package com.benjiweber.html.tags;

import com.benjiweber.typeref.Parameters;

import static com.benjiweber.html.HtmlDsl.build;

public class Title extends Tag {
    public interface Dsl {
        default Title title(String literal) {
            return build($->{},new Literal(literal));
        }
    }

}