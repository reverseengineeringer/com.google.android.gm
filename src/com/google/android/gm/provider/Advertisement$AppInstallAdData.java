package com.google.android.gm.provider;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.text.TextUtils;
import doy;
import dri;
import gwi;
import gwn;
import hbw;

public class Advertisement$AppInstallAdData
  implements Parcelable
{
  public static final Parcelable.ClassLoaderCreator<AppInstallAdData> CREATOR = new doy();
  public final float a;
  public final int b;
  public final String c;
  public final boolean d;
  public final int e;
  public final int f;
  public final String g;
  public final String h;
  public final String i;
  
  private Advertisement$AppInstallAdData()
  {
    a = -1.0F;
    b = -1;
    c = "";
    d = false;
    e = 0;
    f = 0;
    g = "";
    h = "";
    i = "";
  }
  
  public Advertisement$AppInstallAdData(Cursor paramCursor)
  {
    try
    {
      str = paramCursor.getString(paramCursor.getColumnIndex("aia_star_rating"));
      if (str != null) {
        break label187;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      String str;
      boolean bool;
      for (;;) {}
    }
    a = f1;
    b = paramCursor.getInt(paramCursor.getColumnIndex("aia_ratings_count"));
    c = paramCursor.getString(paramCursor.getColumnIndex("aia_package_name"));
    if (paramCursor.getInt(paramCursor.getColumnIndex("aia_inline_install_enabled")) == 1) {}
    for (bool = true;; bool = false)
    {
      d = bool;
      e = paramCursor.getInt(paramCursor.getColumnIndex("aia_teaser_experiment"));
      f = paramCursor.getInt(paramCursor.getColumnIndex("aia_body_experiment"));
      g = paramCursor.getString(paramCursor.getColumnIndex("aia_referrer"));
      h = paramCursor.getString(paramCursor.getColumnIndex("aia_install_url"));
      i = paramCursor.getString(paramCursor.getColumnIndex("aia_install_button_url"));
      return;
      label187:
      float f2 = Float.parseFloat(str);
      f1 = f2;
      break;
    }
  }
  
  public Advertisement$AppInstallAdData(Parcel paramParcel)
  {
    a = paramParcel.readFloat();
    b = paramParcel.readInt();
    c = paramParcel.readString();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      d = bool;
      e = paramParcel.readInt();
      f = paramParcel.readInt();
      g = paramParcel.readString();
      h = paramParcel.readString();
      i = paramParcel.readString();
      return;
      bool = false;
    }
  }
  
  public Advertisement$AppInstallAdData(gwi paramgwi)
  {
    int j;
    label61:
    label70:
    label98:
    boolean bool;
    if (v != null)
    {
      paramgwi = v;
      if ((a & 0x1) != 0)
      {
        j = 1;
        if (j != 0) {
          f1 = b;
        }
        a = f1;
        if ((a & 0x2) == 0) {
          break label207;
        }
        j = 1;
        if (j == 0) {
          break label212;
        }
        j = c;
        b = j;
        c = hbw.a(d);
        if ((a & 0x8) == 0) {
          break label217;
        }
        j = 1;
        if ((j == 0) || (!e)) {
          break label222;
        }
        bool = true;
        label112:
        d = bool;
        if ((a & 0x10) == 0) {
          break label228;
        }
        j = 1;
        label130:
        if (j == 0) {
          break label233;
        }
        j = f;
        label139:
        e = j;
        if ((a & 0x20) == 0) {
          break label238;
        }
        j = m;
        label157:
        if (j != 0) {
          k = g;
        }
        f = k;
        h = hbw.a(h);
      }
    }
    for (i = hbw.a(i);; i = "")
    {
      g = "";
      return;
      j = 0;
      break;
      label207:
      j = 0;
      break label61;
      label212:
      j = -1;
      break label70;
      label217:
      j = 0;
      break label98;
      label222:
      bool = false;
      break label112;
      label228:
      j = 0;
      break label130;
      label233:
      j = 0;
      break label139;
      label238:
      j = 0;
      break label157;
      a = -1.0F;
      b = -1;
      c = "";
      d = false;
      e = 0;
      f = 0;
      h = "";
    }
  }
  
  public final boolean a()
  {
    return (a >= 0.0F) && (b > 0);
  }
  
  public final boolean b()
  {
    return !TextUtils.isEmpty(c);
  }
  
  public final int c()
  {
    switch (e)
    {
    default: 
      dri.e(Advertisement.a, "Unknown TeaserExperiment: %d.", new Object[] { Integer.valueOf(e) });
      return 1;
    }
    return e;
  }
  
  public final int d()
  {
    switch (f)
    {
    default: 
      dri.e(Advertisement.a, "Unknown BodyExperiment: %d.", new Object[] { Integer.valueOf(f) });
      return 2;
    }
    return f;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return super.toString() + "{ starRating: " + a + ", ratingsCount: " + b + ", packageName: " + c + ", isInlineInstallEnabled: " + d + ", teaserExperiment: " + e + ", bodyExperiment: " + f + ", referrer: " + g + ", installUrl: " + h + ", installButtonUrl: " + i + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeFloat(a);
    paramParcel.writeInt(b);
    paramParcel.writeString(c);
    if (d) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(e);
      paramParcel.writeInt(f);
      paramParcel.writeString(g);
      paramParcel.writeString(h);
      paramParcel.writeString(i);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.Advertisement.AppInstallAdData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */