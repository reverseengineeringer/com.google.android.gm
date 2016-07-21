package com.google.android.gms.people.identity.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import enx;
import eny;
import fwo;

public final class ParcelableListOptions
  implements SafeParcelable
{
  public static final fwo CREATOR = new fwo();
  final int a;
  final boolean b;
  final boolean c;
  final String d;
  final boolean e;
  final Bundle f;
  
  public ParcelableListOptions(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    a = paramInt;
    b = paramBoolean1;
    c = paramBoolean2;
    d = paramString;
    e = paramBoolean3;
    paramString = paramBundle;
    if (paramBundle == null) {
      paramString = new Bundle();
    }
    f = paramString;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    return enx.a(this).a("useOfflineDatabase", Boolean.valueOf(b)).a("useWebData", Boolean.valueOf(c)).a("useCP2", Boolean.valueOf(e)).a("endpoint", d).toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.a(paramParcel, 1, b);
    emj.b(paramParcel, 1000, a);
    emj.a(paramParcel, 2, c);
    emj.a(paramParcel, 3, d, false);
    emj.a(paramParcel, 4, e);
    emj.a(paramParcel, 5, f);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.people.identity.internal.ParcelableListOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */