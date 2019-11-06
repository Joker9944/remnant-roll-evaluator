package online.vonarx.actor;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Optional;

@Data
@Accessors
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Actor {

	private final String name;
	private final String displayName;
	private final Biome biome;
	private final Zone zone;
	private final Type type;
	private final Mode mode;

	public Actor(final String name, final Mode mode, final Zone zone) {
		this.name = name;
		this.biome = Biome.matchBiome(name);
		this.zone = zone;
		this.type = Type.matchType(name);
		this.mode = mode;
		this.displayName = type.dictionary().lookup(name)
			.orElse(null);
	}

	public Optional<String> displayName() {
		return Optional.ofNullable(displayName);
	}
}
