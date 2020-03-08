package com.cscrb.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class StringUtils {

    public final static String REG_DIGIT = "[0-9]*";
    public final static String REG_CHAR = "[a-zA-Z]*";
    public final static String EMPTY = "";

    /**
     * 判断是否为空
     */
    public static boolean isEmpty(Object... obj) {
        if (obj == null || "".equals(obj))
            return true;
        for (Object object : obj) {
            if (object == null)
                return true;
            if (object.toString().trim().length() == 0)
                return true;
        }

        return false;
    }

    public static boolean isBlankEmpty(Object obj) {
        if (obj == null || "".equals(obj) || "".equals(obj.toString().trim()) || "null".equalsIgnoreCase(obj.toString()))
            return true;

        return false;
    }

    public static Object nullToSpace(Object o) {
        if (null == o) {
            return "";
        }
        return o;
    }

    public static Integer strToInt(Object obj) {
        if (null == obj || "".equals(obj)) {
            return null;
        }
        return Integer.parseInt(obj.toString());
    }

    public static String objNotNull(Object obj) {
        if (null == obj || "".equals(obj)) {
            return null;
        }
        return obj.toString();
    }

    public static Long strToLong(Object obj) {
        if (null == obj || "".equals(obj)) {
            return null;
        }
        return Long.parseLong(obj.toString());
    }

    public static Date strToDate(Object obj) {
        if (null == obj || "".equals(obj)) {
            return null;
        }
        return new Date(Long.parseLong(obj.toString()));
    }

    /**
     * 是否空,或者为空串,或者为"null"
     */
    public static boolean isBlankEmpty(Object... objs) {
        if (objs == null || objs.length == 0)
            return true;
        for (Object obj : objs) {
            if (isBlankEmpty(obj)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isNotBlank(String pattern) {
        return !isBlankEmpty(pattern);
    }

    public static boolean isBlank(String pattern) {
        return isBlankEmpty(pattern);
    }

    public static String formatCountNames(String nameList) {
        String[] names = nameList.split(",");

        Map<String, Integer> nameCount = new HashMap<String, Integer>();
        for (String name : names) {
            if (StringUtils.isEmpty(name)) continue;
            if (nameCount.containsKey(name)) {
                Integer count = nameCount.get(name) + 1;
                nameCount.put(name, count);
            } else {
                nameCount.put(name, 1);
            }
        }

        StringBuilder newNames = new StringBuilder();
        for (String key : nameCount.keySet()) {
            if (StringUtils.isEmpty(key)) continue;
            Integer count = nameCount.get(key);
            String splitChar = newNames.length() > 0 ? "," : "";
            newNames.append(splitChar).append(key).append("x").append(count);
        }

        return newNames.toString();
    }


    public static boolean isDigit(String str) {
        return isNumeric(str);
    }

    public static boolean isChar(String str) {
        return str.matches(REG_CHAR);
    }

    public static Boolean isNotEmpty(Object... obj) {
        Boolean r = StringUtils.isEmpty(obj);
        return !r;
    }

    public static boolean isNumeric(String str) {
        if (isBlankEmpty(str)) return false;
        for (int i = str.length(); --i >= 0; ) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * string 中的 str 在倒数 num 中的位置
     */
    public static int stringLastlndex(String string, String str, int num) {
        int indexOf = string.lastIndexOf(str);
        if (num > 1) {
            return stringLastlndex(string.substring(0, indexOf), str, num - 1);
        } else {
            return indexOf;
        }
    }


    public static String getValue(Object val) {
        return val == null ? "" : val.toString();
    }

    public static String getFileName(boolean type, Date startDate, String tableName) {
        String dateString = DateUtils.dateFormat(startDate, "yyyyMMdd");
        StringBuffer stringBuffer = new StringBuffer(dateString);
        stringBuffer.append("_");
        stringBuffer.append(tableName);
        stringBuffer.append("_");
        if (type) {
            stringBuffer.append("insert&");
        } else {
            stringBuffer.append("update&");
        }
        return stringBuffer.toString();
    }
}
