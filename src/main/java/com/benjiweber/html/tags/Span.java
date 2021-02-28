package com.benjiweber.html.tags;

import com.benjiweber.typeref.Parameters;

import static com.benjiweber.html.HtmlDsl.build;

public class Span extends Tag implements Content {
    public interface Dsl {

        default Span span(String content) {
            return build($->{},new Literal(content));
        }
        default Span span(Tag... children) {
            return build($->{},children);
        }
        default Span span(Parameters<Span> params, String content) {
            return span(params,new Literal(content));
        }
        default Span span(Parameters<Span> params, Tag... children) {
            return build(params,children);
        }
    }
}