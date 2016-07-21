package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import edg;
import edn;
import emj;

public final class CredentialPickerConfig
  implements SafeParcelable
{
  public static final Parcelable.Creator<CredentialPickerConfig> CREATOR = new edn();
  final int a;
  final boolean b;
  final boolean c;
  
  public CredentialPickerConfig(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a = paramInt;
    b = paramBoolean1;
    c = paramBoolean2;
  }
  
  public CredentialPickerConfig(edg paramedg)
  {
    this(1, a, b);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.a(paramParcel, 1, b);
    emj.b(paramParcel, 1000, a);
    emj.a(paramParcel, 2, c);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.CredentialPickerConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */