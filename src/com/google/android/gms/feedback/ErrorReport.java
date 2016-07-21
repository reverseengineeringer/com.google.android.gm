package com.google.android.gms.feedback;

import android.app.ApplicationErrorReport;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import fjn;

public class ErrorReport
  implements SafeParcelable
{
  public static final Parcelable.Creator<ErrorReport> CREATOR = new fjn();
  public int A;
  public String B;
  public String C;
  public String D;
  public Bundle E;
  public boolean F;
  public int G;
  public int H;
  public boolean I;
  public String J;
  public String K;
  public int L;
  public String M;
  public String N;
  public String O;
  public String P;
  public String Q;
  @Deprecated
  public String R;
  public String S;
  public BitmapTeleporter T;
  public String U;
  public FileTeleporter[] V;
  public String[] W;
  public boolean X;
  public String Y;
  public ThemeSettings Z;
  public final int a;
  public LogOptions aa;
  public String ab;
  public boolean ac;
  public Bundle ad;
  public ApplicationErrorReport b = new ApplicationErrorReport();
  public String c;
  public int d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public int l;
  public String m;
  public String n;
  public String o;
  public String p;
  public String q;
  public String[] r;
  public String[] s;
  public String[] t;
  public String u;
  public String v;
  public byte[] w;
  public int x;
  public int y;
  public int z;
  
  public ErrorReport()
  {
    a = 8;
  }
  
  public ErrorReport(int paramInt1, ApplicationErrorReport paramApplicationErrorReport, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt3, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String paramString14, String paramString15, byte[] paramArrayOfByte, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString16, String paramString17, String paramString18, Bundle paramBundle1, boolean paramBoolean1, int paramInt8, int paramInt9, boolean paramBoolean2, String paramString19, String paramString20, int paramInt10, String paramString21, String paramString22, String paramString23, String paramString24, String paramString25, String paramString26, String paramString27, BitmapTeleporter paramBitmapTeleporter, String paramString28, FileTeleporter[] paramArrayOfFileTeleporter, String[] paramArrayOfString4, boolean paramBoolean3, String paramString29, ThemeSettings paramThemeSettings, LogOptions paramLogOptions, String paramString30, boolean paramBoolean4, Bundle paramBundle2)
  {
    a = paramInt1;
    b = paramApplicationErrorReport;
    c = paramString1;
    d = paramInt2;
    e = paramString2;
    f = paramString3;
    g = paramString4;
    h = paramString5;
    i = paramString6;
    j = paramString7;
    k = paramString8;
    l = paramInt3;
    m = paramString9;
    n = paramString10;
    o = paramString11;
    p = paramString12;
    q = paramString13;
    r = paramArrayOfString1;
    s = paramArrayOfString2;
    t = paramArrayOfString3;
    u = paramString14;
    v = paramString15;
    w = paramArrayOfByte;
    x = paramInt4;
    y = paramInt5;
    z = paramInt6;
    A = paramInt7;
    B = paramString16;
    C = paramString17;
    D = paramString18;
    E = paramBundle1;
    F = paramBoolean1;
    G = paramInt8;
    H = paramInt9;
    I = paramBoolean2;
    J = paramString19;
    K = paramString20;
    L = paramInt10;
    M = paramString21;
    N = paramString22;
    O = paramString23;
    P = paramString24;
    Q = paramString25;
    R = paramString26;
    S = paramString27;
    T = paramBitmapTeleporter;
    U = paramString28;
    V = paramArrayOfFileTeleporter;
    W = paramArrayOfString4;
    X = paramBoolean3;
    Y = paramString29;
    Z = paramThemeSettings;
    aa = paramLogOptions;
    ab = paramString30;
    ac = paramBoolean4;
    ad = paramBundle2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1 = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, paramInt, false);
    emj.a(paramParcel, 3, c, false);
    emj.b(paramParcel, 4, d);
    emj.a(paramParcel, 5, e, false);
    emj.a(paramParcel, 6, f, false);
    emj.a(paramParcel, 7, g, false);
    emj.a(paramParcel, 8, h, false);
    emj.a(paramParcel, 9, i, false);
    emj.a(paramParcel, 10, j, false);
    emj.a(paramParcel, 11, k, false);
    emj.b(paramParcel, 12, l);
    emj.a(paramParcel, 13, m, false);
    emj.a(paramParcel, 14, n, false);
    emj.a(paramParcel, 15, o, false);
    emj.a(paramParcel, 17, q, false);
    emj.a(paramParcel, 16, p, false);
    emj.a(paramParcel, 19, s);
    emj.a(paramParcel, 18, r);
    emj.a(paramParcel, 21, u, false);
    emj.a(paramParcel, 20, t);
    emj.a(paramParcel, 23, w, false);
    emj.a(paramParcel, 22, v, false);
    emj.b(paramParcel, 25, y);
    emj.b(paramParcel, 24, x);
    emj.b(paramParcel, 27, A);
    emj.b(paramParcel, 26, z);
    emj.a(paramParcel, 29, C, false);
    emj.a(paramParcel, 28, B, false);
    emj.a(paramParcel, 31, E);
    emj.a(paramParcel, 30, D, false);
    emj.b(paramParcel, 34, H);
    emj.a(paramParcel, 35, I);
    emj.a(paramParcel, 32, F);
    emj.b(paramParcel, 33, G);
    emj.b(paramParcel, 38, L);
    emj.a(paramParcel, 39, M, false);
    emj.a(paramParcel, 36, J, false);
    emj.a(paramParcel, 37, K, false);
    emj.a(paramParcel, 42, P, false);
    emj.a(paramParcel, 43, Q, false);
    emj.a(paramParcel, 40, N, false);
    emj.a(paramParcel, 41, O, false);
    emj.a(paramParcel, 46, T, paramInt, false);
    emj.a(paramParcel, 47, U, false);
    emj.a(paramParcel, 44, R, false);
    emj.a(paramParcel, 45, S, false);
    emj.a(paramParcel, 51, Y, false);
    emj.a(paramParcel, 50, X);
    emj.a(paramParcel, 49, W);
    emj.a(paramParcel, 48, V, paramInt);
    emj.a(paramParcel, 55, ac);
    emj.a(paramParcel, 54, ab, false);
    emj.a(paramParcel, 53, aa, paramInt, false);
    emj.a(paramParcel, 52, Z, paramInt, false);
    emj.a(paramParcel, 56, ad);
    emj.b(paramParcel, i1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.feedback.ErrorReport
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */