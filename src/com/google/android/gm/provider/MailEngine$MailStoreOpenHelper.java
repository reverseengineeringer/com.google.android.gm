package com.google.android.gm.provider;

import android.content.Context;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.android.mail.utils.Utils;

public class MailEngine$MailStoreOpenHelper
  extends SQLiteOpenHelper
{
  private MailStoreInitializer mDbInitializer;
  
  MailEngine$MailStoreOpenHelper(MailEngine paramMailEngine, Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 127, new DefaultDatabaseErrorHandler());
    if (Utils.isRunningJellybeanOrLater()) {
      setWriteAheadLoggingEnabled(true);
    }
  }
  
  private void enableWriteAheadLogging(SQLiteDatabase paramSQLiteDatabase)
  {
    if ((paramSQLiteDatabase != null) && (paramSQLiteDatabase.isOpen()) && (!paramSQLiteDatabase.isReadOnly())) {
      paramSQLiteDatabase.enableWriteAheadLogging();
    }
  }
  
  private MailStoreInitializer getInitializer(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      if (mDbInitializer == null) {
        mDbInitializer = new MailStoreInitializer(this$0, paramSQLiteDatabase);
      }
      paramSQLiteDatabase = mDbInitializer;
      return paramSQLiteDatabase;
    }
    finally {}
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    getInitializer(paramSQLiteDatabase).bootstrapDatabase();
  }
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.setMaxSqlCacheSize(50);
    if (!Utils.isRunningJellybeanOrLater()) {
      enableWriteAheadLogging(paramSQLiteDatabase);
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase = getInitializer(paramSQLiteDatabase);
    if ((paramInt1 < 36) || ((paramInt1 < 100) && (paramInt1 > 80)))
    {
      paramSQLiteDatabase.bootstrapDatabase();
      return;
    }
    paramSQLiteDatabase.performUpgrade(127);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailEngine.MailStoreOpenHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */