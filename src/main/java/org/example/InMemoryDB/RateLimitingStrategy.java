package org.example.InMemoryDB;

public interface RateLimitingStrategy {
    public boolean isAllowed(int id);
}
