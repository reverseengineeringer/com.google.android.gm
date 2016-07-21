import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.util.Log;

public final class fto
{
  public static Bitmap a(Bitmap paramBitmap)
  {
    int k = 0;
    if (paramBitmap == null) {
      return null;
    }
    int m = paramBitmap.getWidth();
    int i = paramBitmap.getHeight();
    int j;
    if (m >= i)
    {
      k = m / 2 - i / 2;
      j = 0;
    }
    for (;;)
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint(1);
      localPaint.setColor(-16777216);
      localCanvas.drawCircle(i / 2, i / 2, i / 2, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramBitmap, k, j, localPaint);
      return localBitmap;
      j = i / 2 - m / 2;
      i = m;
    }
  }
  
  public static boolean a(fyb paramfyb)
  {
    boolean bool1;
    if (paramfyb == null) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      if (!(paramfyb instanceof eln)) {
        break;
      }
      bool2 = ((eln)paramfyb).a();
      bool1 = bool2;
    } while (bool2);
    Log.w("Utils", "Owner is freezable and isDataValid returned false -- invalid Owner!");
    return bool2;
    return true;
  }
}

/* Location:
 * Qualified Name:     fto
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */