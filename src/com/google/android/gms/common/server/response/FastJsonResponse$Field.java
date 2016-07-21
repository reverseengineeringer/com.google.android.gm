package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import emj;
import enz;
import eoh;
import eoi;
import java.util.ArrayList;
import java.util.Map;

public class FastJsonResponse$Field<I, O>
  implements SafeParcelable
{
  public static final eoi CREATOR = new eoi();
  final int a;
  public final int b;
  public final boolean c;
  public final int d;
  public final boolean e;
  public final String f;
  public final int g;
  public final Class<? extends FastJsonResponse> h;
  public final String i;
  FieldMappingDictionary j;
  eoh<I, O> k;
  
  public FastJsonResponse$Field(int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, String paramString1, int paramInt4, String paramString2, ConverterWrapper paramConverterWrapper)
  {
    a = paramInt1;
    b = paramInt2;
    c = paramBoolean1;
    d = paramInt3;
    e = paramBoolean2;
    f = paramString1;
    g = paramInt4;
    if (paramString2 == null)
    {
      h = null;
      i = null;
      if (paramConverterWrapper != null) {
        break label92;
      }
    }
    for (paramString1 = (String)localObject;; paramString1 = b)
    {
      k = paramString1;
      return;
      h = SafeParcelResponse.class;
      i = paramString2;
      break;
      label92:
      if (b == null) {
        break label110;
      }
    }
    label110:
    throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
  }
  
  private FastJsonResponse$Field()
  {
    a = 1;
    int m;
    b = m;
    boolean bool1;
    c = bool1;
    int n;
    d = n;
    boolean bool2;
    e = bool2;
    String str;
    f = str;
    int i1;
    g = i1;
    Class localClass;
    h = localClass;
    if (localClass == null) {}
    for (i = null;; i = localClass.getCanonicalName())
    {
      k = null;
      return;
    }
  }
  
  public static Field<Double, Double> a(int paramInt)
  {
    return new Field(4, false, 4, false, paramInt, 3, null);
  }
  
  public static Field<Integer, Integer> a(String paramString, int paramInt)
  {
    return new Field(0, false, 0, false, paramString, paramInt, null);
  }
  
  public static <T extends FastJsonResponse> Field<T, T> a(String paramString, int paramInt, Class<T> paramClass)
  {
    return new Field(11, false, 11, false, paramString, paramInt, paramClass);
  }
  
  public static Field<Long, Long> b(String paramString, int paramInt)
  {
    return new Field(2, false, 2, false, paramString, paramInt, null);
  }
  
  public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> b(String paramString, int paramInt, Class<T> paramClass)
  {
    return new Field(11, true, 11, true, paramString, paramInt, paramClass);
  }
  
  private String b()
  {
    if (i == null) {
      return null;
    }
    return i;
  }
  
  public static Field<Boolean, Boolean> c(String paramString, int paramInt)
  {
    return new Field(6, false, 6, false, paramString, paramInt, null);
  }
  
  public static Field<String, String> d(String paramString, int paramInt)
  {
    return new Field(7, false, 7, false, paramString, paramInt, null);
  }
  
  public static Field<ArrayList<String>, ArrayList<String>> e(String paramString, int paramInt)
  {
    return new Field(7, true, 7, true, paramString, paramInt, null);
  }
  
  public final Map<String, Field<?, ?>> a()
  {
    enz.a(i);
    enz.a(j);
    return j.a(i);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("Field\n");
    localStringBuilder1.append("            versionCode=").append(a).append('\n');
    localStringBuilder1.append("                 typeIn=").append(b).append('\n');
    localStringBuilder1.append("            typeInArray=").append(c).append('\n');
    localStringBuilder1.append("                typeOut=").append(d).append('\n');
    localStringBuilder1.append("           typeOutArray=").append(e).append('\n');
    localStringBuilder1.append("        outputFieldName=").append(f).append('\n');
    localStringBuilder1.append("      safeParcelFieldId=").append(g).append('\n');
    localStringBuilder1.append("       concreteTypeName=").append(b()).append('\n');
    if (h != null) {
      localStringBuilder1.append("     concreteType.class=").append(h.getCanonicalName()).append('\n');
    }
    StringBuilder localStringBuilder2 = localStringBuilder1.append("          converterName=");
    if (k == null) {}
    for (String str = "null";; str = k.getClass().getCanonicalName())
    {
      localStringBuilder2.append(str).append('\n');
      return localStringBuilder1.toString();
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int m = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.b(paramParcel, 2, b);
    emj.a(paramParcel, 3, c);
    emj.b(paramParcel, 4, d);
    emj.a(paramParcel, 5, e);
    emj.a(paramParcel, 6, f, false);
    emj.b(paramParcel, 7, g);
    emj.a(paramParcel, 8, b(), false);
    if (k == null) {}
    for (Object localObject = null;; localObject = ConverterWrapper.a(k))
    {
      emj.a(paramParcel, 9, (Parcelable)localObject, paramInt, false);
      emj.b(paramParcel, m);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.server.response.FastJsonResponse.Field
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */