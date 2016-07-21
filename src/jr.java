import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Environment;
import java.io.File;

public class jr
{
  public static final Drawable a(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramContext.getDrawable(paramInt);
    }
    return paramContext.getResources().getDrawable(paramInt);
  }
  
  public static File[] a(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 19) {
      return paramContext.getExternalCacheDirs();
    }
    if (i >= 8) {
      localObject = paramContext.getExternalCacheDir();
    }
    String str;
    do
    {
      return new File[] { localObject };
      localObject = Environment.getExternalStorageDirectory();
      str = paramContext.getPackageName();
      i = 0;
      paramContext = (Context)localObject;
      localObject = paramContext;
    } while (i >= 4);
    Object localObject = new String[] { "Android", "data", str, "cache" }[i];
    if (paramContext == null) {
      paramContext = new File((String)localObject);
    }
    for (;;)
    {
      i += 1;
      break;
      if (localObject != null) {
        paramContext = new File(paramContext, (String)localObject);
      }
    }
  }
  
  public static final int b(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramContext.getColor(paramInt);
    }
    return paramContext.getResources().getColor(paramInt);
  }
}

/* Location:
 * Qualified Name:     jr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */