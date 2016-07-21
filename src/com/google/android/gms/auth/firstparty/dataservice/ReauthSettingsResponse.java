package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import efj;
import emj;

public class ReauthSettingsResponse
  implements SafeParcelable
{
  public static final efj CREATOR = new efj();
  final int a;
  public final int b;
  public final PasswordSettings c;
  public final PinSettings d;
  
  public ReauthSettingsResponse(int paramInt1, int paramInt2, PasswordSettings paramPasswordSettings, PinSettings paramPinSettings)
  {
    a = paramInt1;
    b = paramInt2;
    c = paramPasswordSettings;
    d = paramPinSettings;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.b(paramParcel, 2, b);
    emj.a(paramParcel, 3, c, paramInt, false);
    emj.a(paramParcel, 4, d, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.dataservice.ReauthSettingsResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */