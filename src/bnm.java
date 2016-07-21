import com.android.ex.photo.views.PhotoView;

public final class bnm
  implements Runnable
{
  public final PhotoView a;
  public float b;
  public float c;
  public float d;
  public float e;
  public long f = -1L;
  public boolean g;
  public boolean h;
  
  public bnm(PhotoView paramPhotoView)
  {
    a = paramPhotoView;
  }
  
  public final void a()
  {
    g = false;
    h = true;
  }
  
  public final void run()
  {
    float f2 = 20000.0F;
    if (h) {
      return;
    }
    long l = System.currentTimeMillis();
    int i;
    if (f != -1L)
    {
      f1 = (float)(l - f) / 1000.0F;
      i = a.a(b * f1, c * f1);
      f = l;
      float f3 = d * f1;
      if (Math.abs(b) <= Math.abs(f3)) {
        break label186;
      }
      b -= f3;
      label98:
      f1 *= e;
      if (Math.abs(c) <= Math.abs(f1)) {
        break label194;
      }
      c -= f1;
      label130:
      if (((b != 0.0F) || (c != 0.0F)) && (i != 0)) {
        break label202;
      }
      a();
      a.c();
    }
    for (;;)
    {
      label164:
      if (!h)
      {
        a.post(this);
        return;
        f1 = 0.0F;
        break;
        label186:
        b = 0.0F;
        break label98;
        label194:
        c = 0.0F;
        break label130;
        label202:
        if (i == 1)
        {
          if (b > 0.0F) {}
          for (f1 = 20000.0F;; f1 = -20000.0F)
          {
            d = f1;
            e = 0.0F;
            c = 0.0F;
            break;
          }
        }
        if (i == 2)
        {
          d = 0.0F;
          if (c <= 0.0F) {
            break label279;
          }
        }
      }
    }
    label279:
    for (float f1 = f2;; f1 = -20000.0F)
    {
      e = f1;
      b = 0.0F;
      break label164;
      break;
    }
  }
}

/* Location:
 * Qualified Name:     bnm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */