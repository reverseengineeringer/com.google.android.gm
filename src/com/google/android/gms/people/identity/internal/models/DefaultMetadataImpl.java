package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import emj;
import fvo;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class DefaultMetadataImpl
  extends FastJsonResponse
  implements SafeParcelable
{
  public static final fvo CREATOR = new fvo();
  private static final HashMap<String, FastJsonResponse.Field<?, ?>> l;
  final Set<Integer> a;
  final int b;
  List<DefaultMetadataImpl.Affinities> c;
  String d;
  String e;
  String f;
  boolean g;
  boolean h;
  boolean i;
  String j;
  boolean k;
  
  static
  {
    HashMap localHashMap = new HashMap();
    l = localHashMap;
    localHashMap.put("affinities", FastJsonResponse.Field.b("affinities", 2, DefaultMetadataImpl.Affinities.class));
    l.put("container", FastJsonResponse.Field.d("container", 3));
    l.put("containerContactId", FastJsonResponse.Field.d("containerContactId", 4));
    l.put("containerId", FastJsonResponse.Field.d("containerId", 5));
    l.put("edgeKey", FastJsonResponse.Field.c("edgeKey", 6));
    l.put("primary", FastJsonResponse.Field.c("primary", 7));
    l.put("verified", FastJsonResponse.Field.c("verified", 8));
    l.put("visibility", FastJsonResponse.Field.d("visibility", 9));
    l.put("writeable", FastJsonResponse.Field.c("writeable", 10));
  }
  
  public DefaultMetadataImpl()
  {
    b = 1;
    a = new HashSet();
  }
  
  public DefaultMetadataImpl(Set<Integer> paramSet, int paramInt, List<DefaultMetadataImpl.Affinities> paramList, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString4, boolean paramBoolean4)
  {
    a = paramSet;
    b = paramInt;
    c = paramList;
    d = paramString1;
    e = paramString2;
    f = paramString3;
    g = paramBoolean1;
    h = paramBoolean2;
    i = paramBoolean3;
    j = paramString4;
    k = paramBoolean4;
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
      return f;
    case 6: 
      return Boolean.valueOf(g);
    case 7: 
      return Boolean.valueOf(h);
    case 8: 
      return Boolean.valueOf(i);
    case 9: 
      return j;
    }
    return Boolean.valueOf(k);
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
    if (!(paramObject instanceof DefaultMetadataImpl)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (DefaultMetadataImpl)paramObject;
    Iterator localIterator = l.values().iterator();
    while (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (a(localField))
      {
        if (((DefaultMetadataImpl)paramObject).a(localField))
        {
          if (!b(localField).equals(((DefaultMetadataImpl)paramObject).b(localField))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((DefaultMetadataImpl)paramObject).a(localField)) {
        return false;
      }
    }
    return true;
  }
  
  public final int hashCode()
  {
    Iterator localIterator = l.values().iterator();
    int m = 0;
    if (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (!a(localField)) {
        break label68;
      }
      int n = g;
      m = b(localField).hashCode() + (m + n);
    }
    label68:
    for (;;)
    {
      break;
      return m;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
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
      emj.a(paramParcel, 5, f, true);
    }
    if (localSet.contains(Integer.valueOf(6))) {
      emj.a(paramParcel, 6, g);
    }
    if (localSet.contains(Integer.valueOf(7))) {
      emj.a(paramParcel, 7, h);
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
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.people.identity.internal.models.DefaultMetadataImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */