import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.Mailbox;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public final class bqy
  extends bqv
{
  private static final String[] a = { "syncServerId" };
  
  private static ArrayList<String> a(Context paramContext, Mailbox paramMailbox)
  {
    localArrayList = new ArrayList();
    paramContext = paramContext.getContentResolver().query(beb.a, a, "flagLoaded=2 AND mailboxKey=?", new String[] { Long.toString(D) }, null);
    if (paramContext != null) {
      try
      {
        if (paramContext.moveToNext()) {
          localArrayList.add(paramContext.getString(0));
        }
        return localArrayList;
      }
      finally
      {
        paramContext.close();
      }
    }
  }
  
  public final int a()
  {
    return 0;
  }
  
  public final bnx a(Context paramContext, Account paramAccount, Mailbox paramMailbox, InputStream paramInputStream)
  {
    return new bom(paramContext, paramInputStream, paramMailbox, paramAccount);
  }
  
  public final void a(Context paramContext, bpi parambpi, double paramDouble, Account paramAccount, Mailbox paramMailbox, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      return;
    }
    paramContext = a(paramContext, paramMailbox);
    if (paramContext.isEmpty())
    {
      if (h == 6) {}
      for (int i = 1; paramDouble < 12.0D; i = 0)
      {
        if (i == 0) {
          parambpi.b(30);
        }
        parambpi.b(19);
        paramInt *= 10;
        if (paramInt <= 522) {
          break label116;
        }
        throw new IOException("Max window size reached and still no data");
      }
      if (i != 0) {}
      for (paramContext = "0";; paramContext = "1")
      {
        parambpi.b(30, paramContext);
        break;
      }
      label116:
      if (paramInt < 512)
      {
        parambpi.b(21, String.valueOf(paramInt));
        parambpi.a(23);
        if (k != 0) {
          break label266;
        }
        paramInt = f;
        switch (paramInt)
        {
        default: 
          label158:
          paramContext = "3";
          label203:
          parambpi.b(24, paramContext);
          if (paramDouble >= 12.0D)
          {
            parambpi.a(1093);
            parambpi.b(1094, "2");
            parambpi.b(1095, "200000");
            parambpi.b();
          }
          break;
        }
      }
      for (;;)
      {
        parambpi.b();
        return;
        paramInt = 512;
        break;
        label266:
        paramInt = k;
        break label158;
        paramContext = "1";
        break label203;
        paramContext = "2";
        break label203;
        paramContext = "3";
        break label203;
        paramContext = "4";
        break label203;
        paramContext = "5";
        break label203;
        paramContext = "0";
        break label203;
        parambpi.b(34, "2");
        parambpi.b(35, "7");
      }
    }
    parambpi.a(23);
    parambpi.b(34, "0");
    parambpi.b(25, "7");
    parambpi.b();
    parambpi.a(22);
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      paramAccount = (String)paramContext.next();
      parambpi.a(10).b(13, paramAccount).b();
    }
    parambpi.b();
  }
}

/* Location:
 * Qualified Name:     bqy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */