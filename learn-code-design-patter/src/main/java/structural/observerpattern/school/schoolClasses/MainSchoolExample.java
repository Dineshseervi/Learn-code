package main.java.structural.observerpattern.school.schoolClasses;

import main.java.structural.observerpattern.school.NotifyDepartment;

public class MainSchoolExample
{


    public static void main(String[] args) {
        NotifyDepartment notifyDepartment=new NotifyDepartment();

        Class1A class1A=new Class1A(notifyDepartment);
        Class2A class2A=new Class2A(notifyDepartment);
        Class3A class3A=new Class3A(notifyDepartment);

        notifyDepartment.communicationMessage("today lunch at 12:30 pm");
    }

}
