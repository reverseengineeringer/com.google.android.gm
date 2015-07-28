.class Lcom/android/mail/ui/MailboxSelectionActivity$3;
.super Landroid/widget/SimpleCursorAdapter;
.source "MailboxSelectionActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/mail/ui/MailboxSelectionActivity;->updateAccountList(Landroid/database/Cursor;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/ui/MailboxSelectionActivity;


# direct methods
.method constructor <init>(Lcom/android/mail/ui/MailboxSelectionActivity;Landroid/content/Context;ILandroid/database/Cursor;[Ljava/lang/String;[II)V
    .locals 7
    .param p2, "x0"    # Landroid/content/Context;
    .param p3, "x1"    # I
    .param p4, "x2"    # Landroid/database/Cursor;
    .param p5, "x3"    # [Ljava/lang/String;
    .param p6, "x4"    # [I
    .param p7, "x5"    # I

    .prologue
    .line 247
    iput-object p1, p0, Lcom/android/mail/ui/MailboxSelectionActivity$3;->this$0:Lcom/android/mail/ui/MailboxSelectionActivity;

    move-object v0, p0

    move-object v1, p2

    move v2, p3

    move-object v3, p4

    move-object v4, p5

    move-object v5, p6

    move v6, p7

    invoke-direct/range {v0 .. v6}, Landroid/widget/SimpleCursorAdapter;-><init>(Landroid/content/Context;ILandroid/database/Cursor;[Ljava/lang/String;[II)V

    return-void
.end method


# virtual methods
.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 4
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 250
    invoke-super {p0, p1, p2, p3}, Landroid/widget/SimpleCursorAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    .line 251
    .local v1, "v":Landroid/view/View;
    const v2, 0x7f1000cb

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 252
    .local v0, "accountView":Landroid/widget/TextView;
    new-instance v3, Lcom/android/mail/providers/Account;

    invoke-virtual {p0, p1}, Lcom/android/mail/ui/MailboxSelectionActivity$3;->getItem(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/database/Cursor;

    invoke-direct {v3, v2}, Lcom/android/mail/providers/Account;-><init>(Landroid/database/Cursor;)V

    iget-object v2, v3, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 253
    return-object v1
.end method
