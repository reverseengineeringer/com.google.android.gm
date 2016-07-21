import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

public class js
  extends jl<Cursor>
{
  final jz f = new jz(this);
  public Uri g;
  public String[] h;
  String i;
  String[] j;
  String k;
  Cursor l;
  mb m;
  
  public js(Context paramContext)
  {
    super(paramContext);
  }
  
  private final void a(Cursor paramCursor)
  {
    if (t) {
      if (paramCursor != null) {
        paramCursor.close();
      }
    }
    Cursor localCursor;
    do
    {
      return;
      localCursor = l;
      l = paramCursor;
      if (r) {
        super.b(paramCursor);
      }
    } while ((localCursor == null) || (localCursor == paramCursor) || (localCursor.isClosed()));
    localCursor.close();
  }
  
  public final void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.a(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mUri=");
    paramPrintWriter.println(g);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mProjection=");
    paramPrintWriter.println(Arrays.toString(h));
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mSelection=");
    paramPrintWriter.println(i);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mSelectionArgs=");
    paramPrintWriter.println(Arrays.toString(j));
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mSortOrder=");
    paramPrintWriter.println(k);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mCursor=");
    paramPrintWriter.println(l);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mContentChanged=");
    paramPrintWriter.println(u);
  }
  
  /* Error */
  public final void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 118	jl:e	()V
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 120	js:m	Lmb;
    //   10: ifnull +19 -> 29
    //   13: aload_0
    //   14: getfield 120	js:m	Lmb;
    //   17: astore_1
    //   18: aload_1
    //   19: monitorenter
    //   20: aload_1
    //   21: getfield 124	mb:a	Z
    //   24: ifeq +8 -> 32
    //   27: aload_1
    //   28: monitorexit
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_1
    //   33: iconst_1
    //   34: putfield 124	mb:a	Z
    //   37: aload_1
    //   38: iconst_1
    //   39: putfield 127	mb:c	Z
    //   42: aload_1
    //   43: getfield 130	mb:b	Ljava/lang/Object;
    //   46: astore_2
    //   47: aload_1
    //   48: monitorexit
    //   49: aload_2
    //   50: ifnull +10 -> 60
    //   53: aload_2
    //   54: checkcast 132	android/os/CancellationSignal
    //   57: invokevirtual 135	android/os/CancellationSignal:cancel	()V
    //   60: aload_1
    //   61: monitorenter
    //   62: aload_1
    //   63: iconst_0
    //   64: putfield 127	mb:c	Z
    //   67: aload_1
    //   68: invokevirtual 140	java/lang/Object:notifyAll	()V
    //   71: aload_1
    //   72: monitorexit
    //   73: goto -44 -> 29
    //   76: astore_2
    //   77: aload_1
    //   78: monitorexit
    //   79: aload_2
    //   80: athrow
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    //   86: astore_2
    //   87: aload_1
    //   88: monitorexit
    //   89: aload_2
    //   90: athrow
    //   91: astore_2
    //   92: aload_1
    //   93: monitorenter
    //   94: aload_1
    //   95: iconst_0
    //   96: putfield 127	mb:c	Z
    //   99: aload_1
    //   100: invokevirtual 140	java/lang/Object:notifyAll	()V
    //   103: aload_1
    //   104: monitorexit
    //   105: aload_2
    //   106: athrow
    //   107: astore_2
    //   108: aload_1
    //   109: monitorexit
    //   110: aload_2
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	js
    //   17	61	1	localmb	mb
    //   81	28	1	localObject1	Object
    //   46	8	2	localObject2	Object
    //   76	4	2	localObject3	Object
    //   86	4	2	localObject4	Object
    //   91	15	2	localObject5	Object
    //   107	4	2	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   62	73	76	finally
    //   77	79	76	finally
    //   6	20	81	finally
    //   29	31	81	finally
    //   60	62	81	finally
    //   79	81	81	finally
    //   82	84	81	finally
    //   89	91	81	finally
    //   92	94	81	finally
    //   105	107	81	finally
    //   110	112	81	finally
    //   20	29	86	finally
    //   32	49	86	finally
    //   87	89	86	finally
    //   53	60	91	finally
    //   94	105	107	finally
    //   108	110	107	finally
  }
  
  /* Error */
  public Cursor f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 145	jl:b	Ljm;
    //   6: ifnull +22 -> 28
    //   9: iconst_1
    //   10: istore_1
    //   11: iload_1
    //   12: ifeq +21 -> 33
    //   15: new 147	mf
    //   18: dup
    //   19: invokespecial 149	mf:<init>	()V
    //   22: athrow
    //   23: astore_2
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_2
    //   27: athrow
    //   28: iconst_0
    //   29: istore_1
    //   30: goto -19 -> 11
    //   33: aload_0
    //   34: new 122	mb
    //   37: dup
    //   38: invokespecial 150	mb:<init>	()V
    //   41: putfield 120	js:m	Lmb;
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_0
    //   47: getfield 154	jy:q	Landroid/content/Context;
    //   50: invokevirtual 160	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   53: astore_2
    //   54: aload_0
    //   55: getfield 71	js:g	Landroid/net/Uri;
    //   58: astore_3
    //   59: aload_0
    //   60: getfield 78	js:h	[Ljava/lang/String;
    //   63: astore 4
    //   65: aload_0
    //   66: getfield 90	js:i	Ljava/lang/String;
    //   69: astore 5
    //   71: aload_0
    //   72: getfield 94	js:j	[Ljava/lang/String;
    //   75: astore 6
    //   77: aload_0
    //   78: getfield 98	js:k	Ljava/lang/String;
    //   81: astore 7
    //   83: aload_0
    //   84: getfield 120	js:m	Lmb;
    //   87: astore 8
    //   89: getstatic 165	jn:a	Ljo;
    //   92: aload_2
    //   93: aload_3
    //   94: aload 4
    //   96: aload 5
    //   98: aload 6
    //   100: aload 7
    //   102: aload 8
    //   104: invokeinterface 170 8 0
    //   109: astore_2
    //   110: aload_2
    //   111: ifnull +20 -> 131
    //   114: aload_2
    //   115: invokeinterface 174 1 0
    //   120: pop
    //   121: aload_2
    //   122: aload_0
    //   123: getfield 30	js:f	Ljz;
    //   126: invokeinterface 178 2 0
    //   131: aload_0
    //   132: monitorenter
    //   133: aload_0
    //   134: aconst_null
    //   135: putfield 120	js:m	Lmb;
    //   138: aload_0
    //   139: monitorexit
    //   140: aload_2
    //   141: areturn
    //   142: astore_3
    //   143: aload_2
    //   144: invokeinterface 45 1 0
    //   149: aload_3
    //   150: athrow
    //   151: astore_2
    //   152: aload_0
    //   153: monitorenter
    //   154: aload_0
    //   155: aconst_null
    //   156: putfield 120	js:m	Lmb;
    //   159: aload_0
    //   160: monitorexit
    //   161: aload_2
    //   162: athrow
    //   163: astore_2
    //   164: aload_0
    //   165: monitorexit
    //   166: aload_2
    //   167: athrow
    //   168: astore_2
    //   169: aload_0
    //   170: monitorexit
    //   171: aload_2
    //   172: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	js
    //   10	20	1	n	int
    //   23	4	2	localObject1	Object
    //   53	91	2	localObject2	Object
    //   151	11	2	localObject3	Object
    //   163	4	2	localObject4	Object
    //   168	4	2	localObject5	Object
    //   58	36	3	localUri	Uri
    //   142	8	3	localRuntimeException	RuntimeException
    //   63	32	4	arrayOfString1	String[]
    //   69	28	5	str1	String
    //   75	24	6	arrayOfString2	String[]
    //   81	20	7	str2	String
    //   87	16	8	localmb	mb
    // Exception table:
    //   from	to	target	type
    //   2	9	23	finally
    //   15	23	23	finally
    //   24	26	23	finally
    //   33	46	23	finally
    //   114	131	142	java/lang/RuntimeException
    //   46	110	151	finally
    //   114	131	151	finally
    //   143	151	151	finally
    //   133	140	163	finally
    //   164	166	163	finally
    //   154	161	168	finally
    //   169	171	168	finally
  }
  
  protected final void g()
  {
    if (l != null) {
      a(l);
    }
    if ((k()) || (l == null)) {
      a();
    }
  }
  
  protected final void h()
  {
    b();
  }
  
  protected final void i()
  {
    super.i();
    b();
    if ((l != null) && (!l.isClosed())) {
      l.close();
    }
    l = null;
  }
}

/* Location:
 * Qualified Name:     js
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */