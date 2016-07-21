import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public final class ctp
{
  public static void a(Activity paramActivity, Context paramContext)
  {
    Object localObject;
    int j;
    int i;
    if (cxd.f())
    {
      paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
      localObject = new DisplayMetrics();
      paramContext.getRealMetrics((DisplayMetrics)localObject);
      float f1 = heightPixels / density;
      float f2 = widthPixels / density;
      j = Math.round(Math.min(f1, f2));
      if (j < 600) {
        break label169;
      }
      i = 1;
      if (i != 0)
      {
        localObject = new Configuration();
        if (f2 <= f1) {
          break label175;
        }
        i = 1;
        label106:
        if (i == 0) {
          break label187;
        }
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        paramContext.getMetrics(localDisplayMetrics);
        if (widthPixels / density >= 0.8F * f2) {
          break label181;
        }
        i = 1;
        label149:
        if (i == 0) {}
      }
    }
    for (smallestScreenWidthDp = 599;; smallestScreenWidthDp = j)
    {
      paramActivity.applyOverrideConfiguration((Configuration)localObject);
      return;
      label169:
      i = 0;
      break;
      label175:
      i = 0;
      break label106;
      label181:
      i = 0;
      break label149;
      label187:
      orientation = 1;
    }
  }
}

/* Location:
 * Qualified Name:     ctp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */