import android.view.View;
import android.view.ViewParent;

public final class qr
{
  public boolean a;
  private final View b;
  private ViewParent c;
  private int[] d;
  
  public qr(View paramView)
  {
    b = paramView;
  }
  
  public final void a(boolean paramBoolean)
  {
    if (a)
    {
      View localView = b;
      rg.a.F(localView);
    }
    a = paramBoolean;
  }
  
  public final boolean a()
  {
    return c != null;
  }
  
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    if ((a) && (c != null))
    {
      ViewParent localViewParent = c;
      View localView = b;
      return sz.a.a(localViewParent, localView, paramFloat1, paramFloat2);
    }
    return false;
  }
  
  public final boolean a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if ((a) && (c != null))
    {
      ViewParent localViewParent = c;
      View localView = b;
      return sz.a.a(localViewParent, localView, paramFloat1, paramFloat2, paramBoolean);
    }
    return false;
  }
  
  public final boolean a(int paramInt)
  {
    if (a()) {
      return true;
    }
    if (a)
    {
      ViewParent localViewParent = b.getParent();
      View localView1 = b;
      while (localViewParent != null)
      {
        View localView2 = b;
        if (sz.a.a(localViewParent, localView1, localView2, paramInt))
        {
          c = localViewParent;
          localView2 = b;
          sz.a.b(localViewParent, localView1, localView2, paramInt);
          return true;
        }
        if ((localViewParent instanceof View)) {
          localView1 = (View)localViewParent;
        }
        localViewParent = localViewParent.getParent();
      }
    }
    return false;
  }
  
  public final boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    int j;
    int i;
    if ((a) && (c != null)) {
      if ((paramInt1 != 0) || (paramInt2 != 0) || (paramInt3 != 0) || (paramInt4 != 0))
      {
        if (paramArrayOfInt == null) {
          break label141;
        }
        b.getLocationInWindow(paramArrayOfInt);
        j = paramArrayOfInt[0];
        i = paramArrayOfInt[1];
      }
    }
    for (;;)
    {
      ViewParent localViewParent = c;
      View localView = b;
      sz.a.a(localViewParent, localView, paramInt1, paramInt2, paramInt3, paramInt4);
      if (paramArrayOfInt != null)
      {
        b.getLocationInWindow(paramArrayOfInt);
        paramArrayOfInt[0] -= j;
        paramArrayOfInt[1] -= i;
      }
      return true;
      if (paramArrayOfInt != null)
      {
        paramArrayOfInt[0] = 0;
        paramArrayOfInt[1] = 0;
      }
      return false;
      label141:
      i = 0;
      j = 0;
    }
  }
  
  public final boolean a(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int j;
    int i;
    if ((a) && (c != null)) {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        if (paramArrayOfInt2 == null) {
          break label178;
        }
        b.getLocationInWindow(paramArrayOfInt2);
        j = paramArrayOfInt2[0];
        i = paramArrayOfInt2[1];
      }
    }
    for (;;)
    {
      if (paramArrayOfInt1 == null)
      {
        if (d == null) {
          d = new int[2];
        }
        paramArrayOfInt1 = d;
      }
      for (;;)
      {
        paramArrayOfInt1[0] = 0;
        paramArrayOfInt1[1] = 0;
        ViewParent localViewParent = c;
        View localView = b;
        sz.a.a(localViewParent, localView, paramInt1, paramInt2, paramArrayOfInt1);
        if (paramArrayOfInt2 != null)
        {
          b.getLocationInWindow(paramArrayOfInt2);
          paramArrayOfInt2[0] -= j;
          paramArrayOfInt2[1] -= i;
        }
        return (paramArrayOfInt1[0] != 0) || (paramArrayOfInt1[1] != 0);
        if (paramArrayOfInt2 != null)
        {
          paramArrayOfInt2[0] = 0;
          paramArrayOfInt2[1] = 0;
        }
        return false;
      }
      label178:
      i = 0;
      j = 0;
    }
  }
  
  public final void b()
  {
    if (c != null)
    {
      ViewParent localViewParent = c;
      View localView = b;
      sz.a.a(localViewParent, localView);
      c = null;
    }
  }
}

/* Location:
 * Qualified Name:     qr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */