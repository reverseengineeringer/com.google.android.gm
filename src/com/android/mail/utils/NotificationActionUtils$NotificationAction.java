package com.android.mail.utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.providers.Message;
import cvv;
import cvw;

public class NotificationActionUtils$NotificationAction
  implements Parcelable
{
  public static final Parcelable.ClassLoaderCreator<NotificationAction> CREATOR = new cvv();
  public final cvw a;
  public final Account b;
  public final Conversation c;
  public final Folder d;
  final long e;
  public final int f;
  public final int g;
  private final long h;
  private final String i;
  private final long j;
  
  public NotificationActionUtils$NotificationAction(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    a = cvw.values()[paramParcel.readInt()];
    b = ((Account)paramParcel.readParcelable(paramClassLoader));
    c = ((Conversation)paramParcel.readParcelable(paramClassLoader));
    d = ((Folder)paramParcel.readParcelable(paramClassLoader));
    h = paramParcel.readLong();
    i = paramParcel.readString();
    j = paramParcel.readLong();
    e = paramParcel.readLong();
    f = paramParcel.readInt();
    g = paramParcel.readInt();
  }
  
  public NotificationActionUtils$NotificationAction(cvw paramcvw, Account paramAccount, Conversation paramConversation, Message paramMessage, Folder paramFolder, long paramLong, int paramInt1, int paramInt2)
  {
    a = paramcvw;
    b = paramAccount;
    c = paramConversation;
    d = paramFolder;
    h = b;
    i = e;
    j = d;
    e = paramLong;
    f = paramInt1;
    g = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(a.ordinal());
    paramParcel.writeParcelable(b, 0);
    paramParcel.writeParcelable(c, 0);
    paramParcel.writeParcelable(d, 0);
    paramParcel.writeLong(h);
    paramParcel.writeString(i);
    paramParcel.writeLong(j);
    paramParcel.writeLong(e);
    paramParcel.writeInt(f);
    paramParcel.writeInt(g);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.utils.NotificationActionUtils.NotificationAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */