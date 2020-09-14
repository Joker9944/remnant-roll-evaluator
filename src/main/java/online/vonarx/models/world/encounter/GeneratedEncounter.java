package online.vonarx.models.world.encounter;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import online.vonarx.constants.KnownActor;
import online.vonarx.constants.Origin;
import online.vonarx.constants.Type;
import online.vonarx.constants.world.Biome;
import online.vonarx.constants.world.Zone;
import online.vonarx.models.world.rewards.RewardLine;

import java.util.List;
import java.util.Optional;

@ToString
@EqualsAndHashCode(callSuper = true)
public class GeneratedEncounter extends Encounter {

	private final KnownActor knownActor;

	private final String location;
	@Getter private final List<RewardLine> rewardLines;

	@Builder
	private GeneratedEncounter(final KnownActor knownActor,
	                           final String identifier, final Biome biome, final Zone zone,
	                           final String location, final List<RewardLine> rewardLines) {
		super(identifier, biome, zone);
		this.knownActor = knownActor;
		this.location = location;
		this.rewardLines = rewardLines;
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
	public Optional<String> location() {
		return Optional.ofNullable(location);
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
