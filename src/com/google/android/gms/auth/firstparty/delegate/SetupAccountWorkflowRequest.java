package com.google.android.gms.auth.firstparty.delegate;

import android.accounts.AccountAuthenticatorResponse;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import efx;
import emj;
import enz;
import java.util.List;

public class SetupAccountWorkflowRequest
  implements SafeParcelable
{
  public static final efx CREATOR = new efx();
  public final int a;
  public boolean b;
  public boolean c;
  public List<String> d;
  public Bundle e;
  public final AppDescription f;
  public boolean g;
  public final String h;
  public AccountAuthenticatorResponse i;
  public boolean j;
  public boolean k;
  public String l;
  public String m;
  public String n;
  
  public SetupAccountWorkflowRequest(int paramInt, boolean paramBoolean1, boolean paramBoolean2, List<String> paramList, Bundle paramBundle, AppDescription paramAppDescription, boolean paramBoolean3, String paramString1, AccountAuthenticatorResponse paramAccountAuthenticatorResponse, boolean paramBoolean4, boolean paramBoolean5, String paramString2, String paramString3, String paramString4)
  {
    a = paramInt;
    b = paramBoolean1;
    c = paramBoolean2;
    d = paramList;
    e = paramBundle;
    f = ((AppDescription)enz.a(paramAppDescription));
    g = paramBoolean3;
    h = paramString1;
    i = paramAccountAuthenticatorResponse;
    j = paramBoolean4;
    k = paramBoolean5;
    l = paramString2;
    m = paramString3;
    n = paramString4;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1 = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b);
    emj.a(paramParcel, 3, c);
    emj.a(paramParcel, 4, d, false);
    emj.a(paramParcel, 5, e);
    emj.a(paramParcel, 6, f, paramInt, false);
    emj.a(paramParcel, 7, g);
    emj.a(paramParcel, 8, h, false);
    emj.a(paramParcel, 9, i, paramInt, false);
    emj.a(paramParcel, 10, j);
    emj.a(paramParcel, 11, k);
    emj.a(paramParcel, 12, l, false);
    emj.a(paramParcel, 13, m, false);
    emj.a(paramParcel, 14, n, false);
    emj.b(paramParcel, i1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.delegate.SetupAccountWorkflowRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */