package org.example.NotificationSystem;

public class SmsChannel implements NotificationChannel {

    @Override
    public boolean send(NotificationRequest request){
        System.out.println("sending notification through sms"+request.content);
        return true;
    }

    @Override
    public NotificationType getType() {
        return NotificationType.SMS;
    }
}
