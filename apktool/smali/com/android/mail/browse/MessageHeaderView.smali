.class public Lcom/android/mail/browse/MessageHeaderView;
.super Landroid/widget/LinearLayout;
.source "MessageHeaderView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Landroid/widget/PopupMenu$OnMenuItemClickListener;
.implements Lcom/android/mail/browse/ConversationContainer$DetachListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/browse/MessageHeaderView$RecipientListsBuilder;,
        Lcom/android/mail/browse/MessageHeaderView$MessageHeaderViewCallbacks;
    }
.end annotation


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private mAccountController:Lcom/android/mail/browse/ConversationViewAdapter$ConversationAccountController;

.field private mAddressCache:Ljava/util/Map;
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

.field private mAttachmentIcon:Landroid/view/View;

.field private mBcc:[Ljava/lang/String;

.field private mBottomBorderView:Landroid/view/View;

.field private mCallbacks:Lcom/android/mail/browse/MessageHeaderView$MessageHeaderViewCallbacks;

.field private mCc:[Ljava/lang/String;

.field private mCollapsedDetailsValid:Z

.field private mCollapsedDetailsView:Landroid/view/ViewGroup;

.field private mCollapsedStarVis:I

.field private final mContactInfoObserver:Landroid/database/DataSetObserver;

.field private mContactInfoSource:Lcom/android/mail/ContactInfoSource;

.field private mDateBuilder:Lcom/android/mail/FormattedDateBuilder;

.field private mDetailsPopup:Landroid/app/AlertDialog;

.field private mDraftIcon:Landroid/view/View;

.field private mEditDraftButton:Landroid/view/View;

.field private mExpandMode:I

.field private mExpandable:Z

.field private mExpandedDetailsValid:Z

.field private mExpandedDetailsView:Landroid/view/ViewGroup;

.field private mForwardButton:Landroid/view/View;

.field private mFrom:[Ljava/lang/String;

.field private mImagePromptView:Landroid/view/ViewGroup;

.field private final mInflater:Landroid/view/LayoutInflater;

.field private mInviteView:Lcom/android/mail/browse/MessageInviteView;

.field private mIsDraft:Z

.field private mIsSending:Z

.field private mIsSnappy:Z

.field private mLeftSpacer:Landroid/view/View;

.field private mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

.field private mMessageHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

.field private mObservingContactInfo:Z

.field private mOverflowButton:Landroid/view/View;

.field private mPhotoSpacerView:Landroid/view/View;

.field private mPhotoView:Landroid/widget/QuickContactBadge;

.field private mPopup:Landroid/widget/PopupMenu;

.field private mPreMeasuring:Z

.field private mPresenceView:Landroid/widget/ImageView;

.field private mQueryHandler:Landroid/content/AsyncQueryHandler;

.field private mReplyAllButton:Landroid/view/View;

.field private mReplyButton:Landroid/view/View;

.field private mReplyTo:[Ljava/lang/String;

.field private mRightSpacer:Landroid/view/View;

.field private mSender:Lcom/android/mail/providers/Address;

.field private mSenderEmailView:Landroid/widget/TextView;

.field private mSenderNameView:Landroid/widget/TextView;

.field private mShowImagePrompt:Z

.field private mSnippet:Ljava/lang/String;

.field private mSpamWarningView:Lcom/android/mail/browse/SpamWarningView;

.field private mStarView:Landroid/widget/ImageView;

.field private mTimestampMs:J

.field private mTimestampShort:Ljava/lang/CharSequence;

.field private mTitleContainerCollapsedMarginRight:I

.field private mTitleContainerView:Landroid/view/ViewGroup;

.field private mTo:[Ljava/lang/String;

.field private mUpperDateView:Landroid/widget/TextView;

.field private mUpperHeaderView:Landroid/view/ViewGroup;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 87
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/browse/MessageHeaderView;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 210
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/android/mail/browse/MessageHeaderView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 211
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 214
    const/4 v0, -0x1

    invoke-direct {p0, p1, p2, v0}, Lcom/android/mail/browse/MessageHeaderView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 215
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    const/4 v1, 0x0

    .line 218
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 130
    iput-boolean v1, p0, Lcom/android/mail/browse/MessageHeaderView;->mIsDraft:Z

    .line 185
    new-instance v0, Lcom/android/mail/browse/MessageHeaderView$1;

    invoke-direct {v0, p0}, Lcom/android/mail/browse/MessageHeaderView$1;-><init>(Lcom/android/mail/browse/MessageHeaderView;)V

    iput-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mContactInfoObserver:Landroid/database/DataSetObserver;

    .line 192
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mExpandable:Z

    .line 194
    iput v1, p0, Lcom/android/mail/browse/MessageHeaderView;->mExpandMode:I

    .line 220
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mInflater:Landroid/view/LayoutInflater;

    .line 221
    return-void
.end method

.method static synthetic access$000(Lcom/android/mail/browse/MessageHeaderView;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/browse/MessageHeaderView;

    .prologue
    .line 65
    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->updateContactInfo()V

    return-void
.end method

.method static synthetic access$100(Ljava/util/Map;Ljava/lang/String;)Lcom/android/mail/providers/Address;
    .locals 1
    .param p0, "x0"    # Ljava/util/Map;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 65
    invoke-static {p0, p1}, Lcom/android/mail/browse/MessageHeaderView;->getAddress(Ljava/util/Map;Ljava/lang/String;)Lcom/android/mail/providers/Address;

    move-result-object v0

    return-object v0
.end method

.method private ensureExpandedDetailsView()Z
    .locals 12

    .prologue
    const/4 v9, 0x1

    const/4 v4, 0x0

    .line 1104
    .line 1105
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mExpandedDetailsView:Landroid/view/ViewGroup;

    if-nez v0, :cond_3

    .line 1106
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mInflater:Landroid/view/LayoutInflater;

    const v1, 0x7f040029

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 1108
    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1110
    check-cast v0, Landroid/view/ViewGroup;

    iput-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mExpandedDetailsView:Landroid/view/ViewGroup;

    move v11, v9

    .line 1113
    :goto_0
    iget-boolean v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mExpandedDetailsValid:Z

    if-nez v0, :cond_2

    .line 1114
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessageHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    iget-object v0, v0, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->timestampLong:Ljava/lang/CharSequence;

    if-nez v0, :cond_0

    .line 1115
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessageHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    iget-object v1, p0, Lcom/android/mail/browse/MessageHeaderView;->mDateBuilder:Lcom/android/mail/FormattedDateBuilder;

    iget-wide v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mTimestampMs:J

    invoke-virtual {v1, v2, v3}, Lcom/android/mail/FormattedDateBuilder;->formatLongDateTime(J)Ljava/lang/CharSequence;

    move-result-object v1

    iput-object v1, v0, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->timestampLong:Ljava/lang/CharSequence;

    .line 1117
    :cond_0
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mExpandedDetailsView:Landroid/view/ViewGroup;

    const v1, 0x7f100079

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iget-object v1, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessageHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    iget-object v1, v1, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->timestampLong:Ljava/lang/CharSequence;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1119
    const v1, 0x7f10007d

    const v2, 0x7f10007f

    iget-object v3, p0, Lcom/android/mail/browse/MessageHeaderView;->mReplyTo:[Ljava/lang/String;

    iget-object v5, p0, Lcom/android/mail/browse/MessageHeaderView;->mExpandedDetailsView:Landroid/view/ViewGroup;

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lcom/android/mail/browse/MessageHeaderView;->renderEmailList(II[Ljava/lang/String;ZLandroid/view/View;)V

    .line 1121
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    iget-object v0, v0, Lcom/android/mail/providers/Message;->viaDomain:Ljava/lang/String;

    if-eqz v0, :cond_1

    .line 1122
    const v6, 0x7f10007a

    const v7, 0x7f10007c

    iget-object v8, p0, Lcom/android/mail/browse/MessageHeaderView;->mFrom:[Ljava/lang/String;

    iget-object v10, p0, Lcom/android/mail/browse/MessageHeaderView;->mExpandedDetailsView:Landroid/view/ViewGroup;

    move-object v5, p0

    invoke-direct/range {v5 .. v10}, Lcom/android/mail/browse/MessageHeaderView;->renderEmailList(II[Ljava/lang/String;ZLandroid/view/View;)V

    .line 1124
    :cond_1
    const v1, 0x7f100080

    const v2, 0x7f100082

    iget-object v3, p0, Lcom/android/mail/browse/MessageHeaderView;->mTo:[Ljava/lang/String;

    iget-object v5, p0, Lcom/android/mail/browse/MessageHeaderView;->mExpandedDetailsView:Landroid/view/ViewGroup;

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lcom/android/mail/browse/MessageHeaderView;->renderEmailList(II[Ljava/lang/String;ZLandroid/view/View;)V

    .line 1125
    const v1, 0x7f100083

    const v2, 0x7f100085

    iget-object v3, p0, Lcom/android/mail/browse/MessageHeaderView;->mCc:[Ljava/lang/String;

    iget-object v5, p0, Lcom/android/mail/browse/MessageHeaderView;->mExpandedDetailsView:Landroid/view/ViewGroup;

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lcom/android/mail/browse/MessageHeaderView;->renderEmailList(II[Ljava/lang/String;ZLandroid/view/View;)V

    .line 1126
    const v1, 0x7f100086

    const v2, 0x7f100088

    iget-object v3, p0, Lcom/android/mail/browse/MessageHeaderView;->mBcc:[Ljava/lang/String;

    iget-object v5, p0, Lcom/android/mail/browse/MessageHeaderView;->mExpandedDetailsView:Landroid/view/ViewGroup;

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lcom/android/mail/browse/MessageHeaderView;->renderEmailList(II[Ljava/lang/String;ZLandroid/view/View;)V

    .line 1128
    iput-boolean v9, p0, Lcom/android/mail/browse/MessageHeaderView;->mExpandedDetailsValid:Z

    .line 1130
    :cond_2
    return v11

    :cond_3
    move v11, v4

    goto :goto_0
.end method

.method private getAccount()Lcom/android/mail/providers/Account;
    .locals 1

    .prologue
    .line 347
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mAccountController:Lcom/android/mail/browse/ConversationViewAdapter$ConversationAccountController;

    invoke-interface {v0}, Lcom/android/mail/browse/ConversationViewAdapter$ConversationAccountController;->getAccount()Lcom/android/mail/providers/Account;

    move-result-object v0

    return-object v0
.end method

.method private getAddress(Ljava/lang/String;)Lcom/android/mail/providers/Address;
    .locals 1
    .param p1, "emailStr"    # Ljava/lang/String;

    .prologue
    .line 442
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mAddressCache:Ljava/util/Map;

    invoke-static {v0, p1}, Lcom/android/mail/browse/MessageHeaderView;->getAddress(Ljava/util/Map;Ljava/lang/String;)Lcom/android/mail/providers/Address;

    move-result-object v0

    return-object v0
.end method

.method private static getAddress(Ljava/util/Map;Ljava/lang/String;)Lcom/android/mail/providers/Address;
    .locals 1
    .param p1, "emailStr"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/android/mail/providers/Address;",
            ">;",
            "Ljava/lang/String;",
            ")",
            "Lcom/android/mail/providers/Address;"
        }
    .end annotation

    .prologue
    .line 446
    .local p0, "cache":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/android/mail/providers/Address;>;"
    const/4 v0, 0x0

    .line 447
    .local v0, "addr":Lcom/android/mail/providers/Address;
    if-eqz p0, :cond_0

    .line 448
    invoke-interface {p0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "addr":Lcom/android/mail/providers/Address;
    check-cast v0, Lcom/android/mail/providers/Address;

    .line 450
    .restart local v0    # "addr":Lcom/android/mail/providers/Address;
    :cond_0
    if-nez v0, :cond_1

    .line 451
    invoke-static {p1}, Lcom/android/mail/providers/Address;->getEmailAddress(Ljava/lang/String;)Lcom/android/mail/providers/Address;

    move-result-object v0

    .line 452
    if-eqz p0, :cond_1

    .line 453
    invoke-interface {p0, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 456
    :cond_1
    return-object v0
.end method

.method private getHeaderSubtitle()Ljava/lang/CharSequence;
    .locals 6

    .prologue
    .line 496
    iget-boolean v1, p0, Lcom/android/mail/browse/MessageHeaderView;->mIsSending:Z

    if-eqz v1, :cond_0

    .line 497
    const/4 v0, 0x0

    .line 510
    .local v0, "sub":Ljava/lang/CharSequence;
    :goto_0
    return-object v0

    .line 499
    .end local v0    # "sub":Ljava/lang/CharSequence;
    :cond_0
    invoke-virtual {p0}, Lcom/android/mail/browse/MessageHeaderView;->isExpanded()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 500
    iget-object v1, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    iget-object v1, v1, Lcom/android/mail/providers/Message;->viaDomain:Ljava/lang/String;

    if-eqz v1, :cond_1

    .line 501
    invoke-virtual {p0}, Lcom/android/mail/browse/MessageHeaderView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0c00f4

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    iget-object v5, v5, Lcom/android/mail/providers/Message;->viaDomain:Ljava/lang/String;

    aput-object v5, v3, v4

    invoke-virtual {v1, v2, v3}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .restart local v0    # "sub":Ljava/lang/CharSequence;
    goto :goto_0

    .line 504
    .end local v0    # "sub":Ljava/lang/CharSequence;
    :cond_1
    iget-object v1, p0, Lcom/android/mail/browse/MessageHeaderView;->mSender:Lcom/android/mail/providers/Address;

    invoke-static {v1}, Lcom/android/mail/browse/MessageHeaderView;->getSenderAddress(Lcom/android/mail/providers/Address;)Ljava/lang/CharSequence;

    move-result-object v0

    .restart local v0    # "sub":Ljava/lang/CharSequence;
    goto :goto_0

    .line 507
    .end local v0    # "sub":Ljava/lang/CharSequence;
    :cond_2
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mSnippet:Ljava/lang/String;

    .restart local v0    # "sub":Ljava/lang/CharSequence;
    goto :goto_0
.end method

.method private getHeaderTitle()Ljava/lang/CharSequence;
    .locals 4

    .prologue
    .line 483
    iget-boolean v1, p0, Lcom/android/mail/browse/MessageHeaderView;->mIsDraft:Z

    if-eqz v1, :cond_0

    .line 484
    invoke-virtual {p0}, Lcom/android/mail/browse/MessageHeaderView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f110002

    const/4 v3, 0x1

    invoke-virtual {v1, v2, v3}, Landroid/content/res/Resources;->getQuantityText(II)Ljava/lang/CharSequence;

    move-result-object v0

    .line 491
    .local v0, "title":Ljava/lang/CharSequence;
    :goto_0
    return-object v0

    .line 485
    .end local v0    # "title":Ljava/lang/CharSequence;
    :cond_0
    iget-boolean v1, p0, Lcom/android/mail/browse/MessageHeaderView;->mIsSending:Z

    if-eqz v1, :cond_1

    .line 486
    invoke-virtual {p0}, Lcom/android/mail/browse/MessageHeaderView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0c0099

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .restart local v0    # "title":Ljava/lang/CharSequence;
    goto :goto_0

    .line 488
    .end local v0    # "title":Ljava/lang/CharSequence;
    :cond_1
    iget-object v1, p0, Lcom/android/mail/browse/MessageHeaderView;->mSender:Lcom/android/mail/providers/Address;

    invoke-static {v1}, Lcom/android/mail/browse/MessageHeaderView;->getSenderName(Lcom/android/mail/providers/Address;)Ljava/lang/CharSequence;

    move-result-object v0

    .restart local v0    # "title":Ljava/lang/CharSequence;
    goto :goto_0
.end method

.method private getQueryHandler()Landroid/content/AsyncQueryHandler;
    .locals 2

    .prologue
    .line 1057
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mQueryHandler:Landroid/content/AsyncQueryHandler;

    if-nez v0, :cond_0

    .line 1058
    new-instance v0, Lcom/android/mail/browse/MessageHeaderView$2;

    invoke-virtual {p0}, Lcom/android/mail/browse/MessageHeaderView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Lcom/android/mail/browse/MessageHeaderView$2;-><init>(Lcom/android/mail/browse/MessageHeaderView;Landroid/content/ContentResolver;)V

    iput-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mQueryHandler:Landroid/content/AsyncQueryHandler;

    .line 1060
    :cond_0
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mQueryHandler:Landroid/content/AsyncQueryHandler;

    return-object v0
.end method

.method static getRecipientSummaryText(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;Ljava/util/Map;)Ljava/lang/CharSequence;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "me"    # Ljava/lang/String;
    .param p2, "to"    # [Ljava/lang/String;
    .param p3, "cc"    # [Ljava/lang/String;
    .param p4, "bcc"    # [Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            "[",
            "Ljava/lang/String;",
            "[",
            "Ljava/lang/String;",
            "[",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/android/mail/providers/Address;",
            ">;)",
            "Ljava/lang/CharSequence;"
        }
    .end annotation

    .prologue
    .line 741
    .local p5, "addressCache":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/android/mail/providers/Address;>;"
    new-instance v0, Lcom/android/mail/browse/MessageHeaderView$RecipientListsBuilder;

    invoke-direct {v0, p0, p1, p5}, Lcom/android/mail/browse/MessageHeaderView$RecipientListsBuilder;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/util/Map;)V

    .line 743
    .local v0, "builder":Lcom/android/mail/browse/MessageHeaderView$RecipientListsBuilder;
    const v1, 0x7f0c00be

    invoke-virtual {v0, p2, v1}, Lcom/android/mail/browse/MessageHeaderView$RecipientListsBuilder;->append([Ljava/lang/String;I)V

    .line 744
    const v1, 0x7f0c00bf

    invoke-virtual {v0, p3, v1}, Lcom/android/mail/browse/MessageHeaderView$RecipientListsBuilder;->append([Ljava/lang/String;I)V

    .line 745
    const v1, 0x7f0c00c0

    invoke-virtual {v0, p4, v1}, Lcom/android/mail/browse/MessageHeaderView$RecipientListsBuilder;->append([Ljava/lang/String;I)V

    .line 747
    invoke-virtual {v0}, Lcom/android/mail/browse/MessageHeaderView$RecipientListsBuilder;->build()Ljava/lang/CharSequence;

    move-result-object v1

    return-object v1
.end method

.method private static getSenderAddress(Lcom/android/mail/providers/Address;)Ljava/lang/CharSequence;
    .locals 2
    .param p0, "sender"    # Lcom/android/mail/providers/Address;

    .prologue
    .line 525
    if-nez p0, :cond_0

    const-string v0, ""

    .line 526
    .local v0, "displayName":Ljava/lang/String;
    :goto_0
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    const/4 v1, 0x0

    :goto_1
    return-object v1

    .line 525
    .end local v0    # "displayName":Ljava/lang/String;
    :cond_0
    invoke-virtual {p0}, Lcom/android/mail/providers/Address;->getName()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 526
    .restart local v0    # "displayName":Ljava/lang/String;
    :cond_1
    invoke-virtual {p0}, Lcom/android/mail/providers/Address;->getAddress()Ljava/lang/String;

    move-result-object v1

    goto :goto_1
.end method

.method private static getSenderName(Lcom/android/mail/providers/Address;)Ljava/lang/CharSequence;
    .locals 2
    .param p0, "sender"    # Lcom/android/mail/providers/Address;

    .prologue
    .line 517
    invoke-virtual {p0}, Lcom/android/mail/providers/Address;->getName()Ljava/lang/String;

    move-result-object v0

    .line 518
    .local v0, "displayName":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-virtual {p0}, Lcom/android/mail/providers/Address;->getAddress()Ljava/lang/String;

    move-result-object v0

    .end local v0    # "displayName":Ljava/lang/String;
    :cond_0
    return-object v0
.end method

.method private handleShowImagePromptClick(Landroid/view/View;)V
    .locals 5

    .prologue
    const/4 v4, 0x0

    const v3, 0x7f0c00c2

    const/4 v2, 0x0

    .line 1025
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 1026
    if-nez v0, :cond_0

    .line 1054
    :goto_0
    return-void

    .line 1029
    :cond_0
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    goto :goto_0

    .line 1031
    :pswitch_0
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mCallbacks:Lcom/android/mail/browse/MessageHeaderView$MessageHeaderViewCallbacks;

    if-eqz v0, :cond_1

    .line 1032
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mCallbacks:Lcom/android/mail/browse/MessageHeaderView$MessageHeaderViewCallbacks;

    iget-object v1, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    invoke-interface {v0, v1}, Lcom/android/mail/browse/MessageHeaderView$MessageHeaderViewCallbacks;->showExternalResources(Lcom/android/mail/providers/Message;)V

    .line 1034
    :cond_1
    const v0, 0x7f100094

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 1035
    invoke-virtual {p0}, Lcom/android/mail/browse/MessageHeaderView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 1037
    const v0, 0x7f100095

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 1038
    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setText(I)V

    .line 1039
    const/4 v0, 0x2

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 1041
    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->updateSpacerHeight()V

    goto :goto_0

    .line 1044
    :pswitch_1
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->getQueryHandler()Landroid/content/AsyncQueryHandler;

    move-result-object v1

    invoke-virtual {v0, v1, v2, v4}, Lcom/android/mail/browse/MessageCursor$ConversationMessage;->markAlwaysShowImages(Landroid/content/AsyncQueryHandler;ILjava/lang/Object;)V

    .line 1046
    iput-boolean v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mShowImagePrompt:Z

    .line 1047
    invoke-virtual {p1, v4}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 1048
    const/16 v0, 0x8

    invoke-virtual {p1, v0}, Landroid/view/View;->setVisibility(I)V

    .line 1049
    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->updateSpacerHeight()V

    .line 1050
    invoke-virtual {p0}, Lcom/android/mail/browse/MessageHeaderView;->getContext()Landroid/content/Context;

    move-result-object v0

    const v1, 0x7f0c00c3

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    goto :goto_0

    .line 1029
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method private hideCollapsedDetails()V
    .locals 2

    .prologue
    .line 962
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mCollapsedDetailsView:Landroid/view/ViewGroup;

    if-eqz v0, :cond_0

    .line 963
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mCollapsedDetailsView:Landroid/view/ViewGroup;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 965
    :cond_0
    return-void
.end method

.method private hideDetailsPopup()V
    .locals 1

    .prologue
    .line 1149
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mDetailsPopup:Landroid/app/AlertDialog;

    if-eqz v0, :cond_0

    .line 1150
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mDetailsPopup:Landroid/app/AlertDialog;

    invoke-virtual {v0}, Landroid/app/AlertDialog;->hide()V

    .line 1152
    :cond_0
    return-void
.end method

.method private hideExpandedDetails()V
    .locals 2

    .prologue
    .line 968
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mExpandedDetailsView:Landroid/view/ViewGroup;

    if-eqz v0, :cond_0

    .line 969
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mExpandedDetailsView:Landroid/view/ViewGroup;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 971
    :cond_0
    return-void
.end method

.method private hideInvite()V
    .locals 2

    .prologue
    .line 974
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mInviteView:Lcom/android/mail/browse/MessageInviteView;

    if-eqz v0, :cond_0

    .line 975
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mInviteView:Lcom/android/mail/browse/MessageInviteView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/MessageInviteView;->setVisibility(I)V

    .line 977
    :cond_0
    return-void
.end method

.method private hideShowImagePrompt()V
    .locals 2

    .prologue
    .line 990
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mImagePromptView:Landroid/view/ViewGroup;

    if-eqz v0, :cond_0

    .line 991
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mImagePromptView:Landroid/view/ViewGroup;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 993
    :cond_0
    return-void
.end method

.method private hideSpamWarning()V
    .locals 2

    .prologue
    .line 1009
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mSpamWarningView:Lcom/android/mail/browse/SpamWarningView;

    if-eqz v0, :cond_0

    .line 1010
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mSpamWarningView:Lcom/android/mail/browse/SpamWarningView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/SpamWarningView;->setVisibility(I)V

    .line 1012
    :cond_0
    return-void
.end method

.method static makeSnippet(Ljava/lang/String;)Ljava/lang/String;
    .locals 9

    .prologue
    const/16 v8, 0x3c

    const/16 v7, 0x3b

    const/16 v6, 0x26

    const/4 v5, -0x1

    .line 1164
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1165
    const/4 v0, 0x0

    .line 1245
    :goto_0
    return-object v0

    .line 1168
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    const/16 v0, 0x64

    invoke-direct {v1, v0}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 1170
    new-instance v2, Ljava/io/StringReader;

    invoke-direct {v2, p0}, Ljava/io/StringReader;-><init>(Ljava/lang/String;)V

    .line 1173
    :cond_1
    :goto_1
    :try_start_0
    invoke-virtual {v2}, Ljava/io/StringReader;->read()I

    move-result v0

    if-eq v0, v5, :cond_3

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->length()I

    move-result v3

    const/16 v4, 0x64

    if-ge v3, v4, :cond_3

    .line 1175
    invoke-static {v0}, Ljava/lang/Character;->isWhitespace(I)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 1176
    const/16 v0, 0x20

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1178
    :cond_2
    invoke-virtual {v2}, Ljava/io/StringReader;->read()I

    move-result v0

    .line 1179
    invoke-static {v0}, Ljava/lang/Character;->isWhitespace(I)Z
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v3

    if-nez v3, :cond_2

    .line 1180
    if-ne v0, v5, :cond_4

    .line 1245
    :cond_3
    :goto_2
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1185
    :cond_4
    if-ne v0, v8, :cond_7

    .line 1188
    :cond_5
    :try_start_1
    invoke-virtual {v2}, Ljava/io/StringReader;->read()I

    move-result v0

    if-eq v0, v5, :cond_6

    .line 1189
    const/16 v3, 0x3e

    if-ne v0, v3, :cond_5

    .line 1195
    :cond_6
    if-ne v0, v5, :cond_1

    goto :goto_2

    .line 1198
    :cond_7
    if-ne v0, v6, :cond_12

    .line 1200
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 1202
    :goto_3
    invoke-virtual {v2}, Ljava/io/StringReader;->read()I

    move-result v3

    if-eq v3, v5, :cond_8

    .line 1203
    if-ne v3, v7, :cond_a

    .line 1209
    :cond_8
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1210
    const-string v4, "nbsp"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_b

    .line 1211
    const/16 v0, 0x20

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1231
    :cond_9
    :goto_4
    if-ne v3, v5, :cond_1

    goto :goto_2

    .line 1206
    :cond_a
    int-to-char v3, v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_3

    .line 1241
    :catch_0
    move-exception v0

    .line 1242
    sget-object v2, Lcom/android/mail/browse/MessageHeaderView;->LOG_TAG:Ljava/lang/String;

    const-string v3, "Really? IOException while reading a freaking string?!? "

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v2, v0, v3, v4}, Lcom/android/mail/utils/LogUtils;->wtf(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_2

    .line 1212
    :cond_b
    :try_start_2
    const-string v4, "lt"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_c

    .line 1213
    const/16 v0, 0x3c

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_4

    .line 1214
    :cond_c
    const-string v4, "gt"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_d

    .line 1215
    const/16 v0, 0x3e

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_4

    .line 1216
    :cond_d
    const-string v4, "amp"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_e

    .line 1217
    const/16 v0, 0x26

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_4

    .line 1218
    :cond_e
    const-string v4, "quot"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_f

    .line 1219
    const/16 v0, 0x22

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_4

    .line 1220
    :cond_f
    const-string v4, "apos"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_10

    const-string v4, "#39"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_11

    .line 1221
    :cond_10
    const/16 v0, 0x27

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_4

    .line 1224
    :cond_11
    const/16 v4, 0x26

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1225
    if-ne v3, v7, :cond_9

    .line 1226
    const/16 v0, 0x3b

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_4

    .line 1238
    :cond_12
    int-to-char v0, v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    goto/16 :goto_1
.end method

.method private measureHeight()I
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 469
    invoke-virtual {p0}, Lcom/android/mail/browse/MessageHeaderView;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    check-cast v1, Landroid/view/ViewGroup;

    .line 470
    .local v1, "parent":Landroid/view/ViewGroup;
    if-nez v1, :cond_0

    .line 471
    sget-object v2, Lcom/android/mail/browse/MessageHeaderView;->LOG_TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/Error;

    invoke-direct {v3}, Ljava/lang/Error;-><init>()V

    const-string v4, "Unable to measure height of detached header"

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v2, v3, v4, v5}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 472
    invoke-virtual {p0}, Lcom/android/mail/browse/MessageHeaderView;->getHeight()I

    move-result v0

    .line 477
    :goto_0
    return v0

    .line 474
    :cond_0
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mPreMeasuring:Z

    .line 475
    invoke-static {p0, v1}, Lcom/android/mail/utils/Utils;->measureViewHeight(Landroid/view/View;Landroid/view/ViewGroup;)I

    move-result v0

    .line 476
    .local v0, "h":I
    iput-boolean v5, p0, Lcom/android/mail/browse/MessageHeaderView;->mPreMeasuring:Z

    goto :goto_0
.end method

.method private varargs registerMessageClickTargets([I)V
    .locals 5
    .param p1, "ids"    # [I

    .prologue
    .line 265
    move-object v0, p1

    .local v0, "arr$":[I
    array-length v3, v0

    .local v3, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v3, :cond_1

    aget v2, v0, v1

    .line 266
    .local v2, "id":I
    invoke-virtual {p0, v2}, Lcom/android/mail/browse/MessageHeaderView;->findViewById(I)Landroid/view/View;

    move-result-object v4

    .line 267
    .local v4, "v":Landroid/view/View;
    if-eqz v4, :cond_0

    .line 268
    invoke-virtual {v4, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 265
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 271
    .end local v2    # "id":I
    .end local v4    # "v":Landroid/view/View;
    :cond_1
    return-void
.end method

.method private render(Z)V
    .locals 7
    .param p1, "measureOnly"    # Z

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 364
    new-instance v1, Lcom/android/mail/perf/Timer;

    invoke-direct {v1}, Lcom/android/mail/perf/Timer;-><init>()V

    .line 365
    .local v1, "t":Lcom/android/mail/perf/Timer;
    const-string v4, "message header render"

    invoke-virtual {v1, v4}, Lcom/android/mail/perf/Timer;->start(Ljava/lang/String;)V

    .line 367
    iput-boolean v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mCollapsedDetailsValid:Z

    .line 368
    iput-boolean v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mExpandedDetailsValid:Z

    .line 370
    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessageHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    invoke-virtual {v4}, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->getMessage()Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    move-result-object v4

    iput-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    .line 371
    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    invoke-virtual {v4}, Lcom/android/mail/browse/MessageCursor$ConversationMessage;->shouldShowImagePrompt()Z

    move-result v4

    iput-boolean v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mShowImagePrompt:Z

    .line 372
    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessageHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    invoke-virtual {v4}, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->isExpanded()Z

    move-result v4

    invoke-direct {p0, v4}, Lcom/android/mail/browse/MessageHeaderView;->setExpanded(Z)V

    .line 374
    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    iget-wide v4, v4, Lcom/android/mail/providers/Message;->dateReceivedMs:J

    iput-wide v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mTimestampMs:J

    .line 375
    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessageHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    iget-object v4, v4, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->timestampShort:Ljava/lang/CharSequence;

    iput-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mTimestampShort:Ljava/lang/CharSequence;

    .line 376
    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mTimestampShort:Ljava/lang/CharSequence;

    if-nez v4, :cond_0

    .line 377
    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mDateBuilder:Lcom/android/mail/FormattedDateBuilder;

    iget-wide v5, p0, Lcom/android/mail/browse/MessageHeaderView;->mTimestampMs:J

    invoke-virtual {v4, v5, v6}, Lcom/android/mail/FormattedDateBuilder;->formatShortDate(J)Ljava/lang/CharSequence;

    move-result-object v4

    iput-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mTimestampShort:Ljava/lang/CharSequence;

    .line 378
    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessageHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    iget-object v5, p0, Lcom/android/mail/browse/MessageHeaderView;->mTimestampShort:Ljava/lang/CharSequence;

    iput-object v5, v4, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->timestampShort:Ljava/lang/CharSequence;

    .line 381
    :cond_0
    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    invoke-virtual {v4}, Lcom/android/mail/browse/MessageCursor$ConversationMessage;->getFromAddresses()[Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mFrom:[Ljava/lang/String;

    .line 382
    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    invoke-virtual {v4}, Lcom/android/mail/browse/MessageCursor$ConversationMessage;->getToAddresses()[Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mTo:[Ljava/lang/String;

    .line 383
    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    invoke-virtual {v4}, Lcom/android/mail/browse/MessageCursor$ConversationMessage;->getCcAddresses()[Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mCc:[Ljava/lang/String;

    .line 384
    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    invoke-virtual {v4}, Lcom/android/mail/browse/MessageCursor$ConversationMessage;->getBccAddresses()[Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mBcc:[Ljava/lang/String;

    .line 385
    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    invoke-virtual {v4}, Lcom/android/mail/browse/MessageCursor$ConversationMessage;->getReplyToAddresses()[Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mReplyTo:[Ljava/lang/String;

    .line 392
    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    iget v4, v4, Lcom/android/mail/providers/Message;->draftType:I

    if-eqz v4, :cond_1

    move v2, v3

    :cond_1
    iput-boolean v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mIsDraft:Z

    .line 393
    iget-object v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    iget-boolean v2, v2, Lcom/android/mail/providers/Message;->isSending:Z

    iput-boolean v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mIsSending:Z

    .line 402
    iget-object v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    iget-object v0, v2, Lcom/android/mail/providers/Message;->from:Ljava/lang/String;

    .line 403
    .local v0, "from":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 404
    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->getAccount()Lcom/android/mail/providers/Account;

    move-result-object v2

    iget-object v0, v2, Landroid/accounts/Account;->name:Ljava/lang/String;

    .line 406
    :cond_2
    invoke-direct {p0, v0}, Lcom/android/mail/browse/MessageHeaderView;->getAddress(Ljava/lang/String;)Lcom/android/mail/providers/Address;

    move-result-object v2

    iput-object v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mSender:Lcom/android/mail/providers/Address;

    .line 408
    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->updateChildVisibility()V

    .line 410
    iget-boolean v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mIsDraft:Z

    if-nez v2, :cond_3

    iget-boolean v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mIsSending:Z

    if-eqz v2, :cond_6

    .line 411
    :cond_3
    iget-object v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    iget-object v2, v2, Lcom/android/mail/providers/Message;->snippet:Ljava/lang/String;

    invoke-static {v2}, Lcom/android/mail/browse/MessageHeaderView;->makeSnippet(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mSnippet:Ljava/lang/String;

    .line 416
    :goto_0
    iget-object v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mSenderNameView:Landroid/widget/TextView;

    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->getHeaderTitle()Ljava/lang/CharSequence;

    move-result-object v4

    invoke-virtual {v2, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 417
    iget-object v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mSenderEmailView:Landroid/widget/TextView;

    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->getHeaderSubtitle()Ljava/lang/CharSequence;

    move-result-object v4

    invoke-virtual {v2, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 419
    iget-object v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mUpperDateView:Landroid/widget/TextView;

    if-eqz v2, :cond_4

    .line 420
    iget-object v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mUpperDateView:Landroid/widget/TextView;

    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mTimestampShort:Ljava/lang/CharSequence;

    invoke-virtual {v2, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 423
    :cond_4
    iget-object v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mStarView:Landroid/widget/ImageView;

    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    iget-boolean v4, v4, Lcom/android/mail/providers/Message;->starred:Z

    invoke-virtual {v2, v4}, Landroid/widget/ImageView;->setSelected(Z)V

    .line 424
    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mStarView:Landroid/widget/ImageView;

    invoke-virtual {p0}, Lcom/android/mail/browse/MessageHeaderView;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    iget-object v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mStarView:Landroid/widget/ImageView;

    invoke-virtual {v2}, Landroid/widget/ImageView;->isSelected()Z

    move-result v2

    if-eqz v2, :cond_7

    const v2, 0x7f0c003f

    :goto_1
    invoke-virtual {v5, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v4, v2}, Landroid/widget/ImageView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 427
    if-eqz p1, :cond_8

    .line 429
    invoke-virtual {p0}, Lcom/android/mail/browse/MessageHeaderView;->unbind()V

    .line 438
    :cond_5
    :goto_2
    const-string v2, "message header render"

    invoke-virtual {v1, v2}, Lcom/android/mail/perf/Timer;->pause(Ljava/lang/String;)V

    .line 439
    return-void

    .line 413
    :cond_6
    iget-object v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    iget-object v2, v2, Lcom/android/mail/providers/Message;->snippet:Ljava/lang/String;

    iput-object v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mSnippet:Ljava/lang/String;

    goto :goto_0

    .line 424
    :cond_7
    const v2, 0x7f0c003e

    goto :goto_1

    .line 431
    :cond_8
    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->updateContactInfo()V

    .line 432
    iget-boolean v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mObservingContactInfo:Z

    if-nez v2, :cond_5

    .line 433
    iget-object v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mContactInfoSource:Lcom/android/mail/ContactInfoSource;

    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mContactInfoObserver:Landroid/database/DataSetObserver;

    invoke-interface {v2, v4}, Lcom/android/mail/ContactInfoSource;->registerObserver(Landroid/database/DataSetObserver;)V

    .line 434
    iput-boolean v3, p0, Lcom/android/mail/browse/MessageHeaderView;->mObservingContactInfo:Z

    goto :goto_2
.end method

.method private renderEmailList(II[Ljava/lang/String;ZLandroid/view/View;)V
    .locals 10
    .param p1, "rowRes"    # I
    .param p2, "valueRes"    # I
    .param p3, "emails"    # [Ljava/lang/String;
    .param p4, "showViaDomain"    # Z
    .param p5, "rootView"    # Landroid/view/View;

    .prologue
    .line 636
    if-eqz p3, :cond_0

    array-length v5, p3

    if-nez v5, :cond_1

    .line 661
    :cond_0
    :goto_0
    return-void

    .line 639
    :cond_1
    array-length v5, p3

    new-array v2, v5, [Ljava/lang/String;

    .line 640
    .local v2, "formattedEmails":[Ljava/lang/String;
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_1
    array-length v5, p3

    if-ge v3, v5, :cond_5

    .line 641
    aget-object v5, p3, v3

    invoke-direct {p0, v5}, Lcom/android/mail/browse/MessageHeaderView;->getAddress(Ljava/lang/String;)Lcom/android/mail/providers/Address;

    move-result-object v1

    .line 642
    .local v1, "e":Lcom/android/mail/providers/Address;
    invoke-virtual {v1}, Lcom/android/mail/providers/Address;->getName()Ljava/lang/String;

    move-result-object v4

    .line 643
    .local v4, "name":Ljava/lang/String;
    invoke-virtual {v1}, Lcom/android/mail/providers/Address;->getAddress()Ljava/lang/String;

    move-result-object v0

    .line 644
    .local v0, "addr":Ljava/lang/String;
    if-eqz v4, :cond_2

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v5

    if-nez v5, :cond_3

    .line 645
    :cond_2
    aput-object v0, v2, v3

    .line 640
    :goto_2
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 649
    :cond_3
    if-eqz p4, :cond_4

    .line 650
    invoke-virtual {p0}, Lcom/android/mail/browse/MessageHeaderView;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v6, 0x7f0c00c5

    const/4 v7, 0x3

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    aput-object v4, v7, v8

    const/4 v8, 0x1

    aput-object v0, v7, v8

    const/4 v8, 0x2

    iget-object v9, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    iget-object v9, v9, Lcom/android/mail/providers/Message;->viaDomain:Ljava/lang/String;

    aput-object v9, v7, v8

    invoke-virtual {v5, v6, v7}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v3

    goto :goto_2

    .line 654
    :cond_4
    invoke-virtual {p0}, Lcom/android/mail/browse/MessageHeaderView;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v6, 0x7f0c00c4

    const/4 v7, 0x2

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    aput-object v4, v7, v8

    const/4 v8, 0x1

    aput-object v0, v7, v8

    invoke-virtual {v5, v6, v7}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v3

    goto :goto_2

    .line 659
    .end local v0    # "addr":Ljava/lang/String;
    .end local v1    # "e":Lcom/android/mail/providers/Address;
    .end local v4    # "name":Ljava/lang/String;
    :cond_5
    invoke-virtual {p5, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    const-string v6, "\n"

    invoke-static {v6, v2}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 660
    invoke-virtual {p5, p1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method

.method private static setChildMarginRight(Landroid/view/View;I)V
    .locals 1
    .param p0, "childView"    # Landroid/view/View;
    .param p1, "marginRight"    # I

    .prologue
    .line 629
    invoke-virtual {p0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup$MarginLayoutParams;

    .line 630
    .local v0, "mlp":Landroid/view/ViewGroup$MarginLayoutParams;
    iput p1, v0, Landroid/view/ViewGroup$MarginLayoutParams;->rightMargin:I

    .line 631
    invoke-virtual {p0, v0}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 632
    return-void
.end method

.method private varargs setChildVisibility(I[Landroid/view/View;)V
    .locals 4
    .param p1, "visibility"    # I
    .param p2, "children"    # [Landroid/view/View;

    .prologue
    .line 530
    move-object v0, p2

    .local v0, "arr$":[Landroid/view/View;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_1

    aget-object v3, v0, v1

    .line 531
    .local v3, "v":Landroid/view/View;
    if-eqz v3, :cond_0

    .line 532
    invoke-virtual {v3, p1}, Landroid/view/View;->setVisibility(I)V

    .line 530
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 535
    .end local v3    # "v":Landroid/view/View;
    :cond_1
    return-void
.end method

.method private setExpanded(Z)V
    .locals 1
    .param p1, "expanded"    # Z

    .prologue
    .line 540
    invoke-virtual {p0, p1}, Lcom/android/mail/browse/MessageHeaderView;->setActivated(Z)V

    .line 541
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessageHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    if-eqz v0, :cond_0

    .line 542
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessageHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    invoke-virtual {v0, p1}, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->setExpanded(Z)V

    .line 544
    :cond_0
    return-void
.end method

.method private setMessageDetailsExpanded(Z)V
    .locals 2
    .param p1, "expand"    # Z

    .prologue
    .line 906
    iget v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mExpandMode:I

    if-nez v0, :cond_3

    .line 907
    if-eqz p1, :cond_2

    .line 908
    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->showExpandedDetails()V

    .line 909
    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->hideCollapsedDetails()V

    .line 922
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessageHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    if-eqz v0, :cond_1

    .line 923
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessageHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    iput-boolean p1, v0, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->detailsExpanded:Z

    .line 925
    :cond_1
    return-void

    .line 911
    :cond_2
    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->hideExpandedDetails()V

    .line 912
    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->showCollapsedDetails()V

    goto :goto_0

    .line 914
    :cond_3
    iget v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mExpandMode:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 915
    if-eqz p1, :cond_4

    .line 916
    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->showDetailsPopup()V

    goto :goto_0

    .line 918
    :cond_4
    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->hideDetailsPopup()V

    .line 919
    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->showCollapsedDetails()V

    goto :goto_0
.end method

.method private setReplyOrReplyAllVisible()V
    .locals 7

    .prologue
    const/4 v5, 0x2

    const/16 v2, 0x8

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 614
    iget-boolean v1, p0, Lcom/android/mail/browse/MessageHeaderView;->mIsDraft:Z

    if-eqz v1, :cond_0

    .line 615
    new-array v1, v5, [Landroid/view/View;

    iget-object v5, p0, Lcom/android/mail/browse/MessageHeaderView;->mReplyButton:Landroid/view/View;

    aput-object v5, v1, v3

    iget-object v3, p0, Lcom/android/mail/browse/MessageHeaderView;->mReplyAllButton:Landroid/view/View;

    aput-object v3, v1, v4

    invoke-direct {p0, v2, v1}, Lcom/android/mail/browse/MessageHeaderView;->setChildVisibility(I[Landroid/view/View;)V

    .line 626
    :goto_0
    return-void

    .line 617
    :cond_0
    iget-object v1, p0, Lcom/android/mail/browse/MessageHeaderView;->mOverflowButton:Landroid/view/View;

    if-nez v1, :cond_1

    .line 618
    new-array v1, v5, [Landroid/view/View;

    iget-object v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mReplyButton:Landroid/view/View;

    aput-object v2, v1, v3

    iget-object v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mReplyAllButton:Landroid/view/View;

    aput-object v2, v1, v4

    invoke-direct {p0, v3, v1}, Lcom/android/mail/browse/MessageHeaderView;->setChildVisibility(I[Landroid/view/View;)V

    goto :goto_0

    .line 622
    :cond_1
    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->getAccount()Lcom/android/mail/providers/Account;

    move-result-object v1

    iget-object v1, v1, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    iget v1, v1, Lcom/android/mail/providers/Settings;->replyBehavior:I

    if-ne v1, v4, :cond_3

    move v0, v4

    .line 624
    .local v0, "defaultReplyAll":Z
    :goto_1
    if-eqz v0, :cond_4

    move v1, v2

    :goto_2
    new-array v5, v4, [Landroid/view/View;

    iget-object v6, p0, Lcom/android/mail/browse/MessageHeaderView;->mReplyButton:Landroid/view/View;

    aput-object v6, v5, v3

    invoke-direct {p0, v1, v5}, Lcom/android/mail/browse/MessageHeaderView;->setChildVisibility(I[Landroid/view/View;)V

    .line 625
    if-eqz v0, :cond_2

    move v2, v3

    :cond_2
    new-array v1, v4, [Landroid/view/View;

    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mReplyAllButton:Landroid/view/View;

    aput-object v4, v1, v3

    invoke-direct {p0, v2, v1}, Lcom/android/mail/browse/MessageHeaderView;->setChildVisibility(I[Landroid/view/View;)V

    goto :goto_0

    .end local v0    # "defaultReplyAll":Z
    :cond_3
    move v0, v3

    .line 622
    goto :goto_1

    .restart local v0    # "defaultReplyAll":Z
    :cond_4
    move v1, v3

    .line 624
    goto :goto_2
.end method

.method private showCollapsedDetails()V
    .locals 8

    .prologue
    const/4 v7, 0x0

    .line 1068
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mCollapsedDetailsView:Landroid/view/ViewGroup;

    if-nez v0, :cond_0

    .line 1069
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mInflater:Landroid/view/LayoutInflater;

    const v1, 0x7f040028

    invoke-virtual {v0, v1, p0, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iput-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mCollapsedDetailsView:Landroid/view/ViewGroup;

    .line 1071
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mCollapsedDetailsView:Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/android/mail/browse/MessageHeaderView;->mUpperHeaderView:Landroid/view/ViewGroup;

    invoke-virtual {p0, v1}, Lcom/android/mail/browse/MessageHeaderView;->indexOfChild(Landroid/view/View;)I

    move-result v1

    add-int/lit8 v1, v1, 0x1

    invoke-virtual {p0, v0, v1}, Lcom/android/mail/browse/MessageHeaderView;->addView(Landroid/view/View;I)V

    .line 1072
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mCollapsedDetailsView:Landroid/view/ViewGroup;

    invoke-virtual {v0, p0}, Landroid/view/ViewGroup;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1074
    :cond_0
    iget-boolean v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mCollapsedDetailsValid:Z

    if-nez v0, :cond_2

    .line 1075
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessageHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    iget-object v0, v0, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->recipientSummaryText:Ljava/lang/CharSequence;

    if-nez v0, :cond_1

    .line 1076
    iget-object v6, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessageHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    invoke-virtual {p0}, Lcom/android/mail/browse/MessageHeaderView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->getAccount()Lcom/android/mail/providers/Account;

    move-result-object v1

    iget-object v1, v1, Landroid/accounts/Account;->name:Ljava/lang/String;

    iget-object v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mTo:[Ljava/lang/String;

    iget-object v3, p0, Lcom/android/mail/browse/MessageHeaderView;->mCc:[Ljava/lang/String;

    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mBcc:[Ljava/lang/String;

    iget-object v5, p0, Lcom/android/mail/browse/MessageHeaderView;->mAddressCache:Ljava/util/Map;

    invoke-static/range {v0 .. v5}, Lcom/android/mail/browse/MessageHeaderView;->getRecipientSummaryText(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;Ljava/util/Map;)Ljava/lang/CharSequence;

    move-result-object v0

    iput-object v0, v6, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->recipientSummaryText:Ljava/lang/CharSequence;

    .line 1079
    :cond_1
    const v0, 0x7f100075

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageHeaderView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iget-object v1, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessageHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    iget-object v1, v1, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->recipientSummaryText:Ljava/lang/CharSequence;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1082
    const v0, 0x7f100076

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageHeaderView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iget-object v1, p0, Lcom/android/mail/browse/MessageHeaderView;->mTimestampShort:Ljava/lang/CharSequence;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1084
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mCollapsedDetailsValid:Z

    .line 1086
    :cond_2
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mCollapsedDetailsView:Landroid/view/ViewGroup;

    invoke-virtual {v0, v7}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 1087
    return-void
.end method

.method private showDetailsPopup()V
    .locals 4

    .prologue
    .line 1134
    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->ensureExpandedDetailsView()Z

    .line 1135
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mDetailsPopup:Landroid/app/AlertDialog;

    if-nez v0, :cond_0

    .line 1136
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-virtual {p0}, Lcom/android/mail/browse/MessageHeaderView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 1137
    iget-object v1, p0, Lcom/android/mail/browse/MessageHeaderView;->mExpandedDetailsView:Landroid/view/ViewGroup;

    const v2, 0x7f100089

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v1

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 1139
    iget-object v1, p0, Lcom/android/mail/browse/MessageHeaderView;->mExpandedDetailsView:Landroid/view/ViewGroup;

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setView(Landroid/view/View;)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/android/mail/browse/MessageHeaderView;->getContext()Landroid/content/Context;

    move-result-object v2

    const v3, 0x7f0c0109

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 1142
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mDetailsPopup:Landroid/app/AlertDialog;

    .line 1146
    :goto_0
    return-void

    .line 1144
    :cond_0
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mDetailsPopup:Landroid/app/AlertDialog;

    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    goto :goto_0
.end method

.method private showExpandedDetails()V
    .locals 3

    .prologue
    .line 1096
    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->ensureExpandedDetailsView()Z

    move-result v0

    .line 1097
    .local v0, "expandedViewCreated":Z
    if-eqz v0, :cond_0

    .line 1098
    iget-object v1, p0, Lcom/android/mail/browse/MessageHeaderView;->mExpandedDetailsView:Landroid/view/ViewGroup;

    iget-object v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mUpperHeaderView:Landroid/view/ViewGroup;

    invoke-virtual {p0, v2}, Lcom/android/mail/browse/MessageHeaderView;->indexOfChild(Landroid/view/View;)I

    move-result v2

    add-int/lit8 v2, v2, 0x1

    invoke-virtual {p0, v1, v2}, Lcom/android/mail/browse/MessageHeaderView;->addView(Landroid/view/View;I)V

    .line 1100
    :cond_0
    iget-object v1, p0, Lcom/android/mail/browse/MessageHeaderView;->mExpandedDetailsView:Landroid/view/ViewGroup;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 1101
    return-void
.end method

.method private showImagePrompt()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 996
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mImagePromptView:Landroid/view/ViewGroup;

    if-nez v0, :cond_0

    .line 997
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mInflater:Landroid/view/LayoutInflater;

    const v1, 0x7f04002d

    invoke-virtual {v0, v1, p0, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    .line 999
    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageHeaderView;->addView(Landroid/view/View;)V

    .line 1000
    invoke-virtual {v0, p0}, Landroid/view/ViewGroup;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1001
    const/4 v1, 0x1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setTag(Ljava/lang/Object;)V

    .line 1003
    iput-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mImagePromptView:Landroid/view/ViewGroup;

    .line 1005
    :cond_0
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mImagePromptView:Landroid/view/ViewGroup;

    invoke-virtual {v0, v2}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 1006
    return-void
.end method

.method private showInvite()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 980
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mInviteView:Lcom/android/mail/browse/MessageInviteView;

    if-nez v0, :cond_0

    .line 981
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mInflater:Landroid/view/LayoutInflater;

    const v1, 0x7f04002c

    invoke-virtual {v0, v1, p0, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/android/mail/browse/MessageInviteView;

    iput-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mInviteView:Lcom/android/mail/browse/MessageInviteView;

    .line 983
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mInviteView:Lcom/android/mail/browse/MessageInviteView;

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageHeaderView;->addView(Landroid/view/View;)V

    .line 985
    :cond_0
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mInviteView:Lcom/android/mail/browse/MessageInviteView;

    iget-object v1, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/MessageInviteView;->bind(Lcom/android/mail/providers/Message;)V

    .line 986
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mInviteView:Lcom/android/mail/browse/MessageInviteView;

    invoke-virtual {v0, v2}, Lcom/android/mail/browse/MessageInviteView;->setVisibility(I)V

    .line 987
    return-void
.end method

.method private showSpamWarning()V
    .locals 3

    .prologue
    .line 1015
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mSpamWarningView:Lcom/android/mail/browse/SpamWarningView;

    if-nez v0, :cond_0

    .line 1016
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mInflater:Landroid/view/LayoutInflater;

    const v1, 0x7f04002e

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p0, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/android/mail/browse/SpamWarningView;

    iput-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mSpamWarningView:Lcom/android/mail/browse/SpamWarningView;

    .line 1018
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mSpamWarningView:Lcom/android/mail/browse/SpamWarningView;

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageHeaderView;->addView(Landroid/view/View;)V

    .line 1021
    :cond_0
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mSpamWarningView:Lcom/android/mail/browse/SpamWarningView;

    iget-object v1, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    iget-object v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mSender:Lcom/android/mail/providers/Address;

    invoke-virtual {v0, v1, v2}, Lcom/android/mail/browse/SpamWarningView;->showSpamWarning(Lcom/android/mail/providers/Message;Lcom/android/mail/providers/Address;)V

    .line 1022
    return-void
.end method

.method private toggleMessageDetails(Landroid/view/View;)V
    .locals 4
    .param p1, "visibleDetailsView"    # Landroid/view/View;

    .prologue
    .line 896
    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->measureHeight()I

    move-result v1

    .line 897
    .local v1, "heightBefore":I
    iget-object v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mCollapsedDetailsView:Landroid/view/ViewGroup;

    if-ne p1, v2, :cond_1

    const/4 v0, 0x1

    .line 898
    .local v0, "detailsExpanded":Z
    :goto_0
    invoke-direct {p0, v0}, Lcom/android/mail/browse/MessageHeaderView;->setMessageDetailsExpanded(Z)V

    .line 899
    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->updateSpacerHeight()V

    .line 900
    iget-object v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mCallbacks:Lcom/android/mail/browse/MessageHeaderView$MessageHeaderViewCallbacks;

    if-eqz v2, :cond_0

    .line 901
    iget-object v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mCallbacks:Lcom/android/mail/browse/MessageHeaderView$MessageHeaderViewCallbacks;

    iget-object v3, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessageHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    invoke-interface {v2, v3, v0, v1}, Lcom/android/mail/browse/MessageHeaderView$MessageHeaderViewCallbacks;->setMessageDetailsExpanded(Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;ZI)V

    .line 903
    :cond_0
    return-void

    .line 897
    .end local v0    # "detailsExpanded":Z
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private updateChildVisibility()V
    .locals 9

    .prologue
    const/4 v6, 0x3

    const/4 v8, 0x2

    const/16 v3, 0x8

    const/4 v7, 0x1

    const/4 v4, 0x0

    .line 553
    invoke-virtual {p0}, Lcom/android/mail/browse/MessageHeaderView;->isExpanded()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 556
    iget-boolean v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mIsSnappy:Z

    if-eqz v2, :cond_0

    move v2, v3

    :goto_0
    invoke-virtual {p0, v2}, Lcom/android/mail/browse/MessageHeaderView;->setMessageDetailsVisibility(I)V

    .line 558
    iget-boolean v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mIsDraft:Z

    if-eqz v2, :cond_1

    .line 559
    const/16 v1, 0x8

    .line 560
    .local v1, "normalVis":I
    const/4 v0, 0x0

    .line 566
    .local v0, "draftVis":I
    :goto_1
    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->setReplyOrReplyAllVisible()V

    .line 567
    const/4 v2, 0x5

    new-array v2, v2, [Landroid/view/View;

    iget-object v5, p0, Lcom/android/mail/browse/MessageHeaderView;->mPhotoView:Landroid/widget/QuickContactBadge;

    aput-object v5, v2, v4

    iget-object v5, p0, Lcom/android/mail/browse/MessageHeaderView;->mPhotoSpacerView:Landroid/view/View;

    aput-object v5, v2, v7

    iget-object v5, p0, Lcom/android/mail/browse/MessageHeaderView;->mForwardButton:Landroid/view/View;

    aput-object v5, v2, v8

    iget-object v5, p0, Lcom/android/mail/browse/MessageHeaderView;->mSenderEmailView:Landroid/widget/TextView;

    aput-object v5, v2, v6

    const/4 v5, 0x4

    iget-object v6, p0, Lcom/android/mail/browse/MessageHeaderView;->mOverflowButton:Landroid/view/View;

    aput-object v6, v2, v5

    invoke-direct {p0, v1, v2}, Lcom/android/mail/browse/MessageHeaderView;->setChildVisibility(I[Landroid/view/View;)V

    .line 569
    new-array v2, v8, [Landroid/view/View;

    iget-object v5, p0, Lcom/android/mail/browse/MessageHeaderView;->mDraftIcon:Landroid/view/View;

    aput-object v5, v2, v4

    iget-object v5, p0, Lcom/android/mail/browse/MessageHeaderView;->mEditDraftButton:Landroid/view/View;

    aput-object v5, v2, v7

    invoke-direct {p0, v0, v2}, Lcom/android/mail/browse/MessageHeaderView;->setChildVisibility(I[Landroid/view/View;)V

    .line 570
    new-array v2, v8, [Landroid/view/View;

    iget-object v5, p0, Lcom/android/mail/browse/MessageHeaderView;->mAttachmentIcon:Landroid/view/View;

    aput-object v5, v2, v4

    iget-object v5, p0, Lcom/android/mail/browse/MessageHeaderView;->mUpperDateView:Landroid/widget/TextView;

    aput-object v5, v2, v7

    invoke-direct {p0, v3, v2}, Lcom/android/mail/browse/MessageHeaderView;->setChildVisibility(I[Landroid/view/View;)V

    .line 571
    new-array v2, v7, [Landroid/view/View;

    iget-object v3, p0, Lcom/android/mail/browse/MessageHeaderView;->mStarView:Landroid/widget/ImageView;

    aput-object v3, v2, v4

    invoke-direct {p0, v4, v2}, Lcom/android/mail/browse/MessageHeaderView;->setChildVisibility(I[Landroid/view/View;)V

    .line 573
    iget-object v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mTitleContainerView:Landroid/view/ViewGroup;

    invoke-static {v2, v4}, Lcom/android/mail/browse/MessageHeaderView;->setChildMarginRight(Landroid/view/View;I)V

    .line 604
    .end local v0    # "draftVis":I
    .end local v1    # "normalVis":I
    :goto_2
    return-void

    :cond_0
    move v2, v4

    .line 556
    goto :goto_0

    .line 562
    :cond_1
    const/4 v1, 0x0

    .line 563
    .restart local v1    # "normalVis":I
    const/16 v0, 0x8

    .restart local v0    # "draftVis":I
    goto :goto_1

    .line 577
    .end local v0    # "draftVis":I
    .end local v1    # "normalVis":I
    :cond_2
    invoke-virtual {p0, v3}, Lcom/android/mail/browse/MessageHeaderView;->setMessageDetailsVisibility(I)V

    .line 578
    new-array v2, v8, [Landroid/view/View;

    iget-object v5, p0, Lcom/android/mail/browse/MessageHeaderView;->mSenderEmailView:Landroid/widget/TextView;

    aput-object v5, v2, v4

    iget-object v5, p0, Lcom/android/mail/browse/MessageHeaderView;->mUpperDateView:Landroid/widget/TextView;

    aput-object v5, v2, v7

    invoke-direct {p0, v4, v2}, Lcom/android/mail/browse/MessageHeaderView;->setChildVisibility(I[Landroid/view/View;)V

    .line 580
    const/4 v2, 0x4

    new-array v2, v2, [Landroid/view/View;

    iget-object v5, p0, Lcom/android/mail/browse/MessageHeaderView;->mEditDraftButton:Landroid/view/View;

    aput-object v5, v2, v4

    iget-object v5, p0, Lcom/android/mail/browse/MessageHeaderView;->mReplyButton:Landroid/view/View;

    aput-object v5, v2, v7

    iget-object v5, p0, Lcom/android/mail/browse/MessageHeaderView;->mReplyAllButton:Landroid/view/View;

    aput-object v5, v2, v8

    iget-object v5, p0, Lcom/android/mail/browse/MessageHeaderView;->mForwardButton:Landroid/view/View;

    aput-object v5, v2, v6

    invoke-direct {p0, v3, v2}, Lcom/android/mail/browse/MessageHeaderView;->setChildVisibility(I[Landroid/view/View;)V

    .line 582
    new-array v2, v7, [Landroid/view/View;

    iget-object v5, p0, Lcom/android/mail/browse/MessageHeaderView;->mOverflowButton:Landroid/view/View;

    aput-object v5, v2, v4

    invoke-direct {p0, v3, v2}, Lcom/android/mail/browse/MessageHeaderView;->setChildVisibility(I[Landroid/view/View;)V

    .line 584
    iget-object v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    iget-boolean v2, v2, Lcom/android/mail/providers/Message;->hasAttachments:Z

    if-eqz v2, :cond_3

    move v2, v4

    :goto_3
    new-array v5, v7, [Landroid/view/View;

    iget-object v6, p0, Lcom/android/mail/browse/MessageHeaderView;->mAttachmentIcon:Landroid/view/View;

    aput-object v6, v5, v4

    invoke-direct {p0, v2, v5}, Lcom/android/mail/browse/MessageHeaderView;->setChildVisibility(I[Landroid/view/View;)V

    .line 587
    iget v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mCollapsedStarVis:I

    new-array v5, v7, [Landroid/view/View;

    iget-object v6, p0, Lcom/android/mail/browse/MessageHeaderView;->mStarView:Landroid/widget/ImageView;

    aput-object v6, v5, v4

    invoke-direct {p0, v2, v5}, Lcom/android/mail/browse/MessageHeaderView;->setChildVisibility(I[Landroid/view/View;)V

    .line 589
    iget-object v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mTitleContainerView:Landroid/view/ViewGroup;

    iget v5, p0, Lcom/android/mail/browse/MessageHeaderView;->mTitleContainerCollapsedMarginRight:I

    invoke-static {v2, v5}, Lcom/android/mail/browse/MessageHeaderView;->setChildMarginRight(Landroid/view/View;I)V

    .line 591
    iget-boolean v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mIsDraft:Z

    if-eqz v2, :cond_4

    .line 593
    new-array v2, v7, [Landroid/view/View;

    iget-object v5, p0, Lcom/android/mail/browse/MessageHeaderView;->mDraftIcon:Landroid/view/View;

    aput-object v5, v2, v4

    invoke-direct {p0, v4, v2}, Lcom/android/mail/browse/MessageHeaderView;->setChildVisibility(I[Landroid/view/View;)V

    .line 594
    new-array v2, v8, [Landroid/view/View;

    iget-object v5, p0, Lcom/android/mail/browse/MessageHeaderView;->mPhotoView:Landroid/widget/QuickContactBadge;

    aput-object v5, v2, v4

    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mPhotoSpacerView:Landroid/view/View;

    aput-object v4, v2, v7

    invoke-direct {p0, v3, v2}, Lcom/android/mail/browse/MessageHeaderView;->setChildVisibility(I[Landroid/view/View;)V

    goto :goto_2

    :cond_3
    move v2, v3

    .line 584
    goto :goto_3

    .line 598
    :cond_4
    new-array v2, v7, [Landroid/view/View;

    iget-object v5, p0, Lcom/android/mail/browse/MessageHeaderView;->mDraftIcon:Landroid/view/View;

    aput-object v5, v2, v4

    invoke-direct {p0, v3, v2}, Lcom/android/mail/browse/MessageHeaderView;->setChildVisibility(I[Landroid/view/View;)V

    .line 599
    new-array v2, v8, [Landroid/view/View;

    iget-object v3, p0, Lcom/android/mail/browse/MessageHeaderView;->mPhotoView:Landroid/widget/QuickContactBadge;

    aput-object v3, v2, v4

    iget-object v3, p0, Lcom/android/mail/browse/MessageHeaderView;->mPhotoSpacerView:Landroid/view/View;

    aput-object v3, v2, v7

    invoke-direct {p0, v4, v2}, Lcom/android/mail/browse/MessageHeaderView;->setChildVisibility(I[Landroid/view/View;)V

    goto/16 :goto_2
.end method

.method private updateContactInfo()V
    .locals 10

    .prologue
    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 752
    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mPresenceView:Landroid/widget/ImageView;

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 753
    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mPresenceView:Landroid/widget/ImageView;

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 754
    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mContactInfoSource:Lcom/android/mail/ContactInfoSource;

    if-eqz v4, :cond_0

    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mSender:Lcom/android/mail/providers/Address;

    if-nez v4, :cond_2

    .line 755
    :cond_0
    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mPhotoView:Landroid/widget/QuickContactBadge;

    invoke-virtual {v4}, Landroid/widget/QuickContactBadge;->setImageToDefault()V

    .line 756
    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mPhotoView:Landroid/widget/QuickContactBadge;

    invoke-virtual {p0}, Lcom/android/mail/browse/MessageHeaderView;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v6, 0x7f0c00b8

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/QuickContactBadge;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 789
    :cond_1
    :goto_0
    return-void

    .line 764
    :cond_2
    invoke-virtual {p0}, Lcom/android/mail/browse/MessageHeaderView;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v6, 0x7f0c00b7

    new-array v7, v9, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mSender:Lcom/android/mail/providers/Address;

    invoke-virtual {v4}, Lcom/android/mail/providers/Address;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_5

    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mSender:Lcom/android/mail/providers/Address;

    invoke-virtual {v4}, Lcom/android/mail/providers/Address;->getName()Ljava/lang/String;

    move-result-object v4

    :goto_1
    aput-object v4, v7, v8

    invoke-virtual {v5, v6, v7}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 766
    .local v0, "contentDesc":Ljava/lang/String;
    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mPhotoView:Landroid/widget/QuickContactBadge;

    invoke-virtual {v4, v0}, Landroid/widget/QuickContactBadge;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 767
    const/4 v3, 0x0

    .line 768
    .local v3, "photoSet":Z
    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mSender:Lcom/android/mail/providers/Address;

    invoke-virtual {v4}, Lcom/android/mail/providers/Address;->getAddress()Ljava/lang/String;

    move-result-object v1

    .line 769
    .local v1, "email":Ljava/lang/String;
    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mContactInfoSource:Lcom/android/mail/ContactInfoSource;

    invoke-interface {v4, v1}, Lcom/android/mail/ContactInfoSource;->getContactInfo(Ljava/lang/String;)Lcom/android/mail/ContactInfo;

    move-result-object v2

    .line 770
    .local v2, "info":Lcom/android/mail/ContactInfo;
    if-eqz v2, :cond_6

    .line 771
    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mPhotoView:Landroid/widget/QuickContactBadge;

    iget-object v5, v2, Lcom/android/mail/ContactInfo;->contactUri:Landroid/net/Uri;

    invoke-virtual {v4, v5}, Landroid/widget/QuickContactBadge;->assignContactUri(Landroid/net/Uri;)V

    .line 772
    iget-object v4, v2, Lcom/android/mail/ContactInfo;->photo:Landroid/graphics/Bitmap;

    if-eqz v4, :cond_3

    .line 773
    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mPhotoView:Landroid/widget/QuickContactBadge;

    iget-object v5, v2, Lcom/android/mail/ContactInfo;->photo:Landroid/graphics/Bitmap;

    invoke-virtual {v4, v5}, Landroid/widget/QuickContactBadge;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 774
    new-array v4, v9, [Ljava/lang/Object;

    iget-object v5, p0, Lcom/android/mail/browse/MessageHeaderView;->mSender:Lcom/android/mail/providers/Address;

    invoke-virtual {v5}, Lcom/android/mail/providers/Address;->getName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v8

    invoke-static {v0, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 775
    const/4 v3, 0x1

    .line 777
    :cond_3
    iget-boolean v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mIsDraft:Z

    if-nez v4, :cond_4

    iget-object v4, v2, Lcom/android/mail/ContactInfo;->status:Ljava/lang/Integer;

    if-eqz v4, :cond_4

    .line 778
    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mPresenceView:Landroid/widget/ImageView;

    iget-object v5, v2, Lcom/android/mail/ContactInfo;->status:Ljava/lang/Integer;

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v5

    invoke-static {v5}, Landroid/provider/ContactsContract$StatusUpdates;->getPresenceIconResourceId(I)I

    move-result v5

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 780
    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mPresenceView:Landroid/widget/ImageView;

    invoke-virtual {v4, v8}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 786
    :cond_4
    :goto_2
    if-nez v3, :cond_1

    .line 787
    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mPhotoView:Landroid/widget/QuickContactBadge;

    invoke-virtual {v4}, Landroid/widget/QuickContactBadge;->setImageToDefault()V

    goto :goto_0

    .line 764
    .end local v0    # "contentDesc":Ljava/lang/String;
    .end local v1    # "email":Ljava/lang/String;
    .end local v2    # "info":Lcom/android/mail/ContactInfo;
    .end local v3    # "photoSet":Z
    :cond_5
    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mSender:Lcom/android/mail/providers/Address;

    invoke-virtual {v4}, Lcom/android/mail/providers/Address;->getAddress()Ljava/lang/String;

    move-result-object v4

    goto :goto_1

    .line 783
    .restart local v0    # "contentDesc":Ljava/lang/String;
    .restart local v1    # "email":Ljava/lang/String;
    .restart local v2    # "info":Lcom/android/mail/ContactInfo;
    .restart local v3    # "photoSet":Z
    :cond_6
    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mPhotoView:Landroid/widget/QuickContactBadge;

    invoke-virtual {v4, v1, v9}, Landroid/widget/QuickContactBadge;->assignContactFromEmail(Ljava/lang/String;Z)V

    goto :goto_2
.end method

.method private updateSpacerHeight()V
    .locals 3

    .prologue
    .line 460
    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->measureHeight()I

    move-result v0

    .line 462
    .local v0, "h":I
    iget-object v1, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessageHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    invoke-virtual {v1, v0}, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->setHeight(I)Z

    .line 463
    iget-object v1, p0, Lcom/android/mail/browse/MessageHeaderView;->mCallbacks:Lcom/android/mail/browse/MessageHeaderView$MessageHeaderViewCallbacks;

    if-eqz v1, :cond_0

    .line 464
    iget-object v1, p0, Lcom/android/mail/browse/MessageHeaderView;->mCallbacks:Lcom/android/mail/browse/MessageHeaderView$MessageHeaderViewCallbacks;

    iget-object v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessageHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    invoke-interface {v1, v2, v0}, Lcom/android/mail/browse/MessageHeaderView$MessageHeaderViewCallbacks;->setMessageSpacerHeight(Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;I)V

    .line 466
    :cond_0
    return-void
.end method


# virtual methods
.method public bind(Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;Z)V
    .locals 1
    .param p1, "headerItem"    # Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;
    .param p2, "measureOnly"    # Z

    .prologue
    .line 351
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessageHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessageHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    if-ne v0, p1, :cond_0

    .line 357
    :goto_0
    return-void

    .line 355
    :cond_0
    iput-object p1, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessageHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    .line 356
    invoke-direct {p0, p2}, Lcom/android/mail/browse/MessageHeaderView;->render(Z)V

    goto :goto_0
.end method

.method public hideMessageDetails()V
    .locals 1

    .prologue
    .line 958
    const/16 v0, 0x8

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageHeaderView;->setMessageDetailsVisibility(I)V

    .line 959
    return-void
.end method

.method public initialize(Lcom/android/mail/FormattedDateBuilder;Lcom/android/mail/browse/ConversationViewAdapter$ConversationAccountController;Ljava/util/Map;)V
    .locals 0
    .param p1, "dateBuilder"    # Lcom/android/mail/FormattedDateBuilder;
    .param p2, "accountController"    # Lcom/android/mail/browse/ConversationViewAdapter$ConversationAccountController;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/android/mail/FormattedDateBuilder;",
            "Lcom/android/mail/browse/ConversationViewAdapter$ConversationAccountController;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/android/mail/providers/Address;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 341
    .local p3, "addressCache":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/android/mail/providers/Address;>;"
    iput-object p1, p0, Lcom/android/mail/browse/MessageHeaderView;->mDateBuilder:Lcom/android/mail/FormattedDateBuilder;

    .line 342
    iput-object p2, p0, Lcom/android/mail/browse/MessageHeaderView;->mAccountController:Lcom/android/mail/browse/ConversationViewAdapter$ConversationAccountController;

    .line 343
    iput-object p3, p0, Lcom/android/mail/browse/MessageHeaderView;->mAddressCache:Ljava/util/Map;

    .line 344
    return-void
.end method

.method public isExpanded()Z
    .locals 1

    .prologue
    .line 298
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessageHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessageHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->isExpanded()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 800
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    invoke-virtual {p0, p1, v0}, Lcom/android/mail/browse/MessageHeaderView;->onClick(Landroid/view/View;I)Z

    .line 801
    return-void
.end method

.method public onClick(Landroid/view/View;I)Z
    .locals 8
    .param p1, "v"    # Landroid/view/View;
    .param p2, "id"    # I

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 808
    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    if-nez v4, :cond_0

    .line 809
    sget-object v4, Lcom/android/mail/browse/MessageHeaderView;->LOG_TAG:Ljava/lang/String;

    const-string v5, "ignoring message header tap on unbound view"

    new-array v6, v3, [Ljava/lang/Object;

    invoke-static {v4, v5, v6}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 864
    :goto_0
    return v3

    .line 813
    :cond_0
    const/4 v1, 0x1

    .line 815
    .local v1, "handled":Z
    sparse-switch p2, :sswitch_data_0

    .line 860
    sget-object v4, Lcom/android/mail/browse/MessageHeaderView;->LOG_TAG:Ljava/lang/String;

    const-string v5, "unrecognized header tap: %d"

    new-array v6, v2, [Ljava/lang/Object;

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v6, v3

    invoke-static {v4, v5, v6}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 861
    const/4 v1, 0x0

    :goto_1
    move v3, v1

    .line 864
    goto :goto_0

    .line 817
    :sswitch_0
    invoke-virtual {p0}, Lcom/android/mail/browse/MessageHeaderView;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->getAccount()Lcom/android/mail/providers/Account;

    move-result-object v4

    iget-object v5, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    invoke-static {v3, v4, v5}, Lcom/android/mail/compose/ComposeActivity;->reply(Landroid/content/Context;Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Message;)V

    goto :goto_1

    .line 820
    :sswitch_1
    invoke-virtual {p0}, Lcom/android/mail/browse/MessageHeaderView;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->getAccount()Lcom/android/mail/providers/Account;

    move-result-object v4

    iget-object v5, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    invoke-static {v3, v4, v5}, Lcom/android/mail/compose/ComposeActivity;->replyAll(Landroid/content/Context;Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Message;)V

    goto :goto_1

    .line 823
    :sswitch_2
    invoke-virtual {p0}, Lcom/android/mail/browse/MessageHeaderView;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->getAccount()Lcom/android/mail/providers/Account;

    move-result-object v4

    iget-object v5, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    invoke-static {v3, v4, v5}, Lcom/android/mail/compose/ComposeActivity;->forward(Landroid/content/Context;Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Message;)V

    goto :goto_1

    .line 826
    :sswitch_3
    invoke-virtual {p1}, Landroid/view/View;->isSelected()Z

    move-result v4

    if-nez v4, :cond_1

    .line 827
    .local v2, "newValue":Z
    :goto_2
    invoke-virtual {p1, v2}, Landroid/view/View;->setSelected(Z)V

    .line 828
    iget-object v3, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    invoke-virtual {v3, v2}, Lcom/android/mail/browse/MessageCursor$ConversationMessage;->star(Z)V

    goto :goto_1

    .end local v2    # "newValue":Z
    :cond_1
    move v2, v3

    .line 826
    goto :goto_2

    .line 832
    :sswitch_4
    invoke-virtual {p0}, Lcom/android/mail/browse/MessageHeaderView;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->getAccount()Lcom/android/mail/providers/Account;

    move-result-object v4

    iget-object v5, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    invoke-static {v3, v4, v5}, Lcom/android/mail/compose/ComposeActivity;->editDraft(Landroid/content/Context;Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Message;)V

    goto :goto_1

    .line 835
    :sswitch_5
    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mPopup:Landroid/widget/PopupMenu;

    if-nez v4, :cond_2

    .line 836
    new-instance v4, Landroid/widget/PopupMenu;

    invoke-virtual {p0}, Lcom/android/mail/browse/MessageHeaderView;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-direct {v4, v5, p1}, Landroid/widget/PopupMenu;-><init>(Landroid/content/Context;Landroid/view/View;)V

    iput-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mPopup:Landroid/widget/PopupMenu;

    .line 837
    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mPopup:Landroid/widget/PopupMenu;

    invoke-virtual {v4}, Landroid/widget/PopupMenu;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v4

    const v5, 0x7f12000a

    iget-object v6, p0, Lcom/android/mail/browse/MessageHeaderView;->mPopup:Landroid/widget/PopupMenu;

    invoke-virtual {v6}, Landroid/widget/PopupMenu;->getMenu()Landroid/view/Menu;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 839
    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mPopup:Landroid/widget/PopupMenu;

    invoke-virtual {v4, p0}, Landroid/widget/PopupMenu;->setOnMenuItemClickListener(Landroid/widget/PopupMenu$OnMenuItemClickListener;)V

    .line 841
    :cond_2
    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->getAccount()Lcom/android/mail/providers/Account;

    move-result-object v4

    iget-object v4, v4, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    iget v4, v4, Lcom/android/mail/providers/Settings;->replyBehavior:I

    if-ne v4, v2, :cond_3

    move v0, v2

    .line 843
    .local v0, "defaultReplyAll":Z
    :goto_3
    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mPopup:Landroid/widget/PopupMenu;

    invoke-virtual {v4}, Landroid/widget/PopupMenu;->getMenu()Landroid/view/Menu;

    move-result-object v4

    const v5, 0x7f1000a1

    invoke-interface {v4, v5}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v4

    invoke-interface {v4, v0}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 844
    iget-object v4, p0, Lcom/android/mail/browse/MessageHeaderView;->mPopup:Landroid/widget/PopupMenu;

    invoke-virtual {v4}, Landroid/widget/PopupMenu;->getMenu()Landroid/view/Menu;

    move-result-object v4

    const v5, 0x7f1000a2

    invoke-interface {v4, v5}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v4

    if-nez v0, :cond_4

    :goto_4
    invoke-interface {v4, v2}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 846
    iget-object v3, p0, Lcom/android/mail/browse/MessageHeaderView;->mPopup:Landroid/widget/PopupMenu;

    invoke-virtual {v3}, Landroid/widget/PopupMenu;->show()V

    goto/16 :goto_1

    .end local v0    # "defaultReplyAll":Z
    :cond_3
    move v0, v3

    .line 841
    goto :goto_3

    .restart local v0    # "defaultReplyAll":Z
    :cond_4
    move v2, v3

    .line 844
    goto :goto_4

    .line 851
    .end local v0    # "defaultReplyAll":Z
    :sswitch_6
    invoke-direct {p0, p1}, Lcom/android/mail/browse/MessageHeaderView;->toggleMessageDetails(Landroid/view/View;)V

    goto/16 :goto_1

    .line 854
    :sswitch_7
    invoke-virtual {p0}, Lcom/android/mail/browse/MessageHeaderView;->toggleExpanded()V

    goto/16 :goto_1

    .line 857
    :sswitch_8
    invoke-direct {p0, p1}, Lcom/android/mail/browse/MessageHeaderView;->handleShowImagePromptClick(Landroid/view/View;)V

    goto/16 :goto_1

    .line 815
    :sswitch_data_0
    .sparse-switch
        0x7f100060 -> :sswitch_3
        0x7f10006f -> :sswitch_5
        0x7f100074 -> :sswitch_6
        0x7f100077 -> :sswitch_6
        0x7f10008c -> :sswitch_7
        0x7f100093 -> :sswitch_8
        0x7f1000a1 -> :sswitch_0
        0x7f1000a2 -> :sswitch_1
        0x7f1000a3 -> :sswitch_4
        0x7f1000a4 -> :sswitch_2
    .end sparse-switch
.end method

.method public onDetachedFromParent()V
    .locals 0

    .prologue
    .line 319
    invoke-virtual {p0}, Lcom/android/mail/browse/MessageHeaderView;->unbind()V

    .line 320
    return-void
.end method

.method protected onFinishInflate()V
    .locals 1

    .prologue
    .line 232
    invoke-super {p0}, Landroid/widget/LinearLayout;->onFinishInflate()V

    .line 233
    const v0, 0x7f10008c

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageHeaderView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iput-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mUpperHeaderView:Landroid/view/ViewGroup;

    .line 234
    const v0, 0x7f1000a8

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageHeaderView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mSenderNameView:Landroid/widget/TextView;

    .line 235
    const v0, 0x7f1000aa

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageHeaderView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mSenderEmailView:Landroid/widget/TextView;

    .line 236
    const v0, 0x7f10009d

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageHeaderView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/QuickContactBadge;

    iput-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mPhotoView:Landroid/widget/QuickContactBadge;

    .line 237
    const v0, 0x7f10009e

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageHeaderView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mPhotoSpacerView:Landroid/view/View;

    .line 238
    const v0, 0x7f1000a1

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageHeaderView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mReplyButton:Landroid/view/View;

    .line 239
    const v0, 0x7f1000a2

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageHeaderView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mReplyAllButton:Landroid/view/View;

    .line 240
    const v0, 0x7f1000a4

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageHeaderView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mForwardButton:Landroid/view/View;

    .line 241
    const v0, 0x7f100060

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageHeaderView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mStarView:Landroid/widget/ImageView;

    .line 242
    const v0, 0x7f1000a9

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageHeaderView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mPresenceView:Landroid/widget/ImageView;

    .line 243
    const v0, 0x7f1000a5

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageHeaderView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iput-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mTitleContainerView:Landroid/view/ViewGroup;

    .line 244
    const v0, 0x7f10006f

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageHeaderView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mOverflowButton:Landroid/view/View;

    .line 245
    const v0, 0x7f10009f

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageHeaderView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mDraftIcon:Landroid/view/View;

    .line 246
    const v0, 0x7f1000a3

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageHeaderView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mEditDraftButton:Landroid/view/View;

    .line 247
    const v0, 0x7f1000a6

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageHeaderView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mUpperDateView:Landroid/widget/TextView;

    .line 248
    const v0, 0x7f1000a7

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageHeaderView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mAttachmentIcon:Landroid/view/View;

    .line 250
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mStarView:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->getVisibility()I

    move-result v0

    iput v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mCollapsedStarVis:I

    .line 251
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mTitleContainerView:Landroid/view/ViewGroup;

    invoke-virtual {v0}, Landroid/view/ViewGroup;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup$MarginLayoutParams;

    iget v0, v0, Landroid/view/ViewGroup$MarginLayoutParams;->rightMargin:I

    iput v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mTitleContainerCollapsedMarginRight:I

    .line 254
    const v0, 0x7f10008d

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageHeaderView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mBottomBorderView:Landroid/view/View;

    .line 255
    const v0, 0x7f10009c

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageHeaderView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mLeftSpacer:Landroid/view/View;

    .line 256
    const v0, 0x7f1000a0

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageHeaderView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mRightSpacer:Landroid/view/View;

    .line 258
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/android/mail/browse/MessageHeaderView;->setExpanded(Z)V

    .line 260
    const/4 v0, 0x7

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    invoke-direct {p0, v0}, Lcom/android/mail/browse/MessageHeaderView;->registerMessageClickTargets([I)V

    .line 262
    return-void

    .line 260
    :array_0
    .array-data 4
        0x7f1000a1
        0x7f1000a2
        0x7f1000a4
        0x7f100060
        0x7f1000a3
        0x7f10006f
        0x7f10008c
    .end array-data
.end method

.method protected onLayout(ZIIII)V
    .locals 2

    .prologue
    .line 1250
    new-instance v0, Lcom/android/mail/perf/Timer;

    invoke-direct {v0}, Lcom/android/mail/perf/Timer;-><init>()V

    .line 1251
    const-string v1, "message header layout"

    invoke-virtual {v0, v1}, Lcom/android/mail/perf/Timer;->start(Ljava/lang/String;)V

    .line 1252
    invoke-super/range {p0 .. p5}, Landroid/widget/LinearLayout;->onLayout(ZIIII)V

    .line 1253
    const-string v1, "message header layout"

    invoke-virtual {v0, v1}, Lcom/android/mail/perf/Timer;->pause(Ljava/lang/String;)V

    .line 1254
    return-void
.end method

.method protected onMeasure(II)V
    .locals 2

    .prologue
    .line 1258
    new-instance v0, Lcom/android/mail/perf/Timer;

    invoke-direct {v0}, Lcom/android/mail/perf/Timer;-><init>()V

    .line 1263
    invoke-super {p0, p1, p2}, Landroid/widget/LinearLayout;->onMeasure(II)V

    .line 1264
    iget-boolean v1, p0, Lcom/android/mail/browse/MessageHeaderView;->mPreMeasuring:Z

    if-nez v1, :cond_0

    .line 1265
    const-string v1, "message header measure"

    invoke-virtual {v0, v1}, Lcom/android/mail/perf/Timer;->pause(Ljava/lang/String;)V

    .line 1267
    :cond_0
    return-void
.end method

.method public onMenuItemClick(Landroid/view/MenuItem;)Z
    .locals 2
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 794
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mPopup:Landroid/widget/PopupMenu;

    invoke-virtual {v0}, Landroid/widget/PopupMenu;->dismiss()V

    .line 795
    const/4 v0, 0x0

    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    invoke-virtual {p0, v0, v1}, Lcom/android/mail/browse/MessageHeaderView;->onClick(Landroid/view/View;I)Z

    move-result v0

    return v0
.end method

.method public refresh()V
    .locals 1

    .prologue
    .line 360
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/android/mail/browse/MessageHeaderView;->render(Z)V

    .line 361
    return-void
.end method

.method public setCallbacks(Lcom/android/mail/browse/MessageHeaderView$MessageHeaderViewCallbacks;)V
    .locals 0
    .param p1, "callbacks"    # Lcom/android/mail/browse/MessageHeaderView$MessageHeaderViewCallbacks;

    .prologue
    .line 282
    iput-object p1, p0, Lcom/android/mail/browse/MessageHeaderView;->mCallbacks:Lcom/android/mail/browse/MessageHeaderView$MessageHeaderViewCallbacks;

    .line 283
    return-void
.end method

.method public setContactInfoSource(Lcom/android/mail/ContactInfoSource;)V
    .locals 0
    .param p1, "contactInfoSource"    # Lcom/android/mail/ContactInfoSource;

    .prologue
    .line 278
    iput-object p1, p0, Lcom/android/mail/browse/MessageHeaderView;->mContactInfoSource:Lcom/android/mail/ContactInfoSource;

    .line 279
    return-void
.end method

.method public setExpandMode(I)V
    .locals 0
    .param p1, "mode"    # I

    .prologue
    .line 227
    iput p1, p0, Lcom/android/mail/browse/MessageHeaderView;->mExpandMode:I

    .line 228
    return-void
.end method

.method public setExpandable(Z)V
    .locals 0
    .param p1, "expandable"    # Z

    .prologue
    .line 868
    iput-boolean p1, p0, Lcom/android/mail/browse/MessageHeaderView;->mExpandable:Z

    .line 869
    return-void
.end method

.method public setMessageDetailsVisibility(I)V
    .locals 1
    .param p1, "vis"    # I

    .prologue
    .line 928
    const/16 v0, 0x8

    if-ne p1, v0, :cond_1

    .line 929
    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->hideCollapsedDetails()V

    .line 930
    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->hideExpandedDetails()V

    .line 931
    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->hideSpamWarning()V

    .line 932
    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->hideShowImagePrompt()V

    .line 933
    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->hideInvite()V

    .line 952
    :goto_0
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mBottomBorderView:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 953
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mBottomBorderView:Landroid/view/View;

    invoke-virtual {v0, p1}, Landroid/view/View;->setVisibility(I)V

    .line 955
    :cond_0
    return-void

    .line 935
    :cond_1
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessageHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    iget-boolean v0, v0, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->detailsExpanded:Z

    invoke-direct {p0, v0}, Lcom/android/mail/browse/MessageHeaderView;->setMessageDetailsExpanded(Z)V

    .line 936
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    iget-object v0, v0, Lcom/android/mail/providers/Message;->spamWarningString:Ljava/lang/String;

    if-nez v0, :cond_2

    .line 937
    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->hideSpamWarning()V

    .line 941
    :goto_1
    iget-boolean v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mShowImagePrompt:Z

    if-eqz v0, :cond_3

    .line 942
    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->showImagePrompt()V

    .line 946
    :goto_2
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    invoke-virtual {v0}, Lcom/android/mail/browse/MessageCursor$ConversationMessage;->isFlaggedCalendarInvite()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 947
    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->showInvite()V

    goto :goto_0

    .line 939
    :cond_2
    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->showSpamWarning()V

    goto :goto_1

    .line 944
    :cond_3
    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->hideShowImagePrompt()V

    goto :goto_2

    .line 949
    :cond_4
    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->hideInvite()V

    goto :goto_0
.end method

.method public setSnappy(Z)V
    .locals 3
    .param p1, "snappy"    # Z

    .prologue
    const/16 v2, 0x8

    const/4 v1, 0x0

    .line 302
    iput-boolean p1, p0, Lcom/android/mail/browse/MessageHeaderView;->mIsSnappy:Z

    .line 303
    invoke-virtual {p0}, Lcom/android/mail/browse/MessageHeaderView;->hideMessageDetails()V

    .line 304
    if-eqz p1, :cond_0

    .line 305
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageHeaderView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 307
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mLeftSpacer:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 308
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mRightSpacer:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 315
    :goto_0
    return-void

    .line 310
    :cond_0
    const v0, 0x106000b

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageHeaderView;->setBackgroundColor(I)V

    .line 312
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mLeftSpacer:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 313
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mRightSpacer:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method

.method public toggleExpanded()V
    .locals 3

    .prologue
    .line 872
    iget-boolean v1, p0, Lcom/android/mail/browse/MessageHeaderView;->mExpandable:Z

    if-nez v1, :cond_1

    .line 893
    :cond_0
    :goto_0
    return-void

    .line 875
    :cond_1
    invoke-virtual {p0}, Lcom/android/mail/browse/MessageHeaderView;->isExpanded()Z

    move-result v1

    if-nez v1, :cond_3

    const/4 v1, 0x1

    :goto_1
    invoke-direct {p0, v1}, Lcom/android/mail/browse/MessageHeaderView;->setExpanded(Z)V

    .line 878
    iget-boolean v1, p0, Lcom/android/mail/browse/MessageHeaderView;->mIsSnappy:Z

    if-nez v1, :cond_2

    .line 879
    iget-object v1, p0, Lcom/android/mail/browse/MessageHeaderView;->mSenderNameView:Landroid/widget/TextView;

    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->getHeaderTitle()Ljava/lang/CharSequence;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 880
    iget-object v1, p0, Lcom/android/mail/browse/MessageHeaderView;->mSenderEmailView:Landroid/widget/TextView;

    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->getHeaderSubtitle()Ljava/lang/CharSequence;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 883
    :cond_2
    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->updateChildVisibility()V

    .line 888
    invoke-direct {p0}, Lcom/android/mail/browse/MessageHeaderView;->measureHeight()I

    move-result v0

    .line 889
    .local v0, "h":I
    iget-object v1, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessageHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    invoke-virtual {v1, v0}, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->setHeight(I)Z

    .line 890
    iget-object v1, p0, Lcom/android/mail/browse/MessageHeaderView;->mCallbacks:Lcom/android/mail/browse/MessageHeaderView$MessageHeaderViewCallbacks;

    if-eqz v1, :cond_0

    .line 891
    iget-object v1, p0, Lcom/android/mail/browse/MessageHeaderView;->mCallbacks:Lcom/android/mail/browse/MessageHeaderView$MessageHeaderViewCallbacks;

    iget-object v2, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessageHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    invoke-interface {v1, v2, v0}, Lcom/android/mail/browse/MessageHeaderView$MessageHeaderViewCallbacks;->setMessageExpanded(Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;I)V

    goto :goto_0

    .line 875
    .end local v0    # "h":I
    :cond_3
    const/4 v1, 0x0

    goto :goto_1
.end method

.method public unbind()V
    .locals 2

    .prologue
    const/4 v0, 0x0

    .line 329
    iput-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessageHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    .line 330
    iput-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    .line 332
    iget-boolean v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mObservingContactInfo:Z

    if-eqz v0, :cond_0

    .line 333
    iget-object v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mContactInfoSource:Lcom/android/mail/ContactInfoSource;

    iget-object v1, p0, Lcom/android/mail/browse/MessageHeaderView;->mContactInfoObserver:Landroid/database/DataSetObserver;

    invoke-interface {v0, v1}, Lcom/android/mail/ContactInfoSource;->unregisterObserver(Landroid/database/DataSetObserver;)V

    .line 334
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/mail/browse/MessageHeaderView;->mObservingContactInfo:Z

    .line 336
    :cond_0
    return-void
.end method
