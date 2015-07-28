package com.android.mail;

import android.content.Context;
import android.text.format.DateUtils;
import java.util.Formatter;

public class FormattedDateBuilder
{
  private Formatter dateFormatter;
  private Context mContext;
  private StringBuilder sb;
  
  public FormattedDateBuilder(Context paramContext)
  {
    mContext = paramContext;
    sb = new StringBuilder();
    dateFormatter = new Formatter(sb);
  }
  
  public CharSequence formatLongDateTime(long paramLong)
  {
    sb.setLength(0);
    DateUtils.formatDateRange(mContext, dateFormatter, paramLong, paramLong, 524310);
    sb.append(" ");
    DateUtils.formatDateRange(mContext, dateFormatter, paramLong, paramLong, 1);
    return sb.toString();
  }
  
  public CharSequence formatShortDate(long paramLong)
  {
    return DateUtils.getRelativeTimeSpanString(mContext, paramLong);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.FormattedDateBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */