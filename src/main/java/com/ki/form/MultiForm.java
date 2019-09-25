package com.ki.form;

import javax.validation.constraints.NotNull;

public class MultiForm {
    @NotNull
    private String key1;
    @NotNull
    private String key2;
    @NotNull
    private String key3;
    @NotNull
    private String value;

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    public String getKey2() {
        return key2;
    }

    public void setKey2(String key2) {
        this.key2 = key2;
    }

    public String getKey3() {
        return key3;
    }

    public void setKey3(String key3) {
        this.key3 = key3;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
