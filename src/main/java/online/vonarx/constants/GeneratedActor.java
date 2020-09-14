package online.vonarx.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import online.vonarx.constants.world.Biome;
import online.vonarx.constants.world.Zone;

import java.util.Optional;

import static online.vonarx.constants.world.Biome.*;
import static online.vonarx.constants.world.Zone.NONE;

@RequiredArgsConstructor
public enum GeneratedActor {
	ACE(KnownActor.ACE, 0, "/Game/Generated/Quests/Quest_OverworldPOI_Ace", WARD_13, NONE),
	MC_CABE(KnownActor.MC_CABE, 0, "/Game/Generated/Quests/Quest_OverworldPOI_McCabe", WARD_13, NONE),
	REGGIE(KnownActor.REGGIE, 0, "/Game/Generated/Quests/Quest_OverworldPOI_Reggie", WARD_13, NONE),
	RIGS(KnownActor.RIGS, 0, "/Game/Generated/Quests/Quest_OverworldPOI_Rigs", WARD_13, NONE),
	SUBMACHINE_GUN(KnownActor.SUBMACHINE_GUN_PICKUP, 0, "/Game/Generated/Quests/Quest_Event_Submachinegun", WARD_13, NONE),
	TAPE_RECORDER(KnownActor.TAPE_RECORDER, 0, "/Game/Generated/Quests/Quest_Event_TapeRecorder", WARD_13, NONE),
	LETO_S_LAB(KnownActor.LETO_S_LAB, 0, "/Game/Generated/Quests/Quest_SmallD_LetosLab", CITY_EARTH, null),
	ISKAL_QUEEN_STORY(KnownActor.ISKAL_QUEEN_STORY, 1, "/Game/Generated/Quests/Quest_OverworldPOI_IskalQueen", CORSUS, null),
	ANCIENT_CONSTRUCT(KnownActor.ANCIENT_CONSTRUCT, 1, "/Game/Generated/Quests/Quest_Boss_AncientConstruct", RHOM, null),
	SOUL_LINK(KnownActor.SOUL_LINK, 1, "/Game/Generated/Quests/Quest_Event_SoulLink", RHOM, null),
	GUARDIAN_SHRINE(KnownActor.GUARDIAN_SHRINE, 1, "/Game/Generated/Quests/Quest_SmallD_GuardianShrine", YAESHA, null),
	ROOT_HORROR(KnownActor.ROOT_HORROR, 2, "/Game/Generated/Quests/Quest_Boss_RootHorror", YAESHA, null),
	DREAMER(KnownActor.DREAMER, 1, "/Game/Generated/Quests/Quest_Boss_Dreamer", WARD_17, NONE);

	@Getter private final KnownActor knownActor;
	@Getter private final int index;
	@Getter private final String identifier;
	@Getter private final Biome biome;
	private final Zone zoneOverride;

	public Optional<Zone> zoneOverride() {
		return Optional.ofNullable(zoneOverride);
	}
}
