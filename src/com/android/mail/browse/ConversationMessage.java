package com.android.mail.browse;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import bcl;
import bxg;
import byx;
import ccx;
import cll;
import com.android.mail.providers.Attachment;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Message;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ConversationMessage
  extends Message
{
  public static final ccx<ConversationMessage> b = new bxg();
  public transient byx a;
  
  public ConversationMessage(Context paramContext, bcl parambcl, Uri paramUri)
  {
    super(paramContext, parambcl, paramUri);
  }
  
  public ConversationMessage(Cursor paramCursor)
  {
    super(paramCursor);
  }
  
  public final Conversation a()
  {
    if (a != null) {
      return a.d();
    }
    return null;
  }
  
  public final void a(boolean paramBoolean)
  {
    cll localcll = a.e();
    if (localcll != null) {
      localcll.a(this, paramBoolean);
    }
  }
  
  public final int b()
  {
    Uri localUri1 = f;
    Iterator localIterator = l().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      Uri localUri2 = ((Attachment)localIterator.next()).k();
      if (localUri2 != null) {}
      for (int j = localUri2.hashCode();; j = 0)
      {
        i = j + i;
        break;
      }
    }
    return Arrays.hashCode(new Object[] { localUri1, Integer.valueOf(i) });
  }
  
  public final void b(boolean paramBoolean)
  {
    cll localcll = a.e();
    if (localcll != null) {
      localcll.b(this, paramBoolean);
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.ConversationMessage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */