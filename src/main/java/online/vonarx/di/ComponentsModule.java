package online.vonarx.di;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import dagger.Module;
import dagger.Provides;
import online.vonarx.components.formatters.ListAdventureModeFormatter;
import online.vonarx.components.formatters.ListStoryModeFormatter;
import online.vonarx.components.formatters.TableAdventureModeFormatter;
import online.vonarx.components.formatters.TableStoryModeFormatter;
import online.vonarx.components.save.world.AdventureModeFactory;
import online.vonarx.components.save.world.StoryModeFactory;
import online.vonarx.constants.world.Mode;
import online.vonarx.formatter.ModeFormatter;
import online.vonarx.models.AppParameters;
import online.vonarx.save.ModeFactory;

import javax.inject.Singleton;
import java.util.List;
import java.util.Map;

@Module
public abstract class ComponentsModule {

	@Provides
	@Singleton
	static List<ModeFactory> mapSaveFactories(final AppParameters parameters,
	                                          final StoryModeFactory storySaveFactory, final AdventureModeFactory adventureSaveFactory) {
		final var listBuilder = ImmutableList.<ModeFactory>builder();
		final var modes = parameters.modes();
		if (modes.contains(Mode.STORY))
			listBuilder.add(storySaveFactory);
		if (modes.contains(Mode.ADVENTURE))
			listBuilder.add(adventureSaveFactory);
		return listBuilder.build();
	}

	@Provides
	@Singleton
	static Map<Mode, ModeFormatter> mapSaveFormatter(final AppParameters parameters,
	                                                 final TableStoryModeFormatter tableStoryFormatter, final ListStoryModeFormatter listStoryFormatter,
	                                                 final TableAdventureModeFormatter tableAdventureFormatter, final ListAdventureModeFormatter listAdventureFormatter) {
		final var formatterMapBuilder = ImmutableMap.<Mode, ModeFormatter>builder();
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
