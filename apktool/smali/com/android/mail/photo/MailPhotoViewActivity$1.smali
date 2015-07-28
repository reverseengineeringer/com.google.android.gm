.class Lcom/android/mail/photo/MailPhotoViewActivity$1;
.super Ljava/lang/Object;
.source "MailPhotoViewActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/mail/photo/MailPhotoViewActivity;->updateProgressAndEmptyViews(Lcom/android/ex/photo/fragments/PhotoViewFragment;Lcom/android/mail/providers/Attachment;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/photo/MailPhotoViewActivity;

.field final synthetic val$progressBar:Lcom/android/ex/photo/views/ProgressBarWrapper;


# direct methods
.method constructor <init>(Lcom/android/mail/photo/MailPhotoViewActivity;Lcom/android/ex/photo/views/ProgressBarWrapper;)V
    .locals 0

    .prologue
    .line 230
    iput-object p1, p0, Lcom/android/mail/photo/MailPhotoViewActivity$1;->this$0:Lcom/android/mail/photo/MailPhotoViewActivity;

    iput-object p2, p0, Lcom/android/mail/photo/MailPhotoViewActivity$1;->val$progressBar:Lcom/android/ex/photo/views/ProgressBarWrapper;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 233
    iget-object v0, p0, Lcom/android/mail/photo/MailPhotoViewActivity$1;->this$0:Lcom/android/mail/photo/MailPhotoViewActivity;

    # invokes: Lcom/android/mail/photo/MailPhotoViewActivity;->downloadAttachment()V
    invoke-static {v0}, Lcom/android/mail/photo/MailPhotoViewActivity;->access$000(Lcom/android/mail/photo/MailPhotoViewActivity;)V

    .line 234
    iget-object v0, p0, Lcom/android/mail/photo/MailPhotoViewActivity$1;->val$progressBar:Lcom/android/ex/photo/views/ProgressBarWrapper;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/android/ex/photo/views/ProgressBarWrapper;->setVisibility(I)V

    .line 235
    return-void
.end method
