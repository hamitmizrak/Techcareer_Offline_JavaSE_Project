package com.hamitmizrak.roles;

public enum ERoles {
    ADMIN(1,"admin"),WRITER(2,"writer"),USER(3,"user");

    // Key
    private final Integer key;

    // Value
    private final String value;

    // CONSTRUCTOR
    private ERoles(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    // GETTER
    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
