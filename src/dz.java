import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

final class dz
  extends Drawable.ConstantState
{
  int a;
  dy b;
  ColorStateList c = null;
  PorterDuff.Mode d = dt.a;
  boolean e;
  Bitmap f;
  ColorStateList g;
  PorterDuff.Mode h;
  int i;
  boolean j;
  boolean k;
  Paint l;
  
  public dz()
  {
    b = new dy();
  }
  
  public dz(dz paramdz)
  {
    if (paramdz != null)
    {
      a = a;
      b = new dy(b);
      if (b.b != null) {
        b.b = new Paint(b.b);
      }
      if (b.a != null) {
        b.a = new Paint(b.a);
      }
      c = c;
      d = d;
      e = e;
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    f.eraseColor(0);
    Canvas localCanvas = new Canvas(f);
    b.a(localCanvas, paramInt1, paramInt2);
  }
  
  public final int getChangingConfigurations()
  {
    return a;
  }
  
  public final Drawable newDrawable()
  {
    return new dt(this);
  }
  
  public final Drawable newDrawable(Resources paramResources)
  {
    return new dt(this);
  }
}

/* Location:
 * Qualified Name:     dz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */