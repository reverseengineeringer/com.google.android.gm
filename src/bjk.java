import android.accounts.Account;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.text.util.Rfc822Token;
import android.text.util.Rfc822Tokenizer;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class bjk
  extends CursorAdapter
{
  private static final Map<String, String> g = new HashMap();
  private final long a;
  private int b;
  private bjl c;
  private final Long d;
  private bim e;
  private final StateListDrawable f;
  
  public bjk(Context paramContext, long paramLong1, Long paramLong, String paramString, long paramLong2, int paramInt, bjl parambjl, bim parambim, StateListDrawable paramStateListDrawable, bih parambih) {}
  
  private static Cursor a(Cursor paramCursor, String paramString1, String paramString2)
  {
    MatrixCursor localMatrixCursor = new MatrixCursor(paramCursor.getColumnNames(), paramCursor.getCount());
    HashSet localHashSet = new HashSet();
    paramCursor.moveToPosition(-1);
    String str2;
    String str1;
    while (paramCursor.moveToNext()) {
      if ("vnd.android.cursor.item/name".equals(paramCursor.getString(9)))
      {
        str2 = paramCursor.getString(0);
        str1 = paramCursor.getString(6);
      }
    }
    for (int i = paramCursor.getInt(7);; i = 0)
    {
      paramCursor.moveToPosition(-1);
      while (paramCursor.moveToNext()) {
        if ((paramString1 == null) || (paramString1.equals(paramCursor.getString(9))))
        {
          Object localObject1 = paramCursor.getString(1);
          if (!localHashSet.contains(localObject1))
          {
            localHashSet.add(localObject1);
            localObject1 = new Object[10];
            localObject1[0] = paramCursor.getString(0);
            localObject1[1] = paramCursor.getString(1);
            localObject1[2] = Integer.valueOf(paramCursor.getInt(2));
            localObject1[3] = paramCursor.getString(3);
            localObject1[4] = Long.valueOf(paramCursor.getLong(4));
            localObject1[5] = Long.valueOf(paramCursor.getLong(5));
            localObject1[6] = paramCursor.getString(6);
            localObject1[7] = Integer.valueOf(paramCursor.getInt(7));
            localObject1[8] = paramCursor.getString(8);
            localObject1[9] = paramCursor.getString(9);
            if (localObject1[0] == null) {
              localObject1[0] = str2;
            }
            if (localObject1[6] == null) {
              localObject1[6] = str1;
            }
            if (((Integer)localObject1[7]).intValue() == 0) {
              localObject1[7] = Integer.valueOf(i);
            }
            if (localObject1[8] == null) {
              localObject1[8] = paramString2;
            }
            String str3 = (String)localObject1[6];
            if (str3 != null)
            {
              if (!g.containsKey(str3)) {
                break label409;
              }
              localObject1[6] = g.get(str3);
            }
            for (;;)
            {
              localMatrixCursor.addRow((Object[])localObject1);
              break;
              label409:
              if (str3.indexOf('?') != str3.lastIndexOf('?'))
              {
                Object localObject2 = str3.split("\\?");
                StringBuilder localStringBuilder = new StringBuilder();
                int j = 0;
                if (j < localObject2.length)
                {
                  if (j == 1) {
                    localStringBuilder.append("?");
                  }
                  for (;;)
                  {
                    localStringBuilder.append(localObject2[j]);
                    j += 1;
                    break;
                    if (j > 1) {
                      localStringBuilder.append("&");
                    }
                  }
                }
                localObject2 = localStringBuilder.toString();
                g.put(str3, localObject2);
                localObject1[6] = localObject2;
              }
            }
          }
        }
      }
      return localMatrixCursor;
      str2 = null;
      str1 = null;
    }
  }
  
  static bkn a(bkn parambkn1, bkn parambkn2)
  {
    bkn localbkn;
    if (parambkn2 == null) {
      localbkn = parambkn1;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return localbkn;
                localbkn = parambkn2;
              } while (parambkn1 == null);
              if ((!TextUtils.isEmpty(c)) && (TextUtils.isEmpty(c))) {
                return parambkn1;
              }
              if (TextUtils.isEmpty(c)) {
                break;
              }
              localbkn = parambkn2;
            } while (TextUtils.isEmpty(c));
            if ((!TextUtils.equals(c, d)) && (TextUtils.equals(c, d))) {
              return parambkn1;
            }
            if (TextUtils.equals(c, d)) {
              break;
            }
            localbkn = parambkn2;
          } while (TextUtils.equals(c, d));
          if (((j != null) || (parambkn1.a() != null)) && (j == null) && (parambkn2.a() == null)) {
            return parambkn1;
          }
          if (j != null) {
            break;
          }
          localbkn = parambkn2;
        } while (parambkn2.a() == null);
        localbkn = parambkn2;
      } while (j != null);
      localbkn = parambkn2;
    } while (parambkn1.a() != null);
    return parambkn2;
  }
  
  private static HashMap<String, bkn> a(Cursor paramCursor, Long paramLong)
  {
    HashMap localHashMap = new HashMap();
    if ((paramCursor != null) && (paramCursor.moveToFirst())) {
      do
      {
        String str1 = paramCursor.getString(1);
        Object localObject = bkn.a(paramCursor.getString(0), paramCursor.getInt(7), paramCursor.getString(1), paramCursor.getInt(2), paramCursor.getString(3), paramCursor.getLong(4), paramLong, paramCursor.getLong(5), paramCursor.getString(6), paramCursor.getString(8));
        localHashMap.put(str1, a((bkn)localHashMap.get(str1), (bkn)localObject));
        if (Log.isLoggable("RecipAlternates", 3))
        {
          localObject = String.valueOf(paramCursor.getString(0));
          long l = paramCursor.getLong(4);
          String str2 = String.valueOf(paramCursor.getString(1));
          new StringBuilder(String.valueOf(str1).length() + 103 + String.valueOf(localObject).length() + String.valueOf(str2).length()).append("Received reverse look up information for ").append(str1).append(" RESULTS:  NAME : ").append((String)localObject).append(" CONTACT ID : ").append(l).append(" ADDRESS :").append(str2);
        }
      } while (paramCursor.moveToNext());
    }
    return localHashMap;
  }
  
  public static void a(Context paramContext, bhx parambhx, ArrayList<String> paramArrayList, Account paramAccount, bjm parambjm, bih parambih)
  {
    bja localbja = bix.b;
    int j = Math.min(50, paramArrayList.size());
    HashSet localHashSet = new HashSet();
    Object localObject = new StringBuilder();
    int i = 0;
    if (i < j)
    {
      parambhx = Rfc822Tokenizer.tokenize(((String)paramArrayList.get(i)).toLowerCase());
      if (parambhx.length > 0) {}
      for (parambhx = parambhx[0].getAddress();; parambhx = (String)paramArrayList.get(i))
      {
        localHashSet.add(parambhx);
        ((StringBuilder)localObject).append("?");
        if (i < j - 1) {
          ((StringBuilder)localObject).append(",");
        }
        i += 1;
        break;
      }
    }
    if (Log.isLoggable("RecipAlternates", 3))
    {
      parambhx = String.valueOf(localHashSet.toString());
      if (parambhx.length() != 0) {
        "Doing reverse lookup for ".concat(parambhx);
      }
    }
    else
    {
      parambhx = new String[localHashSet.size()];
      localHashSet.toArray(parambhx);
    }
    for (;;)
    {
      try
      {
        if (big.a(paramContext, parambih))
        {
          paramArrayList = paramContext.getContentResolver();
          Uri localUri = c;
          String[] arrayOfString = a;
          String str = String.valueOf(a[1]);
          localObject = String.valueOf(((StringBuilder)localObject).toString());
          parambhx = paramArrayList.query(localUri, arrayOfString, String.valueOf(str).length() + 6 + String.valueOf(localObject).length() + str + " IN (" + (String)localObject + ")", parambhx, null);
        }
      }
      finally
      {
        parambhx = null;
        if (parambhx != null) {
          parambhx.close();
        }
      }
      try
      {
        paramArrayList = a(parambhx, null);
        parambjm.a(paramArrayList);
        if (parambhx != null) {
          parambhx.close();
        }
        parambhx = new HashSet();
        a(paramContext, paramArrayList, localHashSet, paramAccount, parambhx, localbja, parambjm, parambih);
        parambjm.a(parambhx);
        return;
      }
      finally {}
      new String("Doing reverse lookup for ");
      break;
    }
  }
  
  /* Error */
  private static void a(Context paramContext, Map<String, bkn> paramMap, Set<String> paramSet1, Account paramAccount, Set<String> paramSet2, bja parambja, bjm parambjm, bih parambih)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 366 1 0
    //   6: aload_2
    //   7: invokeinterface 369 1 0
    //   12: if_icmpge +111 -> 123
    //   15: new 159	java/util/HashSet
    //   18: dup
    //   19: invokespecial 160	java/util/HashSet:<init>	()V
    //   22: astore 13
    //   24: aload_2
    //   25: invokeinterface 373 1 0
    //   30: astore_2
    //   31: aload_2
    //   32: invokeinterface 378 1 0
    //   37: ifeq +36 -> 73
    //   40: aload_2
    //   41: invokeinterface 382 1 0
    //   46: checkcast 69	java/lang/String
    //   49: astore 12
    //   51: aload_1
    //   52: aload 12
    //   54: invokeinterface 212 2 0
    //   59: ifne -28 -> 31
    //   62: aload 13
    //   64: aload 12
    //   66: invokevirtual 188	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   69: pop
    //   70: goto -39 -> 31
    //   73: aload 4
    //   75: aload 13
    //   77: invokeinterface 386 2 0
    //   82: pop
    //   83: aload_0
    //   84: aload 7
    //   86: invokestatic 61	big:a	(Landroid/content/Context;Lbih;)Z
    //   89: ifeq +397 -> 486
    //   92: aload_0
    //   93: invokevirtual 67	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   96: getstatic 390	bic:a	Landroid/net/Uri;
    //   99: getstatic 392	bic:b	[Ljava/lang/String;
    //   102: aconst_null
    //   103: aconst_null
    //   104: aconst_null
    //   105: invokevirtual 79	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   108: astore_1
    //   109: aload_1
    //   110: ifnonnull +14 -> 124
    //   113: aload_1
    //   114: ifnull +9 -> 123
    //   117: aload_1
    //   118: invokeinterface 87 1 0
    //   123: return
    //   124: aload_0
    //   125: aload_1
    //   126: aload_3
    //   127: invokestatic 397	bhx:a	(Landroid/content/Context;Landroid/database/Cursor;Landroid/accounts/Account;)Ljava/util/List;
    //   130: astore 12
    //   132: aload_1
    //   133: ifnull +9 -> 142
    //   136: aload_1
    //   137: invokeinterface 87 1 0
    //   142: aconst_null
    //   143: astore_2
    //   144: aload 13
    //   146: invokevirtual 398	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   149: astore 13
    //   151: aload 13
    //   153: invokeinterface 378 1 0
    //   158: ifeq -35 -> 123
    //   161: aload 13
    //   163: invokeinterface 382 1 0
    //   168: checkcast 69	java/lang/String
    //   171: astore 14
    //   173: iconst_0
    //   174: istore 8
    //   176: aload_2
    //   177: astore_1
    //   178: iload 8
    //   180: aload 12
    //   182: invokeinterface 401 1 0
    //   187: if_icmpge +291 -> 478
    //   190: aload 12
    //   192: iload 8
    //   194: invokeinterface 402 2 0
    //   199: checkcast 404	bid
    //   202: getfield 405	bid:a	J
    //   205: lstore 9
    //   207: lload 9
    //   209: invokestatic 204	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   212: astore_2
    //   213: aload_0
    //   214: aload 7
    //   216: invokestatic 61	big:a	(Landroid/content/Context;Lbih;)Z
    //   219: istore 11
    //   221: iload 11
    //   223: ifne +100 -> 323
    //   226: aconst_null
    //   227: astore_1
    //   228: aload_1
    //   229: ifnull +220 -> 449
    //   232: aload_1
    //   233: invokeinterface 154 1 0
    //   238: ifeq +211 -> 449
    //   241: aload_1
    //   242: lload 9
    //   244: invokestatic 204	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   247: invokestatic 350	bjk:a	(Landroid/database/Cursor;Ljava/lang/Long;)Ljava/util/HashMap;
    //   250: astore_2
    //   251: aload_2
    //   252: invokeinterface 409 1 0
    //   257: invokeinterface 373 1 0
    //   262: astore 14
    //   264: aload 14
    //   266: invokeinterface 378 1 0
    //   271: ifeq +153 -> 424
    //   274: aload 4
    //   276: aload 14
    //   278: invokeinterface 382 1 0
    //   283: checkcast 69	java/lang/String
    //   286: invokeinterface 412 2 0
    //   291: pop
    //   292: goto -28 -> 264
    //   295: astore_0
    //   296: aload_1
    //   297: ifnull +9 -> 306
    //   300: aload_1
    //   301: invokeinterface 87 1 0
    //   306: aload_0
    //   307: athrow
    //   308: astore_0
    //   309: aconst_null
    //   310: astore_1
    //   311: aload_1
    //   312: ifnull +9 -> 321
    //   315: aload_1
    //   316: invokeinterface 87 1 0
    //   321: aload_0
    //   322: athrow
    //   323: aload 5
    //   325: getfield 414	bja:b	Landroid/net/Uri;
    //   328: invokevirtual 114	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   331: aload 14
    //   333: invokeinterface 417 1 0
    //   338: invokevirtual 122	android/net/Uri$Builder:appendPath	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   341: ldc_w 419
    //   344: ldc_w 421
    //   347: invokevirtual 131	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   350: astore 15
    //   352: aload_2
    //   353: ifnull +15 -> 368
    //   356: aload 15
    //   358: ldc 124
    //   360: aload_2
    //   361: invokestatic 127	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   364: invokevirtual 131	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   367: pop
    //   368: aload_3
    //   369: ifnull +29 -> 398
    //   372: aload 15
    //   374: ldc_w 423
    //   377: aload_3
    //   378: getfield 428	android/accounts/Account:name	Ljava/lang/String;
    //   381: invokevirtual 131	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   384: pop
    //   385: aload 15
    //   387: ldc_w 430
    //   390: aload_3
    //   391: getfield 433	android/accounts/Account:type	Ljava/lang/String;
    //   394: invokevirtual 131	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   397: pop
    //   398: aload_0
    //   399: invokevirtual 67	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   402: aload 15
    //   404: invokevirtual 135	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   407: aload 5
    //   409: getfield 40	bja:a	[Ljava/lang/String;
    //   412: aconst_null
    //   413: aconst_null
    //   414: aconst_null
    //   415: invokevirtual 79	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   418: astore_2
    //   419: aload_2
    //   420: astore_1
    //   421: goto -193 -> 228
    //   424: aload 6
    //   426: aload_2
    //   427: invokeinterface 355 2 0
    //   432: aload_1
    //   433: astore_2
    //   434: aload_1
    //   435: ifnull -284 -> 151
    //   438: aload_1
    //   439: invokeinterface 87 1 0
    //   444: aconst_null
    //   445: astore_2
    //   446: goto -295 -> 151
    //   449: aload_1
    //   450: ifnull +33 -> 483
    //   453: aload_1
    //   454: invokeinterface 87 1 0
    //   459: aconst_null
    //   460: astore_1
    //   461: iload 8
    //   463: iconst_1
    //   464: iadd
    //   465: istore 8
    //   467: goto -289 -> 178
    //   470: astore_0
    //   471: goto -175 -> 296
    //   474: astore_0
    //   475: goto -164 -> 311
    //   478: aload_1
    //   479: astore_2
    //   480: goto -329 -> 151
    //   483: goto -22 -> 461
    //   486: aconst_null
    //   487: astore_1
    //   488: goto -379 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	491	0	paramContext	Context
    //   0	491	1	paramMap	Map<String, bkn>
    //   0	491	2	paramSet1	Set<String>
    //   0	491	3	paramAccount	Account
    //   0	491	4	paramSet2	Set<String>
    //   0	491	5	parambja	bja
    //   0	491	6	parambjm	bjm
    //   0	491	7	parambih	bih
    //   174	292	8	i	int
    //   205	38	9	l	long
    //   219	3	11	bool	boolean
    //   49	142	12	localObject1	Object
    //   22	140	13	localObject2	Object
    //   171	161	14	localObject3	Object
    //   350	53	15	localBuilder	android.net.Uri.Builder
    // Exception table:
    //   from	to	target	type
    //   232	264	295	finally
    //   264	292	295	finally
    //   424	432	295	finally
    //   83	109	308	finally
    //   207	221	470	finally
    //   323	352	470	finally
    //   356	368	470	finally
    //   372	398	470	finally
    //   398	419	470	finally
    //   124	132	474	finally
  }
  
  public static void a(Context paramContext, Map<String, bkn> paramMap, Set<String> paramSet1, Account paramAccount, Set<String> paramSet2, bjm parambjm, bih parambih)
  {
    a(paramContext, paramMap, paramSet1, paramAccount, paramSet2, bix.b, parambjm, parambih);
  }
  
  public static void a(bhx parambhx)
  {
    ;
    ((bjm)localObject).a(parambhx);
  }
  
  public final bkn a(int paramInt)
  {
    Cursor localCursor = getCursor();
    localCursor.moveToPosition(paramInt);
    return bkn.a(localCursor.getString(0), localCursor.getInt(7), localCursor.getString(1), localCursor.getInt(2), localCursor.getString(3), localCursor.getLong(4), d, localCursor.getLong(5), localCursor.getString(6), localCursor.getString(8));
  }
  
  public final void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    int i = paramCursor.getPosition();
    paramContext = a(i);
    e.a(paramView, null, paramContext, i, biq.b, null, f);
  }
  
  public final long getItemId(int paramInt)
  {
    Cursor localCursor = getCursor();
    if (localCursor.moveToPosition(paramInt)) {
      localCursor.getLong(5);
    }
    return -1L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Cursor localCursor = getCursor();
    localCursor.moveToPosition(paramInt);
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = e.a(biq.b);
    }
    if (localCursor.getLong(5) == a)
    {
      b = paramInt;
      if (c != null) {
        c.a(b);
      }
    }
    bindView(paramViewGroup, paramViewGroup.getContext(), localCursor);
    return paramViewGroup;
  }
  
  public final View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return e.a(biq.b);
  }
}

/* Location:
 * Qualified Name:     bjk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */