import android.os.Build.VERSION;

public final class vk
{
  public static final vn a = new vp();
  public final Object b;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      a = new vo();
      return;
    }
    if (Build.VERSION.SDK_INT >= 15)
    {
      a = new vm();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      a = new vl();
      return;
    }
  }
  
  public vk(Object paramObject)
  {
    b = paramObject;
  }
  
  public final void a(int paramInt)
  {
    a.b(b, paramInt);
  }
  
  public final void a(boolean paramBoolean)
  {
    a.a(b, paramBoolean);
  }
  
  public final void b(int paramInt)
  {
    a.a(b, paramInt);
  }
  
  public final void c(int paramInt)
  {
    a.e(b, paramInt);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (vk)paramObject;
        if (b != null) {
          break;
        }
      } while (b == null);
      return false;
    } while (b.equals(b));
    return false;
  }
  
  public final int hashCode()
  {
    if (b == null) {
      return 0;
    }
    return b.hashCode();
  }
}

/* Location:
 * Qualified Name:     vk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */