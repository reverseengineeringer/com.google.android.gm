package com.google.android.gms.common.server;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import eon;

public class FavaDiagnosticsEntity
  implements SafeParcelable
{
  public static final eon CREATOR = new eon();
  final int a;
  public final String b;
  public final int c;
  
  public FavaDiagnosticsEntity(int paramInt1, String paramString, int paramInt2)
  {
    a = paramInt1;
    b = paramString;
    c = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, false);
    emj.b(paramParcel, 3, c);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.server.FavaDiagnosticsEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */