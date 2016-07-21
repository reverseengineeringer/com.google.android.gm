import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.Command;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class dbe
  implements czh
{
  static final String a = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[] { "hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id" });
  final Context b;
  final String c;
  czl d;
  private final dbh e;
  private volatile czm f;
  private final czi g;
  private long h;
  
  dbe(czi paramczi, Context paramContext)
  {
    this(paramczi, paramContext, "google_analytics_v2.db");
  }
  
  private dbe(czi paramczi, Context paramContext, String paramString)
  {
    b = paramContext.getApplicationContext();
    c = paramString;
    g = paramczi;
    d = new dbf(this);
    e = new dbh(this, b, c);
    f = new dbk(new dbg(this), b);
    h = 0L;
  }
  
  private final SQLiteDatabase a(String paramString)
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = e.getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (SQLiteException localSQLiteException)
    {
      dav.f(paramString);
    }
    return null;
  }
  
  private static String a(Map<String, String> paramMap)
  {
    ArrayList localArrayList = new ArrayList(paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localArrayList.add((String)localEntry.getKey() + "=" + dat.a((String)localEntry.getValue()));
    }
    return TextUtils.join("&", localArrayList);
  }
  
  /* Error */
  private final List<das> a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc -74
    //   3: invokespecial 184	dbe:a	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   6: astore 6
    //   8: aload 6
    //   10: ifnonnull +15 -> 25
    //   13: new 108	java/util/ArrayList
    //   16: dup
    //   17: invokespecial 185	java/util/ArrayList:<init>	()V
    //   20: astore 5
    //   22: aload 5
    //   24: areturn
    //   25: aconst_null
    //   26: astore 5
    //   28: new 108	java/util/ArrayList
    //   31: dup
    //   32: invokespecial 185	java/util/ArrayList:<init>	()V
    //   35: pop
    //   36: ldc -69
    //   38: iconst_2
    //   39: anewarray 4	java/lang/Object
    //   42: dup
    //   43: iconst_0
    //   44: ldc 33
    //   46: aastore
    //   47: dup
    //   48: iconst_1
    //   49: ldc 29
    //   51: aastore
    //   52: invokestatic 43	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   55: astore 4
    //   57: iload_1
    //   58: invokestatic 192	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   61: astore 7
    //   63: aload 6
    //   65: ldc 27
    //   67: iconst_3
    //   68: anewarray 39	java/lang/String
    //   71: dup
    //   72: iconst_0
    //   73: ldc 29
    //   75: aastore
    //   76: dup
    //   77: iconst_1
    //   78: ldc 31
    //   80: aastore
    //   81: dup
    //   82: iconst_2
    //   83: ldc 33
    //   85: aastore
    //   86: aconst_null
    //   87: aconst_null
    //   88: aconst_null
    //   89: aconst_null
    //   90: aload 4
    //   92: aload 7
    //   94: invokevirtual 198	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   97: astore 4
    //   99: new 108	java/util/ArrayList
    //   102: dup
    //   103: invokespecial 185	java/util/ArrayList:<init>	()V
    //   106: astore 7
    //   108: aload 4
    //   110: invokeinterface 203 1 0
    //   115: ifeq +63 -> 178
    //   118: new 205	das
    //   121: dup
    //   122: aload 4
    //   124: iconst_0
    //   125: invokeinterface 209 2 0
    //   130: aload 4
    //   132: iconst_1
    //   133: invokeinterface 209 2 0
    //   138: invokespecial 212	das:<init>	(JJ)V
    //   141: astore 5
    //   143: aload 5
    //   145: aload 4
    //   147: iconst_2
    //   148: invokeinterface 215 2 0
    //   153: putfield 217	das:d	Ljava/lang/String;
    //   156: aload 7
    //   158: aload 5
    //   160: invokeinterface 169 2 0
    //   165: pop
    //   166: aload 4
    //   168: invokeinterface 220 1 0
    //   173: istore_3
    //   174: iload_3
    //   175: ifne -57 -> 118
    //   178: aload 4
    //   180: ifnull +10 -> 190
    //   183: aload 4
    //   185: invokeinterface 223 1 0
    //   190: aload 4
    //   192: astore 5
    //   194: ldc -31
    //   196: iconst_1
    //   197: anewarray 4	java/lang/Object
    //   200: dup
    //   201: iconst_0
    //   202: ldc 29
    //   204: aastore
    //   205: invokestatic 43	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   208: astore 8
    //   210: aload 4
    //   212: astore 5
    //   214: iload_1
    //   215: invokestatic 192	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   218: astore 9
    //   220: aload 4
    //   222: astore 5
    //   224: aload 6
    //   226: ldc 27
    //   228: iconst_2
    //   229: anewarray 39	java/lang/String
    //   232: dup
    //   233: iconst_0
    //   234: ldc 29
    //   236: aastore
    //   237: dup
    //   238: iconst_1
    //   239: ldc 35
    //   241: aastore
    //   242: aconst_null
    //   243: aconst_null
    //   244: aconst_null
    //   245: aconst_null
    //   246: aload 8
    //   248: aload 9
    //   250: invokevirtual 198	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   253: astore 6
    //   255: aload 6
    //   257: invokeinterface 203 1 0
    //   262: ifeq +61 -> 323
    //   265: iconst_0
    //   266: istore_1
    //   267: aload 6
    //   269: instanceof 227
    //   272: ifeq +338 -> 610
    //   275: aload 6
    //   277: checkcast 227	android/database/sqlite/SQLiteCursor
    //   280: invokevirtual 231	android/database/sqlite/SQLiteCursor:getWindow	()Landroid/database/CursorWindow;
    //   283: invokevirtual 236	android/database/CursorWindow:getNumRows	()I
    //   286: ifle +126 -> 412
    //   289: aload 7
    //   291: iload_1
    //   292: invokeinterface 240 2 0
    //   297: checkcast 205	das
    //   300: aload 6
    //   302: iconst_1
    //   303: invokeinterface 215 2 0
    //   308: putfield 241	das:a	Ljava/lang/String;
    //   311: aload 6
    //   313: invokeinterface 220 1 0
    //   318: istore_3
    //   319: iload_3
    //   320: ifne +375 -> 695
    //   323: aload 6
    //   325: ifnull +10 -> 335
    //   328: aload 6
    //   330: invokeinterface 223 1 0
    //   335: aload 7
    //   337: areturn
    //   338: astore 5
    //   340: aconst_null
    //   341: astore 4
    //   343: new 141	java/lang/StringBuilder
    //   346: dup
    //   347: ldc -13
    //   349: invokespecial 246	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   352: aload 5
    //   354: invokevirtual 249	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   357: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokestatic 105	dav:f	(Ljava/lang/String;)I
    //   366: pop
    //   367: new 108	java/util/ArrayList
    //   370: dup
    //   371: invokespecial 185	java/util/ArrayList:<init>	()V
    //   374: astore 6
    //   376: aload 6
    //   378: astore 5
    //   380: aload 4
    //   382: ifnull -360 -> 22
    //   385: aload 4
    //   387: invokeinterface 223 1 0
    //   392: aload 6
    //   394: areturn
    //   395: astore 4
    //   397: aload 5
    //   399: ifnull +10 -> 409
    //   402: aload 5
    //   404: invokeinterface 223 1 0
    //   409: aload 4
    //   411: athrow
    //   412: new 141	java/lang/StringBuilder
    //   415: dup
    //   416: ldc -5
    //   418: invokespecial 246	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   421: aload 7
    //   423: iload_1
    //   424: invokeinterface 240 2 0
    //   429: checkcast 205	das
    //   432: getfield 253	das:b	J
    //   435: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   438: ldc_w 258
    //   441: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: invokestatic 105	dav:f	(Ljava/lang/String;)I
    //   450: pop
    //   451: goto -140 -> 311
    //   454: astore 5
    //   456: aload 6
    //   458: astore 4
    //   460: aload 5
    //   462: astore 6
    //   464: aload 4
    //   466: astore 5
    //   468: new 141	java/lang/StringBuilder
    //   471: dup
    //   472: ldc_w 260
    //   475: invokespecial 246	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   478: aload 6
    //   480: invokevirtual 249	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   483: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   489: invokestatic 105	dav:f	(Ljava/lang/String;)I
    //   492: pop
    //   493: aload 4
    //   495: astore 5
    //   497: new 108	java/util/ArrayList
    //   500: dup
    //   501: invokespecial 185	java/util/ArrayList:<init>	()V
    //   504: astore 6
    //   506: iconst_0
    //   507: istore_1
    //   508: aload 4
    //   510: astore 5
    //   512: aload 7
    //   514: invokeinterface 261 1 0
    //   519: astore 7
    //   521: aload 4
    //   523: astore 5
    //   525: aload 7
    //   527: invokeinterface 133 1 0
    //   532: ifeq +112 -> 644
    //   535: aload 4
    //   537: astore 5
    //   539: aload 7
    //   541: invokeinterface 137 1 0
    //   546: checkcast 205	das
    //   549: astore 8
    //   551: iload_1
    //   552: istore_2
    //   553: aload 4
    //   555: astore 5
    //   557: aload 8
    //   559: getfield 241	das:a	Ljava/lang/String;
    //   562: invokestatic 265	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   565: ifeq +9 -> 574
    //   568: iload_1
    //   569: ifne +75 -> 644
    //   572: iconst_1
    //   573: istore_2
    //   574: aload 4
    //   576: astore 5
    //   578: aload 6
    //   580: aload 8
    //   582: invokeinterface 169 2 0
    //   587: pop
    //   588: iload_2
    //   589: istore_1
    //   590: goto -69 -> 521
    //   593: astore 4
    //   595: aload 5
    //   597: ifnull +10 -> 607
    //   600: aload 5
    //   602: invokeinterface 223 1 0
    //   607: aload 4
    //   609: athrow
    //   610: aload 7
    //   612: iload_1
    //   613: invokeinterface 240 2 0
    //   618: checkcast 205	das
    //   621: aload 6
    //   623: iconst_1
    //   624: invokeinterface 215 2 0
    //   629: putfield 241	das:a	Ljava/lang/String;
    //   632: goto -321 -> 311
    //   635: astore 4
    //   637: aload 6
    //   639: astore 5
    //   641: goto -46 -> 595
    //   644: aload 4
    //   646: ifnull +10 -> 656
    //   649: aload 4
    //   651: invokeinterface 223 1 0
    //   656: aload 6
    //   658: areturn
    //   659: astore 6
    //   661: goto -197 -> 464
    //   664: astore 6
    //   666: aload 4
    //   668: astore 5
    //   670: aload 6
    //   672: astore 4
    //   674: goto -277 -> 397
    //   677: astore 6
    //   679: aload 4
    //   681: astore 5
    //   683: aload 6
    //   685: astore 4
    //   687: goto -290 -> 397
    //   690: astore 5
    //   692: goto -349 -> 343
    //   695: iload_1
    //   696: iconst_1
    //   697: iadd
    //   698: istore_1
    //   699: goto -432 -> 267
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	702	0	this	dbe
    //   0	702	1	paramInt	int
    //   552	37	2	i	int
    //   173	147	3	bool	boolean
    //   55	331	4	localObject1	Object
    //   395	15	4	localObject2	Object
    //   458	117	4	localObject3	Object
    //   593	15	4	localObject4	Object
    //   635	32	4	localObject5	Object
    //   672	14	4	localObject6	Object
    //   20	203	5	localObject7	Object
    //   338	15	5	localSQLiteException1	SQLiteException
    //   378	25	5	localObject8	Object
    //   454	7	5	localSQLiteException2	SQLiteException
    //   466	216	5	localObject9	Object
    //   690	1	5	localSQLiteException3	SQLiteException
    //   6	651	6	localObject10	Object
    //   659	1	6	localSQLiteException4	SQLiteException
    //   664	7	6	localObject11	Object
    //   677	7	6	localObject12	Object
    //   61	550	7	localObject13	Object
    //   208	373	8	localObject14	Object
    //   218	31	9	str	String
    // Exception table:
    //   from	to	target	type
    //   36	99	338	android/database/sqlite/SQLiteException
    //   36	99	395	finally
    //   255	265	454	android/database/sqlite/SQLiteException
    //   267	311	454	android/database/sqlite/SQLiteException
    //   311	319	454	android/database/sqlite/SQLiteException
    //   412	451	454	android/database/sqlite/SQLiteException
    //   610	632	454	android/database/sqlite/SQLiteException
    //   194	210	593	finally
    //   214	220	593	finally
    //   224	255	593	finally
    //   468	493	593	finally
    //   497	506	593	finally
    //   512	521	593	finally
    //   525	535	593	finally
    //   539	551	593	finally
    //   557	568	593	finally
    //   578	588	593	finally
    //   255	265	635	finally
    //   267	311	635	finally
    //   311	319	635	finally
    //   412	451	635	finally
    //   610	632	635	finally
    //   194	210	659	android/database/sqlite/SQLiteException
    //   214	220	659	android/database/sqlite/SQLiteException
    //   224	255	659	android/database/sqlite/SQLiteException
    //   99	118	664	finally
    //   118	174	664	finally
    //   343	376	677	finally
    //   99	118	690	android/database/sqlite/SQLiteException
    //   118	174	690	android/database/sqlite/SQLiteException
  }
  
  private final void a(Collection<das> paramCollection)
  {
    boolean bool = false;
    if (paramCollection == null) {
      throw new NullPointerException("hits cannot be null");
    }
    if (paramCollection.isEmpty()) {}
    Object localObject;
    do
    {
      return;
      localObject = a("Error opening database for deleteHit");
    } while (localObject == null);
    String[] arrayOfString = new String[paramCollection.size()];
    String str = String.format("HIT_ID in (%s)", new Object[] { TextUtils.join(",", Collections.nCopies(arrayOfString.length, "?")) });
    Iterator localIterator = paramCollection.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      arrayOfString[i] = Long.toString(nextb);
      i += 1;
    }
    try
    {
      ((SQLiteDatabase)localObject).delete("hits2", str, arrayOfString);
      localObject = g;
      if (c() == 0) {
        bool = true;
      }
      ((czi)localObject).a(bool);
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      dav.f("Error deleting hit " + paramCollection);
    }
  }
  
  private final int c()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    int i = 0;
    int j = 0;
    Object localObject5 = a("Error opening database for requestNumHitsPending");
    if (localObject5 == null) {}
    for (;;)
    {
      return j;
      try
      {
        localObject5 = ((SQLiteDatabase)localObject5).rawQuery("SELECT COUNT(*) from hits2", null);
        localObject1 = localObject5;
        localObject3 = localObject5;
        if (((Cursor)localObject5).moveToFirst())
        {
          localObject1 = localObject5;
          localObject3 = localObject5;
          long l = ((Cursor)localObject5).getLong(0);
          i = (int)l;
        }
        j = i;
        return i;
      }
      catch (SQLiteException localSQLiteException)
      {
        localObject4 = localObject1;
        dav.f("Error getting numStoredHits");
        return 0;
      }
      finally
      {
        Object localObject4;
        if (localObject4 != null) {
          ((Cursor)localObject4).close();
        }
      }
    }
  }
  
  public final void a()
  {
    boolean bool = true;
    Object localObject = a("Error opening database for clearHits");
    if (localObject != null)
    {
      if (0L != 0L) {
        break label49;
      }
      ((SQLiteDatabase)localObject).delete("hits2", null, null);
      localObject = g;
      if (c() != 0) {
        break label76;
      }
    }
    for (;;)
    {
      ((czi)localObject).a(bool);
      return;
      label49:
      ((SQLiteDatabase)localObject).delete("hits2", "hit_app_id = ?", new String[] { Long.valueOf(0L).toString() });
      break;
      label76:
      bool = false;
    }
  }
  
  public final void a(Map<String, String> paramMap, long paramLong, String paramString, Collection<Command> paramCollection)
  {
    boolean bool = true;
    long l = d.a();
    Object localObject;
    if (l > h + 86400000L)
    {
      h = l;
      localObject = a("Error opening database for deleteStaleHits");
      if (localObject != null)
      {
        ((SQLiteDatabase)localObject).delete("hits2", "HIT_TIME < ?", new String[] { Long.toString(d.a() - 2592000000L) });
        localObject = g;
        if (c() != 0) {
          break label364;
        }
        ((czi)localObject).a(bool);
      }
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      localObject = (Command)paramCollection.next();
      if (a.equals("appendVersion"))
      {
        paramCollection = c;
        localObject = b;
        if (paramCollection != null) {
          break label370;
        }
        paramCollection = "";
        label173:
        if (localObject != null) {
          paramMap.put(localObject, paramCollection);
        }
      }
    }
    int i = c() - 2000 + 1;
    if (i > 0)
    {
      paramCollection = a(i);
      dav.g("Store full, deleting " + paramCollection.size() + " hits to make room");
      a(paramCollection);
    }
    paramCollection = a("Error opening database for putHit");
    if (paramCollection != null)
    {
      localObject = new ContentValues();
      ((ContentValues)localObject).put("hit_string", a(paramMap));
      ((ContentValues)localObject).put("hit_time", Long.valueOf(paramLong));
      if (!paramMap.containsKey("AppUID")) {
        break label374;
      }
    }
    for (;;)
    {
      label364:
      label370:
      try
      {
        paramLong = Long.parseLong((String)paramMap.get("AppUID"));
        ((ContentValues)localObject).put("hit_app_id", Long.valueOf(paramLong));
        paramMap = paramString;
        if (paramString == null) {
          paramMap = "http://www.google-analytics.com/collect";
        }
        if (paramMap.length() != 0) {
          break label379;
        }
        dav.f("empty path: not sending hit");
        return;
      }
      catch (NumberFormatException paramMap) {}
      bool = false;
      break;
      break label173;
      label374:
      paramLong = 0L;
    }
    label379:
    ((ContentValues)localObject).put("hit_url", paramMap);
    try
    {
      paramCollection.insert("hits2", null, (ContentValues)localObject);
      g.a(false);
      return;
    }
    catch (SQLiteException paramMap)
    {
      dav.f("Error storing hit");
    }
  }
  
  public final void b()
  {
    dav.e("dispatch running...");
    if (!f.a()) {}
    List localList;
    int i;
    do
    {
      return;
      localList = a(40);
      if (localList.isEmpty())
      {
        dav.e("...nothing to dispatch");
        g.a(true);
        return;
      }
      i = f.a(localList);
      dav.e("sent " + i + " of " + localList.size() + " hits");
      a(localList.subList(0, Math.min(i, localList.size())));
    } while ((i != localList.size()) || (c() <= 0));
    czv.a().c();
  }
}

/* Location:
 * Qualified Name:     dbe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */