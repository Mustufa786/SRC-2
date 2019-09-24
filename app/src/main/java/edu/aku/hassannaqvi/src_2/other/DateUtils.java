package edu.aku.hassannaqvi.src_2.other;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by gul.sanober on 3/21/2018.
 */

public class DateUtils {


    public static String getThreeDaysBack(String format, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(cal.getTime());
        cal.add(Calendar.DATE, days);
        return new SimpleDateFormat(format).format(cal.getTime()); //"dd-MM-yyyy HH:mm"
    }


    public static Calendar getCalendarDate(String value) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar calendar = Calendar.getInstance();
        try {
            Date date = sdf.parse(value);
            calendar.setTime(date);
            return calendar;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar;
    }

    public static Calendar getCalendarDate(String dd, String mm, String yy) {

        String dob = String.format("%02d", Integer.valueOf(dd)) + "-"
                + String.format("%02d", Integer.valueOf(mm))
                + "-" + yy;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar calendar = Calendar.getInstance();
        try {
            Date date = sdf.parse(dob);
            calendar.setTime(date);
            return calendar;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar;
    }

    public static Calendar getCalendarDate(String mm, String yy) {

        String dob = String.format("%02d", Integer.valueOf("01")) + "-"
                + String.format("%02d", Integer.valueOf(mm))
                + "-" + yy;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar calendar = Calendar.getInstance();
        try {
            Date date = sdf.parse(dob);
            calendar.setTime(date);
            return calendar;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar;
    }


    public static long ageInYearByDOB(String year) {
        Calendar cal = Calendar.getInstance();
        long yearofbirth = Integer.valueOf(year);
        Long ageInYears = cal.get(Calendar.YEAR) - yearofbirth;
        //long ageInYears = (diff / (24 * 60 * 60 * 1000)) / 365;
        return ageInYears;
    }

    public static long ageInYearByDOB(Calendar cal) {
        Date dob = cal.getTime();
        Date today = new Date();
        Long diff = today.getTime() - dob.getTime();
        double ageInYears = (diff / (24 * 60 * 60 * 1000)) / 365.25;
        long age = (long) Math.floor(ageInYears);
        return age;
    }

    public static double ageInYearByDOBdouble(Calendar cal) {
        Date dob = cal.getTime();
        Date today = new Date();
        Long diff = today.getTime() - dob.getTime();
        double ageInYears = (diff / (24 * 60 * 60 * 1000)) / 365.25;
//        double age = (double) Math.floor(ageInYears);
        double age = Math.ceil(ageInYears);
        return age;
    }

    public static long ageInMonthsByDOB(Calendar cal) {
        Date dob = cal.getTime();
        Date today = new Date();
        Long diff = today.getTime() - dob.getTime();
        double ageInMonths = (diff / (24 * 60 * 60 * 1000)) / 30.4375;
        long age = (long) Math.floor(ageInMonths);
        return age;
    }

    public static int getCurrentYear() {
        Date date = new Date(); // Current date
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        //int year = cal.get(Calendar.YEAR);

        return cal.get(Calendar.YEAR);
    }

    public static int getCurrentMonth() {
        Date date = new Date(); // Current date
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        //int year = cal.get(Calendar.MONTH);

        return cal.get(Calendar.MONTH);
    }

    public static int getCurrentDate() {
        Date date = new Date(); // Current date
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        //int year = cal.get(Calendar.DAY_OF_MONTH);

        return cal.get(Calendar.DAY_OF_MONTH);
    }

//    public static AgeModel calculateAge(long birthDate) {
//        int years = 0;
//        int months = 0;
//        int days = 0;
//
//        if (birthDate != 0) {
//            //create calendar object for birth day
//            Calendar birthDay = Calendar.getInstance();
//            birthDay.setTimeInMillis(birthDate);
//
//            //create calendar object for current day
//            Calendar now = Calendar.getInstance();
//            Calendar current = Calendar.getInstance();
//            //Get difference between years
//            years = now.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
//
//            //get months
//            int currMonth = now.get(Calendar.MONTH) + 1;
//            int birthMonth = birthDay.get(Calendar.MONTH) + 1;
//
//            //Get difference between months
//            months = currMonth - birthMonth;
//
//            //if month difference is in negative then reduce years by one and calculate the number of months.
//            if (months < 0) {
//                years--;
//                months = 12 - birthMonth + currMonth;
//            } else if (months == 0 && now.get(Calendar.DATE) < birthDay.get(Calendar.DATE)) {
//                years--;
//                months = 11;
//            }
//
//            //Calculate the days
//            if (now.get(Calendar.DATE) > birthDay.get(Calendar.DATE))
//                days = now.get(Calendar.DATE) - birthDay.get(Calendar.DATE);
//            else if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE)) {
//                int today = now.get(Calendar.DAY_OF_MONTH);
//                now.add(Calendar.MONTH, -1);
//                days = now.getActualMaximum(Calendar.DAY_OF_MONTH) - birthDay.get(Calendar.DAY_OF_MONTH) + today;
//            } else {
//                days = 0;
//                if (months == 12) {
//                    years++;
//                    months = 0;
//                }
//            }
//        }
//
//        //Create new Age object
//        return new AgeModel(days, months, years);
//    }

}
