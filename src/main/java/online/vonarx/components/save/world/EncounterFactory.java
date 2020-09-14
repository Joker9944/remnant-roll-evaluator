package online.vonarx.components.save.world;

import online.vonarx.components.dictionaries.world.*;
import online.vonarx.constants.KnownActor;
import online.vonarx.constants.Type;
import online.vonarx.constants.world.Biome;
import online.vonarx.constants.world.Zone;
import online.vonarx.models.world.encounter.Encounter;
import online.vonarx.models.world.encounter.GeneratedEncounter;
import online.vonarx.models.world.encounter.KnownEncounter;
import online.vonarx.models.world.encounter.UnknownEncounter;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static java.util.List.of;

public class EncounterFactory {

	private final BiomeDictionary biomeDictionary;
	private final LocationDictionary locationDictionary;
	private final TypeDictionary typeDictionary;
	private final RewardDictionary rewardDictionary;
	private final KnownEncountersDictionary knownEncountersDictionary;
	private final GeneratedEncountersDictionary generatedEncountersDictionary;

	@Inject
	public EncounterFactory(final BiomeDictionary biomeDictionary, final LocationDictionary locationDictionary,
	                        final TypeDictionary typeDictionary, final RewardDictionary rewardDictionary,
	                        final KnownEncountersDictionary knownEncountersDictionary,
	                        final GeneratedEncountersDictionary generatedEncountersDictionary) {
		this.biomeDictionary = biomeDictionary;
		this.locationDictionary = locationDictionary;
		this.typeDictionary = typeDictionary;
		this.rewardDictionary = rewardDictionary;
		this.knownEncountersDictionary = knownEncountersDictionary;
		this.generatedEncountersDictionary = generatedEncountersDictionary;
	}

	public List<Encounter> create(final Zone zone, final String identifier) {
		return knownEncountersDictionary.lookup(identifier)
			.map(knownActor -> buildKnownEncounter(zone, identifier, knownActor))
			.orElseGet(() -> of(buildUnknownEncounter(zone, identifier)));
	}

	private List<Encounter> buildKnownEncounter(final Zone zone, final String identifier, final KnownActor originalKnownActor) {
		final var encounters = new ArrayList<Encounter>();
		encounters.add(KnownEncounter.builder()
			.knownActor(originalKnownActor)
			.identifier(identifier)
			.biome(biomeDictionary.lookup(identifier).orElse(Biome.UNKNOWN))
			.zone(zone)
			.location(locationDictionary.lookup(originalKnownActor).orElse(null))
			.rewardLines(rewardDictionary.lookup(originalKnownActor).orElse(of()))
			.build());
		generatedEncountersDictionary.lookup(originalKnownActor).ifPresent(generatedKnownActors -> generatedKnownActors.forEach(generatedKnownActor -> {
			encounters.add(generatedKnownActor.index(), GeneratedEncounter.builder()
				.knownActor(generatedKnownActor.knownActor())
				.identifier(generatedKnownActor.identifier())
				.biome(generatedKnownActor.biome())
				.zone(generatedKnownActor.zoneOverride().orElse(zone))
				.location(locationDictionary.lookup(generatedKnownActor.knownActor()).orElse(null))
				.rewardLines(rewardDictionary.lookup(generatedKnownActor.knownActor()).orElse(of()))
				.build());
		}));
		return encounters;
	}

	private UnknownEncounter buildUnknownEncounter(final Zone zone, final String identifier) {
		return UnknownEncounter.builder()
			.identifier(identifier)
			.biome(biomeDictionary.lookup(identifier).orElse(Biome.UNKNOWN))
			.type(typeDictionary.lookup(identifier).orElse(Type.OTHER))
			.zone(zone)
			.build();
	}
}
