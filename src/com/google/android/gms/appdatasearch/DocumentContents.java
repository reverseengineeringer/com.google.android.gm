package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ebi;
import emj;

public class DocumentContents
  implements SafeParcelable
{
  public static final ebi CREATOR = new ebi();
  final int a;
  final DocumentSection[] b;
  public final String c;
  public final boolean d;
  public final Account e;
  
  public DocumentContents(int paramInt, DocumentSection[] paramArrayOfDocumentSection, String paramString, boolean paramBoolean, Account paramAccount)
  {
    a = paramInt;
    b = paramArrayOfDocumentSection;
    c = paramString;
    d = paramBoolean;
    e = paramAccount;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.a(paramParcel, 1, b, paramInt);
    emj.b(paramParcel, 1000, a);
    emj.a(paramParcel, 2, c, false);
    emj.a(paramParcel, 3, d);
    emj.a(paramParcel, 4, e, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.DocumentContents
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */