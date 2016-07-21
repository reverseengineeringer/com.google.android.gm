package com.google.android.gms.googlehelp;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import flj;

public final class OfflineSuggestion
  implements SafeParcelable
{
  public static final Parcelable.Creator<OfflineSuggestion> CREATOR = new flj();
  final int a;
  final String b;
  final String c;
  final String d;
  final String e;
  
  public OfflineSuggestion(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a = paramInt;
    b = paramString1;
    c = paramString2;
    d = paramString3;
    e = paramString4;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, false);
    emj.a(paramParcel, 3, c, false);
    emj.a(paramParcel, 4, d, false);
    emj.a(paramParcel, 5, e, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.googlehelp.OfflineSuggestion
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */