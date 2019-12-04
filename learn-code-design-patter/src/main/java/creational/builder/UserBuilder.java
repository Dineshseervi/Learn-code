package main.java.creational.builder;

public class UserBuilder {

    public static void main(String[] args) {
        User user1 = new User.UserBuilder("Lokesh", "53271")
                .age(30)
                .phone("1234567")
                .address("Fake address 1234")
                .build();

        System.out.println(user1);

    }
}
