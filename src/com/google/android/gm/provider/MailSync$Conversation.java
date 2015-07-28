package com.google.android.gm.provider;

import android.text.TextUtils;
import java.util.Set;

public class MailSync$Conversation
{
  public long conversationId;
  public long date;
  public String fromAddress;
  public boolean hasAttachments;
  public Set<Long> labelIds;
  public long maxMessageId;
  public int numMessages;
  public Gmail.PersonalLevel personalLevel;
  public String snippet;
  public long sortMessageId;
  public String subject;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("conversationId: ").append(conversationId);
    localStringBuilder.append(", sortMessageId: ").append(sortMessageId);
    localStringBuilder.append(", maxMessageId: ").append(maxMessageId);
    localStringBuilder.append(", numMessage: ").append(numMessages);
    localStringBuilder.append(", date: ").append(date);
    if (subject != null) {
      localStringBuilder.append(", subject: ").append(subject);
    }
    if (snippet != null) {
      localStringBuilder.append(", snippet: ").append(snippet);
    }
    localStringBuilder.append(", hasAttachments: ").append(hasAttachments);
    if (fromAddress != null) {
      localStringBuilder.append(", fromAddress: '").append(fromAddress.replace('\n', '|')).append('\'');
    }
    localStringBuilder.append(", labelIds: ").append(TextUtils.join("|", labelIds));
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailSync.Conversation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */