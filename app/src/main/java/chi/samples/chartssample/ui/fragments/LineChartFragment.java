package chi.samples.chartssample.ui.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import chi.samples.chartssample.R;

/**
 * Created by Nilita on 12.06.2015.
 */
public class LineChartFragment extends Fragment {
    private final String TAG = getClass().getSimpleName();
    private Context context;
    private LineChart lineChart;
    private TextView value;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.context = activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.line_chart_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lineChart = (LineChart) view.findViewById(R.id.lineChart);
        value = (TextView) view.findViewById(R.id.tvValue);

        lineChart.setHighlightEnabled(true);
        lineChart.setBackgroundColor(context.getResources().getColor(R.color.white));
        lineChart.setDrawGridBackground(false);

        lineChart.getAxisLeft().setEnabled(false);
        lineChart.getAxisRight().setEnabled(false);
        lineChart.getXAxis().setEnabled(false);
        lineChart.setDescription("Realtime line chart without grid");
        lineChart.setData(new LineData());
    }

    @Override
    public void onResume() {
        super.onResume();

        startFakeRealtime();
    }

    private void startFakeRealtime(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                addEntry();
                startFakeRealtime();
            }
        }, 2000);
    }

    private void addEntry() {
        LineData lineData = lineChart.getData();

        if (lineData != null) {
            LineDataSet dataSet = lineData.getDataSetByIndex(0);

            if (dataSet == null) {
                dataSet = createSet("real time graph");
                lineData.addDataSet(dataSet);
            }

            lineData.addXValue("");
            float newValue = (float) (Math.random() * 75) + 60f;
            lineData.addEntry(new Entry(newValue, dataSet.getEntryCount()), 0);

            lineChart.notifyDataSetChanged();
            lineChart.setVisibleXRange(6);
            lineChart.moveViewToX(lineData.getXValCount() - 7);

            lineChart.invalidate();
            value.setText(String.valueOf((int) newValue));
        }
    }

    private LineDataSet createSet(String label){
        LineDataSet dataSet = new LineDataSet(null, label);
        dataSet.setColor(context.getResources().getColor(R.color.neon_blue));
        dataSet.setDrawCubic(true);
        return dataSet;
    }
}
