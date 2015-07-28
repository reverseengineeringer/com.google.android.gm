.class public Lcom/android/mail/browse/SecureConversationViewFragment;
.super Lcom/android/mail/ui/AbstractConversationViewFragment;
.source "SecureConversationViewFragment.java"

# interfaces
.implements Lcom/android/mail/browse/MessageHeaderView$MessageHeaderViewCallbacks;


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private mConversationHeaderView:Lcom/android/mail/browse/ConversationViewHeader;

.field private mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

.field private mMessageFooterView:Lcom/android/mail/browse/MessageFooterView;

.field private mMessageHeaderView:Lcom/android/mail/browse/MessageHeaderView;

.field private mScrollView:Landroid/widget/ScrollView;

.field private mWebView:Landroid/webkit/WebView;

.field private mWebViewClient:Landroid/webkit/WebViewClient;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 56
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/browse/SecureConversationViewFragment;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 93
    invoke-direct {p0}, Lcom/android/mail/ui/AbstractConversationViewFragment;-><init>()V

    .line 63
    new-instance v0, Lcom/android/mail/browse/SecureConversationViewFragment$1;

    invoke-direct {v0, p0}, Lcom/android/mail/browse/SecureConversationViewFragment$1;-><init>(Lcom/android/mail/browse/SecureConversationViewFragment;)V

    iput-object v0, p0, Lcom/android/mail/browse/SecureConversationViewFragment;->mWebViewClient:Landroid/webkit/WebViewClient;

    .line 94
    return-void
.end method

.method static synthetic access$000(Lcom/android/mail/browse/SecureConversationViewFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/browse/SecureConversationViewFragment;

    .prologue
    .line 54
    invoke-virtual {p0}, Lcom/android/mail/browse/SecureConversationViewFragment;->onConversationSeen()V

    return-void
.end method

.method static synthetic access$100(Lcom/android/mail/browse/SecureConversationViewFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/browse/SecureConversationViewFragment;

    .prologue
    .line 54
    invoke-virtual {p0}, Lcom/android/mail/browse/SecureConversationViewFragment;->dismissLoadingStatus()V

    return-void
.end method

.method public static newInstance(Landroid/os/Bundle;Lcom/android/mail/providers/Conversation;)Lcom/android/mail/browse/SecureConversationViewFragment;
    .locals 3
    .param p0, "existingArgs"    # Landroid/os/Bundle;
    .param p1, "conversation"    # Lcom/android/mail/providers/Conversation;

    .prologue
    .line 81
    new-instance v1, Lcom/android/mail/browse/SecureConversationViewFragment;

    invoke-direct {v1}, Lcom/android/mail/browse/SecureConversationViewFragment;-><init>()V

    .line 82
    .local v1, "f":Lcom/android/mail/browse/SecureConversationViewFragment;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0, p0}, Landroid/os/Bundle;-><init>(Landroid/os/Bundle;)V

    .line 83
    .local v0, "args":Landroid/os/Bundle;
    const-string v2, "conversation"

    invoke-virtual {v0, v2, p1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 84
    invoke-virtual {v1, v0}, Lcom/android/mail/browse/SecureConversationViewFragment;->setArguments(Landroid/os/Bundle;)V

    .line 85
    return-object v1
.end method

.method private renderMessageBodies(Lcom/android/mail/browse/MessageCursor;Z)V
    .locals 13
    .param p1, "messageCursor"    # Lcom/android/mail/browse/MessageCursor;
    .param p2, "enableContentReadySignal"    # Z

    .prologue
    .line 214
    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    .line 216
    .local v11, "convHtml":Ljava/lang/StringBuilder;
    invoke-virtual {p1}, Lcom/android/mail/browse/MessageCursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 217
    const/16 v1, 0xc

    invoke-virtual {p1, v1}, Lcom/android/mail/browse/MessageCursor;->getString(I)Ljava/lang/String;

    move-result-object v10

    .line 218
    .local v10, "content":Ljava/lang/String;
    invoke-static {v10}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 219
    const/16 v1, 0xd

    invoke-virtual {p1, v1}, Lcom/android/mail/browse/MessageCursor;->getString(I)Ljava/lang/String;

    move-result-object v10

    .line 220
    if-eqz v10, :cond_0

    .line 221
    new-instance v1, Landroid/text/SpannedString;

    invoke-direct {v1, v10}, Landroid/text/SpannedString;-><init>(Ljava/lang/CharSequence;)V

    invoke-static {v1}, Landroid/text/Html;->toHtml(Landroid/text/Spanned;)Ljava/lang/String;

    move-result-object v10

    .line 224
    :cond_0
    invoke-virtual {v11, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 225
    iget-object v0, p0, Lcom/android/mail/browse/SecureConversationViewFragment;->mWebView:Landroid/webkit/WebView;

    iget-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mBaseUri:Ljava/lang/String;

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "text/html"

    const-string v4, "utf-8"

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/webkit/WebView;->loadDataWithBaseURL(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 226
    invoke-virtual {p1}, Lcom/android/mail/browse/MessageCursor;->getMessage()Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    move-result-object v1

    iput-object v1, p0, Lcom/android/mail/browse/SecureConversationViewFragment;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    .line 227
    new-instance v0, Lcom/android/mail/browse/ConversationViewAdapter;

    iget-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    invoke-direct/range {v0 .. v9}, Lcom/android/mail/browse/ConversationViewAdapter;-><init>(Lcom/android/mail/ui/ControllableActivity;Lcom/android/mail/browse/ConversationViewAdapter$ConversationAccountController;Landroid/app/LoaderManager;Lcom/android/mail/browse/MessageHeaderView$MessageHeaderViewCallbacks;Lcom/android/mail/ContactInfoSource;Lcom/android/mail/browse/ConversationViewHeader$ConversationViewHeaderCallbacks;Lcom/android/mail/browse/SuperCollapsedBlock$OnClickListener;Ljava/util/Map;Lcom/android/mail/FormattedDateBuilder;)V

    .line 229
    .local v0, "mAdapter":Lcom/android/mail/browse/ConversationViewAdapter;
    iget-object v1, p0, Lcom/android/mail/browse/SecureConversationViewFragment;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lcom/android/mail/browse/ConversationViewAdapter;->newMessageHeaderItem(Lcom/android/mail/browse/MessageCursor$ConversationMessage;Z)Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    move-result-object v12

    .line 230
    .local v12, "item":Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;
    iget-object v1, p0, Lcom/android/mail/browse/SecureConversationViewFragment;->mMessageHeaderView:Lcom/android/mail/browse/MessageHeaderView;

    iget-object v2, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mDateBuilder:Lcom/android/mail/FormattedDateBuilder;

    iget-object v3, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mAddressCache:Ljava/util/Map;

    invoke-virtual {v1, v2, p0, v3}, Lcom/android/mail/browse/MessageHeaderView;->initialize(Lcom/android/mail/FormattedDateBuilder;Lcom/android/mail/browse/ConversationViewAdapter$ConversationAccountController;Ljava/util/Map;)V

    .line 231
    iget-object v1, p0, Lcom/android/mail/browse/SecureConversationViewFragment;->mMessageHeaderView:Lcom/android/mail/browse/MessageHeaderView;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lcom/android/mail/browse/MessageHeaderView;->setExpandMode(I)V

    .line 232
    iget-object v1, p0, Lcom/android/mail/browse/SecureConversationViewFragment;->mMessageHeaderView:Lcom/android/mail/browse/MessageHeaderView;

    const/4 v2, 0x0

    invoke-virtual {v1, v12, v2}, Lcom/android/mail/browse/MessageHeaderView;->bind(Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;Z)V

    .line 233
    iget-object v1, p0, Lcom/android/mail/browse/SecureConversationViewFragment;->mMessageHeaderView:Lcom/android/mail/browse/MessageHeaderView;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/android/mail/browse/MessageHeaderView;->setMessageDetailsVisibility(I)V

    .line 234
    iget-object v1, p0, Lcom/android/mail/browse/SecureConversationViewFragment;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    iget-boolean v1, v1, Lcom/android/mail/providers/Message;->hasAttachments:Z

    if-eqz v1, :cond_1

    .line 235
    iget-object v1, p0, Lcom/android/mail/browse/SecureConversationViewFragment;->mMessageFooterView:Lcom/android/mail/browse/MessageFooterView;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/android/mail/browse/MessageFooterView;->setVisibility(I)V

    .line 236
    iget-object v1, p0, Lcom/android/mail/browse/SecureConversationViewFragment;->mMessageFooterView:Lcom/android/mail/browse/MessageFooterView;

    invoke-virtual {p0}, Lcom/android/mail/browse/SecureConversationViewFragment;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v2

    invoke-virtual {p0}, Lcom/android/mail/browse/SecureConversationViewFragment;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lcom/android/mail/browse/MessageFooterView;->initialize(Landroid/app/LoaderManager;Landroid/app/FragmentManager;)V

    .line 237
    iget-object v1, p0, Lcom/android/mail/browse/SecureConversationViewFragment;->mMessageFooterView:Lcom/android/mail/browse/MessageFooterView;

    const/4 v2, 0x0

    invoke-virtual {v1, v12, v2}, Lcom/android/mail/browse/MessageFooterView;->bind(Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;Z)V

    .line 240
    .end local v0    # "mAdapter":Lcom/android/mail/browse/ConversationViewAdapter;
    .end local v10    # "content":Ljava/lang/String;
    .end local v12    # "item":Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;
    :cond_1
    return-void
.end method


# virtual methods
.method protected markUnread()V
    .locals 8

    .prologue
    .line 141
    invoke-virtual {p0}, Lcom/android/mail/browse/SecureConversationViewFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/android/mail/ui/ControllableActivity;

    .line 142
    .local v0, "activity":Lcom/android/mail/ui/ControllableActivity;
    if-eqz v0, :cond_0

    iget-object v2, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mConversation:Lcom/android/mail/providers/Conversation;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/android/mail/browse/SecureConversationViewFragment;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    if-nez v2, :cond_2

    .line 143
    :cond_0
    sget-object v4, Lcom/android/mail/browse/SecureConversationViewFragment;->LOG_TAG:Ljava/lang/String;

    const-string v5, "ignoring markUnread for conv=%s"

    const/4 v2, 0x1

    new-array v6, v2, [Ljava/lang/Object;

    const/4 v7, 0x0

    iget-object v2, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mConversation:Lcom/android/mail/providers/Conversation;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mConversation:Lcom/android/mail/providers/Conversation;

    iget-wide v2, v2, Lcom/android/mail/providers/Conversation;->id:J

    :goto_0
    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    aput-object v2, v6, v7

    invoke-static {v4, v5, v6}, Lcom/android/mail/utils/LogUtils;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 151
    :goto_1
    return-void

    .line 143
    :cond_1
    const-wide/16 v2, 0x0

    goto :goto_0

    .line 147
    :cond_2
    new-instance v1, Ljava/util/HashSet;

    invoke-direct {v1}, Ljava/util/HashSet;-><init>()V

    .line 148
    .local v1, "uris":Ljava/util/HashSet;, "Ljava/util/HashSet<Landroid/net/Uri;>;"
    iget-object v2, p0, Lcom/android/mail/browse/SecureConversationViewFragment;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    iget-object v2, v2, Lcom/android/mail/providers/Message;->uri:Landroid/net/Uri;

    invoke-virtual {v1, v2}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 149
    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getConversationUpdater()Lcom/android/mail/ui/ConversationUpdater;

    move-result-object v2

    iget-object v3, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mConversation:Lcom/android/mail/providers/Conversation;

    iget-object v4, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mConversation:Lcom/android/mail/providers/Conversation;

    iget-object v4, v4, Lcom/android/mail/providers/Conversation;->conversationInfo:Lcom/android/mail/providers/ConversationInfo;

    invoke-static {v4}, Lcom/android/mail/providers/ConversationInfo;->toString(Lcom/android/mail/providers/ConversationInfo;)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v1, v4}, Lcom/android/mail/ui/ConversationUpdater;->markConversationMessagesUnread(Lcom/android/mail/providers/Conversation;Ljava/util/Set;Ljava/lang/String;)V

    goto :goto_1
.end method

.method public onAccountChanged(Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Account;)V
    .locals 0
    .param p1, "newAccount"    # Lcom/android/mail/providers/Account;
    .param p2, "oldAccount"    # Lcom/android/mail/providers/Account;

    .prologue
    .line 156
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v4, 0x0

    .line 98
    invoke-super {p0, p1}, Lcom/android/mail/ui/AbstractConversationViewFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 99
    iget-object v1, p0, Lcom/android/mail/browse/SecureConversationViewFragment;->mConversationHeaderView:Lcom/android/mail/browse/ConversationViewHeader;

    invoke-virtual {v1, p0, p0}, Lcom/android/mail/browse/ConversationViewHeader;->setCallbacks(Lcom/android/mail/browse/ConversationViewHeader$ConversationViewHeaderCallbacks;Lcom/android/mail/browse/ConversationViewAdapter$ConversationAccountController;)V

    .line 100
    iget-object v1, p0, Lcom/android/mail/browse/SecureConversationViewFragment;->mConversationHeaderView:Lcom/android/mail/browse/ConversationViewHeader;

    invoke-virtual {v1, v4}, Lcom/android/mail/browse/ConversationViewHeader;->setFoldersVisible(Z)V

    .line 101
    iget-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->getSubjectDisplayChanger()Lcom/android/mail/ui/SubjectDisplayChanger;

    move-result-object v0

    .line 102
    .local v0, "sdc":Lcom/android/mail/ui/SubjectDisplayChanger;
    if-eqz v0, :cond_0

    .line 103
    iget-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mConversation:Lcom/android/mail/providers/Conversation;

    iget-object v1, v1, Lcom/android/mail/providers/Conversation;->subject:Ljava/lang/String;

    invoke-interface {v0, v1}, Lcom/android/mail/ui/SubjectDisplayChanger;->setSubject(Ljava/lang/String;)V

    .line 105
    :cond_0
    iget-object v1, p0, Lcom/android/mail/browse/SecureConversationViewFragment;->mConversationHeaderView:Lcom/android/mail/browse/ConversationViewHeader;

    iget-object v2, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mConversation:Lcom/android/mail/providers/Conversation;

    iget-object v2, v2, Lcom/android/mail/providers/Conversation;->subject:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/android/mail/browse/ConversationViewHeader;->setSubject(Ljava/lang/String;)V

    .line 106
    iget-object v1, p0, Lcom/android/mail/browse/SecureConversationViewFragment;->mMessageHeaderView:Lcom/android/mail/browse/MessageHeaderView;

    invoke-virtual {p0}, Lcom/android/mail/browse/SecureConversationViewFragment;->getContactInfoSource()Lcom/android/mail/ui/AbstractConversationViewFragment$ContactLoaderCallbacks;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/android/mail/browse/MessageHeaderView;->setContactInfoSource(Lcom/android/mail/ContactInfoSource;)V

    .line 107
    iget-object v1, p0, Lcom/android/mail/browse/SecureConversationViewFragment;->mMessageHeaderView:Lcom/android/mail/browse/MessageHeaderView;

    invoke-virtual {v1, p0}, Lcom/android/mail/browse/MessageHeaderView;->setCallbacks(Lcom/android/mail/browse/MessageHeaderView$MessageHeaderViewCallbacks;)V

    .line 108
    iget-object v1, p0, Lcom/android/mail/browse/SecureConversationViewFragment;->mMessageHeaderView:Lcom/android/mail/browse/MessageHeaderView;

    invoke-virtual {v1, v4}, Lcom/android/mail/browse/MessageHeaderView;->setExpandable(Z)V

    .line 109
    invoke-virtual {p0}, Lcom/android/mail/browse/SecureConversationViewFragment;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {p0}, Lcom/android/mail/browse/SecureConversationViewFragment;->getMessageLoaderCallbacks()Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoaderCallbacks;

    move-result-object v3

    invoke-virtual {v1, v4, v2, v3}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    .line 110
    invoke-virtual {p0}, Lcom/android/mail/browse/SecureConversationViewFragment;->showLoadingStatus()V

    .line 111
    return-void
.end method

.method public onConversationUpdated(Lcom/android/mail/providers/Conversation;)V
    .locals 1
    .param p1, "conv"    # Lcom/android/mail/providers/Conversation;

    .prologue
    .line 244
    iget-object v0, p0, Lcom/android/mail/browse/SecureConversationViewFragment;->mConversationHeaderView:Lcom/android/mail/browse/ConversationViewHeader;

    .line 245
    .local v0, "headerView":Lcom/android/mail/browse/ConversationViewHeader;
    if-eqz v0, :cond_0

    .line 246
    invoke-virtual {v0, p1}, Lcom/android/mail/browse/ConversationViewHeader;->onConversationUpdated(Lcom/android/mail/providers/Conversation;)V

    .line 248
    :cond_0
    return-void
.end method

.method public onConversationViewHeaderHeightChange(I)V
    .locals 0
    .param p1, "newHeight"    # I

    .prologue
    .line 171
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 6
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 116
    const v2, 0x7f040066

    invoke-virtual {p1, v2, p2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 117
    .local v0, "rootView":Landroid/view/View;
    const v2, 0x7f1000e8

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ScrollView;

    iput-object v2, p0, Lcom/android/mail/browse/SecureConversationViewFragment;->mScrollView:Landroid/widget/ScrollView;

    .line 118
    const v2, 0x7f1000e9

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/android/mail/browse/ConversationViewHeader;

    iput-object v2, p0, Lcom/android/mail/browse/SecureConversationViewFragment;->mConversationHeaderView:Lcom/android/mail/browse/ConversationViewHeader;

    .line 119
    const v2, 0x7f1000ea

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/android/mail/browse/MessageHeaderView;

    iput-object v2, p0, Lcom/android/mail/browse/SecureConversationViewFragment;->mMessageHeaderView:Lcom/android/mail/browse/MessageHeaderView;

    .line 120
    const v2, 0x7f1000eb

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/android/mail/browse/MessageFooterView;

    iput-object v2, p0, Lcom/android/mail/browse/SecureConversationViewFragment;->mMessageFooterView:Lcom/android/mail/browse/MessageFooterView;

    .line 121
    invoke-virtual {p0, v0}, Lcom/android/mail/browse/SecureConversationViewFragment;->instantiateProgressIndicators(Landroid/view/View;)V

    .line 122
    const v2, 0x7f1000ad

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/webkit/WebView;

    iput-object v2, p0, Lcom/android/mail/browse/SecureConversationViewFragment;->mWebView:Landroid/webkit/WebView;

    .line 123
    iget-object v2, p0, Lcom/android/mail/browse/SecureConversationViewFragment;->mWebView:Landroid/webkit/WebView;

    iget-object v3, p0, Lcom/android/mail/browse/SecureConversationViewFragment;->mWebViewClient:Landroid/webkit/WebViewClient;

    invoke-virtual {v2, v3}, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 124
    iget-object v2, p0, Lcom/android/mail/browse/SecureConversationViewFragment;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v2, v4}, Landroid/webkit/WebView;->setFocusable(Z)V

    .line 125
    iget-object v2, p0, Lcom/android/mail/browse/SecureConversationViewFragment;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v2}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v1

    .line 127
    .local v1, "settings":Landroid/webkit/WebSettings;
    invoke-virtual {v1, v4}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    .line 128
    sget-object v2, Landroid/webkit/WebSettings$LayoutAlgorithm;->NORMAL:Landroid/webkit/WebSettings$LayoutAlgorithm;

    invoke-virtual {v1, v2}, Landroid/webkit/WebSettings;->setLayoutAlgorithm(Landroid/webkit/WebSettings$LayoutAlgorithm;)V

    .line 130
    invoke-virtual {v1, v5}, Landroid/webkit/WebSettings;->setSupportZoom(Z)V

    .line 131
    invoke-virtual {v1, v5}, Landroid/webkit/WebSettings;->setBuiltInZoomControls(Z)V

    .line 132
    invoke-virtual {v1, v4}, Landroid/webkit/WebSettings;->setDisplayZoomControls(Z)V

    .line 134
    return-object v0
.end method

.method protected onMessageCursorLoadFinished(Landroid/content/Loader;Lcom/android/mail/browse/MessageCursor;Lcom/android/mail/browse/MessageCursor;)V
    .locals 3
    .param p2, "newCursor"    # Lcom/android/mail/browse/MessageCursor;
    .param p3, "oldCursor"    # Lcom/android/mail/browse/MessageCursor;
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
    .line 196
    .local p1, "loader":Landroid/content/Loader;, "Landroid/content/Loader<Landroid/database/Cursor;>;"
    if-eqz p2, :cond_0

    invoke-virtual {p2}, Lcom/android/mail/browse/MessageCursor;->isLoaded()Z

    move-result v0

    if-nez v0, :cond_2

    .line 197
    :cond_0
    sget-object v0, Lcom/android/mail/browse/SecureConversationViewFragment;->LOG_TAG:Ljava/lang/String;

    const-string v1, "CONV RENDER: existing cursor is null, rendering from scratch"

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 205
    :cond_1
    :goto_0
    return-void

    .line 200
    :cond_2
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->isFinishing()Z

    move-result v0

    if-nez v0, :cond_1

    .line 204
    iget-boolean v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mEnableContentReadySignal:Z

    invoke-direct {p0, p2, v0}, Lcom/android/mail/browse/SecureConversationViewFragment;->renderMessageBodies(Lcom/android/mail/browse/MessageCursor;Z)V

    goto :goto_0
.end method

.method public onUserVisibleHintChanged()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 175
    iget-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    if-nez v1, :cond_0

    .line 185
    :goto_0
    return-void

    .line 178
    :cond_0
    iget-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->getSubjectDisplayChanger()Lcom/android/mail/ui/SubjectDisplayChanger;

    move-result-object v0

    .line 179
    .local v0, "sdc":Lcom/android/mail/ui/SubjectDisplayChanger;
    if-eqz v0, :cond_1

    .line 180
    iget-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mConversation:Lcom/android/mail/providers/Conversation;

    iget-object v1, v1, Lcom/android/mail/providers/Conversation;->subject:Ljava/lang/String;

    invoke-interface {v0, v1}, Lcom/android/mail/ui/SubjectDisplayChanger;->setSubject(Ljava/lang/String;)V

    .line 182
    :cond_1
    iget-object v1, p0, Lcom/android/mail/browse/SecureConversationViewFragment;->mConversationHeaderView:Lcom/android/mail/browse/ConversationViewHeader;

    iget-object v2, p0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mConversation:Lcom/android/mail/providers/Conversation;

    iget-object v2, v2, Lcom/android/mail/providers/Conversation;->subject:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/android/mail/browse/ConversationViewHeader;->setSubject(Ljava/lang/String;)V

    .line 183
    iget-object v1, p0, Lcom/android/mail/browse/SecureConversationViewFragment;->mScrollView:Landroid/widget/ScrollView;

    invoke-virtual {v1, v3, v3}, Landroid/widget/ScrollView;->scrollTo(II)V

    .line 184
    invoke-virtual {p0}, Lcom/android/mail/browse/SecureConversationViewFragment;->onConversationSeen()V

    goto :goto_0
.end method

.method public setMessageDetailsExpanded(Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;ZI)V
    .locals 0
    .param p1, "i"    # Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;
    .param p2, "expanded"    # Z
    .param p3, "heightbefore"    # I

    .prologue
    .line 253
    return-void
.end method

.method public setMessageExpanded(Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;I)V
    .locals 0
    .param p1, "item"    # Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;
    .param p2, "newSpacerHeight"    # I

    .prologue
    .line 166
    return-void
.end method

.method public setMessageSpacerHeight(Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;I)V
    .locals 0
    .param p1, "item"    # Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;
    .param p2, "newSpacerHeight"    # I

    .prologue
    .line 161
    return-void
.end method

.method public showExternalResources(Lcom/android/mail/providers/Message;)V
    .locals 2
    .param p1, "msg"    # Lcom/android/mail/providers/Message;

    .prologue
    .line 189
    iget-object v0, p0, Lcom/android/mail/browse/SecureConversationViewFragment;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/webkit/WebSettings;->setBlockNetworkImage(Z)V

    .line 190
    return-void
.end method
