.class public Lcom/android/mail/ui/LeaveBehindItem;
.super Landroid/widget/FrameLayout;
.source "LeaveBehindItem.java"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lcom/android/mail/ui/SwipeableItemView;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/ui/LeaveBehindItem$1;,
        Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData;
    }
.end annotation


# static fields
.field private static sFadeInAnimationDuration:I

.field private static sScrollSlop:F

.field private static sShrinkAnimationDuration:I


# instance fields
.field private mAccount:Lcom/android/mail/providers/Account;

.field private mAdapter:Lcom/android/mail/ui/AnimatedAdapter;

.field private mAnimatedHeight:I

.field private mAnimating:Z

.field private mData:Lcom/android/mail/providers/Conversation;

.field private mFadingInText:Z

.field private mSwipeableContent:Landroid/view/View;

.field private mText:Landroid/widget/TextView;

.field private mUndoOp:Lcom/android/mail/ui/ToastBarOperation;

.field private mWidth:I

.field public position:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    const/4 v0, -0x1

    .line 51
    sput v0, Lcom/android/mail/ui/LeaveBehindItem;->sShrinkAnimationDuration:I

    .line 52
    sput v0, Lcom/android/mail/ui/LeaveBehindItem;->sFadeInAnimationDuration:I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 56
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/android/mail/ui/LeaveBehindItem;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 57
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 60
    const/4 v0, -0x1

    invoke-direct {p0, p1, p2, v0}, Lcom/android/mail/ui/LeaveBehindItem;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 61
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    const/4 v2, -0x1

    .line 64
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 189
    iput v2, p0, Lcom/android/mail/ui/LeaveBehindItem;->mAnimatedHeight:I

    .line 65
    sget v1, Lcom/android/mail/ui/LeaveBehindItem;->sShrinkAnimationDuration:I

    if-ne v1, v2, :cond_0

    .line 66
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 67
    .local v0, "res":Landroid/content/res/Resources;
    const v1, 0x7f0a0009

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v1

    sput v1, Lcom/android/mail/ui/LeaveBehindItem;->sShrinkAnimationDuration:I

    .line 68
    const v1, 0x7f0a000b

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v1

    sput v1, Lcom/android/mail/ui/LeaveBehindItem;->sFadeInAnimationDuration:I

    .line 69
    const v1, 0x7f0a001e

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v1

    int-to-float v1, v1

    sput v1, Lcom/android/mail/ui/LeaveBehindItem;->sScrollSlop:F

    .line 71
    .end local v0    # "res":Landroid/content/res/Resources;
    :cond_0
    return-void
.end method


# virtual methods
.method public bindOperations(ILcom/android/mail/providers/Account;Lcom/android/mail/ui/AnimatedAdapter;Lcom/android/mail/ui/ToastBarOperation;Lcom/android/mail/providers/Conversation;Lcom/android/mail/providers/Folder;)V
    .locals 3
    .param p1, "pos"    # I
    .param p2, "account"    # Lcom/android/mail/providers/Account;
    .param p3, "adapter"    # Lcom/android/mail/ui/AnimatedAdapter;
    .param p4, "undoOp"    # Lcom/android/mail/ui/ToastBarOperation;
    .param p5, "target"    # Lcom/android/mail/providers/Conversation;
    .param p6, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 100
    iput p1, p0, Lcom/android/mail/ui/LeaveBehindItem;->position:I

    .line 101
    iput-object p4, p0, Lcom/android/mail/ui/LeaveBehindItem;->mUndoOp:Lcom/android/mail/ui/ToastBarOperation;

    .line 102
    iput-object p2, p0, Lcom/android/mail/ui/LeaveBehindItem;->mAccount:Lcom/android/mail/providers/Account;

    .line 103
    iput-object p3, p0, Lcom/android/mail/ui/LeaveBehindItem;->mAdapter:Lcom/android/mail/ui/AnimatedAdapter;

    .line 104
    invoke-virtual {p0, p5}, Lcom/android/mail/ui/LeaveBehindItem;->setData(Lcom/android/mail/providers/Conversation;)V

    .line 105
    const v0, 0x7f1000f3

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/LeaveBehindItem;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/LeaveBehindItem;->mSwipeableContent:Landroid/view/View;

    .line 108
    iget-object v0, p0, Lcom/android/mail/ui/LeaveBehindItem;->mSwipeableContent:Landroid/view/View;

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 109
    const v0, 0x7f1000f4

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/LeaveBehindItem;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/android/mail/ui/LeaveBehindItem;->mText:Landroid/widget/TextView;

    .line 110
    iget-object v0, p0, Lcom/android/mail/ui/LeaveBehindItem;->mText:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/android/mail/ui/LeaveBehindItem;->mUndoOp:Lcom/android/mail/ui/ToastBarOperation;

    invoke-virtual {p0}, Lcom/android/mail/ui/LeaveBehindItem;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v1, v2, p6}, Lcom/android/mail/ui/ToastBarOperation;->getSingularDescription(Landroid/content/Context;Lcom/android/mail/providers/Folder;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 112
    iget-object v0, p0, Lcom/android/mail/ui/LeaveBehindItem;->mText:Landroid/widget/TextView;

    invoke-virtual {v0, p0}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 113
    return-void
.end method

.method public canChildBeDismissed()Z
    .locals 1

    .prologue
    .line 141
    const/4 v0, 0x1

    return v0
.end method

.method public commit()V
    .locals 3

    .prologue
    .line 116
    iget-object v1, p0, Lcom/android/mail/ui/LeaveBehindItem;->mAdapter:Lcom/android/mail/ui/AnimatedAdapter;

    invoke-virtual {v1}, Lcom/android/mail/ui/AnimatedAdapter;->getConversationCursor()Lcom/android/mail/browse/ConversationCursor;

    move-result-object v0

    .line 117
    .local v0, "cursor":Lcom/android/mail/browse/ConversationCursor;
    if-eqz v0, :cond_0

    .line 118
    invoke-virtual {p0}, Lcom/android/mail/ui/LeaveBehindItem;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {p0}, Lcom/android/mail/ui/LeaveBehindItem;->getData()Lcom/android/mail/providers/Conversation;

    move-result-object v2

    invoke-static {v2}, Lcom/google/common/collect/ImmutableList;->of(Ljava/lang/Object;)Lcom/google/common/collect/ImmutableList;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/android/mail/browse/ConversationCursor;->delete(Landroid/content/Context;Ljava/util/Collection;)I

    .line 120
    :cond_0
    return-void
.end method

.method public dismiss()V
    .locals 1

    .prologue
    .line 124
    iget-object v0, p0, Lcom/android/mail/ui/LeaveBehindItem;->mAdapter:Lcom/android/mail/ui/AnimatedAdapter;

    if-eqz v0, :cond_0

    .line 125
    iget-object v0, p0, Lcom/android/mail/ui/LeaveBehindItem;->mAdapter:Lcom/android/mail/ui/AnimatedAdapter;

    invoke-virtual {v0}, Lcom/android/mail/ui/AnimatedAdapter;->fadeOutLeaveBehindItems()V

    .line 126
    iget-object v0, p0, Lcom/android/mail/ui/LeaveBehindItem;->mAdapter:Lcom/android/mail/ui/AnimatedAdapter;

    invoke-virtual {v0}, Lcom/android/mail/ui/AnimatedAdapter;->notifyDataSetChanged()V

    .line 128
    :cond_0
    return-void
.end method

.method public getConversationId()J
    .locals 2

    .prologue
    .line 131
    invoke-virtual {p0}, Lcom/android/mail/ui/LeaveBehindItem;->getData()Lcom/android/mail/providers/Conversation;

    move-result-object v0

    iget-wide v0, v0, Lcom/android/mail/providers/Conversation;->id:J

    return-wide v0
.end method

.method public getData()Lcom/android/mail/providers/Conversation;
    .locals 1

    .prologue
    .line 236
    iget-object v0, p0, Lcom/android/mail/ui/LeaveBehindItem;->mData:Lcom/android/mail/providers/Conversation;

    return-object v0
.end method

.method public getLeaveBehindData()Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData;
    .locals 3

    .prologue
    .line 145
    new-instance v0, Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData;

    invoke-virtual {p0}, Lcom/android/mail/ui/LeaveBehindItem;->getData()Lcom/android/mail/providers/Conversation;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/ui/LeaveBehindItem;->mUndoOp:Lcom/android/mail/ui/ToastBarOperation;

    invoke-direct {v0, p0, v1, v2}, Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData;-><init>(Lcom/android/mail/ui/LeaveBehindItem;Lcom/android/mail/providers/Conversation;Lcom/android/mail/ui/ToastBarOperation;)V

    return-object v0
.end method

.method public getMinAllowScrollDistance()F
    .locals 1

    .prologue
    .line 266
    sget v0, Lcom/android/mail/ui/LeaveBehindItem;->sScrollSlop:F

    return v0
.end method

.method public getSwipeableView()Landroid/view/View;
    .locals 1

    .prologue
    .line 136
    iget-object v0, p0, Lcom/android/mail/ui/LeaveBehindItem;->mSwipeableContent:Landroid/view/View;

    return-object v0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 75
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v1

    .line 76
    .local v1, "id":I
    packed-switch v1, :pswitch_data_0

    .line 96
    :cond_0
    :goto_0
    return-void

    .line 78
    :pswitch_0
    iget-object v2, p0, Lcom/android/mail/ui/LeaveBehindItem;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v2, v2, Lcom/android/mail/providers/Account;->undoUri:Landroid/net/Uri;

    if-eqz v2, :cond_0

    .line 83
    iget-object v2, p0, Lcom/android/mail/ui/LeaveBehindItem;->mAdapter:Lcom/android/mail/ui/AnimatedAdapter;

    invoke-virtual {p0}, Lcom/android/mail/ui/LeaveBehindItem;->getConversationId()J

    move-result-wide v3

    invoke-virtual {v2, v3, v4}, Lcom/android/mail/ui/AnimatedAdapter;->clearLeaveBehind(J)V

    .line 84
    iget-object v2, p0, Lcom/android/mail/ui/LeaveBehindItem;->mAdapter:Lcom/android/mail/ui/AnimatedAdapter;

    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Lcom/android/mail/ui/AnimatedAdapter;->setSwipeUndo(Z)V

    .line 85
    iget-object v2, p0, Lcom/android/mail/ui/LeaveBehindItem;->mAdapter:Lcom/android/mail/ui/AnimatedAdapter;

    invoke-virtual {v2}, Lcom/android/mail/ui/AnimatedAdapter;->getConversationCursor()Lcom/android/mail/browse/ConversationCursor;

    move-result-object v0

    .line 86
    .local v0, "cursor":Lcom/android/mail/browse/ConversationCursor;
    if-eqz v0, :cond_0

    .line 87
    invoke-virtual {p0}, Lcom/android/mail/ui/LeaveBehindItem;->getContext()Landroid/content/Context;

    move-result-object v2

    iget-object v3, p0, Lcom/android/mail/ui/LeaveBehindItem;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v3, v3, Lcom/android/mail/providers/Account;->undoUri:Landroid/net/Uri;

    invoke-virtual {v0, v2, v3}, Lcom/android/mail/browse/ConversationCursor;->undo(Landroid/content/Context;Landroid/net/Uri;)V

    goto :goto_0

    .line 76
    nop

    :pswitch_data_0
    .packed-switch 0x7f1000f3
        :pswitch_0
    .end packed-switch
.end method

.method protected onMeasure(II)V
    .locals 2
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 241
    iget v0, p0, Lcom/android/mail/ui/LeaveBehindItem;->mAnimatedHeight:I

    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    .line 242
    iget v0, p0, Lcom/android/mail/ui/LeaveBehindItem;->mWidth:I

    iget v1, p0, Lcom/android/mail/ui/LeaveBehindItem;->mAnimatedHeight:I

    invoke-virtual {p0, v0, v1}, Lcom/android/mail/ui/LeaveBehindItem;->setMeasuredDimension(II)V

    .line 246
    :goto_0
    return-void

    .line 244
    :cond_0
    invoke-super {p0, p1, p2}, Landroid/widget/FrameLayout;->onMeasure(II)V

    goto :goto_0
.end method

.method public setAnimatedHeight(I)V
    .locals 0
    .param p1, "height"    # I

    .prologue
    .line 252
    iput p1, p0, Lcom/android/mail/ui/LeaveBehindItem;->mAnimatedHeight:I

    .line 253
    invoke-virtual {p0}, Lcom/android/mail/ui/LeaveBehindItem;->requestLayout()V

    .line 254
    return-void
.end method

.method public setData(Lcom/android/mail/providers/Conversation;)V
    .locals 0
    .param p1, "conversation"    # Lcom/android/mail/providers/Conversation;

    .prologue
    .line 232
    iput-object p1, p0, Lcom/android/mail/ui/LeaveBehindItem;->mData:Lcom/android/mail/providers/Conversation;

    .line 233
    return-void
.end method

.method public showTextImmediately()V
    .locals 1

    .prologue
    .line 261
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/mail/ui/LeaveBehindItem;->mFadingInText:Z

    .line 262
    return-void
.end method

.method public startAnimation(Lcom/android/mail/ui/ViewMode;Landroid/animation/Animator$AnimatorListener;)V
    .locals 8
    .param p1, "viewMode"    # Lcom/android/mail/ui/ViewMode;
    .param p2, "listener"    # Landroid/animation/Animator$AnimatorListener;

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 202
    iget-boolean v4, p0, Lcom/android/mail/ui/LeaveBehindItem;->mAnimating:Z

    if-nez v4, :cond_0

    .line 203
    iput-boolean v7, p0, Lcom/android/mail/ui/LeaveBehindItem;->mAnimating:Z

    .line 204
    invoke-virtual {p0}, Lcom/android/mail/ui/LeaveBehindItem;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4, p1}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getMinHeight(Landroid/content/Context;Lcom/android/mail/ui/ViewMode;)I

    move-result v2

    .line 205
    .local v2, "minHeight":I
    invoke-virtual {p0, v2}, Lcom/android/mail/ui/LeaveBehindItem;->setMinimumHeight(I)V

    .line 206
    move v3, v2

    .line 207
    .local v3, "start":I
    const/4 v0, 0x0

    .line 208
    .local v0, "end":I
    const-string v4, "animatedHeight"

    const/4 v5, 0x2

    new-array v5, v5, [I

    aput v3, v5, v6

    aput v6, v5, v7

    invoke-static {p0, v4, v5}, Landroid/animation/ObjectAnimator;->ofInt(Ljava/lang/Object;Ljava/lang/String;[I)Landroid/animation/ObjectAnimator;

    move-result-object v1

    .line 209
    .local v1, "height":Landroid/animation/ObjectAnimator;
    iput v3, p0, Lcom/android/mail/ui/LeaveBehindItem;->mAnimatedHeight:I

    .line 210
    invoke-virtual {p0}, Lcom/android/mail/ui/LeaveBehindItem;->getMeasuredWidth()I

    move-result v4

    iput v4, p0, Lcom/android/mail/ui/LeaveBehindItem;->mWidth:I

    .line 211
    iget-object v4, p0, Lcom/android/mail/ui/LeaveBehindItem;->mSwipeableContent:Landroid/view/View;

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Landroid/view/View;->setVisibility(I)V

    .line 212
    new-instance v4, Landroid/view/animation/DecelerateInterpolator;

    const/high16 v5, 0x40000000    # 2.0f

    invoke-direct {v4, v5}, Landroid/view/animation/DecelerateInterpolator;-><init>(F)V

    invoke-virtual {v1, v4}, Landroid/animation/ObjectAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    .line 213
    invoke-virtual {v1, p2}, Landroid/animation/ObjectAnimator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    .line 214
    sget v4, Lcom/android/mail/ui/LeaveBehindItem;->sShrinkAnimationDuration:I

    int-to-long v4, v4

    invoke-virtual {v1, v4, v5}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    .line 215
    invoke-virtual {v1}, Landroid/animation/ObjectAnimator;->start()V

    .line 217
    .end local v0    # "end":I
    .end local v1    # "height":Landroid/animation/ObjectAnimator;
    .end local v2    # "minHeight":I
    .end local v3    # "start":I
    :cond_0
    return-void
.end method

.method public startFadeInAnimation()V
    .locals 6

    .prologue
    .line 220
    iget-boolean v3, p0, Lcom/android/mail/ui/LeaveBehindItem;->mFadingInText:Z

    if-nez v3, :cond_0

    .line 221
    const/4 v3, 0x1

    iput-boolean v3, p0, Lcom/android/mail/ui/LeaveBehindItem;->mFadingInText:Z

    .line 222
    const/4 v2, 0x0

    .line 223
    .local v2, "start":F
    const/high16 v0, 0x3f800000    # 1.0f

    .line 224
    .local v0, "end":F
    iget-object v3, p0, Lcom/android/mail/ui/LeaveBehindItem;->mText:Landroid/widget/TextView;

    const-string v4, "alpha"

    const/4 v5, 0x2

    new-array v5, v5, [F

    fill-array-data v5, :array_0

    invoke-static {v3, v4, v5}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v1

    .line 225
    .local v1, "fadeIn":Landroid/animation/ObjectAnimator;
    new-instance v3, Landroid/view/animation/DecelerateInterpolator;

    const/high16 v4, 0x40000000    # 2.0f

    invoke-direct {v3, v4}, Landroid/view/animation/DecelerateInterpolator;-><init>(F)V

    invoke-virtual {v1, v3}, Landroid/animation/ObjectAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    .line 226
    sget v3, Lcom/android/mail/ui/LeaveBehindItem;->sFadeInAnimationDuration:I

    int-to-long v3, v3

    invoke-virtual {v1, v3, v4}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    .line 227
    invoke-virtual {v1}, Landroid/animation/ObjectAnimator;->start()V

    .line 229
    .end local v0    # "end":F
    .end local v1    # "fadeIn":Landroid/animation/ObjectAnimator;
    .end local v2    # "start":F
    :cond_0
    return-void

    .line 224
    :array_0
    .array-data 4
        0x0
        0x3f800000    # 1.0f
    .end array-data
.end method
