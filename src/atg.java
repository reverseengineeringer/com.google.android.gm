import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.Policy;

public final class atg
{
  public static void a(Context paramContext, Account paramAccount)
  {
    int i = 0;
    if (!paramAccount.h())
    {
      paramAccount.h(paramContext);
      Object localObject2;
      long l;
      if (v != null)
      {
        if (v.w != null)
        {
          localObject2 = cvm.a;
          localObject1 = String.valueOf(v.w);
          if (((String)localObject1).length() == 0) {
            break label209;
          }
          localObject1 = "Clearing unsupported policies ".concat((String)localObject1);
          cvm.b((String)localObject2, (String)localObject1, new Object[0]);
          v.w = null;
        }
        l = D;
        localObject2 = v;
        if (m != null) {
          break label223;
        }
      }
      label209:
      label223:
      for (localObject1 = "";; localObject1 = m)
      {
        bfh.a(paramContext, l, (Policy)localObject2, (String)localObject1, false);
        localObject1 = paramContext.getResources().getStringArray(aqz.f);
        localObject2 = new ContentValues();
        ((ContentValues)localObject2).put("accountKey", Long.valueOf(D));
        paramAccount = paramContext.getContentResolver();
        int j = localObject1.length;
        while (i < j)
        {
          CharSequence localCharSequence = localObject1[i];
          if (!TextUtils.isEmpty(localCharSequence))
          {
            ((ContentValues)localObject2).put("quickResponse", localCharSequence);
            paramAccount.insert(bek.a, (ContentValues)localObject2);
          }
          i += 1;
        }
        localObject1 = new String("Clearing unsupported policies ");
        break;
      }
    }
    Object localObject1 = new ContentValues();
    ((ContentValues)localObject1).put("displayName", c);
    ((ContentValues)localObject1).put("senderName", k);
    ((ContentValues)localObject1).put("signature", n);
    ((ContentValues)localObject1).put("syncInterval", Integer.valueOf(g));
    ((ContentValues)localObject1).put("flags", Integer.valueOf(j));
    ((ContentValues)localObject1).put("syncLookback", Integer.valueOf(f));
    ((ContentValues)localObject1).put("securitySyncKey", m);
    ((ContentValues)localObject1).put("maxAttachmentSize", Long.valueOf(q));
    ((ContentValues)localObject1).put("sendingCapabilities", Long.valueOf(r));
    paramAccount.a(paramContext, (ContentValues)localObject1);
    ayh.a(paramContext);
  }
}

/* Location:
 * Qualified Name:     atg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */