package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ebg;
import emj;

public class CorpusScoringInfo
  implements SafeParcelable
{
  public static final ebg CREATOR = new ebg();
  final int a;
  public final CorpusId b;
  public final int c;
  public final int d;
  
  public CorpusScoringInfo(int paramInt1, CorpusId paramCorpusId, int paramInt2, int paramInt3)
  {
    a = paramInt1;
    b = paramCorpusId;
    c = paramInt2;
    d = paramInt3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.a(paramParcel, 1, b, paramInt, false);
    emj.b(paramParcel, 1000, a);
    emj.b(paramParcel, 2, c);
    emj.b(paramParcel, 3, d);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.CorpusScoringInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */