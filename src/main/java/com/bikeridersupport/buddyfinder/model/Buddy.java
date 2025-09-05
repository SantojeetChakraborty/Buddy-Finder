package com.bikeridersupport.buddyfinder.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "buddy")
public class Buddy extends BaseUser{
    public Buddy() {
        this.setRole(Role.BUDDY);
        this.setBuddyStatus(BuddyStatus.OPEN);
    }
}
