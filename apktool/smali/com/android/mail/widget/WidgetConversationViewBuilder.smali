.class public Lcom/android/mail/widget/WidgetConversationViewBuilder;
.super Ljava/lang/Object;
.source "WidgetConversationViewBuilder.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/widget/WidgetConversationViewBuilder$WidgetFolderDisplayer;
    }
.end annotation


# static fields
.field private static ATTACHMENT:Landroid/graphics/Bitmap;

.field private static DATE_FONT_SIZE:I

.field private static DATE_TEXT_COLOR:I

.field private static SUBJECT_FONT_SIZE:I

.field private static SUBJECT_TEXT_COLOR_READ:I

.field private static SUBJECT_TEXT_COLOR_UNREAD:I


# instance fields
.field private final mContext:Landroid/content/Context;

.field private mFolderDisplayer:Lcom/android/mail/widget/WidgetConversationViewBuilder$WidgetFolderDisplayer;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/android/mail/providers/Account;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "account"    # Lcom/android/mail/providers/Account;

    .prologue
    .line 114
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 115
    iput-object p1, p0, Lcom/android/mail/widget/WidgetConversationViewBuilder;->mContext:Landroid/content/Context;

    .line 116
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 119
    .local v0, "res":Landroid/content/res/Resources;
    const v1, 0x7f0b004f

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    sput v1, Lcom/android/mail/widget/WidgetConversationViewBuilder;->DATE_FONT_SIZE:I

    .line 120
    const v1, 0x7f0b004e

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    sput v1, Lcom/android/mail/widget/WidgetConversationViewBuilder;->SUBJECT_FONT_SIZE:I

    .line 123
    const v1, 0x7f090008

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    sput v1, Lcom/android/mail/widget/WidgetConversationViewBuilder;->SUBJECT_TEXT_COLOR_READ:I

    .line 124
    const v1, 0x7f090005

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    sput v1, Lcom/android/mail/widget/WidgetConversationViewBuilder;->SUBJECT_TEXT_COLOR_UNREAD:I

    .line 125
    const v1, 0x7f09000b

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    sput v1, Lcom/android/mail/widget/WidgetConversationViewBuilder;->DATE_TEXT_COLOR:I

    .line 128
    const v1, 0x7f02003a

    invoke-static {v0, v1}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v1

    sput-object v1, Lcom/android/mail/widget/WidgetConversationViewBuilder;->ATTACHMENT:Landroid/graphics/Bitmap;

    .line 129
    return-void
.end method

.method private addStyle(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    .locals 5
    .param p1, "text"    # Ljava/lang/CharSequence;
    .param p2, "size"    # I
    .param p3, "color"    # I

    .prologue
    const/16 v4, 0x21

    const/4 v3, 0x0

    .line 135
    new-instance v0, Landroid/text/SpannableStringBuilder;

    invoke-direct {v0, p1}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 136
    .local v0, "builder":Landroid/text/SpannableStringBuilder;
    new-instance v1, Landroid/text/style/AbsoluteSizeSpan;

    invoke-direct {v1, p2}, Landroid/text/style/AbsoluteSizeSpan;-><init>(I)V

    invoke-interface {p1}, Ljava/lang/CharSequence;->length()I

    move-result v2

    invoke-virtual {v0, v1, v3, v2, v4}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 138
    if-eqz p3, :cond_0

    .line 139
    new-instance v1, Landroid/text/style/ForegroundColorSpan;

    invoke-direct {v1, p3}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    invoke-interface {p1}, Ljava/lang/CharSequence;->length()I

    move-result v2

    invoke-virtual {v0, v1, v3, v2, v4}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 142
    :cond_0
    return-object v0
.end method


# virtual methods
.method public getStyledView(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Lcom/android/mail/providers/Conversation;Lcom/android/mail/providers/Folder;Landroid/text/SpannableStringBuilder;Ljava/lang/String;)Landroid/widget/RemoteViews;
    .locals 15
    .param p1, "status"    # Ljava/lang/CharSequence;
    .param p2, "date"    # Ljava/lang/CharSequence;
    .param p3, "conversation"    # Lcom/android/mail/providers/Conversation;
    .param p4, "currentFolder"    # Lcom/android/mail/providers/Folder;
    .param p5, "senders"    # Landroid/text/SpannableStringBuilder;
    .param p6, "filteredSubject"    # Ljava/lang/String;

    .prologue
    .line 152
    move-object/from16 v0, p3

    iget-boolean v11, v0, Lcom/android/mail/providers/Conversation;->read:Z

    if-nez v11, :cond_3

    const/4 v3, 0x1

    .line 153
    .local v3, "isUnread":Z
    :goto_0
    invoke-virtual/range {p3 .. p3}, Lcom/android/mail/providers/Conversation;->getSnippet()Ljava/lang/String;

    move-result-object v6

    .line 154
    .local v6, "snippet":Ljava/lang/String;
    move-object/from16 v0, p3

    iget-boolean v2, v0, Lcom/android/mail/providers/Conversation;->hasAttachments:Z

    .line 157
    .local v2, "hasAttachments":Z
    sget v11, Lcom/android/mail/widget/WidgetConversationViewBuilder;->DATE_FONT_SIZE:I

    sget v12, Lcom/android/mail/widget/WidgetConversationViewBuilder;->DATE_TEXT_COLOR:I

    move-object/from16 v0, p2

    invoke-direct {p0, v0, v11, v12}, Lcom/android/mail/widget/WidgetConversationViewBuilder;->addStyle(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;

    move-result-object v7

    .line 160
    .local v7, "styledDate":Ljava/lang/CharSequence;
    if-eqz v3, :cond_4

    sget v10, Lcom/android/mail/widget/WidgetConversationViewBuilder;->SUBJECT_TEXT_COLOR_UNREAD:I

    .line 161
    .local v10, "subjectColor":I
    :goto_1
    iget-object v11, p0, Lcom/android/mail/widget/WidgetConversationViewBuilder;->mContext:Landroid/content/Context;

    move-object/from16 v0, p6

    invoke-static {v11, v0, v6}, Lcom/android/mail/providers/Conversation;->getSubjectAndSnippetForDisplay(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableStringBuilder;

    move-result-object v9

    .line 163
    .local v9, "subjectAndSnippet":Landroid/text/SpannableStringBuilder;
    if-eqz v3, :cond_0

    .line 164
    new-instance v11, Landroid/text/style/StyleSpan;

    const/4 v12, 0x1

    invoke-direct {v11, v12}, Landroid/text/style/StyleSpan;-><init>(I)V

    const/4 v12, 0x0

    invoke-virtual/range {p6 .. p6}, Ljava/lang/String;->length()I

    move-result v13

    const/16 v14, 0x21

    invoke-virtual {v9, v11, v12, v13, v14}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 167
    :cond_0
    new-instance v11, Landroid/text/style/ForegroundColorSpan;

    invoke-direct {v11, v10}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    const/4 v12, 0x0

    invoke-virtual {v9}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v13

    const/16 v14, 0x21

    invoke-virtual {v9, v11, v12, v13, v14}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 169
    sget v11, Lcom/android/mail/widget/WidgetConversationViewBuilder;->SUBJECT_FONT_SIZE:I

    const/4 v12, 0x0

    invoke-direct {p0, v9, v11, v12}, Lcom/android/mail/widget/WidgetConversationViewBuilder;->addStyle(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;

    move-result-object v8

    .line 172
    .local v8, "styledSubject":Ljava/lang/CharSequence;
    const/4 v4, 0x0

    .line 173
    .local v4, "paperclipBitmap":Landroid/graphics/Bitmap;
    if-eqz v2, :cond_1

    .line 174
    sget-object v4, Lcom/android/mail/widget/WidgetConversationViewBuilder;->ATTACHMENT:Landroid/graphics/Bitmap;

    .line 178
    :cond_1
    new-instance v5, Landroid/widget/RemoteViews;

    iget-object v11, p0, Lcom/android/mail/widget/WidgetConversationViewBuilder;->mContext:Landroid/content/Context;

    invoke-virtual {v11}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v11

    const v12, 0x7f04007b

    invoke-direct {v5, v11, v12}, Landroid/widget/RemoteViews;-><init>(Ljava/lang/String;I)V

    .line 180
    .local v5, "remoteViews":Landroid/widget/RemoteViews;
    const v11, 0x7f100117

    move-object/from16 v0, p5

    invoke-virtual {v5, v11, v0}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 181
    const v11, 0x7f100116

    invoke-virtual {v5, v11, v7}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 182
    const v11, 0x7f100118

    invoke-virtual {v5, v11, v8}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 183
    if-eqz v4, :cond_5

    .line 184
    const v11, 0x7f100115

    const/4 v12, 0x0

    invoke-virtual {v5, v11, v12}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 185
    const v11, 0x7f100115

    invoke-virtual {v5, v11, v4}, Landroid/widget/RemoteViews;->setImageViewBitmap(ILandroid/graphics/Bitmap;)V

    .line 189
    :goto_2
    if-eqz v3, :cond_6

    .line 190
    const v11, 0x7f10010f

    const/4 v12, 0x0

    invoke-virtual {v5, v11, v12}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 191
    const v11, 0x7f100110

    const/16 v12, 0x8

    invoke-virtual {v5, v11, v12}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 196
    :goto_3
    iget-object v11, p0, Lcom/android/mail/widget/WidgetConversationViewBuilder;->mContext:Landroid/content/Context;

    invoke-virtual {v11}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    const v12, 0x7f0f0004

    invoke-virtual {v11, v12}, Landroid/content/res/Resources;->getBoolean(I)Z

    move-result v11

    if-eqz v11, :cond_2

    .line 197
    new-instance v11, Lcom/android/mail/widget/WidgetConversationViewBuilder$WidgetFolderDisplayer;

    iget-object v12, p0, Lcom/android/mail/widget/WidgetConversationViewBuilder;->mContext:Landroid/content/Context;

    invoke-direct {v11, v12}, Lcom/android/mail/widget/WidgetConversationViewBuilder$WidgetFolderDisplayer;-><init>(Landroid/content/Context;)V

    iput-object v11, p0, Lcom/android/mail/widget/WidgetConversationViewBuilder;->mFolderDisplayer:Lcom/android/mail/widget/WidgetConversationViewBuilder$WidgetFolderDisplayer;

    .line 198
    iget-object v11, p0, Lcom/android/mail/widget/WidgetConversationViewBuilder;->mFolderDisplayer:Lcom/android/mail/widget/WidgetConversationViewBuilder$WidgetFolderDisplayer;

    move-object/from16 v0, p3

    move-object/from16 v1, p4

    invoke-virtual {v11, v0, v1}, Lcom/android/mail/widget/WidgetConversationViewBuilder$WidgetFolderDisplayer;->loadConversationFolders(Lcom/android/mail/providers/Conversation;Lcom/android/mail/providers/Folder;)V

    .line 199
    iget-object v11, p0, Lcom/android/mail/widget/WidgetConversationViewBuilder;->mFolderDisplayer:Lcom/android/mail/widget/WidgetConversationViewBuilder$WidgetFolderDisplayer;

    invoke-virtual {v11, v5}, Lcom/android/mail/widget/WidgetConversationViewBuilder$WidgetFolderDisplayer;->displayFolders(Landroid/widget/RemoteViews;)V

    .line 202
    :cond_2
    return-object v5

    .line 152
    .end local v2    # "hasAttachments":Z
    .end local v3    # "isUnread":Z
    .end local v4    # "paperclipBitmap":Landroid/graphics/Bitmap;
    .end local v5    # "remoteViews":Landroid/widget/RemoteViews;
    .end local v6    # "snippet":Ljava/lang/String;
    .end local v7    # "styledDate":Ljava/lang/CharSequence;
    .end local v8    # "styledSubject":Ljava/lang/CharSequence;
    .end local v9    # "subjectAndSnippet":Landroid/text/SpannableStringBuilder;
    .end local v10    # "subjectColor":I
    :cond_3
    const/4 v3, 0x0

    goto/16 :goto_0

    .line 160
    .restart local v2    # "hasAttachments":Z
    .restart local v3    # "isUnread":Z
    .restart local v6    # "snippet":Ljava/lang/String;
    .restart local v7    # "styledDate":Ljava/lang/CharSequence;
    :cond_4
    sget v10, Lcom/android/mail/widget/WidgetConversationViewBuilder;->SUBJECT_TEXT_COLOR_READ:I

    goto/16 :goto_1

    .line 187
    .restart local v4    # "paperclipBitmap":Landroid/graphics/Bitmap;
    .restart local v5    # "remoteViews":Landroid/widget/RemoteViews;
    .restart local v8    # "styledSubject":Ljava/lang/CharSequence;
    .restart local v9    # "subjectAndSnippet":Landroid/text/SpannableStringBuilder;
    .restart local v10    # "subjectColor":I
    :cond_5
    const v11, 0x7f100115

    const/16 v12, 0x8

    invoke-virtual {v5, v11, v12}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    goto :goto_2

    .line 193
    :cond_6
    const v11, 0x7f10010f

    const/16 v12, 0x8

    invoke-virtual {v5, v11, v12}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 194
    const v11, 0x7f100110

    const/4 v12, 0x0

    invoke-virtual {v5, v11, v12}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    goto :goto_3
.end method
