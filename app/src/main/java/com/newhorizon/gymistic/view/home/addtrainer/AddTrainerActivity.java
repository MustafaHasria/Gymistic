package com.newhorizon.gymistic.view.home.addtrainer;

import static com.newhorizon.gymistic.util.AppConst.TRAINER_DATA;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.newhorizon.gymistic.R;
import com.newhorizon.gymistic.view.home.TrainerModel;
import com.tsongkha.spinnerdatepicker.SpinnerDatePickerDialogBuilder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;

import io.paperdb.Paper;

public class AddTrainerActivity extends AppCompatActivity {
    //region Components
    TextInputEditText activityAddTrainerTextInputEditTextName;
    TextInputEditText activityAddTrainerTextInputEditTextTypeOfSport;
    TextInputEditText activityAddTrainerTextInputEditTextCountOfCourses;
    Button activityAddTrainerButtonStartDate;
    Button activityAddTrainerButtonEndDate;
    Button activityAddTrainerButtonAdd;
    RadioGroup activityAddTrainerRadioGroup;
    CheckBox activityAddTrainerCheckBox;
    TextInputLayout activityAddTrainerTextInputLayoutCountOfCourses;
    //endregion

    //region Variables
    int yearStartDate;
    int monthStartDate;
    int dayStartDate;
    int yearEndDate;
    int monthEndDate;
    int dayEndDate;
    int totalYear, totalMonth, totalDay;
    String name, typeOfSport, countCourse, period;
    boolean isMale, isMonthly;
    //endregion

    //region Life cycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trainer);
        //region Find view by id
        activityAddTrainerTextInputEditTextName = findViewById(R.id.activity_add_trainer_text_input_edit_text_name);
        activityAddTrainerTextInputEditTextTypeOfSport = findViewById(R.id.activity_add_trainer_text_input_edit_text_type_of_sport);
        activityAddTrainerTextInputEditTextCountOfCourses = findViewById(R.id.activity_add_trainer_text_input_edit_text_count_of_courses);
        activityAddTrainerButtonStartDate = findViewById(R.id.activity_add_trainer_button_start_date);
        activityAddTrainerButtonEndDate = findViewById(R.id.activity_add_trainer_button_end_date);
        activityAddTrainerButtonAdd = findViewById(R.id.activity_add_trainer_button_add);
        activityAddTrainerRadioGroup = findViewById(R.id.activity_add_trainer_radio_group);
        activityAddTrainerCheckBox = findViewById(R.id.activity_add_trainer_check_box);
        activityAddTrainerTextInputLayoutCountOfCourses = findViewById(R.id.activity_add_trainer_text_input_layout_count_of_courses);
        //endregion

        activityAddTrainerButtonStartDate.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
            int currentYear = calendar.get(Calendar.YEAR);
            int currentMonth = calendar.get(Calendar.MONTH);
            int currentDay = calendar.get(Calendar.DAY_OF_MONTH);

            new SpinnerDatePickerDialogBuilder()
                    .context(AddTrainerActivity.this)
                    .callback((view, year, monthOfYear, dayOfMonth) -> {
                        yearStartDate = year;
                        monthStartDate = monthOfYear;
                        dayStartDate = dayOfMonth;
                        activityAddTrainerButtonEndDate.setVisibility(View.VISIBLE);
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

            new SpinnerDatePickerDialogBuilder()
                    .context(AddTrainerActivity.this)
                    .callback((view, year, monthOfYear, dayOfMonth) -> {
                        yearEndDate = year;
                        monthEndDate = monthOfYear;
                        dayEndDate = dayOfMonth;
                        activityAddTrainerButtonEndDate.setText("" + year + "/" + monthOfYear + "/" + dayOfMonth + "");
                    })
                    .spinnerTheme(R.style.NumberPickerStyle)
                    .showTitle(true)
                    .showDaySpinner(true)
                    .defaultDate(yearStartDate, monthStartDate, dayStartDate)
                    .minDate(yearStartDate, monthStartDate, dayStartDate)
                    .build()
                    .show();

        });

        activityAddTrainerCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                isMonthly = b;
                if (b)
                    activityAddTrainerTextInputLayoutCountOfCourses.setVisibility(View.GONE);
                else
                    activityAddTrainerTextInputLayoutCountOfCourses.setVisibility(View.VISIBLE);

            }
        });

        activityAddTrainerRadioGroup.setOnCheckedChangeListener((radioGroup, i) -> isMale = i == 1);
        activityAddTrainerButtonAdd.setOnClickListener(view -> {
            name = Objects.requireNonNull(activityAddTrainerTextInputEditTextName.getText()).toString();
            typeOfSport = Objects.requireNonNull(activityAddTrainerTextInputEditTextTypeOfSport.getText()).toString();
            countCourse = Objects.requireNonNull(activityAddTrainerTextInputEditTextCountOfCourses.getText()).toString();
            totalYear = yearEndDate - yearStartDate;
            totalMonth = monthEndDate - monthStartDate;
            totalDay = dayEndDate - dayStartDate;
            period = totalYear + "/" + totalMonth + "/" + totalDay;
            String startDate = yearStartDate + "/" + monthStartDate + "/" + dayStartDate;
            String endDate = yearEndDate + "/" + monthEndDate + "/" + dayEndDate;
            List<TrainerModel> trainerModelList = Paper.book().read(TRAINER_DATA, new ArrayList<>());
            if (isMonthly)
                countCourse = "0";
            trainerModelList.add(new TrainerModel(name, typeOfSport, isMale, startDate, endDate, isMonthly, Integer.parseInt(countCourse), period));
            Paper.book().write(TRAINER_DATA, trainerModelList);
            this.finish();
        });
    }
    //endregion
}