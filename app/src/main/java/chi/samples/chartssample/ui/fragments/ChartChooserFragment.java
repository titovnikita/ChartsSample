package chi.samples.chartssample.ui.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import chi.samples.chartssample.R;
import chi.samples.chartssample.core.ActivityBridge;

/**
 * Created by Nilita on 12.06.2015.
 */
public class ChartChooserFragment extends Fragment {
    private ActivityBridge bridge;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        bridge = (ActivityBridge) activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.chart_chooser_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.btnLineChart).setOnClickListener(new Clicker());
        view.findViewById(R.id.btnBarChart).setOnClickListener(new Clicker());
    }

    private class Clicker implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btnLineChart:
                    bridge.getFragmentLauncher().launchLineChartFragment(new LineChartFragment(), true);
                    break;
                case R.id.btnBarChart:
                    bridge.getFragmentLauncher().launchBarChartFragment(new BarChartFragment(), true);
                    break;
            }
        }
    }
}
