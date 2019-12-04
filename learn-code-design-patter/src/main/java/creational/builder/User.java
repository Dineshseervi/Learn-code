package main.java.creational.builder;

public class User {
    private String name;
    private String empId;
    private int age;
    private String address;
    private String aadharCardNumber;
    private String phone;

    public User(UserBuilder userBuilder) {
        this.name = userBuilder.name;
        this.empId = userBuilder.empId;
        this.age = userBuilder.age;
        this.phone = userBuilder.phone;
        this.address = userBuilder.address;
        this.aadharCardNumber = userBuilder.aadharCardNumber;
    }


    public String getName() {
        return name;
    }

    public String getEmpId() {
        return empId;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getAadharCardNumber() {
        return aadharCardNumber;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", empId='" + empId + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", aadharCardNumber='" + aadharCardNumber + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public static class UserBuilder {
        private String name;
        private String empId;
        private int age;
        private String address;
        private String aadharCardNumber;
        private String phone;

        public UserBuilder(String name, String empId) {
            this.name = name;
            this.empId = empId;

        }

        public UserBuilder age(int age)
        {
            this.age=age;
            return this;
        }

        public UserBuilder address(String  address)
        {
            this.address=address;
            return this;
        }

        public UserBuilder phone(String  phone)
        {
            this.phone=phone;
            return this;
        }

        public UserBuilder aadharCardNumber(String  aadharCardNumber)
        {
            this.aadharCardNumber=aadharCardNumber;
            return this;
        }

        public User build()
        {
            User user=new User(this);

            return  user;
        }

    }
}
