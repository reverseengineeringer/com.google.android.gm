.class public abstract Lcom/android/mail/browse/ConversationCursor$ConversationProvider;
.super Landroid/content/ContentProvider;
.source "ConversationCursor.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/browse/ConversationCursor;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "ConversationProvider"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/browse/ConversationCursor$ConversationProvider$ProviderExecute;
    }
.end annotation


# static fields
.field public static AUTHORITY:Ljava/lang/String;


# instance fields
.field private mUndoDeleteUris:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/net/Uri;",
            ">;"
        }
    .end annotation
.end field

.field private mUndoSequence:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 911
    invoke-direct {p0}, Landroid/content/ContentProvider;-><init>()V

    .line 1021
    const/4 v0, 0x0

    iput v0, p0, Lcom/android/mail/browse/ConversationCursor$ConversationProvider;->mUndoSequence:I

    .line 1022
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/android/mail/browse/ConversationCursor$ConversationProvider;->mUndoDeleteUris:Ljava/util/ArrayList;

    return-void
.end method

.method static synthetic access$2000(Lcom/android/mail/browse/ConversationCursor$ConversationProvider;Landroid/net/Uri;Landroid/content/ContentValues;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/browse/ConversationCursor$ConversationProvider;
    .param p1, "x1"    # Landroid/net/Uri;
    .param p2, "x2"    # Landroid/content/ContentValues;

    .prologue
    .line 911
    invoke-direct {p0, p1, p2}, Lcom/android/mail/browse/ConversationCursor$ConversationProvider;->insertLocal(Landroid/net/Uri;Landroid/content/ContentValues;)V

    return-void
.end method

.method private insertLocal(Landroid/net/Uri;Landroid/content/ContentValues;)V
    .locals 0
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "values"    # Landroid/content/ContentValues;

    .prologue
    .line 1019
    return-void
.end method


# virtual methods
.method addToUndoSequence(Landroid/net/Uri;)V
    .locals 2
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    .line 1025
    # getter for: Lcom/android/mail/browse/ConversationCursor;->sSequence:I
    invoke-static {}, Lcom/android/mail/browse/ConversationCursor;->access$1200()I

    move-result v0

    iget v1, p0, Lcom/android/mail/browse/ConversationCursor$ConversationProvider;->mUndoSequence:I

    if-eq v0, v1, :cond_0

    .line 1026
    # getter for: Lcom/android/mail/browse/ConversationCursor;->sSequence:I
    invoke-static {}, Lcom/android/mail/browse/ConversationCursor;->access$1200()I

    move-result v0

    iput v0, p0, Lcom/android/mail/browse/ConversationCursor$ConversationProvider;->mUndoSequence:I

    .line 1027
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor$ConversationProvider;->mUndoDeleteUris:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 1029
    :cond_0
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor$ConversationProvider;->mUndoDeleteUris:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1030
    return-void
.end method

.method public apply(Ljava/util/Collection;Lcom/android/mail/browse/ConversationCursor;)I
    .locals 11
    .param p2, "conversationCursor"    # Lcom/android/mail/browse/ConversationCursor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/browse/ConversationCursor$ConversationOperation;",
            ">;",
            "Lcom/android/mail/browse/ConversationCursor;",
            ")I"
        }
    .end annotation

    .prologue
    .line 1089
    .local p1, "ops":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/browse/ConversationCursor$ConversationOperation;>;"
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    .line 1092
    .local v3, "batchMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/util/ArrayList<Landroid/content/ContentProviderOperation;>;>;"
    # operator++ for: Lcom/android/mail/browse/ConversationCursor;->sSequence:I
    invoke-static {}, Lcom/android/mail/browse/ConversationCursor;->access$1208()I

    .line 1095
    const/4 v7, 0x0

    .line 1096
    .local v7, "recalibrateRequired":Z
    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v5

    .local v5, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_3

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/android/mail/browse/ConversationCursor$ConversationOperation;

    .line 1097
    .local v6, "op":Lcom/android/mail/browse/ConversationCursor$ConversationOperation;
    # getter for: Lcom/android/mail/browse/ConversationCursor$ConversationOperation;->mUri:Landroid/net/Uri;
    invoke-static {v6}, Lcom/android/mail/browse/ConversationCursor$ConversationOperation;->access$1700(Lcom/android/mail/browse/ConversationCursor$ConversationOperation;)Landroid/net/Uri;

    move-result-object v9

    # invokes: Lcom/android/mail/browse/ConversationCursor;->uriFromCachingUri(Landroid/net/Uri;)Landroid/net/Uri;
    invoke-static {v9}, Lcom/android/mail/browse/ConversationCursor;->access$1000(Landroid/net/Uri;)Landroid/net/Uri;

    move-result-object v8

    .line 1098
    .local v8, "underlyingUri":Landroid/net/Uri;
    invoke-virtual {v8}, Landroid/net/Uri;->getAuthority()Ljava/lang/String;

    move-result-object v2

    .line 1099
    .local v2, "authority":Ljava/lang/String;
    invoke-virtual {v3, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/ArrayList;

    .line 1100
    .local v1, "authOps":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/content/ContentProviderOperation;>;"
    if-nez v1, :cond_1

    .line 1101
    new-instance v1, Ljava/util/ArrayList;

    .end local v1    # "authOps":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/content/ContentProviderOperation;>;"
    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 1102
    .restart local v1    # "authOps":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/content/ContentProviderOperation;>;"
    invoke-virtual {v3, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1104
    :cond_1
    # invokes: Lcom/android/mail/browse/ConversationCursor$ConversationOperation;->execute(Landroid/net/Uri;)Landroid/content/ContentProviderOperation;
    invoke-static {v6, v8}, Lcom/android/mail/browse/ConversationCursor$ConversationOperation;->access$1800(Lcom/android/mail/browse/ConversationCursor$ConversationOperation;Landroid/net/Uri;)Landroid/content/ContentProviderOperation;

    move-result-object v4

    .line 1105
    .local v4, "cpo":Landroid/content/ContentProviderOperation;
    if-eqz v4, :cond_2

    .line 1106
    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1109
    :cond_2
    # getter for: Lcom/android/mail/browse/ConversationCursor$ConversationOperation;->mRecalibrateRequired:Z
    invoke-static {v6}, Lcom/android/mail/browse/ConversationCursor$ConversationOperation;->access$1900(Lcom/android/mail/browse/ConversationCursor$ConversationOperation;)Z

    move-result v9

    if-eqz v9, :cond_0

    .line 1110
    const/4 v7, 0x1

    goto :goto_0

    .line 1115
    .end local v1    # "authOps":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/content/ContentProviderOperation;>;"
    .end local v2    # "authority":Ljava/lang/String;
    .end local v4    # "cpo":Landroid/content/ContentProviderOperation;
    .end local v6    # "op":Lcom/android/mail/browse/ConversationCursor$ConversationOperation;
    .end local v8    # "underlyingUri":Landroid/net/Uri;
    :cond_3
    if-eqz v7, :cond_4

    .line 1116
    # invokes: Lcom/android/mail/browse/ConversationCursor;->recalibratePosition()V
    invoke-static {p2}, Lcom/android/mail/browse/ConversationCursor;->access$1500(Lcom/android/mail/browse/ConversationCursor;)V

    .line 1120
    :cond_4
    # invokes: Lcom/android/mail/browse/ConversationCursor;->notifyDataChanged()V
    invoke-static {p2}, Lcom/android/mail/browse/ConversationCursor;->access$1600(Lcom/android/mail/browse/ConversationCursor;)V

    .line 1123
    invoke-virtual {v3}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v9

    invoke-interface {v9}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_1
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_6

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 1125
    .restart local v2    # "authority":Ljava/lang/String;
    :try_start_0
    invoke-static {}, Lcom/android/mail/browse/ConversationCursor;->offUiThread()Z

    move-result v9

    if-eqz v9, :cond_5

    .line 1126
    # getter for: Lcom/android/mail/browse/ConversationCursor;->sResolver:Landroid/content/ContentResolver;
    invoke-static {}, Lcom/android/mail/browse/ConversationCursor;->access$1100()Landroid/content/ContentResolver;

    move-result-object v10

    invoke-virtual {v3, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/ArrayList;

    invoke-virtual {v10, v2, v9}, Landroid/content/ContentResolver;->applyBatch(Ljava/lang/String;Ljava/util/ArrayList;)[Landroid/content/ContentProviderResult;

    goto :goto_1

    .line 1140
    :catch_0
    move-exception v9

    goto :goto_1

    .line 1128
    :cond_5
    move-object v0, v2

    .line 1129
    .local v0, "auth":Ljava/lang/String;
    new-instance v9, Ljava/lang/Thread;

    new-instance v10, Lcom/android/mail/browse/ConversationCursor$ConversationProvider$1;

    invoke-direct {v10, p0, v0, v3}, Lcom/android/mail/browse/ConversationCursor$ConversationProvider$1;-><init>(Lcom/android/mail/browse/ConversationCursor$ConversationProvider;Ljava/lang/String;Ljava/util/HashMap;)V

    invoke-direct {v9, v10}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v9}, Ljava/lang/Thread;->start()V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Landroid/content/OperationApplicationException; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_1

    .line 1141
    .end local v0    # "auth":Ljava/lang/String;
    :catch_1
    move-exception v9

    goto :goto_1

    .line 1144
    .end local v2    # "authority":Ljava/lang/String;
    :cond_6
    # getter for: Lcom/android/mail/browse/ConversationCursor;->sSequence:I
    invoke-static {}, Lcom/android/mail/browse/ConversationCursor;->access$1200()I

    move-result v9

    return v9
.end method

.method clearMostlyDead(Landroid/net/Uri;Lcom/android/mail/browse/ConversationCursor;)Z
    .locals 2
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "conversationCursor"    # Lcom/android/mail/browse/ConversationCursor;

    .prologue
    .line 1057
    # invokes: Lcom/android/mail/browse/ConversationCursor;->uriStringFromCachingUri(Landroid/net/Uri;)Ljava/lang/String;
    invoke-static {p1}, Lcom/android/mail/browse/ConversationCursor;->access$1300(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v0

    .line 1058
    .local v0, "uriString":Ljava/lang/String;
    invoke-virtual {p2, v0}, Lcom/android/mail/browse/ConversationCursor;->clearMostlyDead(Ljava/lang/String;)Z

    move-result v1

    return v1
.end method

.method commitMostlyDead(Lcom/android/mail/providers/Conversation;Lcom/android/mail/browse/ConversationCursor;)V
    .locals 0
    .param p1, "conv"    # Lcom/android/mail/providers/Conversation;
    .param p2, "conversationCursor"    # Lcom/android/mail/browse/ConversationCursor;

    .prologue
    .line 1053
    invoke-virtual {p2, p1}, Lcom/android/mail/browse/ConversationCursor;->commitMostlyDead(Lcom/android/mail/providers/Conversation;)V

    .line 1054
    return-void
.end method

.method public delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 2
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "selection"    # Ljava/lang/String;
    .param p3, "selectionArgs"    # [Ljava/lang/String;

    .prologue
    .line 946
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Unexpected call to ConversationProvider.delete"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method deleteLocal(Landroid/net/Uri;Lcom/android/mail/browse/ConversationCursor;)V
    .locals 3
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "conversationCursor"    # Lcom/android/mail/browse/ConversationCursor;

    .prologue
    .line 1034
    # invokes: Lcom/android/mail/browse/ConversationCursor;->uriStringFromCachingUri(Landroid/net/Uri;)Ljava/lang/String;
    invoke-static {p1}, Lcom/android/mail/browse/ConversationCursor;->access$1300(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v0

    .line 1035
    .local v0, "uriString":Ljava/lang/String;
    const-string v1, "__deleted__"

    const/4 v2, 0x1

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    # invokes: Lcom/android/mail/browse/ConversationCursor;->cacheValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    invoke-static {p2, v0, v1, v2}, Lcom/android/mail/browse/ConversationCursor;->access$1400(Lcom/android/mail/browse/ConversationCursor;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 1036
    invoke-virtual {p0, p1}, Lcom/android/mail/browse/ConversationCursor$ConversationProvider;->addToUndoSequence(Landroid/net/Uri;)V

    .line 1037
    return-void
.end method

.method protected abstract getAuthority()Ljava/lang/String;
.end method

.method public getType(Landroid/net/Uri;)Ljava/lang/String;
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    .line 951
    const/4 v0, 0x0

    return-object v0
.end method

.method public insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "values"    # Landroid/content/ContentValues;

    .prologue
    .line 935
    invoke-direct {p0, p1, p2}, Lcom/android/mail/browse/ConversationCursor$ConversationProvider;->insertLocal(Landroid/net/Uri;Landroid/content/ContentValues;)V

    .line 936
    invoke-static {p1, p2}, Lcom/android/mail/browse/ConversationCursor$ConversationProvider$ProviderExecute;->opInsert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method public onCreate()Z
    .locals 1

    .prologue
    .line 921
    sput-object p0, Lcom/android/mail/browse/ConversationCursor;->sProvider:Lcom/android/mail/browse/ConversationCursor$ConversationProvider;

    .line 922
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationCursor$ConversationProvider;->getAuthority()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/browse/ConversationCursor$ConversationProvider;->AUTHORITY:Ljava/lang/String;

    .line 923
    const/4 v0, 0x1

    return v0
.end method

.method public query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    .locals 6
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "projection"    # [Ljava/lang/String;
    .param p3, "selection"    # Ljava/lang/String;
    .param p4, "selectionArgs"    # [Ljava/lang/String;
    .param p5, "sortOrder"    # Ljava/lang/String;

    .prologue
    .line 929
    # getter for: Lcom/android/mail/browse/ConversationCursor;->sResolver:Landroid/content/ContentResolver;
    invoke-static {}, Lcom/android/mail/browse/ConversationCursor;->access$1100()Landroid/content/ContentResolver;

    move-result-object v0

    # invokes: Lcom/android/mail/browse/ConversationCursor;->uriFromCachingUri(Landroid/net/Uri;)Landroid/net/Uri;
    invoke-static {p1}, Lcom/android/mail/browse/ConversationCursor;->access$1000(Landroid/net/Uri;)Landroid/net/Uri;

    move-result-object v1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    return-object v0
.end method

.method setMostlyDead(Lcom/android/mail/providers/Conversation;Lcom/android/mail/browse/ConversationCursor;)V
    .locals 2
    .param p1, "conv"    # Lcom/android/mail/providers/Conversation;
    .param p2, "conversationCursor"    # Lcom/android/mail/browse/ConversationCursor;

    .prologue
    .line 1046
    iget-object v0, p1, Lcom/android/mail/providers/Conversation;->uri:Landroid/net/Uri;

    .line 1047
    .local v0, "uri":Landroid/net/Uri;
    # invokes: Lcom/android/mail/browse/ConversationCursor;->uriStringFromCachingUri(Landroid/net/Uri;)Ljava/lang/String;
    invoke-static {v0}, Lcom/android/mail/browse/ConversationCursor;->access$1300(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v1

    .line 1048
    .local v1, "uriString":Ljava/lang/String;
    invoke-virtual {p2, v1, p1}, Lcom/android/mail/browse/ConversationCursor;->setMostlyDead(Ljava/lang/String;Lcom/android/mail/providers/Conversation;)V

    .line 1049
    invoke-virtual {p0, v0}, Lcom/android/mail/browse/ConversationCursor$ConversationProvider;->addToUndoSequence(Landroid/net/Uri;)V

    .line 1050
    return-void
.end method

.method undeleteLocal(Landroid/net/Uri;Lcom/android/mail/browse/ConversationCursor;)V
    .locals 3
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "conversationCursor"    # Lcom/android/mail/browse/ConversationCursor;

    .prologue
    .line 1041
    # invokes: Lcom/android/mail/browse/ConversationCursor;->uriStringFromCachingUri(Landroid/net/Uri;)Ljava/lang/String;
    invoke-static {p1}, Lcom/android/mail/browse/ConversationCursor;->access$1300(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v0

    .line 1042
    .local v0, "uriString":Ljava/lang/String;
    const-string v1, "__deleted__"

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    # invokes: Lcom/android/mail/browse/ConversationCursor;->cacheValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    invoke-static {p2, v0, v1, v2}, Lcom/android/mail/browse/ConversationCursor;->access$1400(Lcom/android/mail/browse/ConversationCursor;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 1043
    return-void
.end method

.method public undo(Lcom/android/mail/browse/ConversationCursor;)V
    .locals 4
    .param p1, "conversationCursor"    # Lcom/android/mail/browse/ConversationCursor;

    .prologue
    .line 1062
    # getter for: Lcom/android/mail/browse/ConversationCursor;->sSequence:I
    invoke-static {}, Lcom/android/mail/browse/ConversationCursor;->access$1200()I

    move-result v2

    iget v3, p0, Lcom/android/mail/browse/ConversationCursor$ConversationProvider;->mUndoSequence:I

    if-ne v2, v3, :cond_2

    .line 1063
    iget-object v2, p0, Lcom/android/mail/browse/ConversationCursor$ConversationProvider;->mUndoDeleteUris:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/net/Uri;

    .line 1064
    .local v1, "uri":Landroid/net/Uri;
    invoke-virtual {p0, v1, p1}, Lcom/android/mail/browse/ConversationCursor$ConversationProvider;->clearMostlyDead(Landroid/net/Uri;Lcom/android/mail/browse/ConversationCursor;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 1065
    invoke-virtual {p0, v1, p1}, Lcom/android/mail/browse/ConversationCursor$ConversationProvider;->undeleteLocal(Landroid/net/Uri;Lcom/android/mail/browse/ConversationCursor;)V

    goto :goto_0

    .line 1068
    .end local v1    # "uri":Landroid/net/Uri;
    :cond_1
    const/4 v2, 0x0

    iput v2, p0, Lcom/android/mail/browse/ConversationCursor$ConversationProvider;->mUndoSequence:I

    .line 1069
    # invokes: Lcom/android/mail/browse/ConversationCursor;->recalibratePosition()V
    invoke-static {p1}, Lcom/android/mail/browse/ConversationCursor;->access$1500(Lcom/android/mail/browse/ConversationCursor;)V

    .line 1072
    # invokes: Lcom/android/mail/browse/ConversationCursor;->notifyDataChanged()V
    invoke-static {p1}, Lcom/android/mail/browse/ConversationCursor;->access$1600(Lcom/android/mail/browse/ConversationCursor;)V

    .line 1074
    .end local v0    # "i$":Ljava/util/Iterator;
    :cond_2
    return-void
.end method

.method public update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 2
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "values"    # Landroid/content/ContentValues;
    .param p3, "selection"    # Ljava/lang/String;
    .param p4, "selectionArgs"    # [Ljava/lang/String;

    .prologue
    .line 941
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Unexpected call to ConversationProvider.delete"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method updateLocal(Landroid/net/Uri;Landroid/content/ContentValues;Lcom/android/mail/browse/ConversationCursor;)V
    .locals 4
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "values"    # Landroid/content/ContentValues;
    .param p3, "conversationCursor"    # Lcom/android/mail/browse/ConversationCursor;

    .prologue
    .line 1078
    if-nez p2, :cond_1

    .line 1085
    :cond_0
    return-void

    .line 1081
    :cond_1
    # invokes: Lcom/android/mail/browse/ConversationCursor;->uriStringFromCachingUri(Landroid/net/Uri;)Ljava/lang/String;
    invoke-static {p1}, Lcom/android/mail/browse/ConversationCursor;->access$1300(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v2

    .line 1082
    .local v2, "uriString":Ljava/lang/String;
    invoke-virtual {p2}, Landroid/content/ContentValues;->keySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 1083
    .local v0, "columnName":Ljava/lang/String;
    invoke-virtual {p2, v0}, Landroid/content/ContentValues;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    # invokes: Lcom/android/mail/browse/ConversationCursor;->cacheValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    invoke-static {p3, v2, v0, v3}, Lcom/android/mail/browse/ConversationCursor;->access$1400(Lcom/android/mail/browse/ConversationCursor;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_0
.end method
