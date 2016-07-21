package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import emj;
import fwa;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class DefaultPersonImpl$Images
  extends FastJsonResponse
  implements SafeParcelable
{
  public static final fwa CREATOR = new fwa();
  private static final HashMap<String, FastJsonResponse.Field<?, ?>> f;
  final Set<Integer> a;
  final int b;
  boolean c;
  DefaultMetadataImpl d;
  String e;
  
  static
  {
    HashMap localHashMap = new HashMap();
    f = localHashMap;
    localHashMap.put("isDefault", FastJsonResponse.Field.c("isDefault", 2));
    f.put("metadata", FastJsonResponse.Field.a("metadata", 3, DefaultMetadataImpl.class));
    f.put("url", FastJsonResponse.Field.d("url", 4));
  }
  
  public DefaultPersonImpl$Images()
  {
    b = 1;
    a = new HashSet();
  }
  
  public DefaultPersonImpl$Images(Set<Integer> paramSet, int paramInt, boolean paramBoolean, DefaultMetadataImpl paramDefaultMetadataImpl, String paramString)
  {
    a = paramSet;
    b = paramInt;
    c = paramBoolean;
    d = paramDefaultMetadataImpl;
    e = paramString;
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
      return Boolean.valueOf(c);
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
    if (!(paramObject instanceof Images)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (Images)paramObject;
    Iterator localIterator = f.values().iterator();
    while (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (a(localField))
      {
        if (((Images)paramObject).a(localField))
        {
          if (!b(localField).equals(((Images)paramObject).b(localField))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((Images)paramObject).a(localField)) {
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
      emj.a(paramParcel, 2, c);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      emj.a(paramParcel, 3, d, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      emj.a(paramParcel, 4, e, true);
    }
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Images
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */