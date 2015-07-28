.class public Lcom/android/mail/compose/CcBccView;
.super Landroid/widget/RelativeLayout;
.source "CcBccView.java"


# instance fields
.field private final mBcc:Landroid/view/View;

.field private final mCc:Landroid/view/View;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 35
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/android/mail/compose/CcBccView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 36
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 39
    const/4 v0, -0x1

    invoke-direct {p0, p1, p2, v0}, Lcom/android/mail/compose/CcBccView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 40
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 43
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 44
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f040012

    invoke-virtual {v0, v1, p0}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 45
    const v0, 0x7f100034

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/CcBccView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/compose/CcBccView;->mCc:Landroid/view/View;

    .line 46
    const v0, 0x7f100037

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/CcBccView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/compose/CcBccView;->mBcc:Landroid/view/View;

    .line 47
    return-void
.end method

.method private animate(Ljava/lang/Boolean;ZZ)V
    .locals 9
    .param p1, "showCc"    # Ljava/lang/Boolean;
    .param p2, "showBcc"    # Z
    .param p3, "ccWasAlreadyShown"    # Z

    .prologue
    const/4 v8, 0x2

    .line 74
    invoke-virtual {p0}, Lcom/android/mail/compose/CcBccView;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    .line 76
    .local v4, "res":Landroid/content/res/Resources;
    const v5, 0x7f0a0005

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v3

    .line 77
    .local v3, "fadeDuration":I
    iget-object v5, p0, Lcom/android/mail/compose/CcBccView;->mBcc:Landroid/view/View;

    const-string v6, "alpha"

    new-array v7, v8, [F

    fill-array-data v7, :array_0

    invoke-static {v5, v6, v7}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v0

    .line 78
    .local v0, "bccAnimator":Landroid/animation/ObjectAnimator;
    int-to-long v5, v3

    invoke-virtual {v0, v5, v6}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    .line 81
    if-nez p3, :cond_0

    .line 82
    iget-object v5, p0, Lcom/android/mail/compose/CcBccView;->mCc:Landroid/view/View;

    const-string v6, "alpha"

    new-array v7, v8, [F

    fill-array-data v7, :array_1

    invoke-static {v5, v6, v7}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v1

    .line 83
    .local v1, "ccAnimator":Landroid/animation/ObjectAnimator;
    int-to-long v5, v3

    invoke-virtual {v1, v5, v6}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    .line 84
    new-instance v2, Landroid/animation/AnimatorSet;

    invoke-direct {v2}, Landroid/animation/AnimatorSet;-><init>()V

    .local v2, "fadeAnimation":Landroid/animation/Animator;
    move-object v5, v2

    .line 85
    check-cast v5, Landroid/animation/AnimatorSet;

    new-array v6, v8, [Landroid/animation/Animator;

    const/4 v7, 0x0

    aput-object v1, v6, v7

    const/4 v7, 0x1

    aput-object v0, v6, v7

    invoke-virtual {v5, v6}, Landroid/animation/AnimatorSet;->playTogether([Landroid/animation/Animator;)V

    .line 89
    .end local v1    # "ccAnimator":Landroid/animation/ObjectAnimator;
    :goto_0
    invoke-virtual {v2}, Landroid/animation/Animator;->start()V

    .line 90
    return-void

    .line 87
    .end local v2    # "fadeAnimation":Landroid/animation/Animator;
    :cond_0
    move-object v2, v0

    .restart local v2    # "fadeAnimation":Landroid/animation/Animator;
    goto :goto_0

    .line 77
    nop

    :array_0
    .array-data 4
        0x0
        0x3f800000    # 1.0f
    .end array-data

    .line 82
    :array_1
    .array-data 4
        0x0
        0x3f800000    # 1.0f
    .end array-data
.end method


# virtual methods
.method public isBccVisible()Z
    .locals 1

    .prologue
    .line 103
    iget-object v0, p0, Lcom/android/mail/compose/CcBccView;->mBcc:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isCcVisible()Z
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/android/mail/compose/CcBccView;->mCc:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public show(ZZZ)V
    .locals 6
    .param p1, "animate"    # Z
    .param p2, "showCc"    # Z
    .param p3, "showBcc"    # Z

    .prologue
    const/16 v3, 0x8

    const/4 v2, 0x0

    const/high16 v5, 0x3f800000    # 1.0f

    .line 50
    iget-object v1, p0, Lcom/android/mail/compose/CcBccView;->mCc:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->isShown()Z

    move-result v0

    .line 51
    .local v0, "ccWasAlreadyShown":Z
    iget-object v4, p0, Lcom/android/mail/compose/CcBccView;->mCc:Landroid/view/View;

    if-eqz p2, :cond_0

    move v1, v2

    :goto_0
    invoke-virtual {v4, v1}, Landroid/view/View;->setVisibility(I)V

    .line 52
    iget-object v1, p0, Lcom/android/mail/compose/CcBccView;->mBcc:Landroid/view/View;

    if-eqz p3, :cond_1

    :goto_1
    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 53
    if-eqz p1, :cond_2

    .line 54
    invoke-static {p2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-direct {p0, v1, p3, v0}, Lcom/android/mail/compose/CcBccView;->animate(Ljava/lang/Boolean;ZZ)V

    .line 64
    :goto_2
    return-void

    :cond_0
    move v1, v3

    .line 51
    goto :goto_0

    :cond_1
    move v2, v3

    .line 52
    goto :goto_1

    .line 56
    :cond_2
    if-eqz p2, :cond_3

    .line 57
    iget-object v1, p0, Lcom/android/mail/compose/CcBccView;->mCc:Landroid/view/View;

    invoke-virtual {v1, v5}, Landroid/view/View;->setAlpha(F)V

    .line 59
    :cond_3
    if-eqz p3, :cond_4

    .line 60
    iget-object v1, p0, Lcom/android/mail/compose/CcBccView;->mBcc:Landroid/view/View;

    invoke-virtual {v1, v5}, Landroid/view/View;->setAlpha(F)V

    .line 62
    :cond_4
    invoke-virtual {p0}, Lcom/android/mail/compose/CcBccView;->requestLayout()V

    goto :goto_2
.end method
