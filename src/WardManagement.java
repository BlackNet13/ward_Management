import java.util.ArrayList;




public class WardManagement {

	public static void main(String[] args) {

		
		//Initialize Ward array with ward objects 
		Ward[] wardArr = new Ward[4];
		
		//-------------------
		// Complete code here
		//-------------------
		wardArr[0] = new Ward("A","1 Bed, attached bath/toilet",10,535.00);
		wardArr[1] = new Ward("B1","4 Bed, attached bath/toilet",20,266.43);
		wardArr[2] = new Ward("B2","6 Bed, common bath/toilet",20,83.00);
		wardArr[3] = new Ward("C","8 Bed, common bath/toilet",50,37.00);

		
		//initialise Patient arraylist with patient objects	
		ArrayList<Patient> patientList = new ArrayList<Patient>();
		
		//-------------------
		// Complete code here
		//-------------------
		patientList.add(new Patient("111A","John Lee","A",2,"01/12/2022",1));
		patientList.add(new Patient("222B","Mary Jane","B1",11,"02/12/2022",2));
		patientList.add(new Patient("333C","Abdul Musri","B1",12,"03/12/2022",3));
		patientList.add(new Patient("444D","Jane Tan","B2",2,"12/12/2022","",3,4));
		patientList.add(new Patient("555E","Paul Tan","C",2,"02/11/2022","",4,5));
		patientList.add(new Patient("666F","Paul Ng","C",3,"03/11/2022","09/11/2022",0,6));
		patientList.add(new Patient("777G","Wong Kuan","C",4,"02/12/2022",7));
		
		//visitorList - Addon
		ArrayList<Visitors> visitorList = new ArrayList<Visitors>(); /*so that it can expand when needed*/
		visitorList.add(new Visitors("222A","Tru Lee","8000 2000","02/12/2022","John Lee","N","",1)); /*new visitorAddition to records */
		/*below are visitors currently on premise to match the case provided */
		visitorList.add(new Visitors("125J","Jacob Tan","8056 2045","12/12/2022","Paul Tan","Y","Paul Tan",5)); //1
		visitorList.add(new Visitors("246W","Mike Kie","8999 2879","12/12/2022","Paul Tan","Y","Paul Tan",5)); //2
		visitorList.add(new Visitors("127Z","Jacob Tan","9123 2033","12/12/2022","","Y", "Paul Tan",5)); //3
		visitorList.add(new Visitors("129L","Lucy Ng","8245 2345","12/12/2022","Paul Tan","Y","Paul Tan",5)); //4
		visitorList.add(new Visitors("125P","Julie Wang","8989 2945","12/12/2022","Jane Tan","Y","Jane Tan",4)); //5
		visitorList.add(new Visitors("156W","Taylor Tan","8446 2345","12/12/2022","Jane Tan","Y","Jane Tan",4)); //6
		visitorList.add(new Visitors("197I","Susan Rie","9306 3145","12/12/2022","","Y","Jane Tan",4)); //7
		
		//paymentrecordList - Addon
		ArrayList<Paid>recordList = new ArrayList<Paid>();
		

		//amtArrears , amtEarned, badDebt -Addon
		double [] paymentOverview = {0.00,0.00,0.00};
		
		//display standard menu and ask for option
		int option = -99;
		publicMenu();
		
		
		
		//indefinite while loop
		while(option != 11) {
			boolean patientfound = true;
			option = Helper.readInt("\nEnter option or 0 for main menu > ");

			//check for  options
			if(option == 0) {
				//display main menu
				publicMenu();
			} else if (option == 1) {
				//list ward info
				displayWardInfo(wardArr);		
			} else if (option == 2) {
				//display patient in ward
				displayPatientList(patientList,wardArr); //Parameter was change
			} else if (option == 3) {
				//admit patient
				admitPatient(patientList);
			} else if (option == 4) {
				//discharged patient
				patientfound = dischargePatient(patientList,wardArr,visitorList); //Parameter was change
			} else if (option == 5) {
				//Remove patient
				patientfound = removePatient(patientList,visitorList,recordList); //Parameter was change
			} else if (option == 6) {
				//register visit
				patientfound = registerVisit(patientList,visitorList); //Parameter was change
			} else if (option == 7) {
				//End visit
				patientfound = endVisit(patientList,visitorList); //Parameter was change
			} else if (option == 8) {
				//End visit
				displayWardOverview(patientList, wardArr);
			}else if (option == 9) {
				//Visitors
				displayVisitorList(visitorList); //AddOn
			}else if (option == 10) {
				//View amount owed per patient, register payment for select patient, show total amount in arrears.
				paymentRelated(patientList, wardArr,paymentOverview,recordList); //AddOn
			}else if (option == 11)/*edited as two more options was added*/ {
				//log out
				System.out.println("\nGood bye!");
			} else {
				//invalid option chosen
				System.out.println("\n*** Invalid option selected ***\n");
			}

			//if patient does not exist based on return boolean
			if (!patientfound) {
				System.out.println("\n*** No such patient in ward ***\n");
			}

		}

	} // end of main



	

	//-------------------------------------------------------------------------------------------------------
	//static method to print the standard menu 
	//-------------------------------------------------------------------------------------------------------
	public static void publicMenu() {
		System.out.println();
		Helper.line(45, "*");
		System.out.println("*****     PATIENT  MANAGEMENT  MENU     *****");
		Helper.line(45, "*");
		
		//-------------------
		// Complete code here
		//-------------------
		System.out.println(String.format("| %-4sView all Ward Info%21s\n| %-4sDisplay Patient List%19s\n| %-4sAdmit Patient%26s\n| %-4sDischarge Patient%22s\n| %-4sRemove Patient%25s\n| %-4sRegister Visit%25s\n| %-4sEnd Visit%30s\n| %-4sDisplay Ward Overview%30s\n| %-4sVisitor List%49s\n| %-4sPayment Related%46s\n| %-4sLogout%55s", "1.","|","2.","|","3.","|","4.","|","5.","|","6.","|","7.","|","8."," __      __   _         ","9."," \\ \\    / /__| |__ ___ _ __  ___  ","10.","  \\ \\/\\/ / -_) / _/ _ \\ '  \\/ -_) ","11.","   \\_/\\_/\\___|_\\__\\___/_|_|_\\___| "));
	}



	//-------------------------------------------------------------------------------------------------------
	//static method takes in a ward array and list out ward details in a tabular list
	//-------------------------------------------------------------------------------------------------------
	public static void displayWardInfo(Ward[] wardArr) {

		//-------------------
		// Complete code here
		//-------------------
		//for ease: opt 1,completed and checked /
		System.out.println(String.format("\n******Ward Information******\n\n%-6s%-30s%-12s%s","Ward","Description","Bed Count","Bed Charge" ));
		System.out.println(String.format("%-6s%-30s%-12s%s","----","-----------","---------","----------" ));
		
		//loop that will print out each object in the array wardArr
		for (int i=0;i<wardArr.length;i++) {
		System.out.println(String.format("%-6s%-30s%-12d$%.2f", wardArr[i].getWard(),wardArr[i].getDescription(),wardArr[i].getBedCount(),wardArr[i].getBedCharge()));
		}
	}


	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and display all the patient information in a tabular list
	//-------------------------------------------------------------------------------------------------------
	public static void displayPatientList(ArrayList<Patient> patientList, Ward[] wardArr) { //Parameter was change

		//-------------------
		// Complete code here
		//-------------------
		//for ease: opt 2,checked and completed + also shows amount owed and paid /
		System.out.println(String.format("\n******Patient List******\n\n%-8s%-16s%-6s%-6s%-15s%-18s%-15s%-15s%s","NRIC4","Name","Ward","Bed","Date Warded","Date Discharged","Visitor Count","Amount Owed", "Amount Paid"));
		System.out.println(String.format("%-8s%-16s%-6s%-6s%-15s%-18s%-15s%-15s%s","-----","----","---","---","-----------","---------------","-------------","-----------", "-----------"));
		
		//loop that goes through whether the patient has a record for amt owed/paid and also sets the bed charge to 0 by default
	for (int i=0; i<patientList.size(); i++) {
		double o = patientList.get(i).getAmtOwed();
		double p = patientList.get(i).getAmtPaid();
		double c = 0.00;
	
		//still in loop, this checks whether the data for the patient in the data discharge is empty or not,
		//if it is not and the amount owed & paid are both zero and has not been calculated it will push in the amount owed	
		if (patientList.get(i).getAmtPaid()==0 && patientList.get(i).getDateDischarged()!="" && patientList.get(i).getAmtOwed()==0) {
			String [] wardList = {"A","B1","B2","C"}; //list of existing wards in an array.
			if(patientList.get(i).getDebtForgiven()==0) {
				for (int x=0; x<wardList.length; x++) {
					if (patientList.get(i).getWard().equalsIgnoreCase(wardList[x])) { //if ward in patient list equals ward in the wardlist above
						c= wardArr[x].getBedCharge(); //it gets the charged for the bed from the original ward list using the number from through the loop from the wardlist above
						o= patientList.get(i).setAmtOwed(patientList.get(i).getDateWarded(), patientList.get(i).getDateDischarged(), "N", c);//it sets the amount by taking in parameters
						//the parameters are as follows: date warded. date discharged. Y/N because this method also has a print function which is being use in the discharge patient option,
						//finally it also takes in the charged amount for that bed. It then substrings both dates given, and add it the day stayed times the amount of charge.
					}
					}
			}
			
		}
		//prints the info after the processing above
		System.out.println(String.format("%-8s%-16s%-6s%-6s%-15s%-18s%-15s$%-15.2f$%.2f",patientList.get(i).getNric4(),patientList.get(i).getName(),patientList.get(i).getWard(),patientList.get(i).getBed(),patientList.get(i).getDateWarded(),patientList.get(i).getDateDischarged(),patientList.get(i).getVisitorCount(),o,p));
	}
	}


	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the admit patient functionality
	//-------------------------------------------------------------------------------------------------------
	public static void admitPatient(ArrayList<Patient> patientList) {

		//-------------------
		// Complete code here
		//-------------------
		//for ease: opt 3,checked and completed + has advanced validation checks /
	System.out.print("\n===========REGISTER PATIENT ADMITANCE==========\n\n");
	 String N = Helper.readString("  Enter Patient 4 digit NRIC > ");
	 if (N.length()==4 ) {
		 if(Character.isDigit(N.charAt(0))&& Character.isDigit(N.charAt(1))&& Character.isDigit(N.charAt(2))&& Character.isAlphabetic(N.charAt(3))) {//checks if entry of last digit of nric is correct
			
			for (int i=0; i<patientList.size(); i++) {
				
				if(N.equalsIgnoreCase(patientList.get(i).getNric4())) { //checks if nric exist already
					System.out.println("\n  NRIC entered exist.");
					N = Helper.readString("\n  Enter Patient 4 digit NRIC > ");
				}}
			
			String PN = Helper.readString("\n  Enter Patient name > "); //name does not get similarity checks as there will be some people with same name but different nric
			 String W = Helper.readString("\n  Enter Ward > ").toUpperCase();
			 boolean checkW=false;
			 while(checkW==false) { //checks if user keys in existing ward
				 switch(W) {
				  case "A":
					checkW=true;
				    break;
				  case "B1":
					checkW=true;
				    break;
				  case "B2":
					checkW=true;   
					break;
				  case "C":
					checkW=true;   
					break;
				  default:
					System.out.println("\n  The ward does not exist");
					W = Helper.readString("\n  Enter Ward > ").toUpperCase();
				}
			 }
			 
			 int B = Helper.readInt("\n  Enter Bed > "); //needs to be outside of the while loop to be able 
			 //to be added when all checks are completed

			 boolean checkB=false;
			 while(checkB==false) {//checking if bed exist, if occupied
				 for (int i=0; i<patientList.size(); i++) {
				 if((B>20 && W!="C" && B>0)||(B>0 && B>50 && W=="C")) { //this works, it checks if the bed no entered exists
					System.out.println("\n  The ward does not contain that bed number.\n");
					B = Helper.readInt("\n  Enter Bed > ");
				}else if(B==patientList.get(i).getBed()&& patientList.get(i).getDateDischarged()=="") { //this checks if there are any existing bed entry that hasnt been discharged
						System.out.println("\n  The bed is occupied.\n");
						B = Helper.readInt("\n  Enter Bed > ");
				}else{//if all the above is false, this will be true.
					checkB=true;
				}
				}
			 }
			 
				String DW = Helper.readString("\n  Enter Date Warded > ");
				int DWL = DW.length();
				if (!DW.matches("\\d{2}/\\d{2}/\\d{4}") && DWL!=10) {//checks if date is entered in the correct format, it checks for matches to regular expression, the d being digit, to make it more complex you can actually add the range for each digit.
					System.out.println("\n  The date must be entered in this format: dd/mm/yyyy\n");
					DW = Helper.readString("\n  Enter Date Warded > ");
				}
				patientList.add(new Patient(N,PN,W,B,DW,patientList.size()+1)); //the extra parameter is use to generate the code for the visitor index
				//this visitor index will help tie the patient data in relation to the visitor. This helps with deletion later on.
				System.out.println();
				patientList.get(patientList.size()-1).display();
				System.out.println("\n  *** Patient has been added ***");
						
					
		 }else {
			 System.out.println("\n  Enter NRIC Number's last 3 digits & Alphabet"); //error msg
			 admitPatient(patientList); //starts process again
		 }
	}else {
		 System.out.println("\n  Enter the last four characters of the NRIC Number"); //error msg
		 admitPatient(patientList); //starts process again
	 	}
	}


	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the discharge patient functionality
	//It will return 'true' if the patient record exist
	//-------------------------------------------------------------------------------------------------------
	public static boolean dischargePatient(ArrayList<Patient> patientList, Ward [] wardArr,ArrayList<Visitors> visitorList) { //Paramete change

		boolean patientfound = false;

		//-------------------
		// Complete code here
		//-------------------
		//for ease: opt 4,checked and completed + has advanced validation checks + visitor on premise status changed to N /
		System.out.print("\n===========REGISTER PATIENT DISCHARGE==========\n\n");
		String nricDis = Helper.readString("Enter patient's Nric > ");
		String nameIn =Helper.readString("Enter patient's Name > ");
		for (int i=0; i<patientList.size();i++) {
		if(nameIn.equalsIgnoreCase(patientList.get(i).getName()) && nricDis.equalsIgnoreCase(patientList.get(i).getNric4())) {
			patientfound = true;
			if (patientList.get(i).getDateDischarged().equals("")) {
			patientList.get(i).display();
			System.out.println();
			String DD = Helper.readString("Enter date discharged > ");
			int DDL = DD.length();
			while (!DD.matches("\\d{2}/\\d{2}/\\d{4}") && DDL!=10 || DDL!=10) {
				System.out.println("\nThe date must be entered in this format: dd/mm/yyyy\n");
				DD = Helper.readString("Enter date discharged > ");
				DDL = DD.length();
			}
			
			int day =Integer.parseInt(DD.substring(0,2));
			int mth =Integer.parseInt(DD.substring(3,5));
			int yr =Integer.parseInt(DD.substring(6,10));
			
			//This portion helps check if date entry is wrong.
			boolean entryC =false;
			while(entryC==false){
				day =Integer.parseInt(DD.substring(0,2));
				mth =Integer.parseInt(DD.substring(3,5));
				yr =Integer.parseInt(DD.substring(6,10));
				
				if (day==0 || mth == 0 || yr == 0) {//checks if date entered is larger then date warded
					System.out.println("\nThe day/month/year must not consist of solely 0.\n");
					DD = Helper.readString("Enter date discharged > ");
					
				}else if(yr < Integer.parseInt(patientList.get(i).getDateWarded().substring(6,10)) ) {
					System.out.println("\nThe year entered must be larger than or equal to year warded.\n");
					DD = Helper.readString("Enter date discharged > ");
					
				}else if(mth == Integer.parseInt(patientList.get(i).getDateWarded().substring(3,5))&& day < Integer.parseInt(patientList.get(i).getDateWarded().substring(0,2))) {
					System.out.println("\nThe day entered must be larger than or equal to the day warded for being warded in the same month and year .\n");
					DD = Helper.readString("Enter date discharged > ");
				}else if(yr == Integer.parseInt(patientList.get(i).getDateWarded().substring(6,10))&& mth < Integer.parseInt(patientList.get(i).getDateWarded().substring(3,5))){
					System.out.println("\nThe month entered must be larger than or equal to month warded for being warded in the same year.\n");
					DD = Helper.readString("Enter date discharged > ");
				}else {
					entryC=true;
				}
			}
			
			
			patientList.get(i).setDateDischarged(DD);
			patientList.get(i).setVisitorCount(0);
			System.out.println("\n*** Patient is discharged ***");
			
			double c = 0.00;
			String [] wardList = {"A","B1","B2","C"};
			for (int x=0; x<wardList.length; x++) {
				if (patientList.get(i).getWard().equalsIgnoreCase(wardList[x])) {
					c= wardArr[x].getBedCharge();
				    patientList.get(i).setAmtOwed(patientList.get(i).getDateWarded(), patientList.get(i).getDateDischarged(), "N", c);
				}
			}
			patientList.get(i).setAmtOwed(patientList.get(i).getDateWarded(), patientList.get(i).getDateDischarged(), "Y", c);
			for(int a=0; a<visitorList.size();a++) { //changes on premise status to N for all that are visiting this patient.
			if (visitorList.get(a).getvisitationP().equalsIgnoreCase(nameIn)) {
				visitorList.get(a).setvisitationP("");
				visitorList.get(a).setOnPremise("N");
			}
			}
			
			
			}else {
				System.out.println("\n*** Patient has already been discharged ***");
			}
		}
		}
		return patientfound;
	}





	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the remove patient functionality
	//It will return 'true' if the patient record exist
	//-------------------------------------------------------------------------------------------------------
	public static boolean removePatient(ArrayList<Patient> patientList, ArrayList<Visitors> visitorList,ArrayList<Paid>recordList) { //Parameter change

		boolean patientfound = false;

		//-------------------
		// Complete code here
		//-------------------
		//for ease: opt 5,checked and completed + checks if patient cannot be deleted due to amount owing, or have not been discharged, removes related visitor data too /
		System.out.print("\n===========PATIENT RECORD REMOVAL==========\n\n");
		String nricRm = Helper.readString("Enter patient's Nric > ");
		String nameIn =Helper.readString("Enter patient's Name > ");
		String yN = "p";
		for (int i=0; i<patientList.size();i++) {
		if(nameIn.equalsIgnoreCase(patientList.get(i).getName())&&nricRm.equalsIgnoreCase(patientList.get(i).getNric4())) {//checks if patient exist.
			 patientList.get(i).display();
			 patientfound = true;
			 
			 
			 while ((!yN.equalsIgnoreCase("y")||!yN.equalsIgnoreCase("n"))&& yN=="p") { //checks for confirmation of deletion
				 yN = Helper.readString("Confirm deletion (y/n) > ");
				 if (yN.equalsIgnoreCase("Y")) {
					 if(patientList.get(i).getAmtOwed()!=0&& patientList.get(i).getAmtPaid()==0) {
						 System.out.println("\nPatient still owes: $"+patientList.get(i).getAmtOwed()+ " and cannot be removed until payment has been made or debt has been forgiven."); //debt forgiven == bad debt expense on records.
					 }else if(patientList.get(i).getDateDischarged()=="") {
					 System.out.println("\nPatient has not been discharged and cannot be deleted from records.");
					 }else {
						 double p = patientList.get(i).getAmtPaid();
						 String n4 = patientList.get(i).getNric4();
						 String n = patientList.get(i).getName();
						 int d = patientList.get(i).getDaysS();
						 double df = patientList.get(i).getDebtForgiven();
						 
						 int pH = patientList.get(i).getVisitorIdx();
						 for(int x=0; x<visitorList.size();x++) {
							 if(visitorList.get(x).getVisitorID()==pH) {
								 visitorList.remove(x);
								 x--;
							 }else if(x==visitorList.size()-1) {
								 recordList.add(new Paid(n4,n,d,p,df));
								 
								 patientList.remove(i);
								 System.out.println("\n*** Patient has been deleted ***");
								 break;
							 }
						 }
					 
					 	}
				 }else if(yN.equalsIgnoreCase("N")) {
					 System.out.println("\n*** Deletion has been cancelled ***");
					 break;
				 }else {
					 System.out.println("\n*** Invalid option, only y or n options allowed ***");
				 }
			 }
			}
		}
		return patientfound;
	}


	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the register visit functionality
	//It will return 'true' if the patient record exist
	//-------------------------------------------------------------------------------------------------------
	public static boolean registerVisit(ArrayList<Patient> patientList,ArrayList<Visitors> visitorList) { //Parameter change

		boolean patientfound = false;

		//-------------------
		// Complete code here
		//-------------------
		//for ease: opt 6,completed and checked + adds/updates visitor list records with relevant data, checks if existing record is present. /
		System.out.print("\n===========REGISTER VISITATION==========\n\n");
		String nricRv = Helper.readString("\nEnter patient's last four digit of NRIC > ");
		String nameIn =Helper.readString("\nEnter patient name > ");
		for (int i=0; i<patientList.size();i++) {
		if(nameIn.equalsIgnoreCase(patientList.get(i).getName())&&nricRv.equalsIgnoreCase(patientList.get(i).getNric4())) {
			 	patientList.get(i).display();
				 patientfound=true;
			 	boolean complete = false;
			 if (patientList.get(i).getDateDischarged().equals("")) {
				 if (patientList.get(i).getVisitorCount()==4) {
					 System.out.println("\n*** No additional visitor allowed ***\n");
					 complete = true;

				 }else if(patientList.get(i).getVisitorCount()>0) {
					 System.out.println("\n*** Only "+ (4-patientList.get(i).getVisitorCount())+" visitor(s) allowed ***\n");
				 }else {
					 System.out.println("\n*** Only 4 visitor(s) allowed ***\n");
				 }
			 	
			 while(complete==false) {
			 	int vc = Helper.readInt("Enter number of new visitors > ");
			 	int vcCount = 0;
			 	if(vc > 0 && vc+patientList.get(i).getVisitorCount()<=4) {
			 		String d = Helper.readString("Enter date of visit in: dd/mm/yyyy format > ");
			 		int dL = d.length();
			 		while (!d.matches("\\d{2}/\\d{2}/\\d{4}") && dL!=10) {
						System.out.println("\nThe date must be entered in this format: dd/mm/yyyy\n");
						d = Helper.readString("Enter date of visit in: dd/mm/yyyy format > ");
					}
			 		while(vcCount!=vc) {
			 			for (int x=0; x<visitorList.size();) /*doesnt have a increment condition as the break stops it from repeating once it completes it's task*/ {
			 				System.out.println("\n--Please enter details of visitor "+(vcCount+1)+"--");
			 				String ic = Helper.readString("Enter last 4 digit of NRIC of visitor > ");
				 			String nm = Helper.readString("Enter name of visitor > ");
			 				if(ic.equalsIgnoreCase(visitorList.get(x).getNric()) && nm.equalsIgnoreCase(visitorList.get(x).getName())&&visitorList.get(x).getOnPremise()=="N") {
			 					System.out.println("Previous visitor's record found.");
			 					String chg = Helper.readString("Any changes to previous record's contact/family members who are patient? (Y/N) > ");
			 					if (chg.equalsIgnoreCase("Y")) {//makes changes to existing visitor info.
			 						String newC = Helper.readString("Enter new contact number of visitor in xxxx xxxx format,leave blank if no changes >");
			 						String newf1 = Helper.readString("Enter patient name if family, leave blank if no changes >");
			 						String newf2 = Helper.readString("Enter another family member's name if they are also patient, leave blank if no changes >");
			 						if(newC!="") {visitorList.get(x).setContact(newC);}
			 						if(newf1!="") {visitorList.get(x).setnok1(newf1);}
			 						if(newf2!="") {visitorList.get(x).setnok2(newf2);}
			 					}else if(chg.equalsIgnoreCase("N")) {//does not update visitor's info except for status of visitor
			 						visitorList.get(x).setDate(d);
			 						visitorList.get(x).setvisited(visitorList.get(x).getvisited()+1);
			 						visitorList.get(x).setOnPremise("Y");
			 						visitorList.get(x).setvisitationP(nameIn);
			 						vcCount+=1;
			 					}
			 				}else if(visitorList.get(x).getOnPremise()=="Y"){//gives an error msg if visitor is already found to be on premise.
			 					System.out.println("\n-----Visitor already on premise.-----");
			 					break;
			 				}else {//allows for entry of new visitor info.
			 					String c = Helper.readString("Enter contact number of visitor in xxxx xxxx format >");
					 			String f1 = Helper.readString("Enter patient name if next of kin, leave blank if none >");
					 			String f2 = Helper.readString("Enter if another next of kin is also patient, leave blank if none>");
					 			visitorList.add(new Visitors(ic,nm,c,d,f1,f2,"Y",nameIn,patientList.get(i).getVisitorIdx()));
					 			vcCount+=1;
					 			
			 				}
			 				
			 				break; //prevents repetition of loop that will keep asking for visitor info.
			 			}
			 			
			 		}
			 		System.out.println("\n*** Please proceed to ward ***");
			 		patientList.get(i).setVisitorCount(patientList.get(i).getVisitorCount()+vc);
			 		patientfound=true;
			 		complete = true;
			 	}else if(vc <= 0) { //determines that user wants to cancel operation as they give invalid user input for visitor count
			 		String mm = Helper.readString("\nCancel operation ? (y/n)> "); //if n is entered, it will bring user back to the start to ask once again.
			 		if (mm.equalsIgnoreCase("Y")) {
			 			complete = true;
			 			System.out.println("\nOperation has been cancelled");
			 		}
			 	}else {
			 		System.out.println("\n*** Visitors exceeded ***\n");
			 	}
			}
		}else {
			System.out.println("\n*** Patient has been discharged ***");
			
		}
		}
		}
		return patientfound;
	}

	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the end visit functionality
	//It will return 'true' if the patient record exist
	//-------------------------------------------------------------------------------------------------------
	public static boolean endVisit(ArrayList<Patient> patientList,ArrayList<Visitors> visitorList) { //Parameter Change

		boolean patientfound = false;

		//-------------------
		// Complete code here
		//-------------------
		//for ease: opt 7,complete and checked + interacts with the visitor list to check if visitor exist and whether visitor is on premise. changes status to reflect after ending visitation /
		System.out.print("\n===========REGISTER END OF VISIT==========\n\n");

		
		
		String nricEv = Helper.readString("Enter patient's last four digits of NRIC > ");
		String nameIn =Helper.readString("Enter patient name > ");
		
		int index =0;
		boolean vFound = false;
		
		for (int i=0; i<patientList.size();i++) {
			if(nameIn.equalsIgnoreCase(patientList.get(i).getName())) {
				patientfound = true;
				index = i;
				if(!patientList.get(i).getDateDischarged().equals("")&&patientfound==false){//if patient has been discharged
					//patient has been discharge
					System.out.println("\n*** Patient has been discharged ***\n");
				 
					break;
				}else if(patientList.get(i).getDateDischarged().equals("")) { //if patient is not discharge and have no visitors
					if(nameIn.equalsIgnoreCase(patientList.get(i).getName())&& nricEv.equalsIgnoreCase(patientList.get(i).getNric4())&&patientList.get(i).getVisitorCount()==0){
						System.out.println("\n-----Patient has no visitors.-----");
						break;
					}else if( nricEv.equalsIgnoreCase(patientList.get(i).getNric4())&&patientList.get(i).getVisitorCount()!=0) {//if patient has visitor
						patientList.get(i).display(); //displays the patient record found.
						int vL = Helper.readInt("\nEnter number of visitor(s) leaving >");
						if (vL>patientList.get(i).getVisitorCount()) {
							System.out.println("\n*** Visitor(s) leaving is more than visited ***\n");
							break;
						}else {
							patientList.get(i).setVisitorCount(patientList.get(i).getVisitorCount()-vL);
							int vLCount = 0;
							while(vLCount!=vL) {
								System.out.println("\n--Please enter details of visitor "+(vLCount+1)+" leaving--");
								String ic = Helper.readString("Enter last 4 digit of NRIC of visitor >");
								String nm = Helper.readString("Enter name of visitor >");
							
								for (int x=0; x<visitorList.size();x++) {
				 				
									if(ic.equalsIgnoreCase(visitorList.get(x).getNric()) && nm.equalsIgnoreCase(visitorList.get(x).getName())) {
					 				
										//System.out.println("found."); <-- use for testing
										if(visitorList.get(x).getOnPremise().equalsIgnoreCase("Y")) {
											visitorList.get(x).setOnPremise("N");
											visitorList.get(x).setvisitationP("");
											System.out.println("-----End of visitation successfully registered.-----");
											vLCount++;
											vFound=true;
											break;
										}else if(visitorList.get(x).getOnPremise().equalsIgnoreCase("N")) {
											vLCount++;
											System.out.println("-----Visitor entered not on premise.-----");
										}
					 				
									}else{
										vFound =false;
									}
		
								}
								if(vFound==false) {
									System.out.println("-----Visitor not found, only " + vLCount + " patient/s have left-----");
									vLCount++;
									patientList.get(i).setVisitorCount(patientList.get(i).getVisitorCount()+1);
									break;
								}
							}
							//was here
						}
						
						
						System.out.println("\n*** No of visitor(s) still at ward: " + patientList.get(index).getVisitorCount()+" ***\n");
				}
			}
		}
		}
		return patientfound;
	}

	
	
	//------------------------------------------------------------------------------------------------------------
	//static method that takes in a patient arraylist, a ward array and display an overview of the ward information
	//------------------------------------------------------------------------------------------------------------
	public static void displayWardOverview (ArrayList<Patient> patientList, Ward[] wardArr) {

		//-------------------
		// Complete code here
		//-------------------
		//for ease: opt 8, completed and checked /
		System.out.println(String.format("\n******Ward Overview******\n\n%-6s%-31s%-10s%-15s%-15s","Ward","Description","Bed/Ward","Patients/Ward","Visitors/Ward"));
		System.out.println(String.format("%-6s%-31s%-10s%-15s%-15s","----","-----------","--------","-------------","-------------"));
		int [] wt = {0,0,0,0};
		int [] pt = {0,0,0,0};
		int [] vt = {0,0,0,0};
		
		for(int i=0; i<patientList.size();i++) {
		if(patientList.get(i).getDateDischarged()=="") {
			switch (patientList.get(i).getWard()){
			case "A":
				wt[0]+=1;
				pt[0]+=1;
				vt[0]+=patientList.get(i).getVisitorCount();
				break;
			case "B1":
				wt[1]+=1;
				pt[1]+=1;
				vt[1]+=patientList.get(i).getVisitorCount();
				break;
			case "B2":
				wt[2]+=1;
				pt[2]+=1;
				vt[2]+=patientList.get(i).getVisitorCount();
				break;
			case "C":
				wt[3]+=1;
				pt[3]+=1;
				vt[3]+=patientList.get(i).getVisitorCount();
				break;
			}
		}	
		
		
		}
		for(int i=0; i<wardArr.length;i++) {
			if(wt[i]>0) {
			System.out.println(String.format("%-6s%-33s%-13d%-15d%d",wardArr[i].getWard(),wardArr[i].getDescription(),wt[i],pt[i],vt[i]));
		}
			
		}
		System.out.println(String.format("%75s","--------------------------------------"));
		System.out.println(String.format("%35s%5d%13d%15d","Overview: ",(wt[0]+wt[1]+wt[2]+wt[3]),(pt[0]+pt[1]+pt[2]+pt[3]),(vt[0]+vt[1]+vt[2]+vt[3])));
	}



	//---------------------------------------------------------------------------
	//---------Extra Section for additional function[Visitors Record List]-------
	//---------------------------------------------------------------------------
	//for ease: opt 9,completed and checked :shows list of visitors that have visited patients before and currently, shows the amt of times visited and whether on premise, Next of kin and contact info as well. /
	public static void displayVisitorList(ArrayList<Visitors> visitorList) {
		System.out.println(String.format("\n******Visitor List******\n\n%-8s%-12s%-15s%-22s%-15s%-20s%-15s%-15s%s","NRIC","Name","Contact","Date of Last Visit","Family(Main)","Family(Optional)", "Times Visited","On Premise","Visitation Purpose"));
	
		for(int i=0; i<visitorList.size();i++) {
			System.out.println(String.format("%-8s%-12s%-15s%-25s%-20s%-18s%-10d%-15s%s",visitorList.get(i).getNric(),visitorList.get(i).getName(),visitorList.get(i).getContact(),visitorList.get(i).getDate(),visitorList.get(i).getnok1(),visitorList.get(i).getnok2(),visitorList.get(i).getvisited(),visitorList.get(i).getOnPremise(),visitorList.get(i).getvisitationP()));
		}
	}
	
	//---------------------------------------------------------------------------
	//---------Extra Section for additional function[Payment Related]------------
	//---------------------------------------------------------------------------
		
	//for ease: opt 10,completed and checked + extra payment menu and functions to manage patient's bed charge for days stayed. /
		public static void paymentRelated(ArrayList<Patient> patientList, Ward[] wardArr, double[] paymentOverview,ArrayList<Paid> recordList) {
			String exit = "";
			while(!exit.equalsIgnoreCase("q")) {
				
				
				System.out.print("\n===========PAYMENT MODULE==========\n----------------------------");
				System.out.print(String.format("\n%-5sView Patient's Payables\n%-5sMake Payment\n%-5sOverwrite Debt\n%-5sOverview\n%-5sQuit\n","1.","2.","3.","4.","5." ));
				String opt2 = Helper.readString("\nEnter option 1-5 >");
				
				
				switch(opt2) {
				
				case "1": //checked and completed: show's requested patient's payment record of outstanding and paid, does not show anything if there are not payment related records.
					System.out.print("\n===========PATIENT'S PAYABLES==========\n");
					String inptIC = Helper.readString("\nEnter last 4 digit of NRIC >");
					String inptN = Helper.readString("\nEnter name of patient >");
					System.out.println(String.format("%-7s%-10s%-15s%s", "IC","Name", "Outstanding","Paid"));
					
					for(int i=0; i<patientList.size(); i++) {
						if (inptIC.equalsIgnoreCase(patientList.get(i).getNric4()) && inptN.equalsIgnoreCase(patientList.get(i).getName()) && (!patientList.get(i).getDateDischarged().equalsIgnoreCase(""))) {
							double c = 0.00;
							String [] wardList = {"A","B1","B2","C"};
							for (int x=0; x<wardList.length; x++) {
								if (patientList.get(i).getWard().equalsIgnoreCase(wardList[x])&&(patientList.get(i).getAmtPaid()==0&&patientList.get(i).getAmtOwed()==0)) {
									c = wardArr[x].getBedCharge();
									patientList.get(i).setAmtOwed(patientList.get(i).getDateWarded(), patientList.get(i).getDateDischarged(),"N" ,c );
									}}
								if(inptIC.equalsIgnoreCase(patientList.get(i).getNric4()) && inptN.equalsIgnoreCase(patientList.get(i).getName())){
										System.out.println(String.format("%-7s%-10s$%-14.2f$%.2f",patientList.get(i).getNric4(),patientList.get(i).getName(),patientList.get(i).getAmtOwed(),patientList.get(i).getAmtPaid()));
										
								}

							
						
						}	
				}
				break;
				case "2": //checked and completed: enables completion of payment, shows error if negative number is entered. change and remainder shown after successful payment, does not show anything if patient isnt discharged yet
					
					System.out.print("\n===========PAYMENT REGISTER==========\n");
					inptIC = Helper.readString("\nEnter last 4 digit of NRIC >");
					inptN = Helper.readString("\nEnter name of patient >");
					for(int i=0; i<patientList.size(); i++) {
						if (inptIC.equalsIgnoreCase(patientList.get(i).getNric4()) && inptN.equalsIgnoreCase(patientList.get(i).getName()) && (!patientList.get(i).getDateDischarged().equalsIgnoreCase(""))) {
							double c = 0.00;
							String [] wardList = {"A","B1","B2","C"};
							for (int x=0; x<wardList.length; x++) {
								if (patientList.get(i).getWard().equalsIgnoreCase(wardList[x])&&(patientList.get(i).getAmtOwed()==0&&patientList.get(i).getAmtPaid()==0)) {
									c = wardArr[x].getBedCharge();
									patientList.get(i).setAmtOwed(patientList.get(i).getDateWarded(), patientList.get(i).getDateDischarged(),"N" ,c );
					
								}
							}
							System.out.println(String.format("\n%-7s%-15s%-10.2f%.2f",patientList.get(i).getNric4(),patientList.get(i).getName(),patientList.get(i).getAmtOwed(),patientList.get(i).getAmtPaid()));
							double paymt = Helper.readDouble("Enter amount to be paid >");
							double amtO = patientList.get(i).getAmtOwed();
							if(paymt>=amtO) {
								System.out.print("Amount fully paid. Change of: $"+(paymt-amtO));
								double paid = patientList.get(i).getAmtPaid();
								patientList.get(i).setAmtPaid(amtO+paid);
								patientList.get(i).setAmtOweL(0);
							}else if(paymt<amtO && paymt>0.01) {
								System.out.print("\nPartial payment has been accepted. The outstanding amount left is: $"+(amtO-paymt));
								double paid = patientList.get(i).getAmtPaid();
								patientList.get(i).setAmtPaid(paid+paymt);
								patientList.get(i).setAmtOweL(amtO-paymt);

							}else {
								System.out.println("\nYou cannot pay in negative amounts.");
							}
						}
							
					}
				break;
				case "3":
					//checked and completed: overwrites debt and calculates it, this one does detect if patient has not been discharged yet
					System.out.print("\n===========OVERWRITE DEBT==========\n");
					inptIC = Helper.readString("\nEnter last 4 digit of NRIC >");
					inptN = Helper.readString("\nEnter name of patient >");
					for(int i=0; i<patientList.size(); i++) {
						if (inptIC.equalsIgnoreCase(patientList.get(i).getNric4()) && inptN.equalsIgnoreCase(patientList.get(i).getName()) ) {
							
							if(!patientList.get(i).getDateDischarged().equalsIgnoreCase("")) {
								double c = 0.00;
								String [] wardList = {"A","B1","B2","C"};
								
								for (int x=0; x<wardList.length; x++) {
									if (patientList.get(i).getWard().equalsIgnoreCase(wardList[x])&&(patientList.get(i).getAmtOwed()==0&&patientList.get(i).getAmtPaid()==0)) {
										c = wardArr[x].getBedCharge();
										patientList.get(i).setAmtOwed(patientList.get(i).getDateWarded(), patientList.get(i).getDateDischarged(),"N" ,c );
										
									}
								}
								System.out.println(String.format("\n%-7s%-15s%-10.2f%.2f",patientList.get(i).getNric4(),patientList.get(i).getName(),patientList.get(i).getAmtOwed(),patientList.get(i).getAmtPaid()));
								String conOd = Helper.readString("\nConfirm overwrite remaining debt for patient? (Y/N) >");
								double amtO = patientList.get(i).getAmtOwed();
								double amtP = patientList.get(i).getAmtPaid();
								
								if(conOd.equalsIgnoreCase("Y")) {
									if(amtO!=0) {
										patientList.get(i).setDebtForgiven(amtO);
										patientList.get(i).setAmtOweL(0);
										
										System.out.println("\nPatient's debt has been overwritten.");
									}else if(amtO==0 && amtP!=0) {
										System.out.println("\nPatient selected has already paid in full.");
									}
									
								}else {
									System.out.println("\nOverwrite has been cancelled.");
								}
							}else {
								System.out.println("\nPatient has not been discharged yet.");
								break;
							}
							
							
						}
						
					}
					
				break;
				case "4": //check and completed: shows overview of all payment matters related to patient's that are discharged 
					System.out.print("\n===========ACCOUNT RECIVABLES OVERVIEW==========\n");
					System.out.println(String.format("\n%-10s%-10s%-15s%-15s%s", "NRIC","Name","Days Stayed","Outstanding", "Paid", "Patient's Arrears" , "Earned"));
					
					paymentOverview[0]=0;
					paymentOverview[1]=0;
					
					for(int i=0; i<patientList.size(); i++) {
						double c = 0.00;
						String [] wardList = {"A","B1","B2","C"};
						
						if(patientList.get(i).getDateDischarged()!="") {
							if(patientList.get(i).getDebtForgiven()==0) {
								for (int x=0; x<wardList.length; x++) {
									if (patientList.get(i).getWard().equalsIgnoreCase(wardList[x]) && (patientList.get(i).getAmtPaid()==0&&patientList.get(i).getAmtOwed()==0)) {
										c = wardArr[x].getBedCharge();
										patientList.get(i).setAmtOwed(patientList.get(i).getDateWarded(), patientList.get(i).getDateDischarged(),"N" ,c ); /*allow the method to run first so that the days stayed will also be updated */
									}}
								System.out.println(String.format("%-10s%-10s%-15d$%-14.2f$%.2f",patientList.get(i).getNric4(),patientList.get(i).getName(),patientList.get(i).getDaysS(),patientList.get(i).getAmtOwed(),patientList.get(i).getAmtPaid()));
								paymentOverview[0]+=patientList.get(i).getAmtOwed();
								paymentOverview[1]+=patientList.get(i).getAmtPaid();
							}else {
								System.out.println(String.format("%-10s%-10s%-15d$%-14.2f$%.2f",patientList.get(i).getNric4(),patientList.get(i).getName(),patientList.get(i).getDaysS(),patientList.get(i).getAmtOwed(),patientList.get(i).getAmtPaid()));
								paymentOverview[1]+=patientList.get(i).getAmtPaid(); //before GA due not update with this,payment did not update without this line. 
								paymentOverview[2]+=patientList.get(i).getDebtForgiven();
							}
							
						}else if(recordList.size()>0) {
							for(int a =0; a<recordList.size();a++) {
								System.out.println(String.format("%-10s%-10s%-15d$%-14s$%.2f",recordList.get(a).getNric(),recordList.get(a).getName(),recordList.get(a).getDaysS(),"0.00",recordList.get(a).getAmtPaid()));
								paymentOverview[1]+=recordList.get(a).getAmtPaid();
								paymentOverview[2]+=recordList.get(a).getDebtF();
								
							}
							break;
						}
			}
				System.out.println("\n\nPatient's Arrears: $"+paymentOverview[0]+" | Amount Earned: $" +paymentOverview[1] + " | Bad Debt: $" + paymentOverview[2]);
				break;
				case "5": //checked: allows to exit from payment module.
					exit ="q";
				break;
				}
			
			}
			
		}
}