import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class adu
  implements lk
{
  private static final int[] m = { 1, 4, 5, 3, 2, 0 };
  public final Context a;
  public adv b;
  ArrayList<ady> c;
  public ArrayList<ady> d;
  public int e = 0;
  CharSequence f;
  Drawable g;
  View h;
  public boolean i = false;
  public CopyOnWriteArrayList<WeakReference<aej>> j = new CopyOnWriteArrayList();
  ady k;
  public boolean l;
  private final Resources n;
  private boolean o;
  private boolean p;
  private ArrayList<ady> q;
  private boolean r;
  private ArrayList<ady> s;
  private boolean t;
  private ContextMenu.ContextMenuInfo u;
  private boolean v = false;
  private boolean w = false;
  private boolean x = false;
  private ArrayList<ady> y = new ArrayList();
  
  public adu(Context paramContext)
  {
    a = paramContext;
    n = paramContext.getResources();
    c = new ArrayList();
    q = new ArrayList();
    r = true;
    d = new ArrayList();
    s = new ArrayList();
    t = true;
    if ((n.getConfiguration().keyboard != 1) && (n.getBoolean(acb.d))) {}
    for (;;)
    {
      p = bool;
      return;
      bool = false;
    }
  }
  
  private static int a(ArrayList<ady> paramArrayList, int paramInt)
  {
    int i1 = paramArrayList.size() - 1;
    while (i1 >= 0)
    {
      if (geta <= paramInt) {
        return i1 + 1;
      }
      i1 -= 1;
    }
    return 0;
  }
  
  private final ady a(int paramInt, KeyEvent paramKeyEvent)
  {
    ArrayList localArrayList = y;
    localArrayList.clear();
    a(localArrayList, paramInt, paramKeyEvent);
    if (localArrayList.isEmpty())
    {
      paramKeyEvent = null;
      return paramKeyEvent;
    }
    int i3 = paramKeyEvent.getMetaState();
    KeyCharacterMap.KeyData localKeyData = new KeyCharacterMap.KeyData();
    paramKeyEvent.getKeyData(localKeyData);
    int i4 = localArrayList.size();
    if (i4 == 1) {
      return (ady)localArrayList.get(0);
    }
    boolean bool = b();
    int i1 = 0;
    label84:
    if (i1 < i4)
    {
      ady localady = (ady)localArrayList.get(i1);
      if (bool) {}
      for (int i2 = localady.getAlphabeticShortcut();; i2 = localady.getNumericShortcut())
      {
        if (i2 == meta[0])
        {
          paramKeyEvent = localady;
          if ((i3 & 0x2) == 0) {
            break;
          }
        }
        if (i2 == meta[2])
        {
          paramKeyEvent = localady;
          if ((i3 & 0x2) != 0) {
            break;
          }
        }
        if ((bool) && (i2 == 8))
        {
          paramKeyEvent = localady;
          if (paramInt == 67) {
            break;
          }
        }
        i1 += 1;
        break label84;
      }
    }
    return null;
  }
  
  private final void a(int paramInt, boolean paramBoolean)
  {
    if ((paramInt < 0) || (paramInt >= c.size())) {}
    do
    {
      return;
      c.remove(paramInt);
    } while (!paramBoolean);
    a(true);
  }
  
  private final void a(List<ady> paramList, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = b();
    int i3 = paramKeyEvent.getMetaState();
    KeyCharacterMap.KeyData localKeyData = new KeyCharacterMap.KeyData();
    if ((!paramKeyEvent.getKeyData(localKeyData)) && (paramInt != 67)) {
      return;
    }
    int i4 = c.size();
    int i1 = 0;
    label49:
    ady localady;
    if (i1 < i4)
    {
      localady = (ady)c.get(i1);
      if (localady.hasSubMenu()) {
        ((adu)localady.getSubMenu()).a(paramList, paramInt, paramKeyEvent);
      }
      if (!bool) {
        break label184;
      }
    }
    label184:
    for (int i2 = localady.getAlphabeticShortcut();; i2 = localady.getNumericShortcut())
    {
      if (((i3 & 0x5) == 0) && (i2 != 0) && ((i2 == meta[0]) || (i2 == meta[2]) || ((bool) && (i2 == 8) && (paramInt == 67))) && (localady.isEnabled())) {
        paramList.add(localady);
      }
      i1 += 1;
      break label49;
      break;
    }
  }
  
  protected final adu a(Drawable paramDrawable)
  {
    a(null, paramDrawable, null);
    return this;
  }
  
  protected final adu a(CharSequence paramCharSequence)
  {
    a(paramCharSequence, null, null);
    return this;
  }
  
  public final MenuItem a(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    int i1 = (0xFFFF0000 & paramInt3) >> 16;
    if ((i1 < 0) || (i1 >= m.length)) {
      throw new IllegalArgumentException("order does not contain a valid category.");
    }
    i1 = m[i1] << 16 | 0xFFFF & paramInt3;
    paramCharSequence = new ady(this, paramInt1, paramInt2, paramInt3, i1, paramCharSequence, e);
    if (u != null) {
      e = u;
    }
    c.add(a(c, i1), paramCharSequence);
    a(true);
    return paramCharSequence;
  }
  
  protected String a()
  {
    return "android:menu:actionviewstates";
  }
  
  public void a(adv paramadv)
  {
    b = paramadv;
  }
  
  public final void a(aej paramaej)
  {
    a(paramaej, a);
  }
  
  public final void a(aej paramaej, Context paramContext)
  {
    j.add(new WeakReference(paramaej));
    paramaej.a(paramContext, this);
    t = true;
  }
  
  public final void a(Bundle paramBundle)
  {
    if (j.isEmpty()) {
      return;
    }
    SparseArray localSparseArray = new SparseArray();
    Iterator localIterator = j.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (WeakReference)localIterator.next();
      aej localaej = (aej)((WeakReference)localObject).get();
      if (localaej == null)
      {
        j.remove(localObject);
      }
      else
      {
        int i1 = localaej.b();
        if (i1 > 0)
        {
          localObject = localaej.d();
          if (localObject != null) {
            localSparseArray.put(i1, localObject);
          }
        }
      }
    }
    paramBundle.putSparseParcelableArray("android:menu:presenters", localSparseArray);
  }
  
  final void a(CharSequence paramCharSequence, Drawable paramDrawable, View paramView)
  {
    if (paramView != null)
    {
      h = paramView;
      f = null;
      g = null;
    }
    for (;;)
    {
      a(false);
      return;
      if (paramCharSequence != null) {
        f = paramCharSequence;
      }
      if (paramDrawable != null) {
        g = paramDrawable;
      }
      h = null;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!v)
    {
      if (paramBoolean)
      {
        r = true;
        t = true;
      }
      if (!j.isEmpty())
      {
        d();
        Iterator localIterator = j.iterator();
        while (localIterator.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          aej localaej = (aej)localWeakReference.get();
          if (localaej == null) {
            j.remove(localWeakReference);
          } else {
            localaej.b(paramBoolean);
          }
        }
        e();
      }
      return;
    }
    w = true;
  }
  
  boolean a(adu paramadu, MenuItem paramMenuItem)
  {
    return (b != null) && (b.a(paramadu, paramMenuItem));
  }
  
  public boolean a(ady paramady)
  {
    boolean bool2 = false;
    if (j.isEmpty()) {
      return bool2;
    }
    d();
    Iterator localIterator = j.iterator();
    boolean bool1 = false;
    for (;;)
    {
      label29:
      if (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        aej localaej = (aej)localWeakReference.get();
        if (localaej == null)
        {
          j.remove(localWeakReference);
        }
        else
        {
          bool1 = localaej.b(paramady);
          if (!bool1) {
            break;
          }
        }
      }
    }
    for (;;)
    {
      e();
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      k = paramady;
      return bool1;
      break label29;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, aej paramaej, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    paramMenuItem = (ady)paramMenuItem;
    if ((paramMenuItem == null) || (!paramMenuItem.isEnabled())) {
      bool1 = false;
    }
    boolean bool3;
    Object localObject;
    label95:
    do
    {
      return bool1;
      bool3 = paramMenuItem.b();
      localObject = d;
      if ((localObject != null) && (((oy)localObject).e())) {}
      for (int i1 = 1;; i1 = 0)
      {
        if (!paramMenuItem.i()) {
          break label95;
        }
        bool2 = paramMenuItem.expandActionView() | bool3;
        bool1 = bool2;
        if (!bool2) {
          break;
        }
        b(true);
        return bool2;
      }
      if ((!paramMenuItem.hasSubMenu()) && (i1 == 0)) {
        break label283;
      }
      b(false);
      if (!paramMenuItem.hasSubMenu()) {
        paramMenuItem.a(new aep(a, this, paramMenuItem));
      }
      paramMenuItem = (aep)paramMenuItem.getSubMenu();
      if (i1 != 0) {
        ((oy)localObject).a(paramMenuItem);
      }
      if (!j.isEmpty()) {
        break;
      }
      bool2 = bool3 | bool1;
      bool1 = bool2;
    } while (bool2);
    b(true);
    return bool2;
    bool1 = bool2;
    if (paramaej != null) {
      bool1 = paramaej.a(paramMenuItem);
    }
    paramaej = j.iterator();
    label214:
    while (paramaej.hasNext())
    {
      localObject = (WeakReference)paramaej.next();
      aej localaej = (aej)((WeakReference)localObject).get();
      if (localaej == null)
      {
        j.remove(localObject);
      }
      else
      {
        if (bool1) {
          break label297;
        }
        bool1 = localaej.a(paramMenuItem);
      }
    }
    label283:
    label297:
    for (;;)
    {
      break label214;
      break;
      if ((paramInt & 0x1) == 0) {
        b(true);
      }
      return bool3;
    }
  }
  
  public MenuItem add(int paramInt)
  {
    return a(0, 0, 0, n.getString(paramInt));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(paramInt1, paramInt2, paramInt3, n.getString(paramInt4));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    return a(paramInt1, paramInt2, paramInt3, paramCharSequence);
  }
  
  public MenuItem add(CharSequence paramCharSequence)
  {
    return a(0, 0, 0, paramCharSequence);
  }
  
  public int addIntentOptions(int paramInt1, int paramInt2, int paramInt3, ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt4, MenuItem[] paramArrayOfMenuItem)
  {
    PackageManager localPackageManager = a.getPackageManager();
    List localList = localPackageManager.queryIntentActivityOptions(paramComponentName, paramArrayOfIntent, paramIntent, 0);
    int i1;
    label52:
    ResolveInfo localResolveInfo;
    if (localList != null)
    {
      i1 = localList.size();
      if ((paramInt4 & 0x1) == 0) {
        removeGroup(paramInt1);
      }
      paramInt4 = 0;
      if (paramInt4 >= i1) {
        break label214;
      }
      localResolveInfo = (ResolveInfo)localList.get(paramInt4);
      if (specificIndex >= 0) {
        break label201;
      }
    }
    label201:
    for (paramComponentName = paramIntent;; paramComponentName = paramArrayOfIntent[specificIndex])
    {
      paramComponentName = new Intent(paramComponentName);
      paramComponentName.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
      paramComponentName = add(paramInt1, paramInt2, paramInt3, localResolveInfo.loadLabel(localPackageManager)).setIcon(localResolveInfo.loadIcon(localPackageManager)).setIntent(paramComponentName);
      if ((paramArrayOfMenuItem != null) && (specificIndex >= 0)) {
        paramArrayOfMenuItem[specificIndex] = paramComponentName;
      }
      paramInt4 += 1;
      break label52;
      i1 = 0;
      break;
    }
    label214:
    return i1;
  }
  
  public SubMenu addSubMenu(int paramInt)
  {
    return addSubMenu(0, 0, 0, n.getString(paramInt));
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return addSubMenu(paramInt1, paramInt2, paramInt3, n.getString(paramInt4));
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    paramCharSequence = (ady)a(paramInt1, paramInt2, paramInt3, paramCharSequence);
    aep localaep = new aep(a, this, paramCharSequence);
    paramCharSequence.a(localaep);
    return localaep;
  }
  
  public SubMenu addSubMenu(CharSequence paramCharSequence)
  {
    return addSubMenu(0, 0, 0, paramCharSequence);
  }
  
  public final void b(aej paramaej)
  {
    Iterator localIterator = j.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      aej localaej = (aej)localWeakReference.get();
      if ((localaej == null) || (localaej == paramaej)) {
        j.remove(localWeakReference);
      }
    }
  }
  
  public final void b(Bundle paramBundle)
  {
    int i2 = size();
    int i1 = 0;
    Object localObject3;
    for (Object localObject1 = null; i1 < i2; localObject1 = localObject3)
    {
      MenuItem localMenuItem = getItem(i1);
      View localView = qe.a(localMenuItem);
      localObject3 = localObject1;
      if (localView != null)
      {
        localObject3 = localObject1;
        if (localView.getId() != -1)
        {
          Object localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new SparseArray();
          }
          localView.saveHierarchyState((SparseArray)localObject2);
          localObject3 = localObject2;
          if (qe.c(localMenuItem))
          {
            paramBundle.putInt("android:menu:expandedactionview", localMenuItem.getItemId());
            localObject3 = localObject2;
          }
        }
      }
      if (localMenuItem.hasSubMenu()) {
        ((aep)localMenuItem.getSubMenu()).b(paramBundle);
      }
      i1 += 1;
    }
    if (localObject1 != null) {
      paramBundle.putSparseParcelableArray(a(), (SparseArray)localObject1);
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    if (x) {
      return;
    }
    x = true;
    Iterator localIterator = j.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      aej localaej = (aej)localWeakReference.get();
      if (localaej == null) {
        j.remove(localWeakReference);
      } else {
        localaej.a(this, paramBoolean);
      }
    }
    x = false;
  }
  
  boolean b()
  {
    return o;
  }
  
  public boolean b(ady paramady)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (!j.isEmpty())
    {
      if (k != paramady) {
        bool2 = bool1;
      }
    }
    else {
      return bool2;
    }
    d();
    Iterator localIterator = j.iterator();
    bool1 = false;
    for (;;)
    {
      label41:
      if (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        aej localaej = (aej)localWeakReference.get();
        if (localaej == null)
        {
          j.remove(localWeakReference);
        }
        else
        {
          bool1 = localaej.c(paramady);
          if (!bool1) {
            break;
          }
        }
      }
    }
    for (;;)
    {
      e();
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      k = null;
      return bool1;
      break label41;
    }
  }
  
  public final void c(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    do
    {
      int i1;
      do
      {
        return;
        SparseArray localSparseArray = paramBundle.getSparseParcelableArray(a());
        int i2 = size();
        i1 = 0;
        while (i1 < i2)
        {
          MenuItem localMenuItem = getItem(i1);
          View localView = qe.a(localMenuItem);
          if ((localView != null) && (localView.getId() != -1)) {
            localView.restoreHierarchyState(localSparseArray);
          }
          if (localMenuItem.hasSubMenu()) {
            ((aep)localMenuItem.getSubMenu()).c(paramBundle);
          }
          i1 += 1;
        }
        i1 = paramBundle.getInt("android:menu:expandedactionview");
      } while (i1 <= 0);
      paramBundle = findItem(i1);
    } while (paramBundle == null);
    qe.b(paramBundle);
  }
  
  public boolean c()
  {
    return p;
  }
  
  public void clear()
  {
    if (k != null) {
      b(k);
    }
    c.clear();
    a(true);
  }
  
  public void clearHeader()
  {
    g = null;
    f = null;
    h = null;
    a(false);
  }
  
  public void close()
  {
    b(true);
  }
  
  public final void d()
  {
    if (!v)
    {
      v = true;
      w = false;
    }
  }
  
  public final void e()
  {
    v = false;
    if (w)
    {
      w = false;
      a(true);
    }
  }
  
  final void f()
  {
    r = true;
    a(true);
  }
  
  public MenuItem findItem(int paramInt)
  {
    int i2 = size();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = (ady)c.get(i1);
      if (((ady)localObject).getItemId() == paramInt) {}
      MenuItem localMenuItem;
      do
      {
        return (MenuItem)localObject;
        if (!((ady)localObject).hasSubMenu()) {
          break;
        }
        localMenuItem = ((ady)localObject).getSubMenu().findItem(paramInt);
        localObject = localMenuItem;
      } while (localMenuItem != null);
      i1 += 1;
    }
    return null;
  }
  
  final void g()
  {
    t = true;
    a(true);
  }
  
  public MenuItem getItem(int paramInt)
  {
    return (MenuItem)c.get(paramInt);
  }
  
  public final ArrayList<ady> h()
  {
    if (!r) {
      return q;
    }
    q.clear();
    int i2 = c.size();
    int i1 = 0;
    while (i1 < i2)
    {
      ady localady = (ady)c.get(i1);
      if (localady.isVisible()) {
        q.add(localady);
      }
      i1 += 1;
    }
    r = false;
    t = true;
    return q;
  }
  
  public boolean hasVisibleItems()
  {
    if (l) {
      return true;
    }
    int i2 = size();
    int i1 = 0;
    while (i1 < i2)
    {
      if (((ady)c.get(i1)).isVisible()) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  public final void i()
  {
    ArrayList localArrayList = h();
    if (!t) {
      return;
    }
    Object localObject = j.iterator();
    int i1 = 0;
    while (((Iterator)localObject).hasNext())
    {
      WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
      aej localaej = (aej)localWeakReference.get();
      if (localaej == null) {
        j.remove(localWeakReference);
      } else {
        i1 = localaej.a() | i1;
      }
    }
    if (i1 != 0)
    {
      d.clear();
      s.clear();
      int i3 = localArrayList.size();
      i1 = 0;
      if (i1 < i3)
      {
        localObject = (ady)localArrayList.get(i1);
        if (((ady)localObject).f()) {
          d.add(localObject);
        }
        for (;;)
        {
          int i2;
          i1 += 1;
          break;
          s.add(localObject);
        }
      }
    }
    else
    {
      d.clear();
      s.clear();
      s.addAll(h());
    }
    t = false;
  }
  
  public boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent)
  {
    return a(paramInt, paramKeyEvent) != null;
  }
  
  public final ArrayList<ady> j()
  {
    i();
    return s;
  }
  
  public adu k()
  {
    return this;
  }
  
  public boolean performIdentifierAction(int paramInt1, int paramInt2)
  {
    return a(findItem(paramInt1), null, paramInt2);
  }
  
  public boolean performShortcut(int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    paramKeyEvent = a(paramInt1, paramKeyEvent);
    boolean bool = false;
    if (paramKeyEvent != null) {
      bool = a(paramKeyEvent, null, paramInt2);
    }
    if ((paramInt2 & 0x2) != 0) {
      b(true);
    }
    return bool;
  }
  
  public void removeGroup(int paramInt)
  {
    int i2 = size();
    int i1 = 0;
    if (i1 < i2) {
      if (((ady)c.get(i1)).getGroupId() != paramInt) {}
    }
    for (;;)
    {
      label30:
      if (i1 >= 0)
      {
        int i3 = c.size();
        i2 = 0;
        for (;;)
        {
          if ((i2 < i3 - i1) && (((ady)c.get(i1)).getGroupId() == paramInt))
          {
            a(i1, false);
            i2 += 1;
            continue;
            i1 += 1;
            break;
            i1 = -1;
            break label30;
          }
        }
        a(true);
      }
    }
  }
  
  public void removeItem(int paramInt)
  {
    int i2 = size();
    int i1 = 0;
    if (i1 < i2) {
      if (((ady)c.get(i1)).getItemId() != paramInt) {}
    }
    for (;;)
    {
      a(i1, true);
      return;
      i1 += 1;
      break;
      i1 = -1;
    }
  }
  
  public void setGroupCheckable(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2 = c.size();
    int i1 = 0;
    while (i1 < i2)
    {
      ady localady = (ady)c.get(i1);
      if (localady.getGroupId() == paramInt)
      {
        localady.a(paramBoolean2);
        localady.setCheckable(paramBoolean1);
      }
      i1 += 1;
    }
  }
  
  public void setGroupEnabled(int paramInt, boolean paramBoolean)
  {
    int i2 = c.size();
    int i1 = 0;
    while (i1 < i2)
    {
      ady localady = (ady)c.get(i1);
      if (localady.getGroupId() == paramInt) {
        localady.setEnabled(paramBoolean);
      }
      i1 += 1;
    }
  }
  
  public void setGroupVisible(int paramInt, boolean paramBoolean)
  {
    int i3 = c.size();
    int i2 = 0;
    int i1 = 0;
    if (i2 < i3)
    {
      ady localady = (ady)c.get(i2);
      if ((localady.getGroupId() != paramInt) || (!localady.b(paramBoolean))) {
        break label74;
      }
      i1 = 1;
    }
    label74:
    for (;;)
    {
      i2 += 1;
      break;
      if (i1 != 0) {
        a(true);
      }
      return;
    }
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    o = paramBoolean;
    a(false);
  }
  
  public int size()
  {
    return c.size();
  }
}

/* Location:
 * Qualified Name:     adu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */