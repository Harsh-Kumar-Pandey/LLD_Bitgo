package org.example;

import java.util.concurrent.PriorityBlockingQueue;

public class NotificationService {

    public ChannelFactory factory;
    public PriorityBlockingQueue<NotificationRequest> requests;
    private int MAX_RETIRES=3;

    public NotificationService(ChannelFactory factory){
        this.factory=factory;
        this.requests=new PriorityBlockingQueue<>();
    }

    public void enqueueNotification(NotificationRequest request){
        requests.offer(request);
        System.out.println("notification added");
    }

    public void proccessNotification(){
        NotificationRequest request=requests.poll();
        if(request==null) return;

        NotificationChannel channel=factory.getNotificationChannel(request.type);
        boolean success=false;
        try{
           success= channel.send(request);

        }catch (Exception e){
            System.out.println("Some error in sending notification");
        }

        if(!success){
            request.retryCount++;
            if(request.retryCount<MAX_RETIRES){
                requests.add(request);
            }else{
                System.out.println("Discarding notificaion after multiple retireies");
            }
        }
    }

}
