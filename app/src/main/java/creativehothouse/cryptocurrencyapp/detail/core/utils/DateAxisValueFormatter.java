package creativehothouse.cryptocurrencyapp.detail.core.utils;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateAxisValueFormatter implements IAxisValueFormatter {

  private long referenceTimestamp;
  private DateFormat mDataFormat;
  private Date mDate;

  public DateAxisValueFormatter(long referenceTimestamp) {
    this.referenceTimestamp = referenceTimestamp;
    this.mDataFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    this.mDate = new Date();
  }

  @Override
  public String getFormattedValue(float value, AxisBase axis) {
    long convertedTimestamp = (long) value;
    long originalTimestamp = referenceTimestamp + convertedTimestamp;
    return getParsedData(originalTimestamp);
  }

  private String getParsedData(long timestamp) {
    try {
      mDate.setTime(timestamp);
      return mDataFormat.format(mDate);
    } catch (Exception ex) {
      return "xx";
    }
  }
}