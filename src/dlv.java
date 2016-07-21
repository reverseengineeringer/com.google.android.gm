import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.android.email.provider.EmailProvider;
import com.android.emailcommon.provider.Mailbox;
import com.android.mail.providers.Message;

public final class dlv
  extends cot<Boolean>
{
  private static final String a = cvl.a;
  private static final int[] b = { 3, 4 };
  private final String c;
  private final String d;
  private final dlw e;
  
  public dlv(Context paramContext, String paramString1, String paramString2, dlw paramdlw)
  {
    super(paramContext);
    c = paramString1;
    d = paramString2;
    e = paramdlw;
  }
  
  private final boolean a(Uri paramUri, int paramInt, long... paramVarArgs)
  {
    paramVarArgs = hku.a(", ", paramVarArgs);
    cvm.b(a, "Gmailify: Copy messages in mailboxes: %s", new Object[] { paramVarArgs });
    String str = String.valueOf("mailboxKey IN (");
    paramVarArgs = String.valueOf(str).length() + 1 + String.valueOf(paramVarArgs).length() + str + paramVarArgs + ")";
    paramVarArgs = getContext().getContentResolver().query(beb.a, bdv.B, paramVarArgs, null, null);
    if (paramVarArgs == null)
    {
      paramUri = String.valueOf(beb.a);
      throw new NullPointerException(String.valueOf(paramUri).length() + 25 + "Null cursor returned for " + paramUri);
    }
    e.a(Mailbox.c(paramInt), paramVarArgs.getCount());
    boolean bool1 = true;
    try
    {
      while (paramVarArgs.moveToNext())
      {
        boolean bool2 = a(paramUri, paramVarArgs.getLong(paramVarArgs.getColumnIndex("_id")));
        bool1 &= bool2;
      }
      return bool1;
    }
    finally
    {
      paramVarArgs.close();
    }
  }
  
  private final boolean a(Uri paramUri, long paramLong)
  {
    Object localObject = EmailProvider.a("uimessage", paramLong);
    ContentResolver localContentResolver = getContext().getContentResolver();
    Cursor localCursor = localContentResolver.query((Uri)localObject, chh.n, null, null, null);
    if (localCursor == null)
    {
      paramUri = String.valueOf(localObject);
      throw new NullPointerException(String.valueOf(paramUri).length() + 25 + "Null cursor returned for " + paramUri);
    }
    try
    {
      if (localCursor.moveToFirst())
      {
        localObject = new Message(localCursor);
        cvm.a(a, "Gmailify: Copy message: %s", new Object[] { localObject });
        paramUri = localContentResolver.insert(paramUri, ((Message)localObject).c());
        if (paramUri != null) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
      }
      cvm.d(a, "Gmailify: Could not load message id=%d", new Object[] { Long.valueOf(paramLong) });
      return false;
    }
    finally
    {
      localCursor.close();
    }
  }
}

/* Location:
 * Qualified Name:     dlv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */