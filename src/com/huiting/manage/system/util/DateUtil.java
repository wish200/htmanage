package com.huiting.manage.system.util;


import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * <p> <b>Title：</b> 日期工具类 </p> <p> <b>Description：</b> </p>
 *
 * @author 闫洪磊
 */
public class DateUtil {

    public final static String FORMAT_YEARMONTH = "yyyyMM";
    public final static String FORMAT_DATE = "yyyy-MM-dd";
    public final static String FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";
    public final static String FORMAT_DATE_ZH = "yyyy年MM月dd日";
    public final static String FORMAT_DATETIME_ZH = "yyyy年MM月dd日 HH时mm分ss秒";
    public final static String TYPE_YEARMONTH = "ym";
    public final static String TYPE_DATE = "date";
    public final static String TYPE_DATETIME = "datetime";
    /**
     * 日期排序类型-升序
     */
    public final static int DATE_ORDER_ASC = 0;
    /**
     * 日期排序类型-降序
     */
    public final static int DATE_ORDER_DESC = 1;

    /**
     * @param date
     * @param mnum
     * @return
     * @方法说明 增加月份
     * @date 2013-1-23
     */
    public static Date addMonth(Date date, int mnum) {
        Calendar calender = Calendar.getInstance();
        calender.setTime(date);
        calender.add(Calendar.MONTH, mnum);
        return calender.getTime();
    }
    /**
     * 
    * @Title: getNowLastMonth 
    * @Description: 获取日期的上一个月  
    * @param @param date 201301 201212
    * @param @return     String
    * @return String   
    * @throws
     */
    @SuppressWarnings("deprecation")
	public static String getNowLastMonth(){
    	Date date=new Date();
    	date.setMonth(date.getMonth() - 1);
		String nowTime=DateUtil.getYearMonth(date);
    	return nowTime;
    }
    
    /**
     * 
    * @Title: getNowLastMonth 
    * @Description: 获取日期的上二个月  
    * @param @param date 201301 201212
    * @param @return     String
    * @return String   
    * @throws
     */
    @SuppressWarnings("deprecation")
	public static String getNowLastTWOMonth(){
    	Date date=new Date();
    	date.setMonth(date.getMonth() - 2);
		String nowTime=DateUtil.getYearMonth(date);
    	return nowTime;
    }
    
    /**
      * @Description: 根据年月 获得报送频率 
      * @param @return   比如：03 Q 06 H 
      * @return String   
      * @throws
     */
    public static String getFetchrate(String yearmonth){
    	String fetchrate="";
    	if(yearmonth.endsWith("03")||(yearmonth.endsWith("09"))){
    		fetchrate="Q";
		}else if(yearmonth.endsWith("06")){
			fetchrate="H";
		}else if (yearmonth.endsWith("12")) {
			fetchrate="Y";
		}else {
			fetchrate="M";
		}
    	return fetchrate;
    }
    /**
     * @throws ParseException 
      * @Description: 获取输入年月的上一月。
      * @param @param yearmonth
      * @param @return    
      * @return String   
      * @throws
     */
    @SuppressWarnings("deprecation")
    public static String getLastMonth(String yearmonth) throws ParseException{
    	Date YearMonth=getDateParse(yearmonth,"yyyyMM");
    	YearMonth.setMonth(YearMonth.getMonth() - 1);
    	String nowTime=DateUtil.getYearMonth(YearMonth);
    	return nowTime;
    }
    
    /**
     * @throws ParseException 
      * @Description: 获取输入年月的xia一月。
      * @param @param yearmonth
      * @param @return    
      * @return String   
      * @throws
     */
    @SuppressWarnings("deprecation")
    public static String getNextMonth(String yearmonth) throws ParseException{
    	Date YearMonth=getDateParse(yearmonth,"yyyyMM");
    	YearMonth.setMonth(YearMonth.getMonth() + 1);
    	String nowTime=DateUtil.getYearMonth(YearMonth);
    	return nowTime;
    }
    
    /**
     * 用字符串获得日期
     *
     * @throws ParseException
     * @dateValue 日期字符串
     * @dateType 格式化的类型,date和datetime
     */
    public static Date getDate(String dateValue, String dateType)
            throws ParseException {
        if (dateValue == null) {
            return null;
        }
        if (dateType.equals(TYPE_DATE)) {
            SimpleDateFormat sfdate = new SimpleDateFormat(FORMAT_DATE);
            return sfdate.parse(dateValue);
        } else if (dateType.equals(TYPE_DATETIME)) {
            SimpleDateFormat sftime = new SimpleDateFormat(FORMAT_DATETIME);
            return sftime.parse(dateValue);
        } else if (dateType.equals(TYPE_YEARMONTH)) {
            SimpleDateFormat sftime = new SimpleDateFormat(FORMAT_YEARMONTH);
            return sftime.parse(dateValue);
        }
        return null;
    }

    /**
     * 用字符串获得java.sql.Date日期
     *
     * @throws ParseException
     * @dateValue 日期字符串
     * @dateType 格式化的类型,date和datetime
     */
    public static java.sql.Date getSqlDate(String dateValue, String dateType)
            throws ParseException {
        Date date = getDate(dateValue, dateType);
        if (date == null) {
            return null;
        }
        return new java.sql.Date(date.getTime());
    }

    /**
     * 将日期加上某些天或减去天数)返回字符串
     *
     * @param date 待处理日期
     * @param to 加减的天数
     * @return 日期
     */
    public static Date dateAdd(String date, int to) {
        java.util.Date d = null;
        try {
            d = java.sql.Date.valueOf(date);
        } catch (Exception e) {
            e.printStackTrace();
            d = new java.util.Date();
        }
        Calendar strDate = Calendar.getInstance();
        strDate.setTime(d);
        strDate.add(Calendar.DATE, to); // 日期减 如果不够减会将月变动
        return strDate.getTime();
    }

    /**
     * 将日期加上某些天或减去天数)返回字符串
     *
     * @param date 待处理日期
     * @param to 加减的天数
     * @return 日期
     */
    public static java.sql.Date dateAdd(java.sql.Date date, int to) {
        Calendar strDate = Calendar.getInstance();
        strDate.setTime(date);
        strDate.add(Calendar.DATE, to); // 日期减 如果不够减会将月变动
        return new java.sql.Date(strDate.getTime().getTime());
    }

    /**
     * @throws ParseException
     *
     * @Title: getDate
     * @Description:  字符串 转换 日期
     * @param
     * @param dateValue "201303"
     * @param
     * @param dateType “yyyyMM”
     * @param
     * @return
     * @return Date
     * @throws
     */
    public static Date getDateParse(String dateValue, String dateType)
            throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(dateType);
        Date date = sdf.parse(dateValue);
        return date;
    }

    /**
     * 格式化日期
     *
     * @param date 日期对象
     * @param splitChar 分隔字符
     * @return
     */
    public static String formatDate(Date date, String splitChar) {
        java.text.SimpleDateFormat sfdate = new java.text.SimpleDateFormat(
                "yyyy" + splitChar + "MM" + splitChar + "dd");
        return sfdate.format(date);
    }

    /**
     * @dateValue 日期对象，可以是java.util.Date和java.sql.Date
     * @dateType 格式化的类型,date和datetime
     */
    public static String format(Object dateValue, String dateType) {
        if (dateValue == null) {
            return "";
        }
        if (dateValue instanceof java.sql.Date) {
            return dateValue.toString();
        } else if (dateValue instanceof java.util.Date) {
            if (TYPE_DATE.equals(dateType)) {
                java.text.SimpleDateFormat sfdate = new java.text.SimpleDateFormat(FORMAT_DATE);
                return sfdate.format(dateValue);
            } else if (TYPE_DATETIME.equals(dateType)) {
                java.text.SimpleDateFormat sftime = new java.text.SimpleDateFormat(FORMAT_DATETIME);
                return sftime.format(dateValue);
            } else {
                return "非法日期格式[" + dateType + "]";
            }
        } else {
            return "非日期类型";
        }
    }

    /**
     * 转换日期对象为中文化日期
     *
     * @dateValue 日期对象，可以是java.util.Date和java.sql.Date
     * @dateType 格式化的类型,date和datetime
     */
    public static String formatZh(Date dateValue, String dateType) {
        if (dateValue == null) {
            return "";
        }
        if (dateValue instanceof java.sql.Date) {
            return dateValue.toString();
        } else if (dateValue instanceof java.util.Date) {
            if (TYPE_DATE.equals(dateType)) {
                java.text.SimpleDateFormat sfdate = new java.text.SimpleDateFormat(FORMAT_DATE_ZH);
                return sfdate.format(dateValue);
            } else if (TYPE_DATETIME.equals(dateType)) {
                java.text.SimpleDateFormat sftime = new java.text.SimpleDateFormat(FORMAT_DATETIME_ZH);
                return sftime.format(dateValue);
            } else {
                return "非法日期格式[" + dateType + "]";
            }
        } else {
            return "非日期类型";
        }
    }

    /**
     * 转化成年月日期
     *
     * @param sDate 字符型日期：2009-02-02
     * @param DelimeterChar 分割符号比如 / -
     * @return 年月日期 :2009年02月02日
     */
    public static String chDateChange(String sDate, String DelimeterChar) {
        String tmpArr[] = sDate.split(DelimeterChar);
        tmpArr[0] = tmpArr[0] + "年";
        tmpArr[1] = tmpArr[1] + "月";
        tmpArr[2] = tmpArr[2] + "日";
        return tmpArr[0] + tmpArr[1] + tmpArr[2];
    }

    /**
     * 得到系统日期
     *
     * @return YYYY-MM-DD
     */
    public static String getSysdate() {
        java.sql.Timestamp timeNow = new java.sql.Timestamp(
                System.currentTimeMillis());
        return timeNow.toString().substring(0, 10);
    }

    /**
     * 得到系统日期
     *
     * @return YYYY-MM-DD
     */
    public static String getSysdate(String formatType) {
        java.sql.Timestamp timeNow = new java.sql.Timestamp(
                System.currentTimeMillis());
        return formatZh(timeNow, formatType);
    }

    /**
     * 得到某天是周几
     *
     * @param strDay
     * @return 周几
     */
    public static int getWeekDay(String strDay) {
        Date day = DateUtil.dateAdd(strDay, -1);
        Calendar strDate = Calendar.getInstance();
        strDate.setTime(day);
        int meStrDate = strDate.get(Calendar.DAY_OF_WEEK);
        return meStrDate;
    }

    /**
     * 得到某天是周几
     *
     * @param strDay
     * @return 周几
     */
    public static int getWeekDay(Date date) {
        Date day = DateUtil.dateAdd(format(date, "date"), -1);
        Calendar strDate = Calendar.getInstance();
        strDate.setTime(day);
        int meStrDate = strDate.get(Calendar.DAY_OF_WEEK);
        return meStrDate;
    }

    /**
     * 取得两个日期段的日期间隔
     *
     * @author color
     * @param t1 时间1
     * @param t2 时间2
     * @return t2 与t1的间隔天数
     * @throws ParseException 如果输入的日期格式不是0000-00-00 格式抛出异常
     */
    public static int getBetweenDays(String t1, String t2)
            throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        int betweenDays = 0;
        Date d1 = format.parse(t1);
        Date d2 = format.parse(t2);
        betweenDays = getBetweenDays(d1, d2);
        return betweenDays;
    }

    /**
     * 取得两个日期段的日期间隔
     *
     * @author color
     * @param t1 时间1
     * @param t2 时间2
     * @param swapDate 当日期1小于日期2时是否交换两个日期值
     * @return t2 与t1的间隔天数
     * @throws ParseException 如果输入的日期格式不是0000-00-00 格式抛出异常
     */
    public static int getBetweenDays(String t1, String t2, boolean swapDate)
            throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        int betweenDays = 0;
        Date d1 = format.parse(t1);
        Date d2 = format.parse(t2);
        betweenDays = getBetweenDays(d1, d2, swapDate);
        return betweenDays;
    }

    /**
     * 取得两个日期段的日期间隔
     *
     * @param d1 日期1
     * @param d2 日期2
     * @param swapDate 当日期1小于日期2时是否交换两个日期值
     * @return t2 与t1的间隔天数
     */
    public static int getBetweenDays(Date d1, Date d2, boolean swapDate) {
        if (d1 == null || d2 == null) {
            return -1;
        }
        int betweenDays;
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);
        if (swapDate) {
            // 保证第二个时间一定大于第一个时间
            if (c1.after(c2)) {
                c2.setTime(d1);
                c1.setTime(d2);
            }
        }
        int betweenYears = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
        betweenDays = c2.get(Calendar.DAY_OF_YEAR)
                - c1.get(Calendar.DAY_OF_YEAR);
        for (int i = 0; i < betweenYears; i++) {
            c1.set(Calendar.YEAR, (c1.get(Calendar.YEAR) + 1));
            betweenDays += c1.getMaximum(Calendar.DAY_OF_YEAR);
        }
        return betweenDays;
    }

    /**
     * 取得两个日期段的日期间隔
     *
     * @param d1 日期1
     * @param d2 日期2
     * @return t2 与t1的间隔天数
     */
    private static int getBetweenDays(Date d1, Date d2) {
        if (d1 == null || d2 == null) {
            return -1;
        }
        int betweenDays;
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);
        // 保证第二个时间一定大于第一个时间
        if (c1.after(c2)) {
            c2.setTime(d1);
            c1.setTime(d2);
        }
        int betweenYears = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
        betweenDays = c2.get(Calendar.DAY_OF_YEAR) - c1.get(Calendar.DAY_OF_YEAR);
        for (int i = 0; i < betweenYears; i++) {
            c1.set(Calendar.YEAR, (c1.get(Calendar.YEAR) + 1));
            betweenDays += c1.getMaximum(Calendar.DAY_OF_YEAR);
        }
        return betweenDays;
    }
  

    /**
     * 判断指定日期是否在一个日期范围内
     *
     * @param fromDate 范围开始日期
     * @param toDate 范围结束日期
     * @param testDate 测试日期
     * @return 在范围内true,否则false
     */
    public static boolean betweenDays(java.sql.Date fromDate,
            java.sql.Date toDate, java.sql.Date testDate) {
        if (fromDate == null || toDate == null || testDate == null) {
            return false;
        }

        // 1、 交换开始和结束日期
        if (fromDate.getTime() > toDate.getTime()) {
            java.sql.Date tempDate = fromDate;
            fromDate = toDate;
            toDate = tempDate;
        }

        // 2、缩小范围
        long testDateTime = testDate.getTime();
        if ((testDateTime > fromDate.getTime() && testDateTime > toDate
                .getTime())
                || testDateTime < fromDate.getTime()
                && testDateTime < toDate.getTime()) {
            return false;
        }

        return true;
    }

    /**
     * @throws ParseException 
     * 
    * @Title: getNextMonth 
    * @Description: 获得下个月第一天的日期   。 
    * @param @return     
    * @return Date   
    * @throws
     */
    @SuppressWarnings("deprecation")
	public static Date getNextMonthFirst(Date date){   
       Date dat; 
       date.setHours(0);
       date.setMinutes(0);
       date.setSeconds(0);
       Calendar lastDate = Calendar.getInstance();   
       lastDate.setTime(date);
       lastDate.add(Calendar.MONTH,1);//减一个月   
       lastDate.set(Calendar.DATE, 1);//把日期设置为当月第一天 
       dat=lastDate.getTime();   
       return dat;     
    }   
    /**
     * 得到指定年、月的最后一天
     *
     * @param year 年
     * @param month 月
     * @return 本年月的最后一天，如果2009,10，返回结果：2009-10-31
     */
    public static String getLastDateDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        // 某年某月的最后一天
        int lastDate = cal.getActualMaximum(Calendar.DATE);
        return year + "-" + (month + 1) + "-" + lastDate;
    }

    /**
     * 判断两个日期是否为同一天
     *
     * @param d1 日期一
     * @param d2 日期二
     * @return 同一天true，不是同一天false
     */
    public static boolean isSameDate(Date d1, Date d2) {
        boolean result = false;
        Calendar c1 = Calendar.getInstance();
        c1.setTime(d1);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(d2);

        if (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)
                && c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH)
                && c1.get(Calendar.DAY_OF_MONTH) == c2
                .get(Calendar.DAY_OF_MONTH)) {
            result = true;
        }
        return result;
    }

    /**
     * 获取当前系统时间，24小时制
     *
     * @return 当前系统时间
     */
    public static Time getSystemTime() {
        Calendar c1 = Calendar.getInstance();
        int hour = c1.get(Calendar.HOUR_OF_DAY);
        int minute = c1.get(Calendar.MINUTE);
        int second = c1.get(Calendar.SECOND);
        Time systemTime = Time.valueOf(hour + ":" + minute + ":" + second);
        return systemTime;
    }

    /**
     * 是否为周末
     *
     * @param strDate
     * @return true|false
     */
    public static boolean isWeekend(String strDate) {
        int weekDay = getWeekDay(strDate);
        if (weekDay == 6 || weekDay == 7) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 是否为周末
     *
     * @param strDate
     * @return true|false
     */
    public static boolean isWeekend(Date date) {
        int weekDay = getWeekDay(format(date, "date"));
        if (weekDay == 6 || weekDay == 7) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 是否为法定节假日
     *
     * @param strDate
     * @return true|false
     */
    public static boolean isHoliday(String strDate) {
        return false;
    }

    /**
     * 日期排序
     *
     * @param dates 日期列表
     * @param orderType 排序类型 <br/> {@link #DATE_ORDER_ASC}<br/>
     * {@link #DATE_ORDER_DESC}
     * @return 排序结果
     */
    public static List<? extends java.util.Date> orderDate(
            List<? extends java.util.Date> dates, int orderType) {
        DateComparator comp = new DateComparator(orderType);
        Collections.sort(dates, comp);
        return dates;
    }

    /**
     * 日期分组<br/> 能够对指定日期列表按照连续性分组<br/> 例如：[2010-01-15, 2010-01-16, 2010-01-17,
     * 2010-01-20, 2010-01-21, 2010-01-25]<br/> 分组结果为：<br/> <ul>
     * <li>[2010-01-15, 2010-01-16, 2010-01-17]</li> <li>[2010-01-20,
     * 2010-01-21]</li> <li>[2010-01-25]</li> </ul>
     *
     * @param dates 日期对象
     * @return 连续性分组结果
     */
    public static List<List<? extends java.util.Date>> groupDates(
            List<? extends java.util.Date> dates) {
        List<List<? extends java.util.Date>> result = new ArrayList<List<? extends java.util.Date>>();

        // 按照升序排序
        orderDate(dates, DateUtil.DATE_ORDER_ASC);

        // 临时结果
        List<Date> tempDates = null;

        // 上一组最后一个日期
        Date lastDate = null;

        // 当前读取日期
        Date cdate = null;
        for (int i = 0; i < dates.size(); i++) {
            cdate = dates.get(i);

            // 第一次增加
            if (tempDates == null) {
                tempDates = new ArrayList<Date>();
                tempDates.add(cdate);
                result.add(tempDates);
            } else {
                /**
                 * 差距为1是继续在原有的列表中添加，大于1就是用新的列表
                 */
                lastDate = tempDates.get(tempDates.size() - 1);
                int days = getBetweenDays(lastDate, cdate);
                if (days == 1) {
                    tempDates.add(cdate);
                } else {
                    tempDates = new ArrayList<Date>();
                    tempDates.add(cdate);
                    result.add(tempDates);
                }
            }

        }

        return result;
    }

    public static List<java.sql.Date> getBetweenDates(java.sql.Date fromDate,
            java.sql.Date toDate) {
        List<java.sql.Date> result = new ArrayList<java.sql.Date>();
        // 如果开始日期大于结束日期交换
        if (toDate.getTime() < fromDate.getTime()) {
            java.sql.Date tempDate = fromDate;
            fromDate = toDate;
            toDate = tempDate;
        }

        Calendar ca = Calendar.getInstance();
        while (fromDate.getTime() <= toDate.getTime()) {
            ca.setTime(fromDate);
            java.sql.Date tempDate = new java.sql.Date(ca.getTime().getTime());
            result.add(tempDate);
            ca.add(Calendar.DATE, 1);
            fromDate = new java.sql.Date(ca.getTime().getTime());
        }

        return result;
    }

    public static List<java.sql.Date> getAllDate(List<java.sql.Date[]> dateList) {
        List<java.sql.Date> result = new ArrayList<java.sql.Date>();
        for (Object[] objs : dateList) {
            if (objs[0] == null || objs[1] == null) {
                continue;
            }
            java.sql.Date date1 = (java.sql.Date) objs[0];
            java.sql.Date date2 = (java.sql.Date) objs[1];
            List<java.sql.Date> betweenDates = getBetweenDates(date1, date2);
            for (java.sql.Date date : betweenDates) {
                if (!result.contains(date)) {
                    result.add(date);
                }
            }
        }
        return result;
    }

    /**
     * 将出生日期与当前日期相减，获得年龄
     *
     * @param birthdayDate
     * @return
     */
    public static int getAge(Date birthdayDate) {
        String formatCurrent = new SimpleDateFormat("yyyy-MM-dd")
                .format(new Date());

        int firstCu = formatCurrent.indexOf("-");
        int lastCu = formatCurrent.lastIndexOf("-");
        String currentYearStr = formatCurrent.substring(0, firstCu);
        String currentMonthStr = formatCurrent.substring(firstCu + 1, lastCu);
        String currentDayStr = formatCurrent.substring(lastCu + 1);
        int currentYear = Integer.valueOf(currentYearStr);
        int currentMonth = Integer.valueOf(currentMonthStr);
        int currentDay = Integer.valueOf(currentDayStr);

        String formatBirthday = new SimpleDateFormat("yyyy-MM-dd")
                .format(birthdayDate);

        int first = formatBirthday.indexOf("-");
        int last = formatBirthday.lastIndexOf("-");
        String birthYearStr = formatBirthday.substring(0, first);
        String birthMonthStr = formatBirthday.substring(first + 1, last);
        String birthDayStr = formatBirthday.substring(last + 1);

        int birthYear = Integer.valueOf(birthYearStr);
        int birthMonth = Integer.valueOf(birthMonthStr);
        int birthDay = Integer.valueOf(birthDayStr);

        if (currentMonth > birthMonth) {
            return currentYear - birthYear;
        } else if (currentMonth == birthMonth) {
            if (currentDay >= birthDay) {
                return currentYear - birthYear;
            } else {
                return currentYear - birthYear - 1;
            }
        } else {
            return currentYear - birthYear - 1;
        }
    }

    /**
     * 根据指定年月计算上月年月标示<br/>
     *
     * @param yearMonth
     * @return 201010返回201009，201001返回200912
     */
    public static String getPreYearMonth(String yearMonth) {
        if (yearMonth.length() == 6) {
            int year = Integer.valueOf(yearMonth.substring(0, 4));
            int month = Integer.valueOf(yearMonth.substring(4));
            if (month != 1) {
                month -= 1;
            } else {
                year -= 1;
                month = 12;
            }
            return year + (month < 10 ? "0" + month : String.valueOf(month));
        }
        return "";
    }

    /**
     * 获取当前年份
     */
    public static Integer getCurrentYear() {
        Calendar ca = Calendar.getInstance();
        return ca.get(Calendar.YEAR);
    }

    /**
     * 获取当前月份
     */
    public static Integer getCurrentMonth() {
        Calendar ca = Calendar.getInstance();
        return ca.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取年月，例如 201009
     *
     * @param dateObj
     * @return
     */
    public static String getYearMonth(Date dateObj) {
        if (dateObj == null) {
            return "";
        }
        Calendar ca = Calendar.getInstance();
        ca.setTime(dateObj);
        int month = ca.get(Calendar.MONTH) + 1;
        String strMonth = month < 10 ? ("0" + month) : String.valueOf(month);
        String yearMonth = ca.get(Calendar.YEAR) + strMonth;
        return yearMonth;
    }

    /**
     * 获取同比年月
     *
     * @param dateObj
     * @return
     */
    public static List<String> getCtolYear_YearMonth(Date dateObj, int count) {
        List<String> CtolMonDates = new ArrayList<String>();
        if (dateObj == null) {
            return CtolMonDates;
        }
        Calendar ca = Calendar.getInstance();
        ca.setTime(dateObj);
        int month = ca.get(Calendar.MONTH) + 1;
        ;
        String strMonth = month < 10 ? ("0" + month) : String.valueOf(month);
        int year = 0;
        for (int i = 0; i < count; i++) {
            year = ca.get(Calendar.YEAR);
            System.out.println(year);
            if(year<2012){break;}
            ca.add(Calendar.YEAR, -1);
            CtolMonDates.add(year + strMonth);
        }
        return CtolMonDates;
    }
    /**
     * 获取连续的机构的季度
     *
     * @param dateObj
     * @return
     */
    public static List<String> getQuarYear_YearMonth(Date dateObj, int count) {
        List<String> CtolMonDates = new ArrayList<String>();
        if (dateObj == null) {
            return CtolMonDates;
        }
        Calendar ca = Calendar.getInstance();
        ca.setTime(dateObj);
        for (int i = 0; i < count; i++) {
            CtolMonDates.add(ca.get(Calendar.YEAR) +""+ (ca.get(Calendar.MONTH)+1>10?ca.get(Calendar.MONTH)+1:"0"+(ca.get(Calendar.MONTH)+1)));
            ca.add(Calendar.MONTH, -3);
        }
        return CtolMonDates;
    }

    /**
     * 获取同比年月默认为5个月
     *
     * @param dateObj Date日期
     * @return
     */
    public static List<String> getCtolYear_YearMonth(Date dateObj) {
        return getCtolYear_YearMonth(dateObj, 3);
    }

    /**
     * 获取环比年月
     *
     * @param dateObj Date日期
     * @param count 环比日期个数
     * @return
     */
    public static List<String> getCtolMon_YearMonth(Date dateObj, int count,
            String frequency) {
        List<String> CtolMonDates = new ArrayList<String>();
        if (dateObj == null) {
            return CtolMonDates;
        }
        Calendar ca = Calendar.getInstance();
        ca.setTime(dateObj);
        int month = 0;
        int year = 0;
        for (int i = 0; i < count; i++) {
            month = ca.get(Calendar.MONTH) + 1;
            year = ca.get(Calendar.YEAR);
            String strMonth = month < 10 ? ("0" + month) : String
                    .valueOf(month);
            if ("M".equals(frequency)) {
                ca.add(Calendar.MONTH, -1);
            }
            if ("Q".equals(frequency)) {
                ca.add(Calendar.MONTH, -3);
            }
            if ("H".equals(frequency)) {
                ca.add(Calendar.MONTH, -6);
            }
            if ("Y".equals(frequency)) {
                ca.add(Calendar.MONTH, -12);
            }

            CtolMonDates.add(year + strMonth);
        }
        return CtolMonDates;
    }
    
    /**
     * 
    * @Title: getDate 
    * @Description: 根据频率与
    * @param @param date
    * @param @param cont
    * @param @param step    
    * @return void  
    * @throws
     */
    public static Date getDate(Date date,int cont,String step){
    	 Calendar lastDate = Calendar.getInstance();  
    	 lastDate.setTime(date);
    	 if("M".equals(step)){
    		 lastDate.add(Calendar.MONTH, +cont);
    	 }
    	 if("Q".equals(step)){
    		 
    		 lastDate.add(Calendar.MONTH, +cont*3);
    	 }
    	 if("H".equals(step)){
    		 lastDate.add(Calendar.MONTH, +cont*6);
    	 }
    	 if("Y".equals(step)){
    		 lastDate.add(Calendar.YEAR, +cont);
    	 }
    	 return lastDate.getTime();
    }
    
    /**
     * @Description: 超过 多少号 。获得上个月份。 不超过。获得上两个月分
     * @param @return    
     * @return String   
     * @throws
    */
    @SuppressWarnings("deprecation")
    public static String getPassDate(String passDay,Date now){
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
    	String day=sdf.format(now).substring(6);
    	String resultDate="";
    	if(Integer.parseInt(day)>Integer.parseInt(passDay)){
    		now.setMonth(now.getMonth() - 1);
    		resultDate=DateUtil.getYearMonth(now);
    	}else{
    		now.setMonth(now.getMonth() - 2);
    		resultDate=DateUtil.getYearMonth(now);
    	}
    	
    	return resultDate;
    }
    /**
      * @Description: 获得分类监管日期
      * @param @return    
      * @return String   
      * @throws
     */
    public static String getClassDate(){
    	String year=getSysdate().substring(0,4);
    	String day=getSysdate().substring(8);
    	String month=getSysdate().substring(5,7);
    	String result="";
    	if(month.equals("03")||month.equals("06")||month.equals("09")||month.equals("12")){
    		if(Integer.parseInt(day)>15){
    			result=getYearMonth(new Date());
    		}else{
    			if(Integer.parseInt(month)==3){
    	    		 result=Integer.parseInt(year)-1+"12";    		
    	    		return result;
    	    	}else if(Integer.parseInt(month)==6){
    	    		 result=year+"03";    		
    	    		return result;
    	    	}else if(Integer.parseInt(month)==9){
    	    		 result=year+"06";    		
    	    		return result;
    	    	}else if(Integer.parseInt(month)==12){
    	    		 result=year+"09";    		
    	    		return result;
    	    	}
    		}
    		return result;
    	}else if(Integer.parseInt(month)<3){
    		 result=Integer.parseInt(year)-1+"12";    		
    		return result;
    	}else if(Integer.parseInt(month)<6){
    		 result=year+"03";    		
    		return result;
    	}else if(Integer.parseInt(month)<9){
    		 result=year+"06";    		
    		return result;
    	}else if(Integer.parseInt(month)<12){
    		 result=year+"09";    		
    		return result;
    	}
    	return result;
    }
    /**
     * @Description: 根据参数yyyyMM获得上个季度。
     * @param @return    
     * @return String   
     * @throws
    */
    public static String getLastQuarter(String yearmonth){
    	String result="";
    	String year=yearmonth.substring(0,4);
    	String month=yearmonth.substring(4,6);
    	if(Integer.parseInt(month)==3){
	   		 result=Integer.parseInt(year)-1+"12";    		
	   		return result;
	   	}else if(Integer.parseInt(month)==6){
	   		 result=year+"03";    		
	   		return result;
	   	}else if(Integer.parseInt(month)==9){
	   		 result=year+"06";    		
	   		return result;
	   	}else if(Integer.parseInt(month)==12){
	   		 result=year+"09";    		
	   		return result;
	   	}
    	return result;
    }
    /**
     * @Description: 获得上个月的第一天。
     * @param @param args
     * @param @throws ParseException   
     * @return void  
     * @throws
     */
    public static Date getLastMonthOneDay(Date date){
    	 Calendar calendar = Calendar.getInstance();  
     	 calendar.setTime(date);
     	 int month = calendar.get(Calendar.MONTH);
     	 if(month==1){
     		 calendar.set(Calendar.MONTH, 12);
     		 calendar.set(Calendar.DAY_OF_MONTH,1); 
	   	 }else{
	   		calendar.set(Calendar.MONTH, month-1);
	   		calendar.set(Calendar.DAY_OF_MONTH,1); 
	   	 }
    	 return calendar.getTime();
    }
    /**
     * @Description: 获得上个月的最后一天。
     * @param @param date
     * @param @return   
     * @return Date  
     * @throws
     */
    public static Date getLastMonthLastDay(Date date){
    	Calendar calendar = Calendar.getInstance();  
    	calendar.setTime(date);
    	int month = calendar.get(Calendar.MONTH);
    	calendar.set(Calendar.MONTH, month-1);
    	calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));  
    	Date strDateTo = calendar.getTime();  
        return strDateTo;
    }
    /**
     * @Description: 获得当前时间的上一个季度
     * @param @return   yyyyMM
     * @return String  
     * @throws
     */
    public static String getLastMonQ(){
    	String yearmonth=getYearMonth(new Date());
    	String year=yearmonth.substring(0,4);
    	String month=yearmonth.substring(4,6);
    	int montha=Integer.parseInt(month);
    	if((1<=montha&&montha<=3)){
    		month="12";
    		year=Integer.parseInt(year)-1+"";
    	}else if((4<=montha&&montha<=6)){
    		month="03";
    	}else if((7<=montha&&montha<=9)){
    		month="06";
    	}else if((10<=montha&&montha<=12)){
    		month="09";
    	}
    	return year+month;
    }
    /**
     * @Description: 根据yyyymm、获得往后推5年数据期次
     * @param @param yearmonth
     * @param @return   
     * @return String  
     * @throws
     * @author yokoboy
     */
    public static List<String> getAfterFiveYear(String yearmonth){
    	String year=yearmonth.substring(0,4);
    	String month=yearmonth.substring(4,6);
    	List<String> reuslt=new ArrayList<String>();
    	int intyear=Integer.parseInt(year);
    	reuslt.add(yearmonth);
    	for(int i=1;i<5;i++){
    		reuslt.add(intyear-i+""+month);
    	}
    	return reuslt;
    }
    /**
     * 传入年月 ，输出这个月的最后一天
     * @param date
     * @return
     */
    public static String getMontLastDay(String date){
    SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
   	 Calendar c1 = Calendar.getInstance();
   	 try {
		c1.setTime(sdf.parse(date));
	} catch (ParseException e) {
		e.printStackTrace();
	}
   	 return date+c1.getActualMaximum(Calendar.DAY_OF_MONTH);
   }
    public static void main(String[] args) throws ParseException {
    	System.out.println(getMontLastDay("201302"));
    }
    public static List<String> getThisYearMoth(Date dateObj,String frequency) {
    	   List<String> CtolMonDates = new ArrayList<String>();
           if (dateObj == null) {
               return CtolMonDates;
           }
           Calendar ca = Calendar.getInstance();
           ca.setTime(dateObj);
           int month = 0;
           int yeartemp = 0;
          int  year = ca.get(Calendar.YEAR);
           for (int i = 0; i < 100; i++) {
               month = ca.get(Calendar.MONTH) + 1;
               yeartemp = ca.get(Calendar.YEAR);
               String strMonth = month < 10 ? ("0" + month) : String
                       .valueOf(month);
               if ("M".equals(frequency)) {
                   ca.add(Calendar.MONTH, -1);
               }
               if ("Q".equals(frequency)) {
                   ca.add(Calendar.MONTH, -3);
               }
               if ("H".equals(frequency)) {
                   ca.add(Calendar.MONTH, -6);
               }
               if ("Y".equals(frequency)) {
                   ca.add(Calendar.MONTH, -12);
               }
               if(yeartemp!=year){
            	   break;
               }
               CtolMonDates.add(year + strMonth);
           }
           return CtolMonDates;
    }
    /**
     *  获得当前时间的最大季度月份
     * @param date
     * @return
     */
    public static Date getNowMaxQuarter(Date dateObj){
    	  Calendar ca = Calendar.getInstance();
          ca.setTime(dateObj);
          while (((ca.get(Calendar.MONTH)+1)%3)!=0) {
        	  ca.set(ca.get(Calendar.YEAR), ca.get(Calendar.MONTH)-1, ca.get(Calendar.DAY_OF_MONTH));
          }
    	return ca.getTime();
    };
    /**
     * 本年从一月开始,到现在的所有月份
     *
     * @return
     */
    @SuppressWarnings("deprecation")
	public static List<String> getThisYearMoth(Date date) {
        int i = date.getMonth() + 1;
        return getCtolMon_YearMonth(date, i, "M");
    }
}

/**
 * <p> <b>Title：</b>日期大小比较 </p> <p>
 * <b>Description：</b>实现比较接口，按照排序类型[升序,降序]排列日期集合 </p>
 *
 */
class DateComparator implements Comparator<Date> {

    int orderType;

    public DateComparator(int orderType) {
        this.orderType = orderType;
    }

    public int compare(Date d1, Date d2) {
        if (d1.getTime() > d2.getTime()) {
            if (orderType == DateUtil.DATE_ORDER_ASC) {
                return 1;
            } else {
                return -1;
            }
        } else {
            if (d1.getTime() == d2.getTime()) {
                return 0;
            } else {
                if (orderType == DateUtil.DATE_ORDER_DESC) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
    }
}
