.class public final Lcom/android/mail/ui/ConversationViewFragment;
.super Lcom/android/mail/ui/AbstractConversationViewFragment;
.source "ConversationViewFragment.java"

# interfaces
.implements Landroid/view/View$OnLayoutChangeListener;
.implements Lcom/android/mail/browse/ConversationViewAdapter$ConversationAccountController;
.implements Lcom/android/mail/browse/MessageCursor$ConversationController;
.implements Lcom/android/mail/browse/MessageHeaderView$MessageHeaderViewCallbacks;
.implements Lcom/android/mail/browse/SuperCollapsedBlock$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/ui/ConversationViewFragment$SetCookieTask;,
        Lcom/android/mail/ui/ConversationViewFragment$NewMessagesInfo;,
        Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;,
        Lcom/android/mail/ui/ConversationViewFragment$ConversationWebViewClient;
    }
.end annotation


# static fields
.field private static final BUNDLE_KEY_WEBVIEW_Y_PERCENT:Ljava/lang/String;

.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private final LOAD_NOW:I

.field private final LOAD_WAIT_FOR_INITIAL_CONVERSATION:I

.field private final LOAD_WAIT_UNTIL_VISIBLE:I

.field private mAdapter:Lcom/android/mail/browse/ConversationViewAdapter;

.field private mConversationContainer:Lcom/android/mail/browse/ConversationContainer;

.field private mDiff:I

.field private mEnableContentReadySignal:Z

.field private final mJsBridge:Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;

.field private mLoadWaitReason:I

.field private final mLoadedObserver:Landroid/database/DataSetObserver;

.field private mMaxAutoLoadMessages:I

.field private mNeedRender:Z

.field private mNewMessageBar:Landroid/view/View;

.field private final mOnProgressDismiss:Ljava/lang/Runnable;

.field private mScrollIndicators:Lcom/android/mail/browse/ScrollIndicatorsView;

.field private mTempBodiesHtml:Ljava/lang/String;

.field private mTemplates:Lcom/android/mail/ui/HtmlConversationTemplates;

.field private mViewsCreated:Z

.field private mWebView:Lcom/android/mail/browse/ConversationWebView;

.field private final mWebViewClient:Landroid/webkit/WebViewClient;

.field private mWebViewLoadStartMs:J

.field private mWebViewLoadedData:Z

.field private mWebViewSizeChangeListener:Lcom/android/mail/browse/ConversationWebView$ContentSizeChangeListener;

.field private mWebViewYPercent:F


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 93
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/ui/ConversationViewFragment;->LOG_TAG:Ljava/lang/String;

    .line 199
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-class v1, Lcom/android/mail/ui/ConversationViewFragment;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "webview-y-percent"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/ui/ConversationViewFragment;->BUNDLE_KEY_WEBVIEW_Y_PERCENT:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 206
    invoke-direct {p0}, Lcom/android/mail/ui/AbstractConversationViewFragment;-><init>()V

    .line 99
    iput v1, p0, Lcom/android/mail/ui/ConversationViewFragment;->mDiff:I

    .line 104
    iput v1, p0, Lcom/android/mail/ui/ConversationViewFragment;->LOAD_NOW:I

    .line 112
    const/4 v0, 0x1

    iput v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->LOAD_WAIT_FOR_INITIAL_CONVERSATION:I

    .line 118
    const/4 v0, 0x2

    iput v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->LOAD_WAIT_UNTIL_VISIBLE:I

    .line 130
    new-instance v0, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;

    invoke-direct {v0, p0, v2}, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;-><init>(Lcom/android/mail/ui/ConversationViewFragment;Lcom/android/mail/ui/ConversationViewFragment$1;)V

    iput-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mJsBridge:Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;

    .line 132
    new-instance v0, Lcom/android/mail/ui/ConversationViewFragment$ConversationWebViewClient;

    invoke-direct {v0, p0, v2}, Lcom/android/mail/ui/ConversationViewFragment$ConversationWebViewClient;-><init>(Lcom/android/mail/ui/ConversationViewFragment;Lcom/android/mail/ui/ConversationViewFragment$1;)V

    iput-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebViewClient:Landroid/webkit/WebViewClient;

    .line 156
    iput v1, p0, Lcom/android/mail/ui/ConversationViewFragment;->mLoadWaitReason:I

    .line 171
    new-instance v0, Lcom/android/mail/ui/ConversationViewFragment$1;

    invoke-direct {v0, p0}, Lcom/android/mail/ui/ConversationViewFragment$1;-><init>(Lcom/android/mail/ui/ConversationViewFragment;)V

    iput-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mLoadedObserver:Landroid/database/DataSetObserver;

    .line 185
    new-instance v0, Lcom/android/mail/ui/ConversationViewFragment$2;

    const-string v1, "onProgressDismiss"

    invoke-direct {v0, p0, v1}, Lcom/android/mail/ui/ConversationViewFragment$2;-><init>(Lcom/android/mail/ui/ConversationViewFragment;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mOnProgressDismiss:Ljava/lang/Runnable;

    .line 207
    return-void
.end method

.method static synthetic access$1000(Lcom/android/mail/ui/ConversationViewFragment;)Z
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/ConversationViewFragment;

    .prologue
    .line 86
    iget-boolean v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mEnableContentReadySignal:Z

    return v0
.end method

.method static synthetic access$1100(Lcom/android/mail/ui/ConversationViewFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/ui/ConversationViewFragment;

    .prologue
    .line 86
    invoke-direct {p0}, Lcom/android/mail/ui/ConversationViewFragment;->revealConversation()V

    return-void
.end method

.method static synthetic access$1200([Ljava/lang/String;[Ljava/lang/String;)[Lcom/android/mail/browse/ConversationContainer$OverlayPosition;
    .locals 1
    .param p0, "x0"    # [Ljava/lang/String;
    .param p1, "x1"    # [Ljava/lang/String;

    .prologue
    .line 86
    invoke-static {p0, p1}, Lcom/android/mail/ui/ConversationViewFragment;->parsePositions([Ljava/lang/String;[Ljava/lang/String;)[Lcom/android/mail/browse/ConversationContainer$OverlayPosition;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$1300(Lcom/android/mail/ui/ConversationViewFragment;)Lcom/android/mail/browse/ConversationContainer;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/ConversationViewFragment;

    .prologue
    .line 86
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mConversationContainer:Lcom/android/mail/browse/ConversationContainer;

    return-object v0
.end method

.method static synthetic access$1400(Lcom/android/mail/ui/ConversationViewFragment;)I
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/ConversationViewFragment;

    .prologue
    .line 86
    iget v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mDiff:I

    return v0
.end method

.method static synthetic access$1402(Lcom/android/mail/ui/ConversationViewFragment;I)I
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/ui/ConversationViewFragment;
    .param p1, "x1"    # I

    .prologue
    .line 86
    iput p1, p0, Lcom/android/mail/ui/ConversationViewFragment;->mDiff:I

    return p1
.end method

.method static synthetic access$1500(Lcom/android/mail/ui/ConversationViewFragment;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/ConversationViewFragment;

    .prologue
    .line 86
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mTempBodiesHtml:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1502(Lcom/android/mail/ui/ConversationViewFragment;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/ui/ConversationViewFragment;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 86
    iput-object p1, p0, Lcom/android/mail/ui/ConversationViewFragment;->mTempBodiesHtml:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$1600(Lcom/android/mail/ui/ConversationViewFragment;)Lcom/android/mail/ui/HtmlConversationTemplates;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/ConversationViewFragment;

    .prologue
    .line 86
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mTemplates:Lcom/android/mail/ui/HtmlConversationTemplates;

    return-object v0
.end method

.method static synthetic access$1700(Lcom/android/mail/ui/ConversationViewFragment;)F
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/ConversationViewFragment;

    .prologue
    .line 86
    iget v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebViewYPercent:F

    return v0
.end method

.method static synthetic access$1800(Lcom/android/mail/ui/ConversationViewFragment;Ljava/lang/String;)Lcom/android/mail/providers/Address;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/ConversationViewFragment;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 86
    invoke-direct {p0, p1}, Lcom/android/mail/ui/ConversationViewFragment;->getAddress(Ljava/lang/String;)Lcom/android/mail/providers/Address;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$200()Ljava/lang/String;
    .locals 1

    .prologue
    .line 86
    sget-object v0, Lcom/android/mail/ui/ConversationViewFragment;->LOG_TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$300(Lcom/android/mail/ui/ConversationViewFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/ui/ConversationViewFragment;

    .prologue
    .line 86
    invoke-direct {p0}, Lcom/android/mail/ui/ConversationViewFragment;->handleDelayedConversationLoad()V

    return-void
.end method

.method static synthetic access$400(Lcom/android/mail/ui/ConversationViewFragment;)Lcom/android/mail/browse/ConversationWebView;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/ConversationViewFragment;

    .prologue
    .line 86
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    return-object v0
.end method

.method static synthetic access$500(Lcom/android/mail/ui/ConversationViewFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/ui/ConversationViewFragment;

    .prologue
    .line 86
    invoke-direct {p0}, Lcom/android/mail/ui/ConversationViewFragment;->showConversation()V

    return-void
.end method

.method static synthetic access$600(Lcom/android/mail/ui/ConversationViewFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/ui/ConversationViewFragment;

    .prologue
    .line 86
    invoke-direct {p0}, Lcom/android/mail/ui/ConversationViewFragment;->onNewMessageBarClick()V

    return-void
.end method

.method static synthetic access$700(Lcom/android/mail/ui/ConversationViewFragment;)Z
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/ConversationViewFragment;

    .prologue
    .line 86
    iget-boolean v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mViewsCreated:Z

    return v0
.end method

.method static synthetic access$800(Lcom/android/mail/ui/ConversationViewFragment;)J
    .locals 2
    .param p0, "x0"    # Lcom/android/mail/ui/ConversationViewFragment;

    .prologue
    .line 86
    iget-wide v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebViewLoadStartMs:J

    return-wide v0
.end method

.method static synthetic access$900(Lcom/android/mail/ui/ConversationViewFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/ui/ConversationViewFragment;

    .prologue
    .line 86
    invoke-direct {p0}, Lcom/android/mail/ui/ConversationViewFragment;->ensureContentSizeChangeListener()V

    return-void
.end method

.method private calculateScrollYPercent()F
    .locals 6

    .prologue
    .line 407
    iget-object v4, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    invoke-virtual {v4}, Lcom/android/mail/browse/ConversationWebView;->getScrollY()I

    move-result v1

    .line 408
    .local v1, "scrollY":I
    iget-object v4, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    invoke-virtual {v4}, Lcom/android/mail/browse/ConversationWebView;->getHeight()I

    move-result v2

    .line 409
    .local v2, "viewH":I
    iget-object v4, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    invoke-virtual {v4}, Lcom/android/mail/browse/ConversationWebView;->getContentHeight()I

    move-result v4

    int-to-float v4, v4

    iget-object v5, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    invoke-virtual {v5}, Lcom/android/mail/browse/ConversationWebView;->getScale()F

    move-result v5

    mul-float/2addr v4, v5

    float-to-int v3, v4

    .line 411
    .local v3, "webH":I
    if-eqz v3, :cond_0

    if-gt v3, v2, :cond_1

    .line 412
    :cond_0
    const/4 v0, 0x0

    .line 420
    .local v0, "p":F
    :goto_0
    return v0

    .line 413
    .end local v0    # "p":F
    :cond_1
    add-int v4, v1, v2

    if-lt v4, v3, :cond_2

    .line 416
    const/high16 v0, 0x3f800000    # 1.0f

    .restart local v0    # "p":F
    goto :goto_0

    .line 418
    .end local v0    # "p":F
    :cond_2
    int-to-float v4, v1

    int-to-float v5, v3

    div-float v0, v4, v5

    .restart local v0    # "p":F
    goto :goto_0
.end method

.method private ensureContentSizeChangeListener()V
    .locals 2

    .prologue
    .line 887
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebViewSizeChangeListener:Lcom/android/mail/browse/ConversationWebView$ContentSizeChangeListener;

    if-nez v0, :cond_0

    .line 888
    new-instance v0, Lcom/android/mail/ui/ConversationViewFragment$6;

    invoke-direct {v0, p0}, Lcom/android/mail/ui/ConversationViewFragment$6;-><init>(Lcom/android/mail/ui/ConversationViewFragment;)V

    iput-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebViewSizeChangeListener:Lcom/android/mail/browse/ConversationWebView$ContentSizeChangeListener;

    .line 900
    :cond_0
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    iget-object v1, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebViewSizeChangeListener:Lcom/android/mail/browse/ConversationWebView$ContentSizeChangeListener;

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/ConversationWebView;->setContentSizeChangeListener(Lcom/android/mail/browse/ConversationWebView$ContentSizeChangeListener;)V

    .line 901
    return-void
.end method

.method private getAddress(Ljava/lang/String;)Lcom/android/mail/providers/Address;
    .locals 2
    .param p1, "rawFrom"    # Ljava/lang/String;

    .prologue
    .line 878
    iget-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mAddressCache:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Address;

    .line 879
    .local v0, "addr":Lcom/android/mail/providers/Address;
    if-nez v0, :cond_0

    .line 880
    invoke-static {p1}, Lcom/android/mail/providers/Address;->getEmailAddress(Ljava/lang/String;)Lcom/android/mail/providers/Address;

    move-result-object v0

    .line 881
    iget-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mAddressCache:Ljava/util/Map;

    invoke-interface {v1, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 883
    :cond_0
    return-object v0
.end method

.method private getNewIncomingMessagesInfo(Lcom/android/mail/browse/MessageCursor;)Lcom/android/mail/ui/ConversationViewFragment$NewMessagesInfo;
    .locals 9

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 1168
    new-instance v1, Lcom/android/mail/ui/ConversationViewFragment$NewMessagesInfo;

    const/4 v0, 0x0

    invoke-direct {v1, p0, v0}, Lcom/android/mail/ui/ConversationViewFragment$NewMessagesInfo;-><init>(Lcom/android/mail/ui/ConversationViewFragment;Lcom/android/mail/ui/ConversationViewFragment$1;)V

    .line 1170
    const/4 v0, -0x1

    .line 1171
    :cond_0
    :goto_0
    add-int/lit8 v0, v0, 0x1

    invoke-virtual {p1, v0}, Lcom/android/mail/browse/MessageCursor;->moveToPosition(I)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 1172
    invoke-virtual {p1}, Lcom/android/mail/browse/MessageCursor;->getMessage()Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    move-result-object v2

    .line 1173
    iget-object v3, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mViewState:Lcom/android/mail/ui/ConversationViewState;

    invoke-virtual {v3, v2}, Lcom/android/mail/ui/ConversationViewState;->contains(Lcom/android/mail/providers/Message;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 1174
    sget-object v3, Lcom/android/mail/ui/ConversationViewFragment;->LOG_TAG:Ljava/lang/String;

    const-string v4, "conversation diff: found new msg: %s"

    new-array v5, v8, [Ljava/lang/Object;

    iget-object v6, v2, Lcom/android/mail/providers/Message;->uri:Landroid/net/Uri;

    aput-object v6, v5, v7

    invoke-static {v3, v4, v5}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1176
    iget-object v3, v2, Lcom/android/mail/providers/Message;->from:Ljava/lang/String;

    invoke-direct {p0, v3}, Lcom/android/mail/ui/ConversationViewFragment;->getAddress(Ljava/lang/String;)Lcom/android/mail/providers/Address;

    move-result-object v3

    .line 1180
    iget-object v4, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mAccount:Lcom/android/mail/providers/Account;

    invoke-virtual {v3}, Lcom/android/mail/providers/Address;->getAddress()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v3}, Lcom/android/mail/providers/Account;->ownsFromAddress(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 1181
    sget-object v3, Lcom/android/mail/ui/ConversationViewFragment;->LOG_TAG:Ljava/lang/String;

    const-string v4, "found message from self: %s"

    new-array v5, v8, [Ljava/lang/Object;

    iget-object v2, v2, Lcom/android/mail/providers/Message;->uri:Landroid/net/Uri;

    aput-object v2, v5, v7

    invoke-static {v3, v4, v5}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1182
    iget v2, v1, Lcom/android/mail/ui/ConversationViewFragment$NewMessagesInfo;->countFromSelf:I

    add-int/lit8 v2, v2, 0x1

    iput v2, v1, Lcom/android/mail/ui/ConversationViewFragment$NewMessagesInfo;->countFromSelf:I

    goto :goto_0

    .line 1186
    :cond_1
    iget v3, v1, Lcom/android/mail/ui/ConversationViewFragment$NewMessagesInfo;->count:I

    add-int/lit8 v3, v3, 0x1

    iput v3, v1, Lcom/android/mail/ui/ConversationViewFragment$NewMessagesInfo;->count:I

    .line 1187
    iget-object v2, v2, Lcom/android/mail/providers/Message;->from:Ljava/lang/String;

    iput-object v2, v1, Lcom/android/mail/ui/ConversationViewFragment$NewMessagesInfo;->senderAddress:Ljava/lang/String;

    goto :goto_0

    .line 1190
    :cond_2
    return-object v1
.end method

.method private handleDelayedConversationLoad()V
    .locals 0

    .prologue
    .line 509
    invoke-direct {p0}, Lcom/android/mail/ui/ConversationViewFragment;->resetLoadWaiting()V

    .line 510
    invoke-direct {p0}, Lcom/android/mail/ui/ConversationViewFragment;->startConversationLoad()V

    .line 511
    return-void
.end method

.method private isLoadWaiting()Z
    .locals 1

    .prologue
    .line 533
    iget v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mLoadWaitReason:I

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static isOverviewMode(Lcom/android/mail/providers/Account;)Z
    .locals 1
    .param p0, "acct"    # Lcom/android/mail/providers/Account;

    .prologue
    .line 904
    iget-object v0, p0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    iget v0, v0, Lcom/android/mail/providers/Settings;->conversationViewMode:I

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private measureOverlayHeight(I)I
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 755
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mAdapter:Lcom/android/mail/browse/ConversationViewAdapter;

    invoke-virtual {v0, p1}, Lcom/android/mail/browse/ConversationViewAdapter;->getItem(I)Lcom/android/mail/browse/ConversationOverlayItem;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/android/mail/ui/ConversationViewFragment;->measureOverlayHeight(Lcom/android/mail/browse/ConversationOverlayItem;)I

    move-result v0

    return v0
.end method

.method private measureOverlayHeight(Lcom/android/mail/browse/ConversationOverlayItem;)I
    .locals 7
    .param p1, "convItem"    # Lcom/android/mail/browse/ConversationOverlayItem;

    .prologue
    .line 771
    invoke-virtual {p1}, Lcom/android/mail/browse/ConversationOverlayItem;->getType()I

    move-result v3

    .line 773
    .local v3, "type":I
    iget-object v4, p0, Lcom/android/mail/ui/ConversationViewFragment;->mConversationContainer:Lcom/android/mail/browse/ConversationContainer;

    invoke-virtual {v4, v3}, Lcom/android/mail/browse/ConversationContainer;->getScrapView(I)Landroid/view/View;

    move-result-object v0

    .line 774
    .local v0, "convertView":Landroid/view/View;
    iget-object v4, p0, Lcom/android/mail/ui/ConversationViewFragment;->mAdapter:Lcom/android/mail/browse/ConversationViewAdapter;

    iget-object v5, p0, Lcom/android/mail/ui/ConversationViewFragment;->mConversationContainer:Lcom/android/mail/browse/ConversationContainer;

    const/4 v6, 0x1

    invoke-virtual {v4, p1, v0, v5, v6}, Lcom/android/mail/browse/ConversationViewAdapter;->getView(Lcom/android/mail/browse/ConversationOverlayItem;Landroid/view/View;Landroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    .line 776
    .local v2, "hostView":Landroid/view/View;
    if-nez v0, :cond_0

    .line 777
    iget-object v4, p0, Lcom/android/mail/ui/ConversationViewFragment;->mConversationContainer:Lcom/android/mail/browse/ConversationContainer;

    invoke-virtual {v4, v3, v2}, Lcom/android/mail/browse/ConversationContainer;->addScrapView(ILandroid/view/View;)V

    .line 780
    :cond_0
    iget-object v4, p0, Lcom/android/mail/ui/ConversationViewFragment;->mConversationContainer:Lcom/android/mail/browse/ConversationContainer;

    invoke-virtual {v4, v2}, Lcom/android/mail/browse/ConversationContainer;->measureOverlay(Landroid/view/View;)I

    move-result v1

    .line 781
    .local v1, "heightPx":I
    invoke-virtual {p1, v1}, Lcom/android/mail/browse/ConversationOverlayItem;->setHeight(I)Z

    .line 782
    invoke-virtual {p1}, Lcom/android/mail/browse/ConversationOverlayItem;->markMeasurementValid()V

    .line 784
    return v1
.end method

.method public static newInstance(Landroid/os/Bundle;Lcom/android/mail/providers/Conversation;)Lcom/android/mail/ui/ConversationViewFragment;
    .locals 3
    .param p0, "existingArgs"    # Landroid/os/Bundle;
    .param p1, "conversation"    # Lcom/android/mail/providers/Conversation;

    .prologue
    .line 216
    new-instance v1, Lcom/android/mail/ui/ConversationViewFragment;

    invoke-direct {v1}, Lcom/android/mail/ui/ConversationViewFragment;-><init>()V

    .line 217
    .local v1, "f":Lcom/android/mail/ui/ConversationViewFragment;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0, p0}, Landroid/os/Bundle;-><init>(Landroid/os/Bundle;)V

    .line 218
    .local v0, "args":Landroid/os/Bundle;
    const-string v2, "conversation"

    invoke-virtual {v0, v2, p1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 219
    invoke-virtual {v1, v0}, Lcom/android/mail/ui/ConversationViewFragment;->setArguments(Landroid/os/Bundle;)V

    .line 220
    return-object v1
.end method

.method private onNewMessageBarClick()V
    .locals 2

    .prologue
    .line 850
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mNewMessageBar:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 852
    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationViewFragment;->getMessageCursor()Lcom/android/mail/browse/MessageCursor;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/android/mail/ui/ConversationViewFragment;->renderConversation(Lcom/android/mail/browse/MessageCursor;)V

    .line 854
    return-void
.end method

.method private static parsePositions([Ljava/lang/String;[Ljava/lang/String;)[Lcom/android/mail/browse/ConversationContainer$OverlayPosition;
    .locals 6
    .param p0, "topArray"    # [Ljava/lang/String;
    .param p1, "bottomArray"    # [Ljava/lang/String;

    .prologue
    .line 858
    array-length v1, p0

    .line 859
    .local v1, "len":I
    new-array v2, v1, [Lcom/android/mail/browse/ConversationContainer$OverlayPosition;

    .line 860
    .local v2, "positions":[Lcom/android/mail/browse/ConversationContainer$OverlayPosition;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v1, :cond_0

    .line 861
    new-instance v3, Lcom/android/mail/browse/ConversationContainer$OverlayPosition;

    aget-object v4, p0, v0

    invoke-static {v4}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v4

    aget-object v5, p1, v0

    invoke-static {v5}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v5

    invoke-direct {v3, v4, v5}, Lcom/android/mail/browse/ConversationContainer$OverlayPosition;-><init>(II)V

    aput-object v3, v2, v0

    .line 860
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 864
    :cond_0
    return-object v2
.end method

.method private processInPlaceUpdates(Lcom/android/mail/browse/MessageCursor;Lcom/android/mail/browse/MessageCursor;)Z
    .locals 12

    .prologue
    .line 1194
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v2

    .line 1195
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v3

    .line 1197
    const/4 v1, 0x0

    .line 1199
    const/4 v0, 0x0

    .line 1201
    :goto_0
    invoke-virtual {p1, v0}, Lcom/android/mail/browse/MessageCursor;->moveToPosition(I)Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-virtual {p2, v0}, Lcom/android/mail/browse/MessageCursor;->moveToPosition(I)Z

    move-result v4

    if-nez v4, :cond_2

    .line 1227
    :cond_0
    invoke-interface {v3}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_7

    .line 1229
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mConversationContainer:Lcom/android/mail/browse/ConversationContainer;

    invoke-virtual {v0, v3}, Lcom/android/mail/browse/ConversationContainer;->onOverlayModelUpdate(Ljava/util/List;)V

    .line 1230
    const/4 v0, 0x1

    .line 1233
    :goto_1
    invoke-interface {v2}, Ljava/util/Set;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_1

    .line 1234
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    const-string v1, "javascript:replaceMessageBodies([%s]);"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    const-string v5, ","

    invoke-static {v5, v2}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v3, v4

    invoke-static {v1, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/ConversationWebView;->loadUrl(Ljava/lang/String;)V

    .line 1236
    const/4 v0, 0x1

    .line 1239
    :cond_1
    return v0

    .line 1205
    :cond_2
    invoke-virtual {p1}, Lcom/android/mail/browse/MessageCursor;->getMessage()Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    move-result-object v4

    .line 1206
    invoke-virtual {p2}, Lcom/android/mail/browse/MessageCursor;->getMessage()Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    move-result-object v5

    .line 1208
    iget-object v6, v4, Lcom/android/mail/providers/Message;->from:Ljava/lang/String;

    iget-object v7, v5, Lcom/android/mail/providers/Message;->from:Ljava/lang/String;

    invoke-static {v6, v7}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v6

    if-eqz v6, :cond_3

    iget-boolean v6, v4, Lcom/android/mail/providers/Message;->isSending:Z

    iget-boolean v7, v5, Lcom/android/mail/providers/Message;->isSending:Z

    if-eq v6, v7, :cond_4

    .line 1210
    :cond_3
    iget-object v6, p0, Lcom/android/mail/ui/ConversationViewFragment;->mAdapter:Lcom/android/mail/browse/ConversationViewAdapter;

    invoke-virtual {v6, v4, v3}, Lcom/android/mail/browse/ConversationViewAdapter;->updateItemsForMessage(Lcom/android/mail/browse/MessageCursor$ConversationMessage;Ljava/util/List;)V

    .line 1211
    sget-object v6, Lcom/android/mail/ui/ConversationViewFragment;->LOG_TAG:Ljava/lang/String;

    const-string v7, "msg #%d (%d): detected from/sending change. isSending=%s"

    const/4 v8, 0x3

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    aput-object v10, v8, v9

    const/4 v9, 0x1

    iget-wide v10, v4, Lcom/android/mail/providers/Message;->id:J

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v10

    aput-object v10, v8, v9

    const/4 v9, 0x2

    iget-boolean v10, v4, Lcom/android/mail/providers/Message;->isSending:Z

    invoke-static {v10}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v10

    aput-object v10, v8, v9

    invoke-static {v6, v7, v8}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1216
    :cond_4
    iget-object v6, v4, Lcom/android/mail/providers/Message;->bodyHtml:Ljava/lang/String;

    iget-object v7, v5, Lcom/android/mail/providers/Message;->bodyHtml:Ljava/lang/String;

    invoke-static {v6, v7}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v6

    if-eqz v6, :cond_5

    iget-object v6, v4, Lcom/android/mail/providers/Message;->bodyText:Ljava/lang/String;

    iget-object v5, v5, Lcom/android/mail/providers/Message;->bodyText:Ljava/lang/String;

    invoke-static {v6, v5}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_6

    .line 1219
    :cond_5
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const/16 v6, 0x22

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lcom/android/mail/ui/ConversationViewFragment;->mTemplates:Lcom/android/mail/ui/HtmlConversationTemplates;

    invoke-virtual {v6, v4}, Lcom/android/mail/ui/HtmlConversationTemplates;->getMessageDomId(Lcom/android/mail/providers/Message;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const/16 v6, 0x22

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v2, v5}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 1220
    sget-object v5, Lcom/android/mail/ui/ConversationViewFragment;->LOG_TAG:Ljava/lang/String;

    const-string v6, "msg #%d (%d): detected body change"

    const/4 v7, 0x2

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v7, v8

    const/4 v8, 0x1

    iget-wide v9, v4, Lcom/android/mail/providers/Message;->id:J

    invoke-static {v9, v10}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    aput-object v4, v7, v8

    invoke-static {v5, v6, v7}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1223
    :cond_6
    add-int/lit8 v0, v0, 0x1

    .line 1224
    goto/16 :goto_0

    :cond_7
    move v0, v1

    goto/16 :goto_1
.end method

.method private processNewOutgoingMessage(Lcom/android/mail/browse/MessageCursor$ConversationMessage;)V
    .locals 2

    .prologue
    .line 1243
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mTemplates:Lcom/android/mail/ui/HtmlConversationTemplates;

    invoke-virtual {v0}, Lcom/android/mail/ui/HtmlConversationTemplates;->reset()V

    .line 1247
    const/4 v0, 0x1

    iget-boolean v1, p1, Lcom/android/mail/providers/Message;->alwaysShowImages:Z

    invoke-direct {p0, p1, v0, v1}, Lcom/android/mail/ui/ConversationViewFragment;->renderMessage(Lcom/android/mail/browse/MessageCursor$ConversationMessage;ZZ)V

    .line 1248
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mTemplates:Lcom/android/mail/ui/HtmlConversationTemplates;

    invoke-virtual {v0}, Lcom/android/mail/ui/HtmlConversationTemplates;->emit()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mTempBodiesHtml:Ljava/lang/String;

    .line 1250
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mViewState:Lcom/android/mail/ui/ConversationViewState;

    sget v1, Lcom/android/mail/ui/ConversationViewState$ExpansionState;->EXPANDED:I

    invoke-virtual {v0, p1, v1}, Lcom/android/mail/ui/ConversationViewState;->setExpansionState(Lcom/android/mail/providers/Message;I)V

    .line 1252
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mViewState:Lcom/android/mail/ui/ConversationViewState;

    const/4 v1, 0x0

    invoke-virtual {v0, p1, v1}, Lcom/android/mail/ui/ConversationViewState;->setReadState(Lcom/android/mail/providers/Message;Z)V

    .line 1256
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mConversationContainer:Lcom/android/mail/browse/ConversationContainer;

    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationContainer;->invalidateSpacerGeometry()V

    .line 1258
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    const-string v1, "javascript:appendMessageHtml();"

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/ConversationWebView;->loadUrl(Ljava/lang/String;)V

    .line 1259
    return-void
.end method

.method private renderCollapsedHeaders(Lcom/android/mail/browse/MessageCursor;Lcom/android/mail/browse/ConversationViewAdapter$SuperCollapsedBlockItem;)Ljava/lang/String;
    .locals 16
    .param p1, "cursor"    # Lcom/android/mail/browse/MessageCursor;
    .param p2, "blockToReplace"    # Lcom/android/mail/browse/ConversationViewAdapter$SuperCollapsedBlockItem;

    .prologue
    .line 713
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v15

    .line 715
    .local v15, "replacements":Ljava/util/List;, "Ljava/util/List<Lcom/android/mail/browse/ConversationOverlayItem;>;"
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/android/mail/ui/ConversationViewFragment;->mTemplates:Lcom/android/mail/ui/HtmlConversationTemplates;

    invoke-virtual {v1}, Lcom/android/mail/ui/HtmlConversationTemplates;->reset()V

    .line 719
    const/4 v9, 0x0

    .line 720
    .local v9, "error":F
    invoke-virtual/range {p2 .. p2}, Lcom/android/mail/browse/ConversationViewAdapter$SuperCollapsedBlockItem;->getStart()I

    move-result v14

    .local v14, "i":I
    invoke-virtual/range {p2 .. p2}, Lcom/android/mail/browse/ConversationViewAdapter$SuperCollapsedBlockItem;->getEnd()I

    move-result v8

    .local v8, "end":I
    :goto_0
    if-gt v14, v8, :cond_1

    .line 721
    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Lcom/android/mail/browse/MessageCursor;->moveToPosition(I)Z

    .line 722
    invoke-virtual/range {p1 .. p1}, Lcom/android/mail/browse/MessageCursor;->getMessage()Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    move-result-object v2

    .line 723
    .local v2, "msg":Lcom/android/mail/browse/MessageCursor$ConversationMessage;
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/android/mail/ui/ConversationViewFragment;->mAdapter:Lcom/android/mail/browse/ConversationViewAdapter;

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Lcom/android/mail/browse/ConversationViewAdapter;->newMessageHeaderItem(Lcom/android/mail/browse/MessageCursor$ConversationMessage;Z)Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    move-result-object v12

    .line 725
    .local v12, "header":Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/android/mail/ui/ConversationViewFragment;->mAdapter:Lcom/android/mail/browse/ConversationViewAdapter;

    invoke-virtual {v1, v12}, Lcom/android/mail/browse/ConversationViewAdapter;->newMessageFooterItem(Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;)Lcom/android/mail/browse/ConversationViewAdapter$MessageFooterItem;

    move-result-object v10

    .line 727
    .local v10, "footer":Lcom/android/mail/browse/ConversationViewAdapter$MessageFooterItem;
    move-object/from16 v0, p0

    invoke-direct {v0, v12}, Lcom/android/mail/ui/ConversationViewFragment;->measureOverlayHeight(Lcom/android/mail/browse/ConversationOverlayItem;)I

    move-result v13

    .line 728
    .local v13, "headerPx":I
    move-object/from16 v0, p0

    invoke-direct {v0, v10}, Lcom/android/mail/ui/ConversationViewFragment;->measureOverlayHeight(Lcom/android/mail/browse/ConversationOverlayItem;)I

    move-result v11

    .line 729
    .local v11, "footerPx":I
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    invoke-virtual {v1, v13}, Lcom/android/mail/browse/ConversationWebView;->screenPxToWebPxError(I)F

    move-result v1

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    invoke-virtual {v3, v11}, Lcom/android/mail/browse/ConversationWebView;->screenPxToWebPxError(I)F

    move-result v3

    add-float/2addr v1, v3

    add-float/2addr v9, v1

    .line 733
    const/4 v7, 0x0

    .line 734
    .local v7, "correction":I
    const/high16 v1, 0x3f800000    # 1.0f

    cmpl-float v1, v9, v1

    if-ltz v1, :cond_0

    .line 735
    const/4 v7, 0x1

    .line 736
    const/high16 v1, 0x3f800000    # 1.0f

    sub-float/2addr v9, v1

    .line 739
    :cond_0
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/android/mail/ui/ConversationViewFragment;->mTemplates:Lcom/android/mail/ui/HtmlConversationTemplates;

    const/4 v3, 0x0

    iget-boolean v4, v2, Lcom/android/mail/providers/Message;->alwaysShowImages:Z

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    invoke-virtual {v5, v13}, Lcom/android/mail/browse/ConversationWebView;->screenPxToWebPx(I)I

    move-result v5

    add-int/2addr v5, v7

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    invoke-virtual {v6, v11}, Lcom/android/mail/browse/ConversationWebView;->screenPxToWebPx(I)I

    move-result v6

    invoke-virtual/range {v1 .. v6}, Lcom/android/mail/ui/HtmlConversationTemplates;->appendMessageHtml(Lcom/android/mail/providers/Message;ZZII)V

    .line 742
    invoke-interface {v15, v12}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 743
    invoke-interface {v15, v10}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 745
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mViewState:Lcom/android/mail/ui/ConversationViewState;

    sget v3, Lcom/android/mail/ui/ConversationViewState$ExpansionState;->COLLAPSED:I

    invoke-virtual {v1, v2, v3}, Lcom/android/mail/ui/ConversationViewState;->setExpansionState(Lcom/android/mail/providers/Message;I)V

    .line 720
    add-int/lit8 v14, v14, 0x1

    goto :goto_0

    .line 748
    .end local v2    # "msg":Lcom/android/mail/browse/MessageCursor$ConversationMessage;
    .end local v7    # "correction":I
    .end local v10    # "footer":Lcom/android/mail/browse/ConversationViewAdapter$MessageFooterItem;
    .end local v11    # "footerPx":I
    .end local v12    # "header":Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;
    .end local v13    # "headerPx":I
    :cond_1
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/android/mail/ui/ConversationViewFragment;->mAdapter:Lcom/android/mail/browse/ConversationViewAdapter;

    move-object/from16 v0, p2

    invoke-virtual {v1, v0, v15}, Lcom/android/mail/browse/ConversationViewAdapter;->replaceSuperCollapsedBlock(Lcom/android/mail/browse/ConversationViewAdapter$SuperCollapsedBlockItem;Ljava/util/Collection;)V

    .line 749
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/android/mail/ui/ConversationViewFragment;->mAdapter:Lcom/android/mail/browse/ConversationViewAdapter;

    invoke-virtual {v1}, Lcom/android/mail/browse/ConversationViewAdapter;->notifyDataSetChanged()V

    .line 751
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/android/mail/ui/ConversationViewFragment;->mTemplates:Lcom/android/mail/ui/HtmlConversationTemplates;

    invoke-virtual {v1}, Lcom/android/mail/ui/HtmlConversationTemplates;->emit()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method private renderConversation(Lcom/android/mail/browse/MessageCursor;)V
    .locals 6
    .param p1, "messageCursor"    # Lcom/android/mail/browse/MessageCursor;

    .prologue
    .line 537
    iget-boolean v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mEnableContentReadySignal:Z

    invoke-direct {p0, p1, v0}, Lcom/android/mail/ui/ConversationViewFragment;->renderMessageBodies(Lcom/android/mail/browse/MessageCursor;Z)Ljava/lang/String;

    move-result-object v2

    .line 559
    .local v2, "convHtml":Ljava/lang/String;
    iget-boolean v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebViewLoadedData:Z

    if-eqz v0, :cond_0

    .line 560
    invoke-direct {p0}, Lcom/android/mail/ui/ConversationViewFragment;->calculateScrollYPercent()F

    move-result v0

    iput v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebViewYPercent:F

    .line 563
    :cond_0
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    iget-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mBaseUri:Ljava/lang/String;

    const-string v3, "text/html"

    const-string v4, "utf-8"

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Lcom/android/mail/browse/ConversationWebView;->loadDataWithBaseURL(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 564
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebViewLoadedData:Z

    .line 565
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebViewLoadStartMs:J

    .line 566
    return-void
.end method

.method private renderMessage(Lcom/android/mail/browse/MessageCursor$ConversationMessage;ZZ)V
    .locals 11
    .param p1, "msg"    # Lcom/android/mail/browse/MessageCursor$ConversationMessage;
    .param p2, "expanded"    # Z
    .param p3, "safeForImages"    # Z

    .prologue
    .line 696
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mAdapter:Lcom/android/mail/browse/ConversationViewAdapter;

    invoke-virtual {v0, p1, p2}, Lcom/android/mail/browse/ConversationViewAdapter;->addMessageHeader(Lcom/android/mail/browse/MessageCursor$ConversationMessage;Z)I

    move-result v9

    .line 697
    .local v9, "headerPos":I
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mAdapter:Lcom/android/mail/browse/ConversationViewAdapter;

    invoke-virtual {v0, v9}, Lcom/android/mail/browse/ConversationViewAdapter;->getItem(I)Lcom/android/mail/browse/ConversationOverlayItem;

    move-result-object v8

    check-cast v8, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    .line 699
    .local v8, "headerItem":Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mAdapter:Lcom/android/mail/browse/ConversationViewAdapter;

    invoke-virtual {v0, v8}, Lcom/android/mail/browse/ConversationViewAdapter;->addMessageFooter(Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;)I

    move-result v6

    .line 704
    .local v6, "footerPos":I
    invoke-direct {p0, v9}, Lcom/android/mail/ui/ConversationViewFragment;->measureOverlayHeight(I)I

    move-result v10

    .line 705
    .local v10, "headerPx":I
    invoke-direct {p0, v6}, Lcom/android/mail/ui/ConversationViewFragment;->measureOverlayHeight(I)I

    move-result v7

    .line 707
    .local v7, "footerPx":I
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mTemplates:Lcom/android/mail/ui/HtmlConversationTemplates;

    iget-object v1, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    invoke-virtual {v1, v10}, Lcom/android/mail/browse/ConversationWebView;->screenPxToWebPx(I)I

    move-result v4

    iget-object v1, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    invoke-virtual {v1, v7}, Lcom/android/mail/browse/ConversationWebView;->screenPxToWebPx(I)I

    move-result v5

    move-object v1, p1

    move v2, p2

    move v3, p3

    invoke-virtual/range {v0 .. v5}, Lcom/android/mail/ui/HtmlConversationTemplates;->appendMessageHtml(Lcom/android/mail/providers/Message;ZZII)V

    .line 709
    return-void
.end method

.method private renderMessageBodies(Lcom/android/mail/browse/MessageCursor;Z)Ljava/lang/String;
    .locals 23
    .param p1, "messageCursor"    # Lcom/android/mail/browse/MessageCursor;
    .param p2, "enableContentReadySignal"    # Z

    .prologue
    .line 575
    const/16 v16, -0x1

    .line 577
    .local v16, "pos":I
    sget-object v3, Lcom/android/mail/ui/ConversationViewFragment;->LOG_TAG:Ljava/lang/String;

    const-string v4, "IN renderMessageBodies, fragment=%s"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object p0, v6, v7

    invoke-static {v3, v4, v6}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 578
    const/4 v10, 0x0

    .line 590
    .local v10, "allowNetworkImages":Z
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/android/mail/ui/ConversationViewFragment;->mConversationContainer:Lcom/android/mail/browse/ConversationContainer;

    invoke-virtual {v3}, Lcom/android/mail/browse/ConversationContainer;->invalidateSpacerGeometry()V

    .line 592
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/android/mail/ui/ConversationViewFragment;->mAdapter:Lcom/android/mail/browse/ConversationViewAdapter;

    invoke-virtual {v3}, Lcom/android/mail/browse/ConversationViewAdapter;->clear()V

    .line 596
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mViewState:Lcom/android/mail/ui/ConversationViewState;

    move-object/from16 v19, v0

    .line 597
    .local v19, "prevState":Lcom/android/mail/ui/ConversationViewState;
    new-instance v3, Lcom/android/mail/ui/ConversationViewState;

    move-object/from16 v0, v19

    invoke-direct {v3, v0}, Lcom/android/mail/ui/ConversationViewState;-><init>(Lcom/android/mail/ui/ConversationViewState;)V

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mViewState:Lcom/android/mail/ui/ConversationViewState;

    .line 603
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/android/mail/ui/ConversationViewFragment;->mAdapter:Lcom/android/mail/browse/ConversationViewAdapter;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mConversation:Lcom/android/mail/providers/Conversation;

    invoke-virtual {v3, v4}, Lcom/android/mail/browse/ConversationViewAdapter;->addConversationHeader(Lcom/android/mail/providers/Conversation;)I

    move-result v12

    .line 604
    .local v12, "convHeaderPos":I
    move-object/from16 v0, p0

    invoke-direct {v0, v12}, Lcom/android/mail/ui/ConversationViewFragment;->measureOverlayHeight(I)I

    move-result v13

    .line 606
    .local v13, "convHeaderPx":I
    invoke-virtual/range {p0 .. p0}, Lcom/android/mail/ui/ConversationViewFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0b002c

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v3

    invoke-virtual/range {p0 .. p0}, Lcom/android/mail/ui/ConversationViewFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v6, 0x7f0b002b

    invoke-virtual {v4, v6}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v4

    add-int v22, v3, v4

    .line 610
    .local v22, "sideMarginPx":I
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/android/mail/ui/ConversationViewFragment;->mTemplates:Lcom/android/mail/ui/HtmlConversationTemplates;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    move/from16 v0, v22

    invoke-virtual {v4, v0}, Lcom/android/mail/browse/ConversationWebView;->screenPxToWebPx(I)I

    move-result v4

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    invoke-virtual {v6, v13}, Lcom/android/mail/browse/ConversationWebView;->screenPxToWebPx(I)I

    move-result v6

    invoke-virtual {v3, v4, v6}, Lcom/android/mail/ui/HtmlConversationTemplates;->startConversation(II)V

    .line 613
    const/4 v11, -0x1

    .line 614
    .local v11, "collapsedStart":I
    const/16 v17, 0x0

    .line 615
    .local v17, "prevCollapsedMsg":Lcom/android/mail/browse/MessageCursor$ConversationMessage;
    const/16 v18, 0x0

    .line 617
    .local v18, "prevSafeForImages":Z
    :goto_0
    add-int/lit8 v16, v16, 0x1

    move-object/from16 v0, p1

    move/from16 v1, v16

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/MessageCursor;->moveToPosition(I)Z

    move-result v3

    if-eqz v3, :cond_9

    .line 618
    invoke-virtual/range {p1 .. p1}, Lcom/android/mail/browse/MessageCursor;->getMessage()Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    move-result-object v15

    .line 621
    .local v15, "msg":Lcom/android/mail/browse/MessageCursor$ConversationMessage;
    iget-boolean v0, v15, Lcom/android/mail/providers/Message;->alwaysShowImages:Z

    move/from16 v20, v0

    .line 622
    .local v20, "safeForImages":Z
    or-int v10, v10, v20

    .line 624
    move-object/from16 v0, v19

    invoke-virtual {v0, v15}, Lcom/android/mail/ui/ConversationViewState;->getExpansionState(Lcom/android/mail/providers/Message;)Ljava/lang/Integer;

    move-result-object v21

    .line 626
    .local v21, "savedExpanded":Ljava/lang/Integer;
    if-eqz v21, :cond_2

    .line 627
    invoke-virtual/range {v21 .. v21}, Ljava/lang/Integer;->intValue()I

    move-result v3

    invoke-static {v3}, Lcom/android/mail/ui/ConversationViewState$ExpansionState;->isSuperCollapsed(I)Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-virtual/range {p1 .. p1}, Lcom/android/mail/browse/MessageCursor;->isLast()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 630
    sget v14, Lcom/android/mail/ui/ConversationViewState$ExpansionState;->EXPANDED:I

    .line 639
    .local v14, "expandedState":I
    :goto_1
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mViewState:Lcom/android/mail/ui/ConversationViewState;

    invoke-virtual {v3, v15, v14}, Lcom/android/mail/ui/ConversationViewState;->setExpansionState(Lcom/android/mail/providers/Message;I)V

    .line 645
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mViewState:Lcom/android/mail/ui/ConversationViewState;

    iget-boolean v3, v15, Lcom/android/mail/providers/Message;->read:Z

    if-eqz v3, :cond_5

    move-object/from16 v0, v19

    invoke-virtual {v0, v15}, Lcom/android/mail/ui/ConversationViewState;->isUnread(Lcom/android/mail/providers/Message;)Z

    move-result v3

    if-nez v3, :cond_5

    const/4 v3, 0x1

    :goto_2
    invoke-virtual {v4, v15, v3}, Lcom/android/mail/ui/ConversationViewState;->setReadState(Lcom/android/mail/providers/Message;Z)V

    .line 652
    invoke-static {v14}, Lcom/android/mail/ui/ConversationViewState$ExpansionState;->isSuperCollapsed(I)Z

    move-result v3

    if-eqz v3, :cond_6

    .line 655
    if-gez v11, :cond_0

    .line 656
    move/from16 v11, v16

    .line 658
    :cond_0
    move-object/from16 v17, v15

    .line 659
    move/from16 v18, v20

    .line 660
    goto :goto_0

    .line 632
    .end local v14    # "expandedState":I
    :cond_1
    invoke-virtual/range {v21 .. v21}, Ljava/lang/Integer;->intValue()I

    move-result v14

    .restart local v14    # "expandedState":I
    goto :goto_1

    .line 636
    .end local v14    # "expandedState":I
    :cond_2
    iget-boolean v3, v15, Lcom/android/mail/providers/Message;->read:Z

    if-eqz v3, :cond_3

    iget-boolean v3, v15, Lcom/android/mail/providers/Message;->starred:Z

    if-nez v3, :cond_3

    invoke-virtual/range {p1 .. p1}, Lcom/android/mail/browse/MessageCursor;->isLast()Z

    move-result v3

    if-eqz v3, :cond_4

    :cond_3
    sget v14, Lcom/android/mail/ui/ConversationViewState$ExpansionState;->EXPANDED:I

    .restart local v14    # "expandedState":I
    :goto_3
    goto :goto_1

    .end local v14    # "expandedState":I
    :cond_4
    sget v14, Lcom/android/mail/ui/ConversationViewState$ExpansionState;->SUPER_COLLAPSED:I

    goto :goto_3

    .line 645
    .restart local v14    # "expandedState":I
    :cond_5
    const/4 v3, 0x0

    goto :goto_2

    .line 664
    :cond_6
    if-ltz v11, :cond_7

    .line 665
    sub-int v3, v16, v11

    const/4 v4, 0x1

    if-ne v3, v4, :cond_8

    .line 667
    const/4 v3, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    move/from16 v2, v18

    invoke-direct {v0, v1, v3, v2}, Lcom/android/mail/ui/ConversationViewFragment;->renderMessage(Lcom/android/mail/browse/MessageCursor$ConversationMessage;ZZ)V

    .line 672
    :goto_4
    const/16 v17, 0x0

    .line 673
    const/4 v11, -0x1

    .line 676
    :cond_7
    invoke-static {v14}, Lcom/android/mail/ui/ConversationViewState$ExpansionState;->isExpanded(I)Z

    move-result v3

    move-object/from16 v0, p0

    move/from16 v1, v20

    invoke-direct {v0, v15, v3, v1}, Lcom/android/mail/ui/ConversationViewFragment;->renderMessage(Lcom/android/mail/browse/MessageCursor$ConversationMessage;ZZ)V

    goto/16 :goto_0

    .line 670
    :cond_8
    add-int/lit8 v3, v16, -0x1

    move-object/from16 v0, p0

    invoke-direct {v0, v11, v3}, Lcom/android/mail/ui/ConversationViewFragment;->renderSuperCollapsedBlock(II)V

    goto :goto_4

    .line 679
    .end local v14    # "expandedState":I
    .end local v15    # "msg":Lcom/android/mail/browse/MessageCursor$ConversationMessage;
    .end local v20    # "safeForImages":Z
    .end local v21    # "savedExpanded":Ljava/lang/Integer;
    :cond_9
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    invoke-virtual {v3}, Lcom/android/mail/browse/ConversationWebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v4

    if-nez v10, :cond_a

    const/4 v3, 0x1

    :goto_5
    invoke-virtual {v4, v3}, Landroid/webkit/WebSettings;->setBlockNetworkImage(Z)V

    .line 682
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mConversation:Lcom/android/mail/providers/Conversation;

    iget-object v3, v3, Lcom/android/mail/providers/Conversation;->conversationBaseUri:Landroid/net/Uri;

    if-eqz v3, :cond_b

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mConversation:Lcom/android/mail/providers/Conversation;

    iget-object v3, v3, Lcom/android/mail/providers/Conversation;->conversationBaseUri:Landroid/net/Uri;

    invoke-virtual {v3}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v5

    .line 684
    .local v5, "conversationBaseUri":Ljava/lang/String;
    :goto_6
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/android/mail/ui/ConversationViewFragment;->mTemplates:Lcom/android/mail/ui/HtmlConversationTemplates;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mBaseUri:Ljava/lang/String;

    const/16 v6, 0x140

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    invoke-virtual {v7}, Lcom/android/mail/browse/ConversationWebView;->getViewportWidth()I

    move-result v7

    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mAccount:Lcom/android/mail/providers/Account;

    invoke-static {v8}, Lcom/android/mail/ui/ConversationViewFragment;->isOverviewMode(Lcom/android/mail/providers/Account;)Z

    move-result v9

    move/from16 v8, p2

    invoke-virtual/range {v3 .. v9}, Lcom/android/mail/ui/HtmlConversationTemplates;->endConversation(Ljava/lang/String;Ljava/lang/String;IIZZ)Ljava/lang/String;

    move-result-object v3

    return-object v3

    .line 679
    .end local v5    # "conversationBaseUri":Ljava/lang/String;
    :cond_a
    const/4 v3, 0x0

    goto :goto_5

    .line 682
    :cond_b
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mBaseUri:Ljava/lang/String;

    goto :goto_6
.end method

.method private renderSuperCollapsedBlock(II)V
    .locals 4
    .param p1, "start"    # I
    .param p2, "end"    # I

    .prologue
    .line 689
    iget-object v2, p0, Lcom/android/mail/ui/ConversationViewFragment;->mAdapter:Lcom/android/mail/browse/ConversationViewAdapter;

    invoke-virtual {v2, p1, p2}, Lcom/android/mail/browse/ConversationViewAdapter;->addSuperCollapsedBlock(II)I

    move-result v0

    .line 690
    .local v0, "blockPos":I
    invoke-direct {p0, v0}, Lcom/android/mail/ui/ConversationViewFragment;->measureOverlayHeight(I)I

    move-result v1

    .line 691
    .local v1, "blockPx":I
    iget-object v2, p0, Lcom/android/mail/ui/ConversationViewFragment;->mTemplates:Lcom/android/mail/ui/HtmlConversationTemplates;

    iget-object v3, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    invoke-virtual {v3, v1}, Lcom/android/mail/browse/ConversationWebView;->screenPxToWebPx(I)I

    move-result v3

    invoke-virtual {v2, p1, v3}, Lcom/android/mail/ui/HtmlConversationTemplates;->appendSuperCollapsedHtml(II)V

    .line 692
    return-void
.end method

.method private resetLoadWaiting()V
    .locals 2

    .prologue
    .line 424
    iget v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mLoadWaitReason:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 425
    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationViewFragment;->getListController()Lcom/android/mail/ui/ConversationUpdater;

    move-result-object v0

    iget-object v1, p0, Lcom/android/mail/ui/ConversationViewFragment;->mLoadedObserver:Landroid/database/DataSetObserver;

    invoke-interface {v0, v1}, Lcom/android/mail/ui/ConversationUpdater;->unregisterConversationLoadedObserver(Landroid/database/DataSetObserver;)V

    .line 427
    :cond_0
    const/4 v0, 0x0

    iput v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mLoadWaitReason:I

    .line 428
    return-void
.end method

.method private revealConversation()V
    .locals 1

    .prologue
    .line 529
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mOnProgressDismiss:Ljava/lang/Runnable;

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/ConversationViewFragment;->dismissLoadingStatus(Ljava/lang/Runnable;)V

    .line 530
    return-void
.end method

.method private setupOverviewMode()V
    .locals 3

    .prologue
    .line 908
    iget-object v2, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mAccount:Lcom/android/mail/providers/Account;

    invoke-static {v2}, Lcom/android/mail/ui/ConversationViewFragment;->isOverviewMode(Lcom/android/mail/providers/Account;)Z

    move-result v0

    .line 909
    .local v0, "overviewMode":Z
    iget-object v2, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    invoke-virtual {v2}, Lcom/android/mail/browse/ConversationWebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v1

    .line 910
    .local v1, "settings":Landroid/webkit/WebSettings;
    invoke-virtual {v1, v0}, Landroid/webkit/WebSettings;->setUseWideViewPort(Z)V

    .line 911
    invoke-virtual {v1, v0}, Landroid/webkit/WebSettings;->setSupportZoom(Z)V

    .line 912
    if-eqz v0, :cond_0

    .line 913
    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/webkit/WebSettings;->setBuiltInZoomControls(Z)V

    .line 914
    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/webkit/WebSettings;->setDisplayZoomControls(Z)V

    .line 916
    :cond_0
    return-void
.end method

.method private showConversation()V
    .locals 6

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 476
    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationViewFragment;->isUserVisible()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 477
    sget-object v4, Lcom/android/mail/ui/ConversationViewFragment;->LOG_TAG:Ljava/lang/String;

    const-string v5, "SHOWCONV: CVF is user-visible, immediately loading conversation (%s)"

    new-array v3, v3, [Ljava/lang/Object;

    aput-object p0, v3, v2

    invoke-static {v4, v5, v3}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 479
    const/4 v1, 0x0

    .line 502
    .local v1, "reason":I
    :goto_0
    iput v1, p0, Lcom/android/mail/ui/ConversationViewFragment;->mLoadWaitReason:I

    .line 503
    iget v2, p0, Lcom/android/mail/ui/ConversationViewFragment;->mLoadWaitReason:I

    if-nez v2, :cond_0

    .line 504
    invoke-direct {p0}, Lcom/android/mail/ui/ConversationViewFragment;->startConversationLoad()V

    .line 506
    :cond_0
    return-void

    .line 481
    .end local v1    # "reason":I
    :cond_1
    iget-object v4, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mConversation:Lcom/android/mail/providers/Conversation;

    iget-boolean v4, v4, Lcom/android/mail/providers/Conversation;->isRemote:Z

    if-nez v4, :cond_2

    iget-object v4, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mConversation:Lcom/android/mail/providers/Conversation;

    invoke-virtual {v4}, Lcom/android/mail/providers/Conversation;->getNumMessages()I

    move-result v4

    iget v5, p0, Lcom/android/mail/ui/ConversationViewFragment;->mMaxAutoLoadMessages:I

    if-le v4, v5, :cond_3

    :cond_2
    move v0, v3

    .line 487
    .local v0, "disableOffscreenLoading":Z
    :goto_1
    if-eqz v0, :cond_4

    .line 488
    const/4 v1, 0x2

    .line 489
    .restart local v1    # "reason":I
    sget-object v4, Lcom/android/mail/ui/ConversationViewFragment;->LOG_TAG:Ljava/lang/String;

    const-string v5, "SHOWCONV: CVF waiting until visible to load (%s)"

    new-array v3, v3, [Ljava/lang/Object;

    aput-object p0, v3, v2

    invoke-static {v4, v5, v3}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0

    .end local v0    # "disableOffscreenLoading":Z
    .end local v1    # "reason":I
    :cond_3
    move v0, v2

    .line 481
    goto :goto_1

    .line 490
    .restart local v0    # "disableOffscreenLoading":Z
    :cond_4
    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationViewFragment;->getListController()Lcom/android/mail/ui/ConversationUpdater;

    move-result-object v4

    invoke-interface {v4}, Lcom/android/mail/ui/ConversationUpdater;->isInitialConversationLoading()Z

    move-result v4

    if-eqz v4, :cond_5

    .line 491
    const/4 v1, 0x1

    .line 492
    .restart local v1    # "reason":I
    sget-object v4, Lcom/android/mail/ui/ConversationViewFragment;->LOG_TAG:Ljava/lang/String;

    const-string v5, "SHOWCONV: CVF waiting for initial to finish (%s)"

    new-array v3, v3, [Ljava/lang/Object;

    aput-object p0, v3, v2

    invoke-static {v4, v5, v3}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 493
    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationViewFragment;->getListController()Lcom/android/mail/ui/ConversationUpdater;

    move-result-object v2

    iget-object v3, p0, Lcom/android/mail/ui/ConversationViewFragment;->mLoadedObserver:Landroid/database/DataSetObserver;

    invoke-interface {v2, v3}, Lcom/android/mail/ui/ConversationUpdater;->registerConversationLoadedObserver(Landroid/database/DataSetObserver;)V

    goto :goto_0

    .line 495
    .end local v1    # "reason":I
    :cond_5
    sget-object v4, Lcom/android/mail/ui/ConversationViewFragment;->LOG_TAG:Ljava/lang/String;

    const-string v5, "SHOWCONV: CVF is not visible, but no reason to wait. loading now. (%s)"

    new-array v3, v3, [Ljava/lang/Object;

    aput-object p0, v3, v2

    invoke-static {v4, v5, v3}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 498
    const/4 v1, 0x0

    .restart local v1    # "reason":I
    goto :goto_0
.end method

.method private showNewMessageNotification(Lcom/android/mail/ui/ConversationViewFragment$NewMessagesInfo;)V
    .locals 2

    .prologue
    .line 843
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mNewMessageBar:Landroid/view/View;

    const v1, 0x7f1000ce

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 845
    invoke-virtual {p1}, Lcom/android/mail/ui/ConversationViewFragment$NewMessagesInfo;->getNotificationText()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 846
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mNewMessageBar:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 847
    return-void
.end method

.method private startConversationLoad()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 514
    iget-object v1, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    invoke-virtual {v1, v4}, Lcom/android/mail/browse/ConversationWebView;->setVisibility(I)V

    .line 515
    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationViewFragment;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v1

    sget-object v2, Landroid/os/Bundle;->EMPTY:Landroid/os/Bundle;

    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationViewFragment;->getMessageLoaderCallbacks()Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoaderCallbacks;

    move-result-object v3

    invoke-virtual {v1, v4, v2, v3}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    .line 516
    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationViewFragment;->isUserVisible()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 517
    iget-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->getSubjectDisplayChanger()Lcom/android/mail/ui/SubjectDisplayChanger;

    move-result-object v0

    .line 518
    .local v0, "sdc":Lcom/android/mail/ui/SubjectDisplayChanger;
    if-eqz v0, :cond_0

    .line 519
    iget-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mConversation:Lcom/android/mail/providers/Conversation;

    iget-object v1, v1, Lcom/android/mail/providers/Conversation;->subject:Ljava/lang/String;

    invoke-interface {v0, v1}, Lcom/android/mail/ui/SubjectDisplayChanger;->setSubject(Ljava/lang/String;)V

    .line 525
    .end local v0    # "sdc":Lcom/android/mail/ui/SubjectDisplayChanger;
    :cond_0
    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationViewFragment;->showLoadingStatus()V

    .line 526
    return-void
.end method


# virtual methods
.method protected markUnread()V
    .locals 7

    .prologue
    const/4 v3, 0x1

    const/4 v6, 0x0

    .line 433
    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationViewFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/android/mail/ui/ControllableActivity;

    .line 434
    .local v0, "activity":Lcom/android/mail/ui/ControllableActivity;
    if-nez v0, :cond_0

    .line 435
    sget-object v1, Lcom/android/mail/ui/ConversationViewFragment;->LOG_TAG:Ljava/lang/String;

    const-string v2, "ignoring markUnread for conv=%s"

    new-array v3, v3, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mConversation:Lcom/android/mail/providers/Conversation;

    iget-wide v4, v4, Lcom/android/mail/providers/Conversation;->id:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-static {v1, v2, v3}, Lcom/android/mail/utils/LogUtils;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 446
    :goto_0
    return-void

    .line 439
    :cond_0
    iget-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mViewState:Lcom/android/mail/ui/ConversationViewState;

    if-nez v1, :cond_1

    .line 440
    sget-object v1, Lcom/android/mail/ui/ConversationViewFragment;->LOG_TAG:Ljava/lang/String;

    const-string v2, "ignoring markUnread for conv with no view state (%d)"

    new-array v3, v3, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mConversation:Lcom/android/mail/providers/Conversation;

    iget-wide v4, v4, Lcom/android/mail/providers/Conversation;->id:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-static {v1, v2, v3}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0

    .line 444
    :cond_1
    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getConversationUpdater()Lcom/android/mail/ui/ConversationUpdater;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mConversation:Lcom/android/mail/providers/Conversation;

    iget-object v3, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mViewState:Lcom/android/mail/ui/ConversationViewState;

    invoke-virtual {v3}, Lcom/android/mail/ui/ConversationViewState;->getUnreadMessageUris()Ljava/util/Set;

    move-result-object v3

    iget-object v4, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mViewState:Lcom/android/mail/ui/ConversationViewState;

    invoke-virtual {v4}, Lcom/android/mail/ui/ConversationViewState;->getConversationInfo()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v2, v3, v4}, Lcom/android/mail/ui/ConversationUpdater;->markConversationMessagesUnread(Lcom/android/mail/providers/Conversation;Ljava/util/Set;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onAccountChanged(Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Account;)V
    .locals 3
    .param p1, "newAccount"    # Lcom/android/mail/providers/Account;
    .param p2, "oldAccount"    # Lcom/android/mail/providers/Account;

    .prologue
    .line 226
    invoke-static {p1}, Lcom/android/mail/ui/ConversationViewFragment;->isOverviewMode(Lcom/android/mail/providers/Account;)Z

    move-result v1

    invoke-static {p2}, Lcom/android/mail/ui/ConversationViewFragment;->isOverviewMode(Lcom/android/mail/providers/Account;)Z

    move-result v2

    if-eq v1, v2, :cond_1

    .line 227
    invoke-direct {p0}, Lcom/android/mail/ui/ConversationViewFragment;->setupOverviewMode()V

    .line 228
    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationViewFragment;->getMessageCursor()Lcom/android/mail/browse/MessageCursor;

    move-result-object v0

    .line 229
    .local v0, "c":Lcom/android/mail/browse/MessageCursor;
    if-eqz v0, :cond_0

    .line 230
    invoke-direct {p0, v0}, Lcom/android/mail/ui/ConversationViewFragment;->renderConversation(Lcom/android/mail/browse/MessageCursor;)V

    .line 242
    .end local v0    # "c":Lcom/android/mail/browse/MessageCursor;
    :cond_0
    :goto_0
    return-void

    .line 241
    :cond_1
    iget-object v1, p0, Lcom/android/mail/ui/ConversationViewFragment;->mAdapter:Lcom/android/mail/browse/ConversationViewAdapter;

    invoke-virtual {v1}, Lcom/android/mail/browse/ConversationViewAdapter;->notifyDataSetChanged()V

    goto :goto_0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 13
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v12, 0x0

    .line 246
    sget-object v0, Lcom/android/mail/ui/ConversationViewFragment;->LOG_TAG:Ljava/lang/String;

    const-string v1, "IN CVF.onActivityCreated, this=%s visible=%s"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    aput-object p0, v2, v12

    const/4 v3, 0x1

    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationViewFragment;->isUserVisible()Z

    move-result v4

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 247
    invoke-super {p0, p1}, Lcom/android/mail/ui/AbstractConversationViewFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 249
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->isFinishing()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 300
    :cond_0
    :goto_0
    return-void

    .line 254
    :cond_1
    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationViewFragment;->getContext()Landroid/content/Context;

    move-result-object v10

    .line 255
    .local v10, "context":Landroid/content/Context;
    new-instance v0, Lcom/android/mail/ui/HtmlConversationTemplates;

    invoke-direct {v0, v10}, Lcom/android/mail/ui/HtmlConversationTemplates;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mTemplates:Lcom/android/mail/ui/HtmlConversationTemplates;

    .line 257
    new-instance v9, Lcom/android/mail/FormattedDateBuilder;

    invoke-direct {v9, v10}, Lcom/android/mail/FormattedDateBuilder;-><init>(Landroid/content/Context;)V

    .line 259
    .local v9, "dateBuilder":Lcom/android/mail/FormattedDateBuilder;
    new-instance v0, Lcom/android/mail/browse/ConversationViewAdapter;

    iget-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationViewFragment;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v3

    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationViewFragment;->getContactInfoSource()Lcom/android/mail/ui/AbstractConversationViewFragment$ContactLoaderCallbacks;

    move-result-object v5

    iget-object v8, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mAddressCache:Ljava/util/Map;

    move-object v2, p0

    move-object v4, p0

    move-object v6, p0

    move-object v7, p0

    invoke-direct/range {v0 .. v9}, Lcom/android/mail/browse/ConversationViewAdapter;-><init>(Lcom/android/mail/ui/ControllableActivity;Lcom/android/mail/browse/ConversationViewAdapter$ConversationAccountController;Landroid/app/LoaderManager;Lcom/android/mail/browse/MessageHeaderView$MessageHeaderViewCallbacks;Lcom/android/mail/ContactInfoSource;Lcom/android/mail/browse/ConversationViewHeader$ConversationViewHeaderCallbacks;Lcom/android/mail/browse/SuperCollapsedBlock$OnClickListener;Ljava/util/Map;Lcom/android/mail/FormattedDateBuilder;)V

    iput-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mAdapter:Lcom/android/mail/browse/ConversationViewAdapter;

    .line 262
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mConversationContainer:Lcom/android/mail/browse/ConversationContainer;

    iget-object v1, p0, Lcom/android/mail/ui/ConversationViewFragment;->mAdapter:Lcom/android/mail/browse/ConversationViewAdapter;

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/ConversationContainer;->setOverlayAdapter(Lcom/android/mail/browse/ConversationViewAdapter;)V

    .line 265
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mConversationContainer:Lcom/android/mail/browse/ConversationContainer;

    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationContainer;->getSnapHeader()Lcom/android/mail/browse/MessageHeaderView;

    move-result-object v11

    .line 266
    .local v11, "snapHeader":Lcom/android/mail/browse/MessageHeaderView;
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mAddressCache:Ljava/util/Map;

    invoke-virtual {v11, v9, p0, v0}, Lcom/android/mail/browse/MessageHeaderView;->initialize(Lcom/android/mail/FormattedDateBuilder;Lcom/android/mail/browse/ConversationViewAdapter$ConversationAccountController;Ljava/util/Map;)V

    .line 267
    invoke-virtual {v11, p0}, Lcom/android/mail/browse/MessageHeaderView;->setCallbacks(Lcom/android/mail/browse/MessageHeaderView$MessageHeaderViewCallbacks;)V

    .line 268
    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationViewFragment;->getContactInfoSource()Lcom/android/mail/ui/AbstractConversationViewFragment$ContactLoaderCallbacks;

    move-result-object v0

    invoke-virtual {v11, v0}, Lcom/android/mail/browse/MessageHeaderView;->setContactInfoSource(Lcom/android/mail/ContactInfoSource;)V

    .line 270
    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationViewFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0a0016

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v0

    iput v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mMaxAutoLoadMessages:I

    .line 272
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    new-instance v1, Lcom/android/mail/browse/WebViewContextMenu;

    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationViewFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/android/mail/browse/WebViewContextMenu;-><init>(Landroid/app/Activity;)V

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/ConversationWebView;->setOnCreateContextMenuListener(Landroid/view/View$OnCreateContextMenuListener;)V

    .line 275
    invoke-direct {p0}, Lcom/android/mail/ui/ConversationViewFragment;->setupOverviewMode()V

    .line 287
    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationViewFragment;->getHandler()Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/android/mail/ui/ConversationViewFragment$3;

    const-string v2, "showConversation"

    invoke-direct {v1, p0, v2}, Lcom/android/mail/ui/ConversationViewFragment$3;-><init>(Lcom/android/mail/ui/ConversationViewFragment;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 294
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mConversation:Lcom/android/mail/providers/Conversation;

    iget-object v0, v0, Lcom/android/mail/providers/Conversation;->conversationBaseUri:Landroid/net/Uri;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v0, v0, Lcom/android/mail/providers/Account;->accoutCookieQueryUri:Landroid/net/Uri;

    invoke-static {v0}, Lcom/android/mail/utils/Utils;->isEmpty(Landroid/net/Uri;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 297
    new-instance v0, Lcom/android/mail/ui/ConversationViewFragment$SetCookieTask;

    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationViewFragment;->getContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mConversation:Lcom/android/mail/providers/Conversation;

    iget-object v2, v2, Lcom/android/mail/providers/Conversation;->conversationBaseUri:Landroid/net/Uri;

    iget-object v3, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v3, v3, Lcom/android/mail/providers/Account;->accoutCookieQueryUri:Landroid/net/Uri;

    invoke-direct {v0, p0, v1, v2, v3}, Lcom/android/mail/ui/ConversationViewFragment$SetCookieTask;-><init>(Lcom/android/mail/ui/ConversationViewFragment;Landroid/content/Context;Landroid/net/Uri;Landroid/net/Uri;)V

    new-array v1, v12, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/android/mail/ui/ConversationViewFragment$SetCookieTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0
.end method

.method public onConversationUpdated(Lcom/android/mail/providers/Conversation;)V
    .locals 2

    .prologue
    .line 1305
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mConversationContainer:Lcom/android/mail/browse/ConversationContainer;

    const v1, 0x7f1000b1

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/ConversationContainer;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/android/mail/browse/ConversationViewHeader;

    .line 1307
    iput-object p1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mConversation:Lcom/android/mail/providers/Conversation;

    .line 1308
    if-eqz v0, :cond_0

    .line 1309
    invoke-virtual {v0, p1}, Lcom/android/mail/browse/ConversationViewHeader;->onConversationUpdated(Lcom/android/mail/providers/Conversation;)V

    .line 1311
    :cond_0
    return-void
.end method

.method public onConversationViewHeaderHeightChange(I)V
    .locals 6
    .param p1, "newHeight"    # I

    .prologue
    .line 789
    iget-object v1, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    invoke-virtual {v1, p1}, Lcom/android/mail/browse/ConversationWebView;->screenPxToWebPx(I)I

    move-result v0

    .line 791
    .local v0, "h":I
    iget-object v1, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    const-string v2, "javascript:setConversationHeaderSpacerHeight(%s);"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/android/mail/browse/ConversationWebView;->loadUrl(Ljava/lang/String;)V

    .line 792
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedState"    # Landroid/os/Bundle;

    .prologue
    .line 304
    invoke-super {p0, p1}, Lcom/android/mail/ui/AbstractConversationViewFragment;->onCreate(Landroid/os/Bundle;)V

    .line 306
    if-eqz p1, :cond_0

    .line 307
    sget-object v0, Lcom/android/mail/ui/ConversationViewFragment;->BUNDLE_KEY_WEBVIEW_Y_PERCENT:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getFloat(Ljava/lang/String;)F

    move-result v0

    iput v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebViewYPercent:F

    .line 309
    :cond_0
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 11
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v7, 0x1

    const/4 v8, 0x0

    .line 315
    const v6, 0x7f040033

    invoke-virtual {p1, v6, p2, v8}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    .line 316
    .local v2, "rootView":Landroid/view/View;
    const v6, 0x7f1000ac

    invoke-virtual {v2, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Lcom/android/mail/browse/ConversationContainer;

    iput-object v6, p0, Lcom/android/mail/ui/ConversationViewFragment;->mConversationContainer:Lcom/android/mail/browse/ConversationContainer;

    .line 319
    iget-object v6, p0, Lcom/android/mail/ui/ConversationViewFragment;->mConversationContainer:Lcom/android/mail/browse/ConversationContainer;

    const v9, 0x7f1000cd

    invoke-virtual {v6, v9}, Lcom/android/mail/browse/ConversationContainer;->findViewById(I)Landroid/view/View;

    move-result-object v6

    iput-object v6, p0, Lcom/android/mail/ui/ConversationViewFragment;->mNewMessageBar:Landroid/view/View;

    .line 320
    iget-object v6, p0, Lcom/android/mail/ui/ConversationViewFragment;->mNewMessageBar:Landroid/view/View;

    new-instance v9, Lcom/android/mail/ui/ConversationViewFragment$4;

    invoke-direct {v9, p0}, Lcom/android/mail/ui/ConversationViewFragment$4;-><init>(Lcom/android/mail/ui/ConversationViewFragment;)V

    invoke-virtual {v6, v9}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 327
    invoke-virtual {p0, v2}, Lcom/android/mail/ui/ConversationViewFragment;->instantiateProgressIndicators(Landroid/view/View;)V

    .line 329
    iget-object v6, p0, Lcom/android/mail/ui/ConversationViewFragment;->mConversationContainer:Lcom/android/mail/browse/ConversationContainer;

    const v9, 0x7f1000ad

    invoke-virtual {v6, v9}, Lcom/android/mail/browse/ConversationContainer;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Lcom/android/mail/browse/ConversationWebView;

    iput-object v6, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    .line 331
    iget-object v6, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    iget-object v9, p0, Lcom/android/mail/ui/ConversationViewFragment;->mJsBridge:Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;

    const-string v10, "mail"

    invoke-virtual {v6, v9, v10}, Lcom/android/mail/browse/ConversationWebView;->addJavascriptInterface(Ljava/lang/Object;Ljava/lang/String;)V

    .line 342
    invoke-static {}, Lcom/android/mail/utils/Utils;->isRunningJellybeanOrLater()Z

    move-result v6

    iput-boolean v6, p0, Lcom/android/mail/ui/ConversationViewFragment;->mEnableContentReadySignal:Z

    .line 343
    iget-object v9, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    iget-boolean v6, p0, Lcom/android/mail/ui/ConversationViewFragment;->mEnableContentReadySignal:Z

    if-nez v6, :cond_0

    move v6, v7

    :goto_0
    invoke-virtual {v9, v6}, Lcom/android/mail/browse/ConversationWebView;->setUseSoftwareLayer(Z)V

    .line 344
    iget-object v6, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationViewFragment;->isUserVisible()Z

    move-result v9

    invoke-virtual {v6, v9}, Lcom/android/mail/browse/ConversationWebView;->onUserVisibilityChanged(Z)V

    .line 345
    iget-object v6, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    iget-object v9, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebViewClient:Landroid/webkit/WebViewClient;

    invoke-virtual {v6, v9}, Lcom/android/mail/browse/ConversationWebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 346
    iget-object v6, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    new-instance v9, Lcom/android/mail/ui/ConversationViewFragment$5;

    invoke-direct {v9, p0}, Lcom/android/mail/ui/ConversationViewFragment$5;-><init>(Lcom/android/mail/ui/ConversationViewFragment;)V

    invoke-virtual {v6, v9}, Lcom/android/mail/browse/ConversationWebView;->setWebChromeClient(Landroid/webkit/WebChromeClient;)V

    .line 355
    iget-object v6, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    invoke-virtual {v6}, Lcom/android/mail/browse/ConversationWebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v3

    .line 357
    .local v3, "settings":Landroid/webkit/WebSettings;
    const v6, 0x7f1000b0

    invoke-virtual {v2, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Lcom/android/mail/browse/ScrollIndicatorsView;

    iput-object v6, p0, Lcom/android/mail/ui/ConversationViewFragment;->mScrollIndicators:Lcom/android/mail/browse/ScrollIndicatorsView;

    .line 358
    iget-object v6, p0, Lcom/android/mail/ui/ConversationViewFragment;->mScrollIndicators:Lcom/android/mail/browse/ScrollIndicatorsView;

    iget-object v9, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    invoke-virtual {v6, v9}, Lcom/android/mail/browse/ScrollIndicatorsView;->setSourceView(Lcom/android/mail/browse/ScrollNotifier;)V

    .line 360
    invoke-virtual {v3, v7}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    .line 362
    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationViewFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-virtual {v6}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v6

    iget v1, v6, Landroid/content/res/Configuration;->fontScale:F

    .line 363
    .local v1, "fontScale":F
    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationViewFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const v9, 0x7f0a0023

    invoke-virtual {v6, v9}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v0

    .line 365
    .local v0, "desiredFontSizePx":I
    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationViewFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const v9, 0x7f0a0024

    invoke-virtual {v6, v9}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v5

    .line 368
    .local v5, "unstyledFontSizePx":I
    invoke-virtual {v3}, Landroid/webkit/WebSettings;->getTextZoom()I

    move-result v4

    .line 370
    .local v4, "textZoom":I
    mul-int v6, v4, v0

    div-int v4, v6, v5

    .line 372
    int-to-float v6, v4

    mul-float/2addr v6, v1

    float-to-int v4, v6

    .line 373
    invoke-virtual {v3, v4}, Landroid/webkit/WebSettings;->setTextZoom(I)V

    .line 375
    iput-boolean v7, p0, Lcom/android/mail/ui/ConversationViewFragment;->mViewsCreated:Z

    .line 376
    iput-boolean v8, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebViewLoadedData:Z

    .line 378
    return-object v2

    .end local v0    # "desiredFontSizePx":I
    .end local v1    # "fontScale":F
    .end local v3    # "settings":Landroid/webkit/WebSettings;
    .end local v4    # "textZoom":I
    .end local v5    # "unstyledFontSizePx":I
    :cond_0
    move v6, v8

    .line 343
    goto :goto_0
.end method

.method public onDestroyView()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 391
    invoke-super {p0}, Lcom/android/mail/ui/AbstractConversationViewFragment;->onDestroyView()V

    .line 392
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mConversationContainer:Lcom/android/mail/browse/ConversationContainer;

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/ConversationContainer;->setOverlayAdapter(Lcom/android/mail/browse/ConversationViewAdapter;)V

    .line 393
    iput-object v1, p0, Lcom/android/mail/ui/ConversationViewFragment;->mAdapter:Lcom/android/mail/browse/ConversationViewAdapter;

    .line 394
    invoke-direct {p0}, Lcom/android/mail/ui/ConversationViewFragment;->resetLoadWaiting()V

    .line 395
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mViewsCreated:Z

    .line 396
    return-void
.end method

.method public onLayoutChange(Landroid/view/View;IIIIIIII)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;
    .param p2, "left"    # I
    .param p3, "top"    # I
    .param p4, "right"    # I
    .param p5, "bottom"    # I
    .param p6, "oldLeft"    # I
    .param p7, "oldTop"    # I
    .param p8, "oldRight"    # I
    .param p9, "oldBottom"    # I

    .prologue
    const/4 v1, 0x0

    .line 1316
    iget-boolean v2, p0, Lcom/android/mail/ui/ConversationViewFragment;->mNeedRender:Z

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/android/mail/ui/ConversationViewFragment;->mConversationContainer:Lcom/android/mail/browse/ConversationContainer;

    invoke-virtual {v2}, Lcom/android/mail/browse/ConversationContainer;->getWidth()I

    move-result v2

    if-eqz v2, :cond_1

    const/4 v0, 0x1

    .line 1318
    .local v0, "sizeChanged":Z
    :goto_0
    if-eqz v0, :cond_0

    .line 1319
    iput-boolean v1, p0, Lcom/android/mail/ui/ConversationViewFragment;->mNeedRender:Z

    .line 1320
    iget-object v1, p0, Lcom/android/mail/ui/ConversationViewFragment;->mConversationContainer:Lcom/android/mail/browse/ConversationContainer;

    invoke-virtual {v1, p0}, Lcom/android/mail/browse/ConversationContainer;->removeOnLayoutChangeListener(Landroid/view/View$OnLayoutChangeListener;)V

    .line 1321
    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationViewFragment;->getMessageCursor()Lcom/android/mail/browse/MessageCursor;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/android/mail/ui/ConversationViewFragment;->renderConversation(Lcom/android/mail/browse/MessageCursor;)V

    .line 1323
    :cond_0
    return-void

    .end local v0    # "sizeChanged":Z
    :cond_1
    move v0, v1

    .line 1316
    goto :goto_0
.end method

.method public onMessageCursorLoadFinished(Landroid/content/Loader;Lcom/android/mail/browse/MessageCursor;Lcom/android/mail/browse/MessageCursor;)V
    .locals 5
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

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 1106
    if-eqz p3, :cond_6

    invoke-virtual {p3}, Lcom/android/mail/browse/MessageCursor;->isClosed()Z

    move-result v0

    if-nez v0, :cond_6

    .line 1107
    invoke-direct {p0, p2}, Lcom/android/mail/ui/ConversationViewFragment;->getNewIncomingMessagesInfo(Lcom/android/mail/browse/MessageCursor;)Lcom/android/mail/ui/ConversationViewFragment$NewMessagesInfo;

    move-result-object v3

    .line 1109
    iget v0, v3, Lcom/android/mail/ui/ConversationViewFragment$NewMessagesInfo;->count:I

    if-lez v0, :cond_0

    .line 1113
    sget-object v0, Lcom/android/mail/ui/ConversationViewFragment;->LOG_TAG:Ljava/lang/String;

    const-string v4, "CONV RENDER: conversation updated, holding cursor for new incoming message (%s)"

    new-array v1, v1, [Ljava/lang/Object;

    aput-object p0, v1, v2

    invoke-static {v0, v4, v1}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1115
    invoke-direct {p0, v3}, Lcom/android/mail/ui/ConversationViewFragment;->showNewMessageNotification(Lcom/android/mail/ui/ConversationViewFragment$NewMessagesInfo;)V

    .line 1165
    :goto_0
    return-void

    .line 1119
    :cond_0
    invoke-virtual {p3}, Lcom/android/mail/browse/MessageCursor;->getStateHashCode()I

    move-result v4

    .line 1120
    invoke-virtual {p2}, Lcom/android/mail/browse/MessageCursor;->getStateHashCode()I

    move-result v0

    if-eq v0, v4, :cond_1

    move v0, v1

    .line 1122
    :goto_1
    if-nez v0, :cond_3

    .line 1123
    invoke-direct {p0, p2, p3}, Lcom/android/mail/ui/ConversationViewFragment;->processInPlaceUpdates(Lcom/android/mail/browse/MessageCursor;Lcom/android/mail/browse/MessageCursor;)Z

    move-result v0

    .line 1124
    if-eqz v0, :cond_2

    .line 1125
    sget-object v0, Lcom/android/mail/ui/ConversationViewFragment;->LOG_TAG:Ljava/lang/String;

    const-string v3, "CONV RENDER: processed update(s) in place (%s)"

    new-array v1, v1, [Ljava/lang/Object;

    aput-object p0, v1, v2

    invoke-static {v0, v3, v1}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0

    :cond_1
    move v0, v2

    .line 1120
    goto :goto_1

    .line 1127
    :cond_2
    sget-object v0, Lcom/android/mail/ui/ConversationViewFragment;->LOG_TAG:Ljava/lang/String;

    const-string v3, "CONV RENDER: uninteresting update, ignoring this conversation update (%s)"

    new-array v1, v1, [Ljava/lang/Object;

    aput-object p0, v1, v2

    invoke-static {v0, v3, v1}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0

    .line 1131
    :cond_3
    iget v0, v3, Lcom/android/mail/ui/ConversationViewFragment$NewMessagesInfo;->countFromSelf:I

    if-ne v0, v1, :cond_5

    .line 1134
    invoke-virtual {p2, v1}, Lcom/android/mail/browse/MessageCursor;->getStateHashCode(I)I

    move-result v0

    if-ne v0, v4, :cond_4

    move v0, v1

    .line 1135
    :goto_2
    if-eqz v0, :cond_5

    .line 1136
    sget-object v0, Lcom/android/mail/ui/ConversationViewFragment;->LOG_TAG:Ljava/lang/String;

    const-string v3, "CONV RENDER: update is a single new message from self (%s)"

    new-array v1, v1, [Ljava/lang/Object;

    aput-object p0, v1, v2

    invoke-static {v0, v3, v1}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1138
    invoke-virtual {p2}, Lcom/android/mail/browse/MessageCursor;->moveToLast()Z

    .line 1139
    invoke-virtual {p2}, Lcom/android/mail/browse/MessageCursor;->getMessage()Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/android/mail/ui/ConversationViewFragment;->processNewOutgoingMessage(Lcom/android/mail/browse/MessageCursor$ConversationMessage;)V

    goto :goto_0

    :cond_4
    move v0, v2

    .line 1134
    goto :goto_2

    .line 1145
    :cond_5
    sget-object v0, Lcom/android/mail/ui/ConversationViewFragment;->LOG_TAG:Ljava/lang/String;

    const-string v3, "CONV RENDER: conversation updated, but not due to incoming message. rendering. (%s)"

    new-array v4, v1, [Ljava/lang/Object;

    aput-object p0, v4, v2

    invoke-static {v0, v3, v4}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1159
    :goto_3
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mConversationContainer:Lcom/android/mail/browse/ConversationContainer;

    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationContainer;->getWidth()I

    move-result v0

    if-nez v0, :cond_7

    .line 1160
    iput-boolean v1, p0, Lcom/android/mail/ui/ConversationViewFragment;->mNeedRender:Z

    .line 1161
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mConversationContainer:Lcom/android/mail/browse/ConversationContainer;

    invoke-virtual {v0, p0}, Lcom/android/mail/browse/ConversationContainer;->addOnLayoutChangeListener(Landroid/view/View$OnLayoutChangeListener;)V

    goto :goto_0

    .line 1153
    :cond_6
    sget-object v0, Lcom/android/mail/ui/ConversationViewFragment;->LOG_TAG:Ljava/lang/String;

    const-string v3, "CONV RENDER: initial render. (%s)"

    new-array v4, v1, [Ljava/lang/Object;

    aput-object p0, v4, v2

    invoke-static {v0, v3, v4}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_3

    .line 1163
    :cond_7
    invoke-direct {p0, p2}, Lcom/android/mail/ui/ConversationViewFragment;->renderConversation(Lcom/android/mail/browse/MessageCursor;)V

    goto :goto_0
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 383
    invoke-super {p0}, Lcom/android/mail/ui/AbstractConversationViewFragment;->onResume()V

    .line 386
    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationViewFragment;->getView()Landroid/view/View;

    move-result-object v0

    const-string v1, "ConversationViewFragment"

    invoke-static {v0, v1}, Lcom/android/mail/utils/Utils;->fixSubTreeLayoutIfOrphaned(Landroid/view/View;Ljava/lang/String;)V

    .line 387
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 400
    invoke-super {p0, p1}, Lcom/android/mail/ui/AbstractConversationViewFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 402
    sget-object v0, Lcom/android/mail/ui/ConversationViewFragment;->BUNDLE_KEY_WEBVIEW_Y_PERCENT:Ljava/lang/String;

    invoke-direct {p0}, Lcom/android/mail/ui/ConversationViewFragment;->calculateScrollYPercent()F

    move-result v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putFloat(Ljava/lang/String;F)V

    .line 403
    return-void
.end method

.method public onSuperCollapsedClick(Lcom/android/mail/browse/ConversationViewAdapter$SuperCollapsedBlockItem;)V
    .locals 3

    .prologue
    .line 833
    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationViewFragment;->getMessageCursor()Lcom/android/mail/browse/MessageCursor;

    move-result-object v0

    .line 834
    if-eqz v0, :cond_0

    iget-boolean v1, p0, Lcom/android/mail/ui/ConversationViewFragment;->mViewsCreated:Z

    if-nez v1, :cond_1

    .line 840
    :cond_0
    :goto_0
    return-void

    .line 838
    :cond_1
    invoke-direct {p0, v0, p1}, Lcom/android/mail/ui/ConversationViewFragment;->renderCollapsedHeaders(Lcom/android/mail/browse/MessageCursor;Lcom/android/mail/browse/ConversationViewAdapter$SuperCollapsedBlockItem;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mTempBodiesHtml:Ljava/lang/String;

    .line 839
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "javascript:replaceSuperCollapsedBlock("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/android/mail/browse/ConversationViewAdapter$SuperCollapsedBlockItem;->getStart()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/ConversationWebView;->loadUrl(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onUserVisibleHintChanged()V
    .locals 5

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 450
    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationViewFragment;->isUserVisible()Z

    move-result v0

    .line 452
    .local v0, "userVisible":Z
    if-nez v0, :cond_2

    .line 453
    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationViewFragment;->dismissLoadingStatus()V

    .line 464
    :cond_0
    :goto_0
    iget-object v1, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    if-eqz v1, :cond_1

    .line 465
    iget-object v1, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    invoke-virtual {v1, v0}, Lcom/android/mail/browse/ConversationWebView;->onUserVisibilityChanged(Z)V

    .line 467
    :cond_1
    return-void

    .line 454
    :cond_2
    iget-boolean v1, p0, Lcom/android/mail/ui/ConversationViewFragment;->mViewsCreated:Z

    if-eqz v1, :cond_0

    .line 455
    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationViewFragment;->getMessageCursor()Lcom/android/mail/browse/MessageCursor;

    move-result-object v1

    if-eqz v1, :cond_3

    .line 456
    sget-object v1, Lcom/android/mail/ui/ConversationViewFragment;->LOG_TAG:Ljava/lang/String;

    const-string v2, "Fragment is now user-visible, onConversationSeen: %s"

    new-array v3, v3, [Ljava/lang/Object;

    aput-object p0, v3, v4

    invoke-static {v1, v2, v3}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 457
    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationViewFragment;->onConversationSeen()V

    goto :goto_0

    .line 458
    :cond_3
    invoke-direct {p0}, Lcom/android/mail/ui/ConversationViewFragment;->isLoadWaiting()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 459
    sget-object v1, Lcom/android/mail/ui/ConversationViewFragment;->LOG_TAG:Ljava/lang/String;

    const-string v2, "Fragment is now user-visible, showing conversation: %s"

    new-array v3, v3, [Ljava/lang/Object;

    aput-object p0, v3, v4

    invoke-static {v1, v2, v3}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 460
    invoke-direct {p0}, Lcom/android/mail/ui/ConversationViewFragment;->handleDelayedConversationLoad()V

    goto :goto_0
.end method

.method public setMessageDetailsExpanded(Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;ZI)V
    .locals 2
    .param p1, "i"    # Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;
    .param p2, "expanded"    # Z
    .param p3, "heightBefore"    # I

    .prologue
    .line 1328
    if-eqz p2, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {p1}, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->getHeight()I

    move-result v1

    sub-int/2addr v1, p3

    invoke-static {v1}, Ljava/lang/Math;->abs(I)I

    move-result v1

    mul-int/2addr v0, v1

    iput v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mDiff:I

    .line 1329
    return-void

    .line 1328
    :cond_0
    const/4 v0, -0x1

    goto :goto_0
.end method

.method public setMessageExpanded(Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;I)V
    .locals 9

    .prologue
    const/4 v5, 0x3

    const/4 v8, 0x2

    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 811
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mConversationContainer:Lcom/android/mail/browse/ConversationContainer;

    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationContainer;->invalidateSpacerGeometry()V

    .line 814
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    invoke-virtual {v0, p2}, Lcom/android/mail/browse/ConversationWebView;->screenPxToWebPx(I)I

    move-result v0

    .line 815
    const-string v1, "ConvLayout"

    const-string v2, "setting HTML spacer expanded=%s h=%dwebPx (%dscreenPx)"

    new-array v3, v5, [Ljava/lang/Object;

    invoke-virtual {p1}, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->isExpanded()Z

    move-result v4

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v7

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v8

    invoke-static {v1, v2, v3}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 817
    iget-object v1, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    const-string v2, "javascript:setMessageBodyVisible(\'%s\', %s, %s);"

    new-array v3, v5, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/android/mail/ui/ConversationViewFragment;->mTemplates:Lcom/android/mail/ui/HtmlConversationTemplates;

    invoke-virtual {p1}, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->getMessage()Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/android/mail/ui/HtmlConversationTemplates;->getMessageDomId(Lcom/android/mail/providers/Message;)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-virtual {p1}, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->isExpanded()Z

    move-result v4

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    aput-object v4, v3, v7

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    aput-object v0, v3, v8

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/android/mail/browse/ConversationWebView;->loadUrl(Ljava/lang/String;)V

    .line 820
    iget-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mViewState:Lcom/android/mail/ui/ConversationViewState;

    invoke-virtual {p1}, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->getMessage()Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    move-result-object v2

    invoke-virtual {p1}, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->isExpanded()Z

    move-result v0

    if-eqz v0, :cond_0

    sget v0, Lcom/android/mail/ui/ConversationViewState$ExpansionState;->EXPANDED:I

    :goto_0
    invoke-virtual {v1, v2, v0}, Lcom/android/mail/ui/ConversationViewState;->setExpansionState(Lcom/android/mail/providers/Message;I)V

    .line 822
    return-void

    .line 820
    :cond_0
    sget v0, Lcom/android/mail/ui/ConversationViewState$ExpansionState;->COLLAPSED:I

    goto :goto_0
.end method

.method public setMessageSpacerHeight(Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;I)V
    .locals 8
    .param p1, "item"    # Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;
    .param p2, "newSpacerHeightPx"    # I

    .prologue
    const/4 v5, 0x2

    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 799
    iget-object v1, p0, Lcom/android/mail/ui/ConversationViewFragment;->mConversationContainer:Lcom/android/mail/browse/ConversationContainer;

    invoke-virtual {v1}, Lcom/android/mail/browse/ConversationContainer;->invalidateSpacerGeometry()V

    .line 802
    iget-object v1, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    invoke-virtual {v1, p2}, Lcom/android/mail/browse/ConversationWebView;->screenPxToWebPx(I)I

    move-result v0

    .line 803
    .local v0, "h":I
    const-string v1, "ConvLayout"

    const-string v2, "setting HTML spacer h=%dwebPx (%dscreenPx)"

    new-array v3, v5, [Ljava/lang/Object;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v7

    invoke-static {v1, v2, v3}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 805
    iget-object v1, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    const-string v2, "javascript:setMessageHeaderSpacerHeight(\'%s\', %s);"

    new-array v3, v5, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/android/mail/ui/ConversationViewFragment;->mTemplates:Lcom/android/mail/ui/HtmlConversationTemplates;

    invoke-virtual {p1}, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->getMessage()Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/android/mail/ui/HtmlConversationTemplates;->getMessageDomId(Lcom/android/mail/providers/Message;)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v7

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/android/mail/browse/ConversationWebView;->loadUrl(Ljava/lang/String;)V

    .line 807
    return-void
.end method

.method public showExternalResources(Lcom/android/mail/providers/Message;)V
    .locals 3

    .prologue
    .line 826
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationWebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/webkit/WebSettings;->setBlockNetworkImage(Z)V

    .line 827
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "javascript:unblockImages(\'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/ui/ConversationViewFragment;->mTemplates:Lcom/android/mail/ui/HtmlConversationTemplates;

    invoke-virtual {v2, p1}, Lcom/android/mail/ui/HtmlConversationTemplates;->getMessageDomId(Lcom/android/mail/providers/Message;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\');"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/ConversationWebView;->loadUrl(Ljava/lang/String;)V

    .line 828
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 870
    invoke-super {p0}, Lcom/android/mail/ui/AbstractConversationViewFragment;->toString()Ljava/lang/String;

    move-result-object v0

    .line 871
    sget-object v1, Lcom/android/mail/ui/ConversationViewFragment;->LOG_TAG:Ljava/lang/String;

    const/4 v2, 0x3

    invoke-static {v1, v2}, Lcom/android/mail/utils/LogUtils;->isLoggable(Ljava/lang/String;I)Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mConversation:Lcom/android/mail/providers/Conversation;

    if-nez v1, :cond_1

    .line 874
    :cond_0
    :goto_0
    return-object v0

    :cond_1
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " subj="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mConversation:Lcom/android/mail/providers/Conversation;

    iget-object v1, v1, Lcom/android/mail/providers/Conversation;->subject:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method
