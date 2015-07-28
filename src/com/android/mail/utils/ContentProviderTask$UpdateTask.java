package com.android.mail.utils;

import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import com.google.common.collect.Lists;

public class ContentProviderTask$UpdateTask
  extends ContentProviderTask
{
  public void run(ContentResolver paramContentResolver, Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    paramContentValues = ContentProviderOperation.newUpdate(paramUri).withValues(paramContentValues).withSelection(paramString, paramArrayOfString).build();
    super.run(paramContentResolver, paramUri.getAuthority(), Lists.newArrayList(new ContentProviderOperation[] { paramContentValues }));
  }
}

/* Location:
 * Qualified Name:     com.android.mail.utils.ContentProviderTask.UpdateTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */