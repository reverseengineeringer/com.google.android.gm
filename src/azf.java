import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.RemoteException;
import com.android.email.provider.EmailProvider;
import com.android.emailcommon.provider.Mailbox;
import com.android.emailcommon.service.SearchParams;
import java.util.Locale;

public final class azf
  extends AsyncTask<Void, Void, Void>
{
  public azf(EmailProvider paramEmailProvider, Context paramContext, long paramLong1, SearchParams paramSearchParams, long paramLong2) {}
  
  private final Void a()
  {
    int i = 2;
    Object localObject = bam.a(a, b);
    if (localObject != null) {}
    for (;;)
    {
      try
      {
        localObject = ((ber)localObject).a(b, c, d);
        int j = ((Bundle)localObject).getInt("search_total_results", 0);
        int k = ((Bundle)localObject).getInt("search_status", 0);
        switch (k)
        {
        case 1: 
        case 2: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        case 26: 
        case 27: 
        case 28: 
        case 29: 
        case 30: 
        case 31: 
          cvm.d(bbw.a, "Unexpected EmailServiceStatus %d", new Object[] { Integer.valueOf(k) });
          i = 6;
        case 22: 
        case 25: 
          buo.a().a("sync_result", String.valueOf(i), String.format(Locale.US, "searchMessage:%d", new Object[] { Integer.valueOf(k) }), 0L);
          cvm.b(EmailProvider.a, "status %d in runSearchQuery", new Object[] { Integer.valueOf(i) });
          localObject = new ContentValues(2);
          ((ContentValues)localObject).put("totalCount", Integer.valueOf(j));
          ((ContentValues)localObject).put("uiLastSyncResult", Integer.valueOf(i));
          e.update(ContentUris.withAppendedId(Mailbox.a, d), (ContentValues)localObject, null, null);
          cvm.b(EmailProvider.a, "EmailProvider#runSearchQuery. TotalCount to UI: %d", new Object[] { Integer.valueOf(j) });
          return null;
        }
      }
      catch (RemoteException localRemoteException)
      {
        cvm.e("searchMessages", localRemoteException, "RemoteException", new Object[0]);
        return null;
      }
      i = 0;
      continue;
      i = 5;
      continue;
      i = 10;
      continue;
      i = 3;
      continue;
      i = 1;
      continue;
      i = 11;
    }
  }
}

/* Location:
 * Qualified Name:     azf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */