import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.android.emailcommon.provider.Attachment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class bpq
{
  Context a;
  public long b;
  String c;
  String d;
  String e;
  String f;
  String g;
  int h;
  int i;
  int j;
  int k;
  public long l;
  long m;
  public int n;
  String o;
  String p;
  ArrayList<Attachment> q = new ArrayList();
  Map<Long, bpp> r = new HashMap();
  public ArrayList<String> s = new ArrayList();
  String t;
  String u;
  
  bpq() {}
  
  bpq(Context paramContext, Cursor paramCursor)
  {
    a = paramContext;
    b = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
    c = paramCursor.getString(paramCursor.getColumnIndex("toList"));
    d = paramCursor.getString(paramCursor.getColumnIndex("ccList"));
    e = paramCursor.getString(paramCursor.getColumnIndex("bccList"));
    f = paramCursor.getString(paramCursor.getColumnIndex("replyToList"));
    g = paramCursor.getString(paramCursor.getColumnIndex("subject"));
    h = paramCursor.getInt(paramCursor.getColumnIndex("priority"));
    i = paramCursor.getInt(paramCursor.getColumnIndex("flagAttachment"));
    j = paramCursor.getInt(paramCursor.getColumnIndex("flagRead"));
    k = paramCursor.getInt(paramCursor.getColumnIndex("flagFavorite"));
    l = paramCursor.getLong(paramCursor.getColumnIndex("timeStamp"));
    m = paramCursor.getLong(paramCursor.getColumnIndex("draftUpsyncTimestamp"));
    n = paramCursor.getInt(paramCursor.getColumnIndex("flagsEas"));
    paramContext = bds.a(a, b);
    if (paramContext != null)
    {
      o = d;
      p = e;
    }
    if (i == 1)
    {
      paramContext = Attachment.b(a, b);
      int i2 = paramContext.length;
      int i1 = 0;
      while (i1 < i2)
      {
        Attachment localAttachment = paramContext[i1];
        if (TextUtils.isEmpty(y))
        {
          bpp localbpp = bpo.a(a, localAttachment);
          if ((!TextUtils.isEmpty(i)) && (localbpp != null))
          {
            r.put(Long.valueOf(D), localbpp);
            q.add(localAttachment);
          }
        }
        i1 += 1;
      }
    }
    a();
    t = paramCursor.getString(paramCursor.getColumnIndex("syncServerId"));
    if (TextUtils.isEmpty(t)) {}
    for (paramContext = bpo.a("draft", b);; paramContext = t)
    {
      u = paramContext;
      return;
    }
  }
  
  /* Error */
  private final void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 68	bpq:b	J
    //   4: invokestatic 192	java/lang/Long:toString	(J)Ljava/lang/String;
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 54	bpq:a	Landroid/content/Context;
    //   12: invokevirtual 198	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   15: getstatic 201	com/android/emailcommon/provider/Attachment:b	Landroid/net/Uri;
    //   18: getstatic 204	bpo:d	[Ljava/lang/String;
    //   21: ldc -50
    //   23: iconst_1
    //   24: anewarray 208	java/lang/String
    //   27: dup
    //   28: iconst_0
    //   29: aload_1
    //   30: aastore
    //   31: aconst_null
    //   32: invokevirtual 214	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   35: astore_1
    //   36: aload_1
    //   37: ifnull +63 -> 100
    //   40: aload_1
    //   41: invokeinterface 218 1 0
    //   46: ifeq +54 -> 100
    //   49: aload_1
    //   50: aload_1
    //   51: ldc -36
    //   53: invokeinterface 62 2 0
    //   58: invokeinterface 74 2 0
    //   63: astore_2
    //   64: aload_2
    //   65: invokestatic 149	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   68: ifne -32 -> 36
    //   71: aload_0
    //   72: getfield 50	bpq:s	Ljava/util/ArrayList;
    //   75: aload_2
    //   76: invokevirtual 175	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   79: pop
    //   80: goto -44 -> 36
    //   83: astore_3
    //   84: aload_1
    //   85: astore_2
    //   86: aload_3
    //   87: astore_1
    //   88: aload_2
    //   89: ifnull +9 -> 98
    //   92: aload_2
    //   93: invokeinterface 223 1 0
    //   98: aload_1
    //   99: athrow
    //   100: aload_1
    //   101: ifnull +9 -> 110
    //   104: aload_1
    //   105: invokeinterface 223 1 0
    //   110: return
    //   111: astore_1
    //   112: aconst_null
    //   113: astore_2
    //   114: goto -26 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	bpq
    //   7	98	1	localObject1	Object
    //   111	1	1	localObject2	Object
    //   63	51	2	localObject3	Object
    //   83	4	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   40	80	83	finally
    //   8	36	111	finally
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof bpq))) {}
    do
    {
      return false;
      paramObject = (bpq)paramObject;
    } while ((b != b) || (!hbc.a(c, c)) || (!hbc.a(d, d)) || (!hbc.a(e, e)) || (!hbc.a(f, f)) || (!hbc.a(g, g)) || (h != h) || (i != i) || (j != j) || (k != k) || (l != l) || (m != m) || (!hbc.a(o, o)) || (!hbc.a(p, p)) || (!hbc.a(q, q)) || (!hbc.a(r, r)) || (!hbc.a(s, s)) || (!hbc.a(t, t)) || (!hbc.a(u, u)));
    return true;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { Long.valueOf(b), c, d, e, f, g, Integer.valueOf(h), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(l), Long.valueOf(m), o, p, q, r, s, t, u });
  }
}

/* Location:
 * Qualified Name:     bpq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */