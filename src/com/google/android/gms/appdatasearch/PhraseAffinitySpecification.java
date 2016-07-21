package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ebz;
import emj;

public class PhraseAffinitySpecification
  implements SafeParcelable
{
  public static final ebz CREATOR = new ebz();
  final int a;
  final PhraseAffinityCorpusSpec[] b;
  
  public PhraseAffinitySpecification(int paramInt, PhraseAffinityCorpusSpec[] paramArrayOfPhraseAffinityCorpusSpec)
  {
    a = paramInt;
    b = paramArrayOfPhraseAffinityCorpusSpec;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.a(paramParcel, 1, b, paramInt);
    emj.b(paramParcel, 1000, a);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.PhraseAffinitySpecification
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */