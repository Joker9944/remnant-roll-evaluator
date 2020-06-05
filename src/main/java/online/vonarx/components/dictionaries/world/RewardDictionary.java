package online.vonarx.components.dictionaries.world;

import online.vonarx.components.save.world.RewardFactory;
import online.vonarx.constants.KnownActor;
import online.vonarx.dictionary.DictionaryWrapper;
import online.vonarx.dictionary.implementation.ChainDictionary;
import online.vonarx.dictionary.implementation.MapDictionary;
import online.vonarx.models.world.rewards.RewardLine;

import javax.inject.Inject;
import java.util.List;

import static java.util.List.of;
import static online.vonarx.constants.KnownActor.*;

public class RewardDictionary extends DictionaryWrapper<KnownActor, List<RewardLine>> {

	@Inject
	public RewardDictionary(final RewardFactory rf) {
		super(ChainDictionary.<KnownActor, List<RewardLine>>builder()
			// Bosses
			.addDictionary(MapDictionary.<KnownActor, List<RewardLine>>builder()
				// Earth
				.put(GOREFIST, of(rf.reward(FLESH_BARB)))
				.put(SHROUD, of(rf.reward(SHADEWOOD)))
				.put(THE_MANGLER, of(rf.reward(HOLLOW_SEED)))
				.put(BRABUS, of(
					rf.optionalReward(SHRAPNEL_SHARD),
					rf.inclusiveOptionalReward(BANDIT_S_MASK, BANDIT_JACKET, BANDIT_TROUSERS),
					rf.optionalReward(COLD_AS_ICE)))
				.put(THE_ENT, of(
					rf.inclusiveReward(QUICK_HANDS, CHEER),
					rf.exclusiveReward(SPORE_GLAND, TWISTED_HEART),
					rf.hardcoreReward(PROVISIONER_RING)))
				.put(SINGE, of(
					rf.inclusiveReward(QUICK_HANDS, BECKON_EMOTE),
					rf.exclusiveReward(BLAZING_HEART, DRAGON_LINKS),
					rf.hardcoreReward(PROVISIONER_RING)))
				// Wasteland
				.put(RAZE, of(rf.reward(SENTINEL_SHARD)))
				.put(SCOURGE, of(rf.reward(RADIOACTIVE_SKULL)))
				.put(MAUL, of(rf.reward(HOUND_CHOKER)))
				.put(SHADE_AND_SHATTER, of(rf.reward(BLACK_TEAR)))
				.put(CLAVIGER, of(
					rf.inclusiveReward(RECOVERY, LAUGH),
					rf.exclusiveReward(STONE_OF_THE_GUARDIAN, VOID_SLIVER),
					rf.hardcoreReward(AKARI_WAR_BAND)))
				.put(THE_HARROW, of(
					rf.inclusiveReward(RECOVERY, FAIL),
					rf.exclusiveReward(THERMAL_GEODE, LOST_HARPOON),
					rf.hardcoreReward(AKARI_WAR_BAND)))
				.put(UNDYING_KING, of(
					rf.optionalReward(RIVEN),
					rf.inclusiveOptionalReward(THE_UNDYING_HEART, KINGSLAYER, GRAVEDIGGER)))
				// Swamp
				.put(THE_THRALL, of(rf.inclusiveReward(SWARM_TUSK, CATALYST)))
				.put(CANKER, of(rf.inclusiveReward(SLIME_VESSEL, CATALYST)))
				.put(THE_UNCLEAN_ONE, of(
					rf.inclusiveReward(GLUTTON, EXHAUSTED),
					rf.exclusiveReward(UNCLEAN_HEART, HAMMERHEAD_S_ORE)))
				.put(IXILLIS, of(
					rf.reward(CONFUSED),
					rf.exclusiveReward(HIVESTONE, GUARDIAN_TENTACLE),
					rf.hardcoreReward(EMPOWERING_LOOP)))
				// Jungle
				.put(THE_WARDEN, of(rf.reward(KIN_CALLERS_BELL)))
				.put(STORMCALLER_BOSS, of(rf.reward(STORM_CRYSTAL)))
				.put(SCALD_AND_SEAR, of(rf.reward(ZEPHYR_S_CONDUIT)))
				.put(ONSLAUGHT, of(rf.reward(BLINK_SPEAR_SHARD)))
				.put(BLINK_THIEF, of(rf.reward(RICOCHET_RIFLE)))
				.put(ROOT_HORROR, of(rf.reward(GUARDIAN_S_BLESSING)))
				.put(TOTEM_FATHER, of(
					rf.inclusiveReward(ARCANE_STRIKE, TEA_TIME),
					rf.exclusiveReward(TOTEM_ANTLER, TEMPEST_HEARTSTRING),
					rf.hardcoreReward(RING_OF_SUPREMACY)))
				.put(THE_RAVAGER, of(
					rf.inclusiveReward(ARCANE_STRIKE, FREEZE_FRAME),
					rf.exclusiveReward(TENTACLE_POD, STALKER_S_CLAW),
					rf.hardcoreReward(RING_OF_SUPREMACY)))
				// Leto's Lab
				.put(RIPHIDE, of(rf.reward(DISPLACEMENT_CRYSTAL)))
				// Swamps of Corsus
				.put(DREAM_EATER, of(rf.reward(LUMINOUS_GLAND)))
				.put(BARBED_TERROR, of(rf.reward(BARBED_SINEW)))
				.put(ISKAL_QUEEN, of(
					rf.reward(FOOTWORK),
					rf.exclusiveReward(CRYSTALLINE_PLASMA, ISKAL_HUSK)))
				.build())
			// Quests
			.addDictionary(MapDictionary.<KnownActor, List<RewardLine>>builder()
				// Earth
				.put(MUD_TOOTH, of(rf.reward(POCKET_WATCH)))
				.put(WAILING_WOOD, of(rf.exclusiveReward(TWISTED_IDOL, BARK_SKIN)))
				.put(THE_ROOT_SHRINE, of(rf.inclusiveReward(TWISTED_HOOD, TWISTED_CAGE, TWISTED_TASSETS)))
				.put(A_TALE_OF_TWO_LIZ_S, of(
					rf.reward(WARRIOR),
					rf.optionalReward(CHICAGO_TYPEWRITER)))
				.put(TWISTED_MASK_MERCHANT, of(rf.optionalReward(TWISTED_MASK)))
				.put(HUNTER_S_HIDEOUT, of(rf.inclusiveReward(HUNTING_PISTOL, SHADOW_WALKER)))
				.put(SUPPLY_RUN, of(rf.inclusiveReward(ASSAULT_RIFLE, SPIRIT)))
				.put(CULT_OF_THE_ROOT, of(rf.exclusiveReward(BRAIDED_THORNS, ROOT_CIRCLET)))
				.put(THE_ROOT_MOTHER, of(rf.reward(MOTHER_S_BLESSING)))
				// Wasteland
				.put(MONOLITH, of(rf.merchandise(VOID_SKULL, VOID_CARAPACE, VOID_GREAVES)))
				.put(WUD, of(rf.merchandise(OSSEOUS_HELM, OSSEOUS_HUSK, OSSEOUS_KILT, MENDER_S_CHARM, JEWEL_OF_THE_BLACK_SUN)))
				.put(THE_LOST_GANTRY, of(rf.reward(BEAM_RIFLE)))
				.put(THE_CLEAN_ROOM, of(rf.reward(WASTELANDER_FLAIL)))
				.put(VAULT_OF_THE_HERALD, of(
					rf.optionalReward(AKARI_MASK),
					rf.optionalReward(AKARI_GARB),
					rf.optionalReward(AKARI_LEGGINGS)))
				// Jungle
				.put(FLAUTIST, of(
					rf.optionalReward(HEART_OF_THE_WOLF),
					rf.optionalReward(SWIFTNESS)))
				.put(WOLF_SHRINE, of(rf.inclusiveReward(ELDER_HEADDRESS, ELDER_RAIMENT, ELDER_LEGGINGS)))
				.put(THE_RISEN, of(rf.reward(SOUL_ANCHOR)))
				.put(RED_DOE_SHRINE, of(
					rf.optionalReward(SCAVENGER_S_BAUBLE),
					rf.optionalReward(SWIFTNESS)))
				.put(STUCK_MERCHANT, of(rf.merchandise(SPEAR, RADIANT_PROTECTOR, RADIANT_GREAVES, GUARDIAN_S_RING)))
				.put(GUARDIAN_SHRINE, of(rf.reward(RADIANT_VISAGE)))
				// Leto's Lab
				.put(LETO_S_LAB, of(rf.inclusiveReward(LETO_S_HELMET, LETO_S_ARMOR, LETO_S_LEGGINGS)))
				// Swamps of Corsus
				.put(ABANDONED_THRONE, of(/* Shiny carapace */))
				.put(GRAVEYARD_ELF, of(
					rf.merchandise(GRIM_COIL),
					rf.inclusiveOptionalReward(POTENCY, RING_OF_THE_UNCLEAN)))
				.put(A_SMART_BUG, of(
					rf.merchandise(CARAPACE_GREAT_HELM, CARAPACE_SHELL, CARAPACE_GREAVES),
					rf.optionalReward(LUMINESCENT),
					rf.optionalReward(GIFT_OF_THE_ISKAL)))
				.put(FETID_POOL, of(
					rf.reward(RUSTED_AMULET),
					rf.optionalReward(HERO_S_RING),
					rf.optionalReward(FORTIFICATION)))
				.put(WISPS, of(
					rf.reward(SOUL_ANCHOR),
					rf.optionalReward(EVOCATION)))
				.put(CRYPTOLITH, of(
					rf.optionalReward(CONCENTRATION),
					rf.optionalReward(BLOOD_BOND),
					rf.inclusiveOptionalReward(LABYRINTH_HELM, LABYRINTH_ARMOR, LABYRINTH_GREAVES)))
				.build())
			// Items
			.addDictionary(MapDictionary.<KnownActor, List<RewardLine>>builder()
				// Quest Items
				.put(TARNISHED_RING, of(rf.reward(SCAVENGER)))
				.put(STRANGE_COIN, of(rf.reward(MAGNUM_REVOLVER)))
				// Armor
				.put(DRIFTER_S_MASK, of(rf.reward(DRIFTER_S_MASK)))
				// Amulets
				.put(GUNSLINGER_S_CHARM, of(rf.reward(GUNSLINGER_S_CHARM)))
				.put(CLEANSING_JEWEL, of(rf.reward(CLEANSING_JEWEL)))
				.put(GALENIC_CHARM, of(rf.reward(GALENIC_CHARM)))
				.put(MENDER_S_CHARM, of(rf.reward(MENDER_S_CHARM)))
				.put(BUTCHER_S_FETISH, of(rf.reward(BUTCHER_S_FETISH)))
				.put(STORM_AMULET, of(rf.reward(STORM_AMULET)))
				.put(VENGEANCE_IDOL, of(rf.reward(VENGEANCE_IDOL)))
				.put(BRUTAL_MARK, of(rf.reward(BRUTAL_MARK)))
				.put(ROCK_OF_ANGUISH, of(rf.reward(ROCK_OF_ANGUISH)))
				.put(LETO_S_AMULET, of(rf.reward(LETO_S_AMULET)))
				// Swamps of Corsus
				.put(TALISMAN_OF_ANIMOSITY, of(rf.reward(TALISMAN_OF_ANIMOSITY)))
				// Rings
				.put(HEARTSEEKER, of(rf.reward(HEARTSEEKER)))
				.put(PILLAR_OF_STONE, of(rf.reward(PILLAR_OF_STONE)))
				.put(BAND_OF_STRENGTH, of(rf.reward(BAND_OF_STRENGTH)))
				.put(EZLAN_S_BAND, of(rf.reward(EZLAN_S_BAND)))
				.put(GRAVITY_STONE, of(rf.reward(GRAVITY_STONE)))
				.put(HUNTER_S_HALO, of(rf.reward(HUNTER_S_HALO)))
				.put(JEWEL_OF_THE_BLACK_SUN, of(rf.reward(JEWEL_OF_THE_BLACK_SUN)))
				.put(DEVOURING_LOOP, of(rf.reward(DEVOURING_LOOP)))
				.put(HEART_OF_THE_WOLF, of(rf.reward(HEART_OF_THE_WOLF)))
				.put(HUNTER_S_BAND, of(rf.reward(HUNTER_S_BAND)))
				.put(KEEPER_S_RING, of(rf.reward(KEEPER_S_RING)))
				.put(STONE_OF_BALANCE, of(rf.reward(STONE_OF_BALANCE)))
				.put(RING_OF_EVASION, of(rf.reward(RING_OF_EVASION)))
				.put(LEECH_EMBER, of(rf.reward(LEECH_EMBER)))
				.put(CELERITY_STONE, of(rf.reward(CELERITY_STONE)))
				.put(GUARDIAN_S_RING, of(rf.reward(GUARDIAN_S_RING)))
				.put(SAGESTONE, of(rf.reward(SAGESTONE)))
				.put(MOTHER_S_RING, of(rf.reward(MOTHER_S_RING)))
				.put(RAZORSTONE, of(rf.reward(RAZORSTONE)))
				.put(BLOOD_FONT, of(rf.reward(BLOOD_FONT)))
				// Swamps of Corsus
				.put(BAND_OF_POLLUX, of(rf.reward(BAND_OF_POLLUX)))
				.put(GUNSLINGER_S_RING, of(rf.reward(GUNSLINGER_S_RING)))
				.put(COMPULSION_LOOP, of(rf.reward(COMPULSION_LOOP)))
				.put(RING_OF_SHADOWS, of(rf.reward(RING_OF_SHADOWS)))
				.put(BAND_OF_CASTOR, of(rf.reward(BAND_OF_CASTOR)))
				.put(AGGRESSOR_S_BANE, of(rf.reward(AGGRESSOR_S_BANE)))
				.put(DECEIVER_S_BAND, of(rf.reward(DECEIVER_S_BAND)))
				.put(RING_OF_ELUSION, of(rf.reward(RING_OF_ELUSION)))
				.put(STOCKPILE_CIRCLET, of(rf.reward(STOCKPILE_CIRCLET)))
				.build())
			.build()
		);
	}
}
