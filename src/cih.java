import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.android.mail.providers.Conversation;
import java.util.Collection;
import java.util.Iterator;

final class cih
  implements DialogInterface.OnClickListener
{
  cih(cht paramcht, Collection paramCollection) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = b;
    Object localObject = a;
    ContentValues localContentValues = new ContentValues(2);
    localContentValues.put("unsubscribeState", Integer.valueOf(3));
    localObject = ((Collection)localObject).iterator();
    int i;
    for (paramInt = 0; ((Iterator)localObject).hasNext(); paramInt = i)
    {
      Conversation localConversation = (Conversation)((Iterator)localObject).next();
      i = paramInt;
      if (localConversation.f())
      {
        i = paramInt + 1;
        localContentValues.put("unsubscribeSenderIdentifier", z);
        paramDialogInterface.a(Conversation.a(localConversation), localContentValues);
      }
    }
    cvm.c(cht.I, "Unsubscribed %d conversations", new Object[] { Integer.valueOf(paramInt) });
    b.a(null, -1);
  }
}

/* Location:
 * Qualified Name:     cih
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */