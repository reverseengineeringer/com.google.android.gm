.class public Lcom/android/mail/ui/MailActionBarView;
.super Landroid/widget/LinearLayout;
.source "MailActionBarView.java"

# interfaces
.implements Landroid/view/MenuItem$OnActionExpandListener;
.implements Landroid/widget/SearchView$OnQueryTextListener;
.implements Landroid/widget/SearchView$OnSuggestionListener;
.implements Lcom/android/mail/ui/SubjectDisplayChanger;
.implements Lcom/android/mail/ui/ViewMode$ModeChangeListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/ui/MailActionBarView$FolderObserver;
    }
.end annotation


# static fields
.field public static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private mAccount:Lcom/android/mail/providers/Account;

.field private final mAccountObserver:Lcom/android/mail/providers/AccountObserver;

.field protected mActionBar:Landroid/app/ActionBar;

.field protected mActivity:Lcom/android/mail/ui/ControllableActivity;

.field protected mController:Lcom/android/mail/ui/ActivityController;

.field private mCurrentConversation:Lcom/android/mail/providers/Conversation;

.field private mFolder:Lcom/android/mail/providers/Folder;

.field private mFolderAccountName:Landroid/widget/TextView;

.field private mFolderObserver:Landroid/database/DataSetObserver;

.field private mFolderSettingsItem:Landroid/view/MenuItem;

.field private mFolderView:Landroid/view/View;

.field private final mHandler:Landroid/os/Handler;

.field private mHasManyAccounts:Z

.field private mHelpItem:Landroid/view/MenuItem;

.field private final mInvalidateMenu:Ljava/lang/Runnable;

.field private final mIsOnTablet:Z

.field private mMode:I

.field private mRefreshActionView:Landroid/view/View;

.field private mRefreshInProgress:Z

.field private mRefreshItem:Landroid/view/MenuItem;

.field private mSearch:Landroid/view/MenuItem;

.field private mSearchWidget:Landroid/widget/SearchView;

.field private mSendFeedbackItem:Landroid/view/MenuItem;

.field private final mShowConversationSubject:Z

.field private mSpinner:Lcom/android/mail/ui/MailSpinner;

.field private mSpinnerAdapter:Lcom/android/mail/AccountSpinnerAdapter;

.field private mSubjectView:Lcom/android/mail/browse/SnippetTextView;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 98
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/ui/MailActionBarView;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 125
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/android/mail/ui/MailActionBarView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 126
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 129
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/android/mail/ui/MailActionBarView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 130
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 133
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 70
    const/4 v0, 0x0

    iput v0, p0, Lcom/android/mail/ui/MailActionBarView;->mMode:I

    .line 100
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mHandler:Landroid/os/Handler;

    .line 101
    new-instance v0, Lcom/android/mail/ui/MailActionBarView$1;

    invoke-direct {v0, p0}, Lcom/android/mail/ui/MailActionBarView$1;-><init>(Lcom/android/mail/ui/MailActionBarView;)V

    iput-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mInvalidateMenu:Ljava/lang/Runnable;

    .line 111
    new-instance v0, Lcom/android/mail/ui/MailActionBarView$2;

    invoke-direct {v0, p0}, Lcom/android/mail/ui/MailActionBarView$2;-><init>(Lcom/android/mail/ui/MailActionBarView;)V

    iput-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mAccountObserver:Lcom/android/mail/providers/AccountObserver;

    .line 134
    invoke-virtual {p0}, Lcom/android/mail/ui/MailActionBarView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0f0003

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getBoolean(I)Z

    move-result v0

    iput-boolean v0, p0, Lcom/android/mail/ui/MailActionBarView;->mShowConversationSubject:Z

    .line 135
    invoke-static {p1}, Lcom/android/mail/utils/Utils;->useTabletUI(Landroid/content/Context;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/android/mail/ui/MailActionBarView;->mIsOnTablet:Z

    .line 136
    return-void
.end method

.method static synthetic access$000(Lcom/android/mail/ui/MailActionBarView;)Lcom/android/mail/providers/Account;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/MailActionBarView;

    .prologue
    .line 60
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mAccount:Lcom/android/mail/providers/Account;

    return-object v0
.end method

.method static synthetic access$002(Lcom/android/mail/ui/MailActionBarView;Lcom/android/mail/providers/Account;)Lcom/android/mail/providers/Account;
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/ui/MailActionBarView;
    .param p1, "x1"    # Lcom/android/mail/providers/Account;

    .prologue
    .line 60
    iput-object p1, p0, Lcom/android/mail/ui/MailActionBarView;->mAccount:Lcom/android/mail/providers/Account;

    return-object p1
.end method

.method static synthetic access$100(Lcom/android/mail/ui/MailActionBarView;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/MailActionBarView;

    .prologue
    .line 60
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mFolderAccountName:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$200(Lcom/android/mail/ui/MailActionBarView;)Lcom/android/mail/ui/MailSpinner;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/MailActionBarView;

    .prologue
    .line 60
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mSpinner:Lcom/android/mail/ui/MailSpinner;

    return-object v0
.end method

.method private final enableDisableSpinnner()V
    .locals 3

    .prologue
    const/4 v0, 0x1

    .line 274
    iget-boolean v1, p0, Lcom/android/mail/ui/MailActionBarView;->mIsOnTablet:Z

    if-nez v1, :cond_0

    .line 281
    :goto_0
    return-void

    .line 278
    :cond_0
    iget-boolean v1, p0, Lcom/android/mail/ui/MailActionBarView;->mHasManyAccounts:Z

    if-nez v1, :cond_1

    iget v1, p0, Lcom/android/mail/ui/MailActionBarView;->mMode:I

    if-eq v1, v0, :cond_1

    iget v1, p0, Lcom/android/mail/ui/MailActionBarView;->mMode:I

    const/4 v2, 0x5

    if-ne v1, v2, :cond_2

    .line 280
    .local v0, "enabled":Z
    :cond_1
    :goto_1
    iget-object v1, p0, Lcom/android/mail/ui/MailActionBarView;->mSpinner:Lcom/android/mail/ui/MailSpinner;

    invoke-virtual {v1, v0}, Lcom/android/mail/ui/MailSpinner;->changeEnabledState(Z)V

    goto :goto_0

    .line 278
    .end local v0    # "enabled":Z
    :cond_2
    const/4 v0, 0x0

    goto :goto_1
.end method

.method private onRefreshStarted()V
    .locals 1

    .prologue
    .line 482
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/android/mail/ui/MailActionBarView;->setRefreshInProgress(Z)Z

    .line 483
    return-void
.end method

.method private onRefreshStopped()V
    .locals 1

    .prologue
    .line 486
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/android/mail/ui/MailActionBarView;->setRefreshInProgress(Z)Z

    .line 487
    return-void
.end method

.method private setRefreshInProgress(Z)Z
    .locals 2
    .param p1, "inProgress"    # Z

    .prologue
    .line 471
    iget-boolean v0, p0, Lcom/android/mail/ui/MailActionBarView;->mRefreshInProgress:Z

    if-eq p1, v0, :cond_2

    .line 472
    iput-boolean p1, p0, Lcom/android/mail/ui/MailActionBarView;->mRefreshInProgress:Z

    .line 473
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mSearch:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mSearch:Landroid/view/MenuItem;

    invoke-interface {v0}, Landroid/view/MenuItem;->isActionViewExpanded()Z

    move-result v0

    if-nez v0, :cond_1

    .line 474
    :cond_0
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/android/mail/ui/MailActionBarView;->mInvalidateMenu:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 476
    :cond_1
    const/4 v0, 0x1

    .line 478
    :goto_0
    return v0

    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private setStandardMode()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 421
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mSpinner:Lcom/android/mail/ui/MailSpinner;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/android/mail/ui/MailSpinner;->setVisibility(I)V

    .line 422
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mFolderView:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 423
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mFolderAccountName:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 424
    return-void
.end method

.method private showNavList()V
    .locals 3

    .prologue
    const/16 v2, 0x8

    .line 412
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mSpinner:Lcom/android/mail/ui/MailSpinner;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/android/mail/ui/MailSpinner;->setVisibility(I)V

    .line 413
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mFolderView:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 414
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mFolderAccountName:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 415
    return-void
.end method


# virtual methods
.method public attach()V
    .locals 0

    .prologue
    .line 253
    return-void
.end method

.method public clearSubject()V
    .locals 2

    .prologue
    .line 594
    iget-boolean v0, p0, Lcom/android/mail/ui/MailActionBarView;->mShowConversationSubject:Z

    if-nez v0, :cond_0

    .line 599
    :goto_0
    return-void

    .line 598
    :cond_0
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mSubjectView:Lcom/android/mail/browse/SnippetTextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/SnippetTextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method

.method public collapseSearch()V
    .locals 1

    .prologue
    .line 159
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mSearch:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    .line 160
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mSearch:Landroid/view/MenuItem;

    invoke-interface {v0}, Landroid/view/MenuItem;->collapseActionView()Z

    .line 162
    :cond_0
    return-void
.end method

.method protected getMode()I
    .locals 1

    .prologue
    .line 352
    iget v0, p0, Lcom/android/mail/ui/MailActionBarView;->mMode:I

    return v0
.end method

.method public getOptionsMenuId()I
    .locals 2

    .prologue
    .line 207
    const/4 v1, 0x7

    new-array v0, v1, [I

    fill-array-data v0, :array_0

    .line 223
    .local v0, "modeMenu":[I
    iget v1, p0, Lcom/android/mail/ui/MailActionBarView;->mMode:I

    aget v1, v0, v1

    return v1

    .line 207
    nop

    :array_0
    .array-data 4
        0x7f120002
        0x7f120001
        0x7f120002
        0x7f120006
        0x7f120003
        0x7f120005
        0x7f12000f
    .end array-data
.end method

.method public getQuery()Ljava/lang/String;
    .locals 1

    .prologue
    .line 494
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mSearchWidget:Landroid/widget/SearchView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mSearchWidget:Landroid/widget/SearchView;

    invoke-virtual {v0}, Landroid/widget/SearchView;->getQuery()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

.method protected getSearch()Landroid/view/MenuItem;
    .locals 1

    .prologue
    .line 168
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mSearch:Landroid/view/MenuItem;

    return-object v0
.end method

.method public getUnshownSubject(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "subject"    # Ljava/lang/String;

    .prologue
    .line 603
    iget-boolean v0, p0, Lcom/android/mail/ui/MailActionBarView;->mShowConversationSubject:Z

    if-nez v0, :cond_0

    .line 607
    .end local p1    # "subject":Ljava/lang/String;
    :goto_0
    return-object p1

    .restart local p1    # "subject":Ljava/lang/String;
    :cond_0
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mSubjectView:Lcom/android/mail/browse/SnippetTextView;

    invoke-virtual {v0, p1}, Lcom/android/mail/browse/SnippetTextView;->getTextRemainder(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    goto :goto_0
.end method

.method public initialize(Lcom/android/mail/ui/ControllableActivity;Lcom/android/mail/ui/ActivityController;Lcom/android/mail/ui/ViewMode;Landroid/app/ActionBar;Lcom/android/mail/ui/RecentFolderList;)V
    .locals 3
    .param p1, "activity"    # Lcom/android/mail/ui/ControllableActivity;
    .param p2, "callback"    # Lcom/android/mail/ui/ActivityController;
    .param p3, "viewMode"    # Lcom/android/mail/ui/ViewMode;
    .param p4, "actionBar"    # Landroid/app/ActionBar;
    .param p5, "recentFolders"    # Lcom/android/mail/ui/RecentFolderList;

    .prologue
    .line 234
    iput-object p4, p0, Lcom/android/mail/ui/MailActionBarView;->mActionBar:Landroid/app/ActionBar;

    .line 235
    iput-object p2, p0, Lcom/android/mail/ui/MailActionBarView;->mController:Lcom/android/mail/ui/ActivityController;

    .line 236
    iput-object p1, p0, Lcom/android/mail/ui/MailActionBarView;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    .line 237
    new-instance v1, Lcom/android/mail/ui/MailActionBarView$FolderObserver;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Lcom/android/mail/ui/MailActionBarView$FolderObserver;-><init>(Lcom/android/mail/ui/MailActionBarView;Lcom/android/mail/ui/MailActionBarView$1;)V

    iput-object v1, p0, Lcom/android/mail/ui/MailActionBarView;->mFolderObserver:Landroid/database/DataSetObserver;

    .line 238
    iget-object v1, p0, Lcom/android/mail/ui/MailActionBarView;->mController:Lcom/android/mail/ui/ActivityController;

    iget-object v2, p0, Lcom/android/mail/ui/MailActionBarView;->mFolderObserver:Landroid/database/DataSetObserver;

    invoke-interface {v1, v2}, Lcom/android/mail/ui/ActivityController;->registerFolderObserver(Landroid/database/DataSetObserver;)V

    .line 240
    invoke-virtual {p0}, Lcom/android/mail/ui/MailActionBarView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcom/android/mail/utils/Utils;->useTabletUI(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_0

    const/4 v0, 0x1

    .line 241
    .local v0, "showAllFolders":Z
    :goto_0
    new-instance v1, Lcom/android/mail/AccountSpinnerAdapter;

    invoke-virtual {p0}, Lcom/android/mail/ui/MailActionBarView;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, p1, v2, v0}, Lcom/android/mail/AccountSpinnerAdapter;-><init>(Lcom/android/mail/ui/ControllableActivity;Landroid/content/Context;Z)V

    iput-object v1, p0, Lcom/android/mail/ui/MailActionBarView;->mSpinnerAdapter:Lcom/android/mail/AccountSpinnerAdapter;

    .line 242
    const v1, 0x7f10002d

    invoke-virtual {p0, v1}, Lcom/android/mail/ui/MailActionBarView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/android/mail/ui/MailSpinner;

    iput-object v1, p0, Lcom/android/mail/ui/MailActionBarView;->mSpinner:Lcom/android/mail/ui/MailSpinner;

    .line 243
    iget-object v1, p0, Lcom/android/mail/ui/MailActionBarView;->mSpinner:Lcom/android/mail/ui/MailSpinner;

    iget-object v2, p0, Lcom/android/mail/ui/MailActionBarView;->mSpinnerAdapter:Lcom/android/mail/AccountSpinnerAdapter;

    invoke-virtual {v1, v2}, Lcom/android/mail/ui/MailSpinner;->setAdapter(Lcom/android/mail/AccountSpinnerAdapter;)V

    .line 244
    iget-object v1, p0, Lcom/android/mail/ui/MailActionBarView;->mSpinner:Lcom/android/mail/ui/MailSpinner;

    iget-object v2, p0, Lcom/android/mail/ui/MailActionBarView;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-virtual {v1, v2}, Lcom/android/mail/ui/MailSpinner;->setController(Lcom/android/mail/ui/ActivityController;)V

    .line 245
    iget-object v1, p0, Lcom/android/mail/ui/MailActionBarView;->mAccountObserver:Lcom/android/mail/providers/AccountObserver;

    invoke-interface {p1}, Lcom/android/mail/ui/ControllableActivity;->getAccountController()Lcom/android/mail/ui/AccountController;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/android/mail/providers/AccountObserver;->initialize(Lcom/android/mail/ui/AccountController;)Lcom/android/mail/providers/Account;

    move-result-object v1

    iput-object v1, p0, Lcom/android/mail/ui/MailActionBarView;->mAccount:Lcom/android/mail/providers/Account;

    .line 246
    return-void

    .line 240
    .end local v0    # "showAllFolders":Z
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 5
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    const/4 v3, 0x1

    .line 181
    iget v2, p0, Lcom/android/mail/ui/MailActionBarView;->mMode:I

    if-nez v2, :cond_0

    .line 182
    const/4 v2, 0x0

    .line 202
    :goto_0
    return v2

    .line 184
    :cond_0
    const v2, 0x7f10012f

    invoke-interface {p1, v2}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v2

    iput-object v2, p0, Lcom/android/mail/ui/MailActionBarView;->mSearch:Landroid/view/MenuItem;

    .line 185
    iget-object v2, p0, Lcom/android/mail/ui/MailActionBarView;->mSearch:Landroid/view/MenuItem;

    if-eqz v2, :cond_1

    .line 186
    iget-object v2, p0, Lcom/android/mail/ui/MailActionBarView;->mSearch:Landroid/view/MenuItem;

    invoke-interface {v2}, Landroid/view/MenuItem;->getActionView()Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/SearchView;

    iput-object v2, p0, Lcom/android/mail/ui/MailActionBarView;->mSearchWidget:Landroid/widget/SearchView;

    .line 187
    iget-object v2, p0, Lcom/android/mail/ui/MailActionBarView;->mSearch:Landroid/view/MenuItem;

    invoke-interface {v2, p0}, Landroid/view/MenuItem;->setOnActionExpandListener(Landroid/view/MenuItem$OnActionExpandListener;)Landroid/view/MenuItem;

    .line 188
    iget-object v2, p0, Lcom/android/mail/ui/MailActionBarView;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v2}, Lcom/android/mail/ui/ControllableActivity;->getActivityContext()Landroid/content/Context;

    move-result-object v2

    const-string v4, "search"

    invoke-virtual {v2, v4}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/app/SearchManager;

    .line 190
    .local v1, "searchManager":Landroid/app/SearchManager;
    if-eqz v1, :cond_1

    iget-object v2, p0, Lcom/android/mail/ui/MailActionBarView;->mSearchWidget:Landroid/widget/SearchView;

    if-eqz v2, :cond_1

    .line 191
    iget-object v2, p0, Lcom/android/mail/ui/MailActionBarView;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v2}, Lcom/android/mail/ui/ControllableActivity;->getComponentName()Landroid/content/ComponentName;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/app/SearchManager;->getSearchableInfo(Landroid/content/ComponentName;)Landroid/app/SearchableInfo;

    move-result-object v0

    .line 192
    .local v0, "info":Landroid/app/SearchableInfo;
    iget-object v2, p0, Lcom/android/mail/ui/MailActionBarView;->mSearchWidget:Landroid/widget/SearchView;

    invoke-virtual {v2, v0}, Landroid/widget/SearchView;->setSearchableInfo(Landroid/app/SearchableInfo;)V

    .line 193
    iget-object v2, p0, Lcom/android/mail/ui/MailActionBarView;->mSearchWidget:Landroid/widget/SearchView;

    invoke-virtual {v2, p0}, Landroid/widget/SearchView;->setOnQueryTextListener(Landroid/widget/SearchView$OnQueryTextListener;)V

    .line 194
    iget-object v2, p0, Lcom/android/mail/ui/MailActionBarView;->mSearchWidget:Landroid/widget/SearchView;

    invoke-virtual {v2, p0}, Landroid/widget/SearchView;->setOnSuggestionListener(Landroid/widget/SearchView$OnSuggestionListener;)V

    .line 195
    iget-object v2, p0, Lcom/android/mail/ui/MailActionBarView;->mSearchWidget:Landroid/widget/SearchView;

    invoke-virtual {v2, v3}, Landroid/widget/SearchView;->setIconifiedByDefault(Z)V

    .line 198
    .end local v0    # "info":Landroid/app/SearchableInfo;
    .end local v1    # "searchManager":Landroid/app/SearchManager;
    :cond_1
    const v2, 0x7f100122

    invoke-interface {p1, v2}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v2

    iput-object v2, p0, Lcom/android/mail/ui/MailActionBarView;->mHelpItem:Landroid/view/MenuItem;

    .line 199
    const v2, 0x7f100121

    invoke-interface {p1, v2}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v2

    iput-object v2, p0, Lcom/android/mail/ui/MailActionBarView;->mSendFeedbackItem:Landroid/view/MenuItem;

    .line 200
    const v2, 0x7f100130

    invoke-interface {p1, v2}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v2

    iput-object v2, p0, Lcom/android/mail/ui/MailActionBarView;->mRefreshItem:Landroid/view/MenuItem;

    .line 201
    const v2, 0x7f100131

    invoke-interface {p1, v2}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v2

    iput-object v2, p0, Lcom/android/mail/ui/MailActionBarView;->mFolderSettingsItem:Landroid/view/MenuItem;

    move v2, v3

    .line 202
    goto :goto_0
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    .line 295
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mFolderObserver:Landroid/database/DataSetObserver;

    if-eqz v0, :cond_0

    .line 296
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mController:Lcom/android/mail/ui/ActivityController;

    iget-object v1, p0, Lcom/android/mail/ui/MailActionBarView;->mFolderObserver:Landroid/database/DataSetObserver;

    invoke-interface {v0, v1}, Lcom/android/mail/ui/ActivityController;->unregisterFolderObserver(Landroid/database/DataSetObserver;)V

    .line 297
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mFolderObserver:Landroid/database/DataSetObserver;

    .line 299
    :cond_0
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mSpinnerAdapter:Lcom/android/mail/AccountSpinnerAdapter;

    invoke-virtual {v0}, Lcom/android/mail/AccountSpinnerAdapter;->destroy()V

    .line 300
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mAccountObserver:Lcom/android/mail/providers/AccountObserver;

    invoke-virtual {v0}, Lcom/android/mail/providers/AccountObserver;->unregisterAndDestroy()V

    .line 301
    return-void
.end method

.method protected onFinishInflate()V
    .locals 2

    .prologue
    .line 148
    invoke-super {p0}, Landroid/widget/LinearLayout;->onFinishInflate()V

    .line 150
    const v0, 0x7f10002c

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/MailActionBarView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/android/mail/browse/SnippetTextView;

    iput-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mSubjectView:Lcom/android/mail/browse/SnippetTextView;

    .line 151
    const v0, 0x7f10002a

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/MailActionBarView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mFolderView:Landroid/view/View;

    .line 152
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mFolderView:Landroid/view/View;

    const v1, 0x7f10001d

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mFolderAccountName:Landroid/widget/TextView;

    .line 153
    return-void
.end method

.method public onFolderUpdated(Lcom/android/mail/providers/Folder;)V
    .locals 2
    .param p1, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 551
    iget-object v1, p0, Lcom/android/mail/ui/MailActionBarView;->mSpinner:Lcom/android/mail/ui/MailSpinner;

    invoke-virtual {v1, p1}, Lcom/android/mail/ui/MailSpinner;->onFolderUpdated(Lcom/android/mail/providers/Folder;)V

    .line 552
    iget v0, p1, Lcom/android/mail/providers/Folder;->syncStatus:I

    .line 553
    .local v0, "status":I
    invoke-virtual {p1}, Lcom/android/mail/providers/Folder;->isSyncInProgress()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 554
    invoke-direct {p0}, Lcom/android/mail/ui/MailActionBarView;->onRefreshStarted()V

    .line 559
    :goto_0
    return-void

    .line 557
    :cond_0
    invoke-direct {p0}, Lcom/android/mail/ui/MailActionBarView;->onRefreshStopped()V

    goto :goto_0
.end method

.method public onMenuItemActionCollapse(Landroid/view/MenuItem;)Z
    .locals 1
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 576
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/MailActionBarView;->setVisibility(I)V

    .line 580
    const/4 v0, 0x1

    return v0
.end method

.method public onMenuItemActionExpand(Landroid/view/MenuItem;)Z
    .locals 1
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 568
    const/4 v0, 0x1

    return v0
.end method

.method public onPrepareOptionsMenu(Landroid/view/Menu;)Z
    .locals 5
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 358
    sget-object v0, Lcom/android/mail/ui/MailActionBarView;->LOG_TAG:Ljava/lang/String;

    const-string v3, "ActionBarView.onPrepareOptionsMenu()."

    new-array v4, v2, [Ljava/lang/Object;

    invoke-static {v0, v3, v4}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 362
    iget-boolean v0, p0, Lcom/android/mail/ui/MailActionBarView;->mRefreshInProgress:Z

    if-eqz v0, :cond_5

    .line 363
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mRefreshItem:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    .line 364
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mRefreshActionView:Landroid/view/View;

    if-nez v0, :cond_4

    .line 365
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mRefreshItem:Landroid/view/MenuItem;

    const v3, 0x7f040008

    invoke-interface {v0, v3}, Landroid/view/MenuItem;->setActionView(I)Landroid/view/MenuItem;

    .line 366
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mRefreshItem:Landroid/view/MenuItem;

    invoke-interface {v0}, Landroid/view/MenuItem;->getActionView()Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mRefreshActionView:Landroid/view/View;

    .line 376
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mHelpItem:Landroid/view/MenuItem;

    if-eqz v0, :cond_1

    .line 377
    iget-object v3, p0, Lcom/android/mail/ui/MailActionBarView;->mHelpItem:Landroid/view/MenuItem;

    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mAccount:Lcom/android/mail/providers/Account;

    if-eqz v0, :cond_6

    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mAccount:Lcom/android/mail/providers/Account;

    const v4, 0x8000

    invoke-virtual {v0, v4}, Lcom/android/mail/providers/Account;->supportsCapability(I)Z

    move-result v0

    if-eqz v0, :cond_6

    move v0, v1

    :goto_1
    invoke-interface {v3, v0}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 380
    :cond_1
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mSendFeedbackItem:Landroid/view/MenuItem;

    if-eqz v0, :cond_2

    .line 381
    iget-object v3, p0, Lcom/android/mail/ui/MailActionBarView;->mSendFeedbackItem:Landroid/view/MenuItem;

    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mAccount:Lcom/android/mail/providers/Account;

    if-eqz v0, :cond_7

    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mAccount:Lcom/android/mail/providers/Account;

    const/high16 v4, 0x10000

    invoke-virtual {v0, v4}, Lcom/android/mail/providers/Account;->supportsCapability(I)Z

    move-result v0

    if-eqz v0, :cond_7

    move v0, v1

    :goto_2
    invoke-interface {v3, v0}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 384
    :cond_2
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mFolderSettingsItem:Landroid/view/MenuItem;

    if-eqz v0, :cond_3

    .line 385
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mFolderSettingsItem:Landroid/view/MenuItem;

    iget-object v3, p0, Lcom/android/mail/ui/MailActionBarView;->mFolder:Lcom/android/mail/providers/Folder;

    if-eqz v3, :cond_8

    iget-object v3, p0, Lcom/android/mail/ui/MailActionBarView;->mFolder:Lcom/android/mail/providers/Folder;

    const/16 v4, 0x200

    invoke-virtual {v3, v4}, Lcom/android/mail/providers/Folder;->supportsCapability(I)Z

    move-result v3

    if-eqz v3, :cond_8

    :goto_3
    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 389
    :cond_3
    iget v0, p0, Lcom/android/mail/ui/MailActionBarView;->mMode:I

    packed-switch v0, :pswitch_data_0

    .line 405
    :goto_4
    :pswitch_0
    return v2

    .line 368
    :cond_4
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mRefreshItem:Landroid/view/MenuItem;

    iget-object v3, p0, Lcom/android/mail/ui/MailActionBarView;->mRefreshActionView:Landroid/view/View;

    invoke-interface {v0, v3}, Landroid/view/MenuItem;->setActionView(Landroid/view/View;)Landroid/view/MenuItem;

    goto :goto_0

    .line 372
    :cond_5
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mRefreshItem:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    .line 373
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mRefreshItem:Landroid/view/MenuItem;

    const/4 v3, 0x0

    invoke-interface {v0, v3}, Landroid/view/MenuItem;->setActionView(Landroid/view/View;)Landroid/view/MenuItem;

    goto :goto_0

    :cond_6
    move v0, v2

    .line 377
    goto :goto_1

    :cond_7
    move v0, v2

    .line 381
    goto :goto_2

    :cond_8
    move v1, v2

    .line 385
    goto :goto_3

    .line 396
    :pswitch_1
    invoke-virtual {p0, p1}, Lcom/android/mail/ui/MailActionBarView;->setConversationModeOptions(Landroid/view/Menu;)V

    goto :goto_4

    .line 401
    :pswitch_2
    const v0, 0x7f10012f

    iget-object v1, p0, Lcom/android/mail/ui/MailActionBarView;->mAccount:Lcom/android/mail/providers/Account;

    const/16 v3, 0x40

    invoke-virtual {v1, v3}, Lcom/android/mail/providers/Account;->supportsCapability(I)Z

    move-result v1

    invoke-static {p1, v0, v1}, Lcom/android/mail/utils/Utils;->setMenuItemVisibility(Landroid/view/Menu;IZ)V

    goto :goto_4

    .line 389
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_2
        :pswitch_0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public onQueryTextChange(Ljava/lang/String;)Z
    .locals 1
    .param p1, "newText"    # Ljava/lang/String;

    .prologue
    .line 467
    const/4 v0, 0x0

    return v0
.end method

.method public onQueryTextSubmit(Ljava/lang/String;)Z
    .locals 3
    .param p1, "query"    # Ljava/lang/String;

    .prologue
    .line 457
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mSearch:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    .line 458
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mSearch:Landroid/view/MenuItem;

    invoke-interface {v0}, Landroid/view/MenuItem;->collapseActionView()Z

    .line 459
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mSearchWidget:Landroid/widget/SearchView;

    const-string v1, ""

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/widget/SearchView;->setQuery(Ljava/lang/CharSequence;Z)V

    .line 461
    :cond_0
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/android/mail/ui/ControllableActivity;->onSearchRequested(Ljava/lang/String;)Z

    .line 462
    const/4 v0, 0x1

    return v0
.end method

.method public onSuggestionClick(I)Z
    .locals 10
    .param p1, "position"    # I

    .prologue
    const/4 v9, -0x1

    const/4 v6, 0x1

    const/4 v7, 0x0

    .line 505
    iget-object v8, p0, Lcom/android/mail/ui/MailActionBarView;->mSearchWidget:Landroid/widget/SearchView;

    invoke-virtual {v8}, Landroid/widget/SearchView;->getSuggestionsAdapter()Landroid/widget/CursorAdapter;

    move-result-object v8

    invoke-virtual {v8}, Landroid/widget/CursorAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v0

    .line 506
    .local v0, "c":Landroid/database/Cursor;
    if-eqz v0, :cond_0

    invoke-interface {v0, p1}, Landroid/database/Cursor;->moveToPosition(I)Z

    move-result v8

    if-eqz v8, :cond_0

    move v1, v6

    .line 507
    .local v1, "haveValidQuery":Z
    :goto_0
    if-nez v1, :cond_1

    .line 508
    sget-object v8, Lcom/android/mail/ui/MailActionBarView;->LOG_TAG:Ljava/lang/String;

    const-string v9, "onSuggestionClick: Couldn\'t get a search query"

    new-array v7, v7, [Ljava/lang/Object;

    invoke-static {v8, v9, v7}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 544
    :goto_1
    return v6

    .end local v1    # "haveValidQuery":Z
    :cond_0
    move v1, v7

    .line 506
    goto :goto_0

    .line 514
    .restart local v1    # "haveValidQuery":Z
    :cond_1
    invoke-virtual {p0}, Lcom/android/mail/ui/MailActionBarView;->collapseSearch()V

    .line 516
    iget-object v8, p0, Lcom/android/mail/ui/MailActionBarView;->mSearchWidget:Landroid/widget/SearchView;

    invoke-virtual {v8}, Landroid/widget/SearchView;->getQuery()Ljava/lang/CharSequence;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    .line 518
    .local v3, "queryText":Ljava/lang/String;
    const-string v8, "suggest_intent_query"

    invoke-interface {v0, v8}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v8

    invoke-interface {v0, v8}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 523
    .local v2, "query":Ljava/lang/String;
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v8

    if-nez v8, :cond_3

    invoke-virtual {v2, v3}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v8

    if-eqz v8, :cond_3

    .line 524
    const-string v8, " "

    invoke-virtual {v3, v8}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v4

    .line 526
    .local v4, "queryTokenIndex":I
    if-le v4, v9, :cond_2

    .line 527
    invoke-virtual {v3, v7, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    .line 537
    :cond_2
    if-le v4, v9, :cond_3

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v8

    if-nez v8, :cond_3

    invoke-virtual {v2, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v8

    if-eqz v8, :cond_3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v8

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v9

    if-ge v8, v9, :cond_3

    .line 539
    invoke-virtual {v2, v3}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v5

    .line 540
    .local v5, "start":I
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v7, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v8, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v8

    add-int/2addr v8, v5

    invoke-virtual {v2, v8}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 543
    .end local v4    # "queryTokenIndex":I
    .end local v5    # "start":I
    :cond_3
    iget-object v7, p0, Lcom/android/mail/ui/MailActionBarView;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v8

    invoke-interface {v7, v8}, Lcom/android/mail/ui/ActivityController;->onSearchRequested(Ljava/lang/String;)V

    goto :goto_1
.end method

.method public onSuggestionSelect(I)Z
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 500
    invoke-virtual {p0, p1}, Lcom/android/mail/ui/MailActionBarView;->onSuggestionClick(I)Z

    move-result v0

    return v0
.end method

.method public onViewModeChanged(I)V
    .locals 3
    .param p1, "newMode"    # I

    .prologue
    const/4 v2, 0x1

    .line 305
    iput p1, p0, Lcom/android/mail/ui/MailActionBarView;->mMode:I

    .line 308
    invoke-direct {p0}, Lcom/android/mail/ui/MailActionBarView;->enableDisableSpinnner()V

    .line 309
    iget-object v1, p0, Lcom/android/mail/ui/MailActionBarView;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->invalidateOptionsMenu()V

    .line 312
    iget-boolean v1, p0, Lcom/android/mail/ui/MailActionBarView;->mIsOnTablet:Z

    if-eqz v1, :cond_0

    iget v1, p0, Lcom/android/mail/ui/MailActionBarView;->mMode:I

    if-ne v1, v2, :cond_2

    .line 313
    :cond_0
    iget-object v1, p0, Lcom/android/mail/ui/MailActionBarView;->mSpinnerAdapter:Lcom/android/mail/AccountSpinnerAdapter;

    invoke-virtual {v1}, Lcom/android/mail/AccountSpinnerAdapter;->enableRecentFolders()V

    .line 318
    :goto_0
    const/4 v0, 0x0

    .line 320
    .local v0, "showFolderView":Z
    iget v1, p0, Lcom/android/mail/ui/MailActionBarView;->mMode:I

    packed-switch v1, :pswitch_data_0

    .line 348
    :cond_1
    :goto_1
    :pswitch_0
    iget-object v2, p0, Lcom/android/mail/ui/MailActionBarView;->mFolderView:Landroid/view/View;

    if-eqz v0, :cond_4

    const/4 v1, 0x0

    :goto_2
    invoke-virtual {v2, v1}, Landroid/view/View;->setVisibility(I)V

    .line 349
    return-void

    .line 315
    .end local v0    # "showFolderView":Z
    :cond_2
    iget-object v1, p0, Lcom/android/mail/ui/MailActionBarView;->mSpinnerAdapter:Lcom/android/mail/AccountSpinnerAdapter;

    invoke-virtual {v1}, Lcom/android/mail/AccountSpinnerAdapter;->disableRecentFolders()V

    goto :goto_0

    .line 322
    .restart local v0    # "showFolderView":Z
    :pswitch_1
    iget-object v1, p0, Lcom/android/mail/ui/MailActionBarView;->mSearch:Landroid/view/MenuItem;

    if-eqz v1, :cond_1

    .line 323
    iget-object v1, p0, Lcom/android/mail/ui/MailActionBarView;->mSearch:Landroid/view/MenuItem;

    invoke-interface {v1}, Landroid/view/MenuItem;->collapseActionView()Z

    goto :goto_1

    .line 327
    :pswitch_2
    invoke-direct {p0}, Lcom/android/mail/ui/MailActionBarView;->showNavList()V

    goto :goto_1

    .line 330
    :pswitch_3
    iget-object v1, p0, Lcom/android/mail/ui/MailActionBarView;->mActionBar:Landroid/app/ActionBar;

    invoke-virtual {v1, v2}, Landroid/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 331
    iget-boolean v1, p0, Lcom/android/mail/ui/MailActionBarView;->mShowConversationSubject:Z

    if-nez v1, :cond_3

    .line 332
    invoke-direct {p0}, Lcom/android/mail/ui/MailActionBarView;->showNavList()V

    goto :goto_1

    .line 334
    :cond_3
    invoke-direct {p0}, Lcom/android/mail/ui/MailActionBarView;->setStandardMode()V

    goto :goto_1

    .line 338
    :pswitch_4
    iget-object v1, p0, Lcom/android/mail/ui/MailActionBarView;->mActionBar:Landroid/app/ActionBar;

    invoke-virtual {v1, v2}, Landroid/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 339
    invoke-direct {p0}, Lcom/android/mail/ui/MailActionBarView;->setStandardMode()V

    .line 340
    const/4 v0, 0x1

    .line 341
    goto :goto_1

    .line 345
    :pswitch_5
    invoke-direct {p0}, Lcom/android/mail/ui/MailActionBarView;->showNavList()V

    goto :goto_1

    .line 348
    :cond_4
    const/16 v1, 0x8

    goto :goto_2

    .line 320
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_3
        :pswitch_2
        :pswitch_4
        :pswitch_0
        :pswitch_0
        :pswitch_5
    .end packed-switch
.end method

.method public removeBackButton()V
    .locals 4

    .prologue
    .line 436
    iget-object v1, p0, Lcom/android/mail/ui/MailActionBarView;->mActionBar:Landroid/app/ActionBar;

    if-nez v1, :cond_0

    .line 443
    :goto_0
    return-void

    .line 440
    :cond_0
    const/4 v0, 0x6

    .line 441
    .local v0, "mask":I
    iget-object v1, p0, Lcom/android/mail/ui/MailActionBarView;->mActionBar:Landroid/app/ActionBar;

    const/4 v2, 0x2

    const/4 v3, 0x6

    invoke-virtual {v1, v2, v3}, Landroid/app/ActionBar;->setDisplayOptions(II)V

    .line 442
    iget-object v1, p0, Lcom/android/mail/ui/MailActionBarView;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/app/ActionBar;->setHomeButtonEnabled(Z)V

    goto :goto_0
.end method

.method public setAccounts([Lcom/android/mail/providers/Account;)V
    .locals 2
    .param p1, "accounts"    # [Lcom/android/mail/providers/Account;

    .prologue
    const/4 v0, 0x1

    .line 260
    iget-object v1, p0, Lcom/android/mail/ui/MailActionBarView;->mSpinnerAdapter:Lcom/android/mail/AccountSpinnerAdapter;

    invoke-virtual {v1, p1}, Lcom/android/mail/AccountSpinnerAdapter;->setAccountArray([Lcom/android/mail/providers/Account;)V

    .line 261
    array-length v1, p1

    if-le v1, v0, :cond_0

    :goto_0
    iput-boolean v0, p0, Lcom/android/mail/ui/MailActionBarView;->mHasManyAccounts:Z

    .line 262
    invoke-direct {p0}, Lcom/android/mail/ui/MailActionBarView;->enableDisableSpinnner()V

    .line 263
    return-void

    .line 261
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setBackButton()V
    .locals 3

    .prologue
    const/4 v2, 0x6

    .line 446
    iget-object v1, p0, Lcom/android/mail/ui/MailActionBarView;->mActionBar:Landroid/app/ActionBar;

    if-nez v1, :cond_0

    .line 453
    :goto_0
    return-void

    .line 450
    :cond_0
    const/4 v0, 0x6

    .line 451
    .local v0, "mask":I
    iget-object v1, p0, Lcom/android/mail/ui/MailActionBarView;->mActionBar:Landroid/app/ActionBar;

    invoke-virtual {v1, v2, v2}, Landroid/app/ActionBar;->setDisplayOptions(II)V

    .line 452
    iget-object v1, p0, Lcom/android/mail/ui/MailActionBarView;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/app/ActionBar;->setHomeButtonEnabled(Z)V

    goto :goto_0
.end method

.method public setConversationModeOptions(Landroid/view/Menu;)V
    .locals 13
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    const/16 v12, 0x10

    const/16 v10, 0x8

    const/4 v11, 0x2

    const/4 v6, 0x1

    const/4 v7, 0x0

    .line 616
    iget-object v5, p0, Lcom/android/mail/ui/MailActionBarView;->mCurrentConversation:Lcom/android/mail/providers/Conversation;

    if-nez v5, :cond_0

    .line 661
    :goto_0
    return-void

    .line 619
    :cond_0
    iget-object v5, p0, Lcom/android/mail/ui/MailActionBarView;->mCurrentConversation:Lcom/android/mail/providers/Conversation;

    invoke-virtual {v5}, Lcom/android/mail/providers/Conversation;->isImportant()Z

    move-result v5

    if-nez v5, :cond_2

    move v4, v6

    .line 620
    .local v4, "showMarkImportant":Z
    :goto_1
    const v8, 0x7f100129

    if-eqz v4, :cond_3

    iget-object v5, p0, Lcom/android/mail/ui/MailActionBarView;->mAccount:Lcom/android/mail/providers/Account;

    const/high16 v9, 0x20000

    invoke-virtual {v5, v9}, Lcom/android/mail/providers/Account;->supportsCapability(I)Z

    move-result v5

    if-eqz v5, :cond_3

    move v5, v6

    :goto_2
    invoke-static {p1, v8, v5}, Lcom/android/mail/utils/Utils;->setMenuItemVisibility(Landroid/view/Menu;IZ)V

    .line 622
    const v8, 0x7f10012a

    if-nez v4, :cond_4

    iget-object v5, p0, Lcom/android/mail/ui/MailActionBarView;->mAccount:Lcom/android/mail/providers/Account;

    const/high16 v9, 0x20000

    invoke-virtual {v5, v9}, Lcom/android/mail/providers/Account;->supportsCapability(I)Z

    move-result v5

    if-eqz v5, :cond_4

    move v5, v6

    :goto_3
    invoke-static {p1, v8, v5}, Lcom/android/mail/utils/Utils;->setMenuItemVisibility(Landroid/view/Menu;IZ)V

    .line 624
    iget-object v5, p0, Lcom/android/mail/ui/MailActionBarView;->mFolder:Lcom/android/mail/providers/Folder;

    if-eqz v5, :cond_5

    iget-object v5, p0, Lcom/android/mail/ui/MailActionBarView;->mFolder:Lcom/android/mail/providers/Folder;

    const/16 v8, 0x20

    invoke-virtual {v5, v8}, Lcom/android/mail/providers/Folder;->supportsCapability(I)Z

    move-result v5

    if-eqz v5, :cond_5

    move v2, v6

    .line 626
    .local v2, "showDelete":Z
    :goto_4
    const v5, 0x7f100125

    invoke-static {p1, v5, v2}, Lcom/android/mail/utils/Utils;->setMenuItemVisibility(Landroid/view/Menu;IZ)V

    .line 630
    if-nez v2, :cond_6

    iget-object v5, p0, Lcom/android/mail/ui/MailActionBarView;->mFolder:Lcom/android/mail/providers/Folder;

    if-eqz v5, :cond_6

    iget-object v5, p0, Lcom/android/mail/ui/MailActionBarView;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-virtual {v5}, Lcom/android/mail/providers/Folder;->isDraft()Z

    move-result v5

    if-eqz v5, :cond_6

    iget-object v5, p0, Lcom/android/mail/ui/MailActionBarView;->mAccount:Lcom/android/mail/providers/Account;

    const/high16 v8, 0x100000

    invoke-virtual {v5, v8}, Lcom/android/mail/providers/Account;->supportsCapability(I)Z

    move-result v5

    if-eqz v5, :cond_6

    move v3, v6

    .line 632
    .local v3, "showDiscardDrafts":Z
    :goto_5
    const v5, 0x7f100126

    invoke-static {p1, v5, v3}, Lcom/android/mail/utils/Utils;->setMenuItemVisibility(Landroid/view/Menu;IZ)V

    .line 633
    iget-object v5, p0, Lcom/android/mail/ui/MailActionBarView;->mAccount:Lcom/android/mail/providers/Account;

    invoke-virtual {v5, v10}, Lcom/android/mail/providers/Account;->supportsCapability(I)Z

    move-result v5

    if-eqz v5, :cond_7

    iget-object v5, p0, Lcom/android/mail/ui/MailActionBarView;->mFolder:Lcom/android/mail/providers/Folder;

    if-eqz v5, :cond_7

    iget-object v5, p0, Lcom/android/mail/ui/MailActionBarView;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-virtual {v5, v12}, Lcom/android/mail/providers/Folder;->supportsCapability(I)Z

    move-result v5

    if-eqz v5, :cond_7

    iget-object v5, p0, Lcom/android/mail/ui/MailActionBarView;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-virtual {v5}, Lcom/android/mail/providers/Folder;->isTrash()Z

    move-result v5

    if-nez v5, :cond_7

    move v0, v6

    .line 636
    .local v0, "archiveVisible":Z
    :goto_6
    const v5, 0x7f100123

    invoke-static {p1, v5, v0}, Lcom/android/mail/utils/Utils;->setMenuItemVisibility(Landroid/view/Menu;IZ)V

    .line 637
    const v8, 0x7f100124

    if-nez v0, :cond_8

    iget-object v5, p0, Lcom/android/mail/ui/MailActionBarView;->mFolder:Lcom/android/mail/providers/Folder;

    if-eqz v5, :cond_8

    iget-object v5, p0, Lcom/android/mail/ui/MailActionBarView;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-virtual {v5, v10}, Lcom/android/mail/providers/Folder;->supportsCapability(I)Z

    move-result v5

    if-eqz v5, :cond_8

    iget-object v5, p0, Lcom/android/mail/ui/MailActionBarView;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-virtual {v5}, Lcom/android/mail/providers/Folder;->isProviderFolder()Z

    move-result v5

    if-nez v5, :cond_8

    move v5, v6

    :goto_7
    invoke-static {p1, v8, v5}, Lcom/android/mail/utils/Utils;->setMenuItemVisibility(Landroid/view/Menu;IZ)V

    .line 640
    const v5, 0x7f100124

    invoke-interface {p1, v5}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v1

    .line 641
    .local v1, "removeFolder":Landroid/view/MenuItem;
    if-eqz v1, :cond_1

    .line 642
    iget-object v5, p0, Lcom/android/mail/ui/MailActionBarView;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v5}, Lcom/android/mail/ui/ControllableActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    const v8, 0x7f0c0040

    new-array v9, v6, [Ljava/lang/Object;

    iget-object v10, p0, Lcom/android/mail/ui/MailActionBarView;->mFolder:Lcom/android/mail/providers/Folder;

    iget-object v10, v10, Lcom/android/mail/providers/Folder;->name:Ljava/lang/String;

    aput-object v10, v9, v7

    invoke-virtual {v5, v8, v9}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-interface {v1, v5}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 645
    :cond_1
    const v8, 0x7f10012c

    iget-object v5, p0, Lcom/android/mail/ui/MailActionBarView;->mAccount:Lcom/android/mail/providers/Account;

    invoke-virtual {v5, v11}, Lcom/android/mail/providers/Account;->supportsCapability(I)Z

    move-result v5

    if-eqz v5, :cond_9

    iget-object v5, p0, Lcom/android/mail/ui/MailActionBarView;->mFolder:Lcom/android/mail/providers/Folder;

    if-eqz v5, :cond_9

    iget-object v5, p0, Lcom/android/mail/ui/MailActionBarView;->mFolder:Lcom/android/mail/providers/Folder;

    const/16 v9, 0x40

    invoke-virtual {v5, v9}, Lcom/android/mail/providers/Folder;->supportsCapability(I)Z

    move-result v5

    if-eqz v5, :cond_9

    iget-object v5, p0, Lcom/android/mail/ui/MailActionBarView;->mCurrentConversation:Lcom/android/mail/providers/Conversation;

    iget-boolean v5, v5, Lcom/android/mail/providers/Conversation;->spam:Z

    if-nez v5, :cond_9

    move v5, v6

    :goto_8
    invoke-static {p1, v8, v5}, Lcom/android/mail/utils/Utils;->setMenuItemVisibility(Landroid/view/Menu;IZ)V

    .line 649
    const v8, 0x7f10012d

    iget-object v5, p0, Lcom/android/mail/ui/MailActionBarView;->mAccount:Lcom/android/mail/providers/Account;

    invoke-virtual {v5, v11}, Lcom/android/mail/providers/Account;->supportsCapability(I)Z

    move-result v5

    if-eqz v5, :cond_a

    iget-object v5, p0, Lcom/android/mail/ui/MailActionBarView;->mFolder:Lcom/android/mail/providers/Folder;

    if-eqz v5, :cond_a

    iget-object v5, p0, Lcom/android/mail/ui/MailActionBarView;->mFolder:Lcom/android/mail/providers/Folder;

    const/16 v9, 0x80

    invoke-virtual {v5, v9}, Lcom/android/mail/providers/Folder;->supportsCapability(I)Z

    move-result v5

    if-eqz v5, :cond_a

    iget-object v5, p0, Lcom/android/mail/ui/MailActionBarView;->mCurrentConversation:Lcom/android/mail/providers/Conversation;

    iget-boolean v5, v5, Lcom/android/mail/providers/Conversation;->spam:Z

    if-eqz v5, :cond_a

    move v5, v6

    :goto_9
    invoke-static {p1, v8, v5}, Lcom/android/mail/utils/Utils;->setMenuItemVisibility(Landroid/view/Menu;IZ)V

    .line 653
    const v8, 0x7f10012e

    iget-object v5, p0, Lcom/android/mail/ui/MailActionBarView;->mAccount:Lcom/android/mail/providers/Account;

    const/4 v9, 0x4

    invoke-virtual {v5, v9}, Lcom/android/mail/providers/Account;->supportsCapability(I)Z

    move-result v5

    if-eqz v5, :cond_b

    iget-object v5, p0, Lcom/android/mail/ui/MailActionBarView;->mFolder:Lcom/android/mail/providers/Folder;

    if-eqz v5, :cond_b

    iget-object v5, p0, Lcom/android/mail/ui/MailActionBarView;->mFolder:Lcom/android/mail/providers/Folder;

    const/16 v9, 0x2000

    invoke-virtual {v5, v9}, Lcom/android/mail/providers/Folder;->supportsCapability(I)Z

    move-result v5

    if-eqz v5, :cond_b

    iget-object v5, p0, Lcom/android/mail/ui/MailActionBarView;->mCurrentConversation:Lcom/android/mail/providers/Conversation;

    iget-boolean v5, v5, Lcom/android/mail/providers/Conversation;->phishing:Z

    if-nez v5, :cond_b

    move v5, v6

    :goto_a
    invoke-static {p1, v8, v5}, Lcom/android/mail/utils/Utils;->setMenuItemVisibility(Landroid/view/Menu;IZ)V

    .line 657
    const v5, 0x7f10012b

    iget-object v8, p0, Lcom/android/mail/ui/MailActionBarView;->mAccount:Lcom/android/mail/providers/Account;

    invoke-virtual {v8, v12}, Lcom/android/mail/providers/Account;->supportsCapability(I)Z

    move-result v8

    if-eqz v8, :cond_c

    iget-object v8, p0, Lcom/android/mail/ui/MailActionBarView;->mFolder:Lcom/android/mail/providers/Folder;

    if-eqz v8, :cond_c

    iget-object v8, p0, Lcom/android/mail/ui/MailActionBarView;->mFolder:Lcom/android/mail/providers/Folder;

    const/16 v9, 0x100

    invoke-virtual {v8, v9}, Lcom/android/mail/providers/Folder;->supportsCapability(I)Z

    move-result v8

    if-eqz v8, :cond_c

    iget-object v8, p0, Lcom/android/mail/ui/MailActionBarView;->mCurrentConversation:Lcom/android/mail/providers/Conversation;

    iget-boolean v8, v8, Lcom/android/mail/providers/Conversation;->muted:Z

    if-nez v8, :cond_c

    :goto_b
    invoke-static {p1, v5, v6}, Lcom/android/mail/utils/Utils;->setMenuItemVisibility(Landroid/view/Menu;IZ)V

    goto/16 :goto_0

    .end local v0    # "archiveVisible":Z
    .end local v1    # "removeFolder":Landroid/view/MenuItem;
    .end local v2    # "showDelete":Z
    .end local v3    # "showDiscardDrafts":Z
    .end local v4    # "showMarkImportant":Z
    :cond_2
    move v4, v7

    .line 619
    goto/16 :goto_1

    .restart local v4    # "showMarkImportant":Z
    :cond_3
    move v5, v7

    .line 620
    goto/16 :goto_2

    :cond_4
    move v5, v7

    .line 622
    goto/16 :goto_3

    :cond_5
    move v2, v7

    .line 624
    goto/16 :goto_4

    .restart local v2    # "showDelete":Z
    :cond_6
    move v3, v7

    .line 630
    goto/16 :goto_5

    .restart local v3    # "showDiscardDrafts":Z
    :cond_7
    move v0, v7

    .line 633
    goto/16 :goto_6

    .restart local v0    # "archiveVisible":Z
    :cond_8
    move v5, v7

    .line 637
    goto/16 :goto_7

    .restart local v1    # "removeFolder":Landroid/view/MenuItem;
    :cond_9
    move v5, v7

    .line 645
    goto/16 :goto_8

    :cond_a
    move v5, v7

    .line 649
    goto :goto_9

    :cond_b
    move v5, v7

    .line 653
    goto :goto_a

    :cond_c
    move v6, v7

    .line 657
    goto :goto_b
.end method

.method public setCurrentConversation(Lcom/android/mail/providers/Conversation;)V
    .locals 0
    .param p1, "conversation"    # Lcom/android/mail/providers/Conversation;

    .prologue
    .line 611
    iput-object p1, p0, Lcom/android/mail/ui/MailActionBarView;->mCurrentConversation:Lcom/android/mail/providers/Conversation;

    .line 612
    return-void
.end method

.method protected setEmptyMode()V
    .locals 2

    .prologue
    const/16 v1, 0x8

    .line 430
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mSpinner:Lcom/android/mail/ui/MailSpinner;

    invoke-virtual {v0, v1}, Lcom/android/mail/ui/MailSpinner;->setVisibility(I)V

    .line 431
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mFolderView:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 432
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mFolderAccountName:Landroid/widget/TextView;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 433
    return-void
.end method

.method public setFolder(Lcom/android/mail/providers/Folder;)V
    .locals 1
    .param p1, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 288
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/android/mail/ui/MailActionBarView;->setRefreshInProgress(Z)Z

    .line 289
    iput-object p1, p0, Lcom/android/mail/ui/MailActionBarView;->mFolder:Lcom/android/mail/providers/Folder;

    .line 290
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mSpinner:Lcom/android/mail/ui/MailSpinner;

    invoke-virtual {v0, p1}, Lcom/android/mail/ui/MailSpinner;->setFolder(Lcom/android/mail/providers/Folder;)V

    .line 291
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->invalidateOptionsMenu()V

    .line 292
    return-void
.end method

.method public setSubject(Ljava/lang/String;)V
    .locals 1
    .param p1, "subject"    # Ljava/lang/String;

    .prologue
    .line 585
    iget-boolean v0, p0, Lcom/android/mail/ui/MailActionBarView;->mShowConversationSubject:Z

    if-nez v0, :cond_0

    .line 590
    :goto_0
    return-void

    .line 589
    :cond_0
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mSubjectView:Lcom/android/mail/browse/SnippetTextView;

    invoke-virtual {v0, p1}, Lcom/android/mail/browse/SnippetTextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method

.method protected showConversationSubject()Z
    .locals 3

    .prologue
    const/4 v0, 0x1

    .line 175
    iget v1, p0, Lcom/android/mail/ui/MailActionBarView;->mMode:I

    const/4 v2, 0x5

    if-eq v1, v2, :cond_0

    iget v1, p0, Lcom/android/mail/ui/MailActionBarView;->mMode:I

    if-ne v1, v0, :cond_1

    :cond_0
    iget-boolean v1, p0, Lcom/android/mail/ui/MailActionBarView;->mShowConversationSubject:Z

    if-eqz v1, :cond_1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method
