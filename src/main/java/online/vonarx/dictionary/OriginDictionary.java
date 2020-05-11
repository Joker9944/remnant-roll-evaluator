package online.vonarx.dictionary;

import online.vonarx.actor.Origin;
import online.vonarx.dictionary.implementation.ChainDictionary;
import online.vonarx.dictionary.implementation.PartialKeySetDictionary;
import online.vonarx.dictionary.implementation.RegExKeyMapDictionary;

import java.util.Map;
import java.util.Set;

import static online.vonarx.actor.KnownActorIdentifiers.*;
import static online.vonarx.actor.Origin.*;

public abstract class OriginDictionary {

	public static final Dictionary<String, Origin> dictionary = new ChainDictionary<>(
		new PartialKeySetDictionary<>(MAIN_GAME, Set.of(
			// Bosses
			GOREFIST, SHROUD, THE_MANGLER, BRABUS, THE_ENT, SINGE,
			RAZE, SCOURGE, MAUL, SHADE_AND_SHATTER, CLAVIGER, THE_HARROW,
			THE_THRALL, CANKER, THE_UNCLEAN_ONE, IXILLIS,
			THE_WARDEN, STORMCALLER, SCALD_AND_SEAR, ONSLAUGHT, BLINK_THIEF, TOTEM_FATHER, THE_RAVAGER,
			// Quests
			MUD_TOOTH, SETTLEMENT, WAILING_WOOD, THE_ROOT_SHRINE, A_TALE_OF_TWO_LIZ_S, TWISTED_MASK_MERCHANT, HUNTERS_HIDEOUT, SUPPLY_RUN, CULT_OF_THE_ROOT,
			MONOLITH, WUD, THE_LOST_GANTRY, THE_CLEAN_ROOM, VAULT_OF_THE_HERALD,
			FLAUTIST, RUINS, WOLF_SHRINE, THE_RISEN, RED_DOE_SHRINE,
			// Quest items
			TARNISHED_RING, STRANGE_COIN,
			// Misc items
			SIMULACRUM, TOME_OF_KNOWLEDGE, DRIFTERS_MASK,
			// Amulets
			GUNSLINGERS_CHARM, CLEANSING_JEWEL, GALENIC_CHARM, MENDERS_CHARM, BUTCHERS_FETISH, STORM_AMULET, VENGEANCE_IDOL, BRUTAL_MARK, ROCK_OF_ANGUISH, LETO_S_AMULET,
			// Rings
			HEARTSEEKER, PILLAR_OF_STONE, BAND_OF_STRENGTH, EZLAN_S_BAND, GRAVITY_STONE, HUNTERS_HALO, JEWEL_OF_THE_BLACK_SUN, DEVOURING_LOOP, HEART_OF_THE_WOLF, HUNTERS_BAND,
			KEEPERS_RING, STONE_OF_BALANCE, RING_OF_EVASION, LEECH_EMBER, CELERITY_STONE, GUARDIANS_RING, SAGESTONE, MOTHERS_RING, RAZORSTONE, BLOOD_FONT
		)),
		new RegExKeyMapDictionary<>(Map.of(STUCK_MERCHANT_REG_EX, MAIN_GAME)),
		new PartialKeySetDictionary<>(LETO_S_LAB_UPDATE, Set.of(RIPHIDE)),
		new PartialKeySetDictionary<>(SWAMPS_OF_CORSUS_UPDATE, Set.of(
			// Bosses
			DREAM_EATER, BARBED_TERROR,
			ISKAL_QUEEN,
			// Quests
			WISPS, ABANDONED_THRONE,
			GRAVEYARD_ELF, FETID_POOL,
			A_SMART_BUG,
			// Amulets
			TALISMAN_OF_ANIMOSITY,
			// Rings
			BAND_OF_POLLUX, GUNSLINGERS_RING,
			PEARL_OF_LUMINESCENCE, COMPULSION_LOOP,
			RING_OF_SHADOWS, BAND_OF_CASTOR,
			AGGRESSORS_BANE, DECEIVERS_BAND,
			RING_OF_ELUSION, STOCKPILE_CIRCLET
		)),
		new RegExKeyMapDictionary<>(Map.of(CRYPTOLITH_REG_EX, SWAMPS_OF_CORSUS_UPDATE))
	);
}
