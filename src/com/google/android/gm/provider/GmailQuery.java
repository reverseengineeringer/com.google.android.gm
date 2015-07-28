package com.google.android.gm.provider;

import android.text.TextUtils;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GmailQuery
{
  static final String ALL_MAIL_SEARCH_NAME = "all";
  public static final Pattern ATTACHMENT_QUERY_PATTERN;
  private static final Map<String, String> CANONICAL_NAME_LABEL_OPERATION_MAP = new ImmutableMap.Builder().put("^iim", "^iim").put("^i", "inbox").put("^all", "all").put("^f", "sent").put("^r", "drafts").put("^t", "starred").put("^im", "imp").put("^io_im", "imp").put("^b", "chats").put("^s", "spam").put("^k", "trash").build();
  public static final Pattern CHAT_PATTERN;
  static final String CHAT_SEARCH_NAME = "chats";
  static final String DRAFT_SEARCH_NAME = "drafts";
  private static final Pattern FROM_PATTERN;
  public static final Pattern IMPORTANT_PATTERN;
  static final String IMPORTANT_SEARCH_NAME = "imp";
  static final String INBOX_SEARCH_NAME = "inbox";
  private static final Pattern IS_READ_PATTERN;
  private static final Map<String, String> LABEL_OPERATION_CANONICAL_NAME_MAP;
  private static final Pattern LABEL_PATTERN;
  static final String[] LOCAL_CONVERSATION_SEARCH_COLUMNS;
  static final String[] LOCAL_MESSAGE_SEARCH_COLUMNS;
  static final String PRIORITY_INBOX_SEARCH_NAME = "^iim";
  private static final Pattern QUOTED_TEXT_PATTERN;
  static final String SENT_MAIL_SEARCH_NAME = "sent";
  static final String SPAM_SEARCH_NAME = "spam";
  private static final Pattern SPECIAL_LABEL_PATTERN;
  static final String STARRED_SEARCH_NAME = "starred";
  public static final Pattern STAR_PATTERN;
  private static final Pattern SUBJECT_PATTERN;
  private static final Pattern TO_PATTERN;
  static final String TRASH_SEARCH_NAME = "trash";
  public static final Pattern UNREAD_PATTERN = Pattern.compile("\\b(is|in|label):\\s*unread\\b");
  private final String mAccount;
  boolean mAttachmentQuery;
  private final Set<String> mFoundOperations;
  final Set<String> mFromFilters;
  private final boolean mFtsEnabled;
  boolean mIsReadQuery;
  private final MailCoreLabelAccess mLabelAccess;
  final Set<Long> mLabelFilters;
  private final String mQueryString;
  private String mRemainingQuery;
  final Set<String> mSubjectFilters;
  final Set<String> mToFilters;
  
  static
  {
    STAR_PATTERN = Pattern.compile("\\b(is|in|label):\\s*starred\\b");
    CHAT_PATTERN = Pattern.compile("\\b(is|in|label):\\s*chat\\b");
    IMPORTANT_PATTERN = Pattern.compile("\\b(is|in|label):\\s*important\\b");
    ATTACHMENT_QUERY_PATTERN = Pattern.compile("\\bhas:attachment\\b");
    TO_PATTERN = Pattern.compile("(^|\\s+)to:\\s*(\\S+)");
    FROM_PATTERN = Pattern.compile("(^|\\s+)from:\\s*(\\S+)");
    LABEL_PATTERN = Pattern.compile("\\b(in|label):\\s*(\\S+)");
    SUBJECT_PATTERN = Pattern.compile("\\bsubject:\\s*(\\S+)");
    SPECIAL_LABEL_PATTERN = Pattern.compile("\\bis:\\s*(starred|chat|important|unread|muted)\\b");
    IS_READ_PATTERN = Pattern.compile("\\bis:read\\b");
    QUOTED_TEXT_PATTERN = Pattern.compile("\\\"(.*)\\\"");
    LOCAL_CONVERSATION_SEARCH_COLUMNS = new String[] { "conversations.subject", "conversations.snippet", "conversations.fromAddress" };
    LOCAL_MESSAGE_SEARCH_COLUMNS = new String[] { "subject", "snippet", "body" };
    LABEL_OPERATION_CANONICAL_NAME_MAP = new ImmutableMap.Builder().put("starred", "^t").put("chat", "^b").put("chats", "^b").put("important", "^io_im").put("unread", "^u").put("muted", "^g").put("^iim", "^iim").put("inbox", "^i").put("all", "^all").put("sent", "^f").put("drafts", "^r").put("imp", "^io_im").put("spam", "^s").put("trash", "^k").build();
  }
  
  public GmailQuery(MailCoreLabelAccess paramMailCoreLabelAccess, String paramString1, String paramString2, boolean paramBoolean)
  {
    mLabelAccess = paramMailCoreLabelAccess;
    mAccount = paramString1;
    mToFilters = Sets.newHashSet();
    mFromFilters = Sets.newHashSet();
    mLabelFilters = Sets.newHashSet();
    mSubjectFilters = Sets.newHashSet();
    mAttachmentQuery = false;
    mIsReadQuery = false;
    mFoundOperations = Sets.newHashSet();
    mQueryString = paramString2;
    mFtsEnabled = paramBoolean;
    parse();
  }
  
  private List<String> addFullTextSearchClauses(String[] paramArrayOfString)
  {
    ArrayList localArrayList1 = Lists.newArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      ArrayList localArrayList2 = Lists.newArrayList();
      localArrayList2.add("conversations._id IN (SELECT docid FROM conversation_fts_table WHERE conversation_fts_table MATCH ? )");
      localArrayList2.add("conversations._id IN (SELECT conversation FROM message_fts_table WHERE message_fts_table MATCH ? )");
      localStringBuilder.setLength(0);
      localStringBuilder.append('(');
      localStringBuilder.append(TextUtils.join(" OR ", localArrayList2));
      localStringBuilder.append(')');
      localArrayList1.add(localStringBuilder.toString());
      i += 1;
    }
    return localArrayList1;
  }
  
  private void addFullTextSearchToArgList(Collection<String> paramCollection, int paramInt, List<String> paramList)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      String str = (String)paramCollection.next();
      str = "\"" + str + "\"";
      int i = 0;
      while (i < paramInt)
      {
        paramList.add(str);
        i += 1;
      }
    }
  }
  
  private void addLabelQueryOperation(MatchResult paramMatchResult, String paramString)
  {
    MailCore.Label localLabel2 = mLabelAccess.getLabelOrNull(paramString);
    MailCore.Label localLabel1 = localLabel2;
    if (localLabel2 == null)
    {
      paramString = (String)LABEL_OPERATION_CANONICAL_NAME_MAP.get(paramString);
      localLabel1 = mLabelAccess.getLabelOrNull(paramString);
    }
    if (localLabel1 != null)
    {
      paramMatchResult = paramMatchResult.group();
      mLabelFilters.add(Long.valueOf(id));
      mFoundOperations.add(paramMatchResult);
    }
  }
  
  private List<String> addLikeSearchClauses(String[] paramArrayOfString)
  {
    ArrayList localArrayList1 = Lists.newArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      ArrayList localArrayList2 = Lists.newArrayList();
      Object localObject1 = LOCAL_CONVERSATION_SEARCH_COLUMNS;
      int k = localObject1.length;
      int j = 0;
      while (j < k)
      {
        localObject2 = localObject1[j];
        localArrayList2.add((String)localObject2 + " LIKE ?");
        j += 1;
      }
      localObject1 = Lists.newArrayList();
      Object localObject2 = LOCAL_MESSAGE_SEARCH_COLUMNS;
      k = localObject2.length;
      j = 0;
      while (j < k)
      {
        String str = localObject2[j];
        ((ArrayList)localObject1).add(str + " LIKE ?");
        j += 1;
      }
      localStringBuilder.setLength(0);
      localStringBuilder.append("conversations._id IN (SELECT conversation FROM messages WHERE ");
      localStringBuilder.append(TextUtils.join(" OR ", (Iterable)localObject1));
      localStringBuilder.append(')');
      localArrayList2.add(localStringBuilder.toString());
      localStringBuilder.setLength(0);
      localStringBuilder.append('(');
      localStringBuilder.append(TextUtils.join(" OR ", localArrayList2));
      localStringBuilder.append(')');
      localArrayList1.add(localStringBuilder.toString());
      i += 1;
    }
    return localArrayList1;
  }
  
  private void addTokensToArgList(Collection<String> paramCollection, int paramInt, List<String> paramList)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      String str = createLikeParameter((String)paramCollection.next());
      int i = 0;
      while (i < paramInt)
      {
        paramList.add(str);
        i += 1;
      }
    }
  }
  
  private String createLikeParameter(String paramString)
  {
    return "%" + paramString + "%";
  }
  
  private List<MatchResult> findMatches(Pattern paramPattern)
  {
    return findMatches(paramPattern, mQueryString);
  }
  
  private static List<MatchResult> findMatches(Pattern paramPattern, String paramString)
  {
    ArrayList localArrayList = Lists.newArrayList();
    paramPattern = paramPattern.matcher(paramString);
    for (int i = 0; paramPattern.find(i); i = paramPattern.end()) {
      localArrayList.add(paramPattern.toMatchResult());
    }
    return localArrayList;
  }
  
  public static String getCanonicalNameForLabelOperation(String paramString)
  {
    return (String)LABEL_OPERATION_CANONICAL_NAME_MAP.get(paramString);
  }
  
  public static String getLabelQueryOperationString(String paramString)
  {
    if (CANONICAL_NAME_LABEL_OPERATION_MAP.containsKey(paramString)) {
      paramString = (String)CANONICAL_NAME_LABEL_OPERATION_MAP.get(paramString);
    }
    for (;;)
    {
      return "label:" + paramString;
    }
  }
  
  public static String getLabelSearchString(String paramString)
  {
    if (Gmail.isSystemLabel(paramString)) {
      return getSearchName(paramString);
    }
    return paramString;
  }
  
  public static String getMatchingLabelOperation(String paramString1, String paramString2)
  {
    paramString1 = findMatches(LABEL_PATTERN, paramString1).iterator();
    while (paramString1.hasNext())
    {
      MatchResult localMatchResult = (MatchResult)paramString1.next();
      String str = localMatchResult.group(2);
      if ((paramString2 != null) && (TextUtils.equals(str, paramString2))) {
        return localMatchResult.group();
      }
    }
    return null;
  }
  
  private ArrayList<String> getMessageTableQueryClauses(String[] paramArrayOfString, int paramInt)
  {
    ArrayList localArrayList1 = Lists.newArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramInt)
    {
      ArrayList localArrayList2 = Lists.newArrayList();
      int k = paramArrayOfString.length;
      int j = 0;
      while (j < k)
      {
        String str = paramArrayOfString[j];
        localArrayList2.add(str + " LIKE ?");
        j += 1;
      }
      localStringBuilder.setLength(0);
      localStringBuilder.append("conversations._id IN (SELECT conversation FROM messages WHERE ");
      localStringBuilder.append(TextUtils.join(" OR ", localArrayList2));
      localStringBuilder.append(')');
      localArrayList1.add(localStringBuilder.toString());
      i += 1;
    }
    return localArrayList1;
  }
  
  private static String getSearchName(String paramString)
  {
    String str = (String)CANONICAL_NAME_LABEL_OPERATION_MAP.get(paramString);
    if (str != null) {
      return str;
    }
    return paramString;
  }
  
  public static boolean isAttachmentQuery(String paramString)
  {
    return ATTACHMENT_QUERY_PATTERN.matcher(paramString).find();
  }
  
  public static boolean isChatQuery(String paramString)
  {
    return CHAT_PATTERN.matcher(paramString).find();
  }
  
  public static boolean isImportantQuery(String paramString)
  {
    return IMPORTANT_PATTERN.matcher(paramString).find();
  }
  
  public static boolean isStarQuery(String paramString)
  {
    return STAR_PATTERN.matcher(paramString).find();
  }
  
  public static boolean isUnreadQuery(String paramString)
  {
    return UNREAD_PATTERN.matcher(paramString).find();
  }
  
  private void parse()
  {
    parseAddressOperations(TO_PATTERN, 2, mToFilters);
    parseAddressOperations(FROM_PATTERN, 2, mFromFilters);
    parselabelOperations();
    parseQueryOperations(SUBJECT_PATTERN, 1, mSubjectFilters);
    parseAttachmentQueries();
    mRemainingQuery = getRemaingSearchQuery();
  }
  
  private void parseAddressOperations(Pattern paramPattern, int paramInt, Set<String> paramSet)
  {
    Iterator localIterator = findMatches(paramPattern).iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (MatchResult)localIterator.next();
      paramPattern = ((MatchResult)localObject).group(paramInt);
      localObject = ((MatchResult)localObject).group();
      if ("me".equals(paramPattern)) {
        paramPattern = mAccount;
      }
      for (;;)
      {
        paramSet.add(paramPattern);
        mFoundOperations.add(localObject);
        break;
      }
    }
  }
  
  private void parseAttachmentQueries()
  {
    Iterator localIterator = findMatches(ATTACHMENT_QUERY_PATTERN).iterator();
    while (localIterator.hasNext())
    {
      MatchResult localMatchResult = (MatchResult)localIterator.next();
      mFoundOperations.add(localMatchResult.group());
      mAttachmentQuery = true;
    }
  }
  
  private void parseQueryOperations(Pattern paramPattern, int paramInt, Set<String> paramSet)
  {
    paramPattern = findMatches(paramPattern).iterator();
    while (paramPattern.hasNext())
    {
      Object localObject = (MatchResult)paramPattern.next();
      String str = ((MatchResult)localObject).group(paramInt);
      localObject = ((MatchResult)localObject).group();
      paramSet.add(str);
      mFoundOperations.add(localObject);
    }
  }
  
  private void parselabelOperations()
  {
    Iterator localIterator = findMatches(LABEL_PATTERN).iterator();
    MatchResult localMatchResult;
    while (localIterator.hasNext())
    {
      localMatchResult = (MatchResult)localIterator.next();
      addLabelQueryOperation(localMatchResult, localMatchResult.group(2));
    }
    localIterator = findMatches(SPECIAL_LABEL_PATTERN).iterator();
    while (localIterator.hasNext())
    {
      localMatchResult = (MatchResult)localIterator.next();
      String str = localMatchResult.group(1);
      str = (String)LABEL_OPERATION_CANONICAL_NAME_MAP.get(str);
      if (str != null) {
        addLabelQueryOperation(localMatchResult, str);
      }
    }
    localIterator = findMatches(IS_READ_PATTERN).iterator();
    while (localIterator.hasNext())
    {
      localMatchResult = (MatchResult)localIterator.next();
      mFoundOperations.add(localMatchResult.group());
      mIsReadQuery = true;
    }
  }
  
  List<String> getQueryBindArgs()
  {
    ArrayList localArrayList = Lists.newArrayList();
    Object localObject = Arrays.asList(getQueryTokens());
    if (mFtsEnabled) {
      addFullTextSearchToArgList((Collection)localObject, MailEngine.FULL_TEXT_SEARCH_TABLES.length, localArrayList);
    }
    for (;;)
    {
      addTokensToArgList(mToFilters, MailEngine.LOCAL_MESSAGE_TO_SEARCH_COLUMNS.length, localArrayList);
      addTokensToArgList(mFromFilters, MailEngine.LOCAL_MESSAGE_FROM_SEARCH_COLUMNS.length, localArrayList);
      localObject = mLabelFilters.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = ((Long)((Iterator)localObject).next()).toString();
        localArrayList.add(str);
        localArrayList.add(str);
      }
      addTokensToArgList((Collection)localObject, LOCAL_CONVERSATION_SEARCH_COLUMNS.length + LOCAL_MESSAGE_SEARCH_COLUMNS.length, localArrayList);
    }
    addTokensToArgList(mSubjectFilters, 1, localArrayList);
    return localArrayList;
  }
  
  String getQueryLikeClause()
  {
    Object localObject = getQueryTokens();
    ArrayList localArrayList = Lists.newArrayList();
    if (mFtsEnabled) {
      localArrayList.addAll(addFullTextSearchClauses((String[])localObject));
    }
    for (;;)
    {
      localArrayList.addAll(getMessageTableQueryClauses(MailEngine.LOCAL_MESSAGE_TO_SEARCH_COLUMNS, mToFilters.size()));
      localArrayList.addAll(getMessageTableQueryClauses(MailEngine.LOCAL_MESSAGE_FROM_SEARCH_COLUMNS, mFromFilters.size()));
      i = 0;
      while (i < mLabelFilters.size())
      {
        localArrayList.add("conversation_labels.conversation_id IN\n(SELECT conversation_labels.conversation_id\n   FROM conversation_labels\n   LEFT OUTER JOIN conversations\n     ON conversation_labels.conversation_id = conversations._id\n     AND conversation_labels.queryId = conversations.queryId\n WHERE conversation_labels.labels_id = ?)\n   AND conversation_labels.labels_id = ? ");
        i += 1;
      }
      localArrayList.addAll(addLikeSearchClauses((String[])localObject));
    }
    if (mIsReadQuery)
    {
      localObject = Long.toString(mLabelAccess.getLabelOrThrow("^u").id);
      localArrayList.add("conversations.labelIds NOT LIKE '%," + (String)localObject + ",%'");
    }
    int i = 0;
    while (i < mSubjectFilters.size())
    {
      localArrayList.add("conversations.subject LIKE ?");
      i += 1;
    }
    if (mAttachmentQuery) {
      localArrayList.add("conversations.hasAttachments != 0");
    }
    return TextUtils.join(" AND ", localArrayList);
  }
  
  String[] getQueryTokens()
  {
    HashSet localHashSet = Sets.newHashSet();
    Object localObject2 = Sets.newHashSet();
    Object localObject1 = findMatches(QUOTED_TEXT_PATTERN, mRemainingQuery).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      MatchResult localMatchResult = (MatchResult)((Iterator)localObject1).next();
      String str = localMatchResult.group(1);
      ((Set)localObject2).add(localMatchResult.group());
      localHashSet.add(str.trim());
    }
    localObject1 = mRemainingQuery;
    localObject2 = ((Set)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      localObject1 = ((String)localObject1).replace((String)((Iterator)localObject2).next(), " ");
    }
    localObject2 = TextUtils.split((String)localObject1, " ");
    int j = localObject2.length;
    int i = 0;
    if (i < j)
    {
      localObject1 = localObject2[i];
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
      for (localObject1 = ((String)localObject1).replace("\"", "");; localObject1 = null)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localHashSet.add(localObject1);
        }
        i += 1;
        break;
      }
    }
    return (String[])localHashSet.toArray(new String[localHashSet.size()]);
  }
  
  String getRemaingSearchQuery()
  {
    String str = mQueryString;
    Iterator localIterator = mFoundOperations.iterator();
    while (localIterator.hasNext()) {
      str = str.replace((String)localIterator.next(), "");
    }
    return str.trim();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.GmailQuery
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */