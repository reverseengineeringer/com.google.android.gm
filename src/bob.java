import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Entity;
import android.content.Entity.NamedContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.provider.ContactsContract.RawContacts;
import android.provider.ContactsContract.SyncState;
import android.provider.SyncStateContract.Helpers;
import android.util.Base64;
import com.android.emailcommon.provider.Mailbox;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.TimeZone;

public final class bob
  extends bnx
{
  static final ArrayList<Entity.NamedContentValues> f = new ArrayList();
  private static final String[] n = { "_id" };
  String[] g = new String[1];
  bod h = new bod();
  public boolean i = false;
  private final android.accounts.Account o;
  private final Uri p;
  
  public bob(Context paramContext, ContentResolver paramContentResolver, InputStream paramInputStream, Mailbox paramMailbox, com.android.emailcommon.provider.Account paramAccount, android.accounts.Account paramAccount1)
  {
    super(paramContext, paramContentResolver, paramInputStream, paramMailbox, paramAccount);
    o = paramAccount1;
    p = a(ContactsContract.RawContacts.CONTENT_URI, b.d);
  }
  
  public static Uri a(Entity.NamedContentValues paramNamedContentValues)
  {
    long l = values.getAsLong("_id").longValue();
    return ContentUris.withAppendedId(uri, l);
  }
  
  static Uri a(Uri paramUri)
  {
    return paramUri.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").build();
  }
  
  public static Uri a(Uri paramUri, String paramString)
  {
    return paramUri.buildUpon().appendQueryParameter("account_name", paramString).appendQueryParameter("account_type", bnq.c).appendQueryParameter("caller_is_syncadapter", "true").build();
  }
  
  private final void a(bod parambod, Entity paramEntity)
  {
    while (b(85) != 3) {
      switch (l)
      {
      default: 
        i();
        break;
      case 86: 
        String str = g();
        bok localbok = parambod.a(paramEntity, "vnd.android.cursor.item/group_membership", -1, str);
        localbok.a("group_sourceid", str);
        parambod.a(a.build());
      }
    }
  }
  
  private final void a(String paramString, bod parambod, Entity paramEntity)
  {
    boc localboc1 = new boc();
    boc localboc2 = new boc();
    boc localboc3 = new boc();
    boe localboe = new boe();
    bog localbog = new bog();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    ArrayList localArrayList5 = new ArrayList();
    if (paramEntity == null)
    {
      localObject1 = b.d;
      localObject1 = ContentProviderOperation.newInsert(a(ContactsContract.RawContacts.CONTENT_URI, (String)localObject1));
      localObject2 = new ContentValues();
      ((ContentValues)localObject2).put("sourceid", paramString);
      ((ContentProviderOperation.Builder)localObject1).withValues((ContentValues)localObject2);
      b = a;
      paramString = c;
      j = d;
      d = (j + 1);
      paramString[j] = a;
      parambod.a(((ContentProviderOperation.Builder)localObject1).build());
    }
    Object localObject3 = null;
    paramString = null;
    Object localObject4 = null;
    Object localObject1 = null;
    String str5 = null;
    String str2 = null;
    String str7 = null;
    String str4 = null;
    String str1 = null;
    Object localObject2 = null;
    String str6 = null;
    String str3 = null;
    while (b(29) != 3)
    {
      Object localObject5;
      ContentValues localContentValues;
      Object localObject6;
      switch (this.l)
      {
      default: 
        i();
        break;
      case 95: 
        localObject4 = g();
        break;
      case 105: 
        str3 = g();
        break;
      case 106: 
        str4 = g();
        break;
      case 117: 
        str5 = g();
        break;
      case 89: 
        paramString = g();
        break;
      case 104: 
        localObject2 = g();
        break;
      case 91: 
      case 92: 
      case 93: 
        localArrayList2.add(new boh(g()));
        break;
      case 76: 
      case 83: 
        localArrayList5.add(new boj(g(), 3));
        break;
      case 782: 
        parambod.a(paramEntity, 20, g());
        break;
      case 82: 
        parambod.a(paramEntity, 4, g());
        break;
      case 779: 
        parambod.a(paramEntity, 10, g());
        break;
      case 102: 
        parambod.a(paramEntity, 5, g());
        break;
      case 96: 
      case 103: 
        localArrayList4.add(new boj(g(), 1));
        break;
      case 107: 
        parambod.a(paramEntity, 2, g());
        break;
      case 84: 
        parambod.a(paramEntity, 9, g());
        break;
      case 115: 
        parambod.a(paramEntity, 14, g());
        break;
      case 114: 
        parambod.a(paramEntity, 6, g());
        break;
      case 71: 
        parambod.a(paramEntity, 19, g());
        break;
      case 775: 
      case 776: 
      case 777: 
        localArrayList3.add(new boi(g()));
        break;
      case 77: 
        a = g();
        break;
      case 78: 
        b = g();
        break;
      case 79: 
        c = g();
        break;
      case 80: 
        e = g();
        break;
      case 81: 
        d = g();
        break;
      case 97: 
        a = g();
        break;
      case 98: 
        b = g();
        break;
      case 99: 
        c = g();
        break;
      case 100: 
        e = g();
        break;
      case 101: 
        d = g();
        break;
      case 109: 
        a = g();
        break;
      case 110: 
        b = g();
        break;
      case 111: 
        c = g();
        break;
      case 112: 
        e = g();
        break;
      case 113: 
        d = g();
        break;
      case 87: 
        a(localArrayList1);
        break;
      case 120: 
        localObject1 = g();
        break;
      case 121: 
        str6 = g();
        break;
      case 122: 
        str7 = g();
        break;
      case 781: 
        localObject5 = g();
        localObject7 = parambod.a(paramEntity, "vnd.android.cursor.item/nickname", 1);
        localContentValues = b;
        if ((localContentValues == null) || (!bod.a(localContentValues, "data1", (String)localObject5)))
        {
          ((bok)localObject7).a("data2", Integer.valueOf(1));
          ((bok)localObject7).a("data1", localObject5);
          parambod.a(a.build());
        }
        break;
      case 70: 
        parambod.b(paramEntity, 1, g());
        break;
      case 778: 
        parambod.b(paramEntity, 7, g());
        break;
      case 116: 
        parambod.b(paramEntity, 14, g());
        break;
      case 90: 
        str1 = g();
        break;
      case 118: 
        localObject3 = g();
        break;
      case 108: 
        str2 = g();
        break;
      case 773: 
        a = g();
        break;
      case 774: 
        b = g();
        break;
      case 780: 
        c = g();
        break;
      case 69: 
        a = g();
        break;
      case 94: 
        b = g();
        break;
      case 72: 
        localObject7 = g();
        localObject5 = parambod.a(paramEntity, "vnd.android.cursor.item/contact_event", 3);
        localContentValues = b;
        if ((localContentValues == null) || (!bod.a(localContentValues, "data1", (String)localObject7))) {
          try
          {
            long l = bhn.b((String)localObject7);
            localObject7 = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
            ((GregorianCalendar)localObject7).setTimeInMillis(l);
            if (((GregorianCalendar)localObject7).get(11) >= 12) {
              ((GregorianCalendar)localObject7).add(5, 1);
            }
            ((bok)localObject5).a("data1", bsx.a((GregorianCalendar)localObject7));
            ((bok)localObject5).a("data2", Integer.valueOf(3));
            parambod.a(a.build());
          }
          catch (ParseException localParseException)
          {
            cvm.d("Exchange", "Parse error for birthday date field.", new Object[] { localParseException });
          }
        }
        break;
      case 119: 
        localObject6 = g();
        localObject7 = parambod.a(paramEntity, "vnd.android.cursor.item/website");
        localContentValues = b;
        if ((localContentValues == null) || (!bod.a(localContentValues, "data1", (String)localObject6)))
        {
          ((bok)localObject7).a("data2", Integer.valueOf(5));
          ((bok)localObject7).a("data1", localObject6);
          parambod.a(a.build());
        }
        break;
      case 124: 
        localObject6 = g();
        try
        {
          localObject6 = Base64.decode((String)localObject6, 0);
          localObject7 = parambod.a(paramEntity, "vnd.android.cursor.item/photo");
          ((bok)localObject7).a("data15", localObject6);
          parambod.a(a.build());
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          cvm.d("Exchange", "Bad base-64 encoding; unable to decode photo.", new Object[0]);
        }
        break;
      case 1098: 
        parambod.b(paramEntity, k());
        break;
      case 73: 
        parambod.b(paramEntity, g());
        break;
      case 85: 
        i = true;
        a(parambod, paramEntity);
      }
    }
    bok localbok = parambod.a(paramEntity, "vnd.android.cursor.item/name");
    Object localObject7 = b;
    if ((localObject7 == null) || (!bod.a((ContentValues)localObject7, "data2", (String)localObject4)) || (!bod.a((ContentValues)localObject7, "data3", str3)) || (!bod.a((ContentValues)localObject7, "data5", str4)) || (!bod.a((ContentValues)localObject7, "data4", (String)localObject3)) || (!bod.a((ContentValues)localObject7, "data7", str6)) || (!bod.a((ContentValues)localObject7, "data9", str7)) || (!bod.a((ContentValues)localObject7, "data6", str5)))
    {
      localbok.a("data2", localObject4);
      localbok.a("data3", str3);
      localbok.a("data5", str4);
      localbok.a("data6", str5);
      localbok.a("data7", str6);
      localbok.a("data9", str7);
      localbok.a("data4", localObject3);
      parambod.a(a.build());
    }
    localObject3 = parambod.a(paramEntity, "vnd.android.cursor.item/eas_business");
    localObject4 = b;
    if ((localObject4 == null) || (!bod.a((ContentValues)localObject4, "data8", c)) || (!bod.a((ContentValues)localObject4, "data6", a)) || (!bod.a((ContentValues)localObject4, "data7", b)))
    {
      if ((a == null) && (b == null) && (c == null)) {
        break label2640;
      }
      j = 1;
      if (j != 0)
      {
        ((bok)localObject3).a("data8", c);
        ((bok)localObject3).a("data6", a);
        ((bok)localObject3).a("data7", b);
        parambod.a(a.build());
      }
    }
    localObject3 = parambod.a(paramEntity, "vnd.android.cursor.item/eas_personal");
    localObject4 = b;
    if ((localObject4 == null) || (!bod.a((ContentValues)localObject4, "data2", a)) || (!bod.a((ContentValues)localObject4, "data4", b))) {
      if ((a == null) && (b == null)) {
        break label2646;
      }
    }
    label2640:
    label2646:
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        ((bok)localObject3).a("data4", b);
        ((bok)localObject3).a("data2", a);
        parambod.a(a.build());
      }
      parambod.a(paramEntity, localArrayList2, "vnd.android.cursor.item/email_v2", -1, 3);
      parambod.a(paramEntity, localArrayList3, "vnd.android.cursor.item/im", -1, 3);
      parambod.a(paramEntity, localArrayList4, "vnd.android.cursor.item/phone_v2", 1, 2);
      parambod.a(paramEntity, localArrayList5, "vnd.android.cursor.item/phone_v2", 3, 2);
      if (!localArrayList1.isEmpty()) {
        parambod.a(paramEntity, localArrayList1);
      }
      if (localboc2.a()) {
        parambod.a(paramEntity, 2, d, a, e, b, c);
      }
      if (localboc1.a()) {
        parambod.a(paramEntity, 1, d, a, e, b, c);
      }
      if (localboc3.a()) {
        parambod.a(paramEntity, 3, d, a, e, b, c);
      }
      if (paramString != null)
      {
        localObject3 = parambod.a(paramEntity, "vnd.android.cursor.item/organization", 1);
        localObject4 = b;
        if ((localObject4 == null) || (!bod.a((ContentValues)localObject4, "data1", paramString)) || (!bod.a((ContentValues)localObject4, "data8", (String)localObject1)) || (!bod.a((ContentValues)localObject4, "data5", str1)) || (!bod.a((ContentValues)localObject4, "data4", (String)localObject2)) || (!bod.a((ContentValues)localObject4, "data9", str2)))
        {
          ((bok)localObject3).a("data2", Integer.valueOf(1));
          ((bok)localObject3).a("data1", paramString);
          ((bok)localObject3).a("data4", localObject2);
          ((bok)localObject3).a("data5", str1);
          ((bok)localObject3).a("data8", localObject1);
          ((bok)localObject3).a("data9", str2);
          parambod.a(a.build());
        }
      }
      if (paramEntity == null) {
        return;
      }
      paramString = paramEntity.getSubValues().iterator();
      while (paramString.hasNext()) {
        parambod.a(ContentProviderOperation.newDelete(a(a((Entity.NamedContentValues)paramString.next()))).build());
      }
      j = 0;
      break;
    }
  }
  
  private final void a(ArrayList<String> paramArrayList)
  {
    while (b(87) != 3) {
      switch (l)
      {
      default: 
        i();
        break;
      case 88: 
        if (paramArrayList.size() < 8) {
          paramArrayList.add(g());
        }
        break;
      }
    }
  }
  
  private final Cursor b(String paramString)
  {
    g[0] = paramString;
    return d.query(p, n, "sourceid=?", g, null);
  }
  
  private final String k()
  {
    String str = null;
    while (b(1098) != 3) {
      switch (l)
      {
      default: 
        i();
        break;
      case 1099: 
        str = g();
      }
    }
    return str;
  }
  
  private final void l()
  {
    String str2 = null;
    String str1 = null;
    while (b(8) != 3) {
      switch (l)
      {
      default: 
        i();
        break;
      case 13: 
        str1 = g();
        break;
      case 14: 
        str2 = g();
      }
    }
    if ((str1 != null) && (str2 != null)) {
      new StringBuilder(String.valueOf(str1).length() + 37 + String.valueOf(str2).length()).append("Changed contact ").append(str1).append(" failed with status: ").append(str2).toString();
    }
  }
  
  /* Error */
  public final void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: bipush 22
    //   3: invokevirtual 132	bob:b	(I)I
    //   6: iconst_3
    //   7: if_icmpeq +417 -> 424
    //   10: aload_0
    //   11: getfield 136	bob:l	I
    //   14: bipush 7
    //   16: if_icmpne +78 -> 94
    //   19: aload_0
    //   20: getfield 45	bob:h	Lbod;
    //   23: astore 4
    //   25: aconst_null
    //   26: astore_3
    //   27: aload_0
    //   28: bipush 7
    //   30: invokevirtual 132	bob:b	(I)I
    //   33: iconst_3
    //   34: if_icmpeq -34 -> 0
    //   37: aload_0
    //   38: getfield 136	bob:l	I
    //   41: lookupswitch	default:+27->68, 13:+34->75, 29:+42->83
    //   68: aload_0
    //   69: invokevirtual 138	bob:i	()V
    //   72: goto -45 -> 27
    //   75: aload_0
    //   76: invokevirtual 141	bob:g	()Ljava/lang/String;
    //   79: astore_3
    //   80: goto -53 -> 27
    //   83: aload_0
    //   84: aload_3
    //   85: aload 4
    //   87: aconst_null
    //   88: invokespecial 445	bob:a	(Ljava/lang/String;Lbod;Landroid/content/Entity;)V
    //   91: goto -64 -> 27
    //   94: aload_0
    //   95: getfield 136	bob:l	I
    //   98: bipush 9
    //   100: if_icmpne +125 -> 225
    //   103: aload_0
    //   104: getfield 45	bob:h	Lbod;
    //   107: astore 4
    //   109: aload_0
    //   110: bipush 9
    //   112: invokevirtual 132	bob:b	(I)I
    //   115: iconst_3
    //   116: if_icmpeq -116 -> 0
    //   119: aload_0
    //   120: getfield 136	bob:l	I
    //   123: tableswitch	default:+17->140, 13:+24->147
    //   140: aload_0
    //   141: invokevirtual 138	bob:i	()V
    //   144: goto -35 -> 109
    //   147: aload_0
    //   148: aload_0
    //   149: invokevirtual 141	bob:g	()Ljava/lang/String;
    //   152: invokespecial 447	bob:b	(Ljava/lang/String;)Landroid/database/Cursor;
    //   155: astore_3
    //   156: aload_3
    //   157: invokeinterface 452 1 0
    //   162: ifeq +43 -> 205
    //   165: aload_3
    //   166: iconst_0
    //   167: invokeinterface 456 2 0
    //   172: lstore_1
    //   173: aload 4
    //   175: getstatic 54	android/provider/ContactsContract$RawContacts:CONTENT_URI	Landroid/net/Uri;
    //   178: lload_1
    //   179: invokestatic 98	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   182: invokevirtual 105	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   185: ldc 107
    //   187: ldc 109
    //   189: invokevirtual 115	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   192: invokevirtual 119	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   195: invokestatic 403	android/content/ContentProviderOperation:newDelete	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   198: invokevirtual 161	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   201: invokevirtual 164	bod:a	(Landroid/content/ContentProviderOperation;)Z
    //   204: pop
    //   205: aload_3
    //   206: invokeinterface 459 1 0
    //   211: goto -102 -> 109
    //   214: astore 4
    //   216: aload_3
    //   217: invokeinterface 459 1 0
    //   222: aload 4
    //   224: athrow
    //   225: aload_0
    //   226: getfield 136	bob:l	I
    //   229: bipush 8
    //   231: if_icmpne +186 -> 417
    //   234: aload_0
    //   235: getfield 45	bob:h	Lbod;
    //   238: astore 5
    //   240: aconst_null
    //   241: astore_3
    //   242: aconst_null
    //   243: astore 4
    //   245: aload_0
    //   246: bipush 8
    //   248: invokevirtual 132	bob:b	(I)I
    //   251: iconst_3
    //   252: if_icmpeq -252 -> 0
    //   255: aload_0
    //   256: getfield 136	bob:l	I
    //   259: lookupswitch	default:+25->284, 13:+32->291, 29:+146->405
    //   284: aload_0
    //   285: invokevirtual 138	bob:i	()V
    //   288: goto -43 -> 245
    //   291: aload_0
    //   292: invokevirtual 141	bob:g	()Ljava/lang/String;
    //   295: astore 4
    //   297: aload_0
    //   298: aload 4
    //   300: invokespecial 447	bob:b	(Ljava/lang/String;)Landroid/database/Cursor;
    //   303: astore 6
    //   305: aload 6
    //   307: invokeinterface 452 1 0
    //   312: ifeq +116 -> 428
    //   315: getstatic 54	android/provider/ContactsContract$RawContacts:CONTENT_URI	Landroid/net/Uri;
    //   318: aload 6
    //   320: iconst_0
    //   321: invokeinterface 456 2 0
    //   326: invokestatic 98	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   329: ldc_w 461
    //   332: invokestatic 464	android/net/Uri:withAppendedPath	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   335: astore 7
    //   337: aload_0
    //   338: getfield 413	bob:d	Landroid/content/ContentResolver;
    //   341: aload 7
    //   343: aconst_null
    //   344: aconst_null
    //   345: aconst_null
    //   346: aconst_null
    //   347: invokevirtual 421	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   350: astore 7
    //   352: aload 7
    //   354: ifnull +74 -> 428
    //   357: aload 7
    //   359: invokestatic 468	android/provider/ContactsContract$RawContacts:newEntityIterator	(Landroid/database/Cursor;)Landroid/content/EntityIterator;
    //   362: astore 7
    //   364: aload 7
    //   366: invokeinterface 471 1 0
    //   371: ifeq +54 -> 425
    //   374: aload 7
    //   376: invokeinterface 472 1 0
    //   381: checkcast 379	android/content/Entity
    //   384: astore_3
    //   385: aload 6
    //   387: invokeinterface 459 1 0
    //   392: goto -147 -> 245
    //   395: astore_3
    //   396: aload 6
    //   398: invokeinterface 459 1 0
    //   403: aload_3
    //   404: athrow
    //   405: aload_0
    //   406: aload 4
    //   408: aload 5
    //   410: aload_3
    //   411: invokespecial 445	bob:a	(Ljava/lang/String;Lbod;Landroid/content/Entity;)V
    //   414: goto -169 -> 245
    //   417: aload_0
    //   418: invokevirtual 138	bob:i	()V
    //   421: goto -421 -> 0
    //   424: return
    //   425: goto -40 -> 385
    //   428: goto -43 -> 385
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	431	0	this	bob
    //   172	7	1	l	long
    //   26	359	3	localObject1	Object
    //   395	16	3	localEntity	Entity
    //   23	151	4	localbod1	bod
    //   214	9	4	localObject2	Object
    //   243	164	4	str	String
    //   238	171	5	localbod2	bod
    //   303	94	6	localCursor	Cursor
    //   335	40	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   156	205	214	finally
    //   305	352	395	finally
    //   357	385	395	finally
  }
  
  /* Error */
  public final void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: bipush 6
    //   3: invokevirtual 132	bob:b	(I)I
    //   6: iconst_3
    //   7: if_icmpeq +290 -> 297
    //   10: aload_0
    //   11: getfield 136	bob:l	I
    //   14: bipush 7
    //   16: if_icmpne +258 -> 274
    //   19: new 79	android/content/ContentValues
    //   22: dup
    //   23: invokespecial 185	android/content/ContentValues:<init>	()V
    //   26: astore_3
    //   27: aconst_null
    //   28: astore_2
    //   29: aconst_null
    //   30: astore_1
    //   31: aload_0
    //   32: bipush 7
    //   34: invokevirtual 132	bob:b	(I)I
    //   37: iconst_3
    //   38: if_icmpeq +65 -> 103
    //   41: aload_0
    //   42: getfield 136	bob:l	I
    //   45: tableswitch	default:+27->72, 12:+42->87, 13:+34->79, 14:+50->95
    //   72: aload_0
    //   73: invokevirtual 138	bob:i	()V
    //   76: goto -45 -> 31
    //   79: aload_0
    //   80: invokevirtual 141	bob:g	()Ljava/lang/String;
    //   83: astore_1
    //   84: goto -53 -> 31
    //   87: aload_0
    //   88: invokevirtual 141	bob:g	()Ljava/lang/String;
    //   91: astore_2
    //   92: goto -61 -> 31
    //   95: aload_0
    //   96: invokevirtual 141	bob:g	()Ljava/lang/String;
    //   99: pop
    //   100: goto -69 -> 31
    //   103: aload_2
    //   104: ifnull -104 -> 0
    //   107: aload_1
    //   108: ifnull -108 -> 0
    //   111: aload_0
    //   112: getfield 40	bob:g	[Ljava/lang/String;
    //   115: iconst_0
    //   116: aload_2
    //   117: aastore
    //   118: aload_0
    //   119: getfield 413	bob:d	Landroid/content/ContentResolver;
    //   122: aload_0
    //   123: getfield 70	bob:p	Landroid/net/Uri;
    //   126: getstatic 26	bob:n	[Ljava/lang/String;
    //   129: ldc_w 474
    //   132: aload_0
    //   133: getfield 40	bob:g	[Ljava/lang/String;
    //   136: aconst_null
    //   137: invokevirtual 421	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   140: astore 4
    //   142: aload 4
    //   144: invokeinterface 452 1 0
    //   149: ifeq +105 -> 254
    //   152: aload_3
    //   153: ldc -69
    //   155: aload_1
    //   156: invokevirtual 191	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   159: aload_3
    //   160: ldc_w 476
    //   163: iconst_0
    //   164: invokestatic 256	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   167: invokevirtual 479	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   170: aload_0
    //   171: getfield 45	bob:h	Lbod;
    //   174: getstatic 54	android/provider/ContactsContract$RawContacts:CONTENT_URI	Landroid/net/Uri;
    //   177: invokestatic 400	bob:a	(Landroid/net/Uri;)Landroid/net/Uri;
    //   180: aload 4
    //   182: iconst_0
    //   183: invokeinterface 456 2 0
    //   188: invokestatic 98	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   191: invokestatic 482	android/content/ContentProviderOperation:newUpdate	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   194: aload_3
    //   195: invokevirtual 195	android/content/ContentProviderOperation$Builder:withValues	(Landroid/content/ContentValues;)Landroid/content/ContentProviderOperation$Builder;
    //   198: invokevirtual 161	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   201: invokevirtual 164	bod:a	(Landroid/content/ContentProviderOperation;)Z
    //   204: pop
    //   205: new 423	java/lang/StringBuilder
    //   208: dup
    //   209: aload_2
    //   210: invokestatic 426	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   213: invokevirtual 429	java/lang/String:length	()I
    //   216: bipush 33
    //   218: iadd
    //   219: aload_1
    //   220: invokestatic 426	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   223: invokevirtual 429	java/lang/String:length	()I
    //   226: iadd
    //   227: invokespecial 432	java/lang/StringBuilder:<init>	(I)V
    //   230: ldc_w 484
    //   233: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: aload_2
    //   237: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: ldc_w 486
    //   243: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload_1
    //   247: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: invokevirtual 443	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: pop
    //   254: aload 4
    //   256: invokeinterface 459 1 0
    //   261: goto -261 -> 0
    //   264: astore_1
    //   265: aload 4
    //   267: invokeinterface 459 1 0
    //   272: aload_1
    //   273: athrow
    //   274: aload_0
    //   275: getfield 136	bob:l	I
    //   278: bipush 8
    //   280: if_icmpne +10 -> 290
    //   283: aload_0
    //   284: invokespecial 488	bob:l	()V
    //   287: goto -287 -> 0
    //   290: aload_0
    //   291: invokevirtual 138	bob:i	()V
    //   294: goto -294 -> 0
    //   297: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	this	bob
    //   30	217	1	str1	String
    //   264	9	1	localObject	Object
    //   28	209	2	str2	String
    //   26	169	3	localContentValues	ContentValues
    //   140	126	4	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   142	254	264	finally
  }
  
  public final void c()
  {
    int j = 0;
    Object localObject = a.j;
    h.a(SyncStateContract.Helpers.newSetOperation(ContactsContract.SyncState.CONTENT_URI, o, a.j.getBytes()));
    h.a(c);
    if ((h.e != null) && (h.e.length > 0))
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("dirty", Integer.valueOf(0));
      if (j < h.d)
      {
        int k = h.c[j];
        label137:
        String str;
        ContentResolver localContentResolver;
        Uri localUri;
        if (k < h.e.length)
        {
          localObject = h.e[k].uri;
          if (localObject != null)
          {
            str = ((Uri)localObject).getLastPathSegment();
            localContentResolver = d;
            localUri = a(ContactsContract.RawContacts.CONTENT_URI);
            localObject = String.valueOf("_id=");
            str = String.valueOf(str);
            if (str.length() == 0) {
              break label214;
            }
          }
        }
        label214:
        for (localObject = ((String)localObject).concat(str);; localObject = new String((String)localObject))
        {
          localContentResolver.update(localUri, localContentValues, (String)localObject, null);
          j += 1;
          break;
          localObject = null;
          break label137;
        }
      }
    }
  }
  
  protected final void e()
  {
    cvm.d("Exchange", "Wiping contacts for account %d", new Object[] { Long.valueOf(b.D) });
    bqw.a(c, b.d);
    Mailbox.a(c, new android.accounts.Account(b.d, bnq.c));
  }
}

/* Location:
 * Qualified Name:     bob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */