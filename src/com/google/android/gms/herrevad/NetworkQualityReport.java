package com.google.android.gms.herrevad;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import flu;
import java.util.Iterator;
import java.util.Set;

public class NetworkQualityReport
  implements SafeParcelable
{
  public static final Parcelable.Creator<NetworkQualityReport> CREATOR = new flu();
  public final int a;
  public int b = -1;
  public long c = -1L;
  public long d = -1L;
  public long e = -1L;
  public int f = -1;
  public Bundle g = new Bundle();
  public boolean h = false;
  
  public NetworkQualityReport()
  {
    a = 1;
  }
  
  public NetworkQualityReport(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, int paramInt3, Bundle paramBundle, boolean paramBoolean)
  {
    a = paramInt1;
    b = paramInt2;
    c = paramLong1;
    d = paramLong2;
    e = paramLong3;
    f = paramInt3;
    g = paramBundle;
    h = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getName()).append("[\n");
    localStringBuilder.append("mLatencyMicros: ").append(b).append("\n");
    localStringBuilder.append("mDurationMicros: ").append(c).append("\n");
    localStringBuilder.append("mBytesDownloaded: ").append(d).append("\n");
    localStringBuilder.append("mBytesUploaded: ").append(e).append("\n");
    localStringBuilder.append("mMeasurementType: ").append(f).append("\n");
    localStringBuilder.append("mIsNoConnectivity: ").append(h).append("\n");
    Iterator localIterator = g.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuilder.append("custom param: ").append(str).append("/").append(g.getString(str)).append("\n");
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.b(paramParcel, 2, b);
    emj.a(paramParcel, 3, c);
    emj.a(paramParcel, 4, d);
    emj.a(paramParcel, 5, e);
    emj.b(paramParcel, 6, f);
    emj.a(paramParcel, 7, g);
    emj.a(paramParcel, 8, h);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.herrevad.NetworkQualityReport
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */