import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class afo
  extends DataSetObservable
{
  static final String a = afo.class.getSimpleName();
  private static final Object g = new Object();
  private static final Map<String, afo> h = new HashMap();
  final Object b = new Object();
  final List<afp> c = new ArrayList();
  final Context d;
  final String e;
  boolean f = true;
  private final List<afs> i = new ArrayList();
  private Intent j;
  private afq k = new afr(this);
  private int l = 50;
  private boolean m = false;
  private boolean n = true;
  private boolean o = false;
  private aft p;
  
  private afo(Context paramContext, String paramString)
  {
    d = paramContext.getApplicationContext();
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.endsWith(".xml")))
    {
      e = (paramString + ".xml");
      return;
    }
    e = paramString;
  }
  
  public static afo a(Context paramContext, String paramString)
  {
    synchronized (g)
    {
      afo localafo2 = (afo)h.get(paramString);
      afo localafo1 = localafo2;
      if (localafo2 == null)
      {
        localafo1 = new afo(paramContext, paramString);
        h.put(paramString, localafo1);
      }
      return localafo1;
    }
  }
  
  private final boolean e()
  {
    if ((k != null) && (j != null) && (!c.isEmpty()) && (!i.isEmpty()))
    {
      k.a(c, Collections.unmodifiableList(i));
      return true;
    }
    return false;
  }
  
  private final void f()
  {
    int i2 = i.size() - l;
    if (i2 <= 0) {}
    for (;;)
    {
      return;
      n = true;
      int i1 = 0;
      while (i1 < i2)
      {
        i.remove(0);
        i1 += 1;
      }
    }
  }
  
  /* Error */
  private final void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 92	afo:d	Landroid/content/Context;
    //   4: aload_0
    //   5: getfield 118	afo:e	Ljava/lang/String;
    //   8: invokevirtual 167	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   11: astore_2
    //   12: invokestatic 173	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   15: astore_3
    //   16: aload_3
    //   17: aload_2
    //   18: ldc -81
    //   20: invokeinterface 181 3 0
    //   25: iconst_0
    //   26: istore_1
    //   27: iload_1
    //   28: iconst_1
    //   29: if_icmpeq +18 -> 47
    //   32: iload_1
    //   33: iconst_2
    //   34: if_icmpeq +13 -> 47
    //   37: aload_3
    //   38: invokeinterface 184 1 0
    //   43: istore_1
    //   44: goto -17 -> 27
    //   47: ldc -70
    //   49: aload_3
    //   50: invokeinterface 189 1 0
    //   55: invokevirtual 193	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   58: ifne +50 -> 108
    //   61: new 161	org/xmlpull/v1/XmlPullParserException
    //   64: dup
    //   65: ldc -61
    //   67: invokespecial 198	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   70: athrow
    //   71: astore_3
    //   72: getstatic 43	afo:a	Ljava/lang/String;
    //   75: new 108	java/lang/StringBuilder
    //   78: dup
    //   79: ldc -56
    //   81: invokespecial 201	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   84: aload_0
    //   85: getfield 118	afo:e	Ljava/lang/String;
    //   88: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: aload_3
    //   95: invokestatic 206	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   98: pop
    //   99: aload_2
    //   100: ifnull +7 -> 107
    //   103: aload_2
    //   104: invokevirtual 211	java/io/FileInputStream:close	()V
    //   107: return
    //   108: aload_0
    //   109: getfield 67	afo:i	Ljava/util/List;
    //   112: astore 4
    //   114: aload 4
    //   116: invokeinterface 214 1 0
    //   121: aload_3
    //   122: invokeinterface 184 1 0
    //   127: istore_1
    //   128: iload_1
    //   129: iconst_1
    //   130: if_icmpeq +138 -> 268
    //   133: iload_1
    //   134: iconst_3
    //   135: if_icmpeq -14 -> 121
    //   138: iload_1
    //   139: iconst_4
    //   140: if_icmpeq -19 -> 121
    //   143: ldc -40
    //   145: aload_3
    //   146: invokeinterface 189 1 0
    //   151: invokevirtual 193	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   154: ifne +52 -> 206
    //   157: new 161	org/xmlpull/v1/XmlPullParserException
    //   160: dup
    //   161: ldc -38
    //   163: invokespecial 198	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   166: athrow
    //   167: astore_3
    //   168: getstatic 43	afo:a	Ljava/lang/String;
    //   171: new 108	java/lang/StringBuilder
    //   174: dup
    //   175: ldc -56
    //   177: invokespecial 201	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   180: aload_0
    //   181: getfield 118	afo:e	Ljava/lang/String;
    //   184: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: aload_3
    //   191: invokestatic 206	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   194: pop
    //   195: aload_2
    //   196: ifnull -89 -> 107
    //   199: aload_2
    //   200: invokevirtual 211	java/io/FileInputStream:close	()V
    //   203: return
    //   204: astore_2
    //   205: return
    //   206: aload 4
    //   208: new 220	afs
    //   211: dup
    //   212: aload_3
    //   213: aconst_null
    //   214: ldc -34
    //   216: invokeinterface 226 3 0
    //   221: aload_3
    //   222: aconst_null
    //   223: ldc -28
    //   225: invokeinterface 226 3 0
    //   230: invokestatic 234	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   233: aload_3
    //   234: aconst_null
    //   235: ldc -20
    //   237: invokeinterface 226 3 0
    //   242: invokestatic 242	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   245: invokespecial 245	afs:<init>	(Ljava/lang/String;JF)V
    //   248: invokeinterface 248 2 0
    //   253: pop
    //   254: goto -133 -> 121
    //   257: astore_3
    //   258: aload_2
    //   259: ifnull +7 -> 266
    //   262: aload_2
    //   263: invokevirtual 211	java/io/FileInputStream:close	()V
    //   266: aload_3
    //   267: athrow
    //   268: aload_2
    //   269: ifnull -162 -> 107
    //   272: aload_2
    //   273: invokevirtual 211	java/io/FileInputStream:close	()V
    //   276: return
    //   277: astore_2
    //   278: return
    //   279: astore_2
    //   280: return
    //   281: astore_2
    //   282: goto -16 -> 266
    //   285: astore_2
    //   286: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	this	afo
    //   26	115	1	i1	int
    //   11	189	2	localFileInputStream	java.io.FileInputStream
    //   204	69	2	localIOException1	java.io.IOException
    //   277	1	2	localIOException2	java.io.IOException
    //   279	1	2	localIOException3	java.io.IOException
    //   281	1	2	localIOException4	java.io.IOException
    //   285	1	2	localFileNotFoundException	java.io.FileNotFoundException
    //   15	35	3	localXmlPullParser	org.xmlpull.v1.XmlPullParser
    //   71	75	3	localXmlPullParserException	org.xmlpull.v1.XmlPullParserException
    //   167	67	3	localIOException5	java.io.IOException
    //   257	10	3	localObject	Object
    //   112	95	4	localList	List
    // Exception table:
    //   from	to	target	type
    //   12	25	71	org/xmlpull/v1/XmlPullParserException
    //   37	44	71	org/xmlpull/v1/XmlPullParserException
    //   47	71	71	org/xmlpull/v1/XmlPullParserException
    //   108	121	71	org/xmlpull/v1/XmlPullParserException
    //   121	128	71	org/xmlpull/v1/XmlPullParserException
    //   143	167	71	org/xmlpull/v1/XmlPullParserException
    //   206	254	71	org/xmlpull/v1/XmlPullParserException
    //   12	25	167	java/io/IOException
    //   37	44	167	java/io/IOException
    //   47	71	167	java/io/IOException
    //   108	121	167	java/io/IOException
    //   121	128	167	java/io/IOException
    //   143	167	167	java/io/IOException
    //   206	254	167	java/io/IOException
    //   199	203	204	java/io/IOException
    //   12	25	257	finally
    //   37	44	257	finally
    //   47	71	257	finally
    //   72	99	257	finally
    //   108	121	257	finally
    //   121	128	257	finally
    //   143	167	257	finally
    //   168	195	257	finally
    //   206	254	257	finally
    //   272	276	277	java/io/IOException
    //   103	107	279	java/io/IOException
    //   262	266	281	java/io/IOException
    //   0	12	285	java/io/FileNotFoundException
  }
  
  public final int a()
  {
    synchronized (b)
    {
      d();
      int i1 = c.size();
      return i1;
    }
  }
  
  public final int a(ResolveInfo paramResolveInfo)
  {
    for (;;)
    {
      int i1;
      synchronized (b)
      {
        d();
        List localList = c;
        int i2 = localList.size();
        i1 = 0;
        if (i1 < i2)
        {
          if (geta == paramResolveInfo) {
            return i1;
          }
        }
        else {
          return -1;
        }
      }
      i1 += 1;
    }
  }
  
  public final ResolveInfo a(int paramInt)
  {
    synchronized (b)
    {
      d();
      ResolveInfo localResolveInfo = c.get(paramInt)).a;
      return localResolveInfo;
    }
  }
  
  final boolean a(afs paramafs)
  {
    boolean bool = i.add(paramafs);
    Object[] arrayOfObject;
    if (bool)
    {
      n = true;
      f();
      if (!m) {
        throw new IllegalStateException("No preceding call to #readHistoricalData");
      }
      if (n)
      {
        n = false;
        if (!TextUtils.isEmpty(e))
        {
          paramafs = new afu(this);
          arrayOfObject = new Object[2];
          arrayOfObject[0] = new ArrayList(i);
          arrayOfObject[1] = e;
          if (Build.VERSION.SDK_INT < 11) {
            break label127;
          }
          paramafs.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, arrayOfObject);
        }
      }
    }
    for (;;)
    {
      e();
      notifyChanged();
      return bool;
      label127:
      paramafs.execute(arrayOfObject);
    }
  }
  
  public final Intent b(int paramInt)
  {
    synchronized (b)
    {
      if (j == null) {
        return null;
      }
      d();
      Object localObject2 = (afp)c.get(paramInt);
      localObject2 = new ComponentName(a.activityInfo.packageName, a.activityInfo.name);
      Intent localIntent = new Intent(j);
      localIntent.setComponent((ComponentName)localObject2);
      if (p != null)
      {
        new Intent(localIntent);
        if (p.a()) {
          return null;
        }
      }
      a(new afs((ComponentName)localObject2, System.currentTimeMillis(), 1.0F));
      return localIntent;
    }
  }
  
  public final ResolveInfo b()
  {
    synchronized (b)
    {
      d();
      if (!c.isEmpty())
      {
        ResolveInfo localResolveInfo = c.get(0)).a;
        return localResolveInfo;
      }
      return null;
    }
  }
  
  public final int c()
  {
    synchronized (b)
    {
      d();
      int i1 = i.size();
      return i1;
    }
  }
  
  final void d()
  {
    int i2 = 1;
    int i1;
    if ((o) && (j != null))
    {
      o = false;
      c.clear();
      List localList = d.getPackageManager().queryIntentActivities(j, 0);
      int i3 = localList.size();
      i1 = 0;
      while (i1 < i3)
      {
        ResolveInfo localResolveInfo = (ResolveInfo)localList.get(i1);
        c.add(new afp(this, localResolveInfo));
        i1 += 1;
      }
      i1 = 1;
      if ((!f) || (!n) || (TextUtils.isEmpty(e))) {
        break label167;
      }
      f = false;
      m = true;
      g();
    }
    for (;;)
    {
      f();
      if ((i1 | i2) != 0)
      {
        e();
        notifyChanged();
      }
      return;
      i1 = 0;
      break;
      label167:
      i2 = 0;
    }
  }
}

/* Location:
 * Qualified Name:     afo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */