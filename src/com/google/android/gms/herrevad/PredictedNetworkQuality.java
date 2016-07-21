package com.google.android.gms.herrevad;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import flv;

public class PredictedNetworkQuality
  implements SafeParcelable
{
  public static final Parcelable.Creator<PredictedNetworkQuality> CREATOR = new flv();
  final int a;
  public int b;
  public int c;
  public long d;
  public long e;
  
  public PredictedNetworkQuality()
  {
    a = 1;
    c = -1;
    d = -1L;
    e = -1L;
  }
  
  public PredictedNetworkQuality(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2)
  {
    a = paramInt1;
    b = paramInt2;
    c = paramInt3;
    d = paramLong1;
    e = paramLong2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getName()).append("[\n");
    localStringBuilder.append("networkType: ").append(b).append("\n");
    localStringBuilder.append("predictedLatencyMicros: ").append(c).append("\n");
    localStringBuilder.append("predictedDownThroughputBps: ").append(d).append("\n");
    localStringBuilder.append("predictedUpThroughputBps: ").append(d).append("\n");
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.b(paramParcel, 2, b);
    emj.b(paramParcel, 3, c);
    emj.a(paramParcel, 4, d);
    emj.a(paramParcel, 5, e);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.herrevad.PredictedNetworkQuality
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */