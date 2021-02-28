package com.benjiweber.html.tags;

import com.benjiweber.typeref.Parameters;

import java.util.stream.Stream;

import static com.benjiweber.html.HtmlDsl.build;
import static com.benjiweber.html.StreamUtils.tagArrayOf;

public class Body extends Tag {
    public interface Dsl {

        default Body body(Stream<Tag> children) {
            return body(tagArrayOf(children));
        }
        default Body body(Tag... children) {
            return build($->{},children);
        }
        default Body body(Parameters<Body> params, Tag... children) {
            return build(params,children);
        }
    }
}