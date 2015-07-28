package com.android.mail.providers;

import android.content.Context;
import android.text.TextUtils;
import android.text.util.Rfc822Token;
import android.text.util.Rfc822Tokenizer;
import com.android.common.contacts.DataUsageStatUpdater;
import java.util.ArrayList;

public class UIProvider
{
  public static final String[] ACCOUNTS_PROJECTION = { "_id", "name", "providerVersion", "accountUri", "capabilities", "folderListUri", "fullFolderListUri", "searchUri", "accountFromAddresses", "saveDraftUri", "sendMailUri", "expungeMessageUri", "undoUri", AccountColumns.SETTINGS_INTENT_URI, "syncStatus", AccountColumns.HELP_INTENT_URI, AccountColumns.SEND_FEEDBACK_INTENT_URI, AccountColumns.REAUTHENTICATION_INTENT_URI, "composeUri", "mimeType", "recentFolderListUri", "color", "defaultRecentFolderListUri", "manualSyncUri", "viewProxyUri", "accountCookieUri", "signature", "auto_advance", "message_text_size", "snap_headers", "reply_behavior", "hide_checkboxes", "confirm_delete", "confirm_archive", "confirm_send", "default_inbox", "default_inbox_name", "force_reply_from_default", "max_attachment_size", "swipe", "priority_inbox_arrows_enabled", "setup_intent_uri", "conversation_view_mode" };
  public static final String[] ACCOUNT_COOKIE_PROJECTION = { "cookie" };
  public static final String[] ATTACHMENT_PROJECTION = { "_display_name", "_size", "uri", "contentType", "state", "destination", "downloadedSize", "contentUri", "thumbnailUri", "previewIntentUri" };
  public static final String[] CONVERSATION_PROJECTION;
  public static final String[] FOLDERS_PROJECTION = { "_id", "folderUri", "name", FolderColumns.HAS_CHILDREN, FolderColumns.CAPABILITIES, FolderColumns.SYNC_WINDOW, "conversationListUri", "childFoldersListUri", "unreadCount", "totalCount", "refreshUri", "syncStatus", "lastSyncResult", "type", "iconResId", "bgColor", "fgColor", "loadMoreUri", "hierarchicalDesc" };
  public static final String[] MESSAGE_PROJECTION;
  public static final String[] UNDO_PROJECTION = { "messageListUri" };
  
  static
  {
    CONVERSATION_PROJECTION = new String[] { "_id", "conversationUri", "messageListUri", "subject", "snippet", "conversationInfo", "dateReceivedMs", "hasAttachments", ConversationColumns.NUM_MESSAGES, ConversationColumns.NUM_DRAFTS, ConversationColumns.SENDING_STATE, ConversationColumns.PRIORITY, ConversationColumns.READ, ConversationColumns.STARRED, "rawFolders", "conversationFlags", "personalLevel", "spam", "phishing", "muted", "color", "accountUri", "senderInfo", "conversationBaseUri", "remote" };
    MESSAGE_PROJECTION = new String[] { "_id", "serverMessageId", "messageUri", "conversationId", "subject", "snippet", "fromAddress", "toAddresses", "ccAddresses", "bccAddresses", "replyToAddress", "dateReceivedMs", "bodyHtml", "bodyText", "bodyEmbedsExternalResources", "refMessageId", "draftType", "appendRefMessageContent", "hasAttachments", "attachmentListUri", "messageFlags", "joinedAttachmentInfos", "saveMessageUri", "sendMessageUri", "alwaysShowImages", MessageColumns.READ, MessageColumns.STARRED, "quotedTextStartPos", "attachments", "customFrom", "messageAccountUri", "eventIntentUri", "spamWarningString", "spamWarningLevel", "spamWarningLinkType", "viaDomain", "isSending" };
  }
  
  public static void incrementRecipientsTimesContacted(Context paramContext, String paramString)
  {
    paramContext = new DataUsageStatUpdater(paramContext);
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = Rfc822Tokenizer.tokenize(paramString);
    int i = 0;
    while (i < paramString.length)
    {
      localArrayList.add(paramString[i].getAddress());
      i += 1;
    }
    paramContext.updateWithAddress(localArrayList);
  }
  
  public static final class AccountColumns
  {
    public static String HELP_INTENT_URI;
    public static String REAUTHENTICATION_INTENT_URI = "reauthenticationUri";
    public static String SEND_FEEDBACK_INTENT_URI;
    public static String SETTINGS_INTENT_URI = "accountSettingsIntentUri";
    
    static
    {
      HELP_INTENT_URI = "helpIntentUri";
      SEND_FEEDBACK_INTENT_URI = "sendFeedbackIntentUri";
    }
  }
  
  public static final class ConversationColumns
  {
    public static String NUM_DRAFTS;
    public static String NUM_MESSAGES = "numMessages";
    public static String PRIORITY = "priority";
    public static String READ = "read";
    public static String SENDING_STATE;
    public static String STARRED = "starred";
    
    static
    {
      NUM_DRAFTS = "numDrafts";
      SENDING_STATE = "sendingState";
    }
  }
  
  public static final class CursorStatus
  {
    public static boolean isWaitingForResults(int paramInt)
    {
      return (paramInt & 0x1) != 0;
    }
  }
  
  public static final class FolderColumns
  {
    public static String CAPABILITIES = "capabilities";
    public static String HAS_CHILDREN = "hasChildren";
    public static String SYNC_WINDOW = "syncWindow";
  }
  
  public static final class MessageColumns
  {
    public static String READ = "read";
    public static String STARRED = "starred";
  }
  
  public static final class SyncStatus
  {
    public static boolean isSyncInProgress(int paramInt)
    {
      return (paramInt & 0x27) != 0;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.providers.UIProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */