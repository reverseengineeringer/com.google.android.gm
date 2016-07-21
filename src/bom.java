import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.TransactionTooLargeException;
import android.text.Html;
import android.text.SpannedString;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.MimeTypeMap;
import com.android.emailcommon.mail.Address;
import com.android.emailcommon.provider.Attachment;
import com.android.emailcommon.provider.Mailbox;
import com.android.emailcommon.provider.Policy;
import com.android.exchange.adapter.Parser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class bom
  extends bnx
{
  private static final String[] w = { "_id", "subject" };
  final ArrayList<Long> f = new ArrayList();
  final Set<String> g = new HashSet();
  final Map<String, bpq> h = new HashMap();
  public final Map<String, Integer> i = new HashMap();
  private final String n = Long.toString(a.D);
  private final ArrayList<beb> o = new ArrayList();
  private final ArrayList<beb> p = new ArrayList();
  private final ArrayList<bon> q = new ArrayList();
  private final ArrayList<beb> r = new ArrayList();
  private final Map<String, String> s = new HashMap();
  private final Map<String, String> t = new HashMap();
  private final Map<String, bpq> u = new HashMap();
  private final Map<String, Long> v = new HashMap();
  private final Policy x;
  private boolean y = false;
  
  public bom(Context paramContext, ContentResolver paramContentResolver, InputStream paramInputStream, Mailbox paramMailbox, com.android.emailcommon.provider.Account paramAccount)
  {
    super(paramContext, paramContentResolver, paramInputStream, paramMailbox, paramAccount);
    if (b.o != 0L)
    {
      x = Policy.a(c, b.o);
      return;
    }
    x = null;
  }
  
  public bom(Context paramContext, ContentResolver paramContentResolver, InputStream paramInputStream, Mailbox paramMailbox, com.android.emailcommon.provider.Account paramAccount, Map<String, bpq> paramMap1, Map<String, bpq> paramMap2, Map<String, Long> paramMap)
  {
    this(paramContext, paramContentResolver, paramInputStream, paramMailbox, paramAccount);
    u.putAll(paramMap1);
    h.putAll(paramMap2);
    v.putAll(paramMap);
  }
  
  public bom(Context paramContext, InputStream paramInputStream, Mailbox paramMailbox, com.android.emailcommon.provider.Account paramAccount)
  {
    this(paramContext, paramContext.getContentResolver(), paramInputStream, paramMailbox, paramAccount);
  }
  
  public bom(Parser paramParser, Context paramContext, ContentResolver paramContentResolver, Mailbox paramMailbox, com.android.emailcommon.provider.Account paramAccount)
  {
    super(paramParser, paramContext, paramContentResolver, paramMailbox, paramAccount);
    if (b.o != 0L)
    {
      x = Policy.a(c, b.o);
      return;
    }
    x = null;
  }
  
  private final Cursor a(String paramString, String[] paramArrayOfString)
  {
    paramArrayOfString = d.query(beb.a, paramArrayOfString, "syncServerId=? AND mailboxKey=?", new String[] { paramString, n }, null);
    if (paramArrayOfString == null) {
      throw new bej();
    }
    if (paramArrayOfString.getCount() > 1)
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() == 0) {
        break label73;
      }
    }
    label73:
    for (paramString = "Multiple messages with the same serverId/mailbox: ".concat(paramString);; paramString = new String("Multiple messages with the same serverId/mailbox: ")) {
      return paramArrayOfString;
    }
  }
  
  private static void a(bdl parambdl, String paramString1, ContentValues paramContentValues, String paramString2)
  {
    parambdl = parambdl.a(paramString1);
    if (!TextUtils.isEmpty(parambdl)) {
      paramContentValues.put(paramString2, parambdl);
    }
  }
  
  private final void a(beb parambeb)
  {
    bdm localbdm = new bdm();
    while (b(162) != 3)
    {
      String str;
      switch (l)
      {
      default: 
        i();
        break;
      case 157: 
        localbdm.a("DTSTAMP", g());
        break;
      case 177: 
        localbdm.a("DTSTART", g());
        break;
      case 158: 
        localbdm.a("DTEND", g());
        break;
      case 163: 
        localbdm.a("ORGMAIL", g());
        break;
      case 161: 
        localbdm.a("LOC", g());
        break;
      case 180: 
        str = bsx.c(g());
        localbdm.a("UID", str);
        ad = str;
        break;
      case 155: 
        a(l);
        break;
      case 167: 
        str = null;
        int j = -1;
        int k = -1;
        int m = -1;
        int i1 = -1;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        while (b(167) != 3) {
          switch (l)
          {
          case 168: 
          default: 
            i();
            break;
          case 169: 
            i4 = h();
            break;
          case 172: 
            i2 = h();
            break;
          case 171: 
            i3 = h();
            break;
          case 173: 
            i1 = h();
            break;
          case 174: 
            m = h();
            break;
          case 175: 
            k = h();
            break;
          case 176: 
            j = h();
            break;
          case 170: 
            str = g();
          }
        }
        localbdm.a("RRULE", bsx.a(i4, i3, i2, i1, m, k, j, str));
        break;
      case 166: 
        localbdm.a("RESPONSE", g());
        break;
      case 154: 
        if (h() == 1) {
          localbdm.a("ALLDAY", "1");
        }
        break;
      case 296: 
        if (bnq.c(b.l))
        {
          str = g();
          localbdm.a("UID", str);
          ad = str;
        }
        break;
      }
    }
    if (o != null) {
      localbdm.a("TITLE", o);
    }
    ac = localbdm.toString();
  }
  
  private static void a(beb parambeb, String paramString)
  {
    if ((parambeb != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramString = Address.d(paramString);
      if ((paramString != null) && (paramString.length > 0)) {
        m = paramString[0].c();
      }
      X = Address.a(paramString);
    }
  }
  
  private final void a(ArrayList<bon> paramArrayList)
  {
    int j = 0;
    long l = 0L;
    Object localObject3 = Boolean.valueOf(false);
    Object localObject2 = Boolean.valueOf(false);
    while (b(8) != 3)
    {
      Object localObject1;
      Object localObject4;
      boolean bool;
      switch (this.l)
      {
      default: 
        i();
        break;
      case 13: 
        localObject1 = g();
        localObject4 = a((String)localObject1, beb.h);
        try
        {
          if (((Cursor)localObject4).moveToFirst()) {
            if (((Cursor)localObject4).getInt(4) == 1)
            {
              bool = true;
              localObject1 = Boolean.valueOf(bool);
              if (((Cursor)localObject4).getInt(6) != 1) {
                break label179;
              }
              bool = true;
              localObject2 = Boolean.valueOf(bool);
              j = ((Cursor)localObject4).getInt(8);
              l = ((Cursor)localObject4).getLong(0);
            }
          }
          for (;;)
          {
            ((Cursor)localObject4).close();
            localObject3 = localObject2;
            localObject2 = localObject1;
            break;
            bool = false;
            break label105;
            bool = false;
            break label128;
            cvm.d("Exchange", "Could not load message '%s' in EmailSyncParser", new Object[] { localObject1 });
            localObject1 = localObject2;
            localObject2 = localObject3;
          }
          localBoolean = null;
        }
        finally
        {
          ((Cursor)localObject4).close();
        }
      case 29: 
        label105:
        label128:
        label179:
        Boolean localBoolean;
        localObject4 = null;
        localObject1 = null;
        while (b(29) != 3) {
          switch (this.l)
          {
          default: 
            i();
            break;
          case 149: 
            if (h() == 1) {}
            for (bool = true;; bool = false)
            {
              localBoolean = Boolean.valueOf(bool);
              break;
            }
          case 186: 
            localObject4 = k();
            break;
          case 1419: 
            int k = h();
            Integer localInteger = Integer.valueOf(0xFFF3FFFF & j);
            if ((k == 1) || (k == 2))
            {
              localObject1 = Integer.valueOf(localInteger.intValue() | 0x40000);
            }
            else
            {
              localObject1 = localInteger;
              if (k == 3) {
                localObject1 = Integer.valueOf(localInteger.intValue() | 0x80000);
              }
            }
            break;
          }
        }
        if ((l != 0L) && (((localBoolean != null) && (!((Boolean)localObject2).equals(localBoolean))) || ((localObject4 != null) && (!((Boolean)localObject3).equals(localObject4))) || (localObject1 != null))) {
          paramArrayList.add(new bon(l, localBoolean, (Boolean)localObject4, (Integer)localObject1));
        }
        break;
      }
    }
  }
  
  private final void a()
  {
    Iterator localIterator = localIterator.iterator();
    while (localIterator.hasNext())
    {
      beb localbeb = (beb)localIterator.next();
      Long localLong = b(x);
      ArrayList localArrayList;
      if (localLong != null)
      {
        cvm.c("Exchange", "Fetched body successfully for %s", new Object[] { localLong });
        String[] arrayOfString = new String[1];
        arrayOfString[0] = String.valueOf(localLong);
        localArrayList.add(ContentProviderOperation.newUpdate(bds.a).withSelection("messageKey=?", arrayOfString).withValue("textContent", ax).build());
        localArrayList.add(ContentProviderOperation.newUpdate(beb.a).withSelection("_id=?", arrayOfString).withValue("flagLoaded", Integer.valueOf(1)).build());
      }
      int j;
      a(localArrayList, j, false);
    }
  }
  
  private final void a()
  {
    ;
    Iterator localIterator = ((ArrayList)localObject1).iterator();
    ArrayList localArrayList;
    int j;
    label159:
    Object localObject2;
    bon localbon;
    label216:
    label220:
    while (localIterator.hasNext())
    {
      beb localbeb = (beb)localIterator.next();
      localObject1 = b(x);
      if (localObject1 != null)
      {
        D = ((Long)localObject1).longValue();
        if (aC)
        {
          ae = n;
          localArrayList.add(ContentProviderOperation.newDelete(ContentUris.withAppendedId(Attachment.c, D)).build());
          localArrayList.add(ContentProviderOperation.newDelete(bds.a).withSelection("messageKey=?", new String[] { String.valueOf(D) }).build());
          localbeb.a(localArrayList);
          a(localArrayList, j, false);
        }
        else
        {
          if (aD)
          {
            localObject1 = Boolean.valueOf(p);
            if (!aE) {
              break label216;
            }
          }
          for (localObject2 = Boolean.valueOf(s);; localObject2 = null)
          {
            if ((localObject1 == null) && (localObject2 == null)) {
              break label220;
            }
            localbon.add(new bon(D, (Boolean)localObject1, (Boolean)localObject2, null));
            break;
            localObject1 = null;
            break label159;
          }
        }
      }
    }
    if (!localbon.isEmpty())
    {
      localObject1 = localbon.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localbon = (bon)((Iterator)localObject1).next();
        localObject2 = new ContentValues();
        if (b != null) {
          ((ContentValues)localObject2).put("flagRead", b);
        }
        if (c != null) {
          ((ContentValues)localObject2).put("flagFavorite", c);
        }
        if (d != null) {
          ((ContentValues)localObject2).put("flags", d);
        }
        localArrayList.add(ContentProviderOperation.newUpdate(ContentUris.withAppendedId(beb.a, a)).withValues((ContentValues)localObject2).build());
        a(localArrayList, j, false);
      }
    }
  }
  
  private final void a()
  {
    Iterator localIterator = localIterator.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      Object localObject1;
      Object localObject3 = (bpq)((Map)localObject1).get(((Map.Entry)localObject2).getKey());
      long l1 = b;
      ArrayList localArrayList;
      if ((n & 0x80) != 0) {
        localArrayList.add(ContentProviderOperation.newDelete(ContentUris.withAppendedId(beb.a, l1)).build());
      }
      for (;;)
      {
        int j;
        a(localArrayList, j, false);
        break;
        long l2 = l;
        localObject3 = (String)((Map.Entry)localObject2).getValue();
        if (localObject3 == null)
        {
          cvm.f("Exchange", "Server id is not found for draft (client id: %s). But the draft is not marked as to-be-sent.", new Object[] { ((Map.Entry)localObject2).getKey() });
          break;
        }
        localObject2 = new ContentValues();
        ((ContentValues)localObject2).put("draftUpsyncTimestamp", Long.valueOf(l2));
        ((ContentValues)localObject2).put("syncServerId", (String)localObject3);
        localArrayList.add(ContentProviderOperation.newUpdate(ContentUris.withAppendedId(beb.a, l1)).withValues((ContentValues)localObject2).build());
      }
    }
  }
  
  private final void a()
  {
    Iterator localIterator = localIterator.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1;
      Object localObject2 = (bpq)((Map)localObject1).get((String)localIterator.next());
      long l1 = b;
      ArrayList localArrayList;
      int j;
      if ((n & 0x80) != 0)
      {
        localArrayList.add(ContentProviderOperation.newDelete(ContentUris.withAppendedId(beb.a, l1)).build());
        a(localArrayList, j, false);
      }
      else
      {
        long l2 = l;
        Object localObject3 = new ContentValues();
        ((ContentValues)localObject3).put("draftUpsyncTimestamp", Long.valueOf(l2));
        localArrayList.add(ContentProviderOperation.newUpdate(ContentUris.withAppendedId(beb.a, l1)).withValues((ContentValues)localObject3).build());
        a(localArrayList, j, false);
        localObject2 = s.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          localArrayList.add(ContentProviderOperation.newDelete(Attachment.b).withSelection("messageKey=? AND fileReference=?", new String[] { Long.toString(l1), localObject3 }).build());
          a(localArrayList, j, false);
        }
      }
    }
  }
  
  private final void a(ArrayList<ContentProviderOperation> paramArrayList, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) || (paramArrayList.size() >= paramInt))
    {
      d.applyBatch(bdv.F, new ArrayList(paramArrayList));
      paramArrayList.clear();
    }
  }
  
  private final void a(ArrayList<Attachment> paramArrayList, beb parambeb, int paramInt)
  {
    int k;
    Object localObject;
    String str1;
    int j;
    String str2;
    Attachment localAttachment;
    while (b(paramInt) != 3) {
      switch (l)
      {
      default: 
        i();
        break;
      case 133: 
      case 1103: 
        k = l;
        localObject = null;
        str3 = null;
        str1 = null;
        j = 0;
        str2 = null;
        while (b(k) != 3) {
          switch (l)
          {
          default: 
            i();
            break;
          case 144: 
          case 1104: 
            localObject = g();
            break;
          case 135: 
          case 1105: 
            str1 = g();
            break;
          case 136: 
          case 1100: 
            str3 = g();
            break;
          case 1109: 
            if (h() == 1) {
              j = 1;
            } else {
              j = 0;
            }
            break;
          case 1107: 
            str2 = g();
          }
        }
        if ((localObject != null) && (str3 != null) && (str1 != null))
        {
          localAttachment = new Attachment();
          q = "base64";
          k = Long.parseLong(str3);
          i = ((String)localObject);
          p = str1;
          k = ((String)localObject).lastIndexOf('.');
          if ((k <= 0) || (k >= ((String)localObject).length() - 1)) {
            break label514;
          }
        }
        break;
      }
    }
    label514:
    for (String str3 = ((String)localObject).substring(k + 1).toLowerCase();; str3 = null)
    {
      if (str3 == null) {
        localObject = "application/octet-stream";
      }
      for (;;)
      {
        j = ((String)localObject);
        if (bnq.d(b.l)) {
          y = str1;
        }
        u = b.D;
        if ((j != 0) && (!TextUtils.isEmpty(str2))) {
          l = str2;
        }
        if ((x != null) && ((x.n) || ((x.p > 0) && (k > x.p)))) {
          s = 512;
        }
        paramArrayList.add(localAttachment);
        t = true;
        break;
        String str4 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str3);
        localObject = str4;
        if (str4 == null)
        {
          localObject = String.valueOf(str3);
          if (((String)localObject).length() != 0) {
            localObject = "application/".concat((String)localObject);
          } else {
            localObject = new String("application/");
          }
        }
      }
      return;
    }
  }
  
  private final Long b(String paramString)
  {
    Long localLong = null;
    try
    {
      paramString = a(paramString, bdv.B);
      localObject1 = localLong;
      if (paramString == null) {
        break label129;
      }
      localObject1 = localLong;
      try
      {
        if (!paramString.moveToFirst()) {
          break label129;
        }
        localLong = Long.valueOf(paramString.getLong(0));
        for (;;)
        {
          localObject1 = localLong;
          if (!paramString.moveToNext()) {
            break;
          }
          localObject1 = Long.valueOf(paramString.getLong(0));
          String str = String.valueOf(localObject1);
          new StringBuilder(String.valueOf(str).length() + 26).append("Delete duplicate with id: ").append(str).toString();
          f.add(localObject1);
        }
        if (localObject1 == null) {
          break label127;
        }
      }
      finally
      {
        localObject1 = paramString;
        paramString = (String)localObject2;
      }
    }
    finally
    {
      for (;;)
      {
        Object localObject1 = null;
      }
    }
    ((Cursor)localObject1).close();
    label127:
    throw paramString;
    label129:
    if (paramString != null) {
      paramString.close();
    }
    return (Long)localObject1;
  }
  
  private final void b(beb parambeb)
  {
    String str1 = "1";
    String str2 = "";
    while (b(1098) != 3) {
      switch (l)
      {
      default: 
        i();
        break;
      case 1094: 
        str1 = g();
        break;
      case 1099: 
        str2 = g();
      }
    }
    if (str1.equals("2"))
    {
      ay = str2;
      return;
    }
    ax = str2;
  }
  
  private final void b()
  {
    Iterator localIterator = localIterator.iterator();
    while (localIterator.hasNext())
    {
      ArrayList localArrayList;
      ((beb)localIterator.next()).a(localArrayList);
      int j;
      a(localArrayList, j, false);
    }
  }
  
  private final void b()
  {
    ;
    Iterator localIterator = ((Map)localObject1).keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject2;
      long l = ((Long)((Map)localObject2).get(str)).longValue();
      str = (String)((Map)localObject1).get(str);
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("fileReference", str);
      ArrayList localArrayList;
      localArrayList.add(ContentProviderOperation.newUpdate(ContentUris.withAppendedId(Attachment.a, l)).withValues(localContentValues).build());
      int j;
      a(localArrayList, j, false);
    }
  }
  
  private final void c()
  {
    Iterator localIterator = localIterator.iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      ArrayList localArrayList;
      localArrayList.add(ContentProviderOperation.newDelete(ContentUris.withAppendedId(beb.a, localLong.longValue())).build());
      bgt.b(c, b.D, localLong.longValue());
      int j;
      a(localArrayList, j, false);
    }
  }
  
  private final beb d(int paramInt)
  {
    beb localbeb = new beb();
    V = b.D;
    U = a.D;
    r = 1;
    int j = 1;
    while (b(paramInt) != 3) {
      switch (l)
      {
      default: 
        i();
        break;
      case 13: 
        x = g();
        break;
      case 14: 
        j = h();
        break;
      case 29: 
        a(localbeb, l);
      }
    }
    if (j != 1) {
      throw new bno(j, x);
    }
    return localbeb;
  }
  
  private final boolean e(int paramInt)
  {
    try
    {
      Object localObject2 = p;
      Object localObject3 = o;
      ArrayList localArrayList1 = f;
      ArrayList localArrayList2 = q;
      ArrayList localArrayList3 = r;
      Map localMap1 = t;
      Map localMap2 = u;
      Set localSet = g;
      Map localMap3 = h;
      Map localMap4 = s;
      Map localMap5 = v;
      Object localObject1 = new ArrayList();
      cvm.b("Exchange", "commitImpl: maxOpsPerBatch=%d numFetched=%d numNew=%d numDeleted=%d numChanged=%d numDraftsChanged=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(((ArrayList)localObject2).size()), Integer.valueOf(((ArrayList)localObject3).size()), Integer.valueOf(localArrayList1.size()), Integer.valueOf(localArrayList2.size()), Integer.valueOf(localArrayList3.size()) });
      a((ArrayList)localObject1, paramInt, (ArrayList)localObject2);
      b((ArrayList)localObject1, paramInt, (ArrayList)localObject3);
      a((ArrayList)localObject1, paramInt, localArrayList3, localArrayList2);
      c((ArrayList)localObject1, paramInt, localArrayList1);
      a((ArrayList)localObject1, paramInt, localMap1, localMap2);
      a((ArrayList)localObject1, paramInt, localSet, localMap3);
      b((ArrayList)localObject1, paramInt, localMap4, localMap5);
      localObject2 = a;
      localObject3 = new ContentValues();
      ((ContentValues)localObject3).put("syncKey", j);
      ((ArrayList)localObject1).add(ContentProviderOperation.newUpdate(ContentUris.withAppendedId(Mailbox.a, D)).withValues((ContentValues)localObject3).build());
      a((ArrayList)localObject1, paramInt, true);
      localObject1 = c;
      localObject1 = j;
      return true;
    }
    catch (TransactionTooLargeException localTransactionTooLargeException)
    {
      cvm.b("Exchange", "Transaction too large exception with batch size %d", new Object[] { Integer.valueOf(paramInt) });
    }
    return false;
  }
  
  private final Boolean k()
  {
    Boolean localBoolean = Boolean.valueOf(false);
    while (b(186) != 3) {
      switch (l)
      {
      default: 
        i();
        break;
      case 187: 
        if (h() == 2) {}
        for (boolean bool = true;; bool = false)
        {
          localBoolean = Boolean.valueOf(bool);
          break;
        }
      }
    }
    return localBoolean;
  }
  
  /* Error */
  public final void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: bipush 22
    //   3: invokevirtual 210	bom:b	(I)I
    //   6: iconst_3
    //   7: if_icmpeq +288 -> 295
    //   10: aload_0
    //   11: getfield 214	bom:l	I
    //   14: bipush 7
    //   16: if_icmpne +22 -> 38
    //   19: aload_0
    //   20: getfield 56	bom:o	Ljava/util/ArrayList;
    //   23: aload_0
    //   24: aload_0
    //   25: getfield 214	bom:l	I
    //   28: invokespecial 695	bom:d	(I)Lbeb;
    //   31: invokevirtual 351	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   34: pop
    //   35: goto -35 -> 0
    //   38: aload_0
    //   39: getfield 214	bom:l	I
    //   42: bipush 9
    //   44: if_icmpeq +12 -> 56
    //   47: aload_0
    //   48: getfield 214	bom:l	I
    //   51: bipush 33
    //   53: if_icmpne +172 -> 225
    //   56: aload_0
    //   57: getfield 60	bom:f	Ljava/util/ArrayList;
    //   60: astore_3
    //   61: aload_0
    //   62: getfield 214	bom:l	I
    //   65: istore_1
    //   66: aload_0
    //   67: iload_1
    //   68: invokevirtual 210	bom:b	(I)I
    //   71: iconst_3
    //   72: if_icmpeq -72 -> 0
    //   75: aload_0
    //   76: getfield 214	bom:l	I
    //   79: tableswitch	default:+17->96, 13:+24->103
    //   96: aload_0
    //   97: invokevirtual 216	bom:i	()V
    //   100: goto -34 -> 66
    //   103: aload_0
    //   104: invokevirtual 221	bom:g	()Ljava/lang/String;
    //   107: astore 4
    //   109: aload_0
    //   110: aload 4
    //   112: getstatic 45	bom:w	[Ljava/lang/String;
    //   115: invokespecial 299	bom:a	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   118: astore_2
    //   119: aload_2
    //   120: invokeinterface 303 1 0
    //   125: ifeq +82 -> 207
    //   128: aload_3
    //   129: aload_2
    //   130: iconst_0
    //   131: invokeinterface 310 2 0
    //   136: invokestatic 519	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   139: invokevirtual 351	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   142: pop
    //   143: getstatic 697	bnq:b	Z
    //   146: ifeq +61 -> 207
    //   149: aload_2
    //   150: iconst_1
    //   151: invokeinterface 700 2 0
    //   156: invokestatic 174	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   159: astore 5
    //   161: new 617	java/lang/StringBuilder
    //   164: dup
    //   165: aload 4
    //   167: invokestatic 174	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   170: invokevirtual 177	java/lang/String:length	()I
    //   173: iconst_2
    //   174: iadd
    //   175: aload 5
    //   177: invokestatic 174	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   180: invokevirtual 177	java/lang/String:length	()I
    //   183: iadd
    //   184: invokespecial 619	java/lang/StringBuilder:<init>	(I)V
    //   187: aload 4
    //   189: invokevirtual 625	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: ldc_w 702
    //   195: invokevirtual 625	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload 5
    //   200: invokevirtual 625	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 626	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: pop
    //   207: aload_2
    //   208: invokeinterface 313 1 0
    //   213: goto -147 -> 66
    //   216: astore_3
    //   217: aload_2
    //   218: invokeinterface 313 1 0
    //   223: aload_3
    //   224: athrow
    //   225: aload_0
    //   226: getfield 214	bom:l	I
    //   229: bipush 8
    //   231: if_icmpne +57 -> 288
    //   234: aload_0
    //   235: getfield 108	bom:b	Lcom/android/emailcommon/provider/Account;
    //   238: getfield 258	com/android/emailcommon/provider/Account:l	Ljava/lang/String;
    //   241: invokestatic 583	bnq:d	(Ljava/lang/String;)Z
    //   244: ifeq +33 -> 277
    //   247: aload_0
    //   248: getfield 90	bom:a	Lcom/android/emailcommon/provider/Mailbox;
    //   251: getfield 704	com/android/emailcommon/provider/Mailbox:h	I
    //   254: iconst_3
    //   255: if_icmpne +22 -> 277
    //   258: aload_0
    //   259: getfield 64	bom:r	Ljava/util/ArrayList;
    //   262: aload_0
    //   263: aload_0
    //   264: getfield 214	bom:l	I
    //   267: invokespecial 695	bom:d	(I)Lbeb;
    //   270: invokevirtual 351	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   273: pop
    //   274: goto -274 -> 0
    //   277: aload_0
    //   278: aload_0
    //   279: getfield 62	bom:q	Ljava/util/ArrayList;
    //   282: invokespecial 705	bom:a	(Ljava/util/ArrayList;)V
    //   285: goto -285 -> 0
    //   288: aload_0
    //   289: invokevirtual 216	bom:i	()V
    //   292: goto -292 -> 0
    //   295: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	this	bom
    //   65	3	1	j	int
    //   118	100	2	localCursor	Cursor
    //   60	69	3	localArrayList	ArrayList
    //   216	8	3	localObject	Object
    //   107	81	4	str1	String
    //   159	40	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   119	207	216	finally
  }
  
  public final void a(beb parambeb, int paramInt)
  {
    Object localObject1 = new ArrayList();
    int j = 0;
    Object localObject2;
    Object localObject3;
    while (b(paramInt) != 3) {
      switch (l)
      {
      default: 
        i();
        break;
      case 134: 
      case 1102: 
        a((ArrayList)localObject1, parambeb, l);
        break;
      case 150: 
        Y = Address.a(Address.d(g()));
        break;
      case 152: 
        a(parambeb, g());
        break;
      case 151: 
        Z = Address.a(Address.d(g()));
        break;
      case 1430: 
        aa = Address.a(Address.d(g()));
        break;
      case 153: 
        ab = Address.a(Address.d(g()));
        break;
      case 143: 
        try
        {
          n = bhn.b(g());
        }
        catch (ParseException localParseException1)
        {
          cvm.d("Exchange", "Parse error for EMAIL_DATE_RECEIVED tag.", new Object[] { localParseException1 });
        }
        break;
      case 148: 
        o = g();
        break;
      case 149: 
        if (h() == 1) {}
        for (boolean bool = true;; bool = false)
        {
          p = bool;
          aD = true;
          break;
        }
      case 1098: 
        b(parambeb);
        break;
      case 186: 
        s = k().booleanValue();
        aE = true;
        break;
      case 183: 
        if (h() == 1) {
          j = 1;
        } else {
          j = 0;
        }
        break;
      case 182: 
        if (j != 0)
        {
          g();
          localObject2 = x;
          r = 2;
          y = true;
        }
        else
        {
          localObject2 = g();
          try
          {
            localObject2 = new bcl(new ByteArrayInputStream(((String)localObject2).getBytes()));
            localObject3 = new ArrayList();
            bco.a((bdn)localObject2, (ArrayList)localObject3, new ArrayList());
            localObject2 = bgu.a((ArrayList)localObject3);
            parambeb.a(d, e);
            af = c;
            ay = b;
            ax = a;
          }
          catch (bdi parambeb)
          {
            throw new IOException(parambeb);
          }
        }
        break;
      case 140: 
        ax = g();
        break;
      case 147: 
        localObject2 = g();
        if (((String)localObject2).equals("IPM.Schedule.Meeting.Request")) {
          u |= 0x4;
        } else if (((String)localObject2).equals("IPM.Schedule.Meeting.Canceled")) {
          u |= 0x8;
        } else if (((String)localObject2).equals("IPM.Schedule.Meeting.Resp.Pos")) {
          v |= 0x1;
        } else if (((String)localObject2).equals("IPM.Schedule.Meeting.Resp.Tent")) {
          v |= 0x2;
        } else if (((String)localObject2).equals("IPM.Schedule.Meeting.Resp.Neg")) {
          v |= 0x4;
        }
        break;
      case 162: 
        a(parambeb);
        break;
      case 181: 
        ah = g();
        break;
      case 1544: 
        a(l);
        break;
      case 1417: 
        aw = Base64.encodeToString(f(), 8);
        break;
      case 1418: 
        f();
        break;
      case 1419: 
        int k = h();
        if ((k == 1) || (k == 2)) {
          u |= 0x40000;
        } else if (k == 3) {
          u |= 0x80000;
        }
        break;
      case 146: 
        w = h();
        break;
      case 1429: 
        aC = true;
        if (h() == 1) {
          u |= 0x100000;
        }
        break;
      }
    }
    if ((a.h == 3) && (X == null)) {
      a(parambeb, b.d);
    }
    if (((ArrayList)localObject1).size() > 0) {
      aA = ((ArrayList)localObject1);
    }
    if ((u & 0xC) != 0)
    {
      if (ax == null) {
        break label1078;
      }
      localObject1 = ax;
    }
    for (;;)
    {
      if (TextUtils.isEmpty(bhl.a((String)localObject1)))
      {
        localObject1 = ac;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = new bdl((String)localObject1);
          localObject2 = new ContentValues();
          a((bdl)localObject1, "LOC", (ContentValues)localObject2, "eventLocation");
          localObject3 = ((bdl)localObject1).a("DTSTART");
          if (TextUtils.isEmpty((CharSequence)localObject3)) {}
        }
      }
      try
      {
        ((ContentValues)localObject2).put("dtstart", Long.valueOf(bhn.b((String)localObject3)));
        a((bdl)localObject1, "ALLDAY", (ContentValues)localObject2, "allDay");
        ax = bsx.a(c, (ContentValues)localObject2, null);
        ay = Html.toHtml(new SpannedString(ax));
        return;
        label1078:
        localObject1 = ay;
      }
      catch (ParseException localParseException2)
      {
        for (;;)
        {
          cvm.d("Exchange", "Parse error for MEETING_DTSTART tag.", new Object[] { localParseException2 });
        }
      }
    }
  }
  
  public final void b()
  {
    while (b(6) != 3) {
      if ((l == 7) || (l == 8) || (l == 9))
      {
        int k;
        String str1;
        int j;
        if ((3 == a.h) && (bnq.d(b.l)))
        {
          k = l;
          Map localMap1 = t;
          Set localSet = g;
          Map localMap2 = s;
          String str2 = null;
          str1 = null;
          j = 1;
          break label180;
          while (b(k) != 3) {
            switch (l)
            {
            default: 
              i();
              break;
            case 12: 
              str1 = g();
              break;
            case 13: 
              str2 = g();
              break;
            case 14: 
              j = h();
            }
          }
          label180:
          while (b(29) != 3) {
            switch (l)
            {
            default: 
              i();
            }
          }
          for (;;)
          {
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
              localMap2.put(localObject1, localObject2);
            }
            while (b(1102) != 3) {
              switch (l)
              {
              default: 
                i();
              }
            }
            Object localObject2 = null;
            Object localObject1 = null;
            while (b(1103) != 3) {
              switch (l)
              {
              default: 
                i();
                break;
              case 1118: 
                localObject1 = g();
                break;
              case 1105: 
                localObject2 = g();
              }
            }
          }
          if ((str1 != null) && (str2 != null))
          {
            k = 1;
            switch (j)
            {
            default: 
              label372:
              if (k != 0)
              {
                cvm.e("Exchange", "Draft add error: status %d; clientId: %s;", new Object[] { Integer.valueOf(j), str1 });
                j = 0;
              }
              break;
            }
          }
          while (j != 0)
          {
            if (k == 0) {
              break label518;
            }
            localMap1.put(str1, str2);
            break;
            k = 0;
            break label372;
            j = 1;
            continue;
            cvm.c("Exchange", "Conflicts with server changes. Local changes will be overwritten. serverId: %s", new Object[] { str2 });
            j = 1;
            continue;
            cvm.e("Exchange", "Draft change error: status %d; serverId: %s;", new Object[] { Integer.valueOf(j), str2 });
            j = 0;
          }
          label518:
          if (str2 != null) {
            localSet.add(str2);
          }
        }
        else
        {
          k = l;
          j = -1;
          str1 = null;
          while (b(k) != 3) {
            if (l == 14) {
              j = h();
            } else if (l == 13) {
              str1 = g();
            } else {
              i();
            }
          }
          if ((str1 != null) && (j != -1)) {
            i.put(str1, Integer.valueOf(j));
          }
        }
      }
      else if (l == 10)
      {
        try
        {
          p.add(d(l));
        }
        catch (bno localbno) {}
        if (a == 8) {
          d.delete(beb.a, "syncServerId=? AND mailboxKey=?", new String[] { b, n });
        }
      }
    }
  }
  
  public final void c()
  {
    if ((a.h == 3) && (e == 1))
    {
      if (!h.isEmpty()) {
        g.addAll(h.keySet());
      }
      Iterator localIterator = u.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!t.containsKey(str)) {
          t.put(str, null);
        }
      }
    }
    int j = 64;
    while (!e(j))
    {
      if (j == 1)
      {
        cvm.f("Exchange", "Transaction too large with batch size one", new Object[0]);
        throw new IllegalStateException("Transaction too large with batch size one");
      }
      j = Math.max(j / 4, 1);
      cvm.d("Exchange", "Transaction too large, retrying batch size %d", new Object[] { Integer.valueOf(j) });
    }
  }
  
  public final boolean d()
  {
    return (super.d()) || (y);
  }
  
  protected final void e()
  {
    cvm.c("Exchange", "Wiping mailbox %s", new Object[] { a });
    buo.a().a("exchange_sync", "wipe", "mailbox", 0L);
    Mailbox.a(d, new android.accounts.Account(b.d, bnq.c), a.D);
  }
}

/* Location:
 * Qualified Name:     bom
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */