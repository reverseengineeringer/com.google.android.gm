.class public Lcom/android/mail/widget/WidgetService;
.super Landroid/widget/RemoteViewsService;
.source "WidgetService.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/widget/WidgetService$MailFactory;
    }
.end annotation


# static fields
.field private static final LOG_TAG:Ljava/lang/String;

.field private static sWidgetLock:Ljava/lang/Object;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 63
    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/android/mail/widget/WidgetService;->sWidgetLock:Ljava/lang/Object;

    .line 65
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/widget/WidgetService;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 59
    invoke-direct {p0}, Landroid/widget/RemoteViewsService;-><init>()V

    .line 202
    return-void
.end method

.method static synthetic access$000()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 59
    sget-object v0, Lcom/android/mail/widget/WidgetService;->sWidgetLock:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic access$100()Ljava/lang/String;
    .locals 1

    .prologue
    .line 59
    sget-object v0, Lcom/android/mail/widget/WidgetService;->LOG_TAG:Ljava/lang/String;

    return-object v0
.end method

.method public static configureValidAccountWidget(Landroid/content/Context;Landroid/widget/RemoteViews;ILcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;Ljava/lang/String;Ljava/lang/Class;)V
    .locals 8
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "remoteViews"    # Landroid/widget/RemoteViews;
    .param p2, "appWidgetId"    # I
    .param p3, "account"    # Lcom/android/mail/providers/Account;
    .param p4, "folder"    # Lcom/android/mail/providers/Folder;
    .param p5, "folderDisplayName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Landroid/widget/RemoteViews;",
            "I",
            "Lcom/android/mail/providers/Account;",
            "Lcom/android/mail/providers/Folder;",
            "Ljava/lang/String;",
            "Ljava/lang/Class",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .local p6, "widgetService":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const v7, 0x7f100108

    const v6, 0x7f100107

    const/4 v5, 0x0

    .line 85
    invoke-virtual {p1, v6, v5}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 91
    invoke-static {p5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p3, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 92
    :cond_0
    sget-object v0, Lcom/android/mail/widget/WidgetService;->LOG_TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/Error;

    invoke-direct {v1}, Ljava/lang/Error;-><init>()V

    const-string v2, "Empty folder or account name.  account: %s, folder: %s"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    iget-object v4, p3, Landroid/accounts/Account;->name:Ljava/lang/String;

    aput-object v4, v3, v5

    const/4 v4, 0x1

    aput-object p5, v3, v4

    invoke-static {v0, v1, v2, v3}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 96
    :cond_1
    invoke-static {p5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 97
    invoke-virtual {p1, v6, p5}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 99
    :cond_2
    invoke-virtual {p1, v7, v5}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 101
    iget-object v0, p3, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 102
    iget-object v0, p3, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-virtual {p1, v7, v0}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 104
    :cond_3
    const v0, 0x7f100109

    invoke-virtual {p1, v0, v5}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 105
    const v0, 0x7f10010a

    invoke-virtual {p1, v0, v5}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 106
    const v0, 0x7f10010b

    invoke-virtual {p1, v0, v5}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 107
    const v0, 0x7f10010d

    const/16 v1, 0x8

    invoke-virtual {p1, v0, v1}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 109
    invoke-static/range {p0 .. p6}, Lcom/android/mail/widget/WidgetService;->configureValidWidgetIntents(Landroid/content/Context;Landroid/widget/RemoteViews;ILcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;Ljava/lang/String;Ljava/lang/Class;)V

    .line 111
    return-void
.end method

.method public static configureValidWidgetIntents(Landroid/content/Context;Landroid/widget/RemoteViews;ILcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;Ljava/lang/String;Ljava/lang/Class;)V
    .locals 9
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "remoteViews"    # Landroid/widget/RemoteViews;
    .param p2, "appWidgetId"    # I
    .param p3, "account"    # Lcom/android/mail/providers/Account;
    .param p4, "folder"    # Lcom/android/mail/providers/Folder;
    .param p5, "folderDisplayName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Landroid/widget/RemoteViews;",
            "I",
            "Lcom/android/mail/providers/Account;",
            "Lcom/android/mail/providers/Folder;",
            "Ljava/lang/String;",
            "Ljava/lang/Class",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 116
    .local p6, "serviceClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const v6, 0x7f10010c

    const/16 v7, 0x8

    invoke-virtual {p1, v6, v7}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 120
    new-instance v3, Landroid/content/Intent;

    invoke-direct {v3, p0, p6}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 121
    .local v3, "intent":Landroid/content/Intent;
    const-string v6, "appWidgetId"

    invoke-virtual {v3, v6, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 122
    const-string v6, "account"

    invoke-virtual {p3}, Lcom/android/mail/providers/Account;->serialize()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v3, v6, v7}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 123
    const-string v6, "folder"

    invoke-static {p4}, Lcom/android/mail/providers/Folder;->toString(Lcom/android/mail/providers/Folder;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v3, v6, v7}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 124
    const/4 v6, 0x1

    invoke-virtual {v3, v6}, Landroid/content/Intent;->toUri(I)Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v6

    invoke-virtual {v3, v6}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 125
    const v6, 0x7f10010b

    invoke-virtual {p1, v6, v3}, Landroid/widget/RemoteViews;->setRemoteAdapter(ILandroid/content/Intent;)V

    .line 127
    invoke-static {p4, p3}, Lcom/android/mail/utils/Utils;->createViewFolderIntent(Lcom/android/mail/providers/Folder;Lcom/android/mail/providers/Account;)Landroid/content/Intent;

    move-result-object v4

    .line 128
    .local v4, "mailIntent":Landroid/content/Intent;
    const/4 v6, 0x0

    const/high16 v7, 0x8000000

    invoke-static {p0, v6, v4, v7}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v0

    .line 130
    .local v0, "clickIntent":Landroid/app/PendingIntent;
    const v6, 0x7f100105

    invoke-virtual {p1, v6, v0}, Landroid/widget/RemoteViews;->setOnClickPendingIntent(ILandroid/app/PendingIntent;)V

    .line 133
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 134
    .local v1, "composeIntent":Landroid/content/Intent;
    const-string v6, "android.intent.action.SEND"

    invoke-virtual {v1, v6}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 135
    const-string v6, "account"

    invoke-virtual {p3}, Lcom/android/mail/providers/Account;->serialize()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v1, v6, v7}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 136
    iget-object v6, p3, Lcom/android/mail/providers/Account;->composeIntentUri:Landroid/net/Uri;

    invoke-virtual {v1, v6}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 137
    const-string v6, "fromemail"

    const/4 v7, 0x1

    invoke-virtual {v1, v6, v7}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 138
    iget-object v6, p3, Lcom/android/mail/providers/Account;->composeIntentUri:Landroid/net/Uri;

    if-eqz v6, :cond_0

    .line 139
    const-string v6, "composeUri"

    iget-object v7, p3, Lcom/android/mail/providers/Account;->composeIntentUri:Landroid/net/Uri;

    invoke-virtual {v1, v6, v7}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 144
    :cond_0
    invoke-static {p0}, Landroid/support/v4/app/TaskStackBuilder;->create(Landroid/content/Context;)Landroid/support/v4/app/TaskStackBuilder;

    move-result-object v5

    .line 145
    .local v5, "taskStackBuilder":Landroid/support/v4/app/TaskStackBuilder;
    invoke-virtual {v5, v4}, Landroid/support/v4/app/TaskStackBuilder;->addNextIntent(Landroid/content/Intent;)Landroid/support/v4/app/TaskStackBuilder;

    move-result-object v6

    invoke-virtual {v6, v1}, Landroid/support/v4/app/TaskStackBuilder;->addNextIntent(Landroid/content/Intent;)Landroid/support/v4/app/TaskStackBuilder;

    move-result-object v6

    const/4 v7, 0x0

    const/high16 v8, 0x8000000

    invoke-virtual {v6, v7, v8}, Landroid/support/v4/app/TaskStackBuilder;->getPendingIntent(II)Landroid/app/PendingIntent;

    move-result-object v0

    .line 148
    const v6, 0x7f10010a

    invoke-virtual {p1, v6, v0}, Landroid/widget/RemoteViews;->setOnClickPendingIntent(ILandroid/app/PendingIntent;)V

    .line 151
    new-instance v2, Landroid/content/Intent;

    invoke-direct {v2}, Landroid/content/Intent;-><init>()V

    .line 152
    .local v2, "conversationIntent":Landroid/content/Intent;
    const-string v6, "android.intent.action.VIEW"

    invoke-virtual {v2, v6}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 153
    const/4 v6, 0x0

    const/high16 v7, 0x8000000

    invoke-static {p0, v6, v2, v7}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v0

    .line 155
    const v6, 0x7f10010b

    invoke-virtual {p1, v6, v0}, Landroid/widget/RemoteViews;->setPendingIntentTemplate(ILandroid/app/PendingIntent;)V

    .line 156
    return-void
.end method

.method private static createWidgetPreferenceValue(Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;)Ljava/lang/String;
    .locals 2
    .param p0, "account"    # Lcom/android/mail/providers/Account;
    .param p1, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 170
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    invoke-virtual {v1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p1, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    invoke-virtual {v1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static saveWidgetInformation(Landroid/content/Context;ILcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;)V
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "appWidgetId"    # I
    .param p2, "account"    # Lcom/android/mail/providers/Account;
    .param p3, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 163
    invoke-static {p0}, Lcom/android/mail/persistence/Persistence;->getPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 164
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "widget-account-"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {p2, p3}, Lcom/android/mail/widget/WidgetService;->createWidgetPreferenceValue(Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 166
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 167
    return-void
.end method


# virtual methods
.method protected configureValidAccountWidget(Landroid/content/Context;Landroid/widget/RemoteViews;ILcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;Ljava/lang/String;)V
    .locals 7

    .prologue
    .line 75
    const-class v6, Lcom/android/mail/widget/WidgetService;

    move-object v0, p1

    move-object v1, p2

    move v2, p3

    move-object v3, p4

    move-object v4, p5

    move-object v5, p6

    invoke-static/range {v0 .. v6}, Lcom/android/mail/widget/WidgetService;->configureValidAccountWidget(Landroid/content/Context;Landroid/widget/RemoteViews;ILcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;Ljava/lang/String;Ljava/lang/Class;)V

    .line 77
    return-void
.end method

.method protected isAccountValid(Landroid/content/Context;Lcom/android/mail/providers/Account;)Z
    .locals 7
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "account"    # Lcom/android/mail/providers/Account;

    .prologue
    .line 188
    if-eqz p2, :cond_1

    .line 189
    invoke-static {p1}, Lcom/android/mail/utils/AccountUtils;->getSyncingAccounts(Landroid/content/Context;)[Lcom/android/mail/providers/Account;

    move-result-object v0

    .line 190
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

    .line 191
    .local v2, "existing":Lcom/android/mail/providers/Account;
    if-eqz p2, :cond_0

    if-eqz v2, :cond_0

    iget-object v5, p2, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    iget-object v6, v2, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    invoke-virtual {v5, v6}, Landroid/net/Uri;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 192
    const/4 v5, 0x1

    .line 196
    .end local v0    # "accounts":[Lcom/android/mail/providers/Account;
    .end local v1    # "arr$":[Lcom/android/mail/providers/Account;
    .end local v2    # "existing":Lcom/android/mail/providers/Account;
    .end local v3    # "i$":I
    .end local v4    # "len$":I
    :goto_1
    return v5

    .line 190
    .restart local v0    # "accounts":[Lcom/android/mail/providers/Account;
    .restart local v1    # "arr$":[Lcom/android/mail/providers/Account;
    .restart local v2    # "existing":Lcom/android/mail/providers/Account;
    .restart local v3    # "i$":I
    .restart local v4    # "len$":I
    :cond_0
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 196
    .end local v0    # "accounts":[Lcom/android/mail/providers/Account;
    .end local v1    # "arr$":[Lcom/android/mail/providers/Account;
    .end local v2    # "existing":Lcom/android/mail/providers/Account;
    .end local v3    # "i$":I
    .end local v4    # "len$":I
    :cond_1
    const/4 v5, 0x0

    goto :goto_1
.end method

.method public isWidgetConfigured(Landroid/content/Context;ILcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;)Z
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "appWidgetId"    # I
    .param p3, "account"    # Lcom/android/mail/providers/Account;
    .param p4, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    const/4 v0, 0x0

    .line 180
    invoke-virtual {p0, p1, p3}, Lcom/android/mail/widget/WidgetService;->isAccountValid(Landroid/content/Context;Lcom/android/mail/providers/Account;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 181
    invoke-static {p1}, Lcom/android/mail/persistence/Persistence;->getPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "widget-account-"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    const/4 v0, 0x1

    .line 184
    :cond_0
    return v0
.end method

.method public onGetViewFactory(Landroid/content/Intent;)Landroid/widget/RemoteViewsService$RemoteViewsFactory;
    .locals 2
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 69
    new-instance v0, Lcom/android/mail/widget/WidgetService$MailFactory;

    invoke-virtual {p0}, Lcom/android/mail/widget/WidgetService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1, p1, p0}, Lcom/android/mail/widget/WidgetService$MailFactory;-><init>(Landroid/content/Context;Landroid/content/Intent;Lcom/android/mail/widget/WidgetService;)V

    return-object v0
.end method
