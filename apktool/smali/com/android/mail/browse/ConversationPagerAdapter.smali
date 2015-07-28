.class public Lcom/android/mail/browse/ConversationPagerAdapter;
.super Lcom/android/mail/utils/FragmentStatePagerAdapter2;
.source "ConversationPagerAdapter.java"

# interfaces
.implements Landroid/support/v4/view/ViewPager$OnPageChangeListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/browse/ConversationPagerAdapter$1;,
        Lcom/android/mail/browse/ConversationPagerAdapter$ListObserver;,
        Lcom/android/mail/browse/ConversationPagerAdapter$FolderObserver;
    }
.end annotation


# static fields
.field private static final BUNDLE_DETACHED_MODE:Ljava/lang/String;

.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private final mAccount:Lcom/android/mail/providers/Account;

.field private final mCommonFragmentArgs:Landroid/os/Bundle;

.field private mController:Lcom/android/mail/ui/ActivityController;

.field private mDetachedMode:Z

.field private final mFolder:Lcom/android/mail/providers/Folder;

.field private final mFolderObserver:Landroid/database/DataSetObserver;

.field private final mInitialConversation:Lcom/android/mail/providers/Conversation;

.field private final mListObserver:Landroid/database/DataSetObserver;

.field private mPager:Landroid/support/v4/view/ViewPager;

.field private mResources:Landroid/content/res/Resources;

.field private mSafeToNotify:Z

.field private mSanitizedHtml:Z

.field private mSingletonMode:Z


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 89
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/browse/ConversationPagerAdapter;->LOG_TAG:Ljava/lang/String;

    .line 91
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-class v1, Lcom/android/mail/browse/ConversationPagerAdapter;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "-detachedmode"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/browse/ConversationPagerAdapter;->BUNDLE_DETACHED_MODE:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/res/Resources;Landroid/app/FragmentManager;Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;Lcom/android/mail/providers/Conversation;)V
    .locals 3
    .param p1, "res"    # Landroid/content/res/Resources;
    .param p2, "fm"    # Landroid/app/FragmentManager;
    .param p3, "account"    # Lcom/android/mail/providers/Account;
    .param p4, "folder"    # Lcom/android/mail/providers/Folder;
    .param p5, "initialConversation"    # Lcom/android/mail/providers/Conversation;

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 96
    invoke-direct {p0, p2, v1}, Lcom/android/mail/utils/FragmentStatePagerAdapter2;-><init>(Landroid/app/FragmentManager;Z)V

    .line 46
    new-instance v0, Lcom/android/mail/browse/ConversationPagerAdapter$ListObserver;

    invoke-direct {v0, p0, v2}, Lcom/android/mail/browse/ConversationPagerAdapter$ListObserver;-><init>(Lcom/android/mail/browse/ConversationPagerAdapter;Lcom/android/mail/browse/ConversationPagerAdapter$1;)V

    iput-object v0, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mListObserver:Landroid/database/DataSetObserver;

    .line 47
    new-instance v0, Lcom/android/mail/browse/ConversationPagerAdapter$FolderObserver;

    invoke-direct {v0, p0, v2}, Lcom/android/mail/browse/ConversationPagerAdapter$FolderObserver;-><init>(Lcom/android/mail/browse/ConversationPagerAdapter;Lcom/android/mail/browse/ConversationPagerAdapter$1;)V

    iput-object v0, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mFolderObserver:Landroid/database/DataSetObserver;

    .line 57
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mSingletonMode:Z

    .line 61
    iput-boolean v1, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mDetachedMode:Z

    .line 97
    iput-object p1, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mResources:Landroid/content/res/Resources;

    .line 98
    invoke-static {p3, p4}, Lcom/android/mail/ui/AbstractConversationViewFragment;->makeBasicArgs(Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;)Landroid/os/Bundle;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mCommonFragmentArgs:Landroid/os/Bundle;

    .line 99
    iput-object p5, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mInitialConversation:Lcom/android/mail/providers/Conversation;

    .line 100
    iput-object p3, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mAccount:Lcom/android/mail/providers/Account;

    .line 101
    iput-object p4, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mFolder:Lcom/android/mail/providers/Folder;

    .line 102
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mAccount:Lcom/android/mail/providers/Account;

    const/16 v1, 0x80

    invoke-virtual {v0, v1}, Lcom/android/mail/providers/Account;->supportsCapability(I)Z

    move-result v0

    iput-boolean v0, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mSanitizedHtml:Z

    .line 104
    return-void
.end method

.method private getConversationViewFragment(Lcom/android/mail/providers/Conversation;)Lcom/android/mail/ui/AbstractConversationViewFragment;
    .locals 1
    .param p1, "c"    # Lcom/android/mail/providers/Conversation;

    .prologue
    .line 178
    iget-boolean v0, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mSanitizedHtml:Z

    if-eqz v0, :cond_0

    .line 179
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mCommonFragmentArgs:Landroid/os/Bundle;

    invoke-static {v0, p1}, Lcom/android/mail/ui/ConversationViewFragment;->newInstance(Landroid/os/Bundle;Lcom/android/mail/providers/Conversation;)Lcom/android/mail/ui/ConversationViewFragment;

    move-result-object v0

    .line 181
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mCommonFragmentArgs:Landroid/os/Bundle;

    invoke-static {v0, p1}, Lcom/android/mail/browse/SecureConversationViewFragment;->newInstance(Landroid/os/Bundle;Lcom/android/mail/providers/Conversation;)Lcom/android/mail/browse/SecureConversationViewFragment;

    move-result-object v0

    goto :goto_0
.end method

.method private getCursor()Landroid/database/Cursor;
    .locals 3

    .prologue
    .line 131
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mController:Lcom/android/mail/ui/ActivityController;

    if-nez v0, :cond_0

    .line 135
    sget-object v0, Lcom/android/mail/browse/ConversationPagerAdapter;->LOG_TAG:Ljava/lang/String;

    const-string v1, "Pager adapter has a null controller. If the conversation view is going away, this is fine.  Otherwise, the state is inconsistent"

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 137
    const/4 v0, 0x0

    .line 140
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v0}, Lcom/android/mail/ui/ActivityController;->getConversationListCursor()Lcom/android/mail/browse/ConversationCursor;

    move-result-object v0

    goto :goto_0
.end method

.method private getDefaultConversation()Lcom/android/mail/providers/Conversation;
    .locals 2

    .prologue
    .line 325
    iget-object v1, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mController:Lcom/android/mail/ui/ActivityController;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v1}, Lcom/android/mail/ui/ActivityController;->getCurrentConversation()Lcom/android/mail/providers/Conversation;

    move-result-object v0

    .line 326
    .local v0, "c":Lcom/android/mail/providers/Conversation;
    :goto_0
    if-nez v0, :cond_0

    .line 327
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mInitialConversation:Lcom/android/mail/providers/Conversation;

    .line 329
    :cond_0
    return-object v0

    .line 325
    .end local v0    # "c":Lcom/android/mail/providers/Conversation;
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public finishUpdate(Landroid/view/ViewGroup;)V
    .locals 1
    .param p1, "container"    # Landroid/view/ViewGroup;

    .prologue
    .line 269
    invoke-super {p0, p1}, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->finishUpdate(Landroid/view/ViewGroup;)V

    .line 270
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mSafeToNotify:Z

    .line 271
    return-void
.end method

.method public getConversationPosition(Lcom/android/mail/providers/Conversation;)I
    .locals 12
    .param p1, "conv"    # Lcom/android/mail/providers/Conversation;

    .prologue
    const/4 v11, 0x1

    const/4 v5, -0x2

    const/4 v6, 0x0

    .line 333
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationPagerAdapter;->isPagingDisabled()Z

    move-result v7

    if-eqz v7, :cond_3

    .line 334
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationPagerAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v7

    if-nez v7, :cond_1

    .line 368
    :cond_0
    :goto_0
    return v5

    .line 338
    :cond_1
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationPagerAdapter;->getDefaultConversation()Lcom/android/mail/providers/Conversation;

    move-result-object v7

    if-eq p1, v7, :cond_2

    .line 339
    sget-object v7, Lcom/android/mail/browse/ConversationPagerAdapter;->LOG_TAG:Ljava/lang/String;

    const-string v8, "unable to find conversation in singleton mode. c=%s"

    new-array v9, v11, [Ljava/lang/Object;

    aput-object p1, v9, v6

    invoke-static {v7, v8, v9}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0

    :cond_2
    move v5, v6

    .line 342
    goto :goto_0

    .line 345
    :cond_3
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationPagerAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v0

    .line 346
    .local v0, "cursor":Landroid/database/Cursor;
    if-eqz v0, :cond_0

    if-eqz p1, :cond_0

    .line 350
    invoke-static {v0}, Lcom/android/mail/utils/Utils;->disableConversationCursorNetworkAccess(Landroid/database/Cursor;)Z

    move-result v3

    .line 352
    .local v3, "networkWasEnabled":Z
    const/4 v5, -0x2

    .line 353
    .local v5, "result":I
    const/4 v4, -0x1

    .line 354
    .local v4, "pos":I
    :cond_4
    add-int/lit8 v4, v4, 0x1

    invoke-interface {v0, v4}, Landroid/database/Cursor;->moveToPosition(I)Z

    move-result v7

    if-eqz v7, :cond_5

    .line 355
    invoke-interface {v0, v6}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v1

    .line 356
    .local v1, "id":J
    iget-wide v7, p1, Lcom/android/mail/providers/Conversation;->id:J

    cmp-long v7, v7, v1

    if-nez v7, :cond_4

    .line 357
    sget-object v7, Lcom/android/mail/browse/ConversationPagerAdapter;->LOG_TAG:Ljava/lang/String;

    const-string v8, "pager adapter found repositioned convo \'%s\' at pos=%d"

    const/4 v9, 0x2

    new-array v9, v9, [Ljava/lang/Object;

    iget-object v10, p1, Lcom/android/mail/providers/Conversation;->subject:Ljava/lang/String;

    aput-object v10, v9, v6

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v9, v11

    invoke-static {v7, v8, v9}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 359
    move v5, v4

    .line 364
    .end local v1    # "id":J
    :cond_5
    if-eqz v3, :cond_0

    .line 365
    invoke-static {v0}, Lcom/android/mail/utils/Utils;->enableConversationCursorNetworkAccess(Landroid/database/Cursor;)Z

    goto :goto_0
.end method

.method public getCount()I
    .locals 7

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 187
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationPagerAdapter;->isPagingDisabled()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 188
    sget-object v3, Lcom/android/mail/browse/ConversationPagerAdapter;->LOG_TAG:Ljava/lang/String;

    const-string v4, "IN CPA.getCount, returning 1 (effective singleton). cursor=%s"

    new-array v5, v1, [Ljava/lang/Object;

    invoke-direct {p0}, Lcom/android/mail/browse/ConversationPagerAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v6

    aput-object v6, v5, v2

    invoke-static {v3, v4, v5}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 196
    :goto_0
    return v1

    .line 192
    :cond_0
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationPagerAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v0

    .line 193
    .local v0, "cursor":Landroid/database/Cursor;
    if-nez v0, :cond_1

    move v1, v2

    .line 194
    goto :goto_0

    .line 196
    :cond_1
    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    move-result v1

    goto :goto_0
.end method

.method public getItem(I)Landroid/app/Fragment;
    .locals 10
    .param p1, "position"    # I

    .prologue
    const/4 v2, 0x0

    const/4 v9, 0x2

    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 147
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationPagerAdapter;->isPagingDisabled()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 150
    if-eqz p1, :cond_0

    .line 151
    sget-object v3, Lcom/android/mail/browse/ConversationPagerAdapter;->LOG_TAG:Ljava/lang/String;

    const-string v4, "pager cursor is null and position is non-zero: %d"

    new-array v5, v8, [Ljava/lang/Object;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v5, v7

    invoke-static {v3, v4, v5}, Lcom/android/mail/utils/LogUtils;->wtf(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 154
    :cond_0
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationPagerAdapter;->getDefaultConversation()Lcom/android/mail/providers/Conversation;

    move-result-object v0

    .line 155
    .local v0, "c":Lcom/android/mail/providers/Conversation;
    iput v7, v0, Lcom/android/mail/providers/Conversation;->position:I

    .line 172
    :goto_0
    invoke-direct {p0, v0}, Lcom/android/mail/browse/ConversationPagerAdapter;->getConversationViewFragment(Lcom/android/mail/providers/Conversation;)Lcom/android/mail/ui/AbstractConversationViewFragment;

    move-result-object v2

    .line 173
    .local v2, "f":Landroid/app/Fragment;
    sget-object v3, Lcom/android/mail/browse/ConversationPagerAdapter;->LOG_TAG:Ljava/lang/String;

    const-string v4, "IN PagerAdapter.getItem, frag=%s subj=%s"

    new-array v5, v9, [Ljava/lang/Object;

    aput-object v2, v5, v7

    iget-object v6, v0, Lcom/android/mail/providers/Conversation;->subject:Ljava/lang/String;

    aput-object v6, v5, v8

    invoke-static {v3, v4, v5}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 174
    .end local v0    # "c":Lcom/android/mail/providers/Conversation;
    .end local v2    # "f":Landroid/app/Fragment;
    :goto_1
    return-object v2

    .line 157
    :cond_1
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationPagerAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v1

    .line 158
    .local v1, "cursor":Landroid/database/Cursor;
    if-nez v1, :cond_2

    .line 159
    sget-object v3, Lcom/android/mail/browse/ConversationPagerAdapter;->LOG_TAG:Ljava/lang/String;

    const-string v4, "unable to get ConversationCursor, pos=%d"

    new-array v5, v8, [Ljava/lang/Object;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v5, v7

    invoke-static {v3, v4, v5}, Lcom/android/mail/utils/LogUtils;->wtf(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_1

    .line 162
    :cond_2
    invoke-interface {v1, p1}, Landroid/database/Cursor;->moveToPosition(I)Z

    move-result v3

    if-nez v3, :cond_3

    .line 163
    sget-object v3, Lcom/android/mail/browse/ConversationPagerAdapter;->LOG_TAG:Ljava/lang/String;

    const-string v4, "unable to seek to ConversationCursor pos=%d (%s)"

    new-array v5, v9, [Ljava/lang/Object;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v5, v7

    aput-object v1, v5, v8

    invoke-static {v3, v4, v5}, Lcom/android/mail/utils/LogUtils;->wtf(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_1

    .line 169
    :cond_3
    new-instance v0, Lcom/android/mail/providers/Conversation;

    invoke-direct {v0, v1}, Lcom/android/mail/providers/Conversation;-><init>(Landroid/database/Cursor;)V

    .line 170
    .restart local v0    # "c":Lcom/android/mail/providers/Conversation;
    iput p1, v0, Lcom/android/mail/providers/Conversation;->position:I

    goto :goto_0
.end method

.method public getItemPosition(Ljava/lang/Object;)I
    .locals 5
    .param p1, "item"    # Ljava/lang/Object;

    .prologue
    .line 201
    instance-of v1, p1, Lcom/android/mail/ui/AbstractConversationViewFragment;

    if-nez v1, :cond_0

    .line 202
    sget-object v1, Lcom/android/mail/browse/ConversationPagerAdapter;->LOG_TAG:Ljava/lang/String;

    const-string v2, "getItemPosition received unexpected item: %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p1, v3, v4

    invoke-static {v1, v2, v3}, Lcom/android/mail/utils/LogUtils;->wtf(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    :cond_0
    move-object v0, p1

    .line 205
    check-cast v0, Lcom/android/mail/ui/AbstractConversationViewFragment;

    .line 206
    .local v0, "fragment":Lcom/android/mail/ui/AbstractConversationViewFragment;
    invoke-virtual {v0}, Lcom/android/mail/ui/AbstractConversationViewFragment;->getConversation()Lcom/android/mail/providers/Conversation;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/android/mail/browse/ConversationPagerAdapter;->getConversationPosition(Lcom/android/mail/providers/Conversation;)I

    move-result v1

    return v1
.end method

.method public getPageTitle(I)Ljava/lang/CharSequence;
    .locals 9
    .param p1, "position"    # I

    .prologue
    .line 219
    iget-object v4, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v4}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v0

    .line 221
    .local v0, "currentPosition":I
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationPagerAdapter;->isPagingDisabled()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 222
    const/4 v2, 0x0

    .line 236
    .local v2, "title":Ljava/lang/String;
    :goto_0
    return-object v2

    .line 223
    .end local v2    # "title":Ljava/lang/String;
    :cond_0
    if-ne p1, v0, :cond_2

    .line 224
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationPagerAdapter;->getCount()I

    move-result v3

    .line 225
    .local v3, "total":I
    iget-object v4, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mController:Lcom/android/mail/ui/ActivityController;

    if-eqz v4, :cond_1

    .line 226
    iget-object v4, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v4}, Lcom/android/mail/ui/ActivityController;->getFolder()Lcom/android/mail/providers/Folder;

    move-result-object v1

    .line 227
    .local v1, "f":Lcom/android/mail/providers/Folder;
    if-eqz v1, :cond_1

    iget v4, v1, Lcom/android/mail/providers/Folder;->totalCount:I

    if-le v4, v3, :cond_1

    .line 228
    iget v3, v1, Lcom/android/mail/providers/Folder;->totalCount:I

    .line 231
    .end local v1    # "f":Lcom/android/mail/providers/Folder;
    :cond_1
    iget-object v4, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mResources:Landroid/content/res/Resources;

    const v5, 0x7f0c00af

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    add-int/lit8 v8, p1, 0x1

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v6, v7

    const/4 v7, 0x1

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-virtual {v4, v5, v6}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 232
    .restart local v2    # "title":Ljava/lang/String;
    goto :goto_0

    .line 233
    .end local v2    # "title":Ljava/lang/String;
    .end local v3    # "total":I
    :cond_2
    iget-object v5, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mResources:Landroid/content/res/Resources;

    if-ge p1, v0, :cond_3

    const v4, 0x7f0c00b0

    :goto_1
    invoke-virtual {v5, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    .restart local v2    # "title":Ljava/lang/String;
    goto :goto_0

    .end local v2    # "title":Ljava/lang/String;
    :cond_3
    const v4, 0x7f0c00b1

    goto :goto_1
.end method

.method public isDetached()Z
    .locals 1

    .prologue
    .line 123
    iget-boolean v0, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mDetachedMode:Z

    return v0
.end method

.method public isPagingDisabled()Z
    .locals 1

    .prologue
    .line 127
    iget-boolean v0, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mSingletonMode:Z

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mDetachedMode:Z

    if-nez v0, :cond_0

    invoke-direct {p0}, Lcom/android/mail/browse/ConversationPagerAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v0

    if-nez v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isSingletonMode()Z
    .locals 1

    .prologue
    .line 119
    iget-boolean v0, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mSingletonMode:Z

    return v0
.end method

.method public matches(Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;)Z
    .locals 1
    .param p1, "account"    # Lcom/android/mail/providers/Account;
    .param p2, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 107
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mAccount:Lcom/android/mail/providers/Account;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mFolder:Lcom/android/mail/providers/Folder;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mAccount:Lcom/android/mail/providers/Account;

    invoke-virtual {v0, p1}, Lcom/android/mail/providers/Account;->matches(Lcom/android/mail/providers/Account;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-virtual {v0, p2}, Lcom/android/mail/providers/Folder;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public notifyDataSetChanged()V
    .locals 10

    .prologue
    const/4 v7, 0x1

    const/4 v9, 0x0

    .line 275
    iget-boolean v5, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mSafeToNotify:Z

    if-nez v5, :cond_0

    .line 276
    sget-object v5, Lcom/android/mail/browse/ConversationPagerAdapter;->LOG_TAG:Ljava/lang/String;

    const-string v6, "IN PagerAdapter.notifyDataSetChanged, ignoring unsafe update"

    new-array v7, v9, [Ljava/lang/Object;

    invoke-static {v5, v6, v7}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 315
    :goto_0
    return-void

    .line 287
    :cond_0
    iget-object v5, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mController:Lcom/android/mail/ui/ActivityController;

    if-eqz v5, :cond_1

    .line 288
    iget-object v5, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v5}, Lcom/android/mail/ui/ActivityController;->getCurrentConversation()Lcom/android/mail/providers/Conversation;

    move-result-object v1

    .line 289
    .local v1, "currConversation":Lcom/android/mail/providers/Conversation;
    invoke-virtual {p0, v1}, Lcom/android/mail/browse/ConversationPagerAdapter;->getConversationPosition(Lcom/android/mail/providers/Conversation;)I

    move-result v4

    .line 290
    .local v4, "pos":I
    const/4 v5, -0x2

    if-ne v4, v5, :cond_2

    invoke-direct {p0}, Lcom/android/mail/browse/ConversationPagerAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v5

    if-eqz v5, :cond_2

    if-eqz v1, :cond_2

    .line 293
    iput-boolean v7, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mDetachedMode:Z

    .line 294
    sget-object v5, Lcom/android/mail/browse/ConversationPagerAdapter;->LOG_TAG:Ljava/lang/String;

    const-string v6, "CPA: current conv is gone, reverting to detached mode. c=%s"

    new-array v7, v7, [Ljava/lang/Object;

    iget-object v8, v1, Lcom/android/mail/providers/Conversation;->uri:Landroid/net/Uri;

    aput-object v8, v7, v9

    invoke-static {v5, v6, v7}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 314
    .end local v1    # "currConversation":Lcom/android/mail/providers/Conversation;
    .end local v4    # "pos":I
    :cond_1
    :goto_1
    invoke-super {p0}, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->notifyDataSetChanged()V

    goto :goto_0

    .line 301
    .restart local v1    # "currConversation":Lcom/android/mail/providers/Conversation;
    .restart local v4    # "pos":I
    :cond_2
    invoke-virtual {p0, v4}, Lcom/android/mail/browse/ConversationPagerAdapter;->getFragmentAt(I)Landroid/app/Fragment;

    move-result-object v3

    check-cast v3, Lcom/android/mail/ui/AbstractConversationViewFragment;

    .line 303
    .local v3, "frag":Lcom/android/mail/ui/AbstractConversationViewFragment;
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationPagerAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v2

    .line 304
    .local v2, "cursor":Landroid/database/Cursor;
    if-eqz v3, :cond_1

    invoke-interface {v2, v4}, Landroid/database/Cursor;->moveToPosition(I)Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-virtual {v3}, Lcom/android/mail/ui/AbstractConversationViewFragment;->isUserVisible()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 306
    new-instance v0, Lcom/android/mail/providers/Conversation;

    invoke-direct {v0, v2}, Lcom/android/mail/providers/Conversation;-><init>(Landroid/database/Cursor;)V

    .line 307
    .local v0, "conv":Lcom/android/mail/providers/Conversation;
    iput v4, v0, Lcom/android/mail/providers/Conversation;->position:I

    .line 308
    invoke-virtual {v3, v0}, Lcom/android/mail/ui/AbstractConversationViewFragment;->onConversationUpdated(Lcom/android/mail/providers/Conversation;)V

    .line 309
    iget-object v5, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v5, v0}, Lcom/android/mail/ui/ActivityController;->setCurrentConversation(Lcom/android/mail/providers/Conversation;)V

    goto :goto_1
.end method

.method public onPageScrollStateChanged(I)V
    .locals 0
    .param p1, "state"    # I

    .prologue
    .line 422
    return-void
.end method

.method public onPageScrolled(IFI)V
    .locals 0
    .param p1, "position"    # I
    .param p2, "positionOffset"    # F
    .param p3, "positionOffsetPixels"    # I

    .prologue
    .line 401
    return-void
.end method

.method public onPageSelected(I)V
    .locals 7
    .param p1, "position"    # I

    .prologue
    .line 405
    iget-object v2, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mController:Lcom/android/mail/ui/ActivityController;

    if-nez v2, :cond_1

    .line 417
    :cond_0
    :goto_0
    return-void

    .line 408
    :cond_1
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationPagerAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v1

    .line 409
    .local v1, "cursor":Landroid/database/Cursor;
    if-eqz v1, :cond_0

    invoke-interface {v1, p1}, Landroid/database/Cursor;->moveToPosition(I)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 413
    new-instance v0, Lcom/android/mail/providers/Conversation;

    invoke-direct {v0, v1}, Lcom/android/mail/providers/Conversation;-><init>(Landroid/database/Cursor;)V

    .line 414
    .local v0, "c":Lcom/android/mail/providers/Conversation;
    iput p1, v0, Lcom/android/mail/providers/Conversation;->position:I

    .line 415
    sget-object v2, Lcom/android/mail/browse/ConversationPagerAdapter;->LOG_TAG:Ljava/lang/String;

    const-string v3, "pager adapter setting current conv: %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    iget-object v6, v0, Lcom/android/mail/providers/Conversation;->subject:Ljava/lang/String;

    aput-object v6, v4, v5

    invoke-static {v2, v3, v4}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 416
    iget-object v2, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v2, v0}, Lcom/android/mail/ui/ActivityController;->setCurrentConversation(Lcom/android/mail/providers/Conversation;)V

    goto :goto_0
.end method

.method public restoreState(Landroid/os/Parcelable;Ljava/lang/ClassLoader;)V
    .locals 5
    .param p1, "state"    # Landroid/os/Parcelable;
    .param p2, "loader"    # Ljava/lang/ClassLoader;

    .prologue
    .line 252
    sget-object v1, Lcom/android/mail/browse/ConversationPagerAdapter;->LOG_TAG:Ljava/lang/String;

    const-string v2, "IN PagerAdapter.restoreState. this=%s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    invoke-static {v1, v2, v3}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 253
    invoke-super {p0, p1, p2}, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->restoreState(Landroid/os/Parcelable;Ljava/lang/ClassLoader;)V

    .line 254
    if-eqz p1, :cond_0

    move-object v0, p1

    .line 255
    check-cast v0, Landroid/os/Bundle;

    .line 256
    .local v0, "b":Landroid/os/Bundle;
    invoke-virtual {v0, p2}, Landroid/os/Bundle;->setClassLoader(Ljava/lang/ClassLoader;)V

    .line 257
    sget-object v1, Lcom/android/mail/browse/ConversationPagerAdapter;->BUNDLE_DETACHED_MODE:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mDetachedMode:Z

    .line 259
    .end local v0    # "b":Landroid/os/Bundle;
    :cond_0
    return-void
.end method

.method public saveState()Landroid/os/Parcelable;
    .locals 5

    .prologue
    .line 241
    sget-object v1, Lcom/android/mail/browse/ConversationPagerAdapter;->LOG_TAG:Ljava/lang/String;

    const-string v2, "IN PagerAdapter.saveState. this=%s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    invoke-static {v1, v2, v3}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 242
    invoke-super {p0}, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->saveState()Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/os/Bundle;

    .line 243
    .local v0, "state":Landroid/os/Bundle;
    if-nez v0, :cond_0

    .line 244
    new-instance v0, Landroid/os/Bundle;

    .end local v0    # "state":Landroid/os/Bundle;
    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 246
    .restart local v0    # "state":Landroid/os/Bundle;
    :cond_0
    sget-object v1, Lcom/android/mail/browse/ConversationPagerAdapter;->BUNDLE_DETACHED_MODE:Ljava/lang/String;

    iget-boolean v2, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mDetachedMode:Z

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 247
    return-object v0
.end method

.method public setActivityController(Lcom/android/mail/ui/ActivityController;)V
    .locals 2
    .param p1, "controller"    # Lcom/android/mail/ui/ActivityController;

    .prologue
    .line 382
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mController:Lcom/android/mail/ui/ActivityController;

    if-eqz v0, :cond_0

    .line 383
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mController:Lcom/android/mail/ui/ActivityController;

    iget-object v1, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mListObserver:Landroid/database/DataSetObserver;

    invoke-interface {v0, v1}, Lcom/android/mail/ui/ActivityController;->unregisterConversationListObserver(Landroid/database/DataSetObserver;)V

    .line 384
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mController:Lcom/android/mail/ui/ActivityController;

    iget-object v1, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mFolderObserver:Landroid/database/DataSetObserver;

    invoke-interface {v0, v1}, Lcom/android/mail/ui/ActivityController;->unregisterFolderObserver(Landroid/database/DataSetObserver;)V

    .line 386
    :cond_0
    iput-object p1, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mController:Lcom/android/mail/ui/ActivityController;

    .line 387
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mController:Lcom/android/mail/ui/ActivityController;

    if-eqz v0, :cond_1

    .line 388
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mController:Lcom/android/mail/ui/ActivityController;

    iget-object v1, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mListObserver:Landroid/database/DataSetObserver;

    invoke-interface {v0, v1}, Lcom/android/mail/ui/ActivityController;->registerConversationListObserver(Landroid/database/DataSetObserver;)V

    .line 389
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mController:Lcom/android/mail/ui/ActivityController;

    iget-object v1, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mFolderObserver:Landroid/database/DataSetObserver;

    invoke-interface {v0, v1}, Lcom/android/mail/ui/ActivityController;->registerFolderObserver(Landroid/database/DataSetObserver;)V

    .line 391
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationPagerAdapter;->notifyDataSetChanged()V

    .line 396
    :cond_1
    return-void
.end method

.method public setItemVisible(Landroid/app/Fragment;Z)V
    .locals 1
    .param p1, "item"    # Landroid/app/Fragment;
    .param p2, "visible"    # Z

    .prologue
    .line 319
    invoke-super {p0, p1, p2}, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->setItemVisible(Landroid/app/Fragment;Z)V

    move-object v0, p1

    .line 320
    check-cast v0, Lcom/android/mail/ui/AbstractConversationViewFragment;

    .line 321
    .local v0, "fragment":Lcom/android/mail/ui/AbstractConversationViewFragment;
    invoke-virtual {v0, p2}, Lcom/android/mail/ui/AbstractConversationViewFragment;->setExtraUserVisibleHint(Z)V

    .line 322
    return-void
.end method

.method public setPager(Landroid/support/v4/view/ViewPager;)V
    .locals 2
    .param p1, "pager"    # Landroid/support/v4/view/ViewPager;

    .prologue
    .line 372
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mPager:Landroid/support/v4/view/ViewPager;

    if-eqz v0, :cond_0

    .line 373
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mPager:Landroid/support/v4/view/ViewPager;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/view/ViewPager;->setOnPageChangeListener(Landroid/support/v4/view/ViewPager$OnPageChangeListener;)V

    .line 375
    :cond_0
    iput-object p1, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mPager:Landroid/support/v4/view/ViewPager;

    .line 376
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mPager:Landroid/support/v4/view/ViewPager;

    if-eqz v0, :cond_1

    .line 377
    iget-object v0, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v0, p0}, Landroid/support/v4/view/ViewPager;->setOnPageChangeListener(Landroid/support/v4/view/ViewPager$OnPageChangeListener;)V

    .line 379
    :cond_1
    return-void
.end method

.method public setPrimaryItem(Landroid/view/ViewGroup;ILjava/lang/Object;)V
    .locals 5
    .param p1, "container"    # Landroid/view/ViewGroup;
    .param p2, "position"    # I
    .param p3, "object"    # Ljava/lang/Object;

    .prologue
    .line 211
    sget-object v0, Lcom/android/mail/browse/ConversationPagerAdapter;->LOG_TAG:Ljava/lang/String;

    const-string v1, "IN PagerAdapter.setPrimaryItem, pos=%d, frag=%s"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    aput-object p3, v2, v3

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 213
    invoke-super {p0, p1, p2, p3}, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->setPrimaryItem(Landroid/view/ViewGroup;ILjava/lang/Object;)V

    .line 214
    return-void
.end method

.method public setSingletonMode(Z)V
    .locals 1
    .param p1, "enabled"    # Z

    .prologue
    .line 112
    iget-boolean v0, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mSingletonMode:Z

    if-eq v0, p1, :cond_0

    .line 113
    iput-boolean p1, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mSingletonMode:Z

    .line 114
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationPagerAdapter;->notifyDataSetChanged()V

    .line 116
    :cond_0
    return-void
.end method

.method public startUpdate(Landroid/view/ViewGroup;)V
    .locals 1
    .param p1, "container"    # Landroid/view/ViewGroup;

    .prologue
    .line 263
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/mail/browse/ConversationPagerAdapter;->mSafeToNotify:Z

    .line 264
    invoke-super {p0, p1}, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->startUpdate(Landroid/view/ViewGroup;)V

    .line 265
    return-void
.end method
