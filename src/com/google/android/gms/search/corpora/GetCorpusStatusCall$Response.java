package com.google.android.gms.search.corpora;

import android.os.Parcel;
import com.google.android.gms.appdatasearch.CorpusStatus;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ejk;
import emj;
import fyy;

public class GetCorpusStatusCall$Response
  implements SafeParcelable, ejk
{
  public static final fyy CREATOR = new fyy();
  public Status a;
  public CorpusStatus b;
  final int c;
  
  public GetCorpusStatusCall$Response()
  {
    c = 1;
  }
  
  public GetCorpusStatusCall$Response(int paramInt, Status paramStatus, CorpusStatus paramCorpusStatus)
  {
    c = paramInt;
    a = paramStatus;
    b = paramCorpusStatus;
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
 * Qualified Name:     com.google.android.gms.search.corpora.GetCorpusStatusCall.Response
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */