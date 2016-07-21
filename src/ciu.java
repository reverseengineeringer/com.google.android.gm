import android.os.Handler;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.ui.ConversationCheckedSet;
import java.util.Collection;
import java.util.Iterator;

public final class ciu
  implements cmx
{
  final int a;
  final Collection<Conversation> b;
  cag c;
  final ctk d;
  private boolean f;
  private final boolean g;
  
  public ciu(int paramInt, Collection<Conversation> paramCollection, boolean paramBoolean)
  {
    a = paramCollection;
    b = hef.a(paramBoolean);
    g = bool;
    paramBoolean = b;
    if (!g) {}
    for (boolean bool = true;; bool = false)
    {
      d = new cib(paramInt, paramBoolean, bool, a);
      return;
    }
  }
  
  /* Error */
  private final boolean c()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 51	ciu:f	Z
    //   8: istore_2
    //   9: iload_2
    //   10: ifeq +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 51	ciu:f	Z
    //   22: iconst_0
    //   23: istore_1
    //   24: goto -11 -> 13
    //   27: astore_3
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_3
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	ciu
    //   1	23	1	bool1	boolean
    //   8	2	2	bool2	boolean
    //   27	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	27	finally
    //   17	22	27	finally
  }
  
  public final void a()
  {
    if (c()) {
      return;
    }
    if (cvm.a(cht.I, 3)) {
      cvm.b(cht.I, "ConversationAction.performAction():\nmTarget=%s\nCurrent=%s", new Object[] { Conversation.a(b), e.l });
    }
    if (e.u == null)
    {
      cvm.e(cht.I, "null ConversationCursor in ConversationAction.performAction():\nmTarget=%s\nCurrent=%s", new Object[] { Conversation.a(b), e.l });
      return;
    }
    int i;
    if (a == buc.x)
    {
      cvm.b(cht.I, "ConversationAction.performAction: Archiving, isBatch=%b", new Object[] { Boolean.valueOf(g) });
      e.u.a(b, 3, c);
      i = 1;
    }
    for (;;)
    {
      if ((i != 0) && (b.size() > 0)) {
        e.n.postDelayed(new civ(this), e.M);
      }
      e.ab();
      if (!g) {
        break;
      }
      e.B.a();
      return;
      if (a == buc.aV)
      {
        cvm.b(cht.I, "ConversationAction.performAction: Deleting, isBatch=%b", new Object[] { Boolean.valueOf(g) });
        e.u.a(b, 0, c);
        if (e.d.a(256)) {
          i = 0;
        }
      }
      else
      {
        Iterator localIterator;
        if (a == buc.cX)
        {
          cvm.b(cht.I, "Muting", new Object[0]);
          if (e.d.a(32))
          {
            localIterator = b.iterator();
            while (localIterator.hasNext()) {
              nextD = true;
            }
          }
          e.u.a(b, 4, c);
          i = 1;
          continue;
        }
        if ((a == buc.ea) || (a == buc.ee))
        {
          cvm.b(cht.I, "Reporting spam", new Object[0]);
          e.u.a(b, 5, c);
          i = 1;
          continue;
        }
        if (a == buc.cC)
        {
          cvm.b(cht.I, "Marking not spam", new Object[0]);
          e.u.a(b, 6, c);
          i = 1;
          continue;
        }
        if (a == buc.dQ)
        {
          cvm.b(cht.I, "Removing star", new Object[0]);
          e.u.a(b, "starred", false);
          i = 1;
          continue;
        }
        if (a == buc.cB)
        {
          cvm.b(cht.I, "Marking not-important", new Object[0]);
          if ((e.d != null) && (e.d.a(128)))
          {
            localIterator = b.iterator();
            while (localIterator.hasNext()) {
              nextD = true;
            }
          }
          e.u.a(b, "importance", 0);
          i = 1;
          continue;
        }
        if (a == buc.ba)
        {
          cvm.b(cht.I, "Discarding draft messages", new Object[0]);
          if ((e.d != null) && (e.d.d(4)))
          {
            localIterator = b.iterator();
            while (localIterator.hasNext()) {
              nextD = true;
            }
          }
          e.u.b(b);
          i = 0;
          continue;
        }
        if (a == buc.bb)
        {
          cvm.b(cht.I, "Discarding messages in Outbox", new Object[0]);
          e.u.c(b);
          i = 0;
          continue;
        }
      }
      i = 1;
    }
  }
  
  public final void a(cag paramcag)
  {
    c = paramcag;
  }
  
  public final int b()
  {
    return a;
  }
}

/* Location:
 * Qualified Name:     ciu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */