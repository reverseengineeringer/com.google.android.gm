package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import eiy;
import ejk;
import ekz;
import emj;
import enx;
import eny;
import java.util.Arrays;

public final class Status
  implements SafeParcelable, ejk
{
  public static final Parcelable.Creator<Status> CREATOR = new ekz();
  public static final Status a = new Status(0);
  public static final Status b = new Status(14);
  public static final Status c = new Status(8);
  public static final Status d = new Status(15);
  public static final Status e = new Status(16);
  final int f;
  public final int g;
  public final String h;
  final PendingIntent i;
  
  public Status(int paramInt)
  {
    this(paramInt, null);
  }
  
  public Status(int paramInt1, int paramInt2, String paramString, PendingIntent paramPendingIntent)
  {
    f = paramInt1;
    g = paramInt2;
    h = paramString;
    i = paramPendingIntent;
  }
  
  public Status(int paramInt, String paramString)
  {
    this(1, paramInt, paramString, null);
  }
  
  public Status(int paramInt, String paramString, PendingIntent paramPendingIntent)
  {
    this(1, paramInt, paramString, paramPendingIntent);
  }
  
  public final Status a()
  {
    return this;
  }
  
  public final boolean b()
  {
    return g <= 0;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Status)) {}
    do
    {
      return false;
      paramObject = (Status)paramObject;
    } while ((f != f) || (g != g) || (!enx.a(h, h)) || (!enx.a(i, i)));
    return true;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(f), Integer.valueOf(g), h, i });
  }
  
  public final String toString()
  {
    eny localeny = enx.a(this);
    if (h != null) {}
    for (String str = h;; str = eiy.a(g)) {
      return localeny.a("statusCode", str).a("resolution", i).toString();
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, g);
    emj.b(paramParcel, 1000, f);
    emj.a(paramParcel, 2, h, false);
    emj.a(paramParcel, 3, i, paramInt, false);
    emj.b(paramParcel, j);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.Status
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */