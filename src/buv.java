import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public final class buv
  extends buu
{
  private static Bitmap g = null;
  
  public buv(Resources paramResources, anf paramanf, bvd parambvd)
  {
    super(paramResources);
    b = paramanf;
    c = parambvd;
    if (g == null) {
      g = BitmapFactory.decodeResource(paramResources, bub.a);
    }
  }
  
  protected final void a(Canvas paramCanvas)
  {
    a(g, g.getWidth(), g.getHeight(), paramCanvas);
  }
}

/* Location:
 * Qualified Name:     buv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */