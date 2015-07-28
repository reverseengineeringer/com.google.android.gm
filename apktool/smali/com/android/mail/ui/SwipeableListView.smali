.class public Lcom/android/mail/ui/SwipeableListView;
.super Landroid/widget/ListView;
.source "SwipeableListView.java"

# interfaces
.implements Lcom/android/mail/ui/SwipeHelper$Callback;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/ui/SwipeableListView$ListItemSwipedListener;,
        Lcom/android/mail/ui/SwipeableListView$ListItemsRemovedListener;
    }
.end annotation


# static fields
.field public static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private mConvSelectionSet:Lcom/android/mail/ui/ConversationSelectionSet;

.field private mEnableSwipe:Z

.field private mFolder:Lcom/android/mail/providers/Folder;

.field private mSwipeAction:I

.field private mSwipeHelper:Lcom/android/mail/ui/SwipeHelper;

.field private mSwipedListener:Lcom/android/mail/ui/SwipeableListView$ListItemSwipedListener;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 50
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/ui/SwipeableListView;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 58
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/android/mail/ui/SwipeableListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 59
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 62
    const/4 v0, -0x1

    invoke-direct {p0, p1, p2, v0}, Lcom/android/mail/ui/SwipeableListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 63
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    const/4 v2, 0x0

    .line 66
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 48
    iput-boolean v2, p0, Lcom/android/mail/ui/SwipeableListView;->mEnableSwipe:Z

    .line 67
    invoke-virtual {p0}, Lcom/android/mail/ui/SwipeableListView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v4, v0, Landroid/util/DisplayMetrics;->density:F

    .line 68
    .local v4, "densityScale":F
    invoke-static {p1}, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->getScaledPagingTouchSlop()I

    move-result v0

    int-to-float v5, v0

    .line 69
    .local v5, "pagingTouchSlop":F
    new-instance v0, Lcom/android/mail/ui/SwipeHelper;

    move-object v1, p1

    move-object v3, p0

    invoke-direct/range {v0 .. v5}, Lcom/android/mail/ui/SwipeHelper;-><init>(Landroid/content/Context;ILcom/android/mail/ui/SwipeHelper$Callback;FF)V

    iput-object v0, p0, Lcom/android/mail/ui/SwipeableListView;->mSwipeHelper:Lcom/android/mail/ui/SwipeHelper;

    .line 71
    return-void
.end method

.method private getAnimatedAdapter()Lcom/android/mail/ui/AnimatedAdapter;
    .locals 1

    .prologue
    .line 337
    invoke-virtual {p0}, Lcom/android/mail/ui/SwipeableListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/android/mail/ui/AnimatedAdapter;

    return-object v0
.end method


# virtual methods
.method public canChildBeDismissed(Lcom/android/mail/ui/SwipeableItemView;)Z
    .locals 1
    .param p1, "v"    # Lcom/android/mail/ui/SwipeableItemView;

    .prologue
    .line 177
    invoke-interface {p1}, Lcom/android/mail/ui/SwipeableItemView;->canChildBeDismissed()Z

    move-result v0

    return v0
.end method

.method public commitDestructiveActions(Z)V
    .locals 1
    .param p1, "animate"    # Z

    .prologue
    .line 190
    invoke-direct {p0}, Lcom/android/mail/ui/SwipeableListView;->getAnimatedAdapter()Lcom/android/mail/ui/AnimatedAdapter;

    move-result-object v0

    .line 191
    .local v0, "adapter":Lcom/android/mail/ui/AnimatedAdapter;
    if-eqz v0, :cond_0

    .line 192
    invoke-virtual {v0, p1}, Lcom/android/mail/ui/AnimatedAdapter;->commitLeaveBehindItems(Z)V

    .line 194
    :cond_0
    return-void
.end method

.method public destroyItems(Ljava/util/ArrayList;Lcom/android/mail/ui/SwipeableListView$ListItemsRemovedListener;)V
    .locals 5
    .param p2, "listener"    # Lcom/android/mail/ui/SwipeableListView$ListItemsRemovedListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/android/mail/browse/ConversationItemView;",
            ">;",
            "Lcom/android/mail/ui/SwipeableListView$ListItemsRemovedListener;",
            ")V"
        }
    .end annotation

    .prologue
    .line 273
    .local p1, "views":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/android/mail/browse/ConversationItemView;>;"
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-nez v4, :cond_1

    .line 287
    :cond_0
    :goto_0
    return-void

    .line 277
    :cond_1
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 278
    .local v1, "conversations":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/android/mail/providers/Conversation;>;"
    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_2
    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_3

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/android/mail/browse/ConversationItemView;

    .line 279
    .local v3, "view":Lcom/android/mail/browse/ConversationItemView;
    if-eqz v3, :cond_2

    .line 282
    invoke-virtual {v3}, Lcom/android/mail/browse/ConversationItemView;->getConversation()Lcom/android/mail/providers/Conversation;

    move-result-object v0

    .line 283
    .local v0, "conv":Lcom/android/mail/providers/Conversation;
    invoke-virtual {p0, v3, v0}, Lcom/android/mail/ui/SwipeableListView;->findConversation(Lcom/android/mail/browse/ConversationItemView;Lcom/android/mail/providers/Conversation;)I

    move-result v4

    iput v4, v0, Lcom/android/mail/providers/Conversation;->position:I

    .line 284
    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 286
    .end local v0    # "conv":Lcom/android/mail/providers/Conversation;
    .end local v3    # "view":Lcom/android/mail/browse/ConversationItemView;
    :cond_3
    invoke-virtual {p0, v1, p2}, Lcom/android/mail/ui/SwipeableListView;->destroyItems(Ljava/util/Collection;Lcom/android/mail/ui/SwipeableListView$ListItemsRemovedListener;)V

    goto :goto_0
.end method

.method public destroyItems(Ljava/util/Collection;Lcom/android/mail/ui/SwipeableListView$ListItemsRemovedListener;)V
    .locals 4
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
    .line 294
    .local p1, "convs":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    if-nez p1, :cond_0

    .line 303
    :goto_0
    return-void

    .line 297
    :cond_0
    invoke-direct {p0}, Lcom/android/mail/ui/SwipeableListView;->getAnimatedAdapter()Lcom/android/mail/ui/AnimatedAdapter;

    move-result-object v0

    .line 298
    .local v0, "adapter":Lcom/android/mail/ui/AnimatedAdapter;
    if-nez v0, :cond_1

    .line 299
    sget-object v1, Lcom/android/mail/ui/SwipeableListView;->LOG_TAG:Ljava/lang/String;

    const-string v2, "SwipeableListView.destroyItems: Cannot destroy: adapter is null."

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v1, v2, v3}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0

    .line 302
    :cond_1
    invoke-virtual {v0, p1, p2}, Lcom/android/mail/ui/AnimatedAdapter;->swipeDelete(Ljava/util/Collection;Lcom/android/mail/ui/SwipeableListView$ListItemsRemovedListener;)V

    goto :goto_0
.end method

.method public dismissChild(Lcom/android/mail/browse/ConversationItemView;)V
    .locals 12
    .param p1, "target"    # Lcom/android/mail/browse/ConversationItemView;

    .prologue
    const/4 v11, 0x1

    const/4 v10, 0x0

    .line 197
    invoke-virtual {p0}, Lcom/android/mail/ui/SwipeableListView;->getContext()Landroid/content/Context;

    move-result-object v2

    .line 200
    .local v2, "context":Landroid/content/Context;
    new-instance v7, Lcom/android/mail/ui/ToastBarOperation;

    iget v8, p0, Lcom/android/mail/ui/SwipeableListView;->mSwipeAction:I

    invoke-direct {v7, v11, v8, v10, v10}, Lcom/android/mail/ui/ToastBarOperation;-><init>(IIIZ)V

    .line 201
    .local v7, "undoOp":Lcom/android/mail/ui/ToastBarOperation;
    invoke-virtual {p1}, Lcom/android/mail/browse/ConversationItemView;->getConversation()Lcom/android/mail/providers/Conversation;

    move-result-object v3

    .line 202
    .local v3, "conv":Lcom/android/mail/providers/Conversation;
    invoke-virtual {p1}, Lcom/android/mail/browse/ConversationItemView;->getConversation()Lcom/android/mail/providers/Conversation;

    move-result-object v8

    invoke-virtual {p0, p1, v3}, Lcom/android/mail/ui/SwipeableListView;->findConversation(Lcom/android/mail/browse/ConversationItemView;Lcom/android/mail/providers/Conversation;)I

    move-result v9

    iput v9, v8, Lcom/android/mail/providers/Conversation;->position:I

    .line 203
    invoke-direct {p0}, Lcom/android/mail/ui/SwipeableListView;->getAnimatedAdapter()Lcom/android/mail/ui/AnimatedAdapter;

    move-result-object v0

    .line 204
    .local v0, "adapter":Lcom/android/mail/ui/AnimatedAdapter;
    if-nez v0, :cond_1

    .line 240
    :cond_0
    :goto_0
    return-void

    .line 207
    :cond_1
    iget v8, v3, Lcom/android/mail/providers/Conversation;->position:I

    invoke-virtual {v0, v3, v7, v8}, Lcom/android/mail/ui/AnimatedAdapter;->setupLeaveBehind(Lcom/android/mail/providers/Conversation;Lcom/android/mail/ui/ToastBarOperation;I)Lcom/android/mail/ui/LeaveBehindItem;

    .line 208
    invoke-virtual {v0}, Lcom/android/mail/ui/AnimatedAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v1

    check-cast v1, Lcom/android/mail/browse/ConversationCursor;

    .line 209
    .local v1, "cc":Lcom/android/mail/browse/ConversationCursor;
    invoke-static {v3}, Lcom/android/mail/providers/Conversation;->listOf(Lcom/android/mail/providers/Conversation;)Ljava/util/Collection;

    move-result-object v4

    .line 210
    .local v4, "convList":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    iget v8, p0, Lcom/android/mail/ui/SwipeableListView;->mSwipeAction:I

    packed-switch v8, :pswitch_data_0

    .line 227
    :goto_1
    iget-object v8, p0, Lcom/android/mail/ui/SwipeableListView;->mSwipedListener:Lcom/android/mail/ui/SwipeableListView$ListItemSwipedListener;

    if-eqz v8, :cond_2

    .line 228
    iget-object v8, p0, Lcom/android/mail/ui/SwipeableListView;->mSwipedListener:Lcom/android/mail/ui/SwipeableListView$ListItemSwipedListener;

    invoke-interface {v8, v4}, Lcom/android/mail/ui/SwipeableListView$ListItemSwipedListener;->onListItemSwiped(Ljava/util/Collection;)V

    .line 230
    :cond_2
    invoke-virtual {v0}, Lcom/android/mail/ui/AnimatedAdapter;->notifyDataSetChanged()V

    .line 231
    iget-object v8, p0, Lcom/android/mail/ui/SwipeableListView;->mConvSelectionSet:Lcom/android/mail/ui/ConversationSelectionSet;

    if-eqz v8, :cond_0

    iget-object v8, p0, Lcom/android/mail/ui/SwipeableListView;->mConvSelectionSet:Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-virtual {v8}, Lcom/android/mail/ui/ConversationSelectionSet;->isEmpty()Z

    move-result v8

    if-nez v8, :cond_0

    iget-object v8, p0, Lcom/android/mail/ui/SwipeableListView;->mConvSelectionSet:Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-virtual {v8, v3}, Lcom/android/mail/ui/ConversationSelectionSet;->contains(Lcom/android/mail/providers/Conversation;)Z

    move-result v8

    if-eqz v8, :cond_0

    .line 233
    iget-object v8, p0, Lcom/android/mail/ui/SwipeableListView;->mConvSelectionSet:Lcom/android/mail/ui/ConversationSelectionSet;

    const/4 v9, 0x0

    invoke-virtual {v8, v9, v3}, Lcom/android/mail/ui/ConversationSelectionSet;->toggle(Lcom/android/mail/browse/ConversationItemView;Lcom/android/mail/providers/Conversation;)V

    .line 236
    invoke-virtual {v3}, Lcom/android/mail/providers/Conversation;->isMostlyDead()Z

    move-result v8

    if-nez v8, :cond_0

    iget-object v8, p0, Lcom/android/mail/ui/SwipeableListView;->mConvSelectionSet:Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-virtual {v8}, Lcom/android/mail/ui/ConversationSelectionSet;->isEmpty()Z

    move-result v8

    if-eqz v8, :cond_0

    .line 237
    invoke-virtual {p0, v11}, Lcom/android/mail/ui/SwipeableListView;->commitDestructiveActions(Z)V

    goto :goto_0

    .line 212
    :pswitch_0
    new-instance v5, Lcom/android/mail/ui/FolderOperation;

    iget-object v8, p0, Lcom/android/mail/ui/SwipeableListView;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-static {v10}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v9

    invoke-direct {v5, v8, v9}, Lcom/android/mail/ui/FolderOperation;-><init>(Lcom/android/mail/providers/Folder;Ljava/lang/Boolean;)V

    .line 213
    .local v5, "folderOp":Lcom/android/mail/ui/FolderOperation;
    invoke-virtual {v3}, Lcom/android/mail/providers/Conversation;->getRawFolders()Ljava/util/ArrayList;

    move-result-object v8

    invoke-static {v8}, Lcom/android/mail/providers/Folder;->hashMapForFolders(Ljava/util/ArrayList;)Ljava/util/HashMap;

    move-result-object v6

    .line 215
    .local v6, "targetFolders":Ljava/util/HashMap;, "Ljava/util/HashMap<Landroid/net/Uri;Lcom/android/mail/providers/Folder;>;"
    iget-object v8, v5, Lcom/android/mail/ui/FolderOperation;->mFolder:Lcom/android/mail/providers/Folder;

    iget-object v8, v8, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    invoke-virtual {v6, v8}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 216
    invoke-virtual {v6}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v8

    invoke-static {v8}, Lcom/android/mail/providers/Folder;->getSerializedFolderString(Ljava/util/Collection;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v3, v8}, Lcom/android/mail/providers/Conversation;->setRawFolders(Ljava/lang/String;)V

    .line 217
    invoke-static {v3}, Lcom/android/mail/providers/Conversation;->listOf(Lcom/android/mail/providers/Conversation;)Ljava/util/Collection;

    move-result-object v8

    const-string v9, "rawFolders"

    invoke-virtual {v3}, Lcom/android/mail/providers/Conversation;->getRawFoldersString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v1, v2, v8, v9, v10}, Lcom/android/mail/browse/ConversationCursor;->mostlyDestructiveUpdate(Landroid/content/Context;Ljava/util/Collection;Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 221
    .end local v5    # "folderOp":Lcom/android/mail/ui/FolderOperation;
    .end local v6    # "targetFolders":Ljava/util/HashMap;, "Ljava/util/HashMap<Landroid/net/Uri;Lcom/android/mail/providers/Folder;>;"
    :pswitch_1
    invoke-virtual {v1, v2, v4}, Lcom/android/mail/browse/ConversationCursor;->mostlyArchive(Landroid/content/Context;Ljava/util/Collection;)I

    goto :goto_1

    .line 224
    :pswitch_2
    invoke-virtual {v1, v2, v4}, Lcom/android/mail/browse/ConversationCursor;->mostlyDelete(Landroid/content/Context;Ljava/util/Collection;)I

    goto :goto_1

    .line 210
    nop

    :pswitch_data_0
    .packed-switch 0x7f100123
        :pswitch_1
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method public enableSwipe(Z)V
    .locals 0
    .param p1, "enable"    # Z

    .prologue
    .line 103
    iput-boolean p1, p0, Lcom/android/mail/ui/SwipeableListView;->mEnableSwipe:Z

    .line 104
    return-void
.end method

.method public findConversation(Lcom/android/mail/browse/ConversationItemView;Lcom/android/mail/providers/Conversation;)I
    .locals 13
    .param p1, "view"    # Lcom/android/mail/browse/ConversationItemView;
    .param p2, "conv"    # Lcom/android/mail/providers/Conversation;

    .prologue
    const/4 v12, -0x1

    .line 306
    iget v8, p2, Lcom/android/mail/providers/Conversation;->position:I

    .line 307
    .local v8, "position":I
    iget-wide v1, p2, Lcom/android/mail/providers/Conversation;->id:J

    .line 309
    .local v1, "convId":J
    if-ne v8, v12, :cond_0

    .line 310
    :try_start_0
    invoke-virtual {p0, p1}, Lcom/android/mail/ui/SwipeableListView;->getPositionForView(Landroid/view/View;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v8

    .line 316
    :cond_0
    :goto_0
    if-ne v8, v12, :cond_1

    .line 320
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_1
    invoke-virtual {p0}, Lcom/android/mail/ui/SwipeableListView;->getChildCount()I

    move-result v9

    if-ge v7, v9, :cond_1

    .line 321
    invoke-virtual {p0, v7}, Lcom/android/mail/ui/SwipeableListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 322
    .local v0, "child":Landroid/view/View;
    instance-of v9, v0, Lcom/android/mail/browse/SwipeableConversationItemView;

    if-eqz v9, :cond_2

    .line 323
    check-cast v0, Lcom/android/mail/browse/SwipeableConversationItemView;

    .end local v0    # "child":Landroid/view/View;
    invoke-virtual {v0}, Lcom/android/mail/browse/SwipeableConversationItemView;->getSwipeableItemView()Lcom/android/mail/browse/ConversationItemView;

    move-result-object v9

    invoke-virtual {v9}, Lcom/android/mail/browse/ConversationItemView;->getConversation()Lcom/android/mail/providers/Conversation;

    move-result-object v4

    .line 325
    .local v4, "foundConv":Lcom/android/mail/providers/Conversation;
    iget-wide v5, v4, Lcom/android/mail/providers/Conversation;->id:J

    .line 326
    .local v5, "foundId":J
    cmp-long v9, v5, v1

    if-nez v9, :cond_2

    .line 327
    move v8, v7

    .line 333
    .end local v4    # "foundConv":Lcom/android/mail/providers/Conversation;
    .end local v5    # "foundId":J
    .end local v7    # "i":I
    :cond_1
    return v8

    .line 312
    :catch_0
    move-exception v3

    .line 313
    .local v3, "e":Ljava/lang/Exception;
    const/4 v8, -0x1

    .line 314
    sget-object v9, Lcom/android/mail/ui/SwipeableListView;->LOG_TAG:Ljava/lang/String;

    const-string v10, "Exception finding position; using alternate strategy"

    const/4 v11, 0x0

    new-array v11, v11, [Ljava/lang/Object;

    invoke-static {v9, v10, v11}, Lcom/android/mail/utils/LogUtils;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0

    .line 320
    .end local v3    # "e":Ljava/lang/Exception;
    .restart local v7    # "i":I
    :cond_2
    add-int/lit8 v7, v7, 0x1

    goto :goto_1
.end method

.method public getChildAtPosition(Landroid/view/MotionEvent;)Landroid/view/View;
    .locals 6
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    .line 156
    invoke-virtual {p0}, Lcom/android/mail/ui/SwipeableListView;->getChildCount()I

    move-result v1

    .line 157
    .local v1, "count":I
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v4

    float-to-int v3, v4

    .line 158
    .local v3, "touchY":I
    const/4 v0, 0x0

    .line 160
    .local v0, "childIdx":I
    :goto_0
    if-ge v0, v1, :cond_3

    .line 161
    invoke-virtual {p0, v0}, Lcom/android/mail/ui/SwipeableListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .line 162
    .local v2, "slidingChild":Landroid/view/View;
    invoke-virtual {v2}, Landroid/view/View;->getVisibility()I

    move-result v4

    const/16 v5, 0x8

    if-ne v4, v5, :cond_1

    .line 160
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 165
    :cond_1
    invoke-virtual {v2}, Landroid/view/View;->getTop()I

    move-result v4

    if-lt v3, v4, :cond_0

    invoke-virtual {v2}, Landroid/view/View;->getBottom()I

    move-result v4

    if-gt v3, v4, :cond_0

    .line 166
    instance-of v4, v2, Lcom/android/mail/browse/SwipeableConversationItemView;

    if-eqz v4, :cond_2

    .line 167
    check-cast v2, Lcom/android/mail/browse/SwipeableConversationItemView;

    .end local v2    # "slidingChild":Landroid/view/View;
    invoke-virtual {v2}, Lcom/android/mail/browse/SwipeableConversationItemView;->getSwipeableItemView()Lcom/android/mail/browse/ConversationItemView;

    move-result-object v2

    .line 172
    :cond_2
    :goto_1
    return-object v2

    :cond_3
    const/4 v2, 0x0

    goto :goto_1
.end method

.method public getSwipeAction()I
    .locals 1

    .prologue
    .line 119
    iget v0, p0, Lcom/android/mail/ui/SwipeableListView;->mSwipeAction:I

    return v0
.end method

.method public onBeginDrag(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 246
    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Lcom/android/mail/ui/SwipeableListView;->requestDisallowInterceptTouchEvent(Z)V

    .line 247
    const/4 v0, 0x0

    .line 248
    .local v0, "view":Lcom/android/mail/browse/SwipeableConversationItemView;
    instance-of v1, p1, Lcom/android/mail/browse/ConversationItemView;

    if-eqz v1, :cond_0

    .line 249
    invoke-virtual {p1}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    .end local v0    # "view":Lcom/android/mail/browse/SwipeableConversationItemView;
    check-cast v0, Lcom/android/mail/browse/SwipeableConversationItemView;

    .line 251
    .restart local v0    # "view":Lcom/android/mail/browse/SwipeableConversationItemView;
    :cond_0
    if-eqz v0, :cond_1

    .line 252
    invoke-virtual {p0}, Lcom/android/mail/ui/SwipeableListView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/SwipeableConversationItemView;->addBackground(Landroid/content/Context;)V

    .line 253
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/SwipeableConversationItemView;->setBackgroundVisibility(I)V

    .line 255
    :cond_1
    return-void
.end method

.method public onChildDismissed(Lcom/android/mail/ui/SwipeableItemView;)V
    .locals 0
    .param p1, "v"    # Lcom/android/mail/ui/SwipeableItemView;

    .prologue
    .line 182
    if-eqz p1, :cond_0

    .line 183
    invoke-interface {p1}, Lcom/android/mail/ui/SwipeableItemView;->dismiss()V

    .line 185
    :cond_0
    return-void
.end method

.method protected onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 3
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .prologue
    .line 75
    invoke-super {p0, p1}, Landroid/widget/ListView;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 76
    invoke-virtual {p0}, Lcom/android/mail/ui/SwipeableListView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    iget v0, v2, Landroid/util/DisplayMetrics;->density:F

    .line 77
    .local v0, "densityScale":F
    iget-object v2, p0, Lcom/android/mail/ui/SwipeableListView;->mSwipeHelper:Lcom/android/mail/ui/SwipeHelper;

    invoke-virtual {v2, v0}, Lcom/android/mail/ui/SwipeHelper;->setDensityScale(F)V

    .line 78
    invoke-virtual {p0}, Lcom/android/mail/ui/SwipeableListView;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/ViewConfiguration;->getScaledPagingTouchSlop()I

    move-result v2

    int-to-float v1, v2

    .line 79
    .local v1, "pagingTouchSlop":F
    iget-object v2, p0, Lcom/android/mail/ui/SwipeableListView;->mSwipeHelper:Lcom/android/mail/ui/SwipeHelper;

    invoke-virtual {v2, v1}, Lcom/android/mail/ui/SwipeHelper;->setPagingTouchSlop(F)V

    .line 80
    return-void
.end method

.method public onDragCancelled(Lcom/android/mail/ui/SwipeableItemView;)V
    .locals 2
    .param p1, "v"    # Lcom/android/mail/ui/SwipeableItemView;

    .prologue
    .line 259
    const/4 v0, 0x0

    .line 260
    .local v0, "view":Lcom/android/mail/browse/SwipeableConversationItemView;
    instance-of v1, p1, Lcom/android/mail/browse/ConversationItemView;

    if-eqz v1, :cond_0

    .line 261
    check-cast p1, Landroid/view/View;

    .end local p1    # "v":Lcom/android/mail/ui/SwipeableItemView;
    invoke-virtual {p1}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    .end local v0    # "view":Lcom/android/mail/browse/SwipeableConversationItemView;
    check-cast v0, Lcom/android/mail/browse/SwipeableConversationItemView;

    .line 263
    .restart local v0    # "view":Lcom/android/mail/browse/SwipeableConversationItemView;
    :cond_0
    if-eqz v0, :cond_1

    .line 264
    invoke-virtual {v0}, Lcom/android/mail/browse/SwipeableConversationItemView;->removeBackground()V

    .line 266
    :cond_1
    return-void
.end method

.method protected onFocusChanged(ZILandroid/graphics/Rect;)V
    .locals 7
    .param p1, "gainFocus"    # Z
    .param p2, "direction"    # I
    .param p3, "previouslyFocusedRect"    # Landroid/graphics/Rect;

    .prologue
    const/4 v4, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 84
    const-string v0, "MailBlankFragment"

    const-string v1, "START CLF-ListView.onFocusChanged layoutRequested=%s root.layoutRequested=%s"

    new-array v2, v4, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/android/mail/ui/SwipeableListView;->isLayoutRequested()Z

    move-result v3

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-virtual {p0}, Lcom/android/mail/ui/SwipeableListView;->getRootView()Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/View;->isLayoutRequested()Z

    move-result v3

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    aput-object v3, v2, v6

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 87
    invoke-super {p0, p1, p2, p3}, Landroid/widget/ListView;->onFocusChanged(ZILandroid/graphics/Rect;)V

    .line 88
    const-string v0, "MailBlankFragment"

    new-instance v1, Ljava/lang/Error;

    invoke-direct {v1}, Ljava/lang/Error;-><init>()V

    const-string v2, "FINISH CLF-ListView.onFocusChanged layoutRequested=%s root.layoutRequested=%s"

    new-array v3, v4, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/android/mail/ui/SwipeableListView;->isLayoutRequested()Z

    move-result v4

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-virtual {p0}, Lcom/android/mail/ui/SwipeableListView;->getRootView()Landroid/view/View;

    move-result-object v4

    invoke-virtual {v4}, Landroid/view/View;->isLayoutRequested()Z

    move-result v4

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-static {v0, v1, v2, v3}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 91
    return-void
.end method

.method public onInterceptTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    .line 137
    iget-boolean v0, p0, Lcom/android/mail/ui/SwipeableListView;->mEnableSwipe:Z

    if-eqz v0, :cond_2

    .line 138
    iget-object v0, p0, Lcom/android/mail/ui/SwipeableListView;->mSwipeHelper:Lcom/android/mail/ui/SwipeHelper;

    invoke-virtual {v0, p1}, Lcom/android/mail/ui/SwipeHelper;->onInterceptTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-super {p0, p1}, Landroid/widget/ListView;->onInterceptTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    .line 140
    :goto_0
    return v0

    .line 138
    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    .line 140
    :cond_2
    invoke-super {p0, p1}, Landroid/widget/ListView;->onInterceptTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method public onScroll()V
    .locals 1

    .prologue
    .line 351
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/SwipeableListView;->commitDestructiveActions(Z)V

    .line 352
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    .line 146
    iget-boolean v0, p0, Lcom/android/mail/ui/SwipeableListView;->mEnableSwipe:Z

    if-eqz v0, :cond_2

    .line 147
    iget-object v0, p0, Lcom/android/mail/ui/SwipeableListView;->mSwipeHelper:Lcom/android/mail/ui/SwipeHelper;

    invoke-virtual {v0, p1}, Lcom/android/mail/ui/SwipeHelper;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-super {p0, p1}, Landroid/widget/ListView;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    .line 149
    :goto_0
    return v0

    .line 147
    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    .line 149
    :cond_2
    invoke-super {p0, p1}, Landroid/widget/ListView;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method public performItemClick(Landroid/view/View;IJ)Z
    .locals 2
    .param p1, "view"    # Landroid/view/View;
    .param p2, "pos"    # I
    .param p3, "id"    # J

    .prologue
    .line 342
    invoke-super {p0, p1, p2, p3, p4}, Landroid/widget/ListView;->performItemClick(Landroid/view/View;IJ)Z

    move-result v0

    .line 345
    .local v0, "handled":Z
    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Lcom/android/mail/ui/SwipeableListView;->commitDestructiveActions(Z)V

    .line 346
    return v0
.end method

.method public requestLayout()V
    .locals 0

    .prologue
    .line 95
    invoke-static {p0}, Lcom/android/mail/utils/Utils;->checkRequestLayout(Landroid/view/View;)V

    .line 96
    invoke-super {p0}, Landroid/widget/ListView;->requestLayout()V

    .line 97
    return-void
.end method

.method public setCurrentFolder(Lcom/android/mail/providers/Folder;)V
    .locals 0
    .param p1, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 127
    iput-object p1, p0, Lcom/android/mail/ui/SwipeableListView;->mFolder:Lcom/android/mail/providers/Folder;

    .line 128
    return-void
.end method

.method public setSelectionSet(Lcom/android/mail/ui/ConversationSelectionSet;)V
    .locals 0
    .param p1, "set"    # Lcom/android/mail/ui/ConversationSelectionSet;

    .prologue
    .line 123
    iput-object p1, p0, Lcom/android/mail/ui/SwipeableListView;->mConvSelectionSet:Lcom/android/mail/ui/ConversationSelectionSet;

    .line 124
    return-void
.end method

.method public setSwipeAction(I)V
    .locals 0
    .param p1, "action"    # I

    .prologue
    .line 111
    iput p1, p0, Lcom/android/mail/ui/SwipeableListView;->mSwipeAction:I

    .line 112
    return-void
.end method

.method public setSwipedListener(Lcom/android/mail/ui/SwipeableListView$ListItemSwipedListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/android/mail/ui/SwipeableListView$ListItemSwipedListener;

    .prologue
    .line 115
    iput-object p1, p0, Lcom/android/mail/ui/SwipeableListView;->mSwipedListener:Lcom/android/mail/ui/SwipeableListView$ListItemSwipedListener;

    .line 116
    return-void
.end method
