.class public Lcom/android/mail/ui/SearchMailActionBarView;
.super Lcom/android/mail/ui/MailActionBarView;
.source "SearchMailActionBarView.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 38
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/android/mail/ui/SearchMailActionBarView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 39
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 42
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/android/mail/ui/SearchMailActionBarView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 43
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 46
    invoke-direct {p0, p1, p2, p3}, Lcom/android/mail/ui/MailActionBarView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 47
    return-void
.end method

.method private clearSearchFocus()V
    .locals 2

    .prologue
    .line 71
    invoke-virtual {p0}, Lcom/android/mail/ui/SearchMailActionBarView;->getSearch()Landroid/view/MenuItem;

    move-result-object v0

    .line 72
    .local v0, "search":Landroid/view/MenuItem;
    if-eqz v0, :cond_0

    .line 73
    invoke-interface {v0}, Landroid/view/MenuItem;->getActionView()Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/SearchView;

    .line 74
    .local v1, "searchWidget":Landroid/widget/SearchView;
    invoke-virtual {v1}, Landroid/widget/SearchView;->clearFocus()V

    .line 76
    .end local v1    # "searchWidget":Landroid/widget/SearchView;
    :cond_0
    return-void
.end method

.method private setPopulatedSearchView()V
    .locals 5

    .prologue
    .line 79
    invoke-virtual {p0}, Lcom/android/mail/ui/SearchMailActionBarView;->getSearch()Landroid/view/MenuItem;

    move-result-object v1

    .line 80
    .local v1, "search":Landroid/view/MenuItem;
    if-eqz v1, :cond_1

    .line 81
    invoke-interface {v1}, Landroid/view/MenuItem;->expandActionView()Z

    .line 82
    iget-object v3, p0, Lcom/android/mail/ui/MailActionBarView;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v3}, Lcom/android/mail/ui/ControllableActivity;->getIntent()Landroid/content/Intent;

    move-result-object v3

    const-string v4, "query"

    invoke-virtual {v3, v4}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 84
    .local v0, "query":Ljava/lang/String;
    invoke-interface {v1}, Landroid/view/MenuItem;->getActionView()Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/SearchView;

    .line 85
    .local v2, "searchWidget":Landroid/widget/SearchView;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 86
    const/4 v3, 0x0

    invoke-virtual {v2, v0, v3}, Landroid/widget/SearchView;->setQuery(Ljava/lang/CharSequence;Z)V

    .line 88
    :cond_0
    invoke-virtual {v2}, Landroid/widget/SearchView;->clearFocus()V

    .line 90
    .end local v0    # "query":Ljava/lang/String;
    .end local v2    # "searchWidget":Landroid/widget/SearchView;
    :cond_1
    return-void
.end method


# virtual methods
.method public onMenuItemActionCollapse(Landroid/view/MenuItem;)Z
    .locals 2
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 94
    invoke-super {p0, p1}, Lcom/android/mail/ui/MailActionBarView;->onMenuItemActionCollapse(Landroid/view/MenuItem;)Z

    .line 98
    invoke-virtual {p0}, Lcom/android/mail/ui/SearchMailActionBarView;->getMode()I

    move-result v0

    .line 99
    .local v0, "mode":I
    const/4 v1, 0x4

    if-eq v0, v1, :cond_0

    invoke-virtual {p0}, Lcom/android/mail/ui/SearchMailActionBarView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcom/android/mail/utils/Utils;->showTwoPaneSearchResults(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_1

    const/4 v1, 0x5

    if-ne v0, v1, :cond_1

    .line 105
    :cond_0
    iget-object v1, p0, Lcom/android/mail/ui/MailActionBarView;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v1}, Lcom/android/mail/ui/ActivityController;->exitSearchMode()V

    .line 110
    :cond_1
    const/4 v1, 0x1

    return v1
.end method

.method public onPrepareOptionsMenu(Landroid/view/Menu;)Z
    .locals 2
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 52
    invoke-super {p0, p1}, Lcom/android/mail/ui/MailActionBarView;->onPrepareOptionsMenu(Landroid/view/Menu;)Z

    .line 53
    invoke-virtual {p0}, Lcom/android/mail/ui/SearchMailActionBarView;->getMode()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 64
    :goto_0
    const/4 v0, 0x0

    return v0

    .line 56
    :pswitch_0
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView;->mActionBar:Landroid/app/ActionBar;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 57
    invoke-virtual {p0}, Lcom/android/mail/ui/SearchMailActionBarView;->setEmptyMode()V

    .line 58
    invoke-virtual {p0}, Lcom/android/mail/ui/SearchMailActionBarView;->showConversationSubject()Z

    move-result v0

    if-nez v0, :cond_0

    .line 59
    invoke-direct {p0}, Lcom/android/mail/ui/SearchMailActionBarView;->setPopulatedSearchView()V

    .line 61
    :cond_0
    invoke-direct {p0}, Lcom/android/mail/ui/SearchMailActionBarView;->clearSearchFocus()V

    goto :goto_0

    .line 53
    :pswitch_data_0
    .packed-switch 0x4
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method
