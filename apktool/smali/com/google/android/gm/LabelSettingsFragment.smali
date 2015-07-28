.class public Lcom/google/android/gm/LabelSettingsFragment;
.super Landroid/app/ListFragment;
.source "LabelSettingsFragment.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;
.implements Lcom/google/android/gm/LabelSettingsObserver;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gm/LabelSettingsFragment$LabelSettingsAdapter;,
        Lcom/google/android/gm/LabelSettingsFragment$Pair;
    }
.end annotation


# instance fields
.field private mAccount:Ljava/lang/String;

.field private mAttributeList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/google/android/gm/LabelSettingsFragment$Pair;",
            ">;"
        }
    .end annotation
.end field

.field private mCanVibrate:Z

.field private mContext:Landroid/content/Context;

.field private mDoesAccountNotify:Z

.field private mDoesLabelNotify:Z

.field private mLabel:Ljava/lang/String;

.field private mNotifyOnce:Z

.field private mPersistence:Lcom/google/android/gm/persistence/Persistence;

.field private mResources:Landroid/content/res/Resources;

.field public mRingtone:Landroid/media/Ringtone;

.field public mRingtoneUri:Ljava/lang/String;

.field private mSettingsObservable:Lcom/google/android/gm/LabelSettingsObservable;

.field private mVibrate:Ljava/lang/String;

.field private mVibrateSettingDisplayValues:[Ljava/lang/String;

.field private mVibrateSettingValues:[Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 41
    invoke-direct {p0}, Landroid/app/ListFragment;-><init>()V

    .line 388
    return-void
.end method

.method static synthetic access$100(Lcom/google/android/gm/LabelSettingsFragment;)Landroid/content/Context;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/LabelSettingsFragment;

    .prologue
    .line 41
    iget-object v0, p0, Lcom/google/android/gm/LabelSettingsFragment;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$1000(Lcom/google/android/gm/LabelSettingsFragment;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/LabelSettingsFragment;

    .prologue
    .line 41
    iget-object v0, p0, Lcom/google/android/gm/LabelSettingsFragment;->mLabel:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1100(Lcom/google/android/gm/LabelSettingsFragment;)Lcom/google/android/gm/LabelSettingsObservable;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/LabelSettingsFragment;

    .prologue
    .line 41
    iget-object v0, p0, Lcom/google/android/gm/LabelSettingsFragment;->mSettingsObservable:Lcom/google/android/gm/LabelSettingsObservable;

    return-object v0
.end method

.method static synthetic access$1200(Lcom/google/android/gm/LabelSettingsFragment;)Landroid/content/res/Resources;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/LabelSettingsFragment;

    .prologue
    .line 41
    iget-object v0, p0, Lcom/google/android/gm/LabelSettingsFragment;->mResources:Landroid/content/res/Resources;

    return-object v0
.end method

.method static synthetic access$1300(Lcom/google/android/gm/LabelSettingsFragment;Landroid/media/Ringtone;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/LabelSettingsFragment;
    .param p1, "x1"    # Landroid/media/Ringtone;

    .prologue
    .line 41
    invoke-direct {p0, p1}, Lcom/google/android/gm/LabelSettingsFragment;->getRingtoneString(Landroid/media/Ringtone;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$1400(Lcom/google/android/gm/LabelSettingsFragment;)Z
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/LabelSettingsFragment;

    .prologue
    .line 41
    iget-boolean v0, p0, Lcom/google/android/gm/LabelSettingsFragment;->mCanVibrate:Z

    return v0
.end method

.method static synthetic access$1500(Lcom/google/android/gm/LabelSettingsFragment;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/LabelSettingsFragment;

    .prologue
    .line 41
    iget-object v0, p0, Lcom/google/android/gm/LabelSettingsFragment;->mVibrate:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1600(Lcom/google/android/gm/LabelSettingsFragment;)Z
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/LabelSettingsFragment;

    .prologue
    .line 41
    iget-boolean v0, p0, Lcom/google/android/gm/LabelSettingsFragment;->mNotifyOnce:Z

    return v0
.end method

.method static synthetic access$1700(Lcom/google/android/gm/LabelSettingsFragment;)[Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/LabelSettingsFragment;

    .prologue
    .line 41
    iget-object v0, p0, Lcom/google/android/gm/LabelSettingsFragment;->mVibrateSettingDisplayValues:[Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$200(Lcom/google/android/gm/LabelSettingsFragment;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/LabelSettingsFragment;

    .prologue
    .line 41
    iget-object v0, p0, Lcom/google/android/gm/LabelSettingsFragment;->mAccount:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$300(Lcom/google/android/gm/LabelSettingsFragment;)Lcom/google/android/gm/persistence/Persistence;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/LabelSettingsFragment;

    .prologue
    .line 41
    iget-object v0, p0, Lcom/google/android/gm/LabelSettingsFragment;->mPersistence:Lcom/google/android/gm/persistence/Persistence;

    return-object v0
.end method

.method static synthetic access$400(Lcom/google/android/gm/LabelSettingsFragment;)Z
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/LabelSettingsFragment;

    .prologue
    .line 41
    iget-boolean v0, p0, Lcom/google/android/gm/LabelSettingsFragment;->mDoesAccountNotify:Z

    return v0
.end method

.method static synthetic access$402(Lcom/google/android/gm/LabelSettingsFragment;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/LabelSettingsFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 41
    iput-boolean p1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mDoesAccountNotify:Z

    return p1
.end method

.method static synthetic access$500(Lcom/google/android/gm/LabelSettingsFragment;)Z
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/LabelSettingsFragment;

    .prologue
    .line 41
    iget-boolean v0, p0, Lcom/google/android/gm/LabelSettingsFragment;->mDoesLabelNotify:Z

    return v0
.end method

.method static synthetic access$502(Lcom/google/android/gm/LabelSettingsFragment;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/LabelSettingsFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 41
    iput-boolean p1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mDoesLabelNotify:Z

    return p1
.end method

.method static synthetic access$600(Lcom/google/android/gm/LabelSettingsFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/LabelSettingsFragment;

    .prologue
    .line 41
    invoke-direct {p0}, Lcom/google/android/gm/LabelSettingsFragment;->saveSettings()V

    return-void
.end method

.method static synthetic access$700(Lcom/google/android/gm/LabelSettingsFragment;)[Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/LabelSettingsFragment;

    .prologue
    .line 41
    iget-object v0, p0, Lcom/google/android/gm/LabelSettingsFragment;->mVibrateSettingValues:[Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$800(Lcom/google/android/gm/LabelSettingsFragment;Lcom/google/android/gm/LabelSettingsFragment$Pair;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/LabelSettingsFragment;
    .param p1, "x1"    # Lcom/google/android/gm/LabelSettingsFragment$Pair;
    .param p2, "x2"    # Ljava/lang/String;

    .prologue
    .line 41
    invoke-direct {p0, p1, p2}, Lcom/google/android/gm/LabelSettingsFragment;->saveVibrateSetting(Lcom/google/android/gm/LabelSettingsFragment$Pair;Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$900(Lcom/google/android/gm/LabelSettingsFragment;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/LabelSettingsFragment;

    .prologue
    .line 41
    iget-object v0, p0, Lcom/google/android/gm/LabelSettingsFragment;->mAttributeList:Ljava/util/List;

    return-object v0
.end method

.method private getRingtoneString(Landroid/media/Ringtone;)Ljava/lang/String;
    .locals 2
    .param p1, "tone"    # Landroid/media/Ringtone;

    .prologue
    .line 366
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/google/android/gm/LabelSettingsFragment;->mContext:Landroid/content/Context;

    invoke-virtual {p1, v0}, Landroid/media/Ringtone;->getTitle(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/google/android/gm/LabelSettingsFragment;->mResources:Landroid/content/res/Resources;

    const v1, 0x7f0c0199

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private loadInitialSettings()V
    .locals 6

    .prologue
    const/4 v5, 0x1

    .line 145
    iget-object v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mPersistence:Lcom/google/android/gm/persistence/Persistence;

    iget-object v2, p0, Lcom/google/android/gm/LabelSettingsFragment;->mContext:Landroid/content/Context;

    iget-object v3, p0, Lcom/google/android/gm/LabelSettingsFragment;->mAccount:Ljava/lang/String;

    iget-object v4, p0, Lcom/google/android/gm/LabelSettingsFragment;->mLabel:Ljava/lang/String;

    invoke-virtual {v1, v2, v3, v4}, Lcom/google/android/gm/persistence/Persistence;->getNotificationLabelInformation(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Set;

    move-result-object v0

    .line 147
    .local v0, "attributes":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mDoesLabelNotify:Z

    .line 148
    iput-boolean v5, p0, Lcom/google/android/gm/LabelSettingsFragment;->mNotifyOnce:Z

    .line 149
    sget-object v1, Landroid/provider/Settings$System;->DEFAULT_NOTIFICATION_URI:Landroid/net/Uri;

    invoke-virtual {v1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mRingtoneUri:Ljava/lang/String;

    .line 150
    iget-boolean v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mCanVibrate:Z

    if-eqz v1, :cond_0

    .line 152
    iget-object v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mResources:Landroid/content/res/Resources;

    const v2, 0x7f0c0195

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mVibrate:Ljava/lang/String;

    .line 154
    :cond_0
    iget-object v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mPersistence:Lcom/google/android/gm/persistence/Persistence;

    iget-object v2, p0, Lcom/google/android/gm/LabelSettingsFragment;->mContext:Landroid/content/Context;

    iget-object v3, p0, Lcom/google/android/gm/LabelSettingsFragment;->mAccount:Ljava/lang/String;

    iget-object v4, p0, Lcom/google/android/gm/LabelSettingsFragment;->mLabel:Ljava/lang/String;

    invoke-virtual {v1, v2, v3, v4}, Lcom/google/android/gm/persistence/Persistence;->shouldNotifyForLabel(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 155
    iput-boolean v5, p0, Lcom/google/android/gm/LabelSettingsFragment;->mDoesLabelNotify:Z

    .line 156
    iget-boolean v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mCanVibrate:Z

    if-eqz v1, :cond_1

    .line 157
    iget-object v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mContext:Landroid/content/Context;

    invoke-static {v1, v0}, Lcom/google/android/gm/persistence/Persistence;->extractVibrateSetting(Landroid/content/Context;Ljava/util/Set;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mVibrate:Ljava/lang/String;

    .line 159
    :cond_1
    sget v1, Lcom/google/android/gm/persistence/Persistence;->LABEL_NOTIFICATION_ONCE:I

    invoke-static {v0, v1}, Lcom/google/android/gm/persistence/Persistence;->extract(Ljava/util/Set;I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mNotifyOnce:Z

    .line 161
    sget v1, Lcom/google/android/gm/persistence/Persistence;->LABEL_NOTIFICATION_RINGTONE:I

    invoke-static {v0, v1}, Lcom/google/android/gm/persistence/Persistence;->extract(Ljava/util/Set;I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mRingtoneUri:Ljava/lang/String;

    .line 163
    :cond_2
    iget-object v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mRingtoneUri:Ljava/lang/String;

    if-eqz v1, :cond_3

    iget-object v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mRingtoneUri:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_3

    .line 164
    iget-object v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/google/android/gm/LabelSettingsFragment;->mRingtoneUri:Ljava/lang/String;

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/media/RingtoneManager;->getRingtone(Landroid/content/Context;Landroid/net/Uri;)Landroid/media/Ringtone;

    move-result-object v1

    iput-object v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mRingtone:Landroid/media/Ringtone;

    .line 166
    :cond_3
    iget-object v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mPersistence:Lcom/google/android/gm/persistence/Persistence;

    iget-object v2, p0, Lcom/google/android/gm/LabelSettingsFragment;->mContext:Landroid/content/Context;

    iget-object v3, p0, Lcom/google/android/gm/LabelSettingsFragment;->mAccount:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gm/persistence/Persistence;->getEnableNotifications(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mDoesAccountNotify:Z

    .line 167
    return-void
.end method

.method public static newInstance(Ljava/lang/String;Ljava/lang/String;)Landroid/app/Fragment;
    .locals 3
    .param p0, "account"    # Ljava/lang/String;
    .param p1, "label"    # Ljava/lang/String;

    .prologue
    .line 84
    new-instance v1, Lcom/google/android/gm/LabelSettingsFragment;

    invoke-direct {v1}, Lcom/google/android/gm/LabelSettingsFragment;-><init>()V

    .line 85
    .local v1, "fragment":Landroid/app/Fragment;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 86
    .local v0, "args":Landroid/os/Bundle;
    const-string v2, "account"

    invoke-virtual {v0, v2, p0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 87
    const-string v2, "label"

    invoke-virtual {v0, v2, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 88
    invoke-virtual {v1, v0}, Landroid/app/Fragment;->setArguments(Landroid/os/Bundle;)V

    .line 89
    return-object v1
.end method

.method private saveSettings()V
    .locals 7

    .prologue
    .line 231
    iget-boolean v3, p0, Lcom/google/android/gm/LabelSettingsFragment;->mDoesLabelNotify:Z

    if-eqz v3, :cond_1

    .line 232
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    .line 233
    .local v0, "attributes":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    iget-object v3, p0, Lcom/google/android/gm/LabelSettingsFragment;->mAttributeList:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gm/LabelSettingsFragment$Pair;

    .line 234
    .local v2, "item":Lcom/google/android/gm/LabelSettingsFragment$Pair;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget v4, v2, Lcom/google/android/gm/LabelSettingsFragment$Pair;->key:I

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, v2, Lcom/google/android/gm/LabelSettingsFragment$Pair;->value:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v3}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 236
    .end local v2    # "item":Lcom/google/android/gm/LabelSettingsFragment$Pair;
    :cond_0
    iget-object v3, p0, Lcom/google/android/gm/LabelSettingsFragment;->mPersistence:Lcom/google/android/gm/persistence/Persistence;

    iget-object v4, p0, Lcom/google/android/gm/LabelSettingsFragment;->mContext:Landroid/content/Context;

    iget-object v5, p0, Lcom/google/android/gm/LabelSettingsFragment;->mAccount:Ljava/lang/String;

    iget-object v6, p0, Lcom/google/android/gm/LabelSettingsFragment;->mLabel:Ljava/lang/String;

    invoke-virtual {v3, v4, v5, v6, v0}, Lcom/google/android/gm/persistence/Persistence;->addNotificationLabel(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;)V

    .line 242
    .end local v0    # "attributes":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .end local v1    # "i$":Ljava/util/Iterator;
    :goto_1
    iget-object v3, p0, Lcom/google/android/gm/LabelSettingsFragment;->mSettingsObservable:Lcom/google/android/gm/LabelSettingsObservable;

    invoke-interface {v3}, Lcom/google/android/gm/LabelSettingsObservable;->notifyChanged()V

    .line 243
    return-void

    .line 238
    :cond_1
    iget-object v3, p0, Lcom/google/android/gm/LabelSettingsFragment;->mPersistence:Lcom/google/android/gm/persistence/Persistence;

    iget-object v4, p0, Lcom/google/android/gm/LabelSettingsFragment;->mContext:Landroid/content/Context;

    iget-object v5, p0, Lcom/google/android/gm/LabelSettingsFragment;->mAccount:Ljava/lang/String;

    iget-object v6, p0, Lcom/google/android/gm/LabelSettingsFragment;->mLabel:Ljava/lang/String;

    invoke-virtual {v3, v4, v5, v6}, Lcom/google/android/gm/persistence/Persistence;->removeNotificationLabel(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 240
    iget-object v3, p0, Lcom/google/android/gm/LabelSettingsFragment;->mContext:Landroid/content/Context;

    iget-object v4, p0, Lcom/google/android/gm/LabelSettingsFragment;->mAccount:Ljava/lang/String;

    invoke-static {v3, v4}, Lcom/google/android/gm/preference/PreferenceUtils;->validateNotificationsForAccount(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_1
.end method

.method private saveVibrateSetting(Lcom/google/android/gm/LabelSettingsFragment$Pair;Ljava/lang/String;)V
    .locals 1
    .param p1, "item"    # Lcom/google/android/gm/LabelSettingsFragment$Pair;
    .param p2, "newValue"    # Ljava/lang/String;

    .prologue
    .line 336
    iput-object p2, p0, Lcom/google/android/gm/LabelSettingsFragment;->mVibrate:Ljava/lang/String;

    .line 337
    iget-object v0, p0, Lcom/google/android/gm/LabelSettingsFragment;->mVibrate:Ljava/lang/String;

    iput-object v0, p1, Lcom/google/android/gm/LabelSettingsFragment$Pair;->value:Ljava/lang/String;

    .line 338
    invoke-virtual {p0}, Lcom/google/android/gm/LabelSettingsFragment;->onChanged()V

    .line 339
    invoke-direct {p0}, Lcom/google/android/gm/LabelSettingsFragment;->saveSettings()V

    .line 340
    return-void
.end method

.method private setRingtone(Landroid/net/Uri;)V
    .locals 4
    .param p1, "ringtone"    # Landroid/net/Uri;

    .prologue
    .line 346
    if-eqz p1, :cond_2

    .line 347
    invoke-virtual {p1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/google/android/gm/LabelSettingsFragment;->mRingtoneUri:Ljava/lang/String;

    .line 348
    iget-object v2, p0, Lcom/google/android/gm/LabelSettingsFragment;->mContext:Landroid/content/Context;

    invoke-static {v2, p1}, Landroid/media/RingtoneManager;->getRingtone(Landroid/content/Context;Landroid/net/Uri;)Landroid/media/Ringtone;

    move-result-object v2

    iput-object v2, p0, Lcom/google/android/gm/LabelSettingsFragment;->mRingtone:Landroid/media/Ringtone;

    .line 354
    :goto_0
    iget-object v2, p0, Lcom/google/android/gm/LabelSettingsFragment;->mAttributeList:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gm/LabelSettingsFragment$Pair;

    .line 355
    .local v1, "item":Lcom/google/android/gm/LabelSettingsFragment$Pair;
    iget v2, v1, Lcom/google/android/gm/LabelSettingsFragment$Pair;->key:I

    sget v3, Lcom/google/android/gm/persistence/Persistence;->LABEL_NOTIFICATION_RINGTONE:I

    if-ne v2, v3, :cond_0

    .line 356
    iget-object v2, p0, Lcom/google/android/gm/LabelSettingsFragment;->mRingtoneUri:Ljava/lang/String;

    iput-object v2, v1, Lcom/google/android/gm/LabelSettingsFragment$Pair;->value:Ljava/lang/String;

    .line 360
    .end local v1    # "item":Lcom/google/android/gm/LabelSettingsFragment$Pair;
    :cond_1
    return-void

    .line 351
    .end local v0    # "i$":Ljava/util/Iterator;
    :cond_2
    const-string v2, ""

    iput-object v2, p0, Lcom/google/android/gm/LabelSettingsFragment;->mRingtoneUri:Ljava/lang/String;

    .line 352
    const/4 v2, 0x0

    iput-object v2, p0, Lcom/google/android/gm/LabelSettingsFragment;->mRingtone:Landroid/media/Ringtone;

    goto :goto_0
.end method

.method private showRingtonePicker()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    .line 265
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.RINGTONE_PICKER"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 266
    .local v0, "intent":Landroid/content/Intent;
    iget-object v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mRingtoneUri:Ljava/lang/String;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mRingtoneUri:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 267
    const-string v1, "android.intent.extra.ringtone.EXISTING_URI"

    iget-object v2, p0, Lcom/google/android/gm/LabelSettingsFragment;->mRingtoneUri:Ljava/lang/String;

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 269
    :cond_0
    const-string v1, "android.intent.extra.ringtone.SHOW_DEFAULT"

    invoke-virtual {v0, v1, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 270
    const-string v1, "android.intent.extra.ringtone.DEFAULT_URI"

    iget-object v2, p0, Lcom/google/android/gm/LabelSettingsFragment;->mContext:Landroid/content/Context;

    invoke-static {v2, v4}, Landroid/media/RingtoneManager;->getActualDefaultRingtoneUri(Landroid/content/Context;I)Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 272
    const-string v1, "android.intent.extra.ringtone.SHOW_SILENT"

    invoke-virtual {v0, v1, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 273
    const-string v1, "android.intent.extra.ringtone.TYPE"

    invoke-virtual {v0, v1, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 274
    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/google/android/gm/LabelSettingsFragment;->startActivityForResult(Landroid/content/Intent;I)V

    .line 275
    return-void
.end method

.method private showSynchronizationSettings()V
    .locals 3

    .prologue
    .line 249
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mContext:Landroid/content/Context;

    const-class v2, Lcom/google/android/gm/LabelSynchronizationActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 250
    const-string v1, "account"

    iget-object v2, p0, Lcom/google/android/gm/LabelSettingsFragment;->mAccount:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 251
    const-string v1, "folder"

    iget-object v2, p0, Lcom/google/android/gm/LabelSettingsFragment;->mLabel:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 252
    const-string v1, "included-labels"

    iget-object v2, p0, Lcom/google/android/gm/LabelSettingsFragment;->mSettingsObservable:Lcom/google/android/gm/LabelSettingsObservable;

    invoke-interface {v2}, Lcom/google/android/gm/LabelSettingsObservable;->getIncludedLabels()Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 254
    const-string v1, "partial-labels"

    iget-object v2, p0, Lcom/google/android/gm/LabelSettingsFragment;->mSettingsObservable:Lcom/google/android/gm/LabelSettingsObservable;

    invoke-interface {v2}, Lcom/google/android/gm/LabelSettingsObservable;->getPartialLabels()Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 256
    const-string v1, "num-of-sync-days"

    iget-object v2, p0, Lcom/google/android/gm/LabelSettingsFragment;->mSettingsObservable:Lcom/google/android/gm/LabelSettingsObservable;

    invoke-interface {v2}, Lcom/google/android/gm/LabelSettingsObservable;->getNumberOfSyncDays()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 258
    const/4 v1, 0x1

    invoke-virtual {p0, v0, v1}, Lcom/google/android/gm/LabelSettingsFragment;->startActivityForResult(Landroid/content/Intent;I)V

    .line 259
    return-void
.end method

.method private showVibrateSettingsDialog(Lcom/google/android/gm/LabelSettingsFragment$Pair;)V
    .locals 8
    .param p1, "item"    # Lcom/google/android/gm/LabelSettingsFragment$Pair;

    .prologue
    .line 299
    iget-object v6, p0, Lcom/google/android/gm/LabelSettingsFragment;->mContext:Landroid/content/Context;

    invoke-virtual {v6}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    .line 301
    .local v5, "res":Landroid/content/res/Resources;
    const/4 v1, 0x2

    .line 302
    .local v1, "currentIndex":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    iget-object v6, p0, Lcom/google/android/gm/LabelSettingsFragment;->mVibrateSettingValues:[Ljava/lang/String;

    array-length v6, v6

    if-ge v2, v6, :cond_0

    .line 303
    iget-object v6, p0, Lcom/google/android/gm/LabelSettingsFragment;->mVibrateSettingValues:[Ljava/lang/String;

    aget-object v6, v6, v2

    iget-object v7, p0, Lcom/google/android/gm/LabelSettingsFragment;->mVibrate:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 304
    move v1, v2

    .line 308
    :cond_0
    move v3, v1

    .line 309
    .local v3, "initialIndex":I
    new-instance v4, Lcom/google/android/gm/LabelSettingsFragment$3;

    invoke-direct {v4, p0, p1}, Lcom/google/android/gm/LabelSettingsFragment$3;-><init>(Lcom/google/android/gm/LabelSettingsFragment;Lcom/google/android/gm/LabelSettingsFragment$Pair;)V

    .line 321
    .local v4, "listClickListener":Landroid/content/DialogInterface$OnClickListener;
    new-instance v0, Lcom/google/android/gm/LabelSettingsFragment$4;

    invoke-direct {v0, p0, p1, v3}, Lcom/google/android/gm/LabelSettingsFragment$4;-><init>(Lcom/google/android/gm/LabelSettingsFragment;Lcom/google/android/gm/LabelSettingsFragment$Pair;I)V

    .line 330
    .local v0, "clickListener":Landroid/content/DialogInterface$OnClickListener;
    new-instance v6, Landroid/app/AlertDialog$Builder;

    iget-object v7, p0, Lcom/google/android/gm/LabelSettingsFragment;->mContext:Landroid/content/Context;

    invoke-direct {v6, v7}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    const v7, 0x7f0c01a4

    invoke-virtual {v6, v7}, Landroid/app/AlertDialog$Builder;->setTitle(I)Landroid/app/AlertDialog$Builder;

    move-result-object v6

    iget-object v7, p0, Lcom/google/android/gm/LabelSettingsFragment;->mVibrateSettingDisplayValues:[Ljava/lang/String;

    invoke-virtual {v6, v7, v3, v4}, Landroid/app/AlertDialog$Builder;->setSingleChoiceItems([Ljava/lang/CharSequence;ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v6

    const v7, 0x7f0c0005

    invoke-virtual {v6, v7, v0}, Landroid/app/AlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v6

    invoke-virtual {v6}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v6

    invoke-virtual {v6}, Landroid/app/AlertDialog;->show()V

    .line 333
    return-void

    .line 302
    .end local v0    # "clickListener":Landroid/content/DialogInterface$OnClickListener;
    .end local v3    # "initialIndex":I
    .end local v4    # "listClickListener":Landroid/content/DialogInterface$OnClickListener;
    :cond_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 6
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 103
    invoke-super {p0, p1}, Landroid/app/ListFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 105
    invoke-virtual {p0}, Lcom/google/android/gm/LabelSettingsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    iput-object v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mContext:Landroid/content/Context;

    .line 106
    iget-object v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    iput-object v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mResources:Landroid/content/res/Resources;

    .line 107
    invoke-static {}, Lcom/google/android/gm/persistence/Persistence;->getInstance()Lcom/google/android/gm/persistence/Persistence;

    move-result-object v1

    iput-object v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mPersistence:Lcom/google/android/gm/persistence/Persistence;

    .line 108
    iget-object v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mContext:Landroid/content/Context;

    const-string v4, "vibrator"

    invoke-virtual {v1, v4}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/Vibrator;

    .line 109
    .local v0, "vibrator":Landroid/os/Vibrator;
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Landroid/os/Vibrator;->hasVibrator()Z

    move-result v1

    if-eqz v1, :cond_1

    move v1, v2

    :goto_0
    iput-boolean v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mCanVibrate:Z

    .line 110
    invoke-virtual {p0}, Lcom/google/android/gm/LabelSettingsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    check-cast v1, Lcom/google/android/gm/LabelSettingsObservable;

    iput-object v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mSettingsObservable:Lcom/google/android/gm/LabelSettingsObservable;

    .line 111
    iget-object v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mSettingsObservable:Lcom/google/android/gm/LabelSettingsObservable;

    invoke-interface {v1, p0}, Lcom/google/android/gm/LabelSettingsObservable;->registerObserver(Lcom/google/android/gm/LabelSettingsObserver;)V

    .line 114
    const/4 v1, 0x3

    new-array v1, v1, [Ljava/lang/String;

    iget-object v4, p0, Lcom/google/android/gm/LabelSettingsFragment;->mResources:Landroid/content/res/Resources;

    const v5, 0x7f0c01a5

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v1, v3

    iget-object v3, p0, Lcom/google/android/gm/LabelSettingsFragment;->mResources:Landroid/content/res/Resources;

    const v4, 0x7f0c01a6

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x2

    iget-object v3, p0, Lcom/google/android/gm/LabelSettingsFragment;->mResources:Landroid/content/res/Resources;

    const v4, 0x7f0c01a7

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    iput-object v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mVibrateSettingDisplayValues:[Ljava/lang/String;

    .line 118
    iget-object v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mResources:Landroid/content/res/Resources;

    const v2, 0x7f0e0018

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mVibrateSettingValues:[Ljava/lang/String;

    .line 120
    invoke-direct {p0}, Lcom/google/android/gm/LabelSettingsFragment;->loadInitialSettings()V

    .line 121
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v1

    iput-object v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mAttributeList:Ljava/util/List;

    .line 122
    iget-object v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mAttributeList:Ljava/util/List;

    new-instance v2, Lcom/google/android/gm/LabelSettingsFragment$Pair;

    sget v3, Lcom/google/android/gm/persistence/Persistence;->LABEL_NOTIFICATION_ON:I

    iget-boolean v4, p0, Lcom/google/android/gm/LabelSettingsFragment;->mDoesLabelNotify:Z

    invoke-static {v4}, Ljava/lang/Boolean;->toString(Z)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lcom/google/android/gm/LabelSettingsFragment$Pair;-><init>(ILjava/lang/String;)V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 124
    iget-object v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mAttributeList:Ljava/util/List;

    new-instance v2, Lcom/google/android/gm/LabelSettingsFragment$Pair;

    sget v3, Lcom/google/android/gm/persistence/Persistence;->LABEL_NOTIFICATION_RINGTONE:I

    iget-object v4, p0, Lcom/google/android/gm/LabelSettingsFragment;->mRingtoneUri:Ljava/lang/String;

    invoke-direct {v2, v3, v4}, Lcom/google/android/gm/LabelSettingsFragment$Pair;-><init>(ILjava/lang/String;)V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 125
    iget-boolean v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mCanVibrate:Z

    if-eqz v1, :cond_0

    .line 126
    iget-object v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mAttributeList:Ljava/util/List;

    new-instance v2, Lcom/google/android/gm/LabelSettingsFragment$Pair;

    sget v3, Lcom/google/android/gm/persistence/Persistence;->LABEL_NOTIFICATION_VIBRATE:I

    iget-object v4, p0, Lcom/google/android/gm/LabelSettingsFragment;->mVibrate:Ljava/lang/String;

    invoke-direct {v2, v3, v4}, Lcom/google/android/gm/LabelSettingsFragment$Pair;-><init>(ILjava/lang/String;)V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 128
    :cond_0
    iget-object v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mAttributeList:Ljava/util/List;

    new-instance v2, Lcom/google/android/gm/LabelSettingsFragment$Pair;

    sget v3, Lcom/google/android/gm/persistence/Persistence;->LABEL_NOTIFICATION_ONCE:I

    iget-boolean v4, p0, Lcom/google/android/gm/LabelSettingsFragment;->mNotifyOnce:Z

    invoke-static {v4}, Ljava/lang/Boolean;->toString(Z)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lcom/google/android/gm/LabelSettingsFragment$Pair;-><init>(ILjava/lang/String;)V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 131
    new-instance v1, Lcom/google/android/gm/LabelSettingsFragment$LabelSettingsAdapter;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Lcom/google/android/gm/LabelSettingsFragment$LabelSettingsAdapter;-><init>(Lcom/google/android/gm/LabelSettingsFragment;Lcom/google/android/gm/LabelSettingsFragment$1;)V

    invoke-virtual {p0, v1}, Lcom/google/android/gm/LabelSettingsFragment;->setListAdapter(Landroid/widget/ListAdapter;)V

    .line 132
    invoke-virtual {p0}, Lcom/google/android/gm/LabelSettingsFragment;->getListView()Landroid/widget/ListView;

    move-result-object v1

    invoke-virtual {v1, p0}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 133
    return-void

    :cond_1
    move v1, v3

    .line 109
    goto/16 :goto_0
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 3
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    const/4 v2, -0x1

    .line 279
    if-nez p1, :cond_0

    if-ne p2, v2, :cond_0

    if-eqz p3, :cond_0

    .line 281
    const-string v1, "android.intent.extra.ringtone.PICKED_URI"

    invoke-virtual {p3, v1}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/net/Uri;

    .line 282
    .local v0, "uri":Landroid/net/Uri;
    invoke-direct {p0, v0}, Lcom/google/android/gm/LabelSettingsFragment;->setRingtone(Landroid/net/Uri;)V

    .line 285
    .end local v0    # "uri":Landroid/net/Uri;
    :cond_0
    const/4 v1, 0x1

    if-ne p1, v1, :cond_1

    if-ne p2, v2, :cond_1

    if-eqz p3, :cond_1

    .line 287
    iget-object v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mSettingsObservable:Lcom/google/android/gm/LabelSettingsObservable;

    const-string v2, "included-labels"

    invoke-virtual {p3, v2}, Landroid/content/Intent;->getStringArrayListExtra(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v2

    invoke-interface {v1, v2}, Lcom/google/android/gm/LabelSettingsObservable;->setIncludedLabels(Ljava/util/ArrayList;)V

    .line 289
    iget-object v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mSettingsObservable:Lcom/google/android/gm/LabelSettingsObservable;

    const-string v2, "partial-labels"

    invoke-virtual {p3, v2}, Landroid/content/Intent;->getStringArrayListExtra(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v2

    invoke-interface {v1, v2}, Lcom/google/android/gm/LabelSettingsObservable;->setPartialLabels(Ljava/util/ArrayList;)V

    .line 292
    :cond_1
    invoke-direct {p0}, Lcom/google/android/gm/LabelSettingsFragment;->saveSettings()V

    .line 293
    return-void
.end method

.method public onChanged()V
    .locals 1

    .prologue
    .line 372
    invoke-virtual {p0}, Lcom/google/android/gm/LabelSettingsFragment;->getListAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/google/android/gm/LabelSettingsFragment$LabelSettingsAdapter;

    invoke-virtual {v0}, Lcom/google/android/gm/LabelSettingsFragment$LabelSettingsAdapter;->notifyDataSetChanged()V

    .line 373
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 94
    invoke-super {p0, p1}, Landroid/app/ListFragment;->onCreate(Landroid/os/Bundle;)V

    .line 96
    invoke-virtual {p0}, Lcom/google/android/gm/LabelSettingsFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 97
    .local v0, "args":Landroid/os/Bundle;
    const-string v1, "account"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mAccount:Ljava/lang/String;

    .line 98
    const-string v1, "label"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/google/android/gm/LabelSettingsFragment;->mLabel:Ljava/lang/String;

    .line 99
    return-void
.end method

.method public onDestroyView()V
    .locals 1

    .prologue
    .line 137
    iget-object v0, p0, Lcom/google/android/gm/LabelSettingsFragment;->mSettingsObservable:Lcom/google/android/gm/LabelSettingsObservable;

    invoke-interface {v0, p0}, Lcom/google/android/gm/LabelSettingsObservable;->unregisterObserver(Lcom/google/android/gm/LabelSettingsObserver;)V

    .line 138
    invoke-super {p0}, Landroid/app/ListFragment;->onDestroyView()V

    .line 139
    return-void
.end method

.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 9
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
    const/4 v5, 0x1

    const/4 v6, 0x0

    .line 171
    invoke-virtual {p0}, Lcom/google/android/gm/LabelSettingsFragment;->getListAdapter()Landroid/widget/ListAdapter;

    move-result-object v7

    invoke-interface {v7, p3}, Landroid/widget/ListAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/google/android/gm/LabelSettingsFragment$Pair;

    .line 173
    .local v3, "item":Lcom/google/android/gm/LabelSettingsFragment$Pair;
    invoke-virtual {p2}, Landroid/view/View;->isEnabled()Z

    move-result v7

    if-nez v7, :cond_3

    .line 176
    iget v7, v3, Lcom/google/android/gm/LabelSettingsFragment$Pair;->key:I

    invoke-static {v7}, Lcom/google/android/gm/persistence/Persistence;->isNotification(I)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 177
    iget-object v7, p0, Lcom/google/android/gm/LabelSettingsFragment;->mSettingsObservable:Lcom/google/android/gm/LabelSettingsObservable;

    invoke-interface {v7}, Lcom/google/android/gm/LabelSettingsObservable;->getIncludedLabels()Ljava/util/ArrayList;

    move-result-object v7

    iget-object v8, p0, Lcom/google/android/gm/LabelSettingsFragment;->mLabel:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v7

    if-nez v7, :cond_0

    iget-object v7, p0, Lcom/google/android/gm/LabelSettingsFragment;->mSettingsObservable:Lcom/google/android/gm/LabelSettingsObservable;

    invoke-interface {v7}, Lcom/google/android/gm/LabelSettingsObservable;->getPartialLabels()Ljava/util/ArrayList;

    move-result-object v7

    iget-object v8, p0, Lcom/google/android/gm/LabelSettingsFragment;->mLabel:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_2

    :cond_0
    move v4, v5

    .line 179
    .local v4, "syncEnabled":Z
    :goto_0
    if-eqz v4, :cond_1

    iget-boolean v5, p0, Lcom/google/android/gm/LabelSettingsFragment;->mDoesAccountNotify:Z

    if-nez v5, :cond_1

    .line 180
    new-instance v1, Lcom/google/android/gm/LabelSettingsFragment$1;

    invoke-direct {v1, p0}, Lcom/google/android/gm/LabelSettingsFragment$1;-><init>(Lcom/google/android/gm/LabelSettingsFragment;)V

    .line 188
    .local v1, "cancel":Landroid/content/DialogInterface$OnClickListener;
    new-instance v2, Lcom/google/android/gm/LabelSettingsFragment$2;

    invoke-direct {v2, p0}, Lcom/google/android/gm/LabelSettingsFragment$2;-><init>(Lcom/google/android/gm/LabelSettingsFragment;)V

    .line 200
    .local v2, "enableNotifications":Landroid/content/DialogInterface$OnClickListener;
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v5, p0, Lcom/google/android/gm/LabelSettingsFragment;->mContext:Landroid/content/Context;

    invoke-direct {v0, v5}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 201
    .local v0, "builder":Landroid/app/AlertDialog$Builder;
    const v5, 0x7f0c016c

    invoke-virtual {v0, v5}, Landroid/app/AlertDialog$Builder;->setMessage(I)Landroid/app/AlertDialog$Builder;

    move-result-object v5

    const v6, 0x1040013

    invoke-virtual {v5, v6, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v5

    const v6, 0x1040009

    invoke-virtual {v5, v6, v1}, Landroid/app/AlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v5

    invoke-virtual {v5}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v5

    invoke-virtual {v5}, Landroid/app/AlertDialog;->show()V

    .line 225
    .end local v0    # "builder":Landroid/app/AlertDialog$Builder;
    .end local v1    # "cancel":Landroid/content/DialogInterface$OnClickListener;
    .end local v2    # "enableNotifications":Landroid/content/DialogInterface$OnClickListener;
    .end local v4    # "syncEnabled":Z
    :cond_1
    :goto_1
    return-void

    :cond_2
    move v4, v6

    .line 177
    goto :goto_0

    .line 210
    :cond_3
    iget v7, v3, Lcom/google/android/gm/LabelSettingsFragment$Pair;->key:I

    sget v8, Lcom/google/android/gm/persistence/Persistence;->LABEL_SYNCHRONIZATION:I

    if-ne v7, v8, :cond_5

    .line 211
    invoke-direct {p0}, Lcom/google/android/gm/LabelSettingsFragment;->showSynchronizationSettings()V

    .line 224
    :cond_4
    :goto_2
    invoke-direct {p0}, Lcom/google/android/gm/LabelSettingsFragment;->saveSettings()V

    goto :goto_1

    .line 212
    :cond_5
    iget v7, v3, Lcom/google/android/gm/LabelSettingsFragment$Pair;->key:I

    sget v8, Lcom/google/android/gm/persistence/Persistence;->LABEL_NOTIFICATION_ON:I

    if-ne v7, v8, :cond_7

    .line 213
    iget-boolean v7, p0, Lcom/google/android/gm/LabelSettingsFragment;->mDoesLabelNotify:Z

    if-nez v7, :cond_6

    :goto_3
    iput-boolean v5, p0, Lcom/google/android/gm/LabelSettingsFragment;->mDoesLabelNotify:Z

    .line 214
    iget-boolean v5, p0, Lcom/google/android/gm/LabelSettingsFragment;->mDoesLabelNotify:Z

    invoke-static {v5}, Ljava/lang/Boolean;->toString(Z)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v3, Lcom/google/android/gm/LabelSettingsFragment$Pair;->value:Ljava/lang/String;

    goto :goto_2

    :cond_6
    move v5, v6

    .line 213
    goto :goto_3

    .line 215
    :cond_7
    iget-boolean v7, p0, Lcom/google/android/gm/LabelSettingsFragment;->mDoesLabelNotify:Z

    if-eqz v7, :cond_8

    iget v7, v3, Lcom/google/android/gm/LabelSettingsFragment$Pair;->key:I

    sget v8, Lcom/google/android/gm/persistence/Persistence;->LABEL_NOTIFICATION_RINGTONE:I

    if-ne v7, v8, :cond_8

    .line 216
    invoke-direct {p0}, Lcom/google/android/gm/LabelSettingsFragment;->showRingtonePicker()V

    goto :goto_2

    .line 217
    :cond_8
    iget-boolean v7, p0, Lcom/google/android/gm/LabelSettingsFragment;->mDoesLabelNotify:Z

    if-eqz v7, :cond_9

    iget-boolean v7, p0, Lcom/google/android/gm/LabelSettingsFragment;->mCanVibrate:Z

    if-eqz v7, :cond_9

    iget v7, v3, Lcom/google/android/gm/LabelSettingsFragment$Pair;->key:I

    sget v8, Lcom/google/android/gm/persistence/Persistence;->LABEL_NOTIFICATION_VIBRATE:I

    if-ne v7, v8, :cond_9

    .line 219
    invoke-direct {p0, v3}, Lcom/google/android/gm/LabelSettingsFragment;->showVibrateSettingsDialog(Lcom/google/android/gm/LabelSettingsFragment$Pair;)V

    goto :goto_2

    .line 220
    :cond_9
    iget-boolean v7, p0, Lcom/google/android/gm/LabelSettingsFragment;->mDoesLabelNotify:Z

    if-eqz v7, :cond_4

    iget v7, v3, Lcom/google/android/gm/LabelSettingsFragment$Pair;->key:I

    sget v8, Lcom/google/android/gm/persistence/Persistence;->LABEL_NOTIFICATION_ONCE:I

    if-ne v7, v8, :cond_4

    .line 221
    iget-boolean v7, p0, Lcom/google/android/gm/LabelSettingsFragment;->mNotifyOnce:Z

    if-nez v7, :cond_a

    :goto_4
    iput-boolean v5, p0, Lcom/google/android/gm/LabelSettingsFragment;->mNotifyOnce:Z

    .line 222
    iget-boolean v5, p0, Lcom/google/android/gm/LabelSettingsFragment;->mNotifyOnce:Z

    invoke-static {v5}, Ljava/lang/Boolean;->toString(Z)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v3, Lcom/google/android/gm/LabelSettingsFragment$Pair;->value:Ljava/lang/String;

    goto :goto_2

    :cond_a
    move v5, v6

    .line 221
    goto :goto_4
.end method
