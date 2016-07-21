import android.support.v7.widget.GridLayout;
import android.view.View;

public class aja
{
  public int b;
  public int c;
  public int d;
  
  aja()
  {
    a();
  }
  
  public int a(GridLayout paramGridLayout, View paramView, aiv paramaiv, int paramInt, boolean paramBoolean)
  {
    return b - paramaiv.a(paramView, paramInt, sf.a(paramGridLayout));
  }
  
  public int a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (GridLayout.a(d))) {
      return 100000;
    }
    return b + c;
  }
  
  protected void a()
  {
    b = Integer.MIN_VALUE;
    c = Integer.MIN_VALUE;
    d = 2;
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    b = Math.max(b, paramInt1);
    c = Math.max(c, paramInt2);
  }
  
  public String toString()
  {
    return "Bounds{before=" + b + ", after=" + c + '}';
  }
}

/* Location:
 * Qualified Name:     aja
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */