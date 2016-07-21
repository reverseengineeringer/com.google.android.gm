import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import java.util.Iterator;
import java.util.List;

public final class drf
{
  public List<String> a;
  SQLiteQueryBuilder b = new SQLiteQueryBuilder();
  private boolean c;
  private SQLiteDatabase d;
  private String[] e;
  private int f;
  private boolean g;
  
  public drf(Context paramContext, SQLiteDatabase paramSQLiteDatabase, String[] paramArrayOfString)
  {
    d = paramSQLiteDatabase;
    e = paramArrayOfString;
    b.setTables("labels");
    b.setProjectionMap(drp.U);
    a = hgd.a(duo.a(paramContext, paramArrayOfString, "name", new String[0]));
    a("( canonicalName != '' OR name != '' )");
  }
  
  public final Cursor a()
  {
    String[] arrayOfString1 = (String[])a.toArray(new String[a.size()]);
    SQLiteQueryBuilder localSQLiteQueryBuilder = b;
    SQLiteDatabase localSQLiteDatabase = d;
    String[] arrayOfString2 = e;
    String str1;
    if (g)
    {
      str1 = "lastTouched DESC";
      if (f == 0) {
        break label90;
      }
    }
    label90:
    for (String str2 = Integer.toString(f);; str2 = null)
    {
      return localSQLiteQueryBuilder.query(localSQLiteDatabase, arrayOfString2, null, arrayOfString1, null, null, str1, str2);
      str1 = "systemLabel DESC, sortOrder ASC";
      break;
    }
  }
  
  public final drf a(long paramLong, int paramInt)
  {
    if (paramLong != 0L)
    {
      StringBuilder localStringBuilder = new StringBuilder("lastTouched");
      localStringBuilder.append(" != 0 AND ");
      localStringBuilder.append("lastTouched");
      localStringBuilder.append(" < ?");
      a.add(Long.toString(paramLong));
      f = paramInt;
      a(localStringBuilder.toString());
      g = true;
    }
    return this;
  }
  
  public final drf a(List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramList = paramList.iterator();
      int i = 1;
      if (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (i != 0)
        {
          localStringBuilder.append("canonicalName IN (");
          i = 0;
        }
        for (;;)
        {
          localStringBuilder.append("?");
          a.add(str);
          break;
          localStringBuilder.append(", ");
        }
      }
      localStringBuilder.append(")");
      a(localStringBuilder.toString());
    }
    return this;
  }
  
  public final drf a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      a("hidden = 0");
    }
    return this;
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    if (c) {
      b.appendWhere(" AND ");
    }
    for (;;)
    {
      b.appendWhere(paramCharSequence);
      return;
      c = true;
    }
  }
}

/* Location:
 * Qualified Name:     drf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */