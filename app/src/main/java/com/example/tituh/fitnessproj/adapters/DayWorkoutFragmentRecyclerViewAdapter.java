package com.example.tituh.fitnessproj.adapters;

import android.app.AlertDialog;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.model.db.TrainingDatabase;
import com.example.tituh.fitnessproj.model.db.TrainingEntity;
import com.example.tituh.fitnessproj.model.db.TrainingRepository;
import com.example.tituh.fitnessproj.networking.responses.training.ResultsItem;
import com.example.tituh.fitnessproj.networking.threads.ExecutorsPool;
import com.example.tituh.fitnessproj.ui.interfaces.OnFragmentInteractionListener;

import java.util.ArrayList;
import java.util.List;


public class DayWorkoutFragmentRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private ArrayList<String> dayArrayList;
    private ArrayList<String> titleArray;
    private int countWeek;
    private int currentWeek;
    private Context context;
    private int level;
    private String week;
    private AlertDialog.Builder dialogBuilderInfo;
    private LayoutInflater layoutInflaterInfo;
    private View promptsViewinfo;
    private AlertDialog alertDialogInfo;
    private Button buttonDialogOk;
    private Button buttonDialogNo;
    private TextView textViewDialog;
    private ArrayList<Boolean> arrayListBool;
    private OnFragmentInteractionListener fragmentInteractionListener;

    public DayWorkoutFragmentRecyclerViewAdapter(ArrayList<String> dayArrayList, ArrayList<String> titleArray,
                                                 int countWeek, int currentWeek, Context context,
                                                 int level, String week, ArrayList<Boolean> boolArray,
                                                 OnFragmentInteractionListener fragmentInteractionListener) {
        this.dayArrayList = dayArrayList;
        this.titleArray = titleArray;
        this.countWeek = countWeek;
        this.currentWeek = currentWeek;
        this.context = context;
        this.level = level;
        this.week = week;
        this.arrayListBool = boolArray;
        this.fragmentInteractionListener = fragmentInteractionListener;
        dialogBuilderInfo = new AlertDialog.Builder(context);
        layoutInflaterInfo = LayoutInflater.from(context);
        promptsViewinfo = layoutInflaterInfo.inflate(R.layout.dialog_reset, null);
        dialogBuilderInfo.setView(promptsViewinfo);
        dialogBuilderInfo.setCancelable(false);
        buttonDialogOk = promptsViewinfo.findViewById(R.id.btn_reset_ok);
        buttonDialogNo = promptsViewinfo.findViewById(R.id.btn_reset_no);
        textViewDialog = promptsViewinfo.findViewById(R.id.textView_dialog_reset);
        textViewDialog.setText("Are you sure, you want to reset the progress of all days passed?");
        alertDialogInfo = dialogBuilderInfo.create();
        //noteDatabase = Room.databaseBuilder(context, TrainingDatabase.class, "db_training").build();
        //trainingRepository = new TrainingRepository(context);
        // trainingEntities = noteDatabase.trainingDao().getTrainingById(week, TrainingRepository.COMPLEXITY_ARR[level], id);
        // if (trainingEntities.isEmpty()) noteDatabase.trainingDao().addTraining(new TrainingEntity(complexity, repsCount, week, id));
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.day_workout_header, parent, false);
            return new DayWorkoutFragmentRecyclerViewAdapter.HeaderViewHolder(layoutView);
        } else if (viewType == TYPE_ITEM) {
            View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_day_item, parent, false);
            return new DayWorkoutFragmentRecyclerViewAdapter.ItemViewHolder(layoutView);
        }
        throw new RuntimeException("No match for " + viewType + ".");
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof DayWorkoutFragmentRecyclerViewAdapter.HeaderViewHolder) {
            ((DayWorkoutFragmentRecyclerViewAdapter.HeaderViewHolder) holder).mHeaderTitle1.setText("" + currentWeek);
            ((DayWorkoutFragmentRecyclerViewAdapter.HeaderViewHolder) holder).mHeaderTitle2.setText("OUT OF " + countWeek + " WEEKS");
            ((DayWorkoutFragmentRecyclerViewAdapter.HeaderViewHolder) holder).mButton.setText("RESET");
            ((DayWorkoutFragmentRecyclerViewAdapter.HeaderViewHolder) holder).mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialogInfo.show();
                }
            });
        } else if (holder instanceof DayWorkoutFragmentRecyclerViewAdapter.ItemViewHolder) {
            ((DayWorkoutFragmentRecyclerViewAdapter.ItemViewHolder) holder)
                    .mTextViewDay.setText(dayArrayList.get(position - 1));
            ((DayWorkoutFragmentRecyclerViewAdapter.ItemViewHolder) holder)
                    .mTextViewExercise.setText(titleArray.get(position - 1));

           /* ExecutorsPool.runCommonBgTask(new Runnable() {
                @Override
                public void run() {
                    if(trainingRepository.getDay(week, TrainingRepository.COMPLEXITY_ARR[level], 36,
                            mResultsItemsArray.get(position-1).getId())){
                        ((ItemViewHolder) holder).mImageViewArrow.setImageResource(R.drawable.completed_vector);
                    }
                }
            });*/

            /*trainingEntities = noteDatabase.trainingDao().getTrainingById(week, TrainingRepository.COMPLEXITY_ARR[level],
                    mResultsItemsArray.get(position).getId());
            if (!trainingEntities.isEmpty()){

            }*/
            if (arrayListBool.get(position - 1)) {
                ((ItemViewHolder) holder).mImageViewArrow.setImageResource(R.drawable.completed_vector);
            } else {
                ((ItemViewHolder) holder).mImageViewArrow.setImageResource(R.drawable.vector_arrow_right_black);
            }
            buttonDialogOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    fragmentInteractionListener.runUiTask(new Runnable() {
                        @Override
                        public void run() {
                            ExecutorsPool.runCommonBgTask(new Runnable() {
                                @Override
                                public void run() {
                                    TrainingRepository trainingRepository = new TrainingRepository(context);
                                    trainingRepository.resetByWeek(week, TrainingRepository.COMPLEXITY_ARR[level]);
                                    for (int i = 0; i < arrayListBool.size(); i++) {
                                        arrayListBool.set(i, false);
                                    }
                                    ((ItemViewHolder) holder).mImageViewArrow.setImageResource(R.drawable.vector_arrow_right_black);
                                }
                            });
                            notifyDataSetChanged();
                        }
                    });
                    alertDialogInfo.dismiss();
                }
            });
        }

        buttonDialogNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialogInfo.dismiss();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dayArrayList.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;
        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

    private class HeaderViewHolder extends RecyclerView.ViewHolder {

        private TextView mHeaderTitle1;
        private TextView mHeaderTitle2;
        private Button mButton;

        private HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            mHeaderTitle1 = (TextView) itemView.findViewById(R.id.text_view_quantity_day);
            mHeaderTitle2 = (TextView) itemView.findViewById(R.id.text_view_all_day);
            mButton = (Button) itemView.findViewById(R.id.btn_button_rest_day);
        }
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {

        ImageView mImageViewProgress;
        TextView mTextViewDay;
        TextView mTextViewExercise;
        ImageView mImageViewArrow;

        private ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageViewProgress = (ImageView) itemView.findViewById(R.id.image_view_day_workout_progress);
            mTextViewDay = (TextView) itemView.findViewById(R.id.text_view_day_workout);
            mTextViewExercise = (TextView) itemView.findViewById(R.id.text_view_what_exersice);
            mImageViewArrow = (ImageView) itemView.findViewById(R.id.image_view_day_workout_arrow);
        }
    }
}
