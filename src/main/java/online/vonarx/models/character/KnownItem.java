package online.vonarx.models.character;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import online.vonarx.constants.KnownActor;
import online.vonarx.constants.Origin;
import online.vonarx.constants.Type;

import java.util.Optional;

@ToString
@EqualsAndHashCode
public class KnownItem implements Item {

	private final KnownActor knownActor;

	@Getter private final String identifier;

	@Builder
	public KnownItem(final KnownActor knownActor, final String identifier) {
		this.knownActor = knownActor;
		this.identifier = identifier;
	}

	@Override
	public Optional<String> displayName() {
		return Optional.of(knownActor.displayName());
	}

	@Override
	public Origin origin() {
		return knownActor.origin();
	}

	@Override
	public Type type() {
		return knownActor.type();
	}

	@Override
	public Optional<KnownActor> knownActor() {
		return Optional.of(knownActor);
	}

	@Override
	public boolean equalsToKnownActor(final KnownActor knownActor) {
		return this.knownActor.equals(knownActor);
	}
}
