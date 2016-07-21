import android.text.TextUtils;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.google.android.gm.provider.Advertisement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class dhx
  extends cpn
{
  private final int a;
  private int b;
  private int c;
  
  public dhx(int paramInt)
  {
    a = paramInt;
  }
  
  private static drp a(Account paramAccount)
  {
    if ((paramAccount == null) || (c == null)) {
      return null;
    }
    return drp.a(c);
  }
  
  private final void a(Account paramAccount, Folder paramFolder, Collection<Conversation> paramCollection, int paramInt1, int paramInt2, cqp paramcqp, long paramLong)
  {
    if (paramInt1 == dfy.as)
    {
      paramInt1 = 1;
      if (paramInt1 != 0) {
        break label51;
      }
    }
    label51:
    ArrayList localArrayList;
    do
    {
      do
      {
        return;
        if (paramInt1 == dfy.K)
        {
          paramInt1 = 2;
          break;
        }
        if (paramInt1 == dfy.bO)
        {
          paramInt1 = 3;
          break;
        }
        paramInt1 = 0;
        break;
        paramAccount = a(paramAccount);
      } while (!a(paramFolder, paramAccount, true));
      localArrayList = new ArrayList();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Conversation localConversation = (Conversation)paramCollection.next();
        int i = paramcqp.a(localConversation);
        i -= paramcqp.a(i);
        if (i < a) {
          localArrayList.add(new dui(localConversation, i));
        }
      }
    } while (localArrayList.size() <= 0);
    paramAccount.a(new duh(Advertisement.a(paramFolder), 4L, paramLong, b, localArrayList, null, null, null, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), null));
  }
  
  private static boolean a(Folder paramFolder, drp paramdrp, boolean paramBoolean)
  {
    if (paramdrp == null) {
      return false;
    }
    String str = o.d();
    int i;
    if ((TextUtils.isEmpty(str)) || ("google.com".equals(str)))
    {
      i = 1;
      label35:
      if ((i == 0) || (!dhw.a(paramFolder)) || (!paramdrp.a(paramFolder))) {
        break label85;
      }
    }
    label85:
    for (boolean bool = true;; bool = false)
    {
      if (!paramBoolean) {
        break label91;
      }
      if ((!bool) || (!v.k())) {
        break;
      }
      return true;
      i = 0;
      break label35;
    }
    label91:
    return bool;
  }
  
  public final void a(int paramInt)
  {
    b = paramInt;
  }
  
  public final void a(Account paramAccount, Folder paramFolder, Conversation paramConversation)
  {
    if (c >= a) {}
    do
    {
      return;
      paramAccount = a(paramAccount);
    } while (!a(paramFolder, paramAccount, true));
    int i = Advertisement.a(paramFolder);
    int j = b;
    long l = b;
    paramAccount.a(new duh(i, 5L, System.currentTimeMillis(), j, null, Long.valueOf(l), null, null, Integer.valueOf(1), null, null));
  }
  
  public final void a(Account paramAccount, Folder paramFolder, Conversation paramConversation, int paramInt)
  {
    c = paramInt;
    if (paramInt >= a) {}
    do
    {
      return;
      paramAccount = a(paramAccount);
    } while (!a(paramFolder, paramAccount, false));
    int i = Advertisement.a(paramFolder);
    int j = b;
    long l = b;
    boolean bool = j;
    paramAccount.a(new duh(i, 2L, System.currentTimeMillis(), j, null, Long.valueOf(l), Integer.valueOf(paramInt), Boolean.valueOf(bool), null, null, null));
  }
  
  public final void a(Account paramAccount, Folder paramFolder, Conversation paramConversation, long paramLong, int paramInt, cqp paramcqp)
  {
    a(paramAccount, paramFolder, Conversation.a(paramConversation), paramInt, 2, paramcqp, paramLong);
  }
  
  public final void a(Account paramAccount, Folder paramFolder, Conversation paramConversation, String paramString)
  {
    if (c >= a) {}
    do
    {
      return;
      paramAccount = a(paramAccount);
    } while (!a(paramFolder, paramAccount, true));
    int i = Advertisement.a(paramFolder);
    int j = b;
    long l = b;
    paramAccount.a(new duh(i, 3L, System.currentTimeMillis(), j, null, Long.valueOf(l), null, null, null, null, paramString));
  }
  
  public final void a(Account paramAccount, Folder paramFolder, Collection<Conversation> paramCollection, boolean paramBoolean, long paramLong, int paramInt, cqp paramcqp)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 3)
    {
      a(paramAccount, paramFolder, paramCollection, paramInt, i, paramcqp, paramLong);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     dhx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */