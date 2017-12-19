package com.airtel.enums;

public enum NegativeDictionary {
    FOOL("fool", -2);

    private String name;
    private Integer score;

    NegativeDictionary(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
