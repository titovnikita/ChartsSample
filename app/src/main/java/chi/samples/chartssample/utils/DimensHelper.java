package chi.samples.chartssample.utils;

import android.content.Context;

public class DimensHelper {
    public static int dpToPx(Context context, int dps) {
        return Math.round(context.getResources().getDisplayMetrics().density * dps);
    }
}
