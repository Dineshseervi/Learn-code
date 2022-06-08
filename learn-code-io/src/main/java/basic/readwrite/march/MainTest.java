package main.java.basic.readwrite.march;

public class MainTest {
    public static void main(String[] args) {
        SubjectA subjectA=new SubjectA();
        subjectA.setName("subjectA");
        subjectA.setPrice(250);
        Object object=subjectA;
        SubjectB subjectB=(SubjectB)object;


    }
}
