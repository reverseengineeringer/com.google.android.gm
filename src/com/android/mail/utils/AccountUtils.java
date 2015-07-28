package com.android.mail.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import com.android.mail.providers.MailAppProvider;
import com.android.mail.providers.UIProvider;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AccountUtils
{
  public static com.android.mail.providers.Account[] getAccounts(Context paramContext)
  {
    Object localObject1 = paramContext.getContentResolver();
    paramContext = null;
    ArrayList localArrayList = Lists.newArrayList();
    try
    {
      localObject1 = ((ContentResolver)localObject1).query(MailAppProvider.getAccountsUri(), UIProvider.ACCOUNTS_PROJECTION, null, null, null);
      if (localObject1 != null) {
        for (;;)
        {
          paramContext = (Context)localObject1;
          if (!((Cursor)localObject1).moveToNext()) {
            break;
          }
          paramContext = (Context)localObject1;
          localArrayList.add(new com.android.mail.providers.Account((Cursor)localObject1));
        }
      }
      if (localObject2 == null) {
        break label83;
      }
    }
    finally
    {
      if (paramContext != null) {
        paramContext.close();
      }
    }
    ((Cursor)localObject2).close();
    label83:
    return (com.android.mail.providers.Account[])localArrayList.toArray(new com.android.mail.providers.Account[localArrayList.size()]);
  }
  
  public static com.android.mail.providers.Account[] getSyncingAccounts(Context paramContext)
  {
    Object localObject1 = paramContext.getContentResolver();
    paramContext = null;
    ArrayList localArrayList = Lists.newArrayList();
    try
    {
      localObject1 = ((ContentResolver)localObject1).query(MailAppProvider.getAccountsUri(), UIProvider.ACCOUNTS_PROJECTION, null, null, null);
      if (localObject1 != null) {
        for (;;)
        {
          paramContext = (Context)localObject1;
          if (!((Cursor)localObject1).moveToNext()) {
            break;
          }
          paramContext = (Context)localObject1;
          com.android.mail.providers.Account localAccount = new com.android.mail.providers.Account((Cursor)localObject1);
          paramContext = (Context)localObject1;
          if (!localAccount.isAccountSyncRequired())
          {
            paramContext = (Context)localObject1;
            localArrayList.add(localAccount);
          }
        }
      }
      if (localObject2 == null) {
        break label96;
      }
    }
    finally
    {
      if (paramContext != null) {
        paramContext.close();
      }
    }
    ((Cursor)localObject2).close();
    label96:
    return (com.android.mail.providers.Account[])localArrayList.toArray(new com.android.mail.providers.Account[localArrayList.size()]);
  }
  
  public static List<com.android.mail.providers.Account> mergeAccountLists(List<com.android.mail.providers.Account> paramList, com.android.mail.providers.Account[] paramArrayOfAccount, boolean paramBoolean)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList2.add(nextname);
      }
    }
    int i = 0;
    while (i < paramArrayOfAccount.length)
    {
      paramList = name;
      if ((paramBoolean) || ((localArrayList2 != null) && (localArrayList2.contains(paramList)))) {
        localArrayList1.add(paramArrayOfAccount[i]);
      }
      i += 1;
    }
    return localArrayList1;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.utils.AccountUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */