package com.google.android.gms.search.queries;

import android.os.Parcel;
import com.google.android.gms.appdatasearch.PhraseAffinityCorpusSpec;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import gbh;

public class GetPhraseAffinityCall$Request
  implements SafeParcelable
{
  public static final gbh CREATOR = new gbh();
  public String[] a;
  public PhraseAffinityCorpusSpec[] b;
  final int c;
  
  public GetPhraseAffinityCall$Request()
  {
    c = 1;
  }
  
  public GetPhraseAffinityCall$Request(int paramInt, String[] paramArrayOfString, PhraseAffinityCorpusSpec[] paramArrayOfPhraseAffinityCorpusSpec)
  {
    c = paramInt;
    a = paramArrayOfString;
    b = paramArrayOfPhraseAffinityCorpusSpec;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1000, c);
    emj.a(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, paramInt);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.search.queries.GetPhraseAffinityCall.Request
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */