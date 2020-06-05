package online.vonarx.components.dictionaries.character;

import online.vonarx.constants.character.Archetype;
import online.vonarx.dictionary.DictionaryWrapper;
import online.vonarx.dictionary.implementation.PartialKeyMapDictionary;

import javax.inject.Inject;

import static online.vonarx.constants.character.Archetype.*;

public class ArchetypeDictionary extends DictionaryWrapper<String, Archetype> {

	@Inject
	public ArchetypeDictionary() {
		super(PartialKeyMapDictionary.<Archetype>builder()
			.put("Archetype_Scrapper_UI", SCRAPPER)
			.put("Archetype_Cultist_UI", CULTIST)
			.put("Archetype_Hunter_UI", HUNTER)
			.build()
		);
	}
}
