package com.benjiweber.html;

import org.junit.Test;

import java.util.stream.Stream;

import static com.benjiweber.html.values.PixelMeasurement.px;
import static com.benjiweber.html.values.Rel.stylesheet;
import static com.benjiweber.html.values.ScriptType.javascript;
import static com.benjiweber.html.values.Style.css;
import static org.junit.Assert.assertEquals;

public class HtmlExampleTest implements HtmlDsl {
    @Test
    public void example_static_doc() {
        assertEquals(
                """
                <html>
                  <head>
                    <title>Hello Html World</title>
                    <meta charset="utf-8" />
                    <link rel="stylesheet" type="css" href="/my.css" />
                    <script type="text/javascript" src="/some.js" ></script>
                  </head>
                  <body>
                    <div class="article">
                      <a href="https://benjiweber.com/">
                        <span class="label">Click Here</span>
                        <img src="/myimg.jpg" width="25" height="25" />
                      </a>
                      <p>
                        <span>some text</span>
                        <div>block</div>
                      </p>
                    </div>
                  </body>
                </html>
                """.trim(),
            html(
                head(
                    title("Hello Html World"),
                    meta($ -> $.charset = "utf-8"),
                    link($->{ $.rel=stylesheet; $.type=css; $.href="/foo.css"; }),
                    script($->{ $.type= javascript; $.src="/some.js"; })
                ),
                body(
                    div($-> $.cssClass = "article",
                        a($-> $.href="https://benjiweber.com/",
                            span($->$.cssClass="label", "Click Here"),
                            img($->{$.src="/myimg.jpg"; $.width=px(25); $.height=px(25); })
                        ),
                        p(span("some text"), div("block"))
                    )
                )
            ).formatted()
        );
    }

    @Test
    public void example_generated_doc() {
            assertEquals(
                """
                <html>
                  <head>
                    <meta charset="utf-8" />
                  </head>
                  <body>
                    <p>Paragraph one</p>
                    <p>Paragraph two</p>
                    <p>Paragraph three</p>
                  </body>
                </html>
                """.trim(),
                html(
                    head(
                        meta($ -> $.charset = "utf-8")
                    ),
                    body(
                        Stream.of("one","two","three")
                            .map(number -> "Paragraph " + number)
                            .map(content -> p(content))
                    )
                ).formatted()
        );
    }

    @Test
    public void example_escaped_user_content() {
        assertEquals(
                """
                <html>
                  <head>
                    <meta charset="utf-8" />
                  </head>
                  <body>
                    <p>&lt;script src="attack.js"&gt;&lt;/script&gt;</p>
                  </body>
                </html>
                """.trim(),
                html(
                    head(
                        meta($-> $.charset = "utf-8")
                    ),
                    body(
                        p("<script src=\"attack.js\"></script>")
                    )
                ).formatted()
        );
    }


}
