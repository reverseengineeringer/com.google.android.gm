.class Lcom/android/mail/browse/ConversationCursor$ConversationProvider$1;
.super Ljava/lang/Object;
.source "ConversationCursor.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/mail/browse/ConversationCursor$ConversationProvider;->apply(Ljava/util/Collection;Lcom/android/mail/browse/ConversationCursor;)I
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/browse/ConversationCursor$ConversationProvider;

.field final synthetic val$auth:Ljava/lang/String;

.field final synthetic val$batchMap:Ljava/util/HashMap;


# direct methods
.method constructor <init>(Lcom/android/mail/browse/ConversationCursor$ConversationProvider;Ljava/lang/String;Ljava/util/HashMap;)V
    .locals 0

    .prologue
    .line 1129
    iput-object p1, p0, Lcom/android/mail/browse/ConversationCursor$ConversationProvider$1;->this$0:Lcom/android/mail/browse/ConversationCursor$ConversationProvider;

    iput-object p2, p0, Lcom/android/mail/browse/ConversationCursor$ConversationProvider$1;->val$auth:Ljava/lang/String;

    iput-object p3, p0, Lcom/android/mail/browse/ConversationCursor$ConversationProvider$1;->val$batchMap:Ljava/util/HashMap;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 1133
    :try_start_0
    # getter for: Lcom/android/mail/browse/ConversationCursor;->sResolver:Landroid/content/ContentResolver;
    invoke-static {}, Lcom/android/mail/browse/ConversationCursor;->access$1100()Landroid/content/ContentResolver;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/browse/ConversationCursor$ConversationProvider$1;->val$auth:Ljava/lang/String;

    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor$ConversationProvider$1;->val$batchMap:Ljava/util/HashMap;

    iget-object v3, p0, Lcom/android/mail/browse/ConversationCursor$ConversationProvider$1;->val$auth:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    invoke-virtual {v1, v2, v0}, Landroid/content/ContentResolver;->applyBatch(Ljava/lang/String;Ljava/util/ArrayList;)[Landroid/content/ContentProviderResult;
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Landroid/content/OperationApplicationException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1137
    :goto_0
    return-void

    .line 1135
    :catch_0
    move-exception v0

    goto :goto_0

    .line 1134
    :catch_1
    move-exception v0

    goto :goto_0
.end method
