package com.google.android.gm.autoactivation;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.text.TextUtils;
import aql;
import arh;
import atg;
import awr;
import bam;
import ban;
import bbn;
import bbo;
import bbt;
import bbw;
import bdi;
import com.android.email.activity.setup.SetupDataFragment;
import com.android.email.provider.EmailProvider;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.AccountDirtyFlags;
import com.android.emailcommon.provider.HostAuth;
import com.android.emailcommon.provider.Policy;
import cvl;
import cvm;
import dfx;
import dge;
import did;
import dmo;
import hbc;
import hf;
import java.io.IOException;

public class AutoActivationEasService
  extends IntentService
{
  static final String a = cvl.a;
  static int b = -1;
  static boolean c = false;
  private static Bundle e = null;
  private static String f;
  Bundle d;
  private ResultReceiver g;
  private ResultReceiver h;
  private ResultReceiver i;
  private SetupDataFragment j;
  
  public AutoActivationEasService()
  {
    super("AutoActivationEasService");
  }
  
  public AutoActivationEasService(String paramString)
  {
    super(paramString);
  }
  
  public static int a(Context paramContext, Bundle paramBundle)
  {
    int k;
    if (paramBundle != null)
    {
      localObject = bbn.b;
      int m = localObject.length;
      k = 0;
      if (k >= m) {
        break label72;
      }
      str1 = localObject[k];
      if (!TextUtils.isEmpty(paramBundle.getString(str1))) {
        break label65;
      }
      cvm.d(bbn.a, "%s in bundle is empty", new Object[] { str1 });
      k = 0;
    }
    for (;;)
    {
      if (k != 0) {
        break label107;
      }
      return -2;
      label65:
      k += 1;
      break;
      label72:
      if (!bbn.a(paramBundle.getString("email_address")))
      {
        cvm.d(bbn.a, "email address in bundle is not valid", new Object[0]);
        k = 0;
      }
      else
      {
        k = 1;
      }
    }
    label107:
    Object localObject = Account.a(paramContext);
    if (localObject == null)
    {
      cvm.d(a, "AutoActivationEasService.checkAndApplyAccountDetails, no account found with email address in app restrictions", new Object[0]);
      return -1;
    }
    paramContext = ((Account)localObject).d(paramContext);
    String str1 = paramBundle.getString("email_address");
    String str2 = paramBundle.getString("exchange_username");
    paramBundle = paramBundle.getString("exchange_host").split(":")[0];
    if (TextUtils.isEmpty(paramBundle))
    {
      cvm.d(a, "AutoActivationEasService.checkAndApplyAccountDetails, invalid host", new Object[0]);
      return -2;
    }
    if ((!hbc.a(str1, d)) || (!hbc.a(str2, f)) || (!hbc.a(paramBundle, c))) {
      return 1;
    }
    return 0;
  }
  
  private final did a(Account paramAccount, awr paramawr)
  {
    for (;;)
    {
      int k;
      try
      {
        cvm.b(bbw.a, "Begin check of incoming email settings for auto activation", new Object[0]);
        paramawr = paramawr.c();
        if (paramawr == null)
        {
          cvm.e(a, "provisionAgainstServer failed with unspecified exception", new Object[0]);
          return new did();
        }
        l = paramawr.getString("validate_protocol_version");
        k = paramawr.getInt("validate_result_code");
        String str = paramawr.getString("validate_redirect_address", null);
        if (str != null) {
          t.c = str;
        }
        if (k == 7)
        {
          j.a((Policy)paramawr.getParcelable("validate_policy_set"));
          paramAccount = null;
          if (paramAccount != null) {
            break label205;
          }
          paramAccount = bbo.a(this, new bdi(k));
          paramAccount = new did(k, paramAccount);
          return paramAccount;
        }
      }
      catch (bdi paramAccount)
      {
        paramawr = bbo.a(this, paramAccount);
        cvm.e(a, paramAccount, "provisionAgainstServer: %s", new Object[] { paramawr });
        return new did(d, paramawr);
      }
      if (k == 8)
      {
        paramAccount = bbn.a(this, getParcelable"validate_policy_set"w.split("\001"));
        continue;
      }
      else
      {
        label205:
        paramAccount = null;
      }
    }
  }
  
  public static void a(Context paramContext, Bundle paramBundle, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, AutoActivationEasService.class);
    localIntent.putExtra("appRetrictions", paramBundle);
    localIntent.putExtra("activationStatus", paramInt);
    paramContext.startService(localIntent);
  }
  
  private final void a(Intent paramIntent, int paramInt1, int paramInt2, CharSequence paramCharSequence)
  {
    paramIntent = PendingIntent.getActivity(this, 0, paramIntent, 268435456);
    paramCharSequence = new hf(this).a(dfx.E).a(getString(paramInt1)).b(getString(paramInt2)).c(paramCharSequence);
    d = paramIntent;
    paramIntent = paramCharSequence.a().b();
    ((NotificationManager)getSystemService("notification")).notify(1, paramIntent);
  }
  
  private final void a(CharSequence paramCharSequence, String paramString)
  {
    SetupDataFragment localSetupDataFragment = j;
    if (h == null) {
      h = new AutoActivationEasService.2(this);
    }
    paramString = AutoActivationSettingsActivity.a(this, localSetupDataFragment, paramString, h);
    paramString.addFlags(8388608);
    a(paramString, dge.bs, dge.bq, paramCharSequence);
  }
  
  private final boolean a(Bundle paramBundle)
  {
    j = new SetupDataFragment();
    j.i = bam.f(this, getString(arh.i));
    d = paramBundle;
    paramBundle = d.getString("email_address");
    if (bbn.a(paramBundle))
    {
      j.a(paramBundle);
      Account localAccount = j.b;
      d = paramBundle;
      c = paramBundle;
      j.a(this, j.i);
      bbn.a(this, localAccount, j);
      j |= 0x10000;
    }
    for (int k = 1; k == 0; k = 0)
    {
      cvm.d(a, "AutoActivationEasService.startActivation: Add email failed", new Object[0]);
      return false;
      cvm.e(a, "email address is invalid", new Object[0]);
    }
    if (!b(d))
    {
      cvm.d(a, "AutoActivationEasService.setupVariablesForActivation: Add other details failed", new Object[0]);
      return false;
    }
    j.e = true;
    paramBundle = d.getString("device_id");
    if (paramBundle != null) {}
    try
    {
      bbt.a(this, paramBundle);
      return true;
    }
    catch (IOException paramBundle)
    {
      for (;;)
      {
        cvm.d(a, paramBundle, "IOException when setting device identifier; ignore", new Object[0]);
      }
    }
  }
  
  private final boolean b()
  {
    Account localAccount = j.b;
    ban localban = j.a(this);
    int m = j & 0xFEFF;
    int k = m;
    if (w) {
      k = m | 0x100;
    }
    m = k;
    if (db.equals(getString(arh.ck)))
    {
      m = k;
      if (l == null) {}
    }
    try
    {
      double d1 = Double.parseDouble(l);
      m = k;
      if (d1 >= 12.0D) {
        m = k | 0x1880;
      }
      j = m;
      f = 3;
      if (j.a() != null) {
        v = j.a();
      }
      return true;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      cvm.e(a, localNumberFormatException, "Exception thrown parsing the protocol version.", new Object[0]);
    }
    return false;
  }
  
  private final boolean b(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("exchange_password");
    String str2 = paramBundle.getString("exchange_login_certificate_alias");
    String str3 = paramBundle.getString("exchange_username");
    Object localObject2 = paramBundle.getString("exchange_host");
    Object localObject1;
    int m;
    int n;
    if ((((String)localObject2).startsWith(":")) || (((String)localObject2).endsWith(":")))
    {
      k = -1;
      localObject1 = localObject2;
      m = 0;
      n = k;
      if (k == -1)
      {
        if (!paramBundle.getBoolean("exchange_ssl_required", true)) {
          break label266;
        }
        n = 443;
      }
      label86:
      if (!paramBundle.getBoolean("exchange_ssl_required", true)) {
        break label336;
      }
    }
    label266:
    label336:
    for (int k = 1;; k = 0)
    {
      int i1 = k;
      if (paramBundle.getBoolean("exchange_trust_all_certificates", false)) {
        i1 = k | 0x8;
      }
      if (m == 0)
      {
        cvm.d(a, "AutoActivationEasService.setUpServerSettings: host is not valid", new Object[0]);
        paramBundle = paramBundle.getString("email_address");
        f = getString(dge.bv, new Object[] { paramBundle });
        b = 1;
      }
      for (;;)
      {
        String[] arrayOfString;
        if ((TextUtils.isEmpty(str3)) || (TextUtils.isEmpty((CharSequence)localObject2)))
        {
          return false;
          arrayOfString = ((String)localObject2).split(":");
          switch (arrayOfString.length)
          {
          default: 
            localObject1 = localObject2;
          }
        }
        for (;;)
        {
          m = 0;
          k = -1;
          break;
          localObject1 = arrayOfString[0];
          m = 1;
          k = -1;
          break;
          localObject1 = arrayOfString[0];
          try
          {
            k = Integer.valueOf(arrayOfString[1]).intValue();
            m = 1;
          }
          catch (NumberFormatException localNumberFormatException) {}
          n = 80;
          break label86;
          paramBundle = j.b.d(this);
          localObject1 = b;
          paramBundle.a(str3, str1);
          paramBundle.a((String)localObject1, (String)localObject2, n, i1);
          h = null;
          i = str2;
          return true;
        }
        localObject2 = localObject1;
      }
    }
  }
  
  final void a()
  {
    b = -1;
    e = null;
    f = null;
    c = false;
    ((NotificationManager)getSystemService("notification")).cancel(1);
    stopSelf();
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    int n = 1;
    Object localObject1 = paramIntent.getBundleExtra("appRetrictions");
    if ((((Bundle)localObject1).containsKey("exchange_login_certificate_alias")) && (TextUtils.isEmpty(((Bundle)localObject1).getString("exchange_login_certificate_alias")))) {
      ((Bundle)localObject1).remove("exchange_login_certificate_alias");
    }
    int k = paramIntent.getIntExtra("activationStatus", 0);
    int i1;
    if ((e == null) || (localObject1 == null))
    {
      i1 = 0;
      if (i1 == 0) {
        break label404;
      }
      cvm.d(a, "AutoActivationEasService.onHandleIntent: Incoming config is the same as cached config. Update activation status", new Object[0]);
      if (k > b)
      {
        b = k;
        e = (Bundle)localObject1;
      }
    }
    for (;;)
    {
      label101:
      if ((a(this, (Bundle)localObject1) == -1) && (a((Bundle)localObject1)))
      {
        paramIntent = ((Bundle)localObject1).getString("email_address");
        localObject2 = new hf(this).a(dfx.E).a(getString(dge.bu)).b(paramIntent);
        ((hf)localObject2).a(2, true);
        localObject2 = ((hf)localObject2).b();
        ((NotificationManager)getSystemService("notification")).notify(1, (Notification)localObject2);
        cvm.d(a, "AutoActivationEasService.startActivation: Start auto activation for EAS account.", new Object[0]);
      }
      switch (b)
      {
      default: 
        cvm.e(a, "AutoActivationEasService.startActivation: Unknown activation state", new Object[0]);
        label404:
        do
        {
          return;
          boolean bool = TextUtils.equals(e.getString("email_address"), ((Bundle)localObject1).getString("email_address"));
          i1 = bool;
          if (b >= 2) {
            break;
          }
          if ((bool) && (TextUtils.equals(e.getString("exchange_host"), ((Bundle)localObject1).getString("exchange_host"))) && (TextUtils.equals(e.getString("exchange_username"), ((Bundle)localObject1).getString("exchange_username"))) && (TextUtils.equals(e.getString("device_id"), ((Bundle)localObject1).getString("device_id"))) && (e.getBoolean("exchange_ssl_required") == ((Bundle)localObject1).getBoolean("exchange_ssl_required")) && (e.getBoolean("exchange_trust_all_certificates") == ((Bundle)localObject1).getBoolean("exchange_trust_all_certificates")))
          {
            i1 = 1;
            break;
          }
          i1 = 0;
          break;
          if (k == 0)
          {
            b = k;
            e = (Bundle)localObject1;
            break label101;
          }
        } while (k <= b);
        b = k;
        e = (Bundle)localObject1;
      }
    }
    Object localObject2 = d.getString("exchange_login_certificate_alias");
    Object localObject3;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = d.getString("exchange_host");
      if (d.getBoolean("exchange_ssl_required", true)) {}
      for (k = 443;; k = 80)
      {
        localObject3 = new Intent(this, AutoActivationCertificateRequestor.class);
        ((Intent)localObject3).putExtra("CertificateRequestor.host", (String)localObject1);
        ((Intent)localObject3).putExtra("CertificateRequestor.port", k);
        ((Intent)localObject3).putExtra("CertificateRequestor.alias", (String)localObject2);
        if (i == null) {
          i = new AutoActivationEasService.3(this);
        }
        ((Intent)localObject3).putExtra("CertificateRequestor.resultReceiver", i);
        ((Intent)localObject3).addFlags(8388608);
        a((Intent)localObject3, dge.bt, dge.br, paramIntent);
        return;
      }
    }
    if (localObject1 == null) {
      cvm.d(a, "AutoActivationEasService.needManualPassword: bundle is null", new Object[0]);
    }
    for (k = 0;; k = 1)
    {
      if (k == 0) {
        break label667;
      }
      f = getString(dge.bw);
      b = 2;
      return;
      if ((!TextUtils.isEmpty(((Bundle)localObject1).getString("exchange_login_certificate_alias"))) || (!TextUtils.isEmpty(((Bundle)localObject1).getString("exchange_password")))) {
        break;
      }
    }
    label667:
    b = 3;
    localObject1 = j.b;
    for (;;)
    {
      int m;
      try
      {
        localObject2 = awr.a((Account)localObject1, this);
        localObject2 = a(j.b, (awr)localObject2);
        if (a == 7)
        {
          m = 1;
          if (b()) {
            break label838;
          }
          cvm.e(a, "Apply account options fail", new Object[0]);
          k = 0;
          if (k != 0)
          {
            if (m == 0) {
              break label938;
            }
            aql.a(this).b(j.b);
          }
          a();
          return;
        }
      }
      catch (bdi paramIntent)
      {
        cvm.d(a, "AutoActivationEasService.startActivation: Fail when getting ServiceStore", new Object[0]);
        return;
      }
      if (a != -1)
      {
        cvm.e(a, "AutoActivationEasService.provisionAgainstServer error: %d", new Object[] { Integer.valueOf(a) });
        f = b;
        b = 2;
        a(paramIntent, b);
        return;
        label838:
        if (!bbn.a(this, j.b, true, true, true, true))
        {
          cvm.b(a, "Account not created", new Object[0]);
          k = 0;
        }
        else
        {
          paramIntent = j.b;
          if (c)
          {
            localObject2 = paramIntent.e(this);
            localObject3 = new ContentValues(1);
            ((ContentValues)localObject3).put("passwordDirty", Integer.valueOf(1));
            ((AccountDirtyFlags)localObject2).a(this, (ContentValues)localObject3);
          }
          paramIntent.b(this);
          k = n;
          continue;
          label938:
          paramIntent = d;
          new dmo(this).a(paramIntent, false);
          j &= 0xFFFFFFDF;
          atg.a(this, (Account)localObject1);
          EmailProvider.b(this);
          bam.b(this, t.b);
          try
          {
            bam.a(getApplicationContext(), (Account)localObject1);
          }
          catch (RemoteException paramIntent)
          {
            cvm.b(a, paramIntent, "request initial sync throws exception", new Object[0]);
          }
          continue;
          localObject1 = f;
          localObject2 = j;
          if (g == null) {
            g = new AutoActivationEasService.1(this);
          }
          localObject1 = AutoActivationSettingsActivity.a(this, (SetupDataFragment)localObject2, (String)localObject1, h);
          ((Intent)localObject1).addFlags(8388608);
          a((Intent)localObject1, dge.bp, dge.bo, paramIntent);
          return;
          a(paramIntent, f);
        }
      }
      else
      {
        m = 0;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.autoactivation.AutoActivationEasService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */