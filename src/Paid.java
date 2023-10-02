

public class Paid { //when record is in the process of deletion, it will transfer payment data over here.
	private String nric4;
	private String name;
	private int daysStayed;
	private double paid;
	private double debtForgiven;
	
	public Paid(String ic,String n, int d, double paid,double f ) {
		nric4 = ic;
		name = n;
		daysStayed = d;
		this.paid =paid;  //in the GA I reverse it for some reason and it end up not working after.
		debtForgiven=f;
	}
	
	public double getAmtPaid() {
		return paid;
	}
	
	public void setAmtPaid(double p) {
		paid = p;
	}
	
	public String getNric() {
		return nric4;
	}
	
	public String getName() {
		return name;
	}
	
	public int getDaysS() {
		return daysStayed;
	}
	
	public double getDebtF(){
		return debtForgiven;
	}
	
	public void setDebtF(double x){
		debtForgiven = x;
	}
}

	
