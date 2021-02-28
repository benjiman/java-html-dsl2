package com.benjiweber.html.format;

import org.w3c.tidy.Tidy;

import java.io.StringReader;
import java.io.StringWriter;

public class Formatter {

    public static String tidy(String html) {
        Tidy tidy = new Tidy();
        tidy.setSmartIndent(true);
        tidy.setTidyMark(false);
        tidy.setDocType("omit");
        tidy.setXmlTags(true);
        StringWriter writer = new StringWriter();
        tidy.parse(new StringReader(html), writer);
        return writer.toString().replaceAll("<script(.*?)/>","<script$1></script>");
    }

}
