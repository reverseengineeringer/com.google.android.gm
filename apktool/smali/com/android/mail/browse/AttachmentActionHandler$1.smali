.class Lcom/android/mail/browse/AttachmentActionHandler$1;
.super Ljava/lang/Object;
.source "AttachmentActionHandler.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/mail/browse/AttachmentActionHandler;->updateStatus(Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/browse/AttachmentActionHandler;

.field final synthetic val$dialog:Lcom/android/mail/browse/AttachmentProgressDialogFragment;


# direct methods
.method constructor <init>(Lcom/android/mail/browse/AttachmentActionHandler;Lcom/android/mail/browse/AttachmentProgressDialogFragment;)V
    .locals 0

    .prologue
    .line 171
    iput-object p1, p0, Lcom/android/mail/browse/AttachmentActionHandler$1;->this$0:Lcom/android/mail/browse/AttachmentActionHandler;

    iput-object p2, p0, Lcom/android/mail/browse/AttachmentActionHandler$1;->val$dialog:Lcom/android/mail/browse/AttachmentProgressDialogFragment;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 174
    iget-object v0, p0, Lcom/android/mail/browse/AttachmentActionHandler$1;->val$dialog:Lcom/android/mail/browse/AttachmentProgressDialogFragment;

    invoke-virtual {v0}, Lcom/android/mail/browse/AttachmentProgressDialogFragment;->dismiss()V

    .line 175
    return-void
.end method
