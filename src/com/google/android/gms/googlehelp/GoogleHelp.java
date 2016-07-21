package com.google.android.gms.googlehelp;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import android.view.View;
import android.view.Window;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.feedback.ErrorReport;
import com.google.android.gms.feedback.ThemeSettings;
import com.google.android.gms.googlehelp.internal.common.OverflowMenuItem;
import com.google.android.gms.googlehelp.internal.common.TogglingData;
import emj;
import fld;
import java.util.ArrayList;
import java.util.List;

public final class GoogleHelp
  implements SafeParcelable
{
  public static final Parcelable.Creator<GoogleHelp> CREATOR = new fld();
  final int a;
  String b;
  public Account c;
  Bundle d;
  String e;
  int f;
  int g;
  boolean h;
  boolean i;
  List<String> j;
  @Deprecated
  Bundle k;
  @Deprecated
  Bitmap l;
  @Deprecated
  byte[] m;
  @Deprecated
  int n;
  @Deprecated
  int o;
  String p;
  public Uri q;
  List<OverflowMenuItem> r;
  @Deprecated
  int s;
  public ThemeSettings t;
  List<OfflineSuggestion> u;
  boolean v;
  public ErrorReport w = new ErrorReport();
  public TogglingData x;
  int y;
  PendingIntent z;
  
  public GoogleHelp(int paramInt1, String paramString1, Account paramAccount, Bundle paramBundle1, String paramString2, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, List<String> paramList, Bundle paramBundle2, Bitmap paramBitmap, byte[] paramArrayOfByte, int paramInt4, int paramInt5, String paramString3, Uri paramUri, List<OverflowMenuItem> paramList1, int paramInt6, ThemeSettings paramThemeSettings, List<OfflineSuggestion> paramList2, boolean paramBoolean3, ErrorReport paramErrorReport, TogglingData paramTogglingData, int paramInt7, PendingIntent paramPendingIntent)
  {
    a = paramInt1;
    b = paramString1;
    c = paramAccount;
    d = paramBundle1;
    e = paramString2;
    f = paramInt2;
    g = paramInt3;
    h = paramBoolean1;
    i = paramBoolean2;
    j = paramList;
    z = paramPendingIntent;
    k = paramBundle2;
    l = paramBitmap;
    m = paramArrayOfByte;
    n = paramInt4;
    o = paramInt5;
    p = paramString3;
    q = paramUri;
    r = paramList1;
    if (a < 4)
    {
      paramThemeSettings = new ThemeSettings();
      b = paramInt6;
    }
    for (;;)
    {
      t = paramThemeSettings;
      u = paramList2;
      v = paramBoolean3;
      w = paramErrorReport;
      if (w != null) {
        w.Y = "GoogleHelp";
      }
      x = paramTogglingData;
      y = paramInt7;
      return;
      if (paramThemeSettings == null) {
        paramThemeSettings = new ThemeSettings();
      }
    }
  }
  
  public GoogleHelp(String paramString)
  {
    this(7, paramString, null, null, null, 0, 0, true, true, new ArrayList(), null, null, null, 0, 0, null, null, new ArrayList(), 0, null, new ArrayList(), false, new ErrorReport(), null, 0, null);
  }
  
  public static Bitmap a(Activity paramActivity)
  {
    try
    {
      paramActivity = paramActivity.getWindow().getDecorView().getRootView();
      Bitmap localBitmap = Bitmap.createBitmap(paramActivity.getWidth(), paramActivity.getHeight(), Bitmap.Config.ARGB_8888);
      paramActivity.draw(new Canvas(localBitmap));
      return localBitmap;
    }
    catch (Exception paramActivity)
    {
      Log.w("GOOGLEHELP_GoogleHelp", "Get screenshot failed!", paramActivity);
    }
    return null;
  }
  
  public final GoogleHelp a(int paramInt, String paramString, Intent paramIntent)
  {
    r.add(new OverflowMenuItem(paramInt, paramString, paramIntent));
    return this;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1 = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, false);
    emj.a(paramParcel, 3, c, paramInt, false);
    emj.a(paramParcel, 4, d);
    emj.a(paramParcel, 5, h);
    emj.a(paramParcel, 6, i);
    emj.a(paramParcel, 7, j, false);
    emj.a(paramParcel, 10, k);
    emj.a(paramParcel, 11, l, paramInt, false);
    emj.a(paramParcel, 14, p, false);
    emj.a(paramParcel, 15, q, paramInt, false);
    emj.b(paramParcel, 17, s);
    emj.b(paramParcel, 16, r, false);
    emj.a(paramParcel, 19, m, false);
    emj.b(paramParcel, 18, u, false);
    emj.b(paramParcel, 21, o);
    emj.b(paramParcel, 20, n);
    emj.a(paramParcel, 23, w, paramInt, false);
    emj.a(paramParcel, 22, v);
    emj.a(paramParcel, 25, t, paramInt, false);
    emj.b(paramParcel, 29, f);
    emj.a(paramParcel, 28, e, false);
    emj.a(paramParcel, 31, x, paramInt, false);
    emj.b(paramParcel, 30, g);
    emj.b(paramParcel, 32, y);
    emj.a(paramParcel, 33, z, paramInt, false);
    emj.b(paramParcel, i1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.googlehelp.GoogleHelp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */