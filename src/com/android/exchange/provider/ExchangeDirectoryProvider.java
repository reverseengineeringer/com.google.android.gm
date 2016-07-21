package com.android.exchange.provider;

import android.accounts.AccountManager;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Binder;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import bdl;
import bdv;
import bhn;
import bnq;
import bnu;
import brd;
import brf;
import brg;
import brh;
import bri;
import brj;
import brl;
import brm;
import brn;
import brw;
import bta;
import cuh;
import cvm;
import cxd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class ExchangeDirectoryProvider
  extends ContentProvider
{
  final HashMap<String, Long> a = new HashMap();
  private final UriMatcher b = new UriMatcher(-1);
  private bta c;
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException();
  }
  
  public String getType(Uri paramUri)
  {
    switch (b.match(paramUri))
    {
    default: 
      return null;
    }
    return "vnd.android.cursor.item/contact";
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean onCreate()
  {
    bdv.i(getContext());
    bnq.a(getContext());
    c = new bta(getContext());
    b.addURI(bnq.d, "directories", 0);
    b.addURI(bnq.d, "contacts/filter/*", 1);
    b.addURI(bnq.d, "contacts/lookup/*/entities", 2);
    b.addURI(bnq.d, "contacts/lookup/*/#/entities", 3);
    b.addURI(bnq.d, "data/emails/filter/*", 4);
    b.addURI(bnq.d, "data/phones/filter/*", 5);
    b.addURI(bnq.d, "phone_lookup/*", 6);
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    cvm.b("Exchange", "ExchangeDirectoryProvider: query: %s", new Object[] { paramUri.toString() });
    int m = b.match(paramUri);
    paramString1 = bnq.c;
    int j;
    int k;
    String str;
    int i;
    label212:
    Object localObject;
    label651:
    label699:
    label710:
    long l1;
    switch (m)
    {
    default: 
      return null;
    case 0: 
      paramUri = AccountManager.get(getContext()).getAccountsByType(paramString1);
      paramString1 = new MatrixCursor(paramArrayOfString1);
      if (paramUri != null)
      {
        m = paramUri.length;
        j = 0;
        while (j < m)
        {
          paramArrayOfString2 = paramUri[j];
          paramString2 = new Object[paramArrayOfString1.length];
          k = 0;
          if (k < paramArrayOfString1.length)
          {
            str = paramArrayOfString1[k];
            i = -1;
            switch (str.hashCode())
            {
            default: 
              switch (i)
              {
              }
              break;
            }
            for (;;)
            {
              k += 1;
              break;
              if (!str.equals("accountName")) {
                break label212;
              }
              i = 0;
              break label212;
              if (!str.equals("accountType")) {
                break label212;
              }
              i = 1;
              break label212;
              if (!str.equals("typeResourceId")) {
                break label212;
              }
              i = 2;
              break label212;
              if (!str.equals("displayName")) {
                break label212;
              }
              i = 3;
              break label212;
              if (!str.equals("exportSupport")) {
                break label212;
              }
              i = 4;
              break label212;
              if (!str.equals("shortcutSupport")) {
                break label212;
              }
              i = 5;
              break label212;
              paramString2[k] = name;
              continue;
              paramString2[k] = type;
              continue;
              paramString2[k] = Integer.valueOf(bnu.g);
              continue;
              str = name;
              i = str.indexOf('@');
              if ((i != -1) && (i < str.length() - 2))
              {
                char c1 = Character.toUpperCase(str.charAt(i + 1));
                str = String.valueOf(str.substring(i + 2));
                paramString2[k] = (String.valueOf(str).length() + 1 + c1 + str);
              }
              else
              {
                paramString2[k] = name;
                continue;
                paramString2[k] = Integer.valueOf(1);
                continue;
                paramString2[k] = Integer.valueOf(0);
              }
            }
          }
          paramString1.addRow(paramString2);
          j += 1;
        }
      }
      return paramString1;
    case 1: 
    case 4: 
    case 5: 
    case 6: 
      str = paramUri.getLastPathSegment();
      if (m == 6)
      {
        localObject = c;
        if (cxd.d())
        {
          paramString1 = null;
          if (a.getPhoneType() == 1)
          {
            i = 1;
            if (i != 0) {
              paramString1 = a.getNetworkCountryIso();
            }
            paramArrayOfString2 = paramString1;
            if (TextUtils.isEmpty(paramString1)) {
              paramArrayOfString2 = a.getSimCountryIso();
            }
            paramString1 = paramArrayOfString2;
            if (TextUtils.isEmpty(paramArrayOfString2))
            {
              paramString1 = Locale.getDefault();
              if (paramString1 == null) {
                break label699;
              }
              paramString1 = paramString1.getCountry();
            }
            paramArrayOfString2 = paramString1;
            if (TextUtils.isEmpty(paramString1)) {
              paramArrayOfString2 = "US";
            }
          }
        }
        for (paramString1 = PhoneNumberUtils.formatNumberToE164(str, paramArrayOfString2.toUpperCase(Locale.US));; paramString1 = str)
        {
          if ((paramString1 != null) && (paramString1.length() >= 2)) {
            break label710;
          }
          return null;
          i = 0;
          break;
          paramString1 = null;
          break label651;
        }
        str = paramUri.getQueryParameter("account_name");
        if (str == null) {
          return null;
        }
        paramUri = paramUri.getQueryParameter("limit");
        i = 20;
        if (paramUri != null) {
          try
          {
            j = Integer.parseInt(paramUri);
            i = j;
            if (j <= 0)
            {
              paramUri = String.valueOf(paramUri);
              if (paramUri.length() != 0)
              {
                paramUri = "Limit not valid: ".concat(paramUri);
                throw new IllegalArgumentException(paramUri);
              }
            }
          }
          catch (NumberFormatException paramArrayOfString2)
          {
            for (;;)
            {
              j = 0;
              continue;
              paramUri = new String("Limit not valid: ");
            }
          }
        }
        l1 = Binder.clearCallingIdentity();
      }
      break;
    }
    for (;;)
    {
      try
      {
        localObject = getContext();
        paramArrayOfString2 = (Long)a.get(str);
        paramUri = paramArrayOfString2;
        if (paramArrayOfString2 == null)
        {
          paramArrayOfString2 = bhn.a((Context)localObject, com.android.emailcommon.provider.Account.a, bdv.B, "emailAddress=?", new String[] { str }, null, Long.valueOf(-1L));
          paramUri = paramArrayOfString2;
          if (paramArrayOfString2.longValue() != -1L)
          {
            a.put(str, paramArrayOfString2);
            paramUri = paramArrayOfString2;
          }
        }
        long l2 = paramUri.longValue();
        if (l2 == -1L) {
          return null;
        }
        if ((m != 5) && (m != 6)) {
          break label1483;
        }
        j = i * 3;
        k = j;
        if (j > 100) {
          k = 100;
        }
        if (cuh.a())
        {
          paramArrayOfString2 = brw.a(getContext(), l2, paramString1, k);
          if ((paramArrayOfString2 == null) || (b.size() <= 0)) {
            break label1154;
          }
          switch (m)
          {
          case 2: 
          case 3: 
            throw new IllegalArgumentException("invalid argument match");
          }
        }
      }
      finally
      {
        Binder.restoreCallingIdentity(l1);
      }
      cvm.c("Exchange", "ExchangeDirectoryProvider.query EasBundling=false, returning empty cursor", new Object[0]);
      paramArrayOfString2 = null;
      continue;
      paramUri = new brm();
      for (;;)
      {
        paramArrayOfString2 = brl.a(paramArrayOfString2);
        Collections.sort(paramArrayOfString2, new brd(paramString2));
        paramUri = paramUri.a(paramArrayOfString2, paramArrayOfString1, i, paramString1);
        Binder.restoreCallingIdentity(l1);
        return paramUri;
        paramUri = new brf();
        continue;
        paramUri = new brj();
        continue;
        paramUri = new brn();
      }
      label1154:
      paramUri = new MatrixCursor(paramArrayOfString1);
      Binder.restoreCallingIdentity(l1);
      return paramUri;
      paramString1 = paramUri.getQueryParameter("account_name");
      if (paramString1 == null) {
        return null;
      }
      paramArrayOfString2 = new bri(paramArrayOfString1);
      paramArrayOfString1 = new MatrixCursor(paramArrayOfString1);
      paramUri = paramUri.getPathSegments();
      paramString2 = (String)paramUri.get(2);
      if (m == 3) {}
      for (l1 = Long.parseLong((String)paramUri.get(3));; l1 = 1L)
      {
        paramString2 = new bdl(paramString2);
        paramUri = new brh(paramString2);
        str = paramString2.a("emailAddress");
        if (!TextUtils.isEmpty(str))
        {
          localObject = new brg(paramArrayOfString2, l1, paramString1, paramUri);
          ((brg)localObject).a("mimetype", "vnd.android.cursor.item/email_v2");
          ((brg)localObject).a("data2", Integer.valueOf(2));
          ((brg)localObject).a("data1", str);
          paramArrayOfString1.addRow(a);
        }
        brg.a(paramArrayOfString1, paramArrayOfString2, l1, paramString1, paramUri, 1, paramString2.a("homePhone"));
        brg.a(paramArrayOfString1, paramArrayOfString2, l1, paramString1, paramUri, 3, paramString2.a("workPhone"));
        brg.a(paramArrayOfString1, paramArrayOfString2, l1, paramString1, paramUri, 2, paramString2.a("mobilePhone"));
        str = paramString2.a("firstName");
        paramString2 = paramString2.a("lastName");
        paramString1 = new brg(paramArrayOfString2, l1, paramString1, paramUri);
        paramString1.a("mimetype", "vnd.android.cursor.item/name");
        paramString1.a("data2", str);
        paramString1.a("data3", paramString2);
        paramString1.a("data1", a);
        paramArrayOfString1.addRow(a);
        return paramArrayOfString1;
      }
      label1483:
      j = i;
      continue;
      paramString1 = str;
      break;
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.android.exchange.provider.ExchangeDirectoryProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */