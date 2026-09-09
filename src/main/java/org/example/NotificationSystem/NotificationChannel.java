package org.example.NotificationSystem;

public interface NotificationChannel {
    public boolean send(NotificationRequest request);
    NotificationType getType();
}
