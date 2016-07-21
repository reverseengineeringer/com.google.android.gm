package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import emj;
import fvr;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class DefaultPersonImpl$Abouts
  extends FastJsonResponse
  implements SafeParcelable
{
  public static final fvr CREATOR = new fvr();
  private static final HashMap<String, FastJsonResponse.Field<?, ?>> f;
  final Set<Integer> a;
  final int b;
  DefaultMetadataImpl c;
  String d;
  String e;
  
  static
  {
    HashMap localHashMap = new HashMap();
    f = localHashMap;
    localHashMap.put("metadata", FastJsonResponse.Field.a("metadata", 2, DefaultMetadataImpl.class));
    f.put("type", FastJsonResponse.Field.d("type", 3));
    f.put("value", FastJsonResponse.Field.d("value", 4));
  }
  
  public DefaultPersonImpl$Abouts()
  {
    b = 1;
    a = new HashSet();
  }
  
  public DefaultPersonImpl$Abouts(Set<Integer> paramSet, int paramInt, DefaultMetadataImpl paramDefaultMetadataImpl, String paramString1, String paramString2)
  {
    a = paramSet;
    b = paramInt;
    c = paramDefaultMetadataImpl;
    d = paramString1;
    e = paramString2;
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
    }
    return e;
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
    if (!(paramObject instanceof Abouts)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (Abouts)paramObject;
    Iterator localIterator = f.values().iterator();
    while (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (a(localField))
      {
        if (((Abouts)paramObject).a(localField))
        {
          if (!b(localField).equals(((Abouts)paramObject).b(localField))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((Abouts)paramObject).a(localField)) {
        return false;
      }
    }
    return true;
  }
  
  public final int hashCode()
  {
    Iterator localIterator = f.values().iterator();
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
    int i = emj.a(paramParcel, 20293);
    Set localSet = a;
    if (localSet.contains(Integer.valueOf(1))) {
      emj.b(paramParcel, 1, b);
    }
    if (localSet.contains(Integer.valueOf(2))) {
      emj.a(paramParcel, 2, c, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      emj.a(paramParcel, 3, d, true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      emj.a(paramParcel, 4, e, true);
    }
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Abouts
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */