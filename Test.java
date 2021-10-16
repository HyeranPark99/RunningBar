package RunningBar;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Test {
	public static void main(String[] args)throws IOException {
		File file = new File("C:\\Users\\Hyeran\\Desktop\\b.txt");
		In dataFile = new In(file);
		
		
		String title = dataFile.readLine();
		String xAxisL = dataFile.readLine();
		String dataSource = dataFile.readLine();
		
		BarChart chart = new BarChart(title, xAxisL, dataSource);
		Bar[] bars =null;
		int recordsPerGroup = 0;
		String caption = "";
		
		while(dataFile.hasNextLine()) {
			String currentL = dataFile.readLine();
			recordsPerGroup = Integer.parseInt(dataFile.readLine()); //number of records
			bars = new Bar[recordsPerGroup];
			
			for(int i = 0; i < recordsPerGroup; i++) {
				currentL = dataFile.readLine();
				String[] data = currentL.split(",");
				//System.out.println(data[0]);
				
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
			
			//Arrays.sort(bars);
            // add from the first to k bars to the bar chart in descending order
            for (int i = 0; i < recordsPerGroup; i++) {
                    Bar bar = bars[recordsPerGroup-1-i];
                   System.out.println(bar.toString());
            }
		
		
		}
	}
}
