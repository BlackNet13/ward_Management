import java.util.ArrayList;


public class testWardManagement {
	public static void main(String[] args) {
		
		/*testing for ward array adding new ward into wardArr*/
		Ward[] wardArr = new Ward[4];
		
		wardArr[0] = new Ward("A","ER Patients",20,100.00);
		wardArr[1] = new Ward("B","Short term Ward",20,30.00);
		wardArr[2] = new Ward("C","Long term Ward",40,80.00);
		wardArr[3] = new Ward("D","Observation Ward",20,50.00);
		
		
		
		
		/*testing for patient arraylist for displaying and etc*/
		ArrayList<Patient> patientList = new ArrayList<Patient>();
	
		patientList.add(new Patient("123U","John1","A",5,"03/01/2022","04/02/2022",0,1));
		patientList.add(new Patient("123K","John2","B1",5,"03/01/2022",2));
		patientList.add(new Patient("123A","John3","B2",5,"03/01/2022",3));
		patientList.add(new Patient("123Z","John4","C",5,"03/01/2022","04/01/2022","0897 0807","Tan Jue","9080 9708",4));
		
		/*
		Patient p1 = patientList.get(1); 
		p1.display();
		*/
		
		/*testing if substring works properly
		String DD = Helper.readString("Enter date discharged >");
		int day =Integer.parseInt(DD.substring(0,2));
		int mth =Integer.parseInt(DD.substring(3,5));
		int yr =Integer.parseInt(DD.substring(6,10));
		
		if (yr <Integer.parseInt(patientList.get(1).getDateWarded().substring(6,10))) {
			System.out.print("nope"+patientList.get(1).getDateWarded().substring(0,2));
		}
		*/
		
		patientList.get(1).display();
		
		/*patientList.get(0).setAmtOwed(patientList.get(0).getDateWarded(), patientList.get(0).getDateDischarged(), "Y", patientList.get(0).getWard());*/
		
	}

}
