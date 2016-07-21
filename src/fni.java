import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;

public final class fni
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
      k = (i - m) / 2;
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
      j = (m - i) / 2;
      i = m;
    }
  }
}

/* Location:
 * Qualified Name:     fni
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */