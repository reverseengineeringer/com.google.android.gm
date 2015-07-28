.class Lcom/android/ex/chips/RecipientEditTextView$RecipientTextWatcher;
.super Ljava/lang/Object;
.source "RecipientEditTextView.java"

# interfaces
.implements Landroid/text/TextWatcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/ex/chips/RecipientEditTextView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "RecipientTextWatcher"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/ex/chips/RecipientEditTextView;


# direct methods
.method private constructor <init>(Lcom/android/ex/chips/RecipientEditTextView;)V
    .locals 0

    .prologue
    .line 2113
    iput-object p1, p0, Lcom/android/ex/chips/RecipientEditTextView$RecipientTextWatcher;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/android/ex/chips/RecipientEditTextView;Lcom/android/ex/chips/RecipientEditTextView$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/android/ex/chips/RecipientEditTextView;
    .param p2, "x1"    # Lcom/android/ex/chips/RecipientEditTextView$1;

    .prologue
    .line 2113
    invoke-direct {p0, p1}, Lcom/android/ex/chips/RecipientEditTextView$RecipientTextWatcher;-><init>(Lcom/android/ex/chips/RecipientEditTextView;)V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 5

    .prologue
    const/4 v3, 0x1

    const/4 v1, 0x0

    .line 2119
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 2121
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView$RecipientTextWatcher;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-virtual {v0}, Lcom/android/ex/chips/RecipientEditTextView;->getSpannable()Landroid/text/Spannable;

    move-result-object v2

    .line 2122
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView$RecipientTextWatcher;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-virtual {v0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-interface {v0}, Landroid/text/Editable;->length()I

    move-result v0

    const-class v3, Lcom/android/ex/chips/RecipientChip;

    invoke-interface {v2, v1, v0, v3}, Landroid/text/Spannable;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/android/ex/chips/RecipientChip;

    .line 2124
    array-length v3, v0

    :goto_0
    if-ge v1, v3, :cond_0

    aget-object v4, v0, v1

    .line 2125
    invoke-interface {v2, v4}, Landroid/text/Spannable;->removeSpan(Ljava/lang/Object;)V

    .line 2124
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 2127
    :cond_0
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView$RecipientTextWatcher;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    # getter for: Lcom/android/ex/chips/RecipientEditTextView;->mMoreChip:Landroid/text/style/ImageSpan;
    invoke-static {v0}, Lcom/android/ex/chips/RecipientEditTextView;->access$1000(Lcom/android/ex/chips/RecipientEditTextView;)Landroid/text/style/ImageSpan;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 2128
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView$RecipientTextWatcher;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    # getter for: Lcom/android/ex/chips/RecipientEditTextView;->mMoreChip:Landroid/text/style/ImageSpan;
    invoke-static {v0}, Lcom/android/ex/chips/RecipientEditTextView;->access$1000(Lcom/android/ex/chips/RecipientEditTextView;)Landroid/text/style/ImageSpan;

    move-result-object v0

    invoke-interface {v2, v0}, Landroid/text/Spannable;->removeSpan(Ljava/lang/Object;)V

    .line 2173
    :cond_1
    :goto_1
    return-void

    .line 2134
    :cond_2
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView$RecipientTextWatcher;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    # invokes: Lcom/android/ex/chips/RecipientEditTextView;->chipsPending()Z
    invoke-static {v0}, Lcom/android/ex/chips/RecipientEditTextView;->access$1100(Lcom/android/ex/chips/RecipientEditTextView;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 2138
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView$RecipientTextWatcher;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    # getter for: Lcom/android/ex/chips/RecipientEditTextView;->mSelectedChip:Lcom/android/ex/chips/RecipientChip;
    invoke-static {v0}, Lcom/android/ex/chips/RecipientEditTextView;->access$400(Lcom/android/ex/chips/RecipientEditTextView;)Lcom/android/ex/chips/RecipientChip;

    move-result-object v0

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView$RecipientTextWatcher;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    iget-object v2, p0, Lcom/android/ex/chips/RecipientEditTextView$RecipientTextWatcher;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    # getter for: Lcom/android/ex/chips/RecipientEditTextView;->mSelectedChip:Lcom/android/ex/chips/RecipientChip;
    invoke-static {v2}, Lcom/android/ex/chips/RecipientEditTextView;->access$400(Lcom/android/ex/chips/RecipientEditTextView;)Lcom/android/ex/chips/RecipientChip;

    move-result-object v2

    # invokes: Lcom/android/ex/chips/RecipientEditTextView;->shouldShowEditableText(Lcom/android/ex/chips/RecipientChip;)Z
    invoke-static {v0, v2}, Lcom/android/ex/chips/RecipientEditTextView;->access$1200(Lcom/android/ex/chips/RecipientEditTextView;Lcom/android/ex/chips/RecipientChip;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 2140
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView$RecipientTextWatcher;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-virtual {v0, v3}, Lcom/android/ex/chips/RecipientEditTextView;->setCursorVisible(Z)V

    .line 2141
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView$RecipientTextWatcher;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    iget-object v2, p0, Lcom/android/ex/chips/RecipientEditTextView$RecipientTextWatcher;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-virtual {v2}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-interface {v2}, Landroid/text/Editable;->length()I

    move-result v2

    invoke-virtual {v0, v2}, Lcom/android/ex/chips/RecipientEditTextView;->setSelection(I)V

    .line 2142
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView$RecipientTextWatcher;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    # invokes: Lcom/android/ex/chips/RecipientEditTextView;->clearSelectedChip()V
    invoke-static {v0}, Lcom/android/ex/chips/RecipientEditTextView;->access$1300(Lcom/android/ex/chips/RecipientEditTextView;)V

    .line 2144
    :cond_3
    invoke-interface {p1}, Landroid/text/Editable;->length()I

    move-result v0

    .line 2147
    if-le v0, v3, :cond_1

    .line 2149
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView$RecipientTextWatcher;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-virtual {v0}, Lcom/android/ex/chips/RecipientEditTextView;->getSelectionEnd()I

    move-result v0

    if-nez v0, :cond_5

    move v0, v1

    .line 2150
    :goto_2
    iget-object v1, p0, Lcom/android/ex/chips/RecipientEditTextView$RecipientTextWatcher;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-virtual {v1}, Lcom/android/ex/chips/RecipientEditTextView;->length()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    .line 2151
    if-eq v0, v1, :cond_6

    .line 2152
    invoke-interface {p1, v0}, Landroid/text/Editable;->charAt(I)C

    move-result v0

    .line 2156
    :goto_3
    const/16 v1, 0x3b

    if-eq v0, v1, :cond_4

    const/16 v1, 0x2c

    if-ne v0, v1, :cond_7

    .line 2157
    :cond_4
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView$RecipientTextWatcher;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    # invokes: Lcom/android/ex/chips/RecipientEditTextView;->commitByCharacter()V
    invoke-static {v0}, Lcom/android/ex/chips/RecipientEditTextView;->access$1400(Lcom/android/ex/chips/RecipientEditTextView;)V

    goto :goto_1

    .line 2149
    :cond_5
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView$RecipientTextWatcher;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-virtual {v0}, Lcom/android/ex/chips/RecipientEditTextView;->getSelectionEnd()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    goto :goto_2

    .line 2154
    :cond_6
    invoke-interface {p1, v1}, Landroid/text/Editable;->charAt(I)C

    move-result v0

    goto :goto_3

    .line 2158
    :cond_7
    const/16 v1, 0x20

    if-ne v0, v1, :cond_1

    .line 2159
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView$RecipientTextWatcher;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-virtual {v0}, Lcom/android/ex/chips/RecipientEditTextView;->isPhoneQuery()Z

    move-result v0

    if-nez v0, :cond_1

    .line 2162
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView$RecipientTextWatcher;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-virtual {v0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 2163
    iget-object v1, p0, Lcom/android/ex/chips/RecipientEditTextView$RecipientTextWatcher;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    # getter for: Lcom/android/ex/chips/RecipientEditTextView;->mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;
    invoke-static {v1}, Lcom/android/ex/chips/RecipientEditTextView;->access$1500(Lcom/android/ex/chips/RecipientEditTextView;)Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

    move-result-object v1

    iget-object v2, p0, Lcom/android/ex/chips/RecipientEditTextView$RecipientTextWatcher;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-virtual {v2}, Lcom/android/ex/chips/RecipientEditTextView;->getSelectionEnd()I

    move-result v2

    invoke-interface {v1, v0, v2}, Landroid/widget/MultiAutoCompleteTextView$Tokenizer;->findTokenStart(Ljava/lang/CharSequence;I)I

    move-result v1

    .line 2164
    iget-object v2, p0, Lcom/android/ex/chips/RecipientEditTextView$RecipientTextWatcher;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    # getter for: Lcom/android/ex/chips/RecipientEditTextView;->mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;
    invoke-static {v2}, Lcom/android/ex/chips/RecipientEditTextView;->access$1500(Lcom/android/ex/chips/RecipientEditTextView;)Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

    move-result-object v2

    invoke-interface {v2, v0, v1}, Landroid/widget/MultiAutoCompleteTextView$Tokenizer;->findTokenEnd(Ljava/lang/CharSequence;I)I

    move-result v2

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 2166
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_1

    iget-object v1, p0, Lcom/android/ex/chips/RecipientEditTextView$RecipientTextWatcher;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    # getter for: Lcom/android/ex/chips/RecipientEditTextView;->mValidator:Landroid/widget/AutoCompleteTextView$Validator;
    invoke-static {v1}, Lcom/android/ex/chips/RecipientEditTextView;->access$1600(Lcom/android/ex/chips/RecipientEditTextView;)Landroid/widget/AutoCompleteTextView$Validator;

    move-result-object v1

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/android/ex/chips/RecipientEditTextView$RecipientTextWatcher;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    # getter for: Lcom/android/ex/chips/RecipientEditTextView;->mValidator:Landroid/widget/AutoCompleteTextView$Validator;
    invoke-static {v1}, Lcom/android/ex/chips/RecipientEditTextView;->access$1600(Lcom/android/ex/chips/RecipientEditTextView;)Landroid/widget/AutoCompleteTextView$Validator;

    move-result-object v1

    invoke-interface {v1, v0}, Landroid/widget/AutoCompleteTextView$Validator;->isValid(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 2168
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView$RecipientTextWatcher;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    # invokes: Lcom/android/ex/chips/RecipientEditTextView;->commitByCharacter()V
    invoke-static {v0}, Lcom/android/ex/chips/RecipientEditTextView;->access$1400(Lcom/android/ex/chips/RecipientEditTextView;)V

    goto/16 :goto_1
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "count"    # I
    .param p4, "after"    # I

    .prologue
    .line 2206
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 5

    .prologue
    .line 2179
    if-le p3, p4, :cond_2

    .line 2182
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView$RecipientTextWatcher;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-virtual {v0}, Lcom/android/ex/chips/RecipientEditTextView;->getSelectionStart()I

    move-result v1

    .line 2183
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView$RecipientTextWatcher;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-virtual {v0}, Lcom/android/ex/chips/RecipientEditTextView;->getSpannable()Landroid/text/Spannable;

    move-result-object v0

    const-class v2, Lcom/android/ex/chips/RecipientChip;

    invoke-interface {v0, v1, v1, v2}, Landroid/text/Spannable;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/android/ex/chips/RecipientChip;

    .line 2185
    array-length v2, v0

    if-lez v2, :cond_1

    .line 2187
    iget-object v2, p0, Lcom/android/ex/chips/RecipientEditTextView$RecipientTextWatcher;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-virtual {v2}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v2

    .line 2189
    iget-object v3, p0, Lcom/android/ex/chips/RecipientEditTextView$RecipientTextWatcher;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    # getter for: Lcom/android/ex/chips/RecipientEditTextView;->mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;
    invoke-static {v3}, Lcom/android/ex/chips/RecipientEditTextView;->access$1500(Lcom/android/ex/chips/RecipientEditTextView;)Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

    move-result-object v3

    invoke-interface {v3, v2, v1}, Landroid/widget/MultiAutoCompleteTextView$Tokenizer;->findTokenStart(Ljava/lang/CharSequence;I)I

    move-result v3

    .line 2190
    iget-object v1, p0, Lcom/android/ex/chips/RecipientEditTextView$RecipientTextWatcher;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    # getter for: Lcom/android/ex/chips/RecipientEditTextView;->mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;
    invoke-static {v1}, Lcom/android/ex/chips/RecipientEditTextView;->access$1500(Lcom/android/ex/chips/RecipientEditTextView;)Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

    move-result-object v1

    invoke-interface {v1, v2, v3}, Landroid/widget/MultiAutoCompleteTextView$Tokenizer;->findTokenEnd(Ljava/lang/CharSequence;I)I

    move-result v1

    .line 2191
    add-int/lit8 v1, v1, 0x1

    .line 2192
    invoke-interface {v2}, Landroid/text/Editable;->length()I

    move-result v4

    if-le v1, v4, :cond_0

    .line 2193
    invoke-interface {v2}, Landroid/text/Editable;->length()I

    move-result v1

    .line 2195
    :cond_0
    invoke-interface {v2, v3, v1}, Landroid/text/Editable;->delete(II)Landroid/text/Editable;

    .line 2196
    iget-object v1, p0, Lcom/android/ex/chips/RecipientEditTextView$RecipientTextWatcher;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-virtual {v1}, Lcom/android/ex/chips/RecipientEditTextView;->getSpannable()Landroid/text/Spannable;

    move-result-object v1

    const/4 v2, 0x0

    aget-object v0, v0, v2

    invoke-interface {v1, v0}, Landroid/text/Spannable;->removeSpan(Ljava/lang/Object;)V

    .line 2201
    :cond_1
    :goto_0
    return-void

    .line 2198
    :cond_2
    if-le p4, p3, :cond_1

    .line 2199
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView$RecipientTextWatcher;->this$0:Lcom/android/ex/chips/RecipientEditTextView;

    # invokes: Lcom/android/ex/chips/RecipientEditTextView;->scrollBottomIntoView()V
    invoke-static {v0}, Lcom/android/ex/chips/RecipientEditTextView;->access$1700(Lcom/android/ex/chips/RecipientEditTextView;)V

    goto :goto_0
.end method
