package com.benjiweber.html.tags;

import java.util.List;
import java.util.stream.Stream;

import static com.benjiweber.html.StreamUtils.unchecked;
import static java.util.stream.Collectors.toList;

public class ReflectiveTag extends Tag {
    public List<Attr> attrs() {
        return Stream.concat(
                super.attrs().stream(),
                Stream.of(getClass().getDeclaredFields())
                        .filter(field -> !field.getType().isAssignableFrom(List.class))
                        .peek(field -> field.setAccessible(true))
                        .map(field -> unchecked(() -> new Attr(field.getName(), field.get(this))))
                        .filter(Attr::hasValue)
        ).collect(toList());
    }
}