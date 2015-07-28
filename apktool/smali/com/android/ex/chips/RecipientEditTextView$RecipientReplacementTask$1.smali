.class Lcom/android/ex/chips/RecipientEditTextView$RecipientReplacementTask$1;
.super Ljava/lang/Object;
.source "RecipientEditTextView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/ex/chips/RecipientEditTextView$RecipientReplacementTask;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/android/ex/chips/RecipientEditTextView$RecipientReplacementTask;

.field final synthetic val$originalRecipients:Ljava/util/ArrayList;

.field final synthetic val$replacements:Ljava/util/ArrayList;


# direct methods
.method constructor <init>(Lcom/android/ex/chips/RecipientEditTextView$RecipientReplacementTask;Ljava/util/ArrayList;Ljava/util/ArrayList;)V
    .locals 0

    .prologue
    .line 2381
    iput-object p1, p0, Lcom/android/ex/chips/RecipientEditTextView$RecipientReplacementTask$1;->this$1:Lcom/android/ex/chips/RecipientEditTextView$RecipientReplacementTask;

    iput-object p2, p0, Lcom/android/ex/chips/RecipientEditTextView$RecipientReplacementTask$1;->val$originalRecipients:Ljava/util/ArrayList;

    iput-object p3, p0, Lcom/android/ex/chips/RecipientEditTextView$RecipientReplacementTask$1;->val$replacements:Ljava/util/ArrayList;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 11

    .prologue
    .line 2384
    iget-object v8, p0, Lcom/android/ex/chips/RecipientEditTextView$RecipientReplacementTask$1;->this$1:Lcom/android/ex/chips/RecipientEditTextView$RecipientReplacementTask;

    iget-object v8, v8, Lcom/android/ex/chips/RecipientEditTextView$RecipientReplacementTask;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-virtual {v8}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v5

    .line 2386
    .local v5, "oldText":Landroid/text/Editable;
    const/4 v3, 0x0

    .line 2387
    .local v3, "i":I
    iget-object v8, p0, Lcom/android/ex/chips/RecipientEditTextView$RecipientReplacementTask$1;->val$originalRecipients:Ljava/util/ArrayList;

    invoke-virtual {v8}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/ex/chips/RecipientChip;

    .line 2389
    .local v0, "chip":Lcom/android/ex/chips/RecipientChip;
    invoke-interface {v5, v0}, Landroid/text/Editable;->getSpanStart(Ljava/lang/Object;)I

    move-result v7

    .line 2390
    .local v7, "start":I
    const/4 v8, -0x1

    if-eq v7, v8, :cond_0

    .line 2391
    invoke-interface {v5, v0}, Landroid/text/Editable;->getSpanEnd(Ljava/lang/Object;)I

    move-result v2

    .line 2392
    .local v2, "end":I
    invoke-interface {v5, v0}, Landroid/text/Editable;->removeSpan(Ljava/lang/Object;)V

    .line 2393
    iget-object v8, p0, Lcom/android/ex/chips/RecipientEditTextView$RecipientReplacementTask$1;->val$replacements:Ljava/util/ArrayList;

    invoke-virtual {v8, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/android/ex/chips/RecipientChip;

    .line 2396
    .local v6, "replacement":Lcom/android/ex/chips/RecipientChip;
    new-instance v1, Landroid/text/SpannableString;

    iget-object v8, p0, Lcom/android/ex/chips/RecipientEditTextView$RecipientReplacementTask$1;->this$1:Lcom/android/ex/chips/RecipientEditTextView$RecipientReplacementTask;

    iget-object v8, v8, Lcom/android/ex/chips/RecipientEditTextView$RecipientReplacementTask;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-virtual {v6}, Lcom/android/ex/chips/RecipientChip;->getEntry()Lcom/android/ex/chips/RecipientEntry;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/android/ex/chips/RecipientEditTextView;->createAddressText(Lcom/android/ex/chips/RecipientEntry;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v1, v8}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 2398
    .local v1, "displayText":Landroid/text/SpannableString;
    const/4 v8, 0x0

    invoke-virtual {v1}, Landroid/text/SpannableString;->length()I

    move-result v9

    const/16 v10, 0x21

    invoke-virtual {v1, v6, v8, v9, v10}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 2402
    invoke-interface {v5, v7, v2, v1}, Landroid/text/Editable;->replace(IILjava/lang/CharSequence;)Landroid/text/Editable;

    .line 2403
    invoke-virtual {v1}, Landroid/text/SpannableString;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v8}, Lcom/android/ex/chips/RecipientChip;->setOriginalText(Ljava/lang/String;)V

    .line 2405
    .end local v1    # "displayText":Landroid/text/SpannableString;
    .end local v2    # "end":I
    .end local v6    # "replacement":Lcom/android/ex/chips/RecipientChip;
    :cond_0
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 2407
    .end local v0    # "chip":Lcom/android/ex/chips/RecipientChip;
    .end local v7    # "start":I
    :cond_1
    iget-object v8, p0, Lcom/android/ex/chips/RecipientEditTextView$RecipientReplacementTask$1;->val$originalRecipients:Ljava/util/ArrayList;

    invoke-virtual {v8}, Ljava/util/ArrayList;->clear()V

    .line 2408
    return-void
.end method
