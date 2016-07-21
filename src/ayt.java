import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.util.Rfc822Token;
import android.text.util.Rfc822Tokenizer;
import com.android.email.provider.EmailProvider;
import com.android.emailcommon.mail.Address;
import com.android.emailcommon.provider.Mailbox;
import com.android.mail.providers.ConversationInfo;
import com.android.mail.providers.Folder;
import com.android.mail.providers.FolderList;
import com.android.mail.providers.ParticipantInfo;
import java.util.ArrayList;

public final class ayt
  extends CursorWrapper
  implements bwv
{
  final long a;
  final Context b;
  private final int c;
  private final FolderList d;
  private final Bundle e = new Bundle();
  private final int f;
  
  public ayt(Context paramContext, Cursor paramCursor, Folder paramFolder, long paramLong)
  {
    super(paramCursor);
    a = paramLong;
    b = paramContext;
    d = FolderList.a(hgd.a(new Folder[] { paramFolder }));
    paramContext = Mailbox.a(paramContext, paramLong);
    f = getColumnIndex("threadSendingState");
    if (paramContext != null)
    {
      c = h;
      e.putInt("cursor_total_count", t);
      if ((r == 4) || (r == 1) || (r == 2) || (r == 8))
      {
        e.putInt("cursor_status", 1);
        return;
      }
      if (r == 0)
      {
        i = chh.b(s);
        if (i != 0)
        {
          cvm.d(cvl.a, "mailbox#%d sync didn't succeed: %d", new Object[] { Long.valueOf(paramContext.c()), Integer.valueOf(i) });
          e.putInt("cursor_status", 4);
          return;
        }
        if ((l == 0) && ((Mailbox.b(h)) || (h == 8)) && (!TextUtils.isEmpty(d)) && (System.currentTimeMillis() - m > 300000L))
        {
          e.putInt("cursor_status", 1);
          return;
        }
        e.putInt("cursor_status", 8);
        return;
      }
      paramCursor = bbw.a;
      i = r;
      cvm.b(paramCursor, 38 + "Unknown mailbox sync status" + i, new Object[0]);
      e.putInt("cursor_status", 8);
      return;
    }
    c = -1;
    paramContext = e;
    if (paramCursor != null) {
      i = paramCursor.getCount();
    }
    paramContext.putInt("cursor_total_count", i);
    e.putInt("cursor_status", 8);
  }
  
  private final ConversationInfo c()
  {
    ConversationInfo localConversationInfo = new ConversationInfo(getInt(getColumnIndex("numMessages")));
    d = getString(getColumnIndex("snippet"));
    e = d;
    c = getInt(9);
    boolean bool;
    Object localObject2;
    Object localObject1;
    if (getInt(getColumnIndex("read")) != 0)
    {
      bool = true;
      localObject2 = getString(getColumnIndex("displayName"));
      localObject1 = getString(getColumnIndex("fromList"));
      if (localObject1 == null) {
        break label159;
      }
      Rfc822Token[] arrayOfRfc822Token = Rfc822Tokenizer.tokenize((CharSequence)localObject1);
      if (arrayOfRfc822Token.length <= 0) {
        break label143;
      }
      localObject1 = arrayOfRfc822Token[0].getAddress();
    }
    for (;;)
    {
      if (c != 3) {
        break label165;
      }
      c = 1;
      return localConversationInfo;
      bool = false;
      break;
      label143:
      cvm.b(cvm.a, "Couldn't parse sender email address", new Object[0]);
      continue;
      label159:
      localObject1 = null;
    }
    label165:
    int j;
    int i;
    if (getColumnIndex("threadReadFlag") >= 0)
    {
      localObject1 = new ayj(this);
      j = 0;
      i = 0;
      label188:
      if (j < a.size())
      {
        localObject2 = (ayl)a.get(j);
        localConversationInfo.a(new ParticipantInfo(a, b, 0, d, 0));
        if ((i != 0) || (d)) {
          break label403;
        }
        d = c;
        i = 1;
      }
    }
    label403:
    for (;;)
    {
      e = c;
      j += 1;
      break label188;
      if (i != 0) {
        break;
      }
      d = e;
      return localConversationInfo;
      if ((c == 5) || (c == 4))
      {
        localObject1 = Address.d(getString(getColumnIndex("toList")));
        j = localObject1.length;
        i = 0;
        while (i < j)
        {
          localObject2 = localObject1[i];
          localConversationInfo.a(new ParticipantInfo(((Address)localObject2).a(), a, 0, bool, 0));
          i += 1;
        }
        break;
      }
      localConversationInfo.a(new ParticipantInfo((String)localObject2, (String)localObject1, 0, bool, 0));
      return localConversationInfo;
    }
  }
  
  public final void a()
  {
    ContentResolver localContentResolver = b.getContentResolver();
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("flagSeen", Boolean.valueOf(true));
    long l = a;
    new ctw().a(localContentResolver, beb.a, localContentValues, "mailboxKey = ? AND flagSeen != ?", new String[] { String.valueOf(l), "1" });
  }
  
  public final void b()
  {
    ContentResolver localContentResolver = b.getContentResolver();
    Uri localUri = EmailProvider.a("uipurgefolder", a);
    new ctu().a(localContentResolver, localUri);
  }
  
  public final Bundle getExtras()
  {
    return e;
  }
  
  public final int getInt(int paramInt)
  {
    if ((paramInt == 10) && (f >= 0))
    {
      String str = getString(f);
      paramInt = 0;
      while (paramInt < 4)
      {
        int i = new Integer[] { Integer.valueOf(-1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(3) }[paramInt].intValue();
        if (str.indexOf(String.valueOf(i)) != -1) {
          return i;
        }
        paramInt += 1;
      }
      return 0;
    }
    return super.getInt(paramInt);
  }
  
  public final long getLong(int paramInt)
  {
    return super.getLong(paramInt);
  }
  
  public final Bundle respond(Bundle paramBundle)
  {
    if ((paramBundle.containsKey("setVisibility")) && (paramBundle.getBoolean("setVisibility")))
    {
      a();
      if (paramBundle.containsKey("enteredFolder")) {
        new ayu(this).execute(new Void[0]);
      }
    }
    Bundle localBundle = new Bundle(3);
    localBundle.putString("setVisibility", "ok");
    if (paramBundle.containsKey("rawFolders")) {
      localBundle.putParcelable("rawFolders", d);
    }
    if (paramBundle.containsKey("conversationInfo")) {
      localBundle.putParcelable("conversationInfo", c());
    }
    return localBundle;
  }
}

/* Location:
 * Qualified Name:     ayt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */