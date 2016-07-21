package com.google.android.gm.utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import dzc;
import java.util.Arrays;

public class WebViewUrl
  implements Parcelable
{
  public static final Parcelable.Creator<WebViewUrl> CREATOR = new dzc();
  public final String a;
  public final boolean b;
  public final String c;
  
  public WebViewUrl(Parcel paramParcel)
  {
    a = paramParcel.readString();
    if (paramParcel.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      c = paramParcel.readString();
      return;
    }
  }
  
  public WebViewUrl(String paramString1, boolean paramBoolean, String paramString2)
  {
    a = paramString1;
    b = paramBoolean;
    c = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof WebViewUrl)) {}
    do
    {
      return false;
      paramObject = (WebViewUrl)paramObject;
    } while ((b != b) || (!TextUtils.equals(a, a)) || (!TextUtils.equals(c, c)));
    return true;
  }
  
  public int hashCode()
  {
    int i = 1;
    int j = Arrays.hashCode(new Object[] { a, c });
    if (b) {}
    for (;;)
    {
      return i + j;
      i = 0;
    }
  }
  
  public String toString()
  {
    String str2 = String.valueOf(super.toString());
    String str3 = a;
    if (b) {}
    for (String str1 = "";; str1 = "un")
    {
      str1 = String.valueOf(String.format(" [url=%s %sauthenticated whitelist=%s]", new Object[] { str3, str1, c }));
      if (str1.length() == 0) {
        break;
      }
      return str2.concat(str1);
    }
    return new String(str2);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(a);
    if (b) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(c);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.utils.WebViewUrl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */