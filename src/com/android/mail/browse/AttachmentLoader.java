package com.android.mail.browse;

import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.net.Uri;
import com.android.mail.providers.Attachment;
import com.android.mail.providers.UIProvider;
import com.google.common.collect.Maps;
import java.util.Map;

public class AttachmentLoader
  extends CursorLoader
{
  public AttachmentLoader(Context paramContext, Uri paramUri)
  {
    super(paramContext, paramUri, UIProvider.ATTACHMENT_PROJECTION, null, null, null);
  }
  
  public Cursor loadInBackground()
  {
    return new AttachmentCursor(super.loadInBackground(), null);
  }
  
  public static class AttachmentCursor
    extends CursorWrapper
  {
    private Map<String, Attachment> mCache = Maps.newHashMap();
    
    private AttachmentCursor(Cursor paramCursor)
    {
      super();
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
}

/* Location:
 * Qualified Name:     com.android.mail.browse.AttachmentLoader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */