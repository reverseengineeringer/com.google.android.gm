.class public Lcom/google/android/gm/preference/GmailPreferenceActivity;
.super Landroid/preference/PreferenceActivity;
.source "GmailPreferenceActivity.java"

# interfaces
.implements Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;
.implements Lcom/google/android/gm/AccountHelper$AddAccountCallback;
.implements Lcom/google/android/gm/ApplicationMenuHandler$HelpCallback;


# static fields
.field private static sCreatedAccount:Z


# instance fields
.field private mAccounts:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mRestartAccountQuery:Z

.field private mSynced:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 56
    const/4 v0, 0x0

    sput-boolean v0, Lcom/google/android/gm/preference/GmailPreferenceActivity;->sCreatedAccount:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 46
    invoke-direct {p0}, Landroid/preference/PreferenceActivity;-><init>()V

    .line 51
    iput-boolean v0, p0, Lcom/google/android/gm/preference/GmailPreferenceActivity;->mSynced:Z

    .line 53
    iput-boolean v0, p0, Lcom/google/android/gm/preference/GmailPreferenceActivity;->mRestartAccountQuery:Z

    return-void
.end method

.method static synthetic access$000(Lcom/google/android/gm/preference/GmailPreferenceActivity;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/preference/GmailPreferenceActivity;

    .prologue
    .line 46
    iget-object v0, p0, Lcom/google/android/gm/preference/GmailPreferenceActivity;->mAccounts:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$002(Lcom/google/android/gm/preference/GmailPreferenceActivity;Ljava/util/List;)Ljava/util/List;
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/preference/GmailPreferenceActivity;
    .param p1, "x1"    # Ljava/util/List;

    .prologue
    .line 46
    iput-object p1, p0, Lcom/google/android/gm/preference/GmailPreferenceActivity;->mAccounts:Ljava/util/List;

    return-object p1
.end method

.method private addAccountHeaders(Ljava/util/List;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Landroid/preference/PreferenceActivity$Header;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "target":Ljava/util/List;, "Ljava/util/List<Landroid/preference/PreferenceActivity$Header;>;"
    const/4 v6, 0x1

    .line 253
    invoke-static {}, Lcom/google/android/gm/persistence/Persistence;->getInstance()Lcom/google/android/gm/persistence/Persistence;

    move-result-object v4

    const/4 v5, 0x0

    invoke-virtual {v4, p0, v5}, Lcom/google/android/gm/persistence/Persistence;->getCachedConfiguredGoogleAccounts(Landroid/content/Context;Z)Ljava/util/List;

    move-result-object v4

    iput-object v4, p0, Lcom/google/android/gm/preference/GmailPreferenceActivity;->mAccounts:Ljava/util/List;

    .line 255
    iget-boolean v4, p0, Lcom/google/android/gm/preference/GmailPreferenceActivity;->mSynced:Z

    if-nez v4, :cond_1

    .line 256
    invoke-direct {p0}, Lcom/google/android/gm/preference/GmailPreferenceActivity;->asyncInitAccounts()V

    .line 257
    iput-boolean v6, p0, Lcom/google/android/gm/preference/GmailPreferenceActivity;->mSynced:Z

    .line 272
    :cond_0
    return-void

    .line 259
    :cond_1
    iget-object v4, p0, Lcom/google/android/gm/preference/GmailPreferenceActivity;->mAccounts:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 260
    .local v0, "account":Ljava/lang/String;
    new-instance v2, Landroid/preference/PreferenceActivity$Header;

    invoke-direct {v2}, Landroid/preference/PreferenceActivity$Header;-><init>()V

    .line 263
    .local v2, "accountHeader":Landroid/preference/PreferenceActivity$Header;
    iput-object v0, v2, Landroid/preference/PreferenceActivity$Header;->title:Ljava/lang/CharSequence;

    .line 264
    const-string v4, "com.google.android.gm.preference.AccountPreferenceFragment"

    iput-object v4, v2, Landroid/preference/PreferenceActivity$Header;->fragment:Ljava/lang/String;

    .line 266
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 267
    .local v1, "accountBundle":Landroid/os/Bundle;
    const-string v4, "account"

    invoke-virtual {v1, v4, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 268
    iput-object v1, v2, Landroid/preference/PreferenceActivity$Header;->fragmentArguments:Landroid/os/Bundle;

    .line 269
    invoke-interface {p1, v6, v2}, Ljava/util/List;->add(ILjava/lang/Object;)V

    goto :goto_0
.end method

.method private asyncInitAccounts()V
    .locals 1

    .prologue
    .line 279
    new-instance v0, Lcom/google/android/gm/preference/GmailPreferenceActivity$1;

    invoke-direct {v0, p0}, Lcom/google/android/gm/preference/GmailPreferenceActivity$1;-><init>(Lcom/google/android/gm/preference/GmailPreferenceActivity;)V

    .line 300
    .local v0, "callback":Landroid/accounts/AccountManagerCallback;, "Landroid/accounts/AccountManagerCallback<[Landroid/accounts/Account;>;"
    invoke-static {p0, v0}, Lcom/google/android/gm/AccountHelper;->getSyncingAccounts(Landroid/content/Context;Landroid/accounts/AccountManagerCallback;)V

    .line 301
    return-void
.end method

.method private final getInitialHeader(JLjava/util/List;)Landroid/preference/PreferenceActivity$Header;
    .locals 4
    .param p1, "fragmentId"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J",
            "Ljava/util/List",
            "<",
            "Landroid/preference/PreferenceActivity$Header;",
            ">;)",
            "Landroid/preference/PreferenceActivity$Header;"
        }
    .end annotation

    .prologue
    .line 178
    .local p3, "target":Ljava/util/List;, "Ljava/util/List<Landroid/preference/PreferenceActivity$Header;>;"
    invoke-interface {p3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/preference/PreferenceActivity$Header;

    .line 179
    .local v0, "header":Landroid/preference/PreferenceActivity$Header;
    iget-wide v2, v0, Landroid/preference/PreferenceActivity$Header;->id:J

    cmp-long v2, v2, p1

    if-nez v2, :cond_0

    iget-object v2, v0, Landroid/preference/PreferenceActivity$Header;->fragment:Ljava/lang/String;

    if-eqz v2, :cond_0

    .line 184
    .end local v0    # "header":Landroid/preference/PreferenceActivity$Header;
    :goto_0
    return-object v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private launchLabelSettings(Landroid/content/Intent;)V
    .locals 4

    .prologue
    .line 124
    const-string v0, "extra_folder"

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Folder;

    .line 126
    const-string v1, "extra_account"

    invoke-virtual {p1, v1}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Lcom/android/mail/providers/Account;

    .line 129
    iget-object v1, v1, Landroid/accounts/Account;->name:Ljava/lang/String;

    .line 130
    iget-object v0, v0, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    invoke-virtual {v0}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v0

    .line 132
    new-instance v2, Landroid/content/Intent;

    const-class v3, Lcom/google/android/gm/LabelsActivity;

    invoke-direct {v2, p0, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 133
    const-string v3, "account_key"

    invoke-virtual {v2, v3, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 134
    const-string v1, "label"

    invoke-virtual {v2, v1, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 135
    invoke-virtual {p0, v2}, Lcom/google/android/gm/preference/GmailPreferenceActivity;->startActivity(Landroid/content/Intent;)V

    .line 136
    invoke-virtual {p0}, Lcom/google/android/gm/preference/GmailPreferenceActivity;->finish()V

    .line 137
    return-void
.end method

.method private launchManageLabels(Landroid/content/Intent;)V
    .locals 3

    .prologue
    .line 140
    const-string v0, "extra_account"

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Account;

    .line 143
    iget-object v0, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    .line 145
    new-instance v1, Landroid/content/Intent;

    const-class v2, Lcom/google/android/gm/LabelsActivity;

    invoke-direct {v1, p0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 146
    const-string v2, "account_key"

    invoke-virtual {v1, v2, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 147
    invoke-virtual {p0, v1}, Lcom/google/android/gm/preference/GmailPreferenceActivity;->startActivity(Landroid/content/Intent;)V

    .line 148
    invoke-virtual {p0}, Lcom/google/android/gm/preference/GmailPreferenceActivity;->finish()V

    .line 149
    return-void
.end method

.method private loadHeaders(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Landroid/preference/PreferenceActivity$Header;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 220
    .local p1, "target":Ljava/util/List;, "Ljava/util/List<Landroid/preference/PreferenceActivity$Header;>;"
    const v0, 0x7f070005

    invoke-virtual {p0, v0, p1}, Lcom/google/android/gm/preference/GmailPreferenceActivity;->loadHeadersFromResource(ILjava/util/List;)V

    .line 222
    invoke-direct {p0, p1}, Lcom/google/android/gm/preference/GmailPreferenceActivity;->addAccountHeaders(Ljava/util/List;)V

    .line 227
    return-void
.end method

.method private loadInitialHeader(J)V
    .locals 7
    .param p1, "initialFragmentId"    # J

    .prologue
    .line 152
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v0

    .line 153
    .local v0, "headerList":Ljava/util/List;, "Ljava/util/List<Landroid/preference/PreferenceActivity$Header;>;"
    invoke-direct {p0, v0}, Lcom/google/android/gm/preference/GmailPreferenceActivity;->loadHeaders(Ljava/util/List;)V

    .line 155
    invoke-direct {p0, p1, p2, v0}, Lcom/google/android/gm/preference/GmailPreferenceActivity;->getInitialHeader(JLjava/util/List;)Landroid/preference/PreferenceActivity$Header;

    move-result-object v1

    .line 156
    .local v1, "initialHeader":Landroid/preference/PreferenceActivity$Header;
    if-eqz v1, :cond_0

    .line 160
    invoke-virtual {p0}, Lcom/google/android/gm/preference/GmailPreferenceActivity;->isMultiPane()Z

    move-result v3

    if-nez v3, :cond_1

    .line 163
    iget-object v3, v1, Landroid/preference/PreferenceActivity$Header;->fragment:Ljava/lang/String;

    new-instance v4, Landroid/os/Bundle;

    invoke-direct {v4}, Landroid/os/Bundle;-><init>()V

    iget v5, v1, Landroid/preference/PreferenceActivity$Header;->titleRes:I

    const/4 v6, 0x0

    invoke-virtual {p0, v3, v4, v5, v6}, Lcom/google/android/gm/preference/GmailPreferenceActivity;->onBuildStartFragmentIntent(Ljava/lang/String;Landroid/os/Bundle;II)Landroid/content/Intent;

    move-result-object v2

    .line 167
    .local v2, "preferenceIntent":Landroid/content/Intent;
    invoke-virtual {p0, v2}, Lcom/google/android/gm/preference/GmailPreferenceActivity;->startActivity(Landroid/content/Intent;)V

    .line 168
    invoke-virtual {p0}, Lcom/google/android/gm/preference/GmailPreferenceActivity;->finish()V

    .line 175
    .end local v2    # "preferenceIntent":Landroid/content/Intent;
    :cond_0
    :goto_0
    return-void

    .line 172
    :cond_1
    invoke-virtual {p0, v1}, Lcom/google/android/gm/preference/GmailPreferenceActivity;->switchToHeader(Landroid/preference/PreferenceActivity$Header;)V

    goto :goto_0
.end method


# virtual methods
.method public getHelpContext()Ljava/lang/String;
    .locals 1

    .prologue
    .line 309
    const-string v0, "gm_settings"

    return-object v0
.end method

.method public onBuildHeaders(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Landroid/preference/PreferenceActivity$Header;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 216
    .local p1, "target":Ljava/util/List;, "Ljava/util/List<Landroid/preference/PreferenceActivity$Header;>;"
    invoke-direct {p0, p1}, Lcom/google/android/gm/preference/GmailPreferenceActivity;->loadHeaders(Ljava/util/List;)V

    .line 217
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 14
    .param p1, "icicle"    # Landroid/os/Bundle;

    .prologue
    const-wide/16 v12, -0x1

    const/4 v11, 0x4

    .line 60
    invoke-super {p0, p1}, Landroid/preference/PreferenceActivity;->onCreate(Landroid/os/Bundle;)V

    .line 62
    invoke-virtual {p0}, Lcom/google/android/gm/preference/GmailPreferenceActivity;->getIntent()Landroid/content/Intent;

    move-result-object v5

    .line 63
    .local v5, "intent":Landroid/content/Intent;
    const-wide/16 v3, -0x1

    .line 64
    .local v3, "initialFragmentId":J
    const-string v9, "initial_fragment_id"

    invoke-virtual {v5, v9}, Landroid/content/Intent;->hasExtra(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_4

    .line 65
    const-string v9, "initial_fragment_id"

    invoke-virtual {v5, v9, v12, v13}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v3

    .line 69
    const-string v9, "initial_fragment_id"

    invoke-virtual {v5, v9}, Landroid/content/Intent;->removeExtra(Ljava/lang/String;)V

    .line 87
    :cond_0
    :goto_0
    cmp-long v9, v3, v12

    if-eqz v9, :cond_2

    .line 88
    const/4 v6, 0x1

    .line 90
    .local v6, "loadInitialHeader":Z
    const-wide/32 v9, 0x7f10011b

    cmp-long v9, v3, v9

    if-nez v9, :cond_1

    .line 91
    const-string v9, "reporting_problem"

    const/4 v10, 0x0

    invoke-virtual {v5, v9, v10}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v8

    .line 93
    .local v8, "reportingProblem":Z
    if-eqz v8, :cond_1

    .line 95
    invoke-static {p0}, Lcom/google/android/gm/Utils;->launchGoogleFeedback(Landroid/content/Context;)V

    .line 96
    const/4 v6, 0x0

    .line 97
    invoke-virtual {p0}, Lcom/google/android/gm/preference/GmailPreferenceActivity;->finish()V

    .line 100
    .end local v8    # "reportingProblem":Z
    :cond_1
    if-eqz v6, :cond_2

    .line 101
    invoke-direct {p0, v3, v4}, Lcom/google/android/gm/preference/GmailPreferenceActivity;->loadInitialHeader(J)V

    .line 106
    .end local v6    # "loadInitialHeader":Z
    :cond_2
    invoke-virtual {p0}, Lcom/google/android/gm/preference/GmailPreferenceActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 107
    .local v0, "actionBar":Landroid/app/ActionBar;
    if-eqz v0, :cond_3

    .line 108
    invoke-virtual {v0, v11, v11}, Landroid/app/ActionBar;->setDisplayOptions(II)V

    .line 112
    :cond_3
    invoke-static {p0}, Landroid/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v7

    .line 113
    .local v7, "prefs":Landroid/content/SharedPreferences;
    invoke-interface {v7, p0}, Landroid/content/SharedPreferences;->registerOnSharedPreferenceChangeListener(Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;)V

    .line 114
    .end local v0    # "actionBar":Landroid/app/ActionBar;
    .end local v7    # "prefs":Landroid/content/SharedPreferences;
    :goto_1
    return-void

    .line 70
    :cond_4
    const-string v9, "extra_folder"

    invoke-virtual {v5, v9}, Landroid/content/Intent;->hasExtra(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_5

    .line 71
    invoke-direct {p0, v5}, Lcom/google/android/gm/preference/GmailPreferenceActivity;->launchLabelSettings(Landroid/content/Intent;)V

    goto :goto_1

    .line 73
    :cond_5
    const-string v9, "extra_manage_folders"

    invoke-virtual {v5, v9}, Landroid/content/Intent;->hasExtra(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_6

    .line 75
    invoke-direct {p0, v5}, Lcom/google/android/gm/preference/GmailPreferenceActivity;->launchManageLabels(Landroid/content/Intent;)V

    goto :goto_0

    .line 77
    :cond_6
    invoke-virtual {v5}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v1

    .line 78
    .local v1, "dataUri":Landroid/net/Uri;
    if-eqz v1, :cond_0

    .line 79
    const-string v9, "preference_fragment_id"

    invoke-virtual {v1, v9}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 81
    .local v2, "fragmentIdStr":Ljava/lang/String;
    if-eqz v2, :cond_0

    .line 82
    invoke-static {v2}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v3

    goto :goto_0
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 2
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 231
    invoke-virtual {p0}, Lcom/google/android/gm/preference/GmailPreferenceActivity;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v0

    .line 232
    .local v0, "inflater":Landroid/view/MenuInflater;
    const v1, 0x7f12000d

    invoke-virtual {v0, v1, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 233
    const/4 v1, 0x1

    return v1
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    const/4 v0, 0x1

    .line 238
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    sparse-switch v1, :sswitch_data_0

    .line 249
    invoke-static {p1, p0, p0}, Lcom/google/android/gm/ApplicationMenuHandler;->handleApplicationMenu(Landroid/view/MenuItem;Landroid/content/Context;Lcom/google/android/gm/ApplicationMenuHandler$HelpCallback;)Z

    move-result v0

    :goto_0
    return v0

    .line 240
    :sswitch_0
    invoke-static {p0, p0}, Lcom/google/android/gm/AccountHelper;->showAddAccount(Landroid/app/Activity;Lcom/google/android/gm/AccountHelper$AddAccountCallback;)V

    goto :goto_0

    .line 246
    :sswitch_1
    invoke-virtual {p0}, Lcom/google/android/gm/preference/GmailPreferenceActivity;->finish()V

    goto :goto_0

    .line 238
    nop

    :sswitch_data_0
    .sparse-switch
        0x102002c -> :sswitch_1
        0x7f10013f -> :sswitch_0
    .end sparse-switch
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 189
    invoke-super {p0}, Landroid/preference/PreferenceActivity;->onPause()V

    .line 192
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/gm/preference/GmailPreferenceActivity;->mRestartAccountQuery:Z

    .line 193
    return-void
.end method

.method public onResult(Landroid/accounts/Account;)V
    .locals 1
    .param p1, "account"    # Landroid/accounts/Account;

    .prologue
    .line 314
    if-eqz p1, :cond_0

    .line 318
    const/4 v0, 0x1

    sput-boolean v0, Lcom/google/android/gm/preference/GmailPreferenceActivity;->sCreatedAccount:Z

    .line 320
    :cond_0
    return-void
.end method

.method public onResume()V
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 197
    invoke-super {p0}, Landroid/preference/PreferenceActivity;->onResume()V

    .line 201
    sget-boolean v2, Lcom/google/android/gm/preference/GmailPreferenceActivity;->sCreatedAccount:Z

    if-nez v2, :cond_0

    iget-boolean v2, p0, Lcom/google/android/gm/preference/GmailPreferenceActivity;->mRestartAccountQuery:Z

    if-eqz v2, :cond_2

    :cond_0
    const/4 v0, 0x1

    .line 202
    .local v0, "requeryAccountManager":Z
    :goto_0
    sput-boolean v1, Lcom/google/android/gm/preference/GmailPreferenceActivity;->sCreatedAccount:Z

    .line 203
    if-eqz v0, :cond_1

    .line 205
    invoke-direct {p0}, Lcom/google/android/gm/preference/GmailPreferenceActivity;->asyncInitAccounts()V

    .line 207
    :cond_1
    return-void

    .end local v0    # "requeryAccountManager":Z
    :cond_2
    move v0, v1

    .line 201
    goto :goto_0
.end method

.method public onSharedPreferenceChanged(Landroid/content/SharedPreferences;Ljava/lang/String;)V
    .locals 0
    .param p1, "prefs"    # Landroid/content/SharedPreferences;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 327
    invoke-static {p0}, Lcom/google/android/gm/provider/UiProvider;->notifyAccountListChanged(Landroid/content/Context;)V

    .line 328
    return-void
.end method

.method public onStop()V
    .locals 1

    .prologue
    .line 118
    invoke-super {p0}, Landroid/preference/PreferenceActivity;->onStop()V

    .line 119
    invoke-static {p0}, Landroid/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 120
    .local v0, "prefs":Landroid/content/SharedPreferences;
    invoke-interface {v0, p0}, Landroid/content/SharedPreferences;->unregisterOnSharedPreferenceChangeListener(Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;)V

    .line 121
    return-void
.end method
