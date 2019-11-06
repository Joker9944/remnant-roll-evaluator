package online.vonarx.dictionary;

import online.vonarx.dictionary.implementation.ChainDictionary;
import online.vonarx.dictionary.implementation.PartialKeyMapDictionary;
import online.vonarx.dictionary.implementation.RegExDictionary;

import java.util.Map;

public abstract class TypeDictionaries {

	public static final Dictionary<String, String> bossDictionary = new PartialKeyMapDictionary<>(Map.ofEntries(
		// City
		Map.entry("Quest_MiniBoss_RootBrute", "Gorefist"),
		Map.entry("Quest_MiniBoss_RootWraith", "Shroud"),
		Map.entry("Quest_MiniBoss_RootTumbleweed", "The Mangler"),
		Map.entry("Quest_MiniBoss_Splitter", "Riphide"),
		Map.entry("Quest_MiniBoss_Brabus", "Brabus"),
		Map.entry("Quest_Boss_RootEnt", "The Ent"),
		Map.entry("Quest_Boss_RootDragon", "Singe"),
		// Wasteland
		Map.entry("Quest_Miniboss_Sentinel", "Raze"),
		Map.entry("Quest_Miniboss_SwarmMaster", "Scourge"),
		Map.entry("Quest_Miniboss_HoundMaster", "Maul"),
		Map.entry("Quest_Miniboss_Vyr", "Shade and Shatter"),
		Map.entry("Quest_Boss_WastelandGuardian", "Claviger"),
		Map.entry("Quest_Boss_TheHarrow", "The Harrow"),
		// Swamp
		Map.entry("Quest_MiniBoss_Tyrant", "The Thrall"),
		Map.entry("Quest_MiniBoss_SlimeHulk", "Canker"),
		Map.entry("Quest_Boss_Fatty", "The Unclean One"),
		Map.entry("Quest_Boss_SwampGuardian", "Ixillis"),
		// Jungle
		Map.entry("Quest_MiniBoss_KinCaller", "The Warden"),
		Map.entry("Quest_Miniboss_StormCaller", "Stormcaller"),
		Map.entry("Quest_Miniboss_ImmolatorAndZephyr", "Scald and Sear"),
		Map.entry("Quest_MiniBoss_BlinkFiend", "Onslaught"),
		Map.entry("Quest_Boss_TotemFather", "Totem Father"),
		Map.entry("Quest_Boss_Wolf", "The Ravager")
	));

	public static final Dictionary<String, String> questDictionary = new PartialKeyMapDictionary<>(Map.ofEntries(
		// City
		Map.entry("Quest_OverworldPOI_MudTooth", "Mud Tooth (Merchant)"),
		Map.entry("Quest_OverworldPOI_Settlement", "Settlement (Overworld)"),
		Map.entry("Quest_OverworldPOI_WailingWood", "Wailing Tree (Overworld)"),
		Map.entry("Quest_Siege_RootShrine", "The Root Shrine (Siege)"),
		Map.entry("Quest_Siege_LizAndLiz", "A Tale of Two Liz's (Siege)"),
		Map.entry("Quest_SmallD_MadMerchant", "Twisted Mask Merchant (Merchant)"),
		Map.entry("Quest_SmallD_HuntersHideout", "Hunter's Hideout (Dungeon)"),
		Map.entry("Quest_SmallD_LastWill", "Supply Run (Dungeon)"),
		Map.entry("Quest_SmallD_RootCultist", "Cult of the Root (Dungeon)"),
		// Wasteland
		Map.entry("Quest_OverworldPOI_Monolith", "Monolith (Overworld)"),
		Map.entry("Quest_OverworldPOI_OldManAndConstruct", "Wud (Merchant)"),
		Map.entry("Quest_Siege_TheLostGantry", "The Lost Gantry (Siege)"),
		Map.entry("Quest_SmallD_TheCleanRoom", "The Clean Room (Dungeon)"),
		Map.entry("Quest_SmallD_ArmorVault", "Vault of The Herald (Dungeon)"),
		// Jungle
		Map.entry("Quest_OverworldPOI_Flautist", "Flautist (Overworld)"),
		Map.entry("Quest_OverworldPOI_Ruins", "Ruins (Overworld)"),
		Map.entry("Quest_OverworldPOI_StuckMerchant", "Stuck Merchant (Merchant)"),
		Map.entry("Quest_OverWorldPOI_StuckMerchant", "Stuck Merchant (Merchant)"),
		Map.entry("Quest_Siege_WolfShrine", "Wolf Shrine (Siege)"),
		Map.entry("Quest_Siege_TheRisen", "The Re-Animator (Siege)"),
		Map.entry("Quest_SmallD_DoeShrine", "Red Doe Shrine (Dungeon)")
	));

	public static final Dictionary<String, String> pickupDictionary = new ChainDictionary(
		new PartialKeyMapDictionary<>(Map.ofEntries(
			// Quest items
			Map.entry("Quest_Event_DrifterMask", "Drifter's Mask"),
			Map.entry("Quest_Event_ReggiesRing", "Tarnished Ring"),
			Map.entry("Quest_Event_AcesCoin", "Strange Coin"),
			// Misc
			Map.entry("Quest_Event_Simulacrum", "Simulacrum"),
			Map.entry("Quest_Event_TraitBook", "Tome of Knowledge"),
			// Amulets
			Map.entry("Quest_Event_GunslingersCharm", "Gunslinger's Charm"),
			Map.entry("Quest_Event_CleansingJewel", "Cleansing Jewel"),
			Map.entry("Quest_Event_GalenicCharm", "Galenic Charm"),
			Map.entry("Quest_Event_MendersCharm", "Mender's Charm"),
			Map.entry("Quest_Event_ButchersFetish", "Butcher's Fetish"),
			Map.entry("Quest_Event_StormAmulet", "Storm Amulet"),
			Map.entry("Quest_Event_VengeanceIdol", "Vengeance Idol"),
			Map.entry("Quest_Event_BrutalMark", "Brutal Mark"),
			Map.entry("Quest_Event_RockOfAnguish", "Rock of Anguish"),
			// Rings
			Map.entry("Quest_Event_HeartSeeker", "Heartseeker"),
			Map.entry("Quest_Event_PillarOfStone", "Pillar of Stone"),
			Map.entry("Quest_Event_BandOfStrength", "Band of Strength"),
			Map.entry("Quest_Event_EzlansBand", "Ezlan's Band"),
			Map.entry("Quest_Event_GravityStone", "Gravity Stone"),
			Map.entry("Quest_Event_HuntersHalo", "Hunter's Halo"),
			Map.entry("Quest_Event_JewelOfTheBlackSun", "Jewel of the Black Sun"),
			Map.entry("Quest_Event_DevouringLoop", "Devouring Loop"),
			Map.entry("Quest_Event_HeartOfTheWolf", "Heart of the Wolf"),
			Map.entry("Quest_Event_HuntersBand", "Hunter's Band"),
			Map.entry("Quest_Event_KeepersRing", "Keeper's Ring"),
			Map.entry("Quest_Event_StoneOfBalance", "Stone of Balance"),
			Map.entry("Quest_Event_RingOfEvasion", "Ring of Evasion"),
			Map.entry("Quest_Event_LeechEmber", "Leech Ember"),
			Map.entry("Quest_Event_CelerityStone", "Celerity Stone"),
			Map.entry("Quest_Event_GuardiansRing", "Guardian's Ring"),
			Map.entry("Quest_Event_SageStone", "Sagestone"),
			Map.entry("Quest_Event_MothersRing", "Mother's Ring"),
			Map.entry("Quest_Event_RazorStone", "Razorstone"),
			Map.entry("Quest_Event_BloodFont", "Blood Font")
		)),
		new RegExDictionary("^/Game/World_.+/Quest_Event_(.+)/.*$")
	);
}
