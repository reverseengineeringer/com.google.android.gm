.class public Lcom/android/mail/ui/MailSpinner;
.super Landroid/widget/FrameLayout;
.source "MailSpinner.java"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Landroid/widget/AdapterView$OnItemClickListener;


# static fields
.field static final synthetic $assertionsDisabled:Z

.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private mAccount:Lcom/android/mail/providers/Account;

.field private final mAccountName:Landroid/widget/TextView;

.field private final mContainer:Landroid/widget/LinearLayout;

.field private mController:Lcom/android/mail/ui/ActivityController;

.field private mFolder:Lcom/android/mail/providers/Folder;

.field private final mFolderCount:Landroid/widget/TextView;

.field private final mFolderName:Landroid/widget/TextView;

.field private final mListPopupWindow:Landroid/widget/ListPopupWindow;

.field private mSpinnerAdapter:Lcom/android/mail/AccountSpinnerAdapter;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 38
    const-class v0, Lcom/android/mail/ui/MailSpinner;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lcom/android/mail/ui/MailSpinner;->$assertionsDisabled:Z

    .line 39
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/ui/MailSpinner;->LOG_TAG:Ljava/lang/String;

    return-void

    .line 38
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 51
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/android/mail/ui/MailSpinner;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 52
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 55
    const/4 v0, -0x1

    invoke-direct {p0, p1, p2, v0}, Lcom/android/mail/ui/MailSpinner;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 56
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 59
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 60
    new-instance v1, Landroid/widget/ListPopupWindow;

    invoke-direct {v1, p1}, Landroid/widget/ListPopupWindow;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/android/mail/ui/MailSpinner;->mListPopupWindow:Landroid/widget/ListPopupWindow;

    .line 61
    iget-object v1, p0, Lcom/android/mail/ui/MailSpinner;->mListPopupWindow:Landroid/widget/ListPopupWindow;

    invoke-virtual {v1, p0}, Landroid/widget/ListPopupWindow;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 62
    iget-object v1, p0, Lcom/android/mail/ui/MailSpinner;->mListPopupWindow:Landroid/widget/ListPopupWindow;

    invoke-virtual {v1, p0}, Landroid/widget/ListPopupWindow;->setAnchorView(Landroid/view/View;)V

    .line 63
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0b0015

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    .line 65
    .local v0, "dropDownWidth":I
    iget-object v1, p0, Lcom/android/mail/ui/MailSpinner;->mListPopupWindow:Landroid/widget/ListPopupWindow;

    invoke-virtual {v1, v0}, Landroid/widget/ListPopupWindow;->setWidth(I)V

    .line 66
    iget-object v1, p0, Lcom/android/mail/ui/MailSpinner;->mListPopupWindow:Landroid/widget/ListPopupWindow;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/widget/ListPopupWindow;->setModal(Z)V

    .line 67
    invoke-virtual {p0}, Lcom/android/mail/ui/MailSpinner;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    const v2, 0x7f040006

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/android/mail/ui/MailSpinner;->addView(Landroid/view/View;)V

    .line 69
    const v1, 0x7f100023

    invoke-virtual {p0, v1}, Lcom/android/mail/ui/MailSpinner;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/android/mail/ui/MailSpinner;->mAccountName:Landroid/widget/TextView;

    .line 70
    const v1, 0x7f100022

    invoke-virtual {p0, v1}, Lcom/android/mail/ui/MailSpinner;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/android/mail/ui/MailSpinner;->mFolderName:Landroid/widget/TextView;

    .line 71
    const v1, 0x7f100020

    invoke-virtual {p0, v1}, Lcom/android/mail/ui/MailSpinner;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/android/mail/ui/MailSpinner;->mFolderCount:Landroid/widget/TextView;

    .line 72
    const v1, 0x7f100021

    invoke-virtual {p0, v1}, Lcom/android/mail/ui/MailSpinner;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/android/mail/ui/MailSpinner;->mContainer:Landroid/widget/LinearLayout;

    .line 73
    iget-object v1, p0, Lcom/android/mail/ui/MailSpinner;->mContainer:Landroid/widget/LinearLayout;

    invoke-virtual {v1, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 74
    return-void
.end method


# virtual methods
.method public final changeEnabledState(Z)V
    .locals 2
    .param p1, "enabled"    # Z

    .prologue
    .line 88
    invoke-virtual {p0, p1}, Lcom/android/mail/ui/MailSpinner;->setEnabled(Z)V

    .line 89
    if-eqz p1, :cond_0

    .line 90
    iget-object v0, p0, Lcom/android/mail/ui/MailSpinner;->mContainer:Landroid/widget/LinearLayout;

    const v1, 0x7f020096

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setBackgroundResource(I)V

    .line 94
    :goto_0
    return-void

    .line 92
    :cond_0
    iget-object v0, p0, Lcom/android/mail/ui/MailSpinner;->mContainer:Landroid/widget/LinearLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 166
    invoke-virtual {p0}, Lcom/android/mail/ui/MailSpinner;->isEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/ui/MailSpinner;->mListPopupWindow:Landroid/widget/ListPopupWindow;

    invoke-virtual {v0}, Landroid/widget/ListPopupWindow;->isShowing()Z

    move-result v0

    if-nez v0, :cond_0

    .line 167
    iget-object v0, p0, Lcom/android/mail/ui/MailSpinner;->mListPopupWindow:Landroid/widget/ListPopupWindow;

    invoke-virtual {v0}, Landroid/widget/ListPopupWindow;->show()V

    .line 169
    :cond_0
    return-void
.end method

.method public onFolderUpdated(Lcom/android/mail/providers/Folder;)V
    .locals 1
    .param p1, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 176
    iget-object v0, p0, Lcom/android/mail/ui/MailSpinner;->mSpinnerAdapter:Lcom/android/mail/AccountSpinnerAdapter;

    invoke-virtual {v0, p1}, Lcom/android/mail/AccountSpinnerAdapter;->onFolderUpdated(Lcom/android/mail/providers/Folder;)V

    .line 177
    invoke-virtual {p0, p1}, Lcom/android/mail/ui/MailSpinner;->setFolder(Lcom/android/mail/providers/Folder;)V

    .line 178
    return-void
.end method

.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 10
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 120
    sget-object v4, Lcom/android/mail/ui/MailSpinner;->LOG_TAG:Ljava/lang/String;

    const-string v5, "onNavigationItemSelected(%d, %d) called"

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v6, v8

    invoke-static {p4, p5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    aput-object v7, v6, v9

    invoke-static {v4, v5, v6}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 121
    iget-object v4, p0, Lcom/android/mail/ui/MailSpinner;->mSpinnerAdapter:Lcom/android/mail/AccountSpinnerAdapter;

    invoke-virtual {v4, p3}, Lcom/android/mail/AccountSpinnerAdapter;->getType(I)I

    move-result v3

    .line 122
    .local v3, "type":I
    const/4 v1, 0x0

    .line 123
    .local v1, "dismiss":Z
    packed-switch v3, :pswitch_data_0

    .line 155
    :goto_0
    :pswitch_0
    if-eqz v1, :cond_0

    .line 156
    iget-object v4, p0, Lcom/android/mail/ui/MailSpinner;->mListPopupWindow:Landroid/widget/ListPopupWindow;

    invoke-virtual {v4}, Landroid/widget/ListPopupWindow;->dismiss()V

    .line 158
    :cond_0
    return-void

    .line 126
    :pswitch_1
    sget-object v4, Lcom/android/mail/ui/MailSpinner;->LOG_TAG:Ljava/lang/String;

    const-string v5, "Got a tap on the dead header"

    new-array v6, v8, [Ljava/lang/Object;

    invoke-static {v4, v5, v6}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0

    .line 130
    :pswitch_2
    iget-object v4, p0, Lcom/android/mail/ui/MailSpinner;->mSpinnerAdapter:Lcom/android/mail/AccountSpinnerAdapter;

    invoke-virtual {v4, p3}, Lcom/android/mail/AccountSpinnerAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Account;

    .line 131
    .local v0, "account":Lcom/android/mail/providers/Account;
    sget-object v4, Lcom/android/mail/ui/MailSpinner;->LOG_TAG:Ljava/lang/String;

    const-string v5, "onNavigationItemSelected: Selecting account: %s"

    new-array v6, v9, [Ljava/lang/Object;

    iget-object v7, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    aput-object v7, v6, v8

    invoke-static {v4, v5, v6}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 133
    iget-object v4, p0, Lcom/android/mail/ui/MailSpinner;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v4, v4, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    iget-object v5, v0, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    invoke-virtual {v4, v5}, Landroid/net/Uri;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 135
    iget-object v4, p0, Lcom/android/mail/ui/MailSpinner;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v4}, Lcom/android/mail/ui/ActivityController;->loadAccountInbox()V

    .line 140
    :goto_1
    const/4 v1, 0x1

    .line 141
    goto :goto_0

    .line 138
    :cond_1
    iget-object v4, p0, Lcom/android/mail/ui/MailSpinner;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v4, v0}, Lcom/android/mail/ui/ActivityController;->onAccountChanged(Lcom/android/mail/providers/Account;)V

    goto :goto_1

    .line 143
    .end local v0    # "account":Lcom/android/mail/providers/Account;
    :pswitch_3
    iget-object v4, p0, Lcom/android/mail/ui/MailSpinner;->mSpinnerAdapter:Lcom/android/mail/AccountSpinnerAdapter;

    invoke-virtual {v4, p3}, Lcom/android/mail/AccountSpinnerAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v2

    .line 144
    .local v2, "folder":Ljava/lang/Object;
    sget-boolean v4, Lcom/android/mail/ui/MailSpinner;->$assertionsDisabled:Z

    if-nez v4, :cond_2

    instance-of v4, v2, Lcom/android/mail/providers/Folder;

    if-nez v4, :cond_2

    new-instance v4, Ljava/lang/AssertionError;

    invoke-direct {v4}, Ljava/lang/AssertionError;-><init>()V

    throw v4

    .line 145
    :cond_2
    sget-object v5, Lcom/android/mail/ui/MailSpinner;->LOG_TAG:Ljava/lang/String;

    const-string v6, "onNavigationItemSelected: Selecting folder: %s"

    new-array v7, v9, [Ljava/lang/Object;

    move-object v4, v2

    check-cast v4, Lcom/android/mail/providers/Folder;

    iget-object v4, v4, Lcom/android/mail/providers/Folder;->name:Ljava/lang/String;

    aput-object v4, v7, v8

    invoke-static {v5, v6, v7}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 147
    iget-object v4, p0, Lcom/android/mail/ui/MailSpinner;->mController:Lcom/android/mail/ui/ActivityController;

    check-cast v2, Lcom/android/mail/providers/Folder;

    .end local v2    # "folder":Ljava/lang/Object;
    invoke-interface {v4, v2}, Lcom/android/mail/ui/ActivityController;->onFolderChanged(Lcom/android/mail/providers/Folder;)V

    .line 148
    const/4 v1, 0x1

    .line 149
    goto :goto_0

    .line 151
    :pswitch_4
    iget-object v4, p0, Lcom/android/mail/ui/MailSpinner;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v4}, Lcom/android/mail/ui/ActivityController;->showFolderList()V

    .line 152
    const/4 v1, 0x1

    goto :goto_0

    .line 123
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_2
        :pswitch_0
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method

.method public setAccount(Lcom/android/mail/providers/Account;)V
    .locals 2
    .param p1, "account"    # Lcom/android/mail/providers/Account;

    .prologue
    .line 97
    iput-object p1, p0, Lcom/android/mail/ui/MailSpinner;->mAccount:Lcom/android/mail/providers/Account;

    .line 98
    iget-object v0, p0, Lcom/android/mail/ui/MailSpinner;->mAccount:Lcom/android/mail/providers/Account;

    if-eqz v0, :cond_0

    .line 99
    iget-object v0, p0, Lcom/android/mail/ui/MailSpinner;->mAccountName:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/android/mail/ui/MailSpinner;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v1, v1, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 101
    :cond_0
    return-void
.end method

.method public setAdapter(Lcom/android/mail/AccountSpinnerAdapter;)V
    .locals 2
    .param p1, "adapter"    # Lcom/android/mail/AccountSpinnerAdapter;

    .prologue
    .line 77
    iput-object p1, p0, Lcom/android/mail/ui/MailSpinner;->mSpinnerAdapter:Lcom/android/mail/AccountSpinnerAdapter;

    .line 78
    iget-object v0, p0, Lcom/android/mail/ui/MailSpinner;->mListPopupWindow:Landroid/widget/ListPopupWindow;

    iget-object v1, p0, Lcom/android/mail/ui/MailSpinner;->mSpinnerAdapter:Lcom/android/mail/AccountSpinnerAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/ListPopupWindow;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 79
    return-void
.end method

.method public setController(Lcom/android/mail/ui/ActivityController;)V
    .locals 0
    .param p1, "controller"    # Lcom/android/mail/ui/ActivityController;

    .prologue
    .line 161
    iput-object p1, p0, Lcom/android/mail/ui/MailSpinner;->mController:Lcom/android/mail/ui/ActivityController;

    .line 162
    return-void
.end method

.method public setFolder(Lcom/android/mail/providers/Folder;)V
    .locals 3
    .param p1, "f"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 104
    iput-object p1, p0, Lcom/android/mail/ui/MailSpinner;->mFolder:Lcom/android/mail/providers/Folder;

    .line 105
    iget-object v0, p0, Lcom/android/mail/ui/MailSpinner;->mFolder:Lcom/android/mail/providers/Folder;

    if-eqz v0, :cond_0

    .line 106
    iget-object v0, p0, Lcom/android/mail/ui/MailSpinner;->mFolderName:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/android/mail/ui/MailSpinner;->mFolder:Lcom/android/mail/providers/Folder;

    iget-object v1, v1, Lcom/android/mail/providers/Folder;->name:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 107
    iget-object v0, p0, Lcom/android/mail/ui/MailSpinner;->mFolderCount:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/android/mail/ui/MailSpinner;->getContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/ui/MailSpinner;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-static {v2}, Lcom/android/mail/utils/Utils;->getFolderUnreadDisplayCount(Lcom/android/mail/providers/Folder;)I

    move-result v2

    invoke-static {v1, v2}, Lcom/android/mail/utils/Utils;->getUnreadCountString(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 110
    iget-object v0, p0, Lcom/android/mail/ui/MailSpinner;->mSpinnerAdapter:Lcom/android/mail/AccountSpinnerAdapter;

    if-eqz v0, :cond_0

    .line 113
    iget-object v0, p0, Lcom/android/mail/ui/MailSpinner;->mSpinnerAdapter:Lcom/android/mail/AccountSpinnerAdapter;

    iget-object v1, p0, Lcom/android/mail/ui/MailSpinner;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-virtual {v0, v1}, Lcom/android/mail/AccountSpinnerAdapter;->setCurrentFolder(Lcom/android/mail/providers/Folder;)Z

    .line 116
    :cond_0
    return-void
.end method
