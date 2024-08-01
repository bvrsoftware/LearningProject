package com.bvr.LearningProject.enums;

public enum UserRoles {
    ADMIN("ADMIN"),
    USER("USER");

    private final String name;
    UserRoles(String name){
        this.name=name;
    }

    public String getName() {
        return this.name;
    }
}
