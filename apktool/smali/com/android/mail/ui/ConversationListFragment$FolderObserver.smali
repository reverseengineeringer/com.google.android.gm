.class Lcom/android/mail/ui/ConversationListFragment$FolderObserver;
.super Landroid/database/DataSetObserver;
.source "ConversationListFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/ConversationListFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "FolderObserver"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/ui/ConversationListFragment;


# direct methods
.method private constructor <init>(Lcom/android/mail/ui/ConversationListFragment;)V
    .locals 0

    .prologue
    .line 144
    iput-object p1, p0, Lcom/android/mail/ui/ConversationListFragment$FolderObserver;->this$0:Lcom/android/mail/ui/ConversationListFragment;

    invoke-direct {p0}, Landroid/database/DataSetObserver;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/android/mail/ui/ConversationListFragment;Lcom/android/mail/ui/ConversationListFragment$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/android/mail/ui/ConversationListFragment;
    .param p2, "x1"    # Lcom/android/mail/ui/ConversationListFragment$1;

    .prologue
    .line 144
    invoke-direct {p0, p1}, Lcom/android/mail/ui/ConversationListFragment$FolderObserver;-><init>(Lcom/android/mail/ui/ConversationListFragment;)V

    return-void
.end method


# virtual methods
.method public onChanged()V
    .locals 3

    .prologue
    .line 147
    iget-object v1, p0, Lcom/android/mail/ui/ConversationListFragment$FolderObserver;->this$0:Lcom/android/mail/ui/ConversationListFragment;

    # getter for: Lcom/android/mail/ui/ConversationListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;
    invoke-static {v1}, Lcom/android/mail/ui/ConversationListFragment;->access$200(Lcom/android/mail/ui/ConversationListFragment;)Lcom/android/mail/ui/ControllableActivity;

    move-result-object v1

    if-nez v1, :cond_1

    .line 155
    :cond_0
    :goto_0
    return-void

    .line 150
    :cond_1
    iget-object v1, p0, Lcom/android/mail/ui/ConversationListFragment$FolderObserver;->this$0:Lcom/android/mail/ui/ConversationListFragment;

    # getter for: Lcom/android/mail/ui/ConversationListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;
    invoke-static {v1}, Lcom/android/mail/ui/ConversationListFragment;->access$200(Lcom/android/mail/ui/ConversationListFragment;)Lcom/android/mail/ui/ControllableActivity;

    move-result-object v1

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->getFolderController()Lcom/android/mail/ui/FolderController;

    move-result-object v0

    .line 151
    .local v0, "controller":Lcom/android/mail/ui/FolderController;
    if-eqz v0, :cond_0

    .line 154
    iget-object v1, p0, Lcom/android/mail/ui/ConversationListFragment$FolderObserver;->this$0:Lcom/android/mail/ui/ConversationListFragment;

    invoke-interface {v0}, Lcom/android/mail/ui/FolderController;->getFolder()Lcom/android/mail/providers/Folder;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/android/mail/ui/ConversationListFragment;->onFolderUpdated(Lcom/android/mail/providers/Folder;)V

    goto :goto_0
.end method
