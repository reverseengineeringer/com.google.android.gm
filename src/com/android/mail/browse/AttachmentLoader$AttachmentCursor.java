package com.android.mail.browse;

import android.database.Cursor;
import android.database.CursorWrapper;
import com.android.mail.providers.Attachment;
import com.google.common.collect.Maps;
import java.util.Map;

public class AttachmentLoader$AttachmentCursor
  extends CursorWrapper
{
  private Map<String, Attachment> mCache = Maps.newHashMap();
  
  private AttachmentLoader$AttachmentCursor(Cursor paramCursor)
  {
    super(paramCursor);
  }
  
  public Attachment get()
  {
    String str = getWrappedCursor().getString(2);
    Attachment localAttachment2 = (Attachment)mCache.get(str);
    Attachment localAttachment1 = localAttachment2;
    if (localAttachment2 == null)
    {
      localAttachment1 = new Attachment(this);
      mCache.put(str, localAttachment1);
    }
    return localAttachment1;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.AttachmentLoader.AttachmentCursor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */