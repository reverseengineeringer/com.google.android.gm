package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.Channel;
import emj;
import enx;
import enz;
import ghi;

public class ChannelImpl
  implements SafeParcelable, Channel
{
  public static final Parcelable.Creator<ChannelImpl> CREATOR = new ghi();
  final int a;
  final String b;
  final String c;
  final String d;
  
  public ChannelImpl(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    a = paramInt;
    b = ((String)enz.a(paramString1));
    c = ((String)enz.a(paramString2));
    d = ((String)enz.a(paramString3));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof ChannelImpl)) {
        return false;
      }
      paramObject = (ChannelImpl)paramObject;
    } while ((b.equals(b)) && (enx.a(c, c)) && (enx.a(d, d)) && (a == a));
    return false;
  }
  
  public int hashCode()
  {
    return b.hashCode();
  }
  
  public String toString()
  {
    return "ChannelImpl{versionCode=" + a + ", token='" + b + '\'' + ", nodeId='" + c + '\'' + ", path='" + d + '\'' + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, false);
    emj.a(paramParcel, 3, c, false);
    emj.a(paramParcel, 4, d, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.ChannelImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */