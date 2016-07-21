package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import emj;
import fwb;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class DefaultPersonImpl$InstantMessaging
  extends FastJsonResponse
  implements SafeParcelable
{
  public static final fwb CREATOR = new fwb();
  private static final HashMap<String, FastJsonResponse.Field<?, ?>> i;
  final Set<Integer> a;
  final int b;
  String c;
  String d;
  DefaultMetadataImpl e;
  String f;
  String g;
  String h;
  
  static
  {
    HashMap localHashMap = new HashMap();
    i = localHashMap;
    localHashMap.put("formattedProtocol", FastJsonResponse.Field.d("formattedProtocol", 2));
    i.put("formattedType", FastJsonResponse.Field.d("formattedType", 3));
    i.put("metadata", FastJsonResponse.Field.a("metadata", 4, DefaultMetadataImpl.class));
    i.put("protocol", FastJsonResponse.Field.d("protocol", 5));
    i.put("type", FastJsonResponse.Field.d("type", 6));
    i.put("value", FastJsonResponse.Field.d("value", 7));
  }
  
  public DefaultPersonImpl$InstantMessaging()
  {
    b = 1;
    a = new HashSet();
  }
  
  public DefaultPersonImpl$InstantMessaging(Set<Integer> paramSet, int paramInt, String paramString1, String paramString2, DefaultMetadataImpl paramDefaultMetadataImpl, String paramString3, String paramString4, String paramString5)
  {
    a = paramSet;
    b = paramInt;
    c = paramString1;
    d = paramString2;
    e = paramDefaultMetadataImpl;
    f = paramString3;
    g = paramString4;
    h = paramString5;
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
      return g;
    }
    return h;
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
    if (!(paramObject instanceof InstantMessaging)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (InstantMessaging)paramObject;
    Iterator localIterator = i.values().iterator();
    while (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (a(localField))
      {
        if (((InstantMessaging)paramObject).a(localField))
        {
          if (!b(localField).equals(((InstantMessaging)paramObject).b(localField))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((InstantMessaging)paramObject).a(localField)) {
        return false;
      }
    }
    return true;
  }
  
  public final int hashCode()
  {
    Iterator localIterator = i.values().iterator();
    int j = 0;
    if (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (!a(localField)) {
        break label68;
      }
      int k = g;
      j = b(localField).hashCode() + (j + k);
    }
    label68:
    for (;;)
    {
      break;
      return j;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = emj.a(paramParcel, 20293);
    Set localSet = a;
    if (localSet.contains(Integer.valueOf(1))) {
      emj.b(paramParcel, 1, b);
    }
    if (localSet.contains(Integer.valueOf(2))) {
      emj.a(paramParcel, 2, c, true);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      emj.a(paramParcel, 3, d, true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      emj.a(paramParcel, 4, e, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(5))) {
      emj.a(paramParcel, 5, f, true);
    }
    if (localSet.contains(Integer.valueOf(6))) {
      emj.a(paramParcel, 6, g, true);
    }
    if (localSet.contains(Integer.valueOf(7))) {
      emj.a(paramParcel, 7, h, true);
    }
    emj.b(paramParcel, j);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.InstantMessaging
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */