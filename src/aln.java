import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

final class aln
  extends Drawable
{
  float a;
  float b;
  boolean c = false;
  boolean d = true;
  private final Paint e;
  private final RectF f;
  private final Rect g;
  private PorterDuffColorFilter h;
  private ColorStateList i;
  private PorterDuff.Mode j = PorterDuff.Mode.SRC_IN;
  
  public aln(int paramInt, float paramFloat)
  {
    a = paramFloat;
    e = new Paint(5);
    e.setColor(paramInt);
    f = new RectF();
    g = new Rect();
  }
  
  private final PorterDuffColorFilter a(ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    if ((paramColorStateList == null) || (paramMode == null)) {
      return null;
    }
    return new PorterDuffColorFilter(paramColorStateList.getColorForState(getState(), 0), paramMode);
  }
  
  final void a(Rect paramRect)
  {
    Rect localRect = paramRect;
    if (paramRect == null) {
      localRect = getBounds();
    }
    f.set(left, top, right, bottom);
    g.set(localRect);
    if (c)
    {
      float f1 = alo.a(b, a, d);
      float f2 = alo.b(b, a, d);
      g.inset((int)Math.ceil(f2), (int)Math.ceil(f1));
      f.set(g);
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Paint localPaint = e;
    if ((h != null) && (localPaint.getColorFilter() == null)) {
      localPaint.setColorFilter(h);
    }
    for (int k = 1;; k = 0)
    {
      paramCanvas.drawRoundRect(f, a, a, localPaint);
      if (k != 0) {
        localPaint.setColorFilter(null);
      }
      return;
    }
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void getOutline(Outline paramOutline)
  {
    paramOutline.setRoundRect(g, a);
  }
  
  public final boolean isStateful()
  {
    return ((i != null) && (i.isStateful())) || (super.isStateful());
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    a(paramRect);
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    if ((i != null) && (j != null))
    {
      h = a(i, j);
      return true;
    }
    return false;
  }
  
  public final void setAlpha(int paramInt)
  {
    e.setAlpha(paramInt);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    e.setColorFilter(paramColorFilter);
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    i = paramColorStateList;
    h = a(i, j);
    invalidateSelf();
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    j = paramMode;
    h = a(i, j);
    invalidateSelf();
  }
}

/* Location:
 * Qualified Name:     aln
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */