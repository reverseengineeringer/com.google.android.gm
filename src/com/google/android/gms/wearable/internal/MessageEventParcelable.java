package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import gdy;
import ggb;

public class MessageEventParcelable
  implements SafeParcelable, gdy
{
  public static final Parcelable.Creator<MessageEventParcelable> CREATOR = new ggb();
  final int a;
  final int b;
  final String c;
  final byte[] d;
  final String e;
  
  public MessageEventParcelable(int paramInt1, int paramInt2, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    a = paramInt1;
    b = paramInt2;
    c = paramString1;
    d = paramArrayOfByte;
    e = paramString2;
  }
  
  public final String a()
  {
    return c;
  }
  
  public final byte[] b()
  {
    return d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("MessageEventParcelable[").append(b).append(",").append(c).append(", size=");
    if (d == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(d.length)) {
      return localObject + "]";
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.b(paramParcel, 2, b);
    emj.a(paramParcel, 3, c, false);
    emj.a(paramParcel, 4, d, false);
    emj.a(paramParcel, 5, e, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.MessageEventParcelable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */