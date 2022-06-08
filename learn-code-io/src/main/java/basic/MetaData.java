package main.java.basic;

import main.java.basic.readwrite.Address;
import main.java.basic.readwrite.HomeAddress;
import main.java.basic.readwrite.RootAddress;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MetaData {

    public static void main(String[] args) {
        Address address1=new Address();
        address1.setNumber(1);
        address1.getAddress().add("nameA");

        Address address2=new Address();
        address2.setNumber(2);
        address2.getAddress().add("nameB");

        HomeAddress homeAddress=new HomeAddress();
        homeAddress.setName("HomeAddressA");
        homeAddress.setNumber(3);

        HomeAddress homeAddress2=new HomeAddress();
        homeAddress2.setName("HomeAddressB");
        homeAddress2.setNumber(4);


        List<RootAddress> rootAddressesList=new ArrayList<>();
        rootAddressesList.add(address1);
        rootAddressesList.add(address2);
        rootAddressesList.add(homeAddress);
        rootAddressesList.add(homeAddress2);

        System.out.println("abcd");rootAddressesList.add(null);
        rootAddressesList.remove(homeAddress2);
        rootAddressesList.add(null);
        rootAddressesList.add(null);
        rootAddressesList.add(null);
        rootAddressesList.add(null);
        System.out.println("after remove");
    }

    private void addAddressA(List<String> address)
    {
        address.add("AA");
    }

    private void addAddressB(List<String> address)
    {
        address.add("BB");
    }

    private void addAddressC(List<String> address)
    {
        address.add("CC");
    }
}
