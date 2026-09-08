package org.example;

public enum Priority {
    High(1) , MEDIUM(2),LOW(3);

    private int rank;
    Priority(int rank){
        this.rank=rank;
    }
    public int getRank(){
        return rank;
    }
}
