package com.google.android.gms.auth.firstparty.shared;

import android.graphics.Bitmap;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import egg;
import emj;

public class CaptchaChallenge
  implements SafeParcelable
{
  public static final egg CREATOR = new egg();
  final int a;
  String b;
  String c;
  Bitmap d;
  
  public CaptchaChallenge(int paramInt, String paramString1, String paramString2, Bitmap paramBitmap)
  {
    a = paramInt;
    b = paramString1;
    c = paramString2;
    d = paramBitmap;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, false);
    emj.a(paramParcel, 3, c, false);
    emj.a(paramParcel, 4, d, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.shared.CaptchaChallenge
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */