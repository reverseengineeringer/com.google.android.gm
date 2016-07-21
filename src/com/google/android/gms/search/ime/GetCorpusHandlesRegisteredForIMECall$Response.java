package com.google.android.gms.search.ime;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ejk;
import emj;
import gai;

public class GetCorpusHandlesRegisteredForIMECall$Response
  implements SafeParcelable, ejk
{
  public static final gai CREATOR = new gai();
  public Status a;
  public String[] b;
  final int c;
  
  public GetCorpusHandlesRegisteredForIMECall$Response()
  {
    c = 1;
  }
  
  public GetCorpusHandlesRegisteredForIMECall$Response(int paramInt, Status paramStatus, String[] paramArrayOfString)
  {
    c = paramInt;
    a = paramStatus;
    b = paramArrayOfString;
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
    emj.a(paramParcel, 2, b);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.search.ime.GetCorpusHandlesRegisteredForIMECall.Response
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */