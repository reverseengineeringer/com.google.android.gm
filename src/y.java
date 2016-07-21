import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;

class y
  extends Drawable
{
  final Paint a = new Paint(1);
  final Rect b = new Rect();
  final RectF c = new RectF();
  float d;
  int e;
  int f;
  int g;
  int h;
  boolean i = true;
  float j;
  private ColorStateList k;
  private int l;
  
  public y()
  {
    a.setStyle(Paint.Style.STROKE);
  }
  
  final void a(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null) {
      l = paramColorStateList.getColorForState(getState(), l);
    }
    k = paramColorStateList;
    i = true;
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (i)
    {
      localObject1 = a;
      Object localObject2 = b;
      copyBounds((Rect)localObject2);
      f1 = d / ((Rect)localObject2).height();
      int m = km.a(e, l);
      int n = km.a(f, l);
      int i1 = km.a(km.b(f, 0), l);
      int i2 = km.a(km.b(h, 0), l);
      int i3 = km.a(h, l);
      int i4 = km.a(g, l);
      float f2 = top;
      float f3 = bottom;
      localObject2 = Shader.TileMode.CLAMP;
      ((Paint)localObject1).setShader(new LinearGradient(0.0F, f2, 0.0F, f3, new int[] { m, n, i1, i2, i3, i4 }, new float[] { 0.0F, f1, 0.5F, 0.5F, 1.0F - f1, 1.0F }, (Shader.TileMode)localObject2));
      i = false;
    }
    float f1 = a.getStrokeWidth() / 2.0F;
    Object localObject1 = c;
    copyBounds(b);
    ((RectF)localObject1).set(b);
    left += f1;
    top += f1;
    right -= f1;
    bottom -= f1;
    paramCanvas.save();
    paramCanvas.rotate(j, ((RectF)localObject1).centerX(), ((RectF)localObject1).centerY());
    paramCanvas.drawOval((RectF)localObject1, a);
    paramCanvas.restore();
  }
  
  public int getOpacity()
  {
    if (d > 0.0F) {
      return -3;
    }
    return -2;
  }
  
  public boolean getPadding(Rect paramRect)
  {
    int m = Math.round(d);
    paramRect.set(m, m, m, m);
    return true;
  }
  
  public boolean isStateful()
  {
    return ((k != null) && (k.isStateful())) || (super.isStateful());
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    i = true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    if (k != null)
    {
      int m = k.getColorForState(paramArrayOfInt, l);
      if (m != l)
      {
        i = true;
        l = m;
      }
    }
    if (i) {
      invalidateSelf();
    }
    return i;
  }
  
  public void setAlpha(int paramInt)
  {
    a.setAlpha(paramInt);
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    a.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
}

/* Location:
 * Qualified Name:     y
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */