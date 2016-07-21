package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import enx;
import ghv;
import java.util.Arrays;

public class ConnectionConfiguration
  implements SafeParcelable
{
  public static final Parcelable.Creator<ConnectionConfiguration> CREATOR = new ghv();
  final int a;
  final String b;
  final String c;
  final int d;
  final int e;
  final boolean f;
  boolean g;
  String h;
  boolean i;
  String j;
  
  public ConnectionConfiguration(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, String paramString3, boolean paramBoolean3, String paramString4)
  {
    a = paramInt1;
    b = paramString1;
    c = paramString2;
    d = paramInt2;
    e = paramInt3;
    f = paramBoolean1;
    g = paramBoolean2;
    h = paramString3;
    i = paramBoolean3;
    j = paramString4;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ConnectionConfiguration)) {}
    do
    {
      return false;
      paramObject = (ConnectionConfiguration)paramObject;
    } while ((!enx.a(Integer.valueOf(a), Integer.valueOf(a))) || (!enx.a(b, b)) || (!enx.a(c, c)) || (!enx.a(Integer.valueOf(d), Integer.valueOf(d))) || (!enx.a(Integer.valueOf(e), Integer.valueOf(e))) || (!enx.a(Boolean.valueOf(f), Boolean.valueOf(f))) || (!enx.a(Boolean.valueOf(i), Boolean.valueOf(i))));
    return true;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(a), b, c, Integer.valueOf(d), Integer.valueOf(e), Boolean.valueOf(f), Boolean.valueOf(i) });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ConnectionConfiguration[ ");
    localStringBuilder.append("mName=" + b);
    localStringBuilder.append(", mAddress=" + c);
    localStringBuilder.append(", mType=" + d);
    localStringBuilder.append(", mRole=" + e);
    localStringBuilder.append(", mEnabled=" + f);
    localStringBuilder.append(", mIsConnected=" + g);
    localStringBuilder.append(", mPeerNodeId=" + h);
    localStringBuilder.append(", mBtlePriority=" + i);
    localStringBuilder.append(", mNodeId=" + j);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, false);
    emj.a(paramParcel, 3, c, false);
    emj.b(paramParcel, 4, d);
    emj.b(paramParcel, 5, e);
    emj.a(paramParcel, 6, f);
    emj.a(paramParcel, 7, g);
    emj.a(paramParcel, 8, h, false);
    emj.a(paramParcel, 9, i);
    emj.a(paramParcel, 10, j, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.ConnectionConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */