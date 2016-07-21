package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import emj;
import fvv;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class DefaultPersonImpl$CoverPhotos
  extends FastJsonResponse
  implements SafeParcelable
{
  public static final fvv CREATOR = new fvv();
  private static final HashMap<String, FastJsonResponse.Field<?, ?>> h;
  final Set<Integer> a;
  final int b;
  int c;
  String d;
  boolean e;
  String f;
  int g;
  
  static
  {
    HashMap localHashMap = new HashMap();
    h = localHashMap;
    localHashMap.put("height", FastJsonResponse.Field.a("height", 2));
    h.put("id", FastJsonResponse.Field.d("id", 3));
    h.put("isDefault", FastJsonResponse.Field.c("isDefault", 4));
    h.put("url", FastJsonResponse.Field.d("url", 5));
    h.put("width", FastJsonResponse.Field.a("width", 6));
  }
  
  public DefaultPersonImpl$CoverPhotos()
  {
    b = 1;
    a = new HashSet();
  }
  
  public DefaultPersonImpl$CoverPhotos(Set<Integer> paramSet, int paramInt1, int paramInt2, String paramString1, boolean paramBoolean, String paramString2, int paramInt3)
  {
    a = paramSet;
    b = paramInt1;
    c = paramInt2;
    d = paramString1;
    e = paramBoolean;
    f = paramString2;
    g = paramInt3;
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
      return Integer.valueOf(c);
    case 3: 
      return d;
    case 4: 
      return Boolean.valueOf(e);
    case 5: 
      return f;
    }
    return Integer.valueOf(g);
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
    if (!(paramObject instanceof CoverPhotos)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (CoverPhotos)paramObject;
    Iterator localIterator = h.values().iterator();
    while (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (a(localField))
      {
        if (((CoverPhotos)paramObject).a(localField))
        {
          if (!b(localField).equals(((CoverPhotos)paramObject).b(localField))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((CoverPhotos)paramObject).a(localField)) {
        return false;
      }
    }
    return true;
  }
  
  public final int hashCode()
  {
    Iterator localIterator = h.values().iterator();
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
      emj.b(paramParcel, 2, c);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      emj.a(paramParcel, 3, d, true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      emj.a(paramParcel, 4, e);
    }
    if (localSet.contains(Integer.valueOf(5))) {
      emj.a(paramParcel, 5, f, true);
    }
    if (localSet.contains(Integer.valueOf(6))) {
      emj.b(paramParcel, 6, g);
    }
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.CoverPhotos
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */