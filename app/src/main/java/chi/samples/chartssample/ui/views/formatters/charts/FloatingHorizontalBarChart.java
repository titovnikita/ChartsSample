package chi.samples.chartssample.ui.views.formatters.charts;

import android.content.Context;
import android.util.AttributeSet;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.highlight.HorizontalBarHighlighter;
import com.github.mikephil.charting.renderer.HorizontalBarChartRenderer;
import com.github.mikephil.charting.renderer.XAxisRendererHorizontalBarChart;
import com.github.mikephil.charting.renderer.YAxisRendererHorizontalBarChart;
import com.github.mikephil.charting.utils.TransformerHorizontalBarChart;

public class FloatingHorizontalBarChart extends HorizontalBarChart {
    public FloatingHorizontalBarChart(Context context) {
        super(context);
    }

    public FloatingHorizontalBarChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FloatingHorizontalBarChart(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void init() {
        super.init();

        mLeftAxisTransformer = new TransformerHorizontalBarChart(mViewPortHandler);
        mRightAxisTransformer = new TransformerHorizontalBarChart(mViewPortHandler);

        mRenderer = new HorizontalBarChartRenderer(this, mAnimator, mViewPortHandler);
        mHighlighter = new HorizontalBarHighlighter(this);

        mAxisRendererLeft = new YAxisRendererHorizontalBarChart(mViewPortHandler, mAxisLeft, mLeftAxisTransformer);
        mAxisRendererRight = new YAxisRendererHorizontalBarChart(mViewPortHandler, mAxisRight, mRightAxisTransformer);
        mXAxisRenderer = new FloatingXAxisHorizontalBarChartRenderer(mViewPortHandler, mXAxis, mLeftAxisTransformer, this);
    }
}
