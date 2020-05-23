package online.vonarx.components.dictionaries;

import online.vonarx.constants.Type;
import online.vonarx.dictionary.implementation.ChainDictionary;
import online.vonarx.dictionary.implementation.PartialKeySetDictionary;
import online.vonarx.dictionary.implementation.RegExKeyMapDictionary;

import javax.inject.Inject;
import java.util.Map;
import java.util.Set;

import static online.vonarx.constants.KnownActorIdentifiers.*;
import static online.vonarx.constants.Type.*;

public class TypeDictionary extends ChainDictionary<String, Type> {

	@Inject
	public TypeDictionary() {
		super(
			new PartialKeySetDictionary<>(BOSS, Set.of(
				BLINK_THIEF,
				// DLC
				ISKAL_QUEEN
			)),
			new PartialKeySetDictionary<>(MERCHANT, Set.of(
				MUD_TOOTH, TWISTED_MASK_MERCHANT, WUD,
				// DLC
				GRAVEYARD_ELF
			)),
			new RegExKeyMapDictionary<>(Map.of(STUCK_MERCHANT_REG_EX, MERCHANT)),
			new PartialKeySetDictionary<>(QUEST_PICKUP, Set.of(
				TARNISHED_RING, STRANGE_COIN
			)),
			new PartialKeySetDictionary<>(AMULET, Set.of(
				GUNSLINGERS_CHARM, CLEANSING_JEWEL,
				GALENIC_CHARM, MENDERS_CHARM,
				BUTCHERS_FETISH, STORM_AMULET,
				VENGEANCE_IDOL, BRUTAL_MARK,
				ROCK_OF_ANGUISH, LETO_S_AMULET,
				// DLC
				TALISMAN_OF_ANIMOSITY
			)),
			new PartialKeySetDictionary<>(RING, Set.of(
				HEARTSEEKER, PILLAR_OF_STONE,
				BAND_OF_STRENGTH, EZLAN_S_BAND,
				GRAVITY_STONE, HUNTERS_HALO,
				JEWEL_OF_THE_BLACK_SUN, DEVOURING_LOOP,
				HEART_OF_THE_WOLF, HUNTERS_BAND,
				KEEPERS_RING, STONE_OF_BALANCE,
				RING_OF_EVASION, LEECH_EMBER,
				CELERITY_STONE, GUARDIANS_RING,
				SAGESTONE, MOTHERS_RING,
				RAZORSTONE, BLOOD_FONT,
				// DLC
				BAND_OF_POLLUX, GUNSLINGERS_RING,
				PEARL_OF_LUMINESCENCE, COMPULSION_LOOP,
				RING_OF_SHADOWS, BAND_OF_CASTOR,
				AGGRESSORS_BANE, DECEIVERS_BAND,
				RING_OF_ELUSION, STOCKPILE_CIRCLET
			)),
			new RegExKeyMapDictionary<>(Map.of(
				"^/Game/World_.+/Quests/Quest_Boss_.*$", BOSS,
				"^/Game/World_.+/Quests/Quest_Mini.oss_.*$", BOSS,
				"^/Game/World_.+/Quests/Quest_Over.orldPOI_.*$", POINT_OF_INTEREST,
				"^/Game/World_.+/Quests/Quest_Siege_.*$", SIEGE,
				"^/Game/World_.+/Quests/Quest_SmallD_.*$", DUNGEON,
				"^/Game/World_.+/Quests/Quest_Event_.*$", PICKUP,
				"^/Game/Campaign_Main/.*$", MAIN_QUEST,
				"^/Game/.+/Templates/.*$", TEMPLATE
			)),
			new RegExKeyMapDictionary<>(Map.of("^/Game/World_.+/Quests.*$", QUEST))
		);
	}
}
