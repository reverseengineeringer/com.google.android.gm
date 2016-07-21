package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ecf;
import emj;

public class RegisterSectionInfo
  implements SafeParcelable
{
  public static final ecf CREATOR = new ecf();
  final int a;
  public final String b;
  public final String c;
  public final boolean d;
  public final int e;
  public final boolean f;
  public final String g;
  public final Feature[] h;
  final int[] i;
  public final String j;
  
  public RegisterSectionInfo(int paramInt1, String paramString1, String paramString2, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, String paramString3, Feature[] paramArrayOfFeature, int[] paramArrayOfInt, String paramString4)
  {
    a = paramInt1;
    b = paramString1;
    c = paramString2;
    d = paramBoolean1;
    e = paramInt2;
    f = paramBoolean2;
    g = paramString3;
    h = paramArrayOfFeature;
    i = paramArrayOfInt;
    j = paramString4;
  }
  
  RegisterSectionInfo(String paramString1, String paramString2, boolean paramBoolean1, int paramInt, boolean paramBoolean2, String paramString3, Feature[] paramArrayOfFeature, int[] paramArrayOfInt, String paramString4)
  {
    this(2, paramString1, paramString2, paramBoolean1, paramInt, paramBoolean2, paramString3, paramArrayOfFeature, paramArrayOfInt, paramString4);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int k = emj.a(paramParcel, 20293);
    emj.a(paramParcel, 1, b, false);
    emj.b(paramParcel, 1000, a);
    emj.a(paramParcel, 2, c, false);
    emj.a(paramParcel, 3, d);
    emj.b(paramParcel, 4, e);
    emj.a(paramParcel, 5, f);
    emj.a(paramParcel, 6, g, false);
    emj.a(paramParcel, 7, h, paramInt);
    emj.a(paramParcel, 8, i);
    emj.a(paramParcel, 11, j, false);
    emj.b(paramParcel, k);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.RegisterSectionInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */