package online.vonarx.dictionary;

import online.vonarx.actor.Mode;
import online.vonarx.actor.Type;

import java.util.Map;
import java.util.Set;

public abstract class Undesirables {

	public static final Set<String> childActors = Set.of(
		// Base
		"Quest_Event_TraitBook_",
		// City
		"Weapon_HuntingPistol",
		"Weapon_AssaultRifle",
		"Weapon_Machinegun",
		// Wasteland
		"Trinket_JewelOfTheBlackSun",
		"Trinket_MendersCharm",
		"Weapon_Wasteland_BeamRifle",
		"Weapon_Wasteland_Flail",
		// Jungle
		"Trinket_HeartOfTheWolf",
		"Quest_SmallD_BlinkThief",
		"Trinket_GuardiansRing",
		"Armor_Head_Radiant"
	);

	public static final Set<Type> redundantActorTypes = Set.of(
		Type.MAIN_QUEST,
		Type.TEMPLATE,
		Type.OTHER
	);

	public static final Map<Mode, Set<String>> redundantActorsByMode = Map.of(
		Mode.STORY, Set.of(
			// Base undesirables
			// City undesirables
			"Weapon_RepeaterPistol",
			"Weapon_Submachinegun",
			"Weapon_SniperRifle",
			"Quest_OverworldPOI_Settlement",
			"Root_Hag",
			// Wasteland undesirables
			"Quest_SunGate",
			"Undying",
			"Quest_OverworldPOI_OldManAndConstruct",
			"Quest_OverworldPOI_Monolith",
			// Swamp undesirables
			"Quest_OverWorldPOI_ElfQueen",
			// Jungle undesirables
			"Quest_OverworldPOI_Flautist",
			"Quest_OverworldPOI_Ruins"
		),
		Mode.ADVENTURE, Set.of("Quest_AdventureMode_")
	);
}
