package online.vonarx.actor;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;
import online.vonarx.dictionary.LocationDictionary;
import online.vonarx.dictionary.NameDictionary;
import online.vonarx.dictionary.OriginDictionary;

import java.util.Optional;

@Data
@Accessors
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Actor {

	private final Mode mode;
	private final Origin origin;
	private final String identifier;
	private final Biome biome;
	private final Zone zone;
	private final String subZone;
	private final Type type;
	private final String name;

	public Actor(final Mode mode, final String identifier, final Zone zone) {
		this.mode = mode;
		this.origin = Origin.matchOrigin(identifier);
		this.identifier = identifier;
		this.biome = Biome.matchBiome(identifier);
		this.zone = zone;
		this.subZone = LocationDictionary.dictionary.lookup(identifier)
			.orElse(null);
		this.type = Type.matchType(identifier);
		this.name = NameDictionary.dictionary.lookup(identifier)
			.orElse(null);
	}

	public Optional<String> subZone() {
		return Optional.ofNullable(subZone);
	}

	public Optional<String> name() {
		return Optional.ofNullable(name);
	}
}
