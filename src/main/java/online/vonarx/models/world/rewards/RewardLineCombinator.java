package online.vonarx.models.world.rewards;

import online.vonarx.constants.KnownActor;

import java.util.Collection;
import java.util.List;

import static java.util.List.of;
import static java.util.stream.Collectors.toList;

public class RewardLineCombinator implements RewardLine {

	private final String combinator;
	private final List<RewardLine> rewardLines;

	public RewardLineCombinator(final String combinator, final RewardLine... rewardLines) {
		this.combinator = combinator;
		this.rewardLines = of(rewardLines);
	}

	@Override
	public List<KnownActor> rewards() {
		return rewardLines.stream()
			.map(RewardLine::rewards)
			.flatMap(Collection::stream)
			.collect(toList());
	}

	@Override
	public String printReward() {
		final var withRewards = rewardLines.stream().filter(RewardLine::isRewardsPresent).collect(toList());
		if (withRewards.size() == 1)
			return withRewards.get(0).printReward();
		final var sb = new StringBuilder();
		for (int index = 0; index < rewardLines.size(); index++) {
			sb.append(rewardLines.get(index).printReward());
			if (index < rewardLines.size() - 2)
				sb.append(", ");
			if (index == rewardLines.size() - 2)
				sb.append(" ").append(combinator).append(" ");
		}
		return sb.toString();
	}

	@Override
	public boolean removeReward(final KnownActor reward) {
		return rewardLines.stream()
			.anyMatch(rewardLine -> rewardLine.removeReward(reward));
	}

	@Override
	public boolean isRewardsPresent() {
		return rewardLines.stream().anyMatch(RewardLine::isRewardsPresent);
	}
}
