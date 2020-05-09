package online.vonarx.dictionary;

import com.google.common.collect.ImmutableMap;
import online.vonarx.dictionary.implementation.ChainDictionary;
import online.vonarx.dictionary.implementation.PartialKeyMapDictionary;
import online.vonarx.dictionary.implementation.RegExExtractionDictionary;

import static online.vonarx.actor.KnownActorIdentifiers.*;

public abstract class NameDictionary {

	public static final Dictionary<String, String> dictionary = new ChainDictionary<>(
		new PartialKeyMapDictionary<>(ImmutableMap.<String, String>builder()
			// City boss
			.put(GOREFIST, "Gorefist")
			.put(SHROUD, "Shroud")
			.put(THE_MANGLER, "The Mangler")
			.put(RIPHIDE, "Riphide")
			.put(BRABUS, "Brabus")
			.put(THE_ENT, "The Ent")
			.put(SINGE, "Singe")
			// Wasteland boss
			.put(RAZE, "Raze")
			.put(SCOURGE, "Scourge")
			.put(MAUL, "Maul")
			.put(SHADE_AND_SHATTER, "Shade and Shatter")
			.put(CLAVIGER, "Claviger")
			.put(THE_HARROW, "The Harrow")
			// Swamp boss
			.put(THE_THRALL, "The Thrall")
			.put(CANKER, "Canker")
			.put(THE_UNCLEAN_ONE, "The Unclean One")
			.put(IXILLIS, "Ixillis")
			// Jungle boss
			.put(THE_WARDEN, "The Warden")
			.put(STORMCALLER, "Stormcaller")
			.put(SCALD_AND_SEAR, "Scald and Sear")
			.put(ONSLAUGHT, "Onslaught")
			.put(TOTEM_FATHER, "Totem Father")
			.put(THE_RAVAGER, "The Ravager")
			// City quests
			.put(MUD_TOOTH, "Mud Tooth")
			.put(SETTLEMENT, "Settlement")
			.put(WAILING_WOOD, "Wailing Tree")
			.put(THE_ROOT_SHRINE, "The Root Shrine")
			.put(A_TALE_OF_TWO_LIZS, "A Tale of Two Liz's")
			.put(TWISTED_MASK_MERCHANT, "Twisted Mask Merchant")
			.put(HUNTERS_HIDEOUT, "Hunter's Hideout")
			.put(SUPPLY_RUN, "Supply Run")
			.put(CULT_OF_THE_ROOT, "Cult of the Root")
			// Wasteland quests
			.put(MONOLITH, "Monolith")
			.put(WUD, "Wud")
			.put(THE_LOST_GANTRY, "The Lost Gantry")
			.put(THE_CLEAN_ROOM, "The Clean Room")
			.put(VAULT_OF_THE_HERALD, "Vault of The Herald")
			// Jungle quests
			.put(FLAUTIST, "Flautist")
			.put(RUINS, "Ruins")
			.put(STUCK_MERCHANT_1, "Stuck Merchant")
			.put(STUCK_MERCHANT_2, "Stuck Merchant")
			.put(WOLF_SHRINE, "Wolf Shrine")
			.put(THE_RISEN, "The Risen")
			.put(RED_DOE_SHRINE, "Red Doe Shrine")
			// Quest items
			.put(TARNISHED_RING, "Tarnished Ring")
			.put(STRANGE_COIN, "Strange Coin")
			// Misc
			.put(SIMULACRUM, "Simulacrum")
			.put(TOME_OF_KNOWLEDGE, "Tome of Knowledge")
			.put(DRIFTERS_MASK, "Drifter's Mask")
			// Amulets
			.put(GUNSLINGERS_CHARM, "Gunslinger's Charm")
			.put(CLEANSING_JEWEL, "Cleansing Jewel")
			.put(GALENIC_CHARM, "Galenic Charm")
			.put(MENDERS_CHARM, "Mender's Charm")
			.put(BUTCHERS_FETISH, "Butcher's Fetish")
			.put(STORM_AMULET, "Storm Amulet")
			.put(VENGEANCE_IDOL, "Vengeance Idol")
			.put(BRUTAL_MARK, "Brutal Mark")
			.put(ROCK_OF_ANGUISH, "Rock of Anguish")
			.put(LETOS_AMULET, "Leto's Amulet")
			// Rings
			.put(HEARTSEEKER, "Heartseeker")
			.put(PILLAR_OF_STONE, "Pillar of Stone")
			.put(BAND_OF_STRENGTH, "Band of Strength")
			.put(EZLANS_BAND, "Ezlan's Band")
			.put(GRAVITY_STONE, "Gravity Stone")
			.put(HUNTERS_HALO, "Hunter's Halo")
			.put(JEWEL_OF_THE_BLACK_SUN, "Jewel of the Black Sun")
			.put(DEVOURING_LOOP, "Devouring Loop")
			.put(HEART_OF_THE_WOLF, "Heart of the Wolf")
			.put(HUNTERS_BAND, "Hunter's Band")
			.put(KEEPERS_RING, "Keeper's Ring")
			.put(STONE_OF_BALANCE, "Stone of Balance")
			.put(RING_OF_EVASION, "Ring of Evasion")
			.put(LEECH_EMBER, "Leech Ember")
			.put(CELERITY_STONE, "Celerity Stone")
			.put(GUARDIANS_RING, "Guardian's Ring")
			.put(SAGESTONE, "Sagestone")
			.put(MOTHERS_RING, "Mother's Ring")
			.put(RAZORSTONE, "Razorstone")
			.put(BLOOD_FONT, "Blood Font")
			// DLC
			// Bosses
			.put(FLICKERING_HORROR, "Flickering Horror")
			// Rings
			.put(BAND_OF_POLLUX, "Band of Pollux")
			.put(GUNSLINGERS_RING, "Gunslinger's Ring")
			.put(PEARL_OF_LUMINESCENCE, "Pearl of Luminescence")
			.put(COMPULSION_LOOP, "Compulsion Loop")
			.put(RING_OF_SHADOWS, "Ring of Shadows")
			.build()),
		new RegExExtractionDictionary("^/Game/World_.+/Quest_Event_(.+)/.*$"));
}
