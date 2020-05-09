package online.vonarx.actor;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RelatedActor {

	private final String identifier;
	private final Type type;
	private final String name;
	private final String subZone;

	public RelatedActor(final String identifier, final Type type, final String name) {
		this.identifier = identifier;
		this.type = type;
		this.name = name;
		subZone = null;
	}

	public Actor adapt(final Actor actor) {
		return new Actor(actor.mode(), actor.origin(), identifier, actor.biome(), actor.zone(), subZone, type, name);
	}
}
