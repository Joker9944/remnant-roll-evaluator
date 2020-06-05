package online.vonarx.models.character;

import lombok.Builder;
import lombok.Data;
import online.vonarx.constants.KnownActor;
import online.vonarx.constants.Origin;
import online.vonarx.constants.Type;

import java.util.Optional;

@Data
@Builder
public class UnknownItem implements Item {

	private final String identifier;
	private final Origin origin = Origin.UNKNOWN;
	private final Type type;

	@Override
	public Optional<String> displayName() {
		return Optional.empty();
	}

	@Override
	public Optional<KnownActor> knownActor() {
		return Optional.empty();
	}

	@Override
	public boolean equalsToKnownActor(final KnownActor knownActor) {
		return false;
	}
}
