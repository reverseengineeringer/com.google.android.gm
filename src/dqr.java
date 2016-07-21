import android.database.Cursor;
import android.text.TextUtils;
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

public class dqr
{
  private static final Map<String, String> A = new hen().b("social", "^smartlabel_social").b("promotions", "^smartlabel_promo").b("updates", "^smartlabel_notification").b("forums", "^smartlabel_group").b();
  private static final Map<String, String> B = new hen().b("^iim", "^iim").b("^i", "inbox").b("^all", "all").b("^f", "sent").b("^r", "drafts").b("^t", "starred").b("^im", "imp").b("^io_im", "imp").b("^b", "chats").b("^s", "spam").b("^k", "trash").b();
  public static final Pattern a = Pattern.compile("\\b(is|in|label):\\s*unread\\b");
  public static final Pattern b = Pattern.compile("\\b(is|in|label):\\s*starred\\b");
  public static final Pattern c = Pattern.compile("\\b(is|in|label):\\s*chat\\b");
  public static final Pattern d = Pattern.compile("\\b(is|in|label):\\s*important\\b");
  public static final Pattern e = Pattern.compile("\\bhas:attachment\\b");
  public static final Pattern f;
  static final String[] g;
  static final String[] h;
  private static final Pattern s = Pattern.compile("(^|\\s+)to:\\s*(\\S+)");
  private static final Pattern t = Pattern.compile("(^|\\s+)from:\\s*(\\S+)");
  private static final Pattern u = Pattern.compile("\\b(in|label):\\s*(\\S+)");
  private static final Pattern v = Pattern.compile("\\bcategory:\\s*(social|promotions|updates|forums)\\b");
  private static final Pattern w = Pattern.compile("\\bsubject:\\s*(\\S+)");
  private static final Pattern x = Pattern.compile("\\bis:\\s*(starred|chat|important|unread|muted)\\b");
  private static final Pattern y = Pattern.compile("\\bis:read\\b");
  private static final Map<String, String> z;
  private final Set<String> C;
  private final boolean D;
  public final dro i;
  public final String j;
  public final String k;
  final Set<String> l;
  final Set<String> m;
  final Set<Long> n;
  final Set<String> o;
  boolean p;
  boolean q;
  public String r;
  
  static
  {
    f = Pattern.compile("\\\"(.*)\\\"");
    g = new String[] { "conversations.subject", "conversations.snippet", "conversations.fromAddress" };
    h = new String[] { "subject", "snippet", "body" };
    z = new hen().b("starred", "^t").b("chat", "^b").b("chats", "^b").b("important", "^io_im").b("unread", "^u").b("muted", "^g").b("^iim", "^iim").b("inbox", "^i").b("all", "^all").b("sent", "^f").b("drafts", "^r").b("imp", "^io_im").b("spam", "^s").b("trash", "^k").b();
  }
  
  public dqr(dro paramdro, String paramString1, String paramString2, boolean paramBoolean)
  {
    i = paramdro;
    j = paramString1;
    l = new HashSet();
    m = new HashSet();
    n = new HashSet();
    o = new HashSet();
    p = false;
    q = false;
    C = new HashSet();
    k = paramString2;
    D = paramBoolean;
    a(s, l);
    a(t, m);
    d();
    b(w, o);
    e();
    r = f();
  }
  
  private static ArrayList<String> a(String[] paramArrayOfString, int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    int i1 = 0;
    while (i1 < paramInt)
    {
      ArrayList localArrayList2 = new ArrayList();
      int i3 = paramArrayOfString.length;
      int i2 = 0;
      while (i2 < i3)
      {
        localArrayList2.add(String.valueOf(paramArrayOfString[i2]).concat(" LIKE ?"));
        i2 += 1;
      }
      localStringBuilder.setLength(0);
      localStringBuilder.append("conversations._id IN (SELECT conversation FROM messages WHERE ");
      localStringBuilder.append(TextUtils.join(" OR ", localArrayList2));
      localStringBuilder.append(')');
      localArrayList1.add(localStringBuilder.toString());
      i1 += 1;
    }
    return localArrayList1;
  }
  
  private final List<MatchResult> a(Pattern paramPattern)
  {
    return a(paramPattern, k);
  }
  
  private static List<MatchResult> a(Pattern paramPattern, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramPattern = paramPattern.matcher(paramString);
    for (int i1 = 0; paramPattern.find(i1); i1 = paramPattern.end()) {
      localArrayList.add(paramPattern.toMatchResult());
    }
    return localArrayList;
  }
  
  private static List<String> a(String[] paramArrayOfString)
  {
    ArrayList localArrayList1 = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    int i1 = 0;
    while (i1 < paramArrayOfString.length)
    {
      ArrayList localArrayList2 = new ArrayList();
      localArrayList2.add("conversations._id IN (SELECT docid FROM conversation_fts_table WHERE conversation_fts_table MATCH ? )");
      localArrayList2.add("conversations._id IN (SELECT conversation FROM message_fts_table WHERE message_fts_table MATCH ? )");
      localStringBuilder.setLength(0);
      localStringBuilder.append('(');
      localStringBuilder.append(TextUtils.join(" OR ", localArrayList2));
      localStringBuilder.append(')');
      localArrayList1.add(localStringBuilder.toString());
      i1 += 1;
    }
    return localArrayList1;
  }
  
  private static void a(Collection<String> paramCollection, int paramInt, List<String> paramList)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      String str = (String)paramCollection.next();
      str = String.valueOf(str).length() + 2 + "\"" + str + "\"";
      int i1 = 0;
      while (i1 < paramInt)
      {
        paramList.add(str);
        i1 += 1;
      }
    }
  }
  
  private final void a(MatchResult paramMatchResult, String paramString)
  {
    drk localdrk2 = i.a(paramString);
    drk localdrk1 = localdrk2;
    if (localdrk2 == null)
    {
      paramString = (String)z.get(paramString);
      localdrk1 = i.a(paramString);
    }
    if (localdrk1 != null)
    {
      paramMatchResult = paramMatchResult.group();
      n.add(Long.valueOf(a));
      C.add(paramMatchResult);
    }
  }
  
  private final void a(Set<String> paramSet)
  {
    Iterator localIterator = a(paramSet).iterator();
    if (localIterator.hasNext())
    {
      Object localObject2 = (MatchResult)localIterator.next();
      paramSet = ((MatchResult)localObject2).group(2);
      localObject2 = ((MatchResult)localObject2).group();
      if ("me".equals(paramSet)) {
        paramSet = j;
      }
      for (;;)
      {
        Object localObject1;
        ((Set)localObject1).add(paramSet);
        C.add(localObject2);
        break;
      }
    }
  }
  
  private static List<String> b(String[] paramArrayOfString)
  {
    ArrayList localArrayList1 = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    int i1 = 0;
    while (i1 < paramArrayOfString.length)
    {
      ArrayList localArrayList2 = new ArrayList();
      Object localObject = g;
      int i3 = localObject.length;
      int i2 = 0;
      while (i2 < i3)
      {
        localArrayList2.add(String.valueOf(localObject[i2]).concat(" LIKE ?"));
        i2 += 1;
      }
      localObject = new ArrayList();
      String[] arrayOfString = h;
      i3 = arrayOfString.length;
      i2 = 0;
      while (i2 < i3)
      {
        ((ArrayList)localObject).add(String.valueOf(arrayOfString[i2]).concat(" LIKE ?"));
        i2 += 1;
      }
      localStringBuilder.setLength(0);
      localStringBuilder.append("conversations._id IN (SELECT conversation FROM messages WHERE ");
      localStringBuilder.append(TextUtils.join(" OR ", (Iterable)localObject));
      localStringBuilder.append(')');
      localArrayList2.add(localStringBuilder.toString());
      localStringBuilder.setLength(0);
      localStringBuilder.append('(');
      localStringBuilder.append(TextUtils.join(" OR ", localArrayList2));
      localStringBuilder.append(')');
      localArrayList1.add(localStringBuilder.toString());
      i1 += 1;
    }
    return localArrayList1;
  }
  
  private static void b(Collection<String> paramCollection, int paramInt, List<String> paramList)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      String str = (String)paramCollection.next();
      str = String.valueOf(str).length() + 2 + "%" + str + "%";
      int i1 = 0;
      while (i1 < paramInt)
      {
        paramList.add(str);
        i1 += 1;
      }
    }
  }
  
  private final void b(Set<String> paramSet)
  {
    paramSet = a(paramSet).iterator();
    while (paramSet.hasNext())
    {
      Object localObject2 = (MatchResult)paramSet.next();
      String str = ((MatchResult)localObject2).group(1);
      localObject2 = ((MatchResult)localObject2).group();
      Object localObject1;
      ((Set)localObject1).add(str);
      C.add(localObject2);
    }
  }
  
  private final String[] c()
  {
    HashSet localHashSet = new HashSet();
    Object localObject2 = new HashSet();
    Object localObject1 = a(f, r).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      MatchResult localMatchResult = (MatchResult)((Iterator)localObject1).next();
      String str = localMatchResult.group(1);
      ((Set)localObject2).add(localMatchResult.group());
      localHashSet.add(str.trim());
    }
    localObject1 = r;
    localObject2 = ((Set)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      localObject1 = ((String)localObject1).replace((String)((Iterator)localObject2).next(), " ");
    }
    localObject2 = TextUtils.split((String)localObject1, " ");
    int i2 = localObject2.length;
    int i1 = 0;
    if (i1 < i2)
    {
      localObject1 = localObject2[i1];
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
      for (localObject1 = ((String)localObject1).replace("\"", "");; localObject1 = null)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localHashSet.add(localObject1);
        }
        i1 += 1;
        break;
      }
    }
    return (String[])localHashSet.toArray(new String[localHashSet.size()]);
  }
  
  private final void d()
  {
    Iterator localIterator = a(u).iterator();
    MatchResult localMatchResult;
    while (localIterator.hasNext())
    {
      localMatchResult = (MatchResult)localIterator.next();
      a(localMatchResult, localMatchResult.group(2));
    }
    localIterator = a(v).iterator();
    String str;
    while (localIterator.hasNext())
    {
      localMatchResult = (MatchResult)localIterator.next();
      str = localMatchResult.group(1);
      str = (String)A.get(str);
      if (str != null) {
        a(localMatchResult, str);
      }
    }
    localIterator = a(x).iterator();
    while (localIterator.hasNext())
    {
      localMatchResult = (MatchResult)localIterator.next();
      str = localMatchResult.group(1);
      str = (String)z.get(str);
      if (str != null) {
        a(localMatchResult, str);
      }
    }
    localIterator = a(y).iterator();
    while (localIterator.hasNext())
    {
      localMatchResult = (MatchResult)localIterator.next();
      C.add(localMatchResult.group());
      q = true;
    }
  }
  
  private final void e()
  {
    Iterator localIterator = a(e).iterator();
    while (localIterator.hasNext())
    {
      MatchResult localMatchResult = (MatchResult)localIterator.next();
      C.add(localMatchResult.group());
      p = true;
    }
  }
  
  private final String f()
  {
    String str = k;
    Iterator localIterator = C.iterator();
    while (localIterator.hasNext()) {
      str = str.replace((String)localIterator.next(), "");
    }
    return str.trim();
  }
  
  Cursor a(Cursor paramCursor)
  {
    return paramCursor;
  }
  
  CharSequence a(int paramInt)
  {
    return null;
  }
  
  String a()
  {
    int i2 = 0;
    Object localObject = c();
    ArrayList localArrayList = new ArrayList();
    if (D) {
      localArrayList.addAll(a((String[])localObject));
    }
    for (;;)
    {
      localArrayList.addAll(a(drp.d, l.size()));
      localArrayList.addAll(a(drp.e, m.size()));
      i1 = 0;
      while (i1 < n.size())
      {
        localArrayList.add("conversation_labels.conversation_id IN\n(SELECT conversation_labels.conversation_id\n   FROM conversation_labels\n   LEFT OUTER JOIN conversations\n     ON conversation_labels.conversation_id = conversations._id\n     AND conversation_labels.queryId = conversations.queryId\n WHERE conversation_labels.labels_id = ?)\n   AND conversation_labels.labels_id = ? ");
        i1 += 1;
      }
      localArrayList.addAll(b((String[])localObject));
    }
    int i1 = i2;
    if (q)
    {
      localObject = Long.toString(i.b("^u").a);
      localArrayList.add(String.valueOf(localObject).length() + 38 + "conversations.labelIds NOT LIKE '%," + (String)localObject + ",%'");
      i1 = i2;
    }
    while (i1 < o.size())
    {
      localArrayList.add("conversations.subject LIKE ?");
      i1 += 1;
    }
    if (p) {
      localArrayList.add("conversations.hasAttachments != 0");
    }
    return TextUtils.join(" AND ", localArrayList);
  }
  
  List<String> b()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = Arrays.asList(c());
    if (D) {
      a((Collection)localObject, drp.c.length, localArrayList);
    }
    for (;;)
    {
      b(l, drp.d.length, localArrayList);
      b(m, drp.e.length, localArrayList);
      localObject = n.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = ((Long)((Iterator)localObject).next()).toString();
        localArrayList.add(str);
        localArrayList.add(str);
      }
      b((Collection)localObject, g.length + h.length, localArrayList);
    }
    b(o, 1, localArrayList);
    return localArrayList;
  }
}

/* Location:
 * Qualified Name:     dqr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */