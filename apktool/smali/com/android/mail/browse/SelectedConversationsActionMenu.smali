.class public Lcom/android/mail/browse/SelectedConversationsActionMenu;
.super Ljava/lang/Object;
.source "SelectedConversationsActionMenu.java"

# interfaces
.implements Landroid/view/ActionMode$Callback;
.implements Lcom/android/mail/ui/ConversationSetObserver;


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private mAccount:Lcom/android/mail/providers/Account;

.field private mAccountObserver:Lcom/android/mail/providers/AccountObserver;

.field private mActionMode:Landroid/view/ActionMode;

.field private mActivated:Z

.field private final mActivity:Lcom/android/mail/ui/ControllableActivity;

.field private final mContext:Landroid/content/Context;

.field private final mFolder:Lcom/android/mail/providers/Folder;

.field private final mListController:Lcom/android/mail/ui/ConversationListCallbacks;

.field private mMenu:Landroid/view/Menu;

.field protected final mSelectionSet:Lcom/android/mail/ui/ConversationSelectionSet;

.field private final mUpdater:Lcom/android/mail/ui/ConversationUpdater;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 66
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/android/mail/ui/ControllableActivity;Lcom/android/mail/ui/ConversationSelectionSet;Lcom/android/mail/providers/Folder;Lcom/android/mail/ui/SwipeableListView;)V
    .locals 2
    .param p1, "activity"    # Lcom/android/mail/ui/ControllableActivity;
    .param p2, "selectionSet"    # Lcom/android/mail/ui/ConversationSelectionSet;
    .param p3, "folder"    # Lcom/android/mail/providers/Folder;
    .param p4, "list"    # Lcom/android/mail/ui/SwipeableListView;

    .prologue
    .line 99
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 84
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mActivated:Z

    .line 100
    iput-object p1, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    .line 101
    invoke-interface {p1}, Lcom/android/mail/ui/ControllableActivity;->getListHandler()Lcom/android/mail/ui/ConversationListCallbacks;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mListController:Lcom/android/mail/ui/ConversationListCallbacks;

    .line 102
    iput-object p2, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mSelectionSet:Lcom/android/mail/ui/ConversationSelectionSet;

    .line 103
    new-instance v0, Lcom/android/mail/browse/SelectedConversationsActionMenu$1;

    invoke-direct {v0, p0}, Lcom/android/mail/browse/SelectedConversationsActionMenu$1;-><init>(Lcom/android/mail/browse/SelectedConversationsActionMenu;)V

    iput-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mAccountObserver:Lcom/android/mail/providers/AccountObserver;

    .line 109
    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mAccountObserver:Lcom/android/mail/providers/AccountObserver;

    invoke-interface {p1}, Lcom/android/mail/ui/ControllableActivity;->getAccountController()Lcom/android/mail/ui/AccountController;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/android/mail/providers/AccountObserver;->initialize(Lcom/android/mail/ui/AccountController;)Lcom/android/mail/providers/Account;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mAccount:Lcom/android/mail/providers/Account;

    .line 110
    iput-object p3, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mFolder:Lcom/android/mail/providers/Folder;

    .line 111
    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getActivityContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mContext:Landroid/content/Context;

    .line 112
    invoke-interface {p1}, Lcom/android/mail/ui/ControllableActivity;->getConversationUpdater()Lcom/android/mail/ui/ConversationUpdater;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mUpdater:Lcom/android/mail/ui/ConversationUpdater;

    .line 113
    invoke-static {}, Lcom/android/mail/ui/FolderSelectionDialog;->setDialogDismissed()V

    .line 114
    return-void
.end method

.method static synthetic access$002(Lcom/android/mail/browse/SelectedConversationsActionMenu;Lcom/android/mail/providers/Account;)Lcom/android/mail/providers/Account;
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/browse/SelectedConversationsActionMenu;
    .param p1, "x1"    # Lcom/android/mail/providers/Account;

    .prologue
    .line 63
    iput-object p1, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mAccount:Lcom/android/mail/providers/Account;

    return-object p1
.end method

.method static synthetic access$100(Lcom/android/mail/browse/SelectedConversationsActionMenu;ILjava/util/Collection;Ljava/util/Collection;Lcom/android/mail/ui/DestructiveAction;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/browse/SelectedConversationsActionMenu;
    .param p1, "x1"    # I
    .param p2, "x2"    # Ljava/util/Collection;
    .param p3, "x3"    # Ljava/util/Collection;
    .param p4, "x4"    # Lcom/android/mail/ui/DestructiveAction;

    .prologue
    .line 63
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/android/mail/browse/SelectedConversationsActionMenu;->destroy(ILjava/util/Collection;Ljava/util/Collection;Lcom/android/mail/ui/DestructiveAction;)V

    return-void
.end method

.method private clearSelection()V
    .locals 1

    .prologue
    .line 231
    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mSelectionSet:Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-virtual {v0}, Lcom/android/mail/ui/ConversationSelectionSet;->clear()V

    .line 232
    return-void
.end method

.method private destroy()V
    .locals 1

    .prologue
    .line 537
    invoke-virtual {p0}, Lcom/android/mail/browse/SelectedConversationsActionMenu;->deactivate()V

    .line 538
    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mSelectionSet:Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-virtual {v0, p0}, Lcom/android/mail/ui/ConversationSelectionSet;->removeObserver(Lcom/android/mail/ui/ConversationSetObserver;)V

    .line 539
    invoke-direct {p0}, Lcom/android/mail/browse/SelectedConversationsActionMenu;->clearSelection()V

    .line 540
    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mUpdater:Lcom/android/mail/ui/ConversationUpdater;

    invoke-interface {v0}, Lcom/android/mail/ui/ConversationUpdater;->refreshConversationList()V

    .line 541
    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mAccountObserver:Lcom/android/mail/providers/AccountObserver;

    if-eqz v0, :cond_0

    .line 542
    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mAccountObserver:Lcom/android/mail/providers/AccountObserver;

    invoke-virtual {v0}, Lcom/android/mail/providers/AccountObserver;->unregisterAndDestroy()V

    .line 543
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mAccountObserver:Lcom/android/mail/providers/AccountObserver;

    .line 545
    :cond_0
    return-void
.end method

.method private destroy(ILjava/util/Collection;Ljava/util/Collection;Lcom/android/mail/ui/DestructiveAction;)V
    .locals 1
    .param p1, "action"    # I
    .param p4, "listener"    # Lcom/android/mail/ui/DestructiveAction;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/browse/ConversationItemView;",
            ">;",
            "Lcom/android/mail/ui/DestructiveAction;",
            ")V"
        }
    .end annotation

    .prologue
    .line 284
    .local p2, "conversations":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    .local p3, "views":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/browse/ConversationItemView;>;"
    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mUpdater:Lcom/android/mail/ui/ConversationUpdater;

    invoke-interface {v0, p1, p2, p3, p4}, Lcom/android/mail/ui/ConversationUpdater;->delete(ILjava/util/Collection;Ljava/util/Collection;Lcom/android/mail/ui/DestructiveAction;)V

    .line 285
    return-void
.end method

.method private markConversationsImportant(Z)V
    .locals 6
    .param p1, "important"    # Z

    .prologue
    .line 307
    iget-object v4, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mSelectionSet:Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-virtual {v4}, Lcom/android/mail/ui/ConversationSelectionSet;->values()Ljava/util/Collection;

    move-result-object v3

    .line 308
    .local v3, "target":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    if-eqz p1, :cond_0

    const/4 v2, 0x1

    .line 310
    .local v2, "priority":I
    :goto_0
    iget-object v4, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mUpdater:Lcom/android/mail/ui/ConversationUpdater;

    sget-object v5, Lcom/android/mail/providers/UIProvider$ConversationColumns;->PRIORITY:Ljava/lang/String;

    invoke-interface {v4, v3, v5, v2}, Lcom/android/mail/ui/ConversationUpdater;->updateConversation(Ljava/util/Collection;Ljava/lang/String;I)V

    .line 312
    invoke-interface {v3}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Conversation;

    .line 313
    .local v0, "c":Lcom/android/mail/providers/Conversation;
    iput v2, v0, Lcom/android/mail/providers/Conversation;->priority:I

    goto :goto_1

    .line 308
    .end local v0    # "c":Lcom/android/mail/providers/Conversation;
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "priority":I
    :cond_0
    const/4 v2, 0x0

    goto :goto_0

    .line 315
    .restart local v1    # "i$":Ljava/util/Iterator;
    .restart local v2    # "priority":I
    :cond_1
    invoke-direct {p0}, Lcom/android/mail/browse/SelectedConversationsActionMenu;->updateSelection()V

    .line 316
    return-void
.end method

.method private markConversationsRead(Z)V
    .locals 3
    .param p1, "read"    # Z

    .prologue
    .line 294
    iget-object v1, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mSelectionSet:Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-virtual {v1}, Lcom/android/mail/ui/ConversationSelectionSet;->values()Ljava/util/Collection;

    move-result-object v0

    .line 296
    .local v0, "targets":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    iget-object v1, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mUpdater:Lcom/android/mail/ui/ConversationUpdater;

    const/4 v2, 0x0

    invoke-interface {v1, v0, p1, v2}, Lcom/android/mail/ui/ConversationUpdater;->markConversationsRead(Ljava/util/Collection;ZZ)V

    .line 297
    invoke-direct {p0}, Lcom/android/mail/browse/SelectedConversationsActionMenu;->updateSelection()V

    .line 298
    return-void
.end method

.method private performDestructiveAction(I)V
    .locals 12
    .param p1, "action"    # I

    .prologue
    .line 249
    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mUpdater:Lcom/android/mail/ui/ConversationUpdater;

    invoke-interface {v0, p1}, Lcom/android/mail/ui/ConversationUpdater;->getDeferredBatchAction(I)Lcom/android/mail/ui/DestructiveAction;

    move-result-object v5

    .line 250
    .local v5, "destructiveAction":Lcom/android/mail/ui/DestructiveAction;
    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v8, v0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    .line 251
    .local v8, "settings":Lcom/android/mail/providers/Settings;
    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mSelectionSet:Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-virtual {v0}, Lcom/android/mail/ui/ConversationSelectionSet;->values()Ljava/util/Collection;

    move-result-object v3

    .line 252
    .local v3, "conversations":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mSelectionSet:Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-virtual {v0}, Lcom/android/mail/ui/ConversationSelectionSet;->views()Ljava/util/Collection;

    move-result-object v4

    .line 253
    .local v4, "views":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/browse/ConversationItemView;>;"
    if-eqz v8, :cond_1

    const v0, 0x7f100125

    if-eq p1, v0, :cond_0

    const v0, 0x7f100126

    if-ne p1, v0, :cond_1

    :cond_0
    iget-boolean v9, v8, Lcom/android/mail/providers/Settings;->confirmDelete:Z

    .line 256
    .local v9, "showDialog":Z
    :goto_0
    if-eqz v9, :cond_2

    .line 258
    packed-switch p1, :pswitch_data_0

    .line 266
    const v7, 0x7f110004

    .line 269
    .local v7, "resId":I
    :goto_1
    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mContext:Landroid/content/Context;

    invoke-interface {v3}, Ljava/util/Collection;->size()I

    move-result v1

    invoke-static {v0, v7, v1}, Lcom/android/mail/utils/Utils;->formatPlural(Landroid/content/Context;II)Ljava/lang/String;

    move-result-object v6

    .line 270
    .local v6, "message":Ljava/lang/CharSequence;
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    invoke-virtual {v0, v6}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v10

    const v11, 0x7f0c00d2

    new-instance v0, Lcom/android/mail/browse/SelectedConversationsActionMenu$2;

    move-object v1, p0

    move v2, p1

    invoke-direct/range {v0 .. v5}, Lcom/android/mail/browse/SelectedConversationsActionMenu$2;-><init>(Lcom/android/mail/browse/SelectedConversationsActionMenu;ILjava/util/Collection;Ljava/util/Collection;Lcom/android/mail/ui/DestructiveAction;)V

    invoke-virtual {v10, v11, v0}, Landroid/app/AlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const v1, 0x7f0c00d3

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 280
    .end local v6    # "message":Ljava/lang/CharSequence;
    .end local v7    # "resId":I
    :goto_2
    return-void

    .line 253
    .end local v9    # "showDialog":Z
    :cond_1
    iget-boolean v9, v8, Lcom/android/mail/providers/Settings;->confirmArchive:Z

    goto :goto_0

    .line 260
    .restart local v9    # "showDialog":Z
    :pswitch_0
    const v7, 0x7f110003

    .line 261
    .restart local v7    # "resId":I
    goto :goto_1

    .line 263
    .end local v7    # "resId":I
    :pswitch_1
    const v7, 0x7f110005

    .line 264
    .restart local v7    # "resId":I
    goto :goto_1

    .line 278
    .end local v7    # "resId":I
    :cond_2
    invoke-direct {p0, p1, v3, v4, v5}, Lcom/android/mail/browse/SelectedConversationsActionMenu;->destroy(ILjava/util/Collection;Ljava/util/Collection;Lcom/android/mail/ui/DestructiveAction;)V

    goto :goto_2

    .line 258
    :pswitch_data_0
    .packed-switch 0x7f100125
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method private starConversations(Z)V
    .locals 5
    .param p1, "star"    # Z

    .prologue
    .line 324
    iget-object v3, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mSelectionSet:Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-virtual {v3}, Lcom/android/mail/ui/ConversationSelectionSet;->values()Ljava/util/Collection;

    move-result-object v2

    .line 325
    .local v2, "target":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    iget-object v3, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mUpdater:Lcom/android/mail/ui/ConversationUpdater;

    sget-object v4, Lcom/android/mail/providers/UIProvider$ConversationColumns;->STARRED:Ljava/lang/String;

    invoke-interface {v3, v2, v4, p1}, Lcom/android/mail/ui/ConversationUpdater;->updateConversation(Ljava/util/Collection;Ljava/lang/String;Z)V

    .line 327
    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Conversation;

    .line 328
    .local v0, "c":Lcom/android/mail/providers/Conversation;
    iput-boolean p1, v0, Lcom/android/mail/providers/Conversation;->starred:Z

    goto :goto_0

    .line 330
    .end local v0    # "c":Lcom/android/mail/providers/Conversation;
    :cond_0
    invoke-direct {p0}, Lcom/android/mail/browse/SelectedConversationsActionMenu;->updateSelection()V

    .line 331
    return-void
.end method

.method private updateCount()V
    .locals 6

    .prologue
    .line 498
    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mActionMode:Landroid/view/ActionMode;

    if-eqz v0, :cond_0

    .line 499
    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mActionMode:Landroid/view/ActionMode;

    iget-object v1, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mContext:Landroid/content/Context;

    const v2, 0x7f0c0094

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mSelectionSet:Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-virtual {v5}, Lcom/android/mail/ui/ConversationSelectionSet;->size()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v1, v2, v3}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/ActionMode;->setTitle(Ljava/lang/CharSequence;)V

    .line 501
    :cond_0
    return-void
.end method

.method private updateSelection()V
    .locals 2

    .prologue
    .line 238
    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mUpdater:Lcom/android/mail/ui/ConversationUpdater;

    invoke-interface {v0}, Lcom/android/mail/ui/ConversationUpdater;->refreshConversationList()V

    .line 239
    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mActionMode:Landroid/view/ActionMode;

    if-eqz v0, :cond_0

    .line 244
    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mActionMode:Landroid/view/ActionMode;

    iget-object v1, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mActionMode:Landroid/view/ActionMode;

    invoke-virtual {v1}, Landroid/view/ActionMode;->getMenu()Landroid/view/Menu;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/android/mail/browse/SelectedConversationsActionMenu;->onPrepareActionMode(Landroid/view/ActionMode;Landroid/view/Menu;)Z

    .line 246
    :cond_0
    return-void
.end method


# virtual methods
.method public activate()V
    .locals 1

    .prologue
    .line 508
    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mSelectionSet:Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-virtual {v0}, Lcom/android/mail/ui/ConversationSelectionSet;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 515
    :cond_0
    :goto_0
    return-void

    .line 511
    :cond_1
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mActivated:Z

    .line 512
    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mActionMode:Landroid/view/ActionMode;

    if-nez v0, :cond_0

    .line 513
    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0, p0}, Lcom/android/mail/ui/ControllableActivity;->startActionMode(Landroid/view/ActionMode$Callback;)Landroid/view/ActionMode;

    goto :goto_0
.end method

.method public deactivate()V
    .locals 1

    .prologue
    .line 522
    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mActionMode:Landroid/view/ActionMode;

    if-eqz v0, :cond_0

    .line 523
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mActivated:Z

    .line 524
    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mActionMode:Landroid/view/ActionMode;

    invoke-virtual {v0}, Landroid/view/ActionMode;->finish()V

    .line 526
    :cond_0
    return-void
.end method

.method public isActivated()Z
    .locals 1

    .prologue
    .line 530
    iget-boolean v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mActivated:Z

    return v0
.end method

.method public onActionItemClicked(Landroid/view/ActionMode;Landroid/view/MenuItem;)Z
    .locals 15
    .param p1, "mode"    # Landroid/view/ActionMode;
    .param p2, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 118
    const/4 v10, 0x1

    .line 120
    .local v10, "handled":Z
    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mListController:Lcom/android/mail/ui/ConversationListCallbacks;

    const/4 v2, 0x1

    invoke-interface {v0, v2}, Lcom/android/mail/ui/ConversationListCallbacks;->commitDestructiveActions(Z)V

    .line 121
    invoke-interface/range {p2 .. p2}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    sparse-switch v0, :sswitch_data_0

    .line 221
    const/4 v10, 0x0

    .line 224
    :cond_0
    :goto_0
    return v10

    .line 123
    :sswitch_0
    const v0, 0x7f100125

    invoke-direct {p0, v0}, Lcom/android/mail/browse/SelectedConversationsActionMenu;->performDestructiveAction(I)V

    goto :goto_0

    .line 126
    :sswitch_1
    const v0, 0x7f100126

    invoke-direct {p0, v0}, Lcom/android/mail/browse/SelectedConversationsActionMenu;->performDestructiveAction(I)V

    goto :goto_0

    .line 129
    :sswitch_2
    const v0, 0x7f100123

    invoke-direct {p0, v0}, Lcom/android/mail/browse/SelectedConversationsActionMenu;->performDestructiveAction(I)V

    goto :goto_0

    .line 132
    :sswitch_3
    const v12, 0x7f100124

    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mSelectionSet:Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-virtual {v0}, Lcom/android/mail/ui/ConversationSelectionSet;->values()Ljava/util/Collection;

    move-result-object v13

    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mSelectionSet:Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-virtual {v0}, Lcom/android/mail/ui/ConversationSelectionSet;->views()Ljava/util/Collection;

    move-result-object v14

    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mUpdater:Lcom/android/mail/ui/ConversationUpdater;

    iget-object v2, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mSelectionSet:Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-virtual {v2}, Lcom/android/mail/ui/ConversationSelectionSet;->values()Ljava/util/Collection;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mFolder:Lcom/android/mail/providers/Folder;

    const/4 v3, 0x1

    const/4 v4, 0x1

    const/4 v5, 0x1

    invoke-interface/range {v0 .. v5}, Lcom/android/mail/ui/ConversationUpdater;->getDeferredRemoveFolder(Ljava/util/Collection;Lcom/android/mail/providers/Folder;ZZZ)Lcom/android/mail/ui/DestructiveAction;

    move-result-object v0

    invoke-direct {p0, v12, v13, v14, v0}, Lcom/android/mail/browse/SelectedConversationsActionMenu;->destroy(ILjava/util/Collection;Ljava/util/Collection;Lcom/android/mail/ui/DestructiveAction;)V

    goto :goto_0

    .line 137
    :sswitch_4
    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mUpdater:Lcom/android/mail/ui/ConversationUpdater;

    const v2, 0x7f10012b

    iget-object v3, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mSelectionSet:Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-virtual {v3}, Lcom/android/mail/ui/ConversationSelectionSet;->values()Ljava/util/Collection;

    move-result-object v3

    iget-object v4, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mUpdater:Lcom/android/mail/ui/ConversationUpdater;

    const v5, 0x7f10012b

    invoke-interface {v4, v5}, Lcom/android/mail/ui/ConversationUpdater;->getBatchAction(I)Lcom/android/mail/ui/DestructiveAction;

    move-result-object v4

    invoke-interface {v0, v2, v3, v4}, Lcom/android/mail/ui/ConversationUpdater;->delete(ILjava/util/Collection;Lcom/android/mail/ui/DestructiveAction;)V

    goto :goto_0

    .line 141
    :sswitch_5
    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mUpdater:Lcom/android/mail/ui/ConversationUpdater;

    const v2, 0x7f10012c

    iget-object v3, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mSelectionSet:Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-virtual {v3}, Lcom/android/mail/ui/ConversationSelectionSet;->values()Ljava/util/Collection;

    move-result-object v3

    iget-object v4, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mUpdater:Lcom/android/mail/ui/ConversationUpdater;

    const v5, 0x7f10012c

    invoke-interface {v4, v5}, Lcom/android/mail/ui/ConversationUpdater;->getBatchAction(I)Lcom/android/mail/ui/DestructiveAction;

    move-result-object v4

    invoke-interface {v0, v2, v3, v4}, Lcom/android/mail/ui/ConversationUpdater;->delete(ILjava/util/Collection;Lcom/android/mail/ui/DestructiveAction;)V

    goto :goto_0

    .line 147
    :sswitch_6
    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mUpdater:Lcom/android/mail/ui/ConversationUpdater;

    const v2, 0x7f10012d

    iget-object v3, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mSelectionSet:Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-virtual {v3}, Lcom/android/mail/ui/ConversationSelectionSet;->values()Ljava/util/Collection;

    move-result-object v3

    iget-object v4, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mUpdater:Lcom/android/mail/ui/ConversationUpdater;

    const v5, 0x7f10012d

    invoke-interface {v4, v5}, Lcom/android/mail/ui/ConversationUpdater;->getBatchAction(I)Lcom/android/mail/ui/DestructiveAction;

    move-result-object v4

    invoke-interface {v0, v2, v3, v4}, Lcom/android/mail/ui/ConversationUpdater;->delete(ILjava/util/Collection;Lcom/android/mail/ui/DestructiveAction;)V

    goto/16 :goto_0

    .line 151
    :sswitch_7
    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mUpdater:Lcom/android/mail/ui/ConversationUpdater;

    const v2, 0x7f10012e

    iget-object v3, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mSelectionSet:Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-virtual {v3}, Lcom/android/mail/ui/ConversationSelectionSet;->values()Ljava/util/Collection;

    move-result-object v3

    iget-object v4, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mUpdater:Lcom/android/mail/ui/ConversationUpdater;

    const v5, 0x7f10012e

    invoke-interface {v4, v5}, Lcom/android/mail/ui/ConversationUpdater;->getBatchAction(I)Lcom/android/mail/ui/DestructiveAction;

    move-result-object v4

    invoke-interface {v0, v2, v3, v4}, Lcom/android/mail/ui/ConversationUpdater;->delete(ILjava/util/Collection;Lcom/android/mail/ui/DestructiveAction;)V

    goto/16 :goto_0

    .line 155
    :sswitch_8
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/android/mail/browse/SelectedConversationsActionMenu;->markConversationsRead(Z)V

    goto/16 :goto_0

    .line 158
    :sswitch_9
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/android/mail/browse/SelectedConversationsActionMenu;->markConversationsRead(Z)V

    goto/16 :goto_0

    .line 161
    :sswitch_a
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/android/mail/browse/SelectedConversationsActionMenu;->starConversations(Z)V

    goto/16 :goto_0

    .line 164
    :sswitch_b
    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mFolder:Lcom/android/mail/providers/Folder;

    iget v0, v0, Lcom/android/mail/providers/Folder;->type:I

    const/4 v2, 0x7

    if-ne v0, v2, :cond_1

    .line 165
    sget-object v0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->LOG_TAG:Ljava/lang/String;

    const-string v2, "We are in a starred folder, removing the star"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v0, v2, v3}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 166
    const v0, 0x7f100134

    invoke-direct {p0, v0}, Lcom/android/mail/browse/SelectedConversationsActionMenu;->performDestructiveAction(I)V

    goto/16 :goto_0

    .line 168
    :cond_1
    sget-object v0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->LOG_TAG:Ljava/lang/String;

    const-string v2, "Not in a starred folder."

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v0, v2, v3}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 169
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/android/mail/browse/SelectedConversationsActionMenu;->starConversations(Z)V

    goto/16 :goto_0

    .line 173
    :sswitch_c
    const/4 v7, 0x0

    .line 174
    .local v7, "cantMove":Z
    iget-object v1, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mAccount:Lcom/android/mail/providers/Account;

    .line 176
    .local v1, "acct":Lcom/android/mail/providers/Account;
    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mFolder:Lcom/android/mail/providers/Folder;

    const/16 v2, 0x1000

    invoke-virtual {v0, v2}, Lcom/android/mail/providers/Folder;->supportsCapability(I)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 177
    const/4 v6, 0x0

    .line 178
    .local v6, "accountUri":Landroid/net/Uri;
    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mSelectionSet:Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-virtual {v0}, Lcom/android/mail/ui/ConversationSelectionSet;->values()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v11

    .local v11, "i$":Ljava/util/Iterator;
    :cond_2
    :goto_1
    invoke-interface {v11}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v11}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/android/mail/providers/Conversation;

    .line 179
    .local v8, "conv":Lcom/android/mail/providers/Conversation;
    if-nez v6, :cond_3

    .line 180
    iget-object v6, v8, Lcom/android/mail/providers/Conversation;->accountUri:Landroid/net/Uri;

    goto :goto_1

    .line 181
    :cond_3
    iget-object v0, v8, Lcom/android/mail/providers/Conversation;->accountUri:Landroid/net/Uri;

    invoke-virtual {v6, v0}, Landroid/net/Uri;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 183
    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mContext:Landroid/content/Context;

    const v2, 0x7f0c00f0

    const/4 v3, 0x1

    invoke-static {v0, v2, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 185
    const/4 v7, 0x1

    .line 189
    .end local v8    # "conv":Lcom/android/mail/providers/Conversation;
    :cond_4
    if-nez v7, :cond_5

    .line 191
    invoke-static {v6}, Lcom/android/mail/providers/MailAppProvider;->getAccountFromAccountUri(Landroid/net/Uri;)Lcom/android/mail/providers/Account;

    move-result-object v1

    .line 194
    .end local v6    # "accountUri":Landroid/net/Uri;
    .end local v11    # "i$":Ljava/util/Iterator;
    :cond_5
    if-nez v7, :cond_0

    .line 196
    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mAccount:Lcom/android/mail/providers/Account;

    const/16 v2, 0x2000

    invoke-virtual {v0, v2}, Lcom/android/mail/providers/Account;->supportsCapability(I)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 199
    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mUpdater:Lcom/android/mail/ui/ConversationUpdater;

    iget-object v3, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mSelectionSet:Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-virtual {v3}, Lcom/android/mail/ui/ConversationSelectionSet;->values()Ljava/util/Collection;

    move-result-object v3

    const/4 v4, 0x1

    iget-object v5, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-static/range {v0 .. v5}, Lcom/android/mail/ui/MultiFoldersSelectionDialog;->getInstance(Landroid/content/Context;Lcom/android/mail/providers/Account;Lcom/android/mail/ui/ConversationUpdater;Ljava/util/Collection;ZLcom/android/mail/providers/Folder;)Lcom/android/mail/ui/MultiFoldersSelectionDialog;

    move-result-object v9

    .line 205
    .local v9, "dialog":Lcom/android/mail/ui/FolderSelectionDialog;
    :goto_2
    if-eqz v9, :cond_0

    .line 206
    invoke-virtual {v9}, Lcom/android/mail/ui/FolderSelectionDialog;->show()V

    goto/16 :goto_0

    .line 202
    .end local v9    # "dialog":Lcom/android/mail/ui/FolderSelectionDialog;
    :cond_6
    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mUpdater:Lcom/android/mail/ui/ConversationUpdater;

    iget-object v3, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mSelectionSet:Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-virtual {v3}, Lcom/android/mail/ui/ConversationSelectionSet;->values()Ljava/util/Collection;

    move-result-object v3

    const/4 v4, 0x1

    iget-object v5, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-static/range {v0 .. v5}, Lcom/android/mail/ui/SingleFolderSelectionDialog;->getInstance(Landroid/content/Context;Lcom/android/mail/providers/Account;Lcom/android/mail/ui/ConversationUpdater;Ljava/util/Collection;ZLcom/android/mail/providers/Folder;)Lcom/android/mail/ui/SingleFolderSelectionDialog;

    move-result-object v9

    .restart local v9    # "dialog":Lcom/android/mail/ui/FolderSelectionDialog;
    goto :goto_2

    .line 211
    .end local v1    # "acct":Lcom/android/mail/providers/Account;
    .end local v7    # "cantMove":Z
    .end local v9    # "dialog":Lcom/android/mail/ui/FolderSelectionDialog;
    :sswitch_d
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/android/mail/browse/SelectedConversationsActionMenu;->markConversationsImportant(Z)V

    goto/16 :goto_0

    .line 214
    :sswitch_e
    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mFolder:Lcom/android/mail/providers/Folder;

    const/16 v2, 0x400

    invoke-virtual {v0, v2}, Lcom/android/mail/providers/Folder;->supportsCapability(I)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 215
    const v0, 0x7f10012a

    invoke-direct {p0, v0}, Lcom/android/mail/browse/SelectedConversationsActionMenu;->performDestructiveAction(I)V

    goto/16 :goto_0

    .line 217
    :cond_7
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/android/mail/browse/SelectedConversationsActionMenu;->markConversationsImportant(Z)V

    goto/16 :goto_0

    .line 121
    nop

    :sswitch_data_0
    .sparse-switch
        0x7f10003c -> :sswitch_9
        0x7f100060 -> :sswitch_a
        0x7f100123 -> :sswitch_2
        0x7f100124 -> :sswitch_3
        0x7f100125 -> :sswitch_0
        0x7f100126 -> :sswitch_1
        0x7f100127 -> :sswitch_c
        0x7f100129 -> :sswitch_d
        0x7f10012a -> :sswitch_e
        0x7f10012b -> :sswitch_4
        0x7f10012c -> :sswitch_5
        0x7f10012d -> :sswitch_6
        0x7f10012e -> :sswitch_7
        0x7f100133 -> :sswitch_8
        0x7f100134 -> :sswitch_b
    .end sparse-switch
.end method

.method public onCreateActionMode(Landroid/view/ActionMode;Landroid/view/Menu;)Z
    .locals 2
    .param p1, "mode"    # Landroid/view/ActionMode;
    .param p2, "menu"    # Landroid/view/Menu;

    .prologue
    .line 335
    iget-object v1, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mSelectionSet:Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-virtual {v1, p0}, Lcom/android/mail/ui/ConversationSelectionSet;->addObserver(Lcom/android/mail/ui/ConversationSetObserver;)V

    .line 336
    iget-object v1, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v0

    .line 337
    .local v0, "inflater":Landroid/view/MenuInflater;
    const v1, 0x7f120004

    invoke-virtual {v0, v1, p2}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 338
    iput-object p1, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mActionMode:Landroid/view/ActionMode;

    .line 339
    iput-object p2, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mMenu:Landroid/view/Menu;

    .line 340
    invoke-direct {p0}, Lcom/android/mail/browse/SelectedConversationsActionMenu;->updateCount()V

    .line 341
    const/4 v1, 0x1

    return v1
.end method

.method public onDestroyActionMode(Landroid/view/ActionMode;)V
    .locals 3
    .param p1, "mode"    # Landroid/view/ActionMode;

    .prologue
    const/4 v2, 0x0

    .line 458
    iput-object v2, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mActionMode:Landroid/view/ActionMode;

    .line 462
    iget-boolean v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mActivated:Z

    if-eqz v0, :cond_0

    .line 463
    invoke-direct {p0}, Lcom/android/mail/browse/SelectedConversationsActionMenu;->destroy()V

    .line 467
    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getListHandler()Lcom/android/mail/ui/ConversationListCallbacks;

    move-result-object v0

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Lcom/android/mail/ui/ConversationListCallbacks;->commitDestructiveActions(Z)V

    .line 469
    :cond_0
    iput-object v2, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mMenu:Landroid/view/Menu;

    .line 470
    return-void
.end method

.method public onPrepareActionMode(Landroid/view/ActionMode;Landroid/view/Menu;)Z
    .locals 34
    .param p1, "mode"    # Landroid/view/ActionMode;
    .param p2, "menu"    # Landroid/view/Menu;

    .prologue
    .line 347
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mSelectionSet:Lcom/android/mail/ui/ConversationSelectionSet;

    move-object/from16 v29, v0

    invoke-virtual/range {v29 .. v29}, Lcom/android/mail/ui/ConversationSelectionSet;->values()Ljava/util/Collection;

    move-result-object v5

    .line 348
    .local v5, "conversations":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    const/16 v23, 0x0

    .line 349
    .local v23, "showStar":Z
    const/16 v21, 0x0

    .line 350
    .local v21, "showMarkUnread":Z
    const/16 v19, 0x0

    .line 351
    .local v19, "showMarkImportant":Z
    const/16 v20, 0x0

    .line 352
    .local v20, "showMarkNotSpam":Z
    const/16 v18, 0x0

    .line 354
    .local v18, "showMarkAsPhishing":Z
    invoke-interface {v5}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v7

    .local v7, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v29

    if-eqz v29, :cond_6

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/android/mail/providers/Conversation;

    .line 355
    .local v4, "conversation":Lcom/android/mail/providers/Conversation;
    iget-boolean v0, v4, Lcom/android/mail/providers/Conversation;->starred:Z

    move/from16 v29, v0

    if-nez v29, :cond_1

    .line 356
    const/16 v23, 0x1

    .line 358
    :cond_1
    iget-boolean v0, v4, Lcom/android/mail/providers/Conversation;->read:Z

    move/from16 v29, v0

    if-eqz v29, :cond_2

    .line 359
    const/16 v21, 0x1

    .line 361
    :cond_2
    invoke-virtual {v4}, Lcom/android/mail/providers/Conversation;->isImportant()Z

    move-result v29

    if-nez v29, :cond_3

    .line 362
    const/16 v19, 0x1

    .line 364
    :cond_3
    iget-boolean v0, v4, Lcom/android/mail/providers/Conversation;->spam:Z

    move/from16 v29, v0

    if-eqz v29, :cond_4

    .line 365
    const/16 v20, 0x1

    .line 367
    :cond_4
    iget-boolean v0, v4, Lcom/android/mail/providers/Conversation;->phishing:Z

    move/from16 v29, v0

    if-nez v29, :cond_5

    .line 368
    const/16 v18, 0x1

    .line 370
    :cond_5
    if-eqz v23, :cond_0

    if-eqz v21, :cond_0

    if-eqz v19, :cond_0

    if-eqz v20, :cond_0

    if-eqz v18, :cond_0

    .line 375
    .end local v4    # "conversation":Lcom/android/mail/providers/Conversation;
    :cond_6
    const v29, 0x7f100060

    move-object/from16 v0, p2

    move/from16 v1, v29

    invoke-interface {v0, v1}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v25

    .line 376
    .local v25, "star":Landroid/view/MenuItem;
    move-object/from16 v0, v25

    move/from16 v1, v23

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 377
    const v29, 0x7f100134

    move-object/from16 v0, p2

    move/from16 v1, v29

    invoke-interface {v0, v1}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v28

    .line 378
    .local v28, "unstar":Landroid/view/MenuItem;
    if-nez v23, :cond_b

    const/16 v29, 0x1

    :goto_0
    invoke-interface/range {v28 .. v29}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 379
    const v29, 0x7f100133

    move-object/from16 v0, p2

    move/from16 v1, v29

    invoke-interface {v0, v1}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v13

    .line 380
    .local v13, "read":Landroid/view/MenuItem;
    if-nez v21, :cond_c

    const/16 v29, 0x1

    :goto_1
    move/from16 v0, v29

    invoke-interface {v13, v0}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 381
    const v29, 0x7f10003c

    move-object/from16 v0, p2

    move/from16 v1, v29

    invoke-interface {v0, v1}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v27

    .line 382
    .local v27, "unread":Landroid/view/MenuItem;
    move-object/from16 v0, v27

    move/from16 v1, v21

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 388
    const v29, 0x7f100124

    move-object/from16 v0, p2

    move/from16 v1, v29

    invoke-interface {v0, v1}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v14

    .line 389
    .local v14, "removeFolder":Landroid/view/MenuItem;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mFolder:Lcom/android/mail/providers/Folder;

    move-object/from16 v29, v0

    if-eqz v29, :cond_d

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mFolder:Lcom/android/mail/providers/Folder;

    move-object/from16 v29, v0

    move-object/from16 v0, v29

    iget v0, v0, Lcom/android/mail/providers/Folder;->type:I

    move/from16 v29, v0

    if-nez v29, :cond_d

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mFolder:Lcom/android/mail/providers/Folder;

    move-object/from16 v29, v0

    const/16 v30, 0x8

    invoke-virtual/range {v29 .. v30}, Lcom/android/mail/providers/Folder;->supportsCapability(I)Z

    move-result v29

    if-eqz v29, :cond_d

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mFolder:Lcom/android/mail/providers/Folder;

    move-object/from16 v29, v0

    invoke-virtual/range {v29 .. v29}, Lcom/android/mail/providers/Folder;->isProviderFolder()Z

    move-result v29

    if-nez v29, :cond_d

    const/16 v22, 0x1

    .line 392
    .local v22, "showRemoveFolder":Z
    :goto_2
    move/from16 v0, v22

    invoke-interface {v14, v0}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 393
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mFolder:Lcom/android/mail/providers/Folder;

    move-object/from16 v29, v0

    if-eqz v29, :cond_7

    if-eqz v22, :cond_7

    .line 394
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    move-object/from16 v29, v0

    invoke-interface/range {v29 .. v29}, Lcom/android/mail/ui/ControllableActivity;->getActivityContext()Landroid/content/Context;

    move-result-object v29

    const v30, 0x7f0c0040

    const/16 v31, 0x1

    move/from16 v0, v31

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v31, v0

    const/16 v32, 0x0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mFolder:Lcom/android/mail/providers/Folder;

    move-object/from16 v33, v0

    move-object/from16 v0, v33

    iget-object v0, v0, Lcom/android/mail/providers/Folder;->name:Ljava/lang/String;

    move-object/from16 v33, v0

    aput-object v33, v31, v32

    invoke-virtual/range {v29 .. v31}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v29

    move-object/from16 v0, v29

    invoke-interface {v14, v0}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 397
    :cond_7
    const v29, 0x7f100123

    move-object/from16 v0, p2

    move/from16 v1, v29

    invoke-interface {v0, v1}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v3

    .line 398
    .local v3, "archive":Landroid/view/MenuItem;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mAccount:Lcom/android/mail/providers/Account;

    move-object/from16 v29, v0

    const/16 v30, 0x8

    invoke-virtual/range {v29 .. v30}, Lcom/android/mail/providers/Account;->supportsCapability(I)Z

    move-result v2

    .line 400
    .local v2, "accountSupportsArchive":Z
    if-eqz v2, :cond_e

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mFolder:Lcom/android/mail/providers/Folder;

    move-object/from16 v29, v0

    const/16 v30, 0x10

    invoke-virtual/range {v29 .. v30}, Lcom/android/mail/providers/Folder;->supportsCapability(I)Z

    move-result v29

    if-eqz v29, :cond_e

    const/4 v15, 0x1

    .line 402
    .local v15, "showArchive":Z
    :goto_3
    if-nez v3, :cond_f

    .line 403
    const/4 v15, 0x0

    .line 408
    :goto_4
    if-nez v15, :cond_8

    if-eqz v2, :cond_8

    .line 409
    if-nez v22, :cond_8

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    move-object/from16 v29, v0

    invoke-interface/range {v29 .. v29}, Lcom/android/mail/ui/ControllableActivity;->getActivityContext()Landroid/content/Context;

    move-result-object v29

    invoke-static/range {v29 .. v29}, Lcom/android/mail/utils/Utils;->shouldShowDisabledArchiveIcon(Landroid/content/Context;)Z

    move-result v29

    if-eqz v29, :cond_8

    .line 411
    const/16 v29, 0x0

    move/from16 v0, v29

    invoke-interface {v3, v0}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 412
    const/16 v29, 0x1

    move/from16 v0, v29

    invoke-interface {v3, v0}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 415
    :cond_8
    const v29, 0x7f10012c

    move-object/from16 v0, p2

    move/from16 v1, v29

    invoke-interface {v0, v1}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v24

    .line 416
    .local v24, "spam":Landroid/view/MenuItem;
    if-nez v20, :cond_10

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mAccount:Lcom/android/mail/providers/Account;

    move-object/from16 v29, v0

    const/16 v30, 0x2

    invoke-virtual/range {v29 .. v30}, Lcom/android/mail/providers/Account;->supportsCapability(I)Z

    move-result v29

    if-eqz v29, :cond_10

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mFolder:Lcom/android/mail/providers/Folder;

    move-object/from16 v29, v0

    const/16 v30, 0x40

    invoke-virtual/range {v29 .. v30}, Lcom/android/mail/providers/Folder;->supportsCapability(I)Z

    move-result v29

    if-eqz v29, :cond_10

    const/16 v29, 0x1

    :goto_5
    move-object/from16 v0, v24

    move/from16 v1, v29

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 419
    const v29, 0x7f10012d

    move-object/from16 v0, p2

    move/from16 v1, v29

    invoke-interface {v0, v1}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v11

    .line 420
    .local v11, "notSpam":Landroid/view/MenuItem;
    if-eqz v20, :cond_11

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mAccount:Lcom/android/mail/providers/Account;

    move-object/from16 v29, v0

    const/16 v30, 0x2

    invoke-virtual/range {v29 .. v30}, Lcom/android/mail/providers/Account;->supportsCapability(I)Z

    move-result v29

    if-eqz v29, :cond_11

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mFolder:Lcom/android/mail/providers/Folder;

    move-object/from16 v29, v0

    const/16 v30, 0x80

    invoke-virtual/range {v29 .. v30}, Lcom/android/mail/providers/Folder;->supportsCapability(I)Z

    move-result v29

    if-eqz v29, :cond_11

    const/16 v29, 0x1

    :goto_6
    move/from16 v0, v29

    invoke-interface {v11, v0}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 423
    const v29, 0x7f10012e

    move-object/from16 v0, p2

    move/from16 v1, v29

    invoke-interface {v0, v1}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v12

    .line 424
    .local v12, "phishing":Landroid/view/MenuItem;
    if-eqz v18, :cond_12

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mAccount:Lcom/android/mail/providers/Account;

    move-object/from16 v29, v0

    const/16 v30, 0x4

    invoke-virtual/range {v29 .. v30}, Lcom/android/mail/providers/Account;->supportsCapability(I)Z

    move-result v29

    if-eqz v29, :cond_12

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mFolder:Lcom/android/mail/providers/Folder;

    move-object/from16 v29, v0

    const/16 v30, 0x2000

    invoke-virtual/range {v29 .. v30}, Lcom/android/mail/providers/Folder;->supportsCapability(I)Z

    move-result v29

    if-eqz v29, :cond_12

    const/16 v29, 0x1

    :goto_7
    move/from16 v0, v29

    invoke-interface {v12, v0}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 428
    const v29, 0x7f10012b

    move-object/from16 v0, p2

    move/from16 v1, v29

    invoke-interface {v0, v1}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v10

    .line 429
    .local v10, "mute":Landroid/view/MenuItem;
    if-eqz v10, :cond_9

    .line 430
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mAccount:Lcom/android/mail/providers/Account;

    move-object/from16 v29, v0

    const/16 v30, 0x10

    invoke-virtual/range {v29 .. v30}, Lcom/android/mail/providers/Account;->supportsCapability(I)Z

    move-result v29

    if-eqz v29, :cond_13

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mFolder:Lcom/android/mail/providers/Folder;

    move-object/from16 v29, v0

    if-eqz v29, :cond_13

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mFolder:Lcom/android/mail/providers/Folder;

    move-object/from16 v29, v0

    move-object/from16 v0, v29

    iget v0, v0, Lcom/android/mail/providers/Folder;->type:I

    move/from16 v29, v0

    const/16 v30, 0x1

    move/from16 v0, v29

    move/from16 v1, v30

    if-ne v0, v1, :cond_13

    const/16 v29, 0x1

    :goto_8
    move/from16 v0, v29

    invoke-interface {v10, v0}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 433
    :cond_9
    const v29, 0x7f100129

    move-object/from16 v0, p2

    move/from16 v1, v29

    invoke-interface {v0, v1}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v8

    .line 434
    .local v8, "markImportant":Landroid/view/MenuItem;
    if-eqz v19, :cond_14

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mAccount:Lcom/android/mail/providers/Account;

    move-object/from16 v29, v0

    const/high16 v30, 0x20000

    invoke-virtual/range {v29 .. v30}, Lcom/android/mail/providers/Account;->supportsCapability(I)Z

    move-result v29

    if-eqz v29, :cond_14

    const/16 v29, 0x1

    :goto_9
    move/from16 v0, v29

    invoke-interface {v8, v0}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 436
    const v29, 0x7f10012a

    move-object/from16 v0, p2

    move/from16 v1, v29

    invoke-interface {v0, v1}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v9

    .line 437
    .local v9, "markNotImportant":Landroid/view/MenuItem;
    if-nez v19, :cond_15

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mAccount:Lcom/android/mail/providers/Account;

    move-object/from16 v29, v0

    const/high16 v30, 0x20000

    invoke-virtual/range {v29 .. v30}, Lcom/android/mail/providers/Account;->supportsCapability(I)Z

    move-result v29

    if-eqz v29, :cond_15

    const/16 v29, 0x1

    :goto_a
    move/from16 v0, v29

    invoke-interface {v9, v0}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 439
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mFolder:Lcom/android/mail/providers/Folder;

    move-object/from16 v29, v0

    if-eqz v29, :cond_16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mFolder:Lcom/android/mail/providers/Folder;

    move-object/from16 v29, v0

    const/16 v30, 0x20

    invoke-virtual/range {v29 .. v30}, Lcom/android/mail/providers/Folder;->supportsCapability(I)Z

    move-result v29

    if-eqz v29, :cond_16

    const/16 v16, 0x1

    .line 441
    .local v16, "showDelete":Z
    :goto_b
    const v29, 0x7f100125

    move-object/from16 v0, p2

    move/from16 v1, v29

    invoke-interface {v0, v1}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v26

    .line 442
    .local v26, "trash":Landroid/view/MenuItem;
    move-object/from16 v0, v26

    move/from16 v1, v16

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 446
    if-nez v16, :cond_17

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mFolder:Lcom/android/mail/providers/Folder;

    move-object/from16 v29, v0

    if-eqz v29, :cond_17

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mFolder:Lcom/android/mail/providers/Folder;

    move-object/from16 v29, v0

    invoke-virtual/range {v29 .. v29}, Lcom/android/mail/providers/Folder;->isDraft()Z

    move-result v29

    if-eqz v29, :cond_17

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->mAccount:Lcom/android/mail/providers/Account;

    move-object/from16 v29, v0

    const/high16 v30, 0x100000

    invoke-virtual/range {v29 .. v30}, Lcom/android/mail/providers/Account;->supportsCapability(I)Z

    move-result v29

    if-eqz v29, :cond_17

    const/16 v17, 0x1

    .line 448
    .local v17, "showDiscardDrafts":Z
    :goto_c
    const v29, 0x7f100126

    move-object/from16 v0, p2

    move/from16 v1, v29

    invoke-interface {v0, v1}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v6

    .line 449
    .local v6, "discardDrafts":Landroid/view/MenuItem;
    if-eqz v6, :cond_a

    .line 450
    move/from16 v0, v17

    invoke-interface {v6, v0}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 453
    :cond_a
    const/16 v29, 0x1

    return v29

    .line 378
    .end local v2    # "accountSupportsArchive":Z
    .end local v3    # "archive":Landroid/view/MenuItem;
    .end local v6    # "discardDrafts":Landroid/view/MenuItem;
    .end local v8    # "markImportant":Landroid/view/MenuItem;
    .end local v9    # "markNotImportant":Landroid/view/MenuItem;
    .end local v10    # "mute":Landroid/view/MenuItem;
    .end local v11    # "notSpam":Landroid/view/MenuItem;
    .end local v12    # "phishing":Landroid/view/MenuItem;
    .end local v13    # "read":Landroid/view/MenuItem;
    .end local v14    # "removeFolder":Landroid/view/MenuItem;
    .end local v15    # "showArchive":Z
    .end local v16    # "showDelete":Z
    .end local v17    # "showDiscardDrafts":Z
    .end local v22    # "showRemoveFolder":Z
    .end local v24    # "spam":Landroid/view/MenuItem;
    .end local v26    # "trash":Landroid/view/MenuItem;
    .end local v27    # "unread":Landroid/view/MenuItem;
    :cond_b
    const/16 v29, 0x0

    goto/16 :goto_0

    .line 380
    .restart local v13    # "read":Landroid/view/MenuItem;
    :cond_c
    const/16 v29, 0x0

    goto/16 :goto_1

    .line 389
    .restart local v14    # "removeFolder":Landroid/view/MenuItem;
    .restart local v27    # "unread":Landroid/view/MenuItem;
    :cond_d
    const/16 v22, 0x0

    goto/16 :goto_2

    .line 400
    .restart local v2    # "accountSupportsArchive":Z
    .restart local v3    # "archive":Landroid/view/MenuItem;
    .restart local v22    # "showRemoveFolder":Z
    :cond_e
    const/4 v15, 0x0

    goto/16 :goto_3

    .line 405
    .restart local v15    # "showArchive":Z
    :cond_f
    invoke-interface {v3, v15}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    goto/16 :goto_4

    .line 416
    .restart local v24    # "spam":Landroid/view/MenuItem;
    :cond_10
    const/16 v29, 0x0

    goto/16 :goto_5

    .line 420
    .restart local v11    # "notSpam":Landroid/view/MenuItem;
    :cond_11
    const/16 v29, 0x0

    goto/16 :goto_6

    .line 424
    .restart local v12    # "phishing":Landroid/view/MenuItem;
    :cond_12
    const/16 v29, 0x0

    goto/16 :goto_7

    .line 430
    .restart local v10    # "mute":Landroid/view/MenuItem;
    :cond_13
    const/16 v29, 0x0

    goto/16 :goto_8

    .line 434
    .restart local v8    # "markImportant":Landroid/view/MenuItem;
    :cond_14
    const/16 v29, 0x0

    goto/16 :goto_9

    .line 437
    .restart local v9    # "markNotImportant":Landroid/view/MenuItem;
    :cond_15
    const/16 v29, 0x0

    goto/16 :goto_a

    .line 439
    :cond_16
    const/16 v16, 0x0

    goto :goto_b

    .line 446
    .restart local v16    # "showDelete":Z
    .restart local v26    # "trash":Landroid/view/MenuItem;
    :cond_17
    const/16 v17, 0x0

    goto :goto_c
.end method

.method public onSetChanged(Lcom/android/mail/ui/ConversationSelectionSet;)V
    .locals 1
    .param p1, "set"    # Lcom/android/mail/ui/ConversationSelectionSet;

    .prologue
    .line 488
    invoke-virtual {p1}, Lcom/android/mail/ui/ConversationSelectionSet;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 492
    :goto_0
    return-void

    .line 491
    :cond_0
    invoke-direct {p0}, Lcom/android/mail/browse/SelectedConversationsActionMenu;->updateCount()V

    goto :goto_0
.end method

.method public onSetEmpty()V
    .locals 3

    .prologue
    .line 479
    sget-object v0, Lcom/android/mail/browse/SelectedConversationsActionMenu;->LOG_TAG:Ljava/lang/String;

    const-string v1, "onSetEmpty called."

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 480
    invoke-direct {p0}, Lcom/android/mail/browse/SelectedConversationsActionMenu;->destroy()V

    .line 481
    return-void
.end method

.method public onSetPopulated(Lcom/android/mail/ui/ConversationSelectionSet;)V
    .locals 0
    .param p1, "set"    # Lcom/android/mail/ui/ConversationSelectionSet;

    .prologue
    .line 475
    return-void
.end method
