package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import fda;

public class OnFetchThumbnailResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnFetchThumbnailResponse> CREATOR = new fda();
  final int a;
  final ParcelFileDescriptor b;
  
  public OnFetchThumbnailResponse(int paramInt, ParcelFileDescriptor paramParcelFileDescriptor)
  {
    a = paramInt;
    b = paramParcelFileDescriptor;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, paramInt | 0x1, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.internal.OnFetchThumbnailResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */