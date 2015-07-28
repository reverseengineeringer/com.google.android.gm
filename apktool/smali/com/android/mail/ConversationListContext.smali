.class public Lcom/android/mail/ConversationListContext;
.super Ljava/lang/Object;
.source "ConversationListContext.java"


# static fields
.field private static final sUrlMatcher:Landroid/content/UriMatcher;


# instance fields
.field public final account:Lcom/android/mail/providers/Account;

.field public final folder:Lcom/android/mail/providers/Folder;

.field public final searchQuery:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    .line 48
    new-instance v0, Landroid/content/UriMatcher;

    const/4 v1, -0x1

    invoke-direct {v0, v1}, Landroid/content/UriMatcher;-><init>(I)V

    sput-object v0, Lcom/android/mail/ConversationListContext;->sUrlMatcher:Landroid/content/UriMatcher;

    .line 63
    sget-object v0, Lcom/android/mail/ConversationListContext;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "com.android.mail.providers"

    const-string v2, "account/*/folder/*"

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 64
    return-void
.end method

.method private constructor <init>(Lcom/android/mail/providers/Account;Ljava/lang/String;Lcom/android/mail/providers/Folder;)V
    .locals 0
    .param p1, "a"    # Lcom/android/mail/providers/Account;
    .param p2, "query"    # Ljava/lang/String;
    .param p3, "f"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 104
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 105
    iput-object p1, p0, Lcom/android/mail/ConversationListContext;->account:Lcom/android/mail/providers/Account;

    .line 106
    iput-object p2, p0, Lcom/android/mail/ConversationListContext;->searchQuery:Ljava/lang/String;

    .line 107
    iput-object p3, p0, Lcom/android/mail/ConversationListContext;->folder:Lcom/android/mail/providers/Folder;

    .line 108
    return-void
.end method

.method public static forBundle(Landroid/os/Bundle;)Lcom/android/mail/ConversationListContext;
    .locals 4
    .param p0, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 72
    const-string v2, "account"

    invoke-virtual {p0, v2}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Account;

    .line 73
    .local v0, "account":Lcom/android/mail/providers/Account;
    const-string v2, "folder"

    invoke-virtual {p0, v2}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Lcom/android/mail/providers/Folder;

    .line 74
    .local v1, "folder":Lcom/android/mail/providers/Folder;
    new-instance v2, Lcom/android/mail/ConversationListContext;

    const-string v3, "query"

    invoke-virtual {p0, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v0, v3, v1}, Lcom/android/mail/ConversationListContext;-><init>(Lcom/android/mail/providers/Account;Ljava/lang/String;Lcom/android/mail/providers/Folder;)V

    return-object v2
.end method

.method public static forFolder(Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;)Lcom/android/mail/ConversationListContext;
    .locals 2
    .param p0, "account"    # Lcom/android/mail/providers/Account;
    .param p1, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 85
    new-instance v0, Lcom/android/mail/ConversationListContext;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1, p1}, Lcom/android/mail/ConversationListContext;-><init>(Lcom/android/mail/providers/Account;Ljava/lang/String;Lcom/android/mail/providers/Folder;)V

    return-object v0
.end method

.method public static forSearchQuery(Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;Ljava/lang/String;)Lcom/android/mail/ConversationListContext;
    .locals 2
    .param p0, "account"    # Lcom/android/mail/providers/Account;
    .param p1, "folder"    # Lcom/android/mail/providers/Folder;
    .param p2, "query"    # Ljava/lang/String;

    .prologue
    .line 93
    new-instance v1, Lcom/android/mail/ConversationListContext;

    invoke-static {p2}, Lcom/google/common/base/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-direct {v1, p0, v0, p1}, Lcom/android/mail/ConversationListContext;-><init>(Lcom/android/mail/providers/Account;Ljava/lang/String;Lcom/android/mail/providers/Folder;)V

    return-object v1
.end method

.method public static final isSearchResult(Lcom/android/mail/ConversationListContext;)Z
    .locals 1
    .param p0, "in"    # Lcom/android/mail/ConversationListContext;

    .prologue
    .line 116
    if-eqz p0, :cond_0

    iget-object v0, p0, Lcom/android/mail/ConversationListContext;->searchQuery:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public toBundle()Landroid/os/Bundle;
    .locals 3

    .prologue
    .line 123
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 124
    .local v0, "result":Landroid/os/Bundle;
    const-string v1, "account"

    iget-object v2, p0, Lcom/android/mail/ConversationListContext;->account:Lcom/android/mail/providers/Account;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 125
    const-string v1, "query"

    iget-object v2, p0, Lcom/android/mail/ConversationListContext;->searchQuery:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 126
    const-string v1, "folder"

    iget-object v2, p0, Lcom/android/mail/ConversationListContext;->folder:Lcom/android/mail/providers/Folder;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 127
    return-object v0
.end method
