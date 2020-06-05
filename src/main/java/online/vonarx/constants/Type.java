package online.vonarx.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Type {
	// Bosses
	WORLD_BOSS("World Boss"),
	BOSS("Boss"),
	// Quests
	QUEST("Quest"),
	MAIN_QUEST("Main quest"),
	DUNGEON("Dungeon"),
	SIEGE("Siege"),
	POINT_OF_INTEREST("POI"),
	MERCHANT("Merchant"),
	// Items
	// Weapons
	WEAPON("Weapon"),
	HAND_GUN("Hand Gun"),
	LONG_GUN("Long Gun"),
	MELEE_WEAPON("Melee Weapon"),
	// Mods
	MOD("Mod"),
	BUILT_IN_MOD("Built in Mod"),
	// Armor
	HEAD_ARMOUR("Head Armor"),
	BODY_ARMOR("Body Armor"),
	LEG_ARMOR("Leg Armor"),
	SKIN_HEAD_ARMOUR("Head Armor Skin"),
	SKIN_BODY_ARMOR("Body Armor Skin"),
	SKIN_LEG_ARMOR("Leg Armor Skin"),
	// Trinkets
	TRINKET("Trinket"),
	RING("Ring"),
	AMULET("Amulet"),
	// Misc
	TRAIT("Trait"),
	EMOTE("Emote"),
	RESOURCE("Resource"),
	PICKUP("Pickup"),
	QUEST_PICKUP("Quest pickup"),
	TEMPLATE("Template"),
	OTHER("Other");

	@Getter private final String displayName;
}
