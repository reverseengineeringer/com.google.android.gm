import com.android.ex.photo.views.PhotoView;

public final class bnk
  implements Runnable
{
  public boolean a;
  private final PhotoView b;
  private float c;
  private float d;
  private boolean e;
  private float f;
  private float g;
  private float h;
  private long i;
  private boolean j;
  
  public bnk(PhotoView paramPhotoView)
  {
    b = paramPhotoView;
  }
  
  public final void a()
  {
    a = false;
    j = true;
  }
  
  public final boolean a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (a) {
      return false;
    }
    c = paramFloat3;
    d = paramFloat4;
    f = paramFloat2;
    i = System.currentTimeMillis();
    g = paramFloat1;
    if (f > g) {}
    for (boolean bool = true;; bool = false)
    {
      e = bool;
      h = ((f - g) / 200.0F);
      a = true;
      j = false;
      b.post(this);
      return true;
    }
  }
  
  public final void run()
  {
    if (j) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = i;
    float f1 = g;
    float f2 = h;
    f1 = (float)(l1 - l2) * f2 + f1;
    b.a(f1, c, d);
    boolean bool2;
    if (f1 != f)
    {
      bool2 = e;
      if (f1 <= f) {
        break label128;
      }
    }
    label128:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (bool2 == bool1)
      {
        b.a(f, c, d);
        a();
      }
      if (j) {
        break;
      }
      b.post(this);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     bnk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */