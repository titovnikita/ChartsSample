package chi.samples.chartssample.ui.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

import chi.samples.chartssample.R;

/**
 * Created by Nilita on 12.06.2015.
 */
public class ReportsFragment extends Fragment {
    private final String TAG = getClass().getSimpleName();
    private final String[] months = {"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"};

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


}
