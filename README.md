# Patient/Ward Management System
As you can see from the title of this repository this is one of the school projects I work on.

Below you can see the details for this project.

<hr>

## Task
#### Create a system on eclipse that allows that user to view all ward/patient information, admit/discharge/remove patient, register and end visits, I have added payment related functions too.
I was provided the skeleton base with the base loop for the options without any functionality, I was also provided some details to include like some mock patient's details and also ward information.

## Features
The features in the final system produced are:<br>
1.  View all Ward Info<br>                    
2.  Display Patient List[Extra: added a display for the amount patient owed and have paid]<br>                  
3.  Admit Patient<br>
    - user does this by inputing patient's IC's first four digits,name, ward, bed,date warded, will reject if bed is occupied already/or does not exist(bug found: system does not display proper error msg for bed does not exist)<br>                         
4.  Discharge Patient<br>
    - user does this by inputing patient's IC and Name that matches and exist in the system records,date discharged, system will kick visitors off from visiting and (extra)calculate charges<br>      
5.  Remove Patient<br>
    - user does this by inputing patient's IC and Name and confirming that they want to delete the patient's records(will not delete if patient have not been discharged and paid their dues fully)<br>
6.  Register Visit<br>
    - user does this by inputing patient's IC and Name, number of visitors(cannot exceed max visitors includes existing visitors), visitor's IC and Name(if existing records exist, will be prompted if changes need to be made or continue with existing records.)<br>                        
7.  End Visit<br>
    - user does this by inputing patient's IC and Name along side with the amount of visitor's ending their visit and their IC and Names<br>                             
8.  Display Ward Overview<br>        
9.  Visitor List<br>                
10. Payment Related[Extra]<br>
    - View Patient's Payables<br>
        -> user does this by inputing patient's IC and Name that have existing payment owing<br>
    - Make Payment<br>
        -> user does this by inputing patient's IC and Name and amount being paid(shows what is the remaining payment owed)<br>
    - Overwrite Debt<br>
        -> user does this by inputing patient's IC and Name and confirming to overwrite the debt of patient(clears the amount of owing, wont count as patient paying their debt but counts as a bad debt)<br>
    - Overview<br>

<hr>

## Screenshots

### Final Product
<table>
  <tr>
    <td>
    <!--<img src="https://your-image-url.type" width="100" height="100">-->
  <img src="https://github.com/BlackNet13/ward_Management/assets/123053395/f063d449-3f50-4425-9bb3-2c08978307e8" height ="150"/>
</td>
    <td>      
      <img src="https://github.com/BlackNet13/ward_Management/assets/123053395/affc1c28-c89a-49f8-8160-b8f84edce4e1" height ="150"/>
    </td>
    </tr>
  <tr>
    <td>Main Menu</td> 
    <td>Ward Info</td>
  </tr>
</table>

<table>
  <tr>
    <td>
      
  <img src="https://github.com/BlackNet13/ward_Management/assets/123053395/76b24ae9-e096-4f8a-a8fd-673780beafac" height ="200"/>

</td>
    <td>      
      <img src="https://github.com/BlackNet13/ward_Management/assets/123053395/5d581007-bf8d-427a-a77b-53fede5e6622" height ="200"/>
    </td>
    </tr>
  <tr>
    <td>Patient List</td> 
    <td>Ward Overview</td>
  </tr>
</table>
<table>
  <tr>
    <td>   
      <img src="https://github.com/BlackNet13/ward_Management/assets/123053395/2ced98b1-8b2c-48ec-a0a4-6ede409e2a56" height ="200"/>
    </td>
  </tr>
  <tr>
    <td>
      Visitor  List
    </td>
  </tr>
</table>
<table>
  <tr>
    <td>   
      <img src="https://github.com/BlackNet13/ward_Management/assets/123053395/6bbc9121-0555-4c50-97ef-602281cf7ce7" height ="200"/>
    </td>
  </tr>
  <tr>
    <td>
      Overview(payment)
    </td>
  </tr>
</table>



## 🛠 Skills/Tools
Java, Eclipse, Github for version control.

## Lessons Learned
- It was a good experience to comment each section so that you know which section of the code is for what.
- It was also a good experience to experiment and add new features as I was allowed free range on the design and the add on functionality 

