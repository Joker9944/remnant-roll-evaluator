package online.vonarx.components.save.world;

import online.vonarx.constants.KnownActor;
import online.vonarx.models.world.rewards.CombinationRewardLine;
import online.vonarx.models.world.rewards.RewardLine;
import online.vonarx.models.world.rewards.SingleRewardLine;

import javax.inject.Inject;

public class RewardFactory {

	@Inject
	public RewardFactory() {}

	public RewardLine reward(final KnownActor reward) {
		return reward(null, reward);
	}

	public RewardLine reward(final String message, final KnownActor reward) {
		return new SingleRewardLine(message, reward);
	}

	public RewardLine hardcoreReward(final KnownActor reward) {
		return reward("Hardcore mode", reward);
	}

	public RewardLine optionalReward(final KnownActor reward) {
		return reward("Not guaranteed", reward);
	}

	public RewardLine exclusiveReward(final KnownActor... rewards) {
		return exclusiveReward(null, rewards);
	}

	public RewardLine exclusiveReward(final String message, final KnownActor... rewards) {
		return new CombinationRewardLine(message, " or ", rewards);
	}

	public RewardLine inclusiveReward(final KnownActor... rewards) {
		return inclusiveReward(null, rewards);
	}

	public RewardLine inclusiveReward(final String message, final KnownActor... rewards) {
		return new CombinationRewardLine(message, " and ", rewards);
	}

	public RewardLine merchandise(final KnownActor... merchandise) {
		return inclusiveReward("Merchandise", merchandise);
	}

	public RewardLine inclusiveOptionalReward(final KnownActor... rewards) {
		return inclusiveReward("Not guaranteed", rewards);
	}
}
