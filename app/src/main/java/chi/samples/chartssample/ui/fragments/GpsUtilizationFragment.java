package chi.samples.chartssample.ui.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

import chi.samples.chartssample.R;
import chi.samples.chartssample.database.models.GraphItem;
import chi.samples.chartssample.ui.views.formatters.PercentIntegerValueFormatter;
import chi.samples.chartssample.utils.DataHelper;

/**
 * Created by Nilita on 12.06.2015.
 */
public class GpsUtilizationFragment extends Fragment {
    private final String TAG = getClass().getSimpleName();
    private final int ANIMATION_DURATION = 1400;


    private LineChart lcGpsUtilizationRate;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gps_utilization, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lcGpsUtilizationRate = (LineChart) view.findViewById(R.id.lcGpsUtilizationRate);

        initGraphs();
    }

    private void initGraphs() {
        initGpsUtilizationRateChart();
    }

    private void initGpsUtilizationRateChart() {
        YAxis rightAxis = lcGpsUtilizationRate.getAxisRight();
        rightAxis.setEnabled(false);

        YAxis leftAxis = lcGpsUtilizationRate.getAxisLeft();
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setAxisMaxValue(100);

        XAxis xAxis = lcGpsUtilizationRate.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        lcGpsUtilizationRate.getLegend().setEnabled(false);
        lcGpsUtilizationRate.setPinchZoom(false);
        lcGpsUtilizationRate.setDoubleTapToZoomEnabled(false);
        lcGpsUtilizationRate.setHighlightPerTapEnabled(false);
        lcGpsUtilizationRate.setHighlightPerDragEnabled(false);
        lcGpsUtilizationRate.setScaleEnabled(false);

        lcGpsUtilizationRate.setBackgroundColor(Color.TRANSPARENT);
        lcGpsUtilizationRate.setDrawGridBackground(false);
        lcGpsUtilizationRate.setDescription("");
        lcGpsUtilizationRate.animateY(ANIMATION_DURATION, Easing.EasingOption.EaseOutQuad);
        lcGpsUtilizationRate.setData(getGpsUtilizationData(DataHelper.getGpsUtilizationData()));
    }

    private LineData getGpsUtilizationData(ArrayList<GraphItem> items) {
        ArrayList<String> xVals = new ArrayList<String>();
        for (int i = 0; i < items.size(); i++) {
            xVals.add(items.get(i).description);
        }

        ArrayList<Entry> yVals = new ArrayList<Entry>();
        for (int i = 0; i < items.size(); i++) {
            yVals.add(new Entry(items.get(i).value, i));
        }

        LineDataSet set = new LineDataSet(yVals, getString(R.string.gps_utilization));

        set.setColor(getResources().getColor(R.color.blue));
        set.setCircleColor(getResources().getColor(R.color.blue));
        set.setLineWidth(3f);
        set.setCircleSize(6f);
        set.setDrawCircleHole(false);
        set.setDrawValues(false);
        set.setFillAlpha(65);
        set.setFillColor(getResources().getColor(R.color.blue));

        ArrayList<LineDataSet> dataSets = new ArrayList<LineDataSet>();
        dataSets.add(set);

        return new LineData(xVals, dataSets);
    }
}
