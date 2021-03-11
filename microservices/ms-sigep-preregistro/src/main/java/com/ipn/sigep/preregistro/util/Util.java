package com.ipn.sigep.preregistro.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * The Class Util.
 */
public class Util {
  
  /**
   * Instantiates a new util.
   */
  private Util() {
  }

  /**
   * Parses the date.
   *
   * @param date the date
   * @return the date
   * @throws ParseException the parse exception
   */
  public static Date parseDate(String date) throws ParseException {
    SimpleDateFormat formato = new SimpleDateFormat("yyMMdd");
    return formato.parse(date);
  }
}
