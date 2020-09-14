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

import static java.util.List.of;

@ToString
@EqualsAndHashCode(callSuper = true)
public class UnknownEncounter extends Encounter {

	@Getter private final Origin origin = Origin.UNKNOWN;
	@Getter private final Type type;

	@Builder
	private UnknownEncounter(final String identifier, final Biome biome, final Zone zone,
	                         final Type type) {
		super(identifier, biome, zone);
		this.type = type;
	}

	@Override
	public Optional<String> displayName() {
		return Optional.empty();
	}

	@Override
	public Optional<String> location() {
		return Optional.empty();
	}

	@Override
	public List<RewardLine> rewardLines() {
		return of();
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
