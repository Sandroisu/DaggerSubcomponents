package ru.startandroid.subcomponentbuilder.first;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.startandroid.subcomponentbuilder.R;
import ru.startandroid.subcomponentbuilder.first.dagger.FirstActivityComponent;
import ru.startandroid.subcomponentbuilder.second.SecondActivity;
import ru.startandroid.subcomponentbuilder.app.App;

public class FirstActivity extends AppCompatActivity {

    @Inject
    FirstActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        ButterKnife.bind(this);
        FirstActivityComponent component =
                (FirstActivityComponent) App.getApp(this).getComponentsHolder()
                        .getActivityComponent(getClass());
        component.inject(this);
    }

    @OnClick(R.id.goToSecondActivity)
    void onGoToSecondActivityClick() {
        startActivity(new Intent(this, SecondActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            App.getApp(this).getComponentsHolder().releaseActivityComponent(getClass());
        }
    }
}
