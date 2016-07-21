package com.google.android.gm.gmailify;

import android.content.ContentResolver;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.android.mail.providers.Account;
import com.google.android.gm.utils.WebViewUrl;
import cvm;
import cxa;
import dkd;
import dkh;
import dkv;
import dkw;
import dkx;
import dlh;
import dli;
import dlm;
import dln;
import dlq;
import dlr;
import dlx;
import dma;
import java.util.Stack;

public class GmailifyOptInActivity
  extends dkd
  implements dkw, dkx, dln
{
  public String c;
  public Account d;
  public WebViewUrl e;
  public String f;
  public long g;
  public boolean h;
  public String i;
  private Account j;
  
  protected final String a()
  {
    return "gmailify_setup";
  }
  
  final void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    c = paramBundle.getString("password");
    d = ((Account)paramBundle.getParcelable("gmail_account"));
    e = ((WebViewUrl)paramBundle.getParcelable("pair_accounts_url"));
  }
  
  public final void a(Account paramAccount)
  {
    String str2 = a;
    if (paramAccount == null) {}
    for (String str1 = null;; str1 = cvm.a(c))
    {
      cvm.b(str2, "Gmailify target: %s", new Object[] { str1 });
      d = paramAccount;
      return;
    }
  }
  
  public final void b(String paramString)
  {
    c = paramString;
  }
  
  public final void c()
  {
    Object localObject1 = b();
    if (localObject1 == null) {
      a(new dkh());
    }
    do
    {
      return;
      if ((localObject1 instanceof dkh))
      {
        a(new dlq());
        return;
      }
      Object localObject2;
      Object localObject3;
      if (((localObject1 instanceof dlq)) || ((localObject1 instanceof dma)))
      {
        localObject1 = d.c();
        localObject2 = new dlr();
        localObject3 = new Bundle(1);
        ((Bundle)localObject3).putParcelable("gmail-account", (Parcelable)localObject1);
        ((dkv)localObject2).setArguments((Bundle)localObject3);
        a((dkv)localObject2);
        return;
      }
      Object localObject4;
      Bundle localBundle;
      if ((localObject1 instanceof dlr))
      {
        if (e == null) {
          localObject1 = new dlm();
        }
        for (;;)
        {
          a((dkv)localObject1);
          return;
          localObject2 = e;
          localObject3 = j.c;
          localObject4 = d.c;
          localObject1 = new dli();
          localBundle = new Bundle(1);
          localBundle.putString("pairUrl", a);
          localBundle.putString("domainWhitelist", c);
          localBundle.putString("thirdPartyAddress", (String)localObject3);
          localBundle.putString("gmailAccount", (String)localObject4);
          ((dli)localObject1).setArguments(localBundle);
        }
      }
      if ((localObject1 instanceof dlm))
      {
        localObject1 = d.c;
        localObject2 = f;
        long l = g;
        localObject3 = new dlh();
        localObject4 = new Bundle(3);
        ((Bundle)localObject4).putString("gmail-address", (String)localObject1);
        ((Bundle)localObject4).putString("token", (String)localObject2);
        ((Bundle)localObject4).putLong("tokenTime", l);
        ((dlh)localObject3).setArguments((Bundle)localObject4);
        a((dkv)localObject3);
        return;
      }
      if (((localObject1 instanceof dlh)) || ((localObject1 instanceof dli)))
      {
        cvm.c(a, "Gmailify: accounts successfully paired", new Object[0]);
        localObject2 = d.c;
        localObject3 = j.c;
        if (i != null) {}
        for (localObject1 = i;; localObject1 = j.c)
        {
          boolean bool = h;
          localObject4 = new dlx();
          localBundle = new Bundle(3);
          localBundle.putString("gmailAddress", (String)localObject2);
          localBundle.putString("thirdPartyAddress", (String)localObject3);
          localBundle.putString("pairedAddress", (String)localObject1);
          localBundle.putBoolean("isActiveGmailAccount", bool);
          ((dlx)localObject4).setArguments(localBundle);
          a((dkv)localObject4);
          b.clear();
          ContentResolver.setSyncAutomatically(d.c(), "gmail-ls", true);
          return;
        }
      }
    } while (!(localObject1 instanceof dlx));
    if (e != null) {}
    for (localObject1 = "oauth";; localObject1 = "plain")
    {
      a("finish", (String)localObject1, 0L);
      startActivity(cxa.a(d));
      finish();
      return;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    j = ((Account)getIntent().getParcelableExtra("account"));
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("password", c);
    paramBundle.putParcelable("gmail_account", d);
    paramBundle.putParcelable("pair_accounts_url", e);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.gmailify.GmailifyOptInActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */