package com.google.android.gm.provider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.text.TextUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Gmail$MessageModification
{
  public static void expungeMessage(ContentResolver paramContentResolver, String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("account is empty");
    }
    paramContentResolver.delete(Gmail.getMessageByIdUri(paramString, paramLong), null, null);
  }
  
  public static void expungeMessages(ContentResolver paramContentResolver, String paramString, List<Long> paramList)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("account is empty");
    }
    paramString = Gmail.getMessagesUri(paramString);
    HashSet localHashSet = Sets.newHashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localHashSet.add(((Long)paramList.next()).toString());
    }
    paramContentResolver.delete(paramString, null, (String[])localHashSet.toArray(new String[localHashSet.size()]));
  }
  
  public static String joinedAttachmentsString(List<Gmail.Attachment> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Gmail.Attachment localAttachment = (Gmail.Attachment)paramList.next();
      if (localStringBuilder.length() != 0) {
        localStringBuilder.append("\n");
      }
      localStringBuilder.append(localAttachment.toJoinedString());
    }
    return localStringBuilder.toString();
  }
  
  public static List<Gmail.Attachment> parseJoinedAttachmentString(String paramString)
  {
    ArrayList localArrayList = Lists.newArrayList();
    if (paramString != null)
    {
      paramString = TextUtils.split(paramString, Gmail.ATTACHMENT_INFO_SEPARATOR_PATTERN);
      int j = paramString.length;
      int i = 0;
      if (i < j)
      {
        String str = paramString[i];
        Gmail.Attachment localAttachment = Gmail.Attachment.parseJoinedString(str);
        if (localAttachment != null) {
          localArrayList.add(localAttachment);
        }
        for (;;)
        {
          i += 1;
          break;
          LogUtils.d("Gmail", "Failed to parse attachment: %s", new Object[] { str });
        }
      }
    }
    return localArrayList;
  }
  
  public static void putBccAddresses(ContentValues paramContentValues, String[] paramArrayOfString)
  {
    paramContentValues.put("bccAddresses", TextUtils.join(",", paramArrayOfString));
  }
  
  public static void putBody(ContentValues paramContentValues, String paramString)
  {
    paramContentValues.put("body", paramString);
  }
  
  public static void putCcAddresses(ContentValues paramContentValues, String[] paramArrayOfString)
  {
    paramContentValues.put("ccAddresses", TextUtils.join(",", paramArrayOfString));
  }
  
  public static void putSubject(ContentValues paramContentValues, String paramString)
  {
    paramContentValues.put("subject", paramString);
  }
  
  public static void putToAddresses(ContentValues paramContentValues, String[] paramArrayOfString)
  {
    paramContentValues.put("toAddresses", TextUtils.join(",", paramArrayOfString));
  }
  
  public static void sendOrSaveExistingMessage(ContentResolver paramContentResolver, String paramString, long paramLong, ContentValues paramContentValues, boolean paramBoolean)
  {
    paramContentValues.put("save", Boolean.valueOf(paramBoolean));
    paramContentValues.put("refMessageId", Integer.valueOf(0));
    paramContentResolver.update(Gmail.getMessageByIdUri(paramString, paramLong), paramContentValues, null, null);
  }
  
  public static long sendOrSaveNewMessage(ContentResolver paramContentResolver, String paramString, ContentValues paramContentValues, long paramLong, boolean paramBoolean)
  {
    paramContentValues.put("save", Boolean.valueOf(paramBoolean));
    paramContentValues.put("refMessageId", Long.valueOf(paramLong));
    return ContentUris.parseId(paramContentResolver.insert(Gmail.getMessagesUri(paramString), paramContentValues));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.Gmail.MessageModification
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */