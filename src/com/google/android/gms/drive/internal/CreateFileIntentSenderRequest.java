package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import emj;
import fee;

public class CreateFileIntentSenderRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<CreateFileIntentSenderRequest> CREATOR = new fee();
  final int a;
  final MetadataBundle b;
  final int c;
  final String d;
  final DriveId e;
  final Integer f;
  
  public CreateFileIntentSenderRequest(int paramInt1, MetadataBundle paramMetadataBundle, int paramInt2, String paramString, DriveId paramDriveId, Integer paramInteger)
  {
    a = paramInt1;
    b = paramMetadataBundle;
    c = paramInt2;
    d = paramString;
    e = paramDriveId;
    f = paramInteger;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, paramInt, false);
    emj.b(paramParcel, 3, c);
    emj.a(paramParcel, 4, d, false);
    emj.a(paramParcel, 5, e, paramInt, false);
    emj.a(paramParcel, 6, f);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.internal.CreateFileIntentSenderRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */