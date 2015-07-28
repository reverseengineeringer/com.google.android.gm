.class Lcom/google/android/common/base/CharEscapers$JavaCharEscaper;
.super Lcom/google/android/common/base/CharEscapers$FastCharEscaper;
.source "CharEscapers.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/common/base/CharEscapers;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "JavaCharEscaper"
.end annotation


# direct methods
.method public constructor <init>([[C)V
    .locals 2
    .param p1, "replacements"    # [[C

    .prologue
    .line 929
    const/16 v0, 0x20

    const/16 v1, 0x7e

    invoke-direct {p0, p1, v0, v1}, Lcom/google/android/common/base/CharEscapers$FastCharEscaper;-><init>([[CCC)V

    .line 930
    return-void
.end method


# virtual methods
.method protected escape(C)[C
    .locals 7
    .param p1, "c"    # C

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 934
    iget v1, p0, Lcom/google/android/common/base/CharEscapers$FastCharEscaper;->replacementLength:I

    if-ge p1, v1, :cond_0

    .line 935
    iget-object v1, p0, Lcom/google/android/common/base/CharEscapers$FastCharEscaper;->replacements:[[C

    aget-object v0, v1, p1

    .line 936
    .local v0, "r":[C
    if-eqz v0, :cond_0

    .line 971
    .end local v0    # "r":[C
    :goto_0
    return-object v0

    .line 942
    :cond_0
    iget-char v1, p0, Lcom/google/android/common/base/CharEscapers$FastCharEscaper;->safeMin:C

    if-gt v1, p1, :cond_1

    iget-char v1, p0, Lcom/google/android/common/base/CharEscapers$FastCharEscaper;->safeMax:C

    if-gt p1, v1, :cond_1

    .line 943
    const/4 v0, 0x0

    goto :goto_0

    .line 946
    :cond_1
    const/16 v1, 0xff

    if-gt p1, v1, :cond_2

    .line 949
    new-array v0, v6, [C

    .line 950
    .restart local v0    # "r":[C
    const/16 v1, 0x5c

    aput-char v1, v0, v2

    .line 951
    # getter for: Lcom/google/android/common/base/CharEscapers;->HEX_DIGITS:[C
    invoke-static {}, Lcom/google/android/common/base/CharEscapers;->access$100()[C

    move-result-object v1

    and-int/lit8 v2, p1, 0x7

    aget-char v1, v1, v2

    aput-char v1, v0, v5

    .line 952
    ushr-int/lit8 v1, p1, 0x3

    int-to-char p1, v1

    .line 953
    # getter for: Lcom/google/android/common/base/CharEscapers;->HEX_DIGITS:[C
    invoke-static {}, Lcom/google/android/common/base/CharEscapers;->access$100()[C

    move-result-object v1

    and-int/lit8 v2, p1, 0x7

    aget-char v1, v1, v2

    aput-char v1, v0, v4

    .line 954
    ushr-int/lit8 v1, p1, 0x3

    int-to-char p1, v1

    .line 955
    # getter for: Lcom/google/android/common/base/CharEscapers;->HEX_DIGITS:[C
    invoke-static {}, Lcom/google/android/common/base/CharEscapers;->access$100()[C

    move-result-object v1

    and-int/lit8 v2, p1, 0x7

    aget-char v1, v1, v2

    aput-char v1, v0, v3

    goto :goto_0

    .line 961
    .end local v0    # "r":[C
    :cond_2
    const/4 v1, 0x6

    new-array v0, v1, [C

    .line 962
    .restart local v0    # "r":[C
    const/16 v1, 0x5c

    aput-char v1, v0, v2

    .line 963
    const/16 v1, 0x75

    aput-char v1, v0, v3

    .line 964
    const/4 v1, 0x5

    # getter for: Lcom/google/android/common/base/CharEscapers;->HEX_DIGITS:[C
    invoke-static {}, Lcom/google/android/common/base/CharEscapers;->access$100()[C

    move-result-object v2

    and-int/lit8 v3, p1, 0xf

    aget-char v2, v2, v3

    aput-char v2, v0, v1

    .line 965
    ushr-int/lit8 v1, p1, 0x4

    int-to-char p1, v1

    .line 966
    # getter for: Lcom/google/android/common/base/CharEscapers;->HEX_DIGITS:[C
    invoke-static {}, Lcom/google/android/common/base/CharEscapers;->access$100()[C

    move-result-object v1

    and-int/lit8 v2, p1, 0xf

    aget-char v1, v1, v2

    aput-char v1, v0, v6

    .line 967
    ushr-int/lit8 v1, p1, 0x4

    int-to-char p1, v1

    .line 968
    # getter for: Lcom/google/android/common/base/CharEscapers;->HEX_DIGITS:[C
    invoke-static {}, Lcom/google/android/common/base/CharEscapers;->access$100()[C

    move-result-object v1

    and-int/lit8 v2, p1, 0xf

    aget-char v1, v1, v2

    aput-char v1, v0, v5

    .line 969
    ushr-int/lit8 v1, p1, 0x4

    int-to-char p1, v1

    .line 970
    # getter for: Lcom/google/android/common/base/CharEscapers;->HEX_DIGITS:[C
    invoke-static {}, Lcom/google/android/common/base/CharEscapers;->access$100()[C

    move-result-object v1

    and-int/lit8 v2, p1, 0xf

    aget-char v1, v1, v2

    aput-char v1, v0, v4

    goto :goto_0
.end method
