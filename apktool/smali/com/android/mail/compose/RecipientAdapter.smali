.class public Lcom/android/mail/compose/RecipientAdapter;
.super Lcom/android/ex/chips/BaseRecipientAdapter;
.source "RecipientAdapter.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/android/mail/providers/Account;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "account"    # Lcom/android/mail/providers/Account;

    .prologue
    .line 25
    invoke-direct {p0, p1}, Lcom/android/ex/chips/BaseRecipientAdapter;-><init>(Landroid/content/Context;)V

    .line 26
    invoke-virtual {p0, p2}, Lcom/android/mail/compose/RecipientAdapter;->setAccount(Landroid/accounts/Account;)V

    .line 27
    return-void
.end method
