package com.benjiweber.html.tags;

import com.benjiweber.typeref.Parameters;

import static com.benjiweber.html.HtmlDsl.build;

public class A extends ReflectiveTag implements Content {
    public String href;
    public String rel ;
    public interface Dsl {
        default A a(Parameters<A> params, Tag... children) {
            return build(params, children);
        }
        default A a(Parameters<A> params, String literal) {
            return build(params, new Literal(literal) );
        }
    }
}