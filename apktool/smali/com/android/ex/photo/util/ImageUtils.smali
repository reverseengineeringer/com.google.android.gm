.class public Lcom/android/ex/photo/util/ImageUtils;
.super Ljava/lang/Object;
.source "ImageUtils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/ex/photo/util/ImageUtils$ImageSize;
    }
.end annotation


# static fields
.field public static final sUseImageSize:Lcom/android/ex/photo/util/ImageUtils$ImageSize;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    .line 60
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xb

    if-lt v0, v1, :cond_0

    .line 61
    sget-object v0, Lcom/android/ex/photo/util/ImageUtils$ImageSize;->NORMAL:Lcom/android/ex/photo/util/ImageUtils$ImageSize;

    sput-object v0, Lcom/android/ex/photo/util/ImageUtils;->sUseImageSize:Lcom/android/ex/photo/util/ImageUtils$ImageSize;

    .line 74
    :goto_0
    return-void

    .line 63
    :cond_0
    sget v0, Lcom/android/ex/photo/PhotoViewActivity;->sMemoryClass:I

    int-to-long v0, v0

    const-wide/16 v2, 0x20

    cmp-long v0, v0, v2

    if-ltz v0, :cond_1

    .line 65
    sget-object v0, Lcom/android/ex/photo/util/ImageUtils$ImageSize;->NORMAL:Lcom/android/ex/photo/util/ImageUtils$ImageSize;

    sput-object v0, Lcom/android/ex/photo/util/ImageUtils;->sUseImageSize:Lcom/android/ex/photo/util/ImageUtils$ImageSize;

    goto :goto_0

    .line 66
    :cond_1
    sget v0, Lcom/android/ex/photo/PhotoViewActivity;->sMemoryClass:I

    int-to-long v0, v0

    const-wide/16 v2, 0x18

    cmp-long v0, v0, v2

    if-ltz v0, :cond_2

    .line 68
    sget-object v0, Lcom/android/ex/photo/util/ImageUtils$ImageSize;->SMALL:Lcom/android/ex/photo/util/ImageUtils$ImageSize;

    sput-object v0, Lcom/android/ex/photo/util/ImageUtils;->sUseImageSize:Lcom/android/ex/photo/util/ImageUtils$ImageSize;

    goto :goto_0

    .line 71
    :cond_2
    sget-object v0, Lcom/android/ex/photo/util/ImageUtils$ImageSize;->EXTRA_SMALL:Lcom/android/ex/photo/util/ImageUtils$ImageSize;

    sput-object v0, Lcom/android/ex/photo/util/ImageUtils;->sUseImageSize:Lcom/android/ex/photo/util/ImageUtils$ImageSize;

    goto :goto_0
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 42
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 51
    return-void
.end method

.method public static createLocalBitmap(Landroid/content/ContentResolver;Landroid/net/Uri;I)Landroid/graphics/Bitmap;
    .locals 6
    .param p0, "resolver"    # Landroid/content/ContentResolver;
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "maxSize"    # I

    .prologue
    const/4 v1, 0x0

    .line 93
    const/4 v2, 0x0

    .line 95
    .local v2, "inputStream":Ljava/io/InputStream;
    :try_start_0
    new-instance v3, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v3}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 96
    .local v3, "opts":Landroid/graphics/BitmapFactory$Options;
    invoke-static {p0, p1}, Lcom/android/ex/photo/util/ImageUtils;->getImageBounds(Landroid/content/ContentResolver;Landroid/net/Uri;)Landroid/graphics/Point;

    move-result-object v0

    .line 98
    .local v0, "bounds":Landroid/graphics/Point;
    invoke-virtual {p0, p1}, Landroid/content/ContentResolver;->openInputStream(Landroid/net/Uri;)Ljava/io/InputStream;

    move-result-object v2

    .line 99
    iget v4, v0, Landroid/graphics/Point;->x:I

    div-int/2addr v4, p2

    iget v5, v0, Landroid/graphics/Point;->y:I

    div-int/2addr v5, p2

    invoke-static {v4, v5}, Ljava/lang/Math;->max(II)I

    move-result v4

    iput v4, v3, Landroid/graphics/BitmapFactory$Options;->inSampleSize:I

    .line 101
    const/4 v4, 0x0

    invoke-static {v2, v4, v3}, Lcom/android/ex/photo/util/ImageUtils;->decodeStream(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_4
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 116
    .local v1, "decodedBitmap":Landroid/graphics/Bitmap;
    if-eqz v2, :cond_0

    .line 117
    :try_start_1
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_6

    .line 122
    .end local v0    # "bounds":Landroid/graphics/Point;
    .end local v1    # "decodedBitmap":Landroid/graphics/Bitmap;
    .end local v3    # "opts":Landroid/graphics/BitmapFactory$Options;
    :cond_0
    :goto_0
    return-object v1

    .line 108
    :catch_0
    move-exception v4

    .line 116
    if-eqz v2, :cond_0

    .line 117
    :try_start_2
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_0

    .line 119
    :catch_1
    move-exception v4

    goto :goto_0

    .line 110
    :catch_2
    move-exception v4

    .line 116
    if-eqz v2, :cond_0

    .line 117
    :try_start_3
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_3

    goto :goto_0

    .line 119
    :catch_3
    move-exception v4

    goto :goto_0

    .line 112
    :catch_4
    move-exception v4

    .line 116
    if-eqz v2, :cond_0

    .line 117
    :try_start_4
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_5

    goto :goto_0

    .line 119
    :catch_5
    move-exception v4

    goto :goto_0

    .line 115
    :catchall_0
    move-exception v4

    .line 116
    if-eqz v2, :cond_1

    .line 117
    :try_start_5
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_7

    .line 120
    :cond_1
    :goto_1
    throw v4

    .line 119
    .restart local v0    # "bounds":Landroid/graphics/Point;
    .restart local v1    # "decodedBitmap":Landroid/graphics/Bitmap;
    .restart local v3    # "opts":Landroid/graphics/BitmapFactory$Options;
    :catch_6
    move-exception v4

    goto :goto_0

    .end local v0    # "bounds":Landroid/graphics/Point;
    .end local v1    # "decodedBitmap":Landroid/graphics/Bitmap;
    .end local v3    # "opts":Landroid/graphics/BitmapFactory$Options;
    :catch_7
    move-exception v5

    goto :goto_1
.end method

.method public static decodeStream(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    .locals 16
    .param p0, "is"    # Ljava/io/InputStream;
    .param p1, "outPadding"    # Landroid/graphics/Rect;
    .param p2, "opts"    # Landroid/graphics/BitmapFactory$Options;

    .prologue
    .line 143
    const/4 v14, 0x0

    .line 145
    .local v14, "out":Ljava/io/ByteArrayOutputStream;
    :try_start_0
    new-instance v15, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v15}, Ljava/io/ByteArrayOutputStream;-><init>()V
    :try_end_0
    .catch Ljava/lang/OutOfMemoryError; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_2
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 146
    .end local v14    # "out":Ljava/io/ByteArrayOutputStream;
    .local v15, "out":Ljava/io/ByteArrayOutputStream;
    const/16 v2, 0x1000

    :try_start_1
    new-array v9, v2, [B

    .line 147
    .local v9, "buffer":[B
    move-object/from16 v0, p0

    invoke-virtual {v0, v9}, Ljava/io/InputStream;->read([B)I

    move-result v11

    .line 148
    .local v11, "n":I
    :goto_0
    if-ltz v11, :cond_0

    .line 149
    const/4 v2, 0x0

    invoke-virtual {v15, v9, v2, v11}, Ljava/io/ByteArrayOutputStream;->write([BII)V

    .line 150
    move-object/from16 v0, p0

    invoke-virtual {v0, v9}, Ljava/io/InputStream;->read([B)I

    move-result v11

    goto :goto_0

    .line 152
    :cond_0
    invoke-virtual {v15}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v8

    .line 155
    .local v8, "bitmapBytes":[B
    invoke-static {v8}, Lcom/android/ex/photo/util/Exif;->getOrientation([B)I

    move-result v13

    .line 156
    .local v13, "orientation":I
    const/4 v2, 0x0

    array-length v3, v8

    move-object/from16 v0, p2

    invoke-static {v8, v2, v3, v0}, Landroid/graphics/BitmapFactory;->decodeByteArray([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 159
    .local v1, "originalBitmap":Landroid/graphics/Bitmap;
    if-eqz v1, :cond_3

    if-eqz v13, :cond_3

    .line 160
    new-instance v6, Landroid/graphics/Matrix;

    invoke-direct {v6}, Landroid/graphics/Matrix;-><init>()V

    .line 161
    .local v6, "matrix":Landroid/graphics/Matrix;
    int-to-float v2, v13

    invoke-virtual {v6, v2}, Landroid/graphics/Matrix;->postRotate(F)Z

    .line 162
    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v4

    invoke-virtual {v1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v5

    const/4 v7, 0x1

    invoke-static/range {v1 .. v7}, Landroid/graphics/Bitmap;->createBitmap(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    :try_end_1
    .catch Ljava/lang/OutOfMemoryError; {:try_start_1 .. :try_end_1} :catch_8
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_7
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v1

    .line 173
    .end local v1    # "originalBitmap":Landroid/graphics/Bitmap;
    if-eqz v15, :cond_1

    .line 175
    :try_start_2
    invoke-virtual {v15}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_4

    :cond_1
    :goto_1
    move-object v14, v15

    .line 178
    .end local v6    # "matrix":Landroid/graphics/Matrix;
    .end local v8    # "bitmapBytes":[B
    .end local v9    # "buffer":[B
    .end local v11    # "n":I
    .end local v13    # "orientation":I
    .end local v15    # "out":Ljava/io/ByteArrayOutputStream;
    .restart local v14    # "out":Ljava/io/ByteArrayOutputStream;
    :cond_2
    :goto_2
    return-object v1

    .line 173
    .end local v14    # "out":Ljava/io/ByteArrayOutputStream;
    .restart local v1    # "originalBitmap":Landroid/graphics/Bitmap;
    .restart local v8    # "bitmapBytes":[B
    .restart local v9    # "buffer":[B
    .restart local v11    # "n":I
    .restart local v13    # "orientation":I
    .restart local v15    # "out":Ljava/io/ByteArrayOutputStream;
    :cond_3
    if-eqz v15, :cond_4

    .line 175
    :try_start_3
    invoke-virtual {v15}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_5

    :cond_4
    :goto_3
    move-object v14, v15

    .line 178
    .end local v15    # "out":Ljava/io/ByteArrayOutputStream;
    .restart local v14    # "out":Ljava/io/ByteArrayOutputStream;
    goto :goto_2

    .line 166
    .end local v1    # "originalBitmap":Landroid/graphics/Bitmap;
    .end local v8    # "bitmapBytes":[B
    .end local v9    # "buffer":[B
    .end local v11    # "n":I
    .end local v13    # "orientation":I
    :catch_0
    move-exception v12

    .line 167
    .local v12, "oome":Ljava/lang/OutOfMemoryError;
    :goto_4
    :try_start_4
    const-string v2, "ImageUtils"

    const-string v3, "ImageUtils#decodeStream(InputStream, Rect, Options) threw an OOME"

    invoke-static {v2, v3, v12}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 168
    const/4 v1, 0x0

    .line 173
    if-eqz v14, :cond_2

    .line 175
    :try_start_5
    invoke-virtual {v14}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_1

    goto :goto_2

    .line 176
    :catch_1
    move-exception v2

    goto :goto_2

    .line 169
    .end local v12    # "oome":Ljava/lang/OutOfMemoryError;
    :catch_2
    move-exception v10

    .line 170
    .local v10, "ioe":Ljava/io/IOException;
    :goto_5
    :try_start_6
    const-string v2, "ImageUtils"

    const-string v3, "ImageUtils#decodeStream(InputStream, Rect, Options) threw an IOE"

    invoke-static {v2, v3, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    .line 171
    const/4 v1, 0x0

    .line 173
    if-eqz v14, :cond_2

    .line 175
    :try_start_7
    invoke-virtual {v14}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_3

    goto :goto_2

    .line 176
    :catch_3
    move-exception v2

    goto :goto_2

    .line 173
    .end local v10    # "ioe":Ljava/io/IOException;
    :catchall_0
    move-exception v2

    :goto_6
    if-eqz v14, :cond_5

    .line 175
    :try_start_8
    invoke-virtual {v14}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_8
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_6

    .line 178
    :cond_5
    :goto_7
    throw v2

    .line 176
    .end local v14    # "out":Ljava/io/ByteArrayOutputStream;
    .restart local v6    # "matrix":Landroid/graphics/Matrix;
    .restart local v8    # "bitmapBytes":[B
    .restart local v9    # "buffer":[B
    .restart local v11    # "n":I
    .restart local v13    # "orientation":I
    .restart local v15    # "out":Ljava/io/ByteArrayOutputStream;
    :catch_4
    move-exception v2

    goto :goto_1

    .end local v6    # "matrix":Landroid/graphics/Matrix;
    .restart local v1    # "originalBitmap":Landroid/graphics/Bitmap;
    :catch_5
    move-exception v2

    goto :goto_3

    .end local v1    # "originalBitmap":Landroid/graphics/Bitmap;
    .end local v8    # "bitmapBytes":[B
    .end local v9    # "buffer":[B
    .end local v11    # "n":I
    .end local v13    # "orientation":I
    .end local v15    # "out":Ljava/io/ByteArrayOutputStream;
    .restart local v14    # "out":Ljava/io/ByteArrayOutputStream;
    :catch_6
    move-exception v3

    goto :goto_7

    .line 173
    .end local v14    # "out":Ljava/io/ByteArrayOutputStream;
    .restart local v15    # "out":Ljava/io/ByteArrayOutputStream;
    :catchall_1
    move-exception v2

    move-object v14, v15

    .end local v15    # "out":Ljava/io/ByteArrayOutputStream;
    .restart local v14    # "out":Ljava/io/ByteArrayOutputStream;
    goto :goto_6

    .line 169
    .end local v14    # "out":Ljava/io/ByteArrayOutputStream;
    .restart local v15    # "out":Ljava/io/ByteArrayOutputStream;
    :catch_7
    move-exception v10

    move-object v14, v15

    .end local v15    # "out":Ljava/io/ByteArrayOutputStream;
    .restart local v14    # "out":Ljava/io/ByteArrayOutputStream;
    goto :goto_5

    .line 166
    .end local v14    # "out":Ljava/io/ByteArrayOutputStream;
    .restart local v15    # "out":Ljava/io/ByteArrayOutputStream;
    :catch_8
    move-exception v12

    move-object v14, v15

    .end local v15    # "out":Ljava/io/ByteArrayOutputStream;
    .restart local v14    # "out":Ljava/io/ByteArrayOutputStream;
    goto :goto_4
.end method

.method private static getImageBounds(Landroid/content/ContentResolver;Landroid/net/Uri;)Landroid/graphics/Point;
    .locals 5
    .param p0, "resolver"    # Landroid/content/ContentResolver;
    .param p1, "uri"    # Landroid/net/Uri;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 193
    new-instance v1, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v1}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 194
    .local v1, "opts":Landroid/graphics/BitmapFactory$Options;
    const/4 v0, 0x0

    .line 197
    .local v0, "inputStream":Ljava/io/InputStream;
    const/4 v2, 0x1

    :try_start_0
    iput-boolean v2, v1, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 198
    invoke-virtual {p0, p1}, Landroid/content/ContentResolver;->openInputStream(Landroid/net/Uri;)Ljava/io/InputStream;

    move-result-object v0

    .line 199
    const/4 v2, 0x0

    invoke-static {v0, v2, v1}, Lcom/android/ex/photo/util/ImageUtils;->decodeStream(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    .line 201
    new-instance v2, Landroid/graphics/Point;

    iget v3, v1, Landroid/graphics/BitmapFactory$Options;->outWidth:I

    iget v4, v1, Landroid/graphics/BitmapFactory$Options;->outHeight:I

    invoke-direct {v2, v3, v4}, Landroid/graphics/Point;-><init>(II)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 204
    if-eqz v0, :cond_0

    .line 205
    :try_start_1
    invoke-virtual {v0}, Ljava/io/InputStream;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    .line 208
    :cond_0
    :goto_0
    return-object v2

    .line 203
    :catchall_0
    move-exception v2

    .line 204
    if-eqz v0, :cond_1

    .line 205
    :try_start_2
    invoke-virtual {v0}, Ljava/io/InputStream;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1

    .line 208
    :cond_1
    :goto_1
    throw v2

    .line 207
    :catch_0
    move-exception v3

    goto :goto_0

    :catch_1
    move-exception v3

    goto :goto_1
.end method

.method public static isImageMimeType(Ljava/lang/String;)Z
    .locals 1
    .param p0, "mimeType"    # Ljava/lang/String;

    .prologue
    .line 80
    if-eqz p0, :cond_0

    const-string v0, "image/"

    invoke-virtual {p0, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
