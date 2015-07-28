.class Lcom/android/mail/ui/TwoPaneLayout$2;
.super Landroid/animation/AnimatorListenerAdapter;
.source "TwoPaneLayout.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/mail/ui/TwoPaneLayout;->animatePanes(III)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/ui/TwoPaneLayout;


# direct methods
.method constructor <init>(Lcom/android/mail/ui/TwoPaneLayout;)V
    .locals 0

    .prologue
    .line 316
    iput-object p1, p0, Lcom/android/mail/ui/TwoPaneLayout$2;->this$0:Lcom/android/mail/ui/TwoPaneLayout;

    invoke-direct {p0}, Landroid/animation/AnimatorListenerAdapter;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationCancel(Landroid/animation/Animator;)V
    .locals 2
    .param p1, "animation"    # Landroid/animation/Animator;

    .prologue
    .line 326
    iget-object v0, p0, Lcom/android/mail/ui/TwoPaneLayout$2;->this$0:Lcom/android/mail/ui/TwoPaneLayout;

    # getter for: Lcom/android/mail/ui/TwoPaneLayout;->mListCopyView:Lcom/android/mail/ui/ConversationListCopy;
    invoke-static {v0}, Lcom/android/mail/ui/TwoPaneLayout;->access$100(Lcom/android/mail/ui/TwoPaneLayout;)Lcom/android/mail/ui/ConversationListCopy;

    move-result-object v0

    invoke-virtual {v0}, Lcom/android/mail/ui/ConversationListCopy;->unbind()V

    .line 327
    iget-object v0, p0, Lcom/android/mail/ui/TwoPaneLayout$2;->this$0:Lcom/android/mail/ui/TwoPaneLayout;

    const/4 v1, 0x0

    # invokes: Lcom/android/mail/ui/TwoPaneLayout;->useHardwareLayer(Z)V
    invoke-static {v0, v1}, Lcom/android/mail/ui/TwoPaneLayout;->access$200(Lcom/android/mail/ui/TwoPaneLayout;Z)V

    .line 328
    return-void
.end method

.method public onAnimationEnd(Landroid/animation/Animator;)V
    .locals 2
    .param p1, "animation"    # Landroid/animation/Animator;

    .prologue
    .line 319
    iget-object v0, p0, Lcom/android/mail/ui/TwoPaneLayout$2;->this$0:Lcom/android/mail/ui/TwoPaneLayout;

    # getter for: Lcom/android/mail/ui/TwoPaneLayout;->mListCopyView:Lcom/android/mail/ui/ConversationListCopy;
    invoke-static {v0}, Lcom/android/mail/ui/TwoPaneLayout;->access$100(Lcom/android/mail/ui/TwoPaneLayout;)Lcom/android/mail/ui/ConversationListCopy;

    move-result-object v0

    invoke-virtual {v0}, Lcom/android/mail/ui/ConversationListCopy;->unbind()V

    .line 320
    iget-object v0, p0, Lcom/android/mail/ui/TwoPaneLayout$2;->this$0:Lcom/android/mail/ui/TwoPaneLayout;

    const/4 v1, 0x0

    # invokes: Lcom/android/mail/ui/TwoPaneLayout;->useHardwareLayer(Z)V
    invoke-static {v0, v1}, Lcom/android/mail/ui/TwoPaneLayout;->access$200(Lcom/android/mail/ui/TwoPaneLayout;Z)V

    .line 321
    iget-object v0, p0, Lcom/android/mail/ui/TwoPaneLayout$2;->this$0:Lcom/android/mail/ui/TwoPaneLayout;

    # invokes: Lcom/android/mail/ui/TwoPaneLayout;->fixupListCopyWidth()V
    invoke-static {v0}, Lcom/android/mail/ui/TwoPaneLayout;->access$300(Lcom/android/mail/ui/TwoPaneLayout;)V

    .line 322
    iget-object v0, p0, Lcom/android/mail/ui/TwoPaneLayout$2;->this$0:Lcom/android/mail/ui/TwoPaneLayout;

    # invokes: Lcom/android/mail/ui/TwoPaneLayout;->onTransitionComplete()V
    invoke-static {v0}, Lcom/android/mail/ui/TwoPaneLayout;->access$000(Lcom/android/mail/ui/TwoPaneLayout;)V

    .line 323
    return-void
.end method
