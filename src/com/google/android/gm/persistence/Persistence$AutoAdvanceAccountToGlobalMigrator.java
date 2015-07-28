package com.google.android.gm.persistence;

import android.content.Context;
import java.util.Iterator;
import java.util.List;

class Persistence$AutoAdvanceAccountToGlobalMigrator
  extends Persistence.AccountToGlobalPreferenceMigrator<String>
{
  Persistence$AutoAdvanceAccountToGlobalMigrator(Persistence paramPersistence)
  {
    super(paramPersistence, null);
  }
  
  private int autoAdvanceSettingPriority(String paramString)
  {
    if ("newer".equals(paramString)) {
      return 3;
    }
    if ("older".equals(paramString)) {
      return 2;
    }
    if ("list".equals(paramString)) {
      return 1;
    }
    return -1;
  }
  
  public String migrateFromMultipleAccounts(Context paramContext, List<String> paramList)
  {
    String str = null;
    int i = -1;
    Iterator localIterator = paramList.iterator();
    paramList = str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      str = Persistence.access$200(this$0, paramContext, str, "auto-advance", null);
      if (str != null)
      {
        int j = autoAdvanceSettingPriority(str);
        if (j > i)
        {
          i = j;
          paramList = str;
        }
      }
    }
    return paramList;
  }
  
  public String migrateFromSingleAccount(Context paramContext, String paramString)
  {
    return Persistence.access$200(this$0, paramContext, paramString, "auto-advance", null);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.persistence.Persistence.AutoAdvanceAccountToGlobalMigrator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */