package com.google.android.gms.feedback;

import android.app.ApplicationErrorReport;
import android.app.ApplicationErrorReport.CrashInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import fjo;
import java.util.ArrayList;

public class FeedbackOptions
  implements SafeParcelable
{
  public static final Parcelable.Creator<FeedbackOptions> CREATOR = new fjo();
  public final int a;
  public String b;
  public Bundle c;
  public String d;
  public ApplicationErrorReport e;
  public String f;
  public BitmapTeleporter g;
  public String h;
  public ArrayList<FileTeleporter> i;
  public boolean j;
  public ThemeSettings k;
  public LogOptions l;
  
  public FeedbackOptions()
  {
    this(3, null, null, null, new ApplicationErrorReport(), null, null, null, null, true, null, null);
  }
  
  public FeedbackOptions(int paramInt, String paramString1, Bundle paramBundle, String paramString2, ApplicationErrorReport paramApplicationErrorReport, String paramString3, BitmapTeleporter paramBitmapTeleporter, String paramString4, ArrayList<FileTeleporter> paramArrayList, boolean paramBoolean, ThemeSettings paramThemeSettings, LogOptions paramLogOptions)
  {
    a = paramInt;
    b = paramString1;
    c = paramBundle;
    d = paramString2;
    e = paramApplicationErrorReport;
    f = paramString3;
    g = paramBitmapTeleporter;
    h = paramString4;
    i = paramArrayList;
    j = paramBoolean;
    k = paramThemeSettings;
    l = paramLogOptions;
  }
  
  public final ApplicationErrorReport.CrashInfo a()
  {
    if (e == null) {
      return null;
    }
    return e.crashInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int m = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, false);
    emj.a(paramParcel, 3, c);
    emj.a(paramParcel, 5, d, false);
    emj.a(paramParcel, 6, e, paramInt, false);
    emj.a(paramParcel, 7, f, false);
    emj.a(paramParcel, 8, g, paramInt, false);
    emj.a(paramParcel, 9, h, false);
    emj.b(paramParcel, 10, i, false);
    emj.a(paramParcel, 11, j);
    emj.a(paramParcel, 12, k, paramInt, false);
    emj.a(paramParcel, 13, l, paramInt, false);
    emj.b(paramParcel, m);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.feedback.FeedbackOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */