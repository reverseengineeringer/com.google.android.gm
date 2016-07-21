package com.google.android.gms.auth.firstparty.proximity.data;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import egd;
import emj;
import enz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Permit
  implements SafeParcelable
{
  public static final egd CREATOR = new egd();
  final int a;
  final String b;
  final String c;
  final String d;
  final PermitAccess e;
  List<PermitAccess> f;
  final Map<String, PermitAccess> g;
  List<String> h;
  final Set<String> i;
  
  public Permit(int paramInt, String paramString1, String paramString2, String paramString3, PermitAccess paramPermitAccess, List<PermitAccess> paramList, List<String> paramList1)
  {
    this(paramInt, paramString1, paramString2, paramString3, paramPermitAccess, a(paramList), new HashSet(paramList1));
  }
  
  private Permit(int paramInt, String paramString1, String paramString2, String paramString3, PermitAccess paramPermitAccess, Map<String, PermitAccess> paramMap, Set<String> paramSet)
  {
    a = paramInt;
    b = enz.a(paramString1);
    c = enz.a(paramString2);
    d = enz.a(paramString3);
    e = ((PermitAccess)enz.a(paramPermitAccess));
    if (paramMap == null) {}
    for (paramString1 = new HashMap();; paramString1 = new HashMap(paramMap))
    {
      g = paramString1;
      i = new HashSet(paramSet);
      return;
    }
  }
  
  private static Map<String, PermitAccess> a(List<PermitAccess> paramList)
  {
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PermitAccess localPermitAccess = (PermitAccess)paramList.next();
      localHashMap.put(b, localPermitAccess);
    }
    return localHashMap;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
        if (paramObject == this) {
          return true;
        }
      } while (!(paramObject instanceof Permit));
      paramObject = (Permit)paramObject;
    } while ((!TextUtils.equals(c, c)) || (!TextUtils.equals(b, b)) || (!TextUtils.equals(d, d)) || (!e.equals(e)) || (!i.equals(i)) || (!g.equals(g)));
    return true;
  }
  
  public int hashCode()
  {
    return (((((b.hashCode() + 527) * 31 + c.hashCode()) * 31 + d.hashCode()) * 31 + i.hashCode()) * 31 + e.hashCode()) * 31 + g.hashCode();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    f = new ArrayList(g.values());
    h = new ArrayList(i);
    int j = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, false);
    emj.a(paramParcel, 3, c, false);
    emj.a(paramParcel, 5, d, false);
    emj.a(paramParcel, 6, e, paramInt, false);
    emj.b(paramParcel, 7, f, false);
    emj.a(paramParcel, 8, h, false);
    emj.b(paramParcel, j);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.proximity.data.Permit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */