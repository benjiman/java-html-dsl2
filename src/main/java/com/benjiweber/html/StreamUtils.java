package com.benjiweber.html;

import com.benjiweber.html.tags.Tag;

import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamUtils {

    public interface ExceptionalSupplier<R,E extends Exception> {
        R get() throws E;
    }
    public static <R,E extends Exception> R unchecked(ExceptionalSupplier<R,E> f) {
        try {
            return f.get();
        } catch (RuntimeException | Error e) {
            throw e;
        } catch ( Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Tag[] tagArrayOf(Stream<Tag> children) {
        return children.collect(toList()).toArray(new Tag[0]);
    }

    public static <T> T[] array(T... ts) {
        return ts;
    }
}
