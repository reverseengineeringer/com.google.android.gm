import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import java.util.ArrayList;

public final class ady
  implements ll
{
  public static String f;
  public static String g;
  public static String h;
  public static String i;
  final int a;
  public adu b;
  public int c = 0;
  public oy d;
  ContextMenu.ContextMenuInfo e;
  private final int j;
  private final int k;
  private final int l;
  private CharSequence m;
  private CharSequence n;
  private Intent o;
  private char p;
  private char q;
  private Drawable r;
  private int s = 0;
  private aep t;
  private Runnable u;
  private MenuItem.OnMenuItemClickListener v;
  private int w = 16;
  private View x;
  private qj y;
  private boolean z = false;
  
  ady(adu paramadu, int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence, int paramInt5)
  {
    b = paramadu;
    j = paramInt2;
    k = paramInt1;
    l = paramInt3;
    a = paramInt4;
    m = paramCharSequence;
    c = paramInt5;
  }
  
  private final ll a(View paramView)
  {
    x = paramView;
    d = null;
    if ((paramView != null) && (paramView.getId() == -1) && (j > 0)) {
      paramView.setId(j);
    }
    b.g();
    return this;
  }
  
  private void e(boolean paramBoolean)
  {
    int i2 = w;
    int i3 = w;
    if (paramBoolean) {}
    for (int i1 = 2;; i1 = 0)
    {
      w = (i1 | i3 & 0xFFFFFFFD);
      if (i2 != w) {
        b.a(false);
      }
      return;
    }
  }
  
  public final CharSequence a(aem paramaem)
  {
    if ((paramaem != null) && (paramaem.b())) {
      return getTitleCondensed();
    }
    return getTitle();
  }
  
  public final ll a(oy paramoy)
  {
    if (d != null)
    {
      oy localoy = d;
      b = null;
      a = null;
    }
    x = null;
    d = paramoy;
    b.a(true);
    if (d != null) {
      d.a(new adz(this));
    }
    return this;
  }
  
  public final ll a(qj paramqj)
  {
    y = paramqj;
    return this;
  }
  
  public final oy a()
  {
    return d;
  }
  
  public final void a(aep paramaep)
  {
    t = paramaep;
    paramaep.setHeaderTitle(getTitle());
  }
  
  public final void a(boolean paramBoolean)
  {
    int i2 = w;
    if (paramBoolean) {}
    for (int i1 = 4;; i1 = 0)
    {
      w = (i1 | i2 & 0xFFFFFFFB);
      return;
    }
  }
  
  public final boolean b()
  {
    if ((v != null) && (v.onMenuItemClick(this))) {}
    do
    {
      do
      {
        return true;
      } while (b.a(b.k(), this));
      if (u != null)
      {
        u.run();
        return true;
      }
      if (o != null) {
        try
        {
          b.a.startActivity(o);
          return true;
        }
        catch (ActivityNotFoundException localActivityNotFoundException)
        {
          Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", localActivityNotFoundException);
        }
      }
    } while ((d != null) && (d.d()));
    return false;
  }
  
  final boolean b(boolean paramBoolean)
  {
    boolean bool = false;
    int i2 = w;
    int i3 = w;
    if (paramBoolean) {}
    for (int i1 = 0;; i1 = 8)
    {
      w = (i1 | i3 & 0xFFFFFFF7);
      paramBoolean = bool;
      if (i2 != w) {
        paramBoolean = true;
      }
      return paramBoolean;
    }
  }
  
  public final char c()
  {
    if (b.b()) {
      return q;
    }
    return p;
  }
  
  public final void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      w |= 0x20;
      return;
    }
    w &= 0xFFFFFFDF;
  }
  
  public final boolean collapseActionView()
  {
    if ((c & 0x8) == 0) {}
    do
    {
      return false;
      if (x == null) {
        return true;
      }
    } while ((y != null) && (!y.b(this)));
    return b.b(this);
  }
  
  public final void d(boolean paramBoolean)
  {
    z = paramBoolean;
    b.a(false);
  }
  
  public final boolean d()
  {
    return (b.c()) && (c() != 0);
  }
  
  public final boolean e()
  {
    return (w & 0x4) != 0;
  }
  
  public final boolean expandActionView()
  {
    if (!i()) {}
    while ((y != null) && (!y.a(this))) {
      return false;
    }
    return b.a(this);
  }
  
  public final boolean f()
  {
    return (w & 0x20) == 32;
  }
  
  public final boolean g()
  {
    return (c & 0x1) == 1;
  }
  
  public final ActionProvider getActionProvider()
  {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
  }
  
  public final View getActionView()
  {
    if (x != null) {
      return x;
    }
    if (d != null)
    {
      x = d.a(this);
      return x;
    }
    return null;
  }
  
  public final char getAlphabeticShortcut()
  {
    return q;
  }
  
  public final int getGroupId()
  {
    return k;
  }
  
  public final Drawable getIcon()
  {
    if (r != null) {
      return r;
    }
    if (s != 0)
    {
      Drawable localDrawable = agj.a().a(b.a, s, false);
      s = 0;
      r = localDrawable;
      return localDrawable;
    }
    return null;
  }
  
  public final Intent getIntent()
  {
    return o;
  }
  
  @ViewDebug.CapturedViewProperty
  public final int getItemId()
  {
    return j;
  }
  
  public final ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return e;
  }
  
  public final char getNumericShortcut()
  {
    return p;
  }
  
  public final int getOrder()
  {
    return l;
  }
  
  public final SubMenu getSubMenu()
  {
    return t;
  }
  
  @ViewDebug.CapturedViewProperty
  public final CharSequence getTitle()
  {
    return m;
  }
  
  public final CharSequence getTitleCondensed()
  {
    if (n != null) {}
    for (CharSequence localCharSequence = n;; localCharSequence = m)
    {
      Object localObject = localCharSequence;
      if (Build.VERSION.SDK_INT < 18)
      {
        localObject = localCharSequence;
        if (localCharSequence != null)
        {
          localObject = localCharSequence;
          if (!(localCharSequence instanceof String)) {
            localObject = localCharSequence.toString();
          }
        }
      }
      return (CharSequence)localObject;
    }
  }
  
  public final boolean h()
  {
    return (c & 0x2) == 2;
  }
  
  public final boolean hasSubMenu()
  {
    return t != null;
  }
  
  public final boolean i()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((c & 0x8) != 0)
    {
      if ((x == null) && (d != null)) {
        x = d.a(this);
      }
      bool1 = bool2;
      if (x != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean isActionViewExpanded()
  {
    return z;
  }
  
  public final boolean isCheckable()
  {
    return (w & 0x1) == 1;
  }
  
  public final boolean isChecked()
  {
    return (w & 0x2) == 2;
  }
  
  public final boolean isEnabled()
  {
    return (w & 0x10) != 0;
  }
  
  public final boolean isVisible()
  {
    if ((d != null) && (d.b())) {
      if (((w & 0x8) != 0) || (!d.c())) {}
    }
    while ((w & 0x8) == 0)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public final MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar)
  {
    if (q == paramChar) {
      return this;
    }
    q = Character.toLowerCase(paramChar);
    b.a(false);
    return this;
  }
  
  public final MenuItem setCheckable(boolean paramBoolean)
  {
    int i2 = w;
    int i3 = w;
    if (paramBoolean) {}
    for (int i1 = 1;; i1 = 0)
    {
      w = (i1 | i3 & 0xFFFFFFFE);
      if (i2 != w) {
        b.a(false);
      }
      return this;
    }
  }
  
  public final MenuItem setChecked(boolean paramBoolean)
  {
    if ((w & 0x4) != 0)
    {
      adu localadu = b;
      int i2 = getGroupId();
      int i3 = c.size();
      int i1 = 0;
      if (i1 < i3)
      {
        ady localady = (ady)c.get(i1);
        if ((localady.getGroupId() == i2) && (localady.e()) && (localady.isCheckable())) {
          if (localady != this) {
            break label100;
          }
        }
        label100:
        for (paramBoolean = true;; paramBoolean = false)
        {
          localady.e(paramBoolean);
          i1 += 1;
          break;
        }
      }
    }
    else
    {
      e(paramBoolean);
    }
    return this;
  }
  
  public final MenuItem setEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (w |= 0x10;; w &= 0xFFFFFFEF)
    {
      b.a(false);
      return this;
    }
  }
  
  public final MenuItem setIcon(int paramInt)
  {
    r = null;
    s = paramInt;
    b.a(false);
    return this;
  }
  
  public final MenuItem setIcon(Drawable paramDrawable)
  {
    s = 0;
    r = paramDrawable;
    b.a(false);
    return this;
  }
  
  public final MenuItem setIntent(Intent paramIntent)
  {
    o = paramIntent;
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar)
  {
    if (p == paramChar) {
      return this;
    }
    p = paramChar;
    b.a(false);
    return this;
  }
  
  public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
  }
  
  public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    v = paramOnMenuItemClickListener;
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    p = paramChar1;
    q = Character.toLowerCase(paramChar2);
    b.a(false);
    return this;
  }
  
  public final void setShowAsAction(int paramInt)
  {
    switch (paramInt & 0x3)
    {
    default: 
      throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }
    c = paramInt;
    b.g();
  }
  
  public final MenuItem setTitle(int paramInt)
  {
    return setTitle(b.a.getString(paramInt));
  }
  
  public final MenuItem setTitle(CharSequence paramCharSequence)
  {
    m = paramCharSequence;
    b.a(false);
    if (t != null) {
      t.setHeaderTitle(paramCharSequence);
    }
    return this;
  }
  
  public final MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    n = paramCharSequence;
    b.a(false);
    return this;
  }
  
  public final MenuItem setVisible(boolean paramBoolean)
  {
    if (b(paramBoolean)) {
      b.f();
    }
    return this;
  }
  
  public final String toString()
  {
    if (m != null) {
      return m.toString();
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     ady
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */