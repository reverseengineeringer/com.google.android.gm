package com.android.mail.providers;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import cgx;
import java.util.Arrays;

public class ParticipantInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ParticipantInfo> CREATOR = new cgx();
  public final String a;
  public final String b;
  public final int c;
  public boolean d;
  public int e;
  
  public ParticipantInfo(Parcel paramParcel)
  {
    a = paramParcel.readString();
    b = paramParcel.readString();
    c = paramParcel.readInt();
    if (paramParcel.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      d = bool;
      e = paramParcel.readInt();
      return;
    }
  }
  
  public ParticipantInfo(String paramString1, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    a = paramString1;
    b = paramString2;
    c = paramInt1;
    d = paramBoolean;
    e = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof ParticipantInfo)) {
        return false;
      }
      paramObject = (ParticipantInfo)paramObject;
    } while ((TextUtils.equals(a, a)) && (TextUtils.equals(b, b)) && (c == c) && (d == d) && (e == e));
    return false;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { a, b, Integer.valueOf(c), Boolean.valueOf(d) });
  }
  
  public String toString()
  {
    boolean bool = d;
    String str1 = a;
    String str2 = b;
    int i = c;
    return String.valueOf(str1).length() + 86 + String.valueOf(str2).length() + "[ParticipantInfo: readConversation = " + bool + ", name = " + str1 + ", email = " + str2 + ", priority = " + i + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(a);
    paramParcel.writeString(b);
    paramParcel.writeInt(c);
    if (d) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(e);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.providers.ParticipantInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */