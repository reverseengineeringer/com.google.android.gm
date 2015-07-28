.class public Lcom/android/mail/compose/ComposeActivity;
.super Landroid/app/Activity;
.source "ComposeActivity.java"

# interfaces
.implements Landroid/app/ActionBar$OnNavigationListener;
.implements Landroid/app/LoaderManager$LoaderCallbacks;
.implements Landroid/content/DialogInterface$OnClickListener;
.implements Landroid/text/TextWatcher;
.implements Landroid/view/View$OnClickListener;
.implements Landroid/widget/TextView$OnEditorActionListener;
.implements Lcom/android/mail/compose/AttachmentsView$AttachmentAddedOrDeletedListener;
.implements Lcom/android/mail/compose/FromAddressSpinner$OnAccountChangedListener;
.implements Lcom/android/mail/compose/QuotedTextView$RespondInlineListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/compose/ComposeActivity$RecipientTextWatcher;,
        Lcom/android/mail/compose/ComposeActivity$ComposeModeAdapter;,
        Lcom/android/mail/compose/ComposeActivity$SendOrSaveMessage;,
        Lcom/android/mail/compose/ComposeActivity$SendOrSaveTask;,
        Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/app/Activity;",
        "Landroid/view/View$OnClickListener;",
        "Landroid/app/ActionBar$OnNavigationListener;",
        "Lcom/android/mail/compose/QuotedTextView$RespondInlineListener;",
        "Landroid/content/DialogInterface$OnClickListener;",
        "Landroid/text/TextWatcher;",
        "Lcom/android/mail/compose/AttachmentsView$AttachmentAddedOrDeletedListener;",
        "Lcom/android/mail/compose/FromAddressSpinner$OnAccountChangedListener;",
        "Landroid/app/LoaderManager$LoaderCallbacks",
        "<",
        "Landroid/database/Cursor;",
        ">;",
        "Landroid/widget/TextView$OnEditorActionListener;"
    }
.end annotation


# static fields
.field static final ALL_EXTRAS:[Ljava/lang/String;

.field private static final EXTRA_FOCUS_SELECTION_END:Ljava/lang/String;

.field private static final LOG_TAG:Ljava/lang/String;

.field private static sRequestMessageIdMap:Ljava/util/concurrent/ConcurrentHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ConcurrentHashMap",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field

.field private static sTestSendOrSaveCallback:Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;


# instance fields
.field private mAccount:Lcom/android/mail/providers/Account;

.field private mAccounts:[Lcom/android/mail/providers/Account;

.field public mActiveTasks:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/android/mail/compose/ComposeActivity$SendOrSaveTask;",
            ">;"
        }
    .end annotation
.end field

.field private mAddingAttachment:Z

.field private mAttachmentsChanged:Z

.field private mAttachmentsView:Lcom/android/mail/compose/AttachmentsView;

.field private mBcc:Lcom/android/ex/chips/RecipientEditTextView;

.field private mBccListener:Lcom/android/mail/compose/ComposeActivity$RecipientTextWatcher;

.field private mBodyView:Landroid/widget/EditText;

.field private mCachedSettings:Lcom/android/mail/providers/Settings;

.field private mCc:Lcom/android/ex/chips/RecipientEditTextView;

.field private mCcBccButton:Landroid/widget/Button;

.field private mCcBccView:Lcom/android/mail/compose/CcBccView;

.field private mCcListener:Lcom/android/mail/compose/ComposeActivity$RecipientTextWatcher;

.field private mComposeMode:I

.field private mComposeModeAdapter:Lcom/android/mail/compose/ComposeActivity$ComposeModeAdapter;

.field private mDraft:Lcom/android/mail/providers/Message;

.field private mDraftId:J

.field private mDraftLock:Ljava/lang/Object;

.field private mForward:Z

.field protected mFromSpinner:Lcom/android/mail/compose/FromAddressSpinner;

.field private mFromSpinnerWrapper:Landroid/view/View;

.field private mFromStatic:Landroid/view/View;

.field private mFromStaticText:Landroid/widget/TextView;

.field private mLaunchedFromEmail:Z

.field private mPhotoAttachmentsButton:Landroid/view/View;

.field private mQuotedTextView:Lcom/android/mail/compose/QuotedTextView;

.field private mRecipient:Ljava/lang/String;

.field private mRecipientErrorDialog:Landroid/app/AlertDialog;

.field protected mRefMessage:Lcom/android/mail/providers/Message;

.field private mRefMessageUri:Landroid/net/Uri;

.field private mReplyFromAccount:Lcom/android/mail/providers/ReplyFromAccount;

.field private mReplyFromChanged:Z

.field private mRequestId:I

.field private mSave:Landroid/view/MenuItem;

.field private mSavedInstanceState:Landroid/os/Bundle;

.field private mSend:Landroid/view/MenuItem;

.field private mSendConfirmDialog:Landroid/app/AlertDialog;

.field private mSendSaveTaskHandler:Landroid/os/Handler;

.field private mSignature:Ljava/lang/String;

.field private mSubject:Landroid/widget/TextView;

.field private mTextChanged:Z

.field private mTo:Lcom/android/ex/chips/RecipientEditTextView;

.field private mToListener:Lcom/android/mail/compose/ComposeActivity$RecipientTextWatcher;

.field private mValidator:Lcom/android/common/Rfc822Validator;

.field private mVideoAttachmentsButton:Landroid/view/View;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 144
    const/4 v0, 0x5

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "subject"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "body"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "to"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "cc"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string v2, "bcc"

    aput-object v2, v0, v1

    sput-object v0, Lcom/android/mail/compose/ComposeActivity;->ALL_EXTRAS:[Ljava/lang/String;

    .line 146
    sput-object v3, Lcom/android/mail/compose/ComposeActivity;->sTestSendOrSaveCallback:Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;

    .line 159
    sput-object v3, Lcom/android/mail/compose/ComposeActivity;->sRequestMessageIdMap:Ljava/util/concurrent/ConcurrentHashMap;

    .line 181
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/compose/ComposeActivity;->LOG_TAG:Ljava/lang/String;

    .line 191
    sput-object v3, Lcom/android/mail/compose/ComposeActivity;->EXTRA_FOCUS_SELECTION_END:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    .line 109
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 203
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mSendSaveTaskHandler:Landroid/os/Handler;

    .line 217
    const/4 v0, -0x1

    iput v0, p0, Lcom/android/mail/compose/ComposeActivity;->mComposeMode:I

    .line 237
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/android/mail/compose/ComposeActivity;->mDraftId:J

    .line 239
    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mDraftLock:Ljava/lang/Object;

    .line 246
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/mail/compose/ComposeActivity;->mLaunchedFromEmail:Z

    .line 1873
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mActiveTasks:Ljava/util/ArrayList;

    .line 2740
    return-void
.end method

.method static synthetic access$000(Lcom/android/mail/compose/ComposeActivity;)Lcom/android/ex/chips/RecipientEditTextView;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/compose/ComposeActivity;

    .prologue
    .line 109
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mTo:Lcom/android/ex/chips/RecipientEditTextView;

    return-object v0
.end method

.method static synthetic access$1000(Lcom/android/mail/compose/ComposeActivity;)Lcom/android/mail/providers/Account;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/compose/ComposeActivity;

    .prologue
    .line 109
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    return-object v0
.end method

.method static synthetic access$102(Lcom/android/mail/compose/ComposeActivity;Landroid/app/AlertDialog;)Landroid/app/AlertDialog;
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/compose/ComposeActivity;
    .param p1, "x1"    # Landroid/app/AlertDialog;

    .prologue
    .line 109
    iput-object p1, p0, Lcom/android/mail/compose/ComposeActivity;->mRecipientErrorDialog:Landroid/app/AlertDialog;

    return-object p1
.end method

.method static synthetic access$1100(Lcom/android/mail/compose/ComposeActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/compose/ComposeActivity;

    .prologue
    .line 109
    invoke-direct {p0}, Lcom/android/mail/compose/ComposeActivity;->discardChanges()V

    return-void
.end method

.method static synthetic access$200(Lcom/android/mail/compose/ComposeActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/compose/ComposeActivity;

    .prologue
    .line 109
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mBodyView:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$300(Lcom/android/mail/compose/ComposeActivity;Landroid/text/Spanned;ZZZ)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/compose/ComposeActivity;
    .param p1, "x1"    # Landroid/text/Spanned;
    .param p2, "x2"    # Z
    .param p3, "x3"    # Z
    .param p4, "x4"    # Z

    .prologue
    .line 109
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/android/mail/compose/ComposeActivity;->sendOrSave(Landroid/text/Spanned;ZZZ)V

    return-void
.end method

.method static synthetic access$400()Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;
    .locals 1

    .prologue
    .line 109
    sget-object v0, Lcom/android/mail/compose/ComposeActivity;->sTestSendOrSaveCallback:Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;

    return-object v0
.end method

.method static synthetic access$500(Lcom/android/mail/compose/ComposeActivity;)Ljava/lang/Object;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/compose/ComposeActivity;

    .prologue
    .line 109
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mDraftLock:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic access$600(Lcom/android/mail/compose/ComposeActivity;)J
    .locals 2
    .param p0, "x0"    # Lcom/android/mail/compose/ComposeActivity;

    .prologue
    .line 109
    iget-wide v0, p0, Lcom/android/mail/compose/ComposeActivity;->mDraftId:J

    return-wide v0
.end method

.method static synthetic access$602(Lcom/android/mail/compose/ComposeActivity;J)J
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/compose/ComposeActivity;
    .param p1, "x1"    # J

    .prologue
    .line 109
    iput-wide p1, p0, Lcom/android/mail/compose/ComposeActivity;->mDraftId:J

    return-wide p1
.end method

.method static synthetic access$700(Lcom/android/mail/compose/ComposeActivity;)Lcom/android/mail/providers/Message;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/compose/ComposeActivity;

    .prologue
    .line 109
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mDraft:Lcom/android/mail/providers/Message;

    return-object v0
.end method

.method static synthetic access$702(Lcom/android/mail/compose/ComposeActivity;Lcom/android/mail/providers/Message;)Lcom/android/mail/providers/Message;
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/compose/ComposeActivity;
    .param p1, "x1"    # Lcom/android/mail/providers/Message;

    .prologue
    .line 109
    iput-object p1, p0, Lcom/android/mail/compose/ComposeActivity;->mDraft:Lcom/android/mail/providers/Message;

    return-object p1
.end method

.method static synthetic access$800()Ljava/util/concurrent/ConcurrentHashMap;
    .locals 1

    .prologue
    .line 109
    sget-object v0, Lcom/android/mail/compose/ComposeActivity;->sRequestMessageIdMap:Ljava/util/concurrent/ConcurrentHashMap;

    return-object v0
.end method

.method static synthetic access$900(Lcom/android/mail/compose/ComposeActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/compose/ComposeActivity;

    .prologue
    .line 109
    invoke-direct {p0}, Lcom/android/mail/compose/ComposeActivity;->saveRequestMap()V

    return-void
.end method

.method private addAddressToList(Ljava/lang/String;Lcom/android/ex/chips/RecipientEditTextView;)V
    .locals 4

    .prologue
    .line 1520
    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    .line 1528
    :cond_0
    return-void

    .line 1523
    :cond_1
    invoke-static {p1}, Landroid/text/util/Rfc822Tokenizer;->tokenize(Ljava/lang/CharSequence;)[Landroid/text/util/Rfc822Token;

    move-result-object v1

    .line 1525
    const/4 v0, 0x0

    :goto_0
    array-length v2, v1

    if-ge v0, v2, :cond_0

    .line 1526
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    aget-object v3, v1, v0

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p2, v2}, Lcom/android/ex/chips/RecipientEditTextView;->append(Ljava/lang/CharSequence;)V

    .line 1525
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method private addBccAddresses(Ljava/util/Collection;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1462
    .local p1, "addresses":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mBcc:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-virtual {p0, p1, v0}, Lcom/android/mail/compose/ComposeActivity;->addAddressesToList(Ljava/util/Collection;Lcom/android/ex/chips/RecipientEditTextView;)V

    .line 1463
    return-void
.end method

.method private addCcAddresses(Ljava/util/Collection;Ljava/util/Collection;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1457
    .local p1, "addresses":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    .local p2, "toAddresses":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    invoke-virtual {p0, p1}, Lcom/android/mail/compose/ComposeActivity;->tokenizeAddressList(Ljava/util/Collection;)Ljava/util/List;

    move-result-object v1

    if-eqz p2, :cond_0

    invoke-virtual {p0, p2}, Lcom/android/mail/compose/ComposeActivity;->tokenizeAddressList(Ljava/util/Collection;)Ljava/util/List;

    move-result-object v0

    :goto_0
    iget-object v2, p0, Lcom/android/mail/compose/ComposeActivity;->mCc:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-virtual {p0, v1, v0, v2}, Lcom/android/mail/compose/ComposeActivity;->addCcAddressesToList(Ljava/util/List;Ljava/util/List;Lcom/android/ex/chips/RecipientEditTextView;)V

    .line 1459
    return-void

    .line 1457
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private addRecipients(Ljava/lang/String;Ljava/util/Set;[Ljava/lang/String;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;[",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 1557
    array-length v1, p3

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v1, :cond_1

    aget-object v2, p3, v0

    .line 1560
    invoke-static {v2}, Lcom/android/mail/providers/Address;->getEmailAddress(Ljava/lang/String;)Lcom/android/mail/providers/Address;

    move-result-object v3

    invoke-virtual {v3}, Lcom/android/mail/providers/Address;->getAddress()Ljava/lang/String;

    move-result-object v3

    .line 1561
    invoke-virtual {p0, p1, v3}, Lcom/android/mail/compose/ComposeActivity;->recipientMatchesThisAccount(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 1562
    const-string v3, "\"\""

    const-string v4, ""

    invoke-virtual {v2, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {p2, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 1557
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 1565
    :cond_1
    return-void
.end method

.method private addToAddresses(Ljava/util/Collection;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1453
    .local p1, "addresses":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mTo:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-virtual {p0, p1, v0}, Lcom/android/mail/compose/ComposeActivity;->addAddressesToList(Ljava/util/Collection;Lcom/android/ex/chips/RecipientEditTextView;)V

    .line 1454
    return-void
.end method

.method private appendSignature()V
    .locals 4

    .prologue
    .line 2573
    iget-object v2, p0, Lcom/android/mail/compose/ComposeActivity;->mCachedSettings:Lcom/android/mail/providers/Settings;

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/android/mail/compose/ComposeActivity;->mCachedSettings:Lcom/android/mail/providers/Settings;

    iget-object v1, v2, Lcom/android/mail/providers/Settings;->signature:Ljava/lang/String;

    .line 2574
    .local v1, "newSignature":Ljava/lang/String;
    :goto_0
    iget-object v2, p0, Lcom/android/mail/compose/ComposeActivity;->mBodyView:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->hasFocus()Z

    move-result v0

    .line 2575
    .local v0, "hasFocus":Z
    iget-object v2, p0, Lcom/android/mail/compose/ComposeActivity;->mSignature:Ljava/lang/String;

    invoke-static {v1, v2}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 2576
    iput-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mSignature:Ljava/lang/String;

    .line 2577
    iget-object v2, p0, Lcom/android/mail/compose/ComposeActivity;->mSignature:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    iget-object v2, p0, Lcom/android/mail/compose/ComposeActivity;->mSignature:Ljava/lang/String;

    iget-object v3, p0, Lcom/android/mail/compose/ComposeActivity;->mBodyView:Landroid/widget/EditText;

    invoke-virtual {v3}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v2, v3}, Lcom/android/mail/compose/ComposeActivity;->getSignatureStartPosition(Ljava/lang/String;Ljava/lang/String;)I

    move-result v2

    if-gez v2, :cond_0

    .line 2581
    iget-object v2, p0, Lcom/android/mail/compose/ComposeActivity;->mBodyView:Landroid/widget/EditText;

    invoke-virtual {v2, p0}, Landroid/widget/EditText;->removeTextChangedListener(Landroid/text/TextWatcher;)V

    .line 2582
    iget-object v2, p0, Lcom/android/mail/compose/ComposeActivity;->mBodyView:Landroid/widget/EditText;

    iget-object v3, p0, Lcom/android/mail/compose/ComposeActivity;->mSignature:Ljava/lang/String;

    invoke-direct {p0, v3}, Lcom/android/mail/compose/ComposeActivity;->convertToPrintableSignature(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/EditText;->append(Ljava/lang/CharSequence;)V

    .line 2583
    iget-object v2, p0, Lcom/android/mail/compose/ComposeActivity;->mBodyView:Landroid/widget/EditText;

    invoke-virtual {v2, p0}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 2585
    :cond_0
    if-eqz v0, :cond_1

    .line 2586
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->focusBody()V

    .line 2589
    :cond_1
    return-void

    .line 2573
    .end local v0    # "hasFocus":Z
    .end local v1    # "newSignature":Ljava/lang/String;
    :cond_2
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private checkValidAccounts()V
    .locals 9

    .prologue
    const/4 v8, 0x0

    .line 398
    invoke-static {p0}, Lcom/android/mail/utils/AccountUtils;->getAccounts(Landroid/content/Context;)[Lcom/android/mail/providers/Account;

    move-result-object v6

    iput-object v6, p0, Lcom/android/mail/compose/ComposeActivity;->mAccounts:[Lcom/android/mail/providers/Account;

    .line 399
    iget-object v6, p0, Lcom/android/mail/compose/ComposeActivity;->mAccounts:[Lcom/android/mail/providers/Account;

    if-eqz v6, :cond_0

    iget-object v6, p0, Lcom/android/mail/compose/ComposeActivity;->mAccounts:[Lcom/android/mail/providers/Account;

    array-length v6, v6

    if-nez v6, :cond_2

    .line 400
    :cond_0
    invoke-static {p0}, Lcom/android/mail/providers/MailAppProvider;->getNoAccountIntent(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v5

    .line 401
    .local v5, "noAccountIntent":Landroid/content/Intent;
    if-eqz v5, :cond_1

    .line 402
    const/4 v6, 0x2

    invoke-virtual {p0, v5, v6}, Lcom/android/mail/compose/ComposeActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 421
    .end local v5    # "noAccountIntent":Landroid/content/Intent;
    :cond_1
    :goto_0
    return-void

    .line 406
    :cond_2
    const/4 v1, 0x0

    .line 407
    .local v1, "anySyncing":Z
    iget-object v2, p0, Lcom/android/mail/compose/ComposeActivity;->mAccounts:[Lcom/android/mail/providers/Account;

    .local v2, "arr$":[Lcom/android/mail/providers/Account;
    array-length v4, v2

    .local v4, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_1
    if-ge v3, v4, :cond_3

    aget-object v0, v2, v3

    .line 408
    .local v0, "a":Lcom/android/mail/providers/Account;
    invoke-virtual {v0}, Lcom/android/mail/providers/Account;->isAccountReady()Z

    move-result v6

    if-eqz v6, :cond_4

    .line 409
    const/4 v1, 0x1

    .line 413
    .end local v0    # "a":Lcom/android/mail/providers/Account;
    :cond_3
    if-nez v1, :cond_5

    .line 415
    iput-object v8, p0, Lcom/android/mail/compose/ComposeActivity;->mAccounts:[Lcom/android/mail/providers/Account;

    .line 416
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v6

    const/4 v7, 0x1

    invoke-virtual {v6, v7, v8, p0}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    goto :goto_0

    .line 407
    .restart local v0    # "a":Lcom/android/mail/providers/Account;
    :cond_4
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 419
    .end local v0    # "a":Lcom/android/mail/providers/Account;
    :cond_5
    invoke-direct {p0}, Lcom/android/mail/compose/ComposeActivity;->finishCreate()V

    goto :goto_0
.end method

.method private clearChangeListeners()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 938
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mSubject:Landroid/widget/TextView;

    invoke-virtual {v0, p0}, Landroid/widget/TextView;->removeTextChangedListener(Landroid/text/TextWatcher;)V

    .line 939
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mBodyView:Landroid/widget/EditText;

    invoke-virtual {v0, p0}, Landroid/widget/EditText;->removeTextChangedListener(Landroid/text/TextWatcher;)V

    .line 940
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mTo:Lcom/android/ex/chips/RecipientEditTextView;

    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mToListener:Lcom/android/mail/compose/ComposeActivity$RecipientTextWatcher;

    invoke-virtual {v0, v1}, Lcom/android/ex/chips/RecipientEditTextView;->removeTextChangedListener(Landroid/text/TextWatcher;)V

    .line 941
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mCc:Lcom/android/ex/chips/RecipientEditTextView;

    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mCcListener:Lcom/android/mail/compose/ComposeActivity$RecipientTextWatcher;

    invoke-virtual {v0, v1}, Lcom/android/ex/chips/RecipientEditTextView;->removeTextChangedListener(Landroid/text/TextWatcher;)V

    .line 942
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mBcc:Lcom/android/ex/chips/RecipientEditTextView;

    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mBccListener:Lcom/android/mail/compose/ComposeActivity$RecipientTextWatcher;

    invoke-virtual {v0, v1}, Lcom/android/ex/chips/RecipientEditTextView;->removeTextChangedListener(Landroid/text/TextWatcher;)V

    .line 943
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mFromSpinner:Lcom/android/mail/compose/FromAddressSpinner;

    invoke-virtual {v0, v2}, Lcom/android/mail/compose/FromAddressSpinner;->setOnAccountChangedListener(Lcom/android/mail/compose/FromAddressSpinner$OnAccountChangedListener;)V

    .line 944
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAttachmentsView:Lcom/android/mail/compose/AttachmentsView;

    invoke-virtual {v0, v2}, Lcom/android/mail/compose/AttachmentsView;->setAttachmentChangesListener(Lcom/android/mail/compose/AttachmentsView$AttachmentAddedOrDeletedListener;)V

    .line 945
    return-void
.end method

.method private clearImeText()V
    .locals 1

    .prologue
    .line 1773
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mBodyView:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->clearComposingText()V

    .line 1774
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mBodyView:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getEditableText()Landroid/text/Editable;

    move-result-object v0

    invoke-static {v0}, Landroid/view/inputmethod/BaseInputConnection;->removeComposingSpans(Landroid/text/Spannable;)V

    .line 1775
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mSubject:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->clearComposingText()V

    .line 1776
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mSubject:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getEditableText()Landroid/text/Editable;

    move-result-object v0

    invoke-static {v0}, Landroid/view/inputmethod/BaseInputConnection;->removeComposingSpans(Landroid/text/Spannable;)V

    .line 1777
    return-void
.end method

.method public static compose(Landroid/content/Context;Lcom/android/mail/providers/Account;)V
    .locals 2
    .param p0, "launcher"    # Landroid/content/Context;
    .param p1, "account"    # Lcom/android/mail/providers/Account;

    .prologue
    .line 265
    const/4 v0, 0x0

    const/4 v1, -0x1

    invoke-static {p0, p1, v0, v1}, Lcom/android/mail/compose/ComposeActivity;->launch(Landroid/content/Context;Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Message;I)V

    .line 266
    return-void
.end method

.method private convertToHashSet(Ljava/util/List;)Ljava/util/HashSet;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<[",
            "Landroid/text/util/Rfc822Token;",
            ">;)",
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1493
    .local p1, "list":Ljava/util/List;, "Ljava/util/List<[Landroid/text/util/Rfc822Token;>;"
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    .line 1494
    .local v0, "hash":Ljava/util/HashSet;, "Ljava/util/HashSet<Ljava/lang/String;>;"
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, [Landroid/text/util/Rfc822Token;

    .line 1495
    .local v3, "tokens":[Landroid/text/util/Rfc822Token;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v4, v3

    if-ge v1, v4, :cond_0

    .line 1496
    aget-object v4, v3, v1

    invoke-virtual {v4}, Landroid/text/util/Rfc822Token;->getAddress()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 1495
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 1499
    .end local v1    # "i":I
    .end local v3    # "tokens":[Landroid/text/util/Rfc822Token;
    :cond_1
    return-object v0
.end method

.method private convertToPrintableSignature(Ljava/lang/String;)Ljava/lang/String;
    .locals 3

    .prologue
    .line 2592
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0c0038

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 2593
    if-nez p1, :cond_0

    .line 2594
    const-string p1, ""

    .line 2596
    :cond_0
    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private createMessage(Lcom/android/mail/providers/ReplyFromAccount;I)Lcom/android/mail/providers/Message;
    .locals 13
    .param p1, "selectedReplyFromAccount"    # Lcom/android/mail/providers/ReplyFromAccount;
    .param p2, "mode"    # I

    .prologue
    const-wide/16 v11, 0x0

    const/4 v7, 0x1

    const/4 v8, 0x0

    const/4 v6, 0x0

    .line 680
    new-instance v3, Lcom/android/mail/providers/Message;

    invoke-direct {v3}, Lcom/android/mail/providers/Message;-><init>()V

    .line 681
    .local v3, "message":Lcom/android/mail/providers/Message;
    const-wide/16 v9, -0x1

    iput-wide v9, v3, Lcom/android/mail/providers/Message;->id:J

    .line 682
    iput-object v6, v3, Lcom/android/mail/providers/Message;->serverId:Ljava/lang/String;

    .line 683
    iput-object v6, v3, Lcom/android/mail/providers/Message;->uri:Landroid/net/Uri;

    .line 684
    iput-object v6, v3, Lcom/android/mail/providers/Message;->conversationUri:Landroid/net/Uri;

    .line 685
    iget-object v5, p0, Lcom/android/mail/compose/ComposeActivity;->mSubject:Landroid/widget/TextView;

    invoke-virtual {v5}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    iput-object v5, v3, Lcom/android/mail/providers/Message;->subject:Ljava/lang/String;

    .line 686
    iput-object v6, v3, Lcom/android/mail/providers/Message;->snippet:Ljava/lang/String;

    .line 687
    iget-object v5, p0, Lcom/android/mail/compose/ComposeActivity;->mTo:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-virtual {v5}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {p0, v5}, Lcom/android/mail/compose/ComposeActivity;->formatSenders(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v3, Lcom/android/mail/providers/Message;->to:Ljava/lang/String;

    .line 688
    iget-object v5, p0, Lcom/android/mail/compose/ComposeActivity;->mCc:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-virtual {v5}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {p0, v5}, Lcom/android/mail/compose/ComposeActivity;->formatSenders(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v3, Lcom/android/mail/providers/Message;->cc:Ljava/lang/String;

    .line 689
    iget-object v5, p0, Lcom/android/mail/compose/ComposeActivity;->mBcc:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-virtual {v5}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {p0, v5}, Lcom/android/mail/compose/ComposeActivity;->formatSenders(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v3, Lcom/android/mail/providers/Message;->bcc:Ljava/lang/String;

    .line 690
    iput-object v6, v3, Lcom/android/mail/providers/Message;->replyTo:Ljava/lang/String;

    .line 691
    iput-wide v11, v3, Lcom/android/mail/providers/Message;->dateReceivedMs:J

    .line 692
    iget-object v5, p0, Lcom/android/mail/compose/ComposeActivity;->mBodyView:Landroid/widget/EditText;

    invoke-virtual {v5}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v5

    invoke-static {v5}, Landroid/text/Html;->toHtml(Landroid/text/Spanned;)Ljava/lang/String;

    move-result-object v2

    .line 693
    .local v2, "htmlBody":Ljava/lang/String;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 694
    .local v1, "fullBody":Ljava/lang/StringBuilder;
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    iput-object v5, v3, Lcom/android/mail/providers/Message;->bodyHtml:Ljava/lang/String;

    .line 695
    iget-object v5, p0, Lcom/android/mail/compose/ComposeActivity;->mBodyView:Landroid/widget/EditText;

    invoke-virtual {v5}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    iput-object v5, v3, Lcom/android/mail/providers/Message;->bodyText:Ljava/lang/String;

    .line 696
    iput-boolean v8, v3, Lcom/android/mail/providers/Message;->embedsExternalResources:Z

    .line 697
    iget-object v5, p0, Lcom/android/mail/compose/ComposeActivity;->mRefMessage:Lcom/android/mail/providers/Message;

    if-eqz v5, :cond_0

    iget-object v5, p0, Lcom/android/mail/compose/ComposeActivity;->mRefMessage:Lcom/android/mail/providers/Message;

    iget-object v5, v5, Lcom/android/mail/providers/Message;->uri:Landroid/net/Uri;

    invoke-virtual {v5}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v5

    :goto_0
    iput-object v5, v3, Lcom/android/mail/providers/Message;->refMessageId:Ljava/lang/String;

    .line 698
    iget-object v5, p0, Lcom/android/mail/compose/ComposeActivity;->mQuotedTextView:Lcom/android/mail/compose/QuotedTextView;

    invoke-virtual {v5}, Lcom/android/mail/compose/QuotedTextView;->getQuotedTextIfIncluded()Ljava/lang/CharSequence;

    move-result-object v5

    if-eqz v5, :cond_1

    move v5, v7

    :goto_1
    iput-boolean v5, v3, Lcom/android/mail/providers/Message;->appendRefMessageContent:Z

    .line 699
    iget-object v5, p0, Lcom/android/mail/compose/ComposeActivity;->mAttachmentsView:Lcom/android/mail/compose/AttachmentsView;

    invoke-virtual {v5}, Lcom/android/mail/compose/AttachmentsView;->getAttachments()Ljava/util/ArrayList;

    move-result-object v0

    .line 700
    .local v0, "attachments":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/android/mail/providers/Attachment;>;"
    if-eqz v0, :cond_2

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v5

    if-lez v5, :cond_2

    :goto_2
    iput-boolean v7, v3, Lcom/android/mail/providers/Message;->hasAttachments:Z

    .line 701
    iput-object v6, v3, Lcom/android/mail/providers/Message;->attachmentListUri:Landroid/net/Uri;

    .line 702
    iput-wide v11, v3, Lcom/android/mail/providers/Message;->messageFlags:J

    .line 703
    iput-object v6, v3, Lcom/android/mail/providers/Message;->saveUri:Ljava/lang/String;

    .line 704
    iput-object v6, v3, Lcom/android/mail/providers/Message;->sendUri:Ljava/lang/String;

    .line 705
    iput-boolean v8, v3, Lcom/android/mail/providers/Message;->alwaysShowImages:Z

    .line 706
    invoke-static {v0}, Lcom/android/mail/providers/Attachment;->toJSONArray(Ljava/util/Collection;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v3, Lcom/android/mail/providers/Message;->attachmentsJson:Ljava/lang/String;

    .line 707
    iget-object v5, p0, Lcom/android/mail/compose/ComposeActivity;->mQuotedTextView:Lcom/android/mail/compose/QuotedTextView;

    invoke-virtual {v5}, Lcom/android/mail/compose/QuotedTextView;->getQuotedText()Ljava/lang/CharSequence;

    move-result-object v4

    .line 708
    .local v4, "quotedText":Ljava/lang/CharSequence;
    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_3

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/android/mail/compose/QuotedTextView;->getQuotedTextOffset(Ljava/lang/String;)I

    move-result v5

    :goto_3
    iput v5, v3, Lcom/android/mail/providers/Message;->quotedTextOffset:I

    .line 710
    iput-object v6, v3, Lcom/android/mail/providers/Message;->accountUri:Landroid/net/Uri;

    .line 711
    invoke-direct {p0, v3, p1, p2}, Lcom/android/mail/compose/ComposeActivity;->updateMessage(Lcom/android/mail/providers/Message;Lcom/android/mail/providers/ReplyFromAccount;I)V

    .line 712
    return-object v3

    .end local v0    # "attachments":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/android/mail/providers/Attachment;>;"
    .end local v4    # "quotedText":Ljava/lang/CharSequence;
    :cond_0
    move-object v5, v6

    .line 697
    goto :goto_0

    :cond_1
    move v5, v8

    .line 698
    goto :goto_1

    .restart local v0    # "attachments":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/android/mail/providers/Attachment;>;"
    :cond_2
    move v7, v8

    .line 700
    goto :goto_2

    .line 708
    .restart local v4    # "quotedText":Ljava/lang/CharSequence;
    :cond_3
    const/4 v5, -0x1

    goto :goto_3
.end method

.method private discardChanges()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 2050
    iput-boolean v0, p0, Lcom/android/mail/compose/ComposeActivity;->mTextChanged:Z

    .line 2051
    iput-boolean v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAttachmentsChanged:Z

    .line 2052
    iput-boolean v0, p0, Lcom/android/mail/compose/ComposeActivity;->mReplyFromChanged:Z

    .line 2053
    return-void
.end method

.method private doAttach(Ljava/lang/String;)V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 2435
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.GET_CONTENT"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 2436
    const-string v1, "android.intent.category.OPENABLE"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    .line 2437
    const/high16 v1, 0x80000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 2438
    invoke-virtual {v0, p1}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 2439
    iput-boolean v2, p0, Lcom/android/mail/compose/ComposeActivity;->mAddingAttachment:Z

    .line 2440
    const v1, 0x7f0c002c

    invoke-virtual {p0, v1}, Lcom/android/mail/compose/ComposeActivity;->getText(I)Ljava/lang/CharSequence;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {p0, v0, v2}, Lcom/android/mail/compose/ComposeActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 2442
    return-void
.end method

.method private doDiscard()V
    .locals 3

    .prologue
    .line 2649
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-direct {v0, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    const v1, 0x7f0c009d

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(I)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const v1, 0x7f0c00d2

    invoke-virtual {v0, v1, p0}, Landroid/app/AlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const v1, 0x7f0c00d3

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 2653
    return-void
.end method

.method private doDiscardWithoutConfirmation(Z)V
    .locals 6

    .prologue
    const-wide/16 v4, -0x1

    .line 2662
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mDraftLock:Ljava/lang/Object;

    monitor-enter v1

    .line 2663
    :try_start_0
    iget-wide v2, p0, Lcom/android/mail/compose/ComposeActivity;->mDraftId:J

    cmp-long v0, v2, v4

    if-eqz v0, :cond_0

    .line 2664
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 2665
    const-string v2, "_id"

    iget-wide v3, p0, Lcom/android/mail/compose/ComposeActivity;->mDraftId:J

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 2666
    iget-object v2, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v2, v2, Lcom/android/mail/providers/Account;->expungeMessageUri:Landroid/net/Uri;

    sget-object v3, Landroid/net/Uri;->EMPTY:Landroid/net/Uri;

    invoke-virtual {v2, v3}, Landroid/net/Uri;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 2667
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    iget-object v3, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v3, v3, Lcom/android/mail/providers/Account;->expungeMessageUri:Landroid/net/Uri;

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual {v2, v3, v0, v4, v5}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2675
    :goto_0
    const-wide/16 v2, -0x1

    iput-wide v2, p0, Lcom/android/mail/compose/ComposeActivity;->mDraftId:J

    .line 2677
    :cond_0
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 2679
    if-eqz p1, :cond_1

    .line 2681
    const v0, 0x7f0c0037

    const/4 v1, 0x0

    invoke-static {p0, v0, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 2685
    :cond_1
    invoke-direct {p0}, Lcom/android/mail/compose/ComposeActivity;->discardChanges()V

    .line 2686
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->finish()V

    .line 2687
    return-void

    .line 2669
    :cond_2
    :try_start_1
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    iget-object v2, p0, Lcom/android/mail/compose/ComposeActivity;->mDraft:Lcom/android/mail/providers/Message;

    iget-object v2, v2, Lcom/android/mail/providers/Message;->uri:Landroid/net/Uri;

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {v0, v2, v3, v4}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    goto :goto_0

    .line 2677
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method private doSave(Z)V
    .locals 2
    .param p1, "showToast"    # Z

    .prologue
    const/4 v1, 0x0

    .line 1768
    invoke-direct {p0}, Lcom/android/mail/compose/ComposeActivity;->clearImeText()V

    .line 1769
    const/4 v0, 0x1

    invoke-virtual {p0, v0, p1, v1, v1}, Lcom/android/mail/compose/ComposeActivity;->sendOrSaveWithSanityChecks(ZZZZ)Z

    .line 1770
    return-void
.end method

.method private doSend()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 1762
    invoke-direct {p0}, Lcom/android/mail/compose/ComposeActivity;->clearImeText()V

    .line 1763
    const/4 v0, 0x1

    invoke-virtual {p0, v1, v0, v1, v1}, Lcom/android/mail/compose/ComposeActivity;->sendOrSaveWithSanityChecks(ZZZZ)Z

    .line 1764
    return-void
.end method

.method public static editDraft(Landroid/content/Context;Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Message;)V
    .locals 1
    .param p0, "launcher"    # Landroid/content/Context;
    .param p1, "account"    # Lcom/android/mail/providers/Account;
    .param p2, "message"    # Lcom/android/mail/providers/Message;

    .prologue
    .line 258
    const/4 v0, 0x3

    invoke-static {p0, p1, p2, v0}, Lcom/android/mail/compose/ComposeActivity;->launch(Landroid/content/Context;Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Message;I)V

    .line 259
    return-void
.end method

.method private findViews()V
    .locals 2

    .prologue
    .line 887
    const v0, 0x7f10003f

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 888
    const v0, 0x7f100048

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mCcBccButton:Landroid/widget/Button;

    .line 889
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mCcBccButton:Landroid/widget/Button;

    if-eqz v0, :cond_0

    .line 890
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mCcBccButton:Landroid/widget/Button;

    invoke-virtual {v0, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 892
    :cond_0
    const v0, 0x7f100049

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/android/mail/compose/CcBccView;

    iput-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mCcBccView:Lcom/android/mail/compose/CcBccView;

    .line 893
    const v0, 0x7f100041

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/android/mail/compose/AttachmentsView;

    iput-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAttachmentsView:Lcom/android/mail/compose/AttachmentsView;

    .line 894
    const v0, 0x7f10004c

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mPhotoAttachmentsButton:Landroid/view/View;

    .line 895
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mPhotoAttachmentsButton:Landroid/view/View;

    if-eqz v0, :cond_1

    .line 896
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mPhotoAttachmentsButton:Landroid/view/View;

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 898
    :cond_1
    const v0, 0x7f10011d

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mVideoAttachmentsButton:Landroid/view/View;

    .line 899
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mVideoAttachmentsButton:Landroid/view/View;

    if-eqz v0, :cond_2

    .line 900
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mVideoAttachmentsButton:Landroid/view/View;

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 902
    :cond_2
    const v0, 0x7f100047

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/android/ex/chips/RecipientEditTextView;

    iput-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mTo:Lcom/android/ex/chips/RecipientEditTextView;

    .line 903
    const v0, 0x7f100036

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/android/ex/chips/RecipientEditTextView;

    iput-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mCc:Lcom/android/ex/chips/RecipientEditTextView;

    .line 904
    const v0, 0x7f100039

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/android/ex/chips/RecipientEditTextView;

    iput-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mBcc:Lcom/android/ex/chips/RecipientEditTextView;

    .line 907
    const v0, 0x7f10004b

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mSubject:Landroid/widget/TextView;

    .line 908
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mSubject:Landroid/widget/TextView;

    invoke-virtual {v0, p0}, Landroid/widget/TextView;->setOnEditorActionListener(Landroid/widget/TextView$OnEditorActionListener;)V

    .line 909
    const v0, 0x7f100042

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/android/mail/compose/QuotedTextView;

    iput-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mQuotedTextView:Lcom/android/mail/compose/QuotedTextView;

    .line 910
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mQuotedTextView:Lcom/android/mail/compose/QuotedTextView;

    invoke-virtual {v0, p0}, Lcom/android/mail/compose/QuotedTextView;->setRespondInlineListener(Lcom/android/mail/compose/QuotedTextView$RespondInlineListener;)V

    .line 911
    const v0, 0x7f100055

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mBodyView:Landroid/widget/EditText;

    .line 912
    const v0, 0x7f100058

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mFromStatic:Landroid/view/View;

    .line 913
    const v0, 0x7f100059

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mFromStaticText:Landroid/widget/TextView;

    .line 914
    const v0, 0x7f100056

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mFromSpinnerWrapper:Landroid/view/View;

    .line 915
    const v0, 0x7f100057

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/android/mail/compose/FromAddressSpinner;

    iput-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mFromSpinner:Lcom/android/mail/compose/FromAddressSpinner;

    .line 916
    return-void
.end method

.method private finishCreate()V
    .locals 15

    .prologue
    .line 311
    iget-object v8, p0, Lcom/android/mail/compose/ComposeActivity;->mSavedInstanceState:Landroid/os/Bundle;

    .line 312
    .local v8, "savedInstanceState":Landroid/os/Bundle;
    invoke-direct {p0}, Lcom/android/mail/compose/ComposeActivity;->findViews()V

    .line 313
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->getIntent()Landroid/content/Intent;

    move-result-object v5

    .line 316
    .local v5, "intent":Landroid/content/Intent;
    const/4 v11, 0x0

    .line 319
    .local v11, "showQuotedText":Z
    const/4 v0, 0x0

    .line 320
    .local v0, "account":Lcom/android/mail/providers/Account;
    invoke-direct {p0, v8}, Lcom/android/mail/compose/ComposeActivity;->hadSavedInstanceStateMessage(Landroid/os/Bundle;)Z

    move-result v12

    if-eqz v12, :cond_0

    .line 321
    const-string v12, "action"

    const/4 v13, -0x1

    invoke-virtual {v8, v12, v13}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v2

    .line 322
    .local v2, "action":I
    const-string v12, "account"

    invoke-virtual {v8, v12}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    .end local v0    # "account":Lcom/android/mail/providers/Account;
    check-cast v0, Lcom/android/mail/providers/Account;

    .line 323
    .restart local v0    # "account":Lcom/android/mail/providers/Account;
    const-string v12, "extraMessage"

    invoke-virtual {v8, v12}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v6

    check-cast v6, Lcom/android/mail/providers/Message;

    .line 325
    .local v6, "message":Lcom/android/mail/providers/Message;
    const-string v12, "attachmentPreviews"

    invoke-virtual {v8, v12}, Landroid/os/Bundle;->getParcelableArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v7

    .line 326
    .local v7, "previews":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/android/mail/ui/AttachmentTile$AttachmentPreview;>;"
    const-string v12, "in-reference-to-message"

    invoke-virtual {v8, v12}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v12

    check-cast v12, Lcom/android/mail/providers/Message;

    iput-object v12, p0, Lcom/android/mail/compose/ComposeActivity;->mRefMessage:Lcom/android/mail/providers/Message;

    .line 336
    :goto_0
    iget-object v12, p0, Lcom/android/mail/compose/ComposeActivity;->mAttachmentsView:Lcom/android/mail/compose/AttachmentsView;

    invoke-virtual {v12, v7}, Lcom/android/mail/compose/AttachmentsView;->setAttachmentPreviews(Ljava/util/ArrayList;)V

    .line 338
    invoke-virtual {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->setAccount(Lcom/android/mail/providers/Account;)V

    .line 339
    iget-object v12, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    if-nez v12, :cond_1

    .line 395
    :goto_1
    return-void

    .line 328
    .end local v2    # "action":I
    .end local v6    # "message":Lcom/android/mail/providers/Message;
    .end local v7    # "previews":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/android/mail/ui/AttachmentTile$AttachmentPreview;>;"
    :cond_0
    invoke-direct {p0, v5}, Lcom/android/mail/compose/ComposeActivity;->obtainAccount(Landroid/content/Intent;)Lcom/android/mail/providers/Account;

    move-result-object v0

    .line 329
    const-string v12, "action"

    const/4 v13, -0x1

    invoke-virtual {v5, v12, v13}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v2

    .line 331
    .restart local v2    # "action":I
    const-string v12, "original-draft-message"

    invoke-virtual {v5, v12}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v6

    check-cast v6, Lcom/android/mail/providers/Message;

    .line 332
    .restart local v6    # "message":Lcom/android/mail/providers/Message;
    const-string v12, "attachmentPreviews"

    invoke-virtual {v5, v12}, Landroid/content/Intent;->getParcelableArrayListExtra(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v7

    .line 333
    .restart local v7    # "previews":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/android/mail/ui/AttachmentTile$AttachmentPreview;>;"
    const-string v12, "in-reference-to-message"

    invoke-virtual {v5, v12}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v12

    check-cast v12, Lcom/android/mail/providers/Message;

    iput-object v12, p0, Lcom/android/mail/compose/ComposeActivity;->mRefMessage:Lcom/android/mail/providers/Message;

    .line 334
    const-string v12, "in-reference-to-message-uri"

    invoke-virtual {v5, v12}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v12

    check-cast v12, Landroid/net/Uri;

    iput-object v12, p0, Lcom/android/mail/compose/ComposeActivity;->mRefMessageUri:Landroid/net/Uri;

    goto :goto_0

    .line 343
    :cond_1
    const-string v12, "fromemail"

    const/4 v13, 0x0

    invoke-virtual {v5, v12, v13}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v12

    if-eqz v12, :cond_3

    .line 344
    const/4 v12, 0x1

    iput-boolean v12, p0, Lcom/android/mail/compose/ComposeActivity;->mLaunchedFromEmail:Z

    .line 354
    :cond_2
    :goto_2
    iget-object v12, p0, Lcom/android/mail/compose/ComposeActivity;->mRefMessageUri:Landroid/net/Uri;

    if-eqz v12, :cond_4

    .line 356
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v12

    const/4 v13, 0x0

    const/4 v14, 0x0

    invoke-virtual {v12, v13, v14, p0}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    goto :goto_1

    .line 345
    :cond_3
    const-string v12, "android.intent.action.SEND"

    invoke-virtual {v5}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v12

    if-eqz v12, :cond_2

    .line 346
    invoke-virtual {v5}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v4

    .line 347
    .local v4, "dataUri":Landroid/net/Uri;
    if-eqz v4, :cond_2

    .line 348
    invoke-virtual {v5}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v12

    invoke-virtual {v12}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v3

    .line 349
    .local v3, "dataScheme":Ljava/lang/String;
    iget-object v12, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v12, v12, Lcom/android/mail/providers/Account;->composeIntentUri:Landroid/net/Uri;

    invoke-virtual {v12}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v1

    .line 350
    .local v1, "accountScheme":Ljava/lang/String;
    invoke-static {v3, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    iput-boolean v12, p0, Lcom/android/mail/compose/ComposeActivity;->mLaunchedFromEmail:Z

    goto :goto_2

    .line 358
    .end local v1    # "accountScheme":Ljava/lang/String;
    .end local v3    # "dataScheme":Ljava/lang/String;
    .end local v4    # "dataUri":Landroid/net/Uri;
    :cond_4
    if-eqz v6, :cond_6

    const/4 v12, 0x3

    if-eq v2, v12, :cond_6

    .line 359
    invoke-direct {p0, v6}, Lcom/android/mail/compose/ComposeActivity;->initFromDraftMessage(Lcom/android/mail/providers/Message;)V

    .line 360
    iget-object v12, p0, Lcom/android/mail/compose/ComposeActivity;->mRefMessage:Lcom/android/mail/providers/Message;

    invoke-direct {p0, v12, v2}, Lcom/android/mail/compose/ComposeActivity;->initQuotedTextFromRefMessage(Lcom/android/mail/providers/Message;I)V

    .line 361
    invoke-direct {p0, v8}, Lcom/android/mail/compose/ComposeActivity;->showCcBcc(Landroid/os/Bundle;)V

    .line 362
    iget-boolean v11, v6, Lcom/android/mail/providers/Message;->appendRefMessageContent:Z

    .line 394
    :cond_5
    :goto_3
    invoke-direct {p0, v2, v5, v8, v11}, Lcom/android/mail/compose/ComposeActivity;->finishSetup(ILandroid/content/Intent;Landroid/os/Bundle;Z)V

    goto/16 :goto_1

    .line 363
    :cond_6
    const/4 v12, 0x3

    if-ne v2, v12, :cond_a

    .line 364
    invoke-direct {p0, v6}, Lcom/android/mail/compose/ComposeActivity;->initFromDraftMessage(Lcom/android/mail/providers/Message;)V

    .line 365
    iget-object v12, v6, Lcom/android/mail/providers/Message;->bcc:Ljava/lang/String;

    invoke-static {v12}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v12

    if-nez v12, :cond_8

    const/4 v9, 0x1

    .line 366
    .local v9, "showBcc":Z
    :goto_4
    if-nez v9, :cond_7

    iget-object v12, v6, Lcom/android/mail/providers/Message;->cc:Ljava/lang/String;

    invoke-static {v12}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v12

    if-nez v12, :cond_9

    :cond_7
    const/4 v10, 0x1

    .line 367
    .local v10, "showCc":Z
    :goto_5
    iget-object v12, p0, Lcom/android/mail/compose/ComposeActivity;->mCcBccView:Lcom/android/mail/compose/CcBccView;

    const/4 v13, 0x0

    invoke-virtual {v12, v13, v10, v9}, Lcom/android/mail/compose/CcBccView;->show(ZZZ)V

    .line 369
    iget v12, v6, Lcom/android/mail/providers/Message;->draftType:I

    packed-switch v12, :pswitch_data_0

    .line 381
    const/4 v2, -0x1

    .line 384
    :goto_6
    iget-object v12, p0, Lcom/android/mail/compose/ComposeActivity;->mRefMessage:Lcom/android/mail/providers/Message;

    invoke-direct {p0, v12, v2}, Lcom/android/mail/compose/ComposeActivity;->initQuotedTextFromRefMessage(Lcom/android/mail/providers/Message;I)V

    .line 385
    iget-boolean v11, v6, Lcom/android/mail/providers/Message;->appendRefMessageContent:Z

    .line 386
    goto :goto_3

    .line 365
    .end local v9    # "showBcc":Z
    .end local v10    # "showCc":Z
    :cond_8
    const/4 v9, 0x0

    goto :goto_4

    .line 366
    .restart local v9    # "showBcc":Z
    :cond_9
    const/4 v10, 0x0

    goto :goto_5

    .line 371
    .restart local v10    # "showCc":Z
    :pswitch_0
    const/4 v2, 0x0

    .line 372
    goto :goto_6

    .line 374
    :pswitch_1
    const/4 v2, 0x1

    .line 375
    goto :goto_6

    .line 377
    :pswitch_2
    const/4 v2, 0x2

    .line 378
    goto :goto_6

    .line 386
    .end local v9    # "showBcc":Z
    .end local v10    # "showCc":Z
    :cond_a
    if-eqz v2, :cond_b

    const/4 v12, 0x1

    if-eq v2, v12, :cond_b

    const/4 v12, 0x2

    if-ne v2, v12, :cond_c

    .line 387
    :cond_b
    iget-object v12, p0, Lcom/android/mail/compose/ComposeActivity;->mRefMessage:Lcom/android/mail/providers/Message;

    if-eqz v12, :cond_5

    .line 388
    iget-object v12, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v12, v12, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-direct {p0, v2, v12}, Lcom/android/mail/compose/ComposeActivity;->initFromRefMessage(ILjava/lang/String;)V

    .line 389
    const/4 v11, 0x1

    goto :goto_3

    .line 392
    :cond_c
    invoke-virtual {p0, v5}, Lcom/android/mail/compose/ComposeActivity;->initFromExtras(Landroid/content/Intent;)V

    goto :goto_3

    .line 369
    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method private finishSetup(ILandroid/content/Intent;Landroid/os/Bundle;Z)V
    .locals 2
    .param p1, "action"    # I
    .param p2, "intent"    # Landroid/content/Intent;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;
    .param p4, "showQuotedText"    # Z

    .prologue
    .line 472
    invoke-direct {p0, p1}, Lcom/android/mail/compose/ComposeActivity;->setFocus(I)V

    .line 473
    const/4 v0, -0x1

    if-ne p1, v0, :cond_0

    .line 474
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mQuotedTextView:Lcom/android/mail/compose/QuotedTextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/android/mail/compose/QuotedTextView;->setVisibility(I)V

    .line 476
    :cond_0
    invoke-direct {p0}, Lcom/android/mail/compose/ComposeActivity;->initRecipients()V

    .line 479
    invoke-direct {p0, p3}, Lcom/android/mail/compose/ComposeActivity;->hadSavedInstanceStateMessage(Landroid/os/Bundle;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 480
    invoke-direct {p0, p2}, Lcom/android/mail/compose/ComposeActivity;->initAttachmentsFromIntent(Landroid/content/Intent;)V

    .line 482
    :cond_1
    invoke-direct {p0, p1}, Lcom/android/mail/compose/ComposeActivity;->initActionBar(I)V

    .line 483
    if-eqz p3, :cond_2

    .end local p3    # "savedInstanceState":Landroid/os/Bundle;
    :goto_0
    invoke-direct {p0, p3, p1}, Lcom/android/mail/compose/ComposeActivity;->initFromSpinner(Landroid/os/Bundle;I)V

    .line 485
    invoke-direct {p0}, Lcom/android/mail/compose/ComposeActivity;->initChangeListeners()V

    .line 486
    invoke-direct {p0}, Lcom/android/mail/compose/ComposeActivity;->updateHideOrShowCcBcc()V

    .line 487
    invoke-direct {p0, p4}, Lcom/android/mail/compose/ComposeActivity;->updateHideOrShowQuotedText(Z)V

    .line 488
    return-void

    .line 483
    .restart local p3    # "savedInstanceState":Landroid/os/Bundle;
    :cond_2
    invoke-virtual {p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object p3

    goto :goto_0
.end method

.method private formatSenders(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "string"    # Ljava/lang/String;

    .prologue
    .line 723
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    invoke-virtual {p1, v0}, Ljava/lang/String;->charAt(I)C

    move-result v0

    const/16 v1, 0x2c

    if-ne v0, v1, :cond_0

    .line 724
    const/4 v0, 0x0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    invoke-virtual {p1, v0, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p1

    .line 726
    .end local p1    # "string":Ljava/lang/String;
    :cond_0
    return-object p1
.end method

.method public static forward(Landroid/content/Context;Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Message;)V
    .locals 1
    .param p0, "launcher"    # Landroid/content/Context;
    .param p1, "account"    # Lcom/android/mail/providers/Account;
    .param p2, "message"    # Lcom/android/mail/providers/Message;

    .prologue
    .line 286
    const/4 v0, 0x2

    invoke-static {p0, p1, p2, v0}, Lcom/android/mail/compose/ComposeActivity;->launch(Landroid/content/Context;Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Message;I)V

    .line 287
    return-void
.end method

.method private getDefaultReplyFromAccount(Lcom/android/mail/providers/Account;)Lcom/android/mail/providers/ReplyFromAccount;
    .locals 10
    .param p1, "account"    # Lcom/android/mail/providers/Account;

    .prologue
    .line 859
    invoke-virtual {p1}, Lcom/android/mail/providers/Account;->getReplyFroms()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v9

    .local v9, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/android/mail/providers/ReplyFromAccount;

    .line 860
    .local v8, "from":Lcom/android/mail/providers/ReplyFromAccount;
    iget-boolean v0, v8, Lcom/android/mail/providers/ReplyFromAccount;->isDefault:Z

    if-eqz v0, :cond_0

    .line 864
    .end local v8    # "from":Lcom/android/mail/providers/ReplyFromAccount;
    :goto_0
    return-object v8

    :cond_1
    new-instance v0, Lcom/android/mail/providers/ReplyFromAccount;

    iget-object v2, p1, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    iget-object v3, p1, Landroid/accounts/Account;->name:Ljava/lang/String;

    iget-object v4, p1, Landroid/accounts/Account;->name:Ljava/lang/String;

    iget-object v5, p1, Landroid/accounts/Account;->name:Ljava/lang/String;

    const/4 v6, 0x1

    const/4 v7, 0x0

    move-object v1, p1

    invoke-direct/range {v0 .. v7}, Lcom/android/mail/providers/ReplyFromAccount;-><init>(Lcom/android/mail/providers/Account;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V

    move-object v8, v0

    goto :goto_0
.end method

.method private static getDraftType(I)I
    .locals 1
    .param p0, "mode"    # I

    .prologue
    .line 2265
    const/4 v0, -0x1

    .line 2266
    .local v0, "draftType":I
    packed-switch p0, :pswitch_data_0

    .line 2280
    :goto_0
    return v0

    .line 2268
    :pswitch_0
    const/4 v0, 0x1

    .line 2269
    goto :goto_0

    .line 2271
    :pswitch_1
    const/4 v0, 0x2

    .line 2272
    goto :goto_0

    .line 2274
    :pswitch_2
    const/4 v0, 0x3

    .line 2275
    goto :goto_0

    .line 2277
    :pswitch_3
    const/4 v0, 0x4

    goto :goto_0

    .line 2266
    nop

    :pswitch_data_0
    .packed-switch -0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method private getMode()I
    .locals 4

    .prologue
    .line 670
    const/4 v1, -0x1

    .line 671
    .local v1, "mode":I
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 672
    .local v0, "actionBar":Landroid/app/ActionBar;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/app/ActionBar;->getNavigationMode()I

    move-result v2

    const/4 v3, 0x1

    if-ne v2, v3, :cond_0

    .line 674
    invoke-virtual {v0}, Landroid/app/ActionBar;->getSelectedNavigationIndex()I

    move-result v1

    .line 676
    :cond_0
    return v1
.end method

.method private getReplyFromAccountForReply(Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Message;)Lcom/android/mail/providers/ReplyFromAccount;
    .locals 5
    .param p1, "account"    # Lcom/android/mail/providers/Account;
    .param p2, "refMessage"    # Lcom/android/mail/providers/Message;

    .prologue
    .line 787
    iget-object v3, p2, Lcom/android/mail/providers/Message;->accountUri:Landroid/net/Uri;

    if-eqz v3, :cond_2

    .line 789
    iget-object v3, p0, Lcom/android/mail/compose/ComposeActivity;->mFromSpinner:Lcom/android/mail/compose/FromAddressSpinner;

    invoke-virtual {v3}, Lcom/android/mail/compose/FromAddressSpinner;->getReplyFromAccounts()Ljava/util/List;

    move-result-object v2

    .line 790
    .local v2, "replyFromAccounts":Ljava/util/List;, "Ljava/util/List<Lcom/android/mail/providers/ReplyFromAccount;>;"
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/ReplyFromAccount;

    .line 791
    .local v0, "from":Lcom/android/mail/providers/ReplyFromAccount;
    iget-object v3, v0, Lcom/android/mail/providers/ReplyFromAccount;->account:Lcom/android/mail/providers/Account;

    iget-object v3, v3, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    iget-object v4, p2, Lcom/android/mail/providers/Message;->accountUri:Landroid/net/Uri;

    invoke-virtual {v3, v4}, Landroid/net/Uri;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 797
    .end local v0    # "from":Lcom/android/mail/providers/ReplyFromAccount;
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "replyFromAccounts":Ljava/util/List;, "Ljava/util/List<Lcom/android/mail/providers/ReplyFromAccount;>;"
    :goto_0
    return-object v0

    .line 795
    .restart local v1    # "i$":Ljava/util/Iterator;
    .restart local v2    # "replyFromAccounts":Ljava/util/List;, "Ljava/util/List<Lcom/android/mail/providers/ReplyFromAccount;>;"
    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    .line 797
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "replyFromAccounts":Ljava/util/List;, "Ljava/util/List<Lcom/android/mail/providers/ReplyFromAccount;>;"
    :cond_2
    invoke-virtual {p0, p1, p2}, Lcom/android/mail/compose/ComposeActivity;->getReplyFromAccount(Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Message;)Lcom/android/mail/providers/ReplyFromAccount;

    move-result-object v0

    goto :goto_0
.end method

.method private getReplyFromAccountFromDraft(Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Message;)Lcom/android/mail/providers/ReplyFromAccount;
    .locals 12
    .param p1, "account"    # Lcom/android/mail/providers/Account;
    .param p2, "msg"    # Lcom/android/mail/providers/Message;

    .prologue
    .line 869
    iget-object v11, p2, Lcom/android/mail/providers/Message;->from:Ljava/lang/String;

    .line 870
    .local v11, "sender":Ljava/lang/String;
    const/4 v0, 0x0

    .line 871
    .local v0, "replyFromAccount":Lcom/android/mail/providers/ReplyFromAccount;
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mFromSpinner:Lcom/android/mail/compose/FromAddressSpinner;

    invoke-virtual {v1}, Lcom/android/mail/compose/FromAddressSpinner;->getReplyFromAccounts()Ljava/util/List;

    move-result-object v10

    .line 872
    .local v10, "replyFromAccounts":Ljava/util/List;, "Ljava/util/List<Lcom/android/mail/providers/ReplyFromAccount;>;"
    iget-object v1, p1, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-static {v1, v11}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 873
    new-instance v0, Lcom/android/mail/providers/ReplyFromAccount;

    .end local v0    # "replyFromAccount":Lcom/android/mail/providers/ReplyFromAccount;
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v2, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v2, v2, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    iget-object v3, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v3, v3, Landroid/accounts/Account;->name:Ljava/lang/String;

    iget-object v4, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v4, v4, Landroid/accounts/Account;->name:Ljava/lang/String;

    iget-object v5, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v5, v5, Landroid/accounts/Account;->name:Ljava/lang/String;

    const/4 v6, 0x1

    const/4 v7, 0x0

    invoke-direct/range {v0 .. v7}, Lcom/android/mail/providers/ReplyFromAccount;-><init>(Lcom/android/mail/providers/Account;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V

    .line 883
    .restart local v0    # "replyFromAccount":Lcom/android/mail/providers/ReplyFromAccount;
    :cond_0
    :goto_0
    return-object v0

    .line 876
    :cond_1
    invoke-interface {v10}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v9

    .local v9, "i$":Ljava/util/Iterator;
    :cond_2
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/android/mail/providers/ReplyFromAccount;

    .line 877
    .local v8, "fromAccount":Lcom/android/mail/providers/ReplyFromAccount;
    iget-object v1, v8, Lcom/android/mail/providers/ReplyFromAccount;->name:Ljava/lang/String;

    invoke-static {v1, v11}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 878
    move-object v0, v8

    .line 879
    goto :goto_0
.end method

.method private getWaitFragment()Lcom/android/mail/ui/WaitFragment;
    .locals 2

    .prologue
    .line 2905
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    const-string v1, "wait-fragment"

    invoke-virtual {v0, v1}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/android/mail/ui/WaitFragment;

    return-object v0
.end method

.method private hadSavedInstanceStateMessage(Landroid/os/Bundle;)Z
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 491
    if-eqz p1, :cond_0

    const-string v0, "extraMessage"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private initActionBar(I)V
    .locals 5

    .prologue
    const/4 v4, 0x6

    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 970
    iput p1, p0, Lcom/android/mail/compose/ComposeActivity;->mComposeMode:I

    .line 971
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 972
    if-nez v0, :cond_0

    .line 1000
    :goto_0
    return-void

    .line 975
    :cond_0
    const/4 v1, -0x1

    if-ne p1, v1, :cond_1

    .line 976
    invoke-virtual {v0, v3}, Landroid/app/ActionBar;->setNavigationMode(I)V

    .line 977
    const v1, 0x7f0c0025

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setTitle(I)V

    .line 997
    :goto_1
    invoke-virtual {v0, v4, v4}, Landroid/app/ActionBar;->setDisplayOptions(II)V

    .line 999
    invoke-virtual {v0, v2}, Landroid/app/ActionBar;->setHomeButtonEnabled(Z)V

    goto :goto_0

    .line 979
    :cond_1
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setTitle(Ljava/lang/CharSequence;)V

    .line 980
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mComposeModeAdapter:Lcom/android/mail/compose/ComposeActivity$ComposeModeAdapter;

    if-nez v1, :cond_2

    .line 981
    new-instance v1, Lcom/android/mail/compose/ComposeActivity$ComposeModeAdapter;

    invoke-direct {v1, p0, p0}, Lcom/android/mail/compose/ComposeActivity$ComposeModeAdapter;-><init>(Lcom/android/mail/compose/ComposeActivity;Landroid/content/Context;)V

    iput-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mComposeModeAdapter:Lcom/android/mail/compose/ComposeActivity$ComposeModeAdapter;

    .line 983
    :cond_2
    invoke-virtual {v0, v2}, Landroid/app/ActionBar;->setNavigationMode(I)V

    .line 984
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mComposeModeAdapter:Lcom/android/mail/compose/ComposeActivity$ComposeModeAdapter;

    invoke-virtual {v0, v1, p0}, Landroid/app/ActionBar;->setListNavigationCallbacks(Landroid/widget/SpinnerAdapter;Landroid/app/ActionBar$OnNavigationListener;)V

    .line 985
    packed-switch p1, :pswitch_data_0

    goto :goto_1

    .line 987
    :pswitch_0
    invoke-virtual {v0, v3}, Landroid/app/ActionBar;->setSelectedNavigationItem(I)V

    goto :goto_1

    .line 990
    :pswitch_1
    invoke-virtual {v0, v2}, Landroid/app/ActionBar;->setSelectedNavigationItem(I)V

    goto :goto_1

    .line 993
    :pswitch_2
    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setSelectedNavigationItem(I)V

    goto :goto_1

    .line 985
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method private initAttachmentsFromIntent(Landroid/content/Intent;)V
    .locals 13

    .prologue
    .line 1278
    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 1279
    if-nez v0, :cond_6

    .line 1280
    sget-object v0, Landroid/os/Bundle;->EMPTY:Landroid/os/Bundle;

    move-object v1, v0

    .line 1282
    :goto_0
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v8

    .line 1283
    iget-boolean v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAttachmentsChanged:Z

    if-nez v0, :cond_4

    .line 1284
    const-wide/16 v2, 0x0

    .line 1285
    const-string v0, "attachments"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1286
    const-string v0, "attachments"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, [Ljava/lang/String;

    check-cast v0, [Ljava/lang/String;

    .line 1287
    array-length v9, v0

    const/4 v4, 0x0

    move v7, v4

    move-wide v4, v2

    :goto_1
    if-ge v7, v9, :cond_0

    aget-object v2, v0, v7

    .line 1288
    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v6

    .line 1289
    const-wide/16 v2, 0x0

    .line 1291
    :try_start_0
    iget-object v10, p0, Lcom/android/mail/compose/ComposeActivity;->mAttachmentsView:Lcom/android/mail/compose/AttachmentsView;

    iget-object v11, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    invoke-virtual {v10, v11, v6}, Lcom/android/mail/compose/AttachmentsView;->addAttachment(Lcom/android/mail/providers/Account;Landroid/net/Uri;)J
    :try_end_0
    .catch Lcom/android/mail/compose/AttachmentsView$AttachmentFailureException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v2

    .line 1296
    :goto_2
    add-long/2addr v4, v2

    .line 1287
    add-int/lit8 v2, v7, 0x1

    move v7, v2

    goto :goto_1

    .line 1292
    :catch_0
    move-exception v6

    .line 1293
    sget-object v10, Lcom/android/mail/compose/ComposeActivity;->LOG_TAG:Ljava/lang/String;

    const-string v11, "Error adding attachment"

    const/4 v12, 0x0

    new-array v12, v12, [Ljava/lang/Object;

    invoke-static {v10, v6, v11, v12}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1294
    invoke-virtual {v6}, Lcom/android/mail/compose/AttachmentsView$AttachmentFailureException;->getErrorRes()I

    move-result v6

    invoke-direct {p0, v6}, Lcom/android/mail/compose/ComposeActivity;->showAttachmentTooBigToast(I)V

    goto :goto_2

    :cond_0
    move-wide v2, v4

    .line 1299
    :cond_1
    const-string v0, "android.intent.extra.STREAM"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 1300
    const-string v0, "android.intent.action.SEND_MULTIPLE"

    invoke-virtual {v0, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 1301
    const-string v0, "android.intent.extra.STREAM"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getParcelableArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    .line 1303
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 1304
    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_3
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/Parcelable;

    .line 1306
    :try_start_1
    iget-object v5, p0, Lcom/android/mail/compose/ComposeActivity;->mAttachmentsView:Lcom/android/mail/compose/AttachmentsView;

    check-cast v0, Landroid/net/Uri;

    invoke-virtual {v5, v0}, Lcom/android/mail/compose/AttachmentsView;->generateLocalAttachment(Landroid/net/Uri;)Lcom/android/mail/providers/Attachment;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_1
    .catch Lcom/android/mail/compose/AttachmentsView$AttachmentFailureException; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_3

    .line 1307
    :catch_1
    move-exception v0

    .line 1308
    sget-object v5, Lcom/android/mail/compose/ComposeActivity;->LOG_TAG:Ljava/lang/String;

    const-string v6, "Error adding attachment"

    const/4 v7, 0x0

    new-array v7, v7, [Ljava/lang/Object;

    invoke-static {v5, v0, v6, v7}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1309
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iget-object v5, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v5, v5, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    invoke-virtual {v5}, Lcom/android/mail/providers/Settings;->getMaxAttachmentSize()I

    move-result v5

    int-to-long v5, v5

    invoke-static {v0, v5, v6}, Lcom/android/mail/utils/AttachmentUtils;->convertToHumanReadableSize(Landroid/content/Context;J)Ljava/lang/String;

    move-result-object v0

    .line 1312
    const v5, 0x7f0c0030

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object v0, v6, v7

    invoke-virtual {p0, v5, v6}, Lcom/android/mail/compose/ComposeActivity;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->showErrorToast(Ljava/lang/String;)V

    goto :goto_3

    .line 1316
    :cond_2
    invoke-virtual {p0, v1}, Lcom/android/mail/compose/ComposeActivity;->addAttachments(Ljava/util/List;)J

    move-result-wide v0

    add-long/2addr v2, v0

    .line 1330
    :cond_3
    :goto_4
    const-wide/16 v0, 0x0

    cmp-long v0, v2, v0

    if-lez v0, :cond_4

    .line 1331
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAttachmentsChanged:Z

    .line 1332
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->updateSaveUi()V

    .line 1335
    :cond_4
    return-void

    .line 1318
    :cond_5
    const-string v0, "android.intent.extra.STREAM"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/net/Uri;

    .line 1319
    const-wide/16 v4, 0x0

    .line 1321
    :try_start_2
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mAttachmentsView:Lcom/android/mail/compose/AttachmentsView;

    iget-object v6, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    invoke-virtual {v1, v6, v0}, Lcom/android/mail/compose/AttachmentsView;->addAttachment(Lcom/android/mail/providers/Account;Landroid/net/Uri;)J
    :try_end_2
    .catch Lcom/android/mail/compose/AttachmentsView$AttachmentFailureException; {:try_start_2 .. :try_end_2} :catch_2

    move-result-wide v0

    .line 1326
    :goto_5
    add-long/2addr v2, v0

    goto :goto_4

    .line 1322
    :catch_2
    move-exception v0

    .line 1323
    sget-object v1, Lcom/android/mail/compose/ComposeActivity;->LOG_TAG:Ljava/lang/String;

    const-string v6, "Error adding attachment"

    const/4 v7, 0x0

    new-array v7, v7, [Ljava/lang/Object;

    invoke-static {v1, v0, v6, v7}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1324
    invoke-virtual {v0}, Lcom/android/mail/compose/AttachmentsView$AttachmentFailureException;->getErrorRes()I

    move-result v0

    invoke-direct {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->showAttachmentTooBigToast(I)V

    move-wide v0, v4

    goto :goto_5

    :cond_6
    move-object v1, v0

    goto/16 :goto_0
.end method

.method private initChangeListeners()V
    .locals 2

    .prologue
    .line 951
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mSubject:Landroid/widget/TextView;

    invoke-virtual {v0, p0}, Landroid/widget/TextView;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 952
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mBodyView:Landroid/widget/EditText;

    invoke-virtual {v0, p0}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 953
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mToListener:Lcom/android/mail/compose/ComposeActivity$RecipientTextWatcher;

    if-nez v0, :cond_0

    .line 954
    new-instance v0, Lcom/android/mail/compose/ComposeActivity$RecipientTextWatcher;

    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mTo:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-direct {v0, p0, v1, p0}, Lcom/android/mail/compose/ComposeActivity$RecipientTextWatcher;-><init>(Lcom/android/mail/compose/ComposeActivity;Lcom/android/ex/chips/RecipientEditTextView;Landroid/text/TextWatcher;)V

    iput-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mToListener:Lcom/android/mail/compose/ComposeActivity$RecipientTextWatcher;

    .line 956
    :cond_0
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mTo:Lcom/android/ex/chips/RecipientEditTextView;

    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mToListener:Lcom/android/mail/compose/ComposeActivity$RecipientTextWatcher;

    invoke-virtual {v0, v1}, Lcom/android/ex/chips/RecipientEditTextView;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 957
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mCcListener:Lcom/android/mail/compose/ComposeActivity$RecipientTextWatcher;

    if-nez v0, :cond_1

    .line 958
    new-instance v0, Lcom/android/mail/compose/ComposeActivity$RecipientTextWatcher;

    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mCc:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-direct {v0, p0, v1, p0}, Lcom/android/mail/compose/ComposeActivity$RecipientTextWatcher;-><init>(Lcom/android/mail/compose/ComposeActivity;Lcom/android/ex/chips/RecipientEditTextView;Landroid/text/TextWatcher;)V

    iput-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mCcListener:Lcom/android/mail/compose/ComposeActivity$RecipientTextWatcher;

    .line 960
    :cond_1
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mCc:Lcom/android/ex/chips/RecipientEditTextView;

    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mCcListener:Lcom/android/mail/compose/ComposeActivity$RecipientTextWatcher;

    invoke-virtual {v0, v1}, Lcom/android/ex/chips/RecipientEditTextView;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 961
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mBccListener:Lcom/android/mail/compose/ComposeActivity$RecipientTextWatcher;

    if-nez v0, :cond_2

    .line 962
    new-instance v0, Lcom/android/mail/compose/ComposeActivity$RecipientTextWatcher;

    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mBcc:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-direct {v0, p0, v1, p0}, Lcom/android/mail/compose/ComposeActivity$RecipientTextWatcher;-><init>(Lcom/android/mail/compose/ComposeActivity;Lcom/android/ex/chips/RecipientEditTextView;Landroid/text/TextWatcher;)V

    iput-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mBccListener:Lcom/android/mail/compose/ComposeActivity$RecipientTextWatcher;

    .line 964
    :cond_2
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mBcc:Lcom/android/ex/chips/RecipientEditTextView;

    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mBccListener:Lcom/android/mail/compose/ComposeActivity$RecipientTextWatcher;

    invoke-virtual {v0, v1}, Lcom/android/ex/chips/RecipientEditTextView;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 965
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mFromSpinner:Lcom/android/mail/compose/FromAddressSpinner;

    invoke-virtual {v0, p0}, Lcom/android/mail/compose/FromAddressSpinner;->setOnAccountChangedListener(Lcom/android/mail/compose/FromAddressSpinner$OnAccountChangedListener;)V

    .line 966
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAttachmentsView:Lcom/android/mail/compose/AttachmentsView;

    invoke-virtual {v0, p0}, Lcom/android/mail/compose/AttachmentsView;->setAttachmentChangesListener(Lcom/android/mail/compose/AttachmentsView$AttachmentAddedOrDeletedListener;)V

    .line 967
    return-void
.end method

.method private initFromDraftMessage(Lcom/android/mail/providers/Message;)V
    .locals 7

    .prologue
    const/4 v4, 0x0

    const/4 v0, 0x1

    const/4 v1, 0x0

    const/4 v2, -0x1

    .line 1029
    sget-object v3, Lcom/android/mail/compose/ComposeActivity;->LOG_TAG:Ljava/lang/String;

    const-string v5, "Intializing draft from previous draft message: %s"

    new-array v6, v0, [Ljava/lang/Object;

    aput-object p1, v6, v1

    invoke-static {v3, v5, v6}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1031
    iput-object p1, p0, Lcom/android/mail/compose/ComposeActivity;->mDraft:Lcom/android/mail/providers/Message;

    .line 1032
    iget-wide v5, p1, Lcom/android/mail/providers/Message;->id:J

    iput-wide v5, p0, Lcom/android/mail/compose/ComposeActivity;->mDraftId:J

    .line 1033
    iget-object v3, p0, Lcom/android/mail/compose/ComposeActivity;->mSubject:Landroid/widget/TextView;

    iget-object v5, p1, Lcom/android/mail/providers/Message;->subject:Ljava/lang/String;

    invoke-virtual {v3, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1034
    iget v3, p1, Lcom/android/mail/providers/Message;->draftType:I

    const/4 v5, 0x4

    if-ne v3, v5, :cond_0

    :goto_0
    iput-boolean v0, p0, Lcom/android/mail/compose/ComposeActivity;->mForward:Z

    .line 1035
    invoke-virtual {p1}, Lcom/android/mail/providers/Message;->getToAddresses()[Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    .line 1036
    invoke-direct {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->addToAddresses(Ljava/util/Collection;)V

    .line 1037
    invoke-virtual {p1}, Lcom/android/mail/providers/Message;->getCcAddresses()[Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v3

    invoke-direct {p0, v3, v0}, Lcom/android/mail/compose/ComposeActivity;->addCcAddresses(Ljava/util/Collection;Ljava/util/Collection;)V

    .line 1038
    invoke-virtual {p1}, Lcom/android/mail/providers/Message;->getBccAddresses()[Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->addBccAddresses(Ljava/util/Collection;)V

    .line 1039
    iget-boolean v0, p1, Lcom/android/mail/providers/Message;->hasAttachments:Z

    if-eqz v0, :cond_1

    .line 1040
    invoke-virtual {p1}, Lcom/android/mail/providers/Message;->getAttachments()Ljava/util/List;

    move-result-object v0

    .line 1041
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Attachment;

    .line 1042
    invoke-virtual {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->addAttachmentAndUpdateView(Lcom/android/mail/providers/Attachment;)V

    goto :goto_1

    :cond_0
    move v0, v1

    .line 1034
    goto :goto_0

    .line 1045
    :cond_1
    iget-boolean v0, p1, Lcom/android/mail/providers/Message;->appendRefMessageContent:Z

    if-eqz v0, :cond_3

    iget v0, p1, Lcom/android/mail/providers/Message;->quotedTextOffset:I

    .line 1049
    :goto_2
    iget-object v3, p1, Lcom/android/mail/providers/Message;->bodyHtml:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_5

    .line 1050
    const-string v3, ""

    .line 1051
    if-le v0, v2, :cond_4

    .line 1053
    iget-object v0, p1, Lcom/android/mail/providers/Message;->bodyHtml:Ljava/lang/String;

    invoke-static {v0}, Lcom/android/mail/compose/QuotedTextView;->findQuotedTextIndex(Ljava/lang/CharSequence;)I

    move-result v5

    .line 1054
    if-le v5, v2, :cond_9

    .line 1055
    iget-object v0, p1, Lcom/android/mail/providers/Message;->bodyHtml:Ljava/lang/String;

    invoke-virtual {v0, v1, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v0

    .line 1056
    iget-object v1, p1, Lcom/android/mail/providers/Message;->bodyHtml:Ljava/lang/String;

    iget-object v3, p1, Lcom/android/mail/providers/Message;->bodyHtml:Ljava/lang/String;

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    invoke-virtual {v1, v5, v3}, Ljava/lang/String;->subSequence(II)Ljava/lang/CharSequence;

    move-result-object v1

    move v3, v5

    .line 1062
    :goto_3
    iget-object v4, p0, Lcom/android/mail/compose/ComposeActivity;->mBodyView:Landroid/widget/EditText;

    invoke-virtual {v4, v0}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 1075
    :goto_4
    if-le v3, v2, :cond_2

    if-eqz v1, :cond_2

    .line 1076
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mQuotedTextView:Lcom/android/mail/compose/QuotedTextView;

    iget-boolean v2, p0, Lcom/android/mail/compose/ComposeActivity;->mForward:Z

    invoke-virtual {v0, v1, v2}, Lcom/android/mail/compose/QuotedTextView;->setQuotedTextFromDraft(Ljava/lang/CharSequence;Z)V

    .line 1078
    :cond_2
    return-void

    :cond_3
    move v0, v2

    .line 1045
    goto :goto_2

    .line 1060
    :cond_4
    iget-object v1, p1, Lcom/android/mail/providers/Message;->bodyHtml:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    move v3, v0

    move-object v0, v1

    move-object v1, v4

    goto :goto_3

    .line 1064
    :cond_5
    iget-object v3, p1, Lcom/android/mail/providers/Message;->bodyText:Ljava/lang/String;

    .line 1065
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_8

    if-le v0, v2, :cond_7

    iget-object v5, p1, Lcom/android/mail/providers/Message;->bodyText:Ljava/lang/String;

    invoke-virtual {v5, v1, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    .line 1069
    :goto_5
    if-le v0, v2, :cond_6

    .line 1070
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_6

    iget-object v3, p1, Lcom/android/mail/providers/Message;->bodyText:Ljava/lang/String;

    invoke-virtual {v3, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v4

    .line 1073
    :cond_6
    iget-object v3, p0, Lcom/android/mail/compose/ComposeActivity;->mBodyView:Landroid/widget/EditText;

    invoke-virtual {v3, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    move-object v1, v4

    move v3, v0

    goto :goto_4

    .line 1065
    :cond_7
    iget-object v1, p1, Lcom/android/mail/providers/Message;->bodyText:Ljava/lang/String;

    goto :goto_5

    :cond_8
    const-string v1, ""

    goto :goto_5

    :cond_9
    move-object v0, v3

    move-object v1, v4

    move v3, v5

    goto :goto_3
.end method

.method private initFromRefMessage(ILjava/lang/String;)V
    .locals 3
    .param p1, "action"    # I
    .param p2, "recipientAddress"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 1003
    invoke-direct {p0, p1, p2}, Lcom/android/mail/compose/ComposeActivity;->setFieldsFromRefMessage(ILjava/lang/String;)V

    .line 1004
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mRefMessage:Lcom/android/mail/providers/Message;

    if-eqz v0, :cond_0

    .line 1008
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mCc:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-virtual {v0}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    if-ne p1, v2, :cond_0

    .line 1009
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mCcBccView:Lcom/android/mail/compose/CcBccView;

    invoke-virtual {v0, v1, v2, v1}, Lcom/android/mail/compose/CcBccView;->show(ZZZ)V

    .line 1012
    :cond_0
    invoke-direct {p0}, Lcom/android/mail/compose/ComposeActivity;->updateHideOrShowCcBcc()V

    .line 1013
    return-void
.end method

.method private initFromSpinner(Landroid/os/Bundle;I)V
    .locals 7
    .param p1, "bundle"    # Landroid/os/Bundle;
    .param p2, "action"    # I

    .prologue
    const/16 v6, 0x8

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 745
    const/4 v0, 0x0

    .line 746
    .local v0, "accountString":Ljava/lang/String;
    const/4 v1, 0x3

    if-ne p2, v1, :cond_0

    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mDraft:Lcom/android/mail/providers/Message;

    iget v1, v1, Lcom/android/mail/providers/Message;->draftType:I

    if-ne v1, v5, :cond_0

    .line 747
    const/4 p2, -0x1

    .line 749
    :cond_0
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mFromSpinner:Lcom/android/mail/compose/FromAddressSpinner;

    iget-object v2, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v3, p0, Lcom/android/mail/compose/ComposeActivity;->mAccounts:[Lcom/android/mail/providers/Account;

    invoke-virtual {v1, p2, v2, v3}, Lcom/android/mail/compose/FromAddressSpinner;->asyncInitFromSpinner(ILcom/android/mail/providers/Account;[Lcom/android/mail/providers/Account;)V

    .line 750
    if-eqz p1, :cond_1

    .line 751
    const-string v1, "replyFromAccount"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 752
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    const-string v2, "replyFromAccount"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/android/mail/providers/ReplyFromAccount;->deserialize(Lcom/android/mail/providers/Account;Ljava/lang/String;)Lcom/android/mail/providers/ReplyFromAccount;

    move-result-object v1

    iput-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mReplyFromAccount:Lcom/android/mail/providers/ReplyFromAccount;

    .line 759
    :cond_1
    :goto_0
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mReplyFromAccount:Lcom/android/mail/providers/ReplyFromAccount;

    if-nez v1, :cond_2

    .line 760
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mDraft:Lcom/android/mail/providers/Message;

    if-eqz v1, :cond_5

    .line 761
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v2, p0, Lcom/android/mail/compose/ComposeActivity;->mDraft:Lcom/android/mail/providers/Message;

    invoke-direct {p0, v1, v2}, Lcom/android/mail/compose/ComposeActivity;->getReplyFromAccountFromDraft(Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Message;)Lcom/android/mail/providers/ReplyFromAccount;

    move-result-object v1

    iput-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mReplyFromAccount:Lcom/android/mail/providers/ReplyFromAccount;

    .line 766
    :cond_2
    :goto_1
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mReplyFromAccount:Lcom/android/mail/providers/ReplyFromAccount;

    if-nez v1, :cond_3

    .line 767
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    invoke-direct {p0, v1}, Lcom/android/mail/compose/ComposeActivity;->getDefaultReplyFromAccount(Lcom/android/mail/providers/Account;)Lcom/android/mail/providers/ReplyFromAccount;

    move-result-object v1

    iput-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mReplyFromAccount:Lcom/android/mail/providers/ReplyFromAccount;

    .line 770
    :cond_3
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mFromSpinner:Lcom/android/mail/compose/FromAddressSpinner;

    iget-object v2, p0, Lcom/android/mail/compose/ComposeActivity;->mReplyFromAccount:Lcom/android/mail/providers/ReplyFromAccount;

    invoke-virtual {v1, v2}, Lcom/android/mail/compose/FromAddressSpinner;->setCurrentAccount(Lcom/android/mail/providers/ReplyFromAccount;)V

    .line 772
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mFromSpinner:Lcom/android/mail/compose/FromAddressSpinner;

    invoke-virtual {v1}, Lcom/android/mail/compose/FromAddressSpinner;->getCount()I

    move-result v1

    if-le v1, v5, :cond_6

    .line 776
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mFromStatic:Landroid/view/View;

    invoke-virtual {v1, v6}, Landroid/view/View;->setVisibility(I)V

    .line 777
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mFromStaticText:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v2, v2, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 778
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mFromSpinnerWrapper:Landroid/view/View;

    invoke-virtual {v1, v4}, Landroid/view/View;->setVisibility(I)V

    .line 784
    :goto_2
    return-void

    .line 754
    :cond_4
    const-string v1, "fromAccountString"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 755
    const-string v1, "fromAccountString"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 756
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mFromSpinner:Lcom/android/mail/compose/FromAddressSpinner;

    invoke-virtual {v1, v0}, Lcom/android/mail/compose/FromAddressSpinner;->getMatchingReplyFromAccount(Ljava/lang/String;)Lcom/android/mail/providers/ReplyFromAccount;

    move-result-object v1

    iput-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mReplyFromAccount:Lcom/android/mail/providers/ReplyFromAccount;

    goto :goto_0

    .line 762
    :cond_5
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mRefMessage:Lcom/android/mail/providers/Message;

    if-eqz v1, :cond_2

    .line 763
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v2, p0, Lcom/android/mail/compose/ComposeActivity;->mRefMessage:Lcom/android/mail/providers/Message;

    invoke-direct {p0, v1, v2}, Lcom/android/mail/compose/ComposeActivity;->getReplyFromAccountForReply(Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Message;)Lcom/android/mail/providers/ReplyFromAccount;

    move-result-object v1

    iput-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mReplyFromAccount:Lcom/android/mail/providers/ReplyFromAccount;

    goto :goto_1

    .line 780
    :cond_6
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mFromStatic:Landroid/view/View;

    invoke-virtual {v1, v4}, Landroid/view/View;->setVisibility(I)V

    .line 781
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mFromStaticText:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v2, v2, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 782
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mFromSpinnerWrapper:Landroid/view/View;

    invoke-virtual {v1, v6}, Landroid/view/View;->setVisibility(I)V

    goto :goto_2
.end method

.method private initQuotedTextFromRefMessage(Lcom/android/mail/providers/Message;I)V
    .locals 3
    .param p1, "refMessage"    # Lcom/android/mail/providers/Message;
    .param p2, "action"    # I

    .prologue
    const/4 v2, 0x2

    const/4 v0, 0x1

    .line 1339
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mRefMessage:Lcom/android/mail/providers/Message;

    if-eqz v1, :cond_1

    if-eqz p2, :cond_0

    if-eq p2, v0, :cond_0

    if-ne p2, v2, :cond_1

    .line 1340
    :cond_0
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mQuotedTextView:Lcom/android/mail/compose/QuotedTextView;

    if-eq p2, v2, :cond_2

    :goto_0
    invoke-virtual {v1, p2, p1, v0}, Lcom/android/mail/compose/QuotedTextView;->setQuotedText(ILcom/android/mail/providers/Message;Z)V

    .line 1342
    :cond_1
    return-void

    .line 1340
    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private initRecipients()V
    .locals 1

    .prologue
    .line 1605
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mTo:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-direct {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->setupRecipients(Lcom/android/ex/chips/RecipientEditTextView;)V

    .line 1606
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mCc:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-direct {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->setupRecipients(Lcom/android/ex/chips/RecipientEditTextView;)V

    .line 1607
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mBcc:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-direct {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->setupRecipients(Lcom/android/ex/chips/RecipientEditTextView;)V

    .line 1608
    return-void
.end method

.method private static launch(Landroid/content/Context;Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Message;I)V
    .locals 3

    .prologue
    .line 290
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/android/mail/compose/ComposeActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 291
    const-string v1, "fromemail"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 292
    const-string v1, "action"

    invoke-virtual {v0, v1, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 293
    const-string v1, "account"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 294
    const/4 v1, 0x3

    if-ne p3, v1, :cond_0

    .line 295
    const-string v1, "original-draft-message"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 299
    :goto_0
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 300
    return-void

    .line 297
    :cond_0
    const-string v1, "in-reference-to-message"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    goto :goto_0
.end method

.method private obtainAccount(Landroid/content/Intent;)Lcom/android/mail/providers/Account;
    .locals 9
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 424
    const/4 v1, 0x0

    .line 425
    .local v1, "account":Lcom/android/mail/providers/Account;
    const/4 v2, 0x0

    .line 426
    .local v2, "accountExtra":Ljava/lang/Object;
    if-eqz p1, :cond_2

    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v7

    if-eqz v7, :cond_2

    .line 427
    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v7

    const-string v8, "account"

    invoke-virtual {v7, v8}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    .line 428
    instance-of v7, v2, Lcom/android/mail/providers/Account;

    if-eqz v7, :cond_0

    .line 429
    check-cast v2, Lcom/android/mail/providers/Account;

    .line 467
    .end local v2    # "accountExtra":Ljava/lang/Object;
    :goto_0
    return-object v2

    .line 430
    .restart local v2    # "accountExtra":Ljava/lang/Object;
    :cond_0
    instance-of v7, v2, Ljava/lang/String;

    if-eqz v7, :cond_1

    .line 432
    check-cast v2, Ljava/lang/String;

    .end local v2    # "accountExtra":Ljava/lang/Object;
    invoke-static {v2}, Lcom/android/mail/providers/Account;->newinstance(Ljava/lang/String;)Lcom/android/mail/providers/Account;

    move-result-object v1

    .line 433
    if-eqz v1, :cond_1

    move-object v2, v1

    .line 434
    goto :goto_0

    .line 437
    :cond_1
    const-string v7, "selectedAccount"

    invoke-virtual {p1, v7}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 439
    :cond_2
    if-nez v1, :cond_8

    .line 440
    invoke-static {}, Lcom/android/mail/providers/MailAppProvider;->getInstance()Lcom/android/mail/providers/MailAppProvider;

    move-result-object v7

    invoke-virtual {v7}, Lcom/android/mail/providers/MailAppProvider;->getLastSentFromAccount()Ljava/lang/String;

    move-result-object v5

    .line 441
    .local v5, "lastAccountUri":Ljava/lang/String;
    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v7

    if-nez v7, :cond_8

    .line 442
    invoke-static {v5}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    .local v2, "accountExtra":Landroid/net/Uri;
    move-object v8, v2

    .line 445
    .end local v2    # "accountExtra":Landroid/net/Uri;
    .end local v5    # "lastAccountUri":Ljava/lang/String;
    :goto_1
    iget-object v7, p0, Lcom/android/mail/compose/ComposeActivity;->mAccounts:[Lcom/android/mail/providers/Account;

    if-eqz v7, :cond_7

    iget-object v7, p0, Lcom/android/mail/compose/ComposeActivity;->mAccounts:[Lcom/android/mail/providers/Account;

    array-length v7, v7

    if-lez v7, :cond_7

    .line 446
    instance-of v7, v8, Ljava/lang/String;

    if-eqz v7, :cond_4

    move-object v7, v8

    check-cast v7, Ljava/lang/String;

    invoke-static {v7}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v7

    if-nez v7, :cond_4

    .line 449
    iget-object v3, p0, Lcom/android/mail/compose/ComposeActivity;->mAccounts:[Lcom/android/mail/providers/Account;

    .local v3, "arr$":[Lcom/android/mail/providers/Account;
    array-length v6, v3

    .local v6, "len$":I
    const/4 v4, 0x0

    .local v4, "i$":I
    :goto_2
    if-ge v4, v6, :cond_6

    aget-object v0, v3, v4

    .line 450
    .local v0, "a":Lcom/android/mail/providers/Account;
    iget-object v7, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_3

    .line 451
    move-object v1, v0

    .line 449
    :cond_3
    add-int/lit8 v4, v4, 0x1

    goto :goto_2

    .line 454
    .end local v0    # "a":Lcom/android/mail/providers/Account;
    .end local v3    # "arr$":[Lcom/android/mail/providers/Account;
    .end local v4    # "i$":I
    .end local v6    # "len$":I
    :cond_4
    instance-of v7, v8, Landroid/net/Uri;

    if-eqz v7, :cond_6

    .line 457
    iget-object v3, p0, Lcom/android/mail/compose/ComposeActivity;->mAccounts:[Lcom/android/mail/providers/Account;

    .restart local v3    # "arr$":[Lcom/android/mail/providers/Account;
    array-length v6, v3

    .restart local v6    # "len$":I
    const/4 v4, 0x0

    .restart local v4    # "i$":I
    :goto_3
    if-ge v4, v6, :cond_6

    aget-object v0, v3, v4

    .line 458
    .restart local v0    # "a":Lcom/android/mail/providers/Account;
    iget-object v7, v0, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    invoke-virtual {v7, v8}, Landroid/net/Uri;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_5

    .line 459
    move-object v1, v0

    .line 457
    :cond_5
    add-int/lit8 v4, v4, 0x1

    goto :goto_3

    .line 463
    .end local v0    # "a":Lcom/android/mail/providers/Account;
    .end local v3    # "arr$":[Lcom/android/mail/providers/Account;
    .end local v4    # "i$":I
    .end local v6    # "len$":I
    :cond_6
    if-nez v1, :cond_7

    .line 464
    iget-object v7, p0, Lcom/android/mail/compose/ComposeActivity;->mAccounts:[Lcom/android/mail/providers/Account;

    const/4 v8, 0x0

    aget-object v1, v7, v8

    :cond_7
    move-object v2, v1

    .line 467
    goto :goto_0

    :cond_8
    move-object v8, v2

    goto :goto_1
.end method

.method private onAppUpPressed()V
    .locals 2

    .prologue
    .line 1744
    iget-boolean v0, p0, Lcom/android/mail/compose/ComposeActivity;->mLaunchedFromEmail:Z

    if-eqz v0, :cond_0

    .line 1747
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->onBackPressed()V

    .line 1759
    :goto_0
    return-void

    .line 1754
    :cond_0
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    invoke-static {v0}, Lcom/android/mail/utils/Utils;->createViewInboxIntent(Lcom/android/mail/providers/Account;)Landroid/content/Intent;

    move-result-object v0

    .line 1755
    const v1, 0x1000c000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 1757
    invoke-virtual {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->startActivity(Landroid/content/Intent;)V

    .line 1758
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->finish()V

    goto :goto_0
.end method

.method public static registerTestSendOrSaveCallback(Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;)V
    .locals 2

    .prologue
    .line 2813
    sget-object v0, Lcom/android/mail/compose/ComposeActivity;->sTestSendOrSaveCallback:Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;

    if-eqz v0, :cond_0

    if-eqz p0, :cond_0

    .line 2814
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Attempting to register more than one test callback"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 2816
    :cond_0
    sput-object p0, Lcom/android/mail/compose/ComposeActivity;->sTestSendOrSaveCallback:Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;

    .line 2817
    return-void
.end method

.method private replaceFragment(Landroid/app/Fragment;ILjava/lang/String;)I
    .locals 2

    .prologue
    .line 2909
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v0

    .line 2910
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 2911
    invoke-virtual {v0, p2}, Landroid/app/FragmentTransaction;->setTransition(I)Landroid/app/FragmentTransaction;

    .line 2912
    const v1, 0x7f100044

    invoke-virtual {v0, v1, p1, p3}, Landroid/app/FragmentTransaction;->replace(ILandroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 2913
    invoke-virtual {v0}, Landroid/app/FragmentTransaction;->commitAllowingStateLoss()I

    move-result v0

    .line 2914
    return v0
.end method

.method public static reply(Landroid/content/Context;Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Message;)V
    .locals 1
    .param p0, "launcher"    # Landroid/content/Context;
    .param p1, "account"    # Lcom/android/mail/providers/Account;
    .param p2, "message"    # Lcom/android/mail/providers/Message;

    .prologue
    .line 272
    const/4 v0, 0x0

    invoke-static {p0, p1, p2, v0}, Lcom/android/mail/compose/ComposeActivity;->launch(Landroid/content/Context;Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Message;I)V

    .line 273
    return-void
.end method

.method public static replyAll(Landroid/content/Context;Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Message;)V
    .locals 1
    .param p0, "launcher"    # Landroid/content/Context;
    .param p1, "account"    # Lcom/android/mail/providers/Account;
    .param p2, "message"    # Lcom/android/mail/providers/Message;

    .prologue
    .line 279
    const/4 v0, 0x1

    invoke-static {p0, p1, p2, v0}, Lcom/android/mail/compose/ComposeActivity;->launch(Landroid/content/Context;Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Message;I)V

    .line 280
    return-void
.end method

.method private saveIfNeeded()V
    .locals 1

    .prologue
    .line 2690
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    if-nez v0, :cond_1

    .line 2700
    :cond_0
    :goto_0
    return-void

    .line 2697
    :cond_1
    invoke-direct {p0}, Lcom/android/mail/compose/ComposeActivity;->shouldSave()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2698
    iget-boolean v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAddingAttachment:Z

    if-nez v0, :cond_2

    const/4 v0, 0x1

    :goto_1
    invoke-direct {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->doSave(Z)V

    goto :goto_0

    :cond_2
    const/4 v0, 0x0

    goto :goto_1
.end method

.method private saveRequestMap()V
    .locals 0

    .prologue
    .line 2432
    return-void
.end method

.method private sendOrSave(Landroid/text/Spanned;ZZZ)V
    .locals 11

    .prologue
    .line 2287
    invoke-static {}, Landroid/app/ActivityManager;->isUserAMonkey()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 2423
    :cond_0
    :goto_0
    return-void

    .line 2292
    :cond_1
    if-eqz p4, :cond_6

    .line 2293
    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/String;

    .line 2300
    :goto_1
    new-instance v6, Lcom/android/mail/compose/ComposeActivity$3;

    invoke-direct {v6, p0}, Lcom/android/mail/compose/ComposeActivity$3;-><init>(Lcom/android/mail/compose/ComposeActivity;)V

    .line 2380
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mReplyFromAccount:Lcom/android/mail/providers/ReplyFromAccount;

    .line 2381
    iget-object v1, v0, Lcom/android/mail/providers/ReplyFromAccount;->name:Ljava/lang/String;

    .line 2382
    if-eqz v0, :cond_2

    if-nez v1, :cond_8

    .line 2385
    :cond_2
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mReplyFromAccount:Lcom/android/mail/providers/ReplyFromAccount;

    .line 2386
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v1, v1, Landroid/accounts/Account;->name:Ljava/lang/String;

    move-object v10, v0

    .line 2389
    :goto_2
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mSendSaveTaskHandler:Landroid/os/Handler;

    if-nez v0, :cond_3

    .line 2390
    new-instance v0, Landroid/os/HandlerThread;

    const-string v1, "Send Message Task Thread"

    invoke-direct {v0, v1}, Landroid/os/HandlerThread;-><init>(Ljava/lang/String;)V

    .line 2391
    invoke-virtual {v0}, Landroid/os/HandlerThread;->start()V

    .line 2393
    new-instance v1, Landroid/os/Handler;

    invoke-virtual {v0}, Landroid/os/HandlerThread;->getLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-direct {v1, v0}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mSendSaveTaskHandler:Landroid/os/Handler;

    .line 2396
    :cond_3
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mReplyFromAccount:Lcom/android/mail/providers/ReplyFromAccount;

    invoke-direct {p0}, Lcom/android/mail/compose/ComposeActivity;->getMode()I

    move-result v1

    invoke-direct {p0, v0, v1}, Lcom/android/mail/compose/ComposeActivity;->createMessage(Lcom/android/mail/providers/ReplyFromAccount;I)Lcom/android/mail/providers/Message;

    move-result-object v2

    .line 2397
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mReplyFromAccount:Lcom/android/mail/providers/ReplyFromAccount;

    iget-object v3, p0, Lcom/android/mail/compose/ComposeActivity;->mRefMessage:Lcom/android/mail/providers/Message;

    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mQuotedTextView:Lcom/android/mail/compose/QuotedTextView;

    invoke-virtual {v0}, Lcom/android/mail/compose/QuotedTextView;->getQuotedTextIfIncluded()Ljava/lang/CharSequence;

    move-result-object v5

    iget-object v7, p0, Lcom/android/mail/compose/ComposeActivity;->mSendSaveTaskHandler:Landroid/os/Handler;

    iget v9, p0, Lcom/android/mail/compose/ComposeActivity;->mComposeMode:I

    move-object v0, p0

    move-object v4, p1

    move v8, p2

    invoke-static/range {v0 .. v9}, Lcom/android/mail/compose/ComposeActivity;->sendOrSaveInternal(Landroid/content/Context;Lcom/android/mail/providers/ReplyFromAccount;Lcom/android/mail/providers/Message;Lcom/android/mail/providers/Message;Landroid/text/Spanned;Ljava/lang/CharSequence;Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;Landroid/os/Handler;ZI)I

    move-result v0

    iput v0, p0, Lcom/android/mail/compose/ComposeActivity;->mRequestId:I

    .line 2401
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mRecipient:Ljava/lang/String;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mRecipient:Ljava/lang/String;

    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v1, v1, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 2402
    iget-object v0, v10, Lcom/android/mail/providers/ReplyFromAccount;->name:Ljava/lang/String;

    iput-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mRecipient:Ljava/lang/String;

    .line 2404
    :cond_4
    iget-object v0, v10, Lcom/android/mail/providers/ReplyFromAccount;->account:Lcom/android/mail/providers/Account;

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->setAccount(Lcom/android/mail/providers/Account;)V

    .line 2409
    if-eqz p3, :cond_5

    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->getChangingConfigurations()I

    move-result v0

    and-int/lit16 v0, v0, 0x80

    if-nez v0, :cond_5

    .line 2410
    if-eqz p2, :cond_7

    const v0, 0x7f0c00c6

    :goto_3
    const/4 v1, 0x1

    invoke-static {p0, v0, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 2416
    :cond_5
    invoke-direct {p0}, Lcom/android/mail/compose/ComposeActivity;->discardChanges()V

    .line 2417
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->updateSaveUi()V

    .line 2420
    if-nez p2, :cond_0

    .line 2421
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->finish()V

    goto/16 :goto_0

    .line 2295
    :cond_6
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->getToAddresses()[Ljava/lang/String;

    .line 2296
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->getCcAddresses()[Ljava/lang/String;

    .line 2297
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->getBccAddresses()[Ljava/lang/String;

    goto/16 :goto_1

    .line 2410
    :cond_7
    const v0, 0x7f0c00c7

    goto :goto_3

    :cond_8
    move-object v10, v0

    goto/16 :goto_2
.end method

.method static sendOrSaveInternal(Landroid/content/Context;Lcom/android/mail/providers/ReplyFromAccount;Lcom/android/mail/providers/Message;Lcom/android/mail/providers/Message;Landroid/text/Spanned;Ljava/lang/CharSequence;Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;Landroid/os/Handler;ZI)I
    .locals 8

    .prologue
    .line 2201
    new-instance v4, Landroid/content/ContentValues;

    invoke-direct {v4}, Landroid/content/ContentValues;-><init>()V

    .line 2203
    if-eqz p3, :cond_4

    iget-object v1, p3, Lcom/android/mail/providers/Message;->uri:Landroid/net/Uri;

    invoke-virtual {v1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v1

    .line 2205
    :goto_0
    invoke-virtual {p2}, Lcom/android/mail/providers/Message;->getToAddresses()[Ljava/lang/String;

    move-result-object v2

    invoke-static {v4, v2}, Lcom/android/mail/providers/MessageModification;->putToAddresses(Landroid/content/ContentValues;[Ljava/lang/String;)V

    .line 2206
    invoke-virtual {p2}, Lcom/android/mail/providers/Message;->getCcAddresses()[Ljava/lang/String;

    move-result-object v2

    invoke-static {v4, v2}, Lcom/android/mail/providers/MessageModification;->putCcAddresses(Landroid/content/ContentValues;[Ljava/lang/String;)V

    .line 2207
    invoke-virtual {p2}, Lcom/android/mail/providers/Message;->getBccAddresses()[Ljava/lang/String;

    move-result-object v2

    invoke-static {v4, v2}, Lcom/android/mail/providers/MessageModification;->putBccAddresses(Landroid/content/ContentValues;[Ljava/lang/String;)V

    .line 2209
    iget-object v2, p2, Lcom/android/mail/providers/Message;->from:Ljava/lang/String;

    invoke-static {v4, v2}, Lcom/android/mail/providers/MessageModification;->putCustomFromAddress(Landroid/content/ContentValues;Ljava/lang/String;)V

    .line 2211
    iget-object v2, p2, Lcom/android/mail/providers/Message;->subject:Ljava/lang/String;

    invoke-static {v4, v2}, Lcom/android/mail/providers/MessageModification;->putSubject(Landroid/content/ContentValues;Ljava/lang/String;)V

    .line 2212
    invoke-static {p4}, Landroid/text/Html;->toHtml(Landroid/text/Spanned;)Ljava/lang/String;

    move-result-object v3

    .line 2214
    invoke-static {p5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_5

    const/4 v2, 0x1

    .line 2215
    :goto_1
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 2216
    if-eqz v2, :cond_0

    .line 2218
    invoke-virtual {p5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    .line 2219
    invoke-static {v3}, Lcom/android/mail/compose/QuotedTextView;->containsQuotedText(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_7

    .line 2220
    invoke-static {v3}, Lcom/android/mail/compose/QuotedTextView;->getQuotedTextOffset(Ljava/lang/String;)I

    move-result v6

    .line 2221
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->length()I

    move-result v7

    add-int/2addr v6, v7

    .line 2222
    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 2223
    int-to-long v6, v6

    invoke-static {v4, v6, v7}, Lcom/android/mail/providers/MessageModification;->putQuoteStartPos(Landroid/content/ContentValues;J)V

    .line 2224
    const/4 v3, 0x2

    move/from16 v0, p9

    if-ne v0, v3, :cond_6

    const/4 v3, 0x1

    :goto_2
    invoke-static {v4, v3}, Lcom/android/mail/providers/MessageModification;->putForward(Landroid/content/ContentValues;Z)V

    .line 2225
    invoke-static {v4, v2}, Lcom/android/mail/providers/MessageModification;->putAppendRefMessageContent(Landroid/content/ContentValues;Z)V

    .line 2233
    :cond_0
    :goto_3
    invoke-static/range {p9 .. p9}, Lcom/android/mail/compose/ComposeActivity;->getDraftType(I)I

    move-result v2

    .line 2234
    invoke-static {v4, v2}, Lcom/android/mail/providers/MessageModification;->putDraftType(Landroid/content/ContentValues;I)V

    .line 2235
    if-eqz p3, :cond_8

    .line 2236
    iget-object v2, p3, Lcom/android/mail/providers/Message;->bodyHtml:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 2237
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v4, v2}, Lcom/android/mail/providers/MessageModification;->putBodyHtml(Landroid/content/ContentValues;Ljava/lang/String;)V

    .line 2239
    :cond_1
    iget-object v2, p3, Lcom/android/mail/providers/Message;->bodyText:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 2240
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v4, v2}, Lcom/android/mail/providers/MessageModification;->putBody(Landroid/content/ContentValues;Ljava/lang/String;)V

    .line 2246
    :cond_2
    :goto_4
    invoke-virtual {p2}, Lcom/android/mail/providers/Message;->getAttachments()Ljava/util/List;

    move-result-object v2

    invoke-static {v4, v2}, Lcom/android/mail/providers/MessageModification;->putAttachments(Landroid/content/ContentValues;Ljava/util/List;)V

    .line 2247
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_3

    .line 2248
    invoke-static {v4, v1}, Lcom/android/mail/providers/MessageModification;->putRefMessageId(Landroid/content/ContentValues;Ljava/lang/String;)V

    .line 2251
    :cond_3
    new-instance v2, Lcom/android/mail/compose/ComposeActivity$SendOrSaveMessage;

    move/from16 v0, p8

    invoke-direct {v2, p1, v4, v1, v0}, Lcom/android/mail/compose/ComposeActivity$SendOrSaveMessage;-><init>(Lcom/android/mail/providers/ReplyFromAccount;Landroid/content/ContentValues;Ljava/lang/String;Z)V

    .line 2253
    new-instance v1, Lcom/android/mail/compose/ComposeActivity$SendOrSaveTask;

    invoke-direct {v1, p0, v2, p6}, Lcom/android/mail/compose/ComposeActivity$SendOrSaveTask;-><init>(Landroid/content/Context;Lcom/android/mail/compose/ComposeActivity$SendOrSaveMessage;Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;)V

    .line 2255
    invoke-interface {p6, v1}, Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;->initializeSendOrSave(Lcom/android/mail/compose/ComposeActivity$SendOrSaveTask;)V

    .line 2259
    invoke-virtual {p7, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 2261
    invoke-virtual {v2}, Lcom/android/mail/compose/ComposeActivity$SendOrSaveMessage;->requestId()I

    move-result v1

    return v1

    .line 2203
    :cond_4
    const-string v1, ""

    goto/16 :goto_0

    .line 2214
    :cond_5
    const/4 v2, 0x0

    goto/16 :goto_1

    .line 2224
    :cond_6
    const/4 v3, 0x0

    goto :goto_2

    .line 2227
    :cond_7
    sget-object v2, Lcom/android/mail/compose/ComposeActivity;->LOG_TAG:Ljava/lang/String;

    const-string v6, "Couldn\'t find quoted text"

    const/4 v7, 0x0

    new-array v7, v7, [Ljava/lang/Object;

    invoke-static {v2, v6, v7}, Lcom/android/mail/utils/LogUtils;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 2230
    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_3

    .line 2243
    :cond_8
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v4, v2}, Lcom/android/mail/providers/MessageModification;->putBodyHtml(Landroid/content/ContentValues;Ljava/lang/String;)V

    .line 2244
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v4, v2}, Lcom/android/mail/providers/MessageModification;->putBody(Landroid/content/ContentValues;Ljava/lang/String;)V

    goto :goto_4
.end method

.method private setFieldsFromRefMessage(ILjava/lang/String;)V
    .locals 2
    .param p1, "action"    # I
    .param p2, "recipientAddress"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x2

    .line 1016
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mRefMessage:Lcom/android/mail/providers/Message;

    invoke-direct {p0, v0, p1}, Lcom/android/mail/compose/ComposeActivity;->setSubject(Lcom/android/mail/providers/Message;I)V

    .line 1018
    if-ne p1, v1, :cond_0

    .line 1019
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/mail/compose/ComposeActivity;->mForward:Z

    .line 1021
    :cond_0
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mRefMessage:Lcom/android/mail/providers/Message;

    invoke-virtual {p0, p2, v0, p1}, Lcom/android/mail/compose/ComposeActivity;->initRecipientsFromRefMessage(Ljava/lang/String;Lcom/android/mail/providers/Message;I)V

    .line 1022
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mRefMessage:Lcom/android/mail/providers/Message;

    invoke-direct {p0, v0, p1}, Lcom/android/mail/compose/ComposeActivity;->initQuotedTextFromRefMessage(Lcom/android/mail/providers/Message;I)V

    .line 1023
    if-eq p1, v1, :cond_1

    iget-boolean v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAttachmentsChanged:Z

    if-eqz v0, :cond_2

    .line 1024
    :cond_1
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mRefMessage:Lcom/android/mail/providers/Message;

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->initAttachments(Lcom/android/mail/providers/Message;)V

    .line 1026
    :cond_2
    return-void
.end method

.method private setFocus(I)V
    .locals 2
    .param p1, "action"    # I

    .prologue
    .line 500
    const/4 v1, 0x3

    if-ne p1, v1, :cond_0

    .line 501
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mDraft:Lcom/android/mail/providers/Message;

    iget v0, v1, Lcom/android/mail/providers/Message;->draftType:I

    .line 502
    .local v0, "type":I
    packed-switch v0, :pswitch_data_0

    .line 510
    :pswitch_0
    const/4 p1, 0x0

    .line 514
    .end local v0    # "type":I
    :cond_0
    :goto_0
    packed-switch p1, :pswitch_data_1

    .line 522
    :pswitch_1
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->focusBody()V

    .line 525
    :goto_1
    return-void

    .line 505
    .restart local v0    # "type":I
    :pswitch_2
    const/4 p1, -0x1

    .line 506
    goto :goto_0

    .line 517
    .end local v0    # "type":I
    :pswitch_3
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mTo:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-virtual {v1}, Lcom/android/ex/chips/RecipientEditTextView;->requestFocus()Z

    goto :goto_1

    .line 502
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_0
        :pswitch_0
        :pswitch_2
    .end packed-switch

    .line 514
    :pswitch_data_1
    .packed-switch -0x1
        :pswitch_3
        :pswitch_1
        :pswitch_1
        :pswitch_3
    .end packed-switch
.end method

.method private setSubject(Lcom/android/mail/providers/Message;I)V
    .locals 5

    .prologue
    const/4 v4, 0x2

    .line 1582
    iget-object v1, p1, Lcom/android/mail/providers/Message;->subject:Ljava/lang/String;

    .line 1585
    const/4 v0, -0x1

    if-ne p2, v0, :cond_0

    .line 1586
    const-string v0, ""

    .line 1594
    :goto_0
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_2

    invoke-virtual {v1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    move-object v0, v1

    .line 1601
    :goto_1
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mSubject:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1602
    return-void

    .line 1587
    :cond_0
    if-ne p2, v4, :cond_1

    .line 1588
    const v0, 0x7f0c0028

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1590
    :cond_1
    const v0, 0x7f0c0027

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1598
    :cond_2
    const v2, 0x7f0c0026

    invoke-virtual {p0, v2}, Lcom/android/mail/compose/ComposeActivity;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v4, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v0, v3, v4

    const/4 v0, 0x1

    aput-object v1, v3, v0

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_1
.end method

.method private setupRecipients(Lcom/android/ex/chips/RecipientEditTextView;)V
    .locals 3

    .prologue
    .line 1611
    new-instance v0, Lcom/android/mail/compose/RecipientAdapter;

    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    invoke-direct {v0, p0, v1}, Lcom/android/mail/compose/RecipientAdapter;-><init>(Landroid/content/Context;Lcom/android/mail/providers/Account;)V

    invoke-virtual {p1, v0}, Lcom/android/ex/chips/RecipientEditTextView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 1612
    new-instance v0, Landroid/text/util/Rfc822Tokenizer;

    invoke-direct {v0}, Landroid/text/util/Rfc822Tokenizer;-><init>()V

    invoke-virtual {p1, v0}, Lcom/android/ex/chips/RecipientEditTextView;->setTokenizer(Landroid/widget/MultiAutoCompleteTextView$Tokenizer;)V

    .line 1613
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mValidator:Lcom/android/common/Rfc822Validator;

    if-nez v0, :cond_1

    .line 1614
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v0, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    .line 1615
    const-string v1, "@"

    invoke-virtual {v0, v1}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    add-int/lit8 v1, v1, 0x1

    .line 1617
    const/4 v2, -0x1

    if-le v1, v2, :cond_0

    .line 1618
    const-string v1, "@"

    invoke-virtual {v0, v1}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    add-int/lit8 v1, v1, 0x1

    invoke-virtual {v0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    .line 1620
    :cond_0
    new-instance v1, Lcom/android/common/Rfc822Validator;

    invoke-direct {v1, v0}, Lcom/android/common/Rfc822Validator;-><init>(Ljava/lang/String;)V

    iput-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mValidator:Lcom/android/common/Rfc822Validator;

    .line 1622
    :cond_1
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mValidator:Lcom/android/common/Rfc822Validator;

    invoke-virtual {p1, v0}, Lcom/android/ex/chips/RecipientEditTextView;->setValidator(Landroid/widget/AutoCompleteTextView$Validator;)V

    .line 1623
    return-void
.end method

.method private shouldSave()Z
    .locals 2

    .prologue
    .line 1996
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mDraftLock:Ljava/lang/Object;

    monitor-enter v1

    .line 2002
    :try_start_0
    iget-boolean v0, p0, Lcom/android/mail/compose/ComposeActivity;->mTextChanged:Z

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAttachmentsChanged:Z

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/android/mail/compose/ComposeActivity;->mReplyFromChanged:Z

    if-eqz v0, :cond_1

    :cond_0
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->isBlank()Z

    move-result v0

    if-nez v0, :cond_1

    const/4 v0, 0x1

    :goto_0
    monitor-exit v1

    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    .line 2004
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method private showAttachmentTooBigToast(I)V
    .locals 4
    .param p1, "errorRes"    # I

    .prologue
    .line 1264
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v2, v2, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    invoke-virtual {v2}, Lcom/android/mail/providers/Settings;->getMaxAttachmentSize()I

    move-result v2

    int-to-long v2, v2

    invoke-static {v1, v2, v3}, Lcom/android/mail/utils/AttachmentUtils;->convertToHumanReadableSize(Landroid/content/Context;J)Ljava/lang/String;

    move-result-object v0

    .line 1266
    .local v0, "maxSize":Ljava/lang/String;
    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object v0, v1, v2

    invoke-virtual {p0, p1, v1}, Lcom/android/mail/compose/ComposeActivity;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/android/mail/compose/ComposeActivity;->showErrorToast(Ljava/lang/String;)V

    .line 1267
    return-void
.end method

.method private showCcBcc(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "state"    # Landroid/os/Bundle;

    .prologue
    .line 1360
    if-eqz p1, :cond_1

    const-string v2, "showCc"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 1361
    const-string v2, "showCc"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    .line 1362
    .local v1, "showCc":Z
    const-string v2, "showBcc"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    .line 1363
    .local v0, "showBcc":Z
    if-nez v1, :cond_0

    if-eqz v0, :cond_1

    .line 1364
    :cond_0
    iget-object v2, p0, Lcom/android/mail/compose/ComposeActivity;->mCcBccView:Lcom/android/mail/compose/CcBccView;

    const/4 v3, 0x0

    invoke-virtual {v2, v3, v1, v0}, Lcom/android/mail/compose/CcBccView;->show(ZZZ)V

    .line 1367
    .end local v0    # "showBcc":Z
    .end local v1    # "showCc":Z
    :cond_1
    return-void
.end method

.method private showCcBccViews()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 2445
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mCcBccView:Lcom/android/mail/compose/CcBccView;

    invoke-virtual {v0, v1, v1, v1}, Lcom/android/mail/compose/CcBccView;->show(ZZZ)V

    .line 2446
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mCcBccButton:Landroid/widget/Button;

    if-eqz v0, :cond_0

    .line 2447
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mCcBccButton:Landroid/widget/Button;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setVisibility(I)V

    .line 2449
    :cond_0
    return-void
.end method

.method private showErrorToast(Ljava/lang/String;)V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 1270
    invoke-static {p0, p1, v4}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 1271
    invoke-virtual {v0, p1}, Landroid/widget/Toast;->setText(Ljava/lang/CharSequence;)V

    .line 1272
    const/4 v1, 0x0

    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0b0044

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    invoke-virtual {v0, v4, v1, v2}, Landroid/widget/Toast;->setGravity(III)V

    .line 1274
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 1275
    return-void
.end method

.method private showSendConfirmDialog(ILandroid/content/DialogInterface$OnClickListener;)V
    .locals 2

    .prologue
    .line 2165
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mSendConfirmDialog:Landroid/app/AlertDialog;

    if-eqz v0, :cond_0

    .line 2166
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mSendConfirmDialog:Landroid/app/AlertDialog;

    invoke-virtual {v0}, Landroid/app/AlertDialog;->dismiss()V

    .line 2167
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mSendConfirmDialog:Landroid/app/AlertDialog;

    .line 2169
    :cond_0
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-direct {v0, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    invoke-virtual {v0, p1}, Landroid/app/AlertDialog$Builder;->setMessage(I)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const v1, 0x7f0c0033

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(I)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const v1, 0x1010355

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setIconAttribute(I)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const v1, 0x7f0c003a

    invoke-virtual {v0, v1, p2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const v1, 0x7f0c00d3

    invoke-virtual {v0, v1, p0}, Landroid/app/AlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mSendConfirmDialog:Landroid/app/AlertDialog;

    .line 2175
    return-void
.end method

.method private showWaitFragment(Lcom/android/mail/providers/Account;)V
    .locals 3

    .prologue
    .line 2894
    invoke-direct {p0}, Lcom/android/mail/compose/ComposeActivity;->getWaitFragment()Lcom/android/mail/ui/WaitFragment;

    move-result-object v0

    .line 2895
    if-eqz v0, :cond_0

    .line 2896
    invoke-virtual {v0, p1}, Lcom/android/mail/ui/WaitFragment;->updateAccount(Lcom/android/mail/providers/Account;)V

    .line 2902
    :goto_0
    return-void

    .line 2898
    :cond_0
    const v0, 0x7f100044

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 2899
    const/4 v0, 0x1

    invoke-static {p1, v0}, Lcom/android/mail/ui/WaitFragment;->newInstance(Lcom/android/mail/providers/Account;Z)Lcom/android/mail/ui/WaitFragment;

    move-result-object v0

    const/16 v1, 0x1001

    const-string v2, "wait-fragment"

    invoke-direct {p0, v0, v1, v2}, Lcom/android/mail/compose/ComposeActivity;->replaceFragment(Landroid/app/Fragment;ILjava/lang/String;)I

    goto :goto_0
.end method

.method private updateHideOrShowCcBcc()V
    .locals 3

    .prologue
    .line 1346
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mCcBccView:Lcom/android/mail/compose/CcBccView;

    invoke-virtual {v0}, Lcom/android/mail/compose/CcBccView;->isCcVisible()Z

    move-result v0

    .line 1347
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mCcBccView:Lcom/android/mail/compose/CcBccView;

    invoke-virtual {v1}, Lcom/android/mail/compose/CcBccView;->isBccVisible()Z

    move-result v1

    .line 1348
    iget-object v2, p0, Lcom/android/mail/compose/ComposeActivity;->mCcBccButton:Landroid/widget/Button;

    if-eqz v2, :cond_1

    .line 1349
    if-eqz v0, :cond_0

    if-nez v1, :cond_3

    .line 1350
    :cond_0
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mCcBccButton:Landroid/widget/Button;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setVisibility(I)V

    .line 1351
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mCcBccButton:Landroid/widget/Button;

    if-nez v0, :cond_2

    const v0, 0x7f0c005e

    :goto_0
    invoke-virtual {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 1357
    :cond_1
    :goto_1
    return-void

    .line 1351
    :cond_2
    const v0, 0x7f0c005f

    goto :goto_0

    .line 1354
    :cond_3
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mCcBccButton:Landroid/widget/Button;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setVisibility(I)V

    goto :goto_1
.end method

.method private updateHideOrShowQuotedText(Z)V
    .locals 2
    .param p1, "showQuotedText"    # Z

    .prologue
    .line 495
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mQuotedTextView:Lcom/android/mail/compose/QuotedTextView;

    invoke-virtual {v0, p1}, Lcom/android/mail/compose/QuotedTextView;->updateCheckedState(Z)V

    .line 496
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mQuotedTextView:Lcom/android/mail/compose/QuotedTextView;

    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAttachmentsView:Lcom/android/mail/compose/AttachmentsView;

    invoke-virtual {v0}, Lcom/android/mail/compose/AttachmentsView;->getAttachments()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {v1, v0}, Lcom/android/mail/compose/QuotedTextView;->setUpperDividerVisible(Z)V

    .line 497
    return-void

    .line 496
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private updateMessage(Lcom/android/mail/providers/Message;Lcom/android/mail/providers/ReplyFromAccount;I)V
    .locals 1
    .param p1, "message"    # Lcom/android/mail/providers/Message;
    .param p2, "selectedReplyFromAccount"    # Lcom/android/mail/providers/ReplyFromAccount;
    .param p3, "mode"    # I

    .prologue
    .line 717
    if-eqz p2, :cond_0

    iget-object v0, p2, Lcom/android/mail/providers/ReplyFromAccount;->address:Ljava/lang/String;

    :goto_0
    iput-object v0, p1, Lcom/android/mail/providers/Message;->from:Ljava/lang/String;

    .line 719
    invoke-static {p3}, Lcom/android/mail/compose/ComposeActivity;->getDraftType(I)I

    move-result v0

    iput v0, p1, Lcom/android/mail/providers/Message;->draftType:I

    .line 720
    return-void

    .line 717
    :cond_0
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v0, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method addAddressesToList(Ljava/util/Collection;Lcom/android/ex/chips/RecipientEditTextView;)V
    .locals 3
    .param p2, "list"    # Lcom/android/ex/chips/RecipientEditTextView;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/android/ex/chips/RecipientEditTextView;",
            ")V"
        }
    .end annotation

    .prologue
    .line 1514
    .local p1, "addresses":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 1515
    .local v0, "address":Ljava/lang/String;
    invoke-direct {p0, v0, p2}, Lcom/android/mail/compose/ComposeActivity;->addAddressToList(Ljava/lang/String;Lcom/android/ex/chips/RecipientEditTextView;)V

    goto :goto_0

    .line 1517
    .end local v0    # "address":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method public addAttachmentAndUpdateView(Landroid/content/Intent;)V
    .locals 1
    .param p1, "data"    # Landroid/content/Intent;

    .prologue
    .line 1374
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v0

    :goto_0
    invoke-virtual {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->addAttachmentAndUpdateView(Landroid/net/Uri;)V

    .line 1375
    return-void

    .line 1374
    :cond_0
    const/4 v0, 0x0

    check-cast v0, Landroid/net/Uri;

    goto :goto_0
.end method

.method public addAttachmentAndUpdateView(Landroid/net/Uri;)V
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 1378
    if-nez p1, :cond_0

    .line 1390
    :goto_0
    return-void

    .line 1382
    :cond_0
    :try_start_0
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAttachmentsView:Lcom/android/mail/compose/AttachmentsView;

    invoke-virtual {v0, p1}, Lcom/android/mail/compose/AttachmentsView;->generateLocalAttachment(Landroid/net/Uri;)Lcom/android/mail/providers/Attachment;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->addAttachmentAndUpdateView(Lcom/android/mail/providers/Attachment;)V
    :try_end_0
    .catch Lcom/android/mail/compose/AttachmentsView$AttachmentFailureException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 1383
    :catch_0
    move-exception v0

    .line 1384
    sget-object v1, Lcom/android/mail/compose/ComposeActivity;->LOG_TAG:Ljava/lang/String;

    const-string v2, "Error adding attachment"

    new-array v3, v6, [Ljava/lang/Object;

    invoke-static {v1, v0, v2, v3}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1385
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v0}, Lcom/android/mail/compose/AttachmentsView$AttachmentFailureException;->getErrorRes()I

    move-result v0

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    iget-object v4, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v4, v4, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    invoke-virtual {v4}, Lcom/android/mail/providers/Settings;->getMaxAttachmentSize()I

    move-result v4

    int-to-long v4, v4

    invoke-static {v3, v4, v5}, Lcom/android/mail/utils/AttachmentUtils;->convertToHumanReadableSize(Landroid/content/Context;J)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v6

    invoke-virtual {v1, v0, v2}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->showErrorToast(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public addAttachmentAndUpdateView(Lcom/android/mail/providers/Attachment;)V
    .locals 4

    .prologue
    .line 1394
    :try_start_0
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAttachmentsView:Lcom/android/mail/compose/AttachmentsView;

    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    invoke-virtual {v0, v1, p1}, Lcom/android/mail/compose/AttachmentsView;->addAttachment(Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Attachment;)J

    move-result-wide v0

    .line 1395
    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-lez v0, :cond_0

    .line 1396
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAttachmentsChanged:Z

    .line 1397
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->updateSaveUi()V
    :try_end_0
    .catch Lcom/android/mail/compose/AttachmentsView$AttachmentFailureException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1403
    :cond_0
    :goto_0
    return-void

    .line 1399
    :catch_0
    move-exception v0

    .line 1400
    sget-object v1, Lcom/android/mail/compose/ComposeActivity;->LOG_TAG:Ljava/lang/String;

    const-string v2, "Error adding attachment"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v1, v0, v2, v3}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1401
    invoke-virtual {v0}, Lcom/android/mail/compose/AttachmentsView$AttachmentFailureException;->getErrorRes()I

    move-result v0

    invoke-direct {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->showAttachmentTooBigToast(I)V

    goto :goto_0
.end method

.method public addAttachments(Ljava/util/List;)J
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/android/mail/providers/Attachment;",
            ">;)J"
        }
    .end annotation

    .prologue
    .line 1238
    const-wide/16 v2, 0x0

    .line 1239
    const/4 v1, 0x0

    .line 1240
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Attachment;

    .line 1242
    :try_start_0
    iget-object v5, p0, Lcom/android/mail/compose/ComposeActivity;->mAttachmentsView:Lcom/android/mail/compose/AttachmentsView;

    iget-object v6, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    invoke-virtual {v5, v6, v0}, Lcom/android/mail/compose/AttachmentsView;->addAttachment(Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Attachment;)J
    :try_end_0
    .catch Lcom/android/mail/compose/AttachmentsView$AttachmentFailureException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v5

    add-long/2addr v2, v5

    move-object v0, v1

    move-wide v7, v2

    move-wide v1, v7

    :goto_1
    move-wide v7, v1

    move-wide v2, v7

    move-object v1, v0

    .line 1245
    goto :goto_0

    .line 1243
    :catch_0
    move-exception v0

    move-wide v1, v2

    .line 1244
    goto :goto_1

    .line 1247
    :cond_0
    if-eqz v1, :cond_1

    .line 1248
    sget-object v0, Lcom/android/mail/compose/ComposeActivity;->LOG_TAG:Ljava/lang/String;

    const-string v4, "Error adding attachment"

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v0, v1, v4, v5}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1249
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    const/4 v4, 0x1

    if-le v0, v4, :cond_2

    .line 1250
    const v0, 0x7f0c002e

    invoke-direct {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->showAttachmentTooBigToast(I)V

    .line 1255
    :cond_1
    :goto_2
    return-wide v2

    .line 1252
    :cond_2
    invoke-virtual {v1}, Lcom/android/mail/compose/AttachmentsView$AttachmentFailureException;->getErrorRes()I

    move-result v0

    invoke-direct {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->showAttachmentTooBigToast(I)V

    goto :goto_2
.end method

.method protected addCcAddressesToList(Ljava/util/List;Ljava/util/List;Lcom/android/ex/chips/RecipientEditTextView;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<[",
            "Landroid/text/util/Rfc822Token;",
            ">;",
            "Ljava/util/List",
            "<[",
            "Landroid/text/util/Rfc822Token;",
            ">;",
            "Lcom/android/ex/chips/RecipientEditTextView;",
            ")V"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 1470
    if-nez p2, :cond_1

    .line 1471
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroid/text/util/Rfc822Token;

    move v1, v2

    .line 1472
    :goto_0
    array-length v4, v0

    if-ge v1, v4, :cond_0

    .line 1473
    aget-object v4, v0, v1

    invoke-virtual {v4}, Landroid/text/util/Rfc822Token;->toString()Ljava/lang/String;

    move-result-object v4

    .line 1474
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ", "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p3, v4}, Lcom/android/ex/chips/RecipientEditTextView;->append(Ljava/lang/CharSequence;)V

    .line 1472
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 1478
    :cond_1
    invoke-direct {p0, p2}, Lcom/android/mail/compose/ComposeActivity;->convertToHashSet(Ljava/util/List;)Ljava/util/HashSet;

    move-result-object v3

    .line 1479
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_2
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroid/text/util/Rfc822Token;

    move v1, v2

    .line 1480
    :goto_1
    array-length v5, v0

    if-ge v1, v5, :cond_2

    .line 1481
    aget-object v5, v0, v1

    invoke-virtual {v5}, Landroid/text/util/Rfc822Token;->toString()Ljava/lang/String;

    move-result-object v5

    .line 1483
    aget-object v6, v0, v1

    invoke-virtual {v6}, Landroid/text/util/Rfc822Token;->getAddress()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3, v6}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_3

    .line 1485
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ", "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p3, v5}, Lcom/android/ex/chips/RecipientEditTextView;->append(Ljava/lang/CharSequence;)V

    .line 1480
    :cond_3
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 1490
    :cond_4
    return-void
.end method

.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 1
    .param p1, "s"    # Landroid/text/Editable;

    .prologue
    .line 2722
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/mail/compose/ComposeActivity;->mTextChanged:Z

    .line 2723
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->updateSaveUi()V

    .line 2724
    return-void
.end method

.method public appendToBody(Ljava/lang/CharSequence;Z)V
    .locals 2
    .param p1, "text"    # Ljava/lang/CharSequence;
    .param p2, "withSignature"    # Z

    .prologue
    .line 2551
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mBodyView:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getEditableText()Landroid/text/Editable;

    move-result-object v0

    .line 2552
    .local v0, "bodyText":Landroid/text/Editable;
    if-eqz v0, :cond_0

    invoke-interface {v0}, Landroid/text/Editable;->length()I

    move-result v1

    if-lez v1, :cond_0

    .line 2553
    invoke-interface {v0, p1}, Landroid/text/Editable;->append(Ljava/lang/CharSequence;)Landroid/text/Editable;

    .line 2557
    :goto_0
    return-void

    .line 2555
    :cond_0
    invoke-virtual {p0, p1, p2}, Lcom/android/mail/compose/ComposeActivity;->setBody(Ljava/lang/CharSequence;Z)V

    goto :goto_0
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "count"    # I
    .param p4, "after"    # I

    .prologue
    .line 2729
    return-void
.end method

.method public checkInvalidEmails([Ljava/lang/String;Ljava/util/List;)V
    .locals 5
    .param p1, "to"    # [Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1943
    .local p2, "wrongEmailsOut":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v4, p0, Lcom/android/mail/compose/ComposeActivity;->mValidator:Lcom/android/common/Rfc822Validator;

    if-nez v4, :cond_1

    .line 1951
    :cond_0
    return-void

    .line 1946
    :cond_1
    move-object v0, p1

    .local v0, "arr$":[Ljava/lang/String;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_0

    aget-object v1, v0, v2

    .line 1947
    .local v1, "email":Ljava/lang/String;
    iget-object v4, p0, Lcom/android/mail/compose/ComposeActivity;->mValidator:Lcom/android/common/Rfc822Validator;

    invoke-virtual {v4, v1}, Lcom/android/common/Rfc822Validator;->isValid(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_2

    .line 1948
    invoke-interface {p2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1946
    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method protected decodeEmailInUri(Ljava/lang/String;)Ljava/lang/String;
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/UnsupportedEncodingException;
        }
    .end annotation

    .prologue
    const/4 v3, 0x2

    const/4 v4, 0x0

    .line 1160
    const-string v0, "+"

    const-string v1, "%2B"

    invoke-virtual {p1, v0, v1}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 1162
    :try_start_0
    const-string v1, "UTF-8"

    invoke-static {v0, v1}, Ljava/net/URLDecoder;->decode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 1169
    :goto_0
    return-object v0

    .line 1163
    :catch_0
    move-exception v0

    .line 1164
    sget-object v1, Lcom/android/mail/compose/ComposeActivity;->LOG_TAG:Ljava/lang/String;

    invoke-static {v1, v3}, Lcom/android/mail/utils/LogUtils;->isLoggable(Ljava/lang/String;I)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1165
    sget-object v1, Lcom/android/mail/compose/ComposeActivity;->LOG_TAG:Ljava/lang/String;

    const-string v2, "%s while decoding \'%s\'"

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/IllegalArgumentException;->getMessage()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v3, v4

    const/4 v0, 0x1

    aput-object p1, v3, v0

    invoke-static {v1, v2, v3}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1169
    :goto_1
    const/4 v0, 0x0

    goto :goto_0

    .line 1167
    :cond_0
    sget-object v1, Lcom/android/mail/compose/ComposeActivity;->LOG_TAG:Ljava/lang/String;

    const-string v2, "Exception  while decoding mailto address"

    new-array v3, v4, [Ljava/lang/Object;

    invoke-static {v1, v0, v2, v3}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_1
.end method

.method public enableSave(Z)V
    .locals 1
    .param p1, "enabled"    # Z

    .prologue
    .line 2617
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mSave:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    .line 2618
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mSave:Landroid/view/MenuItem;

    invoke-interface {v0, p1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 2620
    :cond_0
    return-void
.end method

.method public enableSend(Z)V
    .locals 1
    .param p1, "enabled"    # Z

    .prologue
    .line 2623
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mSend:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    .line 2624
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mSend:Landroid/view/MenuItem;

    invoke-interface {v0, p1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 2626
    :cond_0
    return-void
.end method

.method public focusBody()V
    .locals 4

    .prologue
    .line 531
    iget-object v2, p0, Lcom/android/mail/compose/ComposeActivity;->mBodyView:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->requestFocus()Z

    .line 532
    iget-object v2, p0, Lcom/android/mail/compose/ComposeActivity;->mBodyView:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-interface {v2}, Landroid/text/Editable;->length()I

    move-result v0

    .line 534
    .local v0, "length":I
    iget-object v2, p0, Lcom/android/mail/compose/ComposeActivity;->mSignature:Ljava/lang/String;

    iget-object v3, p0, Lcom/android/mail/compose/ComposeActivity;->mBodyView:Landroid/widget/EditText;

    invoke-virtual {v3}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v2, v3}, Lcom/android/mail/compose/ComposeActivity;->getSignatureStartPosition(Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    .line 536
    .local v1, "signatureStartPos":I
    const/4 v2, -0x1

    if-le v1, v2, :cond_1

    .line 538
    iget-object v2, p0, Lcom/android/mail/compose/ComposeActivity;->mBodyView:Landroid/widget/EditText;

    invoke-virtual {v2, v1}, Landroid/widget/EditText;->setSelection(I)V

    .line 543
    :cond_0
    :goto_0
    return-void

    .line 539
    :cond_1
    if-ltz v0, :cond_0

    .line 541
    iget-object v2, p0, Lcom/android/mail/compose/ComposeActivity;->mBodyView:Landroid/widget/EditText;

    invoke-virtual {v2, v0}, Landroid/widget/EditText;->setSelection(I)V

    goto :goto_0
.end method

.method public getAddressesFromList(Lcom/android/ex/chips/RecipientEditTextView;)[Ljava/lang/String;
    .locals 5
    .param p1, "list"    # Lcom/android/ex/chips/RecipientEditTextView;

    .prologue
    .line 1925
    if-nez p1, :cond_1

    .line 1926
    const/4 v4, 0x0

    new-array v2, v4, [Ljava/lang/String;

    .line 1934
    :cond_0
    return-object v2

    .line 1928
    :cond_1
    invoke-virtual {p1}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v4

    invoke-static {v4}, Landroid/text/util/Rfc822Tokenizer;->tokenize(Ljava/lang/CharSequence;)[Landroid/text/util/Rfc822Token;

    move-result-object v3

    .line 1929
    .local v3, "tokens":[Landroid/text/util/Rfc822Token;
    array-length v0, v3

    .line 1930
    .local v0, "count":I
    new-array v2, v0, [Ljava/lang/String;

    .line 1931
    .local v2, "result":[Ljava/lang/String;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_0

    .line 1932
    aget-object v4, v3, v1

    invoke-virtual {v4}, Landroid/text/util/Rfc822Token;->toString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v1

    .line 1931
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method protected getAttachments()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/android/mail/providers/Attachment;",
            ">;"
        }
    .end annotation

    .prologue
    .line 2821
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAttachmentsView:Lcom/android/mail/compose/AttachmentsView;

    invoke-virtual {v0}, Lcom/android/mail/compose/AttachmentsView;->getAttachments()Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method public getBccAddresses()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 1921
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mBcc:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->getAddressesFromList(Lcom/android/ex/chips/RecipientEditTextView;)[Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getCcAddresses()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 1914
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mCc:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->getAddressesFromList(Lcom/android/ex/chips/RecipientEditTextView;)[Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getFromAccount()Lcom/android/mail/providers/Account;
    .locals 1

    .prologue
    .line 933
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mReplyFromAccount:Lcom/android/mail/providers/ReplyFromAccount;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mReplyFromAccount:Lcom/android/mail/providers/ReplyFromAccount;

    iget-object v0, v0, Lcom/android/mail/providers/ReplyFromAccount;->account:Lcom/android/mail/providers/Account;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mReplyFromAccount:Lcom/android/mail/providers/ReplyFromAccount;

    iget-object v0, v0, Lcom/android/mail/providers/ReplyFromAccount;->account:Lcom/android/mail/providers/Account;

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    goto :goto_0
.end method

.method protected getMatchingRecipient(Lcom/android/mail/providers/Account;Ljava/util/List;)Lcom/android/mail/providers/ReplyFromAccount;
    .locals 10
    .param p1, "account"    # Lcom/android/mail/providers/Account;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/android/mail/providers/Account;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/android/mail/providers/ReplyFromAccount;"
        }
    .end annotation

    .prologue
    .line 831
    .local p2, "sentTo":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v6, 0x0

    .line 833
    .local v6, "matchingReplyFrom":Lcom/android/mail/providers/ReplyFromAccount;
    new-instance v7, Ljava/util/HashSet;

    invoke-direct {v7}, Ljava/util/HashSet;-><init>()V

    .line 834
    .local v7, "recipientsMap":Ljava/util/HashSet;, "Ljava/util/HashSet<Ljava/lang/String;>;"
    invoke-interface {p2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 835
    .local v0, "address":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/util/Rfc822Tokenizer;->tokenize(Ljava/lang/CharSequence;)[Landroid/text/util/Rfc822Token;

    move-result-object v8

    .line 836
    .local v8, "tokens":[Landroid/text/util/Rfc822Token;
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    array-length v9, v8

    if-ge v3, v9, :cond_0

    .line 837
    aget-object v9, v8, v3

    invoke-virtual {v9}, Landroid/text/util/Rfc822Token;->getAddress()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v9}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 836
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 841
    .end local v0    # "address":Ljava/lang/String;
    .end local v3    # "i":I
    .end local v8    # "tokens":[Landroid/text/util/Rfc822Token;
    :cond_1
    const/4 v5, 0x0

    .line 843
    .local v5, "matchingAddressCount":I
    invoke-virtual {p1}, Lcom/android/mail/providers/Account;->getReplyFroms()Ljava/util/List;

    move-result-object v1

    .line 844
    .local v1, "customFroms":Ljava/util/List;, "Ljava/util/List<Lcom/android/mail/providers/ReplyFromAccount;>;"
    if-eqz v1, :cond_3

    .line 845
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_2
    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_3

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/android/mail/providers/ReplyFromAccount;

    .line 846
    .local v2, "entry":Lcom/android/mail/providers/ReplyFromAccount;
    iget-object v9, v2, Lcom/android/mail/providers/ReplyFromAccount;->address:Ljava/lang/String;

    invoke-virtual {v7, v9}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_2

    .line 847
    move-object v6, v2

    .line 848
    add-int/lit8 v5, v5, 0x1

    goto :goto_1

    .line 852
    .end local v2    # "entry":Lcom/android/mail/providers/ReplyFromAccount;
    :cond_3
    const/4 v9, 0x1

    if-le v5, v9, :cond_4

    .line 853
    invoke-direct {p0, p1}, Lcom/android/mail/compose/ComposeActivity;->getDefaultReplyFromAccount(Lcom/android/mail/providers/Account;)Lcom/android/mail/providers/ReplyFromAccount;

    move-result-object v6

    .line 855
    :cond_4
    return-object v6
.end method

.method public getReplyFromAccount(Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Message;)Lcom/android/mail/providers/ReplyFromAccount;
    .locals 2
    .param p1, "account"    # Lcom/android/mail/providers/Account;
    .param p2, "refMessage"    # Lcom/android/mail/providers/Message;

    .prologue
    .line 811
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mCachedSettings:Lcom/android/mail/providers/Settings;

    iget-boolean v1, v1, Lcom/android/mail/providers/Settings;->forceReplyFromDefault:Z

    if-eqz v1, :cond_0

    .line 812
    invoke-direct {p0, p1}, Lcom/android/mail/compose/ComposeActivity;->getDefaultReplyFromAccount(Lcom/android/mail/providers/Account;)Lcom/android/mail/providers/ReplyFromAccount;

    move-result-object v1

    .line 820
    :goto_0
    return-object v1

    .line 817
    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 818
    .local v0, "allRecipients":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-virtual {p2}, Lcom/android/mail/providers/Message;->getToAddresses()[Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 819
    invoke-virtual {p2}, Lcom/android/mail/providers/Message;->getCcAddresses()[Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 820
    invoke-virtual {p0, p1, v0}, Lcom/android/mail/compose/ComposeActivity;->getMatchingRecipient(Lcom/android/mail/providers/Account;Ljava/util/List;)Lcom/android/mail/providers/ReplyFromAccount;

    move-result-object v1

    goto :goto_0
.end method

.method protected getSignatureStartPosition(Ljava/lang/String;Ljava/lang/String;)I
    .locals 7
    .param p1, "signature"    # Ljava/lang/String;
    .param p2, "bodyText"    # Ljava/lang/String;

    .prologue
    .line 2022
    const/4 v4, -0x1

    .line 2024
    .local v4, "startPos":I
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_0

    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-eqz v6, :cond_1

    :cond_0
    move v5, v4

    .line 2042
    .end local v4    # "startPos":I
    .local v5, "startPos":I
    :goto_0
    return v5

    .line 2028
    .end local v5    # "startPos":I
    .restart local v4    # "startPos":I
    :cond_1
    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v0

    .line 2029
    .local v0, "bodyLength":I
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v3

    .line 2030
    .local v3, "signatureLength":I
    invoke-direct {p0, p1}, Lcom/android/mail/compose/ComposeActivity;->convertToPrintableSignature(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 2031
    .local v2, "printableVersion":Ljava/lang/String;
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v1

    .line 2033
    .local v1, "printableLength":I
    if-lt v0, v1, :cond_3

    sub-int v6, v0, v1

    invoke-virtual {p2, v6}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 2036
    sub-int v4, v0, v1

    :cond_2
    :goto_1
    move v5, v4

    .line 2042
    .end local v4    # "startPos":I
    .restart local v5    # "startPos":I
    goto :goto_0

    .line 2037
    .end local v5    # "startPos":I
    .restart local v4    # "startPos":I
    :cond_3
    if-lt v0, v3, :cond_2

    sub-int v6, v0, v3

    invoke-virtual {p2, v6}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 2040
    sub-int v4, v0, v3

    goto :goto_1
.end method

.method public getToAddresses()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 1907
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mTo:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->getAddressesFromList(Lcom/android/ex/chips/RecipientEditTextView;)[Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected initAttachments(Lcom/android/mail/providers/Message;)V
    .locals 1
    .param p1, "refMessage"    # Lcom/android/mail/providers/Message;

    .prologue
    .line 1234
    invoke-virtual {p1}, Lcom/android/mail/providers/Message;->getAttachments()Ljava/util/List;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->addAttachments(Ljava/util/List;)J

    .line 1235
    return-void
.end method

.method public initFromExtras(Landroid/content/Intent;)V
    .locals 8

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x1

    .line 1093
    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v0

    .line 1094
    if-eqz v0, :cond_0

    .line 1095
    const-string v1, "mailto"

    invoke-virtual {v0}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_6

    .line 1096
    invoke-virtual {v0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->initFromMailTo(Ljava/lang/String;)V

    .line 1108
    :cond_0
    :goto_0
    const-string v0, "android.intent.extra.EMAIL"

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getStringArrayExtra(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 1109
    if-eqz v0, :cond_1

    .line 1110
    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->addToAddresses(Ljava/util/Collection;)V

    .line 1112
    :cond_1
    const-string v0, "android.intent.extra.CC"

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getStringArrayExtra(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 1113
    if-eqz v0, :cond_2

    .line 1114
    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    invoke-direct {p0, v0, v7}, Lcom/android/mail/compose/ComposeActivity;->addCcAddresses(Ljava/util/Collection;Ljava/util/Collection;)V

    .line 1116
    :cond_2
    const-string v0, "android.intent.extra.BCC"

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getStringArrayExtra(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 1117
    if-eqz v0, :cond_3

    .line 1118
    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->addBccAddresses(Ljava/util/Collection;)V

    .line 1121
    :cond_3
    const-string v0, "android.intent.extra.SUBJECT"

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1122
    if-eqz v0, :cond_4

    .line 1123
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mSubject:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1126
    :cond_4
    sget-object v1, Lcom/android/mail/compose/ComposeActivity;->ALL_EXTRAS:[Ljava/lang/String;

    array-length v2, v1

    const/4 v0, 0x0

    :goto_1
    if-ge v0, v2, :cond_b

    aget-object v3, v1, v0

    .line 1127
    invoke-virtual {p1, v3}, Landroid/content/Intent;->hasExtra(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_5

    .line 1128
    invoke-virtual {p1, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 1129
    const-string v5, "to"

    invoke-virtual {v5, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_7

    .line 1130
    const-string v3, ","

    invoke-static {v4, v3}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v3

    invoke-direct {p0, v3}, Lcom/android/mail/compose/ComposeActivity;->addToAddresses(Ljava/util/Collection;)V

    .line 1126
    :cond_5
    :goto_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 1098
    :cond_6
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v1, v1, Lcom/android/mail/providers/Account;->composeIntentUri:Landroid/net/Uri;

    invoke-virtual {v1, v0}, Landroid/net/Uri;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 1099
    invoke-virtual {v0}, Landroid/net/Uri;->getSchemeSpecificPart()Ljava/lang/String;

    move-result-object v0

    .line 1100
    if-eqz v0, :cond_0

    .line 1101
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mTo:Lcom/android/ex/chips/RecipientEditTextView;

    const-string v2, ""

    invoke-virtual {v1, v2}, Lcom/android/ex/chips/RecipientEditTextView;->setText(Ljava/lang/CharSequence;)V

    .line 1102
    const-string v1, ","

    invoke-static {v0, v1}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->addToAddresses(Ljava/util/Collection;)V

    goto/16 :goto_0

    .line 1131
    :cond_7
    const-string v5, "cc"

    invoke-virtual {v5, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_8

    .line 1132
    const-string v3, ","

    invoke-static {v4, v3}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v3

    invoke-direct {p0, v3, v7}, Lcom/android/mail/compose/ComposeActivity;->addCcAddresses(Ljava/util/Collection;Ljava/util/Collection;)V

    goto :goto_2

    .line 1133
    :cond_8
    const-string v5, "bcc"

    invoke-virtual {v5, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_9

    .line 1134
    const-string v3, ","

    invoke-static {v4, v3}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v3

    invoke-direct {p0, v3}, Lcom/android/mail/compose/ComposeActivity;->addBccAddresses(Ljava/util/Collection;)V

    goto :goto_2

    .line 1135
    :cond_9
    const-string v5, "subject"

    invoke-virtual {v5, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_a

    .line 1136
    iget-object v3, p0, Lcom/android/mail/compose/ComposeActivity;->mSubject:Landroid/widget/TextView;

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_2

    .line 1137
    :cond_a
    const-string v5, "body"

    invoke-virtual {v5, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5

    .line 1138
    invoke-virtual {p0, v4, v6}, Lcom/android/mail/compose/ComposeActivity;->setBody(Ljava/lang/CharSequence;Z)V

    goto :goto_2

    .line 1143
    :cond_b
    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 1144
    if-eqz v0, :cond_c

    .line 1145
    const-string v1, "android.intent.extra.TEXT"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getCharSequence(Ljava/lang/String;)Ljava/lang/CharSequence;

    move-result-object v0

    .line 1146
    if-eqz v0, :cond_c

    .line 1147
    invoke-virtual {p0, v0, v6}, Lcom/android/mail/compose/ComposeActivity;->setBody(Ljava/lang/CharSequence;Z)V

    .line 1150
    :cond_c
    return-void
.end method

.method public initFromMailTo(Ljava/lang/String;)V
    .locals 9

    .prologue
    const/4 v8, 0x2

    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 1180
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "foo://"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 1181
    const-string v0, "?"

    invoke-virtual {p1, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    .line 1182
    const-string v2, "mailto"

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    add-int/lit8 v2, v2, 0x1

    .line 1186
    const/4 v3, -0x1

    if-ne v0, v3, :cond_3

    .line 1187
    :try_start_0
    invoke-virtual {p1, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->decodeEmailInUri(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1191
    :goto_0
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 1192
    const-string v2, ","

    invoke-static {v0, v2}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->addToAddresses(Ljava/util/Collection;)V
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1202
    :cond_0
    :goto_1
    const-string v0, "cc"

    invoke-virtual {v1, v0}, Landroid/net/Uri;->getQueryParameters(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 1203
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    new-array v2, v2, [Ljava/lang/String;

    invoke-interface {v0, v2}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    const/4 v2, 0x0

    invoke-direct {p0, v0, v2}, Lcom/android/mail/compose/ComposeActivity;->addCcAddresses(Ljava/util/Collection;Ljava/util/Collection;)V

    .line 1205
    const-string v0, "to"

    invoke-virtual {v1, v0}, Landroid/net/Uri;->getQueryParameters(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 1206
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    new-array v2, v2, [Ljava/lang/String;

    invoke-interface {v0, v2}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->addToAddresses(Ljava/util/Collection;)V

    .line 1208
    const-string v0, "bcc"

    invoke-virtual {v1, v0}, Landroid/net/Uri;->getQueryParameters(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 1209
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    new-array v2, v2, [Ljava/lang/String;

    invoke-interface {v0, v2}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->addBccAddresses(Ljava/util/Collection;)V

    .line 1211
    const-string v0, "subject"

    invoke-virtual {v1, v0}, Landroid/net/Uri;->getQueryParameters(Ljava/lang/String;)Ljava/util/List;

    move-result-object v2

    .line 1212
    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_1

    .line 1214
    :try_start_1
    iget-object v3, p0, Lcom/android/mail/compose/ComposeActivity;->mSubject:Landroid/widget/TextView;

    const/4 v0, 0x0

    invoke-interface {v2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    const-string v4, "UTF-8"

    invoke-static {v0, v4}, Ljava/net/URLDecoder;->decode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_1
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_1 .. :try_end_1} :catch_1

    .line 1221
    :cond_1
    :goto_2
    const-string v0, "body"

    invoke-virtual {v1, v0}, Landroid/net/Uri;->getQueryParameters(Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    .line 1222
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_2

    .line 1224
    const/4 v0, 0x0

    :try_start_2
    invoke-interface {v1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    const-string v2, "UTF-8"

    invoke-static {v0, v2}, Ljava/net/URLDecoder;->decode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const/4 v2, 0x1

    invoke-virtual {p0, v0, v2}, Lcom/android/mail/compose/ComposeActivity;->setBody(Ljava/lang/CharSequence;Z)V
    :try_end_2
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_2 .. :try_end_2} :catch_2

    .line 1230
    :cond_2
    :goto_3
    return-void

    .line 1189
    :cond_3
    :try_start_3
    invoke-virtual {p1, v2, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->decodeEmailInUri(Ljava/lang/String;)Ljava/lang/String;
    :try_end_3
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_3 .. :try_end_3} :catch_0

    move-result-object v0

    goto/16 :goto_0

    .line 1194
    :catch_0
    move-exception v0

    .line 1195
    sget-object v2, Lcom/android/mail/compose/ComposeActivity;->LOG_TAG:Ljava/lang/String;

    invoke-static {v2, v8}, Lcom/android/mail/utils/LogUtils;->isLoggable(Ljava/lang/String;I)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 1196
    sget-object v2, Lcom/android/mail/compose/ComposeActivity;->LOG_TAG:Ljava/lang/String;

    const-string v3, "%s while decoding \'%s\'"

    new-array v4, v8, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/io/UnsupportedEncodingException;->getMessage()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v4, v6

    aput-object p1, v4, v7

    invoke-static {v2, v3, v4}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto/16 :goto_1

    .line 1198
    :cond_4
    sget-object v2, Lcom/android/mail/compose/ComposeActivity;->LOG_TAG:Ljava/lang/String;

    const-string v3, "Exception  while decoding mailto address"

    new-array v4, v6, [Ljava/lang/Object;

    invoke-static {v2, v0, v3, v4}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    goto/16 :goto_1

    .line 1215
    :catch_1
    move-exception v0

    .line 1216
    sget-object v3, Lcom/android/mail/compose/ComposeActivity;->LOG_TAG:Ljava/lang/String;

    const-string v4, "%s while decoding subject \'%s\'"

    new-array v5, v8, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/io/UnsupportedEncodingException;->getMessage()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v5, v6

    aput-object v2, v5, v7

    invoke-static {v3, v4, v5}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_2

    .line 1226
    :catch_2
    move-exception v0

    .line 1227
    sget-object v2, Lcom/android/mail/compose/ComposeActivity;->LOG_TAG:Ljava/lang/String;

    const-string v3, "%s while decoding body \'%s\'"

    new-array v4, v8, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/io/UnsupportedEncodingException;->getMessage()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v4, v6

    aput-object v1, v4, v7

    invoke-static {v2, v3, v4}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_3
.end method

.method initRecipientsFromRefMessage(Ljava/lang/String;Lcom/android/mail/providers/Message;I)V
    .locals 1
    .param p1, "recipientAddress"    # Ljava/lang/String;
    .param p2, "refMessage"    # Lcom/android/mail/providers/Message;
    .param p3, "action"    # I

    .prologue
    .line 1408
    const/4 v0, 0x2

    if-ne p3, v0, :cond_0

    .line 1412
    :goto_0
    return-void

    .line 1411
    :cond_0
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v0, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-virtual {p0, v0, p2, p3}, Lcom/android/mail/compose/ComposeActivity;->initReplyRecipients(Ljava/lang/String;Lcom/android/mail/providers/Message;I)V

    goto :goto_0
.end method

.method initReplyRecipients(Ljava/lang/String;Lcom/android/mail/providers/Message;I)V
    .locals 8
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "refMessage"    # Lcom/android/mail/providers/Message;
    .param p3, "action"    # I

    .prologue
    .line 1418
    invoke-static {p1}, Lcom/android/mail/providers/Address;->getEmailAddress(Ljava/lang/String;)Lcom/android/mail/providers/Address;

    move-result-object v0

    invoke-virtual {v0}, Lcom/android/mail/providers/Address;->getAddress()Ljava/lang/String;

    move-result-object v2

    .line 1419
    .local v2, "accountEmail":Ljava/lang/String;
    invoke-virtual {p2}, Lcom/android/mail/providers/Message;->getToAddresses()[Ljava/lang/String;

    move-result-object v5

    .line 1420
    .local v5, "sentToAddresses":[Ljava/lang/String;
    iget-object v4, p2, Lcom/android/mail/providers/Message;->replyTo:Ljava/lang/String;

    .line 1427
    .local v4, "replytoAddress":Ljava/lang/String;
    if-nez p3, :cond_1

    .line 1428
    iget-object v3, p2, Lcom/android/mail/providers/Message;->from:Ljava/lang/String;

    move-object v0, p0

    move-object v1, p1

    invoke-virtual/range {v0 .. v5}, Lcom/android/mail/compose/ComposeActivity;->initToRecipients(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Ljava/util/Collection;

    move-result-object v7

    .line 1430
    .local v7, "toAddresses":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    invoke-direct {p0, v7}, Lcom/android/mail/compose/ComposeActivity;->addToAddresses(Ljava/util/Collection;)V

    .line 1440
    .end local v7    # "toAddresses":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    :cond_0
    :goto_0
    return-void

    .line 1431
    :cond_1
    const/4 v0, 0x1

    if-ne p3, v0, :cond_0

    .line 1432
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v6

    .line 1433
    .local v6, "ccAddresses":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    iget-object v3, p2, Lcom/android/mail/providers/Message;->from:Ljava/lang/String;

    move-object v0, p0

    move-object v1, p1

    invoke-virtual/range {v0 .. v5}, Lcom/android/mail/compose/ComposeActivity;->initToRecipients(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Ljava/util/Collection;

    move-result-object v7

    .line 1435
    .restart local v7    # "toAddresses":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    invoke-direct {p0, v7}, Lcom/android/mail/compose/ComposeActivity;->addToAddresses(Ljava/util/Collection;)V

    .line 1436
    invoke-direct {p0, v2, v6, v5}, Lcom/android/mail/compose/ComposeActivity;->addRecipients(Ljava/lang/String;Ljava/util/Set;[Ljava/lang/String;)V

    .line 1437
    invoke-virtual {p2}, Lcom/android/mail/providers/Message;->getCcAddresses()[Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v2, v6, v0}, Lcom/android/mail/compose/ComposeActivity;->addRecipients(Ljava/lang/String;Ljava/util/Set;[Ljava/lang/String;)V

    .line 1438
    invoke-direct {p0, v6, v7}, Lcom/android/mail/compose/ComposeActivity;->addCcAddresses(Ljava/util/Collection;Ljava/util/Collection;)V

    goto :goto_0
.end method

.method protected initToRecipients(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Ljava/util/Collection;
    .locals 2
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "accountEmail"    # Ljava/lang/String;
    .param p3, "fullSenderAddress"    # Ljava/lang/String;
    .param p4, "replyToAddress"    # Ljava/lang/String;
    .param p5, "inToAddresses"    # [Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "[",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1539
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v0

    .line 1540
    .local v0, "toAddresses":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-static {p4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 1541
    invoke-interface {v0, p4}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 1553
    :goto_0
    return-object v0

    .line 1543
    :cond_0
    invoke-virtual {p0, p1, p3}, Lcom/android/mail/compose/ComposeActivity;->recipientMatchesThisAccount(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 1544
    invoke-interface {v0, p3}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 1550
    :cond_1
    invoke-static {p5}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    goto :goto_0
.end method

.method public isBlank()Z
    .locals 2

    .prologue
    .line 2012
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mSubject:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/CharSequence;->length()I

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mBodyView:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-interface {v0}, Landroid/text/Editable;->length()I

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mSignature:Ljava/lang/String;

    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mBodyView:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/android/mail/compose/ComposeActivity;->getSignatureStartPosition(Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mTo:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-virtual {v0}, Lcom/android/ex/chips/RecipientEditTextView;->length()I

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mCc:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-virtual {v0}, Lcom/android/ex/chips/RecipientEditTextView;->length()I

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mBcc:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-virtual {v0}, Lcom/android/ex/chips/RecipientEditTextView;->length()I

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAttachmentsView:Lcom/android/mail/compose/AttachmentsView;

    invoke-virtual {v0}, Lcom/android/mail/compose/AttachmentsView;->getAttachments()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-nez v0, :cond_1

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isBodyEmpty()Z
    .locals 1

    .prologue
    .line 2183
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mQuotedTextView:Lcom/android/mail/compose/QuotedTextView;

    invoke-virtual {v0}, Lcom/android/mail/compose/QuotedTextView;->isTextIncluded()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isSubjectEmpty()Z
    .locals 1

    .prologue
    .line 2194
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mSubject:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->getTrimmedLength(Ljava/lang/CharSequence;)I

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onAccountChanged()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 2601
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mFromSpinner:Lcom/android/mail/compose/FromAddressSpinner;

    invoke-virtual {v0}, Lcom/android/mail/compose/FromAddressSpinner;->getCurrentAccount()Lcom/android/mail/providers/ReplyFromAccount;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mReplyFromAccount:Lcom/android/mail/providers/ReplyFromAccount;

    .line 2602
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mReplyFromAccount:Lcom/android/mail/providers/ReplyFromAccount;

    iget-object v1, v1, Lcom/android/mail/providers/ReplyFromAccount;->account:Lcom/android/mail/providers/Account;

    invoke-virtual {v0, v1}, Lcom/android/mail/providers/Account;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 2603
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mReplyFromAccount:Lcom/android/mail/providers/ReplyFromAccount;

    iget-object v0, v0, Lcom/android/mail/providers/ReplyFromAccount;->account:Lcom/android/mail/providers/Account;

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->setAccount(Lcom/android/mail/providers/Account;)V

    .line 2608
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->isBlank()Z

    move-result v0

    if-nez v0, :cond_0

    .line 2609
    invoke-virtual {p0, v2}, Lcom/android/mail/compose/ComposeActivity;->enableSave(Z)V

    .line 2611
    :cond_0
    iput-boolean v2, p0, Lcom/android/mail/compose/ComposeActivity;->mReplyFromChanged:Z

    .line 2612
    invoke-direct {p0}, Lcom/android/mail/compose/ComposeActivity;->initRecipients()V

    .line 2614
    :cond_1
    return-void
.end method

.method protected final onActivityResult(IILandroid/content/Intent;)V
    .locals 4
    .param p1, "request"    # I
    .param p2, "result"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x1

    const/4 v1, -0x1

    .line 574
    if-ne p1, v2, :cond_1

    if-ne p2, v1, :cond_1

    .line 575
    invoke-virtual {p0, p3}, Lcom/android/mail/compose/ComposeActivity;->addAttachmentAndUpdateView(Landroid/content/Intent;)V

    .line 576
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAddingAttachment:Z

    .line 588
    :cond_0
    :goto_0
    return-void

    .line 577
    :cond_1
    const/4 v0, 0x2

    if-ne p1, v0, :cond_0

    .line 579
    if-eq p2, v1, :cond_2

    .line 580
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->finish()V

    goto :goto_0

    .line 584
    :cond_2
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v0

    invoke-virtual {v0, v2, v3, p0}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    .line 585
    invoke-direct {p0, v3}, Lcom/android/mail/compose/ComposeActivity;->showWaitFragment(Lcom/android/mail/providers/Account;)V

    goto :goto_0
.end method

.method public onAttachmentAdded()V
    .locals 2

    .prologue
    .line 2713
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mQuotedTextView:Lcom/android/mail/compose/QuotedTextView;

    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAttachmentsView:Lcom/android/mail/compose/AttachmentsView;

    invoke-virtual {v0}, Lcom/android/mail/compose/AttachmentsView;->getAttachments()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {v1, v0}, Lcom/android/mail/compose/QuotedTextView;->setUpperDividerVisible(Z)V

    .line 2714
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAttachmentsView:Lcom/android/mail/compose/AttachmentsView;

    invoke-virtual {v0}, Lcom/android/mail/compose/AttachmentsView;->focusLastAttachment()V

    .line 2715
    return-void

    .line 2713
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onAttachmentDeleted()V
    .locals 3

    .prologue
    const/4 v0, 0x1

    .line 2704
    iput-boolean v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAttachmentsChanged:Z

    .line 2707
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mQuotedTextView:Lcom/android/mail/compose/QuotedTextView;

    iget-object v2, p0, Lcom/android/mail/compose/ComposeActivity;->mAttachmentsView:Lcom/android/mail/compose/AttachmentsView;

    invoke-virtual {v2}, Lcom/android/mail/compose/AttachmentsView;->getAttachments()Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-lez v2, :cond_0

    :goto_0
    invoke-virtual {v1, v0}, Lcom/android/mail/compose/QuotedTextView;->setUpperDividerVisible(Z)V

    .line 2708
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->updateSaveUi()V

    .line 2709
    return-void

    .line 2707
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onBackPressed()V
    .locals 1

    .prologue
    .line 1733
    invoke-direct {p0}, Lcom/android/mail/compose/ComposeActivity;->getWaitFragment()Lcom/android/mail/ui/WaitFragment;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1734
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->finish()V

    .line 1738
    :goto_0
    return-void

    .line 1736
    :cond_0
    invoke-super {p0}, Landroid/app/Activity;->onBackPressed()V

    goto :goto_0
.end method

.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    const/4 v0, 0x1

    .line 2634
    packed-switch p2, :pswitch_data_0

    .line 2646
    :goto_0
    return-void

    .line 2636
    :pswitch_0
    invoke-direct {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->doDiscardWithoutConfirmation(Z)V

    goto :goto_0

    .line 2641
    :pswitch_1
    invoke-virtual {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->enableSend(Z)V

    goto :goto_0

    .line 2634
    nop

    :pswitch_data_0
    .packed-switch -0x2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public onClick(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 1627
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    .line 1628
    sparse-switch v0, :sswitch_data_0

    .line 1641
    :goto_0
    return-void

    .line 1632
    :sswitch_0
    invoke-direct {p0}, Lcom/android/mail/compose/ComposeActivity;->showCcBccViews()V

    goto :goto_0

    .line 1635
    :sswitch_1
    const-string v0, "image/*"

    invoke-direct {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->doAttach(Ljava/lang/String;)V

    goto :goto_0

    .line 1638
    :sswitch_2
    const-string v0, "video/*"

    invoke-direct {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->doAttach(Ljava/lang/String;)V

    goto :goto_0

    .line 1628
    :sswitch_data_0
    .sparse-switch
        0x7f100048 -> :sswitch_0
        0x7f10004c -> :sswitch_1
        0x7f10011d -> :sswitch_2
    .end sparse-switch
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 304
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 305
    const v0, 0x7f040016

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->setContentView(I)V

    .line 306
    iput-object p1, p0, Lcom/android/mail/compose/ComposeActivity;->mSavedInstanceState:Landroid/os/Bundle;

    .line 307
    invoke-direct {p0}, Lcom/android/mail/compose/ComposeActivity;->checkValidAccounts()V

    .line 308
    return-void
.end method

.method public onCreateLoader(ILandroid/os/Bundle;)Landroid/content/Loader;
    .locals 7
    .param p1, "id"    # I
    .param p2, "args"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Landroid/os/Bundle;",
            ")",
            "Landroid/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    .line 2826
    packed-switch p1, :pswitch_data_0

    move-object v0, v4

    .line 2834
    :goto_0
    return-object v0

    .line 2828
    :pswitch_0
    new-instance v0, Landroid/content/CursorLoader;

    iget-object v2, p0, Lcom/android/mail/compose/ComposeActivity;->mRefMessageUri:Landroid/net/Uri;

    sget-object v3, Lcom/android/mail/providers/UIProvider;->MESSAGE_PROJECTION:[Ljava/lang/String;

    move-object v1, p0

    move-object v5, v4

    move-object v6, v4

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 2831
    :pswitch_1
    new-instance v0, Landroid/content/CursorLoader;

    invoke-static {}, Lcom/android/mail/providers/MailAppProvider;->getAccountsUri()Landroid/net/Uri;

    move-result-object v2

    sget-object v3, Lcom/android/mail/providers/UIProvider;->ACCOUNTS_PROJECTION:[Ljava/lang/String;

    move-object v1, p0

    move-object v5, v4

    move-object v6, v4

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 2826
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 6

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 1645
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreateOptionsMenu(Landroid/view/Menu;)Z

    .line 1647
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAccounts:[Lcom/android/mail/providers/Account;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAccounts:[Lcom/android/mail/providers/Account;

    array-length v0, v0

    if-nez v0, :cond_1

    .line 1664
    :cond_0
    :goto_0
    return v1

    .line 1650
    :cond_1
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v0

    .line 1651
    const/high16 v3, 0x7f120000

    invoke-virtual {v0, v3, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 1652
    const v0, 0x7f10011e

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mSave:Landroid/view/MenuItem;

    .line 1653
    const v0, 0x7f10011c

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mSend:Landroid/view/MenuItem;

    .line 1654
    const v0, 0x7f100122

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v3

    .line 1655
    const v0, 0x7f100121

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v4

    .line 1656
    if-eqz v3, :cond_2

    .line 1657
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    const v5, 0x8000

    invoke-virtual {v0, v5}, Lcom/android/mail/providers/Account;->supportsCapability(I)Z

    move-result v0

    if-eqz v0, :cond_4

    move v0, v1

    :goto_1
    invoke-interface {v3, v0}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 1660
    :cond_2
    if-eqz v4, :cond_0

    .line 1661
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    const/high16 v3, 0x10000

    invoke-virtual {v0, v3}, Lcom/android/mail/providers/Account;->supportsCapability(I)Z

    move-result v0

    if-eqz v0, :cond_3

    move v2, v1

    :cond_3
    invoke-interface {v4, v2}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    goto :goto_0

    :cond_4
    move v0, v2

    .line 1657
    goto :goto_1
.end method

.method public onEditorAction(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "view"    # Landroid/widget/TextView;
    .param p2, "action"    # I
    .param p3, "keyEvent"    # Landroid/view/KeyEvent;

    .prologue
    .line 920
    const/4 v0, 0x6

    if-ne p2, v0, :cond_0

    .line 921
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->focusBody()V

    .line 922
    const/4 v0, 0x1

    .line 924
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onLoadFinished(Landroid/content/Loader;Landroid/database/Cursor;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;",
            "Landroid/database/Cursor;",
            ")V"
        }
    .end annotation

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    const/4 v0, 0x0

    .line 2839
    invoke-virtual {p1}, Landroid/content/Loader;->getId()I

    move-result v1

    .line 2840
    packed-switch v1, :pswitch_data_0

    .line 2891
    :cond_0
    :goto_0
    return-void

    .line 2842
    :pswitch_0
    if-eqz p2, :cond_1

    invoke-interface {p2}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 2843
    new-instance v1, Lcom/android/mail/providers/Message;

    invoke-direct {v1, p2}, Lcom/android/mail/providers/Message;-><init>(Landroid/database/Cursor;)V

    iput-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mRefMessage:Lcom/android/mail/providers/Message;

    .line 2845
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mRefMessage:Lcom/android/mail/providers/Message;

    iput-object v0, v1, Lcom/android/mail/providers/Message;->to:Ljava/lang/String;

    .line 2846
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mRefMessage:Lcom/android/mail/providers/Message;

    iput-object v0, v1, Lcom/android/mail/providers/Message;->from:Ljava/lang/String;

    .line 2847
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    .line 2848
    const-string v2, "action"

    const/4 v3, -0x1

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v2

    .line 2849
    iget-object v3, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v3, v3, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-direct {p0, v2, v3}, Lcom/android/mail/compose/ComposeActivity;->initFromRefMessage(ILjava/lang/String;)V

    .line 2850
    invoke-direct {p0, v2, v1, v0, v6}, Lcom/android/mail/compose/ComposeActivity;->finishSetup(ILandroid/content/Intent;Landroid/os/Bundle;Z)V

    .line 2851
    const/4 v0, 0x2

    if-eq v2, v0, :cond_0

    .line 2852
    const-string v0, "to"

    invoke-virtual {v1, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 2853
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 2854
    invoke-direct {p0}, Lcom/android/mail/compose/ComposeActivity;->clearChangeListeners()V

    .line 2855
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mTo:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-virtual {v1, v0}, Lcom/android/ex/chips/RecipientEditTextView;->append(Ljava/lang/CharSequence;)V

    .line 2856
    invoke-direct {p0}, Lcom/android/mail/compose/ComposeActivity;->initChangeListeners()V

    goto :goto_0

    .line 2860
    :cond_1
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->finish()V

    goto :goto_0

    .line 2864
    :pswitch_1
    if-eqz p2, :cond_0

    invoke-interface {p2}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 2867
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 2868
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 2870
    :cond_2
    new-instance v3, Lcom/android/mail/providers/Account;

    invoke-direct {v3, p2}, Lcom/android/mail/providers/Account;-><init>(Landroid/database/Cursor;)V

    .line 2871
    invoke-virtual {v3}, Lcom/android/mail/providers/Account;->isAccountReady()Z

    move-result v4

    if-eqz v4, :cond_3

    .line 2872
    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2874
    :cond_3
    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2875
    invoke-interface {p2}, Landroid/database/Cursor;->moveToNext()Z

    move-result v3

    if-nez v3, :cond_2

    .line 2876
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-lez v3, :cond_4

    .line 2877
    const v0, 0x7f100044

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/16 v3, 0x8

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 2878
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v0

    invoke-virtual {v0, v6}, Landroid/app/LoaderManager;->destroyLoader(I)V

    .line 2879
    const v0, 0x7f10003f

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v5}, Landroid/view/View;->setVisibility(I)V

    .line 2880
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v0

    new-array v0, v0, [Lcom/android/mail/providers/Account;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/android/mail/providers/Account;

    iput-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAccounts:[Lcom/android/mail/providers/Account;

    .line 2881
    invoke-direct {p0}, Lcom/android/mail/compose/ComposeActivity;->finishCreate()V

    .line 2882
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->invalidateOptionsMenu()V

    goto/16 :goto_0

    .line 2885
    :cond_4
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-lez v2, :cond_5

    invoke-virtual {v1, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Account;

    .line 2886
    :cond_5
    invoke-direct {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->showWaitFragment(Lcom/android/mail/providers/Account;)V

    goto/16 :goto_0

    .line 2840
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public bridge synthetic onLoadFinished(Landroid/content/Loader;Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Landroid/content/Loader;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 109
    check-cast p2, Landroid/database/Cursor;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/android/mail/compose/ComposeActivity;->onLoadFinished(Landroid/content/Loader;Landroid/database/Cursor;)V

    return-void
.end method

.method public onLoaderReset(Landroid/content/Loader;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 2920
    .local p1, "arg0":Landroid/content/Loader;, "Landroid/content/Loader<Landroid/database/Cursor;>;"
    return-void
.end method

.method public onNavigationItemSelected(IJ)Z
    .locals 7
    .param p1, "position"    # I
    .param p2, "itemId"    # J

    .prologue
    const/4 v5, 0x2

    const/4 v3, 0x0

    const/4 v4, 0x1

    .line 2453
    iget v0, p0, Lcom/android/mail/compose/ComposeActivity;->mComposeMode:I

    .line 2454
    .local v0, "initialComposeMode":I
    if-nez p1, :cond_5

    .line 2455
    iput v3, p0, Lcom/android/mail/compose/ComposeActivity;->mComposeMode:I

    .line 2461
    :cond_0
    :goto_0
    invoke-direct {p0}, Lcom/android/mail/compose/ComposeActivity;->clearChangeListeners()V

    .line 2462
    iget v5, p0, Lcom/android/mail/compose/ComposeActivity;->mComposeMode:I

    if-eq v0, v5, :cond_4

    .line 2463
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->resetMessageForModeChange()V

    .line 2464
    iget-object v5, p0, Lcom/android/mail/compose/ComposeActivity;->mDraft:Lcom/android/mail/providers/Message;

    if-nez v5, :cond_1

    iget-object v5, p0, Lcom/android/mail/compose/ComposeActivity;->mRefMessage:Lcom/android/mail/providers/Message;

    if-eqz v5, :cond_1

    .line 2465
    iget v5, p0, Lcom/android/mail/compose/ComposeActivity;->mComposeMode:I

    iget-object v6, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v6, v6, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-direct {p0, v5, v6}, Lcom/android/mail/compose/ComposeActivity;->setFieldsFromRefMessage(ILjava/lang/String;)V

    .line 2467
    :cond_1
    const/4 v2, 0x0

    .line 2468
    .local v2, "showCc":Z
    const/4 v1, 0x0

    .line 2469
    .local v1, "showBcc":Z
    iget-object v5, p0, Lcom/android/mail/compose/ComposeActivity;->mDraft:Lcom/android/mail/providers/Message;

    if-eqz v5, :cond_9

    .line 2472
    iget-object v5, p0, Lcom/android/mail/compose/ComposeActivity;->mDraft:Lcom/android/mail/providers/Message;

    iget-object v5, v5, Lcom/android/mail/providers/Message;->bcc:Ljava/lang/String;

    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_7

    move v1, v4

    .line 2475
    :goto_1
    if-nez v1, :cond_2

    iget-object v5, p0, Lcom/android/mail/compose/ComposeActivity;->mDraft:Lcom/android/mail/providers/Message;

    iget-object v5, v5, Lcom/android/mail/providers/Message;->cc:Ljava/lang/String;

    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_8

    iget v5, p0, Lcom/android/mail/compose/ComposeActivity;->mComposeMode:I

    if-ne v5, v4, :cond_8

    :cond_2
    move v2, v4

    .line 2479
    :cond_3
    :goto_2
    iget-object v5, p0, Lcom/android/mail/compose/ComposeActivity;->mCcBccView:Lcom/android/mail/compose/CcBccView;

    invoke-virtual {v5, v3, v2, v1}, Lcom/android/mail/compose/CcBccView;->show(ZZZ)V

    .line 2481
    .end local v1    # "showBcc":Z
    .end local v2    # "showCc":Z
    :cond_4
    invoke-direct {p0}, Lcom/android/mail/compose/ComposeActivity;->updateHideOrShowCcBcc()V

    .line 2482
    invoke-direct {p0}, Lcom/android/mail/compose/ComposeActivity;->initChangeListeners()V

    .line 2483
    return v4

    .line 2456
    :cond_5
    if-ne p1, v4, :cond_6

    .line 2457
    iput v4, p0, Lcom/android/mail/compose/ComposeActivity;->mComposeMode:I

    goto :goto_0

    .line 2458
    :cond_6
    if-ne p1, v5, :cond_0

    .line 2459
    iput v5, p0, Lcom/android/mail/compose/ComposeActivity;->mComposeMode:I

    goto :goto_0

    .restart local v1    # "showBcc":Z
    .restart local v2    # "showCc":Z
    :cond_7
    move v1, v3

    .line 2472
    goto :goto_1

    :cond_8
    move v2, v3

    .line 2475
    goto :goto_2

    .line 2476
    :cond_9
    iget-object v5, p0, Lcom/android/mail/compose/ComposeActivity;->mRefMessage:Lcom/android/mail/providers/Message;

    if-eqz v5, :cond_3

    .line 2477
    iget-object v5, p0, Lcom/android/mail/compose/ComposeActivity;->mCc:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-virtual {v5}, Lcom/android/ex/chips/RecipientEditTextView;->getText()Landroid/text/Editable;

    move-result-object v5

    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_a

    move v2, v4

    :goto_3
    goto :goto_2

    :cond_a
    move v2, v3

    goto :goto_3
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 3

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 1690
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v2

    .line 1692
    sparse-switch v2, :sswitch_data_0

    move v0, v1

    .line 1727
    :goto_0
    if-nez v0, :cond_0

    invoke-super {p0, p1}, Landroid/app/Activity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    :cond_0
    return v0

    .line 1694
    :sswitch_0
    const-string v1, "image/*"

    invoke-direct {p0, v1}, Lcom/android/mail/compose/ComposeActivity;->doAttach(Ljava/lang/String;)V

    goto :goto_0

    .line 1697
    :sswitch_1
    const-string v1, "video/*"

    invoke-direct {p0, v1}, Lcom/android/mail/compose/ComposeActivity;->doAttach(Ljava/lang/String;)V

    goto :goto_0

    .line 1700
    :sswitch_2
    invoke-direct {p0}, Lcom/android/mail/compose/ComposeActivity;->showCcBccViews()V

    goto :goto_0

    .line 1703
    :sswitch_3
    invoke-direct {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->doSave(Z)V

    goto :goto_0

    .line 1706
    :sswitch_4
    invoke-direct {p0}, Lcom/android/mail/compose/ComposeActivity;->doSend()V

    goto :goto_0

    .line 1709
    :sswitch_5
    invoke-direct {p0}, Lcom/android/mail/compose/ComposeActivity;->doDiscard()V

    goto :goto_0

    .line 1712
    :sswitch_6
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    invoke-static {p0, v1}, Lcom/android/mail/utils/Utils;->showSettings(Landroid/content/Context;Lcom/android/mail/providers/Account;)V

    goto :goto_0

    .line 1715
    :sswitch_7
    invoke-direct {p0}, Lcom/android/mail/compose/ComposeActivity;->onAppUpPressed()V

    goto :goto_0

    .line 1718
    :sswitch_8
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    const v2, 0x7f0c000a

    invoke-virtual {p0, v2}, Lcom/android/mail/compose/ComposeActivity;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {p0, v1, v2}, Lcom/android/mail/utils/Utils;->showHelp(Landroid/content/Context;Lcom/android/mail/providers/Account;Ljava/lang/String;)V

    goto :goto_0

    .line 1721
    :sswitch_9
    iget-object v2, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    invoke-static {p0, v2, v1}, Lcom/android/mail/utils/Utils;->sendFeedback(Landroid/content/Context;Lcom/android/mail/providers/Account;Z)V

    goto :goto_0

    .line 1692
    :sswitch_data_0
    .sparse-switch
        0x102002c -> :sswitch_7
        0x7f100048 -> :sswitch_2
        0x7f10004c -> :sswitch_0
        0x7f10011c -> :sswitch_4
        0x7f10011d -> :sswitch_1
        0x7f10011e -> :sswitch_3
        0x7f10011f -> :sswitch_5
        0x7f100120 -> :sswitch_6
        0x7f100121 -> :sswitch_9
        0x7f100122 -> :sswitch_8
    .end sparse-switch
.end method

.method protected onPause()V
    .locals 1

    .prologue
    .line 557
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 559
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mSendConfirmDialog:Landroid/app/AlertDialog;

    if-eqz v0, :cond_0

    .line 560
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mSendConfirmDialog:Landroid/app/AlertDialog;

    invoke-virtual {v0}, Landroid/app/AlertDialog;->dismiss()V

    .line 562
    :cond_0
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mRecipientErrorDialog:Landroid/app/AlertDialog;

    if-eqz v0, :cond_1

    .line 563
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mRecipientErrorDialog:Landroid/app/AlertDialog;

    invoke-virtual {v0}, Landroid/app/AlertDialog;->dismiss()V

    .line 567
    :cond_1
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->isChangingConfigurations()Z

    move-result v0

    if-nez v0, :cond_2

    .line 568
    invoke-direct {p0}, Lcom/android/mail/compose/ComposeActivity;->saveIfNeeded()V

    .line 570
    :cond_2
    return-void
.end method

.method public onPrepareOptionsMenu(Landroid/view/Menu;)Z
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 1669
    const v0, 0x7f100048

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v1

    .line 1670
    if-eqz v1, :cond_1

    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mCc:Lcom/android/ex/chips/RecipientEditTextView;

    if-eqz v0, :cond_1

    .line 1672
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mCc:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-virtual {v0}, Lcom/android/ex/chips/RecipientEditTextView;->isShown()Z

    move-result v0

    .line 1673
    iget-object v2, p0, Lcom/android/mail/compose/ComposeActivity;->mBcc:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-virtual {v2}, Lcom/android/ex/chips/RecipientEditTextView;->isShown()Z

    move-result v2

    .line 1674
    if-eqz v0, :cond_0

    if-nez v2, :cond_4

    .line 1675
    :cond_0
    invoke-interface {v1, v3}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 1676
    if-nez v0, :cond_3

    const v0, 0x7f0c005e

    :goto_0
    invoke-virtual {p0, v0}, Lcom/android/mail/compose/ComposeActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-interface {v1, v0}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 1682
    :cond_1
    :goto_1
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mSave:Landroid/view/MenuItem;

    if-eqz v0, :cond_2

    .line 1683
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mSave:Landroid/view/MenuItem;

    invoke-direct {p0}, Lcom/android/mail/compose/ComposeActivity;->shouldSave()Z

    move-result v1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 1685
    :cond_2
    return v3

    .line 1676
    :cond_3
    const v0, 0x7f0c005f

    goto :goto_0

    .line 1679
    :cond_4
    const/4 v0, 0x0

    invoke-interface {v1, v0}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    goto :goto_1
.end method

.method public onRespondInline(Ljava/lang/String;)V
    .locals 2
    .param p1, "text"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 2538
    invoke-virtual {p0, p1, v1}, Lcom/android/mail/compose/ComposeActivity;->appendToBody(Ljava/lang/CharSequence;Z)V

    .line 2539
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mQuotedTextView:Lcom/android/mail/compose/QuotedTextView;

    invoke-virtual {v0, v1}, Lcom/android/mail/compose/QuotedTextView;->setUpperDividerVisible(Z)V

    .line 2540
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mTo:Lcom/android/ex/chips/RecipientEditTextView;

    invoke-virtual {v0}, Lcom/android/ex/chips/RecipientEditTextView;->requestFocus()Z

    .line 2541
    return-void
.end method

.method public final onRestoreInstanceState(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 592
    invoke-super {p0, p1}, Landroid/app/Activity;->onRestoreInstanceState(Landroid/os/Bundle;)V

    .line 593
    if-eqz p1, :cond_0

    .line 594
    const-string v4, "focusSelectionStart"

    invoke-virtual {p1, v4}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 595
    const-string v4, "focusSelectionStart"

    invoke-virtual {p1, v4}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v3

    .line 596
    .local v3, "selectionStart":I
    sget-object v4, Lcom/android/mail/compose/ComposeActivity;->EXTRA_FOCUS_SELECTION_END:Ljava/lang/String;

    invoke-virtual {p1, v4}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v2

    .line 599
    .local v2, "selectionEnd":I
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->getCurrentFocus()Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    .line 600
    .local v0, "focusEditText":Landroid/widget/EditText;
    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v4

    invoke-interface {v4}, Landroid/text/Editable;->length()I

    move-result v1

    .line 601
    .local v1, "length":I
    if-ge v3, v1, :cond_0

    if-ge v2, v1, :cond_0

    .line 602
    invoke-virtual {v0, v3, v2}, Landroid/widget/EditText;->setSelection(II)V

    .line 606
    .end local v0    # "focusEditText":Landroid/widget/EditText;
    .end local v1    # "length":I
    .end local v2    # "selectionEnd":I
    .end local v3    # "selectionStart":I
    :cond_0
    return-void
.end method

.method protected onResume()V
    .locals 4

    .prologue
    .line 547
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 550
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mFromSpinner:Lcom/android/mail/compose/FromAddressSpinner;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    if-eqz v0, :cond_0

    .line 551
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mFromSpinner:Lcom/android/mail/compose/FromAddressSpinner;

    iget v1, p0, Lcom/android/mail/compose/ComposeActivity;->mComposeMode:I

    iget-object v2, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v3, p0, Lcom/android/mail/compose/ComposeActivity;->mAccounts:[Lcom/android/mail/providers/Account;

    invoke-virtual {v0, v1, v2, v3}, Lcom/android/mail/compose/FromAddressSpinner;->asyncInitFromSpinner(ILcom/android/mail/providers/Account;[Lcom/android/mail/providers/Account;)V

    .line 553
    :cond_0
    return-void
.end method

.method public final onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 11
    .param p1, "state"    # Landroid/os/Bundle;

    .prologue
    .line 610
    invoke-super {p0, p1}, Landroid/app/Activity;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 612
    iget-object v7, p0, Lcom/android/mail/compose/ComposeActivity;->mAccounts:[Lcom/android/mail/providers/Account;

    if-eqz v7, :cond_0

    iget-object v7, p0, Lcom/android/mail/compose/ComposeActivity;->mAccounts:[Lcom/android/mail/providers/Account;

    array-length v7, v7

    if-nez v7, :cond_1

    .line 667
    :cond_0
    :goto_0
    return-void

    .line 618
    :cond_1
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->getCurrentFocus()Landroid/view/View;

    move-result-object v0

    .line 619
    .local v0, "focus":Landroid/view/View;
    if-eqz v0, :cond_2

    instance-of v7, v0, Landroid/widget/EditText;

    if-eqz v7, :cond_2

    move-object v1, v0

    .line 620
    check-cast v1, Landroid/widget/EditText;

    .line 621
    .local v1, "focusEditText":Landroid/widget/EditText;
    const-string v7, "focusSelectionStart"

    invoke-virtual {v1}, Landroid/widget/EditText;->getSelectionStart()I

    move-result v8

    invoke-virtual {p1, v7, v8}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 622
    sget-object v7, Lcom/android/mail/compose/ComposeActivity;->EXTRA_FOCUS_SELECTION_END:Ljava/lang/String;

    invoke-virtual {v1}, Landroid/widget/EditText;->getSelectionEnd()I

    move-result v8

    invoke-virtual {p1, v7, v8}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 625
    .end local v1    # "focusEditText":Landroid/widget/EditText;
    :cond_2
    iget-object v7, p0, Lcom/android/mail/compose/ComposeActivity;->mFromSpinner:Lcom/android/mail/compose/FromAddressSpinner;

    invoke-virtual {v7}, Lcom/android/mail/compose/FromAddressSpinner;->getReplyFromAccounts()Ljava/util/List;

    move-result-object v4

    .line 626
    .local v4, "replyFromAccounts":Ljava/util/List;, "Ljava/util/List<Lcom/android/mail/providers/ReplyFromAccount;>;"
    iget-object v7, p0, Lcom/android/mail/compose/ComposeActivity;->mFromSpinner:Lcom/android/mail/compose/FromAddressSpinner;

    invoke-virtual {v7}, Lcom/android/mail/compose/FromAddressSpinner;->getSelectedItemPosition()I

    move-result v5

    .line 627
    .local v5, "selectedPos":I
    if-eqz v4, :cond_5

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v7

    if-lez v7, :cond_5

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v7

    if-le v7, v5, :cond_5

    invoke-interface {v4, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/android/mail/providers/ReplyFromAccount;

    move-object v6, v7

    .line 630
    .local v6, "selectedReplyFromAccount":Lcom/android/mail/providers/ReplyFromAccount;
    :goto_1
    if-eqz v6, :cond_6

    .line 631
    const-string v7, "replyFromAccount"

    invoke-virtual {v6}, Lcom/android/mail/providers/ReplyFromAccount;->serialize()Lorg/json/JSONObject;

    move-result-object v8

    invoke-virtual {v8}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {p1, v7, v8}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 633
    const-string v7, "account"

    iget-object v8, v6, Lcom/android/mail/providers/ReplyFromAccount;->account:Lcom/android/mail/providers/Account;

    invoke-virtual {p1, v7, v8}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 638
    :goto_2
    iget-wide v7, p0, Lcom/android/mail/compose/ComposeActivity;->mDraftId:J

    const-wide/16 v9, -0x1

    cmp-long v7, v7, v9

    if-nez v7, :cond_3

    iget v7, p0, Lcom/android/mail/compose/ComposeActivity;->mRequestId:I

    if-eqz v7, :cond_3

    .line 641
    const-string v7, "requestId"

    iget v8, p0, Lcom/android/mail/compose/ComposeActivity;->mRequestId:I

    invoke-virtual {p1, v7, v8}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 646
    :cond_3
    invoke-direct {p0}, Lcom/android/mail/compose/ComposeActivity;->getMode()I

    move-result v3

    .line 647
    .local v3, "mode":I
    const-string v7, "action"

    invoke-virtual {p1, v7, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 651
    iget-object v7, p0, Lcom/android/mail/compose/ComposeActivity;->mDraft:Lcom/android/mail/providers/Message;

    if-eqz v7, :cond_7

    .line 652
    iget-object v2, p0, Lcom/android/mail/compose/ComposeActivity;->mDraft:Lcom/android/mail/providers/Message;

    .line 653
    .local v2, "message":Lcom/android/mail/providers/Message;
    invoke-direct {p0, v2, v6, v3}, Lcom/android/mail/compose/ComposeActivity;->updateMessage(Lcom/android/mail/providers/Message;Lcom/android/mail/providers/ReplyFromAccount;I)V

    .line 657
    :goto_3
    const-string v7, "extraMessage"

    invoke-virtual {p1, v7, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 659
    iget-object v7, p0, Lcom/android/mail/compose/ComposeActivity;->mRefMessage:Lcom/android/mail/providers/Message;

    if-eqz v7, :cond_4

    .line 660
    const-string v7, "in-reference-to-message"

    iget-object v8, p0, Lcom/android/mail/compose/ComposeActivity;->mRefMessage:Lcom/android/mail/providers/Message;

    invoke-virtual {p1, v7, v8}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 662
    :cond_4
    const-string v7, "showCc"

    iget-object v8, p0, Lcom/android/mail/compose/ComposeActivity;->mCcBccView:Lcom/android/mail/compose/CcBccView;

    invoke-virtual {v8}, Lcom/android/mail/compose/CcBccView;->isCcVisible()Z

    move-result v8

    invoke-virtual {p1, v7, v8}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 663
    const-string v7, "showBcc"

    iget-object v8, p0, Lcom/android/mail/compose/ComposeActivity;->mCcBccView:Lcom/android/mail/compose/CcBccView;

    invoke-virtual {v8}, Lcom/android/mail/compose/CcBccView;->isBccVisible()Z

    move-result v8

    invoke-virtual {p1, v7, v8}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 665
    const-string v7, "attachmentPreviews"

    iget-object v8, p0, Lcom/android/mail/compose/ComposeActivity;->mAttachmentsView:Lcom/android/mail/compose/AttachmentsView;

    invoke-virtual {v8}, Lcom/android/mail/compose/AttachmentsView;->getAttachmentPreviews()Ljava/util/ArrayList;

    move-result-object v8

    invoke-virtual {p1, v7, v8}, Landroid/os/Bundle;->putParcelableArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    goto/16 :goto_0

    .line 627
    .end local v2    # "message":Lcom/android/mail/providers/Message;
    .end local v3    # "mode":I
    .end local v6    # "selectedReplyFromAccount":Lcom/android/mail/providers/ReplyFromAccount;
    :cond_5
    const/4 v6, 0x0

    goto :goto_1

    .line 635
    .restart local v6    # "selectedReplyFromAccount":Lcom/android/mail/providers/ReplyFromAccount;
    :cond_6
    const-string v7, "account"

    iget-object v8, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    invoke-virtual {p1, v7, v8}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    goto :goto_2

    .line 655
    .restart local v3    # "mode":I
    :cond_7
    invoke-direct {p0, v6, v3}, Lcom/android/mail/compose/ComposeActivity;->createMessage(Lcom/android/mail/providers/ReplyFromAccount;I)Lcom/android/mail/providers/Message;

    move-result-object v2

    .restart local v2    # "message":Lcom/android/mail/providers/Message;
    goto :goto_3
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "before"    # I
    .param p4, "count"    # I

    .prologue
    .line 2734
    return-void
.end method

.method protected recipientMatchesThisAccount(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 1
    .param p1, "accountAddress"    # Ljava/lang/String;
    .param p2, "recipientAddress"    # Ljava/lang/String;

    .prologue
    .line 1576
    invoke-virtual {p1, p2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mFromSpinner:Lcom/android/mail/compose/FromAddressSpinner;

    invoke-virtual {v0}, Lcom/android/mail/compose/FromAddressSpinner;->getReplyFromAccounts()Ljava/util/List;

    move-result-object v0

    invoke-static {p2, v0}, Lcom/android/mail/providers/ReplyFromAccount;->isCustomFrom(Ljava/lang/String;Ljava/util/List;)Z

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

.method protected resetMessageForModeChange()V
    .locals 2

    .prologue
    .line 2495
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mTo:Lcom/android/ex/chips/RecipientEditTextView;

    const-string v1, ""

    invoke-virtual {v0, v1}, Lcom/android/ex/chips/RecipientEditTextView;->setText(Ljava/lang/CharSequence;)V

    .line 2496
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mCc:Lcom/android/ex/chips/RecipientEditTextView;

    const-string v1, ""

    invoke-virtual {v0, v1}, Lcom/android/ex/chips/RecipientEditTextView;->setText(Ljava/lang/CharSequence;)V

    .line 2497
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mBcc:Lcom/android/ex/chips/RecipientEditTextView;

    const-string v1, ""

    invoke-virtual {v0, v1}, Lcom/android/ex/chips/RecipientEditTextView;->setText(Ljava/lang/CharSequence;)V

    .line 2499
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mSubject:Landroid/widget/TextView;

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 2505
    iget-boolean v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAttachmentsChanged:Z

    if-nez v0, :cond_0

    .line 2506
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAttachmentsView:Lcom/android/mail/compose/AttachmentsView;

    invoke-virtual {v0}, Lcom/android/mail/compose/AttachmentsView;->deleteAllAttachments()V

    .line 2508
    :cond_0
    return-void
.end method

.method protected sendOrSaveWithSanityChecks(ZZZZ)Z
    .locals 7

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 2063
    iget-object v2, p0, Lcom/android/mail/compose/ComposeActivity;->mAccounts:[Lcom/android/mail/providers/Account;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    if-nez v2, :cond_2

    .line 2064
    :cond_0
    const v1, 0x7f0c009a

    invoke-static {p0, v1, v0}, Landroid/widget/Toast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    .line 2065
    if-eqz p4, :cond_1

    .line 2066
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->finish()V

    .line 2142
    :cond_1
    :goto_0
    return v0

    .line 2072
    :cond_2
    iget-object v2, p0, Lcom/android/mail/compose/ComposeActivity;->mBodyView:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getEditableText()Landroid/text/Editable;

    move-result-object v5

    .line 2073
    if-eqz p3, :cond_3

    .line 2074
    new-array v2, v0, [Ljava/lang/String;

    move-object v3, v2

    move-object v4, v2

    .line 2083
    :goto_1
    if-nez p1, :cond_4

    array-length v6, v4

    if-nez v6, :cond_4

    array-length v6, v3

    if-nez v6, :cond_4

    array-length v6, v2

    if-nez v6, :cond_4

    .line 2084
    const v1, 0x7f0c0031

    invoke-virtual {p0, v1}, Lcom/android/mail/compose/ComposeActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/android/mail/compose/ComposeActivity;->showRecipientErrorDialog(Ljava/lang/String;)V

    goto :goto_0

    .line 2076
    :cond_3
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->getToAddresses()[Ljava/lang/String;

    move-result-object v4

    .line 2077
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->getCcAddresses()[Ljava/lang/String;

    move-result-object v3

    .line 2078
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->getBccAddresses()[Ljava/lang/String;

    move-result-object v2

    goto :goto_1

    .line 2088
    :cond_4
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    .line 2089
    if-nez p1, :cond_5

    .line 2090
    invoke-virtual {p0, v4, v6}, Lcom/android/mail/compose/ComposeActivity;->checkInvalidEmails([Ljava/lang/String;Ljava/util/List;)V

    .line 2091
    invoke-virtual {p0, v3, v6}, Lcom/android/mail/compose/ComposeActivity;->checkInvalidEmails([Ljava/lang/String;Ljava/util/List;)V

    .line 2092
    invoke-virtual {p0, v2, v6}, Lcom/android/mail/compose/ComposeActivity;->checkInvalidEmails([Ljava/lang/String;Ljava/util/List;)V

    .line 2096
    :cond_5
    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_6

    .line 2097
    const v2, 0x7f0c00c8

    invoke-virtual {p0, v2}, Lcom/android/mail/compose/ComposeActivity;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v1, v1, [Ljava/lang/Object;

    invoke-interface {v6, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    aput-object v3, v1, v0

    invoke-static {v2, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 2099
    invoke-virtual {p0, v1}, Lcom/android/mail/compose/ComposeActivity;->showRecipientErrorDialog(Ljava/lang/String;)V

    goto :goto_0

    .line 2103
    :cond_6
    new-instance v3, Lcom/android/mail/compose/ComposeActivity$2;

    invoke-direct {v3, p0, p1, p2, p3}, Lcom/android/mail/compose/ComposeActivity$2;-><init>(Lcom/android/mail/compose/ComposeActivity;ZZZ)V

    .line 2111
    if-nez p1, :cond_c

    .line 2112
    iget-object v2, p0, Lcom/android/mail/compose/ComposeActivity;->mAttachmentsView:Lcom/android/mail/compose/AttachmentsView;

    invoke-virtual {v2}, Lcom/android/mail/compose/AttachmentsView;->getAttachments()Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_b

    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->showEmptyTextWarnings()Z

    move-result v2

    if-eqz v2, :cond_b

    .line 2113
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->isSubjectEmpty()Z

    move-result v4

    .line 2114
    invoke-static {v5}, Landroid/text/TextUtils;->getTrimmedLength(Ljava/lang/CharSequence;)I

    move-result v2

    if-nez v2, :cond_8

    move v2, v1

    .line 2119
    :goto_2
    if-eqz v2, :cond_9

    iget-boolean v2, p0, Lcom/android/mail/compose/ComposeActivity;->mForward:Z

    if-eqz v2, :cond_7

    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->isBodyEmpty()Z

    move-result v2

    if-eqz v2, :cond_9

    :cond_7
    move v2, v1

    .line 2124
    :goto_3
    if-eqz v4, :cond_a

    .line 2125
    const v0, 0x7f0c0034

    invoke-direct {p0, v0, v3}, Lcom/android/mail/compose/ComposeActivity;->showSendConfirmDialog(ILandroid/content/DialogInterface$OnClickListener;)V

    move v0, v1

    .line 2126
    goto/16 :goto_0

    :cond_8
    move v2, v0

    .line 2114
    goto :goto_2

    :cond_9
    move v2, v0

    .line 2119
    goto :goto_3

    .line 2129
    :cond_a
    if-eqz v2, :cond_b

    .line 2130
    const v0, 0x7f0c0035

    invoke-direct {p0, v0, v3}, Lcom/android/mail/compose/ComposeActivity;->showSendConfirmDialog(ILandroid/content/DialogInterface$OnClickListener;)V

    move v0, v1

    .line 2131
    goto/16 :goto_0

    .line 2135
    :cond_b
    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->showSendConfirmation()Z

    move-result v2

    if-eqz v2, :cond_c

    .line 2136
    const v0, 0x7f0c0036

    invoke-direct {p0, v0, v3}, Lcom/android/mail/compose/ComposeActivity;->showSendConfirmDialog(ILandroid/content/DialogInterface$OnClickListener;)V

    move v0, v1

    .line 2137
    goto/16 :goto_0

    .line 2141
    :cond_c
    invoke-direct {p0, v5, p1, p2, v0}, Lcom/android/mail/compose/ComposeActivity;->sendOrSave(Landroid/text/Spanned;ZZZ)V

    move v0, v1

    .line 2142
    goto/16 :goto_0
.end method

.method setAccount(Lcom/android/mail/providers/Account;)V
    .locals 1
    .param p1, "account"    # Lcom/android/mail/providers/Account;

    .prologue
    .line 731
    if-nez p1, :cond_1

    .line 742
    :cond_0
    :goto_0
    return-void

    .line 734
    :cond_1
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    invoke-virtual {p1, v0}, Lcom/android/mail/providers/Account;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 735
    iput-object p1, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    .line 736
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v0, v0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    iput-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mCachedSettings:Lcom/android/mail/providers/Settings;

    .line 737
    invoke-direct {p0}, Lcom/android/mail/compose/ComposeActivity;->appendSignature()V

    .line 739
    :cond_2
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    if-eqz v0, :cond_0

    .line 740
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v0, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-static {v0}, Lcom/android/mail/ui/MailActivity;->getMailtoNdef(Ljava/lang/String;)Landroid/nfc/NdefMessage;

    move-result-object v0

    invoke-static {v0}, Lcom/android/mail/ui/MailActivity;->setForegroundNdef(Landroid/nfc/NdefMessage;)V

    goto :goto_0
.end method

.method public setBody(Ljava/lang/CharSequence;Z)V
    .locals 1
    .param p1, "text"    # Ljava/lang/CharSequence;
    .param p2, "withSignature"    # Z

    .prologue
    .line 2566
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mBodyView:Landroid/widget/EditText;

    invoke-virtual {v0, p1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 2567
    if-eqz p2, :cond_0

    .line 2568
    invoke-direct {p0}, Lcom/android/mail/compose/ComposeActivity;->appendSignature()V

    .line 2570
    :cond_0
    return-void
.end method

.method protected showEmptyTextWarnings()Z
    .locals 1

    .prologue
    .line 2152
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mAttachmentsView:Lcom/android/mail/compose/AttachmentsView;

    invoke-virtual {v0}, Lcom/android/mail/compose/AttachmentsView;->getAttachments()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public showRecipientErrorDialog(Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 1960
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mRecipientErrorDialog:Landroid/app/AlertDialog;

    if-eqz v0, :cond_0

    .line 1961
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mRecipientErrorDialog:Landroid/app/AlertDialog;

    invoke-virtual {v0}, Landroid/app/AlertDialog;->dismiss()V

    .line 1963
    :cond_0
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-direct {v0, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    invoke-virtual {v0, p1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const v1, 0x7f0c0032

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(I)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const v1, 0x1010355

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setIconAttribute(I)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const v1, 0x7f0c00d2

    new-instance v2, Lcom/android/mail/compose/ComposeActivity$1;

    invoke-direct {v2, p0}, Lcom/android/mail/compose/ComposeActivity$1;-><init>(Lcom/android/mail/compose/ComposeActivity;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mRecipientErrorDialog:Landroid/app/AlertDialog;

    .line 1980
    return-void
.end method

.method protected showSendConfirmation()Z
    .locals 1

    .prologue
    .line 2161
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mCachedSettings:Lcom/android/mail/providers/Settings;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mCachedSettings:Lcom/android/mail/providers/Settings;

    iget-boolean v0, v0, Lcom/android/mail/providers/Settings;->confirmSend:Z

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected tokenizeAddressList(Ljava/util/Collection;)Ljava/util/List;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/util/List",
            "<[",
            "Landroid/text/util/Rfc822Token;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1504
    .local p1, "addresses":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 1506
    .local v2, "tokenized":Ljava/util/List;, "Ljava/util/List<[Landroid/text/util/Rfc822Token;>;"
    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 1507
    .local v0, "address":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/util/Rfc822Tokenizer;->tokenize(Ljava/lang/CharSequence;)[Landroid/text/util/Rfc822Token;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 1509
    .end local v0    # "address":Ljava/lang/String;
    :cond_0
    return-object v2
.end method

.method public updateSaveUi()V
    .locals 2

    .prologue
    .line 1987
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity;->mSave:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    .line 1988
    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity;->mSave:Landroid/view/MenuItem;

    invoke-direct {p0}, Lcom/android/mail/compose/ComposeActivity;->shouldSave()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-virtual {p0}, Lcom/android/mail/compose/ComposeActivity;->isBlank()Z

    move-result v0

    if-nez v0, :cond_1

    const/4 v0, 0x1

    :goto_0
    invoke-interface {v1, v0}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 1990
    :cond_0
    return-void

    .line 1988
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method
