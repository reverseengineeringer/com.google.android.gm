.class Lcom/android/ex/photo/PhotoViewPager$1;
.super Ljava/lang/Object;
.source "PhotoViewPager.java"

# interfaces
.implements Landroid/support/v4/view/ViewPager$PageTransformer;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/ex/photo/PhotoViewPager;->initialize()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/ex/photo/PhotoViewPager;


# direct methods
.method constructor <init>(Lcom/android/ex/photo/PhotoViewPager;)V
    .locals 0

    .prologue
    .line 78
    iput-object p1, p0, Lcom/android/ex/photo/PhotoViewPager$1;->this$0:Lcom/android/ex/photo/PhotoViewPager;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public transformPage(Landroid/view/View;F)V
    .locals 5
    .param p1, "page"    # Landroid/view/View;
    .param p2, "position"    # F

    .prologue
    const/4 v4, 0x0

    const/high16 v3, 0x3f800000    # 1.0f

    .line 90
    cmpg-float v1, p2, v4

    if-ltz v1, :cond_0

    cmpl-float v1, p2, v3

    if-ltz v1, :cond_1

    .line 91
    :cond_0
    invoke-virtual {p1, v4}, Landroid/view/View;->setTranslationX(F)V

    .line 92
    invoke-virtual {p1, v3}, Landroid/view/View;->setAlpha(F)V

    .line 93
    invoke-virtual {p1, v3}, Landroid/view/View;->setScaleX(F)V

    .line 94
    invoke-virtual {p1, v3}, Landroid/view/View;->setScaleY(F)V

    .line 102
    :goto_0
    return-void

    .line 96
    :cond_1
    neg-float v1, p2

    invoke-virtual {p1}, Landroid/view/View;->getWidth()I

    move-result v2

    int-to-float v2, v2

    mul-float/2addr v1, v2

    invoke-virtual {p1, v1}, Landroid/view/View;->setTranslationX(F)V

    .line 97
    sub-float v1, v3, p2

    invoke-static {v4, v1}, Ljava/lang/Math;->max(FF)F

    move-result v1

    invoke-virtual {p1, v1}, Landroid/view/View;->setAlpha(F)V

    .line 98
    const v1, 0x3e99999a    # 0.3f

    mul-float/2addr v1, p2

    sub-float v1, v3, v1

    invoke-static {v4, v1}, Ljava/lang/Math;->max(FF)F

    move-result v0

    .line 99
    .local v0, "scale":F
    invoke-virtual {p1, v0}, Landroid/view/View;->setScaleX(F)V

    .line 100
    invoke-virtual {p1, v0}, Landroid/view/View;->setScaleY(F)V

    goto :goto_0
.end method
