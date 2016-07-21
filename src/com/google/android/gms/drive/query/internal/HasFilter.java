package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import emj;
import ffi;
import fgi;
import fgj;
import fgl;

public class HasFilter<T>
  extends AbstractFilter
{
  public static final fgl CREATOR = new fgl();
  final MetadataBundle a;
  final int b;
  final ffi<T> c;
  
  public HasFilter(int paramInt, MetadataBundle paramMetadataBundle)
  {
    b = paramInt;
    a = paramMetadataBundle;
    c = fgi.a(paramMetadataBundle);
  }
  
  public final <F> F a(fgj<F> paramfgj)
  {
    return (F)paramfgj.a(c, a.a(c));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1000, b);
    emj.a(paramParcel, 1, a, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.query.internal.HasFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */