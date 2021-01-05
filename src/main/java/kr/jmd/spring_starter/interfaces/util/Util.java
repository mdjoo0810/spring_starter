package kr.jmd.spring_starter.interfaces.util;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Util {

    static final DateTimeFormatter FULL_DATE_FORMATTER = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
    static final DateTimeFormatter LONG_DATE_FORMATTER = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
    static final DateTimeFormatter MEDIUM_DATE_FORMATTER = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
    static final DateTimeFormatter SHORT_DATE_FORMATTER = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);

}
