package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import enx;
import ghu;
import java.util.Arrays;

public class Asset
  implements SafeParcelable
{
  public static final Parcelable.Creator<Asset> CREATOR = new ghu();
  final int a;
  public byte[] b;
  public String c;
  public ParcelFileDescriptor d;
  public Uri e;
  
  public Asset(int paramInt, byte[] paramArrayOfByte, String paramString, ParcelFileDescriptor paramParcelFileDescriptor, Uri paramUri)
  {
    a = paramInt;
    b = paramArrayOfByte;
    c = paramString;
    d = paramParcelFileDescriptor;
    e = paramUri;
  }
  
  public static Asset a(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    if (paramParcelFileDescriptor == null) {
      throw new IllegalArgumentException("Asset fd cannot be null");
    }
    return new Asset(1, null, null, paramParcelFileDescriptor, null);
  }
  
  public static Asset a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("Asset data cannot be null");
    }
    return new Asset(1, paramArrayOfByte, null, null, null);
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
      if (!(paramObject instanceof Asset)) {
        return false;
      }
      paramObject = (Asset)paramObject;
    } while ((enx.a(b, b)) && (enx.a(c, c)) && (enx.a(d, d)) && (enx.a(e, e)));
    return false;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { b, c, d, e });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Asset[@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    if (c == null) {
      localStringBuilder.append(", nodigest");
    }
    for (;;)
    {
      if (b != null)
      {
        localStringBuilder.append(", size=");
        localStringBuilder.append(b.length);
      }
      if (d != null)
      {
        localStringBuilder.append(", fd=");
        localStringBuilder.append(d);
      }
      if (e != null)
      {
        localStringBuilder.append(", uri=");
        localStringBuilder.append(e);
      }
      localStringBuilder.append("]");
      return localStringBuilder.toString();
      localStringBuilder.append(", ");
      localStringBuilder.append(c);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt |= 0x1;
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, false);
    emj.a(paramParcel, 3, c, false);
    emj.a(paramParcel, 4, d, paramInt, false);
    emj.a(paramParcel, 5, e, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.Asset
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */