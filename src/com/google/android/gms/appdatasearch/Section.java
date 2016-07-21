package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ecm;
import emj;

public class Section
  implements SafeParcelable
{
  public static final ecm CREATOR = new ecm();
  final int a;
  public final String b;
  public final boolean c;
  public final int d;
  
  public Section(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    a = paramInt1;
    b = paramString;
    c = paramBoolean;
    d = paramInt2;
  }
  
  public Section(String paramString)
  {
    this(paramString, false, 0);
  }
  
  public Section(String paramString, boolean paramBoolean, int paramInt)
  {
    this(2, paramString, paramBoolean, paramInt);
  }
  
  public static boolean a(String paramString)
  {
    return paramString.startsWith("semantic#");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.a(paramParcel, 1, b, false);
    emj.b(paramParcel, 1000, a);
    emj.a(paramParcel, 2, c);
    emj.b(paramParcel, 3, d);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.Section
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */