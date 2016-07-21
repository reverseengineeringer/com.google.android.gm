package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.ProgressEvent;
import com.google.android.gms.drive.events.QueryResultEventParcelable;
import emj;
import fcz;

public class OnEventResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnEventResponse> CREATOR = new fcz();
  final int a;
  public final int b;
  public final ChangeEvent c;
  public final CompletionEvent d;
  public final QueryResultEventParcelable e;
  public final ChangesAvailableEvent f;
  public final ProgressEvent g;
  
  public OnEventResponse(int paramInt1, int paramInt2, ChangeEvent paramChangeEvent, CompletionEvent paramCompletionEvent, QueryResultEventParcelable paramQueryResultEventParcelable, ChangesAvailableEvent paramChangesAvailableEvent, ProgressEvent paramProgressEvent)
  {
    a = paramInt1;
    b = paramInt2;
    c = paramChangeEvent;
    d = paramCompletionEvent;
    e = paramQueryResultEventParcelable;
    f = paramChangesAvailableEvent;
    g = paramProgressEvent;
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
    emj.a(paramParcel, 5, d, paramInt, false);
    emj.a(paramParcel, 6, e, paramInt, false);
    emj.a(paramParcel, 7, f, paramInt, false);
    emj.a(paramParcel, 8, g, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.internal.OnEventResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */