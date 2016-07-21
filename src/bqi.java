import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import com.android.emailcommon.provider.Mailbox;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import org.apache.http.HttpEntity;

public final class bqi
  extends bqc
{
  public final android.accounts.Account a;
  public long b;
  private final Random c;
  
  public bqi(Context paramContext, com.android.emailcommon.provider.Account paramAccount, android.accounts.Account paramAccount1)
  {
    super(paramContext, paramAccount);
    a = paramAccount1;
    b = p;
    if (b == 0L) {
      b = 480L;
    }
    c = new Random();
    long l1 = b;
    long l2 = g.D;
    cvm.b("Exchange", 71 + "initial ping duration " + l1 + " account " + l2, new Object[0]);
  }
  
  private final void a(int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      cvm.e("Exchange", "ping finished: %s account %d status %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
      cvm.f("Exchange", "unexpected logLevel %d", new Object[] { Integer.valueOf(paramInt1) });
    }
    for (;;)
    {
      buo.a().a("eas_ping", String.valueOf(paramInt2), g.l, 0L);
      return;
      cvm.a("Exchange", "ping finished: %s account %d status %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
      continue;
      cvm.b("Exchange", "ping finished: %s account %d status %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
      continue;
      cvm.c("Exchange", "ping finished: %s account %d status %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
      continue;
      cvm.d("Exchange", "ping finished: %s account %d status %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
      continue;
      cvm.e("Exchange", "ping finished: %s account %d status %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    }
  }
  
  private final void a(ArrayList<String> paramArrayList)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = Long.toString(g.D);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    new ArrayList();
    new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    if (cvm.a("Exchange", 3)) {
      localStringBuilder.append("EasPing requesting sync for folders: ");
    }
    paramArrayList = paramArrayList.iterator();
    label94:
    Object localObject;
    if (paramArrayList.hasNext())
    {
      localObject = (String)paramArrayList.next();
      arrayOfString[1] = localObject;
      if (cvm.a("Exchange", 3)) {
        localStringBuilder.append((String)localObject).append(",");
      }
      localObject = f.getContentResolver().query(Mailbox.a, Mailbox.z, "accountKey=? and serverId=?", arrayOfString, null);
      if (localObject == null) {}
    }
    for (;;)
    {
      long l;
      try
      {
        int i;
        if (((Cursor)localObject).moveToFirst())
        {
          l = ((Cursor)localObject).getLong(0);
          i = ((Cursor)localObject).getInt(5);
        }
        switch (i)
        {
        case 67: 
          cvm.e("Exchange", "unexpected collectiontype %d in EasPing", new Object[] { Integer.valueOf(i) });
        case 69: 
        case 70: 
        case 71: 
          ((Cursor)localObject).close();
          break label94;
        }
      }
      finally
      {
        ((Cursor)localObject).close();
      }
      localArrayList1.add(Long.valueOf(l));
      continue;
      localArrayList2.add(Long.valueOf(l));
      continue;
      localArrayList3.add(Long.valueOf(l));
      continue;
      if (cvm.a("Exchange", 3)) {
        cvm.b("Exchange", localStringBuilder.toString(), new Object[0]);
      }
      a(a, bdv.F, localArrayList1);
      a(a, "com.android.calendar", localArrayList2);
      a(a, "com.android.contacts", localArrayList3);
      return;
    }
  }
  
  public static void b(android.accounts.Account paramAccount, long paramLong)
  {
    Bundle localBundle = new Bundle(3);
    localBundle.putBoolean("__push_only__", true);
    localBundle.putBoolean("force", true);
    localBundle.putLong("PING_DELAY", paramLong);
    ContentResolver.requestSync(paramAccount, bdv.F, localBundle);
    cvm.c("Exchange", "requestPing EasOperation %s, %s", new Object[] { paramAccount, localBundle });
  }
  
  public static final boolean c(int paramInt)
  {
    return (paramInt == 100) || (paramInt == -2);
  }
  
  protected final int a(bns parambns)
  {
    if (parambns.e()) {
      throw new IOException("Empty ping response");
    }
    cvm.b("Exchange", "EasPing.handleResponse", new Object[0]);
    parambns = new bpd(parambns.d());
    parambns.d();
    int j = a;
    long l1 = g.D;
    long l2;
    switch (j)
    {
    default: 
      a(6, "Unexpected error", l1, j);
      return -99;
    case 1: 
      a(3, "ping expired", l1, j);
      b = Math.min(1680L, b + 300L);
      parambns = String.valueOf("increasePingDuration adjusting by 300s, new duration ");
      l1 = b;
      l2 = g.D;
      cvm.b("Exchange", String.valueOf(parambns).length() + 50 + parambns + l1 + "s account " + l2, new Object[0]);
      j();
      return 100;
    case 2: 
      a(3, "found changes", l1, j);
      if (a != 2) {}
      for (parambns = null;; parambns = b)
      {
        a(parambns);
        return 101;
      }
    case 3: 
    case 4: 
      a(6, "bad request", l1, j);
      return -101;
    case 5: 
      if (a != 5) {}
      for (int i = -1;; i = c)
      {
        l2 = i;
        cvm.d("Exchange", "Heartbeat out of bounds old duration %ds new duration %ds", new Object[] { Long.valueOf(b), Long.valueOf(l2) });
        a(4, "heartbeat out of bounds", l1, j);
        b = l2;
        j();
        return 100;
      }
    case 6: 
      a(6, "Too many folders", l1, j);
      return -101;
    case 7: 
      a(4, "FolderSync needed", l1, j);
      parambns = new Bundle(1);
      parambns.putBoolean("__account_only__", true);
      ContentResolver.requestSync(a, bdv.F, parambns);
      cvm.b("Exchange", "requestFolderSync EasPing %s, %s", new Object[] { a, parambns });
      return 101;
    case 8: 
      a(5, "Server error", l1, j);
      return -102;
    case 111: 
      a(5, "Retryable server error", l1, j);
      return -102;
    }
    a(6, "Authentication error", l1, j);
    return -7;
  }
  
  protected final String b()
  {
    return "Ping";
  }
  
  protected final HttpEntity c()
  {
    Cursor localCursor = Mailbox.a(f.getContentResolver(), g.D);
    if (localCursor == null) {
      try
      {
        throw new IllegalStateException("Could not read mailboxes");
      }
      finally
      {
        if (localCursor != null) {
          localCursor.close();
        }
      }
    }
    Object localObject2 = null;
    try
    {
      while (localCursor.moveToNext())
      {
        Mailbox localMailbox = new Mailbox();
        localMailbox.a(localCursor);
        if ((j != null) && (!j.equals("0")) && (ContentResolver.getSyncAutomatically(a, Mailbox.d(h))))
        {
          Object localObject3 = localObject2;
          if (localObject2 == null)
          {
            localObject3 = new bpi();
            ((bpi)localObject3).a(837);
            ((bpi)localObject3).b(840, Long.toString(b));
            ((bpi)localObject3).a(841);
          }
          ((bpi)localObject3).a(842);
          ((bpi)localObject3).b(843, d);
          ((bpi)localObject3).b(844, bnq.a(h));
          ((bpi)localObject3).b();
          localObject2 = localObject3;
        }
      }
    }
    finally
    {
      localCursor.close();
    }
    if (localbpi == null)
    {
      l();
      throw new IOException("No mailboxes want push");
    }
    localbpi.b().b().a();
    HttpEntity localHttpEntity = a(localbpi);
    if (localCursor != null) {
      localCursor.close();
    }
    return localHttpEntity;
  }
  
  public final void j()
  {
    ContentValues localContentValues = new ContentValues(1);
    if (g.p != b)
    {
      g.p = b;
      localContentValues.put("pingDuration", Long.valueOf(b));
      com.android.emailcommon.provider.Account.a(f, com.android.emailcommon.provider.Account.a, g.D, localContentValues);
    }
  }
  
  protected final boolean o()
  {
    return false;
  }
  
  protected final long p()
  {
    return b * 1000L + 5000L;
  }
  
  public final int p_()
  {
    return super.p_();
  }
}

/* Location:
 * Qualified Name:     bqi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */