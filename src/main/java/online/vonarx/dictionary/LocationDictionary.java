package online.vonarx.dictionary;

import online.vonarx.dictionary.implementation.PartialKeyMapDictionary;

import java.util.Map;

public abstract class LocationDictionary {

	public static final Dictionary<String, String> dictionary = new PartialKeyMapDictionary<>(Map.ofEntries(
		// City
		Map.entry("Quest_MiniBoss_RootBrute", "Sunken Passage -> The Grinder"),
		Map.entry("Quest_MiniBoss_RootWraith", "The Hidden Sanctum -> The Tainted Well"),
		Map.entry("Quest_MiniBoss_RootTumbleweed", "The Tangled Pass -> The Artery "),
		Map.entry("Quest_MiniBoss_Splitter", "Research Station Alpha -> ???"),
		Map.entry("Quest_MiniBoss_Brabus", "Cutthroat Channel -> The Depot"),
		Map.entry("Quest_Boss_RootEnt", "The Choking Hallow"),
		Map.entry("Quest_Boss_RootDragon", "The Ash Yard"),
		Map.entry("Quest_Siege_RootShrine", "The Gallows"),
		Map.entry("Quest_Siege_LizAndLiz", "Land's End"),
		Map.entry("Quest_SmallD_MadMerchant", "Junk Town"),
		Map.entry("Quest_SmallD_HuntersHideout", "Hidden Grotto"),
		Map.entry("Quest_SmallD_LastWill", "Sorrow's Field"),
		Map.entry("Quest_SmallD_RootCultist", "Marrow Pass"),
		// Wasteland
		Map.entry("Quest_Miniboss_Sentinel", "Shackled Canyon -> Lair of the Eyeless"),
		Map.entry("Quest_Miniboss_SwarmMaster", "The Iron Rift -> The Hive"),
		Map.entry("Quest_Miniboss_HoundMaster", "The Burrows -> Stalker's Den"),
		Map.entry("Quest_Miniboss_Vyr", "The Ardent Temple -> Hall of the Faithful"),
		Map.entry("Quest_Boss_WastelandGuardian", "Loom of the Black Sun -> The Spindle"),
		Map.entry("Quest_Boss_TheHarrow", "Unnamed -> The Bunker"),
		Map.entry("Quest_Siege_TheLostGantry", "Concourse of the Sun -> The Lost Gantry"),
		Map.entry("Quest_SmallD_TheCleanRoom", "The Purge Hall"),
		Map.entry("Quest_SmallD_ArmorVault", "Vault of Heralds"),
		// Swamp
		Map.entry("Quest_MiniBoss_Tyrant", "The Capillary -> Musk Forge"),
		Map.entry("Quest_MiniBoss_SlimeHulk", "The Drowned Trench -> Mire Hollow"),
		Map.entry("Quest_Boss_Fatty", "The Shack"),
		Map.entry("Quest_Boss_SwampGuardian", "The Grotto"),
		// Jungle
		Map.entry("Quest_MiniBoss_KinCaller", "The Halls of Judgement -> The Ring of Trials"),
		Map.entry("Quest_Miniboss_StormCaller", "Heretic's Nest -> Martyr’s Garden"),
		Map.entry("Quest_Miniboss_ImmolatorAndZephyr", "Withering Village >  Warden's Pulpit"),
		Map.entry("Quest_MiniBoss_BlinkFiend", "Widow's Pass > Noble's Rest"),
		Map.entry("Quest_Boss_TotemFather", "The Tempest Court"),
		Map.entry("Quest_Boss_Wolf", "The Ravager's Haunt"),
		Map.entry("Quest_Siege_WolfShrine", "Temple of the Ravager -> Martyr's Sanctuary"),
		Map.entry("Quest_Siege_TheRisen", "Ahanae's Lament ->  The Radiant Tomb"),
		Map.entry("Quest_SmallD_DoeShrine", "Widow's Vestry")
	));
}
