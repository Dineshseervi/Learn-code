package com.learn.system.online.hotel.booking.model;

import sun.jvm.hotspot.debugger.Address;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class HotelBooking {


}

class User {
    private String userName;
    private int age;
    private String mailId;
    private long phone;
    private String gender;
    private Address1 address1;
}
class City{
    private String cityId;
    private String state;
    private String country;
}

enum HotelType{
    LUX,STAR_5,STAR_4, STAR_3, STAR_2
}

enum RoomType{
    DELUX, SUPER_DELUX
}

enum RoomStatus{
    BOOKED,AVAILABLE
}
class Room{
    private String roomId;
    private String hotelId;
    private String roomNumber;
    private RoomType roomType;
    private int squaArea;
    private int level;
    private RoomStatus roomStatus;
}

class Hotel{
    private String Name;
    private Address1 address;
    private long contact;
    private HotelType hotelType;
    private Facilities facilities;
    private Set<Room> rooms;
}

class Address1{
    //..
}


enum Facility
{
    LIFT,POWER_BACKP,POOL,BAR,BREAK_FAST,LUNCH,DINNER,PLAY_AREA
}

class Facilities{
    List<String> facilitiesCollection;
}


class Booking{
    private String bookinngId;
    private String userId;
    private String hotelId;
    private List<String> roomIds;
    private Date from;
    private Date bookTill;
    private int numberOfRoom;
    private int numberOfGuest;
    private RoomType roomType;
    private Payment payment;



}
class Payment{
    String paymentID;
    String bookingId;
    Date paymetDate;
    double amount;
    private PaymentStatus paymentStatus;
    private String bookingMode;
    private String bookingStatus;
    private String discounntCoupons;

}

enum PaymentStatus{
    BOOKED,PAYMENT_FAILED,
}

