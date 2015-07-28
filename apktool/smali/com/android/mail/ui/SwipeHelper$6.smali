.class Lcom/android/mail/ui/SwipeHelper$6;
.super Ljava/lang/Object;
.source "SwipeHelper.java"

# interfaces
.implements Landroid/animation/Animator$AnimatorListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/mail/ui/SwipeHelper;->snapChild(Lcom/android/mail/ui/SwipeableItemView;F)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/ui/SwipeHelper;

.field final synthetic val$animView:Landroid/view/View;


# direct methods
.method constructor <init>(Lcom/android/mail/ui/SwipeHelper;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 366
    iput-object p1, p0, Lcom/android/mail/ui/SwipeHelper$6;->this$0:Lcom/android/mail/ui/SwipeHelper;

    iput-object p2, p0, Lcom/android/mail/ui/SwipeHelper$6;->val$animView:Landroid/view/View;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationCancel(Landroid/animation/Animator;)V
    .locals 0
    .param p1, "animation"    # Landroid/animation/Animator;

    .prologue
    .line 377
    return-void
.end method

.method public onAnimationEnd(Landroid/animation/Animator;)V
    .locals 2
    .param p1, "animation"    # Landroid/animation/Animator;

    .prologue
    .line 372
    iget-object v0, p0, Lcom/android/mail/ui/SwipeHelper$6;->val$animView:Landroid/view/View;

    const/high16 v1, 0x3f800000    # 1.0f

    invoke-virtual {v0, v1}, Landroid/view/View;->setAlpha(F)V

    .line 373
    iget-object v0, p0, Lcom/android/mail/ui/SwipeHelper$6;->this$0:Lcom/android/mail/ui/SwipeHelper;

    # getter for: Lcom/android/mail/ui/SwipeHelper;->mCallback:Lcom/android/mail/ui/SwipeHelper$Callback;
    invoke-static {v0}, Lcom/android/mail/ui/SwipeHelper;->access$100(Lcom/android/mail/ui/SwipeHelper;)Lcom/android/mail/ui/SwipeHelper$Callback;

    move-result-object v0

    iget-object v1, p0, Lcom/android/mail/ui/SwipeHelper$6;->this$0:Lcom/android/mail/ui/SwipeHelper;

    # getter for: Lcom/android/mail/ui/SwipeHelper;->mCurrView:Lcom/android/mail/ui/SwipeableItemView;
    invoke-static {v1}, Lcom/android/mail/ui/SwipeHelper;->access$000(Lcom/android/mail/ui/SwipeHelper;)Lcom/android/mail/ui/SwipeableItemView;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/android/mail/ui/SwipeHelper$Callback;->onDragCancelled(Lcom/android/mail/ui/SwipeableItemView;)V

    .line 374
    return-void
.end method

.method public onAnimationRepeat(Landroid/animation/Animator;)V
    .locals 0
    .param p1, "animation"    # Landroid/animation/Animator;

    .prologue
    .line 380
    return-void
.end method

.method public onAnimationStart(Landroid/animation/Animator;)V
    .locals 0
    .param p1, "animation"    # Landroid/animation/Animator;

    .prologue
    .line 369
    return-void
.end method
