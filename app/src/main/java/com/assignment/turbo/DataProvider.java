package com.assignment.turbo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataProvider {

    private static DataProvider instance = null;
    public static List<RealtimeInfoModel> realTimeInfoDataModelList = new ArrayList<>();
    public static List<HealthModel> healthDataModelList = new ArrayList<>();
    public static String issueString = "";
    public static String fixString = "";
    public static String maintenanceLevelString = "";
    public static String daysString = "";
    public static String maintenanceTitleString = "";


    public static DataProvider getInstance() {
        if (instance == null) {
            instance = new DataProvider();
        }
        return instance;
    }

    private DataProvider() {

        getRealTimeInfoDataModelList();
        getHealthDataModelList();
        getIssueAndFix();
        getMaintenance();


    }

    private void getMaintenance() {
        int min = 50;
        int max = 300;

        int random = (new Random()).nextInt((max - min) + 1) + min;


        StringBuilder s = new StringBuilder(100);
        s.append("Next estimated maintenance at ");
        s.append(random);
        s.append(" miles");

        maintenanceTitleString = s.toString();

        String[] myArrayOfStrings = {"Minor", "Major"};
        Random rand = new Random();
        maintenanceLevelString = myArrayOfStrings[rand.nextInt(myArrayOfStrings.length)];

        min = 1;
        max = 50;
        random = (new Random()).nextInt((max - min) + 1) + min;
        StringBuilder s2 = new StringBuilder(100);
        s2.append(random);
        daysString = s2.toString();

    }

    private void getIssueAndFix() {
        String[] issues = {"Bad O2", "Old cabin Filter", "Dirty Engine Filter"};
        String[] fix = {"Replace Exhaust", "Replace cabin Filter", "Replace Engine Filter"};
        Random r = new Random();
        int index = r.nextInt(issues.length);
        issueString = issues[index];
        fixString = fix[index];
    }

    private void getHealthDataModelList() {
        healthDataModelList.add(new HealthModel("Oil Life", returnStringBuilder()));
        healthDataModelList.add(new HealthModel("Tire", returnStringBuilder()));
        healthDataModelList.add(new HealthModel("Air Filter Quality", returnStringBuilder()));
        healthDataModelList.add(new HealthModel("Oil Pressure", returnStringBuilder()));
        healthDataModelList.add(new HealthModel("Oil Life", returnStringBuilder()));
        healthDataModelList.add(new HealthModel("Tire", "80%"));
        healthDataModelList.add(new HealthModel("Overall Health", returnStringBuilder()));
        healthDataModelList.add(new HealthModel("Estimated mileage", returnStringBuilder4Miles()));

    }

    private void getRealTimeInfoDataModelList() {
        realTimeInfoDataModelList.add(new RealtimeInfoModel(R.drawable.temperature, "Oil Temperature", "190.4"));
        realTimeInfoDataModelList.add(new RealtimeInfoModel(R.drawable.coolant_tempearature1, "Coolant Temperature", "73.0 F"));
        realTimeInfoDataModelList.add(new RealtimeInfoModel(R.drawable.boost, "Boost", "19.7 psi"));
        realTimeInfoDataModelList.add(new RealtimeInfoModel(R.drawable.oil_pressure, "Oil Pressure", "150 psi"));
    }

    private String returnStringBuilder4Miles() {
        int min = 10000;
        int max = 95000;
        int random = (new Random()).nextInt((max - min) + 1) + min;

        StringBuilder s = new StringBuilder(100);
        s.append(random);
        s.append(" miles");

        return  s.toString();
    }

    private String returnStringBuilder() {
        int min = 0;
        int max = 100;

        int random = (new Random()).nextInt((max - min) + 1) + min;
        StringBuilder s = new StringBuilder(100);
        s.append(random);
        s.append("%");

        return s.toString();
    }

}