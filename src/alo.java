import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;

final class alo
  extends Drawable
{
  static final double a = Math.cos(Math.toRadians(45.0D));
  static alp c;
  final int b;
  Paint d;
  Paint e;
  Paint f;
  final RectF g;
  float h;
  Path i;
  float j;
  float k;
  float l;
  float m;
  boolean n = true;
  private boolean o = true;
  private final int p;
  private final int q;
  private boolean r = false;
  
  alo(Resources paramResources, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    p = paramResources.getColor(acm.d);
    q = paramResources.getColor(acm.c);
    b = paramResources.getDimensionPixelSize(acn.a);
    d = new Paint(5);
    d.setColor(paramInt);
    e = new Paint(5);
    e.setStyle(Paint.Style.FILL);
    h = ((int)(paramFloat1 + 0.5F));
    g = new RectF();
    f = new Paint(e);
    f.setAntiAlias(false);
    if (paramFloat2 < 0.0F) {
      throw new IllegalArgumentException("Invalid shadow size " + paramFloat2 + ". Must be >= 0");
    }
    if (paramFloat3 < 0.0F) {
      throw new IllegalArgumentException("Invalid max shadow size " + paramFloat3 + ". Must be >= 0");
    }
    paramFloat2 = a(paramFloat2);
    paramFloat3 = a(paramFloat3);
    paramFloat1 = paramFloat2;
    if (paramFloat2 > paramFloat3)
    {
      if (!r) {
        r = true;
      }
      paramFloat1 = paramFloat3;
    }
    if ((m != paramFloat1) || (k != paramFloat3))
    {
      m = paramFloat1;
      k = paramFloat3;
      l = ((int)(paramFloat1 * 1.5F + b + 0.5F));
      j = (b + paramFloat3);
      o = true;
      invalidateSelf();
    }
  }
  
  static float a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return (float)(1.5F * paramFloat1 + (1.0D - a) * paramFloat2);
    }
    return 1.5F * paramFloat1;
  }
  
  private static int a(float paramFloat)
  {
    int i2 = (int)(0.5F + paramFloat);
    int i1 = i2;
    if (i2 % 2 == 1) {
      i1 = i2 - 1;
    }
    return i1;
  }
  
  static float b(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    float f1 = paramFloat1;
    if (paramBoolean) {
      f1 = (float)(paramFloat1 + (1.0D - a) * paramFloat2);
    }
    return f1;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    int i2 = 1;
    float f1;
    float f2;
    float f3;
    int i1;
    int i3;
    float f4;
    if (o)
    {
      Object localObject1 = getBounds();
      f1 = k * 1.5F;
      g.set(left + k, top + f1, right - k, bottom - f1);
      localObject1 = new RectF(-h, -h, h, h);
      Object localObject2 = new RectF((RectF)localObject1);
      ((RectF)localObject2).inset(-l, -l);
      if (i == null)
      {
        i = new Path();
        i.setFillType(Path.FillType.EVEN_ODD);
        i.moveTo(-h, 0.0F);
        i.rLineTo(-l, 0.0F);
        i.arcTo((RectF)localObject2, 180.0F, 90.0F, false);
        i.arcTo((RectF)localObject1, 270.0F, -90.0F, false);
        i.close();
        f1 = h / (h + l);
        localObject1 = e;
        f2 = h;
        f3 = l;
        i1 = p;
        i3 = p;
        int i4 = q;
        localObject2 = Shader.TileMode.CLAMP;
        ((Paint)localObject1).setShader(new RadialGradient(0.0F, 0.0F, f2 + f3, new int[] { i1, i3, i4 }, new float[] { 0.0F, f1, 1.0F }, (Shader.TileMode)localObject2));
        localObject1 = f;
        f1 = -h;
        f2 = l;
        f3 = -h;
        f4 = l;
        i1 = p;
        i3 = p;
        i4 = q;
        localObject2 = Shader.TileMode.CLAMP;
        ((Paint)localObject1).setShader(new LinearGradient(0.0F, f1 + f2, 0.0F, f3 - f4, new int[] { i1, i3, i4 }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject2));
        f.setAntiAlias(false);
        o = false;
      }
    }
    else
    {
      paramCanvas.translate(0.0F, m / 2.0F);
      f1 = -h - l;
      f2 = h + b + m / 2.0F;
      if (g.width() - 2.0F * f2 <= 0.0F) {
        break label903;
      }
      i1 = 1;
      label504:
      if (g.height() - 2.0F * f2 <= 0.0F) {
        break label909;
      }
    }
    for (;;)
    {
      i3 = paramCanvas.save();
      paramCanvas.translate(g.left + f2, g.top + f2);
      paramCanvas.drawPath(i, e);
      if (i1 != 0) {
        paramCanvas.drawRect(0.0F, f1, g.width() - 2.0F * f2, -h, f);
      }
      paramCanvas.restoreToCount(i3);
      i3 = paramCanvas.save();
      paramCanvas.translate(g.right - f2, g.bottom - f2);
      paramCanvas.rotate(180.0F);
      paramCanvas.drawPath(i, e);
      if (i1 != 0)
      {
        f3 = g.width();
        f4 = -h;
        paramCanvas.drawRect(0.0F, f1, f3 - 2.0F * f2, l + f4, f);
      }
      paramCanvas.restoreToCount(i3);
      i1 = paramCanvas.save();
      paramCanvas.translate(g.left + f2, g.bottom - f2);
      paramCanvas.rotate(270.0F);
      paramCanvas.drawPath(i, e);
      if (i2 != 0) {
        paramCanvas.drawRect(0.0F, f1, g.height() - 2.0F * f2, -h, f);
      }
      paramCanvas.restoreToCount(i1);
      i1 = paramCanvas.save();
      paramCanvas.translate(g.right - f2, g.top + f2);
      paramCanvas.rotate(90.0F);
      paramCanvas.drawPath(i, e);
      if (i2 != 0) {
        paramCanvas.drawRect(0.0F, f1, g.height() - 2.0F * f2, -h, f);
      }
      paramCanvas.restoreToCount(i1);
      paramCanvas.translate(0.0F, -m / 2.0F);
      c.a(paramCanvas, g, h, d);
      return;
      i.reset();
      break;
      label903:
      i1 = 0;
      break label504;
      label909:
      i2 = 0;
    }
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final boolean getPadding(Rect paramRect)
  {
    int i1 = (int)Math.ceil(a(k, h, n));
    int i2 = (int)Math.ceil(b(k, h, n));
    paramRect.set(i2, i1, i2, i1);
    return true;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    o = true;
  }
  
  public final void setAlpha(int paramInt)
  {
    d.setAlpha(paramInt);
    e.setAlpha(paramInt);
    f.setAlpha(paramInt);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    d.setColorFilter(paramColorFilter);
  }
}

/* Location:
 * Qualified Name:     alo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */