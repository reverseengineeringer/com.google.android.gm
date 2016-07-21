import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.RemoteException;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.AccountDirtyFlags;
import java.util.List;

final class dvv
  extends AsyncTask<Void, Void, Void>
{
  Context a;
  String b;
  List<dvw> c;
  
  private final Void a()
  {
    Object localObject2 = Account.a(a, b);
    if (localObject2 == null) {}
    do
    {
      do
      {
        return null;
        localObject3 = ((Account)localObject2).e(a);
      } while (localObject3 == null);
      localObject1 = new ContentValues();
      int j = c.size();
      int i = 0;
      while (i < j)
      {
        dvw localdvw = (dvw)c.get(i);
        if ((!localdvw.a((Account)localObject2)) && (!localdvw.a((AccountDirtyFlags)localObject3))) {
          localdvw.a((ContentValues)localObject1);
        }
        i += 1;
      }
    } while ((((ContentValues)localObject1).size() == 0) || (isCancelled()));
    Object localObject3 = ((Account)localObject2).g();
    localObject2 = ((Uri)localObject3).getAuthority();
    Object localObject1 = ContentProviderOperation.newUpdate((Uri)localObject3).withValues((ContentValues)localObject1).build();
    try
    {
      a.getContentResolver().applyBatch((String)localObject2, hgd.a(new ContentProviderOperation[] { localObject1 }));
      return null;
    }
    catch (RemoteException localRemoteException)
    {
      cvm.d(dvu.a, localRemoteException, "exception executing ApplySettingsTask", new Object[0]);
      return null;
    }
    catch (OperationApplicationException localOperationApplicationException)
    {
      for (;;) {}
    }
  }
}

/* Location:
 * Qualified Name:     dvv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */