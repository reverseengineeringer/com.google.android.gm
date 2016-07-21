import android.accounts.Account;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class bhx
  extends BaseAdapter
  implements Filterable, biw
{
  public final bja a;
  public final int b;
  public final Context c;
  public Account d;
  public final int e;
  public bim f;
  LinkedHashMap<Long, List<bkn>> g;
  List<bkn> h;
  Set<String> i;
  public List<bkn> j;
  int k;
  public CharSequence l;
  public biv m;
  public boolean n;
  public bih o;
  final bia p = new bia(this);
  public bie q;
  private final ContentResolver r;
  private List<bkn> s;
  
  public bhx(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private bhx(Context paramContext, byte paramByte)
  {
    c = paramContext;
    r = paramContext.getContentResolver();
    e = 10;
    m = new bij(r);
    b = 0;
    a = bix.b;
  }
  
  public static List<bid> a(Context paramContext, Cursor paramCursor, Account paramAccount)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    ArrayList localArrayList = new ArrayList();
    paramContext = null;
    while (paramCursor.moveToNext())
    {
      long l1 = paramCursor.getLong(0);
      if (l1 != 1L)
      {
        bid localbid = new bid();
        String str = paramCursor.getString(4);
        int i1 = paramCursor.getInt(5);
        a = l1;
        c = paramCursor.getString(3);
        d = paramCursor.getString(1);
        e = paramCursor.getString(2);
        if ((str != null) && (i1 != 0)) {}
        try
        {
          b = localPackageManager.getResourcesForApplication(str).getString(i1);
          if (b == null) {
            Log.e("BaseRecipientAdapter", String.valueOf(str).length() + 43 + "Cannot resolve directory name: " + i1 + "@" + str);
          }
          if ((paramContext == null) && (paramAccount != null) && (name.equals(d)) && (type.equals(e))) {
            paramContext = localbid;
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          for (;;)
          {
            Log.e("BaseRecipientAdapter", String.valueOf(str).length() + 43 + "Cannot resolve directory name: " + i1 + "@" + str, localNameNotFoundException);
          }
          localArrayList.add(localbid);
        }
      }
    }
    if (paramContext != null) {
      localArrayList.add(1, paramContext);
    }
    return localArrayList;
  }
  
  static void a(bif parambif, boolean paramBoolean, LinkedHashMap<Long, List<bkn>> paramLinkedHashMap, List<bkn> paramList, Set<String> paramSet)
  {
    if (paramSet.contains(b)) {
      return;
    }
    paramSet.add(b);
    if (!paramBoolean)
    {
      paramList.add(bkn.a(a, i, b, c, d, e, f, g, h, j));
      return;
    }
    if (paramLinkedHashMap.containsKey(Long.valueOf(e)))
    {
      paramLinkedHashMap = (List)paramLinkedHashMap.get(Long.valueOf(e));
      String str2 = a;
      int i1 = i;
      paramList = b;
      int i2 = c;
      paramSet = d;
      long l1 = e;
      Long localLong = f;
      long l2 = g;
      String str3 = h;
      String str1 = j;
      str2 = bkn.a(i1, str2, paramList);
      if (str3 != null) {}
      for (parambif = Uri.parse(str3);; parambif = null)
      {
        paramLinkedHashMap.add(new bkn(0, str2, paramList, i2, paramSet, l1, localLong, l2, parambif, false, true, str1, null));
        return;
      }
    }
    paramList = new ArrayList();
    paramList.add(bkn.a(a, i, b, c, d, e, f, g, h, j));
    paramLinkedHashMap.put(Long.valueOf(e), paramList);
  }
  
  private final List<bkn> f()
  {
    if (j != null) {
      return j;
    }
    return s;
  }
  
  final Cursor a(CharSequence paramCharSequence, int paramInt, Long paramLong)
  {
    if (!big.a(c, o)) {
      return null;
    }
    paramCharSequence = a.b.buildUpon().appendPath(paramCharSequence.toString()).appendQueryParameter("limit", String.valueOf(paramInt + 5));
    if (paramLong != null) {
      paramCharSequence.appendQueryParameter("directory", String.valueOf(paramLong));
    }
    if (d != null)
    {
      paramCharSequence.appendQueryParameter("name_for_primary_account", d.name);
      paramCharSequence.appendQueryParameter("type_for_primary_account", d.type);
    }
    System.currentTimeMillis();
    paramCharSequence = r.query(paramCharSequence.build(), a.a, null, null, null);
    System.currentTimeMillis();
    return paramCharSequence;
  }
  
  public final bkn a(int paramInt)
  {
    return (bkn)f().get(paramInt);
  }
  
  final List<bkn> a(LinkedHashMap<Long, List<bkn>> paramLinkedHashMap, List<bkn> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramLinkedHashMap = paramLinkedHashMap.entrySet().iterator();
    int i1 = 0;
    if (paramLinkedHashMap.hasNext())
    {
      List localList = (List)((Map.Entry)paramLinkedHashMap.next()).getValue();
      int i3 = localList.size();
      int i2 = 0;
      while (i2 < i3)
      {
        bkn localbkn = (bkn)localList.get(i2);
        localArrayList.add(localbkn);
        m.a(localbkn, this);
        i1 += 1;
        i2 += 1;
      }
      if (i1 <= e) {}
    }
    for (;;)
    {
      if (i1 <= e)
      {
        paramLinkedHashMap = paramList.iterator();
        while (paramLinkedHashMap.hasNext())
        {
          paramList = (bkn)paramLinkedHashMap.next();
          if (i1 > e) {
            break;
          }
          localArrayList.add(paramList);
          m.a(paramList, this);
          i1 += 1;
        }
      }
      return localArrayList;
      break;
    }
  }
  
  public final List<bid> a(Set<String> paramSet)
  {
    List localList = null;
    if (!big.a(c, o)) {
      paramSet = null;
    }
    for (;;)
    {
      return paramSet;
      if (e - paramSet.size() > 0)
      {
        paramSet = localList;
        try
        {
          Cursor localCursor = r.query(bic.a, bic.b, null, null, null);
          paramSet = localCursor;
          localList = a(c, localCursor, d);
          paramSet = localList;
          return localList;
        }
        finally
        {
          if (paramSet != null) {
            paramSet.close();
          }
        }
      }
    }
    return null;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 > 1)) {
      j = s;
    }
  }
  
  public void a(bif parambif, boolean paramBoolean)
  {
    a(parambif, paramBoolean, g, h, i);
  }
  
  public final void a(CharSequence paramCharSequence, List<bid> paramList, int paramInt)
  {
    int i2 = paramList.size();
    int i1 = 1;
    while (i1 < i2)
    {
      bid localbid = (bid)paramList.get(i1);
      f = paramCharSequence;
      if (g == null) {
        g = new bib(this, localbid);
      }
      g.a(paramInt);
      g.filter(paramCharSequence);
      i1 += 1;
    }
    k = (i2 - 1);
    p.a();
  }
  
  public void a(ArrayList<String> paramArrayList, bjm parambjm)
  {
    bjk.a(c, this, paramArrayList, d, parambjm, o);
  }
  
  public final void a(List<bkn> paramList)
  {
    s = paramList;
    q.a(paramList);
    notifyDataSetChanged();
  }
  
  public boolean a()
  {
    return false;
  }
  
  public List<bkn> b()
  {
    return a(g, h);
  }
  
  public final void c() {}
  
  public final void d()
  {
    notifyDataSetChanged();
  }
  
  public final void e() {}
  
  public int getCount()
  {
    List localList = f();
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public Filter getFilter()
  {
    return new bhy(this);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return fgeta;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    bkn localbkn = (bkn)f().get(paramInt);
    if (l == null) {}
    for (String str = null;; str = l.toString()) {
      return f.a(paramView, paramViewGroup, localbkn, paramInt, biq.a, str, null);
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public boolean isEnabled(int paramInt)
  {
    bkn localbkn = (bkn)f().get(paramInt);
    return (a == 0) || (a == 1);
  }
}

/* Location:
 * Qualified Name:     bhx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */