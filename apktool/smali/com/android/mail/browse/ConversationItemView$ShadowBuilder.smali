.class Lcom/android/mail/browse/ConversationItemView$ShadowBuilder;
.super Landroid/view/View$DragShadowBuilder;
.source "ConversationItemView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/browse/ConversationItemView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ShadowBuilder"
.end annotation


# instance fields
.field private final mBackground:Landroid/graphics/drawable/Drawable;

.field private final mDragDesc:Ljava/lang/String;

.field private mDragDescX:I

.field private mDragDescY:I

.field private final mTouchX:I

.field private final mTouchY:I

.field private final mView:Landroid/view/View;

.field final synthetic this$0:Lcom/android/mail/browse/ConversationItemView;


# direct methods
.method public constructor <init>(Lcom/android/mail/browse/ConversationItemView;Landroid/view/View;III)V
    .locals 2
    .param p2, "view"    # Landroid/view/View;
    .param p3, "count"    # I
    .param p4, "touchX"    # I
    .param p5, "touchY"    # I

    .prologue
    .line 1595
    iput-object p1, p0, Lcom/android/mail/browse/ConversationItemView$ShadowBuilder;->this$0:Lcom/android/mail/browse/ConversationItemView;

    .line 1596
    invoke-direct {p0, p2}, Landroid/view/View$DragShadowBuilder;-><init>(Landroid/view/View;)V

    .line 1597
    iput-object p2, p0, Lcom/android/mail/browse/ConversationItemView$ShadowBuilder;->mView:Landroid/view/View;

    .line 1598
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView$ShadowBuilder;->mView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f020081

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/ConversationItemView$ShadowBuilder;->mBackground:Landroid/graphics/drawable/Drawable;

    .line 1599
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView$ShadowBuilder;->mView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    const v1, 0x7f110001

    invoke-static {v0, v1, p3}, Lcom/android/mail/utils/Utils;->formatPlural(Landroid/content/Context;II)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/ConversationItemView$ShadowBuilder;->mDragDesc:Ljava/lang/String;

    .line 1600
    iput p4, p0, Lcom/android/mail/browse/ConversationItemView$ShadowBuilder;->mTouchX:I

    .line 1601
    iput p5, p0, Lcom/android/mail/browse/ConversationItemView$ShadowBuilder;->mTouchY:I

    .line 1602
    return-void
.end method


# virtual methods
.method public onDrawShadow(Landroid/graphics/Canvas;)V
    .locals 4
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/4 v3, 0x0

    .line 1617
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView$ShadowBuilder;->mBackground:Landroid/graphics/drawable/Drawable;

    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView$ShadowBuilder;->mView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getWidth()I

    move-result v1

    iget-object v2, p0, Lcom/android/mail/browse/ConversationItemView$ShadowBuilder;->mView:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getHeight()I

    move-result v2

    invoke-virtual {v0, v3, v3, v1, v2}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 1618
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView$ShadowBuilder;->mBackground:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 1619
    # getter for: Lcom/android/mail/browse/ConversationItemView;->sPaint:Landroid/text/TextPaint;
    invoke-static {}, Lcom/android/mail/browse/ConversationItemView;->access$400()Landroid/text/TextPaint;

    move-result-object v0

    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView$ShadowBuilder;->this$0:Lcom/android/mail/browse/ConversationItemView;

    iget-object v1, v1, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v1, v1, Lcom/android/mail/browse/ConversationItemViewCoordinates;->subjectFontSize:I

    int-to-float v1, v1

    invoke-virtual {v0, v1}, Landroid/text/TextPaint;->setTextSize(F)V

    .line 1620
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView$ShadowBuilder;->mDragDesc:Ljava/lang/String;

    iget v1, p0, Lcom/android/mail/browse/ConversationItemView$ShadowBuilder;->mDragDescX:I

    int-to-float v1, v1

    iget v2, p0, Lcom/android/mail/browse/ConversationItemView$ShadowBuilder;->mDragDescY:I

    int-to-float v2, v2

    # getter for: Lcom/android/mail/browse/ConversationItemView;->sPaint:Landroid/text/TextPaint;
    invoke-static {}, Lcom/android/mail/browse/ConversationItemView;->access$400()Landroid/text/TextPaint;

    move-result-object v3

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 1621
    return-void
.end method

.method public onProvideShadowMetrics(Landroid/graphics/Point;Landroid/graphics/Point;)V
    .locals 4
    .param p1, "shadowSize"    # Landroid/graphics/Point;
    .param p2, "shadowTouchPoint"    # Landroid/graphics/Point;

    .prologue
    .line 1606
    iget-object v2, p0, Lcom/android/mail/browse/ConversationItemView$ShadowBuilder;->mView:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getWidth()I

    move-result v1

    .line 1607
    .local v1, "width":I
    iget-object v2, p0, Lcom/android/mail/browse/ConversationItemView$ShadowBuilder;->mView:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getHeight()I

    move-result v0

    .line 1608
    .local v0, "height":I
    iget-object v2, p0, Lcom/android/mail/browse/ConversationItemView$ShadowBuilder;->this$0:Lcom/android/mail/browse/ConversationItemView;

    iget-object v2, v2, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v2, v2, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sendersX:I

    iput v2, p0, Lcom/android/mail/browse/ConversationItemView$ShadowBuilder;->mDragDescX:I

    .line 1609
    iget-object v2, p0, Lcom/android/mail/browse/ConversationItemView$ShadowBuilder;->this$0:Lcom/android/mail/browse/ConversationItemView;

    iget-object v2, v2, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v2, v2, Lcom/android/mail/browse/ConversationItemViewCoordinates;->subjectFontSize:I

    # invokes: Lcom/android/mail/browse/ConversationItemView;->getPadding(II)I
    invoke-static {v0, v2}, Lcom/android/mail/browse/ConversationItemView;->access$100(II)I

    move-result v2

    iget-object v3, p0, Lcom/android/mail/browse/ConversationItemView$ShadowBuilder;->this$0:Lcom/android/mail/browse/ConversationItemView;

    iget-object v3, v3, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v3, v3, Lcom/android/mail/browse/ConversationItemViewCoordinates;->subjectAscent:I

    sub-int/2addr v2, v3

    iput v2, p0, Lcom/android/mail/browse/ConversationItemView$ShadowBuilder;->mDragDescY:I

    .line 1611
    invoke-virtual {p1, v1, v0}, Landroid/graphics/Point;->set(II)V

    .line 1612
    iget v2, p0, Lcom/android/mail/browse/ConversationItemView$ShadowBuilder;->mTouchX:I

    iget v3, p0, Lcom/android/mail/browse/ConversationItemView$ShadowBuilder;->mTouchY:I

    invoke-virtual {p2, v2, v3}, Landroid/graphics/Point;->set(II)V

    .line 1613
    return-void
.end method
