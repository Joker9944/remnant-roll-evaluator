package online.vonarx.di;

import com.mitchtalmadge.asciidata.table.formats.ASCIITableFormat;
import dagger.Module;
import dagger.Provides;
import online.vonarx.components.formatters.ListAdventureFormatter;
import online.vonarx.components.formatters.TableAdventureFormatter;
import online.vonarx.formatter.Formatter;
import online.vonarx.models.AppParameters;

import javax.inject.Singleton;

@Module
public abstract class SaveFormatterModule {

	@Provides
	@Singleton
	static Formatter provideSaveFormatter(final AppParameters appParameters) {
		if (appParameters.printerType().equals(AppParameters.SaveFormatterType.TABLE))
			return new TableAdventureFormatter(appParameters.showIdentifiers(), appParameters.showEngineActors(), new ASCIITableFormat());
		else
			return new ListAdventureFormatter(appParameters.showIdentifiers(), appParameters.showEngineActors());
	}
}
