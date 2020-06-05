package online.vonarx.save;

import com.google.common.collect.ImmutableList;
import online.vonarx.components.dictionaries.character.ItemCraftingDictionary;
import online.vonarx.components.dictionaries.world.ZoneDictionary;
import online.vonarx.components.save.world.EncounterFactory;
import online.vonarx.constants.world.Mode;
import online.vonarx.constants.world.Zone;
import online.vonarx.dictionary.Dictionary;
import online.vonarx.dictionary.implementation.MapDictionary;
import online.vonarx.models.character.Character;
import online.vonarx.models.world.Encounter;
import online.vonarx.models.world.WorldSave;
import online.vonarx.models.world.rewards.RewardLine;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

public abstract class ModeFactory {

	private static final Pattern ACTOR_IDENTIFIER_PATTERN = Pattern.compile("/Game/[a-zA-Z0-9/._]+");
	private static final Pattern IS_TEMPLATE_PATTERN = Pattern.compile("^/Game/World_.+/Templates/.*$");

	private final EncounterFactory encounterFactory;
	private final ZoneDictionary zoneDictionary;
	private final ItemCraftingDictionary itemCraftingDictionary;

	public ModeFactory(final EncounterFactory encounterFactory, final ZoneDictionary zoneDictionary,
	                   final ItemCraftingDictionary itemCraftingDictionary) {
		this.encounterFactory = encounterFactory;
		this.zoneDictionary = zoneDictionary;
		this.itemCraftingDictionary = itemCraftingDictionary;
	}

	public WorldSave create(final byte[] saveBinary, final Character character) {
		final var saveString = new String(saveBinary, StandardCharsets.UTF_8);
		final var identifiers = extractIdentifiers(saveString);
		final var extractedIdentifiers = extractIdentifiers(identifiers);
		final var encounters = mapIdentifiersToEncounters(extractedIdentifiers);
		return WorldSave.builder()
			.mode(mode())
			.character(character)
			.encounters(encounters)
			.unattainedRewardsDictionary(buildUnattainedRewardsDictionary(encounters, character))
			.build();
	}

	private List<String> extractIdentifiers(final String save) {
		return ACTOR_IDENTIFIER_PATTERN.matcher(save).results()
			.map(MatchResult::group)
			.collect(toList());
	}

	protected abstract List<String> extractIdentifiers(final List<String> identifiers);

	protected abstract Mode mode();

	private List<Encounter> mapIdentifiersToEncounters(final List<String> identifiers) {
		final var mappedEncounters = new ArrayList<Encounter>();
		var currentZone = Zone.NONE;
		for (final String identifier : identifiers) {
			if (IS_TEMPLATE_PATTERN.matcher(identifier).matches())
				currentZone = zoneDictionary.lookup(identifier)
					.orElse(Zone.NONE);
			mappedEncounters.add(encounterFactory.create(currentZone, identifier));
		}
		return mappedEncounters;
	}

	private Dictionary<Encounter, List<RewardLine>> buildUnattainedRewardsDictionary(final List<Encounter> encounters, final Character character) {
		final var dictionaryBuilder = MapDictionary.<Encounter, List<RewardLine>>builder();
		encounters.forEach(knownEncounter -> {
			final var unattainedItemsBuilder = ImmutableList.<RewardLine>builder();
			knownEncounter.rewardLines().forEach(rewardLine -> {
				rewardLine.rewards().forEach(reward -> {
					if (character.hasItem(reward))
						rewardLine.removeReward(reward);
					itemCraftingDictionary.lookup(reward).ifPresent(craftingCounterpart -> {
						if (character.hasItem(craftingCounterpart))
							rewardLine.removeReward(reward);
					});
				});
				if (rewardLine.isRewardsPresent())
					unattainedItemsBuilder.add(rewardLine);
			});
			final var unattainedItems = unattainedItemsBuilder.build();
			if (unattainedItems.size() > 0)
				dictionaryBuilder.put(knownEncounter, unattainedItems);
		});
		return dictionaryBuilder.build();
	}
}
