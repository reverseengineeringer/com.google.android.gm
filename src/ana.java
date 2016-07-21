import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import java.lang.ref.WeakReference;

public final class ana
  extends Resources
{
  private final WeakReference<Context> a;
  
  public ana(Context paramContext, Resources paramResources)
  {
    super(paramResources.getAssets(), paramResources.getDisplayMetrics(), paramResources.getConfiguration());
    a = new WeakReference(paramContext);
  }
  
  public static boolean a()
  {
    return (aaj.b) && (Build.VERSION.SDK_INT <= 20);
  }
  
  public final Drawable getDrawable(int paramInt)
  {
    Context localContext = (Context)a.get();
    if (localContext != null)
    {
      agj localagj = agj.a();
      Drawable localDrawable2 = localagj.a(localContext, paramInt);
      Drawable localDrawable1 = localDrawable2;
      if (localDrawable2 == null) {
        localDrawable1 = super.getDrawable(paramInt);
      }
      if (localDrawable1 != null) {
        return localagj.a(localContext, paramInt, false, localDrawable1);
      }
      return null;
    }
    return super.getDrawable(paramInt);
  }
}

/* Location:
 * Qualified Name:     ana
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */