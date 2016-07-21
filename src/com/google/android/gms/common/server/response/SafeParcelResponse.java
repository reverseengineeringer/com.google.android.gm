package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emh;
import emi;
import emj;
import enz;
import eom;
import eox;
import eoy;
import epd;
import epe;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SafeParcelResponse
  extends FastJsonResponse
  implements SafeParcelable
{
  public static final eom CREATOR = new eom();
  final int a;
  final int b;
  final FieldMappingDictionary c;
  private final Parcel d;
  private final String e;
  private int f;
  private int g;
  
  public SafeParcelResponse(int paramInt, Parcel paramParcel, FieldMappingDictionary paramFieldMappingDictionary)
  {
    a = paramInt;
    d = ((Parcel)enz.a(paramParcel));
    b = 2;
    c = paramFieldMappingDictionary;
    if (c == null) {}
    for (e = null;; e = c.c)
    {
      f = 2;
      return;
    }
  }
  
  private static HashMap<String, String> a(Bundle paramBundle)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, paramBundle.getString(str));
    }
    return localHashMap;
  }
  
  private static void a(StringBuilder paramStringBuilder, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Unknown type = " + paramInt);
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
      paramStringBuilder.append(paramObject);
      return;
    case 7: 
      paramStringBuilder.append("\"").append(epd.a(paramObject.toString())).append("\"");
      return;
    case 8: 
      paramStringBuilder.append("\"").append(eoy.a((byte[])paramObject)).append("\"");
      return;
    case 9: 
      paramStringBuilder.append("\"").append(eoy.b((byte[])paramObject));
      paramStringBuilder.append("\"");
      return;
    case 10: 
      epe.a(paramStringBuilder, (HashMap)paramObject);
      return;
    }
    throw new IllegalArgumentException("Method does not accept concrete type.");
  }
  
  private final void a(StringBuilder paramStringBuilder, FastJsonResponse.Field<?, ?> paramField, Parcel paramParcel, int paramInt)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    String str = null;
    int i = 0;
    int j = 0;
    if (e)
    {
      paramStringBuilder.append("[");
      int k;
      switch (d)
      {
      default: 
        throw new IllegalStateException("Unknown field type out.");
      case 0: 
        paramField = emh.q(paramParcel, paramInt);
        i = paramField.length;
        paramInt = j;
      case 1: 
        while (paramInt < i)
        {
          if (paramInt != 0) {
            paramStringBuilder.append(",");
          }
          paramStringBuilder.append(Integer.toString(paramField[paramInt]));
          paramInt += 1;
          continue;
          j = emh.a(paramParcel, paramInt);
          k = paramParcel.dataPosition();
          if (j != 0) {
            break label200;
          }
          paramField = str;
          eox.a(paramStringBuilder, paramField);
        }
      }
      for (;;)
      {
        paramStringBuilder.append("]");
        return;
        label200:
        int m = paramParcel.readInt();
        paramField = new BigInteger[m];
        paramInt = i;
        while (paramInt < m)
        {
          paramField[paramInt] = new BigInteger(paramParcel.createByteArray());
          paramInt += 1;
        }
        paramParcel.setDataPosition(j + k);
        break;
        paramInt = emh.a(paramParcel, paramInt);
        i = paramParcel.dataPosition();
        if (paramInt == 0) {
          paramField = (FastJsonResponse.Field<?, ?>)localObject1;
        }
        for (;;)
        {
          eox.a(paramStringBuilder, paramField);
          break;
          paramField = paramParcel.createLongArray();
          paramParcel.setDataPosition(paramInt + i);
        }
        paramInt = emh.a(paramParcel, paramInt);
        i = paramParcel.dataPosition();
        if (paramInt == 0) {
          paramField = (FastJsonResponse.Field<?, ?>)localObject2;
        }
        for (;;)
        {
          eox.a(paramStringBuilder, paramField);
          break;
          paramField = paramParcel.createFloatArray();
          paramParcel.setDataPosition(paramInt + i);
        }
        eox.a(paramStringBuilder, emh.r(paramParcel, paramInt));
        continue;
        eox.a(paramStringBuilder, emh.s(paramParcel, paramInt));
        continue;
        paramInt = emh.a(paramParcel, paramInt);
        i = paramParcel.dataPosition();
        if (paramInt == 0) {
          paramField = (FastJsonResponse.Field<?, ?>)localObject3;
        }
        for (;;)
        {
          eox.a(paramStringBuilder, paramField);
          break;
          paramField = paramParcel.createBooleanArray();
          paramParcel.setDataPosition(paramInt + i);
        }
        eox.a(paramStringBuilder, emh.t(paramParcel, paramInt));
        continue;
        throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
        paramParcel = emh.w(paramParcel, paramInt);
        i = paramParcel.length;
        paramInt = 0;
        while (paramInt < i)
        {
          if (paramInt > 0) {
            paramStringBuilder.append(",");
          }
          paramParcel[paramInt].setDataPosition(0);
          a(paramStringBuilder, paramField.a(), paramParcel[paramInt]);
          paramInt += 1;
        }
      }
    }
    switch (d)
    {
    default: 
      throw new IllegalStateException("Unknown field type out");
    case 0: 
      paramStringBuilder.append(emh.e(paramParcel, paramInt));
      return;
    case 1: 
      paramStringBuilder.append(emh.i(paramParcel, paramInt));
      return;
    case 2: 
      paramStringBuilder.append(emh.g(paramParcel, paramInt));
      return;
    case 3: 
      paramStringBuilder.append(emh.j(paramParcel, paramInt));
      return;
    case 4: 
      paramStringBuilder.append(emh.k(paramParcel, paramInt));
      return;
    case 5: 
      paramStringBuilder.append(emh.l(paramParcel, paramInt));
      return;
    case 6: 
      paramStringBuilder.append(emh.c(paramParcel, paramInt));
      return;
    case 7: 
      paramField = emh.m(paramParcel, paramInt);
      paramStringBuilder.append("\"").append(epd.a(paramField)).append("\"");
      return;
    case 8: 
      paramField = emh.p(paramParcel, paramInt);
      paramStringBuilder.append("\"").append(eoy.a(paramField)).append("\"");
      return;
    case 9: 
      paramField = emh.p(paramParcel, paramInt);
      paramStringBuilder.append("\"").append(eoy.b(paramField));
      paramStringBuilder.append("\"");
      return;
    case 10: 
      paramField = emh.o(paramParcel, paramInt);
      paramParcel = paramField.keySet();
      paramParcel.size();
      paramStringBuilder.append("{");
      paramParcel = paramParcel.iterator();
      for (paramInt = 1; paramParcel.hasNext(); paramInt = 0)
      {
        str = (String)paramParcel.next();
        if (paramInt == 0) {
          paramStringBuilder.append(",");
        }
        paramStringBuilder.append("\"").append(str).append("\"");
        paramStringBuilder.append(":");
        paramStringBuilder.append("\"").append(epd.a(paramField.getString(str))).append("\"");
      }
      paramStringBuilder.append("}");
      return;
    }
    paramParcel = emh.v(paramParcel, paramInt);
    paramParcel.setDataPosition(0);
    a(paramStringBuilder, paramField.a(), paramParcel);
  }
  
  private final void a(StringBuilder paramStringBuilder, FastJsonResponse.Field<?, ?> paramField, Object paramObject)
  {
    if (c)
    {
      paramObject = (ArrayList)paramObject;
      paramStringBuilder.append("[");
      int j = ((ArrayList)paramObject).size();
      int i = 0;
      while (i < j)
      {
        if (i != 0) {
          paramStringBuilder.append(",");
        }
        a(paramStringBuilder, b, ((ArrayList)paramObject).get(i));
        i += 1;
      }
      paramStringBuilder.append("]");
      return;
    }
    a(paramStringBuilder, b, paramObject);
  }
  
  private final void a(StringBuilder paramStringBuilder, Map<String, FastJsonResponse.Field<?, ?>> paramMap, Parcel paramParcel)
  {
    HashMap localHashMap = new HashMap();
    paramMap = paramMap.entrySet().iterator();
    Object localObject;
    while (paramMap.hasNext())
    {
      localObject = (Map.Entry)paramMap.next();
      localHashMap.put(Integer.valueOf(getValueg), localObject);
    }
    paramStringBuilder.append('{');
    int j = emh.a(paramParcel);
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = paramParcel.readInt();
      localObject = (Map.Entry)localHashMap.get(Integer.valueOf(0xFFFF & k));
      if (localObject != null)
      {
        if (i != 0) {
          paramStringBuilder.append(",");
        }
        paramMap = (String)((Map.Entry)localObject).getKey();
        localObject = (FastJsonResponse.Field)((Map.Entry)localObject).getValue();
        paramStringBuilder.append("\"").append(paramMap).append("\":");
        if (k != null) {
          i = 1;
        }
        while (i != 0) {
          switch (d)
          {
          default: 
            throw new IllegalArgumentException("Unknown field out type = " + d);
            i = 0;
            break;
          case 0: 
            a(paramStringBuilder, (FastJsonResponse.Field)localObject, a((FastJsonResponse.Field)localObject, Integer.valueOf(emh.e(paramParcel, k))));
          }
        }
        for (;;)
        {
          i = 1;
          break;
          a(paramStringBuilder, (FastJsonResponse.Field)localObject, a((FastJsonResponse.Field)localObject, emh.i(paramParcel, k)));
          continue;
          a(paramStringBuilder, (FastJsonResponse.Field)localObject, a((FastJsonResponse.Field)localObject, Long.valueOf(emh.g(paramParcel, k))));
          continue;
          a(paramStringBuilder, (FastJsonResponse.Field)localObject, a((FastJsonResponse.Field)localObject, Float.valueOf(emh.j(paramParcel, k))));
          continue;
          a(paramStringBuilder, (FastJsonResponse.Field)localObject, a((FastJsonResponse.Field)localObject, Double.valueOf(emh.k(paramParcel, k))));
          continue;
          a(paramStringBuilder, (FastJsonResponse.Field)localObject, a((FastJsonResponse.Field)localObject, emh.l(paramParcel, k)));
          continue;
          a(paramStringBuilder, (FastJsonResponse.Field)localObject, a((FastJsonResponse.Field)localObject, Boolean.valueOf(emh.c(paramParcel, k))));
          continue;
          a(paramStringBuilder, (FastJsonResponse.Field)localObject, a((FastJsonResponse.Field)localObject, emh.m(paramParcel, k)));
          continue;
          a(paramStringBuilder, (FastJsonResponse.Field)localObject, a((FastJsonResponse.Field)localObject, emh.p(paramParcel, k)));
          continue;
          a(paramStringBuilder, (FastJsonResponse.Field)localObject, a((FastJsonResponse.Field)localObject, a(emh.o(paramParcel, k))));
          continue;
          throw new IllegalArgumentException("Method does not accept concrete type.");
          a(paramStringBuilder, (FastJsonResponse.Field)localObject, paramParcel, k);
        }
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    paramStringBuilder.append('}');
  }
  
  private Parcel d()
  {
    switch (f)
    {
    }
    for (;;)
    {
      return d;
      g = emj.a(d, 20293);
      emj.b(d, g);
      f = 2;
      continue;
      emj.b(d, g);
      f = 2;
    }
  }
  
  public final Map<String, FastJsonResponse.Field<?, ?>> a()
  {
    if (c == null) {
      return null;
    }
    return c.a(e);
  }
  
  protected final Object b()
  {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }
  
  protected final boolean c()
  {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    enz.a(c, "Cannot convert to JSON on client side.");
    Parcel localParcel = d();
    localParcel.setDataPosition(0);
    StringBuilder localStringBuilder = new StringBuilder(100);
    a(localStringBuilder, c.a(e), localParcel);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    Object localObject = d();
    if (localObject != null)
    {
      int j = emj.a(paramParcel, 2);
      paramParcel.appendFrom((Parcel)localObject, 0, ((Parcel)localObject).dataSize());
      emj.b(paramParcel, j);
    }
    switch (b)
    {
    default: 
      throw new IllegalStateException("Invalid creation type: " + b);
    case 0: 
      localObject = null;
    }
    for (;;)
    {
      emj.a(paramParcel, 3, (Parcelable)localObject, paramInt, false);
      emj.b(paramParcel, i);
      return;
      localObject = c;
      continue;
      localObject = c;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.server.response.SafeParcelResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */