package com.benjiweber.html.tags;
public record Attr<T> (String key, T value) {
    public boolean hasValue() {
        return value != null;
    }
}