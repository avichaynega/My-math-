package myMath;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

public class Example0 {
	public static void main(String[] args) throws Exception {
		Polynom p = new Polynom();
	    Monom a = new Monom(2, 2);
	    Monom b =new Monom(3, 1);
	    p.add(a);
	    p.add(b);
		 
	    double[] xData = new double[] { -2,-1.5,-1,-0.5, 0,1,2,3,4,5,6 };
	    double[] yData = new double[] { p.f(-2),p.f(-1.5), p.f(-1),p.f(-0.5), p.f(0),p.f(1),p.f(2),p.f(3),p.f(4),p.f(5),p.f(6)};
	    
	    
	    for (int i = 0; i < yData.length; i++) {
			System.out.println(yData[i]);
		}
	    // Create Chart
	    XYChart chart = QuickChart.getChart("Sample Chart", "X", "Y","y="+p.toString(), xData, yData);
 	    // Show it
	   new SwingWrapper(chart).displayChart();
	 
	  }
}
