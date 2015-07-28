.class Lcom/android/mail/ui/ActionableToastBar$3;
.super Ljava/lang/Object;
.source "ActionableToastBar.java"

# interfaces
.implements Landroid/animation/Animator$AnimatorListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/mail/ui/ActionableToastBar;->getHideAnimation()Landroid/animation/Animator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/ui/ActionableToastBar;


# direct methods
.method constructor <init>(Lcom/android/mail/ui/ActionableToastBar;)V
    .locals 0

    .prologue
    .line 188
    iput-object p1, p0, Lcom/android/mail/ui/ActionableToastBar$3;->this$0:Lcom/android/mail/ui/ActionableToastBar;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationCancel(Landroid/animation/Animator;)V
    .locals 0
    .param p1, "animation"    # Landroid/animation/Animator;

    .prologue
    .line 201
    return-void
.end method

.method public onAnimationEnd(Landroid/animation/Animator;)V
    .locals 2
    .param p1, "animation"    # Landroid/animation/Animator;

    .prologue
    .line 197
    iget-object v0, p0, Lcom/android/mail/ui/ActionableToastBar$3;->this$0:Lcom/android/mail/ui/ActionableToastBar;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/android/mail/ui/ActionableToastBar;->setVisibility(I)V

    .line 198
    return-void
.end method

.method public onAnimationRepeat(Landroid/animation/Animator;)V
    .locals 0
    .param p1, "animation"    # Landroid/animation/Animator;

    .prologue
    .line 194
    return-void
.end method

.method public onAnimationStart(Landroid/animation/Animator;)V
    .locals 0
    .param p1, "animation"    # Landroid/animation/Animator;

    .prologue
    .line 191
    return-void
.end method
