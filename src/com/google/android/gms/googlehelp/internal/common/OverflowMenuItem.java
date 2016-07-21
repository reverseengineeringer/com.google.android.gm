package com.google.android.gms.googlehelp.internal.common;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import fkz;

public final class OverflowMenuItem
  implements SafeParcelable
{
  public static final Parcelable.Creator<OverflowMenuItem> CREATOR = new fkz();
  final int a;
  final int b;
  final String c;
  final Intent d;
  
  public OverflowMenuItem(int paramInt1, int paramInt2, String paramString, Intent paramIntent)
  {
    a = paramInt1;
    b = paramInt2;
    c = paramString;
    d = paramIntent;
  }
  
  public OverflowMenuItem(int paramInt, String paramString, Intent paramIntent)
  {
    this(1, paramInt, paramString, paramIntent);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.b(paramParcel, 2, b);
    emj.a(paramParcel, 3, c, false);
    emj.a(paramParcel, 4, d, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.googlehelp.internal.common.OverflowMenuItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */