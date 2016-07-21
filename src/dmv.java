import android.content.ContentUris;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.net.Uri;
import android.text.TextUtils;
import com.android.mail.providers.Account;
import com.android.mail.providers.Folder;
import com.google.android.gm.persistence.GmailBackupAgent;
import com.google.android.gm.provider.GmailProvider;
import com.google.android.gm.welcome.WelcomeTourActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;

public final class dmv
{
  public static final String a = cvl.a;
  private static final Set<String> e = hfd.a("enable-notifications", "signature", "ringtone", "vibrateWhen", "unobtrusive", "auto-advance-key", new String[] { "swipe-key", "prefetch-attachments", "conversation-mode2", "action-strip-action-reply-all", "snap-headers", "inbox-type", "show-new-inbox-onboarding", "display_images", "notification_labels", "conversation-list-sender-image", "confirm-delete", "archive", "delete", "send", "confirm-actions-key", "signature-key", "vibrate", "show-save-to-drive-promo", "save-to-drive-promo-timestamp" });
  private static dmv f = null;
  private static Boolean g = null;
  private static String h;
  private static Map<String, String> i;
  private static final List<Pattern> j;
  private static int k = -1;
  final dmy b = new dmy(this);
  final dmx c = new dmx(this);
  public final dmz d = new dmz(this);
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    j = localArrayList;
    localArrayList.add(Pattern.compile("noreply\\-\\w+@plus\\.google\\.com"));
    j.add(Pattern.compile("[0-9a-fA-F]+@plus\\.google\\.com"));
  }
  
  public static SharedPreferences a(Context paramContext)
  {
    return paramContext.getSharedPreferences("Gmail", 0);
  }
  
  public static dmv a()
  {
    if (f == null) {
      f = new dmv();
    }
    return f;
  }
  
  private static String a(String paramString1, String paramString2)
  {
    return String.format("%s-%s", new Object[] { paramString1, paramString2 });
  }
  
  public static String a(Set<String> paramSet, int paramInt)
  {
    if (paramSet == null)
    {
      dri.e(a, "attributes was null when trying to find key: %1$d", new Object[] { Integer.valueOf(paramInt) });
      return null;
    }
    String str1 = Integer.toString(paramInt);
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      if (str2 == null) {
        dri.e(a, "attributes contained a null value when trying to find key: %1$d. attributes was: $2$s", new Object[] { Integer.valueOf(paramInt), paramSet.toString() });
      }
      if (str2.startsWith(str1)) {
        return str2.substring(1);
      }
    }
    return null;
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2, String paramString3, Set<String> paramSet)
  {
    if (paramString2.equals(paramString3)) {
      return;
    }
    dri.c(a, "Migrating sync settings from %s to %s /// %s", new Object[] { paramString2, paramString3, paramSet });
    paramString3 = dpy.a(paramContext, paramString1);
    HashSet localHashSet1 = new HashSet();
    localHashSet1.addAll(paramString3.d());
    HashSet localHashSet2 = new HashSet();
    localHashSet2.addAll(paramString3.c());
    if (localHashSet2.contains(paramString2)) {
      localHashSet2.addAll(paramSet);
    }
    for (;;)
    {
      paramString3.a(localHashSet2);
      paramString3.b(localHashSet1);
      dpy.a(paramString1, paramString3, paramContext.getContentResolver());
      return;
      localHashSet1.addAll(paramSet);
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, Set<String> paramSet1, Set<String> paramSet2)
  {
    a(paramContext, paramString1, paramString2, paramString3, paramSet1);
    Object localObject;
    int m;
    if (!paramString2.equals(paramString3))
    {
      dri.c(a, "Migrating notification settings from %s to %s", new Object[] { paramString2, paramString3 });
      paramSet1 = new dnn(paramContext, paramString1, paramString2, true);
      localObject = new dnn(paramContext, paramString1, paramString3, true);
      boolean bool = paramSet1.a();
      ((cfk)localObject).a(bool);
      if (bool)
      {
        ((cfk)localObject).b(paramSet1.b());
        ((cfk)localObject).b(paramSet1.c());
        ((cfk)localObject).c(paramSet1.d());
      }
      if (!"^sq_ig_i_personal".equals(paramString2)) {
        break label235;
      }
      a(paramContext, paramString1, dpy.a);
      paramSet1 = drp.a(paramString1);
      if (paramSet1 != null)
      {
        localObject = X;
        if ((localObject != null) && (((dqc)localObject).a()))
        {
          v.f();
          m = o.b(paramString2, paramString3);
          paramSet1 = dfh.b(paramContext, paramString1);
          localObject = dfh.c(paramContext, paramString1, paramString3);
          if (localObject != null) {
            break label244;
          }
          dri.d(a, "Folder was null in migrateNotificationSettings.", new Object[0]);
        }
      }
    }
    for (;;)
    {
      a(paramContext, paramString1, paramString2, paramString3, paramSet2, false);
      GmailProvider.b(paramContext, paramString1);
      return;
      label235:
      paramSet1.a(false);
      break;
      label244:
      cvz.a(paramContext, k, m, paramSet1, (Folder)localObject, false);
    }
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2, String paramString3, Set<String> paramSet, boolean paramBoolean)
  {
    if (paramString2.equals(paramString3)) {
      return;
    }
    if ((!paramBoolean) && (drp.a(paramString1).e(paramString2)))
    {
      dri.b(a, "Not disabling sync because %s is still visible", new Object[] { paramString2 });
      return;
    }
    paramString3 = dpy.a(paramContext, paramString1);
    HashSet localHashSet1 = new HashSet();
    localHashSet1.addAll(paramString3.d());
    HashSet localHashSet2 = new HashSet();
    localHashSet2.addAll(paramString3.c());
    localHashSet2.remove(paramString2);
    localHashSet1.remove(paramString2);
    if (paramSet != null)
    {
      localHashSet2.removeAll(paramSet);
      localHashSet1.removeAll(paramSet);
    }
    paramString3.a(localHashSet2);
    paramString3.b(localHashSet1);
    dpy.a(paramString1, paramString3, paramContext.getContentResolver());
  }
  
  private static void a(Context paramContext, String paramString, Collection<String> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      g(paramContext, paramString, (String)paramCollection.next());
    }
  }
  
  private static void a(String paramString)
  {
    if (b(paramString)) {
      GmailBackupAgent.a("Shared preferences");
    }
  }
  
  @Deprecated
  public static boolean a(Context paramContext, Set<String> paramSet)
  {
    m(paramContext);
    if (paramSet != null)
    {
      paramContext = a(paramSet, 3);
      if (paramContext == null) {
        break label58;
      }
      paramSet = (String)i.get(paramContext);
      label31:
      if (paramSet == null) {
        break label63;
      }
    }
    for (;;)
    {
      if ((paramSet == null) || (h.equals(paramSet))) {
        break label68;
      }
      return true;
      paramContext = h;
      break;
      label58:
      paramSet = null;
      break label31;
      label63:
      paramSet = paramContext;
    }
    label68:
    return false;
  }
  
  public static String b()
  {
    return "Gmail";
  }
  
  @Deprecated
  private static Set<String> b(boolean paramBoolean)
  {
    if ((paramBoolean == null) || (paramBoolean.equals("")))
    {
      paramBoolean = null;
      return paramBoolean;
    }
    String[] arrayOfString = TextUtils.split(paramBoolean, (String)localObject);
    Object localObject = new HashSet();
    int n = arrayOfString.length;
    int m = 0;
    for (;;)
    {
      paramBoolean = localObject;
      if (m >= n) {
        break;
      }
      ((Set)localObject).add(arrayOfString[m]);
      m += 1;
    }
  }
  
  private final void b(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    b(paramContext, paramString1, "inbox-type", paramString2);
    if (paramBoolean) {
      ao.e();
    }
  }
  
  private static boolean b(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    int m = paramString.indexOf('^');
    String str = paramString;
    if (m >= 0) {
      str = paramString.substring(0, m);
    }
    return e.contains(str);
  }
  
  public static void c(Context paramContext, String paramString1, String paramString2)
  {
    a(paramContext, paramString1, paramString2, null, null, true);
    new dnn(paramContext, paramString1, paramString2, false).a(false);
  }
  
  public static List<Pattern> d(Context paramContext)
  {
    paramContext = ghz.a(paramContext.getContentResolver(), "gmail_social_network_sender_patterns", null);
    if (paramContext != null)
    {
      int m = paramContext.hashCode();
      if (m != k)
      {
        k = m;
        paramContext = TextUtils.split(paramContext, ";");
        j.clear();
        int n = paramContext.length;
        m = 0;
        while (m < n)
        {
          String str = paramContext[m];
          j.add(Pattern.compile(str));
          m += 1;
        }
      }
    }
    return j;
  }
  
  public static String e(Context paramContext, String paramString1, String paramString2)
  {
    if ("priority".equals(paramString1)) {
      return "^iim";
    }
    if ("default".equals(paramString1))
    {
      if (a().c(paramContext, paramString2)) {
        return "^sq_ig_i_personal";
      }
      return "^i";
    }
    return null;
  }
  
  public static String f(Context paramContext, String paramString)
  {
    dmv localdmv = a();
    String str1 = localdmv.a(paramContext, paramString, true);
    boolean bool = localdmv.c(paramContext, paramString);
    String str2 = e(paramContext, str1, paramString);
    if (str2 != null) {
      return str2;
    }
    dri.e(a, "We had an invalid inbox type set (%1$s), reverting to default", new Object[] { str1 });
    localdmv.d(paramContext, paramString, "default");
    if (bool) {
      return "^sq_ig_i_personal";
    }
    return "^i";
  }
  
  private static String f(Context paramContext, String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramString1 != null)
    {
      paramContext = deg.a(paramContext).a(paramString1);
      if (paramContext != null) {
        paramString1 = paramContext;
      }
      str = a(paramString1, paramString2);
    }
    return str;
  }
  
  private static void g(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject = new dnn(paramContext, paramString1, paramString2, false);
    if (((cfk)localObject).a()) {
      ((cfk)localObject).a(false);
    }
    localObject = dfh.b(paramContext, paramString1);
    paramString1 = dfh.a(paramContext, paramString1, paramString2, true);
    if ((localObject != null) && (paramString1 != null)) {
      cvz.a(paramContext, (Account)localObject, paramString1, false);
    }
  }
  
  private static String h(Context paramContext, String paramString)
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
          boolean bool = hbw.b(str);
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
  
  private static String i(Context paramContext, String paramString)
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
  
  public static dtb j(Context paramContext)
  {
    return new dna(paramContext);
  }
  
  /* Error */
  @Deprecated
  private static void m(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 98	dmv:g	Ljava/lang/Boolean;
    //   6: ifnull +9 -> 15
    //   9: getstatic 388	dmv:i	Ljava/util/Map;
    //   12: ifnonnull +126 -> 138
    //   15: aload_0
    //   16: ldc_w 536
    //   19: invokevirtual 540	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   22: checkcast 542	android/os/Vibrator
    //   25: astore_2
    //   26: aload_2
    //   27: ifnull +115 -> 142
    //   30: aload_2
    //   31: invokevirtual 545	android/os/Vibrator:hasVibrator	()Z
    //   34: ifeq +108 -> 142
    //   37: iconst_1
    //   38: istore_1
    //   39: iload_1
    //   40: invokestatic 550	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   43: putstatic 98	dmv:g	Ljava/lang/Boolean;
    //   46: aload_0
    //   47: invokevirtual 554	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   50: astore_0
    //   51: aload_0
    //   52: getstatic 559	dge:eK	I
    //   55: invokevirtual 562	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   58: putstatic 396	dmv:h	Ljava/lang/String;
    //   61: aload_0
    //   62: getstatic 565	dge:eL	I
    //   65: invokevirtual 562	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   68: astore_2
    //   69: aload_0
    //   70: getstatic 559	dge:eK	I
    //   73: invokevirtual 562	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   76: astore_3
    //   77: new 567	hen
    //   80: dup
    //   81: invokespecial 568	hen:<init>	()V
    //   84: astore 4
    //   86: aload 4
    //   88: aload_2
    //   89: aload_2
    //   90: invokevirtual 571	hen:b	(Ljava/lang/Object;Ljava/lang/Object;)Lhen;
    //   93: pop
    //   94: aload 4
    //   96: aload_3
    //   97: aload_3
    //   98: invokevirtual 571	hen:b	(Ljava/lang/Object;Ljava/lang/Object;)Lhen;
    //   101: pop
    //   102: aload 4
    //   104: aload_0
    //   105: getstatic 574	dge:dS	I
    //   108: invokevirtual 562	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   111: aload_2
    //   112: invokevirtual 571	hen:b	(Ljava/lang/Object;Ljava/lang/Object;)Lhen;
    //   115: pop
    //   116: aload 4
    //   118: aload_0
    //   119: getstatic 577	dge:dT	I
    //   122: invokevirtual 562	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   125: aload_3
    //   126: invokevirtual 571	hen:b	(Ljava/lang/Object;Ljava/lang/Object;)Lhen;
    //   129: pop
    //   130: aload 4
    //   132: invokevirtual 580	hen:b	()Lhel;
    //   135: putstatic 388	dmv:i	Ljava/util/Map;
    //   138: ldc 2
    //   140: monitorexit
    //   141: return
    //   142: iconst_0
    //   143: istore_1
    //   144: goto -105 -> 39
    //   147: astore_0
    //   148: ldc 2
    //   150: monitorexit
    //   151: aload_0
    //   152: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramContext	Context
    //   38	106	1	bool	boolean
    //   25	87	2	localObject	Object
    //   76	50	3	str	String
    //   84	47	4	localhen	hen
    // Exception table:
    //   from	to	target	type
    //   3	15	147	finally
    //   15	26	147	finally
    //   30	37	147	finally
    //   39	138	147	finally
  }
  
  public final long a(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    if (paramString1 != null) {
      return paramContext.getSharedPreferences("Gmail", 0).getLong(f(paramContext, paramString1, paramString2), paramLong);
    }
    return paramContext.getSharedPreferences("Gmail", 0).getLong(paramString2, paramLong);
  }
  
  public final String a(Context paramContext, String paramString)
  {
    return a(paramContext, null, a(paramString, "account-alias"), null);
  }
  
  public final String a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 != null) {
      return paramContext.getSharedPreferences("Gmail", 0).getString(f(paramContext, paramString1, paramString2), paramString3);
    }
    return paramContext.getSharedPreferences("Gmail", 0).getString(paramString2, paramString3);
  }
  
  public final String a(Context paramContext, String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (b(paramContext, paramString, "inbox-type"))
    {
      localObject = a(paramContext, paramString, "inbox-type", "default");
      return (String)localObject;
    }
    String str2;
    if (b(paramContext, paramString, "priority-inbox-key"))
    {
      str2 = "priority-inbox-key";
      label44:
      if (!a(paramContext, paramString, str2, false)) {
        break label96;
      }
    }
    label96:
    for (String str1 = "priority";; str1 = "default")
    {
      localObject = str1;
      if (!b(paramContext, paramString, str2)) {
        break;
      }
      b(paramContext, paramString, str1, paramBoolean);
      return str1;
      str2 = "priority-inbox";
      break label44;
    }
  }
  
  public final Set<String> a(Context paramContext, String paramString1, String paramString2, Set<String> paramSet)
  {
    return paramContext.getSharedPreferences("Gmail", 0).getStringSet(f(paramContext, paramString1, paramString2), paramSet);
  }
  
  public final void a(Context paramContext, int paramInt)
  {
    int m = l(paramContext);
    if (paramInt > m)
    {
      dri.c(WelcomeTourActivity.a, "Updated shared pref for %s: %d -> %d", new Object[] { "welcome_tour_version", Integer.valueOf(m), Integer.valueOf(paramInt) });
      SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("Gmail", 0).edit();
      localEditor.putInt(f(paramContext, null, "welcome_tour_version"), paramInt);
      localEditor.apply();
      a("welcome_tour_version");
    }
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2)
  {
    b(paramContext, null, a(paramString1, "account-alias"), paramString2);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, Boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("Gmail", 0).edit();
    localEditor.putBoolean(f(paramContext, paramString1, paramString2), paramBoolean.booleanValue());
    localEditor.apply();
    a(paramString2);
  }
  
  public final void a(Context paramContext, String paramString, boolean paramBoolean, Set<String> paramSet, drl paramdrl)
  {
    String str1 = f(paramContext, paramString);
    boolean bool = a(paramContext, paramString, "server-sectioned-inbox", false);
    a(paramContext, paramString, "server-sectioned-inbox", Boolean.valueOf(paramBoolean));
    if (paramBoolean == bool) {
      return;
    }
    String str2 = f(paramContext, paramString);
    ao.e();
    if (paramSet.isEmpty())
    {
      paramSet = hfd.b("^sq_ig_i_personal");
      if (!"default".equals(a(paramContext, paramString, true))) {
        break label160;
      }
      if (!paramBoolean) {
        break label134;
      }
      a(paramContext, paramString, str1, str2, paramSet, hfd.b("^i"));
      paramdrl.a();
    }
    for (;;)
    {
      if (!paramBoolean) {
        break label237;
      }
      g(paramContext, paramString, "^i");
      return;
      break;
      label134:
      a(paramContext, paramString, str1, str2, hfd.b(str2), paramSet);
      paramdrl.a();
    }
    label160:
    Object localObject;
    if (paramBoolean)
    {
      str1 = "^i";
      str2 = "^sq_ig_i_personal";
      localObject = hfd.b("^i");
      paramdrl = paramSet;
    }
    for (;;)
    {
      a(paramContext, paramString, str1, str2, paramdrl);
      a(paramContext, paramString, str1, str2, (Set)localObject, false);
      break;
      str1 = "^sq_ig_i_personal";
      str2 = "^i";
      paramdrl = hfd.b("^i");
      localObject = paramSet;
    }
    label237:
    a(paramContext, paramString, dpy.a);
  }
  
  public final void a(Context paramContext, List<dgi> paramList, String paramString)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (dgi)localIterator.next();
      paramList = c;
      String str2 = a;
      if (b(str2))
      {
        String str3 = b;
        if ((paramList instanceof Boolean))
        {
          a(paramContext, str3, str2, (Boolean)paramList);
          dri.a(a, "Restore: %s", new Object[] { localObject });
        }
        else
        {
          String str1;
          if ((paramList instanceof String))
          {
            str1 = (String)paramList;
            paramList = str1;
            if ("ringtone".equals(str2))
            {
              str1 = i(paramContext, str1);
              paramList = str1;
              if (str1 == null)
              {
                dri.d(a, "Can't restore ringtone (not found)", new Object[0]);
                continue;
              }
            }
            b(paramContext, str3, str2, paramList);
            dri.a(paramString, "Restore: %s", new Object[] { localObject });
          }
          else if ((paramList instanceof Set))
          {
            localObject = (Set)paramList;
            if (str2.startsWith("notification_labels"))
            {
              String str4 = a((Set)localObject, 2);
              str1 = i(paramContext, str4);
              paramList = str1;
              if (str1 == null) {
                paramList = RingtoneManager.getDefaultUri(2).toString();
              }
              ((Set)localObject).remove(String.valueOf(str4).length() + 11 + 2 + str4);
              ((Set)localObject).add(String.valueOf(paramList).length() + 11 + 2 + paramList);
            }
            paramList = paramContext.getSharedPreferences("Gmail", 0).edit();
            paramList.putStringSet(f(paramContext, str3, str2), (Set)localObject);
            paramList.apply();
            a(str2);
          }
          else
          {
            dri.e(paramString, "Unknown preference data type: %s", new Object[] { paramList.getClass() });
          }
        }
      }
    }
    paramContext.getSharedPreferences("Gmail", 0).edit().commit();
  }
  
  public final void a(Context paramContext, Map<String, Long> paramMap, String paramString1, String paramString2, String paramString3)
  {
    paramMap = (Long)paramMap.get(paramString1);
    if (paramMap != null)
    {
      dri.a(a, "Saving %s-%s timestamp: %d", new Object[] { paramString2, paramString3, paramMap });
      b(paramContext, paramString2, paramString3, paramMap.longValue());
    }
  }
  
  public final void a(Context paramContext, boolean paramBoolean)
  {
    a(paramContext, null, "force_show_welcome_tour", Boolean.valueOf(paramBoolean));
  }
  
  public final boolean a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    return paramContext.getSharedPreferences("Gmail", 0).getBoolean(f(paramContext, paramString1, paramString2), paramBoolean);
  }
  
  public final String b(Context paramContext)
  {
    return a(paramContext, null, "active-account", null);
  }
  
  public final String b(Context paramContext, String paramString)
  {
    String str = a(paramContext, paramString, "signature", null);
    paramString = str;
    if (str == null) {
      paramString = a(paramContext, null, "signature-key", null);
    }
    paramContext = paramString;
    if (paramString == null) {
      paramContext = "";
    }
    return paramContext;
  }
  
  @Deprecated
  public final Set<String> b(Context paramContext, String paramString1, String paramString2, Set<String> paramSet)
  {
    Object localObject = String.valueOf("notification_labels");
    paramString2 = String.valueOf(paramString2);
    if (paramString2.length() != 0) {}
    for (paramString2 = ((String)localObject).concat(paramString2);; paramString2 = new String((String)localObject))
    {
      try
      {
        localObject = a(paramContext, paramString1, paramString2, paramSet);
        paramSet = (Set<String>)localObject;
      }
      catch (ClassCastException localClassCastException)
      {
        do
        {
          paramContext = b(a(paramContext, paramString1, paramString2, null), " ");
        } while (paramContext == null);
        paramString1 = new HashSet();
        paramString2 = String.valueOf(a(paramContext, 0));
        paramString1.add(String.valueOf(paramString2).length() + 11 + 1 + paramString2);
        paramString2 = String.valueOf(a(paramContext, 1));
        paramString1.add(String.valueOf(paramString2).length() + 11 + 2 + paramString2);
        paramString2 = String.valueOf(a(paramContext, 2));
        paramString1.add(String.valueOf(paramString2).length() + 11 + 3 + paramString2);
        paramContext = String.valueOf(a(paramContext, 3));
        paramString1.add(String.valueOf(paramContext).length() + 11 + 4 + paramContext);
      }
      return paramSet;
    }
    return paramString1;
  }
  
  public final void b(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("Gmail", 0).edit();
    localEditor.putLong(f(paramContext, paramString1, paramString2), paramLong);
    localEditor.apply();
    a(paramString2);
  }
  
  public final void b(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("Gmail", 0).edit();
    localEditor.putString(f(paramContext, paramString1, paramString2), paramString3);
    localEditor.apply();
    a(paramString2);
  }
  
  public final boolean b(Context paramContext, String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramString1 != null) {
      str = f(paramContext, paramString1, paramString2);
    }
    return paramContext.getSharedPreferences("Gmail", 0).contains(str);
  }
  
  @Deprecated
  public final Set<String> c(Context paramContext)
  {
    localHashSet = new HashSet();
    Object localObject = a(paramContext, null, "display_images", "");
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      try
      {
        localObject = new JSONArray((String)localObject);
        int n = ((JSONArray)localObject).length();
        int m = 0;
        while (m < n)
        {
          localHashSet.add((String)((JSONArray)localObject).get(m));
          m += 1;
        }
        return localHashSet;
      }
      catch (JSONException localJSONException)
      {
        b(paramContext, null, "display_images", "");
      }
    }
  }
  
  public final boolean c(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, "server-sectioned-inbox", false);
  }
  
  public final void d(Context paramContext, String paramString)
  {
    if ((b(paramContext, paramString, "show-new-inbox-onboarding")) && (a(paramContext, paramString, "show-new-inbox-onboarding", true))) {
      a(paramContext, paramString, "show-new-inbox-onboarding", Boolean.valueOf(false));
    }
  }
  
  public final void d(Context paramContext, String paramString1, String paramString2)
  {
    b(paramContext, paramString1, paramString2, true);
  }
  
  @Deprecated
  public final String e(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    String str = f(paramContext);
    paramContext = str;
    if (str == null) {
      paramContext = localResources.getString(dge.eH);
    }
    return paramContext;
  }
  
  public final boolean e(Context paramContext, String paramString)
  {
    if (!cud.a(paramContext)) {}
    for (boolean bool = true;; bool = false) {
      return a(paramContext, paramString, "prefetch-attachments", bool);
    }
  }
  
  @Deprecated
  public final String f(Context paramContext)
  {
    Object localObject2 = a(paramContext, null, "auto-advance-key", null);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (String)c.a(paramContext);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = a(paramContext, null, "auto-advance", null);
    }
    return (String)localObject2;
  }
  
  @Deprecated
  public final Set<String> g(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    Object localObject2 = a(paramContext, null, "confirm-actions-key", null);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (String)b.a(paramContext);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = a(paramContext, null, "confirm-actions", null);
    }
    paramContext = (Context)localObject2;
    if (localObject2 == null) {
      paramContext = localResources.getString(dge.eI);
    }
    return hio.a(TextUtils.split(paramContext, ","));
  }
  
  public final boolean g(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, "should-sync-all-promos", true);
  }
  
  public final List<String> h()
  {
    Context localContext;
    return hef.a(TextUtils.split(a(localContext, null, "cache-google-accounts-synced", ""), " "));
  }
  
  public final List<dgi> i(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("Gmail", 0);
    Iterator localIterator1 = localSharedPreferences.getAll().entrySet().iterator();
    Object localObject4;
    Object localObject1;
    String str1;
    Object localObject2;
    label109:
    Object localObject3;
    do
    {
      if (!localIterator1.hasNext()) {
        break label346;
      }
      localObject4 = (Map.Entry)localIterator1.next();
      localObject1 = (String)((Map.Entry)localObject4).getKey();
      if (((String)localObject1).indexOf('@') < 0) {
        break;
      }
      int m = ((String)localObject1).indexOf('-', ((String)localObject1).lastIndexOf(46));
      str1 = ((String)localObject1).substring(0, m);
      localObject2 = ((String)localObject1).substring(m + 1);
      if (!b((String)localObject2)) {
        break label183;
      }
      localObject3 = ((Map.Entry)localObject4).getValue();
      if (!"ringtone".equals(localObject2)) {
        break label185;
      }
      localObject1 = h(paramContext, (String)((Map.Entry)localObject4).getValue());
    } while (localObject1 == null);
    for (;;)
    {
      localArrayList.add(new dgi((String)localObject2, str1, localObject1));
      break;
      localObject2 = localObject1;
      str1 = null;
      break label109;
      label183:
      break;
      label185:
      if (((String)localObject2).startsWith("notification_labels"))
      {
        localObject1 = localSharedPreferences.getStringSet((String)localObject1, null);
        if (localObject1 == null) {
          break;
        }
        localObject3 = new HashSet();
        String str2 = Integer.toString(2);
        Iterator localIterator2 = ((Set)localObject1).iterator();
        while (localIterator2.hasNext())
        {
          localObject1 = (String)localIterator2.next();
          if (((String)localObject1).startsWith(str2))
          {
            localObject4 = h(paramContext, ((String)localObject1).substring(1));
            localObject1 = localObject4;
            if (localObject4 == null) {
              localObject1 = RingtoneManager.getDefaultUri(2).toString();
            }
            ((Set)localObject3).add(String.valueOf(localObject1).length() + 11 + 2 + (String)localObject1);
          }
          else
          {
            ((Set)localObject3).add(localObject1);
          }
        }
        localObject1 = localObject3;
        continue;
        label346:
        return localArrayList;
      }
      localObject1 = localObject3;
    }
  }
  
  public final void k(Context paramContext)
  {
    b(paramContext, null, "last_sync_time", System.currentTimeMillis());
  }
  
  public final int l(Context paramContext)
  {
    return paramContext.getSharedPreferences("Gmail", 0).getInt("welcome_tour_version", -2);
  }
}

/* Location:
 * Qualified Name:     dmv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */