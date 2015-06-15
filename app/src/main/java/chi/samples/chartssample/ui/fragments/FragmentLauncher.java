package chi.samples.chartssample.ui.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import chi.samples.chartssample.R;

/**
 * Created by Nilita on 12.06.2015.
 */
public final class FragmentLauncher {
    private static final String CHART_CHOOSER_FRAGMENT_TAG = "chartChooserTag";
    private static final String LINE_CHART_FRAGMENT_TAG = "lineChartTag";
    private static final String BAR_CHART_FRAGMENT_TAG = "barChartTag";

    private final FragmentManager fragmentManager;

    public FragmentLauncher(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    private void launchFragment(Fragment fragment, String tag, boolean addToBackStack) {
        final FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.fragmentContainer, fragment, tag);
        if(addToBackStack) {
            transaction.addToBackStack(tag);
        }
        transaction.commit();
    }

    public void launchChartChooserFragment(final Fragment fragment, final boolean addToBackStack){
        launchFragment(fragment, CHART_CHOOSER_FRAGMENT_TAG, addToBackStack);
    }

    public void launchLineChartFragment(final Fragment fragment, final boolean addToBackStack){
        launchFragment(fragment, LINE_CHART_FRAGMENT_TAG, addToBackStack);
    }

    public void launchBarChartFragment(final Fragment fragment, final boolean addToBackStack){
        launchFragment(fragment, BAR_CHART_FRAGMENT_TAG, addToBackStack);
    }
}
