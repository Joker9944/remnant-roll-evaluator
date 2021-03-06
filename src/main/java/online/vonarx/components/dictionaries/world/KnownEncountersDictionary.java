package online.vonarx.components.dictionaries.world;

import online.vonarx.constants.KnownActor;
import online.vonarx.dictionary.DictionaryWrapper;
import online.vonarx.dictionary.implementation.ChainDictionary;
import online.vonarx.dictionary.implementation.PartialKeyMapDictionary;
import online.vonarx.dictionary.implementation.RegExKeyMapDictionary;

import javax.inject.Inject;

import static online.vonarx.constants.KnownActor.*;

public class KnownEncountersDictionary extends DictionaryWrapper<String, KnownActor> {

	@Inject
	public KnownEncountersDictionary() {
		super(ChainDictionary.<String, KnownActor>builder()
			.addDictionary(PartialKeyMapDictionary.<KnownActor>builder()
				// City bosses
				.put("Quest_MiniBoss_RootBrute", GOREFIST)
				.put("Quest_MiniBoss_RootWraith", SHROUD)
				.put("Quest_MiniBoss_RootTumbleweed", THE_MANGLER)
				.put("Quest_MiniBoss_Splitter", RIPHIDE)
				.put("Quest_MiniBoss_Brabus", BRABUS)
				.put("Quest_Boss_RootEnt", THE_ENT)
				.put("Quest_Boss_RootDragon", SINGE)
				// Wasteland bosses
				.put("Quest_Miniboss_Sentinel", RAZE)
				.put("Quest_Miniboss_SwarmMaster", SCOURGE)
				.put("Quest_Miniboss_HoundMaster", MAUL)
				.put("Quest_Miniboss_Vyr", SHADE_AND_SHATTER)
				.put("Quest_Boss_WastelandGuardian", CLAVIGER)
				.put("Quest_Boss_TheHarrow", THE_HARROW)
				.put("Quest_Boss_UndyingKing", UNDYING_KING)
				// Swamp bosses
				.put("Quest_MiniBoss_Tyrant", THE_THRALL)
				.put("Quest_MiniBoss_SlimeHulk", CANKER)
				.put("Quest_Boss_Fatty", THE_UNCLEAN_ONE)
				.put("Quest_Boss_SwampGuardian", IXILLIS)
				// Jungle bosses
				.put("Quest_MiniBoss_KinCaller", THE_WARDEN)
				.put("Quest_Miniboss_StormCaller", STORMCALLER_BOSS)
				.put("Quest_Miniboss_ImmolatorAndZephyr", SCALD_AND_SEAR)
				.put("Quest_MiniBoss_BlinkFiend", ONSLAUGHT)
				.put("Quest_SmallD_BlinkThief", BLINK_THIEF)
				.put("Quest_Boss_TotemFather", TOTEM_FATHER)
				.put("Quest_Boss_Wolf", THE_RAVAGER)
				// Earth quests
				.put("Quest_OverworldPOI_MudTooth", MUD_TOOTH)
				.put("Quest_OverworldPOI_Settlement", SETTLEMENT)
				.put("Quest_OverworldPOI_WailingWood", WAILING_WOOD)
				.put("Quest_Siege_RootShrine", THE_ROOT_SHRINE)
				.put("Quest_Siege_LizAndLiz", A_TALE_OF_TWO_LIZ_S)
				.put("Quest_SmallD_MadMerchant", TWISTED_MASK_MERCHANT)
				.put("Quest_SmallD_HuntersHideout", HUNTER_S_HIDEOUT)
				.put("Quest_SmallD_LastWill", SUPPLY_RUN)
				.put("Quest_SmallD_RootCultist", CULT_OF_THE_ROOT)
				.put("Quest_Church", THE_ROOT_MOTHER)
				// Wasteland quests
				.put("Quest_OverworldPOI_Monolith", MONOLITH)
				.put("Quest_OverworldPOI_OldManAndConstruct", WUD)
				.put("Quest_Siege_TheLostGantry", THE_LOST_GANTRY)
				.put("Quest_SmallD_TheCleanRoom", THE_CLEAN_ROOM)
				.put("Quest_SmallD_ArmorVault", VAULT_OF_THE_HERALD)
				.put("Quest_OverworldPOI_Cryptolith_Wasteland", CRYPTOLITH_RHOM)
				// Jungle quests
				.put("Quest_OverworldPOI_Flautist", FLAUTIST)
				.put("Quest_OverworldPOI_Ruins", RUINS)
				.put("Quest_Siege_WolfShrine", WOLF_SHRINE)
				.put("Quest_Siege_TheRisen", THE_RISEN)
				.put("Quest_SmallD_DoeShrine", RED_DOE_SHRINE)
				.put("Quest_Pan_Jungle_Ambush", FIGHT_WITH_THE_REBELS)
				// Quest items
				.put("Quest_Event_ReggiesRing", TARNISHED_RING)
				.put("Quest_Event_AcesCoin", STRANGE_COIN)
				// Misc items
				.put("Quest_Event_Simulacrum", SIMULACRUM)
				.put("Quest_Event_TraitBook", TOME_OF_KNOWLEDGE)
				.put("Quest_Event_DrifterMask", DRIFTER_S_MASK)
				// Amulets
				.put("Quest_Event_GunslingersCharm", GUNSLINGER_S_CHARM)
				.put("Quest_Event_CleansingJewel", CLEANSING_JEWEL)
				.put("Quest_Event_GalenicCharm", GALENIC_CHARM)
				.put("Quest_Event_MendersCharm", MENDER_S_CHARM)
				.put("Quest_Event_ButchersFetish", BUTCHER_S_FETISH)
				.put("Quest_Event_StormAmulet", STORM_AMULET)
				.put("Quest_Event_VengeanceIdol", VENGEANCE_IDOL)
				.put("Quest_Event_BrutalMark", BRUTAL_MARK)
				.put("Quest_Event_RockOfAnguish", ROCK_OF_ANGUISH)
				.put("Quest_Event_Penitent", LETO_S_AMULET)
				// Rings
				.put("Quest_Event_HeartSeeker", HEARTSEEKER)
				.put("Quest_Event_PillarOfStone", PILLAR_OF_STONE)
				.put("Quest_Event_BandOfStrength", BAND_OF_STRENGTH)
				.put("Quest_Event_EzlansBand", EZLAN_S_BAND)
				.put("Quest_Event_GravityStone", GRAVITY_STONE)
				.put("Quest_Event_HuntersHalo", HUNTER_S_HALO)
				.put("Quest_Event_JewelOfTheBlackSun", JEWEL_OF_THE_BLACK_SUN)
				.put("Quest_Event_DevouringLoop", DEVOURING_LOOP)
				.put("Quest_Event_HeartOfTheWolf", HEART_OF_THE_WOLF)
				.put("Quest_Event_HuntersBand", HUNTER_S_BAND)
				.put("Quest_Event_KeepersRing", KEEPER_S_RING)
				.put("Quest_Event_StoneOfBalance", STONE_OF_BALANCE)
				.put("Quest_Event_RingOfEvasion", RING_OF_EVASION)
				.put("Quest_Event_LeechEmber", LEECH_EMBER)
				.put("Quest_Event_CelerityStone", CELERITY_STONE)
				.put("Quest_Event_GuardiansRing", GUARDIAN_S_RING)
				.put("Quest_Event_SageStone", SAGESTONE)
				.put("Quest_Event_MothersRing", MOTHER_S_RING)
				.put("Quest_Event_RazorStone", RAZORSTONE)
				.put("Quest_Event_BloodFont", BLOOD_FONT)
				// Swamps of Corsus
				// Bosses
				.put("Quest_MiniBoss_FlickeringHorror", DREAM_EATER)
				.put("Quest_MiniBoss_BarbTerror", BARBED_TERROR)
				.put("Quest_SmallD_QueensTemple", ISKAL_QUEEN_ADVENTURE)
				// Quests
				.put("Quest_OverworldPOI_AbandonedThrone", ABANDONED_THRONE)
				.put("Quest_OverWorldPOI_GraveyardElf", GRAVEYARD_ELF)
				.put("Quest_Siege_BrainBug", A_SMART_BUG)
				.put("Quest_SmallD_FetidPool", FETID_POOL)
				.put("Quest_SmallD_Wisp", WISPS)
				// Misc items
				// TODO what is "Quest_Event_Sketterling_Temple"
				.put("Quest_Event_Sketterling_Temple", SKETTERLING)
				// Amulets
				.put("Quest_Event_TalismanOfAnimosity", TALISMAN_OF_ANIMOSITY)
				// Rings
				.put("Quest_Event_BandOfPollux", BAND_OF_POLLUX)
				.put("Quest_Event_GunslignersRing", GUNSLINGER_S_RING)
				.put("Quest_Event_PearlOfLuminescence", PEARL_OF_LUMINESCENCE)
				.put("Quest_Event_CompulsionLoop", COMPULSION_LOOP)
				.put("Quest_Event_RingOfShadows", RING_OF_SHADOWS)
				.put("Quest_Event_BandOfCastor", BAND_OF_CASTOR)
				.put("Quest_Event_AggressorsBane", AGGRESSOR_S_BANE)
				.put("Quest_Event_DeceiversBand", DECEIVER_S_BAND)
				.put("Quest_Event_RingOfElusion", RING_OF_ELUSION)
				.put("Quest_Event_StockpileCirclet", STOCKPILE_CIRCLET)
				// Subject 2923
				// Bosses
				.put("Quest_MiniBoss_TheJackal", ERFOR_THE_JACKAL)
				.put("Quest_MiniBoss_BlizzardMage", IKRO_THE_ICE_CONJURER)
				.put("Quest_MiniBoss_UrikkiBlademasters", TIAN_THE_ASSASSIN)
				.put("Quest_MiniBoss_ShieldWarden", OBRYK_THE_SHIELD_WARDEN)
				.put("Quest_Boss_RatRider", BRUDVAAK_AND_VARGR)
				// Quests
				.put("Quest_OverworldPOI_BarnSiege", THE_BARN_SIEGE)
				.put("Quest_OverworldPOI_VargylBones", FELMOURN_BURROW)
				.put("Quest_OverworldPOI_Homestead", HOMESTEAD)
				.put("Quest_OverworldPOI_Afterbirth", KRALL_MOTHER)
				.put("Quest_Event_KrallBaby", KRALL_BABY)
				.put("Quest_SmallD_IceSkimmer", SEBUM)
				.put("Quest_SmallD_CreepersPeeper", CREEPER_S_PEEPER)
				.put("Quest_SmallD_WarningTotems", WARNING_TOTEMS)
				.put("Quest_SmallD_FrozenLords", MAGIR_S_TEST)
				// Quest items
				.put("Quest_Event_JanitorsWatch", JANITOR_S_WATCH)
				// Amulets
				.put("Quest_Event_RazorwireNecklace", RAZORWIRE_NECKLACE)
				.put("Quest_Event_AbrasiveAmulet", ABRASIVE_AMULET)
				.put("Quest_Event_Driftstone", DRIFTSTONE)
				.put("Quest_Event_CharcoalNecklace", CHARCOAL_NECKLACE)
				/* TODO verify */.put("Quest_Event_PolishedWhetstone", POLISHED_WHETSTONE)
				/* TODO verify */.put("Quest_Event_RadioactiveEmber", RADIOACTIVE_EMBER)
				/* TODO verify */.put("Quest_Event_TerrorMargin", TERROR_MARGIN)
				/* TODO verify */.put("Quest_Event_StalkersBrand", STALKER_S_BRAND)
				// Rings
				.put("Quest_Event_FiveFingeredRing", FIVE_FINGERED_RING)
				.put("Quest_Event_BurdenOfTheDevoted", BURDEN_OF_THE_DEVOTED)
				.put("Quest_Event_VolatileGem", VOLATILE_GEM)
				.put("Quest_Event_BurdenOfTheWarlord", BURDEN_OF_THE_WARLORD)
				.put("Quest_Event_SerpentsFang", SERPENT_S_FANG)
				/* TODO verify */.put("Quest_Event_BackbreakerRing", BACKBREAKER_RING)
				/* TODO verify */.put("Quest_Event_BurdenOfTheGambler", BURDEN_OF_THE_GAMBLER)
				/* TODO verify */.put("Quest_Event_BurdenOfTheReckless", BURDEN_OF_THE_RECKLESS)
				/* TODO verify */.put("Quest_Event_RestrictionCord", RESTRICTION_CORD)
				.put("Quest_Event_AlchemistsJewel", ALCHEMIST_S_JEWEL)
				/* TODO verify */.put("Quest_Event_BurdenOfTheFollower", BURDEN_OF_THE_FOLLOWER)
				/* TODO verify */.put("Quest_Event_SpiritStone", SPIRIT_STONE)
				// Main quest
				.put("Quest_Campaign_City", CAMPAIGN_EARTH)
				.put("Quest_Campaign_Labyrinth", CAMPAIGN_THE_LABYRINTH)
				.put("Quest_Campaign_Wasteland", CAMPAIGN_RHOM)
				.put("Quest_Campaign_Swamp", CAMPAIGN_CORSUS)
				.put("Quest_Campaign_Jungle", CAMPAIGN_YAESHA)
				.put("Quest_FoundersPrison", CAMPAIGN_FOUNDERS_PRISON)
				.put("Quest_Campaign_Ward13", CAMPAIGN_WARD_17)
				// Zone templates
				.put("City_Overworld_Zone1", FAIRVIEW)
				.put("City_Overworld_Zone2", WESTCOURT)
				.put("Wasteland_Overworld_Zone1", THE_EASTERN_WIND)
				.put("Wasteland_Overworld_Zone2", THE_SCOURING_WASTE)
				.put("Swamp_Overworld_Zone1", THE_FETID_GLADE)
				.put("Swamp_Overworld_Zone2", THE_MIST_FEN)
				.put("Jungle_Overworld_Zone1", THE_VERDANT_STRAND)
				.put("Jungle_Overworld_Zone2", THE_SCALDING_GLADE)
				.build())
			.addDictionary(RegExKeyMapDictionary.<KnownActor>builder()
				.put("^/Game/World_.+/Quests/Quest_OverworldPOI_Cryptolith_.*$", CRYPTOLITH)
				.put("^.*Quest_Over.orldPOI_StuckMerchant.*$", STUCK_MERCHANT)
				.build())
			.build());
	}
}
