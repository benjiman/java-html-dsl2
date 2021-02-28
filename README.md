# java-html-dsl

Example DSL for writing html in Java. Rework of benjiman/java-html-dsl to work with newer versions of Java 

This

```java
String doc =
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
```
Generates

```html
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
```