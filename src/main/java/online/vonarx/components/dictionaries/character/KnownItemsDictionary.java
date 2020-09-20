package online.vonarx.components.dictionaries.character;

import online.vonarx.constants.KnownActor;
import online.vonarx.dictionary.DictionaryWrapper;
import online.vonarx.dictionary.implementation.ChainDictionary;
import online.vonarx.dictionary.implementation.PartialKeyMapDictionary;

import javax.inject.Inject;

import static online.vonarx.constants.KnownActor.*;

public class KnownItemsDictionary extends DictionaryWrapper<String, KnownActor> {

	@Inject
	public KnownItemsDictionary() {
		super(ChainDictionary.<String, KnownActor>builder()
			.addDictionary(PartialKeyMapDictionary.<KnownActor>builder()
				// Skins
				.put("Armor_Head_Adventurer_Skin", SURVIVOR_GOOGLES_SKIN)
				.put("Armor_Body_Adventurer_Skin", SURVIVOR_TUNIC_SKIN)
				.put("Armor_Legs_Adventurer_Skin", SURVIVOR_LEGGINGS_SKIN)
				.put("Armor_Head_Akari_Skin", SHADOW_MASK_SKIN)
				.put("Armor_Body_Akari_Skin", SHADOW_GARB_SKIN)
				.put("Armor_Legs_Akari_Skin", SHADOW_LEGGINGS_SKIN)
				.put("Armor_Head_Bandit_Skin", BRIGAND_MASK_SKIN)
				.put("Armor_Body_Bandit_Skin", BRIGAND_JACKET_SKIN)
				.put("Armor_Legs_Bandit_Skin", BRIGAND_TROUSERS_SKIN)
				.put("Armor_Head_Cultist_Skin", RITUALIST_HAT_SKIN)
				.put("Armor_Body_Cultist_Skin", RITUALIST_DUSTER_SKIN)
				.put("Armor_Legs_Cultist_Skin", RITUALIST_BRITCHES_SKIN)
				.put("Armor_Head_Drifter_Skin", VAGRANT_MASK_SKIN)
				.put("Armor_Body_Drifter_Skin", VAGRANT_OVERCOAT_SKIN)
				.put("Armor_Legs_Drifter_Skin", VAGRANT_TROUSERS_SKIN)
				.put("Armor_Head_Elder_Skin", BLOODLETTER_HEADDRESS_SKIN)
				.put("Armor_Body_Elder_Skin", BLOODLETTER_RAIMENT_SKIN)
				.put("Armor_Legs_Elder_Skin", BLOODLETTER_LEGGINGS_SKIN)
				.put("Armor_Head_Hunter_Skin", WIDOWMAKER_SHROUD_SKIN)
				.put("Armor_Body_Hunter_Skin", WIDOWMAKER_TRENCHCOAT_SKIN)
				.put("Armor_Legs_Hunter_Skin", WIDOWMAKER_PANTS_SKIN)
				.put("Armor_Head_Osseous_Skin", HEADHUNTER_HELM_SKIN)
				.put("Armor_Body_Osseous_Skin", HEADHUNTER_HUSK_SKIN)
				.put("Armor_Legs_Osseous_Skin", HEADHUNTER_KILT_SKIN)
				.put("Armor_Head_Radiant_Skin", CRUSADER_VISAGE_SKIN)
				.put("Armor_Body_Radiant_Skin", CRUSADER_PROTECTOR_SKIN)
				.put("Armor_Legs_Radiant_Skin", CRUSADER_GREAVES_SKIN)
				.put("Armor_Head_Scrapper_Skin", ROUGHNECK_HELMET_SKIN)
				.put("Armor_Body_Scrapper_Skin", ROUGHNECK_BODYPLATE_SKIN)
				.put("Armor_Legs_Scrapper_Skin", ROUGHNECK_WORKBOOTS_SKIN)
				.put("Armor_Head_Slayer_Skin", HARBRINGER_MASK_SKIN)
				.put("Armor_Body_Slayer_Skin", HARBRINGER_MANTLE_SKIN)
				.put("Armor_Legs_Slayer_Skin", HARBRINGER_BOOTS_SKIN)
				.put("Armor_Head_Twisted_Skin", CORRUPTED_HOOD_SKIN)
				.put("Armor_Body_Twisted_Skin", CORRUPTED_CAGE_SKIN)
				.put("Armor_Legs_Twisted_Skin", CORRUPTED_TASSETS_SKIN)
				.put("Armor_Head_Void_Skin", CHAOS_SKULL_SKIN)
				.put("Armor_Body_Void_Skin", CHAOS_CARAPACE_SKIN)
				.put("Armor_Legs_Void_Skin", CHAOS_GREAVES_SKIN)
				.put("Armor_Head_Leto_Skin", SENTINEL_HELMET_SKIN)
				.put("Armor_Body_Leto_Skin", SENTINEL_ARMOR_SKIN)
				.put("Armor_Legs_Leto_Skin", SENTINEL_LEGGINGS_SKIN)
				.put("Armor_Head_Carapace_Skin", VANGUARD_GREAT_HELM_SKIN)
				.put("Armor_Body_Carapace_Skin", VANGUARD_SHELL_SKIN)
				.put("Armor_Legs_Carapace_Skin", VANGUARD_GREAVES_SKIN)
				.put("Armor_Head_Labyrinth_Skin", MYSTIC_HELM_SKIN)
				.put("Armor_Body_Labyrinth_Skin", MYSTIC_ARMOR_SKIN)
				.put("Armor_Legs_Labyrinth_Skin", MYSTIC_GREAVES_SKIN)
				.build())
			.addDictionary(PartialKeyMapDictionary.<KnownActor>builder()
				// Armor
				.put("Armor_Head_Adventurer", ADVENTURER_GOGGLES)
				.put("Armor_Body_Adventurer", ADVENTURER_TUNIC)
				.put("Armor_Legs_Adventurer", ADVENTURER_LEGGINGS)
				.put("Armor_Head_Akari", AKARI_MASK)
				.put("Armor_Body_Akari", AKARI_GARB)
				.put("Armor_Legs_Akari", AKARI_LEGGINGS)
				.put("Armor_Head_Bandit", BANDIT_S_MASK)
				.put("Armor_Body_Bandit", BANDIT_JACKET)
				.put("Armor_Legs_Bandit", BANDIT_TROUSERS)
				.put("Armor_Head_Bomber", BOMBER_HAT)
				.put("Armor_Head_Cultist", CULTIST_HAT)
				.put("Armor_Body_Cultist", CULTIST_DUSTER)
				.put("Armor_Legs_Cultist", CULTIST_BRITCHES)
				.put("Armor_Head_Drifter", DRIFTER_S_MASK)
				.put("Armor_Body_Drifter", DRIFTER_S_OVERCOAT)
				.put("Armor_Legs_Drifter", DRIFTER_S_TROUSERS)
				.put("Armor_Head_Elder", ELDER_HEADDRESS)
				.put("Armor_Body_Elder", ELDER_RAIMENT)
				.put("Armor_Legs_Elder", ELDER_LEGGINGS)
				.put("Armor_Head_Hunter", HUNTER_SHROUD)
				.put("Armor_Body_Hunter", HUNTER_TRENCHCOAT)
				.put("Armor_Legs_Hunter", HUNTER_PANTS)
				.put("Armor_Head_Osseous", OSSEOUS_HELM)
				.put("Armor_Body_Osseous", OSSEOUS_HUSK)
				.put("Armor_Legs_Osseous", OSSEOUS_KILT)
				.put("Armor_Head_Radiant", RADIANT_VISAGE)
				.put("Armor_Body_Radiant", RADIANT_PROTECTOR)
				.put("Armor_Legs_Radiant", RADIANT_GREAVES)
				.put("Armor_Head_Scrapper", SCRAPPER_HELMET)
				.put("Armor_Body_Scrapper", SCRAPPER_BODYPLATE)
				.put("Armor_Legs_Scrapper", SCRAPPER_WORKBOOTS)
				.put("Armor_Head_Slayer", SLAYER_MASK)
				.put("Armor_Body_Slayer", SLAYER_MANTLE)
				.put("Armor_Legs_Slayer", SLAYER_BOOTS)
				.put("Quest_TwistedMask", TWISTED_MASK)
				.put("Armor_Head_Twisted", TWISTED_HOOD)
				.put("Armor_Body_Twisted", TWISTED_CAGE)
				.put("Armor_Legs_Twisted", TWISTED_TASSETS)
				.put("Armor_Head_Void", VOID_SKULL)
				.put("Armor_Body_Void", VOID_CARAPACE)
				.put("Armor_Legs_Void", VOID_GREAVES)
				// Leto's Lab
				.put("Armor_Head_Leto", LETO_S_HELMET)
				.put("Armor_Body_Leto", LETO_S_ARMOR)
				.put("Armor_Legs_Leto", LETO_S_LEGGINGS)
				// Swamps of Corsus
				.put("Armor_Head_Carapace", CARAPACE_GREAT_HELM)
				.put("Armor_Body_Carapace", CARAPACE_SHELL)
				.put("Armor_Legs_Carapace", CARAPACE_GREAVES)
				.put("Armor_Head_Labyrinth", LABYRINTH_HELM)
				.put("Armor_Body_Labyrinth", LABYRINTH_ARMOR)
				.put("Armor_Legs_Labyrinth", LABYRINTH_GREAVES)
				// Weapons
				// Hand Guns
				.put("Weapon_HuntingPistol", HUNTING_PISTOL)
				.put("Weapon_Revolver", MAGNUM_REVOLVER)
				.put("Weapon_RepeaterPistol", REPEATER_PISTOL)
				.put("Weapon_Submachinegun", SUBMACHINE_GUN)
				// Crafted Guns
				.put("Weapon_Pan_CurseOfTheJungleGod", CURSE_OF_THE_JUNGLE_GOD)
				/* TODO verify */.put("Resource_Pan_TentaclePod", TENTACLE_POD)
				.put("Weapon_Wasteland_Defiler", DEFILER)
				/* TODO verify */.put("Resource_Wasteland_ThermalGeode", THERMAL_GEODE)
				.put("Weapon_Swamp_HiveCannon", HIVE_CANNON)
				/* TODO verify */.put("Resource_Swamp_Hivestone", HIVESTONE)
				.put("Weapon_Root_Spitfire", SPITFIRE)
				/* TODO verify */.put("Resource_CIty_BlazingHeart", BLAZING_HEART)
				// Swamps of Corsus
				// Crafted Guns
				.put("Weapon_Swamp_PrideOfTheIskal", PRIDE_OF_THE_ISKAL)
				.put("Resource_Swamp_CrystallinePlasma", CRYSTALLINE_PLASMA)
				// Long Guns
				.put("Weapon_AssaultRifle", ASSAULT_RIFLE)
				.put("Weapon_Wasteland_BeamRifle", BEAM_RIFLE)
				.put("Weapon_Machinegun", CHICAGO_TYPEWRITER)
				.put("Weapon_Coachgun", COACH_GUN)
				.put("Weapon_Swamp_Crossbow", CROSSBOW)
				.put("Weapon_HuntingRifle", HUNTING_RIFLE)
				.put("Weapon_Pan_RicochetRifle", RICOCHET_RIFLE)
				.put("Weapon_Shotgun", SHOTGUN)
				.put("Weapon_SniperRifle", SNIPER_RIFLE)
				// Subject 2923
				.put("Weapon_Rural_FusionRifle", FUSION_RIFLE)
				// Crafted Guns
				.put("Weapon_Swamp_Devastator", DEVASTATOR)
				/* TODO verify */.put("Resource_Swamp_UncleanHeart", UNCLEAN_HEART)
				.put("Weapon_Pan_EyeOfTheStorm", EYE_OF_THE_STORM)
				/* TODO verify */.put("Resource_Pan_TotemAntler", TOTEM_ANTLER)
				.put("Weapon_Wasteland_ParticleAccelerator", PARTICLE_ACCELERATOR)
				/* TODO verify */.put("Resource_Wasteland_VoidSliver", VOID_SLIVER)
				.put("Weapon_Atoll_Repulsor", REPULSOR)
				.put("Resource_Atoll_DreamersMana", DREAMER_S_MANA)
				.put("Weapon_Wasteland_Ruin", RUIN)
				/* TODO verify */.put("Resource_Wasteland_TheUndyingHeart", THE_UNDYING_HEART)
				.put("Weapon_Root_SporeLauncher", SPOREBLOOM)
				/* TODO verify */.put("Resource_Root_SporeGland", SPORE_GLAND)
				// Melee Weapons
				// "Blade of Adventure" is a tutorial only weapon
				.put("Weapon_Wasteland_LostHarpoon", LOST_HARPOON)
				.put("Weapon_Wasteland_Riven", RIVEN)
				.put("Weapon_Hammer", SCRAP_HAMMER)
				.put("Weapon_Hatchet", SCRAP_HATCHET)
				.put("Weapon_Sword", SCRAP_SWORD)
				.put("Weapon_Swamp_Scythe", SCYTHE)
				.put("Weapon_Pan_Spear", SPEAR)
				.put("Weapon_Wasteland_Flail", WASTELANDER_FLAIL)
				// Crafted Weapons
				.put("Weapon_Swamp_ButchersFlail", BUTCHERS_FLAIL)
				/* TODO verify */.put("Resource_Swamp_HammerheadsOre", HAMMERHEAD_S_ORE)
				.put("Weapon_Swamp_GuardianAxe", GUARDIAN_AXE)
				/* TODO verify */.put("Resource_Swamp_GuardianTentacle", GUARDIAN_TENTACLE)
				.put("Weapon_Root_PetrifiedMaul", PETRIFIED_MAUL)
				/* TODO verify */.put("Resource_Root_TwistedHeart", TWISTED_HEART)
				.put("Weapon_Pan_ScarOfTheJungleGod", SCAR_OF_THE_JUNGLE_GOD)
				/* TODO verify */.put("Resource_Pan_StalkersClaw", STALKER_S_CLAW)
				.put("Weapon_Root_Smolder", SMOLDER)
				.put("Resource_CIty_DragonLinks", DRAGON_LINKS)
				.put("Weapon_Pan_VoiceOfTheTempest", VOICE_OF_THE_TEMPEST)
				.put("Resource_Pan_TempestHeartString", TEMPEST_HEARTSTRING)
				.put("Weapon_Wasteland_WorldBreaker", WORLD_BREAKER)
				.put("Resource_Wasteland_StoneOfTheGuardian", STONE_OF_THE_GUARDIAN)
				// Swamps of Corsus
				.put("Weapon_HerosSword", HERO_S_SWORD)
				// Subject 2923
				.put("Weapon_Snow_ChainBlade", CHAIN_BLADE)
				.put("Resource_Snow_SteelOfAgony", STEEL_OF_AGONY)
				/* TODO verify */.put("Weapon_Rural_WorldsEdge", WORLD_S_EDGE)
				.put("Resource_Rural_RootNeoplasm", ROOT_NEOPLASM)
				// Mods
				.put("Mod_Hotshot", HOT_SHOT)
				.put("Mod_HuntersMark", HUNTER_S_MARK)
				.put("Mod_MendersAura", MENDER_S_AURA)
				// Crafted Mods
				.put("Mod_Beckon", BECKON_MOD)
				/* TODO verify */.put("Resource_Wasteland_SentinelShard", SENTINEL_SHARD)
				.put("Mod_BlinkToken", BLINK_TOKEN)
				/* TODO verify */.put("Resource_Pan_BlinkSpearShard", BLINK_SPEAR_SHARD)
				.put("Mod_BreathOfTheDesert", BREATH_OF_THE_DESERT)
				/* TODO verify */.put("Resource_Wasteland_RadioactiveSkull", RADIOACTIVE_SKULL)
				.put("Mod_CorrosiveAura", CORROSIVE_AURA)
				/* TODO verify */.put("Resource_Swamp_SlimeVessel", SLIME_VESSEL)
				.put("Mod_ExplosiveShot", EXPLOSIVE_SHOT)
				/* TODO verify */.put("Resource_CIty_ShrapnelShard", SHRAPNEL_SHARD)
				.put("Mod_FlickerCloak", FLICKER_CLOAK)
				/* TODO verify */.put("Resource_CIty_DisplacementCrystal", DISPLACEMENT_CRYSTAL)
				.put("Mod_HowlersImmunity", HOWLER_S_IMMUNITY)
				/* TODO verify */.put("Resource_Wasteland_HoundChoker", HOUND_CHOKER)
				.put("Mod_IronSentinel", IRON_SENTINEL)
				/* TODO verify */.put("Resource_Wasteland_AncientCore", ANCIENT_CORE)
				.put("Mod_MantleOfThorns", MANTLE_OF_THORNS)
				/* TODO verify */.put("Resource_CIty_FleshBarb", FLESH_BARB)
				.put("Mod_RattleWeed", RATTLE_WEED)
				/* TODO verify */.put("Resource_CIty_Shadewood", SHADEWOOD)
				.put("Mod_SeedCaller", SEED_CALLER)
				/* TODO verify */.put("Resource_CIty_HollowSeed", HOLLOW_SEED)
				.put("Mod_SongOfSwords", SONG_OF_SWORDS)
				/* TODO verify */.put("Resource_Pan_KinCallersBell", KIN_CALLERS_BELL)
				.put("Mod_StormCaller", STORMCALLER_MOD)
				/* TODO verify */.put("Resource_Pan_StormCrystal", STORM_CRYSTAL)
				.put("Mod_Swarm", SWARM)
				/* TODO verify */.put("Resource_Swamp_SwarmTusk", SWARM_TUSK)
				.put("Mod_VeilOfTheBlackTear", VEIL_OF_THE_BLACK_TEAR)
				/* TODO verify */.put("Resource_Wasteland_BlackTear", BLACK_TEAR)
				.put("Mod_WildfireShot", WILDFIRE_SHOT)
				/* TODO verify */.put("Resource_Pan_ZephyrsConduit", ZEPHYR_S_CONDUIT)
				// Static Mods
				.put("Mod_Banish", BANISH)
				.put("Mod_Flamethrower", FLAME_THROWER)
				.put("Mod_GravityCoreShot", GRAVITY_CORE)
				.put("Mod_HiveShot", HIVE_SHOT)
				.put("Mod_RadioactiveVolley", RADIOACTIVE_VOLLEY)
				.put("Mod_Skewer", SKEWER)
				.put("Mod_SporeShot", SPORE_SHOT)
				.put("Mod_StaticFieldShot", STATIC_FIELD_SHOT)
				.put("Mod_TentacleShot", TENTACLE_SHOT)
				.put("Mod_Undying", UNDYING)
				// Swamps of Corsus
				// Crafted Mods
				.put("Mod_RiftWalker", RIFT_WALKER)
				/* TODO verify */.put("Resource_Swamp_LuminousGland", LUMINOUS_GLAND)
				.put("Mod_UnstableQuills", UNSTABLE_QUILLS)
				/* TODO verify */.put("Resource_Swamp_BarbedSinew", BARBED_SINEW)
				.put("Mod_Seeker", SEEKER)
				.put("Resource_Swamp_IskalHusk", ISKAL_HUSK)
				// Static Mods
				.put("Mod_Vampiric", VAMPIRIC)
				// Subject 2923
				// Crafted Mods
				.put("Mod_ColdSpear", COLD_SPEAR)
				.put("Resource_Snow_JackalsIvory", JACKAL_S_IVORY)
				/* TODO verify */.put("Mod_Blizzard", BLIZZARD)
				.put("Resource_Snow_GlacialScepter", GLACIAL_SCEPTER)
				// Static Mods
				.put("Mod_FusionCannon", FUSION_CANNON)
				// Amulets
				.put("Trinket_BrutalMark", BRUTAL_MARK)
				.put("Trinket_ButchersFetish", BUTCHER_S_FETISH)
				.put("Trinket_CleansingJewel", CLEANSING_JEWEL)
				.put("Trinket_GalenicCharm", GALENIC_CHARM)
				.put("Trinket_GunslingersCharm", GUNSLINGER_S_CHARM)
				.put("Trinket_LetosAmulet", LETO_S_AMULET)
				.put("Trinket_MendersCharm", MENDER_S_CHARM)
				.put("Quest_BrabusPocketWatch", POCKET_WATCH)
				.put("Trinket_RockOfAnguish", ROCK_OF_ANGUISH)
				.put("Trinket_StormAmulet", STORM_AMULET)
				.put("Trinket_TwistedIdol", TWISTED_IDOL)
				.put("Trinket_SoulAnchor", SOUL_ANCHOR)
				.put("Trinket_ScavengersBauble", SCAVENGER_S_BAUBLE)
				.put("Trinket_VengeanceIdol", VENGEANCE_IDOL)
				.put("Trinket_NightmareSpiral", NIGHTMARE_SPIRAL)
				// Swamps of Corsus
				/* TODO verify */.put("Trinket_RustedAmulet", RUSTED_AMULET)
				.put("Trinket_TalismanOfAnimosity", TALISMAN_OF_ANIMOSITY)
				.put("Trinket_HeartOfDarkness", HEART_OF_DARKNESS)
				.put("Trinket_AmuletOfEpicaricacy", AMULET_OF_EPICARICACY)
				.put("Trinket_DaredevilsCharm", DAREDEVIL_S_CHARM)
				.put("Trinket_BlackRose", BLACK_ROSE)
				.put("Trinket_TalismanOfPerseverance", TALISMAN_OF_PERSEVERANCE)
				// Subject 2923
				.put("Trinket_RazorwireNecklace", RAZORWIRE_NECKLACE)
				.put("Trinket_HangmansMemento", HANGMAN_S_MOMENTO)
				/* TODO verify */.put("Trinket_AbrasiveAmulet", ABRASIVE_AMULET)
				.put("Trinket_Driftstone", DRIFTSTONE)
				// Rings
				.put("Trinket_AkariWarBand", AKARI_WAR_BAND)
				.put("Trinket_BandOfAccord", BAND_OF_ACCORD)
				.put("Trinket_BandOfStrength", BAND_OF_STRENGTH)
				.put("Trinket_BloodFont", BLOOD_FONT)
				.put("Trinket_BraidedThorns", BRAIDED_THORNS)
				.put("Trinket_CelerityStone", CELERITY_STONE)
				.put("Trinket_DevouringLoop", DEVOURING_LOOP)
				.put("Trinket_EmpoweringLoop", EMPOWERING_LOOP)
				.put("Trinket_EzlansBand", EZLAN_S_BAND)
				.put("Trinket_GravityStone", GRAVITY_STONE)
				.put("Trinket_GuardiansRing", GUARDIAN_S_RING)
				.put("Trinket_HeartSeeker", HEARTSEEKER)
				.put("Trinket_HeartOfTheWolf", HEART_OF_THE_WOLF)
				.put("Trinket_HuntersBand", HUNTER_S_BAND)
				.put("Trinket_HuntersHalo", HUNTER_S_HALO)
				.put("Trinket_JewelOfTheBlackSun", JEWEL_OF_THE_BLACK_SUN)
				.put("Trinket_KeepersRing", KEEPER_S_RING)
				.put("Trinket_LeechEmber", LEECH_EMBER)
				.put("Trinket_MothersRing", MOTHER_S_RING)
				.put("Trinket_PillarOfStone", PILLAR_OF_STONE)
				.put("Trinket_ProvisionerRing", PROVISIONER_RING)
				.put("Trinket_Razorstone", RAZORSTONE)
				.put("Trinket_RingOfEvasion", RING_OF_EVASION)
				.put("Trinket_RingOfSupremacy", RING_OF_SUPREMACY)
				.put("Trinket_RingOfTheAdmiral", RING_OF_THE_ADMIRAL)
				.put("Trinket_RootCirclet", ROOT_CIRCLET)
				.put("Trinket_Sagestone", SAGESTONE)
				.put("Trinket_StoneOfBalance", STONE_OF_BALANCE)
				// Swamps of Corsus
				/* TODO verify */.put("Trinket_AggressorsBane", AGGRESSOR_S_BANE)
				/* TODO verify */.put("Trinket_BandOfCastor", BAND_OF_CASTOR)
				/* TODO verify */.put("Trinket_BandOfPollux", BAND_OF_POLLUX)
				/* TODO verify */.put("Trinket_CompulsionLoop", COMPULSION_LOOP)
				/* TODO verify */.put("Trinket_DeceiversBand", DECEIVER_S_BAND)
				.put("Trinket_GiftOfTheIskal", GIFT_OF_THE_ISKAL)
				.put("Trinket_GrimCoil", GRIM_COIL)
				/* TODO verify */.put("Trinket_GunslingersRing", GUNSLINGER_S_RING)
				.put("Trinket_HerosRing", HERO_S_RING)
				.put("Trinket_IskalHunterBand", ISKAL_HUNTER_BAND)
				.put("Trinket_LoopOfProsperity", LOOP_OF_PROSPERITY)
				/* TODO verify */.put("Trinket_PearlOfLuminescence", PEARL_OF_LUMINESCENCE)
				/* TODO verify */.put("Trinket_RingOfElusion", RING_OF_ELUSION)
				/* TODO verify */.put("Trinket_RingOfShadows", RING_OF_SHADOWS)
				/* TODO verify */.put("Trinket_RingOfTheMantis", RING_OF_THE_MANTIS)
				/* TODO verify */.put("Trinket_RingOfTheUnclean", RING_OF_THE_UNCLEAN)
				.put("Trinket_SoulEmber", SOUL_EMBER)
				/* TODO verify */.put("Trinket_SoulLink", SOUL_LINK)
				.put("Trinket_StockpileCirclet", STOCKPILE_CIRCLET)
				// Subject 2923
				.put("Trinket_FiveFingeredRing", FIVE_FINGERED_RING)
				/* TODO verify */.put("Trinket_BurdenOfTheDevoted", BURDEN_OF_THE_DEVOTED)
				.put("Trinket_VolatileGem", VOLATILE_GEM)
				.put("Trinket_AmberMoonstone", AMBER_MOONSTONE)
				// Traits
				.put("Trait_ArcaneStrike", ARCANE_STRIKE)
				.put("Trait_BarkSkin", BARK_SKIN)
				.put("Trait_Catalyst", CATALYST)
				.put("Trait_ColdAsIce", COLD_AS_ICE)
				.put("Trait_ElderKnowledge", ELDER_KNOWLEDGE)
				.put("Trait_Endurance", ENDURANCE)
				.put("Trait_Executioner", EXECUTIONER)
				.put("Trait_Exploiter", EXPLOITER)
				.put("Trait_Glutton", GLUTTON)
				.put("Trait_GuardiansBlessing", GUARDIAN_S_BLESSING)
				.put("Trait_Handling", HANDLING)
				.put("Trait_KeepersBlessing", KEEPER_S_BLESSING)
				.put("Trait_Kingslayer", KINGSLAYER)
				.put("Trait_MindsEye", MIND_S_EYE)
				.put("Trait_MothersBlessing", MOTHER_S_BLESSING)
				.put("Trait_QuickHands", QUICK_HANDS)
				.put("Trait_RapidStrike", RAPID_STRIKE)
				.put("Trait_Recovery", RECOVERY)
				.put("Trait_Revivalist", REVIVALIST)
				.put("Trait_Scavenger", SCAVENGER)
				.put("Trait_ShadowWalker", SHADOW_WALKER)
				.put("Trait_SleightOfHand", SLEIGHT_OF_HAND)
				.put("Trait_Spirit", SPIRIT)
				.put("Trait_Suspicion", SUSPICION)
				.put("Trait_Swiftness", SWIFTNESS)
				.put("Trait_Teamwork", TEAMWORK)
				.put("Trait_Triage", TRIAGE)
				.put("Trait_TriggerHappy", TRIGGER_HAPPY)
				.put("Trait_Vigor", VIGOR)
				.put("Trait_Warrior", WARRIOR)
				.put("Trait_WillToLive", WILL_TO_LIVE)
				.put("Trait_WorldWalker", WORLD_WALKER)
				// Swamps of Corsus
				.put("Trait_BloodBond", BLOOD_BOND)
				.put("Trait_Concentration", CONCENTRATION)
				.put("Trait_Evocation", EVOCATION)
				.put("Trait_Footwork", FOOTWORK)
				.put("Trait_Fortification", FORTIFICATION)
				.put("Trait_Invoker", INVOKER)
				.put("Trait_Luminescent", LUMINESCENT)
				/* TODO verify */.put("Trait_Potency", POTENCY)
				// Subject 2923
				.put("Trait_ArmorPiercer", ARMOR_PIERCER)
				.put("Trait_Wisdom", WISDOM)
				.put("Trait_FlashCaster", FLASH_CASTER)
				.put("Trait_HardCharger", HARD_CHARGER)
				.put("Trait_Tormentor", TORMENTOR)
				.put("Trait_LastResort", LAST_RESORT)
				// Emotes
				.put("Emote_Beckon", BECKON_EMOTE)
				.put("Emote_Cheer", CHEER)
				.put("Emote_Confused", CONFUSED)
				.put("Emote_Exhausted", EXHAUSTED)
				.put("Emote_Fail", FAIL)
				.put("Emote_FreezeFrame", FREEZE_FRAME)
				.put("Emote_Gravedigger", GRAVEDIGGER)
				.put("Emote_HighFive", HIGH_FIVE)
				/* TODO verify */.put("Emote_Laugh", LAUGH)
				.put("Emote_No", NO)
				.put("Emote_PraiseTheGun", PRAISE_THE_GUN)
				.put("Emote_TeaTime", TEA_TIME)
				.put("Emote_ThisWay", THIS_WAY)
				.put("Emote_Wave", WAVE)
				.put("Emote_Yes", YES)
				.build())
			.build());
	}
}
