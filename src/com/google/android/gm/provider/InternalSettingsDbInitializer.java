package com.google.android.gm.provider;

import android.database.sqlite.SQLiteDatabase;

class InternalSettingsDbInitializer
  extends DatabaseInitializer
{
  InternalSettingsDbInitializer(MailEngine paramMailEngine)
  {
    super(paramMailEngine, mInternalDb);
  }
  
  public void bootstrapDatabase()
  {
    LogUtils.i("Gmail", "Bootstrapping db:%s Current version is %d", new Object[] { mDb.getPath(), Integer.valueOf(mDb.getVersion()) });
    mDb.execSQL("DROP TABLE IF EXISTS internal_sync_settings");
    mDb.execSQL("CREATE TABLE internal_sync_settings (_id INTEGER PRIMARY KEY,name TEXT,value TEXT,UNIQUE (name))");
    mDb.setVersion(2);
  }
  
  public void upgradeDbTo2()
  {
    mEngine.sendUpgradeSyncWindowIntent();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.InternalSettingsDbInitializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */