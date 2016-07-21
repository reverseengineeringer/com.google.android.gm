import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

public class fsc
  extends fsi
{
  public fsc(Context paramContext, eiz parameiz)
  {
    super(paramContext, parameiz, true);
  }
  
  public Bitmap a(Context paramContext, fyb paramfyb, int paramInt)
  {
    return fto.a(BitmapFactory.decodeResource(paramContext.getResources(), fst.b));
  }
  
  public final void a(ImageView paramImageView, fyb paramfyb, int paramInt)
  {
    a(new fsd(this, paramImageView, paramfyb, paramInt));
  }
  
  protected final void a(fsj paramfsj, Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      paramBitmap = f;
      paramfsj = (fsd)paramfsj;
      paramBitmap.setImageBitmap(a(b, c, a));
      return;
    }
    super.a(paramfsj, paramBitmap);
  }
}

/* Location:
 * Qualified Name:     fsc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */