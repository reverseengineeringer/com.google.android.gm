package com.android.mail.providers;

import android.text.TextUtils;
import com.google.common.base.Objects;
import java.util.regex.Pattern;

public class MessageInfo
{
  private static final Pattern MSG_DIVIDER_REGEX = Pattern.compile("\\^\\*\\*\\*\\*\\^");
  public int priority;
  public boolean read;
  public String sender;
  public boolean starred;
  
  public MessageInfo() {}
  
  public MessageInfo(boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt)
  {
    set(paramBoolean1, paramBoolean2, paramString, paramInt);
  }
  
  public static MessageInfo fromString(String paramString)
  {
    boolean bool2 = true;
    paramString = TextUtils.split(paramString, MSG_DIVIDER_REGEX);
    int i = Integer.parseInt(paramString[0]);
    int j = Integer.parseInt(paramString[1]);
    String str = paramString[2];
    int k = Integer.parseInt(paramString[3]);
    boolean bool1;
    if (i != 0)
    {
      bool1 = true;
      if (j == 0) {
        break label69;
      }
    }
    for (;;)
    {
      return new MessageInfo(bool1, bool2, str, k);
      bool1 = false;
      break;
      label69:
      bool2 = false;
    }
  }
  
  public static String toString(MessageInfo paramMessageInfo)
  {
    int j = 1;
    StringBuilder localStringBuilder = new StringBuilder();
    if (read)
    {
      i = 1;
      localStringBuilder.append(i);
      localStringBuilder.append("^****^");
      if (!starred) {
        break label89;
      }
    }
    label89:
    for (int i = j;; i = 0)
    {
      localStringBuilder.append(i);
      localStringBuilder.append("^****^");
      localStringBuilder.append(sender);
      localStringBuilder.append("^****^");
      localStringBuilder.append(priority);
      return localStringBuilder.toString();
      i = 0;
      break;
    }
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { Boolean.valueOf(read), Boolean.valueOf(starred), sender });
  }
  
  public boolean markRead(boolean paramBoolean)
  {
    if (read != paramBoolean)
    {
      read = paramBoolean;
      return true;
    }
    return false;
  }
  
  public void set(boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt)
  {
    read = paramBoolean1;
    starred = paramBoolean2;
    sender = paramString;
    priority = paramInt;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.providers.MessageInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */