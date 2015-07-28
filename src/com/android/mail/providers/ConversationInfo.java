package com.android.mail.providers;

import android.text.TextUtils;
import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

public class ConversationInfo
{
  private static Pattern MESSAGE_CONV_SPLITTER_REGEX = Pattern.compile("\\^\\*\\*\\^");
  private static Pattern MESSAGE_SPLITTER_REGEX = Pattern.compile("\\^\\*\\*\\*\\^");
  public static String SPLITTER = "^*^";
  private static Pattern SPLITTER_REGEX = Pattern.compile("\\^\\*\\^");
  public int draftCount;
  public String firstSnippet;
  public String firstUnreadSnippet;
  public String lastSnippet;
  public int messageCount;
  public final ArrayList<MessageInfo> messageInfos = new ArrayList();
  
  public ConversationInfo() {}
  
  public ConversationInfo(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    set(paramInt1, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public static ConversationInfo fromString(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = TextUtils.split(paramString, MESSAGE_CONV_SPLITTER_REGEX);
    } while (paramString.length < 2);
    ConversationInfo localConversationInfo = parseConversation(paramString[0]);
    parseMessages(localConversationInfo, paramString[1]);
    return localConversationInfo;
  }
  
  private static String getMessageInfoString(ConversationInfo paramConversationInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    Iterator localIterator = messageInfos.iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append(MessageInfo.toString((MessageInfo)localIterator.next()));
      if (i < messageInfos.size() - 1) {
        localStringBuilder.append("^***^");
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static ConversationInfo parseConversation(String paramString)
  {
    paramString = TextUtils.split(paramString, SPLITTER_REGEX);
    return new ConversationInfo(Integer.parseInt(paramString[0]), Integer.parseInt(paramString[1]), paramString[2], paramString[3], paramString[4]);
  }
  
  private static void parseMessages(ConversationInfo paramConversationInfo, String paramString)
  {
    paramString = TextUtils.split(paramString, MESSAGE_SPLITTER_REGEX);
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      paramConversationInfo.addMessage(MessageInfo.fromString(paramString[i]));
      i += 1;
    }
  }
  
  public static String toString(ConversationInfo paramConversationInfo)
  {
    if (paramConversationInfo == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(messageCount);
    localStringBuilder.append(SPLITTER);
    localStringBuilder.append(draftCount);
    localStringBuilder.append(SPLITTER);
    localStringBuilder.append(firstSnippet);
    localStringBuilder.append(SPLITTER);
    localStringBuilder.append(firstUnreadSnippet);
    localStringBuilder.append(SPLITTER);
    localStringBuilder.append(lastSnippet);
    localStringBuilder.append("^**^");
    localStringBuilder.append(getMessageInfoString(paramConversationInfo));
    return localStringBuilder.toString();
  }
  
  public void addMessage(MessageInfo paramMessageInfo)
  {
    messageInfos.add(paramMessageInfo);
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { Integer.valueOf(messageCount), Integer.valueOf(draftCount), messageInfos, firstSnippet, lastSnippet, firstUnreadSnippet });
  }
  
  public boolean markRead(boolean paramBoolean)
  {
    boolean bool = false;
    Iterator localIterator = messageInfos.iterator();
    while (localIterator.hasNext()) {
      bool |= ((MessageInfo)localIterator.next()).markRead(paramBoolean);
    }
    if (paramBoolean)
    {
      firstSnippet = lastSnippet;
      return bool;
    }
    firstSnippet = firstUnreadSnippet;
    return bool;
  }
  
  public void set(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    messageInfos.clear();
    messageCount = paramInt1;
    draftCount = paramInt2;
    firstSnippet = paramString1;
    firstUnreadSnippet = paramString2;
    lastSnippet = paramString3;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.providers.ConversationInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */