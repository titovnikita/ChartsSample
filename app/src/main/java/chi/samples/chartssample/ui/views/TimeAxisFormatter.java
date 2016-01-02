package chi.samples.chartssample.ui.views;

import android.text.format.DateUtils;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.formatter.YAxisValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class TimeAxisFormatter implements YAxisValueFormatter {

    @Override
    public String getFormattedValue(float value, YAxis yAxis) {
        return DateUtils.formatElapsedTime(new Float(value).longValue());
    }
}
