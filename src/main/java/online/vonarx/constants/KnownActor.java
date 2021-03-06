package online.vonarx.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import online.vonarx.constants.world.Biome;
import online.vonarx.constants.world.Zone;

import static online.vonarx.constants.Origin.*;
import static online.vonarx.constants.Type.*;

@RequiredArgsConstructor
public enum KnownActor {
	// Bosses
	// Earth
	GOREFIST("Gorefist", FROM_THE_ASHES, BOSS),
	SHROUD("Shroud", FROM_THE_ASHES, BOSS),
	THE_MANGLER("The Mangler", FROM_THE_ASHES, BOSS),
	BRABUS("Brabus", FROM_THE_ASHES, BOSS),
	THE_ENT("The Ent", FROM_THE_ASHES, WORLD_BOSS),
	SINGE("Singe", FROM_THE_ASHES, WORLD_BOSS),
	RIPHIDE("Riphide", LETO_S_LAB_UPDATE, BOSS),
	// Rhom
	RAZE("Raze", FROM_THE_ASHES, BOSS),
	SCOURGE("Scourge", FROM_THE_ASHES, BOSS),
	MAUL("Maul", FROM_THE_ASHES, BOSS),
	SHADE_AND_SHATTER("Shade and Shatter", FROM_THE_ASHES, BOSS),
	/* Generated */ ANCIENT_CONSTRUCT("Ancient Construct", FROM_THE_ASHES, BOSS),
	CLAVIGER("Claviger", FROM_THE_ASHES, WORLD_BOSS),
	THE_HARROW("The Harrow", FROM_THE_ASHES, WORLD_BOSS),
	UNDYING_KING("Undying King", FROM_THE_ASHES, BOSS),
	// Corsus
	THE_THRALL("The Thrall", FROM_THE_ASHES, BOSS),
	CANKER("Canker", FROM_THE_ASHES, BOSS),
	THE_UNCLEAN_ONE("The Unclean One", FROM_THE_ASHES, BOSS),
	IXILLIS("Ixillis", FROM_THE_ASHES, WORLD_BOSS),
	DREAM_EATER("Dream Eater", SWAMPS_OF_CORSUS_DLC, BOSS),
	BARBED_TERROR("Barbed Terror", SWAMPS_OF_CORSUS_DLC, BOSS),
	ISKAL_QUEEN_ADVENTURE("Iskal Queen", SWAMPS_OF_CORSUS_DLC, BOSS),
	// Yaesha
	THE_WARDEN("The Warden", FROM_THE_ASHES, BOSS),
	STORMCALLER_BOSS("Stormcaller", FROM_THE_ASHES, BOSS),
	SCALD_AND_SEAR("Scald and Sear", FROM_THE_ASHES, BOSS),
	ONSLAUGHT("Onslaught", FROM_THE_ASHES, BOSS),
	BLINK_THIEF("Blink Thief", FROM_THE_ASHES, BOSS),
	/* Generated */ ROOT_HORROR("Root Horror", FROM_THE_ASHES, BOSS),
	TOTEM_FATHER("Totem Father", FROM_THE_ASHES, WORLD_BOSS),
	THE_RAVAGER("The Ravager", FROM_THE_ASHES, WORLD_BOSS),
	// Ward 17
	/* Generated */ DREAMER("Dreamer", FROM_THE_ASHES, WORLD_BOSS),
	// Rural
	/* TODO Generated */ HARSGAARD_ROOT_HARBINGER("Harsgaard, Root Harbinger", SUBJECT_2923_DLC, WORLD_BOSS),
	// Reisum
	ERFOR_THE_JACKAL("Erfor, the Jackal", SUBJECT_2923_DLC, BOSS),
	IKRO_THE_ICE_CONJURER("Ikro, the Ice Conjurer", SUBJECT_2923_DLC, BOSS),
	TIAN_THE_ASSASSIN("Tian, the Assassin", SUBJECT_2923_DLC, BOSS),
	OBRYK_THE_SHIELD_WARDEN("Obryk, the Shield Warden", SUBJECT_2923_DLC, BOSS),
	BRUDVAAK_AND_VARGR("Brudvaak and Vargr", SUBJECT_2923_DLC, WORLD_BOSS),
	// Quests
	// Ward 13
	/* Generated */ ACE("Ace", FROM_THE_ASHES, MERCHANT),
	/* Generated */ MC_CABE("McCabe", FROM_THE_ASHES, MERCHANT),
	/* Generated */ REGGIE("Reggie", FROM_THE_ASHES, MERCHANT),
	/* Generated */ RIGS("Rigs", FROM_THE_ASHES, MERCHANT),
	// TODO Whispers
	// City Earth
	MUD_TOOTH("Mud Tooth", FROM_THE_ASHES, MERCHANT),
	SETTLEMENT("Settlement", FROM_THE_ASHES, POINT_OF_INTEREST),
	WAILING_WOOD("Wailing Tree", FROM_THE_ASHES, POINT_OF_INTEREST),
	THE_ROOT_SHRINE("The Root Shrine", FROM_THE_ASHES, SIEGE),
	A_TALE_OF_TWO_LIZ_S("A Tale of Two Liz's", FROM_THE_ASHES, SIEGE),
	TWISTED_MASK_MERCHANT("Twisted Mask Merchant", FROM_THE_ASHES, MERCHANT),
	HUNTER_S_HIDEOUT("Hunter's Hideout", FROM_THE_ASHES, DUNGEON),
	SUPPLY_RUN("Supply Run", FROM_THE_ASHES, DUNGEON),
	CULT_OF_THE_ROOT("Cult of the Root", FROM_THE_ASHES, DUNGEON),
	THE_ROOT_MOTHER("The Root Mother", FROM_THE_ASHES, SIEGE),
	/* Generated */ LETO_S_LAB("Leto's Lab", LETO_S_LAB_UPDATE, DUNGEON),
	// Rhom
	MONOLITH("Monolith", FROM_THE_ASHES, POINT_OF_INTEREST),
	WUD("Wud", FROM_THE_ASHES, MERCHANT),
	THE_LOST_GANTRY("The Lost Gantry", FROM_THE_ASHES, SIEGE),
	THE_CLEAN_ROOM("The Clean Room", FROM_THE_ASHES, DUNGEON),
	VAULT_OF_THE_HERALD("Vault of The Herald", FROM_THE_ASHES, DUNGEON),
	// Corsus
	/* Generated */ ISKAL_QUEEN_STORY("Iskal Queen", FROM_THE_ASHES, MERCHANT),
	ABANDONED_THRONE("Abandoned Throne", SWAMPS_OF_CORSUS_DLC, POINT_OF_INTEREST),
	CRYPTOLITH_RHOM("Cryptolith", SWAMPS_OF_CORSUS_DLC, POINT_OF_INTEREST),
	CRYPTOLITH("Cryptolith", SWAMPS_OF_CORSUS_DLC, POINT_OF_INTEREST),
	GRAVEYARD_ELF("Graveyard Elf", SWAMPS_OF_CORSUS_DLC, MERCHANT),
	A_SMART_BUG("A Smart Bug?", SWAMPS_OF_CORSUS_DLC, SIEGE),
	FETID_POOL("Fetid Pool", SWAMPS_OF_CORSUS_DLC, DUNGEON),
	WISPS("Wisps", SWAMPS_OF_CORSUS_DLC, DUNGEON),
	// TODO what is "Quest_Event_Sketterling_Temple"
	SKETTERLING("Sketterling", SWAMPS_OF_CORSUS_DLC, QUEST),
	// Yaesha
	FLAUTIST("Flautist", FROM_THE_ASHES, POINT_OF_INTEREST),
	RUINS("Ruins", FROM_THE_ASHES, POINT_OF_INTEREST),
	WOLF_SHRINE("Wolf Shrine", FROM_THE_ASHES, SIEGE),
	THE_RISEN("The Risen", FROM_THE_ASHES, SIEGE),
	RED_DOE_SHRINE("Red Doe Shrine", FROM_THE_ASHES, DUNGEON),
	STUCK_MERCHANT("Stuck Merchant", FROM_THE_ASHES, MERCHANT),
	GUARDIAN_SHRINE("Guardian Shrine", FROM_THE_ASHES, DUNGEON),
	FIGHT_WITH_THE_REBELS("Fight with the Rebels", FROM_THE_ASHES, SIEGE),
	// Rural Earth
	THE_BARN_SIEGE("The Barn Siege", SUBJECT_2923_DLC, SIEGE),
	// Reisum
	SEBUM("Sebum", SUBJECT_2923_DLC, MERCHANT),
	CREEPER_S_PEEPER("Creeper's Peeper", SUBJECT_2923_DLC, DUNGEON),
	KRALL_MOTHER("Krall Mother", SUBJECT_2923_DLC, MERCHANT),
	KRALL_BABY("Krall Baby", SUBJECT_2923_DLC, QUEST),
	WARNING_TOTEMS("Warning Totems", SUBJECT_2923_DLC, DUNGEON),
	FELMOURN_BURROW("Felmourn Burrow", SUBJECT_2923_DLC, POINT_OF_INTEREST),
	HOMESTEAD("Homestead", SUBJECT_2923_DLC, POINT_OF_INTEREST),
	MAGIR_S_TEST("Magir's Test", SUBJECT_2923_DLC, DUNGEON),
	// Items
	// Weapons
	// Hand Guns
	CURSE_OF_THE_JUNGLE_GOD("Curse of the Jungle God", FROM_THE_ASHES, HAND_GUN),
	DEFILER("Defiler", FROM_THE_ASHES, HAND_GUN),
	HIVE_CANNON("Hive Cannon", FROM_THE_ASHES, HAND_GUN),
	HUNTING_PISTOL("Hunting Pistol", FROM_THE_ASHES, HAND_GUN),
	MAGNUM_REVOLVER("Magnum Revolver", FROM_THE_ASHES, HAND_GUN),
	REPEATER_PISTOL("Repeater Pistol", FROM_THE_ASHES, HAND_GUN),
	SPITFIRE("Spitfire", FROM_THE_ASHES, HAND_GUN),
	SUBMACHINE_GUN("Submachine Gun", FROM_THE_ASHES, HAND_GUN),
	PRIDE_OF_THE_ISKAL("Pride of the Iskal", SWAMPS_OF_CORSUS_DLC, HAND_GUN),
	/* TODO Generated */ MACHINE_PISTOL("Machine Pistol", SUBJECT_2923_DLC, HAND_GUN),
	SAWED_OFF("Sawed-Off", SUBJECT_2923_DLC, HAND_GUN),
	TWIN_SHOT("Twin Shot", SUBJECT_2923_DLC, HAND_GUN),
	// Long Guns
	ASSAULT_RIFLE("Assault Rifle", FROM_THE_ASHES, LONG_GUN),
	BEAM_RIFLE("Beam Rifle", FROM_THE_ASHES, LONG_GUN),
	CHICAGO_TYPEWRITER("Chicago Typewriter", FROM_THE_ASHES, LONG_GUN),
	COACH_GUN("Coach Gun", FROM_THE_ASHES, LONG_GUN),
	CROSSBOW("Crossbow", FROM_THE_ASHES, LONG_GUN),
	DEVASTATOR("Devastator", FROM_THE_ASHES, LONG_GUN),
	EYE_OF_THE_STORM("Eye of the Storm", FROM_THE_ASHES, LONG_GUN),
	HUNTING_RIFLE("Hunting Rifle", FROM_THE_ASHES, LONG_GUN),
	PARTICLE_ACCELERATOR("Particle Accelerator", FROM_THE_ASHES, LONG_GUN),
	REPULSOR("Repulsor", FROM_THE_ASHES, LONG_GUN),
	RICOCHET_RIFLE("Ricochet Rifle", FROM_THE_ASHES, LONG_GUN),
	RUIN("Ruin", FROM_THE_ASHES, LONG_GUN),
	SHOTGUN("Shotgun", FROM_THE_ASHES, LONG_GUN),
	SNIPER_RIFLE("Sniper Rifle", FROM_THE_ASHES, LONG_GUN),
	SPOREBLOOM("Sporebloom", FROM_THE_ASHES, LONG_GUN),
	FUSION_RIFLE("Fusion Rifle", SUBJECT_2923_DLC, LONG_GUN),
	ALTERNATOR("Alternator", SUBJECT_2923_DLC, LONG_GUN),
	// Melee Weapons
	GUARDIAN_AXE("Guardian Axe", FROM_THE_ASHES, MELEE_WEAPON),
	LOST_HARPOON("Lost Harpoon", FROM_THE_ASHES, MELEE_WEAPON),
	PETRIFIED_MAUL("Petrified Maul", FROM_THE_ASHES, MELEE_WEAPON),
	RIVEN("Riven", FROM_THE_ASHES, MELEE_WEAPON),
	SCAR_OF_THE_JUNGLE_GOD("Scar of The Jungle God", FROM_THE_ASHES, MELEE_WEAPON),
	SCRAP_HAMMER("Scrap Hammer", FROM_THE_ASHES, MELEE_WEAPON),
	SCRAP_HATCHET("Scrap Hatchet", FROM_THE_ASHES, MELEE_WEAPON),
	SCRAP_SWORD("Scrap Sword", FROM_THE_ASHES, MELEE_WEAPON),
	SCYTHE("Scythe", FROM_THE_ASHES, MELEE_WEAPON),
	SMOLDER("Smolder", FROM_THE_ASHES, MELEE_WEAPON),
	SPEAR("Spear", FROM_THE_ASHES, MELEE_WEAPON),
	VOICE_OF_THE_TEMPEST("Voice of The Tempest", FROM_THE_ASHES, MELEE_WEAPON),
	WASTELANDER_FLAIL("Wastelander Flail", FROM_THE_ASHES, MELEE_WEAPON),
	WORLD_BREAKER("World Breaker", FROM_THE_ASHES, MELEE_WEAPON),
	BUTCHERS_FLAIL("Butchers Flail", SWAMPS_OF_CORSUS_DLC, MELEE_WEAPON),
	HERO_S_SWORD("Hero's Sword", SWAMPS_OF_CORSUS_DLC, MELEE_WEAPON),
	CHAIN_BLADE("Chain Blade", SUBJECT_2923_DLC, MELEE_WEAPON),
	WORLD_S_EDGE("World's Edge", SUBJECT_2923_DLC, MELEE_WEAPON),
	FROSTBORNE("Frostborne", SUBJECT_2923_DLC, MELEE_WEAPON),
	// Mods
	BANISH("Banish", FROM_THE_ASHES, BUILT_IN_MOD),
	BECKON_MOD("Beckon", FROM_THE_ASHES, MOD),
	BLINK_TOKEN("Blink Token", FROM_THE_ASHES, MOD),
	BREATH_OF_THE_DESERT("Breath of the Desert", FROM_THE_ASHES, MOD),
	CORROSIVE_AURA("Corrosive Aura", FROM_THE_ASHES, MOD),
	EXPLOSIVE_SHOT("Explosive Shot", FROM_THE_ASHES, MOD),
	FLAME_THROWER("Flame Thrower", FROM_THE_ASHES, BUILT_IN_MOD),
	FLICKER_CLOAK("Flicker Cloak", FROM_THE_ASHES, MOD),
	GRAVITY_CORE("Gravity Core", FROM_THE_ASHES, BUILT_IN_MOD),
	HIVE_SHOT("Hive Shot", FROM_THE_ASHES, BUILT_IN_MOD),
	HOT_SHOT("Hot Shot", FROM_THE_ASHES, MOD),
	HOWLER_S_IMMUNITY("Howler's Immunity", FROM_THE_ASHES, MOD),
	HUNTER_S_MARK("Hunter's Mark", FROM_THE_ASHES, MOD),
	IRON_SENTINEL("Iron Sentinel", FROM_THE_ASHES, MOD),
	MANTLE_OF_THORNS("Mantle of Thorns", FROM_THE_ASHES, MOD),
	MENDER_S_AURA("Mender's Aura", FROM_THE_ASHES, MOD),
	RADIOACTIVE_VOLLEY("Radioactive Volley", FROM_THE_ASHES, BUILT_IN_MOD),
	RATTLE_WEED("Rattle Weed", FROM_THE_ASHES, MOD),
	SEED_CALLER("Seed Caller", FROM_THE_ASHES, MOD),
	SKEWER("Skewer", FROM_THE_ASHES, BUILT_IN_MOD),
	SONG_OF_SWORDS("Song of Swords", FROM_THE_ASHES, MOD),
	SPORE_SHOT("Spore Shot", FROM_THE_ASHES, BUILT_IN_MOD),
	STATIC_FIELD_SHOT("Static Field Shot", FROM_THE_ASHES, BUILT_IN_MOD),
	STORMCALLER_MOD("Stormcaller", FROM_THE_ASHES, MOD),
	SWARM("Swarm", FROM_THE_ASHES, MOD),
	TENTACLE_SHOT("Tentacle Shot", FROM_THE_ASHES, BUILT_IN_MOD),
	UNDYING("Undying", FROM_THE_ASHES, BUILT_IN_MOD),
	VEIL_OF_THE_BLACK_TEAR("Veil of the Black Tear", FROM_THE_ASHES, MOD),
	WILDFIRE_SHOT("Wildfire Shot", FROM_THE_ASHES, MOD),
	RIFT_WALKER("Rift Walker", SWAMPS_OF_CORSUS_DLC, MOD),
	SEEKER("Seeker", SWAMPS_OF_CORSUS_DLC, MOD),
	UNSTABLE_QUILLS("Unstable Quills", SWAMPS_OF_CORSUS_DLC, MOD),
	VAMPIRIC("Vampiric", SWAMPS_OF_CORSUS_DLC, BUILT_IN_MOD),
	COLD_SPEAR("Cold Spear", SUBJECT_2923_DLC, MOD),
	BLIZZARD("Blizzard", SUBJECT_2923_DLC, MOD),
	FUSION_CANNON("Fusion Cannon", SUBJECT_2923_DLC, BUILT_IN_MOD),
	INCINERATOR("Incinerator", SUBJECT_2923_DLC, BUILT_IN_MOD),
	FAN_OF_KNIVES("Fan of Knives", SUBJECT_2923_DLC, MOD),
	FROZEN_MIST("Frozen Mist", SUBJECT_2923_DLC, MOD),
	VERY_GOOD_BOY("Very Good Boy", SUBJECT_2923_DLC, MOD),
	// Armor
	ADVENTURER_GOGGLES("Adventurer Goggles", FROM_THE_ASHES, HEAD_ARMOUR),
	ADVENTURER_TUNIC("Adventurer Tunic", FROM_THE_ASHES, BODY_ARMOR),
	ADVENTURER_LEGGINGS("Adventurer Leggings", FROM_THE_ASHES, LEG_ARMOR),
	AKARI_MASK("Akari Mask", FROM_THE_ASHES, HEAD_ARMOUR),
	AKARI_GARB("Akari Garb", FROM_THE_ASHES, BODY_ARMOR),
	AKARI_LEGGINGS("Akari Leggings", FROM_THE_ASHES, LEG_ARMOR),
	BANDIT_S_MASK("Bandit's Mask", FROM_THE_ASHES, HEAD_ARMOUR),
	BANDIT_JACKET("Bandit Jacket", FROM_THE_ASHES, BODY_ARMOR),
	BANDIT_TROUSERS("Bandit Trousers", FROM_THE_ASHES, LEG_ARMOR),
	BOMBER_HAT("Bomber Hat", FROM_THE_ASHES, HEAD_ARMOUR),
	CULTIST_HAT("Cultist Hat", FROM_THE_ASHES, HEAD_ARMOUR),
	CULTIST_DUSTER("Cultist Duster", FROM_THE_ASHES, BODY_ARMOR),
	CULTIST_BRITCHES("Cultist Britches", FROM_THE_ASHES, LEG_ARMOR),
	DRIFTER_S_MASK("Drifter's Mask", FROM_THE_ASHES, HEAD_ARMOUR),
	DRIFTER_S_OVERCOAT("Drifter's Overcoat", FROM_THE_ASHES, BODY_ARMOR),
	DRIFTER_S_TROUSERS("Drifter's Trousers", FROM_THE_ASHES, LEG_ARMOR),
	ELDER_HEADDRESS("Elder Headdress", FROM_THE_ASHES, HEAD_ARMOUR),
	ELDER_RAIMENT("Elder Raiment", FROM_THE_ASHES, BODY_ARMOR),
	ELDER_LEGGINGS("Elder Leggings", FROM_THE_ASHES, LEG_ARMOR),
	HUNTER_SHROUD("Hunter Shroud", FROM_THE_ASHES, HEAD_ARMOUR),
	HUNTER_TRENCHCOAT("Hunter Trenchcoat", FROM_THE_ASHES, BODY_ARMOR),
	HUNTER_PANTS("Hunter Pants", FROM_THE_ASHES, LEG_ARMOR),
	OSSEOUS_HELM("Osseous Helm", FROM_THE_ASHES, HEAD_ARMOUR),
	OSSEOUS_HUSK("Osseous Husk", FROM_THE_ASHES, BODY_ARMOR),
	OSSEOUS_KILT("Osseous Kilt", FROM_THE_ASHES, LEG_ARMOR),
	RADIANT_VISAGE("Radiant Visage", FROM_THE_ASHES, HEAD_ARMOUR),
	RADIANT_PROTECTOR("Radiant Protector", FROM_THE_ASHES, BODY_ARMOR),
	RADIANT_GREAVES("Radiant Greaves", FROM_THE_ASHES, LEG_ARMOR),
	SCRAPPER_HELMET("Scrapper Helmet", FROM_THE_ASHES, HEAD_ARMOUR),
	SCRAPPER_BODYPLATE("Scrapper Bodyplate", FROM_THE_ASHES, BODY_ARMOR),
	SCRAPPER_WORKBOOTS("Scrapper Workboots", FROM_THE_ASHES, LEG_ARMOR),
	SLAYER_MASK("Slayer Mask", FROM_THE_ASHES, HEAD_ARMOUR),
	SLAYER_MANTLE("Slayer Mantle", FROM_THE_ASHES, BODY_ARMOR),
	SLAYER_BOOTS("Slayer Boots", FROM_THE_ASHES, LEG_ARMOR),
	TWISTED_MASK("Twisted Mask", FROM_THE_ASHES, HEAD_ARMOUR),
	TWISTED_HOOD("Twisted Hood", FROM_THE_ASHES, HEAD_ARMOUR),
	TWISTED_CAGE("Twisted Cage", FROM_THE_ASHES, BODY_ARMOR),
	TWISTED_TASSETS("Twisted Tassets", FROM_THE_ASHES, LEG_ARMOR),
	VOID_SKULL("Void Skull", FROM_THE_ASHES, HEAD_ARMOUR),
	VOID_CARAPACE("Void Carapace", FROM_THE_ASHES, BODY_ARMOR),
	VOID_GREAVES("Void Greaves", FROM_THE_ASHES, LEG_ARMOR),
	LETO_S_HELMET("Leto's Helmet", LETO_S_LAB_UPDATE, HEAD_ARMOUR),
	LETO_S_ARMOR("Leto's Armor", LETO_S_LAB_UPDATE, BODY_ARMOR),
	LETO_S_LEGGINGS("Leto's Leggings", LETO_S_LAB_UPDATE, LEG_ARMOR),
	CARAPACE_GREAT_HELM("Carapace Great Helm", SWAMPS_OF_CORSUS_DLC, HEAD_ARMOUR),
	CARAPACE_SHELL("Carapace Shell", SWAMPS_OF_CORSUS_DLC, BODY_ARMOR),
	CARAPACE_GREAVES("Carapace Greaves", SWAMPS_OF_CORSUS_DLC, LEG_ARMOR),
	LABYRINTH_HELM("Labyrinth Helm", SWAMPS_OF_CORSUS_DLC, HEAD_ARMOUR),
	LABYRINTH_ARMOR("Labyrinth Armor", SWAMPS_OF_CORSUS_DLC, BODY_ARMOR),
	LABYRINTH_GREAVES("Labyrinth Greaves", SWAMPS_OF_CORSUS_DLC, LEG_ARMOR),
	SCAVENGER_HELMET("Scavenger Helmet", SUBJECT_2923_DLC, HEAD_ARMOUR),
	SCAVENGER_ARMOR("Scavenger Armor", SUBJECT_2923_DLC, BODY_ARMOR),
	SCAVENGER_BOOTS("Scavenger Boots", SUBJECT_2923_DLC, LEG_ARMOR),
	WARLORD_SKULL("Warlord Skull", SUBJECT_2923_DLC, HEAD_ARMOUR),
	WARLORD_ARMOR("Warlord Armor", SUBJECT_2923_DLC, BODY_ARMOR),
	WARLORD_BOOTS("Warlord Boots", SUBJECT_2923_DLC, LEG_ARMOR),
	// Skins
	SURVIVOR_GOOGLES_SKIN("Survivor Googles Skin", SWAMPS_OF_CORSUS_DLC, SKIN_HEAD_ARMOUR),
	SURVIVOR_TUNIC_SKIN("Survivor Tunic Skin", SWAMPS_OF_CORSUS_DLC, SKIN_BODY_ARMOR),
	SURVIVOR_LEGGINGS_SKIN("Survivor Leggings Skin", SWAMPS_OF_CORSUS_DLC, SKIN_LEG_ARMOR),
	SHADOW_MASK_SKIN("Shadow Mask Skin", SWAMPS_OF_CORSUS_DLC, SKIN_HEAD_ARMOUR),
	SHADOW_GARB_SKIN("Shadow Garb Skin", SWAMPS_OF_CORSUS_DLC, SKIN_BODY_ARMOR),
	SHADOW_LEGGINGS_SKIN("Shadow Leggings Skin", SWAMPS_OF_CORSUS_DLC, SKIN_LEG_ARMOR),
	BRIGAND_MASK_SKIN("Brigand Mask Skin", SWAMPS_OF_CORSUS_DLC, SKIN_HEAD_ARMOUR),
	BRIGAND_JACKET_SKIN("Brigand Jacket Skin", SWAMPS_OF_CORSUS_DLC, SKIN_BODY_ARMOR),
	BRIGAND_TROUSERS_SKIN("Brigand Trousers Skin", SWAMPS_OF_CORSUS_DLC, SKIN_LEG_ARMOR),
	RITUALIST_HAT_SKIN("Ritualist Hat Skin", SWAMPS_OF_CORSUS_DLC, SKIN_HEAD_ARMOUR),
	RITUALIST_DUSTER_SKIN("Ritualist Duster Skin", SWAMPS_OF_CORSUS_DLC, SKIN_BODY_ARMOR),
	RITUALIST_BRITCHES_SKIN("Ritualist Britches Skin", SWAMPS_OF_CORSUS_DLC, SKIN_LEG_ARMOR),
	DOOMSAYER_HAT_SKIN("Doomsayer Hat Skin", PREORDER_BONUS, SKIN_HEAD_ARMOUR),
	DOOMSAYER_DUSTER_SKIN("Doomsayer Duster Skin", PREORDER_BONUS, SKIN_BODY_ARMOR),
	DOOMSAYER_BRITCHES_SKIN("Doomsayer Britches Skin", PREORDER_BONUS, SKIN_LEG_ARMOR),
	VAGRANT_MASK_SKIN("Vagrant Mask Skin", SWAMPS_OF_CORSUS_DLC, SKIN_HEAD_ARMOUR),
	VAGRANT_OVERCOAT_SKIN("Vagrant Overcoat Skin", SWAMPS_OF_CORSUS_DLC, SKIN_BODY_ARMOR),
	VAGRANT_TROUSERS_SKIN("Vagrant Trousers Skin", SWAMPS_OF_CORSUS_DLC, SKIN_LEG_ARMOR),
	BLOODLETTER_HEADDRESS_SKIN("Bloodletter Headdress Skin", SWAMPS_OF_CORSUS_DLC, SKIN_HEAD_ARMOUR),
	BLOODLETTER_RAIMENT_SKIN("Bloodletter Raiment Skin", SWAMPS_OF_CORSUS_DLC, SKIN_BODY_ARMOR),
	BLOODLETTER_LEGGINGS_SKIN("Bloodletter Leggings Skin", SWAMPS_OF_CORSUS_DLC, SKIN_LEG_ARMOR),
	WIDOWMAKER_SHROUD_SKIN("Widowmaker Shroud Skin", SWAMPS_OF_CORSUS_DLC, SKIN_HEAD_ARMOUR),
	WIDOWMAKER_TRENCHCOAT_SKIN("Widowmaker Trenchcoat Skin", SWAMPS_OF_CORSUS_DLC, SKIN_BODY_ARMOR),
	WIDOWMAKER_PANTS_SKIN("Widowmaker Pants Skin", SWAMPS_OF_CORSUS_DLC, SKIN_LEG_ARMOR),
	NIGHTSTALKER_SHROUD_SKIN("Nightstalker Shroud Skin", PREORDER_BONUS, SKIN_HEAD_ARMOUR),
	NIGHTSTALKER_TRENCHCOAT_SKIN("Nightstalker Trenchcoat Skin", PREORDER_BONUS, SKIN_BODY_ARMOR),
	NIGHTSTALKER_PANTS_SKIN("Nightstalker Pants Skin", PREORDER_BONUS, SKIN_LEG_ARMOR),
	HEADHUNTER_HELM_SKIN("Headhunter Helm Skin", SWAMPS_OF_CORSUS_DLC, SKIN_HEAD_ARMOUR),
	HEADHUNTER_HUSK_SKIN("Headhunter Husk Skin", SWAMPS_OF_CORSUS_DLC, SKIN_BODY_ARMOR),
	HEADHUNTER_KILT_SKIN("Headhunter Kilt Skin", SWAMPS_OF_CORSUS_DLC, SKIN_LEG_ARMOR),
	CRUSADER_VISAGE_SKIN("Crusader Visage Skin", SWAMPS_OF_CORSUS_DLC, SKIN_HEAD_ARMOUR),
	CRUSADER_PROTECTOR_SKIN("Crusader Protector Skin", SWAMPS_OF_CORSUS_DLC, SKIN_BODY_ARMOR),
	CRUSADER_GREAVES_SKIN("Crusader Greaves Skin", SWAMPS_OF_CORSUS_DLC, SKIN_LEG_ARMOR),
	ROUGHNECK_HELMET_SKIN("Roughneck Helmet Skin", SWAMPS_OF_CORSUS_DLC, SKIN_HEAD_ARMOUR),
	ROUGHNECK_BODYPLATE_SKIN("Roughneck Bodyplate Skin", SWAMPS_OF_CORSUS_DLC, SKIN_BODY_ARMOR),
	ROUGHNECK_WORKBOOTS_SKIN("Roughneck Workboots Skin", SWAMPS_OF_CORSUS_DLC, SKIN_LEG_ARMOR),
	GLADIATOR_HELMET_SKIN("Gladiator Helmet Skin", PREORDER_BONUS, SKIN_HEAD_ARMOUR),
	GLADIATOR_BODYPLATE_SKIN("Gladiator Bodyplate Skin", PREORDER_BONUS, SKIN_BODY_ARMOR),
	GLADIATOR_WORKBOOTS_SKIN("Gladiator Workboots Skin", PREORDER_BONUS, SKIN_LEG_ARMOR),
	HARBRINGER_MASK_SKIN("Harbringer Mask Skin", SWAMPS_OF_CORSUS_DLC, SKIN_HEAD_ARMOUR),
	HARBRINGER_MANTLE_SKIN("Harbringer Mantle Skin", SWAMPS_OF_CORSUS_DLC, SKIN_BODY_ARMOR),
	HARBRINGER_BOOTS_SKIN("Harbringer Boots Skin", SWAMPS_OF_CORSUS_DLC, SKIN_LEG_ARMOR),
	CORRUPTED_HOOD_SKIN("Corrupted Hood Skin", SWAMPS_OF_CORSUS_DLC, SKIN_HEAD_ARMOUR),
	CORRUPTED_CAGE_SKIN("Corrupted Cage Skin", SWAMPS_OF_CORSUS_DLC, SKIN_BODY_ARMOR),
	CORRUPTED_TASSETS_SKIN("Corrupted Tassets Skin", FROM_THE_ASHES, SKIN_LEG_ARMOR),
	CHAOS_SKULL_SKIN("Chaos Skull Skin", SWAMPS_OF_CORSUS_DLC, SKIN_HEAD_ARMOUR),
	CHAOS_CARAPACE_SKIN("Chaos Carapace Skin", SWAMPS_OF_CORSUS_DLC, SKIN_BODY_ARMOR),
	CHAOS_GREAVES_SKIN("Chaos Greaves Skin", FROM_THE_ASHES, SKIN_LEG_ARMOR),
	SENTINEL_HELMET_SKIN("Sentinel Helmet Skin", SWAMPS_OF_CORSUS_DLC, SKIN_HEAD_ARMOUR),
	SENTINEL_ARMOR_SKIN("Sentinel Armor Skin", SWAMPS_OF_CORSUS_DLC, SKIN_BODY_ARMOR),
	SENTINEL_LEGGINGS_SKIN("Sentinel Leggings Skin", SWAMPS_OF_CORSUS_DLC, SKIN_LEG_ARMOR),
	VANGUARD_GREAT_HELM_SKIN("Vanguard Great Helm Skin", SWAMPS_OF_CORSUS_DLC, SKIN_HEAD_ARMOUR),
	VANGUARD_SHELL_SKIN("Vanguard Shell Skin", SWAMPS_OF_CORSUS_DLC, SKIN_BODY_ARMOR),
	VANGUARD_GREAVES_SKIN("Vanguard Greaves Skin", SWAMPS_OF_CORSUS_DLC, SKIN_LEG_ARMOR),
	MYSTIC_HELM_SKIN("Mystic Helm Skin", SWAMPS_OF_CORSUS_DLC, SKIN_HEAD_ARMOUR),
	MYSTIC_ARMOR_SKIN("Mystic Armor Skin", SWAMPS_OF_CORSUS_DLC, SKIN_BODY_ARMOR),
	MYSTIC_GREAVES_SKIN("Mystic Greaves Skin", SWAMPS_OF_CORSUS_DLC, SKIN_LEG_ARMOR),
	DESTROYER_SKULL_SKIN("Destroyer Skull Skin", SUBJECT_2923_DLC, SKIN_HEAD_ARMOUR),
	DESTROYER_ARMOR_SKIN("Destroyer Armor Skin", SUBJECT_2923_DLC, SKIN_BODY_ARMOR),
	DESTROYER_BOOTS_SKIN("Destroyer Boots Skin", SUBJECT_2923_DLC, SKIN_LEG_ARMOR),
	// Quest items
	TARNISHED_RING("Tarnished Ring", FROM_THE_ASHES, QUEST_PICKUP),
	STRANGE_COIN("Strange Coin", FROM_THE_ASHES, QUEST_PICKUP),
	JANITOR_S_WATCH("Janitor's Watch", SUBJECT_2923_DLC, QUEST_PICKUP),
	// Misc items
	SIMULACRUM("Simulacrum", FROM_THE_ASHES, PICKUP),
	TOME_OF_KNOWLEDGE("Tome of Knowledge", FROM_THE_ASHES, PICKUP),
	// Amulets
	BRUTAL_MARK("Brutal Mark", FROM_THE_ASHES, AMULET),
	BUTCHER_S_FETISH("Butcher's Fetish", FROM_THE_ASHES, AMULET),
	CLEANSING_JEWEL("Cleansing Jewel", FROM_THE_ASHES, AMULET),
	GALENIC_CHARM("Galenic Charm", FROM_THE_ASHES, AMULET),
	GUNSLINGER_S_CHARM("Gunslinger's Charm", FROM_THE_ASHES, AMULET),
	LETO_S_AMULET("Leto's Amulet", FROM_THE_ASHES, AMULET),
	MENDER_S_CHARM("Mender's Charm", FROM_THE_ASHES, AMULET),
	POCKET_WATCH("Pocket Watch", FROM_THE_ASHES, AMULET),
	ROCK_OF_ANGUISH("Rock of Anguish", FROM_THE_ASHES, AMULET),
	STORM_AMULET("Storm Amulet", FROM_THE_ASHES, AMULET),
	TWISTED_IDOL("Twisted Idol", FROM_THE_ASHES, AMULET),
	SOUL_ANCHOR("Soul Anchor", FROM_THE_ASHES, AMULET),
	SCAVENGER_S_BAUBLE("Scavenger's Bauble", FROM_THE_ASHES, AMULET),
	VENGEANCE_IDOL("Vengeance Idol", FROM_THE_ASHES, AMULET),
	NIGHTMARE_SPIRAL("Nightmare Spiral", HARDCORE_UPDATE, AMULET),
	RUSTED_AMULET("Rusted Amulet", SWAMPS_OF_CORSUS_DLC, AMULET),
	TALISMAN_OF_ANIMOSITY("Talisman of Animosity", SWAMPS_OF_CORSUS_DLC, AMULET),
	HEART_OF_DARKNESS("Heart of Darkness", SWAMPS_OF_CORSUS_DLC, AMULET),
	AMULET_OF_EPICARICACY("Amulet of Epicaricacy", SWAMPS_OF_CORSUS_DLC, AMULET),
	DAREDEVIL_S_CHARM("Daredevil's Charm", SWAMPS_OF_CORSUS_DLC, AMULET),
	BLACK_ROSE("Black Rose", SWAMPS_OF_CORSUS_DLC, AMULET),
	TALISMAN_OF_PERSEVERANCE("Talisman of Perseverance", SWAMPS_OF_CORSUS_DLC, AMULET),
	RAZORWIRE_NECKLACE("Razorwire Necklace", SUBJECT_2923_DLC, AMULET),
	HANGMAN_S_MOMENTO("Hangman's Momento", SUBJECT_2923_DLC, AMULET),
	ABRASIVE_AMULET("Abrasive Amulet", SUBJECT_2923_DLC, AMULET),
	DRIFTSTONE("Driftstone", SUBJECT_2923_DLC, AMULET),
	CHARCOAL_NECKLACE("Charcoal Necklace", SUBJECT_2923_DLC, AMULET),
	VULCAN_S_DETONATOR("Vulcan's Detonator", SUBJECT_2923_DLC, AMULET),
	POLISHED_WHETSTONE("Polished Whetstone", SUBJECT_2923_DLC, AMULET),
	SHATTERED_VERTEBRAE("Shattered Vertebrae", SUBJECT_2923_DLC, AMULET),
	ONYX_PENDULUM("Onyx Pendulum", SUBJECT_2923_DLC, AMULET),
	BLESSED_NECKLACE("Blessed Necklace", SUBJECT_2923_DLC, AMULET),
	RADIOACTIVE_EMBER("Radioactive Ember", SUBJECT_2923_DLC, AMULET),
	TERROR_MARGIN("Terror Margin", SUBJECT_2923_DLC, AMULET),
	STALKER_S_BRAND("Stalker's Brand", SUBJECT_2923_DLC, AMULET),
	WHITE_ROSE("White Rose", SUBJECT_2923_DLC, AMULET),
	// Rings
	BAND_OF_STRENGTH("Band of Strength", FROM_THE_ASHES, RING),
	BLOOD_FONT("Blood Font", FROM_THE_ASHES, RING),
	BRAIDED_THORNS("Braided Thorns", FROM_THE_ASHES, RING),
	CELERITY_STONE("Celerity Stone", FROM_THE_ASHES, RING),
	DEVOURING_LOOP("Devouring Loop", FROM_THE_ASHES, RING),
	EZLAN_S_BAND("Ezlan's Band", FROM_THE_ASHES, RING),
	GRAVITY_STONE("Gravity Stone", FROM_THE_ASHES, RING),
	GUARDIAN_S_RING("Guardian's Ring", FROM_THE_ASHES, RING),
	HEARTSEEKER("Heartseeker", FROM_THE_ASHES, RING),
	HEART_OF_THE_WOLF("Heart of the Wolf", FROM_THE_ASHES, RING),
	HUNTER_S_BAND("Hunter's Band", FROM_THE_ASHES, RING),
	HUNTER_S_HALO("Hunter's Halo", FROM_THE_ASHES, RING),
	JEWEL_OF_THE_BLACK_SUN("Jewel of the Black Sun", FROM_THE_ASHES, RING),
	KEEPER_S_RING("Keeper's Ring", FROM_THE_ASHES, RING),
	LEECH_EMBER("Leech Ember", FROM_THE_ASHES, RING),
	MOTHER_S_RING("Mother's Ring", FROM_THE_ASHES, RING),
	PILLAR_OF_STONE("Pillar of Stone", FROM_THE_ASHES, RING),
	RAZORSTONE("Razorstone", FROM_THE_ASHES, RING),
	RING_OF_EVASION("Ring of Evasion", FROM_THE_ASHES, RING),
	ROOT_CIRCLET("Root Circlet", FROM_THE_ASHES, RING),
	SAGESTONE("Sagestone", FROM_THE_ASHES, RING),
	STONE_OF_BALANCE("Stone of Balance", FROM_THE_ASHES, RING),
	RING_OF_THE_ADMIRAL("Ring of the Admiral", ADVENTURE_MODE_UPDATE, RING),
	AKARI_WAR_BAND("Akari War Band", HARDCORE_UPDATE, RING),
	BAND_OF_ACCORD("Band of Accord", HARDCORE_UPDATE, RING),
	EMPOWERING_LOOP("Empowering Loop", HARDCORE_UPDATE, RING),
	PROVISIONER_RING("Provisioner Ring", HARDCORE_UPDATE, RING),
	RING_OF_SUPREMACY("Ring of Supremacy", HARDCORE_UPDATE, RING),
	AGGRESSOR_S_BANE("Aggressor's Bane", SWAMPS_OF_CORSUS_DLC, RING),
	BAND_OF_CASTOR("Band of Castor", SWAMPS_OF_CORSUS_DLC, RING),
	BAND_OF_POLLUX("Band of Pollux", SWAMPS_OF_CORSUS_DLC, RING),
	COMPULSION_LOOP("Compulsion Loop", SWAMPS_OF_CORSUS_DLC, RING),
	DECEIVER_S_BAND("Deceiver's Band", SWAMPS_OF_CORSUS_DLC, RING),
	GIFT_OF_THE_ISKAL("Gift of the Iskal", SWAMPS_OF_CORSUS_DLC, RING),
	GRIM_COIL("Grin Coil", SWAMPS_OF_CORSUS_DLC, RING),
	GUNSLINGER_S_RING("Gunslinger's Ring", SWAMPS_OF_CORSUS_DLC, RING),
	HERO_S_RING("Hero's Ring", SWAMPS_OF_CORSUS_DLC, RING),
	ISKAL_HUNTER_BAND("Iskal Hunter Band", SWAMPS_OF_CORSUS_DLC, RING),
	LOOP_OF_PROSPERITY("Loop of Prosperity", SWAMPS_OF_CORSUS_DLC, RING),
	PEARL_OF_LUMINESCENCE("Pearl of Luminescence", SWAMPS_OF_CORSUS_DLC, RING),
	RING_OF_ELUSION("Ring of Elusion", SWAMPS_OF_CORSUS_DLC, RING),
	RING_OF_SHADOWS("Ring of Shadows", SWAMPS_OF_CORSUS_DLC, RING),
	RING_OF_THE_MANTIS("Ring of the Mantis", SWAMPS_OF_CORSUS_DLC, RING),
	RING_OF_THE_UNCLEAN("Ring of the Unclean", SWAMPS_OF_CORSUS_DLC, RING),
	SOUL_EMBER("Soul Ember", SWAMPS_OF_CORSUS_DLC, RING),
	SOUL_LINK("Soul Link", SWAMPS_OF_CORSUS_DLC, RING),
	STOCKPILE_CIRCLET("Stockpile Circlet", SWAMPS_OF_CORSUS_DLC, RING),
	FIVE_FINGERED_RING("Five Fingered Ring", SUBJECT_2923_DLC, RING),
	BURDEN_OF_THE_DEVOTED("Burden of the Devoted", SUBJECT_2923_DLC, RING),
	VOLATILE_GEM("Volatile Gem", SUBJECT_2923_DLC, RING),
	AMBER_MOONSTONE("Amber Moonstone", SUBJECT_2923_DLC, RING),
	/* TODO Generated */ RING_OF_HONOR("Ring of Honor", SUBJECT_2923_DLC, RING),
	SCAVENGER_S_RING("Scavenger's Ring", SUBJECT_2923_DLC, RING),
	BLOODLETTER_S_INSIGNIA("Bloodletter's Insignia", SUBJECT_2923_DLC, RING),
	BAND_OF_DISCORD("Band of Discord", SUBJECT_2923_DLC, RING),
	RING_OF_SYNERGY("Ring of Synergy", SUBJECT_2923_DLC, RING),
	BURDEN_OF_THE_WARLORD("Burden of the Warlord", SUBJECT_2923_DLC, RING),
	SWASHBUCKLER_S_SIGNET("Swashbuckler's Signet", SUBJECT_2923_DLC, RING),
	RING_OF_THE_PUNISHER("Ring of the Punisher", SUBJECT_2923_DLC, RING),
	SERPENT_S_FANG("Serpent's Fang", SUBJECT_2923_DLC, RING),
	BACKBREAKER_RING("Backbreaker Ring", SUBJECT_2923_DLC, RING),
	BURDEN_OF_THE_GAMBLER("Burden of the Gambler", SUBJECT_2923_DLC, RING),
	BURDEN_OF_THE_RECKLESS("Burden of the Reckless", SUBJECT_2923_DLC, RING),
	JUGGERNAUT_BAND("Juggernaut Band", SUBJECT_2923_DLC, RING),
	RESTRICTION_CORD("Restriction Cord", SUBJECT_2923_DLC, RING),
	ALCHEMIST_S_JEWEL("Alchemist's Jewel", SUBJECT_2923_DLC, RING),
	BURDEN_OF_THE_FOLLOWER("Burden of the Follower", SUBJECT_2923_DLC, RING),
	EVOKER_S_SEAL("Evoker's Seal", SUBJECT_2923_DLC, RING),
	PRISMATIC_DIAMOND_RING("Prismatic Diamond Ring", SUBJECT_2923_DLC, RING),
	SPIRIT_STONE("Spirit Stone", SUBJECT_2923_DLC, RING),
	VANGUARD_RING("Vanguard Ring", SUBJECT_2923_DLC, RING),
	BLACK_CAT_BAND("Black Cat Band", SUBJECT_2923_DLC, RING),
	BRIGHT_STEEL_RING("Bright Steel Ring", SUBJECT_2923_DLC, RING),
	RING_OF_FLAWLESS_BEAUTY("Ring of Flawless Beauty", SUBJECT_2923_DLC, RING),
	// Traits
	ARCANE_STRIKE("Arcane Strike", FROM_THE_ASHES, TRAIT),
	BARK_SKIN("Bark Skin", FROM_THE_ASHES, TRAIT),
	CATALYST("Catalyst", FROM_THE_ASHES, TRAIT),
	COLD_AS_ICE("Cold as Ice", FROM_THE_ASHES, TRAIT),
	ELDER_KNOWLEDGE("Elder Knowledge", FROM_THE_ASHES, TRAIT),
	ENDURANCE("Endurance", FROM_THE_ASHES, TRAIT),
	EXECUTIONER("Executioner", FROM_THE_ASHES, TRAIT),
	EXPLOITER("Exploiter", FROM_THE_ASHES, TRAIT),
	GLUTTON("Glutton", FROM_THE_ASHES, TRAIT),
	GUARDIAN_S_BLESSING("Guardian's Blessing", FROM_THE_ASHES, TRAIT),
	HANDLING("Handling", FROM_THE_ASHES, TRAIT),
	KEEPER_S_BLESSING("Keeper's Blessing", FROM_THE_ASHES, TRAIT),
	KINGSLAYER("Kingslayer", FROM_THE_ASHES, TRAIT),
	MIND_S_EYE("Mind's Eye", FROM_THE_ASHES, TRAIT),
	MOTHER_S_BLESSING("Mother's Blessing", FROM_THE_ASHES, TRAIT),
	QUICK_HANDS("Quick Hands", FROM_THE_ASHES, TRAIT),
	RAPID_STRIKE("Rapid Strike", FROM_THE_ASHES, TRAIT),
	RECOVERY("Recovery", FROM_THE_ASHES, TRAIT),
	REVIVALIST("Revivalist", FROM_THE_ASHES, TRAIT),
	SCAVENGER("Scavenger", FROM_THE_ASHES, TRAIT),
	SHADOW_WALKER("Shadow Walker", FROM_THE_ASHES, TRAIT),
	SLEIGHT_OF_HAND("Sleight of Hand", FROM_THE_ASHES, TRAIT),
	SPIRIT("Spirit", FROM_THE_ASHES, TRAIT),
	SUSPICION("Suspicion", FROM_THE_ASHES, TRAIT),
	SWIFTNESS("Swiftness", FROM_THE_ASHES, TRAIT),
	TEAMWORK("Teamwork", FROM_THE_ASHES, TRAIT),
	TRIAGE("Triage", FROM_THE_ASHES, TRAIT),
	TRIGGER_HAPPY("Trigger Happy", FROM_THE_ASHES, TRAIT),
	VIGOR("Vigor", FROM_THE_ASHES, TRAIT),
	WARRIOR("Warrior", FROM_THE_ASHES, TRAIT),
	WILL_TO_LIVE("Will to Live", FROM_THE_ASHES, TRAIT),
	WORLD_WALKER("World Walker", FROM_THE_ASHES, TRAIT),
	BLOOD_BOND("Blood Bond", SWAMPS_OF_CORSUS_DLC, TRAIT),
	CONCENTRATION("Concentration", SWAMPS_OF_CORSUS_DLC, TRAIT),
	EVOCATION("Evocation", SWAMPS_OF_CORSUS_DLC, TRAIT),
	FOOTWORK("Footwork", SWAMPS_OF_CORSUS_DLC, TRAIT),
	FORTIFICATION("Fortification", SWAMPS_OF_CORSUS_DLC, TRAIT),
	INVOKER("Invoker", SWAMPS_OF_CORSUS_DLC, TRAIT),
	LUMINESCENT("Luminescent", SWAMPS_OF_CORSUS_DLC, TRAIT),
	POTENCY("Potency", SWAMPS_OF_CORSUS_DLC, TRAIT),
	ARMOR_PIERCER("Armor Piercer", SUBJECT_2923_DLC, TRAIT),
	WISDOM("Wisdom", SUBJECT_2923_DLC, TRAIT),
	FLASH_CASTER("Flash Caster", SUBJECT_2923_DLC, TRAIT),
	HARD_CHARGER("Hard Charger", SUBJECT_2923_DLC, TRAIT),
	TORMENTOR("Tormentor", SUBJECT_2923_DLC, TRAIT),
	LAST_RESORT("Last Resort", SUBJECT_2923_DLC, TRAIT),
	CLIMBER("Climber", SUBJECT_2923_DLC, TRAIT),
	VACCINE("Vaccine", SUBJECT_2923_DLC, TRAIT),
	DEMOLITIONIST("Demolitionist", SUBJECT_2923_DLC, TRAIT),
	SIPHONER("Siphoner", SUBJECT_2923_DLC, TRAIT),
	// Emotes
	BECKON_EMOTE("Beckon", HARDCORE_UPDATE, EMOTE),
	CHEER("Cheer", HARDCORE_UPDATE, EMOTE),
	CONFUSED("Confused", HARDCORE_UPDATE, EMOTE),
	EXHAUSTED("Exhausted", HARDCORE_UPDATE, EMOTE),
	FAIL("Fail", HARDCORE_UPDATE, EMOTE),
	FREEZE_FRAME("Freeze Frame", HARDCORE_UPDATE, EMOTE),
	GRAVEDIGGER("Gravedigger", HARDCORE_UPDATE, EMOTE),
	LAUGH("Laugh", HARDCORE_UPDATE, EMOTE),
	NO("No", HARDCORE_UPDATE, EMOTE),
	PRAISE_THE_GUN("Praise the Gun", HARDCORE_UPDATE, EMOTE),
	TEA_TIME("Tea Time", HARDCORE_UPDATE, EMOTE),
	THIS_WAY("This Way", HARDCORE_UPDATE, EMOTE),
	WAVE("Wave", HARDCORE_UPDATE, EMOTE),
	YES("Yes", HARDCORE_UPDATE, EMOTE),
	HIGH_FIVE("High Five", HARDCORE_UPDATE, EMOTE),
	// Resources
	// Weapons
	TENTACLE_POD("Tentacle Pod", FROM_THE_ASHES, RESOURCE),
	THERMAL_GEODE("Thermal Geode", FROM_THE_ASHES, RESOURCE),
	HIVESTONE("Hivestone", FROM_THE_ASHES, RESOURCE),
	BLAZING_HEART("Blazing Heart", FROM_THE_ASHES, RESOURCE),
	UNCLEAN_HEART("Unclean Heart", FROM_THE_ASHES, RESOURCE),
	TOTEM_ANTLER("Totem Antler", FROM_THE_ASHES, RESOURCE),
	VOID_SLIVER("Void Sliver", FROM_THE_ASHES, RESOURCE),
	DREAMER_S_MANA("Dreamer's Mana", FROM_THE_ASHES, RESOURCE),
	THE_UNDYING_HEART("The Undying Heart", FROM_THE_ASHES, RESOURCE),
	SPORE_GLAND("Spore Gland", FROM_THE_ASHES, RESOURCE),
	HAMMERHEAD_S_ORE("Hammerhead's Ore", FROM_THE_ASHES, RESOURCE),
	GUARDIAN_TENTACLE("Guardian Tentacle", FROM_THE_ASHES, RESOURCE),
	TWISTED_HEART("Twisted Heart", FROM_THE_ASHES, RESOURCE),
	STALKER_S_CLAW("Stalker's Claw", FROM_THE_ASHES, RESOURCE),
	DRAGON_LINKS("Dragon Links", FROM_THE_ASHES, RESOURCE),
	TEMPEST_HEARTSTRING("Tempest Heartstring", FROM_THE_ASHES, RESOURCE),
	STONE_OF_THE_GUARDIAN("Stone of the Guardian", FROM_THE_ASHES, RESOURCE),
	CRYSTALLINE_PLASMA("Crystalline Plasma", SWAMPS_OF_CORSUS_DLC, RESOURCE),
	STEEL_OF_AGONY("Steel of Agony", SUBJECT_2923_DLC, RESOURCE),
	ROOT_NEOPLASM("Root Neoplasm", SUBJECT_2923_DLC, RESOURCE),
	COLD_CELL("Cold Cell", SUBJECT_2923_DLC, RESOURCE),
	// Mods
	SENTINEL_SHARD("Sentinel Shard", FROM_THE_ASHES, RESOURCE),
	BLINK_SPEAR_SHARD("Blink Spear Shard", FROM_THE_ASHES, RESOURCE),
	RADIOACTIVE_SKULL("Radioactive Skull", FROM_THE_ASHES, RESOURCE),
	SLIME_VESSEL("Slime Vessel", FROM_THE_ASHES, RESOURCE),
	SHRAPNEL_SHARD("Shrapnel Shard", FROM_THE_ASHES, RESOURCE),
	DISPLACEMENT_CRYSTAL("Displacement Crystal", FROM_THE_ASHES, RESOURCE),
	HOUND_CHOKER("Hound Choker", FROM_THE_ASHES, RESOURCE),
	ANCIENT_CORE("Ancient Core", FROM_THE_ASHES, RESOURCE),
	FLESH_BARB("Flesh Bard", FROM_THE_ASHES, RESOURCE),
	SHADEWOOD("Shadewood", FROM_THE_ASHES, RESOURCE),
	HOLLOW_SEED("Hollow Seed", FROM_THE_ASHES, RESOURCE),
	KIN_CALLERS_BELL("Kin Callers Bell", FROM_THE_ASHES, RESOURCE),
	STORM_CRYSTAL("Storm Crystal", FROM_THE_ASHES, RESOURCE),
	SWARM_TUSK("Swarm Tusk", FROM_THE_ASHES, RESOURCE),
	BLACK_TEAR("Black Tear", FROM_THE_ASHES, RESOURCE),
	ZEPHYR_S_CONDUIT("Zephyr's Conduit", FROM_THE_ASHES, RESOURCE),
	LUMINOUS_GLAND("Luminous Gland", SWAMPS_OF_CORSUS_DLC, RESOURCE),
	BARBED_SINEW("Barbed Sinew", SWAMPS_OF_CORSUS_DLC, RESOURCE),
	ISKAL_HUSK("Iskal Husk", SWAMPS_OF_CORSUS_DLC, RESOURCE),
	JACKAL_S_IVORY("Jackal's Ivory", SUBJECT_2923_DLC, RESOURCE),
	GLACIAL_SCEPTER("Glacial Scepter", SUBJECT_2923_DLC, RESOURCE),
	SILVER_FRAGMENT("Silver Fragment", SUBJECT_2923_DLC, RESOURCE),
	OBRYK_S_BRACELET("Obryk's Bracelet", SUBJECT_2923_DLC, RESOURCE),
	// Main quest
	CAMPAIGN_EARTH(Biome.CITY_EARTH.displayName(), FROM_THE_ASHES, MAIN_QUEST),
	CAMPAIGN_THE_LABYRINTH(Biome.THE_LABYRINTH.displayName(), FROM_THE_ASHES, MAIN_QUEST),
	CAMPAIGN_RHOM(Biome.RHOM.displayName(), FROM_THE_ASHES, MAIN_QUEST),
	CAMPAIGN_CORSUS(Biome.CORSUS.displayName(), FROM_THE_ASHES, MAIN_QUEST),
	CAMPAIGN_YAESHA(Biome.YAESHA.displayName(), FROM_THE_ASHES, MAIN_QUEST),
	CAMPAIGN_FOUNDERS_PRISON("Founders Prison", FROM_THE_ASHES, MAIN_QUEST),
	CAMPAIGN_WARD_17(Biome.WARD_17.displayName(), FROM_THE_ASHES, MAIN_QUEST),
	// Zone templates
	FAIRVIEW(Zone.FAIRVIEW.displayName(), FROM_THE_ASHES, TEMPLATE),
	WESTCOURT(Zone.WESTCOURT.displayName(), FROM_THE_ASHES, TEMPLATE),
	THE_EASTERN_WIND(Zone.THE_EASTERN_WIND.displayName(), FROM_THE_ASHES, TEMPLATE),
	THE_SCOURING_WASTE(Zone.THE_SCOURING_WASTE.displayName(), FROM_THE_ASHES, TEMPLATE),
	THE_VERDANT_STRAND(Zone.THE_VERDANT_STRAND.displayName(), FROM_THE_ASHES, TEMPLATE),
	THE_SCALDING_GLADE(Zone.THE_SCALDING_GLADE.displayName(), FROM_THE_ASHES, TEMPLATE),
	THE_FETID_GLADE(Zone.THE_FETID_GLADE.displayName(), FROM_THE_ASHES, TEMPLATE),
	THE_MIST_FEN(Zone.THE_MIST_FEN.displayName(), FROM_THE_ASHES, TEMPLATE),
	// Misc actors
	/* Generated */ TAPE_RECORDER("Tape Recorder", FROM_THE_ASHES, PICKUP),
	/* Generated */ SUBMACHINE_GUN_PICKUP("Submachine Gun", FROM_THE_ASHES, PICKUP);

	@Getter private final String displayName;
	@Getter private final Origin origin;
	@Getter private final Type type;
}
