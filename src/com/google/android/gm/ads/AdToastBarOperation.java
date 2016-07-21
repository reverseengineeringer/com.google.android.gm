package com.google.android.gm.ads;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;
import com.android.mail.providers.Account;
import com.android.mail.ui.toastbar.ToastBarOperation;
import com.google.android.gm.provider.Advertisement;
import dfy;
import dge;
import dhk;
import dhl;
import dhm;

public class AdToastBarOperation
  extends ToastBarOperation
{
  public static final Parcelable.ClassLoaderCreator<ToastBarOperation> CREATOR = new dhk();
  public final Advertisement a;
  public final Account f;
  public Context g;
  private final Runnable h = new dhl(this);
  private final Runnable i = new dhm(this);
  
  public AdToastBarOperation(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    a = ((Advertisement)paramParcel.readParcelable(paramClassLoader));
    f = ((Account)paramParcel.readParcelable(paramClassLoader));
  }
  
  public AdToastBarOperation(Advertisement paramAdvertisement, Account paramAccount)
  {
    super(1, dfy.at, 1);
    a = paramAdvertisement;
    f = paramAccount;
  }
  
  public final void a(Context paramContext)
  {
    g = paramContext;
    AsyncTask.execute(h);
  }
  
  public final void b(Context paramContext)
  {
    g = paramContext;
    AsyncTask.execute(i);
  }
  
  public final boolean b()
  {
    return true;
  }
  
  public final String c(Context paramContext)
  {
    return paramContext.getString(dge.W);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(a, 0);
    paramParcel.writeParcelable(f, 0);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.ads.AdToastBarOperation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */