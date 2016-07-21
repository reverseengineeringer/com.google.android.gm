import android.view.View;

public final class akf
  extends akd
{
  public akf(akw paramakw)
  {
    super(paramakw, (byte)0);
  }
  
  public final int a(View paramView)
  {
    akx localakx = (akx)paramView.getLayoutParams();
    return akw.e(paramView) - topMargin;
  }
  
  public final void a(int paramInt)
  {
    a.e(paramInt);
  }
  
  public final int b()
  {
    return a.k();
  }
  
  public final int b(View paramView)
  {
    akx localakx = (akx)paramView.getLayoutParams();
    int i = akw.g(paramView);
    return bottomMargin + i;
  }
  
  public final int c()
  {
    return a.r - a.m();
  }
  
  public final int c(View paramView)
  {
    akx localakx = (akx)paramView.getLayoutParams();
    int i = akw.c(paramView);
    int j = topMargin;
    return bottomMargin + (i + j);
  }
  
  public final int d()
  {
    return a.r;
  }
  
  public final int d(View paramView)
  {
    akx localakx = (akx)paramView.getLayoutParams();
    int i = akw.b(paramView);
    int j = leftMargin;
    return rightMargin + (i + j);
  }
  
  public final int e()
  {
    return a.r - a.k() - a.m();
  }
  
  public final int f()
  {
    return a.m();
  }
  
  public final int g()
  {
    return a.p;
  }
}

/* Location:
 * Qualified Name:     akf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */