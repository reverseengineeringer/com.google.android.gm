.class public Lcom/android/mail/ui/FolderOperation;
.super Ljava/lang/Object;
.source "FolderOperation.java"


# static fields
.field public static final EMPTY:Ljava/util/Collection;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/ui/FolderOperation;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field public mAdd:Z

.field public mFolder:Lcom/android/mail/providers/Folder;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 32
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    sput-object v0, Lcom/android/mail/ui/FolderOperation;->EMPTY:Ljava/util/Collection;

    return-void
.end method

.method public constructor <init>(Lcom/android/mail/providers/Folder;Ljava/lang/Boolean;)V
    .locals 1
    .param p1, "folder"    # Lcom/android/mail/providers/Folder;
    .param p2, "operation"    # Ljava/lang/Boolean;

    .prologue
    .line 36
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 37
    invoke-virtual {p2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    iput-boolean v0, p0, Lcom/android/mail/ui/FolderOperation;->mAdd:Z

    .line 38
    iput-object p1, p0, Lcom/android/mail/ui/FolderOperation;->mFolder:Lcom/android/mail/providers/Folder;

    .line 39
    return-void
.end method

.method public static isDestructive(Ljava/util/Collection;Lcom/android/mail/providers/Folder;)Z
    .locals 5
    .param p1, "folder"    # Lcom/android/mail/providers/Folder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/ui/FolderOperation;",
            ">;",
            "Lcom/android/mail/providers/Folder;",
            ")Z"
        }
    .end annotation

    .prologue
    .local p0, "folderOps":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/ui/FolderOperation;>;"
    const/4 v2, 0x1

    .line 71
    invoke-interface {p0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/mail/ui/FolderOperation;

    .line 72
    .local v1, "op":Lcom/android/mail/ui/FolderOperation;
    iget-object v3, v1, Lcom/android/mail/ui/FolderOperation;->mFolder:Lcom/android/mail/providers/Folder;

    iget-object v3, v3, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    iget-object v4, p1, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    invoke-static {v3, v4}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    iget-boolean v3, v1, Lcom/android/mail/ui/FolderOperation;->mAdd:Z

    if-nez v3, :cond_1

    .line 79
    .end local v1    # "op":Lcom/android/mail/ui/FolderOperation;
    :goto_0
    return v2

    .line 75
    .restart local v1    # "op":Lcom/android/mail/ui/FolderOperation;
    :cond_1
    invoke-virtual {p1}, Lcom/android/mail/providers/Folder;->isTrash()Z

    move-result v3

    if-eqz v3, :cond_0

    iget-object v3, v1, Lcom/android/mail/ui/FolderOperation;->mFolder:Lcom/android/mail/providers/Folder;

    iget v3, v3, Lcom/android/mail/providers/Folder;->type:I

    if-ne v3, v2, :cond_0

    goto :goto_0

    .line 79
    .end local v1    # "op":Lcom/android/mail/ui/FolderOperation;
    :cond_2
    const/4 v2, 0x0

    goto :goto_0
.end method
