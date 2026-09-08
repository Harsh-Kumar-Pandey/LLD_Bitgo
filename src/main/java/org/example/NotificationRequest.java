package org.example;

public class NotificationRequest implements Comparable<NotificationRequest> {
   public int requestId;
    public  int recipientId;
    public String content;
    public  NotificationType type;
    public  Priority priority;
    public  int retryCount;

    public NotificationRequest(int requestId, int recipientId, String content, NotificationType type, Priority priority){
        this.requestId=requestId;
        this.recipientId=recipientId;
        this.content=content;
        this.type=type;
        this.priority=priority;
    }

    @Override
    public int compareTo(NotificationRequest other){
        return Integer.compare(priority.getRank(),other.priority.getRank());
    }

}
