import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import com.android.mail.ui.settings.GeneralPrefsFragment;

public final class csb
  extends AsyncTask<Void, Void, Void>
{
  public csb(GeneralPrefsFragment paramGeneralPrefsFragment, Context paramContext) {}
  
  private final Void a()
  {
    chf localchf = new chf(a);
    SQLiteDatabase localSQLiteDatabase = localchf.a(false);
    if (localSQLiteDatabase != null) {}
    try
    {
      localSQLiteDatabase.delete("suggestions", null, null);
      localchf.a();
      return null;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        cvm.d(chc.a, localIllegalStateException, "recent suggestions db delete exception", new Object[0]);
      }
    }
  }
}

/* Location:
 * Qualified Name:     csb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */