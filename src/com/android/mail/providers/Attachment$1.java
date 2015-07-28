package com.android.mail.providers;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class Attachment$1
  implements Parcelable.Creator<Attachment>
{
  public Attachment createFromParcel(Parcel paramParcel)
  {
    return new Attachment(paramParcel);
  }
  
  public Attachment[] newArray(int paramInt)
  {
    return new Attachment[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.android.mail.providers.Attachment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */