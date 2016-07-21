package com.google.android.gsf;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import gic;
import gid;

public class LoginData
  implements Parcelable
{
  public static final Parcelable.Creator<LoginData> CREATOR = new gic();
  public String a = null;
  public String b = null;
  public String c = null;
  public String d = null;
  public String e = null;
  public byte[] f = null;
  public String g = null;
  public String h = null;
  public int i = 0;
  public gid j = null;
  public String k = null;
  public String l = null;
  public String m = null;
  public String n = null;
  
  public LoginData() {}
  
  public LoginData(Parcel paramParcel)
  {
    a = paramParcel.readString();
    b = paramParcel.readString();
    c = paramParcel.readString();
    d = paramParcel.readString();
    e = paramParcel.readString();
    int i1 = paramParcel.readInt();
    String str;
    if (i1 == -1)
    {
      f = null;
      g = paramParcel.readString();
      h = paramParcel.readString();
      i = paramParcel.readInt();
      str = paramParcel.readString();
      if (str != null) {
        break label218;
      }
    }
    label218:
    for (j = null;; j = gid.a(str))
    {
      k = paramParcel.readString();
      l = paramParcel.readString();
      m = paramParcel.readString();
      n = paramParcel.readString();
      return;
      f = new byte[i1];
      paramParcel.readByteArray(f);
      break;
    }
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
    paramParcel.writeString(d);
    paramParcel.writeString(e);
    if (f == null)
    {
      paramParcel.writeInt(-1);
      paramParcel.writeString(g);
      paramParcel.writeString(h);
      paramParcel.writeInt(i);
      if (j != null) {
        break label141;
      }
      paramParcel.writeString(null);
    }
    for (;;)
    {
      paramParcel.writeString(k);
      paramParcel.writeString(l);
      paramParcel.writeString(m);
      paramParcel.writeString(n);
      return;
      paramParcel.writeInt(f.length);
      paramParcel.writeByteArray(f);
      break;
      label141:
      paramParcel.writeString(j.name());
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gsf.LoginData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */