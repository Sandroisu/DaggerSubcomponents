package ru.startandroid.subcomponentbuilder.app.dagger;

import dagger.Component;
import ru.startandroid.subcomponentbuilder.first.dagger.FirstActivityComponent;
import ru.startandroid.subcomponentbuilder.second.dagger.SecondActivityComponent;
import ru.startandroid.subcomponentbuilder.second.dagger.SecondActivityModule;

@AppScope
@Component(modules = AppModule.class)
public interface AppComponent {
    FirstActivityComponent createFirstActivityComponent();
    SecondActivityComponent createSecondActivityComponent(SecondActivityModule secondActivityModule);
}