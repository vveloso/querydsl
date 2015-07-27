package com.querydsl.sql.types;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.util.Calendar;
import java.util.TimeZone;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public abstract class AbstractJSR310DateTimeTypeTest<T extends Temporal> {

    protected static final Calendar UTC = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

    static {
        UTC.setTimeInMillis(0);
    }

    protected final AbstractJSR310DateTimeType<T> type;

    public AbstractJSR310DateTimeTypeTest(AbstractJSR310DateTimeType<T> type) {
        this.type = type;
    }

    protected static org.joda.time.LocalDate toJoda(LocalDate value) {
        return new org.joda.time.LocalDate(value.getYear(),
                                           value.getMonthValue(),
                                           value.getDayOfMonth());
    }

    protected static org.joda.time.LocalDateTime toJoda(LocalDateTime value) {
        return new org.joda.time.LocalDateTime(value.getYear(),
                                               value.getMonthValue(),
                                               value.getDayOfMonth(),
                                               value.getHour(),
                                               value.getMinute(),
                                               value.getSecond(),
                                               value.get(ChronoField.MILLI_OF_SECOND));
    }

    protected static org.joda.time.LocalTime toJoda(LocalTime value) {
        return new org.joda.time.LocalTime(value.getHour(),
                                           value.getMinute(),
                                           value.getSecond(),
                                           value.get(ChronoField.MILLI_OF_SECOND));
    }

    protected static DateTime toJoda(Instant value) {
        return new DateTime(value.toEpochMilli(), DateTimeZone.UTC);
    }

    protected static org.joda.time.DateTime toJoda(ZonedDateTime value) {
        DateTimeZone zone = DateTimeZone.forID(value.getZone().getId());
        return new org.joda.time.DateTime(value.toInstant().toEpochMilli(), zone);
    }

    protected static org.joda.time.DateTime toJoda(OffsetDateTime value) {
        return new org.joda.time.DateTime(value.toInstant().toEpochMilli());
    }

}
