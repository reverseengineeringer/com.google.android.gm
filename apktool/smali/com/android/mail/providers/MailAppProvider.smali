.class public abstract Lcom/android/mail/providers/MailAppProvider;
.super Landroid/content/ContentProvider;
.source "MailAppProvider.java"

# interfaces
.implements Landroid/content/Loader$OnLoadCompleteListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/content/ContentProvider;",
        "Landroid/content/Loader$OnLoadCompleteListener",
        "<",
        "Landroid/database/Cursor;",
        ">;"
    }
.end annotation


# static fields
.field private static final LOG_TAG:Ljava/lang/String;

.field private static final PENDING_ACCOUNT_URIS:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Landroid/net/Uri;",
            ">;"
        }
    .end annotation
.end field

.field private static sAuthority:Ljava/lang/String;

.field private static sInstance:Lcom/android/mail/providers/MailAppProvider;


# instance fields
.field private final mAccountCache:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Landroid/net/Uri;",
            "Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;",
            ">;"
        }
    .end annotation
.end field

.field private volatile mAccountsFullyLoaded:Z

.field private final mCursorLoaderMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Landroid/net/Uri;",
            "Landroid/content/CursorLoader;",
            ">;"
        }
    .end annotation
.end field

.field private mResolver:Landroid/content/ContentResolver;

.field private mSharedPrefs:Landroid/content/SharedPreferences;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 78
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/providers/MailAppProvider;->LOG_TAG:Ljava/lang/String;

    .line 87
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v0

    sput-object v0, Lcom/android/mail/providers/MailAppProvider;->PENDING_ACCOUNT_URIS:Ljava/util/Set;

    return-void
.end method

.method protected constructor <init>()V
    .locals 1

    .prologue
    .line 136
    invoke-direct {p0}, Landroid/content/ContentProvider;-><init>()V

    .line 80
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/MailAppProvider;->mAccountCache:Ljava/util/Map;

    .line 82
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/MailAppProvider;->mCursorLoaderMap:Ljava/util/Map;

    .line 89
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/mail/providers/MailAppProvider;->mAccountsFullyLoaded:Z

    .line 137
    return-void
.end method

.method private addAccountImpl(Lcom/android/mail/providers/Account;Landroid/net/Uri;IZ)V
    .locals 5
    .param p1, "account"    # Lcom/android/mail/providers/Account;
    .param p2, "accountsQueryUri"    # Landroid/net/Uri;
    .param p3, "position"    # I
    .param p4, "notify"    # Z

    .prologue
    .line 411
    iget-object v1, p0, Lcom/android/mail/providers/MailAppProvider;->mAccountCache:Ljava/util/Map;

    monitor-enter v1

    .line 412
    if-eqz p1, :cond_0

    .line 413
    :try_start_0
    sget-object v0, Lcom/android/mail/providers/MailAppProvider;->LOG_TAG:Ljava/lang/String;

    const-string v2, "adding account %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p1, v3, v4

    invoke-static {v0, v2, v3}, Lcom/android/mail/utils/LogUtils;->v(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 414
    iget-object v0, p0, Lcom/android/mail/providers/MailAppProvider;->mAccountCache:Ljava/util/Map;

    iget-object v2, p1, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    new-instance v3, Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;

    invoke-direct {v3, p1, p2, p3}, Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;-><init>(Lcom/android/mail/providers/Account;Landroid/net/Uri;I)V

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 417
    :cond_0
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 420
    if-eqz p4, :cond_1

    .line 421
    invoke-static {}, Lcom/android/mail/providers/MailAppProvider;->broadcastAccountChange()V

    .line 425
    :cond_1
    invoke-direct {p0}, Lcom/android/mail/providers/MailAppProvider;->cacheAccountList()V

    .line 426
    return-void

    .line 417
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method private addAccountImpl(Lcom/android/mail/providers/Account;Landroid/net/Uri;Z)V
    .locals 1
    .param p1, "account"    # Lcom/android/mail/providers/Account;
    .param p2, "accountsQueryUri"    # Landroid/net/Uri;
    .param p3, "notify"    # Z

    .prologue
    .line 406
    iget-object v0, p0, Lcom/android/mail/providers/MailAppProvider;->mAccountCache:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->size()I

    move-result v0

    invoke-direct {p0, p1, p2, v0, p3}, Lcom/android/mail/providers/MailAppProvider;->addAccountImpl(Lcom/android/mail/providers/Account;Landroid/net/Uri;IZ)V

    .line 407
    return-void
.end method

.method public static addAccountsForUriAsync(Landroid/net/Uri;)V
    .locals 3
    .param p0, "accountsQueryUri"    # Landroid/net/Uri;

    .prologue
    .line 360
    sget-object v2, Lcom/android/mail/providers/MailAppProvider;->PENDING_ACCOUNT_URIS:Ljava/util/Set;

    monitor-enter v2

    .line 361
    :try_start_0
    invoke-static {}, Lcom/android/mail/providers/MailAppProvider;->getInstance()Lcom/android/mail/providers/MailAppProvider;

    move-result-object v0

    .line 362
    .local v0, "instance":Lcom/android/mail/providers/MailAppProvider;
    if-eqz v0, :cond_0

    .line 363
    invoke-direct {v0, p0}, Lcom/android/mail/providers/MailAppProvider;->startAccountsLoader(Landroid/net/Uri;)V

    .line 367
    :goto_0
    monitor-exit v2

    .line 368
    return-void

    .line 365
    :cond_0
    sget-object v1, Lcom/android/mail/providers/MailAppProvider;->PENDING_ACCOUNT_URIS:Ljava/util/Set;

    invoke-interface {v1, p0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 367
    .end local v0    # "instance":Lcom/android/mail/providers/MailAppProvider;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method private static broadcastAccountChange()V
    .locals 4

    .prologue
    .line 446
    sget-object v0, Lcom/android/mail/providers/MailAppProvider;->sInstance:Lcom/android/mail/providers/MailAppProvider;

    .line 448
    .local v0, "provider":Lcom/android/mail/providers/MailAppProvider;
    if-eqz v0, :cond_0

    .line 449
    iget-object v1, v0, Lcom/android/mail/providers/MailAppProvider;->mResolver:Landroid/content/ContentResolver;

    invoke-static {}, Lcom/android/mail/providers/MailAppProvider;->getAccountsUri()Landroid/net/Uri;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 451
    :cond_0
    return-void
.end method

.method private cacheAccountList()V
    .locals 7

    .prologue
    .line 528
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v1

    .line 529
    .local v1, "accountList":Ljava/util/List;, "Ljava/util/List<Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;>;"
    iget-object v6, p0, Lcom/android/mail/providers/MailAppProvider;->mAccountCache:Ljava/util/Map;

    monitor-enter v6

    .line 530
    :try_start_0
    iget-object v5, p0, Lcom/android/mail/providers/MailAppProvider;->mAccountCache:Ljava/util/Map;

    invoke-interface {v5}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v5

    invoke-interface {v1, v5}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 531
    monitor-exit v6
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 532
    invoke-static {v1}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    .line 534
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v4

    .line 535
    .local v4, "serializedAccounts":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;

    .line 536
    .local v0, "accountEntry":Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;
    invoke-virtual {v0}, Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;->serialize()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 531
    .end local v0    # "accountEntry":Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;
    .end local v3    # "i$":Ljava/util/Iterator;
    .end local v4    # "serializedAccounts":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    :catchall_0
    move-exception v5

    :try_start_1
    monitor-exit v6
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v5

    .line 539
    .restart local v3    # "i$":Ljava/util/Iterator;
    .restart local v4    # "serializedAccounts":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    :cond_0
    invoke-direct {p0}, Lcom/android/mail/providers/MailAppProvider;->getPreferences()Landroid/content/SharedPreferences;

    move-result-object v5

    invoke-interface {v5}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    .line 540
    .local v2, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v5, "accountList"

    invoke-interface {v2, v5, v4}, Landroid/content/SharedPreferences$Editor;->putStringSet(Ljava/lang/String;Ljava/util/Set;)Landroid/content/SharedPreferences$Editor;

    .line 541
    invoke-interface {v2}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 542
    return-void
.end method

.method public static getAccountFromAccountUri(Landroid/net/Uri;)Lcom/android/mail/providers/Account;
    .locals 4
    .param p0, "accountUri"    # Landroid/net/Uri;

    .prologue
    .line 553
    invoke-static {}, Lcom/android/mail/providers/MailAppProvider;->getInstance()Lcom/android/mail/providers/MailAppProvider;

    move-result-object v1

    .line 554
    .local v1, "provider":Lcom/android/mail/providers/MailAppProvider;
    if-eqz v1, :cond_1

    iget-boolean v2, v1, Lcom/android/mail/providers/MailAppProvider;->mAccountsFullyLoaded:Z

    if-eqz v2, :cond_1

    .line 555
    iget-object v3, v1, Lcom/android/mail/providers/MailAppProvider;->mAccountCache:Ljava/util/Map;

    monitor-enter v3

    .line 556
    :try_start_0
    iget-object v2, v1, Lcom/android/mail/providers/MailAppProvider;->mAccountCache:Ljava/util/Map;

    invoke-interface {v2, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;

    .line 557
    .local v0, "entry":Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;
    if-eqz v0, :cond_0

    .line 558
    iget-object v2, v0, Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;->mAccount:Lcom/android/mail/providers/Account;

    monitor-exit v3

    .line 562
    .end local v0    # "entry":Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;
    :goto_0
    return-object v2

    .line 560
    .restart local v0    # "entry":Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;
    :cond_0
    monitor-exit v3

    .line 562
    .end local v0    # "entry":Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;
    :cond_1
    const/4 v2, 0x0

    goto :goto_0

    .line 560
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2
.end method

.method public static getAccountsUri()Landroid/net/Uri;
    .locals 2

    .prologue
    .line 128
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "content://"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcom/android/mail/providers/MailAppProvider;->sAuthority:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method public static getInstance()Lcom/android/mail/providers/MailAppProvider;
    .locals 1

    .prologue
    .line 132
    sget-object v0, Lcom/android/mail/providers/MailAppProvider;->sInstance:Lcom/android/mail/providers/MailAppProvider;

    return-object v0
.end method

.method public static getNoAccountIntent(Landroid/content/Context;)Landroid/content/Intent;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 378
    invoke-static {}, Lcom/android/mail/providers/MailAppProvider;->getInstance()Lcom/android/mail/providers/MailAppProvider;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/android/mail/providers/MailAppProvider;->getNoAccountsIntent(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method

.method private getPreferences()Landroid/content/SharedPreferences;
    .locals 3

    .prologue
    .line 545
    iget-object v0, p0, Lcom/android/mail/providers/MailAppProvider;->mSharedPrefs:Landroid/content/SharedPreferences;

    if-nez v0, :cond_0

    .line 546
    invoke-virtual {p0}, Lcom/android/mail/providers/MailAppProvider;->getContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "MailAppProvider"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/MailAppProvider;->mSharedPrefs:Landroid/content/SharedPreferences;

    .line 549
    :cond_0
    iget-object v0, p0, Lcom/android/mail/providers/MailAppProvider;->mSharedPrefs:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method private loadCachedAccountList()V
    .locals 14

    .prologue
    .line 488
    invoke-direct {p0}, Lcom/android/mail/providers/MailAppProvider;->getPreferences()Landroid/content/SharedPreferences;

    move-result-object v7

    .line 490
    .local v7, "preference":Landroid/content/SharedPreferences;
    const-string v9, "accountList"

    const/4 v10, 0x0

    invoke-interface {v7, v9, v10}, Landroid/content/SharedPreferences;->getStringSet(Ljava/lang/String;Ljava/util/Set;)Ljava/util/Set;

    move-result-object v2

    .line 492
    .local v2, "accountsStringSet":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    if-eqz v2, :cond_3

    .line 493
    const/4 v6, 0x0

    .line 494
    .local v6, "pos":I
    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v5

    .local v5, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_2

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    .line 498
    .local v8, "serializedAccount":Ljava/lang/String;
    :try_start_0
    new-instance v1, Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;

    invoke-direct {v1, v8, v6}, Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;-><init>(Ljava/lang/String;I)V

    .line 500
    .local v1, "accountEntry":Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;
    iget-object v9, v1, Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v9, v9, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    if-eqz v9, :cond_1

    .line 501
    iget-object v0, v1, Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;->mAccount:Lcom/android/mail/providers/Account;

    .line 502
    .local v0, "account":Lcom/android/mail/providers/Account;
    iget-object v9, p0, Lcom/android/mail/providers/MailAppProvider;->mResolver:Landroid/content/ContentResolver;

    iget-object v10, v0, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    invoke-virtual {v9, v10}, Landroid/content/ContentResolver;->acquireContentProviderClient(Landroid/net/Uri;)Landroid/content/ContentProviderClient;

    move-result-object v3

    .line 504
    .local v3, "client":Landroid/content/ContentProviderClient;
    if-eqz v3, :cond_0

    .line 505
    invoke-virtual {v3}, Landroid/content/ContentProviderClient;->release()Z

    .line 506
    iget-object v9, v1, Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;->mAccountsQueryUri:Landroid/net/Uri;

    const/4 v10, 0x0

    invoke-direct {p0, v0, v9, v10}, Lcom/android/mail/providers/MailAppProvider;->addAccountImpl(Lcom/android/mail/providers/Account;Landroid/net/Uri;Z)V

    .line 515
    .end local v0    # "account":Lcom/android/mail/providers/Account;
    .end local v3    # "client":Landroid/content/ContentProviderClient;
    :goto_1
    add-int/lit8 v6, v6, 0x1

    goto :goto_0

    .line 509
    .restart local v0    # "account":Lcom/android/mail/providers/Account;
    .restart local v3    # "client":Landroid/content/ContentProviderClient;
    :cond_0
    sget-object v9, Lcom/android/mail/providers/MailAppProvider;->LOG_TAG:Ljava/lang/String;

    const-string v10, "Dropping account without provider: %s"

    const/4 v11, 0x1

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v12, 0x0

    iget-object v13, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    aput-object v13, v11, v12

    invoke-static {v9, v10, v11}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 516
    .end local v0    # "account":Lcom/android/mail/providers/Account;
    .end local v1    # "accountEntry":Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;
    .end local v3    # "client":Landroid/content/ContentProviderClient;
    :catch_0
    move-exception v4

    .line 518
    .local v4, "e":Ljava/lang/Exception;
    sget-object v9, Lcom/android/mail/providers/MailAppProvider;->LOG_TAG:Ljava/lang/String;

    const-string v10, "Unable to create account object from serialized string \'%s\'"

    const/4 v11, 0x1

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v12, 0x0

    aput-object v8, v11, v12

    invoke-static {v9, v4, v10, v11}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0

    .line 513
    .end local v4    # "e":Ljava/lang/Exception;
    .restart local v1    # "accountEntry":Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;
    :cond_1
    :try_start_1
    sget-object v9, Lcom/android/mail/providers/MailAppProvider;->LOG_TAG:Ljava/lang/String;

    const-string v10, "Dropping account that doesn\'t specify settings"

    const/4 v11, 0x0

    new-array v11, v11, [Ljava/lang/Object;

    invoke-static {v9, v10, v11}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1

    .line 523
    .end local v1    # "accountEntry":Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;
    .end local v8    # "serializedAccount":Ljava/lang/String;
    :cond_2
    invoke-static {}, Lcom/android/mail/providers/MailAppProvider;->broadcastAccountChange()V

    .line 525
    .end local v5    # "i$":Ljava/util/Iterator;
    .end local v6    # "pos":I
    :cond_3
    return-void
.end method

.method private removeAccounts(Ljava/util/Set;Z)V
    .locals 7
    .param p2, "notify"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Landroid/net/Uri;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 429
    .local p1, "uris":Ljava/util/Set;, "Ljava/util/Set<Landroid/net/Uri;>;"
    iget-object v3, p0, Lcom/android/mail/providers/MailAppProvider;->mAccountCache:Ljava/util/Map;

    monitor-enter v3

    .line 430
    :try_start_0
    invoke-interface {p1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/Uri;

    .line 431
    .local v0, "accountUri":Landroid/net/Uri;
    sget-object v2, Lcom/android/mail/providers/MailAppProvider;->LOG_TAG:Ljava/lang/String;

    const-string v4, "Removing account %s"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object v0, v5, v6

    invoke-static {v2, v4, v5}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 432
    iget-object v2, p0, Lcom/android/mail/providers/MailAppProvider;->mAccountCache:Ljava/util/Map;

    invoke-interface {v2, v0}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 434
    .end local v0    # "accountUri":Landroid/net/Uri;
    .end local v1    # "i$":Ljava/util/Iterator;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .restart local v1    # "i$":Ljava/util/Iterator;
    :cond_0
    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 437
    if-eqz p2, :cond_1

    .line 438
    invoke-static {}, Lcom/android/mail/providers/MailAppProvider;->broadcastAccountChange()V

    .line 442
    :cond_1
    invoke-direct {p0}, Lcom/android/mail/providers/MailAppProvider;->cacheAccountList()V

    .line 443
    return-void
.end method

.method private declared-synchronized startAccountsLoader(Landroid/net/Uri;)V
    .locals 8
    .param p1, "accountsQueryUri"    # Landroid/net/Uri;

    .prologue
    .line 382
    monitor-enter p0

    :try_start_0
    new-instance v0, Landroid/content/CursorLoader;

    invoke-virtual {p0}, Lcom/android/mail/providers/MailAppProvider;->getContext()Landroid/content/Context;

    move-result-object v1

    sget-object v3, Lcom/android/mail/providers/UIProvider;->ACCOUNTS_PROJECTION:[Ljava/lang/String;

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    move-object v2, p1

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    .line 386
    .local v0, "accountsCursorLoader":Landroid/content/CursorLoader;
    invoke-virtual {p1}, Landroid/net/Uri;->hashCode()I

    move-result v1

    invoke-virtual {v0, v1, p0}, Landroid/content/CursorLoader;->registerListener(ILandroid/content/Loader$OnLoadCompleteListener;)V

    .line 387
    invoke-virtual {v0}, Landroid/content/CursorLoader;->startLoading()V

    .line 390
    iget-object v1, p0, Lcom/android/mail/providers/MailAppProvider;->mCursorLoaderMap:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/content/CursorLoader;

    .line 391
    .local v7, "oldLoader":Landroid/content/CursorLoader;
    if-eqz v7, :cond_0

    .line 392
    invoke-virtual {v7}, Landroid/content/CursorLoader;->stopLoading()V

    .line 394
    :cond_0
    iget-object v1, p0, Lcom/android/mail/providers/MailAppProvider;->mCursorLoaderMap:Ljava/util/Map;

    invoke-interface {v1, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 395
    monitor-exit p0

    return-void

    .line 382
    .end local v0    # "accountsCursorLoader":Landroid/content/CursorLoader;
    .end local v7    # "oldLoader":Landroid/content/CursorLoader;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method


# virtual methods
.method public delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 1
    .param p1, "url"    # Landroid/net/Uri;
    .param p2, "selection"    # Ljava/lang/String;
    .param p3, "selectionArgs"    # [Ljava/lang/String;

    .prologue
    .line 343
    const/4 v0, 0x0

    return v0
.end method

.method protected abstract getAuthority()Ljava/lang/String;
.end method

.method public getLastSentFromAccount()Ljava/lang/String;
    .locals 3

    .prologue
    .line 474
    invoke-direct {p0}, Lcom/android/mail/providers/MailAppProvider;->getPreferences()Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "lastSendFromAccount"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getLastViewedAccount()Ljava/lang/String;
    .locals 3

    .prologue
    .line 457
    invoke-direct {p0}, Lcom/android/mail/providers/MailAppProvider;->getPreferences()Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "lastViewedAccount"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected abstract getNoAccountsIntent(Landroid/content/Context;)Landroid/content/Intent;
.end method

.method public getType(Landroid/net/Uri;)Ljava/lang/String;
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    .line 348
    const/4 v0, 0x0

    return-object v0
.end method

.method public insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    .locals 0
    .param p1, "url"    # Landroid/net/Uri;
    .param p2, "values"    # Landroid/content/ContentValues;

    .prologue
    .line 332
    return-object p1
.end method

.method public onCreate()Z
    .locals 6

    .prologue
    .line 141
    invoke-virtual {p0}, Lcom/android/mail/providers/MailAppProvider;->getAuthority()Ljava/lang/String;

    move-result-object v4

    sput-object v4, Lcom/android/mail/providers/MailAppProvider;->sAuthority:Ljava/lang/String;

    .line 142
    invoke-virtual {p0}, Lcom/android/mail/providers/MailAppProvider;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v4

    iput-object v4, p0, Lcom/android/mail/providers/MailAppProvider;->mResolver:Landroid/content/ContentResolver;

    .line 144
    new-instance v2, Landroid/content/Intent;

    const-string v4, "com.google.android.gm2.providers.protos.boot.intent.ACTION_PROVIDER_CREATED"

    invoke-direct {v2, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 145
    .local v2, "intent":Landroid/content/Intent;
    invoke-virtual {p0}, Lcom/android/mail/providers/MailAppProvider;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4, v2}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 148
    invoke-direct {p0}, Lcom/android/mail/providers/MailAppProvider;->loadCachedAccountList()V

    .line 150
    sget-object v5, Lcom/android/mail/providers/MailAppProvider;->PENDING_ACCOUNT_URIS:Ljava/util/Set;

    monitor-enter v5

    .line 151
    :try_start_0
    sput-object p0, Lcom/android/mail/providers/MailAppProvider;->sInstance:Lcom/android/mail/providers/MailAppProvider;

    .line 155
    sget-object v4, Lcom/android/mail/providers/MailAppProvider;->PENDING_ACCOUNT_URIS:Ljava/util/Set;

    invoke-static {v4}, Lcom/google/common/collect/ImmutableSet;->copyOf(Ljava/util/Collection;)Lcom/google/common/collect/ImmutableSet;

    move-result-object v3

    .line 156
    .local v3, "urisToQery":Ljava/util/Set;, "Ljava/util/Set<Landroid/net/Uri;>;"
    sget-object v4, Lcom/android/mail/providers/MailAppProvider;->PENDING_ACCOUNT_URIS:Ljava/util/Set;

    invoke-interface {v4}, Ljava/util/Set;->clear()V

    .line 157
    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/Uri;

    .line 158
    .local v0, "accountQueryUri":Landroid/net/Uri;
    invoke-static {v0}, Lcom/android/mail/providers/MailAppProvider;->addAccountsForUriAsync(Landroid/net/Uri;)V

    goto :goto_0

    .line 160
    .end local v0    # "accountQueryUri":Landroid/net/Uri;
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v3    # "urisToQery":Ljava/util/Set;, "Ljava/util/Set<Landroid/net/Uri;>;"
    :catchall_0
    move-exception v4

    monitor-exit v5
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v4

    .restart local v1    # "i$":Ljava/util/Iterator;
    .restart local v3    # "urisToQery":Ljava/util/Set;, "Ljava/util/Set<Landroid/net/Uri;>;"
    :cond_0
    :try_start_1
    monitor-exit v5
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 162
    const/4 v4, 0x1

    return v4
.end method

.method public onLoadComplete(Landroid/content/Loader;Landroid/database/Cursor;)V
    .locals 19
    .param p2, "data"    # Landroid/database/Cursor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;",
            "Landroid/database/Cursor;",
            ")V"
        }
    .end annotation

    .prologue
    .line 567
    .local p1, "loader":Landroid/content/Loader;, "Landroid/content/Loader<Landroid/database/Cursor;>;"
    if-nez p2, :cond_0

    .line 568
    sget-object v14, Lcom/android/mail/providers/MailAppProvider;->LOG_TAG:Ljava/lang/String;

    const-string v15, "null account cursor returned"

    const/16 v16, 0x0

    move/from16 v0, v16

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v16, v0

    invoke-static/range {v14 .. v16}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 619
    :goto_0
    return-void

    .line 572
    :cond_0
    sget-object v14, Lcom/android/mail/providers/MailAppProvider;->LOG_TAG:Ljava/lang/String;

    const-string v15, "Cursor with %d accounts returned"

    const/16 v16, 0x1

    move/from16 v0, v16

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v16, v0

    const/16 v17, 0x0

    invoke-interface/range {p2 .. p2}, Landroid/database/Cursor;->getCount()I

    move-result v18

    invoke-static/range {v18 .. v18}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v18

    aput-object v18, v16, v17

    invoke-static/range {v14 .. v16}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    move-object/from16 v5, p1

    .line 573
    check-cast v5, Landroid/content/CursorLoader;

    .line 574
    .local v5, "cursorLoader":Landroid/content/CursorLoader;
    invoke-virtual {v5}, Landroid/content/CursorLoader;->getUri()Landroid/net/Uri;

    move-result-object v4

    .line 577
    .local v4, "accountsQueryUri":Landroid/net/Uri;
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/android/mail/providers/MailAppProvider;->mAccountCache:Ljava/util/Map;

    monitor-enter v15

    .line 578
    :try_start_0
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/android/mail/providers/MailAppProvider;->mAccountCache:Ljava/util/Map;

    invoke-interface {v14}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v14

    invoke-static {v14}, Lcom/google/common/collect/ImmutableSet;->copyOf(Ljava/util/Collection;)Lcom/google/common/collect/ImmutableSet;

    move-result-object v2

    .line 579
    .local v2, "accountList":Ljava/util/Set;, "Ljava/util/Set<Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;>;"
    monitor-exit v15
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 581
    const/4 v9, 0x0

    .line 583
    .local v9, "lastPosition":I
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v13

    .line 584
    .local v13, "previousQueryUriSet":Ljava/util/Set;, "Ljava/util/Set<Landroid/net/Uri;>;"
    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v8

    .local v8, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_1
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v14

    if-eqz v14, :cond_3

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;

    .line 585
    .local v6, "entry":Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;
    iget-object v14, v6, Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;->mAccountsQueryUri:Landroid/net/Uri;

    invoke-virtual {v4, v14}, Landroid/net/Uri;->equals(Ljava/lang/Object;)Z

    move-result v14

    if-eqz v14, :cond_2

    .line 586
    iget-object v14, v6, Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v14, v14, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    invoke-interface {v13, v14}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 588
    :cond_2
    iget v14, v6, Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;->mPosition:I

    if-le v14, v9, :cond_1

    .line 589
    iget v9, v6, Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;->mPosition:I

    goto :goto_1

    .line 579
    .end local v2    # "accountList":Ljava/util/Set;, "Ljava/util/Set<Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;>;"
    .end local v6    # "entry":Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;
    .end local v8    # "i$":Ljava/util/Iterator;
    .end local v9    # "lastPosition":I
    .end local v13    # "previousQueryUriSet":Ljava/util/Set;, "Ljava/util/Set<Landroid/net/Uri;>;"
    :catchall_0
    move-exception v14

    :try_start_1
    monitor-exit v15
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v14

    .line 596
    .restart local v2    # "accountList":Ljava/util/Set;, "Ljava/util/Set<Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;>;"
    .restart local v8    # "i$":Ljava/util/Iterator;
    .restart local v9    # "lastPosition":I
    .restart local v13    # "previousQueryUriSet":Ljava/util/Set;, "Ljava/util/Set<Landroid/net/Uri;>;"
    :cond_3
    invoke-interface/range {p2 .. p2}, Landroid/database/Cursor;->getExtras()Landroid/os/Bundle;

    move-result-object v7

    .line 597
    .local v7, "extra":Landroid/os/Bundle;
    const-string v14, "accounts_loaded"

    invoke-virtual {v7, v14}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v14

    if-eqz v14, :cond_4

    const/4 v14, 0x1

    :goto_2
    move-object/from16 v0, p0

    iput-boolean v14, v0, Lcom/android/mail/providers/MailAppProvider;->mAccountsFullyLoaded:Z

    .line 599
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v10

    .line 603
    .local v10, "newQueryUriMap":Ljava/util/Set;, "Ljava/util/Set<Landroid/net/Uri;>;"
    move v11, v9

    .line 604
    .local v11, "pos":I
    :goto_3
    invoke-interface/range {p2 .. p2}, Landroid/database/Cursor;->moveToNext()Z

    move-result v14

    if-eqz v14, :cond_5

    .line 605
    new-instance v1, Lcom/android/mail/providers/Account;

    move-object/from16 v0, p2

    invoke-direct {v1, v0}, Lcom/android/mail/providers/Account;-><init>(Landroid/database/Cursor;)V

    .line 606
    .local v1, "account":Lcom/android/mail/providers/Account;
    iget-object v3, v1, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    .line 607
    .local v3, "accountUri":Landroid/net/Uri;
    invoke-interface {v10, v3}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 608
    add-int/lit8 v12, v11, 0x1

    .end local v11    # "pos":I
    .local v12, "pos":I
    const/4 v14, 0x0

    move-object/from16 v0, p0

    invoke-direct {v0, v1, v4, v11, v14}, Lcom/android/mail/providers/MailAppProvider;->addAccountImpl(Lcom/android/mail/providers/Account;Landroid/net/Uri;IZ)V

    move v11, v12

    .line 609
    .end local v12    # "pos":I
    .restart local v11    # "pos":I
    goto :goto_3

    .line 597
    .end local v1    # "account":Lcom/android/mail/providers/Account;
    .end local v3    # "accountUri":Landroid/net/Uri;
    .end local v10    # "newQueryUriMap":Ljava/util/Set;, "Ljava/util/Set<Landroid/net/Uri;>;"
    .end local v11    # "pos":I
    :cond_4
    const/4 v14, 0x0

    goto :goto_2

    .line 611
    .restart local v10    # "newQueryUriMap":Ljava/util/Set;, "Ljava/util/Set<Landroid/net/Uri;>;"
    .restart local v11    # "pos":I
    :cond_5
    invoke-interface {v13, v10}, Ljava/util/Set;->removeAll(Ljava/util/Collection;)Z

    .line 615
    invoke-interface {v13}, Ljava/util/Set;->size()I

    move-result v14

    if-lez v14, :cond_6

    move-object/from16 v0, p0

    iget-boolean v14, v0, Lcom/android/mail/providers/MailAppProvider;->mAccountsFullyLoaded:Z

    if-eqz v14, :cond_6

    .line 616
    const/4 v14, 0x0

    move-object/from16 v0, p0

    invoke-direct {v0, v13, v14}, Lcom/android/mail/providers/MailAppProvider;->removeAccounts(Ljava/util/Set;Z)V

    .line 618
    :cond_6
    invoke-static {}, Lcom/android/mail/providers/MailAppProvider;->broadcastAccountChange()V

    goto/16 :goto_0
.end method

.method public bridge synthetic onLoadComplete(Landroid/content/Loader;Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Landroid/content/Loader;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 63
    check-cast p2, Landroid/database/Cursor;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/android/mail/providers/MailAppProvider;->onLoadComplete(Landroid/content/Loader;Landroid/database/Cursor;)V

    return-void
.end method

.method public query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    .locals 15
    .param p1, "url"    # Landroid/net/Uri;
    .param p2, "projection"    # [Ljava/lang/String;
    .param p3, "selection"    # Ljava/lang/String;
    .param p4, "selectionArgs"    # [Ljava/lang/String;
    .param p5, "sortOrder"    # Ljava/lang/String;

    .prologue
    .line 184
    invoke-static/range {p2 .. p2}, Lcom/android/mail/providers/UIProviderValidator;->validateAccountProjection([Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v11

    .line 185
    .local v11, "resultProjection":[Ljava/lang/String;
    new-instance v7, Landroid/os/Bundle;

    invoke-direct {v7}, Landroid/os/Bundle;-><init>()V

    .line 186
    .local v7, "extras":Landroid/os/Bundle;
    const-string v13, "accounts_loaded"

    iget-boolean v12, p0, Lcom/android/mail/providers/MailAppProvider;->mAccountsFullyLoaded:Z

    if-eqz v12, :cond_1

    const/4 v12, 0x1

    :goto_0
    invoke-virtual {v7, v13, v12}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 189
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v2

    .line 190
    .local v2, "accountList":Ljava/util/List;, "Ljava/util/List<Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;>;"
    iget-object v13, p0, Lcom/android/mail/providers/MailAppProvider;->mAccountCache:Ljava/util/Map;

    monitor-enter v13

    .line 191
    :try_start_0
    iget-object v12, p0, Lcom/android/mail/providers/MailAppProvider;->mAccountCache:Ljava/util/Map;

    invoke-interface {v12}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v12

    invoke-interface {v2, v12}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 192
    monitor-exit v13
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 193
    invoke-static {v2}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    .line 195
    new-instance v6, Lcom/android/mail/utils/MatrixCursorWithExtra;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v12

    invoke-direct {v6, v11, v12, v7}, Lcom/android/mail/utils/MatrixCursorWithExtra;-><init>([Ljava/lang/String;ILandroid/os/Bundle;)V

    .line 198
    .local v6, "cursor":Landroid/database/MatrixCursor;
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :cond_0
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v12

    if-eqz v12, :cond_33

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;

    .line 199
    .local v1, "accountEntry":Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;
    iget-object v0, v1, Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;->mAccount:Lcom/android/mail/providers/Account;

    .line 200
    .local v0, "account":Lcom/android/mail/providers/Account;
    invoke-virtual {v6}, Landroid/database/MatrixCursor;->newRow()Landroid/database/MatrixCursor$RowBuilder;

    move-result-object v4

    .line 202
    .local v4, "builder":Landroid/database/MatrixCursor$RowBuilder;
    move-object v3, v11

    .local v3, "arr$":[Ljava/lang/String;
    array-length v10, v3

    .local v10, "len$":I
    const/4 v9, 0x0

    .local v9, "i$":I
    :goto_1
    if-ge v9, v10, :cond_0

    aget-object v5, v3, v9

    .line 203
    .local v5, "column":Ljava/lang/String;
    const-string v12, "_id"

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_2

    .line 205
    const/4 v12, 0x0

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    .line 202
    :goto_2
    add-int/lit8 v9, v9, 0x1

    goto :goto_1

    .line 186
    .end local v0    # "account":Lcom/android/mail/providers/Account;
    .end local v1    # "accountEntry":Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;
    .end local v2    # "accountList":Ljava/util/List;, "Ljava/util/List<Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;>;"
    .end local v3    # "arr$":[Ljava/lang/String;
    .end local v4    # "builder":Landroid/database/MatrixCursor$RowBuilder;
    .end local v5    # "column":Ljava/lang/String;
    .end local v6    # "cursor":Landroid/database/MatrixCursor;
    .end local v9    # "i$":I
    .end local v10    # "len$":I
    :cond_1
    const/4 v12, 0x0

    goto :goto_0

    .line 192
    .restart local v2    # "accountList":Ljava/util/List;, "Ljava/util/List<Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;>;"
    :catchall_0
    move-exception v12

    :try_start_1
    monitor-exit v13
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v12

    .line 206
    .restart local v0    # "account":Lcom/android/mail/providers/Account;
    .restart local v1    # "accountEntry":Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;
    .restart local v3    # "arr$":[Ljava/lang/String;
    .restart local v4    # "builder":Landroid/database/MatrixCursor$RowBuilder;
    .restart local v5    # "column":Ljava/lang/String;
    .restart local v6    # "cursor":Landroid/database/MatrixCursor;
    .restart local v9    # "i$":I
    .restart local v10    # "len$":I
    :cond_2
    const-string v12, "name"

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_3

    .line 207
    iget-object v12, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto :goto_2

    .line 208
    :cond_3
    const-string v12, "providerVersion"

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_4

    .line 210
    iget v12, v0, Lcom/android/mail/providers/Account;->providerVersion:I

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto :goto_2

    .line 211
    :cond_4
    const-string v12, "accountUri"

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_5

    .line 212
    iget-object v12, v0, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto :goto_2

    .line 213
    :cond_5
    const-string v12, "capabilities"

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_6

    .line 214
    iget v12, v0, Lcom/android/mail/providers/Account;->capabilities:I

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto :goto_2

    .line 215
    :cond_6
    const-string v12, "folderListUri"

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_7

    .line 216
    iget-object v12, v0, Lcom/android/mail/providers/Account;->folderListUri:Landroid/net/Uri;

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto :goto_2

    .line 217
    :cond_7
    const-string v12, "fullFolderListUri"

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_8

    .line 219
    iget-object v12, v0, Lcom/android/mail/providers/Account;->fullFolderListUri:Landroid/net/Uri;

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto :goto_2

    .line 220
    :cond_8
    const-string v12, "searchUri"

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_9

    .line 221
    iget-object v12, v0, Lcom/android/mail/providers/Account;->searchUri:Landroid/net/Uri;

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto :goto_2

    .line 222
    :cond_9
    const-string v12, "accountFromAddresses"

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_a

    .line 224
    iget-object v12, v0, Lcom/android/mail/providers/Account;->accountFromAddresses:Ljava/lang/String;

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto :goto_2

    .line 225
    :cond_a
    const-string v12, "saveDraftUri"

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_b

    .line 226
    iget-object v12, v0, Lcom/android/mail/providers/Account;->saveDraftUri:Landroid/net/Uri;

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_2

    .line 227
    :cond_b
    const-string v12, "sendMailUri"

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_c

    .line 228
    iget-object v12, v0, Lcom/android/mail/providers/Account;->sendMessageUri:Landroid/net/Uri;

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_2

    .line 229
    :cond_c
    const-string v12, "expungeMessageUri"

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_d

    .line 231
    iget-object v12, v0, Lcom/android/mail/providers/Account;->expungeMessageUri:Landroid/net/Uri;

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_2

    .line 232
    :cond_d
    const-string v12, "undoUri"

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_e

    .line 233
    iget-object v12, v0, Lcom/android/mail/providers/Account;->undoUri:Landroid/net/Uri;

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_2

    .line 234
    :cond_e
    sget-object v12, Lcom/android/mail/providers/UIProvider$AccountColumns;->SETTINGS_INTENT_URI:Ljava/lang/String;

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_f

    .line 236
    iget-object v12, v0, Lcom/android/mail/providers/Account;->settingsIntentUri:Landroid/net/Uri;

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_2

    .line 237
    :cond_f
    sget-object v12, Lcom/android/mail/providers/UIProvider$AccountColumns;->HELP_INTENT_URI:Ljava/lang/String;

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_10

    .line 239
    iget-object v12, v0, Lcom/android/mail/providers/Account;->helpIntentUri:Landroid/net/Uri;

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_2

    .line 240
    :cond_10
    sget-object v12, Lcom/android/mail/providers/UIProvider$AccountColumns;->SEND_FEEDBACK_INTENT_URI:Ljava/lang/String;

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_11

    .line 242
    iget-object v12, v0, Lcom/android/mail/providers/Account;->sendFeedbackIntentUri:Landroid/net/Uri;

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_2

    .line 243
    :cond_11
    sget-object v12, Lcom/android/mail/providers/UIProvider$AccountColumns;->REAUTHENTICATION_INTENT_URI:Ljava/lang/String;

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_12

    .line 245
    iget-object v12, v0, Lcom/android/mail/providers/Account;->reauthenticationIntentUri:Landroid/net/Uri;

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_2

    .line 246
    :cond_12
    const-string v12, "syncStatus"

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_13

    .line 247
    iget v12, v0, Lcom/android/mail/providers/Account;->syncStatus:I

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_2

    .line 248
    :cond_13
    const-string v12, "composeUri"

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_14

    .line 249
    iget-object v12, v0, Lcom/android/mail/providers/Account;->composeIntentUri:Landroid/net/Uri;

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_2

    .line 250
    :cond_14
    const-string v12, "mimeType"

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_15

    .line 251
    iget-object v12, v0, Lcom/android/mail/providers/Account;->mimeType:Ljava/lang/String;

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_2

    .line 252
    :cond_15
    const-string v12, "recentFolderListUri"

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_16

    .line 254
    iget-object v12, v0, Lcom/android/mail/providers/Account;->recentFolderListUri:Landroid/net/Uri;

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_2

    .line 255
    :cond_16
    const-string v12, "defaultRecentFolderListUri"

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_17

    .line 257
    iget-object v12, v0, Lcom/android/mail/providers/Account;->defaultRecentFolderListUri:Landroid/net/Uri;

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_2

    .line 258
    :cond_17
    const-string v12, "manualSyncUri"

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_18

    .line 260
    iget-object v12, v0, Lcom/android/mail/providers/Account;->manualSyncUri:Landroid/net/Uri;

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_2

    .line 261
    :cond_18
    const-string v12, "viewProxyUri"

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_19

    .line 263
    iget-object v12, v0, Lcom/android/mail/providers/Account;->viewIntentProxyUri:Landroid/net/Uri;

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_2

    .line 264
    :cond_19
    const-string v12, "accountCookieUri"

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_1a

    .line 266
    iget-object v12, v0, Lcom/android/mail/providers/Account;->accoutCookieQueryUri:Landroid/net/Uri;

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_2

    .line 267
    :cond_1a
    const-string v12, "color"

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_1b

    .line 268
    iget v12, v0, Lcom/android/mail/providers/Account;->color:I

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_2

    .line 269
    :cond_1b
    const-string v12, "signature"

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_1c

    .line 271
    iget-object v12, v0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    iget-object v12, v12, Lcom/android/mail/providers/Settings;->signature:Ljava/lang/String;

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_2

    .line 272
    :cond_1c
    const-string v12, "auto_advance"

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_1d

    .line 274
    iget-object v12, v0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    iget v12, v12, Lcom/android/mail/providers/Settings;->autoAdvance:I

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_2

    .line 275
    :cond_1d
    const-string v12, "message_text_size"

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_1e

    .line 277
    iget-object v12, v0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    iget v12, v12, Lcom/android/mail/providers/Settings;->messageTextSize:I

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_2

    .line 278
    :cond_1e
    const-string v12, "reply_behavior"

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_1f

    .line 280
    iget-object v12, v0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    iget v12, v12, Lcom/android/mail/providers/Settings;->replyBehavior:I

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_2

    .line 281
    :cond_1f
    const-string v12, "hide_checkboxes"

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_21

    .line 283
    iget-object v12, v0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    iget-boolean v12, v12, Lcom/android/mail/providers/Settings;->hideCheckboxes:Z

    if-eqz v12, :cond_20

    const/4 v12, 0x1

    :goto_3
    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_2

    :cond_20
    const/4 v12, 0x0

    goto :goto_3

    .line 284
    :cond_21
    const-string v12, "confirm_delete"

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_23

    .line 286
    iget-object v12, v0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    iget-boolean v12, v12, Lcom/android/mail/providers/Settings;->confirmDelete:Z

    if-eqz v12, :cond_22

    const/4 v12, 0x1

    :goto_4
    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_2

    :cond_22
    const/4 v12, 0x0

    goto :goto_4

    .line 287
    :cond_23
    const-string v12, "confirm_archive"

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_25

    .line 289
    iget-object v12, v0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    iget-boolean v12, v12, Lcom/android/mail/providers/Settings;->confirmArchive:Z

    if-eqz v12, :cond_24

    const/4 v12, 0x1

    :goto_5
    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_2

    :cond_24
    const/4 v12, 0x0

    goto :goto_5

    .line 290
    :cond_25
    const-string v12, "confirm_send"

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_27

    .line 292
    iget-object v12, v0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    iget-boolean v12, v12, Lcom/android/mail/providers/Settings;->confirmSend:Z

    if-eqz v12, :cond_26

    const/4 v12, 0x1

    :goto_6
    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_2

    :cond_26
    const/4 v12, 0x0

    goto :goto_6

    .line 293
    :cond_27
    const-string v12, "default_inbox"

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_28

    .line 295
    iget-object v12, v0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    iget-object v12, v12, Lcom/android/mail/providers/Settings;->defaultInbox:Landroid/net/Uri;

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_2

    .line 296
    :cond_28
    const-string v12, "default_inbox_name"

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_29

    .line 298
    iget-object v12, v0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    iget-object v12, v12, Lcom/android/mail/providers/Settings;->defaultInboxName:Ljava/lang/String;

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_2

    .line 299
    :cond_29
    const-string v12, "snap_headers"

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_2a

    .line 301
    iget-object v12, v0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    iget v12, v12, Lcom/android/mail/providers/Settings;->snapHeaders:I

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_2

    .line 302
    :cond_2a
    const-string v12, "force_reply_from_default"

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_2c

    .line 304
    iget-object v12, v0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    iget-boolean v12, v12, Lcom/android/mail/providers/Settings;->forceReplyFromDefault:Z

    if-eqz v12, :cond_2b

    const/4 v12, 0x1

    :goto_7
    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_2

    :cond_2b
    const/4 v12, 0x0

    goto :goto_7

    .line 305
    :cond_2c
    const-string v12, "max_attachment_size"

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_2d

    .line 307
    iget-object v12, v0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    iget v12, v12, Lcom/android/mail/providers/Settings;->maxAttachmentSize:I

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_2

    .line 308
    :cond_2d
    const-string v12, "swipe"

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_2e

    .line 310
    iget-object v12, v0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    iget v12, v12, Lcom/android/mail/providers/Settings;->swipe:I

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_2

    .line 311
    :cond_2e
    const-string v12, "priority_inbox_arrows_enabled"

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_30

    .line 313
    iget-object v12, v0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    iget-boolean v12, v12, Lcom/android/mail/providers/Settings;->priorityArrowsEnabled:Z

    if-eqz v12, :cond_2f

    const/4 v12, 0x1

    :goto_8
    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_2

    :cond_2f
    const/4 v12, 0x0

    goto :goto_8

    .line 314
    :cond_30
    const-string v12, "setup_intent_uri"

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_31

    .line 316
    iget-object v12, v0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    iget-object v12, v12, Lcom/android/mail/providers/Settings;->setupIntentUri:Landroid/net/Uri;

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_2

    .line 317
    :cond_31
    const-string v12, "conversation_view_mode"

    invoke-static {v5, v12}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_32

    .line 319
    iget-object v12, v0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    iget v12, v12, Lcom/android/mail/providers/Settings;->conversationViewMode:I

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    invoke-virtual {v4, v12}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto/16 :goto_2

    .line 321
    :cond_32
    new-instance v12, Ljava/lang/IllegalStateException;

    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    const-string v14, "Column not found: "

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-direct {v12, v13}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v12

    .line 326
    .end local v0    # "account":Lcom/android/mail/providers/Account;
    .end local v1    # "accountEntry":Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;
    .end local v3    # "arr$":[Ljava/lang/String;
    .end local v4    # "builder":Landroid/database/MatrixCursor$RowBuilder;
    .end local v5    # "column":Ljava/lang/String;
    .end local v9    # "i$":I
    .end local v10    # "len$":I
    :cond_33
    iget-object v12, p0, Lcom/android/mail/providers/MailAppProvider;->mResolver:Landroid/content/ContentResolver;

    invoke-static {}, Lcom/android/mail/providers/MailAppProvider;->getAccountsUri()Landroid/net/Uri;

    move-result-object v13

    invoke-virtual {v6, v12, v13}, Landroid/database/MatrixCursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    .line 327
    return-object v6
.end method

.method public setLastSentFromAccount(Ljava/lang/String;)V
    .locals 2
    .param p1, "accountUriStr"    # Ljava/lang/String;

    .prologue
    .line 482
    invoke-direct {p0}, Lcom/android/mail/providers/MailAppProvider;->getPreferences()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 483
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v1, "lastSendFromAccount"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 484
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 485
    return-void
.end method

.method public setLastViewedAccount(Ljava/lang/String;)V
    .locals 2
    .param p1, "accountUriStr"    # Ljava/lang/String;

    .prologue
    .line 464
    invoke-direct {p0}, Lcom/android/mail/providers/MailAppProvider;->getPreferences()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 465
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v1, "lastViewedAccount"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 466
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 467
    return-void
.end method

.method public shutdown()V
    .locals 4

    .prologue
    .line 167
    sget-object v3, Lcom/android/mail/providers/MailAppProvider;->PENDING_ACCOUNT_URIS:Ljava/util/Set;

    monitor-enter v3

    .line 168
    const/4 v2, 0x0

    :try_start_0
    sput-object v2, Lcom/android/mail/providers/MailAppProvider;->sInstance:Lcom/android/mail/providers/MailAppProvider;

    .line 169
    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 171
    iget-object v2, p0, Lcom/android/mail/providers/MailAppProvider;->mCursorLoaderMap:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/content/CursorLoader;

    .line 172
    .local v1, "loader":Landroid/content/CursorLoader;
    invoke-virtual {v1}, Landroid/content/CursorLoader;->stopLoading()V

    goto :goto_0

    .line 169
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "loader":Landroid/content/CursorLoader;
    :catchall_0
    move-exception v2

    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v2

    .line 174
    .restart local v0    # "i$":Ljava/util/Iterator;
    :cond_0
    iget-object v2, p0, Lcom/android/mail/providers/MailAppProvider;->mCursorLoaderMap:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->clear()V

    .line 175
    return-void
.end method

.method public update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 1
    .param p1, "url"    # Landroid/net/Uri;
    .param p2, "values"    # Landroid/content/ContentValues;
    .param p3, "selection"    # Ljava/lang/String;
    .param p4, "selectionArgs"    # [Ljava/lang/String;

    .prologue
    .line 338
    const/4 v0, 0x0

    return v0
.end method
