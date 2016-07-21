package com.android.mail.providers;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import cgc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ConversationInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ConversationInfo> CREATOR = new cgc();
  public final ArrayList<ParticipantInfo> a;
  public int b;
  public int c;
  public String d;
  public String e;
  
  public ConversationInfo()
  {
    a = new ArrayList();
  }
  
  public ConversationInfo(int paramInt)
  {
    b = paramInt;
    a = new ArrayList(paramInt);
  }
  
  public ConversationInfo(Parcel paramParcel)
  {
    b = paramParcel.readInt();
    c = paramParcel.readInt();
    d = paramParcel.readString();
    e = paramParcel.readString();
    a = paramParcel.createTypedArrayList(ParticipantInfo.CREATOR);
  }
  
  public static ConversationInfo a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    paramArrayOfByte = (ConversationInfo)CREATOR.createFromParcel(localParcel);
    localParcel.recycle();
    return paramArrayOfByte;
  }
  
  public final void a(ParticipantInfo paramParticipantInfo)
  {
    a.add(paramParticipantInfo);
  }
  
  public final boolean a(boolean paramBoolean)
  {
    Iterator localIterator = a.iterator();
    boolean bool2 = false;
    if (localIterator.hasNext())
    {
      ParticipantInfo localParticipantInfo = (ParticipantInfo)localIterator.next();
      if (d != paramBoolean) {
        d = paramBoolean;
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        bool2 = bool1 | bool2;
        break;
      }
    }
    if ((b > 0) && (paramBoolean)) {
      d = e;
    }
    return bool2;
  }
  
  public final byte[] a()
  {
    Parcel localParcel = Parcel.obtain();
    writeToParcel(localParcel, 0);
    byte[] arrayOfByte = localParcel.marshall();
    localParcel.recycle();
    return arrayOfByte;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(b), Integer.valueOf(c), a, d, e });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[ConversationInfo object: messageCount = ");
    localStringBuilder.append(b);
    localStringBuilder.append(", draftCount = ");
    localStringBuilder.append(c);
    localStringBuilder.append(", firstUnreadSnippet= ");
    localStringBuilder.append(d);
    localStringBuilder.append(", participants = ");
    localStringBuilder.append(a.toString());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(b);
    paramParcel.writeInt(c);
    paramParcel.writeString(d);
    paramParcel.writeString(e);
    paramParcel.writeTypedList(a);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.providers.ConversationInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */