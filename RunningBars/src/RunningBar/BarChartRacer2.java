package RunningBar;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class BarChartRacer2 {
	public static void main(String[] args) throws IOException {
		StdDraw.setCanvasSize(1000,700);
		StdDraw.enableDoubleBuffering();
		
		
		File file = new File("C:\\Users\\Hyeran\\Desktop\\Data.txt");
		Scanner myFile = new Scanner(file);
		
		
		String title = myFile.nextLine();
		String xAxisL = myFile.nextLine();
		String dataSource = myFile.nextLine();	
		
		BarChart chart = new BarChart(title, xAxisL, dataSource);
		Bar[] bars;
		int numberOfRecs = 0;
		String caption = "";
		
		
		
		while(myFile.hasNextLine()) {
			String currentL = myFile.nextLine();
			numberOfRecs = Integer.parseInt(myFile.nextLine());
			bars = new Bar[numberOfRecs];
			
			for(int i = 0; i < numberOfRecs; i++) {
				currentL = myFile.nextLine();
				String[] data = currentL.split(",");	// split data and stores
				if (i == 0) {
                    caption = data[0];
                    chart.setCaption(caption);
				}
				String name = data[1];
				int value = Integer.parseInt(data[3]);
				String category = data[4];
				Bar bar = new Bar(name, value, category);
				bars[i] = bar;
			}
			
			Arrays.sort(bars);
            // add from the first to 12th records to the bar chart 
            for (int i = 0; i < 12; i++) {
                    Bar bar = bars[numberOfRecs-1-i];
                    chart.add(bar.getName(), bar.getValue(), bar.getCategory());
            }
		
            StdDraw.clear();
            chart.draw();
            StdDraw.show();
            StdDraw.pause(30);
            chart.reset();
            bars = null;
		
    		

		}
	}
}
