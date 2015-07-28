.class public Lcom/google/android/gm/provider/UiProvider;
.super Landroid/content/ContentProvider;
.source "UiProvider.java"

# interfaces
.implements Lcom/google/android/gm/provider/MailEngine$MailEngineResultCallback;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gm/provider/UiProvider$AccountChangedNotifier;,
        Lcom/google/android/gm/provider/UiProvider$AttachmentCursor;,
        Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;
    }
.end annotation


# static fields
.field private static final ACCOUNTS_URI:Landroid/net/Uri;

.field private static final BASE_AUTH_URI:Landroid/net/Uri;

.field private static final BASE_GVIEW_URI:Landroid/net/Uri;

.field private static final BASE_SETTINGS_URI:Landroid/net/Uri;

.field private static final CONVERSATION_QUERY_LOCAL_ONLY_SELECTION_ARGS:[Ljava/lang/String;

.field private static final GMAIL_CAPABILITIES:Ljava/lang/Integer;

.field private static final INVALID_ACCOUNT_NAMES:Lcom/google/common/collect/ImmutableSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/common/collect/ImmutableSet",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final INVARIANT_LABELS:Lcom/google/common/collect/ImmutableSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/common/collect/ImmutableSet",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final UI_PROVIDER_MESSAGE_TEXT_SIZE_VALUES:[I

.field private static final UI_PROVIDER_REQUIRED_LABELS:[Ljava/lang/String;

.field private static final UI_PROVIDER_SNAP_HEADER_MODE_VALUES:[I

.field private static sAccountNotificationDelayMs:I

.field private static final sAccountStateMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/gm/provider/uiprovider/AccountState;",
            ">;"
        }
    .end annotation
.end field

.field private static sGmailQuote:Ljava/lang/String;

.field private static sInstance:Lcom/google/android/gm/provider/UiProvider;

.field private static sSystemLabelNameMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/CharSequence;",
            ">;"
        }
    .end annotation
.end field

.field private static final sUrlMatcher:Landroid/content/UriMatcher;


# instance fields
.field private final mAccountChangeNotifiers:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/gm/provider/UiProvider$AccountChangedNotifier;",
            ">;"
        }
    .end annotation
.end field

.field private volatile mAccountsFullyInitialized:Z

.field private final mAccountsPendingInitialization:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mContentResolver:Landroid/content/ContentResolver;

.field private mGmail:Lcom/google/android/gm/provider/Gmail;

.field private mLastSequence:I

.field private mMailEnginesInitialized:Z

.field private final mPreviousOperationUndoOps:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;",
            ">;"
        }
    .end annotation
.end field

.field private mUiProviderHandler:Landroid/os/Handler;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x5

    const/4 v4, 0x3

    const/4 v2, 0x0

    const/4 v3, 0x1

    .line 94
    const v0, 0x17ffff

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/UiProvider;->GMAIL_CAPABILITIES:Ljava/lang/Integer;

    .line 116
    new-array v0, v5, [I

    fill-array-data v0, :array_0

    sput-object v0, Lcom/google/android/gm/provider/UiProvider;->UI_PROVIDER_MESSAGE_TEXT_SIZE_VALUES:[I

    .line 123
    new-array v0, v4, [I

    fill-array-data v0, :array_1

    sput-object v0, Lcom/google/android/gm/provider/UiProvider;->UI_PROVIDER_SNAP_HEADER_MODE_VALUES:[I

    .line 128
    new-array v0, v3, [Ljava/lang/String;

    const-string v1, "^^out"

    aput-object v1, v0, v2

    sput-object v0, Lcom/google/android/gm/provider/UiProvider;->UI_PROVIDER_REQUIRED_LABELS:[Ljava/lang/String;

    .line 143
    const-string v0, "content://com.android.gmail.ui/accounts"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/UiProvider;->ACCOUNTS_URI:Landroid/net/Uri;

    .line 145
    const-string v0, "setting://gmail/"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/UiProvider;->BASE_SETTINGS_URI:Landroid/net/Uri;

    .line 146
    const-string v0, "auth://gmail/"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/UiProvider;->BASE_AUTH_URI:Landroid/net/Uri;

    .line 148
    const-string v0, "gview://preview"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/UiProvider;->BASE_GVIEW_URI:Landroid/net/Uri;

    .line 152
    new-array v0, v3, [Ljava/lang/String;

    const-string v1, "SELECTION_ARGUMENT_DO_NOT_BECOME_ACTIVE_NETWORK_CURSOR"

    aput-object v1, v0, v2

    sput-object v0, Lcom/google/android/gm/provider/UiProvider;->CONVERSATION_QUERY_LOCAL_ONLY_SELECTION_ARGS:[Ljava/lang/String;

    .line 156
    const-string v0, "null"

    invoke-static {v0}, Lcom/google/common/collect/ImmutableSet;->of(Ljava/lang/Object;)Lcom/google/common/collect/ImmutableSet;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/UiProvider;->INVALID_ACCOUNT_NAMES:Lcom/google/common/collect/ImmutableSet;

    .line 190
    new-instance v0, Landroid/content/UriMatcher;

    const/4 v1, -0x1

    invoke-direct {v0, v1}, Landroid/content/UriMatcher;-><init>(I)V

    sput-object v0, Lcom/google/android/gm/provider/UiProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    .line 198
    const-string v0, "^u"

    const-string v1, "^t"

    const-string v2, "^o"

    invoke-static {v0, v1, v2}, Lcom/google/common/collect/ImmutableSet;->of(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableSet;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/UiProvider;->INVARIANT_LABELS:Lcom/google/common/collect/ImmutableSet;

    .line 202
    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "com.android.gmail.ui"

    const-string v2, "accounts"

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 205
    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "com.android.gmail.ui"

    const-string v2, "*/account"

    const/4 v3, 0x2

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 208
    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "com.android.gmail.ui"

    const-string v2, "*/labels"

    invoke-virtual {v0, v1, v2, v4}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 211
    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "com.android.gmail.ui"

    const-string v2, "*/label/*"

    const/16 v3, 0x12

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 214
    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "com.android.gmail.ui"

    const-string v2, "*/conversations/*"

    const/4 v3, 0x4

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 217
    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "com.android.gmail.ui"

    const-string v2, "*/conversationsForLabel/*"

    invoke-virtual {v0, v1, v2, v5}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 220
    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "com.android.gmail.ui"

    const-string v2, "*/conversationMessages/#"

    const/4 v3, 0x6

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 223
    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "com.android.gmail.ui"

    const-string v2, "*/messageAttachments/#/#"

    const/16 v3, 0x16

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 226
    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "com.android.gmail.ui"

    const-string v2, "*/messageAttachment/#/#/*"

    const/16 v3, 0x17

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 229
    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "com.android.gmail.ui"

    const-string v2, "*/messages"

    const/4 v3, 0x7

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 232
    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "com.android.gmail.ui"

    const-string v2, "*/sendNewMessage"

    const/16 v3, 0x8

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 234
    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "com.android.gmail.ui"

    const-string v2, "*/saveNewMessage"

    const/16 v3, 0x9

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 236
    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "com.android.gmail.ui"

    const-string v2, "*/expungeMessage"

    const/16 v3, 0x18

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 238
    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "com.android.gmail.ui"

    const-string v2, "*/message/#"

    const/16 v3, 0xa

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 240
    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "com.android.gmail.ui"

    const-string v2, "*/message/save"

    const/16 v3, 0xb

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 242
    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "com.android.gmail.ui"

    const-string v2, "*/message/send"

    const/16 v3, 0xc

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 244
    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "com.android.gmail.ui"

    const-string v2, "*/undo"

    const/16 v3, 0xf

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 246
    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "com.android.gmail.ui"

    const-string v2, "*/refresh"

    const/16 v3, 0x11

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 248
    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "com.android.gmail.ui"

    const-string v2, "*/refresh/*"

    const/16 v3, 0x10

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 250
    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "com.android.gmail.ui"

    const-string v2, "*/conversation/#"

    const/16 v3, 0xd

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 252
    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "com.android.gmail.ui"

    const-string v2, "*/conversationInlineResource/#/*"

    const/16 v3, 0xe

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 254
    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "com.android.gmail.ui"

    const-string v2, "*/search"

    const/16 v3, 0x13

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 256
    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "com.android.gmail.ui"

    const-string v2, "*/searchConversations"

    const/16 v3, 0x14

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 258
    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "com.android.gmail.ui"

    const-string v2, "*/recentFolders"

    const/16 v3, 0x15

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 260
    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "com.android.gmail.ui"

    const-string v2, "*/defaultRecentFolders"

    const/16 v3, 0x19

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 262
    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "com.android.gmail.ui"

    const-string v2, "*/cookie"

    const/16 v3, 0x1a

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 300
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/UiProvider;->sAccountStateMap:Ljava/util/Map;

    return-void

    .line 116
    :array_0
    .array-data 4
        -0x2
        -0x1
        0x0
        0x1
        0x2
    .end array-data

    .line 123
    :array_1
    .array-data 4
        0x0
        0x1
        0x2
    .end array-data
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 92
    invoke-direct {p0}, Landroid/content/ContentProvider;-><init>()V

    .line 268
    iput-boolean v0, p0, Lcom/google/android/gm/provider/UiProvider;->mMailEnginesInitialized:Z

    .line 270
    iput-boolean v0, p0, Lcom/google/android/gm/provider/UiProvider;->mAccountsFullyInitialized:Z

    .line 272
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/UiProvider;->mAccountsPendingInitialization:Ljava/util/Set;

    .line 283
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/UiProvider;->mAccountChangeNotifiers:Ljava/util/Map;

    .line 294
    const/4 v0, -0x1

    iput v0, p0, Lcom/google/android/gm/provider/UiProvider;->mLastSequence:I

    .line 297
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/UiProvider;->mPreviousOperationUndoOps:Ljava/util/List;

    .line 3146
    return-void
.end method

.method static synthetic access$200(Lcom/google/android/gm/provider/UiProvider;)Ljava/util/Set;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/provider/UiProvider;

    .prologue
    .line 92
    iget-object v0, p0, Lcom/google/android/gm/provider/UiProvider;->mAccountsPendingInitialization:Ljava/util/Set;

    return-object v0
.end method

.method static synthetic access$300(Lcom/google/android/gm/provider/UiProvider;)V
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/provider/UiProvider;

    .prologue
    .line 92
    invoke-direct {p0}, Lcom/google/android/gm/provider/UiProvider;->updateAccountsIntializedStatus()V

    return-void
.end method

.method static synthetic access$400(Lcom/google/android/gm/provider/UiProvider;[Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gm/LabelOperations;)I
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/provider/UiProvider;
    .param p1, "x1"    # [Ljava/lang/String;
    .param p2, "x2"    # Ljava/lang/String;
    .param p3, "x3"    # Lcom/google/android/gm/LabelOperations;

    .prologue
    .line 92
    invoke-direct {p0, p1, p2, p3}, Lcom/google/android/gm/provider/UiProvider;->addRemoveLabel([Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gm/LabelOperations;)I

    move-result v0

    return v0
.end method

.method static synthetic access$500()Ljava/util/Map;
    .locals 1

    .prologue
    .line 92
    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->sAccountStateMap:Ljava/util/Map;

    return-object v0
.end method

.method static synthetic access$600()I
    .locals 1

    .prologue
    .line 92
    sget v0, Lcom/google/android/gm/provider/UiProvider;->sAccountNotificationDelayMs:I

    return v0
.end method

.method static synthetic access$700(Ljava/lang/String;)Landroid/net/Uri;
    .locals 1
    .param p0, "x0"    # Ljava/lang/String;

    .prologue
    .line 92
    invoke-static {p0}, Lcom/google/android/gm/provider/UiProvider;->getAccountBaseNotificationUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method private addRemoveLabel([Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gm/LabelOperations;)I
    .locals 26

    .prologue
    .line 1233
    invoke-virtual/range {p3 .. p3}, Lcom/google/android/gm/LabelOperations;->count()I

    move-result v3

    if-nez v3, :cond_0

    .line 1234
    const/4 v3, 0x0

    .line 1303
    :goto_0
    return v3

    .line 1236
    :cond_0
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-direct {v0, v1}, Lcom/google/android/gm/provider/UiProvider;->getOrMakeMailEngine(Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;

    move-result-object v4

    .line 1240
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v8

    .line 1241
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v9

    .line 1243
    invoke-virtual/range {p3 .. p3}, Lcom/google/android/gm/LabelOperations;->getOperationList()Ljava/util/List;

    move-result-object v10

    .line 1244
    new-instance v11, Ljava/util/ArrayList;

    invoke-direct {v11}, Ljava/util/ArrayList;-><init>()V

    .line 1246
    move-object/from16 v0, p1

    array-length v5, v0

    const/4 v3, 0x0

    :goto_1
    if-ge v3, v5, :cond_2

    aget-object v6, p1, v3

    .line 1247
    sget-object v7, Lcom/google/android/gm/provider/Gmail;->CONVERSATION_PROJECTION_LIMITED:[Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/google/android/gm/provider/UiProvider;->mGmail:Lcom/google/android/gm/provider/Gmail;

    move-object/from16 v0, p2

    invoke-virtual {v4, v7, v6, v0, v12}, Lcom/google/android/gm/provider/MailEngine;->getConversationForId([Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gm/provider/Gmail;)Lcom/google/android/gm/ConversationInfo;

    move-result-object v6

    .line 1249
    if-eqz v6, :cond_1

    .line 1250
    invoke-virtual {v11, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1246
    :cond_1
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 1254
    :cond_2
    invoke-virtual {v11}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v12

    :cond_3
    invoke-interface {v12}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_6

    invoke-interface {v12}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    move-object v5, v3

    check-cast v5, Lcom/google/android/gm/ConversationInfo;

    .line 1255
    invoke-virtual {v5}, Lcom/google/android/gm/ConversationInfo;->getLocalMessageId()J

    move-result-wide v13

    .line 1256
    invoke-virtual {v5}, Lcom/google/android/gm/ConversationInfo;->getServerMessageId()J

    move-result-wide v15

    .line 1257
    invoke-virtual {v5}, Lcom/google/android/gm/ConversationInfo;->getConversationId()J

    move-result-wide v17

    .line 1259
    invoke-interface {v10}, Ljava/util/List;->size()I

    move-result v19

    .line 1260
    const/4 v3, 0x0

    move v7, v3

    :goto_2
    move/from16 v0, v19

    if-ge v7, v0, :cond_3

    .line 1261
    invoke-interface {v10, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/google/android/gm/LabelOperations$Operation;

    iget-object v4, v3, Lcom/google/android/gm/LabelOperations$Operation;->mLabel:Lcom/google/android/gm/provider/Label;

    .line 1263
    invoke-interface {v10, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/google/android/gm/LabelOperations$Operation;

    iget-boolean v3, v3, Lcom/google/android/gm/LabelOperations$Operation;->mAdd:Z

    invoke-static {v5, v4, v3}, Lcom/google/android/gm/provider/UiProvider;->getRawOperations(Lcom/google/android/gm/ConversationInfo;Lcom/google/android/gm/provider/Label;Z)Ljava/util/Map;

    move-result-object v20

    .line 1265
    invoke-interface/range {v20 .. v20}, Ljava/util/Map;->size()I

    move-result v21

    .line 1266
    invoke-interface/range {v20 .. v20}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v3

    move/from16 v0, v21

    new-array v4, v0, [Ljava/lang/String;

    invoke-interface {v3, v4}, Ljava/util/Set;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v3

    check-cast v3, [Ljava/lang/String;

    .line 1267
    const/4 v4, 0x0

    move v6, v4

    :goto_3
    move/from16 v0, v21

    if-ge v6, v0, :cond_5

    .line 1268
    new-instance v22, Landroid/content/ContentValues;

    invoke-direct/range {v22 .. v22}, Landroid/content/ContentValues;-><init>()V

    .line 1270
    aget-object v23, v3, v6

    .line 1271
    move-object/from16 v0, v20

    move-object/from16 v1, v23

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Boolean;

    invoke-virtual {v4}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    .line 1273
    const-wide/16 v24, 0x0

    cmp-long v24, v13, v24

    if-eqz v24, :cond_4

    .line 1274
    const-string v24, "canonicalName"

    move-object/from16 v0, v22

    move-object/from16 v1, v24

    move-object/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1275
    const-string v23, "_id"

    invoke-static {v13, v14}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v24

    invoke-virtual/range {v22 .. v24}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 1276
    const-string v23, "messageId"

    invoke-static/range {v15 .. v16}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v24

    invoke-virtual/range {v22 .. v24}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 1277
    const-string v23, "conversation"

    invoke-static/range {v17 .. v18}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v24

    invoke-virtual/range {v22 .. v24}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 1278
    const-string v23, "add_label_action"

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    move-object/from16 v0, v22

    move-object/from16 v1, v23

    invoke-virtual {v0, v1, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 1279
    move-object/from16 v0, v22

    invoke-virtual {v9, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1267
    :goto_4
    add-int/lit8 v4, v6, 0x1

    move v6, v4

    goto :goto_3

    .line 1281
    :cond_4
    const-string v24, "_id"

    invoke-static/range {v17 .. v18}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v25

    move-object/from16 v0, v22

    move-object/from16 v1, v24

    move-object/from16 v2, v25

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 1282
    const-string v24, "canonicalName"

    move-object/from16 v0, v22

    move-object/from16 v1, v24

    move-object/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1283
    const-string v23, "maxMessageId"

    invoke-virtual {v5}, Lcom/google/android/gm/ConversationInfo;->getMaxMessageId()J

    move-result-wide v24

    invoke-static/range {v24 .. v25}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v24

    invoke-virtual/range {v22 .. v24}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 1284
    const-string v23, "add_label_action"

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    move-object/from16 v0, v22

    move-object/from16 v1, v23

    invoke-virtual {v0, v1, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 1285
    move-object/from16 v0, v22

    invoke-virtual {v8, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_4

    .line 1260
    :cond_5
    add-int/lit8 v3, v7, 0x1

    move v7, v3

    goto/16 :goto_2

    .line 1293
    :cond_6
    invoke-virtual {v8}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-lez v3, :cond_7

    .line 1294
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/google/android/gm/provider/UiProvider;->mGmail:Lcom/google/android/gm/provider/Gmail;

    invoke-virtual {v8}, Ljava/util/ArrayList;->size()I

    move-result v3

    new-array v3, v3, [Landroid/content/ContentValues;

    invoke-virtual {v8, v3}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v3

    check-cast v3, [Landroid/content/ContentValues;

    const/4 v5, 0x1

    move-object/from16 v0, p2

    invoke-virtual {v4, v0, v3, v5}, Lcom/google/android/gm/provider/Gmail;->addOrRemoveLabelOnConversationBulk(Ljava/lang/String;[Landroid/content/ContentValues;Z)V

    .line 1298
    :cond_7
    invoke-virtual {v9}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-lez v3, :cond_8

    .line 1299
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/google/android/gm/provider/UiProvider;->mGmail:Lcom/google/android/gm/provider/Gmail;

    invoke-virtual {v9}, Ljava/util/ArrayList;->size()I

    move-result v3

    new-array v3, v3, [Landroid/content/ContentValues;

    invoke-virtual {v9, v3}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v3

    check-cast v3, [Landroid/content/ContentValues;

    const/4 v5, 0x1

    move-object/from16 v0, p2

    invoke-virtual {v4, v0, v3, v5}, Lcom/google/android/gm/provider/Gmail;->addOrRemoveLabelOnMessageBulk(Ljava/lang/String;[Landroid/content/ContentValues;Z)V

    .line 1303
    :cond_8
    invoke-virtual {v11}, Ljava/util/ArrayList;->size()I

    move-result v3

    goto/16 :goto_0
.end method

.method private addUndoOperation(ILcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;)V
    .locals 6
    .param p1, "sequenceNum"    # I
    .param p2, "undoOperation"    # Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;

    .prologue
    .line 977
    iget-object v1, p0, Lcom/google/android/gm/provider/UiProvider;->mPreviousOperationUndoOps:Ljava/util/List;

    monitor-enter v1

    .line 978
    const/4 v0, -0x1

    if-eq p1, v0, :cond_0

    :try_start_0
    iget v0, p0, Lcom/google/android/gm/provider/UiProvider;->mLastSequence:I

    if-le p1, v0, :cond_0

    .line 979
    const-string v0, "Gmail"

    const-string v2, "About to clean %d undo operations. sequenceNum:%d mLastSequence: %d"

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/google/android/gm/provider/UiProvider;->mPreviousOperationUndoOps:Ljava/util/List;

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x2

    iget v5, p0, Lcom/google/android/gm/provider/UiProvider;->mLastSequence:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v0, v2, v3}, Lcom/google/android/gm/provider/LogUtils;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 983
    iget-object v0, p0, Lcom/google/android/gm/provider/UiProvider;->mPreviousOperationUndoOps:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 984
    iput p1, p0, Lcom/google/android/gm/provider/UiProvider;->mLastSequence:I

    .line 986
    :cond_0
    iget-object v0, p0, Lcom/google/android/gm/provider/UiProvider;->mPreviousOperationUndoOps:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 987
    monitor-exit v1

    .line 988
    return-void

    .line 987
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method static broadcastAccountChangeNotification(Landroid/content/Context;Ljava/lang/String;)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "account"    # Ljava/lang/String;

    .prologue
    .line 2880
    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->sInstance:Lcom/google/android/gm/provider/UiProvider;

    .line 2882
    .local v0, "provider":Lcom/google/android/gm/provider/UiProvider;
    if-eqz v0, :cond_0

    .line 2883
    invoke-direct {v0, p0, p1}, Lcom/google/android/gm/provider/UiProvider;->scheduleAccountChangeNotification(Landroid/content/Context;Ljava/lang/String;)V

    .line 2885
    :cond_0
    return-void
.end method

.method static broadcastAccountFolderChangeNotification(Landroid/content/Context;Ljava/lang/String;ZLjava/lang/String;)V
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "isSearch"    # Z
    .param p3, "canonicalName"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x0

    .line 2911
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    .line 2912
    .local v1, "resolver":Landroid/content/ContentResolver;
    if-eqz p2, :cond_0

    .line 2913
    invoke-static {p1}, Lcom/google/android/gm/provider/UiProvider;->getAccountSearchUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v1, v2, v4, v3}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;Z)V

    .line 2918
    :goto_0
    return-void

    .line 2915
    :cond_0
    invoke-static {p1, p3}, Lcom/google/android/gm/provider/UiProvider;->getAccountLabelNotificationUri(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 2916
    .local v0, "notificationUri":Landroid/net/Uri;
    invoke-virtual {v1, v0, v4, v3}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;Z)V

    goto :goto_0
.end method

.method static broadcastFolderNotifications(Landroid/content/Context;Lcom/google/android/gm/provider/Gmail$LabelMap;Ljava/lang/String;Ljava/util/Set;)V
    .locals 9
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "labelMap"    # Lcom/google/android/gm/provider/Gmail$LabelMap;
    .param p2, "account"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/google/android/gm/provider/Gmail$LabelMap;",
            "Ljava/lang/String;",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Long;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p3, "labelIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    const/4 v8, 0x0

    const/4 v7, 0x0

    .line 2992
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v4

    .line 2993
    .local v4, "resolver":Landroid/content/ContentResolver;
    invoke-interface {p3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Long;

    .line 2994
    .local v2, "labelId":Ljava/lang/Long;
    if-eqz v2, :cond_0

    .line 2998
    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v5

    invoke-virtual {p1, v5, v6}, Lcom/google/android/gm/provider/Gmail$LabelMap;->getCanonicalName(J)Ljava/lang/String;

    move-result-object v0

    .line 2999
    .local v0, "canonicalName":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 3002
    invoke-static {p2, v0}, Lcom/google/android/gm/provider/UiProvider;->getAccountLabelNotificationUri(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    .line 3003
    .local v3, "notificationUri":Landroid/net/Uri;
    invoke-virtual {v4, v3, v8, v7}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;Z)V

    goto :goto_0

    .line 3005
    .end local v0    # "canonicalName":Ljava/lang/String;
    .end local v2    # "labelId":Ljava/lang/Long;
    .end local v3    # "notificationUri":Landroid/net/Uri;
    :cond_1
    invoke-interface {p3}, Ljava/util/Set;->size()I

    move-result v5

    if-lez v5, :cond_2

    .line 3006
    invoke-static {p2}, Lcom/google/android/gm/provider/UiProvider;->getAccountFoldersUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v5

    invoke-virtual {v4, v5, v8, v7}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;Z)V

    .line 3010
    invoke-static {p2}, Lcom/google/android/gm/provider/UiProvider;->getRecentFoldersUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v5

    invoke-virtual {v4, v5, v8, v7}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;Z)V

    .line 3012
    :cond_2
    return-void
.end method

.method private createAttachmentCursor(Ljava/lang/String;JJ[Ljava/lang/String;I)Lcom/google/android/gm/provider/UiProvider$AttachmentCursor;
    .locals 10
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "conversationId"    # J
    .param p4, "messageId"    # J
    .param p6, "columnNames"    # [Ljava/lang/String;
    .param p7, "initialCapacity"    # I

    .prologue
    .line 3100
    new-instance v0, Lcom/google/android/gm/provider/UiProvider$AttachmentCursor;

    move-object v1, p0

    move-object v2, p1

    move-wide v3, p2

    move-wide v5, p4

    move-object/from16 v7, p6

    move/from16 v8, p7

    invoke-direct/range {v0 .. v8}, Lcom/google/android/gm/provider/UiProvider$AttachmentCursor;-><init>(Lcom/google/android/gm/provider/UiProvider;Ljava/lang/String;JJ[Ljava/lang/String;I)V

    .line 3103
    .local v0, "result":Lcom/google/android/gm/provider/UiProvider$AttachmentCursor;
    invoke-direct {p0, p1, p2, p3}, Lcom/google/android/gm/provider/UiProvider;->getConversationState(Ljava/lang/String;J)Lcom/google/android/gm/provider/uiprovider/ConversationState;

    move-result-object v9

    .line 3104
    .local v9, "conversationState":Lcom/google/android/gm/provider/uiprovider/ConversationState;
    invoke-virtual {v9, v0}, Lcom/google/android/gm/provider/uiprovider/ConversationState;->addAttachmentCursor(Landroid/database/Cursor;)V

    .line 3106
    return-object v0
.end method

.method private createLabelOperations(Ljava/lang/String;JLjava/util/List;Ljava/util/List;)Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "J",
            "Ljava/util/List",
            "<",
            "Lcom/android/mail/providers/Folder;",
            ">;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;"
        }
    .end annotation

    .prologue
    .line 1138
    new-instance v0, Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;

    const/4 v5, 0x0

    move-object v1, p0

    move-object v2, p1

    move-wide v3, p2

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;-><init>(Lcom/google/android/gm/provider/UiProvider;Ljava/lang/String;JLcom/google/android/gm/provider/UiProvider$1;)V

    .line 1142
    new-instance v4, Ljava/util/HashSet;

    invoke-direct {v4}, Ljava/util/HashSet;-><init>()V

    .line 1143
    invoke-interface {p5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 1144
    invoke-virtual {v4, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 1147
    :cond_0
    new-instance v5, Ljava/util/HashSet;

    invoke-direct {v5}, Ljava/util/HashSet;-><init>()V

    .line 1148
    invoke-interface {p5}, Ljava/util/List;->size()I

    move-result v1

    if-nez v1, :cond_4

    const/4 v1, 0x1

    move v3, v1

    .line 1149
    :goto_1
    if-nez p4, :cond_1

    .line 1150
    new-instance p4, Ljava/util/ArrayList;

    invoke-direct {p4}, Ljava/util/ArrayList;-><init>()V

    .line 1152
    :cond_1
    invoke-interface {p4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :cond_2
    :goto_2
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_7

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/mail/providers/Folder;

    .line 1153
    iget-object v1, v1, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    .line 1158
    invoke-virtual {v1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v1

    const/4 v2, 0x2

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 1159
    invoke-virtual {v5, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 1160
    if-nez v3, :cond_3

    invoke-virtual {v4, v1}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_5

    :cond_3
    const/4 v2, 0x1

    .line 1161
    :goto_3
    if-eqz v2, :cond_2

    invoke-static {v1}, Lcom/google/android/gm/provider/UiProvider;->isUserSettableLabel(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 1162
    invoke-virtual {p0}, Lcom/google/android/gm/provider/UiProvider;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2, p1, v1}, Lcom/google/android/gm/provider/LabelManager;->getLabel(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gm/provider/Label;

    move-result-object v2

    .line 1163
    if-eqz v2, :cond_6

    .line 1164
    const/4 v1, 0x1

    invoke-virtual {v0, v2, v1}, Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;->add(Lcom/google/android/gm/provider/Label;Z)V

    goto :goto_2

    .line 1148
    :cond_4
    const/4 v1, 0x0

    move v3, v1

    goto :goto_1

    .line 1160
    :cond_5
    const/4 v2, 0x0

    goto :goto_3

    .line 1166
    :cond_6
    const-string v2, "Gmail"

    const-string v7, "Couldn\'t create label for canonical name: %s"

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    aput-object v1, v8, v9

    invoke-static {v2, v7, v8}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_2

    .line 1172
    :cond_7
    if-eqz p4, :cond_8

    invoke-interface {p4}, Ljava/util/List;->size()I

    move-result v1

    if-nez v1, :cond_b

    :cond_8
    const/4 v1, 0x1

    move v2, v1

    .line 1173
    :goto_4
    invoke-interface {p5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_9
    :goto_5
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_e

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 1174
    if-nez v2, :cond_a

    invoke-virtual {v5, v1}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_c

    :cond_a
    const/4 v3, 0x1

    .line 1175
    :goto_6
    if-eqz v3, :cond_9

    invoke-static {v1}, Lcom/google/android/gm/provider/UiProvider;->isUserSettableLabel(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_9

    .line 1176
    invoke-virtual {p0}, Lcom/google/android/gm/provider/UiProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3, p1, v1}, Lcom/google/android/gm/provider/LabelManager;->getLabel(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gm/provider/Label;

    move-result-object v3

    .line 1177
    if-eqz v3, :cond_d

    .line 1178
    const/4 v1, 0x0

    invoke-virtual {v0, v3, v1}, Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;->add(Lcom/google/android/gm/provider/Label;Z)V

    goto :goto_5

    .line 1172
    :cond_b
    const/4 v1, 0x0

    move v2, v1

    goto :goto_4

    .line 1174
    :cond_c
    const/4 v3, 0x0

    goto :goto_6

    .line 1180
    :cond_d
    const-string v3, "Gmail"

    const-string v6, "Couldn\'t create label for canonical name: %s"

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    aput-object v1, v7, v8

    invoke-static {v3, v6, v7}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_5

    .line 1185
    :cond_e
    return-object v0
.end method

.method private createLabelOperationsForUIOperation(Ljava/lang/String;JLjava/lang/String;)Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;
    .locals 8

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x1

    .line 1190
    const-string v0, "Gmail"

    const-string v1, "Received operation %s for conversation %d"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    aput-object p4, v2, v7

    invoke-static {p2, p3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    aput-object v3, v2, v6

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1193
    new-instance v0, Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;

    const/4 v5, 0x0

    move-object v1, p0

    move-object v2, p1

    move-wide v3, p2

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;-><init>(Lcom/google/android/gm/provider/UiProvider;Ljava/lang/String;JLcom/google/android/gm/provider/UiProvider$1;)V

    .line 1196
    const-string v1, "archive"

    invoke-virtual {v1, p4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 1197
    invoke-virtual {p0}, Lcom/google/android/gm/provider/UiProvider;->getContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "^i"

    invoke-static {v1, p1, v2}, Lcom/google/android/gm/provider/LabelManager;->getLabel(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gm/provider/Label;

    move-result-object v1

    invoke-virtual {v0, v1, v7}, Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;->add(Lcom/google/android/gm/provider/Label;Z)V

    .line 1214
    :cond_0
    :goto_0
    return-object v0

    .line 1199
    :cond_1
    const-string v1, "mute"

    invoke-virtual {v1, p4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 1200
    invoke-virtual {p0}, Lcom/google/android/gm/provider/UiProvider;->getContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "^g"

    invoke-static {v1, p1, v2}, Lcom/google/android/gm/provider/LabelManager;->getLabel(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gm/provider/Label;

    move-result-object v1

    invoke-virtual {v0, v1, v6}, Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;->add(Lcom/google/android/gm/provider/Label;Z)V

    goto :goto_0

    .line 1202
    :cond_2
    const-string v1, "report_spam"

    invoke-virtual {v1, p4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_3

    const-string v1, "report_not_spam"

    invoke-virtual {v1, p4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 1204
    :cond_3
    invoke-virtual {p0}, Lcom/google/android/gm/provider/UiProvider;->getContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "^s"

    invoke-static {v1, p1, v2}, Lcom/google/android/gm/provider/LabelManager;->getLabel(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gm/provider/Label;

    move-result-object v1

    const-string v2, "report_spam"

    invoke-virtual {v2, p4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;->add(Lcom/google/android/gm/provider/Label;Z)V

    goto :goto_0

    .line 1207
    :cond_4
    const-string v1, "report_phishing"

    invoke-virtual {v1, p4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1208
    invoke-virtual {p0}, Lcom/google/android/gm/provider/UiProvider;->getContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "^p"

    invoke-static {v1, p1, v2}, Lcom/google/android/gm/provider/LabelManager;->getLabel(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gm/provider/Label;

    move-result-object v1

    .line 1210
    if-eqz v1, :cond_0

    .line 1211
    invoke-virtual {v0, v1, v6}, Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;->add(Lcom/google/android/gm/provider/Label;Z)V

    goto :goto_0
.end method

.method private delete(Ljava/lang/String;Ljava/lang/String;I)I
    .locals 7

    .prologue
    const/4 v6, 0x1

    .line 1218
    invoke-static {p1}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v3

    .line 1219
    new-instance v0, Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;

    const/4 v5, 0x0

    move-object v1, p0

    move-object v2, p2

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;-><init>(Lcom/google/android/gm/provider/UiProvider;Ljava/lang/String;JLcom/google/android/gm/provider/UiProvider$1;)V

    .line 1221
    invoke-virtual {p0}, Lcom/google/android/gm/provider/UiProvider;->getContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "^k"

    invoke-static {v1, p2, v2}, Lcom/google/android/gm/provider/LabelManager;->getLabel(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gm/provider/Label;

    move-result-object v1

    invoke-virtual {v0, v1, v6}, Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;->add(Lcom/google/android/gm/provider/Label;Z)V

    .line 1224
    invoke-virtual {v0}, Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;->undoOperation()Lcom/google/android/gm/LabelOperations;

    move-result-object v1

    check-cast v1, Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;

    .line 1226
    invoke-direct {p0, p3, v1}, Lcom/google/android/gm/provider/UiProvider;->addUndoOperation(ILcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;)V

    .line 1228
    new-array v1, v6, [Ljava/lang/String;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    invoke-direct {p0, v1, p2, v0}, Lcom/google/android/gm/provider/UiProvider;->addRemoveLabel([Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gm/LabelOperations;)I

    move-result v0

    return v0
.end method

.method private expungeMessage(Ljava/lang/String;Landroid/content/ContentValues;)I
    .locals 6

    .prologue
    const/4 v0, 0x0

    .line 2335
    const-string v1, "_id"

    invoke-virtual {p2, v1}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 2352
    :goto_0
    return v0

    .line 2338
    :cond_0
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/UiProvider;->getOrMakeMailEngine(Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;

    move-result-object v2

    .line 2339
    const-string v1, "_id"

    invoke-virtual {p2, v1}, Landroid/content/ContentValues;->getAsLong(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v3

    .line 2342
    invoke-virtual {v2, v3, v4, v0}, Lcom/google/android/gm/provider/MailEngine;->getLocalMessage(JZ)Lcom/google/android/gm/provider/MailSync$Message;

    move-result-object v5

    .line 2345
    invoke-virtual {v2, v3, v4}, Lcom/google/android/gm/provider/MailEngine;->expungeLocalMessage(J)I

    move-result v1

    .line 2347
    if-eqz v5, :cond_1

    .line 2348
    iget-object v3, p0, Lcom/google/android/gm/provider/UiProvider;->mContentResolver:Landroid/content/ContentResolver;

    invoke-virtual {v2}, Lcom/google/android/gm/provider/MailEngine;->getAccountName()Ljava/lang/String;

    move-result-object v2

    iget-wide v4, v5, Lcom/google/android/gm/provider/MailSync$Message;->conversationId:J

    invoke-static {v2, v4, v5}, Lcom/google/android/gm/provider/UiProvider;->getConversationMessageListUri(Ljava/lang/String;J)Landroid/net/Uri;

    move-result-object v2

    const/4 v4, 0x0

    invoke-virtual {v3, v2, v4, v0}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;Z)V

    :cond_1
    move v0, v1

    .line 2352
    goto :goto_0
.end method

.method private static getAboutUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 4
    .param p0, "account"    # Ljava/lang/String;

    .prologue
    .line 473
    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->BASE_SETTINGS_URI:Landroid/net/Uri;

    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    const-string v1, "preference_fragment_id"

    const-wide/32 v2, 0x7f10011b

    invoke-static {v2, v3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    const-string v1, "account"

    invoke-virtual {v0, v1, p0}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method private static getAccountBaseNotificationUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 2
    .param p0, "account"    # Ljava/lang/String;

    .prologue
    .line 315
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "content://com.android.gmail.uiinternal/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/notification"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method private static getAccountConversationSearchUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 2
    .param p0, "account"    # Ljava/lang/String;

    .prologue
    .line 355
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "content://com.android.gmail.ui/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/searchConversations"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method private getAccountCookieCursor(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    .locals 9

    .prologue
    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 2815
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/UiProvider;->getOrMakeMailEngine(Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;

    move-result-object v0

    .line 2816
    invoke-static {p2}, Lcom/android/mail/providers/UIProviderValidator;->validateAccountCookieProjection([Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 2822
    :try_start_0
    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailEngine;->getAuthToken()Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lcom/google/android/gm/provider/MailEngine$AuthenticationException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v0

    .line 2832
    :goto_0
    if-eqz v0, :cond_0

    invoke-static {p1, v0}, Lcom/google/android/gm/provider/Urls;->getCookieString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 2835
    :goto_1
    new-instance v4, Landroid/database/MatrixCursor;

    const/4 v5, 0x1

    invoke-direct {v4, v3, v5}, Landroid/database/MatrixCursor;-><init>([Ljava/lang/String;I)V

    .line 2836
    invoke-virtual {v4}, Landroid/database/MatrixCursor;->newRow()Landroid/database/MatrixCursor$RowBuilder;

    move-result-object v5

    .line 2837
    array-length v6, v3

    :goto_2
    if-ge v2, v6, :cond_2

    aget-object v7, v3, v2

    .line 2838
    const-string v8, "cookie"

    invoke-static {v7, v8}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 2839
    invoke-virtual {v5, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    .line 2837
    :goto_3
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    .line 2823
    :catch_0
    move-exception v0

    .line 2824
    const-string v4, "Gmail"

    const-string v5, "IOException retrieving auth token"

    new-array v6, v2, [Ljava/lang/Object;

    invoke-static {v4, v0, v5, v6}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    move-object v0, v1

    .line 2829
    goto :goto_0

    .line 2826
    :catch_1
    move-exception v0

    .line 2827
    const-string v4, "Gmail"

    const-string v5, "AuthenticationException retrieving auth token"

    new-array v6, v2, [Ljava/lang/Object;

    invoke-static {v4, v0, v5, v6}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    move-object v0, v1

    goto :goto_0

    :cond_0
    move-object v0, v1

    .line 2832
    goto :goto_1

    .line 2841
    :cond_1
    invoke-virtual {v5, v1}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto :goto_3

    .line 2844
    :cond_2
    return-object v4
.end method

.method private static getAccountCookieQueryUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 3
    .param p0, "account"    # Ljava/lang/String;

    .prologue
    .line 452
    const-string v1, "content://com.android.gmail.ui"

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v1}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    .line 453
    .local v0, "builder":Landroid/net/Uri$Builder;
    invoke-virtual {v0, p0}, Landroid/net/Uri$Builder;->appendEncodedPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    const-string v2, "cookie"

    invoke-virtual {v1, v2}, Landroid/net/Uri$Builder;->appendEncodedPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 455
    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v1

    return-object v1
.end method

.method private getAccountCursor(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    .locals 6

    .prologue
    .line 1551
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/UiProvider;->getOrMakeMailEngine(Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;

    move-result-object v0

    .line 1553
    const/4 v1, 0x0

    .line 1554
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailEngine;->getAccountName()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/google/android/gm/provider/UiProvider;->isAccountNameValid(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1555
    invoke-static {v0}, Ljava/util/Collections;->singletonList(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    invoke-direct {p0, p2, v0}, Lcom/google/android/gm/provider/UiProvider;->getAccountsCursorForMailEngines([Ljava/lang/String;Ljava/util/List;)Landroid/database/Cursor;

    move-result-object v0

    .line 1561
    :goto_0
    return-object v0

    .line 1558
    :cond_0
    const-string v2, "Gmail"

    const-string v3, "Invalid mailEngine. %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    if-nez v0, :cond_1

    const-string v0, "null MailEngine"

    :goto_1
    aput-object v0, v4, v5

    invoke-static {v2, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    move-object v0, v1

    goto :goto_0

    :cond_1
    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailEngine;->getAccountName()Ljava/lang/String;

    move-result-object v0

    goto :goto_1
.end method

.method private static getAccountExpungeMessageUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 2
    .param p0, "account"    # Ljava/lang/String;

    .prologue
    .line 371
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "content://com.android.gmail.ui/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/expungeMessage"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method private static getAccountFoldersUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 2
    .param p0, "account"    # Ljava/lang/String;

    .prologue
    .line 327
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "content://com.android.gmail.ui/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/labels"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method private getAccountLabelCursor(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    .locals 6
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "canonicalName"    # Ljava/lang/String;
    .param p3, "projection"    # [Ljava/lang/String;

    .prologue
    .line 1881
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/UiProvider;->getOrMakeMailEngine(Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;

    move-result-object v2

    .line 1883
    .local v2, "mailEngine":Lcom/google/android/gm/provider/MailEngine;
    invoke-static {p3}, Lcom/android/mail/providers/UIProviderValidator;->validateFolderProjection([Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 1885
    .local v3, "resultProjection":[Ljava/lang/String;
    sget-object v4, Lcom/google/android/gm/provider/Gmail;->LABEL_PROJECTION:[Ljava/lang/String;

    invoke-virtual {v2, v4}, Lcom/google/android/gm/provider/MailEngine;->getLabelQueryBuilder([Ljava/lang/String;)Lcom/google/android/gm/provider/LabelQueryBuilder;

    move-result-object v4

    invoke-static {p2}, Ljava/util/Collections;->singletonList(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/google/android/gm/provider/LabelQueryBuilder;->filterCanonicalName(Ljava/util/List;)Lcom/google/android/gm/provider/LabelQueryBuilder;

    move-result-object v4

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Lcom/google/android/gm/provider/LabelQueryBuilder;->showHidden(Z)Lcom/google/android/gm/provider/LabelQueryBuilder;

    move-result-object v0

    .line 1888
    .local v0, "builder":Lcom/google/android/gm/provider/LabelQueryBuilder;
    invoke-virtual {v0}, Lcom/google/android/gm/provider/LabelQueryBuilder;->query()Landroid/database/Cursor;

    move-result-object v1

    .line 1889
    .local v1, "labelCursor":Landroid/database/Cursor;
    invoke-static {v2, p1, v3, v1}, Lcom/google/android/gm/provider/UiProvider;->getUiLabelCursor(Lcom/google/android/gm/provider/MailEngine;Ljava/lang/String;[Ljava/lang/String;Landroid/database/Cursor;)Landroid/database/Cursor;

    move-result-object v4

    return-object v4
.end method

.method public static getAccountLabelNotificationUri(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;
    .locals 2
    .param p0, "account"    # Ljava/lang/String;
    .param p1, "canonicalName"    # Ljava/lang/String;

    .prologue
    .line 335
    invoke-static {p0}, Lcom/google/android/gm/provider/UiProvider;->getAccountUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v1}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    .line 336
    .local v0, "builder":Landroid/net/Uri$Builder;
    const-string v1, "label"

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->appendPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 337
    invoke-virtual {v0, p1}, Landroid/net/Uri$Builder;->appendPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 338
    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v1

    return-object v1
.end method

.method public static getAccountLabelUri(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;
    .locals 2
    .param p0, "account"    # Ljava/lang/String;
    .param p1, "canonicalName"    # Ljava/lang/String;

    .prologue
    .line 331
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "content://com.android.gmail.ui/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/label/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {p1}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method private getAccountLabelsCursor(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    .locals 6
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "projection"    # [Ljava/lang/String;

    .prologue
    .line 1868
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/UiProvider;->getOrMakeMailEngine(Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;

    move-result-object v2

    .line 1870
    .local v2, "mailEngine":Lcom/google/android/gm/provider/MailEngine;
    invoke-static {p2}, Lcom/android/mail/providers/UIProviderValidator;->validateFolderProjection([Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 1872
    .local v3, "resultProjection":[Ljava/lang/String;
    sget-object v4, Lcom/google/android/gm/provider/Gmail;->LABEL_PROJECTION:[Ljava/lang/String;

    invoke-virtual {v2, v4}, Lcom/google/android/gm/provider/MailEngine;->getLabelQueryBuilder([Ljava/lang/String;)Lcom/google/android/gm/provider/LabelQueryBuilder;

    move-result-object v4

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Lcom/google/android/gm/provider/LabelQueryBuilder;->showHidden(Z)Lcom/google/android/gm/provider/LabelQueryBuilder;

    move-result-object v0

    .line 1875
    .local v0, "builder":Lcom/google/android/gm/provider/LabelQueryBuilder;
    invoke-virtual {v0}, Lcom/google/android/gm/provider/LabelQueryBuilder;->query()Landroid/database/Cursor;

    move-result-object v1

    .line 1876
    .local v1, "labelCursor":Landroid/database/Cursor;
    invoke-static {v2, p1, v3, v1}, Lcom/google/android/gm/provider/UiProvider;->getUiLabelCursor(Lcom/google/android/gm/provider/MailEngine;Ljava/lang/String;[Ljava/lang/String;Landroid/database/Cursor;)Landroid/database/Cursor;

    move-result-object v4

    return-object v4
.end method

.method public static getAccountObject(Landroid/content/Context;Ljava/lang/String;)Lcom/android/mail/providers/Account;
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "accountName"    # Ljava/lang/String;

    .prologue
    .line 1609
    new-instance v1, Landroid/database/MatrixCursor;

    sget-object v2, Lcom/android/mail/providers/UIProvider;->ACCOUNTS_PROJECTION:[Ljava/lang/String;

    const/4 v3, 0x1

    invoke-direct {v1, v2, v3}, Landroid/database/MatrixCursor;-><init>([Ljava/lang/String;I)V

    .line 1611
    .local v1, "cursor":Landroid/database/MatrixCursor;
    invoke-virtual {v1}, Landroid/database/MatrixCursor;->newRow()Landroid/database/MatrixCursor$RowBuilder;

    move-result-object v0

    .line 1614
    .local v0, "builder":Landroid/database/MatrixCursor$RowBuilder;
    const/4 v2, 0x0

    sget-object v3, Lcom/android/mail/providers/UIProvider;->ACCOUNTS_PROJECTION:[Ljava/lang/String;

    invoke-static {p0, p1, v2, v3, v0}, Lcom/google/android/gm/provider/UiProvider;->populateAccountCursorRow(Landroid/content/Context;Ljava/lang/String;Lcom/google/android/gm/provider/MailEngine;[Ljava/lang/String;Landroid/database/MatrixCursor$RowBuilder;)V

    .line 1616
    invoke-virtual {v1}, Landroid/database/MatrixCursor;->moveToFirst()Z

    .line 1618
    new-instance v2, Lcom/android/mail/providers/Account;

    invoke-direct {v2, v1}, Lcom/android/mail/providers/Account;-><init>(Landroid/database/Cursor;)V

    return-object v2
.end method

.method private static getAccountRefreshUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 3
    .param p0, "account"    # Ljava/lang/String;

    .prologue
    .line 438
    const-string v1, "content://com.android.gmail.ui"

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v1}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    .line 439
    .local v0, "builder":Landroid/net/Uri$Builder;
    invoke-virtual {v0, p0}, Landroid/net/Uri$Builder;->appendEncodedPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    const-string v2, "refresh"

    invoke-virtual {v1, v2}, Landroid/net/Uri$Builder;->appendEncodedPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 441
    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v1

    return-object v1
.end method

.method private static getAccountSaveDraftUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 2
    .param p0, "account"    # Ljava/lang/String;

    .prologue
    .line 363
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "content://com.android.gmail.ui/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/saveNewMessage"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method private static getAccountSearchUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 2
    .param p0, "account"    # Ljava/lang/String;

    .prologue
    .line 351
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "content://com.android.gmail.ui/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/search"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method private static getAccountSendMessageUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 2
    .param p0, "account"    # Ljava/lang/String;

    .prologue
    .line 367
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "content://com.android.gmail.ui/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/sendNewMessage"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method private static getAccountSettingUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 2
    .param p0, "account"    # Ljava/lang/String;

    .prologue
    .line 463
    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->BASE_SETTINGS_URI:Landroid/net/Uri;

    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    const-string v1, "account"

    invoke-virtual {v0, v1, p0}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method private static getAccountUndoUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 2
    .param p0, "account"    # Ljava/lang/String;

    .prologue
    .line 459
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "content://com.android.gmail.ui/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/undo"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method public static getAccountUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 2
    .param p0, "account"    # Ljava/lang/String;

    .prologue
    .line 319
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "content://com.android.gmail.ui/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/account"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method private static getAccountViewIntentProxyUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 2
    .param p0, "account"    # Ljava/lang/String;

    .prologue
    .line 445
    const-string v1, "content://com.android.gmail.ui"

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v1}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    .line 446
    .local v0, "builder":Landroid/net/Uri$Builder;
    const-string v1, "proxy"

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->appendEncodedPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 448
    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v1

    return-object v1
.end method

.method private getAccountsCursor([Ljava/lang/String;)Landroid/database/Cursor;
    .locals 3
    .param p1, "projection"    # [Ljava/lang/String;

    .prologue
    .line 1565
    invoke-virtual {p0}, Lcom/google/android/gm/provider/UiProvider;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Lcom/google/android/gm/provider/MailEngine;->getMailEngines(Landroid/content/Context;)Ljava/util/List;

    move-result-object v1

    .line 1566
    .local v1, "engines":Ljava/util/List;, "Ljava/util/List<Lcom/google/android/gm/provider/MailEngine;>;"
    invoke-direct {p0, p1, v1}, Lcom/google/android/gm/provider/UiProvider;->getAccountsCursorForMailEngines([Ljava/lang/String;Ljava/util/List;)Landroid/database/Cursor;

    move-result-object v0

    .line 1568
    .local v0, "accountsCursor":Landroid/database/Cursor;
    monitor-enter p0

    .line 1571
    :try_start_0
    iget-boolean v2, p0, Lcom/google/android/gm/provider/UiProvider;->mMailEnginesInitialized:Z

    if-nez v2, :cond_0

    .line 1572
    invoke-direct {p0}, Lcom/google/android/gm/provider/UiProvider;->initializeMailEngines()V

    .line 1574
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/google/android/gm/provider/UiProvider;->mMailEnginesInitialized:Z

    .line 1576
    :cond_0
    monitor-exit p0

    .line 1578
    return-object v0

    .line 1576
    :catchall_0
    move-exception v2

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2
.end method

.method private getAccountsCursorForMailEngines([Ljava/lang/String;Ljava/util/List;)Landroid/database/Cursor;
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/google/android/gm/provider/MailEngine;",
            ">;)",
            "Landroid/database/Cursor;"
        }
    .end annotation

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 1582
    invoke-static {p1}, Lcom/android/mail/providers/UIProviderValidator;->validateAccountProjection([Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 1584
    new-instance v4, Landroid/os/Bundle;

    invoke-direct {v4}, Landroid/os/Bundle;-><init>()V

    .line 1585
    const-string v5, "accounts_loaded"

    iget-boolean v0, p0, Lcom/google/android/gm/provider/UiProvider;->mAccountsFullyInitialized:Z

    if-eqz v0, :cond_0

    move v0, v1

    :goto_0
    invoke-virtual {v4, v5, v0}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1587
    new-instance v5, Lcom/android/mail/utils/MatrixCursorWithExtra;

    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v0

    invoke-direct {v5, v3, v0, v4}, Lcom/android/mail/utils/MatrixCursorWithExtra;-><init>([Ljava/lang/String;ILandroid/os/Bundle;)V

    .line 1589
    invoke-interface {p2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gm/provider/MailEngine;

    .line 1590
    invoke-virtual {v5}, Landroid/database/MatrixCursor;->newRow()Landroid/database/MatrixCursor$RowBuilder;

    move-result-object v6

    .line 1591
    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailEngine;->getAccountName()Ljava/lang/String;

    move-result-object v7

    .line 1592
    invoke-static {v7}, Lcom/google/android/gm/provider/UiProvider;->isAccountNameValid(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_1

    .line 1593
    invoke-virtual {p0}, Lcom/google/android/gm/provider/UiProvider;->getContext()Landroid/content/Context;

    move-result-object v8

    invoke-static {v8, v7, v0, v3, v6}, Lcom/google/android/gm/provider/UiProvider;->populateAccountCursorRow(Landroid/content/Context;Ljava/lang/String;Lcom/google/android/gm/provider/MailEngine;[Ljava/lang/String;Landroid/database/MatrixCursor$RowBuilder;)V

    goto :goto_1

    :cond_0
    move v0, v2

    .line 1585
    goto :goto_0

    .line 1596
    :cond_1
    const-string v0, "Gmail"

    const-string v6, "Invalid MailEngine account name: %s"

    new-array v8, v1, [Ljava/lang/Object;

    aput-object v7, v8, v2

    invoke-static {v0, v6, v8}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_1

    .line 1599
    :cond_2
    return-object v5
.end method

.method private static getComposeUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 2
    .param p0, "account"    # Ljava/lang/String;

    .prologue
    .line 486
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "gmail2from://gmail-ls/account/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method public static getConversationBaseUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 1
    .param p0, "account"    # Ljava/lang/String;

    .prologue
    .line 323
    invoke-static {p0}, Lcom/google/android/gm/provider/Urls;->getUriString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method public static getConversationForConversationCursor(Landroid/content/Context;Ljava/lang/String;Lcom/google/android/gm/provider/Gmail$ConversationCursor;)Lcom/android/mail/providers/Conversation;
    .locals 27

    .prologue
    .line 2672
    invoke-virtual/range {p2 .. p2}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getConversationId()J

    move-result-wide v1

    .line 2674
    invoke-virtual/range {p2 .. p2}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getFromSnippetInstructions()Ljava/lang/String;

    move-result-object v10

    .line 2675
    invoke-virtual/range {p2 .. p2}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getSnippet()Ljava/lang/String;

    move-result-object v7

    .line 2676
    invoke-virtual/range {p2 .. p2}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getNumMessages()I

    move-result v11

    .line 2678
    new-instance v24, Lcom/android/mail/providers/ConversationInfo;

    invoke-direct/range {v24 .. v24}, Lcom/android/mail/providers/ConversationInfo;-><init>()V

    .line 2680
    invoke-virtual/range {p2 .. p2}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getLabels()Ljava/util/Map;

    move-result-object v3

    const-string v4, "^u"

    invoke-interface {v3, v4}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v3

    move-object/from16 v0, v24

    invoke-static {v10, v11, v7, v0, v3}, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->generateConversationInfo(Ljava/lang/String;ILjava/lang/String;Lcom/android/mail/providers/ConversationInfo;Z)V

    .line 2683
    move-object/from16 v0, p1

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/UiProvider;->getConversationUri(Ljava/lang/String;J)Landroid/net/Uri;

    move-result-object v3

    invoke-virtual/range {p2 .. p2}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getSubject()Ljava/lang/String;

    move-result-object v4

    invoke-virtual/range {p2 .. p2}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getDateMs()J

    move-result-wide v5

    invoke-virtual/range {p2 .. p2}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->hasAttachments()Z

    move-result v8

    move-object/from16 v0, p1

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/UiProvider;->getConversationMessageListUri(Ljava/lang/String;J)Landroid/net/Uri;

    move-result-object v9

    move-object/from16 v0, p0

    invoke-static {v10, v0}, Lcom/google/android/gm/provider/UiProvider;->parseSendersFromSnippetInstructions(Ljava/lang/String;Landroid/content/Context;)Ljava/lang/String;

    move-result-object v10

    const/4 v12, 0x0

    const/4 v13, 0x0

    invoke-static/range {p2 .. p2}, Lcom/google/android/gm/provider/UiProvider;->getConversationPriority(Lcom/google/android/gm/provider/Gmail$ConversationCursor;)I

    move-result v14

    invoke-virtual/range {p2 .. p2}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getLabels()Ljava/util/Map;

    move-result-object v15

    const-string v16, "^u"

    invoke-interface/range {v15 .. v16}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v15

    if-nez v15, :cond_0

    const/4 v15, 0x1

    :goto_0
    invoke-virtual/range {p2 .. p2}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getLabels()Ljava/util/Map;

    move-result-object v16

    const-string v17, "^t"

    invoke-interface/range {v16 .. v17}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v16

    invoke-static/range {p1 .. p2}, Lcom/google/android/gm/provider/UiProvider;->getSerializedFolderString(Ljava/lang/String;Lcom/google/android/gm/provider/Gmail$ConversationCursor;)Ljava/lang/String;

    move-result-object v17

    const/16 v18, 0x0

    invoke-static/range {p2 .. p2}, Lcom/google/android/gm/provider/UiProvider;->getConversationPersonalLevel(Lcom/google/android/gm/provider/Gmail$ConversationCursor;)I

    move-result v19

    invoke-virtual/range {p2 .. p2}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getLabels()Ljava/util/Map;

    move-result-object v20

    const-string v21, "^s"

    invoke-interface/range {v20 .. v21}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v20

    invoke-virtual/range {p2 .. p2}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getLabels()Ljava/util/Map;

    move-result-object v21

    const-string v22, "^p"

    invoke-interface/range {v21 .. v22}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v21

    invoke-virtual/range {p2 .. p2}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getLabels()Ljava/util/Map;

    move-result-object v22

    const-string v23, "^g"

    invoke-interface/range {v22 .. v23}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v22

    invoke-static/range {p1 .. p1}, Lcom/google/android/gm/provider/UiProvider;->getAccountUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v23

    invoke-static/range {p1 .. p1}, Lcom/google/android/gm/provider/UiProvider;->getConversationBaseUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v25

    invoke-virtual/range {p2 .. p2}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->isSynced()Z

    move-result v26

    if-nez v26, :cond_1

    const/16 v26, 0x1

    :goto_1
    invoke-static/range {v1 .. v26}, Lcom/android/mail/providers/Conversation;->create(JLandroid/net/Uri;Ljava/lang/String;JLjava/lang/String;ZLandroid/net/Uri;Ljava/lang/String;IIIIZZLjava/lang/String;IIZZZLandroid/net/Uri;Lcom/android/mail/providers/ConversationInfo;Landroid/net/Uri;Z)Lcom/android/mail/providers/Conversation;

    move-result-object v1

    .line 2710
    return-object v1

    .line 2683
    :cond_0
    const/4 v15, 0x0

    goto :goto_0

    :cond_1
    const/16 v26, 0x0

    goto :goto_1
.end method

.method public static getConversationMessageListUri(Ljava/lang/String;J)Landroid/net/Uri;
    .locals 2
    .param p0, "account"    # Ljava/lang/String;
    .param p1, "conversationId"    # J

    .prologue
    .line 379
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "content://com.android.gmail.ui/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/conversationMessages/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method private static getConversationPersonalLevel(Lcom/google/android/gm/provider/Gmail$ConversationCursor;)I
    .locals 3
    .param p0, "conversationCursor"    # Lcom/google/android/gm/provider/Gmail$ConversationCursor;

    .prologue
    .line 2523
    const/4 v1, 0x0

    .line 2524
    .local v1, "translatedLevel":I
    invoke-virtual {p0}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getPersonalLevel()Lcom/google/android/gm/provider/Gmail$PersonalLevel;

    move-result-object v0

    .line 2526
    .local v0, "personalLevel":Lcom/google/android/gm/provider/Gmail$PersonalLevel;
    sget-object v2, Lcom/google/android/gm/provider/Gmail$PersonalLevel;->NOT_TO_ME:Lcom/google/android/gm/provider/Gmail$PersonalLevel;

    if-ne v0, v2, :cond_1

    .line 2527
    const/4 v1, 0x0

    .line 2533
    :cond_0
    :goto_0
    return v1

    .line 2528
    :cond_1
    sget-object v2, Lcom/google/android/gm/provider/Gmail$PersonalLevel;->ONLY_TO_ME:Lcom/google/android/gm/provider/Gmail$PersonalLevel;

    if-ne v0, v2, :cond_2

    .line 2529
    const/4 v1, 0x2

    goto :goto_0

    .line 2530
    :cond_2
    sget-object v2, Lcom/google/android/gm/provider/Gmail$PersonalLevel;->TO_ME_AND_OTHERS:Lcom/google/android/gm/provider/Gmail$PersonalLevel;

    if-ne v0, v2, :cond_0

    .line 2531
    const/4 v1, 0x1

    goto :goto_0
.end method

.method private static getConversationPriority(Lcom/google/android/gm/provider/Gmail$ConversationCursor;)I
    .locals 2

    .prologue
    .line 2663
    invoke-virtual {p0}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getLabels()Ljava/util/Map;

    move-result-object v0

    const-string v1, "^io_im"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    .line 2665
    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private getConversationState(Ljava/lang/String;J)Lcom/google/android/gm/provider/uiprovider/ConversationState;
    .locals 2
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "conversationId"    # J

    .prologue
    .line 2067
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/UiProvider;->getOrCreateAccountState(Ljava/lang/String;)Lcom/google/android/gm/provider/uiprovider/AccountState;

    move-result-object v0

    .line 2068
    .local v0, "accountState":Lcom/google/android/gm/provider/uiprovider/AccountState;
    invoke-virtual {p0}, Lcom/google/android/gm/provider/UiProvider;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0, v1, p2, p3}, Lcom/google/android/gm/provider/uiprovider/AccountState;->getOrCreateConversationState(Landroid/content/Context;J)Lcom/google/android/gm/provider/uiprovider/ConversationState;

    move-result-object v1

    return-object v1
.end method

.method public static getConversationUri(Ljava/lang/String;J)Landroid/net/Uri;
    .locals 2
    .param p0, "account"    # Ljava/lang/String;
    .param p1, "conversationId"    # J

    .prologue
    .line 375
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "content://com.android.gmail.ui/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/conversation/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method private getConversationsForLabel(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Integer;Z)Landroid/database/Cursor;
    .locals 8
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "url"    # Landroid/net/Uri;
    .param p3, "canonicalName"    # Ljava/lang/String;
    .param p4, "projection"    # [Ljava/lang/String;
    .param p5, "limit"    # Ljava/lang/Integer;
    .param p6, "accessNetwork"    # Z

    .prologue
    .line 2373
    invoke-static {p4}, Lcom/android/mail/providers/UIProviderValidator;->validateConversationProjection([Ljava/lang/String;)[Ljava/lang/String;

    .line 2375
    const/4 v3, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v4, p3

    move-object v5, p4

    move-object v6, p5

    move v7, p6

    invoke-direct/range {v0 .. v7}, Lcom/google/android/gm/provider/UiProvider;->getConversationsForQuery(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Integer;Z)Landroid/database/Cursor;

    move-result-object v0

    return-object v0
.end method

.method private getConversationsForLabelId(Ljava/lang/String;Landroid/net/Uri;J[Ljava/lang/String;Ljava/lang/Integer;Z)Landroid/database/Cursor;
    .locals 7

    .prologue
    .line 2357
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/UiProvider;->getOrMakeMailEngine(Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;

    move-result-object v0

    .line 2360
    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailEngine;->getLabelMap()Lcom/google/android/gm/provider/Gmail$LabelMap;

    move-result-object v0

    invoke-virtual {v0, p3, p4}, Lcom/google/android/gm/provider/Gmail$LabelMap;->getCanonicalName(J)Ljava/lang/String;

    move-result-object v3

    .line 2361
    if-nez v3, :cond_0

    .line 2363
    const-string v0, "Gmail"

    const-string v1, "Unknown canonical name: %s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v3, v2, v4

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 2364
    const/4 v0, 0x0

    .line 2367
    :goto_0
    return-object v0

    :cond_0
    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v4, p5

    move-object v5, p6

    move v6, p7

    invoke-direct/range {v0 .. v6}, Lcom/google/android/gm/provider/UiProvider;->getConversationsForLabel(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Integer;Z)Landroid/database/Cursor;

    move-result-object v0

    goto :goto_0
.end method

.method private getConversationsForQuery(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Integer;Z)Landroid/database/Cursor;
    .locals 11
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "url"    # Landroid/net/Uri;
    .param p3, "query"    # Ljava/lang/String;
    .param p4, "canonicalName"    # Ljava/lang/String;
    .param p5, "projection"    # [Ljava/lang/String;
    .param p6, "limit"    # Ljava/lang/Integer;
    .param p7, "accessNetwork"    # Z

    .prologue
    .line 2452
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/UiProvider;->getOrMakeMailEngine(Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;

    move-result-object v0

    .line 2454
    .local v0, "mailEngine":Lcom/google/android/gm/provider/MailEngine;
    invoke-static/range {p5 .. p5}, Lcom/android/mail/providers/UIProviderValidator;->validateConversationProjection([Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v8

    .line 2457
    .local v8, "resultProjection":[Ljava/lang/String;
    if-eqz p7, :cond_0

    const/4 v3, 0x0

    .line 2460
    .local v3, "selectionArgs":[Ljava/lang/String;
    :goto_0
    invoke-static {p3, p4}, Lcom/google/android/gm/Utils;->makeQueryString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 2461
    .local v2, "queryString":Ljava/lang/String;
    const/4 v1, 0x0

    const/4 v5, 0x0

    move-object/from16 v4, p6

    invoke-virtual/range {v0 .. v5}, Lcom/google/android/gm/provider/MailEngine;->getConversationCursorForQuery([Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Integer;Z)Landroid/database/Cursor;

    move-result-object v9

    .local v9, "conversationCursor":Landroid/database/Cursor;
    move-object v4, p0

    move-object v5, p1

    move-object v6, v0

    move-object v7, p2

    move/from16 v10, p7

    .line 2464
    invoke-direct/range {v4 .. v10}, Lcom/google/android/gm/provider/UiProvider;->getUiConversationCursor(Ljava/lang/String;Lcom/google/android/gm/provider/MailEngine;Landroid/net/Uri;[Ljava/lang/String;Landroid/database/Cursor;Z)Landroid/database/Cursor;

    move-result-object v1

    return-object v1

    .line 2457
    .end local v2    # "queryString":Ljava/lang/String;
    .end local v3    # "selectionArgs":[Ljava/lang/String;
    .end local v9    # "conversationCursor":Landroid/database/Cursor;
    :cond_0
    sget-object v3, Lcom/google/android/gm/provider/UiProvider;->CONVERSATION_QUERY_LOCAL_ONLY_SELECTION_ARGS:[Ljava/lang/String;

    goto :goto_0
.end method

.method private static getDefaultRecentFoldersUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 2
    .param p0, "account"    # Ljava/lang/String;

    .prologue
    .line 494
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "content://com.android.gmail.ui/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/defaultRecentFolders"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method private static getEmailAddress(Ljava/lang/String;)Lcom/google/android/gm/EmailAddress;
    .locals 1
    .param p0, "rawAddress"    # Ljava/lang/String;

    .prologue
    .line 2784
    invoke-static {p0}, Lcom/google/android/gm/EmailAddress;->getEmailAddress(Ljava/lang/String;)Lcom/google/android/gm/EmailAddress;

    move-result-object v0

    return-object v0
.end method

.method private getFakeSearchFolder(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    .locals 12

    .prologue
    .line 2382
    invoke-direct {p0, p2}, Lcom/google/android/gm/provider/UiProvider;->getOrCreateAccountState(Ljava/lang/String;)Lcom/google/android/gm/provider/uiprovider/AccountState;

    move-result-object v1

    .line 2384
    invoke-static {}, Lcom/android/mail/providers/Folder;->newUnsafeInstance()Lcom/android/mail/providers/Folder;

    move-result-object v2

    .line 2385
    invoke-static {p2}, Lcom/google/android/gm/provider/UiProvider;->getAccountConversationSearchUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    .line 2386
    const-string v3, "query"

    invoke-virtual {v0, v3, p3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 2387
    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    iput-object v0, v2, Lcom/android/mail/providers/Folder;->conversationListUri:Landroid/net/Uri;

    .line 2388
    const-string v0, "search"

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    iput v0, v2, Lcom/android/mail/providers/Folder;->id:I

    .line 2389
    new-instance v3, Landroid/database/MatrixCursor;

    sget-object v0, Lcom/android/mail/providers/UIProvider;->FOLDERS_PROJECTION:[Ljava/lang/String;

    const/4 v4, 0x1

    invoke-direct {v3, v0, v4}, Landroid/database/MatrixCursor;-><init>([Ljava/lang/String;I)V

    .line 2390
    invoke-virtual {v3}, Landroid/database/MatrixCursor;->newRow()Landroid/database/MatrixCursor$RowBuilder;

    move-result-object v4

    .line 2391
    sget-object v5, Lcom/android/mail/providers/UIProvider;->FOLDERS_PROJECTION:[Ljava/lang/String;

    array-length v6, v5

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v6, :cond_13

    aget-object v7, v5, v0

    .line 2392
    const-string v8, "_id"

    invoke-static {v7, v8}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v8

    if-eqz v8, :cond_0

    .line 2393
    iget v7, v2, Lcom/android/mail/providers/Folder;->id:I

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-virtual {v4, v7}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    .line 2391
    :goto_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 2394
    :cond_0
    const-string v8, "folderUri"

    invoke-static {v7, v8}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v8

    if-eqz v8, :cond_1

    .line 2395
    invoke-virtual {v4, p1}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto :goto_1

    .line 2396
    :cond_1
    const-string v8, "name"

    invoke-static {v7, v8}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v8

    if-eqz v8, :cond_2

    .line 2397
    const-string v7, "search"

    invoke-virtual {v4, v7}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto :goto_1

    .line 2398
    :cond_2
    const-string v8, "unreadCount"

    invoke-static {v7, v8}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v8

    if-eqz v8, :cond_3

    .line 2399
    const/4 v7, 0x0

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-virtual {v4, v7}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto :goto_1

    .line 2400
    :cond_3
    const-string v8, "totalCount"

    invoke-static {v7, v8}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v8

    if-eqz v8, :cond_4

    .line 2401
    invoke-virtual {v1, p3}, Lcom/google/android/gm/provider/uiprovider/AccountState;->getNumSearchResults(Ljava/lang/String;)I

    move-result v7

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-virtual {v4, v7}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto :goto_1

    .line 2402
    :cond_4
    sget-object v8, Lcom/android/mail/providers/UIProvider$FolderColumns;->HAS_CHILDREN:Ljava/lang/String;

    invoke-static {v7, v8}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v8

    if-eqz v8, :cond_5

    .line 2405
    const/4 v7, 0x0

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-virtual {v4, v7}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto :goto_1

    .line 2406
    :cond_5
    sget-object v8, Lcom/android/mail/providers/UIProvider$FolderColumns;->CAPABILITIES:Ljava/lang/String;

    invoke-static {v7, v8}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v8

    if-eqz v8, :cond_6

    .line 2407
    const/16 v7, 0x260

    .line 2410
    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-virtual {v4, v7}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto :goto_1

    .line 2411
    :cond_6
    sget-object v8, Lcom/android/mail/providers/UIProvider$FolderColumns;->SYNC_WINDOW:Ljava/lang/String;

    invoke-static {v7, v8}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v8

    if-eqz v8, :cond_7

    .line 2413
    const/4 v7, 0x0

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-virtual {v4, v7}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto :goto_1

    .line 2414
    :cond_7
    const-string v8, "conversationListUri"

    invoke-static {v7, v8}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v8

    if-eqz v8, :cond_8

    .line 2415
    iget-object v7, v2, Lcom/android/mail/providers/Folder;->conversationListUri:Landroid/net/Uri;

    invoke-virtual {v4, v7}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 2416
    :cond_8
    const-string v8, "childFoldersListUri"

    invoke-static {v7, v8}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v8

    if-eqz v8, :cond_9

    .line 2417
    const/4 v7, 0x0

    invoke-virtual {v4, v7}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 2418
    :cond_9
    const-string v8, "refreshUri"

    invoke-static {v7, v8}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v8

    if-eqz v8, :cond_a

    .line 2419
    iget-object v7, v2, Lcom/android/mail/providers/Folder;->conversationListUri:Landroid/net/Uri;

    invoke-virtual {v4, v7}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 2420
    :cond_a
    const-string v8, "syncStatus"

    invoke-static {v7, v8}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v8

    if-eqz v8, :cond_b

    .line 2423
    const/4 v7, 0x0

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-virtual {v4, v7}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 2424
    :cond_b
    const-string v8, "lastSyncResult"

    invoke-static {v7, v8}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v8

    if-eqz v8, :cond_c

    .line 2426
    const/4 v7, 0x0

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-virtual {v4, v7}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 2427
    :cond_c
    const-string v8, "type"

    invoke-static {v7, v8}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v8

    if-eqz v8, :cond_d

    .line 2429
    const/4 v7, 0x0

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-virtual {v4, v7}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 2430
    :cond_d
    const-string v8, "iconResId"

    invoke-static {v7, v8}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v8

    if-eqz v8, :cond_e

    .line 2432
    const/4 v7, 0x0

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-virtual {v4, v7}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 2433
    :cond_e
    const-string v8, "bgColor"

    invoke-static {v7, v8}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v8

    if-eqz v8, :cond_f

    .line 2435
    const/4 v7, 0x0

    invoke-virtual {v4, v7}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 2436
    :cond_f
    const-string v8, "fgColor"

    invoke-static {v7, v8}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v8

    if-eqz v8, :cond_10

    .line 2438
    const/4 v7, 0x0

    invoke-virtual {v4, v7}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 2439
    :cond_10
    const-string v8, "loadMoreUri"

    invoke-static {v7, v8}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v8

    if-eqz v8, :cond_11

    .line 2440
    const/4 v7, 0x0

    invoke-virtual {v4, v7}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 2441
    :cond_11
    const-string v8, "hierarchicalDesc"

    invoke-static {v7, v8}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v8

    if-eqz v8, :cond_12

    .line 2442
    const-string v7, "search"

    invoke-virtual {v4, v7}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 2444
    :cond_12
    const-string v8, "Gmail"

    const-string v9, "unexpected column: %s"

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    aput-object v7, v10, v11

    invoke-static {v8, v9, v10}, Lcom/google/android/gm/provider/LogUtils;->wtf(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto/16 :goto_1

    .line 2447
    :cond_13
    return-object v3
.end method

.method public static getFolderType(ZLjava/lang/String;)I
    .locals 2

    .prologue
    const/4 v0, 0x0

    .line 2636
    .line 2637
    const-string v1, "^t"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 2638
    const/4 v0, 0x7

    .line 2659
    :cond_0
    :goto_0
    return v0

    .line 2640
    :cond_1
    if-eqz p0, :cond_0

    .line 2642
    const-string v1, "^i"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    const-string v1, "^iim"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 2643
    :cond_2
    const/4 v0, 0x1

    goto :goto_0

    .line 2644
    :cond_3
    const-string v1, "^r"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 2645
    const/4 v0, 0x2

    goto :goto_0

    .line 2646
    :cond_4
    const-string v1, "^^out"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 2647
    const/4 v0, 0x3

    goto :goto_0

    .line 2648
    :cond_5
    const-string v1, "^f"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_6

    .line 2649
    const/4 v0, 0x4

    goto :goto_0

    .line 2650
    :cond_6
    const-string v1, "^k"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_7

    .line 2651
    const/4 v0, 0x5

    goto :goto_0

    .line 2652
    :cond_7
    const-string v1, "^s"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_8

    .line 2653
    const/4 v0, 0x6

    goto :goto_0

    .line 2654
    :cond_8
    const-string v1, "^all"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_9

    .line 2655
    const/16 v0, 0x9

    goto :goto_0

    .line 2656
    :cond_9
    const-string v1, "^im"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 2657
    const/16 v0, 0x8

    goto :goto_0
.end method

.method private static getHelpUri(Landroid/content/Context;)Landroid/net/Uri;
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 467
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    const-string v2, "gmail_context_sensitive_help_url"

    const-string v3, "http://support.google.com/mobile/?hl=%locale%"

    invoke-static {v1, v2, v3}, Lcom/google/android/gsf/Gservices;->getString(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 469
    .local v0, "url":Ljava/lang/String;
    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    return-object v1
.end method

.method public static getLabelConversationListFromNameUri(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;
    .locals 2
    .param p0, "account"    # Ljava/lang/String;
    .param p1, "canonicalName"    # Ljava/lang/String;

    .prologue
    .line 346
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "content://com.android.gmail.ui/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/conversationsForLabel/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method public static getLabelConversationListUri(Ljava/lang/String;I)Landroid/net/Uri;
    .locals 2
    .param p0, "account"    # Ljava/lang/String;
    .param p1, "labelId"    # I

    .prologue
    .line 342
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "content://com.android.gmail.ui/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/conversations/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method private static final getLabelFromCanonical(Landroid/content/Context;Lcom/google/android/gm/provider/Gmail$LabelMap;Ljava/lang/String;Ljava/lang/String;Z)Landroid/util/Pair;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/google/android/gm/provider/Gmail$LabelMap;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Z)",
            "Landroid/util/Pair",
            "<",
            "Ljava/lang/Long;",
            "Ljava/lang/CharSequence;",
            ">;"
        }
    .end annotation

    .prologue
    const-wide/16 v1, -0x1

    .line 1906
    if-eqz p4, :cond_0

    .line 1908
    invoke-static {p0, p3}, Lcom/google/android/gm/provider/UiProvider;->getSystemLabelName(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/CharSequence;

    move-result-object v0

    .line 1928
    :goto_0
    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-static {v1, v0}, Landroid/util/Pair;->create(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;

    move-result-object v0

    return-object v0

    .line 1910
    :cond_0
    if-eqz p1, :cond_1

    .line 1911
    invoke-virtual {p1, p3}, Lcom/google/android/gm/provider/Gmail$LabelMap;->getLabelId(Ljava/lang/String;)J

    move-result-wide v1

    .line 1912
    invoke-virtual {p1, v1, v2}, Lcom/google/android/gm/provider/Gmail$LabelMap;->getName(J)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1916
    :cond_1
    invoke-static {p0, p2, p3}, Lcom/google/android/gm/provider/LabelManager;->getLabel(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gm/provider/Label;

    move-result-object v0

    .line 1917
    if-eqz v0, :cond_2

    .line 1918
    invoke-virtual {v0}, Lcom/google/android/gm/provider/Label;->getId()J

    move-result-wide v1

    .line 1919
    invoke-virtual {v0}, Lcom/google/android/gm/provider/Label;->getName()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1921
    :cond_2
    const-string v0, "Gmail"

    const-string v3, "Couldn\'t find label: %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-static {p3}, Lcom/google/android/gm/provider/LogUtils;->sanitizeLabelName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v0, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1924
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static getLabelRefreshUri(Ljava/lang/String;Landroid/net/Uri;)Landroid/net/Uri;
    .locals 2
    .param p0, "account"    # Ljava/lang/String;
    .param p1, "labelUri"    # Landroid/net/Uri;

    .prologue
    .line 431
    invoke-static {p0}, Lcom/google/android/gm/provider/UiProvider;->getAccountRefreshUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v1}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    .line 432
    .local v0, "builder":Landroid/net/Uri$Builder;
    invoke-virtual {p1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->appendPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 434
    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v1

    return-object v1
.end method

.method public static getMessageAttachmentUri(Ljava/lang/String;JJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;
    .locals 3
    .param p0, "account"    # Ljava/lang/String;
    .param p1, "conversationId"    # J
    .param p3, "serverMessageId"    # J
    .param p5, "localMessageId"    # J
    .param p7, "partId"    # Ljava/lang/String;
    .param p8, "mimeType"    # Ljava/lang/String;
    .param p9, "joinedAttachmentInfo"    # Ljava/lang/String;

    .prologue
    .line 401
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "content://com.android.gmail.ui/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/messageAttachment/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p5, p6}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v1}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    .line 405
    .local v0, "builder":Landroid/net/Uri$Builder;
    const-string v1, "serverMessageId"

    invoke-static {p3, p4}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 408
    invoke-static {p8}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 409
    const-string v1, "mimeType"

    invoke-virtual {v0, v1, p8}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 411
    :cond_0
    invoke-static {p9}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 412
    const-string v1, "gmailJoinedAttachment"

    invoke-virtual {v0, v1, p9}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 414
    :cond_1
    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v1

    return-object v1
.end method

.method private getMessageAttachments(Lcom/google/android/gm/provider/uiprovider/UIAttachment$UriParser;[Ljava/lang/String;)Landroid/database/Cursor;
    .locals 16

    .prologue
    .line 1989
    move-object/from16 v0, p1

    iget-wide v3, v0, Lcom/google/android/gm/provider/uiprovider/UIAttachment$UriParser;->mConversationId:J

    .line 1990
    move-object/from16 v0, p1

    iget-object v2, v0, Lcom/google/android/gm/provider/uiprovider/UIAttachment$UriParser;->mAccount:Ljava/lang/String;

    .line 1991
    move-object/from16 v0, p1

    iget-object v12, v0, Lcom/google/android/gm/provider/uiprovider/UIAttachment$UriParser;->mPartId:Ljava/lang/String;

    .line 1992
    move-object/from16 v0, p1

    iget-wide v7, v0, Lcom/google/android/gm/provider/uiprovider/UIAttachment$UriParser;->mLocalMessageId:J

    .line 1993
    move-object/from16 v0, p1

    iget-wide v5, v0, Lcom/google/android/gm/provider/uiprovider/UIAttachment$UriParser;->mMessageId:J

    .line 1994
    move-object/from16 v0, p1

    iget-object v13, v0, Lcom/google/android/gm/provider/uiprovider/UIAttachment$UriParser;->mContentTypeQueryParameters:Ljava/util/List;

    .line 1996
    invoke-static/range {p2 .. p2}, Lcom/android/mail/providers/UIProviderValidator;->validateAttachmentProjection([Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v9

    .line 2005
    move-object/from16 v0, p0

    invoke-direct {v0, v2, v3, v4}, Lcom/google/android/gm/provider/UiProvider;->getConversationState(Ljava/lang/String;J)Lcom/google/android/gm/provider/uiprovider/ConversationState;

    move-result-object v1

    .line 2007
    move-object/from16 v0, p0

    invoke-direct {v0, v2}, Lcom/google/android/gm/provider/UiProvider;->getOrMakeMailEngine(Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;

    .line 2009
    move-object/from16 v0, p1

    invoke-virtual {v1, v0}, Lcom/google/android/gm/provider/uiprovider/ConversationState;->getOrCreateMessageState(Lcom/google/android/gm/provider/uiprovider/UIAttachment$UriParser;)Lcom/google/android/gm/provider/uiprovider/MessageState;

    move-result-object v1

    .line 2011
    if-eqz v1, :cond_4

    .line 2013
    invoke-virtual {v1}, Lcom/google/android/gm/provider/uiprovider/MessageState;->getMessageAttachments()Ljava/util/List;

    move-result-object v10

    .line 2020
    :goto_0
    if-eqz v10, :cond_1

    invoke-interface {v10}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_1

    invoke-static {v12}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 2021
    const-string v1, "Gmail"

    const-string v11, "Looking for attachment partId: %s"

    const/4 v14, 0x1

    new-array v14, v14, [Ljava/lang/Object;

    const/4 v15, 0x0

    aput-object v12, v14, v15

    invoke-static {v1, v11, v14}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 2023
    const/4 v11, 0x0

    .line 2024
    invoke-interface {v10}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v10

    :cond_0
    invoke-interface {v10}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_8

    invoke-interface {v10}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gm/provider/uiprovider/UIAttachment;

    .line 2025
    invoke-interface {v1}, Lcom/google/android/gm/provider/uiprovider/UIAttachment;->getPartId()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v12, v14}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v14

    if-eqz v14, :cond_0

    .line 2027
    const-string v10, "Gmail"

    const-string v11, "Found attachment"

    const/4 v12, 0x0

    new-array v12, v12, [Ljava/lang/Object;

    invoke-static {v10, v11, v12}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 2036
    :goto_1
    if-eqz v1, :cond_5

    invoke-static {v1}, Ljava/util/Collections;->singletonList(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    :goto_2
    move-object v10, v1

    .line 2042
    :cond_1
    if-eqz v10, :cond_7

    invoke-interface {v10}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_7

    if-eqz v13, :cond_7

    invoke-interface {v13}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_7

    .line 2044
    new-instance v11, Ljava/util/ArrayList;

    invoke-direct {v11}, Ljava/util/ArrayList;-><init>()V

    .line 2046
    invoke-interface {v10}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v12

    :cond_2
    :goto_3
    invoke-interface {v12}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_6

    invoke-interface {v12}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gm/provider/uiprovider/UIAttachment;

    .line 2047
    invoke-interface {v13}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v14

    :cond_3
    invoke-interface {v14}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-eqz v10, :cond_2

    invoke-interface {v14}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Ljava/lang/String;

    .line 2048
    invoke-interface {v1}, Lcom/google/android/gm/provider/uiprovider/UIAttachment;->getContentType()Ljava/lang/String;

    move-result-object v15

    .line 2049
    if-eqz v15, :cond_3

    invoke-virtual {v15, v10}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_3

    .line 2051
    invoke-interface {v11, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_3

    .line 2015
    :cond_4
    const-string v1, "Gmail"

    const-string v10, "Couldn\'t find Message State, returning empty attachment list"

    const/4 v11, 0x0

    new-array v11, v11, [Ljava/lang/Object;

    invoke-static {v1, v10, v11}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 2016
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v10

    goto/16 :goto_0

    .line 2036
    :cond_5
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v1

    goto :goto_2

    :cond_6
    move-object v10, v11

    :cond_7
    move-object/from16 v1, p0

    .line 2061
    invoke-direct/range {v1 .. v10}, Lcom/google/android/gm/provider/UiProvider;->getUiAttachmentsCursorForUIAttachments(Ljava/lang/String;JJJ[Ljava/lang/String;Ljava/util/List;)Landroid/database/Cursor;

    move-result-object v1

    return-object v1

    :cond_8
    move-object v1, v11

    goto :goto_1
.end method

.method public static getMessageAttachmentsUri(Ljava/lang/String;JJJ)Landroid/net/Uri;
    .locals 3
    .param p0, "account"    # Ljava/lang/String;
    .param p1, "conversationId"    # J
    .param p3, "serverMessageId"    # J
    .param p5, "localMessageId"    # J

    .prologue
    .line 390
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "content://com.android.gmail.ui/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/messageAttachments/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p5, p6}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    const-string v1, "serverMessageId"

    invoke-static {p3, p4}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method public static getMessageByIdUri(Ljava/lang/String;J)Landroid/net/Uri;
    .locals 2
    .param p0, "account"    # Ljava/lang/String;
    .param p1, "messageId"    # J

    .prologue
    .line 384
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "content://com.android.gmail.ui/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/message/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method private getMessageForId(Ljava/lang/String;J)Landroid/database/Cursor;
    .locals 8
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "localMessageId"    # J

    .prologue
    .line 2493
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/UiProvider;->getOrMakeMailEngine(Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;

    move-result-object v7

    .line 2494
    .local v7, "mailEngine":Lcom/google/android/gm/provider/MailEngine;
    invoke-static {}, Lcom/google/android/gm/persistence/Persistence;->getInstance()Lcom/google/android/gm/persistence/Persistence;

    move-result-object v4

    .line 2496
    .local v4, "persistence":Lcom/google/android/gm/persistence/Persistence;
    sget-object v0, Lcom/google/android/gm/provider/Gmail;->MESSAGE_PROJECTION:[Ljava/lang/String;

    invoke-virtual {v7, v0, p2, p3}, Lcom/google/android/gm/provider/MailEngine;->getMessageCursorForLocalMessageId([Ljava/lang/String;J)Landroid/database/Cursor;

    move-result-object v2

    .line 2498
    .local v2, "messageCursor":Landroid/database/Cursor;
    if-nez v2, :cond_0

    const/4 v0, 0x0

    .line 2499
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;

    invoke-virtual {p0}, Lcom/google/android/gm/provider/UiProvider;->getContext()Landroid/content/Context;

    move-result-object v1

    sget-object v5, Lcom/google/android/gm/provider/UiProvider;->sGmailQuote:Ljava/lang/String;

    sget-object v6, Lcom/android/mail/providers/UIProvider;->MESSAGE_PROJECTION:[Ljava/lang/String;

    move-object v3, p1

    invoke-direct/range {v0 .. v6}, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;-><init>(Landroid/content/Context;Landroid/database/Cursor;Ljava/lang/String;Lcom/google/android/gm/persistence/Persistence;Ljava/lang/String;[Ljava/lang/String;)V

    goto :goto_0
.end method

.method private getMessagesForConversation(Ljava/lang/String;J[Ljava/lang/String;Z)Landroid/database/Cursor;
    .locals 12
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "conversationId"    # J
    .param p4, "projection"    # [Ljava/lang/String;
    .param p5, "useNetwork"    # Z

    .prologue
    .line 2470
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/UiProvider;->getOrMakeMailEngine(Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;

    move-result-object v0

    .line 2473
    .local v0, "mailEngine":Lcom/google/android/gm/provider/MailEngine;
    if-nez p5, :cond_0

    const/4 v4, 0x1

    .line 2475
    .local v4, "useCache":Z
    :goto_0
    invoke-static {}, Lcom/google/android/gm/persistence/Persistence;->getInstance()Lcom/google/android/gm/persistence/Persistence;

    move-result-object v9

    .line 2476
    .local v9, "persistence":Lcom/google/android/gm/persistence/Persistence;
    invoke-static/range {p4 .. p4}, Lcom/android/mail/providers/UIProviderValidator;->validateMessageProjection([Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v11

    .line 2479
    .local v11, "resultProjection":[Ljava/lang/String;
    sget-object v1, Lcom/google/android/gm/provider/Gmail;->MESSAGE_PROJECTION:[Ljava/lang/String;

    const/4 v5, 0x0

    move-wide v2, p2

    invoke-virtual/range {v0 .. v5}, Lcom/google/android/gm/provider/MailEngine;->getMessageCursorForConversationId([Ljava/lang/String;JZZ)Landroid/database/Cursor;

    move-result-object v7

    .line 2482
    .local v7, "messageCursor":Landroid/database/Cursor;
    if-nez v7, :cond_1

    const/4 v5, 0x0

    .line 2489
    :goto_1
    return-object v5

    .line 2473
    .end local v4    # "useCache":Z
    .end local v7    # "messageCursor":Landroid/database/Cursor;
    .end local v9    # "persistence":Lcom/google/android/gm/persistence/Persistence;
    .end local v11    # "resultProjection":[Ljava/lang/String;
    :cond_0
    const/4 v4, 0x0

    goto :goto_0

    .line 2483
    .restart local v4    # "useCache":Z
    .restart local v7    # "messageCursor":Landroid/database/Cursor;
    .restart local v9    # "persistence":Lcom/google/android/gm/persistence/Persistence;
    .restart local v11    # "resultProjection":[Ljava/lang/String;
    :cond_1
    new-instance v5, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;

    invoke-virtual {p0}, Lcom/google/android/gm/provider/UiProvider;->getContext()Landroid/content/Context;

    move-result-object v6

    sget-object v10, Lcom/google/android/gm/provider/UiProvider;->sGmailQuote:Ljava/lang/String;

    move-object v8, p1

    invoke-direct/range {v5 .. v11}, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;-><init>(Landroid/content/Context;Landroid/database/Cursor;Ljava/lang/String;Lcom/google/android/gm/persistence/Persistence;Ljava/lang/String;[Ljava/lang/String;)V

    .line 2486
    .local v5, "result":Landroid/database/Cursor;
    iget-object v1, p0, Lcom/google/android/gm/provider/UiProvider;->mContentResolver:Landroid/content/ContentResolver;

    invoke-static {p1, p2, p3}, Lcom/google/android/gm/provider/UiProvider;->getConversationMessageListUri(Ljava/lang/String;J)Landroid/net/Uri;

    move-result-object v2

    invoke-interface {v5, v1, v2}, Landroid/database/Cursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    goto :goto_1
.end method

.method private getOrCreateAccountState(Ljava/lang/String;)Lcom/google/android/gm/provider/uiprovider/AccountState;
    .locals 4
    .param p1, "account"    # Ljava/lang/String;

    .prologue
    .line 2073
    sget-object v3, Lcom/google/android/gm/provider/UiProvider;->sAccountStateMap:Ljava/util/Map;

    monitor-enter v3

    .line 2074
    :try_start_0
    sget-object v2, Lcom/google/android/gm/provider/UiProvider;->sAccountStateMap:Ljava/util/Map;

    invoke-interface {v2, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 2075
    sget-object v2, Lcom/google/android/gm/provider/UiProvider;->sAccountStateMap:Ljava/util/Map;

    invoke-interface {v2, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gm/provider/uiprovider/AccountState;

    .line 2081
    .local v0, "accountState":Lcom/google/android/gm/provider/uiprovider/AccountState;
    :goto_0
    monitor-exit v3

    .line 2082
    return-object v0

    .line 2077
    .end local v0    # "accountState":Lcom/google/android/gm/provider/uiprovider/AccountState;
    :cond_0
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/UiProvider;->getOrMakeMailEngine(Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;

    move-result-object v1

    .line 2078
    .local v1, "engine":Lcom/google/android/gm/provider/MailEngine;
    new-instance v0, Lcom/google/android/gm/provider/uiprovider/AccountState;

    iget-object v2, p0, Lcom/google/android/gm/provider/UiProvider;->mUiProviderHandler:Landroid/os/Handler;

    invoke-direct {v0, p1, v2, v1}, Lcom/google/android/gm/provider/uiprovider/AccountState;-><init>(Ljava/lang/String;Landroid/os/Handler;Lcom/google/android/gm/provider/MailEngine;)V

    .line 2079
    .restart local v0    # "accountState":Lcom/google/android/gm/provider/uiprovider/AccountState;
    sget-object v2, Lcom/google/android/gm/provider/UiProvider;->sAccountStateMap:Ljava/util/Map;

    invoke-interface {v2, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 2081
    .end local v0    # "accountState":Lcom/google/android/gm/provider/uiprovider/AccountState;
    .end local v1    # "engine":Lcom/google/android/gm/provider/MailEngine;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2
.end method

.method private getOrMakeMailEngine(Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;
    .locals 2

    .prologue
    .line 1403
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1404
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "account is empty"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1406
    :cond_0
    invoke-virtual {p0}, Lcom/google/android/gm/provider/UiProvider;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, p1}, Lcom/google/android/gm/provider/MailEngine;->getOrMakeMailEngine(Landroid/content/Context;Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;

    move-result-object v0

    return-object v0
.end method

.method private static getRawOperations(Lcom/google/android/gm/ConversationInfo;Lcom/google/android/gm/provider/Label;Z)Ljava/util/Map;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gm/ConversationInfo;",
            "Lcom/google/android/gm/provider/Label;",
            "Z)",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 1317
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v3

    .line 1318
    invoke-virtual {p1}, Lcom/google/android/gm/provider/Label;->getCanonicalName()Ljava/lang/String;

    move-result-object v4

    .line 1319
    invoke-static {p2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-interface {v3, v4, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1323
    const-string v0, "^k"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "^g"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1325
    :cond_0
    if-nez p2, :cond_b

    move v0, v1

    .line 1329
    :goto_0
    const-string v5, "^i"

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-interface {v3, v5, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1333
    :cond_1
    const-string v0, "^p"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    if-eqz p2, :cond_2

    .line 1334
    const-string v0, "^i"

    sget-object v5, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-interface {v3, v0, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1335
    const-string v0, "^s"

    sget-object v5, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-interface {v3, v0, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1339
    :cond_2
    const-string v0, "^i"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    if-eqz p2, :cond_3

    .line 1340
    const-string v0, "^s"

    sget-object v5, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-interface {v3, v0, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1341
    const-string v0, "^k"

    sget-object v5, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-interface {v3, v0, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1345
    :cond_3
    const-string v0, "^^important"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    if-nez p2, :cond_5

    :cond_4
    const-string v0, "^^unimportant"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_c

    if-nez p2, :cond_c

    :cond_5
    move v0, v1

    .line 1348
    :goto_1
    const-string v5, "^^unimportant"

    invoke-virtual {v5, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_6

    if-nez p2, :cond_7

    :cond_6
    const-string v5, "^^important"

    invoke-virtual {v5, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_8

    if-nez p2, :cond_8

    :cond_7
    move v2, v1

    .line 1352
    :cond_8
    if-eqz v0, :cond_d

    .line 1353
    const-string v0, "^im"

    sget-object v1, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-interface {v3, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1354
    const-string v0, "^io_im"

    sget-object v1, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-interface {v3, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1355
    const-string v0, "^imi"

    sget-object v1, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-interface {v3, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1356
    const-string v0, "^imn"

    sget-object v1, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-interface {v3, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1357
    const-string v0, "^io_ns"

    sget-object v1, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-interface {v3, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1363
    invoke-virtual {p0}, Lcom/google/android/gm/ConversationInfo;->getLabels()Ljava/util/Map;

    move-result-object v0

    const-string v1, "^i"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 1364
    const-string v0, "^iim"

    sget-object v1, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-interface {v3, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1377
    :cond_9
    :goto_2
    const-string v0, "^i"

    invoke-interface {v3, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_a

    invoke-virtual {p0}, Lcom/google/android/gm/ConversationInfo;->isImportant()Z

    move-result v0

    if-eqz v0, :cond_a

    .line 1378
    const-string v0, "^i"

    invoke-interface {v3, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    .line 1379
    const-string v1, "^iim"

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-interface {v3, v1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1382
    :cond_a
    return-object v3

    :cond_b
    move v0, v2

    .line 1325
    goto/16 :goto_0

    :cond_c
    move v0, v2

    .line 1345
    goto :goto_1

    .line 1366
    :cond_d
    if-eqz v2, :cond_9

    .line 1367
    const-string v0, "^imn"

    sget-object v1, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-interface {v3, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1368
    const-string v0, "^im"

    sget-object v1, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-interface {v3, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1369
    const-string v0, "^io_im"

    sget-object v1, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-interface {v3, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1370
    const-string v0, "^iim"

    sget-object v1, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-interface {v3, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1371
    const-string v0, "^imi"

    sget-object v1, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-interface {v3, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1372
    const-string v0, "^io_ns"

    sget-object v1, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-interface {v3, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_2
.end method

.method private static getReauthenticateUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 2
    .param p0, "account"    # Ljava/lang/String;

    .prologue
    .line 479
    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->BASE_AUTH_URI:Landroid/net/Uri;

    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    const-string v1, "account"

    invoke-virtual {v0, v1, p0}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method private static getRecentFoldersUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 2
    .param p0, "account"    # Ljava/lang/String;

    .prologue
    .line 490
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "content://com.android.gmail.ui/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/recentFolders"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method private getRecentLabelsCursor(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    .locals 8
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "projection"    # [Ljava/lang/String;

    .prologue
    .line 2794
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/UiProvider;->getOrMakeMailEngine(Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;

    move-result-object v3

    .line 2795
    .local v3, "mailEngine":Lcom/google/android/gm/provider/MailEngine;
    invoke-static {p2}, Lcom/android/mail/providers/UIProviderValidator;->validateFolderProjection([Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v4

    .line 2798
    .local v4, "resultProjection":[Ljava/lang/String;
    sget-object v5, Lcom/google/android/gm/provider/Gmail;->LABEL_PROJECTION:[Ljava/lang/String;

    invoke-virtual {v3, v5}, Lcom/google/android/gm/provider/MailEngine;->getLabelQueryBuilder([Ljava/lang/String;)Lcom/google/android/gm/provider/LabelQueryBuilder;

    move-result-object v5

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Lcom/google/android/gm/provider/LabelQueryBuilder;->showHidden(Z)Lcom/google/android/gm/provider/LabelQueryBuilder;

    move-result-object v0

    .line 2802
    .local v0, "builder":Lcom/google/android/gm/provider/LabelQueryBuilder;
    const/16 v2, 0xa

    .line 2803
    .local v2, "limit":I
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    const/16 v7, 0xa

    invoke-virtual {v0, v5, v6, v7}, Lcom/google/android/gm/provider/LabelQueryBuilder;->setRecent(JI)Lcom/google/android/gm/provider/LabelQueryBuilder;

    .line 2804
    invoke-virtual {v0}, Lcom/google/android/gm/provider/LabelQueryBuilder;->query()Landroid/database/Cursor;

    move-result-object v1

    .line 2805
    .local v1, "labelCursor":Landroid/database/Cursor;
    invoke-static {v3, p1, v4, v1}, Lcom/google/android/gm/provider/UiProvider;->getUiLabelCursor(Lcom/google/android/gm/provider/MailEngine;Ljava/lang/String;[Ljava/lang/String;Landroid/database/Cursor;)Landroid/database/Cursor;

    move-result-object v5

    return-object v5
.end method

.method public static getSaveMessageUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 2
    .param p0, "account"    # Ljava/lang/String;

    .prologue
    .line 422
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "content://com.android.gmail.ui/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/message/save"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method public static getSendMessageUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 2
    .param p0, "account"    # Ljava/lang/String;

    .prologue
    .line 418
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "content://com.android.gmail.ui/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/message/send"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method private static getSerializedFolderString(Ljava/lang/String;Lcom/google/android/gm/provider/Gmail$ConversationCursor;)Ljava/lang/String;
    .locals 2
    .param p0, "account"    # Ljava/lang/String;
    .param p1, "conversationCursor"    # Lcom/google/android/gm/provider/Gmail$ConversationCursor;

    .prologue
    const/4 v1, 0x0

    .line 2553
    invoke-virtual {p1}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getLabels()Ljava/util/Map;

    move-result-object v0

    .line 2554
    .local v0, "labels":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/google/android/gm/provider/Label;>;"
    invoke-static {p0, v0, v1, v1}, Lcom/google/android/gm/provider/UiProvider;->getSerializedFolderString(Ljava/lang/String;Ljava/util/Map;Landroid/util/SparseArray;Ljava/util/Map;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public static getSerializedFolderString(Ljava/lang/String;Ljava/util/Map;Landroid/util/SparseArray;Ljava/util/Map;)Ljava/lang/String;
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/gm/provider/Label;",
            ">;",
            "Landroid/util/SparseArray",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "[",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    const/4 v11, 0x1

    const/4 v10, 0x0

    const/4 v2, 0x0

    .line 2559
    new-instance v3, Ljava/util/ArrayList;

    invoke-interface {p1}, Ljava/util/Map;->size()I

    move-result v0

    invoke-direct {v3, v0}, Ljava/util/ArrayList;-><init>(I)V

    .line 2562
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    .line 2563
    invoke-interface {p1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    .line 2564
    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_0
    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 2565
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gm/provider/Label;

    .line 2566
    invoke-virtual {v0}, Lcom/google/android/gm/provider/Label;->getCanonicalName()Ljava/lang/String;

    move-result-object v6

    .line 2567
    invoke-static {v6}, Lcom/google/android/gm/comm/longshadow/LongShadowUtils;->isUserLabel(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    invoke-static {v6}, Lcom/google/android/gm/provider/Gmail;->isDisplayableSystemLabel(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 2569
    :cond_1
    invoke-static {}, Lcom/android/mail/providers/Folder;->newUnsafeInstance()Lcom/android/mail/providers/Folder;

    move-result-object v7

    .line 2570
    invoke-virtual {v0}, Lcom/google/android/gm/provider/Label;->getId()J

    move-result-wide v8

    long-to-int v1, v8

    iput v1, v7, Lcom/android/mail/providers/Folder;->id:I

    .line 2571
    invoke-virtual {v0}, Lcom/google/android/gm/provider/Label;->getCanonicalName()Ljava/lang/String;

    move-result-object v1

    invoke-static {p0, v1}, Lcom/google/android/gm/provider/UiProvider;->getAccountLabelUri(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    iput-object v1, v7, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    .line 2572
    invoke-virtual {v0}, Lcom/google/android/gm/provider/Label;->getName()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v7, Lcom/android/mail/providers/Folder;->name:Ljava/lang/String;

    .line 2573
    iput v2, v7, Lcom/android/mail/providers/Folder;->capabilities:I

    .line 2574
    iput-boolean v2, v7, Lcom/android/mail/providers/Folder;->hasChildren:Z

    .line 2575
    iput v2, v7, Lcom/android/mail/providers/Folder;->syncWindow:I

    .line 2576
    invoke-virtual {v0}, Lcom/google/android/gm/provider/Label;->getId()J

    move-result-wide v8

    long-to-int v1, v8

    invoke-static {p0, v1}, Lcom/google/android/gm/provider/UiProvider;->getLabelConversationListUri(Ljava/lang/String;I)Landroid/net/Uri;

    move-result-object v1

    iput-object v1, v7, Lcom/android/mail/providers/Folder;->conversationListUri:Landroid/net/Uri;

    .line 2578
    iput-object v10, v7, Lcom/android/mail/providers/Folder;->childFoldersListUri:Landroid/net/Uri;

    .line 2579
    iput v2, v7, Lcom/android/mail/providers/Folder;->unreadCount:I

    .line 2580
    iput v2, v7, Lcom/android/mail/providers/Folder;->totalCount:I

    .line 2581
    iput-object v10, v7, Lcom/android/mail/providers/Folder;->refreshUri:Landroid/net/Uri;

    .line 2582
    iput v2, v7, Lcom/android/mail/providers/Folder;->syncStatus:I

    .line 2584
    iput v2, v7, Lcom/android/mail/providers/Folder;->lastSyncResult:I

    .line 2586
    invoke-virtual {v0}, Lcom/google/android/gm/provider/Label;->isSystemLabel()Z

    move-result v1

    invoke-virtual {v0}, Lcom/google/android/gm/provider/Label;->getCanonicalName()Ljava/lang/String;

    move-result-object v8

    invoke-static {v1, v8}, Lcom/google/android/gm/provider/UiProvider;->getFolderType(ZLjava/lang/String;)I

    move-result v1

    iput v1, v7, Lcom/android/mail/providers/Folder;->type:I

    .line 2587
    const-wide/16 v8, -0x1

    iput-wide v8, v7, Lcom/android/mail/providers/Folder;->iconResId:J

    .line 2590
    if-eqz p3, :cond_3

    invoke-interface {p3, v6}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 2591
    invoke-interface {p3, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ljava/lang/String;

    .line 2592
    aget-object v1, v0, v2

    .line 2593
    aget-object v0, v0, v11

    .line 2601
    :cond_2
    :goto_1
    iput-object v1, v7, Lcom/android/mail/providers/Folder;->bgColor:Ljava/lang/String;

    .line 2602
    iput-object v0, v7, Lcom/android/mail/providers/Folder;->fgColor:Ljava/lang/String;

    .line 2603
    iput-object v10, v7, Lcom/android/mail/providers/Folder;->loadMoreUri:Landroid/net/Uri;

    .line 2604
    invoke-virtual {v3, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_0

    .line 2595
    :cond_3
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Lcom/google/android/gm/provider/Label;->getBackgroundColor()I

    move-result v8

    invoke-virtual {v1, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v8, ""

    invoke-virtual {v1, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 2596
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Lcom/google/android/gm/provider/Label;->getTextColor()I

    move-result v0

    invoke-virtual {v8, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v8, ""

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 2597
    if-eqz p3, :cond_2

    .line 2598
    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/String;

    aput-object v1, v8, v2

    aput-object v0, v8, v11

    invoke-interface {p3, v6, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 2608
    :cond_4
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v5

    .line 2609
    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_2
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Folder;

    .line 2611
    if-eqz p2, :cond_7

    .line 2612
    iget v1, v0, Lcom/android/mail/providers/Folder;->id:I

    invoke-virtual {p2, v1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 2613
    if-nez v1, :cond_5

    .line 2614
    invoke-static {v0}, Lcom/android/mail/providers/Folder;->toString(Lcom/android/mail/providers/Folder;)Ljava/lang/String;

    move-result-object v1

    .line 2615
    iget v0, v0, Lcom/android/mail/providers/Folder;->id:I

    invoke-virtual {p2, v0, v1}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 2620
    :cond_5
    :goto_3
    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 2621
    add-int/lit8 v0, v5, -0x1

    if-ge v2, v0, :cond_6

    .line 2622
    const-string v0, "^**^"

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 2624
    :cond_6
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    .line 2625
    goto :goto_2

    .line 2618
    :cond_7
    invoke-static {v0}, Lcom/android/mail/providers/Folder;->toString(Lcom/android/mail/providers/Folder;)Ljava/lang/String;

    move-result-object v1

    goto :goto_3

    .line 2626
    :cond_8
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getSparseFolderObject(Landroid/content/Context;Lcom/google/android/gm/provider/MailEngine;Ljava/lang/String;Ljava/lang/String;)Lcom/android/mail/providers/Folder;
    .locals 12

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    const/4 v1, 0x0

    .line 1936
    new-instance v5, Landroid/database/MatrixCursor;

    sget-object v0, Lcom/google/android/gm/provider/Gmail;->LABEL_PROJECTION:[Ljava/lang/String;

    invoke-direct {v5, v0, v2}, Landroid/database/MatrixCursor;-><init>([Ljava/lang/String;I)V

    .line 1937
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/google/android/gm/provider/MailEngine;->getLabelMap()Lcom/google/android/gm/provider/Gmail$LabelMap;

    move-result-object v0

    .line 1939
    :goto_0
    invoke-static {p3}, Lcom/google/android/gm/provider/Gmail;->isSystemLabel(Ljava/lang/String;)Z

    move-result v6

    .line 1940
    invoke-static {p0, v0, p2, p3, v6}, Lcom/google/android/gm/provider/UiProvider;->getLabelFromCanonical(Landroid/content/Context;Lcom/google/android/gm/provider/Gmail$LabelMap;Ljava/lang/String;Ljava/lang/String;Z)Landroid/util/Pair;

    move-result-object v7

    .line 1943
    invoke-virtual {v5}, Landroid/database/MatrixCursor;->newRow()Landroid/database/MatrixCursor$RowBuilder;

    move-result-object v8

    .line 1944
    sget-object v9, Lcom/google/android/gm/provider/Gmail;->LABEL_PROJECTION:[Ljava/lang/String;

    array-length v10, v9

    move v4, v3

    :goto_1
    if-ge v4, v10, :cond_7

    aget-object v0, v9, v4

    .line 1945
    const-string v11, "_id"

    invoke-virtual {v11, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-eqz v11, :cond_1

    .line 1946
    iget-object v0, v7, Landroid/util/Pair;->first:Ljava/lang/Object;

    invoke-virtual {v8, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    .line 1944
    :goto_2
    add-int/lit8 v0, v4, 0x1

    move v4, v0

    goto :goto_1

    :cond_0
    move-object v0, v1

    .line 1937
    goto :goto_0

    .line 1947
    :cond_1
    const-string v11, "canonicalName"

    invoke-virtual {v11, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-eqz v11, :cond_2

    .line 1948
    invoke-virtual {v8, p3}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto :goto_2

    .line 1949
    :cond_2
    const-string v11, "systemLabel"

    invoke-virtual {v11, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-eqz v11, :cond_4

    .line 1950
    if-eqz v6, :cond_3

    move v0, v2

    :goto_3
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v8, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto :goto_2

    :cond_3
    move v0, v3

    goto :goto_3

    .line 1951
    :cond_4
    const-string v11, "name"

    invoke-virtual {v11, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-eqz v11, :cond_5

    .line 1952
    iget-object v0, v7, Landroid/util/Pair;->second:Ljava/lang/Object;

    invoke-virtual {v8, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto :goto_2

    .line 1953
    :cond_5
    const-string v11, "color"

    invoke-virtual {v11, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 1954
    const-string v0, "2147483647"

    invoke-virtual {v8, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto :goto_2

    .line 1956
    :cond_6
    invoke-virtual {v8, v1}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto :goto_2

    .line 1962
    :cond_7
    :try_start_0
    sget-object v0, Lcom/android/mail/providers/UIProvider;->FOLDERS_PROJECTION:[Ljava/lang/String;

    invoke-static {p1, p2, v0, v5}, Lcom/google/android/gm/provider/UiProvider;->getUiLabelCursor(Lcom/google/android/gm/provider/MailEngine;Ljava/lang/String;[Ljava/lang/String;Landroid/database/Cursor;)Landroid/database/Cursor;

    move-result-object v1

    .line 1965
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    .line 1967
    new-instance v0, Lcom/android/mail/providers/Folder;

    invoke-direct {v0, v1}, Lcom/android/mail/providers/Folder;-><init>(Landroid/database/Cursor;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1969
    if-eqz v1, :cond_8

    .line 1970
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_8
    return-object v0

    .line 1969
    :catchall_0
    move-exception v0

    if-eqz v1, :cond_9

    .line 1970
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_9
    throw v0
.end method

.method private static getSystemLabelName(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/CharSequence;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "canonicalName"    # Ljava/lang/String;

    .prologue
    .line 3015
    invoke-static {p1}, Lcom/google/android/gm/provider/Gmail;->isSystemLabel(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 3016
    const/4 v0, 0x0

    .line 3023
    :goto_0
    return-object v0

    .line 3019
    :cond_0
    const-class v1, Lcom/google/android/gm/provider/UiProvider;

    monitor-enter v1

    .line 3020
    :try_start_0
    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->sSystemLabelNameMap:Ljava/util/Map;

    if-nez v0, :cond_1

    .line 3021
    invoke-static {p0}, Lcom/google/android/gm/provider/Label;->getSystemLabelNameMap(Landroid/content/Context;)Ljava/util/Map;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/UiProvider;->sSystemLabelNameMap:Ljava/util/Map;

    .line 3023
    :cond_1
    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->sSystemLabelNameMap:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    monitor-exit v1

    goto :goto_0

    .line 3024
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method private getUiAttachmentsCursorForUIAttachments(Ljava/lang/String;JJJ[Ljava/lang/String;Ljava/util/List;)Landroid/database/Cursor;
    .locals 16
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "JJJ[",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/google/android/gm/provider/uiprovider/UIAttachment;",
            ">;)",
            "Landroid/database/Cursor;"
        }
    .end annotation

    .prologue
    .line 2088
    invoke-interface/range {p9 .. p9}, Ljava/util/List;->size()I

    move-result v8

    move-object/from16 v1, p0

    move-object/from16 v2, p1

    move-wide/from16 v3, p2

    move-wide/from16 v5, p4

    move-object/from16 v7, p8

    invoke-direct/range {v1 .. v8}, Lcom/google/android/gm/provider/UiProvider;->createAttachmentCursor(Ljava/lang/String;JJ[Ljava/lang/String;I)Lcom/google/android/gm/provider/UiProvider$AttachmentCursor;

    move-result-object v12

    .line 2091
    invoke-interface/range {p9 .. p9}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v13

    :cond_0
    invoke-interface {v13}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_d

    invoke-interface {v13}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    move-object v11, v1

    check-cast v11, Lcom/google/android/gm/provider/uiprovider/UIAttachment;

    .line 2092
    const-string v1, "Gmail"

    const-string v2, "adding attachment to cursor %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v11, v3, v4

    invoke-static {v1, v2, v3}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 2093
    invoke-virtual {v12}, Landroid/database/MatrixCursor;->newRow()Landroid/database/MatrixCursor$RowBuilder;

    move-result-object v14

    .line 2094
    invoke-interface {v11}, Lcom/google/android/gm/provider/uiprovider/UIAttachment;->getPartId()Ljava/lang/String;

    move-result-object v8

    .line 2095
    invoke-interface {v11}, Lcom/google/android/gm/provider/uiprovider/UIAttachment;->getContentType()Ljava/lang/String;

    move-result-object v9

    .line 2097
    invoke-interface {v11}, Lcom/google/android/gm/provider/uiprovider/UIAttachment;->getJoinedAttachmentInfo()Ljava/lang/String;

    move-result-object v10

    move-object/from16 v1, p1

    move-wide/from16 v2, p2

    move-wide/from16 v4, p4

    move-wide/from16 v6, p6

    invoke-static/range {v1 .. v10}, Lcom/google/android/gm/provider/UiProvider;->getMessageAttachmentUri(Ljava/lang/String;JJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v10

    .line 2100
    move-object/from16 v0, p8

    array-length v15, v0

    const/4 v1, 0x0

    move v7, v1

    :goto_0
    if-ge v7, v15, :cond_0

    aget-object v1, p8, v7

    .line 2101
    const-string v2, "uri"

    invoke-static {v1, v2}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 2102
    invoke-virtual {v14, v10}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    .line 2100
    :cond_1
    :goto_1
    add-int/lit8 v1, v7, 0x1

    move v7, v1

    goto :goto_0

    .line 2103
    :cond_2
    const-string v2, "_display_name"

    invoke-static {v1, v2}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 2104
    invoke-interface {v11}, Lcom/google/android/gm/provider/uiprovider/UIAttachment;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v14, v1}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto :goto_1

    .line 2105
    :cond_3
    const-string v2, "_size"

    invoke-static {v1, v2}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 2106
    invoke-interface {v11}, Lcom/google/android/gm/provider/uiprovider/UIAttachment;->getSize()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v14, v1}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto :goto_1

    .line 2107
    :cond_4
    const-string v2, "contentType"

    invoke-static {v1, v2}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 2108
    invoke-virtual {v14, v9}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto :goto_1

    .line 2109
    :cond_5
    const-string v2, "state"

    invoke-static {v1, v2}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_6

    .line 2110
    invoke-interface {v11}, Lcom/google/android/gm/provider/uiprovider/UIAttachment;->getStatus()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v14, v1}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto :goto_1

    .line 2111
    :cond_6
    const-string v2, "destination"

    invoke-static {v1, v2}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_7

    .line 2112
    invoke-interface {v11}, Lcom/google/android/gm/provider/uiprovider/UIAttachment;->getDestination()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v14, v1}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto :goto_1

    .line 2113
    :cond_7
    const-string v2, "downloadedSize"

    invoke-static {v1, v2}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_8

    .line 2114
    invoke-interface {v11}, Lcom/google/android/gm/provider/uiprovider/UIAttachment;->getDownloadedSize()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v14, v1}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto :goto_1

    .line 2115
    :cond_8
    const-string v2, "contentUri"

    invoke-static {v1, v2}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_a

    .line 2117
    invoke-interface {v11}, Lcom/google/android/gm/provider/uiprovider/UIAttachment;->getDestination()I

    move-result v1

    const/4 v2, 0x1

    if-ne v1, v2, :cond_9

    .line 2118
    invoke-interface {v11}, Lcom/google/android/gm/provider/uiprovider/UIAttachment;->getExternalFilePath()Landroid/net/Uri;

    move-result-object v1

    .line 2123
    :goto_2
    invoke-virtual {v14, v1}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 2120
    :cond_9
    sget-object v5, Lcom/google/android/gm/provider/Gmail$AttachmentRendition;->BEST:Lcom/google/android/gm/provider/Gmail$AttachmentRendition;

    const/4 v6, 0x0

    move-object/from16 v1, p1

    move-wide/from16 v2, p6

    move-object v4, v11

    invoke-static/range {v1 .. v6}, Lcom/google/android/gm/provider/Gmail;->getAttachmentUri(Ljava/lang/String;JLcom/google/android/gm/provider/uiprovider/UIAttachment;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;Z)Landroid/net/Uri;

    move-result-object v1

    goto :goto_2

    .line 2124
    :cond_a
    const-string v2, "thumbnailUri"

    invoke-static {v1, v2}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_b

    .line 2125
    sget-object v5, Lcom/google/android/gm/provider/Gmail$AttachmentRendition;->SIMPLE:Lcom/google/android/gm/provider/Gmail$AttachmentRendition;

    const/4 v6, 0x0

    move-object/from16 v1, p1

    move-wide/from16 v2, p6

    move-object v4, v11

    invoke-static/range {v1 .. v6}, Lcom/google/android/gm/provider/Gmail;->getAttachmentUri(Ljava/lang/String;JLcom/google/android/gm/provider/uiprovider/UIAttachment;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;Z)Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v14, v1}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 2127
    :cond_b
    const-string v2, "previewIntentUri"

    invoke-static {v1, v2}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 2129
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gm/provider/UiProvider;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1, v9}, Lcom/google/android/gm/provider/MimeType;->isPreviewable(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v1

    .line 2130
    if-eqz v1, :cond_c

    .line 2131
    sget-object v1, Lcom/google/android/gm/provider/UiProvider;->BASE_GVIEW_URI:Landroid/net/Uri;

    invoke-virtual {v1}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v1

    const-string v2, "account"

    move-object/from16 v0, p1

    invoke-virtual {v1, v2, v0}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    const-string v2, "serverMessageId"

    invoke-static/range {p4 .. p5}, Ljava/lang/Long;->toHexString(J)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    const-string v2, "attId"

    invoke-virtual {v1, v2, v8}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    const-string v2, "mimeType"

    invoke-virtual {v1, v2, v9}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    invoke-virtual {v1}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v1

    .line 2140
    invoke-virtual {v1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v14, v1}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 2142
    :cond_c
    const/4 v1, 0x0

    invoke-virtual {v14, v1}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 2147
    :cond_d
    return-object v12
.end method

.method private getUiConversationCursor(Ljava/lang/String;Lcom/google/android/gm/provider/MailEngine;Landroid/net/Uri;[Ljava/lang/String;Landroid/database/Cursor;Z)Landroid/database/Cursor;
    .locals 2
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "engine"    # Lcom/google/android/gm/provider/MailEngine;
    .param p3, "url"    # Landroid/net/Uri;
    .param p4, "resultProjection"    # [Ljava/lang/String;
    .param p5, "cursor"    # Landroid/database/Cursor;
    .param p6, "accessNetwork"    # Z

    .prologue
    .line 2505
    if-nez p5, :cond_1

    .line 2506
    const/4 v1, 0x0

    .line 2519
    :cond_0
    :goto_0
    return-object v1

    .line 2509
    :cond_1
    new-instance v1, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;

    invoke-direct {v1, p5, p1, p4}, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;-><init>(Landroid/database/Cursor;Ljava/lang/String;[Ljava/lang/String;)V

    .line 2514
    .local v1, "uiConversationCursor":Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;
    if-eqz p3, :cond_0

    if-eqz p6, :cond_0

    .line 2515
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/UiProvider;->getOrCreateAccountState(Ljava/lang/String;)Lcom/google/android/gm/provider/uiprovider/AccountState;

    move-result-object v0

    .line 2516
    .local v0, "accountState":Lcom/google/android/gm/provider/uiprovider/AccountState;
    invoke-virtual {v0, p3, v1}, Lcom/google/android/gm/provider/uiprovider/AccountState;->cacheConversationCursor(Landroid/net/Uri;Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;)V

    goto :goto_0
.end method

.method private static getUiLabelCursor(Lcom/google/android/gm/provider/MailEngine;Ljava/lang/String;[Ljava/lang/String;Landroid/database/Cursor;)Landroid/database/Cursor;
    .locals 1
    .param p0, "engine"    # Lcom/google/android/gm/provider/MailEngine;
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "resultProjection"    # [Ljava/lang/String;
    .param p3, "privateCursor"    # Landroid/database/Cursor;

    .prologue
    .line 1981
    if-nez p3, :cond_0

    .line 1982
    const/4 v0, 0x0

    .line 1985
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;

    invoke-direct {v0, p3, p0, p1, p2}, Lcom/google/android/gm/provider/uiprovider/UILabelCursor;-><init>(Landroid/database/Cursor;Lcom/google/android/gm/provider/MailEngine;Ljava/lang/String;[Ljava/lang/String;)V

    goto :goto_0
.end method

.method private initializeMailEngines()V
    .locals 3

    .prologue
    .line 3030
    invoke-virtual {p0}, Lcom/google/android/gm/provider/UiProvider;->getContext()Landroid/content/Context;

    move-result-object v1

    .line 3031
    .local v1, "context":Landroid/content/Context;
    new-instance v0, Lcom/google/android/gm/AccountHelper;

    invoke-direct {v0, v1}, Lcom/google/android/gm/AccountHelper;-><init>(Landroid/content/Context;)V

    .line 3032
    .local v0, "accountHelper":Lcom/google/android/gm/AccountHelper;
    new-instance v2, Lcom/google/android/gm/provider/UiProvider$1;

    invoke-direct {v2, p0, v1}, Lcom/google/android/gm/provider/UiProvider$1;-><init>(Lcom/google/android/gm/provider/UiProvider;Landroid/content/Context;)V

    invoke-virtual {v0, v2}, Lcom/google/android/gm/AccountHelper;->asyncGetAccountsInfo(Lcom/google/android/gm/AccountHelper$AccountResultsCallback;)V

    .line 3049
    return-void
.end method

.method private intializeLoaderHandler()V
    .locals 3

    .prologue
    .line 519
    new-instance v0, Landroid/os/HandlerThread;

    const-string v1, "UIProvider Thread"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Landroid/os/HandlerThread;-><init>(Ljava/lang/String;I)V

    .line 521
    .local v0, "handlerThread":Landroid/os/HandlerThread;
    invoke-virtual {v0}, Landroid/os/HandlerThread;->start()V

    .line 523
    new-instance v1, Landroid/os/Handler;

    invoke-virtual {v0}, Landroid/os/HandlerThread;->getLooper()Landroid/os/Looper;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v1, p0, Lcom/google/android/gm/provider/UiProvider;->mUiProviderHandler:Landroid/os/Handler;

    .line 524
    return-void
.end method

.method private static isAccountNameValid(Ljava/lang/String;)Z
    .locals 2
    .param p0, "accountName"    # Ljava/lang/String;

    .prologue
    .line 1603
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->INVALID_ACCOUNT_NAMES:Lcom/google/common/collect/ImmutableSet;

    invoke-virtual {p0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/common/collect/ImmutableSet;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static final isUserSettableLabel(Ljava/lang/String;)Z
    .locals 1
    .param p0, "labelName"    # Ljava/lang/String;

    .prologue
    .line 1124
    invoke-static {p0}, Lcom/google/android/gm/provider/Gmail;->isLabelUserSettable(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->INVARIANT_LABELS:Lcom/google/common/collect/ImmutableSet;

    invoke-virtual {v0, p0}, Lcom/google/common/collect/ImmutableSet;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method static notifyAccountChanged(Landroid/content/Context;Ljava/lang/String;)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "accountName"    # Ljava/lang/String;

    .prologue
    .line 2862
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    .line 2863
    .local v0, "resolver":Landroid/content/ContentResolver;
    invoke-static {p1}, Lcom/google/android/gm/provider/UiProvider;->getAccountUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;Z)V

    .line 2865
    invoke-static {p0}, Lcom/google/android/gm/provider/UiProvider;->notifyAccountListChanged(Landroid/content/Context;)V

    .line 2866
    return-void
.end method

.method public static notifyAccountListChanged(Landroid/content/Context;)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 2852
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    .line 2853
    .local v0, "resolver":Landroid/content/ContentResolver;
    sget-object v1, Lcom/google/android/gm/provider/UiProvider;->ACCOUNTS_URI:Landroid/net/Uri;

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;Z)V

    .line 2854
    return-void
.end method

.method static notifyAttachmentChanged(Ljava/lang/String;J)V
    .locals 3
    .param p0, "account"    # Ljava/lang/String;
    .param p1, "conversationId"    # J

    .prologue
    .line 2870
    sget-object v2, Lcom/google/android/gm/provider/UiProvider;->sAccountStateMap:Ljava/util/Map;

    monitor-enter v2

    .line 2871
    :try_start_0
    sget-object v1, Lcom/google/android/gm/provider/UiProvider;->sAccountStateMap:Ljava/util/Map;

    invoke-interface {v1, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gm/provider/uiprovider/AccountState;

    .line 2872
    .local v0, "accountState":Lcom/google/android/gm/provider/uiprovider/AccountState;
    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 2874
    if-eqz v0, :cond_0

    .line 2875
    invoke-virtual {v0, p1, p2}, Lcom/google/android/gm/provider/uiprovider/AccountState;->notifyAttachmentChange(J)V

    .line 2877
    :cond_0
    return-void

    .line 2872
    .end local v0    # "accountState":Lcom/google/android/gm/provider/uiprovider/AccountState;
    :catchall_0
    move-exception v1

    :try_start_1
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1
.end method

.method public static notifyMessageAttachmentsChanged(Landroid/content/Context;Ljava/lang/String;JJJLjava/util/Set;)V
    .locals 12
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "conversationId"    # J
    .param p4, "messageId"    # J
    .param p6, "localMessageId"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            "JJJ",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 2923
    .local p8, "partIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v11

    .line 2924
    .local v11, "resolver":Landroid/content/ContentResolver;
    invoke-static/range {p1 .. p7}, Lcom/google/android/gm/provider/UiProvider;->getMessageAttachmentsUri(Ljava/lang/String;JJJ)Landroid/net/Uri;

    move-result-object v0

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-virtual {v11, v0, v1, v2}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;Z)V

    .line 2927
    invoke-interface/range {p8 .. p8}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v10

    .local v10, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v10}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v10}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    .line 2928
    .local v7, "partId":Ljava/lang/String;
    const/4 v8, 0x0

    const/4 v9, 0x0

    move-object v0, p1

    move-wide v1, p2

    move-wide/from16 v3, p4

    move-wide/from16 v5, p6

    invoke-static/range {v0 .. v9}, Lcom/google/android/gm/provider/UiProvider;->getMessageAttachmentUri(Ljava/lang/String;JJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-virtual {v11, v0, v1, v2}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;Z)V

    goto :goto_0

    .line 2933
    .end local v7    # "partId":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method static onAttachmentDownloadFinished(Ljava/lang/String;JJLjava/lang/String;IIILjava/lang/String;)V
    .locals 11
    .param p0, "account"    # Ljava/lang/String;
    .param p1, "conversationId"    # J
    .param p3, "serverMessageId"    # J
    .param p5, "partId"    # Ljava/lang/String;
    .param p6, "destination"    # I
    .param p7, "downloadStatus"    # I
    .param p8, "attachmentManagerStatus"    # I
    .param p9, "fileUri"    # Ljava/lang/String;

    .prologue
    .line 2938
    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->sInstance:Lcom/google/android/gm/provider/UiProvider;

    .line 2940
    .local v0, "provider":Lcom/google/android/gm/provider/UiProvider;
    if-eqz v0, :cond_0

    move-object v1, p0

    move-wide v2, p1

    move-wide v4, p3

    move-object/from16 v6, p5

    move/from16 v7, p6

    move/from16 v8, p7

    move/from16 v9, p8

    move-object/from16 v10, p9

    .line 2941
    invoke-direct/range {v0 .. v10}, Lcom/google/android/gm/provider/UiProvider;->onAttachmentDownloadFinishedImpl(Ljava/lang/String;JJLjava/lang/String;IIILjava/lang/String;)V

    .line 2944
    :cond_0
    return-void
.end method

.method private onAttachmentDownloadFinishedImpl(Ljava/lang/String;JJLjava/lang/String;IIILjava/lang/String;)V
    .locals 7

    .prologue
    .line 2950
    invoke-direct {p0, p1, p2, p3}, Lcom/google/android/gm/provider/UiProvider;->getConversationState(Ljava/lang/String;J)Lcom/google/android/gm/provider/uiprovider/ConversationState;

    move-result-object v1

    .line 2952
    invoke-virtual {v1, p4, p5}, Lcom/google/android/gm/provider/uiprovider/ConversationState;->getOrCreateMessageState(J)Lcom/google/android/gm/provider/uiprovider/MessageState;

    move-result-object v1

    .line 2955
    if-nez v1, :cond_0

    .line 2956
    const-string v1, "Gmail"

    const-string v2, "couldn\'t find message %d in update AttachmentState"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {p4, p5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v1, v2, v3}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 2987
    :goto_0
    return-void

    .line 2962
    :cond_0
    invoke-virtual {v1, p6}, Lcom/google/android/gm/provider/uiprovider/MessageState;->getMessageAttachment(Ljava/lang/String;)Lcom/google/android/gm/provider/uiprovider/UIAttachment;

    move-result-object v2

    .line 2963
    if-nez v2, :cond_1

    .line 2964
    invoke-virtual {v1}, Lcom/google/android/gm/provider/uiprovider/MessageState;->getMessageAttachments()Ljava/util/List;

    move-result-object v1

    .line 2965
    const-string v2, "Gmail"

    const-string v3, "couldn\'t find attachment %d %s in update AttachmentState.  attachments: %s"

    const/4 v4, 0x3

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-static {p4, p5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    aput-object p6, v4, v5

    const/4 v5, 0x2

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v6

    new-array v6, v6, [Lcom/google/android/gm/provider/uiprovider/UIAttachment;

    invoke-interface {v1, v6}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v1

    invoke-static {v1}, Ljava/util/Arrays;->toString([Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v4, v5

    invoke-static {v2, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0

    .line 2978
    :cond_1
    const/16 v1, 0x194

    move/from16 v0, p9

    if-ne v0, v1, :cond_2

    invoke-interface {v2}, Lcom/google/android/gm/provider/uiprovider/UIAttachment;->downloadCompletedSuccessfully()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 2980
    const-string v1, "Gmail"

    const-string v2, "Attempt to make successful download a failure"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v1, v2, v3}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0

    .line 2983
    :cond_2
    const-string v1, "Gmail"

    const-string v3, "Updating attachment state %d/%d/%s"

    const/4 v4, 0x3

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-static {p8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    invoke-static {p7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x2

    aput-object p10, v4, v5

    invoke-static {v1, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 2985
    move-object/from16 v0, p10

    invoke-interface {v2, p8, p7, v0}, Lcom/google/android/gm/provider/uiprovider/UIAttachment;->updateState(IILjava/lang/String;)V

    goto :goto_0
.end method

.method public static onConversationChanged(Landroid/content/Context;Ljava/lang/String;J)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "conversationId"    # J

    .prologue
    .line 3074
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    invoke-static {p1, p2, p3}, Lcom/google/android/gm/provider/UiProvider;->getConversationMessageListUri(Ljava/lang/String;J)Landroid/net/Uri;

    move-result-object v1

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;Z)V

    .line 3077
    return-void
.end method

.method static parseSendersFromSnippetInstructions(Ljava/lang/String;Landroid/content/Context;)Ljava/lang/String;
    .locals 9

    .prologue
    const/4 v4, 0x0

    .line 2715
    new-instance v6, Landroid/text/SpannableStringBuilder;

    invoke-direct {v6}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 2716
    new-instance v7, Landroid/text/TextUtils$SimpleStringSplitter;

    const/16 v0, 0xa

    invoke-direct {v7, v0}, Landroid/text/TextUtils$SimpleStringSplitter;-><init>(C)V

    .line 2718
    invoke-virtual {v7, p0}, Landroid/text/TextUtils$SimpleStringSplitter;->setString(Ljava/lang/String;)V

    .line 2720
    const/16 v0, 0x8

    new-array v2, v0, [Ljava/lang/String;

    .line 2722
    array-length v1, v2

    .line 2723
    if-eqz p1, :cond_0

    const v0, 0x7f0c009b

    invoke-virtual {p1, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    :goto_0
    move v3, v4

    .line 2724
    :goto_1
    invoke-virtual {v7}, Landroid/text/TextUtils$SimpleStringSplitter;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 2725
    add-int/lit8 v5, v3, 0x1

    invoke-virtual {v7}, Landroid/text/TextUtils$SimpleStringSplitter;->next()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v2, v3

    .line 2726
    if-ne v5, v1, :cond_9

    .line 2727
    mul-int/lit8 v3, v1, 0x2

    new-array v3, v3, [Ljava/lang/String;

    .line 2728
    invoke-static {v2, v4, v3, v4, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 2729
    mul-int/lit8 v1, v1, 0x2

    move-object v2, v3

    move v3, v5

    .line 2730
    goto :goto_1

    .line 2723
    :cond_0
    const-string v0, "me"

    goto :goto_0

    :cond_1
    move v5, v4

    .line 2733
    :goto_2
    if-ge v5, v3, :cond_7

    .line 2734
    add-int/lit8 v1, v5, 0x1

    aget-object v5, v2, v5

    .line 2735
    const-string v7, ""

    invoke-virtual {v7, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_3

    :cond_2
    :goto_3
    move v5, v1

    .line 2754
    goto :goto_2

    .line 2737
    :cond_3
    const-string v7, "e"

    invoke-virtual {v7, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-nez v7, :cond_2

    .line 2739
    const-string v7, "n"

    invoke-virtual {v7, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_4

    .line 2740
    add-int/lit8 v1, v1, 0x1

    goto :goto_3

    .line 2741
    :cond_4
    const-string v7, "d"

    invoke-virtual {v7, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_5

    .line 2742
    add-int/lit8 v1, v1, 0x1

    goto :goto_3

    .line 2743
    :cond_5
    const-string v7, "s"

    invoke-virtual {v7, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-nez v7, :cond_2

    .line 2744
    const-string v7, "f"

    invoke-virtual {v7, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_2

    .line 2747
    add-int/lit8 v7, v1, 0x1

    aget-object v1, v2, v1

    .line 2748
    add-int/lit8 v5, v7, 0x1

    aget-object v1, v2, v7

    .line 2749
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v7

    if-nez v7, :cond_6

    .line 2750
    invoke-virtual {v0}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v1

    .line 2752
    :cond_6
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v7, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v7, ", "

    invoke-virtual {v1, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v6, v1}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    move v1, v5

    goto :goto_3

    .line 2755
    :cond_7
    invoke-virtual {v6}, Landroid/text/SpannableStringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    .line 2756
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_8

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    const/4 v2, 0x1

    if-le v1, v2, :cond_8

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    invoke-virtual {v0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v1

    const/16 v2, 0x2c

    if-ne v1, v2, :cond_8

    .line 2758
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    invoke-virtual {v0, v4, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 2760
    :cond_8
    return-object v0

    :cond_9
    move v3, v5

    goto/16 :goto_1
.end method

.method private performRefresh(Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    .locals 6
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "labelUriStr"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    .line 1028
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/UiProvider;->getOrMakeMailEngine(Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;

    move-result-object v3

    .line 1030
    .local v3, "mailEngine":Lcom/google/android/gm/provider/MailEngine;
    if-eqz p2, :cond_1

    .line 1032
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/UiProvider;->getOrCreateAccountState(Ljava/lang/String;)Lcom/google/android/gm/provider/uiprovider/AccountState;

    move-result-object v0

    .line 1034
    .local v0, "accountState":Lcom/google/android/gm/provider/uiprovider/AccountState;
    invoke-static {p2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 1040
    .local v1, "conversationListUri":Landroid/net/Uri;
    invoke-virtual {v0, v1}, Lcom/google/android/gm/provider/uiprovider/AccountState;->getConversationCursor(Landroid/net/Uri;)Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;

    move-result-object v4

    .line 1044
    .local v4, "uiConversationCursor":Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;
    if-eqz v4, :cond_0

    invoke-virtual {v4}, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->getWrappedCursor()Landroid/database/Cursor;

    move-result-object v2

    .line 1050
    .end local v0    # "accountState":Lcom/google/android/gm/provider/uiprovider/AccountState;
    .end local v1    # "conversationListUri":Landroid/net/Uri;
    .end local v4    # "uiConversationCursor":Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;
    .local v2, "innerCursor":Landroid/database/Cursor;
    :goto_0
    invoke-virtual {v3, v2}, Lcom/google/android/gm/provider/MailEngine;->performRefresh(Landroid/database/Cursor;)V

    .line 1052
    return-object v5

    .end local v2    # "innerCursor":Landroid/database/Cursor;
    .restart local v0    # "accountState":Lcom/google/android/gm/provider/uiprovider/AccountState;
    .restart local v1    # "conversationListUri":Landroid/net/Uri;
    .restart local v4    # "uiConversationCursor":Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;
    :cond_0
    move-object v2, v5

    .line 1044
    goto :goto_0

    .line 1047
    .end local v0    # "accountState":Lcom/google/android/gm/provider/uiprovider/AccountState;
    .end local v1    # "conversationListUri":Landroid/net/Uri;
    .end local v4    # "uiConversationCursor":Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;
    :cond_1
    const/4 v2, 0x0

    .restart local v2    # "innerCursor":Landroid/database/Cursor;
    goto :goto_0
.end method

.method private performUndo(Landroid/net/Uri;[Ljava/lang/String;)Landroid/database/Cursor;
    .locals 10
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "projection"    # [Ljava/lang/String;

    .prologue
    const/4 v9, 0x0

    .line 993
    iget-object v6, p0, Lcom/google/android/gm/provider/UiProvider;->mPreviousOperationUndoOps:Ljava/util/List;

    monitor-enter v6

    .line 994
    :try_start_0
    iget-object v5, p0, Lcom/google/android/gm/provider/UiProvider;->mPreviousOperationUndoOps:Ljava/util/List;

    invoke-static {v5}, Lcom/google/common/collect/ImmutableList;->copyOf(Ljava/util/Collection;)Lcom/google/common/collect/ImmutableList;

    move-result-object v4

    .line 996
    .local v4, "undoOperations":Ljava/util/List;, "Ljava/util/List<Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;>;"
    iget-object v5, p0, Lcom/google/android/gm/provider/UiProvider;->mPreviousOperationUndoOps:Ljava/util/List;

    invoke-interface {v5}, Ljava/util/List;->clear()V

    .line 997
    monitor-exit v6
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 999
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v1

    .line 1001
    .local v1, "accounts":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v4}, Ljava/util/List;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_1

    .line 1002
    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;

    .line 1003
    .local v3, "operation":Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;
    iget-object v5, v3, Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;->mAccount:Ljava/lang/String;

    invoke-interface {v1, v5}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 1004
    # invokes: Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;->performOperation()V
    invoke-static {v3}, Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;->access$100(Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;)V

    goto :goto_0

    .line 997
    .end local v1    # "accounts":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v3    # "operation":Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;
    .end local v4    # "undoOperations":Ljava/util/List;, "Ljava/util/List<Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;>;"
    :catchall_0
    move-exception v5

    :try_start_1
    monitor-exit v6
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v5

    .line 1007
    .restart local v1    # "accounts":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .restart local v2    # "i$":Ljava/util/Iterator;
    .restart local v4    # "undoOperations":Ljava/util/List;, "Ljava/util/List<Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;>;"
    :cond_0
    const-string v5, "Gmail"

    const-string v6, "Performed undo on %d operations"

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v8

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v7, v9

    invoke-static {v5, v6, v7}, Lcom/google/android/gm/provider/LogUtils;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1012
    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 1013
    .local v0, "account":Ljava/lang/String;
    iget-object v5, p0, Lcom/google/android/gm/provider/UiProvider;->mContentResolver:Landroid/content/ContentResolver;

    invoke-static {v0}, Lcom/google/android/gm/provider/Gmail;->getBaseUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v6

    const/4 v7, 0x0

    invoke-virtual {v5, v6, v7, v9}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;Z)V

    goto :goto_1

    .line 1016
    .end local v0    # "account":Ljava/lang/String;
    .end local v2    # "i$":Ljava/util/Iterator;
    :cond_1
    const-string v5, "Gmail"

    const-string v6, "Requested to perform an undo when with no saved undo operations"

    new-array v7, v9, [Ljava/lang/Object;

    invoke-static {v5, v6, v7}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1020
    :cond_2
    new-instance v5, Landroid/database/MatrixCursor;

    invoke-direct {v5, p2, v9}, Landroid/database/MatrixCursor;-><init>([Ljava/lang/String;I)V

    return-object v5
.end method

.method private static populateAccountCursorRow(Landroid/content/Context;Ljava/lang/String;Lcom/google/android/gm/provider/MailEngine;[Ljava/lang/String;Landroid/database/MatrixCursor$RowBuilder;)V
    .locals 9

    .prologue
    .line 1624
    new-instance v3, Landroid/accounts/Account;

    const-string v0, "com.google"

    invoke-direct {v3, p1, v0}, Landroid/accounts/Account;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 1628
    invoke-static {}, Lcom/google/android/gm/persistence/Persistence;->getInstance()Lcom/google/android/gm/persistence/Persistence;

    move-result-object v4

    .line 1630
    array-length v5, p3

    const/4 v0, 0x0

    move v2, v0

    :goto_0
    if-ge v2, v5, :cond_46

    aget-object v0, p3, v2

    .line 1631
    const-string v1, "_id"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1632
    invoke-virtual {v3}, Landroid/accounts/Account;->hashCode()I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    .line 1630
    :goto_1
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_0

    .line 1633
    :cond_0
    const-string v1, "name"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 1634
    invoke-virtual {p4, p1}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto :goto_1

    .line 1635
    :cond_1
    const-string v1, "providerVersion"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 1636
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto :goto_1

    .line 1637
    :cond_2
    const-string v1, "accountUri"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 1638
    invoke-static {p1}, Lcom/google/android/gm/provider/UiProvider;->getAccountUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto :goto_1

    .line 1639
    :cond_3
    const-string v1, "capabilities"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 1640
    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->GMAIL_CAPABILITIES:Ljava/lang/Integer;

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto :goto_1

    .line 1641
    :cond_4
    const-string v1, "folderListUri"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 1642
    invoke-static {p1}, Lcom/google/android/gm/provider/UiProvider;->getAccountFoldersUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto :goto_1

    .line 1643
    :cond_5
    const-string v1, "fullFolderListUri"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_6

    .line 1644
    const/4 v0, 0x0

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto :goto_1

    .line 1645
    :cond_6
    const-string v1, "searchUri"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_7

    .line 1646
    invoke-static {p1}, Lcom/google/android/gm/provider/UiProvider;->getAccountSearchUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto :goto_1

    .line 1647
    :cond_7
    const-string v1, "accountFromAddresses"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_a

    .line 1649
    invoke-static {p1}, Lcom/google/android/gm/provider/UiProvider;->getAccountUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gm/utils/CustomFromUtils;->getCustomReplyFroms(Landroid/net/Uri;)Ljava/util/List;

    move-result-object v0

    .line 1651
    if-eqz v0, :cond_9

    .line 1652
    new-instance v1, Lorg/json/JSONArray;

    invoke-direct {v1}, Lorg/json/JSONArray;-><init>()V

    .line 1653
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :goto_2
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/ReplyFromAccount;

    .line 1654
    invoke-virtual {v0}, Lcom/android/mail/providers/ReplyFromAccount;->serialize()Lorg/json/JSONObject;

    move-result-object v0

    invoke-virtual {v1, v0}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    goto :goto_2

    .line 1656
    :cond_8
    invoke-virtual {v1}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 1658
    :cond_9
    const/4 v0, 0x0

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 1660
    :cond_a
    const-string v1, "saveDraftUri"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_b

    .line 1661
    invoke-static {p1}, Lcom/google/android/gm/provider/UiProvider;->getAccountSaveDraftUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 1662
    :cond_b
    const-string v1, "sendMailUri"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_c

    .line 1663
    invoke-static {p1}, Lcom/google/android/gm/provider/UiProvider;->getAccountSendMessageUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 1664
    :cond_c
    const-string v1, "expungeMessageUri"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_d

    .line 1666
    invoke-static {p1}, Lcom/google/android/gm/provider/UiProvider;->getAccountExpungeMessageUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 1667
    :cond_d
    const-string v1, "undoUri"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_e

    .line 1668
    invoke-static {p1}, Lcom/google/android/gm/provider/UiProvider;->getAccountUndoUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 1669
    :cond_e
    sget-object v1, Lcom/android/mail/providers/UIProvider$AccountColumns;->SETTINGS_INTENT_URI:Ljava/lang/String;

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_f

    .line 1671
    invoke-static {p1}, Lcom/google/android/gm/provider/UiProvider;->getAccountSettingUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 1672
    :cond_f
    const-string v1, "syncStatus"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_18

    .line 1673
    const/4 v0, 0x0

    .line 1674
    if-eqz p2, :cond_16

    .line 1675
    invoke-virtual {p2}, Lcom/google/android/gm/provider/MailEngine;->isBackgroundSyncInProgress()Z

    move-result v1

    if-eqz v1, :cond_10

    .line 1676
    const/4 v0, 0x4

    .line 1678
    :cond_10
    invoke-virtual {p2}, Lcom/google/android/gm/provider/MailEngine;->isLiveQueryInProgress()Z

    move-result v1

    if-eqz v1, :cond_11

    .line 1679
    or-int/lit8 v0, v0, 0x2

    .line 1681
    :cond_11
    invoke-virtual {p2}, Lcom/google/android/gm/provider/MailEngine;->isHandlingUserRefresh()Z

    move-result v1

    if-eqz v1, :cond_12

    .line 1682
    or-int/lit8 v0, v0, 0x1

    .line 1687
    :cond_12
    invoke-virtual {p2}, Lcom/google/android/gm/provider/MailEngine;->labelsSynced()Z

    move-result v1

    if-eqz v1, :cond_13

    invoke-static {p2}, Lcom/google/android/gm/provider/UiProvider;->requiredLabelsPresent(Lcom/google/android/gm/provider/MailEngine;)Z

    move-result v1

    if-nez v1, :cond_17

    :cond_13
    const/4 v1, 0x1

    .line 1689
    :goto_3
    if-eqz v1, :cond_14

    .line 1690
    or-int/lit8 v0, v0, 0x8

    .line 1692
    :cond_14
    invoke-virtual {p2}, Lcom/google/android/gm/provider/MailEngine;->labelsSynchronizationStateInitialized()Z

    move-result v1

    if-nez v1, :cond_15

    .line 1693
    or-int/lit8 v0, v0, 0x20

    .line 1695
    :cond_15
    invoke-virtual {p2}, Lcom/google/android/gm/provider/MailEngine;->automaticSyncEnabled()Z

    move-result v1

    if-nez v1, :cond_16

    .line 1696
    or-int/lit8 v0, v0, 0x10

    .line 1699
    :cond_16
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 1687
    :cond_17
    const/4 v1, 0x0

    goto :goto_3

    .line 1700
    :cond_18
    sget-object v1, Lcom/android/mail/providers/UIProvider$AccountColumns;->HELP_INTENT_URI:Ljava/lang/String;

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_19

    .line 1701
    invoke-static {p0}, Lcom/google/android/gm/provider/UiProvider;->getHelpUri(Landroid/content/Context;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 1702
    :cond_19
    sget-object v1, Lcom/android/mail/providers/UIProvider$AccountColumns;->SEND_FEEDBACK_INTENT_URI:Ljava/lang/String;

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1a

    .line 1705
    invoke-static {p1}, Lcom/google/android/gm/provider/UiProvider;->getAboutUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 1706
    :cond_1a
    sget-object v1, Lcom/android/mail/providers/UIProvider$AccountColumns;->REAUTHENTICATION_INTENT_URI:Ljava/lang/String;

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1b

    .line 1708
    invoke-static {p1}, Lcom/google/android/gm/provider/UiProvider;->getReauthenticateUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 1709
    :cond_1b
    const-string v1, "composeUri"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1c

    .line 1710
    invoke-static {p1}, Lcom/google/android/gm/provider/UiProvider;->getComposeUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 1711
    :cond_1c
    const-string v1, "mimeType"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1d

    .line 1712
    const-string v0, "application/gmail-ls"

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 1713
    :cond_1d
    const-string v1, "recentFolderListUri"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1e

    .line 1715
    invoke-static {p1}, Lcom/google/android/gm/provider/UiProvider;->getRecentFoldersUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 1716
    :cond_1e
    const-string v1, "defaultRecentFolderListUri"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1f

    .line 1718
    invoke-static {p1}, Lcom/google/android/gm/provider/UiProvider;->getDefaultRecentFoldersUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 1719
    :cond_1f
    const-string v1, "manualSyncUri"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_20

    .line 1721
    invoke-static {p1}, Lcom/google/android/gm/provider/UiProvider;->getAccountRefreshUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 1722
    :cond_20
    const-string v1, "viewProxyUri"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_21

    .line 1724
    invoke-static {p1}, Lcom/google/android/gm/provider/UiProvider;->getAccountViewIntentProxyUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 1725
    :cond_21
    const-string v1, "accountCookieUri"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_22

    .line 1727
    invoke-static {p1}, Lcom/google/android/gm/provider/UiProvider;->getAccountCookieQueryUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 1728
    :cond_22
    const-string v1, "color"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_23

    .line 1729
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 1730
    :cond_23
    const-string v1, "signature"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_25

    .line 1732
    invoke-virtual {v4, p0, p1}, Lcom/google/android/gm/persistence/Persistence;->getSignature(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1733
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_24

    const/4 v0, 0x0

    :cond_24
    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 1734
    :cond_25
    const-string v1, "auto_advance"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_29

    .line 1737
    invoke-virtual {v4, p0}, Lcom/google/android/gm/persistence/Persistence;->getHasUserSetAutoAdvanceSetting(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_28

    .line 1738
    invoke-virtual {v4, p0}, Lcom/google/android/gm/persistence/Persistence;->getAutoAdvanceModeNewer(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_26

    .line 1739
    const/4 v0, 0x2

    .line 1748
    :goto_4
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 1740
    :cond_26
    invoke-virtual {v4, p0}, Lcom/google/android/gm/persistence/Persistence;->getAutoAdvanceModeOlder(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_27

    .line 1741
    const/4 v0, 0x1

    goto :goto_4

    .line 1743
    :cond_27
    const/4 v0, 0x3

    goto :goto_4

    .line 1746
    :cond_28
    const/4 v0, 0x0

    goto :goto_4

    .line 1749
    :cond_29
    const-string v1, "message_text_size"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_2c

    .line 1751
    invoke-virtual {v4, p0}, Lcom/google/android/gm/persistence/Persistence;->getMessageTextSize(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v6

    .line 1754
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0e0014

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v7

    .line 1758
    const/4 v1, -0x1

    .line 1759
    const/4 v0, 0x0

    :goto_5
    array-length v8, v7

    if-ge v0, v8, :cond_48

    .line 1760
    aget-object v8, v7, v0

    invoke-static {v6, v8}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v8

    if-eqz v8, :cond_2a

    .line 1766
    :goto_6
    const/4 v1, -0x1

    if-eq v0, v1, :cond_2b

    .line 1767
    sget-object v1, Lcom/google/android/gm/provider/UiProvider;->UI_PROVIDER_MESSAGE_TEXT_SIZE_VALUES:[I

    aget v0, v1, v0

    .line 1772
    :goto_7
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 1759
    :cond_2a
    add-int/lit8 v0, v0, 0x1

    goto :goto_5

    .line 1769
    :cond_2b
    const/4 v0, 0x0

    goto :goto_7

    .line 1773
    :cond_2c
    const-string v1, "reply_behavior"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_2e

    .line 1775
    invoke-virtual {v4, p0}, Lcom/google/android/gm/persistence/Persistence;->getActionStripActionReplyAll(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_2d

    const/4 v0, 0x1

    :goto_8
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    :cond_2d
    const/4 v0, 0x0

    goto :goto_8

    .line 1778
    :cond_2e
    const-string v1, "hide_checkboxes"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_30

    .line 1780
    invoke-virtual {v4, p0}, Lcom/google/android/gm/persistence/Persistence;->getHideCheckboxes(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_2f

    const/4 v0, 0x1

    :goto_9
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    :cond_2f
    const/4 v0, 0x0

    goto :goto_9

    .line 1781
    :cond_30
    const-string v1, "confirm_delete"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_32

    .line 1783
    invoke-virtual {v4, p0}, Lcom/google/android/gm/persistence/Persistence;->getConfirmDelete(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_31

    const/4 v0, 0x1

    :goto_a
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    :cond_31
    const/4 v0, 0x0

    goto :goto_a

    .line 1784
    :cond_32
    const-string v1, "confirm_archive"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_34

    .line 1786
    invoke-virtual {v4, p0}, Lcom/google/android/gm/persistence/Persistence;->getConfirmArchive(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_33

    const/4 v0, 0x1

    :goto_b
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    :cond_33
    const/4 v0, 0x0

    goto :goto_b

    .line 1787
    :cond_34
    const-string v1, "confirm_send"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_36

    .line 1789
    invoke-virtual {v4, p0}, Lcom/google/android/gm/persistence/Persistence;->getConfirmSend(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_35

    const/4 v0, 0x1

    :goto_c
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    :cond_35
    const/4 v0, 0x0

    goto :goto_c

    .line 1790
    :cond_36
    const-string v1, "default_inbox"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_37

    .line 1793
    invoke-static {p0, p1}, Lcom/google/android/gm/persistence/Persistence;->getAccountInbox(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1794
    invoke-static {p1, v0}, Lcom/google/android/gm/provider/UiProvider;->getAccountLabelUri(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 1795
    :cond_37
    const-string v1, "default_inbox_name"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_39

    .line 1798
    invoke-static {p0, p1}, Lcom/google/android/gm/persistence/Persistence;->getAccountInbox(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1799
    if-eqz p2, :cond_38

    invoke-virtual {p2}, Lcom/google/android/gm/provider/MailEngine;->getLabelMap()Lcom/google/android/gm/provider/Gmail$LabelMap;

    move-result-object v0

    .line 1800
    :goto_d
    invoke-static {v1}, Lcom/google/android/gm/provider/Gmail;->isSystemLabel(Ljava/lang/String;)Z

    move-result v6

    invoke-static {p0, v0, p1, v1, v6}, Lcom/google/android/gm/provider/UiProvider;->getLabelFromCanonical(Landroid/content/Context;Lcom/google/android/gm/provider/Gmail$LabelMap;Ljava/lang/String;Ljava/lang/String;Z)Landroid/util/Pair;

    move-result-object v0

    .line 1802
    iget-object v0, v0, Landroid/util/Pair;->second:Ljava/lang/Object;

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 1799
    :cond_38
    const/4 v0, 0x0

    goto :goto_d

    .line 1803
    :cond_39
    const-string v1, "snap_headers"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_3c

    .line 1805
    invoke-virtual {v4, p0}, Lcom/google/android/gm/persistence/Persistence;->getSnapHeaderMode(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v6

    .line 1808
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0e0017

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v7

    .line 1812
    const/4 v1, -0x1

    .line 1813
    const/4 v0, 0x0

    :goto_e
    array-length v8, v7

    if-ge v0, v8, :cond_47

    .line 1814
    aget-object v8, v7, v0

    invoke-static {v6, v8}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v8

    if-eqz v8, :cond_3a

    .line 1820
    :goto_f
    const/4 v1, -0x1

    if-eq v0, v1, :cond_3b

    .line 1821
    sget-object v1, Lcom/google/android/gm/provider/UiProvider;->UI_PROVIDER_SNAP_HEADER_MODE_VALUES:[I

    aget v0, v1, v0

    .line 1826
    :goto_10
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 1813
    :cond_3a
    add-int/lit8 v0, v0, 0x1

    goto :goto_e

    .line 1823
    :cond_3b
    const/4 v0, 0x0

    goto :goto_10

    .line 1827
    :cond_3c
    const-string v1, "force_reply_from_default"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_3e

    .line 1829
    invoke-static {p1}, Lcom/google/android/gm/provider/UiProvider;->getAccountUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gm/utils/CustomFromUtils;->replyFromDefaultAddress(Landroid/net/Uri;)Z

    move-result v0

    if-eqz v0, :cond_3d

    const/4 v0, 0x1

    :goto_11
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    :cond_3d
    const/4 v0, 0x0

    goto :goto_11

    .line 1831
    :cond_3e
    const-string v1, "max_attachment_size"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_3f

    .line 1833
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const-string v1, "gmail_max_attachment_size_bytes"

    const/high16 v6, 0x1900000

    invoke-static {v0, v1, v6}, Lcom/google/android/gsf/Gservices;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 1835
    :cond_3f
    const-string v1, "swipe"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_40

    .line 1837
    invoke-virtual {v4, p0}, Lcom/google/android/gm/persistence/Persistence;->getSwipeIntegerPreference(Landroid/content/Context;)I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 1838
    :cond_40
    const-string v1, "priority_inbox_arrows_enabled"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_42

    .line 1840
    invoke-virtual {v4, p0, p1}, Lcom/google/android/gm/persistence/Persistence;->getPriorityInboxArrowsEnabled(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_41

    const/4 v0, 0x1

    :goto_12
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    :cond_41
    const/4 v0, 0x0

    goto :goto_12

    .line 1842
    :cond_42
    const-string v1, "setup_intent_uri"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_43

    .line 1844
    sget-object v0, Landroid/net/Uri;->EMPTY:Landroid/net/Uri;

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    .line 1845
    :cond_43
    const-string v1, "conversation_view_mode"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_45

    .line 1847
    invoke-virtual {v4, p0}, Lcom/google/android/gm/persistence/Persistence;->getConversationOverviewMode(Landroid/content/Context;)Z

    move-result v0

    .line 1848
    if-eqz v0, :cond_44

    const/4 v0, 0x0

    :goto_13
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p4, v0}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_1

    :cond_44
    const/4 v0, 0x1

    goto :goto_13

    .line 1851
    :cond_45
    new-instance v1, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Unexpected column: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1854
    :cond_46
    return-void

    :cond_47
    move v0, v1

    goto/16 :goto_f

    :cond_48
    move v0, v1

    goto/16 :goto_6
.end method

.method private final populateRecentLabels(Lcom/google/android/gm/provider/MailEngine;Ljava/lang/String;)V
    .locals 12

    .prologue
    .line 1102
    const-string v0, "Gmail"

    const-string v1, "UiProvider.populateRecentLabels()"

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1104
    const/4 v0, 0x3

    new-array v1, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    const-string v2, "^t"

    aput-object v2, v1, v0

    const/4 v0, 0x1

    const-string v2, "^f"

    aput-object v2, v1, v0

    const/4 v0, 0x2

    const-string v2, "^r"

    aput-object v2, v1, v0

    .line 1107
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 1109
    new-instance v4, Landroid/content/ContentValues;

    array-length v0, v1

    invoke-direct {v4, v0}, Landroid/content/ContentValues;-><init>(I)V

    .line 1110
    array-length v5, v1

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v5, :cond_0

    aget-object v6, v1, v0

    .line 1111
    const-string v7, "Gmail"

    const-string v8, "Marking %s with %d"

    const/4 v9, 0x2

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    aput-object v6, v9, v10

    const/4 v10, 0x1

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-static {v7, v8, v9}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1112
    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    invoke-virtual {v4, v6, v7}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 1110
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 1114
    :cond_0
    invoke-virtual {p1, v4}, Lcom/google/android/gm/provider/MailEngine;->updateLabelsLastTouched(Landroid/content/ContentValues;)I

    .line 1115
    iget-object v0, p0, Lcom/google/android/gm/provider/UiProvider;->mContentResolver:Landroid/content/ContentResolver;

    invoke-static {p2}, Lcom/google/android/gm/provider/UiProvider;->getRecentFoldersUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;Z)V

    .line 1116
    return-void
.end method

.method private static requiredLabelsPresent(Lcom/google/android/gm/provider/MailEngine;)Z
    .locals 6
    .param p0, "engine"    # Lcom/google/android/gm/provider/MailEngine;

    .prologue
    .line 1857
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine;->getLabelMap()Lcom/google/android/gm/provider/Gmail$LabelMap;

    move-result-object v3

    .line 1859
    .local v3, "labelMap":Lcom/google/android/gm/provider/Gmail$LabelMap;
    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->UI_PROVIDER_REQUIRED_LABELS:[Ljava/lang/String;

    .local v0, "arr$":[Ljava/lang/String;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v4, :cond_1

    aget-object v2, v0, v1

    .line 1860
    .local v2, "label":Ljava/lang/String;
    invoke-virtual {v3, v2}, Lcom/google/android/gm/provider/Gmail$LabelMap;->labelPresent(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 1861
    const/4 v5, 0x0

    .line 1864
    .end local v2    # "label":Ljava/lang/String;
    :goto_1
    return v5

    .line 1859
    .restart local v2    # "label":Ljava/lang/String;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 1864
    .end local v2    # "label":Ljava/lang/String;
    :cond_1
    const/4 v5, 0x1

    goto :goto_1
.end method

.method private saveDraft(Lcom/google/android/gm/provider/MailEngine;Landroid/content/ContentValues;)J
    .locals 6

    .prologue
    .line 1418
    const-string v0, "_id"

    invoke-virtual {p2, v0}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "_id"

    invoke-virtual {p2, v0}, Landroid/content/ContentValues;->getAsLong(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    .line 1421
    :goto_0
    const/4 v4, 0x1

    invoke-direct {p0, p2}, Lcom/google/android/gm/provider/UiProvider;->translateMessage(Landroid/content/ContentValues;)Landroid/content/ContentValues;

    move-result-object v5

    move-object v0, p0

    move-object v1, p1

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gm/provider/UiProvider;->sendOrSaveDraft(Lcom/google/android/gm/provider/MailEngine;JZLandroid/content/ContentValues;)J

    move-result-wide v0

    return-wide v0

    .line 1418
    :cond_0
    const-wide/16 v2, 0x0

    goto :goto_0
.end method

.method private scheduleAccountChangeNotification(Landroid/content/Context;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 2888
    iget-object v1, p0, Lcom/google/android/gm/provider/UiProvider;->mUiProviderHandler:Landroid/os/Handler;

    .line 2889
    if-nez v1, :cond_0

    .line 2890
    const-string v0, "Gmail"

    const-string v1, "Attempting to schedule notification before initialization"

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/LogUtils;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 2907
    :goto_0
    return-void

    .line 2896
    :cond_0
    iget-object v2, p0, Lcom/google/android/gm/provider/UiProvider;->mAccountChangeNotifiers:Ljava/util/Map;

    monitor-enter v2

    .line 2897
    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/provider/UiProvider;->mAccountChangeNotifiers:Ljava/util/Map;

    invoke-interface {v0, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gm/provider/UiProvider$AccountChangedNotifier;

    .line 2899
    if-nez v0, :cond_1

    .line 2900
    new-instance v0, Lcom/google/android/gm/provider/UiProvider$AccountChangedNotifier;

    invoke-virtual {v1}, Landroid/os/Handler;->getLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, p1, v1, p2}, Lcom/google/android/gm/provider/UiProvider$AccountChangedNotifier;-><init>(Landroid/content/Context;Landroid/os/Looper;Ljava/lang/String;)V

    .line 2902
    iget-object v1, p0, Lcom/google/android/gm/provider/UiProvider;->mAccountChangeNotifiers:Ljava/util/Map;

    invoke-interface {v1, p2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2904
    :cond_1
    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 2906
    invoke-virtual {v0}, Lcom/google/android/gm/provider/UiProvider$AccountChangedNotifier;->scheduleTask()V

    goto :goto_0

    .line 2904
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method private sendMessage(Lcom/google/android/gm/provider/MailEngine;Landroid/content/ContentValues;)J
    .locals 6

    .prologue
    .line 1410
    const-string v0, "_id"

    invoke-virtual {p2, v0}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "_id"

    invoke-virtual {p2, v0}, Landroid/content/ContentValues;->getAsLong(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    .line 1413
    :goto_0
    const/4 v4, 0x0

    invoke-direct {p0, p2}, Lcom/google/android/gm/provider/UiProvider;->translateMessage(Landroid/content/ContentValues;)Landroid/content/ContentValues;

    move-result-object v5

    move-object v0, p0

    move-object v1, p1

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gm/provider/UiProvider;->sendOrSaveDraft(Lcom/google/android/gm/provider/MailEngine;JZLandroid/content/ContentValues;)J

    move-result-wide v0

    return-wide v0

    .line 1410
    :cond_0
    const-wide/16 v2, 0x0

    goto :goto_0
.end method

.method private sendOrSaveDraft(Lcom/google/android/gm/provider/MailEngine;JZLandroid/content/ContentValues;)J
    .locals 8

    .prologue
    const/4 v7, 0x0

    .line 1427
    new-instance v6, Landroid/content/ContentValues;

    invoke-direct {v6, p5}, Landroid/content/ContentValues;-><init>(Landroid/content/ContentValues;)V

    .line 1428
    const-string v0, "refMessageId"

    invoke-virtual {v6, v0}, Landroid/content/ContentValues;->getAsLong(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    .line 1430
    const-string v0, "refMessageId"

    invoke-virtual {v6, v0}, Landroid/content/ContentValues;->remove(Ljava/lang/String;)V

    move-object v0, p1

    move-wide v1, p2

    move v3, p4

    .line 1432
    invoke-virtual/range {v0 .. v6}, Lcom/google/android/gm/provider/MailEngine;->sendOrSaveDraft(JZJLandroid/content/ContentValues;)J

    move-result-wide v0

    .line 1436
    invoke-virtual {p1, v0, v1, v7}, Lcom/google/android/gm/provider/MailEngine;->getLocalMessage(JZ)Lcom/google/android/gm/provider/MailSync$Message;

    move-result-object v2

    .line 1438
    if-eqz v2, :cond_0

    .line 1439
    iget-object v3, p0, Lcom/google/android/gm/provider/UiProvider;->mContentResolver:Landroid/content/ContentResolver;

    invoke-virtual {p1}, Lcom/google/android/gm/provider/MailEngine;->getAccountName()Ljava/lang/String;

    move-result-object v4

    iget-wide v5, v2, Lcom/google/android/gm/provider/MailSync$Message;->conversationId:J

    invoke-static {v4, v5, v6}, Lcom/google/android/gm/provider/UiProvider;->getConversationMessageListUri(Ljava/lang/String;J)Landroid/net/Uri;

    move-result-object v2

    const/4 v4, 0x0

    invoke-virtual {v3, v2, v4, v7}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;Z)V

    .line 1445
    :cond_0
    return-wide v0
.end method

.method private translateMessage(Landroid/content/ContentValues;)Landroid/content/ContentValues;
    .locals 14

    .prologue
    const/4 v6, 0x1

    const/4 v7, 0x0

    const-wide/16 v3, 0x0

    .line 1450
    const-string v0, "_id"

    invoke-virtual {p1, v0}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "_id"

    invoke-virtual {p1, v0}, Landroid/content/ContentValues;->getAsLong(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    move-wide v1, v0

    .line 1453
    :goto_0
    new-instance v9, Landroid/content/ContentValues;

    invoke-direct {v9}, Landroid/content/ContentValues;-><init>()V

    .line 1455
    const-string v0, "toAddresses"

    const-string v5, "toAddresses"

    invoke-virtual {p1, v5}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/google/android/gm/provider/UiProvider;->uiProviderToGmailRecipients(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v9, v0, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1457
    const-string v0, "ccAddresses"

    const-string v5, "ccAddresses"

    invoke-virtual {p1, v5}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/google/android/gm/provider/UiProvider;->uiProviderToGmailRecipients(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v9, v0, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1459
    const-string v0, "bccAddresses"

    const-string v5, "bccAddresses"

    invoke-virtual {p1, v5}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/google/android/gm/provider/UiProvider;->uiProviderToGmailRecipients(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v9, v0, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1461
    const-string v0, "subject"

    const-string v5, "subject"

    invoke-virtual {p1, v5}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v9, v0, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1463
    const-string v0, "snippet"

    const-string v5, "snippet"

    invoke-virtual {p1, v5}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v9, v0, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1465
    const-string v0, "replyToAddresses"

    const-string v5, "replyToAddress"

    invoke-virtual {p1, v5}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v9, v0, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1467
    const-string v0, "fromAddress"

    const-string v5, "fromAddress"

    invoke-virtual {p1, v5}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v9, v0, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1468
    const-string v0, "customFromAddress"

    const-string v5, "customFrom"

    invoke-virtual {p1, v5}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v9, v0, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1470
    const-string v0, "joinedAttachmentInfos"

    invoke-virtual {p1, v0}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1472
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_2

    .line 1477
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v10

    .line 1480
    invoke-static {v0}, Lcom/android/mail/providers/Attachment;->fromJSONArray(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 1482
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v11

    :goto_1
    invoke-interface {v11}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v11}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Attachment;

    .line 1485
    iget-object v5, v0, Lcom/android/mail/providers/Attachment;->uri:Landroid/net/Uri;

    .line 1486
    const/4 v8, 0x0

    .line 1487
    if-eqz v5, :cond_9

    const-string v12, "com.android.gmail.ui"

    invoke-virtual {v5}, Landroid/net/Uri;->getAuthority()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v12

    if-eqz v12, :cond_9

    .line 1488
    const-string v12, "gmailJoinedAttachment"

    invoke-virtual {v5, v12}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 1490
    if-eqz v5, :cond_9

    .line 1495
    :goto_2
    if-nez v5, :cond_8

    .line 1498
    invoke-virtual {v0}, Lcom/android/mail/providers/Attachment;->toJoinedString()Ljava/lang/String;

    move-result-object v0

    .line 1501
    :goto_3
    invoke-interface {v10, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    :cond_0
    move-wide v1, v3

    .line 1450
    goto/16 :goto_0

    .line 1504
    :cond_1
    const-string v0, "joinedAttachmentInfos"

    const-string v5, "\n"

    invoke-static {v5, v10}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v9, v0, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1507
    :cond_2
    const-string v0, "bodyHtml"

    invoke-virtual {p1, v0}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1508
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 1509
    const-string v5, "bodyText"

    invoke-virtual {p1, v5}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 1510
    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v8

    if-nez v8, :cond_3

    .line 1511
    new-instance v0, Landroid/text/SpannedString;

    invoke-direct {v0, v5}, Landroid/text/SpannedString;-><init>(Ljava/lang/CharSequence;)V

    invoke-static {v0}, Landroid/text/Html;->toHtml(Landroid/text/Spanned;)Ljava/lang/String;

    move-result-object v0

    .line 1514
    :cond_3
    const-string v5, "body"

    invoke-virtual {v9, v5, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1515
    const-string v0, "appendRefMessageContent"

    invoke-virtual {p1, v0}, Landroid/content/ContentValues;->getAsInteger(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v0

    .line 1517
    const-string v5, "includeQuotedText"

    if-eqz v0, :cond_5

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    if-eqz v0, :cond_5

    move v0, v6

    :goto_4
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v9, v5, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 1519
    const-string v0, "quoteStartPos"

    const-string v5, "quotedTextStartPos"

    invoke-virtual {p1, v5}, Landroid/content/ContentValues;->getAsInteger(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v9, v0, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1525
    cmp-long v0, v1, v3

    if-nez v0, :cond_4

    const-string v0, "refMessageId"

    invoke-virtual {p1, v0}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_6

    .line 1537
    :cond_4
    :goto_5
    const-string v0, "refMessageId"

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v9, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 1539
    return-object v9

    :cond_5
    move v0, v7

    .line 1517
    goto :goto_4

    .line 1528
    :cond_6
    const-string v0, "refMessageId"

    invoke-virtual {p1, v0}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1530
    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 1531
    invoke-virtual {v0}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v3

    .line 1534
    const-string v0, "draftType"

    invoke-virtual {p1, v0}, Landroid/content/ContentValues;->getAsInteger(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 1535
    const-string v1, "forward"

    const/4 v2, 0x4

    if-ne v0, v2, :cond_7

    :goto_6
    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v9, v1, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    goto :goto_5

    :cond_7
    move v6, v7

    goto :goto_6

    :cond_8
    move-object v0, v5

    goto/16 :goto_3

    :cond_9
    move-object v5, v8

    goto/16 :goto_2
.end method

.method private static uiProviderToGmailRecipients(Ljava/lang/String;)Ljava/lang/String;
    .locals 2

    .prologue
    .line 1543
    if-nez p0, :cond_0

    .line 1544
    const/4 v0, 0x0

    .line 1547
    :goto_0
    return-object v0

    .line 1546
    :cond_0
    invoke-static {p0}, Lcom/android/mail/providers/Message;->tokenizeAddresses(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 1547
    const-string v1, "\n"

    invoke-static {v1, v0}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private updateAccountsIntializedStatus()V
    .locals 1

    .prologue
    .line 3063
    iget-object v0, p0, Lcom/google/android/gm/provider/UiProvider;->mAccountsPendingInitialization:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->size()I

    move-result v0

    if-nez v0, :cond_0

    .line 3066
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/gm/provider/UiProvider;->mAccountsFullyInitialized:Z

    .line 3068
    invoke-virtual {p0}, Lcom/google/android/gm/provider/UiProvider;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gm/provider/UiProvider;->notifyAccountListChanged(Landroid/content/Context;)V

    .line 3070
    :cond_0
    return-void
.end method

.method private updateAttachmentState(Landroid/net/Uri;Landroid/content/ContentValues;)I
    .locals 13

    .prologue
    const/4 v8, 0x0

    const/4 v9, 0x1

    const/4 v6, 0x0

    .line 2152
    const-string v0, "state"

    invoke-virtual {p2, v0}, Landroid/content/ContentValues;->getAsInteger(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v0

    .line 2153
    const-string v1, "destination"

    invoke-virtual {p2, v1}, Landroid/content/ContentValues;->getAsInteger(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v1

    .line 2155
    if-nez v0, :cond_1

    if-nez v1, :cond_1

    .line 2249
    :cond_0
    :goto_0
    return v6

    .line 2159
    :cond_1
    invoke-static {p1}, Lcom/google/android/gm/provider/uiprovider/UIAttachment$UriParser;->parse(Landroid/net/Uri;)Lcom/google/android/gm/provider/uiprovider/UIAttachment$UriParser;

    move-result-object v7

    .line 2162
    iget-object v2, v7, Lcom/google/android/gm/provider/uiprovider/UIAttachment$UriParser;->mAccount:Ljava/lang/String;

    iget-wide v3, v7, Lcom/google/android/gm/provider/uiprovider/UIAttachment$UriParser;->mConversationId:J

    invoke-direct {p0, v2, v3, v4}, Lcom/google/android/gm/provider/UiProvider;->getConversationState(Ljava/lang/String;J)Lcom/google/android/gm/provider/uiprovider/ConversationState;

    move-result-object v2

    .line 2165
    iget-object v3, v7, Lcom/google/android/gm/provider/uiprovider/UIAttachment$UriParser;->mAccount:Ljava/lang/String;

    invoke-direct {p0, v3}, Lcom/google/android/gm/provider/UiProvider;->getOrMakeMailEngine(Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;

    move-result-object v10

    .line 2166
    if-eqz v0, :cond_0

    .line 2167
    invoke-virtual {v2, v7}, Lcom/google/android/gm/provider/uiprovider/ConversationState;->getOrCreateMessageState(Lcom/google/android/gm/provider/uiprovider/UIAttachment$UriParser;)Lcom/google/android/gm/provider/uiprovider/MessageState;

    move-result-object v2

    .line 2171
    iget-object v3, v7, Lcom/google/android/gm/provider/uiprovider/UIAttachment$UriParser;->mPartId:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/google/android/gm/provider/uiprovider/MessageState;->getMessageAttachment(Ljava/lang/String;)Lcom/google/android/gm/provider/uiprovider/UIAttachment;

    move-result-object v3

    .line 2173
    if-nez v3, :cond_2

    .line 2174
    const-string v0, "Gmail"

    const-string v1, "couldn\'t find attachment in update AttachmentState"

    new-array v2, v6, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0

    .line 2178
    :cond_2
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v11

    .line 2179
    packed-switch v11, :pswitch_data_0

    :pswitch_0
    goto :goto_0

    .line 2224
    :pswitch_1
    invoke-interface {v3}, Lcom/google/android/gm/provider/uiprovider/UIAttachment;->getDestination()I

    move-result v0

    if-ne v0, v9, :cond_6

    move v5, v9

    .line 2228
    :goto_1
    invoke-interface {v3, v6, v6, v8}, Lcom/google/android/gm/provider/uiprovider/UIAttachment;->updateState(IILjava/lang/String;)V

    .line 2232
    iget-object v0, v7, Lcom/google/android/gm/provider/uiprovider/UIAttachment$UriParser;->mAccount:Ljava/lang/String;

    iget-wide v1, v7, Lcom/google/android/gm/provider/uiprovider/UIAttachment$UriParser;->mLocalMessageId:J

    sget-object v4, Lcom/google/android/gm/provider/Gmail$AttachmentRendition;->BEST:Lcom/google/android/gm/provider/Gmail$AttachmentRendition;

    invoke-static/range {v0 .. v5}, Lcom/google/android/gm/provider/Gmail;->getAttachmentUri(Ljava/lang/String;JLcom/google/android/gm/provider/uiprovider/UIAttachment;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;Z)Landroid/net/Uri;

    move-result-object v0

    .line 2237
    invoke-static {v10, v0}, Lcom/google/android/gm/provider/MailProvider;->attachmentRequestForUri(Lcom/google/android/gm/provider/MailEngine;Landroid/net/Uri;)Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;

    move-result-object v8

    .line 2240
    if-eqz v8, :cond_0

    .line 2241
    invoke-virtual {v10}, Lcom/google/android/gm/provider/MailEngine;->getAttachmentManager()Lcom/google/android/gm/provider/AttachmentManager;

    move-result-object v0

    iget-object v1, v8, Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;->message:Lcom/google/android/gm/provider/MailSync$Message;

    iget-wide v1, v1, Lcom/google/android/gm/provider/MailSync$Message;->conversationId:J

    iget-object v3, v8, Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;->message:Lcom/google/android/gm/provider/MailSync$Message;

    iget-wide v3, v3, Lcom/google/android/gm/provider/MailSync$Message;->messageId:J

    iget-object v5, v7, Lcom/google/android/gm/provider/uiprovider/UIAttachment$UriParser;->mPartId:Ljava/lang/String;

    iget-object v6, v8, Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;->rendition:Lcom/google/android/gm/provider/Gmail$AttachmentRendition;

    iget-boolean v7, v8, Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;->saveToSd:Z

    invoke-virtual/range {v0 .. v7}, Lcom/google/android/gm/provider/AttachmentManager;->cancelDownloadRequest(JJLjava/lang/String;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;Z)I

    move-result v6

    goto :goto_0

    .line 2183
    :pswitch_2
    if-eqz v1, :cond_4

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 2186
    :goto_2
    if-ne v0, v9, :cond_5

    move v5, v9

    .line 2189
    :goto_3
    const/4 v1, 0x2

    invoke-interface {v3, v1, v0, v8}, Lcom/google/android/gm/provider/uiprovider/UIAttachment;->updateState(IILjava/lang/String;)V

    .line 2193
    iget-object v0, v7, Lcom/google/android/gm/provider/uiprovider/UIAttachment$UriParser;->mAccount:Ljava/lang/String;

    iget-wide v1, v7, Lcom/google/android/gm/provider/uiprovider/UIAttachment$UriParser;->mLocalMessageId:J

    sget-object v4, Lcom/google/android/gm/provider/Gmail$AttachmentRendition;->BEST:Lcom/google/android/gm/provider/Gmail$AttachmentRendition;

    invoke-static/range {v0 .. v5}, Lcom/google/android/gm/provider/Gmail;->getAttachmentUri(Ljava/lang/String;JLcom/google/android/gm/provider/uiprovider/UIAttachment;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;Z)Landroid/net/Uri;

    move-result-object v0

    .line 2197
    invoke-static {v10, v0}, Lcom/google/android/gm/provider/MailProvider;->attachmentRequestForUri(Lcom/google/android/gm/provider/MailEngine;Landroid/net/Uri;)Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;

    move-result-object v12

    .line 2201
    if-eqz v12, :cond_0

    .line 2202
    invoke-virtual {v10}, Lcom/google/android/gm/provider/MailEngine;->getAttachmentManager()Lcom/google/android/gm/provider/AttachmentManager;

    move-result-object v0

    .line 2207
    const/4 v1, 0x4

    if-ne v11, v1, :cond_3

    .line 2208
    iget-object v1, v12, Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;->message:Lcom/google/android/gm/provider/MailSync$Message;

    iget-wide v1, v1, Lcom/google/android/gm/provider/MailSync$Message;->conversationId:J

    iget-object v3, v12, Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;->message:Lcom/google/android/gm/provider/MailSync$Message;

    iget-wide v3, v3, Lcom/google/android/gm/provider/MailSync$Message;->messageId:J

    iget-object v5, v12, Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;->attachment:Lcom/google/android/gm/provider/Gmail$Attachment;

    iget-object v5, v5, Lcom/google/android/gm/provider/Gmail$Attachment;->partId:Ljava/lang/String;

    iget-object v6, v12, Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;->rendition:Lcom/google/android/gm/provider/Gmail$AttachmentRendition;

    iget-boolean v7, v12, Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;->saveToSd:Z

    invoke-virtual/range {v0 .. v7}, Lcom/google/android/gm/provider/AttachmentManager;->resetAttachmentRequest(JJLjava/lang/String;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;Z)I

    .line 2213
    :cond_3
    iget-object v1, v12, Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;->message:Lcom/google/android/gm/provider/MailSync$Message;

    iget-wide v1, v1, Lcom/google/android/gm/provider/MailSync$Message;->conversationId:J

    iget-object v3, v12, Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;->message:Lcom/google/android/gm/provider/MailSync$Message;

    iget-wide v3, v3, Lcom/google/android/gm/provider/MailSync$Message;->messageId:J

    iget-object v5, v12, Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;->attachment:Lcom/google/android/gm/provider/Gmail$Attachment;

    iget-object v6, v12, Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;->rendition:Lcom/google/android/gm/provider/Gmail$AttachmentRendition;

    iget-boolean v7, v12, Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;->saveToSd:Z

    invoke-virtual/range {v0 .. v8}, Lcom/google/android/gm/provider/AttachmentManager;->queryAndStartDownloadingAttachment(JJLcom/google/android/gm/provider/Gmail$Attachment;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;Z[Ljava/lang/String;)Landroid/database/Cursor;

    move v6, v9

    .line 2216
    goto/16 :goto_0

    :cond_4
    move v0, v6

    .line 2183
    goto :goto_2

    :cond_5
    move v5, v6

    .line 2186
    goto :goto_3

    :cond_6
    move v5, v6

    .line 2224
    goto :goto_1

    .line 2179
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
        :pswitch_2
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method private updateConversation(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)I
    .locals 11

    .prologue
    .line 915
    invoke-direct {p0, p2}, Lcom/google/android/gm/provider/UiProvider;->getOrMakeMailEngine(Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;

    move-result-object v10

    .line 916
    const/4 v1, 0x0

    .line 917
    const/4 v6, 0x0

    .line 918
    invoke-static {p1}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v2

    .line 919
    const-string v0, "operation"

    invoke-virtual {p3, v0}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 920
    const-string v0, "operation"

    invoke-virtual {p3, v0}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 923
    const-string v4, "discard_drafts"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_5

    .line 924
    const/4 v0, 0x1

    :goto_0
    move-object v4, v1

    move v1, v0

    .line 938
    :goto_1
    if-nez v4, :cond_0

    .line 939
    new-instance v4, Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;

    const/4 v9, 0x0

    move-object v5, p0

    move-object v6, p2

    move-wide v7, v2

    invoke-direct/range {v4 .. v9}, Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;-><init>(Lcom/google/android/gm/provider/UiProvider;Ljava/lang/String;JLcom/google/android/gm/provider/UiProvider$1;)V

    .line 941
    :cond_0
    sget-object v0, Lcom/android/mail/providers/UIProvider$ConversationColumns;->STARRED:Ljava/lang/String;

    invoke-virtual {p3, v0}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 942
    invoke-virtual {p0}, Lcom/google/android/gm/provider/UiProvider;->getContext()Landroid/content/Context;

    move-result-object v0

    const-string v5, "^t"

    invoke-static {v0, p2, v5}, Lcom/google/android/gm/provider/LabelManager;->getLabel(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gm/provider/Label;

    move-result-object v0

    sget-object v5, Lcom/android/mail/providers/UIProvider$ConversationColumns;->STARRED:Ljava/lang/String;

    invoke-virtual {p3, v5}, Landroid/content/ContentValues;->getAsBoolean(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v5

    invoke-virtual {v4, v0, v5}, Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;->add(Lcom/google/android/gm/provider/Label;Z)V

    .line 945
    :cond_1
    sget-object v0, Lcom/android/mail/providers/UIProvider$ConversationColumns;->READ:Ljava/lang/String;

    invoke-virtual {p3, v0}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 946
    invoke-virtual {p0}, Lcom/google/android/gm/provider/UiProvider;->getContext()Landroid/content/Context;

    move-result-object v0

    const-string v5, "^u"

    invoke-static {v0, p2, v5}, Lcom/google/android/gm/provider/LabelManager;->getLabel(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gm/provider/Label;

    move-result-object v5

    sget-object v0, Lcom/android/mail/providers/UIProvider$ConversationColumns;->READ:Ljava/lang/String;

    invoke-virtual {p3, v0}, Landroid/content/ContentValues;->getAsBoolean(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_7

    const/4 v0, 0x1

    :goto_2
    invoke-virtual {v4, v5, v0}, Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;->add(Lcom/google/android/gm/provider/Label;Z)V

    .line 949
    :cond_2
    const-string v0, "viewed"

    invoke-virtual {p3, v0}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 950
    invoke-virtual {p0}, Lcom/google/android/gm/provider/UiProvider;->getContext()Landroid/content/Context;

    move-result-object v0

    const-string v5, "^o"

    invoke-static {v0, p2, v5}, Lcom/google/android/gm/provider/LabelManager;->getLabel(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gm/provider/Label;

    move-result-object v0

    const/4 v5, 0x1

    invoke-virtual {v4, v0, v5}, Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;->add(Lcom/google/android/gm/provider/Label;Z)V

    .line 953
    :cond_3
    sget-object v0, Lcom/android/mail/providers/UIProvider$ConversationColumns;->PRIORITY:Ljava/lang/String;

    invoke-virtual {p3, v0}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 954
    sget-object v0, Lcom/android/mail/providers/UIProvider$ConversationColumns;->PRIORITY:Ljava/lang/String;

    invoke-virtual {p3, v0}, Landroid/content/ContentValues;->getAsInteger(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    const/4 v5, 0x1

    if-ne v0, v5, :cond_8

    const/4 v0, 0x1

    .line 956
    :goto_3
    if-eqz v0, :cond_9

    const-string v0, "^^important"

    .line 958
    :goto_4
    invoke-virtual {p0}, Lcom/google/android/gm/provider/UiProvider;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-static {v5, p2, v0}, Lcom/google/android/gm/provider/LabelManager;->getLabel(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gm/provider/Label;

    move-result-object v0

    const/4 v5, 0x1

    invoke-virtual {v4, v0, v5}, Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;->add(Lcom/google/android/gm/provider/Label;Z)V

    .line 961
    :cond_4
    const/4 v0, 0x0

    .line 963
    if-eqz v1, :cond_a

    .line 964
    invoke-virtual {v10, v2, v3}, Lcom/google/android/gm/provider/MailEngine;->expungeDraftMessages(J)I

    move-result v0

    move v1, v0

    .line 968
    :goto_5
    invoke-virtual {v4}, Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;->undoOperation()Lcom/google/android/gm/LabelOperations;

    move-result-object v0

    check-cast v0, Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;

    .line 970
    invoke-direct {p0, p4, v0}, Lcom/google/android/gm/provider/UiProvider;->addUndoOperation(ILcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;)V

    .line 972
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    const/4 v2, 0x0

    aput-object p1, v0, v2

    invoke-direct {p0, v0, p2, v4}, Lcom/google/android/gm/provider/UiProvider;->addRemoveLabel([Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gm/LabelOperations;)I

    move-result v0

    add-int/2addr v0, v1

    .line 973
    return v0

    .line 927
    :cond_5
    invoke-direct {p0, p2, v2, v3, v0}, Lcom/google/android/gm/provider/UiProvider;->createLabelOperationsForUIOperation(Ljava/lang/String;JLjava/lang/String;)Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;

    move-result-object v0

    move-object v1, v0

    move v0, v6

    goto/16 :goto_0

    .line 930
    :cond_6
    const-string v0, "rawFolders"

    invoke-virtual {p3, v0}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_b

    .line 932
    invoke-virtual {p0}, Lcom/google/android/gm/provider/UiProvider;->getContext()Landroid/content/Context;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gm/provider/UiProvider;->mGmail:Lcom/google/android/gm/provider/Gmail;

    invoke-virtual {v10, v0, p1, v1}, Lcom/google/android/gm/provider/MailEngine;->getLabelsForConversation(Landroid/content/Context;Ljava/lang/String;Lcom/google/android/gm/provider/Gmail;)Ljava/util/List;

    move-result-object v5

    .line 934
    const-string v0, "rawFolders"

    invoke-virtual {p3, v0}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/android/mail/providers/Folder;->getFoldersArray(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v4

    move-object v0, p0

    move-object v1, p2

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gm/provider/UiProvider;->createLabelOperations(Ljava/lang/String;JLjava/util/List;Ljava/util/List;)Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;

    move-result-object v1

    move-object v4, v1

    move v1, v6

    goto/16 :goto_1

    .line 946
    :cond_7
    const/4 v0, 0x0

    goto/16 :goto_2

    .line 954
    :cond_8
    const/4 v0, 0x0

    goto :goto_3

    .line 956
    :cond_9
    const-string v0, "^^unimportant"

    goto :goto_4

    :cond_a
    move v1, v0

    goto :goto_5

    :cond_b
    move-object v4, v1

    move v1, v6

    goto/16 :goto_1
.end method

.method private updateLabelsLastTouched(Lcom/google/android/gm/provider/MailEngine;Ljava/lang/String;Landroid/content/ContentValues;)I
    .locals 21
    .param p1, "engine"    # Lcom/google/android/gm/provider/MailEngine;
    .param p2, "account"    # Ljava/lang/String;
    .param p3, "values"    # Landroid/content/ContentValues;

    .prologue
    .line 1065
    invoke-virtual/range {p3 .. p3}, Landroid/content/ContentValues;->keySet()Ljava/util/Set;

    move-result-object v7

    .line 1066
    .local v7, "folderUriSet":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    new-instance v5, Landroid/content/ContentValues;

    invoke-virtual/range {p3 .. p3}, Landroid/content/ContentValues;->size()I

    move-result v16

    move/from16 v0, v16

    invoke-direct {v5, v0}, Landroid/content/ContentValues;-><init>(I)V

    .line 1067
    .local v5, "convertedValues":Landroid/content/ContentValues;
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v12

    .line 1069
    .local v12, "now":J
    invoke-interface {v7}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v8

    .local v8, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v16

    if-eqz v16, :cond_0

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Ljava/lang/String;

    .line 1070
    .local v15, "uri":Ljava/lang/String;
    invoke-static {v15}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v6

    .line 1071
    .local v6, "folderUri":Landroid/net/Uri;
    invoke-virtual {v6}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v2

    .line 1072
    .local v2, "canonicalName":Ljava/lang/String;
    invoke-static {v12, v13}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-virtual {v5, v2, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    goto :goto_0

    .line 1077
    .end local v2    # "canonicalName":Ljava/lang/String;
    .end local v6    # "folderUri":Landroid/net/Uri;
    .end local v15    # "uri":Ljava/lang/String;
    :cond_0
    invoke-virtual {v5}, Landroid/content/ContentValues;->keySet()Ljava/util/Set;

    move-result-object v3

    .line 1078
    .local v3, "canonicalNameSet":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    const-string v16, "Gmail"

    const/16 v17, 0x2

    invoke-static/range {v16 .. v17}, Lcom/google/android/gm/provider/LogUtils;->isLoggable(Ljava/lang/String;I)Z

    move-result v16

    if-eqz v16, :cond_1

    .line 1079
    const-string v16, "Gmail"

    const-string v17, "Updating last touched for labels: %s"

    const/16 v18, 0x1

    move/from16 v0, v18

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v18, v0

    const/16 v19, 0x0

    invoke-static {v3}, Lcom/google/android/gm/provider/LogUtils;->labelSetToString(Ljava/util/Set;)Ljava/lang/String;

    move-result-object v20

    aput-object v20, v18, v19

    invoke-static/range {v16 .. v18}, Lcom/google/android/gm/provider/LogUtils;->v(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1083
    :cond_1
    invoke-interface {v3}, Ljava/util/Set;->size()I

    move-result v16

    move/from16 v0, v16

    new-array v0, v0, [Ljava/lang/String;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-interface {v3, v0}, Ljava/util/Set;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v4

    check-cast v4, [Ljava/lang/String;

    .line 1085
    .local v4, "canonicalNames":[Ljava/lang/String;
    move-object/from16 v0, p1

    invoke-virtual {v0, v4}, Lcom/google/android/gm/provider/MailEngine;->getLabelsForCanonicalNames([Ljava/lang/String;)[Lcom/google/android/gm/provider/MailCore$Label;

    move-result-object v10

    .line 1086
    .local v10, "labels":[Lcom/google/android/gm/provider/MailCore$Label;
    move-object v1, v10

    .local v1, "arr$":[Lcom/google/android/gm/provider/MailCore$Label;
    array-length v11, v1

    .local v11, "len$":I
    const/4 v8, 0x0

    .local v8, "i$":I
    :goto_1
    if-ge v8, v11, :cond_3

    aget-object v9, v1, v8

    .line 1087
    .local v9, "label":Lcom/google/android/gm/provider/MailCore$Label;
    if-eqz v9, :cond_2

    .line 1088
    move-object/from16 v0, p1

    invoke-virtual {v0, v9}, Lcom/google/android/gm/provider/MailEngine;->clearNewUnreadMailForNotificationLabelIfNeeded(Lcom/google/android/gm/provider/MailCore$Label;)V

    .line 1086
    :cond_2
    add-int/lit8 v8, v8, 0x1

    goto :goto_1

    .line 1091
    .end local v9    # "label":Lcom/google/android/gm/provider/MailCore$Label;
    :cond_3
    move-object/from16 v0, p1

    invoke-virtual {v0, v5}, Lcom/google/android/gm/provider/MailEngine;->updateLabelsLastTouched(Landroid/content/ContentValues;)I

    move-result v14

    .line 1092
    .local v14, "numChanged":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/android/gm/provider/UiProvider;->mContentResolver:Landroid/content/ContentResolver;

    move-object/from16 v16, v0

    invoke-static/range {p2 .. p2}, Lcom/google/android/gm/provider/UiProvider;->getRecentFoldersUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v17

    const/16 v18, 0x0

    const/16 v19, 0x0

    invoke-virtual/range {v16 .. v19}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;Z)V

    .line 1093
    return v14
.end method

.method private updateMessageState(Ljava/lang/String;Landroid/net/Uri;Landroid/content/ContentValues;)I
    .locals 12

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 2258
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/UiProvider;->getOrMakeMailEngine(Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;

    move-result-object v0

    .line 2259
    invoke-virtual {p2}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v3

    .line 2261
    sget-object v5, Lcom/android/mail/providers/UIProvider$MessageColumns;->READ:Ljava/lang/String;

    invoke-virtual {p3, v5}, Landroid/content/ContentValues;->getAsInteger(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v5

    .line 2262
    sget-object v6, Lcom/android/mail/providers/UIProvider$MessageColumns;->STARRED:Ljava/lang/String;

    invoke-virtual {p3, v6}, Landroid/content/ContentValues;->getAsInteger(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v6

    .line 2263
    const-string v7, "alwaysShowImages"

    invoke-virtual {p3, v7}, Landroid/content/ContentValues;->getAsInteger(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v7

    .line 2266
    if-nez v7, :cond_0

    if-nez v5, :cond_0

    if-nez v6, :cond_0

    .line 2331
    :goto_0
    return v2

    .line 2272
    :cond_0
    invoke-virtual {v0, v3, v4, v2}, Lcom/google/android/gm/provider/MailEngine;->getLocalMessage(JZ)Lcom/google/android/gm/provider/MailSync$Message;

    move-result-object v8

    .line 2275
    if-nez v8, :cond_1

    .line 2276
    const-string v0, "Gmail"

    const-string v5, "Error finding message for localMessageId: %d"

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v5, v1}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0

    .line 2282
    :cond_1
    if-eqz v5, :cond_7

    .line 2283
    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v0

    if-nez v0, :cond_4

    move v0, v1

    .line 2285
    :goto_1
    new-instance v5, Landroid/content/ContentValues;

    invoke-direct {v5}, Landroid/content/ContentValues;-><init>()V

    .line 2287
    const-string v9, "canonicalName"

    const-string v10, "^u"

    invoke-virtual {v5, v9, v10}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 2288
    const-string v9, "_id"

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v10

    invoke-virtual {v5, v9, v10}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 2289
    const-string v9, "messageId"

    iget-wide v10, v8, Lcom/google/android/gm/provider/MailSync$Message;->messageId:J

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v10

    invoke-virtual {v5, v9, v10}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 2290
    const-string v9, "conversation"

    iget-wide v10, v8, Lcom/google/android/gm/provider/MailSync$Message;->conversationId:J

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v10

    invoke-virtual {v5, v9, v10}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 2291
    const-string v9, "add_label_action"

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v5, v9, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 2296
    iget-object v0, p0, Lcom/google/android/gm/provider/UiProvider;->mGmail:Lcom/google/android/gm/provider/Gmail;

    new-array v9, v1, [Landroid/content/ContentValues;

    aput-object v5, v9, v2

    invoke-virtual {v0, p1, v9, v1}, Lcom/google/android/gm/provider/Gmail;->addOrRemoveLabelOnMessageBulk(Ljava/lang/String;[Landroid/content/ContentValues;Z)V

    move v0, v1

    .line 2301
    :goto_2
    if-eqz v6, :cond_2

    .line 2302
    invoke-virtual {v6}, Ljava/lang/Integer;->intValue()I

    move-result v0

    if-eqz v0, :cond_5

    move v0, v1

    .line 2304
    :goto_3
    new-instance v5, Landroid/content/ContentValues;

    invoke-direct {v5}, Landroid/content/ContentValues;-><init>()V

    .line 2306
    const-string v6, "canonicalName"

    const-string v9, "^t"

    invoke-virtual {v5, v6, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 2307
    const-string v6, "_id"

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v5, v6, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 2308
    const-string v3, "messageId"

    iget-wide v9, v8, Lcom/google/android/gm/provider/MailSync$Message;->messageId:J

    invoke-static {v9, v10}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v5, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 2309
    const-string v3, "conversation"

    iget-wide v9, v8, Lcom/google/android/gm/provider/MailSync$Message;->conversationId:J

    invoke-static {v9, v10}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v5, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 2310
    const-string v3, "add_label_action"

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v5, v3, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 2315
    iget-object v0, p0, Lcom/google/android/gm/provider/UiProvider;->mGmail:Lcom/google/android/gm/provider/Gmail;

    new-array v3, v1, [Landroid/content/ContentValues;

    aput-object v5, v3, v2

    invoke-virtual {v0, p1, v3, v1}, Lcom/google/android/gm/provider/Gmail;->addOrRemoveLabelOnMessageBulk(Ljava/lang/String;[Landroid/content/ContentValues;Z)V

    move v0, v1

    .line 2320
    :cond_2
    if-eqz v7, :cond_3

    invoke-virtual {v7}, Ljava/lang/Integer;->intValue()I

    move-result v3

    if-eqz v3, :cond_3

    .line 2324
    invoke-static {}, Lcom/google/android/gm/persistence/Persistence;->getInstance()Lcom/google/android/gm/persistence/Persistence;

    move-result-object v0

    .line 2325
    iget-object v3, v8, Lcom/google/android/gm/provider/MailSync$Message;->fromAddress:Ljava/lang/String;

    invoke-static {v3}, Lcom/google/android/gm/provider/UiProvider;->getEmailAddress(Ljava/lang/String;)Lcom/google/android/gm/EmailAddress;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/android/gm/EmailAddress;->getAddress()Ljava/lang/String;

    move-result-object v3

    .line 2326
    invoke-virtual {p0}, Lcom/google/android/gm/provider/UiProvider;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v0, v4, v3}, Lcom/google/android/gm/persistence/Persistence;->setDisplayImagesFromSender(Landroid/content/Context;Ljava/lang/String;)V

    move v0, v1

    .line 2331
    :cond_3
    if-eqz v0, :cond_6

    :goto_4
    move v2, v1

    goto/16 :goto_0

    :cond_4
    move v0, v2

    .line 2283
    goto/16 :goto_1

    :cond_5
    move v0, v2

    .line 2302
    goto :goto_3

    :cond_6
    move v1, v2

    .line 2331
    goto :goto_4

    :cond_7
    move v0, v2

    goto :goto_2
.end method

.method private updateSearchResultCount(Ljava/lang/String;ILjava/lang/String;)V
    .locals 5
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "numResults"    # I
    .param p3, "queryStr"    # Ljava/lang/String;

    .prologue
    .line 738
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/UiProvider;->getOrCreateAccountState(Ljava/lang/String;)Lcom/google/android/gm/provider/uiprovider/AccountState;

    move-result-object v0

    .line 739
    .local v0, "accountState":Lcom/google/android/gm/provider/uiprovider/AccountState;
    invoke-virtual {v0, p3, p2}, Lcom/google/android/gm/provider/uiprovider/AccountState;->setNumSearchResults(Ljava/lang/String;I)V

    .line 741
    iget-object v1, p0, Lcom/google/android/gm/provider/UiProvider;->mContentResolver:Landroid/content/ContentResolver;

    invoke-static {p1}, Lcom/google/android/gm/provider/UiProvider;->getAccountSearchUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;Z)V

    .line 742
    return-void
.end method


# virtual methods
.method public applyBatch(Ljava/util/ArrayList;)[Landroid/content/ContentProviderResult;
    .locals 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Landroid/content/ContentProviderOperation;",
            ">;)[",
            "Landroid/content/ContentProviderResult;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/content/OperationApplicationException;
        }
    .end annotation

    .prologue
    .local p1, "operations":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/content/ContentProviderOperation;>;"
    const/4 v10, 0x1

    .line 879
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v1

    .line 880
    .local v1, "affectedAccounts":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/content/ContentProviderOperation;

    .line 881
    .local v5, "operation":Landroid/content/ContentProviderOperation;
    invoke-virtual {v5}, Landroid/content/ContentProviderOperation;->getUri()Landroid/net/Uri;

    move-result-object v6

    .line 882
    .local v6, "operationUri":Landroid/net/Uri;
    invoke-virtual {v6}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v8

    const/4 v9, 0x0

    invoke-interface {v8, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 884
    .local v0, "account":Ljava/lang/String;
    invoke-interface {v1, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 888
    .end local v0    # "account":Ljava/lang/String;
    .end local v5    # "operation":Landroid/content/ContentProviderOperation;
    .end local v6    # "operationUri":Landroid/net/Uri;
    :cond_0
    invoke-interface {v1}, Ljava/util/Set;->size()I

    move-result v8

    if-ne v8, v10, :cond_5

    .line 889
    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .line 890
    .local v3, "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_4

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    invoke-direct {p0, v8}, Lcom/google/android/gm/provider/UiProvider;->getOrMakeMailEngine(Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;

    move-result-object v4

    .line 897
    .end local v3    # "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    .local v4, "mailEngine":Lcom/google/android/gm/provider/MailEngine;
    :goto_1
    if-eqz v4, :cond_1

    .line 898
    const/4 v8, 0x1

    :try_start_0
    invoke-virtual {v4, v8}, Lcom/google/android/gm/provider/MailEngine;->beginTransaction(Z)V

    .line 900
    :cond_1
    invoke-super {p0, p1}, Landroid/content/ContentProvider;->applyBatch(Ljava/util/ArrayList;)[Landroid/content/ContentProviderResult;

    move-result-object v7

    .line 901
    .local v7, "results":[Landroid/content/ContentProviderResult;
    if-eqz v4, :cond_2

    .line 902
    invoke-virtual {v4}, Lcom/google/android/gm/provider/MailEngine;->setTransactionSuccessful()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 906
    :cond_2
    if-eqz v4, :cond_3

    .line 907
    invoke-virtual {v4}, Lcom/google/android/gm/provider/MailEngine;->endTransaction()V

    :cond_3
    return-object v7

    .line 890
    .end local v4    # "mailEngine":Lcom/google/android/gm/provider/MailEngine;
    .end local v7    # "results":[Landroid/content/ContentProviderResult;
    .restart local v3    # "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_4
    const/4 v4, 0x0

    goto :goto_1

    .line 892
    .end local v3    # "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_5
    const/4 v4, 0x0

    .restart local v4    # "mailEngine":Lcom/google/android/gm/provider/MailEngine;
    goto :goto_1

    .line 906
    :catchall_0
    move-exception v8

    if-eqz v4, :cond_6

    .line 907
    invoke-virtual {v4}, Lcom/google/android/gm/provider/MailEngine;->endTransaction()V

    :cond_6
    throw v8
.end method

.method public delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 11
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "selection"    # Ljava/lang/String;
    .param p3, "selectionArgs"    # [Ljava/lang/String;

    .prologue
    const/4 v10, 0x0

    .line 848
    const-string v6, "Gmail"

    const/4 v7, 0x3

    invoke-static {v6, v7}, Lcom/google/android/gm/provider/LogUtils;->isLoggable(Ljava/lang/String;I)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 849
    const-string v6, "Gmail"

    const-string v7, "UiProvider.delete: %s"

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Object;

    invoke-static {p1}, Lcom/google/android/gm/provider/LogUtils;->contentUriToString(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v8, v10

    invoke-static {v6, v7, v8}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 851
    :cond_0
    sget-object v6, Lcom/google/android/gm/provider/UiProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v6, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v3

    .line 852
    .local v3, "match":I
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v6

    invoke-interface {v6, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 853
    .local v0, "account":Ljava/lang/String;
    const/4 v1, 0x0

    .line 854
    .local v1, "count":I
    const-string v2, ""

    .line 856
    .local v2, "id":Ljava/lang/String;
    packed-switch v3, :pswitch_data_0

    .line 872
    :goto_0
    return v1

    .line 858
    :pswitch_0
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v6

    const/4 v7, 0x2

    invoke-interface {v6, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    .end local v2    # "id":Ljava/lang/String;
    check-cast v2, Ljava/lang/String;

    .line 859
    .restart local v2    # "id":Ljava/lang/String;
    const/4 v4, -0x1

    .line 860
    .local v4, "sequenceNum":I
    const-string v6, "seq"

    invoke-virtual {p1, v6}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 862
    .local v5, "sequenceString":Ljava/lang/String;
    if-eqz v5, :cond_1

    .line 863
    invoke-static {v5}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v4

    .line 865
    :cond_1
    invoke-direct {p0, v2, v0, v4}, Lcom/google/android/gm/provider/UiProvider;->delete(Ljava/lang/String;Ljava/lang/String;I)I

    move-result v1

    .line 866
    goto :goto_0

    .line 856
    :pswitch_data_0
    .packed-switch 0xd
        :pswitch_0
    .end packed-switch
.end method

.method public getType(Landroid/net/Uri;)Ljava/lang/String;
    .locals 5

    .prologue
    .line 1387
    const-string v0, "Gmail"

    const/4 v1, 0x3

    invoke-static {v0, v1}, Lcom/google/android/gm/provider/LogUtils;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1388
    const-string v0, "Gmail"

    const-string v1, "UiProvider.getType: %s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-static {p1}, Lcom/google/android/gm/provider/LogUtils;->contentUriToString(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1391
    :cond_0
    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v0, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    .line 1393
    packed-switch v0, :pswitch_data_0

    .line 1397
    const/4 v0, 0x0

    :goto_0
    return-object v0

    .line 1395
    :pswitch_0
    const-string v0, "mimeType"

    invoke-virtual {p1, v0}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1393
    :pswitch_data_0
    .packed-switch 0x17
        :pswitch_0
    .end packed-switch
.end method

.method public insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    .locals 12
    .param p1, "url"    # Landroid/net/Uri;
    .param p2, "values"    # Landroid/content/ContentValues;

    .prologue
    const/4 v11, 0x2

    const/4 v10, 0x1

    const/4 v9, 0x0

    .line 746
    const-string v5, "Gmail"

    const/4 v6, 0x3

    invoke-static {v5, v6}, Lcom/google/android/gm/provider/LogUtils;->isLoggable(Ljava/lang/String;I)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 747
    const-string v5, "Gmail"

    const-string v6, "UiProvider.insert: %s(%s)"

    new-array v7, v11, [Ljava/lang/Object;

    invoke-static {p1}, Lcom/google/android/gm/provider/LogUtils;->contentUriToString(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v7, v9

    aput-object p2, v7, v10

    invoke-static {v5, v6, v7}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 751
    :cond_0
    sget-object v5, Lcom/google/android/gm/provider/UiProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v5, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v4

    .line 752
    .local v4, "match":I
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v5

    invoke-interface {v5, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 753
    .local v0, "account":Ljava/lang/String;
    invoke-direct {p0, v0}, Lcom/google/android/gm/provider/UiProvider;->getOrMakeMailEngine(Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;

    move-result-object v3

    .line 756
    .local v3, "mailEngine":Lcom/google/android/gm/provider/MailEngine;
    invoke-static {v0}, Lcom/google/android/gm/provider/MailIndexerService;->onContentProviderAccess(Ljava/lang/String;)V

    .line 758
    packed-switch v4, :pswitch_data_0

    .line 772
    const-string v5, "Gmail"

    const-string v6, "Unexpected UiProvider.insert: %s(%s)"

    new-array v7, v11, [Ljava/lang/Object;

    invoke-static {p1}, Lcom/google/android/gm/provider/LogUtils;->contentUriToString(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v7, v9

    aput-object p2, v7, v10

    invoke-static {v5, v6, v7}, Lcom/google/android/gm/provider/LogUtils;->wtf(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 776
    const/4 v5, 0x0

    :goto_0
    return-object v5

    .line 760
    :pswitch_0
    invoke-direct {p0, v3, p2}, Lcom/google/android/gm/provider/UiProvider;->sendMessage(Lcom/google/android/gm/provider/MailEngine;Landroid/content/ContentValues;)J

    move-result-wide v1

    .line 761
    .local v1, "localMessageId":J
    const-string v5, "Gmail"

    const-string v6, "UiProvider.insert(): added local message %d"

    new-array v7, v10, [Ljava/lang/Object;

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    aput-object v8, v7, v9

    invoke-static {v5, v6, v7}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 763
    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/UiProvider;->getMessageByIdUri(Ljava/lang/String;J)Landroid/net/Uri;

    move-result-object v5

    goto :goto_0

    .line 766
    .end local v1    # "localMessageId":J
    :pswitch_1
    invoke-direct {p0, v3, p2}, Lcom/google/android/gm/provider/UiProvider;->saveDraft(Lcom/google/android/gm/provider/MailEngine;Landroid/content/ContentValues;)J

    move-result-wide v1

    .line 767
    .restart local v1    # "localMessageId":J
    const-string v5, "Gmail"

    const-string v6, "UiProvider.insert(): added local message %d"

    new-array v7, v10, [Ljava/lang/Object;

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    aput-object v8, v7, v9

    invoke-static {v5, v6, v7}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 769
    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/UiProvider;->getMessageByIdUri(Ljava/lang/String;J)Landroid/net/Uri;

    move-result-object v5

    goto :goto_0

    .line 758
    :pswitch_data_0
    .packed-switch 0x8
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public onCreate()Z
    .locals 3

    .prologue
    .line 499
    invoke-virtual {p0}, Lcom/google/android/gm/provider/UiProvider;->getContext()Landroid/content/Context;

    move-result-object v0

    .line 500
    .local v0, "context":Landroid/content/Context;
    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    iput-object v1, p0, Lcom/google/android/gm/provider/UiProvider;->mContentResolver:Landroid/content/ContentResolver;

    .line 501
    new-instance v1, Lcom/google/android/gm/provider/Gmail;

    iget-object v2, p0, Lcom/google/android/gm/provider/UiProvider;->mContentResolver:Landroid/content/ContentResolver;

    invoke-direct {v1, v2}, Lcom/google/android/gm/provider/Gmail;-><init>(Landroid/content/ContentResolver;)V

    iput-object v1, p0, Lcom/google/android/gm/provider/UiProvider;->mGmail:Lcom/google/android/gm/provider/Gmail;

    .line 503
    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0a003e

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v1

    sput v1, Lcom/google/android/gm/provider/UiProvider;->sAccountNotificationDelayMs:I

    .line 505
    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0c0106

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    sput-object v1, Lcom/google/android/gm/provider/UiProvider;->sGmailQuote:Ljava/lang/String;

    .line 506
    invoke-direct {p0}, Lcom/google/android/gm/provider/UiProvider;->intializeLoaderHandler()V

    .line 507
    sput-object p0, Lcom/google/android/gm/provider/UiProvider;->sInstance:Lcom/google/android/gm/provider/UiProvider;

    .line 508
    const/4 v1, 0x1

    return v1
.end method

.method public onMailEngineResult(Lcom/google/android/gm/provider/MailEngine;)V
    .locals 2
    .param p1, "engine"    # Lcom/google/android/gm/provider/MailEngine;

    .prologue
    .line 3057
    iget-object v0, p0, Lcom/google/android/gm/provider/UiProvider;->mAccountsPendingInitialization:Ljava/util/Set;

    invoke-virtual {p1}, Lcom/google/android/gm/provider/MailEngine;->getAccountName()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 3059
    invoke-direct {p0}, Lcom/google/android/gm/provider/UiProvider;->updateAccountsIntializedStatus()V

    .line 3060
    return-void
.end method

.method public query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    .locals 20

    .prologue
    .line 529
    const-string v2, "Gmail"

    const/4 v3, 0x3

    invoke-static {v2, v3}, Lcom/google/android/gm/provider/LogUtils;->isLoggable(Ljava/lang/String;I)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 530
    const-string v2, "Gmail"

    const-string v3, "UiProvider.query: %s(%s, %s)"

    const/4 v4, 0x3

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-static/range {p1 .. p1}, Lcom/google/android/gm/provider/LogUtils;->contentUriToString(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    aput-object p3, v4, v5

    const/4 v5, 0x2

    invoke-static/range {p4 .. p4}, Ljava/util/Arrays;->toString([Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v2, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 534
    :cond_0
    sget-object v2, Lcom/google/android/gm/provider/UiProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    move-object/from16 v0, p1

    invoke-virtual {v2, v0}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v4

    .line 536
    const/4 v2, 0x1

    if-ne v4, v2, :cond_2

    .line 537
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-direct {v0, v1}, Lcom/google/android/gm/provider/UiProvider;->getAccountsCursor([Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v2

    .line 538
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/UiProvider;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v4, Lcom/google/android/gm/provider/UiProvider;->ACCOUNTS_URI:Landroid/net/Uri;

    invoke-interface {v2, v3, v4}, Landroid/database/Cursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    .line 733
    :cond_1
    :goto_0
    return-object v2

    .line 542
    :cond_2
    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v2

    const/4 v3, 0x0

    invoke-interface {v2, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 543
    const/4 v2, 0x0

    .line 544
    const/16 v17, 0x1

    .line 545
    packed-switch v4, :pswitch_data_0

    :pswitch_0
    move/from16 v4, v17

    .line 729
    :goto_1
    if-eqz v2, :cond_1

    if-eqz v4, :cond_1

    .line 730
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/google/android/gm/provider/UiProvider;->mContentResolver:Landroid/content/ContentResolver;

    invoke-static {v3}, Lcom/google/android/gm/provider/UiProvider;->getAccountBaseNotificationUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    invoke-interface {v2, v4, v3}, Landroid/database/Cursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    goto :goto_0

    .line 547
    :pswitch_1
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-direct {v0, v3, v1}, Lcom/google/android/gm/provider/UiProvider;->getAccountCursor(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v4

    .line 548
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/UiProvider;->mContentResolver:Landroid/content/ContentResolver;

    move-object/from16 v0, p1

    invoke-interface {v4, v2, v0}, Landroid/database/Cursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    .line 549
    const/4 v2, 0x0

    move/from16 v19, v2

    move-object v2, v4

    move/from16 v4, v19

    .line 550
    goto :goto_1

    .line 554
    :pswitch_2
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-direct {v0, v3, v1}, Lcom/google/android/gm/provider/UiProvider;->getAccountLabelsCursor(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v4

    .line 555
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/UiProvider;->mContentResolver:Landroid/content/ContentResolver;

    invoke-static {v3}, Lcom/google/android/gm/provider/UiProvider;->getAccountFoldersUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v5

    invoke-interface {v4, v2, v5}, Landroid/database/Cursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    .line 556
    const/4 v2, 0x0

    move/from16 v19, v2

    move-object v2, v4

    move/from16 v4, v19

    .line 557
    goto :goto_1

    .line 561
    :pswitch_3
    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v2

    .line 562
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-direct {v0, v3, v2, v1}, Lcom/google/android/gm/provider/UiProvider;->getAccountLabelCursor(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v4

    .line 563
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/google/android/gm/provider/UiProvider;->mContentResolver:Landroid/content/ContentResolver;

    invoke-static {v3, v2}, Lcom/google/android/gm/provider/UiProvider;->getAccountLabelNotificationUri(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-interface {v4, v5, v2}, Landroid/database/Cursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    .line 565
    const/4 v2, 0x0

    move/from16 v19, v2

    move-object v2, v4

    move/from16 v4, v19

    .line 566
    goto :goto_1

    .line 571
    :pswitch_4
    const-string v2, "limit"

    move-object/from16 v0, p1

    invoke-virtual {v0, v2}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 573
    const/4 v8, 0x0

    .line 575
    :try_start_0
    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_2

    move-result-object v8

    .line 580
    :goto_2
    const/4 v9, 0x1

    .line 581
    const-string v2, "use_network"

    move-object/from16 v0, p1

    invoke-virtual {v0, v2}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 583
    if-eqz v2, :cond_3

    .line 584
    invoke-static {v2}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v9

    .line 590
    :cond_3
    const/4 v2, 0x0

    .line 591
    const-string v5, "all_notifications"

    move-object/from16 v0, p1

    invoke-virtual {v0, v5}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 593
    if-eqz v5, :cond_b

    .line 594
    invoke-static {v5}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v2

    move/from16 v18, v2

    .line 597
    :goto_3
    const/4 v2, 0x4

    if-ne v4, v2, :cond_5

    .line 598
    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v2

    const/4 v4, 0x2

    invoke-interface {v2, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 601
    :try_start_1
    invoke-static {v2}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J
    :try_end_1
    .catch Ljava/lang/NumberFormatException; {:try_start_1 .. :try_end_1} :catch_0

    move-result-wide v5

    move-object/from16 v2, p0

    move-object/from16 v4, p1

    move-object/from16 v7, p2

    .line 608
    invoke-direct/range {v2 .. v9}, Lcom/google/android/gm/provider/UiProvider;->getConversationsForLabelId(Ljava/lang/String;Landroid/net/Uri;J[Ljava/lang/String;Ljava/lang/Integer;Z)Landroid/database/Cursor;

    move-result-object v4

    .line 617
    :goto_4
    if-nez v4, :cond_4

    .line 619
    const-string v2, "Gmail"

    const-string v4, "Returning an empty cursor instead of a null cursor"

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v2, v4, v5}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 620
    new-instance v4, Landroid/database/MatrixCursor;

    const/4 v2, 0x0

    move-object/from16 v0, p2

    invoke-direct {v4, v0, v2}, Landroid/database/MatrixCursor;-><init>([Ljava/lang/String;I)V

    .line 623
    :cond_4
    if-eqz v18, :cond_a

    if-eqz v4, :cond_a

    .line 624
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/UiProvider;->mContentResolver:Landroid/content/ContentResolver;

    invoke-static {v3}, Lcom/google/android/gm/provider/Gmail;->getBaseUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v5

    invoke-interface {v4, v2, v5}, Landroid/database/Cursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    .line 625
    const/4 v2, 0x0

    move/from16 v19, v2

    move-object v2, v4

    move/from16 v4, v19

    goto/16 :goto_1

    .line 602
    :catch_0
    move-exception v3

    .line 603
    const-string v4, "Gmail"

    const-string v5, "Unable to parse label id %s"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object v2, v6, v7

    invoke-static {v4, v3, v5, v6}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 605
    new-instance v2, Landroid/database/MatrixCursor;

    const/4 v3, 0x0

    move-object/from16 v0, p2

    invoke-direct {v2, v0, v3}, Landroid/database/MatrixCursor;-><init>([Ljava/lang/String;I)V

    goto/16 :goto_0

    .line 611
    :cond_5
    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v2

    const/4 v4, 0x2

    invoke-interface {v2, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Ljava/lang/String;

    move-object/from16 v10, p0

    move-object v11, v3

    move-object/from16 v12, p1

    move-object/from16 v14, p2

    move-object v15, v8

    move/from16 v16, v9

    .line 613
    invoke-direct/range {v10 .. v16}, Lcom/google/android/gm/provider/UiProvider;->getConversationsForLabel(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Integer;Z)Landroid/database/Cursor;

    move-result-object v4

    goto :goto_4

    .line 631
    :pswitch_5
    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v2

    const/4 v4, 0x2

    invoke-interface {v2, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 634
    :try_start_2
    invoke-static {v2}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J
    :try_end_2
    .catch Ljava/lang/NumberFormatException; {:try_start_2 .. :try_end_2} :catch_1

    move-result-wide v4

    .line 641
    const/4 v7, 0x1

    .line 642
    const-string v2, "listParams"

    move-object/from16 v0, p1

    invoke-virtual {v0, v2}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 644
    if-eqz v2, :cond_6

    .line 645
    invoke-static {v2}, Lcom/android/mail/providers/ListParams;->newinstance(Ljava/lang/String;)Lcom/android/mail/providers/ListParams;

    move-result-object v2

    .line 646
    if-eqz v2, :cond_6

    .line 647
    iget-boolean v7, v2, Lcom/android/mail/providers/ListParams;->mUseNetwork:Z

    :cond_6
    move-object/from16 v2, p0

    move-object/from16 v6, p2

    .line 651
    invoke-direct/range {v2 .. v7}, Lcom/google/android/gm/provider/UiProvider;->getMessagesForConversation(Ljava/lang/String;J[Ljava/lang/String;Z)Landroid/database/Cursor;

    move-result-object v4

    .line 653
    const/4 v2, 0x0

    move/from16 v19, v2

    move-object v2, v4

    move/from16 v4, v19

    .line 654
    goto/16 :goto_1

    .line 635
    :catch_1
    move-exception v2

    .line 637
    const/4 v2, 0x0

    goto/16 :goto_0

    .line 658
    :pswitch_6
    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v4

    .line 659
    move-object/from16 v0, p0

    invoke-direct {v0, v3, v4, v5}, Lcom/google/android/gm/provider/UiProvider;->getMessageForId(Ljava/lang/String;J)Landroid/database/Cursor;

    move-result-object v2

    move/from16 v4, v17

    .line 660
    goto/16 :goto_1

    .line 663
    :pswitch_7
    invoke-direct/range {p0 .. p2}, Lcom/google/android/gm/provider/UiProvider;->performUndo(Landroid/net/Uri;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v2

    move/from16 v4, v17

    .line 664
    goto/16 :goto_1

    .line 668
    :pswitch_8
    const/16 v2, 0x10

    if-ne v4, v2, :cond_7

    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v2

    .line 670
    :goto_5
    move-object/from16 v0, p0

    invoke-direct {v0, v3, v2}, Lcom/google/android/gm/provider/UiProvider;->performRefresh(Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v2

    move/from16 v4, v17

    .line 671
    goto/16 :goto_1

    .line 668
    :cond_7
    const/4 v2, 0x0

    goto :goto_5

    .line 674
    :pswitch_9
    const-string v2, "query"

    move-object/from16 v0, p1

    invoke-virtual {v0, v2}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 676
    const-string v2, "folder"

    move-object/from16 v0, p1

    invoke-virtual {v0, v2}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 679
    if-eqz v2, :cond_8

    .line 681
    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    .line 682
    invoke-virtual {v2}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v2

    const/4 v5, 0x2

    invoke-interface {v2, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 688
    :goto_6
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-direct {v0, v1, v3, v4, v2}, Lcom/google/android/gm/provider/UiProvider;->getFakeSearchFolder(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v4

    .line 690
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/UiProvider;->mContentResolver:Landroid/content/ContentResolver;

    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v5

    invoke-virtual {v5}, Landroid/net/Uri$Builder;->clearQuery()Landroid/net/Uri$Builder;

    move-result-object v5

    invoke-virtual {v5}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v5

    invoke-interface {v4, v2, v5}, Landroid/database/Cursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    .line 691
    const/4 v2, 0x0

    move/from16 v19, v2

    move-object v2, v4

    move/from16 v4, v19

    .line 692
    goto/16 :goto_1

    .line 685
    :cond_8
    const/4 v2, 0x0

    goto :goto_6

    .line 694
    :pswitch_a
    const-string v2, "query"

    move-object/from16 v0, p1

    invoke-virtual {v0, v2}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 696
    const-string v2, "folder"

    move-object/from16 v0, p1

    invoke-virtual {v0, v2}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 699
    if-eqz v2, :cond_9

    .line 701
    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    .line 702
    invoke-virtual {v2}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v2

    const/4 v4, 0x2

    invoke-interface {v2, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    move-object v6, v2

    .line 707
    :goto_7
    const/4 v8, 0x0

    const/4 v9, 0x1

    move-object/from16 v2, p0

    move-object/from16 v4, p1

    move-object/from16 v7, p2

    invoke-direct/range {v2 .. v9}, Lcom/google/android/gm/provider/UiProvider;->getConversationsForQuery(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Integer;Z)Landroid/database/Cursor;

    move-result-object v2

    .line 709
    invoke-interface {v2}, Landroid/database/Cursor;->getCount()I

    move-result v4

    move-object/from16 v0, p0

    invoke-direct {v0, v3, v4, v5}, Lcom/google/android/gm/provider/UiProvider;->updateSearchResultCount(Ljava/lang/String;ILjava/lang/String;)V

    move/from16 v4, v17

    .line 710
    goto/16 :goto_1

    .line 705
    :cond_9
    const/4 v6, 0x0

    goto :goto_7

    .line 712
    :pswitch_b
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-direct {v0, v3, v1}, Lcom/google/android/gm/provider/UiProvider;->getRecentLabelsCursor(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v4

    .line 713
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/UiProvider;->mContentResolver:Landroid/content/ContentResolver;

    invoke-static {v3}, Lcom/google/android/gm/provider/UiProvider;->getRecentFoldersUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v5

    invoke-interface {v4, v2, v5}, Landroid/database/Cursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    .line 714
    const/4 v2, 0x0

    move/from16 v19, v2

    move-object v2, v4

    move/from16 v4, v19

    .line 715
    goto/16 :goto_1

    .line 718
    :pswitch_c
    invoke-static/range {p1 .. p1}, Lcom/google/android/gm/provider/uiprovider/UIAttachment$UriParser;->parse(Landroid/net/Uri;)Lcom/google/android/gm/provider/uiprovider/UIAttachment$UriParser;

    move-result-object v2

    .line 720
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-direct {v0, v2, v1}, Lcom/google/android/gm/provider/UiProvider;->getMessageAttachments(Lcom/google/android/gm/provider/uiprovider/UIAttachment$UriParser;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v4

    .line 721
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/UiProvider;->mContentResolver:Landroid/content/ContentResolver;

    move-object/from16 v0, p1

    invoke-interface {v4, v2, v0}, Landroid/database/Cursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    .line 722
    const/4 v2, 0x0

    move/from16 v19, v2

    move-object v2, v4

    move/from16 v4, v19

    .line 723
    goto/16 :goto_1

    .line 725
    :pswitch_d
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-direct {v0, v3, v1}, Lcom/google/android/gm/provider/UiProvider;->getAccountCookieCursor(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v2

    move/from16 v4, v17

    goto/16 :goto_1

    .line 576
    :catch_2
    move-exception v2

    goto/16 :goto_2

    :cond_a
    move-object v2, v4

    move/from16 v4, v17

    goto/16 :goto_1

    :cond_b
    move/from16 v18, v2

    goto/16 :goto_3

    .line 545
    nop

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_1
        :pswitch_2
        :pswitch_4
        :pswitch_4
        :pswitch_5
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_6
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_7
        :pswitch_8
        :pswitch_8
        :pswitch_3
        :pswitch_9
        :pswitch_a
        :pswitch_b
        :pswitch_c
        :pswitch_c
        :pswitch_0
        :pswitch_0
        :pswitch_d
    .end packed-switch
.end method

.method public shutdown()V
    .locals 1

    .prologue
    .line 513
    const/4 v0, 0x0

    sput-object v0, Lcom/google/android/gm/provider/UiProvider;->sInstance:Lcom/google/android/gm/provider/UiProvider;

    .line 514
    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->sAccountStateMap:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 515
    return-void
.end method

.method public update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 7

    .prologue
    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v1, 0x0

    .line 782
    const-string v0, "Gmail"

    const/4 v2, 0x3

    invoke-static {v0, v2}, Lcom/google/android/gm/provider/LogUtils;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 783
    const-string v0, "Gmail"

    const-string v2, "UiProvider.update: %s(%s)"

    new-array v3, v6, [Ljava/lang/Object;

    invoke-static {p1}, Lcom/google/android/gm/provider/LogUtils;->contentUriToString(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v1

    aput-object p2, v3, v5

    invoke-static {v0, v2, v3}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 787
    :cond_0
    sget-object v0, Lcom/google/android/gm/provider/UiProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v0, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v2

    .line 788
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 789
    invoke-direct {p0, v0}, Lcom/google/android/gm/provider/UiProvider;->getOrMakeMailEngine(Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;

    move-result-object v3

    .line 792
    invoke-static {v0}, Lcom/google/android/gm/provider/MailIndexerService;->onContentProviderAccess(Ljava/lang/String;)V

    .line 794
    packed-switch v2, :pswitch_data_0

    .line 838
    :pswitch_0
    const-string v0, "Gmail"

    const-string v2, "Unexpected UiProvider.update: %s"

    new-array v3, v5, [Ljava/lang/Object;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {p1}, Lcom/google/android/gm/provider/LogUtils;->contentUriToString(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " and values are : "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {p2}, Landroid/content/ContentValues;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v1

    invoke-static {v0, v2, v3}, Lcom/google/android/gm/provider/LogUtils;->wtf(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    :goto_0
    move v0, v1

    .line 843
    :goto_1
    return v0

    .line 796
    :pswitch_1
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 797
    const/4 v2, -0x1

    .line 798
    const-string v3, "seq"

    invoke-virtual {p1, v3}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 800
    if-eqz v3, :cond_1

    .line 801
    invoke-static {v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    .line 803
    :cond_1
    invoke-direct {p0, v1, v0, p2, v2}, Lcom/google/android/gm/provider/UiProvider;->updateConversation(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)I

    move-result v0

    goto :goto_1

    .line 807
    :pswitch_2
    invoke-direct {p0, v3, p2}, Lcom/google/android/gm/provider/UiProvider;->sendMessage(Lcom/google/android/gm/provider/MailEngine;Landroid/content/ContentValues;)J

    move-result-wide v2

    .line 808
    const-string v0, "Gmail"

    const-string v4, "UiProvider.update(): added local message %d"

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    aput-object v6, v5, v1

    invoke-static {v0, v4, v5}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 810
    long-to-int v0, v2

    goto :goto_1

    .line 814
    :pswitch_3
    invoke-direct {p0, v3, p2}, Lcom/google/android/gm/provider/UiProvider;->saveDraft(Lcom/google/android/gm/provider/MailEngine;Landroid/content/ContentValues;)J

    move-result-wide v2

    .line 815
    const-string v0, "Gmail"

    const-string v4, "UiProvider.update(): added local message %d"

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    aput-object v6, v5, v1

    invoke-static {v0, v4, v5}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 817
    long-to-int v0, v2

    goto :goto_1

    .line 820
    :pswitch_4
    const-string v2, "Gmail"

    const-string v4, "update: running populateRecentLabels."

    new-array v5, v1, [Ljava/lang/Object;

    invoke-static {v2, v4, v5}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 821
    invoke-direct {p0, v3, v0}, Lcom/google/android/gm/provider/UiProvider;->populateRecentLabels(Lcom/google/android/gm/provider/MailEngine;Ljava/lang/String;)V

    goto :goto_0

    .line 825
    :pswitch_5
    invoke-direct {p0, v3, v0, p2}, Lcom/google/android/gm/provider/UiProvider;->updateLabelsLastTouched(Lcom/google/android/gm/provider/MailEngine;Ljava/lang/String;Landroid/content/ContentValues;)I

    move-result v0

    goto :goto_1

    .line 827
    :pswitch_6
    invoke-direct {p0, p1, p2}, Lcom/google/android/gm/provider/UiProvider;->updateAttachmentState(Landroid/net/Uri;Landroid/content/ContentValues;)I

    move-result v0

    goto :goto_1

    :pswitch_7
    move v0, v1

    .line 831
    goto :goto_1

    .line 833
    :pswitch_8
    invoke-direct {p0, v0, p1, p2}, Lcom/google/android/gm/provider/UiProvider;->updateMessageState(Ljava/lang/String;Landroid/net/Uri;Landroid/content/ContentValues;)I

    move-result v0

    goto :goto_1

    .line 835
    :pswitch_9
    invoke-direct {p0, v0, p2}, Lcom/google/android/gm/provider/UiProvider;->expungeMessage(Ljava/lang/String;Landroid/content/ContentValues;)I

    move-result v0

    goto :goto_1

    .line 794
    :pswitch_data_0
    .packed-switch 0x8
        :pswitch_2
        :pswitch_3
        :pswitch_8
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_5
        :pswitch_7
        :pswitch_6
        :pswitch_9
        :pswitch_4
    .end packed-switch
.end method
