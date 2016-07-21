package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import edx;
import emj;
import java.util.ArrayList;

public class GoogleSignInConfig
  implements SafeParcelable
{
  public static final Parcelable.Creator<GoogleSignInConfig> CREATOR = new edx();
  final int a;
  final ArrayList<Scope> b;
  
  public GoogleSignInConfig()
  {
    this(1, new ArrayList());
  }
  
  public GoogleSignInConfig(int paramInt, ArrayList<Scope> paramArrayList)
  {
    a = paramInt;
    b = paramArrayList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.b(paramParcel, 2, new ArrayList(b), false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.GoogleSignInConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */