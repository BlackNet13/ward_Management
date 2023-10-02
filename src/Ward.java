

public class Ward {
	private String ward;
	private String description;
	private int bedCount;
	private double bedCharge;
	
	public Ward(String w,String d, int bCount, double bCharge) {
		ward = w;
		description = d;
		bedCount = bCount;
		bedCharge = bCharge;
	}
	
	
	public String getWard() {
		return ward;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getBedCount() {
		return bedCount;
	}
	
	public double getBedCharge() {
		return bedCharge;
	}
	
	
	
}
