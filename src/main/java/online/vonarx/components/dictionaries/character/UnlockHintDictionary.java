package online.vonarx.components.dictionaries.character;

import online.vonarx.constants.KnownActor;
import online.vonarx.constants.Type;
import online.vonarx.dictionary.DictionaryWrapper;
import online.vonarx.dictionary.implementation.ChainDictionary;
import online.vonarx.dictionary.implementation.MapDictionary;
import online.vonarx.dictionary.implementation.SetDictionary;

import javax.inject.Inject;
import java.util.Arrays;

import static java.util.stream.Collectors.toSet;
import static online.vonarx.constants.KnownActor.*;

public class UnlockHintDictionary extends DictionaryWrapper<KnownActor, String> {

	@Inject
	protected UnlockHintDictionary() {
		super(ChainDictionary.<KnownActor, String>builder()
			// Starting items
			.addDictionary(SetDictionary.<KnownActor, String>builder("Obtained at the beginning of the game.")
				.add(VIGOR, ENDURANCE)
				.add(NO, THIS_WAY, YES)
				.add(REPEATER_PISTOL)
				.add(ADVENTURER_TUNIC, ADVENTURER_LEGGINGS)
				.build())
			// Rigs inventory
			.addDictionary(SetDictionary.<KnownActor, String>builder("Purchase from Rigs.")
				.add(HUNTING_RIFLE, COACH_GUN, SHOTGUN)
				.add(SCRAP_SWORD, SCRAP_HATCHET, SCRAP_HAMMER)
				.add(HUNTER_SHROUD, HUNTER_TRENCHCOAT, HUNTER_PANTS)
				.add(CULTIST_HAT, CULTIST_DUSTER, CULTIST_BRITCHES)
				.add(SCRAPPER_HELMET, SCRAPPER_BODYPLATE, SCRAPPER_WORKBOOTS)
				.build())
			// Wud inventory
			.addDictionary(SetDictionary.<KnownActor, String>builder("Purchase from Wud.")
				.add(OSSEOUS_HELM, OSSEOUS_HUSK, OSSEOUS_KILT)
				.add(MENDER_S_CHARM, JEWEL_OF_THE_BLACK_SUN)
				.build())
			// Stuck Merchant inventory
			.addDictionary(SetDictionary.<KnownActor, String>builder("Purchase from Stuck Merchant.")
				.add(SPEAR)
				.add(RADIANT_PROTECTOR, RADIANT_GREAVES)
				.build())
			// Whispers inventory
			.addDictionary(SetDictionary.<KnownActor, String>builder("Purchase from Whispers.")
				.allAdd(Arrays.stream(KnownActor.values())
					.filter(knownActor -> knownActor.type().equals(Type.SKIN_HEAD_ARMOUR) || knownActor.type().equals(Type.SKIN_BODY_ARMOR) || knownActor.type().equals(Type.SKIN_LEG_ARMOR))
					.collect(toSet()))
				.build())
			// Give Guardians Heart to Iskal Queen
			.addDictionary(SetDictionary.<KnownActor, String>builder("Give the Guardian's Heart to the Iskal Queen.")
				.add(CROSSBOW)
				.add(SLAYER_MASK, SLAYER_MANTLE, SLAYER_BOOTS)
				.build())
			// Red Beetle drops
			.addDictionary(SetDictionary.<KnownActor, String>builder("Kill a Red Beetle found in dungeons on Corsus.")
				.add(AMULET_OF_EPICARICACY)
				.add(ISKAL_HUNTER_BAND, RING_OF_THE_MANTIS)
				.build())
			// Infect Graveyard Elf
			.addDictionary(SetDictionary.<KnownActor, String>builder("Put the Iskal Vial into the Graveyard Elf's soup.")
				.add(POTENCY)
				.add(RING_OF_THE_UNCLEAN)
				.build())
			// Fetid pool cooperative rewards
			.addDictionary(SetDictionary.<KnownActor, String>builder("Open doors 3-1-1 in Fetid Pool dungeon.")
				.add(FORTIFICATION)
				.add(HERO_S_RING)
				.build())
			.addDictionary(MapDictionary.<KnownActor, String>builder()
				// Traits
				.put(EXPLOITER, "Kill 150 enemies with weak spot hits.")
				.put(SPIRIT, "Complete the Supply Run event.")
				.put(QUICK_HANDS, "Defeat the Ent or Singe.")
				.put(WORLD_WALKER, "Arrive on Rhom.")
				.put(KEEPER_S_BLESSING, "Enter the Labyrinth.")
				.put(MOTHER_S_BLESSING, "Defend the Root Mother.")
				.put(TEAMWORK, "Play with another player.")
				.put(WARRIOR, "Complete the A Tale of Two Liz's siege.")
				.put(SHADOW_WALKER, "Complete the Hunter's Hideout event.")
				.put(ELDER_KNOWLEDGE, "Play a tape recorder found in Ward 13.")
				.put(SCAVENGER, "Give the Tarnished Ring to Reggie.")
				.put(RECOVERY, "Defeat Claviger or The Harrow.")
				.put(HANDLING, "Obtain 10 weapons.")
				.put(GLUTTON, "Defeat The Unclean One.")
				.put(CATALYST, "Defeat The Thrall or Canker.")
				.put(EXECUTIONER, "Defeat Ixillis.")
				.put(TRIAGE, "Talk to Navun after completing the Fight with the Rebels siege.")
				.put(KINGSLAYER, "Defeat the Undying King.")
				.put(WILL_TO_LIVE, "Get revived 10 times.")
				.put(ARCANE_STRIKE, "Defeat The Ravager or Totem Father.")
				.put(MIND_S_EYE, "Defeat the Dreamer.")
				.put(BARK_SKIN, "Speak to the Wailing Tree with the Twisted Mask equipped.")
				.put(REVIVALIST, "Revive teammates 10 times.")
				.put(GUARDIAN_S_BLESSING, "Defeat the Root Horror.")
				.put(COLD_AS_ICE, "Murder your teammates for Brabus.")
				.put(TRIGGER_HAPPY, "Upgrade a non-boss ranged weapon to level 20.")
				.put(RAPID_STRIKE, "Upgrade a non-boss melee weapon to level 20.")
				.put(SUSPICION, "Get downed by teammates 10 times.")
				.put(SWIFTNESS, "Play 1-1-3-4-1-1-3-2 on any bell puzzle.")
				.put(SLEIGHT_OF_HAND, "Get 100 kills with 10 different ranged weapons.")
				// Swamps of Corsus
				.put(CONCENTRATION, "Insert the Cryptolith Sigil into the Cryptolith the first time.")
				.put(BLOOD_BOND, "Insert the Cryptolith Sigil into the Cryptolith a second time.")
				.put(FOOTWORK, "Defeat the Iskal Queen.")
				.put(INVOKER, "Let summons kill 100 enemies.")
				.put(LUMINESCENT, "Give the Opalescent Shell to Mar'Gosh.")
				.put(EVOCATION, "Destroy all hives without getting hit by wisps in Circlet Hatchery dungeon.")
				// Subject 2923
				.put(ARMOR_PIERCER, "Deal 5000 damage to enemy armored regions.")
				.put(WISDOM, "Open the blast doors in Ward Prime.")
				.put(FLASH_CASTER, "Acquire 25 weapon mods.")
				.put(HARD_CHARGER, "Defeat Brudvaak and Vargr.")
				// Emotes
				.put(WAVE, "Play with another player.")
				.put(CHEER, "Defeat The Ent.")
				.put(BECKON_EMOTE, "Defeat Singe.")
				.put(FAIL, "Defeat The Harrow.")
				.put(LAUGH, "Defeat Claviger.")
				.put(GRAVEDIGGER, "Defeat the Undying King.")
				.put(EXHAUSTED, "Defeat The Unclean One.")
				.put(CONFUSED, "Defeat Ixillis.")
				.put(FREEZE_FRAME, "Defeat The Ravager.")
				.put(TEA_TIME, "Defeat Totem Father.")
				.put(PRAISE_THE_GUN, "Defeat the Dreamer in normal mode.")
				// Hardcore Update
				.put(HIGH_FIVE, "Defeat the Dreamer in hardcore mode.")
				// Weapons
				// Hand Guns
				.put(MAGNUM_REVOLVER, "Give the Strange Coin to Ace.")
				.put(DEFILER, "Craft with Thermal Geode.")
				.put(THERMAL_GEODE, "Defeat The Harrow.")
				.put(HUNTING_PISTOL, "Found in the safehouse in Hidden Grotto dungeon.")
				.put(SUBMACHINE_GUN, "Found in Ward 13.")
				.put(HIVE_CANNON, "Craft with Hivestone.")
				.put(HIVESTONE, "Defeat Ixillis.")
				.put(SPITFIRE, "Craft with Blazing Heart.")
				.put(BLAZING_HEART, "Defeat Singe.")
				.put(CURSE_OF_THE_JUNGLE_GOD, "Craft with Tentacle Pod.")
				.put(TENTACLE_POD, "Defeat The Ravager.")
				// Swamps of Corsus
				.put(PRIDE_OF_THE_ISKAL, "Craft with Crystalline Plasma.")
				.put(CRYSTALLINE_PLASMA, "Defeat the Iskal Queen.")
				// Long Guns
				.put(ASSAULT_RIFLE, "Found behind the Monkey Door in Sorrow's Field dungeon.")
				.put(BEAM_RIFLE, "Complete The Lost Gantry event.")
				.put(DEVASTATOR, "Craft with Unclean Heart.")
				.put(UNCLEAN_HEART, "Defeat The Unclean One.")
				.put(SNIPER_RIFLE, "Found in the basement of The Root Mother's Church.")
				.put(SPOREBLOOM, "Craft with Spore Gland.")
				.put(SPORE_GLAND, "Defeat The Ent.")
				.put(RUIN, "Craft with The Undying Heart.")
				.put(THE_UNDYING_HEART, "Defeat the Undying King.")
				.put(EYE_OF_THE_STORM, "Craft with Totem Antler.")
				.put(TOTEM_ANTLER, "Defeat the Totem Father in blue mode.")
				.put(PARTICLE_ACCELERATOR, "Craft with Void Sliver.")
				.put(VOID_SLIVER, "Defeat Claviger without letting him absorb a minion.")
				.put(REPULSOR, "Craft with Dreamer's Mana.")
				.put(DREAMER_S_MANA, "Defeat the Dreamer.")
				.put(RICOCHET_RIFLE, "Defeat the Blink Thief.")
				.put(CHICAGO_TYPEWRITER, "Complete the A Tale of Two Liz's siege with both NPC's surviving.")
				// Melee Weapons
				.put(PETRIFIED_MAUL, "Craft with Twisted Heart.")
				.put(TWISTED_HEART, "Destroy the legs of The Ent before defeating him.")
				.put(WASTELANDER_FLAIL, "Complete The Clean Room event.")
				.put(SCYTHE, "Purchase from the Iskal Queen.")
				.put(WORLD_BREAKER, "Craft with Stone of the Guardian.")
				.put(STONE_OF_THE_GUARDIAN, "Defeat Claviger.")
				.put(SPEAR, "Purchase from Stuck Merchant.")
				.put(SCAR_OF_THE_JUNGLE_GOD, "Craft with Stalker's Claw")
				.put(STALKER_S_CLAW, "Play 5-1-5-1-2-3-4-1 at The Ravager's bell puzzle.")
				.put(SMOLDER, "Craft with Dragon Links")
				.put(DRAGON_LINKS, "Sever Singe's tail.")
				.put(VOICE_OF_THE_TEMPEST, "Craft with Tempest Heartstring.")
				.put(TEMPEST_HEARTSTRING, "Defeat the Totem Father in red mode.")
				.put(BUTCHERS_FLAIL, "Craft with Hammerhead's Ore.")
				.put(HAMMERHEAD_S_ORE, "Sneak into The Unclean One's basement and hide in a pot.")
				.put(GUARDIAN_AXE, "Craft with Guardian Tentacle.")
				.put(GUARDIAN_TENTACLE, "Defeat Ixillis XV and Ixillis XVI at the same time.")
				.put(LOST_HARPOON, "Stagger The Harrow by shooting him into the legs and pull the Lost Harpoon from his back.")
				.put(RIVEN, "Give the Guardian's Heart to the Undying King.")
				// Swamps of Corsus
				.put(HERO_S_SWORD, "Defeat 10 bosses in survival mode in a single run.")
				// Subject 2923
				// TODO Add chain blade
				.put(STEEL_OF_AGONY, "Defeat Vargr before Brudvaak.")
				// Mods
				.put(FLICKER_CLOAK, "Craft with Displacement Crystal.")
				.put(DISPLACEMENT_CRYSTAL, "Defeat Riphide.")
				.put(MENDER_S_AURA, "Purchase from Ace.")
				.put(RATTLE_WEED, "Craft with Shadewood.")
				.put(SHADEWOOD, "Defeat Shroud.")
				.put(MANTLE_OF_THORNS, "Craft with Flesh Barb.")
				.put(FLESH_BARB, "Defeat Gorefist.")
				.put(HOT_SHOT, "Purchase from Ace.")
				.put(HUNTER_S_MARK, "Purchase from Ace.")
				.put(SEED_CALLER, "Craft with Hollow Seed.")
				.put(HOLLOW_SEED, "Defeat The Mangler.")
				.put(RADIOACTIVE_VOLLEY, "Built into Defiler.")
				.put(BREATH_OF_THE_DESERT, "Craft with Radioactive Skull.")
				.put(RADIOACTIVE_SKULL, "Defeat Scourge.")
				.put(VEIL_OF_THE_BLACK_TEAR, "Craft with Black Tear.")
				.put(BLACK_TEAR, "Defeat Shade and Shatter.")
				.put(SKEWER, "Built into Devastator.")
				.put(SONG_OF_SWORDS, "Craft with Kin Callers Bell.")
				.put(KIN_CALLERS_BELL, "Defeat The Warden.")
				.put(CORROSIVE_AURA, "Craft with Slime Vessel.")
				.put(SLIME_VESSEL, "Defeat Canker.")
				.put(BLINK_TOKEN, "Craft with Blink Spear Shard.")
				.put(BLINK_SPEAR_SHARD, "Defeat Onslaught.")
				.put(SWARM, "Craft with Swarm Tusk.")
				.put(SWARM_TUSK, "Defeat The Thrall.")
				.put(STORMCALLER_MOD, "Craft with Storm Crystal.")
				.put(STORM_CRYSTAL, "Defeat Stormcaller.")
				.put(BECKON_MOD, "Craft with Sentinel Shard.")
				.put(SENTINEL_SHARD, "Defeat Raze.")
				.put(HIVE_SHOT, "Built into Hive Cannon.")
				.put(UNDYING, "Built into Ruin.")
				.put(STATIC_FIELD_SHOT, "Built into Eye of the Storm.")
				.put(HOWLER_S_IMMUNITY, "Crafted with Hound Choker.")
				.put(HOUND_CHOKER, "Defeat Maul.")
				.put(FLAME_THROWER, "Built into Spitfire.")
				.put(IRON_SENTINEL, "Craft with Ancient Core.")
				.put(ANCIENT_CORE, "Defeat Ancient Construct.")
				.put(EXPLOSIVE_SHOT, "Craft with Shrapnel Shard.")
				.put(SHRAPNEL_SHARD, "Defeat Brabus.")
				.put(WILDFIRE_SHOT, "Craft with Zephyr's Conduit.")
				.put(ZEPHYR_S_CONDUIT, "Defeat Scald and Sear.")
				.put(TENTACLE_SHOT, "Built into Curse of the Jungle God.")
				.put(SPORE_SHOT, "Built into Sporebloom.")
				.put(GRAVITY_CORE, "Built into Particle Accelerator.")
				.put(BANISH, "Built into Repulsor.")
				// Swamps of Corsus
				.put(VAMPIRIC, "Built into Pride of the Iskal.")
				.put(RIFT_WALKER, "Craft with Luminous Gland.")
				.put(LUMINOUS_GLAND, "Defeat Rift Walker.")
				.put(UNSTABLE_QUILLS, "Craft with Barbed Sinew.")
				.put(BARBED_SINEW, "Defeat Barbed Terror.")
				.put(SEEKER, "Craft with Iskal Husk.")
				.put(ISKAL_HUSK, "Squash the Iskal Queen with a stalactite.")
				// Subject 2923
				.put(COLD_SPEAR, "Defeat Erfor, the Jackal.")
				// Armor
				.put(ADVENTURER_GOGGLES, "Defeat 5 bosses in survival mode in a single run.")
				.put(AKARI_MASK, "Open the left door in the Vault of The Herald dungeon.")
				.put(AKARI_GARB, "Open the middle door in the Vault of The Herald dungeon.")
				.put(AKARI_LEGGINGS, "Open the right door in the Vault of The Herald dungeon.")
				.put(BOMBER_HAT, "Cannot be obtained; was a Twitch Prime pre-order.")
				.put(RADIANT_VISAGE, "Found in Guardian Shrine dungeon.")
				.put(TWISTED_MASK, "Pressure Twisted Mask Merchant on the mask and defeat him.")
				// Amulets
				.put(LETO_S_AMULET, "Can be found in Sunken Passage or Hidden Sanctum dungeon in a hidden room below a \"Only the penitent man may pass\" graffiti.")
				.put(POCKET_WATCH, "Listen to all of Mud Tooth's stories.")
				.put(TWISTED_IDOL, "Defeat the Wailing Tree.")
				.put(SOUL_ANCHOR, "Complete The Risen siege.")
				.put(SCAVENGER_S_BAUBLE, "Play 5-4-3-3-4-1-2-3-2-1 at the Red Doe Shrine bell puzzle.")
				.put(NIGHTMARE_SPIRAL, "Defeat the Dreamer in hardcore mode.")
				// Swamps of Corsus
				.put(RUSTED_AMULET, "Found in Fetid Pools dungeon.")
				.put(HEART_OF_DARKNESS, "Open door 2 in Fetid Pool dungeon.")
				.put(TALISMAN_OF_PERSEVERANCE, "Defeat 50 bosses in survival mode.")
				.put(DAREDEVIL_S_CHARM, "Defeat 75 bosses in survival mode.")
				.put(BLACK_ROSE, "Defeat 100 bosses in survival mode.")
				// Subject 2923
				.put(HANGMAN_S_MOMENTO, "Complete The Barn Siege.")
				// Rings
				.put(BRAIDED_THORNS, "Destroy all Root Nexuses in Marrow Pass dungeon and defeat the cultist.")
				.put(ROOT_CIRCLET, "Talk to the cultist in Marrow Pass dungeon with destroying a Root Nexus.")
				.put(HEART_OF_THE_WOLF, "Play 3-4-5-3-2-1 at the Flautist bell puzzle.")
				.put(GUARDIAN_S_RING, "Purchase from Stuck Merchant or pickup next to Stuck Merchant after defeating the Root Horror.")
				.put(RING_OF_THE_ADMIRAL, "Purchase from Reggie.")
				.put(PROVISIONER_RING, "Defeat The Ent or Singe in hardcore mode.")
				.put(AKARI_WAR_BAND, "Defeat Claviger or THe Harrow in hardcore mode.")
				.put(EMPOWERING_LOOP, "Defeat Ixillis in hardcore mode.")
				.put(RING_OF_SUPREMACY, "Defeat The Ravager or Totem Father in hardcore mode.")
				.put(BAND_OF_ACCORD, "High five another player.")
				// Swamps of Corsus
				.put(GRIM_COIL, "Purchase from Graveyard Elf.")
				.put(SOUL_EMBER, "Destroy all hives in Circlet Hatchery dungeon.")
				.put(LOOP_OF_PROSPERITY, "Defeat 25 bosses in survival mode.")
				.put(GIFT_OF_THE_ISKAL, "Defeat Mar'Gosh")
				.put(SOUL_LINK, "Found in a cave next to a Cryptolith on Rhom.")
				.build())
			.addDictionary(SetDictionary.<KnownActor, String>builder("Trade the Pocket Watch with Brabus.")
				.add(BANDIT_S_MASK, BANDIT_JACKET, BANDIT_TROUSERS)
				.build())
			.addDictionary(SetDictionary.<KnownActor, String>builder("Trade a Hardened Carapace with Mar'Gosh.")
				.add(CARAPACE_GREAT_HELM, CARAPACE_SHELL, CARAPACE_GREAVES)
				.build())
			.addDictionary(SetDictionary.<KnownActor, String>builder("Found behind a shelf at Founder's Hideout.")
				.add(DRIFTER_S_OVERCOAT, DRIFTER_S_TROUSERS)
				.build())
			.addDictionary(SetDictionary.<KnownActor, String>builder("Complete the Wolf Shrine siege.")
				.add(ELDER_HEADDRESS, ELDER_RAIMENT, ELDER_LEGGINGS)
				.build())
			.addDictionary(SetDictionary.<KnownActor, String>builder("Insert the Cryptolith Sigil into the Cryptolith a third time.")
				.add(LABYRINTH_HELM, LABYRINTH_ARMOR, LABYRINTH_GREAVES)
				.build())
			.addDictionary(SetDictionary.<KnownActor, String>builder("Found after the teleport puzzle in Leto's Laboratory dungeon.")
				.add(LETO_S_HELMET, LETO_S_ARMOR, LETO_S_LEGGINGS)
				.build())
			.addDictionary(SetDictionary.<KnownActor, String>builder("Complete The Root Shrine siege.")
				.add(TWISTED_HOOD, TWISTED_CAGE, TWISTED_TASSETS)
				.build())
			.addDictionary(SetDictionary.<KnownActor, String>builder("Purchase after solving the Monolith floor tile puzzle.")
				.add(VOID_SKULL, VOID_CARAPACE, VOID_GREAVES)
				.build())
			// Earth random drops
			.addDictionary(SetDictionary.<KnownActor, String>builder("Found randomly on City Earth.")
				// Armor
				.add(DRIFTER_S_MASK)
				// Amulets
				.add(GUNSLINGER_S_CHARM)
				// Rings
				.add(HEARTSEEKER, MOTHER_S_RING, PILLAR_OF_STONE, RING_OF_EVASION, SAGESTONE)
				// Swamps of Corsus
				.add(COMPULSION_LOOP, GUNSLINGER_S_RING, STOCKPILE_CIRCLET, AGGRESSOR_S_BANE, BAND_OF_POLLUX, BAND_OF_CASTOR)
				.build())
			// Rhom random drops
			.addDictionary(SetDictionary.<KnownActor, String>builder("Found randomly on Rhom.")
				// Amulets
				.add(BRUTAL_MARK, CLEANSING_JEWEL, GALENIC_CHARM)
				// Swamps of Corsus
				.add(TALISMAN_OF_ANIMOSITY)
				// Rings
				.add(BAND_OF_STRENGTH, EZLAN_S_BAND, GRAVITY_STONE, HUNTER_S_HALO, LEECH_EMBER)
				// Swamps of Corsus
				.add(DECEIVER_S_BAND, RING_OF_ELUSION)
				.build())
			// Corsus random drops
			.addDictionary(SetDictionary.<KnownActor, String>builder("Found randomly on Corsus.")
				// Amulets
				.add(BUTCHER_S_FETISH, ROCK_OF_ANGUISH, ABRASIVE_AMULET)
				// Rings
				.add(BLOOD_FONT, DEVOURING_LOOP, RAZORSTONE, BURDEN_OF_THE_DEVOTED)
				.build())
			// Yaesha random drops
			.addDictionary(SetDictionary.<KnownActor, String>builder("Found randomly on Yaesha.")
				// Amulets
				.add(STORM_AMULET, VENGEANCE_IDOL)
				// Rings
				.add(CELERITY_STONE, HUNTER_S_BAND, KEEPER_S_RING, STONE_OF_BALANCE)
				// Swamps of Corsus
				.add(PEARL_OF_LUMINESCENCE, RING_OF_SHADOWS)
				.build())
			.addDictionary(SetDictionary.<KnownActor, String>builder("Found randomly on Rural Earth.")
				// Rings
				.add(FIVE_FINGERED_RING)
				.build())
			.addDictionary(SetDictionary.<KnownActor, String>builder("Found randomly on Reisum.")
				// Amulets
				.add(RAZORWIRE_NECKLACE, DRIFTSTONE)
				.build())
			.build());
	}
}
