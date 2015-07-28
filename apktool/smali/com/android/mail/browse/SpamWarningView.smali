.class public Lcom/android/mail/browse/SpamWarningView;
.super Landroid/widget/RelativeLayout;
.source "SpamWarningView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field private final mHighWarningColor:I

.field private final mLowWarningColor:I

.field private mSpamWarningIcon:Landroid/widget/ImageView;

.field private mSpamWarningLink:Landroid/widget/TextView;

.field private mSpamWarningText:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 25
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/android/mail/browse/SpamWarningView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 26
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 29
    invoke-direct {p0, p1, p2}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 31
    invoke-virtual {p0}, Lcom/android/mail/browse/SpamWarningView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f090027

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    iput v0, p0, Lcom/android/mail/browse/SpamWarningView;->mHighWarningColor:I

    .line 32
    invoke-virtual {p0}, Lcom/android/mail/browse/SpamWarningView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f090020

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    iput v0, p0, Lcom/android/mail/browse/SpamWarningView;->mLowWarningColor:I

    .line 33
    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 47
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    .line 49
    .local v0, "id":I
    packed-switch v0, :pswitch_data_0

    .line 58
    :pswitch_0
    return-void

    .line 49
    :pswitch_data_0
    .packed-switch 0x7f100097
        :pswitch_0
    .end packed-switch
.end method

.method public onFinishInflate()V
    .locals 1

    .prologue
    .line 37
    invoke-virtual {p0, p0}, Lcom/android/mail/browse/SpamWarningView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 39
    const v0, 0x7f100098

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/SpamWarningView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/android/mail/browse/SpamWarningView;->mSpamWarningIcon:Landroid/widget/ImageView;

    .line 40
    const v0, 0x7f100099

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/SpamWarningView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/android/mail/browse/SpamWarningView;->mSpamWarningText:Landroid/widget/TextView;

    .line 41
    const v0, 0x7f10009a

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/SpamWarningView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/android/mail/browse/SpamWarningView;->mSpamWarningLink:Landroid/widget/TextView;

    .line 42
    iget-object v0, p0, Lcom/android/mail/browse/SpamWarningView;->mSpamWarningLink:Landroid/widget/TextView;

    invoke-virtual {v0, p0}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 43
    return-void
.end method

.method public showSpamWarning(Lcom/android/mail/providers/Message;Lcom/android/mail/providers/Address;)V
    .locals 9
    .param p1, "message"    # Lcom/android/mail/providers/Message;
    .param p2, "sender"    # Lcom/android/mail/providers/Address;

    .prologue
    const/4 v8, 0x2

    const/4 v7, 0x0

    .line 61
    invoke-virtual {p0, v7}, Lcom/android/mail/browse/SpamWarningView;->setVisibility(I)V

    .line 65
    invoke-virtual {p2}, Lcom/android/mail/providers/Address;->getAddress()Ljava/lang/String;

    move-result-object v1

    .line 66
    .local v1, "senderAddress":Ljava/lang/String;
    const/16 v3, 0x40

    invoke-virtual {v1, v3}, Ljava/lang/String;->indexOf(I)I

    move-result v3

    add-int/lit8 v3, v3, 0x1

    invoke-virtual {v1, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v2

    .line 67
    .local v2, "senderDomain":Ljava/lang/String;
    iget-object v3, p0, Lcom/android/mail/browse/SpamWarningView;->mSpamWarningText:Landroid/widget/TextView;

    iget-object v4, p1, Lcom/android/mail/providers/Message;->spamWarningString:Ljava/lang/String;

    new-array v5, v8, [Ljava/lang/Object;

    aput-object v1, v5, v7

    const/4 v6, 0x1

    aput-object v2, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 70
    iget v3, p1, Lcom/android/mail/providers/Message;->spamWarningLevel:I

    if-ne v3, v8, :cond_0

    .line 71
    iget-object v3, p0, Lcom/android/mail/browse/SpamWarningView;->mSpamWarningText:Landroid/widget/TextView;

    iget v4, p0, Lcom/android/mail/browse/SpamWarningView;->mHighWarningColor:I

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setTextColor(I)V

    .line 72
    iget-object v3, p0, Lcom/android/mail/browse/SpamWarningView;->mSpamWarningIcon:Landroid/widget/ImageView;

    const v4, 0x7f02002d

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 80
    :goto_0
    iget v0, p1, Lcom/android/mail/providers/Message;->spamLinkType:I

    .line 81
    .local v0, "linkType":I
    packed-switch v0, :pswitch_data_0

    .line 94
    :goto_1
    return-void

    .line 74
    .end local v0    # "linkType":I
    :cond_0
    iget-object v3, p0, Lcom/android/mail/browse/SpamWarningView;->mSpamWarningText:Landroid/widget/TextView;

    iget v4, p0, Lcom/android/mail/browse/SpamWarningView;->mLowWarningColor:I

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setTextColor(I)V

    .line 75
    iget-object v3, p0, Lcom/android/mail/browse/SpamWarningView;->mSpamWarningIcon:Landroid/widget/ImageView;

    const v4, 0x7f02002c

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_0

    .line 83
    .restart local v0    # "linkType":I
    :pswitch_0
    iget-object v3, p0, Lcom/android/mail/browse/SpamWarningView;->mSpamWarningLink:Landroid/widget/TextView;

    const/16 v4, 0x8

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1

    .line 86
    :pswitch_1
    iget-object v3, p0, Lcom/android/mail/browse/SpamWarningView;->mSpamWarningLink:Landroid/widget/TextView;

    invoke-virtual {v3, v7}, Landroid/widget/TextView;->setVisibility(I)V

    .line 87
    iget-object v3, p0, Lcom/android/mail/browse/SpamWarningView;->mSpamWarningLink:Landroid/widget/TextView;

    const v4, 0x7f0c00f3

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(I)V

    goto :goto_1

    .line 90
    :pswitch_2
    iget-object v3, p0, Lcom/android/mail/browse/SpamWarningView;->mSpamWarningLink:Landroid/widget/TextView;

    invoke-virtual {v3, v7}, Landroid/widget/TextView;->setVisibility(I)V

    .line 91
    iget-object v3, p0, Lcom/android/mail/browse/SpamWarningView;->mSpamWarningLink:Landroid/widget/TextView;

    const v4, 0x7f0c0044

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(I)V

    goto :goto_1

    .line 81
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
