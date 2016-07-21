import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.util.Log;
import android.view.View;
import android.view.Window;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public final class fkr
{
  public static Bitmap a(Activity paramActivity)
  {
    FutureTask localFutureTask = new FutureTask(new fks(paramActivity));
    paramActivity.runOnUiThread(localFutureTask);
    try
    {
      paramActivity = (Bitmap)localFutureTask.get();
      return paramActivity;
    }
    catch (InterruptedException paramActivity)
    {
      Log.w("gH_Utils", "Taking screenshot failed!");
      return null;
    }
    catch (ExecutionException paramActivity)
    {
      for (;;) {}
    }
  }
  
  static Bitmap b(Activity paramActivity)
  {
    int i = 0;
    try
    {
      View localView1 = paramActivity.getWindow().getDecorView().getRootView();
      View localView2 = localView1.findViewById(16908290);
      if (localView2 == null) {
        return null;
      }
      int j = paramActivity.getResources().getIdentifier("status_bar_height", "dimen", "android");
      if (j != 0) {
        i = paramActivity.getResources().getDimensionPixelSize(j);
      }
      i += localView2.getTop();
      if (i < localView1.getHeight())
      {
        paramActivity = Bitmap.createBitmap(localView1.getWidth(), localView1.getHeight(), Bitmap.Config.ARGB_8888);
        localView1.draw(new Canvas(paramActivity));
        j = Math.min(paramActivity.getHeight() - i, localView2.getHeight());
        paramActivity = Bitmap.createBitmap(paramActivity, 0, i, paramActivity.getWidth(), j);
        return paramActivity;
      }
    }
    catch (Exception paramActivity)
    {
      Log.w("gH_Utils", "Get screenshot failed!", paramActivity);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     fkr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */