import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.android.mail.providers.Conversation;
import java.util.Collection;
import java.util.Iterator;

final class cii
  implements DialogInterface.OnClickListener
{
  cii(cht paramcht, Collection paramCollection, boolean paramBoolean, cag paramcag) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == -1)
    {
      paramDialogInterface = d;
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
      d.a(a, cht.a(d, buc.ee, a, b, c), b);
    }
    for (;;)
    {
      d.a(null, -1);
      return;
      if (paramInt == -2) {
        d.a(a, cht.a(d, buc.ea, a, b, c), b);
      }
    }
  }
}

/* Location:
 * Qualified Name:     cii
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */