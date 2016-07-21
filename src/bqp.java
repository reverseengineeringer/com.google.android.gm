import android.content.ContentValues;
import android.content.Context;
import com.android.emailcommon.provider.Account;
import java.util.TimeZone;

public final class bqp
  extends bqo
{
  private static final TimeZone m = TimeZone.getTimeZone("UTC");
  
  private bqp(Context paramContext, Account paramAccount, Integer paramInteger, String paramString1, String paramString2, Long paramLong) {}
  
  public static void a(Context paramContext, Account paramAccount, ContentValues paramContentValues, String paramString, Long paramLong)
  {
    Integer localInteger = paramContentValues.getAsInteger("selfAttendeeStatus");
    if (paramLong == null) {}
    for (paramContentValues = paramContentValues.getAsString("_sync_id");; paramContentValues = paramContentValues.getAsString("original_sync_id"))
    {
      new bqp(paramContext, paramAccount, localInteger, paramString, paramContentValues, paramLong).p_();
      return;
    }
  }
  
  protected final int c(int paramInt)
  {
    int i = 1;
    switch (paramInt)
    {
    case 3: 
    default: 
      cvm.e("Exchange", "Bad attendeeStatus value: %d", new Object[] { Integer.valueOf(paramInt) });
      i = -1;
    case 1: 
      return i;
    case 4: 
      return 2;
    }
    return 3;
  }
}

/* Location:
 * Qualified Name:     bqp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */