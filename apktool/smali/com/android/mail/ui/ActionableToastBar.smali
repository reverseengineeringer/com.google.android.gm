.class public Lcom/android/mail/ui/ActionableToastBar;
.super Landroid/widget/LinearLayout;
.source "ActionableToastBar.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/ui/ActionableToastBar$ActionClickedListener;
    }
.end annotation


# instance fields
.field private mActionButton:Landroid/view/View;

.field private mActionDescriptionIcon:Landroid/widget/ImageView;

.field private mActionDescriptionView:Landroid/widget/TextView;

.field private mActionIcon:Landroid/view/View;

.field private mActionText:Landroid/widget/TextView;

.field private final mBottomMarginSizeInConversation:I

.field private mHidden:Z

.field private mHideAnimation:Landroid/animation/Animator;

.field private mOperation:Lcom/android/mail/ui/ToastBarOperation;

.field private mShowAnimation:Landroid/animation/Animator;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 55
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/android/mail/ui/ActionableToastBar;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 56
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 59
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/android/mail/ui/ActionableToastBar;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 60
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 63
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 37
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/mail/ui/ActionableToastBar;->mHidden:Z

    .line 64
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0b005f

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    iput v0, p0, Lcom/android/mail/ui/ActionableToastBar;->mBottomMarginSizeInConversation:I

    .line 66
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f040009

    const/4 v2, 0x1

    invoke-virtual {v0, v1, p0, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    .line 67
    return-void
.end method

.method private getHideAnimation()Landroid/animation/Animator;
    .locals 2

    .prologue
    .line 185
    iget-object v0, p0, Lcom/android/mail/ui/ActionableToastBar;->mHideAnimation:Landroid/animation/Animator;

    if-nez v0, :cond_0

    .line 186
    invoke-virtual {p0}, Lcom/android/mail/ui/ActionableToastBar;->getContext()Landroid/content/Context;

    move-result-object v0

    const v1, 0x7f050005

    invoke-static {v0, v1}, Landroid/animation/AnimatorInflater;->loadAnimator(Landroid/content/Context;I)Landroid/animation/Animator;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/ActionableToastBar;->mHideAnimation:Landroid/animation/Animator;

    .line 188
    iget-object v0, p0, Lcom/android/mail/ui/ActionableToastBar;->mHideAnimation:Landroid/animation/Animator;

    new-instance v1, Lcom/android/mail/ui/ActionableToastBar$3;

    invoke-direct {v1, p0}, Lcom/android/mail/ui/ActionableToastBar$3;-><init>(Lcom/android/mail/ui/ActionableToastBar;)V

    invoke-virtual {v0, v1}, Landroid/animation/Animator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    .line 203
    iget-object v0, p0, Lcom/android/mail/ui/ActionableToastBar;->mHideAnimation:Landroid/animation/Animator;

    invoke-virtual {v0, p0}, Landroid/animation/Animator;->setTarget(Ljava/lang/Object;)V

    .line 205
    :cond_0
    iget-object v0, p0, Lcom/android/mail/ui/ActionableToastBar;->mHideAnimation:Landroid/animation/Animator;

    return-object v0
.end method

.method private getShowAnimation()Landroid/animation/Animator;
    .locals 2

    .prologue
    .line 161
    iget-object v0, p0, Lcom/android/mail/ui/ActionableToastBar;->mShowAnimation:Landroid/animation/Animator;

    if-nez v0, :cond_0

    .line 162
    invoke-virtual {p0}, Lcom/android/mail/ui/ActionableToastBar;->getContext()Landroid/content/Context;

    move-result-object v0

    const v1, 0x7f050004

    invoke-static {v0, v1}, Landroid/animation/AnimatorInflater;->loadAnimator(Landroid/content/Context;I)Landroid/animation/Animator;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/ActionableToastBar;->mShowAnimation:Landroid/animation/Animator;

    .line 164
    iget-object v0, p0, Lcom/android/mail/ui/ActionableToastBar;->mShowAnimation:Landroid/animation/Animator;

    new-instance v1, Lcom/android/mail/ui/ActionableToastBar$2;

    invoke-direct {v1, p0}, Lcom/android/mail/ui/ActionableToastBar$2;-><init>(Lcom/android/mail/ui/ActionableToastBar;)V

    invoke-virtual {v0, v1}, Landroid/animation/Animator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    .line 179
    iget-object v0, p0, Lcom/android/mail/ui/ActionableToastBar;->mShowAnimation:Landroid/animation/Animator;

    invoke-virtual {v0, p0}, Landroid/animation/Animator;->setTarget(Ljava/lang/Object;)V

    .line 181
    :cond_0
    iget-object v0, p0, Lcom/android/mail/ui/ActionableToastBar;->mShowAnimation:Landroid/animation/Animator;

    return-object v0
.end method


# virtual methods
.method public getOperation()Lcom/android/mail/ui/ToastBarOperation;
    .locals 1

    .prologue
    .line 139
    iget-object v0, p0, Lcom/android/mail/ui/ActionableToastBar;->mOperation:Lcom/android/mail/ui/ToastBarOperation;

    return-object v0
.end method

.method public hide(Z)V
    .locals 2
    .param p1, "animate"    # Z

    .prologue
    .line 146
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/mail/ui/ActionableToastBar;->mHidden:Z

    .line 147
    invoke-virtual {p0}, Lcom/android/mail/ui/ActionableToastBar;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    .line 148
    iget-object v0, p0, Lcom/android/mail/ui/ActionableToastBar;->mActionDescriptionView:Landroid/widget/TextView;

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 149
    iget-object v0, p0, Lcom/android/mail/ui/ActionableToastBar;->mActionButton:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 151
    if-eqz p1, :cond_1

    .line 152
    invoke-direct {p0}, Lcom/android/mail/ui/ActionableToastBar;->getHideAnimation()Landroid/animation/Animator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/animation/Animator;->start()V

    .line 158
    :cond_0
    :goto_0
    return-void

    .line 154
    :cond_1
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/ActionableToastBar;->setAlpha(F)V

    .line 155
    const/16 v0, 0x8

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/ActionableToastBar;->setVisibility(I)V

    goto :goto_0
.end method

.method public isEventInToastBar(Landroid/view/MotionEvent;)Z
    .locals 7
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 209
    invoke-virtual {p0}, Lcom/android/mail/ui/ActionableToastBar;->isShown()Z

    move-result v5

    if-nez v5, :cond_0

    .line 216
    :goto_0
    return v4

    .line 212
    :cond_0
    const/4 v5, 0x2

    new-array v1, v5, [I

    .line 213
    .local v1, "xy":[I
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v0

    .line 214
    .local v0, "x":F
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v2

    .line 215
    .local v2, "y":F
    invoke-virtual {p0, v1}, Lcom/android/mail/ui/ActionableToastBar;->getLocationOnScreen([I)V

    .line 216
    aget v5, v1, v4

    int-to-float v5, v5

    cmpl-float v5, v0, v5

    if-lez v5, :cond_1

    aget v5, v1, v4

    invoke-virtual {p0}, Lcom/android/mail/ui/ActionableToastBar;->getWidth()I

    move-result v6

    add-int/2addr v5, v6

    int-to-float v5, v5

    cmpg-float v5, v0, v5

    if-gez v5, :cond_1

    aget v5, v1, v3

    int-to-float v5, v5

    cmpl-float v5, v2, v5

    if-lez v5, :cond_1

    aget v5, v1, v3

    invoke-virtual {p0}, Lcom/android/mail/ui/ActionableToastBar;->getHeight()I

    move-result v6

    add-int/2addr v5, v6

    int-to-float v5, v5

    cmpg-float v5, v2, v5

    if-gez v5, :cond_1

    :goto_1
    move v4, v3

    goto :goto_0

    :cond_1
    move v3, v4

    goto :goto_1
.end method

.method protected onFinishInflate()V
    .locals 1

    .prologue
    .line 71
    invoke-super {p0}, Landroid/widget/LinearLayout;->onFinishInflate()V

    .line 73
    const v0, 0x7f100024

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/ActionableToastBar;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/android/mail/ui/ActionableToastBar;->mActionDescriptionIcon:Landroid/widget/ImageView;

    .line 74
    const v0, 0x7f100025

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/ActionableToastBar;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/android/mail/ui/ActionableToastBar;->mActionDescriptionView:Landroid/widget/TextView;

    .line 75
    const v0, 0x7f100026

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/ActionableToastBar;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/ActionableToastBar;->mActionButton:Landroid/view/View;

    .line 76
    const v0, 0x7f100028

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/ActionableToastBar;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/ActionableToastBar;->mActionIcon:Landroid/view/View;

    .line 77
    const v0, 0x7f100029

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/ActionableToastBar;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/android/mail/ui/ActionableToastBar;->mActionText:Landroid/widget/TextView;

    .line 78
    return-void
.end method

.method public setConversationMode(Z)V
    .locals 2
    .param p1, "isInConversationMode"    # Z

    .prologue
    .line 86
    invoke-virtual {p0}, Lcom/android/mail/ui/ActionableToastBar;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout$LayoutParams;

    .line 87
    .local v0, "params":Landroid/widget/FrameLayout$LayoutParams;
    if-eqz p1, :cond_0

    iget v1, p0, Lcom/android/mail/ui/ActionableToastBar;->mBottomMarginSizeInConversation:I

    :goto_0
    iput v1, v0, Landroid/widget/FrameLayout$LayoutParams;->bottomMargin:I

    .line 88
    invoke-virtual {p0, v0}, Lcom/android/mail/ui/ActionableToastBar;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 89
    return-void

    .line 87
    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public show(Lcom/android/mail/ui/ActionableToastBar$ActionClickedListener;ILjava/lang/CharSequence;ZIZLcom/android/mail/ui/ToastBarOperation;)V
    .locals 4
    .param p1, "listener"    # Lcom/android/mail/ui/ActionableToastBar$ActionClickedListener;
    .param p2, "descriptionIconResourceId"    # I
    .param p3, "descriptionText"    # Ljava/lang/CharSequence;
    .param p4, "showActionIcon"    # Z
    .param p5, "actionTextResource"    # I
    .param p6, "replaceVisibleToast"    # Z
    .param p7, "op"    # Lcom/android/mail/ui/ToastBarOperation;

    .prologue
    const/16 v0, 0x8

    const/4 v1, 0x0

    .line 108
    iget-boolean v2, p0, Lcom/android/mail/ui/ActionableToastBar;->mHidden:Z

    if-nez v2, :cond_0

    if-nez p6, :cond_0

    .line 136
    :goto_0
    return-void

    .line 112
    :cond_0
    iput-object p7, p0, Lcom/android/mail/ui/ActionableToastBar;->mOperation:Lcom/android/mail/ui/ToastBarOperation;

    .line 114
    iget-object v2, p0, Lcom/android/mail/ui/ActionableToastBar;->mActionButton:Landroid/view/View;

    new-instance v3, Lcom/android/mail/ui/ActionableToastBar$1;

    invoke-direct {v3, p0, p1}, Lcom/android/mail/ui/ActionableToastBar$1;-><init>(Lcom/android/mail/ui/ActionableToastBar;Lcom/android/mail/ui/ActionableToastBar$ActionClickedListener;)V

    invoke-virtual {v2, v3}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 123
    if-nez p2, :cond_2

    .line 124
    iget-object v2, p0, Lcom/android/mail/ui/ActionableToastBar;->mActionDescriptionIcon:Landroid/widget/ImageView;

    invoke-virtual {v2, v0}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 130
    :goto_1
    iget-object v2, p0, Lcom/android/mail/ui/ActionableToastBar;->mActionDescriptionView:Landroid/widget/TextView;

    invoke-virtual {v2, p3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 131
    iget-object v2, p0, Lcom/android/mail/ui/ActionableToastBar;->mActionIcon:Landroid/view/View;

    if-eqz p4, :cond_1

    move v0, v1

    :cond_1
    invoke-virtual {v2, v0}, Landroid/view/View;->setVisibility(I)V

    .line 132
    iget-object v0, p0, Lcom/android/mail/ui/ActionableToastBar;->mActionText:Landroid/widget/TextView;

    invoke-virtual {v0, p5}, Landroid/widget/TextView;->setText(I)V

    .line 134
    iput-boolean v1, p0, Lcom/android/mail/ui/ActionableToastBar;->mHidden:Z

    .line 135
    invoke-direct {p0}, Lcom/android/mail/ui/ActionableToastBar;->getShowAnimation()Landroid/animation/Animator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/animation/Animator;->start()V

    goto :goto_0

    .line 126
    :cond_2
    iget-object v2, p0, Lcom/android/mail/ui/ActionableToastBar;->mActionDescriptionIcon:Landroid/widget/ImageView;

    invoke-virtual {v2, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 127
    iget-object v2, p0, Lcom/android/mail/ui/ActionableToastBar;->mActionDescriptionIcon:Landroid/widget/ImageView;

    invoke-virtual {v2, p2}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_1
.end method
