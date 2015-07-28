.class public Lcom/android/mail/browse/ScrollIndicatorsView;
.super Landroid/view/View;
.source "ScrollIndicatorsView.java"

# interfaces
.implements Lcom/android/mail/browse/ScrollNotifier$ScrollListener;


# instance fields
.field private mSource:Lcom/android/mail/browse/ScrollNotifier;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 22
    invoke-direct {p0, p1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 23
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 26
    invoke-direct {p0, p1, p2}, Landroid/view/View;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 27
    return-void
.end method


# virtual methods
.method protected computeHorizontalScrollExtent()I
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/android/mail/browse/ScrollIndicatorsView;->mSource:Lcom/android/mail/browse/ScrollNotifier;

    invoke-interface {v0}, Lcom/android/mail/browse/ScrollNotifier;->computeHorizontalScrollExtent()I

    move-result v0

    return v0
.end method

.method protected computeHorizontalScrollOffset()I
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/android/mail/browse/ScrollIndicatorsView;->mSource:Lcom/android/mail/browse/ScrollNotifier;

    invoke-interface {v0}, Lcom/android/mail/browse/ScrollNotifier;->computeHorizontalScrollOffset()I

    move-result v0

    return v0
.end method

.method protected computeHorizontalScrollRange()I
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/android/mail/browse/ScrollIndicatorsView;->mSource:Lcom/android/mail/browse/ScrollNotifier;

    invoke-interface {v0}, Lcom/android/mail/browse/ScrollNotifier;->computeHorizontalScrollRange()I

    move-result v0

    return v0
.end method

.method protected computeVerticalScrollExtent()I
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/android/mail/browse/ScrollIndicatorsView;->mSource:Lcom/android/mail/browse/ScrollNotifier;

    invoke-interface {v0}, Lcom/android/mail/browse/ScrollNotifier;->computeVerticalScrollExtent()I

    move-result v0

    return v0
.end method

.method protected computeVerticalScrollOffset()I
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/android/mail/browse/ScrollIndicatorsView;->mSource:Lcom/android/mail/browse/ScrollNotifier;

    invoke-interface {v0}, Lcom/android/mail/browse/ScrollNotifier;->computeVerticalScrollOffset()I

    move-result v0

    return v0
.end method

.method protected computeVerticalScrollRange()I
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/android/mail/browse/ScrollIndicatorsView;->mSource:Lcom/android/mail/browse/ScrollNotifier;

    invoke-interface {v0}, Lcom/android/mail/browse/ScrollNotifier;->computeVerticalScrollRange()I

    move-result v0

    return v0
.end method

.method public onNotifierScroll(II)V
    .locals 0
    .param p1, "left"    # I
    .param p2, "top"    # I

    .prologue
    .line 66
    invoke-virtual {p0}, Lcom/android/mail/browse/ScrollIndicatorsView;->awakenScrollBars()Z

    .line 67
    return-void
.end method

.method public setSourceView(Lcom/android/mail/browse/ScrollNotifier;)V
    .locals 1
    .param p1, "notifier"    # Lcom/android/mail/browse/ScrollNotifier;

    .prologue
    .line 30
    iput-object p1, p0, Lcom/android/mail/browse/ScrollIndicatorsView;->mSource:Lcom/android/mail/browse/ScrollNotifier;

    .line 31
    iget-object v0, p0, Lcom/android/mail/browse/ScrollIndicatorsView;->mSource:Lcom/android/mail/browse/ScrollNotifier;

    invoke-interface {v0, p0}, Lcom/android/mail/browse/ScrollNotifier;->addScrollListener(Lcom/android/mail/browse/ScrollNotifier$ScrollListener;)V

    .line 32
    return-void
.end method
