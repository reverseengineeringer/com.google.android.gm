.class public Lcom/android/mail/ui/AnimatedAdapter;
.super Landroid/widget/SimpleCursorAdapter;
.source "AnimatedAdapter.java"

# interfaces
.implements Landroid/animation/Animator$AnimatorListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/ui/AnimatedAdapter$Listener;
    }
.end annotation


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private mAccount:Lcom/android/mail/providers/Account;

.field private final mAccountListener:Lcom/android/mail/providers/AccountObserver;

.field private mActivity:Lcom/android/mail/ui/ControllableActivity;

.field private final mAnimatingViews:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Long;",
            "Lcom/android/mail/browse/SwipeableConversationItemView;",
            ">;"
        }
    .end annotation
.end field

.field private final mBatchConversations:Lcom/android/mail/ui/ConversationSelectionSet;

.field private final mContext:Landroid/content/Context;

.field private final mDeletingItems:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field

.field private final mFadeLeaveBehindItems:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Long;",
            "Lcom/android/mail/ui/LeaveBehindItem;",
            ">;"
        }
    .end annotation
.end field

.field private mFolder:Lcom/android/mail/providers/Folder;

.field private mFooter:Landroid/view/View;

.field private final mLastDeletingItems:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field

.field private mLeaveBehindItem:Lcom/android/mail/ui/LeaveBehindItem;

.field private final mListView:Lcom/android/mail/ui/SwipeableListView;

.field private mPendingDestruction:Lcom/android/mail/ui/SwipeableListView$ListItemsRemovedListener;

.field private mPriorityMarkersEnabled:Z

.field private final mRefreshAction:Lcom/android/mail/ui/SwipeableListView$ListItemsRemovedListener;

.field private mShowFooter:Z

.field private final mSwipeDeletingItems:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field

.field private mSwipeEnabled:Z

.field private final mSwipeUndoingItems:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field

.field private final mUndoingItems:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 116
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/ui/AnimatedAdapter;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;ILcom/android/mail/browse/ConversationCursor;Lcom/android/mail/ui/ConversationSelectionSet;Lcom/android/mail/ui/ControllableActivity;Lcom/android/mail/ui/SwipeableListView;)V
    .locals 7
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "textViewResourceId"    # I
    .param p3, "cursor"    # Lcom/android/mail/browse/ConversationCursor;
    .param p4, "batch"    # Lcom/android/mail/ui/ConversationSelectionSet;
    .param p5, "activity"    # Lcom/android/mail/ui/ControllableActivity;
    .param p6, "listView"    # Lcom/android/mail/ui/SwipeableListView;

    .prologue
    const/4 v6, 0x0

    .line 121
    sget-object v4, Lcom/android/mail/providers/UIProvider;->CONVERSATION_PROJECTION:[Ljava/lang/String;

    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move-object v3, p3

    invoke-direct/range {v0 .. v6}, Landroid/widget/SimpleCursorAdapter;-><init>(Landroid/content/Context;ILandroid/database/Cursor;[Ljava/lang/String;[II)V

    .line 57
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mDeletingItems:Ljava/util/HashSet;

    .line 58
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mLastDeletingItems:Ljava/util/ArrayList;

    .line 59
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mUndoingItems:Ljava/util/HashSet;

    .line 60
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mSwipeDeletingItems:Ljava/util/HashSet;

    .line 61
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mSwipeUndoingItems:Ljava/util/HashSet;

    .line 62
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mAnimatingViews:Ljava/util/HashMap;

    .line 64
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mFadeLeaveBehindItems:Ljava/util/HashMap;

    .line 79
    new-instance v0, Lcom/android/mail/ui/AnimatedAdapter$1;

    invoke-direct {v0, p0}, Lcom/android/mail/ui/AnimatedAdapter$1;-><init>(Lcom/android/mail/ui/AnimatedAdapter;)V

    iput-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mRefreshAction:Lcom/android/mail/ui/SwipeableListView$ListItemsRemovedListener;

    .line 99
    new-instance v0, Lcom/android/mail/ui/AnimatedAdapter$2;

    invoke-direct {v0, p0}, Lcom/android/mail/ui/AnimatedAdapter$2;-><init>(Lcom/android/mail/ui/AnimatedAdapter;)V

    iput-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mAccountListener:Lcom/android/mail/providers/AccountObserver;

    .line 122
    iput-object p1, p0, Lcom/android/mail/ui/AnimatedAdapter;->mContext:Landroid/content/Context;

    .line 123
    iput-object p4, p0, Lcom/android/mail/ui/AnimatedAdapter;->mBatchConversations:Lcom/android/mail/ui/ConversationSelectionSet;

    .line 124
    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mAccountListener:Lcom/android/mail/providers/AccountObserver;

    invoke-interface {p5}, Lcom/android/mail/ui/ControllableActivity;->getAccountController()Lcom/android/mail/ui/AccountController;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/android/mail/providers/AccountObserver;->initialize(Lcom/android/mail/ui/AccountController;)Lcom/android/mail/providers/Account;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/android/mail/ui/AnimatedAdapter;->setAccount(Lcom/android/mail/providers/Account;)V

    .line 125
    iput-object p5, p0, Lcom/android/mail/ui/AnimatedAdapter;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    .line 126
    iput-boolean v6, p0, Lcom/android/mail/ui/AnimatedAdapter;->mShowFooter:Z

    .line 127
    iput-object p6, p0, Lcom/android/mail/ui/AnimatedAdapter;->mListView:Lcom/android/mail/ui/SwipeableListView;

    .line 128
    return-void
.end method

.method static synthetic access$000(Lcom/android/mail/ui/AnimatedAdapter;Lcom/android/mail/providers/Account;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/ui/AnimatedAdapter;
    .param p1, "x1"    # Lcom/android/mail/providers/Account;

    .prologue
    .line 50
    invoke-direct {p0, p1}, Lcom/android/mail/ui/AnimatedAdapter;->setAccount(Lcom/android/mail/providers/Account;)V

    return-void
.end method

.method private delete(Ljava/util/Collection;Lcom/android/mail/ui/SwipeableListView$ListItemsRemovedListener;Ljava/util/HashSet;)V
    .locals 7
    .param p2, "listener"    # Lcom/android/mail/ui/SwipeableListView$ListItemsRemovedListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;",
            "Lcom/android/mail/ui/SwipeableListView$ListItemsRemovedListener;",
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/Long;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 237
    .local p1, "conversations":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    .local p3, "list":Ljava/util/HashSet;, "Ljava/util/HashSet<Ljava/lang/Long;>;"
    iget-object v4, p0, Lcom/android/mail/ui/AnimatedAdapter;->mLastDeletingItems:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->clear()V

    .line 239
    iget-object v4, p0, Lcom/android/mail/ui/AnimatedAdapter;->mListView:Lcom/android/mail/ui/SwipeableListView;

    invoke-virtual {v4}, Lcom/android/mail/ui/SwipeableListView;->getFirstVisiblePosition()I

    move-result v3

    .line 240
    .local v3, "startPosition":I
    iget-object v4, p0, Lcom/android/mail/ui/AnimatedAdapter;->mListView:Lcom/android/mail/ui/SwipeableListView;

    invoke-virtual {v4}, Lcom/android/mail/ui/SwipeableListView;->getLastVisiblePosition()I

    move-result v1

    .line 243
    .local v1, "endPosition":I
    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Conversation;

    .line 244
    .local v0, "c":Lcom/android/mail/providers/Conversation;
    iget v4, v0, Lcom/android/mail/providers/Conversation;->position:I

    if-lt v4, v3, :cond_0

    iget v4, v0, Lcom/android/mail/providers/Conversation;->position:I

    if-gt v4, v1, :cond_0

    .line 245
    iget-object v4, p0, Lcom/android/mail/ui/AnimatedAdapter;->mLastDeletingItems:Ljava/util/ArrayList;

    iget-wide v5, v0, Lcom/android/mail/providers/Conversation;->id:J

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 246
    iget-wide v4, v0, Lcom/android/mail/providers/Conversation;->id:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {p3, v4}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 250
    .end local v0    # "c":Lcom/android/mail/providers/Conversation;
    :cond_1
    invoke-virtual {p3}, Ljava/util/HashSet;->isEmpty()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 252
    invoke-interface {p2}, Lcom/android/mail/ui/SwipeableListView$ListItemsRemovedListener;->onListItemsRemoved()V

    .line 256
    :goto_1
    invoke-virtual {p0}, Lcom/android/mail/ui/AnimatedAdapter;->notifyDataSetChanged()V

    .line 257
    return-void

    .line 254
    :cond_2
    invoke-direct {p0, p2}, Lcom/android/mail/ui/AnimatedAdapter;->performAndSetNextAction(Lcom/android/mail/ui/SwipeableListView$ListItemsRemovedListener;)V

    goto :goto_1
.end method

.method private getDeletingView(ILcom/android/mail/providers/Conversation;Landroid/view/ViewGroup;Z)Landroid/view/View;
    .locals 4
    .param p1, "position"    # I
    .param p2, "conversation"    # Lcom/android/mail/providers/Conversation;
    .param p3, "parent"    # Landroid/view/ViewGroup;
    .param p4, "swipe"    # Z

    .prologue
    .line 397
    iput p1, p2, Lcom/android/mail/providers/Conversation;->position:I

    .line 398
    iget-object v1, p0, Lcom/android/mail/ui/AnimatedAdapter;->mAnimatingViews:Ljava/util/HashMap;

    iget-wide v2, p2, Lcom/android/mail/providers/Conversation;->id:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/browse/SwipeableConversationItemView;

    .line 399
    .local v0, "deletingView":Lcom/android/mail/browse/SwipeableConversationItemView;
    if-nez v0, :cond_0

    .line 402
    invoke-direct {p0, p1, p3, p2}, Lcom/android/mail/ui/AnimatedAdapter;->newConversationItemView(ILandroid/view/ViewGroup;Lcom/android/mail/providers/Conversation;)Lcom/android/mail/browse/SwipeableConversationItemView;

    move-result-object v0

    .line 403
    invoke-virtual {v0, p0, p4}, Lcom/android/mail/browse/SwipeableConversationItemView;->startDeleteAnimation(Lcom/android/mail/ui/AnimatedAdapter;Z)V

    .line 405
    :cond_0
    return-object v0
.end method

.method private getFadeLeaveBehindItem(ILcom/android/mail/providers/Conversation;)Lcom/android/mail/ui/LeaveBehindItem;
    .locals 3
    .param p1, "position"    # I
    .param p2, "target"    # Lcom/android/mail/providers/Conversation;

    .prologue
    .line 384
    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mFadeLeaveBehindItems:Ljava/util/HashMap;

    iget-wide v1, p2, Lcom/android/mail/providers/Conversation;->id:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/ui/LeaveBehindItem;

    return-object v0
.end method

.method private getLeaveBehindItem(Lcom/android/mail/providers/Conversation;)Lcom/android/mail/ui/LeaveBehindItem;
    .locals 1
    .param p1, "target"    # Lcom/android/mail/providers/Conversation;

    .prologue
    .line 380
    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mLeaveBehindItem:Lcom/android/mail/ui/LeaveBehindItem;

    return-object v0
.end method

.method private getUndoingView(ILcom/android/mail/providers/Conversation;Landroid/view/ViewGroup;Z)Landroid/view/View;
    .locals 4
    .param p1, "position"    # I
    .param p2, "conv"    # Lcom/android/mail/providers/Conversation;
    .param p3, "parent"    # Landroid/view/ViewGroup;
    .param p4, "swipe"    # Z

    .prologue
    .line 409
    iput p1, p2, Lcom/android/mail/providers/Conversation;->position:I

    .line 410
    iget-object v1, p0, Lcom/android/mail/ui/AnimatedAdapter;->mAnimatingViews:Ljava/util/HashMap;

    iget-wide v2, p2, Lcom/android/mail/providers/Conversation;->id:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/browse/SwipeableConversationItemView;

    .line 411
    .local v0, "undoView":Lcom/android/mail/browse/SwipeableConversationItemView;
    if-nez v0, :cond_0

    .line 414
    invoke-direct {p0, p1, p3, p2}, Lcom/android/mail/ui/AnimatedAdapter;->newConversationItemView(ILandroid/view/ViewGroup;Lcom/android/mail/providers/Conversation;)Lcom/android/mail/browse/SwipeableConversationItemView;

    move-result-object v0

    .line 415
    iget-object v1, p0, Lcom/android/mail/ui/AnimatedAdapter;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->getViewMode()Lcom/android/mail/ui/ViewMode;

    move-result-object v1

    invoke-virtual {v0, v1, p0, p4}, Lcom/android/mail/browse/SwipeableConversationItemView;->startUndoAnimation(Lcom/android/mail/ui/ViewMode;Lcom/android/mail/ui/AnimatedAdapter;Z)V

    .line 417
    :cond_0
    return-object v0
.end method

.method private hasFadeLeaveBehinds()Z
    .locals 1

    .prologue
    .line 309
    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mFadeLeaveBehindItems:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private hasLeaveBehinds()Z
    .locals 1

    .prologue
    .line 305
    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mLeaveBehindItem:Lcom/android/mail/ui/LeaveBehindItem;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private isPositionDeleting(J)Z
    .locals 2
    .param p1, "id"    # J

    .prologue
    .line 458
    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mDeletingItems:Ljava/util/HashSet;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method private isPositionFadeLeaveBehind(Lcom/android/mail/providers/Conversation;)Z
    .locals 3
    .param p1, "conv"    # Lcom/android/mail/providers/Conversation;

    .prologue
    .line 484
    invoke-direct {p0}, Lcom/android/mail/ui/AnimatedAdapter;->hasFadeLeaveBehinds()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mFadeLeaveBehindItems:Ljava/util/HashMap;

    iget-wide v1, p1, Lcom/android/mail/providers/Conversation;->id:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/android/mail/providers/Conversation;->isMostlyDead()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private isPositionLeaveBehind(Lcom/android/mail/providers/Conversation;)Z
    .locals 4
    .param p1, "conv"    # Lcom/android/mail/providers/Conversation;

    .prologue
    .line 478
    invoke-direct {p0}, Lcom/android/mail/ui/AnimatedAdapter;->hasLeaveBehinds()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mLeaveBehindItem:Lcom/android/mail/ui/LeaveBehindItem;

    invoke-virtual {v0}, Lcom/android/mail/ui/LeaveBehindItem;->getConversationId()J

    move-result-wide v0

    iget-wide v2, p1, Lcom/android/mail/providers/Conversation;->id:J

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/android/mail/providers/Conversation;->isMostlyDead()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private isPositionSwipeDeleting(J)Z
    .locals 2
    .param p1, "id"    # J

    .prologue
    .line 462
    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mSwipeDeletingItems:Ljava/util/HashSet;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method private isPositionUndoing(J)Z
    .locals 2
    .param p1, "id"    # J

    .prologue
    .line 466
    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mUndoingItems:Ljava/util/HashSet;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method private isPositionUndoingSwipe(J)Z
    .locals 2
    .param p1, "id"    # J

    .prologue
    .line 470
    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mSwipeUndoingItems:Ljava/util/HashSet;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method private newConversationItemView(ILandroid/view/ViewGroup;Lcom/android/mail/providers/Conversation;)Lcom/android/mail/browse/SwipeableConversationItemView;
    .locals 9
    .param p1, "position"    # I
    .param p2, "parent"    # Landroid/view/ViewGroup;
    .param p3, "conversation"    # Lcom/android/mail/providers/Conversation;

    .prologue
    .line 439
    const/4 v1, 0x0

    invoke-super {p0, p1, v1, p2}, Landroid/widget/SimpleCursorAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/android/mail/browse/SwipeableConversationItemView;

    .line 441
    .local v0, "view":Lcom/android/mail/browse/SwipeableConversationItemView;
    invoke-virtual {v0}, Lcom/android/mail/browse/SwipeableConversationItemView;->reset()V

    .line 442
    iget-object v2, p0, Lcom/android/mail/ui/AnimatedAdapter;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    iget-object v3, p0, Lcom/android/mail/ui/AnimatedAdapter;->mBatchConversations:Lcom/android/mail/ui/ConversationSelectionSet;

    iget-object v4, p0, Lcom/android/mail/ui/AnimatedAdapter;->mFolder:Lcom/android/mail/providers/Folder;

    iget-object v1, p0, Lcom/android/mail/ui/AnimatedAdapter;->mAccount:Lcom/android/mail/providers/Account;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/android/mail/ui/AnimatedAdapter;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v1, v1, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    iget-boolean v5, v1, Lcom/android/mail/providers/Settings;->hideCheckboxes:Z

    :goto_0
    iget-boolean v6, p0, Lcom/android/mail/ui/AnimatedAdapter;->mSwipeEnabled:Z

    iget-boolean v7, p0, Lcom/android/mail/ui/AnimatedAdapter;->mPriorityMarkersEnabled:Z

    move-object v1, p3

    move-object v8, p0

    invoke-virtual/range {v0 .. v8}, Lcom/android/mail/browse/SwipeableConversationItemView;->bind(Lcom/android/mail/providers/Conversation;Lcom/android/mail/ui/ControllableActivity;Lcom/android/mail/ui/ConversationSelectionSet;Lcom/android/mail/providers/Folder;ZZZLcom/android/mail/ui/AnimatedAdapter;)V

    .line 445
    iget-object v1, p0, Lcom/android/mail/ui/AnimatedAdapter;->mAnimatingViews:Ljava/util/HashMap;

    iget-wide v2, p3, Lcom/android/mail/providers/Conversation;->id:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 446
    return-object v0

    .line 442
    :cond_0
    const/4 v5, 0x0

    goto :goto_0
.end method

.method private final performAndSetNextAction(Lcom/android/mail/ui/SwipeableListView$ListItemsRemovedListener;)V
    .locals 1
    .param p1, "next"    # Lcom/android/mail/ui/SwipeableListView$ListItemsRemovedListener;

    .prologue
    .line 513
    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mPendingDestruction:Lcom/android/mail/ui/SwipeableListView$ListItemsRemovedListener;

    if-eqz v0, :cond_0

    .line 514
    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mPendingDestruction:Lcom/android/mail/ui/SwipeableListView$ListItemsRemovedListener;

    invoke-interface {v0}, Lcom/android/mail/ui/SwipeableListView$ListItemsRemovedListener;->onListItemsRemoved()V

    .line 516
    :cond_0
    iput-object p1, p0, Lcom/android/mail/ui/AnimatedAdapter;->mPendingDestruction:Lcom/android/mail/ui/SwipeableListView$ListItemsRemovedListener;

    .line 517
    return-void
.end method

.method private final setAccount(Lcom/android/mail/providers/Account;)V
    .locals 2
    .param p1, "newAccount"    # Lcom/android/mail/providers/Account;

    .prologue
    .line 108
    iput-object p1, p0, Lcom/android/mail/ui/AnimatedAdapter;->mAccount:Lcom/android/mail/providers/Account;

    .line 109
    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v0, v0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    iget-boolean v0, v0, Lcom/android/mail/providers/Settings;->priorityArrowsEnabled:Z

    iput-boolean v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mPriorityMarkersEnabled:Z

    .line 110
    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mAccount:Lcom/android/mail/providers/Account;

    const/16 v1, 0x4000

    invoke-virtual {v0, v1}, Lcom/android/mail/providers/Account;->supportsCapability(I)Z

    move-result v0

    iput-boolean v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mSwipeEnabled:Z

    .line 111
    return-void
.end method

.method private updateAnimatingConversationItems(Ljava/lang/Object;Ljava/util/HashSet;)V
    .locals 5
    .param p1, "obj"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/Long;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 546
    .local p2, "items":Ljava/util/HashSet;, "Ljava/util/HashSet<Ljava/lang/Long;>;"
    invoke-virtual {p2}, Ljava/util/HashSet;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_0

    .line 547
    instance-of v3, p1, Lcom/android/mail/browse/ConversationItemView;

    if-eqz v3, :cond_0

    move-object v2, p1

    .line 548
    check-cast v2, Lcom/android/mail/browse/ConversationItemView;

    .line 549
    .local v2, "target":Lcom/android/mail/browse/ConversationItemView;
    invoke-virtual {v2}, Lcom/android/mail/browse/ConversationItemView;->getConversation()Lcom/android/mail/providers/Conversation;

    move-result-object v3

    iget-wide v0, v3, Lcom/android/mail/providers/Conversation;->id:J

    .line 550
    .local v0, "id":J
    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {p2, v3}, Ljava/util/HashSet;->remove(Ljava/lang/Object;)Z

    .line 551
    iget-object v3, p0, Lcom/android/mail/ui/AnimatedAdapter;->mAnimatingViews:Ljava/util/HashMap;

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 552
    invoke-virtual {p2}, Ljava/util/HashSet;->isEmpty()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 553
    const/4 v3, 0x0

    invoke-direct {p0, v3}, Lcom/android/mail/ui/AnimatedAdapter;->performAndSetNextAction(Lcom/android/mail/ui/SwipeableListView$ListItemsRemovedListener;)V

    .line 554
    invoke-virtual {p0}, Lcom/android/mail/ui/AnimatedAdapter;->notifyDataSetChanged()V

    .line 558
    .end local v0    # "id":J
    .end local v2    # "target":Lcom/android/mail/browse/ConversationItemView;
    :cond_0
    return-void
.end method


# virtual methods
.method public addFooter(Landroid/view/View;)V
    .locals 0
    .param p1, "footerView"    # Landroid/view/View;

    .prologue
    .line 596
    iput-object p1, p0, Lcom/android/mail/ui/AnimatedAdapter;->mFooter:Landroid/view/View;

    .line 597
    return-void
.end method

.method public areAllItemsEnabled()Z
    .locals 1

    .prologue
    .line 563
    const/4 v0, 0x0

    return v0
.end method

.method public bindView(Landroid/view/View;Landroid/content/Context;Landroid/database/Cursor;)V
    .locals 9
    .param p1, "view"    # Landroid/view/View;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 429
    instance-of v0, p1, Lcom/android/mail/browse/SwipeableConversationItemView;

    if-nez v0, :cond_0

    .line 435
    :goto_0
    return-void

    :cond_0
    move-object v0, p1

    .line 432
    check-cast v0, Lcom/android/mail/browse/SwipeableConversationItemView;

    iget-object v2, p0, Lcom/android/mail/ui/AnimatedAdapter;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    iget-object v3, p0, Lcom/android/mail/ui/AnimatedAdapter;->mBatchConversations:Lcom/android/mail/ui/ConversationSelectionSet;

    iget-object v4, p0, Lcom/android/mail/ui/AnimatedAdapter;->mFolder:Lcom/android/mail/providers/Folder;

    iget-object v1, p0, Lcom/android/mail/ui/AnimatedAdapter;->mAccount:Lcom/android/mail/providers/Account;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/android/mail/ui/AnimatedAdapter;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v1, v1, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    iget-boolean v5, v1, Lcom/android/mail/providers/Settings;->hideCheckboxes:Z

    :goto_1
    iget-boolean v6, p0, Lcom/android/mail/ui/AnimatedAdapter;->mSwipeEnabled:Z

    iget-boolean v7, p0, Lcom/android/mail/ui/AnimatedAdapter;->mPriorityMarkersEnabled:Z

    move-object v1, p3

    move-object v8, p0

    invoke-virtual/range {v0 .. v8}, Lcom/android/mail/browse/SwipeableConversationItemView;->bind(Landroid/database/Cursor;Lcom/android/mail/ui/ControllableActivity;Lcom/android/mail/ui/ConversationSelectionSet;Lcom/android/mail/providers/Folder;ZZZLcom/android/mail/ui/AnimatedAdapter;)V

    goto :goto_0

    :cond_1
    const/4 v5, 0x0

    goto :goto_1
.end method

.method public clearLeaveBehind(J)V
    .locals 3
    .param p1, "itemId"    # J

    .prologue
    .line 604
    invoke-direct {p0}, Lcom/android/mail/ui/AnimatedAdapter;->hasLeaveBehinds()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mLeaveBehindItem:Lcom/android/mail/ui/LeaveBehindItem;

    invoke-virtual {v0}, Lcom/android/mail/ui/LeaveBehindItem;->getConversationId()J

    move-result-wide v0

    cmp-long v0, v0, p1

    if-nez v0, :cond_0

    .line 605
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mLeaveBehindItem:Lcom/android/mail/ui/LeaveBehindItem;

    .line 611
    :goto_0
    return-void

    .line 606
    :cond_0
    invoke-direct {p0}, Lcom/android/mail/ui/AnimatedAdapter;->hasFadeLeaveBehinds()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 607
    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mFadeLeaveBehindItems:Ljava/util/HashMap;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 609
    :cond_1
    sget-object v0, Lcom/android/mail/ui/AnimatedAdapter;->LOG_TAG:Ljava/lang/String;

    const-string v1, "Trying to clear a non-existant leave behind"

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0
.end method

.method public commitLeaveBehindItems(Z)V
    .locals 4
    .param p1, "animate"    # Z

    .prologue
    .line 353
    const/4 v0, 0x0

    .line 354
    .local v0, "changed":Z
    invoke-direct {p0}, Lcom/android/mail/ui/AnimatedAdapter;->hasLeaveBehinds()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 355
    if-eqz p1, :cond_1

    .line 356
    iget-object v3, p0, Lcom/android/mail/ui/AnimatedAdapter;->mLeaveBehindItem:Lcom/android/mail/ui/LeaveBehindItem;

    invoke-virtual {v3}, Lcom/android/mail/ui/LeaveBehindItem;->dismiss()V

    .line 360
    :goto_0
    const/4 v0, 0x1

    .line 362
    :cond_0
    invoke-direct {p0}, Lcom/android/mail/ui/AnimatedAdapter;->hasFadeLeaveBehinds()Z

    move-result v3

    if-eqz v3, :cond_3

    if-nez p1, :cond_3

    .line 364
    iget-object v3, p0, Lcom/android/mail/ui/AnimatedAdapter;->mFadeLeaveBehindItems:Ljava/util/HashMap;

    invoke-virtual {v3}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/android/mail/ui/LeaveBehindItem;

    .line 365
    .local v2, "item":Lcom/android/mail/ui/LeaveBehindItem;
    invoke-virtual {v2}, Lcom/android/mail/ui/LeaveBehindItem;->commit()V

    goto :goto_1

    .line 358
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "item":Lcom/android/mail/ui/LeaveBehindItem;
    :cond_1
    iget-object v3, p0, Lcom/android/mail/ui/AnimatedAdapter;->mLeaveBehindItem:Lcom/android/mail/ui/LeaveBehindItem;

    invoke-virtual {v3}, Lcom/android/mail/ui/LeaveBehindItem;->commit()V

    goto :goto_0

    .line 367
    .restart local v1    # "i$":Ljava/util/Iterator;
    :cond_2
    iget-object v3, p0, Lcom/android/mail/ui/AnimatedAdapter;->mFadeLeaveBehindItems:Ljava/util/HashMap;

    invoke-virtual {v3}, Ljava/util/HashMap;->clear()V

    .line 368
    const/4 v0, 0x1

    .line 370
    .end local v1    # "i$":Ljava/util/Iterator;
    :cond_3
    iget-object v3, p0, Lcom/android/mail/ui/AnimatedAdapter;->mLastDeletingItems:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_4

    .line 371
    iget-object v3, p0, Lcom/android/mail/ui/AnimatedAdapter;->mLastDeletingItems:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->clear()V

    .line 372
    const/4 v0, 0x1

    .line 374
    :cond_4
    if-eqz v0, :cond_5

    .line 375
    invoke-virtual {p0}, Lcom/android/mail/ui/AnimatedAdapter;->notifyDataSetChanged()V

    .line 377
    :cond_5
    return-void
.end method

.method public createConversationItemView(Lcom/android/mail/browse/SwipeableConversationItemView;Landroid/content/Context;Lcom/android/mail/providers/Conversation;)Landroid/view/View;
    .locals 9
    .param p1, "view"    # Lcom/android/mail/browse/SwipeableConversationItemView;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "conv"    # Lcom/android/mail/providers/Conversation;

    .prologue
    .line 164
    if-nez p1, :cond_0

    .line 165
    new-instance p1, Lcom/android/mail/browse/SwipeableConversationItemView;

    .end local p1    # "view":Lcom/android/mail/browse/SwipeableConversationItemView;
    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v0, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-direct {p1, p2, v0}, Lcom/android/mail/browse/SwipeableConversationItemView;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 167
    .restart local p1    # "view":Lcom/android/mail/browse/SwipeableConversationItemView;
    :cond_0
    iget-object v2, p0, Lcom/android/mail/ui/AnimatedAdapter;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    iget-object v3, p0, Lcom/android/mail/ui/AnimatedAdapter;->mBatchConversations:Lcom/android/mail/ui/ConversationSelectionSet;

    iget-object v4, p0, Lcom/android/mail/ui/AnimatedAdapter;->mFolder:Lcom/android/mail/providers/Folder;

    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mAccount:Lcom/android/mail/providers/Account;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v0, v0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    iget-boolean v5, v0, Lcom/android/mail/providers/Settings;->hideCheckboxes:Z

    :goto_0
    iget-boolean v6, p0, Lcom/android/mail/ui/AnimatedAdapter;->mSwipeEnabled:Z

    iget-boolean v7, p0, Lcom/android/mail/ui/AnimatedAdapter;->mPriorityMarkersEnabled:Z

    move-object v0, p1

    move-object v1, p3

    move-object v8, p0

    invoke-virtual/range {v0 .. v8}, Lcom/android/mail/browse/SwipeableConversationItemView;->bind(Lcom/android/mail/providers/Conversation;Lcom/android/mail/ui/ControllableActivity;Lcom/android/mail/ui/ConversationSelectionSet;Lcom/android/mail/providers/Folder;ZZZLcom/android/mail/ui/AnimatedAdapter;)V

    .line 170
    return-object p1

    .line 167
    :cond_1
    const/4 v5, 0x0

    goto :goto_0
.end method

.method public delete(Ljava/util/Collection;Lcom/android/mail/ui/SwipeableListView$ListItemsRemovedListener;)V
    .locals 1
    .param p2, "listener"    # Lcom/android/mail/ui/SwipeableListView$ListItemsRemovedListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;",
            "Lcom/android/mail/ui/SwipeableListView$ListItemsRemovedListener;",
            ")V"
        }
    .end annotation

    .prologue
    .line 231
    .local p1, "conversations":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mDeletingItems:Ljava/util/HashSet;

    invoke-direct {p0, p1, p2, v0}, Lcom/android/mail/ui/AnimatedAdapter;->delete(Ljava/util/Collection;Lcom/android/mail/ui/SwipeableListView$ListItemsRemovedListener;Ljava/util/HashSet;)V

    .line 232
    return-void
.end method

.method public final destroy()V
    .locals 1

    .prologue
    .line 132
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/AnimatedAdapter;->swapCursor(Landroid/database/Cursor;)Landroid/database/Cursor;

    .line 133
    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mAccountListener:Lcom/android/mail/providers/AccountObserver;

    invoke-virtual {v0}, Lcom/android/mail/providers/AccountObserver;->unregisterAndDestroy()V

    .line 134
    return-void
.end method

.method public fadeOutLeaveBehindItems()V
    .locals 6

    .prologue
    .line 327
    iget-object v3, p0, Lcom/android/mail/ui/AnimatedAdapter;->mListView:Lcom/android/mail/ui/SwipeableListView;

    invoke-virtual {v3}, Lcom/android/mail/ui/SwipeableListView;->getFirstVisiblePosition()I

    move-result v2

    .line 328
    .local v2, "startPosition":I
    iget-object v3, p0, Lcom/android/mail/ui/AnimatedAdapter;->mListView:Lcom/android/mail/ui/SwipeableListView;

    invoke-virtual {v3}, Lcom/android/mail/ui/SwipeableListView;->getLastVisiblePosition()I

    move-result v1

    .line 330
    .local v1, "endPosition":I
    invoke-direct {p0}, Lcom/android/mail/ui/AnimatedAdapter;->hasLeaveBehinds()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 333
    iget-object v3, p0, Lcom/android/mail/ui/AnimatedAdapter;->mLeaveBehindItem:Lcom/android/mail/ui/LeaveBehindItem;

    invoke-virtual {v3}, Lcom/android/mail/ui/LeaveBehindItem;->getData()Lcom/android/mail/providers/Conversation;

    move-result-object v0

    .line 334
    .local v0, "conv":Lcom/android/mail/providers/Conversation;
    iget v3, v0, Lcom/android/mail/providers/Conversation;->position:I

    if-lt v3, v2, :cond_2

    iget v3, v0, Lcom/android/mail/providers/Conversation;->position:I

    if-gt v3, v1, :cond_2

    .line 335
    iget-object v3, p0, Lcom/android/mail/ui/AnimatedAdapter;->mFadeLeaveBehindItems:Ljava/util/HashMap;

    iget-wide v4, v0, Lcom/android/mail/providers/Conversation;->id:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    iget-object v5, p0, Lcom/android/mail/ui/AnimatedAdapter;->mLeaveBehindItem:Lcom/android/mail/ui/LeaveBehindItem;

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 339
    :goto_0
    iget-wide v3, v0, Lcom/android/mail/providers/Conversation;->id:J

    invoke-virtual {p0, v3, v4}, Lcom/android/mail/ui/AnimatedAdapter;->clearLeaveBehind(J)V

    .line 341
    .end local v0    # "conv":Lcom/android/mail/providers/Conversation;
    :cond_0
    iget-object v3, p0, Lcom/android/mail/ui/AnimatedAdapter;->mLastDeletingItems:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_1

    .line 342
    iget-object v3, p0, Lcom/android/mail/ui/AnimatedAdapter;->mLastDeletingItems:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->clear()V

    .line 344
    :cond_1
    invoke-virtual {p0}, Lcom/android/mail/ui/AnimatedAdapter;->notifyDataSetChanged()V

    .line 345
    return-void

    .line 337
    .restart local v0    # "conv":Lcom/android/mail/providers/Conversation;
    :cond_2
    iget-object v3, p0, Lcom/android/mail/ui/AnimatedAdapter;->mLeaveBehindItem:Lcom/android/mail/ui/LeaveBehindItem;

    invoke-virtual {v3}, Lcom/android/mail/ui/LeaveBehindItem;->commit()V

    goto :goto_0
.end method

.method public getConversationCursor()Lcom/android/mail/browse/ConversationCursor;
    .locals 1

    .prologue
    .line 653
    invoke-virtual {p0}, Lcom/android/mail/ui/AnimatedAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v0

    check-cast v0, Lcom/android/mail/browse/ConversationCursor;

    return-object v0
.end method

.method public getCount()I
    .locals 2

    .prologue
    .line 138
    invoke-super {p0}, Landroid/widget/SimpleCursorAdapter;->getCount()I

    move-result v0

    .line 139
    .local v0, "count":I
    iget-boolean v1, p0, Lcom/android/mail/ui/AnimatedAdapter;->mShowFooter:Z

    if-eqz v1, :cond_0

    add-int/lit8 v0, v0, 0x1

    .end local v0    # "count":I
    :cond_0
    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 451
    iget-boolean v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mShowFooter:Z

    if-eqz v0, :cond_0

    invoke-super {p0}, Landroid/widget/SimpleCursorAdapter;->getCount()I

    move-result v0

    if-ne p1, v0, :cond_0

    .line 452
    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mFooter:Landroid/view/View;

    .line 454
    :goto_0
    return-object v0

    :cond_0
    invoke-super {p0, p1}, Landroid/widget/SimpleCursorAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 389
    iget-boolean v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mShowFooter:Z

    if-eqz v0, :cond_0

    invoke-super {p0}, Landroid/widget/SimpleCursorAdapter;->getCount()I

    move-result v0

    if-ne p1, v0, :cond_0

    .line 390
    const-wide/16 v0, -0x1

    .line 392
    :goto_0
    return-wide v0

    :cond_0
    invoke-super {p0, p1}, Landroid/widget/SimpleCursorAdapter;->getItemId(I)J

    move-result-wide v0

    goto :goto_0
.end method

.method public getItemViewType(I)I
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 188
    iget-boolean v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mShowFooter:Z

    if-eqz v0, :cond_0

    invoke-super {p0}, Landroid/widget/SimpleCursorAdapter;->getCount()I

    move-result v0

    if-ne p1, v0, :cond_0

    .line 189
    const/4 v0, 0x1

    .line 199
    :goto_0
    return v0

    .line 190
    :cond_0
    invoke-direct {p0}, Lcom/android/mail/ui/AnimatedAdapter;->hasLeaveBehinds()Z

    move-result v0

    if-nez v0, :cond_1

    invoke-virtual {p0}, Lcom/android/mail/ui/AnimatedAdapter;->isAnimating()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 197
    :cond_1
    const/4 v0, -0x1

    goto :goto_0

    .line 199
    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getListView()Lcom/android/mail/ui/SwipeableListView;
    .locals 1

    .prologue
    .line 348
    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mListView:Lcom/android/mail/ui/SwipeableListView;

    return-object v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 8
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 261
    iget-boolean v4, p0, Lcom/android/mail/ui/AnimatedAdapter;->mShowFooter:Z

    if-eqz v4, :cond_0

    invoke-super {p0}, Landroid/widget/SimpleCursorAdapter;->getCount()I

    move-result v4

    if-ne p1, v4, :cond_0

    .line 262
    iget-object v2, p0, Lcom/android/mail/ui/AnimatedAdapter;->mFooter:Landroid/view/View;

    .line 300
    :goto_0
    return-object v2

    .line 264
    :cond_0
    invoke-virtual {p0, p1}, Lcom/android/mail/ui/AnimatedAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/mail/browse/ConversationCursor;

    .line 265
    .local v1, "cursor":Lcom/android/mail/browse/ConversationCursor;
    new-instance v0, Lcom/android/mail/providers/Conversation;

    invoke-direct {v0, v1}, Lcom/android/mail/providers/Conversation;-><init>(Landroid/database/Cursor;)V

    .line 266
    .local v0, "conv":Lcom/android/mail/providers/Conversation;
    iget-wide v4, v0, Lcom/android/mail/providers/Conversation;->id:J

    invoke-direct {p0, v4, v5}, Lcom/android/mail/ui/AnimatedAdapter;->isPositionUndoing(J)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 267
    invoke-direct {p0, p1, v0, p3, v6}, Lcom/android/mail/ui/AnimatedAdapter;->getUndoingView(ILcom/android/mail/providers/Conversation;Landroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    goto :goto_0

    .line 268
    :cond_1
    iget-wide v4, v0, Lcom/android/mail/providers/Conversation;->id:J

    invoke-direct {p0, v4, v5}, Lcom/android/mail/ui/AnimatedAdapter;->isPositionUndoingSwipe(J)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 269
    invoke-direct {p0, p1, v0, p3, v7}, Lcom/android/mail/ui/AnimatedAdapter;->getUndoingView(ILcom/android/mail/providers/Conversation;Landroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    goto :goto_0

    .line 270
    :cond_2
    iget-wide v4, v0, Lcom/android/mail/providers/Conversation;->id:J

    invoke-direct {p0, v4, v5}, Lcom/android/mail/ui/AnimatedAdapter;->isPositionDeleting(J)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 271
    invoke-direct {p0, p1, v0, p3, v6}, Lcom/android/mail/ui/AnimatedAdapter;->getDeletingView(ILcom/android/mail/providers/Conversation;Landroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    goto :goto_0

    .line 272
    :cond_3
    iget-wide v4, v0, Lcom/android/mail/providers/Conversation;->id:J

    invoke-direct {p0, v4, v5}, Lcom/android/mail/ui/AnimatedAdapter;->isPositionSwipeDeleting(J)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 273
    invoke-direct {p0, p1, v0, p3, v7}, Lcom/android/mail/ui/AnimatedAdapter;->getDeletingView(ILcom/android/mail/providers/Conversation;Landroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    goto :goto_0

    .line 275
    :cond_4
    invoke-direct {p0}, Lcom/android/mail/ui/AnimatedAdapter;->hasFadeLeaveBehinds()Z

    move-result v4

    if-eqz v4, :cond_5

    .line 276
    invoke-direct {p0, v0}, Lcom/android/mail/ui/AnimatedAdapter;->isPositionFadeLeaveBehind(Lcom/android/mail/providers/Conversation;)Z

    move-result v4

    if-eqz v4, :cond_5

    .line 277
    invoke-direct {p0, p1, v0}, Lcom/android/mail/ui/AnimatedAdapter;->getFadeLeaveBehindItem(ILcom/android/mail/providers/Conversation;)Lcom/android/mail/ui/LeaveBehindItem;

    move-result-object v2

    .line 278
    .local v2, "fade":Lcom/android/mail/ui/LeaveBehindItem;
    iget-object v4, p0, Lcom/android/mail/ui/AnimatedAdapter;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v4}, Lcom/android/mail/ui/ControllableActivity;->getViewMode()Lcom/android/mail/ui/ViewMode;

    move-result-object v4

    invoke-virtual {v2, v4, p0}, Lcom/android/mail/ui/LeaveBehindItem;->startAnimation(Lcom/android/mail/ui/ViewMode;Landroid/animation/Animator$AnimatorListener;)V

    goto :goto_0

    .line 282
    .end local v2    # "fade":Lcom/android/mail/ui/LeaveBehindItem;
    :cond_5
    invoke-direct {p0}, Lcom/android/mail/ui/AnimatedAdapter;->hasLeaveBehinds()Z

    move-result v4

    if-eqz v4, :cond_7

    .line 283
    invoke-direct {p0, v0}, Lcom/android/mail/ui/AnimatedAdapter;->isPositionLeaveBehind(Lcom/android/mail/providers/Conversation;)Z

    move-result v4

    if-eqz v4, :cond_7

    .line 284
    invoke-direct {p0, v0}, Lcom/android/mail/ui/AnimatedAdapter;->getLeaveBehindItem(Lcom/android/mail/providers/Conversation;)Lcom/android/mail/ui/LeaveBehindItem;

    move-result-object v3

    .line 285
    .local v3, "fadeIn":Lcom/android/mail/ui/LeaveBehindItem;
    invoke-direct {p0}, Lcom/android/mail/ui/AnimatedAdapter;->hasFadeLeaveBehinds()Z

    move-result v4

    if-eqz v4, :cond_6

    .line 287
    invoke-virtual {v3}, Lcom/android/mail/ui/LeaveBehindItem;->showTextImmediately()V

    :goto_1
    move-object v2, v3

    .line 291
    goto :goto_0

    .line 289
    :cond_6
    invoke-virtual {v3}, Lcom/android/mail/ui/LeaveBehindItem;->startFadeInAnimation()V

    goto :goto_1

    .line 294
    .end local v3    # "fadeIn":Lcom/android/mail/ui/LeaveBehindItem;
    :cond_7
    if-eqz p2, :cond_9

    instance-of v4, p2, Lcom/android/mail/browse/SwipeableConversationItemView;

    if-nez v4, :cond_9

    .line 295
    sget-object v4, Lcom/android/mail/ui/AnimatedAdapter;->LOG_TAG:Ljava/lang/String;

    const-string v5, "Incorrect convert view received; nulling it out"

    new-array v6, v6, [Ljava/lang/Object;

    invoke-static {v4, v5, v6}, Lcom/android/mail/utils/LogUtils;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 296
    iget-object v4, p0, Lcom/android/mail/ui/AnimatedAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {p0, v4, v1, p3}, Lcom/android/mail/ui/AnimatedAdapter;->newView(Landroid/content/Context;Landroid/database/Cursor;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    :cond_8
    :goto_2
    move-object v4, p2

    .line 300
    check-cast v4, Lcom/android/mail/browse/SwipeableConversationItemView;

    iget-object v5, p0, Lcom/android/mail/ui/AnimatedAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {p0, v4, v5, v0}, Lcom/android/mail/ui/AnimatedAdapter;->createConversationItemView(Lcom/android/mail/browse/SwipeableConversationItemView;Landroid/content/Context;Lcom/android/mail/providers/Conversation;)Landroid/view/View;

    move-result-object v2

    goto/16 :goto_0

    .line 297
    :cond_9
    if-eqz p2, :cond_8

    move-object v4, p2

    .line 298
    check-cast v4, Lcom/android/mail/browse/SwipeableConversationItemView;

    invoke-virtual {v4}, Lcom/android/mail/browse/SwipeableConversationItemView;->reset()V

    goto :goto_2
.end method

.method public getViewTypeCount()I
    .locals 1

    .prologue
    .line 182
    const/4 v0, 0x5

    return v0
.end method

.method public hasStableIds()Z
    .locals 1

    .prologue
    .line 175
    const/4 v0, 0x1

    return v0
.end method

.method public hideFooter()V
    .locals 1

    .prologue
    .line 585
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/AnimatedAdapter;->setFooterVisibility(Z)V

    .line 586
    return-void
.end method

.method public isAnimating()Z
    .locals 1

    .prologue
    .line 642
    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mUndoingItems:Ljava/util/HashSet;

    invoke-virtual {v0}, Ljava/util/HashSet;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mSwipeUndoingItems:Ljava/util/HashSet;

    invoke-virtual {v0}, Ljava/util/HashSet;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-direct {p0}, Lcom/android/mail/ui/AnimatedAdapter;->hasFadeLeaveBehinds()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mDeletingItems:Ljava/util/HashSet;

    invoke-virtual {v0}, Ljava/util/HashSet;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mSwipeDeletingItems:Ljava/util/HashSet;

    invoke-virtual {v0}, Ljava/util/HashSet;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isEnabled(I)Z
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 568
    int-to-long v0, p1

    invoke-direct {p0, v0, v1}, Lcom/android/mail/ui/AnimatedAdapter;->isPositionDeleting(J)Z

    move-result v0

    if-nez v0, :cond_0

    int-to-long v0, p1

    invoke-direct {p0, v0, v1}, Lcom/android/mail/ui/AnimatedAdapter;->isPositionUndoing(J)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public newView(Landroid/content/Context;Landroid/database/Cursor;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "cursor"    # Landroid/database/Cursor;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 422
    new-instance v0, Lcom/android/mail/browse/SwipeableConversationItemView;

    iget-object v1, p0, Lcom/android/mail/ui/AnimatedAdapter;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v1, v1, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-direct {v0, p1, v1}, Lcom/android/mail/browse/SwipeableConversationItemView;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 424
    .local v0, "view":Lcom/android/mail/browse/SwipeableConversationItemView;
    return-object v0
.end method

.method public onAnimationCancel(Landroid/animation/Animator;)V
    .locals 0
    .param p1, "animation"    # Landroid/animation/Animator;

    .prologue
    .line 573
    invoke-virtual {p0, p1}, Lcom/android/mail/ui/AnimatedAdapter;->onAnimationEnd(Landroid/animation/Animator;)V

    .line 574
    return-void
.end method

.method public onAnimationEnd(Landroid/animation/Animator;)V
    .locals 5
    .param p1, "animation"    # Landroid/animation/Animator;

    .prologue
    .line 522
    instance-of v3, p1, Landroid/animation/AnimatorSet;

    if-eqz v3, :cond_2

    move-object v2, p1

    .line 523
    check-cast v2, Landroid/animation/AnimatorSet;

    .line 524
    .local v2, "set":Landroid/animation/AnimatorSet;
    invoke-virtual {v2}, Landroid/animation/AnimatorSet;->getChildAnimations()Ljava/util/ArrayList;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/animation/ObjectAnimator;

    invoke-virtual {v3}, Landroid/animation/ObjectAnimator;->getTarget()Ljava/lang/Object;

    move-result-object v0

    .line 528
    .end local v2    # "set":Landroid/animation/AnimatorSet;
    .end local p1    # "animation":Landroid/animation/Animator;
    .local v0, "obj":Ljava/lang/Object;
    :goto_0
    iget-object v3, p0, Lcom/android/mail/ui/AnimatedAdapter;->mSwipeDeletingItems:Ljava/util/HashSet;

    invoke-direct {p0, v0, v3}, Lcom/android/mail/ui/AnimatedAdapter;->updateAnimatingConversationItems(Ljava/lang/Object;Ljava/util/HashSet;)V

    .line 529
    iget-object v3, p0, Lcom/android/mail/ui/AnimatedAdapter;->mDeletingItems:Ljava/util/HashSet;

    invoke-direct {p0, v0, v3}, Lcom/android/mail/ui/AnimatedAdapter;->updateAnimatingConversationItems(Ljava/lang/Object;Ljava/util/HashSet;)V

    .line 530
    iget-object v3, p0, Lcom/android/mail/ui/AnimatedAdapter;->mSwipeUndoingItems:Ljava/util/HashSet;

    invoke-direct {p0, v0, v3}, Lcom/android/mail/ui/AnimatedAdapter;->updateAnimatingConversationItems(Ljava/lang/Object;Ljava/util/HashSet;)V

    .line 531
    iget-object v3, p0, Lcom/android/mail/ui/AnimatedAdapter;->mUndoingItems:Ljava/util/HashSet;

    invoke-direct {p0, v0, v3}, Lcom/android/mail/ui/AnimatedAdapter;->updateAnimatingConversationItems(Ljava/lang/Object;Ljava/util/HashSet;)V

    .line 532
    invoke-direct {p0}, Lcom/android/mail/ui/AnimatedAdapter;->hasFadeLeaveBehinds()Z

    move-result v3

    if-eqz v3, :cond_0

    instance-of v3, v0, Lcom/android/mail/ui/LeaveBehindItem;

    if-eqz v3, :cond_0

    move-object v1, v0

    .line 533
    check-cast v1, Lcom/android/mail/ui/LeaveBehindItem;

    .line 534
    .local v1, "objItem":Lcom/android/mail/ui/LeaveBehindItem;
    invoke-virtual {v1}, Lcom/android/mail/ui/LeaveBehindItem;->getConversationId()J

    move-result-wide v3

    invoke-virtual {p0, v3, v4}, Lcom/android/mail/ui/AnimatedAdapter;->clearLeaveBehind(J)V

    .line 535
    invoke-virtual {v1}, Lcom/android/mail/ui/LeaveBehindItem;->commit()V

    .line 537
    invoke-virtual {p0}, Lcom/android/mail/ui/AnimatedAdapter;->notifyDataSetChanged()V

    .line 540
    .end local v1    # "objItem":Lcom/android/mail/ui/LeaveBehindItem;
    :cond_0
    invoke-virtual {p0}, Lcom/android/mail/ui/AnimatedAdapter;->isAnimating()Z

    move-result v3

    if-nez v3, :cond_1

    .line 541
    iget-object v3, p0, Lcom/android/mail/ui/AnimatedAdapter;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v3, p0}, Lcom/android/mail/ui/ControllableActivity;->onAnimationEnd(Lcom/android/mail/ui/AnimatedAdapter;)V

    .line 543
    :cond_1
    return-void

    .line 526
    .end local v0    # "obj":Ljava/lang/Object;
    .restart local p1    # "animation":Landroid/animation/Animator;
    :cond_2
    check-cast p1, Landroid/animation/ObjectAnimator;

    .end local p1    # "animation":Landroid/animation/Animator;
    invoke-virtual {p1}, Landroid/animation/ObjectAnimator;->getTarget()Ljava/lang/Object;

    move-result-object v0

    .restart local v0    # "obj":Ljava/lang/Object;
    goto :goto_0
.end method

.method public onAnimationRepeat(Landroid/animation/Animator;)V
    .locals 0
    .param p1, "animation"    # Landroid/animation/Animator;

    .prologue
    .line 578
    return-void
.end method

.method public onAnimationStart(Landroid/animation/Animator;)V
    .locals 1
    .param p1, "animation"    # Landroid/animation/Animator;

    .prologue
    .line 498
    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mUndoingItems:Ljava/util/HashSet;

    invoke-virtual {v0}, Ljava/util/HashSet;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 499
    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mDeletingItems:Ljava/util/HashSet;

    invoke-virtual {v0}, Ljava/util/HashSet;->clear()V

    .line 500
    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mLastDeletingItems:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 501
    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mSwipeDeletingItems:Ljava/util/HashSet;

    invoke-virtual {v0}, Ljava/util/HashSet;->clear()V

    .line 505
    :goto_0
    return-void

    .line 503
    :cond_0
    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mUndoingItems:Ljava/util/HashSet;

    invoke-virtual {v0}, Ljava/util/HashSet;->clear()V

    goto :goto_0
.end method

.method public onRestoreInstanceState(Landroid/os/Bundle;)V
    .locals 7
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 625
    const-string v4, "last_deleting_items"

    invoke-virtual {p1, v4}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 626
    const-string v4, "last_deleting_items"

    invoke-virtual {p1, v4}, Landroid/os/Bundle;->getLongArray(Ljava/lang/String;)[J

    move-result-object v2

    .line 627
    .local v2, "lastDeleting":[J
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v4, v2

    if-ge v0, v4, :cond_0

    .line 628
    iget-object v4, p0, Lcom/android/mail/ui/AnimatedAdapter;->mLastDeletingItems:Ljava/util/ArrayList;

    aget-wide v5, v2, v0

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 627
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 631
    .end local v0    # "i":I
    .end local v2    # "lastDeleting":[J
    :cond_0
    const-string v4, "leave_behind_item"

    invoke-virtual {p1, v4}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 632
    const-string v4, "leave_behind_item"

    invoke-virtual {p1, v4}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v3

    check-cast v3, Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData;

    .line 633
    .local v3, "left":Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData;
    iget-object v4, v3, Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData;->data:Lcom/android/mail/providers/Conversation;

    iget-object v5, v3, Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData;->op:Lcom/android/mail/ui/ToastBarOperation;

    iget-object v6, v3, Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData;->data:Lcom/android/mail/providers/Conversation;

    iget v6, v6, Lcom/android/mail/providers/Conversation;->position:I

    invoke-virtual {p0, v4, v5, v6}, Lcom/android/mail/ui/AnimatedAdapter;->setupLeaveBehind(Lcom/android/mail/providers/Conversation;Lcom/android/mail/ui/ToastBarOperation;I)Lcom/android/mail/ui/LeaveBehindItem;

    move-result-object v1

    .line 634
    .local v1, "item":Lcom/android/mail/ui/LeaveBehindItem;
    iput-object v1, p0, Lcom/android/mail/ui/AnimatedAdapter;->mLeaveBehindItem:Lcom/android/mail/ui/LeaveBehindItem;

    .line 636
    .end local v1    # "item":Lcom/android/mail/ui/LeaveBehindItem;
    .end local v3    # "left":Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData;
    :cond_1
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 614
    iget-object v2, p0, Lcom/android/mail/ui/AnimatedAdapter;->mLastDeletingItems:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    new-array v1, v2, [J

    .line 615
    .local v1, "lastDeleting":[J
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v2, v1

    if-ge v0, v2, :cond_0

    .line 616
    iget-object v2, p0, Lcom/android/mail/ui/AnimatedAdapter;->mLastDeletingItems:Ljava/util/ArrayList;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Long;

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    aput-wide v2, v1, v0

    .line 615
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 618
    :cond_0
    const-string v2, "last_deleting_items"

    invoke-virtual {p1, v2, v1}, Landroid/os/Bundle;->putLongArray(Ljava/lang/String;[J)V

    .line 619
    invoke-direct {p0}, Lcom/android/mail/ui/AnimatedAdapter;->hasLeaveBehinds()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 620
    const-string v2, "leave_behind_item"

    iget-object v3, p0, Lcom/android/mail/ui/AnimatedAdapter;->mLeaveBehindItem:Lcom/android/mail/ui/LeaveBehindItem;

    invoke-virtual {v3}, Lcom/android/mail/ui/LeaveBehindItem;->getLeaveBehindData()Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData;

    move-result-object v3

    invoke-virtual {p1, v2, v3}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 622
    :cond_1
    return-void
.end method

.method public setFolder(Lcom/android/mail/providers/Folder;)V
    .locals 0
    .param p1, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 600
    iput-object p1, p0, Lcom/android/mail/ui/AnimatedAdapter;->mFolder:Lcom/android/mail/providers/Folder;

    .line 601
    return-void
.end method

.method public setFooterVisibility(Z)V
    .locals 1
    .param p1, "show"    # Z

    .prologue
    .line 589
    iget-boolean v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mShowFooter:Z

    if-eq v0, p1, :cond_0

    .line 590
    iput-boolean p1, p0, Lcom/android/mail/ui/AnimatedAdapter;->mShowFooter:Z

    .line 591
    invoke-virtual {p0}, Lcom/android/mail/ui/AnimatedAdapter;->notifyDataSetChanged()V

    .line 593
    :cond_0
    return-void
.end method

.method public setSwipeUndo(Z)V
    .locals 2
    .param p1, "undo"    # Z

    .prologue
    .line 153
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mLastDeletingItems:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 154
    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mSwipeUndoingItems:Ljava/util/HashSet;

    iget-object v1, p0, Lcom/android/mail/ui/AnimatedAdapter;->mLastDeletingItems:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->addAll(Ljava/util/Collection;)Z

    .line 155
    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mLastDeletingItems:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 157
    invoke-virtual {p0}, Lcom/android/mail/ui/AnimatedAdapter;->notifyDataSetChanged()V

    .line 158
    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mRefreshAction:Lcom/android/mail/ui/SwipeableListView$ListItemsRemovedListener;

    invoke-direct {p0, v0}, Lcom/android/mail/ui/AnimatedAdapter;->performAndSetNextAction(Lcom/android/mail/ui/SwipeableListView$ListItemsRemovedListener;)V

    .line 160
    :cond_0
    return-void
.end method

.method public setUndo(Z)V
    .locals 2
    .param p1, "undo"    # Z

    .prologue
    .line 143
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mLastDeletingItems:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 144
    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mUndoingItems:Ljava/util/HashSet;

    iget-object v1, p0, Lcom/android/mail/ui/AnimatedAdapter;->mLastDeletingItems:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->addAll(Ljava/util/Collection;)Z

    .line 145
    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mLastDeletingItems:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 147
    invoke-virtual {p0}, Lcom/android/mail/ui/AnimatedAdapter;->notifyDataSetChanged()V

    .line 148
    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mRefreshAction:Lcom/android/mail/ui/SwipeableListView$ListItemsRemovedListener;

    invoke-direct {p0, v0}, Lcom/android/mail/ui/AnimatedAdapter;->performAndSetNextAction(Lcom/android/mail/ui/SwipeableListView$ListItemsRemovedListener;)V

    .line 150
    :cond_0
    return-void
.end method

.method public setupLeaveBehind(Lcom/android/mail/providers/Conversation;Lcom/android/mail/ui/ToastBarOperation;I)Lcom/android/mail/ui/LeaveBehindItem;
    .locals 8
    .param p1, "target"    # Lcom/android/mail/providers/Conversation;
    .param p2, "undoOp"    # Lcom/android/mail/ui/ToastBarOperation;
    .param p3, "deletedRow"    # I

    .prologue
    .line 314
    invoke-virtual {p0}, Lcom/android/mail/ui/AnimatedAdapter;->fadeOutLeaveBehindItems()V

    .line 315
    iget-object v1, p0, Lcom/android/mail/ui/AnimatedAdapter;->mContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/android/mail/ui/AnimatedAdapter;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v2}, Lcom/android/mail/ui/ControllableActivity;->getViewMode()Lcom/android/mail/ui/ViewMode;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getMode(Landroid/content/Context;Lcom/android/mail/ui/ViewMode;)I

    move-result v1

    invoke-static {v1}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->isWideMode(I)Z

    move-result v7

    .line 317
    .local v7, "isWide":Z
    iget-object v1, p0, Lcom/android/mail/ui/AnimatedAdapter;->mContext:Landroid/content/Context;

    invoke-static {v1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    if-eqz v7, :cond_0

    const v1, 0x7f04006c

    :goto_0
    const/4 v3, 0x0

    invoke-virtual {v2, v1, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/android/mail/ui/LeaveBehindItem;

    .line 319
    .local v0, "leaveBehind":Lcom/android/mail/ui/LeaveBehindItem;
    iget-object v2, p0, Lcom/android/mail/ui/AnimatedAdapter;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v6, p0, Lcom/android/mail/ui/AnimatedAdapter;->mFolder:Lcom/android/mail/providers/Folder;

    move v1, p3

    move-object v3, p0

    move-object v4, p2

    move-object v5, p1

    invoke-virtual/range {v0 .. v6}, Lcom/android/mail/ui/LeaveBehindItem;->bindOperations(ILcom/android/mail/providers/Account;Lcom/android/mail/ui/AnimatedAdapter;Lcom/android/mail/ui/ToastBarOperation;Lcom/android/mail/providers/Conversation;Lcom/android/mail/providers/Folder;)V

    .line 320
    iput-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mLeaveBehindItem:Lcom/android/mail/ui/LeaveBehindItem;

    .line 321
    iget-object v1, p0, Lcom/android/mail/ui/AnimatedAdapter;->mLastDeletingItems:Ljava/util/ArrayList;

    iget-wide v2, p1, Lcom/android/mail/providers/Conversation;->id:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 322
    return-object v0

    .line 317
    .end local v0    # "leaveBehind":Lcom/android/mail/ui/LeaveBehindItem;
    :cond_0
    const v1, 0x7f04006a

    goto :goto_0
.end method

.method public swipeDelete(Ljava/util/Collection;Lcom/android/mail/ui/SwipeableListView$ListItemsRemovedListener;)V
    .locals 1
    .param p2, "listener"    # Lcom/android/mail/ui/SwipeableListView$ListItemsRemovedListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;",
            "Lcom/android/mail/ui/SwipeableListView$ListItemsRemovedListener;",
            ")V"
        }
    .end annotation

    .prologue
    .line 215
    .local p1, "conversations":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter;->mSwipeDeletingItems:Ljava/util/HashSet;

    invoke-direct {p0, p1, p2, v0}, Lcom/android/mail/ui/AnimatedAdapter;->delete(Ljava/util/Collection;Lcom/android/mail/ui/SwipeableListView$ListItemsRemovedListener;Ljava/util/HashSet;)V

    .line 216
    return-void
.end method
