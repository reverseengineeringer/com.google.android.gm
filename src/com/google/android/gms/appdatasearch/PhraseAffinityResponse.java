package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import eby;
import emj;

public class PhraseAffinityResponse
  implements SafeParcelable
{
  public static final eby CREATOR = new eby();
  final int a;
  final String b;
  final CorpusId[] c;
  final int[] d;
  
  public PhraseAffinityResponse(int paramInt, String paramString, CorpusId[] paramArrayOfCorpusId, int[] paramArrayOfInt)
  {
    a = paramInt;
    b = paramString;
    c = paramArrayOfCorpusId;
    d = paramArrayOfInt;
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
    emj.a(paramParcel, 3, d);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.PhraseAffinityResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */