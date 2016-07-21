import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;

public final class bmt
  extends jl<bmv>
  implements bmu
{
  private String f;
  private Bitmap g;
  
  public bmt(Context paramContext, String paramString)
  {
    super(paramContext);
    f = paramString;
  }
  
  private static void a(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      paramBitmap.recycle();
    }
  }
  
  private final void a(bmv parambmv)
  {
    Bitmap localBitmap1;
    if (parambmv != null)
    {
      localBitmap1 = b;
      if (!t) {
        break label30;
      }
      if (localBitmap1 != null) {
        a(localBitmap1);
      }
    }
    label30:
    Bitmap localBitmap2;
    do
    {
      return;
      localBitmap1 = null;
      break;
      localBitmap2 = g;
      g = localBitmap1;
      if (r) {
        super.b(parambmv);
      }
    } while ((localBitmap2 == null) || (localBitmap2 == localBitmap1) || (localBitmap2.isRecycled()));
    a(localBitmap2);
  }
  
  private final bmv f()
  {
    Object localObject2 = new bmv();
    Object localObject3 = q;
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (f != null) {
        localObject1 = ((Context)localObject3).getContentResolver();
      }
    }
    try
    {
      localObject3 = bna.a((ContentResolver)localObject1, Uri.parse(f), blq.b);
      localObject1 = localObject3;
      localObject2 = localObject3;
      if (b != null)
      {
        localObject2 = localObject3;
        b.setDensity(160);
        localObject1 = localObject3;
      }
      return (bmv)localObject1;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      c = 1;
    }
    return (bmv)localObject2;
  }
  
  public final void a(String paramString)
  {
    f = paramString;
  }
  
  protected final void g()
  {
    if (g != null)
    {
      bmv localbmv = new bmv();
      c = 0;
      b = g;
      a(localbmv);
    }
    if ((k()) || (g == null)) {
      a();
    }
  }
  
  protected final void h()
  {
    b();
  }
  
  protected final void i()
  {
    super.i();
    b();
    if (g != null)
    {
      a(g);
      g = null;
    }
  }
}

/* Location:
 * Qualified Name:     bmt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */