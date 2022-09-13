
package com.post.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Title: 字符工具类
 * @Description: TODO(描述)
 * @author: 雷大鹏
 * @date: 2020-05-10 10:19:16
 */
public class StringUtils {

    public static int count = 0;
    static Pattern pattern = null;

    public static DecimalFormat df = new DecimalFormat("0.00");

    public static int getIntValue(Object obj) {
        Double double_ = Double.parseDouble(obj.toString());
        return double_.intValue();
    }

    public static Double getDoubleValue(Object obj) {
        return Double.parseDouble(obj.toString());
    }

    // 用星号混淆字符串
    public static String confusion(String content, int startIndex, int replaceCount) {
        return confusion(content, startIndex, replaceCount, "*");
    }

    // 用指定符号混淆字符串
    public static String confusion(String content, int startIndex, int replaceCount, String symbol) {
        if (startIndex + replaceCount > content.length()) {
            return content;
        }

        String confusionStr = "";
        while (confusionStr.length() < replaceCount) {
            confusionStr += symbol;
        }

        return content.substring(0, startIndex) + confusionStr + content.substring(startIndex + 1 + replaceCount);
    }

    // 判断字符串是否是由纯数字组成
    public static boolean isNumber(String str) {
        pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    // 判断字符串是否null或者空字符
    public static boolean isBlank(String... str) {
        for (String _str : str) {
            if (_str != null && !"".equals(_str.trim())) {
                return false;
            }
        }

        return true;
    }

    // 判断字符串是否不为null并且不为空字符串
    public static boolean isNotBlank(String... str) {
        for (String _str : str) {
            if (_str == null || "".equals(_str)) {
                return false;
            }
        }
        return true;
    }

    public static String getPrimaryKey() {
        synchronized (Long.class) {
            count++;
            if (count >= 99999) {
                count = 0;
            }
        }
        String param = count + "";
        while (param.length() < 5) {
            param = "0" + param;
        }
//		return (DateUtils.getToday("YYYYMMddHHmmss") + param);
        return 1 + param;

    }

    public static String fill(String str, int length, String character) {
        while (str.length() < length) {
            str = character + str;
        }
        return str;
    }

    public static String fillRight(String str, int length, String character) {
        while (str.length() < length) {
            str = str + character;
        }
        return str;
    }

    public static boolean isContainChinese(String str) {
        pattern = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = pattern.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }

    public static String URLDecoder(String str) {
        try {
            return URLDecoder.decode(URLDecoder.decode(str, "UTF-8"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String filterPoint(String obj) {
        if (obj.endsWith(".00")) {
            obj = obj.substring(0, obj.length() - 3);
        }
        if (obj.endsWith(".0")) {
            obj = obj.substring(0, obj.length() - 2);
        }

        return obj;
    }

    public static String ObjectToString(Object object) {
        if (object instanceof Double) {
            Double doubleTmp = Double.parseDouble(object + "");
            return doubleTmp.intValue() + "";
        } else {
            return object.toString();
        }
    }

    public static void main(String[] args) {
        // http%3A%2F%2Fwxtest.smeia.cn%2Fcust%2FcustDataFile%2Fphotoupload%2F2021102500000003.png
        String test = "http%3A%2F%2Fwxtest.smeia.cn%2Fcust%2FcustDataFile%2Fphotoupload%2F2021102500000003.png";
        System.out.println("解码前:" + test);
        System.out.println("解码后:" + URLDecoder(test));
    }

    public static String getStringFromMap(Map map, String key) {
        if (map == null || map.get(key) == null) {
            return null;
        } else if (StringUtils.isBlank(map.get(key).toString())) {
            return null;
        } else {
            return map.get(key).toString();
        }
    }

    public static String division(int a, int b) {
        float num = (float) a / b;
        return df.format(num);
    }

    public static String join(String[] s) {
        StringBuffer sb = new StringBuffer("");
        if (s != null && s.length > 0) {
            for (String str : s) {
                sb.append(str);
            }
        }

        return sb.toString();

    }

    public static String getUserNameByToken(String token) {
        return getParamsByToken(token)[0];
    }

    public static String getUserIdByToken(String token) {
        return getParamsByToken(token)[1];
    }

    public static String getOrganCodeByToken(String token) {
        return getParamsByToken(token)[2];
    }

    public static String[] getParamsByToken(String token) {
        // String
        // token=user.getUserName()+"|"+user.getUserId()+"|"+user.getOrganCode()+"|"+user.getRoleCode();
        return token.split("_");
    }

}
