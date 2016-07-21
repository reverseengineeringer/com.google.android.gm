package com.google.android.gms.auth.api.credentials.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import edk;
import emj;

public final class DeleteRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<DeleteRequest> CREATOR = new edk();
  final int a;
  final Credential b;
  
  public DeleteRequest(int paramInt, Credential paramCredential)
  {
    a = paramInt;
    b = paramCredential;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.a(paramParcel, 1, b, paramInt, false);
    emj.b(paramParcel, 1000, a);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.internal.DeleteRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */