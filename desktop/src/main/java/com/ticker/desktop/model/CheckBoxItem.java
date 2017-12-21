package com.ticker.desktop.model;

public class CheckBoxItem {

    private String id;

    private String text;

    private Object value;

    private boolean isChecked;

    public CheckBoxItem(String id, String text, Object value, boolean isChecked) {
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

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
