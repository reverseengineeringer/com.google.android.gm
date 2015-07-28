.class public Lcom/google/android/gm/provider/ZipUtils;
.super Ljava/lang/Object;
.source "ZipUtils.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static deflate([B)[B
    .locals 2
    .param p0, "data"    # [B

    .prologue
    .line 119
    const/4 v0, 0x0

    array-length v1, p0

    invoke-static {p0, v0, v1}, Lcom/google/android/gm/provider/ZipUtils;->deflate([BII)[B

    move-result-object v0

    return-object v0
.end method

.method public static deflate([BII)[B
    .locals 5
    .param p0, "data"    # [B
    .param p1, "offset"    # I
    .param p2, "length"    # I

    .prologue
    .line 103
    new-instance v2, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v2}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 104
    .local v2, "out":Ljava/io/ByteArrayOutputStream;
    new-instance v1, Ljava/util/zip/DeflaterOutputStream;

    new-instance v3, Ljava/util/zip/Deflater;

    invoke-direct {v3}, Ljava/util/zip/Deflater;-><init>()V

    invoke-direct {v1, v2, v3}, Ljava/util/zip/DeflaterOutputStream;-><init>(Ljava/io/OutputStream;Ljava/util/zip/Deflater;)V

    .line 106
    .local v1, "os":Ljava/util/zip/DeflaterOutputStream;
    :try_start_0
    invoke-virtual {v1, p0, p1, p2}, Ljava/util/zip/DeflaterOutputStream;->write([BII)V

    .line 107
    invoke-virtual {v1}, Ljava/util/zip/DeflaterOutputStream;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 112
    invoke-virtual {v2}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v3

    return-object v3

    .line 108
    :catch_0
    move-exception v0

    .line 110
    .local v0, "e":Ljava/io/IOException;
    new-instance v3, Ljava/lang/IllegalStateException;

    const-string v4, "ByteArrayOutputStream threw "

    invoke-direct {v3, v4, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v3
.end method

.method public static inflate(Ljava/util/zip/Inflater;)[B
    .locals 2
    .param p0, "inflater"    # Ljava/util/zip/Inflater;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/util/zip/DataFormatException;
        }
    .end annotation

    .prologue
    .line 41
    invoke-static {p0}, Lcom/google/android/gm/provider/ZipUtils;->inflateToStream(Ljava/util/zip/Inflater;)Ljava/io/ByteArrayOutputStream;

    move-result-object v0

    .line 42
    .local v0, "out":Ljava/io/ByteArrayOutputStream;
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v1

    return-object v1
.end method

.method private static inflateToStream(Ljava/util/zip/Inflater;)Ljava/io/ByteArrayOutputStream;
    .locals 4
    .param p0, "inflater"    # Ljava/util/zip/Inflater;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/util/zip/DataFormatException;
        }
    .end annotation

    .prologue
    .line 23
    new-instance v2, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v2}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 24
    .local v2, "out":Ljava/io/ByteArrayOutputStream;
    const/16 v3, 0x400

    new-array v0, v3, [B

    .line 25
    .local v0, "bytes":[B
    const/4 v1, 0x0

    .line 27
    .local v1, "len":I
    :cond_0
    invoke-virtual {p0, v0}, Ljava/util/zip/Inflater;->inflate([B)I

    move-result v1

    .line 28
    if-eqz v1, :cond_1

    .line 29
    const/4 v3, 0x0

    invoke-virtual {v2, v0, v3, v1}, Ljava/io/ByteArrayOutputStream;->write([BII)V

    .line 31
    :cond_1
    if-nez v1, :cond_0

    .line 32
    return-object v2
.end method

.method public static inflateToStream([B[B)Ljava/io/InputStream;
    .locals 3
    .param p0, "compressed"    # [B
    .param p1, "dict"    # [B

    .prologue
    .line 135
    new-instance v0, Lcom/google/android/gm/provider/ZipUtils$1;

    invoke-direct {v0, p1}, Lcom/google/android/gm/provider/ZipUtils$1;-><init>([B)V

    .line 144
    .local v0, "inflater":Ljava/util/zip/Inflater;
    new-instance v1, Lcom/google/android/gm/provider/ZipUtils$2;

    new-instance v2, Ljava/io/ByteArrayInputStream;

    invoke-direct {v2, p0}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    invoke-direct {v1, v2, v0}, Lcom/google/android/gm/provider/ZipUtils$2;-><init>(Ljava/io/InputStream;Ljava/util/zip/Inflater;)V

    return-object v1
.end method

.method public static inflateToUTF8(Ljava/util/zip/Inflater;)Ljava/lang/String;
    .locals 2
    .param p0, "inflater"    # Ljava/util/zip/Inflater;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/util/zip/DataFormatException;,
            Ljava/io/UnsupportedEncodingException;
        }
    .end annotation

    .prologue
    .line 52
    invoke-static {p0}, Lcom/google/android/gm/provider/ZipUtils;->inflateToStream(Ljava/util/zip/Inflater;)Ljava/io/ByteArrayOutputStream;

    move-result-object v0

    .line 53
    .local v0, "out":Ljava/io/ByteArrayOutputStream;
    const-string v1, "UTF-8"

    invoke-virtual {v0, v1}, Ljava/io/ByteArrayOutputStream;->toString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public static inflateToUTF8([BII)Ljava/lang/String;
    .locals 2
    .param p0, "data"    # [B
    .param p1, "offset"    # I
    .param p2, "length"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/util/zip/DataFormatException;,
            Ljava/io/UnsupportedEncodingException;
        }
    .end annotation

    .prologue
    .line 76
    new-instance v0, Ljava/util/zip/Inflater;

    invoke-direct {v0}, Ljava/util/zip/Inflater;-><init>()V

    .line 78
    .local v0, "inflater":Ljava/util/zip/Inflater;
    :try_start_0
    invoke-virtual {v0, p0, p1, p2}, Ljava/util/zip/Inflater;->setInput([BII)V

    .line 79
    invoke-static {v0}, Lcom/google/android/gm/provider/ZipUtils;->inflateToUTF8(Ljava/util/zip/Inflater;)Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 81
    invoke-virtual {v0}, Ljava/util/zip/Inflater;->end()V

    return-object v1

    :catchall_0
    move-exception v1

    invoke-virtual {v0}, Ljava/util/zip/Inflater;->end()V

    throw v1
.end method
