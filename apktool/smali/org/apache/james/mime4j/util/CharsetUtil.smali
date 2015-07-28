.class public Lorg/apache/james/mime4j/util/CharsetUtil;
.super Ljava/lang/Object;
.source "CharsetUtil.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/apache/james/mime4j/util/CharsetUtil$1;,
        Lorg/apache/james/mime4j/util/CharsetUtil$Charset;
    }
.end annotation


# static fields
.field public static final ISO_8859_1:Ljava/nio/charset/Charset;

.field private static JAVA_CHARSETS:[Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

.field public static final US_ASCII:Ljava/nio/charset/Charset;

.field public static final UTF_8:Ljava/nio/charset/Charset;

.field private static charsetMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lorg/apache/james/mime4j/util/CharsetUtil$Charset;",
            ">;"
        }
    .end annotation
.end field

.field private static decodingSupported:Ljava/util/TreeSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/TreeSet",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static encodingSupported:Ljava/util/TreeSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/TreeSet",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static log:Lorg/apache/james/mime4j/Log;


# direct methods
.method static constructor <clinit>()V
    .locals 13

    .prologue
    const/4 v12, 0x3

    const/4 v11, 0x2

    const/4 v10, 0x1

    const/4 v1, 0x0

    const/4 v9, 0x0

    .line 794
    const-class v0, Lorg/apache/james/mime4j/util/CharsetUtil;

    invoke-static {v0}, Lorg/apache/james/mime4j/LogFactory;->getLog(Ljava/lang/Class;)Lorg/apache/james/mime4j/Log;

    move-result-object v0

    sput-object v0, Lorg/apache/james/mime4j/util/CharsetUtil;->log:Lorg/apache/james/mime4j/Log;

    .line 812
    const/16 v0, 0x93

    new-array v0, v0, [Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    new-instance v2, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v3, "ISO8859_1"

    const-string v4, "ISO-8859-1"

    const/16 v5, 0xd

    new-array v5, v5, [Ljava/lang/String;

    const-string v6, "ISO_8859-1:1987"

    aput-object v6, v5, v1

    const-string v6, "iso-ir-100"

    aput-object v6, v5, v10

    const-string v6, "ISO_8859-1"

    aput-object v6, v5, v11

    const-string v6, "latin1"

    aput-object v6, v5, v12

    const/4 v6, 0x4

    const-string v7, "l1"

    aput-object v7, v5, v6

    const/4 v6, 0x5

    const-string v7, "IBM819"

    aput-object v7, v5, v6

    const/4 v6, 0x6

    const-string v7, "CP819"

    aput-object v7, v5, v6

    const/4 v6, 0x7

    const-string v7, "csISOLatin1"

    aput-object v7, v5, v6

    const/16 v6, 0x8

    const-string v7, "8859_1"

    aput-object v7, v5, v6

    const/16 v6, 0x9

    const-string v7, "819"

    aput-object v7, v5, v6

    const/16 v6, 0xa

    const-string v7, "IBM-819"

    aput-object v7, v5, v6

    const/16 v6, 0xb

    const-string v7, "ISO8859-1"

    aput-object v7, v5, v6

    const/16 v6, 0xc

    const-string v7, "ISO_8859_1"

    aput-object v7, v5, v6

    invoke-direct {v2, v3, v4, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v2, v0, v1

    new-instance v2, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v3, "ISO8859_2"

    const-string v4, "ISO-8859-2"

    const/16 v5, 0x8

    new-array v5, v5, [Ljava/lang/String;

    const-string v6, "ISO_8859-2:1987"

    aput-object v6, v5, v1

    const-string v6, "iso-ir-101"

    aput-object v6, v5, v10

    const-string v6, "ISO_8859-2"

    aput-object v6, v5, v11

    const-string v6, "latin2"

    aput-object v6, v5, v12

    const/4 v6, 0x4

    const-string v7, "l2"

    aput-object v7, v5, v6

    const/4 v6, 0x5

    const-string v7, "csISOLatin2"

    aput-object v7, v5, v6

    const/4 v6, 0x6

    const-string v7, "8859_2"

    aput-object v7, v5, v6

    const/4 v6, 0x7

    const-string v7, "iso8859_2"

    aput-object v7, v5, v6

    invoke-direct {v2, v3, v4, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v2, v0, v10

    new-instance v2, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v3, "ISO8859_3"

    const-string v4, "ISO-8859-3"

    const/4 v5, 0x7

    new-array v5, v5, [Ljava/lang/String;

    const-string v6, "ISO_8859-3:1988"

    aput-object v6, v5, v1

    const-string v6, "iso-ir-109"

    aput-object v6, v5, v10

    const-string v6, "ISO_8859-3"

    aput-object v6, v5, v11

    const-string v6, "latin3"

    aput-object v6, v5, v12

    const/4 v6, 0x4

    const-string v7, "l3"

    aput-object v7, v5, v6

    const/4 v6, 0x5

    const-string v7, "csISOLatin3"

    aput-object v7, v5, v6

    const/4 v6, 0x6

    const-string v7, "8859_3"

    aput-object v7, v5, v6

    invoke-direct {v2, v3, v4, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v2, v0, v11

    new-instance v2, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v3, "ISO8859_4"

    const-string v4, "ISO-8859-4"

    const/4 v5, 0x7

    new-array v5, v5, [Ljava/lang/String;

    const-string v6, "ISO_8859-4:1988"

    aput-object v6, v5, v1

    const-string v6, "iso-ir-110"

    aput-object v6, v5, v10

    const-string v6, "ISO_8859-4"

    aput-object v6, v5, v11

    const-string v6, "latin4"

    aput-object v6, v5, v12

    const/4 v6, 0x4

    const-string v7, "l4"

    aput-object v7, v5, v6

    const/4 v6, 0x5

    const-string v7, "csISOLatin4"

    aput-object v7, v5, v6

    const/4 v6, 0x6

    const-string v7, "8859_4"

    aput-object v7, v5, v6

    invoke-direct {v2, v3, v4, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v2, v0, v12

    const/4 v2, 0x4

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "ISO8859_5"

    const-string v5, "ISO-8859-5"

    const/4 v6, 0x6

    new-array v6, v6, [Ljava/lang/String;

    const-string v7, "ISO_8859-5:1988"

    aput-object v7, v6, v1

    const-string v7, "iso-ir-144"

    aput-object v7, v6, v10

    const-string v7, "ISO_8859-5"

    aput-object v7, v6, v11

    const-string v7, "cyrillic"

    aput-object v7, v6, v12

    const/4 v7, 0x4

    const-string v8, "csISOLatinCyrillic"

    aput-object v8, v6, v7

    const/4 v7, 0x5

    const-string v8, "8859_5"

    aput-object v8, v6, v7

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/4 v2, 0x5

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "ISO8859_6"

    const-string v5, "ISO-8859-6"

    const/16 v6, 0x8

    new-array v6, v6, [Ljava/lang/String;

    const-string v7, "ISO_8859-6:1987"

    aput-object v7, v6, v1

    const-string v7, "iso-ir-127"

    aput-object v7, v6, v10

    const-string v7, "ISO_8859-6"

    aput-object v7, v6, v11

    const-string v7, "ECMA-114"

    aput-object v7, v6, v12

    const/4 v7, 0x4

    const-string v8, "ASMO-708"

    aput-object v8, v6, v7

    const/4 v7, 0x5

    const-string v8, "arabic"

    aput-object v8, v6, v7

    const/4 v7, 0x6

    const-string v8, "csISOLatinArabic"

    aput-object v8, v6, v7

    const/4 v7, 0x7

    const-string v8, "8859_6"

    aput-object v8, v6, v7

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/4 v2, 0x6

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "ISO8859_7"

    const-string v5, "ISO-8859-7"

    const/16 v6, 0xa

    new-array v6, v6, [Ljava/lang/String;

    const-string v7, "ISO_8859-7:1987"

    aput-object v7, v6, v1

    const-string v7, "iso-ir-126"

    aput-object v7, v6, v10

    const-string v7, "ISO_8859-7"

    aput-object v7, v6, v11

    const-string v7, "ELOT_928"

    aput-object v7, v6, v12

    const/4 v7, 0x4

    const-string v8, "ECMA-118"

    aput-object v8, v6, v7

    const/4 v7, 0x5

    const-string v8, "greek"

    aput-object v8, v6, v7

    const/4 v7, 0x6

    const-string v8, "greek8"

    aput-object v8, v6, v7

    const/4 v7, 0x7

    const-string v8, "csISOLatinGreek"

    aput-object v8, v6, v7

    const/16 v7, 0x8

    const-string v8, "8859_7"

    aput-object v8, v6, v7

    const/16 v7, 0x9

    const-string v8, "sun_eu_greek"

    aput-object v8, v6, v7

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/4 v2, 0x7

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "ISO8859_8"

    const-string v5, "ISO-8859-8"

    const/4 v6, 0x6

    new-array v6, v6, [Ljava/lang/String;

    const-string v7, "ISO_8859-8:1988"

    aput-object v7, v6, v1

    const-string v7, "iso-ir-138"

    aput-object v7, v6, v10

    const-string v7, "ISO_8859-8"

    aput-object v7, v6, v11

    const-string v7, "hebrew"

    aput-object v7, v6, v12

    const/4 v7, 0x4

    const-string v8, "csISOLatinHebrew"

    aput-object v8, v6, v7

    const/4 v7, 0x5

    const-string v8, "8859_8"

    aput-object v8, v6, v7

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x8

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "ISO8859_9"

    const-string v5, "ISO-8859-9"

    const/4 v6, 0x7

    new-array v6, v6, [Ljava/lang/String;

    const-string v7, "ISO_8859-9:1989"

    aput-object v7, v6, v1

    const-string v7, "iso-ir-148"

    aput-object v7, v6, v10

    const-string v7, "ISO_8859-9"

    aput-object v7, v6, v11

    const-string v7, "latin5"

    aput-object v7, v6, v12

    const/4 v7, 0x4

    const-string v8, "l5"

    aput-object v8, v6, v7

    const/4 v7, 0x5

    const-string v8, "csISOLatin5"

    aput-object v8, v6, v7

    const/4 v7, 0x6

    const-string v8, "8859_9"

    aput-object v8, v6, v7

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x9

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "ISO8859_13"

    const-string v5, "ISO-8859-13"

    new-array v6, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0xa

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "ISO8859_15"

    const-string v5, "ISO-8859-15"

    const/16 v6, 0xe

    new-array v6, v6, [Ljava/lang/String;

    const-string v7, "ISO_8859-15"

    aput-object v7, v6, v1

    const-string v7, "Latin-9"

    aput-object v7, v6, v10

    const-string v7, "8859_15"

    aput-object v7, v6, v11

    const-string v7, "csISOlatin9"

    aput-object v7, v6, v12

    const/4 v7, 0x4

    const-string v8, "IBM923"

    aput-object v8, v6, v7

    const/4 v7, 0x5

    const-string v8, "cp923"

    aput-object v8, v6, v7

    const/4 v7, 0x6

    const-string v8, "923"

    aput-object v8, v6, v7

    const/4 v7, 0x7

    const-string v8, "L9"

    aput-object v8, v6, v7

    const/16 v7, 0x8

    const-string v8, "IBM-923"

    aput-object v8, v6, v7

    const/16 v7, 0x9

    const-string v8, "ISO8859-15"

    aput-object v8, v6, v7

    const/16 v7, 0xa

    const-string v8, "LATIN9"

    aput-object v8, v6, v7

    const/16 v7, 0xb

    const-string v8, "LATIN0"

    aput-object v8, v6, v7

    const/16 v7, 0xc

    const-string v8, "csISOlatin0"

    aput-object v8, v6, v7

    const/16 v7, 0xd

    const-string v8, "ISO8859_15_FDIS"

    aput-object v8, v6, v7

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0xb

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "KOI8_R"

    const-string v5, "KOI8-R"

    new-array v6, v11, [Ljava/lang/String;

    const-string v7, "csKOI8R"

    aput-object v7, v6, v1

    const-string v7, "koi8"

    aput-object v7, v6, v10

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0xc

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "ASCII"

    const-string v5, "US-ASCII"

    const/16 v6, 0xc

    new-array v6, v6, [Ljava/lang/String;

    const-string v7, "ANSI_X3.4-1968"

    aput-object v7, v6, v1

    const-string v7, "iso-ir-6"

    aput-object v7, v6, v10

    const-string v7, "ANSI_X3.4-1986"

    aput-object v7, v6, v11

    const-string v7, "ISO_646.irv:1991"

    aput-object v7, v6, v12

    const/4 v7, 0x4

    const-string v8, "ISO646-US"

    aput-object v8, v6, v7

    const/4 v7, 0x5

    const-string v8, "us"

    aput-object v8, v6, v7

    const/4 v7, 0x6

    const-string v8, "IBM367"

    aput-object v8, v6, v7

    const/4 v7, 0x7

    const-string v8, "cp367"

    aput-object v8, v6, v7

    const/16 v7, 0x8

    const-string v8, "csASCII"

    aput-object v8, v6, v7

    const/16 v7, 0x9

    const-string v8, "ascii7"

    aput-object v8, v6, v7

    const/16 v7, 0xa

    const-string v8, "646"

    aput-object v8, v6, v7

    const/16 v7, 0xb

    const-string v8, "iso_646.irv:1983"

    aput-object v8, v6, v7

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0xd

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "UTF8"

    const-string v5, "UTF-8"

    new-array v6, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0xe

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "UTF-16"

    const-string v5, "UTF-16"

    new-array v6, v10, [Ljava/lang/String;

    const-string v7, "UTF_16"

    aput-object v7, v6, v1

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0xf

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "UnicodeBigUnmarked"

    const-string v5, "UTF-16BE"

    new-array v6, v12, [Ljava/lang/String;

    const-string v7, "X-UTF-16BE"

    aput-object v7, v6, v1

    const-string v7, "UTF_16BE"

    aput-object v7, v6, v10

    const-string v7, "ISO-10646-UCS-2"

    aput-object v7, v6, v11

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x10

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "UnicodeLittleUnmarked"

    const-string v5, "UTF-16LE"

    new-array v6, v11, [Ljava/lang/String;

    const-string v7, "UTF_16LE"

    aput-object v7, v6, v1

    const-string v7, "X-UTF-16LE"

    aput-object v7, v6, v10

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x11

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Big5"

    const-string v5, "Big5"

    const/4 v6, 0x4

    new-array v6, v6, [Ljava/lang/String;

    const-string v7, "csBig5"

    aput-object v7, v6, v1

    const-string v7, "CN-Big5"

    aput-object v7, v6, v10

    const-string v7, "BIG-FIVE"

    aput-object v7, v6, v11

    const-string v7, "BIGFIVE"

    aput-object v7, v6, v12

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x12

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Big5_HKSCS"

    const-string v5, "Big5-HKSCS"

    new-array v6, v10, [Ljava/lang/String;

    const-string v7, "big5hkscs"

    aput-object v7, v6, v1

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x13

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "EUC_JP"

    const-string v5, "EUC-JP"

    const/4 v6, 0x6

    new-array v6, v6, [Ljava/lang/String;

    const-string v7, "csEUCPkdFmtJapanese"

    aput-object v7, v6, v1

    const-string v7, "Extended_UNIX_Code_Packed_Format_for_Japanese"

    aput-object v7, v6, v10

    const-string v7, "eucjis"

    aput-object v7, v6, v11

    const-string v7, "x-eucjp"

    aput-object v7, v6, v12

    const/4 v7, 0x4

    const-string v8, "eucjp"

    aput-object v8, v6, v7

    const/4 v7, 0x5

    const-string v8, "x-euc-jp"

    aput-object v8, v6, v7

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x14

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "EUC_KR"

    const-string v5, "EUC-KR"

    const/16 v6, 0x8

    new-array v6, v6, [Ljava/lang/String;

    const-string v7, "csEUCKR"

    aput-object v7, v6, v1

    const-string v7, "ksc5601"

    aput-object v7, v6, v10

    const-string v7, "5601"

    aput-object v7, v6, v11

    const-string v7, "ksc5601_1987"

    aput-object v7, v6, v12

    const/4 v7, 0x4

    const-string v8, "ksc_5601"

    aput-object v8, v6, v7

    const/4 v7, 0x5

    const-string v8, "ksc5601-1987"

    aput-object v8, v6, v7

    const/4 v7, 0x6

    const-string v8, "ks_c_5601-1987"

    aput-object v8, v6, v7

    const/4 v7, 0x7

    const-string v8, "euckr"

    aput-object v8, v6, v7

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x15

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "GB18030"

    const-string v5, "GB18030"

    new-array v6, v10, [Ljava/lang/String;

    const-string v7, "gb18030-2000"

    aput-object v7, v6, v1

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x16

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "EUC_CN"

    const-string v5, "GB2312"

    const/16 v6, 0x8

    new-array v6, v6, [Ljava/lang/String;

    const-string v7, "x-EUC-CN"

    aput-object v7, v6, v1

    const-string v7, "csGB2312"

    aput-object v7, v6, v10

    const-string v7, "euccn"

    aput-object v7, v6, v11

    const-string v7, "euc-cn"

    aput-object v7, v6, v12

    const/4 v7, 0x4

    const-string v8, "gb2312-80"

    aput-object v8, v6, v7

    const/4 v7, 0x5

    const-string v8, "gb2312-1980"

    aput-object v8, v6, v7

    const/4 v7, 0x6

    const-string v8, "CN-GB"

    aput-object v8, v6, v7

    const/4 v7, 0x7

    const-string v8, "CN-GB-ISOIR165"

    aput-object v8, v6, v7

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x17

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "GBK"

    const-string v5, "windows-936"

    const/4 v6, 0x4

    new-array v6, v6, [Ljava/lang/String;

    const-string v7, "CP936"

    aput-object v7, v6, v1

    const-string v7, "MS936"

    aput-object v7, v6, v10

    const-string v7, "ms_936"

    aput-object v7, v6, v11

    const-string v7, "x-mswin-936"

    aput-object v7, v6, v12

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x18

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp037"

    const-string v5, "IBM037"

    const/4 v6, 0x5

    new-array v6, v6, [Ljava/lang/String;

    const-string v7, "ebcdic-cp-us"

    aput-object v7, v6, v1

    const-string v7, "ebcdic-cp-ca"

    aput-object v7, v6, v10

    const-string v7, "ebcdic-cp-wt"

    aput-object v7, v6, v11

    const-string v7, "ebcdic-cp-nl"

    aput-object v7, v6, v12

    const/4 v7, 0x4

    const-string v8, "csIBM037"

    aput-object v8, v6, v7

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x19

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp273"

    const-string v5, "IBM273"

    new-array v6, v10, [Ljava/lang/String;

    const-string v7, "csIBM273"

    aput-object v7, v6, v1

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x1a

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp277"

    const-string v5, "IBM277"

    new-array v6, v12, [Ljava/lang/String;

    const-string v7, "EBCDIC-CP-DK"

    aput-object v7, v6, v1

    const-string v7, "EBCDIC-CP-NO"

    aput-object v7, v6, v10

    const-string v7, "csIBM277"

    aput-object v7, v6, v11

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x1b

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp278"

    const-string v5, "IBM278"

    const/4 v6, 0x4

    new-array v6, v6, [Ljava/lang/String;

    const-string v7, "CP278"

    aput-object v7, v6, v1

    const-string v7, "ebcdic-cp-fi"

    aput-object v7, v6, v10

    const-string v7, "ebcdic-cp-se"

    aput-object v7, v6, v11

    const-string v7, "csIBM278"

    aput-object v7, v6, v12

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x1c

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp280"

    const-string v5, "IBM280"

    new-array v6, v11, [Ljava/lang/String;

    const-string v7, "ebcdic-cp-it"

    aput-object v7, v6, v1

    const-string v7, "csIBM280"

    aput-object v7, v6, v10

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x1d

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp284"

    const-string v5, "IBM284"

    new-array v6, v11, [Ljava/lang/String;

    const-string v7, "ebcdic-cp-es"

    aput-object v7, v6, v1

    const-string v7, "csIBM284"

    aput-object v7, v6, v10

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x1e

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp285"

    const-string v5, "IBM285"

    new-array v6, v11, [Ljava/lang/String;

    const-string v7, "ebcdic-cp-gb"

    aput-object v7, v6, v1

    const-string v7, "csIBM285"

    aput-object v7, v6, v10

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x1f

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp297"

    const-string v5, "IBM297"

    new-array v6, v11, [Ljava/lang/String;

    const-string v7, "ebcdic-cp-fr"

    aput-object v7, v6, v1

    const-string v7, "csIBM297"

    aput-object v7, v6, v10

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x20

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp420"

    const-string v5, "IBM420"

    new-array v6, v11, [Ljava/lang/String;

    const-string v7, "ebcdic-cp-ar1"

    aput-object v7, v6, v1

    const-string v7, "csIBM420"

    aput-object v7, v6, v10

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x21

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp424"

    const-string v5, "IBM424"

    new-array v6, v11, [Ljava/lang/String;

    const-string v7, "ebcdic-cp-he"

    aput-object v7, v6, v1

    const-string v7, "csIBM424"

    aput-object v7, v6, v10

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x22

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp437"

    const-string v5, "IBM437"

    new-array v6, v11, [Ljava/lang/String;

    const-string v7, "437"

    aput-object v7, v6, v1

    const-string v7, "csPC8CodePage437"

    aput-object v7, v6, v10

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x23

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp500"

    const-string v5, "IBM500"

    new-array v6, v12, [Ljava/lang/String;

    const-string v7, "ebcdic-cp-be"

    aput-object v7, v6, v1

    const-string v7, "ebcdic-cp-ch"

    aput-object v7, v6, v10

    const-string v7, "csIBM500"

    aput-object v7, v6, v11

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x24

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp775"

    const-string v5, "IBM775"

    new-array v6, v10, [Ljava/lang/String;

    const-string v7, "csPC775Baltic"

    aput-object v7, v6, v1

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x25

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp838"

    const-string v5, "IBM-Thai"

    new-array v6, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x26

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp850"

    const-string v5, "IBM850"

    new-array v6, v11, [Ljava/lang/String;

    const-string v7, "850"

    aput-object v7, v6, v1

    const-string v7, "csPC850Multilingual"

    aput-object v7, v6, v10

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x27

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp852"

    const-string v5, "IBM852"

    new-array v6, v11, [Ljava/lang/String;

    const-string v7, "852"

    aput-object v7, v6, v1

    const-string v7, "csPCp852"

    aput-object v7, v6, v10

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x28

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp855"

    const-string v5, "IBM855"

    new-array v6, v11, [Ljava/lang/String;

    const-string v7, "855"

    aput-object v7, v6, v1

    const-string v7, "csIBM855"

    aput-object v7, v6, v10

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x29

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp857"

    const-string v5, "IBM857"

    new-array v6, v11, [Ljava/lang/String;

    const-string v7, "857"

    aput-object v7, v6, v1

    const-string v7, "csIBM857"

    aput-object v7, v6, v10

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x2a

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp858"

    const-string v5, "IBM00858"

    new-array v6, v12, [Ljava/lang/String;

    const-string v7, "CCSID00858"

    aput-object v7, v6, v1

    const-string v7, "CP00858"

    aput-object v7, v6, v10

    const-string v7, "PC-Multilingual-850+euro"

    aput-object v7, v6, v11

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x2b

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp860"

    const-string v5, "IBM860"

    new-array v6, v11, [Ljava/lang/String;

    const-string v7, "860"

    aput-object v7, v6, v1

    const-string v7, "csIBM860"

    aput-object v7, v6, v10

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x2c

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp861"

    const-string v5, "IBM861"

    new-array v6, v12, [Ljava/lang/String;

    const-string v7, "861"

    aput-object v7, v6, v1

    const-string v7, "cp-is"

    aput-object v7, v6, v10

    const-string v7, "csIBM861"

    aput-object v7, v6, v11

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x2d

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp862"

    const-string v5, "IBM862"

    new-array v6, v11, [Ljava/lang/String;

    const-string v7, "862"

    aput-object v7, v6, v1

    const-string v7, "csPC862LatinHebrew"

    aput-object v7, v6, v10

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x2e

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp863"

    const-string v5, "IBM863"

    new-array v6, v11, [Ljava/lang/String;

    const-string v7, "863"

    aput-object v7, v6, v1

    const-string v7, "csIBM863"

    aput-object v7, v6, v10

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x2f

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp864"

    const-string v5, "IBM864"

    new-array v6, v11, [Ljava/lang/String;

    const-string v7, "cp864"

    aput-object v7, v6, v1

    const-string v7, "csIBM864"

    aput-object v7, v6, v10

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x30

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp865"

    const-string v5, "IBM865"

    new-array v6, v11, [Ljava/lang/String;

    const-string v7, "865"

    aput-object v7, v6, v1

    const-string v7, "csIBM865"

    aput-object v7, v6, v10

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x31

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp866"

    const-string v5, "IBM866"

    new-array v6, v11, [Ljava/lang/String;

    const-string v7, "866"

    aput-object v7, v6, v1

    const-string v7, "csIBM866"

    aput-object v7, v6, v10

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x32

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp868"

    const-string v5, "IBM868"

    new-array v6, v11, [Ljava/lang/String;

    const-string v7, "cp-ar"

    aput-object v7, v6, v1

    const-string v7, "csIBM868"

    aput-object v7, v6, v10

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x33

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp869"

    const-string v5, "IBM869"

    new-array v6, v11, [Ljava/lang/String;

    const-string v7, "cp-gr"

    aput-object v7, v6, v1

    const-string v7, "csIBM869"

    aput-object v7, v6, v10

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x34

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp870"

    const-string v5, "IBM870"

    new-array v6, v12, [Ljava/lang/String;

    const-string v7, "ebcdic-cp-roece"

    aput-object v7, v6, v1

    const-string v7, "ebcdic-cp-yu"

    aput-object v7, v6, v10

    const-string v7, "csIBM870"

    aput-object v7, v6, v11

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x35

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp871"

    const-string v5, "IBM871"

    new-array v6, v11, [Ljava/lang/String;

    const-string v7, "ebcdic-cp-is"

    aput-object v7, v6, v1

    const-string v7, "csIBM871"

    aput-object v7, v6, v10

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x36

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp918"

    const-string v5, "IBM918"

    new-array v6, v11, [Ljava/lang/String;

    const-string v7, "ebcdic-cp-ar2"

    aput-object v7, v6, v1

    const-string v7, "csIBM918"

    aput-object v7, v6, v10

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x37

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp1026"

    const-string v5, "IBM1026"

    new-array v6, v10, [Ljava/lang/String;

    const-string v7, "csIBM1026"

    aput-object v7, v6, v1

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x38

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp1047"

    const-string v5, "IBM1047"

    new-array v6, v10, [Ljava/lang/String;

    const-string v7, "IBM-1047"

    aput-object v7, v6, v1

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x39

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp1140"

    const-string v5, "IBM01140"

    new-array v6, v12, [Ljava/lang/String;

    const-string v7, "CCSID01140"

    aput-object v7, v6, v1

    const-string v7, "CP01140"

    aput-object v7, v6, v10

    const-string v7, "ebcdic-us-37+euro"

    aput-object v7, v6, v11

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x3a

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp1141"

    const-string v5, "IBM01141"

    new-array v6, v12, [Ljava/lang/String;

    const-string v7, "CCSID01141"

    aput-object v7, v6, v1

    const-string v7, "CP01141"

    aput-object v7, v6, v10

    const-string v7, "ebcdic-de-273+euro"

    aput-object v7, v6, v11

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x3b

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp1142"

    const-string v5, "IBM01142"

    const/4 v6, 0x4

    new-array v6, v6, [Ljava/lang/String;

    const-string v7, "CCSID01142"

    aput-object v7, v6, v1

    const-string v7, "CP01142"

    aput-object v7, v6, v10

    const-string v7, "ebcdic-dk-277+euro"

    aput-object v7, v6, v11

    const-string v7, "ebcdic-no-277+euro"

    aput-object v7, v6, v12

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x3c

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp1143"

    const-string v5, "IBM01143"

    const/4 v6, 0x4

    new-array v6, v6, [Ljava/lang/String;

    const-string v7, "CCSID01143"

    aput-object v7, v6, v1

    const-string v7, "CP01143"

    aput-object v7, v6, v10

    const-string v7, "ebcdic-fi-278+euro"

    aput-object v7, v6, v11

    const-string v7, "ebcdic-se-278+euro"

    aput-object v7, v6, v12

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x3d

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp1144"

    const-string v5, "IBM01144"

    new-array v6, v12, [Ljava/lang/String;

    const-string v7, "CCSID01144"

    aput-object v7, v6, v1

    const-string v7, "CP01144"

    aput-object v7, v6, v10

    const-string v7, "ebcdic-it-280+euro"

    aput-object v7, v6, v11

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x3e

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp1145"

    const-string v5, "IBM01145"

    new-array v6, v12, [Ljava/lang/String;

    const-string v7, "CCSID01145"

    aput-object v7, v6, v1

    const-string v7, "CP01145"

    aput-object v7, v6, v10

    const-string v7, "ebcdic-es-284+euro"

    aput-object v7, v6, v11

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x3f

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp1146"

    const-string v5, "IBM01146"

    new-array v6, v12, [Ljava/lang/String;

    const-string v7, "CCSID01146"

    aput-object v7, v6, v1

    const-string v7, "CP01146"

    aput-object v7, v6, v10

    const-string v7, "ebcdic-gb-285+euro"

    aput-object v7, v6, v11

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x40

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp1147"

    const-string v5, "IBM01147"

    new-array v6, v12, [Ljava/lang/String;

    const-string v7, "CCSID01147"

    aput-object v7, v6, v1

    const-string v7, "CP01147"

    aput-object v7, v6, v10

    const-string v7, "ebcdic-fr-297+euro"

    aput-object v7, v6, v11

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x41

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp1148"

    const-string v5, "IBM01148"

    new-array v6, v12, [Ljava/lang/String;

    const-string v7, "CCSID01148"

    aput-object v7, v6, v1

    const-string v7, "CP01148"

    aput-object v7, v6, v10

    const-string v7, "ebcdic-international-500+euro"

    aput-object v7, v6, v11

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x42

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp1149"

    const-string v5, "IBM01149"

    new-array v6, v12, [Ljava/lang/String;

    const-string v7, "CCSID01149"

    aput-object v7, v6, v1

    const-string v7, "CP01149"

    aput-object v7, v6, v10

    const-string v7, "ebcdic-is-871+euro"

    aput-object v7, v6, v11

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x43

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp1250"

    const-string v5, "windows-1250"

    new-array v6, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x44

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp1251"

    const-string v5, "windows-1251"

    new-array v6, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x45

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp1252"

    const-string v5, "windows-1252"

    new-array v6, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x46

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp1253"

    const-string v5, "windows-1253"

    new-array v6, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x47

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp1254"

    const-string v5, "windows-1254"

    new-array v6, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x48

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp1255"

    const-string v5, "windows-1255"

    new-array v6, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x49

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp1256"

    const-string v5, "windows-1256"

    new-array v6, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x4a

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp1257"

    const-string v5, "windows-1257"

    new-array v6, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x4b

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp1258"

    const-string v5, "windows-1258"

    new-array v6, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x4c

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "ISO2022CN"

    const-string v5, "ISO-2022-CN"

    new-array v6, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x4d

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "ISO2022JP"

    const-string v5, "ISO-2022-JP"

    const/4 v6, 0x4

    new-array v6, v6, [Ljava/lang/String;

    const-string v7, "csISO2022JP"

    aput-object v7, v6, v1

    const-string v7, "JIS"

    aput-object v7, v6, v10

    const-string v7, "jis_encoding"

    aput-object v7, v6, v11

    const-string v7, "csjisencoding"

    aput-object v7, v6, v12

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x4e

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "ISO2022KR"

    const-string v5, "ISO-2022-KR"

    new-array v6, v10, [Ljava/lang/String;

    const-string v7, "csISO2022KR"

    aput-object v7, v6, v1

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x4f

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "JIS_X0201"

    const-string v5, "JIS_X0201"

    new-array v6, v12, [Ljava/lang/String;

    const-string v7, "X0201"

    aput-object v7, v6, v1

    const-string v7, "JIS0201"

    aput-object v7, v6, v10

    const-string v7, "csHalfWidthKatakana"

    aput-object v7, v6, v11

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x50

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "JIS_X0212-1990"

    const-string v5, "JIS_X0212-1990"

    const/4 v6, 0x4

    new-array v6, v6, [Ljava/lang/String;

    const-string v7, "iso-ir-159"

    aput-object v7, v6, v1

    const-string v7, "x0212"

    aput-object v7, v6, v10

    const-string v7, "JIS0212"

    aput-object v7, v6, v11

    const-string v7, "csISO159JISX02121990"

    aput-object v7, v6, v12

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x51

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "JIS_C6626-1983"

    const-string v5, "JIS_C6626-1983"

    const/4 v6, 0x6

    new-array v6, v6, [Ljava/lang/String;

    const-string v7, "x-JIS0208"

    aput-object v7, v6, v1

    const-string v7, "JIS0208"

    aput-object v7, v6, v10

    const-string v7, "csISO87JISX0208"

    aput-object v7, v6, v11

    const-string v7, "x0208"

    aput-object v7, v6, v12

    const/4 v7, 0x4

    const-string v8, "JIS_X0208-1983"

    aput-object v8, v6, v7

    const/4 v7, 0x5

    const-string v8, "iso-ir-87"

    aput-object v8, v6, v7

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x52

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "SJIS"

    const-string v5, "Shift_JIS"

    const/4 v6, 0x5

    new-array v6, v6, [Ljava/lang/String;

    const-string v7, "MS_Kanji"

    aput-object v7, v6, v1

    const-string v7, "csShiftJIS"

    aput-object v7, v6, v10

    const-string v7, "shift-jis"

    aput-object v7, v6, v11

    const-string v7, "x-sjis"

    aput-object v7, v6, v12

    const/4 v7, 0x4

    const-string v8, "pck"

    aput-object v8, v6, v7

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x53

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "TIS620"

    const-string v5, "TIS-620"

    new-array v6, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x54

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "MS932"

    const-string v5, "Windows-31J"

    new-array v6, v12, [Ljava/lang/String;

    const-string v7, "windows-932"

    aput-object v7, v6, v1

    const-string v7, "csWindows31J"

    aput-object v7, v6, v10

    const-string v7, "x-ms-cp932"

    aput-object v7, v6, v11

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x55

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "EUC_TW"

    const-string v5, "EUC-TW"

    new-array v6, v12, [Ljava/lang/String;

    const-string v7, "x-EUC-TW"

    aput-object v7, v6, v1

    const-string v7, "cns11643"

    aput-object v7, v6, v10

    const-string v7, "euctw"

    aput-object v7, v6, v11

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x56

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "x-Johab"

    const-string v5, "johab"

    const/4 v6, 0x5

    new-array v6, v6, [Ljava/lang/String;

    const-string v7, "johab"

    aput-object v7, v6, v1

    const-string v7, "cp1361"

    aput-object v7, v6, v10

    const-string v7, "ms1361"

    aput-object v7, v6, v11

    const-string v7, "ksc5601-1992"

    aput-object v7, v6, v12

    const/4 v7, 0x4

    const-string v8, "ksc5601_1992"

    aput-object v8, v6, v7

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x57

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "MS950_HKSCS"

    const-string v5, ""

    new-array v6, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x58

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "MS874"

    const-string v5, "windows-874"

    new-array v6, v10, [Ljava/lang/String;

    const-string v7, "cp874"

    aput-object v7, v6, v1

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x59

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "MS949"

    const-string v5, "windows-949"

    new-array v6, v12, [Ljava/lang/String;

    const-string v7, "windows949"

    aput-object v7, v6, v1

    const-string v7, "ms_949"

    aput-object v7, v6, v10

    const-string v7, "x-windows-949"

    aput-object v7, v6, v11

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x5a

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "MS950"

    const-string v5, "windows-950"

    new-array v6, v10, [Ljava/lang/String;

    const-string v7, "x-windows-950"

    aput-object v7, v6, v1

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x5b

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp737"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x5c

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp856"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x5d

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp875"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x5e

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp921"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x5f

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp922"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x60

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp930"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x61

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp933"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x62

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp935"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x63

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp937"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x64

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp939"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x65

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp942"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x66

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp942C"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x67

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp943"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x68

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp943C"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x69

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp948"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x6a

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp949"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x6b

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp949C"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x6c

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp950"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x6d

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp964"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x6e

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp970"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x6f

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp1006"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x70

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp1025"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x71

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp1046"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x72

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp1097"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x73

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp1098"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x74

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp1112"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x75

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp1122"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x76

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp1123"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x77

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp1124"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x78

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp1381"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x79

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp1383"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x7a

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Cp33722"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x7b

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "Big5_Solaris"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x7c

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "EUC_JP_LINUX"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x7d

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "EUC_JP_Solaris"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x7e

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "ISCII91"

    new-array v5, v11, [Ljava/lang/String;

    const-string v6, "x-ISCII91"

    aput-object v6, v5, v1

    const-string v6, "iscii"

    aput-object v6, v5, v10

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x7f

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "ISO2022_CN_CNS"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x80

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "ISO2022_CN_GB"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x81

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "x-iso-8859-11"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x82

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "JISAutoDetect"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x83

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "MacArabic"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x84

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "MacCentralEurope"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x85

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "MacCroatian"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x86

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "MacCyrillic"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x87

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "MacDingbat"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x88

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "MacGreek"

    const-string v5, "MacGreek"

    new-array v6, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x89

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "MacHebrew"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x8a

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "MacIceland"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x8b

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "MacRoman"

    const-string v5, "MacRoman"

    new-array v6, v12, [Ljava/lang/String;

    const-string v7, "Macintosh"

    aput-object v7, v6, v1

    const-string v7, "MAC"

    aput-object v7, v6, v10

    const-string v7, "csMacintosh"

    aput-object v7, v6, v11

    invoke-direct {v3, v4, v5, v6, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x8c

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "MacRomania"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x8d

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "MacSymbol"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x8e

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "MacThai"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x8f

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "MacTurkish"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x90

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "MacUkraine"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x91

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "UnicodeBig"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    const/16 v2, 0x92

    new-instance v3, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    const-string v4, "UnicodeLittle"

    new-array v5, v1, [Ljava/lang/String;

    invoke-direct {v3, v4, v9, v5, v9}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/james/mime4j/util/CharsetUtil$1;)V

    aput-object v3, v0, v2

    sput-object v0, Lorg/apache/james/mime4j/util/CharsetUtil;->JAVA_CHARSETS:[Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    .line 1005
    sput-object v9, Lorg/apache/james/mime4j/util/CharsetUtil;->decodingSupported:Ljava/util/TreeSet;

    .line 1011
    sput-object v9, Lorg/apache/james/mime4j/util/CharsetUtil;->encodingSupported:Ljava/util/TreeSet;

    .line 1017
    sput-object v9, Lorg/apache/james/mime4j/util/CharsetUtil;->charsetMap:Ljava/util/HashMap;

    .line 1020
    new-instance v0, Ljava/util/TreeSet;

    invoke-direct {v0}, Ljava/util/TreeSet;-><init>()V

    sput-object v0, Lorg/apache/james/mime4j/util/CharsetUtil;->decodingSupported:Ljava/util/TreeSet;

    .line 1021
    new-instance v0, Ljava/util/TreeSet;

    invoke-direct {v0}, Ljava/util/TreeSet;-><init>()V

    sput-object v0, Lorg/apache/james/mime4j/util/CharsetUtil;->encodingSupported:Ljava/util/TreeSet;

    .line 1022
    const/4 v0, 0x5

    new-array v2, v0, [B

    fill-array-data v2, :array_0

    move v0, v1

    .line 1023
    :goto_0
    sget-object v3, Lorg/apache/james/mime4j/util/CharsetUtil;->JAVA_CHARSETS:[Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    array-length v3, v3

    if-ge v0, v3, :cond_0

    .line 1025
    :try_start_0
    new-instance v3, Ljava/lang/String;

    sget-object v4, Lorg/apache/james/mime4j/util/CharsetUtil;->JAVA_CHARSETS:[Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    aget-object v4, v4, v0

    # getter for: Lorg/apache/james/mime4j/util/CharsetUtil$Charset;->canonical:Ljava/lang/String;
    invoke-static {v4}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;->access$100(Lorg/apache/james/mime4j/util/CharsetUtil$Charset;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v2, v4}, Ljava/lang/String;-><init>([BLjava/lang/String;)V

    .line 1026
    sget-object v3, Lorg/apache/james/mime4j/util/CharsetUtil;->decodingSupported:Ljava/util/TreeSet;

    sget-object v4, Lorg/apache/james/mime4j/util/CharsetUtil;->JAVA_CHARSETS:[Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    aget-object v4, v4, v0

    # getter for: Lorg/apache/james/mime4j/util/CharsetUtil$Charset;->canonical:Ljava/lang/String;
    invoke-static {v4}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;->access$100(Lorg/apache/james/mime4j/util/CharsetUtil$Charset;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/util/TreeSet;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/UnsupportedOperationException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_2

    .line 1031
    :goto_1
    :try_start_1
    const-string v3, "dummy"

    sget-object v4, Lorg/apache/james/mime4j/util/CharsetUtil;->JAVA_CHARSETS:[Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    aget-object v4, v4, v0

    # getter for: Lorg/apache/james/mime4j/util/CharsetUtil$Charset;->canonical:Ljava/lang/String;
    invoke-static {v4}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;->access$100(Lorg/apache/james/mime4j/util/CharsetUtil$Charset;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    .line 1032
    sget-object v3, Lorg/apache/james/mime4j/util/CharsetUtil;->encodingSupported:Ljava/util/TreeSet;

    sget-object v4, Lorg/apache/james/mime4j/util/CharsetUtil;->JAVA_CHARSETS:[Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    aget-object v4, v4, v0

    # getter for: Lorg/apache/james/mime4j/util/CharsetUtil$Charset;->canonical:Ljava/lang/String;
    invoke-static {v4}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;->access$100(Lorg/apache/james/mime4j/util/CharsetUtil$Charset;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/util/TreeSet;->add(Ljava/lang/Object;)Z
    :try_end_1
    .catch Ljava/lang/UnsupportedOperationException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_1 .. :try_end_1} :catch_0

    .line 1023
    :goto_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 1038
    :cond_0
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lorg/apache/james/mime4j/util/CharsetUtil;->charsetMap:Ljava/util/HashMap;

    move v0, v1

    .line 1039
    :goto_3
    sget-object v2, Lorg/apache/james/mime4j/util/CharsetUtil;->JAVA_CHARSETS:[Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    array-length v2, v2

    if-ge v0, v2, :cond_3

    .line 1040
    sget-object v2, Lorg/apache/james/mime4j/util/CharsetUtil;->JAVA_CHARSETS:[Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    aget-object v3, v2, v0

    .line 1041
    sget-object v2, Lorg/apache/james/mime4j/util/CharsetUtil;->charsetMap:Ljava/util/HashMap;

    # getter for: Lorg/apache/james/mime4j/util/CharsetUtil$Charset;->canonical:Ljava/lang/String;
    invoke-static {v3}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;->access$100(Lorg/apache/james/mime4j/util/CharsetUtil$Charset;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1042
    # getter for: Lorg/apache/james/mime4j/util/CharsetUtil$Charset;->mime:Ljava/lang/String;
    invoke-static {v3}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;->access$200(Lorg/apache/james/mime4j/util/CharsetUtil$Charset;)Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 1043
    sget-object v2, Lorg/apache/james/mime4j/util/CharsetUtil;->charsetMap:Ljava/util/HashMap;

    # getter for: Lorg/apache/james/mime4j/util/CharsetUtil$Charset;->mime:Ljava/lang/String;
    invoke-static {v3}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;->access$200(Lorg/apache/james/mime4j/util/CharsetUtil$Charset;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1045
    :cond_1
    # getter for: Lorg/apache/james/mime4j/util/CharsetUtil$Charset;->aliases:[Ljava/lang/String;
    invoke-static {v3}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;->access$300(Lorg/apache/james/mime4j/util/CharsetUtil$Charset;)[Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_2

    move v2, v1

    .line 1046
    :goto_4
    # getter for: Lorg/apache/james/mime4j/util/CharsetUtil$Charset;->aliases:[Ljava/lang/String;
    invoke-static {v3}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;->access$300(Lorg/apache/james/mime4j/util/CharsetUtil$Charset;)[Ljava/lang/String;

    move-result-object v4

    array-length v4, v4

    if-ge v2, v4, :cond_2

    .line 1047
    sget-object v4, Lorg/apache/james/mime4j/util/CharsetUtil;->charsetMap:Ljava/util/HashMap;

    # getter for: Lorg/apache/james/mime4j/util/CharsetUtil$Charset;->aliases:[Ljava/lang/String;
    invoke-static {v3}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;->access$300(Lorg/apache/james/mime4j/util/CharsetUtil$Charset;)[Ljava/lang/String;

    move-result-object v5

    aget-object v5, v5, v2

    invoke-virtual {v5}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1046
    add-int/lit8 v2, v2, 0x1

    goto :goto_4

    .line 1039
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_3

    .line 1052
    :cond_3
    sget-object v0, Lorg/apache/james/mime4j/util/CharsetUtil;->log:Lorg/apache/james/mime4j/Log;

    invoke-virtual {v0}, Lorg/apache/james/mime4j/Log;->isDebugEnabled()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 1053
    sget-object v0, Lorg/apache/james/mime4j/util/CharsetUtil;->log:Lorg/apache/james/mime4j/Log;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Character sets which support decoding: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Lorg/apache/james/mime4j/util/CharsetUtil;->decodingSupported:Ljava/util/TreeSet;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lorg/apache/james/mime4j/Log;->debug(Ljava/lang/Object;)V

    .line 1055
    sget-object v0, Lorg/apache/james/mime4j/util/CharsetUtil;->log:Lorg/apache/james/mime4j/Log;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Character sets which support encoding: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Lorg/apache/james/mime4j/util/CharsetUtil;->encodingSupported:Ljava/util/TreeSet;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lorg/apache/james/mime4j/Log;->debug(Ljava/lang/Object;)V

    .line 1079
    :cond_4
    const-string v0, "US-ASCII"

    invoke-static {v0}, Ljava/nio/charset/Charset;->forName(Ljava/lang/String;)Ljava/nio/charset/Charset;

    move-result-object v0

    sput-object v0, Lorg/apache/james/mime4j/util/CharsetUtil;->US_ASCII:Ljava/nio/charset/Charset;

    .line 1082
    const-string v0, "ISO-8859-1"

    invoke-static {v0}, Ljava/nio/charset/Charset;->forName(Ljava/lang/String;)Ljava/nio/charset/Charset;

    move-result-object v0

    sput-object v0, Lorg/apache/james/mime4j/util/CharsetUtil;->ISO_8859_1:Ljava/nio/charset/Charset;

    .line 1085
    const-string v0, "UTF-8"

    invoke-static {v0}, Ljava/nio/charset/Charset;->forName(Ljava/lang/String;)Ljava/nio/charset/Charset;

    move-result-object v0

    sput-object v0, Lorg/apache/james/mime4j/util/CharsetUtil;->UTF_8:Ljava/nio/charset/Charset;

    return-void

    .line 1034
    :catch_0
    move-exception v3

    goto/16 :goto_2

    .line 1033
    :catch_1
    move-exception v3

    goto/16 :goto_2

    .line 1028
    :catch_2
    move-exception v3

    goto/16 :goto_1

    .line 1027
    :catch_3
    move-exception v3

    goto/16 :goto_1

    .line 1022
    nop

    :array_0
    .array-data 1
        0x64t
        0x75t
        0x6dt
        0x6dt
        0x79t
    .end array-data
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 793
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 796
    return-void
.end method

.method public static isDecodingSupported(Ljava/lang/String;)Z
    .locals 2
    .param p0, "charsetName"    # Ljava/lang/String;

    .prologue
    .line 1154
    sget-object v0, Lorg/apache/james/mime4j/util/CharsetUtil;->decodingSupported:Ljava/util/TreeSet;

    invoke-virtual {p0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/TreeSet;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public static isWhitespace(C)Z
    .locals 1
    .param p0, "ch"    # C

    .prologue
    .line 1100
    const/16 v0, 0x20

    if-eq p0, v0, :cond_0

    const/16 v0, 0x9

    if-eq p0, v0, :cond_0

    const/16 v0, 0xd

    if-eq p0, v0, :cond_0

    const/16 v0, 0xa

    if-ne p0, v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isWhitespace(Ljava/lang/String;)Z
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 1115
    if-nez p0, :cond_0

    .line 1116
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "String may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1118
    :cond_0
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    move v1, v0

    .line 1119
    :goto_0
    if-ge v1, v2, :cond_2

    .line 1120
    invoke-virtual {p0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v3

    invoke-static {v3}, Lorg/apache/james/mime4j/util/CharsetUtil;->isWhitespace(C)Z

    move-result v3

    if-nez v3, :cond_1

    .line 1124
    :goto_1
    return v0

    .line 1119
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 1124
    :cond_2
    const/4 v0, 0x1

    goto :goto_1
.end method

.method public static toJavaCharset(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "charsetName"    # Ljava/lang/String;

    .prologue
    .line 1184
    sget-object v1, Lorg/apache/james/mime4j/util/CharsetUtil;->charsetMap:Ljava/util/HashMap;

    invoke-virtual {p0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;

    .line 1185
    .local v0, "c":Lorg/apache/james/mime4j/util/CharsetUtil$Charset;
    if-eqz v0, :cond_0

    .line 1186
    # getter for: Lorg/apache/james/mime4j/util/CharsetUtil$Charset;->canonical:Ljava/lang/String;
    invoke-static {v0}, Lorg/apache/james/mime4j/util/CharsetUtil$Charset;->access$100(Lorg/apache/james/mime4j/util/CharsetUtil$Charset;)Ljava/lang/String;

    move-result-object v1

    .line 1188
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method
