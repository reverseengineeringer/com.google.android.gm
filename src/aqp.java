import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;

final class aqp
  extends ContentObserver
{
  private final Context a;
  
  public aqp(Handler paramHandler, Context paramContext)
  {
    super(paramHandler);
    a = paramContext;
  }
  
  /* Error */
  public final void onChange(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 13	aqp:a	Landroid/content/Context;
    //   4: invokevirtual 22	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   7: getstatic 27	com/android/emailcommon/provider/Account:a	Landroid/net/Uri;
    //   10: getstatic 33	bdv:B	[Ljava/lang/String;
    //   13: aconst_null
    //   14: aconst_null
    //   15: aconst_null
    //   16: invokevirtual 39	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   19: astore 5
    //   21: new 41	java/util/HashSet
    //   24: dup
    //   25: invokespecial 44	java/util/HashSet:<init>	()V
    //   28: astore 6
    //   30: new 41	java/util/HashSet
    //   33: dup
    //   34: invokespecial 44	java/util/HashSet:<init>	()V
    //   37: astore 4
    //   39: aload 5
    //   41: ifnonnull +17 -> 58
    //   44: getstatic 49	aql:a	Ljava/lang/String;
    //   47: ldc 51
    //   49: iconst_0
    //   50: anewarray 53	java/lang/Object
    //   53: invokestatic 59	cvm:f	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   56: pop
    //   57: return
    //   58: aload 5
    //   60: invokeinterface 65 1 0
    //   65: ifeq +37 -> 102
    //   68: aload 6
    //   70: aload 5
    //   72: iconst_0
    //   73: invokeinterface 69 2 0
    //   78: invokestatic 75	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   81: invokeinterface 81 2 0
    //   86: pop
    //   87: goto -29 -> 58
    //   90: astore 4
    //   92: aload 5
    //   94: invokeinterface 84 1 0
    //   99: aload 4
    //   101: athrow
    //   102: aload 5
    //   104: invokeinterface 84 1 0
    //   109: getstatic 88	aql:c	Laql;
    //   112: getfield 91	aql:f	Ljava/util/Map;
    //   115: invokeinterface 97 1 0
    //   120: invokeinterface 101 1 0
    //   125: astore 5
    //   127: aload 5
    //   129: invokeinterface 106 1 0
    //   134: ifeq +46 -> 180
    //   137: aload 5
    //   139: invokeinterface 110 1 0
    //   144: checkcast 71	java/lang/Long
    //   147: invokevirtual 114	java/lang/Long:longValue	()J
    //   150: lstore_2
    //   151: aload 6
    //   153: lload_2
    //   154: invokestatic 75	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   157: invokeinterface 117 2 0
    //   162: ifne -35 -> 127
    //   165: aload 4
    //   167: lload_2
    //   168: invokestatic 75	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   171: invokeinterface 81 2 0
    //   176: pop
    //   177: goto -50 -> 127
    //   180: aload 6
    //   182: invokeinterface 101 1 0
    //   187: astore 5
    //   189: aload 5
    //   191: invokeinterface 106 1 0
    //   196: ifeq +27 -> 223
    //   199: aload 5
    //   201: invokeinterface 110 1 0
    //   206: checkcast 71	java/lang/Long
    //   209: invokevirtual 114	java/lang/Long:longValue	()J
    //   212: lstore_2
    //   213: getstatic 88	aql:c	Laql;
    //   216: lload_2
    //   217: invokevirtual 120	aql:a	(J)V
    //   220: goto -31 -> 189
    //   223: aload 4
    //   225: invokeinterface 101 1 0
    //   230: astore 4
    //   232: aload 4
    //   234: invokeinterface 106 1 0
    //   239: ifeq +27 -> 266
    //   242: aload 4
    //   244: invokeinterface 110 1 0
    //   249: checkcast 71	java/lang/Long
    //   252: invokevirtual 114	java/lang/Long:longValue	()J
    //   255: lstore_2
    //   256: getstatic 88	aql:c	Laql;
    //   259: lload_2
    //   260: invokevirtual 123	aql:b	(J)V
    //   263: goto -31 -> 232
    //   266: aload_0
    //   267: getfield 13	aqp:a	Landroid/content/Context;
    //   270: astore 5
    //   272: getstatic 127	aql:k	Ljava/lang/Object;
    //   275: astore 4
    //   277: aload 4
    //   279: monitorenter
    //   280: getstatic 131	aql:h	Z
    //   283: ifeq +19 -> 302
    //   286: iconst_1
    //   287: putstatic 134	aql:i	Z
    //   290: aload 4
    //   292: monitorexit
    //   293: return
    //   294: astore 5
    //   296: aload 4
    //   298: monitorexit
    //   299: aload 5
    //   301: athrow
    //   302: invokestatic 136	aql:b	()V
    //   305: getstatic 139	aql:b	Landroid/os/Handler;
    //   308: getstatic 139	aql:b	Landroid/os/Handler;
    //   311: iconst_0
    //   312: aload 5
    //   314: invokestatic 145	android/os/Message:obtain	(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
    //   317: ldc2_w 146
    //   320: invokevirtual 153	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   323: pop
    //   324: iconst_1
    //   325: putstatic 131	aql:h	Z
    //   328: aload 5
    //   330: aconst_null
    //   331: aconst_null
    //   332: invokestatic 158	com/android/mail/utils/NotificationActionUtils:a	(Landroid/content/Context;Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;)V
    //   335: goto -45 -> 290
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	338	0	this	aqp
    //   0	338	1	paramBoolean	boolean
    //   150	110	2	l	long
    //   37	1	4	localHashSet1	java.util.HashSet
    //   90	134	4	localObject1	Object
    //   19	252	5	localObject3	Object
    //   294	35	5	localObject4	Object
    //   28	153	6	localHashSet2	java.util.HashSet
    // Exception table:
    //   from	to	target	type
    //   58	87	90	finally
    //   280	290	294	finally
    //   290	293	294	finally
    //   296	299	294	finally
    //   302	335	294	finally
  }
}

/* Location:
 * Qualified Name:     aqp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */