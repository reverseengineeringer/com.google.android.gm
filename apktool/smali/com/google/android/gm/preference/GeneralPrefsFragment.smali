.class public final Lcom/google/android/gm/preference/GeneralPrefsFragment;
.super Lcom/google/android/gm/preference/GmailPreferenceFragment;
.source "GeneralPrefsFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# instance fields
.field private mClearDisplayImagesDialog:Landroid/app/AlertDialog;

.field private mClearSearchHistoryDialog:Landroid/app/AlertDialog;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Lcom/google/android/gm/preference/GmailPreferenceFragment;-><init>()V

    return-void
.end method

.method private clearDisplayImages()V
    .locals 2

    .prologue
    .line 158
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-virtual {p0}, Lcom/google/android/gm/preference/GeneralPrefsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    const v1, 0x7f0c017f

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(I)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const v1, 0x1010355

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setIconAttribute(I)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const v1, 0x7f0c00d2

    invoke-virtual {v0, v1, p0}, Landroid/app/AlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const v1, 0x7f0c00d3

    invoke-virtual {v0, v1, p0}, Landroid/app/AlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/preference/GeneralPrefsFragment;->mClearDisplayImagesDialog:Landroid/app/AlertDialog;

    .line 164
    return-void
.end method

.method private clearSearchHistory()V
    .locals 2

    .prologue
    .line 167
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-virtual {p0}, Lcom/google/android/gm/preference/GeneralPrefsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    const v1, 0x7f0c017c

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(I)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const v1, 0x7f0c017b

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(I)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const v1, 0x1010355

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setIconAttribute(I)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const v1, 0x7f0c00d2

    invoke-virtual {v0, v1, p0}, Landroid/app/AlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const v1, 0x7f0c00d3

    invoke-virtual {v0, v1, p0}, Landroid/app/AlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/preference/GeneralPrefsFragment;->mClearSearchHistoryDialog:Landroid/app/AlertDialog;

    .line 174
    return-void
.end method

.method private initializeConfirmActions(Lcom/google/android/gm/persistence/Persistence;Landroid/content/Context;)V
    .locals 3
    .param p1, "persistence"    # Lcom/google/android/gm/persistence/Persistence;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 273
    invoke-virtual {p1, p2}, Lcom/google/android/gm/persistence/Persistence;->getConfirmActions(Landroid/content/Context;)Ljava/util/Set;

    move-result-object v0

    .line 275
    .local v0, "confirmActions":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    const-string v1, "confirm-actions-delete"

    const-string v2, "delete"

    invoke-interface {v0, v2}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    invoke-virtual {p0, v1, v2}, Lcom/google/android/gm/preference/GeneralPrefsFragment;->initializeCheckBox(Ljava/lang/String;Z)V

    .line 276
    const-string v1, "confirm-actions-archive"

    const-string v2, "archive"

    invoke-interface {v0, v2}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    invoke-virtual {p0, v1, v2}, Lcom/google/android/gm/preference/GeneralPrefsFragment;->initializeCheckBox(Ljava/lang/String;Z)V

    .line 277
    const-string v1, "confirm-actions-send"

    const-string v2, "send"

    invoke-interface {v0, v2}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    invoke-virtual {p0, v1, v2}, Lcom/google/android/gm/preference/GeneralPrefsFragment;->initializeCheckBox(Ljava/lang/String;Z)V

    .line 278
    return-void
.end method

.method private varargs listenForPreferenceChange([Ljava/lang/String;)V
    .locals 5
    .param p1, "keys"    # [Ljava/lang/String;

    .prologue
    .line 263
    move-object v0, p1

    .local v0, "arr$":[Ljava/lang/String;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v3, :cond_1

    aget-object v2, v0, v1

    .line 264
    .local v2, "key":Ljava/lang/String;
    invoke-virtual {p0, v2}, Lcom/google/android/gm/preference/GeneralPrefsFragment;->findPreference(Ljava/lang/CharSequence;)Landroid/preference/Preference;

    move-result-object v4

    .line 265
    .local v4, "p":Landroid/preference/Preference;
    if-eqz v4, :cond_0

    .line 266
    invoke-virtual {v4, p0}, Landroid/preference/Preference;->setOnPreferenceChangeListener(Landroid/preference/Preference$OnPreferenceChangeListener;)V

    .line 263
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 269
    .end local v2    # "key":Ljava/lang/String;
    .end local v4    # "p":Landroid/preference/Preference;
    :cond_1
    return-void
.end method

.method private updateConfirmActions(Ljava/lang/String;Ljava/lang/Boolean;)V
    .locals 5
    .param p1, "preference"    # Ljava/lang/String;
    .param p2, "newValue"    # Ljava/lang/Boolean;

    .prologue
    .line 281
    invoke-virtual {p0}, Lcom/google/android/gm/preference/GeneralPrefsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 282
    .local v0, "activity":Landroid/app/Activity;
    invoke-static {}, Lcom/google/android/gm/persistence/Persistence;->getInstance()Lcom/google/android/gm/persistence/Persistence;

    move-result-object v3

    .line 283
    .local v3, "persistence":Lcom/google/android/gm/persistence/Persistence;
    invoke-virtual {v3, v0}, Lcom/google/android/gm/persistence/Persistence;->getConfirmActions(Landroid/content/Context;)Ljava/util/Set;

    move-result-object v1

    .line 285
    .local v1, "currentConfirmActions":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-virtual {p2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 286
    const/4 v2, 0x0

    .line 288
    .local v2, "hasAction":Z
    const-string v4, "none"

    invoke-interface {v1, v4}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 291
    invoke-interface {v1, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 302
    .end local v2    # "hasAction":Z
    :cond_0
    :goto_0
    invoke-virtual {v3, v0, v1}, Lcom/google/android/gm/persistence/Persistence;->setConfirmActions(Landroid/content/Context;Ljava/util/Set;)V

    .line 303
    return-void

    .line 296
    :cond_1
    invoke-interface {v1, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 298
    invoke-interface {v1}, Ljava/util/Set;->size()I

    move-result v4

    if-nez v4, :cond_0

    .line 299
    const-string v4, "none"

    invoke-interface {v1, v4}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 6
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    const/4 v5, 0x0

    const/4 v3, -0x1

    const/4 v4, 0x0

    .line 179
    iget-object v2, p0, Lcom/google/android/gm/preference/GeneralPrefsFragment;->mClearSearchHistoryDialog:Landroid/app/AlertDialog;

    invoke-virtual {p1, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 180
    if-ne p2, v3, :cond_0

    .line 181
    invoke-virtual {p0}, Lcom/google/android/gm/preference/GeneralPrefsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 184
    .local v0, "context":Landroid/content/Context;
    new-instance v2, Lcom/google/android/gm/preference/GeneralPrefsFragment$1;

    invoke-direct {v2, p0, v0}, Lcom/google/android/gm/preference/GeneralPrefsFragment$1;-><init>(Lcom/google/android/gm/preference/GeneralPrefsFragment;Landroid/content/Context;)V

    new-array v3, v4, [Ljava/lang/Void;

    invoke-virtual {v2, v3}, Lcom/google/android/gm/preference/GeneralPrefsFragment$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 196
    invoke-virtual {p0}, Lcom/google/android/gm/preference/GeneralPrefsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    const v3, 0x7f0c01db

    invoke-static {v2, v3, v4}, Landroid/widget/Toast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/Toast;->show()V

    .line 210
    .end local v0    # "context":Landroid/content/Context;
    :cond_0
    :goto_0
    return-void

    .line 199
    :cond_1
    iget-object v2, p0, Lcom/google/android/gm/preference/GeneralPrefsFragment;->mClearDisplayImagesDialog:Landroid/app/AlertDialog;

    invoke-virtual {p1, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 200
    if-ne p2, v3, :cond_0

    .line 201
    invoke-static {}, Lcom/google/android/gm/persistence/Persistence;->getInstance()Lcom/google/android/gm/persistence/Persistence;

    move-result-object v1

    .line 202
    .local v1, "persistence":Lcom/google/android/gm/persistence/Persistence;
    invoke-virtual {p0}, Lcom/google/android/gm/preference/GeneralPrefsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 203
    .restart local v0    # "context":Landroid/content/Context;
    const-string v2, "display_images"

    const-string v3, ""

    invoke-virtual {v1, v0, v5, v2, v3}, Lcom/google/android/gm/persistence/Persistence;->setString(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 204
    const-string v2, "display_sender_images_patterns_set"

    new-instance v3, Ljava/util/HashSet;

    invoke-direct {v3}, Ljava/util/HashSet;-><init>()V

    invoke-virtual {v1, v0, v5, v2, v3}, Lcom/google/android/gm/persistence/Persistence;->setStringSet(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;)V

    .line 206
    invoke-virtual {p0}, Lcom/google/android/gm/preference/GeneralPrefsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    const v3, 0x7f0c01dc

    invoke-static {v2, v3, v4}, Landroid/widget/Toast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/Toast;->show()V

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 65
    invoke-super {p0, p1}, Lcom/google/android/gm/preference/GmailPreferenceFragment;->onCreate(Landroid/os/Bundle;)V

    .line 70
    invoke-virtual {p0}, Lcom/google/android/gm/preference/GeneralPrefsFragment;->getPreferenceManager()Landroid/preference/PreferenceManager;

    move-result-object v1

    const-string v2, "Gmail"

    invoke-virtual {v1, v2}, Landroid/preference/PreferenceManager;->setSharedPreferencesName(Ljava/lang/String;)V

    .line 72
    const v1, 0x7f070003

    invoke-virtual {p0, v1}, Lcom/google/android/gm/preference/GeneralPrefsFragment;->addPreferencesFromResource(I)V

    .line 75
    invoke-virtual {p0}, Lcom/google/android/gm/preference/GeneralPrefsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-static {v1}, Lcom/android/mail/utils/Utils;->useTabletUI(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 76
    invoke-virtual {p0}, Lcom/google/android/gm/preference/GeneralPrefsFragment;->getPreferenceScreen()Landroid/preference/PreferenceScreen;

    move-result-object v0

    .line 77
    .local v0, "ps":Landroid/preference/PreferenceScreen;
    const-string v1, "snap-headers"

    invoke-virtual {p0, v1}, Lcom/google/android/gm/preference/GeneralPrefsFragment;->findPreference(Ljava/lang/CharSequence;)Landroid/preference/Preference;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/preference/PreferenceScreen;->removePreference(Landroid/preference/Preference;)Z

    .line 78
    const-string v1, "action-strip-action-reply-all"

    invoke-virtual {p0, v1}, Lcom/google/android/gm/preference/GeneralPrefsFragment;->findPreference(Ljava/lang/CharSequence;)Landroid/preference/Preference;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/preference/PreferenceScreen;->removePreference(Landroid/preference/Preference;)Z

    .line 79
    const-string v1, "hide-checkboxes"

    invoke-virtual {p0, v1}, Lcom/google/android/gm/preference/GeneralPrefsFragment;->findPreference(Ljava/lang/CharSequence;)Landroid/preference/Preference;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/preference/PreferenceScreen;->removePreference(Landroid/preference/Preference;)Z

    .line 83
    .end local v0    # "ps":Landroid/preference/PreferenceScreen;
    :cond_0
    invoke-virtual {p0}, Lcom/google/android/gm/preference/GeneralPrefsFragment;->getPreferenceScreen()Landroid/preference/PreferenceScreen;

    move-result-object v1

    const-string v2, "message-text-key"

    invoke-virtual {p0, v2}, Lcom/google/android/gm/preference/GeneralPrefsFragment;->findPreference(Ljava/lang/CharSequence;)Landroid/preference/Preference;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/preference/PreferenceScreen;->removePreference(Landroid/preference/Preference;)Z

    .line 85
    return-void
.end method

.method public onPreferenceChange(Landroid/preference/Preference;Ljava/lang/Object;)Z
    .locals 6
    .param p1, "preference"    # Landroid/preference/Preference;
    .param p2, "newValue"    # Ljava/lang/Object;

    .prologue
    const/4 v5, 0x0

    .line 89
    invoke-virtual {p0}, Lcom/google/android/gm/preference/GeneralPrefsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v4

    if-nez v4, :cond_0

    .line 92
    const/4 v3, 0x0

    .line 128
    .end local p2    # "newValue":Ljava/lang/Object;
    :goto_0
    return v3

    .line 95
    .restart local p2    # "newValue":Ljava/lang/Object;
    :cond_0
    const/4 v3, 0x1

    .line 96
    .local v3, "result":Z
    invoke-virtual {p1}, Landroid/preference/Preference;->getContext()Landroid/content/Context;

    move-result-object v0

    .line 97
    .local v0, "context":Landroid/content/Context;
    invoke-static {}, Lcom/google/android/gm/persistence/Persistence;->getInstance()Lcom/google/android/gm/persistence/Persistence;

    move-result-object v2

    .line 98
    .local v2, "persistence":Lcom/google/android/gm/persistence/Persistence;
    invoke-virtual {p1}, Landroid/preference/Preference;->getKey()Ljava/lang/String;

    move-result-object v1

    .line 101
    .local v1, "key":Ljava/lang/String;
    const-string v4, "confirm-actions-delete"

    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 102
    const-string v4, "delete"

    check-cast p2, Ljava/lang/Boolean;

    .end local p2    # "newValue":Ljava/lang/Object;
    invoke-direct {p0, v4, p2}, Lcom/google/android/gm/preference/GeneralPrefsFragment;->updateConfirmActions(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 127
    :goto_1
    invoke-virtual {p0}, Lcom/google/android/gm/preference/GeneralPrefsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v4

    invoke-static {v4}, Lcom/google/android/gm/provider/UiProvider;->notifyAccountListChanged(Landroid/content/Context;)V

    goto :goto_0

    .line 103
    .restart local p2    # "newValue":Ljava/lang/Object;
    :cond_1
    const-string v4, "confirm-actions-archive"

    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 104
    const-string v4, "archive"

    check-cast p2, Ljava/lang/Boolean;

    .end local p2    # "newValue":Ljava/lang/Object;
    invoke-direct {p0, v4, p2}, Lcom/google/android/gm/preference/GeneralPrefsFragment;->updateConfirmActions(Ljava/lang/String;Ljava/lang/Boolean;)V

    goto :goto_1

    .line 105
    .restart local p2    # "newValue":Ljava/lang/Object;
    :cond_2
    const-string v4, "confirm-actions-send"

    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 106
    const-string v4, "send"

    check-cast p2, Ljava/lang/Boolean;

    .end local p2    # "newValue":Ljava/lang/Object;
    invoke-direct {p0, v4, p2}, Lcom/google/android/gm/preference/GeneralPrefsFragment;->updateConfirmActions(Ljava/lang/String;Ljava/lang/Boolean;)V

    goto :goto_1

    .line 107
    .restart local p2    # "newValue":Ljava/lang/Object;
    :cond_3
    const-string v4, "swipe-key"

    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 108
    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v0, v4}, Lcom/google/android/gm/persistence/Persistence;->setSwipe(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_1

    .line 109
    :cond_4
    const-string v4, "action-strip-action-reply-all"

    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_5

    .line 110
    check-cast p2, Ljava/lang/Boolean;

    .end local p2    # "newValue":Ljava/lang/Object;
    invoke-virtual {p2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    invoke-virtual {v2, v0, v4}, Lcom/google/android/gm/persistence/Persistence;->setActionStripActionReplyAll(Landroid/content/Context;Z)V

    goto :goto_1

    .line 111
    .restart local p2    # "newValue":Ljava/lang/Object;
    :cond_5
    const-string v4, "conversation-mode"

    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_6

    .line 112
    check-cast p2, Ljava/lang/Boolean;

    .end local p2    # "newValue":Ljava/lang/Object;
    invoke-virtual {p2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    invoke-virtual {v2, v0, v4}, Lcom/google/android/gm/persistence/Persistence;->setConversationOverviewMode(Landroid/content/Context;Z)V

    goto :goto_1

    .line 113
    .restart local p2    # "newValue":Ljava/lang/Object;
    :cond_6
    const-string v4, "auto-advance-key"

    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_7

    .line 114
    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v0, v4}, Lcom/google/android/gm/persistence/Persistence;->setAutoAdvanceMode(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_1

    .line 115
    :cond_7
    const-string v4, "message-text-key"

    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_8

    .line 116
    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v0, v4}, Lcom/google/android/gm/persistence/Persistence;->setMessageTextSize(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_1

    .line 117
    :cond_8
    const-string v4, "hide-checkboxes"

    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_9

    .line 118
    check-cast p2, Ljava/lang/Boolean;

    .end local p2    # "newValue":Ljava/lang/Object;
    invoke-virtual {v2, v0, v5, v1, p2}, Lcom/google/android/gm/persistence/Persistence;->setBoolean(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V

    goto/16 :goto_1

    .line 119
    .restart local p2    # "newValue":Ljava/lang/Object;
    :cond_9
    const-string v4, "snap-headers"

    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_a

    .line 120
    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v0, v4}, Lcom/google/android/gm/persistence/Persistence;->setSnapHeaderMode(Landroid/content/Context;Ljava/lang/String;)V

    goto/16 :goto_1

    .line 121
    :cond_a
    const-string v4, "display_images"

    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_b

    .line 122
    check-cast p2, Ljava/lang/Boolean;

    .end local p2    # "newValue":Ljava/lang/Object;
    invoke-virtual {v2, v0, v5, v1, p2}, Lcom/google/android/gm/persistence/Persistence;->setBoolean(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V

    goto/16 :goto_1

    .line 124
    .restart local p2    # "newValue":Ljava/lang/Object;
    :cond_b
    const/4 v3, 0x0

    goto/16 :goto_1
.end method

.method public onPreferenceTreeClick(Landroid/preference/PreferenceScreen;Landroid/preference/Preference;)Z
    .locals 3
    .param p1, "preferenceScreen"    # Landroid/preference/PreferenceScreen;
    .param p2, "preference"    # Landroid/preference/Preference;

    .prologue
    const/4 v1, 0x0

    .line 133
    invoke-virtual {p0}, Lcom/google/android/gm/preference/GeneralPrefsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    if-nez v2, :cond_1

    .line 154
    :cond_0
    :goto_0
    return v1

    .line 139
    :cond_1
    invoke-virtual {p2}, Landroid/preference/Preference;->getKey()Ljava/lang/String;

    move-result-object v0

    .line 140
    .local v0, "key":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 144
    const/4 v1, 0x1

    .line 146
    .local v1, "result":Z
    const-string v2, "clear-search-history"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 147
    invoke-direct {p0}, Lcom/google/android/gm/preference/GeneralPrefsFragment;->clearSearchHistory()V

    goto :goto_0

    .line 148
    :cond_2
    const-string v2, "clear-display-images-whitelist"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 149
    invoke-direct {p0}, Lcom/google/android/gm/preference/GeneralPrefsFragment;->clearDisplayImages()V

    goto :goto_0

    .line 151
    :cond_3
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public onResume()V
    .locals 6

    .prologue
    .line 225
    invoke-super {p0}, Lcom/google/android/gm/preference/GmailPreferenceFragment;->onResume()V

    .line 226
    invoke-virtual {p0}, Lcom/google/android/gm/preference/GeneralPrefsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 233
    .local v0, "context":Landroid/content/Context;
    invoke-static {}, Lcom/google/android/gm/persistence/Persistence;->getInstance()Lcom/google/android/gm/persistence/Persistence;

    move-result-object v1

    .line 234
    .local v1, "persistence":Lcom/google/android/gm/persistence/Persistence;
    invoke-direct {p0, v1, v0}, Lcom/google/android/gm/preference/GeneralPrefsFragment;->initializeConfirmActions(Lcom/google/android/gm/persistence/Persistence;Landroid/content/Context;)V

    .line 235
    const-string v3, "auto-advance-key"

    invoke-virtual {p0, v3}, Lcom/google/android/gm/preference/GeneralPrefsFragment;->findPreference(Ljava/lang/CharSequence;)Landroid/preference/Preference;

    move-result-object v3

    check-cast v3, Lcom/google/android/gm/preference/FancySummaryListPreference;

    invoke-virtual {v1, v0}, Lcom/google/android/gm/persistence/Persistence;->getAutoAdvanceMode(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/google/android/gm/preference/FancySummaryListPreference;->setValue(Ljava/lang/String;)V

    .line 237
    const-string v3, "swipe-key"

    invoke-virtual {p0, v3}, Lcom/google/android/gm/preference/GeneralPrefsFragment;->findPreference(Ljava/lang/CharSequence;)Landroid/preference/Preference;

    move-result-object v3

    check-cast v3, Lcom/google/android/gm/preference/FancySummaryListPreference;

    invoke-virtual {v1, v0}, Lcom/google/android/gm/persistence/Persistence;->getSwipe(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/google/android/gm/preference/FancySummaryListPreference;->setValue(Ljava/lang/String;)V

    .line 239
    const-string v3, "message-text-key"

    invoke-virtual {p0, v3}, Lcom/google/android/gm/preference/GeneralPrefsFragment;->findPreference(Ljava/lang/CharSequence;)Landroid/preference/Preference;

    move-result-object v2

    check-cast v2, Lcom/google/android/gm/preference/FancySummaryListPreference;

    .line 241
    .local v2, "textSizePref":Lcom/google/android/gm/preference/FancySummaryListPreference;
    if-eqz v2, :cond_0

    .line 242
    invoke-virtual {v1, v0}, Lcom/google/android/gm/persistence/Persistence;->getMessageTextSize(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/google/android/gm/preference/FancySummaryListPreference;->setValue(Ljava/lang/String;)V

    .line 244
    :cond_0
    const-string v3, "action-strip-action-reply-all"

    invoke-virtual {v1, v0}, Lcom/google/android/gm/persistence/Persistence;->getActionStripActionReplyAll(Landroid/content/Context;)Z

    move-result v4

    invoke-virtual {p0, v3, v4}, Lcom/google/android/gm/preference/GeneralPrefsFragment;->initializeCheckBox(Ljava/lang/String;Z)V

    .line 247
    const/16 v3, 0xb

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string v5, "confirm-actions-delete"

    aput-object v5, v3, v4

    const/4 v4, 0x1

    const-string v5, "confirm-actions-archive"

    aput-object v5, v3, v4

    const/4 v4, 0x2

    const-string v5, "confirm-actions-send"

    aput-object v5, v3, v4

    const/4 v4, 0x3

    const-string v5, "swipe-key"

    aput-object v5, v3, v4

    const/4 v4, 0x4

    const-string v5, "action-strip-action-reply-all"

    aput-object v5, v3, v4

    const/4 v4, 0x5

    const-string v5, "auto-advance-key"

    aput-object v5, v3, v4

    const/4 v4, 0x6

    const-string v5, "message-text-key"

    aput-object v5, v3, v4

    const/4 v4, 0x7

    const-string v5, "hide-checkboxes"

    aput-object v5, v3, v4

    const/16 v4, 0x8

    const-string v5, "conversation-mode"

    aput-object v5, v3, v4

    const/16 v4, 0x9

    const-string v5, "snap-headers"

    aput-object v5, v3, v4

    const/16 v4, 0xa

    const-string v5, "display_images"

    aput-object v5, v3, v4

    invoke-direct {p0, v3}, Lcom/google/android/gm/preference/GeneralPrefsFragment;->listenForPreferenceChange([Ljava/lang/String;)V

    .line 260
    return-void
.end method

.method public onStop()V
    .locals 1

    .prologue
    .line 214
    invoke-super {p0}, Lcom/google/android/gm/preference/GmailPreferenceFragment;->onStop()V

    .line 215
    iget-object v0, p0, Lcom/google/android/gm/preference/GeneralPrefsFragment;->mClearSearchHistoryDialog:Landroid/app/AlertDialog;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gm/preference/GeneralPrefsFragment;->mClearSearchHistoryDialog:Landroid/app/AlertDialog;

    invoke-virtual {v0}, Landroid/app/AlertDialog;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 216
    iget-object v0, p0, Lcom/google/android/gm/preference/GeneralPrefsFragment;->mClearSearchHistoryDialog:Landroid/app/AlertDialog;

    invoke-virtual {v0}, Landroid/app/AlertDialog;->dismiss()V

    .line 218
    :cond_0
    iget-object v0, p0, Lcom/google/android/gm/preference/GeneralPrefsFragment;->mClearDisplayImagesDialog:Landroid/app/AlertDialog;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/google/android/gm/preference/GeneralPrefsFragment;->mClearDisplayImagesDialog:Landroid/app/AlertDialog;

    invoke-virtual {v0}, Landroid/app/AlertDialog;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 219
    iget-object v0, p0, Lcom/google/android/gm/preference/GeneralPrefsFragment;->mClearDisplayImagesDialog:Landroid/app/AlertDialog;

    invoke-virtual {v0}, Landroid/app/AlertDialog;->dismiss()V

    .line 221
    :cond_1
    return-void
.end method
