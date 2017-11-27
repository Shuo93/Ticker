package com.ticker.desktop.model.enums;

public enum Type {
    BOX("box"),
    POCKET("pocket"),
    BOOK("book"),
    LABEL("label");

    private String type;

    Type(String type) {
        this.type = type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
