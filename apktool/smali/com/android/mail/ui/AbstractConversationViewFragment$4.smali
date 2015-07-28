.class Lcom/android/mail/ui/AbstractConversationViewFragment$4;
.super Landroid/animation/AnimatorListenerAdapter;
.source "AbstractConversationViewFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/mail/ui/AbstractConversationViewFragment;->animateDismiss(Ljava/lang/Runnable;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

.field final synthetic val$doAfter:Ljava/lang/Runnable;


# direct methods
.method constructor <init>(Lcom/android/mail/ui/AbstractConversationViewFragment;Ljava/lang/Runnable;)V
    .locals 0

    .prologue
    .line 290
    iput-object p1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$4;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    iput-object p2, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$4;->val$doAfter:Ljava/lang/Runnable;

    invoke-direct {p0}, Landroid/animation/AnimatorListenerAdapter;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/animation/Animator;)V
    .locals 3
    .param p1, "animation"    # Landroid/animation/Animator;

    .prologue
    .line 293
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$4;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    # getter for: Lcom/android/mail/ui/AbstractConversationViewFragment;->mBackgroundView:Landroid/view/View;
    invoke-static {v0}, Lcom/android/mail/ui/AbstractConversationViewFragment;->access$400(Lcom/android/mail/ui/AbstractConversationViewFragment;)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 294
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$4;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    # getter for: Lcom/android/mail/ui/AbstractConversationViewFragment;->mBackgroundView:Landroid/view/View;
    invoke-static {v0}, Lcom/android/mail/ui/AbstractConversationViewFragment;->access$400(Lcom/android/mail/ui/AbstractConversationViewFragment;)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/View;->setLayerType(ILandroid/graphics/Paint;)V

    .line 295
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$4;->val$doAfter:Ljava/lang/Runnable;

    if-eqz v0, :cond_0

    .line 296
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$4;->val$doAfter:Ljava/lang/Runnable;

    invoke-interface {v0}, Ljava/lang/Runnable;->run()V

    .line 298
    :cond_0
    return-void
.end method
