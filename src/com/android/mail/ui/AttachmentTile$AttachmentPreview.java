package com.android.mail.ui;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.android.mail.providers.Attachment;
import com.android.mail.utils.AttachmentUtils;

public final class AttachmentTile$AttachmentPreview
  implements Parcelable
{
  public static final Parcelable.Creator<AttachmentPreview> CREATOR = new Parcelable.Creator()
  {
    public AttachmentTile.AttachmentPreview createFromParcel(Parcel paramAnonymousParcel)
    {
      return new AttachmentTile.AttachmentPreview(paramAnonymousParcel, null);
    }
    
    public AttachmentTile.AttachmentPreview[] newArray(int paramAnonymousInt)
    {
      return new AttachmentTile.AttachmentPreview[paramAnonymousInt];
    }
  };
  public String attachmentIdentifier;
  public Bitmap preview;
  
  private AttachmentTile$AttachmentPreview(Parcel paramParcel)
  {
    attachmentIdentifier = paramParcel.readString();
    preview = ((Bitmap)paramParcel.readParcelable(null));
  }
  
  public AttachmentTile$AttachmentPreview(Attachment paramAttachment, Bitmap paramBitmap)
  {
    attachmentIdentifier = AttachmentUtils.getIdentifier(paramAttachment);
    preview = paramBitmap;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(attachmentIdentifier);
    paramParcel.writeParcelable(preview, 0);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.AttachmentTile.AttachmentPreview
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */