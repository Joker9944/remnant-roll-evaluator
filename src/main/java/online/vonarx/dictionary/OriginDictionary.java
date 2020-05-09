package online.vonarx.dictionary;

import online.vonarx.actor.Origin;
import online.vonarx.dictionary.implementation.ChainDictionary;
import online.vonarx.dictionary.implementation.PartialKeySetDictionary;

import java.util.Set;

import static online.vonarx.actor.KnownActorIdentifiers.*;

public class OriginDictionary {

	public static final Dictionary<String, Origin> dictionary = new ChainDictionary<>(
		new PartialKeySetDictionary<>(Origin.MAIN_GAME, Set.of(
			GOREFIST, SHROUD, THE_MANGLER, BRABUS, THE_ENT, SINGE,
			RAZE, SCOURGE, MAUL, SHADE_AND_SHATTER, CLAVIGER, THE_HARROW,
			THE_THRALL, CANKER, THE_UNCLEAN_ONE, IXILLIS,
			THE_WARDEN, STORMCALLER, SCALD_AND_SEAR, ONSLAUGHT, BLINK_THIEF, TOTEM_FATHER, THE_RAVAGER,
			MUD_TOOTH, SETTLEMENT, WAILING_WOOD, THE_ROOT_SHRINE, A_TALE_OF_TWO_LIZS, TWISTED_MASK_MERCHANT, HUNTERS_HIDEOUT, SUPPLY_RUN, CULT_OF_THE_ROOT,
			MONOLITH, WUD, WUD_FULL, THE_LOST_GANTRY, THE_CLEAN_ROOM, VAULT_OF_THE_HERALD,
			FLAUTIST, RUINS, STUCK_MERCHANT_1, STUCK_MERCHANT_2, STUCK_MERCHANT_FULL, WOLF_SHRINE, THE_RISEN, RED_DOE_SHRINE,
			TARNISHED_RING, STRANGE_COIN,
			SIMULACRUM, TOME_OF_KNOWLEDGE, DRIFTERS_MASK,
			GUNSLINGERS_CHARM, CLEANSING_JEWEL, GALENIC_CHARM, MENDERS_CHARM, BUTCHERS_FETISH, STORM_AMULET, VENGEANCE_IDOL, BRUTAL_MARK, ROCK_OF_ANGUISH, LETOS_AMULET,
			HEARTSEEKER, PILLAR_OF_STONE, BAND_OF_STRENGTH, EZLANS_BAND, GRAVITY_STONE, HUNTERS_HALO, JEWEL_OF_THE_BLACK_SUN, DEVOURING_LOOP, HEART_OF_THE_WOLF, HUNTERS_BAND,
			KEEPERS_RING, STONE_OF_BALANCE, RING_OF_EVASION, LEECH_EMBER, CELERITY_STONE, GUARDIANS_RING, SAGESTONE, MOTHERS_RING, RAZORSTONE, BLOOD_FONT
		)),
		new PartialKeySetDictionary<>(Origin.LETOS_LAB_UPDATE, Set.of(RIPHIDE, RIPHIDE_FULL)),
		new PartialKeySetDictionary<>(Origin.SWAMPS_OF_CORSUS_UPDATE, Set.of(
			// Bosses
			FLICKERING_HORROR, BARBED_TERROR,
			// Amulets
			TALISMAN_OF_ANIMOSITY,
			// Rings
			BAND_OF_POLLUX, GUNSLINGERS_RING,
			PEARL_OF_LUMINESCENCE, COMPULSION_LOOP,
			RING_OF_SHADOWS, BAND_OF_CASTOR,
			AGGRESSORS_BANE, DECEIVERS_BAND,
			RING_OF_ELUSION, STOCKPILE_CIRCLET
		))
	);
}
