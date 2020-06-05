package online.vonarx.models.world.rewards;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import lombok.Getter;
import online.vonarx.constants.KnownActor;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class RewardLine {

	private final String message;
	@Getter protected final List<KnownActor> rewards;

	protected RewardLine(final String message, final List<KnownActor> rewards) {
		this.message = message;
		this.rewards = new CopyOnWriteArrayList<>(rewards);
	}

	public final String printReward() {
		return message == null ? printRewardInternal() : "(" + message + ") " + printRewardInternal();
	}

	@CanIgnoreReturnValue
	public final boolean removeReward(final KnownActor reward) {
		return rewards.remove(reward);
	}

	public final boolean isRewardsPresent() {
		return rewards.size() != 0;
	}

	protected abstract String printRewardInternal();
}
