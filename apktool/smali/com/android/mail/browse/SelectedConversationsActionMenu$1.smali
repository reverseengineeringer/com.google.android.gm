.class Lcom/android/mail/browse/SelectedConversationsActionMenu$1;
.super Lcom/android/mail/providers/AccountObserver;
.source "SelectedConversationsActionMenu.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/mail/browse/SelectedConversationsActionMenu;-><init>(Lcom/android/mail/ui/ControllableActivity;Lcom/android/mail/ui/ConversationSelectionSet;Lcom/android/mail/providers/Folder;Lcom/android/mail/ui/SwipeableListView;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/browse/SelectedConversationsActionMenu;


# direct methods
.method constructor <init>(Lcom/android/mail/browse/SelectedConversationsActionMenu;)V
    .locals 0

    .prologue
    .line 103
    iput-object p1, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu$1;->this$0:Lcom/android/mail/browse/SelectedConversationsActionMenu;

    invoke-direct {p0}, Lcom/android/mail/providers/AccountObserver;-><init>()V

    return-void
.end method


# virtual methods
.method public onChanged(Lcom/android/mail/providers/Account;)V
    .locals 1
    .param p1, "newAccount"    # Lcom/android/mail/providers/Account;

    .prologue
    .line 106
    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu$1;->this$0:Lcom/android/mail/browse/SelectedConversationsActionMenu;

    # setter for: Lcom/android/mail/browse/SelectedConversationsActionMenu;->mAccount:Lcom/android/mail/providers/Account;
    invoke-static {v0, p1}, Lcom/android/mail/browse/SelectedConversationsActionMenu;->access$002(Lcom/android/mail/browse/SelectedConversationsActionMenu;Lcom/android/mail/providers/Account;)Lcom/android/mail/providers/Account;

    .line 107
    return-void
.end method
