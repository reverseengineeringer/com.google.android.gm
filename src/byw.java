import android.database.Cursor;
import android.os.Bundle;
import com.android.mail.browse.ConversationMessage;
import com.android.mail.providers.Conversation;

public final class byw
  extends ccy<ConversationMessage>
{
  public byx a;
  private Integer b;
  
  public byw(Cursor paramCursor)
  {
    super(paramCursor, ConversationMessage.b);
  }
  
  public final int a(int paramInt)
  {
    int i = 17;
    int j = -1;
    int k = getCount();
    for (;;)
    {
      j += 1;
      if ((!moveToPosition(j)) || (j >= k - paramInt)) {
        break;
      }
      i = i * 31 + a().b();
    }
    return i;
  }
  
  public final ConversationMessage a()
  {
    ConversationMessage localConversationMessage = (ConversationMessage)f();
    a = a;
    return localConversationMessage;
  }
  
  public final ConversationMessage a(long paramLong)
  {
    if (isClosed()) {
      return null;
    }
    int i = -1;
    ConversationMessage localConversationMessage;
    do
    {
      i += 1;
      if (!moveToPosition(i)) {
        break;
      }
      localConversationMessage = a();
    } while (paramLong != d);
    return localConversationMessage;
    return null;
  }
  
  public final Conversation b()
  {
    if (a != null) {
      return a.d();
    }
    return null;
  }
  
  public final boolean c()
  {
    int i = -1;
    do
    {
      i += 1;
      if (!moveToPosition(i)) {
        break;
      }
    } while (aB);
    return false;
    return true;
  }
  
  public final int d()
  {
    if (b != null) {
      return b.intValue();
    }
    b = Integer.valueOf(2);
    Bundle localBundle = getExtras();
    if ((localBundle != null) && (localBundle.containsKey("cursor_status"))) {
      b = Integer.valueOf(localBundle.getInt("cursor_status"));
    }
    return b.intValue();
  }
  
  public final boolean e()
  {
    return !chj.a(d());
  }
}

/* Location:
 * Qualified Name:     byw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */