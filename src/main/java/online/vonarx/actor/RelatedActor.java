package online.vonarx.actor;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor
@AllArgsConstructor
public class RelatedActor {

	private String overrideName;
	private final String displayName;
	private final Type type;

	public Actor adapt(final Actor actor) {
		return new Actor(Objects.requireNonNullElseGet(overrideName, () -> "Adapted from: " + actor.name()), displayName, actor.biome(), actor.zone(), type, actor.mode());
	}
}
