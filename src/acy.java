import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;

public final class acy
{
  public Context a;
  
  private acy(Context paramContext)
  {
    a = paramContext;
  }
  
  public static acy a(Context paramContext)
  {
    return new acy(paramContext);
  }
  
  public final boolean a()
  {
    if (a.getApplicationInfo().targetSdkVersion >= 16) {
      return a.getResources().getBoolean(acb.a);
    }
    return a.getResources().getBoolean(acb.b);
  }
  
  public final int b()
  {
    TypedArray localTypedArray = a.obtainStyledAttributes(null, ack.b, aca.c, 0);
    int j = localTypedArray.getLayoutDimension(ack.k, 0);
    Resources localResources = a.getResources();
    int i = j;
    if (!a()) {
      i = Math.min(j, localResources.getDimensionPixelSize(acd.a));
    }
    localTypedArray.recycle();
    return i;
  }
  
  public final int c()
  {
    return a.getResources().getDimensionPixelSize(acd.b);
  }
}

/* Location:
 * Qualified Name:     acy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */