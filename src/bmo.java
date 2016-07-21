import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.View;

public abstract class bmo
  extends qv
{
  private final fq a;
  private Fragment b = null;
  private ny<String, Fragment> c = new bmp(this);
  gd f = null;
  
  public bmo(fq paramfq)
  {
    a = paramfq;
  }
  
  public Object a(View paramView, int paramInt)
  {
    if (f == null) {
      f = a.a();
    }
    Object localObject = a(paramView.getId(), paramInt);
    c.b(localObject);
    localObject = a.a((String)localObject);
    if (localObject != null) {
      f.c((Fragment)localObject);
    }
    for (paramView = (View)localObject;; paramView = (View)localObject)
    {
      if (paramView != b) {
        paramView.a(false);
      }
      return paramView;
      localObject = b(paramInt);
      if (localObject == null) {
        return null;
      }
      f.a(paramView.getId(), (Fragment)localObject, a(paramView.getId(), paramInt));
    }
  }
  
  protected String a(int paramInt1, int paramInt2)
  {
    return 40 + "android:switcher:" + paramInt1 + ":" + paramInt2;
  }
  
  public final void a(Parcelable paramParcelable, ClassLoader paramClassLoader) {}
  
  public void a(View paramView, int paramInt, Object paramObject)
  {
    if (f == null) {
      f = a.a();
    }
    Fragment localFragment = (Fragment)paramObject;
    String str = H;
    paramObject = str;
    if (str == null) {
      paramObject = a(paramView.getId(), paramInt);
    }
    c.a(paramObject, localFragment);
    f.b(localFragment);
  }
  
  public final void a(Object paramObject)
  {
    paramObject = (Fragment)paramObject;
    if (paramObject != b)
    {
      if (b != null) {
        b.a(false);
      }
      if (paramObject != null) {
        ((Fragment)paramObject).a(true);
      }
      b = ((Fragment)paramObject);
    }
  }
  
  public final boolean a(View paramView, Object paramObject)
  {
    paramObject = R;
    while ((paramView instanceof View))
    {
      if (paramView == paramObject) {
        return true;
      }
      paramView = ((View)paramView).getParent();
    }
    return false;
  }
  
  public abstract Fragment b(int paramInt);
  
  public final void c()
  {
    if ((f != null) && (!a.e()))
    {
      f.c();
      f = null;
      a.b();
    }
  }
  
  public final Parcelable d()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     bmo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */