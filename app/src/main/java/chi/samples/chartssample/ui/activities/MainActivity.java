package chi.samples.chartssample.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import chi.samples.chartssample.R;
import chi.samples.chartssample.core.ActivityBridge;
import chi.samples.chartssample.ui.fragments.MenuFragment;
import chi.samples.chartssample.ui.fragments.FragmentLauncher;


public class MainActivity extends AppCompatActivity implements ActivityBridge {

    private FragmentLauncher fragmentLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentLauncher = new FragmentLauncher(getSupportFragmentManager());

        fragmentLauncher.launchChartChooserFragment(new MenuFragment(), false);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public FragmentLauncher getFragmentLauncher() {
        return fragmentLauncher;
    }
}
