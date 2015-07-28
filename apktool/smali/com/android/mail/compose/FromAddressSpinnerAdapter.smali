.class public Lcom/android/mail/compose/FromAddressSpinnerAdapter;
.super Landroid/widget/ArrayAdapter;
.source "FromAddressSpinnerAdapter.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/ArrayAdapter",
        "<",
        "Lcom/android/mail/providers/ReplyFromAccount;",
        ">;"
    }
.end annotation


# static fields
.field public static ACCOUNT_ADDRESS:I

.field public static ACCOUNT_DISPLAY:I

.field public static REAL_ACCOUNT:I

.field private static sFormatString:Ljava/lang/String;


# instance fields
.field private mInflater:Landroid/view/LayoutInflater;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 43
    const/4 v0, 0x2

    sput v0, Lcom/android/mail/compose/FromAddressSpinnerAdapter;->REAL_ACCOUNT:I

    .line 45
    const/4 v0, 0x0

    sput v0, Lcom/android/mail/compose/FromAddressSpinnerAdapter;->ACCOUNT_DISPLAY:I

    .line 47
    const/4 v0, 0x1

    sput v0, Lcom/android/mail/compose/FromAddressSpinnerAdapter;->ACCOUNT_ADDRESS:I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 52
    const v0, 0x7f040044

    const v1, 0x7f1000b2

    invoke-direct {p0, p1, v0, v1}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;II)V

    .line 53
    invoke-virtual {p0}, Lcom/android/mail/compose/FromAddressSpinnerAdapter;->getContext()Landroid/content/Context;

    move-result-object v0

    const v1, 0x7f0c0065

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/compose/FromAddressSpinnerAdapter;->sFormatString:Ljava/lang/String;

    .line 54
    return-void
.end method

.method private static formatAddress(Ljava/lang/String;)Ljava/lang/CharSequence;
    .locals 4
    .param p0, "address"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 104
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 105
    const-string v0, ""

    .line 107
    :goto_0
    return-object v0

    :cond_0
    sget-object v0, Lcom/android/mail/compose/FromAddressSpinnerAdapter;->sFormatString:Ljava/lang/String;

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {p0}, Landroid/text/util/Rfc822Tokenizer;->tokenize(Ljava/lang/CharSequence;)[Landroid/text/util/Rfc822Token;

    move-result-object v2

    aget-object v2, v2, v3

    invoke-virtual {v2}, Landroid/text/util/Rfc822Token;->getAddress()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v3

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method


# virtual methods
.method public addAccounts(Ljava/util/List;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/android/mail/providers/ReplyFromAccount;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 112
    .local p1, "replyFromAccounts":Ljava/util/List;, "Ljava/util/List<Lcom/android/mail/providers/ReplyFromAccount;>;"
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/ReplyFromAccount;

    .line 114
    .local v0, "account":Lcom/android/mail/providers/ReplyFromAccount;
    invoke-virtual {p0, v0}, Lcom/android/mail/compose/FromAddressSpinnerAdapter;->add(Ljava/lang/Object;)V

    goto :goto_0

    .line 116
    .end local v0    # "account":Lcom/android/mail/providers/ReplyFromAccount;
    :cond_0
    return-void
.end method

.method public getDropDownView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 6
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 90
    invoke-virtual {p0, p1}, Lcom/android/mail/compose/FromAddressSpinnerAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/android/mail/providers/ReplyFromAccount;

    .line 91
    .local v2, "fromItem":Lcom/android/mail/providers/ReplyFromAccount;
    iget-boolean v4, v2, Lcom/android/mail/providers/ReplyFromAccount;->isCustomFrom:Z

    if-eqz v4, :cond_1

    const v3, 0x7f040036

    .line 93
    .local v3, "res":I
    :goto_0
    invoke-virtual {p0}, Lcom/android/mail/compose/FromAddressSpinnerAdapter;->getInflater()Landroid/view/LayoutInflater;

    move-result-object v4

    const/4 v5, 0x0

    invoke-virtual {v4, v3, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    .line 94
    .local v1, "fromEntry":Landroid/view/View;
    const v4, 0x7f1000b2

    invoke-virtual {v1, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 95
    .local v0, "acctName":Landroid/widget/TextView;
    iget-object v4, v2, Lcom/android/mail/providers/ReplyFromAccount;->name:Ljava/lang/String;

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 96
    iget-boolean v4, v2, Lcom/android/mail/providers/ReplyFromAccount;->isCustomFrom:Z

    if-eqz v4, :cond_0

    .line 97
    const v4, 0x7f1000b3

    invoke-virtual {v1, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    iget-object v5, v2, Lcom/android/mail/providers/ReplyFromAccount;->address:Ljava/lang/String;

    invoke-static {v5}, Lcom/android/mail/compose/FromAddressSpinnerAdapter;->formatAddress(Ljava/lang/String;)Ljava/lang/CharSequence;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 100
    :cond_0
    return-object v1

    .line 91
    .end local v0    # "acctName":Landroid/widget/TextView;
    .end local v1    # "fromEntry":Landroid/view/View;
    .end local v3    # "res":I
    :cond_1
    const v3, 0x7f040043

    goto :goto_0
.end method

.method protected getInflater()Landroid/view/LayoutInflater;
    .locals 2

    .prologue
    .line 57
    iget-object v0, p0, Lcom/android/mail/compose/FromAddressSpinnerAdapter;->mInflater:Landroid/view/LayoutInflater;

    if-nez v0, :cond_0

    .line 58
    invoke-virtual {p0}, Lcom/android/mail/compose/FromAddressSpinnerAdapter;->getContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "layout_inflater"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    iput-object v0, p0, Lcom/android/mail/compose/FromAddressSpinnerAdapter;->mInflater:Landroid/view/LayoutInflater;

    .line 61
    :cond_0
    iget-object v0, p0, Lcom/android/mail/compose/FromAddressSpinnerAdapter;->mInflater:Landroid/view/LayoutInflater;

    return-object v0
.end method

.method public getItemViewType(I)I
    .locals 1
    .param p1, "pos"    # I

    .prologue
    .line 72
    invoke-virtual {p0, p1}, Lcom/android/mail/compose/FromAddressSpinnerAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/ReplyFromAccount;

    iget-boolean v0, v0, Lcom/android/mail/providers/ReplyFromAccount;->isCustomFrom:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 77
    invoke-virtual {p0, p1}, Lcom/android/mail/compose/FromAddressSpinnerAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/mail/providers/ReplyFromAccount;

    .line 78
    .local v1, "fromItem":Lcom/android/mail/providers/ReplyFromAccount;
    iget-boolean v3, v1, Lcom/android/mail/providers/ReplyFromAccount;->isCustomFrom:Z

    if-eqz v3, :cond_1

    const v2, 0x7f040037

    .line 79
    .local v2, "res":I
    :goto_0
    if-nez p2, :cond_2

    invoke-virtual {p0}, Lcom/android/mail/compose/FromAddressSpinnerAdapter;->getInflater()Landroid/view/LayoutInflater;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v3, v2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 80
    .local v0, "fromEntry":Landroid/view/View;
    :goto_1
    const v3, 0x7f1000b2

    invoke-virtual {v0, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    iget-object v4, v1, Lcom/android/mail/providers/ReplyFromAccount;->name:Ljava/lang/String;

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 81
    iget-boolean v3, v1, Lcom/android/mail/providers/ReplyFromAccount;->isCustomFrom:Z

    if-eqz v3, :cond_0

    .line 82
    const v3, 0x7f1000b3

    invoke-virtual {v0, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    iget-object v4, v1, Lcom/android/mail/providers/ReplyFromAccount;->address:Ljava/lang/String;

    invoke-static {v4}, Lcom/android/mail/compose/FromAddressSpinnerAdapter;->formatAddress(Ljava/lang/String;)Ljava/lang/CharSequence;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 85
    :cond_0
    return-object v0

    .line 78
    .end local v0    # "fromEntry":Landroid/view/View;
    .end local v2    # "res":I
    :cond_1
    const v2, 0x7f040044

    goto :goto_0

    .restart local v2    # "res":I
    :cond_2
    move-object v0, p2

    .line 79
    goto :goto_1
.end method

.method public getViewTypeCount()I
    .locals 1

    .prologue
    .line 67
    const/4 v0, 0x2

    return v0
.end method
