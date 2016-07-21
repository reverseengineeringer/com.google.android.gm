import android.content.ContentUris;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.provider.ContactsContract.Contacts;
import com.google.android.gms.common.api.Status;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public final class dxr
  extends cot<hel<String, btn>>
{
  private static final String a = cvl.a;
  private final eiz b;
  private final String c;
  private final Set<String> d;
  
  public dxr(Context paramContext, eiz parameiz, String paramString, Set<String> paramSet)
  {
    super(paramContext);
    b = parameiz;
    c = paramString;
    d = paramSet;
  }
  
  public static Bitmap a(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    try
    {
      Bitmap localBitmap = frs.a(paramParcelFileDescriptor);
      try
      {
        paramParcelFileDescriptor.close();
        return localBitmap;
      }
      catch (IOException paramParcelFileDescriptor)
      {
        cvm.b(a, paramParcelFileDescriptor.getMessage(), new Object[0]);
        return localBitmap;
      }
      try
      {
        paramParcelFileDescriptor.close();
        throw ((Throwable)localObject);
      }
      catch (IOException paramParcelFileDescriptor)
      {
        for (;;)
        {
          cvm.b(a, paramParcelFileDescriptor.getMessage(), new Object[0]);
        }
      }
    }
    finally {}
  }
  
  public static hel<String, btn> a(Context paramContext, eiz parameiz, String paramString, Set<String> paramSet, boolean paramBoolean)
  {
    ans.a("load contact photos util");
    if ((!parameiz.f()) && (!parameiz.e()))
    {
      cvm.b(a, "Client not connected.", new Object[0]);
      ans.a();
      return null;
    }
    if (cwm.a(paramContext, "android.permission.READ_CONTACTS")) {
      bus.a("contacts_photo", "enabled");
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      paramContext = new fqx();
      b = paramString;
      e = 1;
      h = true;
      fqw localfqw = paramContext.a();
      paramSet = paramSet.iterator();
      label102:
      if (!paramSet.hasNext()) {
        break label745;
      }
      String str = (String)paramSet.next();
      try
      {
        ans.a("get autocomplete entry");
        paramContext = (fqy)frm.i.a(parameiz, str, localfqw).a(5L, TimeUnit.SECONDS);
        Object localObject1 = paramContext.a();
        if (g == 15) {
          cvm.c(a, "Autocomplete query timed out.", new Object[0]);
        }
        paramString = paramContext.c();
        try
        {
          paramContext = a;
          Object localObject2 = String.valueOf(localObject1);
          Object localObject3 = String.valueOf(paramString);
          cvm.b(paramContext, String.valueOf(localObject2).length() + 39 + String.valueOf(localObject3).length() + "Autocomplete list loaded: status=" + (String)localObject2 + " list=" + (String)localObject3, new Object[0]);
          ans.a();
          if ((!((Status)localObject1).b()) || (paramString == null) || (paramString.c() <= 0))
          {
            localHashMap.put(str, new btn(null));
            if (paramString == null) {
              break label102;
            }
            paramString.d();
            break label102;
            bus.a("contacts_photo", "disabled");
          }
          else
          {
            localObject2 = (fxz)paramString.a(0);
            long l = ((fxz)localObject2).f();
            if (l != 0L) {}
            for (paramContext = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, l);; paramContext = null)
            {
              if (((fxz)localObject2).j() != null) {
                break label430;
              }
              cvm.b(a, "AvatarReference is null.", new Object[0]);
              localHashMap.put(str, new btn(paramContext));
              if (paramString == null) {
                break;
              }
              paramString.d();
              break;
            }
            label430:
            ans.a("get image result");
            localObject3 = new frg();
            a = 1;
            b = 1;
            localObject3 = ((frg)localObject3).a();
            localObject3 = (frh)frm.g.a(parameiz, ((fxz)localObject2).j(), (frf)localObject3).a(5L, TimeUnit.SECONDS);
            localObject2 = ((frh)localObject3).c();
            localObject3 = ((frh)localObject3).a();
            ans.a();
            int i = g;
            if ((!((Status)localObject3).b()) || (localObject2 == null))
            {
              localObject3 = a;
              localObject1 = String.valueOf(localObject1);
              localObject2 = String.valueOf(localObject2);
              cvm.b((String)localObject3, String.valueOf(localObject1).length() + 27 + String.valueOf(localObject2).length() + "Image loaded: status=" + (String)localObject1 + "  pfd=" + (String)localObject2, new Object[0]);
              localHashMap.put(str, new btn(paramContext));
              if (paramString == null) {
                break label102;
              }
              paramString.d();
              break label102;
            }
            if (paramBoolean)
            {
              ans.a("decode bitmap");
              localObject1 = a((ParcelFileDescriptor)localObject2);
              ans.a();
              localHashMap.put(str, new btn(paramContext, (Bitmap)localObject1));
            }
            while (paramString != null)
            {
              paramString.d();
              break;
              localHashMap.put(str, new btn(paramContext, b((ParcelFileDescriptor)localObject2)));
            }
            if (parameiz == null) {
              break label743;
            }
          }
        }
        finally
        {
          parameiz = paramString;
        }
      }
      finally
      {
        for (;;)
        {
          label743:
          label745:
          parameiz = null;
        }
      }
    }
    parameiz.d();
    throw paramContext;
    ans.a();
    return hel.a(localHashMap);
  }
  
  /* Error */
  private static byte[] b(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    // Byte code:
    //   0: new 294	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokevirtual 298	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   8: invokespecial 301	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   11: astore 4
    //   13: sipush 16384
    //   16: newarray <illegal type>
    //   18: astore_3
    //   19: new 303	java/io/ByteArrayOutputStream
    //   22: dup
    //   23: invokespecial 304	java/io/ByteArrayOutputStream:<init>	()V
    //   26: astore_2
    //   27: aload_2
    //   28: astore_0
    //   29: aload 4
    //   31: aload_3
    //   32: invokevirtual 308	java/io/FileInputStream:read	([B)I
    //   35: istore_1
    //   36: iload_1
    //   37: iconst_m1
    //   38: if_icmpeq +44 -> 82
    //   41: aload_2
    //   42: astore_0
    //   43: aload_2
    //   44: aload_3
    //   45: iconst_0
    //   46: iload_1
    //   47: invokevirtual 312	java/io/ByteArrayOutputStream:write	([BII)V
    //   50: goto -23 -> 27
    //   53: astore_3
    //   54: aload_2
    //   55: astore_0
    //   56: getstatic 20	dxr:a	Ljava/lang/String;
    //   59: ldc_w 314
    //   62: aload_3
    //   63: invokestatic 319	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   66: pop
    //   67: aload 4
    //   69: invokevirtual 320	java/io/FileInputStream:close	()V
    //   72: aload_2
    //   73: ifnull +7 -> 80
    //   76: aload_2
    //   77: invokevirtual 321	java/io/ByteArrayOutputStream:close	()V
    //   80: aconst_null
    //   81: areturn
    //   82: aload_2
    //   83: astore_0
    //   84: aload_2
    //   85: invokevirtual 325	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   88: astore_3
    //   89: aload 4
    //   91: invokevirtual 320	java/io/FileInputStream:close	()V
    //   94: aload_2
    //   95: invokevirtual 321	java/io/ByteArrayOutputStream:close	()V
    //   98: aload_3
    //   99: areturn
    //   100: astore_0
    //   101: getstatic 20	dxr:a	Ljava/lang/String;
    //   104: ldc_w 327
    //   107: aload_0
    //   108: invokestatic 319	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   111: pop
    //   112: aload_3
    //   113: areturn
    //   114: astore_0
    //   115: getstatic 20	dxr:a	Ljava/lang/String;
    //   118: ldc_w 329
    //   121: aload_0
    //   122: invokestatic 319	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   125: pop
    //   126: goto -32 -> 94
    //   129: astore_0
    //   130: getstatic 20	dxr:a	Ljava/lang/String;
    //   133: ldc_w 329
    //   136: aload_0
    //   137: invokestatic 319	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   140: pop
    //   141: goto -69 -> 72
    //   144: astore_0
    //   145: getstatic 20	dxr:a	Ljava/lang/String;
    //   148: ldc_w 327
    //   151: aload_0
    //   152: invokestatic 319	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   155: pop
    //   156: aconst_null
    //   157: areturn
    //   158: astore_2
    //   159: aconst_null
    //   160: astore_0
    //   161: aload 4
    //   163: invokevirtual 320	java/io/FileInputStream:close	()V
    //   166: aload_0
    //   167: ifnull +7 -> 174
    //   170: aload_0
    //   171: invokevirtual 321	java/io/ByteArrayOutputStream:close	()V
    //   174: aload_2
    //   175: athrow
    //   176: astore_3
    //   177: getstatic 20	dxr:a	Ljava/lang/String;
    //   180: ldc_w 329
    //   183: aload_3
    //   184: invokestatic 319	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   187: pop
    //   188: goto -22 -> 166
    //   191: astore_0
    //   192: getstatic 20	dxr:a	Ljava/lang/String;
    //   195: ldc_w 327
    //   198: aload_0
    //   199: invokestatic 319	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   202: pop
    //   203: goto -29 -> 174
    //   206: astore_2
    //   207: goto -46 -> 161
    //   210: astore_3
    //   211: aconst_null
    //   212: astore_2
    //   213: goto -159 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	paramParcelFileDescriptor	ParcelFileDescriptor
    //   35	12	1	i	int
    //   26	69	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   158	17	2	localObject1	Object
    //   206	1	2	localObject2	Object
    //   212	1	2	localObject3	Object
    //   18	27	3	arrayOfByte1	byte[]
    //   53	10	3	localIOException1	IOException
    //   88	25	3	arrayOfByte2	byte[]
    //   176	8	3	localIOException2	IOException
    //   210	1	3	localIOException3	IOException
    //   11	151	4	localFileInputStream	java.io.FileInputStream
    // Exception table:
    //   from	to	target	type
    //   29	36	53	java/io/IOException
    //   43	50	53	java/io/IOException
    //   84	89	53	java/io/IOException
    //   94	98	100	java/io/IOException
    //   89	94	114	java/io/IOException
    //   67	72	129	java/io/IOException
    //   76	80	144	java/io/IOException
    //   13	27	158	finally
    //   161	166	176	java/io/IOException
    //   170	174	191	java/io/IOException
    //   29	36	206	finally
    //   43	50	206	finally
    //   56	67	206	finally
    //   84	89	206	finally
    //   13	27	210	java/io/IOException
  }
}

/* Location:
 * Qualified Name:     dxr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */