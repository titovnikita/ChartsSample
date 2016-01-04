package chi.samples.chartssample.ui.views.formatters.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.renderer.XAxisRendererHorizontalBarChart;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

import chi.samples.chartssample.utils.DimensHelper;

public class FloatingXAxisHorizontalBarChartRenderer extends XAxisRendererHorizontalBarChart {
    public FloatingXAxisHorizontalBarChartRenderer(ViewPortHandler viewPortHandler, XAxis xAxis, Transformer trans, BarChart chart) {
        super(viewPortHandler, xAxis, trans, chart);
    }

    @Override
    protected void drawLabels(Canvas c, float pos, PointF anchor) {

        final float labelRotationAngleDegrees = mXAxis.getLabelRotationAngle();

        // pre allocate to save performance (dont allocate in loop)
        float[] position = new float[]{
                0f, 0f
        };

        BarData bd = mChart.getData();
        int step = bd.getDataSetCount();

        for (int i = mMinX; i <= mMaxX; i += mXAxis.mAxisLabelModulus) {

            position[1] = i * step + i * bd.getGroupSpace()
                    + bd.getGroupSpace() / 2f;

            if (step > 1) {
                position[1] += ((float) step - 1f) / 2f;
            }

            mTrans.pointValuesToPixel(position);

            if (mViewPortHandler.isInBoundsY(position[1])) {

                String label = mXAxis.getValues().get(i);
                int spacePx = (int) (mChart.getBarData().getDataSetByIndex(0).getBarSpace() * 100 / 3) + 3;
                drawLabel(c, label, i, pos, position[1] + DimensHelper.dpToPx(mChart.getContext(), -spacePx), anchor, labelRotationAngleDegrees);
            }
        }
    }


}
