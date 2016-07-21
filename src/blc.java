import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.style.ImageSpan;
import android.util.Log;
import java.io.InputStream;

public final class blc
  extends ImageSpan
{
  Uri a;
  public int b;
  public int c;
  private Drawable d;
  private Context e;
  private final int f;
  
  public final Drawable getDrawable()
  {
    if (d != null) {
      return d;
    }
    if (a != null) {
      System.gc();
    }
    for (;;)
    {
      int j;
      int i;
      try
      {
        Object localObject2 = e.getContentResolver().openInputStream(a);
        Object localObject1 = new BitmapFactory.Options();
        inJustDecodeBounds = true;
        BitmapFactory.decodeStream((InputStream)localObject2, null, (BitmapFactory.Options)localObject1);
        ((InputStream)localObject2).close();
        localObject2 = e.getContentResolver().openInputStream(a);
        j = outWidth;
        i = outHeight;
        b = j;
        c = i;
        if (outWidth > f)
        {
          j = f;
          i = i * f / outWidth;
          localObject1 = BitmapFactory.decodeStream((InputStream)localObject2, new Rect(0, 0, j, i), null);
          d = new BitmapDrawable(e.getResources(), (Bitmap)localObject1);
          d.setBounds(0, 0, j, i);
          ((InputStream)localObject2).close();
          return d;
        }
        localObject1 = BitmapFactory.decodeStream((InputStream)localObject2);
        continue;
        d = super.getDrawable();
      }
      catch (Exception localException)
      {
        localObject2 = String.valueOf(a);
        Log.e("EditStyledTextSpan", String.valueOf(localObject2).length() + 25 + "Failed to loaded content " + (String)localObject2, localException);
        return null;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        Log.e("EditStyledTextSpan", "OutOfMemoryError");
        return null;
      }
      Drawable localDrawable = d;
      if (f >= 0)
      {
        int m = localDrawable.getIntrinsicWidth();
        int k = localDrawable.getIntrinsicHeight();
        i = f;
        new StringBuilder(55).append("--- rescaleBigImage:").append(m).append(",").append(k).append(",").append(i);
        j = k;
        i = m;
        if (m > f)
        {
          i = f;
          j = k * f / i;
        }
        localDrawable.setBounds(0, 0, i, j);
      }
      b = d.getIntrinsicWidth();
      c = d.getIntrinsicHeight();
    }
  }
}

/* Location:
 * Qualified Name:     blc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */