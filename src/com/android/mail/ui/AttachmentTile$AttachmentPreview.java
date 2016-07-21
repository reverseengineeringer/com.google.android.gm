package com.android.mail.ui;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import ckj;
import com.android.mail.providers.Attachment;

public final class AttachmentTile$AttachmentPreview
  implements Parcelable
{
  public static final Parcelable.Creator<AttachmentPreview> CREATOR = new ckj();
  public final String a;
  public final Bitmap b;
  
  public AttachmentTile$AttachmentPreview(Parcel paramParcel)
  {
    a = paramParcel.readString();
    b = ((Bitmap)paramParcel.readParcelable(null));
  }
  
  public AttachmentTile$AttachmentPreview(Attachment paramAttachment, Bitmap paramBitmap)
  {
    a = paramAttachment.k().toString();
    b = paramBitmap;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(a);
    paramParcel.writeParcelable(b, 0);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.AttachmentTile.AttachmentPreview
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */