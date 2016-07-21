package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import edt;
import emj;
import enz;

public final class IdpTokenType
  implements SafeParcelable
{
  public static final Parcelable.Creator<IdpTokenType> CREATOR = new edt();
  public static final IdpTokenType a = new IdpTokenType("accessToken");
  public static final IdpTokenType b = new IdpTokenType("idToken");
  final int c;
  final String d;
  
  public IdpTokenType(int paramInt, String paramString)
  {
    c = paramInt;
    d = enz.a(paramString);
  }
  
  private IdpTokenType(String paramString)
  {
    this(1, paramString);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null) {}
    try
    {
      boolean bool3 = d.equals(d);
      bool1 = bool2;
      if (bool3) {
        bool1 = true;
      }
      return bool1;
    }
    catch (ClassCastException paramObject) {}
    return false;
  }
  
  public final int hashCode()
  {
    return d.hashCode();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, c);
    emj.a(paramParcel, 2, d, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.IdpTokenType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */