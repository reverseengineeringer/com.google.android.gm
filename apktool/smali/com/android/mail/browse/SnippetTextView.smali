.class public Lcom/android/mail/browse/SnippetTextView;
.super Landroid/widget/TextView;
.source "SnippetTextView.java"


# instance fields
.field private mLastHSpec:I

.field private mLastWSpec:I

.field private mMaxLines:I


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 38
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/android/mail/browse/SnippetTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 39
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 42
    invoke-direct {p0, p1, p2}, Landroid/widget/TextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 43
    return-void
.end method


# virtual methods
.method public getTextRemainder(Ljava/lang/String;)Ljava/lang/String;
    .locals 7
    .param p1, "text"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 60
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v5

    if-nez v5, :cond_2

    :cond_0
    move-object p1, v2

    .line 91
    .end local p1    # "text":Ljava/lang/String;
    :cond_1
    :goto_0
    return-object p1

    .line 65
    .restart local p1    # "text":Ljava/lang/String;
    :cond_2
    invoke-virtual {p0}, Lcom/android/mail/browse/SnippetTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v4

    .line 66
    .local v4, "savedText":Ljava/lang/CharSequence;
    invoke-virtual {p0}, Lcom/android/mail/browse/SnippetTextView;->getEllipsize()Landroid/text/TextUtils$TruncateAt;

    move-result-object v3

    .line 67
    .local v3, "savedEllipsize":Landroid/text/TextUtils$TruncateAt;
    invoke-virtual {p0, v2}, Lcom/android/mail/browse/SnippetTextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V

    .line 68
    invoke-virtual {p0, p1}, Lcom/android/mail/browse/SnippetTextView;->setText(Ljava/lang/CharSequence;)V

    .line 70
    invoke-virtual {p0}, Lcom/android/mail/browse/SnippetTextView;->getLayout()Landroid/text/Layout;

    move-result-object v0

    .line 72
    .local v0, "layout":Landroid/text/Layout;
    if-nez v0, :cond_3

    .line 73
    iget v5, p0, Lcom/android/mail/browse/SnippetTextView;->mLastWSpec:I

    iget v6, p0, Lcom/android/mail/browse/SnippetTextView;->mLastHSpec:I

    invoke-virtual {p0, v5, v6}, Lcom/android/mail/browse/SnippetTextView;->measure(II)V

    .line 74
    invoke-virtual {p0}, Lcom/android/mail/browse/SnippetTextView;->getLayout()Landroid/text/Layout;

    move-result-object v0

    .line 77
    :cond_3
    if-eqz v0, :cond_1

    .line 82
    invoke-virtual {v0}, Landroid/text/Layout;->getLineCount()I

    move-result v1

    .line 83
    .local v1, "lineCount":I
    iget v5, p0, Lcom/android/mail/browse/SnippetTextView;->mMaxLines:I

    if-gt v1, v5, :cond_4

    .line 84
    const/4 v2, 0x0

    .line 89
    .local v2, "remainder":Ljava/lang/String;
    :goto_1
    invoke-virtual {p0, v3}, Lcom/android/mail/browse/SnippetTextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V

    .line 90
    invoke-virtual {p0, v4}, Lcom/android/mail/browse/SnippetTextView;->setText(Ljava/lang/CharSequence;)V

    move-object p1, v2

    .line 91
    goto :goto_0

    .line 86
    .end local v2    # "remainder":Ljava/lang/String;
    :cond_4
    iget v5, p0, Lcom/android/mail/browse/SnippetTextView;->mMaxLines:I

    invoke-virtual {v0, v5}, Landroid/text/Layout;->getLineStart(I)I

    move-result v5

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v6

    invoke-virtual {p1, v5, v6}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    .restart local v2    # "remainder":Ljava/lang/String;
    goto :goto_1
.end method

.method protected onMeasure(II)V
    .locals 0
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 53
    invoke-super {p0, p1, p2}, Landroid/widget/TextView;->onMeasure(II)V

    .line 55
    iput p1, p0, Lcom/android/mail/browse/SnippetTextView;->mLastWSpec:I

    .line 56
    iput p2, p0, Lcom/android/mail/browse/SnippetTextView;->mLastHSpec:I

    .line 57
    return-void
.end method

.method public setMaxLines(I)V
    .locals 0
    .param p1, "maxlines"    # I

    .prologue
    .line 47
    invoke-super {p0, p1}, Landroid/widget/TextView;->setMaxLines(I)V

    .line 48
    iput p1, p0, Lcom/android/mail/browse/SnippetTextView;->mMaxLines:I

    .line 49
    return-void
.end method
