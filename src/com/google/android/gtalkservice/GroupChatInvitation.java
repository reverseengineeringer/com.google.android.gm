package com.google.android.gtalkservice;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import gii;

public class GroupChatInvitation
  implements Parcelable
{
  public static final Parcelable.Creator<GroupChatInvitation> CREATOR = new gii();
  private String a;
  private String b;
  private String c;
  private String d;
  private long e;
  
  public GroupChatInvitation(Parcel paramParcel)
  {
    a = paramParcel.readString();
    b = paramParcel.readString();
    d = paramParcel.readString();
    c = paramParcel.readString();
    e = paramParcel.readLong();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(a);
    paramParcel.writeString(b);
    paramParcel.writeString(d);
    paramParcel.writeString(c);
    paramParcel.writeLong(e);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gtalkservice.GroupChatInvitation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */