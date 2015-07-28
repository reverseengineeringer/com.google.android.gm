.class public Lcom/android/mail/browse/SuperCollapsedBlock;
.super Landroid/widget/FrameLayout;
.source "SuperCollapsedBlock.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/browse/SuperCollapsedBlock$OnClickListener;
    }
.end annotation


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private mBackgroundView:Landroid/view/View;

.field private mClick:Lcom/android/mail/browse/SuperCollapsedBlock$OnClickListener;

.field private mCountView:Landroid/widget/TextView;

.field private mIconView:Landroid/view/View;

.field private mModel:Lcom/android/mail/browse/ConversationViewAdapter$SuperCollapsedBlockItem;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 54
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/browse/SuperCollapsedBlock;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 57
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/android/mail/browse/SuperCollapsedBlock;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 58
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 61
    invoke-direct {p0, p1, p2}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 62
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/SuperCollapsedBlock;->setActivated(Z)V

    .line 63
    invoke-virtual {p0, p0}, Lcom/android/mail/browse/SuperCollapsedBlock;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 64
    return-void
.end method

.method static synthetic access$000(Lcom/android/mail/browse/SuperCollapsedBlock;)Lcom/android/mail/browse/ConversationViewAdapter$SuperCollapsedBlockItem;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/browse/SuperCollapsedBlock;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/android/mail/browse/SuperCollapsedBlock;->mModel:Lcom/android/mail/browse/ConversationViewAdapter$SuperCollapsedBlockItem;

    return-object v0
.end method

.method static synthetic access$100(Lcom/android/mail/browse/SuperCollapsedBlock;)Lcom/android/mail/browse/SuperCollapsedBlock$OnClickListener;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/browse/SuperCollapsedBlock;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/android/mail/browse/SuperCollapsedBlock;->mClick:Lcom/android/mail/browse/SuperCollapsedBlock$OnClickListener;

    return-object v0
.end method


# virtual methods
.method public bind(Lcom/android/mail/browse/ConversationViewAdapter$SuperCollapsedBlockItem;)V
    .locals 2
    .param p1, "item"    # Lcom/android/mail/browse/ConversationViewAdapter$SuperCollapsedBlockItem;

    .prologue
    .line 86
    iput-object p1, p0, Lcom/android/mail/browse/SuperCollapsedBlock;->mModel:Lcom/android/mail/browse/ConversationViewAdapter$SuperCollapsedBlockItem;

    .line 87
    invoke-virtual {p1}, Lcom/android/mail/browse/ConversationViewAdapter$SuperCollapsedBlockItem;->getEnd()I

    move-result v0

    invoke-virtual {p1}, Lcom/android/mail/browse/ConversationViewAdapter$SuperCollapsedBlockItem;->getStart()I

    move-result v1

    sub-int/2addr v0, v1

    add-int/lit8 v0, v0, 0x1

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/SuperCollapsedBlock;->setCount(I)V

    .line 88
    return-void
.end method

.method public initialize(Lcom/android/mail/browse/SuperCollapsedBlock$OnClickListener;)V
    .locals 0
    .param p1, "onClick"    # Lcom/android/mail/browse/SuperCollapsedBlock$OnClickListener;

    .prologue
    .line 67
    iput-object p1, p0, Lcom/android/mail/browse/SuperCollapsedBlock;->mClick:Lcom/android/mail/browse/SuperCollapsedBlock$OnClickListener;

    .line 68
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 97
    const v0, 0x7f1000f2

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/SuperCollapsedBlock;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    const v1, 0x7f0c00db

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 99
    iget-object v0, p0, Lcom/android/mail/browse/SuperCollapsedBlock;->mCountView:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 101
    iget-object v0, p0, Lcom/android/mail/browse/SuperCollapsedBlock;->mClick:Lcom/android/mail/browse/SuperCollapsedBlock$OnClickListener;

    if-eqz v0, :cond_0

    .line 102
    invoke-virtual {p0}, Lcom/android/mail/browse/SuperCollapsedBlock;->getHandler()Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/android/mail/browse/SuperCollapsedBlock$1;

    invoke-direct {v1, p0}, Lcom/android/mail/browse/SuperCollapsedBlock$1;-><init>(Lcom/android/mail/browse/SuperCollapsedBlock;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 109
    :cond_0
    return-void
.end method

.method protected onFinishInflate()V
    .locals 3

    .prologue
    .line 72
    invoke-super {p0}, Landroid/widget/FrameLayout;->onFinishInflate()V

    .line 74
    const v1, 0x7f1000f0

    invoke-virtual {p0, v1}, Lcom/android/mail/browse/SuperCollapsedBlock;->findViewById(I)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lcom/android/mail/browse/SuperCollapsedBlock;->mIconView:Landroid/view/View;

    .line 75
    const v1, 0x7f1000f1

    invoke-virtual {p0, v1}, Lcom/android/mail/browse/SuperCollapsedBlock;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/android/mail/browse/SuperCollapsedBlock;->mCountView:Landroid/widget/TextView;

    .line 76
    const v1, 0x7f1000ef

    invoke-virtual {p0, v1}, Lcom/android/mail/browse/SuperCollapsedBlock;->findViewById(I)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lcom/android/mail/browse/SuperCollapsedBlock;->mBackgroundView:Landroid/view/View;

    .line 79
    invoke-virtual {p0}, Lcom/android/mail/browse/SuperCollapsedBlock;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f020028

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    check-cast v0, Landroid/graphics/drawable/BitmapDrawable;

    .line 81
    .local v0, "bd":Landroid/graphics/drawable/BitmapDrawable;
    sget-object v1, Landroid/graphics/Shader$TileMode;->REPEAT:Landroid/graphics/Shader$TileMode;

    sget-object v2, Landroid/graphics/Shader$TileMode;->REPEAT:Landroid/graphics/Shader$TileMode;

    invoke-virtual {v0, v1, v2}, Landroid/graphics/drawable/BitmapDrawable;->setTileModeXY(Landroid/graphics/Shader$TileMode;Landroid/graphics/Shader$TileMode;)V

    .line 82
    iget-object v1, p0, Lcom/android/mail/browse/SuperCollapsedBlock;->mBackgroundView:Landroid/view/View;

    invoke-virtual {v1, v0}, Landroid/view/View;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 83
    return-void
.end method

.method public setCount(I)V
    .locals 2
    .param p1, "count"    # I

    .prologue
    .line 91
    iget-object v0, p0, Lcom/android/mail/browse/SuperCollapsedBlock;->mCountView:Landroid/widget/TextView;

    invoke-static {p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 92
    iget-object v0, p0, Lcom/android/mail/browse/SuperCollapsedBlock;->mIconView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->setLevel(I)Z

    .line 93
    return-void
.end method
