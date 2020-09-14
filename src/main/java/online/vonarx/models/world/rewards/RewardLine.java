package online.vonarx.models.world.rewards;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import online.vonarx.constants.KnownActor;

import java.util.List;

public interface RewardLine {

	List<KnownActor> rewards();

	String printReward();

	@CanIgnoreReturnValue
	boolean removeReward(final KnownActor reward);

	boolean isRewardsPresent();
}
