import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.android.mail.providers.Account;
import com.android.mail.providers.Folder;
import com.android.mail.ui.FolderItemView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

final class cnq
  extends BaseAdapter
  implements cns
{
  private final cgz b = new cnr(this);
  private final cpp c;
  private final boolean d;
  private List<cdi> e = new ArrayList();
  private ccy<Folder> f = null;
  private ccy<Folder> g = null;
  
  public cnq(cnk paramcnk, boolean paramBoolean)
  {
    d = paramBoolean;
    paramcnk = b.o();
    if ((paramcnk != null) && (d))
    {
      cgz localcgz = b;
      if (paramcnk == null) {
        throw new IllegalArgumentException("RecentFolderObserver initialized with null controller!");
      }
      a = paramcnk;
      a.g(localcgz);
      c = a.m();
      return;
    }
    c = null;
  }
  
  private final List<cdi> a(List<cdi> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    new ArrayList();
    for (;;)
    {
      Folder localFolder = (Folder)f.f();
      if ((!a.b(localFolder)) && (!localFolder.d(8192)))
      {
        if (!localFolder.d(8194)) {
          break label118;
        }
        localArrayList1.add(cdi.a(a.b, localFolder, 3));
      }
      while (!f.moveToNext())
      {
        paramList.addAll(localArrayList1);
        paramList.addAll(localArrayList2);
        return paramList;
        label118:
        localArrayList2.add(cdi.a(a.b, localFolder, 3));
      }
    }
  }
  
  private final void a(List<cdi> paramList1, List<cdi> paramList2, int paramInt)
  {
    if (paramList2.size() > 0)
    {
      if (paramInt == 0) {
        break label40;
      }
      paramList1.add(cdi.a(a.b, paramInt));
    }
    for (;;)
    {
      paramList1.addAll(paramList2);
      return;
      label40:
      if (paramList1.size() == 0) {
        paramList1.add(new cdp(a.b));
      } else {
        paramList1.add(cdi.a(a.b));
      }
    }
  }
  
  private final List<cdi> b(List<cdi> paramList)
  {
    Object localObject1 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject2 = (Folder)f.f();
    label105:
    int i;
    if ((localObject2 != null) && (!a.b((Folder)localObject2)))
    {
      if (((Folder)localObject2).d(8192)) {
        ((List)localObject1).add(cdi.a(a.b, (Folder)localObject2, 1));
      }
    }
    else
    {
      if (f.moveToNext()) {
        break label555;
      }
      if (g != null)
      {
        localObject2 = a.i.toString();
        cvm.b(cnk.a, "Checking if all folder list contains %s", new Object[] { localObject2 });
        if (!g.moveToFirst()) {
          break label569;
        }
        cvm.b(cnk.a, "Cursor for %s seems reasonably valid", new Object[] { localObject2 });
        i = 0;
        label182:
        Folder localFolder = (Folder)g.f();
        if ((a.b(localFolder)) || (!c.equals(a.i))) {
          break label566;
        }
        cvm.b(cnk.a, "Found %s !", new Object[] { localObject2 });
        i = 1;
        label244:
        j = i;
        if (i == 0) {
          if (g.moveToNext()) {
            break label563;
          }
        }
      }
    }
    label555:
    label563:
    label566:
    label569:
    for (int j = i;; j = 0)
    {
      if ((j == 0) && (!Folder.a(4096, a.o)) && (a.i != cus.a) && (a.p != null) && (a.h != null) && (a.h.ai()))
      {
        cvm.b(cnk.a, "Current folder (%1$s) has disappeared for %2$s", new Object[] { localObject2, a.p.c });
        a.b(a.p);
      }
      localObject2 = a;
      if (localArrayList3.size() > 0) {}
      for (boolean bool = true;; bool = false)
      {
        x = bool;
        a(paramList, (List)localObject1, 0);
        a(paramList, localArrayList3, 0);
        c(paramList);
        localObject1 = a.g();
        if (localObject1 != null) {
          Collections.sort(localArrayList1, (Comparator)localObject1);
        }
        localArrayList2.addAll(localArrayList1);
        a(paramList, localArrayList2, buj.m);
        return paramList;
        if (((Folder)localObject2).d(8194))
        {
          localArrayList3.add(cdi.a(a.b, (Folder)localObject2, 1));
          break label105;
        }
        if (((Folder)localObject2).d(1))
        {
          localArrayList1.add(cdi.a(a.b, (Folder)localObject2, 3));
          break label105;
        }
        localArrayList2.add(cdi.a(a.b, (Folder)localObject2, 3));
        break label105;
        break;
      }
      break label182;
      break label244;
    }
  }
  
  private final void c(List<cdi> paramList)
  {
    Object localObject2 = c;
    Object localObject1 = new ArrayList();
    if (localObject2 != null)
    {
      localObject2 = ((cpp)localObject2).a().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Folder localFolder = (Folder)((Iterator)localObject2).next();
        if (!localFolder.a()) {
          ((List)localObject1).add(localFolder);
        }
      }
    }
    if (a.f != null)
    {
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext()) {
        if (a.b((Folder)((Iterator)localObject2).next())) {
          ((Iterator)localObject2).remove();
        }
      }
    }
    if (((List)localObject1).size() > 0)
    {
      paramList.add(cdi.a(a.b, buj.dZ));
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Folder)((Iterator)localObject1).next();
        paramList.add(cdi.a(a.b, (Folder)localObject2, 2));
      }
    }
  }
  
  final void a()
  {
    boolean bool = a.x;
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if (b())
    {
      localObject = localArrayList;
      if (!a.p.f())
      {
        localArrayList.add(new cdq(a.b));
        localObject = localArrayList;
      }
    }
    for (;;)
    {
      e = ((List)localObject);
      if ((a.h != null) && (a.x) && (!bool)) {
        a.h.a(a.p);
      }
      notifyDataSetChanged();
      return;
      if (d) {
        localObject = b(localArrayList);
      } else {
        localObject = a(localArrayList);
      }
    }
  }
  
  public final void a(ccy<Folder> paramccy)
  {
    f = paramccy;
    a.h();
    a();
  }
  
  public final boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public final void b(ccy<Folder> paramccy)
  {
    g = paramccy;
    a.h();
    a();
  }
  
  final boolean b()
  {
    return (f == null) || (f.isClosed()) || (f.getCount() <= 0) || (!f.moveToFirst());
  }
  
  public final ccy<Folder> c()
  {
    return f;
  }
  
  public final void d()
  {
    cgz localcgz = b;
    if (a != null) {
      a.h(localcgz);
    }
  }
  
  public final int getCount()
  {
    return e.size();
  }
  
  public final Object getItem(int paramInt)
  {
    if (paramInt >= e.size()) {
      return null;
    }
    return e.get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return getItem(paramInt).hashCode();
  }
  
  public final int getItemViewType(int paramInt)
  {
    return ((cdi)getItem(paramInt)).b();
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    cdi localcdi = (cdi)getItem(paramInt);
    paramView = localcdi.a(paramView, paramViewGroup);
    int j = localcdi.b();
    boolean bool = localcdi.a(a.i, a.n);
    if (j == 0)
    {
      paramViewGroup = a.c;
      if (a.l == null) {
        break label162;
      }
    }
    label162:
    for (int i = a.l.getCount();; i = 0)
    {
      paramViewGroup.setItemChecked(i + paramInt + a.c.getHeaderViewsCount(), bool);
      if ((j == 0) && (bool) && (a.j != null) && (a.k != a.j.k)) {
        ((FolderItemView)paramView).a(a.j.k);
      }
      return paramView;
    }
  }
  
  public final int getViewTypeCount()
  {
    return 10;
  }
  
  public final boolean isEnabled(int paramInt)
  {
    cdi localcdi = (cdi)getItem(paramInt);
    return (localcdi != null) && (localcdi.a());
  }
}

/* Location:
 * Qualified Name:     cnq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */