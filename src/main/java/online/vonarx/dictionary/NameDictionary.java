package online.vonarx.dictionary;

import online.vonarx.dictionary.implementation.ChainDictionary;
import online.vonarx.dictionary.implementation.PartialKeyMapDictionary;
import online.vonarx.dictionary.implementation.RegExExtractionDictionary;

import java.util.Map;

import static online.vonarx.actor.KnownActorIdentifiers.*;

public abstract class NameDictionary {

	public static final Dictionary<String, String> dictionary = new ChainDictionary<>(
		new PartialKeyMapDictionary<>(Map.ofEntries(
			// City boss
			Map.entry(GOREFIST, "Gorefist"),
			Map.entry(SHROUD, "Shroud"),
			Map.entry(THE_MANGLER, "The Mangler"),
			Map.entry(RIPHIDE, "Riphide"),
			Map.entry(BRABUS, "Brabus"),
			Map.entry(THE_ENT, "The Ent"),
			Map.entry(SINGE, "Singe"),
			// Wasteland boss
			Map.entry(RAZE, "Raze"),
			Map.entry(SCOURGE, "Scourge"),
			Map.entry(MAUL, "Maul"),
			Map.entry(SHADE_AND_SHATTER, "Shade and Shatter"),
			Map.entry(CLAVIGER, "Claviger"),
			Map.entry(THE_HARROW, "The Harrow"),
			// Swamp boss
			Map.entry(THE_THRALL, "The Thrall"),
			Map.entry(CANKER, "Canker"),
			Map.entry(THE_UNDLEAN_ONE, "The Unclean One"),
			Map.entry(IXILLIS, "Ixillis"),
			// Jungle boss
			Map.entry(THE_WARDEN, "The Warden"),
			Map.entry(STORMCALLER, "Stormcaller"),
			Map.entry(SCALD_AND_SEAR, "Scald and Sear"),
			Map.entry(ONSLAUGHT, "Onslaught"),
			Map.entry(TOTEM_FATHER, "Totem Father"),
			Map.entry(THE_RAVAGER, "The Ravager"),
			// City quests
			Map.entry(MUD_TOOTH, "Mud Tooth"),
			Map.entry(SETTLEMENT, "Settlement"),
			Map.entry(WAILING_WOOD, "Wailing Tree"),
			Map.entry(THE_ROOT_SHRINE, "The Root Shrine"),
			Map.entry(A_TALE_OF_TWO_LIZS, "A Tale of Two Liz's"),
			Map.entry(TWISTED_MASK_MERCHANT, "Twisted Mask Merchant"),
			Map.entry(HUNTERS_HIDEOUT, "Hunter's Hideout"),
			Map.entry(SUPPLY_RUN, "Supply Run"),
			Map.entry(CULT_OF_THE_ROOT, "Cult of the Root"),
			// Wasteland quests
			Map.entry(MONOLITH, "Monolith"),
			Map.entry(WUD, "Wud"),
			Map.entry(THE_LOST_GANTRY, "The Lost Gantry"),
			Map.entry(THE_CLEAN_ROOM, "The Clean Room"),
			Map.entry(VAULT_OF_THE_HERALD, "Vault of The Herald"),
			// Jungle quests
			Map.entry(FLAUTIST, "Flautist"),
			Map.entry(RUINS, "Ruins"),
			Map.entry(STUCK_MERCHANT_1, "Stuck Merchant"),
			Map.entry(STUCK_MERCHANT_2, "Stuck Merchant"),
			Map.entry(WOLF_SHRINE, "Wolf Shrine"),
			Map.entry(THE_RISEN, "The Risen"),
			Map.entry(RED_DOE_SHRINE, "Red Doe Shrine"),
			// Quest items
			Map.entry(TARNISHED_RING, "Tarnished Ring"),
			Map.entry(STRANGE_COIN, "Strange Coin"),
			// Misc
			Map.entry(SIMULACRUM, "Simulacrum"),
			Map.entry(TOME_OF_KNOWLEDGE, "Tome of Knowledge"),
			Map.entry(DRIFTERS_MASK, "Drifter's Mask"),
			// Amulets
			Map.entry(GUNSLINGERS_CHARM, "Gunslinger's Charm"),
			Map.entry(CLEANSING_JEWEL, "Cleansing Jewel"),
			Map.entry(GALENIC_CHARM, "Galenic Charm"),
			Map.entry(MENDERS_CHARM, "Mender's Charm"),
			Map.entry(BUTCHERS_FETISH, "Butcher's Fetish"),
			Map.entry(STORM_AMULET, "Storm Amulet"),
			Map.entry(VENGEANCE_IDOL, "Vengeance Idol"),
			Map.entry(BRUTAL_MARK, "Brutal Mark"),
			Map.entry(ROCK_OF_ANGUISH, "Rock of Anguish"),
			Map.entry(LETOS_AMULET, "Leto's Amulet"),
			// Rings
			Map.entry(HEARTSEEKER, "Heartseeker"),
			Map.entry(PILLAR_OF_STONE, "Pillar of Stone"),
			Map.entry(BAND_OF_STRENGTH, "Band of Strength"),
			Map.entry(EZLANS_BAND, "Ezlan's Band"),
			Map.entry(GRAVITY_STONE, "Gravity Stone"),
			Map.entry(HUNTERS_HALO, "Hunter's Halo"),
			Map.entry(JEWEL_OF_THE_BLACK_SUN, "Jewel of the Black Sun"),
			Map.entry(DEVOURING_LOOP, "Devouring Loop"),
			Map.entry(HEART_OF_THE_WOLF, "Heart of the Wolf"),
			Map.entry(HUNTERS_BAND, "Hunter's Band"),
			Map.entry(KEEPERS_RING, "Keeper's Ring"),
			Map.entry(STONE_OF_BALANCE, "Stone of Balance"),
			Map.entry(RING_OF_EVASION, "Ring of Evasion"),
			Map.entry(LEECH_EMBER, "Leech Ember"),
			Map.entry(CELERITY_STONE, "Celerity Stone"),
			Map.entry(GUARDIANS_RING, "Guardian's Ring"),
			Map.entry(SAGESTONE, "Sagestone"),
			Map.entry(MOTHERS_RING, "Mother's Ring"),
			Map.entry(RAZORSTONE, "Razorstone"),
			Map.entry(BLOOD_FONT, "Blood Font"),
						Map.entry(BAND_OF_POLLUX, "Band of Pollux"),
						Map.entry(GUNSLINGERS_RING, "Gunslinger's Ring")
		)),
		new RegExExtractionDictionary("^/Game/World_.+/Quest_Event_(.+)/.*$")
	);
}
