.class public Lcom/android/ex/chips/RecipientEditTextView;
.super Landroid/widget/MultiAutoCompleteTextView;
.source "RecipientEditTextView.java"

# interfaces
.implements Landroid/content/DialogInterface$OnDismissListener;
.implements Landroid/view/ActionMode$Callback;
.implements Landroid/view/GestureDetector$OnGestureListener;
.implements Landroid/view/View$OnClickListener;
.implements Landroid/widget/AdapterView$OnItemClickListener;
.implements Landroid/widget/TextView$OnEditorActionListener;
.implements Lcom/android/ex/chips/RecipientAlternatesAdapter$OnCheckedItemChangedListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/ex/chips/RecipientEditTextView$RecipientChipShadow;,
        Lcom/android/ex/chips/RecipientEditTextView$MoreImageSpan;,
        Lcom/android/ex/chips/RecipientEditTextView$IndividualReplacementTask;,
        Lcom/android/ex/chips/RecipientEditTextView$RecipientReplacementTask;,
        Lcom/android/ex/chips/RecipientEditTextView$RecipientTextWatcher;
    }
.end annotation


# static fields
.field private static DISMISS:I

.field private static sSelectedTextColor:I


# instance fields
.field private final mAddTextWatcher:Ljava/lang/Runnable;

.field private mAddressPopup:Landroid/widget/ListPopupWindow;

.field private mAlternatesLayout:I

.field private mAlternatesListener:Landroid/widget/AdapterView$OnItemClickListener;

.field private mAlternatesPopup:Landroid/widget/ListPopupWindow;

.field private mCheckedItem:I

.field private mChipBackground:Landroid/graphics/drawable/Drawable;

.field private mChipBackgroundPressed:Landroid/graphics/drawable/Drawable;

.field private mChipDelete:Landroid/graphics/drawable/Drawable;

.field private mChipFontSize:F

.field private mChipHeight:F

.field private mChipPadding:I

.field private mCopyAddress:Ljava/lang/String;

.field private mCopyDialog:Landroid/app/Dialog;

.field private mDefaultContactPhoto:Landroid/graphics/Bitmap;

.field private mDelayedShrink:Ljava/lang/Runnable;

.field private mDragEnabled:Z

.field private mGestureDetector:Landroid/view/GestureDetector;

.field private mHandlePendingChips:Ljava/lang/Runnable;

.field private mHandler:Landroid/os/Handler;

.field private mIndividualReplacements:Lcom/android/ex/chips/RecipientEditTextView$IndividualReplacementTask;

.field private mInvalidChipBackground:Landroid/graphics/drawable/Drawable;

.field private mLineSpacingExtra:F

.field private mMaxLines:I

.field private mMoreChip:Landroid/text/style/ImageSpan;

.field private mMoreItem:Landroid/widget/TextView;

.field private mNoChips:Z

.field private final mPendingChips:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mPendingChipsCount:I

.field private mRemovedSpans:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/android/ex/chips/RecipientChip;",
            ">;"
        }
    .end annotation
.end field

.field private mScrollView:Landroid/widget/ScrollView;

.field private mSelectedChip:Lcom/android/ex/chips/RecipientChip;

.field private mShouldShrink:Z

.field private mTemporaryRecipients:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/android/ex/chips/RecipientChip;",
            ">;"
        }
    .end annotation
.end field

.field private mTextWatcher:Landroid/text/TextWatcher;

.field private mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

.field private mTriedGettingScrollView:Z

.field private mValidator:Landroid/widget/AutoCompleteTextView$Validator;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 111
    const-string v0, "dismiss"

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    sput v0, Lcom/android/ex/chips/RecipientEditTextView;->DISMISS:I

    .line 121
    const/4 v0, -0x1

    sput v0, Lcom/android/ex/chips/RecipientEditTextView;->sSelectedTextColor:I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 230
    invoke-direct {p0, p1, p2}, Landroid/widget/MultiAutoCompleteTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 124
    iput-object v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mChipBackground:Landroid/graphics/drawable/Drawable;

    .line 126
    iput-object v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mChipDelete:Landroid/graphics/drawable/Drawable;

    .line 154
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mPendingChips:Ljava/util/ArrayList;

    .line 158
    iput v1, p0, Lcom/android/ex/chips/RecipientEditTextView;->mPendingChipsCount:I

    .line 160
    iput-boolean v1, p0, Lcom/android/ex/chips/RecipientEditTextView;->mNoChips:Z

    .line 170
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mShouldShrink:Z

    .line 195
    iput-boolean v1, p0, Lcom/android/ex/chips/RecipientEditTextView;->mDragEnabled:Z

    .line 197
    new-instance v0, Lcom/android/ex/chips/RecipientEditTextView$1;

    invoke-direct {v0, p0}, Lcom/android/ex/chips/RecipientEditTextView$1;-><init>(Lcom/android/ex/chips/RecipientEditTextView;)V

    iput-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mAddTextWatcher:Ljava/lang/Runnable;

    .line 209
    new-instance v0, Lcom/android/ex/chips/RecipientEditTextView$2;

    invoke-direct {v0, p0}, Lcom/android/ex/chips/RecipientEditTextView$2;-><init>(Lcom/android/ex/chips/RecipientEditTextView;)V

    iput-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mHandlePendingChips:Ljava/lang/Runnable;

    .line 218
    new-instance v0, Lcom/android/ex/chips/RecipientEditTextView$3;

    invoke-direct {v0, p0}, Lcom/android/ex/chips/RecipientEditTextView$3;-><init>(Lcom/android/ex/chips/RecipientEditTextView;)V

    iput-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mDelayedShrink:Ljava/lang/Runnable;

    .line 231
    invoke-direct {p0, p1, p2}, Lcom/android/ex/chips/RecipientEditTextView;->setChipDimensions(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 232
    sget v0, Lcom/android/ex/chips/RecipientEditTextView;->sSelectedTextColor:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 233
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x106000b

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    sput v0, Lcom/android/ex/chips/RecipientEditTextView;->sSelectedTextColor:I

    .line 235
    :cond_0
    new-instance v0, Landroid/widget/ListPopupWindow;

    invoke-direct {v0, p1}, Landroid/widget/ListPopupWindow;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mAlternatesPopup:Landroid/widget/ListPopupWindow;

    .line 236
    new-instance v0, Landroid/widget/ListPopupWindow;

    invoke-direct {v0, p1}, Landroid/widget/ListPopupWindow;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mAddressPopup:Landroid/widget/ListPopupWindow;

    .line 237
    new-instance v0, Landroid/app/Dialog;

    invoke-direct {v0, p1}, Landroid/app/Dialog;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mCopyDialog:Landroid/app/Dialog;

    .line 238
    new-instance v0, Lcom/android/ex/chips/RecipientEditTextView$4;

    invoke-direct {v0, p0}, Lcom/android/ex/chips/RecipientEditTextView$4;-><init>(Lcom/android/ex/chips/RecipientEditTextView;)V

    iput-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mAlternatesListener:Landroid/widget/AdapterView$OnItemClickListener;

    .line 251
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getInputType()I

    move-result v0

    const/high16 v1, 0x80000

    or-int/2addr v0, v1

    invoke-virtual {p0, v0}, Lcom/android/ex/chips/RecipientEditTextView;->setInputType(I)V

    .line 252
    invoke-virtual {p0, p0}, Lcom/android/ex/chips/RecipientEditTextView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 253
    invoke-virtual {p0, p0}, Lcom/android/ex/chips/RecipientEditTextView;->setCustomSelectionActionModeCallback(Landroid/view/ActionMode$Callback;)V

    .line 254
    new-instance v0, Lcom/android/ex/chips/RecipientEditTextView$5;

    invoke-direct {v0, p0}, Lcom/android/ex/chips/RecipientEditTextView$5;-><init>(Lcom/android/ex/chips/RecipientEditTextView;)V

    iput-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mHandler:Landroid/os/Handler;

    .line 264
    new-instance v0, Lcom/android/ex/chips/RecipientEditTextView$RecipientTextWatcher;

    invoke-direct {v0, p0, v2}, Lcom/android/ex/chips/RecipientEditTextView$RecipientTextWatcher;-><init>(Lcom/android/ex/chips/RecipientEditTextView;Lcom/android/ex/chips/RecipientEditTextView$1;)V

    iput-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTextWatcher:Landroid/text/TextWatcher;

    .line 265
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTextWatcher:Landroid/text/TextWatcher;

    invoke-virtual {p0, v0}, Lcom/android/ex/chips/RecipientEditTextView;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 266
    new-instance v0, Landroid/view/GestureDetector;

    invoke-direct {v0, p1, p0}, Landroid/view/GestureDetector;-><init>(Landroid/content/Context;Landroid/view/GestureDetector$OnGestureListener;)V

    iput-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mGestureDetector:Landroid/view/GestureDetector;

    .line 267
    invoke-virtual {p0, p0}, Lcom/android/ex/chips/RecipientEditTextView;->setOnEditorActionListener(Landroid/widget/TextView$OnEditorActionListener;)V

    .line 268
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getLineCount()I

    move-result v0

    iput v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mMaxLines:I

    .line 269
    return-void
.end method

.method static synthetic access$000(Lcom/android/ex/chips/RecipientEditTextView;)Landroid/text/TextWatcher;
    .locals 1
    .param p0, "x0"    # Lcom/android/ex/chips/RecipientEditTextView;

    .prologue
    .line 96
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTextWatcher:Landroid/text/TextWatcher;

    return-object v0
.end method

.method static synthetic access$002(Lcom/android/ex/chips/RecipientEditTextView;Landroid/text/TextWatcher;)Landroid/text/TextWatcher;
    .locals 0
    .param p0, "x0"    # Lcom/android/ex/chips/RecipientEditTextView;
    .param p1, "x1"    # Landroid/text/TextWatcher;

    .prologue
    .line 96
    iput-object p1, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTextWatcher:Landroid/text/TextWatcher;

    return-object p1
.end method

.method static synthetic access$1000(Lcom/android/ex/chips/RecipientEditTextView;)Landroid/text/style/ImageSpan;
    .locals 1
    .param p0, "x0"    # Lcom/android/ex/chips/RecipientEditTextView;

    .prologue
    .line 96
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mMoreChip:Landroid/text/style/ImageSpan;

    return-object v0
.end method

.method static synthetic access$1100(Lcom/android/ex/chips/RecipientEditTextView;)Z
    .locals 1
    .param p0, "x0"    # Lcom/android/ex/chips/RecipientEditTextView;

    .prologue
    .line 96
    invoke-direct {p0}, Lcom/android/ex/chips/RecipientEditTextView;->chipsPending()Z

    move-result v0

    return v0
.end method

.method static synthetic access$1200(Lcom/android/ex/chips/RecipientEditTextView;Lcom/android/ex/chips/RecipientChip;)Z
    .locals 1
    .param p0, "x0"    # Lcom/android/ex/chips/RecipientEditTextView;
    .param p1, "x1"    # Lcom/android/ex/chips/RecipientChip;

    .prologue
    .line 96
    invoke-direct {p0, p1}, Lcom/android/ex/chips/RecipientEditTextView;->shouldShowEditableText(Lcom/android/ex/chips/RecipientChip;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$1300(Lcom/android/ex/chips/RecipientEditTextView;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/ex/chips/RecipientEditTextView;

    .prologue
    .line 96
    invoke-direct {p0}, Lcom/android/ex/chips/RecipientEditTextView;->clearSelectedChip()V

    return-void
.end method

.method static synthetic access$1400(Lcom/android/ex/chips/RecipientEditTextView;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/ex/chips/RecipientEditTextView;

    .prologue
    .line 96
    invoke-direct {p0}, Lcom/android/ex/chips/RecipientEditTextView;->commitByCharacter()V

    return-void
.end method

.method static synthetic access$1500(Lcom/android/ex/chips/RecipientEditTextView;)Landroid/widget/MultiAutoCompleteTextView$Tokenizer;
    .locals 1
    .param p0, "x0"    # Lcom/android/ex/chips/RecipientEditTextView;

    .prologue
    .line 96
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

    return-object v0
.end method

.method static synthetic access$1600(Lcom/android/ex/chips/RecipientEditTextView;)Landroid/widget/AutoCompleteTextView$Validator;
    .locals 1
    .param p0, "x0"    # Lcom/android/ex/chips/RecipientEditTextView;

    .prologue
    .line 96
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mValidator:Landroid/widget/AutoCompleteTextView$Validator;

    return-object v0
.end method

.method static synthetic access$1700(Lcom/android/ex/chips/RecipientEditTextView;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/ex/chips/RecipientEditTextView;

    .prologue
    .line 96
    invoke-direct {p0}, Lcom/android/ex/chips/RecipientEditTextView;->scrollBottomIntoView()V

    return-void
.end method

.method static synthetic access$1800(Lcom/android/ex/chips/RecipientEditTextView;)Z
    .locals 1
    .param p0, "x0"    # Lcom/android/ex/chips/RecipientEditTextView;

    .prologue
    .line 96
    iget-boolean v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mNoChips:Z

    return v0
.end method

.method static synthetic access$1900(Lcom/android/ex/chips/RecipientEditTextView;Lcom/android/ex/chips/RecipientEntry;IZZ)Lcom/android/ex/chips/RecipientChip;
    .locals 1
    .param p0, "x0"    # Lcom/android/ex/chips/RecipientEditTextView;
    .param p1, "x1"    # Lcom/android/ex/chips/RecipientEntry;
    .param p2, "x2"    # I
    .param p3, "x3"    # Z
    .param p4, "x4"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/NullPointerException;
        }
    .end annotation

    .prologue
    .line 96
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/android/ex/chips/RecipientEditTextView;->constructChipSpan(Lcom/android/ex/chips/RecipientEntry;IZZ)Lcom/android/ex/chips/RecipientChip;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$200(Lcom/android/ex/chips/RecipientEditTextView;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/ex/chips/RecipientEditTextView;

    .prologue
    .line 96
    invoke-direct {p0}, Lcom/android/ex/chips/RecipientEditTextView;->shrink()V

    return-void
.end method

.method static synthetic access$2000(Lcom/android/ex/chips/RecipientEditTextView;)Lcom/android/ex/chips/RecipientEditTextView$IndividualReplacementTask;
    .locals 1
    .param p0, "x0"    # Lcom/android/ex/chips/RecipientEditTextView;

    .prologue
    .line 96
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mIndividualReplacements:Lcom/android/ex/chips/RecipientEditTextView$IndividualReplacementTask;

    return-object v0
.end method

.method static synthetic access$2100(Lcom/android/ex/chips/RecipientEditTextView;)Ljava/util/ArrayList;
    .locals 1
    .param p0, "x0"    # Lcom/android/ex/chips/RecipientEditTextView;

    .prologue
    .line 96
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mRemovedSpans:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic access$2200(Lcom/android/ex/chips/RecipientEditTextView;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/android/ex/chips/RecipientEditTextView;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 96
    invoke-direct {p0, p1}, Lcom/android/ex/chips/RecipientEditTextView;->tokenizeAddress(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$2300(Lcom/android/ex/chips/RecipientEditTextView;Lcom/android/ex/chips/RecipientEntry;)Lcom/android/ex/chips/RecipientEntry;
    .locals 1
    .param p0, "x0"    # Lcom/android/ex/chips/RecipientEditTextView;
    .param p1, "x1"    # Lcom/android/ex/chips/RecipientEntry;

    .prologue
    .line 96
    invoke-direct {p0, p1}, Lcom/android/ex/chips/RecipientEditTextView;->createValidatedEntry(Lcom/android/ex/chips/RecipientEntry;)Lcom/android/ex/chips/RecipientEntry;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$300(Lcom/android/ex/chips/RecipientEditTextView;)Landroid/widget/ListPopupWindow;
    .locals 1
    .param p0, "x0"    # Lcom/android/ex/chips/RecipientEditTextView;

    .prologue
    .line 96
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mAlternatesPopup:Landroid/widget/ListPopupWindow;

    return-object v0
.end method

.method static synthetic access$400(Lcom/android/ex/chips/RecipientEditTextView;)Lcom/android/ex/chips/RecipientChip;
    .locals 1
    .param p0, "x0"    # Lcom/android/ex/chips/RecipientEditTextView;

    .prologue
    .line 96
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mSelectedChip:Lcom/android/ex/chips/RecipientChip;

    return-object v0
.end method

.method static synthetic access$500(Lcom/android/ex/chips/RecipientEditTextView;)Landroid/os/Handler;
    .locals 1
    .param p0, "x0"    # Lcom/android/ex/chips/RecipientEditTextView;

    .prologue
    .line 96
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mHandler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$600()I
    .locals 1

    .prologue
    .line 96
    sget v0, Lcom/android/ex/chips/RecipientEditTextView;->DISMISS:I

    return v0
.end method

.method static synthetic access$900(Lcom/android/ex/chips/RecipientEditTextView;Lcom/android/ex/chips/RecipientChip;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/ex/chips/RecipientEditTextView;
    .param p1, "x1"    # Lcom/android/ex/chips/RecipientChip;

    .prologue
    .line 96
    invoke-direct {p0, p1}, Lcom/android/ex/chips/RecipientEditTextView;->unselectChip(Lcom/android/ex/chips/RecipientChip;)V

    return-void
.end method

.method private alreadyHasChip(II)Z
    .locals 3

    .prologue
    const/4 v1, 0x1

    .line 1222
    iget-boolean v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mNoChips:Z

    if-eqz v0, :cond_0

    move v0, v1

    .line 1229
    :goto_0
    return v0

    .line 1225
    :cond_0
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSpannable()Landroid/text/Spannable;

    move-result-object v0

    const-class v2, Lcom/android/ex/chips/RecipientChip;

    invoke-interface {v0, p1, p2, v2}, Landroid/text/Spannable;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/android/ex/chips/RecipientChip;

    .line 1226
    if-eqz v0, :cond_1

    array-length v0, v0

    if-nez v0, :cond_2

    .line 1227
    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    :cond_2
    move v0, v1

    .line 1229
    goto :goto_0
.end method

.method private calculateAvailableWidth(Z)F
    .locals 2
    .param p1, "pressed"    # Z

    .prologue
    .line 655
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getWidth()I

    move-result v0

    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getPaddingLeft()I

    move-result v1

    sub-int/2addr v0, v1

    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getPaddingRight()I

    move-result v1

    sub-int/2addr v0, v1

    iget v1, p0, Lcom/android/ex/chips/RecipientEditTextView;->mChipPadding:I

    mul-int/lit8 v1, v1, 0x2

    sub-int/2addr v0, v1

    int-to-float v0, v0

    return v0
.end method

.method private calculateOffsetFromBottom(I)I
    .locals 3
    .param p1, "line"    # I

    .prologue
    .line 644
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getLineCount()I

    move-result v1

    add-int/lit8 v2, p1, 0x1

    sub-int v0, v1, v2

    .line 645
    .local v0, "actualLine":I
    iget v1, p0, Lcom/android/ex/chips/RecipientEditTextView;->mChipHeight:F

    float-to-int v1, v1

    mul-int/2addr v1, v0

    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getPaddingBottom()I

    move-result v2

    add-int/2addr v1, v2

    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getPaddingTop()I

    move-result v2

    add-int/2addr v1, v2

    neg-int v1, v1

    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getDropDownVerticalOffset()I

    move-result v2

    add-int/2addr v1, v2

    return v1
.end method

.method private checkChipWidths()V
    .locals 8

    .prologue
    .line 764
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSortedRecipients()[Lcom/android/ex/chips/RecipientChip;

    move-result-object v3

    .line 765
    .local v3, "chips":[Lcom/android/ex/chips/RecipientChip;
    if-eqz v3, :cond_1

    .line 767
    move-object v0, v3

    .local v0, "arr$":[Lcom/android/ex/chips/RecipientChip;
    array-length v5, v0

    .local v5, "len$":I
    const/4 v4, 0x0

    .local v4, "i$":I
    :goto_0
    if-ge v4, v5, :cond_1

    aget-object v2, v0, v4

    .line 768
    .local v2, "chip":Lcom/android/ex/chips/RecipientChip;
    invoke-virtual {v2}, Lcom/android/ex/chips/RecipientChip;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v6

    invoke-virtual {v6}, Landroid/graphics/drawable/Drawable;->getBounds()Landroid/graphics/Rect;

    move-result-object v1

    .line 769
    .local v1, "bounds":Landroid/graphics/Rect;
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getWidth()I

    move-result v6

    if-lez v6, :cond_0

    iget v6, v1, Landroid/graphics/Rect;->right:I

    iget v7, v1, Landroid/graphics/Rect;->left:I

    sub-int/2addr v6, v7

    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getWidth()I

    move-result v7

    if-le v6, v7, :cond_0

    .line 771
    invoke-virtual {v2}, Lcom/android/ex/chips/RecipientChip;->getEntry()Lcom/android/ex/chips/RecipientEntry;

    move-result-object v6

    invoke-virtual {p0, v2, v6}, Lcom/android/ex/chips/RecipientEditTextView;->replaceChip(Lcom/android/ex/chips/RecipientChip;Lcom/android/ex/chips/RecipientEntry;)V

    .line 767
    :cond_0
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 775
    .end local v0    # "arr$":[Lcom/android/ex/chips/RecipientChip;
    .end local v1    # "bounds":Landroid/graphics/Rect;
    .end local v2    # "chip":Lcom/android/ex/chips/RecipientChip;
    .end local v4    # "i$":I
    .end local v5    # "len$":I
    :cond_1
    return-void
.end method

.method private chipsPending()Z
    .locals 1

    .prologue
    .line 2104
    iget v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mPendingChipsCount:I

    if-gtz v0, :cond_0

    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mRemovedSpans:Ljava/util/ArrayList;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mRemovedSpans:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private clearSelectedChip()V
    .locals 1

    .prologue
    .line 1328
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mSelectedChip:Lcom/android/ex/chips/RecipientChip;

    if-eqz v0, :cond_0

    .line 1329
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mSelectedChip:Lcom/android/ex/chips/RecipientChip;

    invoke-direct {p0, v0}, Lcom/android/ex/chips/RecipientEditTextView;->unselectChip(Lcom/android/ex/chips/RecipientChip;)V

    .line 1330
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mSelectedChip:Lcom/android/ex/chips/RecipientChip;

    .line 1332
    :cond_0
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/android/ex/chips/RecipientEditTextView;->setCursorVisible(Z)V

    .line 1333
    return-void
.end method

.method private commitByCharacter()V
    .locals 4

    .prologue
    .line 1131
    iget-object v3, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

    if-nez v3, :cond_0

    .line 1141
    :goto_0
    return-void

    .line 1134
    :cond_0
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v0

    .line 1135
    .local v0, "editable":Landroid/text/Editable;
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSelectionEnd()I

    move-result v1

    .line 1136
    .local v1, "end":I
    iget-object v3, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

    invoke-interface {v3, v0, v1}, Landroid/widget/MultiAutoCompleteTextView$Tokenizer;->findTokenStart(Ljava/lang/CharSequence;I)I

    move-result v2

    .line 1137
    .local v2, "start":I
    invoke-direct {p0, v2, v1}, Lcom/android/ex/chips/RecipientEditTextView;->shouldCreateChip(II)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 1138
    invoke-direct {p0, v2, v1, v0}, Lcom/android/ex/chips/RecipientEditTextView;->commitChip(IILandroid/text/Editable;)Z

    .line 1140
    :cond_1
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-interface {v3}, Landroid/text/Editable;->length()I

    move-result v3

    invoke-virtual {p0, v3}, Lcom/android/ex/chips/RecipientEditTextView;->setSelection(I)V

    goto :goto_0
.end method

.method private commitChip(IILandroid/text/Editable;)Z
    .locals 6

    .prologue
    const/4 v1, 0x1

    const/4 v5, -0x1

    const/4 v2, 0x0

    .line 1144
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    .line 1145
    if-eqz v0, :cond_0

    invoke-interface {v0}, Landroid/widget/ListAdapter;->getCount()I

    move-result v0

    if-lez v0, :cond_0

    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->enoughToFilter()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSelectionEnd()I

    move-result v0

    if-ne p2, v0, :cond_0

    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->isPhoneQuery()Z

    move-result v0

    if-nez v0, :cond_0

    .line 1148
    invoke-direct {p0, v2}, Lcom/android/ex/chips/RecipientEditTextView;->submitItemAtPosition(I)V

    .line 1149
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->dismissDropDown()V

    move v0, v1

    .line 1181
    :goto_0
    return v0

    .line 1152
    :cond_0
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

    invoke-interface {v0, p3, p1}, Landroid/widget/MultiAutoCompleteTextView$Tokenizer;->findTokenEnd(Ljava/lang/CharSequence;I)I

    move-result v0

    .line 1153
    invoke-interface {p3}, Landroid/text/Editable;->length()I

    move-result v3

    add-int/lit8 v4, v0, 0x1

    if-le v3, v4, :cond_2

    .line 1154
    add-int/lit8 v3, v0, 0x1

    invoke-interface {p3, v3}, Landroid/text/Editable;->charAt(I)C

    move-result v3

    .line 1155
    const/16 v4, 0x2c

    if-eq v3, v4, :cond_1

    const/16 v4, 0x3b

    if-ne v3, v4, :cond_2

    .line 1156
    :cond_1
    add-int/lit8 v0, v0, 0x1

    .line 1159
    :cond_2
    invoke-virtual {p3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3, p1, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    .line 1160
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->clearComposingText()V

    .line 1161
    if-eqz v0, :cond_5

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v3

    if-lez v3, :cond_5

    const-string v3, " "

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_5

    .line 1162
    invoke-direct {p0, v0}, Lcom/android/ex/chips/RecipientEditTextView;->createTokenizedEntry(Ljava/lang/String;)Lcom/android/ex/chips/RecipientEntry;

    move-result-object v0

    .line 1163
    if-eqz v0, :cond_3

    .line 1164
    const-string v3, ""

    invoke-static {p3, p1, p2, v3}, Landroid/text/method/QwertyKeyListener;->markAsReplaced(Landroid/text/Spannable;IILjava/lang/String;)V

    .line 1165
    invoke-direct {p0, v0, v2}, Lcom/android/ex/chips/RecipientEditTextView;->createChip(Lcom/android/ex/chips/RecipientEntry;Z)Ljava/lang/CharSequence;

    move-result-object v0

    .line 1166
    if-eqz v0, :cond_3

    if-le p1, v5, :cond_3

    if-le p2, v5, :cond_3

    .line 1167
    invoke-interface {p3, p1, p2, v0}, Landroid/text/Editable;->replace(IILjava/lang/CharSequence;)Landroid/text/Editable;

    .line 1174
    :cond_3
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSelectionEnd()I

    move-result v0

    if-ne p2, v0, :cond_4

    .line 1175
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->dismissDropDown()V

    .line 1177
    :cond_4
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->sanitizeBetween()V

    move v0, v1

    .line 1178
    goto :goto_0

    :cond_5
    move v0, v2

    .line 1181
    goto :goto_0
.end method

.method private commitDefault()Z
    .locals 6

    .prologue
    const/4 v4, 0x0

    .line 1109
    iget-object v5, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

    if-nez v5, :cond_1

    .line 1126
    :cond_0
    :goto_0
    return v4

    .line 1112
    :cond_1
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v0

    .line 1113
    .local v0, "editable":Landroid/text/Editable;
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSelectionEnd()I

    move-result v1

    .line 1114
    .local v1, "end":I
    iget-object v5, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

    invoke-interface {v5, v0, v1}, Landroid/widget/MultiAutoCompleteTextView$Tokenizer;->findTokenStart(Ljava/lang/CharSequence;I)I

    move-result v2

    .line 1116
    .local v2, "start":I
    invoke-direct {p0, v2, v1}, Lcom/android/ex/chips/RecipientEditTextView;->shouldCreateChip(II)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 1117
    iget-object v4, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v5

    invoke-interface {v4, v5, v2}, Landroid/widget/MultiAutoCompleteTextView$Tokenizer;->findTokenEnd(Ljava/lang/CharSequence;I)I

    move-result v3

    .line 1120
    .local v3, "whatEnd":I
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSelectionEnd()I

    move-result v4

    if-eq v3, v4, :cond_2

    .line 1121
    invoke-direct {p0, v2, v3}, Lcom/android/ex/chips/RecipientEditTextView;->handleEdit(II)V

    .line 1122
    const/4 v4, 0x1

    goto :goto_0

    .line 1124
    :cond_2
    invoke-direct {p0, v2, v1, v0}, Lcom/android/ex/chips/RecipientEditTextView;->commitChip(IILandroid/text/Editable;)Z

    move-result v4

    goto :goto_0
.end method

.method private constructChipSpan(Lcom/android/ex/chips/RecipientEntry;IZZ)Lcom/android/ex/chips/RecipientChip;
    .locals 10
    .param p1, "contact"    # Lcom/android/ex/chips/RecipientEntry;
    .param p2, "offset"    # I
    .param p3, "pressed"    # Z
    .param p4, "leaveIconSpace"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/NullPointerException;
        }
    .end annotation

    .prologue
    const/4 v9, 0x0

    .line 608
    iget-object v7, p0, Lcom/android/ex/chips/RecipientEditTextView;->mChipBackground:Landroid/graphics/drawable/Drawable;

    if-nez v7, :cond_0

    .line 609
    new-instance v7, Ljava/lang/NullPointerException;

    const-string v8, "Unable to render any chips as setChipDimensions was not called."

    invoke-direct {v7, v8}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v7

    .line 612
    :cond_0
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getLayout()Landroid/text/Layout;

    move-result-object v2

    .line 614
    .local v2, "layout":Landroid/text/Layout;
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getPaint()Landroid/text/TextPaint;

    move-result-object v3

    .line 615
    .local v3, "paint":Landroid/text/TextPaint;
    invoke-virtual {v3}, Landroid/text/TextPaint;->getTextSize()F

    move-result v1

    .line 616
    .local v1, "defaultSize":F
    invoke-virtual {v3}, Landroid/text/TextPaint;->getColor()I

    move-result v0

    .line 619
    .local v0, "defaultColor":I
    if-eqz p3, :cond_1

    .line 620
    invoke-direct {p0, p1, v3, v2}, Lcom/android/ex/chips/RecipientEditTextView;->createSelectedChip(Lcom/android/ex/chips/RecipientEntry;Landroid/text/TextPaint;Landroid/text/Layout;)Landroid/graphics/Bitmap;

    move-result-object v6

    .line 627
    .local v6, "tmpBitmap":Landroid/graphics/Bitmap;
    :goto_0
    new-instance v5, Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    invoke-direct {v5, v7, v6}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    .line 628
    .local v5, "result":Landroid/graphics/drawable/Drawable;
    invoke-virtual {v6}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v7

    invoke-virtual {v6}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v8

    invoke-virtual {v5, v9, v9, v7, v8}, Landroid/graphics/drawable/BitmapDrawable;->setBounds(IIII)V

    .line 629
    new-instance v4, Lcom/android/ex/chips/RecipientChip;

    invoke-direct {v4, v5, p1, p2}, Lcom/android/ex/chips/RecipientChip;-><init>(Landroid/graphics/drawable/Drawable;Lcom/android/ex/chips/RecipientEntry;I)V

    .line 631
    .local v4, "recipientChip":Lcom/android/ex/chips/RecipientChip;
    invoke-virtual {v3, v1}, Landroid/text/TextPaint;->setTextSize(F)V

    .line 632
    invoke-virtual {v3, v0}, Landroid/text/TextPaint;->setColor(I)V

    .line 633
    return-object v4

    .line 623
    .end local v4    # "recipientChip":Lcom/android/ex/chips/RecipientChip;
    .end local v5    # "result":Landroid/graphics/drawable/Drawable;
    .end local v6    # "tmpBitmap":Landroid/graphics/Bitmap;
    :cond_1
    invoke-direct {p0, p1, v3, v2, p4}, Lcom/android/ex/chips/RecipientEditTextView;->createUnselectedChip(Lcom/android/ex/chips/RecipientEntry;Landroid/text/TextPaint;Landroid/text/Layout;Z)Landroid/graphics/Bitmap;

    move-result-object v6

    .restart local v6    # "tmpBitmap":Landroid/graphics/Bitmap;
    goto :goto_0
.end method

.method private createAlternatesAdapter(Lcom/android/ex/chips/RecipientChip;)Landroid/widget/ListAdapter;
    .locals 9
    .param p1, "chip"    # Lcom/android/ex/chips/RecipientChip;

    .prologue
    .line 1424
    new-instance v0, Lcom/android/ex/chips/RecipientAlternatesAdapter;

    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {p1}, Lcom/android/ex/chips/RecipientChip;->getContactId()J

    move-result-wide v2

    invoke-virtual {p1}, Lcom/android/ex/chips/RecipientChip;->getDataId()J

    move-result-wide v4

    iget v6, p0, Lcom/android/ex/chips/RecipientEditTextView;->mAlternatesLayout:I

    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v7

    check-cast v7, Lcom/android/ex/chips/BaseRecipientAdapter;

    invoke-virtual {v7}, Lcom/android/ex/chips/BaseRecipientAdapter;->getQueryType()I

    move-result v7

    move-object v8, p0

    invoke-direct/range {v0 .. v8}, Lcom/android/ex/chips/RecipientAlternatesAdapter;-><init>(Landroid/content/Context;JJIILcom/android/ex/chips/RecipientAlternatesAdapter$OnCheckedItemChangedListener;)V

    return-object v0
.end method

.method private createChip(Lcom/android/ex/chips/RecipientEntry;Z)Ljava/lang/CharSequence;
    .locals 10
    .param p1, "entry"    # Lcom/android/ex/chips/RecipientEntry;
    .param p2, "pressed"    # Z

    .prologue
    const/4 v7, 0x0

    .line 1548
    invoke-virtual {p0, p1}, Lcom/android/ex/chips/RecipientEditTextView;->createAddressText(Lcom/android/ex/chips/RecipientEntry;)Ljava/lang/String;

    move-result-object v2

    .line 1549
    .local v2, "displayText":Ljava/lang/String;
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v8

    if-eqz v8, :cond_1

    move-object v1, v7

    .line 1570
    :cond_0
    :goto_0
    return-object v1

    .line 1552
    :cond_1
    const/4 v1, 0x0

    .line 1554
    .local v1, "chipText":Landroid/text/SpannableString;
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSelectionEnd()I

    move-result v4

    .line 1555
    .local v4, "end":I
    iget-object v8, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v9

    invoke-interface {v8, v9, v4}, Landroid/widget/MultiAutoCompleteTextView$Tokenizer;->findTokenStart(Ljava/lang/CharSequence;I)I

    move-result v5

    .line 1556
    .local v5, "start":I
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v8

    add-int/lit8 v6, v8, -0x1

    .line 1557
    .local v6, "textLength":I
    new-instance v1, Landroid/text/SpannableString;

    .end local v1    # "chipText":Landroid/text/SpannableString;
    invoke-direct {v1, v2}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 1558
    .restart local v1    # "chipText":Landroid/text/SpannableString;
    iget-boolean v8, p0, Lcom/android/ex/chips/RecipientEditTextView;->mNoChips:Z

    if-nez v8, :cond_0

    .line 1560
    const/4 v8, 0x0

    :try_start_0
    invoke-direct {p0, p1, v5, p2, v8}, Lcom/android/ex/chips/RecipientEditTextView;->constructChipSpan(Lcom/android/ex/chips/RecipientEntry;IZZ)Lcom/android/ex/chips/RecipientChip;

    move-result-object v0

    .line 1562
    .local v0, "chip":Lcom/android/ex/chips/RecipientChip;
    const/4 v8, 0x0

    const/16 v9, 0x21

    invoke-virtual {v1, v0, v8, v6, v9}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 1564
    invoke-virtual {v1}, Landroid/text/SpannableString;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v0, v8}, Lcom/android/ex/chips/RecipientChip;->setOriginalText(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 1565
    .end local v0    # "chip":Lcom/android/ex/chips/RecipientChip;
    :catch_0
    move-exception v3

    .line 1566
    .local v3, "e":Ljava/lang/NullPointerException;
    const-string v8, "RecipientEditTextView"

    invoke-virtual {v3}, Ljava/lang/NullPointerException;->getMessage()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    move-object v1, v7

    .line 1567
    goto :goto_0
.end method

.method private createMoreSpan(I)Lcom/android/ex/chips/RecipientEditTextView$MoreImageSpan;
    .locals 13
    .param p1, "count"    # I

    .prologue
    const/4 v2, 0x0

    .line 1705
    iget-object v3, p0, Lcom/android/ex/chips/RecipientEditTextView;->mMoreItem:Landroid/widget/TextView;

    invoke-virtual {v3}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v2

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 1706
    .local v1, "moreText":Ljava/lang/String;
    new-instance v6, Landroid/text/TextPaint;

    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getPaint()Landroid/text/TextPaint;

    move-result-object v3

    invoke-direct {v6, v3}, Landroid/text/TextPaint;-><init>(Landroid/graphics/Paint;)V

    .line 1707
    .local v6, "morePaint":Landroid/text/TextPaint;
    iget-object v3, p0, Lcom/android/ex/chips/RecipientEditTextView;->mMoreItem:Landroid/widget/TextView;

    invoke-virtual {v3}, Landroid/widget/TextView;->getTextSize()F

    move-result v3

    invoke-virtual {v6, v3}, Landroid/text/TextPaint;->setTextSize(F)V

    .line 1708
    iget-object v3, p0, Lcom/android/ex/chips/RecipientEditTextView;->mMoreItem:Landroid/widget/TextView;

    invoke-virtual {v3}, Landroid/widget/TextView;->getCurrentTextColor()I

    move-result v3

    invoke-virtual {v6, v3}, Landroid/text/TextPaint;->setColor(I)V

    .line 1709
    invoke-virtual {v6, v1}, Landroid/text/TextPaint;->measureText(Ljava/lang/String;)F

    move-result v3

    float-to-int v3, v3

    iget-object v4, p0, Lcom/android/ex/chips/RecipientEditTextView;->mMoreItem:Landroid/widget/TextView;

    invoke-virtual {v4}, Landroid/widget/TextView;->getPaddingLeft()I

    move-result v4

    add-int/2addr v3, v4

    iget-object v4, p0, Lcom/android/ex/chips/RecipientEditTextView;->mMoreItem:Landroid/widget/TextView;

    invoke-virtual {v4}, Landroid/widget/TextView;->getPaddingRight()I

    move-result v4

    add-int v12, v3, v4

    .line 1711
    .local v12, "width":I
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getLineHeight()I

    move-result v9

    .line 1712
    .local v9, "height":I
    sget-object v3, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v12, v9, v3}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v8

    .line 1713
    .local v8, "drawable":Landroid/graphics/Bitmap;
    new-instance v0, Landroid/graphics/Canvas;

    invoke-direct {v0, v8}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 1714
    .local v0, "canvas":Landroid/graphics/Canvas;
    move v7, v9

    .line 1715
    .local v7, "adjustedHeight":I
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getLayout()Landroid/text/Layout;

    move-result-object v10

    .line 1716
    .local v10, "layout":Landroid/text/Layout;
    if-eqz v10, :cond_0

    .line 1717
    invoke-virtual {v10, v2}, Landroid/text/Layout;->getLineDescent(I)I

    move-result v3

    sub-int/2addr v7, v3

    .line 1719
    :cond_0
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v3

    const/4 v4, 0x0

    int-to-float v5, v7

    invoke-virtual/range {v0 .. v6}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;IIFFLandroid/graphics/Paint;)V

    .line 1721
    new-instance v11, Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-direct {v11, v3, v8}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    .line 1722
    .local v11, "result":Landroid/graphics/drawable/Drawable;
    invoke-virtual {v11, v2, v2, v12, v9}, Landroid/graphics/drawable/BitmapDrawable;->setBounds(IIII)V

    .line 1723
    new-instance v2, Lcom/android/ex/chips/RecipientEditTextView$MoreImageSpan;

    invoke-direct {v2, p0, v11}, Lcom/android/ex/chips/RecipientEditTextView$MoreImageSpan;-><init>(Lcom/android/ex/chips/RecipientEditTextView;Landroid/graphics/drawable/Drawable;)V

    return-object v2
.end method

.method private createReplacementChip(IILandroid/text/Editable;)V
    .locals 16
    .param p1, "tokenStart"    # I
    .param p2, "tokenEnd"    # I
    .param p3, "editable"    # Landroid/text/Editable;

    .prologue
    .line 887
    invoke-direct/range {p0 .. p2}, Lcom/android/ex/chips/RecipientEditTextView;->alreadyHasChip(II)Z

    move-result v13

    if-eqz v13, :cond_1

    .line 931
    :cond_0
    :goto_0
    return-void

    .line 892
    :cond_1
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v13

    move/from16 v0, p1

    move/from16 v1, p2

    invoke-virtual {v13, v0, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v12

    .line 893
    .local v12, "token":Ljava/lang/String;
    invoke-virtual {v12}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v13

    const/16 v14, 0x2c

    invoke-virtual {v13, v14}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v5

    .line 894
    .local v5, "commitCharIndex":I
    invoke-virtual {v12}, Ljava/lang/String;->length()I

    move-result v13

    add-int/lit8 v13, v13, -0x1

    if-ne v5, v13, :cond_2

    .line 895
    const/4 v13, 0x0

    invoke-virtual {v12}, Ljava/lang/String;->length()I

    move-result v14

    add-int/lit8 v14, v14, -0x1

    invoke-virtual {v12, v13, v14}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v12

    .line 897
    :cond_2
    move-object/from16 v0, p0

    invoke-direct {v0, v12}, Lcom/android/ex/chips/RecipientEditTextView;->createTokenizedEntry(Ljava/lang/String;)Lcom/android/ex/chips/RecipientEntry;

    move-result-object v9

    .line 898
    .local v9, "entry":Lcom/android/ex/chips/RecipientEntry;
    if-eqz v9, :cond_0

    .line 899
    move-object/from16 v0, p0

    invoke-virtual {v0, v9}, Lcom/android/ex/chips/RecipientEditTextView;->createAddressText(Lcom/android/ex/chips/RecipientEntry;)Ljava/lang/String;

    move-result-object v6

    .line 901
    .local v6, "destText":Ljava/lang/String;
    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v13

    add-int/lit8 v11, v13, -0x1

    .line 902
    .local v11, "textLength":I
    new-instance v4, Landroid/text/SpannableString;

    invoke-direct {v4, v6}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 903
    .local v4, "chipText":Landroid/text/SpannableString;
    invoke-virtual/range {p0 .. p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSelectionEnd()I

    move-result v8

    .line 904
    .local v8, "end":I
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/android/ex/chips/RecipientEditTextView;->mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

    if-eqz v13, :cond_6

    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/android/ex/chips/RecipientEditTextView;->mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

    invoke-virtual/range {p0 .. p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v14

    invoke-interface {v13, v14, v8}, Landroid/widget/MultiAutoCompleteTextView$Tokenizer;->findTokenStart(Ljava/lang/CharSequence;I)I

    move-result v10

    .line 905
    .local v10, "start":I
    :goto_1
    const/4 v3, 0x0

    .line 907
    .local v3, "chip":Lcom/android/ex/chips/RecipientChip;
    :try_start_0
    move-object/from16 v0, p0

    iget-boolean v13, v0, Lcom/android/ex/chips/RecipientEditTextView;->mNoChips:Z

    if-nez v13, :cond_4

    .line 909
    const/4 v14, 0x0

    invoke-virtual {v9}, Lcom/android/ex/chips/RecipientEntry;->getDisplayName()Ljava/lang/String;

    move-result-object v13

    invoke-static {v13}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v13

    if-nez v13, :cond_3

    invoke-virtual {v9}, Lcom/android/ex/chips/RecipientEntry;->getDisplayName()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v9}, Lcom/android/ex/chips/RecipientEntry;->getDestination()Ljava/lang/String;

    move-result-object v15

    invoke-static {v13, v15}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v13

    if-eqz v13, :cond_7

    :cond_3
    const/4 v13, 0x1

    :goto_2
    move-object/from16 v0, p0

    invoke-direct {v0, v9, v10, v14, v13}, Lcom/android/ex/chips/RecipientEditTextView;->constructChipSpan(Lcom/android/ex/chips/RecipientEntry;IZZ)Lcom/android/ex/chips/RecipientChip;

    move-result-object v3

    .line 916
    const/4 v13, 0x0

    const/16 v14, 0x21

    invoke-virtual {v4, v3, v13, v11, v14}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V
    :try_end_0
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_0

    .line 921
    :cond_4
    :goto_3
    move-object/from16 v0, p3

    move/from16 v1, p1

    move/from16 v2, p2

    invoke-interface {v0, v1, v2, v4}, Landroid/text/Editable;->replace(IILjava/lang/CharSequence;)Landroid/text/Editable;

    .line 923
    if-eqz v3, :cond_0

    .line 924
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/android/ex/chips/RecipientEditTextView;->mTemporaryRecipients:Ljava/util/ArrayList;

    if-nez v13, :cond_5

    .line 925
    new-instance v13, Ljava/util/ArrayList;

    invoke-direct {v13}, Ljava/util/ArrayList;-><init>()V

    move-object/from16 v0, p0

    iput-object v13, v0, Lcom/android/ex/chips/RecipientEditTextView;->mTemporaryRecipients:Ljava/util/ArrayList;

    .line 927
    :cond_5
    invoke-virtual {v4}, Landroid/text/SpannableString;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v3, v13}, Lcom/android/ex/chips/RecipientChip;->setOriginalText(Ljava/lang/String;)V

    .line 928
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/android/ex/chips/RecipientEditTextView;->mTemporaryRecipients:Ljava/util/ArrayList;

    invoke-virtual {v13, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_0

    .line 904
    .end local v3    # "chip":Lcom/android/ex/chips/RecipientChip;
    .end local v10    # "start":I
    :cond_6
    const/4 v10, 0x0

    goto :goto_1

    .line 909
    .restart local v3    # "chip":Lcom/android/ex/chips/RecipientChip;
    .restart local v10    # "start":I
    :cond_7
    const/4 v13, 0x0

    goto :goto_2

    .line 918
    :catch_0
    move-exception v7

    .line 919
    .local v7, "e":Ljava/lang/NullPointerException;
    const-string v13, "RecipientEditTextView"

    invoke-virtual {v7}, Ljava/lang/NullPointerException;->getMessage()Ljava/lang/String;

    move-result-object v14

    invoke-static {v13, v14, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_3
.end method

.method private createSelectedChip(Lcom/android/ex/chips/RecipientEntry;Landroid/text/TextPaint;Landroid/text/Layout;)Landroid/graphics/Bitmap;
    .locals 13
    .param p1, "contact"    # Lcom/android/ex/chips/RecipientEntry;
    .param p2, "paint"    # Landroid/text/TextPaint;
    .param p3, "layout"    # Landroid/text/Layout;

    .prologue
    .line 476
    iget v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mChipHeight:F

    float-to-int v9, v2

    .line 477
    .local v9, "height":I
    move v8, v9

    .line 478
    .local v8, "deleteWidth":I
    const/4 v2, 0x1

    new-array v12, v2, [F

    .line 479
    .local v12, "widths":[F
    const-string v2, " "

    invoke-virtual {p2, v2, v12}, Landroid/text/TextPaint;->getTextWidths(Ljava/lang/String;[F)I

    .line 480
    invoke-virtual {p0, p1}, Lcom/android/ex/chips/RecipientEditTextView;->createChipDisplayText(Lcom/android/ex/chips/RecipientEntry;)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x1

    invoke-direct {p0, v3}, Lcom/android/ex/chips/RecipientEditTextView;->calculateAvailableWidth(Z)F

    move-result v3

    int-to-float v4, v8

    sub-float/2addr v3, v4

    const/4 v4, 0x0

    aget v4, v12, v4

    sub-float/2addr v3, v4

    invoke-direct {p0, v2, p2, v3}, Lcom/android/ex/chips/RecipientEditTextView;->ellipsizeText(Ljava/lang/CharSequence;Landroid/text/TextPaint;F)Ljava/lang/CharSequence;

    move-result-object v1

    .line 485
    .local v1, "ellipsizedText":Ljava/lang/CharSequence;
    mul-int/lit8 v2, v8, 0x2

    const/4 v3, 0x0

    invoke-interface {v1}, Ljava/lang/CharSequence;->length()I

    move-result v4

    invoke-virtual {p2, v1, v3, v4}, Landroid/text/TextPaint;->measureText(Ljava/lang/CharSequence;II)F

    move-result v3

    float-to-double v3, v3

    invoke-static {v3, v4}, Ljava/lang/Math;->floor(D)D

    move-result-wide v3

    double-to-int v3, v3

    iget v4, p0, Lcom/android/ex/chips/RecipientEditTextView;->mChipPadding:I

    mul-int/lit8 v4, v4, 0x2

    add-int/2addr v3, v4

    add-int/2addr v3, v8

    invoke-static {v2, v3}, Ljava/lang/Math;->max(II)I

    move-result v11

    .line 490
    .local v11, "width":I
    sget-object v2, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v11, v9, v2}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v10

    .line 491
    .local v10, "tmpBitmap":Landroid/graphics/Bitmap;
    new-instance v0, Landroid/graphics/Canvas;

    invoke-direct {v0, v10}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 492
    .local v0, "canvas":Landroid/graphics/Canvas;
    iget-object v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mChipBackgroundPressed:Landroid/graphics/drawable/Drawable;

    if-eqz v2, :cond_0

    .line 493
    iget-object v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mChipBackgroundPressed:Landroid/graphics/drawable/Drawable;

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4, v11, v9}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 494
    iget-object v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mChipBackgroundPressed:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v2, v0}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 495
    sget v2, Lcom/android/ex/chips/RecipientEditTextView;->sSelectedTextColor:I

    invoke-virtual {p2, v2}, Landroid/text/TextPaint;->setColor(I)V

    .line 497
    const/4 v2, 0x0

    invoke-interface {v1}, Ljava/lang/CharSequence;->length()I

    move-result v3

    iget v4, p0, Lcom/android/ex/chips/RecipientEditTextView;->mChipPadding:I

    int-to-float v4, v4

    move-object v5, v1

    check-cast v5, Ljava/lang/String;

    invoke-direct {p0, v5, p2, v9}, Lcom/android/ex/chips/RecipientEditTextView;->getTextYOffset(Ljava/lang/String;Landroid/text/TextPaint;I)F

    move-result v5

    move-object v6, p2

    invoke-virtual/range {v0 .. v6}, Landroid/graphics/Canvas;->drawText(Ljava/lang/CharSequence;IIFFLandroid/graphics/Paint;)V

    .line 500
    new-instance v7, Landroid/graphics/Rect;

    invoke-direct {v7}, Landroid/graphics/Rect;-><init>()V

    .line 501
    .local v7, "backgroundPadding":Landroid/graphics/Rect;
    iget-object v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mChipBackgroundPressed:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v2, v7}, Landroid/graphics/drawable/Drawable;->getPadding(Landroid/graphics/Rect;)Z

    .line 502
    iget-object v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mChipDelete:Landroid/graphics/drawable/Drawable;

    sub-int v3, v11, v8

    iget v4, v7, Landroid/graphics/Rect;->left:I

    add-int/2addr v3, v4

    iget v4, v7, Landroid/graphics/Rect;->top:I

    add-int/lit8 v4, v4, 0x0

    iget v5, v7, Landroid/graphics/Rect;->right:I

    sub-int v5, v11, v5

    iget v6, v7, Landroid/graphics/Rect;->bottom:I

    sub-int v6, v9, v6

    invoke-virtual {v2, v3, v4, v5, v6}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 506
    iget-object v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mChipDelete:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v2, v0}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 510
    .end local v7    # "backgroundPadding":Landroid/graphics/Rect;
    :goto_0
    return-object v10

    .line 508
    :cond_0
    const-string v2, "RecipientEditTextView"

    const-string v3, "Unable to draw a background for the chips as it was never set"

    invoke-static {v2, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method private createSingleAddressAdapter(Lcom/android/ex/chips/RecipientChip;)Landroid/widget/ListAdapter;
    .locals 4
    .param p1, "currentChip"    # Lcom/android/ex/chips/RecipientChip;

    .prologue
    .line 1429
    new-instance v0, Lcom/android/ex/chips/SingleRecipientArrayAdapter;

    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getContext()Landroid/content/Context;

    move-result-object v1

    iget v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mAlternatesLayout:I

    invoke-virtual {p1}, Lcom/android/ex/chips/RecipientChip;->getEntry()Lcom/android/ex/chips/RecipientEntry;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/android/ex/chips/SingleRecipientArrayAdapter;-><init>(Landroid/content/Context;ILcom/android/ex/chips/RecipientEntry;)V

    return-object v0
.end method

.method private createTokenizedEntry(Ljava/lang/String;)Lcom/android/ex/chips/RecipientEntry;
    .locals 7
    .param p1, "token"    # Ljava/lang/String;

    .prologue
    const/4 v6, 0x0

    .line 946
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 947
    const/4 v5, 0x0

    .line 1000
    :goto_0
    return-object v5

    .line 949
    :cond_0
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->isPhoneQuery()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-static {p1}, Lcom/android/ex/chips/RecipientEditTextView;->isPhoneNumber(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 950
    invoke-static {p1}, Lcom/android/ex/chips/RecipientEntry;->constructFakeEntry(Ljava/lang/String;)Lcom/android/ex/chips/RecipientEntry;

    move-result-object v5

    goto :goto_0

    .line 953
    :cond_1
    invoke-static {p1}, Landroid/text/util/Rfc822Tokenizer;->tokenize(Ljava/lang/CharSequence;)[Landroid/text/util/Rfc822Token;

    move-result-object v3

    .line 954
    .local v3, "tokens":[Landroid/text/util/Rfc822Token;
    const/4 v1, 0x0

    .line 955
    .local v1, "display":Ljava/lang/String;
    invoke-direct {p0, p1}, Lcom/android/ex/chips/RecipientEditTextView;->isValid(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_6

    if-eqz v3, :cond_6

    array-length v5, v3

    if-lez v5, :cond_6

    .line 958
    aget-object v5, v3, v6

    invoke-virtual {v5}, Landroid/text/util/Rfc822Token;->getName()Ljava/lang/String;

    move-result-object v1

    .line 959
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_5

    .line 960
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->isPhoneQuery()Z

    move-result v5

    if-nez v5, :cond_4

    .line 961
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_2

    .line 962
    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object p1

    .line 964
    :cond_2
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v5

    add-int/lit8 v5, v5, -0x1

    invoke-virtual {p1, v5}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 965
    .local v0, "charAt":C
    const/16 v5, 0x2c

    if-eq v0, v5, :cond_3

    const/16 v5, 0x3b

    if-ne v0, v5, :cond_4

    .line 966
    :cond_3
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v5

    add-int/lit8 v5, v5, -0x1

    invoke-virtual {p1, v6, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p1

    .line 969
    .end local v0    # "charAt":C
    :cond_4
    invoke-static {v1, p1}, Lcom/android/ex/chips/RecipientEntry;->constructGeneratedEntry(Ljava/lang/String;Ljava/lang/String;)Lcom/android/ex/chips/RecipientEntry;

    move-result-object v5

    goto :goto_0

    .line 971
    :cond_5
    aget-object v5, v3, v6

    invoke-virtual {v5}, Landroid/text/util/Rfc822Token;->getAddress()Ljava/lang/String;

    move-result-object v1

    .line 972
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_6

    .line 973
    invoke-static {v1}, Lcom/android/ex/chips/RecipientEntry;->constructFakeEntry(Ljava/lang/String;)Lcom/android/ex/chips/RecipientEntry;

    move-result-object v5

    goto :goto_0

    .line 979
    :cond_6
    const/4 v4, 0x0

    .line 980
    .local v4, "validatedToken":Ljava/lang/String;
    iget-object v5, p0, Lcom/android/ex/chips/RecipientEditTextView;->mValidator:Landroid/widget/AutoCompleteTextView$Validator;

    if-eqz v5, :cond_7

    iget-object v5, p0, Lcom/android/ex/chips/RecipientEditTextView;->mValidator:Landroid/widget/AutoCompleteTextView$Validator;

    invoke-interface {v5, p1}, Landroid/widget/AutoCompleteTextView$Validator;->isValid(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_7

    .line 982
    iget-object v5, p0, Lcom/android/ex/chips/RecipientEditTextView;->mValidator:Landroid/widget/AutoCompleteTextView$Validator;

    invoke-interface {v5, p1}, Landroid/widget/AutoCompleteTextView$Validator;->fixText(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    .line 983
    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_7

    .line 984
    invoke-virtual {v4, p1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_8

    .line 987
    invoke-static {v4}, Landroid/text/util/Rfc822Tokenizer;->tokenize(Ljava/lang/CharSequence;)[Landroid/text/util/Rfc822Token;

    move-result-object v2

    .line 988
    .local v2, "tokenized":[Landroid/text/util/Rfc822Token;
    array-length v5, v2

    if-lez v5, :cond_7

    .line 989
    aget-object v5, v2, v6

    invoke-virtual {v5}, Landroid/text/util/Rfc822Token;->getAddress()Ljava/lang/String;

    move-result-object v4

    .line 1000
    .end local v2    # "tokenized":[Landroid/text/util/Rfc822Token;
    :cond_7
    :goto_1
    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_9

    .end local v4    # "validatedToken":Ljava/lang/String;
    :goto_2
    invoke-static {v4}, Lcom/android/ex/chips/RecipientEntry;->constructFakeEntry(Ljava/lang/String;)Lcom/android/ex/chips/RecipientEntry;

    move-result-object v5

    goto/16 :goto_0

    .line 995
    .restart local v4    # "validatedToken":Ljava/lang/String;
    :cond_8
    const/4 v4, 0x0

    goto :goto_1

    :cond_9
    move-object v4, p1

    .line 1000
    goto :goto_2
.end method

.method private createUnselectedChip(Lcom/android/ex/chips/RecipientEntry;Landroid/text/TextPaint;Landroid/text/Layout;Z)Landroid/graphics/Bitmap;
    .locals 25
    .param p1, "contact"    # Lcom/android/ex/chips/RecipientEntry;
    .param p2, "paint"    # Landroid/text/TextPaint;
    .param p3, "layout"    # Landroid/text/Layout;
    .param p4, "leaveBlankIconSpacer"    # Z

    .prologue
    .line 519
    move-object/from16 v0, p0

    iget v5, v0, Lcom/android/ex/chips/RecipientEditTextView;->mChipHeight:F

    float-to-int v0, v5

    move/from16 v16, v0

    .line 520
    .local v16, "height":I
    move/from16 v17, v16

    .line 521
    .local v17, "iconWidth":I
    const/4 v5, 0x1

    new-array v0, v5, [F

    move-object/from16 v24, v0

    .line 522
    .local v24, "widths":[F
    const-string v5, " "

    move-object/from16 v0, p2

    move-object/from16 v1, v24

    invoke-virtual {v0, v5, v1}, Landroid/text/TextPaint;->getTextWidths(Ljava/lang/String;[F)I

    .line 523
    invoke-virtual/range {p0 .. p1}, Lcom/android/ex/chips/RecipientEditTextView;->createChipDisplayText(Lcom/android/ex/chips/RecipientEntry;)Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x0

    move-object/from16 v0, p0

    invoke-direct {v0, v6}, Lcom/android/ex/chips/RecipientEditTextView;->calculateAvailableWidth(Z)F

    move-result v6

    move/from16 v0, v17

    int-to-float v7, v0

    sub-float/2addr v6, v7

    const/4 v7, 0x0

    aget v7, v24, v7

    sub-float/2addr v6, v7

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-direct {v0, v5, v1, v6}, Lcom/android/ex/chips/RecipientEditTextView;->ellipsizeText(Ljava/lang/CharSequence;Landroid/text/TextPaint;F)Ljava/lang/CharSequence;

    move-result-object v4

    .line 527
    .local v4, "ellipsizedText":Ljava/lang/CharSequence;
    mul-int/lit8 v5, v17, 0x2

    const/4 v6, 0x0

    invoke-interface {v4}, Ljava/lang/CharSequence;->length()I

    move-result v7

    move-object/from16 v0, p2

    invoke-virtual {v0, v4, v6, v7}, Landroid/text/TextPaint;->measureText(Ljava/lang/CharSequence;II)F

    move-result v6

    float-to-double v6, v6

    invoke-static {v6, v7}, Ljava/lang/Math;->floor(D)D

    move-result-wide v6

    double-to-int v6, v6

    move-object/from16 v0, p0

    iget v7, v0, Lcom/android/ex/chips/RecipientEditTextView;->mChipPadding:I

    mul-int/lit8 v7, v7, 0x2

    add-int/2addr v6, v7

    add-int v6, v6, v17

    invoke-static {v5, v6}, Ljava/lang/Math;->max(II)I

    move-result v23

    .line 532
    .local v23, "width":I
    sget-object v5, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    move/from16 v0, v23

    move/from16 v1, v16

    invoke-static {v0, v1, v5}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v22

    .line 533
    .local v22, "tmpBitmap":Landroid/graphics/Bitmap;
    new-instance v3, Landroid/graphics/Canvas;

    move-object/from16 v0, v22

    invoke-direct {v3, v0}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 534
    .local v3, "canvas":Landroid/graphics/Canvas;
    invoke-virtual/range {p0 .. p1}, Lcom/android/ex/chips/RecipientEditTextView;->getChipBackground(Lcom/android/ex/chips/RecipientEntry;)Landroid/graphics/drawable/Drawable;

    move-result-object v10

    .line 535
    .local v10, "background":Landroid/graphics/drawable/Drawable;
    if-eqz v10, :cond_8

    .line 536
    const/4 v5, 0x0

    const/4 v6, 0x0

    move/from16 v0, v23

    move/from16 v1, v16

    invoke-virtual {v10, v5, v6, v0, v1}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 537
    invoke-virtual {v10, v3}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 540
    invoke-virtual/range {p1 .. p1}, Lcom/android/ex/chips/RecipientEntry;->getContactId()J

    move-result-wide v12

    .line 541
    .local v12, "contactId":J
    invoke-virtual/range {p0 .. p0}, Lcom/android/ex/chips/RecipientEditTextView;->isPhoneQuery()Z

    move-result v5

    if-eqz v5, :cond_3

    const-wide/16 v5, -0x1

    cmp-long v5, v12, v5

    if-eqz v5, :cond_2

    const/4 v14, 0x1

    .line 546
    .local v14, "drawPhotos":Z
    :goto_0
    if-eqz v14, :cond_6

    .line 547
    invoke-virtual/range {p1 .. p1}, Lcom/android/ex/chips/RecipientEntry;->getPhotoBytes()[B

    move-result-object v20

    .line 550
    .local v20, "photoBytes":[B
    if-nez v20, :cond_0

    invoke-virtual/range {p1 .. p1}, Lcom/android/ex/chips/RecipientEntry;->getPhotoThumbnailUri()Landroid/net/Uri;

    move-result-object v5

    if-eqz v5, :cond_0

    .line 552
    invoke-virtual/range {p0 .. p0}, Lcom/android/ex/chips/RecipientEditTextView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v5

    check-cast v5, Lcom/android/ex/chips/BaseRecipientAdapter;

    invoke-virtual/range {p1 .. p1}, Lcom/android/ex/chips/RecipientEntry;->getPhotoThumbnailUri()Landroid/net/Uri;

    move-result-object v6

    move-object/from16 v0, p1

    invoke-virtual {v5, v0, v6}, Lcom/android/ex/chips/BaseRecipientAdapter;->fetchPhoto(Lcom/android/ex/chips/RecipientEntry;Landroid/net/Uri;)V

    .line 554
    invoke-virtual/range {p1 .. p1}, Lcom/android/ex/chips/RecipientEntry;->getPhotoBytes()[B

    move-result-object v20

    .line 558
    :cond_0
    if-eqz v20, :cond_5

    .line 559
    const/4 v5, 0x0

    move-object/from16 v0, v20

    array-length v6, v0

    move-object/from16 v0, v20

    invoke-static {v0, v5, v6}, Landroid/graphics/BitmapFactory;->decodeByteArray([BII)Landroid/graphics/Bitmap;

    move-result-object v19

    .line 565
    .local v19, "photo":Landroid/graphics/Bitmap;
    :goto_1
    if-eqz v19, :cond_1

    .line 566
    new-instance v21, Landroid/graphics/RectF;

    const/4 v5, 0x0

    const/4 v6, 0x0

    invoke-virtual/range {v19 .. v19}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v7

    int-to-float v7, v7

    invoke-virtual/range {v19 .. v19}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v8

    int-to-float v8, v8

    move-object/from16 v0, v21

    invoke-direct {v0, v5, v6, v7, v8}, Landroid/graphics/RectF;-><init>(FFFF)V

    .line 567
    .local v21, "src":Landroid/graphics/RectF;
    new-instance v11, Landroid/graphics/Rect;

    invoke-direct {v11}, Landroid/graphics/Rect;-><init>()V

    .line 568
    .local v11, "backgroundPadding":Landroid/graphics/Rect;
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/android/ex/chips/RecipientEditTextView;->mChipBackground:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v5, v11}, Landroid/graphics/drawable/Drawable;->getPadding(Landroid/graphics/Rect;)Z

    .line 569
    new-instance v15, Landroid/graphics/RectF;

    sub-int v5, v23, v17

    iget v6, v11, Landroid/graphics/Rect;->left:I

    add-int/2addr v5, v6

    int-to-float v5, v5

    iget v6, v11, Landroid/graphics/Rect;->top:I

    add-int/lit8 v6, v6, 0x0

    int-to-float v6, v6

    iget v7, v11, Landroid/graphics/Rect;->right:I

    sub-int v7, v23, v7

    int-to-float v7, v7

    iget v8, v11, Landroid/graphics/Rect;->bottom:I

    sub-int v8, v16, v8

    int-to-float v8, v8

    invoke-direct {v15, v5, v6, v7, v8}, Landroid/graphics/RectF;-><init>(FFFF)V

    .line 573
    .local v15, "dst":Landroid/graphics/RectF;
    new-instance v18, Landroid/graphics/Matrix;

    invoke-direct/range {v18 .. v18}, Landroid/graphics/Matrix;-><init>()V

    .line 574
    .local v18, "matrix":Landroid/graphics/Matrix;
    sget-object v5, Landroid/graphics/Matrix$ScaleToFit;->FILL:Landroid/graphics/Matrix$ScaleToFit;

    move-object/from16 v0, v18

    move-object/from16 v1, v21

    invoke-virtual {v0, v1, v15, v5}, Landroid/graphics/Matrix;->setRectToRect(Landroid/graphics/RectF;Landroid/graphics/RectF;Landroid/graphics/Matrix$ScaleToFit;)Z

    .line 575
    move-object/from16 v0, v19

    move-object/from16 v1, v18

    move-object/from16 v2, p2

    invoke-virtual {v3, v0, v1, v2}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V

    .line 580
    .end local v11    # "backgroundPadding":Landroid/graphics/Rect;
    .end local v15    # "dst":Landroid/graphics/RectF;
    .end local v18    # "matrix":Landroid/graphics/Matrix;
    .end local v19    # "photo":Landroid/graphics/Bitmap;
    .end local v20    # "photoBytes":[B
    .end local v21    # "src":Landroid/graphics/RectF;
    :cond_1
    :goto_2
    invoke-virtual/range {p0 .. p0}, Lcom/android/ex/chips/RecipientEditTextView;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v6, 0x106000c

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getColor(I)I

    move-result v5

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/text/TextPaint;->setColor(I)V

    .line 582
    const/4 v5, 0x0

    invoke-interface {v4}, Ljava/lang/CharSequence;->length()I

    move-result v6

    move-object/from16 v0, p0

    iget v7, v0, Lcom/android/ex/chips/RecipientEditTextView;->mChipPadding:I

    int-to-float v7, v7

    move-object v8, v4

    check-cast v8, Ljava/lang/String;

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    move/from16 v2, v16

    invoke-direct {v0, v8, v1, v2}, Lcom/android/ex/chips/RecipientEditTextView;->getTextYOffset(Ljava/lang/String;Landroid/text/TextPaint;I)F

    move-result v8

    move-object/from16 v9, p2

    invoke-virtual/range {v3 .. v9}, Landroid/graphics/Canvas;->drawText(Ljava/lang/CharSequence;IIFFLandroid/graphics/Paint;)V

    .line 587
    .end local v12    # "contactId":J
    .end local v14    # "drawPhotos":Z
    :goto_3
    return-object v22

    .line 541
    .restart local v12    # "contactId":J
    :cond_2
    const/4 v14, 0x0

    goto/16 :goto_0

    :cond_3
    const-wide/16 v5, -0x1

    cmp-long v5, v12, v5

    if-eqz v5, :cond_4

    const-wide/16 v5, -0x2

    cmp-long v5, v12, v5

    if-eqz v5, :cond_4

    invoke-virtual/range {p1 .. p1}, Lcom/android/ex/chips/RecipientEntry;->getDisplayName()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_4

    const/4 v14, 0x1

    goto/16 :goto_0

    :cond_4
    const/4 v14, 0x0

    goto/16 :goto_0

    .line 562
    .restart local v14    # "drawPhotos":Z
    .restart local v20    # "photoBytes":[B
    :cond_5
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/ex/chips/RecipientEditTextView;->mDefaultContactPhoto:Landroid/graphics/Bitmap;

    move-object/from16 v19, v0

    .restart local v19    # "photo":Landroid/graphics/Bitmap;
    goto/16 :goto_1

    .line 577
    .end local v19    # "photo":Landroid/graphics/Bitmap;
    .end local v20    # "photoBytes":[B
    :cond_6
    if-eqz p4, :cond_7

    invoke-virtual/range {p0 .. p0}, Lcom/android/ex/chips/RecipientEditTextView;->isPhoneQuery()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 578
    :cond_7
    const/16 v17, 0x0

    goto :goto_2

    .line 585
    .end local v12    # "contactId":J
    .end local v14    # "drawPhotos":Z
    :cond_8
    const-string v5, "RecipientEditTextView"

    const-string v6, "Unable to draw a background for the chips as it was never set"

    invoke-static {v5, v6}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_3
.end method

.method private createValidatedEntry(Lcom/android/ex/chips/RecipientEntry;)Lcom/android/ex/chips/RecipientEntry;
    .locals 6
    .param p1, "item"    # Lcom/android/ex/chips/RecipientEntry;

    .prologue
    .line 1603
    if-nez p1, :cond_0

    .line 1604
    const/4 v1, 0x0

    .line 1622
    :goto_0
    return-object v1

    .line 1610
    :cond_0
    invoke-virtual {p1}, Lcom/android/ex/chips/RecipientEntry;->getDestination()Ljava/lang/String;

    move-result-object v0

    .line 1611
    .local v0, "destination":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->isPhoneQuery()Z

    move-result v2

    if-nez v2, :cond_1

    invoke-virtual {p1}, Lcom/android/ex/chips/RecipientEntry;->getContactId()J

    move-result-wide v2

    const-wide/16 v4, -0x2

    cmp-long v2, v2, v4

    if-nez v2, :cond_1

    .line 1612
    invoke-virtual {p1}, Lcom/android/ex/chips/RecipientEntry;->getDisplayName()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2, v0}, Lcom/android/ex/chips/RecipientEntry;->constructGeneratedEntry(Ljava/lang/String;Ljava/lang/String;)Lcom/android/ex/chips/RecipientEntry;

    move-result-object v1

    .local v1, "entry":Lcom/android/ex/chips/RecipientEntry;
    goto :goto_0

    .line 1614
    .end local v1    # "entry":Lcom/android/ex/chips/RecipientEntry;
    :cond_1
    invoke-virtual {p1}, Lcom/android/ex/chips/RecipientEntry;->getContactId()J

    move-result-wide v2

    invoke-static {v2, v3}, Lcom/android/ex/chips/RecipientEntry;->isCreatedRecipient(J)Z

    move-result v2

    if-eqz v2, :cond_3

    invoke-virtual {p1}, Lcom/android/ex/chips/RecipientEntry;->getDisplayName()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_2

    invoke-virtual {p1}, Lcom/android/ex/chips/RecipientEntry;->getDisplayName()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2, v0}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_2

    iget-object v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mValidator:Landroid/widget/AutoCompleteTextView$Validator;

    if-eqz v2, :cond_3

    iget-object v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mValidator:Landroid/widget/AutoCompleteTextView$Validator;

    invoke-interface {v2, v0}, Landroid/widget/AutoCompleteTextView$Validator;->isValid(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_3

    .line 1618
    :cond_2
    invoke-static {v0}, Lcom/android/ex/chips/RecipientEntry;->constructFakeEntry(Ljava/lang/String;)Lcom/android/ex/chips/RecipientEntry;

    move-result-object v1

    .restart local v1    # "entry":Lcom/android/ex/chips/RecipientEntry;
    goto :goto_0

    .line 1620
    .end local v1    # "entry":Lcom/android/ex/chips/RecipientEntry;
    :cond_3
    move-object v1, p1

    .restart local v1    # "entry":Lcom/android/ex/chips/RecipientEntry;
    goto :goto_0
.end method

.method private ellipsizeText(Ljava/lang/CharSequence;Landroid/text/TextPaint;F)Ljava/lang/CharSequence;
    .locals 3
    .param p1, "text"    # Ljava/lang/CharSequence;
    .param p2, "paint"    # Landroid/text/TextPaint;
    .param p3, "maxWidth"    # F

    .prologue
    .line 464
    iget v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mChipFontSize:F

    invoke-virtual {p2, v0}, Landroid/text/TextPaint;->setTextSize(F)V

    .line 465
    const/4 v0, 0x0

    cmpg-float v0, p3, v0

    if-gtz v0, :cond_0

    const-string v0, "RecipientEditTextView"

    const/4 v1, 0x3

    invoke-static {v0, v1}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 466
    const-string v0, "RecipientEditTextView"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Max width is negative: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 468
    :cond_0
    sget-object v0, Landroid/text/TextUtils$TruncateAt;->END:Landroid/text/TextUtils$TruncateAt;

    invoke-static {p1, p2, p3, v0}, Landroid/text/TextUtils;->ellipsize(Ljava/lang/CharSequence;Landroid/text/TextPaint;FLandroid/text/TextUtils$TruncateAt;)Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method private expand()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x0

    .line 448
    iget-boolean v1, p0, Lcom/android/ex/chips/RecipientEditTextView;->mShouldShrink:Z

    if-eqz v1, :cond_0

    .line 449
    const v1, 0x7fffffff

    invoke-virtual {p0, v1}, Lcom/android/ex/chips/RecipientEditTextView;->setMaxLines(I)V

    .line 451
    :cond_0
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->removeMoreChip()V

    .line 452
    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Lcom/android/ex/chips/RecipientEditTextView;->setCursorVisible(Z)V

    .line 453
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v0

    .line 454
    .local v0, "text":Landroid/text/Editable;
    if-eqz v0, :cond_2

    invoke-interface {v0}, Landroid/text/Editable;->length()I

    move-result v1

    if-lez v1, :cond_2

    invoke-interface {v0}, Landroid/text/Editable;->length()I

    move-result v1

    :goto_0
    invoke-virtual {p0, v1}, Lcom/android/ex/chips/RecipientEditTextView;->setSelection(I)V

    .line 457
    iget-object v1, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTemporaryRecipients:Ljava/util/ArrayList;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTemporaryRecipients:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-lez v1, :cond_1

    .line 458
    new-instance v1, Lcom/android/ex/chips/RecipientEditTextView$RecipientReplacementTask;

    invoke-direct {v1, p0, v3}, Lcom/android/ex/chips/RecipientEditTextView$RecipientReplacementTask;-><init>(Lcom/android/ex/chips/RecipientEditTextView;Lcom/android/ex/chips/RecipientEditTextView$1;)V

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v1, v2}, Lcom/android/ex/chips/RecipientEditTextView$RecipientReplacementTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 459
    iput-object v3, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTemporaryRecipients:Ljava/util/ArrayList;

    .line 461
    :cond_1
    return-void

    :cond_2
    move v1, v2

    .line 454
    goto :goto_0
.end method

.method private findChip(I)Lcom/android/ex/chips/RecipientChip;
    .locals 5

    .prologue
    const/4 v1, 0x0

    .line 1480
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSpannable()Landroid/text/Spannable;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-interface {v2}, Landroid/text/Editable;->length()I

    move-result v2

    const-class v3, Lcom/android/ex/chips/RecipientChip;

    invoke-interface {v0, v1, v2, v3}, Landroid/text/Spannable;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/android/ex/chips/RecipientChip;

    .line 1482
    :goto_0
    array-length v2, v0

    if-ge v1, v2, :cond_1

    .line 1483
    aget-object v2, v0, v1

    .line 1484
    invoke-direct {p0, v2}, Lcom/android/ex/chips/RecipientEditTextView;->getChipStart(Lcom/android/ex/chips/RecipientChip;)I

    move-result v3

    .line 1485
    invoke-direct {p0, v2}, Lcom/android/ex/chips/RecipientEditTextView;->getChipEnd(Lcom/android/ex/chips/RecipientChip;)I

    move-result v4

    .line 1486
    if-lt p1, v3, :cond_0

    if-gt p1, v4, :cond_0

    move-object v0, v2

    .line 1490
    :goto_1
    return-object v0

    .line 1482
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 1490
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method private findText(Landroid/text/Editable;I)I
    .locals 2
    .param p1, "text"    # Landroid/text/Editable;
    .param p2, "offset"    # I

    .prologue
    .line 1473
    invoke-interface {p1, p2}, Landroid/text/Editable;->charAt(I)C

    move-result v0

    const/16 v1, 0x20

    if-eq v0, v1, :cond_0

    .line 1476
    .end local p2    # "offset":I
    :goto_0
    return p2

    .restart local p2    # "offset":I
    :cond_0
    const/4 p2, -0x1

    goto :goto_0
.end method

.method private focusNext()Z
    .locals 2

    .prologue
    .line 1092
    const/16 v1, 0x82

    invoke-virtual {p0, v1}, Lcom/android/ex/chips/RecipientEditTextView;->focusSearch(I)Landroid/view/View;

    move-result-object v0

    .line 1093
    .local v0, "next":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 1094
    invoke-virtual {v0}, Landroid/view/View;->requestFocus()Z

    .line 1095
    const/4 v1, 0x1

    .line 1097
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private getChipEnd(Lcom/android/ex/chips/RecipientChip;)I
    .locals 1
    .param p1, "chip"    # Lcom/android/ex/chips/RecipientChip;

    .prologue
    .line 1285
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSpannable()Landroid/text/Spannable;

    move-result-object v0

    invoke-interface {v0, p1}, Landroid/text/Spannable;->getSpanEnd(Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method private getChipStart(Lcom/android/ex/chips/RecipientChip;)I
    .locals 1
    .param p1, "chip"    # Lcom/android/ex/chips/RecipientChip;

    .prologue
    .line 1281
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSpannable()Landroid/text/Spannable;

    move-result-object v0

    invoke-interface {v0, p1}, Landroid/text/Spannable;->getSpanStart(Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method private getTextYOffset(Ljava/lang/String;Landroid/text/TextPaint;I)F
    .locals 4
    .param p1, "text"    # Ljava/lang/String;
    .param p2, "paint"    # Landroid/text/TextPaint;
    .param p3, "height"    # I

    .prologue
    .line 600
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    .line 601
    .local v0, "bounds":Landroid/graphics/Rect;
    const/4 v2, 0x0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v3

    invoke-virtual {p2, p1, v2, v3, v0}, Landroid/text/TextPaint;->getTextBounds(Ljava/lang/String;IILandroid/graphics/Rect;)V

    .line 602
    iget v2, v0, Landroid/graphics/Rect;->bottom:I

    iget v3, v0, Landroid/graphics/Rect;->top:I

    sub-int v1, v2, v3

    .line 603
    .local v1, "textHeight":I
    sub-int v2, p3, v1

    div-int/lit8 v2, v2, 0x2

    sub-int v2, p3, v2

    invoke-virtual {p2}, Landroid/text/TextPaint;->descent()F

    move-result v3

    float-to-int v3, v3

    sub-int/2addr v2, v3

    int-to-float v2, v2

    return v2
.end method

.method private handleEdit(II)V
    .locals 4

    .prologue
    const/4 v3, -0x1

    .line 1233
    if-eq p1, v3, :cond_0

    if-ne p2, v3, :cond_1

    .line 1235
    :cond_0
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->dismissDropDown()V

    .line 1253
    :goto_0
    return-void

    .line 1240
    :cond_1
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v0

    .line 1241
    invoke-virtual {p0, p2}, Lcom/android/ex/chips/RecipientEditTextView;->setSelection(I)V

    .line 1242
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1, p1, p2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    .line 1243
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 1244
    invoke-static {v1}, Lcom/android/ex/chips/RecipientEntry;->constructFakeEntry(Ljava/lang/String;)Lcom/android/ex/chips/RecipientEntry;

    move-result-object v1

    .line 1245
    const-string v2, ""

    invoke-static {v0, p1, p2, v2}, Landroid/text/method/QwertyKeyListener;->markAsReplaced(Landroid/text/Spannable;IILjava/lang/String;)V

    .line 1246
    const/4 v2, 0x0

    invoke-direct {p0, v1, v2}, Lcom/android/ex/chips/RecipientEditTextView;->createChip(Lcom/android/ex/chips/RecipientEntry;Z)Ljava/lang/CharSequence;

    move-result-object v1

    .line 1247
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSelectionEnd()I

    move-result v2

    .line 1248
    if-eqz v1, :cond_2

    if-le p1, v3, :cond_2

    if-le v2, v3, :cond_2

    .line 1249
    invoke-interface {v0, p1, v2, v1}, Landroid/text/Editable;->replace(IILjava/lang/CharSequence;)Landroid/text/Editable;

    .line 1252
    :cond_2
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->dismissDropDown()V

    goto :goto_0
.end method

.method private handlePasteAndReplace()V
    .locals 4

    .prologue
    .line 2253
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->handlePaste()Ljava/util/ArrayList;

    move-result-object v0

    .line 2254
    .local v0, "created":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/android/ex/chips/RecipientChip;>;"
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-lez v2, :cond_0

    .line 2256
    new-instance v1, Lcom/android/ex/chips/RecipientEditTextView$IndividualReplacementTask;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Lcom/android/ex/chips/RecipientEditTextView$IndividualReplacementTask;-><init>(Lcom/android/ex/chips/RecipientEditTextView;Lcom/android/ex/chips/RecipientEditTextView$1;)V

    .line 2257
    .local v1, "replace":Lcom/android/ex/chips/RecipientEditTextView$IndividualReplacementTask;
    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object v0, v2, v3

    invoke-virtual {v1, v2}, Lcom/android/ex/chips/RecipientEditTextView$IndividualReplacementTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 2259
    .end local v1    # "replace":Lcom/android/ex/chips/RecipientEditTextView$IndividualReplacementTask;
    :cond_0
    return-void
.end method

.method private handlePasteClip(Landroid/content/ClipData;)V
    .locals 5

    .prologue
    .line 2219
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTextWatcher:Landroid/text/TextWatcher;

    invoke-virtual {p0, v0}, Lcom/android/ex/chips/RecipientEditTextView;->removeTextChangedListener(Landroid/text/TextWatcher;)V

    .line 2221
    if-eqz p1, :cond_2

    invoke-virtual {p1}, Landroid/content/ClipData;->getDescription()Landroid/content/ClipDescription;

    move-result-object v0

    const-string v1, "text/plain"

    invoke-virtual {v0, v1}, Landroid/content/ClipDescription;->hasMimeType(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 2222
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {p1}, Landroid/content/ClipData;->getItemCount()I

    move-result v1

    if-ge v0, v1, :cond_2

    .line 2223
    invoke-virtual {p1, v0}, Landroid/content/ClipData;->getItemAt(I)Landroid/content/ClipData$Item;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/ClipData$Item;->getText()Ljava/lang/CharSequence;

    move-result-object v1

    .line 2224
    if-eqz v1, :cond_0

    .line 2225
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSelectionStart()I

    move-result v2

    .line 2226
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSelectionEnd()I

    move-result v3

    .line 2227
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v4

    .line 2228
    if-ltz v2, :cond_1

    if-ltz v3, :cond_1

    if-eq v2, v3, :cond_1

    .line 2229
    invoke-interface {v4, v1, v2, v3}, Landroid/text/Editable;->append(Ljava/lang/CharSequence;II)Landroid/text/Editable;

    .line 2233
    :goto_1
    invoke-direct {p0}, Lcom/android/ex/chips/RecipientEditTextView;->handlePasteAndReplace()V

    .line 2222
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 2231
    :cond_1
    invoke-interface {v4, v3, v1}, Landroid/text/Editable;->insert(ILjava/lang/CharSequence;)Landroid/text/Editable;

    goto :goto_1

    .line 2238
    :cond_2
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/android/ex/chips/RecipientEditTextView;->mAddTextWatcher:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 2239
    return-void
.end method

.method private isInDelete(Lcom/android/ex/chips/RecipientChip;IFF)Z
    .locals 1
    .param p1, "chip"    # Lcom/android/ex/chips/RecipientChip;
    .param p2, "offset"    # I
    .param p3, "x"    # F
    .param p4, "y"    # F

    .prologue
    .line 2019
    invoke-virtual {p1}, Lcom/android/ex/chips/RecipientChip;->isSelected()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-direct {p0, p1}, Lcom/android/ex/chips/RecipientEditTextView;->getChipEnd(Lcom/android/ex/chips/RecipientChip;)I

    move-result v0

    if-ne p2, v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static isPhoneNumber(Ljava/lang/String;)Z
    .locals 2
    .param p0, "number"    # Ljava/lang/String;

    .prologue
    .line 937
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 938
    const/4 v1, 0x0

    .line 942
    :goto_0
    return v1

    .line 941
    :cond_0
    sget-object v1, Landroid/util/Patterns;->PHONE:Ljava/util/regex/Pattern;

    invoke-virtual {v1, p0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    .line 942
    .local v0, "match":Ljava/util/regex/Matcher;
    invoke-virtual {v0}, Ljava/util/regex/Matcher;->matches()Z

    move-result v1

    goto :goto_0
.end method

.method private isValid(Ljava/lang/String;)Z
    .locals 1
    .param p1, "text"    # Ljava/lang/String;

    .prologue
    .line 1005
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mValidator:Landroid/widget/AutoCompleteTextView$Validator;

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mValidator:Landroid/widget/AutoCompleteTextView$Validator;

    invoke-interface {v0, p1}, Landroid/widget/AutoCompleteTextView$Validator;->isValid(Ljava/lang/CharSequence;)Z

    move-result v0

    goto :goto_0
.end method

.method private postHandlePendingChips()V
    .locals 2

    .prologue
    .line 758
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/android/ex/chips/RecipientEditTextView;->mHandlePendingChips:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 759
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/android/ex/chips/RecipientEditTextView;->mHandlePendingChips:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 760
    return-void
.end method

.method private putOffsetInRange(I)I
    .locals 9
    .param p1, "o"    # I

    .prologue
    .line 1446
    move v3, p1

    .line 1447
    .local v3, "offset":I
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v6

    .line 1448
    .local v6, "text":Landroid/text/Editable;
    invoke-interface {v6}, Landroid/text/Editable;->length()I

    move-result v2

    .line 1450
    .local v2, "length":I
    move v5, v2

    .line 1451
    .local v5, "realLength":I
    add-int/lit8 v1, v2, -0x1

    .local v1, "i":I
    :goto_0
    if-ltz v1, :cond_0

    .line 1452
    invoke-interface {v6, v1}, Landroid/text/Editable;->charAt(I)C

    move-result v7

    const/16 v8, 0x20

    if-ne v7, v8, :cond_0

    .line 1453
    add-int/lit8 v5, v5, -0x1

    .line 1451
    add-int/lit8 v1, v1, -0x1

    goto :goto_0

    .line 1461
    :cond_0
    if-lt v3, v5, :cond_1

    move v4, v3

    .line 1469
    .end local v3    # "offset":I
    .local v4, "offset":I
    :goto_1
    return v4

    .line 1464
    .end local v4    # "offset":I
    .restart local v3    # "offset":I
    :cond_1
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v0

    .line 1465
    .local v0, "editable":Landroid/text/Editable;
    :goto_2
    if-ltz v3, :cond_2

    invoke-direct {p0, v0, v3}, Lcom/android/ex/chips/RecipientEditTextView;->findText(Landroid/text/Editable;I)I

    move-result v7

    const/4 v8, -0x1

    if-ne v7, v8, :cond_2

    invoke-direct {p0, v3}, Lcom/android/ex/chips/RecipientEditTextView;->findChip(I)Lcom/android/ex/chips/RecipientChip;

    move-result-object v7

    if-nez v7, :cond_2

    .line 1467
    add-int/lit8 v3, v3, -0x1

    goto :goto_2

    :cond_2
    move v4, v3

    .line 1469
    .end local v3    # "offset":I
    .restart local v4    # "offset":I
    goto :goto_1
.end method

.method private scrollBottomIntoView()V
    .locals 4

    .prologue
    .line 2210
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mScrollView:Landroid/widget/ScrollView;

    if-eqz v0, :cond_0

    .line 2211
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mScrollView:Landroid/widget/ScrollView;

    const/4 v1, 0x0

    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getLineCount()I

    move-result v2

    int-to-float v2, v2

    iget v3, p0, Lcom/android/ex/chips/RecipientEditTextView;->mChipHeight:F

    mul-float/2addr v2, v3

    float-to-int v2, v2

    invoke-virtual {v0, v1, v2}, Landroid/widget/ScrollView;->scrollBy(II)V

    .line 2213
    :cond_0
    return-void
.end method

.method private scrollLineIntoView(I)V
    .locals 3
    .param p1, "line"    # I

    .prologue
    .line 1386
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mScrollView:Landroid/widget/ScrollView;

    if-eqz v0, :cond_0

    .line 1387
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mScrollView:Landroid/widget/ScrollView;

    const/4 v1, 0x0

    invoke-direct {p0, p1}, Lcom/android/ex/chips/RecipientEditTextView;->calculateOffsetFromBottom(I)I

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/widget/ScrollView;->scrollBy(II)V

    .line 1389
    :cond_0
    return-void
.end method

.method private selectChip(Lcom/android/ex/chips/RecipientChip;)Lcom/android/ex/chips/RecipientChip;
    .locals 10

    .prologue
    const/16 v9, 0x21

    const/4 v2, 0x0

    const/4 v8, 0x0

    const/4 v7, 0x1

    const/4 v6, -0x1

    .line 1880
    invoke-direct {p0, p1}, Lcom/android/ex/chips/RecipientEditTextView;->shouldShowEditableText(Lcom/android/ex/chips/RecipientChip;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1881
    invoke-virtual {p1}, Lcom/android/ex/chips/RecipientChip;->getValue()Ljava/lang/CharSequence;

    move-result-object v0

    .line 1882
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v1

    .line 1883
    invoke-virtual {p0, p1}, Lcom/android/ex/chips/RecipientEditTextView;->removeChip(Lcom/android/ex/chips/RecipientChip;)V

    .line 1884
    invoke-interface {v1, v0}, Landroid/text/Editable;->append(Ljava/lang/CharSequence;)Landroid/text/Editable;

    .line 1885
    invoke-virtual {p0, v7}, Lcom/android/ex/chips/RecipientEditTextView;->setCursorVisible(Z)V

    .line 1886
    invoke-interface {v1}, Landroid/text/Editable;->length()I

    move-result v1

    invoke-virtual {p0, v1}, Lcom/android/ex/chips/RecipientEditTextView;->setSelection(I)V

    .line 1887
    new-instance v1, Lcom/android/ex/chips/RecipientChip;

    check-cast v0, Ljava/lang/String;

    invoke-static {v0}, Lcom/android/ex/chips/RecipientEntry;->constructFakeEntry(Ljava/lang/String;)Lcom/android/ex/chips/RecipientEntry;

    move-result-object v0

    invoke-direct {v1, v2, v0, v6}, Lcom/android/ex/chips/RecipientChip;-><init>(Landroid/graphics/drawable/Drawable;Lcom/android/ex/chips/RecipientEntry;I)V

    move-object v0, v1

    .line 1940
    :goto_0
    return-object v0

    .line 1888
    :cond_0
    invoke-virtual {p1}, Lcom/android/ex/chips/RecipientChip;->getContactId()J

    move-result-wide v0

    const-wide/16 v3, -0x2

    cmp-long v0, v0, v3

    if-nez v0, :cond_5

    .line 1889
    invoke-direct {p0, p1}, Lcom/android/ex/chips/RecipientEditTextView;->getChipStart(Lcom/android/ex/chips/RecipientChip;)I

    move-result v1

    .line 1890
    invoke-direct {p0, p1}, Lcom/android/ex/chips/RecipientEditTextView;->getChipEnd(Lcom/android/ex/chips/RecipientChip;)I

    move-result v3

    .line 1891
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSpannable()Landroid/text/Spannable;

    move-result-object v0

    invoke-interface {v0, p1}, Landroid/text/Spannable;->removeSpan(Ljava/lang/Object;)V

    .line 1894
    :try_start_0
    iget-boolean v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mNoChips:Z

    if-eqz v0, :cond_1

    move-object v0, v2

    .line 1895
    goto :goto_0

    .line 1897
    :cond_1
    invoke-virtual {p1}, Lcom/android/ex/chips/RecipientChip;->getEntry()Lcom/android/ex/chips/RecipientEntry;

    move-result-object v0

    const/4 v4, 0x1

    const/4 v5, 0x0

    invoke-direct {p0, v0, v1, v4, v5}, Lcom/android/ex/chips/RecipientEditTextView;->constructChipSpan(Lcom/android/ex/chips/RecipientEntry;IZZ)Lcom/android/ex/chips/RecipientChip;
    :try_end_0
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 1902
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v2

    .line 1903
    const-string v4, ""

    invoke-static {v2, v1, v3, v4}, Landroid/text/method/QwertyKeyListener;->markAsReplaced(Landroid/text/Spannable;IILjava/lang/String;)V

    .line 1904
    if-eq v1, v6, :cond_2

    if-ne v3, v6, :cond_4

    .line 1905
    :cond_2
    const-string v1, "RecipientEditTextView"

    const-string v2, "The chip being selected no longer exists but should."

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 1909
    :goto_1
    invoke-virtual {v0, v7}, Lcom/android/ex/chips/RecipientChip;->setSelected(Z)V

    .line 1910
    invoke-direct {p0, v0}, Lcom/android/ex/chips/RecipientEditTextView;->shouldShowEditableText(Lcom/android/ex/chips/RecipientChip;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 1911
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getLayout()Landroid/text/Layout;

    move-result-object v1

    invoke-direct {p0, v0}, Lcom/android/ex/chips/RecipientEditTextView;->getChipStart(Lcom/android/ex/chips/RecipientChip;)I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/text/Layout;->getLineForOffset(I)I

    move-result v1

    invoke-direct {p0, v1}, Lcom/android/ex/chips/RecipientEditTextView;->scrollLineIntoView(I)V

    .line 1913
    :cond_3
    iget-object v1, p0, Lcom/android/ex/chips/RecipientEditTextView;->mAddressPopup:Landroid/widget/ListPopupWindow;

    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getWidth()I

    move-result v2

    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-direct {p0, v0, v1, v2, v3}, Lcom/android/ex/chips/RecipientEditTextView;->showAddress(Lcom/android/ex/chips/RecipientChip;Landroid/widget/ListPopupWindow;ILandroid/content/Context;)V

    .line 1914
    invoke-virtual {p0, v8}, Lcom/android/ex/chips/RecipientEditTextView;->setCursorVisible(Z)V

    goto :goto_0

    .line 1898
    :catch_0
    move-exception v0

    .line 1899
    const-string v1, "RecipientEditTextView"

    invoke-virtual {v0}, Ljava/lang/NullPointerException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    move-object v0, v2

    .line 1900
    goto :goto_0

    .line 1907
    :cond_4
    invoke-interface {v2, v0, v1, v3, v9}, Landroid/text/Editable;->setSpan(Ljava/lang/Object;III)V

    goto :goto_1

    .line 1917
    :cond_5
    invoke-direct {p0, p1}, Lcom/android/ex/chips/RecipientEditTextView;->getChipStart(Lcom/android/ex/chips/RecipientChip;)I

    move-result v1

    .line 1918
    invoke-direct {p0, p1}, Lcom/android/ex/chips/RecipientEditTextView;->getChipEnd(Lcom/android/ex/chips/RecipientChip;)I

    move-result v3

    .line 1919
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSpannable()Landroid/text/Spannable;

    move-result-object v0

    invoke-interface {v0, p1}, Landroid/text/Spannable;->removeSpan(Ljava/lang/Object;)V

    .line 1922
    :try_start_1
    invoke-virtual {p1}, Lcom/android/ex/chips/RecipientChip;->getEntry()Lcom/android/ex/chips/RecipientEntry;

    move-result-object v0

    const/4 v4, 0x1

    const/4 v5, 0x0

    invoke-direct {p0, v0, v1, v4, v5}, Lcom/android/ex/chips/RecipientEditTextView;->constructChipSpan(Lcom/android/ex/chips/RecipientEntry;IZZ)Lcom/android/ex/chips/RecipientChip;
    :try_end_1
    .catch Ljava/lang/NullPointerException; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v0

    .line 1927
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v2

    .line 1928
    const-string v4, ""

    invoke-static {v2, v1, v3, v4}, Landroid/text/method/QwertyKeyListener;->markAsReplaced(Landroid/text/Spannable;IILjava/lang/String;)V

    .line 1929
    if-eq v1, v6, :cond_6

    if-ne v3, v6, :cond_8

    .line 1930
    :cond_6
    const-string v1, "RecipientEditTextView"

    const-string v2, "The chip being selected no longer exists but should."

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 1934
    :goto_2
    invoke-virtual {v0, v7}, Lcom/android/ex/chips/RecipientChip;->setSelected(Z)V

    .line 1935
    invoke-direct {p0, v0}, Lcom/android/ex/chips/RecipientEditTextView;->shouldShowEditableText(Lcom/android/ex/chips/RecipientChip;)Z

    move-result v1

    if-eqz v1, :cond_7

    .line 1936
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getLayout()Landroid/text/Layout;

    move-result-object v1

    invoke-direct {p0, v0}, Lcom/android/ex/chips/RecipientEditTextView;->getChipStart(Lcom/android/ex/chips/RecipientChip;)I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/text/Layout;->getLineForOffset(I)I

    move-result v1

    invoke-direct {p0, v1}, Lcom/android/ex/chips/RecipientEditTextView;->scrollLineIntoView(I)V

    .line 1938
    :cond_7
    iget-object v1, p0, Lcom/android/ex/chips/RecipientEditTextView;->mAlternatesPopup:Landroid/widget/ListPopupWindow;

    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getWidth()I

    move-result v2

    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-direct {p0, v0, v1, v2, v3}, Lcom/android/ex/chips/RecipientEditTextView;->showAlternates(Lcom/android/ex/chips/RecipientChip;Landroid/widget/ListPopupWindow;ILandroid/content/Context;)V

    .line 1939
    invoke-virtual {p0, v8}, Lcom/android/ex/chips/RecipientEditTextView;->setCursorVisible(Z)V

    goto/16 :goto_0

    .line 1923
    :catch_1
    move-exception v0

    .line 1924
    const-string v1, "RecipientEditTextView"

    invoke-virtual {v0}, Ljava/lang/NullPointerException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    move-object v0, v2

    .line 1925
    goto/16 :goto_0

    .line 1932
    :cond_8
    invoke-interface {v2, v0, v1, v3, v9}, Landroid/text/Editable;->setSpan(Ljava/lang/Object;III)V

    goto :goto_2
.end method

.method private setChipDimensions(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 8
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/high16 v7, -0x40800000    # -1.0f

    const/4 v6, 0x0

    const/4 v5, -0x1

    .line 660
    sget-object v2, Lcom/android/ex/chips/R$styleable;->RecipientEditTextView:[I

    invoke-virtual {p1, p2, v2, v6, v6}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 662
    .local v0, "a":Landroid/content/res/TypedArray;
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    .line 663
    .local v1, "r":Landroid/content/res/Resources;
    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Landroid/content/res/TypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    iput-object v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mChipBackground:Landroid/graphics/drawable/Drawable;

    .line 664
    iget-object v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mChipBackground:Landroid/graphics/drawable/Drawable;

    if-nez v2, :cond_0

    .line 665
    sget v2, Lcom/android/ex/chips/R$drawable;->chip_background:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    iput-object v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mChipBackground:Landroid/graphics/drawable/Drawable;

    .line 667
    :cond_0
    const/4 v2, 0x2

    invoke-virtual {v0, v2}, Landroid/content/res/TypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    iput-object v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mChipBackgroundPressed:Landroid/graphics/drawable/Drawable;

    .line 669
    iget-object v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mChipBackgroundPressed:Landroid/graphics/drawable/Drawable;

    if-nez v2, :cond_1

    .line 670
    sget v2, Lcom/android/ex/chips/R$drawable;->chip_background_selected:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    iput-object v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mChipBackgroundPressed:Landroid/graphics/drawable/Drawable;

    .line 672
    :cond_1
    const/4 v2, 0x3

    invoke-virtual {v0, v2}, Landroid/content/res/TypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    iput-object v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mChipDelete:Landroid/graphics/drawable/Drawable;

    .line 673
    iget-object v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mChipDelete:Landroid/graphics/drawable/Drawable;

    if-nez v2, :cond_2

    .line 674
    sget v2, Lcom/android/ex/chips/R$drawable;->chip_delete:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    iput-object v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mChipDelete:Landroid/graphics/drawable/Drawable;

    .line 676
    :cond_2
    const/4 v2, 0x5

    invoke-virtual {v0, v2, v5}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v2

    iput v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mChipPadding:I

    .line 677
    iget v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mChipPadding:I

    if-ne v2, v5, :cond_3

    .line 678
    sget v2, Lcom/android/ex/chips/R$dimen;->chip_padding:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v2

    float-to-int v2, v2

    iput v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mChipPadding:I

    .line 680
    :cond_3
    const/4 v2, 0x4

    invoke-virtual {v0, v2, v5}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v2

    iput v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mAlternatesLayout:I

    .line 682
    iget v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mAlternatesLayout:I

    if-ne v2, v5, :cond_4

    .line 683
    sget v2, Lcom/android/ex/chips/R$layout;->chips_alternate_item:I

    iput v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mAlternatesLayout:I

    .line 686
    :cond_4
    sget v2, Lcom/android/ex/chips/R$drawable;->ic_contact_picture:I

    invoke-static {v1, v2}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v2

    iput-object v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mDefaultContactPhoto:Landroid/graphics/Bitmap;

    .line 688
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    sget v3, Lcom/android/ex/chips/R$layout;->more_item:I

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mMoreItem:Landroid/widget/TextView;

    .line 690
    const/4 v2, 0x6

    invoke-virtual {v0, v2, v5}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v2

    int-to-float v2, v2

    iput v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mChipHeight:F

    .line 691
    iget v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mChipHeight:F

    cmpl-float v2, v2, v7

    if-nez v2, :cond_5

    .line 692
    sget v2, Lcom/android/ex/chips/R$dimen;->chip_height:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v2

    iput v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mChipHeight:F

    .line 694
    :cond_5
    const/4 v2, 0x7

    invoke-virtual {v0, v2, v5}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v2

    int-to-float v2, v2

    iput v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mChipFontSize:F

    .line 695
    iget v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mChipFontSize:F

    cmpl-float v2, v2, v7

    if-nez v2, :cond_6

    .line 696
    sget v2, Lcom/android/ex/chips/R$dimen;->chip_text_size:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v2

    iput v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mChipFontSize:F

    .line 698
    :cond_6
    invoke-virtual {v0, v6}, Landroid/content/res/TypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    iput-object v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mInvalidChipBackground:Landroid/graphics/drawable/Drawable;

    .line 700
    iget-object v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mInvalidChipBackground:Landroid/graphics/drawable/Drawable;

    if-nez v2, :cond_7

    .line 701
    sget v2, Lcom/android/ex/chips/R$drawable;->chip_background_invalid:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    iput-object v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mInvalidChipBackground:Landroid/graphics/drawable/Drawable;

    .line 703
    :cond_7
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/android/ex/chips/R$dimen;->line_spacing_extra:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v2

    iput v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mLineSpacingExtra:F

    .line 704
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 705
    return-void
.end method

.method private shouldCreateChip(II)Z
    .locals 1
    .param p1, "start"    # I
    .param p2, "end"    # I

    .prologue
    .line 1218
    iget-boolean v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mNoChips:Z

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->hasFocus()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->enoughToFilter()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-direct {p0, p1, p2}, Lcom/android/ex/chips/RecipientEditTextView;->alreadyHasChip(II)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private shouldShowEditableText(Lcom/android/ex/chips/RecipientChip;)Z
    .locals 4
    .param p1, "currentChip"    # Lcom/android/ex/chips/RecipientChip;

    .prologue
    .line 1945
    invoke-virtual {p1}, Lcom/android/ex/chips/RecipientChip;->getContactId()J

    move-result-wide v0

    .line 1946
    .local v0, "contactId":J
    const-wide/16 v2, -0x1

    cmp-long v2, v0, v2

    if-eqz v2, :cond_0

    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->isPhoneQuery()Z

    move-result v2

    if-nez v2, :cond_1

    const-wide/16 v2, -0x2

    cmp-long v2, v0, v2

    if-nez v2, :cond_1

    :cond_0
    const/4 v2, 0x1

    :goto_0
    return v2

    :cond_1
    const/4 v2, 0x0

    goto :goto_0
.end method

.method private showAddress(Lcom/android/ex/chips/RecipientChip;Landroid/widget/ListPopupWindow;ILandroid/content/Context;)V
    .locals 6
    .param p1, "currentChip"    # Lcom/android/ex/chips/RecipientChip;
    .param p2, "popup"    # Landroid/widget/ListPopupWindow;
    .param p3, "width"    # I
    .param p4, "context"    # Landroid/content/Context;

    .prologue
    const/4 v5, 0x1

    .line 1952
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getLayout()Landroid/text/Layout;

    move-result-object v3

    invoke-direct {p0, p1}, Lcom/android/ex/chips/RecipientEditTextView;->getChipStart(Lcom/android/ex/chips/RecipientChip;)I

    move-result v4

    invoke-virtual {v3, v4}, Landroid/text/Layout;->getLineForOffset(I)I

    move-result v1

    .line 1953
    .local v1, "line":I
    invoke-direct {p0, v1}, Lcom/android/ex/chips/RecipientEditTextView;->calculateOffsetFromBottom(I)I

    move-result v0

    .line 1956
    .local v0, "bottom":I
    invoke-virtual {p2, p3}, Landroid/widget/ListPopupWindow;->setWidth(I)V

    .line 1957
    invoke-virtual {p2, p0}, Landroid/widget/ListPopupWindow;->setAnchorView(Landroid/view/View;)V

    .line 1958
    invoke-virtual {p2, v0}, Landroid/widget/ListPopupWindow;->setVerticalOffset(I)V

    .line 1959
    invoke-direct {p0, p1}, Lcom/android/ex/chips/RecipientEditTextView;->createSingleAddressAdapter(Lcom/android/ex/chips/RecipientChip;)Landroid/widget/ListAdapter;

    move-result-object v3

    invoke-virtual {p2, v3}, Landroid/widget/ListPopupWindow;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 1960
    new-instance v3, Lcom/android/ex/chips/RecipientEditTextView$7;

    invoke-direct {v3, p0, p1, p2}, Lcom/android/ex/chips/RecipientEditTextView$7;-><init>(Lcom/android/ex/chips/RecipientEditTextView;Lcom/android/ex/chips/RecipientChip;Landroid/widget/ListPopupWindow;)V

    invoke-virtual {p2, v3}, Landroid/widget/ListPopupWindow;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 1967
    invoke-virtual {p2}, Landroid/widget/ListPopupWindow;->show()V

    .line 1968
    invoke-virtual {p2}, Landroid/widget/ListPopupWindow;->getListView()Landroid/widget/ListView;

    move-result-object v2

    .line 1969
    .local v2, "listView":Landroid/widget/ListView;
    invoke-virtual {v2, v5}, Landroid/widget/ListView;->setChoiceMode(I)V

    .line 1970
    const/4 v3, 0x0

    invoke-virtual {v2, v3, v5}, Landroid/widget/ListView;->setItemChecked(IZ)V

    .line 1971
    return-void
.end method

.method private showAlternates(Lcom/android/ex/chips/RecipientChip;Landroid/widget/ListPopupWindow;ILandroid/content/Context;)V
    .locals 8
    .param p1, "currentChip"    # Lcom/android/ex/chips/RecipientChip;
    .param p2, "alternatesPopup"    # Landroid/widget/ListPopupWindow;
    .param p3, "width"    # I
    .param p4, "context"    # Landroid/content/Context;

    .prologue
    const/4 v7, 0x1

    const/4 v6, -0x1

    .line 1393
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getLayout()Landroid/text/Layout;

    move-result-object v3

    invoke-direct {p0, p1}, Lcom/android/ex/chips/RecipientEditTextView;->getChipStart(Lcom/android/ex/chips/RecipientChip;)I

    move-result v4

    invoke-virtual {v3, v4}, Landroid/text/Layout;->getLineForOffset(I)I

    move-result v1

    .line 1395
    .local v1, "line":I
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getLineCount()I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    if-ne v1, v3, :cond_1

    .line 1396
    const/4 v0, 0x0

    .line 1403
    .local v0, "bottom":I
    :goto_0
    invoke-virtual {p2, p3}, Landroid/widget/ListPopupWindow;->setWidth(I)V

    .line 1404
    invoke-virtual {p2, p0}, Landroid/widget/ListPopupWindow;->setAnchorView(Landroid/view/View;)V

    .line 1405
    invoke-virtual {p2, v0}, Landroid/widget/ListPopupWindow;->setVerticalOffset(I)V

    .line 1406
    invoke-direct {p0, p1}, Lcom/android/ex/chips/RecipientEditTextView;->createAlternatesAdapter(Lcom/android/ex/chips/RecipientChip;)Landroid/widget/ListAdapter;

    move-result-object v3

    invoke-virtual {p2, v3}, Landroid/widget/ListPopupWindow;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 1407
    iget-object v3, p0, Lcom/android/ex/chips/RecipientEditTextView;->mAlternatesListener:Landroid/widget/AdapterView$OnItemClickListener;

    invoke-virtual {p2, v3}, Landroid/widget/ListPopupWindow;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 1409
    iput v6, p0, Lcom/android/ex/chips/RecipientEditTextView;->mCheckedItem:I

    .line 1410
    invoke-virtual {p2}, Landroid/widget/ListPopupWindow;->show()V

    .line 1411
    invoke-virtual {p2}, Landroid/widget/ListPopupWindow;->getListView()Landroid/widget/ListView;

    move-result-object v2

    .line 1412
    .local v2, "listView":Landroid/widget/ListView;
    invoke-virtual {v2, v7}, Landroid/widget/ListView;->setChoiceMode(I)V

    .line 1417
    iget v3, p0, Lcom/android/ex/chips/RecipientEditTextView;->mCheckedItem:I

    if-eq v3, v6, :cond_0

    .line 1418
    iget v3, p0, Lcom/android/ex/chips/RecipientEditTextView;->mCheckedItem:I

    invoke-virtual {v2, v3, v7}, Landroid/widget/ListView;->setItemChecked(IZ)V

    .line 1419
    iput v6, p0, Lcom/android/ex/chips/RecipientEditTextView;->mCheckedItem:I

    .line 1421
    :cond_0
    return-void

    .line 1398
    .end local v0    # "bottom":I
    .end local v2    # "listView":Landroid/widget/ListView;
    :cond_1
    iget v3, p0, Lcom/android/ex/chips/RecipientEditTextView;->mChipHeight:F

    const/high16 v4, 0x40000000    # 2.0f

    iget v5, p0, Lcom/android/ex/chips/RecipientEditTextView;->mLineSpacingExtra:F

    mul-float/2addr v4, v5

    add-float/2addr v3, v4

    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getLineCount()I

    move-result v4

    add-int/lit8 v4, v4, -0x1

    sub-int/2addr v4, v1

    invoke-static {v4}, Ljava/lang/Math;->abs(I)I

    move-result v4

    int-to-float v4, v4

    mul-float/2addr v3, v4

    float-to-int v3, v3

    neg-int v0, v3

    .restart local v0    # "bottom":I
    goto :goto_0
.end method

.method private showCopyDialog(Ljava/lang/String;)V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 2567
    iput-object p1, p0, Lcom/android/ex/chips/RecipientEditTextView;->mCopyAddress:Ljava/lang/String;

    .line 2568
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mCopyDialog:Landroid/app/Dialog;

    invoke-virtual {v0, p1}, Landroid/app/Dialog;->setTitle(Ljava/lang/CharSequence;)V

    .line 2569
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mCopyDialog:Landroid/app/Dialog;

    sget v1, Lcom/android/ex/chips/R$layout;->copy_chip_dialog_layout:I

    invoke-virtual {v0, v1}, Landroid/app/Dialog;->setContentView(I)V

    .line 2570
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mCopyDialog:Landroid/app/Dialog;

    invoke-virtual {v0, v2}, Landroid/app/Dialog;->setCancelable(Z)V

    .line 2571
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mCopyDialog:Landroid/app/Dialog;

    invoke-virtual {v0, v2}, Landroid/app/Dialog;->setCanceledOnTouchOutside(Z)V

    .line 2572
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mCopyDialog:Landroid/app/Dialog;

    const v1, 0x1020019

    invoke-virtual {v0, v1}, Landroid/app/Dialog;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 2573
    invoke-virtual {v0, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2575
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->isPhoneQuery()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 2576
    sget v1, Lcom/android/ex/chips/R$string;->copy_number:I

    .line 2580
    :goto_0
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 2581
    invoke-virtual {v0, v1}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 2582
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mCopyDialog:Landroid/app/Dialog;

    invoke-virtual {v0, p0}, Landroid/app/Dialog;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V

    .line 2583
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mCopyDialog:Landroid/app/Dialog;

    invoke-virtual {v0}, Landroid/app/Dialog;->show()V

    .line 2584
    return-void

    .line 2578
    :cond_0
    sget v1, Lcom/android/ex/chips/R$string;->copy_email:I

    goto :goto_0
.end method

.method private shrink()V
    .locals 6

    .prologue
    const-wide/16 v2, -0x1

    .line 398
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

    if-nez v0, :cond_0

    .line 445
    :goto_0
    return-void

    .line 401
    :cond_0
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mSelectedChip:Lcom/android/ex/chips/RecipientChip;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mSelectedChip:Lcom/android/ex/chips/RecipientChip;

    invoke-virtual {v0}, Lcom/android/ex/chips/RecipientChip;->getEntry()Lcom/android/ex/chips/RecipientEntry;

    move-result-object v0

    invoke-virtual {v0}, Lcom/android/ex/chips/RecipientEntry;->getContactId()J

    move-result-wide v0

    .line 402
    :goto_1
    iget-object v4, p0, Lcom/android/ex/chips/RecipientEditTextView;->mSelectedChip:Lcom/android/ex/chips/RecipientChip;

    if-eqz v4, :cond_2

    cmp-long v2, v0, v2

    if-eqz v2, :cond_2

    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->isPhoneQuery()Z

    move-result v2

    if-nez v2, :cond_2

    const-wide/16 v2, -0x2

    cmp-long v0, v0, v2

    if-eqz v0, :cond_2

    .line 404
    invoke-direct {p0}, Lcom/android/ex/chips/RecipientEditTextView;->clearSelectedChip()V

    .line 444
    :goto_2
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->createMoreChip()V

    goto :goto_0

    :cond_1
    move-wide v0, v2

    .line 401
    goto :goto_1

    .line 406
    :cond_2
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getWidth()I

    move-result v0

    if-gtz v0, :cond_3

    .line 412
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/android/ex/chips/RecipientEditTextView;->mDelayedShrink:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 413
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/android/ex/chips/RecipientEditTextView;->mDelayedShrink:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_0

    .line 418
    :cond_3
    iget v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mPendingChipsCount:I

    if-lez v0, :cond_5

    .line 419
    invoke-direct {p0}, Lcom/android/ex/chips/RecipientEditTextView;->postHandlePendingChips()V

    .line 442
    :cond_4
    :goto_3
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/android/ex/chips/RecipientEditTextView;->mAddTextWatcher:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_2

    .line 421
    :cond_5
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v1

    .line 422
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSelectionEnd()I

    move-result v2

    .line 423
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

    invoke-interface {v0, v1, v2}, Landroid/widget/MultiAutoCompleteTextView$Tokenizer;->findTokenStart(Ljava/lang/CharSequence;I)I

    move-result v3

    .line 424
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSpannable()Landroid/text/Spannable;

    move-result-object v0

    const-class v4, Lcom/android/ex/chips/RecipientChip;

    invoke-interface {v0, v3, v2, v4}, Landroid/text/Spannable;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/android/ex/chips/RecipientChip;

    .line 425
    if-eqz v0, :cond_6

    array-length v0, v0

    if-nez v0, :cond_4

    .line 426
    :cond_6
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v4

    .line 427
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

    invoke-interface {v0, v4, v3}, Landroid/widget/MultiAutoCompleteTextView$Tokenizer;->findTokenEnd(Ljava/lang/CharSequence;I)I

    move-result v0

    .line 429
    invoke-interface {v4}, Landroid/text/Editable;->length()I

    move-result v5

    if-ge v0, v5, :cond_7

    invoke-interface {v4, v0}, Landroid/text/Editable;->charAt(I)C

    move-result v4

    const/16 v5, 0x2c

    if-ne v4, v5, :cond_7

    .line 430
    add-int/lit8 v0, v0, 0x1

    .line 434
    :cond_7
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSelectionEnd()I

    move-result v4

    .line 435
    if-eq v0, v4, :cond_8

    .line 436
    invoke-direct {p0, v3, v0}, Lcom/android/ex/chips/RecipientEditTextView;->handleEdit(II)V

    goto :goto_3

    .line 438
    :cond_8
    invoke-direct {p0, v3, v2, v1}, Lcom/android/ex/chips/RecipientEditTextView;->commitChip(IILandroid/text/Editable;)Z

    goto :goto_3
.end method

.method private startDrag(Lcom/android/ex/chips/RecipientChip;)V
    .locals 5
    .param p1, "currentChip"    # Lcom/android/ex/chips/RecipientChip;

    .prologue
    .line 2513
    invoke-virtual {p1}, Lcom/android/ex/chips/RecipientChip;->getEntry()Lcom/android/ex/chips/RecipientEntry;

    move-result-object v2

    invoke-virtual {v2}, Lcom/android/ex/chips/RecipientEntry;->getDestination()Ljava/lang/String;

    move-result-object v0

    .line 2514
    .local v0, "address":Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const/16 v3, 0x2c

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Landroid/content/ClipData;->newPlainText(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Landroid/content/ClipData;

    move-result-object v1

    .line 2517
    .local v1, "data":Landroid/content/ClipData;
    new-instance v2, Lcom/android/ex/chips/RecipientEditTextView$RecipientChipShadow;

    invoke-direct {v2, p0, p1}, Lcom/android/ex/chips/RecipientEditTextView$RecipientChipShadow;-><init>(Lcom/android/ex/chips/RecipientEditTextView;Lcom/android/ex/chips/RecipientChip;)V

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {p0, v1, v2, v3, v4}, Lcom/android/ex/chips/RecipientEditTextView;->startDrag(Landroid/content/ClipData;Landroid/view/View$DragShadowBuilder;Ljava/lang/Object;I)Z

    .line 2521
    invoke-virtual {p0, p1}, Lcom/android/ex/chips/RecipientEditTextView;->removeChip(Lcom/android/ex/chips/RecipientChip;)V

    .line 2522
    return-void
.end method

.method private submitItemAtPosition(I)V
    .locals 5

    .prologue
    .line 1583
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    invoke-interface {v0, p1}, Landroid/widget/ListAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/ex/chips/RecipientEntry;

    invoke-direct {p0, v0}, Lcom/android/ex/chips/RecipientEditTextView;->createValidatedEntry(Lcom/android/ex/chips/RecipientEntry;)Lcom/android/ex/chips/RecipientEntry;

    move-result-object v0

    .line 1585
    if-nez v0, :cond_0

    .line 1600
    :goto_0
    return-void

    .line 1588
    :cond_0
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->clearComposingText()V

    .line 1590
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSelectionEnd()I

    move-result v1

    .line 1591
    iget-object v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-interface {v2, v3, v1}, Landroid/widget/MultiAutoCompleteTextView$Tokenizer;->findTokenStart(Ljava/lang/CharSequence;I)I

    move-result v2

    .line 1593
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v3

    .line 1594
    const-string v4, ""

    invoke-static {v3, v2, v1, v4}, Landroid/text/method/QwertyKeyListener;->markAsReplaced(Landroid/text/Spannable;IILjava/lang/String;)V

    .line 1595
    const/4 v4, 0x0

    invoke-direct {p0, v0, v4}, Lcom/android/ex/chips/RecipientEditTextView;->createChip(Lcom/android/ex/chips/RecipientEntry;Z)Ljava/lang/CharSequence;

    move-result-object v0

    .line 1596
    if-eqz v0, :cond_1

    if-ltz v2, :cond_1

    if-ltz v1, :cond_1

    .line 1597
    invoke-interface {v3, v2, v1, v0}, Landroid/text/Editable;->replace(IILjava/lang/CharSequence;)Landroid/text/Editable;

    .line 1599
    :cond_1
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->sanitizeBetween()V

    goto :goto_0
.end method

.method private tokenizeAddress(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "destination"    # Ljava/lang/String;

    .prologue
    .line 1009
    invoke-static {p1}, Landroid/text/util/Rfc822Tokenizer;->tokenize(Ljava/lang/CharSequence;)[Landroid/text/util/Rfc822Token;

    move-result-object v0

    .line 1010
    .local v0, "tokens":[Landroid/text/util/Rfc822Token;
    if-eqz v0, :cond_0

    array-length v1, v0

    if-lez v1, :cond_0

    .line 1011
    const/4 v1, 0x0

    aget-object v1, v0, v1

    invoke-virtual {v1}, Landroid/text/util/Rfc822Token;->getAddress()Ljava/lang/String;

    move-result-object p1

    .line 1013
    .end local p1    # "destination":Ljava/lang/String;
    :cond_0
    return-object p1
.end method

.method private unselectChip(Lcom/android/ex/chips/RecipientChip;)V
    .locals 6

    .prologue
    const/4 v4, -0x1

    .line 1979
    invoke-direct {p0, p1}, Lcom/android/ex/chips/RecipientEditTextView;->getChipStart(Lcom/android/ex/chips/RecipientChip;)I

    move-result v0

    .line 1980
    invoke-direct {p0, p1}, Lcom/android/ex/chips/RecipientEditTextView;->getChipEnd(Lcom/android/ex/chips/RecipientChip;)I

    move-result v1

    .line 1981
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v2

    .line 1982
    const/4 v3, 0x0

    iput-object v3, p0, Lcom/android/ex/chips/RecipientEditTextView;->mSelectedChip:Lcom/android/ex/chips/RecipientChip;

    .line 1983
    if-eq v0, v4, :cond_0

    if-ne v1, v4, :cond_3

    .line 1984
    :cond_0
    const-string v0, "RecipientEditTextView"

    const-string v1, "The chip doesn\'t exist or may be a chip a user was editing"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 1985
    invoke-interface {v2}, Landroid/text/Editable;->length()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/android/ex/chips/RecipientEditTextView;->setSelection(I)V

    .line 1986
    invoke-direct {p0}, Lcom/android/ex/chips/RecipientEditTextView;->commitDefault()Z

    .line 2000
    :cond_1
    :goto_0
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/android/ex/chips/RecipientEditTextView;->setCursorVisible(Z)V

    .line 2001
    invoke-interface {v2}, Landroid/text/Editable;->length()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/android/ex/chips/RecipientEditTextView;->setSelection(I)V

    .line 2002
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mAlternatesPopup:Landroid/widget/ListPopupWindow;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mAlternatesPopup:Landroid/widget/ListPopupWindow;

    invoke-virtual {v0}, Landroid/widget/ListPopupWindow;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 2003
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mAlternatesPopup:Landroid/widget/ListPopupWindow;

    invoke-virtual {v0}, Landroid/widget/ListPopupWindow;->dismiss()V

    .line 2005
    :cond_2
    return-void

    .line 1988
    :cond_3
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSpannable()Landroid/text/Spannable;

    move-result-object v3

    invoke-interface {v3, p1}, Landroid/text/Spannable;->removeSpan(Ljava/lang/Object;)V

    .line 1989
    const-string v3, ""

    invoke-static {v2, v0, v1, v3}, Landroid/text/method/QwertyKeyListener;->markAsReplaced(Landroid/text/Spannable;IILjava/lang/String;)V

    .line 1990
    invoke-interface {v2, p1}, Landroid/text/Editable;->removeSpan(Ljava/lang/Object;)V

    .line 1992
    :try_start_0
    iget-boolean v3, p0, Lcom/android/ex/chips/RecipientEditTextView;->mNoChips:Z

    if-nez v3, :cond_1

    .line 1993
    invoke-virtual {p1}, Lcom/android/ex/chips/RecipientChip;->getEntry()Lcom/android/ex/chips/RecipientEntry;

    move-result-object v3

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-direct {p0, v3, v0, v4, v5}, Lcom/android/ex/chips/RecipientEditTextView;->constructChipSpan(Lcom/android/ex/chips/RecipientEntry;IZZ)Lcom/android/ex/chips/RecipientChip;

    move-result-object v3

    const/16 v4, 0x21

    invoke-interface {v2, v3, v0, v1, v4}, Landroid/text/Editable;->setSpan(Ljava/lang/Object;III)V
    :try_end_0
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 1996
    :catch_0
    move-exception v0

    .line 1997
    const-string v1, "RecipientEditTextView"

    invoke-virtual {v0}, Ljava/lang/NullPointerException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method


# virtual methods
.method public append(Ljava/lang/CharSequence;II)V
    .locals 6
    .param p1, "text"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "end"    # I

    .prologue
    const/16 v5, 0x2c

    .line 350
    iget-object v4, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTextWatcher:Landroid/text/TextWatcher;

    if-eqz v4, :cond_0

    .line 351
    iget-object v4, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTextWatcher:Landroid/text/TextWatcher;

    invoke-virtual {p0, v4}, Lcom/android/ex/chips/RecipientEditTextView;->removeTextChangedListener(Landroid/text/TextWatcher;)V

    .line 353
    :cond_0
    invoke-super {p0, p1, p2, p3}, Landroid/widget/MultiAutoCompleteTextView;->append(Ljava/lang/CharSequence;II)V

    .line 354
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_2

    invoke-static {p1}, Landroid/text/TextUtils;->getTrimmedLength(Ljava/lang/CharSequence;)I

    move-result v4

    if-lez v4, :cond_2

    .line 355
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 356
    .local v0, "displayString":Ljava/lang/String;
    invoke-virtual {v0, v5}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v3

    .line 360
    .local v3, "separatorPos":I
    const/4 v4, -0x1

    if-le v3, v4, :cond_1

    .line 361
    invoke-virtual {v0, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v2

    .line 362
    .local v2, "parseDisplayString":Ljava/lang/String;
    const/16 v4, 0x22

    invoke-virtual {v2, v4}, Ljava/lang/String;->indexOf(I)I

    move-result v1

    .line 363
    .local v1, "endQuotedTextPos":I
    if-le v1, v3, :cond_1

    .line 364
    invoke-virtual {v2, v5, v1}, Ljava/lang/String;->lastIndexOf(II)I

    move-result v3

    .line 368
    .end local v1    # "endQuotedTextPos":I
    .end local v2    # "parseDisplayString":Ljava/lang/String;
    :cond_1
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_2

    invoke-static {v0}, Landroid/text/TextUtils;->getTrimmedLength(Ljava/lang/CharSequence;)I

    move-result v4

    if-lez v4, :cond_2

    .line 370
    iget v4, p0, Lcom/android/ex/chips/RecipientEditTextView;->mPendingChipsCount:I

    add-int/lit8 v4, v4, 0x1

    iput v4, p0, Lcom/android/ex/chips/RecipientEditTextView;->mPendingChipsCount:I

    .line 371
    iget-object v4, p0, Lcom/android/ex/chips/RecipientEditTextView;->mPendingChips:Ljava/util/ArrayList;

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 376
    .end local v0    # "displayString":Ljava/lang/String;
    .end local v3    # "separatorPos":I
    :cond_2
    iget v4, p0, Lcom/android/ex/chips/RecipientEditTextView;->mPendingChipsCount:I

    if-lez v4, :cond_3

    .line 377
    invoke-direct {p0}, Lcom/android/ex/chips/RecipientEditTextView;->postHandlePendingChips()V

    .line 379
    :cond_3
    iget-object v4, p0, Lcom/android/ex/chips/RecipientEditTextView;->mHandler:Landroid/os/Handler;

    iget-object v5, p0, Lcom/android/ex/chips/RecipientEditTextView;->mAddTextWatcher:Ljava/lang/Runnable;

    invoke-virtual {v4, v5}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 380
    return-void
.end method

.method countTokens(Landroid/text/Editable;)I
    .locals 3
    .param p1, "text"    # Landroid/text/Editable;

    .prologue
    .line 1748
    const/4 v1, 0x0

    .line 1749
    .local v1, "tokenCount":I
    const/4 v0, 0x0

    .line 1750
    .local v0, "start":I
    :cond_0
    invoke-interface {p1}, Landroid/text/Editable;->length()I

    move-result v2

    if-ge v0, v2, :cond_1

    .line 1751
    iget-object v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

    invoke-interface {v2, p1, v0}, Landroid/widget/MultiAutoCompleteTextView$Tokenizer;->findTokenEnd(Ljava/lang/CharSequence;I)I

    move-result v2

    invoke-virtual {p0, v2}, Lcom/android/ex/chips/RecipientEditTextView;->movePastTerminators(I)I

    move-result v0

    .line 1752
    add-int/lit8 v1, v1, 0x1

    .line 1753
    invoke-interface {p1}, Landroid/text/Editable;->length()I

    move-result v2

    if-lt v0, v2, :cond_0

    .line 1757
    :cond_1
    return v1
.end method

.method createAddressText(Lcom/android/ex/chips/RecipientEntry;)Ljava/lang/String;
    .locals 5

    .prologue
    const/4 v1, 0x0

    .line 1496
    invoke-virtual {p1}, Lcom/android/ex/chips/RecipientEntry;->getDisplayName()Ljava/lang/String;

    move-result-object v0

    .line 1497
    invoke-virtual {p1}, Lcom/android/ex/chips/RecipientEntry;->getDestination()Ljava/lang/String;

    move-result-object v2

    .line 1498
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_0

    invoke-static {v0, v2}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_1

    :cond_0
    move-object v0, v1

    .line 1502
    :cond_1
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->isPhoneQuery()Z

    move-result v3

    if-eqz v3, :cond_3

    invoke-static {v2}, Lcom/android/ex/chips/RecipientEditTextView;->isPhoneNumber(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 1503
    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    .line 1516
    :goto_0
    const-string v1, ","

    invoke-virtual {v0, v1}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    .line 1517
    iget-object v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

    if-eqz v2, :cond_2

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_2

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    if-ge v1, v2, :cond_2

    iget-object v1, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

    invoke-interface {v1, v0}, Landroid/widget/MultiAutoCompleteTextView$Tokenizer;->terminateToken(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    :cond_2
    return-object v0

    .line 1505
    :cond_3
    if-eqz v2, :cond_4

    .line 1508
    invoke-static {v2}, Landroid/text/util/Rfc822Tokenizer;->tokenize(Ljava/lang/CharSequence;)[Landroid/text/util/Rfc822Token;

    move-result-object v3

    .line 1509
    if-eqz v3, :cond_4

    array-length v4, v3

    if-lez v4, :cond_4

    .line 1510
    const/4 v2, 0x0

    aget-object v2, v3, v2

    invoke-virtual {v2}, Landroid/text/util/Rfc822Token;->getAddress()Ljava/lang/String;

    move-result-object v2

    .line 1513
    :cond_4
    new-instance v3, Landroid/text/util/Rfc822Token;

    invoke-direct {v3, v0, v2, v1}, Landroid/text/util/Rfc822Token;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 1514
    invoke-virtual {v3}, Landroid/text/util/Rfc822Token;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method createChipDisplayText(Lcom/android/ex/chips/RecipientEntry;)Ljava/lang/String;
    .locals 5
    .param p1, "entry"    # Lcom/android/ex/chips/RecipientEntry;

    .prologue
    .line 1525
    invoke-virtual {p1}, Lcom/android/ex/chips/RecipientEntry;->getDisplayName()Ljava/lang/String;

    move-result-object v1

    .line 1526
    .local v1, "display":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/android/ex/chips/RecipientEntry;->getDestination()Ljava/lang/String;

    move-result-object v0

    .line 1527
    .local v0, "address":Ljava/lang/String;
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_0

    invoke-static {v1, v0}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 1528
    :cond_0
    const/4 v1, 0x0

    .line 1530
    :cond_1
    if-eqz v0, :cond_3

    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->isPhoneQuery()Z

    move-result v3

    if-eqz v3, :cond_2

    invoke-static {v0}, Lcom/android/ex/chips/RecipientEditTextView;->isPhoneNumber(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_3

    .line 1533
    :cond_2
    invoke-static {v0}, Landroid/text/util/Rfc822Tokenizer;->tokenize(Ljava/lang/CharSequence;)[Landroid/text/util/Rfc822Token;

    move-result-object v2

    .line 1534
    .local v2, "tokenized":[Landroid/text/util/Rfc822Token;
    if-eqz v2, :cond_3

    array-length v3, v2

    if-lez v3, :cond_3

    .line 1535
    const/4 v3, 0x0

    aget-object v3, v2, v3

    invoke-virtual {v3}, Landroid/text/util/Rfc822Token;->getAddress()Ljava/lang/String;

    move-result-object v0

    .line 1538
    .end local v2    # "tokenized":[Landroid/text/util/Rfc822Token;
    :cond_3
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_4

    .line 1543
    .end local v1    # "display":Ljava/lang/String;
    :goto_0
    return-object v1

    .line 1540
    .restart local v1    # "display":Ljava/lang/String;
    :cond_4
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_5

    move-object v1, v0

    .line 1541
    goto :goto_0

    .line 1543
    :cond_5
    new-instance v3, Landroid/text/util/Rfc822Token;

    const/4 v4, 0x0

    invoke-direct {v3, v1, v0, v4}, Landroid/text/util/Rfc822Token;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v3}, Landroid/text/util/Rfc822Token;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method createMoreChip()V
    .locals 14

    .prologue
    const/4 v2, 0x0

    .line 1767
    iget-boolean v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mNoChips:Z

    if-eqz v0, :cond_1

    .line 1768
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->createMoreChipPlainText()V

    .line 1821
    :cond_0
    :goto_0
    return-void

    .line 1772
    :cond_1
    iget-boolean v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mShouldShrink:Z

    if-eqz v0, :cond_0

    .line 1775
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSpannable()Landroid/text/Spannable;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-interface {v1}, Landroid/text/Editable;->length()I

    move-result v1

    const-class v3, Lcom/android/ex/chips/RecipientEditTextView$MoreImageSpan;

    invoke-interface {v0, v2, v1, v3}, Landroid/text/Spannable;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroid/text/style/ImageSpan;

    .line 1776
    array-length v1, v0

    if-lez v1, :cond_2

    .line 1777
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSpannable()Landroid/text/Spannable;

    move-result-object v1

    aget-object v0, v0, v2

    invoke-interface {v1, v0}, Landroid/text/Spannable;->removeSpan(Ljava/lang/Object;)V

    .line 1779
    :cond_2
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSortedRecipients()[Lcom/android/ex/chips/RecipientChip;

    move-result-object v4

    .line 1781
    if-eqz v4, :cond_3

    array-length v0, v4

    const/4 v1, 0x2

    if-gt v0, v1, :cond_4

    .line 1782
    :cond_3
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mMoreChip:Landroid/text/style/ImageSpan;

    goto :goto_0

    .line 1785
    :cond_4
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSpannable()Landroid/text/Spannable;

    move-result-object v5

    .line 1786
    array-length v6, v4

    .line 1787
    add-int/lit8 v7, v6, -0x2

    .line 1788
    invoke-direct {p0, v7}, Lcom/android/ex/chips/RecipientEditTextView;->createMoreSpan(I)Lcom/android/ex/chips/RecipientEditTextView$MoreImageSpan;

    move-result-object v8

    .line 1789
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mRemovedSpans:Ljava/util/ArrayList;

    .line 1792
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v9

    .line 1793
    sub-int v0, v6, v7

    move v1, v2

    move v3, v2

    :goto_1
    array-length v10, v4

    if-ge v0, v10, :cond_9

    .line 1794
    iget-object v10, p0, Lcom/android/ex/chips/RecipientEditTextView;->mRemovedSpans:Ljava/util/ArrayList;

    aget-object v11, v4, v0

    invoke-virtual {v10, v11}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1795
    sub-int v10, v6, v7

    if-ne v0, v10, :cond_5

    .line 1796
    aget-object v3, v4, v0

    invoke-interface {v5, v3}, Landroid/text/Spannable;->getSpanStart(Ljava/lang/Object;)I

    move-result v3

    .line 1798
    :cond_5
    array-length v10, v4

    add-int/lit8 v10, v10, -0x1

    if-ne v0, v10, :cond_6

    .line 1799
    aget-object v1, v4, v0

    invoke-interface {v5, v1}, Landroid/text/Spannable;->getSpanEnd(Ljava/lang/Object;)I

    move-result v1

    .line 1801
    :cond_6
    iget-object v10, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTemporaryRecipients:Ljava/util/ArrayList;

    if-eqz v10, :cond_7

    iget-object v10, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTemporaryRecipients:Ljava/util/ArrayList;

    aget-object v11, v4, v0

    invoke-virtual {v10, v11}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v10

    if-nez v10, :cond_8

    .line 1802
    :cond_7
    aget-object v10, v4, v0

    invoke-interface {v5, v10}, Landroid/text/Spannable;->getSpanStart(Ljava/lang/Object;)I

    move-result v10

    .line 1803
    aget-object v11, v4, v0

    invoke-interface {v5, v11}, Landroid/text/Spannable;->getSpanEnd(Ljava/lang/Object;)I

    move-result v11

    .line 1804
    aget-object v12, v4, v0

    invoke-virtual {v9}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v13, v10, v11}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v12, v10}, Lcom/android/ex/chips/RecipientChip;->setOriginalText(Ljava/lang/String;)V

    .line 1806
    :cond_8
    aget-object v10, v4, v0

    invoke-interface {v5, v10}, Landroid/text/Spannable;->removeSpan(Ljava/lang/Object;)V

    .line 1793
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 1808
    :cond_9
    invoke-interface {v9}, Landroid/text/Editable;->length()I

    move-result v0

    if-ge v1, v0, :cond_a

    .line 1809
    invoke-interface {v9}, Landroid/text/Editable;->length()I

    move-result v1

    .line 1811
    :cond_a
    invoke-static {v3, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    .line 1812
    invoke-static {v3, v1}, Ljava/lang/Math;->min(II)I

    move-result v1

    .line 1813
    new-instance v3, Landroid/text/SpannableString;

    invoke-interface {v9, v1, v0}, Landroid/text/Editable;->subSequence(II)Ljava/lang/CharSequence;

    move-result-object v4

    invoke-direct {v3, v4}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 1814
    invoke-virtual {v3}, Landroid/text/SpannableString;->length()I

    move-result v4

    const/16 v5, 0x21

    invoke-virtual {v3, v8, v2, v4, v5}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 1815
    invoke-interface {v9, v1, v0, v3}, Landroid/text/Editable;->replace(IILjava/lang/CharSequence;)Landroid/text/Editable;

    .line 1816
    iput-object v8, p0, Lcom/android/ex/chips/RecipientEditTextView;->mMoreChip:Landroid/text/style/ImageSpan;

    .line 1818
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->isPhoneQuery()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getLineCount()I

    move-result v0

    iget v1, p0, Lcom/android/ex/chips/RecipientEditTextView;->mMaxLines:I

    if-le v0, v1, :cond_0

    .line 1819
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getLineCount()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/android/ex/chips/RecipientEditTextView;->setMaxLines(I)V

    goto/16 :goto_0
.end method

.method createMoreChipPlainText()V
    .locals 10

    .prologue
    .line 1729
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v5

    .line 1730
    .local v5, "text":Landroid/text/Editable;
    const/4 v4, 0x0

    .line 1731
    .local v4, "start":I
    move v1, v4

    .line 1732
    .local v1, "end":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    const/4 v7, 0x2

    if-ge v2, v7, :cond_0

    .line 1733
    iget-object v7, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

    invoke-interface {v7, v5, v4}, Landroid/widget/MultiAutoCompleteTextView$Tokenizer;->findTokenEnd(Ljava/lang/CharSequence;I)I

    move-result v7

    invoke-virtual {p0, v7}, Lcom/android/ex/chips/RecipientEditTextView;->movePastTerminators(I)I

    move-result v1

    .line 1734
    move v4, v1

    .line 1732
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 1737
    :cond_0
    const/4 v4, 0x0

    .line 1738
    invoke-virtual {p0, v5}, Lcom/android/ex/chips/RecipientEditTextView;->countTokens(Landroid/text/Editable;)I

    move-result v6

    .line 1739
    .local v6, "tokenCount":I
    add-int/lit8 v7, v6, -0x2

    invoke-direct {p0, v7}, Lcom/android/ex/chips/RecipientEditTextView;->createMoreSpan(I)Lcom/android/ex/chips/RecipientEditTextView$MoreImageSpan;

    move-result-object v3

    .line 1740
    .local v3, "moreSpan":Lcom/android/ex/chips/RecipientEditTextView$MoreImageSpan;
    new-instance v0, Landroid/text/SpannableString;

    invoke-interface {v5}, Landroid/text/Editable;->length()I

    move-result v7

    invoke-interface {v5, v1, v7}, Landroid/text/Editable;->subSequence(II)Ljava/lang/CharSequence;

    move-result-object v7

    invoke-direct {v0, v7}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 1741
    .local v0, "chipText":Landroid/text/SpannableString;
    const/4 v7, 0x0

    invoke-virtual {v0}, Landroid/text/SpannableString;->length()I

    move-result v8

    const/16 v9, 0x21

    invoke-virtual {v0, v3, v7, v8, v9}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 1742
    invoke-interface {v5}, Landroid/text/Editable;->length()I

    move-result v7

    invoke-interface {v5, v1, v7, v0}, Landroid/text/Editable;->replace(IILjava/lang/CharSequence;)Landroid/text/Editable;

    .line 1743
    iput-object v3, p0, Lcom/android/ex/chips/RecipientEditTextView;->mMoreChip:Landroid/text/style/ImageSpan;

    .line 1744
    return-void
.end method

.method getChipBackground(Lcom/android/ex/chips/RecipientEntry;)Landroid/graphics/drawable/Drawable;
    .locals 2
    .param p1, "contact"    # Lcom/android/ex/chips/RecipientEntry;

    .prologue
    .line 595
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mValidator:Landroid/widget/AutoCompleteTextView$Validator;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mValidator:Landroid/widget/AutoCompleteTextView$Validator;

    invoke-virtual {p1}, Lcom/android/ex/chips/RecipientEntry;->getDestination()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Landroid/widget/AutoCompleteTextView$Validator;->isValid(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mChipBackground:Landroid/graphics/drawable/Drawable;

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mInvalidChipBackground:Landroid/graphics/drawable/Drawable;

    goto :goto_0
.end method

.method getLastChip()Lcom/android/ex/chips/RecipientChip;
    .locals 3

    .prologue
    .line 305
    const/4 v1, 0x0

    .line 306
    .local v1, "last":Lcom/android/ex/chips/RecipientChip;
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSortedRecipients()[Lcom/android/ex/chips/RecipientChip;

    move-result-object v0

    .line 307
    .local v0, "chips":[Lcom/android/ex/chips/RecipientChip;
    if-eqz v0, :cond_0

    array-length v2, v0

    if-lez v2, :cond_0

    .line 308
    array-length v2, v0

    add-int/lit8 v2, v2, -0x1

    aget-object v1, v0, v2

    .line 310
    :cond_0
    return-object v1
.end method

.method getMoreChip()Landroid/text/style/ImageSpan;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 1699
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSpannable()Landroid/text/Spannable;

    move-result-object v0

    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-interface {v1}, Landroid/text/Editable;->length()I

    move-result v1

    const-class v2, Lcom/android/ex/chips/RecipientEditTextView$MoreImageSpan;

    invoke-interface {v0, v3, v1, v2}, Landroid/text/Spannable;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/android/ex/chips/RecipientEditTextView$MoreImageSpan;

    .line 1701
    if-eqz v0, :cond_0

    array-length v1, v0

    if-lez v1, :cond_0

    aget-object v0, v0, v3

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method getSortedRecipients()[Lcom/android/ex/chips/RecipientChip;
    .locals 4

    .prologue
    .line 1652
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSpannable()Landroid/text/Spannable;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-interface {v2}, Landroid/text/Editable;->length()I

    move-result v2

    const-class v3, Lcom/android/ex/chips/RecipientChip;

    invoke-interface {v0, v1, v2, v3}, Landroid/text/Spannable;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/android/ex/chips/RecipientChip;

    .line 1654
    new-instance v1, Ljava/util/ArrayList;

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 1656
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSpannable()Landroid/text/Spannable;

    move-result-object v0

    .line 1657
    new-instance v2, Lcom/android/ex/chips/RecipientEditTextView$6;

    invoke-direct {v2, p0, v0}, Lcom/android/ex/chips/RecipientEditTextView$6;-><init>(Lcom/android/ex/chips/RecipientEditTextView;Landroid/text/Spannable;)V

    invoke-static {v1, v2}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 1672
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v0

    new-array v0, v0, [Lcom/android/ex/chips/RecipientChip;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/android/ex/chips/RecipientChip;

    return-object v0
.end method

.method getSpannable()Landroid/text/Spannable;
    .locals 1

    .prologue
    .line 1277
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v0

    return-object v0
.end method

.method getViewWidth()I
    .locals 1

    .prologue
    .line 845
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getWidth()I

    move-result v0

    return v0
.end method

.method handlePaste()Ljava/util/ArrayList;
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/android/ex/chips/RecipientChip;",
            ">;"
        }
    .end annotation

    .prologue
    .line 2263
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    .line 2264
    .local v7, "text":Ljava/lang/String;
    iget-object v10, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSelectionEnd()I

    move-result v11

    invoke-interface {v10, v7, v11}, Landroid/widget/MultiAutoCompleteTextView$Tokenizer;->findTokenStart(Ljava/lang/CharSequence;I)I

    move-result v5

    .line 2265
    .local v5, "originalTokenStart":I
    invoke-virtual {v7, v5}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v4

    .line 2266
    .local v4, "lastAddress":Ljava/lang/String;
    move v9, v5

    .line 2267
    .local v9, "tokenStart":I
    move v6, v9

    .line 2268
    .local v6, "prevTokenStart":I
    const/4 v3, 0x0

    .line 2269
    .local v3, "findChip":Lcom/android/ex/chips/RecipientChip;
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 2270
    .local v0, "created":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/android/ex/chips/RecipientChip;>;"
    if-eqz v9, :cond_2

    .line 2272
    :goto_0
    if-eqz v9, :cond_0

    if-nez v3, :cond_0

    .line 2273
    move v6, v9

    .line 2274
    iget-object v10, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

    invoke-interface {v10, v7, v9}, Landroid/widget/MultiAutoCompleteTextView$Tokenizer;->findTokenStart(Ljava/lang/CharSequence;I)I

    move-result v9

    .line 2275
    invoke-direct {p0, v9}, Lcom/android/ex/chips/RecipientEditTextView;->findChip(I)Lcom/android/ex/chips/RecipientChip;

    move-result-object v3

    goto :goto_0

    .line 2277
    :cond_0
    if-eq v9, v5, :cond_2

    .line 2278
    if-eqz v3, :cond_1

    .line 2279
    move v9, v6

    .line 2283
    :cond_1
    :goto_1
    if-ge v9, v5, :cond_2

    .line 2284
    iget-object v10, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-interface {v10, v11, v9}, Landroid/widget/MultiAutoCompleteTextView$Tokenizer;->findTokenEnd(Ljava/lang/CharSequence;I)I

    move-result v10

    invoke-virtual {p0, v10}, Lcom/android/ex/chips/RecipientEditTextView;->movePastTerminators(I)I

    move-result v8

    .line 2286
    .local v8, "tokenEnd":I
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v10

    invoke-direct {p0, v9, v8, v10}, Lcom/android/ex/chips/RecipientEditTextView;->commitChip(IILandroid/text/Editable;)Z

    .line 2287
    invoke-direct {p0, v9}, Lcom/android/ex/chips/RecipientEditTextView;->findChip(I)Lcom/android/ex/chips/RecipientChip;

    move-result-object v1

    .line 2288
    .local v1, "createdChip":Lcom/android/ex/chips/RecipientChip;
    if-nez v1, :cond_4

    .line 2299
    .end local v1    # "createdChip":Lcom/android/ex/chips/RecipientChip;
    .end local v8    # "tokenEnd":I
    :cond_2
    invoke-virtual {p0, v4}, Lcom/android/ex/chips/RecipientEditTextView;->isCompletedToken(Ljava/lang/CharSequence;)Z

    move-result v10

    if-eqz v10, :cond_3

    .line 2300
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v2

    .line 2301
    .local v2, "editable":Landroid/text/Editable;
    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v10, v4, v5}, Ljava/lang/String;->indexOf(Ljava/lang/String;I)I

    move-result v9

    .line 2302
    invoke-interface {v2}, Landroid/text/Editable;->length()I

    move-result v10

    invoke-direct {p0, v9, v10, v2}, Lcom/android/ex/chips/RecipientEditTextView;->commitChip(IILandroid/text/Editable;)Z

    .line 2303
    invoke-direct {p0, v9}, Lcom/android/ex/chips/RecipientEditTextView;->findChip(I)Lcom/android/ex/chips/RecipientChip;

    move-result-object v10

    invoke-virtual {v0, v10}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2305
    .end local v2    # "editable":Landroid/text/Editable;
    :cond_3
    return-object v0

    .line 2292
    .restart local v1    # "createdChip":Lcom/android/ex/chips/RecipientChip;
    .restart local v8    # "tokenEnd":I
    :cond_4
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSpannable()Landroid/text/Spannable;

    move-result-object v10

    invoke-interface {v10, v1}, Landroid/text/Spannable;->getSpanEnd(Ljava/lang/Object;)I

    move-result v10

    add-int/lit8 v9, v10, 0x1

    .line 2293
    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1
.end method

.method handlePendingChips()V
    .locals 14

    .prologue
    const/16 v8, 0x32

    const/4 v13, 0x2

    .line 779
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getViewWidth()I

    move-result v5

    if-gtz v5, :cond_1

    .line 841
    :cond_0
    :goto_0
    return-void

    .line 785
    :cond_1
    iget v5, p0, Lcom/android/ex/chips/RecipientEditTextView;->mPendingChipsCount:I

    if-lez v5, :cond_0

    .line 789
    iget-object v6, p0, Lcom/android/ex/chips/RecipientEditTextView;->mPendingChips:Ljava/util/ArrayList;

    monitor-enter v6

    .line 790
    :try_start_0
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v1

    .line 792
    .local v1, "editable":Landroid/text/Editable;
    iget v5, p0, Lcom/android/ex/chips/RecipientEditTextView;->mPendingChipsCount:I

    if-gt v5, v8, :cond_6

    .line 793
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    iget-object v5, p0, Lcom/android/ex/chips/RecipientEditTextView;->mPendingChips:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v5

    if-ge v2, v5, :cond_4

    .line 794
    iget-object v5, p0, Lcom/android/ex/chips/RecipientEditTextView;->mPendingChips:Ljava/util/ArrayList;

    invoke-virtual {v5, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 795
    .local v0, "current":Ljava/lang/String;
    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v4

    .line 796
    .local v4, "tokenStart":I
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v5

    add-int v3, v4, v5

    .line 797
    .local v3, "tokenEnd":I
    if-ltz v4, :cond_3

    .line 800
    invoke-interface {v1}, Landroid/text/Editable;->length()I

    move-result v5

    add-int/lit8 v5, v5, -0x2

    if-ge v3, v5, :cond_2

    invoke-interface {v1, v3}, Landroid/text/Editable;->charAt(I)C

    move-result v5

    const/16 v7, 0x2c

    if-ne v5, v7, :cond_2

    .line 802
    add-int/lit8 v3, v3, 0x1

    .line 804
    :cond_2
    invoke-direct {p0, v4, v3, v1}, Lcom/android/ex/chips/RecipientEditTextView;->createReplacementChip(IILandroid/text/Editable;)V

    .line 806
    :cond_3
    iget v5, p0, Lcom/android/ex/chips/RecipientEditTextView;->mPendingChipsCount:I

    add-int/lit8 v5, v5, -0x1

    iput v5, p0, Lcom/android/ex/chips/RecipientEditTextView;->mPendingChipsCount:I

    .line 793
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 808
    .end local v0    # "current":Ljava/lang/String;
    .end local v3    # "tokenEnd":I
    .end local v4    # "tokenStart":I
    :cond_4
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->sanitizeEnd()V

    .line 813
    .end local v2    # "i":I
    :goto_2
    iget-object v5, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTemporaryRecipients:Ljava/util/ArrayList;

    if-eqz v5, :cond_9

    iget-object v5, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTemporaryRecipients:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v5

    if-lez v5, :cond_9

    iget-object v5, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTemporaryRecipients:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v5

    if-gt v5, v8, :cond_9

    .line 815
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->hasFocus()Z

    move-result v5

    if-nez v5, :cond_5

    iget-object v5, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTemporaryRecipients:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v5

    if-ge v5, v13, :cond_7

    .line 816
    :cond_5
    new-instance v5, Lcom/android/ex/chips/RecipientEditTextView$RecipientReplacementTask;

    const/4 v7, 0x0

    invoke-direct {v5, p0, v7}, Lcom/android/ex/chips/RecipientEditTextView$RecipientReplacementTask;-><init>(Lcom/android/ex/chips/RecipientEditTextView;Lcom/android/ex/chips/RecipientEditTextView$1;)V

    const/4 v7, 0x0

    new-array v7, v7, [Ljava/lang/Void;

    invoke-virtual {v5, v7}, Lcom/android/ex/chips/RecipientEditTextView$RecipientReplacementTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 817
    const/4 v5, 0x0

    iput-object v5, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTemporaryRecipients:Ljava/util/ArrayList;

    .line 838
    :goto_3
    const/4 v5, 0x0

    iput v5, p0, Lcom/android/ex/chips/RecipientEditTextView;->mPendingChipsCount:I

    .line 839
    iget-object v5, p0, Lcom/android/ex/chips/RecipientEditTextView;->mPendingChips:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->clear()V

    .line 840
    monitor-exit v6

    goto/16 :goto_0

    .end local v1    # "editable":Landroid/text/Editable;
    :catchall_0
    move-exception v5

    monitor-exit v6
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v5

    .line 810
    .restart local v1    # "editable":Landroid/text/Editable;
    :cond_6
    const/4 v5, 0x1

    :try_start_1
    iput-boolean v5, p0, Lcom/android/ex/chips/RecipientEditTextView;->mNoChips:Z

    goto :goto_2

    .line 820
    :cond_7
    new-instance v5, Lcom/android/ex/chips/RecipientEditTextView$IndividualReplacementTask;

    const/4 v7, 0x0

    invoke-direct {v5, p0, v7}, Lcom/android/ex/chips/RecipientEditTextView$IndividualReplacementTask;-><init>(Lcom/android/ex/chips/RecipientEditTextView;Lcom/android/ex/chips/RecipientEditTextView$1;)V

    iput-object v5, p0, Lcom/android/ex/chips/RecipientEditTextView;->mIndividualReplacements:Lcom/android/ex/chips/RecipientEditTextView$IndividualReplacementTask;

    .line 821
    iget-object v5, p0, Lcom/android/ex/chips/RecipientEditTextView;->mIndividualReplacements:Lcom/android/ex/chips/RecipientEditTextView$IndividualReplacementTask;

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    new-instance v9, Ljava/util/ArrayList;

    iget-object v10, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTemporaryRecipients:Ljava/util/ArrayList;

    const/4 v11, 0x0

    const/4 v12, 0x2

    invoke-virtual {v10, v11, v12}, Ljava/util/ArrayList;->subList(II)Ljava/util/List;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    aput-object v9, v7, v8

    invoke-virtual {v5, v7}, Lcom/android/ex/chips/RecipientEditTextView$IndividualReplacementTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 823
    iget-object v5, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTemporaryRecipients:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v5

    if-le v5, v13, :cond_8

    .line 824
    new-instance v5, Ljava/util/ArrayList;

    iget-object v7, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTemporaryRecipients:Ljava/util/ArrayList;

    const/4 v8, 0x2

    iget-object v9, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTemporaryRecipients:Ljava/util/ArrayList;

    invoke-virtual {v9}, Ljava/util/ArrayList;->size()I

    move-result v9

    invoke-virtual {v7, v8, v9}, Ljava/util/ArrayList;->subList(II)Ljava/util/List;

    move-result-object v7

    invoke-direct {v5, v7}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v5, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTemporaryRecipients:Ljava/util/ArrayList;

    .line 830
    :goto_4
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->createMoreChip()V

    goto :goto_3

    .line 828
    :cond_8
    const/4 v5, 0x0

    iput-object v5, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTemporaryRecipients:Ljava/util/ArrayList;

    goto :goto_4

    .line 835
    :cond_9
    const/4 v5, 0x0

    iput-object v5, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTemporaryRecipients:Ljava/util/ArrayList;

    .line 836
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->createMoreChip()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_3
.end method

.method isCompletedToken(Ljava/lang/CharSequence;)Z
    .locals 6
    .param p1, "text"    # Ljava/lang/CharSequence;

    .prologue
    const/4 v4, 0x0

    .line 1313
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 1324
    :cond_0
    :goto_0
    return v4

    .line 1317
    :cond_1
    invoke-interface {p1}, Ljava/lang/CharSequence;->length()I

    move-result v1

    .line 1318
    .local v1, "end":I
    iget-object v5, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

    invoke-interface {v5, p1, v1}, Landroid/widget/MultiAutoCompleteTextView$Tokenizer;->findTokenStart(Ljava/lang/CharSequence;I)I

    move-result v2

    .line 1319
    .local v2, "start":I
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5, v2, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    .line 1320
    .local v3, "token":Ljava/lang/String;
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 1321
    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v5

    add-int/lit8 v5, v5, -0x1

    invoke-virtual {v3, v5}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 1322
    .local v0, "atEnd":C
    const/16 v5, 0x2c

    if-eq v0, v5, :cond_2

    const/16 v5, 0x3b

    if-ne v0, v5, :cond_0

    :cond_2
    const/4 v4, 0x1

    goto :goto_0
.end method

.method protected isPhoneQuery()Z
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 2618
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/android/ex/chips/BaseRecipientAdapter;

    invoke-virtual {v0}, Lcom/android/ex/chips/BaseRecipientAdapter;->getQueryType()I

    move-result v0

    if-ne v0, v1, :cond_0

    move v0, v1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method movePastTerminators(I)I
    .locals 4
    .param p1, "tokenEnd"    # I

    .prologue
    .line 2310
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->length()I

    move-result v2

    if-lt p1, v2, :cond_0

    move v1, p1

    .line 2322
    .end local p1    # "tokenEnd":I
    .local v1, "tokenEnd":I
    :goto_0
    return v1

    .line 2313
    .end local v1    # "tokenEnd":I
    .restart local p1    # "tokenEnd":I
    :cond_0
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 2314
    .local v0, "atEnd":C
    const/16 v2, 0x2c

    if-eq v0, v2, :cond_1

    const/16 v2, 0x3b

    if-ne v0, v2, :cond_2

    .line 2315
    :cond_1
    add-int/lit8 p1, p1, 0x1

    .line 2319
    :cond_2
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->length()I

    move-result v2

    if-ge p1, v2, :cond_3

    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/String;->charAt(I)C

    move-result v2

    const/16 v3, 0x20

    if-ne v2, v3, :cond_3

    .line 2320
    add-int/lit8 p1, p1, 0x1

    :cond_3
    move v1, p1

    .line 2322
    .end local p1    # "tokenEnd":I
    .restart local v1    # "tokenEnd":I
    goto :goto_0
.end method

.method public onActionItemClicked(Landroid/view/ActionMode;Landroid/view/MenuItem;)Z
    .locals 1
    .param p1, "mode"    # Landroid/view/ActionMode;
    .param p2, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 1677
    const/4 v0, 0x0

    return v0
.end method

.method public onCheckedItemChanged(I)V
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 1435
    iget-object v1, p0, Lcom/android/ex/chips/RecipientEditTextView;->mAlternatesPopup:Landroid/widget/ListPopupWindow;

    invoke-virtual {v1}, Landroid/widget/ListPopupWindow;->getListView()Landroid/widget/ListView;

    move-result-object v0

    .line 1436
    .local v0, "listView":Landroid/widget/ListView;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/widget/ListView;->getCheckedItemCount()I

    move-result v1

    if-nez v1, :cond_0

    .line 1437
    const/4 v1, 0x1

    invoke-virtual {v0, p1, v1}, Landroid/widget/ListView;->setItemChecked(IZ)V

    .line 1439
    :cond_0
    iput p1, p0, Lcom/android/ex/chips/RecipientEditTextView;->mCheckedItem:I

    .line 1440
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 2611
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "clipboard"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/ClipboardManager;

    .line 2613
    const-string v1, ""

    iget-object v2, p0, Lcom/android/ex/chips/RecipientEditTextView;->mCopyAddress:Ljava/lang/String;

    invoke-static {v1, v2}, Landroid/content/ClipData;->newPlainText(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Landroid/content/ClipData;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/ClipboardManager;->setPrimaryClip(Landroid/content/ClipData;)V

    .line 2614
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mCopyDialog:Landroid/app/Dialog;

    invoke-virtual {v0}, Landroid/app/Dialog;->dismiss()V

    .line 2615
    return-void
.end method

.method public onClick(Lcom/android/ex/chips/RecipientChip;IFF)V
    .locals 1
    .param p1, "chip"    # Lcom/android/ex/chips/RecipientChip;
    .param p2, "offset"    # I
    .param p3, "x"    # F
    .param p4, "y"    # F

    .prologue
    .line 2094
    invoke-virtual {p1}, Lcom/android/ex/chips/RecipientChip;->isSelected()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2095
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/android/ex/chips/RecipientEditTextView;->isInDelete(Lcom/android/ex/chips/RecipientChip;IFF)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 2096
    invoke-virtual {p0, p1}, Lcom/android/ex/chips/RecipientEditTextView;->removeChip(Lcom/android/ex/chips/RecipientChip;)V

    .line 2101
    :cond_0
    :goto_0
    return-void

    .line 2098
    :cond_1
    invoke-direct {p0}, Lcom/android/ex/chips/RecipientEditTextView;->clearSelectedChip()V

    goto :goto_0
.end method

.method public onCreateActionMode(Landroid/view/ActionMode;Landroid/view/Menu;)Z
    .locals 1
    .param p1, "mode"    # Landroid/view/ActionMode;
    .param p2, "menu"    # Landroid/view/Menu;

    .prologue
    .line 1694
    const/4 v0, 0x0

    return v0
.end method

.method public onCreateInputConnection(Landroid/view/inputmethod/EditorInfo;)Landroid/view/inputmethod/InputConnection;
    .locals 4
    .param p1, "outAttrs"    # Landroid/view/inputmethod/EditorInfo;

    .prologue
    .line 289
    invoke-super {p0, p1}, Landroid/widget/MultiAutoCompleteTextView;->onCreateInputConnection(Landroid/view/inputmethod/EditorInfo;)Landroid/view/inputmethod/InputConnection;

    move-result-object v0

    .line 290
    .local v0, "connection":Landroid/view/inputmethod/InputConnection;
    iget v2, p1, Landroid/view/inputmethod/EditorInfo;->imeOptions:I

    and-int/lit16 v1, v2, 0xff

    .line 291
    .local v1, "imeActions":I
    and-int/lit8 v2, v1, 0x6

    if-eqz v2, :cond_0

    .line 293
    iget v2, p1, Landroid/view/inputmethod/EditorInfo;->imeOptions:I

    xor-int/2addr v2, v1

    iput v2, p1, Landroid/view/inputmethod/EditorInfo;->imeOptions:I

    .line 295
    iget v2, p1, Landroid/view/inputmethod/EditorInfo;->imeOptions:I

    or-int/lit8 v2, v2, 0x6

    iput v2, p1, Landroid/view/inputmethod/EditorInfo;->imeOptions:I

    .line 297
    :cond_0
    iget v2, p1, Landroid/view/inputmethod/EditorInfo;->imeOptions:I

    const/high16 v3, 0x40000000    # 2.0f

    and-int/2addr v2, v3

    if-eqz v2, :cond_1

    .line 298
    iget v2, p1, Landroid/view/inputmethod/EditorInfo;->imeOptions:I

    const v3, -0x40000001    # -1.9999999f

    and-int/2addr v2, v3

    iput v2, p1, Landroid/view/inputmethod/EditorInfo;->imeOptions:I

    .line 300
    :cond_1
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getContext()Landroid/content/Context;

    move-result-object v2

    sget v3, Lcom/android/ex/chips/R$string;->done:I

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p1, Landroid/view/inputmethod/EditorInfo;->actionLabel:Ljava/lang/CharSequence;

    .line 301
    return-object v0
.end method

.method public onDestroyActionMode(Landroid/view/ActionMode;)V
    .locals 0
    .param p1, "mode"    # Landroid/view/ActionMode;

    .prologue
    .line 1682
    return-void
.end method

.method public onDismiss(Landroid/content/DialogInterface;)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 2605
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mCopyAddress:Ljava/lang/String;

    .line 2606
    return-void
.end method

.method public onDown(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "e"    # Landroid/view/MotionEvent;

    .prologue
    .line 2473
    const/4 v0, 0x0

    return v0
.end method

.method public onDragEvent(Landroid/view/DragEvent;)Z
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 2529
    invoke-virtual {p1}, Landroid/view/DragEvent;->getAction()I

    move-result v1

    packed-switch v1, :pswitch_data_0

    .line 2540
    :pswitch_0
    const/4 v0, 0x0

    :goto_0
    return v0

    .line 2532
    :pswitch_1
    invoke-virtual {p1}, Landroid/view/DragEvent;->getClipDescription()Landroid/content/ClipDescription;

    move-result-object v0

    const-string v1, "text/plain"

    invoke-virtual {v0, v1}, Landroid/content/ClipDescription;->hasMimeType(Ljava/lang/String;)Z

    move-result v0

    goto :goto_0

    .line 2534
    :pswitch_2
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->requestFocus()Z

    goto :goto_0

    .line 2537
    :pswitch_3
    invoke-virtual {p1}, Landroid/view/DragEvent;->getClipData()Landroid/content/ClipData;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/android/ex/chips/RecipientEditTextView;->handlePasteClip(Landroid/content/ClipData;)V

    goto :goto_0

    .line 2529
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
        :pswitch_3
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method public onEditorAction(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z
    .locals 2
    .param p1, "view"    # Landroid/widget/TextView;
    .param p2, "action"    # I
    .param p3, "keyEvent"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v0, 0x1

    .line 273
    const/4 v1, 0x6

    if-ne p2, v1, :cond_3

    .line 274
    invoke-direct {p0}, Lcom/android/ex/chips/RecipientEditTextView;->commitDefault()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 284
    :cond_0
    :goto_0
    return v0

    .line 277
    :cond_1
    iget-object v1, p0, Lcom/android/ex/chips/RecipientEditTextView;->mSelectedChip:Lcom/android/ex/chips/RecipientChip;

    if-eqz v1, :cond_2

    .line 278
    invoke-direct {p0}, Lcom/android/ex/chips/RecipientEditTextView;->clearSelectedChip()V

    goto :goto_0

    .line 280
    :cond_2
    invoke-direct {p0}, Lcom/android/ex/chips/RecipientEditTextView;->focusNext()Z

    move-result v1

    if-nez v1, :cond_0

    .line 284
    :cond_3
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onFling(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z
    .locals 1
    .param p1, "e1"    # Landroid/view/MotionEvent;
    .param p2, "e2"    # Landroid/view/MotionEvent;
    .param p3, "velocityX"    # F
    .param p4, "velocityY"    # F

    .prologue
    .line 2479
    const/4 v0, 0x0

    return v0
.end method

.method public onFocusChanged(ZILandroid/graphics/Rect;)V
    .locals 0
    .param p1, "hasFocus"    # Z
    .param p2, "direction"    # I
    .param p3, "previous"    # Landroid/graphics/Rect;

    .prologue
    .line 384
    invoke-super {p0, p1, p2, p3}, Landroid/widget/MultiAutoCompleteTextView;->onFocusChanged(ZILandroid/graphics/Rect;)V

    .line 385
    if-nez p1, :cond_0

    .line 386
    invoke-direct {p0}, Lcom/android/ex/chips/RecipientEditTextView;->shrink()V

    .line 390
    :goto_0
    return-void

    .line 388
    :cond_0
    invoke-direct {p0}, Lcom/android/ex/chips/RecipientEditTextView;->expand()V

    goto :goto_0
.end method

.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 0
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 1579
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    invoke-direct {p0, p3}, Lcom/android/ex/chips/RecipientEditTextView;->submitItemAtPosition(I)V

    .line 1580
    return-void
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 1261
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mSelectedChip:Lcom/android/ex/chips/RecipientChip;

    if-eqz v0, :cond_1

    const/16 v0, 0x43

    if-ne p1, v0, :cond_1

    .line 1262
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mAlternatesPopup:Landroid/widget/ListPopupWindow;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mAlternatesPopup:Landroid/widget/ListPopupWindow;

    invoke-virtual {v0}, Landroid/widget/ListPopupWindow;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1263
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mAlternatesPopup:Landroid/widget/ListPopupWindow;

    invoke-virtual {v0}, Landroid/widget/ListPopupWindow;->dismiss()V

    .line 1265
    :cond_0
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mSelectedChip:Lcom/android/ex/chips/RecipientChip;

    invoke-virtual {p0, v0}, Lcom/android/ex/chips/RecipientEditTextView;->removeChip(Lcom/android/ex/chips/RecipientChip;)V

    .line 1268
    :cond_1
    const/16 v0, 0x42

    if-ne p1, v0, :cond_2

    invoke-virtual {p2}, Landroid/view/KeyEvent;->hasNoModifiers()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 1269
    const/4 v0, 0x1

    .line 1272
    :goto_0
    return v0

    :cond_2
    invoke-super {p0, p1, p2}, Landroid/widget/MultiAutoCompleteTextView;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method public onKeyPreIme(ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 1043
    const/4 v0, 0x4

    if-ne p1, v0, :cond_0

    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mSelectedChip:Lcom/android/ex/chips/RecipientChip;

    if-eqz v0, :cond_0

    .line 1044
    invoke-direct {p0}, Lcom/android/ex/chips/RecipientEditTextView;->clearSelectedChip()V

    .line 1045
    const/4 v0, 0x1

    .line 1047
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1, p2}, Landroid/widget/MultiAutoCompleteTextView;->onKeyPreIme(ILandroid/view/KeyEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method public onKeyUp(ILandroid/view/KeyEvent;)Z
    .locals 2
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v0, 0x1

    .line 1060
    sparse-switch p1, :sswitch_data_0

    .line 1088
    :cond_0
    invoke-super {p0, p1, p2}, Landroid/widget/MultiAutoCompleteTextView;->onKeyUp(ILandroid/view/KeyEvent;)Z

    move-result v0

    :cond_1
    :goto_0
    return v0

    .line 1063
    :sswitch_0
    invoke-virtual {p2}, Landroid/view/KeyEvent;->hasNoModifiers()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1064
    invoke-direct {p0}, Lcom/android/ex/chips/RecipientEditTextView;->commitDefault()Z

    move-result v1

    if-nez v1, :cond_1

    .line 1067
    iget-object v1, p0, Lcom/android/ex/chips/RecipientEditTextView;->mSelectedChip:Lcom/android/ex/chips/RecipientChip;

    if-eqz v1, :cond_2

    .line 1068
    invoke-direct {p0}, Lcom/android/ex/chips/RecipientEditTextView;->clearSelectedChip()V

    goto :goto_0

    .line 1070
    :cond_2
    invoke-direct {p0}, Lcom/android/ex/chips/RecipientEditTextView;->focusNext()Z

    move-result v1

    if-eqz v1, :cond_0

    goto :goto_0

    .line 1076
    :sswitch_1
    invoke-virtual {p2}, Landroid/view/KeyEvent;->hasNoModifiers()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1077
    iget-object v1, p0, Lcom/android/ex/chips/RecipientEditTextView;->mSelectedChip:Lcom/android/ex/chips/RecipientChip;

    if-eqz v1, :cond_3

    .line 1078
    invoke-direct {p0}, Lcom/android/ex/chips/RecipientEditTextView;->clearSelectedChip()V

    .line 1082
    :goto_1
    invoke-direct {p0}, Lcom/android/ex/chips/RecipientEditTextView;->focusNext()Z

    move-result v1

    if-eqz v1, :cond_0

    goto :goto_0

    .line 1080
    :cond_3
    invoke-direct {p0}, Lcom/android/ex/chips/RecipientEditTextView;->commitDefault()Z

    goto :goto_1

    .line 1060
    :sswitch_data_0
    .sparse-switch
        0x17 -> :sswitch_0
        0x3d -> :sswitch_1
        0x42 -> :sswitch_0
    .end sparse-switch
.end method

.method public onLongPress(Landroid/view/MotionEvent;)V
    .locals 5
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 2484
    iget-object v4, p0, Lcom/android/ex/chips/RecipientEditTextView;->mSelectedChip:Lcom/android/ex/chips/RecipientChip;

    if-eqz v4, :cond_1

    .line 2500
    :cond_0
    :goto_0
    return-void

    .line 2487
    :cond_1
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v2

    .line 2488
    .local v2, "x":F
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v3

    .line 2489
    .local v3, "y":F
    invoke-virtual {p0, v2, v3}, Lcom/android/ex/chips/RecipientEditTextView;->getOffsetForPosition(FF)I

    move-result v4

    invoke-direct {p0, v4}, Lcom/android/ex/chips/RecipientEditTextView;->putOffsetInRange(I)I

    move-result v1

    .line 2490
    .local v1, "offset":I
    invoke-direct {p0, v1}, Lcom/android/ex/chips/RecipientEditTextView;->findChip(I)Lcom/android/ex/chips/RecipientChip;

    move-result-object v0

    .line 2491
    .local v0, "currentChip":Lcom/android/ex/chips/RecipientChip;
    if-eqz v0, :cond_0

    .line 2492
    iget-boolean v4, p0, Lcom/android/ex/chips/RecipientEditTextView;->mDragEnabled:Z

    if-eqz v4, :cond_2

    .line 2494
    invoke-direct {p0, v0}, Lcom/android/ex/chips/RecipientEditTextView;->startDrag(Lcom/android/ex/chips/RecipientChip;)V

    goto :goto_0

    .line 2497
    :cond_2
    invoke-virtual {v0}, Lcom/android/ex/chips/RecipientChip;->getEntry()Lcom/android/ex/chips/RecipientEntry;

    move-result-object v4

    invoke-virtual {v4}, Lcom/android/ex/chips/RecipientEntry;->getDestination()Ljava/lang/String;

    move-result-object v4

    invoke-direct {p0, v4}, Lcom/android/ex/chips/RecipientEditTextView;->showCopyDialog(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onPrepareActionMode(Landroid/view/ActionMode;Landroid/view/Menu;)Z
    .locals 1
    .param p1, "mode"    # Landroid/view/ActionMode;
    .param p2, "menu"    # Landroid/view/Menu;

    .prologue
    .line 1686
    const/4 v0, 0x0

    return v0
.end method

.method public onRestoreInstanceState(Landroid/os/Parcelable;)V
    .locals 1
    .param p1, "state"    # Landroid/os/Parcelable;

    .prologue
    .line 327
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 328
    const/4 v0, 0x0

    invoke-super {p0, v0}, Landroid/widget/MultiAutoCompleteTextView;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    .line 332
    :goto_0
    return-void

    .line 330
    :cond_0
    invoke-super {p0, p1}, Landroid/widget/MultiAutoCompleteTextView;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    goto :goto_0
.end method

.method public onSaveInstanceState()Landroid/os/Parcelable;
    .locals 1

    .prologue
    .line 337
    invoke-direct {p0}, Lcom/android/ex/chips/RecipientEditTextView;->clearSelectedChip()V

    .line 338
    invoke-super {p0}, Landroid/widget/MultiAutoCompleteTextView;->onSaveInstanceState()Landroid/os/Parcelable;

    move-result-object v0

    return-object v0
.end method

.method public onScroll(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z
    .locals 1
    .param p1, "e1"    # Landroid/view/MotionEvent;
    .param p2, "e2"    # Landroid/view/MotionEvent;
    .param p3, "distanceX"    # F
    .param p4, "distanceY"    # F

    .prologue
    .line 2589
    const/4 v0, 0x0

    return v0
.end method

.method public onSelectionChanged(II)V
    .locals 3
    .param p1, "start"    # I
    .param p2, "end"    # I

    .prologue
    .line 317
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getLastChip()Lcom/android/ex/chips/RecipientChip;

    move-result-object v0

    .line 318
    .local v0, "last":Lcom/android/ex/chips/RecipientChip;
    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSpannable()Landroid/text/Spannable;

    move-result-object v1

    invoke-interface {v1, v0}, Landroid/text/Spannable;->getSpanEnd(Ljava/lang/Object;)I

    move-result v1

    if-ge p1, v1, :cond_0

    .line 320
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSpannable()Landroid/text/Spannable;

    move-result-object v1

    invoke-interface {v1, v0}, Landroid/text/Spannable;->getSpanEnd(Ljava/lang/Object;)I

    move-result v1

    add-int/lit8 v1, v1, 0x1

    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-interface {v2}, Landroid/text/Editable;->length()I

    move-result v2

    invoke-static {v1, v2}, Ljava/lang/Math;->min(II)I

    move-result v1

    invoke-virtual {p0, v1}, Lcom/android/ex/chips/RecipientEditTextView;->setSelection(I)V

    .line 322
    :cond_0
    invoke-super {p0, p1, p2}, Landroid/widget/MultiAutoCompleteTextView;->onSelectionChanged(II)V

    .line 323
    return-void
.end method

.method public onShowPress(Landroid/view/MotionEvent;)V
    .locals 0
    .param p1, "e"    # Landroid/view/MotionEvent;

    .prologue
    .line 2595
    return-void
.end method

.method public onSingleTapUp(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "e"    # Landroid/view/MotionEvent;

    .prologue
    .line 2600
    const/4 v0, 0x0

    return v0
.end method

.method public onSizeChanged(IIII)V
    .locals 2
    .param p1, "width"    # I
    .param p2, "height"    # I
    .param p3, "oldw"    # I
    .param p4, "oldh"    # I

    .prologue
    .line 736
    invoke-super {p0, p1, p2, p3, p4}, Landroid/widget/MultiAutoCompleteTextView;->onSizeChanged(IIII)V

    .line 737
    if-eqz p1, :cond_0

    if-eqz p2, :cond_0

    .line 738
    iget v1, p0, Lcom/android/ex/chips/RecipientEditTextView;->mPendingChipsCount:I

    if-lez v1, :cond_1

    .line 739
    invoke-direct {p0}, Lcom/android/ex/chips/RecipientEditTextView;->postHandlePendingChips()V

    .line 745
    :cond_0
    :goto_0
    iget-object v1, p0, Lcom/android/ex/chips/RecipientEditTextView;->mScrollView:Landroid/widget/ScrollView;

    if-nez v1, :cond_4

    iget-boolean v1, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTriedGettingScrollView:Z

    if-nez v1, :cond_4

    .line 746
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    .line 747
    .local v0, "parent":Landroid/view/ViewParent;
    :goto_1
    if-eqz v0, :cond_2

    instance-of v1, v0, Landroid/widget/ScrollView;

    if-nez v1, :cond_2

    .line 748
    invoke-interface {v0}, Landroid/view/ViewParent;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    goto :goto_1

    .line 741
    .end local v0    # "parent":Landroid/view/ViewParent;
    :cond_1
    invoke-direct {p0}, Lcom/android/ex/chips/RecipientEditTextView;->checkChipWidths()V

    goto :goto_0

    .line 750
    .restart local v0    # "parent":Landroid/view/ViewParent;
    :cond_2
    if-eqz v0, :cond_3

    .line 751
    check-cast v0, Landroid/widget/ScrollView;

    .end local v0    # "parent":Landroid/view/ViewParent;
    iput-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mScrollView:Landroid/widget/ScrollView;

    .line 753
    :cond_3
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTriedGettingScrollView:Z

    .line 755
    :cond_4
    return-void
.end method

.method public onTextContextMenuItem(I)Z
    .locals 2

    .prologue
    .line 2243
    const v0, 0x1020022

    if-ne p1, v0, :cond_0

    .line 2244
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "clipboard"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/ClipboardManager;

    .line 2246
    invoke-virtual {v0}, Landroid/content/ClipboardManager;->getPrimaryClip()Landroid/content/ClipData;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/android/ex/chips/RecipientEditTextView;->handlePasteClip(Landroid/content/ClipData;)V

    .line 2247
    const/4 v0, 0x1

    .line 2249
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Landroid/widget/MultiAutoCompleteTextView;->onTextContextMenuItem(I)Z

    move-result v0

    goto :goto_0
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 9
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v8, 0x1

    .line 1345
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->isFocused()Z

    move-result v7

    if-nez v7, :cond_1

    .line 1347
    invoke-super {p0, p1}, Landroid/widget/MultiAutoCompleteTextView;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v3

    .line 1382
    :cond_0
    :goto_0
    return v3

    .line 1349
    :cond_1
    invoke-super {p0, p1}, Landroid/widget/MultiAutoCompleteTextView;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v3

    .line 1350
    .local v3, "handled":Z
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    .line 1351
    .local v0, "action":I
    const/4 v1, 0x0

    .line 1352
    .local v1, "chipWasSelected":Z
    iget-object v7, p0, Lcom/android/ex/chips/RecipientEditTextView;->mSelectedChip:Lcom/android/ex/chips/RecipientChip;

    if-nez v7, :cond_2

    .line 1353
    iget-object v7, p0, Lcom/android/ex/chips/RecipientEditTextView;->mGestureDetector:Landroid/view/GestureDetector;

    invoke-virtual {v7, p1}, Landroid/view/GestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    .line 1355
    :cond_2
    iget-object v7, p0, Lcom/android/ex/chips/RecipientEditTextView;->mCopyAddress:Ljava/lang/String;

    if-nez v7, :cond_4

    if-ne v0, v8, :cond_4

    .line 1356
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v5

    .line 1357
    .local v5, "x":F
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v6

    .line 1358
    .local v6, "y":F
    invoke-virtual {p0, v5, v6}, Lcom/android/ex/chips/RecipientEditTextView;->getOffsetForPosition(FF)I

    move-result v7

    invoke-direct {p0, v7}, Lcom/android/ex/chips/RecipientEditTextView;->putOffsetInRange(I)I

    move-result v4

    .line 1359
    .local v4, "offset":I
    invoke-direct {p0, v4}, Lcom/android/ex/chips/RecipientEditTextView;->findChip(I)Lcom/android/ex/chips/RecipientChip;

    move-result-object v2

    .line 1360
    .local v2, "currentChip":Lcom/android/ex/chips/RecipientChip;
    if-eqz v2, :cond_7

    .line 1361
    if-ne v0, v8, :cond_3

    .line 1362
    iget-object v7, p0, Lcom/android/ex/chips/RecipientEditTextView;->mSelectedChip:Lcom/android/ex/chips/RecipientChip;

    if-eqz v7, :cond_5

    iget-object v7, p0, Lcom/android/ex/chips/RecipientEditTextView;->mSelectedChip:Lcom/android/ex/chips/RecipientChip;

    if-eq v7, v2, :cond_5

    .line 1363
    invoke-direct {p0}, Lcom/android/ex/chips/RecipientEditTextView;->clearSelectedChip()V

    .line 1364
    invoke-direct {p0, v2}, Lcom/android/ex/chips/RecipientEditTextView;->selectChip(Lcom/android/ex/chips/RecipientChip;)Lcom/android/ex/chips/RecipientChip;

    move-result-object v7

    iput-object v7, p0, Lcom/android/ex/chips/RecipientEditTextView;->mSelectedChip:Lcom/android/ex/chips/RecipientChip;

    .line 1373
    :cond_3
    :goto_1
    const/4 v1, 0x1

    .line 1374
    const/4 v3, 0x1

    .line 1379
    .end local v2    # "currentChip":Lcom/android/ex/chips/RecipientChip;
    .end local v4    # "offset":I
    .end local v5    # "x":F
    .end local v6    # "y":F
    :cond_4
    :goto_2
    if-ne v0, v8, :cond_0

    if-nez v1, :cond_0

    .line 1380
    invoke-direct {p0}, Lcom/android/ex/chips/RecipientEditTextView;->clearSelectedChip()V

    goto :goto_0

    .line 1365
    .restart local v2    # "currentChip":Lcom/android/ex/chips/RecipientChip;
    .restart local v4    # "offset":I
    .restart local v5    # "x":F
    .restart local v6    # "y":F
    :cond_5
    iget-object v7, p0, Lcom/android/ex/chips/RecipientEditTextView;->mSelectedChip:Lcom/android/ex/chips/RecipientChip;

    if-nez v7, :cond_6

    .line 1366
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-interface {v7}, Landroid/text/Editable;->length()I

    move-result v7

    invoke-virtual {p0, v7}, Lcom/android/ex/chips/RecipientEditTextView;->setSelection(I)V

    .line 1367
    invoke-direct {p0}, Lcom/android/ex/chips/RecipientEditTextView;->commitDefault()Z

    .line 1368
    invoke-direct {p0, v2}, Lcom/android/ex/chips/RecipientEditTextView;->selectChip(Lcom/android/ex/chips/RecipientChip;)Lcom/android/ex/chips/RecipientChip;

    move-result-object v7

    iput-object v7, p0, Lcom/android/ex/chips/RecipientEditTextView;->mSelectedChip:Lcom/android/ex/chips/RecipientChip;

    goto :goto_1

    .line 1370
    :cond_6
    iget-object v7, p0, Lcom/android/ex/chips/RecipientEditTextView;->mSelectedChip:Lcom/android/ex/chips/RecipientChip;

    invoke-virtual {p0, v7, v4, v5, v6}, Lcom/android/ex/chips/RecipientEditTextView;->onClick(Lcom/android/ex/chips/RecipientChip;IFF)V

    goto :goto_1

    .line 1375
    :cond_7
    iget-object v7, p0, Lcom/android/ex/chips/RecipientEditTextView;->mSelectedChip:Lcom/android/ex/chips/RecipientChip;

    if-eqz v7, :cond_4

    iget-object v7, p0, Lcom/android/ex/chips/RecipientEditTextView;->mSelectedChip:Lcom/android/ex/chips/RecipientChip;

    invoke-direct {p0, v7}, Lcom/android/ex/chips/RecipientEditTextView;->shouldShowEditableText(Lcom/android/ex/chips/RecipientChip;)Z

    move-result v7

    if-eqz v7, :cond_4

    .line 1376
    const/4 v1, 0x1

    goto :goto_2
.end method

.method protected performFiltering(Ljava/lang/CharSequence;I)V
    .locals 4

    .prologue
    .line 1297
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->enoughToFilter()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0, p1}, Lcom/android/ex/chips/RecipientEditTextView;->isCompletedToken(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1298
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSelectionEnd()I

    move-result v0

    .line 1299
    iget-object v1, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

    invoke-interface {v1, p1, v0}, Landroid/widget/MultiAutoCompleteTextView$Tokenizer;->findTokenStart(Ljava/lang/CharSequence;I)I

    move-result v1

    .line 1302
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSpannable()Landroid/text/Spannable;

    move-result-object v2

    .line 1303
    const-class v3, Lcom/android/ex/chips/RecipientChip;

    invoke-interface {v2, v1, v0, v3}, Landroid/text/Spannable;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/android/ex/chips/RecipientChip;

    .line 1304
    if-eqz v0, :cond_0

    array-length v0, v0

    if-lez v0, :cond_0

    .line 1309
    :goto_0
    return-void

    .line 1308
    :cond_0
    invoke-super {p0, p1, p2}, Landroid/widget/MultiAutoCompleteTextView;->performFiltering(Ljava/lang/CharSequence;I)V

    goto :goto_0
.end method

.method public performValidation()V
    .locals 0

    .prologue
    .line 395
    return-void
.end method

.method removeChip(Lcom/android/ex/chips/RecipientChip;)V
    .locals 8
    .param p1, "chip"    # Lcom/android/ex/chips/RecipientChip;

    .prologue
    .line 2027
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSpannable()Landroid/text/Spannable;

    move-result-object v2

    .line 2028
    .local v2, "spannable":Landroid/text/Spannable;
    invoke-interface {v2, p1}, Landroid/text/Spannable;->getSpanStart(Ljava/lang/Object;)I

    move-result v1

    .line 2029
    .local v1, "spanStart":I
    invoke-interface {v2, p1}, Landroid/text/Spannable;->getSpanEnd(Ljava/lang/Object;)I

    move-result v0

    .line 2030
    .local v0, "spanEnd":I
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v3

    .line 2031
    .local v3, "text":Landroid/text/Editable;
    move v4, v0

    .line 2032
    .local v4, "toDelete":I
    iget-object v6, p0, Lcom/android/ex/chips/RecipientEditTextView;->mSelectedChip:Lcom/android/ex/chips/RecipientChip;

    if-ne p1, v6, :cond_1

    const/4 v5, 0x1

    .line 2034
    .local v5, "wasSelected":Z
    :goto_0
    if-eqz v5, :cond_0

    .line 2035
    const/4 v6, 0x0

    iput-object v6, p0, Lcom/android/ex/chips/RecipientEditTextView;->mSelectedChip:Lcom/android/ex/chips/RecipientChip;

    .line 2038
    :cond_0
    :goto_1
    if-ltz v4, :cond_2

    invoke-interface {v3}, Landroid/text/Editable;->length()I

    move-result v6

    if-ge v4, v6, :cond_2

    invoke-interface {v3, v4}, Landroid/text/Editable;->charAt(I)C

    move-result v6

    const/16 v7, 0x20

    if-ne v6, v7, :cond_2

    .line 2039
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    .line 2032
    .end local v5    # "wasSelected":Z
    :cond_1
    const/4 v5, 0x0

    goto :goto_0

    .line 2041
    .restart local v5    # "wasSelected":Z
    :cond_2
    invoke-interface {v2, p1}, Landroid/text/Spannable;->removeSpan(Ljava/lang/Object;)V

    .line 2042
    if-ltz v1, :cond_3

    if-lez v4, :cond_3

    .line 2043
    invoke-interface {v3, v1, v4}, Landroid/text/Editable;->delete(II)Landroid/text/Editable;

    .line 2045
    :cond_3
    if-eqz v5, :cond_4

    .line 2046
    invoke-direct {p0}, Lcom/android/ex/chips/RecipientEditTextView;->clearSelectedChip()V

    .line 2048
    :cond_4
    return-void
.end method

.method removeMoreChip()V
    .locals 11

    .prologue
    .line 1829
    iget-object v9, p0, Lcom/android/ex/chips/RecipientEditTextView;->mMoreChip:Landroid/text/style/ImageSpan;

    if-eqz v9, :cond_0

    .line 1830
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSpannable()Landroid/text/Spannable;

    move-result-object v7

    .line 1831
    .local v7, "span":Landroid/text/Spannable;
    iget-object v9, p0, Lcom/android/ex/chips/RecipientEditTextView;->mMoreChip:Landroid/text/style/ImageSpan;

    invoke-interface {v7, v9}, Landroid/text/Spannable;->removeSpan(Ljava/lang/Object;)V

    .line 1832
    const/4 v9, 0x0

    iput-object v9, p0, Lcom/android/ex/chips/RecipientEditTextView;->mMoreChip:Landroid/text/style/ImageSpan;

    .line 1834
    iget-object v9, p0, Lcom/android/ex/chips/RecipientEditTextView;->mRemovedSpans:Ljava/util/ArrayList;

    if-eqz v9, :cond_0

    iget-object v9, p0, Lcom/android/ex/chips/RecipientEditTextView;->mRemovedSpans:Ljava/util/ArrayList;

    invoke-virtual {v9}, Ljava/util/ArrayList;->size()I

    move-result v9

    if-lez v9, :cond_0

    .line 1836
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSortedRecipients()[Lcom/android/ex/chips/RecipientChip;

    move-result-object v6

    .line 1839
    .local v6, "recipients":[Lcom/android/ex/chips/RecipientChip;
    if-eqz v6, :cond_0

    array-length v9, v6

    if-nez v9, :cond_1

    .line 1865
    .end local v6    # "recipients":[Lcom/android/ex/chips/RecipientChip;
    .end local v7    # "span":Landroid/text/Spannable;
    :cond_0
    :goto_0
    return-void

    .line 1842
    .restart local v6    # "recipients":[Lcom/android/ex/chips/RecipientChip;
    .restart local v7    # "span":Landroid/text/Spannable;
    :cond_1
    array-length v9, v6

    add-int/lit8 v9, v9, -0x1

    aget-object v9, v6, v9

    invoke-interface {v7, v9}, Landroid/text/Spannable;->getSpanEnd(Ljava/lang/Object;)I

    move-result v4

    .line 1843
    .local v4, "end":I
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v3

    .line 1844
    .local v3, "editable":Landroid/text/Editable;
    iget-object v9, p0, Lcom/android/ex/chips/RecipientEditTextView;->mRemovedSpans:Ljava/util/ArrayList;

    invoke-virtual {v9}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v5

    .local v5, "i$":Ljava/util/Iterator;
    :cond_2
    :goto_1
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_3

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/ex/chips/RecipientChip;

    .line 1849
    .local v0, "chip":Lcom/android/ex/chips/RecipientChip;
    invoke-virtual {v0}, Lcom/android/ex/chips/RecipientChip;->getOriginalText()Ljava/lang/CharSequence;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    .line 1854
    .local v8, "token":Ljava/lang/String;
    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v9, v8, v4}, Ljava/lang/String;->indexOf(Ljava/lang/String;I)I

    move-result v2

    .line 1855
    .local v2, "chipStart":I
    invoke-interface {v3}, Landroid/text/Editable;->length()I

    move-result v9

    invoke-virtual {v8}, Ljava/lang/String;->length()I

    move-result v10

    add-int/2addr v10, v2

    invoke-static {v9, v10}, Ljava/lang/Math;->min(II)I

    move-result v1

    .local v1, "chipEnd":I
    move v4, v1

    .line 1857
    const/4 v9, -0x1

    if-eq v2, v9, :cond_2

    .line 1858
    const/16 v9, 0x21

    invoke-interface {v3, v0, v2, v1, v9}, Landroid/text/Editable;->setSpan(Ljava/lang/Object;III)V

    goto :goto_1

    .line 1862
    .end local v0    # "chip":Lcom/android/ex/chips/RecipientChip;
    .end local v1    # "chipEnd":I
    .end local v2    # "chipStart":I
    .end local v8    # "token":Ljava/lang/String;
    :cond_3
    iget-object v9, p0, Lcom/android/ex/chips/RecipientEditTextView;->mRemovedSpans:Ljava/util/ArrayList;

    invoke-virtual {v9}, Ljava/util/ArrayList;->clear()V

    goto :goto_0
.end method

.method public removeTextChangedListener(Landroid/text/TextWatcher;)V
    .locals 1
    .param p1, "watcher"    # Landroid/text/TextWatcher;

    .prologue
    .line 2109
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTextWatcher:Landroid/text/TextWatcher;

    .line 2110
    invoke-super {p0, p1}, Landroid/widget/MultiAutoCompleteTextView;->removeTextChangedListener(Landroid/text/TextWatcher;)V

    .line 2111
    return-void
.end method

.method replaceChip(Lcom/android/ex/chips/RecipientChip;Lcom/android/ex/chips/RecipientEntry;)V
    .locals 8

    .prologue
    const/4 v2, 0x1

    const/4 v7, -0x1

    const/4 v3, 0x0

    .line 2056
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mSelectedChip:Lcom/android/ex/chips/RecipientChip;

    if-ne p1, v0, :cond_4

    move v1, v2

    .line 2057
    :goto_0
    if-eqz v1, :cond_0

    .line 2058
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mSelectedChip:Lcom/android/ex/chips/RecipientChip;

    .line 2060
    :cond_0
    invoke-direct {p0, p1}, Lcom/android/ex/chips/RecipientEditTextView;->getChipStart(Lcom/android/ex/chips/RecipientChip;)I

    move-result v4

    .line 2061
    invoke-direct {p0, p1}, Lcom/android/ex/chips/RecipientEditTextView;->getChipEnd(Lcom/android/ex/chips/RecipientChip;)I

    move-result v0

    .line 2062
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSpannable()Landroid/text/Spannable;

    move-result-object v5

    invoke-interface {v5, p1}, Landroid/text/Spannable;->removeSpan(Ljava/lang/Object;)V

    .line 2063
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v5

    .line 2064
    invoke-direct {p0, p2, v3}, Lcom/android/ex/chips/RecipientEditTextView;->createChip(Lcom/android/ex/chips/RecipientEntry;Z)Ljava/lang/CharSequence;

    move-result-object v6

    .line 2065
    if-eqz v6, :cond_2

    .line 2066
    if-eq v4, v7, :cond_1

    if-ne v0, v7, :cond_5

    .line 2067
    :cond_1
    const-string v0, "RecipientEditTextView"

    const-string v4, "The chip to replace does not exist but should."

    invoke-static {v0, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 2068
    invoke-interface {v5, v3, v6}, Landroid/text/Editable;->insert(ILjava/lang/CharSequence;)Landroid/text/Editable;

    .line 2082
    :cond_2
    :goto_1
    invoke-virtual {p0, v2}, Lcom/android/ex/chips/RecipientEditTextView;->setCursorVisible(Z)V

    .line 2083
    if-eqz v1, :cond_3

    .line 2084
    invoke-direct {p0}, Lcom/android/ex/chips/RecipientEditTextView;->clearSelectedChip()V

    .line 2086
    :cond_3
    return-void

    :cond_4
    move v1, v3

    .line 2056
    goto :goto_0

    .line 2070
    :cond_5
    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 2075
    :goto_2
    if-ltz v0, :cond_6

    invoke-interface {v5}, Landroid/text/Editable;->length()I

    move-result v3

    if-ge v0, v3, :cond_6

    invoke-interface {v5, v0}, Landroid/text/Editable;->charAt(I)C

    move-result v3

    const/16 v7, 0x20

    if-ne v3, v7, :cond_6

    .line 2076
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 2078
    :cond_6
    invoke-interface {v5, v4, v0, v6}, Landroid/text/Editable;->replace(IILjava/lang/CharSequence;)Landroid/text/Editable;

    goto :goto_1
.end method

.method protected replaceText(Ljava/lang/CharSequence;)V
    .locals 0
    .param p1, "text"    # Ljava/lang/CharSequence;

    .prologue
    .line 1035
    return-void
.end method

.method sanitizeBetween()V
    .locals 8

    .prologue
    .line 1187
    iget v6, p0, Lcom/android/ex/chips/RecipientEditTextView;->mPendingChipsCount:I

    if-lez v6, :cond_1

    .line 1215
    :cond_0
    :goto_0
    return-void

    .line 1191
    :cond_1
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSortedRecipients()[Lcom/android/ex/chips/RecipientChip;

    move-result-object v3

    .line 1192
    .local v3, "recips":[Lcom/android/ex/chips/RecipientChip;
    if-eqz v3, :cond_0

    array-length v6, v3

    if-lez v6, :cond_0

    .line 1193
    array-length v6, v3

    add-int/lit8 v6, v6, -0x1

    aget-object v2, v3, v6

    .line 1194
    .local v2, "last":Lcom/android/ex/chips/RecipientChip;
    const/4 v0, 0x0

    .line 1195
    .local v0, "beforeLast":Lcom/android/ex/chips/RecipientChip;
    array-length v6, v3

    const/4 v7, 0x1

    if-le v6, v7, :cond_2

    .line 1196
    array-length v6, v3

    add-int/lit8 v6, v6, -0x2

    aget-object v0, v3, v6

    .line 1198
    :cond_2
    const/4 v4, 0x0

    .line 1199
    .local v4, "startLooking":I
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSpannable()Landroid/text/Spannable;

    move-result-object v6

    invoke-interface {v6, v2}, Landroid/text/Spannable;->getSpanStart(Ljava/lang/Object;)I

    move-result v1

    .line 1200
    .local v1, "end":I
    if-eqz v0, :cond_3

    .line 1201
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSpannable()Landroid/text/Spannable;

    move-result-object v6

    invoke-interface {v6, v0}, Landroid/text/Spannable;->getSpanEnd(Ljava/lang/Object;)I

    move-result v4

    .line 1202
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v5

    .line 1203
    .local v5, "text":Landroid/text/Editable;
    const/4 v6, -0x1

    if-eq v4, v6, :cond_0

    invoke-interface {v5}, Landroid/text/Editable;->length()I

    move-result v6

    add-int/lit8 v6, v6, -0x1

    if-gt v4, v6, :cond_0

    .line 1207
    invoke-interface {v5, v4}, Landroid/text/Editable;->charAt(I)C

    move-result v6

    const/16 v7, 0x20

    if-ne v6, v7, :cond_3

    .line 1208
    add-int/lit8 v4, v4, 0x1

    .line 1211
    .end local v5    # "text":Landroid/text/Editable;
    :cond_3
    if-ltz v4, :cond_0

    if-ltz v1, :cond_0

    if-ge v4, v1, :cond_0

    .line 1212
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-interface {v6, v4, v1}, Landroid/text/Editable;->delete(II)Landroid/text/Editable;

    goto :goto_0
.end method

.method sanitizeEnd()V
    .locals 6

    .prologue
    .line 854
    iget v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mPendingChipsCount:I

    if-lez v0, :cond_1

    .line 880
    :cond_0
    :goto_0
    return-void

    .line 858
    :cond_1
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSortedRecipients()[Lcom/android/ex/chips/RecipientChip;

    move-result-object v0

    .line 859
    if-eqz v0, :cond_0

    array-length v0, v0

    if-lez v0, :cond_0

    .line 862
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getMoreChip()Landroid/text/style/ImageSpan;

    move-result-object v0

    iput-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mMoreChip:Landroid/text/style/ImageSpan;

    .line 863
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mMoreChip:Landroid/text/style/ImageSpan;

    if-eqz v0, :cond_3

    .line 864
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mMoreChip:Landroid/text/style/ImageSpan;

    .line 868
    :goto_1
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getSpannable()Landroid/text/Spannable;

    move-result-object v1

    invoke-interface {v1, v0}, Landroid/text/Spannable;->getSpanEnd(Ljava/lang/Object;)I

    move-result v0

    .line 869
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v1

    .line 870
    invoke-interface {v1}, Landroid/text/Editable;->length()I

    move-result v2

    .line 871
    if-le v2, v0, :cond_0

    .line 873
    const-string v3, "RecipientEditTextView"

    const/4 v4, 0x3

    invoke-static {v3, v4}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 874
    const-string v3, "RecipientEditTextView"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "There were extra characters after the last tokenizable entry."

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 877
    :cond_2
    add-int/lit8 v0, v0, 0x1

    invoke-interface {v1, v0, v2}, Landroid/text/Editable;->delete(II)Landroid/text/Editable;

    goto :goto_0

    .line 866
    :cond_3
    invoke-virtual {p0}, Lcom/android/ex/chips/RecipientEditTextView;->getLastChip()Lcom/android/ex/chips/RecipientChip;

    move-result-object v0

    goto :goto_1
.end method

.method public setTokenizer(Landroid/widget/MultiAutoCompleteTextView$Tokenizer;)V
    .locals 1
    .param p1, "tokenizer"    # Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

    .prologue
    .line 1018
    iput-object p1, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

    .line 1019
    iget-object v0, p0, Lcom/android/ex/chips/RecipientEditTextView;->mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

    invoke-super {p0, v0}, Landroid/widget/MultiAutoCompleteTextView;->setTokenizer(Landroid/widget/MultiAutoCompleteTextView$Tokenizer;)V

    .line 1020
    return-void
.end method

.method public setValidator(Landroid/widget/AutoCompleteTextView$Validator;)V
    .locals 0
    .param p1, "validator"    # Landroid/widget/AutoCompleteTextView$Validator;

    .prologue
    .line 1024
    iput-object p1, p0, Lcom/android/ex/chips/RecipientEditTextView;->mValidator:Landroid/widget/AutoCompleteTextView$Validator;

    .line 1025
    invoke-super {p0, p1}, Landroid/widget/MultiAutoCompleteTextView;->setValidator(Landroid/widget/AutoCompleteTextView$Validator;)V

    .line 1026
    return-void
.end method
