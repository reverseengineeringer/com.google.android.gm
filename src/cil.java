import android.os.AsyncTask;
import com.android.mail.providers.Folder;

final class cil
  extends AsyncTask<Void, Void, Folder>
{
  cil(cht paramcht) {}
  
  /* Error */
  private final Folder a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: getfield 11	cil:a	Lcht;
    //   6: getfield 22	cht:e	Lcom/android/mail/providers/Folder;
    //   9: ifnonnull +70 -> 79
    //   12: aload_0
    //   13: getfield 11	cil:a	Lcht;
    //   16: getfield 26	cht:h	Landroid/content/Context;
    //   19: invokevirtual 32	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   22: aload_0
    //   23: getfield 11	cil:a	Lcht;
    //   26: getfield 36	cht:c	Lcom/android/mail/providers/Account;
    //   29: getfield 42	com/android/mail/providers/Account:z	Lcom/android/mail/providers/Settings;
    //   32: getfield 48	com/android/mail/providers/Settings:i	Landroid/net/Uri;
    //   35: getstatic 53	chh:i	[Ljava/lang/String;
    //   38: aconst_null
    //   39: aconst_null
    //   40: aconst_null
    //   41: invokevirtual 59	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   44: astore_2
    //   45: aload_2
    //   46: ifnull +33 -> 79
    //   49: aload_2
    //   50: invokeinterface 65 1 0
    //   55: ifeq +18 -> 73
    //   58: aload_0
    //   59: getfield 11	cil:a	Lcht;
    //   62: new 67	com/android/mail/providers/Folder
    //   65: dup
    //   66: aload_2
    //   67: invokespecial 70	com/android/mail/providers/Folder:<init>	(Landroid/database/Cursor;)V
    //   70: putfield 22	cht:e	Lcom/android/mail/providers/Folder;
    //   73: aload_2
    //   74: invokeinterface 73 1 0
    //   79: aload_0
    //   80: getfield 11	cil:a	Lcht;
    //   83: getfield 76	cht:d	Lcom/android/mail/providers/Folder;
    //   86: ifnull +110 -> 196
    //   89: aload_0
    //   90: getfield 11	cil:a	Lcht;
    //   93: getfield 26	cht:h	Landroid/content/Context;
    //   96: invokevirtual 32	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   99: aload_0
    //   100: getfield 11	cil:a	Lcht;
    //   103: getfield 76	cht:d	Lcom/android/mail/providers/Folder;
    //   106: getfield 79	com/android/mail/providers/Folder:v	Landroid/net/Uri;
    //   109: getstatic 53	chh:i	[Ljava/lang/String;
    //   112: aconst_null
    //   113: aconst_null
    //   114: aconst_null
    //   115: invokevirtual 59	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   118: astore_2
    //   119: aload_2
    //   120: ifnull +14 -> 134
    //   123: aload_2
    //   124: astore_1
    //   125: aload_2
    //   126: invokeinterface 65 1 0
    //   131: ifne +36 -> 167
    //   134: aload_2
    //   135: astore_1
    //   136: aload_0
    //   137: getfield 11	cil:a	Lcht;
    //   140: getfield 22	cht:e	Lcom/android/mail/providers/Folder;
    //   143: astore_3
    //   144: aload_3
    //   145: astore_1
    //   146: aload_2
    //   147: ifnull +9 -> 156
    //   150: aload_2
    //   151: invokeinterface 73 1 0
    //   156: aload_1
    //   157: areturn
    //   158: astore_1
    //   159: aload_2
    //   160: invokeinterface 73 1 0
    //   165: aload_1
    //   166: athrow
    //   167: aload_2
    //   168: astore_1
    //   169: new 67	com/android/mail/providers/Folder
    //   172: dup
    //   173: aload_2
    //   174: invokespecial 70	com/android/mail/providers/Folder:<init>	(Landroid/database/Cursor;)V
    //   177: astore_3
    //   178: aload_3
    //   179: astore_1
    //   180: goto -34 -> 146
    //   183: astore_2
    //   184: aload_1
    //   185: ifnull +9 -> 194
    //   188: aload_1
    //   189: invokeinterface 73 1 0
    //   194: aload_2
    //   195: athrow
    //   196: aload_0
    //   197: getfield 11	cil:a	Lcht;
    //   200: getfield 22	cht:e	Lcom/android/mail/providers/Folder;
    //   203: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	this	cil
    //   1	156	1	localObject1	Object
    //   158	8	1	localObject2	Object
    //   168	21	1	localObject3	Object
    //   44	130	2	localCursor	android.database.Cursor
    //   183	12	2	localObject4	Object
    //   143	36	3	localFolder	Folder
    // Exception table:
    //   from	to	target	type
    //   49	73	158	finally
    //   89	119	183	finally
    //   125	134	183	finally
    //   136	144	183	finally
    //   169	178	183	finally
  }
}

/* Location:
 * Qualified Name:     cil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */