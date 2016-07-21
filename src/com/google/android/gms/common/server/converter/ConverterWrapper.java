package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import eoe;
import eoh;

public class ConverterWrapper
  implements SafeParcelable
{
  public static final eoe CREATOR = new eoe();
  final int a;
  public final StringToIntConverter b;
  
  public ConverterWrapper(int paramInt, StringToIntConverter paramStringToIntConverter)
  {
    a = paramInt;
    b = paramStringToIntConverter;
  }
  
  private ConverterWrapper(StringToIntConverter paramStringToIntConverter)
  {
    a = 1;
    b = paramStringToIntConverter;
  }
  
  public static ConverterWrapper a(eoh<?, ?> parameoh)
  {
    if ((parameoh instanceof StringToIntConverter)) {
      return new ConverterWrapper((StringToIntConverter)parameoh);
    }
    throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.server.converter.ConverterWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */