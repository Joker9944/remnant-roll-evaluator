package online.vonarx.constants.character;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Archetype {
	HUNTER("Hunter"),
	CULTIST("Cultist"),
	SCRAPPER("Scrapper");

	@Getter private final String displayName;
}
