package chi.samples.chartssample.ui.views.formatters;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class PercentIntegerValueFormatter implements ValueFormatter {
    @Override
    public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
        return String.valueOf(((int) value)) + "%";
    }
}
