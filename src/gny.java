import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import com.google.android.libraries.social.licenses.License;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public final class gny
{
  /* Error */
  public static String a(Context paramContext, License paramLicense)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 14	com/google/android/libraries/social/licenses/License:d	Ljava/lang/String;
    //   4: invokevirtual 20	java/lang/String:isEmpty	()Z
    //   7: ifeq +35 -> 42
    //   10: aload_0
    //   11: invokevirtual 26	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   14: invokevirtual 30	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   17: astore_0
    //   18: aload_1
    //   19: aload_0
    //   20: aload_0
    //   21: ldc 32
    //   23: ldc 34
    //   25: aload_0
    //   26: getstatic 39	goa:a	I
    //   29: invokevirtual 45	android/content/res/Resources:getResourcePackageName	(I)Ljava/lang/String;
    //   32: invokevirtual 49	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   35: invokevirtual 53	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   38: invokestatic 56	gny:a	(Lcom/google/android/libraries/social/licenses/License;Ljava/io/InputStream;)Ljava/lang/String;
    //   41: areturn
    //   42: new 58	java/util/jar/JarFile
    //   45: dup
    //   46: aload_1
    //   47: getfield 14	com/google/android/libraries/social/licenses/License:d	Ljava/lang/String;
    //   50: invokespecial 62	java/util/jar/JarFile:<init>	(Ljava/lang/String;)V
    //   53: astore_2
    //   54: aload_2
    //   55: astore_0
    //   56: aload_1
    //   57: aload_2
    //   58: aload_2
    //   59: ldc 64
    //   61: invokevirtual 68	java/util/jar/JarFile:getJarEntry	(Ljava/lang/String;)Ljava/util/jar/JarEntry;
    //   64: invokevirtual 72	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   67: invokestatic 56	gny:a	(Lcom/google/android/libraries/social/licenses/License;Ljava/io/InputStream;)Ljava/lang/String;
    //   70: astore_3
    //   71: aload_2
    //   72: invokevirtual 76	java/util/jar/JarFile:close	()V
    //   75: aload_3
    //   76: areturn
    //   77: astore_0
    //   78: aload_3
    //   79: areturn
    //   80: astore_3
    //   81: aconst_null
    //   82: astore_2
    //   83: aload_2
    //   84: astore_0
    //   85: aload_1
    //   86: invokestatic 80	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   89: astore_1
    //   90: aload_2
    //   91: astore_0
    //   92: new 82	java/lang/RuntimeException
    //   95: dup
    //   96: new 84	java/lang/StringBuilder
    //   99: dup
    //   100: aload_1
    //   101: invokestatic 80	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   104: invokevirtual 88	java/lang/String:length	()I
    //   107: bipush 32
    //   109: iadd
    //   110: invokespecial 91	java/lang/StringBuilder:<init>	(I)V
    //   113: ldc 93
    //   115: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_1
    //   119: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: aload_3
    //   126: invokespecial 104	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   129: athrow
    //   130: astore_2
    //   131: aload_0
    //   132: astore_1
    //   133: aload_2
    //   134: astore_0
    //   135: aload_1
    //   136: ifnull +7 -> 143
    //   139: aload_1
    //   140: invokevirtual 76	java/util/jar/JarFile:close	()V
    //   143: aload_0
    //   144: athrow
    //   145: astore_1
    //   146: goto -3 -> 143
    //   149: astore_0
    //   150: aconst_null
    //   151: astore_1
    //   152: goto -17 -> 135
    //   155: astore_3
    //   156: goto -73 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	paramContext	Context
    //   0	159	1	paramLicense	License
    //   53	38	2	localJarFile	java.util.jar.JarFile
    //   130	4	2	localObject	Object
    //   70	9	3	str	String
    //   80	46	3	localIOException1	java.io.IOException
    //   155	1	3	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   71	75	77	java/io/IOException
    //   42	54	80	java/io/IOException
    //   56	71	130	finally
    //   85	90	130	finally
    //   92	130	130	finally
    //   139	143	145	java/io/IOException
    //   42	54	149	finally
    //   56	71	155	java/io/IOException
  }
  
  /* Error */
  private static String a(License paramLicense, java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 110	com/google/android/libraries/social/licenses/License:c	I
    //   4: newarray <illegal type>
    //   6: astore 4
    //   8: aload_1
    //   9: aload_0
    //   10: getfield 114	com/google/android/libraries/social/licenses/License:b	J
    //   13: invokevirtual 120	java/io/InputStream:skip	(J)J
    //   16: pop2
    //   17: iconst_0
    //   18: istore_2
    //   19: iload_2
    //   20: aload 4
    //   22: arraylength
    //   23: if_icmpge +27 -> 50
    //   26: aload_1
    //   27: aload 4
    //   29: iload_2
    //   30: aload 4
    //   32: arraylength
    //   33: iload_2
    //   34: isub
    //   35: invokevirtual 124	java/io/InputStream:read	([BII)I
    //   38: istore_3
    //   39: iload_3
    //   40: ifle +10 -> 50
    //   43: iload_2
    //   44: iload_3
    //   45: iadd
    //   46: istore_2
    //   47: goto -28 -> 19
    //   50: aload_1
    //   51: invokevirtual 125	java/io/InputStream:close	()V
    //   54: new 16	java/lang/String
    //   57: dup
    //   58: aload 4
    //   60: ldc 127
    //   62: invokespecial 130	java/lang/String:<init>	([BLjava/lang/String;)V
    //   65: astore_0
    //   66: aload_0
    //   67: areturn
    //   68: astore_1
    //   69: aload_0
    //   70: invokestatic 80	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   73: astore_0
    //   74: new 82	java/lang/RuntimeException
    //   77: dup
    //   78: new 84	java/lang/StringBuilder
    //   81: dup
    //   82: aload_0
    //   83: invokestatic 80	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   86: invokevirtual 88	java/lang/String:length	()I
    //   89: bipush 32
    //   91: iadd
    //   92: invokespecial 91	java/lang/StringBuilder:<init>	(I)V
    //   95: ldc 93
    //   97: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload_0
    //   101: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: aload_1
    //   108: invokespecial 104	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   111: athrow
    //   112: astore_0
    //   113: new 82	java/lang/RuntimeException
    //   116: dup
    //   117: ldc -124
    //   119: aload_0
    //   120: invokespecial 104	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	paramLicense	License
    //   0	124	1	paramInputStream	java.io.InputStream
    //   18	29	2	i	int
    //   38	8	3	j	int
    //   6	53	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   8	17	68	java/io/IOException
    //   19	39	68	java/io/IOException
    //   50	54	68	java/io/IOException
    //   54	66	112	java/io/UnsupportedEncodingException
  }
  
  public static ArrayList<License> a(Context paramContext)
  {
    Object localObject = paramContext.getApplicationContext();
    paramContext = ((Context)localObject).getPackageName();
    try
    {
      localObject = ((Context)localObject).getPackageManager().getServiceInfo(new ComponentName((Context)localObject, "com.google.android.libraries.social.licenses.MetadataHolder"), 640);
      return a((ServiceInfo)localObject, "");
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      throw new RuntimeException(String.format("Could not find application info for package: %s", new Object[] { paramContext }), localNameNotFoundException);
    }
  }
  
  private static ArrayList<License> a(ServiceInfo paramServiceInfo, String paramString)
  {
    Object localObject = Bundle.EMPTY;
    if (paramServiceInfo != null) {
      if (metaData != null) {
        paramServiceInfo = metaData;
      }
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramServiceInfo.keySet().iterator();
      label41:
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (str.startsWith("com.google.android.libraries.social.licenses.LICENSE."))
        {
          String[] arrayOfString = paramServiceInfo.getString(str).split(":");
          boolean bool;
          if (arrayOfString.length == 2)
          {
            bool = true;
            label95:
            localObject = String.valueOf(str);
            if (((String)localObject).length() == 0) {
              break label181;
            }
          }
          label181:
          for (localObject = "Invalid license meta-data value for element: ".concat((String)localObject);; localObject = new String("Invalid license meta-data value for element: "))
          {
            gol.a(bool, localObject);
            long l = Long.parseLong(arrayOfString[0]);
            int i = Integer.parseInt(arrayOfString[1]);
            localArrayList.add(new License(str.substring(53), l, i, paramString));
            break label41;
            paramServiceInfo = Bundle.EMPTY;
            break;
            bool = false;
            break label95;
          }
        }
      }
      Collections.sort(localArrayList);
      return localArrayList;
      paramServiceInfo = (ServiceInfo)localObject;
    }
  }
}

/* Location:
 * Qualified Name:     gny
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */