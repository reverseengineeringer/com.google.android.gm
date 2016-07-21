import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

public class db<V extends View>
  extends ad<V>
{
  private dc a;
  private int b = 0;
  private int c = 0;
  
  public db() {}
  
  public db(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean a(int paramInt)
  {
    if (a != null) {
      return a.a(paramInt);
    }
    b = paramInt;
    return false;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    c(paramCoordinatorLayout, paramV, paramInt);
    if (a == null) {
      a = new dc(paramV);
    }
    paramCoordinatorLayout = a;
    b = a.getTop();
    c = a.getLeft();
    paramCoordinatorLayout.a();
    if (b != 0)
    {
      a.a(b);
      b = 0;
    }
    if (c != 0)
    {
      paramCoordinatorLayout = a;
      paramInt = c;
      if (e != paramInt)
      {
        e = paramInt;
        paramCoordinatorLayout.a();
      }
      c = 0;
    }
    return true;
  }
  
  public int b()
  {
    if (a != null) {
      return a.d;
    }
    return 0;
  }
  
  protected void c(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    paramCoordinatorLayout.a(paramV, paramInt);
  }
}

/* Location:
 * Qualified Name:     db
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */