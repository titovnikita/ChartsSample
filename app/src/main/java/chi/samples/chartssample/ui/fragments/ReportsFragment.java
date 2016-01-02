package chi.samples.chartssample.ui.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;

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

        initGraphs();
    }

    private void initGraphs() {
        initJobsAWeekGraph();
        initPieChart(pcPickups);
        initPieChart(pcDeliveries);

        initPickupsChart();
        initDeliveriesChart();
    }

    private void initDeliveriesChart() {
        pcDeliveries.setCenterText("73%");
        pcDeliveries.setCenterTextColor(getResources().getColor(R.color.pink));
        pcDeliveries.setCenterTextSize(25);
        pcDeliveries.getLegend().setEnabled(false);
        pcDeliveries.setRotationEnabled(false);
        pcDeliveries.setRotationAngle(-90);

        pcDeliveries.setData(getPieData(73, R.color.pink));
    }

    private void initPickupsChart() {
        pcPickups.setCenterText("68%");
        pcPickups.setCenterTextColor(getResources().getColor(R.color.dark_blue));
        pcPickups.setCenterTextSize(25);
        pcPickups.getLegend().setEnabled(false);
        pcPickups.setRotationEnabled(false);
        pcPickups.setRotationAngle(-90);

        pcPickups.setData(getPieData(68, R.color.dark_blue));
    }

    private void initPieChart(PieChart chart) {
        chart.setUsePercentValues(true);
        chart.setDescription("");
        chart.setExtraOffsets(5, 10, 5, 5);

        chart.setDragDecelerationFrictionCoef(0.95f);

        chart.setDrawHoleEnabled(true);
        chart.setHoleColorTransparent(true);

        chart.setTransparentCircleColor(Color.WHITE);
        chart.setTransparentCircleAlpha(110);

        chart.setHoleRadius(58f);
        chart.setTransparentCircleRadius(61f);

        chart.setDrawCenterText(true);

        chart.setRotationAngle(0);

        chart.setRotationEnabled(true);
        chart.setHighlightPerTapEnabled(true);

        chart.animateY(1400, Easing.EasingOption.EaseInOutQuad);
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
        bcJobsAWeek.animateY(1400, Easing.EasingOption.EaseInBounce);
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

    public PieData getPieData(int value, int accentColorResId) {
        ArrayList<Entry> yVals1 = new ArrayList<Entry>();

        yVals1.add(new Entry(value, 0));
        yVals1.add(new Entry(100 - value, 1));

        ArrayList<String> xVals = new ArrayList<String>();
        xVals.add("");
        xVals.add("");

        PieDataSet dataSet = new PieDataSet(yVals1, "On-time");
        dataSet.setSliceSpace(2f);
        dataSet.setDrawValues(false);

        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(getResources().getColor(accentColorResId));
        colors.add(getResources().getColor(R.color.grey_light));

        dataSet.setColors(colors);

        return new PieData(xVals, dataSet);
    }
}
