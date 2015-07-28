.class public Lcom/android/mail/browse/ConversationViewAdapter$MessageFooterItem;
.super Lcom/android/mail/browse/ConversationOverlayItem;
.source "ConversationViewAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/browse/ConversationViewAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "MessageFooterItem"
.end annotation


# instance fields
.field private final headerItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

.field final synthetic this$0:Lcom/android/mail/browse/ConversationViewAdapter;


# direct methods
.method private constructor <init>(Lcom/android/mail/browse/ConversationViewAdapter;Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;)V
    .locals 0
    .param p2, "item"    # Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    .prologue
    .line 219
    iput-object p1, p0, Lcom/android/mail/browse/ConversationViewAdapter$MessageFooterItem;->this$0:Lcom/android/mail/browse/ConversationViewAdapter;

    invoke-direct {p0}, Lcom/android/mail/browse/ConversationOverlayItem;-><init>()V

    .line 220
    iput-object p2, p0, Lcom/android/mail/browse/ConversationViewAdapter$MessageFooterItem;->headerItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    .line 221
    return-void
.end method

.method synthetic constructor <init>(Lcom/android/mail/browse/ConversationViewAdapter;Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;Lcom/android/mail/browse/ConversationViewAdapter$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/android/mail/browse/ConversationViewAdapter;
    .param p2, "x1"    # Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;
    .param p3, "x2"    # Lcom/android/mail/browse/ConversationViewAdapter$1;

    .prologue
    .line 212
    invoke-direct {p0, p1, p2}, Lcom/android/mail/browse/ConversationViewAdapter$MessageFooterItem;-><init>(Lcom/android/mail/browse/ConversationViewAdapter;Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;)V

    return-void
.end method


# virtual methods
.method public bindView(Landroid/view/View;Z)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;
    .param p2, "measureOnly"    # Z

    .prologue
    .line 238
    move-object v0, p1

    check-cast v0, Lcom/android/mail/browse/MessageFooterView;

    .line 239
    .local v0, "attachmentsView":Lcom/android/mail/browse/MessageFooterView;
    iget-object v1, p0, Lcom/android/mail/browse/ConversationViewAdapter$MessageFooterItem;->headerItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    invoke-virtual {v0, v1, p2}, Lcom/android/mail/browse/MessageFooterView;->bind(Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;Z)V

    .line 240
    return-void
.end method

.method public createView(Landroid/content/Context;Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "inflater"    # Landroid/view/LayoutInflater;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 230
    const v1, 0x7f04002a

    const/4 v2, 0x0

    invoke-virtual {p2, v1, p3, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/android/mail/browse/MessageFooterView;

    .line 232
    .local v0, "v":Lcom/android/mail/browse/MessageFooterView;
    iget-object v1, p0, Lcom/android/mail/browse/ConversationViewAdapter$MessageFooterItem;->this$0:Lcom/android/mail/browse/ConversationViewAdapter;

    # getter for: Lcom/android/mail/browse/ConversationViewAdapter;->mLoaderManager:Landroid/app/LoaderManager;
    invoke-static {v1}, Lcom/android/mail/browse/ConversationViewAdapter;->access$600(Lcom/android/mail/browse/ConversationViewAdapter;)Landroid/app/LoaderManager;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/browse/ConversationViewAdapter$MessageFooterItem;->this$0:Lcom/android/mail/browse/ConversationViewAdapter;

    # getter for: Lcom/android/mail/browse/ConversationViewAdapter;->mFragmentManager:Landroid/app/FragmentManager;
    invoke-static {v2}, Lcom/android/mail/browse/ConversationViewAdapter;->access$700(Lcom/android/mail/browse/ConversationViewAdapter;)Landroid/app/FragmentManager;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/android/mail/browse/MessageFooterView;->initialize(Landroid/app/LoaderManager;Landroid/app/FragmentManager;)V

    .line 233
    return-object v0
.end method

.method public getGravity()I
    .locals 1

    .prologue
    .line 251
    const/16 v0, 0x30

    return v0
.end method

.method public getHeight()I
    .locals 1

    .prologue
    .line 258
    iget-object v0, p0, Lcom/android/mail/browse/ConversationViewAdapter$MessageFooterItem;->headerItem:Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;

    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->isExpanded()Z

    move-result v0

    if-nez v0, :cond_0

    .line 259
    const/4 v0, 0x0

    .line 261
    :goto_0
    return v0

    :cond_0
    invoke-super {p0}, Lcom/android/mail/browse/ConversationOverlayItem;->getHeight()I

    move-result v0

    goto :goto_0
.end method

.method public getType()I
    .locals 1

    .prologue
    .line 225
    const/4 v0, 0x2

    return v0
.end method

.method public isContiguous()Z
    .locals 1

    .prologue
    .line 244
    const/4 v0, 0x1

    return v0
.end method
