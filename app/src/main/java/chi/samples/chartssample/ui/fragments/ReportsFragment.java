package chi.samples.chartssample.ui.fragments;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

import chi.samples.chartssample.R;
import chi.samples.chartssample.database.models.GraphItem;
import chi.samples.chartssample.utils.DataHelper;

/**
 * Created by Nilita on 12.06.2015.
 */
public class ReportsFragment extends Fragment {
    private final String TAG = getClass().getSimpleName();

    private BarChart bcJobsAWeek;
    private PieChart pcPickups, pcDeliveries;
    private HorizontalBarChart hbcAvgStopTime;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_reports, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bcJobsAWeek = (BarChart) view.findViewById(R.id.bcJobAWeek);
        pcPickups = (PieChart) view.findViewById(R.id.pcPickups);
        pcDeliveries = (PieChart) view.findViewById(R.id.pcDeliveries);
        hbcAvgStopTime = (HorizontalBarChart) view.findViewById(R.id.hbcAvgStopTime);

    }

    private void initGraphs() {
        initJobsAWeekGraph();
    }

    private void initJobsAWeekGraph() {
        YAxis rightAxis = bcJobsAWeek.getAxisRight();
        rightAxis.setEnabled(false);

        YAxis leftAxis = bcJobsAWeek.getAxisLeft();
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setAxisMaxValue(25);

        XAxis xAxis = bcJobsAWeek.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);

        bcJobsAWeek.getLegend().setEnabled(false);
        bcJobsAWeek.setBackgroundColor(Color.WHITE);
        bcJobsAWeek.setDrawGridBackground(false);
        bcJobsAWeek.setDescription("");
        bcJobsAWeek.setData(getJobsGraphData(DataHelper.getJobsPerWeekData()));
    }

    private BarData getJobsGraphData(ArrayList<GraphItem> items) {

        ArrayList<String> xVals = new ArrayList<String>();
        for (int i = 0; i < items.size(); i++) {
            xVals.add(items.get(i).description);
        }

        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();

        for (int i = 0; i < items.size(); i++) {
            yVals1.add(new BarEntry(items.get(i).value, i));
        }

        BarDataSet set1 = new BarDataSet(yVals1, getString(R.string.job_title));
        set1.setBarSpacePercent(35f);
        set1.setColor(getResources().getColor(R.color.blue));

        ArrayList<BarDataSet> dataSets = new ArrayList<BarDataSet>();
        dataSets.add(set1);

        BarData data = new BarData(xVals, dataSets);
        data.setValueTextSize(10f);

        return data;
    }
}
