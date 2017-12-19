package com.airtel.enums;

public enum BannedDictionary {
    ABC("abc");

    private String name;

    BannedDictionary(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
