

public class Patient {
	private String nric4;
	private String name;
	private String ward;
	private int bed;
	private String dateWarded;
	private String dateDischarged;
	private int visitorCount;
	private String contact; /*contact number*/
	private String nok1; /*next of kin*/
	private String nokC1; /*next of kin's contact*/
	private String nok2; /*next of kin*/
	private String nokC2; /*next of kin's contact*/
	private double amtOwed; /*amount owed which is calculated at discharge in comparison to date warded*/
	private double amtPaid; /*amount paid which will have another function/method to update amount paid*/
	private int daysS;
	private int visitorIndex;
	private double debtForgiven;

	/*additional constructor */
	public Patient(String ic,String n, String w, int b, String dWarded, String dDischarged, String c, String nk, String nkC, int In) {
		nric4 = ic;
		name = n;
		ward = w;
		bed = b;
		dateWarded = dWarded;
		dateDischarged = dDischarged;
		visitorCount = 0;
		contact =c;
		nok1 = nk;
		nokC1= nkC;
		amtOwed = 0.00;
		amtPaid = 0.00;
		daysS = 0;
		visitorIndex =In;
		debtForgiven = 0.00;
	}
	
	/*default requirement of public patient constructor 1*/
	public Patient(String ic,String n, String w, int b, String dWarded, String dDischarged, int v, int In) {
		nric4 = ic;
		name = n;
		ward = w;
		bed = b;
		dateWarded = dWarded;
		dateDischarged = dDischarged;
		visitorCount = v;
		contact ="";
		nok1 = "";
		nokC1 = "";
		amtOwed = 0.00;
		amtPaid = 0.00;
		daysS = 0;
		visitorIndex =In;
		debtForgiven = 0.00;
	}
	
	/*default requirement of public patient constructor 2*/
	public Patient(String ic,String n, String w, int b, String dWarded, int In) {
		nric4 = ic;
		name = n;
		ward = w;
		bed = b;
		dateWarded = dWarded;
		dateDischarged = "";
		visitorCount = 0;
		contact ="";
		nok1 = "";
		nokC1 = "";
		amtOwed = 0.00;
		amtPaid = 0.00;
		daysS = 0;
		visitorIndex =In;
		debtForgiven = 0.00;
	}
	
	public String getNric4() {
		return nric4;
	}
	
	public String getName() {
		return name;
	}
	
	public String getWard() {
		return ward;
	}
	
	public int getBed() {
		return bed;
	}
	
	public String getDateWarded() {
		return dateWarded;
	}
	
	public String getDateDischarged() {
		return dateDischarged;
	}
	
	public void setDateDischarged(String date) {
		dateDischarged = date;
	}
	
	public int getVisitorCount() {
		return visitorCount;
	}
	
	public void setVisitorCount(int count) {
		visitorCount = count;
	}
	
	/*get and set for the private modifiable contents of patient*/
	public String getContact() {
		return contact;
	}
	
	public String getNok1() {
		return nok1;
	}
	
	public String getNokC1() {
		return nokC1;
	}
	
	public String getNok2() {
		return nok2;
	}
	
	public String getNokC2() {
		return nokC2;
	}
	
	public double getAmtOwed() {
		return amtOwed;
	}
	
	public double getAmtPaid() {
		return amtPaid;
	}
	
	public void setAmtPaid(double x) {
		amtPaid = x;
	}
	
	public double setAmtOwed(String dateW,String dateD, String show, double charge) {
		daysS=0; /*check on this again*/
		
		if (dateD!="") {
		
		int day1 =Integer.parseInt(dateW.substring(0,2));
		int mth1 =Integer.parseInt(dateW.substring(3,5));
		int yr1 =Integer.parseInt(dateW.substring(6,10));
		
		int day2 =Integer.parseInt(dateD.substring(0,2));
		int mth2 =Integer.parseInt(dateD.substring(3,5));
		int yr2 =Integer.parseInt(dateD.substring(6,10));
		
		//days in mth.
		//31 = 1,3,5,7,8,10,12
		//28 = 2
		//30 = 4,6,9,11
	
		int [] mthArray = {31,28,31,30,31,30,31,31,30,31,30,31};
		int mthCounter = mth1;
		
		if(yr2>yr1 && mth2>=mth1) {
			daysS+=((yr2-yr1)*365)+1;
		}else if(yr2>yr1 && mth1>mth2) {
			int revMth = mth2-mth1; //reverse calculation, gives negative number
			int mthDiff = 0; //stores the mth difference
			while(revMth!=0) {
				mthDiff++;
				revMth++;
				
			}
			for(int i = mthDiff; i<mthArray.length; i++) {
				daysS+=mthArray[i];
			}
			
		}
		
		if(mth2>mth1) {
			//daysS+=((mth2-mth1)*30)+1;
			for(int i=0; i<mthArray.length;i++) {
				if(mthCounter-1==i) {
					mthCounter++;
					daysS+=mthArray[i];
				}
			}
		}
		
		
		if(day2>day1) {
			daysS+=(day2-day1)+1;
		}else if(day2==day1) {
			daysS+=1;
		}
		amtOwed = (charge*daysS);
		
		
	
		/*System.out.println("The difference is: " + daysS); /*to test day difference system*/
		
		}
		
		if (show.equalsIgnoreCase("Y")) {
		System.out.println("The amount owed is: $" + amtOwed + " for " + daysS + " day(s) stayed.");
		}
		return amtOwed;
	}
	
	public int getVisitorIdx() {
		return visitorIndex;
	}
	
	public double getDebtForgiven() {
		return debtForgiven;
	}
	
	public void setDebtForgiven(double x) {
		debtForgiven = x;
	}
	
	public void setAmtOweL(double x) {//this method overwrites the amt owed after payment has been made
		amtOwed = x;
	}
	
	public int getDaysS() {
		return daysS;
	}
	
	
	public void display() {
		System.out.println(String.format("  %-18s %s\n  %-18s %s\n  %-18s %s%d\n  %-18s %s\n  %-18s %s\n  %-18s %s%d","Patient Name", ":"+ name,"Ward",":"+ ward, "Bed",":", bed,"Date Warded",":"+dateWarded,"Date discharged",":"+dateDischarged,"No of visitor(s)",":",visitorCount));
	}
}
