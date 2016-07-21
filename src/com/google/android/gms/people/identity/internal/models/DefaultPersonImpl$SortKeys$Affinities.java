package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import emj;
import fuf;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class DefaultPersonImpl$SortKeys$Affinities
  extends FastJsonResponse
  implements SafeParcelable
{
  public static final fuf CREATOR = new fuf();
  private static final HashMap<String, FastJsonResponse.Field<?, ?>> e;
  final Set<Integer> a;
  final int b;
  String c;
  double d;
  
  static
  {
    HashMap localHashMap = new HashMap();
    e = localHashMap;
    localHashMap.put("type", FastJsonResponse.Field.d("type", 2));
    e.put("value", FastJsonResponse.Field.a("value"));
  }
  
  public DefaultPersonImpl$SortKeys$Affinities()
  {
    b = 1;
    a = new HashSet();
  }
  
  public DefaultPersonImpl$SortKeys$Affinities(Set<Integer> paramSet, int paramInt, String paramString, double paramDouble)
  {
    a = paramSet;
    b = paramInt;
    c = paramString;
    d = paramDouble;
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
    }
    return Double.valueOf(d);
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
    if (!(paramObject instanceof Affinities)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (Affinities)paramObject;
    Iterator localIterator = e.values().iterator();
    while (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (a(localField))
      {
        if (((Affinities)paramObject).a(localField))
        {
          if (!b(localField).equals(((Affinities)paramObject).b(localField))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((Affinities)paramObject).a(localField)) {
        return false;
      }
    }
    return true;
  }
  
  public final int hashCode()
  {
    Iterator localIterator = e.values().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (!a(localField)) {
        break label68;
      }
      int j = g;
      i = b(localField).hashCode() + (i + j);
    }
    label68:
    for (;;)
    {
      break;
      return i;
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
      emj.a(paramParcel, 2, c, true);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      emj.a(paramParcel, d);
    }
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.SortKeys.Affinities
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */