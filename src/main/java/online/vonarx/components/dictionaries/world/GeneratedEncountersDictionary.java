package online.vonarx.components.dictionaries.world;

import online.vonarx.constants.GeneratedActor;
import online.vonarx.constants.KnownActor;
import online.vonarx.dictionary.DictionaryWrapper;
import online.vonarx.dictionary.implementation.MapDictionary;

import javax.inject.Inject;
import java.util.List;

import static java.util.List.of;
import static online.vonarx.constants.KnownActor.*;

public class GeneratedEncountersDictionary extends DictionaryWrapper<KnownActor, List<GeneratedActor>> {

	@Inject
	public GeneratedEncountersDictionary() {
		super(MapDictionary.<KnownActor, List<GeneratedActor>>builder()
			.put(RIPHIDE, of(GeneratedActor.LETO_S_LAB))
			.put(WUD, of(GeneratedActor.ANCIENT_CONSTRUCT))
			.put(CRYPTOLITH_RHOM, of(GeneratedActor.SOUL_LINK))
			.put(STUCK_MERCHANT, of(GeneratedActor.GUARDIAN_SHRINE, GeneratedActor.ROOT_HORROR))
			.put(CAMPAIGN_EARTH, of(GeneratedActor.TAPE_RECORDER, GeneratedActor.SUBMACHINE_GUN, GeneratedActor.RIGS, GeneratedActor.REGGIE, GeneratedActor.MC_CABE, GeneratedActor.ACE))
			.put(CAMPAIGN_WARD_17, of(GeneratedActor.DREAMER))
			// TODO verify location in story
			.put(CAMPAIGN_CORSUS, of(GeneratedActor.ISKAL_QUEEN_STORY))
			.build());
	}
}
