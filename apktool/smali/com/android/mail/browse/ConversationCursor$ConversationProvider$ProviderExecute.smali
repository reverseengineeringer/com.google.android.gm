.class Lcom/android/mail/browse/ConversationCursor$ConversationProvider$ProviderExecute;
.super Ljava/lang/Object;
.source "ConversationCursor.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/browse/ConversationCursor$ConversationProvider;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "ProviderExecute"
.end annotation


# instance fields
.field final mCode:I

.field final mUri:Landroid/net/Uri;

.field final mValues:Landroid/content/ContentValues;


# direct methods
.method constructor <init>(ILandroid/net/Uri;Landroid/content/ContentValues;)V
    .locals 1
    .param p1, "code"    # I
    .param p2, "uri"    # Landroid/net/Uri;
    .param p3, "values"    # Landroid/content/ContentValues;

    .prologue
    .line 967
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 968
    iput p1, p0, Lcom/android/mail/browse/ConversationCursor$ConversationProvider$ProviderExecute;->mCode:I

    .line 969
    # invokes: Lcom/android/mail/browse/ConversationCursor;->uriFromCachingUri(Landroid/net/Uri;)Landroid/net/Uri;
    invoke-static {p2}, Lcom/android/mail/browse/ConversationCursor;->access$1000(Landroid/net/Uri;)Landroid/net/Uri;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/ConversationCursor$ConversationProvider$ProviderExecute;->mUri:Landroid/net/Uri;

    .line 970
    iput-object p3, p0, Lcom/android/mail/browse/ConversationCursor$ConversationProvider$ProviderExecute;->mValues:Landroid/content/ContentValues;

    .line 971
    return-void
.end method

.method static opInsert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    .locals 2
    .param p0, "uri"    # Landroid/net/Uri;
    .param p1, "values"    # Landroid/content/ContentValues;

    .prologue
    .line 978
    new-instance v0, Lcom/android/mail/browse/ConversationCursor$ConversationProvider$ProviderExecute;

    const/4 v1, 0x1

    invoke-direct {v0, v1, p0, p1}, Lcom/android/mail/browse/ConversationCursor$ConversationProvider$ProviderExecute;-><init>(ILandroid/net/Uri;Landroid/content/ContentValues;)V

    .line 979
    .local v0, "e":Lcom/android/mail/browse/ConversationCursor$ConversationProvider$ProviderExecute;
    invoke-static {}, Lcom/android/mail/browse/ConversationCursor;->offUiThread()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationCursor$ConversationProvider$ProviderExecute;->go()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/net/Uri;

    .line 981
    :goto_0
    return-object v1

    .line 980
    :cond_0
    new-instance v1, Ljava/lang/Thread;

    invoke-direct {v1, v0}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v1}, Ljava/lang/Thread;->start()V

    .line 981
    const/4 v1, 0x0

    goto :goto_0
.end method


# virtual methods
.method public go()Ljava/lang/Object;
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 1004
    iget v1, p0, Lcom/android/mail/browse/ConversationCursor$ConversationProvider$ProviderExecute;->mCode:I

    packed-switch v1, :pswitch_data_0

    .line 1012
    :goto_0
    return-object v0

    .line 1006
    :pswitch_0
    # getter for: Lcom/android/mail/browse/ConversationCursor;->sResolver:Landroid/content/ContentResolver;
    invoke-static {}, Lcom/android/mail/browse/ConversationCursor;->access$1100()Landroid/content/ContentResolver;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/browse/ConversationCursor$ConversationProvider$ProviderExecute;->mUri:Landroid/net/Uri;

    invoke-virtual {v1, v2, v0, v0}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    goto :goto_0

    .line 1008
    :pswitch_1
    # getter for: Lcom/android/mail/browse/ConversationCursor;->sResolver:Landroid/content/ContentResolver;
    invoke-static {}, Lcom/android/mail/browse/ConversationCursor;->access$1100()Landroid/content/ContentResolver;

    move-result-object v0

    iget-object v1, p0, Lcom/android/mail/browse/ConversationCursor$ConversationProvider$ProviderExecute;->mUri:Landroid/net/Uri;

    iget-object v2, p0, Lcom/android/mail/browse/ConversationCursor$ConversationProvider$ProviderExecute;->mValues:Landroid/content/ContentValues;

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    move-result-object v0

    goto :goto_0

    .line 1010
    :pswitch_2
    # getter for: Lcom/android/mail/browse/ConversationCursor;->sResolver:Landroid/content/ContentResolver;
    invoke-static {}, Lcom/android/mail/browse/ConversationCursor;->access$1100()Landroid/content/ContentResolver;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/browse/ConversationCursor$ConversationProvider$ProviderExecute;->mUri:Landroid/net/Uri;

    iget-object v3, p0, Lcom/android/mail/browse/ConversationCursor$ConversationProvider$ProviderExecute;->mValues:Landroid/content/ContentValues;

    invoke-virtual {v1, v2, v3, v0, v0}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    goto :goto_0

    .line 1004
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public run()V
    .locals 0

    .prologue
    .line 1000
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationCursor$ConversationProvider$ProviderExecute;->go()Ljava/lang/Object;

    .line 1001
    return-void
.end method
