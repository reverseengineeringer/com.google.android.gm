package com.google.android.gm.persistence;

import android.content.Context;
import java.util.List;

abstract class Persistence$AccountToGlobalPreferenceMigrator<T>
{
  private Persistence$AccountToGlobalPreferenceMigrator(Persistence paramPersistence) {}
  
  public T migrate(Context paramContext)
  {
    Object localObject = this$0.getCachedConfiguredGoogleAccounts(paramContext, false);
    if (localObject != null)
    {
      if (((List)localObject).size() == 1) {
        return (T)migrateFromSingleAccount(paramContext, (String)((List)localObject).get(0));
      }
      if (((List)localObject).size() > 1) {
        return (T)migrateFromMultipleAccounts(paramContext, (List)localObject);
      }
    }
    localObject = this$0.getActiveAccount(paramContext);
    if (localObject != null) {
      return (T)migrateFromSingleAccount(paramContext, (String)localObject);
    }
    return null;
  }
  
  abstract T migrateFromMultipleAccounts(Context paramContext, List<String> paramList);
  
  abstract T migrateFromSingleAccount(Context paramContext, String paramString);
}

/* Location:
 * Qualified Name:     com.google.android.gm.persistence.Persistence.AccountToGlobalPreferenceMigrator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */