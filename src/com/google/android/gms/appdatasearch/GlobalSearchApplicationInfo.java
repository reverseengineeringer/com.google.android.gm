package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ebq;
import emj;

public class GlobalSearchApplicationInfo
  implements SafeParcelable
{
  public static final ebq CREATOR = new ebq();
  final int a;
  final String b;
  public final int c;
  public final int d;
  public final int e;
  public final String f;
  public final String g;
  public final String h;
  
  public GlobalSearchApplicationInfo(int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3, String paramString4)
  {
    a = paramInt1;
    b = paramString1;
    c = paramInt2;
    d = paramInt3;
    e = paramInt4;
    f = paramString2;
    g = paramString3;
    h = paramString4;
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
      if (!(paramObject instanceof GlobalSearchApplicationInfo)) {
        break;
      }
      paramObject = (GlobalSearchApplicationInfo)paramObject;
    } while ((TextUtils.equals(b, b)) && (c == c) && (d == d) && (e == e) && (TextUtils.equals(f, f)) && (TextUtils.equals(g, g)) && (TextUtils.equals(h, h)));
    return false;
    return false;
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + "{" + b + ";labelId=" + Integer.toHexString(c) + ";settingsDescriptionId=" + Integer.toHexString(d) + ";iconId=" + Integer.toHexString(e) + ";defaultIntentAction=" + f + ";defaultIntentData=" + g + ";defaultIntentActivity=" + h + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.a(paramParcel, 1, b, false);
    emj.b(paramParcel, 1000, a);
    emj.b(paramParcel, 2, c);
    emj.b(paramParcel, 3, d);
    emj.b(paramParcel, 4, e);
    emj.a(paramParcel, 5, f, false);
    emj.a(paramParcel, 6, g, false);
    emj.a(paramParcel, 7, h, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.GlobalSearchApplicationInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */