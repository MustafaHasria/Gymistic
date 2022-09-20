package com.newhorizon.gymistic.view.registration;

import static com.newhorizon.gymistic.util.AppConst.IS_LOGGED_IN;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.newhorizon.gymistic.R;
import com.newhorizon.gymistic.view.home.HomeActivity;

import io.paperdb.Paper;

public class RegistrationActivity extends AppCompatActivity {

    //region Components
    EditText activityRegistrationEditTextUsername;
    EditText activityRegistrationEditTextPassword;
    Button activityRegistrationButtonLogin;
    //endregion

    //region Variables
    String username, password;
    //endregion

    //region Life cycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        activityRegistrationEditTextUsername = findViewById(R.id.activity_registration_edit_text_username);
        activityRegistrationEditTextPassword = findViewById(R.id.activity_registration_edit_text_password);
        activityRegistrationButtonLogin = findViewById(R.id.activity_registration_button_login);

        activityRegistrationButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = activityRegistrationEditTextUsername.getText().toString();
                password = activityRegistrationEditTextPassword.getText().toString();

                if(username.equals("admin") && password.equals("admin")){
                    Paper.book().write(IS_LOGGED_IN, true);
                    startActivity(new Intent(RegistrationActivity.this, HomeActivity.class));
                    finish();
                }

                else
                    Toast.makeText(RegistrationActivity.this, "your credentials is wrong!", Toast.LENGTH_SHORT).show();
            }
        });

    }
    //endregion
}