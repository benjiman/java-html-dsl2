package com.benjiweber.html.tags;

import com.benjiweber.typeref.Parameters;

import static com.benjiweber.html.HtmlDsl.build;

public class P extends Tag implements Content {
    public interface Dsl {

        default P p(String literal) {
            return p(new Literal(literal));
        }
        default <T extends Tag & Content> P p(T... children) {
            return build($->{}, children);
        }
        default <T extends Tag & Content> P p(Parameters<P> params, T... children) {
            return build(params, children);
        }
        default P p(Parameters<P> params, String literal) {
            return build(params, new Literal(literal) );
        }
    }

}