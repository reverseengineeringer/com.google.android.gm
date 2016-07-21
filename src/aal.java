import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

final class aal
  implements zj
{
  aal(aak paramaak) {}
  
  public final Drawable a()
  {
    amp localamp = amp.a(a.l(), null, new int[] { aca.D });
    Drawable localDrawable = localamp.a(0);
    a.recycle();
    return localDrawable;
  }
  
  public final void a(int paramInt)
  {
    zc localzc = a.a();
    if (localzc != null) {
      localzc.e(paramInt);
    }
  }
  
  public final void a(Drawable paramDrawable, int paramInt)
  {
    zc localzc = a.a();
    if (localzc != null)
    {
      localzc.b(paramDrawable);
      localzc.e(paramInt);
    }
  }
  
  public final Context b()
  {
    return a.l();
  }
  
  public final boolean c()
  {
    zc localzc = a.a();
    return (localzc != null) && ((localzc.g() & 0x4) != 0);
  }
}

/* Location:
 * Qualified Name:     aal
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */