import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

public final class fsf
  extends fsi
{
  public fsf(Context paramContext, eiz parameiz)
  {
    super(paramContext, parameiz, false);
  }
  
  public static Bitmap a(Context paramContext)
  {
    return BitmapFactory.decodeResource(paramContext.getResources(), fst.a);
  }
  
  protected final void a(fsj paramfsj, Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      f.setImageBitmap(a(b));
      return;
    }
    super.a(paramfsj, paramBitmap);
  }
}

/* Location:
 * Qualified Name:     fsf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */