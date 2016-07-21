package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import enx;
import enz;
import fye;
import java.util.Arrays;

public class PlayLoggerContext
  implements SafeParcelable
{
  public static final fye CREATOR = new fye();
  public final int a;
  public final String b;
  public final int c;
  public final int d;
  public final String e;
  public final String f;
  public final boolean g;
  public final String h;
  public final boolean i;
  public final int j;
  
  public PlayLoggerContext(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2, int paramInt4)
  {
    a = paramInt1;
    b = paramString1;
    c = paramInt2;
    d = paramInt3;
    e = paramString2;
    f = paramString3;
    g = paramBoolean1;
    h = paramString4;
    i = paramBoolean2;
    j = paramInt4;
  }
  
  public PlayLoggerContext(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, boolean paramBoolean, int paramInt3)
  {
    a = 1;
    b = ((String)enz.a(paramString1));
    c = paramInt1;
    d = paramInt2;
    h = paramString2;
    e = paramString3;
    f = paramString4;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      g = bool;
      i = paramBoolean;
      j = paramInt3;
      return;
    }
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
      if (!(paramObject instanceof PlayLoggerContext)) {
        break;
      }
      paramObject = (PlayLoggerContext)paramObject;
    } while ((a == a) && (b.equals(b)) && (c == c) && (d == d) && (enx.a(h, h)) && (enx.a(e, e)) && (enx.a(f, f)) && (g == g) && (i == i) && (j == j));
    return false;
    return false;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(a), b, Integer.valueOf(c), Integer.valueOf(d), h, e, f, Boolean.valueOf(g), Boolean.valueOf(i), Integer.valueOf(j) });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PlayLoggerContext[");
    localStringBuilder.append("versionCode=").append(a).append(',');
    localStringBuilder.append("package=").append(b).append(',');
    localStringBuilder.append("packageVersionCode=").append(c).append(',');
    localStringBuilder.append("logSource=").append(d).append(',');
    localStringBuilder.append("logSourceName=").append(h).append(',');
    localStringBuilder.append("uploadAccount=").append(e).append(',');
    localStringBuilder.append("loggingId=").append(f).append(',');
    localStringBuilder.append("logAndroidId=").append(g).append(',');
    localStringBuilder.append("isAnonymous=").append(i).append(',');
    localStringBuilder.append("qosTier=").append(j);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, false);
    emj.b(paramParcel, 3, c);
    emj.b(paramParcel, 4, d);
    emj.a(paramParcel, 5, e, false);
    emj.a(paramParcel, 6, f, false);
    emj.a(paramParcel, 7, g);
    emj.a(paramParcel, 8, h, false);
    emj.a(paramParcel, 9, i);
    emj.b(paramParcel, 10, j);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.playlog.internal.PlayLoggerContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */