package com.bikeridersupport.buddyfinder.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "users")
public class User extends BaseUser{

    public User() {
        this.setRole(Role.APP_USER);
        this.setUserMembership(UserMembership.NORMAL);
    }
}
