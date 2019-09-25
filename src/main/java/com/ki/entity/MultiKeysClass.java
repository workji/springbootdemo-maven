package com.ki.entity;

import java.io.Serializable;

public class MultiKeysClass implements Serializable {

    private String key1;
    private String key2;
    private String key3;

    public MultiKeysClass(){}

    public MultiKeysClass(String key1, String key2, String key3){
        this.key1 = key1;
        this.key2 = key2;
        this.key3 = key3;
    }

    @Override
    public int hashCode(){
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((key1 == null) ? 0 : key1.hashCode());
        result = PRIME * result + ((key2 == null) ? 0 : key2.hashCode());
        result = PRIME * result + ((key3 == null) ? 0 : key3.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final MultiKeysClass other = (MultiKeysClass) obj;
        if (key1 == null) {
            if (other.key1 != null) {
                return false;
            }
        } else if (!key1.equals(other.key1)) {
            return false;
        }

        if (key2 == null) {
            if (other.key2 != null) {
                return false;
            }
        } else if (!key2.equals(other.key2)) {
            return false;
        }

        if (key3 == null) {
            if (other.key3 != null) {
                return false;
            }
        } else if (!key3.equals(other.key3)) {
            return false;
        }

        return true;
    }

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
}
