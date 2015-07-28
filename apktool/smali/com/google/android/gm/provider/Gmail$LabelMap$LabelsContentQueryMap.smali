.class Lcom/google/android/gm/provider/Gmail$LabelMap$LabelsContentQueryMap;
.super Landroid/content/ContentQueryMap;
.source "Gmail.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gm/provider/Gmail$LabelMap;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "LabelsContentQueryMap"
.end annotation


# direct methods
.method public constructor <init>(Landroid/database/Cursor;Ljava/lang/String;)V
    .locals 2
    .param p1, "cursor"    # Landroid/database/Cursor;
    .param p2, "columnNameOfKey"    # Ljava/lang/String;

    .prologue
    .line 2487
    const/4 v0, 0x1

    const/4 v1, 0x0

    invoke-direct {p0, p1, p2, v0, v1}, Landroid/content/ContentQueryMap;-><init>(Landroid/database/Cursor;Ljava/lang/String;ZLandroid/os/Handler;)V

    .line 2491
    const/4 v0, 0x0

    invoke-super {p0, v0}, Landroid/content/ContentQueryMap;->setKeepUpdated(Z)V

    .line 2492
    return-void
.end method


# virtual methods
.method public setKeepUpdated(Z)V
    .locals 0
    .param p1, "keepUpdated"    # Z

    .prologue
    .line 2502
    return-void
.end method
