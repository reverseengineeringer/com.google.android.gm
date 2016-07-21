import android.view.View;

public final class ake
  extends akd
{
  public ake(akw paramakw)
  {
    super(paramakw, (byte)0);
  }
  
  public final int a(View paramView)
  {
    akx localakx = (akx)paramView.getLayoutParams();
    return akw.d(paramView) - leftMargin;
  }
  
  public final void a(int paramInt)
  {
    a.d(paramInt);
  }
  
  public final int b()
  {
    return a.j();
  }
  
  public final int b(View paramView)
  {
    akx localakx = (akx)paramView.getLayoutParams();
    int i = akw.f(paramView);
    return rightMargin + i;
  }
  
  public final int c()
  {
    return a.q - a.l();
  }
  
  public final int c(View paramView)
  {
    akx localakx = (akx)paramView.getLayoutParams();
    int i = akw.b(paramView);
    int j = leftMargin;
    return rightMargin + (i + j);
  }
  
  public final int d()
  {
    return a.q;
  }
  
  public final int d(View paramView)
  {
    akx localakx = (akx)paramView.getLayoutParams();
    int i = akw.c(paramView);
    int j = topMargin;
    return bottomMargin + (i + j);
  }
  
  public final int e()
  {
    return a.q - a.j() - a.l();
  }
  
  public final int f()
  {
    return a.l();
  }
  
  public final int g()
  {
    return a.o;
  }
}

/* Location:
 * Qualified Name:     ake
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */