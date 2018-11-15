package myMath;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;

import de.erichseifert.gral.data.DataSource;
import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.data.filters.Convolution;
import de.erichseifert.gral.data.filters.Filter.Mode;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
import de.erichseifert.gral.plots.lines.LineRenderer;
import de.erichseifert.gral.ui.InteractivePanel;

// I took this class test and library from Gral site link :http://trac.erichseifert.de/gral/
/*
 * This class is drawing Polynom on Axis and print it on screen
 * this class has taken from library Gral at this site :http://trac.erichseifert.de/gral/
 */
public class LinePlotTest extends JFrame {
/*
 * Constructor that get Polynom and print it on screen.
 */
	public LinePlotTest(Polynom p) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 500);
		double eps = 0.01;
		double y0, ymid, y1;
		DataTable data = new DataTable(Double.class, Double.class);
		DataTable CriticalPoints = new DataTable(Double.class, Double.class);
		
		for (double x = -2; x <= 6; x += eps) {
			y0 = p.f(x - eps);
			ymid = p.f(x);
			y1 = p.f(x + eps);
			if (ymid < y0 && ymid < y1 || ymid > y0 && ymid > y1) {
				CriticalPoints.add(x, ymid);
			}
			double y = p.f(x);
			data.add(x, y);
		}

		XYPlot plot = new XYPlot(data);
		plot.add(data);
		plot.add(CriticalPoints);
		Shape circle = new Ellipse2D.Double(-4.0, -4.0, 8.0, 8.0);
		getContentPane().add(new InteractivePanel(plot));
		LineRenderer lines = new DefaultLineRenderer2D();
		plot.setLineRenderers(data, lines);
		plot.getPointRenderers(CriticalPoints).get(0).setShape(circle);
		plot.getPointRenderers(CriticalPoints).get(0).setColor(Color.RED);
		plot.getPointRenderers(CriticalPoints).get(0).setValueVisible(true);
		plot.getPointRenderers(data).get(0).setColor(Color.blue);
		plot.getLineRenderers(data).get(0).setColor(Color.blue);		
	
	}

}
