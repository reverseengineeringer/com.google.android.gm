.class public Lcom/android/mail/browse/ConversationViewAdapter$ConversationHeaderItem;
.super Lcom/android/mail/browse/ConversationOverlayItem;
.source "ConversationViewAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/browse/ConversationViewAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "ConversationHeaderItem"
.end annotation


# instance fields
.field public final mConversation:Lcom/android/mail/providers/Conversation;

.field final synthetic this$0:Lcom/android/mail/browse/ConversationViewAdapter;


# direct methods
.method private constructor <init>(Lcom/android/mail/browse/ConversationViewAdapter;Lcom/android/mail/providers/Conversation;)V
    .locals 0
    .param p2, "conv"    # Lcom/android/mail/providers/Conversation;

    .prologue
    .line 88
    iput-object p1, p0, Lcom/android/mail/browse/ConversationViewAdapter$ConversationHeaderItem;->this$0:Lcom/android/mail/browse/ConversationViewAdapter;

    invoke-direct {p0}, Lcom/android/mail/browse/ConversationOverlayItem;-><init>()V

    .line 89
    iput-object p2, p0, Lcom/android/mail/browse/ConversationViewAdapter$ConversationHeaderItem;->mConversation:Lcom/android/mail/providers/Conversation;

    .line 90
    return-void
.end method

.method synthetic constructor <init>(Lcom/android/mail/browse/ConversationViewAdapter;Lcom/android/mail/providers/Conversation;Lcom/android/mail/browse/ConversationViewAdapter$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/android/mail/browse/ConversationViewAdapter;
    .param p2, "x1"    # Lcom/android/mail/providers/Conversation;
    .param p3, "x2"    # Lcom/android/mail/browse/ConversationViewAdapter$1;

    .prologue
    .line 85
    invoke-direct {p0, p1, p2}, Lcom/android/mail/browse/ConversationViewAdapter$ConversationHeaderItem;-><init>(Lcom/android/mail/browse/ConversationViewAdapter;Lcom/android/mail/providers/Conversation;)V

    return-void
.end method


# virtual methods
.method public bindView(Landroid/view/View;Z)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;
    .param p2, "measureOnly"    # Z

    .prologue
    .line 114
    move-object v0, p1

    check-cast v0, Lcom/android/mail/browse/ConversationViewHeader;

    .line 115
    .local v0, "header":Lcom/android/mail/browse/ConversationViewHeader;
    invoke-virtual {v0, p0}, Lcom/android/mail/browse/ConversationViewHeader;->bind(Lcom/android/mail/browse/ConversationViewAdapter$ConversationHeaderItem;)V

    .line 116
    return-void
.end method

.method public createView(Landroid/content/Context;Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "inflater"    # Landroid/view/LayoutInflater;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 99
    const v1, 0x7f040034

    const/4 v2, 0x0

    invoke-virtual {p2, v1, p3, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/android/mail/browse/ConversationViewHeader;

    .line 101
    .local v0, "headerView":Lcom/android/mail/browse/ConversationViewHeader;
    iget-object v1, p0, Lcom/android/mail/browse/ConversationViewAdapter$ConversationHeaderItem;->this$0:Lcom/android/mail/browse/ConversationViewAdapter;

    # getter for: Lcom/android/mail/browse/ConversationViewAdapter;->mConversationCallbacks:Lcom/android/mail/browse/ConversationViewHeader$ConversationViewHeaderCallbacks;
    invoke-static {v1}, Lcom/android/mail/browse/ConversationViewAdapter;->access$000(Lcom/android/mail/browse/ConversationViewAdapter;)Lcom/android/mail/browse/ConversationViewHeader$ConversationViewHeaderCallbacks;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/browse/ConversationViewAdapter$ConversationHeaderItem;->this$0:Lcom/android/mail/browse/ConversationViewAdapter;

    # getter for: Lcom/android/mail/browse/ConversationViewAdapter;->mAccountController:Lcom/android/mail/browse/ConversationViewAdapter$ConversationAccountController;
    invoke-static {v2}, Lcom/android/mail/browse/ConversationViewAdapter;->access$100(Lcom/android/mail/browse/ConversationViewAdapter;)Lcom/android/mail/browse/ConversationViewAdapter$ConversationAccountController;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/android/mail/browse/ConversationViewHeader;->setCallbacks(Lcom/android/mail/browse/ConversationViewHeader$ConversationViewHeaderCallbacks;Lcom/android/mail/browse/ConversationViewAdapter$ConversationAccountController;)V

    .line 102
    invoke-virtual {v0, p0}, Lcom/android/mail/browse/ConversationViewHeader;->bind(Lcom/android/mail/browse/ConversationViewAdapter$ConversationHeaderItem;)V

    .line 103
    iget-object v1, p0, Lcom/android/mail/browse/ConversationViewAdapter$ConversationHeaderItem;->mConversation:Lcom/android/mail/providers/Conversation;

    iget-object v1, v1, Lcom/android/mail/providers/Conversation;->subject:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/ConversationViewHeader;->setSubject(Ljava/lang/String;)V

    .line 104
    iget-object v1, p0, Lcom/android/mail/browse/ConversationViewAdapter$ConversationHeaderItem;->this$0:Lcom/android/mail/browse/ConversationViewAdapter;

    # getter for: Lcom/android/mail/browse/ConversationViewAdapter;->mAccountController:Lcom/android/mail/browse/ConversationViewAdapter$ConversationAccountController;
    invoke-static {v1}, Lcom/android/mail/browse/ConversationViewAdapter;->access$100(Lcom/android/mail/browse/ConversationViewAdapter;)Lcom/android/mail/browse/ConversationViewAdapter$ConversationAccountController;

    move-result-object v1

    invoke-interface {v1}, Lcom/android/mail/browse/ConversationViewAdapter$ConversationAccountController;->getAccount()Lcom/android/mail/providers/Account;

    move-result-object v1

    const/16 v2, 0x2000

    invoke-virtual {v1, v2}, Lcom/android/mail/providers/Account;->supportsCapability(I)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 106
    iget-object v1, p0, Lcom/android/mail/browse/ConversationViewAdapter$ConversationHeaderItem;->mConversation:Lcom/android/mail/providers/Conversation;

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/ConversationViewHeader;->setFolders(Lcom/android/mail/providers/Conversation;)V

    .line 109
    :cond_0
    return-object v0
.end method

.method public getType()I
    .locals 1

    .prologue
    .line 94
    const/4 v0, 0x0

    return v0
.end method

.method public isContiguous()Z
    .locals 1

    .prologue
    .line 120
    const/4 v0, 0x1

    return v0
.end method
