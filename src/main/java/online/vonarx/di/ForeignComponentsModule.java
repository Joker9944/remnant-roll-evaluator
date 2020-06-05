package online.vonarx.di;

import com.mitchtalmadge.asciidata.table.formats.ASCIITableFormat;
import com.mitchtalmadge.asciidata.table.formats.TableFormatAbstract;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;
import java.io.PrintStream;

@Module
public abstract class ForeignComponentsModule {

	@Provides
	@Singleton
	static PrintStream providePrintStream() {
		return System.out;
	}

	@Provides
	@Singleton
	static TableFormatAbstract provideTableFormat() {
		return new ASCIITableFormat();
	}
}
