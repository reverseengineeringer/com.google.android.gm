package com.google.android.gms.search.global;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import fzx;

public class SetIncludeInGlobalSearchCall$Request
  implements SafeParcelable
{
  public static final fzx CREATOR = new fzx();
  public String a;
  public boolean b;
  final int c;
  
  public SetIncludeInGlobalSearchCall$Request()
  {
    c = 1;
  }
  
  public SetIncludeInGlobalSearchCall$Request(int paramInt, String paramString, boolean paramBoolean)
  {
    c = paramInt;
    a = paramString;
    b = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1000, c);
    emj.a(paramParcel, 1, a, false);
    emj.a(paramParcel, 2, b);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.search.global.SetIncludeInGlobalSearchCall.Request
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */