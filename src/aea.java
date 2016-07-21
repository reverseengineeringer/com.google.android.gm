import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Method;

public class aea
  extends adq<ll>
  implements MenuItem
{
  public Method e;
  
  aea(Context paramContext, ll paramll)
  {
    super(paramContext, paramll);
  }
  
  aeb a(ActionProvider paramActionProvider)
  {
    return new aeb(this, a, paramActionProvider);
  }
  
  public boolean collapseActionView()
  {
    return ((ll)d).collapseActionView();
  }
  
  public boolean expandActionView()
  {
    return ((ll)d).expandActionView();
  }
  
  public ActionProvider getActionProvider()
  {
    oy localoy = ((ll)d).a();
    if ((localoy instanceof aeb)) {
      return c;
    }
    return null;
  }
  
  public View getActionView()
  {
    View localView2 = ((ll)d).getActionView();
    View localView1 = localView2;
    if ((localView2 instanceof aec)) {
      localView1 = (View)a;
    }
    return localView1;
  }
  
  public char getAlphabeticShortcut()
  {
    return ((ll)d).getAlphabeticShortcut();
  }
  
  public int getGroupId()
  {
    return ((ll)d).getGroupId();
  }
  
  public Drawable getIcon()
  {
    return ((ll)d).getIcon();
  }
  
  public Intent getIntent()
  {
    return ((ll)d).getIntent();
  }
  
  public int getItemId()
  {
    return ((ll)d).getItemId();
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return ((ll)d).getMenuInfo();
  }
  
  public char getNumericShortcut()
  {
    return ((ll)d).getNumericShortcut();
  }
  
  public int getOrder()
  {
    return ((ll)d).getOrder();
  }
  
  public SubMenu getSubMenu()
  {
    return a(((ll)d).getSubMenu());
  }
  
  public CharSequence getTitle()
  {
    return ((ll)d).getTitle();
  }
  
  public CharSequence getTitleCondensed()
  {
    return ((ll)d).getTitleCondensed();
  }
  
  public boolean hasSubMenu()
  {
    return ((ll)d).hasSubMenu();
  }
  
  public boolean isActionViewExpanded()
  {
    return ((ll)d).isActionViewExpanded();
  }
  
  public boolean isCheckable()
  {
    return ((ll)d).isCheckable();
  }
  
  public boolean isChecked()
  {
    return ((ll)d).isChecked();
  }
  
  public boolean isEnabled()
  {
    return ((ll)d).isEnabled();
  }
  
  public boolean isVisible()
  {
    return ((ll)d).isVisible();
  }
  
  public MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    ll localll = (ll)d;
    if (paramActionProvider != null) {}
    for (paramActionProvider = a(paramActionProvider);; paramActionProvider = null)
    {
      localll.a(paramActionProvider);
      return this;
    }
  }
  
  public MenuItem setActionView(int paramInt)
  {
    ((ll)d).setActionView(paramInt);
    View localView = ((ll)d).getActionView();
    if ((localView instanceof CollapsibleActionView)) {
      ((ll)d).setActionView(new aec(localView));
    }
    return this;
  }
  
  public MenuItem setActionView(View paramView)
  {
    Object localObject = paramView;
    if ((paramView instanceof CollapsibleActionView)) {
      localObject = new aec(paramView);
    }
    ((ll)d).setActionView((View)localObject);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar)
  {
    ((ll)d).setAlphabeticShortcut(paramChar);
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean)
  {
    ((ll)d).setCheckable(paramBoolean);
    return this;
  }
  
  public MenuItem setChecked(boolean paramBoolean)
  {
    ((ll)d).setChecked(paramBoolean);
    return this;
  }
  
  public MenuItem setEnabled(boolean paramBoolean)
  {
    ((ll)d).setEnabled(paramBoolean);
    return this;
  }
  
  public MenuItem setIcon(int paramInt)
  {
    ((ll)d).setIcon(paramInt);
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable)
  {
    ((ll)d).setIcon(paramDrawable);
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent)
  {
    ((ll)d).setIntent(paramIntent);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar)
  {
    ((ll)d).setNumericShortcut(paramChar);
    return this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    ll localll = (ll)d;
    if (paramOnActionExpandListener != null) {}
    for (paramOnActionExpandListener = new aed(this, paramOnActionExpandListener);; paramOnActionExpandListener = null)
    {
      localll.a(paramOnActionExpandListener);
      return this;
    }
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    ll localll = (ll)d;
    if (paramOnMenuItemClickListener != null) {}
    for (paramOnMenuItemClickListener = new aee(this, paramOnMenuItemClickListener);; paramOnMenuItemClickListener = null)
    {
      localll.setOnMenuItemClickListener(paramOnMenuItemClickListener);
      return this;
    }
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    ((ll)d).setShortcut(paramChar1, paramChar2);
    return this;
  }
  
  public void setShowAsAction(int paramInt)
  {
    ((ll)d).setShowAsAction(paramInt);
  }
  
  public MenuItem setShowAsActionFlags(int paramInt)
  {
    ((ll)d).setShowAsActionFlags(paramInt);
    return this;
  }
  
  public MenuItem setTitle(int paramInt)
  {
    ((ll)d).setTitle(paramInt);
    return this;
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence)
  {
    ((ll)d).setTitle(paramCharSequence);
    return this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    ((ll)d).setTitleCondensed(paramCharSequence);
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean)
  {
    return ((ll)d).setVisible(paramBoolean);
  }
}

/* Location:
 * Qualified Name:     aea
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */