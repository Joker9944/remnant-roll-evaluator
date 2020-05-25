package online.vonarx.di;

import com.google.common.collect.ImmutableMap;
import dagger.Module;
import dagger.Provides;
import online.vonarx.components.formatters.ListAdventureFormatter;
import online.vonarx.components.formatters.ListStoryFormatter;
import online.vonarx.components.formatters.TableAdventureFormatter;
import online.vonarx.components.formatters.TableStoryFormatter;
import online.vonarx.components.save.AdventureSaveFactory;
import online.vonarx.components.save.StorySaveFactory;
import online.vonarx.constants.Mode;
import online.vonarx.formatter.Formatter;
import online.vonarx.models.AppParameters;
import online.vonarx.save.SaveFactory;

import javax.inject.Singleton;
import java.util.Map;

@Module
public abstract class ComponentsModule {

	@Provides
	@Singleton
	static Map<Mode, SaveFactory> mapSaveFactories(final AppParameters parameters,
	                                               final StorySaveFactory storySaveFactory, final AdventureSaveFactory adventureSaveFactory) {
		final var factoryMapBuilder = ImmutableMap.<Mode, SaveFactory>builder();
		final var modes = parameters.modes();
		if (modes.contains(Mode.STORY))
			factoryMapBuilder.put(Mode.STORY, storySaveFactory);
		if (modes.contains(Mode.ADVENTURE))
			factoryMapBuilder.put(Mode.ADVENTURE, adventureSaveFactory);
		return factoryMapBuilder.build();
	}

	@Provides
	@Singleton
	static Map<Mode, Formatter> mapSaveFormatter(final AppParameters parameters,
	                                             final TableStoryFormatter tableStoryFormatter, final ListStoryFormatter listStoryFormatter,
	                                             final TableAdventureFormatter tableAdventureFormatter, final ListAdventureFormatter listAdventureFormatter) {
		final var formatterMapBuilder = ImmutableMap.<Mode, Formatter>builder();
		final var modes = parameters.modes();
		if (parameters.printerType().equals(AppParameters.SaveFormatterType.TABLE)) {
			if (modes.contains(Mode.STORY))
				formatterMapBuilder.put(Mode.STORY, tableStoryFormatter);
			if (modes.contains(Mode.ADVENTURE))
				formatterMapBuilder.put(Mode.ADVENTURE, tableAdventureFormatter);
		} else {
			if (modes.contains(Mode.STORY))
				formatterMapBuilder.put(Mode.STORY, listStoryFormatter);
			if (modes.contains(Mode.ADVENTURE))
				formatterMapBuilder.put(Mode.ADVENTURE, listAdventureFormatter);
		}
		return formatterMapBuilder.build();
	}
}
