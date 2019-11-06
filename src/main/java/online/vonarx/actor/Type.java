package online.vonarx.actor;

import lombok.Getter;
import lombok.experimental.Accessors;
import online.vonarx.dictionary.Dictionary;
import online.vonarx.dictionary.TypeDictionaries;

import java.util.Optional;
import java.util.function.Predicate;

import static java.util.Arrays.stream;

public enum Type {
	BOSS("Bosses", "(?i)^/Game/World_.+/Quests.*boss.*$", TypeDictionaries.bossDictionary),
	PICKUP("Pickups", "^/Game/World_.+/Quests/Quest_Event_.*$", TypeDictionaries.pickupDictionary),
	QUEST("Quests", "^/Game/World_.+/Quests.*$", TypeDictionaries.questDictionary),
	MAIN_QUEST("Main quest", "^/Game/Campaign_Main/.*$", key -> Optional.empty()),
	TEMPLATE("Template", "^/Game/.+/Templates/.*$", key -> Optional.empty()),
	OTHER("Misc", "^.*$", key -> Optional.empty());

	private final String regex;

	@Getter
	@Accessors
	private final String displayName;

	@Getter
	@Accessors
	private final Dictionary<String, String> dictionary;

	Type(final String displayName, final String regex, final Dictionary<String, String> dictionary) {
		this.displayName = displayName;
		this.regex = regex;
		this.dictionary = dictionary;
	}

	public static Type matchType(final String name) {
		return stream(values())
			.filter(nameMatchesType(name))
			.findAny()
			.orElseThrow(() -> new RuntimeException("RegEx as we know it does not work anymore, run!"));
	}

	private static Predicate<Type> nameMatchesType(final String name) {
		return type -> name.matches(type.regex);
	}
}
