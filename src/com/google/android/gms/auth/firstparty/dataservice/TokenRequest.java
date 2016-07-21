package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.auth.firstparty.shared.CaptchaSolution;
import com.google.android.gms.auth.firstparty.shared.FACLConfig;
import com.google.android.gms.auth.firstparty.shared.PACLConfig;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import efk;
import efl;
import emj;

public class TokenRequest
  implements SafeParcelable
{
  public static final efl CREATOR = new efl();
  final int a;
  public String b;
  public String c;
  Bundle d = new Bundle();
  volatile FACLConfig e;
  volatile PACLConfig f;
  volatile boolean g;
  volatile boolean h;
  String i = efk.a.toString();
  public AppDescription j;
  CaptchaSolution k;
  public volatile boolean l;
  volatile boolean m;
  volatile boolean n;
  final String o;
  
  public TokenRequest()
  {
    a = 2;
    o = "com.google";
  }
  
  public TokenRequest(int paramInt, String paramString1, String paramString2, Bundle paramBundle, FACLConfig paramFACLConfig, PACLConfig paramPACLConfig, boolean paramBoolean1, boolean paramBoolean2, String paramString3, AppDescription paramAppDescription, CaptchaSolution paramCaptchaSolution, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, String paramString4)
  {
    a = paramInt;
    b = paramString1;
    c = paramString2;
    d = paramBundle;
    e = paramFACLConfig;
    f = paramPACLConfig;
    g = paramBoolean1;
    h = paramBoolean2;
    i = paramString3;
    j = paramAppDescription;
    k = paramCaptchaSolution;
    l = paramBoolean3;
    m = paramBoolean4;
    n = paramBoolean5;
    o = paramString4;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1 = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, false);
    emj.a(paramParcel, 3, c, false);
    emj.a(paramParcel, 4, d);
    emj.a(paramParcel, 5, e, paramInt, false);
    emj.a(paramParcel, 6, f, paramInt, false);
    emj.a(paramParcel, 7, g);
    emj.a(paramParcel, 8, h);
    emj.a(paramParcel, 9, i, false);
    emj.a(paramParcel, 10, j, paramInt, false);
    emj.a(paramParcel, 11, k, paramInt, false);
    emj.a(paramParcel, 12, l);
    emj.a(paramParcel, 13, m);
    emj.a(paramParcel, 14, n);
    emj.a(paramParcel, 15, o, false);
    emj.b(paramParcel, i1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.dataservice.TokenRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */