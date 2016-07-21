import android.accounts.Account;
import android.content.Context;
import android.database.Cursor;
import com.google.android.gm.provider.GmailProvider;
import com.google.android.gm.provider.MailProvider;
import com.google.android.gms.appdatasearch.SuggestionResults;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class dgn
  extends chf
{
  static final String[] f = { "_id", "suggest_text_1", "suggest_intent_query", "suggest_icon_1" };
  String g = null;
  
  public dgn(Context paramContext)
  {
    super(paramContext);
    paramContext = String.valueOf("android.resource://");
    String str = String.valueOf(b.getPackageName());
    int i = dfx.d;
    g = (String.valueOf(paramContext).length() + 12 + String.valueOf(str).length() + paramContext + str + "/" + i);
  }
  
  public final Cursor a(String paramString)
  {
    Object localObject3 = super.a(paramString);
    if ((MailProvider.a() != null) && (paramString != null))
    {
      dgo localdgo = new dgo(this, f);
      Object localObject2 = paramString.trim();
      int i = 0;
      paramString = null;
      HashSet localHashSet = new HashSet();
      Object localObject4;
      if (localObject3 != null)
      {
        localObject4 = Integer.toString(dfx.y);
        while (((Cursor)localObject3).moveToNext())
        {
          String str1 = ((Cursor)localObject3).getString(1);
          String str2 = ((Cursor)localObject3).getString(2);
          String str3 = ((Cursor)localObject3).getString(3);
          if (str3.endsWith((String)localObject4))
          {
            if (!localHashSet.contains(str1))
            {
              localHashSet.add(str1);
              localdgo.addRow(new Object[] { Integer.valueOf(i), str1, str2, str3 });
              i += 1;
            }
          }
          else
          {
            localObject1 = paramString;
            if (paramString == null) {
              localObject1 = new ArrayList();
            }
            ((List)localObject1).add(new dgp(str1, str2, str3));
            paramString = (String)localObject1;
          }
        }
        ((Cursor)localObject3).close();
      }
      for (Object localObject1 = paramString;; localObject1 = null)
      {
        localObject3 = MailProvider.a();
        int j;
        if (GmailProvider.c != null)
        {
          paramString = new Account(GmailProvider.c, "com.google");
          j = i;
          if (paramString == null) {
            break label441;
          }
          paramString = ((bgr)localObject3).a((String)localObject2, paramString);
          j = i;
          if (paramString == null) {
            break label441;
          }
          localObject4 = paramString.iterator();
          label276:
          if (!((Iterator)localObject4).hasNext()) {
            break label439;
          }
          paramString = (ecp)((Iterator)localObject4).next();
          localObject2 = b;
          j = a;
          localObject3 = c[j];
          if (localHashSet.contains(localObject3)) {
            break label557;
          }
          localObject2 = b;
          j = a;
          if (d[j] != null) {
            break label428;
          }
          paramString = c[j];
          label358:
          localObject2 = paramString;
          if (paramString == null) {
            localObject2 = localObject3;
          }
          localHashSet.add(localObject3);
          localdgo.addRow(new Object[] { Integer.valueOf(i), localObject2, localObject3, a.g });
          i += 1;
        }
        label428:
        label439:
        label441:
        label554:
        label557:
        for (;;)
        {
          break label276;
          paramString = null;
          break;
          paramString = d[j];
          break label358;
          j = i;
          if (localObject1 != null)
          {
            paramString = ((List)localObject1).iterator();
            i = j;
            if (paramString.hasNext())
            {
              localObject1 = (dgp)paramString.next();
              if (localHashSet.contains(a)) {
                break label554;
              }
              localHashSet.add(a);
              localdgo.addRow(new Object[] { Integer.valueOf(i), a, b, c });
              i += 1;
            }
          }
          for (;;)
          {
            break;
            return localdgo;
          }
        }
        i = 0;
      }
    }
    return (Cursor)localObject3;
  }
}

/* Location:
 * Qualified Name:     dgn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */