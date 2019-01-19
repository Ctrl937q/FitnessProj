package com.example.tituh.fitnessproj.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.networking.responses.training.WorkoutsItem;

import java.util.List;

public class GlossaryWorkoutsRecyclerViewAdapter extends RecyclerView.Adapter<GlossaryWorkoutsRecyclerViewAdapter.ViewHolder> {

    private List<WorkoutsItem> mList;
    private Context context;
    private AlertDialog.Builder dialogBuilderInfo;
    private LayoutInflater layoutInflaterInfo;
    private View promptsViewinfo;
    private AlertDialog alertDialogInfo;
    private Button buttonInfoDialog;
    private TextView textViewInfoDialog;

    public GlossaryWorkoutsRecyclerViewAdapter(List<WorkoutsItem> mList, Context context) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public GlossaryWorkoutsRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_glossary_item, parent, false);
        return new GlossaryWorkoutsRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GlossaryWorkoutsRecyclerViewAdapter.ViewHolder holder, final int position) {

        Glide.with(context)
                .asBitmap()
                .load(mList.get(position).getImage())
                .apply(new RequestOptions().override(150, 130)
                        .placeholder(R.drawable.placeholder_recipes))
                .into(holder.imageViewGlossary);

        holder.mTextViewWarmUpNameGlossary.setText(mList.get(position).getTitle());
        holder.mTextViewWarmUpDurationGlossary.setText("" + secondsToString(mList.get(position).getDuration()));
        if (mList.get(position).getInfo().equalsIgnoreCase("-")) {
            holder.imageViewInfoGlossary.setVisibility(View.GONE);
        } else {
            holder.imageViewInfoGlossary.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (textViewInfoDialog != null && mList != null) {
                        textViewInfoDialog.setText(mList.get(position).getInfo());
                        alertDialogInfo.show();
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextViewWarmUpNameGlossary;
        private TextView mTextViewWarmUpDurationGlossary;
        private ImageView imageViewGlossary;
        private ImageView imageViewInfoGlossary;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dialogBuilderInfo = new AlertDialog.Builder(context);
            layoutInflaterInfo = LayoutInflater.from(context);
            promptsViewinfo = layoutInflaterInfo.inflate(R.layout.dialog_info, null);
            dialogBuilderInfo.setView(promptsViewinfo);
            dialogBuilderInfo.setCancelable(false);

            buttonInfoDialog = promptsViewinfo.findViewById(R.id.btn_ok_dialog_info);
            textViewInfoDialog = promptsViewinfo.findViewById(R.id.text_info_dialog_exercise_do);
            alertDialogInfo = dialogBuilderInfo.create();

            buttonInfoDialog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialogInfo.dismiss();
                }
            });
            mTextViewWarmUpNameGlossary = itemView.findViewById(R.id.warm_up_name_glossary);
            mTextViewWarmUpDurationGlossary = itemView.findViewById(R.id.textView_time_exercise_2_glossary);
            imageViewGlossary = itemView.findViewById(R.id.imageView_glossary);
            imageViewInfoGlossary = itemView.findViewById(R.id.image_view_info_glossary);
        }
    }


    private String secondsToString(double pTimee) {
        int pTime = (int) pTimee;
        if (pTime < 60) {
            String time = String.valueOf(pTime) + " sec";
            return time;
        } else {
            String timeMin = String.valueOf(pTime / 60);
            String timeSec = String.valueOf(pTime % 60);
            if (timeSec.equals("0")) {
                return timeMin + " min";
            } else {
                String time = timeMin + " min " + timeSec + " sec";
                return time;
            }
        }
    }
}
