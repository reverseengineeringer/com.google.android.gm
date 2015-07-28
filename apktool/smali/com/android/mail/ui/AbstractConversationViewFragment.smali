.class public abstract Lcom/android/mail/ui/AbstractConversationViewFragment;
.super Landroid/app/Fragment;
.source "AbstractConversationViewFragment.java"

# interfaces
.implements Lcom/android/mail/browse/ConversationViewAdapter$ConversationAccountController;
.implements Lcom/android/mail/browse/ConversationViewHeader$ConversationViewHeaderCallbacks;
.implements Lcom/android/mail/browse/MessageCursor$ConversationController;
.implements Lcom/android/mail/browse/MessageHeaderView$MessageHeaderViewCallbacks;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/ui/AbstractConversationViewFragment$FragmentRunnable;,
        Lcom/android/mail/ui/AbstractConversationViewFragment$MarkReadObserver;,
        Lcom/android/mail/ui/AbstractConversationViewFragment$AbstractConversationWebViewClient;,
        Lcom/android/mail/ui/AbstractConversationViewFragment$ContactLoaderCallbacks;,
        Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoader;,
        Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoaderCallbacks;
    }
.end annotation


# static fields
.field private static final BUNDLE_USER_VISIBLE:Ljava/lang/String;

.field private static final BUNDLE_VIEW_STATE:Ljava/lang/String;

.field private static final LOG_TAG:Ljava/lang/String;

.field private static sMinDelay:I

.field private static sMinShowTime:I


# instance fields
.field protected mAccount:Lcom/android/mail/providers/Account;

.field private final mAccountObserver:Lcom/android/mail/providers/AccountObserver;

.field protected mActivity:Lcom/android/mail/ui/ControllableActivity;

.field protected final mAddressCache:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/android/mail/providers/Address;",
            ">;"
        }
    .end annotation
.end field

.field private mBackgroundView:Landroid/view/View;

.field protected mBaseUri:Ljava/lang/String;

.field private mChangeFoldersMenuItem:Landroid/view/MenuItem;

.field private final mContactLoaderCallbacks:Lcom/android/mail/ui/AbstractConversationViewFragment$ContactLoaderCallbacks;

.field private mContext:Landroid/content/Context;

.field protected mConversation:Lcom/android/mail/providers/Conversation;

.field private mCursor:Lcom/android/mail/browse/MessageCursor;

.field protected mDateBuilder:Lcom/android/mail/FormattedDateBuilder;

.field private final mDelayedShow:Ljava/lang/Runnable;

.field protected mEnableContentReadySignal:Z

.field protected mFolder:Lcom/android/mail/providers/Folder;

.field private final mHandler:Landroid/os/Handler;

.field private mLoadingShownTime:J

.field private mMarkReadObserver:Lcom/android/mail/ui/AbstractConversationViewFragment$MarkReadObserver;

.field private final mMessageLoaderCallbacks:Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoaderCallbacks;

.field private mProgressView:Landroid/view/View;

.field private mUserVisible:Z

.field protected mViewState:Lcom/android/mail/ui/ConversationViewState;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, -0x1

    .line 84
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/ui/AbstractConversationViewFragment;->LOG_TAG:Ljava/lang/String;

    .line 87
    sput v1, Lcom/android/mail/ui/AbstractConversationViewFragment;->sMinDelay:I

    .line 88
    sput v1, Lcom/android/mail/ui/AbstractConversationViewFragment;->sMinShowTime:I

    .line 143
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-class v1, Lcom/android/mail/ui/AbstractConversationViewFragment;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "viewstate"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/ui/AbstractConversationViewFragment;->BUNDLE_VIEW_STATE:Ljava/lang/String;

    .line 149
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-class v1, Lcom/android/mail/ui/AbstractConversationViewFragment;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "uservisible"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/ui/AbstractConversationViewFragment;->BUNDLE_USER_VISIBLE:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    .line 164
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    .line 90
    new-instance v0, Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoaderCallbacks;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoaderCallbacks;-><init>(Lcom/android/mail/ui/AbstractConversationViewFragment;Lcom/android/mail/ui/AbstractConversationViewFragment$1;)V

    iput-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mMessageLoaderCallbacks:Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoaderCallbacks;

    .line 92
    new-instance v0, Lcom/android/mail/ui/AbstractConversationViewFragment$ContactLoaderCallbacks;

    invoke-direct {v0, p0}, Lcom/android/mail/ui/AbstractConversationViewFragment$ContactLoaderCallbacks;-><init>(Lcom/android/mail/ui/AbstractConversationViewFragment;)V

    iput-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mContactLoaderCallbacks:Lcom/android/mail/ui/AbstractConversationViewFragment$ContactLoaderCallbacks;

    .line 98
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mAddressCache:Ljava/util/Map;

    .line 109
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mHandler:Landroid/os/Handler;

    .line 124
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mLoadingShownTime:J

    .line 126
    new-instance v0, Lcom/android/mail/ui/AbstractConversationViewFragment$1;

    const-string v1, "mDelayedShow"

    invoke-direct {v0, p0, v1}, Lcom/android/mail/ui/AbstractConversationViewFragment$1;-><init>(Lcom/android/mail/ui/AbstractConversationViewFragment;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mDelayedShow:Ljava/lang/Runnable;

    .line 134
    new-instance v0, Lcom/android/mail/ui/AbstractConversationViewFragment$2;

    invoke-direct {v0, p0}, Lcom/android/mail/ui/AbstractConversationViewFragment$2;-><init>(Lcom/android/mail/ui/AbstractConversationViewFragment;)V

    iput-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mAccountObserver:Lcom/android/mail/providers/AccountObserver;

    .line 165
    return-void
.end method

.method static synthetic access$1002(Lcom/android/mail/ui/AbstractConversationViewFragment;Lcom/android/mail/ui/AbstractConversationViewFragment$MarkReadObserver;)Lcom/android/mail/ui/AbstractConversationViewFragment$MarkReadObserver;
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/ui/AbstractConversationViewFragment;
    .param p1, "x1"    # Lcom/android/mail/ui/AbstractConversationViewFragment$MarkReadObserver;

    .prologue
    .line 77
    iput-object p1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mMarkReadObserver:Lcom/android/mail/ui/AbstractConversationViewFragment$MarkReadObserver;

    return-object p1
.end method

.method static synthetic access$102(Lcom/android/mail/ui/AbstractConversationViewFragment;J)J
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/ui/AbstractConversationViewFragment;
    .param p1, "x1"    # J

    .prologue
    .line 77
    iput-wide p1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mLoadingShownTime:J

    return-wide p1
.end method

.method static synthetic access$200(Lcom/android/mail/ui/AbstractConversationViewFragment;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/AbstractConversationViewFragment;

    .prologue
    .line 77
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mProgressView:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$300(Lcom/android/mail/ui/AbstractConversationViewFragment;Ljava/lang/Runnable;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/ui/AbstractConversationViewFragment;
    .param p1, "x1"    # Ljava/lang/Runnable;

    .prologue
    .line 77
    invoke-direct {p0, p1}, Lcom/android/mail/ui/AbstractConversationViewFragment;->dismiss(Ljava/lang/Runnable;)V

    return-void
.end method

.method static synthetic access$400(Lcom/android/mail/ui/AbstractConversationViewFragment;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/AbstractConversationViewFragment;

    .prologue
    .line 77
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mBackgroundView:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$500(Lcom/android/mail/ui/AbstractConversationViewFragment;)Lcom/android/mail/browse/MessageCursor;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/AbstractConversationViewFragment;

    .prologue
    .line 77
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mCursor:Lcom/android/mail/browse/MessageCursor;

    return-object v0
.end method

.method static synthetic access$502(Lcom/android/mail/ui/AbstractConversationViewFragment;Lcom/android/mail/browse/MessageCursor;)Lcom/android/mail/browse/MessageCursor;
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/ui/AbstractConversationViewFragment;
    .param p1, "x1"    # Lcom/android/mail/browse/MessageCursor;

    .prologue
    .line 77
    iput-object p1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mCursor:Lcom/android/mail/browse/MessageCursor;

    return-object p1
.end method

.method static synthetic access$600()Ljava/lang/String;
    .locals 1

    .prologue
    .line 77
    sget-object v0, Lcom/android/mail/ui/AbstractConversationViewFragment;->LOG_TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$700(Lcom/android/mail/ui/AbstractConversationViewFragment;)Z
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/AbstractConversationViewFragment;

    .prologue
    .line 77
    iget-boolean v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mUserVisible:Z

    return v0
.end method

.method static synthetic access$800(Lcom/android/mail/ui/AbstractConversationViewFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/ui/AbstractConversationViewFragment;

    .prologue
    .line 77
    invoke-direct {p0}, Lcom/android/mail/ui/AbstractConversationViewFragment;->onError()V

    return-void
.end method

.method private animateDismiss(Ljava/lang/Runnable;)V
    .locals 3
    .param p1, "doAfter"    # Ljava/lang/Runnable;

    .prologue
    .line 282
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractConversationViewFragment;->isAdded()Z

    move-result v1

    if-nez v1, :cond_0

    .line 283
    iget-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mBackgroundView:Landroid/view/View;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 301
    :goto_0
    return-void

    .line 287
    :cond_0
    iget-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mBackgroundView:Landroid/view/View;

    invoke-static {v1}, Lcom/android/mail/utils/Utils;->enableHardwareLayer(Landroid/view/View;)V

    .line 288
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractConversationViewFragment;->getContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f050005

    invoke-static {v1, v2}, Landroid/animation/AnimatorInflater;->loadAnimator(Landroid/content/Context;I)Landroid/animation/Animator;

    move-result-object v0

    .line 289
    .local v0, "animator":Landroid/animation/Animator;
    iget-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mBackgroundView:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/animation/Animator;->setTarget(Ljava/lang/Object;)V

    .line 290
    new-instance v1, Lcom/android/mail/ui/AbstractConversationViewFragment$4;

    invoke-direct {v1, p0, p1}, Lcom/android/mail/ui/AbstractConversationViewFragment$4;-><init>(Lcom/android/mail/ui/AbstractConversationViewFragment;Ljava/lang/Runnable;)V

    invoke-virtual {v0, v1}, Landroid/animation/Animator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    .line 300
    invoke-virtual {v0}, Landroid/animation/Animator;->start()V

    goto :goto_0
.end method

.method private dismiss(Ljava/lang/Runnable;)V
    .locals 2
    .param p1, "doAfter"    # Ljava/lang/Runnable;

    .prologue
    .line 267
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mLoadingShownTime:J

    .line 268
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mProgressView:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 269
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mBackgroundView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v0

    if-nez v0, :cond_1

    .line 270
    invoke-direct {p0, p1}, Lcom/android/mail/ui/AbstractConversationViewFragment;->animateDismiss(Ljava/lang/Runnable;)V

    .line 276
    :cond_0
    :goto_0
    return-void

    .line 272
    :cond_1
    if-eqz p1, :cond_0

    .line 273
    invoke-interface {p1}, Ljava/lang/Runnable;->run()V

    goto :goto_0
.end method

.method public static makeBasicArgs(Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;)Landroid/os/Bundle;
    .locals 2
    .param p0, "account"    # Lcom/android/mail/providers/Account;
    .param p1, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 153
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 154
    .local v0, "args":Landroid/os/Bundle;
    const-string v1, "account"

    invoke-virtual {v0, v1, p0}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 155
    const-string v1, "folder"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 156
    return-object v0
.end method

.method private onError()V
    .locals 3

    .prologue
    .line 525
    sget-object v0, Lcom/android/mail/ui/AbstractConversationViewFragment;->LOG_TAG:Ljava/lang/String;

    const-string v1, "CVF: visible conv has no messages, exiting conv mode"

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 529
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mHandler:Landroid/os/Handler;

    new-instance v1, Lcom/android/mail/ui/AbstractConversationViewFragment$5;

    const-string v2, "onError"

    invoke-direct {v1, p0, v2}, Lcom/android/mail/ui/AbstractConversationViewFragment$5;-><init>(Lcom/android/mail/ui/AbstractConversationViewFragment;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 538
    return-void
.end method


# virtual methods
.method protected dismissLoadingStatus()V
    .locals 1

    .prologue
    .line 236
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/AbstractConversationViewFragment;->dismissLoadingStatus(Ljava/lang/Runnable;)V

    .line 237
    return-void
.end method

.method protected dismissLoadingStatus(Ljava/lang/Runnable;)V
    .locals 6
    .param p1, "doAfter"    # Ljava/lang/Runnable;

    .prologue
    .line 246
    iget-wide v2, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mLoadingShownTime:J

    const-wide/16 v4, -0x1

    cmp-long v2, v2, v4

    if-nez v2, :cond_0

    .line 248
    iget-object v2, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mHandler:Landroid/os/Handler;

    iget-object v3, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mDelayedShow:Ljava/lang/Runnable;

    invoke-virtual {v2, v3}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 249
    invoke-direct {p0, p1}, Lcom/android/mail/ui/AbstractConversationViewFragment;->dismiss(Ljava/lang/Runnable;)V

    .line 263
    :goto_0
    return-void

    .line 252
    :cond_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iget-wide v4, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mLoadingShownTime:J

    sub-long/2addr v2, v4

    invoke-static {v2, v3}, Ljava/lang/Math;->abs(J)J

    move-result-wide v0

    .line 253
    .local v0, "diff":J
    sget v2, Lcom/android/mail/ui/AbstractConversationViewFragment;->sMinShowTime:I

    int-to-long v2, v2

    cmp-long v2, v0, v2

    if-lez v2, :cond_1

    .line 254
    invoke-direct {p0, p1}, Lcom/android/mail/ui/AbstractConversationViewFragment;->dismiss(Ljava/lang/Runnable;)V

    goto :goto_0

    .line 256
    :cond_1
    iget-object v2, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mHandler:Landroid/os/Handler;

    new-instance v3, Lcom/android/mail/ui/AbstractConversationViewFragment$3;

    const-string v4, "dismissLoadingStatus"

    invoke-direct {v3, p0, v4, p1}, Lcom/android/mail/ui/AbstractConversationViewFragment$3;-><init>(Lcom/android/mail/ui/AbstractConversationViewFragment;Ljava/lang/String;Ljava/lang/Runnable;)V

    sget v4, Lcom/android/mail/ui/AbstractConversationViewFragment;->sMinShowTime:I

    int-to-long v4, v4

    sub-long/2addr v4, v0

    invoke-static {v4, v5}, Ljava/lang/Math;->abs(J)J

    move-result-wide v4

    invoke-virtual {v2, v3, v4, v5}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_0
.end method

.method public getAccount()Lcom/android/mail/providers/Account;
    .locals 1

    .prologue
    .line 371
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mAccount:Lcom/android/mail/providers/Account;

    return-object v0
.end method

.method public getContactInfoSource()Lcom/android/mail/ui/AbstractConversationViewFragment$ContactLoaderCallbacks;
    .locals 1

    .prologue
    .line 366
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mContactLoaderCallbacks:Lcom/android/mail/ui/AbstractConversationViewFragment$ContactLoaderCallbacks;

    return-object v0
.end method

.method public getContext()Landroid/content/Context;
    .locals 1

    .prologue
    .line 345
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method public getConversation()Lcom/android/mail/providers/Conversation;
    .locals 1

    .prologue
    .line 349
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mConversation:Lcom/android/mail/providers/Conversation;

    return-object v0
.end method

.method public getHandler()Landroid/os/Handler;
    .locals 1

    .prologue
    .line 358
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mHandler:Landroid/os/Handler;

    return-object v0
.end method

.method public getListController()Lcom/android/mail/ui/ConversationUpdater;
    .locals 2

    .prologue
    .line 323
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractConversationViewFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/android/mail/ui/ControllableActivity;

    .line 324
    .local v0, "activity":Lcom/android/mail/ui/ControllableActivity;
    if-eqz v0, :cond_0

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getConversationUpdater()Lcom/android/mail/ui/ConversationUpdater;

    move-result-object v1

    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getMessageCursor()Lcom/android/mail/browse/MessageCursor;
    .locals 1

    .prologue
    .line 354
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mCursor:Lcom/android/mail/browse/MessageCursor;

    return-object v0
.end method

.method public getMessageLoaderCallbacks()Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoaderCallbacks;
    .locals 1

    .prologue
    .line 362
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mMessageLoaderCallbacks:Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoaderCallbacks;

    return-object v0
.end method

.method protected getNewViewState()Lcom/android/mail/ui/ConversationViewState;
    .locals 1

    .prologue
    .line 586
    new-instance v0, Lcom/android/mail/ui/ConversationViewState;

    invoke-direct {v0}, Lcom/android/mail/ui/ConversationViewState;-><init>()V

    return-object v0
.end method

.method public getSubjectRemainder(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "subject"    # Ljava/lang/String;

    .prologue
    .line 404
    iget-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->getSubjectDisplayChanger()Lcom/android/mail/ui/SubjectDisplayChanger;

    move-result-object v0

    .line 405
    .local v0, "sdc":Lcom/android/mail/ui/SubjectDisplayChanger;
    if-nez v0, :cond_0

    .line 408
    .end local p1    # "subject":Ljava/lang/String;
    :goto_0
    return-object p1

    .restart local p1    # "subject":Ljava/lang/String;
    :cond_0
    invoke-interface {v0, p1}, Lcom/android/mail/ui/SubjectDisplayChanger;->getUnshownSubject(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    goto :goto_0
.end method

.method public instantiateProgressIndicators(Landroid/view/View;)V
    .locals 1
    .param p1, "rootView"    # Landroid/view/View;

    .prologue
    .line 231
    const v0, 0x7f100069

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mBackgroundView:Landroid/view/View;

    .line 232
    const v0, 0x7f10006a

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mProgressView:Landroid/view/View;

    .line 233
    return-void
.end method

.method public isUserVisible()Z
    .locals 1

    .prologue
    .line 450
    iget-boolean v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mUserVisible:Z

    return v0
.end method

.method protected markReadOnSeen(Lcom/android/mail/ui/ConversationUpdater;)V
    .locals 5
    .param p1, "listController"    # Lcom/android/mail/ui/ConversationUpdater;

    .prologue
    const/4 v4, 0x1

    .line 574
    new-array v1, v4, [Lcom/android/mail/providers/Conversation;

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mConversation:Lcom/android/mail/providers/Conversation;

    aput-object v3, v1, v2

    invoke-static {v1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-interface {p1, v1, v4, v4}, Lcom/android/mail/ui/ConversationUpdater;->markConversationsRead(Ljava/util/Collection;ZZ)V

    .line 579
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractConversationViewFragment;->getMessageCursor()Lcom/android/mail/browse/MessageCursor;

    move-result-object v0

    .line 580
    .local v0, "cursor":Lcom/android/mail/browse/MessageCursor;
    if-eqz v0, :cond_0

    .line 581
    invoke-virtual {v0}, Lcom/android/mail/browse/MessageCursor;->markMessagesRead()V

    .line 583
    :cond_0
    return-void
.end method

.method protected abstract markUnread()V
.end method

.method protected abstract onAccountChanged(Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Account;)V
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 305
    invoke-super {p0, p1}, Landroid/app/Fragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 306
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractConversationViewFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 307
    .local v0, "activity":Landroid/app/Activity;
    instance-of v1, v0, Lcom/android/mail/ui/ControllableActivity;

    if-nez v1, :cond_0

    .line 308
    sget-object v1, Lcom/android/mail/ui/AbstractConversationViewFragment;->LOG_TAG:Ljava/lang/String;

    const-string v2, "ConversationViewFragment expects only a ControllableActivity tocreate it. Cannot proceed."

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v1, v2, v3}, Lcom/android/mail/utils/LogUtils;->wtf(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 311
    :cond_0
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Landroid/app/Activity;->isFinishing()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 319
    :cond_1
    :goto_0
    return-void

    :cond_2
    move-object v1, v0

    .line 315
    check-cast v1, Lcom/android/mail/ui/ControllableActivity;

    iput-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    .line 316
    invoke-virtual {v0}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    iput-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mContext:Landroid/content/Context;

    .line 317
    new-instance v2, Lcom/android/mail/FormattedDateBuilder;

    iget-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    check-cast v1, Landroid/content/Context;

    invoke-direct {v2, v1}, Lcom/android/mail/FormattedDateBuilder;-><init>(Landroid/content/Context;)V

    iput-object v2, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mDateBuilder:Lcom/android/mail/FormattedDateBuilder;

    .line 318
    iget-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mAccountObserver:Lcom/android/mail/providers/AccountObserver;

    iget-object v2, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v2}, Lcom/android/mail/ui/ControllableActivity;->getAccountController()Lcom/android/mail/ui/AccountController;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/android/mail/providers/AccountObserver;->initialize(Lcom/android/mail/ui/AccountController;)Lcom/android/mail/providers/Account;

    move-result-object v1

    iput-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mAccount:Lcom/android/mail/providers/Account;

    goto :goto_0
.end method

.method protected onConversationSeen()V
    .locals 9

    .prologue
    const/4 v5, 0x1

    const/4 v8, 0x0

    .line 542
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractConversationViewFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/android/mail/ui/ControllableActivity;

    .line 543
    .local v0, "activity":Lcom/android/mail/ui/ControllableActivity;
    if-nez v0, :cond_0

    .line 544
    sget-object v3, Lcom/android/mail/ui/AbstractConversationViewFragment;->LOG_TAG:Ljava/lang/String;

    const-string v4, "ignoring onConversationSeen for conv=%s"

    new-array v5, v5, [Ljava/lang/Object;

    iget-object v6, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mConversation:Lcom/android/mail/providers/Conversation;

    iget-wide v6, v6, Lcom/android/mail/providers/Conversation;->id:J

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    aput-object v6, v5, v8

    invoke-static {v3, v4, v5}, Lcom/android/mail/utils/LogUtils;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 570
    :goto_0
    return-void

    .line 548
    :cond_0
    iget-object v3, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mViewState:Lcom/android/mail/ui/ConversationViewState;

    iget-object v4, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mConversation:Lcom/android/mail/providers/Conversation;

    invoke-virtual {v3, v4}, Lcom/android/mail/ui/ConversationViewState;->setInfoForConversation(Lcom/android/mail/providers/Conversation;)V

    .line 554
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractConversationViewFragment;->getMessageCursor()Lcom/android/mail/browse/MessageCursor;

    move-result-object v1

    .line 555
    .local v1, "cursor":Lcom/android/mail/browse/MessageCursor;
    iget-object v3, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mConversation:Lcom/android/mail/providers/Conversation;

    invoke-virtual {v3}, Lcom/android/mail/providers/Conversation;->isViewed()Z

    move-result v3

    if-eqz v3, :cond_1

    if-eqz v1, :cond_2

    invoke-virtual {v1}, Lcom/android/mail/browse/MessageCursor;->isConversationRead()Z

    move-result v3

    if-nez v3, :cond_2

    .line 556
    :cond_1
    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getConversationUpdater()Lcom/android/mail/ui/ConversationUpdater;

    move-result-object v2

    .line 559
    .local v2, "listController":Lcom/android/mail/ui/ConversationUpdater;
    invoke-interface {v2}, Lcom/android/mail/ui/ConversationUpdater;->getConversationListCursor()Lcom/android/mail/browse/ConversationCursor;

    move-result-object v3

    if-nez v3, :cond_3

    .line 560
    sget-object v3, Lcom/android/mail/ui/AbstractConversationViewFragment;->LOG_TAG:Ljava/lang/String;

    const-string v4, "deferring conv mark read on open for id=%d"

    new-array v5, v5, [Ljava/lang/Object;

    iget-object v6, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mConversation:Lcom/android/mail/providers/Conversation;

    iget-wide v6, v6, Lcom/android/mail/providers/Conversation;->id:J

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    aput-object v6, v5, v8

    invoke-static {v3, v4, v5}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 562
    new-instance v3, Lcom/android/mail/ui/AbstractConversationViewFragment$MarkReadObserver;

    const/4 v4, 0x0

    invoke-direct {v3, p0, v2, v4}, Lcom/android/mail/ui/AbstractConversationViewFragment$MarkReadObserver;-><init>(Lcom/android/mail/ui/AbstractConversationViewFragment;Lcom/android/mail/ui/ConversationUpdater;Lcom/android/mail/ui/AbstractConversationViewFragment$1;)V

    iput-object v3, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mMarkReadObserver:Lcom/android/mail/ui/AbstractConversationViewFragment$MarkReadObserver;

    .line 563
    iget-object v3, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mMarkReadObserver:Lcom/android/mail/ui/AbstractConversationViewFragment$MarkReadObserver;

    invoke-interface {v2, v3}, Lcom/android/mail/ui/ConversationUpdater;->registerConversationListObserver(Landroid/database/DataSetObserver;)V

    .line 569
    .end local v2    # "listController":Lcom/android/mail/ui/ConversationUpdater;
    :cond_2
    :goto_1
    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getListHandler()Lcom/android/mail/ui/ConversationListCallbacks;

    move-result-object v3

    iget-object v4, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mConversation:Lcom/android/mail/providers/Conversation;

    invoke-interface {v3, v4}, Lcom/android/mail/ui/ConversationListCallbacks;->onConversationSeen(Lcom/android/mail/providers/Conversation;)V

    goto :goto_0

    .line 565
    .restart local v2    # "listController":Lcom/android/mail/ui/ConversationUpdater;
    :cond_3
    invoke-virtual {p0, v2}, Lcom/android/mail/ui/AbstractConversationViewFragment;->markReadOnSeen(Lcom/android/mail/ui/ConversationUpdater;)V

    goto :goto_1
.end method

.method public abstract onConversationUpdated(Lcom/android/mail/providers/Conversation;)V
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 6
    .param p1, "savedState"    # Landroid/os/Bundle;

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 196
    invoke-super {p0, p1}, Landroid/app/Fragment;->onCreate(Landroid/os/Bundle;)V

    .line 198
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractConversationViewFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 199
    .local v0, "args":Landroid/os/Bundle;
    const-string v1, "account"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Lcom/android/mail/providers/Account;

    iput-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mAccount:Lcom/android/mail/providers/Account;

    .line 200
    const-string v1, "conversation"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Lcom/android/mail/providers/Conversation;

    iput-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mConversation:Lcom/android/mail/providers/Conversation;

    .line 201
    const-string v1, "folder"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Lcom/android/mail/providers/Folder;

    iput-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mFolder:Lcom/android/mail/providers/Folder;

    .line 205
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "x-thread://"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v2, v2, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mConversation:Lcom/android/mail/providers/Conversation;

    iget-wide v2, v2, Lcom/android/mail/providers/Conversation;->id:J

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mBaseUri:Ljava/lang/String;

    .line 217
    iput-boolean v4, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mEnableContentReadySignal:Z

    .line 218
    sget-object v1, Lcom/android/mail/ui/AbstractConversationViewFragment;->LOG_TAG:Ljava/lang/String;

    const-string v2, "onCreate in ConversationViewFragment (this=%s)"

    new-array v3, v5, [Ljava/lang/Object;

    aput-object p0, v3, v4

    invoke-static {v1, v2, v3}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 220
    invoke-virtual {p0, v5}, Lcom/android/mail/ui/AbstractConversationViewFragment;->setHasOptionsMenu(Z)V

    .line 222
    if-eqz p1, :cond_0

    .line 223
    sget-object v1, Lcom/android/mail/ui/AbstractConversationViewFragment;->BUNDLE_VIEW_STATE:Ljava/lang/String;

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Lcom/android/mail/ui/ConversationViewState;

    iput-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mViewState:Lcom/android/mail/ui/ConversationViewState;

    .line 224
    sget-object v1, Lcom/android/mail/ui/AbstractConversationViewFragment;->BUNDLE_USER_VISIBLE:Ljava/lang/String;

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mUserVisible:Z

    .line 228
    :goto_0
    return-void

    .line 226
    :cond_0
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractConversationViewFragment;->getNewViewState()Lcom/android/mail/ui/ConversationViewState;

    move-result-object v1

    iput-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mViewState:Lcom/android/mail/ui/ConversationViewState;

    goto :goto_0
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 1
    .param p1, "menu"    # Landroid/view/Menu;
    .param p2, "inflater"    # Landroid/view/MenuInflater;

    .prologue
    .line 376
    invoke-super {p0, p1, p2}, Landroid/app/Fragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 377
    const v0, 0x7f100127

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mChangeFoldersMenuItem:Landroid/view/MenuItem;

    .line 378
    return-void
.end method

.method public onDestroyView()V
    .locals 2

    .prologue
    .line 422
    invoke-super {p0}, Landroid/app/Fragment;->onDestroyView()V

    .line 423
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mAccountObserver:Lcom/android/mail/providers/AccountObserver;

    invoke-virtual {v0}, Lcom/android/mail/providers/AccountObserver;->unregisterAndDestroy()V

    .line 424
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mMarkReadObserver:Lcom/android/mail/ui/AbstractConversationViewFragment$MarkReadObserver;

    if-eqz v0, :cond_0

    .line 425
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getConversationUpdater()Lcom/android/mail/ui/ConversationUpdater;

    move-result-object v0

    iget-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mMarkReadObserver:Lcom/android/mail/ui/AbstractConversationViewFragment$MarkReadObserver;

    invoke-interface {v0, v1}, Lcom/android/mail/ui/ConversationUpdater;->unregisterConversationListObserver(Landroid/database/DataSetObserver;)V

    .line 427
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mMarkReadObserver:Lcom/android/mail/ui/AbstractConversationViewFragment$MarkReadObserver;

    .line 429
    :cond_0
    return-void
.end method

.method public onFoldersClicked()V
    .locals 3

    .prologue
    .line 395
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mChangeFoldersMenuItem:Landroid/view/MenuItem;

    if-nez v0, :cond_0

    .line 396
    sget-object v0, Lcom/android/mail/ui/AbstractConversationViewFragment;->LOG_TAG:Ljava/lang/String;

    const-string v1, "unable to open \'change folders\' dialog for a conversation"

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 400
    :goto_0
    return-void

    .line 399
    :cond_0
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    iget-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mChangeFoldersMenuItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Lcom/android/mail/ui/ControllableActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    goto :goto_0
.end method

.method protected abstract onMessageCursorLoadFinished(Landroid/content/Loader;Lcom/android/mail/browse/MessageCursor;Lcom/android/mail/browse/MessageCursor;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;",
            "Lcom/android/mail/browse/MessageCursor;",
            "Lcom/android/mail/browse/MessageCursor;",
            ")V"
        }
    .end annotation
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 382
    const/4 v0, 0x0

    .line 383
    .local v0, "handled":Z
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    packed-switch v1, :pswitch_data_0

    .line 389
    :goto_0
    return v0

    .line 385
    :pswitch_0
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractConversationViewFragment;->markUnread()V

    .line 386
    const/4 v0, 0x1

    goto :goto_0

    .line 383
    :pswitch_data_0
    .packed-switch 0x7f100128
        :pswitch_0
    .end packed-switch
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 414
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mViewState:Lcom/android/mail/ui/ConversationViewState;

    if-eqz v0, :cond_0

    .line 415
    sget-object v0, Lcom/android/mail/ui/AbstractConversationViewFragment;->BUNDLE_VIEW_STATE:Ljava/lang/String;

    iget-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mViewState:Lcom/android/mail/ui/ConversationViewState;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 417
    :cond_0
    sget-object v0, Lcom/android/mail/ui/AbstractConversationViewFragment;->BUNDLE_USER_VISIBLE:Ljava/lang/String;

    iget-boolean v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mUserVisible:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 418
    return-void
.end method

.method public abstract onUserVisibleHintChanged()V
.end method

.method public setExtraUserVisibleHint(Z)V
    .locals 6
    .param p1, "isVisibleToUser"    # Z

    .prologue
    .line 436
    sget-object v1, Lcom/android/mail/ui/AbstractConversationViewFragment;->LOG_TAG:Ljava/lang/String;

    const-string v2, "in CVF.setHint, val=%s (%s)"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    aput-object p0, v3, v4

    invoke-static {v1, v2, v3}, Lcom/android/mail/utils/LogUtils;->v(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 437
    iget-boolean v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mUserVisible:Z

    if-eq v1, p1, :cond_0

    .line 438
    iput-boolean p1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mUserVisible:Z

    .line 439
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractConversationViewFragment;->getMessageCursor()Lcom/android/mail/browse/MessageCursor;

    move-result-object v0

    .line 440
    .local v0, "cursor":Lcom/android/mail/browse/MessageCursor;
    iget-boolean v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mUserVisible:Z

    if-eqz v1, :cond_1

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/android/mail/browse/MessageCursor;->isLoaded()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-virtual {v0}, Lcom/android/mail/browse/MessageCursor;->getCount()I

    move-result v1

    if-nez v1, :cond_1

    .line 442
    invoke-direct {p0}, Lcom/android/mail/ui/AbstractConversationViewFragment;->onError()V

    .line 447
    .end local v0    # "cursor":Lcom/android/mail/browse/MessageCursor;
    :cond_0
    :goto_0
    return-void

    .line 445
    .restart local v0    # "cursor":Lcom/android/mail/browse/MessageCursor;
    :cond_1
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractConversationViewFragment;->onUserVisibleHintChanged()V

    goto :goto_0
.end method

.method protected showLoadingStatus()V
    .locals 5

    .prologue
    .line 329
    iget-boolean v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mUserVisible:Z

    if-nez v1, :cond_0

    .line 342
    :goto_0
    return-void

    .line 332
    :cond_0
    sget v1, Lcom/android/mail/ui/AbstractConversationViewFragment;->sMinDelay:I

    const/4 v2, -0x1

    if-ne v1, v2, :cond_1

    .line 333
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractConversationViewFragment;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 334
    .local v0, "res":Landroid/content/res/Resources;
    const v1, 0x7f0a0029

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v1

    sput v1, Lcom/android/mail/ui/AbstractConversationViewFragment;->sMinDelay:I

    .line 335
    const v1, 0x7f0a002a

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v1

    sput v1, Lcom/android/mail/ui/AbstractConversationViewFragment;->sMinShowTime:I

    .line 339
    .end local v0    # "res":Landroid/content/res/Resources;
    :cond_1
    iget-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mBackgroundView:Landroid/view/View;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 340
    iget-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mHandler:Landroid/os/Handler;

    iget-object v2, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mDelayedShow:Ljava/lang/Runnable;

    invoke-virtual {v1, v2}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 341
    iget-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mHandler:Landroid/os/Handler;

    iget-object v2, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mDelayedShow:Ljava/lang/Runnable;

    sget v3, Lcom/android/mail/ui/AbstractConversationViewFragment;->sMinDelay:I

    int-to-long v3, v3

    invoke-virtual {v1, v2, v3, v4}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_0
.end method
