package com.benjiweber.html.tags;

import com.benjiweber.html.values.Rel;
import com.benjiweber.html.values.ScriptType;
import com.benjiweber.html.values.Style;
import com.benjiweber.typeref.Parameters;

import static com.benjiweber.html.HtmlDsl.build;

public class Script extends ReflectiveTag {
    public ScriptType type;
    public String src;

    public interface Dsl {
        default Script script(Parameters<Script> params, Tag... children) {
            return build(params, children);
        }
    }
}