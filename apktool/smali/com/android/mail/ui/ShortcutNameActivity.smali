.class public Lcom/android/mail/ui/ShortcutNameActivity;
.super Landroid/app/Activity;
.source "ShortcutNameActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Landroid/widget/TextView$OnEditorActionListener;


# instance fields
.field private mFolderName:Ljava/lang/String;

.field private mFolderText:Landroid/widget/EditText;

.field private mShortcutClickIntent:Landroid/content/Intent;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method

.method private doCancel()V
    .locals 1

    .prologue
    .line 113
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/ShortcutNameActivity;->setResult(I)V

    .line 114
    invoke-virtual {p0}, Lcom/android/mail/ui/ShortcutNameActivity;->finish()V

    .line 115
    return-void
.end method

.method private doCreateShortcut()V
    .locals 5

    .prologue
    .line 95
    iget-object v3, p0, Lcom/android/mail/ui/ShortcutNameActivity;->mFolderText:Landroid/widget/EditText;

    invoke-virtual {v3}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    .line 97
    .local v2, "userShortcutName":Ljava/lang/CharSequence;
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 98
    .local v0, "resultIntent":Landroid/content/Intent;
    const-string v3, "extra_folder_click_intent"

    iget-object v4, p0, Lcom/android/mail/ui/ShortcutNameActivity;->mShortcutClickIntent:Landroid/content/Intent;

    invoke-virtual {v0, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 101
    const-string v3, "android.intent.extra.shortcut.NAME"

    iget-object v4, p0, Lcom/android/mail/ui/ShortcutNameActivity;->mFolderName:Ljava/lang/String;

    invoke-virtual {v0, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 103
    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    .line 104
    .local v1, "shortcutName":Ljava/lang/String;
    invoke-static {v1}, Landroid/text/TextUtils;->getTrimmedLength(Ljava/lang/CharSequence;)I

    move-result v3

    if-lez v3, :cond_0

    .line 105
    iget-object v3, p0, Lcom/android/mail/ui/ShortcutNameActivity;->mShortcutClickIntent:Landroid/content/Intent;

    const-string v4, "android.intent.extra.shortcut.NAME"

    invoke-virtual {v3, v4, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 108
    :cond_0
    const/4 v3, -0x1

    iget-object v4, p0, Lcom/android/mail/ui/ShortcutNameActivity;->mShortcutClickIntent:Landroid/content/Intent;

    invoke-virtual {p0, v3, v4}, Lcom/android/mail/ui/ShortcutNameActivity;->setResult(ILandroid/content/Intent;)V

    .line 109
    invoke-virtual {p0}, Lcom/android/mail/ui/ShortcutNameActivity;->finish()V

    .line 110
    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 77
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    .line 78
    .local v0, "id":I
    const v1, 0x7f1000fa

    if-ne v1, v0, :cond_1

    .line 79
    invoke-direct {p0}, Lcom/android/mail/ui/ShortcutNameActivity;->doCreateShortcut()V

    .line 83
    :cond_0
    :goto_0
    return-void

    .line 80
    :cond_1
    const v1, 0x7f1000bf

    if-ne v1, v0, :cond_0

    .line 81
    invoke-direct {p0}, Lcom/android/mail/ui/ShortcutNameActivity;->doCancel()V

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "icicle"    # Landroid/os/Bundle;

    .prologue
    .line 53
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 54
    const v2, 0x7f040067

    invoke-virtual {p0, v2}, Lcom/android/mail/ui/ShortcutNameActivity;->setContentView(I)V

    .line 56
    invoke-virtual {p0}, Lcom/android/mail/ui/ShortcutNameActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    const-string v3, "extra_folder_click_intent"

    invoke-virtual {v2, v3}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v2

    check-cast v2, Landroid/content/Intent;

    iput-object v2, p0, Lcom/android/mail/ui/ShortcutNameActivity;->mShortcutClickIntent:Landroid/content/Intent;

    .line 57
    invoke-virtual {p0}, Lcom/android/mail/ui/ShortcutNameActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    const-string v3, "extra_shortcut_name"

    invoke-virtual {v2, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/android/mail/ui/ShortcutNameActivity;->mFolderName:Ljava/lang/String;

    .line 59
    const v2, 0x7f1000ec

    invoke-virtual {p0, v2}, Lcom/android/mail/ui/ShortcutNameActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/EditText;

    iput-object v2, p0, Lcom/android/mail/ui/ShortcutNameActivity;->mFolderText:Landroid/widget/EditText;

    .line 60
    iget-object v2, p0, Lcom/android/mail/ui/ShortcutNameActivity;->mFolderText:Landroid/widget/EditText;

    iget-object v3, p0, Lcom/android/mail/ui/ShortcutNameActivity;->mFolderName:Ljava/lang/String;

    invoke-virtual {v2, v3}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 61
    iget-object v2, p0, Lcom/android/mail/ui/ShortcutNameActivity;->mFolderText:Landroid/widget/EditText;

    invoke-virtual {v2, p0}, Landroid/widget/EditText;->setOnEditorActionListener(Landroid/widget/TextView$OnEditorActionListener;)V

    .line 64
    iget-object v2, p0, Lcom/android/mail/ui/ShortcutNameActivity;->mFolderText:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->requestFocus()Z

    .line 65
    iget-object v2, p0, Lcom/android/mail/ui/ShortcutNameActivity;->mFolderText:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    .line 66
    .local v1, "editableText":Landroid/text/Editable;
    invoke-interface {v1}, Landroid/text/Editable;->length()I

    move-result v2

    invoke-static {v1, v2}, Landroid/text/Selection;->setSelection(Landroid/text/Spannable;I)V

    .line 68
    const v2, 0x7f1000fa

    invoke-virtual {p0, v2}, Lcom/android/mail/ui/ShortcutNameActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 69
    const v2, 0x7f1000bf

    invoke-virtual {p0, v2}, Lcom/android/mail/ui/ShortcutNameActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 70
    invoke-virtual {p0}, Lcom/android/mail/ui/ShortcutNameActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 71
    .local v0, "actionBar":Landroid/app/ActionBar;
    if-eqz v0, :cond_0

    .line 72
    const v2, 0x7f030001

    invoke-virtual {v0, v2}, Landroid/app/ActionBar;->setIcon(I)V

    .line 74
    :cond_0
    return-void
.end method

.method public onEditorAction(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "v"    # Landroid/widget/TextView;
    .param p2, "actionId"    # I
    .param p3, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 86
    const/4 v0, 0x6

    if-ne p2, v0, :cond_0

    .line 87
    invoke-direct {p0}, Lcom/android/mail/ui/ShortcutNameActivity;->doCreateShortcut()V

    .line 88
    const/4 v0, 0x1

    .line 90
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
