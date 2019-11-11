package online.vonarx.actor;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import online.vonarx.dictionary.TypeDictionary;

@Accessors
@RequiredArgsConstructor
public enum Type {
	BOSS("Boss"),
	RING("Ring"),
	AMULET("Amulet"),
	PICKUP("Pickup"),
	SIEGE("Siege"),
	DUNGEON("Dungeon"),
	MERCHANT("Merchant"),
	POI("Point of Interest"),
	QUEST("Quest"),
	QUEST_PICKUP("Quest pickup"),
	MAIN_QUEST("Main quest"),
	TEMPLATE("Template"),
	OTHER("Other");

	@Getter private final String displayName;

	static Type matchType(final String name) {
		return TypeDictionary.dictionary.lookup(name)
			.orElseThrow(() -> new RuntimeException("RegEx as we know it does not work anymore, run!"));
	}
}
