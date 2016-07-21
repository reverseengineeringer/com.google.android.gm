package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import emj;
import ffi;
import fgf;
import fgi;
import fgj;

public class FieldOnlyFilter
  extends AbstractFilter
{
  public static final Parcelable.Creator<FieldOnlyFilter> CREATOR = new fgf();
  final MetadataBundle a;
  final int b;
  private final ffi<?> c;
  
  public FieldOnlyFilter(int paramInt, MetadataBundle paramMetadataBundle)
  {
    b = paramInt;
    a = paramMetadataBundle;
    c = fgi.a(paramMetadataBundle);
  }
  
  public final <T> T a(fgj<T> paramfgj)
  {
    return (T)paramfgj.a(c);
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
 * Qualified Name:     com.google.android.gms.drive.query.internal.FieldOnlyFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */