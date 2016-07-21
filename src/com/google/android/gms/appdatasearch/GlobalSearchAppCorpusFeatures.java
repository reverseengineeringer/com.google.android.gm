package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ecv;
import emj;

public class GlobalSearchAppCorpusFeatures
  implements SafeParcelable
{
  public static final ecv CREATOR = new ecv();
  final int a;
  final String b;
  final Feature[] c;
  
  public GlobalSearchAppCorpusFeatures(int paramInt, String paramString, Feature[] paramArrayOfFeature)
  {
    a = paramInt;
    b = paramString;
    c = paramArrayOfFeature;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.a(paramParcel, 1, b, false);
    emj.b(paramParcel, 1000, a);
    emj.a(paramParcel, 2, c, paramInt);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.GlobalSearchAppCorpusFeatures
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */