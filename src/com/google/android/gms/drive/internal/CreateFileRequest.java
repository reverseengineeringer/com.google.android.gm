package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import emj;
import enz;
import faw;
import fef;

public class CreateFileRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<CreateFileRequest> CREATOR = new fef();
  final int a;
  final DriveId b;
  final MetadataBundle c;
  final Contents d;
  final Integer e;
  final boolean f;
  final String g;
  final int h;
  final int i;
  
  public CreateFileRequest(int paramInt1, DriveId paramDriveId, MetadataBundle paramMetadataBundle, Contents paramContents, Integer paramInteger, boolean paramBoolean, String paramString, int paramInt2, int paramInt3)
  {
    if ((paramContents != null) && (paramInt3 != 0)) {
      if (c != paramInt3) {
        break label67;
      }
    }
    label67:
    for (boolean bool = true;; bool = false)
    {
      enz.b(bool, "inconsistent contents reference");
      if (((paramInteger != null) && (paramInteger.intValue() != 0)) || (paramContents != null) || (paramInt3 != 0)) {
        break;
      }
      throw new IllegalArgumentException("Need a valid contents");
    }
    a = paramInt1;
    b = ((DriveId)enz.a(paramDriveId));
    c = ((MetadataBundle)enz.a(paramMetadataBundle));
    d = paramContents;
    e = paramInteger;
    g = paramString;
    h = paramInt2;
    f = paramBoolean;
    i = paramInt3;
  }
  
  public CreateFileRequest(DriveId paramDriveId, MetadataBundle paramMetadataBundle, int paramInt1, int paramInt2, faw paramfaw)
  {
    this(2, paramDriveId, paramMetadataBundle, null, Integer.valueOf(paramInt2), b, a, c, paramInt1);
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
    emj.a(paramParcel, 6, f);
    emj.a(paramParcel, 7, g, false);
    emj.b(paramParcel, 8, h);
    emj.b(paramParcel, 9, i);
    emj.b(paramParcel, j);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.internal.CreateFileRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */