.class public Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;
.super Lcom/android/mail/browse/ConversationOverlayItem;
.source "ConversationViewAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/browse/ConversationViewAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "MessageHeaderItem"
.end annotation


# instance fields
.field public detailsExpanded:Z

.field private mExpanded:Z

.field private mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

.field public recipientSummaryText:Ljava/lang/CharSequence;

.field final synthetic this$0:Lcom/android/mail/browse/ConversationViewAdapter;

.field public timestampLong:Ljava/lang/CharSequence;

.field public timestampShort:Ljava/lang/CharSequence;


# direct methods
.method constructor <init>(Lcom/android/mail/browse/ConversationViewAdapter;Lcom/android/mail/browse/MessageCursor$ConversationMessage;Z)V
    .locals 1
    .param p2, "message"    # Lcom/android/mail/browse/MessageCursor$ConversationMessage;
    .param p3, "expanded"    # Z

    .prologue
    .line 137
    iput-object p1, p0, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->this$0:Lcom/android/mail/browse/ConversationViewAdapter;

    invoke-direct {p0}, Lcom/android/mail/browse/ConversationOverlayItem;-><init>()V

    .line 138
    iput-object p2, p0, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    .line 139
    iput-boolean p3, p0, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->mExpanded:Z

    .line 141
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->detailsExpanded:Z

    .line 142
    return-void
.end method


# virtual methods
.method public belongsToMessage(Lcom/android/mail/browse/MessageCursor$ConversationMessage;)Z
    .locals 1
    .param p1, "message"    # Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    .prologue
    .line 202
    iget-object v0, p0, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    invoke-static {v0, p1}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public bindView(Landroid/view/View;Z)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;
    .param p2, "measureOnly"    # Z

    .prologue
    .line 165
    move-object v0, p1

    check-cast v0, Lcom/android/mail/browse/MessageHeaderView;

    .line 166
    .local v0, "header":Lcom/android/mail/browse/MessageHeaderView;
    invoke-virtual {v0, p0, p2}, Lcom/android/mail/browse/MessageHeaderView;->bind(Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;Z)V

    .line 167
    return-void
.end method

.method public canBecomeSnapHeader()Z
    .locals 1

    .prologue
    .line 192
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->isExpanded()Z

    move-result v0

    return v0
.end method

.method public canPushSnapHeader()Z
    .locals 1

    .prologue
    .line 197
    const/4 v0, 0x1

    return v0
.end method

.method public createView(Landroid/content/Context;Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "inflater"    # Landroid/view/LayoutInflater;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 155
    const v1, 0x7f04002b

    const/4 v2, 0x0

    invoke-virtual {p2, v1, p3, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/android/mail/browse/MessageHeaderView;

    .line 157
    .local v0, "v":Lcom/android/mail/browse/MessageHeaderView;
    iget-object v1, p0, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->this$0:Lcom/android/mail/browse/ConversationViewAdapter;

    # getter for: Lcom/android/mail/browse/ConversationViewAdapter;->mDateBuilder:Lcom/android/mail/FormattedDateBuilder;
    invoke-static {v1}, Lcom/android/mail/browse/ConversationViewAdapter;->access$200(Lcom/android/mail/browse/ConversationViewAdapter;)Lcom/android/mail/FormattedDateBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->this$0:Lcom/android/mail/browse/ConversationViewAdapter;

    # getter for: Lcom/android/mail/browse/ConversationViewAdapter;->mAccountController:Lcom/android/mail/browse/ConversationViewAdapter$ConversationAccountController;
    invoke-static {v2}, Lcom/android/mail/browse/ConversationViewAdapter;->access$100(Lcom/android/mail/browse/ConversationViewAdapter;)Lcom/android/mail/browse/ConversationViewAdapter$ConversationAccountController;

    move-result-object v2

    iget-object v3, p0, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->this$0:Lcom/android/mail/browse/ConversationViewAdapter;

    # getter for: Lcom/android/mail/browse/ConversationViewAdapter;->mAddressCache:Ljava/util/Map;
    invoke-static {v3}, Lcom/android/mail/browse/ConversationViewAdapter;->access$300(Lcom/android/mail/browse/ConversationViewAdapter;)Ljava/util/Map;

    move-result-object v3

    invoke-virtual {v0, v1, v2, v3}, Lcom/android/mail/browse/MessageHeaderView;->initialize(Lcom/android/mail/FormattedDateBuilder;Lcom/android/mail/browse/ConversationViewAdapter$ConversationAccountController;Ljava/util/Map;)V

    .line 158
    iget-object v1, p0, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->this$0:Lcom/android/mail/browse/ConversationViewAdapter;

    # getter for: Lcom/android/mail/browse/ConversationViewAdapter;->mMessageCallbacks:Lcom/android/mail/browse/MessageHeaderView$MessageHeaderViewCallbacks;
    invoke-static {v1}, Lcom/android/mail/browse/ConversationViewAdapter;->access$400(Lcom/android/mail/browse/ConversationViewAdapter;)Lcom/android/mail/browse/MessageHeaderView$MessageHeaderViewCallbacks;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/MessageHeaderView;->setCallbacks(Lcom/android/mail/browse/MessageHeaderView$MessageHeaderViewCallbacks;)V

    .line 159
    iget-object v1, p0, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->this$0:Lcom/android/mail/browse/ConversationViewAdapter;

    # getter for: Lcom/android/mail/browse/ConversationViewAdapter;->mContactInfoSource:Lcom/android/mail/ContactInfoSource;
    invoke-static {v1}, Lcom/android/mail/browse/ConversationViewAdapter;->access$500(Lcom/android/mail/browse/ConversationViewAdapter;)Lcom/android/mail/ContactInfoSource;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/MessageHeaderView;->setContactInfoSource(Lcom/android/mail/ContactInfoSource;)V

    .line 160
    return-object v0
.end method

.method public getMessage()Lcom/android/mail/browse/MessageCursor$ConversationMessage;
    .locals 1

    .prologue
    .line 145
    iget-object v0, p0, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    return-object v0
.end method

.method public getType()I
    .locals 1

    .prologue
    .line 150
    const/4 v0, 0x1

    return v0
.end method

.method public isContiguous()Z
    .locals 1

    .prologue
    .line 177
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->isExpanded()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isExpanded()Z
    .locals 1

    .prologue
    .line 181
    iget-boolean v0, p0, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->mExpanded:Z

    return v0
.end method

.method public onModelUpdated(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 171
    move-object v0, p1

    check-cast v0, Lcom/android/mail/browse/MessageHeaderView;

    .line 172
    .local v0, "header":Lcom/android/mail/browse/MessageHeaderView;
    invoke-virtual {v0}, Lcom/android/mail/browse/MessageHeaderView;->refresh()V

    .line 173
    return-void
.end method

.method public setExpanded(Z)V
    .locals 1
    .param p1, "expanded"    # Z

    .prologue
    .line 185
    iget-boolean v0, p0, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->mExpanded:Z

    if-eq v0, p1, :cond_0

    .line 186
    iput-boolean p1, p0, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->mExpanded:Z

    .line 188
    :cond_0
    return-void
.end method

.method public setMessage(Lcom/android/mail/browse/MessageCursor$ConversationMessage;)V
    .locals 0
    .param p1, "message"    # Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    .prologue
    .line 207
    iput-object p1, p0, Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;->mMessage:Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    .line 208
    return-void
.end method
