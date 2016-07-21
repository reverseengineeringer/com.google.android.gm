package com.android.mail.ui.toastbar;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import buc;
import buh;
import buj;
import com.android.mail.providers.Folder;
import ctd;
import ctj;
import ctk;

public class ToastBarOperation
  implements Parcelable, ctd
{
  public static final Parcelable.ClassLoaderCreator<ToastBarOperation> CREATOR = new ctj();
  private final int a;
  public final int b;
  public final int c;
  long d = -1L;
  long e = -1L;
  private final Folder f;
  private final ctk g;
  
  public ToastBarOperation(int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramInt1, paramInt2, paramInt3, null, null);
  }
  
  public ToastBarOperation(int paramInt1, int paramInt2, int paramInt3, Folder paramFolder, long paramLong1, long paramLong2, ctk paramctk)
  {
    a = paramInt3;
    b = paramInt2;
    c = paramInt1;
    f = paramFolder;
    d = paramLong1;
    e = paramLong2;
    g = paramctk;
  }
  
  public ToastBarOperation(int paramInt1, int paramInt2, int paramInt3, Folder paramFolder, ctk paramctk)
  {
    this(paramInt1, paramInt2, paramInt3, paramFolder, -1L, -1L, paramctk);
  }
  
  public ToastBarOperation(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    a = paramParcel.readInt();
    b = paramParcel.readInt();
    c = paramParcel.readInt();
    f = ((Folder)paramParcel.readParcelable(paramClassLoader));
    d = paramParcel.readLong();
    e = paramParcel.readLong();
    g = null;
  }
  
  public final int a()
  {
    if (b == buc.ee) {
      return 0;
    }
    return buj.fo;
  }
  
  public void a(Context paramContext) {}
  
  public void b(Context paramContext)
  {
    if (g != null) {
      g.a();
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public String c(Context paramContext)
  {
    if (b == buc.dP) {
      return paramContext.getString(buj.bU, new Object[] { f.d });
    }
    if (b == buc.cS) {
      return paramContext.getString(buj.aG, new Object[] { f.d });
    }
    if (b == buc.dp) {
      return paramContext.getString(buj.dJ);
    }
    int i;
    if (b == buc.aV) {
      i = buh.f;
    }
    while (i == -1)
    {
      return "";
      if (b == buc.ac) {
        i = buh.g;
      } else if (b == buc.x) {
        i = buh.e;
      } else if (b == buc.ea) {
        i = buh.k;
      } else if (b == buc.cC) {
        i = buh.j;
      } else if (b == buc.cB) {
        i = buh.i;
      } else if (b == buc.cX) {
        i = buh.h;
      } else if (b == buc.dQ) {
        i = buh.m;
      } else if (b == buc.ee) {
        i = buh.l;
      } else {
        i = -1;
      }
    }
    return paramContext.getResources().getQuantityString(i, a, new Object[] { Integer.valueOf(a) });
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("{");
    localStringBuilder.append(super.toString());
    localStringBuilder.append(" mAction=");
    localStringBuilder.append(b);
    localStringBuilder.append(" mCount=");
    localStringBuilder.append(a);
    localStringBuilder.append(" mType=");
    localStringBuilder.append(c);
    localStringBuilder.append(" mFolder=");
    localStringBuilder.append(f);
    localStringBuilder.append(" mMinimumDuration=");
    localStringBuilder.append(d);
    localStringBuilder.append(" mMaximumDuration=");
    localStringBuilder.append(e);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(a);
    paramParcel.writeInt(b);
    paramParcel.writeInt(c);
    paramParcel.writeParcelable(f, 0);
    paramParcel.writeLong(d);
    paramParcel.writeLong(e);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.toastbar.ToastBarOperation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */