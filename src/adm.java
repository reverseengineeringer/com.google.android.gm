import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

public final class adm
  implements ll
{
  private final int a;
  private final int b;
  private final int c;
  private final int d;
  private CharSequence e;
  private CharSequence f;
  private Intent g;
  private char h;
  private char i;
  private Drawable j;
  private int k = 0;
  private Context l;
  private MenuItem.OnMenuItemClickListener m;
  private int n = 16;
  
  public adm(Context paramContext, CharSequence paramCharSequence)
  {
    l = paramContext;
    a = 16908332;
    b = 0;
    c = 0;
    d = 0;
    e = paramCharSequence;
  }
  
  public final ll a(oy paramoy)
  {
    throw new UnsupportedOperationException();
  }
  
  public final ll a(qj paramqj)
  {
    return this;
  }
  
  public final oy a()
  {
    return null;
  }
  
  public final boolean collapseActionView()
  {
    return false;
  }
  
  public final boolean expandActionView()
  {
    return false;
  }
  
  public final ActionProvider getActionProvider()
  {
    throw new UnsupportedOperationException();
  }
  
  public final View getActionView()
  {
    return null;
  }
  
  public final char getAlphabeticShortcut()
  {
    return i;
  }
  
  public final int getGroupId()
  {
    return b;
  }
  
  public final Drawable getIcon()
  {
    return j;
  }
  
  public final Intent getIntent()
  {
    return g;
  }
  
  public final int getItemId()
  {
    return a;
  }
  
  public final ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return null;
  }
  
  public final char getNumericShortcut()
  {
    return h;
  }
  
  public final int getOrder()
  {
    return d;
  }
  
  public final SubMenu getSubMenu()
  {
    return null;
  }
  
  public final CharSequence getTitle()
  {
    return e;
  }
  
  public final CharSequence getTitleCondensed()
  {
    if (f != null) {
      return f;
    }
    return e;
  }
  
  public final boolean hasSubMenu()
  {
    return false;
  }
  
  public final boolean isActionViewExpanded()
  {
    return false;
  }
  
  public final boolean isCheckable()
  {
    return (n & 0x1) != 0;
  }
  
  public final boolean isChecked()
  {
    return (n & 0x2) != 0;
  }
  
  public final boolean isEnabled()
  {
    return (n & 0x10) != 0;
  }
  
  public final boolean isVisible()
  {
    return (n & 0x8) == 0;
  }
  
  public final MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    throw new UnsupportedOperationException();
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar)
  {
    i = paramChar;
    return this;
  }
  
  public final MenuItem setCheckable(boolean paramBoolean)
  {
    int i2 = n;
    if (paramBoolean) {}
    for (int i1 = 1;; i1 = 0)
    {
      n = (i1 | i2 & 0xFFFFFFFE);
      return this;
    }
  }
  
  public final MenuItem setChecked(boolean paramBoolean)
  {
    int i2 = n;
    if (paramBoolean) {}
    for (int i1 = 2;; i1 = 0)
    {
      n = (i1 | i2 & 0xFFFFFFFD);
      return this;
    }
  }
  
  public final MenuItem setEnabled(boolean paramBoolean)
  {
    int i2 = n;
    if (paramBoolean) {}
    for (int i1 = 16;; i1 = 0)
    {
      n = (i1 | i2 & 0xFFFFFFEF);
      return this;
    }
  }
  
  public final MenuItem setIcon(int paramInt)
  {
    k = paramInt;
    j = jr.a(l, paramInt);
    return this;
  }
  
  public final MenuItem setIcon(Drawable paramDrawable)
  {
    j = paramDrawable;
    k = 0;
    return this;
  }
  
  public final MenuItem setIntent(Intent paramIntent)
  {
    g = paramIntent;
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar)
  {
    h = paramChar;
    return this;
  }
  
  public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    throw new UnsupportedOperationException();
  }
  
  public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    m = paramOnMenuItemClickListener;
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    h = paramChar1;
    i = paramChar2;
    return this;
  }
  
  public final void setShowAsAction(int paramInt) {}
  
  public final MenuItem setTitle(int paramInt)
  {
    e = l.getResources().getString(paramInt);
    return this;
  }
  
  public final MenuItem setTitle(CharSequence paramCharSequence)
  {
    e = paramCharSequence;
    return this;
  }
  
  public final MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    f = paramCharSequence;
    return this;
  }
  
  public final MenuItem setVisible(boolean paramBoolean)
  {
    int i2 = n;
    if (paramBoolean) {}
    for (int i1 = 0;; i1 = 8)
    {
      n = (i1 | i2 & 0x8);
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     adm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */