package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import emj;
import ffi;
import fge;
import fgi;
import fgj;

public class ComparisonFilter<T>
  extends AbstractFilter
{
  public static final fge CREATOR = new fge();
  final Operator a;
  final MetadataBundle b;
  final int c;
  final ffi<T> d;
  
  public ComparisonFilter(int paramInt, Operator paramOperator, MetadataBundle paramMetadataBundle)
  {
    c = paramInt;
    a = paramOperator;
    b = paramMetadataBundle;
    d = fgi.a(paramMetadataBundle);
  }
  
  public final <F> F a(fgj<F> paramfgj)
  {
    return (F)paramfgj.a(a, d, b.a(d));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1000, c);
    emj.a(paramParcel, 1, a, paramInt, false);
    emj.a(paramParcel, 2, b, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.query.internal.ComparisonFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */