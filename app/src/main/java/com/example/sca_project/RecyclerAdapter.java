package com.example.sca_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<DataItem> myDataList = null;

    public final static int ITEM_ALRAM = 101;
    public final static int ITEM_JOURNAL = 102;
    public final static int ITEM_QNA = 103;
    public final static int ITEM_SCHEDULE = 104;
    Context context;

    RecyclerAdapter(Context context, ArrayList<DataItem> dataList)
    {
        this.context = context;
        myDataList = dataList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case ITEM_ALRAM:
                return new AlarmViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_alarm, parent, false));
            case ITEM_JOURNAL:
                return new JournalViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_journal, parent, false));
            case ITEM_QNA:
                return new QnaViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_alarm, parent, false));
            case ITEM_SCHEDULE:
                return new ScheduleViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_alarm, parent, false));

        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch (holder.getItemViewType()){
            case ITEM_ALRAM:
                DataItem item = myDataList.get(position);
                AlarmViewHolder alarmholder = (AlarmViewHolder) holder;
                alarmholder.alarmName.setText(item.getMain());
                alarmholder.alarmTime.setText(item.getAlarm_time());
                alarmholder.alarmPmam.setText(item.getAlarm_ampm());
                alarmholder.alarmCycle.setText(item.getAlarm_cycle());
                alarmholder.alarmSwitch.isChecked();
                break;
            case ITEM_JOURNAL:
                DataItem item1 = myDataList.get(position);
                JournalViewHolder journalholder = (JournalViewHolder) holder;
                journalholder.journalViewnum.setText(item1.getViewnum());
                journalholder.journalMain.setText(item1.getMain());
                journalholder.journalDay.setText(item1.getJournal_day());
                journalholder.journalTitle.setText(item1.getJournal_title());
                break;

            case ITEM_QNA:
                DataItem item2 = myDataList.get(position);
                QnaViewHolder qnaholder = (QnaViewHolder) holder;
                qnaholder.qnaViewnum.setText(item2.getViewnum());
                qnaholder.qnaMain.setText(item2.getMain());
                qnaholder.qnaTitle.setText(item2.getQna_title());
                break;

            case ITEM_SCHEDULE:
                DataItem item3 = myDataList.get(position);
                ScheduleViewHolder scholder = (ScheduleViewHolder) holder;
                scholder.scheduleTitle.setText(item3.getSchedule_title());
                break;

        }

    }


    @Override
    public int getItemViewType(int position) {
        if(myDataList.get(position).getAlarm_time().isEmpty() == false) {
            return ITEM_ALRAM;
        }
        if(myDataList.get(position).getJournal_title().isEmpty() == false) {
            return ITEM_JOURNAL;
        }
        if(myDataList.get(position).getQna_title().isEmpty() == false) {
            return ITEM_QNA;
        }
        if(myDataList.get(position).getSchedule_title().isEmpty() == false) {
            return ITEM_SCHEDULE;
        }
        return ITEM_ALRAM;
    }

    @Override
    public int getItemCount() {
        return myDataList.size();
    }


    public class AlarmViewHolder extends RecyclerView.ViewHolder{
        private TextView alarmCycle, alarmPmam, alarmTime, alarmName;
        private Switch alarmSwitch;

        public AlarmViewHolder(@NonNull View itemView) {
            super(itemView);

            alarmName =itemView.findViewById(R.id.item_alarm_main);
            alarmCycle =itemView.findViewById(R.id.item_alarm_cycle);
            alarmPmam = itemView.findViewById(R.id.item_alarm_pmam);
            alarmTime = itemView.findViewById(R.id.item_alarm_time);
            alarmSwitch = itemView.findViewById(R.id.item_alarm_switch);
        }
    }

    public class JournalViewHolder extends RecyclerView.ViewHolder{
        private TextView journalDay, journalTitle, journalMain, journalViewnum;

        public JournalViewHolder(@NonNull View itemView) {
            super(itemView);

            journalTitle = itemView.findViewById(R.id.item_journal_title);
            journalDay = itemView.findViewById(R.id.item_journal_day);
            journalMain = itemView.findViewById(R.id.item_journal_main);
            journalViewnum = itemView.findViewById(R.id.item_journal_viewnum);

        }
    }

    public class QnaViewHolder extends RecyclerView.ViewHolder{
        private TextView qnaTitle, qnaMain, qnaViewnum;

        public QnaViewHolder(@NonNull View itemView) {
            super(itemView);

            qnaTitle = itemView.findViewById(R.id.item_qna_title);
            qnaMain = itemView.findViewById(R.id.item_qna_main);
            qnaViewnum = itemView.findViewById(R.id.item_qna_viewnum);
        }
    }

    public class ScheduleViewHolder extends RecyclerView.ViewHolder{
        private TextView scheduleTitle;

        public ScheduleViewHolder(@NonNull View itemView) {
            super(itemView);

            scheduleTitle=itemView.findViewById(R.id.item_schedule_title);
        }
    }
}
