package com.google.android.gms.auth.firstparty.dataservice;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import efh;
import emj;

public class PostSignInData
  implements SafeParcelable
{
  public static final efh CREATOR = new efh();
  final int a;
  public final Intent b;
  public final PendingIntent c;
  
  public PostSignInData(int paramInt, Intent paramIntent, PendingIntent paramPendingIntent)
  {
    a = paramInt;
    b = paramIntent;
    c = paramPendingIntent;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, paramInt, false);
    emj.a(paramParcel, 3, c, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.dataservice.PostSignInData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */