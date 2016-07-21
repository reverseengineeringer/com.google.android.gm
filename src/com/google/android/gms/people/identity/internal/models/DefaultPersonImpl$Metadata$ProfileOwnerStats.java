package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import emj;
import fwg;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class DefaultPersonImpl$Metadata$ProfileOwnerStats
  extends FastJsonResponse
  implements SafeParcelable
{
  public static final fwg CREATOR = new fwg();
  private static final HashMap<String, FastJsonResponse.Field<?, ?>> e;
  final Set<Integer> a;
  final int b;
  long c;
  long d;
  
  static
  {
    HashMap localHashMap = new HashMap();
    e = localHashMap;
    localHashMap.put("incomingAnyCircleCount", FastJsonResponse.Field.b("incomingAnyCircleCount", 2));
    e.put("viewCount", FastJsonResponse.Field.b("viewCount", 3));
  }
  
  public DefaultPersonImpl$Metadata$ProfileOwnerStats()
  {
    b = 1;
    a = new HashSet();
  }
  
  public DefaultPersonImpl$Metadata$ProfileOwnerStats(Set<Integer> paramSet, int paramInt, long paramLong1, long paramLong2)
  {
    a = paramSet;
    b = paramInt;
    c = paramLong1;
    d = paramLong2;
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
      return Long.valueOf(c);
    }
    return Long.valueOf(d);
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
    if (!(paramObject instanceof ProfileOwnerStats)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (ProfileOwnerStats)paramObject;
    Iterator localIterator = e.values().iterator();
    while (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (a(localField))
      {
        if (((ProfileOwnerStats)paramObject).a(localField))
        {
          if (!b(localField).equals(((ProfileOwnerStats)paramObject).b(localField))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((ProfileOwnerStats)paramObject).a(localField)) {
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
      emj.a(paramParcel, 2, c);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      emj.a(paramParcel, 3, d);
    }
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Metadata.ProfileOwnerStats
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */