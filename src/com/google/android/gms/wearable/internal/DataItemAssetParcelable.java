package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import enz;
import gdu;
import gev;

public class DataItemAssetParcelable
  implements SafeParcelable, gdu
{
  public static final Parcelable.Creator<DataItemAssetParcelable> CREATOR = new gev();
  final int a;
  final String b;
  final String c;
  
  public DataItemAssetParcelable(int paramInt, String paramString1, String paramString2)
  {
    a = paramInt;
    b = paramString1;
    c = paramString2;
  }
  
  public DataItemAssetParcelable(gdu paramgdu)
  {
    a = 1;
    b = ((String)enz.a(paramgdu.b()));
    c = ((String)enz.a(paramgdu.c()));
  }
  
  public final boolean a()
  {
    return true;
  }
  
  public final String b()
  {
    return b;
  }
  
  public final String c()
  {
    return c;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataItemAssetParcelable[");
    localStringBuilder.append("@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    if (b == null) {
      localStringBuilder.append(",noid");
    }
    for (;;)
    {
      localStringBuilder.append(", key=");
      localStringBuilder.append(c);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
      localStringBuilder.append(",");
      localStringBuilder.append(b);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, false);
    emj.a(paramParcel, 3, c, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.DataItemAssetParcelable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */