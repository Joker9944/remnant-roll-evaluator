package online.vonarx.dictionary;

import online.vonarx.dictionary.implementation.ChainDictionary;
import online.vonarx.dictionary.implementation.PartialKeyMapDictionary;
import online.vonarx.dictionary.implementation.RegExDictionary;

import java.util.Map;

public abstract class TypeDictionaries {

	public static final Dictionary<String, String> bossDictionary = new PartialKeyMapDictionary<>(Map.ofEntries(
		// City bosses
		Map.entry("Quest_MiniBoss_RootBrute", "Gorefist"),
		Map.entry("Quest_MiniBoss_RootWraith", "Shroud"),
		Map.entry("Quest_MiniBoss_RootTumbleweed", "The Mangler"),
		Map.entry("Quest_MiniBoss_Splitter", "Riphide"),
		Map.entry("Brabus", "Brabus"),
		Map.entry("Quest_Boss_RootEnt", "The Ent"),
		Map.entry("Quest_Boss_RootDragon", "Singe"),
		// Wasteland bosses
		Map.entry("Quest_Miniboss_Sentinel", "Raze"),
		Map.entry("Quest_Miniboss_SwarmMaster", "Scourge"),
		Map.entry("Quest_Miniboss_HoundMaster", "Maul"),
		// Ancient Construct is based on Wud quest
		Map.entry("Quest_Miniboss_Vyr", "Shade and Shatter"),
		// Undying King is based on Undying NPC
		Map.entry("Quest_Boss_WastelandGuardian", "Claviger"),
		Map.entry("Quest_Boss_TheHarrow", "The Harrow"),
		// Swamp bosses
		Map.entry("Quest_MiniBoss_Tyrant", "The Thrall"),
		Map.entry("Quest_MiniBoss_SlimeHulk", "Canker"),
		Map.entry("Quest_Boss_Fatty", "The Unclean One"),
		Map.entry("Quest_Boss_SwampGuardian", "Ixillis"),
		// Jungle bosses
		Map.entry("Quest_MiniBoss_KinCaller", "The Warden"),
		Map.entry("Quest_Miniboss_StormCaller", "Stormcaller"),
		Map.entry("Quest_Miniboss_ImmolatorAndZephyr", "Scald and Sear"),
		Map.entry("Quest_MiniBoss_BlinkFiend", "Onslaught"),
		// Root Horror based on Stuck Merchant quest
		// Blink Thief is based on BlinkThief Quest
		Map.entry("Quest_Boss_TotemFather", "Totem Father"),
		Map.entry("Quest_Boss_Wolf", "The Ravager")
	));

	public static final Dictionary<String, String> questDictionary = new PartialKeyMapDictionary<>(Map.ofEntries(
		// City quests
		Map.entry("Quest_Siege_RootShrine", "The Root Shrine (Siege)"),
		Map.entry("Quest_OverworldPOI_MudTooth", "Mud Tooth (Merchant)"),
		Map.entry("Quest_SmallD_MadMerchant", "Twisted Mask Merchant (Merchant)"),
		Map.entry("Quest_OverworldPOI_Settlement", "Settlement (Overworld)"),
		Map.entry("Quest_SmallD_HuntersHideout", "Hunter's Hideout (Dungeon)"),
		Map.entry("Quest_SmallD_LastWill", "Supply Run (Dungeon)"),
		Map.entry("Quest_OverworldPOI_WailingWood", "Wailing Tree (Overworld)"),
		Map.entry("Quest_Siege_LizAndLiz", "A Tale of Two Liz's (Siege)"),
		Map.entry("Quest_SmallD_RootCultist", "Cult of the Root (Dungeon)"),
		// Wasteland quests
		Map.entry("Quest_OverworldPOI_Monolith", "Monolith (Overworld)"),
		Map.entry("Quest_OverworldPOI_OldManAndConstruct", "Wud (Merchant)"),
		Map.entry("Quest_Siege_TheLostGantry", "The Lost Gantry (Siege)"),
		Map.entry("Quest_SmallD_TheCleanRoom", "The Clean Room (Dungeon)"),
		Map.entry("Quest_SmallD_ArmorVault", "Vault of The Herald (Dungeon)"),
		Map.entry("Quest_SunGate", "Sun Gate (Overworld)"),
		// Swamp quests
		Map.entry("Quest_OverWorldPOI_ElfQueen", "Elf Queen (Merchant)"),
		// Jungle quests
		Map.entry("Quest_OverworldPOI_Flautist", "Flautist (Overworld)"),
		Map.entry("Quest_Siege_WolfShrine", "Wolf Shrine (Siege)"),
		Map.entry("Quest_OverworldPOI_Ruins", "Ruins (Overworld)"),
		Map.entry("Quest_OverworldPOI_StuckMerchant", "Stuck Merchant (Merchant)"),
		Map.entry("Quest_OverWorldPOI_StuckMerchant", "Stuck Merchant (Merchant)"),
		Map.entry("Quest_Siege_TheRisen", "The Re-Animator (Siege)"),
		Map.entry("Quest_SmallD_DoeShrine", "Red Doe Shrine (Dungeon)")
	));

	public static final Dictionary<String, String> weaponDictionary = new PartialKeyMapDictionary<>(Map.ofEntries(
		// City weapons
		Map.entry("Weapon_RepeaterPistol", "Repeater Pistol"),
		Map.entry("Weapon_Submachinegun", "Submachine Gun"),
		Map.entry("Weapon_SniperRifle", "Sniper Rifle"),
		Map.entry("Weapon_HuntingPistol", "Hunting Pistol"),
		Map.entry("Weapon_AssaultRifle", "Assault Rifle"),
		Map.entry("Weapon_Machinegun", "Chicago Typewriter"),
		// Wasteland weapons
		Map.entry("Weapon_Wasteland_BeamRifle", "Beam Rifle"),
		Map.entry("Weapon_Wasteland_Flail", "Wastelander Flail")
	));

	private static final Dictionary<String, String> trinketKeyWordDictionary = new PartialKeyMapDictionary<>(Map.ofEntries(
		// Amulets
		Map.entry("GunslingersCharm", "Gunslinger's Charm"),
		Map.entry("CleansingJewel", "Cleansing Jewel"),
		Map.entry("GalenicCharm", "Galenic Charm"),
		Map.entry("MendersCharm", "Mender's Charm"),
		Map.entry("ButchersFetish", "Butcher's Fetish"),
		Map.entry("StormAmulet", "Storm Amulet"),
		Map.entry("VengeanceIdol", "Vengeance Idol"),
		Map.entry("BrutalMark", "Brutal Mark"),
		Map.entry("RockOfAnguish", "Rock of Anguish"),
		// Rings
		Map.entry("HeartSeeker", "Heartseeker"),
		Map.entry("PillarOfStone", "Pillar of Stone"),
		Map.entry("BandOfStrength", "Band of Strength"),
		Map.entry("EzlansBand", "Ezlan's Band"),
		Map.entry("GravityStone", "Gravity Stone"),
		Map.entry("HuntersHalo", "Hunter's Halo"),
		Map.entry("JewelOfTheBlackSun", "Jewel of the Black Sun"),
		Map.entry("DevouringLoop", "Devouring Loop"),
		Map.entry("HeartOfTheWolf", "Heart of the Wolf"),
		Map.entry("HuntersBand", "Hunter's Band"),
		Map.entry("KeepersRing", "Keeper's Ring"),
		Map.entry("StoneOfBalance", "Stone Of Balance"),
		Map.entry("RingOfEvasion", "Ring of Evasion"),
		Map.entry("LeechEmber", "Leech Ember"),
		Map.entry("CelerityStone", "Celerity Stone"),
		Map.entry("GuardiansRing", "Guardian's Ring"),
		Map.entry("SageStone", "Sagestone")
	));

	public static final Dictionary<String, String> pickupDictionary = new ChainDictionary(
		new PartialKeyMapDictionary<>(Map.ofEntries(
			Map.entry("Quest_Event_DrifterMask", "Drifter's Mask"),
			Map.entry("Quest_Event_ReggiesRing", "Tarnished Ring"),
			Map.entry("Quest_Event_AcesCoin", "Strange Coin"),
			Map.entry("Quest_Event_Simulacrum", "Simulacrum")
		)),
		trinketKeyWordDictionary,
		new RegExDictionary(
			"^/Game/World_.+/Quest_Event_(.+)/.*$")
	);

	public static final Dictionary<String, String> armorDictionary = new PartialKeyMapDictionary<>(Map.ofEntries(
		// City armors
		Map.entry("Armor_Head_Drifter", "Drifter's Mask"),
		// Jungle armors
		Map.entry("Armor_Head_Radiant", "Radiant Visage")
	));

	public static final Dictionary<String, String> trinketsDictionary = new ChainDictionary(
		trinketKeyWordDictionary,
		new RegExDictionary(
			"^/Game/World_.+/Items/Trinkets/(.+)/.*$",
			"^/Game/World_.+/Items/Trinkets/Trinket_(.+)\\..*$")
	);

	public static final Dictionary<String, String> consumablesDictionary = new RegExDictionary(
		"^/Game/World_.+/Items/Consumables/(.+)/.*$");


	public static final Dictionary<String, String> charactersDictionary = new RegExDictionary(
		"^/Game/World_.+/Characters/(.+)/Blueprints/.*$",
		"^/Game/World_.+/Characters/(.+)/.*$");

	public static final Dictionary<String, String> resourcesDictionary = new RegExDictionary(
		"^/Game/World_.+/Resources/.+/Resource_(.+)\\..*$"
	);
}
