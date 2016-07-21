import android.view.View;

final class dc
{
  final View a;
  int b;
  int c;
  int d;
  int e;
  
  public dc(View paramView)
  {
    a = paramView;
  }
  
  final void a()
  {
    rg.e(a, d - (a.getTop() - b));
    rg.f(a, e - (a.getLeft() - c));
  }
  
  public final boolean a(int paramInt)
  {
    if (d != paramInt)
    {
      d = paramInt;
      a();
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     dc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */