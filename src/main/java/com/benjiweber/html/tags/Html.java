package com.benjiweber.html.tags;

import com.benjiweber.typeref.Parameters;

import static com.benjiweber.html.HtmlDsl.build;
import static com.benjiweber.html.StreamUtils.array;

public class Html extends Tag {

    public interface Dsl {
        default Html html(Head head, Body body) {
            return build($->{}, array(head,body));
        }
        default Html html(Parameters<Html> params, Head head, Body body) {
            return build(params,array(head,body));
        }
    }
}