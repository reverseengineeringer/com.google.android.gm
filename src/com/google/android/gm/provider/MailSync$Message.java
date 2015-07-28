package com.google.android.gm.provider;

import android.text.TextUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MailSync$Message
{
  public List<Gmail.Attachment> attachments = Lists.newArrayList();
  public List<String> bccAddresses = Collections.emptyList();
  public String body;
  public boolean bodyEmbedsExternalResources;
  public List<String> ccAddresses = Collections.emptyList();
  public boolean clientCreated;
  public long conversationId;
  public String customFromAddress;
  public long dateReceivedMs;
  public long dateSentMs;
  public boolean forward;
  public String fromAddress = "";
  public boolean includeQuotedText;
  public Set<Long> labelIds = Sets.newHashSet();
  public String listInfo;
  public long localMessageId;
  public long messageId;
  public Gmail.PersonalLevel personalLevel;
  public long quoteStartPos;
  public long refMessageId;
  public long refMsgId;
  public List<String> replyToAddresses = Collections.emptyList();
  public String snippet;
  public String subject;
  public List<String> toAddresses = Collections.emptyList();
  
  public Gmail.Attachment getAttachmentOrNull(String paramString)
  {
    Iterator localIterator = attachments.iterator();
    while (localIterator.hasNext())
    {
      Gmail.Attachment localAttachment = (Gmail.Attachment)localIterator.next();
      if (paramString.equals(partId)) {
        return localAttachment;
      }
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Message: ").append(messageId);
    localStringBuilder.append(", ").append(conversationId);
    localStringBuilder.append(", from: ").append(fromAddress);
    localStringBuilder.append(", to: ").append(TextUtils.join(", ", toAddresses));
    if (ccAddresses.size() != 0) {
      localStringBuilder.append(", cc: ").append(TextUtils.join(", ", ccAddresses));
    }
    if (bccAddresses.size() != 0) {
      localStringBuilder.append(", bcc: ").append(TextUtils.join(", ", bccAddresses));
    }
    if (replyToAddresses.size() != 0) {
      localStringBuilder.append(", replyTo: ").append(TextUtils.join(", ", replyToAddresses));
    }
    localStringBuilder.append(", subject: ").append(subject);
    localStringBuilder.append(", snippet: ").append(snippet);
    localStringBuilder.append(", forward: ").append(forward);
    localStringBuilder.append(", includeQuotedText: ").append(includeQuotedText);
    localStringBuilder.append(", quoteStartPos: ").append(quoteStartPos);
    localStringBuilder.append(", clientCreated: ").append(clientCreated);
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailSync.Message
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */