import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Entity;
import android.content.Entity.NamedContentValues;
import android.content.EntityIterator;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.Groups;
import android.provider.ContactsContract.RawContacts;
import android.provider.ContactsContract.RawContactsEntity;
import android.text.TextUtils;
import android.util.Base64;
import com.android.emailcommon.provider.Mailbox;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;

public final class bqw
  extends bqv
{
  private static final String[] a = { "title" };
  private static final String[] b = { "_id" };
  private static final int[] c = { 775, 776, 777 };
  private static final int[] d = { 91, 92, 93 };
  private static final int[] e = { 83, 76 };
  private static final int[] f = { 103, 96 };
  private static final int[] g = { 97, 98, 99, 100, 101 };
  private static final int[] h = { 77, 78, 79, 80, 81 };
  private static final int[] i = { 97, 110, 111, 112, 113 };
  private static final SimpleDateFormat n;
  private static final DateFormat[] o = { bnq.g, n };
  private final android.accounts.Account j;
  private final ArrayList<Long> k = new ArrayList();
  private final ArrayList<Long> l = new ArrayList();
  private bob m = null;
  
  static
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
    n = localSimpleDateFormat;
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
  }
  
  public bqw(String paramString)
  {
    j = new android.accounts.Account(paramString, bnq.c);
  }
  
  private static Uri a(Uri paramUri, String paramString)
  {
    return paramUri.buildUpon().appendQueryParameter("account_name", paramString).appendQueryParameter("account_type", bnq.c).appendQueryParameter("caller_is_syncadapter", "true").build();
  }
  
  private static String a(ContentValues paramContentValues, String paramString)
  {
    if ((paramContentValues == null) || (paramString == null)) {
      paramContentValues = null;
    }
    do
    {
      return paramContentValues;
      if (!paramContentValues.containsKey(paramString)) {
        break;
      }
      paramString = paramContentValues.getAsString(paramString);
      paramContentValues = paramString;
    } while (!TextUtils.isEmpty(paramString));
    return null;
  }
  
  private static String a(ContentValues paramContentValues, ArrayList<ContentValues> paramArrayList)
  {
    String str1 = a(paramContentValues, "data2");
    String str3 = a(paramContentValues, "data3");
    String str2 = a(paramContentValues, "data5");
    paramContentValues = a(paramContentValues, "data6");
    if ((str1 == null) && (str3 == null))
    {
      paramContentValues = paramArrayList.iterator();
      while (paramContentValues.hasNext())
      {
        paramArrayList = a((ContentValues)paramContentValues.next(), "data1");
        if (paramArrayList != null) {
          return paramArrayList;
        }
      }
      return null;
    }
    paramArrayList = new StringBuilder();
    if (str3 != null)
    {
      paramArrayList.append(str3);
      if (paramContentValues != null)
      {
        paramContentValues = String.valueOf(paramContentValues);
        if (paramContentValues.length() == 0) {
          break label167;
        }
      }
    }
    label167:
    for (paramContentValues = " ".concat(paramContentValues);; paramContentValues = new String(" "))
    {
      paramArrayList.append(paramContentValues);
      paramArrayList.append(", ");
      if (str1 != null) {
        paramArrayList.append(String.valueOf(str1).concat(" "));
      }
      if (str2 != null) {
        paramArrayList.append(str2);
      }
      return paramArrayList.toString().trim();
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    try
    {
      if (paramContext.getPackageManager().checkPermission("android.permission.READ_CONTACTS", paramContext.getPackageName()) == 0)
      {
        bus.a("contacts_wipe", "enabled");
        paramContext.getContentResolver().delete(a(ContactsContract.RawContacts.CONTENT_URI, paramString), null, null);
        return;
      }
      cvm.d("Exchange", "unable to wipe contacts, permission disabled", new Object[0]);
      bus.a("contacts_wipe", "disabled");
      return;
    }
    catch (IllegalArgumentException paramContext)
    {
      cvm.e("Exchange", "ContactsProvider disabled; unable to wipe account.", new Object[0]);
    }
  }
  
  private final void a(bpi parambpi, ContentResolver paramContentResolver, com.android.emailcommon.provider.Account paramAccount, Mailbox paramMailbox, double paramDouble)
  {
    Object localObject2 = d;
    Object localObject1 = paramContentResolver.query(a(ContactsContract.Groups.CONTENT_URI, (String)localObject2), b, "dirty=1", null, null);
    Object localObject3;
    Object localObject4;
    long l1;
    if (localObject1 != null)
    {
      try
      {
        if (((Cursor)localObject1).getCount() <= 0) {
          break label178;
        }
        localObject3 = new String[1];
        localObject4 = new ContentValues();
        while (((Cursor)localObject1).moveToNext())
        {
          l1 = ((Cursor)localObject1).getLong(0);
          ((ContentValues)localObject4).put("data1", Long.valueOf(l1));
          localObject3[0] = Long.toString(l1);
          paramContentResolver.update(ContactsContract.Data.CONTENT_URI, (ContentValues)localObject4, "mimetype='vnd.android.cursor.item/group_membership' AND data1=?", (String[])localObject3);
        }
        paramContentResolver.delete(a(ContactsContract.Groups.CONTENT_URI, (String)localObject2), "deleted=1", null);
      }
      finally
      {
        ((Cursor)localObject1).close();
      }
      ((ContentValues)localObject4).clear();
      ((ContentValues)localObject4).put("dirty", Integer.valueOf(0));
      paramContentResolver.update(a(ContactsContract.Groups.CONTENT_URI, (String)localObject2), (ContentValues)localObject4, null, null);
      label178:
      ((Cursor)localObject1).close();
    }
    paramAccount = paramContentResolver.query(a(ContactsContract.RawContactsEntity.CONTENT_URI, d), null, "dirty=1", null, null);
    if (paramAccount == null) {
      return;
    }
    EntityIterator localEntityIterator = ContactsContract.RawContacts.newEntityIterator(paramAccount);
    ContentValues localContentValues1 = new ContentValues();
    boolean bool1 = false;
    ContentValues localContentValues2;
    ArrayList localArrayList1;
    int i2;
    label326:
    int i4;
    ArrayList localArrayList2;
    int i3;
    for (;;)
    {
      int i5;
      try
      {
        Uri localUri = ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").build();
        i1 = 1;
        if (!localEntityIterator.hasNext()) {
          break label2538;
        }
        localObject1 = (Entity)localEntityIterator.next();
        localContentValues2 = ((Entity)localObject1).getEntityValues();
        paramAccount = localContentValues2.getAsString("sourceid");
        localArrayList1 = new ArrayList();
        if (i1 == 0) {
          break label2556;
        }
        parambpi.a(22);
        cvm.b("Exchange", "Sending Contacts changes to the server", new Object[0]);
        i2 = 0;
        if (paramAccount == null)
        {
          l1 = D;
          long l2 = System.currentTimeMillis();
          paramAccount = 45 + "new_" + l1 + "_" + l2;
          cvm.b("Exchange", "Creating new contact with clientId: %s", new Object[] { paramAccount });
          parambpi.a(7).b(12, paramAccount);
          localContentValues1.put("sync1", paramAccount);
          paramContentResolver.update(ContentUris.withAppendedId(localUri, localContentValues2.getAsLong("_id").longValue()), localContentValues1, null, null);
          parambpi.a(29);
          i4 = 0;
          i5 = 0;
          localArrayList2 = new ArrayList();
          localObject4 = ((Entity)localObject1).getSubValues().iterator();
          localObject1 = null;
          i3 = 0;
          label479:
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
          localObject3 = nextvalues;
          localObject2 = ((ContentValues)localObject3).getAsString("mimetype");
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label657;
          }
          cvm.c("Exchange", "Contacts upsync, unknown data: no mimetype set", new Object[0]);
          continue;
        }
        if (localContentValues2.getAsInteger("deleted").intValue() != 1) {
          break label620;
        }
      }
      finally
      {
        localEntityIterator.close();
      }
      cvm.b("Exchange", "Deleting contact with serverId: %s", new Object[] { paramAccount });
      parambpi.a(9).b(13, paramAccount).b();
      k.add(localContentValues2.getAsLong("_id"));
      i1 = i2;
      continue;
      label620:
      cvm.b("Exchange", "Upsync change to contact with serverId: %s", new Object[] { paramAccount });
      parambpi.a(8).b(13, paramAccount);
      bool1 = true;
      continue;
      label657:
      i1 = -1;
      switch (((String)localObject2).hashCode())
      {
      case -1569536764: 
        cvm.c("Exchange", "Contacts upsync, unknown data: %s", new Object[] { localObject2 });
        continue;
        if (!((String)localObject2).equals("vnd.android.cursor.item/email_v2")) {
          break label2581;
        }
        i1 = 0;
        break;
      case 2034973555: 
        if (!((String)localObject2).equals("vnd.android.cursor.item/nickname")) {
          break label2581;
        }
        i1 = 1;
        break;
      case 2078597740: 
        if (!((String)localObject2).equals("vnd.android.cursor.item/eas_children")) {
          break label2581;
        }
        i1 = 2;
        break;
      case -727759827: 
        if (!((String)localObject2).equals("vnd.android.cursor.item/eas_business")) {
          break label2581;
        }
        i1 = 3;
        break;
      case 456415478: 
        if (!((String)localObject2).equals("vnd.android.cursor.item/website")) {
          break label2581;
        }
        i1 = 4;
        break;
      case 862235309: 
        if (!((String)localObject2).equals("vnd.android.cursor.item/eas_personal")) {
          break label2581;
        }
        i1 = 5;
        break;
      case 684173810: 
        if (!((String)localObject2).equals("vnd.android.cursor.item/phone_v2")) {
          break label2581;
        }
        i1 = 6;
        break;
      case 1409846529: 
        if (!((String)localObject2).equals("vnd.android.cursor.item/relation")) {
          break label2581;
        }
        i1 = 7;
        break;
      case -1079224304: 
        if (!((String)localObject2).equals("vnd.android.cursor.item/name")) {
          break label2581;
        }
        i1 = 8;
        break;
      case -601229436: 
        if (!((String)localObject2).equals("vnd.android.cursor.item/postal-address_v2")) {
          break label2581;
        }
        i1 = 9;
        break;
      case 689862072: 
        if (!((String)localObject2).equals("vnd.android.cursor.item/organization")) {
          break label2581;
        }
        i1 = 10;
        break;
      case 950831081: 
        if (!((String)localObject2).equals("vnd.android.cursor.item/im")) {
          break label2581;
        }
        i1 = 11;
        break;
      case -1328682538: 
        if (!((String)localObject2).equals("vnd.android.cursor.item/contact_event")) {
          break label2581;
        }
        i1 = 12;
        break;
      case 1464725403: 
        if (!((String)localObject2).equals("vnd.android.cursor.item/group_membership")) {
          break label2581;
        }
        i1 = 13;
        break;
      case -1079210633: 
        if (!((String)localObject2).equals("vnd.android.cursor.item/note")) {
          break label2581;
        }
        i1 = 14;
        break;
      case 905843021: 
        if (!((String)localObject2).equals("vnd.android.cursor.item/photo")) {
          break label2581;
        }
        i1 = 15;
        break label2581;
        localArrayList2.add(localObject3);
        continue;
        a(parambpi, (ContentValues)localObject3, "data1", 781);
        continue;
        a(parambpi, (ContentValues)localObject3);
        continue;
        a(parambpi, (ContentValues)localObject3, "data8", 780);
        a(parambpi, (ContentValues)localObject3, "data6", 773);
        a(parambpi, (ContentValues)localObject3, "data7", 774);
        continue;
        a(parambpi, (ContentValues)localObject3, "data1", 119);
        continue;
        a(parambpi, (ContentValues)localObject3, "data2", 69);
        bool1 = a(parambpi, (ContentValues)localObject3, "data4", 94);
        continue;
        localObject2 = ((ContentValues)localObject3).getAsString("data1");
        if ((localObject2 == null) || (!((ContentValues)localObject3).containsKey("data2"))) {}
        label1249:
        while (((ContentValues)localObject3).containsKey("data2"))
        {
          i1 = ((ContentValues)localObject3).getAsInteger("data2").intValue();
          if (i1 != 1) {
            break label2666;
          }
          i5 += 1;
          break;
          switch (((ContentValues)localObject3).getAsInteger("data2").intValue())
          {
          case 1: 
            if (i5 < 2) {
              parambpi.b(f[i5], (String)localObject2);
            }
            break;
          case 3: 
            if (i3 < 2) {
              parambpi.b(e[i3], (String)localObject2);
            }
            break;
          case 20: 
            parambpi.b(782, (String)localObject2);
            break;
          case 19: 
            parambpi.b(71, (String)localObject2);
            break;
          case 4: 
            parambpi.b(82, (String)localObject2);
            break;
          case 10: 
            parambpi.b(779, (String)localObject2);
            break;
          case 2: 
            parambpi.b(107, (String)localObject2);
            break;
          case 9: 
            parambpi.b(84, (String)localObject2);
            break;
          case 6: 
            parambpi.b(114, (String)localObject2);
            break;
          case 14: 
            parambpi.b(115, (String)localObject2);
            break;
          case 5: 
            parambpi.b(102, (String)localObject2);
          }
        }
        localObject2 = ((ContentValues)localObject3).getAsString("data1");
        if ((localObject2 != null) && (((ContentValues)localObject3).containsKey("data2"))) {
          switch (((ContentValues)localObject3).getAsInteger("data2").intValue())
          {
          case 1: 
            parambpi.b(70, (String)localObject2);
            break;
          case 7: 
            parambpi.b(778, (String)localObject2);
            break;
          case 14: 
            parambpi.b(116, (String)localObject2);
            continue;
            a(parambpi, (ContentValues)localObject3, "data3", 105);
            a(parambpi, (ContentValues)localObject3, "data2", 95);
            a(parambpi, (ContentValues)localObject3, "data5", 106);
            a(parambpi, (ContentValues)localObject3, "data6", 117);
            a(parambpi, (ContentValues)localObject3, "data7", 121);
            a(parambpi, (ContentValues)localObject3, "data9", 122);
            a(parambpi, (ContentValues)localObject3, "data4", 118);
            localObject1 = localObject3;
            continue;
            if (((ContentValues)localObject3).containsKey("data2")) {
              switch (((ContentValues)localObject3).getAsInteger("data2").intValue())
              {
              case 1: 
                a(parambpi, (ContentValues)localObject3, g);
                break;
              case 2: 
                a(parambpi, (ContentValues)localObject3, h);
                break;
              case 3: 
                a(parambpi, (ContentValues)localObject3, i);
                continue;
                a(parambpi, (ContentValues)localObject3, "data4", 104);
                a(parambpi, (ContentValues)localObject3, "data1", 89);
                a(parambpi, (ContentValues)localObject3, "data5", 90);
                a(parambpi, (ContentValues)localObject3, "data9", 108);
                continue;
                localObject2 = ((ContentValues)localObject3).getAsString("data1");
                if ((localObject2 == null) || (i4 >= 3)) {
                  break label2691;
                }
                parambpi.b(c[i4], (String)localObject2);
                break label2691;
                if (((ContentValues)localObject3).containsKey("data2"))
                {
                  localObject2 = ((ContentValues)localObject3).getAsInteger("data2");
                  if ((localObject2 != null) && (((Integer)localObject2).equals(Integer.valueOf(3))))
                  {
                    b(parambpi, (ContentValues)localObject3);
                    continue;
                    localArrayList1.add(((ContentValues)localObject3).getAsInteger("data1"));
                    continue;
                    localObject2 = "";
                    if (((ContentValues)localObject3).containsKey("data1")) {
                      localObject2 = ((ContentValues)localObject3).getAsString("data1").replaceAll("\n", "\r\n");
                    }
                    if (paramDouble >= 12.0D)
                    {
                      parambpi.a(1098);
                      parambpi.b(1094, "1").b(1099, (String)localObject2);
                      parambpi.b();
                    }
                    else
                    {
                      parambpi.b(73, (String)localObject2);
                      continue;
                      if (((ContentValues)localObject3).containsKey("data15")) {
                        parambpi.b(124, Base64.encodeToString(((ContentValues)localObject3).getAsByteArray("data15"), 2));
                      } else {
                        parambpi.b(124);
                      }
                    }
                  }
                }
                break;
              }
            }
            break;
          }
        }
        break;
      }
    }
    Iterator localIterator = localArrayList2.iterator();
    int i1 = 0;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject3 = (ContentValues)localIterator.next();
        localObject2 = ((ContentValues)localObject3).getAsString("data1");
        localObject4 = ((ContentValues)localObject3).getAsString("data4");
        localObject3 = localObject4;
        if (localObject4 != null) {
          break label2700;
        }
        localObject3 = localObject2;
      }
      for (;;)
      {
        label2169:
        if (i1 >= 3) {
          break label2717;
        }
        parambpi.b(d[i1], (String)localObject2);
        break label2717;
        label2508:
        label2538:
        label2556:
        label2563:
        label2566:
        label2569:
        label2581:
        label2666:
        label2678:
        label2691:
        label2700:
        do
        {
          localObject2 = String.valueOf(localObject3).length() + 5 + String.valueOf(localObject2).length() + "\"" + (String)localObject3 + "\" <" + (String)localObject2 + ">";
          break label2169;
          if (!bool1)
          {
            localObject2 = ContactsContract.RawContacts.CONTENT_URI;
            paramAccount = String.valueOf(paramAccount);
            localObject2 = paramContentResolver.query((Uri)localObject2, new String[] { "display_name_alt" }, "sync1=?", new String[] { paramAccount }, null);
          }
          for (;;)
          {
            try
            {
              if (!((Cursor)localObject2).moveToNext()) {
                break label2569;
              }
              paramAccount = ((Cursor)localObject2).getString(0);
              if (paramAccount == null) {
                continue;
              }
              boolean bool2 = TextUtils.isEmpty(paramAccount);
              if (bool2) {
                continue;
              }
              ((Cursor)localObject2).close();
              localObject2 = paramAccount;
              if (paramAccount == null) {
                localObject2 = a((ContentValues)localObject1, localArrayList2);
              }
              if (localObject2 != null) {
                parambpi.b(94, (String)localObject2);
              }
              if (localArrayList1.isEmpty()) {
                break label2508;
              }
              i1 = 1;
              localObject1 = localArrayList1.iterator();
            }
            finally
            {
              try
              {
                if (!paramAccount.moveToFirst()) {
                  break label2566;
                }
                if (i1 == 0) {
                  break label2563;
                }
                parambpi.a(85);
                i1 = 0;
                parambpi.b(86, paramAccount.getString(0));
                paramAccount.close();
                continue;
              }
              finally
              {
                paramAccount.close();
              }
              parambpi = finally;
              ((Cursor)localObject2).close();
            }
            if (((Iterator)localObject1).hasNext())
            {
              i3 = ((Integer)((Iterator)localObject1).next()).intValue();
              paramAccount = paramContentResolver.query(ContentUris.withAppendedId(ContactsContract.Groups.CONTENT_URI, i3), a, null, null, null);
            }
            if (i1 == 0) {
              parambpi.b();
            }
            parambpi.b().b();
            l.add(localContentValues2.getAsLong("_id"));
            i1 = i2;
            break;
            if (i1 == 0) {
              parambpi.b();
            }
            localEntityIterator.close();
            return;
            i2 = i1;
            break label326;
            continue;
            continue;
            paramAccount = null;
          }
          do
          {
            i1 = i3;
            break label2678;
            switch (i1)
            {
            }
            break;
            break label1249;
          } while (i1 != 3);
          i1 = i3 + 1;
          i3 = i1;
          break label479;
          break label479;
          break label479;
          i4 += 1;
          break label479;
          if (localObject2 == null) {
            break label2717;
          }
        } while (paramDouble >= 12.0D);
      }
      label2717:
      i1 += 1;
    }
  }
  
  private static void a(bpi parambpi, ContentValues paramContentValues)
  {
    int i1 = 1;
    int i3 = 0;
    while (i3 < 8)
    {
      String str = bqx.a[i3];
      int i2 = i1;
      if (paramContentValues.containsKey(str))
      {
        i2 = i1;
        if (i1 != 0)
        {
          parambpi.a(87);
          i2 = 0;
        }
        parambpi.b(88, paramContentValues.getAsString(str));
      }
      i3 += 1;
      i1 = i2;
    }
    if (i1 == 0) {
      parambpi.b();
    }
  }
  
  private static void a(bpi parambpi, ContentValues paramContentValues, int[] paramArrayOfInt)
  {
    a(parambpi, paramContentValues, "data7", paramArrayOfInt[0]);
    a(parambpi, paramContentValues, "data10", paramArrayOfInt[1]);
    a(parambpi, paramContentValues, "data9", paramArrayOfInt[2]);
    a(parambpi, paramContentValues, "data8", paramArrayOfInt[3]);
    a(parambpi, paramContentValues, "data4", paramArrayOfInt[4]);
  }
  
  private static boolean a(bpi parambpi, ContentValues paramContentValues, String paramString, int paramInt)
  {
    paramContentValues = a(paramContentValues, paramString);
    if (paramContentValues != null)
    {
      parambpi.b(paramInt, paramContentValues);
      return true;
    }
    return false;
  }
  
  private static void b(bpi parambpi, ContentValues paramContentValues)
  {
    DateFormat[] arrayOfDateFormat;
    int i2;
    int i1;
    if (paramContentValues.containsKey("data1"))
    {
      paramContentValues = paramContentValues.getAsString("data1");
      if (!TextUtils.isEmpty(paramContentValues))
      {
        arrayOfDateFormat = o;
        i2 = arrayOfDateFormat.length;
        i1 = 0;
      }
    }
    for (;;)
    {
      Object localObject;
      if (i1 < i2) {
        localObject = arrayOfDateFormat[i1];
      }
      try
      {
        localObject = ((DateFormat)localObject).parse(paramContentValues);
        if (localObject != null)
        {
          parambpi.b(72, bnq.g.format((Date)localObject));
          return;
        }
      }
      catch (ParseException localParseException)
      {
        i1 += 1;
      }
    }
  }
  
  public final int a()
  {
    return 262144;
  }
  
  public final bnx a(Context paramContext, com.android.emailcommon.provider.Account paramAccount, Mailbox paramMailbox, InputStream paramInputStream)
  {
    m = new bob(paramContext, paramContext.getContentResolver(), paramInputStream, paramMailbox, paramAccount, j);
    return m;
  }
  
  public final void a(Context paramContext, bpi parambpi, double paramDouble, com.android.emailcommon.provider.Account paramAccount, Mailbox paramMailbox, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      parambpi.a(32);
      parambpi.b(95);
      parambpi.b(105);
      parambpi.b(106);
      parambpi.b(117);
      parambpi.b(89);
      parambpi.b(104);
      parambpi.b(91);
      parambpi.b(92);
      parambpi.b(93);
      parambpi.b(76);
      parambpi.b(83);
      parambpi.b(782);
      parambpi.b(82);
      parambpi.b(779);
      parambpi.b(102);
      parambpi.b(103);
      parambpi.b(96);
      parambpi.b(107);
      parambpi.b(84);
      parambpi.b(115);
      parambpi.b(114);
      parambpi.b(71);
      parambpi.b(775);
      parambpi.b(776);
      parambpi.b(777);
      parambpi.b(77);
      parambpi.b(78);
      parambpi.b(79);
      parambpi.b(80);
      parambpi.b(81);
      parambpi.b(97);
      parambpi.b(98);
      parambpi.b(99);
      parambpi.b(100);
      parambpi.b(101);
      parambpi.b(109);
      parambpi.b(110);
      parambpi.b(111);
      parambpi.b(112);
      parambpi.b(113);
      parambpi.b(120);
      parambpi.b(121);
      parambpi.b(122);
      parambpi.b(781);
      parambpi.b(70);
      parambpi.b(778);
      parambpi.b(116);
      parambpi.b(90);
      parambpi.b(118);
      parambpi.b(108);
      parambpi.b(773);
      parambpi.b(774);
      parambpi.b(780);
      parambpi.b(69);
      parambpi.b(72);
      parambpi.b(119);
      parambpi.b(124);
      parambpi.b(94);
      parambpi.b();
      return;
    }
    paramInt *= 10;
    if (paramInt > 522) {
      throw new IOException("Max window size reached and still no data");
    }
    if (paramInt < 512) {}
    for (;;)
    {
      a(parambpi, null, paramDouble, paramInt);
      a(parambpi, paramContext.getContentResolver(), paramAccount, paramMailbox, paramDouble);
      return;
      paramInt = 512;
    }
  }
  
  public final void a(Context paramContext, com.android.emailcommon.provider.Account paramAccount)
  {
    ContentResolver localContentResolver = paramContext.getContentResolver();
    Object localObject1 = new bod();
    Object localObject2 = l.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Long)((Iterator)localObject2).next();
      ((bod)localObject1).a(ContentProviderOperation.newUpdate(ContentUris.withAppendedId(ContactsContract.RawContacts.CONTENT_URI, ((Long)localObject3).longValue()).buildUpon().appendQueryParameter("caller_is_syncadapter", "true").build()).withValue("dirty", Integer.valueOf(0)).build());
    }
    localObject2 = k.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Long)((Iterator)localObject2).next();
      ((bod)localObject1).a(ContentProviderOperation.newDelete(ContentUris.withAppendedId(ContactsContract.RawContacts.CONTENT_URI, ((Long)localObject3).longValue()).buildUpon().appendQueryParameter("caller_is_syncadapter", "true").build()).build());
    }
    ((bod)localObject1).a(paramContext);
    if ((m != null) && (m.i))
    {
      localObject1 = a(ContactsContract.Groups.CONTENT_URI, d);
      paramContext = localContentResolver.query((Uri)localObject1, new String[] { "sourceid", "title" }, "title IS NULL", null, null);
      localObject2 = new ContentValues();
      ((ContentValues)localObject2).put("group_visible", Integer.valueOf(1));
      try
      {
        if (paramContext.moveToNext())
        {
          localObject3 = paramContext.getString(0);
          ((ContentValues)localObject2).put("title", (String)localObject3);
          localContentResolver.update(a((Uri)localObject1, d), (ContentValues)localObject2, "sourceid=?", new String[] { localObject3 });
        }
        return;
      }
      finally
      {
        paramContext.close();
      }
    }
  }
}

/* Location:
 * Qualified Name:     bqw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */