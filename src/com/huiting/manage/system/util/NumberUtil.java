package com.huiting.manage.system.util;

import java.math.BigDecimal;

import org.apache.commons.lang.math.NumberUtils;

/**
 *
 * @ClassName: NumberUtil
 * @Description: 数字转换工具类
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午5:17:43
 *
 */
public class NumberUtil extends NumberUtils {

    public static BigDecimal createBigDecimal(Double dou) {
        return dou != null ? createBigDecimal(dou.toString()) : null;
    }

    public static BigDecimal createBigDecimal(Long lou) {
        return lou != null ? createBigDecimal(lou.toString()) : null;
    }

    public static BigDecimal createBigDecimal(Integer lou) {
        return lou != null ? createBigDecimal(lou.toString()) : null;
    }

    public static Integer createInteger(BigDecimal bd) {
        if (bd == null) {
            return null;
        }
        return new Integer(bd.intValue());
    }

    public static Integer createInteger(java.math.BigInteger bi) {
        if (bi == null) {
            return null;
        }
        return new Integer(bi.intValue());
    }

    public static Integer createInteger(java.lang.Long l) {
        if (l == null) {
            return null;
        }
        return new Integer(l.intValue());
    }

    public static Integer createInteger(java.lang.Number n) {
        if (n == null) {
            return null;
        }
        return new Integer(n.intValue());
    }

    public static Integer createInteger(Object o) {
        if (o == null) {
            return null;
        }
        if (o instanceof Number) {
            return createInteger((Number) o);
        }

        return createInteger(o.toString());
    }

    public static Long createLong(BigDecimal bd) {
        if (bd == null) {
            return null;
        }
        return new Long(bd.longValue());
    }

    public static Long createLong(java.math.BigInteger bi) {
        if (bi == null) {
            return null;
        }
        return new Long(bi.longValue());
    }

    public static Long createLong(java.lang.Number n) {
        if (n == null) {
            return null;
        }
        return new Long(n.longValue());
    }

    public static Long createLong(Object o) {
        if (o == null) {
            return null;
        }
        if (o instanceof Number) {
            return createLong((Number) o);
        }

        return createLong(o.toString());
    }

    public static Double createDouble(BigDecimal bd) {
        if (bd == null) {
            return null;
        }
        return new Double(bd.doubleValue());
    }

    public static Double createDouble(java.math.BigInteger bi) {
        if (bi == null) {
            return null;
        }
        return new Double(bi.doubleValue());
    }

    public static Double createDouble(java.lang.Long l) {
        if (l == null) {
            return null;
        }
        return new Double(l.doubleValue());
    }

    public static Double createDouble(java.lang.Number n) {
        if (n == null) {
            return null;
        }
        return new Double(n.doubleValue());
    }

    public static Double createDouble(Object o) {
        if (o == null) {
            return null;
        }
        if (o instanceof Number) {
            return createDouble((Number) o);
        }

        return createDouble(o.toString());
    }

    public static boolean number2Boolean(int i) {
        if (i == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static String number2String(long num) {
        return String.valueOf(num);
    }

    /**
     * @param ft
     * @param sd
     * @return
     * @方法说明 比较参数大小,空最大
     */
    public static boolean compareTo(Long ft, Long sd) {
        if (null == ft && null != sd) {
            return true;
        }
        if (null == ft && null == sd) {
            return false;
        }
        if (null != ft & null == sd) {
            return false;
        }
        return ft.compareTo(sd) > 0;
    }

    /**
     * @param fd
     * @param sd
     * @return
     * @方法说明 比较两个值是否相等
     */
    public static boolean equalsDouble(Double fd, Double sd) {
        if (null != fd && null == sd) {
            return false;
        }
        if (null == fd && null != sd) {
            return false;
        }
        if (null == fd && null == sd) {
            return true;
        }
        return (fd.compareTo(sd) == 0);
    }

    public static boolean equalsBigDecimal(BigDecimal fd, BigDecimal sd) {
        if (null != fd && null == sd) {
            return false;
        }
        if (null == fd && null != sd) {
            return false;
        }
        if (null == fd && null == sd) {
            return true;
        }
        return (fd.compareTo(sd) == 0);
    }

    public static boolean equalsLong(Long fd, Long sd) {
        if (null != fd && null == sd) {
            return false;
        }
        if (null == fd && null != sd) {
            return false;
        }
        if (null == fd && null == sd) {
            return true;
        }
        return (fd.compareTo(sd) == 0);
    }

    public static boolean equalsInteger(Integer fd, Integer sd) {
        if (null != fd && null == sd) {
            return false;
        }
        if (null == fd && null != sd) {
            return false;
        }
        if (null == fd && null == sd) {
            return true;
        }
        return (fd.compareTo(sd) == 0);
    }

    public static boolean equalsShort(Short fd, Short sd) {
        if (null != fd && null == sd) {
            return false;
        }
        if (null == fd && null != sd) {
            return false;
        }
        if (null == fd && null == sd) {
            return true;
        }
        return (fd.compareTo(sd) == 0);
    }

    /**
     * @param fd
     * @param sd
     * @return
     * @方法说明 对数值类型的判断相等(目前支持 long integer double)
     */
    public static boolean equals(Object fd, Object sd) {
        if (null != fd && null == sd) {
            return false;
        }
        if (null == fd && null != sd) {
            return false;
        }
        if (null == fd && null == sd) {
            return true;
        }
        if (fd.getClass().equals(Long.class)) {
            return equalsLong(createLong(fd), createLong(sd));
        }
        if (fd.getClass().equals(Integer.class)) {
            return equalsInteger(createInteger(fd), createInteger(sd));
        }
        if (fd.getClass().equals(Double.class)) {
            return equalsDouble(createDouble(fd), createDouble(sd));
        }
        return fd.equals(sd);
    }

    /**
     * @param fd
     * @param sd
     * @return
     * @方法说明 计算乘法
     */
    public static BigDecimal multiplyB(Object fd, Object sd) {
        if (null == fd || null == sd) {
            return null;
        }
        BigDecimal f = NumberUtils.createBigDecimal(fd.toString());
        BigDecimal s = NumberUtils.createBigDecimal(sd.toString());
        return f.multiply(s);
    }

    /**
     * @param fd
     * @param sd
     * @return
     * @方法说明 计算乘法
     */
    public static Double multiplyD(Object fd, Object sd) {
        if (null == fd || null == sd) {
            return null;
        }
        BigDecimal f = NumberUtils.createBigDecimal(fd.toString());
        BigDecimal s = NumberUtils.createBigDecimal(sd.toString());
        return f.multiply(s).doubleValue();
    }

    /**
     * @param fd
     * @param sd
     * @return
     * @方法说明 计算乘法
     */
    public static Integer multiplyI(Object fd, Object sd) {
        if (null == fd || null == sd) {
            return null;
        }
        BigDecimal f = NumberUtils.createBigDecimal(fd.toString());
        BigDecimal s = NumberUtils.createBigDecimal(sd.toString());
        return f.multiply(s).intValue();
    }

    /**
     *
     * @param fd
     * @param sd
     * @return
     * @方法说明 计算减法
     */
    public static Double subtractD(Object fd, Object sd) {
        if (null == fd || null == sd) {
            return null;
        }
        BigDecimal f = NumberUtils.createBigDecimal(fd.toString());
        BigDecimal s = NumberUtils.createBigDecimal(sd.toString());
        return f.subtract(s).doubleValue();
    }

    /**
     *
     * @param fd
     * @param sd
     * @return
     * @方法说明 计算减法
     */
    public static Integer subtractI(Object fd, Object sd) {
        if (null == fd || null == sd) {
            return null;
        }
        BigDecimal f = NumberUtils.createBigDecimal(fd.toString());
        BigDecimal s = NumberUtils.createBigDecimal(sd.toString());
        return f.subtract(s).intValue();
    }

    /**
     *
     * @param fd
     * @param sd
     * @return
     * @方法说明 计算减法
     */
    public static BigDecimal subtractB(Object fd, Object sd) {
        if (null == fd || null == sd) {
            return null;
        }
        BigDecimal f = NumberUtils.createBigDecimal(fd.toString());
        BigDecimal s = NumberUtils.createBigDecimal(sd.toString());
        return f.subtract(s);
    }

    /**
     *
     * @param fd
     * @param sd
     * @return
     * @方法说明 计算加法
     */
    public static BigDecimal addB(Object fd, Object sd) {
        if (null == fd || null == sd) {
            return null;
        }
        BigDecimal f = NumberUtils.createBigDecimal(fd.toString());
        BigDecimal s = NumberUtils.createBigDecimal(sd.toString());
        return f.add(s);
    }

    /**
     *
     * @param fd
     * @param sd
     * @return
     * @方法说明 计算加法
     */
    public static Double addD(Object fd, Object sd) {
        if (null == fd || null == sd) {
            return null;
        }
        BigDecimal f = NumberUtils.createBigDecimal(fd.toString());
        BigDecimal s = NumberUtils.createBigDecimal(sd.toString());
        return f.add(s).doubleValue();
    }

    /**
     *
     * @param fd
     * @param sd
     * @return
     * @方法说明 计算加法
     */
    public static Integer addI(Object fd, Object sd) {
        if (null == fd || null == sd) {
            return null;
        }
        BigDecimal f = NumberUtils.createBigDecimal(fd.toString());
        BigDecimal s = NumberUtils.createBigDecimal(sd.toString());
        return f.add(s).intValue();
    }

    /**
     *
     * @param fd
     * @param sd
     * @return
     * @方法说明 除法
     */
    public static BigDecimal divideB(Object fd, Object sd) {
        if (null == fd || null == sd) {
            return null;
        }
        BigDecimal f = NumberUtils.createBigDecimal(fd.toString());
        BigDecimal s = NumberUtils.createBigDecimal(sd.toString());
        return f.divide(s);
    }

    /**
     *
     * @param fd
     * @param sd
     * @return
     * @方法说明 除法
     */
    public static Double divideD(Object fd, Object sd) {
        if (null == fd || null == sd) {
            return null;
        }
        BigDecimal f = NumberUtils.createBigDecimal(fd.toString());
        BigDecimal s = NumberUtils.createBigDecimal(sd.toString());
        return f.divide(s,3,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     *
     * @param fd
     * @param sd
     * @return
     * @方法说明 除法
     */
    public static Integer divideI(Object fd, Object sd) {
        if (null == fd || null == sd) {
            return null;
        }
        BigDecimal f = NumberUtils.createBigDecimal(fd.toString());
        BigDecimal s = NumberUtils.createBigDecimal(sd.toString());
        return f.divide(s).intValue();
    }

    public static Integer createInteger(String s) {
        return s != null ? Integer.valueOf(s) : null;
    }
}
