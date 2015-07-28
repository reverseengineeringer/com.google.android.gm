.class public Lcom/android/mail/browse/MessageFooterView;
.super Landroid/widget/LinearLayout;
.source "MessageFooterView.java"

# interfaces
.implements Landroid/app/LoaderManager$LoaderCallbacks;
.implements Lcom/android/mail/browse/ConversationContainer$DetachListener;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/LinearLayout;",
        "Lcom/android/mail/browse/ConversationContainer$DetachListener;",
        "Landroid/app/LoaderManager$LoaderCallbacks",
        "<",
        "Landroid/database/Cursor;",
        ">;"
    }
.end annotation


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private mAttachmentBarList:Landroid/widget/LinearLayout;

.field private mAttachmentGrid:Lcom/android/mail/ui/AttachmentTileGrid;

.field private mAttachmentsCursor:Lcom/android/mail/browse/AttachmentLoader$AttachmentCursor;

.field private mFragmentManager:Landroid/app/FragmentManager;

.field private final mInflater:Landroid/view/LayoutInflater;

.field private mLoaderManager:Landroid/app/LoaderManager;

.field private mMessageHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

.field private mTitleBar:Landroid/view/View;

.field private mTitleText:Landroid/widget/TextView;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 64
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/browse/MessageFooterView;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 67
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/android/mail/browse/MessageFooterView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 68
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 71
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 73
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/MessageFooterView;->mInflater:Landroid/view/LayoutInflater;

    .line 74
    return-void
.end method

.method private getAttachmentLoaderId()Ljava/lang/Integer;
    .locals 3

    .prologue
    .line 208
    const/4 v0, 0x0

    .line 209
    .local v0, "id":Ljava/lang/Integer;
    iget-object v2, p0, Lcom/android/mail/browse/MessageFooterView;->mMessageHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    if-nez v2, :cond_1

    const/4 v1, 0x0

    .line 210
    .local v1, "msg":Lcom/android/mail/providers/Message;
    :goto_0
    if-eqz v1, :cond_0

    iget-boolean v2, v1, Lcom/android/mail/providers/Message;->hasAttachments:Z

    if-eqz v2, :cond_0

    iget-object v2, v1, Lcom/android/mail/providers/Message;->attachmentListUri:Landroid/net/Uri;

    if-eqz v2, :cond_0

    .line 211
    iget-object v2, v1, Lcom/android/mail/providers/Message;->attachmentListUri:Landroid/net/Uri;

    invoke-virtual {v2}, Landroid/net/Uri;->hashCode()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    .line 213
    :cond_0
    return-object v0

    .line 209
    .end local v1    # "msg":Lcom/android/mail/providers/Message;
    :cond_1
    iget-object v2, p0, Lcom/android/mail/browse/MessageFooterView;->mMessageHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    invoke-virtual {v2}, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->getMessage()Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    move-result-object v1

    goto :goto_0
.end method

.method private renderAttachments(Ljava/util/List;Z)V
    .locals 8
    .param p2, "loaderResult"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/android/mail/providers/Attachment;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .local p1, "attachments":Ljava/util/List;, "Ljava/util/List<Lcom/android/mail/providers/Attachment;>;"
    const/4 v7, 0x0

    .line 155
    if-eqz p1, :cond_0

    invoke-interface {p1}, Ljava/util/List;->isEmpty()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 178
    :cond_0
    :goto_0
    return-void

    .line 160
    :cond_1
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v3

    .line 161
    .local v3, "maxSize":I
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4, v3}, Ljava/util/ArrayList;-><init>(I)V

    .line 162
    .local v4, "tiledAttachments":Ljava/util/List;, "Ljava/util/List<Lcom/android/mail/providers/Attachment;>;"
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1, v3}, Ljava/util/ArrayList;-><init>(I)V

    .line 164
    .local v1, "barAttachments":Ljava/util/List;, "Ljava/util/List<Lcom/android/mail/providers/Attachment;>;"
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_3

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Attachment;

    .line 165
    .local v0, "attachment":Lcom/android/mail/providers/Attachment;
    invoke-static {v0}, Lcom/android/mail/ui/AttachmentTile;->isTiledAttachment(Lcom/android/mail/providers/Attachment;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 166
    invoke-interface {v4, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 168
    :cond_2
    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 171
    .end local v0    # "attachment":Lcom/android/mail/providers/Attachment;
    :cond_3
    iget-object v5, p0, Lcom/android/mail/browse/MessageFooterView;->mMessageHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    invoke-virtual {v5}, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->getMessage()Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    move-result-object v5

    invoke-static {p1}, Lcom/android/mail/providers/Attachment;->toJSONArray(Ljava/util/Collection;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, v5, Lcom/android/mail/providers/Message;->attachmentsJson:Ljava/lang/String;

    .line 173
    iget-object v5, p0, Lcom/android/mail/browse/MessageFooterView;->mTitleText:Landroid/widget/TextView;

    invoke-virtual {v5, v7}, Landroid/widget/TextView;->setVisibility(I)V

    .line 174
    iget-object v5, p0, Lcom/android/mail/browse/MessageFooterView;->mTitleBar:Landroid/view/View;

    invoke-virtual {v5, v7}, Landroid/view/View;->setVisibility(I)V

    .line 176
    invoke-direct {p0, v4, p2}, Lcom/android/mail/browse/MessageFooterView;->renderTiledAttachments(Ljava/util/List;Z)V

    .line 177
    invoke-direct {p0, v1, p2}, Lcom/android/mail/browse/MessageFooterView;->renderBarAttachments(Ljava/util/List;Z)V

    goto :goto_0
.end method

.method private renderAttachments(Z)V
    .locals 3
    .param p1, "loaderResult"    # Z

    .prologue
    .line 140
    iget-object v2, p0, Lcom/android/mail/browse/MessageFooterView;->mAttachmentsCursor:Lcom/android/mail/browse/AttachmentLoader$AttachmentCursor;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/android/mail/browse/MessageFooterView;->mAttachmentsCursor:Lcom/android/mail/browse/AttachmentLoader$AttachmentCursor;

    invoke-virtual {v2}, Lcom/android/mail/browse/AttachmentLoader$AttachmentCursor;->isClosed()Z

    move-result v2

    if-nez v2, :cond_0

    .line 141
    const/4 v1, -0x1

    .line 142
    .local v1, "i":I
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v0

    .line 143
    .local v0, "attachments":Ljava/util/List;, "Ljava/util/List<Lcom/android/mail/providers/Attachment;>;"
    :goto_0
    iget-object v2, p0, Lcom/android/mail/browse/MessageFooterView;->mAttachmentsCursor:Lcom/android/mail/browse/AttachmentLoader$AttachmentCursor;

    add-int/lit8 v1, v1, 0x1

    invoke-virtual {v2, v1}, Lcom/android/mail/browse/AttachmentLoader$AttachmentCursor;->moveToPosition(I)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 144
    iget-object v2, p0, Lcom/android/mail/browse/MessageFooterView;->mAttachmentsCursor:Lcom/android/mail/browse/AttachmentLoader$AttachmentCursor;

    invoke-virtual {v2}, Lcom/android/mail/browse/AttachmentLoader$AttachmentCursor;->get()Lcom/android/mail/providers/Attachment;

    move-result-object v2

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 149
    .end local v0    # "attachments":Ljava/util/List;, "Ljava/util/List<Lcom/android/mail/providers/Attachment;>;"
    .end local v1    # "i":I
    :cond_0
    iget-object v2, p0, Lcom/android/mail/browse/MessageFooterView;->mMessageHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    invoke-virtual {v2}, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->getMessage()Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    move-result-object v2

    invoke-virtual {v2}, Lcom/android/mail/browse/MessageCursor$ConversationMessage;->getAttachments()Ljava/util/List;

    move-result-object v0

    .line 151
    .restart local v0    # "attachments":Ljava/util/List;, "Ljava/util/List<Lcom/android/mail/providers/Attachment;>;"
    :cond_1
    invoke-direct {p0, v0, p1}, Lcom/android/mail/browse/MessageFooterView;->renderAttachments(Ljava/util/List;Z)V

    .line 152
    return-void
.end method

.method private renderBarAttachments(Ljava/util/List;Z)V
    .locals 6
    .param p2, "loaderResult"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/android/mail/providers/Attachment;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 189
    .local p1, "barAttachments":Ljava/util/List;, "Ljava/util/List<Lcom/android/mail/providers/Attachment;>;"
    iget-object v4, p0, Lcom/android/mail/browse/MessageFooterView;->mAttachmentBarList:Landroid/widget/LinearLayout;

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 191
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Attachment;

    .line 192
    .local v0, "attachment":Lcom/android/mail/providers/Attachment;
    invoke-virtual {v0}, Lcom/android/mail/providers/Attachment;->getIdentifierUri()Landroid/net/Uri;

    move-result-object v3

    .line 193
    .local v3, "id":Landroid/net/Uri;
    iget-object v4, p0, Lcom/android/mail/browse/MessageFooterView;->mAttachmentBarList:Landroid/widget/LinearLayout;

    invoke-virtual {v4, v3}, Landroid/widget/LinearLayout;->findViewWithTag(Ljava/lang/Object;)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/android/mail/browse/MessageAttachmentBar;

    .line 196
    .local v1, "barAttachmentView":Lcom/android/mail/browse/MessageAttachmentBar;
    if-nez v1, :cond_0

    .line 197
    iget-object v4, p0, Lcom/android/mail/browse/MessageFooterView;->mInflater:Landroid/view/LayoutInflater;

    invoke-static {v4, p0}, Lcom/android/mail/browse/MessageAttachmentBar;->inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Lcom/android/mail/browse/MessageAttachmentBar;

    move-result-object v1

    .line 198
    invoke-virtual {v1, v3}, Lcom/android/mail/browse/MessageAttachmentBar;->setTag(Ljava/lang/Object;)V

    .line 199
    iget-object v4, p0, Lcom/android/mail/browse/MessageFooterView;->mFragmentManager:Landroid/app/FragmentManager;

    invoke-virtual {v1, v4}, Lcom/android/mail/browse/MessageAttachmentBar;->initialize(Landroid/app/FragmentManager;)V

    .line 200
    iget-object v4, p0, Lcom/android/mail/browse/MessageFooterView;->mAttachmentBarList:Landroid/widget/LinearLayout;

    invoke-virtual {v4, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 203
    :cond_0
    invoke-virtual {v1, v0, p2}, Lcom/android/mail/browse/MessageAttachmentBar;->render(Lcom/android/mail/providers/Attachment;Z)V

    goto :goto_0

    .line 205
    .end local v0    # "attachment":Lcom/android/mail/providers/Attachment;
    .end local v1    # "barAttachmentView":Lcom/android/mail/browse/MessageAttachmentBar;
    .end local v3    # "id":Landroid/net/Uri;
    :cond_1
    return-void
.end method

.method private renderTiledAttachments(Ljava/util/List;Z)V
    .locals 3
    .param p2, "loaderResult"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/android/mail/providers/Attachment;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 181
    .local p1, "tiledAttachments":Ljava/util/List;, "Ljava/util/List<Lcom/android/mail/providers/Attachment;>;"
    iget-object v0, p0, Lcom/android/mail/browse/MessageFooterView;->mAttachmentGrid:Lcom/android/mail/ui/AttachmentTileGrid;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/android/mail/ui/AttachmentTileGrid;->setVisibility(I)V

    .line 184
    iget-object v0, p0, Lcom/android/mail/browse/MessageFooterView;->mAttachmentGrid:Lcom/android/mail/ui/AttachmentTileGrid;

    iget-object v1, p0, Lcom/android/mail/browse/MessageFooterView;->mFragmentManager:Landroid/app/FragmentManager;

    iget-object v2, p0, Lcom/android/mail/browse/MessageFooterView;->mMessageHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    invoke-virtual {v2}, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->getMessage()Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    move-result-object v2

    iget-object v2, v2, Lcom/android/mail/providers/Message;->attachmentListUri:Landroid/net/Uri;

    invoke-virtual {v0, v1, v2, p1, p2}, Lcom/android/mail/ui/AttachmentTileGrid;->configureGrid(Landroid/app/FragmentManager;Landroid/net/Uri;Ljava/util/List;Z)V

    .line 186
    return-void
.end method


# virtual methods
.method public bind(Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;Z)V
    .locals 7
    .param p1, "headerItem"    # Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;
    .param p2, "measureOnly"    # Z

    .prologue
    const/4 v2, 0x0

    const/16 v3, 0x8

    .line 96
    iget-object v4, p0, Lcom/android/mail/browse/MessageFooterView;->mMessageHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    if-eqz v4, :cond_0

    iget-object v4, p0, Lcom/android/mail/browse/MessageFooterView;->mMessageHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    invoke-virtual {v4}, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->getMessage()Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    move-result-object v4

    if-eqz v4, :cond_0

    iget-object v4, p0, Lcom/android/mail/browse/MessageFooterView;->mMessageHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    invoke-virtual {v4}, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->getMessage()Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    move-result-object v4

    iget-object v4, v4, Lcom/android/mail/providers/Message;->attachmentListUri:Landroid/net/Uri;

    if-eqz v4, :cond_0

    iget-object v4, p0, Lcom/android/mail/browse/MessageFooterView;->mMessageHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    invoke-virtual {v4}, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->getMessage()Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    move-result-object v4

    iget-object v4, v4, Lcom/android/mail/providers/Message;->attachmentListUri:Landroid/net/Uri;

    invoke-virtual {p1}, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->getMessage()Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    move-result-object v5

    iget-object v5, v5, Lcom/android/mail/providers/Message;->attachmentListUri:Landroid/net/Uri;

    invoke-virtual {v4, v5}, Landroid/net/Uri;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 101
    iget-object v4, p0, Lcom/android/mail/browse/MessageFooterView;->mAttachmentGrid:Lcom/android/mail/ui/AttachmentTileGrid;

    invoke-virtual {v4}, Lcom/android/mail/ui/AttachmentTileGrid;->removeAllViewsInLayout()V

    .line 102
    iget-object v4, p0, Lcom/android/mail/browse/MessageFooterView;->mAttachmentBarList:Landroid/widget/LinearLayout;

    invoke-virtual {v4}, Landroid/widget/LinearLayout;->removeAllViewsInLayout()V

    .line 103
    iget-object v4, p0, Lcom/android/mail/browse/MessageFooterView;->mTitleText:Landroid/widget/TextView;

    invoke-virtual {v4, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 104
    iget-object v4, p0, Lcom/android/mail/browse/MessageFooterView;->mTitleBar:Landroid/view/View;

    invoke-virtual {v4, v3}, Landroid/view/View;->setVisibility(I)V

    .line 105
    iget-object v4, p0, Lcom/android/mail/browse/MessageFooterView;->mAttachmentGrid:Lcom/android/mail/ui/AttachmentTileGrid;

    invoke-virtual {v4, v3}, Lcom/android/mail/ui/AttachmentTileGrid;->setVisibility(I)V

    .line 106
    iget-object v4, p0, Lcom/android/mail/browse/MessageFooterView;->mAttachmentBarList:Landroid/widget/LinearLayout;

    invoke-virtual {v4, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 111
    :cond_0
    invoke-direct {p0}, Lcom/android/mail/browse/MessageFooterView;->getAttachmentLoaderId()Ljava/lang/Integer;

    move-result-object v1

    .line 113
    .local v1, "oldAttachmentLoaderId":Ljava/lang/Integer;
    iput-object p1, p0, Lcom/android/mail/browse/MessageFooterView;->mMessageHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    .line 115
    invoke-direct {p0}, Lcom/android/mail/browse/MessageFooterView;->getAttachmentLoaderId()Ljava/lang/Integer;

    move-result-object v0

    .line 117
    .local v0, "attachmentLoaderId":Ljava/lang/Integer;
    if-eqz v1, :cond_1

    invoke-static {v1, v0}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 119
    iget-object v4, p0, Lcom/android/mail/browse/MessageFooterView;->mLoaderManager:Landroid/app/LoaderManager;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v5

    invoke-virtual {v4, v5}, Landroid/app/LoaderManager;->destroyLoader(I)V

    .line 124
    :cond_1
    if-nez p2, :cond_2

    if-eqz v0, :cond_2

    .line 125
    sget-object v4, Lcom/android/mail/browse/MessageFooterView;->LOG_TAG:Ljava/lang/String;

    const-string v5, "binding footer view, calling initLoader for message %d"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    aput-object v0, v6, v2

    invoke-static {v4, v5, v6}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 127
    iget-object v4, p0, Lcom/android/mail/browse/MessageFooterView;->mLoaderManager:Landroid/app/LoaderManager;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v5

    sget-object v6, Landroid/os/Bundle;->EMPTY:Landroid/os/Bundle;

    invoke-virtual {v4, v5, v6, p0}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    .line 131
    :cond_2
    iget-object v4, p0, Lcom/android/mail/browse/MessageFooterView;->mAttachmentGrid:Lcom/android/mail/ui/AttachmentTileGrid;

    invoke-virtual {v4}, Lcom/android/mail/ui/AttachmentTileGrid;->getChildCount()I

    move-result v4

    if-nez v4, :cond_3

    iget-object v4, p0, Lcom/android/mail/browse/MessageFooterView;->mAttachmentBarList:Landroid/widget/LinearLayout;

    invoke-virtual {v4}, Landroid/widget/LinearLayout;->getChildCount()I

    move-result v4

    if-nez v4, :cond_3

    .line 133
    invoke-direct {p0, v2}, Lcom/android/mail/browse/MessageFooterView;->renderAttachments(Z)V

    .line 135
    :cond_3
    iget-object v4, p0, Lcom/android/mail/browse/MessageFooterView;->mMessageHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    invoke-virtual {v4}, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->isExpanded()Z

    move-result v4

    if-eqz v4, :cond_4

    :goto_0
    invoke-virtual {p0, v2}, Lcom/android/mail/browse/MessageFooterView;->setVisibility(I)V

    .line 136
    return-void

    :cond_4
    move v2, v3

    .line 135
    goto :goto_0
.end method

.method public initialize(Landroid/app/LoaderManager;Landroid/app/FragmentManager;)V
    .locals 0
    .param p1, "loaderManager"    # Landroid/app/LoaderManager;
    .param p2, "fragmentManager"    # Landroid/app/FragmentManager;

    .prologue
    .line 87
    iput-object p1, p0, Lcom/android/mail/browse/MessageFooterView;->mLoaderManager:Landroid/app/LoaderManager;

    .line 88
    iput-object p2, p0, Lcom/android/mail/browse/MessageFooterView;->mFragmentManager:Landroid/app/FragmentManager;

    .line 89
    return-void
.end method

.method public onCreateLoader(ILandroid/os/Bundle;)Landroid/content/Loader;
    .locals 3
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
    .line 223
    new-instance v0, Lcom/android/mail/browse/AttachmentLoader;

    invoke-virtual {p0}, Lcom/android/mail/browse/MessageFooterView;->getContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/browse/MessageFooterView;->mMessageHeaderItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    invoke-virtual {v2}, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->getMessage()Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    move-result-object v2

    iget-object v2, v2, Lcom/android/mail/providers/Message;->attachmentListUri:Landroid/net/Uri;

    invoke-direct {v0, v1, v2}, Lcom/android/mail/browse/AttachmentLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;)V

    return-object v0
.end method

.method public onDetachedFromParent()V
    .locals 0

    .prologue
    .line 219
    return-void
.end method

.method protected onFinishInflate()V
    .locals 1

    .prologue
    .line 78
    invoke-super {p0}, Landroid/widget/LinearLayout;->onFinishInflate()V

    .line 80
    const v0, 0x7f10008a

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageFooterView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/android/mail/browse/MessageFooterView;->mTitleText:Landroid/widget/TextView;

    .line 81
    const v0, 0x7f10008b

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageFooterView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/MessageFooterView;->mTitleBar:Landroid/view/View;

    .line 82
    const v0, 0x7f100052

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageFooterView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/android/mail/ui/AttachmentTileGrid;

    iput-object v0, p0, Lcom/android/mail/browse/MessageFooterView;->mAttachmentGrid:Lcom/android/mail/ui/AttachmentTileGrid;

    .line 83
    const v0, 0x7f100053

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageFooterView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/android/mail/browse/MessageFooterView;->mAttachmentBarList:Landroid/widget/LinearLayout;

    .line 84
    return-void
.end method

.method public onLoadFinished(Landroid/content/Loader;Landroid/database/Cursor;)V
    .locals 1
    .param p2, "data"    # Landroid/database/Cursor;
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
    .line 229
    .local p1, "loader":Landroid/content/Loader;, "Landroid/content/Loader<Landroid/database/Cursor;>;"
    check-cast p2, Lcom/android/mail/browse/AttachmentLoader$AttachmentCursor;

    .end local p2    # "data":Landroid/database/Cursor;
    iput-object p2, p0, Lcom/android/mail/browse/MessageFooterView;->mAttachmentsCursor:Lcom/android/mail/browse/AttachmentLoader$AttachmentCursor;

    .line 231
    iget-object v0, p0, Lcom/android/mail/browse/MessageFooterView;->mAttachmentsCursor:Lcom/android/mail/browse/AttachmentLoader$AttachmentCursor;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/browse/MessageFooterView;->mAttachmentsCursor:Lcom/android/mail/browse/AttachmentLoader$AttachmentCursor;

    invoke-virtual {v0}, Lcom/android/mail/browse/AttachmentLoader$AttachmentCursor;->isClosed()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 236
    :cond_0
    :goto_0
    return-void

    .line 235
    :cond_1
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/android/mail/browse/MessageFooterView;->renderAttachments(Z)V

    goto :goto_0
.end method

.method public bridge synthetic onLoadFinished(Landroid/content/Loader;Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Landroid/content/Loader;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 50
    check-cast p2, Landroid/database/Cursor;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/android/mail/browse/MessageFooterView;->onLoadFinished(Landroid/content/Loader;Landroid/database/Cursor;)V

    return-void
.end method

.method public onLoaderReset(Landroid/content/Loader;)V
    .locals 1
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
    .line 240
    .local p1, "loader":Landroid/content/Loader;, "Landroid/content/Loader<Landroid/database/Cursor;>;"
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/mail/browse/MessageFooterView;->mAttachmentsCursor:Lcom/android/mail/browse/AttachmentLoader$AttachmentCursor;

    .line 241
    return-void
.end method
