package com.benjiweber.html.tags;

import com.benjiweber.typeref.Parameters;

import static com.benjiweber.html.HtmlDsl.build;

public class Div extends Tag implements Content {

    public interface Dsl {

        default Div div(String content) {
            return div(new Literal(content));
        }
        default Div div(Tag... children) {
            return build($->{},children);
        }
        default Div div(Parameters<Div> params, Tag... children) {
            return build(params,children);
        }
    }

}