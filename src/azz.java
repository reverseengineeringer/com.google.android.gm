import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;

public final class azz
{
  public static String a(Uri paramUri, String paramString)
  {
    String str1 = paramUri.getQueryParameter("account_name");
    String str2 = paramUri.getQueryParameter("account_type");
    if (paramString == null) {}
    for (paramUri = new StringBuilder();; paramUri = new StringBuilder(paramString))
    {
      if (!TextUtils.isEmpty(str1))
      {
        if (paramUri.length() != 0) {
          paramUri.append(" AND ");
        }
        paramUri.append("account_name=?");
      }
      if (!TextUtils.isEmpty(str2))
      {
        if (paramUri.length() != 0) {
          paramUri.append(" AND ");
        }
        paramUri.append("account_type=?");
      }
      if (paramUri.length() != 0) {
        break;
      }
      return null;
    }
    return paramUri.toString();
  }
  
  public static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE tasks (_id INTEGER PRIMARY KEY,server_id TEXT,subject TEXT,account_name TEXT,account_type TEXT,body TEXT,complete INTEGER NOT NULL DEFAULT 0,date_complete LONG,start_date LONG,due_date LONG,reminder_set INTEGER,reminder_time TEXT,rrule TEXT,rdate TEXT,exrule TEXT,exdate TEXT,importance INTEGER,sensitivity INTEGER,categories TEXT,sync_dirty INTEGER NOT NULL DEFAULT 0,sync_local_id TEXT,sync_version TEXT,deleted INTEGER NOT NULL DEFAULT 0,folder_id LONG NOT NULL DEFAULT 0,recurrence_dead_occur INTEGER,recurrence_regenerate INTEGER,recurrent_start_date LONG,notification_status INTEGER NOT NULL DEFAULT 0,notification_time LONG);");
    cty.a(paramSQLiteDatabase, "tasks", "server_id");
  }
  
  public static void a(boolean paramBoolean, ContentValues paramContentValues)
  {
    if (!paramBoolean) {
      paramContentValues.put("sync_dirty", Integer.valueOf(1));
    }
  }
  
  public static String[] a(Uri paramUri, String[] paramArrayOfString)
  {
    String str = paramUri.getQueryParameter("account_name");
    paramUri = paramUri.getQueryParameter("account_type");
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfString != null) {
      localArrayList.addAll(Arrays.asList(paramArrayOfString));
    }
    if (!TextUtils.isEmpty(str)) {
      localArrayList.add(str);
    }
    if (!TextUtils.isEmpty(paramUri)) {
      localArrayList.add(paramUri);
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
}

/* Location:
 * Qualified Name:     azz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */