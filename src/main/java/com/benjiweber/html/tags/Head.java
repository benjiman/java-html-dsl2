package com.benjiweber.html.tags;

import com.benjiweber.typeref.Parameters;

import static com.benjiweber.html.HtmlDsl.build;

public class Head extends Tag {

    public interface Dsl {
        default Head head(Tag... children) {
            return build($->{},children);
        }
        default Head head(Parameters<Head> params, Tag... children) {
            return build(params,children);
        }
    }
}