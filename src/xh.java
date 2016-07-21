import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable.Callback;

final class xh
{
  final RectF a = new RectF();
  final Paint b = new Paint();
  final Paint c = new Paint();
  float d = 0.0F;
  float e = 0.0F;
  float f = 0.0F;
  float g = 5.0F;
  float h = 2.5F;
  int[] i;
  int j;
  float k;
  float l;
  float m;
  boolean n;
  Path o;
  float p;
  double q;
  int r;
  int s;
  int t;
  final Paint u = new Paint(1);
  int v;
  int w;
  private final Drawable.Callback x;
  
  public xh(Drawable.Callback paramCallback)
  {
    x = paramCallback;
    b.setStrokeCap(Paint.Cap.SQUARE);
    b.setAntiAlias(true);
    b.setStyle(Paint.Style.STROKE);
    c.setStyle(Paint.Style.FILL);
    c.setAntiAlias(true);
  }
  
  final int a()
  {
    return (j + 1) % i.length;
  }
  
  public final void a(float paramFloat)
  {
    d = paramFloat;
    d();
  }
  
  public final void a(int paramInt)
  {
    j = paramInt;
    w = i[j];
  }
  
  public final void a(boolean paramBoolean)
  {
    if (n != paramBoolean)
    {
      n = paramBoolean;
      d();
    }
  }
  
  public final void a(int[] paramArrayOfInt)
  {
    i = paramArrayOfInt;
    a(0);
  }
  
  public final void b()
  {
    k = d;
    l = e;
    m = f;
  }
  
  public final void b(float paramFloat)
  {
    e = paramFloat;
    d();
  }
  
  public final void c()
  {
    k = 0.0F;
    l = 0.0F;
    m = 0.0F;
    a(0.0F);
    b(0.0F);
    c(0.0F);
  }
  
  public final void c(float paramFloat)
  {
    f = paramFloat;
    d();
  }
  
  final void d()
  {
    x.invalidateDrawable(null);
  }
}

/* Location:
 * Qualified Name:     xh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */