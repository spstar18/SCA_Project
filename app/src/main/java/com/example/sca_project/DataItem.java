package com.example.sca_project;

import android.graphics.drawable.Drawable;

public class DataItem {
    private Drawable user_img;
    private String name, viewnum, main;
    private String user_nickname, user_email;
    private String alarm_cycle, alarm_time, alarm_ampm;
    private String journal_day;

    public Drawable getUser_img() {
        return user_img;
    }

    public void setUser_img(Drawable user_img) {
        this.user_img = user_img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getUser_nickname() {
        return user_nickname;
    }

    public void setUser_nickname(String user_nickname) {
        this.user_nickname = user_nickname;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
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
}
