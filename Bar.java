package RunningBar;

import java.util.Arrays;

public class Bar implements Comparable<Bar> {
	
	private String name;
	private int val;
	private String ctgry;
	
	
	public Bar(String name, int value, String category) {
		this.name =name;
		this.val = value;
		this.ctgry = category;
	}
	
	public String getName() {
		if(name == null)
			throw new IllegalArgumentException("Invalid name: "+null);
		return this.name;
	}
	
	public int getValue() {
		if(val < 0)
			throw new IllegalArgumentException("Invalid value: "+ val);
		return this.val;
	}
	
	public String getCategory() {
		if(ctgry == null)
			throw new IllegalArgumentException("Invalid name: "+null);
		return this.ctgry;
	}
	
	
	public String toString() {
		return getName()+ ", "+ getValue()+", "+getCategory();
	}
	
	
	/**
	 * Logic to sort.
	 *
	 */
	@Override
	public int compareTo(Bar o) {
		// ToODO Auto-generated method stub
		if(o == null)
			throw new NullPointerException("Invalid Bar object");
		return Integer.compare(this.getValue(), o.val);
	}
	
	
	public static void main(String[] args) {
		Bar[] bars = new Bar[10];
        bars[0] = new Bar("Beijing", 22674, "East Asia");
        bars[1] = new Bar("Cairo", 19850, "Middle East");
        bars[2] = new Bar("Delhi", 27890, "South Asia");
        bars[3] = new Bar("Dhaka", 19633, "South Asia");
        bars[4] = new Bar("Mexico City", 21520, "Latin America");
        bars[5] = new Bar("Mumbai", 22120, "South Asia");
        bars[6] = new Bar("Osaka", 20409, "East Asia");
        bars[7] = new Bar("SÄ?o Paulo", 21698, "Latin America");
        bars[8] = new Bar("Shanghai", 25779, "East Asia");
        bars[9] = new Bar("Tokyo", 38194, "East Asia");

        Arrays.sort(bars);
        for (int i = 0; i < bars.length; i++)
            StdOut.println(bars[i]);
		
		
	}
	
	


	
}
