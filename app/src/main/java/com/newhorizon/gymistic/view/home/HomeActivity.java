package com.newhorizon.gymistic.view.home;

import static com.newhorizon.gymistic.util.AppConst.TRAINER_DATA;

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

import io.paperdb.Paper;

public class HomeActivity extends AppCompatActivity implements TrainerAdapter.TrainerClickListeners {

    //region Variables
    List<TrainerModel> trainerModelList;
    TrainerAdapter trainerAdapter;
    //endregion

    //region Components
    RecyclerView activityMainRecyclerViewTrainers;
    FloatingActionButton activityMainFloatingActionButton;
    //endregion


    //region Life cycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        List<TrainerModel> trainerModelList = Paper.book().read(TRAINER_DATA, new ArrayList<>());
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

    @Override
    protected void onResume() {
        super.onResume();
        trainerAdapter.updateList(Paper.book().read(TRAINER_DATA, new ArrayList<>()));
    }

    //endregion


    //region Adapter click listeners
    @Override
    public void onItemRecyclerTrainerCardViewMainContainerClickListener(int position, TrainerModel trainerModel) {

    }

    //endregion
}