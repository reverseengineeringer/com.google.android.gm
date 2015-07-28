.class public Lcom/android/mail/AccountSpinnerAdapter;
.super Landroid/widget/BaseAdapter;
.source "AccountSpinnerAdapter.java"


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field final mAccountObserver:Lcom/android/mail/providers/AccountObserver;

.field private final mActivityController:Lcom/android/mail/ui/ConversationListCallbacks;

.field private mAllAccounts:[Lcom/android/mail/providers/Account;

.field private final mContext:Landroid/content/Context;

.field private mCurrentAccount:Lcom/android/mail/providers/Account;

.field private mCurrentFolder:Lcom/android/mail/providers/Folder;

.field private final mFolderWatcher:Lcom/android/mail/providers/FolderWatcher;

.field private final mInflater:Landroid/view/LayoutInflater;

.field private mNumAccounts:I

.field private mRecentFolderController:Lcom/android/mail/ui/RecentFolderController;

.field private mRecentFolderList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/android/mail/providers/Folder;",
            ">;"
        }
    .end annotation
.end field

.field private mRecentFolderObserver:Lcom/android/mail/providers/RecentFolderObserver;

.field private mRecentFolders:Lcom/android/mail/ui/RecentFolderList;

.field private mRecentFoldersVisible:Z

.field private mShowAllFoldersItem:Z

.field private mSpinnerRecentFolderObserver:Lcom/android/mail/providers/RecentFolderObserver;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 105
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/AccountSpinnerAdapter;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/android/mail/ui/ControllableActivity;Landroid/content/Context;Z)V
    .locals 2
    .param p1, "activity"    # Lcom/android/mail/ui/ControllableActivity;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "showAllFolders"    # Z

    .prologue
    const/4 v1, 0x0

    .line 239
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 54
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mCurrentAccount:Lcom/android/mail/providers/Account;

    .line 58
    iput v1, p0, Lcom/android/mail/AccountSpinnerAdapter;->mNumAccounts:I

    .line 62
    new-array v0, v1, [Lcom/android/mail/providers/Account;

    iput-object v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mAllAccounts:[Lcom/android/mail/providers/Account;

    .line 70
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mRecentFolderList:Ljava/util/ArrayList;

    .line 99
    new-instance v0, Lcom/android/mail/AccountSpinnerAdapter$1;

    invoke-direct {v0, p0}, Lcom/android/mail/AccountSpinnerAdapter$1;-><init>(Lcom/android/mail/AccountSpinnerAdapter;)V

    iput-object v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mSpinnerRecentFolderObserver:Lcom/android/mail/providers/RecentFolderObserver;

    .line 107
    new-instance v0, Lcom/android/mail/AccountSpinnerAdapter$2;

    invoke-direct {v0, p0}, Lcom/android/mail/AccountSpinnerAdapter$2;-><init>(Lcom/android/mail/AccountSpinnerAdapter;)V

    iput-object v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mAccountObserver:Lcom/android/mail/providers/AccountObserver;

    .line 240
    iput-object p2, p0, Lcom/android/mail/AccountSpinnerAdapter;->mContext:Landroid/content/Context;

    .line 241
    invoke-static {p2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mInflater:Landroid/view/LayoutInflater;

    .line 242
    iput-boolean p3, p0, Lcom/android/mail/AccountSpinnerAdapter;->mShowAllFoldersItem:Z

    .line 246
    new-instance v0, Lcom/android/mail/providers/FolderWatcher;

    invoke-direct {v0, p1, p0}, Lcom/android/mail/providers/FolderWatcher;-><init>(Lcom/android/mail/ui/RestrictedActivity;Landroid/widget/BaseAdapter;)V

    iput-object v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mFolderWatcher:Lcom/android/mail/providers/FolderWatcher;

    .line 247
    iget-object v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mAccountObserver:Lcom/android/mail/providers/AccountObserver;

    invoke-interface {p1}, Lcom/android/mail/ui/ControllableActivity;->getAccountController()Lcom/android/mail/ui/AccountController;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/android/mail/providers/AccountObserver;->initialize(Lcom/android/mail/ui/AccountController;)Lcom/android/mail/providers/Account;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mCurrentAccount:Lcom/android/mail/providers/Account;

    .line 248
    invoke-interface {p1}, Lcom/android/mail/ui/ControllableActivity;->getListHandler()Lcom/android/mail/ui/ConversationListCallbacks;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mActivityController:Lcom/android/mail/ui/ConversationListCallbacks;

    .line 249
    invoke-interface {p1}, Lcom/android/mail/ui/ControllableActivity;->getRecentFolderController()Lcom/android/mail/ui/RecentFolderController;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mRecentFolderController:Lcom/android/mail/ui/RecentFolderController;

    .line 250
    return-void
.end method

.method static synthetic access$000(Lcom/android/mail/AccountSpinnerAdapter;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/AccountSpinnerAdapter;

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/android/mail/AccountSpinnerAdapter;->requestRecentFolders()V

    return-void
.end method

.method static synthetic access$100(Lcom/android/mail/AccountSpinnerAdapter;)Landroid/net/Uri;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/AccountSpinnerAdapter;

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/android/mail/AccountSpinnerAdapter;->getCurrentAccountUri()Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$202(Lcom/android/mail/AccountSpinnerAdapter;Lcom/android/mail/providers/Account;)Lcom/android/mail/providers/Account;
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/AccountSpinnerAdapter;
    .param p1, "x1"    # Lcom/android/mail/providers/Account;

    .prologue
    .line 48
    iput-object p1, p0, Lcom/android/mail/AccountSpinnerAdapter;->mCurrentAccount:Lcom/android/mail/providers/Account;

    return-object p1
.end method

.method static synthetic access$300(Lcom/android/mail/AccountSpinnerAdapter;)Z
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/AccountSpinnerAdapter;

    .prologue
    .line 48
    iget-boolean v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mRecentFoldersVisible:Z

    return v0
.end method

.method static synthetic access$400(Lcom/android/mail/AccountSpinnerAdapter;)[Lcom/android/mail/providers/Account;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/AccountSpinnerAdapter;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mAllAccounts:[Lcom/android/mail/providers/Account;

    return-object v0
.end method

.method static synthetic access$500()Ljava/lang/String;
    .locals 1

    .prologue
    .line 48
    sget-object v0, Lcom/android/mail/AccountSpinnerAdapter;->LOG_TAG:Ljava/lang/String;

    return-object v0
.end method

.method private static disableView(Landroid/view/View;)V
    .locals 1
    .param p0, "view"    # Landroid/view/View;

    .prologue
    .line 208
    if-eqz p0, :cond_0

    .line 209
    const/16 v0, 0x8

    invoke-virtual {p0, v0}, Landroid/view/View;->setVisibility(I)V

    .line 211
    :cond_0
    return-void
.end method

.method private static displayOrHide(Landroid/view/View;ILjava/lang/String;)V
    .locals 2
    .param p0, "v"    # Landroid/view/View;
    .param p1, "resourceId"    # I
    .param p2, "toDisplay"    # Ljava/lang/String;

    .prologue
    .line 443
    invoke-virtual {p0, p1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 444
    .local v0, "target":Landroid/widget/TextView;
    if-nez v0, :cond_0

    .line 452
    :goto_0
    return-void

    .line 447
    :cond_0
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 448
    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0

    .line 451
    :cond_1
    invoke-virtual {v0, p2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method

.method private static enableView(Landroid/view/View;)V
    .locals 1
    .param p0, "view"    # Landroid/view/View;

    .prologue
    .line 202
    if-eqz p0, :cond_0

    .line 203
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Landroid/view/View;->setVisibility(I)V

    .line 205
    :cond_0
    return-void
.end method

.method private getAccount(I)Lcom/android/mail/providers/Account;
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 470
    iget v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mNumAccounts:I

    add-int/lit8 v0, v0, 0x1

    if-lt p1, v0, :cond_0

    .line 471
    const/4 v0, 0x0

    .line 473
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mAllAccounts:[Lcom/android/mail/providers/Account;

    add-int/lit8 v1, p1, -0x1

    aget-object v0, v0, v1

    goto :goto_0
.end method

.method private getCurrentAccountName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 340
    invoke-direct {p0}, Lcom/android/mail/AccountSpinnerAdapter;->isCurrentAccountInvalid()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 341
    const-string v0, ""

    .line 343
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mCurrentAccount:Lcom/android/mail/providers/Account;

    iget-object v0, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    goto :goto_0
.end method

.method private getCurrentAccountUri()Landroid/net/Uri;
    .locals 1

    .prologue
    .line 347
    invoke-direct {p0}, Lcom/android/mail/AccountSpinnerAdapter;->isCurrentAccountInvalid()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 348
    sget-object v0, Landroid/net/Uri;->EMPTY:Landroid/net/Uri;

    .line 350
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mCurrentAccount:Lcom/android/mail/providers/Account;

    iget-object v0, v0, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    goto :goto_0
.end method

.method private final getRecentOffset(I)I
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 220
    iget v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mNumAccounts:I

    sub-int v0, p1, v0

    add-int/lit8 v0, v0, -0x2

    return v0
.end method

.method private isCurrentAccountInvalid()Z
    .locals 1

    .prologue
    .line 336
    iget-object v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mCurrentAccount:Lcom/android/mail/providers/Account;

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private final populateUnreadCountView(Landroid/widget/TextView;I)V
    .locals 1
    .param p1, "unreadCountView"    # Landroid/widget/TextView;
    .param p2, "unreadCount"    # I

    .prologue
    .line 461
    iget-object v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mContext:Landroid/content/Context;

    invoke-static {v0, p2}, Lcom/android/mail/utils/Utils;->getUnreadCountString(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 462
    return-void
.end method

.method private requestRecentFolders()V
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 503
    iget-object v2, p0, Lcom/android/mail/AccountSpinnerAdapter;->mCurrentFolder:Lcom/android/mail/providers/Folder;

    if-nez v2, :cond_0

    move-object v0, v1

    .line 504
    .local v0, "uri":Landroid/net/Uri;
    :goto_0
    iget-boolean v2, p0, Lcom/android/mail/AccountSpinnerAdapter;->mRecentFoldersVisible:Z

    if-eqz v2, :cond_1

    .line 505
    iget-object v1, p0, Lcom/android/mail/AccountSpinnerAdapter;->mRecentFolders:Lcom/android/mail/ui/RecentFolderList;

    invoke-virtual {v1, v0}, Lcom/android/mail/ui/RecentFolderList;->getRecentFolderList(Landroid/net/Uri;)Ljava/util/ArrayList;

    move-result-object v1

    iput-object v1, p0, Lcom/android/mail/AccountSpinnerAdapter;->mRecentFolderList:Ljava/util/ArrayList;

    .line 506
    invoke-virtual {p0}, Lcom/android/mail/AccountSpinnerAdapter;->notifyDataSetChanged()V

    .line 510
    :goto_1
    return-void

    .line 503
    .end local v0    # "uri":Landroid/net/Uri;
    :cond_0
    iget-object v2, p0, Lcom/android/mail/AccountSpinnerAdapter;->mCurrentFolder:Lcom/android/mail/providers/Folder;

    iget-object v0, v2, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    goto :goto_0

    .line 508
    .restart local v0    # "uri":Landroid/net/Uri;
    :cond_1
    iput-object v1, p0, Lcom/android/mail/AccountSpinnerAdapter;->mRecentFolderList:Ljava/util/ArrayList;

    goto :goto_1
.end method

.method private static final selectRelevant(Landroid/view/View;I)V
    .locals 6
    .param p0, "view"    # Landroid/view/View;
    .param p1, "type"    # I

    .prologue
    .line 165
    if-nez p0, :cond_0

    .line 199
    :goto_0
    :pswitch_0
    return-void

    .line 168
    :cond_0
    const v5, 0x7f10001b

    invoke-virtual {p0, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 169
    .local v1, "anchor":Landroid/view/View;
    const v5, 0x7f10001d

    invoke-virtual {p0, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 170
    .local v0, "account":Landroid/view/View;
    const v5, 0x7f10001e

    invoke-virtual {p0, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    .line 171
    .local v4, "header":Landroid/view/View;
    const/high16 v5, 0x7f100000

    invoke-virtual {p0, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    .line 172
    .local v2, "folder":Landroid/view/View;
    const v5, 0x7f10001f

    invoke-virtual {p0, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    .line 174
    .local v3, "footer":Landroid/view/View;
    invoke-static {v1}, Lcom/android/mail/AccountSpinnerAdapter;->disableView(Landroid/view/View;)V

    .line 175
    invoke-static {v0}, Lcom/android/mail/AccountSpinnerAdapter;->disableView(Landroid/view/View;)V

    .line 176
    invoke-static {v4}, Lcom/android/mail/AccountSpinnerAdapter;->disableView(Landroid/view/View;)V

    .line 177
    invoke-static {v2}, Lcom/android/mail/AccountSpinnerAdapter;->disableView(Landroid/view/View;)V

    .line 178
    invoke-static {v3}, Lcom/android/mail/AccountSpinnerAdapter;->disableView(Landroid/view/View;)V

    .line 179
    packed-switch p1, :pswitch_data_0

    goto :goto_0

    .line 181
    :pswitch_1
    invoke-static {v1}, Lcom/android/mail/AccountSpinnerAdapter;->enableView(Landroid/view/View;)V

    goto :goto_0

    .line 187
    :pswitch_2
    invoke-static {v0}, Lcom/android/mail/AccountSpinnerAdapter;->enableView(Landroid/view/View;)V

    goto :goto_0

    .line 190
    :pswitch_3
    invoke-static {v4}, Lcom/android/mail/AccountSpinnerAdapter;->enableView(Landroid/view/View;)V

    goto :goto_0

    .line 193
    :pswitch_4
    invoke-static {v2}, Lcom/android/mail/AccountSpinnerAdapter;->enableView(Landroid/view/View;)V

    goto :goto_0

    .line 196
    :pswitch_5
    invoke-static {v3}, Lcom/android/mail/AccountSpinnerAdapter;->enableView(Landroid/view/View;)V

    goto :goto_0

    .line 179
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
    .end packed-switch
.end method


# virtual methods
.method public areAllItemsEnabled()Z
    .locals 1

    .prologue
    .line 487
    const/4 v0, 0x0

    return v0
.end method

.method public destroy()V
    .locals 1

    .prologue
    .line 551
    iget-object v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mAccountObserver:Lcom/android/mail/providers/AccountObserver;

    invoke-virtual {v0}, Lcom/android/mail/providers/AccountObserver;->unregisterAndDestroy()V

    .line 552
    iget-object v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mRecentFolderObserver:Lcom/android/mail/providers/RecentFolderObserver;

    if-eqz v0, :cond_0

    .line 553
    iget-object v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mRecentFolderObserver:Lcom/android/mail/providers/RecentFolderObserver;

    invoke-virtual {v0}, Lcom/android/mail/providers/RecentFolderObserver;->unregisterAndDestroy()V

    .line 554
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mRecentFolderObserver:Lcom/android/mail/providers/RecentFolderObserver;

    .line 556
    :cond_0
    return-void
.end method

.method public disableRecentFolders()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 516
    iget-boolean v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mRecentFoldersVisible:Z

    if-eqz v0, :cond_1

    .line 517
    iget-object v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mRecentFolderObserver:Lcom/android/mail/providers/RecentFolderObserver;

    if-eqz v0, :cond_0

    .line 518
    iget-object v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mRecentFolderObserver:Lcom/android/mail/providers/RecentFolderObserver;

    invoke-virtual {v0}, Lcom/android/mail/providers/RecentFolderObserver;->unregisterAndDestroy()V

    .line 519
    iput-object v1, p0, Lcom/android/mail/AccountSpinnerAdapter;->mRecentFolderObserver:Lcom/android/mail/providers/RecentFolderObserver;

    .line 521
    :cond_0
    iput-object v1, p0, Lcom/android/mail/AccountSpinnerAdapter;->mRecentFolders:Lcom/android/mail/ui/RecentFolderList;

    .line 522
    invoke-virtual {p0}, Lcom/android/mail/AccountSpinnerAdapter;->notifyDataSetChanged()V

    .line 523
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mRecentFoldersVisible:Z

    .line 525
    :cond_1
    return-void
.end method

.method public enableRecentFolders()V
    .locals 2

    .prologue
    .line 531
    iget-boolean v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mRecentFoldersVisible:Z

    if-nez v0, :cond_1

    .line 532
    iget-object v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mSpinnerRecentFolderObserver:Lcom/android/mail/providers/RecentFolderObserver;

    iput-object v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mRecentFolderObserver:Lcom/android/mail/providers/RecentFolderObserver;

    .line 533
    iget-object v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mRecentFolderObserver:Lcom/android/mail/providers/RecentFolderObserver;

    iget-object v1, p0, Lcom/android/mail/AccountSpinnerAdapter;->mRecentFolderController:Lcom/android/mail/ui/RecentFolderController;

    invoke-virtual {v0, v1}, Lcom/android/mail/providers/RecentFolderObserver;->initialize(Lcom/android/mail/ui/RecentFolderController;)Lcom/android/mail/ui/RecentFolderList;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mRecentFolders:Lcom/android/mail/ui/RecentFolderList;

    .line 534
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mRecentFoldersVisible:Z

    .line 538
    iget-object v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mRecentFolderList:Ljava/util/ArrayList;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mRecentFolderList:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-gtz v0, :cond_2

    .line 540
    :cond_0
    invoke-direct {p0}, Lcom/android/mail/AccountSpinnerAdapter;->requestRecentFolders()V

    .line 545
    :cond_1
    :goto_0
    return-void

    .line 542
    :cond_2
    invoke-virtual {p0}, Lcom/android/mail/AccountSpinnerAdapter;->notifyDataSetChanged()V

    goto :goto_0
.end method

.method public getCount()I
    .locals 5

    .prologue
    const/4 v2, 0x0

    .line 291
    iget-object v3, p0, Lcom/android/mail/AccountSpinnerAdapter;->mRecentFolderList:Ljava/util/ArrayList;

    if-nez v3, :cond_1

    move v1, v2

    .line 292
    .local v1, "numRecents":I
    :goto_0
    iget-boolean v3, p0, Lcom/android/mail/AccountSpinnerAdapter;->mRecentFoldersVisible:Z

    if-eqz v3, :cond_2

    if-lez v1, :cond_2

    add-int/lit8 v3, v1, 0x1

    iget-boolean v4, p0, Lcom/android/mail/AccountSpinnerAdapter;->mShowAllFoldersItem:Z

    if-eqz v4, :cond_0

    const/4 v2, 0x1

    :cond_0
    add-int v0, v3, v2

    .line 294
    .local v0, "numFolders":I
    :goto_1
    iget v2, p0, Lcom/android/mail/AccountSpinnerAdapter;->mNumAccounts:I

    add-int/lit8 v2, v2, 0x1

    add-int/2addr v2, v0

    return v2

    .line 291
    .end local v0    # "numFolders":I
    .end local v1    # "numRecents":I
    :cond_1
    iget-object v3, p0, Lcom/android/mail/AccountSpinnerAdapter;->mRecentFolderList:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v1

    goto :goto_0

    .restart local v1    # "numRecents":I
    :cond_2
    move v0, v2

    .line 292
    goto :goto_1
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 299
    invoke-virtual {p0, p1}, Lcom/android/mail/AccountSpinnerAdapter;->getType(I)I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 310
    :pswitch_0
    iget-object v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mRecentFolderList:Ljava/util/ArrayList;

    invoke-direct {p0, p1}, Lcom/android/mail/AccountSpinnerAdapter;->getRecentOffset(I)I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    :goto_0
    return-object v0

    .line 301
    :pswitch_1
    const-string v0, "dead header"

    goto :goto_0

    .line 303
    :pswitch_2
    invoke-direct {p0, p1}, Lcom/android/mail/AccountSpinnerAdapter;->getAccount(I)Lcom/android/mail/providers/Account;

    move-result-object v0

    goto :goto_0

    .line 305
    :pswitch_3
    const-string v0, "account spinner header"

    goto :goto_0

    .line 307
    :pswitch_4
    const-string v0, "show all folders"

    goto :goto_0

    .line 299
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_0
        :pswitch_4
    .end packed-switch
.end method

.method public getItemId(I)J
    .locals 3
    .param p1, "position"    # I

    .prologue
    .line 316
    invoke-virtual {p0, p1}, Lcom/android/mail/AccountSpinnerAdapter;->getType(I)I

    move-result v0

    .line 317
    .local v0, "type":I
    packed-switch v0, :pswitch_data_0

    .line 327
    :pswitch_0
    iget-object v1, p0, Lcom/android/mail/AccountSpinnerAdapter;->mRecentFolderList:Ljava/util/ArrayList;

    invoke-direct {p0, p1}, Lcom/android/mail/AccountSpinnerAdapter;->getRecentOffset(I)I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/mail/providers/Folder;

    iget-object v1, v1, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    invoke-virtual {v1}, Landroid/net/Uri;->hashCode()I

    move-result v1

    int-to-long v1, v1

    :goto_0
    return-wide v1

    .line 323
    :pswitch_1
    int-to-long v1, v0

    goto :goto_0

    .line 325
    :pswitch_2
    invoke-direct {p0, p1}, Lcom/android/mail/AccountSpinnerAdapter;->getAccount(I)Lcom/android/mail/providers/Account;

    move-result-object v1

    iget-object v1, v1, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    invoke-virtual {v1}, Landroid/net/Uri;->hashCode()I

    move-result v1

    int-to-long v1, v1

    goto :goto_0

    .line 317
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_2
        :pswitch_1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public getType(I)I
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 141
    if-nez p1, :cond_0

    .line 142
    const/4 v0, 0x1

    .line 156
    :goto_0
    return v0

    .line 145
    :cond_0
    iget v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mNumAccounts:I

    if-gt p1, v0, :cond_1

    .line 146
    const/4 v0, 0x2

    goto :goto_0

    .line 149
    :cond_1
    iget v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mNumAccounts:I

    add-int/lit8 v0, v0, 0x1

    if-ne p1, v0, :cond_2

    .line 150
    const/4 v0, 0x3

    goto :goto_0

    .line 152
    :cond_2
    iget-boolean v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mShowAllFoldersItem:Z

    if-eqz v0, :cond_3

    invoke-direct {p0, p1}, Lcom/android/mail/AccountSpinnerAdapter;->getRecentOffset(I)I

    move-result v0

    iget-object v1, p0, Lcom/android/mail/AccountSpinnerAdapter;->mRecentFolderList:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-lt v0, v1, :cond_3

    .line 153
    const/4 v0, 0x5

    goto :goto_0

    .line 156
    :cond_3
    const/4 v0, 0x4

    goto :goto_0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 12
    .param p1, "position"    # I
    .param p2, "view"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 367
    if-nez p1, :cond_0

    .line 369
    iget-object v9, p0, Lcom/android/mail/AccountSpinnerAdapter;->mActivityController:Lcom/android/mail/ui/ConversationListCallbacks;

    const/4 v10, 0x0

    invoke-interface {v9, v10}, Lcom/android/mail/ui/ConversationListCallbacks;->commitDestructiveActions(Z)V

    .line 372
    :cond_0
    const-string v1, ""

    .line 374
    .local v1, "bigText":Ljava/lang/String;
    const-string v6, ""

    .line 375
    .local v6, "smallText":Ljava/lang/String;
    const/4 v8, 0x0

    .line 379
    .local v8, "unreadCount":I
    invoke-virtual {p0, p1}, Lcom/android/mail/AccountSpinnerAdapter;->getType(I)I

    move-result v7

    .line 380
    .local v7, "type":I
    iget-object v10, p0, Lcom/android/mail/AccountSpinnerAdapter;->mInflater:Landroid/view/LayoutInflater;

    iget-boolean v9, p0, Lcom/android/mail/AccountSpinnerAdapter;->mRecentFoldersVisible:Z

    if-eqz v9, :cond_1

    const v9, 0x7f040005

    :goto_0
    const/4 v11, 0x0

    invoke-virtual {v10, v9, v11}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 383
    invoke-static {p2, v7}, Lcom/android/mail/AccountSpinnerAdapter;->selectRelevant(Landroid/view/View;I)V

    .line 384
    packed-switch v7, :pswitch_data_0

    .line 432
    :goto_1
    :pswitch_0
    return-object p2

    .line 380
    :cond_1
    const v9, 0x7f040007

    goto :goto_0

    .line 388
    :pswitch_1
    invoke-direct {p0, p1}, Lcom/android/mail/AccountSpinnerAdapter;->getAccount(I)Lcom/android/mail/providers/Account;

    move-result-object v0

    .line 389
    .local v0, "account":Lcom/android/mail/providers/Account;
    const v9, 0x7f100012

    invoke-virtual {p2, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    .line 390
    .local v3, "colorView":Landroid/view/View;
    if-nez v0, :cond_2

    .line 391
    const-string v1, ""

    .line 392
    const-string v6, ""

    .line 393
    const/4 v8, 0x0

    .line 394
    const/4 v9, 0x4

    invoke-virtual {v3, v9}, Landroid/view/View;->setVisibility(I)V

    .line 408
    :goto_2
    const v9, 0x7f100014

    invoke-static {p2, v9, v1}, Lcom/android/mail/AccountSpinnerAdapter;->displayOrHide(Landroid/view/View;ILjava/lang/String;)V

    .line 409
    const v9, 0x7f100015

    invoke-static {p2, v9, v6}, Lcom/android/mail/AccountSpinnerAdapter;->displayOrHide(Landroid/view/View;ILjava/lang/String;)V

    .line 410
    const v9, 0x7f100013

    invoke-virtual {p2, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/TextView;

    invoke-direct {p0, v9, v8}, Lcom/android/mail/AccountSpinnerAdapter;->populateUnreadCountView(Landroid/widget/TextView;I)V

    goto :goto_1

    .line 396
    :cond_2
    iget-object v9, v0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    iget-object v1, v9, Lcom/android/mail/providers/Settings;->defaultInboxName:Ljava/lang/String;

    .line 397
    iget-object v6, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    .line 398
    iget v2, v0, Lcom/android/mail/providers/Account;->color:I

    .line 399
    .local v2, "color":I
    if-eqz v2, :cond_3

    .line 400
    const/4 v9, 0x0

    invoke-virtual {v3, v9}, Landroid/view/View;->setVisibility(I)V

    .line 401
    invoke-virtual {v3, v2}, Landroid/view/View;->setBackgroundColor(I)V

    .line 405
    :goto_3
    iget-object v9, p0, Lcom/android/mail/AccountSpinnerAdapter;->mFolderWatcher:Lcom/android/mail/providers/FolderWatcher;

    iget-object v10, v0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    iget-object v10, v10, Lcom/android/mail/providers/Settings;->defaultInbox:Landroid/net/Uri;

    invoke-virtual {v9, v10}, Lcom/android/mail/providers/FolderWatcher;->get(Landroid/net/Uri;)Lcom/android/mail/providers/Folder;

    move-result-object v5

    .line 406
    .local v5, "inbox":Lcom/android/mail/providers/Folder;
    if-eqz v5, :cond_4

    iget v8, v5, Lcom/android/mail/providers/Folder;->unreadCount:I

    :goto_4
    goto :goto_2

    .line 403
    .end local v5    # "inbox":Lcom/android/mail/providers/Folder;
    :cond_3
    const/4 v9, 0x4

    invoke-virtual {v3, v9}, Landroid/view/View;->setVisibility(I)V

    goto :goto_3

    .line 406
    .restart local v5    # "inbox":Lcom/android/mail/providers/Folder;
    :cond_4
    const/4 v8, 0x0

    goto :goto_4

    .line 414
    .end local v0    # "account":Lcom/android/mail/providers/Account;
    .end local v2    # "color":I
    .end local v3    # "colorView":Landroid/view/View;
    .end local v5    # "inbox":Lcom/android/mail/providers/Folder;
    :pswitch_2
    const v9, 0x7f10001a

    invoke-virtual {p2, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/TextView;

    invoke-direct {p0}, Lcom/android/mail/AccountSpinnerAdapter;->getCurrentAccountName()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_1

    .line 418
    :pswitch_3
    iget-object v9, p0, Lcom/android/mail/AccountSpinnerAdapter;->mRecentFolderList:Ljava/util/ArrayList;

    invoke-direct {p0, p1}, Lcom/android/mail/AccountSpinnerAdapter;->getRecentOffset(I)I

    move-result v10

    invoke-virtual {v9, v10}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/android/mail/providers/Folder;

    .line 419
    .local v4, "folder":Lcom/android/mail/providers/Folder;
    const v9, 0x7f100016

    invoke-virtual {p2, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    .line 420
    .restart local v3    # "colorView":Landroid/view/View;
    iget-object v1, v4, Lcom/android/mail/providers/Folder;->name:Ljava/lang/String;

    .line 421
    iget v8, v4, Lcom/android/mail/providers/Folder;->unreadCount:I

    .line 422
    invoke-static {v4, v3}, Lcom/android/mail/providers/Folder;->setFolderBlockColor(Lcom/android/mail/providers/Folder;Landroid/view/View;)V

    .line 423
    const/4 v9, 0x0

    invoke-virtual {v3, v9}, Landroid/view/View;->setVisibility(I)V

    .line 424
    const v9, 0x7f100018

    invoke-static {p2, v9, v1}, Lcom/android/mail/AccountSpinnerAdapter;->displayOrHide(Landroid/view/View;ILjava/lang/String;)V

    .line 425
    const v9, 0x7f100019

    invoke-static {p2, v9, v6}, Lcom/android/mail/AccountSpinnerAdapter;->displayOrHide(Landroid/view/View;ILjava/lang/String;)V

    .line 426
    const v9, 0x7f100017

    invoke-virtual {p2, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/TextView;

    invoke-direct {p0, v9, v8}, Lcom/android/mail/AccountSpinnerAdapter;->populateUnreadCountView(Landroid/widget/TextView;I)V

    goto/16 :goto_1

    .line 384
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_0
    .end packed-switch
.end method

.method public hasStableIds()Z
    .locals 1

    .prologue
    .line 356
    const/4 v0, 0x1

    return v0
.end method

.method public isEmpty()Z
    .locals 1

    .prologue
    .line 362
    const/4 v0, 0x0

    return v0
.end method

.method public isEnabled(I)Z
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 480
    invoke-virtual {p0, p1}, Lcom/android/mail/AccountSpinnerAdapter;->getType(I)I

    move-result v0

    .line 481
    .local v0, "type":I
    const/4 v1, 0x3

    if-eq v0, v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public onFolderUpdated(Lcom/android/mail/providers/Folder;)V
    .locals 0
    .param p1, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 494
    iput-object p1, p0, Lcom/android/mail/AccountSpinnerAdapter;->mCurrentFolder:Lcom/android/mail/providers/Folder;

    .line 495
    invoke-virtual {p0}, Lcom/android/mail/AccountSpinnerAdapter;->notifyDataSetChanged()V

    .line 496
    return-void
.end method

.method public setAccountArray([Lcom/android/mail/providers/Account;)V
    .locals 9
    .param p1, "accounts"    # [Lcom/android/mail/providers/Account;

    .prologue
    .line 257
    invoke-direct {p0}, Lcom/android/mail/AccountSpinnerAdapter;->getCurrentAccountUri()Landroid/net/Uri;

    move-result-object v0

    .line 258
    .local v0, "currentAccount":Landroid/net/Uri;
    iput-object p1, p0, Lcom/android/mail/AccountSpinnerAdapter;->mAllAccounts:[Lcom/android/mail/providers/Account;

    .line 259
    array-length v4, p1

    iput v4, p0, Lcom/android/mail/AccountSpinnerAdapter;->mNumAccounts:I

    .line 260
    invoke-direct {p0}, Lcom/android/mail/AccountSpinnerAdapter;->isCurrentAccountInvalid()Z

    move-result v4

    if-nez v4, :cond_0

    .line 261
    invoke-static {p1, v0}, Lcom/android/mail/providers/Account;->findPosition([Lcom/android/mail/providers/Account;Landroid/net/Uri;)I

    move-result v2

    .line 262
    .local v2, "pos":I
    sget-object v4, Lcom/android/mail/AccountSpinnerAdapter;->LOG_TAG:Ljava/lang/String;

    const-string v5, "setAccountArray: mCurrentAccountPos = %d"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-static {v4, v5, v6}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 265
    .end local v2    # "pos":I
    :cond_0
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget v4, p0, Lcom/android/mail/AccountSpinnerAdapter;->mNumAccounts:I

    if-ge v1, v4, :cond_1

    .line 266
    iget-object v4, p0, Lcom/android/mail/AccountSpinnerAdapter;->mAllAccounts:[Lcom/android/mail/providers/Account;

    aget-object v4, v4, v1

    iget-object v4, v4, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    iget-object v3, v4, Lcom/android/mail/providers/Settings;->defaultInbox:Landroid/net/Uri;

    .line 267
    .local v3, "uri":Landroid/net/Uri;
    iget-object v4, p0, Lcom/android/mail/AccountSpinnerAdapter;->mFolderWatcher:Lcom/android/mail/providers/FolderWatcher;

    invoke-virtual {v4, v3}, Lcom/android/mail/providers/FolderWatcher;->startWatching(Landroid/net/Uri;)V

    .line 265
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 269
    .end local v3    # "uri":Landroid/net/Uri;
    :cond_1
    invoke-virtual {p0}, Lcom/android/mail/AccountSpinnerAdapter;->notifyDataSetChanged()V

    .line 270
    return-void
.end method

.method public setCurrentFolder(Lcom/android/mail/providers/Folder;)Z
    .locals 1
    .param p1, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 278
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/android/mail/AccountSpinnerAdapter;->mCurrentFolder:Lcom/android/mail/providers/Folder;

    if-eq p1, v0, :cond_0

    .line 279
    iput-object p1, p0, Lcom/android/mail/AccountSpinnerAdapter;->mCurrentFolder:Lcom/android/mail/providers/Folder;

    .line 281
    invoke-direct {p0}, Lcom/android/mail/AccountSpinnerAdapter;->requestRecentFolders()V

    .line 282
    const/4 v0, 0x1

    .line 284
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
