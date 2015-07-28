.class public Lcom/android/mail/browse/ConversationPagerController;
.super Ljava/lang/Object;
.source "ConversationPagerController.java"


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private mActivityController:Lcom/android/mail/ui/ActivityController;

.field private mFragmentManager:Landroid/app/FragmentManager;

.field private mInitialConversationLoading:Z

.field private final mLoadedObservable:Landroid/database/DataSetObservable;

.field private mPager:Landroid/support/v4/view/ViewPager;

.field private mPagerAdapter:Lcom/android/mail/browse/ConversationPagerAdapter;

.field private mShown:Z

.field private mSubjectDisplayChanger:Lcom/android/mail/ui/SubjectDisplayChanger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 76
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/browse/ConversationPagerController;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/android/mail/ui/RestrictedActivity;Lcom/android/mail/ui/ActivityController;)V
    .locals 1
    .param p1, "activity"    # Lcom/android/mail/ui/RestrictedActivity;
    .param p2, "controller"    # Lcom/android/mail/ui/ActivityController;

    .prologue
    .line 90
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 74
    new-instance v0, Landroid/database/DataSetObservable;

    invoke-direct {v0}, Landroid/database/DataSetObservable;-><init>()V

    iput-object v0, p0, Lcom/android/mail/browse/ConversationPagerController;->mLoadedObservable:Landroid/database/DataSetObservable;

    .line 91
    invoke-interface {p1}, Lcom/android/mail/ui/RestrictedActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/ConversationPagerController;->mFragmentManager:Landroid/app/FragmentManager;

    .line 92
    const v0, 0x7f1000ab

    invoke-interface {p1, v0}, Lcom/android/mail/ui/RestrictedActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v4/view/ViewPager;

    iput-object v0, p0, Lcom/android/mail/browse/ConversationPagerController;->mPager:Landroid/support/v4/view/ViewPager;

    .line 93
    iput-object p2, p0, Lcom/android/mail/browse/ConversationPagerController;->mActivityController:Lcom/android/mail/ui/ActivityController;

    .line 94
    invoke-interface {p2}, Lcom/android/mail/ui/ActivityController;->getSubjectDisplayChanger()Lcom/android/mail/ui/SubjectDisplayChanger;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/ConversationPagerController;->mSubjectDisplayChanger:Lcom/android/mail/ui/SubjectDisplayChanger;

    .line 96
    invoke-interface {p1}, Lcom/android/mail/ui/RestrictedActivity;->getActivityContext()Landroid/content/Context;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/android/mail/browse/ConversationPagerController;->setupPageMargin(Landroid/content/Context;)V

    .line 97
    return-void
.end method

.method private cleanup()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 174
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerController;->mPagerAdapter:Lcom/android/mail/browse/ConversationPagerAdapter;

    if-eqz v0, :cond_0

    .line 176
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerController;->mPagerAdapter:Lcom/android/mail/browse/ConversationPagerAdapter;

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/ConversationPagerAdapter;->setActivityController(Lcom/android/mail/ui/ActivityController;)V

    .line 177
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerController;->mPagerAdapter:Lcom/android/mail/browse/ConversationPagerAdapter;

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/ConversationPagerAdapter;->setPager(Landroid/support/v4/view/ViewPager;)V

    .line 178
    iput-object v1, p0, Lcom/android/mail/browse/ConversationPagerController;->mPagerAdapter:Lcom/android/mail/browse/ConversationPagerAdapter;

    .line 180
    :cond_0
    return-void
.end method

.method private setupPageMargin(Landroid/content/Context;)V
    .locals 7
    .param p1, "c"    # Landroid/content/Context;

    .prologue
    const/4 v3, 0x0

    .line 220
    const/4 v4, 0x1

    new-array v4, v4, [I

    const v5, 0x1010214

    aput v5, v4, v3

    invoke-virtual {p1, v4}, Landroid/content/Context;->obtainStyledAttributes([I)Landroid/content/res/TypedArray;

    move-result-object v6

    .line 221
    .local v6, "a":Landroid/content/res/TypedArray;
    invoke-virtual {v6, v3}, Landroid/content/res/TypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    .line 222
    .local v1, "divider":Landroid/graphics/drawable/Drawable;
    invoke-virtual {v6}, Landroid/content/res/TypedArray;->recycle()V

    .line 223
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f0b002a

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v2

    .line 225
    .local v2, "padding":I
    new-instance v0, Landroid/graphics/drawable/InsetDrawable;

    move v4, v2

    move v5, v3

    invoke-direct/range {v0 .. v5}, Landroid/graphics/drawable/InsetDrawable;-><init>(Landroid/graphics/drawable/Drawable;IIII)V

    .line 226
    .local v0, "gutterDrawable":Landroid/graphics/drawable/Drawable;
    iget-object v3, p0, Lcom/android/mail/browse/ConversationPagerController;->mPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v4

    mul-int/lit8 v5, v2, 0x2

    add-int/2addr v4, v5

    invoke-virtual {v3, v4}, Landroid/support/v4/view/ViewPager;->setPageMargin(I)V

    .line 227
    iget-object v3, p0, Lcom/android/mail/browse/ConversationPagerController;->mPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v3, v0}, Landroid/support/v4/view/ViewPager;->setPageMarginDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 228
    return-void
.end method


# virtual methods
.method public hide(Z)V
    .locals 3
    .param p1, "changeVisibility"    # Z

    .prologue
    const/4 v2, 0x0

    .line 148
    iget-boolean v0, p0, Lcom/android/mail/browse/ConversationPagerController;->mShown:Z

    if-nez v0, :cond_0

    .line 149
    sget-object v0, Lcom/android/mail/browse/ConversationPagerController;->LOG_TAG:Ljava/lang/String;

    const-string v1, "IN CPC.hide, but already hidden"

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 162
    :goto_0
    return-void

    .line 152
    :cond_0
    iput-boolean v2, p0, Lcom/android/mail/browse/ConversationPagerController;->mShown:Z

    .line 153
    if-eqz p1, :cond_1

    .line 154
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerController;->mPager:Landroid/support/v4/view/ViewPager;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/support/v4/view/ViewPager;->setVisibility(I)V

    .line 157
    :cond_1
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerController;->mSubjectDisplayChanger:Lcom/android/mail/ui/SubjectDisplayChanger;

    invoke-interface {v0}, Lcom/android/mail/ui/SubjectDisplayChanger;->clearSubject()V

    .line 159
    sget-object v0, Lcom/android/mail/browse/ConversationPagerController;->LOG_TAG:Ljava/lang/String;

    const-string v1, "IN CPC.hide, clearing adapter and unregistering list observer"

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 160
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerController;->mPager:Landroid/support/v4/view/ViewPager;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/view/ViewPager;->setAdapter(Landroid/support/v4/view/PagerAdapter;)V

    .line 161
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationPagerController;->cleanup()V

    goto :goto_0
.end method

.method public isInitialConversationLoading()Z
    .locals 1

    .prologue
    .line 165
    iget-boolean v0, p0, Lcom/android/mail/browse/ConversationPagerController;->mInitialConversationLoading:Z

    return v0
.end method

.method public onConversationSeen(Lcom/android/mail/providers/Conversation;)V
    .locals 4
    .param p1, "conv"    # Lcom/android/mail/providers/Conversation;

    .prologue
    const/4 v3, 0x0

    .line 183
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerController;->mPagerAdapter:Lcom/android/mail/browse/ConversationPagerAdapter;

    if-nez v0, :cond_1

    .line 199
    :cond_0
    :goto_0
    return-void

    .line 189
    :cond_1
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerController;->mPagerAdapter:Lcom/android/mail/browse/ConversationPagerAdapter;

    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationPagerAdapter;->isSingletonMode()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 190
    sget-object v0, Lcom/android/mail/browse/ConversationPagerController;->LOG_TAG:Ljava/lang/String;

    const-string v1, "IN pager adapter, finished loading primary conversation, switching to cursor mode to load other conversations"

    new-array v2, v3, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 192
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerController;->mPagerAdapter:Lcom/android/mail/browse/ConversationPagerAdapter;

    invoke-virtual {v0, v3}, Lcom/android/mail/browse/ConversationPagerAdapter;->setSingletonMode(Z)V

    .line 195
    :cond_2
    iget-boolean v0, p0, Lcom/android/mail/browse/ConversationPagerController;->mInitialConversationLoading:Z

    if-eqz v0, :cond_0

    .line 196
    iput-boolean v3, p0, Lcom/android/mail/browse/ConversationPagerController;->mInitialConversationLoading:Z

    .line 197
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerController;->mLoadedObservable:Landroid/database/DataSetObservable;

    invoke-virtual {v0}, Landroid/database/DataSetObservable;->notifyChanged()V

    goto :goto_0
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 170
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationPagerController;->cleanup()V

    .line 171
    return-void
.end method

.method public registerConversationLoadedObserver(Landroid/database/DataSetObserver;)V
    .locals 1
    .param p1, "observer"    # Landroid/database/DataSetObserver;

    .prologue
    .line 202
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerController;->mLoadedObservable:Landroid/database/DataSetObservable;

    invoke-virtual {v0, p1}, Landroid/database/DataSetObservable;->registerObserver(Ljava/lang/Object;)V

    .line 203
    return-void
.end method

.method public show(Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;Lcom/android/mail/providers/Conversation;Z)V
    .locals 10
    .param p1, "account"    # Lcom/android/mail/providers/Account;
    .param p2, "folder"    # Lcom/android/mail/providers/Folder;
    .param p3, "initialConversation"    # Lcom/android/mail/providers/Conversation;
    .param p4, "changeVisibility"    # Z

    .prologue
    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 101
    iput-boolean v9, p0, Lcom/android/mail/browse/ConversationPagerController;->mInitialConversationLoading:Z

    .line 103
    iget-boolean v0, p0, Lcom/android/mail/browse/ConversationPagerController;->mShown:Z

    if-eqz v0, :cond_1

    .line 104
    sget-object v0, Lcom/android/mail/browse/ConversationPagerController;->LOG_TAG:Ljava/lang/String;

    const-string v1, "IN CPC.show, but already shown"

    new-array v2, v8, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 108
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerController;->mPagerAdapter:Lcom/android/mail/browse/ConversationPagerAdapter;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerController;->mPagerAdapter:Lcom/android/mail/browse/ConversationPagerAdapter;

    invoke-virtual {v0, p1, p2}, Lcom/android/mail/browse/ConversationPagerAdapter;->matches(Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerController;->mPagerAdapter:Lcom/android/mail/browse/ConversationPagerAdapter;

    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationPagerAdapter;->isDetached()Z

    move-result v0

    if-nez v0, :cond_0

    .line 110
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerController;->mPagerAdapter:Lcom/android/mail/browse/ConversationPagerAdapter;

    invoke-virtual {v0, p3}, Lcom/android/mail/browse/ConversationPagerAdapter;->getConversationPosition(Lcom/android/mail/providers/Conversation;)I

    move-result v7

    .line 111
    .local v7, "pos":I
    if-ltz v7, :cond_0

    .line 112
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerController;->mPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v0, v7}, Landroid/support/v4/view/ViewPager;->setCurrentItem(I)V

    .line 145
    .end local v7    # "pos":I
    :goto_0
    return-void

    .line 117
    :cond_0
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationPagerController;->cleanup()V

    .line 120
    :cond_1
    if-eqz p4, :cond_2

    .line 121
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerController;->mPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v0, v8}, Landroid/support/v4/view/ViewPager;->setVisibility(I)V

    .line 124
    :cond_2
    new-instance v0, Lcom/android/mail/browse/ConversationPagerAdapter;

    iget-object v1, p0, Lcom/android/mail/browse/ConversationPagerController;->mPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v1}, Landroid/support/v4/view/ViewPager;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/browse/ConversationPagerController;->mFragmentManager:Landroid/app/FragmentManager;

    move-object v3, p1

    move-object v4, p2

    move-object v5, p3

    invoke-direct/range {v0 .. v5}, Lcom/android/mail/browse/ConversationPagerAdapter;-><init>(Landroid/content/res/Resources;Landroid/app/FragmentManager;Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;Lcom/android/mail/providers/Conversation;)V

    iput-object v0, p0, Lcom/android/mail/browse/ConversationPagerController;->mPagerAdapter:Lcom/android/mail/browse/ConversationPagerAdapter;

    .line 126
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerController;->mPagerAdapter:Lcom/android/mail/browse/ConversationPagerAdapter;

    invoke-virtual {v0, v8}, Lcom/android/mail/browse/ConversationPagerAdapter;->setSingletonMode(Z)V

    .line 127
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerController;->mPagerAdapter:Lcom/android/mail/browse/ConversationPagerAdapter;

    iget-object v1, p0, Lcom/android/mail/browse/ConversationPagerController;->mActivityController:Lcom/android/mail/ui/ActivityController;

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/ConversationPagerAdapter;->setActivityController(Lcom/android/mail/ui/ActivityController;)V

    .line 128
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerController;->mPagerAdapter:Lcom/android/mail/browse/ConversationPagerAdapter;

    iget-object v1, p0, Lcom/android/mail/browse/ConversationPagerController;->mPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/ConversationPagerAdapter;->setPager(Landroid/support/v4/view/ViewPager;)V

    .line 129
    sget-object v0, Lcom/android/mail/browse/ConversationPagerController;->LOG_TAG:Ljava/lang/String;

    const-string v1, "IN CPC.show, adapter=%s"

    new-array v2, v9, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/android/mail/browse/ConversationPagerController;->mPagerAdapter:Lcom/android/mail/browse/ConversationPagerAdapter;

    aput-object v3, v2, v8

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 131
    sget-object v0, Lcom/android/mail/browse/ConversationPagerController;->LOG_TAG:Ljava/lang/String;

    const-string v1, "init pager adapter, count=%d initial=%s"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/android/mail/browse/ConversationPagerController;->mPagerAdapter:Lcom/android/mail/browse/ConversationPagerAdapter;

    invoke-virtual {v3}, Lcom/android/mail/browse/ConversationPagerAdapter;->getCount()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v8

    iget-object v3, p3, Lcom/android/mail/providers/Conversation;->subject:Ljava/lang/String;

    aput-object v3, v2, v9

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 133
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerController;->mPager:Landroid/support/v4/view/ViewPager;

    iget-object v1, p0, Lcom/android/mail/browse/ConversationPagerController;->mPagerAdapter:Lcom/android/mail/browse/ConversationPagerAdapter;

    invoke-virtual {v0, v1}, Landroid/support/v4/view/ViewPager;->setAdapter(Landroid/support/v4/view/PagerAdapter;)V

    .line 137
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerController;->mPagerAdapter:Lcom/android/mail/browse/ConversationPagerAdapter;

    invoke-virtual {v0, p3}, Lcom/android/mail/browse/ConversationPagerAdapter;->getConversationPosition(Lcom/android/mail/providers/Conversation;)I

    move-result v6

    .line 138
    .local v6, "initialPos":I
    if-ltz v6, :cond_3

    .line 139
    sget-object v0, Lcom/android/mail/browse/ConversationPagerController;->LOG_TAG:Ljava/lang/String;

    const-string v1, "*** pager fragment init pos=%d"

    new-array v2, v9, [Ljava/lang/Object;

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v8

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 140
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerController;->mPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v0, v6}, Landroid/support/v4/view/ViewPager;->setCurrentItem(I)V

    .line 144
    :cond_3
    iput-boolean v9, p0, Lcom/android/mail/browse/ConversationPagerController;->mShown:Z

    goto :goto_0
.end method

.method public stopListening()V
    .locals 2

    .prologue
    .line 214
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerController;->mPagerAdapter:Lcom/android/mail/browse/ConversationPagerAdapter;

    if-eqz v0, :cond_0

    .line 215
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerController;->mPagerAdapter:Lcom/android/mail/browse/ConversationPagerAdapter;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/ConversationPagerAdapter;->setActivityController(Lcom/android/mail/ui/ActivityController;)V

    .line 217
    :cond_0
    return-void
.end method

.method public unregisterConversationLoadedObserver(Landroid/database/DataSetObserver;)V
    .locals 1
    .param p1, "observer"    # Landroid/database/DataSetObserver;

    .prologue
    .line 206
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerController;->mLoadedObservable:Landroid/database/DataSetObservable;

    invoke-virtual {v0, p1}, Landroid/database/DataSetObservable;->unregisterObserver(Ljava/lang/Object;)V

    .line 207
    return-void
.end method
