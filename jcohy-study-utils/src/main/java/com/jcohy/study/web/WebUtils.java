package com.jcohy.study.web;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

/**
 * Copyright  : 2015-2033 Beijing
 * Created by jiac on 2018/3/9 15:44.
 * ClassName  : WebUtils
 * Description  :
 */
public class WebUtils {

    private static Pattern IMG_SRC = compile("<img\\s+(?:[^>]*)src\\s*=\\s*([^>]+)", 10);
    private static final String regexpForHtml = "<([^>]*)>";

    public WebUtils() {
    }

    public static List<String> get(String htmlTxt) {
        Matcher matcher = IMG_SRC.matcher(htmlTxt);
        ArrayList list = new ArrayList();

        while(matcher.find()) {
            String group = matcher.group(1);
            if (group != null) {
                if (group.startsWith("'")) {
                    list.add(group.substring(1, group.indexOf("'", 1)));
                } else if (group.startsWith("\"")) {
                    list.add(group.substring(1, group.indexOf("\"", 1)));
                } else {
                    list.add(group.split("\\s")[0]);
                }
            }
        }

        return list;
    }

    public static List<String> getImageList(String htmlTxt) {
        return get(htmlTxt);
    }

    public static String getFirstImage(String htmlTxt) throws IndexOutOfBoundsException {
        return getImageByIndex(htmlTxt, 0);
    }

    public static String getImageByIndex(String htmlTxt, int index) throws IndexOutOfBoundsException {
        if (get(htmlTxt).size() <= index) {
            throw new IndexOutOfBoundsException("the index you custom is out of the image size");
        } else {
            return (String)getImageList(htmlTxt).get(index);
        }
    }

    public static String filterHtml(String str) {
        Pattern pattern = compile("<([^>]*)>");
        Matcher matcher = pattern.matcher(str);
        StringBuffer sb = new StringBuffer();

        for(boolean result1 = matcher.find(); result1; result1 = matcher.find()) {
            matcher.appendReplacement(sb, "");
        }

        matcher.appendTail(sb);
        return sb.toString();
    }

    public static String fiterHtmlTag(String str, String tag) {
        String regexp = "<\\s*" + tag + "\\s+([^>]*)\\s*>";
        Pattern pattern = compile(regexp);
        Matcher matcher = pattern.matcher(str);
        StringBuffer sb = new StringBuffer();

        for(boolean result1 = matcher.find(); result1; result1 = matcher.find()) {
            matcher.appendReplacement(sb, "");
        }

        matcher.appendTail(sb);
        return sb.toString();
    }

    public static String replaceHtmlTag(String str, String beforeTag, String tagAttribute, String startTag, String endTag) {
        String regexpForTag = "<\\s*" + beforeTag + "\\s+([^>]*)\\s*>";
        String regexpForTagAttribute = tagAttribute + "=\"([^\"]+)\"";
        Pattern patternForTag = compile(regexpForTag);
        Pattern patternForAttribute = compile(regexpForTagAttribute);
        Matcher matcherForTag = patternForTag.matcher(str);
        StringBuffer sb = new StringBuffer();

        for(boolean result = matcherForTag.find(); result; result = matcherForTag.find()) {
            StringBuffer sbReplace = new StringBuffer();
            Matcher matcherForAttribute = patternForAttribute.matcher(matcherForTag.group(1));
            if (matcherForAttribute.find()) {
                matcherForAttribute.appendReplacement(sbReplace, startTag + matcherForAttribute.group(1) + endTag);
            }

            matcherForTag.appendReplacement(sb, sbReplace.toString());
        }

        matcherForTag.appendTail(sb);
        return sb.toString();
    }
}
