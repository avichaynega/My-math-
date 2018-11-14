package myMath;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;

import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
import de.erichseifert.gral.plots.lines.LineRenderer;
import de.erichseifert.gral.plots.points.PointRenderer;
import de.erichseifert.gral.ui.InteractivePanel;

public class LinePlotTest extends JFrame {
	public LinePlotTest(Polynom p) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 400);
		double eps = 0.1;
		double y0, ymid, y1;
		System.out.println(p.toString());
		DataTable data = new DataTable(Double.class, Double.class);
		DataTable data2 = new DataTable(Double.class, Double.class);
		for (double x = -2; x <= 6; x += 0.01) {
			y0 = p.f(x - eps);
			ymid = p.f(x);
			y1 = p.f(x + eps);
			if (ymid < y0 && ymid < y1 || ymid > y0 && ymid > y1) {
				data2.add(x, ymid);
			}
			double y = p.f(x);
			data.add(x, y);
		}
		XYPlot plot = new XYPlot(data);
		plot.add(data2);
		Shape circle = new Ellipse2D.Double(-4.0, -4.0, 8.0, 8.0);
		getContentPane().add(new InteractivePanel(plot));
		LineRenderer lines = new DefaultLineRenderer2D();
		plot.setLineRenderers(data,lines);
		plot.getPointRenderers(data2).get(0).setShape(circle);
		plot.getPointRenderers(data2).get(0).setColor(Color.RED);
		plot.getPointRenderers(data2).get(0).setValueVisible(true);
		plot.getPointRenderers(data).get(0).setColor(Color.BLUE);;
		plot.getLineRenderers(data).get(0).setColor(Color.BLUE);
		

		
	}

}
