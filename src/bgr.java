import android.accounts.Account;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.appdatasearch.CorpusStatus;
import com.google.android.gms.appdatasearch.QuerySpecification;
import com.google.android.gms.appdatasearch.RegisterCorpusInfo;
import com.google.android.gms.appdatasearch.SearchResults;
import com.google.android.gms.appdatasearch.Section;
import com.google.android.gms.appdatasearch.SuggestionResults;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.search.corpora.GetCorpusStatusCall.Response;
import com.google.android.gms.search.queries.QuerySuggestCall.Response;
import java.util.concurrent.TimeUnit;

public abstract class bgr
{
  private static final String b = cvl.a;
  private static int c;
  private static final Object d;
  private static final QuerySpecification f;
  public final Context a;
  private final eiz e;
  
  static
  {
    if (bhk.a()) {}
    for (int i = 1;; i = 0)
    {
      c = i;
      d = new Object();
      f = new eca().a(new Section("conversation")).a(new Section("body", true, 80)).a();
      return;
    }
  }
  
  public bgr(Context paramContext)
  {
    this(paramContext, new eja(paramContext).a(fyg.p).a(fyg.n).a());
  }
  
  private bgr(Context paramContext, eiz parameiz)
  {
    a = paramContext;
    e = parameiz;
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool = true;
    for (;;)
    {
      int i;
      synchronized (d)
      {
        if (c == 0)
        {
          if (cud.a(paramContext)) {
            c = 2;
          }
        }
        else
        {
          if (c != 1) {
            break label84;
          }
          return bool;
        }
        i = eik.a(paramContext);
        if (i == 0) {
          c = 1;
        }
      }
      c = 2;
      cvm.e(b, "Google play services not available: %d", new Object[] { Integer.valueOf(i) });
      continue;
      label84:
      bool = false;
    }
  }
  
  public abstract bgs a(SQLiteDatabase paramSQLiteDatabase, Account paramAccount);
  
  public QuerySpecification a()
  {
    return f;
  }
  
  public final SearchResults a(String paramString, Account arg2, int paramInt1, int paramInt2)
  {
    String str1 = RegisterCorpusInfo.a("messages", ???);
    Object localObject;
    eiz localeiz;
    String str2;
    QuerySpecification localQuerySpecification;
    synchronized (e)
    {
      localObject = e.a(10000L, TimeUnit.MILLISECONDS);
      if (!((ConnectionResult)localObject).b())
      {
        cvm.e(b, "Connection to search failed: %d", new Object[] { Integer.valueOf(c) });
        return null;
      }
    }
  }
  
  public final SuggestionResults a(String paramString, Account paramAccount)
  {
    synchronized (e)
    {
      Object localObject = e.a(10000L, TimeUnit.MILLISECONDS);
      if (!((ConnectionResult)localObject).b())
      {
        cvm.e(b, "Connection to search failed: %d", new Object[] { Integer.valueOf(c) });
        return null;
      }
      if (paramAccount == null) {
        paramAccount = null;
      }
      try
      {
        paramString = tae, paramString, a.getPackageName(), paramAccount, 20).a()).b;
        if ((paramString != null) && (!paramString.a())) {
          break label183;
        }
        cvm.e(b, "Error from suggestions: %s", new Object[] { b });
        e.d();
        return null;
      }
      finally
      {
        e.d();
      }
      localObject = new String[1];
      localObject[0] = RegisterCorpusInfo.a("messages", paramAccount);
      paramAccount = (Account)localObject;
    }
    label183:
    e.d();
    return paramString;
  }
  
  public final void b(SQLiteDatabase arg1, Account paramAccount)
  {
    String str1 = name;
    cvm.b(b, "AppDataSearch: Schedule indexing for %s", new Object[] { cvm.a(str1) });
    String str2 = RegisterCorpusInfo.a("messages", paramAccount);
    paramAccount = a(???, paramAccount);
    if (paramAccount == null)
    {
      cvm.d(b, "AppDataSearch: Search store not found for account %s", new Object[] { cvm.a(str1) });
      return;
    }
    long l1 = paramAccount.a();
    long l2 = paramAccount.b();
    Object localObject;
    synchronized (e)
    {
      localObject = e.a(30000L, TimeUnit.MILLISECONDS);
      if (!((ConnectionResult)localObject).b())
      {
        buo.a().a("index_scheduling", "failure", "connection_failure", 0L);
        cvm.e(b, "AppDataSearch: Connection to search failed: %d", new Object[] { Integer.valueOf(c) });
        return;
      }
    }
    try
    {
      cvm.b(b, "AppDataSearch: Getting status for %s", new Object[] { cvm.a(str1) });
      localObject = vae, a.getPackageName(), str2).a()).b;
      if ((localObject == null) || (!b))
      {
        buo.a().a("index_scheduling", "failure", "account_not_registered", 0L);
        cvm.e(b, "AppDataSearch: Account %s is not registered for search", new Object[] { cvm.a(str1) });
        e.d();
        return;
      }
      cvm.c(b, "AppDataSearch: minSeqNo=%d, maxSeqNo=%d, lastCommittedSequence=%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(d) });
      if (l1 <= d) {
        paramAccount.a(d);
      }
      fyg.v.a(e, a.getPackageName(), str2, l2);
      buo.a().a("index_scheduling", "success", null, 0L);
      e.d();
      return;
    }
    finally
    {
      e.d();
    }
  }
}

/* Location:
 * Qualified Name:     bgr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */