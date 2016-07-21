import com.android.mail.providers.Conversation;
import java.util.Collection;

public final class cli
{
  public static final String a = cvl.a;
  boolean b = true;
  Conversation c;
  private final clj d;
  
  public cli(clj paramclj)
  {
    d = paramclj;
  }
  
  private final Conversation a(int paramInt)
  {
    Object localObject = d.e();
    ((bwg)localObject).moveToPosition(paramInt);
    localObject = ((bwg)localObject).m();
    C = paramInt;
    return (Conversation)localObject;
  }
  
  private static boolean a(bwg parambwg)
  {
    return (parambwg != null) && (!parambwg.isClosed());
  }
  
  private final boolean b()
  {
    return a(d.e());
  }
  
  final int a()
  {
    int j = -1;
    bwg localbwg = d.e();
    int i;
    if (!b) {
      i = c.C;
    }
    do
    {
      do
      {
        int k;
        do
        {
          do
          {
            do
            {
              do
              {
                return i;
                i = j;
              } while (localbwg == null);
              i = j;
            } while (c == null);
            b = false;
            k = localbwg.getCount();
            i = j;
          } while (!a(localbwg));
          i = j;
        } while (k == 0);
        i = localbwg.a(c.b);
        if (i >= 0)
        {
          c.C = i;
          localbwg.moveToPosition(i + 1);
          return i;
        }
        j = i;
        if (i >= k) {
          j = k - 1;
        }
        i = j;
      } while (!a(localbwg));
      i = j;
    } while (j < 0);
    cvm.b(a, "ConversationPositionTracker: Could not find conversation %s in the cursor. Moving to position %d ", new Object[] { c.toString(), Integer.valueOf(j) });
    localbwg.moveToPosition(j);
    c = new Conversation(localbwg);
    c.C = j;
    return j;
  }
  
  public final Conversation a(int paramInt, Collection<Conversation> paramCollection)
  {
    boolean bool1;
    boolean bool2;
    label16:
    Object localObject;
    if (paramInt == 2)
    {
      bool1 = true;
      if (paramInt != 1) {
        break label83;
      }
      bool2 = true;
      if (!bool1) {
        break label130;
      }
      paramInt = a();
      if ((b()) && (paramInt >= 0)) {
        break label89;
      }
      localObject = null;
    }
    for (;;)
    {
      cvm.b(a, "ConversationPositionTracker.getNextConversation: getNewer = %b, getOlder = %b, Next conversation is %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), localObject });
      return (Conversation)localObject;
      bool1 = false;
      break;
      label83:
      bool2 = false;
      break label16;
      label89:
      paramInt -= 1;
      for (;;)
      {
        if (paramInt < 0) {
          break label124;
        }
        Conversation localConversation = a(paramInt);
        localObject = localConversation;
        if (!Conversation.a(paramCollection, localConversation)) {
          break;
        }
        paramInt -= 1;
      }
      label124:
      localObject = null;
      continue;
      label130:
      if (bool2)
      {
        paramInt = a();
        if ((!b()) || (paramInt < 0))
        {
          localObject = null;
        }
        else
        {
          paramInt += 1;
          for (;;)
          {
            localObject = d.e();
            if (a((bwg)localObject)) {}
            for (int i = ((bwg)localObject).getCount();; i = 0)
            {
              if (paramInt >= i) {
                break label222;
              }
              localObject = a(paramInt);
              if (Conversation.a(paramCollection, (Conversation)localObject)) {
                break label215;
              }
              break;
            }
            label215:
            paramInt += 1;
          }
          label222:
          localObject = null;
        }
      }
      else
      {
        localObject = null;
      }
    }
  }
}

/* Location:
 * Qualified Name:     cli
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */