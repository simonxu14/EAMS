package com.eams.util;

import java.sql.Timestamp;  
import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Calendar;  
import java.util.Date;  
import java.util.GregorianCalendar;  
import java.util.Map;  
import java.util.regex.Matcher;  
import java.util.regex.Pattern;  
  
import org.apache.struts2.util.StrutsTypeConverter;  
  
  
public class TimestampConverter extends StrutsTypeConverter {  
      
    private static final String TYPE_A_REG_EXP = "^(\\d{2})-(\\d{2})-(\\d{4})-$";  
    private static final String TYPE_A_FORMAT = "MM-dd-yyyy";  
      
    /** 
     * String -> Timestamp
     */  
    @Override  
    public Object convertFromString(Map context, String[] values, Class toClass) {  
    		String str=values[0];
    		SimpleDateFormat sdf=new SimpleDateFormat(TYPE_A_FORMAT);
    		try {
				Date d=sdf.parse(str);
				Timestamp tt=new Timestamp(d.getTime());
				return tt;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		return null;
    		
//        if(values == null || values.length != 1){  
//            return null;  
//        }  
//        if(!Timestamp.class.isAssignableFrom(toClass)){  
//            return null;  
//        }  
//
//        Matcher matcher = Pattern.compile(TYPE_A_REG_EXP).matcher(values[0]);  
//        if(matcher.matches()){
//            Timestamp timestamp = null;  
//            try {  
//                int month = Integer.valueOf(matcher.group(1));  
//                System.out.println(month);
//                int day = Integer.valueOf(matcher.group(2)) - 1;   
//                System.out.println(day);
//                int year = Integer.valueOf(matcher.group(3)); 
//                System.out.println(year);
//                Calendar calendar = new GregorianCalendar(year, month, day, 0, 0, 0);  
//                timestamp = new Timestamp(calendar.getTimeInMillis());  
//            } catch (Throwable e) {  
//            }  
//            return timestamp;  
//        } else {  
//            return null;  
//        }  
    }  
  
    /** 
     * Timestamp -> String 
     */  
    @Override  
    public String convertToString(Map context, Object o) {  
    	 return null;
    }
}