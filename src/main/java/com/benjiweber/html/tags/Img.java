package com.benjiweber.html.tags;

import com.benjiweber.html.values.PixelMeasurement;
import com.benjiweber.typeref.Parameters;

import static com.benjiweber.html.HtmlDsl.build;

public class Img extends ReflectiveTag implements Content {
    public String src;
    public PixelMeasurement width;
    public PixelMeasurement height;

    public interface Dsl {
        default Img img(Parameters<Img> params, Tag... children) {
            return build(params, children);
        }
    }
}