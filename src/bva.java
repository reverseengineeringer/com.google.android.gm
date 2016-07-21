import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;

public final class bva
  extends buu
{
  private static Typeface h;
  private static Typeface i;
  private static int j;
  private static int k;
  private static int l;
  private static int m;
  private static int n;
  private static int o;
  private static int p;
  private static Bitmap q;
  private static final Paint r = new Paint();
  private static final Rect s = new Rect();
  private static Path t = null;
  private static Path u = null;
  private static final char[] v = new char[1];
  public buy g;
  
  public bva(Resources paramResources)
  {
    super(paramResources);
    if (j == 0)
    {
      j = paramResources.getDimensionPixelSize(bua.Z);
      k = paramResources.getDimensionPixelSize(bua.Y);
      l = paramResources.getColor(btz.x);
      m = paramResources.getColor(btz.y);
      n = paramResources.getColor(btz.z);
      o = paramResources.getColor(btz.u);
      p = paramResources.getColor(btz.v);
      q = BitmapFactory.decodeResource(paramResources, bub.h);
      h = Typeface.create("sans-serif-light", 0);
      i = Typeface.create("sans-serif-light", 1);
      r.setTextAlign(Paint.Align.CENTER);
      r.setAntiAlias(true);
    }
  }
  
  private static void a(Canvas paramCanvas, Rect paramRect, Typeface paramTypeface, int paramInt1, int paramInt2)
  {
    r.setTypeface(paramTypeface);
    r.setTextSize(paramInt2);
    r.getTextBounds(v, 0, 1, s);
    r.setColor(paramInt1);
    paramCanvas.drawText(v, 0, 1, paramRect.centerX(), paramRect.centerY() + s.height() / 2, r);
  }
  
  public static boolean a(int paramInt)
  {
    if (!Character.isLetterOrDigit(paramInt)) {}
    while (((32 > paramInt) || (paramInt > 591)) && ((880 > paramInt) || (paramInt > 1327))) {
      return false;
    }
    return true;
  }
  
  private static Path b(int paramInt)
  {
    Path localPath = new Path();
    float f1 = paramInt / 2.41F;
    float f2 = (paramInt - f1) / 2.0F;
    localPath.moveTo(f2, 0.0F);
    localPath.lineTo(f2 + f1, 0.0F);
    localPath.lineTo(paramInt, f2);
    localPath.lineTo(paramInt, f2 + f1);
    localPath.lineTo(f2 + f1, paramInt);
    localPath.lineTo(f2, paramInt);
    localPath.lineTo(0.0F, f1 + f2);
    localPath.lineTo(0.0F, f2);
    localPath.close();
    return localPath;
  }
  
  protected final void a(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    r.setAlpha(f.getAlpha());
    if (e != 0) {
      a(paramCanvas, false);
    }
    while (d == null) {
      return;
    }
    Object localObject = d.b;
    Paint localPaint = r;
    if (g == null) {
      g = new buz(a);
    }
    localPaint.setColor(g.a((String)localObject));
    a(paramCanvas, localRect, r);
    localObject = d;
    if (!TextUtils.isEmpty(a)) {}
    for (localObject = a;; localObject = b)
    {
      char c = ((String)localObject).charAt(0);
      if (!a(c)) {
        break;
      }
      v[0] = Character.toUpperCase(c);
      a(paramCanvas, localRect, h, l, j);
      return;
    }
    a(q, q.getWidth(), q.getHeight(), paramCanvas);
  }
  
  public final void a(Canvas paramCanvas, boolean paramBoolean)
  {
    Rect localRect = getBounds();
    int i1;
    Object localObject;
    switch (e)
    {
    default: 
      return;
    case 1: 
      i2 = o;
      i1 = m;
      v[0] = '!';
      r.setColor(i2);
      i2 = localRect.width();
      if (paramBoolean)
      {
        if (u == null) {
          u = b(i2);
        }
        localObject = u;
        label87:
        paramCanvas.drawPath((Path)localObject, r);
        localObject = i;
        if (!paramBoolean) {
          break label163;
        }
      }
      break;
    }
    label163:
    for (int i2 = k;; i2 = j)
    {
      a(paramCanvas, localRect, (Typeface)localObject, i1, i2);
      return;
      i2 = p;
      i1 = n;
      v[0] = '?';
      break;
      if (t == null) {
        t = b(i2);
      }
      localObject = t;
      break label87;
    }
  }
}

/* Location:
 * Qualified Name:     bva
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */