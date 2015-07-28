.class Lcom/android/mail/ui/AbstractConversationViewFragment$2;
.super Lcom/android/mail/providers/AccountObserver;
.source "AbstractConversationViewFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/AbstractConversationViewFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;


# direct methods
.method constructor <init>(Lcom/android/mail/ui/AbstractConversationViewFragment;)V
    .locals 0

    .prologue
    .line 134
    iput-object p1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$2;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    invoke-direct {p0}, Lcom/android/mail/providers/AccountObserver;-><init>()V

    return-void
.end method


# virtual methods
.method public onChanged(Lcom/android/mail/providers/Account;)V
    .locals 2
    .param p1, "newAccount"    # Lcom/android/mail/providers/Account;

    .prologue
    .line 137
    iget-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$2;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    iget-object v0, v1, Lcom/android/mail/ui/AbstractConversationViewFragment;->mAccount:Lcom/android/mail/providers/Account;

    .line 138
    .local v0, "oldAccount":Lcom/android/mail/providers/Account;
    iget-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$2;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    iput-object p1, v1, Lcom/android/mail/ui/AbstractConversationViewFragment;->mAccount:Lcom/android/mail/providers/Account;

    .line 139
    iget-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$2;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    invoke-virtual {v1, p1, v0}, Lcom/android/mail/ui/AbstractConversationViewFragment;->onAccountChanged(Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Account;)V

    .line 140
    return-void
.end method
