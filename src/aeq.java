import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

final class aeq
  extends aeo
  implements SubMenu
{
  aeq(Context paramContext, lm paramlm)
  {
    super(paramContext, paramlm);
  }
  
  public final void clearHeader()
  {
    ((lm)d).clearHeader();
  }
  
  public final MenuItem getItem()
  {
    return a(((lm)d).getItem());
  }
  
  public final SubMenu setHeaderIcon(int paramInt)
  {
    ((lm)d).setHeaderIcon(paramInt);
    return this;
  }
  
  public final SubMenu setHeaderIcon(Drawable paramDrawable)
  {
    ((lm)d).setHeaderIcon(paramDrawable);
    return this;
  }
  
  public final SubMenu setHeaderTitle(int paramInt)
  {
    ((lm)d).setHeaderTitle(paramInt);
    return this;
  }
  
  public final SubMenu setHeaderTitle(CharSequence paramCharSequence)
  {
    ((lm)d).setHeaderTitle(paramCharSequence);
    return this;
  }
  
  public final SubMenu setHeaderView(View paramView)
  {
    ((lm)d).setHeaderView(paramView);
    return this;
  }
  
  public final SubMenu setIcon(int paramInt)
  {
    ((lm)d).setIcon(paramInt);
    return this;
  }
  
  public final SubMenu setIcon(Drawable paramDrawable)
  {
    ((lm)d).setIcon(paramDrawable);
    return this;
  }
}

/* Location:
 * Qualified Name:     aeq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */