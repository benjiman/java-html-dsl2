package com.benjiweber.html.tags;

import java.util.List;
import java.util.stream.Stream;

import static com.benjiweber.html.format.Formatter.tidy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Tag {
    public String style;
    public String cssClass;
    public List<Tag> children = List.of();
    public String innerText = "";

    @Override
    public String toString() {
        return "<" + name() + attrString() + ifNoChildren("/") + ">" +
                children.stream().map(Object::toString).collect(joining())
                + ifChildren("</" + name() + ">");
    }

    private String ifNoChildren(String s) {
        return children.size() > 0 ? "" : s;
    }

    private String ifChildren(String s) {
        return children.size() > 0 ? s : "";
    }

    public String formatted() {
        return tidy(toString()).trim();
    }

    private String attrString() {
        return attrs().stream().map(attr -> " " + attr.key() + "=\"" + attr.value() + "\"").collect(joining());
    }

    public String name() {
        return getClass().getSimpleName().toLowerCase();
    }
    public List<Attr> attrs() {
        return thoseWithValues(
                new Attr("style", style),
                new Attr("class", cssClass)
        )
                .collect(toList());
    }

    public static Stream<Attr> thoseWithValues(Attr... attrs) {
        return Stream.of(attrs).filter(Attr::hasValue);
    }
}