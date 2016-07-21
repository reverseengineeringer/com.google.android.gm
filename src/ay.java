import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.ViewTreeObserver.OnPreDrawListener;

public abstract class ay
{
  static final int[] j = { 16842919, 16842910 };
  static final int[] k = { 16842908, 16842910 };
  static final int[] l = new int[0];
  private final Rect a = new Rect();
  Drawable d;
  Drawable e;
  y f;
  Drawable g;
  public float h;
  public float i;
  public final di m;
  final bi n;
  public ViewTreeObserver.OnPreDrawListener o;
  
  ay(di paramdi, bi parambi)
  {
    m = paramdi;
    n = parambi;
  }
  
  static GradientDrawable f()
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(1);
    localGradientDrawable.setColor(-1);
    return localGradientDrawable;
  }
  
  final y a(int paramInt, ColorStateList paramColorStateList)
  {
    Resources localResources = m.getResources();
    y localy = e();
    int i1 = localResources.getColor(d.g);
    int i2 = localResources.getColor(d.f);
    int i3 = localResources.getColor(d.d);
    int i4 = localResources.getColor(d.e);
    e = i1;
    f = i2;
    g = i3;
    h = i4;
    float f1 = paramInt;
    if (d != f1)
    {
      d = f1;
      a.setStrokeWidth(f1 * 1.3333F);
      i = true;
      localy.invalidateSelf();
    }
    localy.a(paramColorStateList);
    return localy;
  }
  
  public abstract void a();
  
  public abstract void a(float paramFloat);
  
  public abstract void a(ColorStateList paramColorStateList);
  
  public abstract void a(ColorStateList paramColorStateList, PorterDuff.Mode paramMode, int paramInt1, int paramInt2);
  
  public abstract void a(PorterDuff.Mode paramMode);
  
  abstract void a(Rect paramRect);
  
  public abstract void a(ba paramba, boolean paramBoolean);
  
  public abstract void a(int[] paramArrayOfInt);
  
  public abstract void b(float paramFloat);
  
  void b(Rect paramRect) {}
  
  public abstract void b(ba paramba, boolean paramBoolean);
  
  public boolean b()
  {
    return false;
  }
  
  void c() {}
  
  public final void d()
  {
    Rect localRect = a;
    a(localRect);
    b(localRect);
    n.a(left, top, right, bottom);
  }
  
  y e()
  {
    return new y();
  }
}

/* Location:
 * Qualified Name:     ay
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */