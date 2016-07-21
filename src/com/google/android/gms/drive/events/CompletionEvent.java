package com.google.android.gms.drive.events;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import emj;
import eow;
import fbj;
import fcl;
import fcn;
import ffg;
import ffi;
import fnw;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class CompletionEvent
  implements SafeParcelable, ResourceEvent
{
  public static final Parcelable.Creator<CompletionEvent> CREATOR = new fbj();
  final int a;
  public final DriveId b;
  final String c;
  final ParcelFileDescriptor d;
  final ParcelFileDescriptor e;
  public final MetadataBundle f;
  final List<String> g;
  final int h;
  final IBinder i;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;
  
  public CompletionEvent(int paramInt1, DriveId paramDriveId, String paramString, ParcelFileDescriptor paramParcelFileDescriptor1, ParcelFileDescriptor paramParcelFileDescriptor2, MetadataBundle paramMetadataBundle, List<String> paramList, int paramInt2, IBinder paramIBinder)
  {
    a = paramInt1;
    b = paramDriveId;
    c = paramString;
    d = paramParcelFileDescriptor1;
    e = paramParcelFileDescriptor2;
    f = paramMetadataBundle;
    g = paramList;
    h = paramInt2;
    i = paramIBinder;
  }
  
  public final int a()
  {
    return 2;
  }
  
  public final List<String> b()
  {
    d();
    return new ArrayList(g);
  }
  
  public final void c()
  {
    d();
    l = true;
    eow.a(d);
    eow.a(e);
    Object localObject1;
    Object localObject3;
    if (f != null)
    {
      localObject1 = f;
      localObject3 = fnw.F;
      if (b.containsKey(((ffi)localObject3).a()))
      {
        localObject1 = (BitmapTeleporter)f.a(fnw.F);
        if (d) {}
      }
    }
    try
    {
      b.close();
      if (i == null)
      {
        ffg.c("CompletionEvent", "No callback on " + "dismiss");
        return;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.w("BitmapTeleporter", "Could not close PFD", localIOException);
      }
    }
    for (;;)
    {
      try
      {
        IBinder localIBinder = i;
        if (localIBinder == null)
        {
          localIBinder = null;
          localIBinder.a(false);
          return;
        }
      }
      catch (RemoteException localRemoteException)
      {
        ffg.c("CompletionEvent", "RemoteException on " + "dismiss: " + localRemoteException);
        return;
      }
      localObject3 = localRemoteException.queryLocalInterface("com.google.android.gms.drive.internal.IEventReleaseCallback");
      Object localObject2;
      if ((localObject3 != null) && ((localObject3 instanceof fcl))) {
        localObject2 = (fcl)localObject3;
      } else {
        localObject2 = new fcn((IBinder)localObject2);
      }
    }
  }
  
  public final void d()
  {
    if (l) {
      throw new IllegalStateException("Event has already been dismissed or snoozed.");
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    if (g == null) {}
    for (String str = "<null>";; str = "'" + TextUtils.join("','", g) + "'") {
      return String.format(Locale.US, "CompletionEvent [id=%s, status=%s, trackingTag=%s]", new Object[] { b, Integer.valueOf(h), str });
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt |= 0x1;
    int m = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, paramInt, false);
    emj.a(paramParcel, 3, c, false);
    emj.a(paramParcel, 4, d, paramInt, false);
    emj.a(paramParcel, 5, e, paramInt, false);
    emj.a(paramParcel, 6, f, paramInt, false);
    emj.a(paramParcel, 7, g, false);
    emj.b(paramParcel, 8, h);
    emj.a(paramParcel, 9, i);
    emj.b(paramParcel, m);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.events.CompletionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */