.class Lcom/google/android/gm/persistence/Persistence$MailEnginePreferences;
.super Ljava/lang/Object;
.source "Persistence.java"

# interfaces
.implements Lcom/google/android/gm/provider/MailEngine$Preferences;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gm/persistence/Persistence;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "MailEnginePreferences"
.end annotation


# instance fields
.field private final mContext:Landroid/content/Context;


# direct methods
.method constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 1585
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 1586
    iput-object p1, p0, Lcom/google/android/gm/persistence/Persistence$MailEnginePreferences;->mContext:Landroid/content/Context;

    .line 1587
    return-void
.end method


# virtual methods
.method public getFullTextSearchEnabled(Ljava/lang/String;)Z
    .locals 2
    .param p1, "account"    # Ljava/lang/String;

    .prologue
    .line 1596
    invoke-static {}, Lcom/google/android/gm/persistence/Persistence;->getInstance()Lcom/google/android/gm/persistence/Persistence;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gm/persistence/Persistence$MailEnginePreferences;->mContext:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lcom/google/android/gm/persistence/Persistence;->fullTextSearchEnabled(Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method public getPrefetchAttachments(Ljava/lang/String;)Z
    .locals 2
    .param p1, "account"    # Ljava/lang/String;

    .prologue
    .line 1591
    invoke-static {}, Lcom/google/android/gm/persistence/Persistence;->getInstance()Lcom/google/android/gm/persistence/Persistence;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gm/persistence/Persistence$MailEnginePreferences;->mContext:Landroid/content/Context;

    invoke-virtual {v0, v1, p1}, Lcom/google/android/gm/persistence/Persistence;->getPrefetchAttachments(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    return v0
.end method
