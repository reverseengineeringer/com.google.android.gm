.class Lcom/android/mail/ui/MailActionBarView$2;
.super Lcom/android/mail/providers/AccountObserver;
.source "MailActionBarView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/MailActionBarView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/ui/MailActionBarView;


# direct methods
.method constructor <init>(Lcom/android/mail/ui/MailActionBarView;)V
    .locals 0

    .prologue
    .line 111
    iput-object p1, p0, Lcom/android/mail/ui/MailActionBarView$2;->this$0:Lcom/android/mail/ui/MailActionBarView;

    invoke-direct {p0}, Lcom/android/mail/providers/AccountObserver;-><init>()V

    return-void
.end method


# virtual methods
.method public onChanged(Lcom/android/mail/providers/Account;)V
    .locals 2
    .param p1, "newAccount"    # Lcom/android/mail/providers/Account;

    .prologue
    .line 114
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView$2;->this$0:Lcom/android/mail/ui/MailActionBarView;

    # setter for: Lcom/android/mail/ui/MailActionBarView;->mAccount:Lcom/android/mail/providers/Account;
    invoke-static {v0, p1}, Lcom/android/mail/ui/MailActionBarView;->access$002(Lcom/android/mail/ui/MailActionBarView;Lcom/android/mail/providers/Account;)Lcom/android/mail/providers/Account;

    .line 115
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView$2;->this$0:Lcom/android/mail/ui/MailActionBarView;

    # getter for: Lcom/android/mail/ui/MailActionBarView;->mFolderAccountName:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/android/mail/ui/MailActionBarView;->access$100(Lcom/android/mail/ui/MailActionBarView;)Landroid/widget/TextView;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 116
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView$2;->this$0:Lcom/android/mail/ui/MailActionBarView;

    # getter for: Lcom/android/mail/ui/MailActionBarView;->mFolderAccountName:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/android/mail/ui/MailActionBarView;->access$100(Lcom/android/mail/ui/MailActionBarView;)Landroid/widget/TextView;

    move-result-object v0

    iget-object v1, p0, Lcom/android/mail/ui/MailActionBarView$2;->this$0:Lcom/android/mail/ui/MailActionBarView;

    # getter for: Lcom/android/mail/ui/MailActionBarView;->mAccount:Lcom/android/mail/providers/Account;
    invoke-static {v1}, Lcom/android/mail/ui/MailActionBarView;->access$000(Lcom/android/mail/ui/MailActionBarView;)Lcom/android/mail/providers/Account;

    move-result-object v1

    iget-object v1, v1, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 118
    :cond_0
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView$2;->this$0:Lcom/android/mail/ui/MailActionBarView;

    # getter for: Lcom/android/mail/ui/MailActionBarView;->mSpinner:Lcom/android/mail/ui/MailSpinner;
    invoke-static {v0}, Lcom/android/mail/ui/MailActionBarView;->access$200(Lcom/android/mail/ui/MailActionBarView;)Lcom/android/mail/ui/MailSpinner;

    move-result-object v0

    iget-object v1, p0, Lcom/android/mail/ui/MailActionBarView$2;->this$0:Lcom/android/mail/ui/MailActionBarView;

    # getter for: Lcom/android/mail/ui/MailActionBarView;->mAccount:Lcom/android/mail/providers/Account;
    invoke-static {v1}, Lcom/android/mail/ui/MailActionBarView;->access$000(Lcom/android/mail/ui/MailActionBarView;)Lcom/android/mail/providers/Account;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/android/mail/ui/MailSpinner;->setAccount(Lcom/android/mail/providers/Account;)V

    .line 119
    return-void
.end method
