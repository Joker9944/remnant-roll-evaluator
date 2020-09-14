package online.vonarx.components.save.world;

import online.vonarx.constants.KnownActor;
import online.vonarx.models.world.rewards.BasicRewardLine;
import online.vonarx.models.world.rewards.BasicRewardLineWithMessage;
import online.vonarx.models.world.rewards.RewardLine;
import online.vonarx.models.world.rewards.RewardLineCombinator;

import javax.inject.Inject;

public class RewardFactory {

	@Inject
	public RewardFactory() {}

	public RewardLine reward(final KnownActor... rewards) {
		return new BasicRewardLine("and", rewards);
	}

	public RewardLine reward(final String message, final KnownActor... rewards) {
		return new BasicRewardLineWithMessage(message, "and", rewards);
	}

	public RewardLine hardcoreReward(final KnownActor... rewards) {
		return reward("Hardcore mode", rewards);
	}

	public RewardLine optionalReward(final KnownActor... rewards) {
		return reward("Missable", rewards);
	}

	public RewardLine merchandise(final KnownActor... merchandise) {
		return reward("Merchandise", merchandise);
	}

	public RewardLine exclusiveReward(final KnownActor... rewards) {
		return new BasicRewardLine("or", rewards);
	}

	public RewardLine exclusiveReward(final String message, final KnownActor... rewards) {
		return new BasicRewardLineWithMessage(message, "or", rewards);
	}

	public RewardLine combineRewardLines(final RewardLine... rewardLines) {
		return new RewardLineCombinator("or", rewardLines);
	}
}
