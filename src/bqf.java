import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.android.emailcommon.provider.Attachment;
import com.android.emailcommon.provider.Mailbox;
import com.android.exchange.service.EasService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.entity.InputStreamEntity;

public final class bqf
  extends bqc
{
  private final beb a;
  private boolean b;
  private final File c;
  private final bqh d;
  private final int e;
  private final boolean k;
  private File l;
  private FileInputStream m;
  
  public bqf(Context paramContext, com.android.emailcommon.provider.Account paramAccount, beb parambeb, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext, paramAccount);
    a = parambeb;
    j();
    c = paramContext.getCacheDir();
    Object localObject2;
    Object localObject4;
    Object localObject3;
    int j;
    Object localObject1;
    int i;
    if (paramBoolean1)
    {
      localObject2 = f;
      localObject4 = g;
      localObject3 = a;
      j = u;
      parambeb = null;
      localObject1 = null;
      Object localObject5 = ac;
      paramAccount = (com.android.emailcommon.provider.Account)localObject1;
      paramContext = parambeb;
      if (TextUtils.isEmpty((CharSequence)localObject5)) {
        break label714;
      }
      localObject5 = new bdl((String)localObject5);
      String str = ((bdl)localObject5).a("EVENT_FORWARD");
      paramAccount = (com.android.emailcommon.provider.Account)localObject1;
      paramContext = parambeb;
      if (TextUtils.isEmpty(str)) {
        break label714;
      }
      paramAccount = (com.android.emailcommon.provider.Account)localObject1;
      paramContext = parambeb;
      if (!Boolean.valueOf(str).booleanValue()) {
        break label714;
      }
      parambeb = ((bdl)localObject5).a("COLLECTION_ID");
      localObject1 = ((bdl)localObject5).a("ITEM_ID");
      paramAccount = parambeb;
      paramContext = (Context)localObject1;
      if (TextUtils.isEmpty(parambeb)) {
        break label714;
      }
      paramAccount = parambeb;
      paramContext = (Context)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label714;
      }
      i = 1;
      paramContext = (Context)localObject1;
      paramAccount = parambeb;
    }
    for (;;)
    {
      if ((i == 0) && ((0x20000 & j) != 0))
      {
        paramContext = null;
        d = paramContext;
        label197:
        k = paramBoolean2;
        paramContext = d;
        if (!b) {
          break label708;
        }
        if (paramContext != null) {
          break label685;
        }
        i = 1349;
      }
      for (;;)
      {
        e = i;
        return;
        if ((j & 0x1) != 0) {}
        for (paramBoolean1 = true;; paramBoolean1 = false)
        {
          if (!paramBoolean1) {
            break label257;
          }
          paramContext = null;
          break;
        }
        label257:
        if ((j & 0x2) != 0) {}
        for (j = 1;; j = 0)
        {
          if ((paramBoolean1) || (j != 0)) {
            break label288;
          }
          paramContext = null;
          break;
        }
        label288:
        if ((paramBoolean1) && (j != 0))
        {
          paramContext = null;
          break;
        }
        if ((j & 0x80) == 0)
        {
          paramContext = null;
          break;
        }
        long l1 = 0L;
        localObject1 = paramAccount;
        parambeb = paramContext;
        if (i == 0)
        {
          long l2 = bds.b((Context)localObject2, D);
          cvm.b("Exchange", "getSmartSendInfo - found refId: %d for %d", new Object[] { Long.valueOf(l2), Long.valueOf(D) });
          l1 = l2;
          localObject1 = paramAccount;
          parambeb = paramContext;
          if (l2 > 0L)
          {
            localObject4 = bhn.a((Context)localObject2, beb.a, l2, new String[] { "syncServerId", "mailboxKey", "protocolSearchInfo" });
            l1 = l2;
            localObject1 = paramAccount;
            parambeb = paramContext;
            if (localObject4 != null)
            {
              paramContext = localObject4[0];
              l1 = Long.parseLong(localObject4[1]);
              localObject4 = bhn.a((Context)localObject2, Mailbox.a, l1, new String[] { "serverId" });
              l1 = l2;
              localObject1 = paramAccount;
              parambeb = paramContext;
              if (localObject4 != null)
              {
                localObject1 = localObject4[0];
                parambeb = paramContext;
                l1 = l2;
              }
            }
          }
        }
        if ((parambeb != null) && (localObject1 != null))
        {
          if (j != 0)
          {
            localObject3 = Attachment.b((Context)localObject2, D);
            localObject2 = Attachment.b((Context)localObject2, l1);
            j = localObject2.length;
            i = 0;
            for (;;)
            {
              if (i >= j) {
                break label575;
              }
              if (!bqh.a(localObject2[i], (Attachment[])localObject3))
              {
                paramContext = null;
                break;
              }
              i += 1;
            }
            label575:
            paramAccount = new ArrayList();
            j = localObject3.length;
            i = 0;
            for (;;)
            {
              paramContext = paramAccount;
              if (i >= j) {
                break;
              }
              paramContext = localObject3[i];
              if (!bqh.a(paramContext, (Attachment[])localObject2)) {
                paramAccount.add(paramContext);
              }
              i += 1;
            }
          }
          paramContext = null;
          paramContext = new bqh(parambeb, (String)localObject1, paramBoolean1, paramContext);
          break;
        }
        cvm.d("Exchange", "getSmartSendInfo - Skipping SmartSend, could not find IDs for: %d", new Object[] { Long.valueOf(D) });
        paramContext = null;
        break;
        d = null;
        break label197;
        label685:
        if (paramContext.a())
        {
          i = 1350;
        }
        else
        {
          i = 1351;
          continue;
          label708:
          i = 0;
        }
      }
      label714:
      i = 0;
    }
  }
  
  /* Error */
  private final boolean a(File paramFile, beb parambeb, bqh parambqh)
  {
    // Byte code:
    //   0: new 184	java/io/FileOutputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 187	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   8: astore 5
    //   10: aload_3
    //   11: ifnull +49 -> 60
    //   14: iconst_1
    //   15: istore 4
    //   17: iload 4
    //   19: ifeq +47 -> 66
    //   22: aload_3
    //   23: getfield 190	bqh:d	Ljava/util/ArrayList;
    //   26: astore_1
    //   27: aload_0
    //   28: getfield 41	bqf:f	Landroid/content/Context;
    //   31: aload_2
    //   32: aload 5
    //   34: iload 4
    //   36: iconst_1
    //   37: aload_1
    //   38: invokestatic 195	bcp:a	(Landroid/content/Context;Lbeb;Ljava/io/OutputStream;ZZLjava/util/List;)V
    //   41: aload 5
    //   43: invokevirtual 198	java/io/FileOutputStream:close	()V
    //   46: iconst_1
    //   47: ireturn
    //   48: astore_1
    //   49: ldc 108
    //   51: ldc -56
    //   53: aload_1
    //   54: invokestatic 205	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   57: pop
    //   58: iconst_0
    //   59: ireturn
    //   60: iconst_0
    //   61: istore 4
    //   63: goto -46 -> 17
    //   66: aconst_null
    //   67: astore_1
    //   68: goto -41 -> 27
    //   71: astore_1
    //   72: ldc 108
    //   74: ldc -49
    //   76: aload_1
    //   77: invokestatic 205	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   80: pop
    //   81: goto -35 -> 46
    //   84: astore_1
    //   85: ldc 108
    //   87: ldc -47
    //   89: aload_1
    //   90: invokestatic 205	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   93: pop
    //   94: aload 5
    //   96: invokevirtual 198	java/io/FileOutputStream:close	()V
    //   99: iconst_0
    //   100: ireturn
    //   101: astore_1
    //   102: ldc 108
    //   104: ldc -49
    //   106: aload_1
    //   107: invokestatic 205	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   110: pop
    //   111: goto -12 -> 99
    //   114: astore_1
    //   115: aload 5
    //   117: invokevirtual 198	java/io/FileOutputStream:close	()V
    //   120: aload_1
    //   121: athrow
    //   122: astore_2
    //   123: ldc 108
    //   125: ldc -49
    //   127: aload_2
    //   128: invokestatic 205	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   131: pop
    //   132: goto -12 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	bqf
    //   0	135	1	paramFile	File
    //   0	135	2	parambeb	beb
    //   0	135	3	parambqh	bqh
    //   15	47	4	bool	boolean
    //   8	108	5	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   0	10	48	java/io/FileNotFoundException
    //   41	46	71	java/io/IOException
    //   22	27	84	java/lang/Exception
    //   27	41	84	java/lang/Exception
    //   94	99	101	java/io/IOException
    //   22	27	114	finally
    //   27	41	114	finally
    //   85	94	114	finally
    //   115	120	122	java/io/IOException
  }
  
  private final void c(int paramInt)
  {
    cvm.b("Exchange", "Permanent failure sending message %d status %d", new Object[] { Long.valueOf(a.D), Integer.valueOf(paramInt) });
    a.ak = Long.MAX_VALUE;
    a.a(f, a.e());
  }
  
  private final void d(int paramInt)
  {
    int i;
    if (k)
    {
      i = a.aj;
      if (i < 5L) {
        break label234;
      }
      cvm.b("Exchange", "Too many failures sending message %d status %d, failing permanently", new Object[] { Long.valueOf(a.D), Integer.valueOf(paramInt) });
    }
    for (long l1 = Long.MAX_VALUE;; l1 = System.currentTimeMillis() + Math.pow(2.0D, a.aj) * 1800000L)
    {
      ContentValues localContentValues = new ContentValues(2);
      localContentValues.put("retryCount", Integer.valueOf(i));
      localContentValues.put("nextRetryTime", Long.valueOf(l1));
      Object localObject = new Intent(f, EasService.class);
      String str = bnq.c;
      ((Intent)localObject).setAction(str);
      ((Intent)localObject).putExtra("SYNC_OUTBOX", true);
      ((Intent)localObject).putExtra("MAILBOX_ID", a.U);
      ((Intent)localObject).putExtra("ACCOUNT", new android.accounts.Account(g.d, str));
      localObject = PendingIntent.getService(f, 0, (Intent)localObject, 1073741824);
      ((AlarmManager)f.getSystemService("alarm")).set(1, l1, (PendingIntent)localObject);
      a.a(f, localContentValues);
      return;
      i = a.aj + 1;
      break;
      label234:
      cvm.b("Exchange", "Temporary failure while sending message %d, status %d", new Object[] { Long.valueOf(a.D), Integer.valueOf(paramInt) });
    }
  }
  
  private final void j()
  {
    b = bnq.b(g.l);
  }
  
  protected final int a(bns parambns)
  {
    if (b) {}
    try
    {
      parambns = new bph(parambns.d(), e);
      parambns.d();
      i = a;
      if (bnp.a(i))
      {
        cvm.d("Exchange", "Needs provisioning before sending message: %d", new Object[] { Long.valueOf(a.D) });
        return -6;
      }
      if ((i == 150) && (d != null))
      {
        cvm.d("Exchange", "ITEM_NOT_FOUND smart sending message: %d", new Object[] { Long.valueOf(a.D) });
        return -101;
      }
      if (bnp.d(i))
      {
        d(i);
        return -102;
      }
    }
    catch (boz parambns)
    {
      int i;
      cvm.b("Exchange", "Empty response sending message: %d", new Object[] { Long.valueOf(a.D) });
      cvm.b("Exchange", "Returning RESULT_SUCCESS after sending: %d", new Object[] { Long.valueOf(a.D) });
      f.getContentResolver().delete(ContentUris.withAppendedId(beb.a, a.D), null, null);
      return 0;
      c(i);
      cvm.e("Exchange", "General failure sending message: %d status: %d", new Object[] { Long.valueOf(a.D), Integer.valueOf(i) });
      return -102;
    }
    catch (IOException parambns)
    {
      cvm.e("Exchange", parambns, "IOException sending message: %d", new Object[] { Long.valueOf(a.D) });
    }
    return -100;
  }
  
  protected final int b(bns parambns)
  {
    int i = b;
    cvm.b("Exchange", "handleHttpError %d", new Object[] { Integer.valueOf(i) });
    if ((i == 500) && (d != null)) {
      return -101;
    }
    switch (i)
    {
    }
    for (;;)
    {
      return -99;
      c(i);
      continue;
      d(i);
    }
  }
  
  protected final String b()
  {
    String str = "SendMail";
    if (d != null)
    {
      if (!b) {
        break label61;
      }
      if (!d.a()) {
        break label54;
      }
    }
    label54:
    for (str = "SmartForward";; str = "SmartReply")
    {
      localObject = str;
      if (!b) {
        localObject = String.valueOf(str).concat("&SaveInSent=T");
      }
      return (String)localObject;
    }
    label61:
    Object localObject = d;
    StringBuilder localStringBuilder = new StringBuilder();
    if (((bqh)localObject).a()) {}
    for (str = "SmartForward";; str = "SmartReply")
    {
      localStringBuilder.append(str);
      localStringBuilder.append("&ItemId=");
      localStringBuilder.append(Uri.encode(a, ":"));
      localStringBuilder.append("&CollectionId=");
      localStringBuilder.append(Uri.encode(b, ":"));
      str = localStringBuilder.toString();
      break;
    }
  }
  
  protected final HttpEntity c()
  {
    try
    {
      l = File.createTempFile("eas_", "tmp", c);
      if (!a(l, a, d))
      {
        cvm.d("Exchange", "IO error writing to temp file", new Object[0]);
        throw new bqd(this, "Failure writing to temp file");
      }
    }
    catch (IOException localIOException)
    {
      cvm.d("Exchange", "IO error creating temp file", new Object[0]);
      throw new IllegalStateException("Failure creating temp file");
    }
    long l1;
    try
    {
      m = new FileInputStream(l);
      l1 = l.length();
      if (b) {
        return new bqg(m, l1, e, a, d);
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      cvm.d("Exchange", "IO error creating fileInputStream", new Object[0]);
      throw new IllegalStateException("Failure creating fileInputStream");
    }
    return new InputStreamEntity(m, l1);
  }
  
  public final String d()
  {
    if (h.e < 14.0D) {
      return "message/rfc822";
    }
    return super.d();
  }
  
  public final boolean k()
  {
    j();
    return true;
  }
  
  protected final void m()
  {
    if (m != null) {}
    try
    {
      m.close();
      m = null;
      if (l != null)
      {
        if (l.exists()) {
          l.delete();
        }
        l = null;
      }
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        cvm.d("Exchange", "IOException closing fileStream %s", new Object[] { localIOException });
      }
    }
  }
}

/* Location:
 * Qualified Name:     bqf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */