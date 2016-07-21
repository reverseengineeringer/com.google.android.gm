package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.query.internal.FilterHolder;
import emj;
import fdj;

public class OpenFileIntentSenderRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<OpenFileIntentSenderRequest> CREATOR = new fdj();
  final int a;
  final String b;
  final String[] c;
  final DriveId d;
  final FilterHolder e;
  
  public OpenFileIntentSenderRequest(int paramInt, String paramString, String[] paramArrayOfString, DriveId paramDriveId, FilterHolder paramFilterHolder)
  {
    a = paramInt;
    b = paramString;
    c = paramArrayOfString;
    d = paramDriveId;
    e = paramFilterHolder;
  }
  
  public OpenFileIntentSenderRequest(String paramString, String[] paramArrayOfString, DriveId paramDriveId, FilterHolder paramFilterHolder)
  {
    this(1, paramString, paramArrayOfString, paramDriveId, paramFilterHolder);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, false);
    emj.a(paramParcel, 3, c);
    emj.a(paramParcel, 4, d, paramInt, false);
    emj.a(paramParcel, 5, e, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.internal.OpenFileIntentSenderRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */