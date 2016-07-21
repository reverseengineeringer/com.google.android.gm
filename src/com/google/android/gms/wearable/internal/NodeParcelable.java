package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import gge;

public class NodeParcelable
  implements SafeParcelable
{
  public static final Parcelable.Creator<NodeParcelable> CREATOR = new gge();
  final int a;
  final String b;
  final String c;
  final int d;
  final boolean e;
  
  public NodeParcelable(int paramInt1, String paramString1, String paramString2, int paramInt2, boolean paramBoolean)
  {
    a = paramInt1;
    b = paramString1;
    c = paramString2;
    d = paramInt2;
    e = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof NodeParcelable)) {
      return false;
    }
    return b.equals(b);
  }
  
  public int hashCode()
  {
    return b.hashCode();
  }
  
  public String toString()
  {
    return "Node{" + c + ", id=" + b + ", hops=" + d + ", isNearby=" + e + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, false);
    emj.a(paramParcel, 3, c, false);
    emj.b(paramParcel, 4, d);
    emj.a(paramParcel, 5, e);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.NodeParcelable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */