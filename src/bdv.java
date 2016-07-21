import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.ContentObservable;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.AccountDirtyFlags;
import com.android.emailcommon.provider.Attachment;
import com.android.emailcommon.provider.Credential;
import com.android.emailcommon.provider.HostAuth;
import com.android.emailcommon.provider.Mailbox;
import com.android.emailcommon.provider.Policy;
import java.util.List;

public abstract class bdv
{
  public static final String[] A = { "count(*)" };
  public static final String[] B = { "_id" };
  public static String E;
  public static String F;
  public static String G;
  public static Uri H;
  public static Uri I;
  public static Uri J;
  public static Uri K;
  public static Uri L;
  public static Uri M;
  public static Uri N;
  public static String O;
  public Uri C;
  public long D = -1L;
  private Uri a = null;
  private bdw b;
  private ContentObservable c;
  
  public static int a(Context paramContext, Uri paramUri, long paramLong)
  {
    return paramContext.getContentResolver().delete(ContentUris.withAppendedId(paramUri, paramLong), null, null);
  }
  
  public static int a(Context paramContext, Uri paramUri, long paramLong, ContentValues paramContentValues)
  {
    return paramContext.getContentResolver().update(ContentUris.withAppendedId(paramUri, paramLong), paramContentValues, null, null);
  }
  
  public static int a(Context paramContext, Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return bhn.a(paramContext, paramUri, A, paramString, paramArrayOfString, null, Long.valueOf(0L)).intValue();
  }
  
  public static Uri a(Uri paramUri, int paramInt)
  {
    return paramUri.buildUpon().appendQueryParameter("limit", Integer.toString(paramInt)).build();
  }
  
  public static <T extends bdv> T a(Context paramContext, Cursor paramCursor, Class<T> paramClass)
  {
    try
    {
      paramClass = (bdv)paramClass.newInstance();
      D = paramCursor.getLong(0);
      paramClass.a(paramContext, paramCursor);
      return paramClass;
    }
    catch (IllegalAccessException paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    catch (InstantiationException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public static <T extends bdv> T a(Context paramContext, Class<T> paramClass, Uri paramUri, String[] paramArrayOfString, long paramLong)
  {
    return a(paramContext, paramClass, paramUri, paramArrayOfString, paramLong, null);
  }
  
  public static <T extends bdv> T a(Context paramContext, Class<T> paramClass, Uri paramUri, String[] paramArrayOfString, long paramLong, ContentObserver paramContentObserver)
  {
    cwv.a();
    paramUri = ContentUris.withAppendedId(paramUri, paramLong);
    paramUri = paramContext.getContentResolver().query(paramUri, paramArrayOfString, null, null, null);
    if (paramUri == null) {
      throw new bej();
    }
    try
    {
      if (paramUri.moveToFirst())
      {
        paramClass = a(paramContext, paramUri, paramClass);
        if (paramContentObserver != null) {
          paramClass.a(paramContext, paramContentObserver);
        }
        return paramClass;
      }
      return null;
    }
    finally
    {
      paramUri.close();
    }
  }
  
  private final void a()
  {
    try
    {
      if (c == null) {
        throw new IllegalStateException("Unregistering with null observable");
      }
    }
    finally {}
    c.unregisterAll();
  }
  
  private final void a(Context paramContext, ContentObserver paramContentObserver)
  {
    try
    {
      if (b == null)
      {
        b = new bdw(this);
        paramContext.getContentResolver().registerContentObserver(b(), true, b);
        c = new ContentObservable();
      }
      c.registerObserver(paramContentObserver);
      return;
    }
    finally {}
  }
  
  public static boolean c(String paramString)
  {
    return (paramString == null) || (paramString.isEmpty()) || (paramString.equals("0"));
  }
  
  public static void i(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (F == null)
        {
          if (E == null) {
            E = paramContext.getResources().getString(bcd.a);
          }
          F = String.valueOf(E).concat(".provider");
          paramContext = String.valueOf(F);
          if (paramContext.length() != 0)
          {
            paramContext = "init for ".concat(paramContext);
            cvm.b("EmailContent", paramContext, new Object[0]);
            G = String.valueOf(E).concat(".notifier");
            paramContext = String.valueOf(F);
            if (paramContext.length() == 0) {
              break label551;
            }
            paramContext = "content://".concat(paramContext);
            H = Uri.parse(paramContext);
            paramContext = String.valueOf(G);
            if (paramContext.length() == 0) {
              break label565;
            }
            paramContext = "content://".concat(paramContext);
            I = Uri.parse(paramContext);
            paramContext = F;
            J = Uri.parse(String.valueOf(paramContext).length() + 26 + "content://" + paramContext + "/pickTrashFolder");
            paramContext = F;
            K = Uri.parse(String.valueOf(paramContext).length() + 25 + "content://" + paramContext + "/pickSentFolder");
            paramContext = F;
            L = Uri.parse(String.valueOf(paramContext).length() + 30 + "content://" + paramContext + "/mailboxNotification");
            paramContext = F;
            M = Uri.parse(String.valueOf(paramContext).length() + 35 + "content://" + paramContext + "/mailboxMostRecentMessage");
            paramContext = F;
            N = Uri.parse(String.valueOf(paramContext).length() + 23 + "content://" + paramContext + "/accountCheck");
            O = String.valueOf(E).concat(".permission.ACCESS_PROVIDER");
            Account.a();
            Mailbox.a();
            paramContext = String.valueOf(H);
            bek.a = Uri.parse(String.valueOf(paramContext).length() + 14 + paramContext + "/quickresponse");
            paramContext = String.valueOf(H);
            bek.b = Uri.parse(String.valueOf(paramContext).length() + 22 + paramContext + "/quickresponse/account");
            HostAuth.a();
            Credential.a();
            Policy.a();
            beb.a();
            bed.a();
            beg.g = H.buildUpon().appendEncodedPath("messageChange").build();
            bds.a();
            Attachment.a();
            AccountDirtyFlags.a();
            bem.a();
          }
        }
        else
        {
          return;
        }
        paramContext = new String("init for ");
        continue;
        paramContext = new String("content://");
      }
      finally {}
      label551:
      continue;
      label565:
      paramContext = new String("content://");
    }
  }
  
  public final int a(Context paramContext, ContentValues paramContentValues)
  {
    if (!h()) {
      throw new UnsupportedOperationException();
    }
    return paramContext.getContentResolver().update(g(), paramContentValues, null, null);
  }
  
  public void a(Context paramContext, Cursor paramCursor)
  {
    a(paramCursor);
  }
  
  public abstract void a(Cursor paramCursor);
  
  public Uri b()
  {
    throw new UnsupportedOperationException("Subclasses must override this method for content observation to work");
  }
  
  public long c()
  {
    return D;
  }
  
  public abstract ContentValues e();
  
  public final Uri g()
  {
    if (a == null) {
      a = ContentUris.withAppendedId(C, D);
    }
    return a;
  }
  
  public Uri h(Context paramContext)
  {
    if (h()) {
      throw new UnsupportedOperationException();
    }
    paramContext = paramContext.getContentResolver().insert(C, e());
    D = Long.parseLong((String)paramContext.getPathSegments().get(1));
    return paramContext;
  }
  
  public final boolean h()
  {
    return D != -1L;
  }
  
  public final void i()
  {
    try
    {
      if (c != null) {
        c.dispatchChange(false);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public final void j(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 185	bdv:b	Lbdw;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: invokespecial 403	bdv:a	()V
    //   18: aload_1
    //   19: invokevirtual 56	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   22: aload_0
    //   23: getfield 185	bdv:b	Lbdw;
    //   26: invokevirtual 406	android/content/ContentResolver:unregisterContentObserver	(Landroid/database/ContentObserver;)V
    //   29: aload_0
    //   30: aconst_null
    //   31: putfield 185	bdv:b	Lbdw;
    //   34: goto -23 -> 11
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	bdv
    //   0	42	1	paramContext	Context
    //   6	2	2	localbdw	bdw
    // Exception table:
    //   from	to	target	type
    //   2	7	37	finally
    //   14	34	37	finally
  }
}

/* Location:
 * Qualified Name:     bdv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */