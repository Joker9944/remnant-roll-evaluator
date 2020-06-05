package online.vonarx.models.world.rewards;

import lombok.EqualsAndHashCode;
import online.vonarx.constants.KnownActor;

import static java.util.List.of;

@EqualsAndHashCode(callSuper = true)
public class SingleRewardLine extends RewardLine {

	public SingleRewardLine(final String message, final KnownActor reward) {
		super(message, of(reward));
	}

	@Override
	protected String printRewardInternal() {
		return rewards.get(0).displayName();
	}
}
