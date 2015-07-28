.class public Lcom/google/android/gm/MailIntentService;
.super Landroid/app/IntentService;
.source "MailIntentService.java"


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 52
    const-string v0, "MailIntentService"

    invoke-direct {p0, v0}, Landroid/app/IntentService;-><init>(Ljava/lang/String;)V

    .line 53
    return-void
.end method

.method private handleAccountList([Landroid/accounts/Account;Z)V
    .locals 5
    .param p1, "accounts"    # [Landroid/accounts/Account;
    .param p2, "isInitialNotification"    # Z

    .prologue
    .line 216
    const/4 v4, 0x0

    invoke-static {p0, v4, p1}, Lcom/google/android/gm/Utils;->cacheGoogleAccountList(Landroid/content/Context;Z[Landroid/accounts/Account;)V

    .line 218
    if-nez p2, :cond_1

    .line 230
    :cond_0
    return-void

    .line 222
    :cond_1
    array-length v3, p1

    .line 223
    .local v3, "numAccounts":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v3, :cond_0

    .line 224
    aget-object v0, p1, v2

    .line 227
    .local v0, "account":Landroid/accounts/Account;
    iget-object v4, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-static {p0, v4}, Lcom/google/android/gm/provider/MailEngine;->getOrMakeMailEngineSync(Landroid/content/Context;Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;

    move-result-object v1

    .line 228
    .local v1, "engine":Lcom/google/android/gm/provider/MailEngine;
    const/4 v4, 0x1

    invoke-virtual {v1, v4}, Lcom/google/android/gm/provider/MailEngine;->sendNotificationIntents(Z)V

    .line 223
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method private handleLocaleChanged(Landroid/content/Intent;)V
    .locals 0
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 193
    invoke-static {p0}, Lcom/google/android/gm/Utils;->cancelAndResendNotifications(Landroid/content/Context;)V

    .line 194
    return-void
.end method

.method private handleProviderChangedIntent(Landroid/content/Intent;)V
    .locals 7
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 197
    invoke-static {}, Lcom/google/android/gm/persistence/Persistence;->getInstance()Lcom/google/android/gm/persistence/Persistence;

    move-result-object v3

    .line 199
    .local v3, "persistence":Lcom/google/android/gm/persistence/Persistence;
    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v5

    const-string v6, "account"

    invoke-virtual {v5, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 200
    .local v0, "account":Ljava/lang/String;
    invoke-virtual {v3, p0, v0}, Lcom/google/android/gm/persistence/Persistence;->getEnableNotifications(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v1

    .line 201
    .local v1, "enabled":Z
    if-nez v1, :cond_1

    .line 212
    :cond_0
    :goto_0
    return-void

    .line 203
    :cond_1
    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v5

    const-string v6, "notificationLabel"

    invoke-virtual {v5, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 204
    .local v2, "label":Ljava/lang/String;
    invoke-virtual {v3, p0, v0, v2}, Lcom/google/android/gm/persistence/Persistence;->shouldNotifyForLabel(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v4

    .line 208
    .local v4, "shouldNotifyForLabel":Z
    if-eqz v4, :cond_0

    .line 211
    invoke-static {p0, p1}, Lcom/google/android/gm/Utils;->setNewEmailIndicator(Landroid/content/Context;Landroid/content/Intent;)V

    goto :goto_0
.end method

.method private postSendErrorNotification(Landroid/content/Intent;)V
    .locals 7
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 147
    const-string v0, "account"

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 148
    .local v1, "account":Ljava/lang/String;
    const-string v0, "extraMessageSubject"

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 149
    .local v2, "subject":Ljava/lang/String;
    const-string v0, "extraConversationId"

    const-wide/16 v5, -0x1

    invoke-virtual {p1, v0, v5, v6}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v3

    .line 150
    .local v3, "conversationId":J
    invoke-virtual {p0}, Lcom/google/android/gm/MailIntentService;->getBaseContext()Landroid/content/Context;

    move-result-object v0

    const v5, 0x7f110022

    const v6, 0x7f0c01d7

    invoke-static/range {v0 .. v6}, Lcom/google/android/gm/Utils;->createErrorNotification(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;JII)V

    .line 152
    return-void
.end method

.method private sendAccountsChangedNotification(Z)V
    .locals 11
    .param p1, "isInitialNotification"    # Z

    .prologue
    const/4 v10, 0x0

    const/4 v9, 0x0

    .line 158
    if-eqz p1, :cond_0

    .line 159
    const-string v5, "MIS.sendInitialNotifications"

    invoke-static {v5}, Lcom/google/android/gm/perf/Timer;->startTiming(Ljava/lang/String;)V

    .line 163
    :cond_0
    invoke-static {p0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v5

    const-string v6, "com.google"

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/String;

    const-string v8, "mail"

    invoke-static {v8}, Lcom/google/android/gsf/GoogleLoginServiceConstants;->featureForService(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v7, v9

    invoke-virtual {v5, v6, v7, v10, v10}, Landroid/accounts/AccountManager;->getAccountsByTypeAndFeatures(Ljava/lang/String;[Ljava/lang/String;Landroid/accounts/AccountManagerCallback;Landroid/os/Handler;)Landroid/accounts/AccountManagerFuture;

    move-result-object v2

    .line 170
    .local v2, "future":Landroid/accounts/AccountManagerFuture;, "Landroid/accounts/AccountManagerFuture<[Landroid/accounts/Account;>;"
    :try_start_0
    invoke-interface {v2}, Landroid/accounts/AccountManagerFuture;->getResult()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroid/accounts/Account;

    .line 172
    .local v0, "accounts":[Landroid/accounts/Account;
    invoke-direct {p0, v0, p1}, Lcom/google/android/gm/MailIntentService;->handleAccountList([Landroid/accounts/Account;Z)V
    :try_end_0
    .catch Landroid/accounts/OperationCanceledException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Landroid/accounts/AuthenticatorException; {:try_start_0 .. :try_end_0} :catch_2
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 183
    if-eqz p1, :cond_1

    .line 184
    const-string v5, "MIS.sendInitialNotifications"

    invoke-static {v5}, Lcom/google/android/gm/perf/Timer;->stopTiming(Ljava/lang/String;)V

    .line 186
    :cond_1
    invoke-virtual {p0}, Lcom/google/android/gm/MailIntentService;->stopSelf()V

    .line 188
    .end local v0    # "accounts":[Landroid/accounts/Account;
    :goto_0
    return-void

    .line 173
    :catch_0
    move-exception v4

    .line 175
    .local v4, "oce":Landroid/accounts/OperationCanceledException;
    :try_start_1
    const-string v5, "Gmail"

    const-string v6, "Unexpected exception trying to get accounts."

    const/4 v7, 0x0

    new-array v7, v7, [Ljava/lang/Object;

    invoke-static {v5, v4, v6, v7}, Lcom/google/android/gm/provider/LogUtils;->w(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 183
    if-eqz p1, :cond_2

    .line 184
    const-string v5, "MIS.sendInitialNotifications"

    invoke-static {v5}, Lcom/google/android/gm/perf/Timer;->stopTiming(Ljava/lang/String;)V

    .line 186
    :cond_2
    invoke-virtual {p0}, Lcom/google/android/gm/MailIntentService;->stopSelf()V

    goto :goto_0

    .line 176
    .end local v4    # "oce":Landroid/accounts/OperationCanceledException;
    :catch_1
    move-exception v3

    .line 178
    .local v3, "ioe":Ljava/io/IOException;
    :try_start_2
    const-string v5, "Gmail"

    const-string v6, "Unexpected exception trying to get accounts."

    const/4 v7, 0x0

    new-array v7, v7, [Ljava/lang/Object;

    invoke-static {v5, v3, v6, v7}, Lcom/google/android/gm/provider/LogUtils;->w(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 183
    if-eqz p1, :cond_3

    .line 184
    const-string v5, "MIS.sendInitialNotifications"

    invoke-static {v5}, Lcom/google/android/gm/perf/Timer;->stopTiming(Ljava/lang/String;)V

    .line 186
    :cond_3
    invoke-virtual {p0}, Lcom/google/android/gm/MailIntentService;->stopSelf()V

    goto :goto_0

    .line 179
    .end local v3    # "ioe":Ljava/io/IOException;
    :catch_2
    move-exception v1

    .line 181
    .local v1, "ae":Landroid/accounts/AuthenticatorException;
    :try_start_3
    const-string v5, "Gmail"

    const-string v6, "Unexpected exception trying to get accounts."

    const/4 v7, 0x0

    new-array v7, v7, [Ljava/lang/Object;

    invoke-static {v5, v1, v6, v7}, Lcom/google/android/gm/provider/LogUtils;->w(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 183
    if-eqz p1, :cond_4

    .line 184
    const-string v5, "MIS.sendInitialNotifications"

    invoke-static {v5}, Lcom/google/android/gm/perf/Timer;->stopTiming(Ljava/lang/String;)V

    .line 186
    :cond_4
    invoke-virtual {p0}, Lcom/google/android/gm/MailIntentService;->stopSelf()V

    goto :goto_0

    .line 183
    .end local v1    # "ae":Landroid/accounts/AuthenticatorException;
    :catchall_0
    move-exception v5

    if-eqz p1, :cond_5

    .line 184
    const-string v6, "MIS.sendInitialNotifications"

    invoke-static {v6}, Lcom/google/android/gm/perf/Timer;->stopTiming(Ljava/lang/String;)V

    .line 186
    :cond_5
    invoke-virtual {p0}, Lcom/google/android/gm/MailIntentService;->stopSelf()V

    throw v5
.end method


# virtual methods
.method protected onHandleIntent(Landroid/content/Intent;)V
    .locals 24
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 58
    :try_start_0
    const-string v19, "Gmail"

    const-string v20, "Handling intent %s"

    const/16 v21, 0x1

    move/from16 v0, v21

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v21, v0

    const/16 v22, 0x0

    aput-object p1, v21, v22

    invoke-static/range {v19 .. v21}, Lcom/google/android/gm/provider/LogUtils;->v(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 60
    invoke-static/range {p0 .. p0}, Lcom/google/android/gm/Utils;->haveGoogleMailActivitiesBeenEnabled(Landroid/content/Context;)Z

    move-result v18

    .line 61
    .local v18, "usingGoogleMail":Z
    invoke-virtual/range {p1 .. p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v5

    .line 62
    .local v5, "action":Ljava/lang/String;
    const-string v19, "android.intent.action.BOOT_COMPLETED"

    move-object/from16 v0, v19

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    if-nez v19, :cond_0

    const-string v19, "android.intent.action.DEVICE_STORAGE_OK"

    move-object/from16 v0, v19

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    if-nez v19, :cond_0

    const-string v19, "android.intent.action.MY_PACKAGE_REPLACED"

    move-object/from16 v0, v19

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_2

    .line 67
    :cond_0
    const/16 v19, 0x1

    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-direct {v0, v1}, Lcom/google/android/gm/MailIntentService;->sendAccountsChangedNotification(Z)V

    .line 144
    .end local v5    # "action":Ljava/lang/String;
    .end local v18    # "usingGoogleMail":Z
    :cond_1
    :goto_0
    return-void

    .line 68
    .restart local v5    # "action":Ljava/lang/String;
    .restart local v18    # "usingGoogleMail":Z
    :cond_2
    const-string v19, "android.intent.action.DOWNLOAD_COMPLETE"

    move-object/from16 v0, v19

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_4

    .line 69
    const-string v19, "extra_download_id"

    const-wide/16 v20, -0x1

    move-object/from16 v0, p1

    move-object/from16 v1, v19

    move-wide/from16 v2, v20

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v19

    invoke-static/range {v19 .. v20}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v9

    .line 70
    .local v9, "downloadId":Ljava/lang/Long;
    invoke-virtual {v9}, Ljava/lang/Long;->longValue()J

    move-result-wide v19

    invoke-static/range {v19 .. v20}, Lcom/google/android/gm/provider/AttachmentManager;->getAccountFromDownloadId(J)Ljava/lang/String;

    move-result-object v4

    .line 73
    .local v4, "account":Ljava/lang/String;
    if-nez v4, :cond_3

    .line 74
    const-string v19, "download"

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/google/android/gm/MailIntentService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v19

    check-cast v19, Landroid/app/DownloadManager;

    const/16 v20, 0x1

    move/from16 v0, v20

    new-array v0, v0, [J

    move-object/from16 v20, v0

    const/16 v21, 0x0

    invoke-virtual {v9}, Ljava/lang/Long;->longValue()J

    move-result-wide v22

    aput-wide v22, v20, v21

    invoke-virtual/range {v19 .. v20}, Landroid/app/DownloadManager;->remove([J)I
    :try_end_0
    .catch Landroid/database/SQLException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 141
    .end local v4    # "account":Ljava/lang/String;
    .end local v5    # "action":Ljava/lang/String;
    .end local v9    # "downloadId":Ljava/lang/Long;
    .end local v18    # "usingGoogleMail":Z
    :catch_0
    move-exception v10

    .line 142
    .local v10, "e":Landroid/database/SQLException;
    const-string v19, "Gmail"

    const-string v20, "Error handling intent %s"

    const/16 v21, 0x1

    move/from16 v0, v21

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v21, v0

    const/16 v22, 0x0

    aput-object p1, v21, v22

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    move-object/from16 v2, v21

    invoke-static {v0, v10, v1, v2}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0

    .line 80
    .end local v10    # "e":Landroid/database/SQLException;
    .restart local v4    # "account":Ljava/lang/String;
    .restart local v5    # "action":Ljava/lang/String;
    .restart local v9    # "downloadId":Ljava/lang/Long;
    .restart local v18    # "usingGoogleMail":Z
    :cond_3
    :try_start_1
    move-object/from16 v0, p0

    invoke-static {v0, v4}, Lcom/google/android/gm/provider/MailEngine;->getOrMakeMailEngineSync(Landroid/content/Context;Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;

    move-result-object v11

    .line 81
    .local v11, "engine":Lcom/google/android/gm/provider/MailEngine;
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gm/MailIntentService;->getBaseContext()Landroid/content/Context;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v14

    .line 82
    .local v14, "res":Landroid/content/res/Resources;
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    .line 84
    .local v6, "attachmentFrom":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    const v19, 0x7f0c01b7

    move/from16 v0, v19

    invoke-virtual {v14, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 85
    const v19, 0x7f0c01b8

    move/from16 v0, v19

    invoke-virtual {v14, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 86
    sget-object v19, Lcom/google/android/gm/provider/AttachmentManager;->ATTACHMENT_FROM:Ljava/lang/String;

    move-object/from16 v0, p1

    move-object/from16 v1, v19

    invoke-virtual {v0, v1, v6}, Landroid/content/Intent;->putStringArrayListExtra(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;

    .line 88
    invoke-virtual {v11}, Lcom/google/android/gm/provider/MailEngine;->getAttachmentManager()Lcom/google/android/gm/provider/AttachmentManager;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, p1

    invoke-virtual {v0, v1}, Lcom/google/android/gm/provider/AttachmentManager;->handleDownloadManagerIntent(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 90
    .end local v4    # "account":Ljava/lang/String;
    .end local v6    # "attachmentFrom":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    .end local v9    # "downloadId":Ljava/lang/Long;
    .end local v11    # "engine":Lcom/google/android/gm/provider/MailEngine;
    .end local v14    # "res":Landroid/content/res/Resources;
    :cond_4
    const-string v19, "com.google.android.gm.intent.CLEAR_ALL_NEW_MAIL_NOTIFICATIONS"

    move-object/from16 v0, v19

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_5

    .line 92
    invoke-static/range {p0 .. p0}, Lcom/google/android/gm/Utils;->clearAllNotfications(Landroid/content/Context;)V

    goto/16 :goto_0

    .line 93
    :cond_5
    const-string v19, "com.google.android.gm.intent.CLEAR_NEW_MAIL_NOTIFICATIONS"

    move-object/from16 v0, v19

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_6

    .line 94
    const-string v19, "account"

    move-object/from16 v0, p1

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 96
    .restart local v4    # "account":Ljava/lang/String;
    const-string v19, "label"

    move-object/from16 v0, p1

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 98
    .local v12, "label":Ljava/lang/String;
    move-object/from16 v0, p0

    invoke-static {v0, v4, v12}, Lcom/google/android/gm/Utils;->clearLabelNotification(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 99
    .end local v4    # "account":Ljava/lang/String;
    .end local v12    # "label":Ljava/lang/String;
    :cond_6
    const-string v19, "com.android.mail.action.update_notification"

    move-object/from16 v0, v19

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_7

    .line 100
    invoke-direct/range {p0 .. p1}, Lcom/google/android/gm/MailIntentService;->handleProviderChangedIntent(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 101
    :cond_7
    const-string v19, "android.accounts.LOGIN_ACCOUNTS_CHANGED"

    move-object/from16 v0, v19

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_8

    .line 103
    invoke-static/range {p0 .. p0}, Lcom/google/android/gm/Utils;->enableShortcutIntentFilter(Landroid/content/Context;)V

    .line 104
    const/16 v19, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-direct {v0, v1}, Lcom/google/android/gm/MailIntentService;->sendAccountsChangedNotification(Z)V

    goto/16 :goto_0

    .line 105
    :cond_8
    const-string v19, "android.intent.action.LOCALE_CHANGED"

    move-object/from16 v0, v19

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_9

    .line 106
    invoke-direct/range {p0 .. p1}, Lcom/google/android/gm/MailIntentService;->handleLocaleChanged(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 107
    :cond_9
    const-string v19, "com.google.android.gm.intent.VALIDATE_ACCOUNT_NOTIFICATIONS"

    move-object/from16 v0, v19

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_a

    .line 108
    const-string v19, "account"

    move-object/from16 v0, p1

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 110
    .restart local v4    # "account":Ljava/lang/String;
    move-object/from16 v0, p0

    invoke-static {v0, v4}, Lcom/google/android/gm/Utils;->validateAccountNotifications(Landroid/content/Context;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 111
    .end local v4    # "account":Ljava/lang/String;
    :cond_a
    const-string v19, "com.google.android.gm.intent.ACTION_POST_SEND_ERROR"

    move-object/from16 v0, v19

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_b

    .line 112
    invoke-direct/range {p0 .. p1}, Lcom/google/android/gm/MailIntentService;->postSendErrorNotification(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 113
    :cond_b
    const-string v19, "com.google.android.gm.intent.ACTION_PROVIDER_CREATED"

    move-object/from16 v0, v19

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_c

    .line 115
    new-instance v17, Landroid/content/Intent;

    const-string v19, "com.android.mail.ACTION_NOTIFY_DATASET_CHANGED"

    move-object/from16 v0, v17

    move-object/from16 v1, v19

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 117
    .local v17, "updateAllWigetsIntent":Landroid/content/Intent;
    const-string v19, "update-all-widgets"

    const/16 v20, 0x1

    move-object/from16 v0, v17

    move-object/from16 v1, v19

    move/from16 v2, v20

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 118
    const-string v19, "application/gmail-ls"

    move-object/from16 v0, v17

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 119
    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/google/android/gm/MailIntentService;->sendBroadcast(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 120
    .end local v17    # "updateAllWigetsIntent":Landroid/content/Intent;
    :cond_c
    const-string v19, "com.google.android.gm.intent.ACTION_UPGRADE_SYNC_WINDOW"

    move-object/from16 v0, v19

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_1

    .line 130
    const-string v19, "account"

    move-object/from16 v0, p1

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 131
    .restart local v4    # "account":Ljava/lang/String;
    move-object/from16 v0, p0

    invoke-static {v0, v4}, Lcom/google/android/gm/provider/MailEngine;->getOrMakeMailEngineSync(Landroid/content/Context;Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Lcom/google/android/gm/provider/MailEngine;->getMailSync()Lcom/google/android/gm/provider/MailSync;

    move-result-object v13

    .line 133
    .local v13, "mailSync":Lcom/google/android/gm/provider/MailSync;
    invoke-static/range {p0 .. p0}, Lcom/google/android/gm/provider/Gmail;->getDefaultConversationAgeDays(Landroid/content/Context;)J

    move-result-wide v15

    .line 134
    .local v15, "targetDays":J
    invoke-virtual {v13}, Lcom/google/android/gm/provider/MailSync;->getConversationAgeDays()J

    move-result-wide v7

    .line 136
    .local v7, "currDays":J
    cmp-long v19, v7, v15

    if-gez v19, :cond_1

    .line 137
    invoke-static {}, Lcom/google/android/gm/persistence/Persistence;->getInstance()Lcom/google/android/gm/persistence/Persistence;

    move-result-object v19

    const/16 v20, 0x1

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    move/from16 v2, v20

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gm/persistence/Persistence;->setUpgradeSyncWindow(Landroid/content/Context;Z)V

    .line 138
    new-instance v19, Landroid/content/Intent;

    const-string v20, "com.google.android.gm.intent.ACTION_DISPLAY_SYNC_WINDOW_UPGRADE"

    invoke-direct/range {v19 .. v20}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/google/android/gm/MailIntentService;->sendBroadcast(Landroid/content/Intent;)V
    :try_end_1
    .catch Landroid/database/SQLException; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_0
.end method
