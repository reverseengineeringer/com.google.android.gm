package com.google.android.gms.appdatasearch;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ebm;
import emj;

public class Feature
  implements SafeParcelable
{
  public static final ebm CREATOR = new ebm();
  final int a;
  public final int b;
  final Bundle c;
  
  public Feature(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    a = paramInt1;
    b = paramInt2;
    c = paramBundle;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, b);
    emj.b(paramParcel, 1000, a);
    emj.a(paramParcel, 2, c);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.Feature
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */