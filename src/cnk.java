import android.app.Activity;
import android.app.ListFragment;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.android.mail.providers.Account;
import com.android.mail.providers.Folder;
import com.android.mail.providers.Settings;
import com.android.mail.ui.FolderItemView;
import com.android.mail.ui.MiniDrawerView;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class cnk
  extends ListFragment
  implements LoaderManager.LoaderCallbacks<ccy<Folder>>, cgo
{
  static final String a = cvl.a;
  int A;
  public cmy B;
  public float C;
  private Uri D;
  private cmz E;
  private Folder F;
  private cnu G;
  private cgm H = null;
  private cfx I = null;
  private cnt J = null;
  private cfy K = null;
  private boolean L;
  private cnw M;
  private boolean N;
  public ckv b;
  ListView c;
  boolean d = false;
  public boolean e = true;
  ArrayList<Integer> f;
  cod g;
  cjo h;
  public cus i = cus.a;
  Folder j;
  public byn<ListAdapter> k;
  cno l;
  public cns m;
  int n = 0;
  int o = 2;
  public Account p;
  Account q = null;
  Folder r = null;
  cgn s = null;
  boolean t = false;
  final cnp u = new cnp(this);
  anf v;
  bvd w;
  boolean x;
  boolean y;
  public MiniDrawerView z;
  
  static cnk a(Folder paramFolder, Uri paramUri, ArrayList<Integer> paramArrayList)
  {
    cnk localcnk = new cnk();
    Bundle localBundle = new Bundle(3);
    if (paramFolder != null) {
      localBundle.putParcelable("arg-parent-folder", paramFolder);
    }
    if (paramUri != null) {
      localBundle.putString("arg-folder-list-uri", paramUri.toString());
    }
    if (paramArrayList != null) {
      localBundle.putIntegerArrayList("arg-excluded-folder-types", paramArrayList);
    }
    localcnk.setArguments(localBundle);
    return localcnk;
  }
  
  private final Folder e(Account paramAccount)
  {
    if ((paramAccount == null) || (s == null)) {
      return null;
    }
    return s.a(paramAccount);
  }
  
  private final boolean l()
  {
    return f() == 0;
  }
  
  private final int m()
  {
    int i1 = c.getFirstVisiblePosition();
    int i2 = f();
    if (i2 - i1 <= 0) {
      return 0;
    }
    return i2 - i1;
  }
  
  public final int a(Account paramAccount)
  {
    if ((paramAccount == null) || (s == null)) {}
    do
    {
      return 0;
      paramAccount = s.a(paramAccount);
    } while (paramAccount == null);
    return k;
  }
  
  public void a()
  {
    if (l != null) {
      l.notifyDataSetChanged();
    }
  }
  
  public void a(float paramFloat)
  {
    Object localObject = z;
    ArrayList localArrayList = new ArrayList();
    localObject = c.iterator();
    coy localcoy;
    while (((Iterator)localObject).hasNext())
    {
      localcoy = (coy)((Iterator)localObject).next();
      if (a.getVisibility() != 8) {
        localArrayList.add(localcoy);
      }
    }
    if (!cxd.a()) {}
    label277:
    label328:
    label397:
    label421:
    for (;;)
    {
      localObject = this;
      boolean bool = false;
      for (;;)
      {
        N = bool;
        do
        {
          if (!N) {
            break label397;
          }
          z.setAlpha(1.0F);
          c.setAlpha(1.0F);
          localObject = localArrayList.iterator();
          while (((Iterator)localObject).hasNext()) {
            nexta.setAlpha(0.0F);
          }
        } while ((paramFloat != 0.0F) && (paramFloat != 1.0F));
        int i4 = localArrayList.size();
        int i2 = m();
        int i5 = c.getChildCount();
        int i1 = 0;
        if (i2 < i5)
        {
          localObject = c.getChildAt(i2);
          int i3;
          if ((localObject instanceof FolderItemView))
          {
            localObject = (FolderItemView)localObject;
            if (i1 < i4)
            {
              localcoy = (coy)localArrayList.get(i1);
              i3 = b.intValue();
              if ((a != null) && (a.a == i3))
              {
                i3 = 1;
                if (i3 == 0) {
                  break label328;
                }
                C = (a.getTop() - ((FolderItemView)localObject).getTop());
                ((FolderItemView)localObject).a(C, false);
                i1 += 1;
              }
            }
          }
          for (;;)
          {
            i2 += 1;
            break;
            i3 = 0;
            break label277;
            ((FolderItemView)localObject).a(C, true);
            continue;
            cxe.c((View)localObject);
          }
        }
        if (i1 != i4) {
          break label421;
        }
        bool = true;
        localObject = this;
      }
      z.a(l());
      for (;;)
      {
        z.setVisibility(0);
        c.setVisibility(0);
        b(paramFloat);
        return;
        cxe.c(z);
        cxe.c(c);
        z.c();
      }
    }
  }
  
  public void a(LayoutInflater paramLayoutInflater, View paramView, ListView paramListView) {}
  
  final void a(Folder paramFolder)
  {
    int i3 = 1;
    int i2 = 0;
    if (paramFolder == null)
    {
      i = cus.a;
      j = null;
      cvm.e(a, "FolderListFragment.setSelectedFolder(null) called!", new Object[0]);
      return;
    }
    Folder localFolder = j;
    if (paramFolder == null) {
      if (localFolder == null)
      {
        i1 = 1;
        label53:
        if (i1 == 0) {
          i2 = 1;
        }
        if ((n == 0) || ((p != null) && (c.equals(p.z.i)))) {
          if (!paramFolder.d(8194)) {
            break label259;
          }
        }
      }
    }
    label259:
    for (int i1 = i3;; i1 = 3)
    {
      n = i1;
      o = p;
      j = paramFolder;
      i = c;
      if (i2 == 0) {
        break;
      }
      if (m != null) {
        m.notifyDataSetChanged();
      }
      if (z == null) {
        break;
      }
      z.a();
      return;
      i1 = 0;
      break label53;
      if ((localFolder != null) && ((paramFolder == localFolder) || ((c.equals(c)) && (d.equals(d)) && (f == f) && (j == j) && (k == k))))
      {
        i1 = 1;
        break label53;
      }
      i1 = 0;
      break label53;
    }
  }
  
  public final void a(Folder paramFolder, String paramString)
  {
    if (!c.equals(i))
    {
      r = paramFolder;
      h.a(true, null, paramFolder);
      buo.a().a("switch_folder", paramFolder.b(), paramString, 0L);
      return;
    }
    h.a(false, null, paramFolder);
  }
  
  public void a(boolean paramBoolean)
  {
    int i1 = m();
    int i2 = c.getChildCount();
    while (i1 < i2)
    {
      localObject = c.getChildAt(i1);
      if (!(localObject instanceof FolderItemView)) {
        cxe.d((View)localObject);
      }
      i1 += 1;
    }
    if (!N)
    {
      cxe.d(z);
      cxe.d(c);
    }
    Object localObject = z;
    boolean bool = l();
    Iterator localIterator = d.iterator();
    while (localIterator.hasNext()) {
      cxe.d((View)localIterator.next());
    }
    if (bool) {
      cxe.d(b);
    }
    if (paramBoolean) {
      z.c();
    }
    a(paramBoolean, true);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!y) {}
    do
    {
      do
      {
        return;
        L = paramBoolean1;
      } while (!paramBoolean2);
      if (!e()) {
        break;
      }
      z.setVisibility(0);
      c.setVisibility(4);
    } while (E == null);
    E.b(c);
    return;
    z.setVisibility(4);
    c.setVisibility(0);
  }
  
  int b()
  {
    return h.an();
  }
  
  public void b(float paramFloat)
  {
    if (N)
    {
      int i1 = m();
      Object localObject = z;
      if (l()) {
        cmy.a(b, paramFloat);
      }
      Iterator localIterator = d.iterator();
      while (localIterator.hasNext())
      {
        View localView = (View)localIterator.next();
        cmy.a(localView, -a.C, paramFloat);
        cmy.a(localView, paramFloat);
      }
      int i2 = c.getChildCount();
      if (i1 < i2)
      {
        localObject = c.getChildAt(i1);
        if ((localObject instanceof FolderItemView))
        {
          localObject = (FolderItemView)localObject;
          cmy.b((View)localObject, c, paramFloat);
          if (d) {
            cmy.b((View)localObject, paramFloat);
          }
        }
        for (;;)
        {
          i1 += 1;
          break;
          cmy.b(b, paramFloat);
          continue;
          cmy.b((View)localObject, C, paramFloat);
          cmy.b((View)localObject, paramFloat);
        }
      }
    }
    else
    {
      z.setAlpha(1.0F - paramFloat);
      c.setAlpha(paramFloat);
    }
  }
  
  final void b(Account paramAccount)
  {
    n = 1;
    o = 2;
    q = paramAccount;
    h.a(true, q, e(q));
    buo.a().a("switch_account", "drawer_account_switch", null, 0L);
  }
  
  final boolean b(Folder paramFolder)
  {
    if (f == null) {
      return false;
    }
    Iterator localIterator = f.iterator();
    while (localIterator.hasNext()) {
      if (paramFolder.d(((Integer)localIterator.next()).intValue())) {
        return true;
      }
    }
    return false;
  }
  
  public final void c(Account paramAccount)
  {
    if ((p == null) || (paramAccount == null) || (!p.c.equals(c))) {
      b.x();
    }
    if ((paramAccount != null) && (i.equals(z.i)))
    {
      h.a(false, q, e(q));
      return;
    }
    b(paramAccount);
  }
  
  public final Account[] c()
  {
    if (K != null) {
      return K.b();
    }
    return new Account[0];
  }
  
  public void c_(int paramInt)
  {
    Object localObject1 = getListView().getAdapter().getItem(paramInt);
    cvm.b(a, "viewFolderOrChangeAccount(%d): %s", new Object[] { Integer.valueOf(paramInt), localObject1 });
    if ((localObject1 instanceof cdi))
    {
      localObject2 = (cdi)localObject1;
      switch (((cdi)localObject2).b())
      {
      case 1: 
      case 2: 
      case 3: 
      case 4: 
      case 6: 
      default: 
        localObject2 = a;
        localObject1 = String.valueOf(localObject1);
        cvm.b((String)localObject2, String.valueOf(localObject1).length() + 100 + "FolderListFragment: viewFolderOrChangeAccount(): Clicked on unset item in drawer. Offending item is " + (String)localObject1, new Object[0]);
      case 5: 
        do
        {
          return;
          c(b);
          paramInt = 0;
          localObject1 = null;
        } while (localObject1 == null);
        if (paramInt != 2) {
          break;
        }
      }
    }
    for (Object localObject2 = "recent";; localObject2 = "normal")
    {
      a((Folder)localObject1, (String)localObject2);
      return;
      localObject1 = a;
      paramInt = e;
      n = paramInt;
      o = p;
      cvm.b(a, "FLF.viewFolderOrChangeAccount folder=%s, type=%d", new Object[] { localObject1, Integer.valueOf(n) });
      break;
      ((cdi)localObject2).onClick(null);
      paramInt = 0;
      localObject1 = null;
      break;
      if ((localObject1 instanceof Folder))
      {
        localObject1 = (Folder)localObject1;
        paramInt = 0;
        break;
      }
      cvm.f(a, "viewFolderOrChangeAccount(): invalid item", new Object[0]);
      paramInt = 0;
      localObject1 = null;
      break;
    }
  }
  
  public cno d()
  {
    return new cno();
  }
  
  final void d(Account paramAccount)
  {
    int i1;
    if ((paramAccount != null) && ((p == null) || (!p.g.equals(g))))
    {
      i1 = 1;
      p = paramAccount;
      if (i1 == 0) {
        break label100;
      }
      G.a();
      m.a(null);
      i();
      i = cus.a;
      j = null;
      if (M != null) {
        M.a(c(), p);
      }
    }
    label100:
    while (paramAccount != null)
    {
      return;
      i1 = 0;
      break;
    }
    cvm.e(a, "FLF.setSelectedAccount(null) called! Destroying existing loader.", new Object[0]);
    paramAccount = getLoaderManager();
    paramAccount.destroyLoader(0);
    paramAccount.destroyLoader(1);
  }
  
  public final boolean e()
  {
    return (y) && (L);
  }
  
  public int f()
  {
    return 0;
  }
  
  public Comparator<cdi> g()
  {
    return null;
  }
  
  public ListAdapter getListAdapter()
  {
    throw new UnsupportedOperationException("Use getListView().getAdapter() instead which accounts for any header or footer views.");
  }
  
  public void h()
  {
    if (!e)
    {
      if (l != null)
      {
        cno localcno = l;
        Account[] arrayOfAccount = c();
        ArrayList localArrayList = new ArrayList(arrayOfAccount.length);
        if (p == null) {}
        for (Uri localUri = Uri.EMPTY;; localUri = p.g)
        {
          int i2 = arrayOfAccount.length;
          int i1 = 0;
          while (i1 < i2)
          {
            Account localAccount = arrayOfAccount[i1];
            a(localAccount);
            localArrayList.add(new cdc(b, localAccount, localUri.equals(g), v, w));
            i1 += 1;
          }
        }
        if (p == null) {
          cvm.f(a, "buildAccountListDrawerItems() with null current account.", new Object[0]);
        }
        a = localArrayList;
        localcno.notifyDataSetChanged();
      }
      if (M != null) {
        M.a(c(), p);
      }
    }
  }
  
  final void i()
  {
    LoaderManager localLoaderManager = getLoaderManager();
    localLoaderManager.destroyLoader(0);
    localLoaderManager.restartLoader(0, Bundle.EMPTY, this);
    localLoaderManager.destroyLoader(1);
    localLoaderManager.restartLoader(1, Bundle.EMPTY, this);
  }
  
  public void j()
  {
    M = new cnw(this);
  }
  
  public ListAdapter k()
  {
    return M;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    paramBundle = getActivity();
    if (!(paramBundle instanceof ckv)) {
      cvm.f(a, "FolderListFragment expects only a ControllableActivity tocreate it. Cannot proceed.", new Object[0]);
    }
    int i1;
    label161:
    label201:
    label234:
    do
    {
      return;
      b = ((ckv)paramBundle);
      A = getResources().getDimensionPixelSize(bua.a);
      i1 = getActivity().getResources().getDimensionPixelSize(bua.a);
      if (!cud.a(getActivity())) {
        break;
      }
      i1 = 0;
      v = new anp(i1);
      w = new bvd(getActivity(), v);
      if (!y) {
        break label560;
      }
      j();
      paramBundle = z;
      a = this;
      a.k().registerDataSetObserver(new coz(paramBundle));
      a(e(), true);
      paramBundle = b.m();
      H = new cnl(this);
      if (paramBundle == null) {
        break label572;
      }
      paramBundle = H.a(paramBundle);
      j = paramBundle;
      if (F == null) {
        break label577;
      }
      m = new cnv(this, F);
      paramBundle = b.j();
      l = d();
      G = new cnu(this);
      if ((paramBundle != null) && (!c.equals(i))) {
        a(paramBundle);
      }
      paramBundle = b.n();
      I = new cnm(this);
      g = b.i();
      E = b.p();
      if (paramBundle != null)
      {
        h = paramBundle;
        d(I.a(paramBundle));
        K = new cnn(this);
        K.a(paramBundle);
        J = new cnt(this);
        h.e(J);
        if (E != null) {
          E.a(u);
        }
      }
    } while (b.isFinishing());
    c.setChoiceMode(b());
    k = new byn();
    if (l != null) {
      k.a(new ListAdapter[] { l, m, G });
    }
    for (;;)
    {
      s = new cgn(b, this);
      s.a(c());
      setListAdapter(k);
      paramBundle = getActivity();
      if (cmy.b == null) {
        cmy.b = new cmy(paramBundle);
      }
      B = cmy.b;
      return;
      i1 = i1 * i1 * 10;
      break;
      label560:
      z.setVisibility(8);
      break label161;
      label572:
      paramBundle = null;
      break label201;
      label577:
      m = new cnq(this, d);
      break label234;
      k.a(new ListAdapter[] { m, G });
    }
  }
  
  public Loader<ccy<Folder>> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    if (paramInt == 0) {
      if (D != null) {
        paramBundle = D;
      }
    }
    for (;;)
    {
      return new ccz(b.g(), paramBundle, chh.i, Folder.y);
      paramBundle = p.i;
      continue;
      if (paramInt != 1) {
        break;
      }
      paramBundle = p.k;
    }
    cvm.f(a, "FLF.onCreateLoader() with weird type", new Object[0]);
    return null;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      F = ((Folder)localBundle.getParcelable("arg-parent-folder"));
      String str = localBundle.getString("arg-folder-list-uri");
      if (str != null) {
        D = Uri.parse(str);
      }
      f = localBundle.getIntegerArrayList("arg-excluded-folder-types");
    }
    paramViewGroup = paramLayoutInflater.inflate(bue.E, paramViewGroup, false);
    c = ((ListView)paramViewGroup.findViewById(16908298));
    c.setEmptyView(null);
    c.setDivider(null);
    z = ((MiniDrawerView)paramViewGroup.findViewById(buc.cO));
    a(paramLayoutInflater, paramViewGroup, c);
    if ((paramBundle != null) && (paramBundle.containsKey("flf-list-state"))) {
      c.onRestoreInstanceState(paramBundle.getParcelable("flf-list-state"));
    }
    if ((paramBundle != null) && (paramBundle.containsKey("flf-selected-folder")))
    {
      i = new cus(Uri.parse(paramBundle.getString("flf-selected-folder")));
      n = paramBundle.getInt("flf-selected-item-type");
      o = paramBundle.getInt("flf-selected-type");
      if ((paramBundle != null) && (!paramBundle.getBoolean("flf-inbox-present", true))) {
        break label255;
      }
    }
    label255:
    for (boolean bool = true;; bool = false)
    {
      x = bool;
      return paramViewGroup;
      if (F == null) {
        break;
      }
      i = F.c;
      break;
    }
  }
  
  public void onDestroyView()
  {
    if (m != null) {
      m.d();
    }
    setListAdapter(null);
    if (H != null)
    {
      H.a();
      H = null;
    }
    if (I != null)
    {
      I.a();
      I = null;
    }
    if (K != null)
    {
      K.c();
      K = null;
    }
    if ((J != null) && (h != null))
    {
      h.f(J);
      J = null;
    }
    super.onDestroyView();
    if ((b != null) && (E != null))
    {
      E.b(u);
      E = null;
    }
  }
  
  public void onListItemClick(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    c_(paramInt);
  }
  
  public void onLoaderReset(Loader<ccy<Folder>> paramLoader)
  {
    if (m != null)
    {
      if (paramLoader.getId() != 0) {
        break label25;
      }
      m.a(null);
    }
    label25:
    while (paramLoader.getId() != 1) {
      return;
    }
    m.b(null);
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (c != null) {
      paramBundle.putParcelable("flf-list-state", c.onSaveInstanceState());
    }
    if (i != null) {
      paramBundle.putString("flf-selected-folder", i.toString());
    }
    paramBundle.putInt("flf-selected-item-type", n);
    paramBundle.putInt("flf-selected-type", o);
    paramBundle.putBoolean("flf-inbox-present", x);
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(super.toString());
    localStringBuilder.setLength(localStringBuilder.length() - 1);
    localStringBuilder.append(" folder=");
    localStringBuilder.append(D);
    localStringBuilder.append(" parent=");
    localStringBuilder.append(F);
    localStringBuilder.append(" adapterCount=");
    if (k != null) {}
    for (int i1 = k.getCount();; i1 = -1)
    {
      localStringBuilder.append(i1);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
  }
}

/* Location:
 * Qualified Name:     cnk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */