package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import edy;
import emj;
import enz;

public class SignInAccount
  implements SafeParcelable
{
  public static final Parcelable.Creator<SignInAccount> CREATOR = new edy();
  final int a;
  String b;
  String c;
  String d;
  String e;
  Uri f;
  
  public SignInAccount(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Uri paramUri)
  {
    a = paramInt;
    d = enz.a(paramString3, "Email cannot be empty.");
    e = paramString4;
    f = paramUri;
    b = paramString1;
    c = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, false);
    emj.a(paramParcel, 3, c, false);
    emj.a(paramParcel, 4, d, false);
    emj.a(paramParcel, 5, e, false);
    emj.a(paramParcel, 6, f, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.SignInAccount
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */