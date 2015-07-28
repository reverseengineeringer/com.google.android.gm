package com.google.android.gm.persistence;

import android.content.Context;
import java.util.Iterator;
import java.util.List;

class Persistence$DefaultReplyAllMigrator
  extends Persistence.AccountToGlobalPreferenceMigrator<Boolean>
{
  Persistence$DefaultReplyAllMigrator(Persistence paramPersistence)
  {
    super(paramPersistence, null);
  }
  
  Boolean migrateFromMultipleAccounts(Context paramContext, List<String> paramList)
  {
    boolean bool = true;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      bool &= Persistence.access$100(this$0, paramContext, str, "action-strip-action-reply-all", false);
    }
    return Boolean.valueOf(bool);
  }
  
  Boolean migrateFromSingleAccount(Context paramContext, String paramString)
  {
    return Boolean.valueOf(Persistence.access$100(this$0, paramContext, paramString, "action-strip-action-reply-all", false));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.persistence.Persistence.DefaultReplyAllMigrator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */