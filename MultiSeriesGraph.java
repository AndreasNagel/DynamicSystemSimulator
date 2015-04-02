import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.xy.*;
import org.jfree.data.xy.*;

class MultiSeriesGraph {
    /*@ specification MultiSeriesGraph {

        double x;
        alias (double) ys;
        void init_ready, drawing_ready, paintAll, done, updated;
        boolean repaintImmediately, axisAlwaysIncludeZero, showSeparateAxis;
        boolean autoSort, allowDuplicates;
        float lineThickness;
        //NB! seriesNames if defined must match ys
        String[] seriesNames;
        String domainName;

        //----default settings
        repaintImmediately = true;
        axisAlwaysIncludeZero = true;
        showSeparateAxis = false;
        lineThickness = 1;   
        autoSort = false; 
        allowDuplicates = true;
        domainName = "";

        //change settings
        ys.length, lineThickness, axisAlwaysIncludeZero, 
        	showSeparateAxis, autoSort, allowDuplicates -> init_ready {init};
        //setup axis lables
        init_ready, domainName, seriesNames, showSeparateAxis -> updated {setSeriesName};
        //add coordinates
        init_ready, x, ys, repaintImmediately -> drawing_ready, (Exception) {draw};
        //paint all at once
        paintAll, repaintImmediately -> done {drawAll};
    }@*/

    double prevx = 0, firstround = -1;
    private JFreeChart chart;
    private ChartFrame frame;
    private XYPlot plot;
    private List<XYSeries> series = new ArrayList<XYSeries>();
    boolean firstDraw = true;
    private void initChart() {
        chart = ChartFactory.createXYLineChart( null, null, null,
                null, PlotOrientation.VERTICAL, 
                true, //legend
                true, //tooltip
                false );//url

        plot = chart.getXYPlot();

        frame = new ChartFrame( "Graph", chart );
        frame.addWindowListener( new WindowAdapter() {

            @Override
            public void windowClosing( WindowEvent e ) {
                System.out.println( "Chart frame closed - terminating program" );
                frame.dispose();
                ee.ioc.cs.vsle.api.ProgramContext.terminate();
            }
        } );
    }
    
    public void init( int length, float lineThickness,
            boolean axisAlwaysIncludeZero, boolean showSeparateAxis, 
            boolean autoSort, boolean allowDuplicates ) {
        
        initChart();
        
        if (showSeparateAxis) {
            for (int i = 0; i < length; i++) {
                XYSeriesCollection dataset = new XYSeriesCollection();
                XYSeries ser = new XYSeries("" + i, autoSort, allowDuplicates);
                dataset.addSeries(ser);
                series.add( ser );
                plot.setDataset(i, dataset);
            }
        } else {
            XYSeriesCollection dataset = new XYSeriesCollection();
            for (int i = 0; i < length; i++) {
                XYSeries ser = new XYSeries("" + i, autoSort, allowDuplicates);
                dataset.addSeries(ser);
                series.add( ser );
            }
            plot.setDataset(0, dataset);
        }

        Stroke stroke = new BasicStroke( lineThickness );
        NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
        domainAxis.setAutoRangeIncludesZero( axisAlwaysIncludeZero );
        
        if ( showSeparateAxis && length > 1 ) {
            chart.removeLegend();
            for ( int i = 0, len = series.size(); i < len; i++ ) {
                XYSeries ser  = series.get( i );
                Paint color = plot.getDrawingSupplier().getNextPaint();
                NumberAxis axis = new NumberAxis( ser.getKey().toString() );
                axis.setAutoRangeIncludesZero( axisAlwaysIncludeZero );
                axis.setLabelPaint( color );
                axis.setTickLabelPaint( color );
                if (i < len / 2) {
                    plot.setRangeAxisLocation(i, AxisLocation.BOTTOM_OR_LEFT);
                }
                plot.setRangeAxis( i, axis );
                plot.mapDatasetToRangeAxis( i, i);
                XYLineAndShapeRenderer rend = new XYLineAndShapeRenderer(true, false);
                rend.setSeriesStroke( 0, stroke );
                rend.setSeriesPaint( 0, color );
                plot.setRenderer( i, rend );
            }
        } else {
            NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
            rangeAxis.setAutoRangeIncludesZero( axisAlwaysIncludeZero );
            plot.getRenderer().setStroke( stroke );
        }
        
        frame.pack();
        frame.setVisible( true );
    }

    public void draw( final double x, final double[] ys,
            final boolean repaintImmediately ) throws Exception {

        for ( int i = 0; i < ys.length; i++ ) {
                    series.get( i ).add(x, ys[i], repaintImmediately );
                    //System.out.println("Joonistan asju " + prevx);

        }
        //prevx = x;
    }

    public void setSeriesName( String domain, String[] names, boolean showSeparateAxis ) {

        if(domain != null && domain.length() > 0) {
            NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
            domainAxis.setLabel( domain );
        }
        for (int i = 0; i < names.length; i++) {
            if(showSeparateAxis) {
                plot.getRangeAxis(i).setLabel(names[i]); 
            }
            series.get( i ).setKey(names[i]);   
        }
    }

    public void drawAll( boolean repaintImmediately ) {
        if ( !repaintImmediately ) {
            for( XYSeries ser : series ){
                ser.fireSeriesChanged();
            }
        }
    }

    /**
     * @param args
     * @throws Exception
     */
    public static void main( String[] args ) throws Exception {
        MultiSeriesGraph g = new MultiSeriesGraph();
        String[] range = new String[] { "one", "two", "333" };
        boolean showSeparateAxis = false;
        g.init( range.length, 4f, false, showSeparateAxis, false, true );
        g.setSeriesName( "domain", range, showSeparateAxis );
        g.draw( 1, new double[] { 0.2, 6, 60 }, true );
        g.draw( 2, new double[] { 0.3, 8, 40 }, true );
        g.draw( 3, new double[] { 0.6, 7, 12 }, true );
    }
}
