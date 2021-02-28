package com.benjiweber.html.tags;

import org.apache.commons.lang.StringEscapeUtils;

public class Literal extends Tag implements Content {
    public Literal(String literal) {
        this.innerText = literal;
    }

    @Override
    public String toString() {
        return StringEscapeUtils.escapeHtml(innerText);
    }
}