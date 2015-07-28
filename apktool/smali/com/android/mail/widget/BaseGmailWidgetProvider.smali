.class public Lcom/android/mail/widget/BaseGmailWidgetProvider;
.super Lcom/android/mail/widget/BaseWidgetProvider;
.source "BaseGmailWidgetProvider.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Lcom/android/mail/widget/BaseWidgetProvider;-><init>()V

    return-void
.end method


# virtual methods
.method protected configureValidAccountWidget(Landroid/content/Context;Landroid/widget/RemoteViews;ILcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;Ljava/lang/String;)V
    .locals 7

    .prologue
    .line 68
    iget-object v5, p5, Lcom/android/mail/providers/Folder;->name:Ljava/lang/String;

    const-class v6, Lcom/android/mail/widget/GmailWidgetService;

    move-object v0, p1

    move-object v1, p2

    move v2, p3

    move-object v3, p4

    move-object v4, p5

    invoke-static/range {v0 .. v6}, Lcom/android/mail/widget/GmailWidgetService;->configureValidAccountWidget(Landroid/content/Context;Landroid/widget/RemoteViews;ILcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;Ljava/lang/String;Ljava/lang/Class;)V

    .line 70
    return-void
.end method

.method protected getCurrentWidgetIds(Landroid/content/Context;)[I
    .locals 7
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 34
    invoke-static {p1}, Landroid/appwidget/AppWidgetManager;->getInstance(Landroid/content/Context;)Landroid/appwidget/AppWidgetManager;

    move-result-object v0

    .line 35
    .local v0, "appWidgetManager":Landroid/appwidget/AppWidgetManager;
    new-instance v1, Landroid/content/ComponentName;

    const-string v5, "com.google.android.gm.widget.GmailWidgetProvider"

    invoke-direct {v1, p1, v5}, Landroid/content/ComponentName;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 37
    .local v1, "gmailComponent":Landroid/content/ComponentName;
    new-instance v3, Landroid/content/ComponentName;

    const-string v5, "com.google.android.gm.widget.GoogleMailWidgetProvider"

    invoke-direct {v3, p1, v5}, Landroid/content/ComponentName;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 39
    .local v3, "googleMailComponent":Landroid/content/ComponentName;
    invoke-virtual {v0, v1}, Landroid/appwidget/AppWidgetManager;->getAppWidgetIds(Landroid/content/ComponentName;)[I

    move-result-object v2

    .line 40
    .local v2, "gmailWidgetIds":[I
    invoke-virtual {v0, v3}, Landroid/appwidget/AppWidgetManager;->getAppWidgetIds(Landroid/content/ComponentName;)[I

    move-result-object v4

    .line 41
    .local v4, "googleMailWidgetIds":[I
    const/4 v5, 0x2

    new-array v5, v5, [[I

    const/4 v6, 0x0

    aput-object v2, v5, v6

    const/4 v6, 0x1

    aput-object v4, v5, v6

    invoke-static {v5}, Lcom/google/common/primitives/Ints;->concat([[I)[I

    move-result-object v5

    return-object v5
.end method

.method protected isAccountValid(Landroid/content/Context;Lcom/android/mail/providers/Account;)Z
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "account"    # Lcom/android/mail/providers/Account;

    .prologue
    .line 91
    invoke-static {p1, p2}, Lcom/google/android/gm/Utils;->isAccountValid(Landroid/content/Context;Lcom/android/mail/providers/Account;)Z

    move-result v0

    return v0
.end method

.method protected migrateLegacyWidgetInformation(Landroid/content/Context;I)V
    .locals 12
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "widgetId"    # I

    .prologue
    const/4 v11, 0x0

    .line 97
    invoke-static {p1}, Lcom/google/android/gm/persistence/Persistence;->getPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v6

    .line 98
    .local v6, "preferences":Landroid/content/SharedPreferences;
    invoke-interface {v6}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    .line 100
    .local v2, "editor":Landroid/content/SharedPreferences$Editor;
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "widget-account-"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 103
    .local v4, "legacyPreferenceKey":Ljava/lang/String;
    invoke-interface {v6, v4, v11}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 106
    .local v1, "accountLabel":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 107
    const-string v9, " "

    invoke-static {v1, v9}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v5

    .line 112
    .local v5, "parsedInfo":[Ljava/lang/String;
    array-length v9, v5

    const/4 v10, 0x2

    if-ne v9, v10, :cond_1

    .line 113
    const/4 v9, 0x0

    aget-object v0, v5, v9

    .line 114
    .local v0, "account":Ljava/lang/String;
    const/4 v9, 0x1

    aget-object v3, v5, v9

    .line 120
    .local v3, "label":Ljava/lang/String;
    :goto_0
    invoke-static {p1, v0}, Lcom/google/android/gm/provider/UiProvider;->getAccountObject(Landroid/content/Context;Ljava/lang/String;)Lcom/android/mail/providers/Account;

    move-result-object v7

    .line 121
    .local v7, "uiAccount":Lcom/android/mail/providers/Account;
    invoke-static {p1, v11, v0, v3}, Lcom/google/android/gm/provider/UiProvider;->getSparseFolderObject(Landroid/content/Context;Lcom/google/android/gm/provider/MailEngine;Ljava/lang/String;Ljava/lang/String;)Lcom/android/mail/providers/Folder;

    move-result-object v8

    .line 125
    .local v8, "uiFolder":Lcom/android/mail/providers/Folder;
    if-eqz v7, :cond_0

    if-eqz v8, :cond_0

    .line 126
    invoke-static {p1, p2, v7, v8}, Lcom/android/mail/widget/WidgetService;->saveWidgetInformation(Landroid/content/Context;ILcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;)V

    .line 128
    invoke-virtual {p0, p1, p2, v7, v8}, Lcom/android/mail/widget/BaseGmailWidgetProvider;->updateWidgetInternal(Landroid/content/Context;ILcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;)V

    .line 131
    invoke-interface {v2, v4}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 135
    .end local v0    # "account":Ljava/lang/String;
    .end local v3    # "label":Ljava/lang/String;
    .end local v5    # "parsedInfo":[Ljava/lang/String;
    .end local v7    # "uiAccount":Lcom/android/mail/providers/Account;
    .end local v8    # "uiFolder":Lcom/android/mail/providers/Folder;
    :cond_0
    invoke-interface {v2}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 136
    return-void

    .line 116
    .restart local v5    # "parsedInfo":[Ljava/lang/String;
    :cond_1
    move-object v0, v1

    .line 117
    .restart local v0    # "account":Ljava/lang/String;
    invoke-static {p1, v0}, Lcom/google/android/gm/persistence/Persistence;->getAccountInbox(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .restart local v3    # "label":Ljava/lang/String;
    goto :goto_0
.end method

.method public onDeleted(Landroid/content/Context;[I)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "appWidgetIds"    # [I

    .prologue
    .line 77
    invoke-super {p0, p1, p2}, Lcom/android/mail/widget/BaseWidgetProvider;->onDeleted(Landroid/content/Context;[I)V

    .line 80
    invoke-static {p1}, Lcom/google/android/gm/persistence/Persistence;->getPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v2

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 81
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v2, p2

    if-ge v1, v2, :cond_0

    .line 83
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

    .line 81
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 85
    :cond_0
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 87
    return-void
.end method

.method protected updateWidgetInternal(Landroid/content/Context;ILcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;)V
    .locals 8
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "appWidgetId"    # I
    .param p3, "account"    # Lcom/android/mail/providers/Account;
    .param p4, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 50
    new-instance v2, Landroid/widget/RemoteViews;

    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    const v1, 0x7f04007a

    invoke-direct {v2, v0, v1}, Landroid/widget/RemoteViews;-><init>(Ljava/lang/String;I)V

    .line 51
    .local v2, "remoteViews":Landroid/widget/RemoteViews;
    invoke-virtual {p0, p1, p3}, Lcom/android/mail/widget/BaseGmailWidgetProvider;->isAccountValid(Landroid/content/Context;Lcom/android/mail/providers/Account;)Z

    move-result v7

    .line 53
    .local v7, "isAccountValid":Z
    if-nez v7, :cond_0

    .line 54
    invoke-super {p0, p1, p2, p3, p4}, Lcom/android/mail/widget/BaseWidgetProvider;->updateWidgetInternal(Landroid/content/Context;ILcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;)V

    .line 59
    :goto_0
    invoke-static {p1}, Landroid/appwidget/AppWidgetManager;->getInstance(Landroid/content/Context;)Landroid/appwidget/AppWidgetManager;

    move-result-object v0

    invoke-virtual {v0, p2, v2}, Landroid/appwidget/AppWidgetManager;->updateAppWidget(ILandroid/widget/RemoteViews;)V

    .line 60
    return-void

    .line 56
    :cond_0
    iget-object v6, p4, Lcom/android/mail/providers/Folder;->name:Ljava/lang/String;

    move-object v0, p0

    move-object v1, p1

    move v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-virtual/range {v0 .. v6}, Lcom/android/mail/widget/BaseGmailWidgetProvider;->configureValidAccountWidget(Landroid/content/Context;Landroid/widget/RemoteViews;ILcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;Ljava/lang/String;)V

    goto :goto_0
.end method
