import android.content.AsyncTaskLoader;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Loader;
import android.content.Loader.ForceLoadContentObserver;
import android.database.Cursor;
import android.net.Uri;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

public class ccz<T>
  extends AsyncTaskLoader<ccy<T>>
{
  final Loader<ccy<T>>.ForceLoadContentObserver a;
  public Uri b;
  final String[] c;
  final String d = null;
  final String[] e = null;
  final String f = null;
  ccy<T> g;
  private final ccx<T> h;
  private int i = 0;
  
  public ccz(Context paramContext, Uri paramUri, String[] paramArrayOfString, ccx<T> paramccx)
  {
    super(paramContext);
    if (paramccx == null) {
      throw new NullPointerException("The factory cannot be null");
    }
    a = new Loader.ForceLoadContentObserver(this);
    a(paramUri);
    c = paramArrayOfString;
    h = paramccx;
  }
  
  private final ccy<T> a()
  {
    Object localObject = getContext().getContentResolver().query(b, c, d, e, f);
    if (localObject == null)
    {
      localObject = null;
      return (ccy<T>)localObject;
    }
    ((Cursor)localObject).getCount();
    ((Cursor)localObject).registerContentObserver(a);
    ccy localccy = a((Cursor)localObject);
    localObject = localccy.getWrappedCursor();
    if ((localObject == null) || (!((Cursor)localObject).moveToFirst())) {}
    for (;;)
    {
      localObject = localccy;
      try
      {
        if (i <= 0) {
          break;
        }
        Thread.sleep(i);
        return localccy;
      }
      catch (InterruptedException localInterruptedException)
      {
        return localccy;
      }
      do
      {
        localccy.f();
      } while (localInterruptedException.moveToNext());
    }
  }
  
  public ccy<T> a(Cursor paramCursor)
  {
    return new ccy(paramCursor, h);
  }
  
  public final void a(Uri paramUri)
  {
    if (paramUri == null) {
      throw new NullPointerException("The uri cannot be null");
    }
    b = paramUri;
  }
  
  public void a(ccy<T> paramccy)
  {
    if (isReset()) {
      if (paramccy != null) {
        paramccy.close();
      }
    }
    ccy localccy;
    do
    {
      return;
      localccy = g;
      g = paramccy;
      if (isStarted()) {
        super.deliverResult(paramccy);
      }
    } while ((localccy == null) || (localccy == paramccy) || (localccy.isClosed()));
    localccy.close();
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mUri=");
    paramPrintWriter.println(b);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mProjection=");
    paramPrintWriter.println(Arrays.toString(c));
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mSelection=");
    paramPrintWriter.println(d);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mSelectionArgs=");
    paramPrintWriter.println(Arrays.toString(e));
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mSortOrder=");
    paramPrintWriter.println(f);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mCursor=");
    paramPrintWriter.println(g);
  }
  
  protected void onReset()
  {
    super.onReset();
    onStopLoading();
    if ((g != null) && (!g.isClosed())) {
      g.close();
    }
    g = null;
  }
  
  protected void onStartLoading()
  {
    if (g != null) {
      a(g);
    }
    if ((takeContentChanged()) || (g == null)) {
      forceLoad();
    }
  }
  
  protected void onStopLoading()
  {
    cancelLoad();
  }
}

/* Location:
 * Qualified Name:     ccz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */