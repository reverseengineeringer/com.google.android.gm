.class public abstract Lcom/android/mail/widget/BaseWidgetProvider;
.super Landroid/appwidget/AppWidgetProvider;
.source "BaseWidgetProvider.java"


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 63
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/widget/BaseWidgetProvider;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 50
    invoke-direct {p0}, Landroid/appwidget/AppWidgetProvider;-><init>()V

    return-void
.end method

.method private isWidgetConfigured(Landroid/content/Context;I)Z
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "widgetId"    # I

    .prologue
    .line 325
    invoke-static {p1}, Lcom/android/mail/persistence/Persistence;->getPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 326
    .local v0, "pref":Landroid/content/SharedPreferences;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "widget-account-"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private final migrateAllLegacyWidgetInformation(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 330
    invoke-virtual {p0, p1}, Lcom/android/mail/widget/BaseWidgetProvider;->getCurrentWidgetIds(Landroid/content/Context;)[I

    move-result-object v0

    .line 331
    .local v0, "currentWidgetIds":[I
    invoke-direct {p0, p1, v0}, Lcom/android/mail/widget/BaseWidgetProvider;->migrateLegacyWidgets(Landroid/content/Context;[I)V

    .line 332
    return-void
.end method

.method private final migrateLegacyWidgets(Landroid/content/Context;[I)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "widgetIds"    # [I

    .prologue
    .line 335
    move-object v0, p2

    .local v0, "arr$":[I
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_1

    aget v3, v0, v1

    .line 338
    .local v3, "widgetId":I
    invoke-direct {p0, p1, v3}, Lcom/android/mail/widget/BaseWidgetProvider;->isWidgetConfigured(Landroid/content/Context;I)Z

    move-result v4

    if-nez v4, :cond_0

    .line 339
    invoke-virtual {p0, p1, v3}, Lcom/android/mail/widget/BaseWidgetProvider;->migrateLegacyWidgetInformation(Landroid/content/Context;I)V

    .line 335
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 342
    .end local v3    # "widgetId":I
    :cond_1
    return-void
.end method

.method public static updateWidget(Landroid/content/Context;ILcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;)V
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "appWidgetId"    # I
    .param p2, "account"    # Lcom/android/mail/providers/Account;
    .param p3, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 261
    if-eqz p2, :cond_0

    if-nez p3, :cond_1

    .line 262
    :cond_0
    sget-object v1, Lcom/android/mail/widget/BaseWidgetProvider;->LOG_TAG:Ljava/lang/String;

    const-string v2, "Missing account or folder.  account: %s folder %s"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p2, v3, v4

    const/4 v4, 0x1

    aput-object p3, v3, v4

    invoke-static {v1, v2, v3}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 274
    :goto_0
    return-void

    .line 266
    :cond_1
    new-instance v0, Landroid/content/Intent;

    const-string v1, "com.android.mail.ACTION_UPDATE_WIDGET"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 268
    .local v0, "updateWidgetIntent":Landroid/content/Intent;
    iget-object v1, p2, Lcom/android/mail/providers/Account;->mimeType:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 269
    const-string v1, "widgetId"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 270
    const-string v1, "account"

    invoke-virtual {p2}, Lcom/android/mail/providers/Account;->serialize()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 271
    const-string v1, "folder"

    invoke-static {p3}, Lcom/android/mail/providers/Folder;->toString(Lcom/android/mail/providers/Folder;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 273
    invoke-virtual {p0, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    goto :goto_0
.end method


# virtual methods
.method protected configureValidAccountWidget(Landroid/content/Context;Landroid/widget/RemoteViews;ILcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;Ljava/lang/String;)V
    .locals 7

    .prologue
    .line 320
    const-class v6, Lcom/android/mail/widget/WidgetService;

    move-object v0, p1

    move-object v1, p2

    move v2, p3

    move-object v3, p4

    move-object v4, p5

    move-object v5, p6

    invoke-static/range {v0 .. v6}, Lcom/android/mail/widget/WidgetService;->configureValidAccountWidget(Landroid/content/Context;Landroid/widget/RemoteViews;ILcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;Ljava/lang/String;Ljava/lang/Class;)V

    .line 322
    return-void
.end method

.method protected getAccountObject(Landroid/content/Context;Ljava/lang/String;)Lcom/android/mail/providers/Account;
    .locals 8
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "accountUri"    # Ljava/lang/String;

    .prologue
    .line 237
    invoke-virtual {p1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    .line 238
    .local v0, "resolver":Landroid/content/ContentResolver;
    const/4 v6, 0x0

    .line 239
    .local v6, "account":Lcom/android/mail/providers/Account;
    const/4 v7, 0x0

    .line 241
    .local v7, "accountCursor":Landroid/database/Cursor;
    :try_start_0
    invoke-static {p2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    sget-object v2, Lcom/android/mail/providers/UIProvider;->ACCOUNTS_PROJECTION:[Ljava/lang/String;

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v7

    .line 243
    if-eqz v7, :cond_0

    .line 244
    invoke-interface {v7}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 245
    new-instance v6, Lcom/android/mail/providers/Account;

    .end local v6    # "account":Lcom/android/mail/providers/Account;
    invoke-direct {v6, v7}, Lcom/android/mail/providers/Account;-><init>(Landroid/database/Cursor;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 249
    .restart local v6    # "account":Lcom/android/mail/providers/Account;
    :cond_0
    if-eqz v7, :cond_1

    .line 250
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    .line 253
    :cond_1
    return-object v6

    .line 249
    .end local v6    # "account":Lcom/android/mail/providers/Account;
    :catchall_0
    move-exception v1

    if-eqz v7, :cond_2

    .line 250
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    :cond_2
    throw v1
.end method

.method protected getCurrentWidgetIds(Landroid/content/Context;)[I
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 88
    invoke-static {p1}, Landroid/appwidget/AppWidgetManager;->getInstance(Landroid/content/Context;)Landroid/appwidget/AppWidgetManager;

    move-result-object v0

    .line 89
    .local v0, "appWidgetManager":Landroid/appwidget/AppWidgetManager;
    new-instance v1, Landroid/content/ComponentName;

    const-string v2, "com.android.mail.widget.WidgetProvider"

    invoke-direct {v1, p1, v2}, Landroid/content/ComponentName;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 91
    .local v1, "mailComponent":Landroid/content/ComponentName;
    invoke-virtual {v0, v1}, Landroid/appwidget/AppWidgetManager;->getAppWidgetIds(Landroid/content/ComponentName;)[I

    move-result-object v2

    return-object v2
.end method

.method protected isAccountValid(Landroid/content/Context;Lcom/android/mail/providers/Account;)Z
    .locals 7
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "account"    # Lcom/android/mail/providers/Account;

    .prologue
    .line 307
    if-eqz p2, :cond_1

    .line 308
    invoke-static {p1}, Lcom/android/mail/utils/AccountUtils;->getSyncingAccounts(Landroid/content/Context;)[Lcom/android/mail/providers/Account;

    move-result-object v0

    .line 309
    .local v0, "accounts":[Lcom/android/mail/providers/Account;
    move-object v1, v0

    .local v1, "arr$":[Lcom/android/mail/providers/Account;
    array-length v4, v1

    .local v4, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v4, :cond_1

    aget-object v2, v1, v3

    .line 310
    .local v2, "existing":Lcom/android/mail/providers/Account;
    if-eqz p2, :cond_0

    if-eqz v2, :cond_0

    iget-object v5, p2, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    iget-object v6, v2, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    invoke-virtual {v5, v6}, Landroid/net/Uri;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 311
    const/4 v5, 0x1

    .line 315
    .end local v0    # "accounts":[Lcom/android/mail/providers/Account;
    .end local v1    # "arr$":[Lcom/android/mail/providers/Account;
    .end local v2    # "existing":Lcom/android/mail/providers/Account;
    .end local v3    # "i$":I
    .end local v4    # "len$":I
    :goto_1
    return v5

    .line 309
    .restart local v0    # "accounts":[Lcom/android/mail/providers/Account;
    .restart local v1    # "arr$":[Lcom/android/mail/providers/Account;
    .restart local v2    # "existing":Lcom/android/mail/providers/Account;
    .restart local v3    # "i$":I
    .restart local v4    # "len$":I
    :cond_0
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 315
    .end local v0    # "accounts":[Lcom/android/mail/providers/Account;
    .end local v1    # "arr$":[Lcom/android/mail/providers/Account;
    .end local v2    # "existing":Lcom/android/mail/providers/Account;
    .end local v3    # "i$":I
    .end local v4    # "len$":I
    :cond_1
    const/4 v5, 0x0

    goto :goto_1
.end method

.method protected abstract migrateLegacyWidgetInformation(Landroid/content/Context;I)V
.end method

.method public onDeleted(Landroid/content/Context;[I)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "appWidgetIds"    # [I

    .prologue
    .line 70
    invoke-super {p0, p1, p2}, Landroid/appwidget/AppWidgetProvider;->onDeleted(Landroid/content/Context;[I)V

    .line 73
    invoke-static {p1}, Lcom/android/mail/persistence/Persistence;->getPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v2

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 74
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v2, p2

    if-ge v1, v2, :cond_0

    .line 76
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "widget-account-"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    aget v3, p2, v1

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v2}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 74
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 78
    :cond_0
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 80
    return-void
.end method

.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 24
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 120
    invoke-direct/range {p0 .. p1}, Lcom/android/mail/widget/BaseWidgetProvider;->migrateAllLegacyWidgetInformation(Landroid/content/Context;)V

    .line 122
    invoke-super/range {p0 .. p2}, Landroid/appwidget/AppWidgetProvider;->onReceive(Landroid/content/Context;Landroid/content/Intent;)V

    .line 123
    sget-object v20, Lcom/android/mail/widget/BaseWidgetProvider;->LOG_TAG:Ljava/lang/String;

    const-string v21, "BaseWidgetProvider.onReceive: %s"

    const/16 v22, 0x1

    move/from16 v0, v22

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v22, v0

    const/16 v23, 0x0

    aput-object p2, v22, v23

    invoke-static/range {v20 .. v22}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 125
    invoke-virtual/range {p2 .. p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v6

    .line 126
    .local v6, "action":Ljava/lang/String;
    const-string v20, "com.android.mail.ACTION_UPDATE_WIDGET"

    move-object/from16 v0, v20

    invoke-virtual {v0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v20

    if-eqz v20, :cond_1

    .line 127
    const-string v20, "widgetId"

    const/16 v21, -0x1

    move-object/from16 v0, p2

    move-object/from16 v1, v20

    move/from16 v2, v21

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v17

    .line 128
    .local v17, "widgetId":I
    const-string v20, "account"

    move-object/from16 v0, p2

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    invoke-static/range {v20 .. v20}, Lcom/android/mail/providers/Account;->newinstance(Ljava/lang/String;)Lcom/android/mail/providers/Account;

    move-result-object v3

    .line 129
    .local v3, "account":Lcom/android/mail/providers/Account;
    const-string v20, "folder"

    move-object/from16 v0, p2

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    invoke-static/range {v20 .. v20}, Lcom/android/mail/providers/Folder;->fromString(Ljava/lang/String;)Lcom/android/mail/providers/Folder;

    move-result-object v9

    .line 130
    .local v9, "folder":Lcom/android/mail/providers/Folder;
    const/16 v20, -0x1

    move/from16 v0, v17

    move/from16 v1, v20

    if-eq v0, v1, :cond_0

    if-eqz v3, :cond_0

    if-eqz v9, :cond_0

    .line 131
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move/from16 v2, v17

    invoke-virtual {v0, v1, v2, v3, v9}, Lcom/android/mail/widget/BaseWidgetProvider;->updateWidgetInternal(Landroid/content/Context;ILcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;)V

    .line 174
    .end local v3    # "account":Lcom/android/mail/providers/Account;
    .end local v9    # "folder":Lcom/android/mail/providers/Folder;
    .end local v17    # "widgetId":I
    :cond_0
    :goto_0
    return-void

    .line 133
    :cond_1
    const-string v20, "com.android.mail.ACTION_NOTIFY_DATASET_CHANGED"

    move-object/from16 v0, v20

    invoke-virtual {v0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v20

    if-eqz v20, :cond_0

    .line 135
    invoke-virtual/range {p2 .. p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v8

    .line 136
    .local v8, "extras":Landroid/os/Bundle;
    const-string v20, "accountUri"

    move-object/from16 v0, v20

    invoke-virtual {v8, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v5

    check-cast v5, Landroid/net/Uri;

    .line 137
    .local v5, "accountUri":Landroid/net/Uri;
    const-string v20, "folderUri"

    move-object/from16 v0, v20

    invoke-virtual {v8, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v10

    check-cast v10, Landroid/net/Uri;

    .line 138
    .local v10, "folderUri":Landroid/net/Uri;
    const-string v20, "update-all-widgets"

    const/16 v21, 0x0

    move-object/from16 v0, v20

    move/from16 v1, v21

    invoke-virtual {v8, v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v15

    .line 140
    .local v15, "updateAllWidgets":Z
    if-nez v5, :cond_2

    if-nez v10, :cond_2

    if-eqz v15, :cond_0

    .line 143
    :cond_2
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v19

    .line 144
    .local v19, "widgetsToUpdate":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Integer;>;"
    invoke-virtual/range {p0 .. p1}, Lcom/android/mail/widget/BaseWidgetProvider;->getCurrentWidgetIds(Landroid/content/Context;)[I

    move-result-object v7

    .local v7, "arr$":[I
    array-length v13, v7

    .local v13, "len$":I
    const/4 v11, 0x0

    .local v11, "i$":I
    :goto_1
    if-ge v11, v13, :cond_6

    aget v12, v7, v11

    .line 147
    .local v12, "id":I
    invoke-static/range {p1 .. p1}, Lcom/android/mail/persistence/Persistence;->getPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v20

    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "widget-account-"

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v0, v12}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    const/16 v22, 0x0

    invoke-interface/range {v20 .. v22}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 150
    .local v4, "accountFolder":Ljava/lang/String;
    if-eqz v4, :cond_4

    .line 151
    const-string v20, " "

    move-object/from16 v0, v20

    invoke-static {v4, v0}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v14

    .line 153
    .local v14, "parsedInfo":[Ljava/lang/String;
    move/from16 v16, v15

    .line 154
    .local v16, "updateThis":Z
    if-nez v16, :cond_3

    .line 155
    if-eqz v5, :cond_5

    invoke-virtual {v5}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v20

    const/16 v21, 0x0

    aget-object v21, v14, v21

    invoke-static/range {v20 .. v21}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v20

    if-eqz v20, :cond_5

    .line 157
    const/16 v16, 0x1

    .line 163
    :cond_3
    :goto_2
    if-eqz v16, :cond_4

    .line 164
    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v20

    invoke-interface/range {v19 .. v20}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 144
    .end local v14    # "parsedInfo":[Ljava/lang/String;
    .end local v16    # "updateThis":Z
    :cond_4
    add-int/lit8 v11, v11, 0x1

    goto :goto_1

    .line 158
    .restart local v14    # "parsedInfo":[Ljava/lang/String;
    .restart local v16    # "updateThis":Z
    :cond_5
    if-eqz v10, :cond_3

    invoke-virtual {v10}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v20

    const/16 v21, 0x1

    aget-object v21, v14, v21

    invoke-static/range {v20 .. v21}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v20

    if-eqz v20, :cond_3

    .line 160
    const/16 v16, 0x1

    goto :goto_2

    .line 168
    .end local v4    # "accountFolder":Ljava/lang/String;
    .end local v12    # "id":I
    .end local v14    # "parsedInfo":[Ljava/lang/String;
    .end local v16    # "updateThis":Z
    :cond_6
    invoke-interface/range {v19 .. v19}, Ljava/util/Set;->size()I

    move-result v20

    if-lez v20, :cond_0

    .line 169
    invoke-static/range {v19 .. v19}, Lcom/google/common/primitives/Ints;->toArray(Ljava/util/Collection;)[I

    move-result-object v18

    .line 170
    .local v18, "widgets":[I
    invoke-static/range {p1 .. p1}, Landroid/appwidget/AppWidgetManager;->getInstance(Landroid/content/Context;)Landroid/appwidget/AppWidgetManager;

    move-result-object v20

    const v21, 0x7f10010b

    move-object/from16 v0, v20

    move-object/from16 v1, v18

    move/from16 v2, v21

    invoke-virtual {v0, v1, v2}, Landroid/appwidget/AppWidgetManager;->notifyAppWidgetViewDataChanged([II)V

    goto/16 :goto_0
.end method

.method public onUpdate(Landroid/content/Context;Landroid/appwidget/AppWidgetManager;[I)V
    .locals 17
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "appWidgetManager"    # Landroid/appwidget/AppWidgetManager;
    .param p3, "appWidgetIds"    # [I

    .prologue
    .line 181
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p3

    invoke-direct {v0, v1, v2}, Lcom/android/mail/widget/BaseWidgetProvider;->migrateLegacyWidgets(Landroid/content/Context;[I)V

    .line 183
    invoke-super/range {p0 .. p3}, Landroid/appwidget/AppWidgetProvider;->onUpdate(Landroid/content/Context;Landroid/appwidget/AppWidgetManager;[I)V

    .line 185
    invoke-virtual/range {p1 .. p1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    .line 186
    .local v3, "resolver":Landroid/content/ContentResolver;
    const/4 v15, 0x0

    .local v15, "i":I
    :goto_0
    move-object/from16 v0, p3

    array-length v4, v0

    if-ge v15, v4, :cond_6

    .line 188
    invoke-static/range {p1 .. p1}, Lcom/android/mail/persistence/Persistence;->getPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v4

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "widget-account-"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    aget v6, p3, v15

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x0

    invoke-interface {v4, v5, v6}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    .line 190
    .local v10, "accountFolder":Ljava/lang/String;
    const/4 v11, 0x0

    .line 191
    .local v11, "accountUri":Ljava/lang/String;
    const/4 v14, 0x0

    .line 192
    .local v14, "folderUri":Ljava/lang/String;
    invoke-static {v10}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 193
    const-string v4, " "

    invoke-static {v10, v4}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v16

    .line 195
    .local v16, "parsedInfo":[Ljava/lang/String;
    move-object/from16 v0, v16

    array-length v4, v0

    const/4 v5, 0x2

    if-ne v4, v5, :cond_4

    .line 196
    const/4 v4, 0x0

    aget-object v11, v16, v4

    .line 197
    const/4 v4, 0x1

    aget-object v14, v16, v4

    .line 211
    .end local v16    # "parsedInfo":[Ljava/lang/String;
    :cond_0
    :goto_1
    const/4 v9, 0x0

    .line 212
    .local v9, "account":Lcom/android/mail/providers/Account;
    invoke-static {v11}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 213
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-virtual {v0, v1, v11}, Lcom/android/mail/widget/BaseWidgetProvider;->getAccountObject(Landroid/content/Context;Ljava/lang/String;)Lcom/android/mail/providers/Account;

    move-result-object v9

    .line 215
    :cond_1
    const/4 v12, 0x0

    .line 216
    .local v12, "folder":Lcom/android/mail/providers/Folder;
    invoke-static {v14}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_3

    .line 217
    const/4 v13, 0x0

    .line 219
    .local v13, "folderCursor":Landroid/database/Cursor;
    :try_start_0
    invoke-static {v14}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    sget-object v5, Lcom/android/mail/providers/UIProvider;->FOLDERS_PROJECTION:[Ljava/lang/String;

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-virtual/range {v3 .. v8}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v13

    .line 221
    if-eqz v13, :cond_2

    .line 222
    invoke-interface {v13}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 223
    new-instance v12, Lcom/android/mail/providers/Folder;

    .end local v12    # "folder":Lcom/android/mail/providers/Folder;
    invoke-direct {v12, v13}, Lcom/android/mail/providers/Folder;-><init>(Landroid/database/Cursor;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 227
    .restart local v12    # "folder":Lcom/android/mail/providers/Folder;
    :cond_2
    if-eqz v13, :cond_3

    .line 228
    invoke-interface {v13}, Landroid/database/Cursor;->close()V

    .line 232
    .end local v13    # "folderCursor":Landroid/database/Cursor;
    :cond_3
    aget v4, p3, v15

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-virtual {v0, v1, v4, v9, v12}, Lcom/android/mail/widget/BaseWidgetProvider;->updateWidgetInternal(Landroid/content/Context;ILcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;)V

    .line 186
    add-int/lit8 v15, v15, 0x1

    goto :goto_0

    .line 201
    .end local v9    # "account":Lcom/android/mail/providers/Account;
    .end local v12    # "folder":Lcom/android/mail/providers/Folder;
    .restart local v16    # "parsedInfo":[Ljava/lang/String;
    :cond_4
    move-object v11, v10

    .line 202
    const/4 v14, 0x0

    goto :goto_1

    .line 227
    .end local v16    # "parsedInfo":[Ljava/lang/String;
    .restart local v9    # "account":Lcom/android/mail/providers/Account;
    .restart local v13    # "folderCursor":Landroid/database/Cursor;
    :catchall_0
    move-exception v4

    if-eqz v13, :cond_5

    .line 228
    invoke-interface {v13}, Landroid/database/Cursor;->close()V

    :cond_5
    throw v4

    .line 234
    .end local v9    # "account":Lcom/android/mail/providers/Account;
    .end local v10    # "accountFolder":Ljava/lang/String;
    .end local v11    # "accountUri":Ljava/lang/String;
    .end local v13    # "folderCursor":Landroid/database/Cursor;
    .end local v14    # "folderUri":Ljava/lang/String;
    :cond_6
    return-void
.end method

.method protected updateWidgetInternal(Landroid/content/Context;ILcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;)V
    .locals 7

    .prologue
    const v5, 0x7f10010c

    const/4 v4, 0x0

    const/16 v3, 0x8

    .line 278
    new-instance v2, Landroid/widget/RemoteViews;

    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    const v1, 0x7f04007a

    invoke-direct {v2, v0, v1}, Landroid/widget/RemoteViews;-><init>(Ljava/lang/String;I)V

    .line 279
    invoke-virtual {p0, p1, p3}, Lcom/android/mail/widget/BaseWidgetProvider;->isAccountValid(Landroid/content/Context;Lcom/android/mail/providers/Account;)Z

    move-result v0

    .line 281
    if-nez v0, :cond_0

    .line 283
    const v0, 0x7f100107

    invoke-virtual {v2, v0, v3}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 284
    const v0, 0x7f100108

    invoke-virtual {v2, v0, v3}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 285
    const v0, 0x7f100109

    invoke-virtual {v2, v0, v3}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 286
    const v0, 0x7f10010a

    invoke-virtual {v2, v0, v3}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 287
    const v0, 0x7f10010b

    invoke-virtual {v2, v0, v3}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 288
    const v0, 0x7f10010d

    invoke-virtual {v2, v0, v3}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 289
    invoke-virtual {v2, v5, v4}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 291
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/android/mail/ui/MailboxSelectionActivity;

    invoke-direct {v0, p1, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 292
    const-string v1, "appWidgetId"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 293
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->toUri(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 294
    const/high16 v1, 0x40000000    # 2.0f

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 295
    const/high16 v1, 0x8000000

    invoke-static {p1, v4, v0, v1}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v0

    .line 297
    invoke-virtual {v2, v5, v0}, Landroid/widget/RemoteViews;->setOnClickPendingIntent(ILandroid/app/PendingIntent;)V

    .line 303
    :goto_0
    invoke-static {p1}, Landroid/appwidget/AppWidgetManager;->getInstance(Landroid/content/Context;)Landroid/appwidget/AppWidgetManager;

    move-result-object v0

    invoke-virtual {v0, p2, v2}, Landroid/appwidget/AppWidgetManager;->updateAppWidget(ILandroid/widget/RemoteViews;)V

    .line 304
    return-void

    .line 300
    :cond_0
    const-string v6, " "

    move-object v0, p0

    move-object v1, p1

    move v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-virtual/range {v0 .. v6}, Lcom/android/mail/widget/BaseWidgetProvider;->configureValidAccountWidget(Landroid/content/Context;Landroid/widget/RemoteViews;ILcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;Ljava/lang/String;)V

    goto :goto_0
.end method
