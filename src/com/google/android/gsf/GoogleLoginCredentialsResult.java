package com.google.android.gsf;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import ghx;

public class GoogleLoginCredentialsResult
  implements Parcelable
{
  public static final Parcelable.Creator<GoogleLoginCredentialsResult> CREATOR = new ghx();
  private String a;
  private String b;
  private Intent c;
  
  public GoogleLoginCredentialsResult()
  {
    b = null;
    c = null;
    a = null;
  }
  
  public GoogleLoginCredentialsResult(Parcel paramParcel)
  {
    a = paramParcel.readString();
    b = paramParcel.readString();
    int i = paramParcel.readInt();
    c = null;
    if (i == 1)
    {
      c = new Intent();
      c.readFromParcel(paramParcel);
      c.setExtrasClassLoader(getClass().getClassLoader());
    }
  }
  
  public int describeContents()
  {
    if (c != null) {
      return c.describeContents();
    }
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(a);
    paramParcel.writeString(b);
    if (c != null)
    {
      paramParcel.writeInt(1);
      c.writeToParcel(paramParcel, 0);
      return;
    }
    paramParcel.writeInt(0);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gsf.GoogleLoginCredentialsResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */