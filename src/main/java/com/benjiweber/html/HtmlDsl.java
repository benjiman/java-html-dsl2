package com.benjiweber.html;

import com.benjiweber.html.tags.*;
import com.benjiweber.typeref.Parameters;

import java.util.List;

public interface HtmlDsl extends
    Html.Dsl,
    Head.Dsl,
    Title.Dsl,
    Meta.Dsl,
    Link.Dsl,
    Script.Dsl,
    Body.Dsl,
    Div.Dsl,
    Span.Dsl,
    A.Dsl,
    P.Dsl,
    Img.Dsl {

    static <T extends Tag> T build(Parameters<T> params, Tag... children) {
        var tag = params.get();
        tag.children = List.of(children);
        return tag;
    }

}
