package com.example.sca_project;

import android.graphics.drawable.Drawable;

public class DataItem {
    private String viewnum, main;
    private String journal_title, qna_title, schedule_title;
    private String alarm_cycle, alarm_time, alarm_ampm, alarm_title;
    private String journal_day;


    public String getViewnum() {
        return viewnum;
    }

    public void setViewnum(String viewnum) {
        this.viewnum = viewnum;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }


    public String getAlarm_cycle() {
        return alarm_cycle;
    }

    public void setAlarm_cycle(String alarm_cycle) {
        this.alarm_cycle = alarm_cycle;
    }

    public String getAlarm_time() {
        return alarm_time;
    }

    public void setAlarm_time(String alarm_time) {
        this.alarm_time = alarm_time;
    }

    public String getAlarm_ampm() {
        return alarm_ampm;
    }

    public void setAlarm_ampm(String alarm_ampm) {
        this.alarm_ampm = alarm_ampm;
    }

    public String getJournal_day() {
        return journal_day;
    }

    public void setJournal_day(String journal_day) {
        this.journal_day = journal_day;
    }

    public String getJournal_title() {
        return journal_title;
    }

    public void setJournal_title(String journal_title) {
        this.journal_title = journal_title;
    }

    public String getQna_title() {
        return qna_title;
    }

    public void setQna_title(String qna_title) {
        this.qna_title = qna_title;
    }

    public String getSchedule_title() {
        return schedule_title;
    }

    public void setSchedule_title(String schedule_title) {
        this.schedule_title = schedule_title;
    }

    public String getAlarm_title() {
        return alarm_title;
    }

    public void setAlarm_title(String alarm_title) {
        this.alarm_title = alarm_title;
    }
}
