.class Lcom/google/android/gm/provider/MailEngine$5;
.super Ljava/lang/Object;
.source "MailEngine.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gm/provider/MailEngine;->enqueueAttachmentDownloadTask()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/android/gm/provider/MailEngine;


# direct methods
.method constructor <init>(Lcom/google/android/gm/provider/MailEngine;)V
    .locals 0

    .prologue
    .line 1076
    iput-object p1, p0, Lcom/google/android/gm/provider/MailEngine$5;->this$0:Lcom/google/android/gm/provider/MailEngine;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 1079
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$5;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mAttachmentManager:Lcom/google/android/gm/provider/AttachmentManager;
    invoke-static {v1}, Lcom/google/android/gm/provider/MailEngine;->access$1200(Lcom/google/android/gm/provider/MailEngine;)Lcom/google/android/gm/provider/AttachmentManager;

    move-result-object v0

    .line 1080
    .local v0, "manager":Lcom/google/android/gm/provider/AttachmentManager;
    if-eqz v0, :cond_0

    .line 1081
    invoke-virtual {v0}, Lcom/google/android/gm/provider/AttachmentManager;->maybeStartNextAttachmentDownload()V

    .line 1085
    :goto_0
    return-void

    .line 1083
    :cond_0
    const-string v1, "Gmail"

    const-string v2, "null AttachmentManager instance"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v1, v2, v3}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0
.end method
