import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

final class amo
  extends alm
{
  private final WeakReference<Context> a;
  
  public amo(Context paramContext, Resources paramResources)
  {
    super(paramResources);
    a = new WeakReference(paramContext);
  }
  
  public final Drawable getDrawable(int paramInt)
  {
    Drawable localDrawable = super.getDrawable(paramInt);
    Context localContext = (Context)a.get();
    if ((localDrawable != null) && (localContext != null))
    {
      agj.a();
      agj.a(localContext, paramInt, localDrawable);
    }
    return localDrawable;
  }
}

/* Location:
 * Qualified Name:     amo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */