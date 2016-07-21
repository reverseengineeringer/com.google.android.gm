package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import emj;
import faw;
import fea;

public class CloseContentsAndUpdateMetadataRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<CloseContentsAndUpdateMetadataRequest> CREATOR = new fea();
  final int a;
  final DriveId b;
  final MetadataBundle c;
  final Contents d;
  final boolean e;
  final String f;
  final int g;
  final int h;
  final boolean i;
  
  public CloseContentsAndUpdateMetadataRequest(int paramInt1, DriveId paramDriveId, MetadataBundle paramMetadataBundle, Contents paramContents, boolean paramBoolean1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    a = paramInt1;
    b = paramDriveId;
    c = paramMetadataBundle;
    d = paramContents;
    e = paramBoolean1;
    f = paramString;
    g = paramInt2;
    h = paramInt3;
    i = paramBoolean2;
  }
  
  public CloseContentsAndUpdateMetadataRequest(DriveId paramDriveId, MetadataBundle paramMetadataBundle, int paramInt, boolean paramBoolean, faw paramfaw)
  {
    this(1, paramDriveId, paramMetadataBundle, null, b, a, c, paramInt, paramBoolean);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, paramInt, false);
    emj.a(paramParcel, 3, c, paramInt, false);
    emj.a(paramParcel, 4, d, paramInt, false);
    emj.a(paramParcel, 5, e);
    emj.a(paramParcel, 6, f, false);
    emj.b(paramParcel, 7, g);
    emj.b(paramParcel, 8, h);
    emj.a(paramParcel, 9, i);
    emj.b(paramParcel, j);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */