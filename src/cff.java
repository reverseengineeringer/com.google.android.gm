import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;

@Deprecated
public final class cff
{
  private static final String a = cvl.a;
  private final Bitmap b;
  private final Bitmap[] c;
  private final Bitmap[] d;
  private final Rect e;
  private final int f;
  private final TextPaint g = new TextPaint();
  private final Canvas h = new Canvas();
  private final char[] i = new char[1];
  private final buy j;
  private final bva k;
  
  public cff(Resources paramResources)
  {
    this(paramResources, new buz(paramResources));
  }
  
  public cff(Resources paramResources, buy parambuy)
  {
    f = paramResources.getDimensionPixelSize(bua.Z);
    int m = paramResources.getColor(btz.x);
    Typeface localTypeface = Typeface.create("sans-serif-light", 0);
    e = new Rect();
    g.setTypeface(localTypeface);
    g.setColor(m);
    g.setTextAlign(Paint.Align.CENTER);
    g.setAntiAlias(true);
    c = new Bitmap[3];
    b = BitmapFactory.decodeResource(paramResources, bub.h);
    d = new Bitmap[3];
    j = parambuy;
    k = new bva(paramResources);
  }
  
  private final Bitmap a(cop paramcop, boolean paramBoolean)
  {
    Object localObject;
    if ((a <= 0) || (b <= 0))
    {
      cvm.d(a, "LetterTileProvider width(%d) or height(%d) is 0.", new Object[] { Integer.valueOf(a), Integer.valueOf(b) });
      localObject = null;
    }
    float f1;
    int m;
    Bitmap[] arrayOfBitmap;
    label77:
    Bitmap localBitmap;
    do
    {
      return (Bitmap)localObject;
      f1 = c;
      if (f1 != 1.0F) {
        break label178;
      }
      m = 0;
      if (!paramBoolean) {
        break label197;
      }
      arrayOfBitmap = d;
      localBitmap = arrayOfBitmap[m];
      if ((localBitmap == null) || (localBitmap.getWidth() != a)) {
        break;
      }
      localObject = localBitmap;
    } while (localBitmap.getHeight() == b);
    int i2;
    int i3;
    int n;
    int i1;
    if (paramBoolean)
    {
      localObject = b;
      i2 = a;
      i3 = b;
      n = ((Bitmap)localObject).getWidth();
      i1 = ((Bitmap)localObject).getHeight();
      if ((i2 == n) && (i3 == i1)) {
        paramcop = (cop)localObject;
      }
    }
    for (;;)
    {
      arrayOfBitmap[m] = paramcop;
      return paramcop;
      label178:
      if (f1 == 0.5F)
      {
        m = 1;
        break;
      }
      m = 2;
      break;
      label197:
      arrayOfBitmap = c;
      break label77;
      paramcop = new Matrix();
      f1 = Math.max(i2 / n, i3 / i1);
      paramcop.setScale(f1, f1);
      i2 = Math.round(i2 / f1);
      i3 = Math.round(i3 / f1);
      int i4 = (int)(n * 0.5F - i2 / 2);
      int i5 = (int)(i1 * 0.5F - i3 / 2);
      paramcop = Bitmap.createBitmap((Bitmap)localObject, Math.max(Math.min(i4, n - i2), 0), Math.max(Math.min(i5, i1 - i3), 0), i2, i3, paramcop, true);
      continue;
      paramcop = Bitmap.createBitmap(a, b, Bitmap.Config.ARGB_8888);
    }
  }
  
  public final Bitmap a(cop paramcop, int paramInt)
  {
    Bitmap localBitmap = a(paramcop, false);
    if (localBitmap == null)
    {
      cvm.d(a, "LetterTileProvider width(%d) or height(%d) is 0.", new Object[] { Integer.valueOf(a), Integer.valueOf(b) });
      return null;
    }
    Canvas localCanvas = h;
    localCanvas.setBitmap(localBitmap);
    k.setBounds(0, 0, a, b);
    k.e = paramInt;
    k.a(localCanvas, true);
    return localBitmap;
  }
  
  public final Bitmap a(cop paramcop, String paramString1, String paramString2)
  {
    Object localObject;
    if (!TextUtils.isEmpty(paramString1))
    {
      localObject = paramString1;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label84;
      }
    }
    label84:
    for (char c1 = '.';; c1 = ((String)localObject).charAt(0))
    {
      localObject = a(paramcop, false);
      if (localObject != null) {
        break label95;
      }
      cvm.d(a, "LetterTileProvider width(%d) or height(%d) is 0 for name %s and address %s.", new Object[] { Integer.valueOf(a), Integer.valueOf(b), paramString1, paramString2 });
      return null;
      localObject = paramString2;
      break;
    }
    label95:
    paramString1 = h;
    paramString1.setBitmap((Bitmap)localObject);
    paramString1.drawColor(j.a(paramString2));
    float f1;
    if (bva.a(c1))
    {
      i[0] = Character.toUpperCase(c1);
      paramString2 = g;
      if (d > 0.0F)
      {
        f1 = d;
        paramString2.setTextSize(f1);
        g.getTextBounds(i, 0, 1, e);
        paramString1.drawText(i, 0, 1, a / 2 + 0, b / 2 + 0 + (e.bottom - e.top) / 2, g);
      }
    }
    for (;;)
    {
      return (Bitmap)localObject;
      f1 = f;
      break;
      paramString1.drawBitmap(a(paramcop, true), 0.0F, 0.0F, null);
    }
  }
}

/* Location:
 * Qualified Name:     cff
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */