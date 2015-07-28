.class Lcom/android/mail/browse/ConversationViewHeader$ConversationFolderDisplayer;
.super Lcom/android/mail/ui/FolderDisplayer;
.source "ConversationViewHeader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/browse/ConversationViewHeader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "ConversationFolderDisplayer"
.end annotation


# instance fields
.field private mDims:Lcom/android/mail/browse/FolderSpan$FolderSpanDimensions;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/android/mail/browse/FolderSpan$FolderSpanDimensions;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "dims"    # Lcom/android/mail/browse/FolderSpan$FolderSpanDimensions;

    .prologue
    .line 210
    invoke-direct {p0, p1}, Lcom/android/mail/ui/FolderDisplayer;-><init>(Landroid/content/Context;)V

    .line 211
    iput-object p2, p0, Lcom/android/mail/browse/ConversationViewHeader$ConversationFolderDisplayer;->mDims:Lcom/android/mail/browse/FolderSpan$FolderSpanDimensions;

    .line 212
    return-void
.end method

.method private addSpan(Landroid/text/SpannableStringBuilder;Lcom/android/mail/providers/Folder;)V
    .locals 7
    .param p1, "sb"    # Landroid/text/SpannableStringBuilder;
    .param p2, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    const/16 v6, 0x21

    .line 231
    invoke-virtual {p1}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v3

    .line 232
    .local v3, "start":I
    iget-object v4, p2, Lcom/android/mail/providers/Folder;->name:Ljava/lang/String;

    invoke-virtual {p1, v4}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 233
    invoke-virtual {p1}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v1

    .line 235
    .local v1, "end":I
    iget v4, p0, Lcom/android/mail/ui/FolderDisplayer;->mDefaultFgColor:I

    invoke-virtual {p2, v4}, Lcom/android/mail/providers/Folder;->getForegroundColor(I)I

    move-result v2

    .line 236
    .local v2, "fgColor":I
    iget v4, p0, Lcom/android/mail/ui/FolderDisplayer;->mDefaultBgColor:I

    invoke-virtual {p2, v4}, Lcom/android/mail/providers/Folder;->getBackgroundColor(I)I

    move-result v0

    .line 238
    .local v0, "bgColor":I
    new-instance v4, Landroid/text/style/BackgroundColorSpan;

    invoke-direct {v4, v0}, Landroid/text/style/BackgroundColorSpan;-><init>(I)V

    invoke-virtual {p1, v4, v3, v1, v6}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 240
    new-instance v4, Landroid/text/style/ForegroundColorSpan;

    invoke-direct {v4, v2}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    invoke-virtual {p1, v4, v3, v1, v6}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 242
    new-instance v4, Lcom/android/mail/browse/FolderSpan;

    iget-object v5, p0, Lcom/android/mail/browse/ConversationViewHeader$ConversationFolderDisplayer;->mDims:Lcom/android/mail/browse/FolderSpan$FolderSpanDimensions;

    invoke-direct {v4, p1, v5}, Lcom/android/mail/browse/FolderSpan;-><init>(Landroid/text/Spanned;Lcom/android/mail/browse/FolderSpan$FolderSpanDimensions;)V

    invoke-virtual {p1, v4, v3, v1, v6}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 244
    return-void
.end method


# virtual methods
.method public appendFolderSpans(Landroid/text/SpannableStringBuilder;)V
    .locals 6
    .param p1, "sb"    # Landroid/text/SpannableStringBuilder;

    .prologue
    .line 215
    iget-object v4, p0, Lcom/android/mail/ui/FolderDisplayer;->mFoldersSortedSet:Ljava/util/SortedSet;

    invoke-interface {v4}, Ljava/util/SortedSet;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/mail/providers/Folder;

    .line 216
    .local v1, "f":Lcom/android/mail/providers/Folder;
    invoke-direct {p0, p1, v1}, Lcom/android/mail/browse/ConversationViewHeader$ConversationFolderDisplayer;->addSpan(Landroid/text/SpannableStringBuilder;Lcom/android/mail/providers/Folder;)V

    goto :goto_0

    .line 219
    .end local v1    # "f":Lcom/android/mail/providers/Folder;
    :cond_0
    iget-object v4, p0, Lcom/android/mail/ui/FolderDisplayer;->mFoldersSortedSet:Ljava/util/SortedSet;

    invoke-interface {v4}, Ljava/util/SortedSet;->isEmpty()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 220
    invoke-static {}, Lcom/android/mail/providers/Folder;->newUnsafeInstance()Lcom/android/mail/providers/Folder;

    move-result-object v0

    .line 221
    .local v0, "addLabel":Lcom/android/mail/providers/Folder;
    iget-object v4, p0, Lcom/android/mail/ui/FolderDisplayer;->mContext:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    .line 222
    .local v3, "r":Landroid/content/res/Resources;
    const v4, 0x7f0c00ae

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v0, Lcom/android/mail/providers/Folder;->name:Ljava/lang/String;

    .line 223
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, ""

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const v5, 0x7f09001e

    invoke-virtual {v3, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    iput-object v4, v0, Lcom/android/mail/providers/Folder;->bgColor:Ljava/lang/String;

    .line 225
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, ""

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const v5, 0x7f09001d

    invoke-virtual {v3, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    iput-object v4, v0, Lcom/android/mail/providers/Folder;->fgColor:Ljava/lang/String;

    .line 226
    invoke-direct {p0, p1, v0}, Lcom/android/mail/browse/ConversationViewHeader$ConversationFolderDisplayer;->addSpan(Landroid/text/SpannableStringBuilder;Lcom/android/mail/providers/Folder;)V

    .line 228
    .end local v0    # "addLabel":Lcom/android/mail/providers/Folder;
    .end local v3    # "r":Landroid/content/res/Resources;
    :cond_1
    return-void
.end method
