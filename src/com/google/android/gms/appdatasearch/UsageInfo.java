package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ecu;
import emj;

public class UsageInfo
  implements SafeParcelable
{
  public static final ecu CREATOR = new ecu();
  final int a;
  final DocumentId b;
  final long c;
  int d;
  public final String e;
  final DocumentContents f;
  final boolean g;
  int h;
  int i;
  
  public UsageInfo(int paramInt1, DocumentId paramDocumentId, long paramLong, int paramInt2, String paramString, DocumentContents paramDocumentContents, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    a = paramInt1;
    b = paramDocumentId;
    c = paramLong;
    d = paramInt2;
    e = paramString;
    f = paramDocumentContents;
    g = paramBoolean;
    h = paramInt3;
    i = paramInt4;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d, status=%d]", new Object[] { b, Long.valueOf(c), Integer.valueOf(d), Integer.valueOf(i) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = emj.a(paramParcel, 20293);
    emj.a(paramParcel, 1, b, paramInt, false);
    emj.b(paramParcel, 1000, a);
    emj.a(paramParcel, 2, c);
    emj.b(paramParcel, 3, d);
    emj.a(paramParcel, 4, e, false);
    emj.a(paramParcel, 5, f, paramInt, false);
    emj.a(paramParcel, 6, g);
    emj.b(paramParcel, 7, h);
    emj.b(paramParcel, 8, i);
    emj.b(paramParcel, j);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.UsageInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */