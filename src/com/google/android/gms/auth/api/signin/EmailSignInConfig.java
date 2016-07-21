package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Patterns;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import edv;
import emj;
import enz;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailSignInConfig
  implements SafeParcelable
{
  public static final Parcelable.Creator<EmailSignInConfig> CREATOR = new edv();
  final int a;
  final Uri b;
  String c;
  Uri d;
  
  public EmailSignInConfig(int paramInt, Uri paramUri1, String paramString, Uri paramUri2)
  {
    enz.a(paramUri1, "Server widget url cannot be null in order to use email/password sign in.");
    enz.a(paramUri1.toString(), "Server widget url cannot be null in order to use email/password sign in.");
    enz.b(Patterns.WEB_URL.matcher(paramUri1.toString()).matches(), "Invalid server widget url");
    a = paramInt;
    b = paramUri1;
    c = paramString;
    d = paramUri2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, paramInt, false);
    emj.a(paramParcel, 3, c, false);
    emj.a(paramParcel, 4, d, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.EmailSignInConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */