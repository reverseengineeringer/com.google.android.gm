import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.android.emailcommon.provider.ExchangeOofSettings;

public final class azk
{
  private static final String a = cvl.a;
  
  public static int a(SQLiteDatabase paramSQLiteDatabase, String paramString, ExchangeOofSettings paramExchangeOofSettings)
  {
    Object localObject = paramSQLiteDatabase.query("ExchangeOofSettings", new String[] { "num_attempts_to_upload", "is_dirty" }, "email=?", new String[] { paramString }, null, null, null);
    if (localObject != null) {}
    for (;;)
    {
      try
      {
        if (((Cursor)localObject).moveToFirst())
        {
          i = ((Cursor)localObject).getInt(((Cursor)localObject).getColumnIndex("num_attempts_to_upload"));
          if (((Cursor)localObject).getInt(((Cursor)localObject).getColumnIndex("is_dirty")) != 0)
          {
            boolean bool = d;
            if (!bool)
            {
              if (i < 3) {
                return 0;
              }
              cvm.e(a, "Overwriting local dirty EAS OOF settings", new Object[0]);
              buo.a().a("EAS_OOF", "local_upload_failure", cui.d(paramString), 0L);
            }
          }
        }
        ((Cursor)localObject).close();
        localObject = new ContentValues(15);
        ((ContentValues)localObject).put("email", paramString);
        ((ContentValues)localObject).put("num_attempts_to_upload", Integer.valueOf(0));
        ((ContentValues)localObject).put("eas_oof_state", Integer.valueOf(a));
        ((ContentValues)localObject).put("eas_oof_start", Long.valueOf(b));
        ((ContentValues)localObject).put("eas_oof_end", Long.valueOf(c));
        if (d)
        {
          i = 1;
          ((ContentValues)localObject).put("is_dirty", Integer.valueOf(i));
          ((ContentValues)localObject).put("eas_oof_internal_enabled", Boolean.valueOf(e));
          ((ContentValues)localObject).put("eas_oof_internal_message", g);
          ((ContentValues)localObject).put("eas_oof_internal_message_type", Integer.valueOf(f));
          ((ContentValues)localObject).put("eas_oof_external_known_enabled", Boolean.valueOf(h));
          ((ContentValues)localObject).put("eas_oof_external_known_message", j);
          ((ContentValues)localObject).put("eas_oof_external_known_message_type", Integer.valueOf(i));
          ((ContentValues)localObject).put("eas_oof_external_unknown_enabled", Boolean.valueOf(k));
          ((ContentValues)localObject).put("eas_oof_external_unknown_message", m);
          ((ContentValues)localObject).put("eas_oof_external_unknown_message_type", Integer.valueOf(l));
          paramSQLiteDatabase.insertWithOnConflict("ExchangeOofSettings", null, (ContentValues)localObject, 5);
          return 1;
        }
      }
      finally
      {
        ((Cursor)localObject).close();
      }
      int i = 0;
    }
  }
  
  public static Cursor a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    return paramSQLiteDatabase.query("ExchangeOofSettings", null, "email=?", new String[] { paramString }, null, null, null);
  }
}

/* Location:
 * Qualified Name:     azk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */