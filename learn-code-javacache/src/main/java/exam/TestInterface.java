package main.java.exam;

public interface TestInterface {

    public String name="a";
    //private String email;

    String getAddress();
}

class TestStudentAddress implements TestInterface
{

    @Override
    public String getAddress() {
       // TestInterface.name="cc";
        return null;
    }
}
