 
public class Visitors {
	private String nric4;
	private String name;
	private String vContact;
	private String dateOfLastVisit;
	private String nok1; /*next of kin of patient?*/
	private String nok2; /*next of kin of patient*/
	private int visited;
	private String onPremise;
	private String visitationPurpose;
	private int visitorID;
	
	public Visitors(String ic, String n, String c, String d, String nk1, String nk2, String p, String vp, int In) {
		nric4 = ic;
		name = n;
		vContact = c;
		dateOfLastVisit = d;
		nok1 = nk1;
		nok2 = nk2;
		visited = 1;
		onPremise = p;
		visitationPurpose = vp;
		visitorID = In;
	}
	
	public Visitors(String ic, String n, String c, String d, String nk1, String p, String vp,int In) {
		nric4 = ic;
		name = n;
		vContact = c;
		dateOfLastVisit = d;
		nok1 = nk1;
		nok2 = "";
		visited = 1;
		onPremise = p;
		visitationPurpose = vp;
		visitorID = In;
	}
	
	public String getNric() {
		return nric4;
	}
	
	public String getName() {
		return name;
	}
	
	public String getContact() {
		return vContact;
	}
	
	public void setContact(String x) {
		vContact =x;
	}
	
	public String getDate() {
		return dateOfLastVisit;
	}
	
	public void setDate(String date) {
	  dateOfLastVisit=date;
	}
	
	public String getnok1() {
		return nok1;
	}
	
	public String getnok2() {
		return nok2;
	}
	
	public void setnok1(String nk1) {
		nok1 = nk1;
	}
	
	public void setnok2(String nk2) {
		nok2 = nk2;
	}
	
	public int getvisited() {
		return visited;
	}
	
	public void setvisited(int num) {
		visited = num;
	}
	
	public int getVisitorID() {
		return visitorID;
	}
	
	public String getvisitationP() {
		return visitationPurpose;
	}
	public void setvisitationP(String x) {
		visitationPurpose = x;
	}
	
	public String getOnPremise() {
		return onPremise;
	}
	
	public void setOnPremise(String x) {
		onPremise = x;
	}
}
