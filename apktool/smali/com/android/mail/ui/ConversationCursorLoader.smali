.class public Lcom/android/mail/ui/ConversationCursorLoader;
.super Landroid/content/AsyncTaskLoader;
.source "ConversationCursorLoader.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/content/AsyncTaskLoader",
        "<",
        "Lcom/android/mail/browse/ConversationCursor;",
        ">;"
    }
.end annotation


# static fields
.field private static final sLoaders:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/android/mail/ui/ConversationCursorLoader;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final mActivity:Landroid/app/Activity;

.field private mClosed:Z

.field private final mConversationCursor:Lcom/android/mail/browse/ConversationCursor;

.field private mInit:Z

.field private mInitialConversationLimit:Z

.field private final mName:Ljava/lang/String;

.field private mRetain:Z

.field private mRetained:Z

.field private final mUri:Landroid/net/Uri;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 45
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lcom/android/mail/ui/ConversationCursorLoader;->sLoaders:Ljava/util/ArrayList;

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/android/mail/providers/Account;Landroid/net/Uri;Ljava/lang/String;)V
    .locals 5
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "account"    # Lcom/android/mail/providers/Account;
    .param p3, "uri"    # Landroid/net/Uri;
    .param p4, "name"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 49
    invoke-direct {p0, p1}, Landroid/content/AsyncTaskLoader;-><init>(Landroid/content/Context;)V

    .line 39
    iput-boolean v0, p0, Lcom/android/mail/ui/ConversationCursorLoader;->mInit:Z

    .line 40
    iput-boolean v0, p0, Lcom/android/mail/ui/ConversationCursorLoader;->mClosed:Z

    .line 41
    iput-boolean v0, p0, Lcom/android/mail/ui/ConversationCursorLoader;->mRetain:Z

    .line 42
    iput-boolean v0, p0, Lcom/android/mail/ui/ConversationCursorLoader;->mRetained:Z

    .line 50
    iput-object p1, p0, Lcom/android/mail/ui/ConversationCursorLoader;->mActivity:Landroid/app/Activity;

    .line 51
    iput-object p3, p0, Lcom/android/mail/ui/ConversationCursorLoader;->mUri:Landroid/net/Uri;

    .line 52
    iput-object p4, p0, Lcom/android/mail/ui/ConversationCursorLoader;->mName:Ljava/lang/String;

    .line 53
    const/high16 v0, 0x40000

    invoke-virtual {p2, v0}, Lcom/android/mail/providers/Account;->supportsCapability(I)Z

    move-result v0

    iput-boolean v0, p0, Lcom/android/mail/ui/ConversationCursorLoader;->mInitialConversationLimit:Z

    .line 56
    new-instance v0, Lcom/android/mail/browse/ConversationCursor;

    iget-object v1, p0, Lcom/android/mail/ui/ConversationCursorLoader;->mActivity:Landroid/app/Activity;

    iget-object v2, p0, Lcom/android/mail/ui/ConversationCursorLoader;->mUri:Landroid/net/Uri;

    iget-boolean v3, p0, Lcom/android/mail/ui/ConversationCursorLoader;->mInitialConversationLimit:Z

    iget-object v4, p0, Lcom/android/mail/ui/ConversationCursorLoader;->mName:Ljava/lang/String;

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/android/mail/browse/ConversationCursor;-><init>(Landroid/app/Activity;Landroid/net/Uri;ZLjava/lang/String;)V

    iput-object v0, p0, Lcom/android/mail/ui/ConversationCursorLoader;->mConversationCursor:Lcom/android/mail/browse/ConversationCursor;

    .line 58
    invoke-direct {p0}, Lcom/android/mail/ui/ConversationCursorLoader;->addLoader()V

    .line 59
    return-void
.end method

.method private addLoader()V
    .locals 3

    .prologue
    .line 72
    const-string v0, "ConversationCursorLoader"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Add loader: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/ui/ConversationCursorLoader;->mUri:Landroid/net/Uri;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 74
    sget-object v0, Lcom/android/mail/ui/ConversationCursorLoader;->sLoaders:Ljava/util/ArrayList;

    invoke-virtual {v0, p0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 75
    sget-object v0, Lcom/android/mail/ui/ConversationCursorLoader;->sLoaders:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    const/4 v1, 0x1

    if-le v0, v1, :cond_0

    .line 76
    invoke-direct {p0}, Lcom/android/mail/ui/ConversationCursorLoader;->dumpLoaders()V

    .line 78
    :cond_0
    return-void
.end method

.method private dumpLoaders()V
    .locals 5

    .prologue
    .line 63
    const-string v2, "ConversationCursorLoader"

    const-string v3, "Loaders: "

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 64
    sget-object v2, Lcom/android/mail/ui/ConversationCursorLoader;->sLoaders:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/mail/ui/ConversationCursorLoader;

    .line 65
    .local v1, "loader":Lcom/android/mail/ui/ConversationCursorLoader;
    const-string v2, "ConversationCursorLoader"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, " >> "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, v1, Lcom/android/mail/ui/ConversationCursorLoader;->mName:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " ("

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, v1, Lcom/android/mail/ui/ConversationCursorLoader;->mUri:Landroid/net/Uri;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ")"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 68
    .end local v1    # "loader":Lcom/android/mail/ui/ConversationCursorLoader;
    :cond_0
    return-void
.end method


# virtual methods
.method public loadInBackground()Lcom/android/mail/browse/ConversationCursor;
    .locals 1

    .prologue
    .line 111
    iget-boolean v0, p0, Lcom/android/mail/ui/ConversationCursorLoader;->mInit:Z

    if-nez v0, :cond_0

    .line 112
    iget-object v0, p0, Lcom/android/mail/ui/ConversationCursorLoader;->mConversationCursor:Lcom/android/mail/browse/ConversationCursor;

    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationCursor;->load()V

    .line 113
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/mail/ui/ConversationCursorLoader;->mInit:Z

    .line 115
    :cond_0
    iget-object v0, p0, Lcom/android/mail/ui/ConversationCursorLoader;->mConversationCursor:Lcom/android/mail/browse/ConversationCursor;

    return-object v0
.end method

.method public bridge synthetic loadInBackground()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 32
    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationCursorLoader;->loadInBackground()Lcom/android/mail/browse/ConversationCursor;

    move-result-object v0

    return-object v0
.end method

.method public onReset()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 90
    iget-boolean v0, p0, Lcom/android/mail/ui/ConversationCursorLoader;->mRetain:Z

    if-nez v0, :cond_1

    .line 92
    const-string v0, "ConversationCursorLoader"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Reset loader/disable cursor: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/ui/ConversationCursorLoader;->mName:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 95
    iget-object v0, p0, Lcom/android/mail/ui/ConversationCursorLoader;->mConversationCursor:Lcom/android/mail/browse/ConversationCursor;

    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationCursor;->disable()V

    .line 96
    iput-boolean v3, p0, Lcom/android/mail/ui/ConversationCursorLoader;->mClosed:Z

    .line 97
    sget-object v0, Lcom/android/mail/ui/ConversationCursorLoader;->sLoaders:Ljava/util/ArrayList;

    invoke-virtual {v0, p0}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 98
    sget-object v0, Lcom/android/mail/ui/ConversationCursorLoader;->sLoaders:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 99
    invoke-direct {p0}, Lcom/android/mail/ui/ConversationCursorLoader;->dumpLoaders()V

    .line 107
    :cond_0
    :goto_0
    return-void

    .line 103
    :cond_1
    const-string v0, "ConversationCursorLoader"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Reset loader/retain cursor: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/ui/ConversationCursorLoader;->mName:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 104
    iput-boolean v3, p0, Lcom/android/mail/ui/ConversationCursorLoader;->mRetained:Z

    goto :goto_0
.end method

.method protected onStartLoading()V
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 120
    iget-boolean v0, p0, Lcom/android/mail/ui/ConversationCursorLoader;->mClosed:Z

    if-eqz v0, :cond_1

    .line 121
    iput-boolean v1, p0, Lcom/android/mail/ui/ConversationCursorLoader;->mClosed:Z

    .line 122
    iget-object v0, p0, Lcom/android/mail/ui/ConversationCursorLoader;->mConversationCursor:Lcom/android/mail/browse/ConversationCursor;

    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationCursor;->load()V

    .line 123
    invoke-direct {p0}, Lcom/android/mail/ui/ConversationCursorLoader;->addLoader()V

    .line 125
    const-string v0, "ConversationCursorLoader"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Restarting reset loader: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/ui/ConversationCursorLoader;->mName:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 133
    :cond_0
    :goto_0
    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationCursorLoader;->forceLoad()V

    .line 134
    iget-object v0, p0, Lcom/android/mail/ui/ConversationCursorLoader;->mConversationCursor:Lcom/android/mail/browse/ConversationCursor;

    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationCursor;->resume()V

    .line 135
    return-void

    .line 127
    :cond_1
    iget-boolean v0, p0, Lcom/android/mail/ui/ConversationCursorLoader;->mRetained:Z

    if-eqz v0, :cond_0

    .line 128
    iput-boolean v1, p0, Lcom/android/mail/ui/ConversationCursorLoader;->mRetained:Z

    .line 130
    const-string v0, "ConversationCursorLoader"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Resuming retained loader: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/ui/ConversationCursorLoader;->mName:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method protected onStopLoading()V
    .locals 1

    .prologue
    .line 139
    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationCursorLoader;->cancelLoad()Z

    .line 140
    iget-object v0, p0, Lcom/android/mail/ui/ConversationCursorLoader;->mConversationCursor:Lcom/android/mail/browse/ConversationCursor;

    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationCursor;->pause()V

    .line 141
    return-void
.end method
