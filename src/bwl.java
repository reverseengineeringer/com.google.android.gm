import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentValues;
import android.net.Uri;
import android.net.Uri.Builder;
import com.android.mail.providers.Conversation;
import java.util.Iterator;
import java.util.Set;

public final class bwl
{
  final Uri a;
  boolean b = true;
  private final int d;
  private final Conversation e;
  private final ContentValues f;
  private final cag g;
  private final boolean h;
  private final boolean i;
  
  public bwl(bwg parambwg, int paramInt, Conversation paramConversation, ContentValues paramContentValues, cag paramcag)
  {
    d = paramInt;
    a = c;
    e = paramConversation;
    f = paramContentValues;
    g = paramcag;
    h = D;
    i = paramConversation.b();
  }
  
  public bwl(bwg parambwg, int paramInt, Conversation paramConversation, cag paramcag)
  {
    this(parambwg, paramInt, paramConversation, null, paramcag);
  }
  
  final ContentProviderOperation a(Uri paramUri)
  {
    Uri localUri = paramUri.buildUpon().appendQueryParameter("seq", Integer.toString(bwg.a)).build();
    switch (d)
    {
    default: 
      int j = d;
      throw new UnsupportedOperationException(47 + "No such ConversationOperation type: " + j);
    case 2: 
      if (h) {
        bwg.b.a(a, c, g);
      }
      while (!i)
      {
        return ContentProviderOperation.newUpdate(localUri).withValues(f).build();
        Object localObject = a;
        paramUri = f;
        bwg localbwg = c;
        if (paramUri != null)
        {
          localObject = bwg.b((Uri)localObject);
          Iterator localIterator = paramUri.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            localbwg.a((String)localObject, str, paramUri.get(str));
          }
        }
        b = false;
      }
      paramUri = e;
      c.a(paramUri);
      return null;
    case 130: 
      bwg.b.a(e, c, g);
      return ContentProviderOperation.newUpdate(localUri).withValues(f).build();
    case 1: 
      return ContentProviderOperation.newInsert(localUri).withValues(f).build();
    case 0: 
      bwg.b.a(a, c, g);
      if (!i) {
        return ContentProviderOperation.newDelete(localUri).build();
      }
      paramUri = e;
      c.a(paramUri);
      return null;
    case 128: 
      bwg.b.a(e, c, g);
      return ContentProviderOperation.newDelete(localUri).build();
    case 3: 
      bwg.b.a(a, c, g);
      if (!i) {
        return ContentProviderOperation.newUpdate(localUri).withValue("operation", "archive").build();
      }
      paramUri = e;
      c.a(paramUri);
      return null;
    case 131: 
      bwg.b.a(e, c, g);
      return ContentProviderOperation.newUpdate(localUri).withValue("operation", "archive").build();
    case 4: 
      if (h) {
        bwg.b.a(a, c, g);
      }
      return ContentProviderOperation.newUpdate(localUri).withValue("operation", "mute").build();
    case 5: 
    case 6: 
      bwg.b.a(a, c, g);
      if (d == 5) {}
      for (paramUri = "report_spam";; paramUri = "report_not_spam") {
        return ContentProviderOperation.newUpdate(localUri).withValue("operation", paramUri).build();
      }
    case 7: 
      bwg.b.a(a, c, g);
      return ContentProviderOperation.newUpdate(localUri).withValue("operation", "discard_drafts").build();
    }
    bwg.b.a(a, c, g);
    return ContentProviderOperation.newUpdate(localUri).withValue("operation", "discard_outbox").build();
  }
}

/* Location:
 * Qualified Name:     bwl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */