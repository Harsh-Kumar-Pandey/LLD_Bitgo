package org.example;

public interface RateLimitingStrategy {
    public boolean isAllowed(int id);
}
