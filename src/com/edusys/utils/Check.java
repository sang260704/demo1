/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sang
 */
public class Check {

    public static boolean isName(String st) {
        String pattern = "^[^!-@]+$";
        return st.matches(pattern);
    }

    public static boolean isEmail(String st) {
        String pattern = "^\\w+@\\w+\\.\\w+(\\.\\w+)*$";
        return st.matches(pattern);
    }

    public static boolean isDate(String dateString, String format) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            LocalDate.parse(dateString, formatter);
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }
    
    public static boolean isNumber(String num) {
        try {
            double temp = Double.parseDouble(num);
            if (temp >= 0) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

}
