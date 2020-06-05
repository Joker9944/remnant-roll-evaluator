package online.vonarx.models;

import online.vonarx.constants.KnownActor;
import online.vonarx.constants.Origin;
import online.vonarx.constants.Type;

import java.util.Optional;

public interface Actor {

	Optional<String> displayName();
	String identifier();
	Origin origin();
	Type type();

	Optional<KnownActor> knownActor();

	boolean equalsToKnownActor(final KnownActor knownActor);
}
