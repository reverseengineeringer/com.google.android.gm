package com.google.android.gm.provider;

import android.database.sqlite.SQLiteDatabase;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class DatabaseInitializer
{
  protected final SQLiteDatabase mDb;
  protected final MailEngine mEngine;
  protected final int mInitialDbVersion;
  
  DatabaseInitializer(MailEngine paramMailEngine, SQLiteDatabase paramSQLiteDatabase)
  {
    mEngine = paramMailEngine;
    mDb = paramSQLiteDatabase;
    mInitialDbVersion = paramSQLiteDatabase.getVersion();
  }
  
  private int upgradeDatabase(int paramInt)
  {
    paramInt = getTargetDbVersion(paramInt);
    Method localMethod = findUpgradeMethod(paramInt);
    Throwable localThrowable = null;
    try
    {
      localMethod.invoke(this, new Object[0]);
      mDb.setVersion(paramInt);
      if (localThrowable != null) {
        throw new IllegalStateException("Failed to invoke upgrade Method", localThrowable);
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;) {}
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;) {}
    }
    return paramInt;
  }
  
  public abstract void bootstrapDatabase();
  
  Method findUpgradeMethod(int paramInt)
  {
    Object localObject = getClass();
    try
    {
      localObject = ((Class)localObject).getMethod("upgradeDbTo" + paramInt, (Class[])null);
      return (Method)localObject;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new IllegalStateException("Missing upgrade to version: " + paramInt, localNoSuchMethodException);
    }
  }
  
  int getTargetDbVersion(int paramInt)
  {
    return paramInt + 1;
  }
  
  void performUpgrade(int paramInt)
  {
    for (int i = mInitialDbVersion; i < paramInt; i = upgradeDatabase(i)) {}
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.DatabaseInitializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */