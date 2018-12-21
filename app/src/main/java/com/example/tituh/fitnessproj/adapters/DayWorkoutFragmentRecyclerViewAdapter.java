package com.example.tituh.fitnessproj.adapters;

import android.app.AlertDialog;
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
import com.example.tituh.fitnessproj.model.db.TrainingRepository;
import com.example.tituh.fitnessproj.networking.threads.ExecutorsPool;

import java.util.ArrayList;


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

    public DayWorkoutFragmentRecyclerViewAdapter(ArrayList<String> dayArrayList, ArrayList<String> titleArray,
                                                 int countWeek, int currentWeek, Context context,
                                                 int level, String week) {
        this.dayArrayList = dayArrayList;
        this.titleArray = titleArray;
        this.countWeek = countWeek;
        this.currentWeek = currentWeek;
        this.context = context;
        this.level = level;
        this.week = week;
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
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
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
        }

        buttonDialogNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialogInfo.dismiss();
            }
        });

        buttonDialogOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ExecutorsPool.runCommonBgTask(new Runnable() {
                    @Override
                    public void run() {
                        TrainingRepository trainingRepository = new TrainingRepository(context);
                        trainingRepository.resetByWeek(week, TrainingRepository.COMPLEXITY_ARR[level]);
                    }
                });
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
