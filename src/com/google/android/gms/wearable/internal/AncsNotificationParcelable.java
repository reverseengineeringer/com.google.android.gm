package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import ghc;

public class AncsNotificationParcelable
  implements SafeParcelable
{
  public static final Parcelable.Creator<AncsNotificationParcelable> CREATOR = new ghc();
  final int a;
  int b;
  final String c;
  final String d;
  final String e;
  final String f;
  final String g;
  String h;
  byte i;
  byte j;
  byte k;
  byte l;
  
  public AncsNotificationParcelable(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4)
  {
    b = paramInt2;
    a = paramInt1;
    c = paramString1;
    d = paramString2;
    e = paramString3;
    f = paramString4;
    g = paramString5;
    h = paramString6;
    i = paramByte1;
    j = paramByte2;
    k = paramByte3;
    l = paramByte4;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (AncsNotificationParcelable)paramObject;
      if (l != l) {
        return false;
      }
      if (k != k) {
        return false;
      }
      if (j != j) {
        return false;
      }
      if (i != i) {
        return false;
      }
      if (b != b) {
        return false;
      }
      if (a != a) {
        return false;
      }
      if (!c.equals(c)) {
        return false;
      }
      if (d != null)
      {
        if (d.equals(d)) {}
      }
      else {
        while (d != null) {
          return false;
        }
      }
      if (!h.equals(h)) {
        return false;
      }
      if (!e.equals(e)) {
        return false;
      }
      if (!g.equals(g)) {
        return false;
      }
    } while (f.equals(f));
    return false;
  }
  
  public int hashCode()
  {
    int n = a;
    int i1 = b;
    int i2 = c.hashCode();
    if (d != null) {}
    for (int m = d.hashCode();; m = 0) {
      return ((((((((m + ((n * 31 + i1) * 31 + i2) * 31) * 31 + e.hashCode()) * 31 + f.hashCode()) * 31 + g.hashCode()) * 31 + h.hashCode()) * 31 + i) * 31 + j) * 31 + k) * 31 + l;
    }
  }
  
  public String toString()
  {
    return "AncsNotificationParcelable{mVersionCode=" + a + ", mId=" + b + ", mAppId='" + c + '\'' + ", mDateTime='" + d + '\'' + ", mNotificationText='" + e + '\'' + ", mTitle='" + f + '\'' + ", mSubtitle='" + g + '\'' + ", mDisplayName='" + h + '\'' + ", mEventId=" + i + ", mEventFlags=" + j + ", mCategoryId=" + k + ", mCategoryCount=" + l + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.b(paramParcel, 2, b);
    emj.a(paramParcel, 3, c, false);
    emj.a(paramParcel, 4, d, false);
    emj.a(paramParcel, 5, e, false);
    emj.a(paramParcel, 6, f, false);
    emj.a(paramParcel, 7, g, false);
    if (h == null) {}
    for (String str = c;; str = h)
    {
      emj.a(paramParcel, 8, str, false);
      emj.a(paramParcel, 9, i);
      emj.a(paramParcel, 10, j);
      emj.a(paramParcel, 11, k);
      emj.a(paramParcel, 12, l);
      emj.b(paramParcel, paramInt);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.AncsNotificationParcelable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */