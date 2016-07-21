import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.os.AsyncTask;
import java.util.ArrayList;

public class ctt
  extends AsyncTask<Void, Void, ctv>
{
  private static final String d = cvl.a;
  private ContentResolver a;
  private String b;
  private ArrayList<ContentProviderOperation> c;
  
  protected final ctv a()
  {
    try
    {
      ctv localctv = new ctv(null, a.applyBatch(b, c));
      return localctv;
    }
    catch (Exception localException)
    {
      cvm.d(d, localException, "exception executing ContentProviderOperationsTask", new Object[0]);
      return new ctv(localException, null);
    }
  }
  
  public final void a(ContentResolver paramContentResolver, String paramString, ArrayList<ContentProviderOperation> paramArrayList)
  {
    a = paramContentResolver;
    b = paramString;
    c = paramArrayList;
    executeOnExecutor(THREAD_POOL_EXECUTOR, new Void[] { null });
  }
}

/* Location:
 * Qualified Name:     ctt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */