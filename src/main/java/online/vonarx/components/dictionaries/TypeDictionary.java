package online.vonarx.components.dictionaries;

import online.vonarx.constants.Type;
import online.vonarx.dictionary.DictionaryWrapper;
import online.vonarx.dictionary.implementation.ChainDictionary;
import online.vonarx.dictionary.implementation.PartialKeySetDictionary;
import online.vonarx.dictionary.implementation.RegExKeyMapDictionary;

import javax.inject.Inject;

import static online.vonarx.constants.KnownActorIdentifiers.*;
import static online.vonarx.constants.Type.*;

public class TypeDictionary extends DictionaryWrapper<String, Type> {

	@Inject
	public TypeDictionary() {
		super(ChainDictionary.<String, Type>builder()
			.addDictionary(PartialKeySetDictionary.builder(BOSS)
				.add(BLINK_THIEF)
				// DLC
				.add(ISKAL_QUEEN)
				.build())
			.addDictionary(PartialKeySetDictionary.builder(MERCHANT)
				.add(MUD_TOOTH)
				.add(TWISTED_MASK_MERCHANT)
				.add(WUD)
				// DLC
				.add(GRAVEYARD_ELF)
				.build())
			.addDictionary(RegExKeyMapDictionary.<Type>builder()
				.put(STUCK_MERCHANT_REG_EX, MERCHANT)
				.build())
			.addDictionary(PartialKeySetDictionary.builder(QUEST_PICKUP)
				.add(TARNISHED_RING)
				.add(STRANGE_COIN)
				.build())
			.addDictionary(PartialKeySetDictionary.builder(AMULET)
				.add(GUNSLINGERS_CHARM, CLEANSING_JEWEL,
					GALENIC_CHARM, MENDERS_CHARM,
					BUTCHERS_FETISH, STORM_AMULET,
					VENGEANCE_IDOL, BRUTAL_MARK,
					ROCK_OF_ANGUISH, LETO_S_AMULET,
					// DLC
					TALISMAN_OF_ANIMOSITY)
				.build())
			.addDictionary(PartialKeySetDictionary.builder(RING)
				.add(HEARTSEEKER, PILLAR_OF_STONE,
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
					RING_OF_ELUSION, STOCKPILE_CIRCLET)
				.build())
			.addDictionary(RegExKeyMapDictionary.<Type>builder()
				.put("^/Game/World_.+/Quests/Quest_Boss_.*$", BOSS)
				.put("^/Game/World_.+/Quests/Quest_Mini.oss_.*$", BOSS)
				.put("^/Game/World_.+/Quests/Quest_Over.orldPOI_.*$", POINT_OF_INTEREST)
				.put("^/Game/World_.+/Quests/Quest_Siege_.*$", SIEGE)
				.put("^/Game/World_.+/Quests/Quest_SmallD_.*$", DUNGEON)
				.put("^/Game/World_.+/Quests/Quest_Event_.*$", PICKUP)
				.put("^/Game/Campaign_Main/.*$", MAIN_QUEST)
				.put("^/Game/.+/Templates/.*$", TEMPLATE)
				.build())
			.addDictionary(RegExKeyMapDictionary.<Type>builder()
				.put("^/Game/World_.+/Quests.*$", QUEST)
				.build())
			.build()
		);
	}
}
