package com.newhorizon.gymistic.view.home.addtrainer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.newhorizon.gymistic.R;
import com.tsongkha.spinnerdatepicker.SpinnerDatePickerDialogBuilder;

import java.util.Calendar;
import java.util.TimeZone;

public class AddTrainerActivity extends AppCompatActivity {
    //region Components
    TextInputEditText activityAddTrainerTextInputEditTextName;
    TextInputEditText activityAddTrainerTextInputEditTextTypeOfSport;
    TextInputEditText activityAddTrainerTextInputEditCountOfCourses;
    Button activityAddTrainerButtonStartDate;
    Button activityAddTrainerButtonEndDate;
    Button activityAddTrainerButtonAdd;
    RadioGroup activityAddTrainerRadioGroup;
    CheckBox activityAddTrainerCheckBox;
    //endregion

    //region Variables
    int currentYearEndDate;
    int currentMonthEndDate;
    int currentDayEndDate;

    //endregion

    //region Life cycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trainer);
        //region Find view by id
        activityAddTrainerTextInputEditTextName = findViewById(R.id.activity_add_trainer_text_input_edit_text_name);
        activityAddTrainerTextInputEditTextTypeOfSport = findViewById(R.id.activity_add_trainer_text_input_edit_text_type_of_sport);
        activityAddTrainerTextInputEditCountOfCourses = findViewById(R.id.activity_add_trainer_text_input_edit_text_type_of_count_of_courses);
        activityAddTrainerButtonStartDate = findViewById(R.id.activity_add_trainer_button_start_date);
        activityAddTrainerButtonEndDate = findViewById(R.id.activity_add_trainer_button_end_date);
        activityAddTrainerButtonAdd = findViewById(R.id.activity_add_trainer_button_add);
        activityAddTrainerRadioGroup = findViewById(R.id.activity_add_trainer_radio_group);
        activityAddTrainerCheckBox = findViewById(R.id.activity_add_trainer_check_box);
        //endregion

        activityAddTrainerButtonStartDate.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
            int currentYear = calendar.get(Calendar.YEAR);
            int currentMonth = calendar.get(Calendar.MONTH);
            int currentDay = calendar.get(Calendar.DAY_OF_MONTH);

            new SpinnerDatePickerDialogBuilder()
                    .context(AddTrainerActivity.this)
                    .callback((view, year, monthOfYear, dayOfMonth) -> {
                        currentYearEndDate = year;
                        currentMonthEndDate = monthOfYear;
                        activityAddTrainerButtonEndDate.setVisibility(View.VISIBLE);
                        currentDayEndDate = dayOfMonth;
                        activityAddTrainerButtonStartDate.setText("" + year + "/" + monthOfYear + "/" + dayOfMonth + "");
                    })
                    .spinnerTheme(R.style.NumberPickerStyle)
                    .showTitle(true)
                    .showDaySpinner(true)
                    .defaultDate(currentYear, currentMonth, currentDay)
                    .minDate(currentYear, currentMonth, currentDay)
                    .build()
                    .show();

        });

        activityAddTrainerButtonEndDate.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
            int currentYear = calendar.get(Calendar.YEAR);
            int currentMonth = calendar.get(Calendar.MONTH);
            int currentDay = calendar.get(Calendar.DAY_OF_MONTH);

            new SpinnerDatePickerDialogBuilder()
                    .context(AddTrainerActivity.this)
                    .callback((view, year, monthOfYear, dayOfMonth) -> {
                        activityAddTrainerButtonEndDate.setText("" + year + "/" + monthOfYear + "/" + dayOfMonth + "");
                    })
                    .spinnerTheme(R.style.NumberPickerStyle)
                    .showTitle(true)
                    .showDaySpinner(true)
                    .defaultDate(currentYearEndDate, currentMonthEndDate, currentDayEndDate)
                    .minDate(currentYearEndDate, currentMonthEndDate, currentDayEndDate)
                    .build()
                    .show();

        });
    }
    //endregion
}