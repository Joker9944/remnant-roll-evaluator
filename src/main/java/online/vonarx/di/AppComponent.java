package online.vonarx.di;

import dagger.BindsInstance;
import dagger.Component;
import online.vonarx.components.App;
import online.vonarx.models.AppParameters;

import javax.inject.Singleton;

@Component(modules = {ComponentsModule.class, ForeignComponentsModule.class})
@Singleton
public interface AppComponent {
	App app();

	@Component.Factory
	interface Factory {
		AppComponent create(@BindsInstance final AppParameters appParameters);
	}
}
