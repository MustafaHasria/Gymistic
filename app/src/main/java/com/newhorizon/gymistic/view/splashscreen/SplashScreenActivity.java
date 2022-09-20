package com.newhorizon.gymistic.view.splashscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.newhorizon.gymistic.util.AppConst;
import com.newhorizon.gymistic.view.home.HomeActivity;
import com.newhorizon.gymistic.view.registration.RegistrationActivity;

import io.paperdb.Paper;

public class SplashScreenActivity extends Activity {

    boolean isLoggedIn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Paper.init(this);
        isLoggedIn = Paper.book().read(AppConst.IS_LOGGED_IN, false);
        if (isLoggedIn)
            startActivity(new Intent(SplashScreenActivity.this, HomeActivity.class));
        else
            startActivity(new Intent(SplashScreenActivity.this, RegistrationActivity.class));
        finish();

    }
}
