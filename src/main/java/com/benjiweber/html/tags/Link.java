package com.benjiweber.html.tags;

import com.benjiweber.html.values.Rel;
import com.benjiweber.html.values.Style;
import com.benjiweber.typeref.Parameters;

import static com.benjiweber.html.HtmlDsl.build;

public class Link extends ReflectiveTag implements Content {
    public Rel rel;
    public Style type;
    public String href;

    public interface Dsl {
        default Link link(Parameters<Link> params, Tag... children) {
            return build(params, children);
        }
    }

}