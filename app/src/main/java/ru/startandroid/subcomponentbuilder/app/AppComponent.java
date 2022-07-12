package ru.startandroid.subcomponentbuilder.app;

import dagger.Component;
import ru.startandroid.subcomponentbuilder.app.ComponentsHolder;
import ru.startandroid.subcomponentbuilder.app.dagger.AppModule;
import ru.startandroid.subcomponentbuilder.app.dagger.AppScope;

@AppScope
@Component(modules = AppModule.class)
public interface AppComponent {
    void injectComponentsHolder(ComponentsHolder componentsHolder);
}
