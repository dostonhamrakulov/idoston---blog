package com.asosiy.idoston.store;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {

    static SimpleDateFormat sdf;
    public static final String REST_SERVICE_URI = "http://localhost:8080/";

    public static String getCurrentDate(){
        sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");
        Date d = new Date();
        return sdf.format(d);
    }

    public static Date getCurrentDateinDate() throws ParseException {
        sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");
        return sdf.parse(getCurrentDate());
    }

    public static String convertDateToString(Date date){
        sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");
        Date d = date;
        return sdf.format(d);
    }
    public static Date convertStringToDate(String date) throws Exception{
        sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");
        return sdf.parse(date);
    }
}
