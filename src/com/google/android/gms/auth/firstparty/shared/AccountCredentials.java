package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ege;
import emj;
import enz;

public class AccountCredentials
  implements SafeParcelable
{
  public static final ege CREATOR = new ege();
  final int a;
  boolean b;
  String c;
  String d;
  String e;
  String f;
  String g;
  String h;
  final String i;
  
  @Deprecated
  public AccountCredentials()
  {
    this("com.google");
  }
  
  public AccountCredentials(int paramInt, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    a = paramInt;
    b = paramBoolean;
    c = paramString1;
    d = paramString2;
    e = paramString3;
    f = paramString4;
    g = paramString5;
    h = paramString6;
    i = paramString7;
  }
  
  private AccountCredentials(String paramString)
  {
    a = 2;
    i = enz.a(paramString, "Account type can't be empty.");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b);
    emj.a(paramParcel, 3, c, false);
    emj.a(paramParcel, 4, d, false);
    emj.a(paramParcel, 5, e, false);
    emj.a(paramParcel, 6, f, false);
    emj.a(paramParcel, 7, g, false);
    emj.a(paramParcel, 8, h, false);
    emj.a(paramParcel, 9, i, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.shared.AccountCredentials
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */