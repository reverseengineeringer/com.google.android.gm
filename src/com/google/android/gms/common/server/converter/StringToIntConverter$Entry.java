package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import eog;

public final class StringToIntConverter$Entry
  implements SafeParcelable
{
  public static final eog CREATOR = new eog();
  final int a;
  final String b;
  final int c;
  
  public StringToIntConverter$Entry(int paramInt1, String paramString, int paramInt2)
  {
    a = paramInt1;
    b = paramString;
    c = paramInt2;
  }
  
  StringToIntConverter$Entry(String paramString, int paramInt)
  {
    a = 1;
    b = paramString;
    c = paramInt;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, false);
    emj.b(paramParcel, 3, c);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.server.converter.StringToIntConverter.Entry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */