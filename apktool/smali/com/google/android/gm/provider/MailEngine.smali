.class public final Lcom/google/android/gm/provider/MailEngine;
.super Ljava/lang/Object;
.source "MailEngine.java"

# interfaces
.implements Lcom/google/android/gm/provider/AttachmentManager$RestrictedMailEngine;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gm/provider/MailEngine$MailStoreOpenHelper;,
        Lcom/google/android/gm/provider/MailEngine$AccountManagerOrderComparator;,
        Lcom/google/android/gm/provider/MailEngine$DatasetChangedNotifier;,
        Lcom/google/android/gm/provider/MailEngine$NormalHttpRequestRunner;,
        Lcom/google/android/gm/provider/MailEngine$MailEngineSyncObserver;,
        Lcom/google/android/gm/provider/MailEngine$AuthenticationException;,
        Lcom/google/android/gm/provider/MailEngine$MessageCursorLogic;,
        Lcom/google/android/gm/provider/MailEngine$MessageIdPair;,
        Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;,
        Lcom/google/android/gm/provider/MailEngine$ConversationCursor;,
        Lcom/google/android/gm/provider/MailEngine$CloneableMessageCursor;,
        Lcom/google/android/gm/provider/MailEngine$NetworkCursor;,
        Lcom/google/android/gm/provider/MailEngine$NetworkCursorLogic;,
        Lcom/google/android/gm/provider/MailEngine$SyncThread;,
        Lcom/google/android/gm/provider/MailEngine$PublicMailStore;,
        Lcom/google/android/gm/provider/MailEngine$SyncInfo;,
        Lcom/google/android/gm/provider/MailEngine$MailEngineContainer;,
        Lcom/google/android/gm/provider/MailEngine$MailEngineInitListener;,
        Lcom/google/android/gm/provider/MailEngine$MailEngineResultCallback;,
        Lcom/google/android/gm/provider/MailEngine$Preferences;,
        Lcom/google/android/gm/provider/MailEngine$HttpRequestRunner;,
        Lcom/google/android/gm/provider/MailEngine$ClientCreated;
    }
.end annotation


# static fields
.field private static final CLIENT_CREATED_LOCAL_LABELS:[Ljava/lang/String;

.field static final FULL_TEXT_SEARCH_TABLES:[Ljava/lang/String;

.field static final LABEL_PROJECTION_MAP:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field static final LOCAL_MESSAGE_FROM_SEARCH_COLUMNS:[Ljava/lang/String;

.field static final LOCAL_MESSAGE_TO_SEARCH_COLUMNS:[Ljava/lang/String;

.field private static final LOCAL_ONLY_CONVERSATION_QUERY_SELECTION_ARGS:[Ljava/lang/String;

.field private static final MESSAGE_COLUMN_EXTRAS:[[Ljava/lang/String;

.field private static final MESSAGE_PROJECTION_MAP:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field static final NETWORK_CURSOR_LOGIC_FETCHER_THREADS:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Thread;",
            ">;"
        }
    .end annotation
.end field

.field private static final PROJECTION_MESSAGE_SYNCED:[Ljava/lang/String;

.field private static final PROJECTION_VALUE:[Ljava/lang/String;

.field private static final PROJECTON_MESSAGE_ID_AND_CONVERSATION_ID:[Ljava/lang/String;

.field private static USER_AGENT_STRING:Ljava/lang/String;

.field static sConversationPurgeTask:Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic$PurgeStaleConversationsTask;

.field private static sMailEngineCreationHandler:Landroid/os/Handler;

.field private static sMailEngines:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/gm/provider/MailEngine$MailEngineContainer;",
            ">;"
        }
    .end annotation
.end field

.field static sNextQueryId:J

.field private static sNotifyDatasetChangedThread:Landroid/os/HandlerThread;

.field private static sTestingHttpRequestRunner:Lcom/google/android/gm/provider/MailEngine$HttpRequestRunner;

.field private static sTestingPreferences:Lcom/google/android/gm/provider/MailEngine$Preferences;


# instance fields
.field private final mAccount:Landroid/accounts/Account;

.field private final mAttachmentManager:Lcom/google/android/gm/provider/AttachmentManager;

.field private mBackgroundSyncThread:Ljava/lang/Thread;

.field private final mBackgroundSyncThreadLock:Ljava/lang/Object;

.field private final mBackgroundTaskHandler:Landroid/os/Handler;

.field private volatile mBackgroundTasksDisabledForTesting:Z

.field private mContext:Landroid/content/Context;

.field private final mConversationCursorForQueryLock:Ljava/lang/Object;

.field private final mCookieStore:Lorg/apache/http/client/CookieStore;

.field private final mDatasetChangedNotifier:Lcom/google/android/gm/provider/MailEngine$DatasetChangedNotifier;

.field mDb:Landroid/database/sqlite/SQLiteDatabase;

.field final mDbLock:Ljava/lang/Object;

.field private volatile mFakeIoException:Z

.field private mHttpClient:Lcom/google/android/common/http/GoogleHttpClient;

.field private mHttpRequestRunner:Lcom/google/android/gm/provider/MailEngine$HttpRequestRunner;

.field private mInitCallbacks:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Landroid/util/Pair",
            "<",
            "Landroid/os/Handler;",
            "Lcom/google/android/gm/provider/MailEngine$MailEngineInitListener;",
            ">;>;"
        }
    .end annotation
.end field

.field private mInitializationComplete:Z

.field private mInitializationLock:Ljava/lang/Object;

.field mInternalDb:Landroid/database/sqlite/SQLiteDatabase;

.field private volatile mIsSyncCancelled:Z

.field private volatile mIsSyncInProgress:Z

.field private mLabelMap:Lcom/google/android/gm/provider/Gmail$LabelMap;

.field private final mLabelMapObserver:Ljava/util/Observer;

.field private mLastConversationCursorLogic:Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;

.field private mLastQuery:Ljava/lang/String;

.field private mLastSyncLoopCheckTime:J

.field private volatile mLastSyncResult:I

.field private mLastSyncThreadTime:J

.field mMailCore:Lcom/google/android/gm/provider/MailCore;

.field private volatile mMailEngineClosing:Z

.field private mMailIndexRequested:Z

.field mMailStore:Lcom/google/android/gm/provider/MailStore;

.field mMailSync:Lcom/google/android/gm/provider/MailSync;

.field private final mMessageCursorLogicMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Long;",
            "Lcom/google/android/gm/provider/MailEngine$MessageCursorLogic;",
            ">;"
        }
    .end annotation
.end field

.field private final mMessageCursorLogicMapLock:Ljava/lang/Object;

.field private final mNotificationLabels:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Long;",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field

.field private mNotificationsRequestsRegistered:Z

.field mOperations:Lcom/google/android/gm/provider/Operations;

.field private final mPreferences:Lcom/google/android/gm/provider/MailEngine$Preferences;

.field mProviderChangedBroadcastWakeLock:Landroid/os/PowerManager$WakeLock;

.field private final mRemoveRefeshStatusRunnable:Ljava/lang/Runnable;

.field private final mRemoveRefreshStatusDelayMs:I

.field private final mStartAccountIndexingIntent:Landroid/app/PendingIntent;

.field private mStatus:Ljava/util/BitSet;

.field final mStatusLock:Ljava/lang/Object;

.field private mSyncCountPerPeriod:I

.field private final mSyncLock:Ljava/lang/Object;

.field private mSyncThread:Ljava/lang/Thread;

.field private final mSyncThreadLock:Ljava/lang/Object;

.field final mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

.field private final mTransactionListener:Lcom/google/android/gm/provider/GmailTransactionListener;

.field private mUrls:Lcom/google/android/gm/provider/Urls;

.field private mUserRefreshCompleted:Z

.field private mValidateSyncSets:Z


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x0

    const/4 v3, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 240
    new-array v0, v6, [Ljava/lang/String;

    const-string v1, "conversation_fts_table"

    aput-object v1, v0, v4

    const-string v1, "message_fts_table"

    aput-object v1, v0, v5

    sput-object v0, Lcom/google/android/gm/provider/MailEngine;->FULL_TEXT_SEARCH_TABLES:[Ljava/lang/String;

    .line 245
    new-array v0, v3, [Ljava/lang/String;

    const-string v1, "toAddresses"

    aput-object v1, v0, v4

    const-string v1, "ccAddresses"

    aput-object v1, v0, v5

    const-string v1, "bccAddresses"

    aput-object v1, v0, v6

    sput-object v0, Lcom/google/android/gm/provider/MailEngine;->LOCAL_MESSAGE_TO_SEARCH_COLUMNS:[Ljava/lang/String;

    .line 250
    new-array v0, v5, [Ljava/lang/String;

    const-string v1, "fromAddress"

    aput-object v1, v0, v4

    sput-object v0, Lcom/google/android/gm/provider/MailEngine;->LOCAL_MESSAGE_FROM_SEARCH_COLUMNS:[Ljava/lang/String;

    .line 296
    new-array v0, v6, [Ljava/lang/String;

    const-string v1, "messageId"

    aput-object v1, v0, v4

    const-string v1, "conversation"

    aput-object v1, v0, v5

    sput-object v0, Lcom/google/android/gm/provider/MailEngine;->PROJECTON_MESSAGE_ID_AND_CONVERSATION_ID:[Ljava/lang/String;

    .line 300
    new-array v0, v5, [Ljava/lang/String;

    const-string v1, "value"

    aput-object v1, v0, v4

    sput-object v0, Lcom/google/android/gm/provider/MailEngine;->PROJECTION_VALUE:[Ljava/lang/String;

    .line 301
    new-array v0, v5, [Ljava/lang/String;

    const-string v1, "synced"

    aput-object v1, v0, v4

    sput-object v0, Lcom/google/android/gm/provider/MailEngine;->PROJECTION_MESSAGE_SYNCED:[Ljava/lang/String;

    .line 303
    new-array v0, v5, [Ljava/lang/String;

    const-string v1, "SELECTION_ARGUMENT_DO_NOT_BECOME_ACTIVE_NETWORK_CURSOR"

    aput-object v1, v0, v4

    sput-object v0, Lcom/google/android/gm/provider/MailEngine;->LOCAL_ONLY_CONVERSATION_QUERY_SELECTION_ARGS:[Ljava/lang/String;

    .line 321
    sput-object v7, Lcom/google/android/gm/provider/MailEngine;->USER_AGENT_STRING:Ljava/lang/String;

    .line 340
    const/16 v0, 0x8

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "^^cached"

    aput-object v1, v0, v4

    const-string v1, "^^out"

    aput-object v1, v0, v5

    const-string v1, "^imi"

    aput-object v1, v0, v6

    const-string v1, "^imn"

    aput-object v1, v0, v3

    const/4 v1, 0x4

    const-string v2, "^im"

    aput-object v2, v0, v1

    const/4 v1, 0x5

    const-string v2, "^io_ns"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "^^important"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "^^unimportant"

    aput-object v2, v0, v1

    sput-object v0, Lcom/google/android/gm/provider/MailEngine;->CLIENT_CREATED_LOCAL_LABELS:[Ljava/lang/String;

    .line 508
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/MailEngine;->NETWORK_CURSOR_LOGIC_FETCHER_THREADS:Ljava/util/Set;

    .line 524
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/MailEngine;->sMailEngines:Ljava/util/Map;

    .line 528
    sput-object v7, Lcom/google/android/gm/provider/MailEngine;->sMailEngineCreationHandler:Landroid/os/Handler;

    .line 537
    const/16 v0, 0x13

    new-array v0, v0, [[Ljava/lang/String;

    new-array v1, v5, [Ljava/lang/String;

    const-string v2, "clientCreated"

    aput-object v2, v1, v4

    aput-object v1, v0, v4

    new-array v1, v5, [Ljava/lang/String;

    const-string v2, "synced"

    aput-object v2, v1, v4

    aput-object v1, v0, v5

    new-array v1, v5, [Ljava/lang/String;

    const-string v2, "queryId"

    aput-object v2, v1, v4

    aput-object v1, v0, v6

    new-array v1, v6, [Ljava/lang/String;

    const-string v2, "_id"

    aput-object v2, v1, v4

    const-string v2, "messages._id"

    aput-object v2, v1, v5

    aput-object v1, v0, v3

    const/4 v1, 0x4

    new-array v2, v6, [Ljava/lang/String;

    const-string v3, "conversation"

    aput-object v3, v2, v4

    const-string v3, "messages.conversation"

    aput-object v3, v2, v5

    aput-object v2, v0, v1

    const/4 v1, 0x5

    new-array v2, v6, [Ljava/lang/String;

    const-string v3, "subject"

    aput-object v3, v2, v4

    const-string v3, "messages.subject"

    aput-object v3, v2, v5

    aput-object v2, v0, v1

    const/4 v1, 0x6

    new-array v2, v6, [Ljava/lang/String;

    const-string v3, "snippet"

    aput-object v3, v2, v4

    const-string v3, "messages.snippet"

    aput-object v3, v2, v5

    aput-object v2, v0, v1

    const/4 v1, 0x7

    new-array v2, v6, [Ljava/lang/String;

    const-string v3, "fromAddress"

    aput-object v3, v2, v4

    const-string v3, "messages.fromAddress"

    aput-object v3, v2, v5

    aput-object v2, v0, v1

    const/16 v1, 0x8

    new-array v2, v6, [Ljava/lang/String;

    const-string v3, "toAddresses"

    aput-object v3, v2, v4

    const-string v3, "messages.toAddresses"

    aput-object v3, v2, v5

    aput-object v2, v0, v1

    const/16 v1, 0x9

    new-array v2, v6, [Ljava/lang/String;

    const-string v3, "ccAddresses"

    aput-object v3, v2, v4

    const-string v3, "messages.ccAddresses"

    aput-object v3, v2, v5

    aput-object v2, v0, v1

    const/16 v1, 0xa

    new-array v2, v6, [Ljava/lang/String;

    const-string v3, "bccAddresses"

    aput-object v3, v2, v4

    const-string v3, "messages.bccAddresses"

    aput-object v3, v2, v5

    aput-object v2, v0, v1

    const/16 v1, 0xb

    new-array v2, v6, [Ljava/lang/String;

    const-string v3, "body"

    aput-object v3, v2, v4

    const-string v3, "CASE WHEN bodyCompressed IS NULL THEN \'0\' || messages.body ELSE \'1\' || bodyCompressed END"

    aput-object v3, v2, v5

    aput-object v2, v0, v1

    const/16 v1, 0xc

    new-array v2, v6, [Ljava/lang/String;

    const-string v3, "labelIds"

    aput-object v3, v2, v4

    const-string v3, "group_concat(labels_id, \' \')"

    aput-object v3, v2, v5

    aput-object v2, v0, v1

    const/16 v1, 0xd

    new-array v2, v6, [Ljava/lang/String;

    const-string v3, "labelCount"

    aput-object v3, v2, v4

    const-string v3, "COUNT(*)"

    aput-object v3, v2, v5

    aput-object v2, v0, v1

    const/16 v1, 0xe

    new-array v2, v6, [Ljava/lang/String;

    const-string v3, "messageLabels"

    aput-object v3, v2, v4

    const-string v3, "group_concat((labels._id || \'^*^\' || labels.canonicalName || \'^*^\' || (CASE labels.canonicalName    WHEN \'^f\' THEN ?    WHEN \'^^out\' THEN ?    WHEN \'^i\' THEN ?    WHEN \'^r\' THEN ?    WHEN \'^b\' THEN ?    WHEN \'^all\' THEN ?    WHEN \'^u\' THEN ?    WHEN \'^k\' THEN ?    WHEN \'^s\' THEN ?    WHEN \'^t\' THEN ?    WHEN \'^g\' THEN ?    WHEN \'^io_im\' THEN ?    WHEN \'^iim\' THEN ?    ELSE labels.name END)  || \'^*^\' || labels.color || \'^*^\' || labels.hidden), \'^**^\')"

    aput-object v3, v2, v5

    aput-object v2, v0, v1

    const/16 v1, 0xf

    new-array v2, v6, [Ljava/lang/String;

    const-string v3, "isStarred"

    aput-object v3, v2, v4

    const-string v3, "SUM(CASE labels.canonicalName WHEN \'^t\' THEN 1 ELSE 0 END)"

    aput-object v3, v2, v5

    aput-object v2, v0, v1

    const/16 v1, 0x10

    new-array v2, v6, [Ljava/lang/String;

    const-string v3, "isDraft"

    aput-object v3, v2, v4

    const-string v3, "SUM(CASE labels.canonicalName WHEN \'^r\' THEN 1 ELSE 0 END)"

    aput-object v3, v2, v5

    aput-object v2, v0, v1

    const/16 v1, 0x11

    new-array v2, v6, [Ljava/lang/String;

    const-string v3, "isInOutbox"

    aput-object v3, v2, v4

    const-string v3, "SUM(CASE labels.canonicalName WHEN \'^^out\' THEN 1 ELSE 0 END)"

    aput-object v3, v2, v5

    aput-object v2, v0, v1

    const/16 v1, 0x12

    new-array v2, v6, [Ljava/lang/String;

    const-string v3, "isUnread"

    aput-object v3, v2, v4

    const-string v3, "SUM(CASE labels.canonicalName WHEN \'^u\' THEN 1 ELSE 0 END)"

    aput-object v3, v2, v5

    aput-object v2, v0, v1

    sput-object v0, Lcom/google/android/gm/provider/MailEngine;->MESSAGE_COLUMN_EXTRAS:[[Ljava/lang/String;

    .line 584
    new-instance v0, Lcom/google/android/gm/provider/ProjectionMapBuilder;

    invoke-direct {v0}, Lcom/google/android/gm/provider/ProjectionMapBuilder;-><init>()V

    sget-object v1, Lcom/google/android/gm/provider/Gmail;->MESSAGE_PROJECTION:[Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/google/android/gm/provider/ProjectionMapBuilder;->addIdentities([Ljava/lang/String;)Lcom/google/android/gm/provider/ProjectionMapBuilder;

    move-result-object v0

    sget-object v1, Lcom/google/android/gm/provider/MailEngine;->MESSAGE_COLUMN_EXTRAS:[[Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/google/android/gm/provider/ProjectionMapBuilder;->addTransformations([[Ljava/lang/String;)Lcom/google/android/gm/provider/ProjectionMapBuilder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gm/provider/ProjectionMapBuilder;->getMap()Ljava/util/Map;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/MailEngine;->MESSAGE_PROJECTION_MAP:Ljava/util/Map;

    .line 589
    new-instance v0, Lcom/google/android/gm/provider/ProjectionMapBuilder;

    invoke-direct {v0}, Lcom/google/android/gm/provider/ProjectionMapBuilder;-><init>()V

    sget-object v1, Lcom/google/android/gm/provider/Gmail;->LABEL_PROJECTION:[Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/google/android/gm/provider/ProjectionMapBuilder;->addIdentities([Ljava/lang/String;)Lcom/google/android/gm/provider/ProjectionMapBuilder;

    move-result-object v0

    const-string v1, "name"

    const-string v2, "(CASE labels.canonicalName    WHEN \'^f\' THEN ?    WHEN \'^^out\' THEN ?    WHEN \'^i\' THEN ?    WHEN \'^r\' THEN ?    WHEN \'^b\' THEN ?    WHEN \'^all\' THEN ?    WHEN \'^u\' THEN ?    WHEN \'^k\' THEN ?    WHEN \'^s\' THEN ?    WHEN \'^t\' THEN ?    WHEN \'^g\' THEN ?    WHEN \'^io_im\' THEN ?    WHEN \'^iim\' THEN ?    ELSE labels.name END) "

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gm/provider/ProjectionMapBuilder;->add(Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gm/provider/ProjectionMapBuilder;

    move-result-object v0

    const-string v1, "sortOrder"

    const-string v2, "CASE labels.systemLabel WHEN 0 THEN labels.canonicalName ELSE labels.systemLabelOrder END"

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gm/provider/ProjectionMapBuilder;->add(Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gm/provider/ProjectionMapBuilder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gm/provider/ProjectionMapBuilder;->getMap()Ljava/util/Map;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/MailEngine;->LABEL_PROJECTION_MAP:Ljava/util/Map;

    .line 5681
    const-wide/16 v0, 0x1

    sput-wide v0, Lcom/google/android/gm/provider/MailEngine;->sNextQueryId:J

    .line 5682
    sput-object v7, Lcom/google/android/gm/provider/MailEngine;->sConversationPurgeTask:Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic$PurgeStaleConversationsTask;

    return-void
.end method

.method private constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 13
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "account"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    const/4 v12, 0x0

    .line 948
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 361
    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mBackgroundSyncThreadLock:Ljava/lang/Object;

    .line 362
    iput-boolean v12, p0, Lcom/google/android/gm/provider/MailEngine;->mBackgroundTasksDisabledForTesting:Z

    .line 363
    iput-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mBackgroundSyncThread:Ljava/lang/Thread;

    .line 369
    iput-boolean v12, p0, Lcom/google/android/gm/provider/MailEngine;->mValidateSyncSets:Z

    .line 381
    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mDbLock:Ljava/lang/Object;

    .line 383
    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mStatusLock:Ljava/lang/Object;

    .line 384
    new-instance v0, Ljava/util/BitSet;

    invoke-direct {v0}, Ljava/util/BitSet;-><init>()V

    iput-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mStatus:Ljava/util/BitSet;

    .line 385
    iput v12, p0, Lcom/google/android/gm/provider/MailEngine;->mLastSyncResult:I

    .line 396
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mNotificationLabels:Ljava/util/Map;

    .line 413
    iput-boolean v12, p0, Lcom/google/android/gm/provider/MailEngine;->mInitializationComplete:Z

    .line 423
    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mInitializationLock:Ljava/lang/Object;

    .line 434
    iput v12, p0, Lcom/google/android/gm/provider/MailEngine;->mSyncCountPerPeriod:I

    .line 439
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/google/android/gm/provider/MailEngine;->mLastSyncLoopCheckTime:J

    .line 444
    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mSyncLock:Ljava/lang/Object;

    .line 449
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/google/android/gm/provider/MailEngine;->mLastSyncThreadTime:J

    .line 454
    iput-boolean v12, p0, Lcom/google/android/gm/provider/MailEngine;->mMailIndexRequested:Z

    .line 459
    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mSyncThreadLock:Ljava/lang/Object;

    .line 461
    iput-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mSyncThread:Ljava/lang/Thread;

    .line 463
    new-instance v0, Lcom/google/android/gm/provider/MailEngine$1;

    invoke-direct {v0, p0}, Lcom/google/android/gm/provider/MailEngine$1;-><init>(Lcom/google/android/gm/provider/MailEngine;)V

    iput-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mLabelMapObserver:Ljava/util/Observer;

    .line 484
    new-instance v0, Lcom/google/android/gm/provider/MailEngine$2;

    invoke-direct {v0, p0}, Lcom/google/android/gm/provider/MailEngine$2;-><init>(Lcom/google/android/gm/provider/MailEngine;)V

    iput-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mRemoveRefeshStatusRunnable:Ljava/lang/Runnable;

    .line 502
    iput-boolean v12, p0, Lcom/google/android/gm/provider/MailEngine;->mMailEngineClosing:Z

    .line 526
    iput-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mProviderChangedBroadcastWakeLock:Landroid/os/PowerManager$WakeLock;

    .line 1152
    iput-boolean v12, p0, Lcom/google/android/gm/provider/MailEngine;->mNotificationsRequestsRegistered:Z

    .line 1264
    iput-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mLabelMap:Lcom/google/android/gm/provider/Gmail$LabelMap;

    .line 2152
    iput-boolean v12, p0, Lcom/google/android/gm/provider/MailEngine;->mFakeIoException:Z

    .line 2219
    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mConversationCursorForQueryLock:Ljava/lang/Object;

    .line 2220
    iput-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mLastQuery:Ljava/lang/String;

    .line 2221
    iput-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mLastConversationCursorLogic:Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;

    .line 6313
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mMessageCursorLogicMap:Ljava/util/Map;

    .line 6314
    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mMessageCursorLogicMapLock:Ljava/lang/Object;

    .line 949
    new-instance v8, Landroid/os/HandlerThread;

    const-string v0, "Background tasks"

    const/16 v1, 0xa

    invoke-direct {v8, v0, v1}, Landroid/os/HandlerThread;-><init>(Ljava/lang/String;I)V

    .line 951
    .local v8, "handlerThread":Landroid/os/HandlerThread;
    invoke-virtual {v8}, Landroid/os/HandlerThread;->start()V

    .line 953
    const-string v0, "ME.constructor"

    invoke-static {v0}, Lcom/google/android/gm/perf/Timer;->startTiming(Ljava/lang/String;)V

    .line 955
    new-instance v0, Landroid/os/Handler;

    invoke-virtual {v8}, Landroid/os/HandlerThread;->getLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mBackgroundTaskHandler:Landroid/os/Handler;

    .line 958
    :try_start_0
    iput-object p1, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    .line 959
    new-instance v0, Landroid/accounts/Account;

    const-string v1, "com.google"

    invoke-direct {v0, p2, v1}, Landroid/accounts/Account;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    .line 960
    new-instance v0, Lcom/google/android/gm/provider/Urls;

    invoke-direct {v0, p2}, Lcom/google/android/gm/provider/Urls;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mUrls:Lcom/google/android/gm/provider/Urls;

    .line 961
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    invoke-static {p2}, Lcom/google/android/gm/provider/MailEngine;->getInternalDbName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/google/android/gm/provider/MailEngine;->openInternalDatabase(Landroid/content/Context;Ljava/lang/String;)V

    .line 962
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    invoke-static {p2}, Lcom/google/android/gm/provider/MailEngine;->getDbName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/google/android/gm/provider/MailEngine;->openDatabase(Landroid/content/Context;Ljava/lang/String;)V

    .line 963
    new-instance v0, Lcom/google/android/gm/provider/TransactionHelper;

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-direct {v0, v1}, Lcom/google/android/gm/provider/TransactionHelper;-><init>(Landroid/database/sqlite/SQLiteDatabase;)V

    iput-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    .line 964
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/TransactionHelper;->beginTransactionNonExclusive()V
    :try_end_0
    .catch Landroid/database/SQLException; {:try_start_0 .. :try_end_0} :catch_0

    .line 966
    :try_start_1
    invoke-direct {p0}, Lcom/google/android/gm/provider/MailEngine;->initialize()V

    .line 967
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/TransactionHelper;->setTransactionSuccessful()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 969
    :try_start_2
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    .line 972
    new-instance v0, Lcom/google/android/gm/provider/GmailTransactionListener;

    invoke-direct {v0, p1, p0, p2}, Lcom/google/android/gm/provider/GmailTransactionListener;-><init>(Landroid/content/Context;Lcom/google/android/gm/provider/MailEngine;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mTransactionListener:Lcom/google/android/gm/provider/GmailTransactionListener;

    .line 974
    new-instance v0, Lorg/apache/http/impl/client/BasicCookieStore;

    invoke-direct {v0}, Lorg/apache/http/impl/client/BasicCookieStore;-><init>()V

    iput-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mCookieStore:Lorg/apache/http/client/CookieStore;

    .line 976
    sget-object v0, Lcom/google/android/gm/provider/MailEngine;->sTestingHttpRequestRunner:Lcom/google/android/gm/provider/MailEngine$HttpRequestRunner;

    if-nez v0, :cond_3

    .line 977
    new-instance v0, Lcom/google/android/gm/provider/MailEngine$NormalHttpRequestRunner;

    invoke-direct {v0}, Lcom/google/android/gm/provider/MailEngine$NormalHttpRequestRunner;-><init>()V

    iput-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mHttpRequestRunner:Lcom/google/android/gm/provider/MailEngine$HttpRequestRunner;

    .line 982
    :goto_0
    sget-object v0, Lcom/google/android/gm/provider/MailEngine;->sTestingPreferences:Lcom/google/android/gm/provider/MailEngine$Preferences;

    if-nez v0, :cond_4

    .line 984
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/google/android/gm/persistence/Persistence;->getMailEnginePreferences(Landroid/content/Context;)Lcom/google/android/gm/persistence/Persistence$MailEnginePreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mPreferences:Lcom/google/android/gm/provider/MailEngine$Preferences;
    :try_end_2
    .catch Landroid/database/SQLException; {:try_start_2 .. :try_end_2} :catch_0

    .line 995
    :goto_1
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/MailEngine;->enqueueFinalInitializationTask(Landroid/content/Context;)V

    .line 996
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/MailEngine;->enqueueCleanupTempFilesTask(Landroid/content/Context;)V

    .line 1000
    new-instance v0, Lcom/google/android/gm/provider/AttachmentManager;

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    iget-object v2, v2, Landroid/accounts/Account;->name:Ljava/lang/String;

    iget-object v3, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine;->mUrls:Lcom/google/android/gm/provider/Urls;

    move-object v5, p0

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gm/provider/AttachmentManager;-><init>(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;Lcom/google/android/gm/provider/Urls;Lcom/google/android/gm/provider/AttachmentManager$RestrictedMailEngine;)V

    iput-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mAttachmentManager:Lcom/google/android/gm/provider/AttachmentManager;

    .line 1002
    const/4 v10, 0x0

    .line 1004
    .local v10, "pendingIntent":Landroid/app/PendingIntent;
    :try_start_3
    new-instance v9, Landroid/content/Intent;

    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    const-class v1, Lcom/google/android/gm/provider/MailIndexerService;

    invoke-direct {v9, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1005
    .local v9, "indexIntent":Landroid/content/Intent;
    const-string v0, "com.google.android.gm.intent.provider.INDEX_MESSAGE_CONTENT"

    invoke-virtual {v9, v0}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 1006
    invoke-static {p2}, Lcom/google/android/gm/provider/Gmail;->getBaseUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    const-string v1, "indexer"

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->appendPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v6

    .line 1008
    .local v6, "builder":Landroid/net/Uri$Builder;
    invoke-virtual {v6}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v9, v0}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 1009
    const-string v0, "account"

    invoke-virtual {v9, v0, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1012
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    const/4 v1, 0x0

    const/high16 v2, 0x8000000

    invoke-static {v0, v1, v9, v2}, Landroid/app/PendingIntent;->getService(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    :try_end_3
    .catch Ljava/lang/UnsupportedOperationException; {:try_start_3 .. :try_end_3} :catch_1

    move-result-object v10

    .line 1021
    .end local v6    # "builder":Landroid/net/Uri$Builder;
    .end local v9    # "indexIntent":Landroid/content/Intent;
    :goto_2
    iput-object v10, p0, Lcom/google/android/gm/provider/MailEngine;->mStartAccountIndexingIntent:Landroid/app/PendingIntent;

    .line 1022
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    .line 1023
    .local v11, "res":Landroid/content/res/Resources;
    new-instance v0, Lcom/google/android/gm/provider/MailEngine$DatasetChangedNotifier;

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    const v2, 0x7f0a001f

    invoke-virtual {v11, v2}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v2

    invoke-direct {v0, p0, v1, v2}, Lcom/google/android/gm/provider/MailEngine$DatasetChangedNotifier;-><init>(Lcom/google/android/gm/provider/MailEngine;Landroid/content/Context;I)V

    iput-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mDatasetChangedNotifier:Lcom/google/android/gm/provider/MailEngine$DatasetChangedNotifier;

    .line 1025
    const v0, 0x7f0a003f

    invoke-virtual {v11, v0}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/MailEngine;->mRemoveRefreshStatusDelayMs:I

    .line 1026
    return-void

    .line 969
    .end local v10    # "pendingIntent":Landroid/app/PendingIntent;
    .end local v11    # "res":Landroid/content/res/Resources;
    :catchall_0
    move-exception v0

    :try_start_4
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    throw v0
    :try_end_4
    .catch Landroid/database/SQLException; {:try_start_4 .. :try_end_4} :catch_0

    .line 988
    :catch_0
    move-exception v7

    .line 989
    .local v7, "e":Landroid/database/SQLException;
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->close()V

    .line 990
    :cond_0
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mInternalDb:Landroid/database/sqlite/SQLiteDatabase;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mInternalDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->close()V

    .line 991
    :cond_1
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mHttpClient:Lcom/google/android/common/http/GoogleHttpClient;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mHttpClient:Lcom/google/android/common/http/GoogleHttpClient;

    invoke-virtual {v0}, Lcom/google/android/common/http/GoogleHttpClient;->close()V

    .line 992
    :cond_2
    throw v7

    .line 979
    .end local v7    # "e":Landroid/database/SQLException;
    :cond_3
    :try_start_5
    sget-object v0, Lcom/google/android/gm/provider/MailEngine;->sTestingHttpRequestRunner:Lcom/google/android/gm/provider/MailEngine$HttpRequestRunner;

    iput-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mHttpRequestRunner:Lcom/google/android/gm/provider/MailEngine$HttpRequestRunner;

    goto/16 :goto_0

    .line 986
    :cond_4
    sget-object v0, Lcom/google/android/gm/provider/MailEngine;->sTestingPreferences:Lcom/google/android/gm/provider/MailEngine$Preferences;

    iput-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mPreferences:Lcom/google/android/gm/provider/MailEngine$Preferences;
    :try_end_5
    .catch Landroid/database/SQLException; {:try_start_5 .. :try_end_5} :catch_0

    goto/16 :goto_1

    .line 1014
    .restart local v10    # "pendingIntent":Landroid/app/PendingIntent;
    :catch_1
    move-exception v7

    .line 1019
    .local v7, "e":Ljava/lang/UnsupportedOperationException;
    const-string v0, "Gmail"

    const-string v1, "UOE while creating pending intent.  Probably running tests"

    new-array v2, v12, [Ljava/lang/Object;

    invoke-static {v0, v7, v1, v2}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_2
.end method

.method static synthetic access$000(Lcom/google/android/gm/provider/MailEngine;)Lcom/google/android/gm/provider/Gmail$LabelMap;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;

    .prologue
    .line 124
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mLabelMap:Lcom/google/android/gm/provider/Gmail$LabelMap;

    return-object v0
.end method

.method static synthetic access$100(Lcom/google/android/gm/provider/MailEngine;)V
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;

    .prologue
    .line 124
    invoke-direct {p0}, Lcom/google/android/gm/provider/MailEngine;->notifyStatusChange()V

    return-void
.end method

.method static synthetic access$1000(Lcom/google/android/gm/provider/MailEngine;)Landroid/database/Cursor;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;

    .prologue
    .line 124
    invoke-direct {p0}, Lcom/google/android/gm/provider/MailEngine;->getCursorForReplyFromDefaultAddress()Landroid/database/Cursor;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$1100(Lcom/google/android/gm/provider/MailEngine;)V
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;

    .prologue
    .line 124
    invoke-direct {p0}, Lcom/google/android/gm/provider/MailEngine;->notifyInitializationComplete()V

    return-void
.end method

.method static synthetic access$1200(Lcom/google/android/gm/provider/MailEngine;)Lcom/google/android/gm/provider/AttachmentManager;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;

    .prologue
    .line 124
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mAttachmentManager:Lcom/google/android/gm/provider/AttachmentManager;

    return-object v0
.end method

.method static synthetic access$1300(Lcom/google/android/gm/provider/MailEngine;)Ljava/util/Map;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;

    .prologue
    .line 124
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mNotificationLabels:Ljava/util/Map;

    return-object v0
.end method

.method static synthetic access$1400(Lcom/google/android/gm/provider/MailEngine;Ljava/util/Set;)V
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;
    .param p1, "x1"    # Ljava/util/Set;

    .prologue
    .line 124
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/MailEngine;->broadcastLabelNotifications(Ljava/util/Set;)V

    return-void
.end method

.method static synthetic access$1700(Lcom/google/android/gm/provider/MailEngine;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 124
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/MailEngine;->wipeAndResync(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$1800(Lcom/google/android/gm/provider/MailEngine;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Ljava/lang/String;

    .prologue
    .line 124
    invoke-direct {p0, p1, p2}, Lcom/google/android/gm/provider/MailEngine;->setSyncSetting(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$1900(Lcom/google/android/gm/provider/MailEngine;)V
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;

    .prologue
    .line 124
    invoke-direct {p0}, Lcom/google/android/gm/provider/MailEngine;->updateMailCoreConfig()V

    return-void
.end method

.method static synthetic access$200(Lcom/google/android/gm/provider/MailEngine;)Z
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;

    .prologue
    .line 124
    iget-boolean v0, p0, Lcom/google/android/gm/provider/MailEngine;->mUserRefreshCompleted:Z

    return v0
.end method

.method static synthetic access$2000(Lcom/google/android/gm/provider/MailEngine;JLcom/google/android/gm/provider/MailSync$SyncRationale;ZZ)V
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;
    .param p1, "x1"    # J
    .param p3, "x2"    # Lcom/google/android/gm/provider/MailSync$SyncRationale;
    .param p4, "x3"    # Z
    .param p5, "x4"    # Z

    .prologue
    .line 124
    invoke-direct/range {p0 .. p5}, Lcom/google/android/gm/provider/MailEngine;->onConversationChanged(JLcom/google/android/gm/provider/MailSync$SyncRationale;ZZ)V

    return-void
.end method

.method static synthetic access$202(Lcom/google/android/gm/provider/MailEngine;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;
    .param p1, "x1"    # Z

    .prologue
    .line 124
    iput-boolean p1, p0, Lcom/google/android/gm/provider/MailEngine;->mUserRefreshCompleted:Z

    return p1
.end method

.method static synthetic access$2100(Lcom/google/android/gm/provider/MailEngine;Landroid/database/Cursor;Z)Lcom/google/android/gm/provider/MailSync$Message;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;
    .param p1, "x1"    # Landroid/database/Cursor;
    .param p2, "x2"    # Z

    .prologue
    .line 124
    invoke-direct {p0, p1, p2}, Lcom/google/android/gm/provider/MailEngine;->getMessageFromCursor(Landroid/database/Cursor;Z)Lcom/google/android/gm/provider/MailSync$Message;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$2200(Lcom/google/android/gm/provider/MailEngine;Lcom/google/android/gm/provider/MailCore$Label;)Z
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;
    .param p1, "x1"    # Lcom/google/android/gm/provider/MailCore$Label;

    .prologue
    .line 124
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/MailEngine;->addNotificationLabel(Lcom/google/android/gm/provider/MailCore$Label;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$2300(Lcom/google/android/gm/provider/MailEngine;)Landroid/content/Context;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;

    .prologue
    .line 124
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$2400(Lcom/google/android/gm/provider/MailEngine;)Lcom/google/android/gm/provider/MailEngine$Preferences;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;

    .prologue
    .line 124
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mPreferences:Lcom/google/android/gm/provider/MailEngine$Preferences;

    return-object v0
.end method

.method static synthetic access$2500(Lcom/google/android/gm/provider/MailSync$Message;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailSync$Message;

    .prologue
    .line 124
    invoke-static {p0}, Lcom/google/android/gm/provider/MailEngine;->joinedAttachmentsString(Lcom/google/android/gm/provider/MailSync$Message;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$2700(Lcom/google/android/gm/provider/MailEngine;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 124
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/MailEngine;->cleanupAttachments(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$2800(Lcom/google/android/gm/provider/MailEngine;Landroid/content/ContentValues;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;
    .param p1, "x1"    # Landroid/content/ContentValues;
    .param p2, "x2"    # Ljava/lang/String;

    .prologue
    .line 124
    invoke-direct {p0, p1, p2}, Lcom/google/android/gm/provider/MailEngine;->updateCachedAttachmentReferences(Landroid/content/ContentValues;Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$2900(Lcom/google/android/gm/provider/MailEngine;)V
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;

    .prologue
    .line 124
    invoke-direct {p0}, Lcom/google/android/gm/provider/MailEngine;->requestIndex()V

    return-void
.end method

.method static synthetic access$300(Lcom/google/android/gm/provider/MailEngine;I)V
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;
    .param p1, "x1"    # I

    .prologue
    .line 124
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/MailEngine;->setLastSyncResult(I)V

    return-void
.end method

.method static synthetic access$3000(Lcom/google/android/gm/provider/MailEngine;)Z
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;

    .prologue
    .line 124
    iget-boolean v0, p0, Lcom/google/android/gm/provider/MailEngine;->mIsSyncInProgress:Z

    return v0
.end method

.method static synthetic access$3002(Lcom/google/android/gm/provider/MailEngine;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;
    .param p1, "x1"    # Z

    .prologue
    .line 124
    iput-boolean p1, p0, Lcom/google/android/gm/provider/MailEngine;->mIsSyncInProgress:Z

    return p1
.end method

.method static synthetic access$3100(Lcom/google/android/gm/provider/MailEngine;)Ljava/lang/Thread;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;

    .prologue
    .line 124
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mSyncThread:Ljava/lang/Thread;

    return-object v0
.end method

.method static synthetic access$3102(Lcom/google/android/gm/provider/MailEngine;Ljava/lang/Thread;)Ljava/lang/Thread;
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;
    .param p1, "x1"    # Ljava/lang/Thread;

    .prologue
    .line 124
    iput-object p1, p0, Lcom/google/android/gm/provider/MailEngine;->mSyncThread:Ljava/lang/Thread;

    return-object p1
.end method

.method static synthetic access$3200(Lcom/google/android/gm/provider/MailEngine;)Ljava/lang/Object;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;

    .prologue
    .line 124
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mSyncLock:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic access$3300(Lcom/google/android/gm/provider/MailEngine;Lcom/google/android/gm/provider/MailEngine$MailEngineSyncObserver;ZLcom/google/android/gm/provider/MailEngine$SyncInfo;Landroid/content/SyncResult;Landroid/os/Bundle;)Z
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;
    .param p1, "x1"    # Lcom/google/android/gm/provider/MailEngine$MailEngineSyncObserver;
    .param p2, "x2"    # Z
    .param p3, "x3"    # Lcom/google/android/gm/provider/MailEngine$SyncInfo;
    .param p4, "x4"    # Landroid/content/SyncResult;
    .param p5, "x5"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/google/android/gm/provider/MailEngine$AuthenticationException;,
            Lcom/google/android/gm/provider/MailSync$ResponseParseException;
        }
    .end annotation

    .prologue
    .line 124
    invoke-direct/range {p0 .. p5}, Lcom/google/android/gm/provider/MailEngine;->runSyncLoop(Lcom/google/android/gm/provider/MailEngine$MailEngineSyncObserver;ZLcom/google/android/gm/provider/MailEngine$SyncInfo;Landroid/content/SyncResult;Landroid/os/Bundle;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$3400(Lcom/google/android/gm/provider/MailEngine;)Ljava/lang/Object;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;

    .prologue
    .line 124
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mSyncThreadLock:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic access$3500(Lcom/google/android/gm/provider/MailEngine;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;
    .param p1, "x1"    # Z

    .prologue
    .line 124
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/MailEngine;->notifyDatasetChanged(Z)V

    return-void
.end method

.method static synthetic access$3600(Lcom/google/android/gm/provider/MailEngine;)Z
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;

    .prologue
    .line 124
    iget-boolean v0, p0, Lcom/google/android/gm/provider/MailEngine;->mMailEngineClosing:Z

    return v0
.end method

.method static synthetic access$3700(Lcom/google/android/gm/provider/MailEngine;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;

    .prologue
    .line 124
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mLastQuery:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$3702(Lcom/google/android/gm/provider/MailEngine;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 124
    iput-object p1, p0, Lcom/google/android/gm/provider/MailEngine;->mLastQuery:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$400(Lcom/google/android/gm/provider/MailEngine;IZ)V
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;
    .param p1, "x1"    # I
    .param p2, "x2"    # Z

    .prologue
    .line 124
    invoke-direct {p0, p1, p2}, Lcom/google/android/gm/provider/MailEngine;->changeTaskState(IZ)V

    return-void
.end method

.method static synthetic access$4002(Lcom/google/android/gm/provider/MailEngine;Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;)Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;
    .param p1, "x1"    # Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;

    .prologue
    .line 124
    iput-object p1, p0, Lcom/google/android/gm/provider/MailEngine;->mLastConversationCursorLogic:Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;

    return-object p1
.end method

.method static synthetic access$4100(Lcom/google/android/gm/provider/MailEngine;)J
    .locals 2
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;

    .prologue
    .line 124
    iget-wide v0, p0, Lcom/google/android/gm/provider/MailEngine;->mLastSyncThreadTime:J

    return-wide v0
.end method

.method static synthetic access$4102(Lcom/google/android/gm/provider/MailEngine;J)J
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;
    .param p1, "x1"    # J

    .prologue
    .line 124
    iput-wide p1, p0, Lcom/google/android/gm/provider/MailEngine;->mLastSyncThreadTime:J

    return-wide p1
.end method

.method static synthetic access$4200(Lcom/google/android/gm/provider/MailEngine;Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;
    .param p1, "x1"    # Lorg/apache/http/client/methods/HttpUriRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/google/android/gm/provider/MailEngine$AuthenticationException;
        }
    .end annotation

    .prologue
    .line 124
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/MailEngine;->runHttpRequest(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$4300(Lcom/google/android/gm/provider/MailEngine;)V
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;

    .prologue
    .line 124
    invoke-direct {p0}, Lcom/google/android/gm/provider/MailEngine;->cancelSyncForLiveRequest()V

    return-void
.end method

.method static synthetic access$4402(Lcom/google/android/gm/provider/MailEngine;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;
    .param p1, "x1"    # Z

    .prologue
    .line 124
    iput-boolean p1, p0, Lcom/google/android/gm/provider/MailEngine;->mIsSyncCancelled:Z

    return p1
.end method

.method static synthetic access$4500(Lcom/google/android/gm/provider/MailEngine;)Ljava/lang/Object;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;

    .prologue
    .line 124
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mMessageCursorLogicMapLock:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic access$4600(Lcom/google/android/gm/provider/MailEngine;)Ljava/util/Map;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;

    .prologue
    .line 124
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mMessageCursorLogicMap:Ljava/util/Map;

    return-object v0
.end method

.method static synthetic access$4700(Lcom/google/android/gm/provider/MailEngine;)Z
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;

    .prologue
    .line 124
    invoke-direct {p0}, Lcom/google/android/gm/provider/MailEngine;->purgeSomeStaleMessagesInTransaction()Z

    move-result v0

    return v0
.end method

.method static synthetic access$4800(Lcom/google/android/gm/provider/MailEngine;)V
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;

    .prologue
    .line 124
    invoke-direct {p0}, Lcom/google/android/gm/provider/MailEngine;->startIndexingIfNeeded()V

    return-void
.end method

.method static synthetic access$4900()Landroid/os/Looper;
    .locals 1

    .prologue
    .line 124
    invoke-static {}, Lcom/google/android/gm/provider/MailEngine;->getNotifyDatasetChangedLooper()Landroid/os/Looper;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$500(Lcom/google/android/gm/provider/MailEngine;)Lcom/google/android/gm/provider/GmailTransactionListener;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;

    .prologue
    .line 124
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mTransactionListener:Lcom/google/android/gm/provider/GmailTransactionListener;

    return-object v0
.end method

.method static synthetic access$600(Lcom/google/android/gm/provider/MailEngine;)V
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;

    .prologue
    .line 124
    invoke-direct {p0}, Lcom/google/android/gm/provider/MailEngine;->onLabelsPossiblyLoaded()V

    return-void
.end method

.method static synthetic access$700(Lcom/google/android/gm/provider/MailEngine;)V
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;

    .prologue
    .line 124
    invoke-direct {p0}, Lcom/google/android/gm/provider/MailEngine;->calculateUnknownSyncRationalesAndPurgeInBackground()V

    return-void
.end method

.method static synthetic access$800(Lcom/google/android/gm/provider/MailEngine;)Landroid/accounts/Account;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;

    .prologue
    .line 124
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    return-object v0
.end method

.method static synthetic access$900(Lcom/google/android/gm/provider/MailEngine;)Landroid/database/Cursor;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine;

    .prologue
    .line 124
    invoke-direct {p0}, Lcom/google/android/gm/provider/MailEngine;->getCursorForCustomLabelColors()Landroid/database/Cursor;

    move-result-object v0

    return-object v0
.end method

.method private addNotificationLabel(Lcom/google/android/gm/provider/MailCore$Label;)Z
    .locals 5
    .param p1, "label"    # Lcom/google/android/gm/provider/MailCore$Label;

    .prologue
    const/4 v1, 0x0

    .line 1331
    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mNotificationLabels:Ljava/util/Map;

    iget-wide v3, p1, Lcom/google/android/gm/provider/MailCore$Label;->id:J

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1332
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/MailEngine;->getNotificationTagLabelCanonicalName(Lcom/google/android/gm/provider/MailCore$Label;)Ljava/lang/String;

    move-result-object v0

    .line 1333
    .local v0, "notificationTagLabelCanonicalName":Ljava/lang/String;
    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    invoke-virtual {v2, v0}, Lcom/google/android/gm/provider/MailCore;->getLabelOrNull(Ljava/lang/String;)Lcom/google/android/gm/provider/MailCore$Label;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 1337
    :goto_0
    return v1

    .line 1336
    :cond_0
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    invoke-virtual {v1, v0}, Lcom/google/android/gm/provider/MailCore;->getOrAddLabel(Ljava/lang/String;)Lcom/google/android/gm/provider/MailCore$Label;

    .line 1337
    const/4 v1, 0x1

    goto :goto_0
.end method

.method private static addressStringsListContainsEmailAddress(Ljava/util/Collection;Ljava/lang/String;)Z
    .locals 3
    .param p1, "emailAddress"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            ")Z"
        }
    .end annotation

    .prologue
    .line 3499
    .local p0, "addressStrings":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    invoke-interface {p0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 3500
    .local v0, "addressString":Ljava/lang/String;
    invoke-static {v0}, Lcom/google/android/gm/provider/Gmail;->getEmailFromAddressString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 3501
    const/4 v2, 0x1

    .line 3504
    .end local v0    # "addressString":Ljava/lang/String;
    :goto_0
    return v2

    :cond_1
    const/4 v2, 0x0

    goto :goto_0
.end method

.method private broadcastLabelNotifications(Ljava/util/Set;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Long;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1341
    .local p1, "updatedLabels":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->inTransaction()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1344
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mTransactionListener:Lcom/google/android/gm/provider/GmailTransactionListener;

    invoke-virtual {v0, p1}, Lcom/google/android/gm/provider/GmailTransactionListener;->addLabelToNotify(Ljava/util/Set;)V

    .line 1348
    :goto_0
    return-void

    .line 1346
    :cond_0
    invoke-virtual {p0, p1}, Lcom/google/android/gm/provider/MailEngine;->broadcastLabelNotificationsImpl(Ljava/util/Set;)V

    goto :goto_0
.end method

.method private cacheAttachment(Lcom/google/android/gm/provider/Gmail$Attachment;)Z
    .locals 14

    .prologue
    .line 3391
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getCacheDir()Ljava/io/File;

    move-result-object v0

    .line 3393
    invoke-virtual {v0}, Ljava/io/File;->getTotalSpace()J

    move-result-wide v5

    .line 3394
    iget v1, p1, Lcom/google/android/gm/provider/Gmail$Attachment;->size:I

    if-lez v1, :cond_1

    .line 3395
    invoke-virtual {v0}, Ljava/io/File;->getUsableSpace()J

    move-result-wide v1

    iget v3, p1, Lcom/google/android/gm/provider/Gmail$Attachment;->size:I

    int-to-long v3, v3

    sub-long/2addr v1, v3

    .line 3396
    invoke-direct {p0, v5, v6, v1, v2}, Lcom/google/android/gm/provider/MailEngine;->isLowSpace(JJ)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 3397
    const-string v0, "Gmail"

    const-string v3, "Low memory (%d/%d). Can\'t cache attachment %s"

    const/4 v4, 0x3

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v7, 0x0

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    aput-object v1, v4, v7

    const/4 v1, 0x1

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    aput-object v2, v4, v1

    const/4 v1, 0x2

    aput-object p1, v4, v1

    invoke-static {v0, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 3399
    const/4 v0, 0x0

    .line 3455
    :cond_0
    :goto_0
    return v0

    .line 3402
    :cond_1
    const/4 v2, 0x0

    .line 3403
    const/4 v3, 0x0

    .line 3404
    const/4 v1, 0x0

    .line 3406
    :try_start_0
    new-instance v4, Ljava/text/SimpleDateFormat;

    const-string v7, "yyyy-MM-dd-kk:mm:ss"

    invoke-direct {v4, v7}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    .line 3407
    new-instance v7, Ljava/util/Date;

    invoke-direct {v7}, Ljava/util/Date;-><init>()V

    invoke-virtual {v4, v7}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v4

    const-string v7, ".attachment"

    invoke-static {v4, v7, v0}, Ljava/io/File;->createTempFile(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;

    move-result-object v1

    .line 3408
    iget-object v4, p1, Lcom/google/android/gm/provider/Gmail$Attachment;->originExtras:Ljava/lang/String;

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 3409
    iget-object v7, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    invoke-virtual {v7}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v7

    invoke-virtual {v7, v4}, Landroid/content/ContentResolver;->openInputStream(Landroid/net/Uri;)Ljava/io/InputStream;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_5
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v4

    .line 3410
    :try_start_1
    new-instance v2, Ljava/io/FileOutputStream;

    invoke-direct {v2, v1}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_6
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 3411
    :try_start_2
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v7

    .line 3412
    const/16 v3, 0x400

    new-array v3, v3, [B

    .line 3414
    :cond_2
    invoke-virtual {v4, v3}, Ljava/io/InputStream;->read([B)I

    move-result v9

    .line 3415
    if-gtz v9, :cond_4

    .line 3423
    invoke-virtual {v2}, Ljava/io/FileOutputStream;->flush()V

    .line 3424
    invoke-virtual {v1}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p1, Lcom/google/android/gm/provider/Gmail$Attachment;->cachedContent:Ljava/lang/String;

    .line 3425
    const-string v3, "Gmail"

    const-string v7, "Cached %s to %s"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    iget-object v10, p1, Lcom/google/android/gm/provider/Gmail$Attachment;->originExtras:Ljava/lang/String;

    aput-object v10, v8, v9

    const/4 v9, 0x1

    iget-object v10, p1, Lcom/google/android/gm/provider/Gmail$Attachment;->cachedContent:Ljava/lang/String;

    aput-object v10, v8, v9

    invoke-static {v3, v7, v8}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 3427
    invoke-virtual {v0}, Ljava/io/File;->getUsableSpace()J

    move-result-wide v7

    .line 3428
    invoke-direct {p0, v5, v6, v7, v8}, Lcom/google/android/gm/provider/MailEngine;->isLowSpace(JJ)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 3429
    invoke-virtual {v1}, Ljava/io/File;->delete()Z

    .line 3430
    const-string v0, "Gmail"

    const-string v3, "Low memory (%d/%d). Can\'t cache attachment %s"

    const/4 v9, 0x3

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    invoke-static {v7, v8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    aput-object v7, v9, v10

    const/4 v7, 0x1

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v9, v7

    const/4 v5, 0x2

    aput-object p1, v9, v5

    invoke-static {v0, v3, v9}, Lcom/google/android/gm/provider/LogUtils;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    .line 3432
    const/4 v0, 0x0

    .line 3447
    if-eqz v4, :cond_3

    .line 3448
    :try_start_3
    invoke-virtual {v4}, Ljava/io/InputStream;->close()V

    .line 3450
    :cond_3
    if-eqz v2, :cond_0

    .line 3451
    invoke-virtual {v2}, Ljava/io/FileOutputStream;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_0

    goto/16 :goto_0

    .line 3453
    :catch_0
    move-exception v1

    .line 3454
    const-string v2, "Gmail"

    const-string v3, "Failed to close stream"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v2, v1, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->w(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    goto/16 :goto_0

    .line 3418
    :cond_4
    const/4 v10, 0x0

    :try_start_4
    invoke-virtual {v2, v3, v10, v9}, Ljava/io/FileOutputStream;->write([BII)V

    .line 3419
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v9

    sub-long/2addr v9, v7

    const-wide/32 v11, 0x36ee80

    cmp-long v9, v9, v11

    if-lez v9, :cond_2

    .line 3420
    new-instance v0, Ljava/io/IOException;

    const-string v3, "Timed out reading attachment data"

    invoke-direct {v0, v3}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_1
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    .line 3436
    :catch_1
    move-exception v0

    move-object v3, v4

    .line 3440
    :goto_1
    :try_start_5
    const-string v4, "Gmail"

    const-string v5, "Failed to cache attachment %s"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object p1, v6, v7

    invoke-static {v4, v0, v5, v6}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 3441
    if-eqz v1, :cond_5

    .line 3442
    invoke-virtual {v1}, Ljava/io/File;->delete()Z
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_3

    .line 3444
    :cond_5
    const/4 v0, 0x0

    .line 3447
    if-eqz v3, :cond_6

    .line 3448
    :try_start_6
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V

    .line 3450
    :cond_6
    if-eqz v2, :cond_0

    .line 3451
    invoke-virtual {v2}, Ljava/io/FileOutputStream;->close()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_2

    goto/16 :goto_0

    .line 3453
    :catch_2
    move-exception v1

    .line 3454
    const-string v2, "Gmail"

    const-string v3, "Failed to close stream"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v2, v1, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->w(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    goto/16 :goto_0

    .line 3435
    :cond_7
    const/4 v0, 0x1

    .line 3447
    if-eqz v4, :cond_8

    .line 3448
    :try_start_7
    invoke-virtual {v4}, Ljava/io/InputStream;->close()V

    .line 3450
    :cond_8
    if-eqz v2, :cond_0

    .line 3451
    invoke-virtual {v2}, Ljava/io/FileOutputStream;->close()V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_3

    goto/16 :goto_0

    .line 3453
    :catch_3
    move-exception v1

    .line 3454
    const-string v2, "Gmail"

    const-string v3, "Failed to close stream"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v2, v1, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->w(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    goto/16 :goto_0

    .line 3446
    :catchall_0
    move-exception v0

    move-object v4, v2

    move-object v2, v3

    .line 3447
    :goto_2
    if-eqz v4, :cond_9

    .line 3448
    :try_start_8
    invoke-virtual {v4}, Ljava/io/InputStream;->close()V

    .line 3450
    :cond_9
    if-eqz v2, :cond_a

    .line 3451
    invoke-virtual {v2}, Ljava/io/FileOutputStream;->close()V
    :try_end_8
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_4

    .line 3455
    :cond_a
    :goto_3
    throw v0

    .line 3453
    :catch_4
    move-exception v1

    .line 3454
    const-string v2, "Gmail"

    const-string v3, "Failed to close stream"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v2, v1, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->w(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_3

    .line 3446
    :catchall_1
    move-exception v0

    move-object v2, v3

    goto :goto_2

    :catchall_2
    move-exception v0

    goto :goto_2

    :catchall_3
    move-exception v0

    move-object v4, v3

    goto :goto_2

    .line 3436
    :catch_5
    move-exception v0

    move-object v13, v3

    move-object v3, v2

    move-object v2, v13

    goto :goto_1

    :catch_6
    move-exception v0

    move-object v2, v3

    move-object v3, v4

    goto :goto_1
.end method

.method private calculateUnknownSyncRationalesAndPurgeInBackground()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 6495
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mLabelMap:Lcom/google/android/gm/provider/Gmail$LabelMap;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/Gmail$LabelMap;->labelsSynced()Z

    move-result v0

    if-nez v0, :cond_0

    .line 6499
    const-string v0, "Gmail"

    const-string v1, "calculateUnknownSyncRationalesAndPurgeInBackground: exiting (labelMap not synced"

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 6543
    :goto_0
    return-void

    .line 6507
    :cond_0
    const-string v0, "Gmail"

    const-string v1, "calculateUnknownSyncRationalesAndPurgeInBackground: queueing"

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 6508
    new-instance v0, Lcom/google/android/gm/provider/MailEngine$12;

    invoke-direct {v0, p0}, Lcom/google/android/gm/provider/MailEngine$12;-><init>(Lcom/google/android/gm/provider/MailEngine;)V

    invoke-virtual {p0, v0}, Lcom/google/android/gm/provider/MailEngine;->postBackgroundTask(Ljava/lang/Runnable;)V

    goto :goto_0
.end method

.method private callInitializationListener(Landroid/os/Handler;Lcom/google/android/gm/provider/MailEngine$MailEngineInitListener;)V
    .locals 1
    .param p1, "handler"    # Landroid/os/Handler;
    .param p2, "listener"    # Lcom/google/android/gm/provider/MailEngine$MailEngineInitListener;

    .prologue
    .line 1115
    new-instance v0, Lcom/google/android/gm/provider/MailEngine$6;

    invoke-direct {v0, p0, p2}, Lcom/google/android/gm/provider/MailEngine$6;-><init>(Lcom/google/android/gm/provider/MailEngine;Lcom/google/android/gm/provider/MailEngine$MailEngineInitListener;)V

    invoke-virtual {p1, v0}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 1120
    return-void
.end method

.method private cancelSyncForLiveRequest()V
    .locals 3

    .prologue
    .line 2120
    iget-boolean v0, p0, Lcom/google/android/gm/provider/MailEngine;->mIsSyncInProgress:Z

    if-eqz v0, :cond_0

    .line 2121
    const-string v0, "Gmail"

    const-string v1, "Cancelling background sync for live request"

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 2122
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/gm/provider/MailEngine;->mIsSyncCancelled:Z

    .line 2123
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine;->requestSync()V

    .line 2125
    :cond_0
    return-void
.end method

.method private changeTaskState(IZ)V
    .locals 2
    .param p1, "task"    # I
    .param p2, "running"    # Z

    .prologue
    .line 1789
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mStatusLock:Ljava/lang/Object;

    monitor-enter v1

    .line 1790
    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mStatus:Ljava/util/BitSet;

    invoke-virtual {v0, p1}, Ljava/util/BitSet;->get(I)Z

    move-result v0

    if-eq v0, p2, :cond_0

    .line 1791
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mStatus:Ljava/util/BitSet;

    invoke-virtual {v0, p1, p2}, Ljava/util/BitSet;->set(IZ)V

    .line 1792
    invoke-direct {p0}, Lcom/google/android/gm/provider/MailEngine;->notifyStatusChange()V

    .line 1794
    :cond_0
    monitor-exit v1

    .line 1795
    return-void

    .line 1794
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method private cleanupAttachments(Ljava/lang/String;)V
    .locals 7

    .prologue
    .line 3014
    invoke-static {p1}, Lcom/google/android/gm/provider/Gmail$MessageModification;->parseJoinedAttachmentString(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 3016
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gm/provider/Gmail$Attachment;

    .line 3017
    iget-object v2, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->cachedContent:Ljava/lang/String;

    invoke-static {v2}, Lcom/google/android/common/base/Strings;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 3018
    const-string v2, "Gmail"

    const-string v3, "Cleaning up cached attachment: %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    iget-object v6, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->cachedContent:Ljava/lang/String;

    aput-object v6, v4, v5

    invoke-static {v2, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 3019
    new-instance v2, Ljava/io/File;

    iget-object v0, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->cachedContent:Ljava/lang/String;

    invoke-direct {v2, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/io/File;->delete()Z

    goto :goto_0

    .line 3022
    :cond_1
    return-void
.end method

.method static clearMailEngines()V
    .locals 5

    .prologue
    .line 865
    sget-object v3, Lcom/google/android/gm/provider/MailEngine;->sMailEngines:Ljava/util/Map;

    monitor-enter v3

    .line 866
    :try_start_0
    sget-object v2, Lcom/google/android/gm/provider/MailEngine;->sMailEngines:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gm/provider/MailEngine$MailEngineContainer;

    .line 867
    .local v0, "engineEntry":Lcom/google/android/gm/provider/MailEngine$MailEngineContainer;
    iget-object v4, v0, Lcom/google/android/gm/provider/MailEngine$MailEngineContainer;->mEngineLock:Ljava/lang/Object;

    monitor-enter v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 868
    :try_start_1
    iget-object v2, v0, Lcom/google/android/gm/provider/MailEngine$MailEngineContainer;->mEngine:Lcom/google/android/gm/provider/MailEngine;

    if-eqz v2, :cond_0

    .line 869
    iget-object v2, v0, Lcom/google/android/gm/provider/MailEngine$MailEngineContainer;->mEngine:Lcom/google/android/gm/provider/MailEngine;

    invoke-virtual {v2}, Lcom/google/android/gm/provider/MailEngine;->close()V

    .line 871
    :cond_0
    monitor-exit v4

    goto :goto_0

    :catchall_0
    move-exception v2

    monitor-exit v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    throw v2

    .line 874
    .end local v0    # "engineEntry":Lcom/google/android/gm/provider/MailEngine$MailEngineContainer;
    :catchall_1
    move-exception v2

    monitor-exit v3
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    throw v2

    .line 873
    :cond_1
    :try_start_3
    sget-object v2, Lcom/google/android/gm/provider/MailEngine;->sMailEngines:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->clear()V

    .line 874
    monitor-exit v3
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 875
    return-void
.end method

.method private detectTooManySyncLoops(Landroid/content/SyncResult;I)V
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 1979
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v0

    iget-wide v2, p0, Lcom/google/android/gm/provider/MailEngine;->mLastSyncLoopCheckTime:J

    sub-long/2addr v0, v2

    const-wide/32 v2, 0x1d4c0

    cmp-long v0, v0, v2

    if-lez v0, :cond_0

    .line 1981
    iput v5, p0, Lcom/google/android/gm/provider/MailEngine;->mSyncCountPerPeriod:I

    .line 1982
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/google/android/gm/provider/MailEngine;->mLastSyncLoopCheckTime:J

    .line 1985
    :cond_0
    iget v0, p0, Lcom/google/android/gm/provider/MailEngine;->mSyncCountPerPeriod:I

    if-le v0, p2, :cond_2

    .line 1986
    const-string v0, "Gmail"

    const-string v1, "Sync check time: %d Sync count: %d Max syncs allowed in period: %d"

    const/4 v2, 0x3

    new-array v2, v2, [Ljava/lang/Object;

    iget-wide v3, p0, Lcom/google/android/gm/provider/MailEngine;->mLastSyncLoopCheckTime:J

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    aput-object v3, v2, v5

    iget v3, p0, Lcom/google/android/gm/provider/MailEngine;->mSyncCountPerPeriod:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v6

    const/4 v3, 0x2

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/LogUtils;->v(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1989
    const-string v0, "Gmail"

    const-string v1, "Too many sync loops, cancelling sync."

    new-array v2, v5, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/LogUtils;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1990
    iput-boolean v6, p0, Lcom/google/android/gm/provider/MailEngine;->mIsSyncCancelled:Z

    .line 1995
    if-eqz p1, :cond_1

    .line 1996
    const-wide/16 v0, 0x1e

    iput-wide v0, p1, Landroid/content/SyncResult;->delayUntil:J

    .line 2001
    :cond_1
    new-instance v0, Ljava/io/IOException;

    const-string v1, "Too many sync loops detected"

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 2003
    :cond_2
    return-void
.end method

.method private enqueueCleanupTempFilesTask(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 1214
    new-instance v0, Lcom/google/android/gm/provider/MailEngine$7;

    invoke-direct {v0, p0, p1}, Lcom/google/android/gm/provider/MailEngine$7;-><init>(Lcom/google/android/gm/provider/MailEngine;Landroid/content/Context;)V

    invoke-virtual {p0, v0}, Lcom/google/android/gm/provider/MailEngine;->postBackgroundTask(Ljava/lang/Runnable;)V

    .line 1226
    return-void
.end method

.method private enqueueFinalInitializationTask(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 1029
    new-instance v0, Lcom/google/android/gm/provider/MailEngine$4;

    invoke-direct {v0, p0, p1}, Lcom/google/android/gm/provider/MailEngine$4;-><init>(Lcom/google/android/gm/provider/MailEngine;Landroid/content/Context;)V

    invoke-virtual {p0, v0}, Lcom/google/android/gm/provider/MailEngine;->postBackgroundTask(Ljava/lang/Runnable;)V

    .line 1072
    return-void
.end method

.method private expungeLocalMessageImpl(J)I
    .locals 12

    .prologue
    const-wide/16 v8, -0x1

    const/4 v5, 0x0

    const/4 v10, 0x1

    const/4 v11, 0x0

    .line 2973
    .line 2974
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->inTransaction()Z

    move-result v0

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Must be in transaction"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 2975
    :cond_0
    new-array v4, v10, [Ljava/lang/String;

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v0

    aput-object v0, v4, v11

    .line 2976
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "messages"

    const/4 v2, 0x3

    new-array v2, v2, [Ljava/lang/String;

    const-string v3, "messageId"

    aput-object v3, v2, v11

    const-string v3, "conversation"

    aput-object v3, v2, v10

    const/4 v3, 0x2

    const-string v6, "joinedAttachmentInfos"

    aput-object v6, v2, v3

    const-string v3, "_id = ?"

    move-object v6, v5

    move-object v7, v5

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v7

    .line 2986
    :try_start_0
    invoke-interface {v7}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-lez v0, :cond_2

    .line 2987
    invoke-interface {v7}, Landroid/database/Cursor;->moveToNext()Z

    .line 2988
    const-string v0, "messageId"

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v3

    .line 2990
    const-string v0, "conversation"

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v1

    .line 2992
    const-string v0, "joinedAttachmentInfos"

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v5

    move-object v6, v5

    .line 2996
    :goto_0
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    .line 2998
    cmp-long v0, v3, v8

    if-eqz v0, :cond_1

    .line 2999
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    new-array v5, v10, [Ljava/lang/Long;

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    aput-object v7, v5, v11

    invoke-static {v5}, Lcom/google/common/collect/Lists;->newArrayList([Ljava/lang/Object;)Ljava/util/ArrayList;

    move-result-object v5

    invoke-virtual {v0, v5}, Lcom/google/android/gm/provider/MailCore;->expungeMessagesWithoutWritingOperations(Ljava/util/List;)V

    .line 3000
    sget-object v0, Lcom/google/android/gm/provider/MailSync$SyncRationale;->LOCAL_CHANGE:Lcom/google/android/gm/provider/MailSync$SyncRationale;

    invoke-direct {p0, v1, v2, v0}, Lcom/google/android/gm/provider/MailEngine;->onConversationChanged(JLcom/google/android/gm/provider/MailSync$SyncRationale;)V

    .line 3001
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mOperations:Lcom/google/android/gm/provider/Operations;

    const-string v5, "messageExpunged"

    invoke-virtual/range {v0 .. v5}, Lcom/google/android/gm/provider/Operations;->recordOperation(JJLjava/lang/String;)J

    .line 3003
    invoke-direct {p0, v6}, Lcom/google/android/gm/provider/MailEngine;->cleanupAttachments(Ljava/lang/String;)V

    move v0, v10

    .line 3007
    :goto_1
    return v0

    .line 2996
    :catchall_0
    move-exception v0

    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    throw v0

    :cond_1
    move v0, v11

    .line 3007
    goto :goto_1

    :cond_2
    move-wide v1, v8

    move-wide v3, v8

    move-object v6, v5

    goto :goto_0
.end method

.method private static declared-synchronized getCreationHandler()Landroid/os/Handler;
    .locals 4

    .prologue
    .line 770
    const-class v2, Lcom/google/android/gm/provider/MailEngine;

    monitor-enter v2

    :try_start_0
    sget-object v1, Lcom/google/android/gm/provider/MailEngine;->sMailEngineCreationHandler:Landroid/os/Handler;

    if-nez v1, :cond_0

    .line 772
    new-instance v0, Landroid/os/HandlerThread;

    const-string v1, "MailEngine creation"

    invoke-direct {v0, v1}, Landroid/os/HandlerThread;-><init>(Ljava/lang/String;)V

    .line 774
    .local v0, "handlerThread":Landroid/os/HandlerThread;
    invoke-virtual {v0}, Landroid/os/HandlerThread;->start()V

    .line 776
    new-instance v1, Landroid/os/Handler;

    invoke-virtual {v0}, Landroid/os/HandlerThread;->getLooper()Landroid/os/Looper;

    move-result-object v3

    invoke-direct {v1, v3}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    sput-object v1, Lcom/google/android/gm/provider/MailEngine;->sMailEngineCreationHandler:Landroid/os/Handler;

    .line 778
    :cond_0
    sget-object v1, Lcom/google/android/gm/provider/MailEngine;->sMailEngineCreationHandler:Landroid/os/Handler;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v2

    return-object v1

    .line 770
    :catchall_0
    move-exception v1

    monitor-exit v2

    throw v1
.end method

.method private getCursorForCustomLabelColors()Landroid/database/Cursor;
    .locals 8

    .prologue
    const/4 v2, 0x0

    .line 1229
    new-instance v0, Landroid/database/sqlite/SQLiteQueryBuilder;

    invoke-direct {v0}, Landroid/database/sqlite/SQLiteQueryBuilder;-><init>()V

    .line 1230
    const-string v1, "custom_label_color_prefs"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 1231
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    move-object v3, v2

    move-object v4, v2

    move-object v5, v2

    move-object v6, v2

    move-object v7, v2

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    return-object v0
.end method

.method private getCursorForReplyFromDefaultAddress()Landroid/database/Cursor;
    .locals 4

    .prologue
    .line 1241
    const-string v0, "name = ?"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    sget-object v3, Lcom/google/android/gm/utils/CustomFromUtils;->REPLY_FROM_DEFAULT_SETTING:Ljava/lang/String;

    aput-object v3, v1, v2

    invoke-direct {p0, v0, v1}, Lcom/google/android/gm/provider/MailEngine;->getServerPrefsCursor(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    return-object v0
.end method

.method private getCursorForServerPrefs()Landroid/database/Cursor;
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 1247
    invoke-direct {p0, v0, v0}, Lcom/google/android/gm/provider/MailEngine;->getServerPrefsCursor(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    return-object v0
.end method

.method static getDbName(Ljava/lang/String;)Ljava/lang/String;
    .locals 2

    .prologue
    .line 1253
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "mailstore."

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ".db"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private getEngineSettingsCursor(Ljava/lang/String;)Landroid/database/Cursor;
    .locals 8

    .prologue
    const/4 v5, 0x0

    .line 1656
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "engine_settings"

    sget-object v2, Lcom/google/android/gm/provider/MailEngine;->PROJECTION_VALUE:[Ljava/lang/String;

    const-string v3, "name = ?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v6, 0x0

    aput-object p1, v4, v6

    move-object v6, v5

    move-object v7, v5

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    return-object v0
.end method

.method private declared-synchronized getHttpClient()Lcom/google/android/common/http/GoogleHttpClient;
    .locals 7

    .prologue
    const/4 v6, -0x1

    const/4 v1, 0x0

    .line 1271
    monitor-enter p0

    :try_start_0
    sget-object v0, Lcom/google/android/gm/provider/MailEngine;->USER_AGENT_STRING:Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v0, :cond_0

    .line 1275
    :try_start_1
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    .line 1277
    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v2

    iget-object v2, v2, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v0

    .line 1279
    iget v0, v0, Landroid/content/pm/PackageInfo;->versionCode:I
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/UnsupportedOperationException; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1288
    :goto_0
    :try_start_2
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Android-GmailProvider/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/MailEngine;->USER_AGENT_STRING:Ljava/lang/String;

    .line 1291
    :cond_0
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mHttpClient:Lcom/google/android/common/http/GoogleHttpClient;

    if-nez v0, :cond_2

    .line 1292
    new-instance v0, Lcom/google/android/common/http/GoogleHttpClient;

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    sget-object v2, Lcom/google/android/gm/provider/MailEngine;->USER_AGENT_STRING:Ljava/lang/String;

    const/4 v3, 0x1

    invoke-direct {v0, v1, v2, v3}, Lcom/google/android/common/http/GoogleHttpClient;-><init>(Landroid/content/Context;Ljava/lang/String;Z)V

    iput-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mHttpClient:Lcom/google/android/common/http/GoogleHttpClient;

    .line 1295
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const-string v1, "gmail_timeout_ms"

    const/4 v2, -0x1

    invoke-static {v0, v1, v2}, Lcom/google/android/gsf/Gservices;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v0

    .line 1298
    if-eq v0, v6, :cond_1

    .line 1299
    const-string v1, "Gmail"

    const-string v2, "Changing network timeout (because of gservices) to %d"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v1, v2, v3}, Lcom/google/android/gm/provider/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1300
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mHttpClient:Lcom/google/android/common/http/GoogleHttpClient;

    invoke-virtual {v1}, Lcom/google/android/common/http/GoogleHttpClient;->getParams()Lorg/apache/http/params/HttpParams;

    move-result-object v1

    .line 1301
    invoke-static {v1, v0}, Lorg/apache/http/params/HttpConnectionParams;->setConnectionTimeout(Lorg/apache/http/params/HttpParams;I)V

    .line 1302
    invoke-static {v1, v0}, Lorg/apache/http/params/HttpConnectionParams;->setSoTimeout(Lorg/apache/http/params/HttpParams;I)V

    .line 1303
    int-to-long v2, v0

    invoke-static {v1, v2, v3}, Lorg/apache/http/conn/params/ConnManagerParams;->setTimeout(Lorg/apache/http/params/HttpParams;J)V

    .line 1305
    :cond_1
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mHttpClient:Lcom/google/android/common/http/GoogleHttpClient;

    const-string v1, "Gmail"

    const/4 v2, 0x2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/common/http/GoogleHttpClient;->enableCurlLogging(Ljava/lang/String;I)V

    .line 1308
    :cond_2
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mHttpClient:Lcom/google/android/common/http/GoogleHttpClient;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    monitor-exit p0

    return-object v0

    .line 1280
    :catch_0
    move-exception v0

    .line 1281
    :try_start_3
    const-string v0, "Gmail"

    const-string v2, "Error finding package %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    invoke-virtual {v5}, Landroid/content/Context;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v5

    iget-object v5, v5, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    aput-object v5, v3, v4

    invoke-static {v0, v2, v3}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    move v0, v1

    .line 1287
    goto :goto_0

    .line 1283
    :catch_1
    move-exception v0

    .line 1286
    const-string v2, "Gmail"

    const-string v3, "Error getting the PackageManager "

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v2, v0, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    move v0, v1

    goto/16 :goto_0

    .line 1271
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method static getInternalDbName(Ljava/lang/String;)Ljava/lang/String;
    .locals 2

    .prologue
    .line 1257
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "internal."

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ".db"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private getIsSyncable()Z
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Landroid/accounts/OperationCanceledException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 1872
    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    invoke-static {v0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v0

    const-string v3, "com.google"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    const-string v6, "mail"

    invoke-static {v6}, Lcom/google/android/gsf/GoogleLoginServiceConstants;->featureForService(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x0

    const/4 v6, 0x0

    invoke-virtual {v0, v3, v4, v5, v6}, Landroid/accounts/AccountManager;->getAccountsByTypeAndFeatures(Ljava/lang/String;[Ljava/lang/String;Landroid/accounts/AccountManagerCallback;Landroid/os/Handler;)Landroid/accounts/AccountManagerFuture;

    move-result-object v0

    invoke-interface {v0}, Landroid/accounts/AccountManagerFuture;->getResult()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroid/accounts/Account;

    .line 1877
    array-length v4, v0

    move v3, v2

    :goto_0
    if-ge v3, v4, :cond_1

    aget-object v5, v0, v3

    .line 1878
    iget-object v6, p0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    invoke-virtual {v6, v5}, Landroid/accounts/Account;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    move v0, v1

    .line 1883
    :goto_1
    return v0

    .line 1877
    :cond_0
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 1882
    :cond_1
    const-string v0, "Gmail"

    const-string v1, "Account doesn\'t support mail %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    aput-object v5, v3, v4

    invoke-static {v0, v1, v3}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    :try_end_0
    .catch Landroid/accounts/AuthenticatorException; {:try_start_0 .. :try_end_0} :catch_0

    move v0, v2

    .line 1883
    goto :goto_1

    .line 1884
    :catch_0
    move-exception v0

    .line 1885
    new-instance v1, Ljava/io/IOException;

    invoke-virtual {v0}, Landroid/accounts/AuthenticatorException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public static getMailEngine(Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;
    .locals 3
    .param p0, "account"    # Ljava/lang/String;

    .prologue
    .line 785
    sget-object v2, Lcom/google/android/gm/provider/MailEngine;->sMailEngines:Ljava/util/Map;

    monitor-enter v2

    .line 786
    :try_start_0
    sget-object v1, Lcom/google/android/gm/provider/MailEngine;->sMailEngines:Ljava/util/Map;

    invoke-interface {v1, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gm/provider/MailEngine$MailEngineContainer;

    .line 787
    .local v0, "engineEntry":Lcom/google/android/gm/provider/MailEngine$MailEngineContainer;
    if-nez v0, :cond_0

    const/4 v1, 0x0

    :goto_0
    monitor-exit v2

    return-object v1

    :cond_0
    iget-object v1, v0, Lcom/google/android/gm/provider/MailEngine$MailEngineContainer;->mEngine:Lcom/google/android/gm/provider/MailEngine;

    goto :goto_0

    .line 788
    .end local v0    # "engineEntry":Lcom/google/android/gm/provider/MailEngine$MailEngineContainer;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method static getMailEngines(Landroid/content/Context;)Ljava/util/List;
    .locals 14
    .param p0, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/google/android/gm/provider/MailEngine;",
            ">;"
        }
    .end annotation

    .prologue
    .line 634
    sget-object v13, Lcom/google/android/gm/provider/MailEngine;->sMailEngines:Ljava/util/Map;

    monitor-enter v13

    .line 635
    :try_start_0
    sget-object v12, Lcom/google/android/gm/provider/MailEngine;->sMailEngines:Ljava/util/Map;

    invoke-interface {v12}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v12

    invoke-static {v12}, Lcom/google/common/collect/ImmutableSet;->copyOf(Ljava/util/Collection;)Lcom/google/common/collect/ImmutableSet;

    move-result-object v6

    .line 636
    .local v6, "containers":Ljava/util/Set;, "Ljava/util/Set<Lcom/google/android/gm/provider/MailEngine$MailEngineContainer;>;"
    monitor-exit v13
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 638
    invoke-static {p0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v12

    const-string v13, "com.google"

    invoke-virtual {v12, v13}, Landroid/accounts/AccountManager;->getAccountsByType(Ljava/lang/String;)[Landroid/accounts/Account;

    move-result-object v1

    .line 640
    .local v1, "accounts":[Landroid/accounts/Account;
    invoke-static {}, Lcom/google/common/collect/ImmutableSet;->builder()Lcom/google/common/collect/ImmutableSet$Builder;

    move-result-object v3

    .line 641
    .local v3, "builder":Lcom/google/common/collect/ImmutableSet$Builder;, "Lcom/google/common/collect/ImmutableSet$Builder<Ljava/lang/String;>;"
    move-object v2, v1

    .local v2, "arr$":[Landroid/accounts/Account;
    array-length v9, v2

    .local v9, "len$":I
    const/4 v8, 0x0

    .local v8, "i$":I
    :goto_0
    if-ge v8, v9, :cond_1

    aget-object v0, v2, v8

    .line 642
    .local v0, "account":Landroid/accounts/Account;
    if-eqz v0, :cond_0

    iget-object v12, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-static {v12}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v12

    if-nez v12, :cond_0

    .line 643
    iget-object v12, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-virtual {v3, v12}, Lcom/google/common/collect/ImmutableSet$Builder;->add(Ljava/lang/Object;)Lcom/google/common/collect/ImmutableSet$Builder;

    .line 641
    :cond_0
    add-int/lit8 v8, v8, 0x1

    goto :goto_0

    .line 636
    .end local v0    # "account":Landroid/accounts/Account;
    .end local v1    # "accounts":[Landroid/accounts/Account;
    .end local v2    # "arr$":[Landroid/accounts/Account;
    .end local v3    # "builder":Lcom/google/common/collect/ImmutableSet$Builder;, "Lcom/google/common/collect/ImmutableSet$Builder<Ljava/lang/String;>;"
    .end local v6    # "containers":Ljava/util/Set;, "Ljava/util/Set<Lcom/google/android/gm/provider/MailEngine$MailEngineContainer;>;"
    .end local v8    # "i$":I
    .end local v9    # "len$":I
    :catchall_0
    move-exception v12

    :try_start_1
    monitor-exit v13
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v12

    .line 646
    .restart local v1    # "accounts":[Landroid/accounts/Account;
    .restart local v2    # "arr$":[Landroid/accounts/Account;
    .restart local v3    # "builder":Lcom/google/common/collect/ImmutableSet$Builder;, "Lcom/google/common/collect/ImmutableSet$Builder<Ljava/lang/String;>;"
    .restart local v6    # "containers":Ljava/util/Set;, "Ljava/util/Set<Lcom/google/android/gm/provider/MailEngine$MailEngineContainer;>;"
    .restart local v8    # "i$":I
    .restart local v9    # "len$":I
    :cond_1
    invoke-virtual {v3}, Lcom/google/common/collect/ImmutableSet$Builder;->build()Lcom/google/common/collect/ImmutableSet;

    move-result-object v11

    .line 648
    .local v11, "validAccountNames":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v10

    .line 649
    .local v10, "mailEngines":Ljava/util/List;, "Ljava/util/List<Lcom/google/android/gm/provider/MailEngine;>;"
    invoke-interface {v6}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v8

    .local v8, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v12

    if-eqz v12, :cond_3

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/google/android/gm/provider/MailEngine$MailEngineContainer;

    .line 650
    .local v5, "container":Lcom/google/android/gm/provider/MailEngine$MailEngineContainer;
    iget-object v13, v5, Lcom/google/android/gm/provider/MailEngine$MailEngineContainer;->mEngineLock:Ljava/lang/Object;

    monitor-enter v13

    .line 651
    :try_start_2
    iget-object v7, v5, Lcom/google/android/gm/provider/MailEngine$MailEngineContainer;->mEngine:Lcom/google/android/gm/provider/MailEngine;

    .line 653
    .local v7, "engine":Lcom/google/android/gm/provider/MailEngine;
    if-eqz v7, :cond_2

    invoke-virtual {v7}, Lcom/google/android/gm/provider/MailEngine;->getAccountName()Ljava/lang/String;

    move-result-object v12

    invoke-interface {v11, v12}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v12

    if-eqz v12, :cond_2

    .line 654
    invoke-interface {v10, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 656
    :cond_2
    monitor-exit v13

    goto :goto_1

    .end local v7    # "engine":Lcom/google/android/gm/provider/MailEngine;
    :catchall_1
    move-exception v12

    monitor-exit v13
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    throw v12

    .line 660
    .end local v5    # "container":Lcom/google/android/gm/provider/MailEngine$MailEngineContainer;
    :cond_3
    new-instance v4, Lcom/google/android/gm/provider/MailEngine$AccountManagerOrderComparator;

    invoke-direct {v4, v1}, Lcom/google/android/gm/provider/MailEngine$AccountManagerOrderComparator;-><init>([Landroid/accounts/Account;)V

    .line 661
    .local v4, "comparator":Ljava/util/Comparator;
    invoke-static {v10, v4}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 663
    return-object v10
.end method

.method private getMessageFromCursor(Landroid/database/Cursor;Z)Lcom/google/android/gm/provider/MailSync$Message;
    .locals 10

    .prologue
    const-wide/16 v8, 0x0

    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 2497
    invoke-interface {p1}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2498
    const/4 v0, 0x0

    .line 2559
    :goto_0
    return-object v0

    .line 2501
    :cond_0
    new-instance v3, Lcom/google/android/gm/provider/MailSync$Message;

    invoke-direct {v3}, Lcom/google/android/gm/provider/MailSync$Message;-><init>()V

    .line 2502
    const-string v0, "_id"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    .line 2503
    const-string v0, "messageId"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v6

    .line 2504
    iput-wide v4, v3, Lcom/google/android/gm/provider/MailSync$Message;->localMessageId:J

    .line 2505
    iput-wide v6, v3, Lcom/google/android/gm/provider/MailSync$Message;->messageId:J

    .line 2506
    const-string v0, "conversation"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    iput-wide v4, v3, Lcom/google/android/gm/provider/MailSync$Message;->conversationId:J

    .line 2508
    const-string v0, "refMessageId"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    iput-wide v4, v3, Lcom/google/android/gm/provider/MailSync$Message;->refMessageId:J

    .line 2510
    const-string v0, "fromAddress"

    invoke-direct {p0, p1, v0}, Lcom/google/android/gm/provider/MailEngine;->getNonnullStringFromCursor(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/google/android/gm/provider/MailSync$Message;->fromAddress:Ljava/lang/String;

    .line 2512
    const-string v0, "customFromAddress"

    invoke-direct {p0, p1, v0}, Lcom/google/android/gm/provider/MailEngine;->getNonnullStringFromCursor(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/google/android/gm/provider/MailSync$Message;->customFromAddress:Ljava/lang/String;

    .line 2514
    const-string v0, "toAddresses"

    invoke-direct {p0, p1, v0}, Lcom/google/android/gm/provider/MailEngine;->getNonnullStringFromCursor(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sget-object v4, Lcom/google/android/gm/provider/Gmail;->EMAIL_SEPARATOR_PATTERN:Ljava/util/regex/Pattern;

    invoke-static {v0, v4}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/util/regex/Pattern;)[Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/common/collect/Lists;->newArrayList([Ljava/lang/Object;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, v3, Lcom/google/android/gm/provider/MailSync$Message;->toAddresses:Ljava/util/List;

    .line 2517
    const-string v0, "ccAddresses"

    invoke-direct {p0, p1, v0}, Lcom/google/android/gm/provider/MailEngine;->getNonnullStringFromCursor(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sget-object v4, Lcom/google/android/gm/provider/Gmail;->EMAIL_SEPARATOR_PATTERN:Ljava/util/regex/Pattern;

    invoke-static {v0, v4}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/util/regex/Pattern;)[Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/common/collect/Lists;->newArrayList([Ljava/lang/Object;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, v3, Lcom/google/android/gm/provider/MailSync$Message;->ccAddresses:Ljava/util/List;

    .line 2520
    const-string v0, "bccAddresses"

    invoke-direct {p0, p1, v0}, Lcom/google/android/gm/provider/MailEngine;->getNonnullStringFromCursor(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sget-object v4, Lcom/google/android/gm/provider/Gmail;->EMAIL_SEPARATOR_PATTERN:Ljava/util/regex/Pattern;

    invoke-static {v0, v4}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/util/regex/Pattern;)[Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/common/collect/Lists;->newArrayList([Ljava/lang/Object;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, v3, Lcom/google/android/gm/provider/MailSync$Message;->bccAddresses:Ljava/util/List;

    .line 2523
    const-string v0, "replyToAddresses"

    invoke-direct {p0, p1, v0}, Lcom/google/android/gm/provider/MailEngine;->getNonnullStringFromCursor(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sget-object v4, Lcom/google/android/gm/provider/Gmail;->EMAIL_SEPARATOR_PATTERN:Ljava/util/regex/Pattern;

    invoke-static {v0, v4}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/util/regex/Pattern;)[Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/common/collect/Lists;->newArrayList([Ljava/lang/Object;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, v3, Lcom/google/android/gm/provider/MailSync$Message;->replyToAddresses:Ljava/util/List;

    .line 2526
    const-string v0, "dateSentMs"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    iput-wide v4, v3, Lcom/google/android/gm/provider/MailSync$Message;->dateSentMs:J

    .line 2528
    const-string v0, "dateReceivedMs"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    iput-wide v4, v3, Lcom/google/android/gm/provider/MailSync$Message;->dateReceivedMs:J

    .line 2530
    const-string v0, "subject"

    invoke-direct {p0, p1, v0}, Lcom/google/android/gm/provider/MailEngine;->getNonnullStringFromCursor(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/google/android/gm/provider/MailSync$Message;->subject:Ljava/lang/String;

    .line 2532
    const-string v0, "snippet"

    invoke-direct {p0, p1, v0}, Lcom/google/android/gm/provider/MailEngine;->getNonnullStringFromCursor(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/google/android/gm/provider/MailSync$Message;->snippet:Ljava/lang/String;

    .line 2534
    invoke-static {}, Lcom/google/android/gm/provider/Gmail;->newMessageLabelIdsSplitter()Landroid/text/TextUtils$StringSplitter;

    move-result-object v0

    .line 2535
    const-string v4, "labelIds"

    invoke-direct {p0, p1, v4}, Lcom/google/android/gm/provider/MailEngine;->getNonnullStringFromCursor(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v0, v4}, Landroid/text/TextUtils$StringSplitter;->setString(Ljava/lang/String;)V

    .line 2536
    invoke-static {v0}, Lcom/google/android/gm/provider/Gmail;->getLabelIdsFromLabelIdsString(Landroid/text/TextUtils$StringSplitter;)Ljava/util/Set;

    move-result-object v0

    iput-object v0, v3, Lcom/google/android/gm/provider/MailSync$Message;->labelIds:Ljava/util/Set;

    .line 2537
    const-string v0, "listInfo"

    invoke-direct {p0, p1, v0}, Lcom/google/android/gm/provider/MailEngine;->getNonnullStringFromCursor(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/google/android/gm/provider/MailSync$Message;->listInfo:Ljava/lang/String;

    .line 2539
    const-string v0, "personalLevel"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    invoke-static {v0}, Lcom/google/android/gm/provider/Gmail$PersonalLevel;->fromInt(I)Lcom/google/android/gm/provider/Gmail$PersonalLevel;

    move-result-object v0

    iput-object v0, v3, Lcom/google/android/gm/provider/MailSync$Message;->personalLevel:Lcom/google/android/gm/provider/Gmail$PersonalLevel;

    .line 2542
    const-string v0, "forward"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    cmp-long v0, v4, v8

    if-eqz v0, :cond_2

    move v0, v1

    :goto_1
    iput-boolean v0, v3, Lcom/google/android/gm/provider/MailSync$Message;->forward:Z

    .line 2544
    const-string v0, "includeQuotedText"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    cmp-long v0, v4, v8

    if-eqz v0, :cond_3

    move v0, v1

    :goto_2
    iput-boolean v0, v3, Lcom/google/android/gm/provider/MailSync$Message;->includeQuotedText:Z

    .line 2546
    const-string v0, "quoteStartPos"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    iput-wide v4, v3, Lcom/google/android/gm/provider/MailSync$Message;->quoteStartPos:J

    .line 2548
    const-string v0, "clientCreated"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    cmp-long v0, v4, v8

    if-eqz v0, :cond_4

    :goto_3
    iput-boolean v1, v3, Lcom/google/android/gm/provider/MailSync$Message;->clientCreated:Z

    .line 2550
    const-string v0, "joinedAttachmentInfos"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 2552
    iget-object v1, v3, Lcom/google/android/gm/provider/MailSync$Message;->attachments:Ljava/util/List;

    invoke-static {v0}, Lcom/google/android/gm/provider/Gmail$MessageModification;->parseJoinedAttachmentString(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v1, v0}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 2555
    if-eqz p2, :cond_1

    .line 2556
    const-string v0, "body"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v3, Lcom/google/android/gm/provider/MailSync$Message;->body:Ljava/lang/String;

    :cond_1
    move-object v0, v3

    .line 2559
    goto/16 :goto_0

    :cond_2
    move v0, v2

    .line 2542
    goto :goto_1

    :cond_3
    move v0, v2

    .line 2544
    goto :goto_2

    :cond_4
    move v1, v2

    .line 2548
    goto :goto_3
.end method

.method private getNonnullStringFromCursor(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 2564
    invoke-interface {p1, p2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 2565
    if-eqz v0, :cond_0

    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

.method private getNotificationTagLabel(Lcom/google/android/gm/provider/MailCore$Label;)Lcom/google/android/gm/provider/MailCore$Label;
    .locals 2
    .param p1, "label"    # Lcom/google/android/gm/provider/MailCore$Label;

    .prologue
    .line 1318
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/MailEngine;->getNotificationTagLabelCanonicalName(Lcom/google/android/gm/provider/MailCore$Label;)Ljava/lang/String;

    move-result-object v0

    .line 1319
    .local v0, "tagLabelName":Ljava/lang/String;
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    invoke-virtual {v1, v0}, Lcom/google/android/gm/provider/MailCore;->getLabelOrNull(Ljava/lang/String;)Lcom/google/android/gm/provider/MailCore$Label;

    move-result-object v1

    return-object v1
.end method

.method private getNotificationTagLabelCanonicalName(Lcom/google/android/gm/provider/MailCore$Label;)Ljava/lang/String;
    .locals 1
    .param p1, "label"    # Lcom/google/android/gm/provider/MailCore$Label;

    .prologue
    .line 1323
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    invoke-virtual {v0, p1}, Lcom/google/android/gm/provider/MailCore;->getLabelCanonicalNameOrThrow(Lcom/google/android/gm/provider/MailCore$Label;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gm/provider/Gmail;->getCanonicalLabelForNotification(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static declared-synchronized getNotifyDatasetChangedLooper()Landroid/os/Looper;
    .locals 4

    .prologue
    .line 6708
    const-class v1, Lcom/google/android/gm/provider/MailEngine;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/google/android/gm/provider/MailEngine;->sNotifyDatasetChangedThread:Landroid/os/HandlerThread;

    if-nez v0, :cond_0

    .line 6709
    new-instance v0, Landroid/os/HandlerThread;

    const-string v2, "Dataset changed notifier"

    const/16 v3, 0xa

    invoke-direct {v0, v2, v3}, Landroid/os/HandlerThread;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/android/gm/provider/MailEngine;->sNotifyDatasetChangedThread:Landroid/os/HandlerThread;

    .line 6711
    sget-object v0, Lcom/google/android/gm/provider/MailEngine;->sNotifyDatasetChangedThread:Landroid/os/HandlerThread;

    invoke-virtual {v0}, Landroid/os/HandlerThread;->start()V

    .line 6713
    :cond_0
    sget-object v0, Lcom/google/android/gm/provider/MailEngine;->sNotifyDatasetChangedThread:Landroid/os/HandlerThread;

    invoke-virtual {v0}, Landroid/os/HandlerThread;->getLooper()Landroid/os/Looper;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    monitor-exit v1

    return-object v0

    .line 6708
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method static getOrMakeMailEngine(Landroid/content/Context;Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;
    .locals 9
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "account"    # Ljava/lang/String;

    .prologue
    .line 668
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 669
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string v4, "account is empty"

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 672
    :cond_0
    const/4 v0, 0x0

    .line 676
    .local v0, "createdNewMailEngine":Z
    :try_start_0
    sget-object v4, Lcom/google/android/gm/provider/MailEngine;->sMailEngines:Ljava/util/Map;

    monitor-enter v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 677
    :try_start_1
    sget-object v3, Lcom/google/android/gm/provider/MailEngine;->sMailEngines:Ljava/util/Map;

    invoke-interface {v3, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gm/provider/MailEngine$MailEngineContainer;

    .line 678
    .local v1, "engineEntry":Lcom/google/android/gm/provider/MailEngine$MailEngineContainer;
    if-nez v1, :cond_1

    .line 679
    new-instance v1, Lcom/google/android/gm/provider/MailEngine$MailEngineContainer;

    .end local v1    # "engineEntry":Lcom/google/android/gm/provider/MailEngine$MailEngineContainer;
    invoke-direct {v1}, Lcom/google/android/gm/provider/MailEngine$MailEngineContainer;-><init>()V

    .line 680
    .restart local v1    # "engineEntry":Lcom/google/android/gm/provider/MailEngine$MailEngineContainer;
    sget-object v3, Lcom/google/android/gm/provider/MailEngine;->sMailEngines:Ljava/util/Map;

    invoke-interface {v3, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 681
    const/4 v0, 0x1

    .line 683
    :cond_1
    monitor-exit v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 691
    :try_start_2
    iget-object v4, v1, Lcom/google/android/gm/provider/MailEngine$MailEngineContainer;->mEngineLock:Ljava/lang/Object;

    monitor-enter v4
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 692
    :try_start_3
    iget-object v2, v1, Lcom/google/android/gm/provider/MailEngine$MailEngineContainer;->mEngine:Lcom/google/android/gm/provider/MailEngine;

    .line 693
    .local v2, "mailEngine":Lcom/google/android/gm/provider/MailEngine;
    if-nez v2, :cond_2

    .line 694
    new-instance v2, Lcom/google/android/gm/provider/MailEngine;

    .end local v2    # "mailEngine":Lcom/google/android/gm/provider/MailEngine;
    invoke-direct {v2, p0, p1}, Lcom/google/android/gm/provider/MailEngine;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 695
    .restart local v2    # "mailEngine":Lcom/google/android/gm/provider/MailEngine;
    iput-object v2, v1, Lcom/google/android/gm/provider/MailEngine$MailEngineContainer;->mEngine:Lcom/google/android/gm/provider/MailEngine;

    .line 697
    iget-object v3, v2, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    invoke-virtual {v3}, Lcom/google/android/gm/provider/MailSync;->getClientId()J

    move-result-wide v5

    const-wide/16 v7, 0x0

    cmp-long v3, v5, v7

    if-nez v3, :cond_2

    .line 698
    invoke-virtual {v2}, Lcom/google/android/gm/provider/MailEngine;->requestSync()V

    .line 701
    :cond_2
    monitor-exit v4
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    .line 705
    if-eqz v0, :cond_3

    .line 707
    invoke-static {p0}, Lcom/google/android/gm/provider/UiProvider;->notifyAccountListChanged(Landroid/content/Context;)V

    :cond_3
    return-object v2

    .line 683
    .end local v1    # "engineEntry":Lcom/google/android/gm/provider/MailEngine$MailEngineContainer;
    .end local v2    # "mailEngine":Lcom/google/android/gm/provider/MailEngine;
    :catchall_0
    move-exception v3

    :try_start_4
    monitor-exit v4
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    :try_start_5
    throw v3
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 705
    :catchall_1
    move-exception v3

    if-eqz v0, :cond_4

    .line 707
    invoke-static {p0}, Lcom/google/android/gm/provider/UiProvider;->notifyAccountListChanged(Landroid/content/Context;)V

    :cond_4
    throw v3

    .line 702
    .restart local v1    # "engineEntry":Lcom/google/android/gm/provider/MailEngine$MailEngineContainer;
    :catchall_2
    move-exception v3

    :try_start_6
    monitor-exit v4
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_2

    :try_start_7
    throw v3
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_1
.end method

.method public static getOrMakeMailEngineAsync(Landroid/content/Context;Ljava/lang/String;Lcom/google/android/gm/provider/MailEngine$MailEngineResultCallback;)V
    .locals 6
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "callback"    # Lcom/google/android/gm/provider/MailEngine$MailEngineResultCallback;

    .prologue
    .line 740
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 741
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "account is empty"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 744
    :cond_0
    invoke-static {}, Lcom/google/android/gm/provider/MailEngine;->getCreationHandler()Landroid/os/Handler;

    move-result-object v3

    .line 746
    .local v3, "handler":Landroid/os/Handler;
    new-instance v4, Landroid/os/Handler;

    invoke-direct {v4}, Landroid/os/Handler;-><init>()V

    .line 748
    .local v4, "callerHandler":Landroid/os/Handler;
    new-instance v0, Lcom/google/android/gm/provider/MailEngine$3;

    move-object v1, p0

    move-object v2, p1

    move-object v5, p2

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gm/provider/MailEngine$3;-><init>(Landroid/content/Context;Ljava/lang/String;Landroid/os/Handler;Landroid/os/Handler;Lcom/google/android/gm/provider/MailEngine$MailEngineResultCallback;)V

    invoke-virtual {v3, v0}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 767
    return-void
.end method

.method public static getOrMakeMailEngineSync(Landroid/content/Context;Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "account"    # Ljava/lang/String;

    .prologue
    .line 722
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v1

    if-ne v0, v1, :cond_0

    .line 723
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "getOrMaikeMailEngineSync should not be called on main (UI) thread"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 727
    :cond_0
    invoke-static {p0, p1}, Lcom/google/android/gm/provider/MailEngine;->getOrMakeMailEngine(Landroid/content/Context;Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;

    move-result-object v0

    return-object v0
.end method

.method private varargs getQueryBindArgs([Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/String;
    .locals 1
    .param p1, "projection"    # [Ljava/lang/String;
    .param p2, "labelColumnName"    # Ljava/lang/String;
    .param p3, "args"    # [Ljava/lang/String;

    .prologue
    .line 2351
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    invoke-static {v0, p1, p2, p3}, Lcom/google/android/gm/provider/QueryUtils;->getQueryBindArgs(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private getServerPrefsCursor(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    .locals 8
    .param p1, "query"    # Ljava/lang/String;
    .param p2, "prefName"    # [Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 1235
    new-instance v0, Landroid/database/sqlite/SQLiteQueryBuilder;

    invoke-direct {v0}, Landroid/database/sqlite/SQLiteQueryBuilder;-><init>()V

    .line 1236
    .local v0, "qb":Landroid/database/sqlite/SQLiteQueryBuilder;
    const-string v1, "server_preferences"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 1237
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    move-object v3, p1

    move-object v4, p2

    move-object v5, v2

    move-object v6, v2

    move-object v7, v2

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v1

    return-object v1
.end method

.method private getSyncedForLocalMessageId(J)Z
    .locals 10

    .prologue
    const/4 v5, 0x0

    const/4 v8, 0x1

    const/4 v9, 0x0

    .line 2600
    new-array v4, v8, [Ljava/lang/String;

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v0

    aput-object v0, v4, v9

    .line 2601
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "messages"

    sget-object v2, Lcom/google/android/gm/provider/MailEngine;->PROJECTION_MESSAGE_SYNCED:[Ljava/lang/String;

    const-string v3, "_id = ?"

    move-object v6, v5

    move-object v7, v5

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v1

    .line 2605
    :try_start_0
    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    if-nez v0, :cond_0

    .line 2612
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :goto_0
    return v9

    .line 2608
    :cond_0
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    .line 2609
    const-string v0, "synced"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getInt(I)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v0

    if-ne v0, v8, :cond_1

    move v0, v8

    .line 2612
    :goto_1
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    move v9, v0

    goto :goto_0

    :cond_1
    move v0, v9

    .line 2609
    goto :goto_1

    .line 2612
    :catchall_0
    move-exception v0

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    throw v0
.end method

.method private getUpdatedAttachments(Ljava/lang/String;J)Ljava/util/List;
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "J)",
            "Ljava/util/List",
            "<",
            "Lcom/google/android/gm/provider/Gmail$Attachment;",
            ">;"
        }
    .end annotation

    .prologue
    .line 3318
    invoke-static {p1}, Lcom/google/android/gm/provider/Gmail$MessageModification;->parseJoinedAttachmentString(Ljava/lang/String;)Ljava/util/List;

    move-result-object v8

    .line 3324
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v9

    .line 3325
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v10

    .line 3326
    const-wide/16 v0, 0x0

    cmp-long v0, p2, v0

    if-eqz v0, :cond_2

    .line 3329
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "messages"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "joinedAttachmentInfos"

    aput-object v4, v2, v3

    const-string v3, "_id = ?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static {p2, p3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v1

    .line 3337
    :try_start_0
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 3338
    const/4 v0, 0x0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    .line 3345
    :goto_0
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 3348
    invoke-static {v0}, Lcom/google/android/gm/provider/Gmail$MessageModification;->parseJoinedAttachmentString(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 3351
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gm/provider/Gmail$Attachment;

    .line 3352
    iget-object v2, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->origin:Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;

    sget-object v3, Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;->LOCAL_FILE:Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;

    if-ne v2, v3, :cond_0

    iget-object v2, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->cachedContent:Ljava/lang/String;

    if-eqz v2, :cond_0

    .line 3354
    iget-object v2, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->originExtras:Ljava/lang/String;

    iget-object v3, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->cachedContent:Ljava/lang/String;

    invoke-interface {v9, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3355
    iget-object v0, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->cachedContent:Ljava/lang/String;

    invoke-interface {v10, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 3340
    :cond_1
    :try_start_1
    const-string v0, "Gmail"

    const-string v2, "No row found for message _id %d though one was expected"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {p2, p3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v0, v2, v3}, Lcom/google/android/gm/provider/LogUtils;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 3342
    const/4 v0, 0x0

    goto :goto_0

    .line 3345
    :catchall_0
    move-exception v0

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    throw v0

    .line 3362
    :cond_2
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v2

    .line 3363
    invoke-interface {v8}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_3
    :goto_2
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gm/provider/Gmail$Attachment;

    .line 3364
    iget-object v1, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->originExtras:Ljava/lang/String;

    invoke-interface {v9, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 3365
    if-eqz v1, :cond_3

    .line 3366
    const-string v4, "Gmail"

    const-string v5, "Attachment Content %s is already cached as %s"

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    iget-object v11, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->originExtras:Ljava/lang/String;

    aput-object v11, v6, v7

    const/4 v7, 0x1

    aput-object v1, v6, v7

    invoke-static {v4, v5, v6}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 3368
    iput-object v1, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->cachedContent:Ljava/lang/String;

    .line 3369
    invoke-interface {v2, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 3374
    :cond_4
    invoke-interface {v10}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 3375
    :cond_5
    :goto_3
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_6

    .line 3376
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 3377
    invoke-interface {v2, v0}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 3378
    invoke-interface {v1}, Ljava/util/Iterator;->remove()V

    goto :goto_3

    .line 3381
    :cond_6
    invoke-interface {v10}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_4
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_7

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 3382
    const-string v2, "Gmail"

    const-string v3, "Cleaning up unused cached file %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v0, v4, v5

    invoke-static {v2, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 3383
    new-instance v2, Ljava/io/File;

    invoke-direct {v2, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/io/File;->delete()Z

    goto :goto_4

    .line 3386
    :cond_7
    return-object v8
.end method

.method private initialize()V
    .locals 10

    .prologue
    const/4 v8, 0x2

    const/4 v7, 0x1

    const/4 v6, 0x0

    const/4 v3, 0x0

    .line 1373
    const-string v0, "ME.initialize"

    invoke-static {v0}, Lcom/google/android/gm/perf/Timer;->startTiming(Ljava/lang/String;)V

    .line 1374
    new-instance v0, Lcom/google/android/gm/provider/MailEngine$8;

    invoke-direct {v0, p0}, Lcom/google/android/gm/provider/MailEngine$8;-><init>(Lcom/google/android/gm/provider/MailEngine;)V

    .line 1388
    new-instance v1, Lcom/google/android/gm/provider/Operations;

    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-direct {v1, v2, v4}, Lcom/google/android/gm/provider/Operations;-><init>(Landroid/content/Context;Landroid/database/sqlite/SQLiteDatabase;)V

    iput-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mOperations:Lcom/google/android/gm/provider/Operations;

    .line 1389
    new-instance v1, Lcom/google/android/gm/provider/MailCore;

    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    iget-object v5, p0, Lcom/google/android/gm/provider/MailEngine;->mOperations:Lcom/google/android/gm/provider/Operations;

    invoke-direct {v1, v2, v4, v5, v0}, Lcom/google/android/gm/provider/MailCore;-><init>(Landroid/content/Context;Landroid/database/sqlite/SQLiteDatabase;Lcom/google/android/gm/provider/Operations;Lcom/google/android/gm/provider/MailCore$Listener;)V

    iput-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    .line 1390
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailCore;->getLabelMap()Lcom/google/android/gm/provider/Gmail$LabelMap;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mLabelMap:Lcom/google/android/gm/provider/Gmail$LabelMap;

    .line 1391
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mLabelMap:Lcom/google/android/gm/provider/Gmail$LabelMap;

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mLabelMapObserver:Ljava/util/Observer;

    invoke-virtual {v0, v1}, Lcom/google/android/gm/provider/Gmail$LabelMap;->addObserver(Ljava/util/Observer;)V

    .line 1392
    new-instance v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;

    invoke-direct {v0, p0}, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;-><init>(Lcom/google/android/gm/provider/MailEngine;)V

    iput-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mMailStore:Lcom/google/android/gm/provider/MailStore;

    .line 1394
    new-instance v9, Ljava/util/HashMap;

    invoke-direct {v9}, Ljava/util/HashMap;-><init>()V

    .line 1395
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "sync_settings"

    new-array v2, v8, [Ljava/lang/String;

    const-string v4, "name"

    aput-object v4, v2, v6

    const-string v4, "value"

    aput-object v4, v2, v7

    move-object v4, v3

    move-object v5, v3

    move-object v6, v3

    move-object v7, v3

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 1399
    :goto_0
    :try_start_0
    invoke-interface {v8}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1400
    const/4 v0, 0x0

    invoke-interface {v8, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 1401
    const/4 v1, 0x1

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 1402
    invoke-interface {v9, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 1405
    :catchall_0
    move-exception v0

    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    throw v0

    :cond_0
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    .line 1408
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mInternalDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransactionNonExclusive()V

    .line 1410
    :try_start_1
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mInternalDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "internal_sync_settings"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "name"

    aput-object v4, v2, v3

    const/4 v3, 0x1

    const-string v4, "value"

    aput-object v4, v2, v3

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_2

    move-result-object v1

    .line 1414
    :goto_1
    :try_start_2
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1415
    const/4 v0, 0x0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 1416
    const/4 v2, 0x1

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 1417
    invoke-interface {v9, v0, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    goto :goto_1

    .line 1421
    :catchall_1
    move-exception v0

    :goto_2
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 1422
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mInternalDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    throw v0

    .line 1419
    :cond_1
    :try_start_3
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mInternalDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 1421
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 1422
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mInternalDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 1425
    new-instance v0, Lcom/google/android/gm/provider/MailSync;

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mMailStore:Lcom/google/android/gm/provider/MailStore;

    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mUrls:Lcom/google/android/gm/provider/Urls;

    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    iget-boolean v5, p0, Lcom/google/android/gm/provider/MailEngine;->mValidateSyncSets:Z

    move-object v3, v9

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gm/provider/MailSync;-><init>(Lcom/google/android/gm/provider/MailStore;Lcom/google/android/gm/provider/Urls;Ljava/util/Map;Landroid/content/Context;Z)V

    iput-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    .line 1426
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/MailSync;->getServerVersion()J

    move-result-wide v1

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gm/provider/MailCore;->setServerVersion(J)V

    .line 1430
    const-string v0, "ME.initialize"

    invoke-static {v0}, Lcom/google/android/gm/perf/Timer;->stopTiming(Ljava/lang/String;)V

    .line 1431
    return-void

    .line 1421
    :catchall_2
    move-exception v0

    move-object v1, v8

    goto :goto_2
.end method

.method private interruptAndWaitForBackgroundThreads()V
    .locals 7

    .prologue
    .line 902
    iget-object v6, p0, Lcom/google/android/gm/provider/MailEngine;->mBackgroundSyncThreadLock:Ljava/lang/Object;

    monitor-enter v6

    .line 903
    :try_start_0
    iget-object v3, p0, Lcom/google/android/gm/provider/MailEngine;->mBackgroundSyncThread:Ljava/lang/Thread;

    .line 904
    .local v3, "syncThreadToKill":Ljava/lang/Thread;
    monitor-exit v6
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 907
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine;->onSyncCanceled()V

    .line 908
    invoke-direct {p0, v3}, Lcom/google/android/gm/provider/MailEngine;->interruptAndWaitForThread(Ljava/lang/Thread;)V

    .line 912
    iget-object v6, p0, Lcom/google/android/gm/provider/MailEngine;->mSyncThreadLock:Ljava/lang/Object;

    monitor-enter v6

    .line 913
    :try_start_1
    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mSyncThread:Ljava/lang/Thread;

    .line 914
    .local v2, "syncThread":Ljava/lang/Thread;
    monitor-exit v6
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 915
    invoke-direct {p0, v2}, Lcom/google/android/gm/provider/MailEngine;->interruptAndWaitForThread(Ljava/lang/Thread;)V

    .line 917
    sget-object v5, Lcom/google/android/gm/provider/MailEngine;->NETWORK_CURSOR_LOGIC_FETCHER_THREADS:Ljava/util/Set;

    invoke-static {v5}, Lcom/google/common/collect/ImmutableSet;->copyOf(Ljava/util/Collection;)Lcom/google/common/collect/ImmutableSet;

    move-result-object v0

    .line 919
    .local v0, "fetcherThreads":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Thread;>;"
    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Thread;

    .line 920
    .local v4, "thread":Ljava/lang/Thread;
    invoke-direct {p0, v4}, Lcom/google/android/gm/provider/MailEngine;->interruptAndWaitForThread(Ljava/lang/Thread;)V

    goto :goto_0

    .line 904
    .end local v0    # "fetcherThreads":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Thread;>;"
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "syncThread":Ljava/lang/Thread;
    .end local v3    # "syncThreadToKill":Ljava/lang/Thread;
    .end local v4    # "thread":Ljava/lang/Thread;
    :catchall_0
    move-exception v5

    :try_start_2
    monitor-exit v6
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v5

    .line 914
    .restart local v3    # "syncThreadToKill":Ljava/lang/Thread;
    :catchall_1
    move-exception v5

    :try_start_3
    monitor-exit v6
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    throw v5

    .line 922
    .restart local v0    # "fetcherThreads":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Thread;>;"
    .restart local v1    # "i$":Ljava/util/Iterator;
    .restart local v2    # "syncThread":Ljava/lang/Thread;
    :cond_0
    return-void
.end method

.method private interruptAndWaitForThread(Ljava/lang/Thread;)V
    .locals 1
    .param p1, "thread"    # Ljava/lang/Thread;

    .prologue
    .line 929
    if-eqz p1, :cond_0

    .line 930
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine;->onSyncCanceled()V

    .line 931
    invoke-virtual {p1}, Ljava/lang/Thread;->interrupt()V

    .line 933
    :try_start_0
    invoke-virtual {p1}, Ljava/lang/Thread;->join()V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 937
    :cond_0
    :goto_0
    return-void

    .line 934
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method private isLowSpace(JJ)Z
    .locals 3

    .prologue
    .line 3494
    long-to-float v0, p3

    long-to-float v1, p1

    const/high16 v2, 0x3e800000    # 0.25f

    mul-float/2addr v1, v2

    cmpg-float v0, v0, v1

    if-gez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static joinedAttachmentsString(Lcom/google/android/gm/provider/MailSync$Message;)Ljava/lang/String;
    .locals 1
    .param p0, "message"    # Lcom/google/android/gm/provider/MailSync$Message;

    .prologue
    .line 3508
    iget-object v0, p0, Lcom/google/android/gm/provider/MailSync$Message;->attachments:Ljava/util/List;

    invoke-static {v0}, Lcom/google/android/gm/provider/Gmail$MessageModification;->joinedAttachmentsString(Ljava/util/List;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private makeRight()V
    .locals 11

    .prologue
    const/4 v2, 0x0

    const/4 v10, 0x3

    const/4 v9, 0x2

    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 3607
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailSync;->getClientId()J

    move-result-wide v3

    .line 3609
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    .line 3611
    invoke-static {}, Landroid/content/ContentResolver;->getMasterSyncAutomatically()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine;->automaticSyncEnabled()Z

    move-result v1

    if-nez v1, :cond_2

    .line 3613
    :cond_0
    new-array v1, v10, [Ljava/lang/String;

    const-string v2, "gmail-ls"

    aput-object v2, v1, v7

    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    iget-object v2, v2, Landroid/accounts/Account;->name:Ljava/lang/String;

    aput-object v2, v1, v8

    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    iget-object v2, v2, Landroid/accounts/Account;->type:Ljava/lang/String;

    aput-object v2, v1, v9

    .line 3616
    :try_start_0
    sget-object v2, Lcom/google/android/gsf/SubscribedFeeds$Feeds;->CONTENT_URI:Landroid/net/Uri;

    const-string v3, "authority=? AND _sync_account=? AND _sync_account_type=?"

    invoke-virtual {v0, v2, v3, v1}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_0

    .line 3663
    :cond_1
    :goto_0
    return-void

    .line 3621
    :catch_0
    move-exception v0

    .line 3628
    const-string v1, "Gmail"

    const-string v2, "NPE.  This shouldn\'t happen"

    new-array v3, v7, [Ljava/lang/Object;

    invoke-static {v1, v0, v2, v3}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0

    .line 3633
    :cond_2
    const-wide/16 v5, 0x0

    cmp-long v1, v3, v5

    if-eqz v1, :cond_1

    .line 3634
    invoke-virtual {p0, v3, v4}, Lcom/google/android/gm/provider/MailEngine;->getSubscribedFeedUrl(J)Ljava/lang/String;

    move-result-object v6

    .line 3635
    const/4 v1, 0x4

    new-array v4, v1, [Ljava/lang/String;

    const-string v1, "gmail-ls"

    aput-object v1, v4, v7

    aput-object v6, v4, v8

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    iget-object v1, v1, Landroid/accounts/Account;->name:Ljava/lang/String;

    aput-object v1, v4, v9

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    iget-object v1, v1, Landroid/accounts/Account;->type:Ljava/lang/String;

    aput-object v1, v4, v10

    .line 3638
    sget-object v1, Lcom/google/android/gsf/SubscribedFeeds$Feeds;->CONTENT_URI:Landroid/net/Uri;

    const-string v3, "authority=? AND feed=? AND _sync_account=? AND _sync_account_type=?"

    move-object v5, v2

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v1

    .line 3645
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v2

    if-nez v2, :cond_3

    .line 3646
    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    const-string v3, "gmail-ls"

    const-string v4, "mail"

    invoke-static {v0, v6, v2, v3, v4}, Lcom/google/android/gsf/SubscribedFeeds;->addFeed(Landroid/content/ContentResolver;Ljava/lang/String;Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;

    .line 3648
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine;->requestSync()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 3660
    :goto_1
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    goto :goto_0

    .line 3651
    :cond_3
    :try_start_2
    sget-object v2, Lcom/google/android/gsf/SubscribedFeeds$Feeds;->CONTENT_URI:Landroid/net/Uri;

    const-string v3, "authority=? AND feed!=? AND _sync_account=? AND _sync_account_type=?"

    invoke-virtual {v0, v2, v3, v4}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1

    .line 3660
    :catchall_0
    move-exception v0

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    throw v0
.end method

.method private notifyDatasetChanged(Z)V
    .locals 1
    .param p1, "scheduleSync"    # Z

    .prologue
    .line 6449
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->inTransaction()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 6452
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mTransactionListener:Lcom/google/android/gm/provider/GmailTransactionListener;

    invoke-virtual {v0, p1}, Lcom/google/android/gm/provider/GmailTransactionListener;->enableGmailAccountNotifications(Z)V

    .line 6456
    :goto_0
    return-void

    .line 6454
    :cond_0
    invoke-virtual {p0, p1}, Lcom/google/android/gm/provider/MailEngine;->sendAccountNotifications(Z)V

    goto :goto_0
.end method

.method private notifyInitializationComplete()V
    .locals 7

    .prologue
    .line 1126
    iget-object v6, p0, Lcom/google/android/gm/provider/MailEngine;->mInitializationLock:Ljava/lang/Object;

    monitor-enter v6

    .line 1127
    const/4 v4, 0x1

    :try_start_0
    iput-boolean v4, p0, Lcom/google/android/gm/provider/MailEngine;->mInitializationComplete:Z

    .line 1128
    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine;->mInitCallbacks:Ljava/util/List;

    if-eqz v4, :cond_1

    .line 1129
    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine;->mInitCallbacks:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v3

    .line 1130
    .local v3, "numCallbacks":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v3, :cond_0

    .line 1131
    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine;->mInitCallbacks:Ljava/util/List;

    invoke-interface {v4, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/util/Pair;

    .line 1134
    .local v1, "callbackInfo":Landroid/util/Pair;, "Landroid/util/Pair<Landroid/os/Handler;Lcom/google/android/gm/provider/MailEngine$MailEngineInitListener;>;"
    iget-object v4, v1, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v4, Landroid/os/Handler;

    iget-object v5, v1, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v5, Lcom/google/android/gm/provider/MailEngine$MailEngineInitListener;

    invoke-direct {p0, v4, v5}, Lcom/google/android/gm/provider/MailEngine;->callInitializationListener(Landroid/os/Handler;Lcom/google/android/gm/provider/MailEngine$MailEngineInitListener;)V

    .line 1130
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 1136
    .end local v1    # "callbackInfo":Landroid/util/Pair;, "Landroid/util/Pair<Landroid/os/Handler;Lcom/google/android/gm/provider/MailEngine$MailEngineInitListener;>;"
    :cond_0
    const/4 v4, 0x0

    iput-object v4, p0, Lcom/google/android/gm/provider/MailEngine;->mInitCallbacks:Ljava/util/List;

    .line 1138
    .end local v2    # "i":I
    .end local v3    # "numCallbacks":I
    :cond_1
    monitor-exit v6
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1142
    invoke-direct {p0}, Lcom/google/android/gm/provider/MailEngine;->calculateUnknownSyncRationalesAndPurgeInBackground()V

    .line 1143
    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    iget-object v4, v4, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-direct {p0}, Lcom/google/android/gm/provider/MailEngine;->getCursorForCustomLabelColors()Landroid/database/Cursor;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/google/android/gm/utils/LabelColorUtils;->instantiateCustomLabelColors(Ljava/lang/String;Landroid/database/Cursor;)V

    .line 1145
    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    iget-object v4, v4, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-static {v4}, Lcom/google/android/gm/provider/UiProvider;->getAccountUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 1146
    .local v0, "accountUri":Landroid/net/Uri;
    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    invoke-virtual {v4}, Lcom/google/android/gm/provider/MailCore;->getCursorForCustomFrom()Landroid/database/Cursor;

    move-result-object v4

    invoke-static {v0, v4}, Lcom/google/android/gm/utils/CustomFromUtils;->instantiateCustomFrom(Landroid/net/Uri;Landroid/database/Cursor;)V

    .line 1147
    invoke-direct {p0}, Lcom/google/android/gm/provider/MailEngine;->getCursorForReplyFromDefaultAddress()Landroid/database/Cursor;

    move-result-object v4

    invoke-static {v0, v4}, Lcom/google/android/gm/utils/CustomFromUtils;->instantiateReplyFromDefaultAddress(Landroid/net/Uri;Landroid/database/Cursor;)V

    .line 1149
    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    iget-object v4, v4, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-direct {p0}, Lcom/google/android/gm/provider/MailEngine;->getCursorForServerPrefs()Landroid/database/Cursor;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/google/android/gm/utils/OutgoingMsgPrefs;->instantiateOutgoingPrefs(Ljava/lang/String;Landroid/database/Cursor;)V

    .line 1150
    return-void

    .line 1138
    .end local v0    # "accountUri":Landroid/net/Uri;
    :catchall_0
    move-exception v4

    :try_start_1
    monitor-exit v6
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v4
.end method

.method private notifyStatusChange()V
    .locals 5

    .prologue
    .line 1798
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    iget-object v0, v1, Landroid/accounts/Account;->name:Ljava/lang/String;

    .line 1799
    .local v0, "accountName":Ljava/lang/String;
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    invoke-static {v0}, Lcom/google/android/gm/provider/Gmail;->getStatusUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;Z)V

    .line 1801
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    invoke-static {v1, v0}, Lcom/google/android/gm/provider/UiProvider;->notifyAccountChanged(Landroid/content/Context;Ljava/lang/String;)V

    .line 1802
    return-void
.end method

.method private onConversationChanged(JLcom/google/android/gm/provider/MailSync$SyncRationale;)V
    .locals 1
    .param p1, "conversationId"    # J
    .param p3, "rationale"    # Lcom/google/android/gm/provider/MailSync$SyncRationale;

    .prologue
    .line 4132
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    invoke-virtual {v0, p1, p2, p3}, Lcom/google/android/gm/provider/MailCore;->onConversationChanged(JLcom/google/android/gm/provider/MailSync$SyncRationale;)V

    .line 4134
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mTransactionListener:Lcom/google/android/gm/provider/GmailTransactionListener;

    invoke-virtual {v0, p1, p2}, Lcom/google/android/gm/provider/GmailTransactionListener;->addConversationToNotify(J)V

    .line 4135
    return-void
.end method

.method private onConversationChanged(JLcom/google/android/gm/provider/MailSync$SyncRationale;ZZ)V
    .locals 6
    .param p1, "conversationId"    # J
    .param p3, "rationale"    # Lcom/google/android/gm/provider/MailSync$SyncRationale;
    .param p4, "updateSynced"    # Z
    .param p5, "messageLabelChange"    # Z

    .prologue
    .line 4139
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    move-wide v1, p1

    move-object v3, p3

    move v4, p4

    move v5, p5

    invoke-virtual/range {v0 .. v5}, Lcom/google/android/gm/provider/MailCore;->onConversationChanged(JLcom/google/android/gm/provider/MailSync$SyncRationale;ZZ)V

    .line 4142
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mTransactionListener:Lcom/google/android/gm/provider/GmailTransactionListener;

    invoke-virtual {v0, p1, p2}, Lcom/google/android/gm/provider/GmailTransactionListener;->addConversationToNotify(J)V

    .line 4143
    return-void
.end method

.method private onLabelsPossiblyLoaded()V
    .locals 4

    .prologue
    .line 1155
    iget-object v3, p0, Lcom/google/android/gm/provider/MailEngine;->mLabelMap:Lcom/google/android/gm/provider/Gmail$LabelMap;

    invoke-virtual {v3}, Lcom/google/android/gm/provider/Gmail$LabelMap;->labelsSynced()Z

    move-result v3

    if-eqz v3, :cond_0

    iget-boolean v3, p0, Lcom/google/android/gm/provider/MailEngine;->mNotificationsRequestsRegistered:Z

    if-eqz v3, :cond_1

    .line 1177
    :cond_0
    :goto_0
    return-void

    .line 1156
    :cond_1
    const/4 v3, 0x1

    iput-boolean v3, p0, Lcom/google/android/gm/provider/MailEngine;->mNotificationsRequestsRegistered:Z

    .line 1160
    const/4 v1, 0x0

    .line 1163
    .local v1, "labelsChanged":Z
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    sget-object v3, Lcom/google/android/gm/provider/MailEngine;->CLIENT_CREATED_LOCAL_LABELS:[Ljava/lang/String;

    array-length v3, v3

    if-ge v0, v3, :cond_3

    .line 1164
    sget-object v3, Lcom/google/android/gm/provider/MailEngine;->CLIENT_CREATED_LOCAL_LABELS:[Ljava/lang/String;

    aget-object v2, v3, v0

    .line 1165
    .local v2, "localLabel":Ljava/lang/String;
    iget-object v3, p0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    invoke-virtual {v3, v2}, Lcom/google/android/gm/provider/MailCore;->getLabelOrNull(Ljava/lang/String;)Lcom/google/android/gm/provider/MailCore$Label;

    move-result-object v3

    if-nez v3, :cond_2

    .line 1166
    iget-object v3, p0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    invoke-virtual {v3, v2}, Lcom/google/android/gm/provider/MailCore;->getOrAddLabel(Ljava/lang/String;)Lcom/google/android/gm/provider/MailCore$Label;

    .line 1167
    const/4 v1, 0x1

    .line 1163
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 1174
    .end local v2    # "localLabel":Ljava/lang/String;
    :cond_3
    invoke-direct {p0}, Lcom/google/android/gm/provider/MailEngine;->updateMailCoreConfig()V

    .line 1176
    iget-object v3, p0, Lcom/google/android/gm/provider/MailEngine;->mMailStore:Lcom/google/android/gm/provider/MailStore;

    invoke-interface {v3}, Lcom/google/android/gm/provider/MailStore;->updateNotificationLabels()V

    goto :goto_0
.end method

.method private openDatabase(Landroid/content/Context;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 1476
    const-string v0, "ME.openDatabase"

    invoke-static {v0}, Lcom/google/android/gm/perf/Timer;->startTiming(Ljava/lang/String;)V

    .line 1477
    new-instance v0, Lcom/google/android/gm/provider/MailEngine$MailStoreOpenHelper;

    invoke-direct {v0, p0, p1, p2}, Lcom/google/android/gm/provider/MailEngine$MailStoreOpenHelper;-><init>(Lcom/google/android/gm/provider/MailEngine;Landroid/content/Context;Ljava/lang/String;)V

    .line 1479
    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailEngine$MailStoreOpenHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    .line 1481
    const-string v0, "ME.openDatabase"

    invoke-static {v0}, Lcom/google/android/gm/perf/Timer;->stopTiming(Ljava/lang/String;)V

    .line 1482
    return-void
.end method

.method private openInternalDatabase(Landroid/content/Context;Ljava/lang/String;)V
    .locals 4

    .prologue
    const/4 v3, 0x2

    .line 1490
    const-string v0, "ME.openDatabase"

    invoke-static {v0}, Lcom/google/android/gm/perf/Timer;->startTiming(Ljava/lang/String;)V

    .line 1491
    const/4 v0, 0x0

    const/4 v1, 0x0

    new-instance v2, Landroid/database/DefaultDatabaseErrorHandler;

    invoke-direct {v2}, Landroid/database/DefaultDatabaseErrorHandler;-><init>()V

    invoke-virtual {p1, p2, v0, v1, v2}, Landroid/content/Context;->openOrCreateDatabase(Ljava/lang/String;ILandroid/database/sqlite/SQLiteDatabase$CursorFactory;Landroid/database/DatabaseErrorHandler;)Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mInternalDb:Landroid/database/sqlite/SQLiteDatabase;

    .line 1493
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mInternalDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransactionNonExclusive()V

    .line 1495
    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mInternalDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->getVersion()I

    move-result v0

    .line 1496
    new-instance v1, Lcom/google/android/gm/provider/InternalSettingsDbInitializer;

    invoke-direct {v1, p0}, Lcom/google/android/gm/provider/InternalSettingsDbInitializer;-><init>(Lcom/google/android/gm/provider/MailEngine;)V

    .line 1497
    if-nez v0, :cond_1

    .line 1498
    invoke-virtual {v1}, Lcom/google/android/gm/provider/InternalSettingsDbInitializer;->bootstrapDatabase()V

    .line 1502
    :cond_0
    :goto_0
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mInternalDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->getVersion()I

    move-result v1

    if-eq v1, v3, :cond_2

    .line 1503
    new-instance v1, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Failed to upgrade internal db from version "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, " to "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/4 v2, 0x2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1509
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mInternalDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    throw v0

    .line 1499
    :cond_1
    if-eq v0, v3, :cond_0

    .line 1500
    const/4 v2, 0x2

    :try_start_1
    invoke-virtual {v1, v2}, Lcom/google/android/gm/provider/DatabaseInitializer;->performUpgrade(I)V

    goto :goto_0

    .line 1507
    :cond_2
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mInternalDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1509
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mInternalDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 1511
    const-string v0, "ME.openDatabase"

    invoke-static {v0}, Lcom/google/android/gm/perf/Timer;->stopTiming(Ljava/lang/String;)V

    .line 1512
    return-void
.end method

.method private purgeSomeStaleMessagesInTransaction()Z
    .locals 10

    .prologue
    const/4 v1, 0x1

    const/4 v3, 0x0

    .line 3701
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailSync;->getLowestMessageIdInDurationOrZero()J

    move-result-wide v4

    .line 3702
    const-string v0, "Gmail"

    const-string v2, "Starting purging messages. Oldest message id in duration: %d"

    new-array v6, v1, [Ljava/lang/Object;

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    aput-object v7, v6, v3

    invoke-static {v0, v2, v6}, Lcom/google/android/gm/provider/LogUtils;->v(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 3705
    new-array v0, v1, [Ljava/lang/String;

    invoke-static {v4, v5}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v0, v3

    .line 3706
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "SELECT _id FROM conversations\nWHERE\n  (syncRationale = \'"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v4, Lcom/google/android/gm/provider/MailSync$SyncRationale;->NONE:Lcom/google/android/gm/provider/MailSync$SyncRationale;

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, "\'\n"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, "OR (syncRationale = \'"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v4, Lcom/google/android/gm/provider/MailSync$SyncRationale;->DURATION:Lcom/google/android/gm/provider/MailSync$SyncRationale;

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, "\'"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, "  AND syncRationaleMessageId < ?"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, ")) AND queryId = 0 LIMIT 100"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 3714
    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v4, v2, v0}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v4

    move v0, v3

    .line 3716
    :cond_0
    :goto_0
    :try_start_0
    invoke-interface {v4}, Landroid/database/Cursor;->moveToNext()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 3717
    const/4 v2, 0x0

    invoke-interface {v4, v2}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v5

    .line 3719
    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mOperations:Lcom/google/android/gm/provider/Operations;

    invoke-virtual {v2, v5, v6}, Lcom/google/android/gm/provider/Operations;->hasUnackedSendOrSaveOperationsForConversation(J)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 3720
    const-string v2, "Gmail"

    const-string v7, " Conversation ID %d has unacked send or save operations."

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v8, v9

    invoke-static {v2, v7, v8}, Lcom/google/android/gm/provider/LogUtils;->v(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    move v2, v3

    .line 3725
    :goto_1
    if-eqz v2, :cond_0

    move v0, v1

    .line 3726
    goto :goto_0

    .line 3723
    :cond_1
    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    invoke-virtual {v2, v5, v6}, Lcom/google/android/gm/provider/MailCore;->purgeConversation(J)Z

    move-result v2

    goto :goto_1

    .line 3730
    :cond_2
    const-string v1, "Gmail"

    const-string v2, "Finished purging messages "

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v1, v2, v3}, Lcom/google/android/gm/provider/LogUtils;->v(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 3733
    invoke-interface {v4}, Landroid/database/Cursor;->close()V

    return v0

    :catchall_0
    move-exception v0

    invoke-interface {v4}, Landroid/database/Cursor;->close()V

    throw v0
.end method

.method private requestIndex()V
    .locals 1

    .prologue
    .line 1554
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/gm/provider/MailEngine;->mMailIndexRequested:Z

    .line 1555
    return-void
.end method

.method private runHttpRequest(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/google/android/gm/provider/MailEngine$AuthenticationException;
        }
    .end annotation

    .prologue
    .line 2138
    invoke-static {p1}, Landroid/net/http/AndroidHttpClient;->modifyRequestToAcceptGzipResponse(Lorg/apache/http/HttpRequest;)V

    .line 2140
    :try_start_0
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/MailEngine;->runHttpRequestInternal(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    :try_end_0
    .catch Lcom/google/android/gm/provider/MailEngine$AuthenticationException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 2144
    :goto_0
    return-object v0

    .line 2141
    :catch_0
    move-exception v0

    .line 2142
    const-string v0, "Gmail"

    const-string v1, "Authentication error, token invalidated, retrying"

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 2144
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/MailEngine;->runHttpRequestInternal(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v0

    goto :goto_0
.end method

.method private runHttpRequestInternal(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/google/android/gm/provider/MailEngine$AuthenticationException;
        }
    .end annotation

    .prologue
    .line 2156
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine;->getAuthToken()Ljava/lang/String;

    move-result-object v0

    .line 2157
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mUrls:Lcom/google/android/gm/provider/Urls;

    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mCookieStore:Lorg/apache/http/client/CookieStore;

    invoke-virtual {v1, v0, v2}, Lcom/google/android/gm/provider/Urls;->newHttpContext(Ljava/lang/String;Lorg/apache/http/client/CookieStore;)Lorg/apache/http/protocol/HttpContext;

    move-result-object v1

    .line 2160
    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mHttpRequestRunner:Lcom/google/android/gm/provider/MailEngine$HttpRequestRunner;

    invoke-direct {p0}, Lcom/google/android/gm/provider/MailEngine;->getHttpClient()Lcom/google/android/common/http/GoogleHttpClient;

    move-result-object v3

    invoke-interface {v2, v3, p1, v1}, Lcom/google/android/gm/provider/MailEngine$HttpRequestRunner;->runHttpRequest(Lorg/apache/http/client/HttpClient;Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;

    move-result-object v1

    .line 2163
    iget-boolean v2, p0, Lcom/google/android/gm/provider/MailEngine;->mFakeIoException:Z

    if-eqz v2, :cond_0

    .line 2164
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/android/gm/provider/MailEngine;->mFakeIoException:Z

    .line 2165
    new-instance v0, Ljava/io/IOException;

    const-string v1, "Fake io exception"

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 2168
    :cond_0
    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    invoke-virtual {v2, v1}, Lcom/google/android/gm/provider/MailSync;->responseContainsAuthFailure(Lorg/apache/http/HttpResponse;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 2169
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    invoke-static {v1}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v1

    const-string v2, "com.google"

    invoke-virtual {v1, v2, v0}, Landroid/accounts/AccountManager;->invalidateAuthToken(Ljava/lang/String;Ljava/lang/String;)V

    .line 2171
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mCookieStore:Lorg/apache/http/client/CookieStore;

    invoke-interface {v0}, Lorg/apache/http/client/CookieStore;->clear()V

    .line 2172
    new-instance v0, Lcom/google/android/gm/provider/MailEngine$AuthenticationException;

    const-string v1, "authtoken is invalid"

    invoke-direct {v0, v1}, Lcom/google/android/gm/provider/MailEngine$AuthenticationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 2175
    :cond_1
    return-object v1
.end method

.method private runSyncLoop(Lcom/google/android/gm/provider/MailEngine$MailEngineSyncObserver;ZLcom/google/android/gm/provider/MailEngine$SyncInfo;Landroid/content/SyncResult;Landroid/os/Bundle;)Z
    .locals 10
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/google/android/gm/provider/MailEngine$AuthenticationException;,
            Lcom/google/android/gm/provider/MailSync$ResponseParseException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 1897
    if-eqz p2, :cond_3

    const/high16 v0, 0x200000

    .line 1900
    :goto_0
    invoke-static {}, Lcom/google/android/gm/provider/Gmail;->isRunningICSOrLater()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1901
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    iget-object v1, v1, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-static {v1}, Lcom/google/android/common/GoogleTrafficStats;->getDomainType(Ljava/lang/String;)I

    move-result v1

    .line 1904
    or-int/2addr v1, v0

    invoke-static {v1}, Landroid/net/TrafficStats;->setThreadStatsTag(I)V

    .line 1909
    :cond_0
    :try_start_0
    const-string v1, "Gmail"

    const-string v4, "runSyncLoop normalSync - %b"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    iget-boolean v7, p3, Lcom/google/android/gm/provider/MailEngine$SyncInfo;->normalSync:Z

    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v1, v4, v5}, Lcom/google/android/gm/provider/LogUtils;->v(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1913
    if-nez p2, :cond_4

    if-eqz p5, :cond_1

    const-string v1, "upload"

    invoke-virtual {p5, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_4

    :cond_1
    move v1, v2

    .line 1915
    :goto_1
    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    const/4 v5, 0x0

    invoke-virtual {v4, v1, p2, p3, v5}, Lcom/google/android/gm/provider/MailSync;->nextSyncRequest(ZZLcom/google/android/gm/provider/MailEngine$SyncInfo;Ljava/util/ArrayList;)Lorg/apache/http/client/methods/HttpUriRequest;

    move-result-object v1

    .line 1919
    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v4

    const-string v5, "gmail-max-sync-per-interval"

    const/16 v6, 0x32

    invoke-static {v4, v5, v6}, Lcom/google/android/gsf/Gservices;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v6

    move v4, v3

    move-object v5, v1

    .line 1922
    :goto_2
    if-eqz v5, :cond_9

    iget-boolean v1, p0, Lcom/google/android/gm/provider/MailEngine;->mIsSyncCancelled:Z

    if-nez v1, :cond_9

    .line 1924
    invoke-direct {p0, p4, v6}, Lcom/google/android/gm/provider/MailEngine;->detectTooManySyncLoops(Landroid/content/SyncResult;I)V

    .line 1926
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    .line 1927
    const-string v7, "gmail_discard_error_uphill_op_old_froyo"

    const/4 v8, 0x0

    invoke-static {v1, v7, v8}, Lcom/google/android/gsf/Gservices;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v1

    if-eqz v1, :cond_5

    move v1, v2

    .line 1930
    :goto_3
    if-eqz v1, :cond_2

    .line 1931
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine;->checkAndUpdateUnackedSettings()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1935
    :cond_2
    :try_start_1
    invoke-direct {p0, v5, p1, p3}, Lcom/google/android/gm/provider/MailEngine;->sendRequest(Lorg/apache/http/client/methods/HttpUriRequest;Lcom/google/android/gm/provider/MailEngine$MailEngineSyncObserver;Lcom/google/android/gm/provider/MailEngine$SyncInfo;)Z
    :try_end_1
    .catch Ljava/net/SocketTimeoutException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v1

    or-int/2addr v1, v4

    .line 1948
    :goto_4
    :try_start_2
    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    const/4 v5, 0x0

    const/4 v7, 0x0

    invoke-virtual {v4, v5, p2, p3, v7}, Lcom/google/android/gm/provider/MailSync;->nextSyncRequest(ZZLcom/google/android/gm/provider/MailEngine$SyncInfo;Ljava/util/ArrayList;)Lorg/apache/http/client/methods/HttpUriRequest;

    move-result-object v4

    .line 1949
    iget v5, p0, Lcom/google/android/gm/provider/MailEngine;->mSyncCountPerPeriod:I

    add-int/lit8 v5, v5, 0x1

    iput v5, p0, Lcom/google/android/gm/provider/MailEngine;->mSyncCountPerPeriod:I

    move-object v5, v4

    move v4, v1

    .line 1950
    goto :goto_2

    .line 1897
    :cond_3
    const/high16 v0, 0x100000

    goto :goto_0

    :cond_4
    move v1, v3

    .line 1913
    goto :goto_1

    :cond_5
    move v1, v3

    .line 1927
    goto :goto_3

    .line 1936
    :catch_0
    move-exception v1

    .line 1937
    iget-object v5, p0, Lcom/google/android/gm/provider/MailEngine;->mMailStore:Lcom/google/android/gm/provider/MailStore;

    invoke-interface {v5, p3}, Lcom/google/android/gm/provider/MailStore;->getConversationInfosToFetch(Lcom/google/android/gm/provider/MailEngine$SyncInfo;)Ljava/util/ArrayList;

    move-result-object v5

    .line 1939
    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v7

    if-lez v7, :cond_6

    .line 1940
    const-string v7, "Gmail"

    const-string v8, "Exception during conversation sync. Will attempt to fetch one conversation at a time"

    const/4 v9, 0x0

    new-array v9, v9, [Ljava/lang/Object;

    invoke-static {v7, v1, v8, v9}, Lcom/google/android/gm/provider/LogUtils;->w(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1942
    invoke-direct {p0, p3, p1, v5}, Lcom/google/android/gm/provider/MailEngine;->syncConversations(Lcom/google/android/gm/provider/MailEngine$SyncInfo;Lcom/google/android/gm/provider/MailEngine$MailEngineSyncObserver;Ljava/util/ArrayList;)Z

    move-result v1

    or-int/2addr v1, v4

    goto :goto_4

    .line 1944
    :cond_6
    throw v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 1965
    :catchall_0
    move-exception v1

    invoke-static {}, Lcom/google/android/gm/provider/Gmail;->isRunningICSOrLater()Z

    move-result v2

    if-eqz v2, :cond_8

    .line 1966
    if-eqz p1, :cond_7

    .line 1967
    invoke-virtual {p1}, Lcom/google/android/gm/provider/MailEngine$MailEngineSyncObserver;->getOperationCount()I

    move-result v2

    invoke-static {v0, v2}, Landroid/net/TrafficStats;->incrementOperationCount(II)V

    .line 1969
    :cond_7
    invoke-static {}, Landroid/net/TrafficStats;->clearThreadStatsTag()V

    .line 1971
    :cond_8
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailSync;->onSyncLoopEnd()V

    throw v1

    .line 1952
    :cond_9
    :try_start_3
    invoke-direct {p0}, Lcom/google/android/gm/provider/MailEngine;->makeRight()V

    .line 1954
    invoke-direct {p0}, Lcom/google/android/gm/provider/MailEngine;->startIndexingIfNeeded()V

    .line 1957
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/MailSync;->saveDirtySettings()V

    .line 1960
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    const-wide/16 v5, 0x2710

    rem-long/2addr v1, v5

    const-wide/16 v5, 0x0

    cmp-long v1, v1, v5

    if-nez v1, :cond_a

    .line 1961
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "VACUUM"

    invoke-virtual {v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 1965
    :cond_a
    invoke-static {}, Lcom/google/android/gm/provider/Gmail;->isRunningICSOrLater()Z

    move-result v1

    if-eqz v1, :cond_c

    .line 1966
    if-eqz p1, :cond_b

    .line 1967
    invoke-virtual {p1}, Lcom/google/android/gm/provider/MailEngine$MailEngineSyncObserver;->getOperationCount()I

    move-result v1

    invoke-static {v0, v1}, Landroid/net/TrafficStats;->incrementOperationCount(II)V

    .line 1969
    :cond_b
    invoke-static {}, Landroid/net/TrafficStats;->clearThreadStatsTag()V

    .line 1971
    :cond_c
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailSync;->onSyncLoopEnd()V

    return v4
.end method

.method private sendNotificationIntent(Lcom/google/android/gm/provider/MailCore$Label;Lcom/google/android/gm/provider/MailCore$Label;IIZ)V
    .locals 5

    .prologue
    .line 3848
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    invoke-virtual {v0, p1}, Lcom/google/android/gm/provider/MailCore;->getLabelCanonicalNameOrThrow(Lcom/google/android/gm/provider/MailCore$Label;)Ljava/lang/String;

    move-result-object v0

    .line 3849
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    invoke-virtual {v1, p2}, Lcom/google/android/gm/provider/MailCore;->getLabelCanonicalNameOrThrow(Lcom/google/android/gm/provider/MailCore$Label;)Ljava/lang/String;

    move-result-object v1

    .line 3852
    new-instance v2, Landroid/content/Intent;

    const-string v3, "com.android.mail.action.update_notification"

    invoke-direct {v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 3853
    const-string v3, "application/gmail-ls"

    invoke-virtual {v2, v3}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 3855
    const-string v3, "notification_extra_folder"

    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    iget-object v4, v4, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-static {v4, v0}, Lcom/google/android/gm/provider/UiProvider;->getAccountLabelUri(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 3857
    const-string v3, "notification_extra_account"

    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    iget-object v4, v4, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-static {v4}, Lcom/google/android/gm/provider/UiProvider;->getAccountUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 3859
    const-string v3, "notification_updated_unread_count"

    invoke-virtual {v2, v3, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 3862
    const-string v3, "account"

    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    iget-object v4, v4, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 3863
    const-string v3, "count"

    invoke-virtual {v2, v3, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 3864
    const-string v3, "unseenCount"

    invoke-virtual {v2, v3, p4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 3865
    const-string v3, "getAttention"

    invoke-virtual {v2, v3, p5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 3866
    const-string v3, "tagLabel"

    invoke-virtual {v2, v3, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 3867
    const-string v1, "notificationLabel"

    invoke-virtual {v2, v1, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 3868
    const-string v0, "Gmail"

    const-string v1, "Sending notification intent: %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v2, v3, v4

    invoke-static {v0, v1, v3}, Lcom/google/android/gm/provider/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 3871
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mProviderChangedBroadcastWakeLock:Landroid/os/PowerManager$WakeLock;

    if-eqz v0, :cond_0

    .line 3872
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mProviderChangedBroadcastWakeLock:Landroid/os/PowerManager$WakeLock;

    const-wide/16 v3, 0x7d0

    invoke-virtual {v0, v3, v4}, Landroid/os/PowerManager$WakeLock;->acquire(J)V

    .line 3874
    :cond_0
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    const/4 v1, 0x0

    invoke-virtual {v0, v2, v1}, Landroid/content/Context;->sendOrderedBroadcast(Landroid/content/Intent;Ljava/lang/String;)V

    .line 3875
    return-void
.end method

.method private sendRequest(Lorg/apache/http/client/methods/HttpUriRequest;Lcom/google/android/gm/provider/MailEngine$MailEngineSyncObserver;Lcom/google/android/gm/provider/MailEngine$SyncInfo;)Z
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/google/android/gm/provider/MailEngine$AuthenticationException;,
            Lcom/google/android/gm/provider/MailSync$ResponseParseException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 2008
    .line 2009
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/MailEngine;->runHttpRequest(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v1

    .line 2011
    :try_start_0
    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    invoke-virtual {v2, v1, p2, p3}, Lcom/google/android/gm/provider/MailSync;->handleSyncResponse(Lorg/apache/http/HttpResponse;Lcom/google/android/gm/provider/MailSyncObserver;Lcom/google/android/gm/provider/MailEngine$SyncInfo;)V

    .line 2026
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine;->purgeStaleMessagesOutsideTransaction()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 2027
    const/4 v0, 0x1

    .line 2032
    :cond_0
    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    const-string v3, "moreForwardSyncNeeded"

    invoke-virtual {v2, v3}, Lcom/google/android/gm/provider/MailSync;->getBooleanSetting(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 2033
    const/4 v2, 0x0

    invoke-direct {p0, v2}, Lcom/google/android/gm/provider/MailEngine;->notifyDatasetChanged(Z)V

    .line 2036
    :cond_1
    invoke-static {}, Ljava/lang/System;->gc()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 2038
    invoke-interface {v1}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v1

    .line 2039
    if-eqz v1, :cond_2

    invoke-interface {v1}, Lorg/apache/http/HttpEntity;->consumeContent()V

    .line 2041
    :cond_2
    return v0

    .line 2038
    :catchall_0
    move-exception v0

    invoke-interface {v1}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v1

    .line 2039
    if-eqz v1, :cond_3

    invoke-interface {v1}, Lorg/apache/http/HttpEntity;->consumeContent()V

    .line 2040
    :cond_3
    throw v0
.end method

.method private setLastSyncResult(I)V
    .locals 4
    .param p1, "result"    # I

    .prologue
    .line 1810
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine;->getCurrentSyncRequest()I

    move-result v1

    .line 1811
    .local v1, "syncStatus":I
    iget-object v3, p0, Lcom/google/android/gm/provider/MailEngine;->mStatusLock:Ljava/lang/Object;

    monitor-enter v3

    .line 1813
    :try_start_0
    iget v2, p0, Lcom/google/android/gm/provider/MailEngine;->mLastSyncResult:I

    and-int/lit8 v0, v2, 0xf

    .line 1814
    .local v0, "currentResult":I
    if-eq v0, p1, :cond_0

    .line 1816
    shl-int/lit8 v2, v1, 0x4

    or-int/2addr v2, p1

    iput v2, p0, Lcom/google/android/gm/provider/MailEngine;->mLastSyncResult:I

    .line 1817
    invoke-direct {p0}, Lcom/google/android/gm/provider/MailEngine;->notifyStatusChange()V

    .line 1819
    :cond_0
    monitor-exit v3

    .line 1820
    return-void

    .line 1819
    .end local v0    # "currentResult":I
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2
.end method

.method private setRefreshStatus()V
    .locals 4

    .prologue
    .line 6647
    const/4 v0, 0x4

    const/4 v1, 0x1

    invoke-direct {p0, v0, v1}, Lcom/google/android/gm/provider/MailEngine;->changeTaskState(IZ)V

    .line 6650
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mBackgroundTaskHandler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mRemoveRefeshStatusRunnable:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 6651
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/android/gm/provider/MailEngine;->mUserRefreshCompleted:Z

    .line 6652
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mBackgroundTaskHandler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mRemoveRefeshStatusRunnable:Ljava/lang/Runnable;

    iget v2, p0, Lcom/google/android/gm/provider/MailEngine;->mRemoveRefreshStatusDelayMs:I

    int-to-long v2, v2

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 6654
    return-void
.end method

.method private setSettingsValue(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 1618
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 1619
    const-string v1, "name"

    invoke-virtual {v0, v1, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1620
    const-string v1, "value"

    invoke-virtual {v0, v1, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1621
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "engine_settings"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3, v0}, Landroid/database/sqlite/SQLiteDatabase;->replace(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 1622
    return-void
.end method

.method static setSyncSetting(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 1635
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 1636
    const-string v1, "name"

    invoke-virtual {v0, v1, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1637
    const-string v1, "value"

    invoke-virtual {v0, v1, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1638
    const-string v1, "sync_settings"

    const/4 v2, 0x0

    invoke-virtual {p0, v1, v2, v0}, Landroid/database/sqlite/SQLiteDatabase;->replace(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 1639
    return-void
.end method

.method private setSyncSetting(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 1628
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-static {v0, p1, p2}, Lcom/google/android/gm/provider/MailEngine;->setSyncSetting(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)V

    .line 1629
    return-void
.end method

.method static setTestingHttpRequestRunner(Lcom/google/android/gm/provider/MailEngine$HttpRequestRunner;)V
    .locals 0
    .param p0, "runner"    # Lcom/google/android/gm/provider/MailEngine$HttpRequestRunner;

    .prologue
    .line 878
    sput-object p0, Lcom/google/android/gm/provider/MailEngine;->sTestingHttpRequestRunner:Lcom/google/android/gm/provider/MailEngine$HttpRequestRunner;

    .line 879
    return-void
.end method

.method static setTestingMailEnginePreference(Lcom/google/android/gm/provider/MailEngine$Preferences;)V
    .locals 0
    .param p0, "preferences"    # Lcom/google/android/gm/provider/MailEngine$Preferences;

    .prologue
    .line 882
    sput-object p0, Lcom/google/android/gm/provider/MailEngine;->sTestingPreferences:Lcom/google/android/gm/provider/MailEngine$Preferences;

    .line 883
    return-void
.end method

.method private startIndexingIfNeeded()V
    .locals 1

    .prologue
    .line 1522
    iget-boolean v0, p0, Lcom/google/android/gm/provider/MailEngine;->mMailIndexRequested:Z

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine;->isFullTextSearchEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1523
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine;->scheduleIndexing()V

    .line 1525
    :cond_0
    return-void
.end method

.method private syncConversations(Lcom/google/android/gm/provider/MailEngine$SyncInfo;Lcom/google/android/gm/provider/MailEngine$MailEngineSyncObserver;Ljava/util/ArrayList;)Z
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gm/provider/MailEngine$SyncInfo;",
            "Lcom/google/android/gm/provider/MailEngine$MailEngineSyncObserver;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/google/android/gm/provider/MailSync$ConversationInfo;",
            ">;)Z"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/google/android/gm/provider/MailEngine$AuthenticationException;,
            Lcom/google/android/gm/provider/MailSync$ResponseParseException;
        }
    .end annotation

    .prologue
    const/4 v11, 0x1

    const/4 v1, 0x0

    .line 2050
    .line 2052
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v0, v1, v11, p1, v2}, Lcom/google/android/gm/provider/MailSync;->nextSyncRequest(ZZLcom/google/android/gm/provider/MailEngine$SyncInfo;Ljava/util/ArrayList;)Lorg/apache/http/client/methods/HttpUriRequest;

    move-result-object v0

    .line 2054
    if-eqz v0, :cond_3

    .line 2055
    invoke-direct {p0, v0, p2, p1}, Lcom/google/android/gm/provider/MailEngine;->sendRequest(Lorg/apache/http/client/methods/HttpUriRequest;Lcom/google/android/gm/provider/MailEngine$MailEngineSyncObserver;Lcom/google/android/gm/provider/MailEngine$SyncInfo;)Z

    move-result v0

    .line 2058
    :goto_0
    invoke-virtual {p3}, Ljava/util/ArrayList;->size()I

    move-result v4

    .line 2059
    const-string v2, "Gmail"

    const-string v3, "Fetching conversations one by one: %d"

    new-array v5, v11, [Ljava/lang/Object;

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v5, v1

    invoke-static {v2, v3, v5}, Lcom/google/android/gm/provider/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    move v3, v1

    move v2, v0

    .line 2060
    :goto_1
    if-ge v3, v4, :cond_0

    .line 2061
    iget-boolean v0, p0, Lcom/google/android/gm/provider/MailEngine;->mIsSyncCancelled:Z

    if-eqz v0, :cond_1

    .line 2062
    const-string v0, "Gmail"

    const-string v3, "Sync canceled. Aborting."

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v3, v1}, Lcom/google/android/gm/provider/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 2081
    :cond_0
    return v2

    .line 2065
    :cond_1
    invoke-virtual {p3, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gm/provider/MailSync$ConversationInfo;

    .line 2066
    iget-wide v5, v0, Lcom/google/android/gm/provider/MailSync$ConversationInfo;->id:J

    .line 2068
    const-string v7, "Gmail"

    const-string v8, "Fetching conversation %d"

    new-array v9, v11, [Ljava/lang/Object;

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v10

    aput-object v10, v9, v1

    invoke-static {v7, v8, v9}, Lcom/google/android/gm/provider/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 2069
    iget-object v7, p0, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    new-array v8, v11, [Lcom/google/android/gm/provider/MailSync$ConversationInfo;

    aput-object v0, v8, v1

    invoke-static {v8}, Lcom/google/common/collect/Lists;->newArrayList([Ljava/lang/Object;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v7, v1, v1, p1, v0}, Lcom/google/android/gm/provider/MailSync;->nextSyncRequest(ZZLcom/google/android/gm/provider/MailEngine$SyncInfo;Ljava/util/ArrayList;)Lorg/apache/http/client/methods/HttpUriRequest;

    move-result-object v0

    .line 2072
    if-eqz v0, :cond_2

    .line 2074
    :try_start_0
    invoke-direct {p0, v0, p2, p1}, Lcom/google/android/gm/provider/MailEngine;->sendRequest(Lorg/apache/http/client/methods/HttpUriRequest;Lcom/google/android/gm/provider/MailEngine$MailEngineSyncObserver;Lcom/google/android/gm/provider/MailEngine$SyncInfo;)Z
    :try_end_0
    .catch Ljava/net/SocketTimeoutException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    or-int/2addr v0, v2

    .line 2060
    :goto_2
    add-int/lit8 v2, v3, 0x1

    move v3, v2

    move v2, v0

    goto :goto_1

    .line 2075
    :catch_0
    move-exception v0

    .line 2076
    const-string v7, "Gmail"

    const-string v8, "Exception while fetching conversation %d"

    new-array v9, v11, [Ljava/lang/Object;

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v10

    aput-object v10, v9, v1

    invoke-static {v7, v0, v8, v9}, Lcom/google/android/gm/provider/LogUtils;->w(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 2077
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mMailStore:Lcom/google/android/gm/provider/MailStore;

    invoke-interface {v0, v5, v6}, Lcom/google/android/gm/provider/MailStore;->delayConversationSync(J)V

    :cond_2
    move v0, v2

    goto :goto_2

    :cond_3
    move v0, v1

    goto :goto_0
.end method

.method private updateCachedAttachmentReferences(Landroid/content/ContentValues;Ljava/lang/String;)V
    .locals 11

    .prologue
    const/4 v10, 0x3

    const/4 v9, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 3031
    const-string v0, "joinedAttachmentInfos"

    invoke-virtual {p1, v0}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 3033
    invoke-static {v0}, Lcom/google/android/gm/provider/Gmail$MessageModification;->parseJoinedAttachmentString(Ljava/lang/String;)Ljava/util/List;

    move-result-object v5

    .line 3036
    invoke-static {p2}, Lcom/google/android/gm/provider/Gmail$MessageModification;->parseJoinedAttachmentString(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 3041
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v6

    .line 3042
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gm/provider/Gmail$Attachment;

    .line 3044
    if-eqz v0, :cond_0

    iget-object v2, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->cachedContent:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 3045
    new-array v2, v10, [Ljava/lang/Object;

    iget-object v7, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->name:Ljava/lang/String;

    aput-object v7, v2, v3

    iget-object v7, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->contentType:Ljava/lang/String;

    aput-object v7, v2, v4

    iget v7, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->size:I

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v2, v9

    invoke-static {v2}, Lcom/google/common/base/Objects;->hashCode([Ljava/lang/Object;)I

    move-result v2

    .line 3047
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v6, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 3054
    :cond_1
    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    move v2, v3

    :goto_1
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gm/provider/Gmail$Attachment;

    .line 3055
    if-eqz v0, :cond_4

    .line 3056
    new-array v1, v10, [Ljava/lang/Object;

    iget-object v8, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->name:Ljava/lang/String;

    aput-object v8, v1, v3

    iget-object v8, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->contentType:Ljava/lang/String;

    aput-object v8, v1, v4

    iget v8, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->size:I

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v1, v9

    invoke-static {v1}, Lcom/google/common/base/Objects;->hashCode([Ljava/lang/Object;)I

    move-result v1

    .line 3058
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v6, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gm/provider/Gmail$Attachment;

    .line 3059
    if-eqz v1, :cond_4

    .line 3060
    iget-object v1, v1, Lcom/google/android/gm/provider/Gmail$Attachment;->cachedContent:Ljava/lang/String;

    iput-object v1, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->cachedContent:Ljava/lang/String;

    move v0, v4

    :goto_2
    move v2, v0

    .line 3063
    goto :goto_1

    .line 3068
    :cond_2
    if-eqz v2, :cond_3

    .line 3069
    invoke-static {v5}, Lcom/google/android/gm/provider/Gmail$MessageModification;->joinedAttachmentsString(Ljava/util/List;)Ljava/lang/String;

    move-result-object v0

    .line 3072
    const-string v1, "joinedAttachmentInfos"

    invoke-virtual {p1, v1, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3074
    :cond_3
    return-void

    :cond_4
    move v0, v2

    goto :goto_2
.end method

.method private updateMailCoreConfig()V
    .locals 3

    .prologue
    .line 1438
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mLabelMap:Lcom/google/android/gm/provider/Gmail$LabelMap;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/Gmail$LabelMap;->labelsSynced()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1441
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/MailSync;->getLabelsIncludedArray()[Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/google/android/gm/provider/MailEngine;->getLabelsForCanonicalNames([Ljava/lang/String;)[Lcom/google/android/gm/provider/MailCore$Label;

    move-result-object v1

    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    invoke-virtual {v2}, Lcom/google/android/gm/provider/MailSync;->getLabelsPartialArray()[Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/google/android/gm/provider/MailEngine;->getLabelsForCanonicalNames([Ljava/lang/String;)[Lcom/google/android/gm/provider/MailCore$Label;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gm/provider/MailCore;->setConfig([Lcom/google/android/gm/provider/MailCore$Label;[Lcom/google/android/gm/provider/MailCore$Label;)V

    .line 1445
    :cond_0
    return-void
.end method

.method private declared-synchronized wipeAndResync(Ljava/lang/String;)V
    .locals 5
    .param p1, "reason"    # Ljava/lang/String;

    .prologue
    .line 837
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->setVersion(I)V

    .line 838
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mInternalDb:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->setVersion(I)V

    .line 842
    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mDbLock:Ljava/lang/Object;

    monitor-enter v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 843
    :try_start_1
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->close()V

    .line 844
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mInternalDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->close()V

    .line 845
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    .line 846
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mInternalDb:Landroid/database/sqlite/SQLiteDatabase;

    .line 847
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 849
    :try_start_2
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 850
    .local v0, "extras":Landroid/os/Bundle;
    const-string v1, "force"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 851
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    const-string v2, "gmail-ls"

    invoke-static {v1, v2, v0}, Landroid/content/ContentResolver;->requestSync(Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;)V

    .line 854
    const-string v1, "Gmail"

    new-instance v2, Ljava/lang/RuntimeException;

    invoke-direct {v2, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    const-string v3, "Wiping mail db: "

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v1, v2, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 855
    const/4 v1, -0x1

    invoke-static {v1}, Ljava/lang/System;->exit(I)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 856
    monitor-exit p0

    return-void

    .line 847
    .end local v0    # "extras":Landroid/os/Bundle;
    :catchall_0
    move-exception v1

    :try_start_3
    monitor-exit v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :try_start_4
    throw v1
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 837
    :catchall_1
    move-exception v1

    monitor-exit p0

    throw v1
.end method


# virtual methods
.method automaticSyncEnabled()Z
    .locals 2

    .prologue
    .line 831
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    const-string v1, "gmail-ls"

    invoke-static {v0, v1}, Landroid/content/ContentResolver;->getSyncAutomatically(Landroid/accounts/Account;Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method backgroundTasksDisabledForTesting()Z
    .locals 1

    .prologue
    .line 893
    iget-boolean v0, p0, Lcom/google/android/gm/provider/MailEngine;->mBackgroundTasksDisabledForTesting:Z

    return v0
.end method

.method beginTransaction(Z)V
    .locals 2
    .param p1, "suppressUiNotifications"    # Z

    .prologue
    .line 6717
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mTransactionListener:Lcom/google/android/gm/provider/GmailTransactionListener;

    invoke-virtual {v0, v1}, Lcom/google/android/gm/provider/TransactionHelper;->beginTransactionWithListenerNonExclusive(Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;)V

    .line 6718
    if-eqz p1, :cond_0

    .line 6719
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/TransactionHelper;->suppressUiNotifications()V

    .line 6721
    :cond_0
    return-void
.end method

.method public blockUntilBackgroundTasksComplete()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 6479
    const-string v0, "Gmail"

    const-string v1, "blockUntilBackgroundTasksComplete: queueing"

    new-array v2, v3, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 6480
    new-instance v0, Ljava/util/concurrent/Semaphore;

    invoke-direct {v0, v3}, Ljava/util/concurrent/Semaphore;-><init>(I)V

    .line 6481
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mBackgroundTaskHandler:Landroid/os/Handler;

    new-instance v2, Lcom/google/android/gm/provider/MailEngine$11;

    invoke-direct {v2, p0, v0}, Lcom/google/android/gm/provider/MailEngine$11;-><init>(Lcom/google/android/gm/provider/MailEngine;Ljava/util/concurrent/Semaphore;)V

    invoke-virtual {v1, v2}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 6488
    :try_start_0
    invoke-virtual {v0}, Ljava/util/concurrent/Semaphore;->acquire()V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 6492
    :goto_0
    return-void

    .line 6489
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method broadcastLabelNotificationsImpl(Ljava/util/Set;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Long;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    .line 1351
    const-string v0, "Gmail"

    const-string v1, "Broadcasting notifications for labels: %s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    aput-object p1, v2, v4

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1353
    if-eqz p1, :cond_0

    invoke-interface {p1}, Ljava/util/Set;->size()I

    move-result v0

    if-nez v0, :cond_1

    .line 1370
    :cond_0
    :goto_0
    return-void

    .line 1358
    :cond_1
    invoke-interface {p1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_2
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Long;

    .line 1359
    if-eqz v0, :cond_2

    .line 1360
    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    iget-object v3, p0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    iget-object v3, v3, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-static {v3, v0}, Lcom/google/android/gm/provider/Label;->getLabelUri(Ljava/lang/String;Ljava/lang/Long;)Landroid/net/Uri;

    move-result-object v0

    const/4 v3, 0x0

    invoke-virtual {v2, v0, v3, v4}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;Z)V

    goto :goto_1

    .line 1365
    :cond_3
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    iget-object v1, v1, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-static {v0, v1, p1}, Lcom/google/android/gm/provider/PublicContentProvider;->broadcastLabelNotifications(Landroid/content/Context;Ljava/lang/String;Ljava/util/Set;)V

    .line 1368
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine;->getLabelMap()Lcom/google/android/gm/provider/Gmail$LabelMap;

    move-result-object v1

    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    iget-object v2, v2, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-static {v0, v1, v2, p1}, Lcom/google/android/gm/provider/UiProvider;->broadcastFolderNotifications(Landroid/content/Context;Lcom/google/android/gm/provider/Gmail$LabelMap;Ljava/lang/String;Ljava/util/Set;)V

    goto :goto_0
.end method

.method cancelScheduledIndexRun()V
    .locals 2

    .prologue
    .line 1544
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    const-string v1, "alarm"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/AlarmManager;

    .line 1545
    if-eqz v0, :cond_0

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mStartAccountIndexingIntent:Landroid/app/PendingIntent;

    if-nez v1, :cond_1

    .line 1551
    :cond_0
    :goto_0
    return-void

    .line 1550
    :cond_1
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mStartAccountIndexingIntent:Landroid/app/PendingIntent;

    invoke-virtual {v0, v1}, Landroid/app/AlarmManager;->cancel(Landroid/app/PendingIntent;)V

    goto :goto_0
.end method

.method public checkAndUpdateUnackedSettings()V
    .locals 6

    .prologue
    .line 2085
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailSync;->getUnackedSentOperations()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2086
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mOperations:Lcom/google/android/gm/provider/Operations;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/Operations;->nextOperationId()I

    move-result v0

    .line 2087
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    const-string v2, "nextUnackedSentOp"

    invoke-virtual {v1, v2}, Lcom/google/android/gm/provider/MailSync;->getIntegerSetting(Ljava/lang/String;)I

    move-result v1

    .line 2089
    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    const-string v3, "errorCountNextUnackedSentOp"

    invoke-virtual {v2, v3}, Lcom/google/android/gm/provider/MailSync;->getIntegerSetting(Ljava/lang/String;)I

    move-result v2

    .line 2092
    if-ne v0, v1, :cond_1

    .line 2093
    add-int/lit8 v0, v2, 0x1

    .line 2094
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    const-string v2, "errorCountNextUnackedSentOp"

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v1, v2, v0}, Lcom/google/android/gm/provider/MailSync;->setIntegerSetting(Ljava/lang/String;Ljava/lang/Integer;)Z

    .line 2105
    :cond_0
    :goto_0
    return-void

    .line 2097
    :cond_1
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    const-string v2, "nextUnackedSentOp"

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v1, v2, v0}, Lcom/google/android/gm/provider/MailSync;->setIntegerSetting(Ljava/lang/String;Ljava/lang/Integer;)Z

    .line 2099
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    const-string v1, "errorCountNextUnackedSentOp"

    const/4 v2, 0x1

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gm/provider/MailSync;->setIntegerSetting(Ljava/lang/String;Ljava/lang/Integer;)Z

    .line 2101
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    const-string v1, "nextUnackedOpWriteTime"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    const-wide/16 v4, 0x3e8

    div-long/2addr v2, v4

    invoke-virtual {v0, v1, v2, v3}, Lcom/google/android/gm/provider/MailSync;->setLongSetting(Ljava/lang/String;J)Z

    goto :goto_0
.end method

.method public checkConsistency()V
    .locals 10
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 3927
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailSync;->getServerVersion()J

    move-result-wide v2

    const-wide/16 v4, 0x9

    cmp-long v0, v2, v4

    if-ltz v0, :cond_1

    .line 3928
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailSync;->getLabelsAllArray()[Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/common/collect/Sets;->newHashSet([Ljava/lang/Object;)Ljava/util/HashSet;

    move-result-object v0

    .line 3930
    const-string v2, "^^out"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 3932
    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 3933
    iget-object v3, p0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    invoke-virtual {v3, v0}, Lcom/google/android/gm/provider/MailCore;->getLabelOrThrow(Ljava/lang/String;)Lcom/google/android/gm/provider/MailCore$Label;

    move-result-object v3

    iget-wide v3, v3, Lcom/google/android/gm/provider/MailCore$Label;->id:J

    .line 3934
    const-wide/16 v5, 0x0

    cmp-long v3, v3, v5

    if-nez v3, :cond_0

    .line 3935
    new-instance v1, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Label id is zero for label "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 3941
    :cond_1
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailSync;->getLabelsIncludedArray()[Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/common/collect/Sets;->newHashSet([Ljava/lang/Object;)Ljava/util/HashSet;

    move-result-object v0

    .line 3942
    const-string v2, "^^out"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 3944
    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mLabelMap:Lcom/google/android/gm/provider/Gmail$LabelMap;

    invoke-virtual {v2}, Lcom/google/android/gm/provider/Gmail$LabelMap;->requery()V

    .line 3945
    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :cond_2
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    move-object v6, v0

    check-cast v6, Ljava/lang/String;

    .line 3946
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    invoke-virtual {v0, v6}, Lcom/google/android/gm/provider/MailCore;->getLabelOrThrow(Ljava/lang/String;)Lcom/google/android/gm/provider/MailCore$Label;

    move-result-object v0

    iget-wide v8, v0, Lcom/google/android/gm/provider/MailCore$Label;->id:J

    .line 3948
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "label:"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/4 v5, 0x0

    move-object v0, p0

    move-object v3, v1

    move-object v4, v1

    invoke-virtual/range {v0 .. v5}, Lcom/google/android/gm/provider/MailEngine;->getConversationCursorForQuery([Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Integer;Z)Landroid/database/Cursor;

    move-result-object v0

    .line 3952
    :try_start_0
    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v2

    int-to-long v2, v2

    .line 3954
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 3957
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mLabelMap:Lcom/google/android/gm/provider/Gmail$LabelMap;

    invoke-virtual {v0, v8, v9}, Lcom/google/android/gm/provider/Gmail$LabelMap;->getNumConversations(J)I

    move-result v0

    .line 3960
    int-to-long v4, v0

    cmp-long v4, v2, v4

    if-eqz v4, :cond_2

    const/16 v4, 0x9c4

    if-gt v0, v4, :cond_2

    .line 3961
    new-instance v1, Ljava/lang/IllegalStateException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Label counts do not match for label "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ": found "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " conversations in db but labels table says "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 3954
    :catchall_0
    move-exception v1

    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    throw v1

    .line 3967
    :cond_3
    return-void
.end method

.method public clearNewUnreadMailForNotificationLabel(Lcom/google/android/gm/provider/MailCore$Label;)I
    .locals 7

    .prologue
    const/4 v2, 0x0

    .line 3886
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    iget-wide v3, p1, Lcom/google/android/gm/provider/MailCore$Label;->id:J

    invoke-static {v3, v4}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v0, v2

    .line 3887
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "message_labels"

    const-string v4, "labels_id = ?"

    invoke-virtual {v1, v3, v4, v0}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 3888
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "conversation_labels"

    const-string v4, "labels_id = ?"

    invoke-virtual {v1, v3, v4, v0}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v6

    .line 3889
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    const v4, 0x7fffffff

    const-string v5, "SHOW"

    move-object v1, p1

    move v3, v2

    invoke-virtual/range {v0 .. v5}, Lcom/google/android/gm/provider/MailCore;->setLabelCounts(Lcom/google/android/gm/provider/MailCore$Label;IIILjava/lang/String;)V

    .line 3891
    invoke-virtual {p0, v2}, Lcom/google/android/gm/provider/MailEngine;->sendNotificationIntents(Z)V

    .line 3892
    return v6
.end method

.method clearNewUnreadMailForNotificationLabelIfNeeded(Lcom/google/android/gm/provider/MailCore$Label;)V
    .locals 7

    .prologue
    .line 3896
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/MailEngine;->getNotificationTagLabel(Lcom/google/android/gm/provider/MailCore$Label;)Lcom/google/android/gm/provider/MailCore$Label;

    move-result-object v0

    .line 3897
    if-nez v0, :cond_1

    .line 3906
    :cond_0
    :goto_0
    return-void

    .line 3900
    :cond_1
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mLabelMap:Lcom/google/android/gm/provider/Gmail$LabelMap;

    iget-wide v2, v0, Lcom/google/android/gm/provider/MailCore$Label;->id:J

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gm/provider/Gmail$LabelMap;->getNumUnreadConversations(J)I

    move-result v1

    .line 3901
    const-string v2, "Gmail"

    const-string v3, "MailEngine.clearNewUnreadMailForNotificationLabelIfNeeded() Count: %d, label: %s"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    aput-object v0, v4, v5

    invoke-static {v2, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 3903
    if-lez v1, :cond_0

    .line 3904
    invoke-virtual {p0, v0}, Lcom/google/android/gm/provider/MailEngine;->clearNewUnreadMailForNotificationLabel(Lcom/google/android/gm/provider/MailCore$Label;)I

    goto :goto_0
.end method

.method public close()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 1180
    iput-boolean v2, p0, Lcom/google/android/gm/provider/MailEngine;->mMailEngineClosing:Z

    .line 1182
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine;->onSyncCanceled()V

    .line 1185
    invoke-direct {p0}, Lcom/google/android/gm/provider/MailEngine;->interruptAndWaitForBackgroundThreads()V

    .line 1187
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mBackgroundTaskHandler:Landroid/os/Handler;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    .line 1190
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine;->blockUntilBackgroundTasksComplete()V

    .line 1192
    sget-object v0, Lcom/google/android/gm/provider/MailEngine;->sConversationPurgeTask:Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic$PurgeStaleConversationsTask;

    if-eqz v0, :cond_0

    .line 1193
    sget-object v0, Lcom/google/android/gm/provider/MailEngine;->sConversationPurgeTask:Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic$PurgeStaleConversationsTask;

    invoke-virtual {v0, v2}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic$PurgeStaleConversationsTask;->cancel(Z)Z

    .line 1196
    :cond_0
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mDbLock:Ljava/lang/Object;

    monitor-enter v1

    .line 1197
    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    if-eqz v0, :cond_1

    .line 1198
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    .line 1200
    :cond_1
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mInternalDb:Landroid/database/sqlite/SQLiteDatabase;

    if-eqz v0, :cond_2

    .line 1201
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mInternalDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->close()V

    .line 1202
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mInternalDb:Landroid/database/sqlite/SQLiteDatabase;

    .line 1204
    :cond_2
    monitor-exit v1

    .line 1205
    return-void

    .line 1204
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method endTransaction()V
    .locals 1

    .prologue
    .line 6728
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    .line 6729
    return-void
.end method

.method public enqueueAttachmentDownloadTask()V
    .locals 1

    .prologue
    .line 1076
    new-instance v0, Lcom/google/android/gm/provider/MailEngine$5;

    invoke-direct {v0, p0}, Lcom/google/android/gm/provider/MailEngine$5;-><init>(Lcom/google/android/gm/provider/MailEngine;)V

    invoke-virtual {p0, v0}, Lcom/google/android/gm/provider/MailEngine;->postBackgroundTask(Ljava/lang/Runnable;)V

    .line 1087
    return-void
.end method

.method expungeDraftMessages(J)I
    .locals 8

    .prologue
    const/4 v3, 0x1

    const/4 v5, 0x0

    const/4 v6, 0x0

    .line 2945
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine;->getLabelMap()Lcom/google/android/gm/provider/Gmail$LabelMap;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gm/provider/Gmail$LabelMap;->getLabelIdDraft()J

    move-result-wide v0

    .line 2946
    const/4 v2, 0x2

    new-array v4, v2, [Ljava/lang/String;

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v4, v6

    invoke-static {v0, v1}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v0

    aput-object v0, v4, v3

    .line 2952
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "messages"

    new-array v2, v3, [Ljava/lang/String;

    const-string v3, "_id"

    aput-object v3, v2, v6

    const-string v3, "messageId IN (SELECT message_messageId FROM message_labels where   message_conversation = ? AND labels_id = ?)"

    move-object v6, v5

    move-object v7, v5

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v1

    .line 2959
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v0

    .line 2961
    :goto_0
    :try_start_0
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 2962
    const/4 v2, 0x0

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 2966
    :catchall_0
    move-exception v0

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    throw v0

    :cond_0
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 2969
    invoke-virtual {p0, v0}, Lcom/google/android/gm/provider/MailEngine;->expungeLocalMessages(Ljava/util/List;)I

    move-result v0

    return v0
.end method

.method public expungeLocalMessage(J)I
    .locals 5
    .param p1, "localMessageId"    # J

    .prologue
    const/4 v4, 0x1

    .line 2900
    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    iget-object v3, p0, Lcom/google/android/gm/provider/MailEngine;->mTransactionListener:Lcom/google/android/gm/provider/GmailTransactionListener;

    invoke-virtual {v2, v3}, Lcom/google/android/gm/provider/TransactionHelper;->beginTransactionWithListenerNonExclusive(Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;)V

    .line 2901
    const/4 v1, 0x0

    .line 2903
    .local v1, "sendNotifications":Z
    :try_start_0
    invoke-direct {p0, p1, p2}, Lcom/google/android/gm/provider/MailEngine;->expungeLocalMessageImpl(J)I

    move-result v0

    .line 2904
    .local v0, "numExpunged":I
    if-lez v0, :cond_0

    .line 2905
    const/4 v1, 0x1

    .line 2907
    :cond_0
    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v2}, Lcom/google/android/gm/provider/TransactionHelper;->setTransactionSuccessful()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 2910
    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v2}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    .line 2911
    if-eqz v1, :cond_1

    .line 2912
    invoke-direct {p0, v4}, Lcom/google/android/gm/provider/MailEngine;->notifyDatasetChanged(Z)V

    :cond_1
    return v0

    .line 2910
    .end local v0    # "numExpunged":I
    :catchall_0
    move-exception v2

    iget-object v3, p0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v3}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    .line 2911
    if-eqz v1, :cond_2

    .line 2912
    invoke-direct {p0, v4}, Lcom/google/android/gm/provider/MailEngine;->notifyDatasetChanged(Z)V

    :cond_2
    throw v2
.end method

.method public expungeLocalMessages(Ljava/util/List;)I
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Long;",
            ">;)I"
        }
    .end annotation

    .prologue
    .local p1, "localMessageIds":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Long;>;"
    const/4 v6, 0x1

    .line 2923
    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    iget-object v5, p0, Lcom/google/android/gm/provider/MailEngine;->mTransactionListener:Lcom/google/android/gm/provider/GmailTransactionListener;

    invoke-virtual {v4, v5}, Lcom/google/android/gm/provider/TransactionHelper;->beginTransactionWithListenerNonExclusive(Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;)V

    .line 2924
    const/4 v2, 0x0

    .line 2925
    .local v2, "numExpunged":I
    const/4 v3, 0x0

    .line 2927
    .local v3, "sendNotifications":Z
    :try_start_0
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Long;

    .line 2928
    .local v1, "localMessageId":Ljava/lang/Long;
    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-direct {p0, v4, v5}, Lcom/google/android/gm/provider/MailEngine;->expungeLocalMessageImpl(J)I

    move-result v4

    add-int/2addr v2, v4

    goto :goto_0

    .line 2930
    .end local v1    # "localMessageId":Ljava/lang/Long;
    :cond_0
    if-lez v2, :cond_1

    .line 2931
    const/4 v3, 0x1

    .line 2933
    :cond_1
    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v4}, Lcom/google/android/gm/provider/TransactionHelper;->setTransactionSuccessful()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 2935
    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v4}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    .line 2936
    if-eqz v3, :cond_2

    .line 2937
    invoke-direct {p0, v6}, Lcom/google/android/gm/provider/MailEngine;->notifyDatasetChanged(Z)V

    .line 2940
    :cond_2
    return v2

    .line 2935
    .end local v0    # "i$":Ljava/util/Iterator;
    :catchall_0
    move-exception v4

    iget-object v5, p0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v5}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    .line 2936
    if-eqz v3, :cond_3

    .line 2937
    invoke-direct {p0, v6}, Lcom/google/android/gm/provider/MailEngine;->notifyDatasetChanged(Z)V

    :cond_3
    throw v4
.end method

.method public getAccountName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 802
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    iget-object v0, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getAttachmentManager()Lcom/google/android/gm/provider/AttachmentManager;
    .locals 1

    .prologue
    .line 1267
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mAttachmentManager:Lcom/google/android/gm/provider/AttachmentManager;

    return-object v0
.end method

.method public getAuthToken()Ljava/lang/String;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/google/android/gm/provider/MailEngine$AuthenticationException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 2187
    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    invoke-static {v0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    const-string v2, "mail"

    const/4 v3, 0x1

    invoke-virtual {v0, v1, v2, v3}, Landroid/accounts/AccountManager;->blockingGetAuthToken(Landroid/accounts/Account;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    .line 2189
    if-nez v0, :cond_0

    .line 2190
    new-instance v0, Lcom/google/android/gm/provider/MailEngine$AuthenticationException;

    const-string v1, "Unable to get auth token"

    invoke-direct {v0, v1}, Lcom/google/android/gm/provider/MailEngine$AuthenticationException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catch Landroid/accounts/AuthenticatorException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Landroid/accounts/OperationCanceledException; {:try_start_0 .. :try_end_0} :catch_1

    .line 2192
    :catch_0
    move-exception v0

    .line 2193
    new-instance v1, Lcom/google/android/gm/provider/MailEngine$AuthenticationException;

    invoke-virtual {v0}, Landroid/accounts/AuthenticatorException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Lcom/google/android/gm/provider/MailEngine$AuthenticationException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 2194
    :catch_1
    move-exception v0

    .line 2195
    new-instance v1, Lcom/google/android/gm/provider/MailEngine$AuthenticationException;

    invoke-virtual {v0}, Landroid/accounts/OperationCanceledException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Lcom/google/android/gm/provider/MailEngine$AuthenticationException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 2197
    :cond_0
    return-object v0
.end method

.method getContext()Landroid/content/Context;
    .locals 1

    .prologue
    .line 806
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method public getConversationCursorForId(Landroid/content/Context;J)Landroid/database/Cursor;
    .locals 3

    .prologue
    .line 2315
    const-string v0, "SELECT conversation_labels.*, conversations.*, conversations.queryId = 0 AS synced, (SELECT group_concat((labels._id || \'^*^\' || labels.canonicalName || \'^*^\' || \n(CASE labels.canonicalName    WHEN \'^f\' THEN ?    WHEN \'^^out\' THEN ?    WHEN \'^i\' THEN ?    WHEN \'^r\' THEN ?    WHEN \'^b\' THEN ?    WHEN \'^all\' THEN ?    WHEN \'^u\' THEN ?    WHEN \'^k\' THEN ?    WHEN \'^s\' THEN ?    WHEN \'^t\' THEN ?    WHEN \'^g\' THEN ?    WHEN \'^io_im\' THEN ?    WHEN \'^iim\' THEN ?    ELSE labels.name END)  || \'^*^\' || labels.color || \'^*^\' || labels.hidden),    \'^**^\') FROM labels JOIN conversation_labels  ON conversation_labels.labels_id = labels._id  AND conversation_labels.conversation_id = conversations._id AND conversation_labels.isZombie = 0) AS conversationLabels   FROM conversation_labels\n  LEFT OUTER JOIN conversations\n  ON conversation_labels.conversation_id = conversations._id\n  AND conversation_labels.queryId = conversations.queryId\nWHERE\n  ( conversations._id = ?)\n  AND isZombie = 0\nGROUP BY conversations._id"

    .line 2327
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    invoke-static {p2, p3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v0, v1

    invoke-static {p1, v0}, Lcom/google/android/gm/provider/QueryUtils;->argListWithLabelNames(Landroid/content/Context;[Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 2330
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "SELECT conversation_labels.*, conversations.*, conversations.queryId = 0 AS synced, (SELECT group_concat((labels._id || \'^*^\' || labels.canonicalName || \'^*^\' || \n(CASE labels.canonicalName    WHEN \'^f\' THEN ?    WHEN \'^^out\' THEN ?    WHEN \'^i\' THEN ?    WHEN \'^r\' THEN ?    WHEN \'^b\' THEN ?    WHEN \'^all\' THEN ?    WHEN \'^u\' THEN ?    WHEN \'^k\' THEN ?    WHEN \'^s\' THEN ?    WHEN \'^t\' THEN ?    WHEN \'^g\' THEN ?    WHEN \'^io_im\' THEN ?    WHEN \'^iim\' THEN ?    ELSE labels.name END)  || \'^*^\' || labels.color || \'^*^\' || labels.hidden),    \'^**^\') FROM labels JOIN conversation_labels  ON conversation_labels.labels_id = labels._id  AND conversation_labels.conversation_id = conversations._id AND conversation_labels.isZombie = 0) AS conversationLabels   FROM conversation_labels\n  LEFT OUTER JOIN conversations\n  ON conversation_labels.conversation_id = conversations._id\n  AND conversation_labels.queryId = conversations.queryId\nWHERE\n  ( conversations._id = ?)\n  AND isZombie = 0\nGROUP BY conversations._id"

    invoke-virtual {v1, v2, v0}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    return-object v0
.end method

.method public getConversationCursorForQuery([Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Integer;Z)Landroid/database/Cursor;
    .locals 9

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 2246
    const-string v3, "ME.conversationQuery"

    invoke-static {v3}, Lcom/google/android/gm/perf/Timer;->startTiming(Ljava/lang/String;)V

    .line 2248
    iget-object v8, p0, Lcom/google/android/gm/provider/MailEngine;->mConversationCursorForQueryLock:Ljava/lang/Object;

    monitor-enter v8

    .line 2251
    if-eqz p3, :cond_1

    .line 2252
    :try_start_0
    array-length v5, p3

    move v3, v2

    move v4, v1

    :goto_0
    if-ge v3, v5, :cond_2

    aget-object v4, p3, v3

    .line 2253
    const-string v6, "SELECTION_ARGUMENT_DO_NOT_BECOME_ACTIVE_NETWORK_CURSOR"

    invoke-virtual {v6, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 2252
    add-int/lit8 v3, v3, 0x1

    move v4, v2

    goto :goto_0

    .line 2256
    :cond_0
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Selection Argument \'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\' unknown."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "Please see Gmail.SelectionArguments for possible values."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 2309
    :catchall_0
    move-exception v1

    monitor-exit v8
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1

    :cond_1
    move v4, v1

    .line 2264
    :cond_2
    :try_start_1
    iget-object v3, p0, Lcom/google/android/gm/provider/MailEngine;->mLastQuery:Ljava/lang/String;

    invoke-static {p2, v3}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_3

    move v3, v1

    .line 2265
    :goto_1
    if-nez v3, :cond_4

    if-eqz v4, :cond_4

    move v7, v1

    .line 2267
    :goto_2
    if-nez v7, :cond_5

    .line 2270
    new-instance v1, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;

    move-object v2, p0

    move-object v3, p2

    move-object v5, p4

    move v6, p5

    invoke-direct/range {v1 .. v6}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;-><init>(Lcom/google/android/gm/provider/MailEngine;Ljava/lang/String;ZLjava/lang/Integer;Z)V

    move-object v3, v1

    .line 2280
    :goto_3
    new-instance v1, Lcom/google/android/gm/provider/MailEngine$9;

    invoke-direct {v1, p0, v3}, Lcom/google/android/gm/provider/MailEngine$9;-><init>(Lcom/google/android/gm/provider/MailEngine;Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;)V

    .line 2288
    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v3}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->getSql()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->getSelectionArgs()[Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x0

    invoke-virtual {v2, v1, v4, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->rawQueryWithFactory(Landroid/database/sqlite/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v2

    .line 2291
    move-object v0, v2

    check-cast v0, Lcom/google/android/gm/provider/MailEngine$NetworkCursor;

    move-object v1, v0

    .line 2292
    if-nez v7, :cond_6

    .line 2294
    invoke-virtual {v3, v1}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->configure(Lcom/google/android/gm/provider/MailEngine$NetworkCursor;)V

    .line 2298
    invoke-virtual {v3}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->purgeConversationsIfNeeded()V

    .line 2307
    :goto_4
    const-string v1, "ME.conversationQuery"

    invoke-static {v1}, Lcom/google/android/gm/perf/Timer;->stopTiming(Ljava/lang/String;)V

    .line 2308
    monitor-exit v8

    return-object v2

    :cond_3
    move v3, v2

    .line 2264
    goto :goto_1

    :cond_4
    move v7, v2

    .line 2265
    goto :goto_2

    .line 2273
    :cond_5
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mLastConversationCursorLogic:Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;

    .line 2275
    # invokes: Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->setLimit(Ljava/lang/Integer;)V
    invoke-static {v1, p4}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->access$1500(Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;Ljava/lang/Integer;)V

    .line 2277
    # invokes: Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->setSelectionArgs()V
    invoke-static {v1}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->access$1600(Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;)V

    move-object v3, v1

    goto :goto_3

    .line 2305
    :cond_6
    invoke-virtual {v1}, Lcom/google/android/gm/provider/MailEngine$NetworkCursor;->requery()Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_4
.end method

.method public getConversationForId([Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gm/provider/Gmail;)Lcom/google/android/gm/ConversationInfo;
    .locals 8

    .prologue
    const/4 v5, 0x0

    const/4 v3, 0x0

    .line 2417
    new-instance v0, Landroid/database/sqlite/SQLiteQueryBuilder;

    invoke-direct {v0}, Landroid/database/sqlite/SQLiteQueryBuilder;-><init>()V

    .line 2418
    const-string v1, "conversations"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 2419
    const-string v1, "conversations._id = ?"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteQueryBuilder;->appendWhere(Ljava/lang/CharSequence;)V

    .line 2421
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v2, 0x1

    new-array v4, v2, [Ljava/lang/String;

    aput-object p2, v4, v5

    move-object v2, p1

    move-object v5, v3

    move-object v6, v3

    move-object v7, v3

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 2422
    if-eqz v0, :cond_0

    .line 2425
    :try_start_0
    new-instance v1, Lcom/google/android/gm/provider/Gmail$DetachedConversationCursor;

    invoke-direct {v1, p4, p3, v0}, Lcom/google/android/gm/provider/Gmail$DetachedConversationCursor;-><init>(Lcom/google/android/gm/provider/Gmail;Ljava/lang/String;Landroid/database/Cursor;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 2426
    const/4 v0, 0x0

    :try_start_1
    invoke-virtual {v1, v0}, Lcom/google/android/gm/provider/Gmail$DetachedConversationCursor;->moveTo(I)Z

    .line 2427
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mLabelMap:Lcom/google/android/gm/provider/Gmail$LabelMap;

    invoke-static {v1, v0}, Lcom/google/android/gm/ConversationInfo;->forCursor(Lcom/google/android/gm/provider/Gmail$ConversationCursor;Lcom/google/android/gm/provider/Gmail$LabelMap;)Lcom/google/android/gm/ConversationInfo;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v3

    .line 2429
    if-eqz v1, :cond_0

    .line 2430
    invoke-virtual {v1}, Lcom/google/android/gm/provider/Gmail$DetachedConversationCursor;->close()V

    .line 2434
    :cond_0
    return-object v3

    .line 2429
    :catchall_0
    move-exception v0

    :goto_0
    if-eqz v3, :cond_1

    .line 2430
    invoke-virtual {v3}, Lcom/google/android/gm/provider/Gmail$DetachedConversationCursor;->close()V

    :cond_1
    throw v0

    .line 2429
    :catchall_1
    move-exception v0

    move-object v3, v1

    goto :goto_0
.end method

.method final getCurrentSyncRequest()I
    .locals 1

    .prologue
    .line 1827
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine;->isHandlingUserRefresh()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1828
    const/4 v0, 0x1

    .line 1835
    :goto_0
    return v0

    .line 1830
    :cond_0
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine;->isLiveQueryInProgress()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1831
    const/4 v0, 0x2

    goto :goto_0

    .line 1833
    :cond_1
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine;->isBackgroundSyncInProgress()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 1834
    const/4 v0, 0x4

    goto :goto_0

    .line 1835
    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getLabelMap()Lcom/google/android/gm/provider/Gmail$LabelMap;
    .locals 1

    .prologue
    .line 795
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mLabelMap:Lcom/google/android/gm/provider/Gmail$LabelMap;

    return-object v0
.end method

.method public getLabelQueryBuilder([Ljava/lang/String;)Lcom/google/android/gm/provider/LabelQueryBuilder;
    .locals 3
    .param p1, "projection"    # [Ljava/lang/String;

    .prologue
    .line 3517
    new-instance v0, Lcom/google/android/gm/provider/LabelQueryBuilder;

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-direct {v0, v1, v2, p1}, Lcom/google/android/gm/provider/LabelQueryBuilder;-><init>(Landroid/content/Context;Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;)V

    return-object v0
.end method

.method getLabelsForCanonicalNames([Ljava/lang/String;)[Lcom/google/android/gm/provider/MailCore$Label;
    .locals 7

    .prologue
    const/4 v1, 0x0

    .line 1448
    array-length v0, p1

    new-array v3, v0, [Lcom/google/android/gm/provider/MailCore$Label;

    move v0, v1

    .line 1449
    :goto_0
    array-length v2, p1

    if-ge v0, v2, :cond_0

    .line 1451
    :try_start_0
    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    aget-object v4, p1, v0

    invoke-virtual {v2, v4}, Lcom/google/android/gm/provider/MailCore;->getLabelOrThrow(Ljava/lang/String;)Lcom/google/android/gm/provider/MailCore$Label;

    move-result-object v2

    aput-object v2, v3, v0
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1449
    :goto_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 1452
    :catch_0
    move-exception v2

    .line 1458
    const-string v4, "Gmail"

    const-string v5, "Couldn\'t find label: %s"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    invoke-virtual {v2}, Ljava/lang/IllegalArgumentException;->getMessage()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v6, v1

    invoke-static {v4, v5, v6}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_1

    .line 1461
    :cond_0
    return-object v3
.end method

.method public getLabelsForConversation(Landroid/content/Context;Ljava/lang/String;Lcom/google/android/gm/provider/Gmail;)Ljava/util/List;
    .locals 8
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "id"    # Ljava/lang/String;
    .param p3, "gmail"    # Lcom/google/android/gm/provider/Gmail;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            "Lcom/google/android/gm/provider/Gmail;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 2392
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v6

    .line 2393
    .local v6, "labels":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-static {p2}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v0

    .line 2394
    .local v0, "conversationId":J
    invoke-virtual {p0, p1, v0, v1}, Lcom/google/android/gm/provider/MailEngine;->getConversationCursorForId(Landroid/content/Context;J)Landroid/database/Cursor;

    move-result-object v2

    .line 2395
    .local v2, "cursor":Landroid/database/Cursor;
    if-eqz v2, :cond_1

    .line 2396
    const/4 v3, 0x0

    .line 2398
    .local v3, "gmailCursor":Lcom/google/android/gm/provider/Gmail$DetachedConversationCursor;
    :try_start_0
    new-instance v4, Lcom/google/android/gm/provider/Gmail$DetachedConversationCursor;

    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine;->getAccountName()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v4, p3, v7, v2}, Lcom/google/android/gm/provider/Gmail$DetachedConversationCursor;-><init>(Lcom/google/android/gm/provider/Gmail;Ljava/lang/String;Landroid/database/Cursor;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 2399
    .end local v3    # "gmailCursor":Lcom/google/android/gm/provider/Gmail$DetachedConversationCursor;
    .local v4, "gmailCursor":Lcom/google/android/gm/provider/Gmail$DetachedConversationCursor;
    const/4 v7, 0x0

    :try_start_1
    invoke-virtual {v4, v7}, Lcom/google/android/gm/provider/Gmail$DetachedConversationCursor;->moveTo(I)Z

    .line 2401
    invoke-virtual {v4}, Lcom/google/android/gm/provider/Gmail$DetachedConversationCursor;->getLabels()Ljava/util/Map;

    move-result-object v5

    .line 2402
    .local v5, "labelMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/google/android/gm/provider/Label;>;"
    if-eqz v5, :cond_0

    .line 2403
    invoke-interface {v5}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v7

    invoke-interface {v6, v7}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 2406
    :cond_0
    if-eqz v4, :cond_1

    .line 2407
    invoke-virtual {v4}, Lcom/google/android/gm/provider/Gmail$DetachedConversationCursor;->close()V

    .line 2411
    .end local v4    # "gmailCursor":Lcom/google/android/gm/provider/Gmail$DetachedConversationCursor;
    .end local v5    # "labelMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/google/android/gm/provider/Label;>;"
    :cond_1
    return-object v6

    .line 2406
    .restart local v3    # "gmailCursor":Lcom/google/android/gm/provider/Gmail$DetachedConversationCursor;
    :catchall_0
    move-exception v7

    :goto_0
    if-eqz v3, :cond_2

    .line 2407
    invoke-virtual {v3}, Lcom/google/android/gm/provider/Gmail$DetachedConversationCursor;->close()V

    :cond_2
    throw v7

    .line 2406
    .end local v3    # "gmailCursor":Lcom/google/android/gm/provider/Gmail$DetachedConversationCursor;
    .restart local v4    # "gmailCursor":Lcom/google/android/gm/provider/Gmail$DetachedConversationCursor;
    :catchall_1
    move-exception v7

    move-object v3, v4

    .end local v4    # "gmailCursor":Lcom/google/android/gm/provider/Gmail$DetachedConversationCursor;
    .restart local v3    # "gmailCursor":Lcom/google/android/gm/provider/Gmail$DetachedConversationCursor;
    goto :goto_0
.end method

.method public getLastSyncResult()I
    .locals 2

    .prologue
    .line 1865
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mStatusLock:Ljava/lang/Object;

    monitor-enter v1

    .line 1866
    :try_start_0
    iget v0, p0, Lcom/google/android/gm/provider/MailEngine;->mLastSyncResult:I

    monitor-exit v1

    return v0

    .line 1867
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public getLocalMessage(JZ)Lcom/google/android/gm/provider/MailSync$Message;
    .locals 2
    .param p1, "localMessageId"    # J
    .param p3, "loadBody"    # Z

    .prologue
    .line 2473
    const/4 v1, 0x0

    invoke-virtual {p0, v1, p1, p2}, Lcom/google/android/gm/provider/MailEngine;->getMessageCursorForLocalMessageId([Ljava/lang/String;J)Landroid/database/Cursor;

    move-result-object v0

    .line 2475
    .local v0, "cursor":Landroid/database/Cursor;
    :try_start_0
    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z

    .line 2476
    invoke-direct {p0, v0, p3}, Lcom/google/android/gm/provider/MailEngine;->getMessageFromCursor(Landroid/database/Cursor;Z)Lcom/google/android/gm/provider/MailSync$Message;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 2478
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    return-object v1

    :catchall_0
    move-exception v1

    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    throw v1
.end method

.method public getMailSync()Lcom/google/android/gm/provider/MailSync;
    .locals 1

    .prologue
    .line 1468
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    return-object v0
.end method

.method public getMessage(JZ)Lcom/google/android/gm/provider/MailSync$Message;
    .locals 2
    .param p1, "messageId"    # J
    .param p3, "loadBody"    # Z

    .prologue
    .line 2486
    const/4 v1, 0x0

    invoke-virtual {p0, v1, p1, p2}, Lcom/google/android/gm/provider/MailEngine;->getMessageCursorForMessageId([Ljava/lang/String;J)Landroid/database/Cursor;

    move-result-object v0

    .line 2488
    .local v0, "cursor":Landroid/database/Cursor;
    :try_start_0
    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z

    .line 2489
    invoke-direct {p0, v0, p3}, Lcom/google/android/gm/provider/MailEngine;->getMessageFromCursor(Landroid/database/Cursor;Z)Lcom/google/android/gm/provider/MailSync$Message;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 2491
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    return-object v1

    :catchall_0
    move-exception v1

    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    throw v1
.end method

.method public getMessageCursorForConversationId([Ljava/lang/String;J)Landroid/database/Cursor;
    .locals 8

    .prologue
    const/4 v3, 0x0

    .line 2334
    const-string v0, "ME.messageConversationIdQuery"

    invoke-static {v0}, Lcom/google/android/gm/perf/Timer;->startTiming(Ljava/lang/String;)V

    .line 2336
    new-instance v0, Landroid/database/sqlite/SQLiteQueryBuilder;

    invoke-direct {v0}, Landroid/database/sqlite/SQLiteQueryBuilder;-><init>()V

    .line 2337
    const-string v1, "messages LEFT OUTER JOIN message_labels \nON messages.messageId = message_labels.message_messageId \nLEFT OUTER JOIN labels \nON message_labels.labels_id = labels._id "

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 2338
    const-string v1, "messages.conversation = ?"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteQueryBuilder;->appendWhere(Ljava/lang/CharSequence;)V

    .line 2339
    sget-object v1, Lcom/google/android/gm/provider/MailEngine;->MESSAGE_PROJECTION_MAP:Ljava/util/Map;

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteQueryBuilder;->setProjectionMap(Ljava/util/Map;)V

    .line 2340
    const-string v1, "messageLabels"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-static {p2, p3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    invoke-direct {p0, p1, v1, v2}, Lcom/google/android/gm/provider/MailEngine;->getQueryBindArgs([Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v4

    .line 2342
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v5, "messages.messageId"

    const-string v7, "messages.messageId"

    move-object v2, p1

    move-object v6, v3

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 2345
    const-string v1, "ME.messageConversationIdQuery"

    invoke-static {v1}, Lcom/google/android/gm/perf/Timer;->stopTiming(Ljava/lang/String;)V

    .line 2346
    new-instance v1, Lcom/google/android/gm/provider/CompressedMessageCursor;

    invoke-direct {v1, v0}, Lcom/google/android/gm/provider/CompressedMessageCursor;-><init>(Landroid/database/Cursor;)V

    return-object v1
.end method

.method public getMessageCursorForConversationId([Ljava/lang/String;JZZ)Landroid/database/Cursor;
    .locals 9

    .prologue
    const/4 v3, 0x0

    .line 2356
    const-string v0, "ME.messageConversationIdQuery"

    invoke-static {v0}, Lcom/google/android/gm/perf/Timer;->startTiming(Ljava/lang/String;)V

    .line 2358
    invoke-virtual {p0, p2, p3}, Lcom/google/android/gm/provider/MailEngine;->getMessageCursorLogicForConversation(J)Lcom/google/android/gm/provider/MailEngine$MessageCursorLogic;

    move-result-object v8

    .line 2359
    new-instance v0, Landroid/database/sqlite/SQLiteQueryBuilder;

    invoke-direct {v0}, Landroid/database/sqlite/SQLiteQueryBuilder;-><init>()V

    .line 2360
    const-string v1, "messages LEFT OUTER JOIN message_labels \nON messages.messageId = message_labels.message_messageId \nLEFT OUTER JOIN labels \nON message_labels.labels_id = labels._id "

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 2363
    const-string v1, "messages.conversation = ? AND (queryId = 0 OR queryId = ?)"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteQueryBuilder;->appendWhere(Ljava/lang/CharSequence;)V

    .line 2364
    sget-object v1, Lcom/google/android/gm/provider/MailEngine;->MESSAGE_PROJECTION_MAP:Ljava/util/Map;

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteQueryBuilder;->setProjectionMap(Ljava/util/Map;)V

    .line 2365
    new-instance v1, Lcom/google/android/gm/provider/MailEngine$10;

    invoke-direct {v1, p0, v8}, Lcom/google/android/gm/provider/MailEngine$10;-><init>(Lcom/google/android/gm/provider/MailEngine;Lcom/google/android/gm/provider/MailEngine$MessageCursorLogic;)V

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteQueryBuilder;->setCursorFactory(Landroid/database/sqlite/SQLiteDatabase$CursorFactory;)V

    .line 2372
    const-string v1, "messageLabels"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-static {p2, p3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    const/4 v4, 0x1

    iget-wide v5, v8, Lcom/google/android/gm/provider/MailEngine$NetworkCursorLogic;->mQueryId:J

    invoke-static {v5, v6}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    invoke-direct {p0, p1, v1, v2}, Lcom/google/android/gm/provider/MailEngine;->getQueryBindArgs([Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v4

    .line 2375
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v5, "messages.messageId"

    const-string v7, "messages.messageId"

    move-object v2, p1

    move-object v6, v3

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    check-cast v0, Lcom/google/android/gm/provider/MailEngine$CloneableMessageCursor;

    .line 2379
    iget-boolean v1, v8, Lcom/google/android/gm/provider/MailEngine$MessageCursorLogic;->mConfigured:Z

    if-eqz v1, :cond_0

    if-nez p4, :cond_1

    .line 2380
    :cond_0
    invoke-virtual {v8, p2, p3, v0, p4}, Lcom/google/android/gm/provider/MailEngine$MessageCursorLogic;->configure(JLcom/google/android/gm/provider/MailEngine$NetworkCursor;Z)V

    .line 2383
    :cond_1
    if-eqz p5, :cond_2

    .line 2384
    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailEngine$CloneableMessageCursor;->clone()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/database/Cursor;

    .line 2385
    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailEngine$CloneableMessageCursor;->close()V

    .line 2387
    :goto_0
    const-string v0, "ME.messageConversationIdQuery"

    invoke-static {v0}, Lcom/google/android/gm/perf/Timer;->stopTiming(Ljava/lang/String;)V

    .line 2388
    new-instance v0, Lcom/google/android/gm/provider/CompressedMessageCursor;

    invoke-direct {v0, v1}, Lcom/google/android/gm/provider/CompressedMessageCursor;-><init>(Landroid/database/Cursor;)V

    return-object v0

    :cond_2
    move-object v1, v0

    goto :goto_0
.end method

.method public getMessageCursorForLocalMessageId([Ljava/lang/String;J)Landroid/database/Cursor;
    .locals 8

    .prologue
    const/4 v3, 0x0

    .line 2439
    const-string v0, "ME.messageLocalIdQuery"

    invoke-static {v0}, Lcom/google/android/gm/perf/Timer;->startTiming(Ljava/lang/String;)V

    .line 2441
    new-instance v0, Landroid/database/sqlite/SQLiteQueryBuilder;

    invoke-direct {v0}, Landroid/database/sqlite/SQLiteQueryBuilder;-><init>()V

    .line 2442
    const-string v1, "messages LEFT OUTER JOIN message_labels \nON messages.messageId = message_labels.message_messageId \nLEFT OUTER JOIN labels \nON message_labels.labels_id = labels._id "

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 2443
    const-string v1, "messages._id = ?"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteQueryBuilder;->appendWhere(Ljava/lang/CharSequence;)V

    .line 2444
    sget-object v1, Lcom/google/android/gm/provider/MailEngine;->MESSAGE_PROJECTION_MAP:Ljava/util/Map;

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteQueryBuilder;->setProjectionMap(Ljava/util/Map;)V

    .line 2445
    const-string v1, "messageLabels"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-static {p2, p3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    invoke-direct {p0, p1, v1, v2}, Lcom/google/android/gm/provider/MailEngine;->getQueryBindArgs([Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v4

    .line 2447
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v5, "messages.messageId"

    move-object v2, p1

    move-object v6, v3

    move-object v7, v3

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 2449
    const-string v1, "ME.messageLocalIdQuery"

    invoke-static {v1}, Lcom/google/android/gm/perf/Timer;->stopTiming(Ljava/lang/String;)V

    .line 2450
    new-instance v1, Lcom/google/android/gm/provider/CompressedMessageCursor;

    invoke-direct {v1, v0}, Lcom/google/android/gm/provider/CompressedMessageCursor;-><init>(Landroid/database/Cursor;)V

    return-object v1
.end method

.method getMessageCursorForMessageId([Ljava/lang/String;J)Landroid/database/Cursor;
    .locals 8

    .prologue
    const/4 v3, 0x0

    .line 2455
    const-string v0, "ME.messageMessageIdQuery"

    invoke-static {v0}, Lcom/google/android/gm/perf/Timer;->startTiming(Ljava/lang/String;)V

    .line 2457
    new-instance v0, Landroid/database/sqlite/SQLiteQueryBuilder;

    invoke-direct {v0}, Landroid/database/sqlite/SQLiteQueryBuilder;-><init>()V

    .line 2458
    const-string v1, "messages LEFT OUTER JOIN message_labels \nON messages.messageId = message_labels.message_messageId \nLEFT OUTER JOIN labels \nON message_labels.labels_id = labels._id "

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 2459
    const-string v1, "messages.messageId = ?"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteQueryBuilder;->appendWhere(Ljava/lang/CharSequence;)V

    .line 2460
    sget-object v1, Lcom/google/android/gm/provider/MailEngine;->MESSAGE_PROJECTION_MAP:Ljava/util/Map;

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteQueryBuilder;->setProjectionMap(Ljava/util/Map;)V

    .line 2461
    const-string v1, "messageLabels"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-static {p2, p3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    invoke-direct {p0, p1, v1, v2}, Lcom/google/android/gm/provider/MailEngine;->getQueryBindArgs([Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v4

    .line 2463
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v5, "messages.messageId"

    move-object v2, p1

    move-object v6, v3

    move-object v7, v3

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 2464
    const-string v1, "ME.messageMessageIdQuery"

    invoke-static {v1}, Lcom/google/android/gm/perf/Timer;->stopTiming(Ljava/lang/String;)V

    .line 2465
    new-instance v1, Lcom/google/android/gm/provider/CompressedMessageCursor;

    invoke-direct {v1, v0}, Lcom/google/android/gm/provider/CompressedMessageCursor;-><init>(Landroid/database/Cursor;)V

    return-object v1
.end method

.method public getMessageCursorLogicForConversation(J)Lcom/google/android/gm/provider/MailEngine$MessageCursorLogic;
    .locals 4
    .param p1, "conversationId"    # J

    .prologue
    .line 6324
    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mMessageCursorLogicMapLock:Ljava/lang/Object;

    monitor-enter v2

    .line 6325
    :try_start_0
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mMessageCursorLogicMap:Ljava/util/Map;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gm/provider/MailEngine$MessageCursorLogic;

    .line 6326
    .local v0, "messageCursorLogic":Lcom/google/android/gm/provider/MailEngine$MessageCursorLogic;
    if-nez v0, :cond_0

    .line 6327
    new-instance v0, Lcom/google/android/gm/provider/MailEngine$MessageCursorLogic;

    .end local v0    # "messageCursorLogic":Lcom/google/android/gm/provider/MailEngine$MessageCursorLogic;
    invoke-direct {v0, p0, p1, p2}, Lcom/google/android/gm/provider/MailEngine$MessageCursorLogic;-><init>(Lcom/google/android/gm/provider/MailEngine;J)V

    .line 6328
    .restart local v0    # "messageCursorLogic":Lcom/google/android/gm/provider/MailEngine$MessageCursorLogic;
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mMessageCursorLogicMap:Ljava/util/Map;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-interface {v1, v3, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 6330
    :cond_0
    monitor-exit v2

    .line 6331
    return-object v0

    .line 6330
    .end local v0    # "messageCursorLogic":Lcom/google/android/gm/provider/MailEngine$MessageCursorLogic;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method getNotificationTagLabel(J)Lcom/google/android/gm/provider/MailCore$Label;
    .locals 1
    .param p1, "labelId"    # J

    .prologue
    .line 1314
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    invoke-virtual {v0, p1, p2}, Lcom/google/android/gm/provider/MailCore;->getLabelOrThrow(J)Lcom/google/android/gm/provider/MailCore$Label;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/google/android/gm/provider/MailEngine;->getNotificationTagLabel(Lcom/google/android/gm/provider/MailCore$Label;)Lcom/google/android/gm/provider/MailCore$Label;

    move-result-object v0

    return-object v0
.end method

.method public getPublicSettingsCursor([Ljava/lang/String;)Landroid/database/Cursor;
    .locals 4

    .prologue
    .line 3521
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 3522
    const-string v0, "select "

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 3523
    const/4 v0, 0x0

    :goto_0
    array-length v2, p1

    if-ge v0, v2, :cond_1

    .line 3524
    aget-object v2, p1, v0

    .line 3525
    if-eqz v0, :cond_0

    const-string v3, ", "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 3526
    :cond_0
    const-string v3, "(select value from internal_sync_settings where name =\'"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 3527
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 3528
    const-string v3, "\') as "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 3529
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 3523
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 3532
    :cond_1
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mInternalDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    return-object v0
.end method

.method public getRequestVersion()I
    .locals 1

    .prologue
    .line 3909
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailSync;->getRequestVersion()I

    move-result v0

    return v0
.end method

.method public getServerArrowsEnabled()Z
    .locals 1

    .prologue
    .line 3923
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailCore;->getInfoOverloadArrowsEnabled()Z

    move-result v0

    return v0
.end method

.method getSettingsInteger(Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/Integer;
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "defaultValue"    # Ljava/lang/Integer;

    .prologue
    .line 1602
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/MailEngine;->getEngineSettingsCursor(Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 1604
    .local v0, "cursor":Landroid/database/Cursor;
    :try_start_0
    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    if-nez v1, :cond_0

    .line 1607
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .end local p2    # "defaultValue":Ljava/lang/Integer;
    :goto_0
    return-object p2

    .line 1605
    .restart local p2    # "defaultValue":Ljava/lang/Integer;
    :cond_0
    :try_start_1
    const-string v1, "value"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object p2

    .line 1607
    .end local p2    # "defaultValue":Ljava/lang/Integer;
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    goto :goto_0

    .restart local p2    # "defaultValue":Ljava/lang/Integer;
    :catchall_0
    move-exception v1

    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    throw v1
.end method

.method getSettingsLong(Ljava/lang/String;Ljava/lang/Long;)Ljava/lang/Long;
    .locals 3
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "defaultValue"    # Ljava/lang/Long;

    .prologue
    .line 1566
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/MailEngine;->getEngineSettingsCursor(Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 1568
    .local v0, "cursor":Landroid/database/Cursor;
    :try_start_0
    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    if-nez v1, :cond_0

    .line 1571
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .end local p2    # "defaultValue":Ljava/lang/Long;
    :goto_0
    return-object p2

    .line 1569
    .restart local p2    # "defaultValue":Ljava/lang/Long;
    :cond_0
    :try_start_1
    const-string v1, "value"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v1

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object p2

    .line 1571
    .end local p2    # "defaultValue":Ljava/lang/Long;
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    goto :goto_0

    .restart local p2    # "defaultValue":Ljava/lang/Long;
    :catchall_0
    move-exception v1

    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    throw v1
.end method

.method getStatusCursor([Ljava/lang/String;)Landroid/database/Cursor;
    .locals 7
    .param p1, "projection"    # [Ljava/lang/String;

    .prologue
    .line 3563
    iget-object v5, p0, Lcom/google/android/gm/provider/MailEngine;->mStatusLock:Ljava/lang/Object;

    monitor-enter v5

    .line 3567
    :try_start_0
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine;->isLiveQueryInProgress()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 3568
    const/4 v1, 0x2

    .line 3576
    .local v1, "currentTask":I
    :goto_0
    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine;->mLabelMap:Lcom/google/android/gm/provider/Gmail$LabelMap;

    invoke-virtual {v4}, Lcom/google/android/gm/provider/Gmail$LabelMap;->labelsSynced()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 3577
    or-int/lit8 v1, v1, 0x10

    .line 3579
    :cond_0
    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine;->mLabelMap:Lcom/google/android/gm/provider/Gmail$LabelMap;

    invoke-virtual {v4}, Lcom/google/android/gm/provider/Gmail$LabelMap;->labelsSynchronizationStateInitialized()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 3580
    or-int/lit8 v1, v1, 0x20

    .line 3583
    :cond_1
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    .line 3584
    .local v3, "status":Ljava/lang/Integer;
    new-instance v2, Landroid/database/MatrixCursor;

    sget-object v4, Lcom/google/android/gm/provider/Gmail;->STATUS_PROJECTION:[Ljava/lang/String;

    const/4 v6, 0x1

    invoke-direct {v2, v4, v6}, Landroid/database/MatrixCursor;-><init>([Ljava/lang/String;I)V

    .line 3586
    .local v2, "cursor":Landroid/database/MatrixCursor;
    invoke-virtual {v2}, Landroid/database/MatrixCursor;->newRow()Landroid/database/MatrixCursor$RowBuilder;

    move-result-object v0

    .line 3589
    .local v0, "builder":Landroid/database/MatrixCursor$RowBuilder;
    invoke-virtual {v0, v3}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    .line 3590
    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    iget-object v4, v4, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-virtual {v0, v4}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    .line 3591
    monitor-exit v5

    return-object v2

    .line 3569
    .end local v0    # "builder":Landroid/database/MatrixCursor$RowBuilder;
    .end local v1    # "currentTask":I
    .end local v2    # "cursor":Landroid/database/MatrixCursor;
    .end local v3    # "status":Ljava/lang/Integer;
    :cond_2
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine;->isBackgroundSyncInProgress()Z

    move-result v4

    if-eqz v4, :cond_3

    .line 3570
    const/4 v1, 0x1

    .restart local v1    # "currentTask":I
    goto :goto_0

    .line 3572
    .end local v1    # "currentTask":I
    :cond_3
    const/4 v1, 0x0

    .restart local v1    # "currentTask":I
    goto :goto_0

    .line 3592
    .end local v1    # "currentTask":I
    :catchall_0
    move-exception v4

    monitor-exit v5
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v4
.end method

.method public getSubscribedFeedUrl(J)Ljava/lang/String;
    .locals 2

    .prologue
    .line 2216
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mUrls:Lcom/google/android/gm/provider/Urls;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/Urls;->serverUrl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "?"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "client"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getSynchronizedLabelSet()Ljava/util/Set;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 6688
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v2

    .line 6689
    .local v2, "synchronizedLabelsSet":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    const/4 v0, 0x0

    .line 6690
    .local v0, "settings":Lcom/google/android/gm/provider/Gmail$Settings;
    sget-object v3, Lcom/google/android/gm/provider/Gmail;->SETTINGS_PROJECTION:[Ljava/lang/String;

    invoke-virtual {p0, v3}, Lcom/google/android/gm/provider/MailEngine;->getPublicSettingsCursor([Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v1

    .line 6692
    .local v1, "settingsCursor":Landroid/database/Cursor;
    :try_start_0
    iget-object v3, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    invoke-static {v3, v1}, Lcom/google/android/gm/provider/Gmail;->getSettings(Landroid/content/Context;Landroid/database/Cursor;)Lcom/google/android/gm/provider/Gmail$Settings;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    .line 6694
    if-eqz v1, :cond_0

    .line 6695
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 6699
    :cond_0
    if-eqz v0, :cond_1

    .line 6701
    invoke-virtual {v0}, Lcom/google/android/gm/provider/Gmail$Settings;->getLabelsIncluded()Ljava/util/List;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    .line 6702
    invoke-virtual {v0}, Lcom/google/android/gm/provider/Gmail$Settings;->getLabelsPartial()Ljava/util/List;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    .line 6704
    :cond_1
    return-object v2

    .line 6694
    :catchall_0
    move-exception v3

    if-eqz v1, :cond_2

    .line 6695
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_2
    throw v3
.end method

.method public handleConversation(Lcom/google/android/gm/provider/MailSync$Conversation;JLcom/google/android/gm/provider/MailCore$Label;)J
    .locals 16

    .prologue
    .line 3980
    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    .line 3983
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/google/android/gm/provider/MailEngine;->mTransactionListener:Lcom/google/android/gm/provider/GmailTransactionListener;

    invoke-virtual {v2, v4}, Lcom/google/android/gm/provider/TransactionHelper;->beginTransactionWithListenerNonExclusive(Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;)V

    .line 3985
    :try_start_0
    move-object/from16 v0, p1

    iget-wide v12, v0, Lcom/google/android/gm/provider/MailSync$Conversation;->conversationId:J

    .line 3986
    invoke-static {v12, v13}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v4

    .line 3989
    const-wide/16 v5, 0x0

    cmp-long v2, p2, v5

    if-nez v2, :cond_3

    .line 3993
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v5, "SELECT COALESCE(MAX(messageId), 0) FROM messages where conversation = ? AND queryId = 0"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/String;

    const/4 v7, 0x0

    aput-object v4, v6, v7

    invoke-static {v2, v5, v6}, Landroid/database/DatabaseUtils;->longForQuery(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;)J

    move-result-wide v8

    .line 4003
    :goto_0
    const-wide/16 v5, 0x0

    cmp-long v2, p2, v5

    if-nez v2, :cond_4

    .line 4004
    new-instance v2, Lcom/google/android/gm/provider/ConversationUtil;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    invoke-direct {v2, v5, v6}, Lcom/google/android/gm/provider/ConversationUtil;-><init>(Landroid/database/sqlite/SQLiteDatabase;Lcom/google/android/gm/provider/MailCore;)V

    .line 4005
    move-wide/from16 v0, p2

    invoke-virtual {v2, v12, v13, v0, v1}, Lcom/google/android/gm/provider/ConversationUtil;->fetchOldConversationLabels(JJ)Ljava/util/Map;

    move-result-object v2

    move-object v11, v2

    .line 4011
    :goto_1
    const-string v2, "_id"

    invoke-static {v12, v13}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v3, v2, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 4012
    const-string v2, "queryId"

    invoke-static/range {p2 .. p3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v3, v2, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 4013
    const-string v2, "subject"

    move-object/from16 v0, p1

    iget-object v5, v0, Lcom/google/android/gm/provider/MailSync$Conversation;->subject:Ljava/lang/String;

    invoke-virtual {v3, v2, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 4014
    const-string v2, "snippet"

    move-object/from16 v0, p1

    iget-object v5, v0, Lcom/google/android/gm/provider/MailSync$Conversation;->snippet:Ljava/lang/String;

    invoke-virtual {v3, v2, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 4015
    const-string v2, "fromAddress"

    move-object/from16 v0, p1

    iget-object v5, v0, Lcom/google/android/gm/provider/MailSync$Conversation;->fromAddress:Ljava/lang/String;

    invoke-virtual {v3, v2, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 4016
    const-string v2, "personalLevel"

    move-object/from16 v0, p1

    iget-object v5, v0, Lcom/google/android/gm/provider/MailSync$Conversation;->personalLevel:Lcom/google/android/gm/provider/Gmail$PersonalLevel;

    invoke-virtual {v5}, Lcom/google/android/gm/provider/Gmail$PersonalLevel;->toInt()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v2, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 4019
    const-string v2, "forceAllUnread"

    const/4 v5, 0x0

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v2, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 4020
    move-object/from16 v0, p1

    iget-object v2, v0, Lcom/google/android/gm/provider/MailSync$Conversation;->labelIds:Ljava/util/Set;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/google/android/gm/provider/MailEngine;->mLabelMap:Lcom/google/android/gm/provider/Gmail$LabelMap;

    invoke-virtual {v5}, Lcom/google/android/gm/provider/Gmail$LabelMap;->getLabelIdCached()J

    move-result-wide v5

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-interface {v2, v5}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 4023
    if-eqz p4, :cond_0

    .line 4024
    move-object/from16 v0, p1

    iget-object v2, v0, Lcom/google/android/gm/provider/MailSync$Conversation;->labelIds:Ljava/util/Set;

    move-object/from16 v0, p4

    iget-wide v5, v0, Lcom/google/android/gm/provider/MailCore$Label;->id:J

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-interface {v2, v5}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 4027
    :cond_0
    move-object/from16 v0, p1

    iget-object v2, v0, Lcom/google/android/gm/provider/MailSync$Conversation;->labelIds:Ljava/util/Set;

    invoke-static {v2}, Lcom/google/android/gm/provider/Gmail;->getLabelIdsStringFromLabelIds(Ljava/util/Set;)Ljava/lang/String;

    move-result-object v2

    .line 4028
    const-string v5, "labelIds"

    invoke-virtual {v3, v5, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 4029
    const-string v2, "numMessages"

    move-object/from16 v0, p1

    iget v5, v0, Lcom/google/android/gm/provider/MailSync$Conversation;->numMessages:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v2, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 4030
    const-string v2, "maxMessageId"

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v3, v2, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 4031
    const-string v2, "hasAttachments"

    move-object/from16 v0, p1

    iget-boolean v5, v0, Lcom/google/android/gm/provider/MailSync$Conversation;->hasAttachments:Z

    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    invoke-virtual {v3, v2, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 4032
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v5, "conversations"

    const/4 v6, 0x0

    invoke-virtual {v2, v5, v6, v3}, Landroid/database/sqlite/SQLiteDatabase;->replace(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v5

    .line 4033
    const-wide/16 v14, 0x0

    cmp-long v2, p2, v14

    if-nez v2, :cond_1

    .line 4034
    invoke-direct/range {p0 .. p0}, Lcom/google/android/gm/provider/MailEngine;->requestIndex()V

    .line 4037
    :cond_1
    const-wide/16 v14, -0x1

    cmp-long v2, v5, v14

    if-nez v2, :cond_2

    .line 4041
    const-string v2, "Gmail"

    const-string v5, "Failed to insert conversation"

    const/4 v6, 0x0

    new-array v6, v6, [Ljava/lang/Object;

    invoke-static {v2, v5, v6}, Lcom/google/android/gm/provider/LogUtils;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 4044
    :cond_2
    const-wide/16 v5, 0x0

    cmp-long v2, p2, v5

    if-nez v2, :cond_7

    .line 4048
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v14

    .line 4049
    move-object/from16 v0, p1

    iget-object v2, v0, Lcom/google/android/gm/provider/MailSync$Conversation;->labelIds:Ljava/util/Set;

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v15

    :goto_2
    invoke-interface {v15}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_5

    invoke-interface {v15}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    move-object v0, v2

    check-cast v0, Ljava/lang/Long;

    move-object v10, v0

    .line 4050
    new-instance v2, Lcom/google/android/gm/provider/LabelRecord;

    move-object/from16 v0, p1

    iget-wide v3, v0, Lcom/google/android/gm/provider/MailSync$Conversation;->sortMessageId:J

    move-object/from16 v0, p1

    iget-wide v5, v0, Lcom/google/android/gm/provider/MailSync$Conversation;->date:J

    const/4 v7, 0x0

    invoke-direct/range {v2 .. v7}, Lcom/google/android/gm/provider/LabelRecord;-><init>(JJZ)V

    invoke-virtual {v14, v10, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_2

    .line 4117
    :catchall_0
    move-exception v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v3}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    throw v2

    .line 3999
    :cond_3
    :try_start_1
    move-object/from16 v0, p1

    iget-wide v8, v0, Lcom/google/android/gm/provider/MailSync$Conversation;->maxMessageId:J

    goto/16 :goto_0

    .line 4008
    :cond_4
    const/4 v2, 0x0

    move-object v11, v2

    goto/16 :goto_1

    .line 4055
    :cond_5
    new-instance v2, Lcom/google/android/gm/provider/SyncedConversationHandler;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    invoke-direct {v2, v3, v4}, Lcom/google/android/gm/provider/SyncedConversationHandler;-><init>(Landroid/database/sqlite/SQLiteDatabase;Lcom/google/android/gm/provider/MailCore;)V

    .line 4057
    sget-object v5, Lcom/google/android/gm/provider/MailSync$SyncRationale;->DURATION:Lcom/google/android/gm/provider/MailSync$SyncRationale;

    const/4 v10, 0x0

    move-wide v3, v12

    move-object v6, v11

    move-object v7, v14

    invoke-virtual/range {v2 .. v10}, Lcom/google/android/gm/provider/SyncedConversationHandler;->updateLabelInfo(JLcom/google/android/gm/provider/MailSync$SyncRationale;Ljava/util/Map;Ljava/util/Map;JLjava/util/Set;)V

    .line 4064
    const-wide/16 v5, 0x0

    move-wide v3, v12

    move-object v7, v14

    invoke-virtual/range {v2 .. v7}, Lcom/google/android/gm/provider/SyncedConversationHandler;->insertConversationLabels(JJLjava/util/Map;)V

    .line 4113
    :cond_6
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v2}, Lcom/google/android/gm/provider/TransactionHelper;->setTransactionSuccessful()V

    .line 4115
    move-object/from16 v0, p1

    iget-wide v2, v0, Lcom/google/android/gm/provider/MailSync$Conversation;->sortMessageId:J
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 4117
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v4}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    return-wide v2

    .line 4066
    :cond_7
    :try_start_2
    invoke-virtual {v3}, Landroid/content/ContentValues;->clear()V

    .line 4068
    if-eqz p4, :cond_9

    .line 4069
    const-string v2, "labels_id"

    move-object/from16 v0, p4

    iget-wide v5, v0, Lcom/google/android/gm/provider/MailCore$Label;->id:J

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v3, v2, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 4078
    :goto_3
    const-string v2, "queryId"

    invoke-static/range {p2 .. p3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v3, v2, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 4079
    const-string v2, "isZombie"

    const/4 v5, 0x0

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v2, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 4092
    const-string v2, "sortMessageId"

    move-object/from16 v0, p1

    iget-wide v5, v0, Lcom/google/android/gm/provider/MailSync$Conversation;->sortMessageId:J

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v3, v2, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 4093
    const-string v2, "date"

    move-object/from16 v0, p1

    iget-wide v5, v0, Lcom/google/android/gm/provider/MailSync$Conversation;->date:J

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v3, v2, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 4094
    const-string v2, "conversation_id"

    invoke-static {v12, v13}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v3, v2, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 4096
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v5, "conversation_labels"

    const-string v6, "queryId = ? AND conversation_id = ?"

    const/4 v7, 0x2

    new-array v7, v7, [Ljava/lang/String;

    const/4 v8, 0x0

    invoke-static/range {p2 .. p3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v7, v8

    const/4 v8, 0x1

    aput-object v4, v7, v8

    invoke-virtual {v2, v5, v6, v7}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 4101
    move-object/from16 v0, p1

    iget-object v2, v0, Lcom/google/android/gm/provider/MailSync$Conversation;->labelIds:Ljava/util/Set;

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_8
    :goto_4
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_6

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Long;

    .line 4102
    const-string v5, "labels_id"

    invoke-virtual {v3, v5, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 4103
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v5, "conversation_labels"

    const/4 v6, 0x0

    invoke-virtual {v2, v5, v6, v3}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v5

    .line 4104
    const-wide/16 v7, -0x1

    cmp-long v2, v5, v7

    if-nez v2, :cond_8

    .line 4108
    const-string v2, "Gmail"

    const-string v5, "Failed to insert conversation label"

    const/4 v6, 0x0

    new-array v6, v6, [Ljava/lang/Object;

    invoke-static {v2, v5, v6}, Lcom/google/android/gm/provider/LogUtils;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_4

    .line 4075
    :cond_9
    const-string v2, "labels_id"

    const/4 v5, 0x0

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v2, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto/16 :goto_3
.end method

.method public isBackgroundSyncInProgress()Z
    .locals 3

    .prologue
    .line 1839
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mStatusLock:Ljava/lang/Object;

    monitor-enter v1

    .line 1840
    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mStatus:Ljava/util/BitSet;

    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Ljava/util/BitSet;->get(I)Z

    move-result v0

    monitor-exit v1

    return v0

    .line 1841
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method isFullTextSearchEnabled()Z
    .locals 2

    .prologue
    .line 1515
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mPreferences:Lcom/google/android/gm/provider/MailEngine$Preferences;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mPreferences:Lcom/google/android/gm/provider/MailEngine$Preferences;

    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine;->getAccountName()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/google/android/gm/provider/MailEngine$Preferences;->getFullTextSearchEnabled(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isHandlingUserRefresh()Z
    .locals 3

    .prologue
    .line 1851
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mStatusLock:Ljava/lang/Object;

    monitor-enter v1

    .line 1852
    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mStatus:Ljava/util/BitSet;

    const/4 v2, 0x4

    invoke-virtual {v0, v2}, Ljava/util/BitSet;->get(I)Z

    move-result v0

    monitor-exit v1

    return v0

    .line 1853
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public isLabelSynchronized(Ljava/lang/String;)Z
    .locals 5
    .param p1, "canonicalName"    # Ljava/lang/String;

    .prologue
    .line 6662
    const/4 v0, 0x0

    .line 6663
    .local v0, "cursorIsForSyncedLabel":Z
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 6664
    const/4 v1, 0x0

    .line 6665
    .local v1, "settings":Lcom/google/android/gm/provider/Gmail$Settings;
    sget-object v4, Lcom/google/android/gm/provider/Gmail;->SETTINGS_PROJECTION:[Ljava/lang/String;

    invoke-virtual {p0, v4}, Lcom/google/android/gm/provider/MailEngine;->getPublicSettingsCursor([Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v2

    .line 6667
    .local v2, "settingsCursor":Landroid/database/Cursor;
    :try_start_0
    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    invoke-static {v4, v2}, Lcom/google/android/gm/provider/Gmail;->getSettings(Landroid/content/Context;Landroid/database/Cursor;)Lcom/google/android/gm/provider/Gmail$Settings;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 6669
    if-eqz v2, :cond_0

    .line 6670
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 6674
    :cond_0
    if-eqz v1, :cond_1

    .line 6675
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v3

    .line 6678
    .local v3, "synchronizedLabelsSet":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-virtual {v1}, Lcom/google/android/gm/provider/Gmail$Settings;->getLabelsIncluded()Ljava/util/List;

    move-result-object v4

    invoke-interface {v3, v4}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    .line 6679
    invoke-virtual {v1}, Lcom/google/android/gm/provider/Gmail$Settings;->getLabelsPartial()Ljava/util/List;

    move-result-object v4

    invoke-interface {v3, v4}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    .line 6681
    invoke-interface {v3, p1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    .line 6684
    .end local v1    # "settings":Lcom/google/android/gm/provider/Gmail$Settings;
    .end local v2    # "settingsCursor":Landroid/database/Cursor;
    .end local v3    # "synchronizedLabelsSet":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    :cond_1
    return v0

    .line 6669
    .restart local v1    # "settings":Lcom/google/android/gm/provider/Gmail$Settings;
    .restart local v2    # "settingsCursor":Landroid/database/Cursor;
    :catchall_0
    move-exception v4

    if-eqz v2, :cond_2

    .line 6670
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    :cond_2
    throw v4
.end method

.method public isLiveQueryInProgress()Z
    .locals 3

    .prologue
    .line 1845
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mStatusLock:Ljava/lang/Object;

    monitor-enter v1

    .line 1846
    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mStatus:Ljava/util/BitSet;

    const/4 v2, 0x2

    invoke-virtual {v0, v2}, Ljava/util/BitSet;->get(I)Z

    move-result v0

    monitor-exit v1

    return v0

    .line 1847
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public labelsSynced()Z
    .locals 1

    .prologue
    .line 814
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine;->getLabelMap()Lcom/google/android/gm/provider/Gmail$LabelMap;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gm/provider/Gmail$LabelMap;->labelsSynced()Z

    move-result v0

    return v0
.end method

.method labelsSynchronizationStateInitialized()Z
    .locals 1

    .prologue
    .line 823
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mLabelMap:Lcom/google/android/gm/provider/Gmail$LabelMap;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/Gmail$LabelMap;->labelsSynchronizationStateInitialized()Z

    move-result v0

    return v0
.end method

.method localMessageIdForMessageId(J)J
    .locals 5

    .prologue
    .line 2621
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "SELECT _id FROM messages WHERE messageId = ?"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Landroid/database/DatabaseUtils;->longForQuery(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;)J

    move-result-wide v0

    return-wide v0
.end method

.method messageIdPairForLocalMessageId(J)Lcom/google/android/gm/provider/MailEngine$MessageIdPair;
    .locals 8

    .prologue
    const/4 v5, 0x0

    .line 2575
    const/4 v0, 0x1

    new-array v4, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v4, v0

    .line 2576
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "messages"

    sget-object v2, Lcom/google/android/gm/provider/MailEngine;->PROJECTON_MESSAGE_ID_AND_CONVERSATION_ID:[Ljava/lang/String;

    const-string v3, "_id = ?"

    move-object v6, v5

    move-object v7, v5

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v1

    .line 2580
    :try_start_0
    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    if-nez v0, :cond_0

    .line 2592
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :goto_0
    return-object v5

    .line 2583
    :cond_0
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    .line 2584
    new-instance v5, Lcom/google/android/gm/provider/MailEngine$MessageIdPair;

    invoke-direct {v5, p0}, Lcom/google/android/gm/provider/MailEngine$MessageIdPair;-><init>(Lcom/google/android/gm/provider/MailEngine;)V

    .line 2585
    const-string v0, "messageId"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    iput-wide v2, v5, Lcom/google/android/gm/provider/MailEngine$MessageIdPair;->messageId:J

    .line 2587
    const-string v0, "conversation"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    iput-wide v2, v5, Lcom/google/android/gm/provider/MailEngine$MessageIdPair;->conversationId:J
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 2592
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    goto :goto_0

    :catchall_0
    move-exception v0

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    throw v0
.end method

.method public onSyncCanceled()V
    .locals 1

    .prologue
    .line 2108
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/gm/provider/MailEngine;->mIsSyncCancelled:Z

    .line 2109
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailSync;->onSyncCanceled()V

    .line 2110
    return-void
.end method

.method openLocalAttachment(Lcom/google/android/gm/provider/Gmail$Attachment;)Landroid/os/ParcelFileDescriptor;
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/FileNotFoundException;
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 3461
    const/4 v0, 0x0

    .line 3463
    iget-object v1, p1, Lcom/google/android/gm/provider/Gmail$Attachment;->cachedContent:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 3464
    iget-object v0, p1, Lcom/google/android/gm/provider/Gmail$Attachment;->cachedContent:Ljava/lang/String;

    .line 3470
    :cond_0
    :goto_0
    if-eqz v0, :cond_2

    .line 3474
    invoke-static {v0}, Lcom/google/android/gm/provider/AttachmentManager;->getPathFromUri(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 3475
    invoke-static {}, Landroid/os/Binder;->clearCallingIdentity()J

    move-result-wide v1

    .line 3477
    :try_start_0
    const-string v3, "Gmail"

    const-string v4, "Opening attachment %s"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object v0, v5, v6

    invoke-static {v3, v4, v5}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 3478
    new-instance v3, Ljava/io/File;

    invoke-direct {v3, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    const/high16 v0, 0x10000000

    invoke-static {v3, v0}, Landroid/os/ParcelFileDescriptor;->open(Ljava/io/File;I)Landroid/os/ParcelFileDescriptor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    .line 3481
    invoke-static {v1, v2}, Landroid/os/Binder;->restoreCallingIdentity(J)V

    return-object v0

    .line 3465
    :cond_1
    iget-object v1, p1, Lcom/google/android/gm/provider/Gmail$Attachment;->origin:Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;

    sget-object v2, Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;->LOCAL_FILE:Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;

    if-ne v1, v2, :cond_0

    iget-object v1, p1, Lcom/google/android/gm/provider/Gmail$Attachment;->originExtras:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 3467
    iget-object v0, p1, Lcom/google/android/gm/provider/Gmail$Attachment;->originExtras:Ljava/lang/String;

    goto :goto_0

    .line 3481
    :catchall_0
    move-exception v0

    invoke-static {v1, v2}, Landroid/os/Binder;->restoreCallingIdentity(J)V

    throw v0

    .line 3485
    :cond_2
    const-string v0, "Gmail"

    const-string v1, "Couldn\'t find local attachment"

    new-array v2, v3, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 3486
    new-instance v0, Ljava/io/FileNotFoundException;

    const-string v1, "Missing local attachment."

    invoke-direct {v0, v1}, Ljava/io/FileNotFoundException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public performBackgroundSync(Landroid/content/SyncResult;Landroid/os/Bundle;)V
    .locals 4

    .prologue
    .line 1670
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mBackgroundSyncThreadLock:Ljava/lang/Object;

    monitor-enter v1

    .line 1671
    :try_start_0
    iget-boolean v0, p0, Lcom/google/android/gm/provider/MailEngine;->mBackgroundTasksDisabledForTesting:Z

    if-eqz v0, :cond_0

    .line 1672
    const-string v0, "Gmail"

    const-string v2, "Sync disabled for testing, don\'t perform sync."

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v0, v2, v3}, Lcom/google/android/gm/provider/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1673
    monitor-exit v1

    .line 1684
    :goto_0
    return-void

    .line 1675
    :cond_0
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mBackgroundSyncThread:Ljava/lang/Thread;

    .line 1676
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 1678
    :try_start_1
    invoke-virtual {p0, p1, p2}, Lcom/google/android/gm/provider/MailEngine;->sync(Landroid/content/SyncResult;Landroid/os/Bundle;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_2

    .line 1680
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mBackgroundSyncThreadLock:Ljava/lang/Object;

    monitor-enter v1

    .line 1681
    const/4 v0, 0x0

    :try_start_2
    iput-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mBackgroundSyncThread:Ljava/lang/Thread;

    .line 1682
    monitor-exit v1

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v0

    .line 1676
    :catchall_1
    move-exception v0

    :try_start_3
    monitor-exit v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    throw v0

    .line 1680
    :catchall_2
    move-exception v0

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mBackgroundSyncThreadLock:Ljava/lang/Object;

    monitor-enter v1

    .line 1681
    const/4 v2, 0x0

    :try_start_4
    iput-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mBackgroundSyncThread:Ljava/lang/Thread;

    .line 1682
    monitor-exit v1
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_3

    throw v0

    :catchall_3
    move-exception v0

    :try_start_5
    monitor-exit v1
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_3

    throw v0
.end method

.method performRefresh(Landroid/database/Cursor;)V
    .locals 5

    .prologue
    const/4 v0, 0x0

    const/4 v1, 0x1

    .line 6597
    .line 6600
    invoke-direct {p0}, Lcom/google/android/gm/provider/MailEngine;->setRefreshStatus()V

    .line 6602
    if-eqz p1, :cond_1

    .line 6603
    invoke-interface {p1}, Landroid/database/Cursor;->getExtras()Landroid/os/Bundle;

    move-result-object v2

    .line 6606
    const-string v3, "active_network_query"

    invoke-virtual {v2, v3, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v3

    .line 6612
    if-eqz v3, :cond_1

    .line 6614
    const-string v3, "label_canonical_name"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 6617
    const-string v4, "status"

    invoke-virtual {v2, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 6618
    sget-object v4, Lcom/google/android/gm/provider/Gmail$CursorStatus;->ERROR:Lcom/google/android/gm/provider/Gmail$CursorStatus;

    invoke-virtual {v4}, Lcom/google/android/gm/provider/Gmail$CursorStatus;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v2, v4}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v2

    .line 6621
    invoke-virtual {p0, v3}, Lcom/google/android/gm/provider/MailEngine;->isLabelSynchronized(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    if-eqz v2, :cond_1

    .line 6622
    :cond_0
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 6623
    const-string v2, "command"

    const-string v3, "retry"

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 6624
    const-string v2, "force_refresh"

    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 6625
    invoke-interface {p1, v0}, Landroid/database/Cursor;->respond(Landroid/os/Bundle;)Landroid/os/Bundle;

    move v0, v1

    .line 6632
    :cond_1
    if-nez v0, :cond_2

    .line 6633
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 6634
    const-string v2, "force"

    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 6638
    const-string v2, "do_not_retry"

    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 6639
    const-string v2, "expedited"

    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 6641
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    const-string v2, "gmail-ls"

    invoke-static {v1, v2, v0}, Landroid/content/ContentResolver;->requestSync(Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;)V

    .line 6643
    :cond_2
    return-void
.end method

.method public postBackgroundTask(Ljava/lang/Runnable;)V
    .locals 1
    .param p1, "runnable"    # Ljava/lang/Runnable;

    .prologue
    .line 6470
    iget-boolean v0, p0, Lcom/google/android/gm/provider/MailEngine;->mMailEngineClosing:Z

    if-nez v0, :cond_0

    .line 6471
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mBackgroundTaskHandler:Landroid/os/Handler;

    invoke-virtual {v0, p1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 6473
    :cond_0
    return-void
.end method

.method purgeStaleMessagesOutsideTransaction()Z
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 3670
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->inTransaction()Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Must not be in transaction"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 3672
    :cond_0
    iget-boolean v0, p0, Lcom/google/android/gm/provider/MailEngine;->mIsSyncCancelled:Z

    if-nez v0, :cond_3

    .line 3673
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mTransactionListener:Lcom/google/android/gm/provider/GmailTransactionListener;

    invoke-virtual {v0, v2}, Lcom/google/android/gm/provider/TransactionHelper;->beginTransactionWithListenerNonExclusive(Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;)V

    move v0, v1

    .line 3676
    :goto_0
    :try_start_0
    invoke-direct {p0}, Lcom/google/android/gm/provider/MailEngine;->purgeSomeStaleMessagesInTransaction()Z

    move-result v2

    .line 3677
    if-nez v2, :cond_2

    .line 3681
    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v2}, Lcom/google/android/gm/provider/TransactionHelper;->setTransactionSuccessful()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 3683
    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v2}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    .line 3686
    :goto_1
    if-eqz v0, :cond_1

    .line 3687
    invoke-direct {p0, v1}, Lcom/google/android/gm/provider/MailEngine;->notifyDatasetChanged(Z)V

    .line 3688
    invoke-direct {p0}, Lcom/google/android/gm/provider/MailEngine;->requestIndex()V

    .line 3690
    :cond_1
    return v0

    .line 3678
    :cond_2
    const/4 v0, 0x1

    .line 3679
    :try_start_1
    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteDatabase;->yieldIfContendedSafely()Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 3683
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    throw v0

    :cond_3
    move v0, v1

    goto :goto_1
.end method

.method public registerInitializationListener(Landroid/os/Handler;Lcom/google/android/gm/provider/MailEngine$MailEngineInitListener;)V
    .locals 3
    .param p1, "handler"    # Landroid/os/Handler;
    .param p2, "listener"    # Lcom/google/android/gm/provider/MailEngine$MailEngineInitListener;

    .prologue
    .line 1096
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mInitializationLock:Ljava/lang/Object;

    monitor-enter v1

    .line 1097
    :try_start_0
    iget-boolean v0, p0, Lcom/google/android/gm/provider/MailEngine;->mInitializationComplete:Z

    if-eqz v0, :cond_0

    .line 1099
    invoke-direct {p0, p1, p2}, Lcom/google/android/gm/provider/MailEngine;->callInitializationListener(Landroid/os/Handler;Lcom/google/android/gm/provider/MailEngine$MailEngineInitListener;)V

    .line 1107
    :goto_0
    monitor-exit v1

    .line 1108
    return-void

    .line 1102
    :cond_0
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mInitCallbacks:Ljava/util/List;

    if-nez v0, :cond_1

    .line 1103
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mInitCallbacks:Ljava/util/List;

    .line 1105
    :cond_1
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mInitCallbacks:Ljava/util/List;

    new-instance v2, Landroid/util/Pair;

    invoke-direct {v2, p1, p2}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 1107
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public requestSync()V
    .locals 3

    .prologue
    .line 859
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    const-string v1, "gmail-ls"

    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    invoke-static {v0, v1, v2}, Landroid/content/ContentResolver;->requestSync(Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;)V

    .line 860
    return-void
.end method

.method scheduleIndexing()V
    .locals 8

    .prologue
    const/4 v1, 0x1

    .line 1528
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    const-string v2, "alarm"

    invoke-virtual {v0, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/AlarmManager;

    .line 1529
    if-eqz v0, :cond_0

    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mStartAccountIndexingIntent:Landroid/app/PendingIntent;

    if-nez v2, :cond_1

    .line 1541
    :cond_0
    :goto_0
    return-void

    .line 1533
    :cond_1
    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    const-string v3, "gmail_full_text_search_indexer_delay_msec"

    const v4, 0x493e0

    invoke-static {v2, v3, v4}, Lcom/google/android/gsf/Gservices;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v2

    .line 1536
    const-string v3, "Gmail"

    const-string v4, "Scheduling index for %s ms from now"

    new-array v5, v1, [Ljava/lang/Object;

    const/4 v6, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v3, v4, v5}, Lcom/google/android/gm/provider/LogUtils;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1539
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    int-to-long v5, v2

    add-long v2, v3, v5

    const-wide/32 v4, 0xdbba0

    iget-object v6, p0, Lcom/google/android/gm/provider/MailEngine;->mStartAccountIndexingIntent:Landroid/app/PendingIntent;

    invoke-virtual/range {v0 .. v6}, Landroid/app/AlarmManager;->setInexactRepeating(IJJLandroid/app/PendingIntent;)V

    goto :goto_0
.end method

.method sendAccountNotifications(Z)V
    .locals 3
    .param p1, "scheduleSync"    # Z

    .prologue
    .line 6459
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    iget-object v1, v1, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-static {v1}, Lcom/google/android/gm/provider/Gmail;->getBaseUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2, p1}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;Z)V

    .line 6461
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mDatasetChangedNotifier:Lcom/google/android/gm/provider/MailEngine$DatasetChangedNotifier;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailEngine$DatasetChangedNotifier;->scheduleTask()V

    .line 6462
    return-void
.end method

.method public sendNotificationIntents(Z)V
    .locals 23

    .prologue
    .line 3742
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    if-nez v2, :cond_1

    .line 3843
    :cond_0
    return-void

    .line 3753
    :cond_1
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v2}, Lcom/google/android/gm/provider/TransactionHelper;->beginTransactionNonExclusive()V

    .line 3755
    :try_start_0
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailEngine;->mLabelMap:Lcom/google/android/gm/provider/Gmail$LabelMap;

    invoke-virtual {v2}, Lcom/google/android/gm/provider/Gmail$LabelMap;->requery()V

    .line 3756
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v2}, Lcom/google/android/gm/provider/TransactionHelper;->setTransactionSuccessful()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 3758
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v2}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    .line 3760
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailEngine;->mNotificationLabels:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v2

    invoke-static {v2}, Lcom/google/common/collect/Sets;->newHashSet(Ljava/lang/Iterable;)Ljava/util/HashSet;

    move-result-object v2

    .line 3761
    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v13

    :cond_2
    :goto_0
    invoke-interface {v13}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v13}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Long;

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v14

    .line 3762
    move-object/from16 v0, p0

    invoke-virtual {v0, v14, v15}, Lcom/google/android/gm/provider/MailEngine;->getNotificationTagLabel(J)Lcom/google/android/gm/provider/MailCore$Label;

    move-result-object v16

    .line 3763
    if-eqz v16, :cond_2

    .line 3764
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "notificationLabelCount-"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v14, v15}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    .line 3766
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "notificationLabelMaxMessageId-"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v14, v15}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    .line 3769
    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gm/provider/MailEngine;->getSettingsInteger(Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v19

    .line 3770
    const-wide/16 v2, 0x0

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    move-object/from16 v0, p0

    move-object/from16 v1, v18

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gm/provider/MailEngine;->getSettingsLong(Ljava/lang/String;Ljava/lang/Long;)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v20

    .line 3772
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailEngine;->mLabelMap:Lcom/google/android/gm/provider/Gmail$LabelMap;

    move-object/from16 v0, v16

    iget-wide v3, v0, Lcom/google/android/gm/provider/MailCore$Label;->id:J

    invoke-virtual {v2, v3, v4}, Lcom/google/android/gm/provider/Gmail$LabelMap;->getNumUnreadConversations(J)I

    move-result v22

    .line 3774
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailEngine;->mLabelMap:Lcom/google/android/gm/provider/Gmail$LabelMap;

    invoke-virtual {v2, v14, v15}, Lcom/google/android/gm/provider/Gmail$LabelMap;->getNumUnreadConversations(J)I

    move-result v3

    .line 3775
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailEngine;->mNotificationLabels:Ljava/util/Map;

    invoke-static {v14, v15}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-interface {v2, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    .line 3776
    const-string v4, "Gmail"

    const-string v5, "considering sending notification. label=%d, oldCount=%d, newCount=%d, unseenCount=%d, getAttention=%b"

    const/4 v6, 0x5

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    invoke-static {v14, v15}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    aput-object v8, v6, v7

    const/4 v7, 0x1

    invoke-static/range {v19 .. v19}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v6, v7

    const/4 v7, 0x2

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v6, v7

    const/4 v7, 0x3

    invoke-static/range {v22 .. v22}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v6, v7

    const/4 v7, 0x4

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-static {v4, v5, v6}, Lcom/google/android/gm/provider/LogUtils;->v(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 3781
    if-eqz v22, :cond_3

    if-nez v3, :cond_e

    .line 3782
    :cond_3
    const/4 v3, 0x0

    .line 3783
    const/4 v2, 0x0

    move v11, v2

    move v12, v3

    .line 3788
    :goto_1
    const-wide/16 v9, 0x0

    .line 3789
    if-lez v12, :cond_d

    .line 3792
    const/4 v8, 0x0

    .line 3794
    const/4 v3, 0x0

    :try_start_1
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "label:"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move-object/from16 v0, v16

    iget-object v4, v0, Lcom/google/android/gm/provider/MailCore$Label;->canonicalName:Ljava/lang/String;

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    sget-object v5, Lcom/google/android/gm/provider/MailEngine;->LOCAL_ONLY_CONVERSATION_QUERY_SELECTION_ARGS:[Ljava/lang/String;

    const/4 v2, 0x1

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    const/4 v7, 0x0

    move-object/from16 v2, p0

    invoke-virtual/range {v2 .. v7}, Lcom/google/android/gm/provider/MailEngine;->getConversationCursorForQuery([Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Integer;Z)Landroid/database/Cursor;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v3

    .line 3799
    :try_start_2
    invoke-interface {v3}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v2

    if-eqz v2, :cond_c

    .line 3800
    const-string v2, "maxMessageId"

    invoke-interface {v3, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v3, v2}, Landroid/database/Cursor;->getLong(I)J
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    move-result-wide v4

    .line 3805
    :goto_2
    if-eqz v3, :cond_b

    .line 3806
    invoke-interface {v3}, Landroid/database/Cursor;->close()V

    move-wide v8, v4

    .line 3811
    :goto_3
    const-wide/16 v2, 0x0

    cmp-long v2, v8, v2

    if-eqz v2, :cond_9

    cmp-long v2, v8, v20

    if-lez v2, :cond_9

    const/4 v2, 0x1

    .line 3814
    :goto_4
    move/from16 v0, v19

    if-ne v0, v12, :cond_4

    if-nez v2, :cond_4

    if-nez v11, :cond_4

    if-eqz p1, :cond_6

    .line 3821
    :cond_4
    if-nez p1, :cond_5

    if-lez v12, :cond_a

    if-eqz v2, :cond_a

    :cond_5
    const/4 v7, 0x1

    .line 3822
    :goto_5
    const-string v2, "Gmail"

    const-string v3, "sending notification. Adjusted values are label=%d, oldCount=%d, newCount=%d, unseenCount=%d, getAttention=%b"

    const/4 v4, 0x5

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-static {v14, v15}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    invoke-static/range {v19 .. v19}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x2

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x3

    invoke-static/range {v22 .. v22}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x4

    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v2, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 3826
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    invoke-virtual {v2, v14, v15}, Lcom/google/android/gm/provider/MailCore;->getLabelOrThrow(J)Lcom/google/android/gm/provider/MailCore$Label;

    move-result-object v3

    move-object/from16 v2, p0

    move-object/from16 v4, v16

    move v5, v12

    move/from16 v6, v22

    invoke-direct/range {v2 .. v7}, Lcom/google/android/gm/provider/MailEngine;->sendNotificationIntent(Lcom/google/android/gm/provider/MailCore$Label;Lcom/google/android/gm/provider/MailCore$Label;IIZ)V

    .line 3830
    :cond_6
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailEngine;->mNotificationLabels:Ljava/util/Map;

    invoke-static {v14, v15}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    const/4 v4, 0x0

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3835
    move/from16 v0, v19

    if-eq v0, v12, :cond_7

    .line 3836
    invoke-static {v12}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-direct {v0, v1, v2}, Lcom/google/android/gm/provider/MailEngine;->setSettingsValue(Ljava/lang/String;Ljava/lang/String;)V

    .line 3838
    :cond_7
    const-wide/16 v2, 0x0

    cmp-long v2, v8, v2

    if-eqz v2, :cond_2

    cmp-long v2, v8, v20

    if-lez v2, :cond_2

    .line 3839
    invoke-static {v8, v9}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p0

    move-object/from16 v1, v18

    invoke-direct {v0, v1, v2}, Lcom/google/android/gm/provider/MailEngine;->setSettingsValue(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 3758
    :catchall_0
    move-exception v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v3}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    throw v2

    .line 3805
    :catchall_1
    move-exception v2

    move-object v3, v8

    :goto_6
    if-eqz v3, :cond_8

    .line 3806
    invoke-interface {v3}, Landroid/database/Cursor;->close()V

    :cond_8
    throw v2

    .line 3811
    :cond_9
    const/4 v2, 0x0

    goto/16 :goto_4

    .line 3821
    :cond_a
    const/4 v7, 0x0

    goto/16 :goto_5

    .line 3805
    :catchall_2
    move-exception v2

    goto :goto_6

    :cond_b
    move-wide v8, v4

    goto/16 :goto_3

    :cond_c
    move-wide v4, v9

    goto/16 :goto_2

    :cond_d
    move-wide v8, v9

    goto/16 :goto_3

    :cond_e
    move v11, v2

    move v12, v3

    goto/16 :goto_1
.end method

.method public sendOrSaveDraft(JZJLandroid/content/ContentValues;)J
    .locals 23

    .prologue
    .line 3088
    new-instance v22, Landroid/util/TimingLogger;

    const-string v3, "Gmail"

    const-string v4, "sendOrSaveDraft"

    move-object/from16 v0, v22

    invoke-direct {v0, v3, v4}, Landroid/util/TimingLogger;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 3090
    const-string v3, "joinedAttachmentInfos"

    move-object/from16 v0, p6

    invoke-virtual {v0, v3}, Landroid/content/ContentValues;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 3091
    move-object/from16 v0, p0

    move-wide/from16 v1, p1

    invoke-direct {v0, v3, v1, v2}, Lcom/google/android/gm/provider/MailEngine;->getUpdatedAttachments(Ljava/lang/String;J)Ljava/util/List;

    move-result-object v4

    .line 3094
    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_0
    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/google/android/gm/provider/Gmail$Attachment;

    .line 3095
    iget-object v6, v3, Lcom/google/android/gm/provider/Gmail$Attachment;->origin:Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;

    sget-object v7, Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;->LOCAL_FILE:Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;

    if-ne v6, v7, :cond_0

    iget-object v6, v3, Lcom/google/android/gm/provider/Gmail$Attachment;->cachedContent:Ljava/lang/String;

    invoke-static {v6}, Lcom/google/android/common/base/Strings;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 3097
    move-object/from16 v0, p0

    invoke-direct {v0, v3}, Lcom/google/android/gm/provider/MailEngine;->cacheAttachment(Lcom/google/android/gm/provider/Gmail$Attachment;)Z

    goto :goto_0

    .line 3100
    :cond_1
    invoke-static {v4}, Lcom/google/android/gm/provider/Gmail$MessageModification;->joinedAttachmentsString(Ljava/util/List;)Ljava/lang/String;

    move-result-object v11

    .line 3101
    const-string v3, "caching"

    move-object/from16 v0, v22

    invoke-virtual {v0, v3}, Landroid/util/TimingLogger;->addSplit(Ljava/lang/String;)V

    .line 3103
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/google/android/gm/provider/MailEngine;->mTransactionListener:Lcom/google/android/gm/provider/GmailTransactionListener;

    invoke-virtual {v3, v4}, Lcom/google/android/gm/provider/TransactionHelper;->beginTransactionWithListenerNonExclusive(Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;)V

    .line 3104
    const/4 v14, 0x0

    .line 3105
    const-string v3, "beginTransactionNonExclusive"

    move-object/from16 v0, v22

    invoke-virtual {v0, v3}, Landroid/util/TimingLogger;->addSplit(Ljava/lang/String;)V

    .line 3111
    const-wide/16 v3, 0x0

    cmp-long v3, p1, v3

    if-eqz v3, :cond_2

    const-wide/16 v3, -0x1

    cmp-long v3, p1, v3

    if-nez v3, :cond_9

    :cond_2
    const/4 v3, 0x1

    move v10, v3

    .line 3114
    :goto_1
    :try_start_0
    invoke-virtual/range {p0 .. p2}, Lcom/google/android/gm/provider/MailEngine;->messageIdPairForLocalMessageId(J)Lcom/google/android/gm/provider/MailEngine$MessageIdPair;

    move-result-object v5

    .line 3116
    if-nez v10, :cond_3

    if-nez v5, :cond_a

    :cond_3
    const-wide/16 v3, 0x0

    move-wide/from16 v20, v3

    .line 3119
    :goto_2
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v12

    .line 3121
    new-instance v3, Landroid/content/ContentValues;

    move-object/from16 v0, p6

    invoke-direct {v3, v0}, Landroid/content/ContentValues;-><init>(Landroid/content/ContentValues;)V

    .line 3122
    const-string v4, "value fiddling"

    move-object/from16 v0, v22

    invoke-virtual {v0, v4}, Landroid/util/TimingLogger;->addSplit(Ljava/lang/String;)V

    .line 3128
    if-nez v10, :cond_4

    if-nez v5, :cond_d

    .line 3132
    :cond_4
    const/16 v4, 0x14

    shl-long v4, v12, v4

    .line 3133
    const-string v6, "messageId"

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    invoke-virtual {v3, v6, v7}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3134
    const-wide/16 v6, 0x0

    cmp-long v6, p4, v6

    if-eqz v6, :cond_5

    const-wide/16 v6, -0x1

    cmp-long v6, p1, v6

    if-nez v6, :cond_b

    .line 3136
    :cond_5
    const-wide/16 v6, 0x0

    move-wide/from16 v18, v4

    .line 3156
    :goto_3
    const-string v8, "fetch ref message"

    move-object/from16 v0, v22

    invoke-virtual {v0, v8}, Landroid/util/TimingLogger;->addSplit(Ljava/lang/String;)V

    .line 3157
    const-string v8, "conversation"

    invoke-static/range {v18 .. v19}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v9

    invoke-virtual {v3, v8, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3159
    const-string v8, "queryId"

    const/4 v9, 0x0

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v3, v8, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 3162
    const-string v8, "synced"

    const/4 v9, 0x1

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v3, v8, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 3163
    const-string v8, "dateSentMs"

    invoke-static {v12, v13}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v9

    invoke-virtual {v3, v8, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3164
    const-string v8, "dateReceivedMs"

    invoke-static {v12, v13}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v9

    invoke-virtual {v3, v8, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3169
    const-string v8, "body"

    invoke-virtual {v3, v8}, Landroid/content/ContentValues;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v8

    if-eqz v8, :cond_6

    .line 3170
    const-string v8, "bodyCompressed"

    invoke-virtual {v3, v8}, Landroid/content/ContentValues;->putNull(Ljava/lang/String;)V

    .line 3174
    :cond_6
    const-string v8, "error"

    const-string v9, ""

    invoke-virtual {v3, v8, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3175
    const-string v8, "clientCreated"

    const/4 v9, 0x1

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v3, v8, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 3178
    const-wide/16 v8, 0x0

    cmp-long v8, v6, v8

    if-eqz v8, :cond_7

    .line 3179
    const-string v8, "refMessageId"

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v9

    invoke-virtual {v3, v8, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 3181
    :cond_7
    const-string v8, "more values"

    move-object/from16 v0, v22

    invoke-virtual {v0, v8}, Landroid/util/TimingLogger;->addSplit(Ljava/lang/String;)V

    .line 3183
    const-string v8, "Gmail"

    const-string v9, "MailEngine.sendOrSaveMessage messageId=%d refMessageId=%d, conversationId=%d"

    const/4 v12, 0x3

    new-array v12, v12, [Ljava/lang/Object;

    const/4 v13, 0x0

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v15

    aput-object v15, v12, v13

    const/4 v13, 0x1

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    aput-object v6, v12, v13

    const/4 v6, 0x2

    invoke-static/range {v18 .. v19}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    aput-object v7, v12, v6

    invoke-static {v8, v9, v12}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 3190
    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v7, "message_labels"

    const-string v8, "message_messageId = ?"

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/String;

    const/4 v12, 0x0

    invoke-static {v4, v5}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v13

    aput-object v13, v9, v12

    invoke-virtual {v6, v7, v8, v9}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 3192
    const-string v6, "delete old labels"

    move-object/from16 v0, v22

    invoke-virtual {v0, v6}, Landroid/util/TimingLogger;->addSplit(Ljava/lang/String;)V

    .line 3194
    const-string v6, "joinedAttachmentInfos"

    invoke-virtual {v3, v6, v11}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3196
    if-eqz v10, :cond_e

    .line 3197
    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v7, "messages"

    const/4 v8, 0x0

    invoke-virtual {v6, v7, v8, v3}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide p1

    .line 3198
    const-wide/16 v6, -0x1

    cmp-long v6, p1, v6

    if-nez v6, :cond_f

    .line 3199
    new-instance v4, Ljava/lang/IllegalStateException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Error while inserting message with values: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v4, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 3299
    :catchall_0
    move-exception v3

    move v4, v14

    :goto_4
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v5}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    .line 3300
    const-string v5, "finish"

    move-object/from16 v0, v22

    invoke-virtual {v0, v5}, Landroid/util/TimingLogger;->addSplit(Ljava/lang/String;)V

    .line 3302
    if-eqz v4, :cond_8

    .line 3303
    const/4 v4, 0x1

    move-object/from16 v0, p0

    invoke-direct {v0, v4}, Lcom/google/android/gm/provider/MailEngine;->notifyDatasetChanged(Z)V

    .line 3304
    const-string v4, "onConversationChanged (new)"

    move-object/from16 v0, v22

    invoke-virtual {v0, v4}, Landroid/util/TimingLogger;->addSplit(Ljava/lang/String;)V

    .line 3306
    :cond_8
    invoke-virtual/range {v22 .. v22}, Landroid/util/TimingLogger;->dumpToLog()V

    throw v3

    .line 3111
    :cond_9
    const/4 v3, 0x0

    move v10, v3

    goto/16 :goto_1

    .line 3116
    :cond_a
    :try_start_1
    iget-wide v3, v5, Lcom/google/android/gm/provider/MailEngine$MessageIdPair;->conversationId:J

    move-wide/from16 v20, v3

    goto/16 :goto_2

    .line 3138
    :cond_b
    const/4 v6, 0x0

    move-object/from16 v0, p0

    move-wide/from16 v1, p4

    invoke-virtual {v0, v1, v2, v6}, Lcom/google/android/gm/provider/MailEngine;->getLocalMessage(JZ)Lcom/google/android/gm/provider/MailSync$Message;

    move-result-object v6

    .line 3139
    if-nez v6, :cond_c

    .line 3143
    const-wide/16 v6, 0x0

    move-wide/from16 v18, v4

    goto/16 :goto_3

    .line 3145
    :cond_c
    iget-wide v8, v6, Lcom/google/android/gm/provider/MailSync$Message;->conversationId:J

    .line 3146
    iget-wide v6, v6, Lcom/google/android/gm/provider/MailSync$Message;->messageId:J

    move-wide/from16 v18, v8

    goto/16 :goto_3

    .line 3150
    :cond_d
    iget-wide v8, v5, Lcom/google/android/gm/provider/MailEngine$MessageIdPair;->conversationId:J

    .line 3151
    iget-wide v4, v5, Lcom/google/android/gm/provider/MailEngine$MessageIdPair;->messageId:J

    .line 3154
    const-wide/16 v6, 0x0

    move-wide/from16 v18, v8

    goto/16 :goto_3

    .line 3203
    :cond_e
    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v7, "messages"

    const-string v8, "_id = ?"

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/String;

    const/4 v10, 0x0

    invoke-static/range {p1 .. p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-virtual {v6, v7, v3, v8, v9}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 3206
    :cond_f
    const-string v3, "insert or update"

    move-object/from16 v0, v22

    invoke-virtual {v0, v3}, Landroid/util/TimingLogger;->addSplit(Ljava/lang/String;)V

    .line 3208
    if-eqz p3, :cond_13

    .line 3209
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    const-string v7, "^r"

    invoke-virtual {v6, v7}, Lcom/google/android/gm/provider/MailCore;->getLabelOrThrow(Ljava/lang/String;)Lcom/google/android/gm/provider/MailCore$Label;

    move-result-object v6

    const/4 v7, 0x1

    sget-object v8, Lcom/google/android/gm/provider/Operations$RecordHistory;->FALSE:Lcom/google/android/gm/provider/Operations$RecordHistory;

    invoke-virtual/range {v3 .. v8}, Lcom/google/android/gm/provider/MailCore;->setLabelOnMessage(JLcom/google/android/gm/provider/MailCore$Label;ZLcom/google/android/gm/provider/Operations$RecordHistory;)V

    .line 3233
    :goto_5
    const-string v3, "set new labels"

    move-object/from16 v0, v22

    invoke-virtual {v0, v3}, Landroid/util/TimingLogger;->addSplit(Ljava/lang/String;)V

    .line 3236
    if-eqz p3, :cond_1b

    .line 3237
    const-string v11, "messageSaved"

    .line 3251
    :goto_6
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine;->mOperations:Lcom/google/android/gm/provider/Operations;

    invoke-virtual {v3, v4, v5}, Lcom/google/android/gm/provider/Operations;->deleteOperationsForMessageId(J)V

    .line 3253
    const-string v3, "update operations"

    move-object/from16 v0, v22

    invoke-virtual {v0, v3}, Landroid/util/TimingLogger;->addSplit(Ljava/lang/String;)V

    .line 3255
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v6

    .line 3256
    const-string v3, "gmail_send_immediately"

    const/4 v7, 0x1

    invoke-static {v6, v3, v7}, Lcom/google/android/gsf/Gservices;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v3

    if-eqz v3, :cond_1c

    const/4 v3, 0x1

    move/from16 v17, v3

    .line 3258
    :goto_7
    const-string v3, "gmail_send_without_sync"

    const/4 v7, 0x1

    invoke-static {v6, v3, v7}, Lcom/google/android/gsf/Gservices;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v3

    if-eqz v3, :cond_1d

    const/4 v3, 0x1

    move/from16 v16, v3

    .line 3260
    :goto_8
    invoke-static {}, Landroid/content/ContentResolver;->getMasterSyncAutomatically()Z

    move-result v3

    if-eqz v3, :cond_1e

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gm/provider/MailEngine;->automaticSyncEnabled()Z

    move-result v3

    if-eqz v3, :cond_1e

    const/4 v3, 0x1

    move v15, v3

    .line 3262
    :goto_9
    if-nez p3, :cond_1f

    if-eqz v17, :cond_1f

    if-eqz v16, :cond_1f

    if-nez v15, :cond_1f

    const/4 v3, 0x1

    .line 3265
    :goto_a
    if-eqz v3, :cond_20

    .line 3266
    new-instance v6, Lcom/google/android/gm/provider/Operations$OperationInfo;

    const-wide/16 v12, 0x0

    move-wide/from16 v7, v18

    move-wide v9, v4

    invoke-direct/range {v6 .. v13}, Lcom/google/android/gm/provider/Operations$OperationInfo;-><init>(JJLjava/lang/String;J)V

    .line 3268
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine;->mOperations:Lcom/google/android/gm/provider/Operations;

    invoke-virtual {v3, v6}, Lcom/google/android/gm/provider/Operations;->incrementAndAddOperations(Lcom/google/android/gm/provider/Operations$OperationInfo;)J

    .line 3273
    :goto_b
    const-string v3, "update operations"

    move-object/from16 v0, v22

    invoke-virtual {v0, v3}, Landroid/util/TimingLogger;->addSplit(Ljava/lang/String;)V

    .line 3275
    cmp-long v3, v18, v20

    if-eqz v3, :cond_10

    const-wide/16 v6, 0x0

    cmp-long v3, v20, v6

    if-eqz v3, :cond_10

    .line 3276
    sget-object v3, Lcom/google/android/gm/provider/MailSync$SyncRationale;->LOCAL_CHANGE:Lcom/google/android/gm/provider/MailSync$SyncRationale;

    move-object/from16 v0, p0

    move-wide/from16 v1, v20

    invoke-direct {v0, v1, v2, v3}, Lcom/google/android/gm/provider/MailEngine;->onConversationChanged(JLcom/google/android/gm/provider/MailSync$SyncRationale;)V

    .line 3278
    :cond_10
    const-string v3, "onConversationChanged (old)"

    move-object/from16 v0, v22

    invoke-virtual {v0, v3}, Landroid/util/TimingLogger;->addSplit(Ljava/lang/String;)V

    .line 3279
    sget-object v9, Lcom/google/android/gm/provider/MailSync$SyncRationale;->LOCAL_CHANGE:Lcom/google/android/gm/provider/MailSync$SyncRationale;

    const/4 v10, 0x1

    const/4 v11, 0x0

    move-object/from16 v6, p0

    move-wide/from16 v7, v18

    invoke-direct/range {v6 .. v11}, Lcom/google/android/gm/provider/MailEngine;->onConversationChanged(JLcom/google/android/gm/provider/MailSync$SyncRationale;ZZ)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 3281
    const/4 v6, 0x1

    .line 3283
    if-nez p3, :cond_12

    if-eqz v17, :cond_12

    .line 3284
    :try_start_2
    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    .line 3285
    const-string v7, "expedited"

    const/4 v8, 0x1

    invoke-virtual {v3, v7, v8}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 3286
    if-eqz v16, :cond_11

    if-nez v15, :cond_11

    .line 3287
    const-string v7, "force"

    const/4 v8, 0x1

    invoke-virtual {v3, v7, v8}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 3288
    const-string v7, "sendwithoutsync"

    const/4 v8, 0x1

    invoke-virtual {v3, v7, v8}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 3289
    const-string v7, "sendwithoutsyncMessageId"

    invoke-virtual {v3, v7, v4, v5}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 3290
    const-string v4, "sendwithoutsyncConversationId"

    move-wide/from16 v0, v18

    invoke-virtual {v3, v4, v0, v1}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 3292
    :cond_11
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    const-string v5, "gmail-ls"

    invoke-static {v4, v5, v3}, Landroid/content/ContentResolver;->requestSync(Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;)V

    .line 3295
    :cond_12
    const-string v3, "notifyDatasetChanged"

    move-object/from16 v0, v22

    invoke-virtual {v0, v3}, Landroid/util/TimingLogger;->addSplit(Ljava/lang/String;)V

    .line 3296
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v3}, Lcom/google/android/gm/provider/TransactionHelper;->setTransactionSuccessful()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 3299
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v3}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    .line 3300
    const-string v3, "finish"

    move-object/from16 v0, v22

    invoke-virtual {v0, v3}, Landroid/util/TimingLogger;->addSplit(Ljava/lang/String;)V

    .line 3303
    const/4 v3, 0x1

    move-object/from16 v0, p0

    invoke-direct {v0, v3}, Lcom/google/android/gm/provider/MailEngine;->notifyDatasetChanged(Z)V

    .line 3304
    const-string v3, "onConversationChanged (new)"

    move-object/from16 v0, v22

    invoke-virtual {v0, v3}, Landroid/util/TimingLogger;->addSplit(Ljava/lang/String;)V

    .line 3306
    invoke-virtual/range {v22 .. v22}, Landroid/util/TimingLogger;->dumpToLog()V

    return-wide p1

    .line 3213
    :cond_13
    const/4 v3, 0x0

    .line 3214
    const/4 v6, 0x0

    :try_start_3
    move-object/from16 v0, p0

    invoke-virtual {v0, v4, v5, v6}, Lcom/google/android/gm/provider/MailEngine;->getMessage(JZ)Lcom/google/android/gm/provider/MailSync$Message;

    move-result-object v6

    .line 3215
    if-eqz v6, :cond_16

    .line 3216
    iget-object v3, v6, Lcom/google/android/gm/provider/MailSync$Message;->toAddresses:Ljava/util/List;

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    iget-object v7, v7, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-static {v3, v7}, Lcom/google/android/gm/provider/MailEngine;->addressStringsListContainsEmailAddress(Ljava/util/Collection;Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_18

    const/4 v3, 0x1

    .line 3218
    :goto_c
    if-nez v3, :cond_14

    iget-object v3, v6, Lcom/google/android/gm/provider/MailSync$Message;->ccAddresses:Ljava/util/List;

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    iget-object v7, v7, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-static {v3, v7}, Lcom/google/android/gm/provider/MailEngine;->addressStringsListContainsEmailAddress(Ljava/util/Collection;Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_19

    :cond_14
    const/4 v3, 0x1

    .line 3220
    :goto_d
    if-nez v3, :cond_15

    iget-object v3, v6, Lcom/google/android/gm/provider/MailSync$Message;->bccAddresses:Ljava/util/List;

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    iget-object v6, v6, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-static {v3, v6}, Lcom/google/android/gm/provider/MailEngine;->addressStringsListContainsEmailAddress(Ljava/util/Collection;Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1a

    :cond_15
    const/4 v3, 0x1

    .line 3223
    :cond_16
    :goto_e
    if-eqz v3, :cond_17

    .line 3224
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    const-string v7, "^i"

    invoke-virtual {v6, v7}, Lcom/google/android/gm/provider/MailCore;->getLabelOrThrow(Ljava/lang/String;)Lcom/google/android/gm/provider/MailCore$Label;

    move-result-object v6

    const/4 v7, 0x1

    sget-object v8, Lcom/google/android/gm/provider/Operations$RecordHistory;->FALSE:Lcom/google/android/gm/provider/Operations$RecordHistory;

    invoke-virtual/range {v3 .. v8}, Lcom/google/android/gm/provider/MailCore;->setLabelOnMessage(JLcom/google/android/gm/provider/MailCore$Label;ZLcom/google/android/gm/provider/Operations$RecordHistory;)V

    .line 3229
    :cond_17
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    const-string v7, "^^out"

    invoke-virtual {v6, v7}, Lcom/google/android/gm/provider/MailCore;->getLabelOrThrow(Ljava/lang/String;)Lcom/google/android/gm/provider/MailCore$Label;

    move-result-object v6

    const/4 v7, 0x1

    sget-object v8, Lcom/google/android/gm/provider/Operations$RecordHistory;->FALSE:Lcom/google/android/gm/provider/Operations$RecordHistory;

    invoke-virtual/range {v3 .. v8}, Lcom/google/android/gm/provider/MailCore;->setLabelOnMessage(JLcom/google/android/gm/provider/MailCore$Label;ZLcom/google/android/gm/provider/Operations$RecordHistory;)V

    goto/16 :goto_5

    .line 3216
    :cond_18
    const/4 v3, 0x0

    goto :goto_c

    .line 3218
    :cond_19
    const/4 v3, 0x0

    goto :goto_d

    .line 3220
    :cond_1a
    const/4 v3, 0x0

    goto :goto_e

    .line 3239
    :cond_1b
    const-string v11, "messageSent"

    goto/16 :goto_6

    .line 3256
    :cond_1c
    const/4 v3, 0x0

    move/from16 v17, v3

    goto/16 :goto_7

    .line 3258
    :cond_1d
    const/4 v3, 0x0

    move/from16 v16, v3

    goto/16 :goto_8

    .line 3260
    :cond_1e
    const/4 v3, 0x0

    move v15, v3

    goto/16 :goto_9

    .line 3262
    :cond_1f
    const/4 v3, 0x0

    goto/16 :goto_a

    .line 3270
    :cond_20
    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/google/android/gm/provider/MailEngine;->mOperations:Lcom/google/android/gm/provider/Operations;

    move-wide/from16 v7, v18

    move-wide v9, v4

    invoke-virtual/range {v6 .. v11}, Lcom/google/android/gm/provider/Operations;->recordOperation(JJLjava/lang/String;)J
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto/16 :goto_b

    .line 3299
    :catchall_1
    move-exception v3

    move v4, v6

    goto/16 :goto_4
.end method

.method sendUpgradeSyncWindowIntent()V
    .locals 3

    .prologue
    .line 4126
    new-instance v0, Landroid/content/Intent;

    const-string v1, "com.google.android.gm.intent.ACTION_UPGRADE_SYNC_WINDOW"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 4127
    const-string v1, "account"

    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine;->getAccountName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 4128
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 4129
    return-void
.end method

.method setBackgroundTasksDisabledForTesting(Z)V
    .locals 0
    .param p1, "disabled"    # Z

    .prologue
    .line 887
    iput-boolean p1, p0, Lcom/google/android/gm/provider/MailEngine;->mBackgroundTasksDisabledForTesting:Z

    .line 888
    invoke-direct {p0}, Lcom/google/android/gm/provider/MailEngine;->interruptAndWaitForBackgroundThreads()V

    .line 889
    return-void
.end method

.method setInternalSetting(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 1642
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 1643
    const-string v1, "name"

    invoke-virtual {v0, v1, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1644
    const-string v1, "value"

    invoke-virtual {v0, v1, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1645
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mInternalDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "internal_sync_settings"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3, v0}, Landroid/database/sqlite/SQLiteDatabase;->replace(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 1646
    return-void
.end method

.method public setLabelOnConversation(JJLjava/lang/String;Z)V
    .locals 9

    .prologue
    .line 2773
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mTransactionListener:Lcom/google/android/gm/provider/GmailTransactionListener;

    invoke-virtual {v0, v1}, Lcom/google/android/gm/provider/TransactionHelper;->beginTransactionWithListenerNonExclusive(Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;)V

    .line 2774
    const/4 v0, 0x0

    .line 2775
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v8

    .line 2777
    :try_start_0
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    invoke-virtual {v1, p5}, Lcom/google/android/gm/provider/MailCore;->getLabelOrNull(Ljava/lang/String;)Lcom/google/android/gm/provider/MailCore$Label;

    move-result-object v5

    .line 2778
    if-eqz v5, :cond_0

    .line 2779
    iget-wide v0, v5, Lcom/google/android/gm/provider/MailCore$Label;->id:J

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    invoke-interface {v8, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 2780
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    sget-object v7, Lcom/google/android/gm/provider/Operations$RecordHistory;->TRUE:Lcom/google/android/gm/provider/Operations$RecordHistory;

    move-wide v1, p1

    move-wide v3, p3

    move v6, p6

    invoke-virtual/range {v0 .. v7}, Lcom/google/android/gm/provider/MailCore;->setLabelOnConversation(JJLcom/google/android/gm/provider/MailCore$Label;ZLcom/google/android/gm/provider/Operations$RecordHistory;)V

    .line 2782
    sget-object v0, Lcom/google/android/gm/provider/MailSync$SyncRationale;->LOCAL_CHANGE:Lcom/google/android/gm/provider/MailSync$SyncRationale;

    invoke-direct {p0, p1, p2, v0}, Lcom/google/android/gm/provider/MailEngine;->onConversationChanged(JLcom/google/android/gm/provider/MailSync$SyncRationale;)V

    .line 2783
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/TransactionHelper;->setTransactionSuccessful()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 2784
    const/4 v0, 0x1

    .line 2787
    :cond_0
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    .line 2788
    if-eqz v0, :cond_1

    .line 2789
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/google/android/gm/provider/MailEngine;->notifyDatasetChanged(Z)V

    .line 2790
    invoke-direct {p0, v8}, Lcom/google/android/gm/provider/MailEngine;->broadcastLabelNotifications(Ljava/util/Set;)V

    .line 2796
    :cond_1
    if-nez p6, :cond_2

    const-string v0, "^u"

    invoke-virtual {v0, p5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 2797
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/google/android/gm/provider/MailEngine;->sendNotificationIntents(Z)V

    .line 2799
    :cond_2
    return-void

    .line 2787
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    .line 2790
    throw v0
.end method

.method public setLabelOnConversationsBulk([Landroid/content/ContentValues;Z)V
    .locals 17

    .prologue
    .line 2804
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v12

    .line 2805
    move-object/from16 v0, p1

    array-length v3, v0

    const/4 v1, 0x0

    move v2, v1

    :goto_0
    if-ge v2, v3, :cond_2

    aget-object v4, p1, v2

    .line 2806
    const-string v1, "_id"

    invoke-virtual {v4, v1}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 2807
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "values must have \'_id\'"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 2810
    :cond_0
    const-string v1, "_id"

    invoke-virtual {v4, v1}, Landroid/content/ContentValues;->getAsLong(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v5

    .line 2812
    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-interface {v12, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 2813
    if-nez v1, :cond_1

    .line 2814
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v1

    .line 2815
    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-interface {v12, v5, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2817
    :cond_1
    invoke-interface {v1, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 2805
    add-int/lit8 v1, v2, 0x1

    move v2, v1

    goto :goto_0

    .line 2820
    :cond_2
    const/4 v11, 0x0

    .line 2821
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v13

    .line 2822
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailEngine;->mTransactionListener:Lcom/google/android/gm/provider/GmailTransactionListener;

    invoke-virtual {v1, v2}, Lcom/google/android/gm/provider/TransactionHelper;->beginTransactionWithListenerNonExclusive(Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;)V

    .line 2823
    if-eqz p2, :cond_3

    .line 2824
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/TransactionHelper;->suppressUiNotifications()V

    .line 2827
    :cond_3
    :try_start_0
    invoke-interface {v12}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v14

    :cond_4
    :goto_1
    invoke-interface {v14}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_b

    invoke-interface {v14}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    move-object v0, v1

    check-cast v0, Ljava/lang/Long;

    move-object v9, v0

    .line 2828
    invoke-interface {v12, v9}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 2829
    const/4 v2, 0x0

    .line 2831
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v15

    :goto_2
    invoke-interface {v15}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_a

    invoke-interface {v15}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/content/ContentValues;

    .line 2832
    const-string v3, "canonicalName"

    invoke-virtual {v1, v3}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_5

    .line 2833
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "values must have \'canonicalName\'"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 2880
    :catchall_0
    move-exception v1

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v2}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    .line 2883
    const/4 v2, 0x1

    move-object/from16 v0, p0

    invoke-direct {v0, v2}, Lcom/google/android/gm/provider/MailEngine;->notifyDatasetChanged(Z)V

    .line 2884
    move-object/from16 v0, p0

    invoke-direct {v0, v13}, Lcom/google/android/gm/provider/MailEngine;->broadcastLabelNotifications(Ljava/util/Set;)V

    throw v1

    .line 2836
    :cond_5
    :try_start_1
    const-string v3, "canonicalName"

    invoke-virtual {v1, v3}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    .line 2838
    const-string v3, "maxMessageId"

    invoke-virtual {v1, v3}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_6

    .line 2839
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "values must have \'maxMessageId\'"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 2842
    :cond_6
    const-string v3, "maxMessageId"

    invoke-virtual {v1, v3}, Landroid/content/ContentValues;->getAsLong(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    .line 2845
    const-string v3, "add_label_action"

    invoke-virtual {v1, v3}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_7

    .line 2846
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "values must have \'add_label_action\'"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 2849
    :cond_7
    const-string v3, "add_label_action"

    invoke-virtual {v1, v3}, Landroid/content/ContentValues;->getAsBoolean(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v7

    .line 2851
    const-string v1, "Gmail"

    const-string v3, "MailProvider.insert(): adding or removing label %s to conversation %d, maxMessageId %d operation (is add) = %b"

    const/4 v6, 0x4

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v8, 0x0

    aput-object v16, v6, v8

    const/4 v8, 0x1

    aput-object v9, v6, v8

    const/4 v8, 0x2

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v10

    aput-object v10, v6, v8

    const/4 v8, 0x3

    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v10

    aput-object v10, v6, v8

    invoke-static {v1, v3, v6}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 2854
    invoke-static/range {v16 .. v16}, Lcom/google/android/gm/provider/Gmail;->isLabelProviderSettable(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_8

    .line 2855
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "label is not provider-settable: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move-object/from16 v0, v16

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 2859
    :cond_8
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    move-object/from16 v0, v16

    invoke-virtual {v1, v0}, Lcom/google/android/gm/provider/MailCore;->getLabelOrNull(Ljava/lang/String;)Lcom/google/android/gm/provider/MailCore$Label;

    move-result-object v6

    .line 2860
    if-eqz v6, :cond_9

    .line 2861
    iget-wide v1, v6, Lcom/google/android/gm/provider/MailCore$Label;->id:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-interface {v13, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 2862
    const/4 v10, 0x1

    .line 2864
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    invoke-virtual {v9}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    sget-object v8, Lcom/google/android/gm/provider/Operations$RecordHistory;->TRUE:Lcom/google/android/gm/provider/Operations$RecordHistory;

    invoke-virtual/range {v1 .. v8}, Lcom/google/android/gm/provider/MailCore;->setLabelOnConversation(JJLcom/google/android/gm/provider/MailCore$Label;ZLcom/google/android/gm/provider/Operations$RecordHistory;)V

    .line 2866
    if-nez v7, :cond_d

    const-string v1, "^u"

    move-object/from16 v0, v16

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_d

    .line 2867
    const/4 v1, 0x1

    move v2, v1

    move v1, v10

    :goto_3
    move v11, v2

    move v2, v1

    .line 2873
    goto/16 :goto_2

    .line 2870
    :cond_9
    const-string v1, "Gmail"

    const-string v3, "Missing label in setLabelOnConversationsBulk: %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v16, v4, v5

    invoke-static {v1, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    move v1, v2

    move v2, v11

    goto :goto_3

    .line 2874
    :cond_a
    if-eqz v2, :cond_4

    .line 2875
    invoke-virtual {v9}, Ljava/lang/Long;->longValue()J

    move-result-wide v1

    sget-object v3, Lcom/google/android/gm/provider/MailSync$SyncRationale;->LOCAL_CHANGE:Lcom/google/android/gm/provider/MailSync$SyncRationale;

    move-object/from16 v0, p0

    invoke-direct {v0, v1, v2, v3}, Lcom/google/android/gm/provider/MailEngine;->onConversationChanged(JLcom/google/android/gm/provider/MailSync$SyncRationale;)V

    goto/16 :goto_1

    .line 2878
    :cond_b
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/TransactionHelper;->setTransactionSuccessful()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 2880
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    .line 2883
    const/4 v1, 0x1

    move-object/from16 v0, p0

    invoke-direct {v0, v1}, Lcom/google/android/gm/provider/MailEngine;->notifyDatasetChanged(Z)V

    .line 2884
    move-object/from16 v0, p0

    invoke-direct {v0, v13}, Lcom/google/android/gm/provider/MailEngine;->broadcastLabelNotifications(Ljava/util/Set;)V

    .line 2889
    if-eqz v11, :cond_c

    .line 2890
    const/4 v1, 0x0

    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Lcom/google/android/gm/provider/MailEngine;->sendNotificationIntents(Z)V

    .line 2892
    :cond_c
    return-void

    :cond_d
    move v1, v10

    move v2, v11

    goto :goto_3
.end method

.method public setLabelOnLocalMessage(JLjava/lang/String;Z)V
    .locals 14
    .param p1, "localMessageId"    # J
    .param p3, "canonicalLabel"    # Ljava/lang/String;
    .param p4, "on"    # Z

    .prologue
    .line 2628
    invoke-virtual/range {p0 .. p2}, Lcom/google/android/gm/provider/MailEngine;->messageIdPairForLocalMessageId(J)Lcom/google/android/gm/provider/MailEngine$MessageIdPair;

    move-result-object v13

    .line 2629
    .local v13, "pair":Lcom/google/android/gm/provider/MailEngine$MessageIdPair;
    if-nez v13, :cond_0

    .line 2630
    const-string v1, "Gmail"

    const-string v5, "setLabelOnLocalMessage returning because message pair does not exist: %d"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    invoke-static/range {p1 .. p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-static {v1, v5, v6}, Lcom/google/android/gm/provider/LogUtils;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 2657
    :goto_0
    return-void

    .line 2635
    :cond_0
    iget-wide v2, v13, Lcom/google/android/gm/provider/MailEngine$MessageIdPair;->messageId:J

    .line 2636
    .local v2, "messageId":J
    iget-wide v11, v13, Lcom/google/android/gm/provider/MailEngine$MessageIdPair;->conversationId:J

    .line 2638
    .local v11, "conversationId":J
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    move-object/from16 v0, p3

    invoke-virtual {v1, v0}, Lcom/google/android/gm/provider/MailCore;->getLabelOrNull(Ljava/lang/String;)Lcom/google/android/gm/provider/MailCore$Label;

    move-result-object v4

    .line 2639
    .local v4, "label":Lcom/google/android/gm/provider/MailCore$Label;
    if-nez v4, :cond_1

    .line 2640
    const-string v1, "Gmail"

    const-string v5, "setLabelOnLocalMessage returning because label does not exist: %s"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object p3, v6, v7

    invoke-static {v1, v5, v6}, Lcom/google/android/gm/provider/LogUtils;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0

    .line 2644
    :cond_1
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    iget-object v5, p0, Lcom/google/android/gm/provider/MailEngine;->mTransactionListener:Lcom/google/android/gm/provider/GmailTransactionListener;

    invoke-virtual {v1, v5}, Lcom/google/android/gm/provider/TransactionHelper;->beginTransactionWithListenerNonExclusive(Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;)V

    .line 2646
    :try_start_0
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    sget-object v6, Lcom/google/android/gm/provider/Operations$RecordHistory;->TRUE:Lcom/google/android/gm/provider/Operations$RecordHistory;

    move/from16 v5, p4

    invoke-virtual/range {v1 .. v6}, Lcom/google/android/gm/provider/MailCore;->setLabelOnMessage(JLcom/google/android/gm/provider/MailCore$Label;ZLcom/google/android/gm/provider/Operations$RecordHistory;)V

    .line 2648
    invoke-direct/range {p0 .. p2}, Lcom/google/android/gm/provider/MailEngine;->getSyncedForLocalMessageId(J)Z

    move-result v9

    .line 2650
    .local v9, "messageSynced":Z
    sget-object v8, Lcom/google/android/gm/provider/MailSync$SyncRationale;->LOCAL_CHANGE:Lcom/google/android/gm/provider/MailSync$SyncRationale;

    const/4 v10, 0x1

    move-object v5, p0

    move-wide v6, v11

    invoke-direct/range {v5 .. v10}, Lcom/google/android/gm/provider/MailEngine;->onConversationChanged(JLcom/google/android/gm/provider/MailSync$SyncRationale;ZZ)V

    .line 2652
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/TransactionHelper;->setTransactionSuccessful()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 2654
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    .line 2655
    const/4 v1, 0x1

    invoke-direct {p0, v1}, Lcom/google/android/gm/provider/MailEngine;->notifyDatasetChanged(Z)V

    goto :goto_0

    .line 2654
    .end local v9    # "messageSynced":Z
    :catchall_0
    move-exception v1

    iget-object v5, p0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v5}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    .line 2655
    const/4 v5, 0x1

    invoke-direct {p0, v5}, Lcom/google/android/gm/provider/MailEngine;->notifyDatasetChanged(Z)V

    throw v1
.end method

.method public setLabelOnLocalMessageBulk([Landroid/content/ContentValues;Z)V
    .locals 25

    .prologue
    .line 2662
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v19

    .line 2663
    move-object/from16 v0, p1

    array-length v5, v0

    const/4 v3, 0x0

    move v4, v3

    :goto_0
    if-ge v4, v5, :cond_2

    aget-object v6, p1, v4

    .line 2664
    const-string v3, "conversation"

    invoke-virtual {v6, v3}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 2665
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string v4, "values must have \'conversation\'"

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 2668
    :cond_0
    const-string v3, "conversation"

    invoke-virtual {v6, v3}, Landroid/content/ContentValues;->getAsLong(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Long;->longValue()J

    move-result-wide v7

    .line 2670
    invoke-static {v7, v8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    move-object/from16 v0, v19

    invoke-interface {v0, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/List;

    .line 2671
    if-nez v3, :cond_1

    .line 2672
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v3

    .line 2673
    invoke-static {v7, v8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    move-object/from16 v0, v19

    invoke-interface {v0, v7, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2675
    :cond_1
    invoke-interface {v3, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 2663
    add-int/lit8 v3, v4, 0x1

    move v4, v3

    goto :goto_0

    .line 2678
    :cond_2
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v20

    .line 2679
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/google/android/gm/provider/MailEngine;->mTransactionListener:Lcom/google/android/gm/provider/GmailTransactionListener;

    invoke-virtual {v3, v4}, Lcom/google/android/gm/provider/TransactionHelper;->beginTransactionWithListenerNonExclusive(Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;)V

    .line 2680
    if-eqz p2, :cond_3

    .line 2681
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v3}, Lcom/google/android/gm/provider/TransactionHelper;->suppressUiNotifications()V

    .line 2684
    :cond_3
    :try_start_0
    invoke-interface/range {v19 .. v19}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v21

    :cond_4
    :goto_1
    invoke-interface/range {v21 .. v21}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_d

    invoke-interface/range {v21 .. v21}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    move-object v0, v3

    check-cast v0, Ljava/lang/Long;

    move-object/from16 v16, v0

    .line 2685
    move-object/from16 v0, v19

    move-object/from16 v1, v16

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/List;

    .line 2686
    const/4 v8, 0x0

    .line 2687
    const/16 v17, 0x0

    .line 2689
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v22

    :goto_2
    invoke-interface/range {v22 .. v22}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_c

    invoke-interface/range {v22 .. v22}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/content/ContentValues;

    .line 2690
    const-string v4, "canonicalName"

    invoke-virtual {v3, v4}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_5

    .line 2691
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string v4, "values must have \'canonicalName\'"

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 2763
    :catchall_0
    move-exception v3

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v4}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    .line 2766
    const/4 v4, 0x1

    move-object/from16 v0, p0

    invoke-direct {v0, v4}, Lcom/google/android/gm/provider/MailEngine;->notifyDatasetChanged(Z)V

    .line 2767
    move-object/from16 v0, p0

    move-object/from16 v1, v20

    invoke-direct {v0, v1}, Lcom/google/android/gm/provider/MailEngine;->broadcastLabelNotifications(Ljava/util/Set;)V

    throw v3

    .line 2694
    :cond_5
    :try_start_1
    const-string v4, "canonicalName"

    invoke-virtual {v3, v4}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    .line 2696
    const-string v4, "_id"

    invoke-virtual {v3, v4}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_6

    .line 2697
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string v4, "values must have \'_id\'"

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 2700
    :cond_6
    const-string v4, "_id"

    invoke-virtual {v3, v4}, Landroid/content/ContentValues;->getAsLong(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Long;->longValue()J

    move-result-wide v23

    .line 2702
    const-string v4, "messageId"

    invoke-virtual {v3, v4}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_7

    .line 2703
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string v4, "values must have \'messageId\'"

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 2706
    :cond_7
    const-string v4, "messageId"

    invoke-virtual {v3, v4}, Landroid/content/ContentValues;->getAsLong(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    .line 2708
    move-object/from16 v0, p0

    move-wide/from16 v1, v23

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gm/provider/MailEngine;->messageIdPairForLocalMessageId(J)Lcom/google/android/gm/provider/MailEngine$MessageIdPair;

    move-result-object v7

    .line 2709
    const/4 v6, 0x1

    .line 2710
    if-eqz v7, :cond_8

    iget-wide v11, v7, Lcom/google/android/gm/provider/MailEngine$MessageIdPair;->conversationId:J

    invoke-virtual/range {v16 .. v16}, Ljava/lang/Long;->longValue()J

    move-result-wide v13

    cmp-long v9, v11, v13

    if-nez v9, :cond_8

    iget-wide v11, v7, Lcom/google/android/gm/provider/MailEngine$MessageIdPair;->messageId:J

    cmp-long v7, v11, v4

    if-eqz v7, :cond_10

    .line 2714
    :cond_8
    const/4 v6, 0x0

    move v9, v6

    .line 2717
    :goto_3
    const-string v6, "add_label_action"

    invoke-virtual {v3, v6}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_9

    .line 2718
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string v4, "values must have \'add_label_action\'"

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 2721
    :cond_9
    const-string v6, "add_label_action"

    invoke-virtual {v3, v6}, Landroid/content/ContentValues;->getAsBoolean(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v7

    .line 2723
    const-string v3, "Gmail"

    const-string v6, "MailProvider.insert(): adding or removing label %s to local message %d operation (is add) = %b"

    const/4 v11, 0x3

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v12, 0x0

    aput-object v10, v11, v12

    const/4 v12, 0x1

    invoke-static/range {v23 .. v24}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v13

    aput-object v13, v11, v12

    const/4 v12, 0x2

    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v13

    aput-object v13, v11, v12

    invoke-static {v3, v6, v11}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 2726
    invoke-static {v10}, Lcom/google/android/gm/provider/Gmail;->isLabelUserSettable(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_a

    .line 2727
    new-instance v3, Ljava/lang/IllegalArgumentException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "label is not user-settable: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 2731
    :cond_a
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    invoke-virtual {v3, v10}, Lcom/google/android/gm/provider/MailCore;->getLabelOrNull(Ljava/lang/String;)Lcom/google/android/gm/provider/MailCore$Label;

    move-result-object v6

    .line 2732
    if-eqz v6, :cond_f

    .line 2733
    iget-wide v10, v6, Lcom/google/android/gm/provider/MailCore$Label;->id:J

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    move-object/from16 v0, v20

    invoke-interface {v0, v3}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 2734
    const/16 v18, 0x1

    .line 2735
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    sget-object v8, Lcom/google/android/gm/provider/Operations$RecordHistory;->TRUE:Lcom/google/android/gm/provider/Operations$RecordHistory;

    invoke-virtual/range {v3 .. v8}, Lcom/google/android/gm/provider/MailCore;->setLabelOnMessage(JLcom/google/android/gm/provider/MailCore$Label;ZLcom/google/android/gm/provider/Operations$RecordHistory;)V

    .line 2737
    if-nez v9, :cond_b

    .line 2742
    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    invoke-virtual/range {v16 .. v16}, Ljava/lang/Long;->longValue()J

    move-result-wide v9

    sget-object v15, Lcom/google/android/gm/provider/Operations$RecordHistory;->FALSE:Lcom/google/android/gm/provider/Operations$RecordHistory;

    move-wide v11, v4

    move-object v13, v6

    move v14, v7

    invoke-virtual/range {v8 .. v15}, Lcom/google/android/gm/provider/MailCore;->setLabelOnConversation(JJLcom/google/android/gm/provider/MailCore$Label;ZLcom/google/android/gm/provider/Operations$RecordHistory;)V

    .line 2746
    :cond_b
    if-nez v17, :cond_e

    .line 2751
    move-object/from16 v0, p0

    move-wide/from16 v1, v23

    invoke-direct {v0, v1, v2}, Lcom/google/android/gm/provider/MailEngine;->getSyncedForLocalMessageId(J)Z

    move-result v3

    move/from16 v4, v18

    :goto_4
    move/from16 v17, v3

    move v8, v4

    .line 2754
    goto/16 :goto_2

    .line 2756
    :cond_c
    if-eqz v8, :cond_4

    .line 2757
    invoke-virtual/range {v16 .. v16}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    sget-object v6, Lcom/google/android/gm/provider/MailSync$SyncRationale;->LOCAL_CHANGE:Lcom/google/android/gm/provider/MailSync$SyncRationale;

    const/4 v8, 0x1

    move-object/from16 v3, p0

    move/from16 v7, v17

    invoke-direct/range {v3 .. v8}, Lcom/google/android/gm/provider/MailEngine;->onConversationChanged(JLcom/google/android/gm/provider/MailSync$SyncRationale;ZZ)V

    goto/16 :goto_1

    .line 2761
    :cond_d
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v3}, Lcom/google/android/gm/provider/TransactionHelper;->setTransactionSuccessful()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 2763
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v3}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    .line 2766
    const/4 v3, 0x1

    move-object/from16 v0, p0

    invoke-direct {v0, v3}, Lcom/google/android/gm/provider/MailEngine;->notifyDatasetChanged(Z)V

    .line 2767
    move-object/from16 v0, p0

    move-object/from16 v1, v20

    invoke-direct {v0, v1}, Lcom/google/android/gm/provider/MailEngine;->broadcastLabelNotifications(Ljava/util/Set;)V

    .line 2769
    return-void

    :cond_e
    move/from16 v3, v17

    move/from16 v4, v18

    goto :goto_4

    :cond_f
    move/from16 v3, v17

    move v4, v8

    goto :goto_4

    :cond_10
    move v9, v6

    goto/16 :goto_3
.end method

.method public setPublicSettings(Landroid/content/ContentValues;)Z
    .locals 6

    .prologue
    const/4 v1, 0x0

    .line 3536
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine;->getMailSync()Lcom/google/android/gm/provider/MailSync;

    move-result-object v4

    .line 3538
    const-string v0, "labelsIncluded"

    invoke-virtual {p1, v0}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    const-string v0, "labelsIncluded"

    invoke-virtual {p1, v0}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 3541
    :goto_0
    const-string v2, "labelsPartial"

    invoke-virtual {p1, v2}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    const-string v2, "labelsPartial"

    invoke-virtual {p1, v2}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 3544
    :goto_1
    const-string v3, "conversationAgeDays"

    invoke-virtual {p1, v3}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_3

    const-string v3, "conversationAgeDays"

    invoke-virtual {p1, v3}, Landroid/content/ContentValues;->getAsLong(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v3

    .line 3547
    :goto_2
    const-string v5, "maxAttachmentSize"

    invoke-virtual {p1, v5}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    const-string v1, "maxAttachmentSize"

    invoke-virtual {p1, v1}, Landroid/content/ContentValues;->getAsLong(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v1

    .line 3550
    :cond_0
    invoke-virtual {v4, v0, v2, v3, v1}, Lcom/google/android/gm/provider/MailSync;->setConfig(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Z

    move-result v0

    return v0

    :cond_1
    move-object v0, v1

    .line 3538
    goto :goto_0

    :cond_2
    move-object v2, v1

    .line 3541
    goto :goto_1

    :cond_3
    move-object v3, v1

    .line 3544
    goto :goto_2
.end method

.method setTestTransactionListener(Landroid/database/sqlite/SQLiteTransactionListener;)V
    .locals 1
    .param p1, "transactionListener"    # Landroid/database/sqlite/SQLiteTransactionListener;

    .prologue
    .line 6591
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mTransactionListener:Lcom/google/android/gm/provider/GmailTransactionListener;

    invoke-virtual {v0, p1}, Lcom/google/android/gm/provider/GmailTransactionListener;->setTestTransactionListener(Landroid/database/sqlite/SQLiteTransactionListener;)V

    .line 6592
    return-void
.end method

.method setTransactionSuccessful()V
    .locals 1

    .prologue
    .line 6724
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/TransactionHelper;->setTransactionSuccessful()V

    .line 6725
    return-void
.end method

.method setValidateSyncSets(Z)V
    .locals 0
    .param p1, "validate"    # Z

    .prologue
    .line 1434
    iput-boolean p1, p0, Lcom/google/android/gm/provider/MailEngine;->mValidateSyncSets:Z

    .line 1435
    return-void
.end method

.method sync(Landroid/content/SyncResult;Landroid/os/Bundle;)V
    .locals 11

    .prologue
    .line 1696
    new-instance v7, Landroid/util/TimingLogger;

    const-string v0, "Gmail-profiling"

    const-string v1, "sync"

    invoke-direct {v7, v0, v1}, Landroid/util/TimingLogger;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 1697
    const-string v0, "start"

    invoke-virtual {v7, v0}, Landroid/util/TimingLogger;->addSplit(Ljava/lang/String;)V

    .line 1698
    new-instance v1, Lcom/google/android/gm/provider/MailEngine$MailEngineSyncObserver;

    invoke-direct {v1}, Lcom/google/android/gm/provider/MailEngine$MailEngineSyncObserver;-><init>()V

    .line 1699
    const/4 v6, 0x0

    .line 1700
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailSync;->clearStats()V

    .line 1702
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    if-nez v0, :cond_0

    .line 1786
    :goto_0
    return-void

    .line 1708
    :cond_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/android/gm/provider/MailEngine;->mIsSyncCancelled:Z

    .line 1711
    const/4 v0, 0x1

    const/4 v2, 0x1

    :try_start_0
    invoke-direct {p0, v0, v2}, Lcom/google/android/gm/provider/MailEngine;->changeTaskState(IZ)V

    .line 1712
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/gm/provider/MailEngine;->mIsSyncInProgress:Z

    .line 1714
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    const-string v2, "gmail-ls"

    invoke-static {v0, v2}, Landroid/content/ContentResolver;->getIsSyncable(Landroid/accounts/Account;Ljava/lang/String;)I

    move-result v0

    .line 1715
    if-gez v0, :cond_1

    .line 1716
    invoke-direct {p0}, Lcom/google/android/gm/provider/MailEngine;->getIsSyncable()Z

    move-result v0

    if-eqz v0, :cond_2

    const/4 v0, 0x1

    .line 1717
    :goto_1
    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    const-string v3, "gmail-ls"

    invoke-static {v2, v3, v0}, Landroid/content/ContentResolver;->setIsSyncable(Landroid/accounts/Account;Ljava/lang/String;I)V

    .line 1721
    :cond_1
    const-string v2, "initialize"

    const/4 v3, 0x0

    invoke-virtual {p2, v2, v3}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z
    :try_end_0
    .catch Lcom/google/android/gm/provider/MailEngine$AuthenticationException; {:try_start_0 .. :try_end_0} :catch_7
    .catch Lcom/google/android/gm/provider/MailSync$ResponseParseException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Landroid/accounts/OperationCanceledException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_3
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result v2

    if-eqz v2, :cond_4

    .line 1767
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/google/android/gm/provider/MailEngine;->sendNotificationIntents(Z)V

    .line 1769
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine;->enqueueAttachmentDownloadTask()V

    .line 1770
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/gm/provider/MailEngine;->mUserRefreshCompleted:Z

    .line 1771
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/android/gm/provider/MailEngine;->mIsSyncInProgress:Z

    .line 1775
    invoke-virtual {v1}, Lcom/google/android/gm/provider/MailEngine$MailEngineSyncObserver;->changesReceived()Z

    move-result v0

    if-nez v0, :cond_3

    .line 1781
    :goto_2
    const-string v0, "stop"

    invoke-virtual {v7, v0}, Landroid/util/TimingLogger;->addSplit(Ljava/lang/String;)V

    .line 1782
    invoke-virtual {v7}, Landroid/util/TimingLogger;->dumpToLog()V

    .line 1784
    const/4 v0, 0x1

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/google/android/gm/provider/MailEngine;->changeTaskState(IZ)V

    goto :goto_0

    .line 1716
    :cond_2
    const/4 v0, 0x0

    goto :goto_1

    .line 1776
    :cond_3
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/google/android/gm/provider/MailEngine;->notifyDatasetChanged(Z)V

    .line 1779
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    iget-object v1, v1, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/google/android/gm/provider/UiProvider;->broadcastAccountChangeNotification(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_2

    .line 1725
    :cond_4
    :try_start_1
    new-instance v3, Lcom/google/android/gm/provider/MailEngine$SyncInfo;

    invoke-direct {v3}, Lcom/google/android/gm/provider/MailEngine$SyncInfo;-><init>()V

    .line 1726
    const/4 v2, 0x1

    iput-boolean v2, v3, Lcom/google/android/gm/provider/MailEngine$SyncInfo;->backgroundSync:Z

    .line 1728
    const-string v2, "sendwithoutsync"

    const/4 v4, 0x0

    invoke-virtual {p2, v2, v4}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 1729
    const/4 v2, 0x0

    iput-boolean v2, v3, Lcom/google/android/gm/provider/MailEngine$SyncInfo;->normalSync:Z

    .line 1730
    const-string v2, "sendwithoutsyncMessageId"

    invoke-virtual {p2, v2}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v4

    iput-wide v4, v3, Lcom/google/android/gm/provider/MailEngine$SyncInfo;->messageId:J

    .line 1731
    const-string v2, "sendwithoutsyncConversationId"

    invoke-virtual {p2, v2}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v4

    iput-wide v4, v3, Lcom/google/android/gm/provider/MailEngine$SyncInfo;->conversationId:J

    .line 1732
    const-string v2, "Gmail"

    const-string v4, "Reading send without sync message id, conversation id, %d %d"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v8, 0x0

    iget-wide v9, v3, Lcom/google/android/gm/provider/MailEngine$SyncInfo;->messageId:J

    invoke-static {v9, v10}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v9

    aput-object v9, v5, v8

    const/4 v8, 0x1

    iget-wide v9, v3, Lcom/google/android/gm/provider/MailEngine$SyncInfo;->conversationId:J

    invoke-static {v9, v10}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v9

    aput-object v9, v5, v8

    invoke-static {v2, v4, v5}, Lcom/google/android/gm/provider/LogUtils;->v(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    :try_end_1
    .catch Lcom/google/android/gm/provider/MailEngine$AuthenticationException; {:try_start_1 .. :try_end_1} :catch_7
    .catch Lcom/google/android/gm/provider/MailSync$ResponseParseException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Landroid/accounts/OperationCanceledException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_3
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 1737
    :cond_5
    if-gtz v0, :cond_7

    .line 1767
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/google/android/gm/provider/MailEngine;->sendNotificationIntents(Z)V

    .line 1769
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine;->enqueueAttachmentDownloadTask()V

    .line 1770
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/gm/provider/MailEngine;->mUserRefreshCompleted:Z

    .line 1771
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/android/gm/provider/MailEngine;->mIsSyncInProgress:Z

    .line 1775
    invoke-virtual {v1}, Lcom/google/android/gm/provider/MailEngine$MailEngineSyncObserver;->changesReceived()Z

    move-result v0

    if-nez v0, :cond_6

    .line 1781
    :goto_3
    const-string v0, "stop"

    invoke-virtual {v7, v0}, Landroid/util/TimingLogger;->addSplit(Ljava/lang/String;)V

    .line 1782
    invoke-virtual {v7}, Landroid/util/TimingLogger;->dumpToLog()V

    .line 1784
    const/4 v0, 0x1

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/google/android/gm/provider/MailEngine;->changeTaskState(IZ)V

    goto/16 :goto_0

    .line 1776
    :cond_6
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/google/android/gm/provider/MailEngine;->notifyDatasetChanged(Z)V

    .line 1779
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    iget-object v1, v1, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/google/android/gm/provider/UiProvider;->broadcastAccountChangeNotification(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_3

    .line 1741
    :cond_7
    :try_start_2
    iget-object v8, p0, Lcom/google/android/gm/provider/MailEngine;->mSyncLock:Ljava/lang/Object;

    monitor-enter v8
    :try_end_2
    .catch Lcom/google/android/gm/provider/MailEngine$AuthenticationException; {:try_start_2 .. :try_end_2} :catch_7
    .catch Lcom/google/android/gm/provider/MailSync$ResponseParseException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Landroid/accounts/OperationCanceledException; {:try_start_2 .. :try_end_2} :catch_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_3
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 1742
    const/4 v2, 0x0

    move-object v0, p0

    move-object v4, p1

    move-object v5, p2

    :try_start_3
    invoke-direct/range {v0 .. v5}, Lcom/google/android/gm/provider/MailEngine;->runSyncLoop(Lcom/google/android/gm/provider/MailEngine$MailEngineSyncObserver;ZLcom/google/android/gm/provider/MailEngine$SyncInfo;Landroid/content/SyncResult;Landroid/os/Bundle;)Z
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    move-result v0

    if-eqz v0, :cond_14

    .line 1743
    const/4 v2, 0x1

    .line 1745
    :goto_4
    :try_start_4
    monitor-exit v8
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_3

    .line 1746
    const/4 v0, 0x0

    :try_start_5
    invoke-direct {p0, v0}, Lcom/google/android/gm/provider/MailEngine;->setLastSyncResult(I)V
    :try_end_5
    .catch Lcom/google/android/gm/provider/MailEngine$AuthenticationException; {:try_start_5 .. :try_end_5} :catch_0
    .catch Lcom/google/android/gm/provider/MailSync$ResponseParseException; {:try_start_5 .. :try_end_5} :catch_6
    .catch Landroid/accounts/OperationCanceledException; {:try_start_5 .. :try_end_5} :catch_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_4
    .catchall {:try_start_5 .. :try_end_5} :catchall_2

    .line 1767
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/google/android/gm/provider/MailEngine;->sendNotificationIntents(Z)V

    .line 1769
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine;->enqueueAttachmentDownloadTask()V

    .line 1770
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/gm/provider/MailEngine;->mUserRefreshCompleted:Z

    .line 1771
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/android/gm/provider/MailEngine;->mIsSyncInProgress:Z

    .line 1775
    invoke-virtual {v1}, Lcom/google/android/gm/provider/MailEngine$MailEngineSyncObserver;->changesReceived()Z

    move-result v0

    if-nez v0, :cond_8

    if-eqz v2, :cond_9

    .line 1776
    :cond_8
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/google/android/gm/provider/MailEngine;->notifyDatasetChanged(Z)V

    .line 1779
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    iget-object v1, v1, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/google/android/gm/provider/UiProvider;->broadcastAccountChangeNotification(Landroid/content/Context;Ljava/lang/String;)V

    .line 1781
    :cond_9
    const-string v0, "stop"

    invoke-virtual {v7, v0}, Landroid/util/TimingLogger;->addSplit(Ljava/lang/String;)V

    .line 1782
    invoke-virtual {v7}, Landroid/util/TimingLogger;->dumpToLog()V

    .line 1784
    const/4 v0, 0x1

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/google/android/gm/provider/MailEngine;->changeTaskState(IZ)V

    goto/16 :goto_0

    .line 1745
    :catchall_0
    move-exception v0

    move v2, v6

    :goto_5
    :try_start_6
    monitor-exit v8
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_3

    :try_start_7
    throw v0
    :try_end_7
    .catch Lcom/google/android/gm/provider/MailEngine$AuthenticationException; {:try_start_7 .. :try_end_7} :catch_0
    .catch Lcom/google/android/gm/provider/MailSync$ResponseParseException; {:try_start_7 .. :try_end_7} :catch_6
    .catch Landroid/accounts/OperationCanceledException; {:try_start_7 .. :try_end_7} :catch_5
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_4
    .catchall {:try_start_7 .. :try_end_7} :catchall_2

    .line 1747
    :catch_0
    move-exception v0

    move v6, v2

    .line 1748
    :goto_6
    :try_start_8
    const-string v2, "Gmail"

    const-string v3, "Auth exception"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v2, v0, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1749
    iget-object v0, p1, Landroid/content/SyncResult;->stats:Landroid/content/SyncStats;

    iget-wide v2, v0, Landroid/content/SyncStats;->numAuthExceptions:J

    const-wide/16 v4, 0x1

    add-long/2addr v2, v4

    iput-wide v2, v0, Landroid/content/SyncStats;->numAuthExceptions:J

    .line 1750
    const/4 v0, 0x2

    invoke-direct {p0, v0}, Lcom/google/android/gm/provider/MailEngine;->setLastSyncResult(I)V
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_1

    .line 1767
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/google/android/gm/provider/MailEngine;->sendNotificationIntents(Z)V

    .line 1769
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine;->enqueueAttachmentDownloadTask()V

    .line 1770
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/gm/provider/MailEngine;->mUserRefreshCompleted:Z

    .line 1771
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/android/gm/provider/MailEngine;->mIsSyncInProgress:Z

    .line 1775
    invoke-virtual {v1}, Lcom/google/android/gm/provider/MailEngine$MailEngineSyncObserver;->changesReceived()Z

    move-result v0

    if-nez v0, :cond_a

    if-eqz v6, :cond_b

    .line 1776
    :cond_a
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/google/android/gm/provider/MailEngine;->notifyDatasetChanged(Z)V

    .line 1779
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    iget-object v1, v1, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/google/android/gm/provider/UiProvider;->broadcastAccountChangeNotification(Landroid/content/Context;Ljava/lang/String;)V

    .line 1781
    :cond_b
    const-string v0, "stop"

    invoke-virtual {v7, v0}, Landroid/util/TimingLogger;->addSplit(Ljava/lang/String;)V

    .line 1782
    invoke-virtual {v7}, Landroid/util/TimingLogger;->dumpToLog()V

    .line 1784
    const/4 v0, 0x1

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/google/android/gm/provider/MailEngine;->changeTaskState(IZ)V

    goto/16 :goto_0

    .line 1751
    :catch_1
    move-exception v0

    .line 1752
    :goto_7
    :try_start_9
    const-string v2, "Gmail"

    const-string v3, "Parse exception: %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailSync$ResponseParseException;->getMessage()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v4, v5

    invoke-static {v2, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1753
    iget-object v0, p1, Landroid/content/SyncResult;->stats:Landroid/content/SyncStats;

    iget-wide v2, v0, Landroid/content/SyncStats;->numParseExceptions:J

    const-wide/16 v4, 0x1

    add-long/2addr v2, v4

    iput-wide v2, v0, Landroid/content/SyncStats;->numParseExceptions:J

    .line 1754
    const/4 v0, 0x5

    invoke-direct {p0, v0}, Lcom/google/android/gm/provider/MailEngine;->setLastSyncResult(I)V
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_1

    .line 1767
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/google/android/gm/provider/MailEngine;->sendNotificationIntents(Z)V

    .line 1769
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine;->enqueueAttachmentDownloadTask()V

    .line 1770
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/gm/provider/MailEngine;->mUserRefreshCompleted:Z

    .line 1771
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/android/gm/provider/MailEngine;->mIsSyncInProgress:Z

    .line 1775
    invoke-virtual {v1}, Lcom/google/android/gm/provider/MailEngine$MailEngineSyncObserver;->changesReceived()Z

    move-result v0

    if-nez v0, :cond_c

    if-eqz v6, :cond_d

    .line 1776
    :cond_c
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/google/android/gm/provider/MailEngine;->notifyDatasetChanged(Z)V

    .line 1779
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    iget-object v1, v1, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/google/android/gm/provider/UiProvider;->broadcastAccountChangeNotification(Landroid/content/Context;Ljava/lang/String;)V

    .line 1781
    :cond_d
    const-string v0, "stop"

    invoke-virtual {v7, v0}, Landroid/util/TimingLogger;->addSplit(Ljava/lang/String;)V

    .line 1782
    invoke-virtual {v7}, Landroid/util/TimingLogger;->dumpToLog()V

    .line 1784
    const/4 v0, 0x1

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/google/android/gm/provider/MailEngine;->changeTaskState(IZ)V

    goto/16 :goto_0

    .line 1755
    :catch_2
    move-exception v0

    .line 1756
    :goto_8
    :try_start_a
    const-string v2, "Gmail"

    const-string v3, "Canceled: %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {v0}, Landroid/accounts/OperationCanceledException;->getMessage()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v4, v5

    invoke-static {v2, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1757
    const/4 v0, 0x5

    invoke-direct {p0, v0}, Lcom/google/android/gm/provider/MailEngine;->setLastSyncResult(I)V
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_1

    .line 1767
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/google/android/gm/provider/MailEngine;->sendNotificationIntents(Z)V

    .line 1769
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine;->enqueueAttachmentDownloadTask()V

    .line 1770
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/gm/provider/MailEngine;->mUserRefreshCompleted:Z

    .line 1771
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/android/gm/provider/MailEngine;->mIsSyncInProgress:Z

    .line 1775
    invoke-virtual {v1}, Lcom/google/android/gm/provider/MailEngine$MailEngineSyncObserver;->changesReceived()Z

    move-result v0

    if-nez v0, :cond_e

    if-eqz v6, :cond_f

    .line 1776
    :cond_e
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/google/android/gm/provider/MailEngine;->notifyDatasetChanged(Z)V

    .line 1779
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    iget-object v1, v1, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/google/android/gm/provider/UiProvider;->broadcastAccountChangeNotification(Landroid/content/Context;Ljava/lang/String;)V

    .line 1781
    :cond_f
    const-string v0, "stop"

    invoke-virtual {v7, v0}, Landroid/util/TimingLogger;->addSplit(Ljava/lang/String;)V

    .line 1782
    invoke-virtual {v7}, Landroid/util/TimingLogger;->dumpToLog()V

    .line 1784
    const/4 v0, 0x1

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/google/android/gm/provider/MailEngine;->changeTaskState(IZ)V

    goto/16 :goto_0

    .line 1758
    :catch_3
    move-exception v0

    .line 1759
    :goto_9
    :try_start_b
    const-string v2, "Gmail"

    const-string v3, "IOException: %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {v0}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v4, v5

    invoke-static {v2, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1760
    const-string v2, "Gmail"

    const-string v3, "Detail: "

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v2, v0, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1761
    iget-object v0, p1, Landroid/content/SyncResult;->stats:Landroid/content/SyncStats;

    iget-wide v2, v0, Landroid/content/SyncStats;->numIoExceptions:J

    const-wide/16 v4, 0x1

    add-long/2addr v2, v4

    iput-wide v2, v0, Landroid/content/SyncStats;->numIoExceptions:J

    .line 1762
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/google/android/gm/provider/MailEngine;->setLastSyncResult(I)V
    :try_end_b
    .catchall {:try_start_b .. :try_end_b} :catchall_1

    .line 1767
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/google/android/gm/provider/MailEngine;->sendNotificationIntents(Z)V

    .line 1769
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine;->enqueueAttachmentDownloadTask()V

    .line 1770
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/gm/provider/MailEngine;->mUserRefreshCompleted:Z

    .line 1771
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/android/gm/provider/MailEngine;->mIsSyncInProgress:Z

    .line 1775
    invoke-virtual {v1}, Lcom/google/android/gm/provider/MailEngine$MailEngineSyncObserver;->changesReceived()Z

    move-result v0

    if-nez v0, :cond_10

    if-eqz v6, :cond_11

    .line 1776
    :cond_10
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/google/android/gm/provider/MailEngine;->notifyDatasetChanged(Z)V

    .line 1779
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    iget-object v1, v1, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/google/android/gm/provider/UiProvider;->broadcastAccountChangeNotification(Landroid/content/Context;Ljava/lang/String;)V

    .line 1781
    :cond_11
    const-string v0, "stop"

    invoke-virtual {v7, v0}, Landroid/util/TimingLogger;->addSplit(Ljava/lang/String;)V

    .line 1782
    invoke-virtual {v7}, Landroid/util/TimingLogger;->dumpToLog()V

    .line 1784
    const/4 v0, 0x1

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/google/android/gm/provider/MailEngine;->changeTaskState(IZ)V

    goto/16 :goto_0

    .line 1767
    :catchall_1
    move-exception v0

    :goto_a
    const/4 v2, 0x0

    invoke-virtual {p0, v2}, Lcom/google/android/gm/provider/MailEngine;->sendNotificationIntents(Z)V

    .line 1769
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine;->enqueueAttachmentDownloadTask()V

    .line 1770
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/google/android/gm/provider/MailEngine;->mUserRefreshCompleted:Z

    .line 1771
    const/4 v2, 0x0

    iput-boolean v2, p0, Lcom/google/android/gm/provider/MailEngine;->mIsSyncInProgress:Z

    .line 1775
    invoke-virtual {v1}, Lcom/google/android/gm/provider/MailEngine$MailEngineSyncObserver;->changesReceived()Z

    move-result v1

    if-nez v1, :cond_12

    if-eqz v6, :cond_13

    .line 1776
    :cond_12
    const/4 v1, 0x0

    invoke-direct {p0, v1}, Lcom/google/android/gm/provider/MailEngine;->notifyDatasetChanged(Z)V

    .line 1779
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;

    iget-object v2, v2, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-static {v1, v2}, Lcom/google/android/gm/provider/UiProvider;->broadcastAccountChangeNotification(Landroid/content/Context;Ljava/lang/String;)V

    .line 1781
    :cond_13
    const-string v1, "stop"

    invoke-virtual {v7, v1}, Landroid/util/TimingLogger;->addSplit(Ljava/lang/String;)V

    .line 1782
    invoke-virtual {v7}, Landroid/util/TimingLogger;->dumpToLog()V

    .line 1784
    const/4 v1, 0x1

    const/4 v2, 0x0

    invoke-direct {p0, v1, v2}, Lcom/google/android/gm/provider/MailEngine;->changeTaskState(IZ)V

    throw v0

    .line 1767
    :catchall_2
    move-exception v0

    move v6, v2

    goto :goto_a

    .line 1758
    :catch_4
    move-exception v0

    move v6, v2

    goto/16 :goto_9

    .line 1755
    :catch_5
    move-exception v0

    move v6, v2

    goto/16 :goto_8

    .line 1751
    :catch_6
    move-exception v0

    move v6, v2

    goto/16 :goto_7

    .line 1747
    :catch_7
    move-exception v0

    goto/16 :goto_6

    .line 1745
    :catchall_3
    move-exception v0

    goto/16 :goto_5

    :cond_14
    move v2, v6

    goto/16 :goto_4
.end method

.method public updateLabelsLastTouched(Landroid/content/ContentValues;)I
    .locals 1
    .param p1, "values"    # Landroid/content/ContentValues;

    .prologue
    .line 4122
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    invoke-virtual {v0, p1}, Lcom/google/android/gm/provider/MailCore;->updateLabelsLastTouched(Landroid/content/ContentValues;)I

    move-result v0

    return v0
.end method
