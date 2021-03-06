package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;

import Control.CtrFunctionality;

public class BarChart {
	CtrFunctionality functionalityCtr = new CtrFunctionality();

	public BarChart(final String title, CategoryDataset dataset,
			String chartTitle, String x, String y, JPanel contentPanel) {
		final JFreeChart chart = createChart(dataset, chartTitle, x, y);
		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setSize(new Dimension(500, 270));
		chartPanel.setBounds(0, 0, 838 + functionalityCtr.getAddWidth(), 414);

		contentPanel.add(chartPanel);
		contentPanel.invalidate();
		contentPanel.revalidate();
		contentPanel.repaint();
		contentPanel.setVisible(true);

	}

	private JFreeChart createChart(final CategoryDataset dataset,
			String chartTitle, String x, String y) {

		final JFreeChart chart = ChartFactory.createBarChart(chartTitle, x, y,
				dataset, PlotOrientation.VERTICAL, true, true, false);

		chart.setBackgroundPaint(Color.lightGray);

		final CategoryPlot plot = chart.getCategoryPlot();
		plot.setBackgroundPaint(Color.lightGray);
		plot.setDomainGridlinePaint(Color.white);
		plot.setRangeGridlinePaint(Color.white);

		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

		final BarRenderer renderer = (BarRenderer) plot.getRenderer();
		renderer.setDrawBarOutline(false);

		// set up gradient paints for series...
		final GradientPaint gp0 = new GradientPaint(0.0f, 0.0f, Color.blue,
				0.0f, 0.0f, Color.lightGray);
		final GradientPaint gp1 = new GradientPaint(0.0f, 0.0f, Color.green,
				0.0f, 0.0f, Color.lightGray);
		final GradientPaint gp2 = new GradientPaint(0.0f, 0.0f, Color.red,
				0.0f, 0.0f, Color.lightGray);
		renderer.setSeriesPaint(0, gp0);
		renderer.setSeriesPaint(1, gp1);
		renderer.setSeriesPaint(2, gp2);

		final CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions
				.createUpRotationLabelPositions(Math.PI / 6.0));

		return chart;

	}

}
