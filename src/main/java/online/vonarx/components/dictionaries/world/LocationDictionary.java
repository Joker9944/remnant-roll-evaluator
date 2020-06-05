package online.vonarx.components.dictionaries.world;

import online.vonarx.constants.KnownActor;
import online.vonarx.dictionary.DictionaryWrapper;
import online.vonarx.dictionary.implementation.MapDictionary;

import javax.inject.Inject;

import static online.vonarx.constants.KnownActor.*;

public class LocationDictionary extends DictionaryWrapper<KnownActor, String> {

	@Inject
	public LocationDictionary() {
		super(MapDictionary.<KnownActor, String>builder()
			.put(GOREFIST, "Sunken Passage -> The Grinder")
			.put(SHROUD, "The Hidden Sanctum -> The Tainted Well")
			.put(THE_MANGLER, "The Tangled Pass -> The Artery ")
			.put(BRABUS, "Cutthroat Channel -> The Depot")
			.put(THE_ENT, "The Choking Hallow")
			.put(SINGE, "The Ash Yard")
			.put(THE_ROOT_SHRINE, "The Gallows")
			.put(A_TALE_OF_TWO_LIZ_S, "Land's End")
			.put(TWISTED_MASK_MERCHANT, "Junk Town")
			.put(HUNTER_S_HIDEOUT, "Hidden Grotto")
			.put(SUPPLY_RUN, "Sorrow's Field")
			.put(CULT_OF_THE_ROOT, "Marrow Pass")
			// Wasteland
			.put(RAZE, "Shackled Canyon -> Lair of the Eyeless")
			.put(SCOURGE, "The Iron Rift -> The Hive")
			.put(MAUL, "The Burrows -> Stalker's Den")
			.put(SHADE_AND_SHATTER, "The Ardent Temple -> Hall of the Faithful")
			.put(CLAVIGER, "Loom of the Black Sun -> The Spindle")
			.put(THE_HARROW, "Unnamed -> The Bunker")
			.put(THE_LOST_GANTRY, "Concourse of the Sun -> The Lost Gantry")
			.put(THE_CLEAN_ROOM, "The Purge Hall")
			.put(VAULT_OF_THE_HERALD, "Vault of Heralds")
			// Swamp
			.put(THE_THRALL, "The Capillary -> Musk Forge")
			.put(CANKER, "The Drowned Trench -> Mire Hollow")
			.put(THE_UNCLEAN_ONE, "The Shack")
			.put(IXILLIS, "The Grotto")
			.put(FIGHT_WITH_THE_REBELS, "Shrine of The Immortals")
			// Jungle
			.put(THE_WARDEN, "The Halls of Judgement -> The Ring of Trials")
			.put(STORMCALLER_BOSS, "Heretic's Nest -> Martyr's Garden")
			.put(SCALD_AND_SEAR, "Withering Village -> Warden's Pulpit")
			.put(ONSLAUGHT, "Widow's Pass -> Noble's Rest")
			.put(TOTEM_FATHER, "The Tempest Court")
			.put(THE_RAVAGER, "The Ravager's Haunt")
			.put(BLINK_THIEF, "Forgotten Undercroft")
			.put(WOLF_SHRINE, "Temple of the Ravager -> Martyr's Sanctuary")
			.put(THE_RISEN, "Ahanae's Lament -> The Radiant Tomb")
			.put(RED_DOE_SHRINE, "Widow's Vestry")
			// Leto's Lab
			.put(LETO_S_LAB, "Research Station Alpha")
			.put(RIPHIDE, "Research Station Alpha -> The Cursed Station")
			// Swamps of Corsus
			.put(DREAM_EATER, "Hall of Whispers -> Corrupted Sanctum")
			.put(BARBED_TERROR, "Needle Lair -> Throne of Barbs")
			.put(ISKAL_QUEEN, "Iskal Sanctum")
			.put(WISPS, "Circlet Hatchery")
			.put(FETID_POOL, "Fetid Pool")
			.put(A_SMART_BUG, "Strange Pass -> Mar'Gosh's Lair")
			.build()
		);
	}
}
