import android.accounts.Account;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.google.android.gms.appdatasearch.QuerySpecification;
import com.google.android.gms.appdatasearch.Section;
import java.util.ArrayList;
import java.util.List;

public final class dqh
  extends bgr
{
  static final String b = cvl.a;
  private static final QuerySpecification c;
  
  static
  {
    eca localeca = new eca();
    if (a == null) {
      a = new ArrayList();
    }
    a.add("^f");
    c = localeca.a(new Section("conversation")).a(new Section("body", true, 80)).a();
  }
  
  private dqh(Context paramContext)
  {
    super(paramContext);
  }
  
  public static Uri a(String paramString)
  {
    return Uri.withAppendedPath(dpy.a(paramString), "appdatasearch");
  }
  
  public static dqh a(Context paramContext)
  {
    if (!b(paramContext)) {
      return null;
    }
    return new dqh(paramContext);
  }
  
  protected final bgs a(SQLiteDatabase paramSQLiteDatabase, Account paramAccount)
  {
    return new dqi(paramSQLiteDatabase);
  }
  
  protected final QuerySpecification a()
  {
    return c;
  }
}

/* Location:
 * Qualified Name:     dqh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */