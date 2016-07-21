package com.google.android.gm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import avj;
import bap;
import bbz;
import bhk;
import cvm;
import cxd;
import dev;
import dfm;
import dfn;
import dfo;
import dfp;

public class MailMigrationApplication
  extends dev
{
  static
  {
    bbz.a(new dfm());
    if (!cxd.d())
    {
      dfo localdfo = new dfo();
      cvm.b(bap.a, "setting background purge scheduler", new Object[0]);
      bap.b = localdfo;
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (!getSharedPreferences("EmailMigration", 0).getBoolean("disable_migration_service", false))
    {
      cvm.b("EmailMigration", "Migration is ENABLED.", new Object[0]);
      startService(new Intent(this, EmailMigrationService.class));
    }
    for (;;)
    {
      new dfn(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
      d = avj.class;
      bhe.a = new dfp(this);
      bhk.a();
      return;
      cvm.b("EmailMigration", "Migration is DISABLED.", new Object[0]);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.MailMigrationApplication
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */