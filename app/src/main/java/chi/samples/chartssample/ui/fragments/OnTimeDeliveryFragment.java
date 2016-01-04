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
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

import chi.samples.chartssample.R;
import chi.samples.chartssample.database.models.GraphItem;
import chi.samples.chartssample.ui.views.formatters.PercentIntegerValueFormatter;
import chi.samples.chartssample.ui.views.formatters.charts.FloatingHorizontalBarChart;
import chi.samples.chartssample.utils.DataHelper;

/**
 * Created by Nilita on 12.06.2015.
 */
public class OnTimeDeliveryFragment extends Fragment {
    private final String TAG = getClass().getSimpleName();
    private final int ANIMATION_DURATION = 1400;
    private final float BAR_SPACE = 60f;
    private final float BAR_SPACE_PERCENT = 35f;
    private final float DEFAULT_TEXT_SIZE = 10f;

    private BarChart bcOnTimePerWeek;
    private FloatingHorizontalBarChart hbcOnTimePerLocation;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_on_time_delivery, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bcOnTimePerWeek = (BarChart) view.findViewById(R.id.bcOnTimePerWeek);
        hbcOnTimePerLocation = (FloatingHorizontalBarChart) view.findViewById(R.id.hbcOnTimePerLocation);

        initGraphs();
    }

    private void initGraphs() {
        initOnTimePerWeekChart();

        initOnTimePerLocationChart();
    }

    private void initOnTimePerWeekChart() {
        YAxis rightAxis = bcOnTimePerWeek.getAxisRight();
        rightAxis.setEnabled(false);

        YAxis leftAxis = bcOnTimePerWeek.getAxisLeft();
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setAxisMaxValue(100);

        XAxis xAxis = bcOnTimePerWeek.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);

        bcOnTimePerWeek.getLegend().setEnabled(false);
        bcOnTimePerWeek.setPinchZoom(false);
        bcOnTimePerWeek.setDoubleTapToZoomEnabled(false);
        bcOnTimePerWeek.setHighlightPerTapEnabled(false);
        bcOnTimePerWeek.setHighlightPerDragEnabled(false);
        bcOnTimePerWeek.setScaleEnabled(false);

        bcOnTimePerWeek.setBackgroundColor(Color.TRANSPARENT);
        bcOnTimePerWeek.setDrawGridBackground(false);
        bcOnTimePerWeek.setDescription("");
        bcOnTimePerWeek.animateY(ANIMATION_DURATION, Easing.EasingOption.EaseInCirc);
        bcOnTimePerWeek.setData(getOnTimePerWeekData(DataHelper.getOnTimePerWeekData()));
    }


    private void initOnTimePerLocationChart() {
        YAxis rightAxis = hbcOnTimePerLocation.getAxisRight();
        rightAxis.setAxisMaxValue(100);
        rightAxis.setEnabled(true);

        YAxis leftAxis = hbcOnTimePerLocation.getAxisLeft();
        leftAxis.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART);
        leftAxis.setDrawGridLines(true);
        leftAxis.setAxisMaxValue(100);

        XAxis xAxis = hbcOnTimePerLocation.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM_INSIDE);
        xAxis.setTextSize(13);
        xAxis.setDrawGridLines(false);

        hbcOnTimePerLocation.setDrawBarShadow(false);
        hbcOnTimePerLocation.setPinchZoom(false);
        hbcOnTimePerLocation.setDoubleTapToZoomEnabled(false);
        hbcOnTimePerLocation.setHighlightPerDragEnabled(false);
        hbcOnTimePerLocation.setScaleEnabled(false);

        hbcOnTimePerLocation.setDrawValueAboveBar(false);

        hbcOnTimePerLocation.setDescription("");
        hbcOnTimePerLocation.getLegend().setEnabled(false);

        hbcOnTimePerLocation.setBackgroundColor(Color.TRANSPARENT);
        hbcOnTimePerLocation.setDrawGridBackground(false);
        hbcOnTimePerLocation.setHighlightPerTapEnabled(false);
        hbcOnTimePerLocation.animateY(ANIMATION_DURATION, Easing.EasingOption.EaseInExpo);

        hbcOnTimePerLocation.setData(getOnTimePerLocationData(DataHelper.getOnTimeByLocationData()));
    }

    private BarData getOnTimePerWeekData(ArrayList<GraphItem> items) {

        ArrayList<String> xVals = new ArrayList<String>();
        for (int i = 0; i < items.size(); i++) {
            xVals.add(items.get(i).description);
        }

        ArrayList<BarEntry> yVals = new ArrayList<BarEntry>();

        for (int i = 0; i < items.size(); i++) {
            yVals.add(new BarEntry(items.get(i).value, i));
        }

        BarDataSet set = new BarDataSet(yVals, getString(R.string.job_title));
        set.setBarSpacePercent(BAR_SPACE_PERCENT);
        set.setColor(getResources().getColor(R.color.pink));

        ArrayList<BarDataSet> dataSets = new ArrayList<BarDataSet>();
        dataSets.add(set);

        BarData data = new BarData(xVals, dataSets);
        data.setValueTextSize(DEFAULT_TEXT_SIZE);
        data.setValueFormatter(new PercentIntegerValueFormatter());

        return data;
    }

    public BarData getOnTimePerLocationData(ArrayList<GraphItem> items) {
        ArrayList<String> xVals = new ArrayList<String>();
        ArrayList<BarEntry> yVals = new ArrayList<BarEntry>();

        for (int i = 0; i < items.size(); i++) {
            xVals.add(items.get(i).description);
            yVals.add(new BarEntry(items.get(i).value, i));
        }

        BarDataSet set = new BarDataSet(yVals, "Average stop time");
        set.setBarSpacePercent(BAR_SPACE);
        set.setAxisDependency(YAxis.AxisDependency.RIGHT);
        set.setColor(getResources().getColor(R.color.pink));
        ArrayList<BarDataSet> dataSets = new ArrayList<BarDataSet>();
        dataSets.add(set);

        BarData data = new BarData(xVals, dataSets);
        data.setValueTextSize(12);
        data.setValueTextColor(Color.WHITE);
        data.setValueFormatter(new PercentIntegerValueFormatter());
        return data;
    }
}
