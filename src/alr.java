import android.view.View;

public final class alr
{
  public static int a(alg paramalg, akd paramakd, View paramView1, View paramView2, akw paramakw, boolean paramBoolean)
  {
    if ((paramakw.i() == 0) || (paramalg.a() == 0) || (paramView1 == null) || (paramView2 == null)) {
      return 0;
    }
    if (!paramBoolean) {
      return Math.abs(akw.a(paramView1) - akw.a(paramView2)) + 1;
    }
    int i = paramakd.b(paramView2);
    int j = paramakd.a(paramView1);
    return Math.min(paramakd.e(), i - j);
  }
  
  public static int a(alg paramalg, akd paramakd, View paramView1, View paramView2, akw paramakw, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    int j = i;
    if (paramakw.i() != 0)
    {
      j = i;
      if (paramalg.a() != 0)
      {
        j = i;
        if (paramView1 != null)
        {
          if (paramView2 != null) {
            break label45;
          }
          j = i;
        }
      }
    }
    return j;
    label45:
    i = Math.min(akw.a(paramView1), akw.a(paramView2));
    j = Math.max(akw.a(paramView1), akw.a(paramView2));
    if (paramBoolean2) {}
    for (i = Math.max(0, paramalg.a() - j - 1);; i = Math.max(0, i))
    {
      j = i;
      if (!paramBoolean1) {
        break;
      }
      j = Math.abs(paramakd.b(paramView2) - paramakd.a(paramView1));
      int k = Math.abs(akw.a(paramView1) - akw.a(paramView2));
      float f = j / (k + 1);
      return Math.round(i * f + (paramakd.b() - paramakd.a(paramView1)));
    }
  }
  
  public static int b(alg paramalg, akd paramakd, View paramView1, View paramView2, akw paramakw, boolean paramBoolean)
  {
    if ((paramakw.i() == 0) || (paramalg.a() == 0) || (paramView1 == null) || (paramView2 == null)) {
      return 0;
    }
    if (!paramBoolean) {
      return paramalg.a();
    }
    int i = paramakd.b(paramView2);
    int j = paramakd.a(paramView1);
    int k = Math.abs(akw.a(paramView1) - akw.a(paramView2));
    return (int)((i - j) / (k + 1) * paramalg.a());
  }
}

/* Location:
 * Qualified Name:     alr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */