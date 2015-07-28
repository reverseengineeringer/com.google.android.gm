.class public Lcom/android/mail/browse/ConversationViewHeader;
.super Landroid/widget/RelativeLayout;
.source "ConversationViewHeader.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/browse/ConversationViewHeader$ConversationFolderDisplayer;,
        Lcom/android/mail/browse/ConversationViewHeader$ConversationViewHeaderCallbacks;
    }
.end annotation


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private mAccountController:Lcom/android/mail/browse/ConversationViewAdapter$ConversationAccountController;

.field private mCallbacks:Lcom/android/mail/browse/ConversationViewHeader$ConversationViewHeaderCallbacks;

.field private mFolderDisplayer:Lcom/android/mail/browse/ConversationViewHeader$ConversationFolderDisplayer;

.field private mFoldersView:Lcom/android/mail/browse/FolderSpanTextView;

.field private mHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$ConversationHeaderItem;

.field private mSubjectView:Landroid/widget/TextView;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 78
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/browse/ConversationViewHeader;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 87
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/android/mail/browse/ConversationViewHeader;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 88
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 91
    invoke-direct {p0, p1, p2}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 92
    return-void
.end method

.method private static getTotalMeasuredChildWidth(Landroid/view/View;)I
    .locals 3
    .param p0, "child"    # Landroid/view/View;

    .prologue
    .line 124
    invoke-virtual {p0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout$LayoutParams;

    .line 125
    .local v0, "p":Landroid/widget/RelativeLayout$LayoutParams;
    invoke-virtual {p0}, Landroid/view/View;->getMeasuredWidth()I

    move-result v1

    iget v2, v0, Landroid/view/ViewGroup$MarginLayoutParams;->leftMargin:I

    add-int/2addr v1, v2

    iget v2, v0, Landroid/view/ViewGroup$MarginLayoutParams;->rightMargin:I

    add-int/2addr v1, v2

    return v1
.end method

.method private measureHeight()I
    .locals 5

    .prologue
    .line 172
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationViewHeader;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    check-cast v1, Landroid/view/ViewGroup;

    .line 173
    .local v1, "parent":Landroid/view/ViewGroup;
    if-nez v1, :cond_0

    .line 174
    sget-object v2, Lcom/android/mail/browse/ConversationViewHeader;->LOG_TAG:Ljava/lang/String;

    const-string v3, "Unable to measure height of conversation header"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v2, v3, v4}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 175
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationViewHeader;->getHeight()I

    move-result v0

    .line 178
    :goto_0
    return v0

    .line 177
    :cond_0
    invoke-static {p0, v1}, Lcom/android/mail/utils/Utils;->measureViewHeight(Landroid/view/View;Landroid/view/ViewGroup;)I

    move-result v0

    .line 178
    .local v0, "h":I
    goto :goto_0
.end method


# virtual methods
.method public bind(Lcom/android/mail/browse/ConversationViewAdapter$ConversationHeaderItem;)V
    .locals 0
    .param p1, "headerItem"    # Lcom/android/mail/browse/ConversationViewAdapter$ConversationHeaderItem;

    .prologue
    .line 168
    iput-object p1, p0, Lcom/android/mail/browse/ConversationViewHeader;->mHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$ConversationHeaderItem;

    .line 169
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 198
    const v0, 0x7f10002b

    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v1

    if-ne v0, v1, :cond_0

    .line 199
    iget-object v0, p0, Lcom/android/mail/browse/ConversationViewHeader;->mCallbacks:Lcom/android/mail/browse/ConversationViewHeader$ConversationViewHeaderCallbacks;

    if-eqz v0, :cond_0

    .line 200
    iget-object v0, p0, Lcom/android/mail/browse/ConversationViewHeader;->mCallbacks:Lcom/android/mail/browse/ConversationViewHeader$ConversationViewHeaderCallbacks;

    invoke-interface {v0}, Lcom/android/mail/browse/ConversationViewHeader$ConversationViewHeaderCallbacks;->onFoldersClicked()V

    .line 203
    :cond_0
    return-void
.end method

.method public onConversationUpdated(Lcom/android/mail/providers/Conversation;)V
    .locals 2
    .param p1, "conv"    # Lcom/android/mail/providers/Conversation;

    .prologue
    .line 188
    invoke-virtual {p0, p1}, Lcom/android/mail/browse/ConversationViewHeader;->setFolders(Lcom/android/mail/providers/Conversation;)V

    .line 190
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationViewHeader;->measureHeight()I

    move-result v0

    .line 191
    .local v0, "h":I
    iget-object v1, p0, Lcom/android/mail/browse/ConversationViewHeader;->mHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$ConversationHeaderItem;

    invoke-virtual {v1, v0}, Lcom/android/mail/browse/ConversationViewAdapter$ConversationHeaderItem;->setHeight(I)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 192
    iget-object v1, p0, Lcom/android/mail/browse/ConversationViewHeader;->mCallbacks:Lcom/android/mail/browse/ConversationViewHeader$ConversationViewHeaderCallbacks;

    invoke-interface {v1, v0}, Lcom/android/mail/browse/ConversationViewHeader$ConversationViewHeaderCallbacks;->onConversationViewHeaderHeightChange(I)V

    .line 194
    :cond_0
    return-void
.end method

.method protected onFinishInflate()V
    .locals 3

    .prologue
    .line 96
    invoke-super {p0}, Landroid/widget/RelativeLayout;->onFinishInflate()V

    .line 98
    const v0, 0x7f10004b

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/ConversationViewHeader;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/android/mail/browse/ConversationViewHeader;->mSubjectView:Landroid/widget/TextView;

    .line 99
    const v0, 0x7f10002b

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/ConversationViewHeader;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/android/mail/browse/FolderSpanTextView;

    iput-object v0, p0, Lcom/android/mail/browse/ConversationViewHeader;->mFoldersView:Lcom/android/mail/browse/FolderSpanTextView;

    .line 101
    iget-object v0, p0, Lcom/android/mail/browse/ConversationViewHeader;->mFoldersView:Lcom/android/mail/browse/FolderSpanTextView;

    invoke-virtual {v0, p0}, Lcom/android/mail/browse/FolderSpanTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 102
    new-instance v0, Lcom/android/mail/browse/ConversationViewHeader$ConversationFolderDisplayer;

    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationViewHeader;->getContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/browse/ConversationViewHeader;->mFoldersView:Lcom/android/mail/browse/FolderSpanTextView;

    invoke-direct {v0, v1, v2}, Lcom/android/mail/browse/ConversationViewHeader$ConversationFolderDisplayer;-><init>(Landroid/content/Context;Lcom/android/mail/browse/FolderSpan$FolderSpanDimensions;)V

    iput-object v0, p0, Lcom/android/mail/browse/ConversationViewHeader;->mFolderDisplayer:Lcom/android/mail/browse/ConversationViewHeader$ConversationFolderDisplayer;

    .line 103
    return-void
.end method

.method protected onMeasure(II)V
    .locals 4
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 107
    invoke-super {p0, p1, p2}, Landroid/widget/RelativeLayout;->onMeasure(II)V

    .line 112
    iget-object v2, p0, Lcom/android/mail/browse/ConversationViewHeader;->mSubjectView:Landroid/widget/TextView;

    invoke-static {v2}, Lcom/android/mail/browse/ConversationViewHeader;->getTotalMeasuredChildWidth(Landroid/view/View;)I

    move-result v2

    iget-object v3, p0, Lcom/android/mail/browse/ConversationViewHeader;->mFoldersView:Lcom/android/mail/browse/FolderSpanTextView;

    invoke-static {v3}, Lcom/android/mail/browse/ConversationViewHeader;->getTotalMeasuredChildWidth(Landroid/view/View;)I

    move-result v3

    add-int/2addr v2, v3

    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationViewHeader;->getPaddingLeft()I

    move-result v3

    add-int/2addr v2, v3

    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationViewHeader;->getPaddingRight()I

    move-result v3

    add-int v0, v2, v3

    .line 115
    .local v0, "childWidthSum":I
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationViewHeader;->getMeasuredWidth()I

    move-result v2

    if-le v0, v2, :cond_0

    .line 116
    iget-object v2, p0, Lcom/android/mail/browse/ConversationViewHeader;->mFoldersView:Lcom/android/mail/browse/FolderSpanTextView;

    invoke-virtual {v2}, Lcom/android/mail/browse/FolderSpanTextView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    check-cast v1, Landroid/widget/RelativeLayout$LayoutParams;

    .line 117
    .local v1, "params":Landroid/widget/RelativeLayout$LayoutParams;
    const/4 v2, 0x3

    const v3, 0x7f10004b

    invoke-virtual {v1, v2, v3}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    .line 118
    const/4 v2, 0x4

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    .line 119
    invoke-super {p0, p1, p2}, Landroid/widget/RelativeLayout;->onMeasure(II)V

    .line 121
    .end local v1    # "params":Landroid/widget/RelativeLayout$LayoutParams;
    :cond_0
    return-void
.end method

.method public setCallbacks(Lcom/android/mail/browse/ConversationViewHeader$ConversationViewHeaderCallbacks;Lcom/android/mail/browse/ConversationViewAdapter$ConversationAccountController;)V
    .locals 0
    .param p1, "callbacks"    # Lcom/android/mail/browse/ConversationViewHeader$ConversationViewHeaderCallbacks;
    .param p2, "accountController"    # Lcom/android/mail/browse/ConversationViewAdapter$ConversationAccountController;

    .prologue
    .line 130
    iput-object p1, p0, Lcom/android/mail/browse/ConversationViewHeader;->mCallbacks:Lcom/android/mail/browse/ConversationViewHeader$ConversationViewHeaderCallbacks;

    .line 131
    iput-object p2, p0, Lcom/android/mail/browse/ConversationViewHeader;->mAccountController:Lcom/android/mail/browse/ConversationViewAdapter$ConversationAccountController;

    .line 132
    return-void
.end method

.method public setFolders(Lcom/android/mail/providers/Conversation;)V
    .locals 8
    .param p1, "conv"    # Lcom/android/mail/providers/Conversation;

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 151
    invoke-virtual {p0, v7}, Lcom/android/mail/browse/ConversationViewHeader;->setFoldersVisible(Z)V

    .line 152
    new-instance v0, Landroid/text/SpannableStringBuilder;

    invoke-direct {v0}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 153
    .local v0, "sb":Landroid/text/SpannableStringBuilder;
    iget-object v2, p0, Lcom/android/mail/browse/ConversationViewHeader;->mAccountController:Lcom/android/mail/browse/ConversationViewAdapter$ConversationAccountController;

    invoke-interface {v2}, Lcom/android/mail/browse/ConversationViewAdapter$ConversationAccountController;->getAccount()Lcom/android/mail/providers/Account;

    move-result-object v2

    iget-object v1, v2, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    .line 154
    .local v1, "settings":Lcom/android/mail/providers/Settings;
    iget-boolean v2, v1, Lcom/android/mail/providers/Settings;->priorityArrowsEnabled:Z

    if-eqz v2, :cond_0

    invoke-virtual {p1}, Lcom/android/mail/providers/Conversation;->isImportant()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 155
    const/16 v2, 0x2e

    invoke-virtual {v0, v2}, Landroid/text/SpannableStringBuilder;->append(C)Landroid/text/SpannableStringBuilder;

    .line 156
    new-instance v2, Lcom/android/mail/browse/PriorityIndicatorSpan;

    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationViewHeader;->getContext()Landroid/content/Context;

    move-result-object v3

    const v4, 0x7f020045

    iget-object v5, p0, Lcom/android/mail/browse/ConversationViewHeader;->mFoldersView:Lcom/android/mail/browse/FolderSpanTextView;

    invoke-virtual {v5}, Lcom/android/mail/browse/FolderSpanTextView;->getPadding()I

    move-result v5

    invoke-direct {v2, v3, v4, v5, v6}, Lcom/android/mail/browse/PriorityIndicatorSpan;-><init>(Landroid/content/Context;III)V

    const/16 v3, 0x11

    invoke-virtual {v0, v2, v6, v7, v3}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 161
    :cond_0
    iget-object v2, p0, Lcom/android/mail/browse/ConversationViewHeader;->mFolderDisplayer:Lcom/android/mail/browse/ConversationViewHeader$ConversationFolderDisplayer;

    const/4 v3, 0x0

    invoke-virtual {v2, p1, v3}, Lcom/android/mail/browse/ConversationViewHeader$ConversationFolderDisplayer;->loadConversationFolders(Lcom/android/mail/providers/Conversation;Lcom/android/mail/providers/Folder;)V

    .line 162
    iget-object v2, p0, Lcom/android/mail/browse/ConversationViewHeader;->mFolderDisplayer:Lcom/android/mail/browse/ConversationViewHeader$ConversationFolderDisplayer;

    invoke-virtual {v2, v0}, Lcom/android/mail/browse/ConversationViewHeader$ConversationFolderDisplayer;->appendFolderSpans(Landroid/text/SpannableStringBuilder;)V

    .line 164
    iget-object v2, p0, Lcom/android/mail/browse/ConversationViewHeader;->mFoldersView:Lcom/android/mail/browse/FolderSpanTextView;

    invoke-virtual {v2, v0}, Lcom/android/mail/browse/FolderSpanTextView;->setText(Ljava/lang/CharSequence;)V

    .line 165
    return-void
.end method

.method public setFoldersVisible(Z)V
    .locals 2
    .param p1, "show"    # Z

    .prologue
    .line 147
    iget-object v1, p0, Lcom/android/mail/browse/ConversationViewHeader;->mFoldersView:Lcom/android/mail/browse/FolderSpanTextView;

    if-eqz p1, :cond_0

    const/4 v0, 0x0

    :goto_0
    invoke-virtual {v1, v0}, Lcom/android/mail/browse/FolderSpanTextView;->setVisibility(I)V

    .line 148
    return-void

    .line 147
    :cond_0
    const/16 v0, 0x8

    goto :goto_0
.end method

.method public setSubject(Ljava/lang/String;)V
    .locals 3
    .param p1, "subject"    # Ljava/lang/String;

    .prologue
    .line 135
    move-object v0, p1

    .line 136
    .local v0, "subjectToShow":Ljava/lang/String;
    iget-object v1, p0, Lcom/android/mail/browse/ConversationViewHeader;->mCallbacks:Lcom/android/mail/browse/ConversationViewHeader$ConversationViewHeaderCallbacks;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/android/mail/browse/ConversationViewHeader;->mCallbacks:Lcom/android/mail/browse/ConversationViewHeader$ConversationViewHeaderCallbacks;

    invoke-interface {v1, p1}, Lcom/android/mail/browse/ConversationViewHeader$ConversationViewHeaderCallbacks;->getSubjectRemainder(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_0

    .line 137
    const/4 v0, 0x0

    .line 139
    :cond_0
    iget-object v1, p0, Lcom/android/mail/browse/ConversationViewHeader;->mSubjectView:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 141
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 142
    iget-object v1, p0, Lcom/android/mail/browse/ConversationViewHeader;->mSubjectView:Landroid/widget/TextView;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 144
    :cond_1
    return-void
.end method
