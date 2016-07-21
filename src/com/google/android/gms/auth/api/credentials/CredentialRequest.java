package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import edg;
import edo;
import emj;
import enz;

public final class CredentialRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<CredentialRequest> CREATOR = new edo();
  final int a;
  final boolean b;
  final String[] c;
  final CredentialPickerConfig d;
  final CredentialPickerConfig e;
  
  public CredentialRequest(int paramInt, boolean paramBoolean, String[] paramArrayOfString, CredentialPickerConfig paramCredentialPickerConfig1, CredentialPickerConfig paramCredentialPickerConfig2)
  {
    a = paramInt;
    b = paramBoolean;
    c = ((String[])enz.a(paramArrayOfString));
    paramArrayOfString = paramCredentialPickerConfig1;
    if (paramCredentialPickerConfig1 == null) {
      paramArrayOfString = new edg().a();
    }
    d = paramArrayOfString;
    paramArrayOfString = paramCredentialPickerConfig2;
    if (paramCredentialPickerConfig2 == null) {
      paramArrayOfString = new edg().a();
    }
    e = paramArrayOfString;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.a(paramParcel, 1, b);
    emj.b(paramParcel, 1000, a);
    emj.a(paramParcel, 2, c);
    emj.a(paramParcel, 3, d, paramInt, false);
    emj.a(paramParcel, 4, e, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.CredentialRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */