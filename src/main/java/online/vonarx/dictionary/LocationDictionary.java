package online.vonarx.dictionary;

import online.vonarx.dictionary.implementation.PartialKeyMapDictionary;

import java.util.Map;

import static online.vonarx.actor.KnownActorIdentifiers.*;

public abstract class LocationDictionary {

	public static final Dictionary<String, String> dictionary = new PartialKeyMapDictionary<>(Map.ofEntries(
		// City
		Map.entry(GOREFIST, "Sunken Passage -> The Grinder"),
		Map.entry(SHROUD, "The Hidden Sanctum -> The Tainted Well"),
		Map.entry(THE_MANGLER, "The Tangled Pass -> The Artery "),
		Map.entry(RIPHIDE, "Research Station Alpha -> The Cursed Station"),
		Map.entry(BRABUS, "Cutthroat Channel -> The Depot"),
		Map.entry(THE_ENT, "The Choking Hallow"),
		Map.entry(SINGE, "The Ash Yard"),
		Map.entry(THE_ROOT_SHRINE, "The Gallows"),
		Map.entry(A_TALE_OF_TWO_LIZS, "Land's End"),
		Map.entry(TWISTED_MASK_MERCHANT, "Junk Town"),
		Map.entry(HUNTERS_HIDEOUT, "Hidden Grotto"),
		Map.entry(SUPPLY_RUN, "Sorrow's Field"),
		Map.entry(CULT_OF_THE_ROOT, "Marrow Pass"),
		// Wasteland
		Map.entry(RAZE, "Shackled Canyon -> Lair of the Eyeless"),
		Map.entry(SCOURGE, "The Iron Rift -> The Hive"),
		Map.entry(MAUL, "The Burrows -> Stalker's Den"),
		Map.entry(SHADE_AND_SHATTER, "The Ardent Temple -> Hall of the Faithful"),
		Map.entry(CLAVIGER, "Loom of the Black Sun -> The Spindle"),
		Map.entry(THE_HARROW, "Unnamed -> The Bunker"),
		Map.entry(THE_LOST_GANTRY, "Concourse of the Sun -> The Lost Gantry"),
		Map.entry(THE_CLEAN_ROOM, "The Purge Hall"),
		Map.entry(VAULT_OF_THE_HERALD, "Vault of Heralds"),
		// Swamp
		Map.entry(THE_THRALL, "The Capillary -> Musk Forge"),
		Map.entry(CANKER, "The Drowned Trench -> Mire Hollow"),
		Map.entry(THE_UNDLEAN_ONE, "The Shack"),
		Map.entry(IXILLIS, "The Grotto"),
		// Jungle
		Map.entry(THE_WARDEN, "The Halls of Judgement -> The Ring of Trials"),
		Map.entry(STORMCALLER, "Heretic's Nest -> Martyr's Garden"),
		Map.entry(SCALD_AND_SEAR, "Withering Village ->  Warden's Pulpit"),
		Map.entry(ONSLAUGHT, "Widow's Pass -> Noble's Rest"),
		Map.entry(TOTEM_FATHER, "The Tempest Court"),
		Map.entry(THE_RAVAGER, "The Ravager's Haunt"),
		Map.entry(WOLF_SHRINE, "Temple of the Ravager -> Martyr's Sanctuary"),
		Map.entry(THE_RISEN, "Ahanae's Lament ->  The Radiant Tomb"),
		Map.entry(RED_DOE_SHRINE, "Widow's Vestry")
	));
}
