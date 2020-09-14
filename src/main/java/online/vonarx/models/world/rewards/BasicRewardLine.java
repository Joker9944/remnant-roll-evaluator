package online.vonarx.models.world.rewards;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import online.vonarx.constants.KnownActor;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@EqualsAndHashCode
public class BasicRewardLine implements RewardLine {

	private final String combinator;
	@Getter protected final List<KnownActor> rewards;

	public BasicRewardLine(final String combinator, final KnownActor... rewards) {
		this.combinator = combinator;
		this.rewards = new CopyOnWriteArrayList<>(rewards);
	}

	@Override
	public String printReward() {
		if (rewards.size() == 1)
			return rewards.get(0).displayName();
		final var sb = new StringBuilder();
		for (int index = 0; index < rewards.size(); index++) {
			sb.append(rewards.get(index).displayName());
			if (index < rewards.size() - 2)
				sb.append(", ");
			if (index == rewards.size() - 2)
				sb.append(" ").append(combinator).append(" ");
		}
		return sb.toString();
	}

	@Override
	public final boolean removeReward(final KnownActor reward) {
		return rewards.remove(reward);
	}

	@Override
	public final boolean isRewardsPresent() {
		return rewards.size() != 0;
	}
}
