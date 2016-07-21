package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.auth.firstparty.shared.CaptchaChallenge;
import com.google.android.gms.auth.firstparty.shared.ScopeDetail;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import efm;
import emj;
import java.util.ArrayList;
import java.util.List;

public class TokenResponse
  implements SafeParcelable
{
  public static final efm CREATOR = new efm();
  final int a;
  @Deprecated
  String b;
  String c;
  public String d;
  String e;
  String f;
  String g;
  String h;
  String i;
  boolean j;
  boolean k;
  boolean l;
  boolean m;
  CaptchaChallenge n;
  List<ScopeDetail> o;
  String p;
  String q;
  boolean r;
  boolean s;
  int t;
  PostSignInData u;
  Account v;
  Long w;
  boolean x;
  List<String> y;
  String z;
  
  public TokenResponse()
  {
    a = 4;
    o = new ArrayList();
  }
  
  public TokenResponse(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, CaptchaChallenge paramCaptchaChallenge, List<ScopeDetail> paramList, String paramString9, String paramString10, boolean paramBoolean5, boolean paramBoolean6, int paramInt2, PostSignInData paramPostSignInData, Account paramAccount, Long paramLong, boolean paramBoolean7, List<String> paramList1, String paramString11)
  {
    a = paramInt1;
    b = paramString1;
    c = paramString2;
    d = paramString3;
    e = paramString4;
    f = paramString5;
    g = paramString6;
    h = paramString7;
    i = paramString8;
    j = paramBoolean1;
    k = paramBoolean2;
    l = paramBoolean3;
    m = paramBoolean4;
    n = paramCaptchaChallenge;
    o = paramList;
    p = paramString9;
    q = paramString10;
    r = paramBoolean5;
    s = paramBoolean6;
    t = paramInt2;
    u = paramPostSignInData;
    if ((paramAccount == null) && (!TextUtils.isEmpty(paramString1))) {}
    for (v = new Account(paramString1, "com.google");; v = paramAccount)
    {
      w = paramLong;
      x = paramBoolean7;
      y = paramList1;
      z = paramString11;
      return;
    }
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
    emj.a(paramParcel, 4, d, false);
    emj.a(paramParcel, 5, e, false);
    emj.a(paramParcel, 6, f, false);
    emj.a(paramParcel, 7, g, false);
    emj.a(paramParcel, 8, h, false);
    emj.a(paramParcel, 9, i, false);
    emj.a(paramParcel, 10, j);
    emj.a(paramParcel, 11, k);
    emj.a(paramParcel, 12, l);
    emj.a(paramParcel, 13, m);
    emj.a(paramParcel, 14, n, paramInt, false);
    emj.b(paramParcel, 15, o, false);
    emj.a(paramParcel, 17, q, false);
    emj.a(paramParcel, 16, p, false);
    emj.a(paramParcel, 19, s);
    emj.a(paramParcel, 18, r);
    emj.a(paramParcel, 21, u, paramInt, false);
    emj.b(paramParcel, 20, t);
    emj.a(paramParcel, 23, w);
    emj.a(paramParcel, 22, v, paramInt, false);
    emj.a(paramParcel, 25, y, false);
    emj.a(paramParcel, 24, x);
    emj.a(paramParcel, 26, z, false);
    emj.b(paramParcel, i1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.dataservice.TokenResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */