.class Lcom/android/mail/compose/QuotedTextView;
.super Landroid/widget/LinearLayout;
.source "QuotedTextView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/compose/QuotedTextView$RespondInlineListener;,
        Lcom/android/mail/compose/QuotedTextView$ShowHideQuotedTextListener;
    }
.end annotation


# static fields
.field private static final HEADER_SEPARATOR_LENGTH:I

.field private static sQuoteBegin:Ljava/lang/String;


# instance fields
.field private mIncludeText:Z

.field private mQuotedText:Ljava/lang/CharSequence;

.field private mQuotedTextWebView:Landroid/webkit/WebView;

.field private mRespondInlineButton:Landroid/widget/Button;

.field private mRespondInlineListener:Lcom/android/mail/compose/QuotedTextView$RespondInlineListener;

.field private mShowHideCheckBox:Landroid/widget/CheckBox;

.field private mShowHideListener:Lcom/android/mail/compose/QuotedTextView$ShowHideQuotedTextListener;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 59
    const-string v0, "<br type=\'attribution\'>"

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    sput v0, Lcom/android/mail/compose/QuotedTextView;->HEADER_SEPARATOR_LENGTH:I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 71
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/android/mail/compose/QuotedTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 72
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 75
    const/4 v0, -0x1

    invoke-direct {p0, p1, p2, v0}, Lcom/android/mail/compose/QuotedTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 76
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    const/4 v3, 0x1

    .line 79
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 65
    iput-boolean v3, p0, Lcom/android/mail/compose/QuotedTextView;->mIncludeText:Z

    .line 80
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 81
    .local v0, "factory":Landroid/view/LayoutInflater;
    const v2, 0x7f040061

    invoke-virtual {v0, v2, p0}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 83
    const v2, 0x7f1000e4

    invoke-virtual {p0, v2}, Lcom/android/mail/compose/QuotedTextView;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/webkit/WebView;

    iput-object v2, p0, Lcom/android/mail/compose/QuotedTextView;->mQuotedTextWebView:Landroid/webkit/WebView;

    .line 84
    iget-object v2, p0, Lcom/android/mail/compose/QuotedTextView;->mQuotedTextWebView:Landroid/webkit/WebView;

    invoke-static {v2}, Lcom/android/mail/utils/Utils;->restrictWebView(Landroid/webkit/WebView;)V

    .line 85
    iget-object v2, p0, Lcom/android/mail/compose/QuotedTextView;->mQuotedTextWebView:Landroid/webkit/WebView;

    invoke-virtual {v2}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v1

    .line 86
    .local v1, "settings":Landroid/webkit/WebSettings;
    invoke-virtual {v1, v3}, Landroid/webkit/WebSettings;->setBlockNetworkLoads(Z)V

    .line 88
    const v2, 0x7f1000e0

    invoke-virtual {p0, v2}, Lcom/android/mail/compose/QuotedTextView;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/CheckBox;

    iput-object v2, p0, Lcom/android/mail/compose/QuotedTextView;->mShowHideCheckBox:Landroid/widget/CheckBox;

    .line 89
    iget-object v2, p0, Lcom/android/mail/compose/QuotedTextView;->mShowHideCheckBox:Landroid/widget/CheckBox;

    invoke-virtual {v2, v3}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 90
    iget-object v2, p0, Lcom/android/mail/compose/QuotedTextView;->mShowHideCheckBox:Landroid/widget/CheckBox;

    invoke-virtual {v2, p0}, Landroid/widget/CheckBox;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 91
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0c0106

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lcom/android/mail/compose/QuotedTextView;->sQuoteBegin:Ljava/lang/String;

    .line 92
    const v2, 0x7f1000e1

    invoke-virtual {p0, v2}, Lcom/android/mail/compose/QuotedTextView;->findViewById(I)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 95
    const v2, 0x7f1000e2

    invoke-virtual {p0, v2}, Lcom/android/mail/compose/QuotedTextView;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    iput-object v2, p0, Lcom/android/mail/compose/QuotedTextView;->mRespondInlineButton:Landroid/widget/Button;

    .line 96
    iget-object v2, p0, Lcom/android/mail/compose/QuotedTextView;->mRespondInlineButton:Landroid/widget/Button;

    if-eqz v2, :cond_0

    .line 97
    iget-object v2, p0, Lcom/android/mail/compose/QuotedTextView;->mRespondInlineButton:Landroid/widget/Button;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setEnabled(Z)V

    .line 99
    :cond_0
    return-void
.end method

.method public static containsQuotedText(Ljava/lang/String;)Z
    .locals 2
    .param p0, "text"    # Ljava/lang/String;

    .prologue
    .line 326
    sget-object v1, Lcom/android/mail/compose/QuotedTextView;->sQuoteBegin:Ljava/lang/String;

    invoke-virtual {p0, v1}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    .line 327
    .local v0, "pos":I
    if-ltz v0, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static findQuotedTextIndex(Ljava/lang/CharSequence;)I
    .locals 2
    .param p0, "htmlText"    # Ljava/lang/CharSequence;

    .prologue
    .line 340
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 341
    const/4 v1, -0x1

    .line 344
    :goto_0
    return v1

    .line 343
    :cond_0
    invoke-virtual {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 344
    .local v0, "textString":Ljava/lang/String;
    sget-object v1, Lcom/android/mail/compose/QuotedTextView;->sQuoteBegin:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    goto :goto_0
.end method

.method private getHtmlText(Lcom/android/mail/providers/Message;)Ljava/lang/String;
    .locals 2
    .param p1, "message"    # Lcom/android/mail/providers/Message;

    .prologue
    .line 241
    iget-object v0, p1, Lcom/android/mail/providers/Message;->bodyHtml:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 242
    iget-object v0, p1, Lcom/android/mail/providers/Message;->bodyHtml:Ljava/lang/String;

    .line 247
    :goto_0
    return-object v0

    .line 243
    :cond_0
    iget-object v0, p1, Lcom/android/mail/providers/Message;->bodyText:Ljava/lang/String;

    if-eqz v0, :cond_1

    .line 245
    new-instance v0, Landroid/text/SpannedString;

    iget-object v1, p1, Lcom/android/mail/providers/Message;->bodyText:Ljava/lang/String;

    invoke-direct {v0, v1}, Landroid/text/SpannedString;-><init>(Ljava/lang/CharSequence;)V

    invoke-static {v0}, Landroid/text/Html;->toHtml(Landroid/text/Spanned;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 247
    :cond_1
    const-string v0, ""

    goto :goto_0
.end method

.method public static getQuotedTextOffset(Ljava/lang/String;)I
    .locals 2
    .param p0, "text"    # Ljava/lang/String;

    .prologue
    .line 331
    const-string v0, "<br type=\'attribution\'>"

    invoke-virtual {p0, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    sget v1, Lcom/android/mail/compose/QuotedTextView;->HEADER_SEPARATOR_LENGTH:I

    add-int/2addr v0, v1

    return v0
.end method

.method private populateData()V
    .locals 8

    .prologue
    const/4 v1, 0x0

    .line 197
    invoke-virtual {p0}, Lcom/android/mail/compose/QuotedTextView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v3, 0x7f0c0006

    invoke-virtual {v0, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 199
    .local v6, "backgroundColor":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/android/mail/compose/QuotedTextView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v3, 0x7f0c0007

    invoke-virtual {v0, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v7

    .line 201
    .local v7, "fontColor":Ljava/lang/String;
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "<head><style type=\"text/css\">* body { background-color: "

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, "; color: "

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, "; }</style></head>"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v3, p0, Lcom/android/mail/compose/QuotedTextView;->mQuotedText:Ljava/lang/CharSequence;

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 204
    .local v2, "html":Ljava/lang/String;
    iget-object v0, p0, Lcom/android/mail/compose/QuotedTextView;->mQuotedTextWebView:Landroid/webkit/WebView;

    const-string v3, "text/html"

    const-string v4, "utf-8"

    move-object v5, v1

    invoke-virtual/range {v0 .. v5}, Landroid/webkit/WebView;->loadDataWithBaseURL(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 205
    return-void
.end method

.method private respondInline()V
    .locals 6

    .prologue
    const/16 v5, 0x8

    .line 210
    invoke-virtual {p0}, Lcom/android/mail/compose/QuotedTextView;->getQuotedText()Ljava/lang/CharSequence;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/android/mail/utils/Utils;->convertHtmlToPlainText(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 211
    .local v0, "plainText":Ljava/lang/String;
    iget-object v2, p0, Lcom/android/mail/compose/QuotedTextView;->mRespondInlineListener:Lcom/android/mail/compose/QuotedTextView$RespondInlineListener;

    if-eqz v2, :cond_0

    .line 212
    iget-object v2, p0, Lcom/android/mail/compose/QuotedTextView;->mRespondInlineListener:Lcom/android/mail/compose/QuotedTextView$RespondInlineListener;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "\n"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Lcom/android/mail/compose/QuotedTextView$RespondInlineListener;->onRespondInline(Ljava/lang/String;)V

    .line 215
    :cond_0
    const/4 v2, 0x0

    invoke-virtual {p0, v2}, Lcom/android/mail/compose/QuotedTextView;->updateCheckedState(Z)V

    .line 216
    iget-object v2, p0, Lcom/android/mail/compose/QuotedTextView;->mRespondInlineButton:Landroid/widget/Button;

    invoke-virtual {v2, v5}, Landroid/widget/Button;->setVisibility(I)V

    .line 218
    const v2, 0x7f1000dc

    invoke-virtual {p0, v2}, Lcom/android/mail/compose/QuotedTextView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 219
    .local v1, "quotedTextView":Landroid/view/View;
    if-eqz v1, :cond_1

    .line 220
    invoke-virtual {v1, v5}, Landroid/view/View;->setVisibility(I)V

    .line 222
    :cond_1
    return-void
.end method

.method private setQuotedText(Ljava/lang/CharSequence;)V
    .locals 3
    .param p1, "quotedText"    # Ljava/lang/CharSequence;

    .prologue
    const/4 v2, 0x0

    .line 310
    iput-object p1, p0, Lcom/android/mail/compose/QuotedTextView;->mQuotedText:Ljava/lang/CharSequence;

    .line 311
    invoke-direct {p0}, Lcom/android/mail/compose/QuotedTextView;->populateData()V

    .line 312
    iget-object v0, p0, Lcom/android/mail/compose/QuotedTextView;->mRespondInlineButton:Landroid/widget/Button;

    if-eqz v0, :cond_0

    .line 313
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 314
    iget-object v0, p0, Lcom/android/mail/compose/QuotedTextView;->mRespondInlineButton:Landroid/widget/Button;

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setVisibility(I)V

    .line 315
    iget-object v0, p0, Lcom/android/mail/compose/QuotedTextView;->mRespondInlineButton:Landroid/widget/Button;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setEnabled(Z)V

    .line 316
    iget-object v0, p0, Lcom/android/mail/compose/QuotedTextView;->mRespondInlineButton:Landroid/widget/Button;

    invoke-virtual {v0, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 323
    :cond_0
    :goto_0
    return-void

    .line 319
    :cond_1
    iget-object v0, p0, Lcom/android/mail/compose/QuotedTextView;->mRespondInlineButton:Landroid/widget/Button;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setVisibility(I)V

    .line 320
    iget-object v0, p0, Lcom/android/mail/compose/QuotedTextView;->mRespondInlineButton:Landroid/widget/Button;

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setEnabled(Z)V

    goto :goto_0
.end method

.method private updateQuotedTextVisibility(Z)V
    .locals 2
    .param p1, "show"    # Z

    .prologue
    .line 192
    iget-object v1, p0, Lcom/android/mail/compose/QuotedTextView;->mQuotedTextWebView:Landroid/webkit/WebView;

    if-eqz p1, :cond_0

    const/4 v0, 0x0

    :goto_0
    invoke-virtual {v1, v0}, Landroid/webkit/WebView;->setVisibility(I)V

    .line 193
    iput-boolean p1, p0, Lcom/android/mail/compose/QuotedTextView;->mIncludeText:Z

    .line 194
    return-void

    .line 192
    :cond_0
    const/16 v0, 0x8

    goto :goto_0
.end method


# virtual methods
.method public allowQuotedText(Z)V
    .locals 2
    .param p1, "allow"    # Z

    .prologue
    .line 112
    const v1, 0x7f1000df

    invoke-virtual {p0, v1}, Lcom/android/mail/compose/QuotedTextView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 113
    .local v0, "quotedTextRow":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 114
    if-eqz p1, :cond_1

    const/4 v1, 0x0

    :goto_0
    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 116
    :cond_0
    return-void

    .line 114
    :cond_1
    const/4 v1, 0x4

    goto :goto_0
.end method

.method public allowRespondInline(Z)V
    .locals 2
    .param p1, "allow"    # Z

    .prologue
    .line 123
    iget-object v0, p0, Lcom/android/mail/compose/QuotedTextView;->mRespondInlineButton:Landroid/widget/Button;

    if-eqz v0, :cond_0

    .line 124
    iget-object v1, p0, Lcom/android/mail/compose/QuotedTextView;->mRespondInlineButton:Landroid/widget/Button;

    if-eqz p1, :cond_1

    const/4 v0, 0x0

    :goto_0
    invoke-virtual {v1, v0}, Landroid/widget/Button;->setVisibility(I)V

    .line 126
    :cond_0
    return-void

    .line 124
    :cond_1
    const/16 v0, 0x8

    goto :goto_0
.end method

.method public getQuotedText()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 143
    iget-object v0, p0, Lcom/android/mail/compose/QuotedTextView;->mQuotedText:Ljava/lang/CharSequence;

    return-object v0
.end method

.method public getQuotedTextIfIncluded()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 133
    iget-boolean v0, p0, Lcom/android/mail/compose/QuotedTextView;->mIncludeText:Z

    if-eqz v0, :cond_0

    .line 134
    iget-object v0, p0, Lcom/android/mail/compose/QuotedTextView;->mQuotedText:Ljava/lang/CharSequence;

    .line 136
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isTextIncluded()Z
    .locals 1

    .prologue
    .line 150
    iget-boolean v0, p0, Lcom/android/mail/compose/QuotedTextView;->mIncludeText:Z

    return v0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 164
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 176
    :goto_0
    return-void

    .line 166
    :pswitch_0
    invoke-direct {p0}, Lcom/android/mail/compose/QuotedTextView;->respondInline()V

    goto :goto_0

    .line 170
    :pswitch_1
    iget-object v0, p0, Lcom/android/mail/compose/QuotedTextView;->mShowHideCheckBox:Landroid/widget/CheckBox;

    invoke-virtual {v0}, Landroid/widget/CheckBox;->isChecked()Z

    move-result v0

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/QuotedTextView;->updateCheckedState(Z)V

    goto :goto_0

    .line 173
    :pswitch_2
    iget-object v0, p0, Lcom/android/mail/compose/QuotedTextView;->mShowHideCheckBox:Landroid/widget/CheckBox;

    invoke-virtual {v0}, Landroid/widget/CheckBox;->isChecked()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_1
    invoke-virtual {p0, v0}, Lcom/android/mail/compose/QuotedTextView;->updateCheckedState(Z)V

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    goto :goto_1

    .line 164
    nop

    :pswitch_data_0
    .packed-switch 0x7f1000e0
        :pswitch_1
        :pswitch_2
        :pswitch_0
    .end packed-switch
.end method

.method public setQuotedText(ILcom/android/mail/providers/Message;Z)V
    .locals 11
    .param p1, "action"    # I
    .param p2, "refMessage"    # Lcom/android/mail/providers/Message;
    .param p3, "allow"    # Z

    .prologue
    .line 252
    const/4 v6, 0x0

    invoke-virtual {p0, v6}, Lcom/android/mail/compose/QuotedTextView;->setVisibility(I)V

    .line 253
    invoke-direct {p0, p2}, Lcom/android/mail/compose/QuotedTextView;->getHtmlText(Lcom/android/mail/providers/Message;)Ljava/lang/String;

    move-result-object v3

    .line 254
    .local v3, "htmlText":Ljava/lang/String;
    new-instance v4, Ljava/lang/StringBuffer;

    invoke-direct {v4}, Ljava/lang/StringBuffer;-><init>()V

    .line 255
    .local v4, "quotedText":Ljava/lang/StringBuffer;
    const/4 v6, 0x2

    const/4 v7, 0x3

    invoke-static {v6, v7}, Ljava/text/DateFormat;->getDateTimeInstance(II)Ljava/text/DateFormat;

    move-result-object v2

    .line 256
    .local v2, "dateFormat":Ljava/text/DateFormat;
    new-instance v1, Ljava/util/Date;

    iget-wide v6, p2, Lcom/android/mail/providers/Message;->dateReceivedMs:J

    invoke-direct {v1, v6, v7}, Ljava/util/Date;-><init>(J)V

    .line 257
    .local v1, "date":Ljava/util/Date;
    invoke-virtual {p0}, Lcom/android/mail/compose/QuotedTextView;->getContext()Landroid/content/Context;

    move-result-object v6

    invoke-virtual {v6}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    .line 258
    .local v5, "resources":Landroid/content/res/Resources;
    if-eqz p1, :cond_0

    const/4 v6, 0x1

    if-ne p1, v6, :cond_2

    .line 259
    :cond_0
    sget-object v6, Lcom/android/mail/compose/QuotedTextView;->sQuoteBegin:Ljava/lang/String;

    invoke-virtual {v4, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 260
    const v6, 0x7f0c0029

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    const/4 v7, 0x2

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    invoke-virtual {v2, v1}, Ljava/text/DateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v7, v8

    const/4 v8, 0x1

    iget-object v9, p2, Lcom/android/mail/providers/Message;->from:Ljava/lang/String;

    const/4 v10, 0x1

    invoke-static {v9, v10}, Lcom/android/mail/utils/Utils;->cleanUpString(Ljava/lang/String;Z)Ljava/lang/Object;

    move-result-object v9

    aput-object v9, v7, v8

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 266
    const-string v6, "<br type=\'attribution\'>"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 267
    const-string v6, "<blockquote class=\"quote\" style=\"margin:0 0 0 .8ex;border-left:1px #ccc solid;padding-left:1ex\">"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 268
    invoke-virtual {v4, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 269
    const-string v6, "</blockquote>"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 270
    const-string v6, "</div>"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 289
    :cond_1
    :goto_0
    invoke-direct {p0, v4}, Lcom/android/mail/compose/QuotedTextView;->setQuotedText(Ljava/lang/CharSequence;)V

    .line 290
    invoke-virtual {p0, p3}, Lcom/android/mail/compose/QuotedTextView;->allowQuotedText(Z)V

    .line 293
    const/4 v6, 0x1

    invoke-virtual {p0, v6}, Lcom/android/mail/compose/QuotedTextView;->allowRespondInline(Z)V

    .line 294
    return-void

    .line 271
    :cond_2
    const/4 v6, 0x2

    if-ne p1, v6, :cond_1

    .line 272
    sget-object v6, Lcom/android/mail/compose/QuotedTextView;->sQuoteBegin:Ljava/lang/String;

    invoke-virtual {v4, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 273
    const v6, 0x7f0c002a

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    const/4 v7, 0x4

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    iget-object v9, p2, Lcom/android/mail/providers/Message;->from:Ljava/lang/String;

    const/4 v10, 0x1

    invoke-static {v9, v10}, Lcom/android/mail/utils/Utils;->cleanUpString(Ljava/lang/String;Z)Ljava/lang/Object;

    move-result-object v9

    aput-object v9, v7, v8

    const/4 v8, 0x1

    invoke-virtual {v2, v1}, Ljava/text/DateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v7, v8

    const/4 v8, 0x2

    iget-object v9, p2, Lcom/android/mail/providers/Message;->subject:Ljava/lang/String;

    const/4 v10, 0x0

    invoke-static {v9, v10}, Lcom/android/mail/utils/Utils;->cleanUpString(Ljava/lang/String;Z)Ljava/lang/Object;

    move-result-object v9

    aput-object v9, v7, v8

    const/4 v8, 0x3

    iget-object v9, p2, Lcom/android/mail/providers/Message;->to:Ljava/lang/String;

    const/4 v10, 0x1

    invoke-static {v9, v10}, Lcom/android/mail/utils/Utils;->cleanUpString(Ljava/lang/String;Z)Ljava/lang/Object;

    move-result-object v9

    aput-object v9, v7, v8

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 280
    iget-object v0, p2, Lcom/android/mail/providers/Message;->cc:Ljava/lang/String;

    .line 281
    .local v0, "ccAddresses":Ljava/lang/String;
    const v6, 0x7f0c002b

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    const/4 v9, 0x1

    invoke-static {v0, v9}, Lcom/android/mail/utils/Utils;->cleanUpString(Ljava/lang/String;Z)Ljava/lang/Object;

    move-result-object v9

    aput-object v9, v7, v8

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 283
    const-string v6, "<br type=\'attribution\'>"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 284
    const-string v6, "<blockquote class=\"quote\" style=\"margin:0 0 0 .8ex;border-left:1px #ccc solid;padding-left:1ex\">"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 285
    invoke-virtual {v4, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 286
    const-string v6, "</blockquote>"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 287
    const-string v6, "</div>"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_0
.end method

.method public setQuotedTextFromDraft(Ljava/lang/CharSequence;Z)V
    .locals 2
    .param p1, "htmlText"    # Ljava/lang/CharSequence;
    .param p2, "forward"    # Z

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 297
    invoke-virtual {p0, v0}, Lcom/android/mail/compose/QuotedTextView;->setVisibility(I)V

    .line 298
    invoke-direct {p0, p1}, Lcom/android/mail/compose/QuotedTextView;->setQuotedText(Ljava/lang/CharSequence;)V

    .line 299
    if-nez p2, :cond_0

    move v0, v1

    :cond_0
    invoke-virtual {p0, v0}, Lcom/android/mail/compose/QuotedTextView;->allowQuotedText(Z)V

    .line 302
    invoke-virtual {p0, v1}, Lcom/android/mail/compose/QuotedTextView;->allowRespondInline(Z)V

    .line 303
    return-void
.end method

.method public setRespondInlineListener(Lcom/android/mail/compose/QuotedTextView$RespondInlineListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/android/mail/compose/QuotedTextView$RespondInlineListener;

    .prologue
    .line 159
    iput-object p1, p0, Lcom/android/mail/compose/QuotedTextView;->mRespondInlineListener:Lcom/android/mail/compose/QuotedTextView$RespondInlineListener;

    .line 160
    return-void
.end method

.method public setUpperDividerVisible(Z)V
    .locals 2
    .param p1, "visible"    # Z

    .prologue
    .line 348
    const v0, 0x7f1000dd

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/QuotedTextView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    if-eqz p1, :cond_0

    const/4 v0, 0x0

    :goto_0
    invoke-virtual {v1, v0}, Landroid/view/View;->setVisibility(I)V

    .line 350
    return-void

    .line 348
    :cond_0
    const/16 v0, 0x8

    goto :goto_0
.end method

.method public updateCheckedState(Z)V
    .locals 1
    .param p1, "checked"    # Z

    .prologue
    .line 184
    iget-object v0, p0, Lcom/android/mail/compose/QuotedTextView;->mShowHideCheckBox:Landroid/widget/CheckBox;

    invoke-virtual {v0, p1}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 185
    invoke-direct {p0, p1}, Lcom/android/mail/compose/QuotedTextView;->updateQuotedTextVisibility(Z)V

    .line 186
    iget-object v0, p0, Lcom/android/mail/compose/QuotedTextView;->mShowHideListener:Lcom/android/mail/compose/QuotedTextView$ShowHideQuotedTextListener;

    if-eqz v0, :cond_0

    .line 187
    iget-object v0, p0, Lcom/android/mail/compose/QuotedTextView;->mShowHideListener:Lcom/android/mail/compose/QuotedTextView$ShowHideQuotedTextListener;

    invoke-interface {v0, p1}, Lcom/android/mail/compose/QuotedTextView$ShowHideQuotedTextListener;->onShowHideQuotedText(Z)V

    .line 189
    :cond_0
    return-void
.end method
