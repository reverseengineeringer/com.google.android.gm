import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.android.mail.widget.BaseGmailWidgetProviderService;

public class cxg
  extends cxh
{
  protected final Class<?> a()
  {
    return BaseGmailWidgetProviderService.class;
  }
  
  public void onDeleted(Context paramContext, int[] paramArrayOfInt)
  {
    super.onDeleted(paramContext, paramArrayOfInt);
    dmv.a();
    paramContext = dmv.a(paramContext).edit();
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      String str = String.valueOf("widget-account-");
      int j = paramArrayOfInt[i];
      paramContext.remove(String.valueOf(str).length() + 11 + str + j);
      i += 1;
    }
    paramContext.apply();
  }
}

/* Location:
 * Qualified Name:     cxg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */