package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ebr;
import emj;

public class GlobalSearchCorpusConfig
  implements SafeParcelable
{
  public static final ebr CREATOR = new ebr();
  final int a;
  public final int[] b;
  public final Feature[] c;
  
  public GlobalSearchCorpusConfig(int paramInt, int[] paramArrayOfInt, Feature[] paramArrayOfFeature)
  {
    a = paramInt;
    b = paramArrayOfInt;
    c = paramArrayOfFeature;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.a(paramParcel, 1, b);
    emj.b(paramParcel, 1000, a);
    emj.a(paramParcel, 2, c, paramInt);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.GlobalSearchCorpusConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */