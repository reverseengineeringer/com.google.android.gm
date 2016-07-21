import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.UUID;

public final class aqv
{
  private static aqv b;
  public final SharedPreferences a;
  
  private aqv(Context paramContext)
  {
    a = paramContext.getSharedPreferences("AndroidMail.Main", 0);
  }
  
  public static aqv a(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = new aqv(paramContext);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  public final String a()
  {
    try
    {
      String str2 = a.getString("deviceUID", null);
      String str1 = str2;
      if (str2 == null)
      {
        str1 = UUID.randomUUID().toString();
        a.edit().putString("deviceUID", str1).apply();
      }
      return str1;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     aqv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */