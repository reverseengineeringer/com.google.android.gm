import android.content.ContentResolver;
import android.content.Context;
import android.content.Loader;
import android.content.Loader.ForceLoadContentObserver;
import android.database.Cursor;
import android.text.TextUtils;
import com.android.email.provider.EmailProvider;
import com.android.emailcommon.provider.Policy;
import com.android.mail.providers.Folder;
import com.android.mail.providers.Settings;
import java.util.HashMap;
import java.util.Map;

public final class atd
  extends cot<Map<String, Object>>
{
  private final Loader<Map<String, Object>>.ForceLoadContentObserver a = new Loader.ForceLoadContentObserver(this);
  private final String b;
  private final long c;
  
  atd(Context paramContext, String paramString, long paramLong)
  {
    super(paramContext);
    b = paramString;
    c = paramLong;
  }
  
  private final Map<String, Object> a()
  {
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(b)) {}
    for (Object localObject1 = com.android.emailcommon.provider.Account.a(getContext(), b, a); localObject1 == null; localObject1 = com.android.emailcommon.provider.Account.a(getContext(), c, a)) {
      return localHashMap;
    }
    localHashMap.put("account", localObject1);
    ((com.android.emailcommon.provider.Account)localObject1).d(getContext());
    ((com.android.emailcommon.provider.Account)localObject1).c(getContext());
    if (t == null) {
      return localHashMap;
    }
    v = Policy.a(getContext(), o, a);
    localObject1 = getContext().getContentResolver().query(EmailProvider.a("uiaccount", D), chh.c, null, null, null);
    if (localObject1 != null)
    {
      localHashMap.put("uiAccountCursor", localObject1);
      ((Cursor)localObject1).registerContentObserver(a);
      if (!((Cursor)localObject1).moveToFirst()) {
        return localHashMap;
      }
    }
    else
    {
      return localHashMap;
    }
    com.android.mail.providers.Account.b();
    localObject1 = cfw.a((Cursor)localObject1);
    localHashMap.put("uiAccount", localObject1);
    localObject1 = getContext().getContentResolver().query(z.i, chh.i, null, null, null);
    if (localObject1 != null) {}
    try
    {
      if (((Cursor)localObject1).moveToFirst())
      {
        Folder localFolder = new Folder((Cursor)localObject1);
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
        localHashMap.put("inbox", localFolder);
        return localHashMap;
      }
      return localHashMap;
    }
    finally
    {
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
    }
  }
}

/* Location:
 * Qualified Name:     atd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */