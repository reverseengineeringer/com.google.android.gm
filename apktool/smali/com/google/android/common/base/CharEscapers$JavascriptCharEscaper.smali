.class Lcom/google/android/common/base/CharEscapers$JavascriptCharEscaper;
.super Lcom/google/android/common/base/CharEscapers$FastCharEscaper;
.source "CharEscapers.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/common/base/CharEscapers;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "JavascriptCharEscaper"
.end annotation


# direct methods
.method public constructor <init>([[C)V
    .locals 2
    .param p1, "replacements"    # [[C

    .prologue
    .line 983
    const/16 v0, 0x20

    const/16 v1, 0x7e

    invoke-direct {p0, p1, v0, v1}, Lcom/google/android/common/base/CharEscapers$FastCharEscaper;-><init>([[CCC)V

    .line 984
    return-void
.end method


# virtual methods
.method protected escape(C)[C
    .locals 9
    .param p1, "c"    # C

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 988
    iget v1, p0, Lcom/google/android/common/base/CharEscapers$FastCharEscaper;->replacementLength:I

    if-ge p1, v1, :cond_0

    .line 989
    iget-object v1, p0, Lcom/google/android/common/base/CharEscapers$FastCharEscaper;->replacements:[[C

    aget-object v0, v1, p1

    .line 990
    .local v0, "r":[C
    if-eqz v0, :cond_0

    .line 1022
    .end local v0    # "r":[C
    :goto_0
    return-object v0

    .line 996
    :cond_0
    iget-char v1, p0, Lcom/google/android/common/base/CharEscapers$FastCharEscaper;->safeMin:C

    if-gt v1, p1, :cond_1

    iget-char v1, p0, Lcom/google/android/common/base/CharEscapers$FastCharEscaper;->safeMax:C

    if-gt p1, v1, :cond_1

    .line 997
    const/4 v0, 0x0

    goto :goto_0

    .line 1001
    :cond_1
    const/16 v1, 0x100

    if-ge p1, v1, :cond_2

    .line 1002
    new-array v0, v8, [C

    .line 1003
    .restart local v0    # "r":[C
    # getter for: Lcom/google/android/common/base/CharEscapers;->HEX_DIGITS:[C
    invoke-static {}, Lcom/google/android/common/base/CharEscapers;->access$100()[C

    move-result-object v1

    and-int/lit8 v2, p1, 0xf

    aget-char v1, v1, v2

    aput-char v1, v0, v7

    .line 1004
    ushr-int/lit8 v1, p1, 0x4

    int-to-char p1, v1

    .line 1005
    # getter for: Lcom/google/android/common/base/CharEscapers;->HEX_DIGITS:[C
    invoke-static {}, Lcom/google/android/common/base/CharEscapers;->access$100()[C

    move-result-object v1

    and-int/lit8 v2, p1, 0xf

    aget-char v1, v1, v2

    aput-char v1, v0, v6

    .line 1006
    const/16 v1, 0x78

    aput-char v1, v0, v5

    .line 1007
    const/16 v1, 0x5c

    aput-char v1, v0, v4

    goto :goto_0

    .line 1012
    .end local v0    # "r":[C
    :cond_2
    const/4 v1, 0x6

    new-array v0, v1, [C

    .line 1013
    .restart local v0    # "r":[C
    const/4 v1, 0x5

    # getter for: Lcom/google/android/common/base/CharEscapers;->HEX_DIGITS:[C
    invoke-static {}, Lcom/google/android/common/base/CharEscapers;->access$100()[C

    move-result-object v2

    and-int/lit8 v3, p1, 0xf

    aget-char v2, v2, v3

    aput-char v2, v0, v1

    .line 1014
    ushr-int/lit8 v1, p1, 0x4

    int-to-char p1, v1

    .line 1015
    # getter for: Lcom/google/android/common/base/CharEscapers;->HEX_DIGITS:[C
    invoke-static {}, Lcom/google/android/common/base/CharEscapers;->access$100()[C

    move-result-object v1

    and-int/lit8 v2, p1, 0xf

    aget-char v1, v1, v2

    aput-char v1, v0, v8

    .line 1016
    ushr-int/lit8 v1, p1, 0x4

    int-to-char p1, v1

    .line 1017
    # getter for: Lcom/google/android/common/base/CharEscapers;->HEX_DIGITS:[C
    invoke-static {}, Lcom/google/android/common/base/CharEscapers;->access$100()[C

    move-result-object v1

    and-int/lit8 v2, p1, 0xf

    aget-char v1, v1, v2

    aput-char v1, v0, v7

    .line 1018
    ushr-int/lit8 v1, p1, 0x4

    int-to-char p1, v1

    .line 1019
    # getter for: Lcom/google/android/common/base/CharEscapers;->HEX_DIGITS:[C
    invoke-static {}, Lcom/google/android/common/base/CharEscapers;->access$100()[C

    move-result-object v1

    and-int/lit8 v2, p1, 0xf

    aget-char v1, v1, v2

    aput-char v1, v0, v6

    .line 1020
    const/16 v1, 0x75

    aput-char v1, v0, v5

    .line 1021
    const/16 v1, 0x5c

    aput-char v1, v0, v4

    goto :goto_0
.end method
