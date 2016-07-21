import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.Iterator;

public class chc
{
  public static final String a = cvl.a;
  public final Context b;
  ArrayList<String> c;
  private final SQLiteOpenHelper d;
  private final String e;
  private final Object f = new Object();
  private boolean g;
  
  public chc(Context paramContext)
  {
    b = paramContext;
    d = new chd(b);
    paramContext = String.valueOf("android.resource://");
    String str = String.valueOf(b.getPackageName());
    int i = bub.ag;
    e = (String.valueOf(paramContext).length() + 12 + String.valueOf(str).length() + paramContext + str + "/" + i);
  }
  
  public Cursor a(String paramString)
  {
    return b(paramString);
  }
  
  public final SQLiteDatabase a(boolean paramBoolean)
  {
    synchronized (f)
    {
      if (!g)
      {
        if (paramBoolean) {}
        for (SQLiteDatabase localSQLiteDatabase = d.getReadableDatabase();; localSQLiteDatabase = d.getWritableDatabase()) {
          return localSQLiteDatabase;
        }
      }
      return null;
    }
  }
  
  public final void a()
  {
    synchronized (f)
    {
      d.close();
      g = true;
      return;
    }
  }
  
  public final Cursor b(String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = a(true);
    if (localSQLiteDatabase != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (c != null)
      {
        Iterator localIterator = c.iterator();
        while (localIterator.hasNext()) {
          localStringBuilder.append((String)localIterator.next()).append(" ");
        }
      }
      return localSQLiteDatabase.rawQuery(" SELECT _id   , display1 AS suggest_text_1   , ? || query AS suggest_intent_query   , ? AS suggest_icon_1 FROM suggestions WHERE display1 LIKE ? ORDER BY date DESC  LIMIT 10", new String[] { localStringBuilder.toString(), e, String.valueOf(paramString).length() + 2 + "%" + paramString + "%" });
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     chc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */