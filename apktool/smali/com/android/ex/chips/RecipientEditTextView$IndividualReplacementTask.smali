.class Lcom/android/ex/chips/RecipientEditTextView$IndividualReplacementTask;
.super Landroid/os/AsyncTask;
.source "RecipientEditTextView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/ex/chips/RecipientEditTextView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "IndividualReplacementTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Object;",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/ex/chips/RecipientEditTextView;


# direct methods
.method private constructor <init>(Lcom/android/ex/chips/RecipientEditTextView;)V
    .locals 0

    .prologue
    .line 2415
    iput-object p1, p0, Lcom/android/ex/chips/RecipientEditTextView$IndividualReplacementTask;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/android/ex/chips/RecipientEditTextView;Lcom/android/ex/chips/RecipientEditTextView$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/android/ex/chips/RecipientEditTextView;
    .param p2, "x1"    # Lcom/android/ex/chips/RecipientEditTextView$1;

    .prologue
    .line 2415
    invoke-direct {p0, p1}, Lcom/android/ex/chips/RecipientEditTextView$IndividualReplacementTask;-><init>(Lcom/android/ex/chips/RecipientEditTextView;)V

    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # [Ljava/lang/Object;

    .prologue
    .line 2415
    invoke-virtual {p0, p1}, Lcom/android/ex/chips/RecipientEditTextView$IndividualReplacementTask;->doInBackground([Ljava/lang/Object;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Object;)Ljava/lang/Void;
    .locals 12
    .param p1, "params"    # [Ljava/lang/Object;

    .prologue
    .line 2422
    const/4 v9, 0x0

    aget-object v6, p1, v9

    check-cast v6, Ljava/util/ArrayList;

    .line 2424
    .local v6, "originalRecipients":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/android/ex/chips/RecipientChip;>;"
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 2426
    .local v0, "addresses":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_0
    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v9

    if-ge v4, v9, :cond_1

    .line 2427
    invoke-virtual {v6, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/ex/chips/RecipientChip;

    .line 2428
    .local v1, "chip":Lcom/android/ex/chips/RecipientChip;
    if-eqz v1, :cond_0

    .line 2429
    iget-object v9, p0, Lcom/android/ex/chips/RecipientEditTextView$IndividualReplacementTask;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-virtual {v1}, Lcom/android/ex/chips/RecipientChip;->getEntry()Lcom/android/ex/chips/RecipientEntry;

    move-result-object v10

    invoke-virtual {v9, v10}, Lcom/android/ex/chips/RecipientEditTextView;->createAddressText(Lcom/android/ex/chips/RecipientEntry;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v0, v9}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2426
    :cond_0
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 2432
    .end local v1    # "chip":Lcom/android/ex/chips/RecipientChip;
    :cond_1
    iget-object v9, p0, Lcom/android/ex/chips/RecipientEditTextView$IndividualReplacementTask;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-virtual {v9}, Lcom/android/ex/chips/RecipientEditTextView;->getContext()Landroid/content/Context;

    move-result-object v9

    invoke-static {v9, v0}, Lcom/android/ex/chips/RecipientAlternatesAdapter;->getMatchingRecipients(Landroid/content/Context;Ljava/util/ArrayList;)Ljava/util/HashMap;

    move-result-object v2

    .line 2434
    .local v2, "entries":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Lcom/android/ex/chips/RecipientEntry;>;"
    invoke-virtual {v6}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v5

    .local v5, "i$":Ljava/util/Iterator;
    :cond_2
    :goto_1
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_4

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/android/ex/chips/RecipientChip;

    .line 2435
    .local v7, "temp":Lcom/android/ex/chips/RecipientChip;
    invoke-virtual {v7}, Lcom/android/ex/chips/RecipientChip;->getEntry()Lcom/android/ex/chips/RecipientEntry;

    move-result-object v9

    invoke-virtual {v9}, Lcom/android/ex/chips/RecipientEntry;->getContactId()J

    move-result-wide v9

    invoke-static {v9, v10}, Lcom/android/ex/chips/RecipientEntry;->isCreatedRecipient(J)Z

    move-result v9

    if-eqz v9, :cond_2

    iget-object v9, p0, Lcom/android/ex/chips/RecipientEditTextView$IndividualReplacementTask;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-virtual {v9}, Lcom/android/ex/chips/RecipientEditTextView;->getSpannable()Landroid/text/Spannable;

    move-result-object v9

    invoke-interface {v9, v7}, Landroid/text/Spannable;->getSpanStart(Ljava/lang/Object;)I

    move-result v9

    const/4 v10, -0x1

    if-eq v9, v10, :cond_2

    .line 2438
    iget-object v10, p0, Lcom/android/ex/chips/RecipientEditTextView$IndividualReplacementTask;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    iget-object v9, p0, Lcom/android/ex/chips/RecipientEditTextView$IndividualReplacementTask;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-virtual {v7}, Lcom/android/ex/chips/RecipientChip;->getEntry()Lcom/android/ex/chips/RecipientEntry;

    move-result-object v11

    invoke-virtual {v11}, Lcom/android/ex/chips/RecipientEntry;->getDestination()Ljava/lang/String;

    move-result-object v11

    # invokes: Lcom/android/ex/chips/RecipientEditTextView;->tokenizeAddress(Ljava/lang/String;)Ljava/lang/String;
    invoke-static {v9, v11}, Lcom/android/ex/chips/RecipientEditTextView;->access$2200(Lcom/android/ex/chips/RecipientEditTextView;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v2, v9}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/android/ex/chips/RecipientEntry;

    # invokes: Lcom/android/ex/chips/RecipientEditTextView;->createValidatedEntry(Lcom/android/ex/chips/RecipientEntry;)Lcom/android/ex/chips/RecipientEntry;
    invoke-static {v10, v9}, Lcom/android/ex/chips/RecipientEditTextView;->access$2300(Lcom/android/ex/chips/RecipientEditTextView;Lcom/android/ex/chips/RecipientEntry;)Lcom/android/ex/chips/RecipientEntry;

    move-result-object v3

    .line 2442
    .local v3, "entry":Lcom/android/ex/chips/RecipientEntry;
    if-nez v3, :cond_3

    iget-object v9, p0, Lcom/android/ex/chips/RecipientEditTextView$IndividualReplacementTask;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-virtual {v9}, Lcom/android/ex/chips/RecipientEditTextView;->isPhoneQuery()Z

    move-result v9

    if-nez v9, :cond_3

    .line 2443
    invoke-virtual {v7}, Lcom/android/ex/chips/RecipientChip;->getEntry()Lcom/android/ex/chips/RecipientEntry;

    move-result-object v3

    .line 2445
    :cond_3
    move-object v8, v3

    .line 2446
    .local v8, "tempEntry":Lcom/android/ex/chips/RecipientEntry;
    if-eqz v8, :cond_2

    .line 2447
    iget-object v9, p0, Lcom/android/ex/chips/RecipientEditTextView$IndividualReplacementTask;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    # getter for: Lcom/android/ex/chips/RecipientEditTextView;->mHandler:Landroid/os/Handler;
    invoke-static {v9}, Lcom/android/ex/chips/RecipientEditTextView;->access$500(Lcom/android/ex/chips/RecipientEditTextView;)Landroid/os/Handler;

    move-result-object v9

    new-instance v10, Lcom/android/ex/chips/RecipientEditTextView$IndividualReplacementTask$1;

    invoke-direct {v10, p0, v7, v8}, Lcom/android/ex/chips/RecipientEditTextView$IndividualReplacementTask$1;-><init>(Lcom/android/ex/chips/RecipientEditTextView$IndividualReplacementTask;Lcom/android/ex/chips/RecipientChip;Lcom/android/ex/chips/RecipientEntry;)V

    invoke-virtual {v9, v10}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_1

    .line 2456
    .end local v3    # "entry":Lcom/android/ex/chips/RecipientEntry;
    .end local v7    # "temp":Lcom/android/ex/chips/RecipientChip;
    .end local v8    # "tempEntry":Lcom/android/ex/chips/RecipientEntry;
    :cond_4
    const/4 v9, 0x0

    return-object v9
.end method
