.class Lcom/android/mail/ui/ConversationViewFragment$SetCookieTask;
.super Landroid/os/AsyncTask;
.source "ConversationViewFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/ConversationViewFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SetCookieTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final mAccountCookieQueryUri:Landroid/net/Uri;

.field final mResolver:Landroid/content/ContentResolver;

.field final mUri:Ljava/lang/String;

.field final synthetic this$0:Lcom/android/mail/ui/ConversationViewFragment;


# direct methods
.method constructor <init>(Lcom/android/mail/ui/ConversationViewFragment;Landroid/content/Context;Landroid/net/Uri;Landroid/net/Uri;)V
    .locals 1
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "baseUri"    # Landroid/net/Uri;
    .param p4, "accountCookieQueryUri"    # Landroid/net/Uri;

    .prologue
    .line 1266
    iput-object p1, p0, Lcom/android/mail/ui/ConversationViewFragment$SetCookieTask;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 1267
    invoke-virtual {p3}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment$SetCookieTask;->mUri:Ljava/lang/String;

    .line 1268
    iput-object p4, p0, Lcom/android/mail/ui/ConversationViewFragment$SetCookieTask;->mAccountCookieQueryUri:Landroid/net/Uri;

    .line 1269
    invoke-virtual {p2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment$SetCookieTask;->mResolver:Landroid/content/ContentResolver;

    .line 1270
    return-void
.end method


# virtual methods
.method public bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # [Ljava/lang/Object;

    .prologue
    .line 1261
    check-cast p1, [Ljava/lang/Void;

    .end local p1    # "x0":[Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/android/mail/ui/ConversationViewFragment$SetCookieTask;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method public varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 9
    .param p1, "args"    # [Ljava/lang/Void;

    .prologue
    const/4 v3, 0x0

    .line 1275
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment$SetCookieTask;->mResolver:Landroid/content/ContentResolver;

    iget-object v1, p0, Lcom/android/mail/ui/ConversationViewFragment$SetCookieTask;->mAccountCookieQueryUri:Landroid/net/Uri;

    sget-object v2, Lcom/android/mail/providers/UIProvider;->ACCOUNT_COOKIE_PROJECTION:[Ljava/lang/String;

    move-object v4, v3

    move-object v5, v3

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v7

    .line 1277
    .local v7, "cookieCursor":Landroid/database/Cursor;
    if-nez v7, :cond_0

    .line 1299
    :goto_0
    return-object v3

    .line 1282
    :cond_0
    :try_start_0
    invoke-interface {v7}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1283
    const-string v0, "cookie"

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 1286
    .local v6, "cookie":Ljava/lang/String;
    if-eqz v6, :cond_1

    .line 1287
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment$SetCookieTask;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    invoke-virtual {v0}, Lcom/android/mail/ui/ConversationViewFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/webkit/CookieSyncManager;->createInstance(Landroid/content/Context;)Landroid/webkit/CookieSyncManager;

    move-result-object v8

    .line 1289
    .local v8, "csm":Landroid/webkit/CookieSyncManager;
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v0

    iget-object v1, p0, Lcom/android/mail/ui/ConversationViewFragment$SetCookieTask;->mUri:Ljava/lang/String;

    invoke-virtual {v0, v1, v6}, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    .line 1290
    invoke-virtual {v8}, Landroid/webkit/CookieSyncManager;->sync()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1295
    .end local v6    # "cookie":Ljava/lang/String;
    .end local v8    # "csm":Landroid/webkit/CookieSyncManager;
    :cond_1
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    goto :goto_0

    :catchall_0
    move-exception v0

    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    throw v0
.end method
