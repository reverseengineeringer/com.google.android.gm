package com.google.android.gms.drive.metadata.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import enx;
import enz;
import ffg;
import ffi;
import ffo;
import ffr;
import fnw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class MetadataBundle
  implements SafeParcelable
{
  public static final Parcelable.Creator<MetadataBundle> CREATOR = new ffr();
  final int a;
  public final Bundle b;
  
  public MetadataBundle(int paramInt, Bundle paramBundle)
  {
    a = paramInt;
    b = ((Bundle)enz.a(paramBundle));
    b.setClassLoader(getClass().getClassLoader());
    paramBundle = new ArrayList();
    Object localObject = b.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (ffo.a(str) == null)
      {
        paramBundle.add(str);
        ffg.b("MetadataBundle", "Ignored unknown metadata field in bundle: " + str);
      }
    }
    paramBundle = paramBundle.iterator();
    while (paramBundle.hasNext())
    {
      localObject = (String)paramBundle.next();
      b.remove((String)localObject);
    }
  }
  
  public MetadataBundle(Bundle paramBundle)
  {
    this(1, paramBundle);
  }
  
  public static MetadataBundle a()
  {
    return new MetadataBundle(new Bundle());
  }
  
  public final <T> T a(ffi<T> paramffi)
  {
    return (T)paramffi.a(b);
  }
  
  public final void a(Context paramContext)
  {
    BitmapTeleporter localBitmapTeleporter = (BitmapTeleporter)a(fnw.F);
    if (localBitmapTeleporter != null) {
      localBitmapTeleporter.a(paramContext.getCacheDir());
    }
  }
  
  public final <T> void a(ffi<T> paramffi, T paramT)
  {
    if (ffo.a(paramffi.a()) == null) {
      throw new IllegalArgumentException("Unregistered field: " + paramffi.a());
    }
    paramffi.a(paramT, b);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof MetadataBundle)) {
      return false;
    }
    paramObject = (MetadataBundle)paramObject;
    Object localObject = b.keySet();
    if (!((Set)localObject).equals(b.keySet())) {
      return false;
    }
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!enx.a(b.get(str), b.get(str))) {
        return false;
      }
    }
    return true;
  }
  
  public final int hashCode()
  {
    Iterator localIterator = b.keySet().iterator();
    String str;
    for (int i = 1; localIterator.hasNext(); i = b.get(str).hashCode() + i * 31) {
      str = (String)localIterator.next();
    }
    return i;
  }
  
  public final String toString()
  {
    return "MetadataBundle [values=" + b + "]";
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.metadata.internal.MetadataBundle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */