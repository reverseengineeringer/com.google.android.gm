.class public abstract Lcom/android/mail/providers/RecentFolderObserver;
.super Landroid/database/DataSetObserver;
.source "RecentFolderObserver.java"


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private mController:Lcom/android/mail/ui/RecentFolderController;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 44
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/providers/RecentFolderObserver;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 50
    invoke-direct {p0}, Landroid/database/DataSetObserver;-><init>()V

    .line 51
    return-void
.end method


# virtual methods
.method public initialize(Lcom/android/mail/ui/RecentFolderController;)Lcom/android/mail/ui/RecentFolderList;
    .locals 3
    .param p1, "controller"    # Lcom/android/mail/ui/RecentFolderController;

    .prologue
    .line 60
    if-nez p1, :cond_0

    .line 61
    sget-object v0, Lcom/android/mail/providers/RecentFolderObserver;->LOG_TAG:Ljava/lang/String;

    const-string v1, "RecentFolderObserver initialized with null controller!"

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->wtf(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 63
    :cond_0
    iput-object p1, p0, Lcom/android/mail/providers/RecentFolderObserver;->mController:Lcom/android/mail/ui/RecentFolderController;

    .line 64
    iget-object v0, p0, Lcom/android/mail/providers/RecentFolderObserver;->mController:Lcom/android/mail/ui/RecentFolderController;

    invoke-interface {v0, p0}, Lcom/android/mail/ui/RecentFolderController;->registerRecentFolderObserver(Landroid/database/DataSetObserver;)V

    .line 65
    iget-object v0, p0, Lcom/android/mail/providers/RecentFolderObserver;->mController:Lcom/android/mail/ui/RecentFolderController;

    invoke-interface {v0}, Lcom/android/mail/ui/RecentFolderController;->getRecentFolders()Lcom/android/mail/ui/RecentFolderList;

    move-result-object v0

    return-object v0
.end method

.method public unregisterAndDestroy()V
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/android/mail/providers/RecentFolderObserver;->mController:Lcom/android/mail/ui/RecentFolderController;

    if-nez v0, :cond_0

    .line 90
    :goto_0
    return-void

    .line 89
    :cond_0
    iget-object v0, p0, Lcom/android/mail/providers/RecentFolderObserver;->mController:Lcom/android/mail/ui/RecentFolderController;

    invoke-interface {v0, p0}, Lcom/android/mail/ui/RecentFolderController;->unregisterRecentFolderObserver(Landroid/database/DataSetObserver;)V

    goto :goto_0
.end method
