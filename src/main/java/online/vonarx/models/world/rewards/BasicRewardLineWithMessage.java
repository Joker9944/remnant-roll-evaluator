package online.vonarx.models.world.rewards;

import lombok.EqualsAndHashCode;
import online.vonarx.constants.KnownActor;

@EqualsAndHashCode(callSuper = true)
public class BasicRewardLineWithMessage extends BasicRewardLine {

	private final String message;

	public BasicRewardLineWithMessage(final String message, final String combinator, final KnownActor... rewards) {
		super(combinator, rewards);
		this.message = message;
	}

	@Override
	public String printReward() {
		return "(" + message + ") " + super.printReward();
	}
}
