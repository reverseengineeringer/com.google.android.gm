import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

public final class crt
  extends AsyncTask<String, Void, Void>
{
  public crt(crr paramcrr) {}
  
  private final Void a(String... paramVarArgs)
  {
    Object localObject = a.c;
    paramVarArgs = paramVarArgs[0];
    localObject = ((chc)localObject).a(false);
    ContentValues localContentValues;
    if (localObject != null)
    {
      localContentValues = new ContentValues(3);
      localContentValues.put("display1", paramVarArgs);
      localContentValues.put("query", paramVarArgs);
      localContentValues.put("date", Long.valueOf(System.currentTimeMillis()));
    }
    try
    {
      ((SQLiteDatabase)localObject).insert("suggestions", null, localContentValues);
      return null;
    }
    catch (IllegalStateException paramVarArgs)
    {
      cvm.d(chc.a, paramVarArgs, "recent suggestions db save exception", new Object[0]);
    }
    return null;
  }
  
  protected final void onPreExecute()
  {
    a.j = true;
  }
}

/* Location:
 * Qualified Name:     crt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */