package com.google.android.gms.search.corpora;

import android.os.Parcel;
import com.google.android.gms.appdatasearch.RegisterCorpusInfo;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ejk;
import emj;
import fyv;

public class GetCorpusInfoCall$Response
  implements SafeParcelable, ejk
{
  public static final fyv CREATOR = new fyv();
  public Status a;
  public RegisterCorpusInfo b;
  final int c;
  
  public GetCorpusInfoCall$Response()
  {
    c = 1;
  }
  
  public GetCorpusInfoCall$Response(int paramInt, Status paramStatus, RegisterCorpusInfo paramRegisterCorpusInfo)
  {
    c = paramInt;
    a = paramStatus;
    b = paramRegisterCorpusInfo;
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
 * Qualified Name:     com.google.android.gms.search.corpora.GetCorpusInfoCall.Response
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */