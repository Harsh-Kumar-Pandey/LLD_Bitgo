package org.example.InMemoryDB;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        RateLimitingStrategy rateLimiter=new TokenBucketRateLimiting(10,4);
        System.out.println("Request 1 for Allowed: for user 1: "+rateLimiter.isAllowed(1));
        System.out.println("Request 2 for Allowed: for user 2: "+rateLimiter.isAllowed(2));
        System.out.println("Request 3 for Allowed: for user 3: "+rateLimiter.isAllowed(3));
        for (int i = 1; i <= 50; i++) {
            boolean allowed = rateLimiter.isAllowed(1);
            System.out.println("Request " + i + ": " + (allowed ? "✅ ALLOWED" : "❌ BLOCKED (429)"));
        }

        System.out.println("\n--- Sleeping for 2 seconds to refill 2 tokens ---");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Request 5: " + (rateLimiter.isAllowed(1) ? "✅ ALLOWED" : "❌ BLOCKED"));
        System.out.println("Request 6: " + (rateLimiter.isAllowed(1) ? "✅ ALLOWED" : "❌ BLOCKED"));
        System.out.println("Request 7: " + (rateLimiter.isAllowed(1) ? "✅ ALLOWED" : "❌ BLOCKED"));
    }
}