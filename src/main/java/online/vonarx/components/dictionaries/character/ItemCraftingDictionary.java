package online.vonarx.components.dictionaries.character;

import com.google.common.collect.ImmutableMap;
import online.vonarx.constants.KnownActor;
import online.vonarx.dictionary.DictionaryWrapper;
import online.vonarx.dictionary.implementation.MapDictionary;

import javax.inject.Inject;
import java.util.Map;

import static java.util.stream.Collectors.toMap;
import static online.vonarx.constants.KnownActor.*;

public class ItemCraftingDictionary extends DictionaryWrapper<KnownActor, KnownActor> {

	private static final Map<KnownActor, KnownActor> materialToItem = ImmutableMap.<KnownActor, KnownActor>builder()
		// Weapons
		// Hand Guns
		.put(TENTACLE_POD, CURSE_OF_THE_JUNGLE_GOD)
		.put(THERMAL_GEODE, DEFILER)
		.put(HIVESTONE, HIVE_CANNON)
		.put(BLAZING_HEART, SPITFIRE)
		// Swamps of Corsus
		.put(CRYSTALLINE_PLASMA, PRIDE_OF_THE_ISKAL)
		// Long Guns
		.put(UNCLEAN_HEART, DEVASTATOR)
		.put(TOTEM_ANTLER, EYE_OF_THE_STORM)
		.put(VOID_SLIVER, PARTICLE_ACCELERATOR)
		.put(DREAMER_S_MANA, REPULSOR)
		.put(THE_UNDYING_HEART, RUIN)
		.put(SPORE_GLAND, SPOREBLOOM)
		// Melee Weapons
		.put(HAMMERHEAD_S_ORE, BUTCHERS_FLAIL)
		.put(GUARDIAN_TENTACLE, GUARDIAN_AXE)
		.put(TWISTED_HEART, PETRIFIED_MAUL)
		.put(STALKER_S_CLAW, SCAR_OF_THE_JUNGLE_GOD)
		.put(DRAGON_LINKS, SMOLDER)
		.put(TEMPEST_HEARTSTRING, VOICE_OF_THE_TEMPEST)
		.put(STONE_OF_THE_GUARDIAN, WORLD_BREAKER)
		// Subject 2923
		.put(STEEL_OF_AGONY, CHAIN_BLADE)
		// Mods
		.put(SENTINEL_SHARD, BECKON_MOD)
		.put(BLINK_SPEAR_SHARD, BLINK_TOKEN)
		.put(RADIOACTIVE_SKULL, BREATH_OF_THE_DESERT)
		.put(SLIME_VESSEL, CORROSIVE_AURA)
		.put(SHRAPNEL_SHARD, EXPLOSIVE_SHOT)
		.put(DISPLACEMENT_CRYSTAL, FLICKER_CLOAK)
		.put(HOUND_CHOKER, HOWLER_S_IMMUNITY)
		.put(ANCIENT_CORE, IRON_SENTINEL)
		.put(FLESH_BARB, MANTLE_OF_THORNS)
		.put(SHADEWOOD, RATTLE_WEED)
		.put(HOLLOW_SEED, SEED_CALLER)
		.put(KIN_CALLERS_BELL, SONG_OF_SWORDS)
		.put(STORM_CRYSTAL, STORMCALLER_MOD)
		.put(SWARM_TUSK, SWARM)
		.put(BLACK_TEAR, VEIL_OF_THE_BLACK_TEAR)
		.put(ZEPHYR_S_CONDUIT, WILDFIRE_SHOT)
		// Swamps of Corsus
		.put(LUMINOUS_GLAND, RIFT_WALKER)
		.put(BARBED_SINEW, UNSTABLE_QUILLS)
		.put(ISKAL_HUSK, SEEKER)
		// Subject 2923
		.put(JACKAL_S_IVORY, COLD_SPEAR)
		.put(GLACIAL_SCEPTER, BLIZZARD)
		.build();

	@Inject
	public ItemCraftingDictionary() {
		super(MapDictionary.<KnownActor, KnownActor>builder()
			.putAll(materialToItem)
			.putAll(materialToItem.entrySet().stream()
				.collect(toMap(Map.Entry::getValue, Map.Entry::getKey)))
			.build()
		);
	}
}
