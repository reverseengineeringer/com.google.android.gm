.class Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoader;
.super Landroid/content/CursorLoader;
.source "AbstractConversationViewFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/AbstractConversationViewFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "MessageLoader"
.end annotation


# instance fields
.field private final mController:Lcom/android/mail/browse/MessageCursor$ConversationController;

.field private final mConversation:Lcom/android/mail/providers/Conversation;

.field private mDeliveredFirstResults:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/android/mail/providers/Conversation;Lcom/android/mail/browse/MessageCursor$ConversationController;)V
    .locals 7
    .param p1, "c"    # Landroid/content/Context;
    .param p2, "conv"    # Lcom/android/mail/providers/Conversation;
    .param p3, "controller"    # Lcom/android/mail/browse/MessageCursor$ConversationController;

    .prologue
    const/4 v4, 0x0

    .line 595
    iget-object v2, p2, Lcom/android/mail/providers/Conversation;->messageListUri:Landroid/net/Uri;

    sget-object v3, Lcom/android/mail/providers/UIProvider;->MESSAGE_PROJECTION:[Ljava/lang/String;

    move-object v0, p0

    move-object v1, p1

    move-object v5, v4

    move-object v6, v4

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    .line 590
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoader;->mDeliveredFirstResults:Z

    .line 596
    iput-object p2, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoader;->mConversation:Lcom/android/mail/providers/Conversation;

    .line 597
    iput-object p3, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoader;->mController:Lcom/android/mail/browse/MessageCursor$ConversationController;

    .line 598
    return-void
.end method


# virtual methods
.method public deliverResult(Landroid/database/Cursor;)V
    .locals 5
    .param p1, "result"    # Landroid/database/Cursor;

    .prologue
    .line 610
    invoke-super {p0, p1}, Landroid/content/CursorLoader;->deliverResult(Landroid/database/Cursor;)V

    .line 612
    iget-boolean v2, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoader;->mDeliveredFirstResults:Z

    if-nez v2, :cond_0

    .line 613
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoader;->mDeliveredFirstResults:Z

    .line 614
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoader;->getUri()Landroid/net/Uri;

    move-result-object v1

    .line 618
    .local v1, "uri":Landroid/net/Uri;
    new-instance v0, Lcom/android/mail/providers/ListParams;

    const/4 v2, -0x1

    const/4 v3, 0x0

    invoke-direct {v0, v2, v3}, Lcom/android/mail/providers/ListParams;-><init>(IZ)V

    .line 622
    .local v0, "listParams":Lcom/android/mail/providers/ListParams;
    invoke-virtual {v1}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v2

    const-string v3, "listParams"

    invoke-virtual {v0}, Lcom/android/mail/providers/ListParams;->serialize()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v2

    invoke-virtual {v2}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v1

    .line 626
    invoke-virtual {p0, v1}, Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoader;->setUri(Landroid/net/Uri;)V

    .line 628
    .end local v0    # "listParams":Lcom/android/mail/providers/ListParams;
    .end local v1    # "uri":Landroid/net/Uri;
    :cond_0
    return-void
.end method

.method public bridge synthetic deliverResult(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 589
    check-cast p1, Landroid/database/Cursor;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoader;->deliverResult(Landroid/database/Cursor;)V

    return-void
.end method

.method public loadInBackground()Landroid/database/Cursor;
    .locals 4

    .prologue
    .line 602
    new-instance v0, Lcom/android/mail/browse/MessageCursor;

    invoke-super {p0}, Landroid/content/CursorLoader;->loadInBackground()Landroid/database/Cursor;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoader;->mConversation:Lcom/android/mail/providers/Conversation;

    iget-object v3, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoader;->mController:Lcom/android/mail/browse/MessageCursor$ConversationController;

    invoke-direct {v0, v1, v2, v3}, Lcom/android/mail/browse/MessageCursor;-><init>(Landroid/database/Cursor;Lcom/android/mail/providers/Conversation;Lcom/android/mail/browse/MessageCursor$ConversationController;)V

    return-object v0
.end method

.method public bridge synthetic loadInBackground()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 589
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoader;->loadInBackground()Landroid/database/Cursor;

    move-result-object v0

    return-object v0
.end method
