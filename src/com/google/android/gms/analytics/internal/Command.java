package com.google.android.gms.analytics.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import eba;

public class Command
  implements Parcelable
{
  public static final Parcelable.Creator<Command> CREATOR = new eba();
  public String a;
  public String b;
  public String c;
  
  public Command() {}
  
  public Command(Parcel paramParcel)
  {
    a = paramParcel.readString();
    b = paramParcel.readString();
    c = paramParcel.readString();
  }
  
  public Command(String paramString1, String paramString2, String paramString3)
  {
    a = paramString1;
    b = paramString2;
    c = paramString3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(a);
    paramParcel.writeString(b);
    paramParcel.writeString(c);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.analytics.internal.Command
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */