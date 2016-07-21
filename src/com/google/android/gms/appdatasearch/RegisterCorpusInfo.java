package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ecd;
import emj;
import java.util.List;

public class RegisterCorpusInfo
  implements SafeParcelable
{
  public static final ecd CREATOR = new ecd();
  final int a;
  public final String b;
  public final String c;
  public final Uri d;
  public final RegisterSectionInfo[] e;
  public final GlobalSearchCorpusConfig f;
  public final boolean g;
  public final Account h;
  public final RegisterCorpusIMEInfo i;
  public final String j;
  public final boolean k;
  
  public RegisterCorpusInfo(int paramInt, String paramString1, String paramString2, Uri paramUri, RegisterSectionInfo[] paramArrayOfRegisterSectionInfo, GlobalSearchCorpusConfig paramGlobalSearchCorpusConfig, boolean paramBoolean1, Account paramAccount, RegisterCorpusIMEInfo paramRegisterCorpusIMEInfo, String paramString3, boolean paramBoolean2)
  {
    a = paramInt;
    b = paramString1;
    c = paramString2;
    d = paramUri;
    e = paramArrayOfRegisterSectionInfo;
    f = paramGlobalSearchCorpusConfig;
    g = paramBoolean1;
    h = paramAccount;
    i = paramRegisterCorpusIMEInfo;
    j = paramString3;
    k = paramBoolean2;
  }
  
  public static Account a(Uri paramUri)
  {
    paramUri = paramUri.getPathSegments();
    if (paramUri.size() < 2) {
      return null;
    }
    String str = (String)paramUri.get(paramUri.size() - 2);
    return new Account(Uri.decode((String)paramUri.get(paramUri.size() - 1)), Uri.decode(str));
  }
  
  public static String a(String paramString, Account paramAccount)
  {
    paramAccount = Uri.encode(type) + "/" + Uri.encode(name);
    return paramString + "/" + paramAccount;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int m = emj.a(paramParcel, 20293);
    emj.a(paramParcel, 1, b, false);
    emj.b(paramParcel, 1000, a);
    emj.a(paramParcel, 2, c, false);
    emj.a(paramParcel, 3, d, paramInt, false);
    emj.a(paramParcel, 4, e, paramInt);
    emj.a(paramParcel, 7, f, paramInt, false);
    emj.a(paramParcel, 8, g);
    emj.a(paramParcel, 9, h, paramInt, false);
    emj.a(paramParcel, 10, i, paramInt, false);
    emj.a(paramParcel, 11, j, false);
    emj.a(paramParcel, 12, k);
    emj.b(paramParcel, m);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.RegisterCorpusInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */