.class Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;
.super Ljava/lang/Object;
.source "MailAppProvider.java"

# interfaces
.implements Ljava/lang/Comparable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/providers/MailAppProvider;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "AccountCacheEntry"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/lang/Comparable",
        "<",
        "Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;",
        ">;"
    }
.end annotation


# static fields
.field private static final ACCOUNT_ENTRY_COMPONENT_SEPARATOR_PATTERN:Ljava/util/regex/Pattern;


# instance fields
.field final mAccount:Lcom/android/mail/providers/Account;

.field final mAccountsQueryUri:Landroid/net/Uri;

.field final mPosition:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 631
    const-string v0, "\\^\\*\\*\\^"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;->ACCOUNT_ENTRY_COMPONENT_SEPARATOR_PATTERN:Ljava/util/regex/Pattern;

    return-void
.end method

.method public constructor <init>(Lcom/android/mail/providers/Account;Landroid/net/Uri;I)V
    .locals 0
    .param p1, "account"    # Lcom/android/mail/providers/Account;
    .param p2, "accountQueryUri"    # Landroid/net/Uri;
    .param p3, "position"    # I

    .prologue
    .line 636
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 637
    iput-object p1, p0, Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;->mAccount:Lcom/android/mail/providers/Account;

    .line 638
    iput-object p2, p0, Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;->mAccountsQueryUri:Landroid/net/Uri;

    .line 639
    iput p3, p0, Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;->mPosition:I

    .line 640
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;I)V
    .locals 4
    .param p1, "serializedString"    # Ljava/lang/String;
    .param p2, "position"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    const/4 v3, 0x1

    .line 662
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 663
    sget-object v1, Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;->ACCOUNT_ENTRY_COMPONENT_SEPARATOR_PATTERN:Ljava/util/regex/Pattern;

    invoke-static {p1, v1}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/util/regex/Pattern;)[Ljava/lang/String;

    move-result-object v0

    .line 665
    .local v0, "cacheEntryMembers":[Ljava/lang/String;
    array-length v1, v0

    const/4 v2, 0x2

    if-eq v1, v2, :cond_0

    .line 666
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "AccountCacheEntry de-serializing failed. Wrong number of members detected. "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    array-length v3, v0

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " detected"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 670
    :cond_0
    const/4 v1, 0x0

    aget-object v1, v0, v1

    invoke-static {v1}, Lcom/android/mail/providers/Account;->newinstance(Ljava/lang/String;)Lcom/android/mail/providers/Account;

    move-result-object v1

    iput-object v1, p0, Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;->mAccount:Lcom/android/mail/providers/Account;

    .line 671
    iget-object v1, p0, Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;->mAccount:Lcom/android/mail/providers/Account;

    if-nez v1, :cond_1

    .line 672
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "AccountCacheEntry de-serializing failed. Account object could not be created from the serialized string: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 676
    :cond_1
    iget-object v1, p0, Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v1, v1, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    sget-object v2, Lcom/android/mail/providers/Settings;->EMPTY_SETTINGS:Lcom/android/mail/providers/Settings;

    if-ne v1, v2, :cond_2

    .line 677
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "AccountCacheEntry de-serializing failed. Settings could not be created from the string: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 680
    :cond_2
    aget-object v1, v0, v3

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_3

    aget-object v1, v0, v3

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    :goto_0
    iput-object v1, p0, Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;->mAccountsQueryUri:Landroid/net/Uri;

    .line 682
    iput p2, p0, Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;->mPosition:I

    .line 683
    return-void

    .line 680
    :cond_3
    const/4 v1, 0x0

    goto :goto_0
.end method


# virtual methods
.method public compareTo(Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;)I
    .locals 2
    .param p1, "o"    # Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;

    .prologue
    .line 687
    iget v0, p0, Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;->mPosition:I

    iget v1, p1, Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;->mPosition:I

    sub-int/2addr v0, v1

    return v0
.end method

.method public bridge synthetic compareTo(Ljava/lang/Object;)I
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 625
    check-cast p1, Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;->compareTo(Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;)I

    move-result v0

    return v0
.end method

.method public declared-synchronized serialize()Ljava/lang/String;
    .locals 4

    .prologue
    .line 646
    monitor-enter p0

    :try_start_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 647
    .local v1, "out":Ljava/lang/StringBuilder;
    iget-object v2, p0, Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;->mAccount:Lcom/android/mail/providers/Account;

    invoke-virtual {v2}, Lcom/android/mail/providers/Account;->serialize()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "^**^"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 648
    iget-object v2, p0, Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;->mAccountsQueryUri:Landroid/net/Uri;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/android/mail/providers/MailAppProvider$AccountCacheEntry;->mAccountsQueryUri:Landroid/net/Uri;

    invoke-virtual {v2}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    .line 650
    .local v0, "accountQueryUri":Ljava/lang/String;
    :goto_0
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 651
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v2

    monitor-exit p0

    return-object v2

    .line 648
    .end local v0    # "accountQueryUri":Ljava/lang/String;
    :cond_0
    :try_start_1
    const-string v0, ""
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 646
    .end local v1    # "out":Ljava/lang/StringBuilder;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method
