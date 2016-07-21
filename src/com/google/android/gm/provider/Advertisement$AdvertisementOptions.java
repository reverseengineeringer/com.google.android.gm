package com.google.android.gm.provider;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import dox;
import gwi;
import gwk;

public class Advertisement$AdvertisementOptions
  implements Parcelable
{
  public static final Parcelable.ClassLoaderCreator<AdvertisementOptions> CREATOR = new dox();
  public final boolean a;
  public final boolean b;
  public final boolean c;
  public final boolean d;
  public final boolean e;
  public final boolean f;
  public final boolean g;
  
  public Advertisement$AdvertisementOptions()
  {
    a = true;
    b = false;
    c = false;
    d = false;
    e = false;
    f = false;
    g = false;
  }
  
  public Advertisement$AdvertisementOptions(Cursor paramCursor)
  {
    if (paramCursor.getInt(paramCursor.getColumnIndex("report_ad_server")) == 1)
    {
      bool1 = true;
      a = bool1;
      if (paramCursor.getInt(paramCursor.getColumnIndex("report_bow")) != 1) {
        break label187;
      }
      bool1 = true;
      label51:
      b = bool1;
      if (paramCursor.getInt(paramCursor.getColumnIndex("send_body")) != 1) {
        break label192;
      }
      bool1 = true;
      label76:
      c = bool1;
      if (paramCursor.getInt(paramCursor.getColumnIndex("show_body_feedback_survey")) != 1) {
        break label197;
      }
      bool1 = true;
      label101:
      d = bool1;
      if (paramCursor.getInt(paramCursor.getColumnIndex("report_duration_since_last_action")) != 1) {
        break label202;
      }
      bool1 = true;
      label126:
      e = bool1;
      if (paramCursor.getInt(paramCursor.getColumnIndex("report_duration_since_last_action_to_bow")) != 1) {
        break label207;
      }
      bool1 = true;
      label151:
      f = bool1;
      if (paramCursor.getInt(paramCursor.getColumnIndex("report_click_id_for_click_event")) != 1) {
        break label212;
      }
    }
    label187:
    label192:
    label197:
    label202:
    label207:
    label212:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      g = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label51;
      bool1 = false;
      break label76;
      bool1 = false;
      break label101;
      bool1 = false;
      break label126;
      bool1 = false;
      break label151;
    }
  }
  
  public Advertisement$AdvertisementOptions(Parcel paramParcel)
  {
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      a = bool1;
      if (paramParcel.readInt() != 1) {
        break label117;
      }
      bool1 = true;
      label31:
      b = bool1;
      if (paramParcel.readInt() != 1) {
        break label122;
      }
      bool1 = true;
      label46:
      c = bool1;
      if (paramParcel.readInt() != 1) {
        break label127;
      }
      bool1 = true;
      label61:
      d = bool1;
      if (paramParcel.readInt() != 1) {
        break label132;
      }
      bool1 = true;
      label76:
      e = bool1;
      if (paramParcel.readInt() != 1) {
        break label137;
      }
      bool1 = true;
      label91:
      f = bool1;
      if (paramParcel.readInt() != 1) {
        break label142;
      }
    }
    label117:
    label122:
    label127:
    label132:
    label137:
    label142:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      g = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label31;
      bool1 = false;
      break label46;
      bool1 = false;
      break label61;
      bool1 = false;
      break label76;
      bool1 = false;
      break label91;
    }
  }
  
  public Advertisement$AdvertisementOptions(gwi paramgwi)
  {
    if (u != null)
    {
      paramgwi = u;
      int i;
      if ((a & 0x1) != 0)
      {
        i = 1;
        if ((i == 0) || (!b)) {
          break label189;
        }
        bool1 = true;
        label43:
        a = bool1;
        if ((a & 0x2) == 0) {
          break label194;
        }
        i = 1;
        label59:
        if ((i == 0) || (!c)) {
          break label199;
        }
        bool1 = true;
        label72:
        b = bool1;
        if ((a & 0x4) == 0) {
          break label204;
        }
        i = 1;
        label88:
        if ((i == 0) || (!d)) {
          break label209;
        }
        bool1 = true;
        label101:
        c = bool1;
        if ((a & 0x8) == 0) {
          break label214;
        }
        i = 1;
        label118:
        if ((i == 0) || (!e)) {
          break label219;
        }
        bool1 = true;
        label131:
        d = bool1;
        if ((a & 0x40) == 0) {
          break label224;
        }
        i = 1;
        label148:
        if ((i == 0) || (!f)) {
          break label229;
        }
      }
      label189:
      label194:
      label199:
      label204:
      label209:
      label214:
      label219:
      label224:
      label229:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        e = bool1;
        f = g;
        g = h;
        return;
        i = 0;
        break;
        bool1 = false;
        break label43;
        i = 0;
        break label59;
        bool1 = false;
        break label72;
        i = 0;
        break label88;
        bool1 = false;
        break label101;
        i = 0;
        break label118;
        bool1 = false;
        break label131;
        i = 0;
        break label148;
      }
    }
    a = true;
    b = false;
    c = false;
    d = false;
    e = false;
    f = false;
    g = false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(super.toString());
    localStringBuilder.append(", reportToAdServer: ").append(a);
    localStringBuilder.append(", reportToBow: ").append(b);
    localStringBuilder.append(", sendAdBody: ").append(c);
    localStringBuilder.append(", showBodyFeedbackSurvey: ").append(d);
    localStringBuilder.append(", reportDurationSinceLastAction: ").append(e);
    localStringBuilder.append(", reportDurationSinceLastActionToBow: ").append(f);
    localStringBuilder.append(", reportClickIdForClickEvent: ").append(g);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    if (a)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!b) {
        break label106;
      }
      paramInt = 1;
      label25:
      paramParcel.writeInt(paramInt);
      if (!c) {
        break label111;
      }
      paramInt = 1;
      label39:
      paramParcel.writeInt(paramInt);
      if (!d) {
        break label116;
      }
      paramInt = 1;
      label53:
      paramParcel.writeInt(paramInt);
      if (!e) {
        break label121;
      }
      paramInt = 1;
      label67:
      paramParcel.writeInt(paramInt);
      if (!f) {
        break label126;
      }
      paramInt = 1;
      label81:
      paramParcel.writeInt(paramInt);
      if (!g) {
        break label131;
      }
    }
    label106:
    label111:
    label116:
    label121:
    label126:
    label131:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label25;
      paramInt = 0;
      break label39;
      paramInt = 0;
      break label53;
      paramInt = 0;
      break label67;
      paramInt = 0;
      break label81;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.Advertisement.AdvertisementOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */