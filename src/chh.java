import android.net.Uri;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public final class chh
{
  public static final Map<String, Class<?>> a = new hen().b("_id", Integer.class).b("name", String.class).b("senderName", String.class).b("accountManagerName", String.class).b("accountId", String.class).b("type", String.class).b("providerVersion", Integer.class).b("accountUri", String.class).b("folderListUri", String.class).b("fullFolderListUri", String.class).b("allFolderListUri", String.class).b("searchUri", String.class).b("searchMessageGenericUri", String.class).b("accountFromAddresses", String.class).b("expungeMessageUri", String.class).b("undoUri", String.class).b("accountSettingsIntentUri", String.class).b("syncStatus", Integer.class).b("helpIntentUri", String.class).b("sendFeedbackIntentUri", String.class).b("reauthenticationUri", String.class).b("composeUri", String.class).b("mimeType", String.class).b("recentFolderListUri", String.class).b("defaultRecentFolderListUri", String.class).b("manualSyncUri", String.class).b("viewProxyUri", String.class).b("accountCookieUri", String.class).b("accountOAuthTokenUri", String.class).b("signature", String.class).b("auto_advance", Integer.class).b("reply_behavior", Integer.class).b("conversation_list_icon", Integer.class).b("confirm_delete", Integer.class).b("confirm_archive", Integer.class).b("confirm_send", Integer.class).b("default_inbox", String.class).b("default_inbox_name", String.class).b("force_reply_from_default", Integer.class).b("max_attachment_size", Integer.class).b("swipe", Integer.class).b("importance_markers_enabled", Integer.class).b("show_chevrons_enabled", Integer.class).b("setup_intent_uri", String.class).b("conversation_view_mode", Integer.class).b("updateSettingsUri", String.class).b("enableMessageTransforms", Integer.class).b("syncAuthority", String.class).b("quickResponseUri", String.class).b("settingsFragmentClass", String.class).b("move_to_inbox", String.class).b("show_images", Integer.class).b("welcome_tour_shown_version", Integer.class).b("securityHold", Integer.class).b("accountSecurityUri", String.class).b("settingsSnapshotUri", String.class).b("vacationResponderSettingsUri", String.class).b("driveUri", String.class).b("drawerAddress", String.class).b("providerHostname", String.class).b("providerPathname", String.class).b("temp_tls_ii", Integer.class).b("temp_tls_oi", Integer.class).b("temp_fz_ii", Integer.class).b("temp_fz_oi", Integer.class).b("domainTlsPredictionUri", String.class).b();
  public static final Map<String, Class<?>> b;
  public static final String[] c;
  public static final String[] d = (String[])a.keySet().toArray(new String[a.size()]);
  public static final String[] e = { "_id", "quickResponse", "uri" };
  public static final String[] f = { "cookie" };
  public static final String[] g = { "oauthToken" };
  public static final String[] h = { "tlsp_domain", "use_tls" };
  public static final String[] i = { "_id", "persistentId", "folderUri", "name", "hasChildren", "capabilities", "syncWindow", "conversationListUri", "childFoldersListUri", "unseenCount", "unreadCount", "totalCount", "refreshUri", "syncStatus", "lastSyncResult", "type", "iconResId", "notificationIconResId", "bgColor", "fgColor", "loadMoreUri", "hierarchicalDesc", "lastMessageTimestamp", "parentUri" };
  public static final String[] j = (String[])new heh().b(hef.a(i)).c("unreadSenders").a().toArray(new String[0]);
  public static final String[] k = { "_id", "conversationUri", "messageListUri", "subject", "snippet", "conversationInfo", "dateReceivedMs", "hasAttachments", "numMessages", "numDrafts", "sendingState", "importance", "read", "seen", "starred", "rawFolders", "conversationFlags", "personalLevel", "spam", "phishing", "muted", "color", "accountUri", "senderInfo", "conversationBaseUri", "remote", "orderKey", "promoteCalendar", "unsubscribeState", "unsubscribeSenderName", "unsubscribeSenderIdentifier", "priority", "reportSpamSuggestion", "canReportNotSuspicious" };
  public static final Uri l = gqa.a;
  public static final String[] m = { "_id", "server_id", "account_name", "account_type", "subject", "body", "complete", "folder_id", "date_complete", "start_date", "due_date", "reminder_set", "reminder_time", "recurrent_start_date", "rrule", "rdate", "importance", "sensitivity" };
  public static final String[] n = { "_id", "serverMessageId", "messageUri", "conversationId", "subject", "snippet", "fromAddress", "toAddresses", "ccAddresses", "bccAddresses", "replyToAddress", "dateReceivedMs", "bodyHtml", "bodyText", "stylesheet", "stylesheetRestrictor", "bodyEmbedsExternalResources", "refMessageId", "draftType", "appendRefMessageContent", "hasAttachments", "attachmentListUri", "attachmentByCidUri", "messageFlags", "alwaysShowImages", "read", "seen", "starred", "quotedTextStartPos", "attachments", "customFrom", "messageAccountUri", "eventIntentUri", "spamWarningString", "spamWarningLevel", "spamWarningLinkType", "sendingState", "clipped", "permalink", "senderExcludedFromBlockOption", "senderBlocked", "unsubscribeSenderIdentifier", "eventTitle", "startTime", "endTime", "allDay", "location", "organizer", "attendees", "recurrenceRule", "icalMethod", "responder", "responderStatus", "syncId", "encryptionStatus", "signingStatus", "tlsStatus", "syncBlocked", "priority", "eventUid", "meetingResponseComment", "proposedStartTime", "proposedEndTime", "meetingResponse", "showUnauthWarning", "proposedTimeFetchStatus", "meetingInfo", "spamReason", "proposeTimeFromMailRefMessageUri", "proposeTimeFromMailRsvp", "proposeTimeFromMailProposedStartTime", "proposeTimeFromMailProposedEndTime", "clientDomain", "spf", "dkim" };
  public static final String[] o = { "_display_name", "_size", "uri", "contentType", "state", "destination", "downloadedSize", "contentUri", "thumbnailUri", "providerData", "supportsDownloadAgain", "type", "flags", "contentId", "hasPreview" };
  public static final Pattern p = Pattern.compile("\n");
  public static final Pattern q = Pattern.compile("\\|");
  public static final String[] r = { "messageListUri" };
  public static final String[] s = { "response1", "response2", "response3" };
  
  static
  {
    hel localhel = new hen().a(a).b("capabilities", Long.class).b();
    b = localhel;
    c = (String[])localhel.keySet().toArray(new String[b.size()]);
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    return paramInt1 << 8 | paramInt2;
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt > 0;
  }
  
  public static int b(int paramInt)
  {
    return paramInt & 0xFF;
  }
  
  public static int c(int paramInt)
  {
    return paramInt >> 8;
  }
}

/* Location:
 * Qualified Name:     chh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */