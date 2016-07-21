package com.google.android.gms.search.queries;

import android.os.Parcel;
import com.google.android.gms.appdatasearch.PhraseAffinityResponse;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ejk;
import emj;
import gbi;

public class GetPhraseAffinityCall$Response
  implements SafeParcelable, ejk
{
  public static final gbi CREATOR = new gbi();
  public Status a;
  public PhraseAffinityResponse b;
  final int c;
  
  public GetPhraseAffinityCall$Response()
  {
    c = 1;
  }
  
  public GetPhraseAffinityCall$Response(int paramInt, Status paramStatus, PhraseAffinityResponse paramPhraseAffinityResponse)
  {
    c = paramInt;
    a = paramStatus;
    b = paramPhraseAffinityResponse;
  }
  
  public final Status a()
  {
    return a;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1000, c);
    emj.a(paramParcel, 1, a, paramInt, false);
    emj.a(paramParcel, 2, b, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.search.queries.GetPhraseAffinityCall.Response
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */