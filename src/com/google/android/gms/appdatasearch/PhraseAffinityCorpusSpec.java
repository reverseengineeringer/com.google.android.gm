package com.google.android.gms.appdatasearch;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ebx;
import emj;

public class PhraseAffinityCorpusSpec
  implements SafeParcelable
{
  public static final ebx CREATOR = new ebx();
  final int a;
  public final CorpusId b;
  final Bundle c;
  
  public PhraseAffinityCorpusSpec(int paramInt, CorpusId paramCorpusId, Bundle paramBundle)
  {
    a = paramInt;
    b = paramCorpusId;
    c = paramBundle;
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
    emj.a(paramParcel, 2, c);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.PhraseAffinityCorpusSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */