package com.google.android.gms.appdatasearch;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ebk;
import emj;

public class DocumentResults
  implements SafeParcelable
{
  public static final ebk CREATOR = new ebk();
  final int a;
  final String b;
  final Bundle c;
  final Bundle d;
  final Bundle e;
  
  public DocumentResults(int paramInt, String paramString, Bundle paramBundle1, Bundle paramBundle2, Bundle paramBundle3)
  {
    a = paramInt;
    b = paramString;
    c = paramBundle1;
    d = paramBundle2;
    e = paramBundle3;
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
    emj.a(paramParcel, 3, d);
    emj.a(paramParcel, 4, e);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.DocumentResults
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */