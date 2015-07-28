.class Lcom/android/mail/browse/MessageHeaderView$RecipientListsBuilder;
.super Ljava/lang/Object;
.source "MessageHeaderView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/browse/MessageHeaderView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "RecipientListsBuilder"
.end annotation


# instance fields
.field private final mAddressCache:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/android/mail/providers/Address;",
            ">;"
        }
    .end annotation
.end field

.field private final mBuilder:Landroid/text/SpannableStringBuilder;

.field private final mComma:Ljava/lang/CharSequence;

.field private final mContext:Landroid/content/Context;

.field mFirst:Z

.field private final mMe:Ljava/lang/String;

.field mRecipientCount:I


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/util/Map;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "me"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/android/mail/providers/Address;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 677
    .local p3, "addressCache":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/android/mail/providers/Address;>;"
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 669
    new-instance v0, Landroid/text/SpannableStringBuilder;

    invoke-direct {v0}, Landroid/text/SpannableStringBuilder;-><init>()V

    iput-object v0, p0, Lcom/android/mail/browse/MessageHeaderView$RecipientListsBuilder;->mBuilder:Landroid/text/SpannableStringBuilder;

    .line 673
    const/4 v0, 0x0

    iput v0, p0, Lcom/android/mail/browse/MessageHeaderView$RecipientListsBuilder;->mRecipientCount:I

    .line 674
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/mail/browse/MessageHeaderView$RecipientListsBuilder;->mFirst:Z

    .line 678
    iput-object p1, p0, Lcom/android/mail/browse/MessageHeaderView$RecipientListsBuilder;->mContext:Landroid/content/Context;

    .line 679
    iput-object p2, p0, Lcom/android/mail/browse/MessageHeaderView$RecipientListsBuilder;->mMe:Ljava/lang/String;

    .line 680
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView$RecipientListsBuilder;->mContext:Landroid/content/Context;

    const v1, 0x7f0c00d1

    invoke-virtual {v0, v1}, Landroid/content/Context;->getText(I)Ljava/lang/CharSequence;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/MessageHeaderView$RecipientListsBuilder;->mComma:Ljava/lang/CharSequence;

    .line 681
    iput-object p3, p0, Lcom/android/mail/browse/MessageHeaderView$RecipientListsBuilder;->mAddressCache:Ljava/util/Map;

    .line 682
    return-void
.end method

.method private getSummaryTextForHeading(I[Ljava/lang/String;I)Ljava/lang/CharSequence;
    .locals 10
    .param p1, "headingStrRes"    # I
    .param p2, "rawAddrs"    # [Ljava/lang/String;
    .param p3, "maxToCopy"    # I

    .prologue
    .line 702
    if-eqz p2, :cond_0

    array-length v6, p2

    if-eqz v6, :cond_0

    if-nez p3, :cond_2

    .line 703
    :cond_0
    const/4 v5, 0x0

    .line 729
    :cond_1
    return-object v5

    .line 706
    :cond_2
    new-instance v5, Landroid/text/SpannableStringBuilder;

    iget-object v6, p0, Lcom/android/mail/browse/MessageHeaderView$RecipientListsBuilder;->mContext:Landroid/content/Context;

    invoke-virtual {v6, p1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 708
    .local v5, "ssb":Landroid/text/SpannableStringBuilder;
    new-instance v6, Landroid/text/style/StyleSpan;

    const/4 v7, 0x1

    invoke-direct {v6, v7}, Landroid/text/style/StyleSpan;-><init>(I)V

    const/4 v7, 0x0

    invoke-virtual {v5}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v8

    const/16 v9, 0x21

    invoke-virtual {v5, v6, v7, v8, v9}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 710
    const/16 v6, 0x20

    invoke-virtual {v5, v6}, Landroid/text/SpannableStringBuilder;->append(C)Landroid/text/SpannableStringBuilder;

    .line 712
    array-length v6, p2

    invoke-static {p3, v6}, Ljava/lang/Math;->min(II)I

    move-result v3

    .line 713
    .local v3, "len":I
    const/4 v1, 0x1

    .line 714
    .local v1, "first":Z
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v3, :cond_1

    .line 715
    iget-object v6, p0, Lcom/android/mail/browse/MessageHeaderView$RecipientListsBuilder;->mAddressCache:Ljava/util/Map;

    aget-object v7, p2, v2

    # invokes: Lcom/android/mail/browse/MessageHeaderView;->getAddress(Ljava/util/Map;Ljava/lang/String;)Lcom/android/mail/providers/Address;
    invoke-static {v6, v7}, Lcom/android/mail/browse/MessageHeaderView;->access$100(Ljava/util/Map;Ljava/lang/String;)Lcom/android/mail/providers/Address;

    move-result-object v0

    .line 716
    .local v0, "email":Lcom/android/mail/providers/Address;
    iget-object v6, p0, Lcom/android/mail/browse/MessageHeaderView$RecipientListsBuilder;->mMe:Ljava/lang/String;

    invoke-virtual {v0}, Lcom/android/mail/providers/Address;->getAddress()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_3

    iget-object v6, p0, Lcom/android/mail/browse/MessageHeaderView$RecipientListsBuilder;->mContext:Landroid/content/Context;

    const v7, 0x7f0c009b

    invoke-virtual {v6, v7}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 721
    .local v4, "name":Ljava/lang/String;
    :goto_1
    if-eqz v1, :cond_4

    .line 722
    const/4 v1, 0x0

    .line 726
    :goto_2
    invoke-virtual {v5, v4}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 714
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 716
    .end local v4    # "name":Ljava/lang/String;
    :cond_3
    invoke-virtual {v0}, Lcom/android/mail/providers/Address;->getSimplifiedName()Ljava/lang/String;

    move-result-object v4

    goto :goto_1

    .line 724
    .restart local v4    # "name":Ljava/lang/String;
    :cond_4
    iget-object v6, p0, Lcom/android/mail/browse/MessageHeaderView$RecipientListsBuilder;->mComma:Ljava/lang/CharSequence;

    invoke-virtual {v5, v6}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    goto :goto_2
.end method


# virtual methods
.method public append([Ljava/lang/String;I)V
    .locals 4
    .param p1, "recipients"    # [Ljava/lang/String;
    .param p2, "headingRes"    # I

    .prologue
    .line 685
    iget v2, p0, Lcom/android/mail/browse/MessageHeaderView$RecipientListsBuilder;->mRecipientCount:I

    rsub-int/lit8 v0, v2, 0x32

    .line 686
    .local v0, "addLimit":I
    invoke-direct {p0, p2, p1, v0}, Lcom/android/mail/browse/MessageHeaderView$RecipientListsBuilder;->getSummaryTextForHeading(I[Ljava/lang/String;I)Ljava/lang/CharSequence;

    move-result-object v1

    .line 687
    .local v1, "recipientList":Ljava/lang/CharSequence;
    if-eqz v1, :cond_0

    .line 690
    iget-boolean v2, p0, Lcom/android/mail/browse/MessageHeaderView$RecipientListsBuilder;->mFirst:Z

    if-eqz v2, :cond_1

    .line 691
    const/4 v2, 0x0

    iput-boolean v2, p0, Lcom/android/mail/browse/MessageHeaderView$RecipientListsBuilder;->mFirst:Z

    .line 695
    :goto_0
    iget-object v2, p0, Lcom/android/mail/browse/MessageHeaderView$RecipientListsBuilder;->mBuilder:Landroid/text/SpannableStringBuilder;

    invoke-virtual {v2, v1}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 696
    iget v2, p0, Lcom/android/mail/browse/MessageHeaderView$RecipientListsBuilder;->mRecipientCount:I

    array-length v3, p1

    invoke-static {v0, v3}, Ljava/lang/Math;->min(II)I

    move-result v3

    add-int/2addr v2, v3

    iput v2, p0, Lcom/android/mail/browse/MessageHeaderView$RecipientListsBuilder;->mRecipientCount:I

    .line 698
    :cond_0
    return-void

    .line 693
    :cond_1
    iget-object v2, p0, Lcom/android/mail/browse/MessageHeaderView$RecipientListsBuilder;->mBuilder:Landroid/text/SpannableStringBuilder;

    const-string v3, "   "

    invoke-virtual {v2, v3}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    goto :goto_0
.end method

.method public build()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 733
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView$RecipientListsBuilder;->mBuilder:Landroid/text/SpannableStringBuilder;

    return-object v0
.end method
