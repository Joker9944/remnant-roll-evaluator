package online.vonarx.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Type {
	BOSS("Boss"),
	RING("Ring"),
	AMULET("Amulet"),
	PICKUP("Pickup"),
	SIEGE("Siege"),
	DUNGEON("Dungeon"),
	MERCHANT("Merchant"),
	POINT_OF_INTEREST("POI"),
	QUEST("Quest"),
	QUEST_PICKUP("Quest pickup"),
	MAIN_QUEST("Main quest"),
	TEMPLATE("Template"),
	OTHER("Other");

	@Getter private final String displayName;
}
