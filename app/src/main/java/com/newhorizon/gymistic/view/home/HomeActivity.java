package com.newhorizon.gymistic.view.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.newhorizon.gymistic.R;
import com.newhorizon.gymistic.view.home.addtrainer.AddTrainerActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements TrainerAdapter.TrainerClickListeners {

    //region Variables
    List<TrainerModel> trainerModelList;
    TrainerAdapter trainerAdapter;
    //endregion

    //region Components
    RecyclerView activityMainRecyclerViewTrainers;
    FloatingActionButton activityMainFloatingActionButton;
    //endregion


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        trainerModelList = new ArrayList<>();
        trainerModelList.add(new TrainerModel("Ahmad", "Gym", true, "1/1/2001", "1/2/2003", true, 16));
        trainerModelList.add(new TrainerModel("Rama", "Balieh", true, "1/1/2001", "1/2/2003", true, 16));
        trainerModelList.add(new TrainerModel("Mohammad", "Airobic", true, "1/1/2001", "1/2/2003", true, 16));
        trainerModelList.add(new TrainerModel("Mustafa", "Basketball", true, "1/1/2001", "1/2/2003", true, 16));
        trainerModelList.add(new TrainerModel("Nour", "Gym", true, "1/1/2001", "1/2/2003", true, 16));
        trainerAdapter = new TrainerAdapter(trainerModelList, this);
        activityMainRecyclerViewTrainers = findViewById(R.id.activity_main_recycler_view_trainers);
        activityMainFloatingActionButton = findViewById(R.id.activity_main_floating_action_button);
        activityMainRecyclerViewTrainers.setAdapter(trainerAdapter);

        activityMainFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, AddTrainerActivity.class));
            }
        });

    }


    //region Adapter click listeners
    @Override
    public void onItemRecyclerTrainerCardViewMainContainerClickListener(int position, TrainerModel trainerModel) {

    }

    //endregion
}