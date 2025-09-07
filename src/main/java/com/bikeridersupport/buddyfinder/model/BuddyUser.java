package com.bikeridersupport.buddyfinder.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "buddy")
public class BuddyUser extends BaseUser{
    Address shopAddress;
    Booking currentBooking;
    List<Booking> bookingHistory;

    BuddyStatus currentStatus = BuddyStatus.CLOSED;

    Role role = Role.BUDDY;
}
