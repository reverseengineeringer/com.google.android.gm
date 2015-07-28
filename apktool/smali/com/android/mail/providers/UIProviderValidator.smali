.class public Lcom/android/mail/providers/UIProviderValidator;
.super Ljava/lang/Object;
.source "UIProviderValidator.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 33
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static getValidProjection([Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/String;
    .locals 4
    .param p0, "requestedProjection"    # [Ljava/lang/String;
    .param p1, "allColumnProjection"    # [Ljava/lang/String;

    .prologue
    .line 80
    if-eqz p0, :cond_1

    .line 81
    invoke-static {p1}, Lcom/google/common/collect/ImmutableSet;->copyOf([Ljava/lang/Object;)Lcom/google/common/collect/ImmutableSet;

    move-result-object v1

    invoke-static {p0, v1}, Lcom/android/mail/providers/UIProviderValidator;->isValidProjection([Ljava/lang/String;Ljava/util/Set;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 83
    move-object v0, p0

    .line 92
    .local v0, "resultProjection":[Ljava/lang/String;
    :goto_0
    return-object v0

    .line 85
    .end local v0    # "resultProjection":[Ljava/lang/String;
    :cond_0
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Invalid projection: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p0}, Ljava/util/Arrays;->toString([Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 90
    :cond_1
    move-object v0, p1

    .restart local v0    # "resultProjection":[Ljava/lang/String;
    goto :goto_0
.end method

.method private static isValidProjection([Ljava/lang/String;Ljava/util/Set;)Z
    .locals 5
    .param p0, "projection"    # [Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Ljava/lang/String;",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .line 96
    .local p1, "validColumns":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    move-object v0, p0

    .local v0, "arr$":[Ljava/lang/String;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_1

    aget-object v1, v0, v2

    .line 97
    .local v1, "column":Ljava/lang/String;
    invoke-interface {p1, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 98
    const/4 v4, 0x0

    .line 101
    .end local v1    # "column":Ljava/lang/String;
    :goto_1
    return v4

    .line 96
    .restart local v1    # "column":Ljava/lang/String;
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 101
    .end local v1    # "column":Ljava/lang/String;
    :cond_1
    const/4 v4, 0x1

    goto :goto_1
.end method

.method public static validateAccountCookieProjection([Ljava/lang/String;)[Ljava/lang/String;
    .locals 1
    .param p0, "projection"    # [Ljava/lang/String;

    .prologue
    .line 52
    sget-object v0, Lcom/android/mail/providers/UIProvider;->ACCOUNT_COOKIE_PROJECTION:[Ljava/lang/String;

    invoke-static {p0, v0}, Lcom/android/mail/providers/UIProviderValidator;->getValidProjection([Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static validateAccountProjection([Ljava/lang/String;)[Ljava/lang/String;
    .locals 1
    .param p0, "projection"    # [Ljava/lang/String;

    .prologue
    .line 38
    sget-object v0, Lcom/android/mail/providers/UIProvider;->ACCOUNTS_PROJECTION:[Ljava/lang/String;

    invoke-static {p0, v0}, Lcom/android/mail/providers/UIProviderValidator;->getValidProjection([Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static validateAttachmentProjection([Ljava/lang/String;)[Ljava/lang/String;
    .locals 1
    .param p0, "projection"    # [Ljava/lang/String;

    .prologue
    .line 73
    sget-object v0, Lcom/android/mail/providers/UIProvider;->ATTACHMENT_PROJECTION:[Ljava/lang/String;

    invoke-static {p0, v0}, Lcom/android/mail/providers/UIProviderValidator;->getValidProjection([Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static validateConversationProjection([Ljava/lang/String;)[Ljava/lang/String;
    .locals 1
    .param p0, "projection"    # [Ljava/lang/String;

    .prologue
    .line 59
    sget-object v0, Lcom/android/mail/providers/UIProvider;->CONVERSATION_PROJECTION:[Ljava/lang/String;

    invoke-static {p0, v0}, Lcom/android/mail/providers/UIProviderValidator;->getValidProjection([Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static validateFolderProjection([Ljava/lang/String;)[Ljava/lang/String;
    .locals 1
    .param p0, "projection"    # [Ljava/lang/String;

    .prologue
    .line 45
    sget-object v0, Lcom/android/mail/providers/UIProvider;->FOLDERS_PROJECTION:[Ljava/lang/String;

    invoke-static {p0, v0}, Lcom/android/mail/providers/UIProviderValidator;->getValidProjection([Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static validateMessageProjection([Ljava/lang/String;)[Ljava/lang/String;
    .locals 1
    .param p0, "projection"    # [Ljava/lang/String;

    .prologue
    .line 66
    sget-object v0, Lcom/android/mail/providers/UIProvider;->MESSAGE_PROJECTION:[Ljava/lang/String;

    invoke-static {p0, v0}, Lcom/android/mail/providers/UIProviderValidator;->getValidProjection([Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
