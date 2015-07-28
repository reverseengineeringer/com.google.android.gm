.class public Lcom/google/android/gm/provider/Urls;
.super Ljava/lang/Object;
.source "Urls.java"


# instance fields
.field private mAccount:Ljava/lang/String;

.field private mUri:Ljava/net/URI;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "account"    # Ljava/lang/String;

    .prologue
    .line 92
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 93
    iput-object p1, p0, Lcom/google/android/gm/provider/Urls;->mAccount:Ljava/lang/String;

    .line 94
    invoke-static {p1}, Lcom/google/android/gm/provider/Urls;->getUri(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/Urls;->mUri:Ljava/net/URI;

    .line 95
    return-void
.end method

.method private static accountDomainIsGmail(Ljava/lang/String;)Z
    .locals 2
    .param p0, "domain"    # Ljava/lang/String;

    .prologue
    .line 235
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    const-string v1, "gmail.com"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    const-string v1, "googlemail.com"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static accountGetDomain(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "account"    # Ljava/lang/String;

    .prologue
    .line 178
    const-string v1, ""

    .line 180
    .local v1, "result":Ljava/lang/String;
    if-eqz p0, :cond_0

    .line 181
    const-string v2, "@"

    invoke-virtual {p0, v2}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    .line 183
    .local v0, "index":I
    const/4 v2, -0x1

    if-eq v0, v2, :cond_0

    .line 184
    add-int/lit8 v2, v0, 0x1

    invoke-virtual {p0, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v1

    .line 190
    .end local v0    # "index":I
    :cond_0
    return-object v1
.end method

.method private addStandardParams(ILjava/util/List;)V
    .locals 3
    .param p1, "version"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/NameValuePair;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 284
    .local p2, "params":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/NameValuePair;>;"
    new-instance v0, Lorg/apache/http/message/BasicNameValuePair;

    const-string v1, "version"

    invoke-static {p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {p2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 285
    new-instance v0, Lorg/apache/http/message/BasicNameValuePair;

    const-string v1, "clientVersion"

    const/16 v2, 0x19

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {p2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 287
    new-instance v0, Lorg/apache/http/message/BasicNameValuePair;

    const-string v1, "allowAnyVersion"

    const-string v2, "1"

    invoke-direct {v0, v1, v2}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {p2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 288
    return-void
.end method

.method public static varargs buildUri(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    .locals 7
    .param p0, "base"    # Ljava/lang/String;
    .param p1, "args"    # [Ljava/lang/String;

    .prologue
    .line 565
    array-length v0, p1

    .line 566
    .local v0, "count":I
    new-instance v2, Ljava/util/ArrayList;

    div-int/lit8 v4, v0, 0x2

    invoke-direct {v2, v4}, Ljava/util/ArrayList;-><init>(I)V

    .line 567
    .local v2, "params":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/NameValuePair;>;"
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_0

    .line 568
    new-instance v4, Lorg/apache/http/message/BasicNameValuePair;

    aget-object v5, p1, v1

    add-int/lit8 v6, v1, 0x1

    aget-object v6, p1, v6

    invoke-direct {v4, v5, v6}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v2, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 567
    add-int/lit8 v1, v1, 0x2

    goto :goto_0

    .line 570
    :cond_0
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3, p0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 571
    .local v3, "sb":Ljava/lang/StringBuilder;
    const-string v4, "?"

    invoke-virtual {p0, v4}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v4

    const/4 v5, -0x1

    if-ne v4, v5, :cond_2

    .line 572
    const-string v4, "?"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 576
    :cond_1
    :goto_1
    const-string v4, "UTF-8"

    invoke-static {v2, v4}, Lorg/apache/http/client/utils/URLEncodedUtils;->format(Ljava/util/List;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 577
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    return-object v4

    .line 573
    :cond_2
    const-string v4, "&"

    invoke-virtual {p0, v4}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 574
    const-string v4, "&"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1
.end method

.method private fillEntity(Landroid/content/ContentResolver;Lcom/google/common/io/protocol/ProtoBuf;Lorg/apache/http/client/methods/HttpPost;)V
    .locals 6
    .param p1, "contentResolver"    # Landroid/content/ContentResolver;
    .param p2, "requestProto"    # Lcom/google/common/io/protocol/ProtoBuf;
    .param p3, "httpPost"    # Lorg/apache/http/client/methods/HttpPost;

    .prologue
    .line 156
    :try_start_0
    new-instance v3, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v3}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 157
    .local v3, "os":Ljava/io/ByteArrayOutputStream;
    invoke-virtual {p2, v3}, Lcom/google/common/io/protocol/ProtoBuf;->outputTo(Ljava/io/OutputStream;)V

    .line 159
    const-string v4, "gmail_max_gzip_size_bytes"

    const v5, 0x3d090

    invoke-static {p1, v4, v5}, Lcom/google/android/gsf/Gservices;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v2

    .line 166
    .local v2, "maxSize":I
    invoke-virtual {v3}, Ljava/io/ByteArrayOutputStream;->size()I

    move-result v4

    if-gt v4, v2, :cond_0

    .line 167
    invoke-virtual {v3}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v4

    invoke-static {v4, p1}, Landroid/net/http/AndroidHttpClient;->getCompressedEntity([BLandroid/content/ContentResolver;)Lorg/apache/http/entity/AbstractHttpEntity;

    move-result-object v1

    .line 171
    .local v1, "entity":Lorg/apache/http/entity/AbstractHttpEntity;
    :goto_0
    invoke-virtual {p3, v1}, Lorg/apache/http/client/methods/HttpPost;->setEntity(Lorg/apache/http/HttpEntity;)V

    .line 175
    return-void

    .line 169
    .end local v1    # "entity":Lorg/apache/http/entity/AbstractHttpEntity;
    :cond_0
    new-instance v1, Lorg/apache/http/entity/ByteArrayEntity;

    invoke-virtual {v3}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v4

    invoke-direct {v1, v4}, Lorg/apache/http/entity/ByteArrayEntity;-><init>([B)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .restart local v1    # "entity":Lorg/apache/http/entity/AbstractHttpEntity;
    goto :goto_0

    .line 172
    .end local v1    # "entity":Lorg/apache/http/entity/AbstractHttpEntity;
    .end local v2    # "maxSize":I
    .end local v3    # "os":Ljava/io/ByteArrayOutputStream;
    :catch_0
    move-exception v0

    .line 173
    .local v0, "e":Ljava/io/IOException;
    new-instance v4, Ljava/lang/RuntimeException;

    const-string v5, "Should not get IO errors while writing to ram"

    invoke-direct {v4, v5}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v4
.end method

.method public static getCookie(Ljava/lang/String;Ljava/lang/String;)Lorg/apache/http/cookie/Cookie;
    .locals 6
    .param p0, "account"    # Ljava/lang/String;
    .param p1, "authToken"    # Ljava/lang/String;

    .prologue
    .line 194
    invoke-static {p0}, Lcom/google/android/gm/provider/Urls;->accountGetDomain(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 199
    .local v3, "domain":Ljava/lang/String;
    if-eqz v3, :cond_0

    invoke-static {v3}, Lcom/google/android/gm/provider/Urls;->accountDomainIsGmail(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 200
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 201
    .local v2, "cookiePrefix":Ljava/lang/String;
    const-string v1, "GXAS_SEC"

    .line 207
    .local v1, "cookieName":Ljava/lang/String;
    :goto_0
    new-instance v0, Lorg/apache/http/impl/cookie/BasicClientCookie;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v0, v1, v4}, Lorg/apache/http/impl/cookie/BasicClientCookie;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 208
    .local v0, "cookie":Lorg/apache/http/impl/cookie/BasicClientCookie;
    const-string v4, "google.com"

    invoke-virtual {v0, v4}, Lorg/apache/http/impl/cookie/BasicClientCookie;->setDomain(Ljava/lang/String;)V

    .line 209
    return-object v0

    .line 203
    .end local v0    # "cookie":Lorg/apache/http/impl/cookie/BasicClientCookie;
    .end local v1    # "cookieName":Ljava/lang/String;
    .end local v2    # "cookiePrefix":Ljava/lang/String;
    :cond_0
    const-string v2, ""

    .line 204
    .restart local v2    # "cookiePrefix":Ljava/lang/String;
    const-string v1, "GX"

    .restart local v1    # "cookieName":Ljava/lang/String;
    goto :goto_0
.end method

.method public static getCookieString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 5
    .param p0, "account"    # Ljava/lang/String;
    .param p1, "authToken"    # Ljava/lang/String;

    .prologue
    .line 220
    invoke-static {p0, p1}, Lcom/google/android/gm/provider/Urls;->getCookie(Ljava/lang/String;Ljava/lang/String;)Lorg/apache/http/cookie/Cookie;

    move-result-object v0

    .line 221
    .local v0, "cookie":Lorg/apache/http/cookie/Cookie;
    invoke-interface {v0}, Lorg/apache/http/cookie/Cookie;->getPath()Ljava/lang/String;

    move-result-object v2

    .line 222
    .local v2, "path":Ljava/lang/String;
    invoke-interface {v0}, Lorg/apache/http/cookie/Cookie;->getDomain()Ljava/lang/String;

    move-result-object v1

    .line 223
    .local v1, "domain":Ljava/lang/String;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-interface {v0}, Lorg/apache/http/cookie/Cookie;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-interface {v0}, Lorg/apache/http/cookie/Cookie;->getValue()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "; path="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    if-nez v2, :cond_0

    const-string v2, "/"

    .end local v2    # "path":Ljava/lang/String;
    :cond_0
    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "; domain="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    if-nez v1, :cond_1

    const-string v1, "google.com"

    .end local v1    # "domain":Ljava/lang/String;
    :cond_1
    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3
.end method

.method public static getUri(Ljava/lang/String;)Ljava/net/URI;
    .locals 4
    .param p0, "account"    # Ljava/lang/String;

    .prologue
    .line 105
    invoke-static {p0}, Lcom/google/android/gm/provider/Urls;->accountGetDomain(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 107
    .local v0, "domain":Ljava/lang/String;
    if-eqz v0, :cond_0

    invoke-static {v0}, Lcom/google/android/gm/provider/Urls;->accountDomainIsGmail(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 108
    const-string v2, "https://mail.google.com/a/%domain%/g/"

    const-string v3, "%domain%"

    invoke-virtual {v2, v3, v0}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    .line 112
    .local v1, "uriString":Ljava/lang/String;
    :goto_0
    invoke-static {v1}, Ljava/net/URI;->create(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v2

    return-object v2

    .line 110
    .end local v1    # "uriString":Ljava/lang/String;
    :cond_0
    const-string v1, "https://mail.google.com/mail/g/"

    .restart local v1    # "uriString":Ljava/lang/String;
    goto :goto_0
.end method

.method public static getUriString(Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p0, "account"    # Ljava/lang/String;

    .prologue
    .line 116
    invoke-static {p0}, Lcom/google/android/gm/provider/Urls;->accountGetDomain(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 118
    .local v0, "domain":Ljava/lang/String;
    if-eqz v0, :cond_0

    invoke-static {v0}, Lcom/google/android/gm/provider/Urls;->accountDomainIsGmail(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 119
    const-string v2, "https://mail.google.com/a/%domain%/g/"

    const-string v3, "%domain%"

    invoke-virtual {v2, v3, v0}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    .line 123
    .local v1, "uriString":Ljava/lang/String;
    :goto_0
    return-object v1

    .line 121
    .end local v1    # "uriString":Ljava/lang/String;
    :cond_0
    const-string v1, "https://mail.google.com/mail/g/"

    .restart local v1    # "uriString":Ljava/lang/String;
    goto :goto_0
.end method

.method private getUriWithParams(Ljava/util/List;)Ljava/net/URI;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/NameValuePair;",
            ">;)",
            "Ljava/net/URI;"
        }
    .end annotation

    .prologue
    .line 547
    .local p1, "params":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/NameValuePair;>;"
    const-string v1, "UTF-8"

    invoke-static {p1, v1}, Lorg/apache/http/client/utils/URLEncodedUtils;->format(Ljava/util/List;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 548
    .local v0, "queryString":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 549
    iget-object v1, p0, Lcom/google/android/gm/provider/Urls;->mUri:Ljava/net/URI;

    .line 551
    :goto_0
    return-object v1

    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/google/android/gm/provider/Urls;->mUri:Ljava/net/URI;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "?"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/net/URI;->create(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v1

    goto :goto_0
.end method


# virtual methods
.method public getConversationListUrl(Landroid/content/ContentResolver;ILjava/lang/String;JII)Lorg/apache/http/client/methods/HttpUriRequest;
    .locals 10
    .param p1, "contentResolver"    # Landroid/content/ContentResolver;
    .param p2, "version"    # I
    .param p3, "query"    # Ljava/lang/String;
    .param p4, "highestMessageId"    # J
    .param p6, "maxResults"    # I
    .param p7, "maxSenders"    # I

    .prologue
    .line 500
    const/16 v1, 0x19

    if-lt p2, v1, :cond_0

    .line 501
    new-instance v6, Lcom/google/common/io/protocol/ProtoBuf;

    sget-object v1, Lcom/google/android/gm/provider/protos/GmsProtosMessageTypes;->REQUEST:Lcom/google/common/io/protocol/ProtoBufType;

    invoke-direct {v6, v1}, Lcom/google/common/io/protocol/ProtoBuf;-><init>(Lcom/google/common/io/protocol/ProtoBufType;)V

    .line 502
    .local v6, "requestProto":Lcom/google/common/io/protocol/ProtoBuf;
    const/4 v1, 0x5

    invoke-virtual {v6, v1}, Lcom/google/common/io/protocol/ProtoBuf;->setNewProtoBuf(I)Lcom/google/common/io/protocol/ProtoBuf;

    move-result-object v9

    .line 503
    .local v9, "queryProto":Lcom/google/common/io/protocol/ProtoBuf;
    const/4 v1, 0x1

    invoke-virtual {v9, v1, p3}, Lcom/google/common/io/protocol/ProtoBuf;->setString(ILjava/lang/String;)V

    .line 504
    const/4 v1, 0x2

    invoke-virtual {v9, v1, p4, p5}, Lcom/google/common/io/protocol/ProtoBuf;->setLong(IJ)V

    .line 505
    const/4 v1, 0x3

    move/from16 v0, p6

    invoke-virtual {v9, v1, v0}, Lcom/google/common/io/protocol/ProtoBuf;->setInt(II)V

    .line 506
    const/4 v1, 0x4

    move/from16 v0, p7

    invoke-virtual {v9, v1, v0}, Lcom/google/common/io/protocol/ProtoBuf;->setInt(II)V

    .line 507
    const-string v1, "Gmail"

    const-string v2, "getConversationListUrl: query: %s, highestMessageId: %d, maxResults = %d, maxSenders %d"

    const/4 v3, 0x4

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p3, v3, v4

    const/4 v4, 0x1

    invoke-static {p4, p5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x2

    invoke-static/range {p6 .. p6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x3

    invoke-static/range {p7 .. p7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v1, v2, v3}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 510
    const-wide/16 v4, 0x0

    const/4 v7, 0x1

    move-object v1, p0

    move-object v2, p1

    move v3, p2

    invoke-virtual/range {v1 .. v7}, Lcom/google/android/gm/provider/Urls;->newProtoRequest(Landroid/content/ContentResolver;IJLcom/google/common/io/protocol/ProtoBuf;Z)Lorg/apache/http/client/methods/HttpPost;

    move-result-object v1

    .line 521
    .end local v6    # "requestProto":Lcom/google/common/io/protocol/ProtoBuf;
    .end local v9    # "queryProto":Lcom/google/common/io/protocol/ProtoBuf;
    :goto_0
    return-object v1

    .line 513
    :cond_0
    new-instance v8, Ljava/util/LinkedList;

    invoke-direct {v8}, Ljava/util/LinkedList;-><init>()V

    .line 514
    .local v8, "params":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/NameValuePair;>;"
    invoke-direct {p0, p2, v8}, Lcom/google/android/gm/provider/Urls;->addStandardParams(ILjava/util/List;)V

    .line 515
    new-instance v1, Lorg/apache/http/message/BasicNameValuePair;

    const-string v2, "view"

    const-string v3, "query"

    invoke-direct {v1, v2, v3}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v8, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 516
    new-instance v1, Lorg/apache/http/message/BasicNameValuePair;

    const-string v2, "query"

    invoke-direct {v1, v2, p3}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v8, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 517
    new-instance v1, Lorg/apache/http/message/BasicNameValuePair;

    const-string v2, "highestMessageId"

    invoke-static {p4, p5}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v8, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 518
    new-instance v1, Lorg/apache/http/message/BasicNameValuePair;

    const-string v2, "maxResults"

    invoke-static/range {p6 .. p6}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v8, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 519
    new-instance v1, Lorg/apache/http/message/BasicNameValuePair;

    const-string v2, "maxSenders"

    invoke-static/range {p7 .. p7}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v8, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 521
    new-instance v1, Lorg/apache/http/client/methods/HttpGet;

    invoke-direct {p0, v8}, Lcom/google/android/gm/provider/Urls;->getUriWithParams(Ljava/util/List;)Ljava/net/URI;

    move-result-object v2

    invoke-direct {v1, v2}, Lorg/apache/http/client/methods/HttpGet;-><init>(Ljava/net/URI;)V

    goto :goto_0
.end method

.method public getFetchAttachmentUri(ILjava/lang/String;IZ)Ljava/net/URI;
    .locals 7
    .param p1, "version"    # I
    .param p2, "originExtras"    # Ljava/lang/String;
    .param p3, "maxWidthAndHeight"    # I
    .param p4, "fullVersion"    # Z

    .prologue
    .line 527
    invoke-static {p2}, Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;->splitServerExtras(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 529
    .local v0, "conversationIdMessageIdPartId":[Ljava/lang/String;
    const/4 v4, 0x1

    aget-object v1, v0, v4

    .line 530
    .local v1, "messageId":Ljava/lang/String;
    const/4 v4, 0x2

    aget-object v3, v0, v4

    .line 531
    .local v3, "partId":Ljava/lang/String;
    new-instance v2, Ljava/util/LinkedList;

    invoke-direct {v2}, Ljava/util/LinkedList;-><init>()V

    .line 532
    .local v2, "params":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/NameValuePair;>;"
    invoke-direct {p0, p1, v2}, Lcom/google/android/gm/provider/Urls;->addStandardParams(ILjava/util/List;)V

    .line 533
    new-instance v4, Lorg/apache/http/message/BasicNameValuePair;

    const-string v5, "view"

    const-string v6, "att"

    invoke-direct {v4, v5, v6}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v2, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 534
    new-instance v4, Lorg/apache/http/message/BasicNameValuePair;

    const-string v5, "messageId"

    invoke-direct {v4, v5, v1}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v2, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 535
    new-instance v4, Lorg/apache/http/message/BasicNameValuePair;

    const-string v5, "partId"

    invoke-direct {v4, v5, v3}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v2, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 536
    new-instance v4, Lorg/apache/http/message/BasicNameValuePair;

    const-string v5, "maxWidth"

    invoke-static {p3}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v4, v5, v6}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v2, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 537
    new-instance v4, Lorg/apache/http/message/BasicNameValuePair;

    const-string v5, "maxHeight"

    invoke-static {p3}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v4, v5, v6}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v2, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 538
    new-instance v5, Lorg/apache/http/message/BasicNameValuePair;

    const-string v6, "showOriginal"

    if-eqz p4, :cond_0

    const-string v4, "1"

    :goto_0
    invoke-direct {v5, v6, v4}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v2, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 539
    invoke-direct {p0, v2}, Lcom/google/android/gm/provider/Urls;->getUriWithParams(Ljava/util/List;)Ljava/net/URI;

    move-result-object v4

    return-object v4

    .line 538
    :cond_0
    const-string v4, "0"

    goto :goto_0
.end method

.method public getGetSyncConfigSuggestionRequest(Landroid/content/ContentResolver;IIIDJ)Lorg/apache/http/client/methods/HttpUriRequest;
    .locals 8
    .param p1, "contentResolver"    # Landroid/content/ContentResolver;
    .param p2, "version"    # I
    .param p3, "maxMessageCount"    # I
    .param p4, "alwaysDownloadLabelLimit"    # I
    .param p5, "unreadFractionLimit"    # D
    .param p7, "recentLabelDurationDays"    # J

    .prologue
    .line 256
    const/16 v0, 0x19

    if-lt p2, v0, :cond_0

    .line 257
    new-instance v5, Lcom/google/common/io/protocol/ProtoBuf;

    sget-object v0, Lcom/google/android/gm/provider/protos/GmsProtosMessageTypes;->REQUEST:Lcom/google/common/io/protocol/ProtoBufType;

    invoke-direct {v5, v0}, Lcom/google/common/io/protocol/ProtoBuf;-><init>(Lcom/google/common/io/protocol/ProtoBufType;)V

    .line 261
    .local v5, "requestProto":Lcom/google/common/io/protocol/ProtoBuf;
    const/16 v0, 0x8

    invoke-virtual {v5, v0}, Lcom/google/common/io/protocol/ProtoBuf;->setNewProtoBuf(I)Lcom/google/common/io/protocol/ProtoBuf;

    .line 262
    const-string v0, "Gmail"

    const-string v1, "getSyncConfigSuggestion: GetConfigInfo"

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 263
    const-wide/16 v3, 0x0

    const/4 v6, 0x1

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    invoke-virtual/range {v0 .. v6}, Lcom/google/android/gm/provider/Urls;->newProtoRequest(Landroid/content/ContentResolver;IJLcom/google/common/io/protocol/ProtoBuf;Z)Lorg/apache/http/client/methods/HttpPost;

    move-result-object v0

    .line 279
    .end local v5    # "requestProto":Lcom/google/common/io/protocol/ProtoBuf;
    :goto_0
    return-object v0

    .line 266
    :cond_0
    new-instance v7, Ljava/util/LinkedList;

    invoke-direct {v7}, Ljava/util/LinkedList;-><init>()V

    .line 267
    .local v7, "params":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/NameValuePair;>;"
    invoke-direct {p0, p2, v7}, Lcom/google/android/gm/provider/Urls;->addStandardParams(ILjava/util/List;)V

    .line 268
    new-instance v0, Lorg/apache/http/message/BasicNameValuePair;

    const-string v1, "view"

    const-string v2, "configInfo"

    invoke-direct {v0, v1, v2}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v7, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 270
    new-instance v0, Lorg/apache/http/message/BasicNameValuePair;

    const-string v1, "max_message_count"

    int-to-long v2, p3

    invoke-static {v2, v3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v7, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 272
    new-instance v0, Lorg/apache/http/message/BasicNameValuePair;

    const-string v1, "always_download_label_limit"

    int-to-long v2, p4

    invoke-static {v2, v3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v7, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 274
    new-instance v0, Lorg/apache/http/message/BasicNameValuePair;

    const-string v1, "unread_fraction_limit"

    invoke-static {p5, p6}, Ljava/lang/Double;->toString(D)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v7, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 276
    new-instance v0, Lorg/apache/http/message/BasicNameValuePair;

    const-string v1, "recent_label_duration_days"

    invoke-static/range {p7 .. p8}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v7, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 279
    new-instance v0, Lorg/apache/http/client/methods/HttpGet;

    invoke-direct {p0, v7}, Lcom/google/android/gm/provider/Urls;->getUriWithParams(Ljava/util/List;)Ljava/net/URI;

    move-result-object v1

    invoke-direct {v0, v1}, Lorg/apache/http/client/methods/HttpGet;-><init>(Ljava/net/URI;)V

    goto :goto_0
.end method

.method public getMainSyncRequestProto(Landroid/content/ContentResolver;JJJLjava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Lcom/google/android/gm/provider/MailEngine$SyncInfo;)Lcom/google/common/io/protocol/ProtoBuf;
    .locals 20
    .param p1, "contentResolver"    # Landroid/content/ContentResolver;
    .param p2, "lowestBackwardConversationIdFetched"    # J
    .param p4, "highestHandledServerOperation"    # J
    .param p6, "ackedClientOperation"    # J
    .param p11, "syncInfo"    # Lcom/google/android/gm/provider/MailEngine$SyncInfo;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/ContentResolver;",
            "JJJ",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/google/android/gm/provider/MailSync$ConversationInfo;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/Long;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/Long;",
            ">;",
            "Lcom/google/android/gm/provider/MailEngine$SyncInfo;",
            ")",
            "Lcom/google/common/io/protocol/ProtoBuf;"
        }
    .end annotation

    .prologue
    .line 403
    .local p8, "conversationInfosToCheck":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/google/android/gm/provider/MailSync$ConversationInfo;>;"
    .local p9, "messageIdsToFetch":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Long;>;"
    .local p10, "dirtyConversations":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Long;>;"
    new-instance v11, Lcom/google/common/io/protocol/ProtoBuf;

    sget-object v14, Lcom/google/android/gm/provider/protos/GmsProtosMessageTypes;->REQUEST:Lcom/google/common/io/protocol/ProtoBufType;

    invoke-direct {v11, v14}, Lcom/google/common/io/protocol/ProtoBuf;-><init>(Lcom/google/common/io/protocol/ProtoBufType;)V

    .line 405
    .local v11, "requestProto":Lcom/google/common/io/protocol/ProtoBuf;
    const/4 v14, 0x4

    invoke-virtual {v11, v14}, Lcom/google/common/io/protocol/ProtoBuf;->setNewProtoBuf(I)Lcom/google/common/io/protocol/ProtoBuf;

    move-result-object v8

    .line 406
    .local v8, "mainSyncProto":Lcom/google/common/io/protocol/ProtoBuf;
    const/4 v14, 0x1

    move-wide/from16 v0, p2

    invoke-virtual {v8, v14, v0, v1}, Lcom/google/common/io/protocol/ProtoBuf;->setLong(IJ)V

    .line 408
    const/4 v14, 0x2

    move-wide/from16 v0, p4

    invoke-virtual {v8, v14, v0, v1}, Lcom/google/common/io/protocol/ProtoBuf;->setLong(IJ)V

    .line 410
    const/4 v14, 0x3

    const/16 v15, 0xc8

    invoke-virtual {v8, v14, v15}, Lcom/google/common/io/protocol/ProtoBuf;->setInt(II)V

    .line 413
    const/4 v14, 0x6

    const/4 v15, 0x1

    invoke-virtual {v8, v14, v15}, Lcom/google/common/io/protocol/ProtoBuf;->setBool(IZ)V

    .line 414
    const/16 v14, 0x8

    const/4 v15, 0x1

    invoke-virtual {v8, v14, v15}, Lcom/google/common/io/protocol/ProtoBuf;->setBool(IZ)V

    .line 415
    const/16 v14, 0x9

    const/4 v15, 0x1

    invoke-virtual {v8, v14, v15}, Lcom/google/common/io/protocol/ProtoBuf;->setBool(IZ)V

    .line 417
    const/4 v14, 0x7

    const-string v15, "gmail_compression_type"

    const/16 v16, 0x3

    move-object/from16 v0, p1

    move/from16 v1, v16

    invoke-static {v0, v15, v1}, Lcom/google/android/gsf/Gservices;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v15

    invoke-virtual {v8, v14, v15}, Lcom/google/common/io/protocol/ProtoBuf;->setInt(II)V

    .line 421
    const/16 v14, 0xa

    const/4 v15, 0x1

    invoke-virtual {v8, v14, v15}, Lcom/google/common/io/protocol/ProtoBuf;->setBool(IZ)V

    .line 423
    const/16 v14, 0xb

    const-string v15, "gmail_main_sync_max_conversion_headers"

    const/16 v16, 0x0

    move-object/from16 v0, p1

    move/from16 v1, v16

    invoke-static {v0, v15, v1}, Lcom/google/android/gsf/Gservices;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v15

    invoke-virtual {v8, v14, v15}, Lcom/google/common/io/protocol/ProtoBuf;->setInt(II)V

    .line 427
    const/16 v14, 0xc

    const/4 v15, 0x5

    invoke-virtual {v8, v14, v15}, Lcom/google/common/io/protocol/ProtoBuf;->setInt(II)V

    .line 429
    const/4 v14, 0x7

    invoke-virtual {v11, v14}, Lcom/google/common/io/protocol/ProtoBuf;->setNewProtoBuf(I)Lcom/google/common/io/protocol/ProtoBuf;

    move-result-object v13

    .line 430
    .local v13, "uphillSyncProto":Lcom/google/common/io/protocol/ProtoBuf;
    const/4 v14, 0x2

    move-wide/from16 v0, p6

    invoke-virtual {v13, v14, v0, v1}, Lcom/google/common/io/protocol/ProtoBuf;->setLong(IJ)V

    .line 432
    const-string v14, "Gmail"

    const-string v15, "MainSyncRequestProto: lowestBkwdConvoId: %d, highestHandledServerOp: %d, normalSync: %b"

    const/16 v16, 0x3

    move/from16 v0, v16

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v16, v0

    const/16 v17, 0x0

    invoke-static/range {p2 .. p3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v18

    aput-object v18, v16, v17

    const/16 v17, 0x1

    invoke-static/range {p4 .. p5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v18

    aput-object v18, v16, v17

    const/16 v17, 0x2

    move-object/from16 v0, p11

    iget-boolean v0, v0, Lcom/google/android/gm/provider/MailEngine$SyncInfo;->normalSync:Z

    move/from16 v18, v0

    invoke-static/range {v18 .. v18}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v18

    aput-object v18, v16, v17

    invoke-static/range {v14 .. v16}, Lcom/google/android/gm/provider/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 436
    const/4 v2, 0x0

    .line 437
    .local v2, "conversationSyncProto":Lcom/google/common/io/protocol/ProtoBuf;
    const/4 v4, 0x0

    .local v4, "i":I
    invoke-virtual/range {p8 .. p8}, Ljava/util/ArrayList;->size()I

    move-result v12

    .local v12, "size":I
    :goto_0
    if-ge v4, v12, :cond_2

    .line 438
    move-object/from16 v0, p8

    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/google/android/gm/provider/MailSync$ConversationInfo;

    .line 439
    .local v7, "info":Lcom/google/android/gm/provider/MailSync$ConversationInfo;
    if-nez v2, :cond_0

    .line 440
    const/4 v14, 0x3

    invoke-virtual {v11, v14}, Lcom/google/common/io/protocol/ProtoBuf;->setNewProtoBuf(I)Lcom/google/common/io/protocol/ProtoBuf;

    move-result-object v2

    .line 442
    :cond_0
    const/4 v14, 0x1

    invoke-virtual {v2, v14}, Lcom/google/common/io/protocol/ProtoBuf;->addNewProtoBuf(I)Lcom/google/common/io/protocol/ProtoBuf;

    move-result-object v3

    .line 444
    .local v3, "fetchConversationProto":Lcom/google/common/io/protocol/ProtoBuf;
    const/4 v14, 0x1

    iget-wide v15, v7, Lcom/google/android/gm/provider/MailSync$ConversationInfo;->id:J

    move-wide v0, v15

    invoke-virtual {v3, v14, v0, v1}, Lcom/google/common/io/protocol/ProtoBuf;->setLong(IJ)V

    .line 446
    const/4 v14, 0x2

    iget-wide v15, v7, Lcom/google/android/gm/provider/MailSync$ConversationInfo;->highestFetchedMessageId:J

    move-wide v0, v15

    invoke-virtual {v3, v14, v0, v1}, Lcom/google/common/io/protocol/ProtoBuf;->setLong(IJ)V

    .line 456
    iget-wide v14, v7, Lcom/google/android/gm/provider/MailSync$ConversationInfo;->highestFetchedMessageId:J

    const-wide/16 v16, 0x0

    cmp-long v14, v14, v16

    if-nez v14, :cond_1

    .line 457
    const/4 v14, 0x4

    iget-wide v15, v7, Lcom/google/android/gm/provider/MailSync$ConversationInfo;->id:J

    move-wide v0, v15

    invoke-virtual {v2, v14, v0, v1}, Lcom/google/common/io/protocol/ProtoBuf;->addLong(IJ)V

    .line 460
    :cond_1
    const-string v14, "Gmail"

    const-string v15, "MainSyncRequestProto: fetchConversation: ConvoId: %d, HighestMessageIdOnClient: %d"

    const/16 v16, 0x2

    move/from16 v0, v16

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v16, v0

    const/16 v17, 0x0

    iget-wide v0, v7, Lcom/google/android/gm/provider/MailSync$ConversationInfo;->id:J

    move-wide/from16 v18, v0

    invoke-static/range {v18 .. v19}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v18

    aput-object v18, v16, v17

    const/16 v17, 0x1

    iget-wide v0, v7, Lcom/google/android/gm/provider/MailSync$ConversationInfo;->highestFetchedMessageId:J

    move-wide/from16 v18, v0

    invoke-static/range {v18 .. v19}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v18

    aput-object v18, v16, v17

    invoke-static/range {v14 .. v16}, Lcom/google/android/gm/provider/LogUtils;->v(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 437
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 464
    .end local v3    # "fetchConversationProto":Lcom/google/common/io/protocol/ProtoBuf;
    .end local v7    # "info":Lcom/google/android/gm/provider/MailSync$ConversationInfo;
    :cond_2
    const/4 v4, 0x0

    invoke-virtual/range {p10 .. p10}, Ljava/util/ArrayList;->size()I

    move-result v12

    :goto_1
    if-ge v4, v12, :cond_4

    .line 465
    move-object/from16 v0, p10

    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Ljava/lang/Long;

    invoke-virtual {v14}, Ljava/lang/Long;->longValue()J

    move-result-wide v5

    .line 466
    .local v5, "id":J
    if-nez v2, :cond_3

    .line 467
    const/4 v14, 0x3

    invoke-virtual {v11, v14}, Lcom/google/common/io/protocol/ProtoBuf;->setNewProtoBuf(I)Lcom/google/common/io/protocol/ProtoBuf;

    move-result-object v2

    .line 469
    :cond_3
    const/4 v14, 0x4

    invoke-virtual {v2, v14, v5, v6}, Lcom/google/common/io/protocol/ProtoBuf;->addLong(IJ)V

    .line 470
    const-string v14, "Gmail"

    const-string v15, "MainSyncRequestProto: ConversationSyncDirtyConversationId: %d"

    const/16 v16, 0x1

    move/from16 v0, v16

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v16, v0

    const/16 v17, 0x0

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v18

    aput-object v18, v16, v17

    invoke-static/range {v14 .. v16}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 464
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    .line 473
    .end local v5    # "id":J
    :cond_4
    move-object/from16 v0, p11

    iget-boolean v14, v0, Lcom/google/android/gm/provider/MailEngine$SyncInfo;->normalSync:Z

    if-nez v14, :cond_6

    .line 474
    const/4 v14, 0x5

    const/4 v15, 0x0

    invoke-virtual {v8, v14, v15}, Lcom/google/common/io/protocol/ProtoBuf;->setInt(II)V

    .line 494
    :cond_5
    return-object v11

    .line 478
    :cond_6
    const/4 v14, 0x5

    const-string v15, "gmail_main_sync_max_forward_sync_items_limit"

    const/16 v16, 0x3e8

    move-object/from16 v0, p1

    move/from16 v1, v16

    invoke-static {v0, v15, v1}, Lcom/google/android/gsf/Gservices;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v15

    invoke-virtual {v8, v14, v15}, Lcom/google/common/io/protocol/ProtoBuf;->setInt(II)V

    .line 485
    const/4 v4, 0x0

    invoke-virtual/range {p9 .. p9}, Ljava/util/ArrayList;->size()I

    move-result v12

    :goto_2
    if-ge v4, v12, :cond_5

    .line 486
    move-object/from16 v0, p9

    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Ljava/lang/Long;

    invoke-virtual {v14}, Ljava/lang/Long;->longValue()J

    move-result-wide v9

    .line 487
    .local v9, "messageId":J
    if-nez v2, :cond_7

    .line 488
    const/4 v14, 0x3

    invoke-virtual {v11, v14}, Lcom/google/common/io/protocol/ProtoBuf;->setNewProtoBuf(I)Lcom/google/common/io/protocol/ProtoBuf;

    move-result-object v2

    .line 490
    :cond_7
    const/4 v14, 0x2

    invoke-virtual {v2, v14, v9, v10}, Lcom/google/common/io/protocol/ProtoBuf;->addLong(IJ)V

    .line 491
    const-string v14, "Gmail"

    const-string v15, "MainSyncRequestProto: ConversationSyncMessageId: %d"

    const/16 v16, 0x1

    move/from16 v0, v16

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v16, v0

    const/16 v17, 0x0

    invoke-static {v9, v10}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v18

    aput-object v18, v16, v17

    invoke-static/range {v14 .. v16}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 485
    add-int/lit8 v4, v4, 0x1

    goto :goto_2
.end method

.method public getStartSyncRequest(Landroid/content/ContentResolver;IJJJJJ)Lorg/apache/http/client/methods/HttpUriRequest;
    .locals 11
    .param p1, "contentResolver"    # Landroid/content/ContentResolver;
    .param p2, "version"    # I
    .param p3, "clientId"    # J
    .param p5, "handledServerOperationId"    # J
    .param p7, "upperFetchedConversationId"    # J
    .param p9, "lowerFetchedConversationId"    # J
    .param p11, "ackedClientOperation"    # J

    .prologue
    .line 348
    const/16 v2, 0x19

    if-lt p2, v2, :cond_0

    .line 349
    new-instance v7, Lcom/google/common/io/protocol/ProtoBuf;

    sget-object v2, Lcom/google/android/gm/provider/protos/GmsProtosMessageTypes;->REQUEST:Lcom/google/common/io/protocol/ProtoBufType;

    invoke-direct {v7, v2}, Lcom/google/common/io/protocol/ProtoBuf;-><init>(Lcom/google/common/io/protocol/ProtoBufType;)V

    .line 350
    .local v7, "requestProto":Lcom/google/common/io/protocol/ProtoBuf;
    const/4 v2, 0x6

    invoke-virtual {v7, v2}, Lcom/google/common/io/protocol/ProtoBuf;->setNewProtoBuf(I)Lcom/google/common/io/protocol/ProtoBuf;

    move-result-object v10

    .line 351
    .local v10, "startSyncProto":Lcom/google/common/io/protocol/ProtoBuf;
    const/4 v2, 0x1

    move-wide/from16 v0, p5

    invoke-virtual {v10, v2, v0, v1}, Lcom/google/common/io/protocol/ProtoBuf;->setLong(IJ)V

    .line 353
    const/4 v2, 0x2

    move-wide/from16 v0, p7

    invoke-virtual {v10, v2, v0, v1}, Lcom/google/common/io/protocol/ProtoBuf;->setLong(IJ)V

    .line 355
    const/4 v2, 0x3

    move-wide/from16 v0, p9

    invoke-virtual {v10, v2, v0, v1}, Lcom/google/common/io/protocol/ProtoBuf;->setLong(IJ)V

    .line 357
    const/4 v2, 0x4

    move-wide/from16 v0, p11

    invoke-virtual {v10, v2, v0, v1}, Lcom/google/common/io/protocol/ProtoBuf;->setLong(IJ)V

    .line 359
    const/4 v2, 0x5

    const/4 v3, 0x1

    invoke-virtual {v10, v2, v3}, Lcom/google/common/io/protocol/ProtoBuf;->setBool(IZ)V

    .line 360
    const/4 v2, 0x6

    const/4 v3, 0x1

    invoke-virtual {v10, v2, v3}, Lcom/google/common/io/protocol/ProtoBuf;->setBool(IZ)V

    .line 361
    const/4 v2, 0x7

    const/4 v3, 0x1

    invoke-virtual {v10, v2, v3}, Lcom/google/common/io/protocol/ProtoBuf;->setBool(IZ)V

    .line 364
    const/16 v2, 0x9

    const/4 v3, 0x1

    invoke-virtual {v10, v2, v3}, Lcom/google/common/io/protocol/ProtoBuf;->setBool(IZ)V

    .line 367
    const-string v2, "Gmail"

    const-string v3, "getStartSyncRequest: handledServerOpId: %d, upperFetchedConvoId: %d, lowerFetchedConvoId: %d, ackedClientOp: %d"

    const/4 v4, 0x4

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-static/range {p5 .. p6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    invoke-static/range {p7 .. p8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x2

    invoke-static/range {p9 .. p10}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x3

    invoke-static/range {p11 .. p12}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v2, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 370
    const/4 v8, 0x1

    move-object v2, p0

    move-object v3, p1

    move v4, p2

    move-wide v5, p3

    invoke-virtual/range {v2 .. v8}, Lcom/google/android/gm/provider/Urls;->newProtoRequest(Landroid/content/ContentResolver;IJLcom/google/common/io/protocol/ProtoBuf;Z)Lorg/apache/http/client/methods/HttpPost;

    move-result-object v2

    .line 386
    .end local v7    # "requestProto":Lcom/google/common/io/protocol/ProtoBuf;
    .end local v10    # "startSyncProto":Lcom/google/common/io/protocol/ProtoBuf;
    :goto_0
    return-object v2

    .line 373
    :cond_0
    new-instance v9, Ljava/util/LinkedList;

    invoke-direct {v9}, Ljava/util/LinkedList;-><init>()V

    .line 374
    .local v9, "params":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/NameValuePair;>;"
    invoke-direct {p0, p2, v9}, Lcom/google/android/gm/provider/Urls;->addStandardParams(ILjava/util/List;)V

    .line 375
    new-instance v2, Lorg/apache/http/message/BasicNameValuePair;

    const-string v3, "view"

    const-string v4, "start"

    invoke-direct {v2, v3, v4}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v9, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 376
    new-instance v2, Lorg/apache/http/message/BasicNameValuePair;

    const-string v3, "client"

    invoke-static {p3, p4}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v9, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 377
    new-instance v2, Lorg/apache/http/message/BasicNameValuePair;

    const-string v3, "acked_client_op"

    invoke-static/range {p11 .. p12}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v9, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 379
    new-instance v2, Lorg/apache/http/message/BasicNameValuePair;

    const-string v3, "server_op"

    invoke-static/range {p5 .. p6}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v9, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 381
    new-instance v2, Lorg/apache/http/message/BasicNameValuePair;

    const-string v3, "upper_message"

    invoke-static/range {p7 .. p8}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v9, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 383
    new-instance v2, Lorg/apache/http/message/BasicNameValuePair;

    const-string v3, "lower_message"

    invoke-static/range {p9 .. p10}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v9, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 386
    new-instance v2, Lorg/apache/http/client/methods/HttpGet;

    invoke-direct {p0, v9}, Lcom/google/android/gm/provider/Urls;->getUriWithParams(Ljava/util/List;)Ljava/net/URI;

    move-result-object v3

    invoke-direct {v2, v3}, Lorg/apache/http/client/methods/HttpGet;-><init>(Ljava/net/URI;)V

    goto :goto_0
.end method

.method public getSyncConfigRequest(Landroid/content/ContentResolver;IJLjava/util/Set;Ljava/util/Set;JJ)Lorg/apache/http/client/methods/HttpUriRequest;
    .locals 14
    .param p1, "contentResolver"    # Landroid/content/ContentResolver;
    .param p2, "version"    # I
    .param p3, "clientId"    # J
    .param p7, "conversationAgeDays"    # J
    .param p9, "maxAttachmentSizeMb"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/ContentResolver;",
            "IJ",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;JJ)",
            "Lorg/apache/http/client/methods/HttpUriRequest;"
        }
    .end annotation

    .prologue
    .line 304
    .local p5, "labelsIncluded":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .local p6, "labelsPartial":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    const/16 v2, 0x19

    move/from16 v0, p2

    if-lt v0, v2, :cond_2

    .line 305
    new-instance v7, Lcom/google/common/io/protocol/ProtoBuf;

    sget-object v2, Lcom/google/android/gm/provider/protos/GmsProtosMessageTypes;->REQUEST:Lcom/google/common/io/protocol/ProtoBufType;

    invoke-direct {v7, v2}, Lcom/google/common/io/protocol/ProtoBuf;-><init>(Lcom/google/common/io/protocol/ProtoBufType;)V

    .line 306
    .local v7, "requestProto":Lcom/google/common/io/protocol/ProtoBuf;
    const/4 v2, 0x2

    invoke-virtual {v7, v2}, Lcom/google/common/io/protocol/ProtoBuf;->setNewProtoBuf(I)Lcom/google/common/io/protocol/ProtoBuf;

    move-result-object v13

    .line 307
    .local v13, "syncConfigProto":Lcom/google/common/io/protocol/ProtoBuf;
    const/4 v2, 0x1

    move-wide/from16 v0, p7

    long-to-int v3, v0

    invoke-virtual {v13, v2, v3}, Lcom/google/common/io/protocol/ProtoBuf;->setInt(II)V

    .line 308
    invoke-interface/range {p5 .. p5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v10

    .local v10, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v10}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v10}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/String;

    .line 309
    .local v9, "canonicalName":Ljava/lang/String;
    const/4 v2, 0x2

    invoke-virtual {v13, v2, v9}, Lcom/google/common/io/protocol/ProtoBuf;->addString(ILjava/lang/String;)V

    goto :goto_0

    .line 312
    .end local v9    # "canonicalName":Ljava/lang/String;
    :cond_0
    invoke-interface/range {p6 .. p6}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v10

    :goto_1
    invoke-interface {v10}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v10}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/String;

    .line 313
    .restart local v9    # "canonicalName":Ljava/lang/String;
    const/4 v2, 0x3

    invoke-virtual {v13, v2, v9}, Lcom/google/common/io/protocol/ProtoBuf;->addString(ILjava/lang/String;)V

    goto :goto_1

    .line 316
    .end local v9    # "canonicalName":Ljava/lang/String;
    :cond_1
    const-string v2, "Gmail"

    const-string v3, "getSyncConfigRequest: conversationAgeDays: %d, labelsIncluded: %s, labelsPartial: %s"

    const/4 v4, 0x3

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-static/range {p7 .. p8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    aput-object p5, v4, v5

    const/4 v5, 0x2

    aput-object p6, v4, v5

    invoke-static {v2, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 319
    const/4 v8, 0x1

    move-object v2, p0

    move-object v3, p1

    move/from16 v4, p2

    move-wide/from16 v5, p3

    invoke-virtual/range {v2 .. v8}, Lcom/google/android/gm/provider/Urls;->newProtoRequest(Landroid/content/ContentResolver;IJLcom/google/common/io/protocol/ProtoBuf;Z)Lorg/apache/http/client/methods/HttpPost;

    move-result-object v2

    .line 339
    .end local v7    # "requestProto":Lcom/google/common/io/protocol/ProtoBuf;
    .end local v13    # "syncConfigProto":Lcom/google/common/io/protocol/ProtoBuf;
    :goto_2
    return-object v2

    .line 322
    .end local v10    # "i$":Ljava/util/Iterator;
    :cond_2
    new-instance v12, Ljava/util/LinkedList;

    invoke-direct {v12}, Ljava/util/LinkedList;-><init>()V

    .line 323
    .local v12, "params":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/NameValuePair;>;"
    move/from16 v0, p2

    invoke-direct {p0, v0, v12}, Lcom/google/android/gm/provider/Urls;->addStandardParams(ILjava/util/List;)V

    .line 324
    new-instance v2, Lorg/apache/http/message/BasicNameValuePair;

    const-string v3, "view"

    const-string v4, "config"

    invoke-direct {v2, v3, v4}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v12, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 325
    new-instance v2, Lorg/apache/http/message/BasicNameValuePair;

    const-string v3, "client"

    invoke-static/range {p3 .. p4}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v12, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 326
    invoke-interface/range {p5 .. p5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v10

    .restart local v10    # "i$":Ljava/util/Iterator;
    :goto_3
    invoke-interface {v10}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_3

    invoke-interface {v10}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/lang/String;

    .line 327
    .local v11, "label":Ljava/lang/String;
    new-instance v2, Lorg/apache/http/message/BasicNameValuePair;

    const-string v3, "labelsIncluded"

    invoke-direct {v2, v3, v11}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v12, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_3

    .line 329
    .end local v11    # "label":Ljava/lang/String;
    :cond_3
    invoke-interface/range {p6 .. p6}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v10

    :goto_4
    invoke-interface {v10}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_4

    invoke-interface {v10}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/lang/String;

    .line 330
    .restart local v11    # "label":Ljava/lang/String;
    new-instance v2, Lorg/apache/http/message/BasicNameValuePair;

    const-string v3, "labelsInDuration"

    invoke-direct {v2, v3, v11}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v12, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_4

    .line 332
    .end local v11    # "label":Ljava/lang/String;
    :cond_4
    new-instance v2, Lorg/apache/http/message/BasicNameValuePair;

    const-string v3, "age"

    invoke-static/range {p7 .. p8}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v12, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 334
    new-instance v2, Lorg/apache/http/message/BasicNameValuePair;

    const-string v3, "attach_size"

    invoke-static/range {p9 .. p10}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v12, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 336
    new-instance v2, Lorg/apache/http/message/BasicNameValuePair;

    const-string v3, "includeInDuration"

    const/4 v4, 0x1

    invoke-static {v4}, Ljava/lang/Boolean;->toString(Z)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v12, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 337
    new-instance v2, Lorg/apache/http/message/BasicNameValuePair;

    const-string v3, "notificationMethod"

    const-string v4, "syncServer"

    invoke-direct {v2, v3, v4}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v12, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 339
    new-instance v2, Lorg/apache/http/client/methods/HttpGet;

    invoke-direct {p0, v12}, Lcom/google/android/gm/provider/Urls;->getUriWithParams(Ljava/util/List;)Ljava/net/URI;

    move-result-object v3

    invoke-direct {v2, v3}, Lorg/apache/http/client/methods/HttpGet;-><init>(Ljava/net/URI;)V

    goto/16 :goto_2
.end method

.method public newHttpContext(Ljava/lang/String;Lorg/apache/http/client/CookieStore;)Lorg/apache/http/protocol/HttpContext;
    .locals 2
    .param p1, "authToken"    # Ljava/lang/String;
    .param p2, "cookieStore"    # Lorg/apache/http/client/CookieStore;

    .prologue
    .line 98
    new-instance v0, Lorg/apache/http/protocol/BasicHttpContext;

    invoke-direct {v0}, Lorg/apache/http/protocol/BasicHttpContext;-><init>()V

    .line 99
    .local v0, "context":Lorg/apache/http/protocol/HttpContext;
    const-string v1, "http.cookie-store"

    invoke-interface {v0, v1, p2}, Lorg/apache/http/protocol/HttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V

    .line 100
    iget-object v1, p0, Lcom/google/android/gm/provider/Urls;->mAccount:Ljava/lang/String;

    invoke-static {v1, p1}, Lcom/google/android/gm/provider/Urls;->getCookie(Ljava/lang/String;Ljava/lang/String;)Lorg/apache/http/cookie/Cookie;

    move-result-object v1

    invoke-interface {p2, v1}, Lorg/apache/http/client/CookieStore;->addCookie(Lorg/apache/http/cookie/Cookie;)V

    .line 101
    return-object v0
.end method

.method public newProtoRequest(Landroid/content/ContentResolver;IJLcom/google/common/io/protocol/ProtoBuf;Z)Lorg/apache/http/client/methods/HttpPost;
    .locals 7
    .param p1, "contentResolver"    # Landroid/content/ContentResolver;
    .param p2, "version"    # I
    .param p3, "clientId"    # J
    .param p5, "requestProto"    # Lcom/google/common/io/protocol/ProtoBuf;
    .param p6, "fillEntity"    # Z

    .prologue
    const/4 v4, 0x1

    .line 132
    const/16 v2, 0x19

    if-ge p2, v2, :cond_0

    .line 133
    new-instance v2, Ljava/lang/IllegalArgumentException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Cannot make a proto request for version "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 137
    :cond_0
    const-wide/16 v2, 0x0

    cmp-long v2, p3, v2

    if-eqz v2, :cond_1

    .line 138
    invoke-virtual {p5, v4, p3, p4}, Lcom/google/common/io/protocol/ProtoBuf;->setLong(IJ)V

    .line 139
    const-string v2, "Gmail"

    const-string v3, "ProtoRequest: clientid: %d"

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-static {p3, p4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v2, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 142
    :cond_1
    new-instance v1, Ljava/util/LinkedList;

    invoke-direct {v1}, Ljava/util/LinkedList;-><init>()V

    .line 143
    .local v1, "params":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/NameValuePair;>;"
    invoke-direct {p0, p2, v1}, Lcom/google/android/gm/provider/Urls;->addStandardParams(ILjava/util/List;)V

    .line 144
    new-instance v0, Lorg/apache/http/client/methods/HttpPost;

    invoke-direct {p0, v1}, Lcom/google/android/gm/provider/Urls;->getUriWithParams(Ljava/util/List;)Ljava/net/URI;

    move-result-object v2

    invoke-direct {v0, v2}, Lorg/apache/http/client/methods/HttpPost;-><init>(Ljava/net/URI;)V

    .line 146
    .local v0, "httpPost":Lorg/apache/http/client/methods/HttpPost;
    if-eqz p6, :cond_2

    .line 147
    invoke-direct {p0, p1, p5, v0}, Lcom/google/android/gm/provider/Urls;->fillEntity(Landroid/content/ContentResolver;Lcom/google/common/io/protocol/ProtoBuf;Lorg/apache/http/client/methods/HttpPost;)V

    .line 150
    :cond_2
    return-object v0
.end method

.method public serverUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 543
    iget-object v0, p0, Lcom/google/android/gm/provider/Urls;->mUri:Ljava/net/URI;

    invoke-virtual {v0}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
