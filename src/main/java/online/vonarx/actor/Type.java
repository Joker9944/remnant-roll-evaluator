package online.vonarx.actor;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import online.vonarx.dictionary.Dictionary;
import online.vonarx.dictionary.TypeDictionaries;

import java.util.Optional;
import java.util.function.Predicate;

import static java.util.Arrays.stream;

@Accessors
@RequiredArgsConstructor
public enum Type {
	BOSS("Bosses", "(?i)^/Game/World_.+/Quests.*boss.*$", TypeDictionaries.bossDictionary, 0),
	PICKUP("Pickups", "^/Game/World_.+/Quests/Quest_Event_.*$", TypeDictionaries.pickupDictionary, 2),
	QUEST("Quests", "^/Game/World_.+/Quests.*$", TypeDictionaries.questDictionary, 1),
	MAIN_QUEST("Main quest", "^/Game/Campaign_Main/.*$", key -> Optional.empty(), 3),
	TEMPLATE("Template", "^/Game/.+/Templates/.*$", key -> Optional.empty(), 4),
	OTHER("Misc", "^.*$", key -> Optional.empty(), 5);

	@Getter private final String displayName;
	private final String regex;
	@Getter private final Dictionary<String, String> dictionary;
	@Getter private final int order;

	public static Type matchType(final String name) {
		return stream(values())
			.filter(nameMatchesType(name))
			.findFirst()
			.orElseThrow(() -> new RuntimeException("RegEx as we know it does not work anymore, run!"));
	}

	private static Predicate<Type> nameMatchesType(final String name) {
		return type -> name.matches(type.regex);
	}
}
