package org.example;

import org.springframework.stereotype.Component;

@Component
public class UserService {

    NotificationService notific;

    public UserService(NotificationService notific) {
        this.notific = notific;
    }
}