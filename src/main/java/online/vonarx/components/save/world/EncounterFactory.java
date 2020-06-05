package online.vonarx.components.save.world;

import online.vonarx.components.dictionaries.world.*;
import online.vonarx.constants.world.Biome;
import online.vonarx.constants.Type;
import online.vonarx.constants.world.Zone;
import online.vonarx.models.world.Encounter;
import online.vonarx.models.world.KnownEncounter;
import online.vonarx.models.world.UnknownEncounter;

import javax.inject.Inject;

import static java.util.List.of;

public class EncounterFactory {

	private final BiomeDictionary biomeDictionary;
	private final LocationDictionary locationDictionary;
	private final TypeDictionary typeDictionary;
	private final RewardDictionary rewardDictionary;
	private final KnownEncountersDictionary knownEncountersDictionary;

	@Inject
	public EncounterFactory(final BiomeDictionary biomeDictionary, final LocationDictionary locationDictionary,
	                        final TypeDictionary typeDictionary, final RewardDictionary rewardDictionary,
	                        final KnownEncountersDictionary knownEncountersDictionary) {
		this.biomeDictionary = biomeDictionary;
		this.locationDictionary = locationDictionary;
		this.typeDictionary = typeDictionary;
		this.rewardDictionary = rewardDictionary;
		this.knownEncountersDictionary = knownEncountersDictionary;
	}

	public Encounter create(final Zone zone, final String identifier) {
		final var knownActorOptional = knownEncountersDictionary.lookup(identifier);
		final var biome = biomeDictionary.lookup(identifier).orElse(Biome.UNKNOWN);
		if (knownActorOptional.isPresent()) {
			final var knownActor = knownActorOptional.get();
			final var location = locationDictionary.lookup(knownActor).orElse(null);
			final var rewardLines = rewardDictionary.lookup(knownActor).orElse(of());
			return KnownEncounter.builder()
				.knownActor(knownActor)
				.identifier(identifier)
				.biome(biome)
				.zone(zone)
				.location(location)
				.rewardLines(rewardLines)
				.build();
		} else {
			final var type = typeDictionary.lookup(identifier).orElse(Type.OTHER);
			return UnknownEncounter.builder()
				.identifier(identifier)
				.biome(biome)
				.type(type)
				.zone(zone)
				.build();
		}
	}
}
