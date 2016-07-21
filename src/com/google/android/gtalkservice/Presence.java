package com.google.android.gtalkservice;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import gij;
import gik;
import java.util.ArrayList;
import java.util.List;

public final class Presence
  implements Parcelable
{
  public static final Parcelable.Creator<Presence> CREATOR = new gij();
  public static final Presence a = new Presence();
  private boolean b;
  private gik c;
  private String d;
  private boolean e;
  private List<String> f;
  private List<String> g;
  private int h;
  private int i;
  private int j;
  private boolean k;
  private int l;
  
  public Presence()
  {
    this(gik.a);
  }
  
  public Presence(Parcel paramParcel)
  {
    h = paramParcel.readInt();
    i = paramParcel.readInt();
    j = paramParcel.readInt();
    if (paramParcel.readInt() != 0)
    {
      bool1 = true;
      k = bool1;
      if (paramParcel.readInt() == 0) {
        break label148;
      }
      bool1 = true;
      label53:
      b = bool1;
      c = ((gik)Enum.valueOf(gik.class, paramParcel.readString()));
      d = paramParcel.readString();
      if (paramParcel.readInt() == 0) {
        break label153;
      }
    }
    label148:
    label153:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      e = bool1;
      f = new ArrayList();
      paramParcel.readStringList(f);
      g = new ArrayList();
      paramParcel.readStringList(g);
      l = paramParcel.readInt();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label53;
    }
  }
  
  private Presence(gik paramgik)
  {
    b = false;
    c = paramgik;
    d = null;
    e = false;
    f = new ArrayList();
    g = new ArrayList();
    l = 8;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    if (!b) {
      return "UNAVAILABLE";
    }
    if (e) {
      return "INVISIBLE";
    }
    StringBuilder localStringBuilder = new StringBuilder(40);
    if (c == gik.a) {
      localStringBuilder.append("AVAILABLE(x)");
    }
    for (;;)
    {
      if ((l & 0x8) != 0) {
        localStringBuilder.append(" pmuc-v1");
      }
      if ((l & 0x1) != 0) {
        localStringBuilder.append(" voice-v1");
      }
      if ((l & 0x2) != 0) {
        localStringBuilder.append(" video-v1");
      }
      if ((l & 0x4) != 0) {
        localStringBuilder.append(" camera-v1");
      }
      return localStringBuilder.toString();
      localStringBuilder.append(c.toString());
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int m = 1;
    paramParcel.writeInt(h);
    paramParcel.writeInt(i);
    paramParcel.writeInt(j);
    if (k)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!b) {
        break label117;
      }
      paramInt = 1;
      label49:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(c.toString());
      paramParcel.writeString(d);
      if (!e) {
        break label122;
      }
    }
    label117:
    label122:
    for (paramInt = m;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeStringList(f);
      paramParcel.writeStringList(g);
      paramParcel.writeInt(l);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label49;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gtalkservice.Presence
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */