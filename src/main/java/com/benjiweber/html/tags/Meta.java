package com.benjiweber.html.tags;

import com.benjiweber.typeref.Parameters;

import static com.benjiweber.html.HtmlDsl.build;

public class Meta extends ReflectiveTag {
    public String charset;
    public interface Dsl {
        default Meta meta(Parameters<Meta> params, Tag... children) {
            return build(params, children);
        }
    }
}