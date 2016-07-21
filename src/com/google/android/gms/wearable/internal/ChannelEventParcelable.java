package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import ghh;

public final class ChannelEventParcelable
  implements SafeParcelable
{
  public static final Parcelable.Creator<ChannelEventParcelable> CREATOR = new ghh();
  final int a;
  final ChannelImpl b;
  final int c;
  final int d;
  final int e;
  
  public ChannelEventParcelable(int paramInt1, ChannelImpl paramChannelImpl, int paramInt2, int paramInt3, int paramInt4)
  {
    a = paramInt1;
    b = paramChannelImpl;
    c = paramInt2;
    d = paramInt3;
    e = paramInt4;
  }
  
  public final void a()
  {
    switch (c)
    {
    default: 
      Log.w("ChannelEventParcelable", "Unknown type: " + c);
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ChannelEventParcelable[versionCode=").append(a).append(", channel=").append(b).append(", type=");
    int i = c;
    String str;
    switch (i)
    {
    default: 
      str = Integer.toString(i);
      localStringBuilder = localStringBuilder.append(str).append(", closeReason=");
      i = d;
      switch (i)
      {
      default: 
        str = Integer.toString(i);
      }
      break;
    }
    for (;;)
    {
      return str + ", appErrorCode=" + e + "]";
      str = "CHANNEL_OPENED";
      break;
      str = "CHANNEL_CLOSED";
      break;
      str = "OUTPUT_CLOSED";
      break;
      str = "INPUT_CLOSED";
      break;
      str = "CLOSE_REASON_DISCONNECTED";
      continue;
      str = "CLOSE_REASON_REMOTE_CLOSE";
      continue;
      str = "CLOSE_REASON_LOCAL_CLOSE";
      continue;
      str = "CLOSE_REASON_NORMAL";
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, paramInt, false);
    emj.b(paramParcel, 3, c);
    emj.b(paramParcel, 4, d);
    emj.b(paramParcel, 5, e);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.ChannelEventParcelable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */