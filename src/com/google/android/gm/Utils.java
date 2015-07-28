package com.google.android.gm;

import android.accounts.AccountManager;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.Contacts;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TextAppearanceSpan;
import android.util.Pair;
import com.android.mail.providers.Folder;
import com.android.mail.providers.UIProvider;
import com.google.android.common.html.parser.HTML.Attribute;
import com.google.android.common.html.parser.HTML.Element;
import com.google.android.common.html.parser.HTML4;
import com.google.android.common.html.parser.HtmlDocument;
import com.google.android.common.html.parser.HtmlDocument.Node;
import com.google.android.common.html.parser.HtmlDocument.Tag;
import com.google.android.common.html.parser.HtmlDocument.TagAttribute;
import com.google.android.common.html.parser.HtmlTree;
import com.google.android.common.html.parser.HtmlTree.DefaultPlainTextConverter;
import com.google.android.common.html.parser.HtmlTree.PlainTextConverter;
import com.google.android.common.html.parser.HtmlTree.PlainTextConverterFactory;
import com.google.android.gm.comm.longshadow.LongShadowUtils;
import com.google.android.gm.persistence.Persistence;
import com.google.android.gm.preference.GmailPreferenceActivity;
import com.google.android.gm.provider.Gmail;
import com.google.android.gm.provider.Gmail.BecomeActiveNetworkCursor;
import com.google.android.gm.provider.Gmail.ConversationCursor;
import com.google.android.gm.provider.Gmail.MessageCursor;
import com.google.android.gm.provider.Gmail.Settings;
import com.google.android.gm.provider.Label;
import com.google.android.gm.provider.LogUtils;
import com.google.android.gm.provider.UiProvider;
import com.google.android.gsf.Gservices;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Utils
{
  private static final Intent BUG_REPORT_INTENT;
  private static final ComponentName GMAIL_LABEL_SHORTCUT_COMPONENT_NAME = new ComponentName("com.google.android.gm", "com.google.android.gm.CreateShortcutActivityGmail");
  private static final HtmlTree.PlainTextConverterFactory GMAIL_MESSAGE_CONVERTER_FACTORY;
  private static final ComponentName GOOGLE_MAIL_CONVERSATION_LIST_COMPONENT_NAME;
  private static final ComponentName GOOGLE_MAIL_LABEL_SHORTCUT_COMPONENT_NAME = new ComponentName("com.google.android.gm", "com.google.android.gm.CreateShortcutActivityGoogleMail");
  private static final Set<Integer> GOOGLE_MAIL_MCC_SET;
  private static final Map<String, com.android.mail.providers.Account> UI_ACCOUNT_MAP;
  private static NotificationMap sActiveNotificationMap;
  private static Map<String, ArrayList<Integer>> sActiveSendErrorNotificationsMap = new ConcurrentHashMap();
  public static Bitmap sDefaultSingleNotifIcon;
  private static CharSequence sDraftPluralString;
  private static CharSequence sDraftSingularString;
  private static CharacterStyle sDraftsStyleSpan;
  private static ScheduleSyncTask sLastScheduleSyncTask;
  private static CharSequence sMeString;
  public static Bitmap sMultipleNotifIcon;
  private static CharacterStyle sReadStyleSpan;
  private static CharSequence sSendFailedString;
  private static CharSequence sSendingString;
  private static CharacterStyle sUnreadStyleSpan;
  private static String sVersionCode;
  
  static
  {
    GOOGLE_MAIL_CONVERSATION_LIST_COMPONENT_NAME = new ComponentName("com.google.android.gm", "com.google.android.gm.ConversationListActivityGoogleMail");
    GOOGLE_MAIL_MCC_SET = ImmutableSet.of(Integer.valueOf(262));
    sVersionCode = null;
    BUG_REPORT_INTENT = new Intent("android.intent.action.BUG_REPORT");
    UI_ACCOUNT_MAP = Maps.newHashMap();
    GMAIL_MESSAGE_CONVERTER_FACTORY = new HtmlTree.PlainTextConverterFactory()
    {
      public HtmlTree.PlainTextConverter createInstance()
      {
        return new Utils.GmailMessagePlainTextConverter();
      }
    };
    sActiveNotificationMap = null;
    sUnreadStyleSpan = null;
  }
  
  private static Uri addGmailParamsToUrl(Context paramContext, String paramString)
  {
    Object localObject = Uri.parse(replaceLocale(paramString)).buildUpon();
    String str = getVersionCode(paramContext);
    paramString = (String)localObject;
    if (str != null) {
      paramString = ((Uri.Builder)localObject).appendQueryParameter("version", str);
    }
    localObject = paramContext.getResources().getConfiguration();
    int i;
    if ((GOOGLE_MAIL_MCC_SET.contains(Integer.valueOf(mcc))) || (haveGoogleMailActivitiesBeenEnabled(paramContext)))
    {
      i = 1;
      if (i == 0) {
        break label91;
      }
    }
    label91:
    for (paramContext = "1";; paramContext = "0")
    {
      return paramString.appendQueryParameter("googleMail", paramContext).build();
      i = 0;
      break;
    }
  }
  
  public static void cacheGoogleAccountList(Context paramContext, boolean paramBoolean, android.accounts.Account[] paramArrayOfAccount)
  {
    ArrayList localArrayList = Lists.newArrayList();
    int i = 0;
    while (i < paramArrayOfAccount.length)
    {
      localArrayList.add(name);
      i += 1;
    }
    Persistence.getInstance().cacheConfiguredGoogleAccounts(paramContext, paramBoolean, localArrayList);
  }
  
  public static void cancelAllNotifications(Context paramContext)
  {
    ((NotificationManager)paramContext.getSystemService("notification")).cancelAll();
    clearAllNotfications(paramContext);
  }
  
  public static void cancelAndResendNotifications(Context paramContext)
  {
    ((NotificationManager)paramContext.getSystemService("notification")).cancelAll();
    NotificationMap localNotificationMap = getNotificationMap(paramContext);
    Iterator localIterator = localNotificationMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      NotificationKey localNotificationKey = (NotificationKey)localIterator.next();
      Intent localIntent = new Intent();
      localIntent.putExtra("count", localNotificationMap.getUnread(localNotificationKey));
      localIntent.putExtra("unseenCount", localNotificationMap.getUnseen(localNotificationKey));
      localIntent.putExtra("account", account);
      validateNotifications(paramContext, localIntent, account, true, label, false, localNotificationKey);
    }
  }
  
  public static void clearAllNotfications(Context paramContext)
  {
    LogUtils.v("Gmail", "Clearing all notifications.", new Object[0]);
    NotificationMap localNotificationMap = getNotificationMap(paramContext);
    localNotificationMap.clear();
    localNotificationMap.saveNotificationMap(paramContext);
  }
  
  public static void clearLabelNotification(Context paramContext, String paramString1, String paramString2)
  {
    LogUtils.v("Gmail", "Clearing all notifications for %s/%s", new Object[] { paramString1, paramString2 });
    NotificationMap localNotificationMap = getNotificationMap(paramContext);
    localNotificationMap.remove(new NotificationKey(paramString1, paramString2));
    localNotificationMap.saveNotificationMap(paramContext);
  }
  
  /* Error */
  private static void configureLatestEventInfoFromConversation(Context paramContext, Notification.Builder paramBuilder, Gmail.ConversationCursor paramConversationCursor, PendingIntent paramPendingIntent, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 163	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   4: astore 15
    //   6: aload_0
    //   7: invokevirtual 323	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   10: invokestatic 329	com/google/android/gm/comm/longshadow/LongShadowUtils:getContentProviderMailAccess	(Landroid/content/ContentResolver;)Lcom/google/android/gm/provider/Gmail;
    //   13: astore 14
    //   15: ldc_w 294
    //   18: ldc_w 331
    //   21: iconst_2
    //   22: anewarray 4	java/lang/Object
    //   25: dup
    //   26: iconst_0
    //   27: iload 5
    //   29: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   32: aastore
    //   33: dup
    //   34: iconst_1
    //   35: iload 6
    //   37: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   40: aastore
    //   41: invokestatic 334	com/google/android/gm/provider/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   44: pop
    //   45: aload_0
    //   46: aload 4
    //   48: invokestatic 338	com/google/android/gm/persistence/Persistence:getAccountInbox	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   51: aload 7
    //   53: invokestatic 344	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   56: ifne +397 -> 453
    //   59: iconst_1
    //   60: istore 8
    //   62: iload 8
    //   64: ifeq +395 -> 459
    //   67: aload_0
    //   68: aload 4
    //   70: aload 7
    //   72: invokestatic 350	com/google/android/gm/provider/LabelManager:getLabel	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gm/provider/Label;
    //   75: invokevirtual 356	com/google/android/gm/provider/Label:getName	()Ljava/lang/String;
    //   78: astore 7
    //   80: iload 6
    //   82: iconst_1
    //   83: if_icmple +423 -> 506
    //   86: aload 15
    //   88: ldc_w 357
    //   91: iconst_1
    //   92: anewarray 4	java/lang/Object
    //   95: dup
    //   96: iconst_0
    //   97: iload 6
    //   99: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   102: aastore
    //   103: invokevirtual 361	android/content/res/Resources:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   106: astore 12
    //   108: aload_1
    //   109: aload_0
    //   110: iconst_1
    //   111: invokestatic 365	com/google/android/gm/Utils:getDefaultNotificationIcon	(Landroid/content/Context;Z)Landroid/graphics/Bitmap;
    //   114: invokevirtual 371	android/app/Notification$Builder:setLargeIcon	(Landroid/graphics/Bitmap;)Landroid/app/Notification$Builder;
    //   117: pop
    //   118: aload_1
    //   119: aload 12
    //   121: invokevirtual 375	android/app/Notification$Builder:setContentTitle	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   124: pop
    //   125: invokestatic 380	com/android/mail/utils/Utils:isRunningJellybeanOrLater	()Z
    //   128: ifeq +358 -> 486
    //   131: aload_0
    //   132: invokevirtual 163	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   135: ldc_w 381
    //   138: invokevirtual 385	android/content/res/Resources:getInteger	(I)I
    //   141: istore 10
    //   143: iload 8
    //   145: ifeq +7 -> 152
    //   148: aload 7
    //   150: astore 4
    //   152: aload_1
    //   153: aload 4
    //   155: invokevirtual 388	android/app/Notification$Builder:setSubText	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   158: pop
    //   159: new 390	android/app/Notification$InboxStyle
    //   162: dup
    //   163: aload_1
    //   164: invokespecial 393	android/app/Notification$InboxStyle:<init>	(Landroid/app/Notification$Builder;)V
    //   167: astore 16
    //   169: aload 16
    //   171: aload 12
    //   173: invokevirtual 397	android/app/Notification$InboxStyle:setBigContentTitle	(Ljava/lang/CharSequence;)Landroid/app/Notification$InboxStyle;
    //   176: pop
    //   177: iconst_0
    //   178: istore 6
    //   180: aload_2
    //   181: invokevirtual 402	com/google/android/gm/provider/Gmail$ConversationCursor:getHasUnreadMessage	()Z
    //   184: ifeq +716 -> 900
    //   187: aconst_null
    //   188: astore 4
    //   190: iconst_0
    //   191: istore 9
    //   193: aload 14
    //   195: aload_2
    //   196: invokevirtual 405	com/google/android/gm/provider/Gmail$ConversationCursor:getAccount	()Ljava/lang/String;
    //   199: aload_2
    //   200: invokevirtual 409	com/google/android/gm/provider/Gmail$ConversationCursor:getConversationId	()J
    //   203: invokevirtual 415	com/google/android/gm/provider/Gmail:getDetachedMessageCursorForConversationId	(Ljava/lang/String;J)Lcom/google/android/gm/provider/Gmail$MessageCursor;
    //   206: astore 13
    //   208: ldc_w 417
    //   211: astore 11
    //   213: aload 13
    //   215: aload 13
    //   217: invokevirtual 422	com/google/android/gm/provider/Gmail$MessageCursor:count	()I
    //   220: iconst_1
    //   221: isub
    //   222: invokevirtual 426	com/google/android/gm/provider/Gmail$MessageCursor:moveTo	(I)Z
    //   225: ifeq +669 -> 894
    //   228: aload 13
    //   230: invokevirtual 429	com/google/android/gm/provider/Gmail$MessageCursor:getFromAddress	()Ljava/lang/String;
    //   233: astore 11
    //   235: aload 11
    //   237: invokestatic 432	com/google/android/gm/Utils:getDisplayableSender	(Ljava/lang/String;)Ljava/lang/String;
    //   240: astore 4
    //   242: iload 9
    //   244: istore 8
    //   246: aload 13
    //   248: aload 13
    //   250: invokevirtual 435	com/google/android/gm/provider/Gmail$MessageCursor:position	()I
    //   253: iconst_1
    //   254: isub
    //   255: invokevirtual 426	com/google/android/gm/provider/Gmail$MessageCursor:moveTo	(I)Z
    //   258: ifeq +27 -> 285
    //   261: aload 13
    //   263: invokevirtual 438	com/google/android/gm/provider/Gmail$MessageCursor:getIsUnread	()Z
    //   266: ifeq -24 -> 242
    //   269: aload 11
    //   271: aload 13
    //   273: invokevirtual 429	com/google/android/gm/provider/Gmail$MessageCursor:getFromAddress	()Ljava/lang/String;
    //   276: invokevirtual 444	java/lang/String:contentEquals	(Ljava/lang/CharSequence;)Z
    //   279: ifne -37 -> 242
    //   282: iconst_1
    //   283: istore 8
    //   285: new 446	android/text/SpannableStringBuilder
    //   288: dup
    //   289: invokespecial 447	android/text/SpannableStringBuilder:<init>	()V
    //   292: astore 11
    //   294: iload 8
    //   296: ifeq +169 -> 465
    //   299: new 446	android/text/SpannableStringBuilder
    //   302: dup
    //   303: invokespecial 447	android/text/SpannableStringBuilder:<init>	()V
    //   306: astore 4
    //   308: aload 15
    //   310: ldc_w 448
    //   313: invokevirtual 385	android/content/res/Resources:getInteger	(I)I
    //   316: istore 8
    //   318: aload_0
    //   319: aload_2
    //   320: invokevirtual 451	com/google/android/gm/provider/Gmail$ConversationCursor:getFromSnippetInstructions	()Ljava/lang/String;
    //   323: aload 11
    //   325: aload 4
    //   327: iload 8
    //   329: iconst_0
    //   330: iconst_0
    //   331: iconst_0
    //   332: iconst_0
    //   333: iconst_1
    //   334: invokestatic 455	com/google/android/gm/Utils:getStyledSenderSnippet	(Landroid/content/Context;Ljava/lang/String;Landroid/text/SpannableStringBuilder;Landroid/text/SpannableStringBuilder;IZZZZZ)V
    //   337: aload 16
    //   339: aload_0
    //   340: aload 11
    //   342: invokevirtual 458	android/text/SpannableStringBuilder:toString	()Ljava/lang/String;
    //   345: aload_2
    //   346: invokevirtual 461	com/google/android/gm/provider/Gmail$ConversationCursor:getSubject	()Ljava/lang/String;
    //   349: aload_2
    //   350: invokevirtual 464	com/google/android/gm/provider/Gmail$ConversationCursor:getSnippet	()Ljava/lang/String;
    //   353: invokestatic 468	com/google/android/gm/Utils:getSingleMessageInboxLine	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/CharSequence;
    //   356: invokevirtual 471	android/app/Notification$InboxStyle:addLine	(Ljava/lang/CharSequence;)Landroid/app/Notification$InboxStyle;
    //   359: pop
    //   360: iload 6
    //   362: iconst_1
    //   363: iadd
    //   364: istore 6
    //   366: aload 13
    //   368: invokevirtual 474	com/google/android/gm/provider/Gmail$MessageCursor:close	()V
    //   371: iload 6
    //   373: iload 10
    //   375: if_icmpgt +10 -> 385
    //   378: aload_2
    //   379: invokevirtual 476	com/google/android/gm/provider/Gmail$ConversationCursor:next	()Z
    //   382: ifne +509 -> 891
    //   385: aload 12
    //   387: astore_0
    //   388: aload_0
    //   389: astore_2
    //   390: aload 7
    //   392: ifnull +31 -> 423
    //   395: aload_0
    //   396: astore_2
    //   397: aload_0
    //   398: ifnull +25 -> 423
    //   401: aload 15
    //   403: ldc_w 477
    //   406: iconst_2
    //   407: anewarray 4	java/lang/Object
    //   410: dup
    //   411: iconst_0
    //   412: aload 7
    //   414: aastore
    //   415: dup
    //   416: iconst_1
    //   417: aload_0
    //   418: aastore
    //   419: invokevirtual 361	android/content/res/Resources:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   422: astore_2
    //   423: aload_2
    //   424: ifnull +9 -> 433
    //   427: aload_1
    //   428: aload_2
    //   429: invokevirtual 480	android/app/Notification$Builder:setTicker	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   432: pop
    //   433: iload 5
    //   435: iconst_1
    //   436: if_icmple +10 -> 446
    //   439: aload_1
    //   440: iload 5
    //   442: invokevirtual 484	android/app/Notification$Builder:setNumber	(I)Landroid/app/Notification$Builder;
    //   445: pop
    //   446: aload_1
    //   447: aload_3
    //   448: invokevirtual 488	android/app/Notification$Builder:setContentIntent	(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;
    //   451: pop
    //   452: return
    //   453: iconst_0
    //   454: istore 8
    //   456: goto -394 -> 62
    //   459: aconst_null
    //   460: astore 7
    //   462: goto -382 -> 80
    //   465: aload 11
    //   467: aload 4
    //   469: invokevirtual 492	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    //   472: pop
    //   473: goto -136 -> 337
    //   476: astore_0
    //   477: aload 13
    //   479: astore_1
    //   480: aload_1
    //   481: invokevirtual 474	com/google/android/gm/provider/Gmail$MessageCursor:close	()V
    //   484: aload_0
    //   485: athrow
    //   486: aload 4
    //   488: astore_0
    //   489: iload 8
    //   491: ifeq +6 -> 497
    //   494: aload 7
    //   496: astore_0
    //   497: aload_1
    //   498: aload_0
    //   499: invokevirtual 495	android/app/Notification$Builder:setContentText	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   502: pop
    //   503: goto -118 -> 385
    //   506: aload_2
    //   507: invokestatic 499	com/google/android/gm/Utils:seekToLatestUnreadConversation	(Lcom/google/android/gm/provider/Gmail$ConversationCursor;)Z
    //   510: pop
    //   511: aconst_null
    //   512: astore 11
    //   514: aload 14
    //   516: aload_2
    //   517: invokevirtual 405	com/google/android/gm/provider/Gmail$ConversationCursor:getAccount	()Ljava/lang/String;
    //   520: aload_2
    //   521: invokevirtual 409	com/google/android/gm/provider/Gmail$ConversationCursor:getConversationId	()J
    //   524: invokevirtual 415	com/google/android/gm/provider/Gmail:getDetachedMessageCursorForConversationId	(Ljava/lang/String;J)Lcom/google/android/gm/provider/Gmail$MessageCursor;
    //   527: astore 14
    //   529: aload 14
    //   531: aload 14
    //   533: invokevirtual 422	com/google/android/gm/provider/Gmail$MessageCursor:count	()I
    //   536: iconst_1
    //   537: isub
    //   538: invokevirtual 426	com/google/android/gm/provider/Gmail$MessageCursor:moveTo	(I)Z
    //   541: ifeq +339 -> 880
    //   544: aload 14
    //   546: invokevirtual 429	com/google/android/gm/provider/Gmail$MessageCursor:getFromAddress	()Ljava/lang/String;
    //   549: astore 11
    //   551: aload 11
    //   553: invokestatic 432	com/google/android/gm/Utils:getDisplayableSender	(Ljava/lang/String;)Ljava/lang/String;
    //   556: astore 12
    //   558: aload_1
    //   559: aload_0
    //   560: aload 11
    //   562: invokestatic 502	com/google/android/gm/Utils:getSenderAddress	(Ljava/lang/String;)Ljava/lang/String;
    //   565: invokestatic 506	com/google/android/gm/Utils:getContactIcon	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   568: invokevirtual 371	android/app/Notification$Builder:setLargeIcon	(Landroid/graphics/Bitmap;)Landroid/app/Notification$Builder;
    //   571: pop
    //   572: aload 11
    //   574: astore 13
    //   576: aload 12
    //   578: astore 11
    //   580: aload 14
    //   582: invokevirtual 435	com/google/android/gm/provider/Gmail$MessageCursor:position	()I
    //   585: istore 6
    //   587: iconst_0
    //   588: istore 9
    //   590: aload 14
    //   592: aload 14
    //   594: invokevirtual 435	com/google/android/gm/provider/Gmail$MessageCursor:position	()I
    //   597: iconst_1
    //   598: isub
    //   599: invokevirtual 426	com/google/android/gm/provider/Gmail$MessageCursor:moveTo	(I)Z
    //   602: ifeq +42 -> 644
    //   605: aload 14
    //   607: invokevirtual 438	com/google/android/gm/provider/Gmail$MessageCursor:getIsUnread	()Z
    //   610: ifeq -20 -> 590
    //   613: aload 14
    //   615: invokevirtual 435	com/google/android/gm/provider/Gmail$MessageCursor:position	()I
    //   618: istore 6
    //   620: iload 9
    //   622: ifne +255 -> 877
    //   625: aload 13
    //   627: aload 14
    //   629: invokevirtual 429	com/google/android/gm/provider/Gmail$MessageCursor:getFromAddress	()Ljava/lang/String;
    //   632: invokevirtual 444	java/lang/String:contentEquals	(Ljava/lang/CharSequence;)Z
    //   635: ifne +242 -> 877
    //   638: iconst_1
    //   639: istore 9
    //   641: goto -51 -> 590
    //   644: invokestatic 380	com/android/mail/utils/Utils:isRunningJellybeanOrLater	()Z
    //   647: ifeq +178 -> 825
    //   650: iload 9
    //   652: ifeq +153 -> 805
    //   655: new 446	android/text/SpannableStringBuilder
    //   658: dup
    //   659: invokespecial 447	android/text/SpannableStringBuilder:<init>	()V
    //   662: astore 11
    //   664: new 446	android/text/SpannableStringBuilder
    //   667: dup
    //   668: invokespecial 447	android/text/SpannableStringBuilder:<init>	()V
    //   671: astore 12
    //   673: aload 15
    //   675: ldc_w 448
    //   678: invokevirtual 385	android/content/res/Resources:getInteger	(I)I
    //   681: istore 10
    //   683: aload_0
    //   684: aload_2
    //   685: invokevirtual 451	com/google/android/gm/provider/Gmail$ConversationCursor:getFromSnippetInstructions	()Ljava/lang/String;
    //   688: aload 11
    //   690: aload 12
    //   692: iload 10
    //   694: iconst_0
    //   695: iconst_0
    //   696: iconst_0
    //   697: iconst_0
    //   698: iconst_1
    //   699: invokestatic 455	com/google/android/gm/Utils:getStyledSenderSnippet	(Landroid/content/Context;Ljava/lang/String;Landroid/text/SpannableStringBuilder;Landroid/text/SpannableStringBuilder;IZZZZZ)V
    //   702: aload_1
    //   703: aload 11
    //   705: invokevirtual 375	android/app/Notification$Builder:setContentTitle	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   708: pop
    //   709: aload 11
    //   711: invokevirtual 458	android/text/SpannableStringBuilder:toString	()Ljava/lang/String;
    //   714: astore 11
    //   716: aload_1
    //   717: aload_0
    //   718: aload_2
    //   719: invokevirtual 461	com/google/android/gm/provider/Gmail$ConversationCursor:getSubject	()Ljava/lang/String;
    //   722: invokestatic 510	com/google/android/gm/Utils:getSingleMessageLittleText	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/CharSequence;
    //   725: invokevirtual 495	android/app/Notification$Builder:setContentText	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   728: pop
    //   729: iload 8
    //   731: ifeq +7 -> 738
    //   734: aload 7
    //   736: astore 4
    //   738: aload_1
    //   739: aload 4
    //   741: invokevirtual 388	android/app/Notification$Builder:setSubText	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   744: pop
    //   745: iload 9
    //   747: ifeq +13 -> 760
    //   750: aload_1
    //   751: aload_0
    //   752: iconst_1
    //   753: invokestatic 365	com/google/android/gm/Utils:getDefaultNotificationIcon	(Landroid/content/Context;Z)Landroid/graphics/Bitmap;
    //   756: invokevirtual 371	android/app/Notification$Builder:setLargeIcon	(Landroid/graphics/Bitmap;)Landroid/app/Notification$Builder;
    //   759: pop
    //   760: new 512	android/app/Notification$BigTextStyle
    //   763: dup
    //   764: aload_1
    //   765: invokespecial 513	android/app/Notification$BigTextStyle:<init>	(Landroid/app/Notification$Builder;)V
    //   768: astore 4
    //   770: aload 14
    //   772: iload 6
    //   774: invokevirtual 426	com/google/android/gm/provider/Gmail$MessageCursor:moveTo	(I)Z
    //   777: pop
    //   778: aload 4
    //   780: aload_0
    //   781: aload_2
    //   782: invokevirtual 461	com/google/android/gm/provider/Gmail$ConversationCursor:getSubject	()Ljava/lang/String;
    //   785: aload 14
    //   787: invokestatic 517	com/google/android/gm/Utils:getSingleMessageBigText	(Landroid/content/Context;Ljava/lang/String;Lcom/google/android/gm/provider/Gmail$MessageCursor;)Ljava/lang/CharSequence;
    //   790: invokevirtual 521	android/app/Notification$BigTextStyle:bigText	(Ljava/lang/CharSequence;)Landroid/app/Notification$BigTextStyle;
    //   793: pop
    //   794: aload 11
    //   796: astore_0
    //   797: aload 14
    //   799: invokevirtual 474	com/google/android/gm/provider/Gmail$MessageCursor:close	()V
    //   802: goto -414 -> 388
    //   805: aload_1
    //   806: aload 11
    //   808: invokevirtual 375	android/app/Notification$Builder:setContentTitle	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   811: pop
    //   812: goto -96 -> 716
    //   815: astore_0
    //   816: aload 14
    //   818: astore_1
    //   819: aload_1
    //   820: invokevirtual 474	com/google/android/gm/provider/Gmail$MessageCursor:close	()V
    //   823: aload_0
    //   824: athrow
    //   825: aload_1
    //   826: aload_0
    //   827: aload 11
    //   829: aload_2
    //   830: invokevirtual 461	com/google/android/gm/provider/Gmail$ConversationCursor:getSubject	()Ljava/lang/String;
    //   833: invokestatic 525	com/google/android/gm/Utils:getSingleMessageNotificationTitle	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/CharSequence;
    //   836: invokevirtual 375	android/app/Notification$Builder:setContentTitle	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   839: pop
    //   840: aload 4
    //   842: astore_0
    //   843: iload 8
    //   845: ifeq +6 -> 851
    //   848: aload 7
    //   850: astore_0
    //   851: aload_1
    //   852: aload_0
    //   853: invokevirtual 495	android/app/Notification$Builder:setContentText	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   856: pop
    //   857: aload 11
    //   859: astore_0
    //   860: goto -63 -> 797
    //   863: astore_0
    //   864: aload 11
    //   866: astore_1
    //   867: goto -48 -> 819
    //   870: astore_0
    //   871: aload 4
    //   873: astore_1
    //   874: goto -394 -> 480
    //   877: goto -287 -> 590
    //   880: aconst_null
    //   881: astore 11
    //   883: ldc_w 417
    //   886: astore 13
    //   888: goto -308 -> 580
    //   891: goto -711 -> 180
    //   894: aconst_null
    //   895: astore 4
    //   897: goto -655 -> 242
    //   900: goto -529 -> 371
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	903	0	paramContext	Context
    //   0	903	1	paramBuilder	Notification.Builder
    //   0	903	2	paramConversationCursor	Gmail.ConversationCursor
    //   0	903	3	paramPendingIntent	PendingIntent
    //   0	903	4	paramString1	String
    //   0	903	5	paramInt1	int
    //   0	903	6	paramInt2	int
    //   0	903	7	paramString2	String
    //   60	784	8	i	int
    //   191	555	9	j	int
    //   141	552	10	k	int
    //   211	671	11	localObject1	Object
    //   106	585	12	localObject2	Object
    //   206	681	13	localObject3	Object
    //   13	804	14	localObject4	Object
    //   4	670	15	localResources	Resources
    //   167	171	16	localInboxStyle	android.app.Notification.InboxStyle
    // Exception table:
    //   from	to	target	type
    //   213	242	476	finally
    //   246	282	476	finally
    //   285	294	476	finally
    //   299	337	476	finally
    //   337	360	476	finally
    //   465	473	476	finally
    //   529	572	815	finally
    //   580	587	815	finally
    //   590	620	815	finally
    //   625	638	815	finally
    //   644	650	815	finally
    //   655	716	815	finally
    //   716	729	815	finally
    //   738	745	815	finally
    //   750	760	815	finally
    //   760	794	815	finally
    //   805	812	815	finally
    //   825	840	815	finally
    //   851	857	815	finally
    //   514	529	863	finally
    //   193	208	870	finally
  }
  
  public static boolean containsAccount(android.accounts.Account paramAccount, android.accounts.Account[] paramArrayOfAccount)
  {
    int j = paramArrayOfAccount.length;
    int i = 0;
    while (i < j)
    {
      if (paramAccount.equals(paramArrayOfAccount[i])) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static void createErrorNotification(Context paramContext, String paramString1, String paramString2, long paramLong, int paramInt1, int paramInt2)
  {
    int i = getGmailAccountCount(paramContext);
    String str = paramContext.getResources().getQuantityString(paramInt1, i);
    Notification.Builder localBuilder = new Notification.Builder(paramContext);
    Object localObject1;
    Object localObject2;
    if (i > 1)
    {
      localObject1 = paramContext.getResources().getString(paramInt2, new Object[] { paramString1 });
      localObject2 = new SpannableString(String.format(str, new Object[] { localObject1 }));
      paramInt1 = ((SpannableString)localObject2).toString().indexOf((String)localObject1);
      ((SpannableString)localObject2).setSpan(new TextAppearanceSpan(paramContext, 2131558491), paramInt1, ((String)localObject1).length() + paramInt1, 0);
      localBuilder.setContentTitle((CharSequence)localObject2);
    }
    for (;;)
    {
      paramInt1 = Objects.hashCode(new Object[] { Long.valueOf(paramLong), paramString2 });
      localObject1 = createViewSendErrorIntent(paramContext, paramString1, paramLong);
      localObject2 = (NotificationManager)paramContext.getSystemService("notification");
      localBuilder.setSmallIcon(17301624);
      localBuilder.setWhen(System.currentTimeMillis());
      localBuilder.setContentText(paramString2);
      localBuilder.setLargeIcon(BitmapFactory.decodeResource(paramContext.getResources(), 17301624));
      localBuilder.setTicker(str);
      localBuilder.setContentIntent(PendingIntent.getActivity(paramContext, -1, (Intent)localObject1, 0));
      updateSendErrorNotificationMap(paramString1, paramInt1);
      ((NotificationManager)localObject2).notify(paramInt1, localBuilder.getNotification());
      return;
      localBuilder.setContentTitle(str);
    }
  }
  
  private static String createNotificationString(NotificationMap paramNotificationMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    Object localObject = Sets.newHashSet();
    Iterator localIterator = paramNotificationMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      NotificationKey localNotificationKey = (NotificationKey)localIterator.next();
      Integer localInteger1 = paramNotificationMap.getUnread(localNotificationKey);
      Integer localInteger2 = paramNotificationMap.getUnseen(localNotificationKey);
      if ((localInteger1 == null) || (localInteger1.intValue() == 0))
      {
        ((Set)localObject).add(localNotificationKey);
      }
      else
      {
        if (i > 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append(localNotificationKey.toString() + " (" + localInteger1 + ", " + localInteger2 + ")");
        i += 1;
      }
    }
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramNotificationMap.remove((NotificationKey)((Iterator)localObject).next());
    }
    return localStringBuilder.toString();
  }
  
  public static Intent createViewConversationIntent(Context paramContext, String paramString1, String paramString2, Gmail.ConversationCursor paramConversationCursor)
  {
    com.android.mail.providers.Account localAccount = getUiProviderAccount(paramContext, paramString1);
    paramString2 = getUiProviderAccountFolder(paramContext, paramString1, paramString2);
    if ((paramString2 == null) || (paramString1 == null))
    {
      LogUtils.e("Gmail", "Null account or folder.  account: %s folder: %s", new Object[] { localAccount, paramString2 });
      return null;
    }
    if (paramConversationCursor == null) {
      return com.android.mail.utils.Utils.createViewFolderIntent(paramString2, localAccount);
    }
    return com.android.mail.utils.Utils.createViewConversationIntent(UiProvider.getConversationForConversationCursor(paramContext, paramString1, paramConversationCursor), paramString2, localAccount);
  }
  
  public static Intent createViewFolderIntent(Context paramContext, String paramString1, String paramString2)
  {
    com.android.mail.providers.Account localAccount = UiProvider.getAccountObject(paramContext, paramString1);
    return com.android.mail.utils.Utils.createViewFolderIntent(UiProvider.getSparseFolderObject(paramContext, null, paramString1, paramString2), localAccount);
  }
  
  private static Intent createViewSendErrorIntent(Context paramContext, String paramString, long paramLong)
  {
    return createViewConversationIntent(paramContext, paramString, "^f", null);
  }
  
  public static void enableLabelShortcutActivity(Context paramContext)
  {
    enableLabelShortcutActivity(paramContext, haveGoogleMailActivitiesBeenEnabled(paramContext));
  }
  
  public static void enableLabelShortcutActivity(Context paramContext, boolean paramBoolean)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (paramBoolean)
    {
      paramContext = GOOGLE_MAIL_LABEL_SHORTCUT_COMPONENT_NAME;
      if (!paramBoolean) {
        break label43;
      }
    }
    label43:
    for (ComponentName localComponentName = GMAIL_LABEL_SHORTCUT_COMPONENT_NAME;; localComponentName = GOOGLE_MAIL_LABEL_SHORTCUT_COMPONENT_NAME)
    {
      localPackageManager.setComponentEnabledSetting(localComponentName, 2, 1);
      localPackageManager.setComponentEnabledSetting(paramContext, 1, 1);
      return;
      paramContext = GMAIL_LABEL_SHORTCUT_COMPONENT_NAME;
      break;
    }
  }
  
  public static void enableShortcutIntentFilter(Context paramContext)
  {
    Persistence localPersistence = Persistence.getInstance();
    String str = localPersistence.getActiveAccount(paramContext);
    android.accounts.Account[] arrayOfAccount = AccountManager.get(paramContext).getAccountsByType("com.google");
    if ((arrayOfAccount.length > 0) && (!shortcutActivityEnabled(paramContext))) {
      startShortcutEnablerService(paramContext, 0name);
    }
    int j = arrayOfAccount.length;
    int i = 0;
    if (i < j) {
      if (!name.equals(str)) {}
    }
    while (arrayOfAccount.length <= 0)
    {
      return;
      i += 1;
      break;
    }
    localPersistence.setActiveAccount(paramContext, 0name);
  }
  
  private static ArrayList<Long> findContacts(Context paramContext, Collection<String> paramCollection)
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = new StringBuilder();
    String[] arrayOfString = new String[paramCollection.size()];
    ((ArrayList)localObject1).addAll(paramCollection);
    Arrays.fill(arrayOfString, "?");
    ((StringBuilder)localObject2).append("data1 IN (").append(TextUtils.join(",", arrayOfString)).append(")");
    paramContext = paramContext.getContentResolver();
    paramCollection = ContactsContract.CommonDataKinds.Email.CONTENT_URI;
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject1 = (String[])((ArrayList)localObject1).toArray(new String[0]);
    paramContext = paramContext.query(paramCollection, new String[] { "contact_id" }, (String)localObject2, (String[])localObject1, null);
    paramCollection = new ArrayList();
    if (paramContext == null) {
      return paramCollection;
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
  
  public static String format(String paramString, Object... paramVarArgs)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    format(localStringBuffer, paramString, paramVarArgs);
    return localStringBuffer.toString();
  }
  
  public static void format(StringBuffer paramStringBuffer, String paramString, Object... paramVarArgs)
  {
    int n = paramString.length();
    int k = 0;
    int j = 0;
    int i = 0;
    if (j < n) {
      if (paramString.charAt(j) == '%') {}
    }
    for (;;)
    {
      j += 1;
      break;
      if (j < n - 1) {
        if (paramString.charAt(j + 1) == 's')
        {
          paramStringBuffer.append(paramString.substring(k, j));
          k = i + 1;
          paramStringBuffer.append(paramVarArgs[i]);
          int m = j + 2;
          j += 1;
          i = k;
          k = m;
          continue;
          if (k < n) {
            paramStringBuffer.append(paramString.substring(k));
          }
          return;
        }
      }
    }
  }
  
  public static String formatPlural(Context paramContext, int paramInt1, int paramInt2)
  {
    return String.format(paramContext.getResources().getQuantityText(paramInt1, paramInt2).toString(), new Object[] { Integer.valueOf(paramInt2) });
  }
  
  private static Bitmap getContactIcon(Context paramContext, String paramString)
  {
    Object localObject1;
    if (paramString == null) {
      localObject1 = null;
    }
    for (;;)
    {
      return (Bitmap)localObject1;
      Object localObject2 = null;
      localObject1 = null;
      Object localObject3 = findContacts(paramContext, Arrays.asList(new String[] { paramString }));
      paramString = (String)localObject2;
      int i;
      int j;
      label69:
      Cursor localCursor;
      if (localObject3 != null)
      {
        paramString = paramContext.getResources();
        i = paramString.getDimensionPixelSize(17104902);
        j = paramString.getDimensionPixelSize(17104901);
        localObject3 = ((ArrayList)localObject3).iterator();
        do
        {
          paramString = (String)localObject1;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          long l = ((Long)((Iterator)localObject3).next()).longValue();
          paramString = Uri.withAppendedPath(ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, l), "photo");
          localCursor = paramContext.getContentResolver().query(paramString, new String[] { "data15" }, null, null, null);
        } while (localCursor == null);
        localObject2 = localObject1;
      }
      try
      {
        if (localCursor.moveToFirst())
        {
          paramString = localCursor.getBlob(0);
          localObject2 = localObject1;
          if (paramString != null)
          {
            localObject1 = BitmapFactory.decodeStream(new ByteArrayInputStream(paramString));
            paramString = (String)localObject1;
            if (localObject1 != null)
            {
              paramString = (String)localObject1;
              if (((Bitmap)localObject1).getHeight() < i) {
                paramString = Bitmap.createScaledBitmap((Bitmap)localObject1, j, i, true);
              }
            }
            localObject2 = paramString;
            if (paramString != null)
            {
              localCursor.close();
              localObject1 = paramString;
              if (paramString != null) {
                continue;
              }
              return getDefaultNotificationIcon(paramContext, false);
            }
          }
        }
        localCursor.close();
        localObject1 = localObject2;
        break label69;
      }
      finally
      {
        localCursor.close();
      }
    }
  }
  
  private static Bitmap getDefaultNotificationIcon(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (sMultipleNotifIcon == null) {
        sMultipleNotifIcon = BitmapFactory.decodeResource(paramContext.getResources(), 2130837604);
      }
      return sMultipleNotifIcon;
    }
    if (sDefaultSingleNotifIcon == null) {
      sDefaultSingleNotifIcon = BitmapFactory.decodeResource(paramContext.getResources(), 2130837568);
    }
    return sDefaultSingleNotifIcon;
  }
  
  private static String getDisplayableSender(String paramString)
  {
    EmailAddress localEmailAddress = EmailAddress.getEmailAddress(paramString);
    Object localObject2 = localEmailAddress.getName();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = localEmailAddress.getAddress();
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = paramString;
    }
    return (String)localObject2;
  }
  
  private static int getGmailAccountCount(Context paramContext)
  {
    int j = 1;
    paramContext = Persistence.getInstance().getCachedConfiguredGoogleAccounts(paramContext, true);
    int i = j;
    if (paramContext != null)
    {
      i = j;
      if (paramContext.size() > 0) {
        i = paramContext.size();
      }
    }
    return i;
  }
  
  public static int getLabelDisplayCount(Label paramLabel)
  {
    int i = 0;
    if (!paramLabel.getDisplayNoConversationCount())
    {
      if (paramLabel.getDisplayTotalConversationCount()) {
        i = paramLabel.getNumConversations();
      }
    }
    else {
      return i;
    }
    return paramLabel.getNumUnreadConversations();
  }
  
  public static String getLabelNotificationSummary(Context paramContext, String paramString1, String paramString2)
  {
    Persistence localPersistence = Persistence.getInstance();
    if (!localPersistence.shouldNotifyForLabel(paramContext, paramString1, paramString2)) {
      return null;
    }
    boolean bool1 = localPersistence.shouldVibrateForLabel(paramContext, paramString1, paramString2);
    boolean bool2 = localPersistence.shouldNotifyOnceForLabel(paramContext, paramString1, paramString2);
    int i;
    if (localPersistence.getNotificationRingtoneUriForLabel(paramContext, paramString1, paramString2) != null)
    {
      i = 1;
      if (i == 0) {
        break label114;
      }
      if ((!bool1) || (!bool2)) {
        break label83;
      }
      i = 2131493288;
    }
    for (;;)
    {
      return paramContext.getResources().getString(i);
      i = 0;
      break;
      label83:
      if (bool1)
      {
        i = 2131493289;
      }
      else if (bool2)
      {
        i = 2131493290;
      }
      else
      {
        i = 2131493291;
        continue;
        label114:
        if ((bool1) && (bool2)) {
          i = 2131493292;
        } else if (bool1) {
          i = 2131493293;
        } else if (bool2) {
          i = 2131493294;
        } else {
          i = 2131493295;
        }
      }
    }
  }
  
  private static String getMessageBodyWithoutElidedText(Gmail.MessageCursor paramMessageCursor)
  {
    return getMessageBodyWithoutElidedText(paramMessageCursor.getBody());
  }
  
  public static String getMessageBodyWithoutElidedText(String paramString)
  {
    paramString = com.android.mail.utils.Utils.getHtmlTree(paramString);
    paramString.setPlainTextConverterFactory(GMAIL_MESSAGE_CONVERTER_FACTORY);
    return paramString.getPlainText();
  }
  
  private static int getNotificationId(String paramString1, String paramString2)
  {
    return paramString1.hashCode() ^ 0x1 ^ paramString2.hashCode();
  }
  
  private static NotificationMap getNotificationMap(Context paramContext)
  {
    try
    {
      if (sActiveNotificationMap == null)
      {
        sActiveNotificationMap = new NotificationMap(null);
        sActiveNotificationMap.loadNotificationMap(paramContext);
      }
      paramContext = sActiveNotificationMap;
      return paramContext;
    }
    finally {}
  }
  
  private static String getSenderAddress(String paramString)
  {
    String str2 = EmailAddress.getEmailAddress(paramString).getAddress();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = paramString;
    }
    return str1;
  }
  
  private static CharSequence getSingleMessageBigText(Context paramContext, String paramString, Gmail.MessageCursor paramMessageCursor)
  {
    TextAppearanceSpan localTextAppearanceSpan = new TextAppearanceSpan(paramContext, 2131558468);
    String str = getMessageBodyWithoutElidedText(paramMessageCursor);
    if (!TextUtils.isEmpty(str)) {}
    for (paramMessageCursor = str.replaceAll("\\n\\s+", "\n"); TextUtils.isEmpty(paramString); paramMessageCursor = "") {
      return str;
    }
    if (TextUtils.isEmpty(paramMessageCursor))
    {
      paramContext = new SpannableString(paramString);
      paramContext.setSpan(localTextAppearanceSpan, 0, paramString.length(), 0);
      return paramContext;
    }
    paramContext = paramContext.getResources().getString(2131493106);
    if (paramContext.indexOf("%2$s") > paramContext.indexOf("%1$s"))
    {
      i = 1;
      paramContext = String.format(paramContext, new Object[] { paramString, paramMessageCursor });
      paramMessageCursor = new SpannableString(paramContext);
      if (i == 0) {
        break label173;
      }
    }
    label173:
    for (int i = paramContext.indexOf(paramString);; i = paramContext.lastIndexOf(paramString))
    {
      paramMessageCursor.setSpan(localTextAppearanceSpan, i, paramString.length() + i, 0);
      return paramMessageCursor;
      i = 0;
      break;
    }
  }
  
  private static CharSequence getSingleMessageInboxLine(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      paramString3 = new TextAppearanceSpan(paramContext, 2131558468);
      if (!TextUtils.isEmpty(paramString1)) {
        break;
      }
      return paramString2;
      paramString2 = paramString3;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      paramContext = new SpannableString(paramString1);
      paramContext.setSpan(paramString3, 0, paramString1.length(), 0);
      return paramContext;
    }
    String str1 = paramContext.getResources().getString(2131493105);
    paramContext = new TextAppearanceSpan(paramContext, 2131558469);
    String str2 = String.format(str1, new Object[] { paramString1, paramString2 });
    SpannableString localSpannableString = new SpannableString(str2);
    int i;
    if (str1.indexOf("%2$s") < str1.indexOf("%1$s"))
    {
      j = 1;
      if (j == 0) {
        break label205;
      }
      i = str2.lastIndexOf(paramString1);
      label151:
      if (j == 0) {
        break label216;
      }
    }
    label205:
    label216:
    for (int j = str2.lastIndexOf(paramString2);; j = str2.indexOf(paramString2))
    {
      localSpannableString.setSpan(paramString3, i, paramString1.length() + i, 0);
      localSpannableString.setSpan(paramContext, j, paramString2.length() + j, 0);
      return localSpannableString;
      j = 0;
      break;
      i = str2.indexOf(paramString1);
      break label151;
    }
  }
  
  private static CharSequence getSingleMessageLittleText(Context paramContext, String paramString)
  {
    paramContext = new TextAppearanceSpan(paramContext, 2131558468);
    SpannableString localSpannableString = new SpannableString(paramString);
    localSpannableString.setSpan(paramContext, 0, paramString.length(), 0);
    return localSpannableString;
  }
  
  private static CharSequence getSingleMessageNotificationTitle(Context paramContext, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return paramString1;
    }
    Object localObject = paramContext.getResources().getString(2131493337);
    if (((String)localObject).indexOf("%2$s") > ((String)localObject).indexOf("%1$s"))
    {
      i = 1;
      paramString1 = String.format((String)localObject, new Object[] { paramString1, paramString2 });
      localObject = new SpannableString(paramString1);
      if (i == 0) {
        break label112;
      }
    }
    label112:
    for (int i = paramString1.lastIndexOf(paramString2);; i = paramString1.indexOf(paramString2))
    {
      ((SpannableString)localObject).setSpan(new TextAppearanceSpan(paramContext, 2131558469), i, paramString2.length() + i, 0);
      return (CharSequence)localObject;
      i = 0;
      break;
    }
  }
  
  public static void getStyledSenderSnippet(Context paramContext, String paramString, SpannableStringBuilder paramSpannableStringBuilder1, SpannableStringBuilder paramSpannableStringBuilder2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    Object localObject = paramContext.getResources();
    if (sUnreadStyleSpan == null)
    {
      sUnreadStyleSpan = new StyleSpan(1);
      sReadStyleSpan = new StyleSpan(0);
      sDraftsStyleSpan = new ForegroundColorSpan(((Resources)localObject).getColor(2131296273));
      sMeString = paramContext.getText(2131493019);
      sDraftSingularString = ((Resources)localObject).getQuantityText(2131820546, 1);
      sDraftPluralString = ((Resources)localObject).getQuantityText(2131820546, 2);
      localObject = new SpannableString(paramContext.getText(2131493017));
      ((SpannableString)localObject).setSpan(CharacterStyle.wrap(sDraftsStyleSpan), 0, ((SpannableString)localObject).length(), 0);
      sSendingString = (CharSequence)localObject;
      sSendFailedString = paramContext.getText(2131493018);
    }
    Gmail.getSenderSnippet(paramString, paramSpannableStringBuilder1, paramSpannableStringBuilder2, paramInt, sUnreadStyleSpan, sReadStyleSpan, sDraftsStyleSpan, sMeString, sDraftSingularString, sDraftPluralString, sSendingString, sSendFailedString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
  }
  
  /* Error */
  private static com.android.mail.providers.Account getUiProviderAccount(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: getstatic 110	com/google/android/gm/Utils:UI_ACCOUNT_MAP	Ljava/util/Map;
    //   3: astore 4
    //   5: aload 4
    //   7: monitorenter
    //   8: getstatic 110	com/google/android/gm/Utils:UI_ACCOUNT_MAP	Ljava/util/Map;
    //   11: aload_1
    //   12: invokeinterface 1045 2 0
    //   17: checkcast 1047	com/android/mail/providers/Account
    //   20: astore_2
    //   21: aload_2
    //   22: astore_3
    //   23: aload_2
    //   24: ifnonnull +62 -> 86
    //   27: aload_1
    //   28: invokestatic 1050	com/google/android/gm/provider/UiProvider:getAccountUri	(Ljava/lang/String;)Landroid/net/Uri;
    //   31: astore_3
    //   32: aload_0
    //   33: invokevirtual 323	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   36: aload_3
    //   37: getstatic 1055	com/android/mail/providers/UIProvider:ACCOUNTS_PROJECTION	[Ljava/lang/String;
    //   40: aconst_null
    //   41: aconst_null
    //   42: aconst_null
    //   43: invokevirtual 780	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   46: astore_3
    //   47: aload_2
    //   48: astore_0
    //   49: aload_3
    //   50: invokeinterface 858 1 0
    //   55: ifeq +23 -> 78
    //   58: new 1047	com/android/mail/providers/Account
    //   61: dup
    //   62: aload_3
    //   63: invokespecial 1058	com/android/mail/providers/Account:<init>	(Landroid/database/Cursor;)V
    //   66: astore_0
    //   67: getstatic 110	com/google/android/gm/Utils:UI_ACCOUNT_MAP	Ljava/util/Map;
    //   70: aload_1
    //   71: aload_0
    //   72: invokeinterface 1062 3 0
    //   77: pop
    //   78: aload_3
    //   79: invokeinterface 791 1 0
    //   84: aload_0
    //   85: astore_3
    //   86: aload 4
    //   88: monitorexit
    //   89: aload_3
    //   90: areturn
    //   91: aload_3
    //   92: invokeinterface 791 1 0
    //   97: aload_0
    //   98: athrow
    //   99: astore_0
    //   100: aload 4
    //   102: monitorexit
    //   103: aload_0
    //   104: athrow
    //   105: astore_0
    //   106: goto -15 -> 91
    //   109: astore_0
    //   110: goto -19 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	paramContext	Context
    //   0	113	1	paramString	String
    //   20	28	2	localAccount	com.android.mail.providers.Account
    //   22	70	3	localObject	Object
    //   3	98	4	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   8	21	99	finally
    //   27	47	99	finally
    //   78	84	99	finally
    //   86	89	99	finally
    //   91	99	99	finally
    //   100	103	99	finally
    //   67	78	105	finally
    //   49	67	109	finally
  }
  
  private static Folder getUiProviderAccountFolder(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject = null;
    paramString1 = UiProvider.getAccountLabelUri(paramString1, paramString2);
    paramString1 = paramContext.getContentResolver().query(paramString1, UIProvider.FOLDERS_PROJECTION, null, null, null);
    paramContext = (Context)localObject;
    try
    {
      if (paramString1.moveToFirst()) {
        paramContext = new Folder(paramString1);
      }
      return paramContext;
    }
    finally
    {
      paramString1.close();
    }
  }
  
  public static String getUnreadCountString(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getResources();
    int i = paramContext.getInteger(2131361820);
    if (paramInt > i) {
      return paramContext.getString(2131493081, new Object[] { Integer.valueOf(i) });
    }
    if (paramInt <= 0) {
      return "";
    }
    return String.valueOf(paramInt);
  }
  
  public static String getVersionCode(Context paramContext)
  {
    if (sVersionCode == null) {}
    try
    {
      sVersionCode = String.valueOf(getPackageManagergetPackageInfogetPackageName0versionCode);
      return sVersionCode;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        LogUtils.e("Gmail", "Error finding package %s", new Object[] { getApplicationInfopackageName });
      }
    }
  }
  
  public static boolean haveGoogleMailActivitiesBeenEnabled(Context paramContext)
  {
    return paramContext.getPackageManager().getComponentEnabledSetting(GOOGLE_MAIL_CONVERSATION_LIST_COMPONENT_NAME) == 1;
  }
  
  public static boolean isAccountValid(Context paramContext, com.android.mail.providers.Account paramAccount)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (paramAccount != null)
    {
      paramContext = AccountManager.get(paramContext).getAccountsByType("com.google");
      paramAccount = name;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < paramContext.length)
      {
        if (paramAccount.equals(name)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean isGoogleFeedbackInstalled(Context paramContext)
  {
    return isSupportingServiceInstalled(paramContext, BUG_REPORT_INTENT);
  }
  
  private static boolean isSupportingServiceInstalled(Context paramContext, Intent paramIntent)
  {
    boolean bool = false;
    try
    {
      paramContext = paramContext.getPackageManager();
      if (paramContext.queryIntentServices(paramIntent, 65536).size() > 0) {
        bool = true;
      }
      return bool;
    }
    catch (UnsupportedOperationException paramContext) {}
    return false;
  }
  
  public static boolean isValidGoogleAccount(Context paramContext, String paramString)
  {
    paramContext = AccountManager.get(paramContext).getAccountsByType("com.google");
    return containsAccount(new android.accounts.Account(paramString, "com.google"), paramContext);
  }
  
  public static StringBuilder joinStrings(Set<String> paramSet, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      String str = (String)paramSet.next();
      if (i > 0) {
        localStringBuilder.append(paramString);
      }
      localStringBuilder.append(str);
      i += 1;
    }
    return localStringBuilder;
  }
  
  public static void launchGoogleFeedback(Context paramContext)
  {
    ServiceConnection local2 = new ServiceConnection()
    {
      public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        try
        {
          paramAnonymousIBinder.transact(1, Parcel.obtain(), null, 0);
          return;
        }
        catch (RemoteException paramAnonymousComponentName)
        {
          LogUtils.e("Gmail", paramAnonymousComponentName, "Error connecting to bug report service", new Object[0]);
        }
      }
      
      public void onServiceDisconnected(ComponentName paramAnonymousComponentName) {}
    };
    paramContext.bindService(BUG_REPORT_INTENT, local2, 1);
  }
  
  public static String makeQueryString(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      return paramString1;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      return "label:" + paramString2;
    }
    return "";
  }
  
  private static void openUrl(Context paramContext, Uri paramUri)
  {
    if ((paramUri == null) || (TextUtils.isEmpty(paramUri.toString())))
    {
      LogUtils.wtf("Gmail", "invalid url in Utils.openUrl(): %s", new Object[] { paramUri });
      return;
    }
    paramUri = new Intent("android.intent.action.VIEW", paramUri);
    paramUri.putExtra("com.android.browser.application_id", paramContext.getPackageName());
    paramContext.startActivity(paramUri);
  }
  
  private static String replaceLocale(String paramString)
  {
    Object localObject = paramString;
    if (paramString.contains("%locale%"))
    {
      localObject = Locale.getDefault();
      localObject = paramString.replace("%locale%", ((Locale)localObject).getLanguage() + "_" + ((Locale)localObject).getCountry().toLowerCase());
    }
    return (String)localObject;
  }
  
  private static boolean seekToLatestUnreadConversation(Gmail.ConversationCursor paramConversationCursor)
  {
    int i = paramConversationCursor.position();
    do
    {
      if (paramConversationCursor.getHasUnreadMessage()) {
        return true;
      }
    } while (paramConversationCursor.next());
    paramConversationCursor.moveTo(i);
    return false;
  }
  
  public static void setNewEmailIndicator(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("count", 0);
    int j = paramIntent.getIntExtra("unseenCount", 0);
    String str1 = paramIntent.getStringExtra("account");
    String str2 = paramIntent.getStringExtra("tagLabel");
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = false;
    NotificationMap localNotificationMap = getNotificationMap(paramContext);
    NotificationKey localNotificationKey = new NotificationKey(str1, str2);
    if (i == 0) {
      localNotificationMap.remove(localNotificationKey);
    }
    for (;;)
    {
      localNotificationMap.saveNotificationMap(paramContext);
      if (LogUtils.isLoggable("Gmail", 2)) {
        LogUtils.v("Gmail", "New email: %s mapSize: %d getAttention: %b", new Object[] { createNotificationString(localNotificationMap), Integer.valueOf(localNotificationMap.size()), Boolean.valueOf(bool2) });
      }
      validateNotifications(paramContext, paramIntent, str1, bool2, str2, bool1, localNotificationKey);
      return;
      bool1 = bool3;
      if (!localNotificationMap.containsKey(localNotificationKey)) {
        bool1 = true;
      }
      localNotificationMap.put(localNotificationKey, i, j);
      bool2 = paramIntent.getBooleanExtra("getAttention", false);
    }
  }
  
  public static boolean shortcutActivityEnabled(Context paramContext)
  {
    paramContext = paramContext.getPackageManager();
    return (paramContext.getComponentEnabledSetting(GOOGLE_MAIL_LABEL_SHORTCUT_COMPONENT_NAME) == 1) || (paramContext.getComponentEnabledSetting(GMAIL_LABEL_SHORTCUT_COMPONENT_NAME) == 1);
  }
  
  public static void showAbout(Context paramContext)
  {
    showPreferences(paramContext, 2131755291L);
  }
  
  public static void showFeedbackSurvey(Context paramContext)
  {
    String str2 = Gservices.getString(paramContext.getContentResolver(), "gmail_feedback_url");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "http://support.google.com/mail?p=android_survey&hl=%locale%";
    }
    openUrl(paramContext, addGmailParamsToUrl(paramContext, str1));
  }
  
  public static void showHelp(Context paramContext, ApplicationMenuHandler.HelpCallback paramHelpCallback)
  {
    showHelp(paramContext, paramHelpCallback.getHelpContext());
  }
  
  public static void showHelp(Context paramContext, String paramString)
  {
    Uri.Builder localBuilder2 = addGmailParamsToUrl(paramContext, Gservices.getString(paramContext.getContentResolver(), "gmail_context_sensitive_help_url", "http://support.google.com/mobile/?hl=%locale%")).buildUpon();
    Uri.Builder localBuilder1 = localBuilder2;
    if (paramString != null) {
      localBuilder1 = localBuilder2.appendQueryParameter("p", paramString);
    }
    openUrl(paramContext, localBuilder1.build());
  }
  
  public static void showOpenSourceLicenses(Context paramContext)
  {
    paramContext.startActivity(new Intent(paramContext, LicenseActivity.class));
  }
  
  private static void showPreferences(Context paramContext, long paramLong)
  {
    Intent localIntent = new Intent(paramContext, GmailPreferenceActivity.class);
    if (paramLong != -1L) {
      localIntent.putExtra("initial_fragment_id", paramLong);
    }
    paramContext.startActivity(localIntent);
  }
  
  public static void showSettings(Context paramContext)
  {
    showPreferences(paramContext, -1L);
  }
  
  private static void startShortcutEnablerService(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, ShortcutEnablerService.class);
    localIntent.putExtra("account-name", paramString);
    paramContext.startService(localIntent);
  }
  
  public static void startSync(String paramString)
  {
    if (sLastScheduleSyncTask != null) {
      sLastScheduleSyncTask.cancel(false);
    }
    sLastScheduleSyncTask = new ScheduleSyncTask(paramString);
    sLastScheduleSyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }
  
  private static void updateSendErrorNotificationMap(String paramString, int paramInt)
  {
    ArrayList localArrayList2 = (ArrayList)sActiveSendErrorNotificationsMap.get(paramString);
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null) {
      localArrayList1 = new ArrayList();
    }
    localArrayList1.add(Integer.valueOf(paramInt));
    sActiveSendErrorNotificationsMap.put(paramString, localArrayList1);
  }
  
  static void validateAccountNotifications(Context paramContext, String paramString)
  {
    Object localObject4 = LongShadowUtils.getContentProviderMailAccess(paramContext.getContentResolver());
    Object localObject2 = Persistence.getInstance();
    Object localObject1 = Lists.newArrayList();
    NotificationMap localNotificationMap = getNotificationMap(paramContext);
    Object localObject3 = localNotificationMap.keySet();
    if (!((Persistence)localObject2).getEnableNotifications(paramContext, paramString))
    {
      localObject2 = ((Set)localObject3).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (NotificationKey)((Iterator)localObject2).next();
        if (account.equals(paramString)) {
          ((List)localObject1).add(localObject3);
        }
      }
    }
    localObject4 = ((Gmail)localObject4).getSettings(paramContext, paramString);
    Object localObject5 = Sets.newHashSet();
    ((Set)localObject5).addAll(((Gmail.Settings)localObject4).getLabelsPartial());
    ((Set)localObject5).addAll(((Gmail.Settings)localObject4).getLabelsIncluded());
    localObject3 = ((Set)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (NotificationKey)((Iterator)localObject3).next();
      if (account.equals(paramString))
      {
        localObject5 = Gmail.getCanonicalLabelForTagLabel(label);
        if (!((Persistence)localObject2).shouldNotifyForLabel(paramContext, account, (String)localObject5)) {
          ((List)localObject1).add(localObject4);
        }
      }
    }
    if (((List)localObject1).size() > 0)
    {
      paramString = (NotificationManager)paramContext.getSystemService("notification");
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (NotificationKey)((Iterator)localObject1).next();
        localObject3 = Gmail.getCanonicalLabelForTagLabel(label);
        paramString.cancel(getNotificationId(account, (String)localObject3));
        localNotificationMap.remove(localObject2);
      }
      localNotificationMap.saveNotificationMap(paramContext);
    }
  }
  
  private static void validateNotifications(Context paramContext, Intent paramIntent, String paramString1, boolean paramBoolean1, String paramString2, boolean paramBoolean2, NotificationKey paramNotificationKey)
  {
    NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
    Persistence localPersistence = Persistence.getInstance();
    Object localObject = getNotificationMap(paramContext);
    if (LogUtils.isLoggable("Gmail", 2)) {
      LogUtils.v("Gmail", "Validating Notification: %s mapSize: %d tagLabel: %s getAttention: %b", new Object[] { createNotificationString((NotificationMap)localObject), Integer.valueOf(((NotificationMap)localObject).size()), paramString2, Boolean.valueOf(paramBoolean1) });
    }
    paramString2 = ((NotificationMap)localObject).getUnread(paramNotificationKey);
    if (paramString2 != null)
    {
      i = paramString2.intValue();
      paramString2 = ((NotificationMap)localObject).getUnseen(paramNotificationKey);
      if (paramString2 == null) {
        break label296;
      }
    }
    label296:
    for (int k = paramString2.intValue();; k = 0)
    {
      paramString2 = null;
      localObject = paramIntent.getStringExtra("notificationLabel");
      paramNotificationKey = (NotificationKey)localObject;
      if (localObject == null) {
        paramNotificationKey = Persistence.getAccountInbox(paramContext, paramString1);
      }
      try
      {
        localObject = LongShadowUtils.getContentProviderMailAccess(paramContext.getContentResolver()).getDetachedConversationCursorForQuery(paramString1, "label:" + Gmail.getCanonicalLabelForNotification(paramNotificationKey), Gmail.BecomeActiveNetworkCursor.NO);
        paramString2 = (String)localObject;
        m = ((Gmail.ConversationCursor)localObject).count();
        j = k;
        if (k == 0) {
          break label917;
        }
        j = k;
        if (k == m) {
          break label917;
        }
        paramString2 = (String)localObject;
        LogUtils.d("Gmail", "Unseen count doesn't match cursor count.  unseen: %d cursor count: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
        j = m;
      }
      finally
      {
        Notification.Builder localBuilder;
        String str1;
        String str2;
        boolean bool;
        int n;
        if (paramString2 == null) {
          break label915;
        }
        paramString2.close();
      }
      if (k != 0) {
        break label302;
      }
      paramString2 = (String)localObject;
      localNotificationManager.cancel(getNotificationId(paramString1, paramNotificationKey));
      if (localObject != null) {
        ((Gmail.ConversationCursor)localObject).close();
      }
      return;
      i = 0;
      break;
    }
    label302:
    paramString2 = (String)localObject;
    paramIntent.addFlags(67108864);
    paramString2 = (String)localObject;
    localBuilder = new Notification.Builder(paramContext);
    paramString2 = (String)localObject;
    localBuilder.setSmallIcon(2130837656);
    paramString2 = (String)localObject;
    localBuilder.setTicker(paramString1);
    paramString2 = (String)localObject;
    localBuilder.setWhen(System.currentTimeMillis());
    paramString2 = (String)localObject;
    paramIntent = Persistence.getInstance().getNotificationLabelInformation(paramContext, paramString1, paramNotificationKey);
    paramString2 = (String)localObject;
    str1 = Persistence.extractVibrateSetting(paramContext, paramIntent);
    paramString2 = (String)localObject;
    str2 = Persistence.extract(paramIntent, Persistence.LABEL_NOTIFICATION_RINGTONE);
    paramString2 = (String)localObject;
    bool = Boolean.parseBoolean(Persistence.extract(paramIntent, Persistence.LABEL_NOTIFICATION_ONCE));
    paramString2 = (String)localObject;
    paramIntent = new Intent("com.google.android.gm.intent.CLEAR_NEW_MAIL_NOTIFICATIONS");
    paramString2 = (String)localObject;
    paramIntent.putExtra("account", paramString1);
    paramString2 = (String)localObject;
    paramIntent.putExtra("label", paramNotificationKey);
    paramString2 = (String)localObject;
    localBuilder.setDeleteIntent(PendingIntent.getBroadcast(paramContext, 0, paramIntent, 0));
    paramString2 = (String)localObject;
    localBuilder.setAutoCancel(true);
    if ((!paramBoolean2) && (paramString1 != null) && (bool))
    {
      paramString2 = (String)localObject;
      localBuilder.setOnlyAlertOnce(true);
    }
    int m = 0;
    paramString2 = (String)localObject;
    n = getNotificationId(paramString1, paramNotificationKey);
    int j = m;
    if (i > 0)
    {
      paramString2 = (String)localObject;
      paramIntent = createViewConversationIntent(paramContext, paramString1, paramNotificationKey, null);
      j = m;
      paramString2 = (String)localObject;
      if (((Gmail.ConversationCursor)localObject).next())
      {
        if (k == 1)
        {
          paramString2 = (String)localObject;
          paramIntent = createViewConversationIntent(paramContext, paramString1, paramNotificationKey, (Gmail.ConversationCursor)localObject);
        }
        paramString2 = (String)localObject;
        configureLatestEventInfoFromConversation(paramContext, localBuilder, (Gmail.ConversationCursor)localObject, PendingIntent.getActivity(paramContext, -1, paramIntent.putExtra("label", paramNotificationKey), 0), paramString1, i, k, paramNotificationKey);
        j = 1;
      }
    }
    if (paramString1 != null)
    {
      paramString2 = (String)localObject;
      LogUtils.d("Gmail", "Account: %s vibrateWhen: %s", new Object[] { paramString1, localPersistence.getVibrateWhen(paramContext, paramString1) });
    }
    k = 0;
    m = 0;
    int i = k;
    if (paramBoolean1)
    {
      i = k;
      if (paramString1 != null)
      {
        i = k;
        paramString2 = (String)localObject;
        if (localPersistence.getEnableNotifications(paramContext, paramString1))
        {
          paramString2 = (String)localObject;
          paramIntent = paramContext.getResources();
          paramBoolean1 = false;
          paramBoolean2 = false;
          if (str1 != null)
          {
            paramString2 = (String)localObject;
            paramBoolean1 = str1.equals(paramIntent.getString(2131493268));
            paramString2 = (String)localObject;
            paramBoolean2 = str1.equals(paramIntent.getString(2131493270));
          }
          paramString2 = (String)localObject;
          if (((AudioManager)paramContext.getSystemService("audio")).getRingerMode() != 1) {
            break label885;
          }
          k = 1;
          break label935;
        }
      }
    }
    for (;;)
    {
      paramString2 = (String)localObject;
      if (TextUtils.isEmpty(str2)) {}
      for (paramContext = null;; paramContext = Uri.parse(str2))
      {
        paramString2 = (String)localObject;
        localBuilder.setSound(paramContext);
        paramString2 = (String)localObject;
        LogUtils.d("Gmail", "New email in %s vibrateWhen: %s, playing notification: %s", new Object[] { paramString1, str1, str2 });
        if (j != 0)
        {
          paramString2 = (String)localObject;
          localBuilder.setDefaults(i | 0x4);
          paramString2 = (String)localObject;
          localNotificationManager.notify(n, localBuilder.getNotification());
        }
        if (localObject == null) {
          break;
        }
        ((Gmail.ConversationCursor)localObject).close();
        return;
        label885:
        k = 0;
        break label935;
        paramString2 = (String)localObject;
      }
      label915:
      label917:
      k = j;
      if (j <= i) {
        break;
      }
      k = i;
      break;
      label935:
      if (!paramBoolean1)
      {
        i = m;
        if (paramBoolean2)
        {
          i = m;
          if (k == 0) {}
        }
      }
      else
      {
        i = 0x0 | 0x2;
      }
    }
  }
  
  public static class GmailMessagePlainTextConverter
    extends HtmlTree.DefaultPlainTextConverter
  {
    private static final HTML.Attribute ELIDED_TEXT_ATTRIBUTE = new HTML.Attribute("class", 0);
    private static final HtmlDocument.Node ELIDED_TEXT_REPLACEMENT_NODE = HtmlDocument.createSelfTerminatingTag(HTML4.BR_ELEMENT, null, null, null);
    private int mEndNodeElidedTextBlock = -1;
    
    public void addNode(HtmlDocument.Node paramNode, int paramInt1, int paramInt2)
    {
      if (paramInt1 < mEndNodeElidedTextBlock) {}
      int i;
      do
      {
        return;
        if (paramInt1 == mEndNodeElidedTextBlock)
        {
          super.addNode(ELIDED_TEXT_REPLACEMENT_NODE, paramInt1, paramInt2);
          return;
        }
        if (!(paramNode instanceof HtmlDocument.Tag)) {
          break;
        }
        int j = 0;
        Object localObject = (HtmlDocument.Tag)paramNode;
        i = j;
        if ("div".equals(((HtmlDocument.Tag)localObject).getElement().getName()))
        {
          localObject = ((HtmlDocument.Tag)localObject).getAttributes(ELIDED_TEXT_ATTRIBUTE).iterator();
          do
          {
            i = j;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
          } while (!"elided-text".equals(((HtmlDocument.TagAttribute)((Iterator)localObject).next()).getValue()));
          mEndNodeElidedTextBlock = paramInt2;
          i = 1;
        }
      } while (i != 0);
      super.addNode(paramNode, paramInt1, paramInt2);
    }
  }
  
  private static class NotificationKey
  {
    public final String account;
    public final String label;
    
    public NotificationKey(String paramString1, String paramString2)
    {
      account = paramString1;
      label = paramString2;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof NotificationKey)) {}
      do
      {
        return false;
        paramObject = (NotificationKey)paramObject;
      } while ((!TextUtils.equals(account, account)) || (!TextUtils.equals(label, label)));
      return true;
    }
    
    public int hashCode()
    {
      return account.hashCode() ^ label.hashCode();
    }
    
    public String toString()
    {
      return account + " " + label;
    }
  }
  
  private static class NotificationMap
    extends ConcurrentHashMap<Utils.NotificationKey, Pair<Integer, Integer>>
  {
    public Integer getUnread(Utils.NotificationKey paramNotificationKey)
    {
      paramNotificationKey = (Pair)get(paramNotificationKey);
      if (paramNotificationKey != null) {
        return (Integer)first;
      }
      return null;
    }
    
    public Integer getUnseen(Utils.NotificationKey paramNotificationKey)
    {
      paramNotificationKey = (Pair)get(paramNotificationKey);
      if (paramNotificationKey != null) {
        return (Integer)second;
      }
      return null;
    }
    
    public void loadNotificationMap(Context paramContext)
    {
      try
      {
        paramContext = Persistence.getInstance().getActiveNotificationSet(paramContext);
        if (paramContext != null)
        {
          paramContext = paramContext.iterator();
          while (paramContext.hasNext())
          {
            String[] arrayOfString = TextUtils.split((String)paramContext.next(), " ");
            if (arrayOfString.length == 4) {
              put(new Utils.NotificationKey(arrayOfString[0], arrayOfString[1]), new Pair(Integer.valueOf(arrayOfString[2]), Integer.valueOf(arrayOfString[3])));
            }
          }
        }
      }
      finally {}
    }
    
    public void put(Utils.NotificationKey paramNotificationKey, int paramInt1, int paramInt2)
    {
      put(paramNotificationKey, new Pair(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)));
    }
    
    public void saveNotificationMap(Context paramContext)
    {
      try
      {
        HashSet localHashSet = Sets.newHashSet();
        Iterator localIterator = keySet().iterator();
        while (localIterator.hasNext())
        {
          Utils.NotificationKey localNotificationKey = (Utils.NotificationKey)localIterator.next();
          Pair localPair = (Pair)get(localNotificationKey);
          Integer localInteger1 = (Integer)first;
          Integer localInteger2 = (Integer)second;
          if ((localPair != null) && (localInteger1 != null) && (localInteger2 != null)) {
            localHashSet.add(TextUtils.join(" ", new String[] { account, label, localInteger1.toString(), localInteger2.toString() }));
          }
        }
        Persistence.getInstance().cacheActiveNotificationSet(paramContext, localHashSet);
      }
      finally {}
    }
  }
  
  static class ScheduleSyncTask
    extends AsyncTask<Void, Void, Void>
  {
    private final String mAccount;
    
    public ScheduleSyncTask(String paramString)
    {
      mAccount = paramString;
    }
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      paramVarArgs = new Bundle();
      paramVarArgs.putBoolean("force", true);
      paramVarArgs.putBoolean("do_not_retry", true);
      paramVarArgs.putBoolean("expedited", true);
      ContentResolver.requestSync(new android.accounts.Account(mAccount, "com.google"), "gmail-ls", paramVarArgs);
      return null;
    }
    
    protected void onPostExecute(Void paramVoid)
    {
      Utils.access$102(null);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.Utils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */