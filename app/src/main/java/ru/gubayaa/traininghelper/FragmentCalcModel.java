package ru.gubayaa.traininghelper;

public class FragmentCalcModel {

   double getBMI(double height, double weight) {
       if (height == 0) {return 0;}

       double bmi;
       bmi = weight / ( height * height / 10000);
       return bmi;
   }

   double getPFC(String sex, int age, double weight, double height) {
       double calories;
       switch(sex) {
           case "Женщина":
               calories = (10 * weight + 6.25 * height - 5 * age - 161) * 1.2;
               break;
           case "Мужчина":
               calories = (10 * weight + 6.25 * height - 5 * age + 5) * 1.2;
               break;
           default:
               calories = 0;
       }
       return calories;
   }
}
