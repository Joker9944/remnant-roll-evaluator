package online.vonarx.components.save.character;

import com.google.common.collect.ImmutableList;
import online.vonarx.components.dictionaries.character.ArchetypeDictionary;
import online.vonarx.components.dictionaries.character.ItemCraftingDictionary;
import online.vonarx.components.dictionaries.character.KnownItemsDictionary;
import online.vonarx.constants.KnownActor;
import online.vonarx.constants.Type;
import online.vonarx.models.AppParameters;
import online.vonarx.models.character.Character;
import online.vonarx.models.character.item.Item;
import online.vonarx.models.character.item.KnownItem;
import online.vonarx.models.character.item.UnknownItem;

import javax.inject.Inject;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;
import static online.vonarx.constants.Type.*;

public class CharacterFactory {

	private final static Pattern CHARACTER_SLOT_PATTERN = Pattern.compile("^.+save_(\\d)\\.sav$");

	private final static Pattern IDENTIFIER_PATTERN = Pattern.compile("/Game/[a-zA-Z0-9/._]+");

	private final static String SAVE_SEGMENT_SEPARATOR = "/Game/_Core/Blueprints/Base/BP_RemnantSaveGameProfile.BP_RemnantSaveGameProfile_C";
	private final static Pattern ARCHETYPE_PATTERN = Pattern.compile("^/Game/_Core/Archetypes/.+$");

	private final int saveSlot;
	private final ArchetypeDictionary archetypeDictionary;
	private final KnownItemsDictionary knownItemsDictionary;
	private final ItemCraftingDictionary itemCraftingDictionary;

	@Inject
	public CharacterFactory(final AppParameters parameters,
	                        final ArchetypeDictionary archetypeDictionary, final KnownItemsDictionary knownItemsDictionary,
	                        final ItemCraftingDictionary itemCraftingDictionary) {
		this.archetypeDictionary = archetypeDictionary;
		this.knownItemsDictionary = knownItemsDictionary;
		this.itemCraftingDictionary = itemCraftingDictionary;
		final var saveFilepath = parameters.saveFilepath().toString();
		final var matcher = CHARACTER_SLOT_PATTERN.matcher(saveFilepath);
		if (matcher.find()) {
			saveSlot = Integer.parseInt(matcher.group(1));
		} else {
			throw new IllegalStateException("Could not find save slot");
		}
	}

	public Character create(final byte[] profileBinary) {
		final var profileString = new String(profileBinary, StandardCharsets.UTF_8);
		final var allIdentifiers = extractIdentifiers(profileString);
		final var segmentSeparatorIndex = allIdentifiers.lastIndexOf(SAVE_SEGMENT_SEPARATOR);
		final var characterSegments = allIdentifiers.subList(1, segmentSeparatorIndex);
		final var characterSegment = extractCharacterSegment(characterSegments);
		return createCharacter(characterSegment);
	}

	private List<String> extractIdentifiers(final String save) {
		return IDENTIFIER_PATTERN.matcher(save).results()
			.map(MatchResult::group)
			.collect(toList());
	}

	private List<String> extractCharacterSegment(final List<String> characterSegments) {
		var segmentStartIndex = -1;
		var segmentIndex = -1;
		for (int i = 0; i < characterSegments.size(); i++) {
			if (ARCHETYPE_PATTERN.matcher(characterSegments.get(i)).matches()) {
				if (segmentIndex == saveSlot)
					return characterSegments.subList(segmentStartIndex, i);
				segmentIndex++;
				segmentStartIndex = i;
			} else if (i == characterSegments.size() - 1 && segmentIndex == saveSlot)
				return characterSegments.subList(segmentStartIndex, i);
		}
		throw new IllegalStateException("Could not find character segment in slot " + saveSlot);
	}

	private Character createCharacter(final List<String> characterIdentifiers) {
		final var archetype = archetypeDictionary.lookup(characterIdentifiers.get(0))
			.orElseThrow(() -> new IllegalStateException("Could not find character archetype"));
		final var itemsBuilder = ImmutableList.<Item>builder();
		characterIdentifiers.forEach(identifier -> {
			final var knownActorOptional = knownItemsDictionary.lookup(identifier);
			knownActorOptional.ifPresentOrElse(knownActor -> itemsBuilder.add(KnownItem.builder()
					.identifier(identifier)
					.knownActor(knownActor)
					.build()),
				() -> itemsBuilder.add(createUnknownItem(identifier)));
		});
		final var items = itemsBuilder.build();
		return Character.builder()
			.archetype(archetype)
			.obtainedArmor(filterActorByTypes(items, HEAD_ARMOUR, BODY_ARMOR, LEG_ARMOR))
			.obtainedSkins(filterActorByTypes(items, SKIN_HEAD_ARMOUR, SKIN_BODY_ARMOR, SKIN_LEG_ARMOR))
			.obtainedWeapons(filterActorByTypes(items, HAND_GUN, LONG_GUN, MELEE_WEAPON))
			.obtainedMods(filterActorByTypes(items, MOD, BUILT_IN_MOD))
			.obtainedAmulets(filterActorByTypes(items, AMULET))
			.obtainedRings(filterActorByTypes(items, RING))
			.obtainedTraits(filterActorByTypes(items, TRAIT))
			.obtainedEmotes(filterActorByTypes(items, EMOTE))
			.obtainedBossResources(filterActorByTypes(items, RESOURCE))
			.unattainedItems(unattainedItems(items))
			.unknownItems(unknownItems(items))
			.build();
	}

	private List<Item> filterActorByTypes(final List<Item> actors, final Type... types) {
		return actors.stream()
			.filter(knownActor -> Arrays.stream(types).anyMatch(type -> knownActor.type().equals(type)))
			.collect(toList());
	}

	private UnknownItem createUnknownItem(final String identifier) {
		if (identifier.contains("/Armor/") && !identifier.endsWith("_Skin_C") && !identifier.endsWith("_PreOrder_C")) {
			if (identifier.contains("_Head_"))
				return createUnknownItem(identifier, HEAD_ARMOUR);
			else if (identifier.contains("_Body_"))
				return createUnknownItem(identifier, BODY_ARMOR);
			else if (identifier.contains("_Legs_"))
				return createUnknownItem(identifier, LEG_ARMOR);
		}
		if (identifier.endsWith("_Skin_C") || identifier.endsWith("_PreOrder_C")) {
			if (identifier.contains("_Head_"))
				return createUnknownItem(identifier, SKIN_HEAD_ARMOUR);
			else if (identifier.contains("_Body_"))
				return createUnknownItem(identifier, SKIN_BODY_ARMOR);
			else if (identifier.contains("_Legs_"))
				return createUnknownItem(identifier, SKIN_BODY_ARMOR);
		}
		if (identifier.contains("/Weapons/") && !identifier.contains("Mod_"))
			return createUnknownItem(identifier, WEAPON);
		if (identifier.contains("/Mod_"))
			return createUnknownItem(identifier, MOD);
		if (identifier.contains("/Trinkets/"))
			return createUnknownItem(identifier, TRINKET);
		if (identifier.contains("/Traits/"))
			return createUnknownItem(identifier, TRAIT);
		if (identifier.contains("/Emotes/"))
			return createUnknownItem(identifier, EMOTE);
		if (identifier.contains("/BossResources/") || identifier.contains("/MiniBossResources/"))
			return createUnknownItem(identifier, RESOURCE);
		return createUnknownItem(identifier, OTHER);
	}

	private UnknownItem createUnknownItem(final String identifier, final Type type) {
		return UnknownItem.builder()
			.identifier(identifier)
			.type(type)
			.build();
	}

	private final static Set<Type> ITEM_TYPES = Set.of(
		HEAD_ARMOUR, BODY_ARMOR, LEG_ARMOR,
		SKIN_HEAD_ARMOUR, SKIN_BODY_ARMOR, SKIN_LEG_ARMOR,
		HAND_GUN, LONG_GUN, MELEE_WEAPON,
		MOD, BUILT_IN_MOD,
		AMULET, RING,
		TRAIT,
		EMOTE,
		RESOURCE
	);

	private List<KnownActor> unattainedItems(final List<Item> attainedItems) {
		return Arrays.stream(KnownActor.values())
			.filter(knownActor -> ITEM_TYPES.stream()
				.anyMatch(type -> knownActor.type().equals(type)))
			.filter(knownActor -> attainedItems.stream()
				.noneMatch(item -> item.equalsToKnownActor(knownActor)))
			.filter(knownActor -> itemCraftingDictionary.lookup(knownActor)
				.map(craftingCounterpart -> attainedItems.stream()
					.noneMatch(item -> item.equalsToKnownActor(craftingCounterpart)))
				.orElse(true))
			.collect(toList());
	}

	private List<UnknownItem> unknownItems(final List<Item> items) {
		return items.stream()
			.filter(item -> item instanceof UnknownItem)
			.map(item -> (UnknownItem) item)
			.collect(toList());
	}
}
