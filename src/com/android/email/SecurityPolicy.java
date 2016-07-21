package com.android.email;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import ayi;
import bam;
import ban;
import bbx;
import bbz;
import bdv;
import com.android.email.provider.EmailProvider;
import com.android.emailcommon.provider.Policy;
import cvm;
import cxd;

public final class SecurityPolicy
{
  private static SecurityPolicy c = null;
  public final Context a;
  public final ComponentName b;
  private DevicePolicyManager d;
  private Policy e;
  
  private SecurityPolicy(Context paramContext)
  {
    a = paramContext.getApplicationContext();
    d = null;
    b = new ComponentName(paramContext, SecurityPolicy.PolicyAdmin.class);
    e = null;
  }
  
  public static SecurityPolicy a(Context paramContext)
  {
    try
    {
      if (c == null) {
        c = new SecurityPolicy(paramContext.getApplicationContext());
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  public static void a(Context paramContext, com.android.emailcommon.provider.Account paramAccount)
  {
    paramContext = bam.e(paramContext, paramAccount.f(paramContext));
    paramContext = new android.accounts.Account(d, c);
    Bundle localBundle = new Bundle(3);
    localBundle.putBoolean("force", true);
    localBundle.putBoolean("do_not_retry", true);
    localBundle.putBoolean("expedited", true);
    ContentResolver.requestSync(paramContext, bdv.F, localBundle);
    cvm.c("Email", "requestSync SecurityPolicy syncAccount %s, %s", new Object[] { paramAccount.toString(), localBundle.toString() });
  }
  
  public static void a(Context paramContext, com.android.emailcommon.provider.Account paramAccount, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (j |= 0x20;; j &= 0xFFFFFFDF)
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("flags", Integer.valueOf(j));
      paramAccount.a(paramContext, localContentValues);
      return;
    }
  }
  
  public static boolean b(Context paramContext)
  {
    Cursor localCursor = paramContext.getContentResolver().query(Policy.a, Policy.B, "passwordExpirationDays>0", null, null);
    if (localCursor == null) {
      return false;
    }
    for (;;)
    {
      try
      {
        if (localCursor.moveToNext())
        {
          long l = Policy.b(paramContext, localCursor.getLong(0));
          if (l < 0L) {
            continue;
          }
          Object localObject = com.android.emailcommon.provider.Account.a(paramContext, l);
          if (localObject == null) {
            continue;
          }
          a(paramContext, (com.android.emailcommon.provider.Account)localObject, true);
          localObject = EmailProvider.a("uiaccountdata", l);
          paramContext.getContentResolver().delete((Uri)localObject, null, null);
          bool = true;
          continue;
        }
        return bool;
      }
      finally
      {
        localCursor.close();
      }
      boolean bool = false;
    }
  }
  
  private final Policy f()
  {
    Policy localPolicy1 = new Policy();
    c = Integer.MIN_VALUE;
    b = Integer.MIN_VALUE;
    d = Integer.MAX_VALUE;
    f = Integer.MIN_VALUE;
    e = Integer.MAX_VALUE;
    g = Integer.MIN_VALUE;
    h = Integer.MAX_VALUE;
    i = false;
    j = false;
    k = false;
    Object localObject2 = a.getContentResolver().query(Policy.a, Policy.x, null, null, null);
    Policy localPolicy2 = new Policy();
    int i = 0;
    try
    {
      while (((Cursor)localObject2).moveToNext())
      {
        localPolicy2.a((Cursor)localObject2);
        String str = String.valueOf(localPolicy2);
        cvm.a("Email", String.valueOf(str).length() + 16 + "Aggregate from: " + str, new Object[0]);
        c = Math.max(c, c);
        b = Math.max(b, b);
        if (d > 0) {
          d = Math.min(d, d);
        }
        if (h > 0) {
          h = Math.min(h, h);
        }
        if (f > 0) {
          f = Math.max(f, f);
        }
        if (e > 0) {
          e = Math.min(e, e);
        }
        if (g > 0) {
          g = Math.max(g, g);
        }
        i |= i;
        j |= j;
        m |= m;
        i = 1;
      }
      ((Cursor)localObject2).close();
      if (i != 0)
      {
        if (c == Integer.MIN_VALUE) {
          c = 0;
        }
        if (b == Integer.MIN_VALUE) {
          b = 0;
        }
        if (d == Integer.MAX_VALUE) {
          d = 0;
        }
        if (h == Integer.MAX_VALUE) {
          h = 0;
        }
        if (f == Integer.MIN_VALUE) {
          f = 0;
        }
        if (e == Integer.MAX_VALUE) {
          e = 0;
        }
        if (g == Integer.MIN_VALUE) {
          g = 0;
        }
        localObject2 = String.valueOf(localPolicy1);
        cvm.b("Email", String.valueOf(localObject2).length() + 22 + "Calculated Aggregate: " + (String)localObject2, new Object[0]);
        return localPolicy1;
      }
    }
    finally
    {
      ((Cursor)localObject2).close();
    }
    cvm.b("Email", "Calculated Aggregate: no policy", new Object[0]);
    return Policy.y;
  }
  
  private final Policy g()
  {
    try
    {
      if (e == null) {
        e = f();
      }
      Policy localPolicy = e;
      return localPolicy;
    }
    finally {}
  }
  
  public final DevicePolicyManager a()
  {
    try
    {
      if (d == null) {
        d = ((DevicePolicyManager)a.getSystemService("device_policy"));
      }
      DevicePolicyManager localDevicePolicyManager = d;
      return localDevicePolicyManager;
    }
    finally {}
  }
  
  public final void a(com.android.emailcommon.provider.Account paramAccount)
  {
    a(a, paramAccount);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      Context localContext1 = a;
      ContentResolver localContentResolver = localContext1.getContentResolver();
      Cursor localCursor = localContentResolver.query(com.android.emailcommon.provider.Account.a, bdv.B, "policyKey IS NOT NULL AND policyKey!=0", null, null);
      try
      {
        int i = localCursor.getCount();
        cvm.d("Email", 70 + "Email administration disabled; deleting " + i + " secured account(s)", new Object[0]);
        while (localCursor.moveToNext()) {
          localContentResolver.delete(EmailProvider.a("uiaccount", localCursor.getLong(0)), null, null);
        }
      }
      finally
      {
        localCursor.close();
      }
      b();
      ayi.a(localContext2);
    }
  }
  
  public final boolean a(Policy paramPolicy)
  {
    boolean bool = false;
    int i = b(paramPolicy);
    if ((i != 0) && (cvm.a("Email", 3)))
    {
      paramPolicy = String.valueOf(paramPolicy);
      paramPolicy = new StringBuilder(String.valueOf(paramPolicy).length() + 15 + "isActive for " + paramPolicy + ": ");
      paramPolicy.append("FALSE -> ");
      if ((i & 0x1) != 0) {
        paramPolicy.append("no_admin ");
      }
      if ((i & 0x2) != 0) {
        paramPolicy.append("config ");
      }
      if ((i & 0x4) != 0) {
        paramPolicy.append("password ");
      }
      if ((i & 0x8) != 0) {
        paramPolicy.append("encryption ");
      }
      if ((i & 0x10) != 0) {
        paramPolicy.append("protocol ");
      }
      cvm.b("Email", paramPolicy.toString(), new Object[0]);
    }
    if (i == 0) {
      bool = true;
    }
    return bool;
  }
  
  public final int b(Policy paramPolicy)
  {
    int m = 0;
    Policy localPolicy = paramPolicy;
    if (paramPolicy == null) {
      localPolicy = g();
    }
    if (localPolicy == Policy.y) {
      return 0;
    }
    paramPolicy = a();
    if (e()) {
      if ((c <= 0) || (paramPolicy.getPasswordMinimumLength(b) >= c)) {
        break label390;
      }
    }
    label383:
    label390:
    for (int j = 4;; j = 0)
    {
      int i = j;
      if (b > 0)
      {
        if (paramPolicy.getPasswordQuality(b) < localPolicy.f()) {
          j = 4;
        }
        i = j;
        if (!paramPolicy.isActivePasswordSufficient()) {
          i = j | 0x4;
        }
      }
      j = i;
      if (h > 0)
      {
        j = i;
        if (paramPolicy.getMaximumTimeToLock(b) > h * 1000) {
          j = i | 0x2;
        }
      }
      i = j;
      int k;
      if (e > 0)
      {
        long l = paramPolicy.getPasswordExpirationTimeout(b);
        if (l != 0L)
        {
          k = j;
          if (l <= localPolicy.j()) {}
        }
        else
        {
          k = j | 0x4;
        }
        if (paramPolicy.getPasswordExpiration(b) - System.currentTimeMillis() >= 0L) {
          break label383;
        }
      }
      for (j = 1;; j = 0)
      {
        i = k;
        if (j != 0) {
          i = k | 0x4;
        }
        j = i;
        if (f > 0)
        {
          j = i;
          if (paramPolicy.getPasswordHistoryLength(b) < f) {
            j = i | 0x2;
          }
        }
        i = j;
        if (g > 0)
        {
          i = j;
          if (paramPolicy.getPasswordMinimumNonLetter(b) < g) {
            i = j | 0x4;
          }
        }
        j = i;
        if (j)
        {
          j = i;
          if (cxd.e())
          {
            j = a().getStorageEncryptionStatus();
            if (j != 3)
            {
              k = m;
              if (j != 4) {}
            }
            else
            {
              k = 1;
            }
            j = i;
            if (k == 0) {
              j = i | 0x8;
            }
          }
        }
        i = j;
        if (m)
        {
          i = j;
          if (!paramPolicy.getCameraDisabled(b)) {
            i = j | 0x2;
          }
        }
        j = i;
        if (w != null) {
          j = i | 0x10;
        }
        return j;
      }
      return 1;
    }
  }
  
  public final void b()
  {
    try
    {
      e = null;
      c();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void c()
  {
    DevicePolicyManager localDevicePolicyManager = a();
    Policy localPolicy = g();
    if (localPolicy == Policy.y)
    {
      cvm.b("Email", "setActivePolicies: none, remove admin", new Object[0]);
      localDevicePolicyManager.removeActiveAdmin(b);
    }
    while (!e()) {
      return;
    }
    String str = String.valueOf(localPolicy);
    cvm.b("Email", String.valueOf(str).length() + 19 + "setActivePolicies: " + str, new Object[0]);
    int i = localPolicy.f();
    localDevicePolicyManager.setPasswordQuality(b, i);
    if (i != 0) {
      i = localDevicePolicyManager.getKeyguardDisabledFeatures(b);
    }
    try
    {
      localDevicePolicyManager.setKeyguardDisabledFeatures(b, i | 0x10);
      localDevicePolicyManager.setPasswordMinimumLength(b, c);
      localDevicePolicyManager.setMaximumTimeToLock(b, h * 1000);
      localDevicePolicyManager.setMaximumFailedPasswordsForWipe(b, d);
      localDevicePolicyManager.setPasswordExpirationTimeout(b, localPolicy.j());
      localDevicePolicyManager.setPasswordHistoryLength(b, f);
      localDevicePolicyManager.setPasswordMinimumSymbols(b, 0);
      localDevicePolicyManager.setPasswordMinimumNumeric(b, 0);
      localDevicePolicyManager.setPasswordMinimumNonLetter(b, g);
    }
    catch (SecurityException localSecurityException1)
    {
      try
      {
        localDevicePolicyManager.setCameraDisabled(b, m);
        localDevicePolicyManager.setStorageEncryption(b, j);
        return;
        localSecurityException1 = localSecurityException1;
        cvm.b("Email", "SecurityException in setKeyguardDisabledFeatures, nothing changed", new Object[0]);
      }
      catch (SecurityException localSecurityException2)
      {
        for (;;)
        {
          cvm.b("Email", "SecurityException in setCameraDisabled, nothing changed", new Object[0]);
        }
      }
    }
  }
  
  public final void d()
  {
    bbz.a(a).e();
  }
  
  public final boolean e()
  {
    DevicePolicyManager localDevicePolicyManager = a();
    return (localDevicePolicyManager.isAdminActive(b)) && (localDevicePolicyManager.hasGrantedPolicy(b, 6)) && (localDevicePolicyManager.hasGrantedPolicy(b, 9)) && (localDevicePolicyManager.hasGrantedPolicy(b, 7)) && (localDevicePolicyManager.hasGrantedPolicy(b, 8));
  }
}

/* Location:
 * Qualified Name:     com.android.email.SecurityPolicy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */