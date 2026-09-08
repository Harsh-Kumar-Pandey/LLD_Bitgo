package org.example;

import java.util.HashMap;
import java.util.Map;

public class ChannelFactory {
    Map<NotificationType, NotificationChannel> channels=new HashMap<>();
    public void registerChannel(NotificationChannel channel){
        channels.put(channel.getType(),channel);
    }

    public NotificationChannel getNotificationChannel(NotificationType type){
        return channels.get(type);
    }
}
