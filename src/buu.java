import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import java.util.LinkedHashSet;

public abstract class buu
  extends Drawable
  implements bve
{
  final Resources a;
  public anf b;
  public bvd c;
  bvb d;
  public int e = 0;
  public final Paint f;
  private ann g;
  private final float h;
  private final Paint i;
  private final Matrix j;
  private int k;
  private int l;
  
  public buu(Resources paramResources)
  {
    a = paramResources;
    f = new Paint();
    f.setAntiAlias(true);
    f.setFilterBitmap(true);
    f.setDither(true);
    float f1 = 0.0F;
    try
    {
      int m = paramResources.getDimensionPixelSize(bua.j);
      f1 = m;
    }
    catch (Resources.NotFoundException paramResources)
    {
      for (;;) {}
    }
    h = f1;
    i = new Paint();
    i.setColor(0);
    i.setStyle(Paint.Style.STROKE);
    i.setStrokeWidth(h);
    i.setAntiAlias(true);
    j = new Matrix();
  }
  
  static void a(Canvas paramCanvas, Rect paramRect, Paint paramPaint)
  {
    paramCanvas.drawCircle(paramRect.centerX(), paramRect.centerY(), paramRect.width() / 2, paramPaint);
  }
  
  private final void a(ann paramann)
  {
    if ((g != null) && (g != paramann)) {
      g.e();
    }
    g = paramann;
    invalidateSelf();
  }
  
  public final int a()
  {
    return k;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    k = paramInt1;
    l = paramInt2;
  }
  
  final void a(Bitmap paramBitmap, int paramInt1, int paramInt2, Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    paramBitmap = new BitmapShader(paramBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    j.reset();
    float f1 = localRect.width();
    float f2 = localRect.height();
    f1 = Math.max(f1 / paramInt1, f2 / paramInt2);
    j.postScale(f1, f1);
    j.postTranslate(left, top);
    paramBitmap.setLocalMatrix(j);
    f.setShader(paramBitmap);
    a(paramCanvas, localRect, f);
    f1 = localRect.width() / 2.0F;
    f2 = h / 2.0F;
    paramCanvas.drawCircle(localRect.centerX(), localRect.centerY(), f1 - f2, i);
  }
  
  protected abstract void a(Canvas paramCanvas);
  
  public final void a(anl paramanl, ann paramann)
  {
    paramanl = (bvb)paramanl;
    c.a(paramanl, this);
    if (paramanl.equals(d)) {
      a(paramann);
    }
    while (paramann == null) {
      return;
    }
    paramann.e();
  }
  
  public final void a(bvb parambvb)
  {
    Object localObject = null;
    if ((d != null) && (d.equals(parambvb))) {}
    do
    {
      return;
      if (g != null)
      {
        g.e();
        g = null;
      }
      if (c != null) {
        c.a(d, this);
      }
      d = parambvb;
      if (parambvb == null)
      {
        invalidateSelf();
        return;
      }
      if (b != null) {
        localObject = (ann)b.a(parambvb);
      }
      if (localObject != null)
      {
        a((ann)localObject);
        return;
      }
    } while ((d == null) || (c == null));
    parambvb = c;
    localObject = d;
    d.add(new bvc((bvb)localObject, this));
    parambvb.a();
  }
  
  public final void a(String paramString1, String paramString2)
  {
    a(new bvb(paramString1, paramString2));
  }
  
  public final int b()
  {
    return l;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    if ((!isVisible()) || (localRect.isEmpty())) {
      return;
    }
    if ((g != null) && (g.a != null))
    {
      a(g.a, g.b, g.c, paramCanvas);
      return;
    }
    a(paramCanvas);
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void setAlpha(int paramInt)
  {
    f.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    f.setColorFilter(paramColorFilter);
  }
}

/* Location:
 * Qualified Name:     buu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */