import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.Contacts;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.TextAppearanceSpan;
import android.util.SparseArray;
import com.android.emailcommon.mail.Address;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.providers.Message;
import com.android.mail.providers.Settings;
import com.android.mail.utils.NotificationActionUtils;
import com.android.mail.utils.NotificationActionUtils.NotificationAction;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class cvz
{
  private static cwg a = null;
  private static final SparseArray<Bitmap> b = new SparseArray();
  private static WeakReference<Bitmap> c = new WeakReference(null);
  private static TextAppearanceSpan d;
  private static CharacterStyle e;
  private static mx f = mx.a();
  private static final oi<cwf, SparseArray<cwd>> g = new oi();
  private static final oi<cwf, Set<cwc>> h = new oi();
  private static String i = null;
  private static String j = null;
  
  public static int a(android.accounts.Account paramAccount, Folder paramFolder)
  {
    return paramAccount.hashCode() ^ 0x1 ^ paramFolder.hashCode();
  }
  
  private static PendingIntent a(Context paramContext, Intent paramIntent)
  {
    paramIntent.putExtra("notification", true);
    paramContext = PendingIntent.getActivity(paramContext, -1, paramIntent, 134217728);
    paramIntent.removeExtra("notification");
    return paramContext;
  }
  
  private static Intent a(Context paramContext, com.android.mail.providers.Account paramAccount, Folder paramFolder, Cursor paramCursor)
  {
    if ((paramFolder == null) || (paramAccount == null))
    {
      cvm.e("NotifUtils", "createViewConversationIntent(): Null account or folder.  account: %s folder: %s", new Object[] { paramAccount, paramFolder });
      return null;
    }
    if (paramCursor == null) {
      return cxa.a(paramContext, c.b, paramAccount);
    }
    return cxa.a(paramContext, new Conversation(paramCursor), c.b, paramAccount);
  }
  
  private static Bitmap a(Context paramContext, String paramString)
  {
    Iterator localIterator = null;
    Object localObject = a(paramContext, Collections.singletonList(paramString));
    paramString = localIterator;
    if (localObject != null)
    {
      localIterator = ((List)localObject).iterator();
      paramString = null;
    }
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      localObject = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, l);
      localObject = ContactsContract.Contacts.openContactPhotoInputStream(paramContext.getContentResolver(), (Uri)localObject, true);
      if (localObject != null) {
        try
        {
          paramString = BitmapFactory.decodeStream((InputStream)localObject);
          if (paramString != null) {
            return paramString;
          }
          hka.a((InputStream)localObject);
        }
        finally
        {
          hka.a((InputStream)localObject);
        }
      }
    }
    return paramString;
  }
  
  private static SpannableString a(CharacterStyle[] paramArrayOfCharacterStyle, CharSequence paramCharSequence)
  {
    paramCharSequence = new SpannableString(paramCharSequence);
    if ((paramArrayOfCharacterStyle != null) && (paramArrayOfCharacterStyle.length > 0)) {
      paramCharSequence.setSpan(paramArrayOfCharacterStyle[0], 0, paramCharSequence.length(), 0);
    }
    return paramCharSequence;
  }
  
  private static SpannableStringBuilder a(Context paramContext, Cursor paramCursor, int paramInt, com.android.mail.providers.Account paramAccount)
  {
    paramCursor = Conversationt;
    ArrayList localArrayList = new ArrayList();
    if (d == null)
    {
      d = new TextAppearanceSpan(paramContext, buk.j);
      e = new TextAppearanceSpan(paramContext, buk.i);
    }
    bzn localbzn = new bzn(paramContext);
    bzt.a(localbzn, paramCursor, "", paramInt, localArrayList, null, null, paramAccount, d, e, false);
    return a(paramContext, localbzn, localArrayList);
  }
  
  private static SpannableStringBuilder a(Context paramContext, bzn parambzn, ArrayList<SpannableString> paramArrayList)
  {
    if (i == null)
    {
      i = paramContext.getString(buj.eF);
      j = paramContext.getString(buj.bt);
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Iterator localIterator = paramArrayList.iterator();
    paramContext = null;
    while (localIterator.hasNext())
    {
      paramArrayList = (SpannableString)localIterator.next();
      if (paramArrayList == null)
      {
        cvm.e("NotifUtils", "null sender iterating over styledSenders", new Object[0]);
      }
      else
      {
        CharacterStyle[] arrayOfCharacterStyle = (CharacterStyle[])paramArrayList.getSpans(0, paramArrayList.length(), CharacterStyle.class);
        String str1;
        if (D.equals(paramArrayList.toString()))
        {
          paramContext = j;
          str1 = String.valueOf(paramArrayList);
          String str2 = j;
          paramContext = a(arrayOfCharacterStyle, String.valueOf(paramContext).length() + 0 + String.valueOf(str1).length() + String.valueOf(str2).length() + paramContext + str1 + str2);
        }
        for (;;)
        {
          localSpannableStringBuilder.append(paramContext);
          paramContext = paramArrayList;
          break;
          if ((localSpannableStringBuilder.length() > 0) && ((paramContext == null) || (!D.equals(paramContext.toString()))))
          {
            paramContext = i;
            str1 = String.valueOf(paramArrayList);
            paramContext = a(arrayOfCharacterStyle, String.valueOf(paramContext).length() + 0 + String.valueOf(str1).length() + paramContext + str1);
          }
          else
          {
            paramContext = paramArrayList;
          }
        }
      }
    }
    return localSpannableStringBuilder;
  }
  
  /* Error */
  private static cwa a(Context paramContext, com.android.mail.providers.Account paramAccount, cfk paramcfk, hf paramhf, ht paramht, Set<cwc> paramSet, Cursor paramCursor, Intent paramIntent, Folder paramFolder, long paramLong, Resources paramResources, boolean paramBoolean, String paramString, int paramInt, cfb paramcfb)
  {
    // Byte code:
    //   0: new 306	cwa
    //   3: dup
    //   4: invokespecial 307	cwa:<init>	()V
    //   7: astore 24
    //   9: new 118	com/android/mail/providers/Conversation
    //   12: dup
    //   13: aload 6
    //   15: invokespecial 121	com/android/mail/providers/Conversation:<init>	(Landroid/database/Cursor;)V
    //   18: astore 26
    //   20: new 309	java/util/HashSet
    //   23: dup
    //   24: invokespecial 310	java/util/HashSet:<init>	()V
    //   27: astore 25
    //   29: aload 26
    //   31: getfield 312	com/android/mail/providers/Conversation:g	Landroid/net/Uri;
    //   34: invokevirtual 318	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   37: ldc_w 320
    //   40: aload 8
    //   42: getfield 322	com/android/mail/providers/Folder:b	Ljava/lang/String;
    //   45: invokevirtual 328	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   48: invokevirtual 332	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   51: astore 20
    //   53: aload_0
    //   54: invokevirtual 173	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   57: aload 20
    //   59: getstatic 338	chh:n	[Ljava/lang/String;
    //   62: aconst_null
    //   63: aconst_null
    //   64: aconst_null
    //   65: invokevirtual 344	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   68: astore 20
    //   70: new 346	byw
    //   73: dup
    //   74: aload 20
    //   76: invokespecial 347	byw:<init>	(Landroid/database/Cursor;)V
    //   79: astore 21
    //   81: aload 21
    //   83: invokevirtual 350	byw:getCount	()I
    //   86: iconst_1
    //   87: isub
    //   88: istore 17
    //   90: aload 21
    //   92: invokevirtual 353	byw:moveToLast	()Z
    //   95: ifeq +1205 -> 1300
    //   98: aload 21
    //   100: invokevirtual 356	byw:a	()Lcom/android/mail/browse/ConversationMessage;
    //   103: invokestatic 359	cvz:a	(Lcom/android/mail/providers/Message;)Ljava/lang/String;
    //   106: astore 22
    //   108: iload 17
    //   110: istore 18
    //   112: iconst_0
    //   113: istore 17
    //   115: iconst_0
    //   116: istore 16
    //   118: aload 21
    //   120: invokevirtual 356	byw:a	()Lcom/android/mail/browse/ConversationMessage;
    //   123: astore 23
    //   125: aload 23
    //   127: getfield 365	com/android/mail/providers/Message:C	Z
    //   130: ifne +694 -> 824
    //   133: iconst_1
    //   134: istore 19
    //   136: iload 19
    //   138: ifeq +1143 -> 1281
    //   141: iload 17
    //   143: ifne +28 -> 171
    //   146: aload 5
    //   148: new 367	cwc
    //   151: dup
    //   152: aload 26
    //   154: getfield 370	com/android/mail/providers/Conversation:b	J
    //   157: aload 23
    //   159: getfield 372	com/android/mail/providers/Message:e	Ljava/lang/String;
    //   162: invokespecial 375	cwc:<init>	(JLjava/lang/String;)V
    //   165: invokeinterface 380 2 0
    //   170: pop
    //   171: aload 21
    //   173: invokevirtual 383	byw:getPosition	()I
    //   176: istore 19
    //   178: aload 23
    //   180: getfield 384	com/android/mail/providers/Message:j	Ljava/lang/String;
    //   183: aload 25
    //   185: invokestatic 387	cvz:a	(Ljava/lang/String;Ljava/util/HashSet;)V
    //   188: iload 16
    //   190: istore 18
    //   192: iload 16
    //   194: ifne +1115 -> 1309
    //   197: iload 16
    //   199: istore 18
    //   201: aload 22
    //   203: aload 23
    //   205: invokestatic 359	cvz:a	(Lcom/android/mail/providers/Message;)Ljava/lang/String;
    //   208: invokevirtual 388	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   211: ifne +1098 -> 1309
    //   214: iconst_1
    //   215: istore 18
    //   217: goto +1092 -> 1309
    //   220: aload 21
    //   222: invokevirtual 391	byw:moveToPrevious	()Z
    //   225: ifne +1037 -> 1262
    //   228: aload 21
    //   230: iload 17
    //   232: invokevirtual 395	byw:moveToPosition	(I)Z
    //   235: ifeq +1020 -> 1255
    //   238: aload 21
    //   240: invokevirtual 356	byw:a	()Lcom/android/mail/browse/ConversationMessage;
    //   243: astore 27
    //   245: aload 27
    //   247: invokestatic 359	cvz:a	(Lcom/android/mail/providers/Message;)Ljava/lang/String;
    //   250: astore 23
    //   252: aload 23
    //   254: invokestatic 398	cvz:b	(Ljava/lang/String;)Ljava/lang/String;
    //   257: astore 22
    //   259: aload_1
    //   260: invokevirtual 403	com/android/mail/providers/Account:c	()Landroid/accounts/Account;
    //   263: getfield 406	android/accounts/Account:name	Ljava/lang/String;
    //   266: astore 28
    //   268: aconst_null
    //   269: astore 5
    //   271: aload 23
    //   273: invokestatic 411	com/android/emailcommon/mail/Address:c	(Ljava/lang/String;)Lcom/android/emailcommon/mail/Address;
    //   276: astore 29
    //   278: aload 29
    //   280: ifnull +10 -> 290
    //   283: aload 29
    //   285: getfield 413	com/android/emailcommon/mail/Address:a	Ljava/lang/String;
    //   288: astore 5
    //   290: aload 5
    //   292: invokestatic 419	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   295: ifeq +957 -> 1252
    //   298: aload 23
    //   300: astore 5
    //   302: aload 24
    //   304: aload_0
    //   305: aload 28
    //   307: aload 22
    //   309: aload 5
    //   311: aload 15
    //   313: invokestatic 423	cxd:d	()Z
    //   316: aload 27
    //   318: invokevirtual 426	com/android/mail/providers/Message:r	()I
    //   321: invokestatic 429	cvz:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcfb;ZI)Lcwb;
    //   324: putfield 432	cwa:b	Lcwb;
    //   327: aload_3
    //   328: aload 24
    //   330: getfield 432	cwa:b	Lcwb;
    //   333: getfield 437	cwb:a	Landroid/graphics/Bitmap;
    //   336: putfield 441	hf:g	Landroid/graphics/Bitmap;
    //   339: aload 22
    //   341: astore 5
    //   343: aload_0
    //   344: aload 26
    //   346: getfield 443	com/android/mail/providers/Conversation:d	Ljava/lang/String;
    //   349: invokestatic 448	com/android/mail/browse/ConversationItemView:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   352: astore 15
    //   354: invokestatic 450	cxd:a	()Z
    //   357: ifeq +715 -> 1072
    //   360: iload 18
    //   362: ifeq +468 -> 830
    //   365: aload_0
    //   366: aload 6
    //   368: aload 11
    //   370: getstatic 455	bud:G	I
    //   373: invokevirtual 461	android/content/res/Resources:getInteger	(I)I
    //   376: aload_1
    //   377: invokestatic 463	cvz:a	(Landroid/content/Context;Landroid/database/Cursor;ILcom/android/mail/providers/Account;)Landroid/text/SpannableStringBuilder;
    //   380: astore 5
    //   382: aload_3
    //   383: aload 5
    //   385: invokevirtual 466	hf:a	(Ljava/lang/CharSequence;)Lhf;
    //   388: pop
    //   389: aload 24
    //   391: aload 5
    //   393: invokevirtual 467	android/text/SpannableStringBuilder:toString	()Ljava/lang/String;
    //   396: putfield 468	cwa:a	Ljava/lang/String;
    //   399: new 213	android/text/style/TextAppearanceSpan
    //   402: dup
    //   403: aload_0
    //   404: getstatic 470	buk:g	I
    //   407: invokespecial 221	android/text/style/TextAppearanceSpan:<init>	(Landroid/content/Context;I)V
    //   410: astore 5
    //   412: new 191	android/text/SpannableString
    //   415: dup
    //   416: aload 15
    //   418: invokespecial 194	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   421: astore 6
    //   423: aload 6
    //   425: aload 5
    //   427: iconst_0
    //   428: aload 15
    //   430: invokevirtual 287	java/lang/String:length	()I
    //   433: iconst_0
    //   434: invokevirtual 201	android/text/SpannableString:setSpan	(Ljava/lang/Object;III)V
    //   437: aload_3
    //   438: aload 6
    //   440: invokevirtual 472	hf:b	(Ljava/lang/CharSequence;)Lhf;
    //   443: pop
    //   444: iload 12
    //   446: ifeq +9 -> 455
    //   449: aload_1
    //   450: getfield 473	com/android/mail/providers/Account:a	Ljava/lang/String;
    //   453: astore 13
    //   455: aload_3
    //   456: aload 13
    //   458: invokevirtual 475	hf:c	(Ljava/lang/CharSequence;)Lhf;
    //   461: pop
    //   462: new 477	he
    //   465: dup
    //   466: aload_3
    //   467: invokespecial 480	he:<init>	(Lhf;)V
    //   470: astore 11
    //   472: aload 21
    //   474: iload 17
    //   476: invokevirtual 395	byw:moveToPosition	(I)Z
    //   479: ifeq +556 -> 1035
    //   482: aload 21
    //   484: invokevirtual 356	byw:a	()Lcom/android/mail/browse/ConversationMessage;
    //   487: astore 6
    //   489: ldc 96
    //   491: iconst_2
    //   492: invokestatic 483	cvm:a	(Ljava/lang/String;I)Z
    //   495: ifeq +35 -> 530
    //   498: ldc 96
    //   500: ldc_w 485
    //   503: iconst_2
    //   504: anewarray 4	java/lang/Object
    //   507: dup
    //   508: iconst_0
    //   509: aload 6
    //   511: getfield 487	com/android/mail/providers/Message:I	Landroid/net/Uri;
    //   514: aastore
    //   515: dup
    //   516: iconst_1
    //   517: aload 6
    //   519: getfield 489	com/android/mail/providers/Message:d	J
    //   522: invokestatic 492	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   525: aastore
    //   526: invokestatic 494	cvm:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   529: pop
    //   530: new 213	android/text/style/TextAppearanceSpan
    //   533: dup
    //   534: aload_0
    //   535: getstatic 470	buk:g	I
    //   538: invokespecial 221	android/text/style/TextAppearanceSpan:<init>	(Landroid/content/Context;I)V
    //   541: astore 13
    //   543: aload 6
    //   545: invokevirtual 496	com/android/mail/providers/Message:n	()Ljava/lang/String;
    //   548: invokestatic 500	cvb:a	(Ljava/lang/String;)Ljava/lang/String;
    //   551: astore 23
    //   553: aload 23
    //   555: invokestatic 419	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   558: ifne +323 -> 881
    //   561: aload 23
    //   563: ldc_w 502
    //   566: ldc_w 504
    //   569: invokevirtual 508	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   572: astore 5
    //   574: aload_0
    //   575: invokevirtual 512	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   578: astore 22
    //   580: aload 15
    //   582: invokestatic 419	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   585: ifeq +303 -> 888
    //   588: new 254	android/text/SpannableStringBuilder
    //   591: dup
    //   592: aload 23
    //   594: invokespecial 513	android/text/SpannableStringBuilder:<init>	(Ljava/lang/CharSequence;)V
    //   597: astore 5
    //   599: iload 16
    //   601: iconst_1
    //   602: if_icmple +34 -> 636
    //   605: aload 5
    //   607: aload 22
    //   609: getstatic 516	buj:eU	I
    //   612: iconst_1
    //   613: anewarray 4	java/lang/Object
    //   616: dup
    //   617: iconst_0
    //   618: iload 16
    //   620: iconst_1
    //   621: isub
    //   622: invokestatic 521	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   625: aastore
    //   626: invokevirtual 524	android/content/res/Resources:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   629: invokestatic 530	android/text/Html:fromHtml	(Ljava/lang/String;)Landroid/text/Spanned;
    //   632: invokevirtual 300	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    //   635: pop
    //   636: aload 11
    //   638: aload 5
    //   640: invokevirtual 533	he:a	(Ljava/lang/CharSequence;)Lhe;
    //   643: pop
    //   644: aload 6
    //   646: astore 5
    //   648: aload 5
    //   650: ifnull +148 -> 798
    //   653: aload_2
    //   654: getfield 538	cfk:a	Lcom/android/mail/providers/Folder;
    //   657: iconst_2
    //   658: invokevirtual 540	com/android/mail/providers/Folder:a	(I)Z
    //   661: ifne +661 -> 1322
    //   664: aload_2
    //   665: getfield 538	cfk:a	Lcom/android/mail/providers/Folder;
    //   668: sipush 1024
    //   671: invokevirtual 540	com/android/mail/providers/Folder:a	(I)Z
    //   674: ifeq +660 -> 1334
    //   677: goto +645 -> 1322
    //   680: ldc_w 542
    //   683: aload_2
    //   684: getfield 547	cfr:b	Landroid/content/Context;
    //   687: invokestatic 552	cfm:a	(Landroid/content/Context;)Lcfm;
    //   690: aload_1
    //   691: ldc2_w 553
    //   694: invokevirtual 557	com/android/mail/providers/Account:a	(J)Z
    //   697: invokevirtual 560	cfm:a	(Z)Ljava/lang/String;
    //   700: invokevirtual 388	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   703: istore 12
    //   705: iload 16
    //   707: ifeq +347 -> 1054
    //   710: iload 12
    //   712: ifne +342 -> 1054
    //   715: getstatic 565	cvw:a	Lcvw;
    //   718: astore 6
    //   720: aload 6
    //   722: getfield 566	cvw:e	Ljava/lang/String;
    //   725: astore 6
    //   727: aload_2
    //   728: getfield 547	cfr:b	Landroid/content/Context;
    //   731: invokestatic 552	cfm:a	(Landroid/content/Context;)Lcfm;
    //   734: invokevirtual 568	cfm:c	()Z
    //   737: ifeq +325 -> 1062
    //   740: getstatic 570	cvw:d	Lcvw;
    //   743: getfield 566	cvw:e	Ljava/lang/String;
    //   746: astore_2
    //   747: new 572	java/util/LinkedHashSet
    //   750: dup
    //   751: iconst_2
    //   752: invokespecial 573	java/util/LinkedHashSet:<init>	(I)V
    //   755: astore 11
    //   757: aload 11
    //   759: aload 6
    //   761: invokeinterface 380 2 0
    //   766: pop
    //   767: aload 11
    //   769: aload_2
    //   770: invokeinterface 380 2 0
    //   775: pop
    //   776: aload_0
    //   777: aload 7
    //   779: aload_3
    //   780: aload 4
    //   782: aload_1
    //   783: aload 26
    //   785: aload 5
    //   787: aload 8
    //   789: iload 14
    //   791: lload 9
    //   793: aload 11
    //   795: invokestatic 578	com/android/mail/utils/NotificationActionUtils:a	(Landroid/content/Context;Landroid/content/Intent;Lhf;Lht;Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Conversation;Lcom/android/mail/providers/Message;Lcom/android/mail/providers/Folder;IJLjava/util/Set;)V
    //   798: aload_3
    //   799: aload 25
    //   801: invokestatic 581	cvz:a	(Lhf;Ljava/util/HashSet;)V
    //   804: aload 21
    //   806: invokevirtual 584	byw:close	()V
    //   809: aload 20
    //   811: ifnull +10 -> 821
    //   814: aload 20
    //   816: invokeinterface 587 1 0
    //   821: aload 24
    //   823: areturn
    //   824: iconst_0
    //   825: istore 19
    //   827: goto -691 -> 136
    //   830: aload 5
    //   832: invokestatic 588	cvz:a	(Ljava/lang/String;)Ljava/lang/String;
    //   835: astore 5
    //   837: aload_3
    //   838: aload 5
    //   840: invokevirtual 466	hf:a	(Ljava/lang/CharSequence;)Lhf;
    //   843: pop
    //   844: aload 24
    //   846: aload 5
    //   848: putfield 468	cwa:a	Ljava/lang/String;
    //   851: goto -452 -> 399
    //   854: astore_0
    //   855: aload 21
    //   857: astore_1
    //   858: aload 20
    //   860: astore_2
    //   861: aload_1
    //   862: ifnull +7 -> 869
    //   865: aload_1
    //   866: invokevirtual 584	byw:close	()V
    //   869: aload_2
    //   870: ifnull +9 -> 879
    //   873: aload_2
    //   874: invokeinterface 587 1 0
    //   879: aload_0
    //   880: athrow
    //   881: ldc -24
    //   883: astore 5
    //   885: goto -311 -> 574
    //   888: aload 5
    //   890: invokestatic 419	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   893: ifeq +31 -> 924
    //   896: new 254	android/text/SpannableStringBuilder
    //   899: dup
    //   900: aload 15
    //   902: invokespecial 513	android/text/SpannableStringBuilder:<init>	(Ljava/lang/CharSequence;)V
    //   905: astore 5
    //   907: aload 5
    //   909: aload 13
    //   911: iconst_0
    //   912: aload 15
    //   914: invokevirtual 287	java/lang/String:length	()I
    //   917: iconst_0
    //   918: invokevirtual 589	android/text/SpannableStringBuilder:setSpan	(Ljava/lang/Object;III)V
    //   921: goto -322 -> 599
    //   924: aload 22
    //   926: getstatic 592	buj:eT	I
    //   929: invokevirtual 593	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   932: astore 23
    //   934: aload 23
    //   936: ldc_w 595
    //   939: invokevirtual 599	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   942: aload 23
    //   944: ldc_w 601
    //   947: invokevirtual 599	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   950: if_icmple +378 -> 1328
    //   953: iconst_1
    //   954: istore 17
    //   956: aload 23
    //   958: iconst_2
    //   959: anewarray 4	java/lang/Object
    //   962: dup
    //   963: iconst_0
    //   964: aload 15
    //   966: aastore
    //   967: dup
    //   968: iconst_1
    //   969: aload 5
    //   971: aastore
    //   972: invokestatic 605	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   975: astore 23
    //   977: new 254	android/text/SpannableStringBuilder
    //   980: dup
    //   981: aload 23
    //   983: invokespecial 513	android/text/SpannableStringBuilder:<init>	(Ljava/lang/CharSequence;)V
    //   986: astore 5
    //   988: iload 17
    //   990: ifeq +33 -> 1023
    //   993: aload 23
    //   995: aload 15
    //   997: invokevirtual 599	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1000: istore 17
    //   1002: aload 5
    //   1004: aload 13
    //   1006: iload 17
    //   1008: aload 15
    //   1010: invokevirtual 287	java/lang/String:length	()I
    //   1013: iload 17
    //   1015: iadd
    //   1016: iconst_0
    //   1017: invokevirtual 589	android/text/SpannableStringBuilder:setSpan	(Ljava/lang/Object;III)V
    //   1020: goto -421 -> 599
    //   1023: aload 23
    //   1025: aload 15
    //   1027: invokevirtual 608	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   1030: istore 17
    //   1032: goto -30 -> 1002
    //   1035: ldc 96
    //   1037: ldc_w 610
    //   1040: iconst_0
    //   1041: anewarray 4	java/lang/Object
    //   1044: invokestatic 103	cvm:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1047: pop
    //   1048: aconst_null
    //   1049: astore 5
    //   1051: goto -403 -> 648
    //   1054: getstatic 612	cvw:b	Lcvw;
    //   1057: astore 6
    //   1059: goto -339 -> 720
    //   1062: getstatic 614	cvw:c	Lcvw;
    //   1065: getfield 566	cvw:e	Ljava/lang/String;
    //   1068: astore_2
    //   1069: goto -322 -> 747
    //   1072: aload 15
    //   1074: invokestatic 419	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1077: ifeq +40 -> 1117
    //   1080: aload 5
    //   1082: astore_0
    //   1083: aload_3
    //   1084: aload_0
    //   1085: invokevirtual 466	hf:a	(Ljava/lang/CharSequence;)Lhf;
    //   1088: pop
    //   1089: iload 12
    //   1091: ifeq +9 -> 1100
    //   1094: aload_1
    //   1095: getfield 473	com/android/mail/providers/Account:a	Ljava/lang/String;
    //   1098: astore 13
    //   1100: aload_3
    //   1101: aload 13
    //   1103: invokevirtual 472	hf:b	(Ljava/lang/CharSequence;)Lhf;
    //   1106: pop
    //   1107: aload 24
    //   1109: aload 5
    //   1111: putfield 468	cwa:a	Ljava/lang/String;
    //   1114: goto -316 -> 798
    //   1117: aload_0
    //   1118: invokevirtual 512	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1121: getstatic 617	buj:eV	I
    //   1124: invokevirtual 593	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1127: astore_2
    //   1128: aload_2
    //   1129: ldc_w 595
    //   1132: invokevirtual 599	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1135: aload_2
    //   1136: ldc_w 601
    //   1139: invokevirtual 599	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1142: if_icmple +198 -> 1340
    //   1145: iconst_1
    //   1146: istore 14
    //   1148: aload_2
    //   1149: iconst_2
    //   1150: anewarray 4	java/lang/Object
    //   1153: dup
    //   1154: iconst_0
    //   1155: aload 5
    //   1157: aastore
    //   1158: dup
    //   1159: iconst_1
    //   1160: aload 15
    //   1162: aastore
    //   1163: invokestatic 605	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1166: astore 4
    //   1168: new 191	android/text/SpannableString
    //   1171: dup
    //   1172: aload 4
    //   1174: invokespecial 194	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   1177: astore_2
    //   1178: iload 14
    //   1180: ifeq +43 -> 1223
    //   1183: aload 4
    //   1185: aload 15
    //   1187: invokevirtual 608	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   1190: istore 14
    //   1192: aload_2
    //   1193: new 213	android/text/style/TextAppearanceSpan
    //   1196: dup
    //   1197: aload_0
    //   1198: getstatic 619	buk:h	I
    //   1201: invokespecial 221	android/text/style/TextAppearanceSpan:<init>	(Landroid/content/Context;I)V
    //   1204: iload 14
    //   1206: aload 15
    //   1208: invokevirtual 287	java/lang/String:length	()I
    //   1211: iload 14
    //   1213: iadd
    //   1214: iconst_0
    //   1215: invokevirtual 201	android/text/SpannableString:setSpan	(Ljava/lang/Object;III)V
    //   1218: aload_2
    //   1219: astore_0
    //   1220: goto -137 -> 1083
    //   1223: aload 4
    //   1225: aload 15
    //   1227: invokevirtual 599	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1230: istore 14
    //   1232: goto -40 -> 1192
    //   1235: astore_0
    //   1236: aconst_null
    //   1237: astore_1
    //   1238: aconst_null
    //   1239: astore_2
    //   1240: goto -379 -> 861
    //   1243: astore_0
    //   1244: aconst_null
    //   1245: astore_1
    //   1246: aload 20
    //   1248: astore_2
    //   1249: goto -388 -> 861
    //   1252: goto -950 -> 302
    //   1255: ldc -24
    //   1257: astore 5
    //   1259: goto -916 -> 343
    //   1262: iload 18
    //   1264: istore 19
    //   1266: iload 17
    //   1268: istore 18
    //   1270: iload 16
    //   1272: istore 17
    //   1274: iload 19
    //   1276: istore 16
    //   1278: goto -1160 -> 118
    //   1281: iload 16
    //   1283: istore 19
    //   1285: iload 17
    //   1287: istore 16
    //   1289: iload 18
    //   1291: istore 17
    //   1293: iload 19
    //   1295: istore 18
    //   1297: goto -1077 -> 220
    //   1300: iconst_0
    //   1301: istore 18
    //   1303: iconst_0
    //   1304: istore 16
    //   1306: goto -1078 -> 228
    //   1309: iload 17
    //   1311: iconst_1
    //   1312: iadd
    //   1313: istore 16
    //   1315: iload 19
    //   1317: istore 17
    //   1319: goto -1099 -> 220
    //   1322: iconst_1
    //   1323: istore 16
    //   1325: goto -645 -> 680
    //   1328: iconst_0
    //   1329: istore 17
    //   1331: goto -375 -> 956
    //   1334: iconst_0
    //   1335: istore 16
    //   1337: goto -657 -> 680
    //   1340: iconst_0
    //   1341: istore 14
    //   1343: goto -195 -> 1148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1346	0	paramContext	Context
    //   0	1346	1	paramAccount	com.android.mail.providers.Account
    //   0	1346	2	paramcfk	cfk
    //   0	1346	3	paramhf	hf
    //   0	1346	4	paramht	ht
    //   0	1346	5	paramSet	Set<cwc>
    //   0	1346	6	paramCursor	Cursor
    //   0	1346	7	paramIntent	Intent
    //   0	1346	8	paramFolder	Folder
    //   0	1346	9	paramLong	long
    //   0	1346	11	paramResources	Resources
    //   0	1346	12	paramBoolean	boolean
    //   0	1346	13	paramString	String
    //   0	1346	14	paramInt	int
    //   0	1346	15	paramcfb	cfb
    //   116	1220	16	k	int
    //   88	1242	17	m	int
    //   110	1192	18	n	int
    //   134	1182	19	i1	int
    //   51	1196	20	localObject1	Object
    //   79	777	21	localbyw	byw
    //   106	819	22	localObject2	Object
    //   123	901	23	localObject3	Object
    //   7	1101	24	localcwa	cwa
    //   27	773	25	localHashSet	HashSet
    //   18	766	26	localConversation	Conversation
    //   243	74	27	localConversationMessage	com.android.mail.browse.ConversationMessage
    //   266	40	28	str	String
    //   276	8	29	localAddress	Address
    // Exception table:
    //   from	to	target	type
    //   81	108	854	finally
    //   118	133	854	finally
    //   146	171	854	finally
    //   171	188	854	finally
    //   201	214	854	finally
    //   220	228	854	finally
    //   228	268	854	finally
    //   271	278	854	finally
    //   283	290	854	finally
    //   290	298	854	finally
    //   302	339	854	finally
    //   343	360	854	finally
    //   365	399	854	finally
    //   399	444	854	finally
    //   449	455	854	finally
    //   455	530	854	finally
    //   530	574	854	finally
    //   574	599	854	finally
    //   605	636	854	finally
    //   636	644	854	finally
    //   653	677	854	finally
    //   680	705	854	finally
    //   715	720	854	finally
    //   720	747	854	finally
    //   747	798	854	finally
    //   798	804	854	finally
    //   830	851	854	finally
    //   888	921	854	finally
    //   924	953	854	finally
    //   956	988	854	finally
    //   993	1002	854	finally
    //   1002	1020	854	finally
    //   1023	1032	854	finally
    //   1035	1048	854	finally
    //   1054	1059	854	finally
    //   1062	1069	854	finally
    //   1072	1080	854	finally
    //   1083	1089	854	finally
    //   1094	1100	854	finally
    //   1100	1114	854	finally
    //   1117	1145	854	finally
    //   1148	1178	854	finally
    //   1183	1192	854	finally
    //   1192	1218	854	finally
    //   1223	1232	854	finally
    //   29	70	1235	finally
    //   70	81	1243	finally
  }
  
  public static cwb a(Context paramContext, String paramString1, String paramString2, String paramString3, cfb paramcfb, boolean paramBoolean, int paramInt)
  {
    cwv.b();
    cwb localcwb = new cwb();
    Object localObject = paramContext.getResources();
    int k = ((Resources)localObject).getDimensionPixelSize(17104902);
    int m = ((Resources)localObject).getDimensionPixelSize(17104901);
    int n = ((Resources)localObject).getDimensionPixelSize(bua.ae);
    int i1 = ((Resources)localObject).getDimensionPixelSize(bua.ad);
    localObject = new cop(m, k, 1.0F, ((Resources)localObject).getDimensionPixelSize(bua.Y));
    if (paramInt == 0)
    {
      if (!TextUtils.isEmpty(paramString3))
      {
        if (paramcfb != null) {
          break label209;
        }
        paramString1 = a(paramContext, paramString3);
        if (paramString1 == null) {
          break label223;
        }
        b = Bitmap.createScaledBitmap(paramString1, n, i1, true);
        a = Bitmap.createScaledBitmap(paramString1, m, k, true);
        label136:
        if (paramBoolean) {
          a = cts.a(a);
        }
      }
      label154:
      if (a == null)
      {
        paramInt = bub.aj;
        paramString1 = (Bitmap)b.get(paramInt);
        if (paramString1 == null) {
          break label275;
        }
      }
    }
    for (;;)
    {
      a = paramString1;
      if (b == null) {
        b = c(paramContext);
      }
      return localcwb;
      label209:
      paramString1 = paramcfb.a(paramContext, paramString1, paramString3);
      break;
      label223:
      a = new cff(paramContext.getResources()).a((cop)localObject, paramString2, paramString3);
      break label136;
      a = new cff(paramContext.getResources()).a((cop)localObject, paramInt);
      break label154;
      label275:
      paramString1 = BitmapFactory.decodeResource(paramContext.getResources(), paramInt);
      b.put(paramInt, paramString1);
    }
  }
  
  private static String a(Context paramContext, int paramInt)
  {
    return paramContext.getResources().getQuantityString(buh.r, paramInt, new Object[] { Integer.valueOf(paramInt) });
  }
  
  private static String a(com.android.mail.providers.Account paramAccount, Folder paramFolder)
  {
    paramAccount = String.valueOf(g.toString());
    paramFolder = String.valueOf(c.b);
    return String.valueOf(paramAccount).length() + 1 + String.valueOf(paramFolder).length() + paramAccount + "/" + paramFolder;
  }
  
  private static String a(Message paramMessage)
  {
    String str = j;
    paramMessage = str;
    if (str == null) {
      paramMessage = "";
    }
    return paramMessage;
  }
  
  private static String a(cwg paramcwg)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = new HashSet();
    Iterator localIterator = a.keySet().iterator();
    int k = 0;
    while (localIterator.hasNext())
    {
      cwf localcwf = (cwf)localIterator.next();
      Integer localInteger1 = paramcwg.b(localcwf);
      Integer localInteger2 = paramcwg.c(localcwf);
      if ((localInteger1 == null) || (localInteger1.intValue() == 0))
      {
        ((Set)localObject).add(localcwf);
      }
      else
      {
        if (k > 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append(localcwf.toString());
        localStringBuilder.append(" (");
        localStringBuilder.append(localInteger1);
        localStringBuilder.append(", ");
        localStringBuilder.append(localInteger2);
        localStringBuilder.append(')');
        k += 1;
      }
    }
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramcwg.a((cwf)((Iterator)localObject).next());
    }
    return localStringBuilder.toString();
  }
  
  private static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null)
    {
      cvm.e("NotifUtils", "null from string in getWrappedFromString", new Object[0]);
      str = "";
    }
    return f.a(str);
  }
  
  private static ArrayList<Long> a(Context paramContext, Collection<String> paramCollection)
  {
    if (cwm.a(paramContext, "android.permission.READ_CONTACTS"))
    {
      bus.a("contacts_notification", "enabled");
      Object localObject1 = new ArrayList();
      Object localObject2 = new StringBuilder();
      String[] arrayOfString = new String[paramCollection.size()];
      ((ArrayList)localObject1).addAll(paramCollection);
      Arrays.fill(arrayOfString, "?");
      ((StringBuilder)localObject2).append("data1 IN (").append(TextUtils.join(",", arrayOfString)).append(")");
      paramContext = paramContext.getContentResolver();
      paramCollection = ContactsContract.CommonDataKinds.Email.CONTENT_URI;
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = (String[])((ArrayList)localObject1).toArray(new String[((ArrayList)localObject1).size()]);
      paramContext = paramContext.query(paramCollection, new String[] { "contact_id" }, (String)localObject2, (String[])localObject1, null);
      paramCollection = new ArrayList();
      if (paramContext == null) {
        return paramCollection;
      }
    }
    else
    {
      bus.a("contacts_notification", "disabled");
      return null;
    }
    try
    {
      if (paramContext.moveToNext()) {
        paramCollection.add(Long.valueOf(paramContext.getLong(0)));
      }
      return paramCollection;
    }
    finally
    {
      paramContext.close();
    }
  }
  
  public static void a(Context paramContext)
  {
    cvm.a("NotifUtils", "Clearing all notifications.", new Object[0]);
    cwg localcwg = b(paramContext);
    a.clear();
    localcwg.b(paramContext);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, com.android.mail.providers.Account paramAccount, Folder paramFolder, boolean paramBoolean)
  {
    cvm.c("NotifUtils", "sendSetNewEmailIndicator account: %s, folder: %s", new Object[] { cvm.a("NotifUtils", c), cvm.a("NotifUtils", d) });
    Intent localIntent = new Intent("com.android.mail.action.SEND_SET_NEW_EMAIL_INDICATOR");
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra("unread-count", paramInt1);
    localIntent.putExtra("unseen-count", paramInt2);
    localIntent.putExtra("mail_account", paramAccount);
    localIntent.putExtra("folder", paramFolder);
    localIntent.putExtra("get-attention", paramBoolean);
    paramContext.startService(localIntent);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, com.android.mail.providers.Account paramAccount, Folder paramFolder, boolean paramBoolean, cfb paramcfb, ces paramces)
  {
    cvm.b("NotifUtils", "setNewEmailIndicator unreadCount = %d, unseenCount = %d, account = %s, folder = %s, getAttention = %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), c, c, Boolean.valueOf(paramBoolean) });
    boolean bool1 = false;
    int k = a(paramAccount.c(), paramFolder);
    cwg localcwg = b(paramContext);
    cwf localcwf = new cwf(paramAccount, paramFolder);
    boolean bool2 = true;
    if (paramInt1 == 0)
    {
      cvm.b("NotifUtils", "setNewEmailIndicator - cancelling %d for %s / %s", new Object[] { Integer.valueOf(k), c, b });
      localcwg.a(localcwf);
      ih localih = ih.a(paramContext);
      localih.a(k);
      a(localcwf, localih);
      bool2 = true;
      bool1 = false;
      localcwg.b(paramContext);
      if (cvm.a("NotifUtils", 2)) {
        cvm.a("NotifUtils", "New email: %s mapSize: %d getAttention: %b", new Object[] { a(localcwg), Integer.valueOf(a.size()), Boolean.valueOf(paramBoolean) });
      }
      if (NotificationActionUtils.a.a(k) == null) {
        a(paramContext, paramFolder, paramAccount, paramBoolean, bool1, localcwf, bool2, paramcfb, paramces);
      }
      return;
    }
    cvm.b("NotifUtils", "setNewEmailIndicator - update count for: %s / %s to: unread: %d unseen %d", new Object[] { c, b, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (!a.containsKey(localcwf))
    {
      cvm.b("NotifUtils", "setNewEmailIndicator - ignoringUnobtrusiveSetting", new Object[0]);
      bool1 = true;
    }
    for (;;)
    {
      localcwg.a(localcwf, paramInt1, paramInt2);
      break;
      bool2 = false;
    }
  }
  
  public static void a(Context paramContext, android.accounts.Account paramAccount)
  {
    cvm.a("NotifUtils", "Clearing all notifications for %s", new Object[] { paramAccount });
    cwg localcwg = b(paramContext);
    Object localObject1 = new heh();
    Object localObject2 = a.keySet().iterator();
    cwf localcwf;
    while (((Iterator)localObject2).hasNext())
    {
      localcwf = (cwf)((Iterator)localObject2).next();
      if (paramAccount.equals(a.c())) {
        ((heh)localObject1).c(localcwf);
      }
    }
    localObject2 = ((heh)localObject1).a();
    localObject1 = ih.a(paramContext);
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localcwf = (cwf)((Iterator)localObject2).next();
      ((ih)localObject1).a(a(paramAccount, b));
      localcwg.a(localcwf);
      a(localcwf, (ih)localObject1);
    }
    localcwg.b(paramContext);
  }
  
  public static void a(Context paramContext, Uri paramUri)
  {
    cvm.a("NotifUtils", "markConversationAsReadAndSeen=%s", new Object[] { paramUri });
    ContentValues localContentValues = new ContentValues(2);
    localContentValues.put("seen", Boolean.TRUE);
    localContentValues.put("read", Boolean.TRUE);
    paramContext.getContentResolver().update(paramUri, localContentValues, null, null);
  }
  
  public static void a(Context paramContext, cfb paramcfb, ces paramces)
  {
    cvm.b("NotifUtils", "cancelAndResendNotificationsOnLocaleChange", new Object[0]);
    f = mx.a();
    a(paramContext, true, null, null, paramcfb, paramces);
  }
  
  public static void a(Context paramContext, com.android.mail.providers.Account paramAccount)
  {
    Object localObject2 = c;
    cvm.b("NotifUtils", "validateAccountNotifications - %s", new Object[] { localObject2 });
    Object localObject1 = new ArrayList();
    cwg localcwg = b(paramContext);
    Object localObject3 = a.keySet();
    if (!cfg.b(paramContext, paramAccount.h()).b())
    {
      paramAccount = ((Set)localObject3).iterator();
      while (paramAccount.hasNext())
      {
        localObject3 = (cwf)paramAccount.next();
        if (a.c().name.equals(localObject2)) {
          ((List)localObject1).add(localObject3);
        }
      }
    }
    paramAccount = ((Set)localObject3).iterator();
    while (paramAccount.hasNext())
    {
      localObject3 = (cwf)paramAccount.next();
      if (a.c().name.equals(localObject2))
      {
        Folder localFolder = b;
        boolean bool = c.equals(a.z.i);
        if (!new cfk(paramContext, a.h(), localFolder, bool).a()) {
          ((List)localObject1).add(localObject3);
        }
      }
    }
    if (((List)localObject1).size() > 0)
    {
      paramAccount = ih.a(paramContext);
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (cwf)((Iterator)localObject1).next();
        localObject3 = b;
        int k = a(a.c(), (Folder)localObject3);
        cvm.b("NotifUtils", "validateAccountNotifications - cancelling %s / %s", new Object[] { a.c, b });
        paramAccount.a(k);
        localcwg.a((cwf)localObject2);
        NotificationActionUtils.a.c(k);
        NotificationActionUtils.c.a(k);
        a((cwf)localObject2, paramAccount);
      }
      localcwg.b(paramContext);
    }
  }
  
  /* Error */
  private static void a(Context paramContext, com.android.mail.providers.Account paramAccount, cfk paramcfk, hf paramhf, ht paramht, Map<cwd, cwe> paramMap, Set<cwc> paramSet, int paramInt1, Cursor paramCursor, PendingIntent paramPendingIntent, Intent paramIntent, int paramInt2, int paramInt3, Folder paramFolder, long paramLong, cfb paramcfb)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 512	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   4: astore 29
    //   6: iload 12
    //   8: iconst_1
    //   9: if_icmpgt +9 -> 18
    //   12: invokestatic 1005	cxd:f	()Z
    //   15: ifeq +371 -> 386
    //   18: iconst_1
    //   19: istore 17
    //   21: ldc 96
    //   23: ldc_w 1007
    //   26: iconst_2
    //   27: anewarray 4	java/lang/Object
    //   30: dup
    //   31: iconst_0
    //   32: iload 11
    //   34: invokestatic 521	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   37: aastore
    //   38: dup
    //   39: iconst_1
    //   40: iload 12
    //   42: invokestatic 521	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   45: aastore
    //   46: invokestatic 837	cvm:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   49: pop
    //   50: aload 13
    //   52: getfield 106	com/android/mail/providers/Folder:c	Lcus;
    //   55: getfield 111	cus:b	Landroid/net/Uri;
    //   58: aload_1
    //   59: getfield 982	com/android/mail/providers/Account:z	Lcom/android/mail/providers/Settings;
    //   62: getfield 986	com/android/mail/providers/Settings:i	Landroid/net/Uri;
    //   65: invokevirtual 1008	android/net/Uri:equals	(Ljava/lang/Object;)Z
    //   68: istore 21
    //   70: iload 21
    //   72: ifeq +320 -> 392
    //   75: aconst_null
    //   76: astore 22
    //   78: iload 17
    //   80: ifeq +1256 -> 1336
    //   83: aload_0
    //   84: iload 12
    //   86: invokestatic 1010	cvz:a	(Landroid/content/Context;I)Ljava/lang/String;
    //   89: astore 24
    //   91: aload_3
    //   92: aload 24
    //   94: invokevirtual 466	hf:a	(Ljava/lang/CharSequence;)Lhf;
    //   97: pop
    //   98: invokestatic 450	cxd:a	()Z
    //   101: ifeq +1207 -> 1308
    //   104: aload_0
    //   105: invokevirtual 512	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   108: getstatic 1013	bud:w	I
    //   111: invokevirtual 461	android/content/res/Resources:getInteger	(I)I
    //   114: istore 20
    //   116: iload 21
    //   118: ifeq +284 -> 402
    //   121: aload_1
    //   122: getfield 473	com/android/mail/providers/Account:a	Ljava/lang/String;
    //   125: astore 23
    //   127: aload_3
    //   128: aload 23
    //   130: invokevirtual 475	hf:c	(Ljava/lang/CharSequence;)Lhf;
    //   133: pop
    //   134: new 1015	hi
    //   137: dup
    //   138: aload_3
    //   139: invokespecial 1016	hi:<init>	(Lhf;)V
    //   142: astore 30
    //   144: aload_1
    //   145: aload 13
    //   147: invokestatic 1018	cvz:a	(Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;)Ljava/lang/String;
    //   150: astore 31
    //   152: new 309	java/util/HashSet
    //   155: dup
    //   156: invokespecial 310	java/util/HashSet:<init>	()V
    //   159: astore 32
    //   161: aload_3
    //   162: aload 31
    //   164: putfield 1020	hf:r	Ljava/lang/String;
    //   167: aload_3
    //   168: iconst_1
    //   169: putfield 1023	hf:s	Z
    //   172: aconst_null
    //   173: astore 23
    //   175: iconst_0
    //   176: istore 17
    //   178: new 118	com/android/mail/providers/Conversation
    //   181: dup
    //   182: aload 8
    //   184: invokespecial 121	com/android/mail/providers/Conversation:<init>	(Landroid/database/Cursor;)V
    //   187: astore 33
    //   189: aload 33
    //   191: getfield 1025	com/android/mail/providers/Conversation:j	Z
    //   194: ifne +1241 -> 1435
    //   197: aload 33
    //   199: getfield 312	com/android/mail/providers/Conversation:g	Landroid/net/Uri;
    //   202: invokevirtual 318	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   205: astore 25
    //   207: aload 25
    //   209: ldc_w 320
    //   212: aload 22
    //   214: invokevirtual 328	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   217: pop
    //   218: aload_0
    //   219: invokevirtual 173	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   222: aload 25
    //   224: invokevirtual 332	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   227: getstatic 338	chh:n	[Ljava/lang/String;
    //   230: aconst_null
    //   231: aconst_null
    //   232: aconst_null
    //   233: invokevirtual 344	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   236: astore 26
    //   238: new 346	byw
    //   241: dup
    //   242: aload 26
    //   244: invokespecial 347	byw:<init>	(Landroid/database/Cursor;)V
    //   247: astore 28
    //   249: ldc -24
    //   251: astore 27
    //   253: ldc -24
    //   255: astore 25
    //   257: aload 28
    //   259: aload 28
    //   261: invokevirtual 350	byw:getCount	()I
    //   264: iconst_1
    //   265: isub
    //   266: invokevirtual 395	byw:moveToPosition	(I)Z
    //   269: ifeq +1175 -> 1444
    //   272: aload 28
    //   274: invokevirtual 356	byw:a	()Lcom/android/mail/browse/ConversationMessage;
    //   277: invokestatic 359	cvz:a	(Lcom/android/mail/providers/Message;)Ljava/lang/String;
    //   280: astore 25
    //   282: aload 25
    //   284: invokestatic 398	cvz:b	(Ljava/lang/String;)Ljava/lang/String;
    //   287: astore 27
    //   289: aload 25
    //   291: aload 32
    //   293: invokestatic 387	cvz:a	(Ljava/lang/String;Ljava/util/HashSet;)V
    //   296: goto +1148 -> 1444
    //   299: aload 28
    //   301: aload 28
    //   303: invokevirtual 383	byw:getPosition	()I
    //   306: iconst_1
    //   307: isub
    //   308: invokevirtual 395	byw:moveToPosition	(I)Z
    //   311: ifeq +98 -> 409
    //   314: aload 28
    //   316: invokevirtual 356	byw:a	()Lcom/android/mail/browse/ConversationMessage;
    //   319: astore 34
    //   321: aload 34
    //   323: invokestatic 359	cvz:a	(Lcom/android/mail/providers/Message;)Ljava/lang/String;
    //   326: astore 35
    //   328: aload 34
    //   330: getfield 1028	com/android/mail/providers/Message:B	Z
    //   333: ifne -34 -> 299
    //   336: aload 25
    //   338: aload 35
    //   340: invokevirtual 1031	java/lang/String:contentEquals	(Ljava/lang/CharSequence;)Z
    //   343: ifne -44 -> 299
    //   346: iconst_1
    //   347: istore 18
    //   349: aload 35
    //   351: aload 32
    //   353: invokestatic 387	cvz:a	(Ljava/lang/String;Ljava/util/HashSet;)V
    //   356: goto -57 -> 299
    //   359: astore_0
    //   360: aload 28
    //   362: astore_1
    //   363: aload 26
    //   365: astore_2
    //   366: aload_1
    //   367: ifnull +7 -> 374
    //   370: aload_1
    //   371: invokevirtual 584	byw:close	()V
    //   374: aload_2
    //   375: ifnull +9 -> 384
    //   378: aload_2
    //   379: invokeinterface 587 1 0
    //   384: aload_0
    //   385: athrow
    //   386: iconst_0
    //   387: istore 17
    //   389: goto -368 -> 21
    //   392: aload 13
    //   394: getfield 835	com/android/mail/providers/Folder:d	Ljava/lang/String;
    //   397: astore 22
    //   399: goto -321 -> 78
    //   402: aload 22
    //   404: astore 23
    //   406: goto -279 -> 127
    //   409: iload 18
    //   411: ifeq +498 -> 909
    //   414: aload_0
    //   415: aload 8
    //   417: aload 29
    //   419: getstatic 455	bud:G	I
    //   422: invokevirtual 461	android/content/res/Resources:getInteger	(I)I
    //   425: aload_1
    //   426: invokestatic 463	cvz:a	(Landroid/content/Context;Landroid/database/Cursor;ILcom/android/mail/providers/Account;)Landroid/text/SpannableStringBuilder;
    //   429: astore 25
    //   431: aload 25
    //   433: invokevirtual 467	android/text/SpannableStringBuilder:toString	()Ljava/lang/String;
    //   436: astore 34
    //   438: aload_0
    //   439: aload 33
    //   441: getfield 443	com/android/mail/providers/Conversation:d	Ljava/lang/String;
    //   444: invokestatic 448	com/android/mail/browse/ConversationItemView:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   447: astore 25
    //   449: aload 33
    //   451: invokevirtual 1033	com/android/mail/providers/Conversation:d	()Ljava/lang/String;
    //   454: astore 27
    //   456: aload 25
    //   458: invokestatic 419	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   461: ifne +989 -> 1450
    //   464: new 213	android/text/style/TextAppearanceSpan
    //   467: dup
    //   468: aload_0
    //   469: getstatic 470	buk:g	I
    //   472: invokespecial 221	android/text/style/TextAppearanceSpan:<init>	(Landroid/content/Context;I)V
    //   475: astore 35
    //   477: aload 34
    //   479: invokestatic 419	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   482: ifeq +444 -> 926
    //   485: aload 30
    //   487: getfield 1036	hi:a	Ljava/util/ArrayList;
    //   490: aload 25
    //   492: invokestatic 1039	hf:e	(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    //   495: invokevirtual 816	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   498: pop
    //   499: iload 17
    //   501: iconst_1
    //   502: iadd
    //   503: istore 17
    //   505: new 439	hf
    //   508: dup
    //   509: aload_0
    //   510: invokespecial 1040	hf:<init>	(Landroid/content/Context;)V
    //   513: astore 27
    //   515: aload 27
    //   517: ldc_w 1042
    //   520: putfield 1044	hf:w	Ljava/lang/String;
    //   523: iload 12
    //   525: iconst_1
    //   526: if_icmple +616 -> 1142
    //   529: aload 27
    //   531: getstatic 1047	bub:aK	I
    //   534: invokevirtual 1050	hf:a	(I)Lhf;
    //   537: pop
    //   538: invokestatic 423	cxd:d	()Z
    //   541: ifeq +16 -> 557
    //   544: aload 27
    //   546: aload 29
    //   548: getstatic 1055	btz:E	I
    //   551: invokevirtual 1058	android/content/res/Resources:getColor	(I)I
    //   554: putfield 1061	hf:y	I
    //   557: aload 27
    //   559: aload 25
    //   561: invokevirtual 472	hf:b	(Ljava/lang/CharSequence;)Lhf;
    //   564: pop
    //   565: aload 27
    //   567: aload_0
    //   568: aload_0
    //   569: aload_1
    //   570: aload 13
    //   572: aload 8
    //   574: invokestatic 1063	cvz:a	(Landroid/content/Context;Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;Landroid/database/Cursor;)Landroid/content/Intent;
    //   577: invokestatic 1065	cvz:a	(Landroid/content/Context;Landroid/content/Intent;)Landroid/app/PendingIntent;
    //   580: putfield 1068	hf:d	Landroid/app/PendingIntent;
    //   583: iload 7
    //   585: aload 33
    //   587: invokevirtual 1069	com/android/mail/providers/Conversation:hashCode	()I
    //   590: ixor
    //   591: istore 18
    //   593: aload 8
    //   595: ifnonnull +559 -> 1154
    //   598: ldc 96
    //   600: ldc_w 1071
    //   603: iconst_0
    //   604: anewarray 4	java/lang/Object
    //   607: invokestatic 103	cvm:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   610: pop
    //   611: aconst_null
    //   612: astore 25
    //   614: aload 25
    //   616: ifnull +639 -> 1255
    //   619: aload 27
    //   621: aload_0
    //   622: iload 18
    //   624: aload 25
    //   626: ldc 83
    //   628: invokestatic 1074	android/app/PendingIntent:getService	(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   631: invokevirtual 1077	hf:a	(Landroid/app/PendingIntent;)Lhf;
    //   634: pop
    //   635: aload 27
    //   637: invokevirtual 1080	hf:a	()Lhf;
    //   640: pop
    //   641: ldc_w 1082
    //   644: iconst_1
    //   645: anewarray 4	java/lang/Object
    //   648: dup
    //   649: iconst_0
    //   650: ldc2_w 1083
    //   653: aload 33
    //   655: getfield 1086	com/android/mail/providers/Conversation:w	J
    //   658: lsub
    //   659: invokestatic 492	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   662: aastore
    //   663: invokestatic 605	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   666: astore 25
    //   668: aload 27
    //   670: aload 31
    //   672: putfield 1020	hf:r	Ljava/lang/String;
    //   675: aload 27
    //   677: aload 25
    //   679: putfield 1088	hf:t	Ljava/lang/String;
    //   682: aload 27
    //   684: aload 33
    //   686: getfield 1090	com/android/mail/providers/Conversation:e	J
    //   689: invokevirtual 1093	hf:a	(J)Lhf;
    //   692: pop
    //   693: new 1095	ht
    //   696: dup
    //   697: invokespecial 1096	ht:<init>	()V
    //   700: astore 34
    //   702: aload_0
    //   703: aload_1
    //   704: aload_2
    //   705: aload 27
    //   707: aload 34
    //   709: aload 6
    //   711: aload 8
    //   713: aload 10
    //   715: aload 13
    //   717: lload 14
    //   719: aload 29
    //   721: iload 21
    //   723: aload 22
    //   725: iload 18
    //   727: aload 16
    //   729: invokestatic 1098	cvz:a	(Landroid/content/Context;Lcom/android/mail/providers/Account;Lcfk;Lhf;Lht;Ljava/util/Set;Landroid/database/Cursor;Landroid/content/Intent;Lcom/android/mail/providers/Folder;JLandroid/content/res/Resources;ZLjava/lang/String;ILcfb;)Lcwa;
    //   732: astore 25
    //   734: aload 5
    //   736: new 1100	cwd
    //   739: dup
    //   740: iload 18
    //   742: aload 33
    //   744: getfield 1090	com/android/mail/providers/Conversation:e	J
    //   747: invokespecial 1103	cwd:<init>	(IJ)V
    //   750: new 1105	cwe
    //   753: dup
    //   754: aload 27
    //   756: aload 34
    //   758: invokespecial 1108	cwe:<init>	(Lhf;Lht;)V
    //   761: invokeinterface 1113 3 0
    //   766: pop
    //   767: aload 23
    //   769: ifnonnull +663 -> 1432
    //   772: aload 25
    //   774: astore 23
    //   776: aload 28
    //   778: invokevirtual 584	byw:close	()V
    //   781: aload 26
    //   783: ifnull +658 -> 1441
    //   786: aload 26
    //   788: invokeinterface 587 1 0
    //   793: iload 17
    //   795: iload 20
    //   797: if_icmpgt +13 -> 810
    //   800: aload 8
    //   802: invokeinterface 811 1 0
    //   807: ifne +631 -> 1438
    //   810: aload_3
    //   811: aload 32
    //   813: invokestatic 581	cvz:a	(Lhf;Ljava/util/HashSet;)V
    //   816: aload 23
    //   818: ifnull +462 -> 1280
    //   821: aload 23
    //   823: getfield 432	cwa:b	Lcwb;
    //   826: ifnull +454 -> 1280
    //   829: aload 4
    //   831: aload 23
    //   833: getfield 432	cwa:b	Lcwb;
    //   836: getfield 656	cwb:b	Landroid/graphics/Bitmap;
    //   839: putfield 1114	ht:a	Landroid/graphics/Bitmap;
    //   842: aload 24
    //   844: astore_0
    //   845: aload_0
    //   846: astore_1
    //   847: aload 22
    //   849: ifnull +31 -> 880
    //   852: aload_0
    //   853: astore_1
    //   854: aload_0
    //   855: ifnull +25 -> 880
    //   858: aload 29
    //   860: getstatic 1117	buj:cL	I
    //   863: iconst_2
    //   864: anewarray 4	java/lang/Object
    //   867: dup
    //   868: iconst_0
    //   869: aload 22
    //   871: aastore
    //   872: dup
    //   873: iconst_1
    //   874: aload_0
    //   875: aastore
    //   876: invokevirtual 524	android/content/res/Resources:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   879: astore_1
    //   880: aload_1
    //   881: ifnull +9 -> 890
    //   884: aload_3
    //   885: aload_1
    //   886: invokevirtual 1119	hf:d	(Ljava/lang/CharSequence;)Lhf;
    //   889: pop
    //   890: iload 11
    //   892: iconst_1
    //   893: if_icmple +9 -> 902
    //   896: aload_3
    //   897: iload 11
    //   899: putfield 1120	hf:i	I
    //   902: aload_3
    //   903: aload 9
    //   905: putfield 1068	hf:d	Landroid/app/PendingIntent;
    //   908: return
    //   909: new 254	android/text/SpannableStringBuilder
    //   912: dup
    //   913: aload 27
    //   915: invokestatic 588	cvz:a	(Ljava/lang/String;)Ljava/lang/String;
    //   918: invokespecial 513	android/text/SpannableStringBuilder:<init>	(Ljava/lang/CharSequence;)V
    //   921: astore 25
    //   923: goto -492 -> 431
    //   926: aload 25
    //   928: invokestatic 419	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   931: ifeq +31 -> 962
    //   934: new 191	android/text/SpannableString
    //   937: dup
    //   938: aload 34
    //   940: invokespecial 194	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   943: astore 25
    //   945: aload 25
    //   947: aload 35
    //   949: iconst_0
    //   950: aload 34
    //   952: invokevirtual 287	java/lang/String:length	()I
    //   955: iconst_0
    //   956: invokevirtual 201	android/text/SpannableString:setSpan	(Ljava/lang/Object;III)V
    //   959: goto -474 -> 485
    //   962: aload_0
    //   963: invokevirtual 512	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   966: getstatic 1123	buj:dk	I
    //   969: invokevirtual 593	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   972: astore 36
    //   974: new 213	android/text/style/TextAppearanceSpan
    //   977: dup
    //   978: aload_0
    //   979: getstatic 619	buk:h	I
    //   982: invokespecial 221	android/text/style/TextAppearanceSpan:<init>	(Landroid/content/Context;I)V
    //   985: astore 37
    //   987: aload 36
    //   989: iconst_2
    //   990: anewarray 4	java/lang/Object
    //   993: dup
    //   994: iconst_0
    //   995: aload 34
    //   997: aastore
    //   998: dup
    //   999: iconst_1
    //   1000: getstatic 51	cvz:f	Lmx;
    //   1003: aload 25
    //   1005: invokevirtual 752	mx:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1008: aastore
    //   1009: invokestatic 605	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1012: astore 38
    //   1014: new 191	android/text/SpannableString
    //   1017: dup
    //   1018: aload 38
    //   1020: invokespecial 194	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   1023: astore 27
    //   1025: aload 36
    //   1027: ldc_w 595
    //   1030: invokevirtual 599	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1033: aload 36
    //   1035: ldc_w 601
    //   1038: invokevirtual 599	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1041: if_icmpge +416 -> 1457
    //   1044: iconst_1
    //   1045: istore 19
    //   1047: iload 19
    //   1049: ifeq +69 -> 1118
    //   1052: aload 38
    //   1054: aload 34
    //   1056: invokevirtual 608	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   1059: istore 18
    //   1061: iload 19
    //   1063: ifeq +67 -> 1130
    //   1066: aload 38
    //   1068: aload 25
    //   1070: invokevirtual 608	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   1073: istore 19
    //   1075: aload 27
    //   1077: aload 35
    //   1079: iload 18
    //   1081: aload 34
    //   1083: invokevirtual 287	java/lang/String:length	()I
    //   1086: iload 18
    //   1088: iadd
    //   1089: iconst_0
    //   1090: invokevirtual 201	android/text/SpannableString:setSpan	(Ljava/lang/Object;III)V
    //   1093: aload 27
    //   1095: aload 37
    //   1097: iload 19
    //   1099: aload 25
    //   1101: invokevirtual 287	java/lang/String:length	()I
    //   1104: iload 19
    //   1106: iadd
    //   1107: iconst_0
    //   1108: invokevirtual 201	android/text/SpannableString:setSpan	(Ljava/lang/Object;III)V
    //   1111: aload 27
    //   1113: astore 25
    //   1115: goto -630 -> 485
    //   1118: aload 38
    //   1120: aload 34
    //   1122: invokevirtual 599	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1125: istore 18
    //   1127: goto -66 -> 1061
    //   1130: aload 38
    //   1132: aload 25
    //   1134: invokevirtual 599	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1137: istore 19
    //   1139: goto -64 -> 1075
    //   1142: aload 27
    //   1144: getstatic 1126	bub:aE	I
    //   1147: invokevirtual 1050	hf:a	(I)Lhf;
    //   1150: pop
    //   1151: goto -613 -> 538
    //   1154: new 118	com/android/mail/providers/Conversation
    //   1157: dup
    //   1158: aload 8
    //   1160: invokespecial 121	com/android/mail/providers/Conversation:<init>	(Landroid/database/Cursor;)V
    //   1163: getfield 1128	com/android/mail/providers/Conversation:c	Landroid/net/Uri;
    //   1166: astore 34
    //   1168: aload 34
    //   1170: ifnonnull +22 -> 1192
    //   1173: ldc 96
    //   1175: ldc_w 1130
    //   1178: iconst_0
    //   1179: anewarray 4	java/lang/Object
    //   1182: invokestatic 103	cvm:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1185: pop
    //   1186: aconst_null
    //   1187: astore 25
    //   1189: goto -575 -> 614
    //   1192: new 78	android/content/Intent
    //   1195: dup
    //   1196: ldc_w 1132
    //   1199: invokespecial 841	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   1202: astore 25
    //   1204: aload 25
    //   1206: aload_0
    //   1207: invokevirtual 844	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1210: invokevirtual 848	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   1213: pop
    //   1214: aload 25
    //   1216: aload 34
    //   1218: invokevirtual 1136	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   1221: pop
    //   1222: aload 25
    //   1224: ldc_w 1138
    //   1227: aload_1
    //   1228: getfield 708	com/android/mail/providers/Account:g	Landroid/net/Uri;
    //   1231: invokevirtual 860	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   1234: pop
    //   1235: aload 25
    //   1237: ldc_w 1140
    //   1240: aload 13
    //   1242: getfield 106	com/android/mail/providers/Folder:c	Lcus;
    //   1245: getfield 111	cus:b	Landroid/net/Uri;
    //   1248: invokevirtual 860	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   1251: pop
    //   1252: goto -638 -> 614
    //   1255: ldc 96
    //   1257: ldc_w 1142
    //   1260: iconst_2
    //   1261: anewarray 4	java/lang/Object
    //   1264: dup
    //   1265: iconst_0
    //   1266: aload_1
    //   1267: aastore
    //   1268: dup
    //   1269: iconst_1
    //   1270: aload 13
    //   1272: aastore
    //   1273: invokestatic 1144	cvm:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1276: pop
    //   1277: goto -642 -> 635
    //   1280: ldc 96
    //   1282: ldc_w 1146
    //   1285: iconst_0
    //   1286: anewarray 4	java/lang/Object
    //   1289: invokestatic 1144	cvm:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1292: pop
    //   1293: aload 4
    //   1295: aload_0
    //   1296: invokestatic 673	cvz:c	(Landroid/content/Context;)Landroid/graphics/Bitmap;
    //   1299: putfield 1114	ht:a	Landroid/graphics/Bitmap;
    //   1302: aload 24
    //   1304: astore_0
    //   1305: goto -460 -> 845
    //   1308: iload 21
    //   1310: ifeq +20 -> 1330
    //   1313: aload_1
    //   1314: getfield 473	com/android/mail/providers/Account:a	Ljava/lang/String;
    //   1317: astore_0
    //   1318: aload_3
    //   1319: aload_0
    //   1320: invokevirtual 472	hf:b	(Ljava/lang/CharSequence;)Lhf;
    //   1323: pop
    //   1324: aload 24
    //   1326: astore_0
    //   1327: goto -482 -> 845
    //   1330: aload 22
    //   1332: astore_0
    //   1333: goto -15 -> 1318
    //   1336: aload 8
    //   1338: invokestatic 1149	cvz:a	(Landroid/database/Cursor;)Z
    //   1341: pop
    //   1342: aload_0
    //   1343: aload_1
    //   1344: aload_2
    //   1345: aload_3
    //   1346: aload 4
    //   1348: aload 6
    //   1350: aload 8
    //   1352: aload 10
    //   1354: aload 13
    //   1356: lload 14
    //   1358: aload 29
    //   1360: iload 21
    //   1362: aload 22
    //   1364: iload 7
    //   1366: aload 16
    //   1368: invokestatic 1098	cvz:a	(Landroid/content/Context;Lcom/android/mail/providers/Account;Lcfk;Lhf;Lht;Ljava/util/Set;Landroid/database/Cursor;Landroid/content/Intent;Lcom/android/mail/providers/Folder;JLandroid/content/res/Resources;ZLjava/lang/String;ILcfb;)Lcwa;
    //   1371: astore_2
    //   1372: aload_2
    //   1373: getfield 468	cwa:a	Ljava/lang/String;
    //   1376: astore_1
    //   1377: aload_2
    //   1378: getfield 432	cwa:b	Lcwb;
    //   1381: ifnull +20 -> 1401
    //   1384: aload 4
    //   1386: aload_2
    //   1387: getfield 432	cwa:b	Lcwb;
    //   1390: getfield 656	cwb:b	Landroid/graphics/Bitmap;
    //   1393: putfield 1114	ht:a	Landroid/graphics/Bitmap;
    //   1396: aload_1
    //   1397: astore_0
    //   1398: goto -553 -> 845
    //   1401: aload 4
    //   1403: aload_0
    //   1404: invokestatic 673	cvz:c	(Landroid/content/Context;)Landroid/graphics/Bitmap;
    //   1407: putfield 1114	ht:a	Landroid/graphics/Bitmap;
    //   1410: aload_1
    //   1411: astore_0
    //   1412: goto -567 -> 845
    //   1415: astore_0
    //   1416: aconst_null
    //   1417: astore_1
    //   1418: aconst_null
    //   1419: astore_2
    //   1420: goto -1054 -> 366
    //   1423: astore_0
    //   1424: aconst_null
    //   1425: astore_1
    //   1426: aload 26
    //   1428: astore_2
    //   1429: goto -1063 -> 366
    //   1432: goto -656 -> 776
    //   1435: goto -642 -> 793
    //   1438: goto -1260 -> 178
    //   1441: goto -648 -> 793
    //   1444: iconst_0
    //   1445: istore 18
    //   1447: goto -1148 -> 299
    //   1450: aload 27
    //   1452: astore 25
    //   1454: goto -990 -> 464
    //   1457: iconst_0
    //   1458: istore 19
    //   1460: goto -413 -> 1047
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1463	0	paramContext	Context
    //   0	1463	1	paramAccount	com.android.mail.providers.Account
    //   0	1463	2	paramcfk	cfk
    //   0	1463	3	paramhf	hf
    //   0	1463	4	paramht	ht
    //   0	1463	5	paramMap	Map<cwd, cwe>
    //   0	1463	6	paramSet	Set<cwc>
    //   0	1463	7	paramInt1	int
    //   0	1463	8	paramCursor	Cursor
    //   0	1463	9	paramPendingIntent	PendingIntent
    //   0	1463	10	paramIntent	Intent
    //   0	1463	11	paramInt2	int
    //   0	1463	12	paramInt3	int
    //   0	1463	13	paramFolder	Folder
    //   0	1463	14	paramLong	long
    //   0	1463	16	paramcfb	cfb
    //   19	779	17	k	int
    //   347	1099	18	m	int
    //   1045	414	19	n	int
    //   114	684	20	i1	int
    //   68	1293	21	bool	boolean
    //   76	1287	22	str1	String
    //   125	707	23	localObject1	Object
    //   89	1236	24	str2	String
    //   205	1248	25	localObject2	Object
    //   236	1191	26	localCursor	Cursor
    //   251	1200	27	localObject3	Object
    //   247	530	28	localbyw	byw
    //   4	1355	29	localResources	Resources
    //   142	344	30	localhi	hi
    //   150	521	31	str3	String
    //   159	653	32	localHashSet	HashSet
    //   187	556	33	localConversation	Conversation
    //   319	898	34	localObject4	Object
    //   326	752	35	localObject5	Object
    //   972	62	36	str4	String
    //   985	111	37	localTextAppearanceSpan	TextAppearanceSpan
    //   1012	119	38	str5	String
    // Exception table:
    //   from	to	target	type
    //   257	296	359	finally
    //   299	346	359	finally
    //   349	356	359	finally
    //   414	431	359	finally
    //   431	464	359	finally
    //   464	485	359	finally
    //   485	499	359	finally
    //   505	523	359	finally
    //   529	538	359	finally
    //   538	557	359	finally
    //   557	593	359	finally
    //   598	611	359	finally
    //   619	635	359	finally
    //   635	767	359	finally
    //   909	923	359	finally
    //   926	959	359	finally
    //   962	1044	359	finally
    //   1052	1061	359	finally
    //   1066	1075	359	finally
    //   1075	1111	359	finally
    //   1118	1127	359	finally
    //   1130	1139	359	finally
    //   1142	1151	359	finally
    //   1154	1168	359	finally
    //   1173	1186	359	finally
    //   1192	1252	359	finally
    //   1255	1277	359	finally
    //   197	238	1415	finally
    //   238	249	1423	finally
  }
  
  public static void a(Context paramContext, com.android.mail.providers.Account paramAccount, Folder paramFolder, boolean paramBoolean)
  {
    cvm.a("NotifUtils", "Clearing all notifications for %s/%s", new Object[] { c, d });
    Object localObject = b(paramContext);
    cwf localcwf = new cwf(paramAccount, paramFolder);
    ((cwg)localObject).a(localcwf);
    ((cwg)localObject).b(paramContext);
    localObject = ih.a(paramContext);
    ((ih)localObject).a(a(paramAccount.c(), paramFolder));
    a(localcwf, (ih)localObject);
    if (paramBoolean)
    {
      paramAccount = c.b;
      paramFolder = new ContentValues(1);
      paramFolder.put("seen", Integer.valueOf(1));
      paramContext.getContentResolver().update(paramAccount, paramFolder, null, null);
    }
  }
  
  private static void a(Context paramContext, Folder paramFolder, com.android.mail.providers.Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, cwf paramcwf, boolean paramBoolean3, cfb paramcfb, ces paramces)
  {
    ih localih = ih.a(paramContext);
    Object localObject2 = b(paramContext);
    Object localObject3;
    int k;
    if (cvm.a("NotifUtils", 2))
    {
      cvm.c("NotifUtils", "Validating Notification: %s mapSize: %d folder: %s getAttention: %b ignoreUnobtrusive: %b", new Object[] { a((cwg)localObject2), Integer.valueOf(a.size()), d, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      localObject3 = ((cwg)localObject2).b(paramcwf);
      if (localObject3 == null) {
        break label289;
      }
      k = ((Integer)localObject3).intValue();
      label99:
      paramcwf = ((cwg)localObject2).c(paramcwf);
      if (paramcwf == null) {
        break label295;
      }
      m = paramcwf.intValue();
      label120:
      localObject2 = null;
      paramcwf = (cwf)localObject2;
    }
    Cursor localCursor;
    label289:
    label295:
    int n;
    label366:
    int i4;
    cwf localcwf;
    do
    {
      try
      {
        localObject3 = h.buildUpon();
        paramcwf = (cwf)localObject2;
        ((Uri.Builder)localObject3).appendQueryParameter("seen", Boolean.FALSE.toString());
        paramcwf = (cwf)localObject2;
        ((Uri.Builder)localObject3).appendQueryParameter("use_network", Boolean.FALSE.toString());
        paramcwf = (cwf)localObject2;
        localCursor = paramContext.getContentResolver().query(((Uri.Builder)localObject3).build(), chh.k, null, null, null);
        if (localCursor == null)
        {
          paramcwf = localCursor;
          cvm.c("NotifUtils", "The cursor is null, so the specified folder probably does not exist", new Object[0]);
          paramcwf = localCursor;
          a(paramContext, paramAccount, paramFolder, false);
          return;
          cvm.c("NotifUtils", "Validating Notification, mapSize: %d getAttention: %b ignoreUnobtrusive: %b", new Object[] { Integer.valueOf(a.size()), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
          break;
          k = 0;
          break label99;
          m = 0;
          break label120;
        }
        paramcwf = localCursor;
        n = localCursor.getCount();
        if ((m == 0) || (m == n)) {
          break label2300;
        }
        paramcwf = localCursor;
        cvm.c("NotifUtils", "Unseen count doesn't match cursor count.  unseen: %d cursor count: %d", new Object[] { Integer.valueOf(m), Integer.valueOf(n) });
        m = n;
      }
      finally
      {
        if (paramcwf == null) {
          break label920;
        }
        paramcwf.close();
      }
      paramcwf = localCursor;
      i4 = a(paramAccount.c(), paramFolder);
      paramcwf = localCursor;
      localcwf = new cwf(paramAccount, paramFolder);
      if (n != 0) {
        break label484;
      }
      paramcwf = localCursor;
      cvm.c("NotifUtils", "validateNotifications - cancelling %d for %s / %s", new Object[] { Integer.valueOf(i4), cvm.a("NotifUtils", c), cvm.a("NotifUtils", b) });
      paramcwf = localCursor;
      localih.a(i4);
      paramcwf = localCursor;
      a(localcwf, localih);
    } while (localCursor == null);
    localCursor.close();
    return;
    label484:
    localObject2 = null;
    paramcwf = localCursor;
    hf localhf = new hf(paramContext);
    paramcwf = localCursor;
    ht localht = new ht();
    paramcwf = localCursor;
    if (cxd.d())
    {
      paramcwf = localCursor;
      y = paramContext.getResources().getColor(btz.E);
    }
    label562:
    long l1;
    if (n > 1)
    {
      paramcwf = localCursor;
      localhf.a(bub.aK);
      paramcwf = localCursor;
      localhf.d(a);
      paramcwf = localCursor;
      z = 0;
      paramcwf = localCursor;
      w = "email";
      paramcwf = localCursor;
      localObject3 = NotificationActionUtils.c;
      paramcwf = localCursor;
      m = cwp.a(a, c, i4);
      if (m >= 0) {
        break label922;
      }
      l1 = 0L;
      break label2318;
    }
    label640:
    cfk localcfk;
    label920:
    label922:
    label939:
    long l2;
    for (;;)
    {
      paramcwf = localCursor;
      Object localObject1;
      localhf.a(localObject1);
      paramcwf = localCursor;
      NotificationActionUtils.c.a(i4);
      paramcwf = localCursor;
      localObject3 = new Intent("com.android.mail.action.CLEAR_NEW_MAIL_NOTIFICATIONS");
      paramcwf = localCursor;
      ((Intent)localObject3).setPackage(paramContext.getPackageName());
      paramcwf = localCursor;
      ((Intent)localObject3).setData(cxa.a(paramContext, c.b));
      paramcwf = localCursor;
      ((Intent)localObject3).putExtra("mail_account", paramAccount);
      paramcwf = localCursor;
      ((Intent)localObject3).putExtra("folder", paramFolder);
      paramcwf = localCursor;
      ((Intent)localObject3).putExtra("shouldLogNotificaitonDismissal", true);
      paramcwf = localCursor;
      localhf.a(PendingIntent.getService(paramContext, i4, (Intent)localObject3, 0));
      paramcwf = localCursor;
      localhf.a();
      paramcwf = localCursor;
      boolean bool = c.equals(z.i);
      paramcwf = localCursor;
      localcfk = new cfk(paramContext, paramAccount.h(), paramFolder, bool);
      if (bool)
      {
        paramcwf = localCursor;
        a(cfg.b(paramContext, paramAccount.h()), localcfk);
      }
      paramcwf = localCursor;
      if (localcfk.a()) {
        break label951;
      }
      paramcwf = localCursor;
      cvm.c("NotifUtils", "Notifications are disabled for this folder; not notifying", new Object[0]);
      if (localCursor == null) {
        break;
      }
      localCursor.close();
      return;
      paramcwf = localCursor;
      localhf.a(bub.aE);
      break label562;
      paramcwf = localCursor;
      l1 = b[m];
      break label2318;
      paramcwf = localCursor;
      l2 = System.currentTimeMillis();
    }
    label951:
    paramcwf = localCursor;
    ns localns = new ns();
    paramcwf = localCursor;
    HashSet localHashSet = new HashSet();
    label1005:
    label1046:
    Object localObject4;
    label1109:
    label1125:
    int i1;
    if (k > 0)
    {
      paramcwf = localCursor;
      if (localCursor.moveToNext())
      {
        if (n == 1)
        {
          m = 1;
          if (m == 0) {
            break label1109;
          }
          paramcwf = localCursor;
        }
        for (localObject2 = a(paramContext, paramAccount, paramFolder, localCursor);; localObject2 = a(paramContext, paramAccount, paramFolder, null))
        {
          paramcwf = localCursor;
          but localbut = buo.a();
          if (!paramBoolean3) {
            break label2345;
          }
          localObject3 = "new_notification";
          break label2332;
          paramcwf = localCursor;
          localbut.a((String)localObject3, (String)localObject4, paramFolder.b(), n);
          if (localObject2 != null) {
            break label1125;
          }
          paramcwf = localCursor;
          cvm.e("NotifUtils", "Null intent when building notification", new Object[0]);
          if (localCursor == null) {
            break;
          }
          localCursor.close();
          return;
          m = 0;
          break label1005;
          paramcwf = localCursor;
        }
        paramcwf = localCursor;
        localObject3 = a(paramContext, (Intent)localObject2);
        paramcwf = localCursor;
        a(paramContext, paramAccount, localcfk, localhf, localht, localns, localHashSet, i4, localCursor, (PendingIntent)localObject3, (Intent)localObject2, k, n, paramFolder, l2, paramcfb);
        i1 = 1;
        paramcfb = (cfb)localObject3;
        label1180:
        paramcwf = localCursor;
        localObject3 = new SparseArray();
        paramcwf = localCursor;
        localObject2 = localns.keySet().iterator();
        for (;;)
        {
          paramcwf = localCursor;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          paramcwf = localCursor;
          localObject4 = (cwd)((Iterator)localObject2).next();
          paramcwf = localCursor;
          ((SparseArray)localObject3).put(a, localObject4);
        }
        paramcwf = localCursor;
        paramBoolean3 = localcfk.c();
        paramcwf = localCursor;
        localObject4 = localcfk.b();
        paramcwf = localCursor;
        if (!localcfk.d())
        {
          m = 1;
          if ((!paramBoolean2) && (m != 0))
          {
            paramcwf = localCursor;
            cvm.b("NotifUtils", "Setting Alert Once", new Object[0]);
            paramcwf = localCursor;
            localhf.a(8, true);
          }
          paramcwf = localCursor;
          cvm.c("NotifUtils", "Account: %s vibrate: %s", new Object[] { cvm.a("NotifUtils", c), Boolean.toString(localcfk.c()) });
          int i3 = 0;
          int i2 = 0;
          paramcwf = localCursor;
          cvm.b("NotifUtils", "getAttention=%s,oldWhen=%s", new Object[] { Boolean.valueOf(paramBoolean1), Long.valueOf(l1) });
          m = i3;
          if (paramBoolean1)
          {
            m = i3;
            if (l1 == 0L)
            {
              paramcwf = localCursor;
              m = i3;
              if (cfg.b(paramContext, paramAccount.h()).b())
              {
                m = i2;
                if (paramBoolean3) {
                  m = 2;
                }
                paramcwf = localCursor;
                if (!TextUtils.isEmpty((CharSequence)localObject4)) {
                  break label1904;
                }
                localObject2 = null;
                label1482:
                paramcwf = localCursor;
                localhf.a((Uri)localObject2);
                paramcwf = localCursor;
                cvm.c("NotifUtils", "New email in %s vibrateWhen: %s, playing notification: %s", new Object[] { cvm.a("NotifUtils", c), Boolean.valueOf(paramBoolean3), localObject4 });
              }
            }
          }
          if (i1 == 0) {
            break label2270;
          }
          paramcwf = localCursor;
          localhf.b(m | 0x4);
          if (l1 != 0L)
          {
            paramcwf = localCursor;
            localhf.d(null);
          }
          paramcwf = localCursor;
          localhf.a(localht);
          if (n <= 1) {
            break label2361;
          }
        }
      }
    }
    label1752:
    label1904:
    label2104:
    label2270:
    label2300:
    label2318:
    label2332:
    label2345:
    label2353:
    label2361:
    for (int m = 1;; m = 0)
    {
      paramcwf = localCursor;
      localObject2 = new hf(paramContext).a(a(paramContext, n)).b(a);
      paramcwf = localCursor;
      d = paramcfb;
      paramcwf = localCursor;
      i = k;
      paramcwf = localCursor;
      z = 1;
      paramcwf = localCursor;
      w = "email";
      paramcwf = localCursor;
      paramcfb = ((hf)localObject2).a(l2);
      paramcwf = localCursor;
      if (cxd.d())
      {
        paramcwf = localCursor;
        y = paramContext.getResources().getColor(btz.E);
      }
      if (m != 0)
      {
        paramcwf = localCursor;
        r = a(paramAccount, paramFolder);
        paramcwf = localCursor;
        s = true;
        paramcwf = localCursor;
        paramcfb.a(bub.aK);
        paramcwf = localCursor;
        A = paramcfb.b();
        paramcwf = localCursor;
        localih.a(i4, localhf.b());
        paramcwf = localCursor;
        paramFolder = g;
        paramcwf = localCursor;
      }
      for (;;)
      {
        try
        {
          paramcwf = (SparseArray)g.get(localcwf);
          if (paramcwf != null)
          {
            m = paramcwf.size();
            k = 0;
            if (k < m)
            {
              paramContext = (cwd)paramcwf.valueAt(k);
              if ((cwd)((SparseArray)localObject3).get(a) == null)
              {
                localih.a(a);
                cvm.b("NotifUtils", "canceling conversation notification %d", new Object[] { Integer.valueOf(a) });
              }
              k += 1;
              continue;
              m = 0;
              break;
              paramcwf = localCursor;
              localObject2 = Uri.parse((String)localObject4);
              break label1482;
              paramcwf = localCursor;
              paramcfb.a(bub.aE);
              break label1752;
            }
          }
          paramcfb = localns.entrySet().iterator();
          if (!paramcfb.hasNext()) {
            break label2104;
          }
          localObject2 = (Map.Entry)paramcfb.next();
          localObject4 = (cwd)((Map.Entry)localObject2).getKey();
          if (paramcwf == null)
          {
            paramContext = null;
            if ((cxd.f()) || (paramContext == null) || (b < b))
            {
              paramContext = (cwe)((Map.Entry)localObject2).getValue();
              a.a(b);
              localih.a(a, a.b());
              cvm.b("NotifUtils", "notifying conversation notification %s", new Object[] { ((Map.Entry)localObject2).getKey() });
            }
          }
          else
          {
            paramContext = (cwd)paramcwf.get(a);
          }
        }
        finally
        {
          paramcwf = localCursor;
        }
      }
      g.put(localcwf, localObject3);
      paramcwf = localCursor;
      paramContext = h;
      paramcwf = localCursor;
      try
      {
        paramFolder = (Set)h.get(localcwf);
        paramcwf = localHashSet.iterator();
        while (paramcwf.hasNext())
        {
          paramcfb = (cwc)paramcwf.next();
          if ((paramFolder == null) || (!paramFolder.contains(paramcfb)))
          {
            l1 = a;
            cvm.b("NotifUtils", "NotifUtils: Sending event for new notif for conversation %s", new Object[] { Long.valueOf(l1) });
            paramces.a(paramAccount, l1, b);
          }
        }
        h.put(localcwf, localHashSet);
      }
      finally
      {
        paramcwf = localCursor;
      }
      while (localCursor != null)
      {
        localCursor.close();
        return;
        paramcwf = localCursor;
        cvm.c("NotifUtils", "event info not configured - not notifying", new Object[0]);
      }
      break;
      i1 = 0;
      paramcfb = (cfb)localObject2;
      break label1180;
      n = m;
      if (m <= k) {
        break label366;
      }
      n = k;
      break label366;
      if (l1 == 0L) {
        break label939;
      }
      l2 = l1;
      break label640;
      for (;;)
      {
        if (m == 0) {
          break label2353;
        }
        localObject4 = "conversation_style";
        break;
        localObject3 = "updated_notification";
      }
      localObject4 = "digest_style";
      break label1046;
    }
  }
  
  public static void a(Context paramContext, cus paramcus, Uri paramUri)
  {
    cvm.a("NotifUtils", "markConversationAsSeen=%s,%s", new Object[] { paramcus, paramUri });
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("conversationUri", paramUri.toString());
    localContentValues.put("seen", Integer.valueOf(1));
    paramContext.getContentResolver().update(b, localContentValues, null, null);
  }
  
  public static void a(Context paramContext, boolean paramBoolean, Uri paramUri, cus paramcus, cfb paramcfb, ces paramces)
  {
    gmn localgmn = glh.a.b();
    Object localObject1;
    Object localObject2;
    if (paramUri == null)
    {
      localObject1 = null;
      if (paramcus != null) {
        break label264;
      }
      localObject2 = null;
      label22:
      cvm.c("NotifUtils", "resendNotifications cancelExisting: %b, account: %s, folder: %s", new Object[] { Boolean.valueOf(paramBoolean), localObject1, localObject2 });
      if (paramBoolean)
      {
        cvm.b("NotifUtils", "resendNotifications - cancelling all", new Object[0]);
        localObject1 = ih.a(paramContext);
        c.cancelAll();
        if (Build.VERSION.SDK_INT <= 19) {
          ((ih)localObject1).a(new ii(b.getPackageName()));
        }
      }
      localObject1 = ba.keySet().iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label360;
      }
      localObject2 = (cwf)((Iterator)localObject1).next();
      Folder localFolder = b;
      int k = a(a.c(), localFolder);
      if ((paramUri != null) && (!hbc.a(paramUri, a.g)) && (paramcus != null) && (!hbc.a(paramcus, c)))
      {
        cvm.b("NotifUtils", "resendNotifications - not resending %s / %s because it doesn't match %s / %s", new Object[] { a.g, c, paramUri, paramcus });
        continue;
        localObject1 = cvm.a("NotifUtils", paramUri.toString());
        break;
        label264:
        localObject2 = cvm.a("NotifUtils", paramcus.toString());
        break label22;
      }
      cvm.b("NotifUtils", "resendNotifications - resending %s / %s", new Object[] { a.g, c });
      NotificationActionUtils.NotificationAction localNotificationAction = (NotificationActionUtils.NotificationAction)NotificationActionUtils.a.a(k);
      if (localNotificationAction == null) {
        a(paramContext, localFolder, a, true, false, (cwf)localObject2, false, paramcfb, paramces);
      } else {
        NotificationActionUtils.d(paramContext, localNotificationAction);
      }
    }
    label360:
    glh.a.a(localgmn, "Notifications.resend");
  }
  
  public static void a(cfg paramcfg, cfk paramcfk)
  {
    if (d.contains("inbox-notifications-enabled"))
    {
      if (!d.contains("notifications-enabled")) {
        paramcfk.a(d.getBoolean("inbox-notifications-enabled", true));
      }
      e.remove("inbox-notifications-enabled").apply();
    }
  }
  
  private static void a(cwf paramcwf, ih arg1)
  {
    synchronized (g)
    {
      SparseArray localSparseArray = (SparseArray)g.get(paramcwf);
      if (localSparseArray != null)
      {
        int k = 0;
        int m = localSparseArray.size();
        while (k < m)
        {
          ???.a(localSparseArray.keyAt(k));
          k += 1;
        }
        g.remove(paramcwf);
      }
    }
    synchronized (h)
    {
      h.remove(paramcwf);
      return;
      paramcwf = finally;
      throw paramcwf;
    }
  }
  
  private static void a(hf paramhf, HashSet<String> paramHashSet)
  {
    paramHashSet = paramHashSet.iterator();
    while (paramHashSet.hasNext())
    {
      String str = (String)paramHashSet.next();
      if (!TextUtils.isEmpty(str))
      {
        str = "mailto:".concat(str);
        C.add(str);
      }
    }
  }
  
  private static void a(String paramString, HashSet<String> paramHashSet)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = Address.c(paramString);
      if (localObject != null)
      {
        localObject = a;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label35;
        }
        paramHashSet.add(localObject);
      }
    }
    return;
    label35:
    cvm.c("NotifUtils", "Unable to grab email from \"%s\" for notification tagging", new Object[] { cvm.a("NotifUtils", paramString) });
  }
  
  private static boolean a(Cursor paramCursor)
  {
    int k = paramCursor.getPosition();
    do
    {
      if (!Conversationj) {
        return true;
      }
    } while (paramCursor.moveToNext());
    paramCursor.moveToPosition(k);
    return false;
  }
  
  private static cwg b(Context paramContext)
  {
    try
    {
      if (a == null)
      {
        cwg localcwg = new cwg();
        a = localcwg;
        localcwg.a(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private static String b(String paramString)
  {
    Object localObject2 = null;
    Address localAddress = Address.c(paramString);
    if (localAddress == null) {}
    for (Object localObject1 = null; !TextUtils.isEmpty((CharSequence)localObject1); localObject1 = b)
    {
      localObject1 = Address.b((String)localObject1);
      return (String)localObject1;
    }
    if (localAddress == null)
    {
      localObject1 = localObject2;
      label41:
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label65;
      }
    }
    for (;;)
    {
      localObject1 = paramString;
      if (paramString != null) {
        break;
      }
      return "";
      localObject1 = a;
      break label41;
      label65:
      paramString = (String)localObject1;
    }
  }
  
  private static Bitmap c(Context paramContext)
  {
    Bitmap localBitmap2 = (Bitmap)c.get();
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      localBitmap1 = BitmapFactory.decodeResource(paramContext.getResources(), bub.b);
      c = new WeakReference(localBitmap1);
    }
    return localBitmap1;
  }
}

/* Location:
 * Qualified Name:     cvz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */