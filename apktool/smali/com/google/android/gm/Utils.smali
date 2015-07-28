.class public Lcom/google/android/gm/Utils;
.super Ljava/lang/Object;
.source "Utils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gm/Utils$ScheduleSyncTask;,
        Lcom/google/android/gm/Utils$GmailMessagePlainTextConverter;,
        Lcom/google/android/gm/Utils$NotificationMap;,
        Lcom/google/android/gm/Utils$NotificationKey;
    }
.end annotation


# static fields
.field private static final BUG_REPORT_INTENT:Landroid/content/Intent;

.field private static final GMAIL_LABEL_SHORTCUT_COMPONENT_NAME:Landroid/content/ComponentName;

.field private static final GMAIL_MESSAGE_CONVERTER_FACTORY:Lcom/google/android/common/html/parser/HtmlTree$PlainTextConverterFactory;

.field private static final GOOGLE_MAIL_CONVERSATION_LIST_COMPONENT_NAME:Landroid/content/ComponentName;

.field private static final GOOGLE_MAIL_LABEL_SHORTCUT_COMPONENT_NAME:Landroid/content/ComponentName;

.field private static final GOOGLE_MAIL_MCC_SET:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private static final UI_ACCOUNT_MAP:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/android/mail/providers/Account;",
            ">;"
        }
    .end annotation
.end field

.field private static sActiveNotificationMap:Lcom/google/android/gm/Utils$NotificationMap;

.field private static sActiveSendErrorNotificationsMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/Integer;",
            ">;>;"
        }
    .end annotation
.end field

.field public static sDefaultSingleNotifIcon:Landroid/graphics/Bitmap;

.field private static sDraftPluralString:Ljava/lang/CharSequence;

.field private static sDraftSingularString:Ljava/lang/CharSequence;

.field private static sDraftsStyleSpan:Landroid/text/style/CharacterStyle;

.field private static sLastScheduleSyncTask:Lcom/google/android/gm/Utils$ScheduleSyncTask;

.field private static sMeString:Ljava/lang/CharSequence;

.field public static sMultipleNotifIcon:Landroid/graphics/Bitmap;

.field private static sReadStyleSpan:Landroid/text/style/CharacterStyle;

.field private static sSendFailedString:Ljava/lang/CharSequence;

.field private static sSendingString:Ljava/lang/CharSequence;

.field private static sUnreadStyleSpan:Landroid/text/style/CharacterStyle;

.field private static sVersionCode:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 164
    new-instance v0, Landroid/content/ComponentName;

    const-string v1, "com.google.android.gm"

    const-string v2, "com.google.android.gm.CreateShortcutActivityGmail"

    invoke-direct {v0, v1, v2}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lcom/google/android/gm/Utils;->GMAIL_LABEL_SHORTCUT_COMPONENT_NAME:Landroid/content/ComponentName;

    .line 167
    new-instance v0, Landroid/content/ComponentName;

    const-string v1, "com.google.android.gm"

    const-string v2, "com.google.android.gm.CreateShortcutActivityGoogleMail"

    invoke-direct {v0, v1, v2}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lcom/google/android/gm/Utils;->GOOGLE_MAIL_LABEL_SHORTCUT_COMPONENT_NAME:Landroid/content/ComponentName;

    .line 170
    new-instance v0, Landroid/content/ComponentName;

    const-string v1, "com.google.android.gm"

    const-string v2, "com.google.android.gm.ConversationListActivityGoogleMail"

    invoke-direct {v0, v1, v2}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lcom/google/android/gm/Utils;->GOOGLE_MAIL_CONVERSATION_LIST_COMPONENT_NAME:Landroid/content/ComponentName;

    .line 177
    const/16 v0, 0x106

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-static {v0}, Lcom/google/common/collect/ImmutableSet;->of(Ljava/lang/Object;)Lcom/google/common/collect/ImmutableSet;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/Utils;->GOOGLE_MAIL_MCC_SET:Ljava/util/Set;

    .line 181
    sput-object v3, Lcom/google/android/gm/Utils;->sVersionCode:Ljava/lang/String;

    .line 184
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.BUG_REPORT"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/google/android/gm/Utils;->BUG_REPORT_INTENT:Landroid/content/Intent;

    .line 186
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/Utils;->UI_ACCOUNT_MAP:Ljava/util/Map;

    .line 190
    new-instance v0, Lcom/google/android/gm/Utils$1;

    invoke-direct {v0}, Lcom/google/android/gm/Utils$1;-><init>()V

    sput-object v0, Lcom/google/android/gm/Utils;->GMAIL_MESSAGE_CONVERTER_FACTORY:Lcom/google/android/common/html/parser/HtmlTree$PlainTextConverterFactory;

    .line 326
    sput-object v3, Lcom/google/android/gm/Utils;->sActiveNotificationMap:Lcom/google/android/gm/Utils$NotificationMap;

    .line 1485
    sput-object v3, Lcom/google/android/gm/Utils;->sUnreadStyleSpan:Landroid/text/style/CharacterStyle;

    .line 2226
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    sput-object v0, Lcom/google/android/gm/Utils;->sActiveSendErrorNotificationsMap:Ljava/util/Map;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 108
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 1454
    return-void
.end method

.method static synthetic access$102(Lcom/google/android/gm/Utils$ScheduleSyncTask;)Lcom/google/android/gm/Utils$ScheduleSyncTask;
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/Utils$ScheduleSyncTask;

    .prologue
    .line 108
    sput-object p0, Lcom/google/android/gm/Utils;->sLastScheduleSyncTask:Lcom/google/android/gm/Utils$ScheduleSyncTask;

    return-object p0
.end method

.method private static addGmailParamsToUrl(Landroid/content/Context;Ljava/lang/String;)Landroid/net/Uri;
    .locals 3

    .prologue
    .line 1921
    invoke-static {p1}, Lcom/google/android/gm/Utils;->replaceLocale(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1922
    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    .line 1923
    invoke-static {p0}, Lcom/google/android/gm/Utils;->getVersionCode(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    .line 1924
    if-eqz v1, :cond_0

    .line 1925
    const-string v2, "version"

    invoke-virtual {v0, v2, v1}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    .line 1928
    :cond_0
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v1

    .line 1931
    sget-object v2, Lcom/google/android/gm/Utils;->GOOGLE_MAIL_MCC_SET:Ljava/util/Set;

    iget v1, v1, Landroid/content/res/Configuration;->mcc:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v2, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    invoke-static {p0}, Lcom/google/android/gm/Utils;->haveGoogleMailActivitiesBeenEnabled(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_2

    :cond_1
    const/4 v1, 0x1

    .line 1933
    :goto_0
    const-string v2, "googleMail"

    if-eqz v1, :cond_3

    const-string v1, "1"

    :goto_1
    invoke-virtual {v0, v2, v1}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    .line 1934
    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    return-object v0

    .line 1931
    :cond_2
    const/4 v1, 0x0

    goto :goto_0

    .line 1933
    :cond_3
    const-string v1, "0"

    goto :goto_1
.end method

.method public static cacheGoogleAccountList(Landroid/content/Context;Z[Landroid/accounts/Account;)V
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "synced"    # Z
    .param p2, "accounts"    # [Landroid/accounts/Account;

    .prologue
    .line 2134
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v0

    .line 2135
    .local v0, "accountNames":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v2, p2

    if-ge v1, v2, :cond_0

    .line 2136
    aget-object v2, p2, v1

    iget-object v2, v2, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 2135
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 2138
    :cond_0
    invoke-static {}, Lcom/google/android/gm/persistence/Persistence;->getInstance()Lcom/google/android/gm/persistence/Persistence;

    move-result-object v2

    invoke-virtual {v2, p0, p1, v0}, Lcom/google/android/gm/persistence/Persistence;->cacheConfiguredGoogleAccounts(Landroid/content/Context;ZLjava/lang/Iterable;)V

    .line 2140
    return-void
.end method

.method public static cancelAllNotifications(Landroid/content/Context;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 454
    const-string v1, "notification"

    invoke-virtual {p0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/NotificationManager;

    .line 456
    .local v0, "nm":Landroid/app/NotificationManager;
    invoke-virtual {v0}, Landroid/app/NotificationManager;->cancelAll()V

    .line 457
    invoke-static {p0}, Lcom/google/android/gm/Utils;->clearAllNotfications(Landroid/content/Context;)V

    .line 458
    return-void
.end method

.method public static cancelAndResendNotifications(Landroid/content/Context;)V
    .locals 11
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 465
    const-string v0, "notification"

    invoke-virtual {p0, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroid/app/NotificationManager;

    .line 467
    .local v9, "nm":Landroid/app/NotificationManager;
    invoke-virtual {v9}, Landroid/app/NotificationManager;->cancelAll()V

    .line 469
    invoke-static {p0}, Lcom/google/android/gm/Utils;->getNotificationMap(Landroid/content/Context;)Lcom/google/android/gm/Utils$NotificationMap;

    move-result-object v10

    .line 470
    .local v10, "notificationMap":Lcom/google/android/gm/Utils$NotificationMap;
    invoke-virtual {v10}, Lcom/google/android/gm/Utils$NotificationMap;->keySet()Ljava/util/Set;

    move-result-object v8

    .line 472
    .local v8, "keys":Ljava/util/Set;, "Ljava/util/Set<Lcom/google/android/gm/Utils$NotificationKey;>;"
    invoke-interface {v8}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v7

    .local v7, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/google/android/gm/Utils$NotificationKey;

    .line 473
    .local v6, "notification":Lcom/google/android/gm/Utils$NotificationKey;
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 474
    .local v1, "fakedIntent":Landroid/content/Intent;
    const-string v0, "count"

    invoke-virtual {v10, v6}, Lcom/google/android/gm/Utils$NotificationMap;->getUnread(Lcom/google/android/gm/Utils$NotificationKey;)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 476
    const-string v0, "unseenCount"

    invoke-virtual {v10, v6}, Lcom/google/android/gm/Utils$NotificationMap;->getUnseen(Lcom/google/android/gm/Utils$NotificationKey;)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 478
    const-string v0, "account"

    iget-object v2, v6, Lcom/google/android/gm/Utils$NotificationKey;->account:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 479
    iget-object v2, v6, Lcom/google/android/gm/Utils$NotificationKey;->account:Ljava/lang/String;

    const/4 v3, 0x1

    iget-object v4, v6, Lcom/google/android/gm/Utils$NotificationKey;->label:Ljava/lang/String;

    const/4 v5, 0x0

    move-object v0, p0

    invoke-static/range {v0 .. v6}, Lcom/google/android/gm/Utils;->validateNotifications(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;ZLjava/lang/String;ZLcom/google/android/gm/Utils$NotificationKey;)V

    goto :goto_0

    .line 482
    .end local v1    # "fakedIntent":Landroid/content/Intent;
    .end local v6    # "notification":Lcom/google/android/gm/Utils$NotificationKey;
    :cond_0
    return-void
.end method

.method public static clearAllNotfications(Landroid/content/Context;)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 548
    const-string v1, "Gmail"

    const-string v2, "Clearing all notifications."

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v1, v2, v3}, Lcom/google/android/gm/provider/LogUtils;->v(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 549
    invoke-static {p0}, Lcom/google/android/gm/Utils;->getNotificationMap(Landroid/content/Context;)Lcom/google/android/gm/Utils$NotificationMap;

    move-result-object v0

    .line 550
    .local v0, "notificationMap":Lcom/google/android/gm/Utils$NotificationMap;
    invoke-virtual {v0}, Lcom/google/android/gm/Utils$NotificationMap;->clear()V

    .line 551
    invoke-virtual {v0, p0}, Lcom/google/android/gm/Utils$NotificationMap;->saveNotificationMap(Landroid/content/Context;)V

    .line 552
    return-void
.end method

.method public static clearLabelNotification(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .locals 6
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "label"    # Ljava/lang/String;

    .prologue
    .line 558
    const-string v2, "Gmail"

    const-string v3, "Clearing all notifications for %s/%s"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object p1, v4, v5

    const/4 v5, 0x1

    aput-object p2, v4, v5

    invoke-static {v2, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->v(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 559
    invoke-static {p0}, Lcom/google/android/gm/Utils;->getNotificationMap(Landroid/content/Context;)Lcom/google/android/gm/Utils$NotificationMap;

    move-result-object v1

    .line 560
    .local v1, "notificationMap":Lcom/google/android/gm/Utils$NotificationMap;
    new-instance v0, Lcom/google/android/gm/Utils$NotificationKey;

    invoke-direct {v0, p1, p2}, Lcom/google/android/gm/Utils$NotificationKey;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 561
    .local v0, "key":Lcom/google/android/gm/Utils$NotificationKey;
    invoke-virtual {v1, v0}, Lcom/google/android/gm/Utils$NotificationMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 562
    invoke-virtual {v1, p0}, Lcom/google/android/gm/Utils$NotificationMap;->saveNotificationMap(Landroid/content/Context;)V

    .line 563
    return-void
.end method

.method private static configureLatestEventInfoFromConversation(Landroid/content/Context;Landroid/app/Notification$Builder;Lcom/google/android/gm/provider/Gmail$ConversationCursor;Landroid/app/PendingIntent;Ljava/lang/String;IILjava/lang/String;)V
    .locals 22

    .prologue
    .line 877
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v18

    .line 878
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    invoke-static {v3}, Lcom/google/android/gm/comm/longshadow/LongShadowUtils;->getContentProviderMailAccess(Landroid/content/ContentResolver;)Lcom/google/android/gm/provider/Gmail;

    move-result-object v19

    .line 881
    const-string v3, "Gmail"

    const-string v4, "Showing notification with unreadCount of %d and unseenCount of %d"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    invoke-static/range {p5 .. p5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x1

    invoke-static/range {p6 .. p6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v3, v4, v5}, Lcom/google/android/gm/provider/LogUtils;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 885
    move-object/from16 v0, p0

    move-object/from16 v1, p4

    invoke-static {v0, v1}, Lcom/google/android/gm/persistence/Persistence;->getAccountInbox(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 889
    move-object/from16 v0, p7

    invoke-static {v3, v0}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_7

    const/4 v3, 0x1

    move/from16 v17, v3

    .line 892
    :goto_0
    if-eqz v17, :cond_8

    move-object/from16 v0, p0

    move-object/from16 v1, p4

    move-object/from16 v2, p7

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/LabelManager;->getLabel(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gm/provider/Label;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/android/gm/provider/Label;->getName()Ljava/lang/String;

    move-result-object v13

    .line 895
    :goto_1
    const/4 v3, 0x1

    move/from16 v0, p6

    if-le v0, v3, :cond_c

    .line 897
    const v3, 0x7f0c01d8

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-static/range {p6 .. p6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    move-object/from16 v0, v18

    invoke-virtual {v0, v3, v4}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v16

    .line 900
    const/4 v3, 0x1

    move-object/from16 v0, p0

    invoke-static {v0, v3}, Lcom/google/android/gm/Utils;->getDefaultNotificationIcon(Landroid/content/Context;Z)Landroid/graphics/Bitmap;

    move-result-object v3

    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Landroid/app/Notification$Builder;->setLargeIcon(Landroid/graphics/Bitmap;)Landroid/app/Notification$Builder;

    .line 907
    move-object/from16 v0, p1

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Landroid/app/Notification$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    .line 909
    invoke-static {}, Lcom/android/mail/utils/Utils;->isRunningJellybeanOrLater()Z

    move-result v3

    if-eqz v3, :cond_a

    .line 911
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0a0028

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v20

    .line 915
    if-eqz v17, :cond_0

    move-object/from16 p4, v13

    :cond_0
    move-object/from16 v0, p1

    move-object/from16 v1, p4

    invoke-virtual {v0, v1}, Landroid/app/Notification$Builder;->setSubText(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    .line 918
    new-instance v17, Landroid/app/Notification$InboxStyle;

    move-object/from16 v0, v17

    move-object/from16 v1, p1

    invoke-direct {v0, v1}, Landroid/app/Notification$InboxStyle;-><init>(Landroid/app/Notification$Builder;)V

    .line 920
    move-object/from16 v0, v17

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Landroid/app/Notification$InboxStyle;->setBigContentTitle(Ljava/lang/CharSequence;)Landroid/app/Notification$InboxStyle;

    .line 922
    const/4 v3, 0x0

    move v14, v3

    .line 924
    :goto_2
    invoke-virtual/range {p2 .. p2}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getHasUnreadMessage()Z

    move-result v3

    if-eqz v3, :cond_18

    .line 925
    const/4 v4, 0x0

    .line 926
    const/4 v3, 0x0

    .line 929
    :try_start_0
    invoke-virtual/range {p2 .. p2}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getAccount()Ljava/lang/String;

    move-result-object v5

    invoke-virtual/range {p2 .. p2}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getConversationId()J

    move-result-wide v6

    move-object/from16 v0, v19

    invoke-virtual {v0, v5, v6, v7}, Lcom/google/android/gm/provider/Gmail;->getDetachedMessageCursorForConversationId(Ljava/lang/String;J)Lcom/google/android/gm/provider/Gmail$MessageCursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_3

    move-result-object v15

    .line 932
    const/4 v5, 0x0

    .line 933
    :try_start_1
    const-string v4, ""

    .line 934
    invoke-virtual {v15}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->count()I

    move-result v6

    add-int/lit8 v6, v6, -0x1

    invoke-virtual {v15, v6}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->moveTo(I)Z

    move-result v6

    if-eqz v6, :cond_17

    .line 935
    invoke-virtual {v15}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->getFromAddress()Ljava/lang/String;

    move-result-object v4

    .line 936
    invoke-static {v4}, Lcom/google/android/gm/Utils;->getDisplayableSender(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    move-object v6, v5

    .line 938
    :cond_1
    :goto_3
    invoke-virtual {v15}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->position()I

    move-result v5

    add-int/lit8 v5, v5, -0x1

    invoke-virtual {v15, v5}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->moveTo(I)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 939
    invoke-virtual {v15}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->getIsUnread()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-virtual {v15}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->getFromAddress()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->contentEquals(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_1

    .line 941
    const/4 v3, 0x1

    .line 945
    :cond_2
    new-instance v5, Landroid/text/SpannableStringBuilder;

    invoke-direct {v5}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 947
    if-eqz v3, :cond_9

    .line 948
    new-instance v6, Landroid/text/SpannableStringBuilder;

    invoke-direct {v6}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 950
    const v3, 0x7f0a0040

    move-object/from16 v0, v18

    invoke-virtual {v0, v3}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v7

    .line 952
    invoke-virtual/range {p2 .. p2}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getFromSnippetInstructions()Ljava/lang/String;

    move-result-object v4

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    const/4 v12, 0x1

    move-object/from16 v3, p0

    invoke-static/range {v3 .. v12}, Lcom/google/android/gm/Utils;->getStyledSenderSnippet(Landroid/content/Context;Ljava/lang/String;Landroid/text/SpannableStringBuilder;Landroid/text/SpannableStringBuilder;IZZZZZ)V

    .line 961
    :goto_4
    invoke-virtual {v5}, Landroid/text/SpannableStringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual/range {p2 .. p2}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getSubject()Ljava/lang/String;

    move-result-object v4

    invoke-virtual/range {p2 .. p2}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getSnippet()Ljava/lang/String;

    move-result-object v5

    move-object/from16 v0, p0

    invoke-static {v0, v3, v4, v5}, Lcom/google/android/gm/Utils;->getSingleMessageInboxLine(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/CharSequence;

    move-result-object v3

    .line 965
    move-object/from16 v0, v17

    invoke-virtual {v0, v3}, Landroid/app/Notification$InboxStyle;->addLine(Ljava/lang/CharSequence;)Landroid/app/Notification$InboxStyle;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 966
    add-int/lit8 v3, v14, 0x1

    .line 968
    invoke-virtual {v15}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->close()V

    .line 971
    :goto_5
    move/from16 v0, v20

    if-gt v3, v0, :cond_3

    invoke-virtual/range {p2 .. p2}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->next()Z

    move-result v4

    if-nez v4, :cond_16

    :cond_3
    :goto_6
    move-object/from16 v3, v16

    .line 1080
    :goto_7
    if-eqz v13, :cond_4

    if-eqz v3, :cond_4

    .line 1082
    const v4, 0x7f0c01b0

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object v13, v5, v6

    const/4 v6, 0x1

    aput-object v3, v5, v6

    move-object/from16 v0, v18

    invoke-virtual {v0, v4, v5}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 1086
    :cond_4
    if-eqz v3, :cond_5

    .line 1088
    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Landroid/app/Notification$Builder;->setTicker(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    .line 1092
    :cond_5
    const/4 v3, 0x1

    move/from16 v0, p5

    if-le v0, v3, :cond_6

    .line 1093
    move-object/from16 v0, p1

    move/from16 v1, p5

    invoke-virtual {v0, v1}, Landroid/app/Notification$Builder;->setNumber(I)Landroid/app/Notification$Builder;

    .line 1096
    :cond_6
    move-object/from16 v0, p1

    move-object/from16 v1, p3

    invoke-virtual {v0, v1}, Landroid/app/Notification$Builder;->setContentIntent(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;

    .line 1097
    return-void

    .line 889
    :cond_7
    const/4 v3, 0x0

    move/from16 v17, v3

    goto/16 :goto_0

    .line 892
    :cond_8
    const/4 v13, 0x0

    goto/16 :goto_1

    .line 959
    :cond_9
    :try_start_2
    invoke-virtual {v5, v6}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_4

    .line 968
    :catchall_0
    move-exception v3

    move-object v4, v15

    :goto_8
    invoke-virtual {v4}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->close()V

    throw v3

    .line 974
    :cond_a
    if-eqz v17, :cond_b

    move-object/from16 p4, v13

    :cond_b
    move-object/from16 v0, p1

    move-object/from16 v1, p4

    invoke-virtual {v0, v1}, Landroid/app/Notification$Builder;->setContentText(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    goto :goto_6

    .line 982
    :cond_c
    invoke-static/range {p2 .. p2}, Lcom/google/android/gm/Utils;->seekToLatestUnreadConversation(Lcom/google/android/gm/provider/Gmail$ConversationCursor;)Z

    .line 984
    const/4 v4, 0x0

    .line 985
    const/4 v5, 0x0

    .line 986
    const/4 v6, 0x0

    .line 988
    :try_start_3
    invoke-virtual/range {p2 .. p2}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getAccount()Ljava/lang/String;

    move-result-object v3

    invoke-virtual/range {p2 .. p2}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getConversationId()J

    move-result-wide v7

    move-object/from16 v0, v19

    invoke-virtual {v0, v3, v7, v8}, Lcom/google/android/gm/provider/Gmail;->getDetachedMessageCursorForConversationId(Ljava/lang/String;J)Lcom/google/android/gm/provider/Gmail$MessageCursor;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    move-result-object v14

    .line 993
    :try_start_4
    const-string v3, ""

    .line 994
    invoke-virtual {v14}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->count()I

    move-result v4

    add-int/lit8 v4, v4, -0x1

    invoke-virtual {v14, v4}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->moveTo(I)Z

    move-result v4

    if-eqz v4, :cond_15

    .line 995
    invoke-virtual {v14}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->getFromAddress()Ljava/lang/String;

    move-result-object v3

    .line 996
    invoke-static {v3}, Lcom/google/android/gm/Utils;->getDisplayableSender(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 997
    invoke-static {v3}, Lcom/google/android/gm/Utils;->getSenderAddress(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    move-object/from16 v0, p0

    invoke-static {v0, v6}, Lcom/google/android/gm/Utils;->getContactIcon(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v6

    move-object/from16 v0, p1

    invoke-virtual {v0, v6}, Landroid/app/Notification$Builder;->setLargeIcon(Landroid/graphics/Bitmap;)Landroid/app/Notification$Builder;

    move-object v6, v3

    move-object v3, v4

    .line 1002
    :goto_9
    invoke-virtual {v14}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->position()I

    move-result v4

    move v15, v4

    move/from16 v16, v5

    .line 1003
    :cond_d
    :goto_a
    invoke-virtual {v14}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->position()I

    move-result v4

    add-int/lit8 v4, v4, -0x1

    invoke-virtual {v14, v4}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->moveTo(I)Z

    move-result v4

    if-eqz v4, :cond_e

    .line 1004
    invoke-virtual {v14}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->getIsUnread()Z

    move-result v4

    if-eqz v4, :cond_d

    .line 1005
    invoke-virtual {v14}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->position()I

    move-result v4

    .line 1006
    if-nez v16, :cond_14

    invoke-virtual {v14}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->getFromAddress()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v6, v5}, Ljava/lang/String;->contentEquals(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_14

    .line 1008
    const/4 v5, 0x1

    move v15, v4

    move/from16 v16, v5

    goto :goto_a

    .line 1013
    :cond_e
    invoke-static {}, Lcom/android/mail/utils/Utils;->isRunningJellybeanOrLater()Z

    move-result v4

    if-eqz v4, :cond_12

    .line 1016
    if-eqz v16, :cond_11

    .line 1018
    new-instance v5, Landroid/text/SpannableStringBuilder;

    invoke-direct {v5}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 1019
    new-instance v6, Landroid/text/SpannableStringBuilder;

    invoke-direct {v6}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 1020
    const v3, 0x7f0a0040

    move-object/from16 v0, v18

    invoke-virtual {v0, v3}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v7

    .line 1021
    invoke-virtual/range {p2 .. p2}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getFromSnippetInstructions()Ljava/lang/String;

    move-result-object v4

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    const/4 v12, 0x1

    move-object/from16 v3, p0

    invoke-static/range {v3 .. v12}, Lcom/google/android/gm/Utils;->getStyledSenderSnippet(Landroid/content/Context;Ljava/lang/String;Landroid/text/SpannableStringBuilder;Landroid/text/SpannableStringBuilder;IZZZZZ)V

    .line 1027
    move-object/from16 v0, p1

    invoke-virtual {v0, v5}, Landroid/app/Notification$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    .line 1029
    invoke-virtual {v5}, Landroid/text/SpannableStringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 1038
    :goto_b
    invoke-virtual/range {p2 .. p2}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getSubject()Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, p0

    invoke-static {v0, v4}, Lcom/google/android/gm/Utils;->getSingleMessageLittleText(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/CharSequence;

    move-result-object v4

    move-object/from16 v0, p1

    invoke-virtual {v0, v4}, Landroid/app/Notification$Builder;->setContentText(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    .line 1044
    if-eqz v17, :cond_f

    move-object/from16 p4, v13

    :cond_f
    move-object/from16 v0, p1

    move-object/from16 v1, p4

    invoke-virtual {v0, v1}, Landroid/app/Notification$Builder;->setSubText(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    .line 1047
    if-eqz v16, :cond_10

    .line 1048
    const/4 v4, 0x1

    move-object/from16 v0, p0

    invoke-static {v0, v4}, Lcom/google/android/gm/Utils;->getDefaultNotificationIcon(Landroid/content/Context;Z)Landroid/graphics/Bitmap;

    move-result-object v4

    move-object/from16 v0, p1

    invoke-virtual {v0, v4}, Landroid/app/Notification$Builder;->setLargeIcon(Landroid/graphics/Bitmap;)Landroid/app/Notification$Builder;

    .line 1050
    :cond_10
    new-instance v4, Landroid/app/Notification$BigTextStyle;

    move-object/from16 v0, p1

    invoke-direct {v4, v0}, Landroid/app/Notification$BigTextStyle;-><init>(Landroid/app/Notification$Builder;)V

    .line 1053
    invoke-virtual {v14, v15}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->moveTo(I)Z

    .line 1054
    invoke-virtual/range {p2 .. p2}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getSubject()Ljava/lang/String;

    move-result-object v5

    move-object/from16 v0, p0

    invoke-static {v0, v5, v14}, Lcom/google/android/gm/Utils;->getSingleMessageBigText(Landroid/content/Context;Ljava/lang/String;Lcom/google/android/gm/provider/Gmail$MessageCursor;)Ljava/lang/CharSequence;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/app/Notification$BigTextStyle;->bigText(Ljava/lang/CharSequence;)Landroid/app/Notification$BigTextStyle;
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 1074
    :goto_c
    invoke-virtual {v14}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->close()V

    goto/16 :goto_7

    .line 1032
    :cond_11
    :try_start_5
    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Landroid/app/Notification$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    goto :goto_b

    .line 1074
    :catchall_1
    move-exception v3

    move-object v4, v14

    :goto_d
    invoke-virtual {v4}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->close()V

    throw v3

    .line 1061
    :cond_12
    :try_start_6
    invoke-virtual/range {p2 .. p2}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getSubject()Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, p0

    invoke-static {v0, v3, v4}, Lcom/google/android/gm/Utils;->getSingleMessageNotificationTitle(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/CharSequence;

    move-result-object v4

    move-object/from16 v0, p1

    invoke-virtual {v0, v4}, Landroid/app/Notification$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    .line 1067
    if-eqz v17, :cond_13

    move-object/from16 p4, v13

    :cond_13
    move-object/from16 v0, p1

    move-object/from16 v1, p4

    invoke-virtual {v0, v1}, Landroid/app/Notification$Builder;->setContentText(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    goto :goto_c

    .line 1074
    :catchall_2
    move-exception v3

    goto :goto_d

    .line 968
    :catchall_3
    move-exception v3

    goto/16 :goto_8

    :cond_14
    move v15, v4

    goto/16 :goto_a

    :cond_15
    move-object/from16 v21, v3

    move-object v3, v6

    move-object/from16 v6, v21

    goto/16 :goto_9

    :cond_16
    move v14, v3

    goto/16 :goto_2

    :cond_17
    move-object v6, v5

    goto/16 :goto_3

    :cond_18
    move v3, v14

    goto/16 :goto_5
.end method

.method public static containsAccount(Landroid/accounts/Account;[Landroid/accounts/Account;)Z
    .locals 5
    .param p0, "account"    # Landroid/accounts/Account;
    .param p1, "accounts"    # [Landroid/accounts/Account;

    .prologue
    .line 1708
    move-object v0, p1

    .local v0, "arr$":[Landroid/accounts/Account;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_1

    aget-object v1, v0, v2

    .line 1709
    .local v1, "candidateAccount":Landroid/accounts/Account;
    invoke-virtual {p0, v1}, Landroid/accounts/Account;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 1710
    const/4 v4, 0x1

    .line 1713
    .end local v1    # "candidateAccount":Landroid/accounts/Account;
    :goto_1
    return v4

    .line 1708
    .restart local v1    # "candidateAccount":Landroid/accounts/Account;
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 1713
    .end local v1    # "candidateAccount":Landroid/accounts/Account;
    :cond_1
    const/4 v4, 0x0

    goto :goto_1
.end method

.method public static createErrorNotification(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;JII)V
    .locals 7

    .prologue
    .line 2234
    invoke-static {p0}, Lcom/google/android/gm/Utils;->getGmailAccountCount(Landroid/content/Context;)I

    move-result v0

    .line 2235
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, p5, v0}, Landroid/content/res/Resources;->getQuantityString(II)Ljava/lang/String;

    move-result-object v1

    .line 2236
    new-instance v2, Landroid/app/Notification$Builder;

    invoke-direct {v2, p0}, Landroid/app/Notification$Builder;-><init>(Landroid/content/Context;)V

    .line 2237
    const/4 v3, 0x1

    if-le v0, v3, :cond_0

    .line 2242
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p1, v3, v4

    invoke-virtual {v0, p6, v3}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 2243
    new-instance v3, Landroid/text/SpannableString;

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v0, v4, v5

    invoke-static {v1, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 2246
    invoke-virtual {v3}, Landroid/text/SpannableString;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v4

    .line 2247
    new-instance v5, Landroid/text/style/TextAppearanceSpan;

    const v6, 0x7f0d005b

    invoke-direct {v5, p0, v6}, Landroid/text/style/TextAppearanceSpan;-><init>(Landroid/content/Context;I)V

    .line 2249
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    add-int/2addr v0, v4

    const/4 v6, 0x0

    invoke-virtual {v3, v5, v4, v0, v6}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 2251
    invoke-virtual {v2, v3}, Landroid/app/Notification$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    .line 2255
    :goto_0
    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-static {p3, p4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    aput-object v4, v0, v3

    const/4 v3, 0x1

    aput-object p2, v0, v3

    invoke-static {v0}, Lcom/google/common/base/Objects;->hashCode([Ljava/lang/Object;)I

    move-result v3

    .line 2256
    invoke-static {p0, p1, p3, p4}, Lcom/google/android/gm/Utils;->createViewSendErrorIntent(Landroid/content/Context;Ljava/lang/String;J)Landroid/content/Intent;

    move-result-object v4

    .line 2257
    const-string v0, "notification"

    invoke-virtual {p0, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/NotificationManager;

    .line 2259
    const v5, 0x1080078

    invoke-virtual {v2, v5}, Landroid/app/Notification$Builder;->setSmallIcon(I)Landroid/app/Notification$Builder;

    .line 2260
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    invoke-virtual {v2, v5, v6}, Landroid/app/Notification$Builder;->setWhen(J)Landroid/app/Notification$Builder;

    .line 2261
    invoke-virtual {v2, p2}, Landroid/app/Notification$Builder;->setContentText(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    .line 2262
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v6, 0x1080078

    invoke-static {v5, v6}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v5

    invoke-virtual {v2, v5}, Landroid/app/Notification$Builder;->setLargeIcon(Landroid/graphics/Bitmap;)Landroid/app/Notification$Builder;

    .line 2264
    invoke-virtual {v2, v1}, Landroid/app/Notification$Builder;->setTicker(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    .line 2265
    const/4 v1, -0x1

    const/4 v5, 0x0

    invoke-static {p0, v1, v4, v5}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v1

    invoke-virtual {v2, v1}, Landroid/app/Notification$Builder;->setContentIntent(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;

    .line 2266
    invoke-static {p1, v3}, Lcom/google/android/gm/Utils;->updateSendErrorNotificationMap(Ljava/lang/String;I)V

    .line 2267
    invoke-virtual {v2}, Landroid/app/Notification$Builder;->getNotification()Landroid/app/Notification;

    move-result-object v1

    invoke-virtual {v0, v3, v1}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    .line 2268
    return-void

    .line 2253
    :cond_0
    invoke-virtual {v2, v1}, Landroid/app/Notification$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    goto :goto_0
.end method

.method private static createNotificationString(Lcom/google/android/gm/Utils$NotificationMap;)Ljava/lang/String;
    .locals 9
    .param p0, "notifications"    # Lcom/google/android/gm/Utils$NotificationMap;

    .prologue
    .line 303
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    .line 304
    .local v4, "result":Ljava/lang/StringBuilder;
    const/4 v0, 0x0

    .line 305
    .local v0, "i":I
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v3

    .line 306
    .local v3, "keysToRemove":Ljava/util/Set;, "Ljava/util/Set<Lcom/google/android/gm/Utils$NotificationKey;>;"
    invoke-virtual {p0}, Lcom/google/android/gm/Utils$NotificationMap;->keySet()Ljava/util/Set;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gm/Utils$NotificationKey;

    .line 307
    .local v2, "key":Lcom/google/android/gm/Utils$NotificationKey;
    invoke-virtual {p0, v2}, Lcom/google/android/gm/Utils$NotificationMap;->getUnread(Lcom/google/android/gm/Utils$NotificationKey;)Ljava/lang/Integer;

    move-result-object v5

    .line 308
    .local v5, "unread":Ljava/lang/Integer;
    invoke-virtual {p0, v2}, Lcom/google/android/gm/Utils$NotificationMap;->getUnseen(Lcom/google/android/gm/Utils$NotificationKey;)Ljava/lang/Integer;

    move-result-object v6

    .line 309
    .local v6, "unseen":Ljava/lang/Integer;
    if-eqz v5, :cond_0

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v7

    if-nez v7, :cond_1

    .line 310
    :cond_0
    invoke-interface {v3, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 312
    :cond_1
    if-lez v0, :cond_2

    const-string v7, ", "

    invoke-virtual {v4, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 313
    :cond_2
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2}, Lcom/google/android/gm/Utils$NotificationKey;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, " ("

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ", "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ")"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v4, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 314
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 318
    .end local v2    # "key":Lcom/google/android/gm/Utils$NotificationKey;
    .end local v5    # "unread":Ljava/lang/Integer;
    .end local v6    # "unseen":Ljava/lang/Integer;
    :cond_3
    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_4

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gm/Utils$NotificationKey;

    .line 319
    .restart local v2    # "key":Lcom/google/android/gm/Utils$NotificationKey;
    invoke-virtual {p0, v2}, Lcom/google/android/gm/Utils$NotificationMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 322
    .end local v2    # "key":Lcom/google/android/gm/Utils$NotificationKey;
    :cond_4
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    return-object v7
.end method

.method public static createViewConversationIntent(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gm/provider/Gmail$ConversationCursor;)Landroid/content/Intent;
    .locals 6

    .prologue
    .line 1747
    invoke-static {p0, p1}, Lcom/google/android/gm/Utils;->getUiProviderAccount(Landroid/content/Context;Ljava/lang/String;)Lcom/android/mail/providers/Account;

    move-result-object v0

    .line 1750
    invoke-static {p0, p1, p2}, Lcom/google/android/gm/Utils;->getUiProviderAccountFolder(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lcom/android/mail/providers/Folder;

    move-result-object v1

    .line 1752
    if-eqz v1, :cond_0

    if-nez p1, :cond_1

    .line 1753
    :cond_0
    const-string v2, "Gmail"

    const-string v3, "Null account or folder.  account: %s folder: %s"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v0, v4, v5

    const/4 v0, 0x1

    aput-object v1, v4, v0

    invoke-static {v2, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1755
    const/4 v0, 0x0

    .line 1773
    :goto_0
    return-object v0

    .line 1760
    :cond_1
    if-nez p3, :cond_2

    .line 1761
    invoke-static {v1, v0}, Lcom/android/mail/utils/Utils;->createViewFolderIntent(Lcom/android/mail/providers/Folder;Lcom/android/mail/providers/Account;)Landroid/content/Intent;

    move-result-object v0

    goto :goto_0

    .line 1767
    :cond_2
    invoke-static {p0, p1, p3}, Lcom/google/android/gm/provider/UiProvider;->getConversationForConversationCursor(Landroid/content/Context;Ljava/lang/String;Lcom/google/android/gm/provider/Gmail$ConversationCursor;)Lcom/android/mail/providers/Conversation;

    move-result-object v2

    .line 1769
    invoke-static {v2, v1, v0}, Lcom/android/mail/utils/Utils;->createViewConversationIntent(Lcom/android/mail/providers/Conversation;Lcom/android/mail/providers/Folder;Lcom/android/mail/providers/Account;)Landroid/content/Intent;

    move-result-object v0

    goto :goto_0
.end method

.method public static createViewFolderIntent(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "label"    # Ljava/lang/String;

    .prologue
    .line 1780
    invoke-static {p0, p1}, Lcom/google/android/gm/provider/UiProvider;->getAccountObject(Landroid/content/Context;Ljava/lang/String;)Lcom/android/mail/providers/Account;

    move-result-object v0

    .line 1783
    .local v0, "uiAccount":Lcom/android/mail/providers/Account;
    const/4 v2, 0x0

    invoke-static {p0, v2, p1, p2}, Lcom/google/android/gm/provider/UiProvider;->getSparseFolderObject(Landroid/content/Context;Lcom/google/android/gm/provider/MailEngine;Ljava/lang/String;Ljava/lang/String;)Lcom/android/mail/providers/Folder;

    move-result-object v1

    .line 1785
    .local v1, "uiFolder":Lcom/android/mail/providers/Folder;
    invoke-static {v1, v0}, Lcom/android/mail/utils/Utils;->createViewFolderIntent(Lcom/android/mail/providers/Folder;Lcom/android/mail/providers/Account;)Landroid/content/Intent;

    move-result-object v2

    return-object v2
.end method

.method private static createViewSendErrorIntent(Landroid/content/Context;Ljava/lang/String;J)Landroid/content/Intent;
    .locals 2

    .prologue
    .line 2222
    const-string v0, "^f"

    const/4 v1, 0x0

    invoke-static {p0, p1, v0, v1}, Lcom/google/android/gm/Utils;->createViewConversationIntent(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gm/provider/Gmail$ConversationCursor;)Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method

.method public static enableLabelShortcutActivity(Landroid/content/Context;)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 2070
    invoke-static {p0}, Lcom/google/android/gm/Utils;->haveGoogleMailActivitiesBeenEnabled(Landroid/content/Context;)Z

    move-result v0

    .line 2071
    .local v0, "googleMailActivitiesEnabled":Z
    invoke-static {p0, v0}, Lcom/google/android/gm/Utils;->enableLabelShortcutActivity(Landroid/content/Context;Z)V

    .line 2072
    return-void
.end method

.method public static enableLabelShortcutActivity(Landroid/content/Context;Z)V
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "useGoogleMail"    # Z

    .prologue
    const/4 v4, 0x1

    .line 2076
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    .line 2079
    .local v2, "pm":Landroid/content/pm/PackageManager;
    if-eqz p1, :cond_0

    sget-object v1, Lcom/google/android/gm/Utils;->GOOGLE_MAIL_LABEL_SHORTCUT_COMPONENT_NAME:Landroid/content/ComponentName;

    .line 2081
    .local v1, "enabledLabelShortcutComponent":Landroid/content/ComponentName;
    :goto_0
    if-eqz p1, :cond_1

    sget-object v0, Lcom/google/android/gm/Utils;->GMAIL_LABEL_SHORTCUT_COMPONENT_NAME:Landroid/content/ComponentName;

    .line 2083
    .local v0, "disabledLabelShortcutComponent":Landroid/content/ComponentName;
    :goto_1
    const/4 v3, 0x2

    invoke-virtual {v2, v0, v3, v4}, Landroid/content/pm/PackageManager;->setComponentEnabledSetting(Landroid/content/ComponentName;II)V

    .line 2085
    invoke-virtual {v2, v1, v4, v4}, Landroid/content/pm/PackageManager;->setComponentEnabledSetting(Landroid/content/ComponentName;II)V

    .line 2087
    return-void

    .line 2079
    .end local v0    # "disabledLabelShortcutComponent":Landroid/content/ComponentName;
    .end local v1    # "enabledLabelShortcutComponent":Landroid/content/ComponentName;
    :cond_0
    sget-object v1, Lcom/google/android/gm/Utils;->GMAIL_LABEL_SHORTCUT_COMPONENT_NAME:Landroid/content/ComponentName;

    goto :goto_0

    .line 2081
    .restart local v1    # "enabledLabelShortcutComponent":Landroid/content/ComponentName;
    :cond_1
    sget-object v0, Lcom/google/android/gm/Utils;->GOOGLE_MAIL_LABEL_SHORTCUT_COMPONENT_NAME:Landroid/content/ComponentName;

    goto :goto_1
.end method

.method public static enableShortcutIntentFilter(Landroid/content/Context;)V
    .locals 7

    .prologue
    const/4 v1, 0x0

    .line 2030
    invoke-static {}, Lcom/google/android/gm/persistence/Persistence;->getInstance()Lcom/google/android/gm/persistence/Persistence;

    move-result-object v2

    .line 2031
    invoke-virtual {v2, p0}, Lcom/google/android/gm/persistence/Persistence;->getActiveAccount(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    .line 2032
    invoke-static {p0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v0

    const-string v4, "com.google"

    invoke-virtual {v0, v4}, Landroid/accounts/AccountManager;->getAccountsByType(Ljava/lang/String;)[Landroid/accounts/Account;

    move-result-object v4

    .line 2037
    array-length v0, v4

    if-lez v0, :cond_0

    invoke-static {p0}, Lcom/google/android/gm/Utils;->shortcutActivityEnabled(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 2038
    aget-object v0, v4, v1

    iget-object v0, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-static {p0, v0}, Lcom/google/android/gm/Utils;->startShortcutEnablerService(Landroid/content/Context;Ljava/lang/String;)V

    .line 2041
    :cond_0
    array-length v5, v4

    move v0, v1

    :goto_0
    if-ge v0, v5, :cond_3

    aget-object v6, v4, v0

    .line 2042
    iget-object v6, v6, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-virtual {v6, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 2049
    :cond_1
    :goto_1
    return-void

    .line 2041
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 2046
    :cond_3
    array-length v0, v4

    if-lez v0, :cond_1

    .line 2047
    aget-object v0, v4, v1

    iget-object v0, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-virtual {v2, p0, v0}, Lcom/google/android/gm/persistence/Persistence;->setActiveAccount(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_1
.end method

.method private static findContacts(Landroid/content/Context;Ljava/util/Collection;)Ljava/util/ArrayList;
    .locals 11
    .param p0, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation

    .prologue
    .local p1, "addresses":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    const/4 v4, 0x0

    .line 775
    new-instance v9, Ljava/util/ArrayList;

    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    .line 776
    .local v9, "whereArgs":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    .line 777
    .local v10, "whereBuilder":Ljava/lang/StringBuilder;
    invoke-interface {p1}, Ljava/util/Collection;->size()I

    move-result v1

    new-array v8, v1, [Ljava/lang/String;

    .line 779
    .local v8, "questionMarks":[Ljava/lang/String;
    invoke-virtual {v9, p1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 780
    const-string v1, "?"

    invoke-static {v8, v1}, Ljava/util/Arrays;->fill([Ljava/lang/Object;Ljava/lang/Object;)V

    .line 781
    const-string v1, "data1 IN ("

    invoke-virtual {v10, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ","

    invoke-static {v2, v8}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 785
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    .line 786
    .local v0, "resolver":Landroid/content/ContentResolver;
    sget-object v1, Landroid/provider/ContactsContract$CommonDataKinds$Email;->CONTENT_URI:Landroid/net/Uri;

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const-string v3, "contact_id"

    aput-object v3, v2, v4

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    new-array v4, v4, [Ljava/lang/String;

    invoke-virtual {v9, v4}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v4

    check-cast v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 790
    .local v6, "c":Landroid/database/Cursor;
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    .line 791
    .local v7, "contactIds":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Long;>;"
    if-nez v6, :cond_0

    .line 801
    :goto_0
    return-object v7

    .line 795
    :cond_0
    :goto_1
    :try_start_0
    invoke-interface {v6}, Landroid/database/Cursor;->moveToNext()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 796
    const/4 v1, 0x0

    invoke-interface {v6, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v1

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v7, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_1

    .line 799
    :catchall_0
    move-exception v1

    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    throw v1

    :cond_1
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    goto :goto_0
.end method

.method public static varargs format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    .locals 2
    .param p0, "formatString"    # Ljava/lang/String;
    .param p1, "args"    # [Ljava/lang/Object;

    .prologue
    .line 1585
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 1586
    .local v0, "result":Ljava/lang/StringBuffer;
    invoke-static {v0, p0, p1}, Lcom/google/android/gm/Utils;->format(Ljava/lang/StringBuffer;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 1587
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public static varargs format(Ljava/lang/StringBuffer;Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 7
    .param p0, "result"    # Ljava/lang/StringBuffer;
    .param p1, "formatString"    # Ljava/lang/String;
    .param p2, "args"    # [Ljava/lang/Object;

    .prologue
    .line 1591
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v4

    .line 1595
    .local v4, "length":I
    const/4 v2, 0x0

    .line 1597
    .local v2, "current":I
    const/4 v0, 0x0

    .line 1598
    .local v0, "argIndex":I
    move v3, v2

    .local v3, "i":I
    move v1, v0

    .end local v0    # "argIndex":I
    .local v1, "argIndex":I
    :goto_0
    if-ge v3, v4, :cond_2

    .line 1599
    invoke-virtual {p1, v3}, Ljava/lang/String;->charAt(I)C

    move-result v5

    const/16 v6, 0x25

    if-eq v5, v6, :cond_0

    move v0, v1

    .line 1598
    .end local v1    # "argIndex":I
    .restart local v0    # "argIndex":I
    :goto_1
    add-int/lit8 v3, v3, 0x1

    move v1, v0

    .end local v0    # "argIndex":I
    .restart local v1    # "argIndex":I
    goto :goto_0

    .line 1600
    :cond_0
    add-int/lit8 v5, v4, -0x1

    if-ge v3, v5, :cond_4

    .line 1601
    add-int/lit8 v5, v3, 0x1

    invoke-virtual {p1, v5}, Ljava/lang/String;->charAt(I)C

    move-result v5

    const/16 v6, 0x73

    if-eq v5, v6, :cond_1

    move v0, v1

    .end local v1    # "argIndex":I
    .restart local v0    # "argIndex":I
    goto :goto_1

    .line 1603
    .end local v0    # "argIndex":I
    .restart local v1    # "argIndex":I
    :cond_1
    invoke-virtual {p1, v2, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p0, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 1604
    add-int/lit8 v0, v1, 0x1

    .end local v1    # "argIndex":I
    .restart local v0    # "argIndex":I
    aget-object v5, p2, v1

    invoke-virtual {p0, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    .line 1606
    add-int/lit8 v2, v3, 0x2

    .line 1608
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 1612
    .end local v0    # "argIndex":I
    .restart local v1    # "argIndex":I
    :cond_2
    if-ge v2, v4, :cond_3

    invoke-virtual {p1, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p0, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 1613
    :cond_3
    return-void

    :cond_4
    move v0, v1

    .end local v1    # "argIndex":I
    .restart local v0    # "argIndex":I
    goto :goto_1
.end method

.method public static formatPlural(Landroid/content/Context;II)Ljava/lang/String;
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "resource"    # I
    .param p2, "count"    # I

    .prologue
    .line 1621
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, p1, p2}, Landroid/content/res/Resources;->getQuantityText(II)Ljava/lang/CharSequence;

    move-result-object v0

    .line 1622
    .local v0, "formatString":Ljava/lang/CharSequence;
    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method private static getContactIcon(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Bitmap;
    .locals 18
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "senderAddress"    # Ljava/lang/String;

    .prologue
    .line 805
    if-nez p1, :cond_1

    .line 806
    const/4 v12, 0x0

    .line 852
    :cond_0
    :goto_0
    return-object v12

    .line 808
    :cond_1
    const/4 v12, 0x0

    .line 809
    .local v12, "icon":Landroid/graphics/Bitmap;
    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v3, 0x0

    aput-object p1, v1, v3

    invoke-static {v1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    move-object/from16 v0, p0

    invoke-static {v0, v1}, Lcom/google/android/gm/Utils;->findContacts(Landroid/content/Context;Ljava/util/Collection;)Ljava/util/ArrayList;

    move-result-object v7

    .line 812
    .local v7, "contactIds":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Long;>;"
    if-eqz v7, :cond_4

    .line 814
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v17

    .line 815
    .local v17, "res":Landroid/content/res/Resources;
    const v1, 0x1050006

    move-object/from16 v0, v17

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v15

    .line 817
    .local v15, "idealIconHeight":I
    const v1, 0x1050005

    move-object/from16 v0, v17

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v16

    .line 819
    .local v16, "idealIconWidth":I
    invoke-virtual {v7}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v11

    .local v11, "i$":Ljava/util/Iterator;
    :cond_2
    :goto_1
    invoke-interface {v11}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_4

    invoke-interface {v11}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Long;

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v13

    .line 820
    .local v13, "id":J
    sget-object v1, Landroid/provider/ContactsContract$Contacts;->CONTENT_URI:Landroid/net/Uri;

    invoke-static {v1, v13, v14}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v8

    .line 822
    .local v8, "contactUri":Landroid/net/Uri;
    const-string v1, "photo"

    invoke-static {v8, v1}, Landroid/net/Uri;->withAppendedPath(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    .line 823
    .local v2, "photoUri":Landroid/net/Uri;
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string v5, "data15"

    aput-object v5, v3, v4

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    invoke-virtual/range {v1 .. v6}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v9

    .line 826
    .local v9, "cursor":Landroid/database/Cursor;
    if-eqz v9, :cond_2

    .line 828
    :try_start_0
    invoke-interface {v9}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_5

    .line 829
    const/4 v1, 0x0

    invoke-interface {v9, v1}, Landroid/database/Cursor;->getBlob(I)[B

    move-result-object v10

    .line 830
    .local v10, "data":[B
    if-eqz v10, :cond_5

    .line 831
    new-instance v1, Ljava/io/ByteArrayInputStream;

    invoke-direct {v1, v10}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    invoke-static {v1}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;)Landroid/graphics/Bitmap;

    move-result-object v12

    .line 832
    if-eqz v12, :cond_3

    invoke-virtual {v12}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v1

    if-ge v1, v15, :cond_3

    .line 834
    const/4 v1, 0x1

    move/from16 v0, v16

    invoke-static {v12, v0, v15, v1}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v12

    .line 837
    :cond_3
    if-eqz v12, :cond_5

    .line 843
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    .line 848
    .end local v2    # "photoUri":Landroid/net/Uri;
    .end local v8    # "contactUri":Landroid/net/Uri;
    .end local v9    # "cursor":Landroid/database/Cursor;
    .end local v10    # "data":[B
    .end local v11    # "i$":Ljava/util/Iterator;
    .end local v13    # "id":J
    .end local v15    # "idealIconHeight":I
    .end local v16    # "idealIconWidth":I
    .end local v17    # "res":Landroid/content/res/Resources;
    :cond_4
    if-nez v12, :cond_0

    .line 850
    const/4 v1, 0x0

    move-object/from16 v0, p0

    invoke-static {v0, v1}, Lcom/google/android/gm/Utils;->getDefaultNotificationIcon(Landroid/content/Context;Z)Landroid/graphics/Bitmap;

    move-result-object v12

    goto/16 :goto_0

    .line 843
    .restart local v2    # "photoUri":Landroid/net/Uri;
    .restart local v8    # "contactUri":Landroid/net/Uri;
    .restart local v9    # "cursor":Landroid/database/Cursor;
    .restart local v11    # "i$":Ljava/util/Iterator;
    .restart local v13    # "id":J
    .restart local v15    # "idealIconHeight":I
    .restart local v16    # "idealIconWidth":I
    .restart local v17    # "res":Landroid/content/res/Resources;
    :cond_5
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    goto :goto_1

    :catchall_0
    move-exception v1

    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    throw v1
.end method

.method private static getDefaultNotificationIcon(Landroid/content/Context;Z)Landroid/graphics/Bitmap;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "multipleNew"    # Z

    .prologue
    .line 857
    if-eqz p1, :cond_1

    .line 858
    sget-object v1, Lcom/google/android/gm/Utils;->sMultipleNotifIcon:Landroid/graphics/Bitmap;

    if-nez v1, :cond_0

    .line 859
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f020064

    invoke-static {v1, v2}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v1

    sput-object v1, Lcom/google/android/gm/Utils;->sMultipleNotifIcon:Landroid/graphics/Bitmap;

    .line 862
    :cond_0
    sget-object v0, Lcom/google/android/gm/Utils;->sMultipleNotifIcon:Landroid/graphics/Bitmap;

    .line 870
    .local v0, "icon":Landroid/graphics/Bitmap;
    :goto_0
    return-object v0

    .line 864
    .end local v0    # "icon":Landroid/graphics/Bitmap;
    :cond_1
    sget-object v1, Lcom/google/android/gm/Utils;->sDefaultSingleNotifIcon:Landroid/graphics/Bitmap;

    if-nez v1, :cond_2

    .line 865
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f020040

    invoke-static {v1, v2}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v1

    sput-object v1, Lcom/google/android/gm/Utils;->sDefaultSingleNotifIcon:Landroid/graphics/Bitmap;

    .line 868
    :cond_2
    sget-object v0, Lcom/google/android/gm/Utils;->sDefaultSingleNotifIcon:Landroid/graphics/Bitmap;

    .restart local v0    # "icon":Landroid/graphics/Bitmap;
    goto :goto_0
.end method

.method private static getDisplayableSender(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "sender"    # Ljava/lang/String;

    .prologue
    .line 1384
    invoke-static {p0}, Lcom/google/android/gm/EmailAddress;->getEmailAddress(Ljava/lang/String;)Lcom/google/android/gm/EmailAddress;

    move-result-object v0

    .line 1386
    .local v0, "address":Lcom/google/android/gm/EmailAddress;
    invoke-virtual {v0}, Lcom/google/android/gm/EmailAddress;->getName()Ljava/lang/String;

    move-result-object v1

    .line 1388
    .local v1, "displayableSender":Ljava/lang/String;
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1389
    invoke-virtual {v0}, Lcom/google/android/gm/EmailAddress;->getAddress()Ljava/lang/String;

    move-result-object v1

    .line 1393
    :cond_0
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 1394
    move-object v1, p0

    .line 1396
    :cond_1
    return-object v1
.end method

.method private static getGmailAccountCount(Landroid/content/Context;)I
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v1, 0x1

    .line 1430
    invoke-static {}, Lcom/google/android/gm/persistence/Persistence;->getInstance()Lcom/google/android/gm/persistence/Persistence;

    move-result-object v2

    invoke-virtual {v2, p0, v1}, Lcom/google/android/gm/persistence/Persistence;->getCachedConfiguredGoogleAccounts(Landroid/content/Context;Z)Ljava/util/List;

    move-result-object v0

    .line 1433
    .local v0, "accounts":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    :cond_0
    return v1
.end method

.method public static getLabelDisplayCount(Lcom/google/android/gm/provider/Label;)I
    .locals 2
    .param p0, "label"    # Lcom/google/android/gm/provider/Label;

    .prologue
    .line 2322
    const/4 v0, 0x0

    .line 2323
    .local v0, "count":I
    invoke-virtual {p0}, Lcom/google/android/gm/provider/Label;->getDisplayNoConversationCount()Z

    move-result v1

    if-nez v1, :cond_0

    .line 2324
    invoke-virtual {p0}, Lcom/google/android/gm/provider/Label;->getDisplayTotalConversationCount()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 2325
    invoke-virtual {p0}, Lcom/google/android/gm/provider/Label;->getNumConversations()I

    move-result v0

    .line 2330
    :cond_0
    :goto_0
    return v0

    .line 2327
    :cond_1
    invoke-virtual {p0}, Lcom/google/android/gm/provider/Label;->getNumUnreadConversations()I

    move-result v0

    goto :goto_0
.end method

.method public static getLabelNotificationSummary(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 3

    .prologue
    .line 1631
    invoke-static {}, Lcom/google/android/gm/persistence/Persistence;->getInstance()Lcom/google/android/gm/persistence/Persistence;

    move-result-object v0

    .line 1632
    invoke-virtual {v0, p0, p1, p2}, Lcom/google/android/gm/persistence/Persistence;->shouldNotifyForLabel(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    .line 1634
    if-nez v1, :cond_0

    .line 1635
    const/4 v0, 0x0

    .line 1670
    :goto_0
    return-object v0

    .line 1638
    :cond_0
    invoke-virtual {v0, p0, p1, p2}, Lcom/google/android/gm/persistence/Persistence;->shouldVibrateForLabel(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    .line 1640
    invoke-virtual {v0, p0, p1, p2}, Lcom/google/android/gm/persistence/Persistence;->shouldNotifyOnceForLabel(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v2

    .line 1643
    invoke-virtual {v0, p0, p1, p2}, Lcom/google/android/gm/persistence/Persistence;->getNotificationRingtoneUriForLabel(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    if-eqz v0, :cond_1

    const/4 v0, 0x1

    .line 1647
    :goto_1
    if-eqz v0, :cond_5

    .line 1648
    if-eqz v1, :cond_2

    if-eqz v2, :cond_2

    .line 1649
    const v0, 0x7f0c01a8

    .line 1670
    :goto_2
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1643
    :cond_1
    const/4 v0, 0x0

    goto :goto_1

    .line 1650
    :cond_2
    if-eqz v1, :cond_3

    .line 1651
    const v0, 0x7f0c01a9

    goto :goto_2

    .line 1652
    :cond_3
    if-eqz v2, :cond_4

    .line 1653
    const v0, 0x7f0c01aa

    goto :goto_2

    .line 1655
    :cond_4
    const v0, 0x7f0c01ab

    goto :goto_2

    .line 1658
    :cond_5
    if-eqz v1, :cond_6

    if-eqz v2, :cond_6

    .line 1659
    const v0, 0x7f0c01ac

    goto :goto_2

    .line 1661
    :cond_6
    if-eqz v1, :cond_7

    .line 1662
    const v0, 0x7f0c01ad

    goto :goto_2

    .line 1663
    :cond_7
    if-eqz v2, :cond_8

    .line 1664
    const v0, 0x7f0c01ae

    goto :goto_2

    .line 1666
    :cond_8
    const v0, 0x7f0c01af

    goto :goto_2
.end method

.method private static getMessageBodyWithoutElidedText(Lcom/google/android/gm/provider/Gmail$MessageCursor;)Ljava/lang/String;
    .locals 1
    .param p0, "messageCursor"    # Lcom/google/android/gm/provider/Gmail$MessageCursor;

    .prologue
    .line 1217
    invoke-virtual {p0}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->getBody()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gm/Utils;->getMessageBodyWithoutElidedText(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getMessageBodyWithoutElidedText(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "html"    # Ljava/lang/String;

    .prologue
    .line 1222
    invoke-static {p0}, Lcom/android/mail/utils/Utils;->getHtmlTree(Ljava/lang/String;)Lcom/google/android/common/html/parser/HtmlTree;

    move-result-object v0

    .line 1223
    .local v0, "htmlTree":Lcom/google/android/common/html/parser/HtmlTree;
    sget-object v1, Lcom/google/android/gm/Utils;->GMAIL_MESSAGE_CONVERTER_FACTORY:Lcom/google/android/common/html/parser/HtmlTree$PlainTextConverterFactory;

    invoke-virtual {v0, v1}, Lcom/google/android/common/html/parser/HtmlTree;->setPlainTextConverterFactory(Lcom/google/android/common/html/parser/HtmlTree$PlainTextConverterFactory;)V

    .line 1225
    invoke-virtual {v0}, Lcom/google/android/common/html/parser/HtmlTree;->getPlainText()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method private static getNotificationId(Ljava/lang/String;Ljava/lang/String;)I
    .locals 2
    .param p0, "account"    # Ljava/lang/String;
    .param p1, "label"    # Ljava/lang/String;

    .prologue
    .line 541
    invoke-virtual {p0}, Ljava/lang/String;->hashCode()I

    move-result v0

    xor-int/lit8 v0, v0, 0x1

    invoke-virtual {p1}, Ljava/lang/String;->hashCode()I

    move-result v1

    xor-int/2addr v0, v1

    return v0
.end method

.method private static declared-synchronized getNotificationMap(Landroid/content/Context;)Lcom/google/android/gm/Utils$NotificationMap;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 332
    const-class v1, Lcom/google/android/gm/Utils;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/google/android/gm/Utils;->sActiveNotificationMap:Lcom/google/android/gm/Utils$NotificationMap;

    if-nez v0, :cond_0

    .line 333
    new-instance v0, Lcom/google/android/gm/Utils$NotificationMap;

    const/4 v2, 0x0

    invoke-direct {v0, v2}, Lcom/google/android/gm/Utils$NotificationMap;-><init>(Lcom/google/android/gm/Utils$1;)V

    sput-object v0, Lcom/google/android/gm/Utils;->sActiveNotificationMap:Lcom/google/android/gm/Utils$NotificationMap;

    .line 336
    sget-object v0, Lcom/google/android/gm/Utils;->sActiveNotificationMap:Lcom/google/android/gm/Utils$NotificationMap;

    invoke-virtual {v0, p0}, Lcom/google/android/gm/Utils$NotificationMap;->loadNotificationMap(Landroid/content/Context;)V

    .line 338
    :cond_0
    sget-object v0, Lcom/google/android/gm/Utils;->sActiveNotificationMap:Lcom/google/android/gm/Utils$NotificationMap;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 332
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private static getSenderAddress(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "sender"    # Ljava/lang/String;

    .prologue
    .line 1404
    invoke-static {p0}, Lcom/google/android/gm/EmailAddress;->getEmailAddress(Ljava/lang/String;)Lcom/google/android/gm/EmailAddress;

    move-result-object v0

    .line 1406
    .local v0, "address":Lcom/google/android/gm/EmailAddress;
    invoke-virtual {v0}, Lcom/google/android/gm/EmailAddress;->getAddress()Ljava/lang/String;

    move-result-object v1

    .line 1410
    .local v1, "tokenizedAddress":Ljava/lang/String;
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1411
    move-object v1, p0

    .line 1413
    :cond_0
    return-object v1
.end method

.method private static getSingleMessageBigText(Landroid/content/Context;Ljava/lang/String;Lcom/google/android/gm/provider/Gmail$MessageCursor;)Ljava/lang/CharSequence;
    .locals 7

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 1177
    new-instance v4, Landroid/text/style/TextAppearanceSpan;

    const v0, 0x7f0d0044

    invoke-direct {v4, p0, v0}, Landroid/text/style/TextAppearanceSpan;-><init>(Landroid/content/Context;I)V

    .line 1180
    invoke-static {p2}, Lcom/google/android/gm/Utils;->getMessageBodyWithoutElidedText(Lcom/google/android/gm/provider/Gmail$MessageCursor;)Ljava/lang/String;

    move-result-object v1

    .line 1183
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "\\n\\s+"

    const-string v5, "\n"

    invoke-virtual {v1, v0, v5}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1186
    :goto_0
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_1

    move-object v0, v1

    .line 1212
    :goto_1
    return-object v0

    .line 1183
    :cond_0
    const-string v0, ""

    goto :goto_0

    .line 1189
    :cond_1
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 1191
    new-instance v0, Landroid/text/SpannableString;

    invoke-direct {v0, p1}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 1192
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    invoke-virtual {v0, v4, v3, v1, v3}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    goto :goto_1

    .line 1196
    :cond_2
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v5, 0x7f0c00f2

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 1201
    const-string v1, "%2$s"

    invoke-virtual {v5, v1}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    const-string v6, "%1$s"

    invoke-virtual {v5, v6}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v6

    if-le v1, v6, :cond_3

    move v1, v2

    .line 1203
    :goto_2
    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    aput-object p1, v6, v3

    aput-object v0, v6, v2

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 1205
    new-instance v2, Landroid/text/SpannableString;

    invoke-direct {v2, v0}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 1207
    if-eqz v1, :cond_4

    invoke-virtual {v0, p1}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    .line 1209
    :goto_3
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    add-int/2addr v1, v0

    invoke-virtual {v2, v4, v0, v1, v3}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    move-object v0, v2

    .line 1212
    goto :goto_1

    :cond_3
    move v1, v3

    .line 1201
    goto :goto_2

    .line 1207
    :cond_4
    invoke-virtual {v0, p1}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v0

    goto :goto_3
.end method

.method private static getSingleMessageInboxLine(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/CharSequence;
    .locals 9

    .prologue
    const/4 v0, 0x1

    const/4 v4, 0x0

    .line 1111
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 1113
    :goto_0
    new-instance v5, Landroid/text/style/TextAppearanceSpan;

    const v1, 0x7f0d0044

    invoke-direct {v5, p0, v1}, Landroid/text/style/TextAppearanceSpan;-><init>(Landroid/content/Context;I)V

    .line 1116
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 1147
    :goto_1
    return-object p2

    :cond_0
    move-object p2, p3

    .line 1111
    goto :goto_0

    .line 1119
    :cond_1
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 1121
    new-instance p2, Landroid/text/SpannableString;

    invoke-direct {p2, p1}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 1122
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    invoke-virtual {p2, v5, v4, v0, v4}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    goto :goto_1

    .line 1126
    :cond_2
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0c00f1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 1128
    new-instance v6, Landroid/text/style/TextAppearanceSpan;

    const v1, 0x7f0d0045

    invoke-direct {v6, p0, v1}, Landroid/text/style/TextAppearanceSpan;-><init>(Landroid/content/Context;I)V

    .line 1131
    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    aput-object p1, v1, v4

    aput-object p2, v1, v0

    invoke-static {v2, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    .line 1133
    new-instance v1, Landroid/text/SpannableString;

    invoke-direct {v1, v7}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 1135
    const-string v3, "%2$s"

    invoke-virtual {v2, v3}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v3

    const-string v8, "%1$s"

    invoke-virtual {v2, v8}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v2

    if-ge v3, v2, :cond_3

    move v3, v0

    .line 1137
    :goto_2
    if-eqz v3, :cond_4

    invoke-virtual {v7, p1}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v0

    move v2, v0

    .line 1140
    :goto_3
    if-eqz v3, :cond_5

    invoke-virtual {v7, p2}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v0

    .line 1143
    :goto_4
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v3, v2

    invoke-virtual {v1, v5, v2, v3, v4}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 1145
    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v2

    add-int/2addr v2, v0

    invoke-virtual {v1, v6, v0, v2, v4}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    move-object p2, v1

    .line 1147
    goto :goto_1

    :cond_3
    move v3, v4

    .line 1135
    goto :goto_2

    .line 1137
    :cond_4
    invoke-virtual {v7, p1}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    move v2, v0

    goto :goto_3

    .line 1140
    :cond_5
    invoke-virtual {v7, p2}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    goto :goto_4
.end method

.method private static getSingleMessageLittleText(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/CharSequence;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 1158
    new-instance v0, Landroid/text/style/TextAppearanceSpan;

    const v1, 0x7f0d0044

    invoke-direct {v0, p0, v1}, Landroid/text/style/TextAppearanceSpan;-><init>(Landroid/content/Context;I)V

    .line 1161
    new-instance v1, Landroid/text/SpannableString;

    invoke-direct {v1, p1}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 1162
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v2

    invoke-virtual {v1, v0, v3, v2, v3}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 1164
    return-object v1
.end method

.method private static getSingleMessageNotificationTitle(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/CharSequence;
    .locals 5

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 1238
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1261
    :goto_0
    return-object p1

    .line 1242
    :cond_0
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v3, 0x7f0c01d9

    invoke-virtual {v0, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 1247
    const-string v0, "%2$s"

    invoke-virtual {v3, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    const-string v4, "%1$s"

    invoke-virtual {v3, v4}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v4

    if-le v0, v4, :cond_1

    move v0, v1

    .line 1249
    :goto_1
    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    aput-object p1, v4, v2

    aput-object p2, v4, v1

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 1252
    new-instance p1, Landroid/text/SpannableString;

    invoke-direct {p1, v1}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 1255
    if-eqz v0, :cond_2

    invoke-virtual {v1, p2}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v0

    .line 1257
    :goto_2
    new-instance v1, Landroid/text/style/TextAppearanceSpan;

    const v3, 0x7f0d0045

    invoke-direct {v1, p0, v3}, Landroid/text/style/TextAppearanceSpan;-><init>(Landroid/content/Context;I)V

    .line 1259
    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v3, v0

    invoke-virtual {p1, v1, v0, v3, v2}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    goto :goto_0

    :cond_1
    move v0, v2

    .line 1247
    goto :goto_1

    .line 1255
    :cond_2
    invoke-virtual {v1, p2}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    goto :goto_2
.end method

.method public static getStyledSenderSnippet(Landroid/content/Context;Ljava/lang/String;Landroid/text/SpannableStringBuilder;Landroid/text/SpannableStringBuilder;IZZZZZ)V
    .locals 18

    .prologue
    .line 1500
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    .line 1501
    sget-object v2, Lcom/google/android/gm/Utils;->sUnreadStyleSpan:Landroid/text/style/CharacterStyle;

    if-nez v2, :cond_0

    .line 1502
    new-instance v2, Landroid/text/style/StyleSpan;

    const/4 v3, 0x1

    invoke-direct {v2, v3}, Landroid/text/style/StyleSpan;-><init>(I)V

    sput-object v2, Lcom/google/android/gm/Utils;->sUnreadStyleSpan:Landroid/text/style/CharacterStyle;

    .line 1503
    new-instance v2, Landroid/text/style/StyleSpan;

    const/4 v3, 0x0

    invoke-direct {v2, v3}, Landroid/text/style/StyleSpan;-><init>(I)V

    sput-object v2, Lcom/google/android/gm/Utils;->sReadStyleSpan:Landroid/text/style/CharacterStyle;

    .line 1504
    new-instance v2, Landroid/text/style/ForegroundColorSpan;

    const v3, 0x7f090011

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-direct {v2, v3}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    sput-object v2, Lcom/google/android/gm/Utils;->sDraftsStyleSpan:Landroid/text/style/CharacterStyle;

    .line 1506
    const v2, 0x7f0c009b

    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Landroid/content/Context;->getText(I)Ljava/lang/CharSequence;

    move-result-object v2

    sput-object v2, Lcom/google/android/gm/Utils;->sMeString:Ljava/lang/CharSequence;

    .line 1507
    const v2, 0x7f110002

    const/4 v3, 0x1

    invoke-virtual {v1, v2, v3}, Landroid/content/res/Resources;->getQuantityText(II)Ljava/lang/CharSequence;

    move-result-object v2

    sput-object v2, Lcom/google/android/gm/Utils;->sDraftSingularString:Ljava/lang/CharSequence;

    .line 1508
    const v2, 0x7f110002

    const/4 v3, 0x2

    invoke-virtual {v1, v2, v3}, Landroid/content/res/Resources;->getQuantityText(II)Ljava/lang/CharSequence;

    move-result-object v1

    sput-object v1, Lcom/google/android/gm/Utils;->sDraftPluralString:Ljava/lang/CharSequence;

    .line 1509
    new-instance v1, Landroid/text/SpannableString;

    const v2, 0x7f0c0099

    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Landroid/content/Context;->getText(I)Ljava/lang/CharSequence;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 1510
    sget-object v2, Lcom/google/android/gm/Utils;->sDraftsStyleSpan:Landroid/text/style/CharacterStyle;

    invoke-static {v2}, Landroid/text/style/CharacterStyle;->wrap(Landroid/text/style/CharacterStyle;)Landroid/text/style/CharacterStyle;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v1}, Landroid/text/SpannableString;->length()I

    move-result v4

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 1512
    sput-object v1, Lcom/google/android/gm/Utils;->sSendingString:Ljava/lang/CharSequence;

    .line 1513
    const v1, 0x7f0c009a

    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Landroid/content/Context;->getText(I)Ljava/lang/CharSequence;

    move-result-object v1

    sput-object v1, Lcom/google/android/gm/Utils;->sSendFailedString:Ljava/lang/CharSequence;

    .line 1516
    :cond_0
    sget-object v5, Lcom/google/android/gm/Utils;->sUnreadStyleSpan:Landroid/text/style/CharacterStyle;

    sget-object v6, Lcom/google/android/gm/Utils;->sReadStyleSpan:Landroid/text/style/CharacterStyle;

    sget-object v7, Lcom/google/android/gm/Utils;->sDraftsStyleSpan:Landroid/text/style/CharacterStyle;

    sget-object v8, Lcom/google/android/gm/Utils;->sMeString:Ljava/lang/CharSequence;

    sget-object v9, Lcom/google/android/gm/Utils;->sDraftSingularString:Ljava/lang/CharSequence;

    sget-object v10, Lcom/google/android/gm/Utils;->sDraftPluralString:Ljava/lang/CharSequence;

    sget-object v11, Lcom/google/android/gm/Utils;->sSendingString:Ljava/lang/CharSequence;

    sget-object v12, Lcom/google/android/gm/Utils;->sSendFailedString:Ljava/lang/CharSequence;

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    move-object/from16 v3, p3

    move/from16 v4, p4

    move/from16 v13, p5

    move/from16 v14, p6

    move/from16 v15, p7

    move/from16 v16, p8

    move/from16 v17, p9

    invoke-static/range {v1 .. v17}, Lcom/google/android/gm/provider/Gmail;->getSenderSnippet(Ljava/lang/String;Landroid/text/SpannableStringBuilder;Landroid/text/SpannableStringBuilder;ILandroid/text/style/CharacterStyle;Landroid/text/style/CharacterStyle;Landroid/text/style/CharacterStyle;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZZZZ)V

    .line 1526
    return-void
.end method

.method private static getUiProviderAccount(Landroid/content/Context;Ljava/lang/String;)Lcom/android/mail/providers/Account;
    .locals 11
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "accountName"    # Ljava/lang/String;

    .prologue
    .line 1790
    const/4 v8, 0x0

    .line 1792
    .local v8, "result":Lcom/android/mail/providers/Account;
    sget-object v10, Lcom/google/android/gm/Utils;->UI_ACCOUNT_MAP:Ljava/util/Map;

    monitor-enter v10

    .line 1793
    :try_start_0
    sget-object v1, Lcom/google/android/gm/Utils;->UI_ACCOUNT_MAP:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    move-object v0, v1

    check-cast v0, Lcom/android/mail/providers/Account;

    move-object v8, v0

    .line 1795
    if-nez v8, :cond_1

    .line 1796
    invoke-static {p1}, Lcom/google/android/gm/provider/UiProvider;->getAccountUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    .line 1798
    .local v2, "accountUri":Landroid/net/Uri;
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    sget-object v3, Lcom/android/mail/providers/UIProvider;->ACCOUNTS_PROJECTION:[Ljava/lang/String;

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    invoke-virtual/range {v1 .. v6}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v7

    .line 1801
    .local v7, "accountCursor":Landroid/database/Cursor;
    :try_start_1
    invoke-interface {v7}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1802
    new-instance v9, Lcom/android/mail/providers/Account;

    invoke-direct {v9, v7}, Lcom/android/mail/providers/Account;-><init>(Landroid/database/Cursor;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1803
    .end local v8    # "result":Lcom/android/mail/providers/Account;
    .local v9, "result":Lcom/android/mail/providers/Account;
    :try_start_2
    sget-object v1, Lcom/google/android/gm/Utils;->UI_ACCOUNT_MAP:Ljava/util/Map;

    invoke-interface {v1, p1, v9}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    move-object v8, v9

    .line 1806
    .end local v9    # "result":Lcom/android/mail/providers/Account;
    .restart local v8    # "result":Lcom/android/mail/providers/Account;
    :cond_0
    :try_start_3
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    .line 1809
    .end local v2    # "accountUri":Landroid/net/Uri;
    .end local v7    # "accountCursor":Landroid/database/Cursor;
    :cond_1
    monitor-exit v10

    .line 1810
    return-object v8

    .line 1806
    .restart local v2    # "accountUri":Landroid/net/Uri;
    .restart local v7    # "accountCursor":Landroid/database/Cursor;
    :catchall_0
    move-exception v1

    :goto_0
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    throw v1

    .line 1809
    .end local v2    # "accountUri":Landroid/net/Uri;
    .end local v7    # "accountCursor":Landroid/database/Cursor;
    :catchall_1
    move-exception v1

    monitor-exit v10
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    throw v1

    .line 1806
    .end local v8    # "result":Lcom/android/mail/providers/Account;
    .restart local v2    # "accountUri":Landroid/net/Uri;
    .restart local v7    # "accountCursor":Landroid/database/Cursor;
    .restart local v9    # "result":Lcom/android/mail/providers/Account;
    :catchall_2
    move-exception v1

    move-object v8, v9

    .end local v9    # "result":Lcom/android/mail/providers/Account;
    .restart local v8    # "result":Lcom/android/mail/providers/Account;
    goto :goto_0
.end method

.method private static getUiProviderAccountFolder(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lcom/android/mail/providers/Folder;
    .locals 8
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "accountName"    # Ljava/lang/String;
    .param p2, "canonicalName"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 1815
    const/4 v7, 0x0

    .line 1817
    .local v7, "result":Lcom/android/mail/providers/Folder;
    invoke-static {p1, p2}, Lcom/google/android/gm/provider/UiProvider;->getAccountLabelUri(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 1819
    .local v1, "folderUri":Landroid/net/Uri;
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v2, Lcom/android/mail/providers/UIProvider;->FOLDERS_PROJECTION:[Ljava/lang/String;

    move-object v4, v3

    move-object v5, v3

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 1822
    .local v6, "folderCursor":Landroid/database/Cursor;
    :try_start_0
    invoke-interface {v6}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1823
    new-instance v7, Lcom/android/mail/providers/Folder;

    .end local v7    # "result":Lcom/android/mail/providers/Folder;
    invoke-direct {v7, v6}, Lcom/android/mail/providers/Folder;-><init>(Landroid/database/Cursor;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1826
    .restart local v7    # "result":Lcom/android/mail/providers/Folder;
    :cond_0
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    .line 1828
    return-object v7

    .line 1826
    .end local v7    # "result":Lcom/android/mail/providers/Folder;
    :catchall_0
    move-exception v0

    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    throw v0
.end method

.method public static getUnreadCountString(Landroid/content/Context;I)Ljava/lang/String;
    .locals 5

    .prologue
    .line 2300
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 2301
    const v1, 0x7f0a001c

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v1

    .line 2302
    if-le p1, v1, :cond_0

    .line 2303
    const v2, 0x7f0c00d9

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    aput-object v1, v3, v4

    invoke-virtual {v0, v2, v3}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 2310
    :goto_0
    return-object v0

    .line 2305
    :cond_0
    if-gtz p1, :cond_1

    .line 2306
    const-string v0, ""

    goto :goto_0

    .line 2308
    :cond_1
    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static getVersionCode(Landroid/content/Context;)Ljava/lang/String;
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 2146
    sget-object v0, Lcom/google/android/gm/Utils;->sVersionCode:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 2148
    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v0

    iget v0, v0, Landroid/content/pm/PackageInfo;->versionCode:I

    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/Utils;->sVersionCode:Ljava/lang/String;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 2156
    :cond_0
    :goto_0
    sget-object v0, Lcom/google/android/gm/Utils;->sVersionCode:Ljava/lang/String;

    return-object v0

    .line 2151
    :catch_0
    move-exception v0

    .line 2152
    const-string v0, "Gmail"

    const-string v1, "Error finding package %s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v3

    iget-object v3, v3, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    aput-object v3, v2, v4

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0
.end method

.method public static haveGoogleMailActivitiesBeenEnabled(Landroid/content/Context;)Z
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v1, 0x1

    .line 2108
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    .line 2109
    .local v0, "pm":Landroid/content/pm/PackageManager;
    sget-object v2, Lcom/google/android/gm/Utils;->GOOGLE_MAIL_CONVERSATION_LIST_COMPONENT_NAME:Landroid/content/ComponentName;

    invoke-virtual {v0, v2}, Landroid/content/pm/PackageManager;->getComponentEnabledSetting(Landroid/content/ComponentName;)I

    move-result v2

    if-ne v2, v1, :cond_0

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static isAccountValid(Landroid/content/Context;Lcom/android/mail/providers/Account;)Z
    .locals 5

    .prologue
    const/4 v1, 0x0

    .line 2401
    if-eqz p1, :cond_0

    .line 2402
    invoke-static {p0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v0

    const-string v2, "com.google"

    invoke-virtual {v0, v2}, Landroid/accounts/AccountManager;->getAccountsByType(Ljava/lang/String;)[Landroid/accounts/Account;

    move-result-object v2

    .line 2405
    iget-object v3, p1, Landroid/accounts/Account;->name:Ljava/lang/String;

    move v0, v1

    .line 2407
    :goto_0
    array-length v4, v2

    if-ge v0, v4, :cond_0

    .line 2408
    aget-object v4, v2, v0

    iget-object v4, v4, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 2409
    const/4 v1, 0x1

    .line 2413
    :cond_0
    return v1

    .line 2407
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method public static isGoogleFeedbackInstalled(Landroid/content/Context;)Z
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 1896
    sget-object v0, Lcom/google/android/gm/Utils;->BUG_REPORT_INTENT:Landroid/content/Intent;

    invoke-static {p0, v0}, Lcom/google/android/gm/Utils;->isSupportingServiceInstalled(Landroid/content/Context;Landroid/content/Intent;)Z

    move-result v0

    return v0
.end method

.method private static isSupportingServiceInstalled(Landroid/content/Context;Landroid/content/Intent;)Z
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 2362
    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;
    :try_end_0
    .catch Ljava/lang/UnsupportedOperationException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 2366
    const/high16 v2, 0x10000

    invoke-virtual {v1, p1, v2}, Landroid/content/pm/PackageManager;->queryIntentServices(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v1

    .line 2368
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_0

    const/4 v0, 0x1

    :cond_0
    :goto_0
    return v0

    .line 2363
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method public static isValidGoogleAccount(Landroid/content/Context;Ljava/lang/String;)Z
    .locals 3

    .prologue
    .line 1725
    invoke-static {p0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v0

    const-string v1, "com.google"

    invoke-virtual {v0, v1}, Landroid/accounts/AccountManager;->getAccountsByType(Ljava/lang/String;)[Landroid/accounts/Account;

    move-result-object v0

    .line 1728
    new-instance v1, Landroid/accounts/Account;

    const-string v2, "com.google"

    invoke-direct {v1, p1, v2}, Landroid/accounts/Account;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {v1, v0}, Lcom/google/android/gm/Utils;->containsAccount(Landroid/accounts/Account;[Landroid/accounts/Account;)Z

    move-result v0

    return v0
.end method

.method public static joinStrings(Ljava/util/Set;Ljava/lang/String;)Ljava/lang/StringBuilder;
    .locals 6
    .param p1, "separator"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            ")",
            "Ljava/lang/StringBuilder;"
        }
    .end annotation

    .prologue
    .line 287
    .local p0, "strings":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    .line 288
    .local v4, "result":Ljava/lang/StringBuilder;
    const/4 v0, 0x0

    .line 289
    .local v0, "i":I
    invoke-interface {p0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 290
    .local v3, "l":Ljava/lang/String;
    add-int/lit8 v1, v0, 0x1

    .end local v0    # "i":I
    .local v1, "i":I
    if-lez v0, :cond_0

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 291
    :cond_0
    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move v0, v1

    .end local v1    # "i":I
    .restart local v0    # "i":I
    goto :goto_0

    .line 294
    .end local v3    # "l":Ljava/lang/String;
    :cond_1
    return-object v4
.end method

.method public static launchGoogleFeedback(Landroid/content/Context;)V
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 1901
    new-instance v0, Lcom/google/android/gm/Utils$2;

    invoke-direct {v0}, Lcom/google/android/gm/Utils$2;-><init>()V

    .line 1917
    .local v0, "conn":Landroid/content/ServiceConnection;
    sget-object v1, Lcom/google/android/gm/Utils;->BUG_REPORT_INTENT:Landroid/content/Intent;

    const/4 v2, 0x1

    invoke-virtual {p0, v1, v0, v2}, Landroid/content/Context;->bindService(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z

    .line 1918
    return-void
.end method

.method public static makeQueryString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "query"    # Ljava/lang/String;
    .param p1, "label"    # Ljava/lang/String;

    .prologue
    .line 2118
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 2124
    .end local p0    # "query":Ljava/lang/String;
    :goto_0
    return-object p0

    .line 2121
    .restart local p0    # "query":Ljava/lang/String;
    :cond_0
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 2122
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "label:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    goto :goto_0

    .line 2124
    :cond_1
    const-string p0, ""

    goto :goto_0
.end method

.method private static openUrl(Landroid/content/Context;Landroid/net/Uri;)V
    .locals 4

    .prologue
    .line 1962
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1963
    :cond_0
    const-string v0, "Gmail"

    const-string v1, "invalid url in Utils.openUrl(): %s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/LogUtils;->wtf(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1969
    :goto_0
    return-void

    .line 1966
    :cond_1
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    invoke-direct {v0, v1, p1}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 1967
    const-string v1, "com.android.browser.application_id"

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1968
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto :goto_0
.end method

.method private static replaceLocale(Ljava/lang/String;)Ljava/lang/String;
    .locals 3

    .prologue
    .line 1947
    const-string v0, "%locale%"

    invoke-virtual {p0, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1948
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v0

    .line 1949
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0}, Ljava/util/Locale;->getCountry()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1950
    const-string v1, "%locale%"

    invoke-virtual {p0, v1, v0}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object p0

    .line 1952
    :cond_0
    return-object p0
.end method

.method private static seekToLatestUnreadConversation(Lcom/google/android/gm/provider/Gmail$ConversationCursor;)Z
    .locals 2
    .param p0, "cusor"    # Lcom/google/android/gm/provider/Gmail$ConversationCursor;

    .prologue
    .line 1365
    invoke-virtual {p0}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->position()I

    move-result v0

    .line 1367
    .local v0, "initialPosition":I
    :cond_0
    invoke-virtual {p0}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getHasUnreadMessage()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 1368
    const/4 v1, 0x1

    .line 1374
    :goto_0
    return v1

    .line 1370
    :cond_1
    invoke-virtual {p0}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->next()Z

    move-result v1

    if-nez v1, :cond_0

    .line 1373
    invoke-virtual {p0, v0}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->moveTo(I)Z

    .line 1374
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static setNewEmailIndicator(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 14
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    const/4 v13, 0x2

    const/4 v12, 0x0

    .line 568
    const-string v0, "count"

    invoke-virtual {p1, v0, v12}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v8

    .line 569
    .local v8, "unreadCount":I
    const-string v0, "unseenCount"

    invoke-virtual {p1, v0, v12}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v9

    .line 571
    .local v9, "unseenCount":I
    const-string v0, "account"

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 572
    .local v2, "account":Ljava/lang/String;
    const-string v0, "tagLabel"

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 573
    .local v4, "tagLabel":Ljava/lang/String;
    const/4 v5, 0x0

    .line 576
    .local v5, "ignoreUnobtrusiveSetting":Z
    const/4 v3, 0x0

    .line 577
    .local v3, "getAttention":Z
    invoke-static {p0}, Lcom/google/android/gm/Utils;->getNotificationMap(Landroid/content/Context;)Lcom/google/android/gm/Utils$NotificationMap;

    move-result-object v7

    .line 578
    .local v7, "notificationMap":Lcom/google/android/gm/Utils$NotificationMap;
    new-instance v6, Lcom/google/android/gm/Utils$NotificationKey;

    invoke-direct {v6, v2, v4}, Lcom/google/android/gm/Utils$NotificationKey;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 579
    .local v6, "key":Lcom/google/android/gm/Utils$NotificationKey;
    if-nez v8, :cond_1

    .line 580
    invoke-virtual {v7, v6}, Lcom/google/android/gm/Utils$NotificationMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 592
    :goto_0
    invoke-virtual {v7, p0}, Lcom/google/android/gm/Utils$NotificationMap;->saveNotificationMap(Landroid/content/Context;)V

    .line 594
    const-string v0, "Gmail"

    invoke-static {v0, v13}, Lcom/google/android/gm/provider/LogUtils;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 595
    const-string v0, "Gmail"

    const-string v1, "New email: %s mapSize: %d getAttention: %b"

    const/4 v10, 0x3

    new-array v10, v10, [Ljava/lang/Object;

    invoke-static {v7}, Lcom/google/android/gm/Utils;->createNotificationString(Lcom/google/android/gm/Utils$NotificationMap;)Ljava/lang/String;

    move-result-object v11

    aput-object v11, v10, v12

    const/4 v11, 0x1

    invoke-virtual {v7}, Lcom/google/android/gm/Utils$NotificationMap;->size()I

    move-result v12

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    aput-object v12, v10, v11

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v11

    aput-object v11, v10, v13

    invoke-static {v0, v1, v10}, Lcom/google/android/gm/provider/LogUtils;->v(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    :cond_0
    move-object v0, p0

    move-object v1, p1

    .line 600
    invoke-static/range {v0 .. v6}, Lcom/google/android/gm/Utils;->validateNotifications(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;ZLjava/lang/String;ZLcom/google/android/gm/Utils$NotificationKey;)V

    .line 602
    return-void

    .line 582
    :cond_1
    invoke-virtual {v7, v6}, Lcom/google/android/gm/Utils$NotificationMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 586
    const/4 v5, 0x1

    .line 588
    :cond_2
    invoke-virtual {v7, v6, v8, v9}, Lcom/google/android/gm/Utils$NotificationMap;->put(Lcom/google/android/gm/Utils$NotificationKey;II)V

    .line 589
    const-string v0, "getAttention"

    invoke-virtual {p1, v0, v12}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v3

    goto :goto_0
.end method

.method public static shortcutActivityEnabled(Landroid/content/Context;)Z
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v1, 0x1

    .line 2094
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    .line 2097
    .local v0, "pm":Landroid/content/pm/PackageManager;
    sget-object v2, Lcom/google/android/gm/Utils;->GOOGLE_MAIL_LABEL_SHORTCUT_COMPONENT_NAME:Landroid/content/ComponentName;

    invoke-virtual {v0, v2}, Landroid/content/pm/PackageManager;->getComponentEnabledSetting(Landroid/content/ComponentName;)I

    move-result v2

    if-eq v2, v1, :cond_0

    sget-object v2, Lcom/google/android/gm/Utils;->GMAIL_LABEL_SHORTCUT_COMPONENT_NAME:Landroid/content/ComponentName;

    invoke-virtual {v0, v2}, Landroid/content/pm/PackageManager;->getComponentEnabledSetting(Landroid/content/ComponentName;)I

    move-result v2

    if-ne v2, v1, :cond_1

    :cond_0
    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static showAbout(Landroid/content/Context;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 1874
    const-wide/32 v0, 0x7f10011b

    invoke-static {p0, v0, v1}, Lcom/google/android/gm/Utils;->showPreferences(Landroid/content/Context;J)V

    .line 1875
    return-void
.end method

.method public static showFeedbackSurvey(Landroid/content/Context;)V
    .locals 2

    .prologue
    .line 1883
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const-string v1, "gmail_feedback_url"

    invoke-static {v0, v1}, Lcom/google/android/gsf/Gservices;->getString(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1885
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1886
    const-string v0, "http://support.google.com/mail?p=android_survey&hl=%locale%"

    .line 1888
    :cond_0
    invoke-static {p0, v0}, Lcom/google/android/gm/Utils;->addGmailParamsToUrl(Landroid/content/Context;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 1889
    invoke-static {p0, v0}, Lcom/google/android/gm/Utils;->openUrl(Landroid/content/Context;Landroid/net/Uri;)V

    .line 1890
    return-void
.end method

.method public static showHelp(Landroid/content/Context;Lcom/google/android/gm/ApplicationMenuHandler$HelpCallback;)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "callback"    # Lcom/google/android/gm/ApplicationMenuHandler$HelpCallback;

    .prologue
    .line 1998
    invoke-interface {p1}, Lcom/google/android/gm/ApplicationMenuHandler$HelpCallback;->getHelpContext()Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/google/android/gm/Utils;->showHelp(Landroid/content/Context;Ljava/lang/String;)V

    .line 1999
    return-void
.end method

.method public static showHelp(Landroid/content/Context;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 1979
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const-string v1, "gmail_context_sensitive_help_url"

    const-string v2, "http://support.google.com/mobile/?hl=%locale%"

    invoke-static {v0, v1, v2}, Lcom/google/android/gsf/Gservices;->getString(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1982
    invoke-static {p0, v0}, Lcom/google/android/gm/Utils;->addGmailParamsToUrl(Landroid/content/Context;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 1983
    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    .line 1985
    if-eqz p1, :cond_0

    .line 1986
    const-string v1, "p"

    invoke-virtual {v0, v1, p1}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    .line 1989
    :cond_0
    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/google/android/gm/Utils;->openUrl(Landroid/content/Context;Landroid/net/Uri;)V

    .line 1990
    return-void
.end method

.method public static showOpenSourceLicenses(Landroid/content/Context;)V
    .locals 2

    .prologue
    .line 2022
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/google/android/gm/LicenseActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2023
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 2024
    return-void
.end method

.method private static showPreferences(Landroid/content/Context;J)V
    .locals 3

    .prologue
    .line 2012
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/google/android/gm/preference/GmailPreferenceActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2013
    const-wide/16 v1, -0x1

    cmp-long v1, p1, v1

    if-eqz v1, :cond_0

    .line 2014
    const-string v1, "initial_fragment_id"

    invoke-virtual {v0, v1, p1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 2018
    :cond_0
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 2019
    return-void
.end method

.method public static showSettings(Landroid/content/Context;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 2008
    const-wide/16 v0, -0x1

    invoke-static {p0, v0, v1}, Lcom/google/android/gm/Utils;->showPreferences(Landroid/content/Context;J)V

    .line 2009
    return-void
.end method

.method private static startShortcutEnablerService(Landroid/content/Context;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 2057
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 2058
    const-class v1, Lcom/google/android/gm/ShortcutEnablerService;

    invoke-virtual {v0, p0, v1}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    .line 2059
    const-string v1, "account-name"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 2060
    invoke-virtual {p0, v0}, Landroid/content/Context;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 2061
    return-void
.end method

.method public static startSync(Ljava/lang/String;)V
    .locals 3
    .param p0, "accountName"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 1443
    sget-object v0, Lcom/google/android/gm/Utils;->sLastScheduleSyncTask:Lcom/google/android/gm/Utils$ScheduleSyncTask;

    if-eqz v0, :cond_0

    .line 1444
    sget-object v0, Lcom/google/android/gm/Utils;->sLastScheduleSyncTask:Lcom/google/android/gm/Utils$ScheduleSyncTask;

    invoke-virtual {v0, v2}, Lcom/google/android/gm/Utils$ScheduleSyncTask;->cancel(Z)Z

    .line 1447
    :cond_0
    new-instance v0, Lcom/google/android/gm/Utils$ScheduleSyncTask;

    invoke-direct {v0, p0}, Lcom/google/android/gm/Utils$ScheduleSyncTask;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/google/android/gm/Utils;->sLastScheduleSyncTask:Lcom/google/android/gm/Utils$ScheduleSyncTask;

    .line 1448
    sget-object v0, Lcom/google/android/gm/Utils;->sLastScheduleSyncTask:Lcom/google/android/gm/Utils$ScheduleSyncTask;

    sget-object v1, Landroid/os/AsyncTask;->THREAD_POOL_EXECUTOR:Ljava/util/concurrent/Executor;

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gm/Utils$ScheduleSyncTask;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 1449
    return-void
.end method

.method private static updateSendErrorNotificationMap(Ljava/lang/String;I)V
    .locals 2
    .param p0, "account"    # Ljava/lang/String;
    .param p1, "notificationId"    # I

    .prologue
    .line 2271
    sget-object v1, Lcom/google/android/gm/Utils;->sActiveSendErrorNotificationsMap:Ljava/util/Map;

    invoke-interface {v1, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    .line 2272
    .local v0, "activeNotifications":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Integer;>;"
    if-nez v0, :cond_0

    .line 2273
    new-instance v0, Ljava/util/ArrayList;

    .end local v0    # "activeNotifications":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Integer;>;"
    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 2275
    .restart local v0    # "activeNotifications":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Integer;>;"
    :cond_0
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2276
    sget-object v1, Lcom/google/android/gm/Utils;->sActiveSendErrorNotificationsMap:Ljava/util/Map;

    invoke-interface {v1, p0, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2277
    return-void
.end method

.method static validateAccountNotifications(Landroid/content/Context;Ljava/lang/String;)V
    .locals 13
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "account"    # Ljava/lang/String;

    .prologue
    .line 488
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v12

    invoke-static {v12}, Lcom/google/android/gm/comm/longshadow/LongShadowUtils;->getContentProviderMailAccess(Landroid/content/ContentResolver;)Lcom/google/android/gm/provider/Gmail;

    move-result-object v2

    .line 489
    .local v2, "gm":Lcom/google/android/gm/provider/Gmail;
    invoke-static {}, Lcom/google/android/gm/persistence/Persistence;->getInstance()Lcom/google/android/gm/persistence/Persistence;

    move-result-object v9

    .line 491
    .local v9, "persistence":Lcom/google/android/gm/persistence/Persistence;
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v8

    .line 494
    .local v8, "notificationsToCancel":Ljava/util/List;, "Ljava/util/List<Lcom/google/android/gm/Utils$NotificationKey;>;"
    invoke-static {p0}, Lcom/google/android/gm/Utils;->getNotificationMap(Landroid/content/Context;)Lcom/google/android/gm/Utils$NotificationMap;

    move-result-object v7

    .line 495
    .local v7, "notificationMap":Lcom/google/android/gm/Utils$NotificationMap;
    invoke-virtual {v7}, Lcom/google/android/gm/Utils$NotificationMap;->keySet()Ljava/util/Set;

    move-result-object v4

    .line 496
    .local v4, "keys":Ljava/util/Set;, "Ljava/util/Set<Lcom/google/android/gm/Utils$NotificationKey;>;"
    invoke-virtual {v9, p0, p1}, Lcom/google/android/gm/persistence/Persistence;->getEnableNotifications(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v1

    .line 497
    .local v1, "enabled":Z
    if-nez v1, :cond_1

    .line 499
    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v12

    if-eqz v12, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/google/android/gm/Utils$NotificationKey;

    .line 500
    .local v6, "notification":Lcom/google/android/gm/Utils$NotificationKey;
    iget-object v12, v6, Lcom/google/android/gm/Utils$NotificationKey;->account:Ljava/lang/String;

    invoke-virtual {v12, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v12

    if-eqz v12, :cond_0

    .line 501
    invoke-interface {v8, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 505
    .end local v3    # "i$":Ljava/util/Iterator;
    .end local v6    # "notification":Lcom/google/android/gm/Utils$NotificationKey;
    :cond_1
    invoke-virtual {v2, p0, p1}, Lcom/google/android/gm/provider/Gmail;->getSettings(Landroid/content/Context;Ljava/lang/String;)Lcom/google/android/gm/provider/Gmail$Settings;

    move-result-object v10

    .line 506
    .local v10, "settings":Lcom/google/android/gm/provider/Gmail$Settings;
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v11

    .line 507
    .local v11, "syncedLabels":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-virtual {v10}, Lcom/google/android/gm/provider/Gmail$Settings;->getLabelsPartial()Ljava/util/List;

    move-result-object v12

    invoke-interface {v11, v12}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    .line 508
    invoke-virtual {v10}, Lcom/google/android/gm/provider/Gmail$Settings;->getLabelsIncluded()Ljava/util/List;

    move-result-object v12

    invoke-interface {v11, v12}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    .line 512
    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .restart local v3    # "i$":Ljava/util/Iterator;
    :cond_2
    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v12

    if-eqz v12, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/google/android/gm/Utils$NotificationKey;

    .line 513
    .restart local v6    # "notification":Lcom/google/android/gm/Utils$NotificationKey;
    iget-object v12, v6, Lcom/google/android/gm/Utils$NotificationKey;->account:Ljava/lang/String;

    invoke-virtual {v12, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v12

    if-eqz v12, :cond_2

    .line 516
    iget-object v12, v6, Lcom/google/android/gm/Utils$NotificationKey;->label:Ljava/lang/String;

    invoke-static {v12}, Lcom/google/android/gm/provider/Gmail;->getCanonicalLabelForTagLabel(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 518
    .local v0, "canonicalName":Ljava/lang/String;
    iget-object v12, v6, Lcom/google/android/gm/Utils$NotificationKey;->account:Ljava/lang/String;

    invoke-virtual {v9, p0, v12, v0}, Lcom/google/android/gm/persistence/Persistence;->shouldNotifyForLabel(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v12

    if-nez v12, :cond_2

    .line 520
    invoke-interface {v8, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 527
    .end local v0    # "canonicalName":Ljava/lang/String;
    .end local v6    # "notification":Lcom/google/android/gm/Utils$NotificationKey;
    .end local v10    # "settings":Lcom/google/android/gm/provider/Gmail$Settings;
    .end local v11    # "syncedLabels":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    :cond_3
    invoke-interface {v8}, Ljava/util/List;->size()I

    move-result v12

    if-lez v12, :cond_5

    .line 528
    const-string v12, "notification"

    invoke-virtual {p0, v12}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/app/NotificationManager;

    .line 530
    .local v5, "nm":Landroid/app/NotificationManager;
    invoke-interface {v8}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_2
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v12

    if-eqz v12, :cond_4

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/google/android/gm/Utils$NotificationKey;

    .line 531
    .restart local v6    # "notification":Lcom/google/android/gm/Utils$NotificationKey;
    iget-object v12, v6, Lcom/google/android/gm/Utils$NotificationKey;->label:Ljava/lang/String;

    invoke-static {v12}, Lcom/google/android/gm/provider/Gmail;->getCanonicalLabelForTagLabel(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 533
    .restart local v0    # "canonicalName":Ljava/lang/String;
    iget-object v12, v6, Lcom/google/android/gm/Utils$NotificationKey;->account:Ljava/lang/String;

    invoke-static {v12, v0}, Lcom/google/android/gm/Utils;->getNotificationId(Ljava/lang/String;Ljava/lang/String;)I

    move-result v12

    invoke-virtual {v5, v12}, Landroid/app/NotificationManager;->cancel(I)V

    .line 534
    invoke-virtual {v7, v6}, Lcom/google/android/gm/Utils$NotificationMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_2

    .line 536
    .end local v0    # "canonicalName":Ljava/lang/String;
    .end local v6    # "notification":Lcom/google/android/gm/Utils$NotificationKey;
    :cond_4
    invoke-virtual {v7, p0}, Lcom/google/android/gm/Utils$NotificationMap;->saveNotificationMap(Landroid/content/Context;)V

    .line 538
    .end local v5    # "nm":Landroid/app/NotificationManager;
    :cond_5
    return-void
.end method

.method private static validateNotifications(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;ZLjava/lang/String;ZLcom/google/android/gm/Utils$NotificationKey;)V
    .locals 34
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "notificationAccount"    # Ljava/lang/String;
    .param p3, "getAttention"    # Z
    .param p4, "tagLabel"    # Ljava/lang/String;
    .param p5, "ignoreUnobtrusiveSetting"    # Z
    .param p6, "key"    # Lcom/google/android/gm/Utils$NotificationKey;

    .prologue
    .line 611
    const-string v3, "notification"

    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v18

    check-cast v18, Landroid/app/NotificationManager;

    .line 614
    .local v18, "nm":Landroid/app/NotificationManager;
    invoke-static {}, Lcom/google/android/gm/persistence/Persistence;->getInstance()Lcom/google/android/gm/persistence/Persistence;

    move-result-object v23

    .line 616
    .local v23, "persistence":Lcom/google/android/gm/persistence/Persistence;
    invoke-static/range {p0 .. p0}, Lcom/google/android/gm/Utils;->getNotificationMap(Landroid/content/Context;)Lcom/google/android/gm/Utils$NotificationMap;

    move-result-object v20

    .line 617
    .local v20, "notificationMap":Lcom/google/android/gm/Utils$NotificationMap;
    const-string v3, "Gmail"

    const/4 v7, 0x2

    invoke-static {v3, v7}, Lcom/google/android/gm/provider/LogUtils;->isLoggable(Ljava/lang/String;I)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 618
    const-string v3, "Gmail"

    const-string v7, "Validating Notification: %s mapSize: %d tagLabel: %s getAttention: %b"

    const/16 v31, 0x4

    move/from16 v0, v31

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v31, v0

    const/16 v32, 0x0

    invoke-static/range {v20 .. v20}, Lcom/google/android/gm/Utils;->createNotificationString(Lcom/google/android/gm/Utils$NotificationMap;)Ljava/lang/String;

    move-result-object v33

    aput-object v33, v31, v32

    const/16 v32, 0x1

    invoke-virtual/range {v20 .. v20}, Lcom/google/android/gm/Utils$NotificationMap;->size()I

    move-result v33

    invoke-static/range {v33 .. v33}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v33

    aput-object v33, v31, v32

    const/16 v32, 0x2

    aput-object p4, v31, v32

    const/16 v32, 0x3

    invoke-static/range {p3 .. p3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v33

    aput-object v33, v31, v32

    move-object/from16 v0, v31

    invoke-static {v3, v7, v0}, Lcom/google/android/gm/provider/LogUtils;->v(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 623
    :cond_0
    move-object/from16 v0, v20

    move-object/from16 v1, p6

    invoke-virtual {v0, v1}, Lcom/google/android/gm/Utils$NotificationMap;->getUnread(Lcom/google/android/gm/Utils$NotificationKey;)Ljava/lang/Integer;

    move-result-object v26

    .line 624
    .local v26, "unread":Ljava/lang/Integer;
    if-eqz v26, :cond_5

    invoke-virtual/range {v26 .. v26}, Ljava/lang/Integer;->intValue()I

    move-result v8

    .line 625
    .local v8, "unreadCount":I
    :goto_0
    move-object/from16 v0, v20

    move-object/from16 v1, p6

    invoke-virtual {v0, v1}, Lcom/google/android/gm/Utils$NotificationMap;->getUnseen(Lcom/google/android/gm/Utils$NotificationKey;)Ljava/lang/Integer;

    move-result-object v27

    .line 626
    .local v27, "unseen":Ljava/lang/Integer;
    if-eqz v27, :cond_6

    invoke-virtual/range {v27 .. v27}, Ljava/lang/Integer;->intValue()I

    move-result v9

    .line 629
    .local v9, "unseenCount":I
    :goto_1
    const/4 v5, 0x0

    .line 631
    .local v5, "conversationCursor":Lcom/google/android/gm/provider/Gmail$ConversationCursor;
    const-string v3, "notificationLabel"

    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    .line 632
    .local v10, "label":Ljava/lang/String;
    if-nez v10, :cond_1

    .line 633
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-static {v0, v1}, Lcom/google/android/gm/persistence/Persistence;->getAccountInbox(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    .line 637
    :cond_1
    :try_start_0
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    invoke-static {v3}, Lcom/google/android/gm/comm/longshadow/LongShadowUtils;->getContentProviderMailAccess(Landroid/content/ContentResolver;)Lcom/google/android/gm/provider/Gmail;

    move-result-object v17

    .line 638
    .local v17, "gmail":Lcom/google/android/gm/provider/Gmail;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "label:"

    invoke-virtual {v3, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-static {v10}, Lcom/google/android/gm/provider/Gmail;->getCanonicalLabelForNotification(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v3, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    sget-object v7, Lcom/google/android/gm/provider/Gmail$BecomeActiveNetworkCursor;->NO:Lcom/google/android/gm/provider/Gmail$BecomeActiveNetworkCursor;

    move-object/from16 v0, v17

    move-object/from16 v1, p2

    invoke-virtual {v0, v1, v3, v7}, Lcom/google/android/gm/provider/Gmail;->getDetachedConversationCursorForQuery(Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gm/provider/Gmail$BecomeActiveNetworkCursor;)Lcom/google/android/gm/provider/Gmail$ConversationCursor;

    move-result-object v5

    .line 642
    invoke-virtual {v5}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->count()I

    move-result v14

    .line 646
    .local v14, "cursorUnseenCount":I
    if-eqz v9, :cond_2

    if-eq v9, v14, :cond_2

    .line 647
    const-string v3, "Gmail"

    const-string v7, "Unseen count doesn\'t match cursor count.  unseen: %d cursor count: %d"

    const/16 v31, 0x2

    move/from16 v0, v31

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v31, v0

    const/16 v32, 0x0

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v33

    aput-object v33, v31, v32

    const/16 v32, 0x1

    invoke-static {v14}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v33

    aput-object v33, v31, v32

    move-object/from16 v0, v31

    invoke-static {v3, v7, v0}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 650
    move v9, v14

    .line 655
    :cond_2
    if-le v9, v8, :cond_3

    .line 656
    move v9, v8

    .line 659
    :cond_3
    if-nez v9, :cond_7

    .line 660
    move-object/from16 v0, p2

    invoke-static {v0, v10}, Lcom/google/android/gm/Utils;->getNotificationId(Ljava/lang/String;Ljava/lang/String;)I

    move-result v3

    move-object/from16 v0, v18

    invoke-virtual {v0, v3}, Landroid/app/NotificationManager;->cancel(I)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 768
    if-eqz v5, :cond_4

    .line 769
    invoke-virtual {v5}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->close()V

    .line 772
    :cond_4
    :goto_2
    return-void

    .line 624
    .end local v5    # "conversationCursor":Lcom/google/android/gm/provider/Gmail$ConversationCursor;
    .end local v8    # "unreadCount":I
    .end local v9    # "unseenCount":I
    .end local v10    # "label":Ljava/lang/String;
    .end local v14    # "cursorUnseenCount":I
    .end local v17    # "gmail":Lcom/google/android/gm/provider/Gmail;
    .end local v27    # "unseen":Ljava/lang/Integer;
    :cond_5
    const/4 v8, 0x0

    goto/16 :goto_0

    .line 626
    .restart local v8    # "unreadCount":I
    .restart local v27    # "unseen":Ljava/lang/Integer;
    :cond_6
    const/4 v9, 0x0

    goto :goto_1

    .line 666
    .restart local v5    # "conversationCursor":Lcom/google/android/gm/provider/Gmail$ConversationCursor;
    .restart local v9    # "unseenCount":I
    .restart local v10    # "label":Ljava/lang/String;
    .restart local v14    # "cursorUnseenCount":I
    .restart local v17    # "gmail":Lcom/google/android/gm/provider/Gmail;
    :cond_7
    const/high16 v3, 0x4000000

    :try_start_1
    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 671
    new-instance v4, Landroid/app/Notification$Builder;

    move-object/from16 v0, p0

    invoke-direct {v4, v0}, Landroid/app/Notification$Builder;-><init>(Landroid/content/Context;)V

    .line 672
    .local v4, "notification":Landroid/app/Notification$Builder;
    const v3, 0x7f020098

    invoke-virtual {v4, v3}, Landroid/app/Notification$Builder;->setSmallIcon(I)Landroid/app/Notification$Builder;

    .line 673
    move-object/from16 v0, p2

    invoke-virtual {v4, v0}, Landroid/app/Notification$Builder;->setTicker(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    .line 674
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v31

    move-wide/from16 v0, v31

    invoke-virtual {v4, v0, v1}, Landroid/app/Notification$Builder;->setWhen(J)Landroid/app/Notification$Builder;

    .line 675
    invoke-static {}, Lcom/google/android/gm/persistence/Persistence;->getInstance()Lcom/google/android/gm/persistence/Persistence;

    move-result-object v3

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-virtual {v3, v0, v1, v10}, Lcom/google/android/gm/persistence/Persistence;->getNotificationLabelInformation(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Set;

    move-result-object v11

    .line 677
    .local v11, "attributes":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    move-object/from16 v0, p0

    invoke-static {v0, v11}, Lcom/google/android/gm/persistence/Persistence;->extractVibrateSetting(Landroid/content/Context;Ljava/util/Set;)Ljava/lang/String;

    move-result-object v28

    .line 678
    .local v28, "vibrate":Ljava/lang/String;
    sget v3, Lcom/google/android/gm/persistence/Persistence;->LABEL_NOTIFICATION_RINGTONE:I

    invoke-static {v11, v3}, Lcom/google/android/gm/persistence/Persistence;->extract(Ljava/util/Set;I)Ljava/lang/String;

    move-result-object v25

    .line 680
    .local v25, "ringtoneUri":Ljava/lang/String;
    sget v3, Lcom/google/android/gm/persistence/Persistence;->LABEL_NOTIFICATION_ONCE:I

    invoke-static {v11, v3}, Lcom/google/android/gm/persistence/Persistence;->extract(Ljava/util/Set;I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v21

    .line 686
    .local v21, "notifyOnce":Z
    new-instance v13, Landroid/content/Intent;

    const-string v3, "com.google.android.gm.intent.CLEAR_NEW_MAIL_NOTIFICATIONS"

    invoke-direct {v13, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 688
    .local v13, "cancelNotificationIntent":Landroid/content/Intent;
    const-string v3, "account"

    move-object/from16 v0, p2

    invoke-virtual {v13, v3, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 691
    const-string v3, "label"

    invoke-virtual {v13, v3, v10}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 694
    const/4 v3, 0x0

    const/4 v7, 0x0

    move-object/from16 v0, p0

    invoke-static {v0, v3, v13, v7}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v3

    invoke-virtual {v4, v3}, Landroid/app/Notification$Builder;->setDeleteIntent(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;

    .line 697
    const/4 v3, 0x1

    invoke-virtual {v4, v3}, Landroid/app/Notification$Builder;->setAutoCancel(Z)Landroid/app/Notification$Builder;

    .line 699
    if-nez p5, :cond_8

    if-eqz p2, :cond_8

    if-eqz v21, :cond_8

    .line 704
    const/4 v3, 0x1

    invoke-virtual {v4, v3}, Landroid/app/Notification$Builder;->setOnlyAlertOnce(Z)Landroid/app/Notification$Builder;

    .line 707
    :cond_8
    const/16 v16, 0x0

    .line 708
    .local v16, "eventInfoConfigured":Z
    move-object/from16 v0, p2

    invoke-static {v0, v10}, Lcom/google/android/gm/Utils;->getNotificationId(Ljava/lang/String;Ljava/lang/String;)I

    move-result v19

    .line 710
    .local v19, "notificationId":I
    if-lez v8, :cond_a

    .line 711
    const/4 v3, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-static {v0, v1, v10, v3}, Lcom/google/android/gm/Utils;->createViewConversationIntent(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gm/provider/Gmail$ConversationCursor;)Landroid/content/Intent;

    move-result-object p1

    .line 714
    invoke-virtual {v5}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->next()Z

    move-result v3

    if-eqz v3, :cond_a

    .line 717
    const/4 v3, 0x1

    if-ne v9, v3, :cond_9

    .line 718
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-static {v0, v1, v10, v5}, Lcom/google/android/gm/Utils;->createViewConversationIntent(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gm/provider/Gmail$ConversationCursor;)Landroid/content/Intent;

    move-result-object p1

    .line 721
    :cond_9
    const-string v3, "label"

    move-object/from16 v0, p1

    invoke-virtual {v0, v3, v10}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object p1

    .line 722
    const/4 v3, -0x1

    const/4 v7, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-static {v0, v3, v1, v7}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v6

    .local v6, "clickIntent":Landroid/app/PendingIntent;
    move-object/from16 v3, p0

    move-object/from16 v7, p2

    .line 723
    invoke-static/range {v3 .. v10}, Lcom/google/android/gm/Utils;->configureLatestEventInfoFromConversation(Landroid/content/Context;Landroid/app/Notification$Builder;Lcom/google/android/gm/provider/Gmail$ConversationCursor;Landroid/app/PendingIntent;Ljava/lang/String;IILjava/lang/String;)V

    .line 726
    const/16 v16, 0x1

    .line 729
    .end local v6    # "clickIntent":Landroid/app/PendingIntent;
    :cond_a
    if-eqz p2, :cond_b

    .line 730
    const-string v3, "Gmail"

    const-string v7, "Account: %s vibrateWhen: %s"

    const/16 v31, 0x2

    move/from16 v0, v31

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v31, v0

    const/16 v32, 0x0

    aput-object p2, v31, v32

    const/16 v32, 0x1

    move-object/from16 v0, v23

    move-object/from16 v1, p0

    move-object/from16 v2, p2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gm/persistence/Persistence;->getVibrateWhen(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v33

    aput-object v33, v31, v32

    move-object/from16 v0, v31

    invoke-static {v3, v7, v0}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 734
    :cond_b
    const/4 v15, 0x0

    .line 736
    .local v15, "defaults":I
    if-eqz p3, :cond_f

    if-eqz p2, :cond_f

    .line 737
    move-object/from16 v0, v23

    move-object/from16 v1, p0

    move-object/from16 v2, p2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gm/persistence/Persistence;->getEnableNotifications(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_f

    .line 738
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v24

    .line 739
    .local v24, "resources":Landroid/content/res/Resources;
    const/16 v29, 0x0

    .line 740
    .local v29, "vibrateAlways":Z
    const/16 v30, 0x0

    .line 741
    .local v30, "vibrateSilent":Z
    if-eqz v28, :cond_c

    .line 742
    const v3, 0x7f0c0194

    move-object/from16 v0, v24

    invoke-virtual {v0, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v28

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v29

    .line 744
    const v3, 0x7f0c0196

    move-object/from16 v0, v24

    invoke-virtual {v0, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v28

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v30

    .line 747
    :cond_c
    const-string v3, "audio"

    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Landroid/media/AudioManager;

    .line 749
    .local v12, "audioManager":Landroid/media/AudioManager;
    invoke-virtual {v12}, Landroid/media/AudioManager;->getRingerMode()I

    move-result v3

    const/4 v7, 0x1

    if-ne v3, v7, :cond_11

    const/16 v22, 0x1

    .line 752
    .local v22, "nowSilent":Z
    :goto_3
    if-nez v29, :cond_d

    if-eqz v30, :cond_e

    if-eqz v22, :cond_e

    .line 753
    :cond_d
    or-int/lit8 v15, v15, 0x2

    .line 755
    :cond_e
    invoke-static/range {v25 .. v25}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_12

    const/4 v3, 0x0

    :goto_4
    invoke-virtual {v4, v3}, Landroid/app/Notification$Builder;->setSound(Landroid/net/Uri;)Landroid/app/Notification$Builder;

    .line 757
    const-string v3, "Gmail"

    const-string v7, "New email in %s vibrateWhen: %s, playing notification: %s"

    const/16 v31, 0x3

    move/from16 v0, v31

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v31, v0

    const/16 v32, 0x0

    aput-object p2, v31, v32

    const/16 v32, 0x1

    aput-object v28, v31, v32

    const/16 v32, 0x2

    aput-object v25, v31, v32

    move-object/from16 v0, v31

    invoke-static {v3, v7, v0}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 762
    .end local v12    # "audioManager":Landroid/media/AudioManager;
    .end local v22    # "nowSilent":Z
    .end local v24    # "resources":Landroid/content/res/Resources;
    .end local v29    # "vibrateAlways":Z
    .end local v30    # "vibrateSilent":Z
    :cond_f
    if-eqz v16, :cond_10

    .line 763
    or-int/lit8 v15, v15, 0x4

    .line 764
    invoke-virtual {v4, v15}, Landroid/app/Notification$Builder;->setDefaults(I)Landroid/app/Notification$Builder;

    .line 765
    invoke-virtual {v4}, Landroid/app/Notification$Builder;->getNotification()Landroid/app/Notification;

    move-result-object v3

    move-object/from16 v0, v18

    move/from16 v1, v19

    invoke-virtual {v0, v1, v3}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 768
    :cond_10
    if-eqz v5, :cond_4

    .line 769
    invoke-virtual {v5}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->close()V

    goto/16 :goto_2

    .line 749
    .restart local v12    # "audioManager":Landroid/media/AudioManager;
    .restart local v24    # "resources":Landroid/content/res/Resources;
    .restart local v29    # "vibrateAlways":Z
    .restart local v30    # "vibrateSilent":Z
    :cond_11
    const/16 v22, 0x0

    goto :goto_3

    .line 755
    .restart local v22    # "nowSilent":Z
    :cond_12
    :try_start_2
    invoke-static/range {v25 .. v25}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result-object v3

    goto :goto_4

    .line 768
    .end local v4    # "notification":Landroid/app/Notification$Builder;
    .end local v11    # "attributes":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .end local v12    # "audioManager":Landroid/media/AudioManager;
    .end local v13    # "cancelNotificationIntent":Landroid/content/Intent;
    .end local v14    # "cursorUnseenCount":I
    .end local v15    # "defaults":I
    .end local v16    # "eventInfoConfigured":Z
    .end local v17    # "gmail":Lcom/google/android/gm/provider/Gmail;
    .end local v19    # "notificationId":I
    .end local v21    # "notifyOnce":Z
    .end local v22    # "nowSilent":Z
    .end local v24    # "resources":Landroid/content/res/Resources;
    .end local v25    # "ringtoneUri":Ljava/lang/String;
    .end local v28    # "vibrate":Ljava/lang/String;
    .end local v29    # "vibrateAlways":Z
    .end local v30    # "vibrateSilent":Z
    :catchall_0
    move-exception v3

    if-eqz v5, :cond_13

    .line 769
    invoke-virtual {v5}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->close()V

    :cond_13
    throw v3
.end method
