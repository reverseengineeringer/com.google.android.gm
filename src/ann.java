import android.graphics.Bitmap;

public class ann
  implements anj
{
  public final Bitmap a;
  public int b;
  public int c;
  int d;
  private int e = 0;
  private final boolean f;
  
  public ann(Bitmap paramBitmap)
  {
    this(paramBitmap, true);
  }
  
  public ann(Bitmap paramBitmap, boolean paramBoolean)
  {
    a = paramBitmap;
    f = paramBoolean;
  }
  
  public void a()
  {
    e += 1;
  }
  
  public final int b()
  {
    return e;
  }
  
  public final boolean c()
  {
    return f;
  }
  
  public int d()
  {
    return a.getByteCount();
  }
  
  public void e()
  {
    if (e == 0) {
      throw new IllegalStateException();
    }
    e -= 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("[");
    localStringBuilder.append(super.toString());
    localStringBuilder.append(" refCount=");
    localStringBuilder.append(e);
    localStringBuilder.append(" mReusable=");
    localStringBuilder.append(f);
    localStringBuilder.append(" bmp=");
    localStringBuilder.append(a);
    localStringBuilder.append(" logicalW/H=");
    localStringBuilder.append(b);
    localStringBuilder.append("/");
    localStringBuilder.append(c);
    if (a != null)
    {
      localStringBuilder.append(" sz=");
      localStringBuilder.append(a.getByteCount() >> 10);
      localStringBuilder.append("KB");
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     ann
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */