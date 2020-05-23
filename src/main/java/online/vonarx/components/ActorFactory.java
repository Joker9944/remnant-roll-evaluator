package online.vonarx.components;

import online.vonarx.components.dictionaries.*;
import online.vonarx.constants.Biome;
import online.vonarx.constants.Origin;
import online.vonarx.constants.Type;
import online.vonarx.constants.Zone;
import online.vonarx.models.Actor;

import javax.inject.Inject;

public class ActorFactory {

	private final OriginDictionary originDictionary;
	private final BiomeDictionary biomeDictionary;
	private final LocationDictionary locationDictionary;
	private final TypeDictionary typeDictionary;
	private final NameDictionary nameDictionary;

	@Inject
	public ActorFactory(final OriginDictionary originDictionary, final BiomeDictionary biomeDictionary,
	                    final LocationDictionary locationDictionary, final TypeDictionary typeDictionary,
	                    final NameDictionary nameDictionary) {
		this.originDictionary = originDictionary;
		this.biomeDictionary = biomeDictionary;
		this.locationDictionary = locationDictionary;
		this.typeDictionary = typeDictionary;
		this.nameDictionary = nameDictionary;
	}

	public Actor create(final Zone zone, final String identifier) {
		return Actor.builder()
			.origin(originDictionary.lookup(identifier).orElse(Origin.UNKNOWN))
			.identifier(identifier)
			.biome(biomeDictionary.lookup(identifier).orElse(Biome.UNKNOWN))
			.zone(zone)
			.subZone(locationDictionary.lookup(identifier).orElse(null))
			.type(typeDictionary.lookup(identifier).orElse(Type.OTHER))
			.name(nameDictionary.lookup(identifier).orElse(null))
			.build();
	}
}
