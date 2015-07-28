.class Lcom/google/android/gm/provider/UiProvider$AccountChangedNotifier;
.super Lcom/android/mail/utils/DelayedTaskHandler;
.source "UiProvider.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gm/provider/UiProvider;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "AccountChangedNotifier"
.end annotation


# instance fields
.field private final mNotificationUri:Landroid/net/Uri;

.field private final mResolver:Landroid/content/ContentResolver;


# direct methods
.method constructor <init>(Landroid/content/Context;Landroid/os/Looper;Ljava/lang/String;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "looper"    # Landroid/os/Looper;
    .param p3, "account"    # Ljava/lang/String;

    .prologue
    .line 3151
    # getter for: Lcom/google/android/gm/provider/UiProvider;->sAccountNotificationDelayMs:I
    invoke-static {}, Lcom/google/android/gm/provider/UiProvider;->access$600()I

    move-result v0

    invoke-direct {p0, p2, v0}, Lcom/android/mail/utils/DelayedTaskHandler;-><init>(Landroid/os/Looper;I)V

    .line 3153
    invoke-virtual {p1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/UiProvider$AccountChangedNotifier;->mResolver:Landroid/content/ContentResolver;

    .line 3154
    # invokes: Lcom/google/android/gm/provider/UiProvider;->getAccountBaseNotificationUri(Ljava/lang/String;)Landroid/net/Uri;
    invoke-static {p3}, Lcom/google/android/gm/provider/UiProvider;->access$700(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/UiProvider$AccountChangedNotifier;->mNotificationUri:Landroid/net/Uri;

    .line 3155
    return-void
.end method


# virtual methods
.method protected performTask()V
    .locals 4

    .prologue
    .line 3159
    iget-object v0, p0, Lcom/google/android/gm/provider/UiProvider$AccountChangedNotifier;->mResolver:Landroid/content/ContentResolver;

    iget-object v1, p0, Lcom/google/android/gm/provider/UiProvider$AccountChangedNotifier;->mNotificationUri:Landroid/net/Uri;

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;Z)V

    .line 3160
    return-void
.end method
