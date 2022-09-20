package com.newhorizon.gymistic.view.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.newhorizon.gymistic.R;

import java.util.List;

public class TrainerAdapter extends RecyclerView.Adapter<TrainerAdapter.TrainerViewHolder>{

    //region Adapter

    //region Variables
    private List<TrainerModel> trainerModelList;
    private Context context;
    private TrainerClickListeners trainerClickListeners;
    //endregion

    //region Constructor

    public TrainerAdapter(List<TrainerModel> trainerModelList, TrainerClickListeners trainerClickListeners) {
        this.trainerModelList = trainerModelList;
        this.trainerClickListeners = trainerClickListeners;
    }


    //endregion

    @NonNull
    @Override
    public TrainerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_trainer, parent, false);
        context = parent.getContext();
        return new TrainerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrainerViewHolder holder, int position) {
        holder.itemRecyclerTrainerTextViewName.setText(trainerModelList.get(position).getName());
        holder.itemRecyclerTrainerTextViewCharacter.setText(trainerModelList.get(position).getName().toUpperCase().substring(0,1));
        holder.itemRecyclerTrainerTextViewType.setText("type: " + trainerModelList.get(position).getType());
        holder.itemRecyclerTrainerCardViewMainContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, ""+ trainerModelList.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return trainerModelList.size();
    }

    //endregion

    //region Interface click listener
    interface TrainerClickListeners{
        void onItemRecyclerTrainerCardViewMainContainerClickListener(int position, TrainerModel trainerModel);
    }
    //endregion

    //region View holder
    class TrainerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        //region Components
        CardView itemRecyclerTrainerCardViewMainContainer;
        ImageView itemRecyclerTrainerImageViewBackground;
        TextView itemRecyclerTrainerTextViewCharacter;
        TextView itemRecyclerTrainerTextViewName;
        TextView itemRecyclerTrainerTextViewPeriod;
        TextView itemRecyclerTrainerTextViewType;
        //endregion

        //region Constructor
        public TrainerViewHolder(@NonNull View itemView) {
            super(itemView);

            itemRecyclerTrainerCardViewMainContainer = itemView.findViewById(R.id.item_recycler_trainer_card_view_main_container);
            itemRecyclerTrainerImageViewBackground = itemView.findViewById(R.id.item_recycler_trainer_image_view_background);
            itemRecyclerTrainerTextViewCharacter = itemView.findViewById(R.id.item_recycler_trainer_text_view_character);
            itemRecyclerTrainerTextViewName = itemView.findViewById(R.id.item_recycler_trainer_text_view_name);
            itemRecyclerTrainerTextViewPeriod = itemView.findViewById(R.id.item_recycler_trainer_text_view_period);
            itemRecyclerTrainerTextViewType = itemView.findViewById(R.id.item_recycler_trainer_text_view_type);

            itemRecyclerTrainerCardViewMainContainer.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
        }
        //endregion
    }
    //endregion


}
