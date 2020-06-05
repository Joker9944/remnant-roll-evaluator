package online.vonarx.models.world;

import lombok.Data;
import online.vonarx.constants.world.Biome;
import online.vonarx.constants.world.Zone;
import online.vonarx.models.Actor;
import online.vonarx.models.world.rewards.RewardLine;

import java.util.List;
import java.util.Optional;

@Data
public abstract class Encounter implements Actor {

	private final String identifier;
	private final Biome biome;
	private final Zone zone;

	public abstract Optional<String> location();

	public abstract List<RewardLine> rewardLines();
}
