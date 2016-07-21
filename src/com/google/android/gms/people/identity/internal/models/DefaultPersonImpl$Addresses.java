package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import emj;
import fvs;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class DefaultPersonImpl$Addresses
  extends FastJsonResponse
  implements SafeParcelable
{
  public static final fvs CREATOR = new fvs();
  private static final HashMap<String, FastJsonResponse.Field<?, ?>> n;
  final Set<Integer> a;
  final int b;
  String c;
  String d;
  String e;
  String f;
  DefaultMetadataImpl g;
  String h;
  String i;
  String j;
  String k;
  String l;
  String m;
  
  static
  {
    HashMap localHashMap = new HashMap();
    n = localHashMap;
    localHashMap.put("city", FastJsonResponse.Field.d("city", 2));
    n.put("country", FastJsonResponse.Field.d("country", 3));
    n.put("countryCode", FastJsonResponse.Field.d("countryCode", 4));
    n.put("formattedType", FastJsonResponse.Field.d("formattedType", 5));
    n.put("metadata", FastJsonResponse.Field.a("metadata", 6, DefaultMetadataImpl.class));
    n.put("poBox", FastJsonResponse.Field.d("poBox", 7));
    n.put("postalCode", FastJsonResponse.Field.d("postalCode", 8));
    n.put("region", FastJsonResponse.Field.d("region", 9));
    n.put("streetAddress", FastJsonResponse.Field.d("streetAddress", 10));
    n.put("type", FastJsonResponse.Field.d("type", 11));
    n.put("value", FastJsonResponse.Field.d("value", 12));
  }
  
  public DefaultPersonImpl$Addresses()
  {
    b = 1;
    a = new HashSet();
  }
  
  public DefaultPersonImpl$Addresses(Set<Integer> paramSet, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, DefaultMetadataImpl paramDefaultMetadataImpl, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    a = paramSet;
    b = paramInt;
    c = paramString1;
    d = paramString2;
    e = paramString3;
    f = paramString4;
    g = paramDefaultMetadataImpl;
    h = paramString5;
    i = paramString6;
    j = paramString7;
    k = paramString8;
    l = paramString9;
    m = paramString10;
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
    case 7: 
      return h;
    case 8: 
      return i;
    case 9: 
      return j;
    case 10: 
      return k;
    case 11: 
      return l;
    }
    return m;
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
    if (!(paramObject instanceof Addresses)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (Addresses)paramObject;
    Iterator localIterator = n.values().iterator();
    while (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (a(localField))
      {
        if (((Addresses)paramObject).a(localField))
        {
          if (!b(localField).equals(((Addresses)paramObject).b(localField))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((Addresses)paramObject).a(localField)) {
        return false;
      }
    }
    return true;
  }
  
  public final int hashCode()
  {
    Iterator localIterator = n.values().iterator();
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
      emj.a(paramParcel, 2, c, true);
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
      emj.a(paramParcel, 6, g, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(7))) {
      emj.a(paramParcel, 7, h, true);
    }
    if (localSet.contains(Integer.valueOf(8))) {
      emj.a(paramParcel, 8, i, true);
    }
    if (localSet.contains(Integer.valueOf(9))) {
      emj.a(paramParcel, 9, j, true);
    }
    if (localSet.contains(Integer.valueOf(10))) {
      emj.a(paramParcel, 10, k, true);
    }
    if (localSet.contains(Integer.valueOf(11))) {
      emj.a(paramParcel, 11, l, true);
    }
    if (localSet.contains(Integer.valueOf(12))) {
      emj.a(paramParcel, 12, m, true);
    }
    emj.b(paramParcel, i1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.people.identity.internal.models.DefaultPersonImpl.Addresses
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */