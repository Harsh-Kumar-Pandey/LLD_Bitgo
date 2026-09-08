package org.example;

public interface NotificationChannel {
    public boolean send(NotificationRequest request);
    NotificationType getType();
}
