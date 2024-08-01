package com.bvr.LearningProject.enums;

public enum Authorities {
    VIEW_ACCOUNT("VIEW_ACCOUNT"),
    VIEW_BALANCE("VIEW_BALANCE"),
    VIEW_LOANS("VIEW_LOANS"),
    VIEW_CARDS("VIEW_CARDS");
    private final String name;

    Authorities(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
