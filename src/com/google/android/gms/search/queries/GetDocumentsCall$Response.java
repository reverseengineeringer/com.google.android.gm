package com.google.android.gms.search.queries;

import android.os.Parcel;
import com.google.android.gms.appdatasearch.DocumentResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ejk;
import emj;
import gbg;

public class GetDocumentsCall$Response
  implements SafeParcelable, ejk
{
  public static final gbg CREATOR = new gbg();
  public Status a;
  public DocumentResults b;
  final int c;
  
  public GetDocumentsCall$Response()
  {
    c = 1;
  }
  
  public GetDocumentsCall$Response(int paramInt, Status paramStatus, DocumentResults paramDocumentResults)
  {
    c = paramInt;
    a = paramStatus;
    b = paramDocumentResults;
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
 * Qualified Name:     com.google.android.gms.search.queries.GetDocumentsCall.Response
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */