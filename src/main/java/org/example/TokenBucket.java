package org.example;

public class TokenBucket {
    long capacity;
    long refillRatePerSecond;
    double availableTokens;
    long lastRefillTime;

    TokenBucket(long capacity,long refillRatePerSecond){
        this.capacity=capacity;
        this.refillRatePerSecond=refillRatePerSecond;
    }

    public boolean tryConsume(){
        refill();

        if(availableTokens>=1){
            availableTokens=availableTokens-1;
            return true;
        }
        return false;

    }

    private void refill(){
        long now= System.currentTimeMillis();
        double elapsedTime=(now-lastRefillTime)/1000.0;
        availableTokens=Math.min(availableTokens+(elapsedTime*refillRatePerSecond),capacity);
        lastRefillTime=now;
    }

}
