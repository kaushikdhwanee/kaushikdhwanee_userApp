package com.prolificinteractive.materialcalendarview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.Gravity;
import android.widget.TextView;

import com.prolificinteractive.materialcalendarview.format.WeekDayFormatter;

import java.util.Calendar;

/**
 * Display a day of the week
 */
@SuppressLint("ViewConstructor")
class WeekDayView extends TextView {

    private WeekDayFormatter formatter = WeekDayFormatter.DEFAULT;
    private int dayOfWeek;

    public WeekDayView(Context context, int dayOfWeek) {
        super(context);

        setGravity(Gravity.CENTER);
        setBackgroundColor(Color.TRANSPARENT);
     //   setBackgroundColor(Color.WHITE);
        setTextColor(Color.parseColor("#00aeef"));
//        setBackgroundColor(Color.RED);
//        setTextColor(Color.WHITE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            setTextAlignment(TEXT_ALIGNMENT_CENTER);
        }

        setDayOfWeek(dayOfWeek);
    }

    public void setWeekDayFormatter(WeekDayFormatter formatter) {
        this.formatter = formatter == null ? WeekDayFormatter.DEFAULT : formatter;
        setDayOfWeek(dayOfWeek);
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
        setText(formatter.format(dayOfWeek));
    }

    public void setDayOfWeek(Calendar calendar) {
        setDayOfWeek(CalendarUtils.getDayOfWeek(calendar));
    }
}
