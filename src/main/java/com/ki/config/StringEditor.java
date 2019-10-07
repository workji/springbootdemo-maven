package com.ki.config;

import java.beans.PropertyEditorSupport;

public class StringEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        return "> " + super.getAsText() + " <";
    }

    public void setAsText(String text) throws java.lang.IllegalArgumentException {
        System.out.println("Input:" + text);
        setValue("Go" + text + "Go");
    }
}
