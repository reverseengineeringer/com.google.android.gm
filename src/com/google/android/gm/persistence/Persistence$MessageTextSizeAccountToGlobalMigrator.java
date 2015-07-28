package com.google.android.gm.persistence;

import android.content.Context;
import java.util.Iterator;
import java.util.List;

public class Persistence$MessageTextSizeAccountToGlobalMigrator
  extends Persistence.AccountToGlobalPreferenceMigrator<String>
{
  public Persistence$MessageTextSizeAccountToGlobalMigrator(Persistence paramPersistence)
  {
    super(paramPersistence, null);
  }
  
  public String migrateFromMultipleAccounts(Context paramContext, List<String> paramList)
  {
    String str = null;
    float f1 = 0.0F;
    Iterator localIterator = paramList.iterator();
    paramList = str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      str = Persistence.access$200(this$0, paramContext, str, "message-text", null);
      if (str != null) {
        try
        {
          float f2 = Float.parseFloat(str);
          if (f2 > f1)
          {
            f1 = f2;
            paramList = str;
          }
        }
        catch (NumberFormatException localNumberFormatException) {}
      }
    }
    return paramList;
  }
  
  public String migrateFromSingleAccount(Context paramContext, String paramString)
  {
    return Persistence.access$200(this$0, paramContext, paramString, "message-text", null);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.persistence.Persistence.MessageTextSizeAccountToGlobalMigrator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */