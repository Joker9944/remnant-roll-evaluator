package online.vonarx.dictionary;

import online.vonarx.actor.Type;
import online.vonarx.dictionary.implementation.ChainDictionary;
import online.vonarx.dictionary.implementation.PartialKeySetDictionary;
import online.vonarx.dictionary.implementation.RegExUnitDictionary;

import java.util.Set;

import static online.vonarx.actor.KnownActorIdentifiers.*;

public abstract class TypeDictionary {


	public static final Dictionary<String, Type> dictionary = new ChainDictionary<>(
		new PartialKeySetDictionary<>(Type.BOSS, Set.of(
			BLINK_THIEF
		)),
		new PartialKeySetDictionary<>(Type.MERCHANT, Set.of(
			MUD_TOOTH, TWISTED_MASK_MERCHANT, WUD,
			STUCK_MERCHANT_1, STUCK_MERCHANT_2
		)),
		new PartialKeySetDictionary<>(Type.QUEST_PICKUP, Set.of(
			TARNISHED_RING, STRANGE_COIN
		)),
		new PartialKeySetDictionary<>(Type.AMULET, Set.of(
			GUNSLINGERS_CHARM, CLEANSING_JEWEL,
			GALENIC_CHARM, MENDERS_CHARM,
			BUTCHERS_FETISH, STORM_AMULET,
			VENGEANCE_IDOL, BRUTAL_MARK,
			ROCK_OF_ANGUISH, LETOS_AMULET
		)),
		new PartialKeySetDictionary<>(Type.RING, Set.of(
			HEARTSEEKER, PILLAR_OF_STONE,
			BAND_OF_STRENGTH, EZLANS_BAND,
			GRAVITY_STONE, HUNTERS_HALO,
			JEWEL_OF_THE_BLACK_SUN, DEVOURING_LOOP,
			HEART_OF_THE_WOLF, HUNTERS_BAND,
			KEEPERS_RING, STONE_OF_BALANCE,
			RING_OF_EVASION, LEECH_EMBER,
			CELERITY_STONE, GUARDIANS_RING,
			SAGESTONE, MOTHERS_RING,
			RAZORSTONE, BLOOD_FONT,
						BAND_OF_POLLUX, GUNSLINGERS_RING
		)),
		new RegExUnitDictionary<>("^/Game/World_.+/Quests/Quest_Boss_.*$", Type.BOSS),
		new RegExUnitDictionary<>("^/Game/World_.+/Quests/Quest_MiniBoss_.*$", Type.BOSS),
		new RegExUnitDictionary<>("^/Game/World_.+/Quests/Quest_Miniboss_.*$", Type.BOSS),
		new RegExUnitDictionary<>("^/Game/World_.+/Quests/Quest_OverWorldPOI_.*$", Type.POI),
		new RegExUnitDictionary<>("^/Game/World_.+/Quests/Quest_OverworldPOI_.*$", Type.POI),
		new RegExUnitDictionary<>("^/Game/World_.+/Quests/Quest_Siege_.*$", Type.SIEGE),
		new RegExUnitDictionary<>("^/Game/World_.+/Quests/Quest_SmallD_.*$", Type.DUNGEON),
		new RegExUnitDictionary<>("^/Game/World_.+/Quests/Quest_Event_.*$", Type.PICKUP),
		new RegExUnitDictionary<>("^/Game/World_.+/Quests.*$", Type.QUEST),
		new RegExUnitDictionary<>("^/Game/Campaign_Main/.*$", Type.MAIN_QUEST),
		new RegExUnitDictionary<>("^/Game/.+/Templates/.*$", Type.TEMPLATE),
		new RegExUnitDictionary<>("^.*$", Type.OTHER)
	);
}
