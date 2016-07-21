import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public final class dvd
{
  public static final URI a = URI.create("https://mail.google.com/mail/g/");
  final Context b;
  URI c;
  dor d;
  private final ddy e;
  
  public dvd(Context paramContext, dor paramdor)
  {
    b = paramContext;
    e = new ddy(paramContext);
    c = a;
    d = paramdor;
  }
  
  static gww a()
  {
    gww localgww = new gww();
    k = 2;
    a |= 0x2;
    return localgww;
  }
  
  static gwx a(dqu paramdqu, dnr paramdnr)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(a(new dns("abi", Build.ID)));
    localArrayList.add(a(new dns("de", Build.DEVICE)));
    localArrayList.add(a(new dns("am", Build.MODEL)));
    localArrayList.add(a(new dns("av", Build.VERSION.RELEASE)));
    int i;
    if ((paramdqu != null) && (b))
    {
      i = (int)p;
      if (!a) {
        break label292;
      }
    }
    label292:
    for (String str = "p";; str = "d")
    {
      localArrayList.add(a(new dns(String.format("%s-%s", new Object[] { "shdm", str }), Integer.valueOf(i))));
      localArrayList.add(a(new dns("sssc", Integer.valueOf(paramdqu.i()))));
      localArrayList.add(a(new dns("smsc", Integer.valueOf(paramdqu.j()))));
      localArrayList.add(a(new dns("srs", Integer.valueOf((int)q))));
      paramdqu = paramdnr.c().iterator();
      while (paramdqu.hasNext()) {
        localArrayList.add(a((dns)paramdqu.next()));
      }
    }
    paramdqu = new gwx();
    a = ((gwz[])localArrayList.toArray(gwz.b()));
    return paramdqu;
  }
  
  private static gwz a(dns paramdns)
  {
    int j = 1;
    gwz localgwz = new gwz();
    b = a;
    int i;
    if (b != null)
    {
      i = 1;
      if (i != 0)
      {
        c = b.intValue();
        a |= 0x1;
      }
      if (c == null) {
        break label87;
      }
      i = j;
    }
    for (;;)
    {
      if (i != 0)
      {
        paramdns = c;
        if (paramdns == null)
        {
          throw new NullPointerException();
          i = 0;
          break;
          label87:
          i = 0;
          continue;
        }
        d = paramdns;
        a |= 0x2;
      }
    }
    return localgwz;
  }
  
  static void a(int paramInt, List<NameValuePair> paramList)
  {
    paramList.add(new BasicNameValuePair("version", Integer.toString(paramInt)));
    paramList.add(new BasicNameValuePair("clientVersion", Integer.toString(25)));
  }
  
  /* Error */
  public static void a(ContentResolver paramContentResolver, gww paramgww, HttpPost paramHttpPost)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 224	hlt:a	(Lhlt;)[B
    //   4: astore_1
    //   5: aload_1
    //   6: arraylength
    //   7: aload_0
    //   8: ldc -30
    //   10: ldc -29
    //   12: invokestatic 232	ghz:a	(Landroid/content/ContentResolver;Ljava/lang/String;I)I
    //   15: if_icmpgt +15 -> 30
    //   18: aload_1
    //   19: aload_0
    //   20: invokestatic 238	android/net/http/AndroidHttpClient:getCompressedEntity	([BLandroid/content/ContentResolver;)Lorg/apache/http/entity/AbstractHttpEntity;
    //   23: astore_0
    //   24: aload_2
    //   25: aload_0
    //   26: invokevirtual 244	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   29: return
    //   30: new 246	org/apache/http/entity/ByteArrayEntity
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 249	org/apache/http/entity/ByteArrayEntity:<init>	([B)V
    //   38: astore_0
    //   39: goto -15 -> 24
    //   42: astore_0
    //   43: new 251	java/lang/RuntimeException
    //   46: dup
    //   47: ldc -3
    //   49: invokespecial 256	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	paramContentResolver	ContentResolver
    //   0	53	1	paramgww	gww
    //   0	53	2	paramHttpPost	HttpPost
    // Exception table:
    //   from	to	target	type
    //   0	24	42	java/io/IOException
    //   24	29	42	java/io/IOException
    //   30	39	42	java/io/IOException
  }
  
  static void a(gww paramgww, dqu paramdqu)
  {
    Object localObject;
    int i;
    dtd localdtd;
    if ((paramdqu != null) && (b))
    {
      m = new dop();
      paramgww = m;
      d = Build.VERSION.SDK_INT;
      a |= 0x2;
      localObject = Build.ID;
      if (localObject == null) {
        throw new NullPointerException();
      }
      c = ((String)localObject);
      a |= 0x1;
      localObject = Build.DEVICE;
      if (localObject == null) {
        throw new NullPointerException();
      }
      e = ((String)localObject);
      a |= 0x4;
      localObject = Build.MODEL;
      if (localObject == null) {
        throw new NullPointerException();
      }
      f = ((String)localObject);
      a |= 0x8;
      g = v;
      a |= 0x10;
      h = w;
      a |= 0x20;
      j = a;
      a |= 0x80;
      paramgww.l = g;
      a |= 0x400;
      m = paramdqu.k();
      a |= 0x1000;
      k = u;
      a |= 0x200;
      if (x < 0) {
        break label659;
      }
      i = 1;
      if (i != 0)
      {
        paramgww.i = x;
        a |= 0x40;
      }
      localObject = new doq();
      b = 1;
      a |= 0x1;
      localdtd = c;
      if (!c) {
        break label664;
      }
      i = 2;
    }
    for (;;)
    {
      c = i;
      a |= 0x2;
      d = p;
      a |= 0x4;
      e = q;
      a |= 0x8;
      f = r;
      a |= 0x10;
      g = paramdqu.h();
      a |= 0x20;
      long l = s;
      if (l != 0L)
      {
        h = (n - l);
        a |= 0x40;
      }
      i = e;
      a |= 0x100;
      j = paramdqu.g();
      k = t;
      a |= 0x200;
      l = paramdqu.f();
      a |= 0x400;
      m = paramdqu.e();
      paramdqu = y;
      if (paramdqu != null)
      {
        n = a;
        a |= 0x800;
        p = c;
        a |= 0x2000;
        o = b;
        a |= 0x1000;
      }
      b = new doq[] { localObject };
      return;
      label659:
      i = 0;
      break;
      label664:
      if (b) {
        i = 3;
      } else {
        i = 1;
      }
    }
  }
  
  public final gww a(ContentResolver paramContentResolver, long paramLong1, long paramLong2, long paramLong3, ArrayList<dtq> paramArrayList, ArrayList<Long> paramArrayList1, ArrayList<Long> paramArrayList2, boolean paramBoolean1, boolean paramBoolean2, dtd paramdtd, dqu paramdqu, dnr paramdnr)
  {
    gww localgww = a();
    f = new gxe();
    gxe localgxe = f;
    b = paramLong1;
    a |= 0x1;
    d = paramLong2;
    a |= 0x4;
    c = 200;
    a |= 0x2;
    m = true;
    a |= 0x4000;
    if (b)
    {
      localgxe.b(2);
      if (d != null)
      {
        n = d.longValue();
        a |= 0x10000;
      }
      e = true;
      a |= 0x20;
      g = true;
      a |= 0x80;
      h = true;
      a |= 0x100;
      f = ghz.a(paramContentResolver, "gmail_compression_type", 3);
      a |= 0x40;
      i = true;
      a |= 0x200;
      j = ghz.a(paramContentResolver, "gmail_main_sync_max_conversion_headers", 0);
      a |= 0x400;
      k = 5;
      a |= 0x800;
      l = true;
      a |= 0x2000;
      if (!paramBoolean1) {
        break label775;
      }
      p = true;
    }
    for (a |= 0x40000;; a |= 0x20000)
    {
      if (paramBoolean2)
      {
        q = true;
        a |= 0x80000;
      }
      r = true;
      a |= 0x100000;
      s = true;
      a |= 0x200000;
      if (dkn.a())
      {
        t = true;
        a |= 0x400000;
      }
      l = a(paramdqu, paramdnr);
      a(localgww, paramdqu);
      j = d.a();
      h = new gxi();
      paramdqu = h;
      b = paramLong3;
      a |= 0x1;
      cvm.c("Gmail", "MainSyncRequestProto: lowestBkwdConvoId: %d, highestHandledServerOp: %d, normalSync: %b", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(a) });
      paramdqu = new ArrayList();
      if (paramArrayList.isEmpty()) {
        break label817;
      }
      if (g == null) {
        g = new gxb();
      }
      paramdnr = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        dtq localdtq = (dtq)paramArrayList.next();
        gxc localgxc = new gxc();
        b = a;
        a |= 0x1;
        c = b;
        a |= 0x2;
        if (b == 0L) {
          paramdqu.add(Long.valueOf(a));
        }
        paramdnr.add(localgxc);
        cvm.a("Gmail", "MainSyncRequestProto: fetchConversation: ConvoId: %d, HighestMessageIdOnClient: %d", new Object[] { Long.valueOf(a), Long.valueOf(b) });
      }
      if (c)
      {
        localgxe.b(1);
        break;
      }
      localgxe.b(0);
      break;
      label775:
      o = true;
    }
    g.a = ((gxc[])paramdnr.toArray(gxc.b()));
    label817:
    paramdqu.addAll(paramArrayList2);
    if (!paramdqu.isEmpty())
    {
      if (g == null) {
        g = new gxb();
      }
      g.c = hku.a(paramdqu);
      cvm.b("Gmail", "MainSyncRequestProto: ConversationSync.DirtyConversationIds: %s", new Object[] { paramdqu });
    }
    if (!a)
    {
      localgxe.a(0);
      return localgww;
    }
    localgxe.a(ghz.a(paramContentResolver, "gmail_main_sync_max_forward_sync_items_limit", 1000));
    if (!paramArrayList1.isEmpty())
    {
      if (g == null) {
        g = new gxb();
      }
      g.b = hku.a(paramArrayList1);
      cvm.b("Gmail", "MainSyncRequestProto: ConversationSync.MessageIds: %s", new Object[] { paramArrayList1 });
    }
    return localgww;
  }
  
  final URI a(List<NameValuePair> paramList)
  {
    paramList = URLEncodedUtils.format(paramList, "UTF-8");
    if (TextUtils.isEmpty(paramList)) {
      return c;
    }
    String str = String.valueOf(c);
    return URI.create(String.valueOf(str).length() + 1 + String.valueOf(paramList).length() + str + "?" + paramList);
  }
  
  public final HttpPost a(ContentResolver paramContentResolver, int paramInt, long paramLong, gww paramgww, boolean paramBoolean)
  {
    if (paramInt < 25) {
      throw new IllegalArgumentException(51 + "Cannot make a proto request for version " + paramInt);
    }
    if (paramLong != 0L)
    {
      b = paramLong;
      a |= 0x1;
      cvm.b("Gmail", "ProtoRequest: clientid: %d", new Object[] { Long.valueOf(paramLong) });
    }
    Object localObject = new LinkedList();
    a(paramInt, (List)localObject);
    localObject = new HttpPost(a((List)localObject));
    if (paramBoolean) {
      a(paramContentResolver, paramgww, (HttpPost)localObject);
    }
    return (HttpPost)localObject;
  }
}

/* Location:
 * Qualified Name:     dvd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */