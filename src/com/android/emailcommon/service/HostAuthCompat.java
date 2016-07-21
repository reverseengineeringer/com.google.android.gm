package com.android.emailcommon.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import beu;
import com.android.emailcommon.provider.Credential;
import com.android.emailcommon.provider.HostAuth;

public class HostAuthCompat
  implements Parcelable
{
  public static final Parcelable.Creator<HostAuthCompat> CREATOR = new beu();
  private String a;
  private String b;
  private int c;
  private int d;
  private String e;
  private String f;
  private String g;
  private String h;
  private byte[] i;
  private String j;
  private String k;
  private String l;
  private long m;
  
  public HostAuthCompat(Parcel paramParcel)
  {
    a = paramParcel.readString();
    b = paramParcel.readString();
    c = paramParcel.readInt();
    d = paramParcel.readInt();
    e = paramParcel.readString();
    f = paramParcel.readString();
    g = paramParcel.readString();
    h = paramParcel.readString();
    i = paramParcel.createByteArray();
    j = paramParcel.readString();
    k = paramParcel.readString();
    l = paramParcel.readString();
    m = paramParcel.readLong();
  }
  
  public HostAuthCompat(HostAuth paramHostAuth)
  {
    a = b;
    b = c;
    c = d;
    d = e;
    e = f;
    f = g;
    g = h;
    h = i;
    i = j;
    if (l != null)
    {
      j = l.c;
      k = l.d;
      l = l.e;
      m = l.f;
    }
  }
  
  public final HostAuth a()
  {
    HostAuth localHostAuth = new HostAuth();
    b = a;
    c = b;
    d = c;
    e = d;
    f = e;
    g = f;
    h = g;
    i = h;
    j = i;
    if (!TextUtils.isEmpty(j))
    {
      l = new Credential();
      l.c = j;
      l.d = k;
      l.e = l;
      l.f = m;
    }
    return localHostAuth;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    String str = a;
    return String.valueOf(str).length() + 11 + "[protocol " + str + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(a);
    paramParcel.writeString(b);
    paramParcel.writeInt(c);
    paramParcel.writeInt(d);
    paramParcel.writeString(e);
    paramParcel.writeString(f);
    paramParcel.writeString(g);
    paramParcel.writeString(h);
    paramParcel.writeByteArray(i);
    paramParcel.writeString(j);
    paramParcel.writeString(k);
    paramParcel.writeString(l);
    paramParcel.writeLong(m);
  }
}

/* Location:
 * Qualified Name:     com.android.emailcommon.service.HostAuthCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */