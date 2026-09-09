package org.example.InMemoryDB;

import java.util.concurrent.ConcurrentHashMap;

public class TokenBucketRateLimiting implements RateLimitingStrategy {
    long capacity;
    long refillRatePerSecond;

    ConcurrentHashMap<Integer, TokenBucket> users;
    TokenBucketRateLimiting(long capacity,long refillRatePerSecond){
        this.capacity=capacity;
        this.refillRatePerSecond=refillRatePerSecond;
        this.users=new ConcurrentHashMap<>();
    }

    @Override
    public boolean isAllowed(int id){

        if(!users.containsKey(id)){
            users.put(id,new TokenBucket(capacity,refillRatePerSecond));
        }
        return users.get(id).tryConsume();
    }
}
