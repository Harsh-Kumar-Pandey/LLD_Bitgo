package org.example;

public class EmailChannel implements NotificationChannel {
    @Override
    public boolean send(NotificationRequest request){
        System.out.println("sending notification through email"+request.content);
        return true;
    }

    @Override
    public NotificationType getType() {
        return NotificationType.EMAIL;
    }
}
