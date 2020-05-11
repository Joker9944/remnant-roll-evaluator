package online.vonarx.actor;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Mode {
	STORY("Story"),
	ADVENTURE("Adventure");

	@Getter private final String displayName;
}
