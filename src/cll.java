import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import com.android.mail.browse.ConversationMessage;
import com.android.mail.providers.Conversation;
import java.util.Collection;
import java.util.Set;

public abstract interface cll
  extends cky
{
  public abstract cmx a(boolean paramBoolean, cag paramcag);
  
  public abstract void a(int paramInt, boolean paramBoolean, cag paramcag);
  
  public abstract void a(ConversationMessage paramConversationMessage, boolean paramBoolean);
  
  public abstract void a(Conversation paramConversation, Set<Uri> paramSet, byte[] paramArrayOfByte);
  
  public abstract void a(Collection<Conversation> paramCollection);
  
  public abstract void a(Collection<Conversation> paramCollection, cmx paramcmx, boolean paramBoolean);
  
  public abstract void a(Collection<Conversation> paramCollection, String paramString, int paramInt);
  
  public abstract void a(Collection<Conversation> paramCollection, String paramString, boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void a(Collection<Conversation> paramCollection, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract boolean a(Conversation paramConversation);
  
  public abstract void ab();
  
  public abstract DialogInterface.OnClickListener ad();
  
  public abstract cmx b(int paramInt);
  
  public abstract void b(ConversationMessage paramConversationMessage, boolean paramBoolean);
  
  public abstract cmx c(int paramInt);
}

/* Location:
 * Qualified Name:     cll
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */