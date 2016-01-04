package chi.samples.chartssample.utils;

import java.util.ArrayList;

import chi.samples.chartssample.database.models.GraphItem;

public class DataHelper {

    public static ArrayList<GraphItem> getJobsPerWeekData() {
        ArrayList<GraphItem> jobsPerWeek = new ArrayList<>();
        jobsPerWeek.add(new GraphItem("Dec 1", 18));
        jobsPerWeek.add(new GraphItem("Dec 8", 4));
        jobsPerWeek.add(new GraphItem("Dec 15", 7));
        jobsPerWeek.add(new GraphItem("Dec 22", 11));
        return jobsPerWeek;
    }

    public static ArrayList<GraphItem> getOnTimePerWeekData() {
        ArrayList<GraphItem> jobsPerWeek = new ArrayList<>();
        jobsPerWeek.add(new GraphItem("Dec 1", 72));
        jobsPerWeek.add(new GraphItem("Dec 8", 49));
        jobsPerWeek.add(new GraphItem("Dec 15", 63));
        jobsPerWeek.add(new GraphItem("Dec 22", 87));
        return jobsPerWeek;
    }

    public static ArrayList<GraphItem> getAvgStopData() {
        ArrayList<GraphItem> avgStop = new ArrayList<>();
        avgStop.add(new GraphItem("Delivery", 107));
        avgStop.add(new GraphItem("Pickup", 86));
        return avgStop;
    }

    public static ArrayList<GraphItem> getOnTimeByLocationData() {
        ArrayList<GraphItem> onTimeByLocation = new ArrayList<>();
        onTimeByLocation.add(new GraphItem("GE Transportation - Minneapolis, MN", 64));
        onTimeByLocation.add(new GraphItem("National Trackload - Dallas, TX", 97));
        onTimeByLocation.add(new GraphItem("GE Transportation - Minneapolis, MN", 72));
        onTimeByLocation.add(new GraphItem("National Trackload - Dallas, TX", 31));
        onTimeByLocation.add(new GraphItem("GE Transportation - Minneapolis, MN", 36));
        return onTimeByLocation;
    }

    public static ArrayList<GraphItem> getGpsUtilizationData() {
        ArrayList<GraphItem> gpsUtilization = new ArrayList<>();
        gpsUtilization.add(new GraphItem("Dec 1", 80));
        gpsUtilization.add(new GraphItem("Dec 8", 60));
        gpsUtilization.add(new GraphItem("Dec 15", 100));
        gpsUtilization.add(new GraphItem("Dec 22", 80));
        return gpsUtilization;
    }


}
