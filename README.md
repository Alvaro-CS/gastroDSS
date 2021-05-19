# GastroDSS: DECISSION SUPPORT SYSTEM FOR GASTROINTESTINAL DISEASES
## USER MANUAL

We created a Graphical User Interface in Netbeans using JavaFx. We will give an explanation of the interface and its functionalities. If you want to execute the program directly from CLIPS, you should uncomment the symptoms´ deffacts from the project2.clp file inside the NetBeans project. However, the original CLIPS project that is ready to be loaded and executed is available in the GitHub repository.

In the GUI, the first window is the Welcome screen, where the doctor should introduce the name of the patient, the gender and date of birth.

<div align="center">
<img src="https://github.com/Alvaro-CS/gastroDSS/blob/master/images/image1.png" width= 250" /><br/><br/></div>

Once the personal information of the patient is introduced, the doctor will click on “OK” and start asking the patient for the symptoms and introduce them. He or she should click next in every window to continue once the symptoms have been introduced. In the last symptoms window, the doctor should click “results” to get the possible diagnoses.
                                                                                           
In the last window, the doctor will get the possible diagnoses for the patient ranked by probabilities. The probabilities can be graphically observed with the progress bars and also are indicated as the numerical value. Additionally, if a certain probability is exceeded regarding the most dangerous diseases, the name and percentage of the disease will be marked in red, to warn the doctor. This percentage is different for each of the dangerous diseases: >50% for cholelithiasis, >42% hepatic cirrhosis, >34% for pancreatitis and >25% for stomach cancer. This classification of “most dangerous diseases” was performed with the help of a Medical Professional.  
                                                                                           
<div align="center">
<img src="https://github.com/Alvaro-CS/gastroDSS/blob/master/images/image2.png" width= 250" /><br/><br/></div>

The doctor is able to save this information of the patient in a file by clicking on “Save records”. This will open a window where he/she should introduce the name and the location to store this file. The information will be added to this file, including the date of the record, the personal information of the patient, the recorded symptoms, and the possible diagnoses with their percentages. 

Once the doctor is done with the patient, he or she may click on “New Patient” and it will go back to the “Welcome window” view.

<div align="center">
<img src="https://github.com/Alvaro-CS/gastroDSS/blob/master/images/image3.png" width= 250" /><br/><br/></div

