import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.text.TextUtils.SimpleStringSplitter;
import android.text.TextUtils.StringSplitter;
import android.util.Patterns;
import com.google.android.gm.persistence.GmailBackupAgent;
import com.google.android.gm.provider.uiprovider.GmailAttachment;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class dpy
{
  public static final Set<String> a = new hfe().c("^sq_ig_i_personal").c("^sq_ig_i_social").c("^sq_ig_i_promo").c("^sq_ig_i_notification").c("^sq_ig_i_group").a();
  public static final Pattern b = Pattern.compile("\n");
  static Map<String, Map<String, Uri>> c = new HashMap();
  public static final Pattern d = Pattern.compile(" ");
  public static final Pattern e = Pattern.compile(",");
  static final Pattern f = Pattern.compile("\"(.*)\"");
  static final Pattern g = Pattern.compile("([^<]+)@");
  public static final Set<String> h;
  public static final hcu<Long, String> i;
  public static final Set<String> j;
  public static final Set<String> k;
  public static final Set<String> l;
  public static final String[] m;
  public static final String[] n;
  public static final String[] o;
  public static final String[] p = { "_id", "domainTitle" };
  public static final String[] q = { "account_name" };
  public static String[] r = { "_id", "subject", "snippet", "fromAddress", "personalLevel", "labelIds", "numMessages", "maxMessageId", "hasAttachments", "hasMessagesWithErrors", "forceAllUnread", "fromProtoBuf", "fromCompact", "promoteCalendar", "unsubscribeSenderName", "unsubscribeSenderIdentifier", "fromCompactV2", "hasCalendarInvite" };
  public static String[] s = { "_id", "messageId", "conversation", "subject", "snippet", "fromAddress", "customFromAddress", "toAddresses", "ccAddresses", "bccAddresses", "replyToAddresses", "dateSentMs", "dateReceivedMs", "listInfo", "personalLevel", "body", "stylesheet", "stylesheetRestrictor", "bodyEmbedsExternalResources", "labelIds", "joinedAttachmentInfos", "refMessageId", "refAdEventId", "error", "forward", "includeQuotedText", "quoteStartPos", "spamDisplayedReasonType", "permalink", "clipped", "encrypted", "signed", "receivedWithTls", "spf", "dkim", "clientDomain", "unsubscribeSenderName", "unsubscribeSenderIdentifier", "syncBlocked", "hasEvent", "eventTitle", "startTime", "endTime", "allDay", "location", "organizer", "attendees", "icalMethod", "eventId", "calendarId", "responder", "responseStatus", "labelCount", "messageLabels", "isStarred", "isDraft", "isInOutbox", "isInSending", "isInFailed", "isUnread", "isSenderUnsubscribed", "showUnauthWarning", "isLateReclassified" };
  public static String[] t = { "_id", "canonicalName", "name", "numConversations", "numUnreadConversations", "numUnseenConversations", "color", "systemLabel", "hidden", "labelCountDisplayBehavior", "labelSyncPolicy", "lastTouched", "lastMessageTimestamp", "sortOrder" };
  public static String[] u = { "labelsIncluded", "labelsPartial", "conversationAgeDays", "maxAttachmentSize" };
  static final String[] v = { "status", "account" };
  private static final Set<String> x = hfd.a("^all", "^b", "^r", "^g", "^i", "^f", new String[] { "^s", "^t", "^k", "^u", "^io_im", "^iim", "^p_mtunsub", "^punsub", "^p_aunsub", "^p_bs", "^p_abs", "^sua", "^p_ag", "^^cached", "^^out", "^sq_ig_i_personal", "^sq_ig_i_social", "^sq_ig_i_promo", "^sq_ig_i_notification", "^sq_ig_i_group", "^smartlabel_personal", "^smartlabel_social", "^smartlabel_promo", "^smartlabel_notification", "^smartlabel_group", "^^important", "^^unimportant", "^imi", "^imn", "^io_ns", "^im", "^p", "^sps", "^lcs" });
  private static final Set<String> y;
  public final ContentResolver w;
  
  static
  {
    h = hfd.a("^g", "^i", "^s", "^k");
    i = new hdv().a(Long.valueOf(-500L), "^imi").a(Long.valueOf(-501L), "^imn").a(Long.valueOf(-499L), "^im").a(Long.valueOf(-502L), "^io_ns").a();
    j = hfd.a("^imi", "^imn", "^im", "^io_ns");
    y = hfd.a("^i", "^u", "^k", "^s", "^t", "^g", new String[] { "^^important", "^^unimportant", "^imi", "^imn", "^io_ns", "^o", "^p_bs" });
    k = hfd.a("^i", "^iim", "^k", "^s");
    l = hfd.a("^im", "^io_im", "^iim", "^punsub", "^p_bs", "^p", new String[] { "^sps" });
    m = new String[] { "_id", "event_id", "advertiser_name", "title", "line1", "visible_url", "redirect_url", "advertiser_image_data", "expiration", "reason", "apm_extra_targeting_data", "starred", "view_status", "view", "slot", "apm_xsrf_token", "delete_status", "wta_data", "view_url", "click_url", "interaction_url", "body_view_urls", "obfuscated_data", "report_ad_server", "report_bow", "send_body", "show_body_feedback_survey", "report_duration_since_last_action", "click_id", "aia_star_rating", "aia_ratings_count", "aia_package_name", "aia_inline_install_enabled", "aia_teaser_experiment", "aia_body_experiment", "aia_referrer", "aia_install_url", "aia_install_button_url", "last_shown_timestamp", "last_clicked_timestamp", "last_starred_timestamp", "dismiss_survey_data", "wta_get_url", "wta_tooltip_type", "tab", "ad_client_dedup_id_data", "report_duration_since_last_action_to_bow", "report_click_id_for_click_event" };
    n = new String[] { "body" };
    String[] arrayOfString1 = m;
    String[] arrayOfString2 = n;
    Object[] arrayOfObject = hhz.a(String.class, arrayOfString1.length + arrayOfString2.length);
    System.arraycopy(arrayOfString1, 0, arrayOfObject, 0, arrayOfString1.length);
    System.arraycopy(arrayOfString2, 0, arrayOfObject, arrayOfString1.length, arrayOfString2.length);
    o = (String[])arrayOfObject;
  }
  
  public dpy(ContentResolver paramContentResolver)
  {
    w = paramContentResolver;
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException(34 + "Invalid PersonalLevel: " + paramInt);
    }
    return paramInt;
  }
  
  public static long a(Context paramContext)
  {
    String str;
    if (b(paramContext)) {
      str = "gmail_default_label_sync_days_large_data_partition";
    }
    for (long l1 = 30L;; l1 = 4L)
    {
      return ghz.a(paramContext.getContentResolver(), str, l1);
      str = "gmail_default_label_sync_days";
    }
  }
  
  private static ContentValues a(dqg paramdqg)
  {
    ContentValues localContentValues = new ContentValues();
    if (paramdqg.g()) {
      localContentValues.put("labelsIncluded", TextUtils.join(" ", c));
    }
    if (paramdqg.h()) {
      localContentValues.put("labelsPartial", TextUtils.join(" ", d));
    }
    if (paramdqg.e()) {
      localContentValues.put("conversationAgeDays", Long.valueOf(a));
    }
    if (paramdqg.f()) {
      localContentValues.put("maxAttachmentSize", Long.valueOf(b));
    }
    return localContentValues;
  }
  
  public static Uri a(String paramString)
  {
    Map localMap = l(paramString);
    Uri localUri = (Uri)localMap.get("baseUri");
    Object localObject = localUri;
    if (localUri == null)
    {
      localObject = String.valueOf("content://gmail-ls/");
      paramString = String.valueOf(paramString);
      if (paramString.length() == 0) {
        break label67;
      }
    }
    label67:
    for (paramString = ((String)localObject).concat(paramString);; paramString = new String((String)localObject))
    {
      localObject = Uri.parse(paramString);
      localMap.put("baseUri", localObject);
      return (Uri)localObject;
    }
  }
  
  public static Uri a(String paramString, long paramLong)
  {
    return a(paramString, "/conversations/").buildUpon().appendEncodedPath(Long.toString(paramLong)).appendEncodedPath("attachments").build();
  }
  
  public static Uri a(String paramString, long paramLong, GmailAttachment paramGmailAttachment, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("account is empty");
    }
    if ((r == 1) && (s == 1)) {
      return Uri.parse(paramGmailAttachment.s());
    }
    return a(paramString, paramLong, b, paramInt, false);
  }
  
  public static Uri a(String paramString1, long paramLong, String paramString2)
  {
    return a(paramString1, "/conversation/").buildUpon().appendEncodedPath(Long.toString(paramLong)).appendEncodedPath("labels").appendEncodedPath(m(paramString2)).build();
  }
  
  public static Uri a(String paramString1, long paramLong, String paramString2, int paramInt, boolean paramBoolean)
  {
    return a(paramString1, "/messages/").buildUpon().appendPath(Long.toString(paramLong)).appendPath("attachments").appendPath(paramString2).appendPath(chi.a(paramInt)).appendPath(Boolean.toString(paramBoolean)).build();
  }
  
  public static Uri a(String paramString1, String paramString2)
  {
    Map localMap = l(paramString1);
    Uri localUri = (Uri)localMap.get(paramString2);
    Object localObject = localUri;
    if (localUri == null)
    {
      localObject = String.valueOf("content://gmail-ls/");
      localObject = Uri.parse(String.valueOf(localObject).length() + 0 + String.valueOf(paramString1).length() + String.valueOf(paramString2).length() + (String)localObject + paramString1 + paramString2);
      localMap.put(paramString2, localObject);
    }
    return (Uri)localObject;
  }
  
  public static TextUtils.StringSplitter a()
  {
    return new TextUtils.SimpleStringSplitter(' ');
  }
  
  static dqg a(Context paramContext, Cursor paramCursor)
  {
    dqg localdqg = new dqg();
    paramCursor.moveToNext();
    c = hio.a(TextUtils.split(paramCursor.getString(0), d));
    d = hio.a(TextUtils.split(paramCursor.getString(1), d));
    String str = paramCursor.getString(2);
    if (str != null)
    {
      l1 = Long.parseLong(str);
      a = l1;
      paramContext = paramCursor.getString(3);
      if (paramContext == null) {
        break label124;
      }
    }
    label124:
    for (long l1 = Long.parseLong(paramContext);; l1 = Long.valueOf(0L).longValue())
    {
      b = l1;
      return localdqg;
      l1 = Long.valueOf(a(paramContext)).longValue();
      break;
    }
  }
  
  public static dqg a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("account is empty");
    }
    paramString = paramContext.getContentResolver().query(a(paramString, "/settings/"), u, null, null, null);
    try
    {
      paramContext = a(paramContext, paramString);
      return paramContext;
    }
    finally
    {
      if (paramString != null) {
        paramString.close();
      }
    }
  }
  
  public static String a(Set<Long> paramSet)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(',');
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      localStringBuilder.append((Long)paramSet.next());
      localStringBuilder.append(',');
    }
    return localStringBuilder.toString();
  }
  
  public static Set<Long> a(TextUtils.StringSplitter paramStringSplitter)
  {
    HashSet localHashSet = new HashSet();
    paramStringSplitter = paramStringSplitter.iterator();
    while (paramStringSplitter.hasNext()) {
      localHashSet.add(Long.valueOf((String)paramStringSplitter.next()));
    }
    return localHashSet;
  }
  
  public static void a(Context paramContext, String paramString, dqg paramdqg)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("account is empty");
    }
    dqg localdqg = new dqg();
    localdqg.a(paramdqg.c());
    localdqg.b(paramdqg.d());
    localdqg.a(paramdqg.a());
    localdqg.b(paramdqg.b());
    paramContext = drp.a(paramContext, paramString);
    paramString = a(localdqg);
    if (paramString.size() > 0) {
      paramContext.a(paramString);
    }
  }
  
  public static void a(String paramString, dqg paramdqg, ContentResolver paramContentResolver)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("account is empty");
    }
    paramdqg = a(paramdqg);
    if (paramdqg.size() > 0)
    {
      paramContentResolver.update(a(paramString, "/settings/"), paramdqg, null, null);
      GmailBackupAgent.a("Sync settings ");
    }
  }
  
  public static boolean a(ContentResolver paramContentResolver)
  {
    return ghz.a(paramContentResolver, "gmail_enable_conscrypt_provider", true);
  }
  
  public static boolean a(Map<String, dqz> paramMap)
  {
    return paramMap.containsKey("^io_im");
  }
  
  static Uri b(String paramString)
  {
    return a(paramString, "/labels/");
  }
  
  public static Uri b(String paramString, long paramLong)
  {
    return a(paramString, "/messages/").buildUpon().appendEncodedPath(Long.toString(paramLong)).build();
  }
  
  public static Uri b(String paramString1, long paramLong, String paramString2)
  {
    return a(paramString1, "/messages/").buildUpon().appendEncodedPath(Long.toString(paramLong)).appendEncodedPath("labels").appendEncodedPath(m(paramString2)).build();
  }
  
  public static TextUtils.StringSplitter b()
  {
    return new dpz();
  }
  
  public static dqg b(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("account is empty");
    }
    paramString = drp.a(paramContext, paramString).c(u);
    try
    {
      paramContext = a(paramContext, paramString);
      return paramContext;
    }
    finally
    {
      if (paramString != null) {
        paramString.close();
      }
    }
  }
  
  public static Set<Long> b(Map<String, dqz> paramMap)
  {
    HashSet localHashSet = new HashSet();
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext()) {
      localHashSet.add(Long.valueOf(((dqz)paramMap.next()).a()));
    }
    return localHashSet;
  }
  
  public static boolean b(ContentResolver paramContentResolver)
  {
    return ghz.a(paramContentResolver, "gmail-ads-number-to-display", 1) > 0;
  }
  
  public static boolean b(Context paramContext)
  {
    return paramContext.getFilesDir().getTotalSpace() >= ghz.a(paramContext.getContentResolver(), "gmail_large_data_partition_min_threshold_bytes", 1000000000L);
  }
  
  public static Uri c(String paramString)
  {
    return a(paramString, "/label/");
  }
  
  public static Uri d(String paramString)
  {
    return a(paramString, "/settings/");
  }
  
  public static Uri e(String paramString)
  {
    return a(paramString, "/status/");
  }
  
  public static boolean f(String paramString)
  {
    return x.contains(paramString);
  }
  
  public static boolean g(String paramString)
  {
    return paramString.startsWith("^sq_ig_i_");
  }
  
  public static String h(String paramString)
  {
    Matcher localMatcher = Patterns.EMAIL_ADDRESS.matcher(paramString);
    String str = paramString;
    if (localMatcher.find()) {
      str = paramString.substring(localMatcher.start(), localMatcher.end());
    }
    return str;
  }
  
  public static boolean i(String paramString)
  {
    return (paramString != null) && (!paramString.startsWith("^"));
  }
  
  public static boolean j(String paramString)
  {
    return (y.contains(paramString)) || (i(paramString)) || (paramString.startsWith("^sq_ig_i_"));
  }
  
  public static String k(String paramString)
  {
    String str = String.valueOf("^^unseen-");
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      return str.concat(paramString);
    }
    return new String(str);
  }
  
  private static Map<String, Uri> l(String paramString)
  {
    try
    {
      Map localMap = (Map)c.get(paramString);
      Object localObject = localMap;
      if (localMap == null)
      {
        localObject = new ConcurrentHashMap();
        c.put(paramString, localObject);
      }
      return (Map<String, Uri>)localObject;
    }
    finally {}
  }
  
  private static String m(String paramString)
  {
    try
    {
      paramString = URLEncoder.encode(paramString, "utf-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  public final void a(String paramString, ContentValues[] paramArrayOfContentValues, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("account is empty");
    }
    Uri localUri = a(paramString, "/messages/").buildUpon().appendEncodedPath("labels").build();
    paramString = localUri;
    if (paramBoolean) {
      paramString = localUri.buildUpon().appendQueryParameter("suppressUINotifications", Boolean.TRUE.toString()).build();
    }
    w.bulkInsert(paramString, paramArrayOfContentValues);
  }
}

/* Location:
 * Qualified Name:     dpy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */