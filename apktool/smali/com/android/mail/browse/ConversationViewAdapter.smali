.class public Lcom/android/mail/browse/ConversationViewAdapter;
.super Landroid/widget/BaseAdapter;
.source "ConversationViewAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/browse/ConversationViewAdapter$1;,
        Lcom/android/mail/browse/ConversationViewAdapter$SuperCollapsedBlockItem;,
        Lcom/android/mail/browse/ConversationViewAdapter$MessageFooterItem;,
        Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;,
        Lcom/android/mail/browse/ConversationViewAdapter$ConversationHeaderItem;,
        Lcom/android/mail/browse/ConversationViewAdapter$ConversationAccountController;
    }
.end annotation


# instance fields
.field private final mAccountController:Lcom/android/mail/browse/ConversationViewAdapter$ConversationAccountController;

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

.field private final mContactInfoSource:Lcom/android/mail/ContactInfoSource;

.field private mContext:Landroid/content/Context;

.field private mConversationCallbacks:Lcom/android/mail/browse/ConversationViewHeader$ConversationViewHeaderCallbacks;

.field private final mDateBuilder:Lcom/android/mail/FormattedDateBuilder;

.field private final mFragmentManager:Landroid/app/FragmentManager;

.field private final mInflater:Landroid/view/LayoutInflater;

.field private final mItems:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/android/mail/browse/ConversationOverlayItem;",
            ">;"
        }
    .end annotation
.end field

.field private final mLoaderManager:Landroid/app/LoaderManager;

.field private final mMessageCallbacks:Lcom/android/mail/browse/MessageHeaderView$MessageHeaderViewCallbacks;

.field private mSuperCollapsedListener:Lcom/android/mail/browse/SuperCollapsedBlock$OnClickListener;


# direct methods
.method public constructor <init>(Lcom/android/mail/ui/ControllableActivity;Lcom/android/mail/browse/ConversationViewAdapter$ConversationAccountController;Landroid/app/LoaderManager;Lcom/android/mail/browse/MessageHeaderView$MessageHeaderViewCallbacks;Lcom/android/mail/ContactInfoSource;Lcom/android/mail/browse/ConversationViewHeader$ConversationViewHeaderCallbacks;Lcom/android/mail/browse/SuperCollapsedBlock$OnClickListener;Ljava/util/Map;Lcom/android/mail/FormattedDateBuilder;)V
    .locals 1
    .param p1, "controllableActivity"    # Lcom/android/mail/ui/ControllableActivity;
    .param p2, "accountController"    # Lcom/android/mail/browse/ConversationViewAdapter$ConversationAccountController;
    .param p3, "loaderManager"    # Landroid/app/LoaderManager;
    .param p4, "messageCallbacks"    # Lcom/android/mail/browse/MessageHeaderView$MessageHeaderViewCallbacks;
    .param p5, "contactInfoSource"    # Lcom/android/mail/ContactInfoSource;
    .param p6, "convCallbacks"    # Lcom/android/mail/browse/ConversationViewHeader$ConversationViewHeaderCallbacks;
    .param p7, "scbListener"    # Lcom/android/mail/browse/SuperCollapsedBlock$OnClickListener;
    .param p9, "dateBuilder"    # Lcom/android/mail/FormattedDateBuilder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/android/mail/ui/ControllableActivity;",
            "Lcom/android/mail/browse/ConversationViewAdapter$ConversationAccountController;",
            "Landroid/app/LoaderManager;",
            "Lcom/android/mail/browse/MessageHeaderView$MessageHeaderViewCallbacks;",
            "Lcom/android/mail/ContactInfoSource;",
            "Lcom/android/mail/browse/ConversationViewHeader$ConversationViewHeaderCallbacks;",
            "Lcom/android/mail/browse/SuperCollapsedBlock$OnClickListener;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/android/mail/providers/Address;",
            ">;",
            "Lcom/android/mail/FormattedDateBuilder;",
            ")V"
        }
    .end annotation

    .prologue
    .line 320
    .local p8, "addressCache":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/android/mail/providers/Address;>;"
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 321
    invoke-interface {p1}, Lcom/android/mail/ui/ControllableActivity;->getActivityContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/ConversationViewAdapter;->mContext:Landroid/content/Context;

    .line 322
    iput-object p9, p0, Lcom/android/mail/browse/ConversationViewAdapter;->mDateBuilder:Lcom/android/mail/FormattedDateBuilder;

    .line 323
    iput-object p2, p0, Lcom/android/mail/browse/ConversationViewAdapter;->mAccountController:Lcom/android/mail/browse/ConversationViewAdapter$ConversationAccountController;

    .line 324
    iput-object p3, p0, Lcom/android/mail/browse/ConversationViewAdapter;->mLoaderManager:Landroid/app/LoaderManager;

    .line 325
    invoke-interface {p1}, Lcom/android/mail/ui/ControllableActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/ConversationViewAdapter;->mFragmentManager:Landroid/app/FragmentManager;

    .line 326
    iput-object p4, p0, Lcom/android/mail/browse/ConversationViewAdapter;->mMessageCallbacks:Lcom/android/mail/browse/MessageHeaderView$MessageHeaderViewCallbacks;

    .line 327
    iput-object p5, p0, Lcom/android/mail/browse/ConversationViewAdapter;->mContactInfoSource:Lcom/android/mail/ContactInfoSource;

    .line 328
    iput-object p6, p0, Lcom/android/mail/browse/ConversationViewAdapter;->mConversationCallbacks:Lcom/android/mail/browse/ConversationViewHeader$ConversationViewHeaderCallbacks;

    .line 329
    iput-object p7, p0, Lcom/android/mail/browse/ConversationViewAdapter;->mSuperCollapsedListener:Lcom/android/mail/browse/SuperCollapsedBlock$OnClickListener;

    .line 330
    iput-object p8, p0, Lcom/android/mail/browse/ConversationViewAdapter;->mAddressCache:Ljava/util/Map;

    .line 331
    iget-object v0, p0, Lcom/android/mail/browse/ConversationViewAdapter;->mContext:Landroid/content/Context;

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/ConversationViewAdapter;->mInflater:Landroid/view/LayoutInflater;

    .line 333
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/ConversationViewAdapter;->mItems:Ljava/util/List;

    .line 334
    return-void
.end method

.method static synthetic access$000(Lcom/android/mail/browse/ConversationViewAdapter;)Lcom/android/mail/browse/ConversationViewHeader$ConversationViewHeaderCallbacks;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/browse/ConversationViewAdapter;

    .prologue
    .line 59
    iget-object v0, p0, Lcom/android/mail/browse/ConversationViewAdapter;->mConversationCallbacks:Lcom/android/mail/browse/ConversationViewHeader$ConversationViewHeaderCallbacks;

    return-object v0
.end method

.method static synthetic access$100(Lcom/android/mail/browse/ConversationViewAdapter;)Lcom/android/mail/browse/ConversationViewAdapter$ConversationAccountController;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/browse/ConversationViewAdapter;

    .prologue
    .line 59
    iget-object v0, p0, Lcom/android/mail/browse/ConversationViewAdapter;->mAccountController:Lcom/android/mail/browse/ConversationViewAdapter$ConversationAccountController;

    return-object v0
.end method

.method static synthetic access$200(Lcom/android/mail/browse/ConversationViewAdapter;)Lcom/android/mail/FormattedDateBuilder;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/browse/ConversationViewAdapter;

    .prologue
    .line 59
    iget-object v0, p0, Lcom/android/mail/browse/ConversationViewAdapter;->mDateBuilder:Lcom/android/mail/FormattedDateBuilder;

    return-object v0
.end method

.method static synthetic access$300(Lcom/android/mail/browse/ConversationViewAdapter;)Ljava/util/Map;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/browse/ConversationViewAdapter;

    .prologue
    .line 59
    iget-object v0, p0, Lcom/android/mail/browse/ConversationViewAdapter;->mAddressCache:Ljava/util/Map;

    return-object v0
.end method

.method static synthetic access$400(Lcom/android/mail/browse/ConversationViewAdapter;)Lcom/android/mail/browse/MessageHeaderView$MessageHeaderViewCallbacks;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/browse/ConversationViewAdapter;

    .prologue
    .line 59
    iget-object v0, p0, Lcom/android/mail/browse/ConversationViewAdapter;->mMessageCallbacks:Lcom/android/mail/browse/MessageHeaderView$MessageHeaderViewCallbacks;

    return-object v0
.end method

.method static synthetic access$500(Lcom/android/mail/browse/ConversationViewAdapter;)Lcom/android/mail/ContactInfoSource;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/browse/ConversationViewAdapter;

    .prologue
    .line 59
    iget-object v0, p0, Lcom/android/mail/browse/ConversationViewAdapter;->mContactInfoSource:Lcom/android/mail/ContactInfoSource;

    return-object v0
.end method

.method static synthetic access$600(Lcom/android/mail/browse/ConversationViewAdapter;)Landroid/app/LoaderManager;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/browse/ConversationViewAdapter;

    .prologue
    .line 59
    iget-object v0, p0, Lcom/android/mail/browse/ConversationViewAdapter;->mLoaderManager:Landroid/app/LoaderManager;

    return-object v0
.end method

.method static synthetic access$700(Lcom/android/mail/browse/ConversationViewAdapter;)Landroid/app/FragmentManager;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/browse/ConversationViewAdapter;

    .prologue
    .line 59
    iget-object v0, p0, Lcom/android/mail/browse/ConversationViewAdapter;->mFragmentManager:Landroid/app/FragmentManager;

    return-object v0
.end method

.method static synthetic access$800(Lcom/android/mail/browse/ConversationViewAdapter;)Lcom/android/mail/browse/SuperCollapsedBlock$OnClickListener;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/browse/ConversationViewAdapter;

    .prologue
    .line 59
    iget-object v0, p0, Lcom/android/mail/browse/ConversationViewAdapter;->mSuperCollapsedListener:Lcom/android/mail/browse/SuperCollapsedBlock$OnClickListener;

    return-object v0
.end method


# virtual methods
.method public addConversationHeader(Lcom/android/mail/providers/Conversation;)I
    .locals 2
    .param p1, "conv"    # Lcom/android/mail/providers/Conversation;

    .prologue
    .line 392
    new-instance v0, Lcom/android/mail/browse/ConversationViewAdapter$ConversationHeaderItem;

    const/4 v1, 0x0

    invoke-direct {v0, p0, p1, v1}, Lcom/android/mail/browse/ConversationViewAdapter$ConversationHeaderItem;-><init>(Lcom/android/mail/browse/ConversationViewAdapter;Lcom/android/mail/providers/Conversation;Lcom/android/mail/browse/ConversationViewAdapter$1;)V

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/ConversationViewAdapter;->addItem(Lcom/android/mail/browse/ConversationOverlayItem;)I

    move-result v0

    return v0
.end method

.method public addItem(Lcom/android/mail/browse/ConversationOverlayItem;)I
    .locals 2
    .param p1, "item"    # Lcom/android/mail/browse/ConversationOverlayItem;

    .prologue
    .line 381
    iget-object v1, p0, Lcom/android/mail/browse/ConversationViewAdapter;->mItems:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v0

    .line 382
    .local v0, "pos":I
    iget-object v1, p0, Lcom/android/mail/browse/ConversationViewAdapter;->mItems:Ljava/util/List;

    invoke-interface {v1, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 383
    return v0
.end method

.method public addMessageFooter(Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;)I
    .locals 2
    .param p1, "headerItem"    # Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    .prologue
    .line 400
    new-instance v0, Lcom/android/mail/browse/ConversationViewAdapter$MessageFooterItem;

    const/4 v1, 0x0

    invoke-direct {v0, p0, p1, v1}, Lcom/android/mail/browse/ConversationViewAdapter$MessageFooterItem;-><init>(Lcom/android/mail/browse/ConversationViewAdapter;Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;Lcom/android/mail/browse/ConversationViewAdapter$1;)V

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/ConversationViewAdapter;->addItem(Lcom/android/mail/browse/ConversationOverlayItem;)I

    move-result v0

    return v0
.end method

.method public addMessageHeader(Lcom/android/mail/browse/MessageCursor$ConversationMessage;Z)I
    .locals 1
    .param p1, "msg"    # Lcom/android/mail/browse/MessageCursor$ConversationMessage;
    .param p2, "expanded"    # Z

    .prologue
    .line 396
    new-instance v0, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    invoke-direct {v0, p0, p1, p2}, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;-><init>(Lcom/android/mail/browse/ConversationViewAdapter;Lcom/android/mail/browse/MessageCursor$ConversationMessage;Z)V

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/ConversationViewAdapter;->addItem(Lcom/android/mail/browse/ConversationOverlayItem;)I

    move-result v0

    return v0
.end method

.method public addSuperCollapsedBlock(II)I
    .locals 2
    .param p1, "start"    # I
    .param p2, "end"    # I

    .prologue
    .line 412
    new-instance v0, Lcom/android/mail/browse/ConversationViewAdapter$SuperCollapsedBlockItem;

    const/4 v1, 0x0

    invoke-direct {v0, p0, p1, p2, v1}, Lcom/android/mail/browse/ConversationViewAdapter$SuperCollapsedBlockItem;-><init>(Lcom/android/mail/browse/ConversationViewAdapter;IILcom/android/mail/browse/ConversationViewAdapter$1;)V

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/ConversationViewAdapter;->addItem(Lcom/android/mail/browse/ConversationOverlayItem;)I

    move-result v0

    return v0
.end method

.method public clear()V
    .locals 1

    .prologue
    .line 387
    iget-object v0, p0, Lcom/android/mail/browse/ConversationViewAdapter;->mItems:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 388
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationViewAdapter;->notifyDataSetChanged()V

    .line 389
    return-void
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 338
    iget-object v0, p0, Lcom/android/mail/browse/ConversationViewAdapter;->mItems:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getItem(I)Lcom/android/mail/browse/ConversationOverlayItem;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 353
    iget-object v0, p0, Lcom/android/mail/browse/ConversationViewAdapter;->mItems:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/browse/ConversationOverlayItem;

    return-object v0
.end method

.method public bridge synthetic getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 59
    invoke-virtual {p0, p1}, Lcom/android/mail/browse/ConversationViewAdapter;->getItem(I)Lcom/android/mail/browse/ConversationOverlayItem;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 358
    int-to-long v0, p1

    return-wide v0
.end method

.method public getItemViewType(I)I
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 343
    iget-object v0, p0, Lcom/android/mail/browse/ConversationViewAdapter;->mItems:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/browse/ConversationOverlayItem;

    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationOverlayItem;->getType()I

    move-result v0

    return v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 2
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 363
    invoke-virtual {p0, p1}, Lcom/android/mail/browse/ConversationViewAdapter;->getItem(I)Lcom/android/mail/browse/ConversationOverlayItem;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {p0, v0, p2, p3, v1}, Lcom/android/mail/browse/ConversationViewAdapter;->getView(Lcom/android/mail/browse/ConversationOverlayItem;Landroid/view/View;Landroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public getView(Lcom/android/mail/browse/ConversationOverlayItem;Landroid/view/View;Landroid/view/ViewGroup;Z)Landroid/view/View;
    .locals 3
    .param p1, "item"    # Lcom/android/mail/browse/ConversationOverlayItem;
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;
    .param p4, "measureOnly"    # Z

    .prologue
    .line 370
    if-nez p2, :cond_0

    .line 371
    iget-object v1, p0, Lcom/android/mail/browse/ConversationViewAdapter;->mContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/android/mail/browse/ConversationViewAdapter;->mInflater:Landroid/view/LayoutInflater;

    invoke-virtual {p1, v1, v2, p3}, Lcom/android/mail/browse/ConversationOverlayItem;->createView(Landroid/content/Context;Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 375
    .local v0, "v":Landroid/view/View;
    :goto_0
    invoke-virtual {p1, v0, p4}, Lcom/android/mail/browse/ConversationOverlayItem;->bindView(Landroid/view/View;Z)V

    .line 377
    return-object v0

    .line 373
    .end local v0    # "v":Landroid/view/View;
    :cond_0
    move-object v0, p2

    .restart local v0    # "v":Landroid/view/View;
    goto :goto_0
.end method

.method public getViewTypeCount()I
    .locals 1

    .prologue
    .line 348
    const/4 v0, 0x4

    return v0
.end method

.method public newMessageFooterItem(Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;)Lcom/android/mail/browse/ConversationViewAdapter$MessageFooterItem;
    .locals 2
    .param p1, "headerItem"    # Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    .prologue
    .line 408
    new-instance v0, Lcom/android/mail/browse/ConversationViewAdapter$MessageFooterItem;

    const/4 v1, 0x0

    invoke-direct {v0, p0, p1, v1}, Lcom/android/mail/browse/ConversationViewAdapter$MessageFooterItem;-><init>(Lcom/android/mail/browse/ConversationViewAdapter;Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;Lcom/android/mail/browse/ConversationViewAdapter$1;)V

    return-object v0
.end method

.method public newMessageHeaderItem(Lcom/android/mail/browse/MessageCursor$ConversationMessage;Z)Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;
    .locals 1
    .param p1, "message"    # Lcom/android/mail/browse/MessageCursor$ConversationMessage;
    .param p2, "expanded"    # Z

    .prologue
    .line 404
    new-instance v0, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    invoke-direct {v0, p0, p1, p2}, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;-><init>(Lcom/android/mail/browse/ConversationViewAdapter;Lcom/android/mail/browse/MessageCursor$ConversationMessage;Z)V

    return-object v0
.end method

.method public replaceSuperCollapsedBlock(Lcom/android/mail/browse/ConversationViewAdapter$SuperCollapsedBlockItem;Ljava/util/Collection;)V
    .locals 2
    .param p1, "blockToRemove"    # Lcom/android/mail/browse/ConversationViewAdapter$SuperCollapsedBlockItem;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/android/mail/browse/ConversationViewAdapter$SuperCollapsedBlockItem;",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/browse/ConversationOverlayItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 417
    .local p2, "replacements":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/browse/ConversationOverlayItem;>;"
    iget-object v1, p0, Lcom/android/mail/browse/ConversationViewAdapter;->mItems:Ljava/util/List;

    invoke-interface {v1, p1}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v0

    .line 418
    .local v0, "pos":I
    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 424
    :goto_0
    return-void

    .line 422
    :cond_0
    iget-object v1, p0, Lcom/android/mail/browse/ConversationViewAdapter;->mItems:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    .line 423
    iget-object v1, p0, Lcom/android/mail/browse/ConversationViewAdapter;->mItems:Ljava/util/List;

    invoke-interface {v1, v0, p2}, Ljava/util/List;->addAll(ILjava/util/Collection;)Z

    goto :goto_0
.end method

.method public updateItemsForMessage(Lcom/android/mail/browse/MessageCursor$ConversationMessage;Ljava/util/List;)V
    .locals 4
    .param p1, "message"    # Lcom/android/mail/browse/MessageCursor$ConversationMessage;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/android/mail/browse/MessageCursor$ConversationMessage;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 428
    .local p2, "affectedPositions":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    const/4 v0, 0x0

    .local v0, "i":I
    iget-object v3, p0, Lcom/android/mail/browse/ConversationViewAdapter;->mItems:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v2

    .local v2, "len":I
    :goto_0
    if-ge v0, v2, :cond_1

    .line 429
    iget-object v3, p0, Lcom/android/mail/browse/ConversationViewAdapter;->mItems:Ljava/util/List;

    invoke-interface {v3, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/mail/browse/ConversationOverlayItem;

    .line 430
    .local v1, "item":Lcom/android/mail/browse/ConversationOverlayItem;
    invoke-virtual {v1, p1}, Lcom/android/mail/browse/ConversationOverlayItem;->belongsToMessage(Lcom/android/mail/browse/MessageCursor$ConversationMessage;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 431
    invoke-virtual {v1, p1}, Lcom/android/mail/browse/ConversationOverlayItem;->setMessage(Lcom/android/mail/browse/MessageCursor$ConversationMessage;)V

    .line 432
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {p2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 428
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 435
    .end local v1    # "item":Lcom/android/mail/browse/ConversationOverlayItem;
    :cond_1
    return-void
.end method
