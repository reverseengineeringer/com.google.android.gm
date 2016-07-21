import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;

public abstract class cxh
  extends AppWidgetProvider
{
  protected abstract Class<?> a();
  
  public void onDeleted(Context paramContext, int[] paramArrayOfInt)
  {
    super.onDeleted(paramContext, paramArrayOfInt);
    paramContext = cfm.a(paramContext);
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      SharedPreferences.Editor localEditor = e;
      String str = String.valueOf("widget-account-");
      localEditor.remove(String.valueOf(str).length() + 11 + str + k);
      i += 1;
    }
    e.apply();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    super.onReceive(paramContext, paramIntent);
    paramContext.startService(paramIntent.setClass(paramContext, a()));
  }
  
  public void onUpdate(Context paramContext, AppWidgetManager paramAppWidgetManager, int[] paramArrayOfInt)
  {
    super.onUpdate(paramContext, paramAppWidgetManager, paramArrayOfInt);
    paramAppWidgetManager = new Intent(paramContext, a());
    paramAppWidgetManager.putExtra("widgetIds", paramArrayOfInt);
    paramAppWidgetManager.setAction("com.android.mail.ACTION_DO_UPDATE");
    paramContext.startService(paramAppWidgetManager);
  }
}

/* Location:
 * Qualified Name:     cxh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */