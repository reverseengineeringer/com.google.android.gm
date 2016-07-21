package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ech;
import emj;

public class RequestIndexingSpecification
  implements SafeParcelable
{
  public static final ech CREATOR = new ech();
  final int a;
  
  public RequestIndexingSpecification(int paramInt)
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
 * Qualified Name:     com.google.android.gms.appdatasearch.RequestIndexingSpecification
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */