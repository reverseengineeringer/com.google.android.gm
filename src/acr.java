import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class acr
  extends Drawable
{
  private static final float d = (float)Math.toRadians(45.0D);
  public float a;
  public int b = 2;
  private final Paint c = new Paint();
  private float e;
  private float f;
  private float g;
  private float h;
  private boolean i;
  private final Path j = new Path();
  private final int k;
  private boolean l = false;
  private float m;
  
  public acr(Context paramContext)
  {
    c.setStyle(Paint.Style.STROKE);
    c.setStrokeJoin(Paint.Join.MITER);
    c.setStrokeCap(Paint.Cap.BUTT);
    c.setAntiAlias(true);
    paramContext = paramContext.getTheme().obtainStyledAttributes(null, ack.aB, aca.A, acj.a);
    int n = paramContext.getColor(ack.aF, 0);
    if (n != c.getColor())
    {
      c.setColor(n);
      invalidateSelf();
    }
    float f1 = paramContext.getDimension(ack.aJ, 0.0F);
    if (c.getStrokeWidth() != f1)
    {
      c.setStrokeWidth(f1);
      m = ((float)(f1 / 2.0F * Math.cos(d)));
      invalidateSelf();
    }
    boolean bool = paramContext.getBoolean(ack.aI, true);
    if (i != bool)
    {
      i = bool;
      invalidateSelf();
    }
    f1 = Math.round(paramContext.getDimension(ack.aH, 0.0F));
    if (f1 != h)
    {
      h = f1;
      invalidateSelf();
    }
    k = paramContext.getDimensionPixelSize(ack.aG, 0);
    f = Math.round(paramContext.getDimension(ack.aE, 0.0F));
    e = Math.round(paramContext.getDimension(ack.aC, 0.0F));
    g = paramContext.getDimension(ack.aD, 0.0F);
    paramContext.recycle();
  }
  
  public final void a(boolean paramBoolean)
  {
    if (l != paramBoolean)
    {
      l = paramBoolean;
      invalidateSelf();
    }
  }
  
  public final void b(float paramFloat)
  {
    if (a != paramFloat)
    {
      a = paramFloat;
      invalidateSelf();
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    int n;
    float f1;
    float f2;
    switch (b)
    {
    case 2: 
    default: 
      if (kn.g(this) == 1)
      {
        n = 1;
        f1 = (float)Math.sqrt(e * e * 2.0F);
        f2 = f;
        float f6 = f2 + (f1 - f2) * a;
        f1 = f;
        float f3 = f1 + (g - f1) * a;
        float f4 = Math.round(0.0F + (m - 0.0F) * a);
        float f7 = 0.0F + (d - 0.0F) * a;
        if (n == 0) {
          break label477;
        }
        f1 = 0.0F;
        label145:
        if (n == 0) {
          break label484;
        }
        f2 = 180.0F;
        label153:
        float f5 = a;
        float f8 = (float)Math.round(f6 * Math.cos(f7));
        f6 = (float)Math.round(f6 * Math.sin(f7));
        j.rewind();
        f7 = h + c.getStrokeWidth();
        f7 += (-m - f7) * a;
        float f9 = -f3 / 2.0F;
        j.moveTo(f9 + f4, 0.0F);
        j.rLineTo(f3 - f4 * 2.0F, 0.0F);
        j.moveTo(f9, f7);
        j.rLineTo(f8, f6);
        j.moveTo(f9, -f7);
        j.rLineTo(f8, -f6);
        j.close();
        paramCanvas.save();
        f3 = c.getStrokeWidth();
        f3 = (float)((int)(localRect.height() - 3.0F * f3 - h * 2.0F) / 4 * 2 + (f3 * 1.5D + h));
        paramCanvas.translate(localRect.centerX(), f3);
        if (!i) {
          break label495;
        }
        if ((n ^ l) == 0) {
          break label489;
        }
        n = -1;
        label407:
        paramCanvas.rotate(n * ((f2 - f1) * f5 + f1));
      }
      break;
    }
    for (;;)
    {
      paramCanvas.drawPath(j, c);
      paramCanvas.restore();
      return;
      n = 0;
      break;
      n = 1;
      break;
      if (kn.g(this) == 0)
      {
        n = 1;
        break;
      }
      n = 0;
      break;
      n = 0;
      break;
      label477:
      f1 = -180.0F;
      break label145;
      label484:
      f2 = 0.0F;
      break label153;
      label489:
      n = 1;
      break label407;
      label495:
      if (n != 0) {
        paramCanvas.rotate(180.0F);
      }
    }
  }
  
  public int getIntrinsicHeight()
  {
    return k;
  }
  
  public int getIntrinsicWidth()
  {
    return k;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != c.getAlpha())
    {
      c.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    c.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
}

/* Location:
 * Qualified Name:     acr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */