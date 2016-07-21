package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import emj;
import fwe;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class DefaultPersonImpl$Metadata
  extends FastJsonResponse
  implements SafeParcelable
{
  public static final fwe CREATOR = new fwe();
  private static final HashMap<String, FastJsonResponse.Field<?, ?>> t;
  final Set<Integer> a;
  final int b;
  List<DefaultPersonImpl.Metadata.Affinities> c;
  List<String> d;
  List<String> e;
  boolean f;
  List<String> g;
  List<String> h;
  boolean i;
  List<String> j;
  boolean k;
  List<String> l;
  long m;
  String n;
  String o;
  List<String> p;
  List<DefaultPersonImpl> q;
  String r;
  DefaultPersonImpl.Metadata.ProfileOwnerStats s;
  
  static
  {
    HashMap localHashMap = new HashMap();
    t = localHashMap;
    localHashMap.put("affinities", FastJsonResponse.Field.b("affinities", 2, DefaultPersonImpl.Metadata.Affinities.class));
    t.put("attributions", FastJsonResponse.Field.e("attributions", 3));
    t.put("blockTypes", FastJsonResponse.Field.e("blockTypes", 4));
    t.put("blocked", FastJsonResponse.Field.c("blocked", 5));
    t.put("circles", FastJsonResponse.Field.e("circles", 6));
    t.put("contacts", FastJsonResponse.Field.e("contacts", 7));
    t.put("deleted", FastJsonResponse.Field.c("deleted", 8));
    t.put("groups", FastJsonResponse.Field.e("groups", 9));
    t.put("inViewerDomain", FastJsonResponse.Field.c("inViewerDomain", 10));
    t.put("incomingBlockTypes", FastJsonResponse.Field.e("incomingBlockTypes", 11));
    t.put("lastUpdateTimeMicros", FastJsonResponse.Field.b("lastUpdateTimeMicros", 12));
    t.put("objectType", FastJsonResponse.Field.d("objectType", 13));
    t.put("ownerId", FastJsonResponse.Field.d("ownerId", 14));
    t.put("ownerUserTypes", FastJsonResponse.Field.e("ownerUserTypes", 15));
    t.put("peopleInCommon", FastJsonResponse.Field.b("peopleInCommon", 16, DefaultPersonImpl.class));
    t.put("plusPageType", FastJsonResponse.Field.d("plusPageType", 17));
    t.put("profileOwnerStats", FastJsonResponse.Field.a("profileOwnerStats", 18, DefaultPersonImpl.Metadata.ProfileOwnerStats.class));
  }
  
  public DefaultPersonImpl$Metadata()
  {
    b = 1;
    a = new HashSet();
  }
  
  public DefaultPersonImpl$Metadata(Set<Integer> paramSet, int paramInt, List<DefaultPersonImpl.Metadata.Affinities> paramList, List<String> paramList1, List<String> paramList2, boolean paramBoolean1, List<String> paramList3, List<String> paramList4, boolean paramBoolean2, List<String> paramList5, boolean paramBoolean3, List<String> paramList6, long paramLong, String paramString1, String paramString2, List<String> paramList7, List<DefaultPersonImpl> paramList8, String paramString3, DefaultPersonImpl.Metadata.ProfileOwnerStats paramProfileOwnerStats)
  {
    a = paramSet;
    b = paramInt;
    c = paramList;
    d = paramList1;
    e = paramList2;
    f = paramBoolean1;
    g = paramList3;
    h = paramList4;
    i = paramBoolean2;
    j = paramList5;
    k = paramBoolean3;
    l = paramList6;
    m = paramLong;
    n = paramString1;
    o = paramString2;
    p = paramList7;
    q = paramList8;
    r = paramString3;
    s = paramProfileOwnerStats;
  }
  
  protected final boolean a(FastJsonResponse.Field paramField)
  {
    return a.contains(Integer.valueOf(g));
  }
  
  protected final Object b()
  {
    return null;
  }
  
  protected final Object b(FastJsonResponse.Field paramField)
  {
    switch (g)
    {
    default: 
      throw new IllegalStateException("Unknown safe parcelable id=" + g);
    case 2: 
      return c;
    case 3: 
      return d;
    case 4: 
      return e;
    case 5: 
      return Boolean.valueOf(f);
    case 6: 
      return g;
    case 7: 
      return h;
    case 8: 
      return Boolean.valueOf(i);
    case 9: 
      return j;
    case 10: 
      return Boolean.valueOf(k);
    case 11: 
      return l;
    case 12: 
      return Long.valueOf(m);
    case 13: 
      return n;
    case 14: 
      return o;
    case 15: 
      return p;
    case 16: 
      return q;
    case 17: 
      return r;
    }
    return s;
  }
  
  protected final boolean c()
  {
    return false;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Metadata)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (Metadata)paramObject;
    Iterator localIterator = t.values().iterator();
    while (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (a(localField))
      {
        if (((Metadata)paramObject).a(localField))
        {
          if (!b(localField).equals(((Metadata)paramObject).b(localField))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((Metadata)paramObject).a(localField)) {
        return false;
      }
    }
    return true;
  }
  
  public final int hashCode()
  {
    Iterator localIterator = t.values().iterator();
    int i1 = 0;
    if (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (!a(localField)) {
        break label68;
      }
      int i2 = g;
      i1 = b(localField).hashCode() + (i1 + i2);
    }
    label68:
    for (;;)
    {
      break;
      return i1;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1 = emj.a(paramParcel, 20293);
    Set localSet = a;
    if (localSet.contains(Integer.valueOf(1))) {
      emj.b(paramParcel, 1, b);
    }
    if (localSet.contains(Integer.valueOf(2))) {
      emj.b(paramParcel, 2, c, true);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      emj.a(paramParcel, 3, d, true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      emj.a(paramParcel, 4, e, true);
    }
    if (localSet.contains(Integer.valueOf(5))) {
      emj.a(paramParcel, 5, f);
    }
    if (localSet.contains(Integer.valueOf(6))) {
      emj.a(paramParcel, 6, g, true);
    }
    if (localSet.contains(Integer.valueOf(7))) {
      emj.a(paramParcel, 7, h, true);
    }
    if (localSet.contains(Integer.valueOf(8))) {
      emj.a(paramParcel, 8, i);
    }
    if (localSet.contains(Integer.valueOf(9))) {
      emj.a(paramParcel, 9, j, true);
    }
    if (localSet.contains(Integer.valueOf(10))) {
      emj.a(paramParcel, 10, k);
    }
    if (localSet.contains(Integer.valueOf(11))) {
      emj.a(paramParcel, 11, l, true);
    }
    if (localSet.contains(Integer.valueOf(12))) {
      emj.a(paramParcel, 12, m);
    }
    if (localSet.contains(Integer.valueOf(13))) {
      emj.a(paramParcel, 13, n, true);
    }
    if (localSet.contains(Integer.valueOf(14))) {
      emj.a(paramParcel, 14, o, true);
    }
    if (localSet.contains(Integer.valueOf(15))) {
      emj.a(paramParcel, 15, p, true);
    }
    if (localSet.contains(Integer.valueOf(17))) {
      emj.a(paramParcel, 17, r, true);
    }
    if (localSet.contains(Integer.valueOf(16))) {
      emj.b(paramParcel, 16, q, true);
    }
    if (localSet.contains(Integer.valueOf(18))) {
      emj.a(paramParcel, 18, s, paramInt, true);
    }
    emj.b(paramParcel, i1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Metadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */