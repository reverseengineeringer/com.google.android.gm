package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import emj;
import fvx;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class DefaultPersonImpl$Emails
  extends FastJsonResponse
  implements SafeParcelable
{
  public static final fvx CREATOR = new fvx();
  private static final HashMap<String, FastJsonResponse.Field<?, ?>> g;
  final Set<Integer> a;
  final int b;
  String c;
  DefaultMetadataImpl d;
  String e;
  String f;
  
  static
  {
    HashMap localHashMap = new HashMap();
    g = localHashMap;
    localHashMap.put("formattedType", FastJsonResponse.Field.d("formattedType", 2));
    g.put("metadata", FastJsonResponse.Field.a("metadata", 3, DefaultMetadataImpl.class));
    g.put("type", FastJsonResponse.Field.d("type", 4));
    g.put("value", FastJsonResponse.Field.d("value", 5));
  }
  
  public DefaultPersonImpl$Emails()
  {
    b = 1;
    a = new HashSet();
  }
  
  public DefaultPersonImpl$Emails(Set<Integer> paramSet, int paramInt, String paramString1, DefaultMetadataImpl paramDefaultMetadataImpl, String paramString2, String paramString3)
  {
    a = paramSet;
    b = paramInt;
    c = paramString1;
    d = paramDefaultMetadataImpl;
    e = paramString2;
    f = paramString3;
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
    }
    return f;
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
    if (!(paramObject instanceof Emails)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (Emails)paramObject;
    Iterator localIterator = g.values().iterator();
    while (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (a(localField))
      {
        if (((Emails)paramObject).a(localField))
        {
          if (!b(localField).equals(((Emails)paramObject).b(localField))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((Emails)paramObject).a(localField)) {
        return false;
      }
    }
    return true;
  }
  
  public final int hashCode()
  {
    Iterator localIterator = g.values().iterator();
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
      emj.a(paramParcel, 2, c, true);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      emj.a(paramParcel, 3, d, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      emj.a(paramParcel, 4, e, true);
    }
    if (localSet.contains(Integer.valueOf(5))) {
      emj.a(paramParcel, 5, f, true);
    }
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Emails
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */