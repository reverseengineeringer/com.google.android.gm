package com.google.android.gms.search.corpora;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import fyx;

public class GetCorpusStatusCall$Request
  implements SafeParcelable
{
  public static final fyx CREATOR = new fyx();
  public String a;
  public String b;
  final int c;
  
  public GetCorpusStatusCall$Request()
  {
    c = 1;
  }
  
  public GetCorpusStatusCall$Request(int paramInt, String paramString1, String paramString2)
  {
    c = paramInt;
    a = paramString1;
    b = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1000, c);
    emj.a(paramParcel, 1, a, false);
    emj.a(paramParcel, 2, b, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.search.corpora.GetCorpusStatusCall.Request
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */