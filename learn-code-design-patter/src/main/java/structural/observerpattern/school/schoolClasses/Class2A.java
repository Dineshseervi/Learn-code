package main.java.structural.observerpattern.school.schoolClasses;

import main.java.structural.observerpattern.IObserver;
import main.java.structural.observerpattern.ISubject;
import main.java.structural.observerpattern.school.NotifyDepartment;

public class Class2A implements IObserver {
    private String message;

    public Class2A(ISubject subject) {
        subject.register(this);
    }

    @Override
    public void update(ISubject subject) {
        if(subject instanceof NotifyDepartment)
        {
            NotifyDepartment notifyDepartment=(NotifyDepartment) subject;
            this.message=notifyDepartment.getMessage();
            display();
        }

    }

    @Override
    public void display() {
        System.out.println("Message "+ Class2A.class.getName()+" message :"+message);
    }
}
