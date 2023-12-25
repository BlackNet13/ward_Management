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
3.  Admit Patient(user does this by inputing patient's IC's first four digits,name, ward, bed,date warded, will reject if bed is occupied already/or does not exist(bug found: system does not display proper error msg for bed does not exist))<br>                         
4.  Discharge Patient(user does this by inputing patient's IC and Name that matches and exist in the system records,date discharged, system will kick visitors off from visiting and (extra)calculate charges)<br>                     
5.  Remove Patient(user does this by inputing patient's IC and Name and confirming that they want to delete the patient's records(will not delete if patient have not been discharged and paid their dues fully))<br>                        
6.  Register Visit<br>                        
7.  End Visit<br>                             
8.  Display Ward Overview<br>        
9.  Visitor List<br>                
10. Payment Related<br>
    - View Patient's Payables<br>
    - Make Payment<br>
    - Overwrite Debt<br>
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

      
      <img src="https://github.com/BlackNet13/C206_CaseStudy/assets/123053395/d0b05b04-da5f-4fa8-ae60-4e88a8d3aaae" height ="200"/>
    </td>
    </tr>
  <tr>
    <td>Patient List</td> 
    <td>Student Menu</td>
  </tr>
</table>
<table>
  <tr>
    <td>
      <img src="https://github.com/BlackNet13/C206_CaseStudy/assets/123053395/61662d72-1545-4834-a162-afbc146768f0" height ="200"/>
    </td>
  </tr>
  <tr>
    <td>
      Burn Down Chart
    </td>
  </tr>
</table>


## 🛠 Skills/Tools
Java, Eclipse, Github for version control, project cloning and merging.

## Lessons Learned
- It was a good idea to establish the flow of the system before beginning a group project, I implemented it through the code itself so that members could see it the first thing they get into the main code body.
- Discord pinning function works very well to keep our shared files for documentation always available for any team member to access them when needed.
- Some merge errors when working as a team are better fixed when in person as the error consist of code being undone or overwriten by some of the undesired code, I believe the difficulty was due to this being our first ever agile project.
- Junit was tough as when we first implemented the main code, the code was built more for user input and thus when doing up the junit we had to modify the code so that it have a workaround that can work with both the user input and the junit itself.
- Reading other members code and understanding it is very important in order for some parts of the code to work alongside with other parts of the code
