package com.android.emailcommon;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bbv;

public class EmailProviderConfiguration
  implements Parcelable
{
  public static final Parcelable.Creator<EmailProviderConfiguration> CREATOR = new bbv();
  public final int a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p;
  public String q;
  
  public EmailProviderConfiguration(int paramInt)
  {
    a = paramInt;
  }
  
  public EmailProviderConfiguration(Parcel paramParcel)
  {
    a = paramParcel.readInt();
    b = paramParcel.readString();
    c = paramParcel.readString();
    d = paramParcel.readString();
    e = paramParcel.readString();
    f = paramParcel.readString();
    g = paramParcel.readString();
    h = paramParcel.readString();
    i = paramParcel.readString();
    j = paramParcel.readString();
    k = paramParcel.readString();
    l = paramParcel.readString();
    m = paramParcel.readString();
    n = paramParcel.readString();
    o = paramParcel.readString();
    p = paramParcel.readString();
    q = paramParcel.readString();
  }
  
  private final String a(String paramString1, String paramString2, String paramString3)
  {
    return paramString1.replaceAll("\\$email", paramString2).replaceAll("\\$user", paramString3).replaceAll("\\$domain", d);
  }
  
  public final void a(String paramString)
  {
    String str = paramString.split("@")[0];
    m = a(e, paramString, str);
    n = a(f, paramString, str);
    o = a(g, paramString, str);
    p = a(h, paramString, str);
  }
  
  public final void b(String paramString)
  {
    String str = paramString.split("@")[0];
    m = a(i, paramString, str);
    n = a(j, paramString, str);
    o = a(k, paramString, str);
    p = a(l, paramString, str);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(a);
    paramParcel.writeString(b);
    paramParcel.writeString(c);
    paramParcel.writeString(d);
    paramParcel.writeString(e);
    paramParcel.writeString(f);
    paramParcel.writeString(g);
    paramParcel.writeString(h);
    paramParcel.writeString(i);
    paramParcel.writeString(j);
    paramParcel.writeString(k);
    paramParcel.writeString(l);
    paramParcel.writeString(m);
    paramParcel.writeString(n);
    paramParcel.writeString(o);
    paramParcel.writeString(p);
    paramParcel.writeString(q);
  }
}

/* Location:
 * Qualified Name:     com.android.emailcommon.EmailProviderConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */