package online.vonarx.components.dictionaries;

import com.google.common.collect.ImmutableMap;
import online.vonarx.dictionary.implementation.PartialKeyMapDictionary;

import javax.inject.Inject;

import static online.vonarx.constants.KnownActorIdentifiers.*;

public class LocationDictionary extends PartialKeyMapDictionary<String> {

	@Inject
	public LocationDictionary() {
		super(ImmutableMap.<String, String>builder()
			.put(GOREFIST, "Sunken Passage -> The Grinder")
			.put(SHROUD, "The Hidden Sanctum -> The Tainted Well")
			.put(THE_MANGLER, "The Tangled Pass -> The Artery ")
			.put(RIPHIDE, "Research Station Alpha -> The Cursed Station")
			.put(BRABUS, "Cutthroat Channel -> The Depot")
			.put(THE_ENT, "The Choking Hallow")
			.put(SINGE, "The Ash Yard")
			.put(THE_ROOT_SHRINE, "The Gallows")
			.put(A_TALE_OF_TWO_LIZ_S, "Land's End")
			.put(TWISTED_MASK_MERCHANT, "Junk Town")
			.put(HUNTERS_HIDEOUT, "Hidden Grotto")
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
			// Jungle
			.put(THE_WARDEN, "The Halls of Judgement -> The Ring of Trials")
			.put(STORMCALLER, "Heretic's Nest -> Martyr's Garden")
			.put(SCALD_AND_SEAR, "Withering Village -> Warden's Pulpit")
			.put(ONSLAUGHT, "Widow's Pass -> Noble's Rest")
			.put(TOTEM_FATHER, "The Tempest Court")
			.put(THE_RAVAGER, "The Ravager's Haunt")
			.put(BLINK_THIEF, "Forgotten Undercroft")
			.put(WOLF_SHRINE, "Temple of the Ravager -> Martyr's Sanctuary")
			.put(THE_RISEN, "Ahanae's Lament -> The Radiant Tomb")
			.put(RED_DOE_SHRINE, "Widow's Vestry")
			// DLC
			.put(DREAM_EATER, "Hall of Whispers -> Corrupted Sanctum")
			.put(BARBED_TERROR, "Needle Lair -> Throne of Barbs")
			.put(ISKAL_QUEEN, "Iskal Sanctum")
			.put(WISPS, "Circlet Hatchery")
			.put(FETID_POOL, "Fetid Pool")
			.put(A_SMART_BUG, "Strange pass -> Mar'Gosh's Lair")
			.build()
		);
	}
}
