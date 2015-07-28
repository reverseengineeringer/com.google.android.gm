.class public abstract Lcom/google/android/gm/BaseLabelsController;
.super Ljava/lang/Object;
.source "BaseLabelsController.java"

# interfaces
.implements Lcom/google/android/gm/LabelsActivityController;


# instance fields
.field protected mAccount:Ljava/lang/String;

.field protected final mActionBar:Landroid/app/ActionBar;

.field protected final mActivity:Lcom/google/android/gm/LabelsActivityController$ControllableLabelsActivity;

.field protected final mContext:Landroid/content/Context;

.field protected mDefaultLabel:Ljava/lang/String;

.field mGmail:Lcom/google/android/gm/provider/Gmail;

.field private mHomeIsBack:Z

.field private mIncludedLabels:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field protected mLabelListVisbile:Z

.field private mNumOfSyncDays:I

.field private final mObservers:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/google/android/gm/LabelSettingsObserver;",
            ">;"
        }
    .end annotation
.end field

.field private mPartialLabels:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field mSettings:Lcom/google/android/gm/provider/Gmail$Settings;


# direct methods
.method public constructor <init>(Lcom/google/android/gm/LabelsActivityController$ControllableLabelsActivity;)V
    .locals 1
    .param p1, "activity"    # Lcom/google/android/gm/LabelsActivityController$ControllableLabelsActivity;

    .prologue
    .line 50
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 45
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/android/gm/BaseLabelsController;->mHomeIsBack:Z

    .line 48
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/gm/BaseLabelsController;->mLabelListVisbile:Z

    .line 51
    iput-object p1, p0, Lcom/google/android/gm/BaseLabelsController;->mActivity:Lcom/google/android/gm/LabelsActivityController$ControllableLabelsActivity;

    .line 52
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/BaseLabelsController;->mObservers:Ljava/util/List;

    .line 53
    iget-object v0, p0, Lcom/google/android/gm/BaseLabelsController;->mActivity:Lcom/google/android/gm/LabelsActivityController$ControllableLabelsActivity;

    invoke-interface {v0}, Lcom/google/android/gm/LabelsActivityController$ControllableLabelsActivity;->getContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/BaseLabelsController;->mContext:Landroid/content/Context;

    .line 54
    iget-object v0, p0, Lcom/google/android/gm/BaseLabelsController;->mActivity:Lcom/google/android/gm/LabelsActivityController$ControllableLabelsActivity;

    invoke-interface {v0}, Lcom/google/android/gm/LabelsActivityController$ControllableLabelsActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/BaseLabelsController;->mActionBar:Landroid/app/ActionBar;

    .line 55
    return-void
.end method

.method static synthetic access$000(Lcom/google/android/gm/BaseLabelsController;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/BaseLabelsController;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/google/android/gm/BaseLabelsController;->mIncludedLabels:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$100(Lcom/google/android/gm/BaseLabelsController;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/BaseLabelsController;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/google/android/gm/BaseLabelsController;->mPartialLabels:Ljava/util/List;

    return-object v0
.end method


# virtual methods
.method public getIncludedLabels()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 168
    iget-object v0, p0, Lcom/google/android/gm/BaseLabelsController;->mIncludedLabels:Ljava/util/List;

    invoke-static {v0}, Lcom/google/common/collect/Lists;->newArrayList(Ljava/lang/Iterable;)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method public getNumberOfSyncDays()I
    .locals 1

    .prologue
    .line 178
    iget v0, p0, Lcom/google/android/gm/BaseLabelsController;->mNumOfSyncDays:I

    return v0
.end method

.method public getPartialLabels()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 173
    iget-object v0, p0, Lcom/google/android/gm/BaseLabelsController;->mPartialLabels:Ljava/util/List;

    invoke-static {v0}, Lcom/google/common/collect/Lists;->newArrayList(Ljava/lang/Iterable;)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method public handleBackPressed()Z
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 103
    iget-object v0, p0, Lcom/google/android/gm/BaseLabelsController;->mActionBar:Landroid/app/ActionBar;

    iget-object v1, p0, Lcom/google/android/gm/BaseLabelsController;->mAccount:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setSubtitle(Ljava/lang/CharSequence;)V

    .line 104
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/gm/BaseLabelsController;->mLabelListVisbile:Z

    .line 105
    invoke-virtual {p0, v2}, Lcom/google/android/gm/BaseLabelsController;->toggleUpButton(Z)V

    .line 106
    iget-object v0, p0, Lcom/google/android/gm/BaseLabelsController;->mActivity:Lcom/google/android/gm/LabelsActivityController$ControllableLabelsActivity;

    invoke-interface {v0}, Lcom/google/android/gm/LabelsActivityController$ControllableLabelsActivity;->invalidateOptionsMenu()V

    .line 107
    return v2
.end method

.method public handleCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 2
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 112
    iget-object v1, p0, Lcom/google/android/gm/BaseLabelsController;->mActivity:Lcom/google/android/gm/LabelsActivityController$ControllableLabelsActivity;

    invoke-interface {v1}, Lcom/google/android/gm/LabelsActivityController$ControllableLabelsActivity;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v0

    .line 113
    .local v0, "inflater":Landroid/view/MenuInflater;
    const v1, 0x7f120008

    invoke-virtual {v0, v1, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 114
    const/4 v1, 0x1

    return v1
.end method

.method public handleLabelSelected(Ljava/lang/String;)V
    .locals 3
    .param p1, "label"    # Ljava/lang/String;

    .prologue
    .line 143
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 144
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "label"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 145
    iget-object v1, p0, Lcom/google/android/gm/BaseLabelsController;->mActivity:Lcom/google/android/gm/LabelsActivityController$ControllableLabelsActivity;

    const/4 v2, -0x1

    invoke-interface {v1, v2, v0}, Lcom/google/android/gm/LabelsActivityController$ControllableLabelsActivity;->setResult(ILandroid/content/Intent;)V

    .line 146
    invoke-virtual {p0, p1}, Lcom/google/android/gm/BaseLabelsController;->showLabelSettings(Ljava/lang/String;)V

    .line 147
    return-void
.end method

.method public handleOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 124
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 132
    :cond_0
    iget-object v1, p0, Lcom/google/android/gm/BaseLabelsController;->mContext:Landroid/content/Context;

    iget-object v0, p0, Lcom/google/android/gm/BaseLabelsController;->mActivity:Lcom/google/android/gm/LabelsActivityController$ControllableLabelsActivity;

    check-cast v0, Lcom/google/android/gm/ApplicationMenuHandler$HelpCallback;

    invoke-static {p1, v1, v0}, Lcom/google/android/gm/ApplicationMenuHandler;->handleApplicationMenu(Landroid/view/MenuItem;Landroid/content/Context;Lcom/google/android/gm/ApplicationMenuHandler$HelpCallback;)Z

    move-result v0

    :goto_0
    return v0

    .line 126
    :pswitch_0
    iget-boolean v0, p0, Lcom/google/android/gm/BaseLabelsController;->mHomeIsBack:Z

    if-eqz v0, :cond_0

    .line 127
    iget-object v0, p0, Lcom/google/android/gm/BaseLabelsController;->mActivity:Lcom/google/android/gm/LabelsActivityController$ControllableLabelsActivity;

    invoke-interface {v0}, Lcom/google/android/gm/LabelsActivityController$ControllableLabelsActivity;->onBackPressed()V

    .line 128
    const/4 v0, 0x1

    goto :goto_0

    .line 124
    nop

    :pswitch_data_0
    .packed-switch 0x102002c
        :pswitch_0
    .end packed-switch
.end method

.method public handlePause()V
    .locals 2

    .prologue
    .line 84
    new-instance v0, Lcom/google/android/gm/BaseLabelsController$1;

    invoke-direct {v0, p0}, Lcom/google/android/gm/BaseLabelsController$1;-><init>(Lcom/google/android/gm/BaseLabelsController;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/google/android/gm/BaseLabelsController$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 99
    return-void
.end method

.method public handlePrepareOptionsMenu(Landroid/view/Menu;)Z
    .locals 1
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 119
    const/4 v0, 0x1

    return v0
.end method

.method public handleSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 138
    const-string v0, "label-list-visible"

    iget-boolean v1, p0, Lcom/google/android/gm/BaseLabelsController;->mLabelListVisbile:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 139
    return-void
.end method

.method public initialize(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 59
    iget-object v1, p0, Lcom/google/android/gm/BaseLabelsController;->mActivity:Lcom/google/android/gm/LabelsActivityController$ControllableLabelsActivity;

    invoke-interface {v1}, Lcom/google/android/gm/LabelsActivityController$ControllableLabelsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    .line 60
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "account_key"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/google/android/gm/BaseLabelsController;->mAccount:Ljava/lang/String;

    .line 61
    const-string v1, "label"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/google/android/gm/BaseLabelsController;->mDefaultLabel:Ljava/lang/String;

    .line 63
    new-instance v1, Lcom/google/android/gm/AccountHelper;

    iget-object v2, p0, Lcom/google/android/gm/BaseLabelsController;->mActivity:Lcom/google/android/gm/LabelsActivityController$ControllableLabelsActivity;

    invoke-direct {v1, v2}, Lcom/google/android/gm/AccountHelper;-><init>(Lcom/google/android/gm/RestrictedActivity;)V

    iget-object v2, p0, Lcom/google/android/gm/BaseLabelsController;->mAccount:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/google/android/gm/AccountHelper;->validateAccountName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/google/android/gm/BaseLabelsController;->mAccount:Ljava/lang/String;

    .line 64
    iget-object v1, p0, Lcom/google/android/gm/BaseLabelsController;->mAccount:Ljava/lang/String;

    if-nez v1, :cond_0

    .line 66
    iget-object v1, p0, Lcom/google/android/gm/BaseLabelsController;->mActivity:Lcom/google/android/gm/LabelsActivityController$ControllableLabelsActivity;

    invoke-interface {v1}, Lcom/google/android/gm/LabelsActivityController$ControllableLabelsActivity;->finish()V

    .line 79
    :goto_0
    return-void

    .line 70
    :cond_0
    iget-object v1, p0, Lcom/google/android/gm/BaseLabelsController;->mActivity:Lcom/google/android/gm/LabelsActivityController$ControllableLabelsActivity;

    invoke-interface {v1}, Lcom/google/android/gm/LabelsActivityController$ControllableLabelsActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    invoke-static {v1}, Lcom/google/android/gm/comm/longshadow/LongShadowUtils;->getContentProviderMailAccess(Landroid/content/ContentResolver;)Lcom/google/android/gm/provider/Gmail;

    move-result-object v1

    iput-object v1, p0, Lcom/google/android/gm/BaseLabelsController;->mGmail:Lcom/google/android/gm/provider/Gmail;

    .line 71
    iget-object v1, p0, Lcom/google/android/gm/BaseLabelsController;->mGmail:Lcom/google/android/gm/provider/Gmail;

    iget-object v2, p0, Lcom/google/android/gm/BaseLabelsController;->mContext:Landroid/content/Context;

    iget-object v3, p0, Lcom/google/android/gm/BaseLabelsController;->mAccount:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gm/provider/Gmail;->getSettings(Landroid/content/Context;Ljava/lang/String;)Lcom/google/android/gm/provider/Gmail$Settings;

    move-result-object v1

    iput-object v1, p0, Lcom/google/android/gm/BaseLabelsController;->mSettings:Lcom/google/android/gm/provider/Gmail$Settings;

    .line 73
    iget-object v1, p0, Lcom/google/android/gm/BaseLabelsController;->mSettings:Lcom/google/android/gm/provider/Gmail$Settings;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/Gmail$Settings;->getLabelsIncluded()Ljava/util/List;

    move-result-object v1

    iput-object v1, p0, Lcom/google/android/gm/BaseLabelsController;->mIncludedLabels:Ljava/util/List;

    .line 74
    iget-object v1, p0, Lcom/google/android/gm/BaseLabelsController;->mSettings:Lcom/google/android/gm/provider/Gmail$Settings;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/Gmail$Settings;->getLabelsPartial()Ljava/util/List;

    move-result-object v1

    iput-object v1, p0, Lcom/google/android/gm/BaseLabelsController;->mPartialLabels:Ljava/util/List;

    .line 75
    iget-object v1, p0, Lcom/google/android/gm/BaseLabelsController;->mSettings:Lcom/google/android/gm/provider/Gmail$Settings;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/Gmail$Settings;->getConversationAgeDays()J

    move-result-wide v1

    long-to-int v1, v1

    iput v1, p0, Lcom/google/android/gm/BaseLabelsController;->mNumOfSyncDays:I

    .line 77
    iget-object v1, p0, Lcom/google/android/gm/BaseLabelsController;->mActionBar:Landroid/app/ActionBar;

    iget-object v2, p0, Lcom/google/android/gm/BaseLabelsController;->mAccount:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/app/ActionBar;->setSubtitle(Ljava/lang/CharSequence;)V

    .line 78
    const/4 v1, 0x0

    invoke-virtual {p0, v1}, Lcom/google/android/gm/BaseLabelsController;->toggleUpButton(Z)V

    goto :goto_0
.end method

.method public notifyChanged()V
    .locals 3

    .prologue
    .line 161
    iget-object v2, p0, Lcom/google/android/gm/BaseLabelsController;->mObservers:Ljava/util/List;

    invoke-static {v2}, Lcom/google/common/collect/Lists;->newArrayList(Ljava/lang/Iterable;)Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gm/LabelSettingsObserver;

    .line 162
    .local v1, "observer":Lcom/google/android/gm/LabelSettingsObserver;
    invoke-interface {v1}, Lcom/google/android/gm/LabelSettingsObserver;->onChanged()V

    goto :goto_0

    .line 164
    .end local v1    # "observer":Lcom/google/android/gm/LabelSettingsObserver;
    :cond_0
    return-void
.end method

.method public registerObserver(Lcom/google/android/gm/LabelSettingsObserver;)V
    .locals 1
    .param p1, "observer"    # Lcom/google/android/gm/LabelSettingsObserver;

    .prologue
    .line 151
    iget-object v0, p0, Lcom/google/android/gm/BaseLabelsController;->mObservers:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 152
    return-void
.end method

.method public setIncludedLabels(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 183
    .local p1, "labels":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/google/android/gm/BaseLabelsController;->mIncludedLabels:Ljava/util/List;

    .line 184
    return-void
.end method

.method public setPartialLabels(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 188
    .local p1, "labels":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/google/android/gm/BaseLabelsController;->mPartialLabels:Ljava/util/List;

    .line 189
    return-void
.end method

.method protected abstract showLabelSettings(Ljava/lang/String;)V
.end method

.method protected toggleUpButton(Z)V
    .locals 1
    .param p1, "enable"    # Z

    .prologue
    .line 195
    iput-boolean p1, p0, Lcom/google/android/gm/BaseLabelsController;->mHomeIsBack:Z

    .line 196
    iget-object v0, p0, Lcom/google/android/gm/BaseLabelsController;->mActivity:Lcom/google/android/gm/LabelsActivityController$ControllableLabelsActivity;

    invoke-interface {v0}, Lcom/google/android/gm/LabelsActivityController$ControllableLabelsActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 197
    invoke-static {}, Lcom/google/android/gm/provider/Gmail;->isRunningICSOrLater()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 198
    iget-object v0, p0, Lcom/google/android/gm/BaseLabelsController;->mActivity:Lcom/google/android/gm/LabelsActivityController$ControllableLabelsActivity;

    invoke-interface {v0}, Lcom/google/android/gm/LabelsActivityController$ControllableLabelsActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/app/ActionBar;->setHomeButtonEnabled(Z)V

    .line 200
    :cond_0
    return-void
.end method

.method public unregisterObserver(Lcom/google/android/gm/LabelSettingsObserver;)V
    .locals 1
    .param p1, "observer"    # Lcom/google/android/gm/LabelSettingsObserver;

    .prologue
    .line 156
    iget-object v0, p0, Lcom/google/android/gm/BaseLabelsController;->mObservers:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 157
    return-void
.end method
