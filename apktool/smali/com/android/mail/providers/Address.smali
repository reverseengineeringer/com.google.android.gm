.class public Lcom/android/mail/providers/Address;
.super Ljava/lang/Object;
.source "Address.java"


# static fields
.field private static final EMPTY_ADDRESS_ARRAY:[Lcom/android/mail/providers/Address;

.field private static final LOG_TAG:Ljava/lang/String;

.field private static final REMOVE_OPTIONAL_BRACKET:Ljava/util/regex/Pattern;

.field private static final REMOVE_OPTIONAL_DQUOTE:Ljava/util/regex/Pattern;

.field private static final UNQUOTE:Ljava/util/regex/Pattern;


# instance fields
.field private mAddress:Ljava/lang/String;

.field private mName:Ljava/lang/String;

.field private mSimplifiedName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 66
    const-string v0, "^<?([^>]+)>?$"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/android/mail/providers/Address;->REMOVE_OPTIONAL_BRACKET:Ljava/util/regex/Pattern;

    .line 68
    const-string v0, "^\"?([^\"]*)\"?$"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/android/mail/providers/Address;->REMOVE_OPTIONAL_DQUOTE:Ljava/util/regex/Pattern;

    .line 70
    const-string v0, "\\\\([\\\\\"])"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/android/mail/providers/Address;->UNQUOTE:Ljava/util/regex/Pattern;

    .line 72
    const/4 v0, 0x0

    new-array v0, v0, [Lcom/android/mail/providers/Address;

    sput-object v0, Lcom/android/mail/providers/Address;->EMPTY_ADDRESS_ARRAY:[Lcom/android/mail/providers/Address;

    .line 78
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/providers/Address;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "address"    # Ljava/lang/String;

    .prologue
    .line 80
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 81
    invoke-virtual {p0, p1}, Lcom/android/mail/providers/Address;->setName(Ljava/lang/String;)V

    .line 82
    invoke-virtual {p0, p2}, Lcom/android/mail/providers/Address;->setAddress(Ljava/lang/String;)V

    .line 83
    return-void
.end method

.method public static declared-synchronized getEmailAddress(Ljava/lang/String;)Lcom/android/mail/providers/Address;
    .locals 6
    .param p0, "rawAddress"    # Ljava/lang/String;

    .prologue
    .line 114
    const-class v5, Lcom/android/mail/providers/Address;

    monitor-enter v5

    :try_start_0
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v4

    if-eqz v4, :cond_0

    .line 115
    const/4 v4, 0x0

    .line 127
    :goto_0
    monitor-exit v5

    return-object v4

    .line 118
    :cond_0
    :try_start_1
    invoke-static {p0}, Landroid/text/util/Rfc822Tokenizer;->tokenize(Ljava/lang/CharSequence;)[Landroid/text/util/Rfc822Token;

    move-result-object v3

    .line 119
    .local v3, "tokens":[Landroid/text/util/Rfc822Token;
    array-length v4, v3

    if-lez v4, :cond_2

    .line 120
    const/4 v4, 0x0

    aget-object v4, v3, v4

    invoke-virtual {v4}, Landroid/text/util/Rfc822Token;->getName()Ljava/lang/String;

    move-result-object v2

    .line 121
    .local v2, "tokenizedName":Ljava/lang/String;
    if-eqz v2, :cond_1

    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    .line 122
    .local v1, "name":Ljava/lang/String;
    :goto_1
    const/4 v4, 0x0

    aget-object v4, v3, v4

    invoke-virtual {v4}, Landroid/text/util/Rfc822Token;->getAddress()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 127
    .end local v2    # "tokenizedName":Ljava/lang/String;
    .local v0, "address":Ljava/lang/String;
    :goto_2
    new-instance v4, Lcom/android/mail/providers/Address;

    invoke-direct {v4, v1, v0}, Lcom/android/mail/providers/Address;-><init>(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 114
    .end local v0    # "address":Ljava/lang/String;
    .end local v1    # "name":Ljava/lang/String;
    .end local v3    # "tokens":[Landroid/text/util/Rfc822Token;
    :catchall_0
    move-exception v4

    monitor-exit v5

    throw v4

    .line 121
    .restart local v2    # "tokenizedName":Ljava/lang/String;
    .restart local v3    # "tokens":[Landroid/text/util/Rfc822Token;
    :cond_1
    :try_start_2
    const-string v1, ""

    goto :goto_1

    .line 124
    .end local v2    # "tokenizedName":Ljava/lang/String;
    :cond_2
    const-string v1, ""

    .line 125
    .restart local v1    # "name":Ljava/lang/String;
    if-nez p0, :cond_3

    const-string v0, ""

    .restart local v0    # "address":Ljava/lang/String;
    :goto_3
    goto :goto_2

    .end local v0    # "address":Ljava/lang/String;
    :cond_3
    invoke-static {p0}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result-object v0

    goto :goto_3
.end method

.method static isValidAddress(Ljava/lang/String;)Z
    .locals 3
    .param p0, "address"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 224
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 228
    :cond_0
    :goto_0
    return v1

    .line 227
    :cond_1
    const-string v2, "@"

    invoke-virtual {p0, v2}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    .line 228
    .local v0, "index":I
    const/4 v2, -0x1

    if-eq v0, v2, :cond_0

    new-instance v2, Lcom/android/common/Rfc822Validator;

    invoke-virtual {p0, v1, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v2, v1}, Lcom/android/common/Rfc822Validator;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p0}, Lcom/android/common/Rfc822Validator;->isValid(Ljava/lang/CharSequence;)Z

    move-result v1

    goto :goto_0
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 2
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    .line 234
    instance-of v0, p1, Lcom/android/mail/providers/Address;

    if-eqz v0, :cond_0

    .line 243
    invoke-virtual {p0}, Lcom/android/mail/providers/Address;->getAddress()Ljava/lang/String;

    move-result-object v0

    check-cast p1, Lcom/android/mail/providers/Address;

    .end local p1    # "o":Ljava/lang/Object;
    invoke-virtual {p1}, Lcom/android/mail/providers/Address;->getAddress()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    .line 245
    :goto_0
    return v0

    .restart local p1    # "o":Ljava/lang/Object;
    :cond_0
    invoke-super {p0, p1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    goto :goto_0
.end method

.method public getAddress()Ljava/lang/String;
    .locals 1

    .prologue
    .line 135
    iget-object v0, p0, Lcom/android/mail/providers/Address;->mAddress:Ljava/lang/String;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 148
    iget-object v0, p0, Lcom/android/mail/providers/Address;->mName:Ljava/lang/String;

    return-object v0
.end method

.method public getSimplifiedName()Ljava/lang/String;
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 91
    iget-object v2, p0, Lcom/android/mail/providers/Address;->mSimplifiedName:Ljava/lang/String;

    if-nez v2, :cond_0

    .line 92
    iget-object v2, p0, Lcom/android/mail/providers/Address;->mName:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/android/mail/providers/Address;->mAddress:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 93
    iget-object v2, p0, Lcom/android/mail/providers/Address;->mAddress:Ljava/lang/String;

    const/16 v3, 0x40

    invoke-virtual {v2, v3}, Ljava/lang/String;->indexOf(I)I

    move-result v0

    .line 94
    .local v0, "atSign":I
    const/4 v2, -0x1

    if-eq v0, v2, :cond_1

    iget-object v2, p0, Lcom/android/mail/providers/Address;->mAddress:Ljava/lang/String;

    invoke-virtual {v2, v4, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    :goto_0
    iput-object v2, p0, Lcom/android/mail/providers/Address;->mSimplifiedName:Ljava/lang/String;

    .line 110
    .end local v0    # "atSign":I
    :cond_0
    :goto_1
    iget-object v2, p0, Lcom/android/mail/providers/Address;->mSimplifiedName:Ljava/lang/String;

    return-object v2

    .line 94
    .restart local v0    # "atSign":I
    :cond_1
    const-string v2, ""

    goto :goto_0

    .line 95
    .end local v0    # "atSign":I
    :cond_2
    iget-object v2, p0, Lcom/android/mail/providers/Address;->mName:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_5

    .line 99
    iget-object v2, p0, Lcom/android/mail/providers/Address;->mName:Ljava/lang/String;

    const/16 v3, 0x20

    invoke-virtual {v2, v3}, Ljava/lang/String;->indexOf(I)I

    move-result v1

    .line 100
    .local v1, "end":I
    :goto_2
    if-lez v1, :cond_3

    iget-object v2, p0, Lcom/android/mail/providers/Address;->mName:Ljava/lang/String;

    add-int/lit8 v3, v1, -0x1

    invoke-virtual {v2, v3}, Ljava/lang/String;->charAt(I)C

    move-result v2

    const/16 v3, 0x2c

    if-ne v2, v3, :cond_3

    .line 101
    add-int/lit8 v1, v1, -0x1

    goto :goto_2

    .line 103
    :cond_3
    const/4 v2, 0x1

    if-ge v1, v2, :cond_4

    iget-object v2, p0, Lcom/android/mail/providers/Address;->mName:Ljava/lang/String;

    :goto_3
    iput-object v2, p0, Lcom/android/mail/providers/Address;->mSimplifiedName:Ljava/lang/String;

    goto :goto_1

    :cond_4
    iget-object v2, p0, Lcom/android/mail/providers/Address;->mName:Ljava/lang/String;

    invoke-virtual {v2, v4, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    goto :goto_3

    .line 106
    .end local v1    # "end":I
    :cond_5
    sget-object v2, Lcom/android/mail/providers/Address;->LOG_TAG:Ljava/lang/String;

    const-string v3, "Unable to get a simplified name"

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v2, v3, v4}, Lcom/android/mail/utils/LogUtils;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 107
    const-string v2, ""

    iput-object v2, p0, Lcom/android/mail/providers/Address;->mSimplifiedName:Ljava/lang/String;

    goto :goto_1
.end method

.method public setAddress(Ljava/lang/String;)V
    .locals 2
    .param p1, "address"    # Ljava/lang/String;

    .prologue
    .line 139
    sget-object v0, Lcom/android/mail/providers/Address;->REMOVE_OPTIONAL_BRACKET:Ljava/util/regex/Pattern;

    invoke-virtual {v0, p1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    const-string v1, "$1"

    invoke-virtual {v0, v1}, Ljava/util/regex/Matcher;->replaceAll(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Address;->mAddress:Ljava/lang/String;

    .line 140
    return-void
.end method

.method public setName(Ljava/lang/String;)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 158
    if-eqz p1, :cond_0

    .line 159
    sget-object v0, Lcom/android/mail/providers/Address;->REMOVE_OPTIONAL_DQUOTE:Ljava/util/regex/Pattern;

    invoke-virtual {v0, p1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    const-string v1, "$1"

    invoke-virtual {v0, v1}, Ljava/util/regex/Matcher;->replaceAll(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    .line 160
    sget-object v0, Lcom/android/mail/providers/Address;->UNQUOTE:Ljava/util/regex/Pattern;

    invoke-virtual {v0, p1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    const-string v1, "$1"

    invoke-virtual {v0, v1}, Ljava/util/regex/Matcher;->replaceAll(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    .line 161
    invoke-static {p1}, Lorg/apache/james/mime4j/decoder/DecoderUtil;->decodeEncodedWords(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    .line 162
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_0

    .line 163
    const/4 p1, 0x0

    .line 166
    :cond_0
    iput-object p1, p0, Lcom/android/mail/providers/Address;->mName:Ljava/lang/String;

    .line 167
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 256
    iget-object v0, p0, Lcom/android/mail/providers/Address;->mName:Ljava/lang/String;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/android/mail/providers/Address;->mName:Ljava/lang/String;

    iget-object v1, p0, Lcom/android/mail/providers/Address;->mAddress:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 257
    iget-object v0, p0, Lcom/android/mail/providers/Address;->mName:Ljava/lang/String;

    const-string v1, ".*[\\(\\)<>@,;:\\\\\".\\[\\]].*"

    invoke-virtual {v0, v1}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 258
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/android/mail/providers/Address;->mName:Ljava/lang/String;

    invoke-static {v1}, Lcom/android/mail/utils/Utils;->ensureQuotedString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " <"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/android/mail/providers/Address;->mAddress:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ">"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 263
    :goto_0
    return-object v0

    .line 260
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/android/mail/providers/Address;->mName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " <"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/android/mail/providers/Address;->mAddress:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ">"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 263
    :cond_1
    iget-object v0, p0, Lcom/android/mail/providers/Address;->mAddress:Ljava/lang/String;

    goto :goto_0
.end method
