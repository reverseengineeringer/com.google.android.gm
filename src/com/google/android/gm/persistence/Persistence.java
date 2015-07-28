package com.google.android.gm.persistence;

import android.content.ContentUris;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.net.Uri;
import android.provider.Settings.System;
import android.text.TextUtils;
import com.google.android.common.base.Strings;
import com.google.android.gm.SharedPreference;
import com.google.android.gm.provider.LogUtils;
import com.google.android.gm.provider.MailEngine;
import com.google.android.gm.provider.MailEngine.Preferences;
import com.google.android.gsf.Gservices;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;

public class Persistence
{
  protected static final String ALLOW_BATCH = "allow-batch";
  private static final Set<String> BACKUP_KEYS;
  static final String CONFIRM_ACTIONS_ICS = "confirm-actions-key";
  static final String CONFIRM_ACTIONS_PRE_ICS = "confirm-actions";
  public static int LABEL_NOTIFICATION_ON = 0;
  public static int LABEL_NOTIFICATION_ONCE = 0;
  public static int LABEL_NOTIFICATION_RINGTONE = 0;
  public static int LABEL_NOTIFICATION_VIBRATE = 0;
  public static int LABEL_SYNCHRONIZATION = 0;
  static final String PRIORITY_INBOX_PRE_ICS_KEY = "priority-inbox";
  private static String SEPERATOR;
  static int UR4_LABEL_NOTIFICATION_ON;
  static int UR4_LABEL_NOTIFICATION_ONCE;
  static int UR4_LABEL_NOTIFICATION_RINGTONE;
  static int UR4_LABEL_NOTIFICATION_VIBRATE;
  private static Persistence mInstance;
  private static String sAlwaysVibrateSetting;
  private static Boolean sCanVibrate;
  private static int sLastGserviceSocialNetworkPatternsHashCode = -1;
  private static SharedPreferences sSharedPrefs;
  private static int sShouldShowForThisSdk = -1;
  private static final List<Pattern> sSocialNetworkSenderPatterns;
  private static Map<String, String> sVibrateSettingConversionMap;
  private static String sVibrateWhenSilentSetting;
  final AutoAdvanceAccountToGlobalMigrator mAutoAdvanceMigrator = new AutoAdvanceAccountToGlobalMigrator();
  final ConfirmActionsAccountToGlobalMigrator mConfirmActionsMigrator = new ConfirmActionsAccountToGlobalMigrator();
  final DefaultReplyAllMigrator mDefaultReplyAllMigrator = new DefaultReplyAllMigrator();
  final MessageTextSizeAccountToGlobalMigrator mMessageTextSizeMigrator = new MessageTextSizeAccountToGlobalMigrator();
  
  static
  {
    LABEL_NOTIFICATION_ON = 1;
    LABEL_NOTIFICATION_RINGTONE = 2;
    LABEL_NOTIFICATION_VIBRATE = 3;
    LABEL_NOTIFICATION_ONCE = 4;
    BACKUP_KEYS = ImmutableSet.of("enable-notifications", "signature", "ringtone", "vibrateWhen", "unobtrusive", "auto-advance-key", new String[] { "swipe-key", "message-text-key", "prefetch-attachments", "conversation-mode", "action-strip-action-reply-all", "snap-headers", "priority-inbox-key", "display_images", "display_sender_images_patterns_set", "notification_labels", "hide-checkboxes", "confirm-delete", "archive", "delete", "send", "confirm-actions-key", "signature-key", "vibrate" });
    mInstance = null;
    sCanVibrate = null;
    SEPERATOR = " ";
    UR4_LABEL_NOTIFICATION_ON = 0;
    UR4_LABEL_NOTIFICATION_RINGTONE = 1;
    UR4_LABEL_NOTIFICATION_VIBRATE = 2;
    UR4_LABEL_NOTIFICATION_ONCE = 3;
    sSocialNetworkSenderPatterns = Lists.newArrayList();
    sSocialNetworkSenderPatterns.add(Pattern.compile("noreply\\-\\w+@plus\\.google\\.com"));
    sSocialNetworkSenderPatterns.add(Pattern.compile("[0-9a-fA-F]+@plus\\.google\\.com"));
  }
  
  private void cacheUseInfoOverloadArrowsSetting(Context paramContext, String paramString, boolean paramBoolean)
  {
    setBoolean(paramContext, paramString, "cache-use-priority-markers", Boolean.valueOf(paramBoolean));
  }
  
  private boolean canBackupRestore(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    int i = paramString.indexOf('^');
    String str = paramString;
    if (i >= 0) {
      str = paramString.substring(0, i);
    }
    return BACKUP_KEYS.contains(str);
  }
  
  private boolean containsKey(Context paramContext, String paramString1, String paramString2)
  {
    return getPreferences(paramContext).contains(makeKey(paramString1, paramString2));
  }
  
  private Set<String> convertUR4NotificationLabelInformation(Set<String> paramSet)
  {
    HashSet localHashSet = Sets.newHashSet();
    localHashSet.add(LABEL_NOTIFICATION_ON + extract(paramSet, UR4_LABEL_NOTIFICATION_ON));
    localHashSet.add(LABEL_NOTIFICATION_RINGTONE + extract(paramSet, UR4_LABEL_NOTIFICATION_RINGTONE));
    localHashSet.add(LABEL_NOTIFICATION_VIBRATE + extract(paramSet, UR4_LABEL_NOTIFICATION_VIBRATE));
    localHashSet.add(LABEL_NOTIFICATION_ONCE + extract(paramSet, UR4_LABEL_NOTIFICATION_ONCE));
    return localHashSet;
  }
  
  public static String extract(Set<String> paramSet, int paramInt)
  {
    String str1 = Integer.toString(paramInt);
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      String str2 = (String)paramSet.next();
      if (str2.startsWith(str1)) {
        return str2.substring(1);
      }
    }
    return null;
  }
  
  private static Set<String> extractSet(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramString1 == null) || (paramString1.equals(""))) {
      paramString1 = null;
    }
    String[] arrayOfString;
    int j;
    int i;
    do
    {
      return paramString1;
      arrayOfString = TextUtils.split(paramString1, paramString2);
      paramString2 = new HashSet();
      j = arrayOfString.length;
      i = 0;
      paramString1 = paramString2;
    } while (i >= j);
    paramString1 = arrayOfString[i];
    if (paramBoolean) {
      paramString1 = Uri.decode(paramString1);
    }
    for (;;)
    {
      paramString2.add(paramString1);
      i += 1;
      break;
    }
  }
  
  public static String extractVibrateSetting(Context paramContext, Set<String> paramSet)
  {
    getInstance().initializeVibrationState(paramContext);
    paramSet = extract(paramSet, LABEL_NOTIFICATION_VIBRATE);
    if (paramSet != null) {}
    for (paramContext = (String)sVibrateSettingConversionMap.get(paramSet); paramContext != null; paramContext = null) {
      return paramContext;
    }
    return paramSet;
  }
  
  public static String getAccountInbox(Context paramContext, String paramString)
  {
    if (getInstance().getPriorityInboxDefault(paramContext, paramString)) {
      return "^iim";
    }
    return "^i";
  }
  
  private boolean getBoolean(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    return getPreferences(paramContext).getBoolean(makeKey(paramString1, paramString2), paramBoolean);
  }
  
  private boolean getCachedInfoOverloadArrowsSetting(Context paramContext, String paramString)
  {
    return getBoolean(paramContext, paramString, "cache-use-priority-markers", false);
  }
  
  private Boolean getInfoOverloadArrowsEnabled(String paramString)
  {
    paramString = MailEngine.getMailEngine(paramString);
    if (paramString == null) {
      return null;
    }
    return Boolean.valueOf(paramString.getServerArrowsEnabled());
  }
  
  public static Persistence getInstance()
  {
    if (mInstance == null) {
      mInstance = new Persistence();
    }
    return mInstance;
  }
  
  public static MailEnginePreferences getMailEnginePreferences(Context paramContext)
  {
    return new MailEnginePreferences(paramContext);
  }
  
  public static SharedPreferences getPreferences(Context paramContext)
  {
    if (sSharedPrefs == null) {
      sSharedPrefs = paramContext.getSharedPreferences("Gmail", 0);
    }
    return sSharedPrefs;
  }
  
  private static String getRingtoneTitle(Context paramContext, String paramString)
  {
    if (paramString.length() == 0) {}
    while (RingtoneManager.isDefault(Uri.parse(paramString))) {
      return paramString;
    }
    paramContext = new RingtoneManager(paramContext);
    paramContext.setType(2);
    paramContext = paramContext.getCursor();
    try
    {
      while (paramContext.moveToNext()) {
        if (ContentUris.withAppendedId(Uri.parse(paramContext.getString(2)), paramContext.getLong(0)).toString().equals(paramString))
        {
          String str = paramContext.getString(1);
          boolean bool = Strings.isNullOrEmpty(str);
          if (!bool) {
            return str;
          }
        }
      }
      return null;
    }
    finally
    {
      paramContext.close();
    }
  }
  
  private static String getRingtoneUri(Context paramContext, String paramString)
  {
    if ((paramString.length() == 0) || (RingtoneManager.isDefault(Uri.parse(paramString)))) {
      return paramString;
    }
    paramContext = new RingtoneManager(paramContext);
    paramContext.setType(2);
    paramContext = paramContext.getCursor();
    try
    {
      while (paramContext.moveToNext()) {
        if (paramString.equals(paramContext.getString(1)))
        {
          paramString = ContentUris.withAppendedId(Uri.parse(paramContext.getString(2)), paramContext.getLong(0)).toString();
          return paramString;
        }
      }
      return null;
    }
    finally
    {
      paramContext.close();
    }
  }
  
  private Set<String> getSenderWhitelist(Context paramContext)
  {
    localHashSet = new HashSet();
    Object localObject = getString(paramContext, null, "display_images", "");
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      try
      {
        localObject = new JSONArray((String)localObject);
        int i = 0;
        int j = ((JSONArray)localObject).length();
        while (i < j)
        {
          localHashSet.add((String)((JSONArray)localObject).get(i));
          i += 1;
        }
        return localHashSet;
      }
      catch (JSONException localJSONException)
      {
        setString(paramContext, null, "display_images", "");
      }
    }
  }
  
  private String getStoredAutoAdvanceMode(Context paramContext)
  {
    Object localObject2 = getString(paramContext, null, "auto-advance-key", null);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (String)mAutoAdvanceMigrator.migrate(paramContext);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = getString(paramContext, null, "auto-advance", null);
    }
    return (String)localObject2;
  }
  
  private String getString(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 != null) {
      return getPreferences(paramContext).getString(makeKey(paramString1, paramString2), paramString3);
    }
    return getPreferences(paramContext).getString(paramString2, paramString3);
  }
  
  private String getString(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return getString(paramContext, getActiveAccount(paramContext), paramString1, paramString2);
    }
    return getPreferences(paramContext).getString(paramString1, paramString2);
  }
  
  private boolean getUnobtrusive(Context paramContext, String paramString)
  {
    return getBoolean(paramContext, paramString, "unobtrusive", true);
  }
  
  /* Error */
  private void initializeVibrationState(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 148	com/google/android/gm/persistence/Persistence:sCanVibrate	Ljava/lang/Boolean;
    //   5: ifnull +9 -> 14
    //   8: getstatic 350	com/google/android/gm/persistence/Persistence:sVibrateSettingConversionMap	Ljava/util/Map;
    //   11: ifnonnull +174 -> 185
    //   14: aload_1
    //   15: ldc_w 483
    //   18: invokevirtual 487	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   21: checkcast 489	android/os/Vibrator
    //   24: astore_3
    //   25: aload_3
    //   26: ifnull +162 -> 188
    //   29: aload_3
    //   30: invokevirtual 492	android/os/Vibrator:hasVibrator	()Z
    //   33: ifeq +155 -> 188
    //   36: iconst_1
    //   37: istore_2
    //   38: iload_2
    //   39: invokestatic 228	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   42: putstatic 148	com/google/android/gm/persistence/Persistence:sCanVibrate	Ljava/lang/Boolean;
    //   45: aload_1
    //   46: invokevirtual 496	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   49: astore_1
    //   50: iload_2
    //   51: ifeq +23 -> 74
    //   54: aload_1
    //   55: ldc_w 497
    //   58: invokevirtual 500	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   61: putstatic 502	com/google/android/gm/persistence/Persistence:sAlwaysVibrateSetting	Ljava/lang/String;
    //   64: aload_1
    //   65: ldc_w 503
    //   68: invokevirtual 500	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   71: putstatic 505	com/google/android/gm/persistence/Persistence:sVibrateWhenSilentSetting	Ljava/lang/String;
    //   74: aload_1
    //   75: ldc_w 497
    //   78: invokevirtual 500	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   81: astore_3
    //   82: aload_1
    //   83: ldc_w 506
    //   86: invokevirtual 500	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   89: astore 4
    //   91: aload_1
    //   92: ldc_w 503
    //   95: invokevirtual 500	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   98: astore 5
    //   100: invokestatic 512	com/google/common/collect/ImmutableMap:builder	()Lcom/google/common/collect/ImmutableMap$Builder;
    //   103: astore 6
    //   105: aload 6
    //   107: aload_3
    //   108: aload_3
    //   109: invokevirtual 518	com/google/common/collect/ImmutableMap$Builder:put	(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;
    //   112: pop
    //   113: aload 6
    //   115: aload 4
    //   117: aload 4
    //   119: invokevirtual 518	com/google/common/collect/ImmutableMap$Builder:put	(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;
    //   122: pop
    //   123: aload 6
    //   125: aload 5
    //   127: aload 5
    //   129: invokevirtual 518	com/google/common/collect/ImmutableMap$Builder:put	(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;
    //   132: pop
    //   133: aload 6
    //   135: aload_1
    //   136: ldc_w 519
    //   139: invokevirtual 500	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   142: aload_3
    //   143: invokevirtual 518	com/google/common/collect/ImmutableMap$Builder:put	(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;
    //   146: pop
    //   147: aload 6
    //   149: aload_1
    //   150: ldc_w 520
    //   153: invokevirtual 500	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   156: aload 4
    //   158: invokevirtual 518	com/google/common/collect/ImmutableMap$Builder:put	(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;
    //   161: pop
    //   162: aload 6
    //   164: aload_1
    //   165: ldc_w 521
    //   168: invokevirtual 500	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   171: aload 5
    //   173: invokevirtual 518	com/google/common/collect/ImmutableMap$Builder:put	(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;
    //   176: pop
    //   177: aload 6
    //   179: invokevirtual 525	com/google/common/collect/ImmutableMap$Builder:build	()Lcom/google/common/collect/ImmutableMap;
    //   182: putstatic 350	com/google/android/gm/persistence/Persistence:sVibrateSettingConversionMap	Ljava/util/Map;
    //   185: aload_0
    //   186: monitorexit
    //   187: return
    //   188: iconst_0
    //   189: istore_2
    //   190: goto -152 -> 38
    //   193: astore_1
    //   194: aload_0
    //   195: monitorexit
    //   196: aload_1
    //   197: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	Persistence
    //   0	198	1	paramContext	Context
    //   37	153	2	bool	boolean
    //   24	119	3	localObject	Object
    //   89	68	4	str1	String
    //   98	74	5	str2	String
    //   103	75	6	localBuilder	com.google.common.collect.ImmutableMap.Builder
    // Exception table:
    //   from	to	target	type
    //   2	14	193	finally
    //   14	25	193	finally
    //   29	36	193	finally
    //   38	50	193	finally
    //   54	74	193	finally
    //   74	185	193	finally
  }
  
  public static final boolean isNotification(int paramInt)
  {
    return paramInt >= LABEL_NOTIFICATION_ON;
  }
  
  public static final boolean isNotificationSubChoice(int paramInt)
  {
    return paramInt > LABEL_NOTIFICATION_ON;
  }
  
  private boolean isPresent(Context paramContext, String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramString1 != null) {
      str = makeKey(paramString1, paramString2);
    }
    return getPreferences(paramContext).contains(str);
  }
  
  public static boolean isRingtone(String paramString)
  {
    return "ringtone".equals(paramString);
  }
  
  private void loadSocialNetworkPatterns(Context paramContext)
  {
    paramContext = Gservices.getString(paramContext.getContentResolver(), "gmail_social_network_sender_patterns", null);
    if (paramContext != null)
    {
      int i = paramContext.hashCode();
      if (i != sLastGserviceSocialNetworkPatternsHashCode)
      {
        sLastGserviceSocialNetworkPatternsHashCode = i;
        paramContext = TextUtils.split(paramContext, ";");
        sSocialNetworkSenderPatterns.clear();
        int j = paramContext.length;
        i = 0;
        while (i < j)
        {
          String str = paramContext[i];
          sSocialNetworkSenderPatterns.add(Pattern.compile(str));
          i += 1;
        }
      }
    }
  }
  
  private String makeKey(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramString1 != null) {
      str = paramString1 + "-" + paramString2;
    }
    return str;
  }
  
  private String migrateVibrateValue(Context paramContext, String paramString)
  {
    if (getBoolean(paramContext, paramString, "vibrate", false)) {
      return paramContext.getResources().getString(2131493268);
    }
    return paramContext.getResources().getString(2131493269);
  }
  
  private void notifyBackupDataChanged(String paramString)
  {
    if (canBackupRestore(paramString)) {
      GmailBackupAgent.dataChanged("Shared preferences");
    }
  }
  
  private void remove(Context paramContext, String paramString)
  {
    paramContext = getPreferences(paramContext).edit();
    paramContext.remove(paramString);
    paramContext.apply();
    notifyBackupDataChanged(paramString);
  }
  
  private void setHideCheckboxes(Context paramContext, boolean paramBoolean)
  {
    setBoolean(paramContext, null, "hide-checkboxes", Boolean.valueOf(paramBoolean));
  }
  
  public void addNotificationLabel(Context paramContext, String paramString1, String paramString2, Set<String> paramSet)
  {
    setStringSet(paramContext, paramString1, "notification_labels" + paramString2, paramSet);
  }
  
  public void cacheActiveNotificationSet(Context paramContext, Set<String> paramSet)
  {
    setStringSet(paramContext, "cache-active-notification-set", null, paramSet);
  }
  
  public void cacheConfiguredGoogleAccounts(Context paramContext, boolean paramBoolean, Iterable<String> paramIterable)
  {
    if (paramBoolean) {}
    for (String str = "cache-google-accounts";; str = "cache-google-accounts-synced")
    {
      setString(paramContext, null, str, TextUtils.join(" ", paramIterable));
      return;
    }
  }
  
  public void clearNotificationLabel(Context paramContext, String paramString1, String paramString2)
  {
    remove(paramContext, paramString1, "notification_labels" + paramString2);
  }
  
  public boolean fullTextSearchEnabled(Context paramContext)
  {
    return true;
  }
  
  public boolean getActionStripActionReplyAll(Context paramContext)
  {
    if (isPresent(paramContext, null, "action-strip-action-reply-all")) {
      return getBoolean(paramContext, null, "action-strip-action-reply-all", false);
    }
    Boolean localBoolean2 = (Boolean)mDefaultReplyAllMigrator.migrate(paramContext);
    Boolean localBoolean1 = localBoolean2;
    if (localBoolean2 == null) {
      localBoolean1 = Boolean.valueOf(paramContext.getResources().getBoolean(2131689477));
    }
    return localBoolean1.booleanValue();
  }
  
  public String getActiveAccount(Context paramContext)
  {
    return getString(paramContext, null, "active-account", null);
  }
  
  public Set<String> getActiveNotificationSet(Context paramContext)
  {
    try
    {
      paramContext = getStringSet(paramContext, "cache-active-notification-set", null, null);
      return paramContext;
    }
    catch (ClassCastException paramContext) {}
    return null;
  }
  
  public String getAutoAdvanceMode(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    String str = getStoredAutoAdvanceMode(paramContext);
    paramContext = str;
    if (str == null) {
      paramContext = localResources.getString(2131493256);
    }
    return paramContext;
  }
  
  public boolean getAutoAdvanceModeList(Context paramContext)
  {
    return "list".equals(getAutoAdvanceMode(paramContext));
  }
  
  public boolean getAutoAdvanceModeNewer(Context paramContext)
  {
    return "newer".equals(getAutoAdvanceMode(paramContext));
  }
  
  public boolean getAutoAdvanceModeOlder(Context paramContext)
  {
    return "older".equals(getAutoAdvanceMode(paramContext));
  }
  
  public List<SharedPreference> getBackupPreferences(Context paramContext)
  {
    ArrayList localArrayList = Lists.newArrayList();
    SharedPreferences localSharedPreferences = getPreferences(paramContext);
    Iterator localIterator1 = localSharedPreferences.getAll().entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject4 = (Map.Entry)localIterator1.next();
      Object localObject3 = (String)((Map.Entry)localObject4).getKey();
      String str1;
      Object localObject2;
      label108:
      Object localObject1;
      if (((String)localObject3).indexOf('@') >= 0)
      {
        int i = ((String)localObject3).indexOf('-', ((String)localObject3).lastIndexOf(46));
        str1 = ((String)localObject3).substring(0, i);
        localObject2 = ((String)localObject3).substring(i + 1);
        if (!canBackupRestore((String)localObject2)) {
          break label183;
        }
        localObject1 = ((Map.Entry)localObject4).getValue();
        if (!"ringtone".equals(localObject2)) {
          break label185;
        }
        localObject1 = getRingtoneTitle(paramContext, (String)((Map.Entry)localObject4).getValue());
        if (localObject1 == null) {
          continue;
        }
      }
      for (;;)
      {
        localArrayList.add(new SharedPreference((String)localObject2, str1, localObject1));
        break;
        str1 = null;
        localObject2 = localObject3;
        break label108;
        label183:
        break;
        label185:
        if (((String)localObject2).startsWith("notification_labels"))
        {
          localObject1 = localSharedPreferences.getStringSet((String)localObject3, null);
          if (localObject1 == null) {
            break;
          }
          localObject3 = Sets.newHashSet();
          String str2 = Integer.toString(LABEL_NOTIFICATION_RINGTONE);
          Iterator localIterator2 = ((Set)localObject1).iterator();
          while (localIterator2.hasNext())
          {
            localObject1 = (String)localIterator2.next();
            if (((String)localObject1).startsWith(str2))
            {
              localObject4 = getRingtoneTitle(paramContext, ((String)localObject1).substring(1));
              localObject1 = localObject4;
              if (localObject4 == null) {
                localObject1 = RingtoneManager.getDefaultUri(2).toString();
              }
              ((Set)localObject3).add(LABEL_NOTIFICATION_RINGTONE + (String)localObject1);
            }
            else
            {
              ((Set)localObject3).add(localObject1);
            }
          }
          localObject1 = localObject3;
        }
      }
    }
    return localArrayList;
  }
  
  public List<String> getCachedConfiguredGoogleAccounts(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "cache-google-accounts";; str = "cache-google-accounts-synced") {
      return ImmutableList.copyOf(TextUtils.split(getString(paramContext, null, str, ""), " "));
    }
  }
  
  public Set<String> getConfirmActions(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    Object localObject2 = getString(paramContext, null, "confirm-actions-key", null);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (String)mConfirmActionsMigrator.migrate(paramContext);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = getString(paramContext, null, "confirm-actions", null);
    }
    paramContext = (Context)localObject2;
    if (localObject2 == null) {
      paramContext = localResources.getString(2131493255);
    }
    return Sets.newHashSet(TextUtils.split(paramContext, ","));
  }
  
  public boolean getConfirmArchive(Context paramContext)
  {
    return getConfirmActions(paramContext).contains("archive");
  }
  
  public boolean getConfirmDelete(Context paramContext)
  {
    return getConfirmActions(paramContext).contains("delete");
  }
  
  public boolean getConfirmSend(Context paramContext)
  {
    return getConfirmActions(paramContext).contains("send");
  }
  
  public boolean getConversationOverviewMode(Context paramContext)
  {
    return getBoolean(paramContext, null, "conversation-mode", false);
  }
  
  public boolean getDisplayImagesFromSender(Context paramContext, String paramString)
  {
    boolean bool2 = getSenderWhitelist(paramContext).contains(paramString);
    boolean bool1 = bool2;
    if (!bool2) {
      localSet1 = Collections.emptySet();
    }
    try
    {
      Set localSet2 = getStringSet(paramContext, null, "display_sender_images_patterns_set", localSet1);
      paramContext = localSet2;
    }
    catch (ClassCastException localClassCastException)
    {
      for (;;)
      {
        LogUtils.e("Gmail", localClassCastException, "Error retrieving previously saved senders pattern", new Object[0]);
        remove(paramContext, null, "display_sender_images_patterns_set");
        paramContext = localSet1;
      }
    }
    paramContext = paramContext.iterator();
    bool1 = bool2;
    while (paramContext.hasNext())
    {
      bool2 = Pattern.compile((String)paramContext.next()).matcher(paramString).matches();
      bool1 = bool2;
      if (bool2) {
        bool1 = bool2;
      }
    }
    return bool1;
  }
  
  public boolean getEnableNotifications(Context paramContext, String paramString)
  {
    return getBoolean(paramContext, paramString, "enable-notifications", true);
  }
  
  public boolean getHasUserSetAutoAdvanceSetting(Context paramContext)
  {
    return getStoredAutoAdvanceMode(paramContext) != null;
  }
  
  public boolean getHideCheckboxes(Context paramContext)
  {
    boolean bool = true;
    if (!getPreferences(paramContext).contains("hide-checkboxes"))
    {
      if (!getPreferences(paramContext).contains("allow-batch")) {
        break label66;
      }
      if (getPreferences(paramContext).getBoolean("allow-batch", true)) {
        break label61;
      }
      setHideCheckboxes(paramContext, bool);
    }
    for (;;)
    {
      return getBoolean(paramContext, null, "hide-checkboxes", false);
      label61:
      bool = false;
      break;
      label66:
      setHideCheckboxes(paramContext, false);
    }
  }
  
  public String getMessageTextSize(Context paramContext)
  {
    Object localObject2 = getString(paramContext, null, "message-text-key", null);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (String)mMessageTextSizeMigrator.migrate(paramContext);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = getString(paramContext, null, "message-text", null);
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramContext.getResources().getString(2131493261);
    }
    return (String)localObject1;
  }
  
  public Set<String> getNotificationLabelInformation(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject2 = null;
    boolean bool = getPriorityInboxDefault(paramContext, paramString1);
    Object localObject1;
    if ((bool) || (!paramString2.equals("^i")))
    {
      localObject1 = localObject2;
      if (bool)
      {
        localObject1 = localObject2;
        if (!paramString2.equals("^iim")) {}
      }
    }
    else
    {
      localObject1 = Sets.newHashSet();
      ((Set)localObject1).add(LABEL_NOTIFICATION_ON + Boolean.toString(true));
      ((Set)localObject1).add(LABEL_NOTIFICATION_RINGTONE + getRingtone(paramContext, paramString1));
      ((Set)localObject1).add(LABEL_NOTIFICATION_VIBRATE + getVibrateWhen(paramContext, paramString1));
      ((Set)localObject1).add(LABEL_NOTIFICATION_ONCE + Boolean.toString(getUnobtrusive(paramContext, paramString1)));
    }
    return getNotificationLabelInformation(paramContext, paramString1, paramString2, (Set)localObject1);
  }
  
  public Set<String> getNotificationLabelInformation(Context paramContext, String paramString1, String paramString2, Set<String> paramSet)
  {
    String str = "notification_labels" + paramString2;
    try
    {
      paramString2 = getStringSet(paramContext, paramString1, str, paramSet);
      paramSet = paramString2;
    }
    catch (ClassCastException paramString2)
    {
      do
      {
        paramContext = extractSet(getString(paramContext, paramString1, str, null), SEPERATOR, false);
      } while (paramContext == null);
    }
    return paramSet;
    return convertUR4NotificationLabelInformation(paramContext);
  }
  
  public Uri getNotificationRingtoneUriForLabel(Context paramContext, String paramString1, String paramString2)
  {
    paramString2 = getNotificationLabelInformation(paramContext, paramString1, paramString2);
    paramString1 = null;
    paramContext = paramString1;
    if (paramString2 != null)
    {
      paramString2 = extract(paramString2, LABEL_NOTIFICATION_RINGTONE);
      paramContext = paramString1;
      if (!TextUtils.isEmpty(paramString2)) {
        paramContext = Uri.parse(paramString2);
      }
    }
    return paramContext;
  }
  
  public boolean getPrefetchAttachments(Context paramContext, String paramString)
  {
    return getBoolean(paramContext, paramString, "prefetch-attachments", true);
  }
  
  public boolean getPriorityInboxArrowsEnabled(Context paramContext, String paramString)
  {
    Boolean localBoolean = getInfoOverloadArrowsEnabled(paramString);
    boolean bool2 = getCachedInfoOverloadArrowsSetting(paramContext, paramString);
    if (localBoolean != null) {}
    for (boolean bool1 = localBoolean.booleanValue();; bool1 = bool2)
    {
      if (bool2 != bool1) {
        cacheUseInfoOverloadArrowsSetting(paramContext, paramString, bool1);
      }
      return bool1;
    }
  }
  
  public boolean getPriorityInboxDefault(Context paramContext, String paramString)
  {
    if (containsKey(paramContext, paramString, "priority-inbox-key")) {}
    for (String str = "priority-inbox-key";; str = "priority-inbox") {
      return getBoolean(paramContext, paramString, str, false);
    }
  }
  
  public String getRingtone(Context paramContext, String paramString)
  {
    String str = getString(paramContext, paramString, "ringtone", null);
    paramString = str;
    if (str == null) {
      paramString = getString(paramContext, null, "ringtone", null);
    }
    paramContext = paramString;
    if (paramString == null) {
      paramContext = Settings.System.DEFAULT_NOTIFICATION_URI.toString();
    }
    return paramContext;
  }
  
  public String getSignature(Context paramContext, String paramString)
  {
    String str = getString(paramContext, paramString, "signature", null);
    paramString = str;
    if (str == null) {
      paramString = getString(paramContext, null, "signature-key", null);
    }
    paramContext = paramString;
    if (paramString == null) {
      paramContext = "";
    }
    return paramContext;
  }
  
  public String getSnapHeaderMode(Context paramContext)
  {
    return getString(paramContext, null, "snap-headers", paramContext.getResources().getString(2131493132));
  }
  
  public Set<String> getStringSet(Context paramContext, String paramString1, String paramString2, Set<String> paramSet)
  {
    return getPreferences(paramContext).getStringSet(makeKey(paramString1, paramString2), paramSet);
  }
  
  public String getSwipe(Context paramContext)
  {
    return getString(paramContext, "swipe-key", "archive", false);
  }
  
  public int getSwipeIntegerPreference(Context paramContext)
  {
    paramContext = getString(paramContext, null, "swipe-key", null);
    if ("archive".equals(paramContext)) {}
    do
    {
      return 0;
      if ("delete".equals(paramContext)) {
        return 1;
      }
    } while (!"disabled".equals(paramContext));
    return 2;
  }
  
  public String getVibrateWhen(Context paramContext, String paramString)
  {
    return getString(paramContext, paramString, "vibrateWhen", migrateVibrateValue(paramContext, paramString));
  }
  
  public void remove(Context paramContext, String paramString1, String paramString2)
  {
    remove(paramContext, makeKey(paramString1, paramString2));
  }
  
  public void removeNotificationLabel(Context paramContext, String paramString1, String paramString2)
  {
    Set localSet = getNotificationLabelInformation(paramContext, paramString1, paramString2);
    if ((localSet != null) && (localSet.contains(LABEL_NOTIFICATION_ON + Boolean.toString(true))))
    {
      localSet.remove(LABEL_NOTIFICATION_ON + Boolean.toString(true));
      localSet.add(LABEL_NOTIFICATION_ON + Boolean.toString(false));
      addNotificationLabel(paramContext, paramString1, paramString2, localSet);
    }
  }
  
  public void restoreSharedPreferences(Context paramContext, List<SharedPreference> paramList, String paramString)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (SharedPreference)localIterator.next();
      paramList = ((SharedPreference)localObject).getValue();
      String str2 = ((SharedPreference)localObject).getKey();
      if (canBackupRestore(str2))
      {
        String str3 = ((SharedPreference)localObject).getAccount();
        if ((paramList instanceof Boolean))
        {
          setBoolean(paramContext, str3, str2, (Boolean)paramList);
          LogUtils.v("Gmail", "Restore: %s", new Object[] { localObject });
        }
        else
        {
          String str1;
          if ((paramList instanceof String))
          {
            str1 = (String)paramList;
            paramList = str1;
            if (isRingtone(str2))
            {
              str1 = getRingtoneUri(paramContext, str1);
              paramList = str1;
              if (str1 == null)
              {
                LogUtils.w("Gmail", "Can't restore ringtone (not found)", new Object[0]);
                continue;
              }
            }
            setString(paramContext, str3, str2, paramList);
            LogUtils.v(paramString, "Restore: %s", new Object[] { localObject });
          }
          else if ((paramList instanceof Set))
          {
            localObject = (Set)paramList;
            if (str2.startsWith("notification_labels"))
            {
              String str4 = extract((Set)localObject, LABEL_NOTIFICATION_RINGTONE);
              str1 = getRingtoneUri(paramContext, str4);
              paramList = str1;
              if (str1 == null) {
                paramList = RingtoneManager.getDefaultUri(2).toString();
              }
              ((Set)localObject).remove(LABEL_NOTIFICATION_RINGTONE + str4);
              ((Set)localObject).add(LABEL_NOTIFICATION_RINGTONE + paramList);
            }
            setStringSet(paramContext, str3, str2, (Set)localObject);
          }
          else
          {
            LogUtils.e(paramString, "Unknown preference data type: %s", new Object[] { paramList.getClass() });
          }
        }
      }
    }
    getPreferences(paramContext).edit().commit();
  }
  
  public void setActionStripActionReplyAll(Context paramContext, boolean paramBoolean)
  {
    setBoolean(paramContext, null, "action-strip-action-reply-all", Boolean.valueOf(paramBoolean));
  }
  
  public void setActiveAccount(Context paramContext, String paramString)
  {
    setString(paramContext, null, "active-account", paramString);
  }
  
  public void setAutoAdvanceMode(Context paramContext, String paramString)
  {
    setString(paramContext, null, "auto-advance-key", paramString);
  }
  
  public void setBoolean(Context paramContext, String paramString1, String paramString2, Boolean paramBoolean)
  {
    paramContext = getPreferences(paramContext).edit();
    paramContext.putBoolean(makeKey(paramString1, paramString2), paramBoolean.booleanValue());
    paramContext.apply();
    notifyBackupDataChanged(paramString2);
  }
  
  public void setConfirmActions(Context paramContext, Set<String> paramSet)
  {
    setString(paramContext, null, "confirm-actions-key", TextUtils.join(",", paramSet));
  }
  
  public void setConversationOverviewMode(Context paramContext, boolean paramBoolean)
  {
    setBoolean(paramContext, null, "conversation-mode", Boolean.valueOf(paramBoolean));
  }
  
  public void setDisplayImagesFromSender(Context paramContext, String paramString)
  {
    loadSocialNetworkPatterns(paramContext);
    Iterator localIterator = sSocialNetworkSenderPatterns.iterator();
    Object localObject;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject = (Pattern)localIterator.next();
        if (((Pattern)localObject).matcher(paramString).matches())
        {
          paramString = getStringSet(paramContext, null, "display_sender_images_patterns_set", new HashSet());
          localObject = ((Pattern)localObject).pattern();
          if (!paramString.contains(localObject))
          {
            paramString.add(localObject);
            setStringSet(paramContext, null, "display_sender_images_patterns_set", paramString);
          }
        }
      }
    }
    do
    {
      return;
      localObject = getSenderWhitelist(paramContext);
    } while (((Set)localObject).contains(paramString));
    ((Set)localObject).add(paramString);
    setString(paramContext, null, "display_images", new JSONArray((Collection)localObject).toString());
  }
  
  public void setEnableNotifications(Context paramContext, String paramString, boolean paramBoolean)
  {
    setBoolean(paramContext, paramString, "enable-notifications", Boolean.valueOf(paramBoolean));
  }
  
  public void setMessageTextSize(Context paramContext, String paramString)
  {
    setString(paramContext, null, "message-text-key", paramString);
  }
  
  public void setPrefetchAttachments(Context paramContext, String paramString, boolean paramBoolean)
  {
    setBoolean(paramContext, paramString, "prefetch-attachments", Boolean.valueOf(paramBoolean));
  }
  
  public void setPriorityInboxDefault(Context paramContext, String paramString, boolean paramBoolean)
  {
    setBoolean(paramContext, paramString, "priority-inbox-key", Boolean.valueOf(paramBoolean));
  }
  
  public void setSignature(Context paramContext, String paramString1, String paramString2)
  {
    setString(paramContext, paramString1, "signature", paramString2);
  }
  
  public void setSnapHeaderMode(Context paramContext, String paramString)
  {
    setString(paramContext, null, "snap-headers", paramString);
  }
  
  public void setString(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = getPreferences(paramContext).edit();
    paramContext.putString(makeKey(paramString1, paramString2), paramString3);
    paramContext.apply();
    notifyBackupDataChanged(paramString2);
  }
  
  public void setStringSet(Context paramContext, String paramString1, String paramString2, Set<String> paramSet)
  {
    paramContext = getPreferences(paramContext).edit();
    paramContext.putStringSet(makeKey(paramString1, paramString2), paramSet);
    paramContext.apply();
    notifyBackupDataChanged(paramString2);
  }
  
  public void setSwipe(Context paramContext, String paramString)
  {
    setString(paramContext, null, "swipe-key", paramString);
  }
  
  public void setUpgradeSyncWindow(Context paramContext, boolean paramBoolean)
  {
    if ((paramBoolean) && (isPresent(paramContext, null, "show-sync-window-upgrade"))) {
      return;
    }
    setBoolean(paramContext, null, "show-sync-window-upgrade", Boolean.valueOf(paramBoolean));
  }
  
  public boolean shouldNotifyForLabel(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = getNotificationLabelInformation(paramContext, paramString1, paramString2);
    return (paramContext != null) && (Boolean.parseBoolean(extract(paramContext, LABEL_NOTIFICATION_ON)));
  }
  
  public boolean shouldNotifyOnceForLabel(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = getNotificationLabelInformation(paramContext, paramString1, paramString2);
    return (paramContext != null) && (Boolean.parseBoolean(extract(paramContext, LABEL_NOTIFICATION_ONCE)));
  }
  
  public boolean shouldVibrateForLabel(Context paramContext, String paramString1, String paramString2)
  {
    initializeVibrationState(paramContext);
    paramString1 = getNotificationLabelInformation(paramContext, paramString1, paramString2);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (sCanVibrate.booleanValue())
    {
      paramContext = extractVibrateSetting(paramContext, paramString1);
      if (!sAlwaysVibrateSetting.equals(paramContext))
      {
        bool1 = bool2;
        if (!sVibrateWhenSilentSetting.equals(paramContext)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private abstract class AccountToGlobalPreferenceMigrator<T>
  {
    private AccountToGlobalPreferenceMigrator() {}
    
    public T migrate(Context paramContext)
    {
      Object localObject = getCachedConfiguredGoogleAccounts(paramContext, false);
      if (localObject != null)
      {
        if (((List)localObject).size() == 1) {
          return (T)migrateFromSingleAccount(paramContext, (String)((List)localObject).get(0));
        }
        if (((List)localObject).size() > 1) {
          return (T)migrateFromMultipleAccounts(paramContext, (List)localObject);
        }
      }
      localObject = getActiveAccount(paramContext);
      if (localObject != null) {
        return (T)migrateFromSingleAccount(paramContext, (String)localObject);
      }
      return null;
    }
    
    abstract T migrateFromMultipleAccounts(Context paramContext, List<String> paramList);
    
    abstract T migrateFromSingleAccount(Context paramContext, String paramString);
  }
  
  class AutoAdvanceAccountToGlobalMigrator
    extends Persistence.AccountToGlobalPreferenceMigrator<String>
  {
    AutoAdvanceAccountToGlobalMigrator()
    {
      super(null);
    }
    
    private int autoAdvanceSettingPriority(String paramString)
    {
      if ("newer".equals(paramString)) {
        return 3;
      }
      if ("older".equals(paramString)) {
        return 2;
      }
      if ("list".equals(paramString)) {
        return 1;
      }
      return -1;
    }
    
    public String migrateFromMultipleAccounts(Context paramContext, List<String> paramList)
    {
      String str = null;
      int i = -1;
      Iterator localIterator = paramList.iterator();
      paramList = str;
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        str = Persistence.this.getString(paramContext, str, "auto-advance", null);
        if (str != null)
        {
          int j = autoAdvanceSettingPriority(str);
          if (j > i)
          {
            i = j;
            paramList = str;
          }
        }
      }
      return paramList;
    }
    
    public String migrateFromSingleAccount(Context paramContext, String paramString)
    {
      return Persistence.this.getString(paramContext, paramString, "auto-advance", null);
    }
  }
  
  class ConfirmActionsAccountToGlobalMigrator
    extends Persistence.AccountToGlobalPreferenceMigrator<String>
  {
    ConfirmActionsAccountToGlobalMigrator()
    {
      super(null);
    }
    
    public String migrateFromMultipleAccounts(Context paramContext, List<String> paramList)
    {
      Object localObject = null;
      ArrayList localArrayList = Lists.newArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        str = Persistence.this.getString(paramContext, str, "confirm-actions", null);
        if (str != null) {
          localArrayList.add(str);
        }
      }
      paramContext = (Context)localObject;
      if (localArrayList.size() > 0) {
        paramContext = TextUtils.join(",", localArrayList);
      }
      return paramContext;
    }
    
    public String migrateFromSingleAccount(Context paramContext, String paramString)
    {
      return Persistence.this.getString(paramContext, paramString, "confirm-actions", null);
    }
  }
  
  class DefaultReplyAllMigrator
    extends Persistence.AccountToGlobalPreferenceMigrator<Boolean>
  {
    DefaultReplyAllMigrator()
    {
      super(null);
    }
    
    Boolean migrateFromMultipleAccounts(Context paramContext, List<String> paramList)
    {
      boolean bool = true;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        bool &= Persistence.this.getBoolean(paramContext, str, "action-strip-action-reply-all", false);
      }
      return Boolean.valueOf(bool);
    }
    
    Boolean migrateFromSingleAccount(Context paramContext, String paramString)
    {
      return Boolean.valueOf(Persistence.this.getBoolean(paramContext, paramString, "action-strip-action-reply-all", false));
    }
  }
  
  static class MailEnginePreferences
    implements MailEngine.Preferences
  {
    private final Context mContext;
    
    MailEnginePreferences(Context paramContext)
    {
      mContext = paramContext;
    }
    
    public boolean getFullTextSearchEnabled(String paramString)
    {
      return Persistence.getInstance().fullTextSearchEnabled(mContext);
    }
    
    public boolean getPrefetchAttachments(String paramString)
    {
      return Persistence.getInstance().getPrefetchAttachments(mContext, paramString);
    }
  }
  
  public class MessageTextSizeAccountToGlobalMigrator
    extends Persistence.AccountToGlobalPreferenceMigrator<String>
  {
    public MessageTextSizeAccountToGlobalMigrator()
    {
      super(null);
    }
    
    public String migrateFromMultipleAccounts(Context paramContext, List<String> paramList)
    {
      String str = null;
      float f1 = 0.0F;
      Iterator localIterator = paramList.iterator();
      paramList = str;
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        str = Persistence.this.getString(paramContext, str, "message-text", null);
        if (str != null) {
          try
          {
            float f2 = Float.parseFloat(str);
            if (f2 > f1)
            {
              f1 = f2;
              paramList = str;
            }
          }
          catch (NumberFormatException localNumberFormatException) {}
        }
      }
      return paramList;
    }
    
    public String migrateFromSingleAccount(Context paramContext, String paramString)
    {
      return Persistence.this.getString(paramContext, paramString, "message-text", null);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.persistence.Persistence
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */