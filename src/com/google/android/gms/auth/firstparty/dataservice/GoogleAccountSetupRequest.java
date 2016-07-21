package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.auth.firstparty.shared.AccountCredentials;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.auth.firstparty.shared.CaptchaSolution;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import eey;
import emj;

public class GoogleAccountSetupRequest
  implements SafeParcelable
{
  public static final eey CREATOR = new eey();
  final int a;
  Bundle b;
  boolean c;
  boolean d;
  boolean e;
  String f;
  String g;
  String h;
  String i;
  boolean j;
  boolean k;
  boolean l;
  String m;
  AppDescription n;
  AccountCredentials o;
  CaptchaSolution p;
  String q;
  String r;
  
  public GoogleAccountSetupRequest()
  {
    a = 1;
    b = new Bundle();
  }
  
  public GoogleAccountSetupRequest(int paramInt, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, String paramString5, AppDescription paramAppDescription, AccountCredentials paramAccountCredentials, CaptchaSolution paramCaptchaSolution, String paramString6, String paramString7)
  {
    a = paramInt;
    b = paramBundle;
    c = paramBoolean1;
    d = paramBoolean2;
    e = paramBoolean3;
    f = paramString1;
    g = paramString2;
    h = paramString3;
    i = paramString4;
    j = paramBoolean4;
    k = paramBoolean5;
    l = paramBoolean6;
    m = paramString5;
    n = paramAppDescription;
    o = paramAccountCredentials;
    p = paramCaptchaSolution;
    q = paramString6;
    r = paramString7;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1 = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b);
    emj.a(paramParcel, 3, c);
    emj.a(paramParcel, 4, d);
    emj.a(paramParcel, 5, e);
    emj.a(paramParcel, 6, f, false);
    emj.a(paramParcel, 7, g, false);
    emj.a(paramParcel, 8, h, false);
    emj.a(paramParcel, 9, i, false);
    emj.a(paramParcel, 10, j);
    emj.a(paramParcel, 11, k);
    emj.a(paramParcel, 12, l);
    emj.a(paramParcel, 13, m, false);
    emj.a(paramParcel, 14, n, paramInt, false);
    emj.a(paramParcel, 15, o, paramInt, false);
    emj.a(paramParcel, 17, q, false);
    emj.a(paramParcel, 16, p, paramInt, false);
    emj.a(paramParcel, 18, r, false);
    emj.b(paramParcel, i1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.dataservice.GoogleAccountSetupRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */