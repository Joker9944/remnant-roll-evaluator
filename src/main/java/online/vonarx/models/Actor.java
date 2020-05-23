package online.vonarx.models;

import lombok.Builder;
import lombok.Data;
import online.vonarx.constants.Biome;
import online.vonarx.constants.Origin;
import online.vonarx.constants.Type;
import online.vonarx.constants.Zone;

import java.util.Optional;

@Data
@Builder
public class Actor {

	private final Origin origin;
	private final String identifier;
	private final Biome biome;
	private final Zone zone;
	private final String subZone;
	private final Type type;
	private final String name;

	public Optional<String> subZone() {
		return Optional.ofNullable(subZone);
	}

	public Optional<String> name() {
		return Optional.ofNullable(name);
	}
}
