.class public Lcom/android/mail/utils/AttachmentUtils;
.super Ljava/lang/Object;
.source "AttachmentUtils.java"


# static fields
.field private static sDisplayNameMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 30
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static convertToHumanReadableSize(Landroid/content/Context;J)Ljava/lang/String;
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "size"    # J

    .prologue
    const-wide/16 v3, 0x400

    .line 45
    const-wide/16 v1, 0x0

    cmp-long v1, p1, v1

    if-nez v1, :cond_0

    .line 46
    const-string v1, ""

    .line 53
    :goto_0
    return-object v1

    .line 47
    :cond_0
    cmp-long v1, p1, v3

    if-gez v1, :cond_1

    .line 48
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    const v2, 0x7f0c0066

    invoke-virtual {p0, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 49
    :cond_1
    const-wide/32 v1, 0x100000

    cmp-long v1, p1, v1

    if-gez v1, :cond_2

    .line 50
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    div-long v2, p1, v3

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    const v2, 0x7f0c0067

    invoke-virtual {p0, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 52
    :cond_2
    new-instance v0, Ljava/text/DecimalFormat;

    const-string v1, "0.#"

    invoke-direct {v0, v1}, Ljava/text/DecimalFormat;-><init>(Ljava/lang/String;)V

    .line 53
    .local v0, "onePlace":Ljava/text/DecimalFormat;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    long-to-float v2, p1

    const/high16 v3, 0x49800000    # 1048576.0f

    div-float/2addr v2, v3

    float-to-double v2, v2

    invoke-virtual {v0, v2, v3}, Ljava/text/DecimalFormat;->format(D)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const v2, 0x7f0c0068

    invoke-virtual {p0, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method public static getDisplayType(Landroid/content/Context;Lcom/android/mail/providers/Attachment;)Ljava/lang/String;
    .locals 7
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "attachment"    # Lcom/android/mail/providers/Attachment;

    .prologue
    const/4 v6, 0x0

    const/4 v5, 0x1

    .line 68
    iget-object v3, p1, Lcom/android/mail/providers/Attachment;->contentType:Ljava/lang/String;

    invoke-static {p0, v3}, Lcom/android/mail/utils/AttachmentUtils;->getMimeTypeDisplayName(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 69
    .local v0, "displayType":Ljava/lang/String;
    iget-object v3, p1, Lcom/android/mail/providers/Attachment;->contentType:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_3

    iget-object v3, p1, Lcom/android/mail/providers/Attachment;->contentType:Ljava/lang/String;

    const/16 v4, 0x2f

    invoke-virtual {v3, v4}, Ljava/lang/String;->indexOf(I)I

    move-result v2

    .line 71
    .local v2, "index":I
    :goto_0
    if-nez v0, :cond_0

    if-lez v2, :cond_0

    .line 72
    iget-object v3, p1, Lcom/android/mail/providers/Attachment;->contentType:Ljava/lang/String;

    invoke-virtual {v3, v6, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    invoke-static {p0, v3}, Lcom/android/mail/utils/AttachmentUtils;->getMimeTypeDisplayName(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 75
    :cond_0
    if-nez v0, :cond_1

    .line 76
    iget-object v3, p1, Lcom/android/mail/providers/Attachment;->name:Ljava/lang/String;

    invoke-static {v3}, Lcom/android/mail/utils/Utils;->getFileExtension(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 78
    .local v1, "extension":Ljava/lang/String;
    if-eqz v1, :cond_1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v3

    if-le v3, v5, :cond_1

    const/16 v3, 0x2e

    invoke-virtual {v1, v3}, Ljava/lang/String;->indexOf(I)I

    move-result v3

    if-nez v3, :cond_1

    .line 79
    const v3, 0x7f0c0071

    new-array v4, v5, [Ljava/lang/Object;

    invoke-virtual {v1, v5}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-virtual {p0, v3, v4}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 83
    .end local v1    # "extension":Ljava/lang/String;
    :cond_1
    if-nez v0, :cond_2

    .line 85
    const-string v0, ""

    .line 87
    :cond_2
    return-object v0

    .line 69
    .end local v2    # "index":I
    :cond_3
    const/4 v2, -0x1

    goto :goto_0
.end method

.method public static getIdentifier(Lcom/android/mail/providers/Attachment;)Ljava/lang/String;
    .locals 2
    .param p0, "attachment"    # Lcom/android/mail/providers/Attachment;

    .prologue
    .line 133
    iget-object v0, p0, Lcom/android/mail/providers/Attachment;->contentUri:Landroid/net/Uri;

    .line 134
    .local v0, "uri":Landroid/net/Uri;
    if-eqz v0, :cond_0

    .line 135
    invoke-virtual {v0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v1

    .line 137
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static declared-synchronized getMimeTypeDisplayName(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    .locals 7
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "type"    # Ljava/lang/String;

    .prologue
    .line 99
    const-class v4, Lcom/android/mail/utils/AttachmentUtils;

    monitor-enter v4

    :try_start_0
    sget-object v3, Lcom/android/mail/utils/AttachmentUtils;->sDisplayNameMap:Ljava/util/Map;

    if-nez v3, :cond_0

    .line 100
    const v3, 0x7f0c006d

    invoke-virtual {p0, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 101
    .local v0, "docName":Ljava/lang/String;
    const v3, 0x7f0c006e

    invoke-virtual {p0, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 102
    .local v1, "presoName":Ljava/lang/String;
    const v3, 0x7f0c006f

    invoke-virtual {p0, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 104
    .local v2, "sheetName":Ljava/lang/String;
    new-instance v3, Lcom/google/common/collect/ImmutableMap$Builder;

    invoke-direct {v3}, Lcom/google/common/collect/ImmutableMap$Builder;-><init>()V

    const-string v5, "image"

    const v6, 0x7f0c0069

    invoke-virtual {p0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3, v5, v6}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v3

    const-string v5, "audio"

    const v6, 0x7f0c006b

    invoke-virtual {p0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3, v5, v6}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v3

    const-string v5, "video"

    const v6, 0x7f0c006a

    invoke-virtual {p0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3, v5, v6}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v3

    const-string v5, "text"

    const v6, 0x7f0c006c

    invoke-virtual {p0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3, v5, v6}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v3

    const-string v5, "application/pdf"

    const v6, 0x7f0c0070

    invoke-virtual {p0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3, v5, v6}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v3

    const-string v5, "application/msword"

    invoke-virtual {v3, v5, v0}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v3

    const-string v5, "application/vnd.openxmlformats-officedocument.wordprocessingml.document"

    invoke-virtual {v3, v5, v0}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v3

    const-string v5, "application/vnd.ms-powerpoint"

    invoke-virtual {v3, v5, v1}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v3

    const-string v5, "application/vnd.openxmlformats-officedocument.presentationml.presentation"

    invoke-virtual {v3, v5, v1}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v3

    const-string v5, "application/vnd.ms-excel"

    invoke-virtual {v3, v5, v2}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v3

    const-string v5, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"

    invoke-virtual {v3, v5, v2}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/common/collect/ImmutableMap$Builder;->build()Lcom/google/common/collect/ImmutableMap;

    move-result-object v3

    sput-object v3, Lcom/android/mail/utils/AttachmentUtils;->sDisplayNameMap:Ljava/util/Map;

    .line 129
    .end local v0    # "docName":Ljava/lang/String;
    .end local v1    # "presoName":Ljava/lang/String;
    .end local v2    # "sheetName":Ljava/lang/String;
    :cond_0
    sget-object v3, Lcom/android/mail/utils/AttachmentUtils;->sDisplayNameMap:Ljava/util/Map;

    invoke-interface {v3, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v4

    return-object v3

    .line 99
    :catchall_0
    move-exception v3

    monitor-exit v4

    throw v3
.end method
