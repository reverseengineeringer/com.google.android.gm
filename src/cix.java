import android.content.ContentValues;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.providers.FolderList;
import com.android.mail.ui.ConversationCheckedSet;
import com.android.mail.ui.FolderOperation;
import com.android.mail.ui.toastbar.ToastBarOperation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

final class cix
  implements cmx
{
  private final Collection<Conversation> b;
  private final ArrayList<FolderOperation> c = new ArrayList();
  private final boolean d;
  private boolean e;
  private final boolean f;
  private final boolean g;
  private final int h;
  private final Folder i;
  private cag j;
  private final ctk k;
  
  private cix(Collection<Conversation> paramCollection, Collection<FolderOperation> paramCollection1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, Folder paramFolder)
  {
    b = hef.a(paramCollection1);
    c.addAll(paramBoolean1);
    d = paramBoolean2;
    f = paramBoolean3;
    g = paramInt;
    h = paramFolder;
    Folder localFolder;
    i = localFolder;
    if (g) {}
    for (paramCollection = new cib(paramCollection, b, false, h);; paramCollection = null)
    {
      k = paramCollection;
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
    //   5: getfield 76	cix:e	Z
    //   8: istore_2
    //   9: iload_2
    //   10: ifeq +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 76	cix:e	Z
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
    //   0	32	0	this	cix
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
    if (c()) {}
    label261:
    do
    {
      return;
      Object localObject1;
      if ((d) && (g) && (b.size() > 0))
      {
        localObject1 = new ToastBarOperation(1, h, b.size(), i, k);
        a.a_((ToastBarOperation)localObject1);
      }
      ArrayList localArrayList1 = new ArrayList();
      Iterator localIterator = b.iterator();
      while (localIterator.hasNext())
      {
        Conversation localConversation = (Conversation)localIterator.next();
        Object localObject2 = Folder.a(n.a);
        ArrayList localArrayList2 = new ArrayList();
        ArrayList localArrayList3 = new ArrayList();
        if (d) {
          D = true;
        }
        Object localObject3 = c.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (FolderOperation)((Iterator)localObject3).next();
          localArrayList2.add(b.c.b);
          if (c) {}
          for (localObject1 = Boolean.TRUE;; localObject1 = Boolean.FALSE)
          {
            localArrayList3.add(localObject1);
            if (!c) {
              break label261;
            }
            ((HashMap)localObject2).put(b.c.b, b);
            break;
          }
          ((HashMap)localObject2).remove(b.c.b);
        }
        localObject1 = a.u;
        localObject2 = ((HashMap)localObject2).values();
        localObject3 = j;
        Object localObject4 = new ContentValues();
        bwg.a(localArrayList2, localArrayList3, (ContentValues)localObject4);
        bwg.a((Collection)localObject2, (ContentValues)localObject4);
        localArrayList1.add(((bwg)localObject1).a(localConversation, 2, (ContentValues)localObject4, (cag)localObject3));
      }
      if (a.u != null) {
        a.u.apply(localArrayList1);
      }
      a.ab();
    } while (!f);
    a.B.a();
  }
  
  public final void a(cag paramcag)
  {
    j = paramcag;
  }
  
  public final int b()
  {
    return h;
  }
}

/* Location:
 * Qualified Name:     cix
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */