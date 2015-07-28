.class public Lcom/android/mail/ui/SuppressNotificationReceiver;
.super Landroid/content/BroadcastReceiver;
.source "SuppressNotificationReceiver.java"


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private mContext:Landroid/content/Context;

.field private mController:Lcom/android/mail/ui/AbstractActivityController;

.field private mMimeType:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 41
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/ui/SuppressNotificationReceiver;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public activate(Landroid/content/Context;Lcom/android/mail/ui/AbstractActivityController;)Z
    .locals 9
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "controller"    # Lcom/android/mail/ui/AbstractActivityController;

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 52
    invoke-virtual {p2}, Lcom/android/mail/ui/AbstractActivityController;->getCurrentAccount()Lcom/android/mail/providers/Account;

    move-result-object v0

    .line 54
    .local v0, "account":Lcom/android/mail/providers/Account;
    iput-object p1, p0, Lcom/android/mail/ui/SuppressNotificationReceiver;->mContext:Landroid/content/Context;

    .line 55
    iput-object p2, p0, Lcom/android/mail/ui/SuppressNotificationReceiver;->mController:Lcom/android/mail/ui/AbstractActivityController;

    .line 57
    new-instance v2, Landroid/content/IntentFilter;

    const-string v3, "com.android.mail.action.update_notification"

    invoke-direct {v2, v3}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    .line 61
    .local v2, "filter":Landroid/content/IntentFilter;
    invoke-virtual {v2, v7}, Landroid/content/IntentFilter;->setPriority(I)V

    .line 62
    if-eqz v0, :cond_0

    .line 63
    iget-object v3, v0, Lcom/android/mail/providers/Account;->mimeType:Ljava/lang/String;

    iput-object v3, p0, Lcom/android/mail/ui/SuppressNotificationReceiver;->mMimeType:Ljava/lang/String;

    .line 65
    :try_start_0
    iget-object v3, p0, Lcom/android/mail/ui/SuppressNotificationReceiver;->mMimeType:Ljava/lang/String;

    invoke-virtual {v2, v3}, Landroid/content/IntentFilter;->addDataType(Ljava/lang/String;)V
    :try_end_0
    .catch Landroid/content/IntentFilter$MalformedMimeTypeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 74
    :goto_0
    invoke-virtual {p1, p0, v2}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 76
    return v8

    .line 66
    :catch_0
    move-exception v1

    .line 67
    .local v1, "e":Landroid/content/IntentFilter$MalformedMimeTypeException;
    sget-object v3, Lcom/android/mail/ui/SuppressNotificationReceiver;->LOG_TAG:Ljava/lang/String;

    const-string v4, "Malformed mimetype: %s"

    new-array v5, v8, [Ljava/lang/Object;

    iget-object v6, p0, Lcom/android/mail/ui/SuppressNotificationReceiver;->mMimeType:Ljava/lang/String;

    aput-object v6, v5, v7

    invoke-static {v3, v4, v5}, Lcom/android/mail/utils/LogUtils;->wtf(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0

    .line 72
    .end local v1    # "e":Landroid/content/IntentFilter$MalformedMimeTypeException;
    :cond_0
    sget-object v3, Lcom/android/mail/ui/SuppressNotificationReceiver;->LOG_TAG:Ljava/lang/String;

    const-string v4, "Registering receiver with no mime type"

    new-array v5, v7, [Ljava/lang/Object;

    invoke-static {v3, v4, v5}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0
.end method

.method public activated()Z
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Lcom/android/mail/ui/SuppressNotificationReceiver;->mContext:Landroid/content/Context;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public deactivate()V
    .locals 1

    .prologue
    .line 91
    :try_start_0
    iget-object v0, p0, Lcom/android/mail/ui/SuppressNotificationReceiver;->mContext:Landroid/content/Context;

    if-eqz v0, :cond_0

    .line 92
    iget-object v0, p0, Lcom/android/mail/ui/SuppressNotificationReceiver;->mContext:Landroid/content/Context;

    invoke-virtual {v0, p0}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 93
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/mail/ui/SuppressNotificationReceiver;->mContext:Landroid/content/Context;

    .line 94
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/mail/ui/SuppressNotificationReceiver;->mMimeType:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    .line 99
    :cond_0
    :goto_0
    return-void

    .line 96
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public notificationsDisabledForAccount(Lcom/android/mail/providers/Account;)Z
    .locals 2
    .param p1, "account"    # Lcom/android/mail/providers/Account;

    .prologue
    .line 105
    iget-object v0, p0, Lcom/android/mail/ui/SuppressNotificationReceiver;->mContext:Landroid/content/Context;

    if-eqz v0, :cond_0

    iget-object v0, p1, Lcom/android/mail/providers/Account;->mimeType:Ljava/lang/String;

    iget-object v1, p0, Lcom/android/mail/ui/SuppressNotificationReceiver;->mMimeType:Ljava/lang/String;

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 12
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    const/4 v9, 0x2

    const/4 v11, 0x1

    const/4 v10, 0x0

    .line 110
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 111
    .local v0, "action":Ljava/lang/String;
    const-string v7, "com.android.mail.action.update_notification"

    invoke-virtual {v7, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-nez v7, :cond_1

    .line 164
    :cond_0
    :goto_0
    return-void

    .line 115
    :cond_1
    iget-object v7, p0, Lcom/android/mail/ui/SuppressNotificationReceiver;->mController:Lcom/android/mail/ui/AbstractActivityController;

    invoke-virtual {v7}, Lcom/android/mail/ui/AbstractActivityController;->isConversationListVisible()Z

    move-result v7

    if-eqz v7, :cond_0

    .line 120
    iget-object v7, p0, Lcom/android/mail/ui/SuppressNotificationReceiver;->mController:Lcom/android/mail/ui/AbstractActivityController;

    invoke-virtual {v7}, Lcom/android/mail/ui/AbstractActivityController;->getCurrentListContext()Lcom/android/mail/ConversationListContext;

    move-result-object v4

    .line 121
    .local v4, "listContext":Lcom/android/mail/ConversationListContext;
    if-nez v4, :cond_2

    .line 123
    sget-object v7, Lcom/android/mail/ui/SuppressNotificationReceiver;->LOG_TAG:Ljava/lang/String;

    const-string v8, "unexpected null context"

    new-array v9, v10, [Ljava/lang/Object;

    invoke-static {v7, v8, v9}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0

    .line 127
    :cond_2
    invoke-static {v4}, Lcom/android/mail/ConversationListContext;->isSearchResult(Lcom/android/mail/ConversationListContext;)Z

    move-result v7

    if-nez v7, :cond_0

    .line 132
    iget-object v5, v4, Lcom/android/mail/ConversationListContext;->account:Lcom/android/mail/providers/Account;

    .line 133
    .local v5, "listContextAccount":Lcom/android/mail/providers/Account;
    iget-object v6, v4, Lcom/android/mail/ConversationListContext;->folder:Lcom/android/mail/providers/Folder;

    .line 135
    .local v6, "listContextFolder":Lcom/android/mail/providers/Folder;
    if-eqz v5, :cond_3

    if-nez v6, :cond_4

    .line 136
    :cond_3
    sget-object v7, Lcom/android/mail/ui/SuppressNotificationReceiver;->LOG_TAG:Ljava/lang/String;

    const-string v8, "SuppressNotificationReceiver.onReceive: account=%s, folder=%s"

    new-array v9, v9, [Ljava/lang/Object;

    aput-object v5, v9, v10

    aput-object v6, v9, v11

    invoke-static {v7, v8, v9}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0

    .line 141
    :cond_4
    const-string v7, "notification_extra_account"

    invoke-virtual {p2, v7}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v2

    check-cast v2, Landroid/net/Uri;

    .line 143
    .local v2, "intentAccountUri":Landroid/net/Uri;
    iget-object v7, v5, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    invoke-virtual {v7, v2}, Landroid/net/Uri;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 146
    const-string v7, "notification_extra_folder"

    invoke-virtual {p2, v7}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v3

    check-cast v3, Landroid/net/Uri;

    .line 149
    .local v3, "intentFolderUri":Landroid/net/Uri;
    iget-object v7, v6, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    invoke-virtual {v7, v3}, Landroid/net/Uri;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 152
    const-string v7, "notification_updated_unread_count"

    invoke-virtual {p2, v7, v10}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v1

    .line 158
    .local v1, "count":I
    if-eqz v1, :cond_0

    .line 161
    sget-object v7, Lcom/android/mail/ui/SuppressNotificationReceiver;->LOG_TAG:Ljava/lang/String;

    const-string v8, "Aborting broadcast of intent %s, folder uri is %s"

    new-array v9, v9, [Ljava/lang/Object;

    aput-object p2, v9, v10

    aput-object v3, v9, v11

    invoke-static {v7, v8, v9}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 163
    invoke-virtual {p0}, Lcom/android/mail/ui/SuppressNotificationReceiver;->abortBroadcast()V

    goto :goto_0
.end method
