package com.google.android.gm.provider;

import android.accounts.Account;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Comparator;
import java.util.Map;

class MailEngine$AccountManagerOrderComparator
  implements Comparator<MailEngine>
{
  private final Map<String, Integer> mAccountOrderMap;
  
  public MailEngine$AccountManagerOrderComparator(Account[] paramArrayOfAccount)
  {
    ImmutableMap.Builder localBuilder = new ImmutableMap.Builder();
    int i = 0;
    while (i < paramArrayOfAccount.length)
    {
      localBuilder.put(name, Integer.valueOf(i));
      i += 1;
    }
    mAccountOrderMap = localBuilder.build();
  }
  
  private final int getOrder(MailEngine paramMailEngine)
  {
    if (paramMailEngine == null) {}
    do
    {
      return Integer.MAX_VALUE;
      paramMailEngine = (Integer)mAccountOrderMap.get(paramMailEngine.getAccountName());
    } while (paramMailEngine == null);
    return paramMailEngine.intValue();
  }
  
  public int compare(MailEngine paramMailEngine1, MailEngine paramMailEngine2)
  {
    return getOrder(paramMailEngine1) - getOrder(paramMailEngine2);
  }
  
  public boolean equals(Object paramObject)
  {
    return paramObject instanceof AccountManagerOrderComparator;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailEngine.AccountManagerOrderComparator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */