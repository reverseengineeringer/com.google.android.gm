package com.google.android.gm.persistence;

import android.content.Context;
import android.text.TextUtils;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Persistence$ConfirmActionsAccountToGlobalMigrator
  extends Persistence.AccountToGlobalPreferenceMigrator<String>
{
  Persistence$ConfirmActionsAccountToGlobalMigrator(Persistence paramPersistence)
  {
    super(paramPersistence, null);
  }
  
  public String migrateFromMultipleAccounts(Context paramContext, List<String> paramList)
  {
    Object localObject = null;
    ArrayList localArrayList = Lists.newArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      str = Persistence.access$200(this$0, paramContext, str, "confirm-actions", null);
      if (str != null) {
        localArrayList.add(str);
      }
    }
    paramContext = (Context)localObject;
    if (localArrayList.size() > 0) {
      paramContext = TextUtils.join(",", localArrayList);
    }
    return paramContext;
  }
  
  public String migrateFromSingleAccount(Context paramContext, String paramString)
  {
    return Persistence.access$200(this$0, paramContext, paramString, "confirm-actions", null);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.persistence.Persistence.ConfirmActionsAccountToGlobalMigrator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */