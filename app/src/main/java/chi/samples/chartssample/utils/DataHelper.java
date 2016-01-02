package chi.samples.chartssample.utils;

import java.util.ArrayList;

import chi.samples.chartssample.database.models.GraphItem;

public class DataHelper {

    public static ArrayList<GraphItem> getJobsPerWeekData() {
        ArrayList<GraphItem> jobsPerWeek = new ArrayList<>();
        jobsPerWeek.add(new GraphItem("Dec 1 - 7", 18));
        jobsPerWeek.add(new GraphItem("Dec 8 - 14", 4));
        jobsPerWeek.add(new GraphItem("Dec 15 - 21", 7));
        jobsPerWeek.add(new GraphItem("Dec 22 - 28", 11));
        return jobsPerWeek;
    }

    public static ArrayList<GraphItem> getAvgStopData() {
        ArrayList<GraphItem> avgStop = new ArrayList<>();
        avgStop.add(new GraphItem("Delivery", 107));
        avgStop.add(new GraphItem("Pickup", 86));
        return avgStop;
    }
}
