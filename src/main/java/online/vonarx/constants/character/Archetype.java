package online.vonarx.constants.character;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Archetype {
	// TODO check order
	SCRAPPER("Scrapper"),
	CULTIST("Cultist"),
	HUNTER("Hunter");

	@Getter private final String displayName;
}
