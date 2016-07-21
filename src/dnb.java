import android.content.Context;
import android.graphics.Bitmap;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.TimeUnit;

public final class dnb
  implements cfb
{
  private static final String a = cvl.a;
  
  /* Error */
  private static Bitmap a(Context paramContext, android.net.Uri paramUri, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 30	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: aload_1
    //   5: iload_2
    //   6: invokestatic 36	android/provider/ContactsContract$Contacts:openContactPhotoInputStream	(Landroid/content/ContentResolver;Landroid/net/Uri;Z)Ljava/io/InputStream;
    //   9: astore_0
    //   10: aload_0
    //   11: ifnull +71 -> 82
    //   14: aload_0
    //   15: invokestatic 42	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   18: astore_1
    //   19: aload_0
    //   20: invokevirtual 47	java/io/InputStream:close	()V
    //   23: aload_1
    //   24: areturn
    //   25: astore_0
    //   26: getstatic 15	dnb:a	Ljava/lang/String;
    //   29: ldc 49
    //   31: iconst_0
    //   32: anewarray 4	java/lang/Object
    //   35: invokestatic 55	cvm:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   38: pop
    //   39: aload_1
    //   40: areturn
    //   41: astore_0
    //   42: getstatic 15	dnb:a	Ljava/lang/String;
    //   45: aload_0
    //   46: ldc 57
    //   48: iconst_0
    //   49: anewarray 4	java/lang/Object
    //   52: invokestatic 60	cvm:d	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   55: pop
    //   56: aconst_null
    //   57: areturn
    //   58: astore_1
    //   59: aload_0
    //   60: invokevirtual 47	java/io/InputStream:close	()V
    //   63: aload_1
    //   64: athrow
    //   65: astore_0
    //   66: getstatic 15	dnb:a	Ljava/lang/String;
    //   69: ldc 49
    //   71: iconst_0
    //   72: anewarray 4	java/lang/Object
    //   75: invokestatic 55	cvm:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   78: pop
    //   79: goto -16 -> 63
    //   82: aconst_null
    //   83: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	paramContext	Context
    //   0	84	1	paramUri	android.net.Uri
    //   0	84	2	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   19	23	25	java/io/IOException
    //   0	10	41	java/lang/Exception
    //   19	23	41	java/lang/Exception
    //   26	39	41	java/lang/Exception
    //   59	63	41	java/lang/Exception
    //   63	65	41	java/lang/Exception
    //   66	79	41	java/lang/Exception
    //   14	19	58	finally
    //   59	63	65	java/io/IOException
  }
  
  public final Bitmap a(Context paramContext, String paramString1, String paramString2)
  {
    str1 = null;
    Bitmap localBitmap = null;
    Object localObject = new frp().a().b();
    eiz localeiz = new eja(paramContext.getApplicationContext()).a(frm.c, (eis)localObject).a();
    for (;;)
    {
      try
      {
        localeiz.c();
        localObject = new fqx();
        b = paramString1;
        e = 1;
        h = true;
        paramString1 = ((fqx)localObject).a();
        paramString2 = (fqy)frm.i.a(localeiz, paramString2, paramString1).a(5L, TimeUnit.SECONDS);
        paramString1 = paramString2.a();
        if (g == 15) {
          cvm.c(a, "Autocomplete query timed out.", new Object[0]);
        }
        localObject = paramString2.c();
      }
      finally
      {
        String str2;
        continue;
        paramString2 = null;
        paramContext = paramString2;
        continue;
        paramString1 = null;
        continue;
      }
      try
      {
        paramString2 = a;
        str1 = String.valueOf(paramString1);
        str2 = String.valueOf(localObject);
        cvm.b(paramString2, String.valueOf(str1).length() + 39 + String.valueOf(str2).length() + "Autocomplete list loaded: status=" + str1 + " list=" + str2, new Object[0]);
        if ((paramString1.b()) && (localObject != null))
        {
          int i = ((eli)localObject).c();
          if (i > 0) {}
        }
        else
        {
          if (localObject != null) {
            ((eli)localObject).d();
          }
          localeiz.d();
          return null;
        }
        paramString2 = (fxz)((eli)localObject).a(0);
        paramString1 = paramString2.j();
        if (paramString1 == null)
        {
          if (!cwm.a(paramContext, "android.permission.READ_CONTACTS"))
          {
            cvm.c(a, "We don't have contact permissions, but we want contact icon.", new Object[0]);
            paramContext = localBitmap;
            if (localObject != null) {
              ((eli)localObject).d();
            }
            localeiz.d();
            return paramContext;
          }
          if (paramString2.f() > 0L)
          {
            paramString1 = ftp.a(paramContext, paramString2.f());
            if (paramString1 != null)
            {
              localBitmap = a(paramContext, paramString1, true);
              paramString2 = localBitmap;
              if (localBitmap != null) {
                continue;
              }
              paramString2 = a(paramContext, paramString1, false);
              continue;
            }
          }
          else
          {
            if (paramString2.e() != null)
            {
              paramString1 = ftp.a(paramContext, ftp.a(paramContext, paramString2.b(), paramString2.e()));
              continue;
            }
            if (paramString2.d() == null) {
              continue;
            }
            paramString1 = ftp.a(paramContext, ftp.b(paramContext, paramString2.b(), paramString2.d()));
            continue;
          }
        }
        else
        {
          paramContext = new frg();
          a = 3;
          b = 1;
          paramContext = paramContext.a();
          paramString1 = (frh)frm.g.a(localeiz, paramString1, paramContext).a(5L, TimeUnit.SECONDS);
          paramContext = paramString1.c();
          paramString2 = paramString1.a();
          if (g == 15) {
            cvm.c(a, "Image load timed out.", new Object[0]);
          }
          if ((paramString2.b()) && (paramContext != null))
          {
            paramContext = dxr.a(paramContext);
            continue;
          }
          paramString1 = a;
          paramString2 = String.valueOf(paramString2);
          paramContext = String.valueOf(paramContext);
          cvm.b(paramString1, String.valueOf(paramString2).length() + 27 + String.valueOf(paramContext).length() + "Image loaded: status=" + paramString2 + "  pfd=" + paramContext, new Object[0]);
          paramContext = localBitmap;
          continue;
          paramContext = finally;
        }
      }
      finally
      {
        paramString1 = (String)localObject;
        if (paramString1 != null) {
          paramString1.d();
        }
        localeiz.d();
      }
    }
  }
}

/* Location:
 * Qualified Name:     dnb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */