package android.support.design.internal;

import adu;
import ael;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

public class NavigationMenuView
  extends RecyclerView
  implements ael
{
  public NavigationMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NavigationMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NavigationMenuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(new LinearLayoutManager());
  }
  
  public final void a(adu paramadu) {}
}

/* Location:
 * Qualified Name:     android.support.design.internal.NavigationMenuView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */