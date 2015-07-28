.class public Lcom/android/mail/widget/GmailWidgetService;
.super Lcom/android/mail/widget/WidgetService;
.source "GmailWidgetService.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/android/mail/widget/WidgetService;-><init>()V

    return-void
.end method

.method public static configureValidAccountWidget(Landroid/content/Context;Landroid/widget/RemoteViews;ILcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;Ljava/lang/String;Ljava/lang/Class;)V
    .locals 7
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
    const/4 v5, 0x1

    const v4, 0x7f10010b

    const/16 v1, 0x8

    const v3, 0x7f10010d

    const/4 v2, 0x0

    .line 41
    invoke-static {p0, p3, p4}, Lcom/android/mail/widget/GmailWidgetService;->isFolderSynchronized(Landroid/content/Context;Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;)Z

    move-result v0

    .line 43
    if-eqz v0, :cond_0

    .line 44
    invoke-virtual {p1, v4, v2}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 45
    invoke-virtual {p1, v3, v1}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 46
    const-class v6, Lcom/android/mail/widget/GmailWidgetService;

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    invoke-static/range {v0 .. v6}, Lcom/android/mail/widget/WidgetService;->configureValidAccountWidget(Landroid/content/Context;Landroid/widget/RemoteViews;ILcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;Ljava/lang/String;Ljava/lang/Class;)V

    .line 74
    :goto_0
    return-void

    .line 50
    :cond_0
    invoke-virtual {p1, v4, v1}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 51
    invoke-virtual {p1, v3, v2}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 53
    invoke-virtual {p1, v4, v1}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 54
    invoke-virtual {p1, v3, v2}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 58
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/google/android/gm/LabelSynchronizationActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 59
    const-string v1, "account"

    invoke-virtual {v0, v1, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 60
    const-string v1, "folder"

    invoke-virtual {v0, v1, p4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 61
    const-string v1, "update-widgetid-on-sync-change"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 63
    const-string v1, "perform-actions-internally"

    invoke-virtual {v0, v1, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 64
    invoke-virtual {v0, v5}, Landroid/content/Intent;->toUri(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 65
    const v1, 0x58008000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 68
    const/high16 v1, 0x8000000

    invoke-static {p0, v2, v0, v1}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v0

    .line 70
    invoke-virtual {p1, v3, v0}, Landroid/widget/RemoteViews;->setOnClickPendingIntent(ILandroid/app/PendingIntent;)V

    .line 72
    const-class v6, Lcom/android/mail/widget/GmailWidgetService;

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    invoke-static/range {v0 .. v6}, Lcom/android/mail/widget/GmailWidgetService;->configureValidWidgetIntents(Landroid/content/Context;Landroid/widget/RemoteViews;ILcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;Ljava/lang/String;Ljava/lang/Class;)V

    goto :goto_0
.end method

.method private static isFolderSynchronized(Landroid/content/Context;Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;)Z
    .locals 6
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "account"    # Lcom/android/mail/providers/Account;
    .param p2, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 84
    iget-object v5, p2, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    invoke-virtual {v5}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v0

    .line 86
    .local v0, "canonicalName":Ljava/lang/String;
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    .line 87
    .local v2, "resolver":Landroid/content/ContentResolver;
    invoke-static {v2}, Lcom/google/android/gm/comm/longshadow/LongShadowUtils;->getContentProviderMailAccess(Landroid/content/ContentResolver;)Lcom/google/android/gm/provider/Gmail;

    move-result-object v1

    .line 90
    .local v1, "gm":Lcom/google/android/gm/provider/Gmail;
    iget-object v5, p1, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-virtual {v1, p0, v5}, Lcom/google/android/gm/provider/Gmail;->getSettings(Landroid/content/Context;Ljava/lang/String;)Lcom/google/android/gm/provider/Gmail$Settings;

    move-result-object v3

    .line 91
    .local v3, "settings":Lcom/google/android/gm/provider/Gmail$Settings;
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v4

    .line 94
    .local v4, "synchronizedLabelsSet":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-virtual {v3}, Lcom/google/android/gm/provider/Gmail$Settings;->getLabelsIncluded()Ljava/util/List;

    move-result-object v5

    invoke-interface {v4, v5}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    .line 95
    invoke-virtual {v3}, Lcom/google/android/gm/provider/Gmail$Settings;->getLabelsPartial()Ljava/util/List;

    move-result-object v5

    invoke-interface {v4, v5}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    .line 97
    invoke-interface {v4, v0}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v5

    return v5
.end method


# virtual methods
.method protected configureValidAccountWidget(Landroid/content/Context;Landroid/widget/RemoteViews;ILcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;Ljava/lang/String;)V
    .locals 7

    .prologue
    .line 31
    const-class v6, Lcom/android/mail/widget/GmailWidgetService;

    move-object v0, p1

    move-object v1, p2

    move v2, p3

    move-object v3, p4

    move-object v4, p5

    move-object v5, p6

    invoke-static/range {v0 .. v6}, Lcom/android/mail/widget/GmailWidgetService;->configureValidAccountWidget(Landroid/content/Context;Landroid/widget/RemoteViews;ILcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;Ljava/lang/String;Ljava/lang/Class;)V

    .line 33
    return-void
.end method

.method protected isAccountValid(Landroid/content/Context;Lcom/android/mail/providers/Account;)Z
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "account"    # Lcom/android/mail/providers/Account;

    .prologue
    .line 79
    invoke-static {p1, p2}, Lcom/google/android/gm/Utils;->isAccountValid(Landroid/content/Context;Lcom/android/mail/providers/Account;)Z

    move-result v0

    return v0
.end method
