package com.android.mail.compose.security;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import ccu;
import cui;
import java.util.Arrays;

public class MessageSecurityRecipient
  implements Parcelable
{
  public static final Parcelable.Creator<MessageSecurityRecipient> CREATOR = new ccu();
  public final String a;
  public final String b;
  public final String c;
  public final byte[] d;
  public Bitmap e;
  
  public MessageSecurityRecipient(Parcel paramParcel)
  {
    a = paramParcel.readString();
    b = paramParcel.readString();
    int i = paramParcel.readInt();
    if (i != -1)
    {
      d = new byte[i];
      paramParcel.readByteArray(d);
    }
    for (;;)
    {
      c = cui.b(b);
      return;
      d = null;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof MessageSecurityRecipient)) {
      return false;
    }
    paramObject = (MessageSecurityRecipient)paramObject;
    return b.equals(b);
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { b });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(a);
    paramParcel.writeString(b);
    if (d != null)
    {
      paramParcel.writeInt(d.length);
      paramParcel.writeByteArray(d);
      return;
    }
    paramParcel.writeInt(-1);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.compose.security.MessageSecurityRecipient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */