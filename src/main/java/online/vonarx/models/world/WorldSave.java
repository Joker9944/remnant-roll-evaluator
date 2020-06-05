package online.vonarx.models.world;

import lombok.Builder;
import lombok.Data;
import online.vonarx.constants.world.Mode;
import online.vonarx.dictionary.Dictionary;
import online.vonarx.models.character.Character;
import online.vonarx.models.world.rewards.RewardLine;

import java.util.List;

@Data
@Builder
public class WorldSave {

	private final Mode mode;
	private final Character character;
	private final List<Encounter> encounters;
	private final Dictionary<Encounter, List<RewardLine>> unattainedRewardsDictionary;
}
