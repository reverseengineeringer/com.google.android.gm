package com.google.android.gms.drive.events;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.WriteAwareParcelable;
import emj;
import fbl;

public class QueryResultEventParcelable
  extends WriteAwareParcelable
  implements DriveEvent
{
  public static final fbl CREATOR = new fbl();
  final int a;
  final DataHolder b;
  final boolean c;
  final int d;
  
  public QueryResultEventParcelable(int paramInt1, DataHolder paramDataHolder, boolean paramBoolean, int paramInt2)
  {
    a = paramInt1;
    b = paramDataHolder;
    c = paramBoolean;
    d = paramInt2;
  }
  
  public final int a()
  {
    return 3;
  }
  
  public final void a(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, paramInt, false);
    emj.a(paramParcel, 3, c);
    emj.b(paramParcel, 4, d);
    emj.b(paramParcel, i);
  }
  
  public int describeContents()
  {
    return 0;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.events.QueryResultEventParcelable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */