package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ebj;
import emj;

public class DocumentId
  implements SafeParcelable
{
  public static final ebj CREATOR = new ebj();
  final int a;
  final String b;
  final String c;
  final String d;
  
  public DocumentId(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    a = paramInt;
    b = paramString1;
    c = paramString2;
    d = paramString3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return String.format("DocumentId[packageName=%s, corpusName=%s, uri=%s]", new Object[] { b, c, d });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.a(paramParcel, 1, b, false);
    emj.b(paramParcel, 1000, a);
    emj.a(paramParcel, 2, c, false);
    emj.a(paramParcel, 3, d, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.DocumentId
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */