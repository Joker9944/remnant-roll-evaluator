package online.vonarx.models.character;

import com.google.common.collect.ImmutableList;
import lombok.Builder;
import lombok.Data;
import online.vonarx.constants.KnownActor;
import online.vonarx.constants.character.Archetype;
import online.vonarx.models.character.item.Item;

import java.util.List;

@Data
public class Character {

	private final Archetype archetype;
	private final List<Item> obtainedArmor;
	private final List<Item> obtainedSkins;
	private final List<Item> obtainedWeapons;
	private final List<Item> obtainedMods;
	private final List<Item> obtainedAmulets;
	private final List<Item> obtainedRings;
	private final List<Item> obtainedTraits;
	private final List<Item> obtainedEmotes;
	private final List<Item> obtainedBossResources;

	private final List<Item> allObtainedItems;

	private final List<KnownActor> unattainedItems;

	@Builder
	private Character(final Archetype archetype,
	                  final List<Item> obtainedArmor, final List<Item> obtainedSkins,
	                  final List<Item> obtainedWeapons, final List<Item> obtainedMods,
	                  final List<Item> obtainedAmulets, final List<Item> obtainedRings,
	                  final List<Item> obtainedTraits, final List<Item> obtainedEmotes,
	                  final List<Item> obtainedBossResources,
	                  final List<KnownActor> unattainedItems) {
		this.archetype = archetype;
		this.obtainedArmor = obtainedArmor;
		this.obtainedSkins = obtainedSkins;
		this.obtainedWeapons = obtainedWeapons;
		this.obtainedMods = obtainedMods;
		this.obtainedAmulets = obtainedAmulets;
		this.obtainedRings = obtainedRings;
		this.obtainedTraits = obtainedTraits;
		this.obtainedEmotes = obtainedEmotes;
		this.obtainedBossResources = obtainedBossResources;
		this.unattainedItems = unattainedItems;
		allObtainedItems = ImmutableList.<Item>builder()
			.addAll(obtainedArmor)
			.addAll(obtainedSkins)
			.addAll(obtainedWeapons)
			.addAll(obtainedMods)
			.addAll(obtainedAmulets)
			.addAll(obtainedRings)
			.addAll(obtainedTraits)
			.addAll(obtainedEmotes)
			.addAll(obtainedBossResources)
			.build();
	}

	public boolean hasItem(final KnownActor knownActor) {
		return allObtainedItems.stream()
			.anyMatch(actor -> actor.equalsToKnownActor(knownActor));
	}
}
