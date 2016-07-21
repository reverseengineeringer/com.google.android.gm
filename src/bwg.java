import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.text.TextUtils;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.providers.FolderList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class bwg
  implements Cursor, bwv, cuf
{
  static int a = 0;
  static bwm b;
  private final boolean A;
  public bwr c;
  volatile bwr d;
  public final HashMap<String, ContentValues> e = new HashMap();
  final Object f = new Object();
  public final List<bwk> g = new ArrayList();
  public boolean h = false;
  public boolean i = false;
  final List<Conversation> j = new ArrayList();
  final Set<Conversation> k = new HashSet();
  public final String l;
  public boolean m = false;
  boolean n = false;
  int o = -1;
  final Uri p;
  private final ContentResolver q;
  private bwq r;
  private boolean s = false;
  private String[] t;
  private Set<String> u;
  private final bwp v;
  private boolean w = false;
  private int x = 0;
  private final String[] y;
  private final Handler z = new Handler(Looper.getMainLooper());
  
  public bwg(Context paramContext, Uri paramUri, boolean paramBoolean, String paramString)
  {
    s = paramBoolean;
    q = paramContext.getApplicationContext().getContentResolver();
    p = paramUri;
    l = paramString;
    y = chh.k;
    v = new bwp(this, new Handler(Looper.getMainLooper()));
    paramBoolean = bool;
    if (!cud.a(paramContext)) {
      paramBoolean = true;
    }
    A = paramBoolean;
  }
  
  static Uri a(Uri paramUri)
  {
    if (!paramUri.getAuthority().equals(bwm.a)) {
      return paramUri;
    }
    Object localObject = paramUri.getPathSegments();
    Uri.Builder localBuilder = new Uri.Builder().scheme(paramUri.getScheme()).authority((String)((List)localObject).get(0));
    int i1 = 1;
    while (i1 < ((List)localObject).size())
    {
      localBuilder.appendPath((String)((List)localObject).get(i1));
      i1 += 1;
    }
    localObject = paramUri.getQueryParameterNames().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localBuilder.appendQueryParameter(str, paramUri.getQueryParameter(str));
    }
    return localBuilder.build();
  }
  
  private final Object a(String paramString, int paramInt)
  {
    ContentValues localContentValues = (ContentValues)e.get(paramString);
    if (localContentValues != null)
    {
      if (paramInt == -1) {}
      for (paramString = "__deleted__";; paramString = t[paramInt]) {
        return localContentValues.get(paramString);
      }
    }
    return null;
  }
  
  private static String a(String paramString, StringBuilder paramStringBuilder)
  {
    paramString = paramString.substring(paramString.indexOf("://") + 3);
    if (paramStringBuilder != null)
    {
      paramStringBuilder.setLength(0);
      paramStringBuilder.append(bwm.b);
      paramStringBuilder.append(paramString);
      return paramStringBuilder.toString();
    }
    paramStringBuilder = String.valueOf(bwm.b);
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      return paramStringBuilder.concat(paramString);
    }
    return new String(paramStringBuilder);
  }
  
  private static void a(ContentValues paramContentValues, String paramString, Object paramObject)
  {
    if ((paramObject instanceof Boolean))
    {
      if (((Boolean)paramObject).booleanValue()) {}
      for (int i1 = 1;; i1 = 0)
      {
        paramContentValues.put(paramString, Integer.valueOf(i1));
        return;
      }
    }
    if ((paramObject instanceof Integer))
    {
      paramContentValues.put(paramString, (Integer)paramObject);
      return;
    }
    if ((paramObject instanceof String))
    {
      paramContentValues.put(paramString, (String)paramObject);
      return;
    }
    if ((paramObject instanceof byte[]))
    {
      paramContentValues.put(paramString, (byte[])paramObject);
      return;
    }
    paramContentValues = String.valueOf(paramObject.getClass().getName());
    if (paramContentValues.length() != 0) {}
    for (paramContentValues = "Value class not compatible with cache: ".concat(paramContentValues);; paramContentValues = new String("Value class not compatible with cache: ")) {
      throw new IllegalArgumentException(paramContentValues);
    }
  }
  
  private final void a(bwr parambwr)
  {
    int i3 = 1;
    for (;;)
    {
      Long localLong;
      int i2;
      synchronized (f)
      {
        Iterator localIterator = e.entrySet().iterator();
        long l1 = System.currentTimeMillis();
        if (!localIterator.hasNext()) {
          break label282;
        }
        localObject1 = (Map.Entry)localIterator.next();
        ContentValues localContentValues = (ContentValues)((Map.Entry)localObject1).getValue();
        localObject1 = (String)((Map.Entry)localObject1).getKey();
        if (localContentValues == null) {
          break label256;
        }
        localLong = localContentValues.getAsLong("__updatetime__");
        if ((localLong != null) && (l1 - localLong.longValue() < 10000L))
        {
          cvm.b("ConversationCursor", "IN resetCursor, keep recent changes to %s", new Object[] { localObject1 });
          i1 = 1;
          if ((!localContentValues.containsKey("__deleted__")) || (e.containsKey(localObject1))) {
            break label397;
          }
          x -= 1;
          i2 = x;
          if (!cvm.a("ConversationCursor", 3)) {
            break label415;
          }
          cvm.c("ConversationCursor", "IN resetCursor, sDeletedCount decremented to: %d by %s", new Object[] { Integer.valueOf(i2), localObject1 });
          i2 = 1;
          break label399;
          localIterator.remove();
        }
      }
      if (localLong == null)
      {
        cvm.e("ConversationCursor", "null updateTime from mCacheMap for key: %s", new Object[] { localObject1 });
        break label410;
        label256:
        cvm.e("ConversationCursor", "null ContentValues from mCacheMap for key: %s", new Object[] { localObject1 });
        i2 = 0;
        i1 = 0;
        break label399;
        label282:
        if (c != null)
        {
          i1 = i3;
          if (c.h) {}
        }
        else
        {
          if (!h) {
            break label392;
          }
        }
        label392:
        for (i1 = i3;; i1 = 0)
        {
          if (c != null) {
            close();
          }
          c = parambwr;
          o = -1;
          c.moveToPosition(o);
          if (!w)
          {
            c.registerContentObserver(v);
            w = true;
          }
          i = false;
          c.c();
          if (i1 != 0) {
            g();
          }
          return;
        }
        label397:
        i2 = 0;
        label399:
        if (i1 == 0) {
          continue;
        }
        if (i2 == 0) {
          continue;
        }
        continue;
      }
      label410:
      int i1 = 0;
      continue;
      label415:
      Object localObject1 = "[redacted]";
    }
  }
  
  public static void a(Collection<Folder> paramCollection, ContentValues paramContentValues)
  {
    Object localObject = FolderList.a(paramCollection);
    paramCollection = Parcel.obtain();
    ((FolderList)localObject).writeToParcel(paramCollection, 0);
    localObject = paramCollection.marshall();
    paramCollection.recycle();
    paramContentValues.put("rawFolders", (byte[])localObject);
  }
  
  public static void a(List<Uri> paramList, List<Boolean> paramList1, ContentValues paramContentValues)
  {
    int i2 = paramList.size();
    ArrayList localArrayList = new ArrayList(i2);
    int i1 = 0;
    while (i1 < i2)
    {
      localArrayList.add(((Uri)paramList.get(i1)).buildUpon().appendPath(String.valueOf(paramList1.get(i1))).toString());
      i1 += 1;
    }
    paramContentValues.put("folders_updated", TextUtils.join(",", localArrayList));
  }
  
  public static boolean a(bwg parambwg)
  {
    boolean bool2 = true;
    boolean bool1;
    if (parambwg == null)
    {
      bool1 = false;
      return bool1;
    }
    Bundle localBundle = parambwg.getExtras();
    if (localBundle == null) {}
    for (int i1 = 1;; i1 = localBundle.getInt("cursor_status"))
    {
      bool1 = bool2;
      if (parambwg.getCount() > 0) {
        break;
      }
      bool1 = bool2;
      if (4 == i1) {
        break;
      }
      bool1 = bool2;
      if (8 == i1) {
        break;
      }
      return false;
    }
  }
  
  private boolean a(String paramString)
  {
    cvm.b("ConversationCursor", "[Clearing mostly dead %s] ", new Object[] { paramString });
    j.clear();
    n = false;
    Object localObject = a(paramString, 16);
    if (localObject != null)
    {
      int i1 = ((Integer)localObject).intValue();
      if ((i1 & 0x1) != 0)
      {
        a(paramString, "conversationFlags", Integer.valueOf(i1 & 0xFFFFFFFE));
        return true;
      }
    }
    return false;
  }
  
  private final Object b(int paramInt)
  {
    return a(c.b(), paramInt);
  }
  
  static String b(Uri paramUri)
  {
    return Uri.decode(a(paramUri).toString());
  }
  
  static boolean e()
  {
    return Looper.getMainLooper().getThread() != Thread.currentThread();
  }
  
  private final void q()
  {
    bwm localbwm = b;
    if (d != 0)
    {
      Iterator localIterator = e.iterator();
      while (localIterator.hasNext())
      {
        Uri localUri = (Uri)localIterator.next();
        if (!a(b(localUri))) {
          bwm.a(localUri, this);
        }
      }
      d = 0;
      int i1 = o;
      moveToFirst();
      moveToPosition(i1);
      j();
      if (f != null) {
        f.a();
      }
    }
  }
  
  public final int a(long paramLong)
  {
    int i3 = c.a(paramLong);
    if (i3 < 0) {
      return i3;
    }
    label155:
    label161:
    label177:
    for (;;)
    {
      int i1;
      int i2;
      synchronized (f)
      {
        Iterator localIterator = e.entrySet().iterator();
        i1 = i3;
        if (localIterator.hasNext())
        {
          Object localObject3 = (Map.Entry)localIterator.next();
          if (((ContentValues)((Map.Entry)localObject3).getValue()).containsKey("__deleted__"))
          {
            localObject3 = (String)((Map.Entry)localObject3).getKey();
            localObject3 = (Integer)c.e.get(localObject3);
            if (localObject3 == null) {
              break label155;
            }
            i2 = ((Integer)localObject3).intValue();
            if (i2 != i3) {
              break label161;
            }
            return -1;
          }
        }
        else
        {
          return i1;
        }
      }
      for (;;)
      {
        break label177;
        i2 = -1;
        break;
        if ((i2 >= 0) && (i2 < i3)) {
          i1 -= 1;
        }
      }
    }
  }
  
  public final int a(Collection<Conversation> paramCollection)
  {
    return a(paramCollection, 3, null);
  }
  
  public final int a(Collection<Conversation> paramCollection, int paramInt, cag paramcag)
  {
    ArrayList localArrayList = new ArrayList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localArrayList.add(new bwl(this, paramInt, (Conversation)paramCollection.next(), paramcag));
    }
    return apply(localArrayList);
  }
  
  public final int a(Collection<Conversation> paramCollection, String paramString, int paramInt)
  {
    if (cvm.a("ConversationCursor", 3)) {
      cvm.b("ConversationCursor", "ConversationCursor.updateInt(conversations=%s, columnName=%s)", new Object[] { paramCollection.toArray(), paramString });
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put(paramString, Integer.valueOf(paramInt));
    return apply(a(paramCollection, 2, localContentValues, null));
  }
  
  public final int a(Collection<Conversation> paramCollection, String paramString, boolean paramBoolean)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put(paramString, Boolean.valueOf(paramBoolean));
    return apply(a(paramCollection, 2, localContentValues, null));
  }
  
  public final bwl a(Conversation paramConversation, int paramInt, ContentValues paramContentValues, cag paramcag)
  {
    return new bwl(this, paramInt, paramConversation, paramContentValues, paramcag);
  }
  
  final bwr a(boolean paramBoolean)
  {
    Object localObject2 = p;
    Object localObject1 = localObject2;
    if (paramBoolean) {
      localObject1 = ((Uri)localObject2).buildUpon().appendQueryParameter("limit", "50").build();
    }
    System.currentTimeMillis();
    cxa.g("query");
    localObject2 = q.query((Uri)localObject1, y, null, null, null);
    cxa.a();
    if (localObject2 == null)
    {
      localObject1 = String.valueOf(localObject1);
      cvm.d("ConversationCursor", String.valueOf(localObject1).length() + 36 + "doQuery returning null cursor, uri: " + (String)localObject1, new Object[0]);
    }
    System.gc();
    return new bwr((Cursor)localObject2, A);
  }
  
  public final ArrayList<bwl> a(Collection<Conversation> paramCollection, int paramInt, ContentValues paramContentValues, cag paramcag)
  {
    paramcag = new ArrayList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      paramcag.add(a((Conversation)paramCollection.next(), paramInt, paramContentValues, null));
    }
    return paramcag;
  }
  
  public final void a()
  {
    bww.a(c);
  }
  
  public final void a(Context paramContext, Uri paramUri)
  {
    new Thread(new bwh(this, paramContext, paramUri)).start();
    q();
  }
  
  public final void a(Uri arg1, String paramString, Object paramObject)
  {
    String str = b(???);
    synchronized (f)
    {
      a(str, paramString, paramObject);
      j();
      return;
    }
  }
  
  public final void a(bwk parambwk)
  {
    synchronized (g)
    {
      g.remove(parambwk);
      return;
    }
  }
  
  final void a(Conversation paramConversation)
  {
    o &= 0xFFFFFFFE;
    j.remove(paramConversation);
    cvm.b("ConversationCursor", "[All dead: %s]", new Object[] { c });
    if (j.isEmpty())
    {
      n = false;
      d();
    }
  }
  
  public final void a(cue paramcue, int paramInt)
  {
    if (c != null) {
      c.a(paramcue, paramInt);
    }
  }
  
  final void a(String paramString1, String paramString2, Object paramObject)
  {
    if (e()) {
      cvm.e("ConversationCursor", new Error(), "cacheValue incorrectly being called from non-UI thread", new Object[0]);
    }
    for (;;)
    {
      boolean bool;
      int i1;
      synchronized (f)
      {
        ContentValues localContentValues = (ContentValues)e.get(paramString1);
        if (localContentValues != null) {
          break label212;
        }
        localContentValues = new ContentValues();
        e.put(paramString1, localContentValues);
        if (paramString2.equals("__deleted__"))
        {
          cvm.e("ConversationCursor", "DELETED COLUMN %s", new Object[] { paramString1 });
          bool = ((Boolean)paramObject).booleanValue();
          if (localContentValues.get(paramString2) == null) {
            break label215;
          }
          i1 = 1;
          if ((bool) && (i1 == 0)) {
            x += 1;
          }
        }
        else
        {
          a(localContentValues, paramString2, paramObject);
          localContentValues.put("__updatetime__", Long.valueOf(System.currentTimeMillis()));
          return;
        }
        if ((!bool) && (i1 != 0))
        {
          x -= 1;
          localContentValues.remove(paramString2);
          return;
        }
      }
      if (!bool)
      {
        return;
        label212:
        continue;
        label215:
        i1 = 0;
      }
    }
  }
  
  public final byte[] a(int paramInt)
  {
    return (byte[])b(paramInt);
  }
  
  public final int apply(Collection<bwl> paramCollection)
  {
    return b.apply(paramCollection, this);
  }
  
  public final int b(Collection<Conversation> paramCollection)
  {
    return a(paramCollection, 7, null);
  }
  
  public final int b(Collection<Conversation> paramCollection, ContentValues paramContentValues)
  {
    return apply(a(paramCollection, 130, paramContentValues, null));
  }
  
  public final void b()
  {
    bww.b(c);
  }
  
  public final int c(Collection<Conversation> paramCollection)
  {
    return a(paramCollection, 8, null);
  }
  
  /* Error */
  public final void c()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: getfield 73	bwg:f	Ljava/lang/Object;
    //   6: astore_3
    //   7: aload_3
    //   8: monitorenter
    //   9: ldc_w 351
    //   12: ldc_w 685
    //   15: iconst_0
    //   16: anewarray 4	java/lang/Object
    //   19: invokestatic 358	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   22: pop
    //   23: aload_0
    //   24: aload_0
    //   25: getfield 84	bwg:s	Z
    //   28: invokevirtual 687	bwg:a	(Z)Lbwr;
    //   31: astore 4
    //   33: aload_0
    //   34: getfield 389	bwg:c	Lbwr;
    //   37: ifnull +7 -> 44
    //   40: aload_0
    //   41: invokevirtual 393	bwg:close	()V
    //   44: aload_0
    //   45: aload 4
    //   47: invokevirtual 691	bwr:getColumnNames	()[Ljava/lang/String;
    //   50: putfield 242	bwg:t	[Ljava/lang/String;
    //   53: new 693	hfe
    //   56: dup
    //   57: invokespecial 694	hfe:<init>	()V
    //   60: astore 5
    //   62: aload_0
    //   63: getfield 242	bwg:t	[Ljava/lang/String;
    //   66: astore 6
    //   68: aload 6
    //   70: arraylength
    //   71: istore_2
    //   72: iload_1
    //   73: iload_2
    //   74: if_icmpge +20 -> 94
    //   77: aload 5
    //   79: aload 6
    //   81: iload_1
    //   82: aaload
    //   83: invokevirtual 697	hfe:c	(Ljava/lang/Object;)Lhfe;
    //   86: pop
    //   87: iload_1
    //   88: iconst_1
    //   89: iadd
    //   90: istore_1
    //   91: goto -19 -> 72
    //   94: aload_0
    //   95: aload 5
    //   97: invokevirtual 700	hfe:a	()Lhfd;
    //   100: putfield 702	bwg:u	Ljava/util/Set;
    //   103: aload_0
    //   104: iconst_0
    //   105: putfield 82	bwg:i	Z
    //   108: aload_0
    //   109: iconst_0
    //   110: putfield 80	bwg:h	Z
    //   113: aload_0
    //   114: aconst_null
    //   115: putfield 704	bwg:r	Lbwq;
    //   118: aload_0
    //   119: aload 4
    //   121: invokespecial 706	bwg:a	(Lbwr;)V
    //   124: aload_0
    //   125: getfield 114	bwg:z	Landroid/os/Handler;
    //   128: new 708	bwi
    //   131: dup
    //   132: aload_0
    //   133: invokespecial 711	bwi:<init>	(Lbwg;)V
    //   136: invokevirtual 715	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   139: pop
    //   140: aload_0
    //   141: invokevirtual 717	bwg:p	()V
    //   144: aload_0
    //   145: getfield 84	bwg:s	Z
    //   148: ifeq +12 -> 160
    //   151: aload_0
    //   152: iconst_0
    //   153: putfield 84	bwg:s	Z
    //   156: aload_0
    //   157: invokevirtual 405	bwg:g	()V
    //   160: aload_3
    //   161: monitorexit
    //   162: return
    //   163: astore 4
    //   165: aload_0
    //   166: getfield 84	bwg:s	Z
    //   169: ifeq +12 -> 181
    //   172: aload_0
    //   173: iconst_0
    //   174: putfield 84	bwg:s	Z
    //   177: aload_0
    //   178: invokevirtual 405	bwg:g	()V
    //   181: aload 4
    //   183: athrow
    //   184: astore 4
    //   186: aload_3
    //   187: monitorexit
    //   188: aload 4
    //   190: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	bwg
    //   1	90	1	i1	int
    //   71	4	2	i2	int
    //   6	181	3	localObject1	Object
    //   31	89	4	localbwr	bwr
    //   163	19	4	localObject2	Object
    //   184	5	4	localObject3	Object
    //   60	36	5	localhfe	hfe
    //   66	14	6	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   9	44	163	finally
    //   44	72	163	finally
    //   77	87	163	finally
    //   94	144	163	finally
    //   144	160	184	finally
    //   160	162	184	finally
    //   165	181	184	finally
    //   181	184	184	finally
    //   186	188	184	finally
  }
  
  public final void close()
  {
    if ((c == null) || (c.isClosed()) || (w)) {}
    try
    {
      c.unregisterContentObserver(v);
      w = false;
      c.close();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;) {}
    }
  }
  
  public final void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public final int d(Collection<Conversation> paramCollection)
  {
    return a(paramCollection, 131, null);
  }
  
  public final void d()
  {
    if ((!m) && (!n))
    {
      if ((!i) || (r != null)) {
        break label33;
      }
      h();
    }
    label33:
    while (!h) {
      return;
    }
    i();
  }
  
  public final void deactivate()
  {
    throw new UnsupportedOperationException();
  }
  
  public final int e(Collection<Conversation> paramCollection)
  {
    return a(paramCollection, 128, null);
  }
  
  public final Set<String> f()
  {
    synchronized (f)
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator = e.entrySet().iterator();
      StringBuilder localStringBuilder = new StringBuilder();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (((ContentValues)localEntry.getValue()).containsKey("__deleted__")) {
          localHashSet.add(a((String)localEntry.getKey(), localStringBuilder));
        }
      }
    }
    return localSet;
  }
  
  final void g()
  {
    synchronized (f)
    {
      boolean bool = w;
      if (!bool) {}
    }
    try
    {
      c.unregisterContentObserver(v);
      w = false;
      i = true;
      if (!m) {
        h();
      }
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;) {}
    }
  }
  
  public final byte[] getBlob(int paramInt)
  {
    Object localObject = b(paramInt);
    if (localObject != null) {
      return (byte[])localObject;
    }
    return c.getBlob(paramInt);
  }
  
  public final int getColumnCount()
  {
    return c.getColumnCount();
  }
  
  public final int getColumnIndex(String paramString)
  {
    return c.getColumnIndex(paramString);
  }
  
  public final int getColumnIndexOrThrow(String paramString)
  {
    return c.getColumnIndexOrThrow(paramString);
  }
  
  public final String getColumnName(int paramInt)
  {
    return c.getColumnName(paramInt);
  }
  
  public final String[] getColumnNames()
  {
    return c.getColumnNames();
  }
  
  public final int getCount()
  {
    if (c == null)
    {
      String str1 = l;
      String str2 = String.valueOf(p);
      throw new IllegalStateException(String.valueOf(str1).length() + 33 + String.valueOf(str2).length() + "getCount() on disabled cursor: " + str1 + "(" + str2 + ")");
    }
    return c.getCount() - x;
  }
  
  public final double getDouble(int paramInt)
  {
    Object localObject = b(paramInt);
    if (localObject != null) {
      return ((Double)localObject).doubleValue();
    }
    return c.getDouble(paramInt);
  }
  
  public final Bundle getExtras()
  {
    if (c != null) {
      return c.getExtras();
    }
    return Bundle.EMPTY;
  }
  
  public final float getFloat(int paramInt)
  {
    Object localObject = b(paramInt);
    if (localObject != null) {
      return ((Float)localObject).floatValue();
    }
    return c.getFloat(paramInt);
  }
  
  public final int getInt(int paramInt)
  {
    Object localObject = b(paramInt);
    if (localObject != null) {
      return ((Integer)localObject).intValue();
    }
    return c.getInt(paramInt);
  }
  
  public final long getLong(int paramInt)
  {
    Object localObject = b(paramInt);
    if (localObject != null) {
      return ((Long)localObject).longValue();
    }
    return c.getLong(paramInt);
  }
  
  public final Uri getNotificationUri()
  {
    if (c == null) {
      return null;
    }
    return c.getNotificationUri();
  }
  
  public final int getPosition()
  {
    return o;
  }
  
  public final short getShort(int paramInt)
  {
    Object localObject = b(paramInt);
    if (localObject != null) {
      return ((Short)localObject).shortValue();
    }
    return c.getShort(paramInt);
  }
  
  public final String getString(int paramInt)
  {
    if (paramInt == 1) {
      return a(c.b(), null);
    }
    Object localObject = b(paramInt);
    if (localObject != null) {
      return (String)localObject;
    }
    return c.getString(paramInt);
  }
  
  public final int getType(int paramInt)
  {
    return c.getType(paramInt);
  }
  
  public final boolean getWantsAllOnMoveCalls()
  {
    throw new UnsupportedOperationException();
  }
  
  public final void h()
  {
    if (!n) {
      synchronized (g)
      {
        Iterator localIterator = g.iterator();
        if (localIterator.hasNext()) {
          ((bwk)localIterator.next()).z_();
        }
      }
    }
  }
  
  public final int hashCode()
  {
    return super.hashCode();
  }
  
  final void i()
  {
    synchronized (g)
    {
      Iterator localIterator = g.iterator();
      if (localIterator.hasNext()) {
        ((bwk)localIterator.next()).A_();
      }
    }
  }
  
  public final boolean isAfterLast()
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean isBeforeFirst()
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean isClosed()
  {
    return (c == null) || (c.isClosed());
  }
  
  public final boolean isFirst()
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean isLast()
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean isNull(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  final void j()
  {
    synchronized (g)
    {
      Iterator localIterator = g.iterator();
      if (localIterator.hasNext()) {
        ((bwk)localIterator.next()).d();
      }
    }
    p();
  }
  
  public final void k()
  {
    if (d == null) {
      return;
    }
    synchronized (f)
    {
      r = null;
      h = false;
      a(d);
      d = null;
      j();
      return;
    }
  }
  
  public final boolean l()
  {
    synchronized (f)
    {
      if (r != null) {
        return false;
      }
      if (c != null)
      {
        c.a();
        bwr localbwr = c;
        if (!d)
        {
          localbwr.getWrappedCursor().registerContentObserver(c);
          d = true;
        }
        c.h = false;
      }
      r = new bwq(this);
      r.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
      return true;
    }
  }
  
  public final Conversation m()
  {
    Object localObject2 = n();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new Conversation(this);
      localObject2 = c;
      localObject2 = (bwu)g.get(((bwr)localObject2).getPosition());
      if (b == null) {
        b = ((Conversation)localObject1);
      }
    }
    return (Conversation)localObject1;
  }
  
  public final boolean move(int paramInt)
  {
    throw new UnsupportedOperationException("move unsupported!");
  }
  
  public final boolean moveToFirst()
  {
    if (c == null)
    {
      String str1 = l;
      String str2 = String.valueOf(p);
      throw new IllegalStateException(String.valueOf(str1).length() + 36 + String.valueOf(str2).length() + "moveToFirst() on disabled cursor: " + str1 + "(" + str2 + ")");
    }
    c.moveToPosition(-1);
    o = -1;
    return moveToNext();
  }
  
  public final boolean moveToLast()
  {
    throw new UnsupportedOperationException("moveToLast unsupported!");
  }
  
  public final boolean moveToNext()
  {
    do
    {
      if (!c.moveToNext())
      {
        o = getCount();
        return false;
      }
    } while ((b(-1) instanceof Integer));
    o += 1;
    return true;
  }
  
  public final boolean moveToPosition(int paramInt)
  {
    boolean bool = false;
    for (;;)
    {
      if (c == null)
      {
        String str1 = l;
        String str2 = String.valueOf(p);
        throw new IllegalStateException(String.valueOf(str1).length() + 39 + String.valueOf(str2).length() + "moveToPosition() on disabled cursor: " + str1 + "(" + str2 + ")");
      }
      if (c.getPosition() == -1) {
        cvm.b("ConversationCursor", "Underlying cursor position is -1 asking to move from %d to %d", new Object[] { Integer.valueOf(o), Integer.valueOf(paramInt) });
      }
      if (paramInt == 0) {
        bool = moveToFirst();
      }
      do
      {
        return bool;
        if (paramInt < 0)
        {
          o = -1;
          c.moveToPosition(o);
          return false;
        }
        if (paramInt != o) {
          break;
        }
      } while (paramInt >= getCount());
      return true;
      if (paramInt > o)
      {
        while (paramInt > o) {
          if (!moveToNext()) {
            return false;
          }
        }
        return true;
      }
      if ((paramInt < 0) || (o - paramInt <= paramInt)) {
        break;
      }
      moveToFirst();
    }
    while (paramInt < o) {
      if (!moveToPrevious()) {
        return false;
      }
    }
    return true;
  }
  
  public final boolean moveToPrevious()
  {
    do
    {
      if (!c.moveToPrevious())
      {
        o = -1;
        return false;
      }
    } while ((b(-1) instanceof Integer));
    o -= 1;
    return true;
  }
  
  public final Conversation n()
  {
    Object localObject = c;
    Conversation localConversation = g.get(((bwr)localObject).getPosition())).b;
    if (localConversation == null) {
      return null;
    }
    ContentValues localContentValues = (ContentValues)e.get(c.b());
    if (localContentValues != null)
    {
      localObject = new ContentValues();
      Iterator localIterator = localContentValues.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (u.contains(str)) {
          a((ContentValues)localObject, str, localContentValues.get(str));
        }
      }
      if (((ContentValues)localObject).size() > 0)
      {
        localConversation = new Conversation(localConversation);
        localConversation.a((ContentValues)localObject);
        return localConversation;
      }
    }
    return localConversation;
  }
  
  public final void o()
  {
    bwr localbwr = c;
    cxa.a(localbwr, localbwr.getPosition());
  }
  
  public final void p()
  {
    z.post(new bwj(this));
  }
  
  public final void registerContentObserver(ContentObserver paramContentObserver) {}
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver) {}
  
  public final boolean requery()
  {
    return true;
  }
  
  public final Bundle respond(Bundle paramBundle)
  {
    if (c != null) {
      return c.respond(paramBundle);
    }
    return Bundle.EMPTY;
  }
  
  public final void setExtras(Bundle paramBundle)
  {
    if (c != null) {
      c.setExtras(paramBundle);
    }
  }
  
  public final void setNotificationUri(ContentResolver paramContentResolver, Uri paramUri)
  {
    throw new UnsupportedOperationException();
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("{");
    localStringBuilder.append(super.toString());
    localStringBuilder.append(" mName=");
    localStringBuilder.append(l);
    localStringBuilder.append(" mDeferSync=");
    localStringBuilder.append(n);
    localStringBuilder.append(" mRefreshRequired=");
    localStringBuilder.append(i);
    localStringBuilder.append(" mRefreshReady=");
    localStringBuilder.append(h);
    localStringBuilder.append(" mRefreshTask=");
    localStringBuilder.append(r);
    localStringBuilder.append(" mPaused=");
    localStringBuilder.append(m);
    localStringBuilder.append(" mDeletedCount=");
    localStringBuilder.append(x);
    localStringBuilder.append(" mUnderlying=");
    localStringBuilder.append(c);
    if (cvm.a("ConversationCursor", 3))
    {
      localStringBuilder.append(" mCacheMap=");
      localStringBuilder.append(e);
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public final void unregisterContentObserver(ContentObserver paramContentObserver) {}
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver) {}
}

/* Location:
 * Qualified Name:     bwg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */