package com.newhorizon.gymistic.view.home;

public class TrainerModel {

    //region Properties
    private String name;
    private String type;
    private boolean gender;
    private String startDate;
    private String endDate;
    private boolean isMonthly;
    private int countCourse;
    //endregion

    //region Constructor

    public TrainerModel(String name, String type, boolean gender, String startDate, String endDate, boolean isMonthly, int countCourse) {
        this.name = name;
        this.type = type;
        this.gender = gender;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isMonthly = isMonthly;
        this.countCourse = countCourse;
    }

    public TrainerModel() {
    }


    //endregion

    //region Getters & Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public boolean isMonthly() {
        return isMonthly;
    }

    public void setMonthly(boolean monthly) {
        isMonthly = monthly;
    }

    public int getCountCourse() {
        return countCourse;
    }

    public void setCountCourse(int countCourse) {
        this.countCourse = countCourse;
    }

    //endregion
}
