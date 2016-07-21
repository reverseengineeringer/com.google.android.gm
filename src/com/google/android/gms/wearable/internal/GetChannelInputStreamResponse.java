package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import gfc;

public class GetChannelInputStreamResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetChannelInputStreamResponse> CREATOR = new gfc();
  public final int a;
  public final int b;
  public final ParcelFileDescriptor c;
  
  public GetChannelInputStreamResponse(int paramInt1, int paramInt2, ParcelFileDescriptor paramParcelFileDescriptor)
  {
    a = paramInt1;
    b = paramInt2;
    c = paramParcelFileDescriptor;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.b(paramParcel, 2, b);
    emj.a(paramParcel, 3, c, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.GetChannelInputStreamResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */