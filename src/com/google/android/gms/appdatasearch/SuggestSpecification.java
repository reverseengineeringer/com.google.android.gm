package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import eco;
import emj;

public class SuggestSpecification
  implements SafeParcelable
{
  public static final eco CREATOR = new eco();
  final int a;
  
  public SuggestSpecification()
  {
    this(2);
  }
  
  public SuggestSpecification(int paramInt)
  {
    a = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1000, a);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.SuggestSpecification
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */