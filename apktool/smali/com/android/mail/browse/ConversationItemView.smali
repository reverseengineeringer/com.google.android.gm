.class public Lcom/android/mail/browse/ConversationItemView;
.super Landroid/view/View;
.source "ConversationItemView.java"

# interfaces
.implements Lcom/android/mail/browse/ToggleableItem;
.implements Lcom/android/mail/ui/SwipeableItemView;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/browse/ConversationItemView$ShadowBuilder;,
        Lcom/android/mail/browse/ConversationItemView$ConversationItemFolderDisplayer;
    }
.end annotation


# static fields
.field private static ATTACHMENT:Landroid/graphics/Bitmap;

.field private static CHECKMARK_OFF:Landroid/graphics/Bitmap;

.field private static CHECKMARK_ON:Landroid/graphics/Bitmap;

.field private static DATE_BACKGROUND:Landroid/graphics/Bitmap;

.field private static IMPORTANT_ONLY_TO_ME:Landroid/graphics/Bitmap;

.field private static IMPORTANT_TO_ME_AND_OTHERS:Landroid/graphics/Bitmap;

.field private static IMPORTANT_TO_OTHERS:Landroid/graphics/Bitmap;

.field private static final LOG_TAG:Ljava/lang/String;

.field private static MORE_FOLDERS:Landroid/graphics/Bitmap;

.field private static ONLY_TO_ME:Landroid/graphics/Bitmap;

.field private static STAR_OFF:Landroid/graphics/Bitmap;

.field private static STAR_ON:Landroid/graphics/Bitmap;

.field private static STATE_CALENDAR_INVITE:Landroid/graphics/Bitmap;

.field private static STATE_FORWARDED:Landroid/graphics/Bitmap;

.field private static STATE_REPLIED:Landroid/graphics/Bitmap;

.field private static STATE_REPLIED_AND_FORWARDED:Landroid/graphics/Bitmap;

.field private static TO_ME_AND_OTHERS:Landroid/graphics/Bitmap;

.field private static sActivatedTextColor:I

.field private static sActivatedTextSpan:Landroid/text/style/CharacterStyle;

.field private static sAnimatingBackgroundColor:I

.field private static sDateBackgroundAttachment:Landroid/graphics/Bitmap;

.field private static sDateBackgroundHeight:I

.field private static sDateBackgroundNoAttachment:Landroid/graphics/Bitmap;

.field private static sDateBackgroundPaddingLeft:I

.field private static sDateTextColor:I

.field private static sDefaultTextColor:I

.field private static sElidedPaddingToken:Ljava/lang/String;

.field private static sFadedActivatedColor:I

.field private static sFoldersPaint:Landroid/text/TextPaint;

.field private static sHtmlBuilder:Lcom/google/android/common/html/parser/HtmlTreeBuilder;

.field private static sHtmlParser:Lcom/google/android/common/html/parser/HtmlParser;

.field private static sLayoutCount:I

.field private static sPaint:Landroid/text/TextPaint;

.field private static sScrollSlop:I

.field private static sSendersSplitToken:Ljava/lang/String;

.field private static sSendersTextColorRead:I

.field private static sSendersTextColorUnread:I

.field private static sSendersTextView:Landroid/widget/TextView;

.field private static sSendersTextViewHeight:I

.field private static sSendersTextViewTopPadding:I

.field private static sShrinkAnimationDuration:I

.field private static sSlideAnimationDuration:I

.field private static sSnippetTextColorRead:I

.field private static sSnippetTextColorUnread:I

.field private static sStandardScaledDimen:I

.field private static sSubjectTextColorRead:I

.field private static sSubjectTextColorUnead:I

.field private static sSubjectTextView:Landroid/widget/TextView;

.field private static sTimer:Lcom/android/mail/perf/Timer;

.field private static sTouchSlop:I


# instance fields
.field private mAccount:Ljava/lang/String;

.field private mActivity:Lcom/android/mail/ui/ControllableActivity;

.field private mAdapter:Lcom/android/mail/ui/AnimatedAdapter;

.field private mAnimatedHeight:I

.field private mBackgroundOverride:I

.field private final mBackgrounds:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Landroid/graphics/drawable/Drawable;",
            ">;"
        }
    .end annotation
.end field

.field private mCheckboxesEnabled:Z

.field private mChecked:Z

.field private final mContext:Landroid/content/Context;

.field mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

.field private mDateX:I

.field private mDisplayedFolder:Lcom/android/mail/providers/Folder;

.field private mDownEvent:Z

.field private mFoldersXEnd:I

.field public mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

.field private mLastTouchX:I

.field private mLastTouchY:I

.field private mMode:I

.field private mPaperclipX:I

.field private mPreviousMode:I

.field private mPriorityMarkersEnabled:Z

.field private mSelectedConversationSet:Lcom/android/mail/ui/ConversationSelectionSet;

.field private mSendersWidth:I

.field private mSwipeEnabled:Z

.field private final mTabletDevice:Z

.field private mTesting:Z

.field private mViewWidth:I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 84
    const/4 v0, 0x0

    sput v0, Lcom/android/mail/browse/ConversationItemView;->sLayoutCount:I

    .line 93
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/browse/ConversationItemView;->LOG_TAG:Ljava/lang/String;

    .line 134
    new-instance v0, Landroid/text/TextPaint;

    invoke-direct {v0}, Landroid/text/TextPaint;-><init>()V

    sput-object v0, Lcom/android/mail/browse/ConversationItemView;->sPaint:Landroid/text/TextPaint;

    .line 135
    new-instance v0, Landroid/text/TextPaint;

    invoke-direct {v0}, Landroid/text/TextPaint;-><init>()V

    sput-object v0, Lcom/android/mail/browse/ConversationItemView;->sFoldersPaint:Landroid/text/TextPaint;

    .line 163
    const/4 v0, -0x1

    sput v0, Lcom/android/mail/browse/ConversationItemView;->sFadedActivatedColor:I

    .line 189
    sget-object v0, Lcom/android/mail/browse/ConversationItemView;->sPaint:Landroid/text/TextPaint;

    invoke-virtual {v0, v1}, Landroid/text/TextPaint;->setAntiAlias(Z)V

    .line 190
    sget-object v0, Lcom/android/mail/browse/ConversationItemView;->sFoldersPaint:Landroid/text/TextPaint;

    invoke-virtual {v0, v1}, Landroid/text/TextPaint;->setAntiAlias(Z)V

    .line 191
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "account"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    const/4 v2, -0x1

    .line 326
    invoke-direct {p0, p1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 138
    new-instance v1, Landroid/util/SparseArray;

    invoke-direct {v1}, Landroid/util/SparseArray;-><init>()V

    iput-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mBackgrounds:Landroid/util/SparseArray;

    .line 141
    iput v2, p0, Lcom/android/mail/browse/ConversationItemView;->mViewWidth:I

    .line 144
    iput v2, p0, Lcom/android/mail/browse/ConversationItemView;->mMode:I

    .line 151
    iput-boolean v3, p0, Lcom/android/mail/browse/ConversationItemView;->mTesting:Z

    .line 162
    iput-boolean v3, p0, Lcom/android/mail/browse/ConversationItemView;->mChecked:Z

    .line 172
    iput v2, p0, Lcom/android/mail/browse/ConversationItemView;->mAnimatedHeight:I

    .line 175
    iput v2, p0, Lcom/android/mail/browse/ConversationItemView;->mBackgroundOverride:I

    .line 327
    invoke-virtual {p0, v4}, Lcom/android/mail/browse/ConversationItemView;->setClickable(Z)V

    .line 328
    invoke-virtual {p0, v4}, Lcom/android/mail/browse/ConversationItemView;->setLongClickable(Z)V

    .line 329
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    iput-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mContext:Landroid/content/Context;

    .line 330
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mContext:Landroid/content/Context;

    invoke-static {v1}, Lcom/android/mail/utils/Utils;->useTabletUI(Landroid/content/Context;)Z

    move-result v1

    iput-boolean v1, p0, Lcom/android/mail/browse/ConversationItemView;->mTabletDevice:Z

    .line 331
    iput-object p2, p0, Lcom/android/mail/browse/ConversationItemView;->mAccount:Ljava/lang/String;

    .line 332
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 334
    .local v0, "res":Landroid/content/res/Resources;
    sget-object v1, Lcom/android/mail/browse/ConversationItemView;->CHECKMARK_OFF:Landroid/graphics/Bitmap;

    if-nez v1, :cond_0

    .line 336
    const v1, 0x7f020008

    invoke-static {v0, v1}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v1

    sput-object v1, Lcom/android/mail/browse/ConversationItemView;->CHECKMARK_OFF:Landroid/graphics/Bitmap;

    .line 338
    const v1, 0x7f020009

    invoke-static {v0, v1}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v1

    sput-object v1, Lcom/android/mail/browse/ConversationItemView;->CHECKMARK_ON:Landroid/graphics/Bitmap;

    .line 340
    const v1, 0x7f02000c

    invoke-static {v0, v1}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v1

    sput-object v1, Lcom/android/mail/browse/ConversationItemView;->STAR_OFF:Landroid/graphics/Bitmap;

    .line 342
    const v1, 0x7f020010

    invoke-static {v0, v1}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v1

    sput-object v1, Lcom/android/mail/browse/ConversationItemView;->STAR_ON:Landroid/graphics/Bitmap;

    .line 344
    const v1, 0x7f020043

    invoke-static {v0, v1}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v1

    sput-object v1, Lcom/android/mail/browse/ConversationItemView;->ONLY_TO_ME:Landroid/graphics/Bitmap;

    .line 345
    const v1, 0x7f020046

    invoke-static {v0, v1}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v1

    sput-object v1, Lcom/android/mail/browse/ConversationItemView;->TO_ME_AND_OTHERS:Landroid/graphics/Bitmap;

    .line 346
    const v1, 0x7f020044

    invoke-static {v0, v1}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v1

    sput-object v1, Lcom/android/mail/browse/ConversationItemView;->IMPORTANT_ONLY_TO_ME:Landroid/graphics/Bitmap;

    .line 348
    const v1, 0x7f020047

    invoke-static {v0, v1}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v1

    sput-object v1, Lcom/android/mail/browse/ConversationItemView;->IMPORTANT_TO_ME_AND_OTHERS:Landroid/graphics/Bitmap;

    .line 350
    const v1, 0x7f020045

    invoke-static {v0, v1}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v1

    sput-object v1, Lcom/android/mail/browse/ConversationItemView;->IMPORTANT_TO_OTHERS:Landroid/graphics/Bitmap;

    .line 352
    const v1, 0x7f02003a

    invoke-static {v0, v1}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v1

    sput-object v1, Lcom/android/mail/browse/ConversationItemView;->ATTACHMENT:Landroid/graphics/Bitmap;

    .line 353
    const v1, 0x7f020049

    invoke-static {v0, v1}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v1

    sput-object v1, Lcom/android/mail/browse/ConversationItemView;->MORE_FOLDERS:Landroid/graphics/Bitmap;

    .line 354
    const v1, 0x7f02001d

    invoke-static {v0, v1}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v1

    sput-object v1, Lcom/android/mail/browse/ConversationItemView;->DATE_BACKGROUND:Landroid/graphics/Bitmap;

    .line 355
    const v1, 0x7f02003e

    invoke-static {v0, v1}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v1

    sput-object v1, Lcom/android/mail/browse/ConversationItemView;->STATE_REPLIED:Landroid/graphics/Bitmap;

    .line 357
    const v1, 0x7f02003b

    invoke-static {v0, v1}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v1

    sput-object v1, Lcom/android/mail/browse/ConversationItemView;->STATE_FORWARDED:Landroid/graphics/Bitmap;

    .line 359
    const v1, 0x7f02003d

    invoke-static {v0, v1}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v1

    sput-object v1, Lcom/android/mail/browse/ConversationItemView;->STATE_REPLIED_AND_FORWARDED:Landroid/graphics/Bitmap;

    .line 361
    const v1, 0x7f02003c

    invoke-static {v0, v1}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v1

    sput-object v1, Lcom/android/mail/browse/ConversationItemView;->STATE_CALENDAR_INVITE:Landroid/graphics/Bitmap;

    .line 365
    const v1, 0x7f090004

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    sput v1, Lcom/android/mail/browse/ConversationItemView;->sDefaultTextColor:I

    .line 366
    const v1, 0x106000b

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    sput v1, Lcom/android/mail/browse/ConversationItemView;->sActivatedTextColor:I

    .line 367
    new-instance v1, Landroid/text/style/ForegroundColorSpan;

    sget v2, Lcom/android/mail/browse/ConversationItemView;->sActivatedTextColor:I

    invoke-direct {v1, v2}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    invoke-static {v1}, Landroid/text/style/CharacterStyle;->wrap(Landroid/text/style/CharacterStyle;)Landroid/text/style/CharacterStyle;

    move-result-object v1

    sput-object v1, Lcom/android/mail/browse/ConversationItemView;->sActivatedTextSpan:Landroid/text/style/CharacterStyle;

    .line 368
    const v1, 0x7f090008

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    sput v1, Lcom/android/mail/browse/ConversationItemView;->sSubjectTextColorRead:I

    .line 369
    const v1, 0x7f090005

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    sput v1, Lcom/android/mail/browse/ConversationItemView;->sSubjectTextColorUnead:I

    .line 370
    const v1, 0x7f090009

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    sput v1, Lcom/android/mail/browse/ConversationItemView;->sSnippetTextColorRead:I

    .line 371
    const v1, 0x7f090006

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    sput v1, Lcom/android/mail/browse/ConversationItemView;->sSnippetTextColorUnread:I

    .line 372
    const v1, 0x7f09000a

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    sput v1, Lcom/android/mail/browse/ConversationItemView;->sSendersTextColorRead:I

    .line 373
    const v1, 0x7f090007

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    sput v1, Lcom/android/mail/browse/ConversationItemView;->sSendersTextColorUnread:I

    .line 374
    const v1, 0x7f09000b

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    sput v1, Lcom/android/mail/browse/ConversationItemView;->sDateTextColor:I

    .line 375
    const v1, 0x7f0b0024

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    sput v1, Lcom/android/mail/browse/ConversationItemView;->sDateBackgroundPaddingLeft:I

    .line 377
    const v1, 0x7f0b0025

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    sput v1, Lcom/android/mail/browse/ConversationItemView;->sTouchSlop:I

    .line 378
    const v1, 0x7f0b0023

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    sput v1, Lcom/android/mail/browse/ConversationItemView;->sDateBackgroundHeight:I

    .line 379
    const v1, 0x7f0b0027

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    sput v1, Lcom/android/mail/browse/ConversationItemView;->sStandardScaledDimen:I

    .line 380
    const v1, 0x7f0a0009

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v1

    sput v1, Lcom/android/mail/browse/ConversationItemView;->sShrinkAnimationDuration:I

    .line 381
    const v1, 0x7f0a000a

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v1

    sput v1, Lcom/android/mail/browse/ConversationItemView;->sSlideAnimationDuration:I

    .line 383
    const v1, 0x7f0c0100

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    sput-object v1, Lcom/android/mail/browse/ConversationItemView;->sSendersSplitToken:Ljava/lang/String;

    .line 384
    const v1, 0x7f0c0103

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    sput-object v1, Lcom/android/mail/browse/ConversationItemView;->sElidedPaddingToken:Ljava/lang/String;

    .line 385
    const v1, 0x7f090029

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    sput v1, Lcom/android/mail/browse/ConversationItemView;->sAnimatingBackgroundColor:I

    .line 386
    const v1, 0x7f0b0061

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    sput v1, Lcom/android/mail/browse/ConversationItemView;->sSendersTextViewTopPadding:I

    .line 388
    const v1, 0x7f0b0062

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    sput v1, Lcom/android/mail/browse/ConversationItemView;->sSendersTextViewHeight:I

    .line 390
    const v1, 0x7f0a001d

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v1

    sput v1, Lcom/android/mail/browse/ConversationItemView;->sScrollSlop:I

    .line 392
    :cond_0
    return-void
.end method

.method static synthetic access$000()Landroid/text/TextPaint;
    .locals 1

    .prologue
    .line 82
    sget-object v0, Lcom/android/mail/browse/ConversationItemView;->sFoldersPaint:Landroid/text/TextPaint;

    return-object v0
.end method

.method static synthetic access$100(II)I
    .locals 1
    .param p0, "x0"    # I
    .param p1, "x1"    # I

    .prologue
    .line 82
    invoke-static {p0, p1}, Lcom/android/mail/browse/ConversationItemView;->getPadding(II)I

    move-result v0

    return v0
.end method

.method static synthetic access$200()Landroid/graphics/Bitmap;
    .locals 1

    .prologue
    .line 82
    sget-object v0, Lcom/android/mail/browse/ConversationItemView;->MORE_FOLDERS:Landroid/graphics/Bitmap;

    return-object v0
.end method

.method static synthetic access$400()Landroid/text/TextPaint;
    .locals 1

    .prologue
    .line 82
    sget-object v0, Lcom/android/mail/browse/ConversationItemView;->sPaint:Landroid/text/TextPaint;

    return-object v0
.end method

.method private beginDragMode()V
    .locals 8

    .prologue
    const/4 v1, 0x1

    const/4 v6, 0x0

    .line 1538
    iget v0, p0, Lcom/android/mail/browse/ConversationItemView;->mLastTouchX:I

    if-ltz v0, :cond_0

    iget v0, p0, Lcom/android/mail/browse/ConversationItemView;->mLastTouchY:I

    if-gez v0, :cond_1

    .line 1568
    :cond_0
    :goto_0
    return-void

    .line 1542
    :cond_1
    iget-boolean v0, p0, Lcom/android/mail/browse/ConversationItemView;->mChecked:Z

    if-nez v0, :cond_2

    .line 1543
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationItemView;->toggleCheckMark()V

    .line 1548
    :cond_2
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mSelectedConversationSet:Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-virtual {v0}, Lcom/android/mail/ui/ConversationSelectionSet;->size()I

    move-result v3

    .line 1549
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mContext:Landroid/content/Context;

    const v2, 0x7f110001

    invoke-static {v0, v2, v3}, Lcom/android/mail/utils/Utils;->formatPlural(Landroid/content/Context;II)Ljava/lang/String;

    move-result-object v0

    .line 1551
    iget-object v2, p0, Lcom/android/mail/browse/ConversationItemView;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    sget-object v4, Lcom/android/mail/providers/Conversation;->MOVE_CONVERSATIONS_URI:Landroid/net/Uri;

    invoke-static {v2, v0, v4}, Landroid/content/ClipData;->newUri(Landroid/content/ContentResolver;Ljava/lang/CharSequence;Landroid/net/Uri;)Landroid/content/ClipData;

    move-result-object v7

    .line 1553
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mSelectedConversationSet:Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-virtual {v0}, Lcom/android/mail/ui/ConversationSelectionSet;->values()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Conversation;

    .line 1554
    new-instance v4, Landroid/content/ClipData$Item;

    iget v0, v0, Lcom/android/mail/providers/Conversation;->position:I

    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    invoke-direct {v4, v0}, Landroid/content/ClipData$Item;-><init>(Ljava/lang/CharSequence;)V

    invoke-virtual {v7, v4}, Landroid/content/ClipData;->addItem(Landroid/content/ClipData$Item;)V

    goto :goto_1

    .line 1557
    :cond_3
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationItemView;->getWidth()I

    move-result v2

    .line 1558
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationItemView;->getHeight()I

    move-result v4

    .line 1559
    if-ltz v2, :cond_4

    if-gez v4, :cond_5

    :cond_4
    move v0, v1

    .line 1560
    :goto_2
    if-eqz v0, :cond_6

    .line 1561
    sget-object v0, Lcom/android/mail/browse/ConversationItemView;->LOG_TAG:Ljava/lang/String;

    const-string v3, "ConversationItemView: dimension is negative: width=%d, height=%d"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v5, v6

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v5, v1

    invoke-static {v0, v3, v5}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0

    :cond_5
    move v0, v6

    .line 1559
    goto :goto_2

    .line 1565
    :cond_6
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->startDragMode()V

    .line 1567
    new-instance v0, Lcom/android/mail/browse/ConversationItemView$ShadowBuilder;

    iget v4, p0, Lcom/android/mail/browse/ConversationItemView;->mLastTouchX:I

    iget v5, p0, Lcom/android/mail/browse/ConversationItemView;->mLastTouchY:I

    move-object v1, p0

    move-object v2, p0

    invoke-direct/range {v0 .. v5}, Lcom/android/mail/browse/ConversationItemView$ShadowBuilder;-><init>(Lcom/android/mail/browse/ConversationItemView;Landroid/view/View;III)V

    const/4 v1, 0x0

    invoke-virtual {p0, v7, v0, v1, v6}, Lcom/android/mail/browse/ConversationItemView;->startDrag(Landroid/content/ClipData;Landroid/view/View$DragShadowBuilder;Ljava/lang/Object;I)Z

    goto/16 :goto_0
.end method

.method private bind(Lcom/android/mail/browse/ConversationItemViewModel;Lcom/android/mail/ui/ControllableActivity;Lcom/android/mail/ui/ConversationSelectionSet;Lcom/android/mail/providers/Folder;ZZZLcom/android/mail/ui/AnimatedAdapter;)V
    .locals 1
    .param p1, "header"    # Lcom/android/mail/browse/ConversationItemViewModel;
    .param p2, "activity"    # Lcom/android/mail/ui/ControllableActivity;
    .param p3, "set"    # Lcom/android/mail/ui/ConversationSelectionSet;
    .param p4, "folder"    # Lcom/android/mail/providers/Folder;
    .param p5, "checkboxesDisabled"    # Z
    .param p6, "swipeEnabled"    # Z
    .param p7, "priorityArrowEnabled"    # Z
    .param p8, "adapter"    # Lcom/android/mail/ui/AnimatedAdapter;

    .prologue
    .line 411
    iput-object p1, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    .line 412
    iput-object p2, p0, Lcom/android/mail/browse/ConversationItemView;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    .line 413
    iput-object p3, p0, Lcom/android/mail/browse/ConversationItemView;->mSelectedConversationSet:Lcom/android/mail/ui/ConversationSelectionSet;

    .line 414
    iput-object p4, p0, Lcom/android/mail/browse/ConversationItemView;->mDisplayedFolder:Lcom/android/mail/providers/Folder;

    .line 415
    if-nez p5, :cond_0

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Lcom/android/mail/browse/ConversationItemView;->mCheckboxesEnabled:Z

    .line 416
    iput-boolean p6, p0, Lcom/android/mail/browse/ConversationItemView;->mSwipeEnabled:Z

    .line 417
    iput-boolean p7, p0, Lcom/android/mail/browse/ConversationItemView;->mPriorityMarkersEnabled:Z

    .line 418
    iput-object p8, p0, Lcom/android/mail/browse/ConversationItemView;->mAdapter:Lcom/android/mail/ui/AnimatedAdapter;

    .line 419
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationItemView;->setContentDescription()V

    .line 420
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationItemView;->requestLayout()V

    .line 421
    return-void

    .line 415
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private calculateCoordinates()V
    .locals 22

    .prologue
    .line 684
    const-string v2, "CCHV.coordinates"

    invoke-static {v2}, Lcom/android/mail/browse/ConversationItemView;->startTimer(Ljava/lang/String;)V

    .line 686
    sget-object v2, Lcom/android/mail/browse/ConversationItemView;->sPaint:Landroid/text/TextPaint;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v3, v3, Lcom/android/mail/browse/ConversationItemViewCoordinates;->dateFontSize:I

    int-to-float v3, v3

    invoke-virtual {v2, v3}, Landroid/text/TextPaint;->setTextSize(F)V

    .line 687
    sget-object v2, Lcom/android/mail/browse/ConversationItemView;->sPaint:Landroid/text/TextPaint;

    sget-object v3, Landroid/graphics/Typeface;->DEFAULT:Landroid/graphics/Typeface;

    invoke-virtual {v2, v3}, Landroid/text/TextPaint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    .line 688
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v2, v2, Lcom/android/mail/browse/ConversationItemViewCoordinates;->dateXEnd:I

    sget-object v3, Lcom/android/mail/browse/ConversationItemView;->sPaint:Landroid/text/TextPaint;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v4, v4, Lcom/android/mail/browse/ConversationItemViewModel;->dateText:Ljava/lang/String;

    invoke-virtual {v3, v4}, Landroid/text/TextPaint;->measureText(Ljava/lang/String;)F

    move-result v3

    float-to-int v3, v3

    sub-int/2addr v2, v3

    move-object/from16 v0, p0

    iput v2, v0, Lcom/android/mail/browse/ConversationItemView;->mDateX:I

    .line 690
    move-object/from16 v0, p0

    iget v2, v0, Lcom/android/mail/browse/ConversationItemView;->mDateX:I

    sget-object v3, Lcom/android/mail/browse/ConversationItemView;->ATTACHMENT:Landroid/graphics/Bitmap;

    invoke-virtual {v3}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v3

    sub-int/2addr v2, v3

    move-object/from16 v0, p0

    iput v2, v0, Lcom/android/mail/browse/ConversationItemView;->mPaperclipX:I

    .line 692
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/android/mail/browse/ConversationItemView;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0b0028

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v10

    .line 694
    .local v10, "cellWidth":I
    move-object/from16 v0, p0

    iget v2, v0, Lcom/android/mail/browse/ConversationItemView;->mMode:I

    invoke-static {v2}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->isWideMode(I)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 696
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v2, v2, Lcom/android/mail/browse/ConversationItemViewCoordinates;->dateXEnd:I

    move-object/from16 v0, p0

    iput v2, v0, Lcom/android/mail/browse/ConversationItemView;->mFoldersXEnd:I

    .line 699
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v2, v2, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sendersWidth:I

    move-object/from16 v0, p0

    iput v2, v0, Lcom/android/mail/browse/ConversationItemView;->mSendersWidth:I

    .line 726
    :cond_0
    :goto_0
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/android/mail/browse/ConversationItemView;->mContext:Landroid/content/Context;

    invoke-virtual {v2, v3}, Lcom/android/mail/browse/ConversationItemViewModel;->isLayoutValid(Landroid/content/Context;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 727
    const-string v2, "CCHV.coordinates"

    invoke-static {v2}, Lcom/android/mail/browse/ConversationItemView;->pauseTimer(Ljava/lang/String;)V

    .line 773
    :goto_1
    return-void

    .line 703
    :cond_1
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget-boolean v2, v2, Lcom/android/mail/browse/ConversationItemViewCoordinates;->showFolders:Z

    if-eqz v2, :cond_3

    .line 704
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v2, v2, Lcom/android/mail/browse/ConversationItemViewModel;->paperclip:Landroid/graphics/Bitmap;

    if-eqz v2, :cond_2

    .line 705
    move-object/from16 v0, p0

    iget v2, v0, Lcom/android/mail/browse/ConversationItemView;->mPaperclipX:I

    move-object/from16 v0, p0

    iput v2, v0, Lcom/android/mail/browse/ConversationItemView;->mFoldersXEnd:I

    .line 709
    :goto_2
    move-object/from16 v0, p0

    iget v2, v0, Lcom/android/mail/browse/ConversationItemView;->mFoldersXEnd:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v3, v3, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sendersX:I

    sub-int/2addr v2, v3

    mul-int/lit8 v3, v10, 0x2

    sub-int/2addr v2, v3

    move-object/from16 v0, p0

    iput v2, v0, Lcom/android/mail/browse/ConversationItemView;->mSendersWidth:I

    .line 710
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v2, v2, Lcom/android/mail/browse/ConversationItemViewModel;->folderDisplayer:Lcom/android/mail/browse/ConversationItemView$ConversationItemFolderDisplayer;

    invoke-virtual {v2}, Lcom/android/mail/browse/ConversationItemView$ConversationItemFolderDisplayer;->hasVisibleFolders()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 711
    move-object/from16 v0, p0

    iget v2, v0, Lcom/android/mail/browse/ConversationItemView;->mSendersWidth:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/android/mail/browse/ConversationItemView;->mContext:Landroid/content/Context;

    move-object/from16 v0, p0

    iget v4, v0, Lcom/android/mail/browse/ConversationItemView;->mMode:I

    invoke-static {v3, v4}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getFoldersWidth(Landroid/content/Context;I)I

    move-result v3

    sub-int/2addr v2, v3

    move-object/from16 v0, p0

    iput v2, v0, Lcom/android/mail/browse/ConversationItemView;->mSendersWidth:I

    goto :goto_0

    .line 707
    :cond_2
    move-object/from16 v0, p0

    iget v2, v0, Lcom/android/mail/browse/ConversationItemView;->mDateX:I

    div-int/lit8 v3, v10, 0x2

    sub-int/2addr v2, v3

    move-object/from16 v0, p0

    iput v2, v0, Lcom/android/mail/browse/ConversationItemView;->mFoldersXEnd:I

    goto :goto_2

    .line 715
    :cond_3
    const/4 v11, 0x0

    .line 717
    .local v11, "dateAttachmentStart":I
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v2, v2, Lcom/android/mail/browse/ConversationItemViewModel;->paperclip:Landroid/graphics/Bitmap;

    if-eqz v2, :cond_4

    .line 718
    move-object/from16 v0, p0

    iget v11, v0, Lcom/android/mail/browse/ConversationItemView;->mPaperclipX:I

    .line 722
    :goto_3
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v2, v2, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sendersX:I

    sub-int v2, v11, v2

    sub-int/2addr v2, v10

    move-object/from16 v0, p0

    iput v2, v0, Lcom/android/mail/browse/ConversationItemView;->mSendersWidth:I

    goto/16 :goto_0

    .line 720
    :cond_4
    move-object/from16 v0, p0

    iget v11, v0, Lcom/android/mail/browse/ConversationItemView;->mDateX:I

    goto :goto_3

    .line 732
    .end local v11    # "dateAttachmentStart":I
    :cond_5
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v2, v2, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sendersY:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v3, v3, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sendersAscent:I

    sub-int v17, v2, v3

    .line 734
    .local v17, "sendersY":I
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v2, v2, Lcom/android/mail/browse/ConversationItemViewModel;->styledSenders:[Landroid/text/SpannableString;

    if-eqz v2, :cond_7

    .line 735
    invoke-direct/range {p0 .. p0}, Lcom/android/mail/browse/ConversationItemView;->ellipsizeStyledSenders()I

    .line 766
    :goto_4
    sget-object v2, Lcom/android/mail/browse/ConversationItemView;->sPaint:Landroid/text/TextPaint;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v3, v3, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sendersFontSize:I

    int-to-float v3, v3

    invoke-virtual {v2, v3}, Landroid/text/TextPaint;->setTextSize(F)V

    .line 767
    sget-object v2, Lcom/android/mail/browse/ConversationItemView;->sPaint:Landroid/text/TextPaint;

    sget-object v3, Landroid/graphics/Typeface;->DEFAULT:Landroid/graphics/Typeface;

    invoke-virtual {v2, v3}, Landroid/text/TextPaint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    .line 768
    move-object/from16 v0, p0

    iget v2, v0, Lcom/android/mail/browse/ConversationItemView;->mSendersWidth:I

    if-gez v2, :cond_6

    .line 769
    const/4 v2, 0x0

    move-object/from16 v0, p0

    iput v2, v0, Lcom/android/mail/browse/ConversationItemView;->mSendersWidth:I

    .line 772
    :cond_6
    const-string v2, "CCHV.coordinates"

    invoke-static {v2}, Lcom/android/mail/browse/ConversationItemView;->pauseTimer(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 738
    :cond_7
    const/16 v20, 0x0

    .line 739
    .local v20, "totalWidth":I
    const/4 v13, 0x0

    .line 740
    .local v13, "fixedWidth":I
    sget-object v2, Lcom/android/mail/browse/ConversationItemView;->sPaint:Landroid/text/TextPaint;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v3, v3, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sendersFontSize:I

    int-to-float v3, v3

    invoke-virtual {v2, v3}, Landroid/text/TextPaint;->setTextSize(F)V

    .line 741
    sget-object v2, Lcom/android/mail/browse/ConversationItemView;->sPaint:Landroid/text/TextPaint;

    sget-object v3, Landroid/graphics/Typeface;->DEFAULT:Landroid/graphics/Typeface;

    invoke-virtual {v2, v3}, Landroid/text/TextPaint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    .line 742
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v2, v2, Lcom/android/mail/browse/ConversationItemViewModel;->senderFragments:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v14

    .local v14, "i$":Ljava/util/Iterator;
    :goto_5
    invoke-interface {v14}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_9

    invoke-interface {v14}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Lcom/android/mail/browse/ConversationItemViewModel$SenderFragment;

    .line 743
    .local v16, "senderFragment":Lcom/android/mail/browse/ConversationItemViewModel$SenderFragment;
    move-object/from16 v0, v16

    iget-object v0, v0, Lcom/android/mail/browse/ConversationItemViewModel$SenderFragment;->style:Landroid/text/style/CharacterStyle;

    move-object/from16 v19, v0

    .line 744
    .local v19, "style":Landroid/text/style/CharacterStyle;
    move-object/from16 v0, v16

    iget v0, v0, Lcom/android/mail/browse/ConversationItemViewModel$SenderFragment;->start:I

    move/from16 v18, v0

    .line 745
    .local v18, "start":I
    move-object/from16 v0, v16

    iget v12, v0, Lcom/android/mail/browse/ConversationItemViewModel$SenderFragment;->end:I

    .line 746
    .local v12, "end":I
    sget-object v2, Lcom/android/mail/browse/ConversationItemView;->sPaint:Landroid/text/TextPaint;

    move-object/from16 v0, v19

    invoke-virtual {v0, v2}, Landroid/text/style/CharacterStyle;->updateDrawState(Landroid/text/TextPaint;)V

    .line 747
    sget-object v2, Lcom/android/mail/browse/ConversationItemView;->sPaint:Landroid/text/TextPaint;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v3, v3, Lcom/android/mail/browse/ConversationItemViewModel;->sendersText:Ljava/lang/String;

    move/from16 v0, v18

    invoke-virtual {v2, v3, v0, v12}, Landroid/text/TextPaint;->measureText(Ljava/lang/String;II)F

    move-result v2

    float-to-int v2, v2

    move-object/from16 v0, v16

    iput v2, v0, Lcom/android/mail/browse/ConversationItemViewModel$SenderFragment;->width:I

    .line 748
    move-object/from16 v0, v16

    iget-boolean v15, v0, Lcom/android/mail/browse/ConversationItemViewModel$SenderFragment;->isFixed:Z

    .line 749
    .local v15, "isFixed":Z
    if-eqz v15, :cond_8

    .line 750
    move-object/from16 v0, v16

    iget v2, v0, Lcom/android/mail/browse/ConversationItemViewModel$SenderFragment;->width:I

    add-int/2addr v13, v2

    .line 752
    :cond_8
    move-object/from16 v0, v16

    iget v2, v0, Lcom/android/mail/browse/ConversationItemViewModel$SenderFragment;->width:I

    add-int v20, v20, v2

    .line 753
    goto :goto_5

    .line 755
    .end local v12    # "end":I
    .end local v15    # "isFixed":Z
    .end local v16    # "senderFragment":Lcom/android/mail/browse/ConversationItemViewModel$SenderFragment;
    .end local v18    # "start":I
    .end local v19    # "style":Landroid/text/style/CharacterStyle;
    :cond_9
    move-object/from16 v0, p0

    iget v2, v0, Lcom/android/mail/browse/ConversationItemView;->mMode:I

    invoke-static {v2}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->displaySendersInline(I)Z

    move-result v2

    if-nez v2, :cond_a

    .line 756
    move-object/from16 v0, p0

    iget v2, v0, Lcom/android/mail/browse/ConversationItemView;->mSendersWidth:I

    move/from16 v0, v20

    if-gt v0, v2, :cond_c

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v2, v2, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sendersLineHeight:I

    div-int/lit8 v2, v2, 0x2

    :goto_6
    add-int v17, v17, v2

    .line 758
    :cond_a
    move-object/from16 v0, p0

    iget v2, v0, Lcom/android/mail/browse/ConversationItemView;->mSendersWidth:I

    if-gez v2, :cond_b

    .line 759
    const/4 v2, 0x0

    move-object/from16 v0, p0

    iput v2, v0, Lcom/android/mail/browse/ConversationItemView;->mSendersWidth:I

    .line 761
    :cond_b
    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-direct {v0, v13, v1}, Lcom/android/mail/browse/ConversationItemView;->ellipsize(II)I

    move-result v20

    .line 762
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    move-object/from16 v21, v0

    new-instance v2, Landroid/text/StaticLayout;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v3, v3, Lcom/android/mail/browse/ConversationItemViewModel;->sendersDisplayText:Landroid/text/SpannableStringBuilder;

    sget-object v4, Lcom/android/mail/browse/ConversationItemView;->sPaint:Landroid/text/TextPaint;

    move-object/from16 v0, p0

    iget v5, v0, Lcom/android/mail/browse/ConversationItemView;->mSendersWidth:I

    sget-object v6, Landroid/text/Layout$Alignment;->ALIGN_NORMAL:Landroid/text/Layout$Alignment;

    const/high16 v7, 0x3f800000    # 1.0f

    const/4 v8, 0x0

    const/4 v9, 0x1

    invoke-direct/range {v2 .. v9}, Landroid/text/StaticLayout;-><init>(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFZ)V

    move-object/from16 v0, v21

    iput-object v2, v0, Lcom/android/mail/browse/ConversationItemViewModel;->sendersDisplayLayout:Landroid/text/StaticLayout;

    goto/16 :goto_4

    .line 756
    :cond_c
    const/4 v2, 0x0

    goto :goto_6
.end method

.method private calculateTextsAndBitmaps()V
    .locals 14

    .prologue
    const/4 v13, 0x0

    const/4 v4, 0x0

    const/4 v2, 0x1

    .line 512
    const-string v1, "CCHV.txtsbmps"

    invoke-static {v1}, Lcom/android/mail/browse/ConversationItemView;->startTimer(Ljava/lang/String;)V

    .line 513
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mSelectedConversationSet:Lcom/android/mail/ui/ConversationSelectionSet;

    if-eqz v1, :cond_0

    .line 514
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mSelectedConversationSet:Lcom/android/mail/ui/ConversationSelectionSet;

    iget-object v5, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v5, v5, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    invoke-virtual {v1, v5}, Lcom/android/mail/ui/ConversationSelectionSet;->contains(Lcom/android/mail/providers/Conversation;)Z

    move-result v1

    iput-boolean v1, p0, Lcom/android/mail/browse/ConversationItemView;->mChecked:Z

    .line 516
    :cond_0
    iget-boolean v6, p0, Lcom/android/mail/browse/ConversationItemView;->mCheckboxesEnabled:Z

    .line 517
    .local v6, "checkboxEnabled":Z
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-boolean v1, v1, Lcom/android/mail/browse/ConversationItemViewModel;->checkboxVisible:Z

    if-eq v1, v6, :cond_1

    .line 518
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iput-boolean v6, v1, Lcom/android/mail/browse/ConversationItemViewModel;->checkboxVisible:Z

    .line 521
    :cond_1
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-boolean v8, v1, Lcom/android/mail/browse/ConversationItemViewModel;->unread:Z

    .line 522
    .local v8, "isUnread":Z
    invoke-direct {p0, v8}, Lcom/android/mail/browse/ConversationItemView;->updateBackground(Z)V

    .line 524
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v5, p0, Lcom/android/mail/browse/ConversationItemView;->mContext:Landroid/content/Context;

    invoke-virtual {v1, v5}, Lcom/android/mail/browse/ConversationItemViewModel;->isLayoutValid(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 525
    const-string v1, "CCHV.txtsbmps"

    invoke-static {v1}, Lcom/android/mail/browse/ConversationItemView;->pauseTimer(Ljava/lang/String;)V

    .line 591
    :goto_0
    return-void

    .line 528
    :cond_2
    const-string v1, "CCHV.folders"

    invoke-static {v1}, Lcom/android/mail/browse/ConversationItemView;->startTimer(Ljava/lang/String;)V

    .line 531
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget-boolean v1, v1, Lcom/android/mail/browse/ConversationItemViewCoordinates;->showFolders:Z

    if-eqz v1, :cond_3

    .line 532
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    new-instance v5, Lcom/android/mail/browse/ConversationItemView$ConversationItemFolderDisplayer;

    iget-object v11, p0, Lcom/android/mail/browse/ConversationItemView;->mContext:Landroid/content/Context;

    invoke-direct {v5, v11}, Lcom/android/mail/browse/ConversationItemView$ConversationItemFolderDisplayer;-><init>(Landroid/content/Context;)V

    iput-object v5, v1, Lcom/android/mail/browse/ConversationItemViewModel;->folderDisplayer:Lcom/android/mail/browse/ConversationItemView$ConversationItemFolderDisplayer;

    .line 533
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v1, v1, Lcom/android/mail/browse/ConversationItemViewModel;->folderDisplayer:Lcom/android/mail/browse/ConversationItemView$ConversationItemFolderDisplayer;

    iget-object v5, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v5, v5, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    iget-object v11, p0, Lcom/android/mail/browse/ConversationItemView;->mDisplayedFolder:Lcom/android/mail/providers/Folder;

    invoke-virtual {v1, v5, v11}, Lcom/android/mail/browse/ConversationItemView$ConversationItemFolderDisplayer;->loadConversationFolders(Lcom/android/mail/providers/Conversation;Lcom/android/mail/providers/Folder;)V

    .line 536
    :cond_3
    const-string v1, "CCHV.folders"

    invoke-static {v1}, Lcom/android/mail/browse/ConversationItemView;->pauseTimer(Ljava/lang/String;)V

    .line 538
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v5, p0, Lcom/android/mail/browse/ConversationItemView;->mContext:Landroid/content/Context;

    iget-object v11, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v11, v11, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    iget-wide v11, v11, Lcom/android/mail/providers/Conversation;->dateMs:J

    invoke-static {v5, v11, v12}, Landroid/text/format/DateUtils;->getRelativeTimeSpanString(Landroid/content/Context;J)Ljava/lang/CharSequence;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    iput-object v5, v1, Lcom/android/mail/browse/ConversationItemViewModel;->dateText:Ljava/lang/String;

    .line 542
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iput-object v13, v1, Lcom/android/mail/browse/ConversationItemViewModel;->paperclip:Landroid/graphics/Bitmap;

    .line 543
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v1, v1, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    iget-boolean v1, v1, Lcom/android/mail/providers/Conversation;->hasAttachments:Z

    if-eqz v1, :cond_4

    .line 544
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    sget-object v5, Lcom/android/mail/browse/ConversationItemView;->ATTACHMENT:Landroid/graphics/Bitmap;

    iput-object v5, v1, Lcom/android/mail/browse/ConversationItemViewModel;->paperclip:Landroid/graphics/Bitmap;

    .line 547
    :cond_4
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iput-object v13, v1, Lcom/android/mail/browse/ConversationItemViewModel;->personalLevelBitmap:Landroid/graphics/Bitmap;

    .line 548
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget-boolean v1, v1, Lcom/android/mail/browse/ConversationItemViewCoordinates;->showPersonalLevel:Z

    if-eqz v1, :cond_5

    .line 549
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v1, v1, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    iget v9, v1, Lcom/android/mail/providers/Conversation;->personalLevel:I

    .line 550
    .local v9, "personalLevel":I
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v1, v1, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    iget v1, v1, Lcom/android/mail/providers/Conversation;->priority:I

    if-ne v1, v2, :cond_6

    move v7, v2

    .line 552
    .local v7, "isImportant":Z
    :goto_1
    if-eqz v7, :cond_7

    iget-boolean v1, p0, Lcom/android/mail/browse/ConversationItemView;->mPriorityMarkersEnabled:Z

    if-eqz v1, :cond_7

    move v10, v2

    .line 554
    .local v10, "useImportantMarkers":Z
    :goto_2
    const/4 v1, 0x2

    if-ne v9, v1, :cond_9

    .line 555
    iget-object v5, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    if-eqz v10, :cond_8

    sget-object v1, Lcom/android/mail/browse/ConversationItemView;->IMPORTANT_ONLY_TO_ME:Landroid/graphics/Bitmap;

    :goto_3
    iput-object v1, v5, Lcom/android/mail/browse/ConversationItemViewModel;->personalLevelBitmap:Landroid/graphics/Bitmap;

    .line 565
    .end local v7    # "isImportant":Z
    .end local v9    # "personalLevel":I
    .end local v10    # "useImportantMarkers":Z
    :cond_5
    :goto_4
    const-string v1, "CCHV.sendersubj"

    invoke-static {v1}, Lcom/android/mail/browse/ConversationItemView;->startTimer(Ljava/lang/String;)V

    .line 568
    invoke-direct {p0, v8}, Lcom/android/mail/browse/ConversationItemView;->layoutSubjectSpans(Z)V

    .line 570
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    new-instance v5, Landroid/text/SpannableStringBuilder;

    invoke-direct {v5}, Landroid/text/SpannableStringBuilder;-><init>()V

    iput-object v5, v1, Lcom/android/mail/browse/ConversationItemViewModel;->sendersDisplayText:Landroid/text/SpannableStringBuilder;

    .line 571
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    new-instance v5, Landroid/text/SpannableStringBuilder;

    invoke-direct {v5}, Landroid/text/SpannableStringBuilder;-><init>()V

    iput-object v5, v1, Lcom/android/mail/browse/ConversationItemViewModel;->styledSendersString:Landroid/text/SpannableStringBuilder;

    .line 574
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v1, v1, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    iget-object v1, v1, Lcom/android/mail/providers/Conversation;->conversationInfo:Lcom/android/mail/providers/ConversationInfo;

    if-eqz v1, :cond_d

    .line 575
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationItemView;->getContext()Landroid/content/Context;

    move-result-object v0

    .line 576
    .local v0, "context":Landroid/content/Context;
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v5, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v5, v5, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    invoke-static {v0, v5}, Lcom/android/mail/browse/SendersView;->createMessageInfo(Landroid/content/Context;Lcom/android/mail/providers/Conversation;)Landroid/text/SpannableStringBuilder;

    move-result-object v5

    iput-object v5, v1, Lcom/android/mail/browse/ConversationItemViewModel;->messageInfoString:Landroid/text/SpannableStringBuilder;

    .line 578
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->getViewMode()Lcom/android/mail/ui/ViewMode;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getMode(Landroid/content/Context;Lcom/android/mail/ui/ViewMode;)I

    move-result v5

    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v1, v1, Lcom/android/mail/browse/ConversationItemViewModel;->folderDisplayer:Lcom/android/mail/browse/ConversationItemView$ConversationItemFolderDisplayer;

    if-eqz v1, :cond_c

    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v1, v1, Lcom/android/mail/browse/ConversationItemViewModel;->folderDisplayer:Lcom/android/mail/browse/ConversationItemView$ConversationItemFolderDisplayer;

    # getter for: Lcom/android/mail/browse/ConversationItemView$ConversationItemFolderDisplayer;->mFoldersCount:I
    invoke-static {v1}, Lcom/android/mail/browse/ConversationItemView$ConversationItemFolderDisplayer;->access$300(Lcom/android/mail/browse/ConversationItemView$ConversationItemFolderDisplayer;)I

    move-result v1

    if-lez v1, :cond_c

    move v1, v2

    :goto_5
    iget-object v2, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v2, v2, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    iget-boolean v2, v2, Lcom/android/mail/providers/Conversation;->hasAttachments:Z

    invoke-static {v0, v5, v1, v2}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getSubjectLength(Landroid/content/Context;IZZ)I

    move-result v3

    .line 582
    .local v3, "maxChars":I
    iget-object v11, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v1, v1, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    iget-object v1, v1, Lcom/android/mail/providers/Conversation;->conversationInfo:Lcom/android/mail/providers/ConversationInfo;

    iget-object v2, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v2, v2, Lcom/android/mail/browse/ConversationItemViewModel;->messageInfoString:Landroid/text/SpannableStringBuilder;

    invoke-virtual {v2}, Landroid/text/SpannableStringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {}, Lcom/android/mail/browse/ConversationItemView;->getParser()Lcom/google/android/common/html/parser/HtmlParser;

    move-result-object v4

    invoke-static {}, Lcom/android/mail/browse/ConversationItemView;->getBuilder()Lcom/google/android/common/html/parser/HtmlTreeBuilder;

    move-result-object v5

    invoke-static/range {v0 .. v5}, Lcom/android/mail/browse/SendersView;->format(Landroid/content/Context;Lcom/android/mail/providers/ConversationInfo;Ljava/lang/String;ILcom/google/android/common/html/parser/HtmlParser;Lcom/google/android/common/html/parser/HtmlTreeBuilder;)[Landroid/text/SpannableString;

    move-result-object v1

    iput-object v1, v11, Lcom/android/mail/browse/ConversationItemViewModel;->styledSenders:[Landroid/text/SpannableString;

    .line 589
    .end local v0    # "context":Landroid/content/Context;
    .end local v3    # "maxChars":I
    :goto_6
    const-string v1, "CCHV.sendersubj"

    invoke-static {v1}, Lcom/android/mail/browse/ConversationItemView;->pauseTimer(Ljava/lang/String;)V

    .line 590
    const-string v1, "CCHV.txtsbmps"

    invoke-static {v1}, Lcom/android/mail/browse/ConversationItemView;->pauseTimer(Ljava/lang/String;)V

    goto/16 :goto_0

    .restart local v9    # "personalLevel":I
    :cond_6
    move v7, v4

    .line 550
    goto/16 :goto_1

    .restart local v7    # "isImportant":Z
    :cond_7
    move v10, v4

    .line 552
    goto/16 :goto_2

    .line 555
    .restart local v10    # "useImportantMarkers":Z
    :cond_8
    sget-object v1, Lcom/android/mail/browse/ConversationItemView;->ONLY_TO_ME:Landroid/graphics/Bitmap;

    goto/16 :goto_3

    .line 557
    :cond_9
    if-ne v9, v2, :cond_b

    .line 558
    iget-object v5, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    if-eqz v10, :cond_a

    sget-object v1, Lcom/android/mail/browse/ConversationItemView;->IMPORTANT_TO_ME_AND_OTHERS:Landroid/graphics/Bitmap;

    :goto_7
    iput-object v1, v5, Lcom/android/mail/browse/ConversationItemViewModel;->personalLevelBitmap:Landroid/graphics/Bitmap;

    goto/16 :goto_4

    :cond_a
    sget-object v1, Lcom/android/mail/browse/ConversationItemView;->TO_ME_AND_OTHERS:Landroid/graphics/Bitmap;

    goto :goto_7

    .line 560
    :cond_b
    if-eqz v10, :cond_5

    .line 561
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    sget-object v5, Lcom/android/mail/browse/ConversationItemView;->IMPORTANT_TO_OTHERS:Landroid/graphics/Bitmap;

    iput-object v5, v1, Lcom/android/mail/browse/ConversationItemViewModel;->personalLevelBitmap:Landroid/graphics/Bitmap;

    goto/16 :goto_4

    .end local v7    # "isImportant":Z
    .end local v9    # "personalLevel":I
    .end local v10    # "useImportantMarkers":Z
    .restart local v0    # "context":Landroid/content/Context;
    :cond_c
    move v1, v4

    .line 578
    goto :goto_5

    .line 586
    .end local v0    # "context":Landroid/content/Context;
    :cond_d
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationItemView;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/android/mail/browse/SendersView;->formatSenders(Lcom/android/mail/browse/ConversationItemViewModel;Landroid/content/Context;)V

    goto :goto_6
.end method

.method private canFitFragment(III)Z
    .locals 4
    .param p1, "width"    # I
    .param p2, "line"    # I
    .param p3, "fixedWidth"    # I

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 676
    iget-object v2, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v2, v2, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sendersLineCount:I

    if-ne p2, v2, :cond_2

    .line 677
    add-int v2, p1, p3

    iget v3, p0, Lcom/android/mail/browse/ConversationItemView;->mSendersWidth:I

    if-gt v2, v3, :cond_1

    .line 679
    :cond_0
    :goto_0
    return v0

    :cond_1
    move v0, v1

    .line 677
    goto :goto_0

    .line 679
    :cond_2
    iget v2, p0, Lcom/android/mail/browse/ConversationItemView;->mSendersWidth:I

    if-le p1, v2, :cond_0

    move v0, v1

    goto :goto_0
.end method

.method private copyStyles([Landroid/text/style/CharacterStyle;Ljava/lang/CharSequence;)Landroid/text/SpannableString;
    .locals 4
    .param p1, "spans"    # [Landroid/text/style/CharacterStyle;
    .param p2, "newText"    # Ljava/lang/CharSequence;

    .prologue
    const/4 v3, 0x0

    .line 861
    new-instance v0, Landroid/text/SpannableString;

    invoke-direct {v0, p2}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 862
    .local v0, "s":Landroid/text/SpannableString;
    if-eqz p1, :cond_0

    array-length v1, p1

    if-lez v1, :cond_0

    .line 863
    aget-object v1, p1, v3

    invoke-virtual {v0}, Landroid/text/SpannableString;->length()I

    move-result v2

    invoke-virtual {v0, v1, v3, v2, v3}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 865
    :cond_0
    return-object v0
.end method

.method private createHeightAnimation(Z)Landroid/animation/ObjectAnimator;
    .locals 5

    .prologue
    const/4 v1, 0x0

    .line 1460
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationItemView;->getContext()Landroid/content/Context;

    move-result-object v0

    iget-object v2, p0, Lcom/android/mail/browse/ConversationItemView;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v2}, Lcom/android/mail/ui/ControllableActivity;->getViewMode()Lcom/android/mail/ui/ViewMode;

    move-result-object v2

    invoke-static {v0, v2}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getMinHeight(Landroid/content/Context;Lcom/android/mail/ui/ViewMode;)I

    move-result v0

    .line 1462
    if-eqz p1, :cond_0

    move v2, v1

    .line 1463
    :goto_0
    if-eqz p1, :cond_1

    .line 1464
    :goto_1
    const-string v3, "animatedHeight"

    const/4 v4, 0x2

    new-array v4, v4, [I

    aput v2, v4, v1

    const/4 v1, 0x1

    aput v0, v4, v1

    invoke-static {p0, v3, v4}, Landroid/animation/ObjectAnimator;->ofInt(Ljava/lang/Object;Ljava/lang/String;[I)Landroid/animation/ObjectAnimator;

    move-result-object v0

    .line 1465
    new-instance v1, Landroid/view/animation/DecelerateInterpolator;

    const/high16 v2, 0x40000000    # 2.0f

    invoke-direct {v1, v2}, Landroid/view/animation/DecelerateInterpolator;-><init>(F)V

    invoke-virtual {v0, v1}, Landroid/animation/ObjectAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    .line 1466
    sget v1, Lcom/android/mail/browse/ConversationItemView;->sShrinkAnimationDuration:I

    int-to-long v1, v1

    invoke-virtual {v0, v1, v2}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    .line 1467
    return-object v0

    :cond_0
    move v2, v0

    .line 1462
    goto :goto_0

    :cond_1
    move v0, v1

    .line 1463
    goto :goto_1
.end method

.method private createSubject(ZZ)Landroid/text/SpannableStringBuilder;
    .locals 9
    .param p1, "isUnread"    # Z
    .param p2, "activated"    # Z

    .prologue
    const/4 v7, 0x0

    const/16 v8, 0x21

    .line 635
    iget-object v5, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v5, v5, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    iget-object v5, v5, Lcom/android/mail/providers/Conversation;->subject:Ljava/lang/String;

    invoke-direct {p0, v5}, Lcom/android/mail/browse/ConversationItemView;->filterTag(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 636
    .local v2, "subject":Ljava/lang/String;
    iget-object v5, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v5, v5, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    invoke-virtual {v5}, Lcom/android/mail/providers/Conversation;->getSnippet()Ljava/lang/String;

    move-result-object v0

    .line 637
    .local v0, "snippet":Ljava/lang/String;
    if-eqz p2, :cond_3

    sget v3, Lcom/android/mail/browse/ConversationItemView;->sActivatedTextColor:I

    .line 639
    .local v3, "subjectColor":I
    :goto_0
    if-eqz p2, :cond_5

    sget v1, Lcom/android/mail/browse/ConversationItemView;->sActivatedTextColor:I

    .line 641
    .local v1, "snippetColor":I
    :goto_1
    iget-object v5, p0, Lcom/android/mail/browse/ConversationItemView;->mContext:Landroid/content/Context;

    invoke-static {v5, v2, v0}, Lcom/android/mail/providers/Conversation;->getSubjectAndSnippetForDisplay(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableStringBuilder;

    move-result-object v4

    .line 643
    .local v4, "subjectText":Landroid/text/SpannableStringBuilder;
    if-eqz p1, :cond_0

    .line 644
    new-instance v5, Landroid/text/style/StyleSpan;

    const/4 v6, 0x1

    invoke-direct {v5, v6}, Landroid/text/style/StyleSpan;-><init>(I)V

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v6

    invoke-virtual {v4, v5, v7, v6, v8}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 647
    :cond_0
    if-eqz v2, :cond_1

    .line 648
    new-instance v5, Landroid/text/style/ForegroundColorSpan;

    invoke-direct {v5, v3}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v6

    invoke-virtual {v4, v5, v7, v6, v8}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 651
    :cond_1
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_2

    .line 652
    new-instance v5, Landroid/text/style/ForegroundColorSpan;

    invoke-direct {v5, v1}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v6

    add-int/lit8 v6, v6, 0x1

    invoke-virtual {v4}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v7

    invoke-virtual {v4, v5, v6, v7, v8}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 655
    :cond_2
    return-object v4

    .line 637
    .end local v1    # "snippetColor":I
    .end local v3    # "subjectColor":I
    .end local v4    # "subjectText":Landroid/text/SpannableStringBuilder;
    :cond_3
    if-eqz p1, :cond_4

    sget v3, Lcom/android/mail/browse/ConversationItemView;->sSubjectTextColorUnead:I

    goto :goto_0

    :cond_4
    sget v3, Lcom/android/mail/browse/ConversationItemView;->sSubjectTextColorRead:I

    goto :goto_0

    .line 639
    .restart local v3    # "subjectColor":I
    :cond_5
    if-eqz p1, :cond_6

    sget v1, Lcom/android/mail/browse/ConversationItemView;->sSnippetTextColorUnread:I

    goto :goto_1

    :cond_6
    sget v1, Lcom/android/mail/browse/ConversationItemView;->sSnippetTextColorRead:I

    goto :goto_1
.end method

.method private createTranslateXAnimation(Z)Landroid/animation/ObjectAnimator;
    .locals 5

    .prologue
    const/4 v3, 0x0

    const/4 v0, 0x0

    .line 1436
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationItemView;->getListView()Lcom/android/mail/ui/SwipeableListView;

    move-result-object v1

    .line 1438
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Lcom/android/mail/ui/SwipeableListView;->getMeasuredWidth()I

    move-result v1

    move v2, v1

    .line 1439
    :goto_0
    if-eqz p1, :cond_1

    int-to-float v1, v2

    .line 1440
    :goto_1
    if-eqz p1, :cond_2

    .line 1441
    :goto_2
    const-string v2, "translationX"

    const/4 v4, 0x2

    new-array v4, v4, [F

    aput v1, v4, v3

    const/4 v1, 0x1

    aput v0, v4, v1

    invoke-static {p0, v2, v4}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v0

    .line 1442
    new-instance v1, Landroid/view/animation/DecelerateInterpolator;

    const/high16 v2, 0x40000000    # 2.0f

    invoke-direct {v1, v2}, Landroid/view/animation/DecelerateInterpolator;-><init>(F)V

    invoke-virtual {v0, v1}, Landroid/animation/ObjectAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    .line 1443
    sget v1, Lcom/android/mail/browse/ConversationItemView;->sSlideAnimationDuration:I

    int-to-long v1, v1

    invoke-virtual {v0, v1, v2}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    .line 1444
    return-object v0

    :cond_0
    move v2, v3

    .line 1438
    goto :goto_0

    :cond_1
    move v1, v0

    .line 1439
    goto :goto_1

    .line 1440
    :cond_2
    int-to-float v0, v2

    goto :goto_2
.end method

.method private drawSenders(Landroid/graphics/Canvas;)V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 1081
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v0, v0, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sendersX:I

    int-to-float v0, v0

    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v1, v1, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sendersY:I

    sget v2, Lcom/android/mail/browse/ConversationItemView;->sSendersTextViewTopPadding:I

    add-int/2addr v1, v2

    int-to-float v1, v1

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->translate(FF)V

    .line 1083
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    invoke-direct {p0}, Lcom/android/mail/browse/ConversationItemView;->getSendersTextView()Landroid/widget/TextView;

    move-result-object v1

    iput-object v1, v0, Lcom/android/mail/browse/ConversationItemViewModel;->sendersTextView:Landroid/widget/TextView;

    .line 1084
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v0, v0, Lcom/android/mail/browse/ConversationItemViewModel;->styledSendersString:Landroid/text/SpannableStringBuilder;

    if-eqz v0, :cond_0

    .line 1085
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationItemView;->isActivated()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-direct {p0}, Lcom/android/mail/browse/ConversationItemView;->showActivatedText()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1086
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v0, v0, Lcom/android/mail/browse/ConversationItemViewModel;->styledSendersString:Landroid/text/SpannableStringBuilder;

    sget-object v1, Lcom/android/mail/browse/ConversationItemView;->sActivatedTextSpan:Landroid/text/style/CharacterStyle;

    iget-object v2, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget v2, v2, Lcom/android/mail/browse/ConversationItemViewModel;->styledMessageInfoStringOffset:I

    const/16 v3, 0x21

    invoke-virtual {v0, v1, v4, v2, v3}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 1093
    :goto_0
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v0, v0, Lcom/android/mail/browse/ConversationItemViewModel;->sendersTextView:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v1, v1, Lcom/android/mail/browse/ConversationItemViewModel;->styledSendersString:Landroid/text/SpannableStringBuilder;

    sget-object v2, Landroid/widget/TextView$BufferType;->SPANNABLE:Landroid/widget/TextView$BufferType;

    invoke-virtual {v0, v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V

    .line 1095
    iget v0, p0, Lcom/android/mail/browse/ConversationItemView;->mSendersWidth:I

    const/high16 v1, 0x40000000    # 2.0f

    invoke-static {v0, v1}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v0

    .line 1096
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v1, v1, Lcom/android/mail/browse/ConversationItemViewModel;->sendersTextView:Landroid/widget/TextView;

    sget v2, Lcom/android/mail/browse/ConversationItemView;->sSendersTextViewHeight:I

    invoke-virtual {v1, v0, v2}, Landroid/widget/TextView;->measure(II)V

    .line 1097
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v0, v0, Lcom/android/mail/browse/ConversationItemViewModel;->sendersTextView:Landroid/widget/TextView;

    iget v1, p0, Lcom/android/mail/browse/ConversationItemView;->mSendersWidth:I

    sget v2, Lcom/android/mail/browse/ConversationItemView;->sSendersTextViewHeight:I

    invoke-virtual {v0, v4, v4, v1, v2}, Landroid/widget/TextView;->layout(IIII)V

    .line 1098
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v0, v0, Lcom/android/mail/browse/ConversationItemViewModel;->sendersTextView:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->draw(Landroid/graphics/Canvas;)V

    .line 1100
    :cond_0
    return-void

    .line 1090
    :cond_1
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v0, v0, Lcom/android/mail/browse/ConversationItemViewModel;->styledSendersString:Landroid/text/SpannableStringBuilder;

    sget-object v1, Lcom/android/mail/browse/ConversationItemView;->sActivatedTextSpan:Landroid/text/style/CharacterStyle;

    invoke-virtual {v0, v1}, Landroid/text/SpannableStringBuilder;->removeSpan(Ljava/lang/Object;)V

    goto :goto_0
.end method

.method private drawSubject(Landroid/graphics/Canvas;)V
    .locals 8

    .prologue
    const/4 v7, 0x0

    .line 1103
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationItemView;->getSubjectTextView()Landroid/widget/TextView;

    move-result-object v0

    .line 1104
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v1, v1, Lcom/android/mail/browse/ConversationItemViewCoordinates;->subjectWidth:I

    .line 1105
    invoke-virtual {v0}, Landroid/widget/TextView;->getLineHeight()I

    move-result v2

    mul-int/lit8 v2, v2, 0x2

    int-to-float v2, v2

    sget-object v3, Lcom/android/mail/browse/ConversationItemView;->sPaint:Landroid/text/TextPaint;

    invoke-virtual {v3}, Landroid/text/TextPaint;->descent()F

    move-result v3

    add-float/2addr v2, v3

    float-to-int v2, v2

    .line 1106
    sget-object v3, Lcom/android/mail/browse/ConversationItemView;->sPaint:Landroid/text/TextPaint;

    iget-object v4, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v4, v4, Lcom/android/mail/browse/ConversationItemViewCoordinates;->subjectFontSize:I

    int-to-float v4, v4

    invoke-virtual {v3, v4}, Landroid/text/TextPaint;->setTextSize(F)V

    .line 1107
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationItemView;->isActivated()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-direct {p0}, Lcom/android/mail/browse/ConversationItemView;->showActivatedText()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 1108
    iget-object v3, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v3, v3, Lcom/android/mail/browse/ConversationItemViewModel;->subjectText:Landroid/text/SpannableStringBuilder;

    sget-object v4, Lcom/android/mail/browse/ConversationItemView;->sActivatedTextSpan:Landroid/text/style/CharacterStyle;

    iget-object v5, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v5, v5, Lcom/android/mail/browse/ConversationItemViewModel;->subjectText:Landroid/text/SpannableStringBuilder;

    invoke-virtual {v5}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v5

    const/16 v6, 0x21

    invoke-virtual {v3, v4, v7, v5, v6}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 1114
    :goto_0
    iget-object v3, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v3, v3, Lcom/android/mail/browse/ConversationItemViewCoordinates;->subjectX:I

    int-to-float v3, v3

    iget-object v4, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v4, v4, Lcom/android/mail/browse/ConversationItemViewCoordinates;->subjectY:I

    sget v5, Lcom/android/mail/browse/ConversationItemView;->sSendersTextViewTopPadding:I

    add-int/2addr v4, v5

    int-to-float v4, v4

    invoke-virtual {p1, v3, v4}, Landroid/graphics/Canvas;->translate(FF)V

    .line 1116
    iget-object v3, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v3, v3, Lcom/android/mail/browse/ConversationItemViewModel;->subjectText:Landroid/text/SpannableStringBuilder;

    sget-object v4, Landroid/widget/TextView$BufferType;->SPANNABLE:Landroid/widget/TextView$BufferType;

    invoke-virtual {v0, v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V

    .line 1117
    const/high16 v3, 0x40000000    # 2.0f

    invoke-static {v1, v3}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v3

    invoke-virtual {v0, v3, v2}, Landroid/widget/TextView;->measure(II)V

    .line 1120
    invoke-virtual {v0, v7, v7, v1, v2}, Landroid/widget/TextView;->layout(IIII)V

    .line 1121
    invoke-virtual {v0, p1}, Landroid/widget/TextView;->draw(Landroid/graphics/Canvas;)V

    .line 1122
    return-void

    .line 1112
    :cond_0
    iget-object v3, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v3, v3, Lcom/android/mail/browse/ConversationItemViewModel;->subjectText:Landroid/text/SpannableStringBuilder;

    sget-object v4, Lcom/android/mail/browse/ConversationItemView;->sActivatedTextSpan:Landroid/text/style/CharacterStyle;

    invoke-virtual {v3, v4}, Landroid/text/SpannableStringBuilder;->removeSpan(Ljava/lang/Object;)V

    goto :goto_0
.end method

.method private drawText(Landroid/graphics/Canvas;Ljava/lang/CharSequence;IILandroid/text/TextPaint;)V
    .locals 7
    .param p1, "canvas"    # Landroid/graphics/Canvas;
    .param p2, "s"    # Ljava/lang/CharSequence;
    .param p3, "x"    # I
    .param p4, "y"    # I
    .param p5, "paint"    # Landroid/text/TextPaint;

    .prologue
    .line 1146
    const/4 v2, 0x0

    invoke-interface {p2}, Ljava/lang/CharSequence;->length()I

    move-result v3

    int-to-float v4, p3

    int-to-float v5, p4

    move-object v0, p1

    move-object v1, p2

    move-object v6, p5

    invoke-virtual/range {v0 .. v6}, Landroid/graphics/Canvas;->drawText(Ljava/lang/CharSequence;IIFFLandroid/graphics/Paint;)V

    .line 1147
    return-void
.end method

.method private ellipsize(II)I
    .locals 18
    .param p1, "fixedWidth"    # I
    .param p2, "sendersY"    # I

    .prologue
    .line 869
    const/4 v12, 0x0

    .line 870
    .local v12, "totalWidth":I
    const/4 v2, 0x1

    .line 871
    .local v2, "currentLine":I
    const/4 v3, 0x0

    .line 872
    .local v3, "ellipsize":Z
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v14, v14, Lcom/android/mail/browse/ConversationItemViewModel;->senderFragments:Ljava/util/ArrayList;

    invoke-virtual {v14}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v6

    .local v6, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v14

    if-eqz v14, :cond_8

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/android/mail/browse/ConversationItemViewModel$SenderFragment;

    .line 873
    .local v8, "senderFragment":Lcom/android/mail/browse/ConversationItemViewModel$SenderFragment;
    iget-object v11, v8, Lcom/android/mail/browse/ConversationItemViewModel$SenderFragment;->style:Landroid/text/style/CharacterStyle;

    .line 874
    .local v11, "style":Landroid/text/style/CharacterStyle;
    iget v10, v8, Lcom/android/mail/browse/ConversationItemViewModel$SenderFragment;->start:I

    .line 875
    .local v10, "start":I
    iget v4, v8, Lcom/android/mail/browse/ConversationItemViewModel$SenderFragment;->end:I

    .line 876
    .local v4, "end":I
    iget v13, v8, Lcom/android/mail/browse/ConversationItemViewModel$SenderFragment;->width:I

    .line 877
    .local v13, "width":I
    iget-boolean v7, v8, Lcom/android/mail/browse/ConversationItemViewModel$SenderFragment;->isFixed:Z

    .line 878
    .local v7, "isFixed":Z
    sget-object v14, Lcom/android/mail/browse/ConversationItemView;->sPaint:Landroid/text/TextPaint;

    invoke-virtual {v11, v14}, Landroid/text/style/CharacterStyle;->updateDrawState(Landroid/text/TextPaint;)V

    .line 881
    if-eqz v3, :cond_0

    if-nez v7, :cond_0

    .line 882
    const/4 v14, 0x0

    iput-boolean v14, v8, Lcom/android/mail/browse/ConversationItemViewModel$SenderFragment;->shouldDisplay:Z

    goto :goto_0

    .line 887
    :cond_0
    const/4 v14, 0x0

    iput-object v14, v8, Lcom/android/mail/browse/ConversationItemViewModel$SenderFragment;->ellipsizedText:Ljava/lang/String;

    .line 888
    if-eqz v7, :cond_1

    .line 889
    sub-int p1, p1, v13

    .line 891
    :cond_1
    add-int v14, v12, v13

    move-object/from16 v0, p0

    move/from16 v1, p1

    invoke-direct {v0, v14, v2, v1}, Lcom/android/mail/browse/ConversationItemView;->canFitFragment(III)Z

    move-result v14

    if-nez v14, :cond_4

    .line 894
    if-nez v12, :cond_5

    .line 895
    const/4 v3, 0x1

    .line 912
    :cond_2
    :goto_1
    if-eqz v3, :cond_4

    .line 913
    move-object/from16 v0, p0

    iget v14, v0, Lcom/android/mail/browse/ConversationItemView;->mSendersWidth:I

    sub-int v13, v14, v12

    .line 916
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v14, v14, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sendersLineCount:I

    if-ne v2, v14, :cond_3

    .line 917
    sub-int v13, v13, p1

    .line 919
    :cond_3
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v14, v14, Lcom/android/mail/browse/ConversationItemViewModel;->sendersText:Ljava/lang/String;

    invoke-virtual {v14, v10, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v14

    sget-object v15, Lcom/android/mail/browse/ConversationItemView;->sPaint:Landroid/text/TextPaint;

    int-to-float v0, v13

    move/from16 v16, v0

    sget-object v17, Landroid/text/TextUtils$TruncateAt;->END:Landroid/text/TextUtils$TruncateAt;

    invoke-static/range {v14 .. v17}, Landroid/text/TextUtils;->ellipsize(Ljava/lang/CharSequence;Landroid/text/TextPaint;FLandroid/text/TextUtils$TruncateAt;)Ljava/lang/CharSequence;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v14

    iput-object v14, v8, Lcom/android/mail/browse/ConversationItemViewModel$SenderFragment;->ellipsizedText:Ljava/lang/String;

    .line 922
    sget-object v14, Lcom/android/mail/browse/ConversationItemView;->sPaint:Landroid/text/TextPaint;

    iget-object v15, v8, Lcom/android/mail/browse/ConversationItemViewModel$SenderFragment;->ellipsizedText:Ljava/lang/String;

    invoke-virtual {v14, v15}, Landroid/text/TextPaint;->measureText(Ljava/lang/String;)F

    move-result v14

    float-to-int v13, v14

    .line 925
    :cond_4
    const/4 v14, 0x1

    iput-boolean v14, v8, Lcom/android/mail/browse/ConversationItemViewModel$SenderFragment;->shouldDisplay:Z

    .line 926
    add-int/2addr v12, v13

    .line 929
    iget-object v14, v8, Lcom/android/mail/browse/ConversationItemViewModel$SenderFragment;->ellipsizedText:Ljava/lang/String;

    if-eqz v14, :cond_7

    .line 930
    iget-object v5, v8, Lcom/android/mail/browse/ConversationItemViewModel$SenderFragment;->ellipsizedText:Ljava/lang/String;

    .line 934
    .local v5, "fragmentDisplayText":Ljava/lang/CharSequence;
    :goto_2
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v14, v14, Lcom/android/mail/browse/ConversationItemViewModel;->sendersDisplayText:Landroid/text/SpannableStringBuilder;

    invoke-virtual {v14}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v9

    .line 935
    .local v9, "spanStart":I
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v14, v14, Lcom/android/mail/browse/ConversationItemViewModel;->sendersDisplayText:Landroid/text/SpannableStringBuilder;

    invoke-virtual {v14, v5}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 936
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v14, v14, Lcom/android/mail/browse/ConversationItemViewModel;->sendersDisplayText:Landroid/text/SpannableStringBuilder;

    iget-object v15, v8, Lcom/android/mail/browse/ConversationItemViewModel$SenderFragment;->style:Landroid/text/style/CharacterStyle;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    iget-object v0, v0, Lcom/android/mail/browse/ConversationItemViewModel;->sendersDisplayText:Landroid/text/SpannableStringBuilder;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v16

    const/16 v17, 0x21

    move/from16 v0, v16

    move/from16 v1, v17

    invoke-virtual {v14, v15, v9, v0, v1}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    goto/16 :goto_0

    .line 898
    .end local v5    # "fragmentDisplayText":Ljava/lang/CharSequence;
    .end local v9    # "spanStart":I
    :cond_5
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v14, v14, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sendersLineCount:I

    if-ge v2, v14, :cond_6

    .line 899
    add-int/lit8 v2, v2, 0x1

    .line 900
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v14, v14, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sendersLineHeight:I

    add-int p2, p2, v14

    .line 901
    const/4 v12, 0x0

    .line 904
    add-int v14, v12, v13

    move-object/from16 v0, p0

    iget v15, v0, Lcom/android/mail/browse/ConversationItemView;->mSendersWidth:I

    if-le v14, v15, :cond_2

    .line 905
    const/4 v3, 0x1

    goto/16 :goto_1

    .line 908
    :cond_6
    const/4 v3, 0x1

    goto/16 :goto_1

    .line 932
    :cond_7
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v14, v14, Lcom/android/mail/browse/ConversationItemViewModel;->sendersText:Ljava/lang/String;

    invoke-virtual {v14, v10, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v5

    .restart local v5    # "fragmentDisplayText":Ljava/lang/CharSequence;
    goto :goto_2

    .line 939
    .end local v4    # "end":I
    .end local v5    # "fragmentDisplayText":Ljava/lang/CharSequence;
    .end local v7    # "isFixed":Z
    .end local v8    # "senderFragment":Lcom/android/mail/browse/ConversationItemViewModel$SenderFragment;
    .end local v10    # "start":I
    .end local v11    # "style":Landroid/text/style/CharacterStyle;
    .end local v13    # "width":I
    :cond_8
    return v12
.end method

.method private ellipsizeStyledSenders()I
    .locals 14

    .prologue
    .line 780
    new-instance v7, Landroid/text/SpannableStringBuilder;

    invoke-direct {v7}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 781
    const/4 v1, 0x0

    .line 782
    const/4 v3, 0x0

    .line 784
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v8, v0, Lcom/android/mail/browse/ConversationItemViewModel;->messageInfoString:Landroid/text/SpannableStringBuilder;

    .line 785
    invoke-virtual {v8}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v0

    if-lez v0, :cond_c

    .line 786
    const/4 v0, 0x0

    invoke-virtual {v8}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v2

    const-class v4, Landroid/text/style/CharacterStyle;

    invoke-virtual {v8, v0, v2, v4}, Landroid/text/SpannableStringBuilder;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroid/text/style/CharacterStyle;

    .line 790
    array-length v2, v0

    if-lez v2, :cond_0

    .line 791
    const/4 v2, 0x0

    aget-object v0, v0, v2

    sget-object v2, Lcom/android/mail/browse/ConversationItemView;->sPaint:Landroid/text/TextPaint;

    invoke-virtual {v0, v2}, Landroid/text/style/CharacterStyle;->updateDrawState(Landroid/text/TextPaint;)V

    .line 794
    :cond_0
    sget-object v0, Lcom/android/mail/browse/ConversationItemView;->sPaint:Landroid/text/TextPaint;

    invoke-virtual {v8}, Landroid/text/SpannableStringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/text/TextPaint;->measureText(Ljava/lang/String;)F

    move-result v0

    .line 795
    add-float/2addr v0, v1

    .line 797
    :goto_0
    const/4 v2, 0x0

    .line 799
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v9, v1, Lcom/android/mail/browse/ConversationItemViewModel;->styledSenders:[Landroid/text/SpannableString;

    array-length v10, v9

    const/4 v1, 0x0

    move v5, v1

    move v4, v0

    move-object v1, v2

    :goto_1
    if-ge v5, v10, :cond_2

    aget-object v2, v9, v5

    .line 801
    if-nez v2, :cond_1

    move-object v2, v1

    move v0, v3

    move v1, v4

    .line 799
    :goto_2
    add-int/lit8 v3, v5, 0x1

    move v5, v3

    move v4, v1

    move v3, v0

    move-object v1, v2

    goto :goto_1

    .line 805
    :cond_1
    if-eqz v3, :cond_4

    .line 852
    :cond_2
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    invoke-virtual {v7}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v1

    iput v1, v0, Lcom/android/mail/browse/ConversationItemViewModel;->styledMessageInfoStringOffset:I

    .line 853
    if-eqz v8, :cond_3

    .line 854
    invoke-virtual {v7, v8}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 856
    :cond_3
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iput-object v7, v0, Lcom/android/mail/browse/ConversationItemViewModel;->styledSendersString:Landroid/text/SpannableStringBuilder;

    .line 857
    float-to-int v0, v4

    return v0

    .line 808
    :cond_4
    const/4 v0, 0x0

    invoke-virtual {v2}, Landroid/text/SpannableString;->length()I

    move-result v6

    const-class v11, Landroid/text/style/CharacterStyle;

    invoke-virtual {v2, v0, v6, v11}, Landroid/text/SpannableString;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroid/text/style/CharacterStyle;

    .line 810
    array-length v6, v0

    if-lez v6, :cond_5

    .line 811
    const/4 v6, 0x0

    aget-object v6, v0, v6

    sget-object v11, Lcom/android/mail/browse/ConversationItemView;->sPaint:Landroid/text/TextPaint;

    invoke-virtual {v6, v11}, Landroid/text/style/CharacterStyle;->updateDrawState(Landroid/text/TextPaint;)V

    .line 815
    :cond_5
    sget-object v6, Lcom/android/mail/browse/SendersView;->sElidedString:Ljava/lang/CharSequence;

    invoke-virtual {v2}, Landroid/text/SpannableString;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v6, v11}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_8

    .line 817
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v6, Lcom/android/mail/browse/ConversationItemView;->sElidedPaddingToken:Ljava/lang/String;

    invoke-virtual {v1, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v6, Lcom/android/mail/browse/ConversationItemView;->sElidedPaddingToken:Ljava/lang/String;

    invoke-virtual {v1, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/android/mail/browse/ConversationItemView;->copyStyles([Landroid/text/style/CharacterStyle;Ljava/lang/CharSequence;)Landroid/text/SpannableString;

    move-result-object v1

    .line 826
    :goto_3
    array-length v6, v0

    if-lez v6, :cond_6

    .line 827
    const/4 v6, 0x0

    aget-object v6, v0, v6

    sget-object v11, Lcom/android/mail/browse/ConversationItemView;->sPaint:Landroid/text/TextPaint;

    invoke-virtual {v6, v11}, Landroid/text/style/CharacterStyle;->updateDrawState(Landroid/text/TextPaint;)V

    .line 830
    :cond_6
    sget-object v6, Lcom/android/mail/browse/ConversationItemView;->sPaint:Landroid/text/TextPaint;

    invoke-virtual {v1}, Landroid/text/SpannableString;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v6, v11}, Landroid/text/TextPaint;->measureText(Ljava/lang/String;)F

    move-result v6

    float-to-int v6, v6

    int-to-float v6, v6

    .line 831
    add-float v11, v6, v4

    iget v12, p0, Lcom/android/mail/browse/ConversationItemView;->mSendersWidth:I

    int-to-float v12, v12

    cmpl-float v11, v11, v12

    if-lez v11, :cond_b

    .line 834
    const/4 v6, 0x1

    .line 835
    iget v3, p0, Lcom/android/mail/browse/ConversationItemView;->mSendersWidth:I

    int-to-float v3, v3

    sub-float/2addr v3, v4

    .line 836
    sget-object v11, Lcom/android/mail/browse/ConversationItemView;->sPaint:Landroid/text/TextPaint;

    sget-object v12, Landroid/text/TextUtils$TruncateAt;->END:Landroid/text/TextUtils$TruncateAt;

    invoke-static {v1, v11, v3, v12}, Landroid/text/TextUtils;->ellipsize(Ljava/lang/CharSequence;Landroid/text/TextPaint;FLandroid/text/TextUtils$TruncateAt;)Ljava/lang/CharSequence;

    move-result-object v3

    invoke-direct {p0, v0, v3}, Lcom/android/mail/browse/ConversationItemView;->copyStyles([Landroid/text/style/CharacterStyle;Ljava/lang/CharSequence;)Landroid/text/SpannableString;

    move-result-object v0

    .line 838
    sget-object v3, Lcom/android/mail/browse/ConversationItemView;->sPaint:Landroid/text/TextPaint;

    invoke-virtual {v0}, Landroid/text/SpannableString;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v3, v11}, Landroid/text/TextPaint;->measureText(Ljava/lang/String;)F

    move-result v3

    float-to-int v3, v3

    int-to-float v3, v3

    move v13, v3

    move v3, v6

    move v6, v13

    .line 842
    :goto_4
    add-float/2addr v4, v6

    .line 845
    if-eqz v0, :cond_7

    move-object v1, v0

    .line 850
    :cond_7
    invoke-virtual {v7, v1}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    move v0, v3

    move v1, v4

    goto/16 :goto_2

    .line 818
    :cond_8
    invoke-virtual {v7}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v6

    if-lez v6, :cond_a

    if-eqz v1, :cond_9

    sget-object v6, Lcom/android/mail/browse/SendersView;->sElidedString:Ljava/lang/CharSequence;

    invoke-virtual {v1}, Landroid/text/SpannableString;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v6, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_a

    .line 822
    :cond_9
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v6, Lcom/android/mail/browse/ConversationItemView;->sSendersSplitToken:Ljava/lang/String;

    invoke-virtual {v1, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/android/mail/browse/ConversationItemView;->copyStyles([Landroid/text/style/CharacterStyle;Ljava/lang/CharSequence;)Landroid/text/SpannableString;

    move-result-object v1

    goto :goto_3

    :cond_a
    move-object v1, v2

    .line 824
    goto :goto_3

    .line 840
    :cond_b
    const/4 v0, 0x0

    goto :goto_4

    :cond_c
    move v0, v1

    goto/16 :goto_0
.end method

.method private filterTag(Ljava/lang/String;)Ljava/lang/String;
    .locals 7

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 948
    .line 949
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationItemView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0c0097

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 950
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-virtual {p1, v5}, Ljava/lang/String;->charAt(I)C

    move-result v1

    const/16 v2, 0x5b

    if-ne v1, v2, :cond_0

    .line 951
    const/16 v1, 0x5d

    invoke-virtual {p1, v1}, Ljava/lang/String;->indexOf(I)I

    move-result v1

    .line 952
    if-lez v1, :cond_0

    .line 953
    invoke-virtual {p1, v6, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    .line 954
    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x7

    invoke-static {v2, v4}, Lcom/android/mail/utils/Utils;->ellipsize(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v3, v5

    add-int/lit8 v1, v1, 0x1

    invoke-virtual {p1, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v3, v6

    invoke-static {v0, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    .line 958
    :cond_0
    return-object p1
.end method

.method private static getBuilder()Lcom/google/android/common/html/parser/HtmlTreeBuilder;
    .locals 1

    .prologue
    .line 594
    sget-object v0, Lcom/android/mail/browse/ConversationItemView;->sHtmlBuilder:Lcom/google/android/common/html/parser/HtmlTreeBuilder;

    if-nez v0, :cond_0

    .line 595
    new-instance v0, Lcom/google/android/common/html/parser/HtmlTreeBuilder;

    invoke-direct {v0}, Lcom/google/android/common/html/parser/HtmlTreeBuilder;-><init>()V

    sput-object v0, Lcom/android/mail/browse/ConversationItemView;->sHtmlBuilder:Lcom/google/android/common/html/parser/HtmlTreeBuilder;

    .line 597
    :cond_0
    sget-object v0, Lcom/android/mail/browse/ConversationItemView;->sHtmlBuilder:Lcom/google/android/common/html/parser/HtmlTreeBuilder;

    return-object v0
.end method

.method private getDateBackground(Z)Landroid/graphics/Bitmap;
    .locals 5
    .param p1, "hasAttachments"    # Z

    .prologue
    const/4 v4, 0x0

    .line 1129
    if-eqz p1, :cond_1

    iget v1, p0, Lcom/android/mail/browse/ConversationItemView;->mPaperclipX:I

    :goto_0
    sget v2, Lcom/android/mail/browse/ConversationItemView;->sDateBackgroundPaddingLeft:I

    sub-int v0, v1, v2

    .line 1130
    .local v0, "leftOffset":I
    if-eqz p1, :cond_2

    .line 1131
    sget-object v1, Lcom/android/mail/browse/ConversationItemView;->sDateBackgroundAttachment:Landroid/graphics/Bitmap;

    if-nez v1, :cond_0

    .line 1132
    sget-object v1, Lcom/android/mail/browse/ConversationItemView;->DATE_BACKGROUND:Landroid/graphics/Bitmap;

    iget v2, p0, Lcom/android/mail/browse/ConversationItemView;->mViewWidth:I

    sub-int/2addr v2, v0

    sget v3, Lcom/android/mail/browse/ConversationItemView;->sDateBackgroundHeight:I

    invoke-static {v1, v2, v3, v4}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v1

    sput-object v1, Lcom/android/mail/browse/ConversationItemView;->sDateBackgroundAttachment:Landroid/graphics/Bitmap;

    .line 1135
    :cond_0
    sget-object v1, Lcom/android/mail/browse/ConversationItemView;->sDateBackgroundAttachment:Landroid/graphics/Bitmap;

    .line 1141
    :goto_1
    return-object v1

    .line 1129
    .end local v0    # "leftOffset":I
    :cond_1
    iget v1, p0, Lcom/android/mail/browse/ConversationItemView;->mDateX:I

    goto :goto_0

    .line 1137
    .restart local v0    # "leftOffset":I
    :cond_2
    sget-object v1, Lcom/android/mail/browse/ConversationItemView;->sDateBackgroundNoAttachment:Landroid/graphics/Bitmap;

    if-nez v1, :cond_3

    .line 1138
    sget-object v1, Lcom/android/mail/browse/ConversationItemView;->DATE_BACKGROUND:Landroid/graphics/Bitmap;

    iget v2, p0, Lcom/android/mail/browse/ConversationItemView;->mViewWidth:I

    sub-int/2addr v2, v0

    sget v3, Lcom/android/mail/browse/ConversationItemView;->sDateBackgroundHeight:I

    invoke-static {v1, v2, v3, v4}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v1

    sput-object v1, Lcom/android/mail/browse/ConversationItemView;->sDateBackgroundNoAttachment:Landroid/graphics/Bitmap;

    .line 1141
    :cond_3
    sget-object v1, Lcom/android/mail/browse/ConversationItemView;->sDateBackgroundNoAttachment:Landroid/graphics/Bitmap;

    goto :goto_1
.end method

.method private getFontColor(I)I
    .locals 2
    .param p1, "defaultColor"    # I

    .prologue
    .line 664
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationItemView;->isActivated()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-direct {p0}, Lcom/android/mail/browse/ConversationItemView;->showActivatedText()Z

    move-result v1

    if-eqz v1, :cond_1

    const/4 v0, 0x1

    .line 665
    .local v0, "isBackGroundBlue":Z
    :goto_0
    if-eqz v0, :cond_0

    sget p1, Lcom/android/mail/browse/ConversationItemView;->sActivatedTextColor:I

    .end local p1    # "defaultColor":I
    :cond_0
    return p1

    .line 664
    .end local v0    # "isBackGroundBlue":Z
    .restart local p1    # "defaultColor":I
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private getListView()Lcom/android/mail/ui/SwipeableListView;
    .locals 2

    .prologue
    .line 1370
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationItemView;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    check-cast v1, Lcom/android/mail/browse/SwipeableConversationItemView;

    invoke-virtual {v1}, Lcom/android/mail/browse/SwipeableConversationItemView;->getListView()Landroid/widget/ListView;

    move-result-object v0

    check-cast v0, Lcom/android/mail/ui/SwipeableListView;

    .line 1372
    .local v0, "v":Lcom/android/mail/ui/SwipeableListView;
    if-nez v0, :cond_0

    .line 1373
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mAdapter:Lcom/android/mail/ui/AnimatedAdapter;

    invoke-virtual {v1}, Lcom/android/mail/ui/AnimatedAdapter;->getListView()Lcom/android/mail/ui/SwipeableListView;

    move-result-object v0

    .line 1375
    :cond_0
    return-object v0
.end method

.method private static getPadding(II)I
    .locals 1
    .param p0, "space"    # I
    .param p1, "length"    # I

    .prologue
    .line 322
    sub-int v0, p0, p1

    div-int/lit8 v0, v0, 0x2

    return v0
.end method

.method private static getParser()Lcom/google/android/common/html/parser/HtmlParser;
    .locals 1

    .prologue
    .line 601
    sget-object v0, Lcom/android/mail/browse/ConversationItemView;->sHtmlParser:Lcom/google/android/common/html/parser/HtmlParser;

    if-nez v0, :cond_0

    .line 602
    new-instance v0, Lcom/google/android/common/html/parser/HtmlParser;

    invoke-direct {v0}, Lcom/google/android/common/html/parser/HtmlParser;-><init>()V

    sput-object v0, Lcom/android/mail/browse/ConversationItemView;->sHtmlParser:Lcom/google/android/common/html/parser/HtmlParser;

    .line 604
    :cond_0
    sget-object v0, Lcom/android/mail/browse/ConversationItemView;->sHtmlParser:Lcom/google/android/common/html/parser/HtmlParser;

    return-object v0
.end method

.method private getSendersTextView()Landroid/widget/TextView;
    .locals 3

    .prologue
    const/4 v2, -0x2

    .line 608
    sget-object v1, Lcom/android/mail/browse/ConversationItemView;->sSendersTextView:Landroid/widget/TextView;

    if-nez v1, :cond_0

    .line 609
    new-instance v0, Landroid/widget/TextView;

    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    .line 610
    .local v0, "sendersTextView":Landroid/widget/TextView;
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setMaxLines(I)V

    .line 611
    sget-object v1, Landroid/text/TextUtils$TruncateAt;->END:Landroid/text/TextUtils$TruncateAt;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V

    .line 612
    new-instance v1, Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {v1, v2, v2}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 614
    sput-object v0, Lcom/android/mail/browse/ConversationItemView;->sSendersTextView:Landroid/widget/TextView;

    .line 616
    .end local v0    # "sendersTextView":Landroid/widget/TextView;
    :cond_0
    sget-object v1, Lcom/android/mail/browse/ConversationItemView;->sSendersTextView:Landroid/widget/TextView;

    return-object v1
.end method

.method private getStarBitmap()Landroid/graphics/Bitmap;
    .locals 1

    .prologue
    .line 1125
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v0, v0, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    iget-boolean v0, v0, Lcom/android/mail/providers/Conversation;->starred:Z

    if-eqz v0, :cond_0

    sget-object v0, Lcom/android/mail/browse/ConversationItemView;->STAR_ON:Landroid/graphics/Bitmap;

    :goto_0
    return-object v0

    :cond_0
    sget-object v0, Lcom/android/mail/browse/ConversationItemView;->STAR_OFF:Landroid/graphics/Bitmap;

    goto :goto_0
.end method

.method private getSubjectTextView()Landroid/widget/TextView;
    .locals 3

    .prologue
    const/4 v2, -0x2

    .line 620
    sget-object v1, Lcom/android/mail/browse/ConversationItemView;->sSubjectTextView:Landroid/widget/TextView;

    if-nez v1, :cond_0

    .line 621
    new-instance v0, Landroid/widget/TextView;

    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    .line 622
    .local v0, "subjectTextView":Landroid/widget/TextView;
    sget-object v1, Landroid/text/TextUtils$TruncateAt;->END:Landroid/text/TextUtils$TruncateAt;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V

    .line 623
    new-instance v1, Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {v1, v2, v2}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 625
    sput-object v0, Lcom/android/mail/browse/ConversationItemView;->sSubjectTextView:Landroid/widget/TextView;

    .line 627
    .end local v0    # "subjectTextView":Landroid/widget/TextView;
    :cond_0
    sget-object v1, Lcom/android/mail/browse/ConversationItemView;->sSubjectTextView:Landroid/widget/TextView;

    return-object v1
.end method

.method private isTouchInCheckmark(FF)Z
    .locals 2
    .param p1, "x"    # F
    .param p2, "y"    # F

    .prologue
    .line 1254
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-boolean v0, v0, Lcom/android/mail/browse/ConversationItemViewModel;->checkboxVisible:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v0, v0, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sendersX:I

    sget v1, Lcom/android/mail/browse/ConversationItemView;->sTouchSlop:I

    add-int/2addr v0, v1

    int-to-float v0, v0

    cmpg-float v0, p1, v0

    if-gez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private isTouchInStar(FF)Z
    .locals 2
    .param p1, "x"    # F
    .param p2, "y"    # F

    .prologue
    .line 1259
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v0, v0, Lcom/android/mail/browse/ConversationItemViewCoordinates;->starX:I

    sget v1, Lcom/android/mail/browse/ConversationItemView;->sTouchSlop:I

    sub-int/2addr v0, v1

    int-to-float v0, v0

    cmpl-float v0, p1, v0

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private layoutSubjectSpans(Z)V
    .locals 2
    .param p1, "isUnread"    # Z

    .prologue
    .line 631
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    const/4 v1, 0x0

    invoke-direct {p0, p1, v1}, Lcom/android/mail/browse/ConversationItemView;->createSubject(ZZ)Landroid/text/SpannableStringBuilder;

    move-result-object v1

    iput-object v1, v0, Lcom/android/mail/browse/ConversationItemViewModel;->subjectText:Landroid/text/SpannableStringBuilder;

    .line 632
    return-void
.end method

.method private measureHeight(II)I
    .locals 4

    .prologue
    .line 1502
    .line 1503
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v2

    .line 1504
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v0

    .line 1506
    const/high16 v1, 0x40000000    # 2.0f

    if-ne v2, v1, :cond_0

    .line 1518
    :goto_0
    return v0

    .line 1511
    :cond_0
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mContext:Landroid/content/Context;

    invoke-static {v1, p2}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getHeight(Landroid/content/Context;I)I

    move-result v1

    .line 1512
    const/high16 v3, -0x80000000

    if-ne v2, v3, :cond_1

    .line 1515
    invoke-static {v1, v0}, Ljava/lang/Math;->min(II)I

    move-result v0

    goto :goto_0

    :cond_1
    move v0, v1

    goto :goto_0
.end method

.method private onTouchEventNoSwipe(Landroid/view/MotionEvent;)Z
    .locals 5
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 1276
    const/4 v0, 0x0

    .line 1278
    .local v0, "handled":Z
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v3

    float-to-int v1, v3

    .line 1279
    .local v1, "x":I
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v3

    float-to-int v2, v3

    .line 1280
    .local v2, "y":I
    iput v1, p0, Lcom/android/mail/browse/ConversationItemView;->mLastTouchX:I

    .line 1281
    iput v2, p0, Lcom/android/mail/browse/ConversationItemView;->mLastTouchY:I

    .line 1282
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v3

    packed-switch v3, :pswitch_data_0

    .line 1308
    :cond_0
    :goto_0
    :pswitch_0
    if-nez v0, :cond_1

    .line 1309
    invoke-super {p0, p1}, Landroid/view/View;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    .line 1312
    :cond_1
    return v0

    .line 1284
    :pswitch_1
    int-to-float v3, v1

    int-to-float v4, v2

    invoke-direct {p0, v3, v4}, Lcom/android/mail/browse/ConversationItemView;->isTouchInCheckmark(FF)Z

    move-result v3

    if-nez v3, :cond_2

    int-to-float v3, v1

    int-to-float v4, v2

    invoke-direct {p0, v3, v4}, Lcom/android/mail/browse/ConversationItemView;->isTouchInStar(FF)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 1285
    :cond_2
    const/4 v3, 0x1

    iput-boolean v3, p0, Lcom/android/mail/browse/ConversationItemView;->mDownEvent:Z

    .line 1286
    const/4 v0, 0x1

    goto :goto_0

    .line 1291
    :pswitch_2
    const/4 v3, 0x0

    iput-boolean v3, p0, Lcom/android/mail/browse/ConversationItemView;->mDownEvent:Z

    goto :goto_0

    .line 1295
    :pswitch_3
    iget-boolean v3, p0, Lcom/android/mail/browse/ConversationItemView;->mDownEvent:Z

    if-eqz v3, :cond_0

    .line 1296
    int-to-float v3, v1

    int-to-float v4, v2

    invoke-direct {p0, v3, v4}, Lcom/android/mail/browse/ConversationItemView;->isTouchInCheckmark(FF)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 1298
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationItemView;->toggleCheckMark()V

    .line 1303
    :cond_3
    :goto_1
    const/4 v0, 0x1

    goto :goto_0

    .line 1299
    :cond_4
    int-to-float v3, v1

    int-to-float v4, v2

    invoke-direct {p0, v3, v4}, Lcom/android/mail/browse/ConversationItemView;->isTouchInStar(FF)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 1301
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationItemView;->toggleStar()V

    goto :goto_1

    .line 1282
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_3
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method private static pauseTimer(Ljava/lang/String;)V
    .locals 1
    .param p0, "tag"    # Ljava/lang/String;

    .prologue
    .line 446
    sget-object v0, Lcom/android/mail/browse/ConversationItemView;->sTimer:Lcom/android/mail/perf/Timer;

    if-eqz v0, :cond_0

    .line 447
    sget-object v0, Lcom/android/mail/browse/ConversationItemView;->sTimer:Lcom/android/mail/perf/Timer;

    invoke-virtual {v0, p0}, Lcom/android/mail/perf/Timer;->pause(Ljava/lang/String;)V

    .line 449
    :cond_0
    return-void
.end method

.method private setCheckedActivatedBackground()V
    .locals 1

    .prologue
    .line 1189
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationItemView;->isActivated()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/android/mail/browse/ConversationItemView;->mTabletDevice:Z

    if-eqz v0, :cond_0

    .line 1190
    const v0, 0x7f020073

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/ConversationItemView;->setBackgroundResource(I)V

    .line 1194
    :goto_0
    return-void

    .line 1192
    :cond_0
    const v0, 0x7f020084

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/ConversationItemView;->setBackgroundResource(I)V

    goto :goto_0
.end method

.method private setContentDescription()V
    .locals 2

    .prologue
    .line 493
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->isAccessibilityEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 494
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationItemViewModel;->resetContentDescription()V

    .line 495
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mContext:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/ConversationItemViewModel;->getContentDescription(Landroid/content/Context;)Ljava/lang/CharSequence;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/ConversationItemView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 497
    :cond_0
    return-void
.end method

.method private showActivatedText()Z
    .locals 3

    .prologue
    .line 671
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const/high16 v2, 0x7f0f0000

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getBoolean(I)Z

    move-result v0

    .line 672
    .local v0, "isListCollapsed":Z
    iget-boolean v1, p0, Lcom/android/mail/browse/ConversationItemView;->mTabletDevice:Z

    if-eqz v1, :cond_0

    if-nez v0, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private static startTimer(Ljava/lang/String;)V
    .locals 1
    .param p0, "tag"    # Ljava/lang/String;

    .prologue
    .line 440
    sget-object v0, Lcom/android/mail/browse/ConversationItemView;->sTimer:Lcom/android/mail/perf/Timer;

    if-eqz v0, :cond_0

    .line 441
    sget-object v0, Lcom/android/mail/browse/ConversationItemView;->sTimer:Lcom/android/mail/perf/Timer;

    invoke-virtual {v0, p0}, Lcom/android/mail/perf/Timer;->start(Ljava/lang/String;)V

    .line 443
    :cond_0
    return-void
.end method

.method private toggleCheckMark()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 1210
    iget-object v2, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v2, v2, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    if-eqz v2, :cond_2

    .line 1211
    iget-boolean v2, p0, Lcom/android/mail/browse/ConversationItemView;->mChecked:Z

    if-nez v2, :cond_3

    move v2, v3

    :goto_0
    iput-boolean v2, p0, Lcom/android/mail/browse/ConversationItemView;->mChecked:Z

    .line 1212
    iget-object v2, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v0, v2, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    .line 1214
    .local v0, "conv":Lcom/android/mail/providers/Conversation;
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationItemView;->getListView()Lcom/android/mail/ui/SwipeableListView;

    move-result-object v1

    .line 1215
    .local v1, "listView":Lcom/android/mail/ui/SwipeableListView;
    iget-boolean v2, p0, Lcom/android/mail/browse/ConversationItemView;->mChecked:Z

    if-eqz v2, :cond_4

    if-eqz v1, :cond_4

    invoke-virtual {v1, p0}, Lcom/android/mail/ui/SwipeableListView;->getPositionForView(Landroid/view/View;)I

    move-result v2

    :goto_1
    iput v2, v0, Lcom/android/mail/providers/Conversation;->position:I

    .line 1217
    iget-object v2, p0, Lcom/android/mail/browse/ConversationItemView;->mSelectedConversationSet:Lcom/android/mail/ui/ConversationSelectionSet;

    if-eqz v2, :cond_0

    .line 1218
    iget-object v2, p0, Lcom/android/mail/browse/ConversationItemView;->mSelectedConversationSet:Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-virtual {v2, p0, v0}, Lcom/android/mail/ui/ConversationSelectionSet;->toggle(Lcom/android/mail/browse/ConversationItemView;Lcom/android/mail/providers/Conversation;)V

    .line 1220
    :cond_0
    iget-object v2, p0, Lcom/android/mail/browse/ConversationItemView;->mSelectedConversationSet:Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-virtual {v2}, Lcom/android/mail/ui/ConversationSelectionSet;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 1221
    invoke-virtual {v1, v3}, Lcom/android/mail/ui/SwipeableListView;->commitDestructiveActions(Z)V

    .line 1227
    :cond_1
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationItemView;->requestLayout()V

    .line 1229
    .end local v0    # "conv":Lcom/android/mail/providers/Conversation;
    .end local v1    # "listView":Lcom/android/mail/ui/SwipeableListView;
    :cond_2
    return-void

    .line 1211
    :cond_3
    const/4 v2, 0x0

    goto :goto_0

    .line 1215
    .restart local v0    # "conv":Lcom/android/mail/providers/Conversation;
    .restart local v1    # "listView":Lcom/android/mail/ui/SwipeableListView;
    :cond_4
    const/4 v2, -0x1

    goto :goto_1
.end method

.method private updateBackground(Z)V
    .locals 2

    .prologue
    .line 1150
    iget v0, p0, Lcom/android/mail/browse/ConversationItemView;->mBackgroundOverride:I

    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    .line 1153
    iget v0, p0, Lcom/android/mail/browse/ConversationItemView;->mBackgroundOverride:I

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/ConversationItemView;->setBackgroundColor(I)V

    .line 1186
    :goto_0
    return-void

    .line 1156
    :cond_0
    iget-boolean v0, p0, Lcom/android/mail/browse/ConversationItemView;->mTabletDevice:Z

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getViewMode()Lcom/android/mail/ui/ViewMode;

    move-result-object v0

    invoke-virtual {v0}, Lcom/android/mail/ui/ViewMode;->isListMode()Z

    move-result v0

    if-eqz v0, :cond_1

    const/4 v0, 0x1

    .line 1157
    :goto_1
    if-eqz p1, :cond_5

    .line 1158
    if-eqz v0, :cond_3

    .line 1159
    iget-boolean v0, p0, Lcom/android/mail/browse/ConversationItemView;->mChecked:Z

    if-eqz v0, :cond_2

    .line 1160
    const v0, 0x7f02007b

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/ConversationItemView;->setBackgroundResource(I)V

    goto :goto_0

    .line 1156
    :cond_1
    const/4 v0, 0x0

    goto :goto_1

    .line 1162
    :cond_2
    const v0, 0x7f02001a

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/ConversationItemView;->setBackgroundResource(I)V

    goto :goto_0

    .line 1165
    :cond_3
    iget-boolean v0, p0, Lcom/android/mail/browse/ConversationItemView;->mChecked:Z

    if-eqz v0, :cond_4

    .line 1166
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationItemView;->setCheckedActivatedBackground()V

    goto :goto_0

    .line 1168
    :cond_4
    const v0, 0x7f020018

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/ConversationItemView;->setBackgroundResource(I)V

    goto :goto_0

    .line 1172
    :cond_5
    if-eqz v0, :cond_7

    .line 1173
    iget-boolean v0, p0, Lcom/android/mail/browse/ConversationItemView;->mChecked:Z

    if-eqz v0, :cond_6

    .line 1174
    const v0, 0x7f020077

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/ConversationItemView;->setBackgroundResource(I)V

    goto :goto_0

    .line 1176
    :cond_6
    const v0, 0x7f020019

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/ConversationItemView;->setBackgroundResource(I)V

    goto :goto_0

    .line 1179
    :cond_7
    iget-boolean v0, p0, Lcom/android/mail/browse/ConversationItemView;->mChecked:Z

    if-eqz v0, :cond_8

    .line 1180
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationItemView;->setCheckedActivatedBackground()V

    goto :goto_0

    .line 1182
    :cond_8
    const v0, 0x7f020017

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/ConversationItemView;->setBackgroundResource(I)V

    goto :goto_0
.end method


# virtual methods
.method public bind(Landroid/database/Cursor;Lcom/android/mail/ui/ControllableActivity;Lcom/android/mail/ui/ConversationSelectionSet;Lcom/android/mail/providers/Folder;ZZZLcom/android/mail/ui/AnimatedAdapter;)V
    .locals 9
    .param p1, "cursor"    # Landroid/database/Cursor;
    .param p2, "activity"    # Lcom/android/mail/ui/ControllableActivity;
    .param p3, "set"    # Lcom/android/mail/ui/ConversationSelectionSet;
    .param p4, "folder"    # Lcom/android/mail/providers/Folder;
    .param p5, "checkboxesDisabled"    # Z
    .param p6, "swipeEnabled"    # Z
    .param p7, "priorityArrowEnabled"    # Z
    .param p8, "adapter"    # Lcom/android/mail/ui/AnimatedAdapter;

    .prologue
    .line 397
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mAccount:Ljava/lang/String;

    invoke-static {v0, p1}, Lcom/android/mail/browse/ConversationItemViewModel;->forCursor(Ljava/lang/String;Landroid/database/Cursor;)Lcom/android/mail/browse/ConversationItemViewModel;

    move-result-object v1

    move-object v0, p0

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move v5, p5

    move v6, p6

    move/from16 v7, p7

    move-object/from16 v8, p8

    invoke-direct/range {v0 .. v8}, Lcom/android/mail/browse/ConversationItemView;->bind(Lcom/android/mail/browse/ConversationItemViewModel;Lcom/android/mail/ui/ControllableActivity;Lcom/android/mail/ui/ConversationSelectionSet;Lcom/android/mail/providers/Folder;ZZZLcom/android/mail/ui/AnimatedAdapter;)V

    .line 399
    return-void
.end method

.method public bind(Lcom/android/mail/providers/Conversation;Lcom/android/mail/ui/ControllableActivity;Lcom/android/mail/ui/ConversationSelectionSet;Lcom/android/mail/providers/Folder;ZZZLcom/android/mail/ui/AnimatedAdapter;)V
    .locals 9
    .param p1, "conversation"    # Lcom/android/mail/providers/Conversation;
    .param p2, "activity"    # Lcom/android/mail/ui/ControllableActivity;
    .param p3, "set"    # Lcom/android/mail/ui/ConversationSelectionSet;
    .param p4, "folder"    # Lcom/android/mail/providers/Folder;
    .param p5, "checkboxesDisabled"    # Z
    .param p6, "swipeEnabled"    # Z
    .param p7, "priorityArrowEnabled"    # Z
    .param p8, "adapter"    # Lcom/android/mail/ui/AnimatedAdapter;

    .prologue
    .line 404
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mAccount:Ljava/lang/String;

    invoke-static {v0, p1}, Lcom/android/mail/browse/ConversationItemViewModel;->forConversation(Ljava/lang/String;Lcom/android/mail/providers/Conversation;)Lcom/android/mail/browse/ConversationItemViewModel;

    move-result-object v1

    move-object v0, p0

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move v5, p5

    move v6, p6

    move/from16 v7, p7

    move-object/from16 v8, p8

    invoke-direct/range {v0 .. v8}, Lcom/android/mail/browse/ConversationItemView;->bind(Lcom/android/mail/browse/ConversationItemViewModel;Lcom/android/mail/ui/ControllableActivity;Lcom/android/mail/ui/ConversationSelectionSet;Lcom/android/mail/providers/Folder;ZZZLcom/android/mail/ui/AnimatedAdapter;)V

    .line 406
    return-void
.end method

.method public canChildBeDismissed()Z
    .locals 1

    .prologue
    .line 1264
    const/4 v0, 0x1

    return v0
.end method

.method public dismiss()V
    .locals 2

    .prologue
    .line 1269
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationItemView;->getListView()Lcom/android/mail/ui/SwipeableListView;

    move-result-object v0

    .line 1270
    .local v0, "listView":Lcom/android/mail/ui/SwipeableListView;
    if-eqz v0, :cond_0

    .line 1271
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationItemView;->getListView()Lcom/android/mail/ui/SwipeableListView;

    move-result-object v1

    invoke-virtual {v1, p0}, Lcom/android/mail/ui/SwipeableListView;->dismissChild(Lcom/android/mail/browse/ConversationItemView;)V

    .line 1273
    :cond_0
    return-void
.end method

.method public getConversation()Lcom/android/mail/providers/Conversation;
    .locals 1

    .prologue
    .line 427
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v0, v0, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    return-object v0
.end method

.method public getMinAllowScrollDistance()F
    .locals 1

    .prologue
    .line 1626
    sget v0, Lcom/android/mail/browse/ConversationItemView;->sScrollSlop:I

    int-to-float v0, v0

    return v0
.end method

.method public getSwipeableView()Landroid/view/View;
    .locals 0

    .prologue
    .line 1531
    return-object p0
.end method

.method public onDragEvent(Landroid/view/DragEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/DragEvent;

    .prologue
    .line 1577
    invoke-virtual {p1}, Landroid/view/DragEvent;->getAction()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 1582
    const/4 v0, 0x0

    :goto_0
    return v0

    .line 1579
    :pswitch_0
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->stopDragMode()V

    .line 1580
    const/4 v0, 0x1

    goto :goto_0

    .line 1577
    :pswitch_data_0
    .packed-switch 0x4
        :pswitch_0
    .end packed-switch
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 8

    .prologue
    const/4 v6, 0x0

    .line 964
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-boolean v0, v0, Lcom/android/mail/browse/ConversationItemViewModel;->checkboxVisible:Z

    if-eqz v0, :cond_0

    .line 965
    iget-boolean v0, p0, Lcom/android/mail/browse/ConversationItemView;->mChecked:Z

    if-eqz v0, :cond_9

    sget-object v0, Lcom/android/mail/browse/ConversationItemView;->CHECKMARK_ON:Landroid/graphics/Bitmap;

    .line 966
    :goto_0
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v1, v1, Lcom/android/mail/browse/ConversationItemViewCoordinates;->checkmarkX:I

    int-to-float v1, v1

    iget-object v2, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v2, v2, Lcom/android/mail/browse/ConversationItemViewCoordinates;->checkmarkY:I

    int-to-float v2, v2

    sget-object v3, Lcom/android/mail/browse/ConversationItemView;->sPaint:Landroid/text/TextPaint;

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 970
    :cond_0
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget-boolean v0, v0, Lcom/android/mail/browse/ConversationItemViewCoordinates;->showPersonalLevel:Z

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v0, v0, Lcom/android/mail/browse/ConversationItemViewModel;->personalLevelBitmap:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_1

    .line 971
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v0, v0, Lcom/android/mail/browse/ConversationItemViewModel;->personalLevelBitmap:Landroid/graphics/Bitmap;

    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v1, v1, Lcom/android/mail/browse/ConversationItemViewCoordinates;->personalLevelX:I

    int-to-float v1, v1

    iget-object v2, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v2, v2, Lcom/android/mail/browse/ConversationItemViewCoordinates;->personalLevelY:I

    int-to-float v2, v2

    sget-object v3, Lcom/android/mail/browse/ConversationItemView;->sPaint:Landroid/text/TextPaint;

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 976
    :cond_1
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-boolean v0, v0, Lcom/android/mail/browse/ConversationItemViewModel;->unread:Z

    .line 978
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    .line 979
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v1, v1, Lcom/android/mail/browse/ConversationItemViewModel;->sendersDisplayLayout:Landroid/text/StaticLayout;

    if-eqz v1, :cond_b

    .line 980
    sget-object v1, Lcom/android/mail/browse/ConversationItemView;->sPaint:Landroid/text/TextPaint;

    iget-object v2, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v2, v2, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sendersFontSize:I

    int-to-float v2, v2

    invoke-virtual {v1, v2}, Landroid/text/TextPaint;->setTextSize(F)V

    .line 981
    sget-object v1, Lcom/android/mail/browse/ConversationItemView;->sPaint:Landroid/text/TextPaint;

    invoke-static {v0}, Lcom/android/mail/browse/SendersView;->getTypeface(Z)Landroid/graphics/Typeface;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/text/TextPaint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    .line 982
    sget-object v1, Lcom/android/mail/browse/ConversationItemView;->sPaint:Landroid/text/TextPaint;

    if-eqz v0, :cond_a

    sget v0, Lcom/android/mail/browse/ConversationItemView;->sSendersTextColorUnread:I

    :goto_1
    invoke-direct {p0, v0}, Lcom/android/mail/browse/ConversationItemView;->getFontColor(I)I

    move-result v0

    invoke-virtual {v1, v0}, Landroid/text/TextPaint;->setColor(I)V

    .line 984
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v0, v0, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sendersX:I

    int-to-float v0, v0

    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v1, v1, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sendersY:I

    iget-object v2, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v2, v2, Lcom/android/mail/browse/ConversationItemViewModel;->sendersDisplayLayout:Landroid/text/StaticLayout;

    invoke-virtual {v2}, Landroid/text/StaticLayout;->getTopPadding()I

    move-result v2

    add-int/2addr v1, v2

    int-to-float v1, v1

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->translate(FF)V

    .line 986
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v0, v0, Lcom/android/mail/browse/ConversationItemViewModel;->sendersDisplayLayout:Landroid/text/StaticLayout;

    invoke-virtual {v0, p1}, Landroid/text/StaticLayout;->draw(Landroid/graphics/Canvas;)V

    .line 990
    :goto_2
    invoke-virtual {p1}, Landroid/graphics/Canvas;->restore()V

    .line 994
    sget-object v0, Lcom/android/mail/browse/ConversationItemView;->sPaint:Landroid/text/TextPaint;

    sget-object v1, Landroid/graphics/Typeface;->DEFAULT:Landroid/graphics/Typeface;

    invoke-virtual {v0, v1}, Landroid/text/TextPaint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    .line 995
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    .line 996
    invoke-direct {p0, p1}, Lcom/android/mail/browse/ConversationItemView;->drawSubject(Landroid/graphics/Canvas;)V

    .line 997
    invoke-virtual {p1}, Landroid/graphics/Canvas;->restore()V

    .line 1000
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget-boolean v0, v0, Lcom/android/mail/browse/ConversationItemViewCoordinates;->showFolders:Z

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v0, v0, Lcom/android/mail/browse/ConversationItemViewModel;->folderDisplayer:Lcom/android/mail/browse/ConversationItemView$ConversationItemFolderDisplayer;

    if-eqz v0, :cond_2

    .line 1001
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v0, v0, Lcom/android/mail/browse/ConversationItemViewModel;->folderDisplayer:Lcom/android/mail/browse/ConversationItemView$ConversationItemFolderDisplayer;

    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v2, p0, Lcom/android/mail/browse/ConversationItemView;->mFoldersXEnd:I

    iget v3, p0, Lcom/android/mail/browse/ConversationItemView;->mMode:I

    invoke-virtual {v0, p1, v1, v2, v3}, Lcom/android/mail/browse/ConversationItemView$ConversationItemFolderDisplayer;->drawFolders(Landroid/graphics/Canvas;Lcom/android/mail/browse/ConversationItemViewCoordinates;II)V

    .line 1005
    :cond_2
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v0, v0, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    iget v0, v0, Lcom/android/mail/providers/Conversation;->color:I

    if-eqz v0, :cond_3

    .line 1006
    sget-object v0, Lcom/android/mail/browse/ConversationItemView;->sFoldersPaint:Landroid/text/TextPaint;

    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v1, v1, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    iget v1, v1, Lcom/android/mail/providers/Conversation;->color:I

    invoke-virtual {v0, v1}, Landroid/text/TextPaint;->setColor(I)V

    .line 1007
    sget-object v0, Lcom/android/mail/browse/ConversationItemView;->sFoldersPaint:Landroid/text/TextPaint;

    sget-object v1, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/text/TextPaint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 1008
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getColorBlockWidth(Landroid/content/Context;)I

    move-result v0

    .line 1009
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mContext:Landroid/content/Context;

    invoke-static {v1}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getColorBlockHeight(Landroid/content/Context;)I

    move-result v4

    .line 1010
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v1, v1, Lcom/android/mail/browse/ConversationItemViewCoordinates;->dateXEnd:I

    sub-int v0, v1, v0

    int-to-float v1, v0

    const/4 v2, 0x0

    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v0, v0, Lcom/android/mail/browse/ConversationItemViewCoordinates;->dateXEnd:I

    int-to-float v3, v0

    int-to-float v4, v4

    sget-object v5, Lcom/android/mail/browse/ConversationItemView;->sFoldersPaint:Landroid/text/TextPaint;

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 1016
    :cond_3
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationItemView;->isActivated()Z

    move-result v0

    if-nez v0, :cond_e

    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v0, v0, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    iget-boolean v0, v0, Lcom/android/mail/providers/Conversation;->hasAttachments:Z

    if-nez v0, :cond_4

    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v0, v0, Lcom/android/mail/browse/ConversationItemViewModel;->folderDisplayer:Lcom/android/mail/browse/ConversationItemView$ConversationItemFolderDisplayer;

    if-eqz v0, :cond_e

    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v0, v0, Lcom/android/mail/browse/ConversationItemViewModel;->folderDisplayer:Lcom/android/mail/browse/ConversationItemView$ConversationItemFolderDisplayer;

    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationItemView$ConversationItemFolderDisplayer;->hasVisibleFolders()Z

    move-result v0

    if-eqz v0, :cond_e

    :cond_4
    iget v0, p0, Lcom/android/mail/browse/ConversationItemView;->mMode:I

    invoke-static {v0}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->showAttachmentBackground(I)Z

    move-result v0

    if-eqz v0, :cond_e

    .line 1021
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v0, v0, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    iget-boolean v0, v0, Lcom/android/mail/providers/Conversation;->hasAttachments:Z

    if-eqz v0, :cond_c

    iget v0, p0, Lcom/android/mail/browse/ConversationItemView;->mPaperclipX:I

    :goto_3
    sget v1, Lcom/android/mail/browse/ConversationItemView;->sDateBackgroundPaddingLeft:I

    sub-int v1, v0, v1

    .line 1023
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget-boolean v0, v0, Lcom/android/mail/browse/ConversationItemViewCoordinates;->showFolders:Z

    if-eqz v0, :cond_d

    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v0, v0, Lcom/android/mail/browse/ConversationItemViewCoordinates;->foldersY:I

    .line 1024
    :goto_4
    iget-object v2, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v3, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v3, v3, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    iget-boolean v3, v3, Lcom/android/mail/providers/Conversation;->hasAttachments:Z

    invoke-direct {p0, v3}, Lcom/android/mail/browse/ConversationItemView;->getDateBackground(Z)Landroid/graphics/Bitmap;

    move-result-object v3

    iput-object v3, v2, Lcom/android/mail/browse/ConversationItemViewModel;->dateBackground:Landroid/graphics/Bitmap;

    .line 1025
    iget-object v2, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v2, v2, Lcom/android/mail/browse/ConversationItemViewModel;->dateBackground:Landroid/graphics/Bitmap;

    int-to-float v1, v1

    int-to-float v0, v0

    sget-object v3, Lcom/android/mail/browse/ConversationItemView;->sPaint:Landroid/text/TextPaint;

    invoke-virtual {p1, v2, v1, v0, v3}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 1031
    :goto_5
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget-boolean v0, v0, Lcom/android/mail/browse/ConversationItemViewCoordinates;->showReplyState:Z

    if-eqz v0, :cond_5

    .line 1032
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-boolean v0, v0, Lcom/android/mail/browse/ConversationItemViewModel;->hasBeenRepliedTo:Z

    if-eqz v0, :cond_f

    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-boolean v0, v0, Lcom/android/mail/browse/ConversationItemViewModel;->hasBeenForwarded:Z

    if-eqz v0, :cond_f

    .line 1033
    sget-object v0, Lcom/android/mail/browse/ConversationItemView;->STATE_REPLIED_AND_FORWARDED:Landroid/graphics/Bitmap;

    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v1, v1, Lcom/android/mail/browse/ConversationItemViewCoordinates;->replyStateX:I

    int-to-float v1, v1

    iget-object v2, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v2, v2, Lcom/android/mail/browse/ConversationItemViewCoordinates;->replyStateY:I

    int-to-float v2, v2

    invoke-virtual {p1, v0, v1, v2, v6}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 1048
    :cond_5
    :goto_6
    sget-object v0, Lcom/android/mail/browse/ConversationItemView;->sPaint:Landroid/text/TextPaint;

    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v1, v1, Lcom/android/mail/browse/ConversationItemViewCoordinates;->dateFontSize:I

    int-to-float v1, v1

    invoke-virtual {v0, v1}, Landroid/text/TextPaint;->setTextSize(F)V

    .line 1049
    sget-object v0, Lcom/android/mail/browse/ConversationItemView;->sPaint:Landroid/text/TextPaint;

    sget-object v1, Landroid/graphics/Typeface;->DEFAULT:Landroid/graphics/Typeface;

    invoke-virtual {v0, v1}, Landroid/text/TextPaint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    .line 1050
    sget-object v0, Lcom/android/mail/browse/ConversationItemView;->sPaint:Landroid/text/TextPaint;

    sget v1, Lcom/android/mail/browse/ConversationItemView;->sDateTextColor:I

    invoke-virtual {v0, v1}, Landroid/text/TextPaint;->setColor(I)V

    .line 1051
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v2, v0, Lcom/android/mail/browse/ConversationItemViewModel;->dateText:Ljava/lang/String;

    iget v3, p0, Lcom/android/mail/browse/ConversationItemView;->mDateX:I

    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v0, v0, Lcom/android/mail/browse/ConversationItemViewCoordinates;->dateY:I

    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v1, v1, Lcom/android/mail/browse/ConversationItemViewCoordinates;->dateAscent:I

    sub-int v4, v0, v1

    sget-object v5, Lcom/android/mail/browse/ConversationItemView;->sPaint:Landroid/text/TextPaint;

    move-object v0, p0

    move-object v1, p1

    invoke-direct/range {v0 .. v5}, Lcom/android/mail/browse/ConversationItemView;->drawText(Landroid/graphics/Canvas;Ljava/lang/CharSequence;IILandroid/text/TextPaint;)V

    .line 1055
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v0, v0, Lcom/android/mail/browse/ConversationItemViewModel;->paperclip:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_6

    .line 1056
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v0, v0, Lcom/android/mail/browse/ConversationItemViewModel;->paperclip:Landroid/graphics/Bitmap;

    iget v1, p0, Lcom/android/mail/browse/ConversationItemView;->mPaperclipX:I

    int-to-float v1, v1

    iget-object v2, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v2, v2, Lcom/android/mail/browse/ConversationItemViewCoordinates;->paperclipY:I

    int-to-float v2, v2

    sget-object v3, Lcom/android/mail/browse/ConversationItemView;->sPaint:Landroid/text/TextPaint;

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 1059
    :cond_6
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-boolean v0, v0, Lcom/android/mail/browse/ConversationItemViewModel;->faded:Z

    if-eqz v0, :cond_8

    .line 1061
    sget v0, Lcom/android/mail/browse/ConversationItemView;->sFadedActivatedColor:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_7

    .line 1062
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f090010

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    sput v0, Lcom/android/mail/browse/ConversationItemView;->sFadedActivatedColor:I

    .line 1065
    :cond_7
    sget v0, Lcom/android/mail/browse/ConversationItemView;->sFadedActivatedColor:I

    .line 1066
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    move-result v1

    .line 1067
    invoke-virtual {p1}, Landroid/graphics/Canvas;->getClipBounds()Landroid/graphics/Rect;

    move-result-object v2

    .line 1068
    iget v3, v2, Landroid/graphics/Rect;->left:I

    iget v4, v2, Landroid/graphics/Rect;->top:I

    iget v5, v2, Landroid/graphics/Rect;->right:I

    iget-object v6, p0, Lcom/android/mail/browse/ConversationItemView;->mContext:Landroid/content/Context;

    invoke-virtual {v6}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const v7, 0x7f0b0029

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v6

    sub-int/2addr v5, v6

    iget v2, v2, Landroid/graphics/Rect;->bottom:I

    invoke-virtual {p1, v3, v4, v5, v2}, Landroid/graphics/Canvas;->clipRect(IIII)Z

    .line 1071
    invoke-static {v0}, Landroid/graphics/Color;->alpha(I)I

    move-result v2

    invoke-static {v0}, Landroid/graphics/Color;->red(I)I

    move-result v3

    invoke-static {v0}, Landroid/graphics/Color;->green(I)I

    move-result v4

    invoke-static {v0}, Landroid/graphics/Color;->blue(I)I

    move-result v0

    invoke-virtual {p1, v2, v3, v4, v0}, Landroid/graphics/Canvas;->drawARGB(IIII)V

    .line 1073
    invoke-virtual {p1, v1}, Landroid/graphics/Canvas;->restoreToCount(I)V

    .line 1077
    :cond_8
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationItemView;->getStarBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v1, v1, Lcom/android/mail/browse/ConversationItemViewCoordinates;->starX:I

    int-to-float v1, v1

    iget-object v2, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v2, v2, Lcom/android/mail/browse/ConversationItemViewCoordinates;->starY:I

    int-to-float v2, v2

    sget-object v3, Lcom/android/mail/browse/ConversationItemView;->sPaint:Landroid/text/TextPaint;

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 1078
    return-void

    .line 965
    :cond_9
    sget-object v0, Lcom/android/mail/browse/ConversationItemView;->CHECKMARK_OFF:Landroid/graphics/Bitmap;

    goto/16 :goto_0

    .line 982
    :cond_a
    sget v0, Lcom/android/mail/browse/ConversationItemView;->sSendersTextColorRead:I

    goto/16 :goto_1

    .line 988
    :cond_b
    invoke-direct {p0, p1}, Lcom/android/mail/browse/ConversationItemView;->drawSenders(Landroid/graphics/Canvas;)V

    goto/16 :goto_2

    .line 1021
    :cond_c
    iget v0, p0, Lcom/android/mail/browse/ConversationItemView;->mDateX:I

    goto/16 :goto_3

    .line 1023
    :cond_d
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v0, v0, Lcom/android/mail/browse/ConversationItemViewCoordinates;->dateY:I

    goto/16 :goto_4

    .line 1027
    :cond_e
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iput-object v6, v0, Lcom/android/mail/browse/ConversationItemViewModel;->dateBackground:Landroid/graphics/Bitmap;

    goto/16 :goto_5

    .line 1035
    :cond_f
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-boolean v0, v0, Lcom/android/mail/browse/ConversationItemViewModel;->hasBeenRepliedTo:Z

    if-eqz v0, :cond_10

    .line 1036
    sget-object v0, Lcom/android/mail/browse/ConversationItemView;->STATE_REPLIED:Landroid/graphics/Bitmap;

    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v1, v1, Lcom/android/mail/browse/ConversationItemViewCoordinates;->replyStateX:I

    int-to-float v1, v1

    iget-object v2, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v2, v2, Lcom/android/mail/browse/ConversationItemViewCoordinates;->replyStateY:I

    int-to-float v2, v2

    invoke-virtual {p1, v0, v1, v2, v6}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    goto/16 :goto_6

    .line 1038
    :cond_10
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-boolean v0, v0, Lcom/android/mail/browse/ConversationItemViewModel;->hasBeenForwarded:Z

    if-eqz v0, :cond_11

    .line 1039
    sget-object v0, Lcom/android/mail/browse/ConversationItemView;->STATE_FORWARDED:Landroid/graphics/Bitmap;

    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v1, v1, Lcom/android/mail/browse/ConversationItemViewCoordinates;->replyStateX:I

    int-to-float v1, v1

    iget-object v2, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v2, v2, Lcom/android/mail/browse/ConversationItemViewCoordinates;->replyStateY:I

    int-to-float v2, v2

    invoke-virtual {p1, v0, v1, v2, v6}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    goto/16 :goto_6

    .line 1041
    :cond_11
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-boolean v0, v0, Lcom/android/mail/browse/ConversationItemViewModel;->isInvite:Z

    if-eqz v0, :cond_5

    .line 1042
    sget-object v0, Lcom/android/mail/browse/ConversationItemView;->STATE_CALENDAR_INVITE:Landroid/graphics/Bitmap;

    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v1, v1, Lcom/android/mail/browse/ConversationItemViewCoordinates;->replyStateX:I

    int-to-float v1, v1

    iget-object v2, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v2, v2, Lcom/android/mail/browse/ConversationItemViewCoordinates;->replyStateY:I

    int-to-float v2, v2

    invoke-virtual {p1, v0, v1, v2, v6}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    goto/16 :goto_6
.end method

.method protected onLayout(ZIIII)V
    .locals 7
    .param p1, "changed"    # Z
    .param p2, "left"    # I
    .param p3, "top"    # I
    .param p4, "right"    # I
    .param p5, "bottom"    # I

    .prologue
    .line 453
    const-string v3, "CCHV.layout"

    invoke-static {v3}, Lcom/android/mail/browse/ConversationItemView;->startTimer(Ljava/lang/String;)V

    .line 455
    invoke-super/range {p0 .. p5}, Landroid/view/View;->onLayout(ZIIII)V

    .line 457
    sub-int v2, p4, p2

    .line 458
    .local v2, "width":I
    iget-object v3, p0, Lcom/android/mail/browse/ConversationItemView;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v3}, Lcom/android/mail/ui/ControllableActivity;->getViewMode()Lcom/android/mail/ui/ViewMode;

    move-result-object v3

    invoke-virtual {v3}, Lcom/android/mail/ui/ViewMode;->getMode()I

    move-result v0

    .line 459
    .local v0, "currentMode":I
    iget v3, p0, Lcom/android/mail/browse/ConversationItemView;->mViewWidth:I

    if-ne v2, v3, :cond_0

    iget v3, p0, Lcom/android/mail/browse/ConversationItemView;->mPreviousMode:I

    if-eq v3, v0, :cond_1

    .line 460
    :cond_0
    iput v2, p0, Lcom/android/mail/browse/ConversationItemView;->mViewWidth:I

    .line 461
    iput v0, p0, Lcom/android/mail/browse/ConversationItemView;->mPreviousMode:I

    .line 462
    iget-boolean v3, p0, Lcom/android/mail/browse/ConversationItemView;->mTesting:Z

    if-nez v3, :cond_1

    .line 463
    iget-object v3, p0, Lcom/android/mail/browse/ConversationItemView;->mContext:Landroid/content/Context;

    iget v4, p0, Lcom/android/mail/browse/ConversationItemView;->mPreviousMode:I

    invoke-static {v3, v4}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getMode(Landroid/content/Context;I)I

    move-result v3

    iput v3, p0, Lcom/android/mail/browse/ConversationItemView;->mMode:I

    .line 466
    :cond_1
    iget-object v3, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget v4, p0, Lcom/android/mail/browse/ConversationItemView;->mViewWidth:I

    iput v4, v3, Lcom/android/mail/browse/ConversationItemViewModel;->viewWidth:I

    .line 467
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationItemView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    .line 468
    .local v1, "res":Landroid/content/res/Resources;
    iget-object v3, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    const v4, 0x7f0b0027

    invoke-virtual {v1, v4}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v4

    iput v4, v3, Lcom/android/mail/browse/ConversationItemViewModel;->standardScaledDimen:I

    .line 469
    iget-object v3, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget v3, v3, Lcom/android/mail/browse/ConversationItemViewModel;->standardScaledDimen:I

    sget v4, Lcom/android/mail/browse/ConversationItemView;->sStandardScaledDimen:I

    if-eq v3, v4, :cond_2

    .line 471
    iget-object v3, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget v3, v3, Lcom/android/mail/browse/ConversationItemViewModel;->standardScaledDimen:I

    sput v3, Lcom/android/mail/browse/ConversationItemView;->sStandardScaledDimen:I

    .line 472
    iget-object v3, p0, Lcom/android/mail/browse/ConversationItemView;->mContext:Landroid/content/Context;

    invoke-static {v3}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->refreshConversationHeights(Landroid/content/Context;)V

    .line 473
    const v3, 0x7f0b0023

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v3

    sput v3, Lcom/android/mail/browse/ConversationItemView;->sDateBackgroundHeight:I

    .line 475
    :cond_2
    iget-object v3, p0, Lcom/android/mail/browse/ConversationItemView;->mContext:Landroid/content/Context;

    iget v4, p0, Lcom/android/mail/browse/ConversationItemView;->mViewWidth:I

    iget v5, p0, Lcom/android/mail/browse/ConversationItemView;->mMode:I

    iget-object v6, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget v6, v6, Lcom/android/mail/browse/ConversationItemViewModel;->standardScaledDimen:I

    invoke-static {v3, v4, v5, v6}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->forWidth(Landroid/content/Context;III)Lcom/android/mail/browse/ConversationItemViewCoordinates;

    move-result-object v3

    iput-object v3, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    .line 477
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationItemView;->calculateTextsAndBitmaps()V

    .line 478
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationItemView;->calculateCoordinates()V

    .line 479
    iget-object v3, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v4, p0, Lcom/android/mail/browse/ConversationItemView;->mContext:Landroid/content/Context;

    invoke-virtual {v3, v4}, Lcom/android/mail/browse/ConversationItemViewModel;->isLayoutValid(Landroid/content/Context;)Z

    move-result v3

    if-nez v3, :cond_3

    .line 480
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationItemView;->setContentDescription()V

    .line 482
    :cond_3
    iget-object v3, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v4, p0, Lcom/android/mail/browse/ConversationItemView;->mContext:Landroid/content/Context;

    invoke-virtual {v3, v4}, Lcom/android/mail/browse/ConversationItemViewModel;->validate(Landroid/content/Context;)V

    .line 484
    const-string v3, "CCHV.layout"

    invoke-static {v3}, Lcom/android/mail/browse/ConversationItemView;->pauseTimer(Ljava/lang/String;)V

    .line 485
    sget-object v3, Lcom/android/mail/browse/ConversationItemView;->sTimer:Lcom/android/mail/perf/Timer;

    if-eqz v3, :cond_4

    sget v3, Lcom/android/mail/browse/ConversationItemView;->sLayoutCount:I

    add-int/lit8 v3, v3, 0x1

    sput v3, Lcom/android/mail/browse/ConversationItemView;->sLayoutCount:I

    const/16 v4, 0x32

    if-lt v3, v4, :cond_4

    .line 486
    sget-object v3, Lcom/android/mail/browse/ConversationItemView;->sTimer:Lcom/android/mail/perf/Timer;

    invoke-virtual {v3}, Lcom/android/mail/perf/Timer;->dumpResults()V

    .line 487
    new-instance v3, Lcom/android/mail/perf/Timer;

    invoke-direct {v3}, Lcom/android/mail/perf/Timer;-><init>()V

    sput-object v3, Lcom/android/mail/browse/ConversationItemView;->sTimer:Lcom/android/mail/perf/Timer;

    .line 488
    const/4 v3, 0x0

    sput v3, Lcom/android/mail/browse/ConversationItemView;->sLayoutCount:I

    .line 490
    :cond_4
    return-void
.end method

.method protected onMeasure(II)V
    .locals 3
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 1486
    iget v1, p0, Lcom/android/mail/browse/ConversationItemView;->mAnimatedHeight:I

    const/4 v2, -0x1

    if-ne v1, v2, :cond_0

    .line 1487
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/android/mail/browse/ConversationItemView;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v2}, Lcom/android/mail/ui/ControllableActivity;->getViewMode()Lcom/android/mail/ui/ViewMode;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getMode(Landroid/content/Context;Lcom/android/mail/ui/ViewMode;)I

    move-result v1

    invoke-direct {p0, p2, v1}, Lcom/android/mail/browse/ConversationItemView;->measureHeight(II)I

    move-result v0

    .line 1489
    .local v0, "height":I
    invoke-virtual {p0, p1, v0}, Lcom/android/mail/browse/ConversationItemView;->setMeasuredDimension(II)V

    .line 1493
    .end local v0    # "height":I
    :goto_0
    return-void

    .line 1491
    :cond_0
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v1

    iget v2, p0, Lcom/android/mail/browse/ConversationItemView;->mAnimatedHeight:I

    invoke-virtual {p0, v1, v2}, Lcom/android/mail/browse/ConversationItemView;->setMeasuredDimension(II)V

    goto :goto_0
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 7
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v6, 0x0

    const/4 v3, 0x1

    .line 1320
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v4

    float-to-int v1, v4

    .line 1321
    .local v1, "x":I
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v4

    float-to-int v2, v4

    .line 1322
    .local v2, "y":I
    iput v1, p0, Lcom/android/mail/browse/ConversationItemView;->mLastTouchX:I

    .line 1323
    iput v2, p0, Lcom/android/mail/browse/ConversationItemView;->mLastTouchY:I

    .line 1324
    iget-boolean v4, p0, Lcom/android/mail/browse/ConversationItemView;->mSwipeEnabled:Z

    if-nez v4, :cond_1

    .line 1325
    invoke-direct {p0, p1}, Lcom/android/mail/browse/ConversationItemView;->onTouchEventNoSwipe(Landroid/view/MotionEvent;)Z

    move-result v0

    .line 1355
    :cond_0
    :goto_0
    return v0

    .line 1327
    :cond_1
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v4

    packed-switch v4, :pswitch_data_0

    .line 1351
    :cond_2
    invoke-super {p0, p1}, Landroid/view/View;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    .line 1352
    .local v0, "handled":Z
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v4

    if-nez v4, :cond_0

    move v0, v3

    .line 1353
    goto :goto_0

    .line 1329
    .end local v0    # "handled":Z
    :pswitch_0
    int-to-float v4, v1

    int-to-float v5, v2

    invoke-direct {p0, v4, v5}, Lcom/android/mail/browse/ConversationItemView;->isTouchInCheckmark(FF)Z

    move-result v4

    if-nez v4, :cond_3

    int-to-float v4, v1

    int-to-float v5, v2

    invoke-direct {p0, v4, v5}, Lcom/android/mail/browse/ConversationItemView;->isTouchInStar(FF)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 1330
    :cond_3
    iput-boolean v3, p0, Lcom/android/mail/browse/ConversationItemView;->mDownEvent:Z

    move v0, v3

    .line 1331
    goto :goto_0

    .line 1335
    :pswitch_1
    iget-boolean v4, p0, Lcom/android/mail/browse/ConversationItemView;->mDownEvent:Z

    if-eqz v4, :cond_2

    .line 1336
    int-to-float v4, v1

    int-to-float v5, v2

    invoke-direct {p0, v4, v5}, Lcom/android/mail/browse/ConversationItemView;->isTouchInCheckmark(FF)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 1338
    iput-boolean v6, p0, Lcom/android/mail/browse/ConversationItemView;->mDownEvent:Z

    .line 1339
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationItemView;->toggleCheckMark()V

    move v0, v3

    .line 1340
    goto :goto_0

    .line 1341
    :cond_4
    int-to-float v4, v1

    int-to-float v5, v2

    invoke-direct {p0, v4, v5}, Lcom/android/mail/browse/ConversationItemView;->isTouchInStar(FF)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 1343
    iput-boolean v6, p0, Lcom/android/mail/browse/ConversationItemView;->mDownEvent:Z

    .line 1344
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationItemView;->toggleStar()V

    move v0, v3

    .line 1345
    goto :goto_0

    .line 1327
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public performClick()Z
    .locals 5

    .prologue
    .line 1360
    invoke-super {p0}, Landroid/view/View;->performClick()Z

    move-result v0

    .line 1361
    .local v0, "handled":Z
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationItemView;->getListView()Lcom/android/mail/ui/SwipeableListView;

    move-result-object v1

    .line 1362
    .local v1, "list":Lcom/android/mail/ui/SwipeableListView;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Lcom/android/mail/ui/SwipeableListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 1363
    iget-object v3, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v3, v3, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    invoke-virtual {v1, p0, v3}, Lcom/android/mail/ui/SwipeableListView;->findConversation(Lcom/android/mail/browse/ConversationItemView;Lcom/android/mail/providers/Conversation;)I

    move-result v2

    .line 1364
    .local v2, "pos":I
    iget-object v3, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v3, v3, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    iget-wide v3, v3, Lcom/android/mail/providers/Conversation;->id:J

    invoke-virtual {v1, p0, v2, v3, v4}, Lcom/android/mail/ui/SwipeableListView;->performItemClick(Landroid/view/View;IJ)Z

    .line 1366
    .end local v2    # "pos":I
    :cond_0
    return v0
.end method

.method public reset()V
    .locals 2

    .prologue
    const/4 v1, -0x1

    .line 1383
    iput v1, p0, Lcom/android/mail/browse/ConversationItemView;->mBackgroundOverride:I

    .line 1384
    const/high16 v0, 0x3f800000    # 1.0f

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/ConversationItemView;->setAlpha(F)V

    .line 1385
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/ConversationItemView;->setTranslationX(F)V

    .line 1386
    invoke-virtual {p0, v1}, Lcom/android/mail/browse/ConversationItemView;->setAnimatedHeight(I)V

    .line 1387
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mContext:Landroid/content/Context;

    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->getViewMode()Lcom/android/mail/ui/ViewMode;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getMinHeight(Landroid/content/Context;Lcom/android/mail/ui/ViewMode;)I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/ConversationItemView;->setMinimumHeight(I)V

    .line 1389
    return-void
.end method

.method public setAnimatedHeight(I)V
    .locals 0
    .param p1, "height"    # I

    .prologue
    .line 1480
    iput p1, p0, Lcom/android/mail/browse/ConversationItemView;->mAnimatedHeight:I

    .line 1481
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationItemView;->requestLayout()V

    .line 1482
    return-void
.end method

.method public setBackgroundResource(I)V
    .locals 2
    .param p1, "resourceId"    # I

    .prologue
    .line 501
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mBackgrounds:Landroid/util/SparseArray;

    invoke-virtual {v1, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/graphics/drawable/Drawable;

    .line 502
    .local v0, "drawable":Landroid/graphics/drawable/Drawable;
    if-nez v0, :cond_0

    .line 503
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationItemView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, p1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 504
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mBackgrounds:Landroid/util/SparseArray;

    invoke-virtual {v1, p1, v0}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 506
    :cond_0
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationItemView;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    if-eq v1, v0, :cond_1

    .line 507
    invoke-super {p0, v0}, Landroid/view/View;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 509
    :cond_1
    return-void
.end method

.method public setItemAlpha(F)V
    .locals 0
    .param p1, "alpha"    # F

    .prologue
    .line 1473
    invoke-virtual {p0, p1}, Lcom/android/mail/browse/ConversationItemView;->setAlpha(F)V

    .line 1474
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationItemView;->invalidate()V

    .line 1475
    return-void
.end method

.method setMode(I)V
    .locals 1
    .param p1, "mode"    # I

    .prologue
    .line 435
    iput p1, p0, Lcom/android/mail/browse/ConversationItemView;->mMode:I

    .line 436
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/mail/browse/ConversationItemView;->mTesting:Z

    .line 437
    return-void
.end method

.method public startDestroyAnimation(Landroid/animation/Animator$AnimatorListener;)V
    .locals 5
    .param p1, "listener"    # Landroid/animation/Animator$AnimatorListener;

    .prologue
    const/4 v4, 0x0

    .line 1448
    invoke-direct {p0, v4}, Lcom/android/mail/browse/ConversationItemView;->createHeightAnimation(Z)Landroid/animation/ObjectAnimator;

    move-result-object v0

    .line 1449
    .local v0, "height":Landroid/animation/ObjectAnimator;
    iget-object v2, p0, Lcom/android/mail/browse/ConversationItemView;->mContext:Landroid/content/Context;

    iget-object v3, p0, Lcom/android/mail/browse/ConversationItemView;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v3}, Lcom/android/mail/ui/ControllableActivity;->getViewMode()Lcom/android/mail/ui/ViewMode;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getMinHeight(Landroid/content/Context;Lcom/android/mail/ui/ViewMode;)I

    move-result v1

    .line 1451
    .local v1, "minHeight":I
    invoke-virtual {p0, v4}, Lcom/android/mail/browse/ConversationItemView;->setMinimumHeight(I)V

    .line 1452
    sget v2, Lcom/android/mail/browse/ConversationItemView;->sAnimatingBackgroundColor:I

    iput v2, p0, Lcom/android/mail/browse/ConversationItemView;->mBackgroundOverride:I

    .line 1453
    iget v2, p0, Lcom/android/mail/browse/ConversationItemView;->mBackgroundOverride:I

    invoke-virtual {p0, v2}, Lcom/android/mail/browse/ConversationItemView;->setBackgroundColor(I)V

    .line 1454
    iput v1, p0, Lcom/android/mail/browse/ConversationItemView;->mAnimatedHeight:I

    .line 1455
    invoke-virtual {v0, p1}, Landroid/animation/ObjectAnimator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    .line 1456
    invoke-virtual {v0}, Landroid/animation/ObjectAnimator;->start()V

    .line 1457
    return-void
.end method

.method public startDestroyWithSwipeAnimation(Landroid/animation/Animator$AnimatorListener;)V
    .locals 5
    .param p1, "listener"    # Landroid/animation/Animator$AnimatorListener;

    .prologue
    const/4 v4, 0x0

    .line 1427
    invoke-direct {p0, v4}, Lcom/android/mail/browse/ConversationItemView;->createTranslateXAnimation(Z)Landroid/animation/ObjectAnimator;

    move-result-object v1

    .line 1428
    .local v1, "slide":Landroid/animation/ObjectAnimator;
    invoke-direct {p0, v4}, Lcom/android/mail/browse/ConversationItemView;->createHeightAnimation(Z)Landroid/animation/ObjectAnimator;

    move-result-object v0

    .line 1429
    .local v0, "height":Landroid/animation/ObjectAnimator;
    new-instance v2, Landroid/animation/AnimatorSet;

    invoke-direct {v2}, Landroid/animation/AnimatorSet;-><init>()V

    .line 1430
    .local v2, "transitionSet":Landroid/animation/AnimatorSet;
    const/4 v3, 0x2

    new-array v3, v3, [Landroid/animation/Animator;

    aput-object v1, v3, v4

    const/4 v4, 0x1

    aput-object v0, v3, v4

    invoke-virtual {v2, v3}, Landroid/animation/AnimatorSet;->playSequentially([Landroid/animation/Animator;)V

    .line 1431
    invoke-virtual {v2, p1}, Landroid/animation/AnimatorSet;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    .line 1432
    invoke-virtual {v2}, Landroid/animation/AnimatorSet;->start()V

    .line 1433
    return-void
.end method

.method public startSwipeUndoAnimation(Lcom/android/mail/ui/ViewMode;Landroid/animation/Animator$AnimatorListener;)V
    .locals 2
    .param p1, "viewMode"    # Lcom/android/mail/ui/ViewMode;
    .param p2, "listener"    # Landroid/animation/Animator$AnimatorListener;

    .prologue
    .line 1397
    const/4 v1, 0x1

    invoke-direct {p0, v1}, Lcom/android/mail/browse/ConversationItemView;->createTranslateXAnimation(Z)Landroid/animation/ObjectAnimator;

    move-result-object v0

    .line 1398
    .local v0, "undoAnimator":Landroid/animation/ObjectAnimator;
    invoke-virtual {v0, p2}, Landroid/animation/ObjectAnimator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    .line 1399
    invoke-virtual {v0}, Landroid/animation/ObjectAnimator;->start()V

    .line 1400
    return-void
.end method

.method public startUndoAnimation(Lcom/android/mail/ui/ViewMode;Landroid/animation/Animator$AnimatorListener;)V
    .locals 7

    .prologue
    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 1408
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemView;->mContext:Landroid/content/Context;

    invoke-static {v0, p1}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getMinHeight(Landroid/content/Context;Lcom/android/mail/ui/ViewMode;)I

    move-result v0

    .line 1409
    invoke-virtual {p0, v0}, Lcom/android/mail/browse/ConversationItemView;->setMinimumHeight(I)V

    .line 1410
    iput v4, p0, Lcom/android/mail/browse/ConversationItemView;->mAnimatedHeight:I

    .line 1411
    invoke-direct {p0, v5}, Lcom/android/mail/browse/ConversationItemView;->createHeightAnimation(Z)Landroid/animation/ObjectAnimator;

    move-result-object v0

    .line 1412
    const-string v1, "itemAlpha"

    new-array v2, v6, [F

    fill-array-data v2, :array_0

    invoke-static {p0, v1, v2}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v1

    .line 1413
    sget v2, Lcom/android/mail/browse/ConversationItemView;->sShrinkAnimationDuration:I

    int-to-long v2, v2

    invoke-virtual {v1, v2, v3}, Landroid/animation/Animator;->setDuration(J)Landroid/animation/Animator;

    .line 1414
    new-instance v2, Landroid/view/animation/DecelerateInterpolator;

    const/high16 v3, 0x40000000    # 2.0f

    invoke-direct {v2, v3}, Landroid/view/animation/DecelerateInterpolator;-><init>(F)V

    invoke-virtual {v1, v2}, Landroid/animation/ObjectAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    .line 1415
    new-instance v2, Landroid/animation/AnimatorSet;

    invoke-direct {v2}, Landroid/animation/AnimatorSet;-><init>()V

    .line 1416
    new-array v3, v6, [Landroid/animation/Animator;

    aput-object v0, v3, v4

    aput-object v1, v3, v5

    invoke-virtual {v2, v3}, Landroid/animation/AnimatorSet;->playTogether([Landroid/animation/Animator;)V

    .line 1417
    invoke-virtual {v2, p2}, Landroid/animation/AnimatorSet;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    .line 1418
    invoke-virtual {v2}, Landroid/animation/AnimatorSet;->start()V

    .line 1419
    return-void

    .line 1412
    :array_0
    .array-data 4
        0x0
        0x3f800000    # 1.0f
    .end array-data
.end method

.method public toggleCheckMarkOrBeginDrag()V
    .locals 2

    .prologue
    .line 1201
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemView;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->getViewMode()Lcom/android/mail/ui/ViewMode;

    move-result-object v0

    .line 1202
    .local v0, "mode":Lcom/android/mail/ui/ViewMode;
    iget-boolean v1, p0, Lcom/android/mail/browse/ConversationItemView;->mTabletDevice:Z

    if-eqz v1, :cond_0

    invoke-virtual {v0}, Lcom/android/mail/ui/ViewMode;->isListMode()Z

    move-result v1

    if-nez v1, :cond_1

    .line 1203
    :cond_0
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationItemView;->toggleCheckMark()V

    .line 1207
    :goto_0
    return-void

    .line 1205
    :cond_1
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationItemView;->beginDragMode()V

    goto :goto_0
.end method

.method public toggleStar()V
    .locals 7

    .prologue
    .line 1242
    iget-object v2, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v3, v2, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    iget-object v2, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v2, v2, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    iget-boolean v2, v2, Lcom/android/mail/providers/Conversation;->starred:Z

    if-nez v2, :cond_0

    const/4 v2, 0x1

    :goto_0
    iput-boolean v2, v3, Lcom/android/mail/providers/Conversation;->starred:Z

    .line 1243
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationItemView;->getStarBitmap()Landroid/graphics/Bitmap;

    move-result-object v1

    .line 1244
    .local v1, "starBitmap":Landroid/graphics/Bitmap;
    iget-object v2, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v2, v2, Lcom/android/mail/browse/ConversationItemViewCoordinates;->starX:I

    iget-object v3, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v3, v3, Lcom/android/mail/browse/ConversationItemViewCoordinates;->starY:I

    iget-object v4, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v4, v4, Lcom/android/mail/browse/ConversationItemViewCoordinates;->starX:I

    invoke-virtual {v1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v5

    add-int/2addr v4, v5

    iget-object v5, p0, Lcom/android/mail/browse/ConversationItemView;->mCoordinates:Lcom/android/mail/browse/ConversationItemViewCoordinates;

    iget v5, v5, Lcom/android/mail/browse/ConversationItemViewCoordinates;->starY:I

    invoke-virtual {v1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v6

    add-int/2addr v5, v6

    invoke-virtual {p0, v2, v3, v4, v5}, Lcom/android/mail/browse/ConversationItemView;->postInvalidate(IIII)V

    .line 1247
    iget-object v2, p0, Lcom/android/mail/browse/ConversationItemView;->mAdapter:Lcom/android/mail/ui/AnimatedAdapter;

    invoke-virtual {v2}, Lcom/android/mail/ui/AnimatedAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v0

    check-cast v0, Lcom/android/mail/browse/ConversationCursor;

    .line 1248
    .local v0, "cursor":Lcom/android/mail/browse/ConversationCursor;
    iget-object v2, p0, Lcom/android/mail/browse/ConversationItemView;->mContext:Landroid/content/Context;

    iget-object v3, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v3, v3, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    sget-object v4, Lcom/android/mail/providers/UIProvider$ConversationColumns;->STARRED:Ljava/lang/String;

    iget-object v5, p0, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v5, v5, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    iget-boolean v5, v5, Lcom/android/mail/providers/Conversation;->starred:Z

    invoke-virtual {v0, v2, v3, v4, v5}, Lcom/android/mail/browse/ConversationCursor;->updateBoolean(Landroid/content/Context;Lcom/android/mail/providers/Conversation;Ljava/lang/String;Z)I

    .line 1250
    return-void

    .line 1242
    .end local v0    # "cursor":Lcom/android/mail/browse/ConversationCursor;
    .end local v1    # "starBitmap":Landroid/graphics/Bitmap;
    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method
