.class Lcom/google/android/gm/provider/UiProvider$AttachmentCursor;
.super Landroid/database/MatrixCursor;
.source "UiProvider.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gm/provider/UiProvider;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "AttachmentCursor"
.end annotation


# instance fields
.field private final mAccount:Ljava/lang/String;

.field private final mConversationId:J

.field private final mMessageId:J

.field final synthetic this$0:Lcom/google/android/gm/provider/UiProvider;


# direct methods
.method public constructor <init>(Lcom/google/android/gm/provider/UiProvider;Ljava/lang/String;JJ[Ljava/lang/String;I)V
    .locals 0
    .param p2, "account"    # Ljava/lang/String;
    .param p3, "conversationId"    # J
    .param p5, "messageId"    # J
    .param p7, "columnNames"    # [Ljava/lang/String;
    .param p8, "initialCapacity"    # I

    .prologue
    .line 3115
    iput-object p1, p0, Lcom/google/android/gm/provider/UiProvider$AttachmentCursor;->this$0:Lcom/google/android/gm/provider/UiProvider;

    .line 3116
    invoke-direct {p0, p7, p8}, Landroid/database/MatrixCursor;-><init>([Ljava/lang/String;I)V

    .line 3117
    iput-object p2, p0, Lcom/google/android/gm/provider/UiProvider$AttachmentCursor;->mAccount:Ljava/lang/String;

    .line 3118
    iput-wide p3, p0, Lcom/google/android/gm/provider/UiProvider$AttachmentCursor;->mConversationId:J

    .line 3119
    iput-wide p5, p0, Lcom/google/android/gm/provider/UiProvider$AttachmentCursor;->mMessageId:J

    .line 3120
    return-void
.end method


# virtual methods
.method public close()V
    .locals 6

    .prologue
    .line 3126
    # getter for: Lcom/google/android/gm/provider/UiProvider;->sAccountStateMap:Ljava/util/Map;
    invoke-static {}, Lcom/google/android/gm/provider/UiProvider;->access$500()Ljava/util/Map;

    move-result-object v3

    monitor-enter v3

    .line 3127
    :try_start_0
    # getter for: Lcom/google/android/gm/provider/UiProvider;->sAccountStateMap:Ljava/util/Map;
    invoke-static {}, Lcom/google/android/gm/provider/UiProvider;->access$500()Ljava/util/Map;

    move-result-object v2

    iget-object v4, p0, Lcom/google/android/gm/provider/UiProvider$AttachmentCursor;->mAccount:Ljava/lang/String;

    invoke-interface {v2, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gm/provider/uiprovider/AccountState;

    .line 3128
    .local v0, "accountState":Lcom/google/android/gm/provider/uiprovider/AccountState;
    if-eqz v0, :cond_0

    .line 3130
    iget-wide v4, p0, Lcom/google/android/gm/provider/UiProvider$AttachmentCursor;->mConversationId:J

    invoke-virtual {v0, v4, v5}, Lcom/google/android/gm/provider/uiprovider/AccountState;->getConversationState(J)Lcom/google/android/gm/provider/uiprovider/ConversationState;

    move-result-object v1

    .line 3132
    .local v1, "conversationState":Lcom/google/android/gm/provider/uiprovider/ConversationState;
    if-eqz v1, :cond_0

    .line 3134
    invoke-virtual {v1, p0}, Lcom/google/android/gm/provider/uiprovider/ConversationState;->handleCursorClose(Landroid/database/Cursor;)V

    .line 3137
    .end local v1    # "conversationState":Lcom/google/android/gm/provider/uiprovider/ConversationState;
    :cond_0
    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 3139
    invoke-super {p0}, Landroid/database/MatrixCursor;->close()V

    .line 3140
    return-void

    .line 3137
    .end local v0    # "accountState":Lcom/google/android/gm/provider/uiprovider/AccountState;
    :catchall_0
    move-exception v2

    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v2
.end method
