package online.vonarx.models.world.rewards;

import lombok.EqualsAndHashCode;
import online.vonarx.constants.KnownActor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.List.of;

@EqualsAndHashCode(callSuper = true)
public class CombinationRewardLine extends RewardLine {

	private final String combinator;

	public CombinationRewardLine(final String message, final String combinator, final KnownActor... rewards) {
		super(message, of(rewards));
		this.combinator = combinator;
	}

	@Override
	public String printRewardInternal() {
		if (rewards.size() == 1)
			return rewards.get(0).displayName();
		final var sb = new StringBuilder();
		for (int index = 0; index < rewards.size(); index++) {
			sb.append(rewards.get(index).displayName());
			if (index < rewards.size() - 2)
				sb.append(", ");
			if (index == rewards.size() - 2)
				sb.append(combinator);
		}
		return sb.toString();
	}
}
