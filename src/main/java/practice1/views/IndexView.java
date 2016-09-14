package practice1.views;

import org.primefaces.model.chart.*;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.sound.sampled.Line;

/**
 * Created by yurina on 2015/12/10.
 */
@Named
@RequestScoped
public class IndexView{

    private PieChartModel pieModel;
    private BarChartModel barModel;
    private LineChartModel lineModel;

    @PostConstruct
    public void init() { createCharts();}

    private void createCharts(){
        createPieModels();
        createBarModels();
        createLineModels();
    }

    public PieChartModel getPieModel() {
        return pieModel;
    }

    public BarChartModel getBarModel() {
        return barModel;
    }

    public LineChartModel getLineModel() { return lineModel; }

    private void createPieModels(){
        pieModel = new PieChartModel();

        pieModel.set("team1", 60);
        pieModel.set("team2", 20);
        pieModel.set("team3", 15);
        pieModel.set("team4", 5);

        pieModel.setTitle("Team Chart");
        pieModel.setLegendPosition("w");
    }

    private BarChartModel createBarModels(){
        barModel = new BarChartModel();

        ChartSeries team1 = new ChartSeries();
        team1.setLabel("team1");
        team1.set("team1", 30);
        team1.set("team2", 45);
        team1.set("team3", 15);

        barModel.addSeries(team1);

        barModel.setTitle("Problem1");

        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Team");

        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Time");
        yAxis.setMin(0);
        yAxis.setMax(120);

        return barModel;
    }

    private LineChartModel createLineModels(){
        lineModel = new LineChartModel();

        ChartSeries team1 = new ChartSeries();
        team1.setLabel("team1");
        team1.set("1回目", 50);
        team1.set("2回目", 75);
        team1.set("3回目", 100);

        lineModel.addSeries(team1);

        lineModel.setTitle("team1");
        lineModel.setLegendPosition("e");
        lineModel.setShowPointLabels(true);
        lineModel.getAxes().put(AxisType.X, new CategoryAxis("Number of submit"));
        Axis yAxis = lineModel.getAxis(AxisType.Y);
        yAxis.setLabel("Testcase Pass");
        yAxis.setMin(0);
        yAxis.setMax(100);

        return lineModel;
    }
}


