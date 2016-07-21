import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import com.android.mail.providers.Conversation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class bwm
  extends ContentProvider
{
  public static String a;
  public static String b;
  ContentResolver c;
  int d = 0;
  final ArrayList<Uri> e = new ArrayList();
  cag f = null;
  
  static void a(Uri paramUri, bwg parambwg)
  {
    parambwg.a(bwg.b(paramUri), "__deleted__", Boolean.valueOf(false));
  }
  
  private final void a(Uri paramUri, cag paramcag)
  {
    if (bwg.a != d)
    {
      d = bwg.a;
      e.clear();
      f = paramcag;
    }
    e.add(paramUri);
  }
  
  public abstract String a();
  
  final void a(Uri paramUri, bwg parambwg, cag paramcag)
  {
    parambwg.a(bwg.b(paramUri), "__deleted__", Boolean.valueOf(true));
    a(paramUri, paramcag);
  }
  
  final void a(Conversation paramConversation, bwg parambwg, cag paramcag)
  {
    Uri localUri = c;
    String str = bwg.b(localUri);
    cvm.b("ConversationCursor", "[Mostly dead, deferring: %s] ", new Object[] { str });
    parambwg.a(str, "conversationFlags", Integer.valueOf(1));
    o |= 0x1;
    j.add(paramConversation);
    n = true;
    a(localUri, paramcag);
  }
  
  public int apply(Collection<bwl> paramCollection, bwg parambwg)
  {
    HashMap localHashMap = new HashMap();
    bwg.a += 1;
    Iterator localIterator = paramCollection.iterator();
    int i = 0;
    Object localObject;
    if (localIterator.hasNext())
    {
      bwl localbwl = (bwl)localIterator.next();
      Uri localUri = bwg.a(a);
      String str = localUri.getAuthority();
      localObject = (ArrayList)localHashMap.get(str);
      paramCollection = (Collection<bwl>)localObject;
      if (localObject == null)
      {
        paramCollection = new ArrayList();
        localHashMap.put(str, paramCollection);
      }
      localObject = localbwl.a(localUri);
      if (localObject != null) {
        paramCollection.add(localObject);
      }
      if (!b) {
        break label262;
      }
      i = 1;
    }
    label262:
    for (;;)
    {
      break;
      if (i != 0)
      {
        i = o;
        parambwg.moveToFirst();
        parambwg.moveToPosition(i);
      }
      parambwg.j();
      boolean bool = bwg.e();
      paramCollection = localHashMap.keySet().iterator();
      for (;;)
      {
        if (paramCollection.hasNext())
        {
          parambwg = (String)paramCollection.next();
          localObject = (ArrayList)localHashMap.get(parambwg);
          if (!bool) {}
        }
        try
        {
          c.applyBatch(parambwg, (ArrayList)localObject);
        }
        catch (RemoteException parambwg)
        {
          continue;
          new Thread(new bwn(this, parambwg, (ArrayList)localObject)).start();
          continue;
          return bwg.a;
        }
        catch (OperationApplicationException parambwg) {}
      }
    }
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    throw new IllegalStateException("Unexpected call to ConversationProvider.delete");
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    paramUri = new bwo(c, paramUri, paramContentValues);
    if (bwg.e()) {
      return (Uri)paramUri.a();
    }
    new Thread(paramUri).start();
    return null;
  }
  
  public boolean onCreate()
  {
    bwg.b = this;
    String str = a();
    a = str;
    b = String.valueOf(str).length() + 11 + "content://" + str + "/";
    c = getContext().getContentResolver();
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return c.query(bwg.a(paramUri), paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    throw new IllegalStateException("Unexpected call to ConversationProvider.update");
  }
}

/* Location:
 * Qualified Name:     bwm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */