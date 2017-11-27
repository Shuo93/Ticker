package com.ticker.desktop.model;

public class CheckBoxItem {

    private String id;

    private String text;

    private String value;

    private boolean isChecked;

    public CheckBoxItem(String id, String text, String value, boolean isChecked) {
        this.id = id;
        this.text = text;
        this.value = value;
        this.isChecked = isChecked;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
